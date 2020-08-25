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
import com.baidu.live.data.be;
import com.baidu.live.data.bo;
import com.baidu.live.data.bt;
import com.baidu.live.data.bx;
import com.baidu.live.data.r;
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
/* loaded from: classes7.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    CustomMessageTask.CustomRunnable bke;
    private ViewGroup fZu;
    private FrameLayout gGA;
    private View.OnLayoutChangeListener gGB;
    private InterfaceC0637a gGC;
    private long gGD;
    private CustomMessageListener gGE;
    private CustomMessageListener gGF;
    private CustomMessageListener gGG;
    private CustomMessageListener gGH;
    private CustomMessageListener gGI;
    private CustomMessageListener gGJ;
    private AlaLiveBottomOperationView gGy;
    private com.baidu.tieba.ala.liveroom.data.a gGz;
    private Handler handler;
    private String otherParams;

    /* renamed from: com.baidu.tieba.ala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0637a {
        void bK(int i, int i2);

        void bL(int i, int i2);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.gGE = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                bx bxVar;
                String str;
                long j;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                    j = 1000;
                } else {
                    be beVar = com.baidu.live.w.a.Nk().bka;
                    if (beVar != null && (bxVar = beVar.aJz) != null) {
                        str = bxVar.aLD;
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
        this.gGF = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.ala.liveroom.operation.a.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.ala.liveroom.w.b.bWx().beS != null) {
                    str = com.baidu.tieba.ala.liveroom.w.b.bWx().beS.aDS;
                    i = com.baidu.tieba.ala.liveroom.w.b.bWx().beS.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, 1000L, i);
                }
            }
        };
        this.gGG = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gGy != null) {
                    a.this.gGy.a(false, null, a.this.JY());
                }
            }
        };
        this.gGH = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    r LC = (a.this.gGz == null || a.this.gGz.gxe == null) ? null : a.this.gGz.gxe.LC();
                    if (LC == null || LC.aEd == null) {
                        a.this.gGy.a(false, null, a.this.JY());
                    } else {
                        a.this.gGy.a(LC.aEd.isNewUser, LC.mLiveInfo, a.this.JY());
                    }
                }
            }
        };
        this.gGI = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.ala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gGy != null && a.this.gGy.gHo != null) {
                    a.this.gGy.gHo.performClick();
                }
            }
        };
        this.bke = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.gGy != null && a.this.gGy.gHo != null) {
                        int[] iArr = new int[2];
                        a.this.gGy.gHo.getLocationOnScreen(iArr);
                        jSONObject.putOpt("turn_tab_x", Integer.valueOf(iArr[0]));
                        jSONObject.putOpt("turn_tab_y", Integer.valueOf(iArr[1]));
                    }
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_TURN_TAB_LOC, jSONObject.toString());
                } catch (JSONException e) {
                    return null;
                }
            }
        };
        this.gGJ = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.bVW();
            }
        };
        MessageManager.getInstance().registerListener(this.gGE);
        MessageManager.getInstance().registerListener(this.gGF);
        MessageManager.getInstance().registerListener(this.gGG);
        MessageManager.getInstance().registerListener(this.gGH);
        MessageManager.getInstance().registerListener(this.gGI);
        MessageManager.getInstance().registerListener(this.gGJ);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_TURN_TAB_LOC, this.bke);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void lN(boolean z) {
        if (this.gGy != null) {
            this.gGy.lN(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.gGy != null) {
            this.gGy.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.gGz = aVar;
            this.fZu = viewGroup;
            if (this.gGy == null) {
                this.gGy = new AlaLiveBottomOperationView(getPageContext());
            }
            this.gGy.registerListeners();
            this.gGy.setOnLiveViewOperationBtnClickListener(bVar);
            this.gGy.getRootView().setId(a.g.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.gGy.getRootView()) >= 0) {
                viewGroup.removeView(this.gGy.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.gGy.getRootView().setBackgroundResource(a.f.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.gGy.getRootView().setBackgroundResource(a.d.sdk_transparent);
            }
            viewGroup.addView(this.gGy.getRootView(), layoutParams);
            if (this.gGA == null) {
                this.gGA = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.gGA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.m(view, 8);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                bVR();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.gGy.gGT != null) {
                this.gGy.gGT.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.gGy != null && this.gGy.gDC != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds72));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12) + UtilHelper.getStatusBarHeight();
                    } else {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds25);
                    }
                    layoutParams2.gravity = 53;
                    if (this.gGy.gDC.getParent() != null && (this.gGy.gDC.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.gGy.gDC.getParent()).removeView(this.gGy.gDC);
                    }
                    aVar.gxd.getLiveContainerView().addView(this.gGy.gDC, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.gGA.getParent() != null && (this.gGA.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.gGA.getParent()).removeView(this.gGA);
                    }
                    aVar.gxd.getLiveContainerView().addView(this.gGA, layoutParams3);
                }
            }
            if (this.gGy != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isGiftPanelUnabled()) {
                    this.gGy.setGiftBtnVisible(false);
                } else {
                    this.gGy.setGiftBtnVisible(true);
                }
            }
            if (this.gGy != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isQuickChatUnabled()) {
                    this.gGy.setQuickImInputVisible(false);
                } else {
                    this.gGy.setQuickImInputVisible(true);
                }
            }
        }
    }

    public void bO(View view) {
        if (this.gGy != null) {
            this.gGy.bO(view);
        }
    }

    private void bVR() {
        bt btVar;
        bo boVar;
        if (this.gGB != null) {
            this.gGy.gHo.removeOnLayoutChangeListener(this.gGB);
        }
        be beVar = com.baidu.live.w.a.Nk().bka;
        if (beVar != null && (btVar = beVar.aJB) != null && btVar.aLr && (boVar = beVar.aJy) != null && boVar.aKv != null && !TextUtils.isEmpty(boVar.aKv.webUrl)) {
            this.gGy.gHo.setVisibility(0);
            this.gGy.gHp.setVisibility(0);
            this.gGy.gHq.setVisibility(8);
            return;
        }
        this.gGy.gHo.setVisibility(8);
    }

    public void a(InterfaceC0637a interfaceC0637a) {
        if (this.gGy != null && this.gGy.gHo != null && this.gGy.gHo.getVisibility() == 0) {
            this.gGC = interfaceC0637a;
            this.gGB = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.bVS();
                }
            };
            this.gGy.gHo.addOnLayoutChangeListener(this.gGB);
            this.gGy.gHo.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gGC != null) {
                        int[] iArr = new int[2];
                        a.this.gGy.gHo.getLocationInWindow(iArr);
                        a.this.gGC.bK((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.gGy.gHo.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.gGy.gHo.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVS() {
        if (this.gGy != null && this.gGy.gHo != null && this.gGy.gHo.getVisibility() == 0) {
            this.gGy.gHo.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gGy != null && a.this.gGy.gHo != null && a.this.gGy.gHo.getVisibility() == 0 && a.this.gGC != null) {
                        int[] iArr = new int[2];
                        a.this.gGy.gHo.getLocationInWindow(iArr);
                        a.this.gGC.bL((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.gGy.gHo.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.gGy.gHo.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.gGy != null && this.gGy.gHo != null && this.gGy.gHo.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.gGy.gHp.getVisibility() == 0) {
                    this.gGy.gHp.setVisibility(8);
                }
                if (this.gGy.gHq.getVisibility() != 0) {
                    this.gGy.gHq.setVisibility(0);
                }
                this.gGy.gHq.setTimer(str, f);
                return;
            }
            if (this.gGy.gHp.getVisibility() != 0) {
                this.gGy.gHp.setVisibility(0);
            }
            if (this.gGy.gHq.getVisibility() == 0) {
                this.gGy.gHq.setVisibility(8);
            }
        }
    }

    public void bVT() {
        if (this.gGy != null && this.gGy.gHo != null && this.gGB != null) {
            this.gGy.gHo.removeOnLayoutChangeListener(this.gGB);
        }
        this.gGD = 0L;
        if (this.fZu != null && this.gGy != null && this.fZu.indexOfChild(this.gGy.getRootView()) > 0) {
            this.fZu.removeView(this.gGy.getRootView());
        }
        if (this.gGA != null && (this.gGA.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gGA.getParent()).removeView(this.gGA);
        }
        if (this.gGy != null && this.gGy.gDC != null && (this.gGy.gDC.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gGy.gDC.getParent()).removeView(this.gGy.gDC);
        }
    }

    public void setVisibility(int i) {
        if (this.gGy != null && this.gGy.getRootView() != null) {
            this.gGy.getRootView().setVisibility(i);
        }
        if (this.gGA != null) {
            this.gGA.setVisibility(i);
        }
    }

    public void a(o oVar, r rVar) {
        if (this.gGy != null) {
            if (rVar != null && rVar.aEd != null) {
                this.gGy.a(rVar.aEd.isNewUser, rVar.mLiveInfo, JY());
            } else {
                this.gGy.a(false, null, JY());
            }
            if (oVar == null || TextUtils.isEmpty(oVar.EP()) || oVar.EO() != 1) {
                this.gGy.gGR.setVisibility(8);
                return;
            }
            this.gGy.gGR.setVisibility(0);
            this.gGy.gGQ.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.gGy.gGQ.startLoad(oVar.EP(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.gGy.gHi.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.gGy.gGR.setVisibility(8);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (oVar.EN() != null) {
                    alaStaticItem.addParams("gifts_value", oVar.EN().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, oVar.EN().DR());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, oVar.EN().DS());
                }
                if (rVar != null && rVar.mLiveInfo != null) {
                    alaStaticItem.addParams("feed_id", rVar.mLiveInfo.feed_id);
                    alaStaticItem.addParams("room_id", rVar.mLiveInfo.room_id);
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    public String JY() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void bVU() {
        if (this.gGy != null) {
            this.gGy.setMsgLayoutWidth(false);
            this.gGy.gHr.setVisibility(8);
            this.gGy.gHs.setVisibility(8);
        }
    }

    public void bVV() {
        if (this.gGy != null) {
            this.gGy.setMsgLayoutWidth(true);
            this.gGy.gHr.setVisibility(0);
            this.gGy.gHs.setVisibility(0);
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.gGy != null) {
            if (i3 == 2) {
                bVV();
            } else if (i3 == 1) {
                bVU();
            }
            bVS();
        }
    }

    public void uC(int i) {
        if (this.gGy != null && this.gGy.gDC != null) {
            this.gGy.gDC.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.gGy != null && this.gGy.gGP != null) {
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
            if (this.fZu != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (a.this.fZu != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout = a.this.gGy.gGP;
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
                            a.this.fZu.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.fZu != null) {
                            a.this.fZu.removeView(inflate);
                        }
                    }
                }, i + j);
            }
        }
    }

    public ImageView getLandscapeBarrageImageView() {
        if (this.gGy != null) {
            return this.gGy.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.gGD = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gGE);
        MessageManager.getInstance().unRegisterListener(this.gGF);
        MessageManager.getInstance().unRegisterListener(this.gGG);
        MessageManager.getInstance().unRegisterListener(this.gGH);
        MessageManager.getInstance().unRegisterListener(this.gGI);
        MessageManager.getInstance().unRegisterListener(this.gGJ);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TURN_TAB_LOC);
        this.gGC = null;
        if (this.gGy != null) {
            if (this.gGB != null) {
                this.gGy.gHo.removeOnLayoutChangeListener(this.gGB);
            }
            this.gGy.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVW() {
        if (this.gGy != null && this.gGy.gHp != null) {
            this.gGy.gHp.setScaleX(1.1f);
            this.gGy.gHp.setScaleY(1.1f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gGy.gHp, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gGy.gHp, View.SCALE_Y, 1.1f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gGy.gHp, View.SCALE_X, 1.0f, 1.1f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.gGy.gHp, View.SCALE_Y, 1.0f, 1.1f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(100L);
            animatorSet2.playTogether(ofFloat3, ofFloat4);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.gGy.gHp, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.gGy.gHp, View.SCALE_Y, 1.1f, 1.0f);
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
