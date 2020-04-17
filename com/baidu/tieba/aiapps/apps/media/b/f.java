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
import com.baidu.tbadk.ala.AlaLivePlayerData;
import com.baidu.tbadk.ala.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.aiapps.apps.media.video.VideoContainerManager;
import com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView;
import com.baidu.tieba.play.o;
import org.apache.http.HttpHost;
/* loaded from: classes12.dex */
public class f implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    CustomMessageListener MI;
    private boolean Yk;
    private String bYS;
    private com.baidu.tbadk.ala.d eEB;
    private d.a eEC;
    private o eEE;
    private Activity eEG;
    private SwanVideoView eEy;
    private boolean mDetached;
    private VideoContainerManager eEx = null;
    private int eEz = 0;
    private a eEA = a.bie();
    private com.baidu.tieba.aiapps.apps.media.b.a.a eED = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean eEF = false;
    private String eEH = "AiAppLiveErr";

    public f(Context context, String str) {
        this.bYS = str;
        this.eEG = (Activity) context;
        if (!TextUtils.isEmpty(this.bYS)) {
            com.baidu.swan.apps.media.b.a(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.bYS);
        initData();
        MessageManager.getInstance().registerListener(this.MI);
        this.eEE = new o(this.eEG);
        this.eEE.start();
        this.eEG.getWindow().addFlags(128);
    }

    private void initData() {
        this.eEC = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.f.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + " " + i3);
                f.this.eED.mVideoWidth = i2;
                f.this.eED.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && f.this.eED != null) {
                    if (alaLivePlayerData.fpsAvg != f.this.eED.eEJ) {
                    }
                    if (alaLivePlayerData.videoBitrate != f.this.eED.mVideoBitrate) {
                    }
                    if (alaLivePlayerData.audioBitrate != f.this.eED.mAudioBitrate) {
                    }
                    f.this.eED.eEK = (int) alaLivePlayerData.bandWidth;
                    f.this.eED.eEJ = (int) alaLivePlayerData.fpsAvg;
                    f.this.eED.mAudioBitrate = (int) alaLivePlayerData.audioBitrate;
                    f.this.eED.mVideoBitrate = (int) alaLivePlayerData.videoBitrate;
                }
            }
        };
        this.MI = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.aiapps.apps.media.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    f.this.bil();
                }
            }
        };
    }

    public a big() {
        return this.eEA;
    }

    public void a(a aVar) {
        this.eEA = aVar;
        if (!this.eEA.hidden && this.eEA.bZa) {
            start();
        }
    }

    public void start() {
        if (this.eEA != null) {
            if (this.eEA.hidden) {
                BdLog.d("mPlayerId = " + this.bYS + "can not start(), hide = " + this.eEA.hidden);
                return;
            }
            BdLog.d(this.bYS + " start()");
            if (this.eEz == 0) {
                this.eEz = yR(this.eEA.mSrc);
            }
            if (this.eEz == 0) {
                BdLog.e("unsupport  url type error src = " + this.eEA.mSrc);
                return;
            }
            if (this.eEB != null || this.eEy != null) {
                resetPlayer();
            }
            bih();
            bih().biw();
            bii();
            c(this.eEA);
            c(this.eEA.mSrc, "", "", false);
            if (this.eEz == 1) {
                bij();
            } else if (this.eEz == 2) {
                bik();
            }
            this.mDetached = false;
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String aeT() {
        return this.bYS;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.eEA.bGJ;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aeV() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void dN(boolean z) {
        BdLog.d("onForegroundChanged " + z);
        if (!z) {
            resetPlayer();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void dO(boolean z) {
        BdLog.d("onAppForegroundChanged " + z);
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        BdLog.d("onBackPressed ");
        if (this.eEA != null && this.eEx != null && d(this.eEG, this.eEx.getVideoHolder())) {
            if (this.eEG.getRequestedOrientation() != 1) {
                this.eEE.Ff();
            }
            h(this.eEG, 0);
            return true;
        }
        release();
        return false;
    }

    public void resetPlayer() {
        if (this.eEB != null) {
            bs(this.eEB.aGQ());
            this.eEB.stop();
            this.eEB.destroy();
        }
        this.eEB = null;
        if (this.eEy != null) {
            this.eEy.stopPlayback();
            bs(this.eEy);
        }
        this.eEy = null;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.bYS + " release()");
        this.eEG.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.MI);
        com.baidu.swan.apps.media.b.b(this);
        this.eEE.stop();
        if (this.eEB != null) {
            bs(this.eEB.aGQ());
            this.eEB.stop();
            this.eEB.destroy();
            this.eEB = null;
        }
        if (this.eEy != null) {
            bs(this.eEy);
            this.eEy.stopPlayback();
            this.eEy = null;
        }
        if (this.eEx != null) {
            this.eEx.Sy();
            this.eEx = null;
        }
    }

    private VideoContainerManager bih() {
        if (this.eEx == null && this.eEA != null) {
            this.eEx = new VideoContainerManager(this.eEG, this.eEA);
        }
        return this.eEx;
    }

    private void bii() {
        dG(this.eEA.eEn);
        oH(this.eEA.eEp);
        oI(this.eEA.eEq);
        if (TextUtils.equals(this.eEA.eEr, HorizontalTranslateLayout.HORIZONTAL)) {
            setVideoRotation(90);
        } else {
            setVideoRotation(0);
        }
        if (TextUtils.equals(this.eEA.cdf, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void dG(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.eEB != null) {
            this.eEB.setAudioMute(z);
        }
        if (this.eEy != null) {
            this.eEy.dG(z);
        }
    }

    public void oH(int i) {
    }

    public void oI(int i) {
    }

    public void setVideoRotation(int i) {
    }

    public void setVideoScalingMode(int i) {
        BdLog.d("setVideoScalingMode scalingMode: " + i);
        if (this.eEB != null) {
            this.eEB.setRenderVideoModel(1, i != 2 ? 1 : 2);
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
        if (this.eEz == 2 && this.eEy != null) {
            this.eEy.setVideoPath(str);
        }
        return true;
    }

    private boolean bij() {
        boolean z;
        int i;
        int i2;
        CustomResponsedMessage runTask;
        if (this.eEB == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.eEG)) != null && runTask.getData() != null) {
            this.eEB = (com.baidu.tbadk.ala.d) runTask.getData();
            this.eEB.a(this.eEC);
        }
        if (this.eEB == null) {
            return false;
        }
        if (this.eEB.a(1, this.eEA.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
            this.eEF = true;
        }
        FrameLayout videoHolder = this.eEx.getVideoHolder();
        if (videoHolder != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= videoHolder.getChildCount()) {
                    z = false;
                    break;
                } else if (videoHolder.getChildAt(i3) == this.eEB.aGQ()) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.eEA.bGM != null) {
                    i2 = this.eEA.bGM.getWidth();
                    i = this.eEA.bGM.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.eEH, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.eEA.toString(), "position", this.eEA.bGM == null ? "null" : this.eEA.bGM.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                    i2 = 0;
                }
                videoHolder.addView(this.eEB.aGQ(), new LinearLayout.LayoutParams(i2, i));
                if (TextUtils.equals(this.eEA.cdf, "contain")) {
                    setVideoScalingMode(2);
                } else {
                    setVideoScalingMode(0);
                }
            }
        }
        return true;
    }

    private boolean bik() {
        boolean z;
        int i;
        int i2 = 0;
        if (this.eEz != 2) {
            return false;
        }
        if (this.eEy == null) {
            this.eEy = new SwanVideoView(this.eEG);
        }
        if (this.eEy.getParent() == null) {
            this.eEx.getVideoHolder().addView(this.eEy);
        }
        this.eEy.setVideoPath(this.eEA.mSrc);
        this.eEy.start();
        this.eEF = true;
        if (this.eEx.getVideoHolder() != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.eEx.getVideoHolder().getChildCount()) {
                    z = false;
                    break;
                } else if (this.eEx.getVideoHolder().getChildAt(i3) == this.eEy) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.eEA.bGM != null) {
                    i = this.eEA.bGM.getWidth();
                    i2 = this.eEA.bGM.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.eEH, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.eEA.toString(), "position", this.eEA.bGM == null ? "null" : this.eEA.bGM.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                }
                this.eEx.getVideoHolder().addView(this.eEB.aGQ(), new LinearLayout.LayoutParams(i, i2));
            }
        }
        return true;
    }

    private void b(a aVar) {
        if (this.eEx == null) {
            this.eEx = new VideoContainerManager(this.eEG, aVar);
        }
        if (this.Yk) {
            this.eEx.biy().setHidden(aVar.hidden);
        } else {
            this.eEx.j(aVar);
        }
    }

    private void c(a aVar) {
        BdLog.d("initVideoCoverContainer 00");
        b(aVar);
    }

    private boolean d(a aVar) {
        if (this.eEA == null) {
            return false;
        }
        return (this.eEA.eEn == aVar.eEn && this.eEA.eEp == aVar.eEp && this.eEA.eEq == aVar.eEq && TextUtils.equals(this.eEA.eEr, aVar.eEr) && TextUtils.equals(this.eEA.cdf, aVar.cdf)) ? false : true;
    }

    public void e(@NonNull a aVar) {
        BdLog.d("updatePlayerConfig params: " + aVar.toString());
        if (d(aVar)) {
            this.eEA = aVar;
            bii();
        }
        this.eEA = aVar;
        c(this.eEA);
    }

    public boolean isPlaying() {
        if (this.eEz == 1 && this.eEB != null) {
            return this.eEF;
        }
        if (this.eEz == 2 && this.eEy != null) {
            return this.eEy.isPlaying();
        }
        return false;
    }

    public void stop() {
        if (this.eEB != null) {
            bs(this.eEB.aGQ());
            this.eEB.stop();
            this.eEB.destroy();
            this.eEB.a(null);
            this.eEB = null;
            this.eEF = false;
        }
        if (this.eEy != null) {
            bs(this.eEy);
            this.eEy.stopPlayback();
            this.eEy = null;
            this.eEF = false;
        }
    }

    public void g(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.Yk = z;
        int equipmentWidth = l.getEquipmentWidth(this.eEG);
        int equipmentHeight = l.getEquipmentHeight(this.eEG);
        if (z) {
            if (i == 90 || i == -90) {
                this.eEE.Ff();
                equipmentWidth = equipmentHeight;
                equipmentHeight = equipmentWidth;
            }
        } else if (this.eEG.getRequestedOrientation() != 1) {
            this.eEE.Ff();
        }
        if (z) {
            a(this.eEG, i, equipmentWidth, equipmentHeight);
        } else {
            h(this.eEG, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null && this.eEx != null) {
            this.Yk = true;
            if (this.eEx != null && this.eEx.getVideoHolder().getParent() != null) {
                bs(this.eEx.getVideoHolder());
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.eEx.biy());
                viewGroup.addView(this.eEx.biy());
            }
            this.eEx.biy().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void h(Activity activity, int i) {
        if (activity == null || this.eEA == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.Yk = false;
        if (this.eEx.getVideoHolder().getParent() != null) {
            bs(this.eEx.getVideoHolder());
        }
        if (this.eEB != null && this.eEB.aGQ().getParent() != null) {
            bs(this.eEB.aGQ());
        }
        int width = this.eEA.bGM.getWidth();
        int height = this.eEA.bGM.getHeight();
        this.eEA.bGM.getLeft();
        this.eEA.bGM.getTop();
        this.eEx.getVideoHolder().addView(this.eEB.aGQ(), new LinearLayout.LayoutParams(width, height));
        this.eEx.Sw();
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bil() {
        String jSONString = this.eED.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            BdLog.d(this.bYS + " dispatchNetStatusEvent statusData: " + jSONString);
            c.aa(getSlaveId(), aeT(), jSONString);
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String aeU() {
        return null;
    }

    private static int yR(String str) {
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

    private static void bs(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }
}
