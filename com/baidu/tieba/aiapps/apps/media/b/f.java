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
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
    private boolean EV;
    private String bAL;
    private SwanVideoView eeH;
    private com.baidu.tbadk.ala.d eeK;
    private d.a eeL;
    private o eeN;
    private Activity eeP;
    private boolean mDetached;
    CustomMessageListener tR;
    private VideoContainerManager eeG = null;
    private int eeI = 0;
    private a eeJ = a.baa();
    private com.baidu.tieba.aiapps.apps.media.b.a.a eeM = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean eeO = false;
    private String eeQ = "AiAppLiveErr";

    public f(Context context, String str) {
        this.bAL = str;
        this.eeP = (Activity) context;
        if (!TextUtils.isEmpty(this.bAL)) {
            com.baidu.swan.apps.media.b.a(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.bAL);
        initData();
        MessageManager.getInstance().registerListener(this.tR);
        this.eeN = new o(this.eeP);
        this.eeN.start();
        this.eeP.getWindow().addFlags(128);
    }

    private void initData() {
        this.eeL = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.f.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + HanziToPinyin.Token.SEPARATOR + i3);
                f.this.eeM.mVideoWidth = i2;
                f.this.eeM.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && f.this.eeM != null) {
                    if (alaLivePlayerData.fpsAvg != f.this.eeM.eeS) {
                    }
                    if (alaLivePlayerData.videoBitrate != f.this.eeM.aLo) {
                    }
                    if (alaLivePlayerData.audioBitrate != f.this.eeM.aLu) {
                    }
                    f.this.eeM.eeT = (int) alaLivePlayerData.bandWidth;
                    f.this.eeM.eeS = (int) alaLivePlayerData.fpsAvg;
                    f.this.eeM.aLu = (int) alaLivePlayerData.audioBitrate;
                    f.this.eeM.aLo = (int) alaLivePlayerData.videoBitrate;
                }
            }
        };
        this.tR = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.aiapps.apps.media.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    f.this.bai();
                }
            }
        };
    }

    public a bac() {
        return this.eeJ;
    }

    public void a(a aVar) {
        this.eeJ = aVar;
        if (!this.eeJ.hidden && this.eeJ.bAT) {
            start();
        }
    }

    public void start() {
        if (this.eeJ != null) {
            if (this.eeJ.hidden) {
                BdLog.d("mPlayerId = " + this.bAL + "can not start(), hide = " + this.eeJ.hidden);
                return;
            }
            BdLog.d(this.bAL + " start()");
            if (this.eeI == 0) {
                this.eeI = xF(this.eeJ.mSrc);
            }
            if (this.eeI == 0) {
                BdLog.e("unsupport  url type error src = " + this.eeJ.mSrc);
                return;
            }
            if (this.eeK != null || this.eeH != null) {
                bad();
            }
            bae();
            bae().bat();
            baf();
            c(this.eeJ);
            c(this.eeJ.mSrc, "", "", false);
            if (this.eeI == 1) {
                bag();
            } else if (this.eeI == 2) {
                bah();
            }
            this.mDetached = false;
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xd() {
        return this.bAL;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.eeJ.biB;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Xf() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cR(boolean z) {
        BdLog.d("onForegroundChanged " + z);
        if (!z) {
            bad();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void cS(boolean z) {
        BdLog.d("onAppForegroundChanged " + z);
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        BdLog.d("onBackPressed ");
        if (this.eeJ != null && this.eeG != null && d(this.eeP, this.eeG.getVideoHolder())) {
            if (this.eeP.getRequestedOrientation() != 1) {
                this.eeN.Ah();
            }
            i(this.eeP, 0);
            return true;
        }
        release();
        return false;
    }

    public void bad() {
        if (this.eeK != null) {
            br(this.eeK.ayF());
            this.eeK.stop();
            this.eeK.destroy();
        }
        this.eeK = null;
        if (this.eeH != null) {
            this.eeH.stopPlayback();
            br(this.eeH);
        }
        this.eeH = null;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.bAL + " release()");
        this.eeP.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.tR);
        com.baidu.swan.apps.media.b.b(this);
        this.eeN.stop();
        if (this.eeK != null) {
            br(this.eeK.ayF());
            this.eeK.stop();
            this.eeK.destroy();
            this.eeK = null;
        }
        if (this.eeH != null) {
            br(this.eeH);
            this.eeH.stopPlayback();
            this.eeH = null;
        }
        if (this.eeG != null) {
            this.eeG.KK();
            this.eeG = null;
        }
    }

    private VideoContainerManager bae() {
        if (this.eeG == null && this.eeJ != null) {
            this.eeG = new VideoContainerManager(this.eeP, this.eeJ);
        }
        return this.eeG;
    }

    private void baf() {
        cK(this.eeJ.eew);
        ou(this.eeJ.eey);
        ov(this.eeJ.eez);
        if (TextUtils.equals(this.eeJ.eeA, HorizontalTranslateLayout.HORIZONTAL)) {
            setVideoRotation(90);
        } else {
            setVideoRotation(0);
        }
        if (TextUtils.equals(this.eeJ.bEw, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void cK(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.eeK != null) {
            this.eeK.setAudioMute(z);
        }
        if (this.eeH != null) {
            this.eeH.cK(z);
        }
    }

    public void ou(int i) {
    }

    public void ov(int i) {
    }

    public void setVideoRotation(int i) {
    }

    public void setVideoScalingMode(int i) {
        BdLog.d("setVideoScalingMode scalingMode: " + i);
        if (this.eeK != null) {
            this.eeK.setRenderVideoModel(1, i != 2 ? 1 : 2);
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
        if (this.eeI == 2 && this.eeH != null) {
            this.eeH.setVideoPath(str);
        }
        return true;
    }

    private boolean bag() {
        boolean z;
        int i;
        int i2;
        CustomResponsedMessage runTask;
        if (this.eeK == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.eeP)) != null && runTask.getData() != null) {
            this.eeK = (com.baidu.tbadk.ala.d) runTask.getData();
            this.eeK.a(this.eeL);
        }
        if (this.eeK == null) {
            return false;
        }
        if (this.eeK.a(1, this.eeJ.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
            this.eeO = true;
        }
        FrameLayout videoHolder = this.eeG.getVideoHolder();
        if (videoHolder != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= videoHolder.getChildCount()) {
                    z = false;
                    break;
                } else if (videoHolder.getChildAt(i3) == this.eeK.ayF()) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.eeJ.biE != null) {
                    i2 = this.eeJ.biE.getWidth();
                    i = this.eeJ.biE.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.eeQ, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.eeJ.toString(), "position", this.eeJ.biE == null ? "null" : this.eeJ.biE.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                    i2 = 0;
                }
                videoHolder.addView(this.eeK.ayF(), new LinearLayout.LayoutParams(i2, i));
                if (TextUtils.equals(this.eeJ.bEw, "contain")) {
                    setVideoScalingMode(2);
                } else {
                    setVideoScalingMode(0);
                }
            }
        }
        return true;
    }

    private boolean bah() {
        boolean z;
        int i;
        int i2 = 0;
        if (this.eeI != 2) {
            return false;
        }
        if (this.eeH == null) {
            this.eeH = new SwanVideoView(this.eeP);
        }
        if (this.eeH.getParent() == null) {
            this.eeG.getVideoHolder().addView(this.eeH);
        }
        this.eeH.setVideoPath(this.eeJ.mSrc);
        this.eeH.start();
        this.eeO = true;
        if (this.eeG.getVideoHolder() != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.eeG.getVideoHolder().getChildCount()) {
                    z = false;
                    break;
                } else if (this.eeG.getVideoHolder().getChildAt(i3) == this.eeH) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.eeJ.biE != null) {
                    i = this.eeJ.biE.getWidth();
                    i2 = this.eeJ.biE.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.eeQ, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.eeJ.toString(), "position", this.eeJ.biE == null ? "null" : this.eeJ.biE.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                }
                this.eeG.getVideoHolder().addView(this.eeK.ayF(), new LinearLayout.LayoutParams(i, i2));
            }
        }
        return true;
    }

    private void b(a aVar) {
        if (this.eeG == null) {
            this.eeG = new VideoContainerManager(this.eeP, aVar);
        }
        if (this.EV) {
            this.eeG.bav().setHidden(aVar.hidden);
        } else {
            this.eeG.j(aVar);
        }
    }

    private void c(a aVar) {
        BdLog.d("initVideoCoverContainer 00");
        b(aVar);
    }

    private boolean d(a aVar) {
        if (this.eeJ == null) {
            return false;
        }
        return (this.eeJ.eew == aVar.eew && this.eeJ.eey == aVar.eey && this.eeJ.eez == aVar.eez && TextUtils.equals(this.eeJ.eeA, aVar.eeA) && TextUtils.equals(this.eeJ.bEw, aVar.bEw)) ? false : true;
    }

    public void e(@NonNull a aVar) {
        BdLog.d("updatePlayerConfig params: " + aVar.toString());
        if (d(aVar)) {
            this.eeJ = aVar;
            baf();
        }
        this.eeJ = aVar;
        c(this.eeJ);
    }

    public boolean isPlaying() {
        if (this.eeI == 1 && this.eeK != null) {
            return this.eeO;
        }
        if (this.eeI == 2 && this.eeH != null) {
            return this.eeH.isPlaying();
        }
        return false;
    }

    public void stop() {
        if (this.eeK != null) {
            br(this.eeK.ayF());
            this.eeK.stop();
            this.eeK.destroy();
            this.eeK.a(null);
            this.eeK = null;
            this.eeO = false;
        }
        if (this.eeH != null) {
            br(this.eeH);
            this.eeH.stopPlayback();
            this.eeH = null;
            this.eeO = false;
        }
    }

    public void f(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.EV = z;
        int equipmentWidth = l.getEquipmentWidth(this.eeP);
        int equipmentHeight = l.getEquipmentHeight(this.eeP);
        if (z) {
            if (i == 90 || i == -90) {
                this.eeN.Ah();
                equipmentWidth = equipmentHeight;
                equipmentHeight = equipmentWidth;
            }
        } else if (this.eeP.getRequestedOrientation() != 1) {
            this.eeN.Ah();
        }
        if (z) {
            a(this.eeP, i, equipmentWidth, equipmentHeight);
        } else {
            i(this.eeP, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null && this.eeG != null) {
            this.EV = true;
            if (this.eeG != null && this.eeG.getVideoHolder().getParent() != null) {
                br(this.eeG.getVideoHolder());
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.eeG.bav());
                viewGroup.addView(this.eeG.bav());
            }
            this.eeG.bav().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void i(Activity activity, int i) {
        if (activity == null || this.eeJ == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.EV = false;
        if (this.eeG.getVideoHolder().getParent() != null) {
            br(this.eeG.getVideoHolder());
        }
        if (this.eeK != null && this.eeK.ayF().getParent() != null) {
            br(this.eeK.ayF());
        }
        int width = this.eeJ.biE.getWidth();
        int height = this.eeJ.biE.getHeight();
        this.eeJ.biE.getLeft();
        this.eeJ.biE.getTop();
        this.eeG.getVideoHolder().addView(this.eeK.ayF(), new LinearLayout.LayoutParams(width, height));
        this.eeG.KI();
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bai() {
        String jSONString = this.eeM.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            BdLog.d(this.bAL + " dispatchNetStatusEvent statusData: " + jSONString);
            c.ab(getSlaveId(), Xd(), jSONString);
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xe() {
        return null;
    }

    private static int xF(String str) {
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
