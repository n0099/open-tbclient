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
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    CustomMessageTask.CustomRunnable bAW;
    private ViewGroup bRb;
    private AlaLiveBottomOperationView hLA;
    private com.baidu.tieba.ala.liveroom.data.a hLB;
    private FrameLayout hLC;
    private View.OnLayoutChangeListener hLD;
    private InterfaceC0671a hLE;
    private long hLF;
    private boolean hLG;
    private CustomMessageListener hLH;
    private CustomMessageListener hLI;
    private CustomMessageListener hLJ;
    private CustomMessageListener hLK;
    private CustomMessageListener hLL;
    private CustomMessageListener hLM;
    private Handler handler;
    private String otherParams;

    /* renamed from: com.baidu.tieba.ala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0671a {
        void bP(int i, int i2);

        void bQ(int i, int i2);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.hLG = true;
        this.hLH = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                cy cyVar;
                String str;
                long j = 1000;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                } else {
                    bv bvVar = com.baidu.live.ae.a.Qj().bAS;
                    if (bvVar != null && (cyVar = bvVar.aPN) != null) {
                        str = cyVar.aSV;
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
        this.hLI = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.ala.liveroom.operation.a.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.ala.liveroom.u.b.ckE().bvg != null) {
                    str = com.baidu.tieba.ala.liveroom.u.b.ckE().bvg.aIu;
                    i = com.baidu.tieba.ala.liveroom.u.b.ckE().bvg.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.d(str, 1000L, i);
                }
            }
        };
        this.hLJ = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hLA != null) {
                    a.this.hLA.a(false, null, a.this.Lo());
                }
            }
        };
        this.hLK = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    ab Fm = (a.this.hLB == null || a.this.hLB.hBH == null) ? null : a.this.hLB.hBH.Fm();
                    if (Fm == null || Fm.aIz == null) {
                        a.this.hLA.a(false, null, a.this.Lo());
                    } else {
                        a.this.hLA.a(Fm.aIz.isNewUser, Fm.mLiveInfo, a.this.Lo());
                    }
                }
            }
        };
        this.hLL = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hLA != null && a.this.hLA.hMt != null) {
                    a.this.hLA.hMt.performClick();
                }
            }
        };
        this.bAW = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.hLA != null && a.this.hLA.hMt != null) {
                        int[] iArr = new int[2];
                        a.this.hLA.hMt.getLocationOnScreen(iArr);
                        jSONObject.putOpt("turn_tab_x", Integer.valueOf(iArr[0]));
                        jSONObject.putOpt("turn_tab_y", Integer.valueOf(iArr[1]));
                    }
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_TURN_TAB_LOC, jSONObject.toString());
                } catch (JSONException e) {
                    return null;
                }
            }
        };
        this.hLM = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.cka();
            }
        };
        MessageManager.getInstance().registerListener(this.hLH);
        MessageManager.getInstance().registerListener(this.hLI);
        MessageManager.getInstance().registerListener(this.hLJ);
        MessageManager.getInstance().registerListener(this.hLK);
        MessageManager.getInstance().registerListener(this.hLL);
        MessageManager.getInstance().registerListener(this.hLM);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_TURN_TAB_LOC, this.bAW);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913260, (Class) null);
        if (runTask != null && runTask.getData() != null) {
            this.hLG = ((Boolean) runTask.getData()).booleanValue();
        }
    }

    public void nV(boolean z) {
        if (this.hLA != null) {
            this.hLA.nV(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.hLA != null) {
            this.hLA.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.hLB = aVar;
            this.bRb = viewGroup;
            if (this.hLA == null) {
                this.hLA = new AlaLiveBottomOperationView(getPageContext());
            }
            this.hLA.Tw();
            this.hLA.registerListeners();
            this.hLA.setOnLiveViewOperationBtnClickListener(bVar);
            this.hLA.getRootView().setId(a.f.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.hLA.getRootView()) >= 0) {
                viewGroup.removeView(this.hLA.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.hLA.getRootView().setBackgroundResource(a.e.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.hLA.getRootView().setBackgroundResource(a.c.sdk_transparent);
            }
            viewGroup.addView(this.hLA.getRootView(), layoutParams);
            if (this.hLC == null) {
                this.hLC = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.hLC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.v(view, 8);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                cjU();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.hLA.hLX != null) {
                this.hLA.hLX.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.hLA != null && this.hLA.hIs != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds72));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds8);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12) + UtilHelper.getStatusBarHeight();
                    } else {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds25);
                    }
                    layoutParams2.gravity = 53;
                    if (this.hLA.hIs.getParent() != null && (this.hLA.hIs.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hLA.hIs.getParent()).removeView(this.hLA.hIs);
                    }
                    aVar.hBG.getLiveContainerView().addView(this.hLA.hIs, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.hLC.getParent() != null && (this.hLC.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hLC.getParent()).removeView(this.hLC);
                    }
                    aVar.hBG.getLiveContainerView().addView(this.hLC, layoutParams3);
                }
            }
            if (this.hLA != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isGiftPanelUnabled()) {
                    this.hLA.setGiftBtnVisible(false);
                } else {
                    this.hLA.setGiftBtnVisible(true);
                }
            }
            if (this.hLA != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isQuickChatUnabled()) {
                    this.hLA.setQuickImInputVisible(false);
                } else {
                    this.hLA.setQuickImInputVisible(true);
                }
            }
        }
    }

    public void cu(View view) {
        if (this.hLA != null) {
            this.hLA.cu(view);
        }
    }

    public void S(final ab abVar) {
        if (abVar.aIO.aNR) {
            if (abVar.mLiveInfo.isGoodsListVisible() && this.hLA.hMt.getVisibility() == 0) {
                this.hLA.hMl.setVisibility(8);
            } else {
                this.hLA.hMl.setVisibility(0);
                cjT();
            }
            if (abVar.aIO.aNP == 2) {
                this.hLA.hMm.setVisibility(0);
            } else {
                this.hLA.hMm.setVisibility(8);
            }
            this.hLA.hMl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hLA.hMm.setVisibility(8);
                    if (!TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity();
                    } else {
                        c cVar = new c();
                        cVar.url = abVar.aIO.aNS;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                    }
                    a.this.cjS();
                }
            });
        }
    }

    public void cjR() {
        if (this.hLA != null && this.hLA.hMm != null) {
            this.hLA.hMm.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjS() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("task_from", "task_icon");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_DAILY_TASK_BUTTON_CLICK).setContentExt(jSONObject));
    }

    private void cjT() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_DAILY_TASK_BUTTON_SHOW));
    }

    public boolean Z(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.optString("content_type").equals("daily_task_status")) {
            if (jSONObject.optInt("received", 0) == 2) {
                this.hLA.hMm.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    public void cv(View view) {
        if (this.hLA != null) {
            this.hLA.cv(view);
        }
    }

    private void cjU() {
        co coVar;
        if (this.hLD != null) {
            this.hLA.hMt.removeOnLayoutChangeListener(this.hLD);
        }
        if (com.baidu.live.ae.a.Qj() != null && com.baidu.live.ae.a.Qj().bAS != null && com.baidu.live.ae.a.Qj().bAS.aPM != null && (coVar = com.baidu.live.ae.a.Qj().bAS.aPM) != null) {
            String str = coVar.aRA;
            String str2 = coVar.aRz;
            if (str != null && str2 != null && !str2.isEmpty() && !str.isEmpty() && !TextUtils.isEmpty(str)) {
                this.hLA.hMu.startLoad(str2, 10, false);
                this.hLA.hMt.setVisibility(0);
                this.hLA.hMu.setVisibility(0);
                this.hLA.hMv.setVisibility(8);
                return;
            }
        }
        this.hLA.hMt.setVisibility(8);
    }

    public void a(InterfaceC0671a interfaceC0671a) {
        if (this.hLA != null && this.hLA.hMt != null && this.hLA.hMt.getVisibility() == 0) {
            this.hLE = interfaceC0671a;
            this.hLD = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.cjV();
                }
            };
            this.hLA.hMt.addOnLayoutChangeListener(this.hLD);
            this.hLA.hMt.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hLE != null) {
                        int[] iArr = new int[2];
                        a.this.hLA.hMt.getLocationInWindow(iArr);
                        a.this.hLE.bP((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.hLA.hMt.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20) + a.this.hLA.hMt.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjV() {
        if (this.hLA != null && this.hLA.hMt != null && this.hLA.hMt.getVisibility() == 0) {
            this.hLA.hMt.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hLA != null && a.this.hLA.hMt != null && a.this.hLA.hMt.getVisibility() == 0 && a.this.hLE != null) {
                        int[] iArr = new int[2];
                        a.this.hLA.hMt.getLocationInWindow(iArr);
                        a.this.hLE.bQ((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.hLA.hMt.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20) + a.this.hLA.hMt.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.hLA != null && this.hLA.hMt != null && this.hLA.hMt.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.hLA.hMu.getVisibility() == 0) {
                    this.hLA.hMu.setVisibility(8);
                }
                if (this.hLA.hMv.getVisibility() != 0) {
                    this.hLA.hMv.setVisibility(0);
                }
                this.hLA.hMv.setTimer(str, f);
                return;
            }
            if (this.hLA.hMu.getVisibility() != 0) {
                this.hLA.hMu.setVisibility(0);
            }
            if (this.hLA.hMv.getVisibility() == 0) {
                this.hLA.hMv.setVisibility(8);
            }
        }
    }

    public void cjW() {
        if (this.hLA != null && this.hLA.hMt != null && this.hLD != null) {
            this.hLA.hMt.removeOnLayoutChangeListener(this.hLD);
        }
        this.hLF = 0L;
        if (this.bRb != null && this.hLA != null && this.bRb.indexOfChild(this.hLA.getRootView()) > 0) {
            this.bRb.removeView(this.hLA.getRootView());
        }
        if (this.hLC != null && (this.hLC.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hLC.getParent()).removeView(this.hLC);
        }
        if (this.hLA != null && this.hLA.hIs != null && (this.hLA.hIs.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hLA.hIs.getParent()).removeView(this.hLA.hIs);
        }
        if (this.hLA != null) {
            this.hLA.ccE();
        }
    }

    public void setVisibility(int i) {
        if (this.hLA != null && this.hLA.getRootView() != null) {
            this.hLA.getRootView().setVisibility(i);
        }
        if (this.hLC != null) {
            this.hLC.setVisibility(i);
        }
    }

    public void a(o oVar, ab abVar) {
        if (this.hLA != null) {
            if (abVar != null && abVar.aIz != null) {
                this.hLA.a(abVar.aIz.isNewUser, abVar.mLiveInfo, Lo());
            } else {
                this.hLA.a(false, null, Lo());
            }
            if (oVar == null || TextUtils.isEmpty(oVar.EU()) || oVar.ET() != 1) {
                this.hLA.hLV.setVisibility(8);
                return;
            }
            this.hLA.hLV.setVisibility(0);
            this.hLA.hLU.setDefaultBgResource(a.e.sdk_shape_transparent);
            this.hLA.hLU.startLoad(oVar.EU(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.hLA.hMn.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.hLA.hLV.setVisibility(8);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (oVar.ES() != null) {
                    alaStaticItem.addParams("gifts_value", oVar.ES().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, oVar.ES().DR());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, oVar.ES().DS());
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
                jSONObject.putOpt(LogConfig.LOG_GIFT_ID, oVar.ES().DR());
                jSONObject.putOpt("gift_name", oVar.ES().DS());
                jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, oVar.ES().getPrice());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "show", "liveroom", "quickgift_show").setContentExt(null, null, jSONObject));
        }
    }

    public String Lo() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void cjX() {
        if (this.hLA != null) {
            this.hLA.hMw.setVisibility(8);
            this.hLA.hMx.setVisibility(8);
            this.hLA.hLX.setVisibility(0);
        }
    }

    public void cjY() {
        if (this.hLA != null) {
            this.hLA.hMw.setVisibility(0);
            this.hLA.hMx.setVisibility(0);
            if (this.hLG) {
                this.hLA.hLX.setVisibility(0);
            } else {
                this.hLA.hLX.setVisibility(8);
            }
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.hLA != null) {
            if (i3 == 2) {
                cjY();
            } else if (i3 == 1) {
                cjX();
            }
            cjV();
            cjZ();
        }
    }

    private void cjZ() {
        if (this.hLA != null) {
            this.hLA.bkp();
        }
    }

    public void wa(int i) {
        if (this.hLA != null && this.hLA.hIs != null) {
            this.hLA.hIs.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.hLA != null && this.hLA.hLT != null) {
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
            if (this.bRb != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.12
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (a.this.bRb != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout = a.this.hLA.hLT;
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
                            a.this.bRb.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.bRb != null) {
                            a.this.bRb.removeView(inflate);
                        }
                    }
                }, i + j);
            }
        }
    }

    public ImageView getLandscapeBarrageImageView() {
        if (this.hLA != null) {
            return this.hLA.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.hLF = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.hLH);
        MessageManager.getInstance().unRegisterListener(this.hLI);
        MessageManager.getInstance().unRegisterListener(this.hLJ);
        MessageManager.getInstance().unRegisterListener(this.hLK);
        MessageManager.getInstance().unRegisterListener(this.hLL);
        MessageManager.getInstance().unRegisterListener(this.hLM);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TURN_TAB_LOC);
        this.hLE = null;
        if (this.hLA != null) {
            if (this.hLD != null) {
                this.hLA.hMt.removeOnLayoutChangeListener(this.hLD);
            }
            this.hLA.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cka() {
        if (this.hLA != null && this.hLA.hMu != null) {
            this.hLA.hMu.setScaleX(1.1f);
            this.hLA.hMu.setScaleY(1.1f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hLA.hMu, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hLA.hMu, View.SCALE_Y, 1.1f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hLA.hMu, View.SCALE_X, 1.0f, 1.1f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hLA.hMu, View.SCALE_Y, 1.0f, 1.1f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(100L);
            animatorSet2.playTogether(ofFloat3, ofFloat4);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hLA.hMu, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.hLA.hMu, View.SCALE_Y, 1.1f, 1.0f);
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
