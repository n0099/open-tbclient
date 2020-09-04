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
    CustomMessageTask.CustomRunnable bkh;
    private ViewGroup fZy;
    private AlaLiveBottomOperationView gGC;
    private com.baidu.tieba.ala.liveroom.data.a gGD;
    private FrameLayout gGE;
    private View.OnLayoutChangeListener gGF;
    private InterfaceC0637a gGG;
    private long gGH;
    private CustomMessageListener gGI;
    private CustomMessageListener gGJ;
    private CustomMessageListener gGK;
    private CustomMessageListener gGL;
    private CustomMessageListener gGM;
    private CustomMessageListener gGN;
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
        this.gGI = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
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
                    be beVar = com.baidu.live.w.a.Nk().bkd;
                    if (beVar != null && (bxVar = beVar.aJB) != null) {
                        str = bxVar.aLF;
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
        this.gGJ = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.ala.liveroom.operation.a.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.ala.liveroom.w.b.bWy().beU != null) {
                    str = com.baidu.tieba.ala.liveroom.w.b.bWy().beU.aDU;
                    i = com.baidu.tieba.ala.liveroom.w.b.bWy().beU.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, 1000L, i);
                }
            }
        };
        this.gGK = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gGC != null) {
                    a.this.gGC.a(false, null, a.this.JY());
                }
            }
        };
        this.gGL = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    r LC = (a.this.gGD == null || a.this.gGD.gxi == null) ? null : a.this.gGD.gxi.LC();
                    if (LC == null || LC.aEf == null) {
                        a.this.gGC.a(false, null, a.this.JY());
                    } else {
                        a.this.gGC.a(LC.aEf.isNewUser, LC.mLiveInfo, a.this.JY());
                    }
                }
            }
        };
        this.gGM = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.ala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gGC != null && a.this.gGC.gHs != null) {
                    a.this.gGC.gHs.performClick();
                }
            }
        };
        this.bkh = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.gGC != null && a.this.gGC.gHs != null) {
                        int[] iArr = new int[2];
                        a.this.gGC.gHs.getLocationOnScreen(iArr);
                        jSONObject.putOpt("turn_tab_x", Integer.valueOf(iArr[0]));
                        jSONObject.putOpt("turn_tab_y", Integer.valueOf(iArr[1]));
                    }
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_TURN_TAB_LOC, jSONObject.toString());
                } catch (JSONException e) {
                    return null;
                }
            }
        };
        this.gGN = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.bVX();
            }
        };
        MessageManager.getInstance().registerListener(this.gGI);
        MessageManager.getInstance().registerListener(this.gGJ);
        MessageManager.getInstance().registerListener(this.gGK);
        MessageManager.getInstance().registerListener(this.gGL);
        MessageManager.getInstance().registerListener(this.gGM);
        MessageManager.getInstance().registerListener(this.gGN);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_TURN_TAB_LOC, this.bkh);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void lP(boolean z) {
        if (this.gGC != null) {
            this.gGC.lP(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.gGC != null) {
            this.gGC.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.gGD = aVar;
            this.fZy = viewGroup;
            if (this.gGC == null) {
                this.gGC = new AlaLiveBottomOperationView(getPageContext());
            }
            this.gGC.registerListeners();
            this.gGC.setOnLiveViewOperationBtnClickListener(bVar);
            this.gGC.getRootView().setId(a.g.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.gGC.getRootView()) >= 0) {
                viewGroup.removeView(this.gGC.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.gGC.getRootView().setBackgroundResource(a.f.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.gGC.getRootView().setBackgroundResource(a.d.sdk_transparent);
            }
            viewGroup.addView(this.gGC.getRootView(), layoutParams);
            if (this.gGE == null) {
                this.gGE = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.gGE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.m(view, 8);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                bVS();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.gGC.gGX != null) {
                this.gGC.gGX.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.gGC != null && this.gGC.gDG != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds72));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12) + UtilHelper.getStatusBarHeight();
                    } else {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds25);
                    }
                    layoutParams2.gravity = 53;
                    if (this.gGC.gDG.getParent() != null && (this.gGC.gDG.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.gGC.gDG.getParent()).removeView(this.gGC.gDG);
                    }
                    aVar.gxh.getLiveContainerView().addView(this.gGC.gDG, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.gGE.getParent() != null && (this.gGE.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.gGE.getParent()).removeView(this.gGE);
                    }
                    aVar.gxh.getLiveContainerView().addView(this.gGE, layoutParams3);
                }
            }
            if (this.gGC != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isGiftPanelUnabled()) {
                    this.gGC.setGiftBtnVisible(false);
                } else {
                    this.gGC.setGiftBtnVisible(true);
                }
            }
            if (this.gGC != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isQuickChatUnabled()) {
                    this.gGC.setQuickImInputVisible(false);
                } else {
                    this.gGC.setQuickImInputVisible(true);
                }
            }
        }
    }

    public void bO(View view) {
        if (this.gGC != null) {
            this.gGC.bO(view);
        }
    }

    private void bVS() {
        bt btVar;
        bo boVar;
        if (this.gGF != null) {
            this.gGC.gHs.removeOnLayoutChangeListener(this.gGF);
        }
        be beVar = com.baidu.live.w.a.Nk().bkd;
        if (beVar != null && (btVar = beVar.aJD) != null && btVar.aLt && (boVar = beVar.aJA) != null && boVar.aKx != null && !TextUtils.isEmpty(boVar.aKx.webUrl)) {
            this.gGC.gHs.setVisibility(0);
            this.gGC.gHt.setVisibility(0);
            this.gGC.gHu.setVisibility(8);
            return;
        }
        this.gGC.gHs.setVisibility(8);
    }

    public void a(InterfaceC0637a interfaceC0637a) {
        if (this.gGC != null && this.gGC.gHs != null && this.gGC.gHs.getVisibility() == 0) {
            this.gGG = interfaceC0637a;
            this.gGF = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.bVT();
                }
            };
            this.gGC.gHs.addOnLayoutChangeListener(this.gGF);
            this.gGC.gHs.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gGG != null) {
                        int[] iArr = new int[2];
                        a.this.gGC.gHs.getLocationInWindow(iArr);
                        a.this.gGG.bK((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.gGC.gHs.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.gGC.gHs.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVT() {
        if (this.gGC != null && this.gGC.gHs != null && this.gGC.gHs.getVisibility() == 0) {
            this.gGC.gHs.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gGC != null && a.this.gGC.gHs != null && a.this.gGC.gHs.getVisibility() == 0 && a.this.gGG != null) {
                        int[] iArr = new int[2];
                        a.this.gGC.gHs.getLocationInWindow(iArr);
                        a.this.gGG.bL((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.gGC.gHs.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.gGC.gHs.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.gGC != null && this.gGC.gHs != null && this.gGC.gHs.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.gGC.gHt.getVisibility() == 0) {
                    this.gGC.gHt.setVisibility(8);
                }
                if (this.gGC.gHu.getVisibility() != 0) {
                    this.gGC.gHu.setVisibility(0);
                }
                this.gGC.gHu.setTimer(str, f);
                return;
            }
            if (this.gGC.gHt.getVisibility() != 0) {
                this.gGC.gHt.setVisibility(0);
            }
            if (this.gGC.gHu.getVisibility() == 0) {
                this.gGC.gHu.setVisibility(8);
            }
        }
    }

    public void bVU() {
        if (this.gGC != null && this.gGC.gHs != null && this.gGF != null) {
            this.gGC.gHs.removeOnLayoutChangeListener(this.gGF);
        }
        this.gGH = 0L;
        if (this.fZy != null && this.gGC != null && this.fZy.indexOfChild(this.gGC.getRootView()) > 0) {
            this.fZy.removeView(this.gGC.getRootView());
        }
        if (this.gGE != null && (this.gGE.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gGE.getParent()).removeView(this.gGE);
        }
        if (this.gGC != null && this.gGC.gDG != null && (this.gGC.gDG.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gGC.gDG.getParent()).removeView(this.gGC.gDG);
        }
    }

    public void setVisibility(int i) {
        if (this.gGC != null && this.gGC.getRootView() != null) {
            this.gGC.getRootView().setVisibility(i);
        }
        if (this.gGE != null) {
            this.gGE.setVisibility(i);
        }
    }

    public void a(o oVar, r rVar) {
        if (this.gGC != null) {
            if (rVar != null && rVar.aEf != null) {
                this.gGC.a(rVar.aEf.isNewUser, rVar.mLiveInfo, JY());
            } else {
                this.gGC.a(false, null, JY());
            }
            if (oVar == null || TextUtils.isEmpty(oVar.EP()) || oVar.EO() != 1) {
                this.gGC.gGV.setVisibility(8);
                return;
            }
            this.gGC.gGV.setVisibility(0);
            this.gGC.gGU.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.gGC.gGU.startLoad(oVar.EP(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.gGC.gHm.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.gGC.gGV.setVisibility(8);
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

    public void bVV() {
        if (this.gGC != null) {
            this.gGC.setMsgLayoutWidth(false);
            this.gGC.gHv.setVisibility(8);
            this.gGC.gHw.setVisibility(8);
        }
    }

    public void bVW() {
        if (this.gGC != null) {
            this.gGC.setMsgLayoutWidth(true);
            this.gGC.gHv.setVisibility(0);
            this.gGC.gHw.setVisibility(0);
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.gGC != null) {
            if (i3 == 2) {
                bVW();
            } else if (i3 == 1) {
                bVV();
            }
            bVT();
        }
    }

    public void uC(int i) {
        if (this.gGC != null && this.gGC.gDG != null) {
            this.gGC.gDG.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.gGC != null && this.gGC.gGT != null) {
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
            if (this.fZy != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (a.this.fZy != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout = a.this.gGC.gGT;
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
                            a.this.fZy.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.fZy != null) {
                            a.this.fZy.removeView(inflate);
                        }
                    }
                }, i + j);
            }
        }
    }

    public ImageView getLandscapeBarrageImageView() {
        if (this.gGC != null) {
            return this.gGC.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.gGH = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gGI);
        MessageManager.getInstance().unRegisterListener(this.gGJ);
        MessageManager.getInstance().unRegisterListener(this.gGK);
        MessageManager.getInstance().unRegisterListener(this.gGL);
        MessageManager.getInstance().unRegisterListener(this.gGM);
        MessageManager.getInstance().unRegisterListener(this.gGN);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TURN_TAB_LOC);
        this.gGG = null;
        if (this.gGC != null) {
            if (this.gGF != null) {
                this.gGC.gHs.removeOnLayoutChangeListener(this.gGF);
            }
            this.gGC.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVX() {
        if (this.gGC != null && this.gGC.gHt != null) {
            this.gGC.gHt.setScaleX(1.1f);
            this.gGC.gHt.setScaleY(1.1f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gGC.gHt, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gGC.gHt, View.SCALE_Y, 1.1f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gGC.gHt, View.SCALE_X, 1.0f, 1.1f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.gGC.gHt, View.SCALE_Y, 1.0f, 1.1f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(100L);
            animatorSet2.playTogether(ofFloat3, ofFloat4);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.gGC.gHt, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.gGC.gHt, View.SCALE_Y, 1.1f, 1.0f);
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
