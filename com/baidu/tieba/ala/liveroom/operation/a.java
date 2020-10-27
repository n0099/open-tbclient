package com.baidu.tieba.ala.liveroom.operation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.bm;
import com.baidu.live.data.cb;
import com.baidu.live.data.cg;
import com.baidu.live.data.cl;
import com.baidu.live.data.w;
import com.baidu.live.gift.o;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.util.ScreenHelper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private ViewGroup bEg;
    CustomMessageTask.CustomRunnable bsC;
    private Handler handler;
    private CustomMessageListener hkA;
    private CustomMessageListener hkB;
    private CustomMessageListener hkC;
    private CustomMessageListener hkD;
    private AlaLiveBottomOperationView hks;
    private com.baidu.tieba.ala.liveroom.data.a hkt;
    private FrameLayout hku;
    private View.OnLayoutChangeListener hkv;
    private InterfaceC0668a hkw;
    private long hkx;
    private CustomMessageListener hky;
    private CustomMessageListener hkz;
    private String otherParams;

    /* renamed from: com.baidu.tieba.ala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0668a {
        void bM(int i, int i2);

        void bN(int i, int i2);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.hky = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                cl clVar;
                String str;
                long j;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                    j = 1000;
                } else {
                    bm bmVar = com.baidu.live.z.a.Pq().bsy;
                    if (bmVar != null && (clVar = bmVar.aOB) != null) {
                        str = clVar.aRk;
                        j = IMConnection.RETRY_DELAY_TIMES;
                    } else {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, j, 3000);
                }
            }
        };
        this.hkz = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.ala.liveroom.operation.a.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.ala.liveroom.w.b.ceK().bmT != null) {
                    str = com.baidu.tieba.ala.liveroom.w.b.ceK().bmT.aIv;
                    i = com.baidu.tieba.ala.liveroom.w.b.ceK().bmT.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, 1000L, i);
                }
            }
        };
        this.hkA = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hks != null) {
                    a.this.hks.a(false, null, a.this.Md());
                }
            }
        };
        this.hkB = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    w GH = (a.this.hkt == null || a.this.hkt.haB == null) ? null : a.this.hkt.haB.GH();
                    if (GH == null || GH.aIA == null) {
                        a.this.hks.a(false, null, a.this.Md());
                    } else {
                        a.this.hks.a(GH.aIA.isNewUser, GH.mLiveInfo, a.this.Md());
                    }
                }
            }
        };
        this.hkC = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.ala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hks != null && a.this.hks.hlh != null) {
                    a.this.hks.hlh.performClick();
                }
            }
        };
        this.bsC = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.hks != null && a.this.hks.hlh != null) {
                        int[] iArr = new int[2];
                        a.this.hks.hlh.getLocationOnScreen(iArr);
                        jSONObject.putOpt("turn_tab_x", Integer.valueOf(iArr[0]));
                        jSONObject.putOpt("turn_tab_y", Integer.valueOf(iArr[1]));
                    }
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_TURN_TAB_LOC, jSONObject.toString());
                } catch (JSONException e) {
                    return null;
                }
            }
        };
        this.hkD = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.ceg();
            }
        };
        MessageManager.getInstance().registerListener(this.hky);
        MessageManager.getInstance().registerListener(this.hkz);
        MessageManager.getInstance().registerListener(this.hkA);
        MessageManager.getInstance().registerListener(this.hkB);
        MessageManager.getInstance().registerListener(this.hkC);
        MessageManager.getInstance().registerListener(this.hkD);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_TURN_TAB_LOC, this.bsC);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void mJ(boolean z) {
        if (this.hks != null) {
            this.hks.mJ(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.hks != null) {
            this.hks.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.hkt = aVar;
            this.bEg = viewGroup;
            if (this.hks == null) {
                this.hks = new AlaLiveBottomOperationView(getPageContext());
            }
            this.hks.Qe();
            this.hks.registerListeners();
            this.hks.setOnLiveViewOperationBtnClickListener(bVar);
            this.hks.getRootView().setId(a.g.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.hks.getRootView()) >= 0) {
                viewGroup.removeView(this.hks.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.hks.getRootView().setBackgroundResource(a.f.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.hks.getRootView().setBackgroundResource(a.d.sdk_transparent);
            }
            viewGroup.addView(this.hks.getRootView(), layoutParams);
            if (this.hku == null) {
                this.hku = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.hku.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.p(view, 8);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                ceb();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.hks.hkN != null) {
                this.hks.hkN.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.hks != null && this.hks.hht != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds72));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12) + UtilHelper.getStatusBarHeight();
                    } else {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds25);
                    }
                    layoutParams2.gravity = 53;
                    if (this.hks.hht.getParent() != null && (this.hks.hht.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hks.hht.getParent()).removeView(this.hks.hht);
                    }
                    aVar.haA.getLiveContainerView().addView(this.hks.hht, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.hku.getParent() != null && (this.hku.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hku.getParent()).removeView(this.hku);
                    }
                    aVar.haA.getLiveContainerView().addView(this.hku, layoutParams3);
                }
            }
            if (this.hks != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isGiftPanelUnabled()) {
                    this.hks.setGiftBtnVisible(false);
                } else {
                    this.hks.setGiftBtnVisible(true);
                }
            }
            if (this.hks != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isQuickChatUnabled()) {
                    this.hks.setQuickImInputVisible(false);
                } else {
                    this.hks.setQuickImInputVisible(true);
                }
            }
        }
    }

    public void cb(View view) {
        if (this.hks != null) {
            this.hks.cb(view);
        }
    }

    private void ceb() {
        cg cgVar;
        cb cbVar;
        if (this.hkv != null) {
            this.hks.hlh.removeOnLayoutChangeListener(this.hkv);
        }
        bm bmVar = com.baidu.live.z.a.Pq().bsy;
        if (bmVar != null && (cgVar = bmVar.aOD) != null && cgVar.aQQ && (cbVar = bmVar.aOA) != null && cbVar.aPR != null && !TextUtils.isEmpty(cbVar.aPR.webUrl)) {
            this.hks.hlh.setVisibility(0);
            this.hks.hli.setVisibility(0);
            this.hks.hlj.setVisibility(8);
            return;
        }
        this.hks.hlh.setVisibility(8);
    }

    public void a(InterfaceC0668a interfaceC0668a) {
        if (this.hks != null && this.hks.hlh != null && this.hks.hlh.getVisibility() == 0) {
            this.hkw = interfaceC0668a;
            this.hkv = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.cec();
                }
            };
            this.hks.hlh.addOnLayoutChangeListener(this.hkv);
            this.hks.hlh.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hkw != null) {
                        int[] iArr = new int[2];
                        a.this.hks.hlh.getLocationInWindow(iArr);
                        a.this.hkw.bM((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.hks.hlh.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.hks.hlh.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cec() {
        if (this.hks != null && this.hks.hlh != null && this.hks.hlh.getVisibility() == 0) {
            this.hks.hlh.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hks != null && a.this.hks.hlh != null && a.this.hks.hlh.getVisibility() == 0 && a.this.hkw != null) {
                        int[] iArr = new int[2];
                        a.this.hks.hlh.getLocationInWindow(iArr);
                        a.this.hkw.bN((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.hks.hlh.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.hks.hlh.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.hks != null && this.hks.hlh != null && this.hks.hlh.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.hks.hli.getVisibility() == 0) {
                    this.hks.hli.setVisibility(8);
                }
                if (this.hks.hlj.getVisibility() != 0) {
                    this.hks.hlj.setVisibility(0);
                }
                this.hks.hlj.setTimer(str, f);
                return;
            }
            if (this.hks.hli.getVisibility() != 0) {
                this.hks.hli.setVisibility(0);
            }
            if (this.hks.hlj.getVisibility() == 0) {
                this.hks.hlj.setVisibility(8);
            }
        }
    }

    public void ced() {
        if (this.hks != null && this.hks.hlh != null && this.hkv != null) {
            this.hks.hlh.removeOnLayoutChangeListener(this.hkv);
        }
        this.hkx = 0L;
        if (this.bEg != null && this.hks != null && this.bEg.indexOfChild(this.hks.getRootView()) > 0) {
            this.bEg.removeView(this.hks.getRootView());
        }
        if (this.hku != null && (this.hku.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hku.getParent()).removeView(this.hku);
        }
        if (this.hks != null && this.hks.hht != null && (this.hks.hht.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hks.hht.getParent()).removeView(this.hks.hht);
        }
    }

    public void setVisibility(int i) {
        if (this.hks != null && this.hks.getRootView() != null) {
            this.hks.getRootView().setVisibility(i);
        }
        if (this.hku != null) {
            this.hku.setVisibility(i);
        }
    }

    public void a(o oVar, w wVar) {
        if (this.hks != null) {
            if (wVar != null && wVar.aIA != null) {
                this.hks.a(wVar.aIA.isNewUser, wVar.mLiveInfo, Md());
            } else {
                this.hks.a(false, null, Md());
            }
            if (oVar == null || TextUtils.isEmpty(oVar.Gr()) || oVar.Gq() != 1) {
                this.hks.hkL.setVisibility(8);
                return;
            }
            this.hks.hkL.setVisibility(0);
            this.hks.hkK.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.hks.hkK.startLoad(oVar.Gr(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.hks.hlb.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.hks.hkL.setVisibility(8);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (oVar.Gp() != null) {
                    alaStaticItem.addParams("gifts_value", oVar.Gp().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, oVar.Gp().Fs());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, oVar.Gp().Ft());
                }
                if (wVar != null && wVar.mLiveInfo != null) {
                    alaStaticItem.addParams("feed_id", wVar.mLiveInfo.feed_id);
                    alaStaticItem.addParams("room_id", wVar.mLiveInfo.room_id);
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    public String Md() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void cee() {
        if (this.hks != null) {
            this.hks.setMsgLayoutWidth(false);
            this.hks.hlk.setVisibility(8);
            this.hks.hll.setVisibility(8);
        }
    }

    public void cef() {
        if (this.hks != null) {
            this.hks.setMsgLayoutWidth(true);
            this.hks.hlk.setVisibility(0);
            this.hks.hll.setVisibility(0);
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.hks != null) {
            if (i3 == 2) {
                cef();
            } else if (i3 == 1) {
                cee();
            }
            cec();
        }
    }

    public void vU(int i) {
        if (this.hks != null && this.hks.hht != null) {
            this.hks.hht.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.hks != null && this.hks.hkJ != null) {
            final View inflate = getPageContext().getPageActivity().getLayoutInflater().inflate(a.h.toast_gift_guide, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(a.g.textView);
            ImageView imageView = (ImageView) inflate.findViewById(a.g.arrow_imageView);
            textView.setText(str);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                textView.setBackgroundResource(a.f.bg_guide_gift_toast_hk);
                imageView.setImageResource(a.f.bg_guide_gift_toast_arrow_hk);
            } else {
                textView.setBackgroundResource(a.f.bg_guide_gift_toast_qm);
                imageView.setImageResource(a.f.bg_guide_gift_toast_arrow_qm);
            }
            if (this.bEg != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (a.this.bEg != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout = a.this.hks.hkJ;
                            int[] iArr = new int[2];
                            frameLayout.getLocationOnScreen(iArr);
                            int dimensionPixelSize = ((BdUtilHelper.getScreenSize(pageActivity).widthPixels - iArr[0]) - pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds44)) - (frameLayout.getWidth() / 2);
                            inflate.measure(0, 0);
                            int measuredHeight = (iArr[1] - inflate.getMeasuredHeight()) - frameLayout.getHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(11);
                            layoutParams.rightMargin = dimensionPixelSize;
                            layoutParams.topMargin = measuredHeight;
                            a.this.bEg.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.bEg != null) {
                            a.this.bEg.removeView(inflate);
                        }
                    }
                }, i + j);
            }
        }
    }

    public ImageView getLandscapeBarrageImageView() {
        if (this.hks != null) {
            return this.hks.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.hkx = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.hky);
        MessageManager.getInstance().unRegisterListener(this.hkz);
        MessageManager.getInstance().unRegisterListener(this.hkA);
        MessageManager.getInstance().unRegisterListener(this.hkB);
        MessageManager.getInstance().unRegisterListener(this.hkC);
        MessageManager.getInstance().unRegisterListener(this.hkD);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TURN_TAB_LOC);
        this.hkw = null;
        if (this.hks != null) {
            if (this.hkv != null) {
                this.hks.hlh.removeOnLayoutChangeListener(this.hkv);
            }
            this.hks.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceg() {
        if (this.hks != null && this.hks.hli != null) {
            this.hks.hli.setScaleX(1.1f);
            this.hks.hli.setScaleY(1.1f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hks.hli, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hks.hli, View.SCALE_Y, 1.1f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hks.hli, View.SCALE_X, 1.0f, 1.1f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hks.hli, View.SCALE_Y, 1.0f, 1.1f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(100L);
            animatorSet2.playTogether(ofFloat3, ofFloat4);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hks.hli, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.hks.hli, View.SCALE_Y, 1.1f, 1.0f);
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.setDuration(100L);
            animatorSet3.playTogether(ofFloat5, ofFloat6);
            AnimatorSet animatorSet4 = new AnimatorSet();
            animatorSet4.setStartDelay(600L);
            animatorSet4.setInterpolator(new LinearInterpolator());
            animatorSet4.playSequentially(animatorSet, animatorSet2, animatorSet3);
            animatorSet4.start();
        }
    }
}
