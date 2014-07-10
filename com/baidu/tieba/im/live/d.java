package com.baidu.tieba.im.live;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.RemoteException;
import android.telephony.TelephonyManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.coreExtra.live.LiveErrorMessage;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeDefinition;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeMessage;
import com.baidu.tieba.im.live.livelist.HotLiveListActivity;
import com.baidu.tieba.im.live.service.ILiveGroupManagerService;
import com.baidu.tieba.im.live.service.IRemoteCallback;
import com.baidu.tieba.im.live.service.LiveGroupManagerService;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class d {
    public static d a = new d();
    private String c;
    private String b = null;
    private boolean d = false;
    private int e = 0;
    private int f = 0;
    private boolean g = false;
    private int h = -1;
    private String i = null;
    private String j = null;
    private int k = 0;
    private n l = null;
    private CustomMessageListener m = new e(this, 2001162);
    private CustomMessageListener n = new f(this, 2001164);
    private CustomMessageListener o = new g(this, 2001121);
    private final CustomMessageListener p = new h(this, 2001166);
    private final CustomMessageListener q = new i(this, 2001171);
    private ILiveGroupManagerService r = null;
    private IRemoteCallback s = new j(this);
    private Handler t = new k(this);
    private Runnable u = new l(this);
    private ServiceConnection v = new m(this);

    public void a() {
        if (a != null && this.d) {
            s();
            this.c = TbadkApplication.getCurrentAccount();
            String currentBduss = TbadkApplication.getCurrentBduss();
            if (currentBduss != null) {
                AccessTokenManager.getInstance().asyncLoadAccessToken(currentBduss);
            } else {
                this.b = null;
            }
        }
    }

    private d() {
    }

    public static d b() {
        return a;
    }

    public void c() {
        if (!this.d) {
            MessageManager.getInstance().registerListener(this.m);
            MessageManager.getInstance().registerListener(this.n);
            MessageManager.getInstance().registerListener(this.o);
            MessageManager.getInstance().registerListener(this.p);
            MessageManager.getInstance().registerListener(this.q);
            AccessTokenManager.getInstance().asyncLoadAccessToken(TbadkApplication.getCurrentBduss());
            this.c = TbadkApplication.getCurrentAccount();
            v();
            f();
            this.d = true;
        }
    }

    public void d() {
        if (this.i == null) {
            int g = g();
            if (g == 3) {
                a(i());
            } else if (g == 19) {
                String i = i();
                String j = j();
                if (LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(this.i)) {
                    int o = o();
                    k();
                    this.k = o;
                } else {
                    d(i);
                }
                this.i = i;
                this.j = j;
            }
        }
    }

    public void e() {
        if (this.i != null && this.j != null) {
            if (LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(this.i)) {
                a(this.j, this.k);
            } else {
                a(this.i, this.j);
            }
        }
        this.i = null;
        this.j = null;
        this.k = 0;
    }

    public void f() {
        try {
            ((TelephonyManager) TbadkApplication.m252getInst().getApp().getSystemService("phone")).listen(new o(this, null), 32);
        } catch (SecurityException e) {
        }
    }

    public void a(n nVar) {
        this.l = nVar;
    }

    public int g() {
        try {
            if (this.r != null) {
                return this.r.getCurrentStatus();
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return -1;
    }

    public int h() {
        try {
            if (this.r != null) {
                int currentStatus = this.r.getCurrentStatus();
                this.r.requestStatusRebroadcast();
                return currentStatus;
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return -1;
    }

    public String i() {
        try {
            if (this.r != null) {
                return this.r.getCurrentGroupId();
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return null;
    }

    public String j() {
        try {
            if (this.r != null) {
                return this.r.getCurrentUrl();
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return null;
    }

    public void a(String str) {
        try {
            if (this.r != null) {
                this.r.pausePublish(str);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void b(String str) {
        try {
            if (this.r != null) {
                this.r.startRecordInPublish(str);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void c(String str) {
        try {
            if (this.r != null) {
                this.r.stopRecordInPublish(str);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void a(String str, String str2) {
        try {
            if (this.r != null) {
                this.r.startPlay(str, str2, 0);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void a(String str, int i) {
        try {
            if (this.r != null) {
                this.r.startPlay(LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY, str, i);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void d(String str) {
        this.i = null;
        this.j = null;
        try {
            if (this.r != null) {
                this.r.stopPlay(str, false);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void k() {
        this.i = null;
        this.j = null;
        this.k = 0;
        try {
            if (this.r != null) {
                this.r.stopPlay(LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY, false);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void l() {
        try {
            if (this.r != null) {
                this.r.pausePlay(LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void m() {
        try {
            if (this.r != null) {
                this.r.resumePlay(LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void a(int i) {
        try {
            if (this.r != null) {
                this.r.seekPlayRecord(i);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public int n() {
        try {
            if (this.r != null) {
                return this.r.getDurationOfRecord();
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return 0;
    }

    public int o() {
        try {
            if (this.r != null) {
                return this.r.getPositionOfRecord();
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return 0;
    }

    public void p() {
        try {
            if (this.r != null) {
                this.r.retryPlay();
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public int q() {
        try {
            if (this.r != null) {
                return this.r.getRecordStatus();
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return 1;
    }

    public int r() {
        try {
            if (this.r != null) {
                return this.r.whatIsRunning();
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return -1;
    }

    public void s() {
        try {
            if (this.r != null) {
                this.r.stopAnyRunning(false);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void a(String str, String str2, String str3, String str4, boolean z) {
        if (str2 != null && str4 != null) {
            if (this.b == null) {
                UtilHelper.showToast(TbadkApplication.m252getInst().getApp(), y.live_error_accesstoken_null_or_expire);
                AccessTokenManager.getInstance().asyncLoadAccessToken(TbadkApplication.getCurrentBduss());
                TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_TOKEN_EXPIRED, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_TOKEN_EXPIRED), "");
                e(LiveStatusChangeDefinition.ERROR_PROMPT_TOKEN_EXPIRED);
            } else if (this.c == null) {
                UtilHelper.showToast(TbadkApplication.m252getInst().getApp(), y.live_error_user_not_login);
                e(LiveStatusChangeDefinition.ERROR_PROMPT_USER_NULL);
            } else {
                try {
                    if (this.r != null) {
                        this.r.playOrRecord(str, str2, str3, str4, this.b, this.c, z, false);
                    }
                } catch (RemoteException e) {
                    TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
                    e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
                }
            }
        }
    }

    public int t() {
        try {
            if (this.r == null) {
                return 0;
            }
            return this.r.getRecordTime();
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        try {
            if (this.r != null) {
                this.r.setPublisherPaused(z);
            }
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveStatusChangeMessage.LiveStatusData liveStatusData) {
        if (liveStatusData != null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new LiveStatusChangeMessage(liveStatusData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        if (!StringUtils.isNull(str)) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new LiveErrorMessage(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, int i2) {
        PlayProgressChangedMessage playProgressChangedMessage = new PlayProgressChangedMessage(str);
        playProgressChangedMessage.setCurrentPosition(i2);
        playProgressChangedMessage.setDuration(i);
        MessageManager.getInstance().dispatchResponsedMessageToUI(playProgressChangedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        String string = TbadkApplication.m252getInst().getApp().getResources().getString(y.app_name);
        String string2 = TbadkApplication.m252getInst().getApp().getResources().getString(y.live_end_notify);
        Intent intent = new Intent(TbadkApplication.m252getInst().getApp(), HotLiveListActivity.class);
        intent.setFlags(268435456);
        bb.a((Context) TbadkApplication.m252getInst().getApp(), 22, string, string2, string, PendingIntent.getActivity(TbadkApplication.m252getInst().getApp(), y.app_name, intent, 134217728), false);
    }

    private void v() {
        TbadkApplication.m252getInst().getApp().bindService(new Intent(LiveGroupManagerService.ACTION), this.v, 1);
    }
}
