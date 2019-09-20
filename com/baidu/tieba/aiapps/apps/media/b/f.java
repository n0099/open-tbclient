package com.baidu.tieba.aiapps.apps.media.b;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
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
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
import com.baidu.tbadk.ala.AlaLivePlayerData;
import com.baidu.tbadk.ala.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.play.o;
import org.apache.http.HttpHost;
/* loaded from: classes4.dex */
public class f implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean SX;
    private String aBA;
    private SwanAppNAViewContainer alI;
    private com.baidu.tbadk.ala.d dhg;
    private d.a dhh;
    private com.baidu.tieba.aiapps.apps.media.video.view.a dhj;
    private com.baidu.tieba.aiapps.apps.media.video.b dhk;
    private o dhl;
    private FrameLayout dhn;
    private Activity dho;
    private boolean mDetached;
    CustomMessageListener mNetworkChangedListener;
    private a dhe = a.aGK();
    private int dhf = 0;
    private com.baidu.tieba.aiapps.apps.media.b.a.a dhi = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean dhm = false;
    private String dhp = "AiAppLiveErr";

    public f(Context context, String str) {
        this.aBA = str;
        this.dho = (Activity) context;
        if (!TextUtils.isEmpty(this.aBA)) {
            com.baidu.swan.apps.media.b.a(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.aBA);
        this.alI = new SwanAppNAViewContainer(context);
        this.dhh = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.f.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + " " + i3);
                f.this.dhi.mVideoWidth = i2;
                f.this.dhi.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && f.this.dhi != null) {
                    if (alaLivePlayerData.fpsAvg != f.this.dhi.dhr) {
                        f.this.mR(CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE);
                    }
                    if (alaLivePlayerData.videoBitrate != f.this.dhi.afh) {
                        f.this.mR(CyberPlayerManager.MEDIA_INFO_VIDEO_BITRATE);
                    }
                    if (alaLivePlayerData.audioBitrate != f.this.dhi.afn) {
                        f.this.mR(CyberPlayerManager.MEDIA_INFO_AUDIO_BITRATE);
                    }
                    f.this.dhi.dhs = (int) alaLivePlayerData.bandWidth;
                    f.this.dhi.dhr = (int) alaLivePlayerData.fpsAvg;
                    f.this.dhi.afn = (int) alaLivePlayerData.audioBitrate;
                    f.this.dhi.afh = (int) alaLivePlayerData.videoBitrate;
                }
            }
        };
        this.mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.aiapps.apps.media.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    f.this.aGR();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        this.dhl = new o(this.dho);
        this.dhl.start();
        this.dho.getWindow().addFlags(128);
        this.dhj = new com.baidu.tieba.aiapps.apps.media.video.view.a((Activity) context, false);
        this.dhk = new com.baidu.tieba.aiapps.apps.media.video.b(context);
        this.dhj.e(this.dhk.aHf());
    }

    public a aGM() {
        return this.dhe;
    }

    public void a(a aVar) {
        this.dhe = aVar;
        if (!this.dhe.hidden && this.dhe.aBJ) {
            start();
        }
    }

    public void start() {
        if (this.dhe != null) {
            if (this.dhe.hidden) {
                BdLog.d("mPlayerId = " + this.aBA + "can not start(), hide = " + this.dhe.hidden);
                return;
            }
            BdLog.d(this.aBA + " start()");
            if (this.dhf == 0) {
                this.dhf = tI(this.dhe.mSrc);
            }
            if (this.dhf == 0) {
                BdLog.e("unsupport  url type error src = " + this.dhe.mSrc);
                return;
            }
            if (this.dhg != null) {
                aGN();
            }
            d(this.dhe);
            c(this.dhe.mSrc, "", "", false);
            if (this.dhf == 1) {
                aGQ();
            } else if (this.dhf == 2) {
                aGP();
            }
            this.mDetached = false;
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String GQ() {
        return this.aBA;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dhe.aEs;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object GS() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bw(boolean z) {
        BdLog.d("onForegroundChanged " + z);
        if (this.dhj != null && this.dhf == 2) {
            if (z) {
                this.dhj.bMd();
            } else {
                this.dhj.pausePlay();
            }
        }
        if (this.dhg != null && this.dhf == 1) {
            if (z) {
                this.dhg.stop();
                br(this.dhg.aap());
                this.dhg.destroy();
                this.dhg = null;
                return;
            }
            aGQ();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bx(boolean z) {
        BdLog.d("onAppForegroundChanged " + z);
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        BdLog.d("onBackPressed ");
        if (this.dhf == 1) {
            if (this.dhe != null && this.alI != null && d(this.dho, this.alI)) {
                if (this.dho.getRequestedOrientation() != 1) {
                    this.dhl.bLU();
                }
                g(this.dho, 0);
                return true;
            }
        } else if (this.dhf == 2 && this.dhe != null && this.dhk != null && d(this.dho, this.dhk.aHf())) {
            if (this.dho.getRequestedOrientation() != 1) {
                this.dhl.bLU();
            }
            g(this.dho, 0);
            return true;
        }
        release();
        return false;
    }

    public void aGN() {
        if (this.dhg != null) {
            this.dhg.stop();
            br(this.dhg.aap());
            this.dhg.destroy();
        }
        this.dhg = null;
        if (this.dhj != null) {
            this.dhj.stopPlay();
            this.dhj.destroy();
            br(this.dhj.ceV());
        }
        this.dhj = null;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.aBA + " release()");
        this.dho.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        com.baidu.swan.apps.media.b.b(this);
        this.dhl.stop();
        if (this.dhg != null) {
            this.dhg.stop();
            this.dhg.destroy();
            this.dhg = null;
        }
        if (this.dhj != null) {
            this.dhj.stopPlay();
            this.dhj.aGN();
            this.dhj.destroy();
            this.dhj = null;
        }
    }

    private void aGO() {
        br(this.dhe.dgV);
        mP(this.dhe.dgX);
        mQ(this.dhe.dgY);
        if (TextUtils.equals(this.dhe.dgZ, "horizontal")) {
            setVideoRotation(90);
        } else {
            setVideoRotation(0);
        }
        if (TextUtils.equals(this.dhe.aDG, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void br(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.dhg != null) {
            this.dhg.setAudioMute(z);
        }
        if (this.dhj != null) {
            this.dhj.setMuted(z);
        }
    }

    public void mP(int i) {
    }

    public void mQ(int i) {
    }

    public void setVideoRotation(int i) {
    }

    private void setVideoScalingMode(int i) {
        BdLog.d("setVideoScalingMode scalingMode: " + i);
        if (this.dhg != null) {
            this.dhg.setRenderVideoModel(1, i != 2 ? 1 : 2);
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

    private boolean aGP() {
        boolean z;
        int i;
        int i2 = 0;
        if (this.dhf != 2 || this.dhj == null || this.dhn == null) {
            return false;
        }
        View ceV = this.dhj.ceV();
        if (ceV != null && ceV.getParent() == null) {
            this.dhn.addView(ceV);
        }
        this.dhj.ct(this.dhe.mSrc, "");
        this.dhm = true;
        if (this.dhn != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.dhn.getChildCount()) {
                    z = false;
                    break;
                } else if (this.dhn.getChildAt(i3) == this.dhj.ceV()) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.dhe.aEu != null) {
                    i = this.dhe.aEu.getWidth();
                    i2 = this.dhe.aEu.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.dhp, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.dhe.toString(), "position", this.dhe.aEu == null ? "null" : this.dhe.aEu.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                }
                this.dhn.addView(this.dhg.aap(), new LinearLayout.LayoutParams(i, i2));
            }
        }
        return true;
    }

    private boolean aGQ() {
        boolean z;
        int i;
        int i2;
        CustomResponsedMessage runTask;
        if (this.dhf != 1) {
            return false;
        }
        if (this.dhg == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.dho)) != null && runTask.getData() != null) {
            this.dhg = (com.baidu.tbadk.ala.d) runTask.getData();
            this.dhg.a(this.dhh);
        }
        if (this.dhg != null) {
            if (this.dhg.a(1, this.dhe.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
                this.dhm = true;
            }
            if (this.dhn != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= this.dhn.getChildCount()) {
                        z = false;
                        break;
                    } else if (this.dhn.getChildAt(i3) == this.dhg.aap()) {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!z) {
                    if (this.dhe.aEu != null) {
                        i2 = this.dhe.aEu.getWidth();
                        i = this.dhe.aEu.getHeight();
                    } else {
                        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.dhp, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.dhe.toString(), "position", this.dhe.aEu == null ? "null" : this.dhe.aEu.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                        i = 0;
                        i2 = 0;
                    }
                    this.dhn.addView(this.dhg.aap(), new LinearLayout.LayoutParams(i2, i));
                    if (TextUtils.equals(this.dhe.aDG, "contain")) {
                        setVideoScalingMode(2);
                    } else {
                        setVideoScalingMode(0);
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean b(a aVar) {
        if (this.alI == null) {
            return false;
        }
        if (this.SX) {
            this.alI.setHidden(aVar.hidden);
            return true;
        }
        com.baidu.swan.apps.model.a.a.a Hw = aVar.Hw();
        Hw.id = this.aBA;
        Hw.aEs = this.dhe.aEs;
        Hw.aEt = aVar.aEt;
        if (com.baidu.swan.apps.view.container.c.b.a(Hw.aEs, this.aBA, com.baidu.swan.apps.view.container.c.c.iF(Hw.aEs)) == null) {
            BdLog.d("insertOrUpdateCoverContainer 00");
            this.dhn = new FrameLayout(this.dho);
            return this.alI.a(this.dhn, Hw);
        }
        BdLog.d("insertOrUpdateCoverContainer 01");
        return this.alI.a(Hw);
    }

    private boolean c(a aVar) {
        if (this.dhk == null || this.dhk.aHf() == null) {
            return false;
        }
        com.baidu.swan.apps.model.a.a.a Hw = aVar.Hw();
        Hw.id = this.aBA;
        Hw.aEs = this.dhe.aEs;
        Hw.aEt = aVar.aEt;
        if (com.baidu.swan.apps.view.container.c.b.a(Hw.aEs, this.aBA, com.baidu.swan.apps.view.container.c.c.iF(Hw.aEs)) == null) {
            BdLog.d("insertOrUpdateCoverContainer 00");
            this.dhn = new FrameLayout(this.dho);
            return this.dhk.aHf().a(this.dhn, Hw);
        }
        BdLog.d("insertOrUpdateCoverContainer 01");
        return this.dhk.aHf().a(Hw);
    }

    private void d(a aVar) {
        BdLog.d("initVideoCoverContainer 00");
        if (this.dhf == 1) {
            b(aVar);
        } else if (this.dhf == 2) {
            c(aVar);
        }
    }

    private boolean e(a aVar) {
        if (this.dhe == null) {
            return false;
        }
        return (this.dhe.dgV == aVar.dgV && this.dhe.dgX == aVar.dgX && this.dhe.dgY == aVar.dgY && TextUtils.equals(this.dhe.dgZ, aVar.dgZ) && TextUtils.equals(this.dhe.aDG, aVar.aDG)) ? false : true;
    }

    public void f(@NonNull a aVar) {
        BdLog.d("updatePlayerConfig params: " + aVar.toString());
        if (e(aVar)) {
            this.dhe = aVar;
            aGO();
        }
        this.dhe = aVar;
        d(this.dhe);
    }

    public boolean isPlaying() {
        if (this.dhf == 1 && this.dhg != null) {
            return this.dhm;
        }
        if (this.dhf == 2 && this.dhj != null) {
            return this.dhj.pC();
        }
        return false;
    }

    public void stop() {
        if (this.dhg != null) {
            this.dhg.stop();
            this.dhg.destroy();
            this.dhg.a(null);
            this.dhg = null;
            this.dhm = false;
        }
        if (this.dhj != null) {
            this.dhj.stopPlay();
            this.dhj.aGN();
            this.dhj.destroy();
            this.dhm = false;
            this.dhj = null;
        }
    }

    public void j(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.SX = z;
        int af = l.af(this.dho);
        int ah = l.ah(this.dho);
        if (z) {
            if (i == 90 || i == -90) {
                this.dhl.bLU();
                af = ah;
                ah = af;
            }
        } else if (this.dho.getRequestedOrientation() != 1) {
            this.dhl.bLU();
        }
        if (z) {
            a(this.dho, i, af, ah);
        } else {
            g(this.dho, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null) {
            this.SX = true;
            if (this.alI != null && this.alI.getParent() != null) {
                ((ViewGroup) this.alI.getParent()).removeView(this.alI);
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.alI);
                viewGroup.addView(this.alI);
            }
            if (this.dhg != null && this.dhg.aap().getParent() != null) {
                ((ViewGroup) this.dhg.aap().getParent()).removeView(this.dhg.aap());
            }
            this.dhn.addView(this.dhg.aap(), new LinearLayout.LayoutParams(i2, i3));
            this.alI.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void g(Activity activity, int i) {
        if (activity == null || this.dhe == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.SX = false;
        if (this.dhf == 1) {
            if (this.alI != null && this.alI.getParent() != null) {
                ((ViewGroup) this.alI.getParent()).removeView(this.alI);
            }
            if (this.dhg != null && this.dhg.aap().getParent() != null) {
                ((ViewGroup) this.dhg.aap().getParent()).removeView(this.dhg.aap());
            }
            int width = this.dhe.aEu.getWidth();
            int height = this.dhe.aEu.getHeight();
            this.dhe.aEu.getLeft();
            this.dhe.aEu.Hz();
            this.dhn.addView(this.dhg.aap(), new LinearLayout.LayoutParams(width, height));
            this.alI.Qn();
        } else if (this.dhf == 2) {
            SwanAppNAViewContainer aHf = this.dhk.aHf();
            View ceV = this.dhj.ceV();
            if (aHf != null && aHf.getParent() != null) {
                ((ViewGroup) aHf.getParent()).removeView(aHf);
            }
            if (ceV != null && ceV.getParent() != null) {
                ((ViewGroup) ceV.getParent()).removeView(ceV);
            }
            int width2 = this.dhe.aEu.getWidth();
            int height2 = this.dhe.aEu.getHeight();
            this.dhe.aEu.getLeft();
            this.dhe.aEu.Hz();
            this.dhn.addView(ceV, new LinearLayout.LayoutParams(width2, height2));
            aHf.Qn();
        }
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGR() {
        String Hu = this.dhi.Hu();
        if (!TextUtils.isEmpty(Hu)) {
            BdLog.d(this.aBA + " dispatchNetStatusEvent statusData: " + Hu);
            c.L(getSlaveId(), GQ(), Hu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mR(int i) {
        int mN = b.mN(i);
        BdLog.d(this.aBA + " dispatchStatusIfNeeded what: " + i + " liveStatusCode:" + mN);
        if (mN != 100) {
            if (mN == 2101) {
                c.K(getSlaveId(), GQ(), b.mO(2102));
            }
            c.K(getSlaveId(), GQ(), b.mO(mN));
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String GR() {
        return null;
    }

    private static int tI(String str) {
        Uri parse;
        if (str == null || str.length() < 5) {
            return 0;
        }
        try {
            parse = Uri.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (parse.getScheme().compareToIgnoreCase("rtmp") != 0) {
            if (parse.getScheme().compareToIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME) == 0 && parse.getPath().contains("flv")) {
                return 1;
            }
            if (parse.getScheme().compareToIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME) == 0) {
                if (parse.getPath().contains("m3u8")) {
                    return 2;
                }
            }
            return 0;
        }
        return 1;
    }

    private static void br(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }
}
