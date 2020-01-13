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
/* loaded from: classes10.dex */
public class f implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean EA;
    private String bwp;
    private SwanVideoView eaa;
    private com.baidu.tbadk.ala.d ead;
    private d.a eae;
    private o eag;
    private Activity eai;
    private boolean mDetached;
    CustomMessageListener tB;
    private VideoContainerManager dZZ = null;
    private int eab = 0;
    private a eac = a.aXE();
    private com.baidu.tieba.aiapps.apps.media.b.a.a eaf = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean eah = false;
    private String eaj = "AiAppLiveErr";

    public f(Context context, String str) {
        this.bwp = str;
        this.eai = (Activity) context;
        if (!TextUtils.isEmpty(this.bwp)) {
            com.baidu.swan.apps.media.b.a(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.bwp);
        initData();
        MessageManager.getInstance().registerListener(this.tB);
        this.eag = new o(this.eai);
        this.eag.start();
        this.eai.getWindow().addFlags(128);
    }

    private void initData() {
        this.eae = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.f.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + HanziToPinyin.Token.SEPARATOR + i3);
                f.this.eaf.mVideoWidth = i2;
                f.this.eaf.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && f.this.eaf != null) {
                    if (alaLivePlayerData.fpsAvg != f.this.eaf.eal) {
                    }
                    if (alaLivePlayerData.videoBitrate != f.this.eaf.aGT) {
                    }
                    if (alaLivePlayerData.audioBitrate != f.this.eaf.aGZ) {
                    }
                    f.this.eaf.eam = (int) alaLivePlayerData.bandWidth;
                    f.this.eaf.eal = (int) alaLivePlayerData.fpsAvg;
                    f.this.eaf.aGZ = (int) alaLivePlayerData.audioBitrate;
                    f.this.eaf.aGT = (int) alaLivePlayerData.videoBitrate;
                }
            }
        };
        this.tB = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.aiapps.apps.media.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    f.this.aXM();
                }
            }
        };
    }

    public a aXG() {
        return this.eac;
    }

    public void a(a aVar) {
        this.eac = aVar;
        if (!this.eac.hidden && this.eac.bwx) {
            start();
        }
    }

    public void start() {
        if (this.eac != null) {
            if (this.eac.hidden) {
                BdLog.d("mPlayerId = " + this.bwp + "can not start(), hide = " + this.eac.hidden);
                return;
            }
            BdLog.d(this.bwp + " start()");
            if (this.eab == 0) {
                this.eab = xj(this.eac.mSrc);
            }
            if (this.eab == 0) {
                BdLog.e("unsupport  url type error src = " + this.eac.mSrc);
                return;
            }
            if (this.ead != null || this.eaa != null) {
                aXH();
            }
            aXI();
            aXI().aXX();
            aXJ();
            c(this.eac);
            c(this.eac.mSrc, "", "", false);
            if (this.eab == 1) {
                aXK();
            } else if (this.eab == 2) {
                aXL();
            }
            this.mDetached = false;
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String UK() {
        return this.bwp;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.eac.bdW;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object UM() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cJ(boolean z) {
        BdLog.d("onForegroundChanged " + z);
        if (!z) {
            aXH();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void cK(boolean z) {
        BdLog.d("onAppForegroundChanged " + z);
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        BdLog.d("onBackPressed ");
        if (this.eac != null && this.dZZ != null && d(this.eai, this.dZZ.getVideoHolder())) {
            if (this.eai.getRequestedOrientation() != 1) {
                this.eag.xH();
            }
            e(this.eai, 0);
            return true;
        }
        release();
        return false;
    }

    public void aXH() {
        if (this.ead != null) {
            br(this.ead.awn());
            this.ead.stop();
            this.ead.destroy();
        }
        this.ead = null;
        if (this.eaa != null) {
            this.eaa.stopPlayback();
            br(this.eaa);
        }
        this.eaa = null;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.bwp + " release()");
        this.eai.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.tB);
        com.baidu.swan.apps.media.b.b(this);
        this.eag.stop();
        if (this.ead != null) {
            br(this.ead.awn());
            this.ead.stop();
            this.ead.destroy();
            this.ead = null;
        }
        if (this.eaa != null) {
            br(this.eaa);
            this.eaa.stopPlayback();
            this.eaa = null;
        }
        if (this.dZZ != null) {
            this.dZZ.Iq();
            this.dZZ = null;
        }
    }

    private VideoContainerManager aXI() {
        if (this.dZZ == null && this.eac != null) {
            this.dZZ = new VideoContainerManager(this.eai, this.eac);
        }
        return this.dZZ;
    }

    private void aXJ() {
        cC(this.eac.dZP);
        ob(this.eac.dZR);
        oc(this.eac.dZS);
        if (TextUtils.equals(this.eac.dZT, HorizontalTranslateLayout.HORIZONTAL)) {
            setVideoRotation(90);
        } else {
            setVideoRotation(0);
        }
        if (TextUtils.equals(this.eac.bAd, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void cC(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.ead != null) {
            this.ead.setAudioMute(z);
        }
        if (this.eaa != null) {
            this.eaa.cC(z);
        }
    }

    public void ob(int i) {
    }

    public void oc(int i) {
    }

    public void setVideoRotation(int i) {
    }

    public void setVideoScalingMode(int i) {
        BdLog.d("setVideoScalingMode scalingMode: " + i);
        if (this.ead != null) {
            this.ead.setRenderVideoModel(1, i != 2 ? 1 : 2);
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
        if (this.eab == 2 && this.eaa != null) {
            this.eaa.setVideoPath(str);
        }
        return true;
    }

    private boolean aXK() {
        boolean z;
        int i;
        int i2;
        CustomResponsedMessage runTask;
        if (this.ead == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.eai)) != null && runTask.getData() != null) {
            this.ead = (com.baidu.tbadk.ala.d) runTask.getData();
            this.ead.a(this.eae);
        }
        if (this.ead == null) {
            return false;
        }
        if (this.ead.a(1, this.eac.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
            this.eah = true;
        }
        FrameLayout videoHolder = this.dZZ.getVideoHolder();
        if (videoHolder != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= videoHolder.getChildCount()) {
                    z = false;
                    break;
                } else if (videoHolder.getChildAt(i3) == this.ead.awn()) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.eac.bdZ != null) {
                    i2 = this.eac.bdZ.getWidth();
                    i = this.eac.bdZ.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.eaj, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.eac.toString(), "position", this.eac.bdZ == null ? "null" : this.eac.bdZ.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                    i2 = 0;
                }
                videoHolder.addView(this.ead.awn(), new LinearLayout.LayoutParams(i2, i));
                if (TextUtils.equals(this.eac.bAd, "contain")) {
                    setVideoScalingMode(2);
                } else {
                    setVideoScalingMode(0);
                }
            }
        }
        return true;
    }

    private boolean aXL() {
        boolean z;
        int i;
        int i2 = 0;
        if (this.eab != 2) {
            return false;
        }
        if (this.eaa == null) {
            this.eaa = new SwanVideoView(this.eai);
        }
        if (this.eaa.getParent() == null) {
            this.dZZ.getVideoHolder().addView(this.eaa);
        }
        this.eaa.setVideoPath(this.eac.mSrc);
        this.eaa.start();
        this.eah = true;
        if (this.dZZ.getVideoHolder() != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.dZZ.getVideoHolder().getChildCount()) {
                    z = false;
                    break;
                } else if (this.dZZ.getVideoHolder().getChildAt(i3) == this.eaa) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.eac.bdZ != null) {
                    i = this.eac.bdZ.getWidth();
                    i2 = this.eac.bdZ.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.eaj, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.eac.toString(), "position", this.eac.bdZ == null ? "null" : this.eac.bdZ.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                }
                this.dZZ.getVideoHolder().addView(this.ead.awn(), new LinearLayout.LayoutParams(i, i2));
            }
        }
        return true;
    }

    private void b(a aVar) {
        if (this.dZZ == null) {
            this.dZZ = new VideoContainerManager(this.eai, aVar);
        }
        if (this.EA) {
            this.dZZ.aXZ().setHidden(aVar.hidden);
        } else {
            this.dZZ.j(aVar);
        }
    }

    private void c(a aVar) {
        BdLog.d("initVideoCoverContainer 00");
        b(aVar);
    }

    private boolean d(a aVar) {
        if (this.eac == null) {
            return false;
        }
        return (this.eac.dZP == aVar.dZP && this.eac.dZR == aVar.dZR && this.eac.dZS == aVar.dZS && TextUtils.equals(this.eac.dZT, aVar.dZT) && TextUtils.equals(this.eac.bAd, aVar.bAd)) ? false : true;
    }

    public void e(@NonNull a aVar) {
        BdLog.d("updatePlayerConfig params: " + aVar.toString());
        if (d(aVar)) {
            this.eac = aVar;
            aXJ();
        }
        this.eac = aVar;
        c(this.eac);
    }

    public boolean isPlaying() {
        if (this.eab == 1 && this.ead != null) {
            return this.eah;
        }
        if (this.eab == 2 && this.eaa != null) {
            return this.eaa.isPlaying();
        }
        return false;
    }

    public void stop() {
        if (this.ead != null) {
            br(this.ead.awn());
            this.ead.stop();
            this.ead.destroy();
            this.ead.a(null);
            this.ead = null;
            this.eah = false;
        }
        if (this.eaa != null) {
            br(this.eaa);
            this.eaa.stopPlayback();
            this.eaa = null;
            this.eah = false;
        }
    }

    public void e(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.EA = z;
        int equipmentWidth = l.getEquipmentWidth(this.eai);
        int equipmentHeight = l.getEquipmentHeight(this.eai);
        if (z) {
            if (i == 90 || i == -90) {
                this.eag.xH();
                equipmentWidth = equipmentHeight;
                equipmentHeight = equipmentWidth;
            }
        } else if (this.eai.getRequestedOrientation() != 1) {
            this.eag.xH();
        }
        if (z) {
            a(this.eai, i, equipmentWidth, equipmentHeight);
        } else {
            e(this.eai, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null && this.dZZ != null) {
            this.EA = true;
            if (this.dZZ != null && this.dZZ.getVideoHolder().getParent() != null) {
                br(this.dZZ.getVideoHolder());
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.dZZ.aXZ());
                viewGroup.addView(this.dZZ.aXZ());
            }
            this.dZZ.aXZ().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void e(Activity activity, int i) {
        if (activity == null || this.eac == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.EA = false;
        if (this.dZZ.getVideoHolder().getParent() != null) {
            br(this.dZZ.getVideoHolder());
        }
        if (this.ead != null && this.ead.awn().getParent() != null) {
            br(this.ead.awn());
        }
        int width = this.eac.bdZ.getWidth();
        int height = this.eac.bdZ.getHeight();
        this.eac.bdZ.getLeft();
        this.eac.bdZ.getTop();
        this.dZZ.getVideoHolder().addView(this.ead.awn(), new LinearLayout.LayoutParams(width, height));
        this.dZZ.Io();
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXM() {
        String jSONString = this.eaf.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            BdLog.d(this.bwp + " dispatchNetStatusEvent statusData: " + jSONString);
            c.aa(getSlaveId(), UK(), jSONString);
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String UL() {
        return null;
    }

    private static int xj(String str) {
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
