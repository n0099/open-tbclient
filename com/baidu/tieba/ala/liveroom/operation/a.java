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
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.bb;
import com.baidu.live.data.bl;
import com.baidu.live.data.bq;
import com.baidu.live.data.bu;
import com.baidu.live.data.q;
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
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    CustomMessageTask.CustomRunnable bdZ;
    private ViewGroup fIb;
    private FrameLayout goA;
    private View.OnLayoutChangeListener goB;
    private InterfaceC0576a goC;
    private long goD;
    private CustomMessageListener goE;
    private CustomMessageListener goF;
    private CustomMessageListener goG;
    private CustomMessageListener goH;
    private CustomMessageListener goI;
    private CustomMessageListener goJ;
    private AlaLiveBottomOperationView goy;
    private com.baidu.tieba.ala.liveroom.data.a goz;
    private Handler handler;
    private String otherParams;

    /* renamed from: com.baidu.tieba.ala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0576a {
        void bA(int i, int i2);

        void bz(int i, int i2);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.goE = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                bu buVar;
                String str;
                long j;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                    j = 1000;
                } else {
                    bb bbVar = com.baidu.live.v.a.Hm().bdV;
                    if (bbVar != null && (buVar = bbVar.aCU) != null) {
                        str = buVar.aEY;
                        j = 3000;
                    } else {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, j, 3000);
                }
            }
        };
        this.goF = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.ala.liveroom.operation.a.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.ala.liveroom.u.a.bJt().aZA != null) {
                    str = com.baidu.tieba.ala.liveroom.u.a.bJt().aZA.ayj;
                    i = com.baidu.tieba.ala.liveroom.u.a.bJt().aZA.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, 1000L, i);
                }
            }
        };
        this.goG = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.goy != null) {
                    a.this.goy.a(false, null, a.this.Ep());
                }
            }
        };
        this.goH = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    q FU = (a.this.goz == null || a.this.goz.gfS == null) ? null : a.this.goz.gfS.FU();
                    if (FU == null || FU.axI == null) {
                        a.this.goy.a(false, null, a.this.Ep());
                    } else {
                        a.this.goy.a(FU.axI.isNewUser, FU.mLiveInfo, a.this.Ep());
                    }
                }
            }
        };
        this.goI = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.ala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.goy != null && a.this.goy.gpp != null) {
                    a.this.goy.gpp.performClick();
                }
            }
        };
        this.bdZ = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.goy != null && a.this.goy.gpp != null) {
                        int[] iArr = new int[2];
                        a.this.goy.gpp.getLocationOnScreen(iArr);
                        jSONObject.putOpt("turn_tab_x", Integer.valueOf(iArr[0]));
                        jSONObject.putOpt("turn_tab_y", Integer.valueOf(iArr[1]));
                    }
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_TURN_TAB_LOC, jSONObject.toString());
                } catch (JSONException e) {
                    return null;
                }
            }
        };
        this.goJ = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.bIO();
            }
        };
        MessageManager.getInstance().registerListener(this.goE);
        MessageManager.getInstance().registerListener(this.goF);
        MessageManager.getInstance().registerListener(this.goG);
        MessageManager.getInstance().registerListener(this.goH);
        MessageManager.getInstance().registerListener(this.goI);
        MessageManager.getInstance().registerListener(this.goJ);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_TURN_TAB_LOC, this.bdZ);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void kJ(boolean z) {
        if (this.goy != null) {
            this.goy.kJ(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.goy != null) {
            this.goy.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.goz = aVar;
            this.fIb = viewGroup;
            if (this.goy == null) {
                this.goy = new AlaLiveBottomOperationView(getPageContext());
            }
            this.goy.registerListeners();
            this.goy.setOnLiveViewOperationBtnClickListener(bVar);
            this.goy.getRootView().setId(a.g.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.goy.getRootView()) >= 0) {
                viewGroup.removeView(this.goy.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.goy.getRootView().setBackgroundResource(a.f.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.goy.getRootView().setBackgroundResource(a.d.sdk_transparent);
            }
            viewGroup.addView(this.goy.getRootView(), layoutParams);
            if (this.goA == null) {
                this.goA = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.goA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.l(view, 8);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                bIJ();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.goy.goT != null) {
                this.goy.goT.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.goy != null && this.goy.gpi != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds68));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds22);
                    layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds28);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds10) + UtilHelper.getStatusBarHeight();
                    }
                    layoutParams2.gravity = 53;
                    this.goy.gpi.setVisibility(8);
                    if (this.goy.gpi.getParent() != null && (this.goy.gpi.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.goy.gpi.getParent()).removeView(this.goy.gpi);
                    }
                    aVar.gfR.getLiveContainerView().addView(this.goy.gpi, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.goA.getParent() != null && (this.goA.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.goA.getParent()).removeView(this.goA);
                    }
                    aVar.gfR.getLiveContainerView().addView(this.goA, layoutParams3);
                }
            }
            if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.mGiftPanelInvalid) {
                this.goy.setGiftBtnVisible(false);
            } else {
                this.goy.setGiftBtnVisible(true);
            }
            if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.mQuickChatInvalid) {
                this.goy.setQuickImInputVisible(false);
            } else {
                this.goy.setQuickImInputVisible(true);
            }
        }
    }

    public void bG(View view) {
        if (this.goy != null) {
            this.goy.bG(view);
        }
    }

    private void bIJ() {
        bq bqVar;
        bl blVar;
        if (this.goB != null) {
            this.goy.gpp.removeOnLayoutChangeListener(this.goB);
        }
        bb bbVar = com.baidu.live.v.a.Hm().bdV;
        if (bbVar != null && (bqVar = bbVar.aCW) != null && bqVar.aEN && (blVar = bbVar.aCT) != null && blVar.aDR != null && !TextUtils.isEmpty(blVar.aDR.webUrl)) {
            this.goy.gpp.setVisibility(0);
            this.goy.gpq.setVisibility(0);
            this.goy.gpr.setVisibility(8);
            return;
        }
        this.goy.gpp.setVisibility(8);
    }

    public void a(InterfaceC0576a interfaceC0576a) {
        if (this.goy != null && this.goy.gpp != null && this.goy.gpp.getVisibility() == 0) {
            this.goC = interfaceC0576a;
            this.goB = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.bIK();
                }
            };
            this.goy.gpp.addOnLayoutChangeListener(this.goB);
            this.goy.gpp.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.goC != null) {
                        int[] iArr = new int[2];
                        a.this.goy.gpp.getLocationInWindow(iArr);
                        a.this.goC.bz((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.goy.gpp.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.goy.gpp.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIK() {
        if (this.goy != null && this.goy.gpp != null && this.goy.gpp.getVisibility() == 0) {
            this.goy.gpp.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.goy != null && a.this.goy.gpp != null && a.this.goy.gpp.getVisibility() == 0 && a.this.goC != null) {
                        int[] iArr = new int[2];
                        a.this.goy.gpp.getLocationInWindow(iArr);
                        a.this.goC.bA((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.goy.gpp.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.goy.gpp.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.goy != null && this.goy.gpp != null && this.goy.gpp.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.goy.gpq.getVisibility() == 0) {
                    this.goy.gpq.setVisibility(8);
                }
                if (this.goy.gpr.getVisibility() != 0) {
                    this.goy.gpr.setVisibility(0);
                }
                this.goy.gpr.setTimer(str, f);
                return;
            }
            if (this.goy.gpq.getVisibility() != 0) {
                this.goy.gpq.setVisibility(0);
            }
            if (this.goy.gpr.getVisibility() == 0) {
                this.goy.gpr.setVisibility(8);
            }
        }
    }

    public void bIL() {
        if (this.goy != null && this.goy.gpp != null && this.goB != null) {
            this.goy.gpp.removeOnLayoutChangeListener(this.goB);
        }
        this.goD = 0L;
        if (this.fIb != null && this.goy != null && this.fIb.indexOfChild(this.goy.getRootView()) > 0) {
            this.fIb.removeView(this.goy.getRootView());
        }
        if (this.goA != null && (this.goA.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.goA.getParent()).removeView(this.goA);
        }
        if (this.goy != null && this.goy.gpi != null && (this.goy.gpi.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.goy.gpi.getParent()).removeView(this.goy.gpi);
        }
    }

    public void setVisibility(int i) {
        if (this.goy != null && this.goy.getRootView() != null) {
            this.goy.getRootView().setVisibility(i);
        }
        if (this.goA != null) {
            this.goA.setVisibility(i);
        }
    }

    public void a(o oVar, q qVar) {
        if (this.goy != null) {
            if (qVar != null && qVar.axI != null) {
                this.goy.a(qVar.axI.isNewUser, qVar.mLiveInfo, Ep());
            } else {
                this.goy.a(false, null, Ep());
            }
            if (oVar == null || TextUtils.isEmpty(oVar.yK()) || oVar.yJ() != 1) {
                this.goy.goR.setVisibility(8);
                return;
            }
            this.goy.goR.setVisibility(0);
            this.goy.goQ.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.goy.goQ.startLoad(oVar.yK(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.goy.gpj.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.goy.goR.setVisibility(8);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (oVar.yI() != null) {
                    alaStaticItem.addParams("gifts_value", oVar.yI().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, oVar.yI().xM());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, oVar.yI().xN());
                }
                if (qVar != null && qVar.mLiveInfo != null) {
                    alaStaticItem.addParams("feed_id", qVar.mLiveInfo.feed_id);
                    alaStaticItem.addParams("room_id", qVar.mLiveInfo.room_id);
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    public String Ep() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void bIM() {
        if (this.goy != null) {
            this.goy.setMsgLayoutWidth(false);
            this.goy.gps.setVisibility(8);
            this.goy.gpt.setVisibility(8);
        }
    }

    public void bIN() {
        if (this.goy != null) {
            this.goy.setMsgLayoutWidth(true);
            this.goy.gps.setVisibility(0);
            this.goy.gpt.setVisibility(0);
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.goy != null) {
            if (i3 == 2) {
                bIN();
            } else if (i3 == 1) {
                bIM();
            }
            bIK();
        }
    }

    public void rV(int i) {
        if (this.goy != null && this.goy.gpi != null) {
            this.goy.gpi.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.goy != null && this.goy.goP != null) {
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
            if (this.fIb != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (a.this.fIb != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout = a.this.goy.goP;
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
                            a.this.fIb.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.fIb != null) {
                            a.this.fIb.removeView(inflate);
                        }
                    }
                }, i + j);
            }
        }
    }

    public ImageView getLandscapeBarrageImageView() {
        if (this.goy != null) {
            return this.goy.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.goD = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.goE);
        MessageManager.getInstance().unRegisterListener(this.goF);
        MessageManager.getInstance().unRegisterListener(this.goG);
        MessageManager.getInstance().unRegisterListener(this.goH);
        MessageManager.getInstance().unRegisterListener(this.goI);
        MessageManager.getInstance().unRegisterListener(this.goJ);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TURN_TAB_LOC);
        this.goC = null;
        if (this.goy != null) {
            if (this.goB != null) {
                this.goy.gpp.removeOnLayoutChangeListener(this.goB);
            }
            this.goy.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIO() {
        if (this.goy != null && this.goy.gpq != null) {
            this.goy.gpq.setScaleX(1.1f);
            this.goy.gpq.setScaleY(1.1f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.goy.gpq, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.goy.gpq, View.SCALE_Y, 1.1f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.goy.gpq, View.SCALE_X, 1.0f, 1.1f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.goy.gpq, View.SCALE_Y, 1.0f, 1.1f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(100L);
            animatorSet2.playTogether(ofFloat3, ofFloat4);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.goy.gpq, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.goy.gpq, View.SCALE_Y, 1.1f, 1.0f);
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
