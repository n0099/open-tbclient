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
    CustomMessageListener MO;
    private boolean Yn;
    private String bYY;
    private SwanVideoView eED;
    private com.baidu.tbadk.ala.d eEG;
    private d.a eEH;
    private o eEJ;
    private Activity eEL;
    private boolean mDetached;
    private VideoContainerManager eEC = null;
    private int eEE = 0;
    private a eEF = a.bic();
    private com.baidu.tieba.aiapps.apps.media.b.a.a eEI = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean eEK = false;
    private String eEM = "AiAppLiveErr";

    public f(Context context, String str) {
        this.bYY = str;
        this.eEL = (Activity) context;
        if (!TextUtils.isEmpty(this.bYY)) {
            com.baidu.swan.apps.media.b.a(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.bYY);
        initData();
        MessageManager.getInstance().registerListener(this.MO);
        this.eEJ = new o(this.eEL);
        this.eEJ.start();
        this.eEL.getWindow().addFlags(128);
    }

    private void initData() {
        this.eEH = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.f.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + " " + i3);
                f.this.eEI.mVideoWidth = i2;
                f.this.eEI.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && f.this.eEI != null) {
                    if (alaLivePlayerData.fpsAvg != f.this.eEI.eEO) {
                    }
                    if (alaLivePlayerData.videoBitrate != f.this.eEI.mVideoBitrate) {
                    }
                    if (alaLivePlayerData.audioBitrate != f.this.eEI.mAudioBitrate) {
                    }
                    f.this.eEI.eEP = (int) alaLivePlayerData.bandWidth;
                    f.this.eEI.eEO = (int) alaLivePlayerData.fpsAvg;
                    f.this.eEI.mAudioBitrate = (int) alaLivePlayerData.audioBitrate;
                    f.this.eEI.mVideoBitrate = (int) alaLivePlayerData.videoBitrate;
                }
            }
        };
        this.MO = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.aiapps.apps.media.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    f.this.bij();
                }
            }
        };
    }

    public a bie() {
        return this.eEF;
    }

    public void a(a aVar) {
        this.eEF = aVar;
        if (!this.eEF.hidden && this.eEF.bZg) {
            start();
        }
    }

    public void start() {
        if (this.eEF != null) {
            if (this.eEF.hidden) {
                BdLog.d("mPlayerId = " + this.bYY + "can not start(), hide = " + this.eEF.hidden);
                return;
            }
            BdLog.d(this.bYY + " start()");
            if (this.eEE == 0) {
                this.eEE = yU(this.eEF.mSrc);
            }
            if (this.eEE == 0) {
                BdLog.e("unsupport  url type error src = " + this.eEF.mSrc);
                return;
            }
            if (this.eEG != null || this.eED != null) {
                resetPlayer();
            }
            bif();
            bif().biu();
            big();
            c(this.eEF);
            c(this.eEF.mSrc, "", "", false);
            if (this.eEE == 1) {
                bih();
            } else if (this.eEE == 2) {
                bii();
            }
            this.mDetached = false;
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String aeS() {
        return this.bYY;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.eEF.bGO;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object aeU() {
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
        if (this.eEF != null && this.eEC != null && d(this.eEL, this.eEC.getVideoHolder())) {
            if (this.eEL.getRequestedOrientation() != 1) {
                this.eEJ.Fe();
            }
            h(this.eEL, 0);
            return true;
        }
        release();
        return false;
    }

    public void resetPlayer() {
        if (this.eEG != null) {
            bs(this.eEG.aGO());
            this.eEG.stop();
            this.eEG.destroy();
        }
        this.eEG = null;
        if (this.eED != null) {
            this.eED.stopPlayback();
            bs(this.eED);
        }
        this.eED = null;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.bYY + " release()");
        this.eEL.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.MO);
        com.baidu.swan.apps.media.b.b(this);
        this.eEJ.stop();
        if (this.eEG != null) {
            bs(this.eEG.aGO());
            this.eEG.stop();
            this.eEG.destroy();
            this.eEG = null;
        }
        if (this.eED != null) {
            bs(this.eED);
            this.eED.stopPlayback();
            this.eED = null;
        }
        if (this.eEC != null) {
            this.eEC.Sx();
            this.eEC = null;
        }
    }

    private VideoContainerManager bif() {
        if (this.eEC == null && this.eEF != null) {
            this.eEC = new VideoContainerManager(this.eEL, this.eEF);
        }
        return this.eEC;
    }

    private void big() {
        dG(this.eEF.eEs);
        oH(this.eEF.eEu);
        oI(this.eEF.eEv);
        if (TextUtils.equals(this.eEF.eEw, HorizontalTranslateLayout.HORIZONTAL)) {
            setVideoRotation(90);
        } else {
            setVideoRotation(0);
        }
        if (TextUtils.equals(this.eEF.cdm, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void dG(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.eEG != null) {
            this.eEG.setAudioMute(z);
        }
        if (this.eED != null) {
            this.eED.dG(z);
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
        if (this.eEG != null) {
            this.eEG.setRenderVideoModel(1, i != 2 ? 1 : 2);
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
        if (this.eEE == 2 && this.eED != null) {
            this.eED.setVideoPath(str);
        }
        return true;
    }

    private boolean bih() {
        boolean z;
        int i;
        int i2;
        CustomResponsedMessage runTask;
        if (this.eEG == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.eEL)) != null && runTask.getData() != null) {
            this.eEG = (com.baidu.tbadk.ala.d) runTask.getData();
            this.eEG.a(this.eEH);
        }
        if (this.eEG == null) {
            return false;
        }
        if (this.eEG.a(1, this.eEF.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
            this.eEK = true;
        }
        FrameLayout videoHolder = this.eEC.getVideoHolder();
        if (videoHolder != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= videoHolder.getChildCount()) {
                    z = false;
                    break;
                } else if (videoHolder.getChildAt(i3) == this.eEG.aGO()) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.eEF.bGR != null) {
                    i2 = this.eEF.bGR.getWidth();
                    i = this.eEF.bGR.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.eEM, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.eEF.toString(), "position", this.eEF.bGR == null ? "null" : this.eEF.bGR.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                    i2 = 0;
                }
                videoHolder.addView(this.eEG.aGO(), new LinearLayout.LayoutParams(i2, i));
                if (TextUtils.equals(this.eEF.cdm, "contain")) {
                    setVideoScalingMode(2);
                } else {
                    setVideoScalingMode(0);
                }
            }
        }
        return true;
    }

    private boolean bii() {
        boolean z;
        int i;
        int i2 = 0;
        if (this.eEE != 2) {
            return false;
        }
        if (this.eED == null) {
            this.eED = new SwanVideoView(this.eEL);
        }
        if (this.eED.getParent() == null) {
            this.eEC.getVideoHolder().addView(this.eED);
        }
        this.eED.setVideoPath(this.eEF.mSrc);
        this.eED.start();
        this.eEK = true;
        if (this.eEC.getVideoHolder() != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.eEC.getVideoHolder().getChildCount()) {
                    z = false;
                    break;
                } else if (this.eEC.getVideoHolder().getChildAt(i3) == this.eED) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.eEF.bGR != null) {
                    i = this.eEF.bGR.getWidth();
                    i2 = this.eEF.bGR.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.eEM, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.eEF.toString(), "position", this.eEF.bGR == null ? "null" : this.eEF.bGR.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                }
                this.eEC.getVideoHolder().addView(this.eEG.aGO(), new LinearLayout.LayoutParams(i, i2));
            }
        }
        return true;
    }

    private void b(a aVar) {
        if (this.eEC == null) {
            this.eEC = new VideoContainerManager(this.eEL, aVar);
        }
        if (this.Yn) {
            this.eEC.biw().setHidden(aVar.hidden);
        } else {
            this.eEC.j(aVar);
        }
    }

    private void c(a aVar) {
        BdLog.d("initVideoCoverContainer 00");
        b(aVar);
    }

    private boolean d(a aVar) {
        if (this.eEF == null) {
            return false;
        }
        return (this.eEF.eEs == aVar.eEs && this.eEF.eEu == aVar.eEu && this.eEF.eEv == aVar.eEv && TextUtils.equals(this.eEF.eEw, aVar.eEw) && TextUtils.equals(this.eEF.cdm, aVar.cdm)) ? false : true;
    }

    public void e(@NonNull a aVar) {
        BdLog.d("updatePlayerConfig params: " + aVar.toString());
        if (d(aVar)) {
            this.eEF = aVar;
            big();
        }
        this.eEF = aVar;
        c(this.eEF);
    }

    public boolean isPlaying() {
        if (this.eEE == 1 && this.eEG != null) {
            return this.eEK;
        }
        if (this.eEE == 2 && this.eED != null) {
            return this.eED.isPlaying();
        }
        return false;
    }

    public void stop() {
        if (this.eEG != null) {
            bs(this.eEG.aGO());
            this.eEG.stop();
            this.eEG.destroy();
            this.eEG.a(null);
            this.eEG = null;
            this.eEK = false;
        }
        if (this.eED != null) {
            bs(this.eED);
            this.eED.stopPlayback();
            this.eED = null;
            this.eEK = false;
        }
    }

    public void g(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.Yn = z;
        int equipmentWidth = l.getEquipmentWidth(this.eEL);
        int equipmentHeight = l.getEquipmentHeight(this.eEL);
        if (z) {
            if (i == 90 || i == -90) {
                this.eEJ.Fe();
                equipmentWidth = equipmentHeight;
                equipmentHeight = equipmentWidth;
            }
        } else if (this.eEL.getRequestedOrientation() != 1) {
            this.eEJ.Fe();
        }
        if (z) {
            a(this.eEL, i, equipmentWidth, equipmentHeight);
        } else {
            h(this.eEL, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null && this.eEC != null) {
            this.Yn = true;
            if (this.eEC != null && this.eEC.getVideoHolder().getParent() != null) {
                bs(this.eEC.getVideoHolder());
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.eEC.biw());
                viewGroup.addView(this.eEC.biw());
            }
            this.eEC.biw().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void h(Activity activity, int i) {
        if (activity == null || this.eEF == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.Yn = false;
        if (this.eEC.getVideoHolder().getParent() != null) {
            bs(this.eEC.getVideoHolder());
        }
        if (this.eEG != null && this.eEG.aGO().getParent() != null) {
            bs(this.eEG.aGO());
        }
        int width = this.eEF.bGR.getWidth();
        int height = this.eEF.bGR.getHeight();
        this.eEF.bGR.getLeft();
        this.eEF.bGR.getTop();
        this.eEC.getVideoHolder().addView(this.eEG.aGO(), new LinearLayout.LayoutParams(width, height));
        this.eEC.Sv();
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bij() {
        String jSONString = this.eEI.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            BdLog.d(this.bYY + " dispatchNetStatusEvent statusData: " + jSONString);
            c.aa(getSlaveId(), aeS(), jSONString);
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String aeT() {
        return null;
    }

    private static int yU(String str) {
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
