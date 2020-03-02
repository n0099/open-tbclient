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
    private String bAz;
    private SwanVideoView eee;
    private com.baidu.tbadk.ala.d eeh;
    private d.a eei;
    private o eek;
    private Activity eem;
    private boolean mDetached;
    CustomMessageListener tR;
    private VideoContainerManager eed = null;
    private int eef = 0;
    private a eeg = a.aZV();
    private com.baidu.tieba.aiapps.apps.media.b.a.a eej = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean eel = false;
    private String een = "AiAppLiveErr";

    public f(Context context, String str) {
        this.bAz = str;
        this.eem = (Activity) context;
        if (!TextUtils.isEmpty(this.bAz)) {
            com.baidu.swan.apps.media.b.a(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.bAz);
        initData();
        MessageManager.getInstance().registerListener(this.tR);
        this.eek = new o(this.eem);
        this.eek.start();
        this.eem.getWindow().addFlags(128);
    }

    private void initData() {
        this.eei = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.f.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + HanziToPinyin.Token.SEPARATOR + i3);
                f.this.eej.mVideoWidth = i2;
                f.this.eej.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && f.this.eej != null) {
                    if (alaLivePlayerData.fpsAvg != f.this.eej.eep) {
                    }
                    if (alaLivePlayerData.videoBitrate != f.this.eej.aKZ) {
                    }
                    if (alaLivePlayerData.audioBitrate != f.this.eej.aLf) {
                    }
                    f.this.eej.eeq = (int) alaLivePlayerData.bandWidth;
                    f.this.eej.eep = (int) alaLivePlayerData.fpsAvg;
                    f.this.eej.aLf = (int) alaLivePlayerData.audioBitrate;
                    f.this.eej.aKZ = (int) alaLivePlayerData.videoBitrate;
                }
            }
        };
        this.tR = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.aiapps.apps.media.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    f.this.bad();
                }
            }
        };
    }

    public a aZX() {
        return this.eeg;
    }

    public void a(a aVar) {
        this.eeg = aVar;
        if (!this.eeg.hidden && this.eeg.bAH) {
            start();
        }
    }

    public void start() {
        if (this.eeg != null) {
            if (this.eeg.hidden) {
                BdLog.d("mPlayerId = " + this.bAz + "can not start(), hide = " + this.eeg.hidden);
                return;
            }
            BdLog.d(this.bAz + " start()");
            if (this.eef == 0) {
                this.eef = xD(this.eeg.mSrc);
            }
            if (this.eef == 0) {
                BdLog.e("unsupport  url type error src = " + this.eeg.mSrc);
                return;
            }
            if (this.eeh != null || this.eee != null) {
                aZY();
            }
            aZZ();
            aZZ().bao();
            baa();
            c(this.eeg);
            c(this.eeg.mSrc, "", "", false);
            if (this.eef == 1) {
                bab();
            } else if (this.eef == 2) {
                bac();
            }
            this.mDetached = false;
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xa() {
        return this.bAz;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.eeg.bim;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Xc() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cQ(boolean z) {
        BdLog.d("onForegroundChanged " + z);
        if (!z) {
            aZY();
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
        if (this.eeg != null && this.eed != null && d(this.eem, this.eed.getVideoHolder())) {
            if (this.eem.getRequestedOrientation() != 1) {
                this.eek.Aa();
            }
            e(this.eem, 0);
            return true;
        }
        release();
        return false;
    }

    public void aZY() {
        if (this.eeh != null) {
            br(this.eeh.ayC());
            this.eeh.stop();
            this.eeh.destroy();
        }
        this.eeh = null;
        if (this.eee != null) {
            this.eee.stopPlayback();
            br(this.eee);
        }
        this.eee = null;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.bAz + " release()");
        this.eem.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.tR);
        com.baidu.swan.apps.media.b.b(this);
        this.eek.stop();
        if (this.eeh != null) {
            br(this.eeh.ayC());
            this.eeh.stop();
            this.eeh.destroy();
            this.eeh = null;
        }
        if (this.eee != null) {
            br(this.eee);
            this.eee.stopPlayback();
            this.eee = null;
        }
        if (this.eed != null) {
            this.eed.KH();
            this.eed = null;
        }
    }

    private VideoContainerManager aZZ() {
        if (this.eed == null && this.eeg != null) {
            this.eed = new VideoContainerManager(this.eem, this.eeg);
        }
        return this.eed;
    }

    private void baa() {
        cJ(this.eeg.edT);
        os(this.eeg.edV);
        ot(this.eeg.edW);
        if (TextUtils.equals(this.eeg.edX, HorizontalTranslateLayout.HORIZONTAL)) {
            setVideoRotation(90);
        } else {
            setVideoRotation(0);
        }
        if (TextUtils.equals(this.eeg.bEk, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void cJ(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.eeh != null) {
            this.eeh.setAudioMute(z);
        }
        if (this.eee != null) {
            this.eee.cJ(z);
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
        if (this.eeh != null) {
            this.eeh.setRenderVideoModel(1, i != 2 ? 1 : 2);
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
        if (this.eef == 2 && this.eee != null) {
            this.eee.setVideoPath(str);
        }
        return true;
    }

    private boolean bab() {
        boolean z;
        int i;
        int i2;
        CustomResponsedMessage runTask;
        if (this.eeh == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.eem)) != null && runTask.getData() != null) {
            this.eeh = (com.baidu.tbadk.ala.d) runTask.getData();
            this.eeh.a(this.eei);
        }
        if (this.eeh == null) {
            return false;
        }
        if (this.eeh.a(1, this.eeg.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
            this.eel = true;
        }
        FrameLayout videoHolder = this.eed.getVideoHolder();
        if (videoHolder != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= videoHolder.getChildCount()) {
                    z = false;
                    break;
                } else if (videoHolder.getChildAt(i3) == this.eeh.ayC()) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.eeg.biq != null) {
                    i2 = this.eeg.biq.getWidth();
                    i = this.eeg.biq.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.een, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.eeg.toString(), "position", this.eeg.biq == null ? "null" : this.eeg.biq.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                    i2 = 0;
                }
                videoHolder.addView(this.eeh.ayC(), new LinearLayout.LayoutParams(i2, i));
                if (TextUtils.equals(this.eeg.bEk, "contain")) {
                    setVideoScalingMode(2);
                } else {
                    setVideoScalingMode(0);
                }
            }
        }
        return true;
    }

    private boolean bac() {
        boolean z;
        int i;
        int i2 = 0;
        if (this.eef != 2) {
            return false;
        }
        if (this.eee == null) {
            this.eee = new SwanVideoView(this.eem);
        }
        if (this.eee.getParent() == null) {
            this.eed.getVideoHolder().addView(this.eee);
        }
        this.eee.setVideoPath(this.eeg.mSrc);
        this.eee.start();
        this.eel = true;
        if (this.eed.getVideoHolder() != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.eed.getVideoHolder().getChildCount()) {
                    z = false;
                    break;
                } else if (this.eed.getVideoHolder().getChildAt(i3) == this.eee) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.eeg.biq != null) {
                    i = this.eeg.biq.getWidth();
                    i2 = this.eeg.biq.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.een, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.eeg.toString(), "position", this.eeg.biq == null ? "null" : this.eeg.biq.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                }
                this.eed.getVideoHolder().addView(this.eeh.ayC(), new LinearLayout.LayoutParams(i, i2));
            }
        }
        return true;
    }

    private void b(a aVar) {
        if (this.eed == null) {
            this.eed = new VideoContainerManager(this.eem, aVar);
        }
        if (this.EV) {
            this.eed.baq().setHidden(aVar.hidden);
        } else {
            this.eed.j(aVar);
        }
    }

    private void c(a aVar) {
        BdLog.d("initVideoCoverContainer 00");
        b(aVar);
    }

    private boolean d(a aVar) {
        if (this.eeg == null) {
            return false;
        }
        return (this.eeg.edT == aVar.edT && this.eeg.edV == aVar.edV && this.eeg.edW == aVar.edW && TextUtils.equals(this.eeg.edX, aVar.edX) && TextUtils.equals(this.eeg.bEk, aVar.bEk)) ? false : true;
    }

    public void e(@NonNull a aVar) {
        BdLog.d("updatePlayerConfig params: " + aVar.toString());
        if (d(aVar)) {
            this.eeg = aVar;
            baa();
        }
        this.eeg = aVar;
        c(this.eeg);
    }

    public boolean isPlaying() {
        if (this.eef == 1 && this.eeh != null) {
            return this.eel;
        }
        if (this.eef == 2 && this.eee != null) {
            return this.eee.isPlaying();
        }
        return false;
    }

    public void stop() {
        if (this.eeh != null) {
            br(this.eeh.ayC());
            this.eeh.stop();
            this.eeh.destroy();
            this.eeh.a(null);
            this.eeh = null;
            this.eel = false;
        }
        if (this.eee != null) {
            br(this.eee);
            this.eee.stopPlayback();
            this.eee = null;
            this.eel = false;
        }
    }

    public void f(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.EV = z;
        int equipmentWidth = l.getEquipmentWidth(this.eem);
        int equipmentHeight = l.getEquipmentHeight(this.eem);
        if (z) {
            if (i == 90 || i == -90) {
                this.eek.Aa();
                equipmentWidth = equipmentHeight;
                equipmentHeight = equipmentWidth;
            }
        } else if (this.eem.getRequestedOrientation() != 1) {
            this.eek.Aa();
        }
        if (z) {
            a(this.eem, i, equipmentWidth, equipmentHeight);
        } else {
            e(this.eem, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null && this.eed != null) {
            this.EV = true;
            if (this.eed != null && this.eed.getVideoHolder().getParent() != null) {
                br(this.eed.getVideoHolder());
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.eed.baq());
                viewGroup.addView(this.eed.baq());
            }
            this.eed.baq().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void e(Activity activity, int i) {
        if (activity == null || this.eeg == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.EV = false;
        if (this.eed.getVideoHolder().getParent() != null) {
            br(this.eed.getVideoHolder());
        }
        if (this.eeh != null && this.eeh.ayC().getParent() != null) {
            br(this.eeh.ayC());
        }
        int width = this.eeg.biq.getWidth();
        int height = this.eeg.biq.getHeight();
        this.eeg.biq.getLeft();
        this.eeg.biq.getTop();
        this.eed.getVideoHolder().addView(this.eeh.ayC(), new LinearLayout.LayoutParams(width, height));
        this.eed.KF();
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bad() {
        String jSONString = this.eej.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            BdLog.d(this.bAz + " dispatchNetStatusEvent statusData: " + jSONString);
            c.ab(getSlaveId(), Xa(), jSONString);
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xb() {
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
