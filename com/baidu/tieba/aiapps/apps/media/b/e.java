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
    private com.baidu.tbadk.ala.d bEE;
    private d.a bEF;
    private o bEH;
    private FrameLayout bEJ;
    private boolean bEK;
    private HashMap<Integer, String> bEL;
    private Activity bEM;
    private AiAppsNAViewContainer mContainer;
    private boolean mDetached;
    CustomMessageListener mNetworkChangedListener;
    private String mPlayerId;
    private b bED = b.Xw();
    private com.baidu.tieba.aiapps.apps.media.b.a.a bEG = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean bEI = false;

    public e(Context context, String str) {
        this.mPlayerId = str;
        this.bEM = (Activity) context;
        if (!TextUtils.isEmpty(this.mPlayerId)) {
            AiAppsPlayerManager.addPlayerContext(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.mPlayerId);
        this.mContainer = new AiAppsNAViewContainer(context);
        this.bEF = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.e.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + " " + i3);
                e.this.bEG.mVideoWidth = i2;
                e.this.bEG.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && e.this.bEG != null) {
                    if (alaLivePlayerData.fpsAvg != e.this.bEG.bEQ) {
                        e.this.hB(940);
                    }
                    if (alaLivePlayerData.videoBitrate != e.this.bEG.bEO) {
                        e.this.hB(939);
                    }
                    if (alaLivePlayerData.audioBitrate != e.this.bEG.bEP) {
                        e.this.hB(938);
                    }
                    e.this.bEG.bER = (int) alaLivePlayerData.bandWidth;
                    e.this.bEG.bEQ = (int) alaLivePlayerData.fpsAvg;
                    e.this.bEG.bEP = (int) alaLivePlayerData.audioBitrate;
                    e.this.bEG.bEO = (int) alaLivePlayerData.videoBitrate;
                }
            }
        };
        this.mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.aiapps.apps.media.b.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    e.this.Xz();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        this.bEH = new o(this.bEM);
        this.bEH.start();
        this.bEM.getWindow().addFlags(128);
    }

    public b Xx() {
        return this.bED;
    }

    public void a(b bVar) {
        this.bED = bVar;
        if (!this.bED.hidden && this.bED.mAutoPlay) {
            start();
        }
    }

    public void start() {
        if (this.bED != null) {
            if (this.bED.hidden) {
                BdLog.d("mPlayerId = " + this.mPlayerId + "can not start(), hide = " + this.bED.hidden);
                return;
            }
            BdLog.d(this.mPlayerId + " start()");
            if (this.bEE != null) {
                resetPlayer();
            }
            Xy();
            c(this.bED);
            b(this.bED.mSrc, "", "", false);
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
        return this.bED.slaveId;
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
        if (this.bED != null && this.mContainer != null && d(this.bEM, this.mContainer)) {
            if (this.bEM.getRequestedOrientation() != 1) {
                this.bEH.aXv();
            }
            f(this.bEM, 0);
            return true;
        }
        release();
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void resetPlayer() {
        if (this.bEE != null) {
            this.bEE.stop();
            this.bEE.destroy();
        }
        this.bEE = null;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.mPlayerId + " release()");
        this.bEM.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        AiAppsPlayerManager.removePlayerContext(this);
        this.bEH.stop();
        if (this.bEE != null) {
            this.bEE.stop();
            this.bEE.destroy();
            this.bEE = null;
        }
    }

    private void Xy() {
        dl(this.bED.bEv);
        hy(this.bED.bEx);
        hz(this.bED.bEy);
        if (TextUtils.equals(this.bED.bEz, "horizontal")) {
            hA(90);
        } else {
            hA(0);
        }
        if (TextUtils.equals(this.bED.bEA, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void dl(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.bEE != null) {
            this.bEE.setAudioMute(z);
        }
    }

    public void hy(int i) {
    }

    public void hz(int i) {
    }

    public void hA(int i) {
    }

    public void setVideoScalingMode(int i) {
        BdLog.d("setVideoScalingMode scalingMode: " + i);
        if (this.bEE != null) {
            this.bEE.setRenderVideoModel(1, i != 2 ? 1 : 2);
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
        this.bEL = hashMap2;
        return true;
    }

    private boolean prepareAsync() {
        boolean z;
        CustomResponsedMessage runTask;
        if (this.bEE == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.bEM)) != null && runTask.getData() != null) {
            this.bEE = (com.baidu.tbadk.ala.d) runTask.getData();
            this.bEE.a(this.bEF);
        }
        if (this.bEE == null) {
            return false;
        }
        if (this.bEE.a(1, this.bED.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
            this.bEI = true;
        }
        if (this.bEJ != null) {
            int i = 0;
            while (true) {
                if (i >= this.bEJ.getChildCount()) {
                    z = false;
                    break;
                } else if (this.bEJ.getChildAt(i) == this.bEE.uM()) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                this.bEJ.addView(this.bEE.uM(), new LinearLayout.LayoutParams(this.bED.position.getWidth(), this.bED.position.getHeight()));
                if (TextUtils.equals(this.bED.bEA, "contain")) {
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
        if (this.bEK) {
            this.mContainer.setHidden(bVar.hidden);
            return true;
        }
        AiAppsNaViewModel cloneModel = bVar.cloneModel();
        cloneModel.id = this.mPlayerId;
        cloneModel.slaveId = this.bED.slaveId;
        cloneModel.parentId = bVar.parentId;
        if (NAViewFinder.findNAViewById(cloneModel.slaveId, this.mPlayerId, NAViewUtils.getViewRoot(cloneModel.slaveId)) == null) {
            BdLog.d("insertOrUpdateCoverContainer 00");
            this.bEJ = new FrameLayout(this.bEM);
            return this.mContainer.insertView(this.bEJ, cloneModel);
        }
        BdLog.d("insertOrUpdateCoverContainer 01");
        return this.mContainer.updateView(cloneModel);
    }

    private void c(b bVar) {
        BdLog.d("initVideoCoverContainer 00");
        b(bVar);
    }

    private boolean d(b bVar) {
        if (this.bED == null) {
            return false;
        }
        return (this.bED.bEv == bVar.bEv && this.bED.bEx == bVar.bEx && this.bED.bEy == bVar.bEy && TextUtils.equals(this.bED.bEz, bVar.bEz) && TextUtils.equals(this.bED.bEA, bVar.bEA)) ? false : true;
    }

    public void e(@NonNull b bVar) {
        BdLog.d("updatePlayerConfig params: " + bVar.toString());
        if (d(bVar)) {
            this.bED = bVar;
            Xy();
        }
        this.bED = bVar;
        c(this.bED);
    }

    public boolean isPlaying() {
        if (this.bEE != null) {
            return this.bEI;
        }
        return false;
    }

    public void stop() {
        if (this.bEE != null) {
            this.bEE.stop();
            this.bEE.destroy();
            this.bEE.a(null);
            this.bEE = null;
            this.bEI = false;
        }
    }

    public void f(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.bEK = z;
        int aO = l.aO(this.bEM);
        int aQ = l.aQ(this.bEM);
        if (z) {
            if (i == 90 || i == -90) {
                this.bEH.aXv();
                aO = aQ;
                aQ = aO;
            }
        } else if (this.bEM.getRequestedOrientation() != 1) {
            this.bEH.aXv();
        }
        if (z) {
            a(this.bEM, i, aO, aQ);
        } else {
            f(this.bEM, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null) {
            this.bEK = true;
            if (this.mContainer != null && this.mContainer.getParent() != null) {
                ((ViewGroup) this.mContainer.getParent()).removeView(this.mContainer);
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.mContainer);
                viewGroup.addView(this.mContainer);
            }
            if (this.bEE != null && this.bEE.uM().getParent() != null) {
                ((ViewGroup) this.bEE.uM().getParent()).removeView(this.bEE.uM());
            }
            this.bEJ.addView(this.bEE.uM(), new LinearLayout.LayoutParams(i2, i3));
            this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void f(Activity activity, int i) {
        if (activity == null || this.bED == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.bEK = false;
        if (this.mContainer != null && this.mContainer.getParent() != null) {
            ((ViewGroup) this.mContainer.getParent()).removeView(this.mContainer);
        }
        if (this.bEE != null && this.bEE.uM().getParent() != null) {
            ((ViewGroup) this.bEE.uM().getParent()).removeView(this.bEE.uM());
        }
        int width = this.bED.position.getWidth();
        int height = this.bED.position.getHeight();
        this.bED.position.getLeft();
        this.bED.position.getTop();
        this.bEJ.addView(this.bEE.uM(), new LinearLayout.LayoutParams(width, height));
        this.mContainer.attach();
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xz() {
        String jSONString = this.bEG.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            BdLog.d(this.mPlayerId + " dispatchNetStatusEvent statusData: " + jSONString);
            d.y(getSlaveId(), getPlayerId(), jSONString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hB(int i) {
        int hw = c.hw(i);
        BdLog.d(this.mPlayerId + " dispatchStatusIfNeeded what: " + i + " liveStatusCode:" + hw);
        if (hw != 100) {
            if (hw == 2101) {
                d.x(getSlaveId(), getPlayerId(), c.hx(SubPackageAPSInfo.RESULT_APS_NO_PACKAGE));
            }
            d.x(getSlaveId(), getPlayerId(), c.hx(hw));
        }
    }
}
