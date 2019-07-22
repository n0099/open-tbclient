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
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
import com.baidu.tbadk.ala.AlaLivePlayerData;
import com.baidu.tbadk.ala.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.play.o;
import org.apache.http.HttpHost;
/* loaded from: classes4.dex */
public class f implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean SY;
    private String aBc;
    private SwanAppNAViewContainer alj;
    private com.baidu.tbadk.ala.d dfo;
    private d.a dfp;
    private com.baidu.tieba.aiapps.apps.media.video.view.a dfr;
    private com.baidu.tieba.aiapps.apps.media.video.b dfs;
    private o dft;
    private FrameLayout dfv;
    private Activity dfw;
    private boolean mDetached;
    CustomMessageListener mNetworkChangedListener;
    private a dfm = a.aGe();
    private int dfn = 0;
    private com.baidu.tieba.aiapps.apps.media.b.a.a dfq = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean dfu = false;
    private String dfx = "AiAppLiveErr";

    public f(Context context, String str) {
        this.aBc = str;
        this.dfw = (Activity) context;
        if (!TextUtils.isEmpty(this.aBc)) {
            com.baidu.swan.apps.media.b.a(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.aBc);
        this.alj = new SwanAppNAViewContainer(context);
        this.dfp = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.f.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + " " + i3);
                f.this.dfq.mVideoWidth = i2;
                f.this.dfq.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && f.this.dfq != null) {
                    if (alaLivePlayerData.fpsAvg != f.this.dfq.dfz) {
                        f.this.mM(940);
                    }
                    if (alaLivePlayerData.videoBitrate != f.this.dfq.afh) {
                        f.this.mM(939);
                    }
                    if (alaLivePlayerData.audioBitrate != f.this.dfq.afn) {
                        f.this.mM(938);
                    }
                    f.this.dfq.dfA = (int) alaLivePlayerData.bandWidth;
                    f.this.dfq.dfz = (int) alaLivePlayerData.fpsAvg;
                    f.this.dfq.afn = (int) alaLivePlayerData.audioBitrate;
                    f.this.dfq.afh = (int) alaLivePlayerData.videoBitrate;
                }
            }
        };
        this.mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.aiapps.apps.media.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    f.this.aGl();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        this.dft = new o(this.dfw);
        this.dft.start();
        this.dfw.getWindow().addFlags(128);
        this.dfr = new com.baidu.tieba.aiapps.apps.media.video.view.a((Activity) context, false);
        this.dfs = new com.baidu.tieba.aiapps.apps.media.video.b(context);
        this.dfr.e(this.dfs.aGz());
    }

    public a aGg() {
        return this.dfm;
    }

    public void a(a aVar) {
        this.dfm = aVar;
        if (!this.dfm.hidden && this.dfm.aBl) {
            start();
        }
    }

    public void start() {
        if (this.dfm != null) {
            if (this.dfm.hidden) {
                BdLog.d("mPlayerId = " + this.aBc + "can not start(), hide = " + this.dfm.hidden);
                return;
            }
            BdLog.d(this.aBc + " start()");
            if (this.dfn == 0) {
                this.dfn = tj(this.dfm.mSrc);
            }
            if (this.dfn == 0) {
                BdLog.e("unsupport  url type error src = " + this.dfm.mSrc);
                return;
            }
            if (this.dfo != null) {
                aGh();
            }
            d(this.dfm);
            c(this.dfm.mSrc, "", "", false);
            if (this.dfn == 1) {
                aGk();
            } else if (this.dfn == 2) {
                aGj();
            }
            this.mDetached = false;
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String GM() {
        return this.aBc;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dfm.aDU;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object GO() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bw(boolean z) {
        BdLog.d("onForegroundChanged " + z);
        if (this.dfr != null && this.dfn == 2) {
            if (z) {
                this.dfr.bLc();
            } else {
                this.dfr.pausePlay();
            }
        }
        if (this.dfo != null && this.dfn == 1) {
            if (z) {
                this.dfo.stop();
                br(this.dfo.aal());
                this.dfo.destroy();
                this.dfo = null;
                return;
            }
            aGk();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bx(boolean z) {
        BdLog.d("onAppForegroundChanged " + z);
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        BdLog.d("onBackPressed ");
        if (this.dfn == 1) {
            if (this.dfm != null && this.alj != null && d(this.dfw, this.alj)) {
                if (this.dfw.getRequestedOrientation() != 1) {
                    this.dft.bKT();
                }
                f(this.dfw, 0);
                return true;
            }
        } else if (this.dfn == 2 && this.dfm != null && this.dfs != null && d(this.dfw, this.dfs.aGz())) {
            if (this.dfw.getRequestedOrientation() != 1) {
                this.dft.bKT();
            }
            f(this.dfw, 0);
            return true;
        }
        release();
        return false;
    }

    public void aGh() {
        if (this.dfo != null) {
            this.dfo.stop();
            br(this.dfo.aal());
            this.dfo.destroy();
        }
        this.dfo = null;
        if (this.dfr != null) {
            this.dfr.stopPlay();
            this.dfr.destroy();
            br(this.dfr.cdO());
        }
        this.dfr = null;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.aBc + " release()");
        this.dfw.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        com.baidu.swan.apps.media.b.b(this);
        this.dft.stop();
        if (this.dfo != null) {
            this.dfo.stop();
            this.dfo.destroy();
            this.dfo = null;
        }
        if (this.dfr != null) {
            this.dfr.stopPlay();
            this.dfr.aGh();
            this.dfr.destroy();
            this.dfr = null;
        }
    }

    private void aGi() {
        br(this.dfm.dfd);
        mK(this.dfm.dff);
        mL(this.dfm.dfg);
        if (TextUtils.equals(this.dfm.dfh, "horizontal")) {
            setVideoRotation(90);
        } else {
            setVideoRotation(0);
        }
        if (TextUtils.equals(this.dfm.aDi, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void br(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.dfo != null) {
            this.dfo.setAudioMute(z);
        }
        if (this.dfr != null) {
            this.dfr.setMuted(z);
        }
    }

    public void mK(int i) {
    }

    public void mL(int i) {
    }

    public void setVideoRotation(int i) {
    }

    private void setVideoScalingMode(int i) {
        BdLog.d("setVideoScalingMode scalingMode: " + i);
        if (this.dfo != null) {
            this.dfo.setRenderVideoModel(1, i != 2 ? 1 : 2);
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

    private boolean aGj() {
        boolean z;
        int i;
        int i2 = 0;
        if (this.dfn != 2 || this.dfr == null || this.dfv == null) {
            return false;
        }
        View cdO = this.dfr.cdO();
        if (cdO != null && cdO.getParent() == null) {
            this.dfv.addView(cdO);
        }
        this.dfr.cs(this.dfm.mSrc, "");
        this.dfu = true;
        if (this.dfv != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.dfv.getChildCount()) {
                    z = false;
                    break;
                } else if (this.dfv.getChildAt(i3) == this.dfr.cdO()) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.dfm.aDW != null) {
                    i = this.dfm.aDW.getWidth();
                    i2 = this.dfm.aDW.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.dfx, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.dfm.toString(), "position", this.dfm.aDW == null ? "null" : this.dfm.aDW.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                }
                this.dfv.addView(this.dfo.aal(), new LinearLayout.LayoutParams(i, i2));
            }
        }
        return true;
    }

    private boolean aGk() {
        boolean z;
        int i;
        int i2;
        CustomResponsedMessage runTask;
        if (this.dfn != 1) {
            return false;
        }
        if (this.dfo == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.dfw)) != null && runTask.getData() != null) {
            this.dfo = (com.baidu.tbadk.ala.d) runTask.getData();
            this.dfo.a(this.dfp);
        }
        if (this.dfo != null) {
            if (this.dfo.a(1, this.dfm.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
                this.dfu = true;
            }
            if (this.dfv != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= this.dfv.getChildCount()) {
                        z = false;
                        break;
                    } else if (this.dfv.getChildAt(i3) == this.dfo.aal()) {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!z) {
                    if (this.dfm.aDW != null) {
                        i2 = this.dfm.aDW.getWidth();
                        i = this.dfm.aDW.getHeight();
                    } else {
                        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.dfx, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.dfm.toString(), "position", this.dfm.aDW == null ? "null" : this.dfm.aDW.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                        i = 0;
                        i2 = 0;
                    }
                    this.dfv.addView(this.dfo.aal(), new LinearLayout.LayoutParams(i2, i));
                    if (TextUtils.equals(this.dfm.aDi, "contain")) {
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
        if (this.alj == null) {
            return false;
        }
        if (this.SY) {
            this.alj.setHidden(aVar.hidden);
            return true;
        }
        com.baidu.swan.apps.model.a.a.a Hs = aVar.Hs();
        Hs.id = this.aBc;
        Hs.aDU = this.dfm.aDU;
        Hs.aDV = aVar.aDV;
        if (com.baidu.swan.apps.view.container.c.b.a(Hs.aDU, this.aBc, com.baidu.swan.apps.view.container.c.c.iD(Hs.aDU)) == null) {
            BdLog.d("insertOrUpdateCoverContainer 00");
            this.dfv = new FrameLayout(this.dfw);
            return this.alj.a(this.dfv, Hs);
        }
        BdLog.d("insertOrUpdateCoverContainer 01");
        return this.alj.a(Hs);
    }

    private boolean c(a aVar) {
        if (this.dfs == null || this.dfs.aGz() == null) {
            return false;
        }
        com.baidu.swan.apps.model.a.a.a Hs = aVar.Hs();
        Hs.id = this.aBc;
        Hs.aDU = this.dfm.aDU;
        Hs.aDV = aVar.aDV;
        if (com.baidu.swan.apps.view.container.c.b.a(Hs.aDU, this.aBc, com.baidu.swan.apps.view.container.c.c.iD(Hs.aDU)) == null) {
            BdLog.d("insertOrUpdateCoverContainer 00");
            this.dfv = new FrameLayout(this.dfw);
            return this.dfs.aGz().a(this.dfv, Hs);
        }
        BdLog.d("insertOrUpdateCoverContainer 01");
        return this.dfs.aGz().a(Hs);
    }

    private void d(a aVar) {
        BdLog.d("initVideoCoverContainer 00");
        if (this.dfn == 1) {
            b(aVar);
        } else if (this.dfn == 2) {
            c(aVar);
        }
    }

    private boolean e(a aVar) {
        if (this.dfm == null) {
            return false;
        }
        return (this.dfm.dfd == aVar.dfd && this.dfm.dff == aVar.dff && this.dfm.dfg == aVar.dfg && TextUtils.equals(this.dfm.dfh, aVar.dfh) && TextUtils.equals(this.dfm.aDi, aVar.aDi)) ? false : true;
    }

    public void f(@NonNull a aVar) {
        BdLog.d("updatePlayerConfig params: " + aVar.toString());
        if (e(aVar)) {
            this.dfm = aVar;
            aGi();
        }
        this.dfm = aVar;
        d(this.dfm);
    }

    public boolean isPlaying() {
        if (this.dfn == 1 && this.dfo != null) {
            return this.dfu;
        }
        if (this.dfn == 2 && this.dfr != null) {
            return this.dfr.pB();
        }
        return false;
    }

    public void stop() {
        if (this.dfo != null) {
            this.dfo.stop();
            this.dfo.destroy();
            this.dfo.a(null);
            this.dfo = null;
            this.dfu = false;
        }
        if (this.dfr != null) {
            this.dfr.stopPlay();
            this.dfr.aGh();
            this.dfr.destroy();
            this.dfu = false;
            this.dfr = null;
        }
    }

    public void j(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.SY = z;
        int af = l.af(this.dfw);
        int ah = l.ah(this.dfw);
        if (z) {
            if (i == 90 || i == -90) {
                this.dft.bKT();
                af = ah;
                ah = af;
            }
        } else if (this.dfw.getRequestedOrientation() != 1) {
            this.dft.bKT();
        }
        if (z) {
            a(this.dfw, i, af, ah);
        } else {
            f(this.dfw, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null) {
            this.SY = true;
            if (this.alj != null && this.alj.getParent() != null) {
                ((ViewGroup) this.alj.getParent()).removeView(this.alj);
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.alj);
                viewGroup.addView(this.alj);
            }
            if (this.dfo != null && this.dfo.aal().getParent() != null) {
                ((ViewGroup) this.dfo.aal().getParent()).removeView(this.dfo.aal());
            }
            this.dfv.addView(this.dfo.aal(), new LinearLayout.LayoutParams(i2, i3));
            this.alj.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void f(Activity activity, int i) {
        if (activity == null || this.dfm == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.SY = false;
        if (this.dfn == 1) {
            if (this.alj != null && this.alj.getParent() != null) {
                ((ViewGroup) this.alj.getParent()).removeView(this.alj);
            }
            if (this.dfo != null && this.dfo.aal().getParent() != null) {
                ((ViewGroup) this.dfo.aal().getParent()).removeView(this.dfo.aal());
            }
            int width = this.dfm.aDW.getWidth();
            int height = this.dfm.aDW.getHeight();
            this.dfm.aDW.getLeft();
            this.dfm.aDW.Hv();
            this.dfv.addView(this.dfo.aal(), new LinearLayout.LayoutParams(width, height));
            this.alj.Qj();
        } else if (this.dfn == 2) {
            SwanAppNAViewContainer aGz = this.dfs.aGz();
            View cdO = this.dfr.cdO();
            if (aGz != null && aGz.getParent() != null) {
                ((ViewGroup) aGz.getParent()).removeView(aGz);
            }
            if (cdO != null && cdO.getParent() != null) {
                ((ViewGroup) cdO.getParent()).removeView(cdO);
            }
            int width2 = this.dfm.aDW.getWidth();
            int height2 = this.dfm.aDW.getHeight();
            this.dfm.aDW.getLeft();
            this.dfm.aDW.Hv();
            this.dfv.addView(cdO, new LinearLayout.LayoutParams(width2, height2));
            aGz.Qj();
        }
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGl() {
        String Hq = this.dfq.Hq();
        if (!TextUtils.isEmpty(Hq)) {
            BdLog.d(this.aBc + " dispatchNetStatusEvent statusData: " + Hq);
            c.J(getSlaveId(), GM(), Hq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mM(int i) {
        int mI = b.mI(i);
        BdLog.d(this.aBc + " dispatchStatusIfNeeded what: " + i + " liveStatusCode:" + mI);
        if (mI != 100) {
            if (mI == 2101) {
                c.I(getSlaveId(), GM(), b.mJ(2102));
            }
            c.I(getSlaveId(), GM(), b.mJ(mI));
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String GN() {
        return null;
    }

    private static int tj(String str) {
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
