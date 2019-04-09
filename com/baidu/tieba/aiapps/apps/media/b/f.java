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
    private boolean UU;
    private SwanAppNAViewContainer aku;
    private String azw;
    private com.baidu.tbadk.ala.d cVo;
    private d.a cVp;
    private o cVr;
    private FrameLayout cVt;
    private Activity cVu;
    private boolean mDetached;
    CustomMessageListener mNetworkChangedListener;
    private a cVn = a.azu();
    private com.baidu.tieba.aiapps.apps.media.b.a.a cVq = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean cVs = false;
    private String cVv = "AiAppLiveErr";

    public f(Context context, String str) {
        this.azw = str;
        this.cVu = (Activity) context;
        if (!TextUtils.isEmpty(this.azw)) {
            com.baidu.swan.apps.media.b.a(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.azw);
        this.aku = new SwanAppNAViewContainer(context);
        this.cVp = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.f.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + " " + i3);
                f.this.cVq.mVideoWidth = i2;
                f.this.cVq.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && f.this.cVq != null) {
                    if (alaLivePlayerData.fpsAvg != f.this.cVq.cVz) {
                        f.this.lT(940);
                    }
                    if (alaLivePlayerData.videoBitrate != f.this.cVq.cVx) {
                        f.this.lT(939);
                    }
                    if (alaLivePlayerData.audioBitrate != f.this.cVq.cVy) {
                        f.this.lT(938);
                    }
                    f.this.cVq.cVA = (int) alaLivePlayerData.bandWidth;
                    f.this.cVq.cVz = (int) alaLivePlayerData.fpsAvg;
                    f.this.cVq.cVy = (int) alaLivePlayerData.audioBitrate;
                    f.this.cVq.cVx = (int) alaLivePlayerData.videoBitrate;
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
        this.cVr = new o(this.cVu);
        this.cVr.start();
        this.cVu.getWindow().addFlags(128);
    }

    public a azw() {
        return this.cVn;
    }

    public void a(a aVar) {
        this.cVn = aVar;
        if (!this.cVn.hidden && this.cVn.azG) {
            start();
        }
    }

    public void start() {
        if (this.cVn != null) {
            if (this.cVn.hidden) {
                BdLog.d("mPlayerId = " + this.azw + "can not start(), hide = " + this.cVn.hidden);
                return;
            }
            BdLog.d(this.azw + " start()");
            if (this.cVo != null) {
                azx();
            }
            azy();
            c(this.cVn);
            c(this.cVn.mSrc, "", "", false);
            azz();
            this.mDetached = false;
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String Eg() {
        return this.azw;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.cVn.aBH;
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
        if (this.cVn != null && this.aku != null && d(this.cVu, this.aku)) {
            if (this.cVu.getRequestedOrientation() != 1) {
                this.cVr.bAy();
            }
            f(this.cVu, 0);
            return true;
        }
        release();
        return false;
    }

    public void azx() {
        if (this.cVo != null) {
            this.cVo.stop();
            this.cVo.destroy();
        }
        this.cVo = null;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.azw + " release()");
        this.cVu.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        com.baidu.swan.apps.media.b.b(this);
        this.cVr.stop();
        if (this.cVo != null) {
            this.cVo.stop();
            this.cVo.destroy();
            this.cVo = null;
        }
    }

    private void azy() {
        fY(this.cVn.cVc);
        lQ(this.cVn.cVe);
        lR(this.cVn.cVf);
        if (TextUtils.equals(this.cVn.cVg, "horizontal")) {
            lS(90);
        } else {
            lS(0);
        }
        if (TextUtils.equals(this.cVn.cVh, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void fY(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.cVo != null) {
            this.cVo.setAudioMute(z);
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
        if (this.cVo != null) {
            this.cVo.setRenderVideoModel(1, i != 2 ? 1 : 2);
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
        if (this.cVo == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.cVu)) != null && runTask.getData() != null) {
            this.cVo = (com.baidu.tbadk.ala.d) runTask.getData();
            this.cVo.a(this.cVp);
        }
        if (this.cVo == null) {
            return false;
        }
        if (this.cVo.a(1, this.cVn.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
            this.cVs = true;
        }
        if (this.cVt != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.cVt.getChildCount()) {
                    z = false;
                    break;
                } else if (this.cVt.getChildAt(i3) == this.cVo.UI()) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.cVn.aBJ != null) {
                    i2 = this.cVn.aBJ.getWidth();
                    i = this.cVn.aBJ.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.cVv, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.cVn.toString(), "position", this.cVn.aBJ == null ? "null" : this.cVn.aBJ.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                    i2 = 0;
                }
                this.cVt.addView(this.cVo.UI(), new LinearLayout.LayoutParams(i2, i));
                if (TextUtils.equals(this.cVn.cVh, "contain")) {
                    setVideoScalingMode(2);
                } else {
                    setVideoScalingMode(0);
                }
            }
        }
        return true;
    }

    public boolean b(a aVar) {
        if (this.aku == null) {
            return false;
        }
        if (this.UU) {
            this.aku.setHidden(aVar.hidden);
            return true;
        }
        com.baidu.swan.apps.model.a.a.a EK = aVar.EK();
        EK.id = this.azw;
        EK.aBH = this.cVn.aBH;
        EK.aBI = aVar.aBI;
        if (com.baidu.swan.apps.view.container.c.b.a(EK.aBH, this.azw, com.baidu.swan.apps.view.container.c.c.hS(EK.aBH)) == null) {
            BdLog.d("insertOrUpdateCoverContainer 00");
            this.cVt = new FrameLayout(this.cVu);
            return this.aku.a(this.cVt, EK);
        }
        BdLog.d("insertOrUpdateCoverContainer 01");
        return this.aku.a(EK);
    }

    private void c(a aVar) {
        BdLog.d("initVideoCoverContainer 00");
        b(aVar);
    }

    private boolean d(a aVar) {
        if (this.cVn == null) {
            return false;
        }
        return (this.cVn.cVc == aVar.cVc && this.cVn.cVe == aVar.cVe && this.cVn.cVf == aVar.cVf && TextUtils.equals(this.cVn.cVg, aVar.cVg) && TextUtils.equals(this.cVn.cVh, aVar.cVh)) ? false : true;
    }

    public void e(@NonNull a aVar) {
        BdLog.d("updatePlayerConfig params: " + aVar.toString());
        if (d(aVar)) {
            this.cVn = aVar;
            azy();
        }
        this.cVn = aVar;
        c(this.cVn);
    }

    public boolean isPlaying() {
        if (this.cVo != null) {
            return this.cVs;
        }
        return false;
    }

    public void stop() {
        if (this.cVo != null) {
            this.cVo.stop();
            this.cVo.destroy();
            this.cVo.a(null);
            this.cVo = null;
            this.cVs = false;
        }
    }

    public void j(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.UU = z;
        int aO = l.aO(this.cVu);
        int aQ = l.aQ(this.cVu);
        if (z) {
            if (i == 90 || i == -90) {
                this.cVr.bAy();
                aO = aQ;
                aQ = aO;
            }
        } else if (this.cVu.getRequestedOrientation() != 1) {
            this.cVr.bAy();
        }
        if (z) {
            a(this.cVu, i, aO, aQ);
        } else {
            f(this.cVu, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null) {
            this.UU = true;
            if (this.aku != null && this.aku.getParent() != null) {
                ((ViewGroup) this.aku.getParent()).removeView(this.aku);
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.aku);
                viewGroup.addView(this.aku);
            }
            if (this.cVo != null && this.cVo.UI().getParent() != null) {
                ((ViewGroup) this.cVo.UI().getParent()).removeView(this.cVo.UI());
            }
            this.cVt.addView(this.cVo.UI(), new LinearLayout.LayoutParams(i2, i3));
            this.aku.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void f(Activity activity, int i) {
        if (activity == null || this.cVn == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.UU = false;
        if (this.aku != null && this.aku.getParent() != null) {
            ((ViewGroup) this.aku.getParent()).removeView(this.aku);
        }
        if (this.cVo != null && this.cVo.UI().getParent() != null) {
            ((ViewGroup) this.cVo.UI().getParent()).removeView(this.cVo.UI());
        }
        int width = this.cVn.aBJ.getWidth();
        int height = this.cVn.aBJ.getHeight();
        this.cVn.aBJ.getLeft();
        this.cVn.aBJ.getTop();
        this.cVt.addView(this.cVo.UI(), new LinearLayout.LayoutParams(width, height));
        this.aku.MJ();
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azA() {
        String EI = this.cVq.EI();
        if (!TextUtils.isEmpty(EI)) {
            BdLog.d(this.azw + " dispatchNetStatusEvent statusData: " + EI);
            c.J(getSlaveId(), Eg(), EI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lT(int i) {
        int lO = b.lO(i);
        BdLog.d(this.azw + " dispatchStatusIfNeeded what: " + i + " liveStatusCode:" + lO);
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
