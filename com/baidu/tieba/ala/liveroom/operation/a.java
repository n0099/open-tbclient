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
import com.baidu.live.data.bj;
import com.baidu.live.data.bw;
import com.baidu.live.data.cb;
import com.baidu.live.data.cg;
import com.baidu.live.data.u;
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
    private ViewGroup bBk;
    CustomMessageTask.CustomRunnable bqN;
    private AlaLiveBottomOperationView gYC;
    private com.baidu.tieba.ala.liveroom.data.a gYD;
    private FrameLayout gYE;
    private View.OnLayoutChangeListener gYF;
    private InterfaceC0652a gYG;
    private long gYH;
    private CustomMessageListener gYI;
    private CustomMessageListener gYJ;
    private CustomMessageListener gYK;
    private CustomMessageListener gYL;
    private CustomMessageListener gYM;
    private CustomMessageListener gYN;
    private Handler handler;
    private String otherParams;

    /* renamed from: com.baidu.tieba.ala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0652a {
        void bK(int i, int i2);

        void bL(int i, int i2);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.gYI = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                cg cgVar;
                String str;
                long j;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                    j = 1000;
                } else {
                    bj bjVar = com.baidu.live.x.a.OS().bqJ;
                    if (bjVar != null && (cgVar = bjVar.aNW) != null) {
                        str = cgVar.aQz;
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
        this.gYJ = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.ala.liveroom.operation.a.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.ala.liveroom.w.b.cbG().blx != null) {
                    str = com.baidu.tieba.ala.liveroom.w.b.cbG().blx.aHU;
                    i = com.baidu.tieba.ala.liveroom.w.b.cbG().blx.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, 1000L, i);
                }
            }
        };
        this.gYK = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gYC != null) {
                    a.this.gYC.a(false, null, a.this.LI());
                }
            }
        };
        this.gYL = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    u Gm = (a.this.gYD == null || a.this.gYD.gON == null) ? null : a.this.gYD.gON.Gm();
                    if (Gm == null || Gm.aIf == null) {
                        a.this.gYC.a(false, null, a.this.LI());
                    } else {
                        a.this.gYC.a(Gm.aIf.isNewUser, Gm.mLiveInfo, a.this.LI());
                    }
                }
            }
        };
        this.gYM = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.ala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gYC != null && a.this.gYC.gZr != null) {
                    a.this.gYC.gZr.performClick();
                }
            }
        };
        this.bqN = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.gYC != null && a.this.gYC.gZr != null) {
                        int[] iArr = new int[2];
                        a.this.gYC.gZr.getLocationOnScreen(iArr);
                        jSONObject.putOpt("turn_tab_x", Integer.valueOf(iArr[0]));
                        jSONObject.putOpt("turn_tab_y", Integer.valueOf(iArr[1]));
                    }
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_TURN_TAB_LOC, jSONObject.toString());
                } catch (JSONException e) {
                    return null;
                }
            }
        };
        this.gYN = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.cbc();
            }
        };
        MessageManager.getInstance().registerListener(this.gYI);
        MessageManager.getInstance().registerListener(this.gYJ);
        MessageManager.getInstance().registerListener(this.gYK);
        MessageManager.getInstance().registerListener(this.gYL);
        MessageManager.getInstance().registerListener(this.gYM);
        MessageManager.getInstance().registerListener(this.gYN);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_TURN_TAB_LOC, this.bqN);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void mt(boolean z) {
        if (this.gYC != null) {
            this.gYC.mt(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.gYC != null) {
            this.gYC.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.gYD = aVar;
            this.bBk = viewGroup;
            if (this.gYC == null) {
                this.gYC = new AlaLiveBottomOperationView(getPageContext());
            }
            this.gYC.Pl();
            this.gYC.registerListeners();
            this.gYC.setOnLiveViewOperationBtnClickListener(bVar);
            this.gYC.getRootView().setId(a.g.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.gYC.getRootView()) >= 0) {
                viewGroup.removeView(this.gYC.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.gYC.getRootView().setBackgroundResource(a.f.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.gYC.getRootView().setBackgroundResource(a.d.sdk_transparent);
            }
            viewGroup.addView(this.gYC.getRootView(), layoutParams);
            if (this.gYE == null) {
                this.gYE = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.gYE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.o(view, 8);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                caX();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.gYC.gYX != null) {
                this.gYC.gYX.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.gYC != null && this.gYC.gVF != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds72));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12) + UtilHelper.getStatusBarHeight();
                    } else {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds25);
                    }
                    layoutParams2.gravity = 53;
                    if (this.gYC.gVF.getParent() != null && (this.gYC.gVF.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.gYC.gVF.getParent()).removeView(this.gYC.gVF);
                    }
                    aVar.gOM.getLiveContainerView().addView(this.gYC.gVF, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.gYE.getParent() != null && (this.gYE.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.gYE.getParent()).removeView(this.gYE);
                    }
                    aVar.gOM.getLiveContainerView().addView(this.gYE, layoutParams3);
                }
            }
            if (this.gYC != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isGiftPanelUnabled()) {
                    this.gYC.setGiftBtnVisible(false);
                } else {
                    this.gYC.setGiftBtnVisible(true);
                }
            }
            if (this.gYC != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isQuickChatUnabled()) {
                    this.gYC.setQuickImInputVisible(false);
                } else {
                    this.gYC.setQuickImInputVisible(true);
                }
            }
        }
    }

    public void bX(View view) {
        if (this.gYC != null) {
            this.gYC.bX(view);
        }
    }

    private void caX() {
        cb cbVar;
        bw bwVar;
        if (this.gYF != null) {
            this.gYC.gZr.removeOnLayoutChangeListener(this.gYF);
        }
        bj bjVar = com.baidu.live.x.a.OS().bqJ;
        if (bjVar != null && (cbVar = bjVar.aNY) != null && cbVar.aQg && (bwVar = bjVar.aNV) != null && bwVar.aPh != null && !TextUtils.isEmpty(bwVar.aPh.webUrl)) {
            this.gYC.gZr.setVisibility(0);
            this.gYC.gZs.setVisibility(0);
            this.gYC.gZt.setVisibility(8);
            return;
        }
        this.gYC.gZr.setVisibility(8);
    }

    public void a(InterfaceC0652a interfaceC0652a) {
        if (this.gYC != null && this.gYC.gZr != null && this.gYC.gZr.getVisibility() == 0) {
            this.gYG = interfaceC0652a;
            this.gYF = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.caY();
                }
            };
            this.gYC.gZr.addOnLayoutChangeListener(this.gYF);
            this.gYC.gZr.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gYG != null) {
                        int[] iArr = new int[2];
                        a.this.gYC.gZr.getLocationInWindow(iArr);
                        a.this.gYG.bK((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.gYC.gZr.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.gYC.gZr.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caY() {
        if (this.gYC != null && this.gYC.gZr != null && this.gYC.gZr.getVisibility() == 0) {
            this.gYC.gZr.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gYC != null && a.this.gYC.gZr != null && a.this.gYC.gZr.getVisibility() == 0 && a.this.gYG != null) {
                        int[] iArr = new int[2];
                        a.this.gYC.gZr.getLocationInWindow(iArr);
                        a.this.gYG.bL((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.gYC.gZr.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.gYC.gZr.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.gYC != null && this.gYC.gZr != null && this.gYC.gZr.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.gYC.gZs.getVisibility() == 0) {
                    this.gYC.gZs.setVisibility(8);
                }
                if (this.gYC.gZt.getVisibility() != 0) {
                    this.gYC.gZt.setVisibility(0);
                }
                this.gYC.gZt.setTimer(str, f);
                return;
            }
            if (this.gYC.gZs.getVisibility() != 0) {
                this.gYC.gZs.setVisibility(0);
            }
            if (this.gYC.gZt.getVisibility() == 0) {
                this.gYC.gZt.setVisibility(8);
            }
        }
    }

    public void caZ() {
        if (this.gYC != null && this.gYC.gZr != null && this.gYF != null) {
            this.gYC.gZr.removeOnLayoutChangeListener(this.gYF);
        }
        this.gYH = 0L;
        if (this.bBk != null && this.gYC != null && this.bBk.indexOfChild(this.gYC.getRootView()) > 0) {
            this.bBk.removeView(this.gYC.getRootView());
        }
        if (this.gYE != null && (this.gYE.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gYE.getParent()).removeView(this.gYE);
        }
        if (this.gYC != null && this.gYC.gVF != null && (this.gYC.gVF.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gYC.gVF.getParent()).removeView(this.gYC.gVF);
        }
    }

    public void setVisibility(int i) {
        if (this.gYC != null && this.gYC.getRootView() != null) {
            this.gYC.getRootView().setVisibility(i);
        }
        if (this.gYE != null) {
            this.gYE.setVisibility(i);
        }
    }

    public void a(o oVar, u uVar) {
        if (this.gYC != null) {
            if (uVar != null && uVar.aIf != null) {
                this.gYC.a(uVar.aIf.isNewUser, uVar.mLiveInfo, LI());
            } else {
                this.gYC.a(false, null, LI());
            }
            if (oVar == null || TextUtils.isEmpty(oVar.Gc()) || oVar.Gb() != 1) {
                this.gYC.gYV.setVisibility(8);
                return;
            }
            this.gYC.gYV.setVisibility(0);
            this.gYC.gYU.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.gYC.gYU.startLoad(oVar.Gc(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.gYC.gZl.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.gYC.gYV.setVisibility(8);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (oVar.Ga() != null) {
                    alaStaticItem.addParams("gifts_value", oVar.Ga().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, oVar.Ga().Fd());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, oVar.Ga().Fe());
                }
                if (uVar != null && uVar.mLiveInfo != null) {
                    alaStaticItem.addParams("feed_id", uVar.mLiveInfo.feed_id);
                    alaStaticItem.addParams("room_id", uVar.mLiveInfo.room_id);
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    public String LI() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void cba() {
        if (this.gYC != null) {
            this.gYC.setMsgLayoutWidth(false);
            this.gYC.gZu.setVisibility(8);
            this.gYC.gZv.setVisibility(8);
        }
    }

    public void cbb() {
        if (this.gYC != null) {
            this.gYC.setMsgLayoutWidth(true);
            this.gYC.gZu.setVisibility(0);
            this.gYC.gZv.setVisibility(0);
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.gYC != null) {
            if (i3 == 2) {
                cbb();
            } else if (i3 == 1) {
                cba();
            }
            caY();
        }
    }

    public void vA(int i) {
        if (this.gYC != null && this.gYC.gVF != null) {
            this.gYC.gVF.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.gYC != null && this.gYC.gYT != null) {
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
            if (this.bBk != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (a.this.bBk != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout = a.this.gYC.gYT;
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
                            a.this.bBk.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.bBk != null) {
                            a.this.bBk.removeView(inflate);
                        }
                    }
                }, i + j);
            }
        }
    }

    public ImageView getLandscapeBarrageImageView() {
        if (this.gYC != null) {
            return this.gYC.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.gYH = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gYI);
        MessageManager.getInstance().unRegisterListener(this.gYJ);
        MessageManager.getInstance().unRegisterListener(this.gYK);
        MessageManager.getInstance().unRegisterListener(this.gYL);
        MessageManager.getInstance().unRegisterListener(this.gYM);
        MessageManager.getInstance().unRegisterListener(this.gYN);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TURN_TAB_LOC);
        this.gYG = null;
        if (this.gYC != null) {
            if (this.gYF != null) {
                this.gYC.gZr.removeOnLayoutChangeListener(this.gYF);
            }
            this.gYC.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbc() {
        if (this.gYC != null && this.gYC.gZs != null) {
            this.gYC.gZs.setScaleX(1.1f);
            this.gYC.gZs.setScaleY(1.1f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gYC.gZs, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gYC.gZs, View.SCALE_Y, 1.1f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gYC.gZs, View.SCALE_X, 1.0f, 1.1f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.gYC.gZs, View.SCALE_Y, 1.0f, 1.1f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(100L);
            animatorSet2.playTogether(ofFloat3, ofFloat4);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.gYC.gZs, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.gYC.gZs, View.SCALE_Y, 1.1f, 1.0f);
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
