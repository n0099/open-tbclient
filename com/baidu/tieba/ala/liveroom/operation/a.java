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
import com.baidu.live.an.c;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.data.bv;
import com.baidu.live.data.co;
import com.baidu.live.data.cy;
import com.baidu.live.gift.o;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    CustomMessageTask.CustomRunnable bCw;
    private ViewGroup bSB;
    private AlaLiveBottomOperationView hNj;
    private com.baidu.tieba.ala.liveroom.data.a hNk;
    private FrameLayout hNl;
    private View.OnLayoutChangeListener hNm;
    private InterfaceC0677a hNn;
    private long hNo;
    private boolean hNp;
    private CustomMessageListener hNq;
    private CustomMessageListener hNr;
    private CustomMessageListener hNs;
    private CustomMessageListener hNt;
    private CustomMessageListener hNu;
    private CustomMessageListener hNv;
    private Handler handler;
    private String otherParams;

    /* renamed from: com.baidu.tieba.ala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0677a {
        void bP(int i, int i2);

        void bQ(int i, int i2);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.hNp = true;
        this.hNq = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                cy cyVar;
                String str;
                long j = 1000;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                } else {
                    bv bvVar = com.baidu.live.ae.a.Qm().bCs;
                    if (bvVar != null && (cyVar = bvVar.aRn) != null) {
                        str = cyVar.aUv;
                        j = 3000;
                    } else {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.d(str, j, 3000);
                }
            }
        };
        this.hNr = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.ala.liveroom.operation.a.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.ala.liveroom.u.b.ckK().bwG != null) {
                    str = com.baidu.tieba.ala.liveroom.u.b.ckK().bwG.aJU;
                    i = com.baidu.tieba.ala.liveroom.u.b.ckK().bwG.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.d(str, 1000L, i);
                }
            }
        };
        this.hNs = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hNj != null) {
                    a.this.hNj.a(false, null, a.this.Lr());
                }
            }
        };
        this.hNt = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    ab Fp = (a.this.hNk == null || a.this.hNk.hDq == null) ? null : a.this.hNk.hDq.Fp();
                    if (Fp == null || Fp.aJZ == null) {
                        a.this.hNj.a(false, null, a.this.Lr());
                    } else {
                        a.this.hNj.a(Fp.aJZ.isNewUser, Fp.mLiveInfo, a.this.Lr());
                    }
                }
            }
        };
        this.hNu = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hNj != null && a.this.hNj.hOc != null) {
                    a.this.hNj.hOc.performClick();
                }
            }
        };
        this.bCw = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.hNj != null && a.this.hNj.hOc != null) {
                        int[] iArr = new int[2];
                        a.this.hNj.hOc.getLocationOnScreen(iArr);
                        jSONObject.putOpt("turn_tab_x", Integer.valueOf(iArr[0]));
                        jSONObject.putOpt("turn_tab_y", Integer.valueOf(iArr[1]));
                    }
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_TURN_TAB_LOC, jSONObject.toString());
                } catch (JSONException e) {
                    return null;
                }
            }
        };
        this.hNv = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.ckg();
            }
        };
        MessageManager.getInstance().registerListener(this.hNq);
        MessageManager.getInstance().registerListener(this.hNr);
        MessageManager.getInstance().registerListener(this.hNs);
        MessageManager.getInstance().registerListener(this.hNt);
        MessageManager.getInstance().registerListener(this.hNu);
        MessageManager.getInstance().registerListener(this.hNv);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_TURN_TAB_LOC, this.bCw);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913260, (Class) null);
        if (runTask != null && runTask.getData() != null) {
            this.hNp = ((Boolean) runTask.getData()).booleanValue();
        }
    }

    public void nV(boolean z) {
        if (this.hNj != null) {
            this.hNj.nV(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.hNj != null) {
            this.hNj.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.hNk = aVar;
            this.bSB = viewGroup;
            if (this.hNj == null) {
                this.hNj = new AlaLiveBottomOperationView(getPageContext());
            }
            this.hNj.Tz();
            this.hNj.registerListeners();
            this.hNj.setOnLiveViewOperationBtnClickListener(bVar);
            this.hNj.getRootView().setId(a.f.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.hNj.getRootView()) >= 0) {
                viewGroup.removeView(this.hNj.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.hNj.getRootView().setBackgroundResource(a.e.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.hNj.getRootView().setBackgroundResource(a.c.sdk_transparent);
            }
            viewGroup.addView(this.hNj.getRootView(), layoutParams);
            if (this.hNl == null) {
                this.hNl = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.hNl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.v(view, 8);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                cka();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.hNj.hNG != null) {
                this.hNj.hNG.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.hNj != null && this.hNj.hKb != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds72));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds8);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12) + UtilHelper.getStatusBarHeight();
                    } else {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds25);
                    }
                    layoutParams2.gravity = 53;
                    if (this.hNj.hKb.getParent() != null && (this.hNj.hKb.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hNj.hKb.getParent()).removeView(this.hNj.hKb);
                    }
                    aVar.hDp.getLiveContainerView().addView(this.hNj.hKb, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.hNl.getParent() != null && (this.hNl.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hNl.getParent()).removeView(this.hNl);
                    }
                    aVar.hDp.getLiveContainerView().addView(this.hNl, layoutParams3);
                }
            }
            if (this.hNj != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isGiftPanelUnabled()) {
                    this.hNj.setGiftBtnVisible(false);
                } else {
                    this.hNj.setGiftBtnVisible(true);
                }
            }
            if (this.hNj != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isQuickChatUnabled()) {
                    this.hNj.setQuickImInputVisible(false);
                } else {
                    this.hNj.setQuickImInputVisible(true);
                }
            }
        }
    }

    public void cu(View view) {
        if (this.hNj != null) {
            this.hNj.cu(view);
        }
    }

    public void S(final ab abVar) {
        if (abVar.aKo.aPr) {
            if (abVar.mLiveInfo.isGoodsListVisible() && this.hNj.hOc.getVisibility() == 0) {
                this.hNj.hNU.setVisibility(8);
            } else {
                this.hNj.hNU.setVisibility(0);
                cjZ();
            }
            if (abVar.aKo.aPp == 2) {
                this.hNj.hNV.setVisibility(0);
            } else {
                this.hNj.hNV.setVisibility(8);
            }
            this.hNj.hNU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hNj.hNV.setVisibility(8);
                    if (!TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity();
                    } else {
                        c cVar = new c();
                        cVar.url = abVar.aKo.aPs;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                    }
                    a.this.cjY();
                }
            });
        }
    }

    public void cjX() {
        if (this.hNj != null && this.hNj.hNV != null) {
            this.hNj.hNV.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjY() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("task_from", "task_icon");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_DAILY_TASK_BUTTON_CLICK).setContentExt(jSONObject));
    }

    private void cjZ() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_DAILY_TASK_BUTTON_SHOW));
    }

    public boolean ab(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.optString("content_type").equals("daily_task_status")) {
            if (jSONObject.optInt("received", 0) == 2) {
                this.hNj.hNV.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    public void cv(View view) {
        if (this.hNj != null) {
            this.hNj.cv(view);
        }
    }

    private void cka() {
        co coVar;
        if (this.hNm != null) {
            this.hNj.hOc.removeOnLayoutChangeListener(this.hNm);
        }
        if (com.baidu.live.ae.a.Qm() != null && com.baidu.live.ae.a.Qm().bCs != null && com.baidu.live.ae.a.Qm().bCs.aRm != null && (coVar = com.baidu.live.ae.a.Qm().bCs.aRm) != null) {
            String str = coVar.aTa;
            String str2 = coVar.aSZ;
            if (str != null && str2 != null && !str2.isEmpty() && !str.isEmpty() && !TextUtils.isEmpty(str)) {
                this.hNj.hOd.startLoad(str2, 10, false);
                this.hNj.hOc.setVisibility(0);
                this.hNj.hOd.setVisibility(0);
                this.hNj.hOe.setVisibility(8);
                return;
            }
        }
        this.hNj.hOc.setVisibility(8);
    }

    public void a(InterfaceC0677a interfaceC0677a) {
        if (this.hNj != null && this.hNj.hOc != null && this.hNj.hOc.getVisibility() == 0) {
            this.hNn = interfaceC0677a;
            this.hNm = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.ckb();
                }
            };
            this.hNj.hOc.addOnLayoutChangeListener(this.hNm);
            this.hNj.hOc.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hNn != null) {
                        int[] iArr = new int[2];
                        a.this.hNj.hOc.getLocationInWindow(iArr);
                        a.this.hNn.bP((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.hNj.hOc.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20) + a.this.hNj.hOc.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckb() {
        if (this.hNj != null && this.hNj.hOc != null && this.hNj.hOc.getVisibility() == 0) {
            this.hNj.hOc.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hNj != null && a.this.hNj.hOc != null && a.this.hNj.hOc.getVisibility() == 0 && a.this.hNn != null) {
                        int[] iArr = new int[2];
                        a.this.hNj.hOc.getLocationInWindow(iArr);
                        a.this.hNn.bQ((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.hNj.hOc.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20) + a.this.hNj.hOc.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.hNj != null && this.hNj.hOc != null && this.hNj.hOc.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.hNj.hOd.getVisibility() == 0) {
                    this.hNj.hOd.setVisibility(8);
                }
                if (this.hNj.hOe.getVisibility() != 0) {
                    this.hNj.hOe.setVisibility(0);
                }
                this.hNj.hOe.setTimer(str, f);
                return;
            }
            if (this.hNj.hOd.getVisibility() != 0) {
                this.hNj.hOd.setVisibility(0);
            }
            if (this.hNj.hOe.getVisibility() == 0) {
                this.hNj.hOe.setVisibility(8);
            }
        }
    }

    public void ckc() {
        if (this.hNj != null && this.hNj.hOc != null && this.hNm != null) {
            this.hNj.hOc.removeOnLayoutChangeListener(this.hNm);
        }
        this.hNo = 0L;
        if (this.bSB != null && this.hNj != null && this.bSB.indexOfChild(this.hNj.getRootView()) > 0) {
            this.bSB.removeView(this.hNj.getRootView());
        }
        if (this.hNl != null && (this.hNl.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hNl.getParent()).removeView(this.hNl);
        }
        if (this.hNj != null && this.hNj.hKb != null && (this.hNj.hKb.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hNj.hKb.getParent()).removeView(this.hNj.hKb);
        }
        if (this.hNj != null) {
            this.hNj.ccK();
        }
    }

    public void setVisibility(int i) {
        if (this.hNj != null && this.hNj.getRootView() != null) {
            this.hNj.getRootView().setVisibility(i);
        }
        if (this.hNl != null) {
            this.hNl.setVisibility(i);
        }
    }

    public void a(o oVar, ab abVar) {
        if (this.hNj != null) {
            if (abVar != null && abVar.aJZ != null) {
                this.hNj.a(abVar.aJZ.isNewUser, abVar.mLiveInfo, Lr());
            } else {
                this.hNj.a(false, null, Lr());
            }
            if (oVar == null || TextUtils.isEmpty(oVar.EX()) || oVar.EW() != 1) {
                this.hNj.hNE.setVisibility(8);
                return;
            }
            this.hNj.hNE.setVisibility(0);
            this.hNj.hND.setDefaultBgResource(a.e.sdk_shape_transparent);
            this.hNj.hND.startLoad(oVar.EX(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.hNj.hNW.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.hNj.hNE.setVisibility(8);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (oVar.EV() != null) {
                    alaStaticItem.addParams("gifts_value", oVar.EV().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, oVar.EV().DU());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, oVar.EV().DV());
                }
                if (abVar != null && abVar.mLiveInfo != null) {
                    alaStaticItem.addParams("feed_id", abVar.mLiveInfo.feed_id);
                    alaStaticItem.addParams("room_id", abVar.mLiveInfo.room_id);
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(LogConfig.LOG_GIFT_ID, oVar.EV().DU());
                jSONObject.putOpt("gift_name", oVar.EV().DV());
                jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, oVar.EV().getPrice());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "show", "liveroom", "quickgift_show").setContentExt(null, null, jSONObject));
        }
    }

    public String Lr() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void ckd() {
        if (this.hNj != null) {
            this.hNj.hOf.setVisibility(8);
            this.hNj.hOg.setVisibility(8);
            this.hNj.hNG.setVisibility(0);
        }
    }

    public void cke() {
        if (this.hNj != null) {
            this.hNj.hOf.setVisibility(0);
            this.hNj.hOg.setVisibility(0);
            if (this.hNp) {
                this.hNj.hNG.setVisibility(0);
            } else {
                this.hNj.hNG.setVisibility(8);
            }
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.hNj != null) {
            if (i3 == 2) {
                cke();
            } else if (i3 == 1) {
                ckd();
            }
            ckb();
            ckf();
        }
    }

    private void ckf() {
        if (this.hNj != null) {
            this.hNj.bkr();
        }
    }

    public void wc(int i) {
        if (this.hNj != null && this.hNj.hKb != null) {
            this.hNj.hKb.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.hNj != null && this.hNj.hNC != null) {
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
            if (this.bSB != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.12
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (a.this.bSB != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout = a.this.hNj.hNC;
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
                            a.this.bSB.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.bSB != null) {
                            a.this.bSB.removeView(inflate);
                        }
                    }
                }, i + j);
            }
        }
    }

    public ImageView getLandscapeBarrageImageView() {
        if (this.hNj != null) {
            return this.hNj.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.hNo = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.hNq);
        MessageManager.getInstance().unRegisterListener(this.hNr);
        MessageManager.getInstance().unRegisterListener(this.hNs);
        MessageManager.getInstance().unRegisterListener(this.hNt);
        MessageManager.getInstance().unRegisterListener(this.hNu);
        MessageManager.getInstance().unRegisterListener(this.hNv);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TURN_TAB_LOC);
        this.hNn = null;
        if (this.hNj != null) {
            if (this.hNm != null) {
                this.hNj.hOc.removeOnLayoutChangeListener(this.hNm);
            }
            this.hNj.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckg() {
        if (this.hNj != null && this.hNj.hOd != null) {
            this.hNj.hOd.setScaleX(1.1f);
            this.hNj.hOd.setScaleY(1.1f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hNj.hOd, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hNj.hOd, View.SCALE_Y, 1.1f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hNj.hOd, View.SCALE_X, 1.0f, 1.1f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hNj.hOd, View.SCALE_Y, 1.0f, 1.1f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(100L);
            animatorSet2.playTogether(ofFloat3, ofFloat4);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hNj.hOd, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.hNj.hOd, View.SCALE_Y, 1.1f, 1.0f);
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
