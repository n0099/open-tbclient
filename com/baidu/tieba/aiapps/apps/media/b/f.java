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
    private String bAy;
    private SwanVideoView eed;
    private com.baidu.tbadk.ala.d eeg;
    private d.a eeh;
    private o eej;
    private Activity eel;
    private boolean mDetached;
    CustomMessageListener tR;
    private VideoContainerManager eec = null;
    private int eee = 0;
    private a eef = a.aZT();
    private com.baidu.tieba.aiapps.apps.media.b.a.a eei = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean eek = false;
    private String eem = "AiAppLiveErr";

    public f(Context context, String str) {
        this.bAy = str;
        this.eel = (Activity) context;
        if (!TextUtils.isEmpty(this.bAy)) {
            com.baidu.swan.apps.media.b.a(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.bAy);
        initData();
        MessageManager.getInstance().registerListener(this.tR);
        this.eej = new o(this.eel);
        this.eej.start();
        this.eel.getWindow().addFlags(128);
    }

    private void initData() {
        this.eeh = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.f.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + HanziToPinyin.Token.SEPARATOR + i3);
                f.this.eei.mVideoWidth = i2;
                f.this.eei.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && f.this.eei != null) {
                    if (alaLivePlayerData.fpsAvg != f.this.eei.eeo) {
                    }
                    if (alaLivePlayerData.videoBitrate != f.this.eei.aKY) {
                    }
                    if (alaLivePlayerData.audioBitrate != f.this.eei.aLe) {
                    }
                    f.this.eei.eep = (int) alaLivePlayerData.bandWidth;
                    f.this.eei.eeo = (int) alaLivePlayerData.fpsAvg;
                    f.this.eei.aLe = (int) alaLivePlayerData.audioBitrate;
                    f.this.eei.aKY = (int) alaLivePlayerData.videoBitrate;
                }
            }
        };
        this.tR = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.aiapps.apps.media.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    f.this.bab();
                }
            }
        };
    }

    public a aZV() {
        return this.eef;
    }

    public void a(a aVar) {
        this.eef = aVar;
        if (!this.eef.hidden && this.eef.bAG) {
            start();
        }
    }

    public void start() {
        if (this.eef != null) {
            if (this.eef.hidden) {
                BdLog.d("mPlayerId = " + this.bAy + "can not start(), hide = " + this.eef.hidden);
                return;
            }
            BdLog.d(this.bAy + " start()");
            if (this.eee == 0) {
                this.eee = xD(this.eef.mSrc);
            }
            if (this.eee == 0) {
                BdLog.e("unsupport  url type error src = " + this.eef.mSrc);
                return;
            }
            if (this.eeg != null || this.eed != null) {
                aZW();
            }
            aZX();
            aZX().bam();
            aZY();
            c(this.eef);
            c(this.eef.mSrc, "", "", false);
            if (this.eee == 1) {
                aZZ();
            } else if (this.eee == 2) {
                baa();
            }
            this.mDetached = false;
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String WY() {
        return this.bAy;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.eef.bil;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Xa() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cQ(boolean z) {
        BdLog.d("onForegroundChanged " + z);
        if (!z) {
            aZW();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void cR(boolean z) {
        BdLog.d("onAppForegroundChanged " + z);
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        BdLog.d("onBackPressed ");
        if (this.eef != null && this.eec != null && d(this.eel, this.eec.getVideoHolder())) {
            if (this.eel.getRequestedOrientation() != 1) {
                this.eej.zY();
            }
            e(this.eel, 0);
            return true;
        }
        release();
        return false;
    }

    public void aZW() {
        if (this.eeg != null) {
            br(this.eeg.ayA());
            this.eeg.stop();
            this.eeg.destroy();
        }
        this.eeg = null;
        if (this.eed != null) {
            this.eed.stopPlayback();
            br(this.eed);
        }
        this.eed = null;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.bAy + " release()");
        this.eel.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.tR);
        com.baidu.swan.apps.media.b.b(this);
        this.eej.stop();
        if (this.eeg != null) {
            br(this.eeg.ayA());
            this.eeg.stop();
            this.eeg.destroy();
            this.eeg = null;
        }
        if (this.eed != null) {
            br(this.eed);
            this.eed.stopPlayback();
            this.eed = null;
        }
        if (this.eec != null) {
            this.eec.KF();
            this.eec = null;
        }
    }

    private VideoContainerManager aZX() {
        if (this.eec == null && this.eef != null) {
            this.eec = new VideoContainerManager(this.eel, this.eef);
        }
        return this.eec;
    }

    private void aZY() {
        cJ(this.eef.edS);
        os(this.eef.edU);
        ot(this.eef.edV);
        if (TextUtils.equals(this.eef.edW, HorizontalTranslateLayout.HORIZONTAL)) {
            setVideoRotation(90);
        } else {
            setVideoRotation(0);
        }
        if (TextUtils.equals(this.eef.bEj, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void cJ(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.eeg != null) {
            this.eeg.setAudioMute(z);
        }
        if (this.eed != null) {
            this.eed.cJ(z);
        }
    }

    public void os(int i) {
    }

    public void ot(int i) {
    }

    public void setVideoRotation(int i) {
    }

    public void setVideoScalingMode(int i) {
        BdLog.d("setVideoScalingMode scalingMode: " + i);
        if (this.eeg != null) {
            this.eeg.setRenderVideoModel(1, i != 2 ? 1 : 2);
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
        if (this.eee == 2 && this.eed != null) {
            this.eed.setVideoPath(str);
        }
        return true;
    }

    private boolean aZZ() {
        boolean z;
        int i;
        int i2;
        CustomResponsedMessage runTask;
        if (this.eeg == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.eel)) != null && runTask.getData() != null) {
            this.eeg = (com.baidu.tbadk.ala.d) runTask.getData();
            this.eeg.a(this.eeh);
        }
        if (this.eeg == null) {
            return false;
        }
        if (this.eeg.a(1, this.eef.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
            this.eek = true;
        }
        FrameLayout videoHolder = this.eec.getVideoHolder();
        if (videoHolder != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= videoHolder.getChildCount()) {
                    z = false;
                    break;
                } else if (videoHolder.getChildAt(i3) == this.eeg.ayA()) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.eef.bip != null) {
                    i2 = this.eef.bip.getWidth();
                    i = this.eef.bip.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.eem, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.eef.toString(), "position", this.eef.bip == null ? "null" : this.eef.bip.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                    i2 = 0;
                }
                videoHolder.addView(this.eeg.ayA(), new LinearLayout.LayoutParams(i2, i));
                if (TextUtils.equals(this.eef.bEj, "contain")) {
                    setVideoScalingMode(2);
                } else {
                    setVideoScalingMode(0);
                }
            }
        }
        return true;
    }

    private boolean baa() {
        boolean z;
        int i;
        int i2 = 0;
        if (this.eee != 2) {
            return false;
        }
        if (this.eed == null) {
            this.eed = new SwanVideoView(this.eel);
        }
        if (this.eed.getParent() == null) {
            this.eec.getVideoHolder().addView(this.eed);
        }
        this.eed.setVideoPath(this.eef.mSrc);
        this.eed.start();
        this.eek = true;
        if (this.eec.getVideoHolder() != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.eec.getVideoHolder().getChildCount()) {
                    z = false;
                    break;
                } else if (this.eec.getVideoHolder().getChildAt(i3) == this.eed) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.eef.bip != null) {
                    i = this.eef.bip.getWidth();
                    i2 = this.eef.bip.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.eem, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.eef.toString(), "position", this.eef.bip == null ? "null" : this.eef.bip.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                }
                this.eec.getVideoHolder().addView(this.eeg.ayA(), new LinearLayout.LayoutParams(i, i2));
            }
        }
        return true;
    }

    private void b(a aVar) {
        if (this.eec == null) {
            this.eec = new VideoContainerManager(this.eel, aVar);
        }
        if (this.EV) {
            this.eec.bao().setHidden(aVar.hidden);
        } else {
            this.eec.j(aVar);
        }
    }

    private void c(a aVar) {
        BdLog.d("initVideoCoverContainer 00");
        b(aVar);
    }

    private boolean d(a aVar) {
        if (this.eef == null) {
            return false;
        }
        return (this.eef.edS == aVar.edS && this.eef.edU == aVar.edU && this.eef.edV == aVar.edV && TextUtils.equals(this.eef.edW, aVar.edW) && TextUtils.equals(this.eef.bEj, aVar.bEj)) ? false : true;
    }

    public void e(@NonNull a aVar) {
        BdLog.d("updatePlayerConfig params: " + aVar.toString());
        if (d(aVar)) {
            this.eef = aVar;
            aZY();
        }
        this.eef = aVar;
        c(this.eef);
    }

    public boolean isPlaying() {
        if (this.eee == 1 && this.eeg != null) {
            return this.eek;
        }
        if (this.eee == 2 && this.eed != null) {
            return this.eed.isPlaying();
        }
        return false;
    }

    public void stop() {
        if (this.eeg != null) {
            br(this.eeg.ayA());
            this.eeg.stop();
            this.eeg.destroy();
            this.eeg.a(null);
            this.eeg = null;
            this.eek = false;
        }
        if (this.eed != null) {
            br(this.eed);
            this.eed.stopPlayback();
            this.eed = null;
            this.eek = false;
        }
    }

    public void f(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.EV = z;
        int equipmentWidth = l.getEquipmentWidth(this.eel);
        int equipmentHeight = l.getEquipmentHeight(this.eel);
        if (z) {
            if (i == 90 || i == -90) {
                this.eej.zY();
                equipmentWidth = equipmentHeight;
                equipmentHeight = equipmentWidth;
            }
        } else if (this.eel.getRequestedOrientation() != 1) {
            this.eej.zY();
        }
        if (z) {
            a(this.eel, i, equipmentWidth, equipmentHeight);
        } else {
            e(this.eel, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null && this.eec != null) {
            this.EV = true;
            if (this.eec != null && this.eec.getVideoHolder().getParent() != null) {
                br(this.eec.getVideoHolder());
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.eec.bao());
                viewGroup.addView(this.eec.bao());
            }
            this.eec.bao().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void e(Activity activity, int i) {
        if (activity == null || this.eef == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.EV = false;
        if (this.eec.getVideoHolder().getParent() != null) {
            br(this.eec.getVideoHolder());
        }
        if (this.eeg != null && this.eeg.ayA().getParent() != null) {
            br(this.eeg.ayA());
        }
        int width = this.eef.bip.getWidth();
        int height = this.eef.bip.getHeight();
        this.eef.bip.getLeft();
        this.eef.bip.getTop();
        this.eec.getVideoHolder().addView(this.eeg.ayA(), new LinearLayout.LayoutParams(width, height));
        this.eec.KD();
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bab() {
        String jSONString = this.eei.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            BdLog.d(this.bAy + " dispatchNetStatusEvent statusData: " + jSONString);
            c.ab(getSlaveId(), WY(), jSONString);
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String WZ() {
        return null;
    }

    private static int xD(String str) {
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
