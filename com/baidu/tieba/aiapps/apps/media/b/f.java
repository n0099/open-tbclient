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
    private boolean SE;
    private String aAu;
    private SwanAppNAViewContainer akG;
    private com.baidu.tbadk.ala.d ddK;
    private d.a ddL;
    private o ddN;
    private FrameLayout ddP;
    private Activity ddQ;
    private boolean mDetached;
    CustomMessageListener mNetworkChangedListener;
    private a ddJ = a.aEJ();
    private com.baidu.tieba.aiapps.apps.media.b.a.a ddM = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean ddO = false;
    private String ddR = "AiAppLiveErr";

    public f(Context context, String str) {
        this.aAu = str;
        this.ddQ = (Activity) context;
        if (!TextUtils.isEmpty(this.aAu)) {
            com.baidu.swan.apps.media.b.a(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.aAu);
        this.akG = new SwanAppNAViewContainer(context);
        this.ddL = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.f.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + " " + i3);
                f.this.ddM.mVideoWidth = i2;
                f.this.ddM.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && f.this.ddM != null) {
                    if (alaLivePlayerData.fpsAvg != f.this.ddM.ddT) {
                        f.this.mF(940);
                    }
                    if (alaLivePlayerData.videoBitrate != f.this.ddM.aeK) {
                        f.this.mF(939);
                    }
                    if (alaLivePlayerData.audioBitrate != f.this.ddM.aeQ) {
                        f.this.mF(938);
                    }
                    f.this.ddM.ddU = (int) alaLivePlayerData.bandWidth;
                    f.this.ddM.ddT = (int) alaLivePlayerData.fpsAvg;
                    f.this.ddM.aeQ = (int) alaLivePlayerData.audioBitrate;
                    f.this.ddM.aeK = (int) alaLivePlayerData.videoBitrate;
                }
            }
        };
        this.mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.aiapps.apps.media.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    f.this.aEP();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        this.ddN = new o(this.ddQ);
        this.ddN.start();
        this.ddQ.getWindow().addFlags(128);
    }

    public a aEL() {
        return this.ddJ;
    }

    public void a(a aVar) {
        this.ddJ = aVar;
        if (!this.ddJ.hidden && this.ddJ.aAD) {
            start();
        }
    }

    public void start() {
        if (this.ddJ != null) {
            if (this.ddJ.hidden) {
                BdLog.d("mPlayerId = " + this.aAu + "can not start(), hide = " + this.ddJ.hidden);
                return;
            }
            BdLog.d(this.aAu + " start()");
            if (this.ddK != null) {
                aEM();
            }
            aEN();
            c(this.ddJ);
            c(this.ddJ.mSrc, "", "", false);
            aEO();
            this.mDetached = false;
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String Gc() {
        return this.aAu;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.ddJ.aDm;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Ge() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bt(boolean z) {
        BdLog.d("onForegroundChanged " + z);
    }

    @Override // com.baidu.swan.apps.media.a
    public void bu(boolean z) {
        BdLog.d("onAppForegroundChanged " + z);
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        BdLog.d("onBackPressed ");
        if (this.ddJ != null && this.akG != null && d(this.ddQ, this.akG)) {
            if (this.ddQ.getRequestedOrientation() != 1) {
                this.ddN.bIi();
            }
            f(this.ddQ, 0);
            return true;
        }
        release();
        return false;
    }

    public void aEM() {
        if (this.ddK != null) {
            this.ddK.stop();
            this.ddK.destroy();
        }
        this.ddK = null;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.aAu + " release()");
        this.ddQ.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        com.baidu.swan.apps.media.b.b(this);
        this.ddN.stop();
        if (this.ddK != null) {
            this.ddK.stop();
            this.ddK.destroy();
            this.ddK = null;
        }
    }

    private void aEN() {
        bo(this.ddJ.ddA);
        mD(this.ddJ.ddC);
        mE(this.ddJ.ddD);
        if (TextUtils.equals(this.ddJ.ddE, "horizontal")) {
            setVideoRotation(90);
        } else {
            setVideoRotation(0);
        }
        if (TextUtils.equals(this.ddJ.aCA, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void bo(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.ddK != null) {
            this.ddK.setAudioMute(z);
        }
    }

    public void mD(int i) {
    }

    public void mE(int i) {
    }

    public void setVideoRotation(int i) {
    }

    public void setVideoScalingMode(int i) {
        BdLog.d("setVideoScalingMode scalingMode: " + i);
        if (this.ddK != null) {
            this.ddK.setRenderVideoModel(1, i != 2 ? 1 : 2);
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

    private boolean aEO() {
        boolean z;
        int i;
        int i2;
        CustomResponsedMessage runTask;
        if (this.ddK == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.ddQ)) != null && runTask.getData() != null) {
            this.ddK = (com.baidu.tbadk.ala.d) runTask.getData();
            this.ddK.a(this.ddL);
        }
        if (this.ddK == null) {
            return false;
        }
        if (this.ddK.a(1, this.ddJ.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
            this.ddO = true;
        }
        if (this.ddP != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.ddP.getChildCount()) {
                    z = false;
                    break;
                } else if (this.ddP.getChildAt(i3) == this.ddK.Zm()) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.ddJ.aDo != null) {
                    i2 = this.ddJ.aDo.getWidth();
                    i = this.ddJ.aDo.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.ddR, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.ddJ.toString(), "position", this.ddJ.aDo == null ? "null" : this.ddJ.aDo.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                    i2 = 0;
                }
                this.ddP.addView(this.ddK.Zm(), new LinearLayout.LayoutParams(i2, i));
                if (TextUtils.equals(this.ddJ.aCA, "contain")) {
                    setVideoScalingMode(2);
                } else {
                    setVideoScalingMode(0);
                }
            }
        }
        return true;
    }

    public boolean b(a aVar) {
        if (this.akG == null) {
            return false;
        }
        if (this.SE) {
            this.akG.setHidden(aVar.hidden);
            return true;
        }
        com.baidu.swan.apps.model.a.a.a GI = aVar.GI();
        GI.id = this.aAu;
        GI.aDm = this.ddJ.aDm;
        GI.aDn = aVar.aDn;
        if (com.baidu.swan.apps.view.container.c.b.a(GI.aDm, this.aAu, com.baidu.swan.apps.view.container.c.c.ix(GI.aDm)) == null) {
            BdLog.d("insertOrUpdateCoverContainer 00");
            this.ddP = new FrameLayout(this.ddQ);
            return this.akG.a(this.ddP, GI);
        }
        BdLog.d("insertOrUpdateCoverContainer 01");
        return this.akG.a(GI);
    }

    private void c(a aVar) {
        BdLog.d("initVideoCoverContainer 00");
        b(aVar);
    }

    private boolean d(a aVar) {
        if (this.ddJ == null) {
            return false;
        }
        return (this.ddJ.ddA == aVar.ddA && this.ddJ.ddC == aVar.ddC && this.ddJ.ddD == aVar.ddD && TextUtils.equals(this.ddJ.ddE, aVar.ddE) && TextUtils.equals(this.ddJ.aCA, aVar.aCA)) ? false : true;
    }

    public void e(@NonNull a aVar) {
        BdLog.d("updatePlayerConfig params: " + aVar.toString());
        if (d(aVar)) {
            this.ddJ = aVar;
            aEN();
        }
        this.ddJ = aVar;
        c(this.ddJ);
    }

    public boolean isPlaying() {
        if (this.ddK != null) {
            return this.ddO;
        }
        return false;
    }

    public void stop() {
        if (this.ddK != null) {
            this.ddK.stop();
            this.ddK.destroy();
            this.ddK.a(null);
            this.ddK = null;
            this.ddO = false;
        }
    }

    public void j(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.SE = z;
        int af = l.af(this.ddQ);
        int ah = l.ah(this.ddQ);
        if (z) {
            if (i == 90 || i == -90) {
                this.ddN.bIi();
                af = ah;
                ah = af;
            }
        } else if (this.ddQ.getRequestedOrientation() != 1) {
            this.ddN.bIi();
        }
        if (z) {
            a(this.ddQ, i, af, ah);
        } else {
            f(this.ddQ, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null) {
            this.SE = true;
            if (this.akG != null && this.akG.getParent() != null) {
                ((ViewGroup) this.akG.getParent()).removeView(this.akG);
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.akG);
                viewGroup.addView(this.akG);
            }
            if (this.ddK != null && this.ddK.Zm().getParent() != null) {
                ((ViewGroup) this.ddK.Zm().getParent()).removeView(this.ddK.Zm());
            }
            this.ddP.addView(this.ddK.Zm(), new LinearLayout.LayoutParams(i2, i3));
            this.akG.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void f(Activity activity, int i) {
        if (activity == null || this.ddJ == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.SE = false;
        if (this.akG != null && this.akG.getParent() != null) {
            ((ViewGroup) this.akG.getParent()).removeView(this.akG);
        }
        if (this.ddK != null && this.ddK.Zm().getParent() != null) {
            ((ViewGroup) this.ddK.Zm().getParent()).removeView(this.ddK.Zm());
        }
        int width = this.ddJ.aDo.getWidth();
        int height = this.ddJ.aDo.getHeight();
        this.ddJ.aDo.getLeft();
        this.ddJ.aDo.getTop();
        this.ddP.addView(this.ddK.Zm(), new LinearLayout.LayoutParams(width, height));
        this.akG.Ps();
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEP() {
        String GG = this.ddM.GG();
        if (!TextUtils.isEmpty(GG)) {
            BdLog.d(this.aAu + " dispatchNetStatusEvent statusData: " + GG);
            c.J(getSlaveId(), Gc(), GG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mF(int i) {
        int mB = b.mB(i);
        BdLog.d(this.aAu + " dispatchStatusIfNeeded what: " + i + " liveStatusCode:" + mB);
        if (mB != 100) {
            if (mB == 2101) {
                c.I(getSlaveId(), Gc(), b.mC(2102));
            }
            c.I(getSlaveId(), Gc(), b.mC(mB));
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String Gd() {
        return null;
    }
}
