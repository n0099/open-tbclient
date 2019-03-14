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
    private SwanAppNAViewContainer akp;
    private String azs;
    private com.baidu.tbadk.ala.d cVl;
    private d.a cVm;
    private o cVo;
    private FrameLayout cVq;
    private Activity cVr;
    private boolean mDetached;
    CustomMessageListener mNetworkChangedListener;
    private a cVk = a.azx();
    private com.baidu.tieba.aiapps.apps.media.b.a.a cVn = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean cVp = false;
    private String cVs = "AiAppLiveErr";

    public f(Context context, String str) {
        this.azs = str;
        this.cVr = (Activity) context;
        if (!TextUtils.isEmpty(this.azs)) {
            com.baidu.swan.apps.media.b.a(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.azs);
        this.akp = new SwanAppNAViewContainer(context);
        this.cVm = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.f.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + " " + i3);
                f.this.cVn.mVideoWidth = i2;
                f.this.cVn.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && f.this.cVn != null) {
                    if (alaLivePlayerData.fpsAvg != f.this.cVn.cVw) {
                        f.this.lU(940);
                    }
                    if (alaLivePlayerData.videoBitrate != f.this.cVn.cVu) {
                        f.this.lU(939);
                    }
                    if (alaLivePlayerData.audioBitrate != f.this.cVn.cVv) {
                        f.this.lU(938);
                    }
                    f.this.cVn.cVx = (int) alaLivePlayerData.bandWidth;
                    f.this.cVn.cVw = (int) alaLivePlayerData.fpsAvg;
                    f.this.cVn.cVv = (int) alaLivePlayerData.audioBitrate;
                    f.this.cVn.cVu = (int) alaLivePlayerData.videoBitrate;
                }
            }
        };
        this.mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.aiapps.apps.media.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    f.this.azD();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        this.cVo = new o(this.cVr);
        this.cVo.start();
        this.cVr.getWindow().addFlags(128);
    }

    public a azz() {
        return this.cVk;
    }

    public void a(a aVar) {
        this.cVk = aVar;
        if (!this.cVk.hidden && this.cVk.azC) {
            start();
        }
    }

    public void start() {
        if (this.cVk != null) {
            if (this.cVk.hidden) {
                BdLog.d("mPlayerId = " + this.azs + "can not start(), hide = " + this.cVk.hidden);
                return;
            }
            BdLog.d(this.azs + " start()");
            if (this.cVl != null) {
                azA();
            }
            azB();
            c(this.cVk);
            c(this.cVk.mSrc, "", "", false);
            azC();
            this.mDetached = false;
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String Ei() {
        return this.azs;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cVk.aBD;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Ek() {
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
        if (this.cVk != null && this.akp != null && d(this.cVr, this.akp)) {
            if (this.cVr.getRequestedOrientation() != 1) {
                this.cVo.bAB();
            }
            f(this.cVr, 0);
            return true;
        }
        release();
        return false;
    }

    public void azA() {
        if (this.cVl != null) {
            this.cVl.stop();
            this.cVl.destroy();
        }
        this.cVl = null;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.azs + " release()");
        this.cVr.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        com.baidu.swan.apps.media.b.b(this);
        this.cVo.stop();
        if (this.cVl != null) {
            this.cVl.stop();
            this.cVl.destroy();
            this.cVl = null;
        }
    }

    private void azB() {
        fY(this.cVk.cUZ);
        lR(this.cVk.cVb);
        lS(this.cVk.cVc);
        if (TextUtils.equals(this.cVk.cVd, "horizontal")) {
            lT(90);
        } else {
            lT(0);
        }
        if (TextUtils.equals(this.cVk.cVe, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void fY(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.cVl != null) {
            this.cVl.setAudioMute(z);
        }
    }

    public void lR(int i) {
    }

    public void lS(int i) {
    }

    public void lT(int i) {
    }

    public void setVideoScalingMode(int i) {
        BdLog.d("setVideoScalingMode scalingMode: " + i);
        if (this.cVl != null) {
            this.cVl.setRenderVideoModel(1, i != 2 ? 1 : 2);
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

    private boolean azC() {
        boolean z;
        int i;
        int i2;
        CustomResponsedMessage runTask;
        if (this.cVl == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.cVr)) != null && runTask.getData() != null) {
            this.cVl = (com.baidu.tbadk.ala.d) runTask.getData();
            this.cVl.a(this.cVm);
        }
        if (this.cVl == null) {
            return false;
        }
        if (this.cVl.a(1, this.cVk.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
            this.cVp = true;
        }
        if (this.cVq != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.cVq.getChildCount()) {
                    z = false;
                    break;
                } else if (this.cVq.getChildAt(i3) == this.cVl.UL()) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.cVk.aBF != null) {
                    i2 = this.cVk.aBF.getWidth();
                    i = this.cVk.aBF.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.cVs, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.cVk.toString(), "position", this.cVk.aBF == null ? "null" : this.cVk.aBF.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                    i2 = 0;
                }
                this.cVq.addView(this.cVl.UL(), new LinearLayout.LayoutParams(i2, i));
                if (TextUtils.equals(this.cVk.cVe, "contain")) {
                    setVideoScalingMode(2);
                } else {
                    setVideoScalingMode(0);
                }
            }
        }
        return true;
    }

    public boolean b(a aVar) {
        if (this.akp == null) {
            return false;
        }
        if (this.UT) {
            this.akp.setHidden(aVar.hidden);
            return true;
        }
        com.baidu.swan.apps.model.a.a.a EM = aVar.EM();
        EM.id = this.azs;
        EM.aBD = this.cVk.aBD;
        EM.aBE = aVar.aBE;
        if (com.baidu.swan.apps.view.container.c.b.a(EM.aBD, this.azs, com.baidu.swan.apps.view.container.c.c.hR(EM.aBD)) == null) {
            BdLog.d("insertOrUpdateCoverContainer 00");
            this.cVq = new FrameLayout(this.cVr);
            return this.akp.a(this.cVq, EM);
        }
        BdLog.d("insertOrUpdateCoverContainer 01");
        return this.akp.a(EM);
    }

    private void c(a aVar) {
        BdLog.d("initVideoCoverContainer 00");
        b(aVar);
    }

    private boolean d(a aVar) {
        if (this.cVk == null) {
            return false;
        }
        return (this.cVk.cUZ == aVar.cUZ && this.cVk.cVb == aVar.cVb && this.cVk.cVc == aVar.cVc && TextUtils.equals(this.cVk.cVd, aVar.cVd) && TextUtils.equals(this.cVk.cVe, aVar.cVe)) ? false : true;
    }

    public void e(@NonNull a aVar) {
        BdLog.d("updatePlayerConfig params: " + aVar.toString());
        if (d(aVar)) {
            this.cVk = aVar;
            azB();
        }
        this.cVk = aVar;
        c(this.cVk);
    }

    public boolean isPlaying() {
        if (this.cVl != null) {
            return this.cVp;
        }
        return false;
    }

    public void stop() {
        if (this.cVl != null) {
            this.cVl.stop();
            this.cVl.destroy();
            this.cVl.a(null);
            this.cVl = null;
            this.cVp = false;
        }
    }

    public void j(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.UT = z;
        int aO = l.aO(this.cVr);
        int aQ = l.aQ(this.cVr);
        if (z) {
            if (i == 90 || i == -90) {
                this.cVo.bAB();
                aO = aQ;
                aQ = aO;
            }
        } else if (this.cVr.getRequestedOrientation() != 1) {
            this.cVo.bAB();
        }
        if (z) {
            a(this.cVr, i, aO, aQ);
        } else {
            f(this.cVr, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null) {
            this.UT = true;
            if (this.akp != null && this.akp.getParent() != null) {
                ((ViewGroup) this.akp.getParent()).removeView(this.akp);
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.akp);
                viewGroup.addView(this.akp);
            }
            if (this.cVl != null && this.cVl.UL().getParent() != null) {
                ((ViewGroup) this.cVl.UL().getParent()).removeView(this.cVl.UL());
            }
            this.cVq.addView(this.cVl.UL(), new LinearLayout.LayoutParams(i2, i3));
            this.akp.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void f(Activity activity, int i) {
        if (activity == null || this.cVk == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.UT = false;
        if (this.akp != null && this.akp.getParent() != null) {
            ((ViewGroup) this.akp.getParent()).removeView(this.akp);
        }
        if (this.cVl != null && this.cVl.UL().getParent() != null) {
            ((ViewGroup) this.cVl.UL().getParent()).removeView(this.cVl.UL());
        }
        int width = this.cVk.aBF.getWidth();
        int height = this.cVk.aBF.getHeight();
        this.cVk.aBF.getLeft();
        this.cVk.aBF.getTop();
        this.cVq.addView(this.cVl.UL(), new LinearLayout.LayoutParams(width, height));
        this.akp.ML();
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azD() {
        String EK = this.cVn.EK();
        if (!TextUtils.isEmpty(EK)) {
            BdLog.d(this.azs + " dispatchNetStatusEvent statusData: " + EK);
            c.J(getSlaveId(), Ei(), EK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lU(int i) {
        int lP = b.lP(i);
        BdLog.d(this.azs + " dispatchStatusIfNeeded what: " + i + " liveStatusCode:" + lP);
        if (lP != 100) {
            if (lP == 2101) {
                c.I(getSlaveId(), Ei(), b.lQ(2102));
            }
            c.I(getSlaveId(), Ei(), b.lQ(lP));
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String Ej() {
        return null;
    }
}
