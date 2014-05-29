package com.baidu.tieba.im.live;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.RemoteException;
import android.telephony.TelephonyManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.live.LiveErrorMessage;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeDefinition;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeMessage;
import com.baidu.tieba.im.live.livelist.HotLiveListActivity;
import com.baidu.tieba.im.live.service.ILiveGroupManagerService;
import com.baidu.tieba.im.live.service.IRemoteCallback;
import com.baidu.tieba.im.live.service.LiveGroupManagerService;
import com.baidu.tieba.u;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class b {
    public static b a = new b();
    private String f;
    private final String b = "LiveGroupManager";
    private final int c = 20000;
    private final int d = 3;
    private String e = null;
    private boolean g = false;
    private int h = 0;
    private int i = 0;
    private boolean j = false;
    private String k = null;
    private String l = null;
    private int m = 0;
    private l n = null;
    private CustomMessageListener o = new c(this, MessageTypes.CMD_LIVE_STATUS_REQUEST);
    private CustomMessageListener p = new d(this, MessageTypes.CMD_ACCESS_TOKEN_UPDATED);
    private CustomMessageListener q = new e(this, MessageTypes.CMD_NETWORK_CHANGE);
    private final CustomMessageListener r = new f(this, MessageTypes.CMD_LIVE_CHAT_ROOM_EVENT);
    private final CustomMessageListener s = new g(this, MessageTypes.CMD_EXIT_APP);
    private ILiveGroupManagerService t = null;
    private IRemoteCallback u = new h(this);
    private Handler v = new i(this);
    private Runnable w = new j(this);
    private ServiceConnection x = new k(this);

    public void a() {
        if (a != null) {
            BdLog.d("onAccountChanged, and init flag is " + this.g);
            if (this.g) {
                s();
                this.f = TbadkApplication.getCurrentAccount();
                String currentBduss = TbadkApplication.getCurrentBduss();
                if (currentBduss != null) {
                    AccessTokenManager.getInstance().getAccesssTokenInBackground(currentBduss);
                } else {
                    this.e = null;
                }
            }
        }
    }

    private b() {
    }

    public static b b() {
        return a;
    }

    public void c() {
        if (!this.g) {
            BdLog.addLogPackage("com.baidu.tieba.im.live.LiveGroupManager");
            MessageManager.getInstance().registerListener(this.o);
            MessageManager.getInstance().registerListener(this.p);
            MessageManager.getInstance().registerListener(this.q);
            MessageManager.getInstance().registerListener(this.r);
            MessageManager.getInstance().registerListener(this.s);
            AccessTokenManager.getInstance().getAccesssTokenInBackground(TbadkApplication.getCurrentBduss());
            this.f = TbadkApplication.getCurrentAccount();
            v();
            f();
            this.g = true;
        }
    }

    public void d() {
        if (this.k == null) {
            int g = g();
            BdLog.e("Got incoming/placing call when live status is: " + g);
            if (g == 3) {
                a(i());
            } else if (g == 19) {
                String i = i();
                String j = j();
                if (LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(this.k)) {
                    int o = o();
                    k();
                    this.m = o;
                } else {
                    d(i);
                }
                this.k = i;
                this.l = j;
            }
        }
    }

    public void e() {
        BdLog.e("Got callEnd when live status is: " + g());
        if (this.k != null && this.l != null) {
            if (LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(this.k)) {
                a(this.l, this.m);
            } else {
                a(this.k, this.l);
            }
        }
        this.k = null;
        this.l = null;
        this.m = 0;
    }

    public void f() {
        ((TelephonyManager) TbadkApplication.m252getInst().getApp().getSystemService("phone")).listen(new m(this, null), 32);
    }

    public void a(l lVar) {
        this.n = lVar;
    }

    public int g() {
        try {
            if (this.t != null) {
                return this.t.getCurrentStatus();
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "getCurrentStatus", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return -1;
    }

    public int h() {
        try {
            if (this.t != null) {
                int currentStatus = this.t.getCurrentStatus();
                this.t.requestStatusRebroadcast();
                return currentStatus;
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "queryCurrentStatus", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return -1;
    }

    public String i() {
        try {
            if (this.t != null) {
                return this.t.getCurrentGroupId();
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "getCurrentGroupId", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return null;
    }

    public String j() {
        try {
            if (this.t != null) {
                return this.t.getCurrentUrl();
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "getCurrentUrl", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return null;
    }

    public void a(String str) {
        try {
            if (this.t != null) {
                this.t.pausePublish(str);
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "pausePublish", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void b(String str) {
        try {
            if (this.t != null) {
                this.t.startRecordInPublish(str);
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "startRecordInPublish", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void c(String str) {
        try {
            if (this.t != null) {
                this.t.stopRecordInPublish(str);
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "stopRecordInPublish", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void a(String str, String str2) {
        try {
            if (this.t != null) {
                this.t.startPlay(str, str2, 0);
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "startPlayLive", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void a(String str, int i) {
        try {
            if (this.t != null) {
                this.t.startPlay(LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY, str, i);
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "startPlayRecord", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void d(String str) {
        BdLog.d("stopPlayLive groupId =" + str + " ; status= " + g());
        this.k = null;
        this.l = null;
        try {
            if (this.t != null) {
                this.t.stopPlay(str, false);
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "stopPlayLive", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void k() {
        BdLog.d("stopPlayRecord status= " + g());
        this.k = null;
        this.l = null;
        this.m = 0;
        try {
            if (this.t != null) {
                this.t.stopPlay(LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY, false);
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "stopPlayRecord", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void l() {
        try {
            if (this.t != null) {
                this.t.pausePlay(LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY);
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "pausePlayRecord", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void m() {
        try {
            if (this.t != null) {
                this.t.resumePlay(LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY);
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "resumePlayRecord", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void a(int i) {
        try {
            if (this.t != null) {
                this.t.seekPlayRecord(i);
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "seekPlayRecord", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public int n() {
        try {
            if (this.t != null) {
                return this.t.getDurationOfRecord();
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "getDurationOfRecord", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return 0;
    }

    public int o() {
        try {
            if (this.t != null) {
                return this.t.getPositionOfRecord();
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "getPositionOfRecord", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return 0;
    }

    public void p() {
        try {
            if (this.t != null) {
                this.t.retryPlay();
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "retryPlay", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public int q() {
        try {
            if (this.t != null) {
                return this.t.getRecordStatus();
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "getRecordStatus", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return 1;
    }

    public int r() {
        try {
            if (this.t != null) {
                return this.t.whatIsRunning();
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "whatIsRunning", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
        return -1;
    }

    public void s() {
        BdLog.d("stopAnyRunning status= " + g());
        try {
            if (this.t != null) {
                this.t.stopAnyRunning(false);
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "stopAnyRunning", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    public void a(String str, String str2, String str3, String str4, boolean z) {
        if (str2 != null && str4 != null) {
            if (this.e == null) {
                UtilHelper.showToast(TbadkApplication.m252getInst().getApp(), y.live_error_accesstoken_null_or_expire);
                AccessTokenManager.getInstance().getAccesssTokenInBackground(TbadkApplication.getCurrentBduss());
                BdLog.e("The access token is null yet.");
                TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_TOKEN_EXPIRED, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_TOKEN_EXPIRED), "");
                e(LiveStatusChangeDefinition.ERROR_PROMPT_TOKEN_EXPIRED);
            } else if (this.f == null) {
                UtilHelper.showToast(TbadkApplication.m252getInst().getApp(), y.live_error_user_not_login);
                BdLog.e("The user ID is null yet.");
                e(LiveStatusChangeDefinition.ERROR_PROMPT_USER_NULL);
            } else {
                BdLog.d("playOrRecord groupId = " + str2 + "; status= " + g() + "; stopCurrent= " + z);
                try {
                    if (this.t != null) {
                        this.t.playOrRecord(str, str2, str3, str4, this.e, this.f, z, false);
                    }
                } catch (RemoteException e) {
                    BdLog.e("LiveGroupManager", "playOrRecord", e);
                    TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
                    e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
                }
            }
        }
    }

    public int t() {
        try {
            if (this.t == null) {
                return 0;
            }
            return this.t.getRecordTime();
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "getRecordTime", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        BdLog.d("setPublisherPaused: " + z);
        try {
            if (this.t != null) {
                this.t.setPublisherPaused(z);
            }
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "setPublisherPaused", e);
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
        try {
            String string = TbadkApplication.m252getInst().getApp().getResources().getString(y.app_name);
            String string2 = TbadkApplication.m252getInst().getApp().getResources().getString(y.live_end_notify);
            Notification notification = new Notification(u.icon, string, System.currentTimeMillis());
            notification.flags = 16;
            Intent intent = new Intent(TbadkApplication.m252getInst().getApp(), HotLiveListActivity.class);
            intent.setFlags(268435456);
            notification.setLatestEventInfo(TbadkApplication.m252getInst().getApp(), string, string2, PendingIntent.getActivity(TbadkApplication.m252getInst().getApp(), y.app_name, intent, 134217728));
            ((NotificationManager) TbadkApplication.m252getInst().getApp().getSystemService("notification")).notify(22, notification);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void v() {
        TbadkApplication.m252getInst().getApp().bindService(new Intent(LiveGroupManagerService.ACTION), this.x, 1);
    }
}
