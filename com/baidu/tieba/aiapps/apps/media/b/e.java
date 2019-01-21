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
    private com.baidu.tbadk.ala.d bJK;
    private d.a bJL;
    private o bJN;
    private FrameLayout bJP;
    private boolean bJQ;
    private HashMap<Integer, String> bJR;
    private Activity bJS;
    private AiAppsNAViewContainer mContainer;
    private boolean mDetached;
    CustomMessageListener mNetworkChangedListener;
    private String mPlayerId;
    private b bJJ = b.Zj();
    private com.baidu.tieba.aiapps.apps.media.b.a.a bJM = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean bJO = false;

    public e(Context context, String str) {
        this.mPlayerId = str;
        this.bJS = (Activity) context;
        if (!TextUtils.isEmpty(this.mPlayerId)) {
            AiAppsPlayerManager.addPlayerContext(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.mPlayerId);
        this.mContainer = new AiAppsNAViewContainer(context);
        this.bJL = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.e.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + " " + i3);
                e.this.bJM.mVideoWidth = i2;
                e.this.bJM.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && e.this.bJM != null) {
                    if (alaLivePlayerData.fpsAvg != e.this.bJM.bJW) {
                        e.this.id(940);
                    }
                    if (alaLivePlayerData.videoBitrate != e.this.bJM.bJU) {
                        e.this.id(939);
                    }
                    if (alaLivePlayerData.audioBitrate != e.this.bJM.bJV) {
                        e.this.id(938);
                    }
                    e.this.bJM.bJX = (int) alaLivePlayerData.bandWidth;
                    e.this.bJM.bJW = (int) alaLivePlayerData.fpsAvg;
                    e.this.bJM.bJV = (int) alaLivePlayerData.audioBitrate;
                    e.this.bJM.bJU = (int) alaLivePlayerData.videoBitrate;
                }
            }
        };
        this.mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.aiapps.apps.media.b.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    e.this.Zm();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        this.bJN = new o(this.bJS);
        this.bJN.start();
        this.bJS.getWindow().addFlags(128);
    }

    public b Zk() {
        return this.bJJ;
    }

    public void a(b bVar) {
        this.bJJ = bVar;
        if (!this.bJJ.hidden && this.bJJ.mAutoPlay) {
            start();
        }
    }

    public void start() {
        if (this.bJJ != null) {
            if (this.bJJ.hidden) {
                BdLog.d("mPlayerId = " + this.mPlayerId + "can not start(), hide = " + this.bJJ.hidden);
                return;
            }
            BdLog.d(this.mPlayerId + " start()");
            if (this.bJK != null) {
                resetPlayer();
            }
            Zl();
            c(this.bJJ);
            b(this.bJJ.mSrc, "", "", false);
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
        return this.bJJ.slaveId;
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
        if (this.bJJ != null && this.mContainer != null && d(this.bJS, this.mContainer)) {
            if (this.bJS.getRequestedOrientation() != 1) {
                this.bJN.aZX();
            }
            f(this.bJS, 0);
            return true;
        }
        release();
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void resetPlayer() {
        if (this.bJK != null) {
            this.bJK.stop();
            this.bJK.destroy();
        }
        this.bJK = null;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.mPlayerId + " release()");
        this.bJS.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        AiAppsPlayerManager.removePlayerContext(this);
        this.bJN.stop();
        if (this.bJK != null) {
            this.bJK.stop();
            this.bJK.destroy();
            this.bJK = null;
        }
    }

    private void Zl() {
        dG(this.bJJ.bJB);
        ia(this.bJJ.bJD);
        ib(this.bJJ.bJE);
        if (TextUtils.equals(this.bJJ.bJF, "horizontal")) {
            ic(90);
        } else {
            ic(0);
        }
        if (TextUtils.equals(this.bJJ.bJG, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void dG(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.bJK != null) {
            this.bJK.setAudioMute(z);
        }
    }

    public void ia(int i) {
    }

    public void ib(int i) {
    }

    public void ic(int i) {
    }

    public void setVideoScalingMode(int i) {
        BdLog.d("setVideoScalingMode scalingMode: " + i);
        if (this.bJK != null) {
            this.bJK.setRenderVideoModel(1, i != 2 ? 1 : 2);
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
        this.bJR = hashMap2;
        return true;
    }

    private boolean prepareAsync() {
        boolean z;
        CustomResponsedMessage runTask;
        if (this.bJK == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.bJS)) != null && runTask.getData() != null) {
            this.bJK = (com.baidu.tbadk.ala.d) runTask.getData();
            this.bJK.a(this.bJL);
        }
        if (this.bJK == null) {
            return false;
        }
        if (this.bJK.a(1, this.bJJ.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
            this.bJO = true;
        }
        if (this.bJP != null) {
            int i = 0;
            while (true) {
                if (i >= this.bJP.getChildCount()) {
                    z = false;
                    break;
                } else if (this.bJP.getChildAt(i) == this.bJK.wh()) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                this.bJP.addView(this.bJK.wh(), new LinearLayout.LayoutParams(this.bJJ.position.getWidth(), this.bJJ.position.getHeight()));
                if (TextUtils.equals(this.bJJ.bJG, "contain")) {
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
        if (this.bJQ) {
            this.mContainer.setHidden(bVar.hidden);
            return true;
        }
        AiAppsNaViewModel cloneModel = bVar.cloneModel();
        cloneModel.id = this.mPlayerId;
        cloneModel.slaveId = this.bJJ.slaveId;
        cloneModel.parentId = bVar.parentId;
        if (NAViewFinder.findNAViewById(cloneModel.slaveId, this.mPlayerId, NAViewUtils.getViewRoot(cloneModel.slaveId)) == null) {
            BdLog.d("insertOrUpdateCoverContainer 00");
            this.bJP = new FrameLayout(this.bJS);
            return this.mContainer.insertView(this.bJP, cloneModel);
        }
        BdLog.d("insertOrUpdateCoverContainer 01");
        return this.mContainer.updateView(cloneModel);
    }

    private void c(b bVar) {
        BdLog.d("initVideoCoverContainer 00");
        b(bVar);
    }

    private boolean d(b bVar) {
        if (this.bJJ == null) {
            return false;
        }
        return (this.bJJ.bJB == bVar.bJB && this.bJJ.bJD == bVar.bJD && this.bJJ.bJE == bVar.bJE && TextUtils.equals(this.bJJ.bJF, bVar.bJF) && TextUtils.equals(this.bJJ.bJG, bVar.bJG)) ? false : true;
    }

    public void e(@NonNull b bVar) {
        BdLog.d("updatePlayerConfig params: " + bVar.toString());
        if (d(bVar)) {
            this.bJJ = bVar;
            Zl();
        }
        this.bJJ = bVar;
        c(this.bJJ);
    }

    public boolean isPlaying() {
        if (this.bJK != null) {
            return this.bJO;
        }
        return false;
    }

    public void stop() {
        if (this.bJK != null) {
            this.bJK.stop();
            this.bJK.destroy();
            this.bJK.a(null);
            this.bJK = null;
            this.bJO = false;
        }
    }

    public void f(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.bJQ = z;
        int aO = l.aO(this.bJS);
        int aQ = l.aQ(this.bJS);
        if (z) {
            if (i == 90 || i == -90) {
                this.bJN.aZX();
                aO = aQ;
                aQ = aO;
            }
        } else if (this.bJS.getRequestedOrientation() != 1) {
            this.bJN.aZX();
        }
        if (z) {
            a(this.bJS, i, aO, aQ);
        } else {
            f(this.bJS, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null) {
            this.bJQ = true;
            if (this.mContainer != null && this.mContainer.getParent() != null) {
                ((ViewGroup) this.mContainer.getParent()).removeView(this.mContainer);
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.mContainer);
                viewGroup.addView(this.mContainer);
            }
            if (this.bJK != null && this.bJK.wh().getParent() != null) {
                ((ViewGroup) this.bJK.wh().getParent()).removeView(this.bJK.wh());
            }
            this.bJP.addView(this.bJK.wh(), new LinearLayout.LayoutParams(i2, i3));
            this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void f(Activity activity, int i) {
        if (activity == null || this.bJJ == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.bJQ = false;
        if (this.mContainer != null && this.mContainer.getParent() != null) {
            ((ViewGroup) this.mContainer.getParent()).removeView(this.mContainer);
        }
        if (this.bJK != null && this.bJK.wh().getParent() != null) {
            ((ViewGroup) this.bJK.wh().getParent()).removeView(this.bJK.wh());
        }
        int width = this.bJJ.position.getWidth();
        int height = this.bJJ.position.getHeight();
        this.bJJ.position.getLeft();
        this.bJJ.position.getTop();
        this.bJP.addView(this.bJK.wh(), new LinearLayout.LayoutParams(width, height));
        this.mContainer.attach();
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zm() {
        String jSONString = this.bJM.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            BdLog.d(this.mPlayerId + " dispatchNetStatusEvent statusData: " + jSONString);
            d.y(getSlaveId(), getPlayerId(), jSONString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void id(int i) {
        int hY = c.hY(i);
        BdLog.d(this.mPlayerId + " dispatchStatusIfNeeded what: " + i + " liveStatusCode:" + hY);
        if (hY != 100) {
            if (hY == 2101) {
                d.x(getSlaveId(), getPlayerId(), c.hZ(SubPackageAPSInfo.RESULT_APS_NO_PACKAGE));
            }
            d.x(getSlaveId(), getPlayerId(), c.hZ(hY));
        }
    }
}
