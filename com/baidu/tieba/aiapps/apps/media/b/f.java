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
    private boolean SD;
    private String aAu;
    private SwanAppNAViewContainer akG;
    private com.baidu.tbadk.ala.d ddM;
    private d.a ddN;
    private o ddP;
    private FrameLayout ddR;
    private Activity ddS;
    private boolean mDetached;
    CustomMessageListener mNetworkChangedListener;
    private a ddL = a.aEM();
    private com.baidu.tieba.aiapps.apps.media.b.a.a ddO = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean ddQ = false;
    private String ddT = "AiAppLiveErr";

    public f(Context context, String str) {
        this.aAu = str;
        this.ddS = (Activity) context;
        if (!TextUtils.isEmpty(this.aAu)) {
            com.baidu.swan.apps.media.b.a(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.aAu);
        this.akG = new SwanAppNAViewContainer(context);
        this.ddN = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.f.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + " " + i3);
                f.this.ddO.mVideoWidth = i2;
                f.this.ddO.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && f.this.ddO != null) {
                    if (alaLivePlayerData.fpsAvg != f.this.ddO.ddV) {
                        f.this.mF(940);
                    }
                    if (alaLivePlayerData.videoBitrate != f.this.ddO.aeK) {
                        f.this.mF(939);
                    }
                    if (alaLivePlayerData.audioBitrate != f.this.ddO.aeQ) {
                        f.this.mF(938);
                    }
                    f.this.ddO.ddW = (int) alaLivePlayerData.bandWidth;
                    f.this.ddO.ddV = (int) alaLivePlayerData.fpsAvg;
                    f.this.ddO.aeQ = (int) alaLivePlayerData.audioBitrate;
                    f.this.ddO.aeK = (int) alaLivePlayerData.videoBitrate;
                }
            }
        };
        this.mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.aiapps.apps.media.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    f.this.aES();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        this.ddP = new o(this.ddS);
        this.ddP.start();
        this.ddS.getWindow().addFlags(128);
    }

    public a aEO() {
        return this.ddL;
    }

    public void a(a aVar) {
        this.ddL = aVar;
        if (!this.ddL.hidden && this.ddL.aAD) {
            start();
        }
    }

    public void start() {
        if (this.ddL != null) {
            if (this.ddL.hidden) {
                BdLog.d("mPlayerId = " + this.aAu + "can not start(), hide = " + this.ddL.hidden);
                return;
            }
            BdLog.d(this.aAu + " start()");
            if (this.ddM != null) {
                aEP();
            }
            aEQ();
            c(this.ddL);
            c(this.ddL.mSrc, "", "", false);
            aER();
            this.mDetached = false;
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String Gc() {
        return this.aAu;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.ddL.aDm;
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
        if (this.ddL != null && this.akG != null && d(this.ddS, this.akG)) {
            if (this.ddS.getRequestedOrientation() != 1) {
                this.ddP.bIm();
            }
            f(this.ddS, 0);
            return true;
        }
        release();
        return false;
    }

    public void aEP() {
        if (this.ddM != null) {
            this.ddM.stop();
            this.ddM.destroy();
        }
        this.ddM = null;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.aAu + " release()");
        this.ddS.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        com.baidu.swan.apps.media.b.b(this);
        this.ddP.stop();
        if (this.ddM != null) {
            this.ddM.stop();
            this.ddM.destroy();
            this.ddM = null;
        }
    }

    private void aEQ() {
        bo(this.ddL.ddC);
        mD(this.ddL.ddE);
        mE(this.ddL.ddF);
        if (TextUtils.equals(this.ddL.ddG, "horizontal")) {
            setVideoRotation(90);
        } else {
            setVideoRotation(0);
        }
        if (TextUtils.equals(this.ddL.aCA, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void bo(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.ddM != null) {
            this.ddM.setAudioMute(z);
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
        if (this.ddM != null) {
            this.ddM.setRenderVideoModel(1, i != 2 ? 1 : 2);
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

    private boolean aER() {
        boolean z;
        int i;
        int i2;
        CustomResponsedMessage runTask;
        if (this.ddM == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.ddS)) != null && runTask.getData() != null) {
            this.ddM = (com.baidu.tbadk.ala.d) runTask.getData();
            this.ddM.a(this.ddN);
        }
        if (this.ddM == null) {
            return false;
        }
        if (this.ddM.a(1, this.ddL.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
            this.ddQ = true;
        }
        if (this.ddR != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.ddR.getChildCount()) {
                    z = false;
                    break;
                } else if (this.ddR.getChildAt(i3) == this.ddM.Zm()) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.ddL.aDo != null) {
                    i2 = this.ddL.aDo.getWidth();
                    i = this.ddL.aDo.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.ddT, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.ddL.toString(), "position", this.ddL.aDo == null ? "null" : this.ddL.aDo.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                    i2 = 0;
                }
                this.ddR.addView(this.ddM.Zm(), new LinearLayout.LayoutParams(i2, i));
                if (TextUtils.equals(this.ddL.aCA, "contain")) {
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
        if (this.SD) {
            this.akG.setHidden(aVar.hidden);
            return true;
        }
        com.baidu.swan.apps.model.a.a.a GI = aVar.GI();
        GI.id = this.aAu;
        GI.aDm = this.ddL.aDm;
        GI.aDn = aVar.aDn;
        if (com.baidu.swan.apps.view.container.c.b.a(GI.aDm, this.aAu, com.baidu.swan.apps.view.container.c.c.iw(GI.aDm)) == null) {
            BdLog.d("insertOrUpdateCoverContainer 00");
            this.ddR = new FrameLayout(this.ddS);
            return this.akG.a(this.ddR, GI);
        }
        BdLog.d("insertOrUpdateCoverContainer 01");
        return this.akG.a(GI);
    }

    private void c(a aVar) {
        BdLog.d("initVideoCoverContainer 00");
        b(aVar);
    }

    private boolean d(a aVar) {
        if (this.ddL == null) {
            return false;
        }
        return (this.ddL.ddC == aVar.ddC && this.ddL.ddE == aVar.ddE && this.ddL.ddF == aVar.ddF && TextUtils.equals(this.ddL.ddG, aVar.ddG) && TextUtils.equals(this.ddL.aCA, aVar.aCA)) ? false : true;
    }

    public void e(@NonNull a aVar) {
        BdLog.d("updatePlayerConfig params: " + aVar.toString());
        if (d(aVar)) {
            this.ddL = aVar;
            aEQ();
        }
        this.ddL = aVar;
        c(this.ddL);
    }

    public boolean isPlaying() {
        if (this.ddM != null) {
            return this.ddQ;
        }
        return false;
    }

    public void stop() {
        if (this.ddM != null) {
            this.ddM.stop();
            this.ddM.destroy();
            this.ddM.a(null);
            this.ddM = null;
            this.ddQ = false;
        }
    }

    public void j(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.SD = z;
        int af = l.af(this.ddS);
        int ah = l.ah(this.ddS);
        if (z) {
            if (i == 90 || i == -90) {
                this.ddP.bIm();
                af = ah;
                ah = af;
            }
        } else if (this.ddS.getRequestedOrientation() != 1) {
            this.ddP.bIm();
        }
        if (z) {
            a(this.ddS, i, af, ah);
        } else {
            f(this.ddS, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null) {
            this.SD = true;
            if (this.akG != null && this.akG.getParent() != null) {
                ((ViewGroup) this.akG.getParent()).removeView(this.akG);
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.akG);
                viewGroup.addView(this.akG);
            }
            if (this.ddM != null && this.ddM.Zm().getParent() != null) {
                ((ViewGroup) this.ddM.Zm().getParent()).removeView(this.ddM.Zm());
            }
            this.ddR.addView(this.ddM.Zm(), new LinearLayout.LayoutParams(i2, i3));
            this.akG.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void f(Activity activity, int i) {
        if (activity == null || this.ddL == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.SD = false;
        if (this.akG != null && this.akG.getParent() != null) {
            ((ViewGroup) this.akG.getParent()).removeView(this.akG);
        }
        if (this.ddM != null && this.ddM.Zm().getParent() != null) {
            ((ViewGroup) this.ddM.Zm().getParent()).removeView(this.ddM.Zm());
        }
        int width = this.ddL.aDo.getWidth();
        int height = this.ddL.aDo.getHeight();
        this.ddL.aDo.getLeft();
        this.ddL.aDo.getTop();
        this.ddR.addView(this.ddM.Zm(), new LinearLayout.LayoutParams(width, height));
        this.akG.Ps();
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aES() {
        String GG = this.ddO.GG();
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
