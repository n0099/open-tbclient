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
import com.baidu.live.data.bn;
import com.baidu.live.data.cd;
import com.baidu.live.data.ci;
import com.baidu.live.data.co;
import com.baidu.live.data.w;
import com.baidu.live.gift.n;
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
    private ViewGroup bIc;
    CustomMessageTask.CustomRunnable bsl;
    private Handler handler;
    private AlaLiveBottomOperationView hpQ;
    private com.baidu.tieba.ala.liveroom.data.a hpR;
    private FrameLayout hpS;
    private View.OnLayoutChangeListener hpT;
    private InterfaceC0682a hpU;
    private long hpV;
    private boolean hpW;
    private CustomMessageListener hpX;
    private CustomMessageListener hpY;
    private CustomMessageListener hpZ;
    private CustomMessageListener hqa;
    private CustomMessageListener hqb;
    private CustomMessageListener hqc;
    private String otherParams;

    /* renamed from: com.baidu.tieba.ala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0682a {
        void bO(int i, int i2);

        void bP(int i, int i2);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.hpW = true;
        this.hpX = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                co coVar;
                String str;
                long j;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                    j = 1000;
                } else {
                    bn bnVar = com.baidu.live.aa.a.Ph().bsh;
                    if (bnVar != null && (coVar = bnVar.aNN) != null) {
                        str = coVar.aQF;
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
        this.hpY = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.ala.liveroom.operation.a.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.ala.liveroom.w.b.cgG().bmB != null) {
                    str = com.baidu.tieba.ala.liveroom.w.b.cgG().bmB.aHB;
                    i = com.baidu.tieba.ala.liveroom.w.b.cgG().bmB.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, 1000L, i);
                }
            }
        };
        this.hpZ = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hpQ != null) {
                    a.this.hpQ.a(false, null, a.this.LU());
                }
            }
        };
        this.hqa = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    w Gz = (a.this.hpR == null || a.this.hpR.hgk == null) ? null : a.this.hpR.hgk.Gz();
                    if (Gz == null || Gz.aHG == null) {
                        a.this.hpQ.a(false, null, a.this.LU());
                    } else {
                        a.this.hpQ.a(Gz.aHG.isNewUser, Gz.mLiveInfo, a.this.LU());
                    }
                }
            }
        };
        this.hqb = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.ala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hpQ != null && a.this.hpQ.hqH != null) {
                    a.this.hpQ.hqH.performClick();
                }
            }
        };
        this.bsl = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.hpQ != null && a.this.hpQ.hqH != null) {
                        int[] iArr = new int[2];
                        a.this.hpQ.hqH.getLocationOnScreen(iArr);
                        jSONObject.putOpt("turn_tab_x", Integer.valueOf(iArr[0]));
                        jSONObject.putOpt("turn_tab_y", Integer.valueOf(iArr[1]));
                    }
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_TURN_TAB_LOC, jSONObject.toString());
                } catch (JSONException e) {
                    return null;
                }
            }
        };
        this.hqc = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.cgb();
            }
        };
        MessageManager.getInstance().registerListener(this.hpX);
        MessageManager.getInstance().registerListener(this.hpY);
        MessageManager.getInstance().registerListener(this.hpZ);
        MessageManager.getInstance().registerListener(this.hqa);
        MessageManager.getInstance().registerListener(this.hqb);
        MessageManager.getInstance().registerListener(this.hqc);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_TURN_TAB_LOC, this.bsl);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913260, (Class) null);
        if (runTask != null && runTask.getData() != null) {
            this.hpW = ((Boolean) runTask.getData()).booleanValue();
        }
    }

    public void mT(boolean z) {
        if (this.hpQ != null) {
            this.hpQ.mT(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.hpQ != null) {
            this.hpQ.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.hpR = aVar;
            this.bIc = viewGroup;
            if (this.hpQ == null) {
                this.hpQ = new AlaLiveBottomOperationView(getPageContext());
            }
            this.hpQ.Sf();
            this.hpQ.registerListeners();
            this.hpQ.setOnLiveViewOperationBtnClickListener(bVar);
            this.hpQ.getRootView().setId(a.f.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.hpQ.getRootView()) >= 0) {
                viewGroup.removeView(this.hpQ.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.hpQ.getRootView().setBackgroundResource(a.e.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.hpQ.getRootView().setBackgroundResource(a.c.sdk_transparent);
            }
            viewGroup.addView(this.hpQ.getRootView(), layoutParams);
            if (this.hpS == null) {
                this.hpS = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.hpS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.s(view, 8);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                cfV();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.hpQ.hqn != null) {
                this.hpQ.hqn.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.hpQ != null && this.hpQ.hmU != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds72));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds8);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12) + UtilHelper.getStatusBarHeight();
                    } else {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds25);
                    }
                    layoutParams2.gravity = 53;
                    if (this.hpQ.hmU.getParent() != null && (this.hpQ.hmU.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hpQ.hmU.getParent()).removeView(this.hpQ.hmU);
                    }
                    aVar.hgj.getLiveContainerView().addView(this.hpQ.hmU, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.hpS.getParent() != null && (this.hpS.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hpS.getParent()).removeView(this.hpS);
                    }
                    aVar.hgj.getLiveContainerView().addView(this.hpS, layoutParams3);
                }
            }
            if (this.hpQ != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isGiftPanelUnabled()) {
                    this.hpQ.setGiftBtnVisible(false);
                } else {
                    this.hpQ.setGiftBtnVisible(true);
                }
            }
            if (this.hpQ != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isQuickChatUnabled()) {
                    this.hpQ.setQuickImInputVisible(false);
                } else {
                    this.hpQ.setQuickImInputVisible(true);
                }
            }
        }
    }

    public void ci(View view) {
        if (this.hpQ != null) {
            this.hpQ.ci(view);
        }
    }

    public void cj(View view) {
        if (this.hpQ != null) {
            this.hpQ.cj(view);
        }
    }

    private void cfV() {
        ci ciVar;
        cd cdVar;
        if (this.hpT != null) {
            this.hpQ.hqH.removeOnLayoutChangeListener(this.hpT);
        }
        bn bnVar = com.baidu.live.aa.a.Ph().bsh;
        if (bnVar != null && (ciVar = bnVar.aNP) != null && ciVar.aQh && (cdVar = bnVar.aNM) != null && cdVar.aPi != null && !TextUtils.isEmpty(cdVar.aPi.webUrl)) {
            this.hpQ.hqH.setVisibility(0);
            this.hpQ.hqI.setVisibility(0);
            this.hpQ.hqJ.setVisibility(8);
            return;
        }
        this.hpQ.hqH.setVisibility(8);
    }

    public void a(InterfaceC0682a interfaceC0682a) {
        if (this.hpQ != null && this.hpQ.hqH != null && this.hpQ.hqH.getVisibility() == 0) {
            this.hpU = interfaceC0682a;
            this.hpT = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.cfW();
                }
            };
            this.hpQ.hqH.addOnLayoutChangeListener(this.hpT);
            this.hpQ.hqH.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hpU != null) {
                        int[] iArr = new int[2];
                        a.this.hpQ.hqH.getLocationInWindow(iArr);
                        a.this.hpU.bO((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.hpQ.hqH.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20) + a.this.hpQ.hqH.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfW() {
        if (this.hpQ != null && this.hpQ.hqH != null && this.hpQ.hqH.getVisibility() == 0) {
            this.hpQ.hqH.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hpQ != null && a.this.hpQ.hqH != null && a.this.hpQ.hqH.getVisibility() == 0 && a.this.hpU != null) {
                        int[] iArr = new int[2];
                        a.this.hpQ.hqH.getLocationInWindow(iArr);
                        a.this.hpU.bP((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.hpQ.hqH.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20) + a.this.hpQ.hqH.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.hpQ != null && this.hpQ.hqH != null && this.hpQ.hqH.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.hpQ.hqI.getVisibility() == 0) {
                    this.hpQ.hqI.setVisibility(8);
                }
                if (this.hpQ.hqJ.getVisibility() != 0) {
                    this.hpQ.hqJ.setVisibility(0);
                }
                this.hpQ.hqJ.setTimer(str, f);
                return;
            }
            if (this.hpQ.hqI.getVisibility() != 0) {
                this.hpQ.hqI.setVisibility(0);
            }
            if (this.hpQ.hqJ.getVisibility() == 0) {
                this.hpQ.hqJ.setVisibility(8);
            }
        }
    }

    public void cfX() {
        if (this.hpQ != null && this.hpQ.hqH != null && this.hpT != null) {
            this.hpQ.hqH.removeOnLayoutChangeListener(this.hpT);
        }
        this.hpV = 0L;
        if (this.bIc != null && this.hpQ != null && this.bIc.indexOfChild(this.hpQ.getRootView()) > 0) {
            this.bIc.removeView(this.hpQ.getRootView());
        }
        if (this.hpS != null && (this.hpS.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hpS.getParent()).removeView(this.hpS);
        }
        if (this.hpQ != null && this.hpQ.hmU != null && (this.hpQ.hmU.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hpQ.hmU.getParent()).removeView(this.hpQ.hmU);
        }
        if (this.hpQ != null) {
            this.hpQ.bYH();
        }
    }

    public void setVisibility(int i) {
        if (this.hpQ != null && this.hpQ.getRootView() != null) {
            this.hpQ.getRootView().setVisibility(i);
        }
        if (this.hpS != null) {
            this.hpS.setVisibility(i);
        }
    }

    public void a(n nVar, w wVar) {
        if (this.hpQ != null) {
            if (wVar != null && wVar.aHG != null) {
                this.hpQ.a(wVar.aHG.isNewUser, wVar.mLiveInfo, LU());
            } else {
                this.hpQ.a(false, null, LU());
            }
            if (nVar == null || TextUtils.isEmpty(nVar.Gj()) || nVar.Gi() != 1) {
                this.hpQ.hql.setVisibility(8);
                return;
            }
            this.hpQ.hql.setVisibility(0);
            this.hpQ.hqk.setDefaultBgResource(a.e.sdk_shape_transparent);
            this.hpQ.hqk.startLoad(nVar.Gj(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.hpQ.hqB.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.hpQ.hql.setVisibility(8);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (nVar.Gh() != null) {
                    alaStaticItem.addParams("gifts_value", nVar.Gh().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, nVar.Gh().Fk());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, nVar.Gh().Fl());
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

    public String LU() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void cfY() {
        if (this.hpQ != null) {
            this.hpQ.setMsgLayoutWidth(false);
            this.hpQ.hqK.setVisibility(8);
            this.hpQ.hqL.setVisibility(8);
            this.hpQ.hqn.setVisibility(0);
        }
    }

    public void cfZ() {
        if (this.hpQ != null) {
            this.hpQ.setMsgLayoutWidth(true);
            this.hpQ.hqK.setVisibility(0);
            this.hpQ.hqL.setVisibility(0);
            if (this.hpW) {
                this.hpQ.hqn.setVisibility(0);
            } else {
                this.hpQ.hqn.setVisibility(8);
            }
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.hpQ != null) {
            if (i3 == 2) {
                cfZ();
            } else if (i3 == 1) {
                cfY();
            }
            cfW();
            cga();
        }
    }

    private void cga() {
        if (this.hpQ != null) {
            this.hpQ.big();
        }
    }

    public void wF(int i) {
        if (this.hpQ != null && this.hpQ.hmU != null) {
            this.hpQ.hmU.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.hpQ != null && this.hpQ.hqj != null) {
            final View inflate = getPageContext().getPageActivity().getLayoutInflater().inflate(a.g.toast_gift_guide, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(a.f.textView);
            ImageView imageView = (ImageView) inflate.findViewById(a.f.arrow_imageView);
            textView.setText(str);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                textView.setBackgroundResource(a.e.bg_guide_gift_toast_hk);
                imageView.setImageResource(a.e.bg_guide_gift_toast_arrow_hk);
            } else {
                textView.setBackgroundResource(a.e.bg_guide_gift_toast_qm);
                imageView.setImageResource(a.e.bg_guide_gift_toast_arrow_qm);
            }
            if (this.bIc != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (a.this.bIc != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout = a.this.hpQ.hqj;
                            int[] iArr = new int[2];
                            frameLayout.getLocationOnScreen(iArr);
                            int dimensionPixelSize = ((BdUtilHelper.getScreenSize(pageActivity).widthPixels - iArr[0]) - pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds44)) - (frameLayout.getWidth() / 2);
                            inflate.measure(0, 0);
                            int measuredHeight = (iArr[1] - inflate.getMeasuredHeight()) - frameLayout.getHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(11);
                            layoutParams.rightMargin = dimensionPixelSize;
                            layoutParams.topMargin = measuredHeight;
                            a.this.bIc.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.bIc != null) {
                            a.this.bIc.removeView(inflate);
                        }
                    }
                }, i + j);
            }
        }
    }

    public ImageView getLandscapeBarrageImageView() {
        if (this.hpQ != null) {
            return this.hpQ.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.hpV = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.hpX);
        MessageManager.getInstance().unRegisterListener(this.hpY);
        MessageManager.getInstance().unRegisterListener(this.hpZ);
        MessageManager.getInstance().unRegisterListener(this.hqa);
        MessageManager.getInstance().unRegisterListener(this.hqb);
        MessageManager.getInstance().unRegisterListener(this.hqc);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TURN_TAB_LOC);
        this.hpU = null;
        if (this.hpQ != null) {
            if (this.hpT != null) {
                this.hpQ.hqH.removeOnLayoutChangeListener(this.hpT);
            }
            this.hpQ.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgb() {
        if (this.hpQ != null && this.hpQ.hqI != null) {
            this.hpQ.hqI.setScaleX(1.1f);
            this.hpQ.hqI.setScaleY(1.1f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hpQ.hqI, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hpQ.hqI, View.SCALE_Y, 1.1f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hpQ.hqI, View.SCALE_X, 1.0f, 1.1f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hpQ.hqI, View.SCALE_Y, 1.0f, 1.1f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(100L);
            animatorSet2.playTogether(ofFloat3, ofFloat4);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hpQ.hqI, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.hpQ.hqI, View.SCALE_Y, 1.1f, 1.0f);
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
