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
    private boolean Cp;
    private SwanAppNAViewContainer aFc;
    private String aUO;
    private com.baidu.tbadk.ala.d dqB;
    private d.a dqC;
    private com.baidu.tieba.aiapps.apps.media.video.view.a dqE;
    private com.baidu.tieba.aiapps.apps.media.video.b dqF;
    private o dqG;
    private FrameLayout dqI;
    private Activity dqJ;
    private boolean mDetached;
    CustomMessageListener ri;
    private a dqz = a.aGX();
    private int dqA = 0;
    private com.baidu.tieba.aiapps.apps.media.b.a.a dqD = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean dqH = false;
    private String dqK = "AiAppLiveErr";

    public e(Context context, String str) {
        this.aUO = str;
        this.dqJ = (Activity) context;
        if (!TextUtils.isEmpty(this.aUO)) {
            com.baidu.swan.apps.media.b.a(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.aUO);
        this.aFc = new SwanAppNAViewContainer(context);
        this.dqC = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.e.1
        };
        this.ri = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.aiapps.apps.media.b.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    e.this.aHe();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.ri);
        this.dqG = new o(this.dqJ);
        this.dqG.start();
        this.dqJ.getWindow().addFlags(128);
        this.dqE = new com.baidu.tieba.aiapps.apps.media.video.view.a((Activity) context, false);
        this.dqF = new com.baidu.tieba.aiapps.apps.media.video.b(context);
        this.dqE.e(this.dqF.aHs());
    }

    public a aGZ() {
        return this.dqz;
    }

    public void a(a aVar) {
        this.dqz = aVar;
        if (!this.dqz.hidden && this.dqz.aUX) {
            start();
        }
    }

    public void start() {
        if (this.dqz != null) {
            if (this.dqz.hidden) {
                BdLog.d("mPlayerId = " + this.aUO + "can not start(), hide = " + this.dqz.hidden);
                return;
            }
            BdLog.d(this.aUO + " start()");
            if (this.dqA == 0) {
                this.dqA = ss(this.dqz.mSrc);
            }
            if (this.dqA == 0) {
                BdLog.e("unsupport  url type error src = " + this.dqz.mSrc);
                return;
            }
            if (this.dqB != null) {
                aHa();
            }
            d(this.dqz);
            c(this.dqz.mSrc, "", "", false);
            if (this.dqA == 1) {
                aHd();
            } else if (this.dqA == 2) {
                aHc();
            }
            this.mDetached = false;
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String LK() {
        return this.aUO;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dqz.aXH;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object LM() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void bO(boolean z) {
        BdLog.d("onForegroundChanged " + z);
        if (this.dqE != null && this.dqA == 2) {
            if (z) {
                this.dqE.bIM();
            } else {
                this.dqE.pausePlay();
            }
        }
        if (this.dqB != null && this.dqA == 1) {
            if (z) {
                this.dqB.stop();
                br(this.dqB.afd());
                this.dqB.destroy();
                this.dqB = null;
                return;
            }
            aHd();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void bP(boolean z) {
        BdLog.d("onAppForegroundChanged " + z);
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        BdLog.d("onBackPressed ");
        if (this.dqA == 1) {
            if (this.dqz != null && this.aFc != null && d(this.dqJ, this.aFc)) {
                if (this.dqJ.getRequestedOrientation() != 1) {
                    this.dqG.vs();
                }
                d(this.dqJ, 0);
                return true;
            }
        } else if (this.dqA == 2 && this.dqz != null && this.dqF != null && d(this.dqJ, this.dqF.aHs())) {
            if (this.dqJ.getRequestedOrientation() != 1) {
                this.dqG.vs();
            }
            d(this.dqJ, 0);
            return true;
        }
        release();
        return false;
    }

    public void aHa() {
        if (this.dqB != null) {
            this.dqB.stop();
            br(this.dqB.afd());
            this.dqB.destroy();
        }
        this.dqB = null;
        if (this.dqE != null) {
            this.dqE.stopPlay();
            this.dqE.destroy();
            br(this.dqE.cbX());
        }
        this.dqE = null;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.aUO + " release()");
        this.dqJ.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.ri);
        com.baidu.swan.apps.media.b.b(this);
        this.dqG.stop();
        if (this.dqB != null) {
            this.dqB.stop();
            this.dqB.destroy();
            this.dqB = null;
        }
        if (this.dqE != null) {
            this.dqE.stopPlay();
            this.dqE.aHa();
            this.dqE.destroy();
            this.dqE = null;
        }
    }

    private void aHb() {
        bJ(this.dqz.dqr);
        lS(this.dqz.dqt);
        lT(this.dqz.dqu);
        if (TextUtils.equals(this.dqz.dqv, HorizontalTranslateLayout.HORIZONTAL)) {
            setVideoRotation(90);
        } else {
            setVideoRotation(0);
        }
        if (TextUtils.equals(this.dqz.aWV, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void bJ(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.dqB != null) {
            this.dqB.setAudioMute(z);
        }
        if (this.dqE != null) {
            this.dqE.setMuted(z);
        }
    }

    public void lS(int i) {
    }

    public void lT(int i) {
    }

    public void setVideoRotation(int i) {
    }

    private void setVideoScalingMode(int i) {
        BdLog.d("setVideoScalingMode scalingMode: " + i);
        if (this.dqB != null) {
            this.dqB.setRenderVideoModel(1, i != 2 ? 1 : 2);
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

    private boolean aHc() {
        boolean z;
        int i;
        int i2 = 0;
        if (this.dqA != 2 || this.dqE == null || this.dqI == null) {
            return false;
        }
        View cbX = this.dqE.cbX();
        if (cbX != null && cbX.getParent() == null) {
            this.dqI.addView(cbX);
        }
        this.dqE.cm(this.dqz.mSrc, "");
        this.dqH = true;
        if (this.dqI != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.dqI.getChildCount()) {
                    z = false;
                    break;
                } else if (this.dqI.getChildAt(i3) == this.dqE.cbX()) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.dqz.aXJ != null) {
                    i = this.dqz.aXJ.getWidth();
                    i2 = this.dqz.aXJ.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.dqK, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.dqz.toString(), "position", this.dqz.aXJ == null ? "null" : this.dqz.aXJ.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                }
                this.dqI.addView(this.dqB.afd(), new LinearLayout.LayoutParams(i, i2));
            }
        }
        return true;
    }

    private boolean aHd() {
        boolean z;
        int i;
        int i2;
        CustomResponsedMessage runTask;
        if (this.dqA != 1) {
            return false;
        }
        if (this.dqB == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.dqJ)) != null && runTask.getData() != null) {
            this.dqB = (com.baidu.tbadk.ala.d) runTask.getData();
            this.dqB.a(this.dqC);
        }
        if (this.dqB != null) {
            if (this.dqB.a(1, this.dqz.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
                this.dqH = true;
            }
            if (this.dqI != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= this.dqI.getChildCount()) {
                        z = false;
                        break;
                    } else if (this.dqI.getChildAt(i3) == this.dqB.afd()) {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!z) {
                    if (this.dqz.aXJ != null) {
                        i2 = this.dqz.aXJ.getWidth();
                        i = this.dqz.aXJ.getHeight();
                    } else {
                        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.dqK, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.dqz.toString(), "position", this.dqz.aXJ == null ? "null" : this.dqz.aXJ.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                        i = 0;
                        i2 = 0;
                    }
                    this.dqI.addView(this.dqB.afd(), new LinearLayout.LayoutParams(i2, i));
                    if (TextUtils.equals(this.dqz.aWV, "contain")) {
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
        if (this.aFc == null) {
            return false;
        }
        if (this.Cp) {
            this.aFc.setHidden(aVar.hidden);
            return true;
        }
        com.baidu.swan.apps.model.a.a.a Mq = aVar.Mq();
        Mq.id = this.aUO;
        Mq.aXH = this.dqz.aXH;
        Mq.aXI = aVar.aXI;
        if (com.baidu.swan.apps.view.container.c.b.a(Mq.aXH, this.aUO, com.baidu.swan.apps.view.container.c.c.ji(Mq.aXH)) == null) {
            BdLog.d("insertOrUpdateCoverContainer 00");
            this.dqI = new FrameLayout(this.dqJ);
            return this.aFc.a(this.dqI, Mq);
        }
        BdLog.d("insertOrUpdateCoverContainer 01");
        return this.aFc.a(Mq);
    }

    private boolean c(a aVar) {
        if (this.dqF == null || this.dqF.aHs() == null) {
            return false;
        }
        com.baidu.swan.apps.model.a.a.a Mq = aVar.Mq();
        Mq.id = this.aUO;
        Mq.aXH = this.dqz.aXH;
        Mq.aXI = aVar.aXI;
        if (com.baidu.swan.apps.view.container.c.b.a(Mq.aXH, this.aUO, com.baidu.swan.apps.view.container.c.c.ji(Mq.aXH)) == null) {
            BdLog.d("insertOrUpdateCoverContainer 00");
            this.dqI = new FrameLayout(this.dqJ);
            return this.dqF.aHs().a(this.dqI, Mq);
        }
        BdLog.d("insertOrUpdateCoverContainer 01");
        return this.dqF.aHs().a(Mq);
    }

    private void d(a aVar) {
        BdLog.d("initVideoCoverContainer 00");
        if (this.dqA == 1) {
            b(aVar);
        } else if (this.dqA == 2) {
            c(aVar);
        }
    }

    private boolean e(a aVar) {
        if (this.dqz == null) {
            return false;
        }
        return (this.dqz.dqr == aVar.dqr && this.dqz.dqt == aVar.dqt && this.dqz.dqu == aVar.dqu && TextUtils.equals(this.dqz.dqv, aVar.dqv) && TextUtils.equals(this.dqz.aWV, aVar.aWV)) ? false : true;
    }

    public void f(@NonNull a aVar) {
        BdLog.d("updatePlayerConfig params: " + aVar.toString());
        if (e(aVar)) {
            this.dqz = aVar;
            aHb();
        }
        this.dqz = aVar;
        d(this.dqz);
    }

    public boolean isPlaying() {
        if (this.dqA == 1 && this.dqB != null) {
            return this.dqH;
        }
        if (this.dqA == 2 && this.dqE != null) {
            return this.dqE.kx();
        }
        return false;
    }

    public void stop() {
        if (this.dqB != null) {
            this.dqB.stop();
            this.dqB.destroy();
            this.dqB.a(null);
            this.dqB = null;
            this.dqH = false;
        }
        if (this.dqE != null) {
            this.dqE.stopPlay();
            this.dqE.aHa();
            this.dqE.destroy();
            this.dqH = false;
            this.dqE = null;
        }
    }

    public void k(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.Cp = z;
        int equipmentWidth = l.getEquipmentWidth(this.dqJ);
        int equipmentHeight = l.getEquipmentHeight(this.dqJ);
        if (z) {
            if (i == 90 || i == -90) {
                this.dqG.vs();
                equipmentWidth = equipmentHeight;
                equipmentHeight = equipmentWidth;
            }
        } else if (this.dqJ.getRequestedOrientation() != 1) {
            this.dqG.vs();
        }
        if (z) {
            a(this.dqJ, i, equipmentWidth, equipmentHeight);
        } else {
            d(this.dqJ, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null) {
            this.Cp = true;
            if (this.aFc != null && this.aFc.getParent() != null) {
                ((ViewGroup) this.aFc.getParent()).removeView(this.aFc);
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.aFc);
                viewGroup.addView(this.aFc);
            }
            if (this.dqB != null && this.dqB.afd().getParent() != null) {
                ((ViewGroup) this.dqB.afd().getParent()).removeView(this.dqB.afd());
            }
            this.dqI.addView(this.dqB.afd(), new LinearLayout.LayoutParams(i2, i3));
            this.aFc.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void d(Activity activity, int i) {
        if (activity == null || this.dqz == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.Cp = false;
        if (this.dqA == 1) {
            if (this.aFc != null && this.aFc.getParent() != null) {
                ((ViewGroup) this.aFc.getParent()).removeView(this.aFc);
            }
            if (this.dqB != null && this.dqB.afd().getParent() != null) {
                ((ViewGroup) this.dqB.afd().getParent()).removeView(this.dqB.afd());
            }
            int width = this.dqz.aXJ.getWidth();
            int height = this.dqz.aXJ.getHeight();
            this.dqz.aXJ.getLeft();
            this.dqz.aXJ.Mt();
            this.dqI.addView(this.dqB.afd(), new LinearLayout.LayoutParams(width, height));
            this.aFc.Vd();
        } else if (this.dqA == 2) {
            SwanAppNAViewContainer aHs = this.dqF.aHs();
            View cbX = this.dqE.cbX();
            if (aHs != null && aHs.getParent() != null) {
                ((ViewGroup) aHs.getParent()).removeView(aHs);
            }
            if (cbX != null && cbX.getParent() != null) {
                ((ViewGroup) cbX.getParent()).removeView(cbX);
            }
            int width2 = this.dqz.aXJ.getWidth();
            int height2 = this.dqz.aXJ.getHeight();
            this.dqz.aXJ.getLeft();
            this.dqz.aXJ.Mt();
            this.dqI.addView(cbX, new LinearLayout.LayoutParams(width2, height2));
            aHs.Vd();
        }
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHe() {
        String Mo = this.dqD.Mo();
        if (!TextUtils.isEmpty(Mo)) {
            BdLog.d(this.aUO + " dispatchNetStatusEvent statusData: " + Mo);
            b.O(getSlaveId(), LK(), Mo);
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String LL() {
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
