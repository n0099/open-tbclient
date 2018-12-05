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
    private com.baidu.tbadk.ala.d bIT;
    private d.a bIU;
    private o bIW;
    private FrameLayout bIY;
    private boolean bIZ;
    private HashMap<Integer, String> bJa;
    private Activity bJb;
    private AiAppsNAViewContainer mContainer;
    private boolean mDetached;
    CustomMessageListener mNetworkChangedListener;
    private String mPlayerId;
    private b bIS = b.YK();
    private com.baidu.tieba.aiapps.apps.media.b.a.a bIV = new com.baidu.tieba.aiapps.apps.media.b.a.a();
    private volatile boolean bIX = false;

    public e(Context context, String str) {
        this.mPlayerId = str;
        this.bJb = (Activity) context;
        if (!TextUtils.isEmpty(this.mPlayerId)) {
            AiAppsPlayerManager.addPlayerContext(this);
        }
        BdLog.d("AiAppsLivePlayer create: " + this.mPlayerId);
        this.mContainer = new AiAppsNAViewContainer(context);
        this.bIU = new d.a() { // from class: com.baidu.tieba.aiapps.apps.media.b.e.1
            @Override // com.baidu.tbadk.ala.d.a
            public void onFirstFrame(int i, int i2, int i3) {
                BdLog.d("onFirstFrame " + i2 + " " + i3);
                e.this.bIV.mVideoWidth = i2;
                e.this.bIV.mVideoHeight = i3;
            }

            @Override // com.baidu.tbadk.ala.d.a
            public void a(int i, AlaLivePlayerData alaLivePlayerData) {
                if (alaLivePlayerData != null && e.this.bIV != null) {
                    if (alaLivePlayerData.fpsAvg != e.this.bIV.bJf) {
                        e.this.ic(940);
                    }
                    if (alaLivePlayerData.videoBitrate != e.this.bIV.bJd) {
                        e.this.ic(939);
                    }
                    if (alaLivePlayerData.audioBitrate != e.this.bIV.bJe) {
                        e.this.ic(938);
                    }
                    e.this.bIV.bJg = (int) alaLivePlayerData.bandWidth;
                    e.this.bIV.bJf = (int) alaLivePlayerData.fpsAvg;
                    e.this.bIV.bJe = (int) alaLivePlayerData.audioBitrate;
                    e.this.bIV.bJd = (int) alaLivePlayerData.videoBitrate;
                }
            }
        };
        this.mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.aiapps.apps.media.b.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    e.this.YN();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        this.bIW = new o(this.bJb);
        this.bIW.start();
        this.bJb.getWindow().addFlags(128);
    }

    public b YL() {
        return this.bIS;
    }

    public void a(b bVar) {
        this.bIS = bVar;
        if (!this.bIS.hidden && this.bIS.mAutoPlay) {
            start();
        }
    }

    public void start() {
        if (this.bIS != null) {
            if (this.bIS.hidden) {
                BdLog.d("mPlayerId = " + this.mPlayerId + "can not start(), hide = " + this.bIS.hidden);
                return;
            }
            BdLog.d(this.mPlayerId + " start()");
            if (this.bIT != null) {
                resetPlayer();
            }
            YM();
            c(this.bIS);
            b(this.bIS.mSrc, "", "", false);
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
        return this.bIS.slaveId;
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
        if (this.bIS != null && this.mContainer != null && d(this.bJb, this.mContainer)) {
            if (this.bJb.getRequestedOrientation() != 1) {
                this.bIW.aYK();
            }
            f(this.bJb, 0);
            return true;
        }
        release();
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void resetPlayer() {
        if (this.bIT != null) {
            this.bIT.stop();
            this.bIT.destroy();
        }
        this.bIT = null;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void onDestroy() {
        release();
        BdLog.d("mPlayerId  + \" onDestroy() ");
    }

    public void release() {
        BdLog.d(this.mPlayerId + " release()");
        this.bJb.getWindow().clearFlags(128);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        AiAppsPlayerManager.removePlayerContext(this);
        this.bIW.stop();
        if (this.bIT != null) {
            this.bIT.stop();
            this.bIT.destroy();
            this.bIT = null;
        }
    }

    private void YM() {
        dD(this.bIS.bIK);
        hZ(this.bIS.bIM);
        ia(this.bIS.bIN);
        if (TextUtils.equals(this.bIS.bIO, "horizontal")) {
            ib(90);
        } else {
            ib(0);
        }
        if (TextUtils.equals(this.bIS.bIP, "contain")) {
            setVideoScalingMode(2);
        } else {
            setVideoScalingMode(0);
        }
    }

    public void dD(boolean z) {
        BdLog.d("mPlayerId + \" mute() isMuted: \" + isMuted");
        if (this.bIT != null) {
            this.bIT.setAudioMute(z);
        }
    }

    public void hZ(int i) {
    }

    public void ia(int i) {
    }

    public void ib(int i) {
    }

    public void setVideoScalingMode(int i) {
        BdLog.d("setVideoScalingMode scalingMode: " + i);
        if (this.bIT != null) {
            this.bIT.setRenderVideoModel(1, i != 2 ? 1 : 2);
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
        this.bJa = hashMap2;
        return true;
    }

    private boolean prepareAsync() {
        boolean z;
        CustomResponsedMessage runTask;
        if (this.bIT == null && (runTask = MessageManager.getInstance().runTask(2921364, com.baidu.tbadk.ala.d.class, this.bJb)) != null && runTask.getData() != null) {
            this.bIT = (com.baidu.tbadk.ala.d) runTask.getData();
            this.bIT.a(this.bIU);
        }
        if (this.bIT == null) {
            return false;
        }
        if (this.bIT.a(1, this.bIS.mSrc, new LinearLayout.LayoutParams(-1, -1))) {
            this.bIX = true;
        }
        if (this.bIY != null) {
            int i = 0;
            while (true) {
                if (i >= this.bIY.getChildCount()) {
                    z = false;
                    break;
                } else if (this.bIY.getChildAt(i) == this.bIT.wa()) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                this.bIY.addView(this.bIT.wa(), new LinearLayout.LayoutParams(this.bIS.position.getWidth(), this.bIS.position.getHeight()));
                if (TextUtils.equals(this.bIS.bIP, "contain")) {
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
        if (this.bIZ) {
            this.mContainer.setHidden(bVar.hidden);
            return true;
        }
        AiAppsNaViewModel cloneModel = bVar.cloneModel();
        cloneModel.id = this.mPlayerId;
        cloneModel.slaveId = this.bIS.slaveId;
        cloneModel.parentId = bVar.parentId;
        if (NAViewFinder.findNAViewById(cloneModel.slaveId, this.mPlayerId, NAViewUtils.getViewRoot(cloneModel.slaveId)) == null) {
            BdLog.d("insertOrUpdateCoverContainer 00");
            this.bIY = new FrameLayout(this.bJb);
            return this.mContainer.insertView(this.bIY, cloneModel);
        }
        BdLog.d("insertOrUpdateCoverContainer 01");
        return this.mContainer.updateView(cloneModel);
    }

    private void c(b bVar) {
        BdLog.d("initVideoCoverContainer 00");
        b(bVar);
    }

    private boolean d(b bVar) {
        if (this.bIS == null) {
            return false;
        }
        return (this.bIS.bIK == bVar.bIK && this.bIS.bIM == bVar.bIM && this.bIS.bIN == bVar.bIN && TextUtils.equals(this.bIS.bIO, bVar.bIO) && TextUtils.equals(this.bIS.bIP, bVar.bIP)) ? false : true;
    }

    public void e(@NonNull b bVar) {
        BdLog.d("updatePlayerConfig params: " + bVar.toString());
        if (d(bVar)) {
            this.bIS = bVar;
            YM();
        }
        this.bIS = bVar;
        c(this.bIS);
    }

    public boolean isPlaying() {
        if (this.bIT != null) {
            return this.bIX;
        }
        return false;
    }

    public void stop() {
        if (this.bIT != null) {
            this.bIT.stop();
            this.bIT.destroy();
            this.bIT.a(null);
            this.bIT = null;
            this.bIX = false;
        }
    }

    public void f(boolean z, int i) {
        BdLog.d("setFullScreen  = " + z + " direction  = " + i);
        this.bIZ = z;
        int aO = l.aO(this.bJb);
        int aQ = l.aQ(this.bJb);
        if (z) {
            if (i == 90 || i == -90) {
                this.bIW.aYK();
                aO = aQ;
                aQ = aO;
            }
        } else if (this.bJb.getRequestedOrientation() != 1) {
            this.bIW.aYK();
        }
        if (z) {
            a(this.bJb, i, aO, aQ);
        } else {
            f(this.bJb, i);
        }
    }

    private void a(Activity activity, int i, int i2, int i3) {
        if (activity != null) {
            this.bIZ = true;
            if (this.mContainer != null && this.mContainer.getParent() != null) {
                ((ViewGroup) this.mContainer.getParent()).removeView(this.mContainer);
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup != null) {
                viewGroup.removeView(this.mContainer);
                viewGroup.addView(this.mContainer);
            }
            if (this.bIT != null && this.bIT.wa().getParent() != null) {
                ((ViewGroup) this.bIT.wa().getParent()).removeView(this.bIT.wa());
            }
            this.bIY.addView(this.bIT.wa(), new LinearLayout.LayoutParams(i2, i3));
            this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void f(Activity activity, int i) {
        if (activity == null || this.bIS == null) {
            BdLog.d("updatePortraitEmbedScreen activity = null or mParams = null");
            return;
        }
        this.bIZ = false;
        if (this.mContainer != null && this.mContainer.getParent() != null) {
            ((ViewGroup) this.mContainer.getParent()).removeView(this.mContainer);
        }
        if (this.bIT != null && this.bIT.wa().getParent() != null) {
            ((ViewGroup) this.bIT.wa().getParent()).removeView(this.bIT.wa());
        }
        int width = this.bIS.position.getWidth();
        int height = this.bIS.position.getHeight();
        this.bIS.position.getLeft();
        this.bIS.position.getTop();
        this.bIY.addView(this.bIT.wa(), new LinearLayout.LayoutParams(width, height));
        this.mContainer.attach();
    }

    private static boolean d(Activity activity, View view) {
        ViewGroup viewGroup;
        return (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null || viewGroup.indexOfChild(view) == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YN() {
        String jSONString = this.bIV.toJSONString();
        if (!TextUtils.isEmpty(jSONString)) {
            BdLog.d(this.mPlayerId + " dispatchNetStatusEvent statusData: " + jSONString);
            d.y(getSlaveId(), getPlayerId(), jSONString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ic(int i) {
        int hX = c.hX(i);
        BdLog.d(this.mPlayerId + " dispatchStatusIfNeeded what: " + i + " liveStatusCode:" + hX);
        if (hX != 100) {
            if (hX == 2101) {
                d.x(getSlaveId(), getPlayerId(), c.hY(SubPackageAPSInfo.RESULT_APS_NO_PACKAGE));
            }
            d.x(getSlaveId(), getPlayerId(), c.hY(hX));
        }
    }
}
