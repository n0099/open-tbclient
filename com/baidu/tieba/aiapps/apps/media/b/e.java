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
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
import com.baidu.tbadk.ala.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.play.o;
import org.apache.http.HttpHost;
/* loaded from: classes4.dex */
public class e implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean BP;
    private SwanAppNAViewContainer aEK;
    private String aUw;
    private com.baidu.tbadk.ala.d dpK;
    private d.a dpL;
    private com.baidu.tieba.aiapps.apps.media.video.view.a dpN;
    private com.baidu.tieba.aiapps.apps.media.video.b dpO;
    private o dpP;
    private FrameLayout dpR;
    private Activity dpS;
    private boolean mDetached;
    CustomMessageListener qJ;
    private a dpI = a.aGV();
    private int dpJ = 0;
    private com.baidu.tieba.aiapps.apps.media.b.a.a dpM = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean dpQ = false;
    private String dpT = "AiAppLiveErr";

    public e(Context context, String str) {
        this.aUw = str;
        this.dpS = (Activity) context;
        if (!TextUtils.isEmpty(this.aUw)) {
            com.baidu.swan.apps.media.b.a(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.aUw);
        this.aEK = new SwanAppNAViewContainer(context);
        this.dpL = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.e.1
        };
        this.qJ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.aiapps.apps.media.b.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    e.this.aHc();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.qJ);
        this.dpP = new o(this.dpS);
        this.dpP.start();
        this.dpS.getWindow().addFlags(128);
        this.dpN = new com.baidu.tieba.aiapps.apps.media.video.view.a((Activity) context, false);
        this.dpO = new com.baidu.tieba.aiapps.apps.media.video.b(context);
        this.dpN.e(this.dpO.aHq());
    }

    public a aGX() {
        return this.dpI;
    }

    public void a(a aVar) {
        this.dpI = aVar;
        if (!this.dpI.hidden && this.dpI.aUF) {
            start();
        }
    }

    public void start() {
        if (this.dpI != null) {
            if (this.dpI.hidden) {
                BdLog.d("mPlayerId = " + this.aUw + "can not start(), hide = " + this.dpI.hidden);
                return;
            }
            BdLog.d(this.aUw + " start()");
            if (this.dpJ == 0) {
                this.dpJ = ss(this.dpI.mSrc);
            }
            if (this.dpJ == 0) {
                BdLog.e("unsupport  url type error src = " + this.dpI.mSrc);
                return;
            }
            if (this.dpK != null) {
                aGY();
            }
            d(this.dpI);
            c(this.dpI.mSrc, "", "", false);
            if (this.dpJ == 1) {
                aHb();
            } else if (this.dpJ == 2) {
                aHa();
            }
            this.mDetached = false;
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String LL() {
        return this.aUw;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dpI.aXp;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object LN() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bO(boolean z) {
        BdLog.d("onForegroundChanged " + z);
        if (this.dpN != null && this.dpJ == 2) {
            if (z) {
                this.dpN.bIK();
            } else {
                this.dpN.pausePlay();
            }
        }
        if (this.dpK != null && this.dpJ == 1) {
            if (z) {
                this.dpK.stop();
                br(this.dpK.afb());
                this.dpK.destroy();
                this.dpK = null;
                return;
            }
            aHb();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bP(boolean z) {
        BdLog.d("onAppForegroundChanged " + z);
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        BdLog.d("onBackPressed ");
        if (this.dpJ == 1) {
            if (this.dpI != null && this.aEK != null && d(this.dpS, this.aEK)) {
                if (this.dpS.getRequestedOrientation() != 1) {
                    this.dpP.vt();
                }
                d(this.dpS, 0);
                return true;
            }
        } else if (this.dpJ == 2 && this.dpI != null && this.dpO != null && d(this.dpS, this.dpO.aHq())) {
            if (this.dpS.getRequestedOrientation() != 1) {
                this.dpP.vt();
            }
            d(this.dpS, 0);
            return true;
        }
        release();
        return false;
    }

    public void aGY() {
        if (this.dpK != null) {
            this.dpK.stop();
            br(this.dpK.afb());
            this.dpK.destroy();
        }
        this.dpK = null;
        if (this.dpN != null) {
            this.dpN.stopPlay();
            this.dpN.destroy();
            br(this.dpN.cbV());
        }
        this.dpN = null;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.aUw + " release()");
        this.dpS.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.qJ);
        com.baidu.swan.apps.media.b.b(this);
        this.dpP.stop();
        if (this.dpK != null) {
            this.dpK.stop();
            this.dpK.destroy();
            this.dpK = null;
        }
        if (this.dpN != null) {
            this.dpN.stopPlay();
            this.dpN.aGY();
            this.dpN.destroy();
            this.dpN = null;
        }
    }

    private void aGZ() {
        bJ(this.dpI.dpA);
        lR(this.dpI.dpC);
        lS(this.dpI.dpD);
        if (TextUtils.equals(this.dpI.dpE, HorizontalTranslateLayout.HORIZONTAL)) {
            setVideoRotation(90);
        } else {
            setVideoRotation(0);
        }
        if (TextUtils.equals(this.dpI.aWD, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void bJ(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.dpK != null) {
            this.dpK.setAudioMute(z);
        }
        if (this.dpN != null) {
            this.dpN.setMuted(z);
        }
    }

    public void lR(int i) {
    }

    public void lS(int i) {
    }

    public void setVideoRotation(int i) {
    }

    private void setVideoScalingMode(int i) {
        BdLog.d("setVideoScalingMode scalingMode: " + i);
        if (this.dpK != null) {
            this.dpK.setRenderVideoModel(1, i != 2 ? 1 : 2);
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

    private boolean aHa() {
        boolean z;
        int i;
        int i2 = 0;
        if (this.dpJ != 2 || this.dpN == null || this.dpR == null) {
            return false;
        }
        View cbV = this.dpN.cbV();
        if (cbV != null && cbV.getParent() == null) {
            this.dpR.addView(cbV);
        }
        this.dpN.cm(this.dpI.mSrc, "");
        this.dpQ = true;
        if (this.dpR != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.dpR.getChildCount()) {
                    z = false;
                    break;
                } else if (this.dpR.getChildAt(i3) == this.dpN.cbV()) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.dpI.aXr != null) {
                    i = this.dpI.aXr.getWidth();
                    i2 = this.dpI.aXr.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.dpT, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.dpI.toString(), "position", this.dpI.aXr == null ? "null" : this.dpI.aXr.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                }
                this.dpR.addView(this.dpK.afb(), new LinearLayout.LayoutParams(i, i2));
            }
        }
        return true;
    }

    private boolean aHb() {
        boolean z;
        int i;
        int i2;
        CustomResponsedMessage runTask;
        if (this.dpJ != 1) {
            return false;
        }
        if (this.dpK == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.dpS)) != null && runTask.getData() != null) {
            this.dpK = (com.baidu.tbadk.ala.d) runTask.getData();
            this.dpK.a(this.dpL);
        }
        if (this.dpK != null) {
            if (this.dpK.a(1, this.dpI.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
                this.dpQ = true;
            }
            if (this.dpR != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= this.dpR.getChildCount()) {
                        z = false;
                        break;
                    } else if (this.dpR.getChildAt(i3) == this.dpK.afb()) {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!z) {
                    if (this.dpI.aXr != null) {
                        i2 = this.dpI.aXr.getWidth();
                        i = this.dpI.aXr.getHeight();
                    } else {
                        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.dpT, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.dpI.toString(), "position", this.dpI.aXr == null ? "null" : this.dpI.aXr.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                        i = 0;
                        i2 = 0;
                    }
                    this.dpR.addView(this.dpK.afb(), new LinearLayout.LayoutParams(i2, i));
                    if (TextUtils.equals(this.dpI.aWD, "contain")) {
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
        if (this.aEK == null) {
            return false;
        }
        if (this.BP) {
            this.aEK.setHidden(aVar.hidden);
            return true;
        }
        com.baidu.swan.apps.model.a.a.a Mr = aVar.Mr();
        Mr.id = this.aUw;
        Mr.aXp = this.dpI.aXp;
        Mr.aXq = aVar.aXq;
        if (com.baidu.swan.apps.view.container.c.b.a(Mr.aXp, this.aUw, com.baidu.swan.apps.view.container.c.c.ji(Mr.aXp)) == null) {
            BdLog.d("insertOrUpdateCoverContainer 00");
            this.dpR = new FrameLayout(this.dpS);
            return this.aEK.a(this.dpR, Mr);
        }
        BdLog.d("insertOrUpdateCoverContainer 01");
        return this.aEK.a(Mr);
    }

    private boolean c(a aVar) {
        if (this.dpO == null || this.dpO.aHq() == null) {
            return false;
        }
        com.baidu.swan.apps.model.a.a.a Mr = aVar.Mr();
        Mr.id = this.aUw;
        Mr.aXp = this.dpI.aXp;
        Mr.aXq = aVar.aXq;
        if (com.baidu.swan.apps.view.container.c.b.a(Mr.aXp, this.aUw, com.baidu.swan.apps.view.container.c.c.ji(Mr.aXp)) == null) {
            BdLog.d("insertOrUpdateCoverContainer 00");
            this.dpR = new FrameLayout(this.dpS);
            return this.dpO.aHq().a(this.dpR, Mr);
        }
        BdLog.d("insertOrUpdateCoverContainer 01");
        return this.dpO.aHq().a(Mr);
    }

    private void d(a aVar) {
        BdLog.d("initVideoCoverContainer 00");
        if (this.dpJ == 1) {
            b(aVar);
        } else if (this.dpJ == 2) {
            c(aVar);
        }
    }

    private boolean e(a aVar) {
        if (this.dpI == null) {
            return false;
        }
        return (this.dpI.dpA == aVar.dpA && this.dpI.dpC == aVar.dpC && this.dpI.dpD == aVar.dpD && TextUtils.equals(this.dpI.dpE, aVar.dpE) && TextUtils.equals(this.dpI.aWD, aVar.aWD)) ? false : true;
    }

    public void f(@NonNull a aVar) {
        BdLog.d("updatePlayerConfig params: " + aVar.toString());
        if (e(aVar)) {
            this.dpI = aVar;
            aGZ();
        }
        this.dpI = aVar;
        d(this.dpI);
    }

    public boolean isPlaying() {
        if (this.dpJ == 1 && this.dpK != null) {
            return this.dpQ;
        }
        if (this.dpJ == 2 && this.dpN != null) {
            return this.dpN.kx();
        }
        return false;
    }

    public void stop() {
        if (this.dpK != null) {
            this.dpK.stop();
            this.dpK.destroy();
            this.dpK.a(null);
            this.dpK = null;
            this.dpQ = false;
        }
        if (this.dpN != null) {
            this.dpN.stopPlay();
            this.dpN.aGY();
            this.dpN.destroy();
            this.dpQ = false;
            this.dpN = null;
        }
    }

    public void k(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.BP = z;
        int equipmentWidth = l.getEquipmentWidth(this.dpS);
        int equipmentHeight = l.getEquipmentHeight(this.dpS);
        if (z) {
            if (i == 90 || i == -90) {
                this.dpP.vt();
                equipmentWidth = equipmentHeight;
                equipmentHeight = equipmentWidth;
            }
        } else if (this.dpS.getRequestedOrientation() != 1) {
            this.dpP.vt();
        }
        if (z) {
            a(this.dpS, i, equipmentWidth, equipmentHeight);
        } else {
            d(this.dpS, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null) {
            this.BP = true;
            if (this.aEK != null && this.aEK.getParent() != null) {
                ((ViewGroup) this.aEK.getParent()).removeView(this.aEK);
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.aEK);
                viewGroup.addView(this.aEK);
            }
            if (this.dpK != null && this.dpK.afb().getParent() != null) {
                ((ViewGroup) this.dpK.afb().getParent()).removeView(this.dpK.afb());
            }
            this.dpR.addView(this.dpK.afb(), new LinearLayout.LayoutParams(i2, i3));
            this.aEK.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void d(Activity activity, int i) {
        if (activity == null || this.dpI == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.BP = false;
        if (this.dpJ == 1) {
            if (this.aEK != null && this.aEK.getParent() != null) {
                ((ViewGroup) this.aEK.getParent()).removeView(this.aEK);
            }
            if (this.dpK != null && this.dpK.afb().getParent() != null) {
                ((ViewGroup) this.dpK.afb().getParent()).removeView(this.dpK.afb());
            }
            int width = this.dpI.aXr.getWidth();
            int height = this.dpI.aXr.getHeight();
            this.dpI.aXr.getLeft();
            this.dpI.aXr.Mu();
            this.dpR.addView(this.dpK.afb(), new LinearLayout.LayoutParams(width, height));
            this.aEK.Vb();
        } else if (this.dpJ == 2) {
            SwanAppNAViewContainer aHq = this.dpO.aHq();
            View cbV = this.dpN.cbV();
            if (aHq != null && aHq.getParent() != null) {
                ((ViewGroup) aHq.getParent()).removeView(aHq);
            }
            if (cbV != null && cbV.getParent() != null) {
                ((ViewGroup) cbV.getParent()).removeView(cbV);
            }
            int width2 = this.dpI.aXr.getWidth();
            int height2 = this.dpI.aXr.getHeight();
            this.dpI.aXr.getLeft();
            this.dpI.aXr.Mu();
            this.dpR.addView(cbV, new LinearLayout.LayoutParams(width2, height2));
            aHq.Vb();
        }
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHc() {
        String Mp = this.dpM.Mp();
        if (!TextUtils.isEmpty(Mp)) {
            BdLog.d(this.aUw + " dispatchNetStatusEvent statusData: " + Mp);
            b.O(getSlaveId(), LL(), Mp);
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String LM() {
        return null;
    }

    private static int ss(String str) {
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
