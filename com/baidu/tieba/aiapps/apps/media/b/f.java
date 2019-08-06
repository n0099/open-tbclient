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
    private o dfA;
    private FrameLayout dfC;
    private Activity dfD;
    private com.baidu.tbadk.ala.d dfv;
    private d.a dfw;
    private com.baidu.tieba.aiapps.apps.media.video.view.a dfy;
    private com.baidu.tieba.aiapps.apps.media.video.b dfz;
    private boolean mDetached;
    CustomMessageListener mNetworkChangedListener;
    private a dft = a.aGg();
    private int dfu = 0;
    private com.baidu.tieba.aiapps.apps.media.b.a.a dfx = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean dfB = false;
    private String dfE = "AiAppLiveErr";

    public f(Context context, String str) {
        this.aBc = str;
        this.dfD = (Activity) context;
        if (!TextUtils.isEmpty(this.aBc)) {
            com.baidu.swan.apps.media.b.a(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.aBc);
        this.alj = new SwanAppNAViewContainer(context);
        this.dfw = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.f.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + " " + i3);
                f.this.dfx.mVideoWidth = i2;
                f.this.dfx.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && f.this.dfx != null) {
                    if (alaLivePlayerData.fpsAvg != f.this.dfx.dfG) {
                        f.this.mN(940);
                    }
                    if (alaLivePlayerData.videoBitrate != f.this.dfx.afh) {
                        f.this.mN(939);
                    }
                    if (alaLivePlayerData.audioBitrate != f.this.dfx.afn) {
                        f.this.mN(938);
                    }
                    f.this.dfx.dfH = (int) alaLivePlayerData.bandWidth;
                    f.this.dfx.dfG = (int) alaLivePlayerData.fpsAvg;
                    f.this.dfx.afn = (int) alaLivePlayerData.audioBitrate;
                    f.this.dfx.afh = (int) alaLivePlayerData.videoBitrate;
                }
            }
        };
        this.mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.aiapps.apps.media.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    f.this.aGn();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        this.dfA = new o(this.dfD);
        this.dfA.start();
        this.dfD.getWindow().addFlags(128);
        this.dfy = new com.baidu.tieba.aiapps.apps.media.video.view.a((Activity) context, false);
        this.dfz = new com.baidu.tieba.aiapps.apps.media.video.b(context);
        this.dfy.e(this.dfz.aGB());
    }

    public a aGi() {
        return this.dft;
    }

    public void a(a aVar) {
        this.dft = aVar;
        if (!this.dft.hidden && this.dft.aBl) {
            start();
        }
    }

    public void start() {
        if (this.dft != null) {
            if (this.dft.hidden) {
                BdLog.d("mPlayerId = " + this.aBc + "can not start(), hide = " + this.dft.hidden);
                return;
            }
            BdLog.d(this.aBc + " start()");
            if (this.dfu == 0) {
                this.dfu = tj(this.dft.mSrc);
            }
            if (this.dfu == 0) {
                BdLog.e("unsupport  url type error src = " + this.dft.mSrc);
                return;
            }
            if (this.dfv != null) {
                aGj();
            }
            d(this.dft);
            c(this.dft.mSrc, "", "", false);
            if (this.dfu == 1) {
                aGm();
            } else if (this.dfu == 2) {
                aGl();
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
        return this.dft.aDU;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object GO() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bw(boolean z) {
        BdLog.d("onForegroundChanged " + z);
        if (this.dfy != null && this.dfu == 2) {
            if (z) {
                this.dfy.bLq();
            } else {
                this.dfy.pausePlay();
            }
        }
        if (this.dfv != null && this.dfu == 1) {
            if (z) {
                this.dfv.stop();
                br(this.dfv.aal());
                this.dfv.destroy();
                this.dfv = null;
                return;
            }
            aGm();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bx(boolean z) {
        BdLog.d("onAppForegroundChanged " + z);
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        BdLog.d("onBackPressed ");
        if (this.dfu == 1) {
            if (this.dft != null && this.alj != null && d(this.dfD, this.alj)) {
                if (this.dfD.getRequestedOrientation() != 1) {
                    this.dfA.bLh();
                }
                f(this.dfD, 0);
                return true;
            }
        } else if (this.dfu == 2 && this.dft != null && this.dfz != null && d(this.dfD, this.dfz.aGB())) {
            if (this.dfD.getRequestedOrientation() != 1) {
                this.dfA.bLh();
            }
            f(this.dfD, 0);
            return true;
        }
        release();
        return false;
    }

    public void aGj() {
        if (this.dfv != null) {
            this.dfv.stop();
            br(this.dfv.aal());
            this.dfv.destroy();
        }
        this.dfv = null;
        if (this.dfy != null) {
            this.dfy.stopPlay();
            this.dfy.destroy();
            br(this.dfy.ceg());
        }
        this.dfy = null;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.aBc + " release()");
        this.dfD.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        com.baidu.swan.apps.media.b.b(this);
        this.dfA.stop();
        if (this.dfv != null) {
            this.dfv.stop();
            this.dfv.destroy();
            this.dfv = null;
        }
        if (this.dfy != null) {
            this.dfy.stopPlay();
            this.dfy.aGj();
            this.dfy.destroy();
            this.dfy = null;
        }
    }

    private void aGk() {
        br(this.dft.dfk);
        mL(this.dft.dfm);
        mM(this.dft.dfn);
        if (TextUtils.equals(this.dft.dfo, "horizontal")) {
            setVideoRotation(90);
        } else {
            setVideoRotation(0);
        }
        if (TextUtils.equals(this.dft.aDi, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void br(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.dfv != null) {
            this.dfv.setAudioMute(z);
        }
        if (this.dfy != null) {
            this.dfy.setMuted(z);
        }
    }

    public void mL(int i) {
    }

    public void mM(int i) {
    }

    public void setVideoRotation(int i) {
    }

    private void setVideoScalingMode(int i) {
        BdLog.d("setVideoScalingMode scalingMode: " + i);
        if (this.dfv != null) {
            this.dfv.setRenderVideoModel(1, i != 2 ? 1 : 2);
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

    private boolean aGl() {
        boolean z;
        int i;
        int i2 = 0;
        if (this.dfu != 2 || this.dfy == null || this.dfC == null) {
            return false;
        }
        View ceg = this.dfy.ceg();
        if (ceg != null && ceg.getParent() == null) {
            this.dfC.addView(ceg);
        }
        this.dfy.cs(this.dft.mSrc, "");
        this.dfB = true;
        if (this.dfC != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.dfC.getChildCount()) {
                    z = false;
                    break;
                } else if (this.dfC.getChildAt(i3) == this.dfy.ceg()) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.dft.aDW != null) {
                    i = this.dft.aDW.getWidth();
                    i2 = this.dft.aDW.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.dfE, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.dft.toString(), "position", this.dft.aDW == null ? "null" : this.dft.aDW.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                }
                this.dfC.addView(this.dfv.aal(), new LinearLayout.LayoutParams(i, i2));
            }
        }
        return true;
    }

    private boolean aGm() {
        boolean z;
        int i;
        int i2;
        CustomResponsedMessage runTask;
        if (this.dfu != 1) {
            return false;
        }
        if (this.dfv == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.dfD)) != null && runTask.getData() != null) {
            this.dfv = (com.baidu.tbadk.ala.d) runTask.getData();
            this.dfv.a(this.dfw);
        }
        if (this.dfv != null) {
            if (this.dfv.a(1, this.dft.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
                this.dfB = true;
            }
            if (this.dfC != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= this.dfC.getChildCount()) {
                        z = false;
                        break;
                    } else if (this.dfC.getChildAt(i3) == this.dfv.aal()) {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!z) {
                    if (this.dft.aDW != null) {
                        i2 = this.dft.aDW.getWidth();
                        i = this.dft.aDW.getHeight();
                    } else {
                        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.dfE, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.dft.toString(), "position", this.dft.aDW == null ? "null" : this.dft.aDW.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                        i = 0;
                        i2 = 0;
                    }
                    this.dfC.addView(this.dfv.aal(), new LinearLayout.LayoutParams(i2, i));
                    if (TextUtils.equals(this.dft.aDi, "contain")) {
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
        Hs.aDU = this.dft.aDU;
        Hs.aDV = aVar.aDV;
        if (com.baidu.swan.apps.view.container.c.b.a(Hs.aDU, this.aBc, com.baidu.swan.apps.view.container.c.c.iD(Hs.aDU)) == null) {
            BdLog.d("insertOrUpdateCoverContainer 00");
            this.dfC = new FrameLayout(this.dfD);
            return this.alj.a(this.dfC, Hs);
        }
        BdLog.d("insertOrUpdateCoverContainer 01");
        return this.alj.a(Hs);
    }

    private boolean c(a aVar) {
        if (this.dfz == null || this.dfz.aGB() == null) {
            return false;
        }
        com.baidu.swan.apps.model.a.a.a Hs = aVar.Hs();
        Hs.id = this.aBc;
        Hs.aDU = this.dft.aDU;
        Hs.aDV = aVar.aDV;
        if (com.baidu.swan.apps.view.container.c.b.a(Hs.aDU, this.aBc, com.baidu.swan.apps.view.container.c.c.iD(Hs.aDU)) == null) {
            BdLog.d("insertOrUpdateCoverContainer 00");
            this.dfC = new FrameLayout(this.dfD);
            return this.dfz.aGB().a(this.dfC, Hs);
        }
        BdLog.d("insertOrUpdateCoverContainer 01");
        return this.dfz.aGB().a(Hs);
    }

    private void d(a aVar) {
        BdLog.d("initVideoCoverContainer 00");
        if (this.dfu == 1) {
            b(aVar);
        } else if (this.dfu == 2) {
            c(aVar);
        }
    }

    private boolean e(a aVar) {
        if (this.dft == null) {
            return false;
        }
        return (this.dft.dfk == aVar.dfk && this.dft.dfm == aVar.dfm && this.dft.dfn == aVar.dfn && TextUtils.equals(this.dft.dfo, aVar.dfo) && TextUtils.equals(this.dft.aDi, aVar.aDi)) ? false : true;
    }

    public void f(@NonNull a aVar) {
        BdLog.d("updatePlayerConfig params: " + aVar.toString());
        if (e(aVar)) {
            this.dft = aVar;
            aGk();
        }
        this.dft = aVar;
        d(this.dft);
    }

    public boolean isPlaying() {
        if (this.dfu == 1 && this.dfv != null) {
            return this.dfB;
        }
        if (this.dfu == 2 && this.dfy != null) {
            return this.dfy.pB();
        }
        return false;
    }

    public void stop() {
        if (this.dfv != null) {
            this.dfv.stop();
            this.dfv.destroy();
            this.dfv.a(null);
            this.dfv = null;
            this.dfB = false;
        }
        if (this.dfy != null) {
            this.dfy.stopPlay();
            this.dfy.aGj();
            this.dfy.destroy();
            this.dfB = false;
            this.dfy = null;
        }
    }

    public void j(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.SY = z;
        int af = l.af(this.dfD);
        int ah = l.ah(this.dfD);
        if (z) {
            if (i == 90 || i == -90) {
                this.dfA.bLh();
                af = ah;
                ah = af;
            }
        } else if (this.dfD.getRequestedOrientation() != 1) {
            this.dfA.bLh();
        }
        if (z) {
            a(this.dfD, i, af, ah);
        } else {
            f(this.dfD, i);
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
            if (this.dfv != null && this.dfv.aal().getParent() != null) {
                ((ViewGroup) this.dfv.aal().getParent()).removeView(this.dfv.aal());
            }
            this.dfC.addView(this.dfv.aal(), new LinearLayout.LayoutParams(i2, i3));
            this.alj.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void f(Activity activity, int i) {
        if (activity == null || this.dft == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.SY = false;
        if (this.dfu == 1) {
            if (this.alj != null && this.alj.getParent() != null) {
                ((ViewGroup) this.alj.getParent()).removeView(this.alj);
            }
            if (this.dfv != null && this.dfv.aal().getParent() != null) {
                ((ViewGroup) this.dfv.aal().getParent()).removeView(this.dfv.aal());
            }
            int width = this.dft.aDW.getWidth();
            int height = this.dft.aDW.getHeight();
            this.dft.aDW.getLeft();
            this.dft.aDW.Hv();
            this.dfC.addView(this.dfv.aal(), new LinearLayout.LayoutParams(width, height));
            this.alj.Qj();
        } else if (this.dfu == 2) {
            SwanAppNAViewContainer aGB = this.dfz.aGB();
            View ceg = this.dfy.ceg();
            if (aGB != null && aGB.getParent() != null) {
                ((ViewGroup) aGB.getParent()).removeView(aGB);
            }
            if (ceg != null && ceg.getParent() != null) {
                ((ViewGroup) ceg.getParent()).removeView(ceg);
            }
            int width2 = this.dft.aDW.getWidth();
            int height2 = this.dft.aDW.getHeight();
            this.dft.aDW.getLeft();
            this.dft.aDW.Hv();
            this.dfC.addView(ceg, new LinearLayout.LayoutParams(width2, height2));
            aGB.Qj();
        }
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGn() {
        String Hq = this.dfx.Hq();
        if (!TextUtils.isEmpty(Hq)) {
            BdLog.d(this.aBc + " dispatchNetStatusEvent statusData: " + Hq);
            c.J(getSlaveId(), GM(), Hq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mN(int i) {
        int mJ = b.mJ(i);
        BdLog.d(this.aBc + " dispatchStatusIfNeeded what: " + i + " liveStatusCode:" + mJ);
        if (mJ != 100) {
            if (mJ == 2101) {
                c.I(getSlaveId(), GM(), b.mK(2102));
            }
            c.I(getSlaveId(), GM(), b.mK(mJ));
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
