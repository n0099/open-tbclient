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
/* loaded from: classes9.dex */
public class f implements com.baidu.swan.apps.media.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean Ev;
    private String bvC;
    private SwanVideoView dZR;
    private com.baidu.tbadk.ala.d dZU;
    private d.a dZV;
    private o dZX;
    private Activity dZZ;
    private boolean mDetached;
    CustomMessageListener tA;
    private VideoContainerManager dZQ = null;
    private int dZS = 0;
    private a dZT = a.aXk();
    private com.baidu.tieba.aiapps.apps.media.b.a.a dZW = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean dZY = false;
    private String eaa = "AiAppLiveErr";

    public f(Context context, String str) {
        this.bvC = str;
        this.dZZ = (Activity) context;
        if (!TextUtils.isEmpty(this.bvC)) {
            com.baidu.swan.apps.media.b.a(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.bvC);
        initData();
        MessageManager.getInstance().registerListener(this.tA);
        this.dZX = new o(this.dZZ);
        this.dZX.start();
        this.dZZ.getWindow().addFlags(128);
    }

    private void initData() {
        this.dZV = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.f.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + HanziToPinyin.Token.SEPARATOR + i3);
                f.this.dZW.mVideoWidth = i2;
                f.this.dZW.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && f.this.dZW != null) {
                    if (alaLivePlayerData.fpsAvg != f.this.dZW.eac) {
                    }
                    if (alaLivePlayerData.videoBitrate != f.this.dZW.aGb) {
                    }
                    if (alaLivePlayerData.audioBitrate != f.this.dZW.aGh) {
                    }
                    f.this.dZW.ead = (int) alaLivePlayerData.bandWidth;
                    f.this.dZW.eac = (int) alaLivePlayerData.fpsAvg;
                    f.this.dZW.aGh = (int) alaLivePlayerData.audioBitrate;
                    f.this.dZW.aGb = (int) alaLivePlayerData.videoBitrate;
                }
            }
        };
        this.tA = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.aiapps.apps.media.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    f.this.aXs();
                }
            }
        };
    }

    public a aXm() {
        return this.dZT;
    }

    public void a(a aVar) {
        this.dZT = aVar;
        if (!this.dZT.hidden && this.dZT.bvK) {
            start();
        }
    }

    public void start() {
        if (this.dZT != null) {
            if (this.dZT.hidden) {
                BdLog.d("mPlayerId = " + this.bvC + "can not start(), hide = " + this.dZT.hidden);
                return;
            }
            BdLog.d(this.bvC + " start()");
            if (this.dZS == 0) {
                this.dZS = xf(this.dZT.mSrc);
            }
            if (this.dZS == 0) {
                BdLog.e("unsupport  url type error src = " + this.dZT.mSrc);
                return;
            }
            if (this.dZU != null || this.dZR != null) {
                aXn();
            }
            aXo();
            aXo().aXD();
            aXp();
            c(this.dZT);
            c(this.dZT.mSrc, "", "", false);
            if (this.dZS == 1) {
                aXq();
            } else if (this.dZS == 2) {
                aXr();
            }
            this.mDetached = false;
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String Un() {
        return this.bvC;
    }

    @Override // com.baidu.swan.apps.media.a
    public String getSlaveId() {
        return this.dZT.bdi;
    }

    @Override // com.baidu.swan.apps.media.a
    public Object Up() {
        return this;
    }

    @Override // com.baidu.swan.apps.media.a
    public void cE(boolean z) {
        BdLog.d("onForegroundChanged " + z);
        if (!z) {
            aXn();
        } else {
            start();
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public void cF(boolean z) {
        BdLog.d("onAppForegroundChanged " + z);
    }

    @Override // com.baidu.swan.apps.media.a
    public boolean onBackPressed() {
        BdLog.d("onBackPressed ");
        if (this.dZT != null && this.dZQ != null && d(this.dZZ, this.dZQ.getVideoHolder())) {
            if (this.dZZ.getRequestedOrientation() != 1) {
                this.dZX.xr();
            }
            e(this.dZZ, 0);
            return true;
        }
        release();
        return false;
    }

    public void aXn() {
        if (this.dZU != null) {
            bn(this.dZU.avU());
            this.dZU.stop();
            this.dZU.destroy();
        }
        this.dZU = null;
        if (this.dZR != null) {
            this.dZR.stopPlayback();
            bn(this.dZR);
        }
        this.dZR = null;
    }

    @Override // com.baidu.swan.apps.media.a
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.bvC + " release()");
        this.dZZ.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.tA);
        com.baidu.swan.apps.media.b.b(this);
        this.dZX.stop();
        if (this.dZU != null) {
            bn(this.dZU.avU());
            this.dZU.stop();
            this.dZU.destroy();
            this.dZU = null;
        }
        if (this.dZR != null) {
            bn(this.dZR);
            this.dZR.stopPlayback();
            this.dZR = null;
        }
        if (this.dZQ != null) {
            this.dZQ.HU();
            this.dZQ = null;
        }
    }

    private VideoContainerManager aXo() {
        if (this.dZQ == null && this.dZT != null) {
            this.dZQ = new VideoContainerManager(this.dZZ, this.dZT);
        }
        return this.dZQ;
    }

    private void aXp() {
        cx(this.dZT.dZG);
        ob(this.dZT.dZI);
        oc(this.dZT.dZJ);
        if (TextUtils.equals(this.dZT.dZK, HorizontalTranslateLayout.HORIZONTAL)) {
            setVideoRotation(90);
        } else {
            setVideoRotation(0);
        }
        if (TextUtils.equals(this.dZT.bzq, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void cx(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.dZU != null) {
            this.dZU.setAudioMute(z);
        }
        if (this.dZR != null) {
            this.dZR.cx(z);
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
        if (this.dZU != null) {
            this.dZU.setRenderVideoModel(1, i != 2 ? 1 : 2);
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
        if (this.dZS == 2 && this.dZR != null) {
            this.dZR.setVideoPath(str);
        }
        return true;
    }

    private boolean aXq() {
        boolean z;
        int i;
        int i2;
        CustomResponsedMessage runTask;
        if (this.dZU == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.dZZ)) != null && runTask.getData() != null) {
            this.dZU = (com.baidu.tbadk.ala.d) runTask.getData();
            this.dZU.a(this.dZV);
        }
        if (this.dZU == null) {
            return false;
        }
        if (this.dZU.a(1, this.dZT.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
            this.dZY = true;
        }
        FrameLayout videoHolder = this.dZQ.getVideoHolder();
        if (videoHolder != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= videoHolder.getChildCount()) {
                    z = false;
                    break;
                } else if (videoHolder.getChildAt(i3) == this.dZU.avU()) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.dZT.bdl != null) {
                    i2 = this.dZT.bdl.getWidth();
                    i = this.dZT.bdl.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.eaa, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.dZT.toString(), "position", this.dZT.bdl == null ? "null" : this.dZT.bdl.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                    i2 = 0;
                }
                videoHolder.addView(this.dZU.avU(), new LinearLayout.LayoutParams(i2, i));
                if (TextUtils.equals(this.dZT.bzq, "contain")) {
                    setVideoScalingMode(2);
                } else {
                    setVideoScalingMode(0);
                }
            }
        }
        return true;
    }

    private boolean aXr() {
        boolean z;
        int i;
        int i2 = 0;
        if (this.dZS != 2) {
            return false;
        }
        if (this.dZR == null) {
            this.dZR = new SwanVideoView(this.dZZ);
        }
        if (this.dZR.getParent() == null) {
            this.dZQ.getVideoHolder().addView(this.dZR);
        }
        this.dZR.setVideoPath(this.dZT.mSrc);
        this.dZR.start();
        this.dZY = true;
        if (this.dZQ.getVideoHolder() != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.dZQ.getVideoHolder().getChildCount()) {
                    z = false;
                    break;
                } else if (this.dZQ.getVideoHolder().getChildAt(i3) == this.dZR) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                if (this.dZT.bdl != null) {
                    i = this.dZT.bdl.getWidth();
                    i2 = this.dZT.bdl.getHeight();
                } else {
                    BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), this.eaa, null, 1, "uid", TbadkCoreApplication.getCurrentAccount(), "mParams", this.dZT.toString(), "position", this.dZT.bdl == null ? "null" : this.dZT.bdl.toString(), "appver", BdStatisticsManager.getInstance().getAppVersion());
                    i = 0;
                }
                this.dZQ.getVideoHolder().addView(this.dZU.avU(), new LinearLayout.LayoutParams(i, i2));
            }
        }
        return true;
    }

    private void b(a aVar) {
        if (this.dZQ == null) {
            this.dZQ = new VideoContainerManager(this.dZZ, aVar);
        }
        if (this.Ev) {
            this.dZQ.aXF().setHidden(aVar.hidden);
        } else {
            this.dZQ.j(aVar);
        }
    }

    private void c(a aVar) {
        BdLog.d("initVideoCoverContainer 00");
        b(aVar);
    }

    private boolean d(a aVar) {
        if (this.dZT == null) {
            return false;
        }
        return (this.dZT.dZG == aVar.dZG && this.dZT.dZI == aVar.dZI && this.dZT.dZJ == aVar.dZJ && TextUtils.equals(this.dZT.dZK, aVar.dZK) && TextUtils.equals(this.dZT.bzq, aVar.bzq)) ? false : true;
    }

    public void e(@NonNull a aVar) {
        BdLog.d("updatePlayerConfig params: " + aVar.toString());
        if (d(aVar)) {
            this.dZT = aVar;
            aXp();
        }
        this.dZT = aVar;
        c(this.dZT);
    }

    public boolean isPlaying() {
        if (this.dZS == 1 && this.dZU != null) {
            return this.dZY;
        }
        if (this.dZS == 2 && this.dZR != null) {
            return this.dZR.isPlaying();
        }
        return false;
    }

    public void stop() {
        if (this.dZU != null) {
            bn(this.dZU.avU());
            this.dZU.stop();
            this.dZU.destroy();
            this.dZU.a(null);
            this.dZU = null;
            this.dZY = false;
        }
        if (this.dZR != null) {
            bn(this.dZR);
            this.dZR.stopPlayback();
            this.dZR = null;
            this.dZY = false;
        }
    }

    public void d(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.Ev = z;
        int equipmentWidth = l.getEquipmentWidth(this.dZZ);
        int equipmentHeight = l.getEquipmentHeight(this.dZZ);
        if (z) {
            if (i == 90 || i == -90) {
                this.dZX.xr();
                equipmentWidth = equipmentHeight;
                equipmentHeight = equipmentWidth;
            }
        } else if (this.dZZ.getRequestedOrientation() != 1) {
            this.dZX.xr();
        }
        if (z) {
            a(this.dZZ, i, equipmentWidth, equipmentHeight);
        } else {
            e(this.dZZ, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null && this.dZQ != null) {
            this.Ev = true;
            if (this.dZQ != null && this.dZQ.getVideoHolder().getParent() != null) {
                bn(this.dZQ.getVideoHolder());
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.dZQ.aXF());
                viewGroup.addView(this.dZQ.aXF());
            }
            this.dZQ.aXF().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void e(Activity activity, int i) {
        if (activity == null || this.dZT == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.Ev = false;
        if (this.dZQ.getVideoHolder().getParent() != null) {
            bn(this.dZQ.getVideoHolder());
        }
        if (this.dZU != null && this.dZU.avU().getParent() != null) {
            bn(this.dZU.avU());
        }
        int width = this.dZT.bdl.getWidth();
        int height = this.dZT.bdl.getHeight();
        this.dZT.bdl.getLeft();
        this.dZT.bdl.getTop();
        this.dZQ.getVideoHolder().addView(this.dZU.avU(), new LinearLayout.LayoutParams(width, height));
        this.dZQ.HS();
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXs() {
        String jSONString = this.dZW.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            BdLog.d(this.bvC + " dispatchNetStatusEvent statusData: " + jSONString);
            c.Z(getSlaveId(), Un(), jSONString);
        }
    }

    @Override // com.baidu.swan.apps.media.a
    public String Uo() {
        return null;
    }

    private static int xf(String str) {
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

    private static void bn(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }
}
