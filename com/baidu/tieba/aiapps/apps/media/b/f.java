package com.baidu.tieba.aiapps.apps.media.b;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
import com.baidu.tbadk.ala.AlaLivePlayerData;
import com.baidu.tbadk.ala.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.play.o;
/* loaded from: classes4.dex */
public class f implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean UT;
    private SwanAppNAViewContainer akt;
    private String azv;
    private com.baidu.tbadk.ala.d cVn;
    private d.a cVo;
    private o cVq;
    private FrameLayout cVs;
    private Activity cVt;
    private boolean mDetached;
    CustomMessageListener mNetworkChangedListener;
    private a cVm = a.azu();
    private com.baidu.tieba.aiapps.apps.media.b.a.a cVp = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean cVr = false;
    private String cVu = "AiAppLiveErr";

    public f(Context context, String str) {
        this.azv = str;
        this.cVt = (Activity) context;
        if (!TextUtils.isEmpty(this.azv)) {
            com.baidu.swan.apps.media.b.a(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.azv);
        this.akt = new SwanAppNAViewContainer(context);
        this.cVo = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.f.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + " " + i3);
                f.this.cVp.mVideoWidth = i2;
                f.this.cVp.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && f.this.cVp != null) {
                    if (alaLivePlayerData.fpsAvg != f.this.cVp.cVy) {
                        f.this.lT(940);
                    }
                    if (alaLivePlayerData.videoBitrate != f.this.cVp.cVw) {
                        f.this.lT(939);
                    }
                    if (alaLivePlayerData.audioBitrate != f.this.cVp.cVx) {
                        f.this.lT(938);
                    }
                    f.this.cVp.cVz = (int) alaLivePlayerData.bandWidth;
                    f.this.cVp.cVy = (int) alaLivePlayerData.fpsAvg;
                    f.this.cVp.cVx = (int) alaLivePlayerData.audioBitrate;
                    f.this.cVp.cVw = (int) alaLivePlayerData.videoBitrate;
                }
            }
        };
        this.mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.aiapps.apps.media.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    f.this.azA();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        this.cVq = new o(this.cVt);
        this.cVq.start();
        this.cVt.getWindow().addFlags(128);
    }

    public a azw() {
        return this.cVm;
    }

    public void a(a aVar) {
        this.cVm = aVar;
        if (!this.cVm.hidden && this.cVm.azF) {
            start();
        }
    }

    public void start() {
        if (this.cVm != null) {
            if (this.cVm.hidden) {
                BdLog.d("mPlayerId = " + this.azv + "can not start(), hide = " + this.cVm.hidden);
                return;
            }
            BdLog.d(this.azv + " start()");
            if (this.cVn != null) {
                azx();
            }
            azy();
            c(this.cVm);
            c(this.cVm.mSrc, "", "", false);
            azz();
            this.mDetached = false;
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String Eg() {
        return this.azv;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cVm.aBG;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Ei() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bk(boolean z) {
        BdLog.d("onForegroundChanged " + z);
    }

    @Override // com.baidu.swan.apps.media.a
    public void bl(boolean z) {
        BdLog.d("onAppForegroundChanged " + z);
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        BdLog.d("onBackPressed ");
        if (this.cVm != null && this.akt != null && d(this.cVt, this.akt)) {
            if (this.cVt.getRequestedOrientation() != 1) {
                this.cVq.bAy();
            }
            f(this.cVt, 0);
            return true;
        }
        release();
        return false;
    }

    public void azx() {
        if (this.cVn != null) {
            this.cVn.stop();
            this.cVn.destroy();
        }
        this.cVn = null;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.azv + " release()");
        this.cVt.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        com.baidu.swan.apps.media.b.b(this);
        this.cVq.stop();
        if (this.cVn != null) {
            this.cVn.stop();
            this.cVn.destroy();
            this.cVn = null;
        }
    }

    private void azy() {
        fY(this.cVm.cVb);
        lQ(this.cVm.cVd);
        lR(this.cVm.cVe);
        if (TextUtils.equals(this.cVm.cVf, "horizontal")) {
            lS(90);
        } else {
            lS(0);
        }
        if (TextUtils.equals(this.cVm.cVg, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void fY(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.cVn != null) {
            this.cVn.setAudioMute(z);
        }
    }

    public void lQ(int i) {
    }

    public void lR(int i) {
    }

    public void lS(int i) {
    }

    public void setVideoScalingMode(int i) {
        BdLog.d("setVideoScalingMode scalingMode: " + i);
        if (this.cVn != null) {
            this.cVn.setRenderVideoModel(1, i != 2 ? 1 : 2);
            BdLog.d("setVideoScalingMode " + i);
            return;
        }
        BdLog.d("setVideoScalingMode mPlayer = null ");
    }

    private boolean c(String str, String str2, String str3, boolean z) {
        BdLog.d("setDataSource: " + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder("");
        if (!TextUtils.isEmpty(str2)) {
            sb.append("Cookie:");
            sb.append(str2);
            sb.append("\r\n");
        }
        if (z) {
            sb.append("x-hide-urls-from-log:true\r\n");
        }
        sb.toString();
        return true;
    }

    private boolean azz() {
        boolean z;
        int i;
        int i2;
        CustomResponsedMessage runTask;
        if (this.cVn == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.cVt)) != null && runTask.getData() != null) {
            this.cVn = (com.baidu.tbadk.ala.d) runTask.getData();
            this.cVn.a(this.cVo);
        }
        if (this.cVn == null) {
            return false;
        }
        if (this.cVn.a(1, this.cVm.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
            this.cVr = true;
        }
        if (this.cVs != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.cVs.getChildCount()) {
                    z = false;
                    break;
                } else if (this.cVs.getChildAt(i3) == this.cVn.UI()) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.cVm.aBI != null) {
                    i2 = this.cVm.aBI.getWidth();
                    i = this.cVm.aBI.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.cVu, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.cVm.toString(), "position", this.cVm.aBI == null ? "null" : this.cVm.aBI.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                    i2 = 0;
                }
                this.cVs.addView(this.cVn.UI(), new LinearLayout.LayoutParams(i2, i));
                if (TextUtils.equals(this.cVm.cVg, "contain")) {
                    setVideoScalingMode(2);
                } else {
                    setVideoScalingMode(0);
                }
            }
        }
        return true;
    }

    public boolean b(a aVar) {
        if (this.akt == null) {
            return false;
        }
        if (this.UT) {
            this.akt.setHidden(aVar.hidden);
            return true;
        }
        com.baidu.swan.apps.model.a.a.a EK = aVar.EK();
        EK.id = this.azv;
        EK.aBG = this.cVm.aBG;
        EK.aBH = aVar.aBH;
        if (com.baidu.swan.apps.view.container.c.b.a(EK.aBG, this.azv, com.baidu.swan.apps.view.container.c.c.hS(EK.aBG)) == null) {
            BdLog.d("insertOrUpdateCoverContainer 00");
            this.cVs = new FrameLayout(this.cVt);
            return this.akt.a(this.cVs, EK);
        }
        BdLog.d("insertOrUpdateCoverContainer 01");
        return this.akt.a(EK);
    }

    private void c(a aVar) {
        BdLog.d("initVideoCoverContainer 00");
        b(aVar);
    }

    private boolean d(a aVar) {
        if (this.cVm == null) {
            return false;
        }
        return (this.cVm.cVb == aVar.cVb && this.cVm.cVd == aVar.cVd && this.cVm.cVe == aVar.cVe && TextUtils.equals(this.cVm.cVf, aVar.cVf) && TextUtils.equals(this.cVm.cVg, aVar.cVg)) ? false : true;
    }

    public void e(@NonNull a aVar) {
        BdLog.d("updatePlayerConfig params: " + aVar.toString());
        if (d(aVar)) {
            this.cVm = aVar;
            azy();
        }
        this.cVm = aVar;
        c(this.cVm);
    }

    public boolean isPlaying() {
        if (this.cVn != null) {
            return this.cVr;
        }
        return false;
    }

    public void stop() {
        if (this.cVn != null) {
            this.cVn.stop();
            this.cVn.destroy();
            this.cVn.a(null);
            this.cVn = null;
            this.cVr = false;
        }
    }

    public void j(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.UT = z;
        int aO = l.aO(this.cVt);
        int aQ = l.aQ(this.cVt);
        if (z) {
            if (i == 90 || i == -90) {
                this.cVq.bAy();
                aO = aQ;
                aQ = aO;
            }
        } else if (this.cVt.getRequestedOrientation() != 1) {
            this.cVq.bAy();
        }
        if (z) {
            a(this.cVt, i, aO, aQ);
        } else {
            f(this.cVt, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null) {
            this.UT = true;
            if (this.akt != null && this.akt.getParent() != null) {
                ((ViewGroup) this.akt.getParent()).removeView(this.akt);
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.akt);
                viewGroup.addView(this.akt);
            }
            if (this.cVn != null && this.cVn.UI().getParent() != null) {
                ((ViewGroup) this.cVn.UI().getParent()).removeView(this.cVn.UI());
            }
            this.cVs.addView(this.cVn.UI(), new LinearLayout.LayoutParams(i2, i3));
            this.akt.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void f(Activity activity, int i) {
        if (activity == null || this.cVm == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.UT = false;
        if (this.akt != null && this.akt.getParent() != null) {
            ((ViewGroup) this.akt.getParent()).removeView(this.akt);
        }
        if (this.cVn != null && this.cVn.UI().getParent() != null) {
            ((ViewGroup) this.cVn.UI().getParent()).removeView(this.cVn.UI());
        }
        int width = this.cVm.aBI.getWidth();
        int height = this.cVm.aBI.getHeight();
        this.cVm.aBI.getLeft();
        this.cVm.aBI.getTop();
        this.cVs.addView(this.cVn.UI(), new LinearLayout.LayoutParams(width, height));
        this.akt.MJ();
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azA() {
        String EI = this.cVp.EI();
        if (!TextUtils.isEmpty(EI)) {
            BdLog.d(this.azv + " dispatchNetStatusEvent statusData: " + EI);
            c.J(getSlaveId(), Eg(), EI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lT(int i) {
        int lO = b.lO(i);
        BdLog.d(this.azv + " dispatchStatusIfNeeded what: " + i + " liveStatusCode:" + lO);
        if (lO != 100) {
            if (lO == 2101) {
                c.I(getSlaveId(), Eg(), b.lP(2102));
            }
            c.I(getSlaveId(), Eg(), b.lP(lO));
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String Eh() {
        return null;
    }
}
