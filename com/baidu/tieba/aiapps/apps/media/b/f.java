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
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private boolean US;
    private SwanAppNAViewContainer ako;
    private String azr;
    private com.baidu.tbadk.ala.d cVp;
    private d.a cVq;
    private o cVs;
    private FrameLayout cVu;
    private Activity cVv;
    private boolean mDetached;
    CustomMessageListener mNetworkChangedListener;
    private a cVo = a.azx();
    private com.baidu.tieba.aiapps.apps.media.b.a.a cVr = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean cVt = false;
    private String cVw = "AiAppLiveErr";

    public f(Context context, String str) {
        this.azr = str;
        this.cVv = (Activity) context;
        if (!TextUtils.isEmpty(this.azr)) {
            com.baidu.swan.apps.media.b.a(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.azr);
        this.ako = new SwanAppNAViewContainer(context);
        this.cVq = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.f.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + " " + i3);
                f.this.cVr.mVideoWidth = i2;
                f.this.cVr.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && f.this.cVr != null) {
                    if (alaLivePlayerData.fpsAvg != f.this.cVr.cVA) {
                        f.this.lU(940);
                    }
                    if (alaLivePlayerData.videoBitrate != f.this.cVr.cVy) {
                        f.this.lU(939);
                    }
                    if (alaLivePlayerData.audioBitrate != f.this.cVr.cVz) {
                        f.this.lU(938);
                    }
                    f.this.cVr.cVB = (int) alaLivePlayerData.bandWidth;
                    f.this.cVr.cVA = (int) alaLivePlayerData.fpsAvg;
                    f.this.cVr.cVz = (int) alaLivePlayerData.audioBitrate;
                    f.this.cVr.cVy = (int) alaLivePlayerData.videoBitrate;
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
        this.cVs = new o(this.cVv);
        this.cVs.start();
        this.cVv.getWindow().addFlags(128);
    }

    public a azz() {
        return this.cVo;
    }

    public void a(a aVar) {
        this.cVo = aVar;
        if (!this.cVo.hidden && this.cVo.azB) {
            start();
        }
    }

    public void start() {
        if (this.cVo != null) {
            if (this.cVo.hidden) {
                BdLog.d("mPlayerId = " + this.azr + "can not start(), hide = " + this.cVo.hidden);
                return;
            }
            BdLog.d(this.azr + " start()");
            if (this.cVp != null) {
                azA();
            }
            azB();
            c(this.cVo);
            c(this.cVo.mSrc, "", "", false);
            azC();
            this.mDetached = false;
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String Ei() {
        return this.azr;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cVo.aBC;
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
        if (this.cVo != null && this.ako != null && d(this.cVv, this.ako)) {
            if (this.cVv.getRequestedOrientation() != 1) {
                this.cVs.bAB();
            }
            f(this.cVv, 0);
            return true;
        }
        release();
        return false;
    }

    public void azA() {
        if (this.cVp != null) {
            this.cVp.stop();
            this.cVp.destroy();
        }
        this.cVp = null;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.azr + " release()");
        this.cVv.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        com.baidu.swan.apps.media.b.b(this);
        this.cVs.stop();
        if (this.cVp != null) {
            this.cVp.stop();
            this.cVp.destroy();
            this.cVp = null;
        }
    }

    private void azB() {
        fY(this.cVo.cVd);
        lR(this.cVo.cVf);
        lS(this.cVo.cVg);
        if (TextUtils.equals(this.cVo.cVh, "horizontal")) {
            lT(90);
        } else {
            lT(0);
        }
        if (TextUtils.equals(this.cVo.cVi, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void fY(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.cVp != null) {
            this.cVp.setAudioMute(z);
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
        if (this.cVp != null) {
            this.cVp.setRenderVideoModel(1, i != 2 ? 1 : 2);
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
        if (this.cVp == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.cVv)) != null && runTask.getData() != null) {
            this.cVp = (com.baidu.tbadk.ala.d) runTask.getData();
            this.cVp.a(this.cVq);
        }
        if (this.cVp == null) {
            return false;
        }
        if (this.cVp.a(1, this.cVo.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
            this.cVt = true;
        }
        if (this.cVu != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.cVu.getChildCount()) {
                    z = false;
                    break;
                } else if (this.cVu.getChildAt(i3) == this.cVp.UL()) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.cVo.aBE != null) {
                    i2 = this.cVo.aBE.getWidth();
                    i = this.cVo.aBE.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.cVw, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.cVo.toString(), "position", this.cVo.aBE.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                    i2 = 0;
                }
                this.cVu.addView(this.cVp.UL(), new LinearLayout.LayoutParams(i2, i));
                if (TextUtils.equals(this.cVo.cVi, "contain")) {
                    setVideoScalingMode(2);
                } else {
                    setVideoScalingMode(0);
                }
            }
        }
        return true;
    }

    public boolean b(a aVar) {
        if (this.ako == null) {
            return false;
        }
        if (this.US) {
            this.ako.setHidden(aVar.hidden);
            return true;
        }
        com.baidu.swan.apps.model.a.a.a EM = aVar.EM();
        EM.id = this.azr;
        EM.aBC = this.cVo.aBC;
        EM.aBD = aVar.aBD;
        if (com.baidu.swan.apps.view.container.c.b.a(EM.aBC, this.azr, com.baidu.swan.apps.view.container.c.c.hR(EM.aBC)) == null) {
            BdLog.d("insertOrUpdateCoverContainer 00");
            this.cVu = new FrameLayout(this.cVv);
            return this.ako.a(this.cVu, EM);
        }
        BdLog.d("insertOrUpdateCoverContainer 01");
        return this.ako.a(EM);
    }

    private void c(a aVar) {
        BdLog.d("initVideoCoverContainer 00");
        b(aVar);
    }

    private boolean d(a aVar) {
        if (this.cVo == null) {
            return false;
        }
        return (this.cVo.cVd == aVar.cVd && this.cVo.cVf == aVar.cVf && this.cVo.cVg == aVar.cVg && TextUtils.equals(this.cVo.cVh, aVar.cVh) && TextUtils.equals(this.cVo.cVi, aVar.cVi)) ? false : true;
    }

    public void e(@NonNull a aVar) {
        BdLog.d("updatePlayerConfig params: " + aVar.toString());
        if (d(aVar)) {
            this.cVo = aVar;
            azB();
        }
        this.cVo = aVar;
        c(this.cVo);
    }

    public boolean isPlaying() {
        if (this.cVp != null) {
            return this.cVt;
        }
        return false;
    }

    public void stop() {
        if (this.cVp != null) {
            this.cVp.stop();
            this.cVp.destroy();
            this.cVp.a(null);
            this.cVp = null;
            this.cVt = false;
        }
    }

    public void j(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.US = z;
        int aO = l.aO(this.cVv);
        int aQ = l.aQ(this.cVv);
        if (z) {
            if (i == 90 || i == -90) {
                this.cVs.bAB();
                aO = aQ;
                aQ = aO;
            }
        } else if (this.cVv.getRequestedOrientation() != 1) {
            this.cVs.bAB();
        }
        if (z) {
            a(this.cVv, i, aO, aQ);
        } else {
            f(this.cVv, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null) {
            this.US = true;
            if (this.ako != null && this.ako.getParent() != null) {
                ((ViewGroup) this.ako.getParent()).removeView(this.ako);
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.ako);
                viewGroup.addView(this.ako);
            }
            if (this.cVp != null && this.cVp.UL().getParent() != null) {
                ((ViewGroup) this.cVp.UL().getParent()).removeView(this.cVp.UL());
            }
            this.cVu.addView(this.cVp.UL(), new LinearLayout.LayoutParams(i2, i3));
            this.ako.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void f(Activity activity, int i) {
        if (activity == null || this.cVo == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.US = false;
        if (this.ako != null && this.ako.getParent() != null) {
            ((ViewGroup) this.ako.getParent()).removeView(this.ako);
        }
        if (this.cVp != null && this.cVp.UL().getParent() != null) {
            ((ViewGroup) this.cVp.UL().getParent()).removeView(this.cVp.UL());
        }
        int width = this.cVo.aBE.getWidth();
        int height = this.cVo.aBE.getHeight();
        this.cVo.aBE.getLeft();
        this.cVo.aBE.getTop();
        this.cVu.addView(this.cVp.UL(), new LinearLayout.LayoutParams(width, height));
        this.ako.ML();
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azD() {
        String EK = this.cVr.EK();
        if (!TextUtils.isEmpty(EK)) {
            BdLog.d(this.azr + " dispatchNetStatusEvent statusData: " + EK);
            c.J(getSlaveId(), Ei(), EK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lU(int i) {
        int lP = b.lP(i);
        BdLog.d(this.azr + " dispatchStatusIfNeeded what: " + i + " liveStatusCode:" + lP);
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
