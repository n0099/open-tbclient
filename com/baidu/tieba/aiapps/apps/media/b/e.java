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
    private com.baidu.tbadk.ala.d bIW;
    private d.a bIX;
    private o bIZ;
    private FrameLayout bJb;
    private boolean bJc;
    private HashMap<Integer, String> bJd;
    private Activity bJe;
    private AiAppsNAViewContainer mContainer;
    private boolean mDetached;
    CustomMessageListener mNetworkChangedListener;
    private String mPlayerId;
    private b bIV = b.YM();
    private com.baidu.tieba.aiapps.apps.media.b.a.a bIY = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean bJa = false;

    public e(Context context, String str) {
        this.mPlayerId = str;
        this.bJe = (Activity) context;
        if (!TextUtils.isEmpty(this.mPlayerId)) {
            AiAppsPlayerManager.addPlayerContext(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.mPlayerId);
        this.mContainer = new AiAppsNAViewContainer(context);
        this.bIX = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.e.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + " " + i3);
                e.this.bIY.mVideoWidth = i2;
                e.this.bIY.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && e.this.bIY != null) {
                    if (alaLivePlayerData.fpsAvg != e.this.bIY.bJi) {
                        e.this.id(940);
                    }
                    if (alaLivePlayerData.videoBitrate != e.this.bIY.bJg) {
                        e.this.id(939);
                    }
                    if (alaLivePlayerData.audioBitrate != e.this.bIY.bJh) {
                        e.this.id(938);
                    }
                    e.this.bIY.bJj = (int) alaLivePlayerData.bandWidth;
                    e.this.bIY.bJi = (int) alaLivePlayerData.fpsAvg;
                    e.this.bIY.bJh = (int) alaLivePlayerData.audioBitrate;
                    e.this.bIY.bJg = (int) alaLivePlayerData.videoBitrate;
                }
            }
        };
        this.mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.aiapps.apps.media.b.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    e.this.YP();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        this.bIZ = new o(this.bJe);
        this.bIZ.start();
        this.bJe.getWindow().addFlags(128);
    }

    public b YN() {
        return this.bIV;
    }

    public void a(b bVar) {
        this.bIV = bVar;
        if (!this.bIV.hidden && this.bIV.mAutoPlay) {
            start();
        }
    }

    public void start() {
        if (this.bIV != null) {
            if (this.bIV.hidden) {
                BdLog.d("mPlayerId = " + this.mPlayerId + "can not start(), hide = " + this.bIV.hidden);
                return;
            }
            BdLog.d(this.mPlayerId + " start()");
            if (this.bIW != null) {
                resetPlayer();
            }
            YO();
            c(this.bIV);
            b(this.bIV.mSrc, "", "", false);
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
        return this.bIV.slaveId;
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
        if (this.bIV != null && this.mContainer != null && d(this.bJe, this.mContainer)) {
            if (this.bJe.getRequestedOrientation() != 1) {
                this.bIZ.aZx();
            }
            f(this.bJe, 0);
            return true;
        }
        release();
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void resetPlayer() {
        if (this.bIW != null) {
            this.bIW.stop();
            this.bIW.destroy();
        }
        this.bIW = null;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.mPlayerId + " release()");
        this.bJe.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        AiAppsPlayerManager.removePlayerContext(this);
        this.bIZ.stop();
        if (this.bIW != null) {
            this.bIW.stop();
            this.bIW.destroy();
            this.bIW = null;
        }
    }

    private void YO() {
        dD(this.bIV.bIN);
        ia(this.bIV.bIP);
        ib(this.bIV.bIQ);
        if (TextUtils.equals(this.bIV.bIR, "horizontal")) {
            ic(90);
        } else {
            ic(0);
        }
        if (TextUtils.equals(this.bIV.bIS, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void dD(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.bIW != null) {
            this.bIW.setAudioMute(z);
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
        if (this.bIW != null) {
            this.bIW.setRenderVideoModel(1, i != 2 ? 1 : 2);
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
        this.bJd = hashMap2;
        return true;
    }

    private boolean prepareAsync() {
        boolean z;
        CustomResponsedMessage runTask;
        if (this.bIW == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.bJe)) != null && runTask.getData() != null) {
            this.bIW = (com.baidu.tbadk.ala.d) runTask.getData();
            this.bIW.a(this.bIX);
        }
        if (this.bIW == null) {
            return false;
        }
        if (this.bIW.a(1, this.bIV.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
            this.bJa = true;
        }
        if (this.bJb != null) {
            int i = 0;
            while (true) {
                if (i >= this.bJb.getChildCount()) {
                    z = false;
                    break;
                } else if (this.bJb.getChildAt(i) == this.bIW.wa()) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                this.bJb.addView(this.bIW.wa(), new LinearLayout.LayoutParams(this.bIV.position.getWidth(), this.bIV.position.getHeight()));
                if (TextUtils.equals(this.bIV.bIS, "contain")) {
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
        if (this.bJc) {
            this.mContainer.setHidden(bVar.hidden);
            return true;
        }
        AiAppsNaViewModel cloneModel = bVar.cloneModel();
        cloneModel.id = this.mPlayerId;
        cloneModel.slaveId = this.bIV.slaveId;
        cloneModel.parentId = bVar.parentId;
        if (NAViewFinder.findNAViewById(cloneModel.slaveId, this.mPlayerId, NAViewUtils.getViewRoot(cloneModel.slaveId)) == null) {
            BdLog.d("insertOrUpdateCoverContainer 00");
            this.bJb = new FrameLayout(this.bJe);
            return this.mContainer.insertView(this.bJb, cloneModel);
        }
        BdLog.d("insertOrUpdateCoverContainer 01");
        return this.mContainer.updateView(cloneModel);
    }

    private void c(b bVar) {
        BdLog.d("initVideoCoverContainer 00");
        b(bVar);
    }

    private boolean d(b bVar) {
        if (this.bIV == null) {
            return false;
        }
        return (this.bIV.bIN == bVar.bIN && this.bIV.bIP == bVar.bIP && this.bIV.bIQ == bVar.bIQ && TextUtils.equals(this.bIV.bIR, bVar.bIR) && TextUtils.equals(this.bIV.bIS, bVar.bIS)) ? false : true;
    }

    public void e(@NonNull b bVar) {
        BdLog.d("updatePlayerConfig params: " + bVar.toString());
        if (d(bVar)) {
            this.bIV = bVar;
            YO();
        }
        this.bIV = bVar;
        c(this.bIV);
    }

    public boolean isPlaying() {
        if (this.bIW != null) {
            return this.bJa;
        }
        return false;
    }

    public void stop() {
        if (this.bIW != null) {
            this.bIW.stop();
            this.bIW.destroy();
            this.bIW.a(null);
            this.bIW = null;
            this.bJa = false;
        }
    }

    public void f(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.bJc = z;
        int aO = l.aO(this.bJe);
        int aQ = l.aQ(this.bJe);
        if (z) {
            if (i == 90 || i == -90) {
                this.bIZ.aZx();
                aO = aQ;
                aQ = aO;
            }
        } else if (this.bJe.getRequestedOrientation() != 1) {
            this.bIZ.aZx();
        }
        if (z) {
            a(this.bJe, i, aO, aQ);
        } else {
            f(this.bJe, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null) {
            this.bJc = true;
            if (this.mContainer != null && this.mContainer.getParent() != null) {
                ((ViewGroup) this.mContainer.getParent()).removeView(this.mContainer);
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.mContainer);
                viewGroup.addView(this.mContainer);
            }
            if (this.bIW != null && this.bIW.wa().getParent() != null) {
                ((ViewGroup) this.bIW.wa().getParent()).removeView(this.bIW.wa());
            }
            this.bJb.addView(this.bIW.wa(), new LinearLayout.LayoutParams(i2, i3));
            this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void f(Activity activity, int i) {
        if (activity == null || this.bIV == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.bJc = false;
        if (this.mContainer != null && this.mContainer.getParent() != null) {
            ((ViewGroup) this.mContainer.getParent()).removeView(this.mContainer);
        }
        if (this.bIW != null && this.bIW.wa().getParent() != null) {
            ((ViewGroup) this.bIW.wa().getParent()).removeView(this.bIW.wa());
        }
        int width = this.bIV.position.getWidth();
        int height = this.bIV.position.getHeight();
        this.bIV.position.getLeft();
        this.bIV.position.getTop();
        this.bJb.addView(this.bIW.wa(), new LinearLayout.LayoutParams(width, height));
        this.mContainer.attach();
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YP() {
        String jSONString = this.bIY.toJSONString();
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
