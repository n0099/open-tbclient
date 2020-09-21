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
import com.baidu.live.data.cf;
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
    CustomMessageTask.CustomRunnable bna;
    private AlaLiveBottomOperationView gKb;
    private com.baidu.tieba.ala.liveroom.data.a gKc;
    private FrameLayout gKd;
    private View.OnLayoutChangeListener gKe;
    private InterfaceC0634a gKf;
    private long gKg;
    private CustomMessageListener gKh;
    private CustomMessageListener gKi;
    private CustomMessageListener gKj;
    private CustomMessageListener gKk;
    private CustomMessageListener gKl;
    private CustomMessageListener gKm;
    private ViewGroup gcM;
    private Handler handler;
    private String otherParams;

    /* renamed from: com.baidu.tieba.ala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0634a {
        void bK(int i, int i2);

        void bL(int i, int i2);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.gKh = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                cf cfVar;
                String str;
                long j;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                    j = 1000;
                } else {
                    bj bjVar = com.baidu.live.x.a.NN().bmW;
                    if (bjVar != null && (cfVar = bjVar.aKR) != null) {
                        str = cfVar.aNo;
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
        this.gKi = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.ala.liveroom.operation.a.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.ala.liveroom.w.b.bYg().bhH != null) {
                    str = com.baidu.tieba.ala.liveroom.w.b.bYg().bhH.aEQ;
                    i = com.baidu.tieba.ala.liveroom.w.b.bYg().bhH.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, 1000L, i);
                }
            }
        };
        this.gKj = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gKb != null) {
                    a.this.gKb.a(false, null, a.this.KD());
                }
            }
        };
        this.gKk = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    u Fq = (a.this.gKc == null || a.this.gKc.gAu == null) ? null : a.this.gKc.gAu.Fq();
                    if (Fq == null || Fq.aFb == null) {
                        a.this.gKb.a(false, null, a.this.KD());
                    } else {
                        a.this.gKb.a(Fq.aFb.isNewUser, Fq.mLiveInfo, a.this.KD());
                    }
                }
            }
        };
        this.gKl = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.ala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gKb != null && a.this.gKb.gKR != null) {
                    a.this.gKb.gKR.performClick();
                }
            }
        };
        this.bna = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.gKb != null && a.this.gKb.gKR != null) {
                        int[] iArr = new int[2];
                        a.this.gKb.gKR.getLocationOnScreen(iArr);
                        jSONObject.putOpt("turn_tab_x", Integer.valueOf(iArr[0]));
                        jSONObject.putOpt("turn_tab_y", Integer.valueOf(iArr[1]));
                    }
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_TURN_TAB_LOC, jSONObject.toString());
                } catch (JSONException e) {
                    return null;
                }
            }
        };
        this.gKm = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.bXH();
            }
        };
        MessageManager.getInstance().registerListener(this.gKh);
        MessageManager.getInstance().registerListener(this.gKi);
        MessageManager.getInstance().registerListener(this.gKj);
        MessageManager.getInstance().registerListener(this.gKk);
        MessageManager.getInstance().registerListener(this.gKl);
        MessageManager.getInstance().registerListener(this.gKm);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_TURN_TAB_LOC, this.bna);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void lR(boolean z) {
        if (this.gKb != null) {
            this.gKb.lR(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.gKb != null) {
            this.gKb.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.gKc = aVar;
            this.gcM = viewGroup;
            if (this.gKb == null) {
                this.gKb = new AlaLiveBottomOperationView(getPageContext());
            }
            this.gKb.Og();
            this.gKb.registerListeners();
            this.gKb.setOnLiveViewOperationBtnClickListener(bVar);
            this.gKb.getRootView().setId(a.g.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.gKb.getRootView()) >= 0) {
                viewGroup.removeView(this.gKb.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.gKb.getRootView().setBackgroundResource(a.f.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.gKb.getRootView().setBackgroundResource(a.d.sdk_transparent);
            }
            viewGroup.addView(this.gKb.getRootView(), layoutParams);
            if (this.gKd == null) {
                this.gKd = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.gKd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.n(view, 8);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                bXC();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.gKb.gKw != null) {
                this.gKb.gKw.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.gKb != null && this.gKb.gHf != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds72));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12) + UtilHelper.getStatusBarHeight();
                    } else {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds25);
                    }
                    layoutParams2.gravity = 53;
                    if (this.gKb.gHf.getParent() != null && (this.gKb.gHf.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.gKb.gHf.getParent()).removeView(this.gKb.gHf);
                    }
                    aVar.gAt.getLiveContainerView().addView(this.gKb.gHf, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.gKd.getParent() != null && (this.gKd.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.gKd.getParent()).removeView(this.gKd);
                    }
                    aVar.gAt.getLiveContainerView().addView(this.gKd, layoutParams3);
                }
            }
            if (this.gKb != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isGiftPanelUnabled()) {
                    this.gKb.setGiftBtnVisible(false);
                } else {
                    this.gKb.setGiftBtnVisible(true);
                }
            }
            if (this.gKb != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isQuickChatUnabled()) {
                    this.gKb.setQuickImInputVisible(false);
                } else {
                    this.gKb.setQuickImInputVisible(true);
                }
            }
        }
    }

    public void bT(View view) {
        if (this.gKb != null) {
            this.gKb.bT(view);
        }
    }

    private void bXC() {
        cb cbVar;
        bw bwVar;
        if (this.gKe != null) {
            this.gKb.gKR.removeOnLayoutChangeListener(this.gKe);
        }
        bj bjVar = com.baidu.live.x.a.NN().bmW;
        if (bjVar != null && (cbVar = bjVar.aKT) != null && cbVar.aNb && (bwVar = bjVar.aKQ) != null && bwVar.aMc != null && !TextUtils.isEmpty(bwVar.aMc.webUrl)) {
            this.gKb.gKR.setVisibility(0);
            this.gKb.gKS.setVisibility(0);
            this.gKb.gKT.setVisibility(8);
            return;
        }
        this.gKb.gKR.setVisibility(8);
    }

    public void a(InterfaceC0634a interfaceC0634a) {
        if (this.gKb != null && this.gKb.gKR != null && this.gKb.gKR.getVisibility() == 0) {
            this.gKf = interfaceC0634a;
            this.gKe = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.bXD();
                }
            };
            this.gKb.gKR.addOnLayoutChangeListener(this.gKe);
            this.gKb.gKR.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gKf != null) {
                        int[] iArr = new int[2];
                        a.this.gKb.gKR.getLocationInWindow(iArr);
                        a.this.gKf.bK((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.gKb.gKR.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.gKb.gKR.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXD() {
        if (this.gKb != null && this.gKb.gKR != null && this.gKb.gKR.getVisibility() == 0) {
            this.gKb.gKR.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gKb != null && a.this.gKb.gKR != null && a.this.gKb.gKR.getVisibility() == 0 && a.this.gKf != null) {
                        int[] iArr = new int[2];
                        a.this.gKb.gKR.getLocationInWindow(iArr);
                        a.this.gKf.bL((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.gKb.gKR.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.gKb.gKR.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.gKb != null && this.gKb.gKR != null && this.gKb.gKR.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.gKb.gKS.getVisibility() == 0) {
                    this.gKb.gKS.setVisibility(8);
                }
                if (this.gKb.gKT.getVisibility() != 0) {
                    this.gKb.gKT.setVisibility(0);
                }
                this.gKb.gKT.setTimer(str, f);
                return;
            }
            if (this.gKb.gKS.getVisibility() != 0) {
                this.gKb.gKS.setVisibility(0);
            }
            if (this.gKb.gKT.getVisibility() == 0) {
                this.gKb.gKT.setVisibility(8);
            }
        }
    }

    public void bXE() {
        if (this.gKb != null && this.gKb.gKR != null && this.gKe != null) {
            this.gKb.gKR.removeOnLayoutChangeListener(this.gKe);
        }
        this.gKg = 0L;
        if (this.gcM != null && this.gKb != null && this.gcM.indexOfChild(this.gKb.getRootView()) > 0) {
            this.gcM.removeView(this.gKb.getRootView());
        }
        if (this.gKd != null && (this.gKd.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gKd.getParent()).removeView(this.gKd);
        }
        if (this.gKb != null && this.gKb.gHf != null && (this.gKb.gHf.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gKb.gHf.getParent()).removeView(this.gKb.gHf);
        }
    }

    public void setVisibility(int i) {
        if (this.gKb != null && this.gKb.getRootView() != null) {
            this.gKb.getRootView().setVisibility(i);
        }
        if (this.gKd != null) {
            this.gKd.setVisibility(i);
        }
    }

    public void a(o oVar, u uVar) {
        if (this.gKb != null) {
            if (uVar != null && uVar.aFb != null) {
                this.gKb.a(uVar.aFb.isNewUser, uVar.mLiveInfo, KD());
            } else {
                this.gKb.a(false, null, KD());
            }
            if (oVar == null || TextUtils.isEmpty(oVar.Fg()) || oVar.Ff() != 1) {
                this.gKb.gKu.setVisibility(8);
                return;
            }
            this.gKb.gKu.setVisibility(0);
            this.gKb.gKt.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.gKb.gKt.startLoad(oVar.Fg(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.gKb.gKL.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.gKb.gKu.setVisibility(8);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (oVar.Fe() != null) {
                    alaStaticItem.addParams("gifts_value", oVar.Fe().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, oVar.Fe().Eh());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, oVar.Fe().Ei());
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

    public String KD() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void bXF() {
        if (this.gKb != null) {
            this.gKb.setMsgLayoutWidth(false);
            this.gKb.gKU.setVisibility(8);
            this.gKb.gKV.setVisibility(8);
        }
    }

    public void bXG() {
        if (this.gKb != null) {
            this.gKb.setMsgLayoutWidth(true);
            this.gKb.gKU.setVisibility(0);
            this.gKb.gKV.setVisibility(0);
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.gKb != null) {
            if (i3 == 2) {
                bXG();
            } else if (i3 == 1) {
                bXF();
            }
            bXD();
        }
    }

    public void uV(int i) {
        if (this.gKb != null && this.gKb.gHf != null) {
            this.gKb.gHf.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.gKb != null && this.gKb.gKs != null) {
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
            if (this.gcM != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (a.this.gcM != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout = a.this.gKb.gKs;
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
                            a.this.gcM.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.gcM != null) {
                            a.this.gcM.removeView(inflate);
                        }
                    }
                }, i + j);
            }
        }
    }

    public ImageView getLandscapeBarrageImageView() {
        if (this.gKb != null) {
            return this.gKb.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.gKg = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gKh);
        MessageManager.getInstance().unRegisterListener(this.gKi);
        MessageManager.getInstance().unRegisterListener(this.gKj);
        MessageManager.getInstance().unRegisterListener(this.gKk);
        MessageManager.getInstance().unRegisterListener(this.gKl);
        MessageManager.getInstance().unRegisterListener(this.gKm);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TURN_TAB_LOC);
        this.gKf = null;
        if (this.gKb != null) {
            if (this.gKe != null) {
                this.gKb.gKR.removeOnLayoutChangeListener(this.gKe);
            }
            this.gKb.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXH() {
        if (this.gKb != null && this.gKb.gKS != null) {
            this.gKb.gKS.setScaleX(1.1f);
            this.gKb.gKS.setScaleY(1.1f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gKb.gKS, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gKb.gKS, View.SCALE_Y, 1.1f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gKb.gKS, View.SCALE_X, 1.0f, 1.1f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.gKb.gKS, View.SCALE_Y, 1.0f, 1.1f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(100L);
            animatorSet2.playTogether(ofFloat3, ofFloat4);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.gKb.gKS, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.gKb.gKS, View.SCALE_Y, 1.1f, 1.0f);
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
