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
    private com.baidu.tbadk.ala.d bJJ;
    private d.a bJK;
    private o bJM;
    private FrameLayout bJO;
    private boolean bJP;
    private HashMap<Integer, String> bJQ;
    private Activity bJR;
    private AiAppsNAViewContainer mContainer;
    private boolean mDetached;
    CustomMessageListener mNetworkChangedListener;
    private String mPlayerId;
    private b bJI = b.Zj();
    private com.baidu.tieba.aiapps.apps.media.b.a.a bJL = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean bJN = false;

    public e(Context context, String str) {
        this.mPlayerId = str;
        this.bJR = (Activity) context;
        if (!TextUtils.isEmpty(this.mPlayerId)) {
            AiAppsPlayerManager.addPlayerContext(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.mPlayerId);
        this.mContainer = new AiAppsNAViewContainer(context);
        this.bJK = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.e.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + " " + i3);
                e.this.bJL.mVideoWidth = i2;
                e.this.bJL.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && e.this.bJL != null) {
                    if (alaLivePlayerData.fpsAvg != e.this.bJL.bJV) {
                        e.this.id(940);
                    }
                    if (alaLivePlayerData.videoBitrate != e.this.bJL.bJT) {
                        e.this.id(939);
                    }
                    if (alaLivePlayerData.audioBitrate != e.this.bJL.bJU) {
                        e.this.id(938);
                    }
                    e.this.bJL.bJW = (int) alaLivePlayerData.bandWidth;
                    e.this.bJL.bJV = (int) alaLivePlayerData.fpsAvg;
                    e.this.bJL.bJU = (int) alaLivePlayerData.audioBitrate;
                    e.this.bJL.bJT = (int) alaLivePlayerData.videoBitrate;
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
        this.bJM = new o(this.bJR);
        this.bJM.start();
        this.bJR.getWindow().addFlags(128);
    }

    public b Zk() {
        return this.bJI;
    }

    public void a(b bVar) {
        this.bJI = bVar;
        if (!this.bJI.hidden && this.bJI.mAutoPlay) {
            start();
        }
    }

    public void start() {
        if (this.bJI != null) {
            if (this.bJI.hidden) {
                BdLog.d("mPlayerId = " + this.mPlayerId + "can not start(), hide = " + this.bJI.hidden);
                return;
            }
            BdLog.d(this.mPlayerId + " start()");
            if (this.bJJ != null) {
                resetPlayer();
            }
            Zl();
            c(this.bJI);
            b(this.bJI.mSrc, "", "", false);
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
        return this.bJI.slaveId;
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
        if (this.bJI != null && this.mContainer != null && d(this.bJR, this.mContainer)) {
            if (this.bJR.getRequestedOrientation() != 1) {
                this.bJM.aZX();
            }
            f(this.bJR, 0);
            return true;
        }
        release();
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void resetPlayer() {
        if (this.bJJ != null) {
            this.bJJ.stop();
            this.bJJ.destroy();
        }
        this.bJJ = null;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.mPlayerId + " release()");
        this.bJR.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        AiAppsPlayerManager.removePlayerContext(this);
        this.bJM.stop();
        if (this.bJJ != null) {
            this.bJJ.stop();
            this.bJJ.destroy();
            this.bJJ = null;
        }
    }

    private void Zl() {
        dG(this.bJI.bJA);
        ia(this.bJI.bJC);
        ib(this.bJI.bJD);
        if (TextUtils.equals(this.bJI.bJE, "horizontal")) {
            ic(90);
        } else {
            ic(0);
        }
        if (TextUtils.equals(this.bJI.bJF, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void dG(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.bJJ != null) {
            this.bJJ.setAudioMute(z);
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
        if (this.bJJ != null) {
            this.bJJ.setRenderVideoModel(1, i != 2 ? 1 : 2);
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
        this.bJQ = hashMap2;
        return true;
    }

    private boolean prepareAsync() {
        boolean z;
        CustomResponsedMessage runTask;
        if (this.bJJ == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.bJR)) != null && runTask.getData() != null) {
            this.bJJ = (com.baidu.tbadk.ala.d) runTask.getData();
            this.bJJ.a(this.bJK);
        }
        if (this.bJJ == null) {
            return false;
        }
        if (this.bJJ.a(1, this.bJI.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
            this.bJN = true;
        }
        if (this.bJO != null) {
            int i = 0;
            while (true) {
                if (i >= this.bJO.getChildCount()) {
                    z = false;
                    break;
                } else if (this.bJO.getChildAt(i) == this.bJJ.wh()) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                this.bJO.addView(this.bJJ.wh(), new LinearLayout.LayoutParams(this.bJI.position.getWidth(), this.bJI.position.getHeight()));
                if (TextUtils.equals(this.bJI.bJF, "contain")) {
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
        if (this.bJP) {
            this.mContainer.setHidden(bVar.hidden);
            return true;
        }
        AiAppsNaViewModel cloneModel = bVar.cloneModel();
        cloneModel.id = this.mPlayerId;
        cloneModel.slaveId = this.bJI.slaveId;
        cloneModel.parentId = bVar.parentId;
        if (NAViewFinder.findNAViewById(cloneModel.slaveId, this.mPlayerId, NAViewUtils.getViewRoot(cloneModel.slaveId)) == null) {
            BdLog.d("insertOrUpdateCoverContainer 00");
            this.bJO = new FrameLayout(this.bJR);
            return this.mContainer.insertView(this.bJO, cloneModel);
        }
        BdLog.d("insertOrUpdateCoverContainer 01");
        return this.mContainer.updateView(cloneModel);
    }

    private void c(b bVar) {
        BdLog.d("initVideoCoverContainer 00");
        b(bVar);
    }

    private boolean d(b bVar) {
        if (this.bJI == null) {
            return false;
        }
        return (this.bJI.bJA == bVar.bJA && this.bJI.bJC == bVar.bJC && this.bJI.bJD == bVar.bJD && TextUtils.equals(this.bJI.bJE, bVar.bJE) && TextUtils.equals(this.bJI.bJF, bVar.bJF)) ? false : true;
    }

    public void e(@NonNull b bVar) {
        BdLog.d("updatePlayerConfig params: " + bVar.toString());
        if (d(bVar)) {
            this.bJI = bVar;
            Zl();
        }
        this.bJI = bVar;
        c(this.bJI);
    }

    public boolean isPlaying() {
        if (this.bJJ != null) {
            return this.bJN;
        }
        return false;
    }

    public void stop() {
        if (this.bJJ != null) {
            this.bJJ.stop();
            this.bJJ.destroy();
            this.bJJ.a(null);
            this.bJJ = null;
            this.bJN = false;
        }
    }

    public void f(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.bJP = z;
        int aO = l.aO(this.bJR);
        int aQ = l.aQ(this.bJR);
        if (z) {
            if (i == 90 || i == -90) {
                this.bJM.aZX();
                aO = aQ;
                aQ = aO;
            }
        } else if (this.bJR.getRequestedOrientation() != 1) {
            this.bJM.aZX();
        }
        if (z) {
            a(this.bJR, i, aO, aQ);
        } else {
            f(this.bJR, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null) {
            this.bJP = true;
            if (this.mContainer != null && this.mContainer.getParent() != null) {
                ((ViewGroup) this.mContainer.getParent()).removeView(this.mContainer);
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.mContainer);
                viewGroup.addView(this.mContainer);
            }
            if (this.bJJ != null && this.bJJ.wh().getParent() != null) {
                ((ViewGroup) this.bJJ.wh().getParent()).removeView(this.bJJ.wh());
            }
            this.bJO.addView(this.bJJ.wh(), new LinearLayout.LayoutParams(i2, i3));
            this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void f(Activity activity, int i) {
        if (activity == null || this.bJI == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.bJP = false;
        if (this.mContainer != null && this.mContainer.getParent() != null) {
            ((ViewGroup) this.mContainer.getParent()).removeView(this.mContainer);
        }
        if (this.bJJ != null && this.bJJ.wh().getParent() != null) {
            ((ViewGroup) this.bJJ.wh().getParent()).removeView(this.bJJ.wh());
        }
        int width = this.bJI.position.getWidth();
        int height = this.bJI.position.getHeight();
        this.bJI.position.getLeft();
        this.bJI.position.getTop();
        this.bJO.addView(this.bJJ.wh(), new LinearLayout.LayoutParams(width, height));
        this.mContainer.attach();
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zm() {
        String jSONString = this.bJL.toJSONString();
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
