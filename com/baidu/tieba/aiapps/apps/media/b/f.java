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
    private com.baidu.tbadk.ala.d ddL;
    private d.a ddM;
    private o ddO;
    private FrameLayout ddQ;
    private Activity ddR;
    private boolean mDetached;
    CustomMessageListener mNetworkChangedListener;
    private a ddK = a.aEM();
    private com.baidu.tieba.aiapps.apps.media.b.a.a ddN = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean ddP = false;
    private String ddS = "AiAppLiveErr";

    public f(Context context, String str) {
        this.aAu = str;
        this.ddR = (Activity) context;
        if (!TextUtils.isEmpty(this.aAu)) {
            com.baidu.swan.apps.media.b.a(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.aAu);
        this.akG = new SwanAppNAViewContainer(context);
        this.ddM = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.f.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + " " + i3);
                f.this.ddN.mVideoWidth = i2;
                f.this.ddN.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && f.this.ddN != null) {
                    if (alaLivePlayerData.fpsAvg != f.this.ddN.ddU) {
                        f.this.mF(940);
                    }
                    if (alaLivePlayerData.videoBitrate != f.this.ddN.aeK) {
                        f.this.mF(939);
                    }
                    if (alaLivePlayerData.audioBitrate != f.this.ddN.aeQ) {
                        f.this.mF(938);
                    }
                    f.this.ddN.ddV = (int) alaLivePlayerData.bandWidth;
                    f.this.ddN.ddU = (int) alaLivePlayerData.fpsAvg;
                    f.this.ddN.aeQ = (int) alaLivePlayerData.audioBitrate;
                    f.this.ddN.aeK = (int) alaLivePlayerData.videoBitrate;
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
        this.ddO = new o(this.ddR);
        this.ddO.start();
        this.ddR.getWindow().addFlags(128);
    }

    public a aEO() {
        return this.ddK;
    }

    public void a(a aVar) {
        this.ddK = aVar;
        if (!this.ddK.hidden && this.ddK.aAD) {
            start();
        }
    }

    public void start() {
        if (this.ddK != null) {
            if (this.ddK.hidden) {
                BdLog.d("mPlayerId = " + this.aAu + "can not start(), hide = " + this.ddK.hidden);
                return;
            }
            BdLog.d(this.aAu + " start()");
            if (this.ddL != null) {
                aEP();
            }
            aEQ();
            c(this.ddK);
            c(this.ddK.mSrc, "", "", false);
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
        return this.ddK.aDm;
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
        if (this.ddK != null && this.akG != null && d(this.ddR, this.akG)) {
            if (this.ddR.getRequestedOrientation() != 1) {
                this.ddO.bIl();
            }
            f(this.ddR, 0);
            return true;
        }
        release();
        return false;
    }

    public void aEP() {
        if (this.ddL != null) {
            this.ddL.stop();
            this.ddL.destroy();
        }
        this.ddL = null;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.aAu + " release()");
        this.ddR.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        com.baidu.swan.apps.media.b.b(this);
        this.ddO.stop();
        if (this.ddL != null) {
            this.ddL.stop();
            this.ddL.destroy();
            this.ddL = null;
        }
    }

    private void aEQ() {
        bo(this.ddK.ddB);
        mD(this.ddK.ddD);
        mE(this.ddK.ddE);
        if (TextUtils.equals(this.ddK.ddF, "horizontal")) {
            setVideoRotation(90);
        } else {
            setVideoRotation(0);
        }
        if (TextUtils.equals(this.ddK.aCA, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void bo(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.ddL != null) {
            this.ddL.setAudioMute(z);
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
        if (this.ddL != null) {
            this.ddL.setRenderVideoModel(1, i != 2 ? 1 : 2);
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
        if (this.ddL == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.ddR)) != null && runTask.getData() != null) {
            this.ddL = (com.baidu.tbadk.ala.d) runTask.getData();
            this.ddL.a(this.ddM);
        }
        if (this.ddL == null) {
            return false;
        }
        if (this.ddL.a(1, this.ddK.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
            this.ddP = true;
        }
        if (this.ddQ != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.ddQ.getChildCount()) {
                    z = false;
                    break;
                } else if (this.ddQ.getChildAt(i3) == this.ddL.Zm()) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.ddK.aDo != null) {
                    i2 = this.ddK.aDo.getWidth();
                    i = this.ddK.aDo.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.ddS, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.ddK.toString(), "position", this.ddK.aDo == null ? "null" : this.ddK.aDo.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                    i2 = 0;
                }
                this.ddQ.addView(this.ddL.Zm(), new LinearLayout.LayoutParams(i2, i));
                if (TextUtils.equals(this.ddK.aCA, "contain")) {
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
        GI.aDm = this.ddK.aDm;
        GI.aDn = aVar.aDn;
        if (com.baidu.swan.apps.view.container.c.b.a(GI.aDm, this.aAu, com.baidu.swan.apps.view.container.c.c.ix(GI.aDm)) == null) {
            BdLog.d("insertOrUpdateCoverContainer 00");
            this.ddQ = new FrameLayout(this.ddR);
            return this.akG.a(this.ddQ, GI);
        }
        BdLog.d("insertOrUpdateCoverContainer 01");
        return this.akG.a(GI);
    }

    private void c(a aVar) {
        BdLog.d("initVideoCoverContainer 00");
        b(aVar);
    }

    private boolean d(a aVar) {
        if (this.ddK == null) {
            return false;
        }
        return (this.ddK.ddB == aVar.ddB && this.ddK.ddD == aVar.ddD && this.ddK.ddE == aVar.ddE && TextUtils.equals(this.ddK.ddF, aVar.ddF) && TextUtils.equals(this.ddK.aCA, aVar.aCA)) ? false : true;
    }

    public void e(@NonNull a aVar) {
        BdLog.d("updatePlayerConfig params: " + aVar.toString());
        if (d(aVar)) {
            this.ddK = aVar;
            aEQ();
        }
        this.ddK = aVar;
        c(this.ddK);
    }

    public boolean isPlaying() {
        if (this.ddL != null) {
            return this.ddP;
        }
        return false;
    }

    public void stop() {
        if (this.ddL != null) {
            this.ddL.stop();
            this.ddL.destroy();
            this.ddL.a(null);
            this.ddL = null;
            this.ddP = false;
        }
    }

    public void j(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.SE = z;
        int af = l.af(this.ddR);
        int ah = l.ah(this.ddR);
        if (z) {
            if (i == 90 || i == -90) {
                this.ddO.bIl();
                af = ah;
                ah = af;
            }
        } else if (this.ddR.getRequestedOrientation() != 1) {
            this.ddO.bIl();
        }
        if (z) {
            a(this.ddR, i, af, ah);
        } else {
            f(this.ddR, i);
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
            if (this.ddL != null && this.ddL.Zm().getParent() != null) {
                ((ViewGroup) this.ddL.Zm().getParent()).removeView(this.ddL.Zm());
            }
            this.ddQ.addView(this.ddL.Zm(), new LinearLayout.LayoutParams(i2, i3));
            this.akG.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void f(Activity activity, int i) {
        if (activity == null || this.ddK == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.SE = false;
        if (this.akG != null && this.akG.getParent() != null) {
            ((ViewGroup) this.akG.getParent()).removeView(this.akG);
        }
        if (this.ddL != null && this.ddL.Zm().getParent() != null) {
            ((ViewGroup) this.ddL.Zm().getParent()).removeView(this.ddL.Zm());
        }
        int width = this.ddK.aDo.getWidth();
        int height = this.ddK.aDo.getHeight();
        this.ddK.aDo.getLeft();
        this.ddK.aDo.getTop();
        this.ddQ.addView(this.ddL.Zm(), new LinearLayout.LayoutParams(width, height));
        this.akG.Ps();
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aES() {
        String GG = this.ddN.GG();
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
