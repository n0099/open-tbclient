package com.baidu.tieba.aiapps.apps.media.b;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.searchbox.ng.ai.apps.install.subpackage.SubPackageAPSInfo;
import com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext;
import com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerManager;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewContainer;
import com.baidu.searchbox.ng.ai.apps.view.container.util.NAViewFinder;
import com.baidu.searchbox.ng.ai.apps.view.container.util.NAViewUtils;
import com.baidu.tbadk.ala.AlaLivePlayerData;
import com.baidu.tbadk.ala.d;
import com.baidu.tieba.play.o;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class e implements AiAppsPlayerContext {
    private com.baidu.tbadk.ala.d bFq;
    private d.a bFr;
    private o bFt;
    private FrameLayout bFv;
    private boolean bFw;
    private HashMap<Integer, String> bFx;
    private Activity bFy;
    private AiAppsNAViewContainer mContainer;
    private boolean mDetached;
    CustomMessageListener mNetworkChangedListener;
    private String mPlayerId;
    private b bFp = b.XH();
    private com.baidu.tieba.aiapps.apps.media.b.a.a bFs = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean bFu = false;

    public e(Context context, String str) {
        this.mPlayerId = str;
        this.bFy = (Activity) context;
        if (!TextUtils.isEmpty(this.mPlayerId)) {
            AiAppsPlayerManager.addPlayerContext(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.mPlayerId);
        this.mContainer = new AiAppsNAViewContainer(context);
        this.bFr = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.e.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + " " + i3);
                e.this.bFs.mVideoWidth = i2;
                e.this.bFs.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && e.this.bFs != null) {
                    if (alaLivePlayerData.fpsAvg != e.this.bFs.bFC) {
                        e.this.hO(940);
                    }
                    if (alaLivePlayerData.videoBitrate != e.this.bFs.bFA) {
                        e.this.hO(939);
                    }
                    if (alaLivePlayerData.audioBitrate != e.this.bFs.bFB) {
                        e.this.hO(938);
                    }
                    e.this.bFs.bFD = (int) alaLivePlayerData.bandWidth;
                    e.this.bFs.bFC = (int) alaLivePlayerData.fpsAvg;
                    e.this.bFs.bFB = (int) alaLivePlayerData.audioBitrate;
                    e.this.bFs.bFA = (int) alaLivePlayerData.videoBitrate;
                }
            }
        };
        this.mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.aiapps.apps.media.b.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    e.this.XK();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        this.bFt = new o(this.bFy);
        this.bFt.start();
        this.bFy.getWindow().addFlags(128);
    }

    public b XI() {
        return this.bFp;
    }

    public void a(b bVar) {
        this.bFp = bVar;
        if (!this.bFp.hidden && this.bFp.mAutoPlay) {
            start();
        }
    }

    public void start() {
        if (this.bFp != null) {
            if (this.bFp.hidden) {
                BdLog.d("mPlayerId = " + this.mPlayerId + "can not start(), hide = " + this.bFp.hidden);
                return;
            }
            BdLog.d(this.mPlayerId + " start()");
            if (this.bFq != null) {
                resetPlayer();
            }
            XJ();
            c(this.bFp);
            b(this.bFp.mSrc, "", "", false);
            prepareAsync();
            this.mDetached = false;
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public String getPlayerId() {
        return this.mPlayerId;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public String getSlaveId() {
        return this.bFp.slaveId;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public Object getPlayerObject() {
        return this;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public int getPlayerType() {
        return 2;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void onForegroundChanged(boolean z) {
        BdLog.d("onForegroundChanged " + z);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void onAppForegroundChanged(boolean z) {
        BdLog.d("onAppForegroundChanged " + z);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public boolean onBackPressed() {
        BdLog.d("onBackPressed ");
        if (this.bFp != null && this.mContainer != null && d(this.bFy, this.mContainer)) {
            if (this.bFy.getRequestedOrientation() != 1) {
                this.bFt.aWS();
            }
            f(this.bFy, 0);
            return true;
        }
        release();
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void resetPlayer() {
        if (this.bFq != null) {
            this.bFq.stop();
            this.bFq.destroy();
        }
        this.bFq = null;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.mPlayerId + " release()");
        this.bFy.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        AiAppsPlayerManager.removePlayerContext(this);
        this.bFt.stop();
        if (this.bFq != null) {
            this.bFq.stop();
            this.bFq.destroy();
            this.bFq = null;
        }
    }

    private void XJ() {
        dC(this.bFp.bFh);
        hL(this.bFp.bFj);
        hM(this.bFp.bFk);
        if (TextUtils.equals(this.bFp.bFl, "horizontal")) {
            hN(90);
        } else {
            hN(0);
        }
        if (TextUtils.equals(this.bFp.bFm, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void dC(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.bFq != null) {
            this.bFq.setAudioMute(z);
        }
    }

    public void hL(int i) {
    }

    public void hM(int i) {
    }

    public void hN(int i) {
    }

    public void setVideoScalingMode(int i) {
        BdLog.d("setVideoScalingMode scalingMode: " + i);
        if (this.bFq != null) {
            this.bFq.setRenderVideoModel(1, i != 2 ? 1 : 2);
            BdLog.d("setVideoScalingMode " + i);
            return;
        }
        BdLog.d("setVideoScalingMode mPlayer = null ");
    }

    private boolean b(String str, String str2, String str3, boolean z) {
        BdLog.d("setDataSource: " + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder("");
        if (!TextUtils.isEmpty(str2)) {
            sb.append("Cookie:");
            sb.append(str2);
            sb.append(SystemInfoUtil.LINE_END);
        }
        if (z) {
            sb.append("x-hide-urls-from-log:true\r\n");
        }
        String sb2 = sb.toString();
        HashMap hashMap = new HashMap(2);
        hashMap.put(7, sb2);
        hashMap.put(6, "");
        HashMap<Integer, String> hashMap2 = new HashMap<>(3);
        hashMap2.put(0, str);
        this.bFx = hashMap2;
        return true;
    }

    private boolean prepareAsync() {
        boolean z;
        CustomResponsedMessage runTask;
        if (this.bFq == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.bFy)) != null && runTask.getData() != null) {
            this.bFq = (com.baidu.tbadk.ala.d) runTask.getData();
            this.bFq.a(this.bFr);
        }
        if (this.bFq == null) {
            return false;
        }
        if (this.bFq.a(1, this.bFp.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
            this.bFu = true;
        }
        if (this.bFv != null) {
            int i = 0;
            while (true) {
                if (i >= this.bFv.getChildCount()) {
                    z = false;
                    break;
                } else if (this.bFv.getChildAt(i) == this.bFq.uW()) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                this.bFv.addView(this.bFq.uW(), new LinearLayout.LayoutParams(this.bFp.position.getWidth(), this.bFp.position.getHeight()));
                if (TextUtils.equals(this.bFp.bFm, "contain")) {
                    setVideoScalingMode(2);
                } else {
                    setVideoScalingMode(0);
                }
            }
        }
        return true;
    }

    public boolean b(b bVar) {
        if (this.mContainer == null) {
            return false;
        }
        if (this.bFw) {
            this.mContainer.setHidden(bVar.hidden);
            return true;
        }
        AiAppsNaViewModel cloneModel = bVar.cloneModel();
        cloneModel.id = this.mPlayerId;
        cloneModel.slaveId = this.bFp.slaveId;
        cloneModel.parentId = bVar.parentId;
        if (NAViewFinder.findNAViewById(cloneModel.slaveId, this.mPlayerId, NAViewUtils.getViewRoot(cloneModel.slaveId)) == null) {
            BdLog.d("insertOrUpdateCoverContainer 00");
            this.bFv = new FrameLayout(this.bFy);
            return this.mContainer.insertView(this.bFv, cloneModel);
        }
        BdLog.d("insertOrUpdateCoverContainer 01");
        return this.mContainer.updateView(cloneModel);
    }

    private void c(b bVar) {
        BdLog.d("initVideoCoverContainer 00");
        b(bVar);
    }

    private boolean d(b bVar) {
        if (this.bFp == null) {
            return false;
        }
        return (this.bFp.bFh == bVar.bFh && this.bFp.bFj == bVar.bFj && this.bFp.bFk == bVar.bFk && TextUtils.equals(this.bFp.bFl, bVar.bFl) && TextUtils.equals(this.bFp.bFm, bVar.bFm)) ? false : true;
    }

    public void e(@NonNull b bVar) {
        BdLog.d("updatePlayerConfig params: " + bVar.toString());
        if (d(bVar)) {
            this.bFp = bVar;
            XJ();
        }
        this.bFp = bVar;
        c(this.bFp);
    }

    public boolean isPlaying() {
        if (this.bFq != null) {
            return this.bFu;
        }
        return false;
    }

    public void stop() {
        if (this.bFq != null) {
            this.bFq.stop();
            this.bFq.destroy();
            this.bFq.a(null);
            this.bFq = null;
            this.bFu = false;
        }
    }

    public void f(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.bFw = z;
        int aO = l.aO(this.bFy);
        int aQ = l.aQ(this.bFy);
        if (z) {
            if (i == 90 || i == -90) {
                this.bFt.aWS();
                aO = aQ;
                aQ = aO;
            }
        } else if (this.bFy.getRequestedOrientation() != 1) {
            this.bFt.aWS();
        }
        if (z) {
            a(this.bFy, i, aO, aQ);
        } else {
            f(this.bFy, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null) {
            this.bFw = true;
            if (this.mContainer != null && this.mContainer.getParent() != null) {
                ((ViewGroup) this.mContainer.getParent()).removeView(this.mContainer);
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.mContainer);
                viewGroup.addView(this.mContainer);
            }
            if (this.bFq != null && this.bFq.uW().getParent() != null) {
                ((ViewGroup) this.bFq.uW().getParent()).removeView(this.bFq.uW());
            }
            this.bFv.addView(this.bFq.uW(), new LinearLayout.LayoutParams(i2, i3));
            this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void f(Activity activity, int i) {
        if (activity == null || this.bFp == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.bFw = false;
        if (this.mContainer != null && this.mContainer.getParent() != null) {
            ((ViewGroup) this.mContainer.getParent()).removeView(this.mContainer);
        }
        if (this.bFq != null && this.bFq.uW().getParent() != null) {
            ((ViewGroup) this.bFq.uW().getParent()).removeView(this.bFq.uW());
        }
        int width = this.bFp.position.getWidth();
        int height = this.bFp.position.getHeight();
        this.bFp.position.getLeft();
        this.bFp.position.getTop();
        this.bFv.addView(this.bFq.uW(), new LinearLayout.LayoutParams(width, height));
        this.mContainer.attach();
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XK() {
        String jSONString = this.bFs.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            BdLog.d(this.mPlayerId + " dispatchNetStatusEvent statusData: " + jSONString);
            d.y(getSlaveId(), getPlayerId(), jSONString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hO(int i) {
        int hJ = c.hJ(i);
        BdLog.d(this.mPlayerId + " dispatchStatusIfNeeded what: " + i + " liveStatusCode:" + hJ);
        if (hJ != 100) {
            if (hJ == 2101) {
                d.x(getSlaveId(), getPlayerId(), c.hK(SubPackageAPSInfo.RESULT_APS_NO_PACKAGE));
            }
            d.x(getSlaveId(), getPlayerId(), c.hK(hJ));
        }
    }
}
