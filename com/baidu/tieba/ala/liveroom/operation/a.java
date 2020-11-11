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
    private ViewGroup bJN;
    CustomMessageTask.CustomRunnable btX;
    private Handler handler;
    private AlaLiveBottomOperationView hqj;
    private com.baidu.tieba.ala.liveroom.data.a hqk;
    private FrameLayout hql;
    private View.OnLayoutChangeListener hqm;
    private InterfaceC0682a hqn;
    private long hqo;
    private boolean hqp;
    private CustomMessageListener hqq;
    private CustomMessageListener hqr;
    private CustomMessageListener hqs;
    private CustomMessageListener hqt;
    private CustomMessageListener hqu;
    private CustomMessageListener hqv;
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
        this.hqp = true;
        this.hqq = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
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
                    bn bnVar = com.baidu.live.aa.a.PQ().btT;
                    if (bnVar != null && (coVar = bnVar.aPy) != null) {
                        str = coVar.aSq;
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
        this.hqr = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.ala.liveroom.operation.a.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.ala.liveroom.w.b.chn().bom != null) {
                    str = com.baidu.tieba.ala.liveroom.w.b.chn().bom.aJm;
                    i = com.baidu.tieba.ala.liveroom.w.b.chn().bom.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, 1000L, i);
                }
            }
        };
        this.hqs = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hqj != null) {
                    a.this.hqj.a(false, null, a.this.MD());
                }
            }
        };
        this.hqt = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    w Hi = (a.this.hqk == null || a.this.hqk.hgD == null) ? null : a.this.hqk.hgD.Hi();
                    if (Hi == null || Hi.aJr == null) {
                        a.this.hqj.a(false, null, a.this.MD());
                    } else {
                        a.this.hqj.a(Hi.aJr.isNewUser, Hi.mLiveInfo, a.this.MD());
                    }
                }
            }
        };
        this.hqu = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.ala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hqj != null && a.this.hqj.hra != null) {
                    a.this.hqj.hra.performClick();
                }
            }
        };
        this.btX = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.hqj != null && a.this.hqj.hra != null) {
                        int[] iArr = new int[2];
                        a.this.hqj.hra.getLocationOnScreen(iArr);
                        jSONObject.putOpt("turn_tab_x", Integer.valueOf(iArr[0]));
                        jSONObject.putOpt("turn_tab_y", Integer.valueOf(iArr[1]));
                    }
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_TURN_TAB_LOC, jSONObject.toString());
                } catch (JSONException e) {
                    return null;
                }
            }
        };
        this.hqv = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.cgI();
            }
        };
        MessageManager.getInstance().registerListener(this.hqq);
        MessageManager.getInstance().registerListener(this.hqr);
        MessageManager.getInstance().registerListener(this.hqs);
        MessageManager.getInstance().registerListener(this.hqt);
        MessageManager.getInstance().registerListener(this.hqu);
        MessageManager.getInstance().registerListener(this.hqv);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_TURN_TAB_LOC, this.btX);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913260, (Class) null);
        if (runTask != null && runTask.getData() != null) {
            this.hqp = ((Boolean) runTask.getData()).booleanValue();
        }
    }

    public void mS(boolean z) {
        if (this.hqj != null) {
            this.hqj.mS(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.hqj != null) {
            this.hqj.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.hqk = aVar;
            this.bJN = viewGroup;
            if (this.hqj == null) {
                this.hqj = new AlaLiveBottomOperationView(getPageContext());
            }
            this.hqj.SO();
            this.hqj.registerListeners();
            this.hqj.setOnLiveViewOperationBtnClickListener(bVar);
            this.hqj.getRootView().setId(a.f.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.hqj.getRootView()) >= 0) {
                viewGroup.removeView(this.hqj.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.hqj.getRootView().setBackgroundResource(a.e.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.hqj.getRootView().setBackgroundResource(a.c.sdk_transparent);
            }
            viewGroup.addView(this.hqj.getRootView(), layoutParams);
            if (this.hql == null) {
                this.hql = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.hql.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.p(view, 8);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                cgC();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.hqj.hqG != null) {
                this.hqj.hqG.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.hqj != null && this.hqj.hnn != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds72));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds8);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12) + UtilHelper.getStatusBarHeight();
                    } else {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds25);
                    }
                    layoutParams2.gravity = 53;
                    if (this.hqj.hnn.getParent() != null && (this.hqj.hnn.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hqj.hnn.getParent()).removeView(this.hqj.hnn);
                    }
                    aVar.hgC.getLiveContainerView().addView(this.hqj.hnn, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.hql.getParent() != null && (this.hql.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hql.getParent()).removeView(this.hql);
                    }
                    aVar.hgC.getLiveContainerView().addView(this.hql, layoutParams3);
                }
            }
            if (this.hqj != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isGiftPanelUnabled()) {
                    this.hqj.setGiftBtnVisible(false);
                } else {
                    this.hqj.setGiftBtnVisible(true);
                }
            }
            if (this.hqj != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isQuickChatUnabled()) {
                    this.hqj.setQuickImInputVisible(false);
                } else {
                    this.hqj.setQuickImInputVisible(true);
                }
            }
        }
    }

    public void cf(View view) {
        if (this.hqj != null) {
            this.hqj.cf(view);
        }
    }

    public void cg(View view) {
        if (this.hqj != null) {
            this.hqj.cg(view);
        }
    }

    private void cgC() {
        ci ciVar;
        cd cdVar;
        if (this.hqm != null) {
            this.hqj.hra.removeOnLayoutChangeListener(this.hqm);
        }
        bn bnVar = com.baidu.live.aa.a.PQ().btT;
        if (bnVar != null && (ciVar = bnVar.aPA) != null && ciVar.aRS && (cdVar = bnVar.aPx) != null && cdVar.aQT != null && !TextUtils.isEmpty(cdVar.aQT.webUrl)) {
            this.hqj.hra.setVisibility(0);
            this.hqj.hrb.setVisibility(0);
            this.hqj.hrc.setVisibility(8);
            return;
        }
        this.hqj.hra.setVisibility(8);
    }

    public void a(InterfaceC0682a interfaceC0682a) {
        if (this.hqj != null && this.hqj.hra != null && this.hqj.hra.getVisibility() == 0) {
            this.hqn = interfaceC0682a;
            this.hqm = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.cgD();
                }
            };
            this.hqj.hra.addOnLayoutChangeListener(this.hqm);
            this.hqj.hra.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hqn != null) {
                        int[] iArr = new int[2];
                        a.this.hqj.hra.getLocationInWindow(iArr);
                        a.this.hqn.bO((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.hqj.hra.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20) + a.this.hqj.hra.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgD() {
        if (this.hqj != null && this.hqj.hra != null && this.hqj.hra.getVisibility() == 0) {
            this.hqj.hra.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hqj != null && a.this.hqj.hra != null && a.this.hqj.hra.getVisibility() == 0 && a.this.hqn != null) {
                        int[] iArr = new int[2];
                        a.this.hqj.hra.getLocationInWindow(iArr);
                        a.this.hqn.bP((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.hqj.hra.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20) + a.this.hqj.hra.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.hqj != null && this.hqj.hra != null && this.hqj.hra.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.hqj.hrb.getVisibility() == 0) {
                    this.hqj.hrb.setVisibility(8);
                }
                if (this.hqj.hrc.getVisibility() != 0) {
                    this.hqj.hrc.setVisibility(0);
                }
                this.hqj.hrc.setTimer(str, f);
                return;
            }
            if (this.hqj.hrb.getVisibility() != 0) {
                this.hqj.hrb.setVisibility(0);
            }
            if (this.hqj.hrc.getVisibility() == 0) {
                this.hqj.hrc.setVisibility(8);
            }
        }
    }

    public void cgE() {
        if (this.hqj != null && this.hqj.hra != null && this.hqm != null) {
            this.hqj.hra.removeOnLayoutChangeListener(this.hqm);
        }
        this.hqo = 0L;
        if (this.bJN != null && this.hqj != null && this.bJN.indexOfChild(this.hqj.getRootView()) > 0) {
            this.bJN.removeView(this.hqj.getRootView());
        }
        if (this.hql != null && (this.hql.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hql.getParent()).removeView(this.hql);
        }
        if (this.hqj != null && this.hqj.hnn != null && (this.hqj.hnn.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hqj.hnn.getParent()).removeView(this.hqj.hnn);
        }
        if (this.hqj != null) {
            this.hqj.bZo();
        }
    }

    public void setVisibility(int i) {
        if (this.hqj != null && this.hqj.getRootView() != null) {
            this.hqj.getRootView().setVisibility(i);
        }
        if (this.hql != null) {
            this.hql.setVisibility(i);
        }
    }

    public void a(n nVar, w wVar) {
        if (this.hqj != null) {
            if (wVar != null && wVar.aJr != null) {
                this.hqj.a(wVar.aJr.isNewUser, wVar.mLiveInfo, MD());
            } else {
                this.hqj.a(false, null, MD());
            }
            if (nVar == null || TextUtils.isEmpty(nVar.GS()) || nVar.GR() != 1) {
                this.hqj.hqE.setVisibility(8);
                return;
            }
            this.hqj.hqE.setVisibility(0);
            this.hqj.hqD.setDefaultBgResource(a.e.sdk_shape_transparent);
            this.hqj.hqD.startLoad(nVar.GS(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.hqj.hqU.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.hqj.hqE.setVisibility(8);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (nVar.GQ() != null) {
                    alaStaticItem.addParams("gifts_value", nVar.GQ().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, nVar.GQ().FT());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, nVar.GQ().FU());
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

    public String MD() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void cgF() {
        if (this.hqj != null) {
            this.hqj.setMsgLayoutWidth(false);
            this.hqj.hrd.setVisibility(8);
            this.hqj.hre.setVisibility(8);
            this.hqj.hqG.setVisibility(0);
        }
    }

    public void cgG() {
        if (this.hqj != null) {
            this.hqj.setMsgLayoutWidth(true);
            this.hqj.hrd.setVisibility(0);
            this.hqj.hre.setVisibility(0);
            if (this.hqp) {
                this.hqj.hqG.setVisibility(0);
            } else {
                this.hqj.hqG.setVisibility(8);
            }
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.hqj != null) {
            if (i3 == 2) {
                cgG();
            } else if (i3 == 1) {
                cgF();
            }
            cgD();
            cgH();
        }
    }

    private void cgH() {
        if (this.hqj != null) {
            this.hqj.biM();
        }
    }

    public void wh(int i) {
        if (this.hqj != null && this.hqj.hnn != null) {
            this.hqj.hnn.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.hqj != null && this.hqj.hqC != null) {
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
            if (this.bJN != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (a.this.bJN != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout = a.this.hqj.hqC;
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
                            a.this.bJN.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.bJN != null) {
                            a.this.bJN.removeView(inflate);
                        }
                    }
                }, i + j);
            }
        }
    }

    public ImageView getLandscapeBarrageImageView() {
        if (this.hqj != null) {
            return this.hqj.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.hqo = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.hqq);
        MessageManager.getInstance().unRegisterListener(this.hqr);
        MessageManager.getInstance().unRegisterListener(this.hqs);
        MessageManager.getInstance().unRegisterListener(this.hqt);
        MessageManager.getInstance().unRegisterListener(this.hqu);
        MessageManager.getInstance().unRegisterListener(this.hqv);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TURN_TAB_LOC);
        this.hqn = null;
        if (this.hqj != null) {
            if (this.hqm != null) {
                this.hqj.hra.removeOnLayoutChangeListener(this.hqm);
            }
            this.hqj.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgI() {
        if (this.hqj != null && this.hqj.hrb != null) {
            this.hqj.hrb.setScaleX(1.1f);
            this.hqj.hrb.setScaleY(1.1f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hqj.hrb, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hqj.hrb, View.SCALE_Y, 1.1f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hqj.hrb, View.SCALE_X, 1.0f, 1.1f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hqj.hrb, View.SCALE_Y, 1.0f, 1.1f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(100L);
            animatorSet2.playTogether(ofFloat3, ofFloat4);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hqj.hrb, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.hqj.hrb, View.SCALE_Y, 1.1f, 1.0f);
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
