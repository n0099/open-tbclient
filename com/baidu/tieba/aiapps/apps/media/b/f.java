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
    private String bAA;
    private SwanVideoView eer;
    private com.baidu.tbadk.ala.d eeu;
    private d.a eev;
    private o eex;
    private Activity eez;
    private boolean mDetached;
    CustomMessageListener tR;
    private VideoContainerManager eeq = null;
    private int ees = 0;
    private a eet = a.aZW();
    private com.baidu.tieba.aiapps.apps.media.b.a.a eew = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean eey = false;
    private String eeA = "AiAppLiveErr";

    public f(Context context, String str) {
        this.bAA = str;
        this.eez = (Activity) context;
        if (!TextUtils.isEmpty(this.bAA)) {
            com.baidu.swan.apps.media.b.a(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.bAA);
        initData();
        MessageManager.getInstance().registerListener(this.tR);
        this.eex = new o(this.eez);
        this.eex.start();
        this.eez.getWindow().addFlags(128);
    }

    private void initData() {
        this.eev = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.f.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + HanziToPinyin.Token.SEPARATOR + i3);
                f.this.eew.mVideoWidth = i2;
                f.this.eew.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && f.this.eew != null) {
                    if (alaLivePlayerData.fpsAvg != f.this.eew.eeC) {
                    }
                    if (alaLivePlayerData.videoBitrate != f.this.eew.aLa) {
                    }
                    if (alaLivePlayerData.audioBitrate != f.this.eew.aLg) {
                    }
                    f.this.eew.eeD = (int) alaLivePlayerData.bandWidth;
                    f.this.eew.eeC = (int) alaLivePlayerData.fpsAvg;
                    f.this.eew.aLg = (int) alaLivePlayerData.audioBitrate;
                    f.this.eew.aLa = (int) alaLivePlayerData.videoBitrate;
                }
            }
        };
        this.tR = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.aiapps.apps.media.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    f.this.bae();
                }
            }
        };
    }

    public a aZY() {
        return this.eet;
    }

    public void a(a aVar) {
        this.eet = aVar;
        if (!this.eet.hidden && this.eet.bAI) {
            start();
        }
    }

    public void start() {
        if (this.eet != null) {
            if (this.eet.hidden) {
                BdLog.d("mPlayerId = " + this.bAA + "can not start(), hide = " + this.eet.hidden);
                return;
            }
            BdLog.d(this.bAA + " start()");
            if (this.ees == 0) {
                this.ees = xE(this.eet.mSrc);
            }
            if (this.ees == 0) {
                BdLog.e("unsupport  url type error src = " + this.eet.mSrc);
                return;
            }
            if (this.eeu != null || this.eer != null) {
                aZZ();
            }
            baa();
            baa().bap();
            bab();
            c(this.eet);
            c(this.eet.mSrc, "", "", false);
            if (this.ees == 1) {
                bac();
            } else if (this.ees == 2) {
                bad();
            }
            this.mDetached = false;
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xa() {
        return this.bAA;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.eet.bin;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Xc() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cQ(boolean z) {
        BdLog.d("onForegroundChanged " + z);
        if (!z) {
            aZZ();
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
        if (this.eet != null && this.eeq != null && d(this.eez, this.eeq.getVideoHolder())) {
            if (this.eez.getRequestedOrientation() != 1) {
                this.eex.Aa();
            }
            i(this.eez, 0);
            return true;
        }
        release();
        return false;
    }

    public void aZZ() {
        if (this.eeu != null) {
            br(this.eeu.ayC());
            this.eeu.stop();
            this.eeu.destroy();
        }
        this.eeu = null;
        if (this.eer != null) {
            this.eer.stopPlayback();
            br(this.eer);
        }
        this.eer = null;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.bAA + " release()");
        this.eez.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.tR);
        com.baidu.swan.apps.media.b.b(this);
        this.eex.stop();
        if (this.eeu != null) {
            br(this.eeu.ayC());
            this.eeu.stop();
            this.eeu.destroy();
            this.eeu = null;
        }
        if (this.eer != null) {
            br(this.eer);
            this.eer.stopPlayback();
            this.eer = null;
        }
        if (this.eeq != null) {
            this.eeq.KH();
            this.eeq = null;
        }
    }

    private VideoContainerManager baa() {
        if (this.eeq == null && this.eet != null) {
            this.eeq = new VideoContainerManager(this.eez, this.eet);
        }
        return this.eeq;
    }

    private void bab() {
        cJ(this.eet.eeg);
        os(this.eet.eei);
        ot(this.eet.eej);
        if (TextUtils.equals(this.eet.eek, HorizontalTranslateLayout.HORIZONTAL)) {
            setVideoRotation(90);
        } else {
            setVideoRotation(0);
        }
        if (TextUtils.equals(this.eet.bEl, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void cJ(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.eeu != null) {
            this.eeu.setAudioMute(z);
        }
        if (this.eer != null) {
            this.eer.cJ(z);
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
        if (this.eeu != null) {
            this.eeu.setRenderVideoModel(1, i != 2 ? 1 : 2);
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
        if (this.ees == 2 && this.eer != null) {
            this.eer.setVideoPath(str);
        }
        return true;
    }

    private boolean bac() {
        boolean z;
        int i;
        int i2;
        CustomResponsedMessage runTask;
        if (this.eeu == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.eez)) != null && runTask.getData() != null) {
            this.eeu = (com.baidu.tbadk.ala.d) runTask.getData();
            this.eeu.a(this.eev);
        }
        if (this.eeu == null) {
            return false;
        }
        if (this.eeu.a(1, this.eet.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
            this.eey = true;
        }
        FrameLayout videoHolder = this.eeq.getVideoHolder();
        if (videoHolder != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= videoHolder.getChildCount()) {
                    z = false;
                    break;
                } else if (videoHolder.getChildAt(i3) == this.eeu.ayC()) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.eet.bir != null) {
                    i2 = this.eet.bir.getWidth();
                    i = this.eet.bir.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.eeA, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.eet.toString(), "position", this.eet.bir == null ? "null" : this.eet.bir.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                    i2 = 0;
                }
                videoHolder.addView(this.eeu.ayC(), new LinearLayout.LayoutParams(i2, i));
                if (TextUtils.equals(this.eet.bEl, "contain")) {
                    setVideoScalingMode(2);
                } else {
                    setVideoScalingMode(0);
                }
            }
        }
        return true;
    }

    private boolean bad() {
        boolean z;
        int i;
        int i2 = 0;
        if (this.ees != 2) {
            return false;
        }
        if (this.eer == null) {
            this.eer = new SwanVideoView(this.eez);
        }
        if (this.eer.getParent() == null) {
            this.eeq.getVideoHolder().addView(this.eer);
        }
        this.eer.setVideoPath(this.eet.mSrc);
        this.eer.start();
        this.eey = true;
        if (this.eeq.getVideoHolder() != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.eeq.getVideoHolder().getChildCount()) {
                    z = false;
                    break;
                } else if (this.eeq.getVideoHolder().getChildAt(i3) == this.eer) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.eet.bir != null) {
                    i = this.eet.bir.getWidth();
                    i2 = this.eet.bir.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.eeA, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.eet.toString(), "position", this.eet.bir == null ? "null" : this.eet.bir.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                }
                this.eeq.getVideoHolder().addView(this.eeu.ayC(), new LinearLayout.LayoutParams(i, i2));
            }
        }
        return true;
    }

    private void b(a aVar) {
        if (this.eeq == null) {
            this.eeq = new VideoContainerManager(this.eez, aVar);
        }
        if (this.EV) {
            this.eeq.bar().setHidden(aVar.hidden);
        } else {
            this.eeq.j(aVar);
        }
    }

    private void c(a aVar) {
        BdLog.d("initVideoCoverContainer 00");
        b(aVar);
    }

    private boolean d(a aVar) {
        if (this.eet == null) {
            return false;
        }
        return (this.eet.eeg == aVar.eeg && this.eet.eei == aVar.eei && this.eet.eej == aVar.eej && TextUtils.equals(this.eet.eek, aVar.eek) && TextUtils.equals(this.eet.bEl, aVar.bEl)) ? false : true;
    }

    public void e(@NonNull a aVar) {
        BdLog.d("updatePlayerConfig params: " + aVar.toString());
        if (d(aVar)) {
            this.eet = aVar;
            bab();
        }
        this.eet = aVar;
        c(this.eet);
    }

    public boolean isPlaying() {
        if (this.ees == 1 && this.eeu != null) {
            return this.eey;
        }
        if (this.ees == 2 && this.eer != null) {
            return this.eer.isPlaying();
        }
        return false;
    }

    public void stop() {
        if (this.eeu != null) {
            br(this.eeu.ayC());
            this.eeu.stop();
            this.eeu.destroy();
            this.eeu.a(null);
            this.eeu = null;
            this.eey = false;
        }
        if (this.eer != null) {
            br(this.eer);
            this.eer.stopPlayback();
            this.eer = null;
            this.eey = false;
        }
    }

    public void f(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.EV = z;
        int equipmentWidth = l.getEquipmentWidth(this.eez);
        int equipmentHeight = l.getEquipmentHeight(this.eez);
        if (z) {
            if (i == 90 || i == -90) {
                this.eex.Aa();
                equipmentWidth = equipmentHeight;
                equipmentHeight = equipmentWidth;
            }
        } else if (this.eez.getRequestedOrientation() != 1) {
            this.eex.Aa();
        }
        if (z) {
            a(this.eez, i, equipmentWidth, equipmentHeight);
        } else {
            i(this.eez, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null && this.eeq != null) {
            this.EV = true;
            if (this.eeq != null && this.eeq.getVideoHolder().getParent() != null) {
                br(this.eeq.getVideoHolder());
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.eeq.bar());
                viewGroup.addView(this.eeq.bar());
            }
            this.eeq.bar().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void i(Activity activity, int i) {
        if (activity == null || this.eet == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.EV = false;
        if (this.eeq.getVideoHolder().getParent() != null) {
            br(this.eeq.getVideoHolder());
        }
        if (this.eeu != null && this.eeu.ayC().getParent() != null) {
            br(this.eeu.ayC());
        }
        int width = this.eet.bir.getWidth();
        int height = this.eet.bir.getHeight();
        this.eet.bir.getLeft();
        this.eet.bir.getTop();
        this.eeq.getVideoHolder().addView(this.eeu.ayC(), new LinearLayout.LayoutParams(width, height));
        this.eeq.KF();
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bae() {
        String jSONString = this.eew.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            BdLog.d(this.bAA + " dispatchNetStatusEvent statusData: " + jSONString);
            c.ab(getSlaveId(), Xa(), jSONString);
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String Xb() {
        return null;
    }

    private static int xE(String str) {
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
