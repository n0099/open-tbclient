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
    private AlaLiveBottomOperationView hLm;
    private com.baidu.tieba.ala.liveroom.data.a hLn;
    private FrameLayout hLo;
    private View.OnLayoutChangeListener hLp;
    private InterfaceC0670a hLq;
    private long hLr;
    private boolean hLs;
    private CustomMessageListener hLt;
    private CustomMessageListener hLu;
    private CustomMessageListener hLv;
    private CustomMessageListener hLw;
    private CustomMessageListener hLx;
    private CustomMessageListener hLy;
    private Handler handler;
    private String otherParams;

    /* renamed from: com.baidu.tieba.ala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0670a {
        void bO(int i, int i2);

        void bP(int i, int i2);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.hLs = true;
        this.hLt = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
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
        this.hLu = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.ala.liveroom.operation.a.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.ala.liveroom.u.b.ckx().bvg != null) {
                    str = com.baidu.tieba.ala.liveroom.u.b.ckx().bvg.aIu;
                    i = com.baidu.tieba.ala.liveroom.u.b.ckx().bvg.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.d(str, 1000L, i);
                }
            }
        };
        this.hLv = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hLm != null) {
                    a.this.hLm.a(false, null, a.this.Lo());
                }
            }
        };
        this.hLw = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    ab Fm = (a.this.hLn == null || a.this.hLn.hBt == null) ? null : a.this.hLn.hBt.Fm();
                    if (Fm == null || Fm.aIz == null) {
                        a.this.hLm.a(false, null, a.this.Lo());
                    } else {
                        a.this.hLm.a(Fm.aIz.isNewUser, Fm.mLiveInfo, a.this.Lo());
                    }
                }
            }
        };
        this.hLx = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hLm != null && a.this.hLm.hMf != null) {
                    a.this.hLm.hMf.performClick();
                }
            }
        };
        this.bAW = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.hLm != null && a.this.hLm.hMf != null) {
                        int[] iArr = new int[2];
                        a.this.hLm.hMf.getLocationOnScreen(iArr);
                        jSONObject.putOpt("turn_tab_x", Integer.valueOf(iArr[0]));
                        jSONObject.putOpt("turn_tab_y", Integer.valueOf(iArr[1]));
                    }
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_TURN_TAB_LOC, jSONObject.toString());
                } catch (JSONException e) {
                    return null;
                }
            }
        };
        this.hLy = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.cjT();
            }
        };
        MessageManager.getInstance().registerListener(this.hLt);
        MessageManager.getInstance().registerListener(this.hLu);
        MessageManager.getInstance().registerListener(this.hLv);
        MessageManager.getInstance().registerListener(this.hLw);
        MessageManager.getInstance().registerListener(this.hLx);
        MessageManager.getInstance().registerListener(this.hLy);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_TURN_TAB_LOC, this.bAW);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913260, (Class) null);
        if (runTask != null && runTask.getData() != null) {
            this.hLs = ((Boolean) runTask.getData()).booleanValue();
        }
    }

    public void nV(boolean z) {
        if (this.hLm != null) {
            this.hLm.nV(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.hLm != null) {
            this.hLm.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.hLn = aVar;
            this.bRb = viewGroup;
            if (this.hLm == null) {
                this.hLm = new AlaLiveBottomOperationView(getPageContext());
            }
            this.hLm.Tw();
            this.hLm.registerListeners();
            this.hLm.setOnLiveViewOperationBtnClickListener(bVar);
            this.hLm.getRootView().setId(a.f.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.hLm.getRootView()) >= 0) {
                viewGroup.removeView(this.hLm.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.hLm.getRootView().setBackgroundResource(a.e.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.hLm.getRootView().setBackgroundResource(a.c.sdk_transparent);
            }
            viewGroup.addView(this.hLm.getRootView(), layoutParams);
            if (this.hLo == null) {
                this.hLo = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.hLo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.v(view, 8);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                cjN();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.hLm.hLJ != null) {
                this.hLm.hLJ.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.hLm != null && this.hLm.hIe != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds72));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds8);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12) + UtilHelper.getStatusBarHeight();
                    } else {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds25);
                    }
                    layoutParams2.gravity = 53;
                    if (this.hLm.hIe.getParent() != null && (this.hLm.hIe.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hLm.hIe.getParent()).removeView(this.hLm.hIe);
                    }
                    aVar.hBs.getLiveContainerView().addView(this.hLm.hIe, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.hLo.getParent() != null && (this.hLo.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hLo.getParent()).removeView(this.hLo);
                    }
                    aVar.hBs.getLiveContainerView().addView(this.hLo, layoutParams3);
                }
            }
            if (this.hLm != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isGiftPanelUnabled()) {
                    this.hLm.setGiftBtnVisible(false);
                } else {
                    this.hLm.setGiftBtnVisible(true);
                }
            }
            if (this.hLm != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isQuickChatUnabled()) {
                    this.hLm.setQuickImInputVisible(false);
                } else {
                    this.hLm.setQuickImInputVisible(true);
                }
            }
        }
    }

    public void cu(View view) {
        if (this.hLm != null) {
            this.hLm.cu(view);
        }
    }

    public void S(final ab abVar) {
        if (abVar.aIO.aNR) {
            if (abVar.mLiveInfo.isGoodsListVisible() && this.hLm.hMf.getVisibility() == 0) {
                this.hLm.hLX.setVisibility(8);
            } else {
                this.hLm.hLX.setVisibility(0);
                cjM();
            }
            if (abVar.aIO.aNP == 2) {
                this.hLm.hLY.setVisibility(0);
            } else {
                this.hLm.hLY.setVisibility(8);
            }
            this.hLm.hLX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hLm.hLY.setVisibility(8);
                    if (!TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity();
                    } else {
                        c cVar = new c();
                        cVar.url = abVar.aIO.aNS;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                    }
                    a.this.cjL();
                }
            });
        }
    }

    public void cjK() {
        if (this.hLm != null && this.hLm.hLY != null) {
            this.hLm.hLY.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjL() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("task_from", "task_icon");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_DAILY_TASK_BUTTON_CLICK).setContentExt(jSONObject));
    }

    private void cjM() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_DAILY_TASK_BUTTON_SHOW));
    }

    public boolean Z(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.optString("content_type").equals("daily_task_status")) {
            if (jSONObject.optInt("received", 0) == 2) {
                this.hLm.hLY.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    public void cv(View view) {
        if (this.hLm != null) {
            this.hLm.cv(view);
        }
    }

    private void cjN() {
        co coVar;
        if (this.hLp != null) {
            this.hLm.hMf.removeOnLayoutChangeListener(this.hLp);
        }
        if (com.baidu.live.ae.a.Qj() != null && com.baidu.live.ae.a.Qj().bAS != null && com.baidu.live.ae.a.Qj().bAS.aPM != null && (coVar = com.baidu.live.ae.a.Qj().bAS.aPM) != null) {
            String str = coVar.aRA;
            String str2 = coVar.aRz;
            if (str != null && str2 != null && !str2.isEmpty() && !str.isEmpty() && !TextUtils.isEmpty(str)) {
                this.hLm.hMg.startLoad(str2, 10, false);
                this.hLm.hMf.setVisibility(0);
                this.hLm.hMg.setVisibility(0);
                this.hLm.hMh.setVisibility(8);
                return;
            }
        }
        this.hLm.hMf.setVisibility(8);
    }

    public void a(InterfaceC0670a interfaceC0670a) {
        if (this.hLm != null && this.hLm.hMf != null && this.hLm.hMf.getVisibility() == 0) {
            this.hLq = interfaceC0670a;
            this.hLp = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.cjO();
                }
            };
            this.hLm.hMf.addOnLayoutChangeListener(this.hLp);
            this.hLm.hMf.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hLq != null) {
                        int[] iArr = new int[2];
                        a.this.hLm.hMf.getLocationInWindow(iArr);
                        a.this.hLq.bO((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.hLm.hMf.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20) + a.this.hLm.hMf.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjO() {
        if (this.hLm != null && this.hLm.hMf != null && this.hLm.hMf.getVisibility() == 0) {
            this.hLm.hMf.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hLm != null && a.this.hLm.hMf != null && a.this.hLm.hMf.getVisibility() == 0 && a.this.hLq != null) {
                        int[] iArr = new int[2];
                        a.this.hLm.hMf.getLocationInWindow(iArr);
                        a.this.hLq.bP((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.hLm.hMf.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20) + a.this.hLm.hMf.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.hLm != null && this.hLm.hMf != null && this.hLm.hMf.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.hLm.hMg.getVisibility() == 0) {
                    this.hLm.hMg.setVisibility(8);
                }
                if (this.hLm.hMh.getVisibility() != 0) {
                    this.hLm.hMh.setVisibility(0);
                }
                this.hLm.hMh.setTimer(str, f);
                return;
            }
            if (this.hLm.hMg.getVisibility() != 0) {
                this.hLm.hMg.setVisibility(0);
            }
            if (this.hLm.hMh.getVisibility() == 0) {
                this.hLm.hMh.setVisibility(8);
            }
        }
    }

    public void cjP() {
        if (this.hLm != null && this.hLm.hMf != null && this.hLp != null) {
            this.hLm.hMf.removeOnLayoutChangeListener(this.hLp);
        }
        this.hLr = 0L;
        if (this.bRb != null && this.hLm != null && this.bRb.indexOfChild(this.hLm.getRootView()) > 0) {
            this.bRb.removeView(this.hLm.getRootView());
        }
        if (this.hLo != null && (this.hLo.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hLo.getParent()).removeView(this.hLo);
        }
        if (this.hLm != null && this.hLm.hIe != null && (this.hLm.hIe.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hLm.hIe.getParent()).removeView(this.hLm.hIe);
        }
        if (this.hLm != null) {
            this.hLm.ccx();
        }
    }

    public void setVisibility(int i) {
        if (this.hLm != null && this.hLm.getRootView() != null) {
            this.hLm.getRootView().setVisibility(i);
        }
        if (this.hLo != null) {
            this.hLo.setVisibility(i);
        }
    }

    public void a(o oVar, ab abVar) {
        if (this.hLm != null) {
            if (abVar != null && abVar.aIz != null) {
                this.hLm.a(abVar.aIz.isNewUser, abVar.mLiveInfo, Lo());
            } else {
                this.hLm.a(false, null, Lo());
            }
            if (oVar == null || TextUtils.isEmpty(oVar.EU()) || oVar.ET() != 1) {
                this.hLm.hLH.setVisibility(8);
                return;
            }
            this.hLm.hLH.setVisibility(0);
            this.hLm.hLG.setDefaultBgResource(a.e.sdk_shape_transparent);
            this.hLm.hLG.startLoad(oVar.EU(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.hLm.hLZ.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.hLm.hLH.setVisibility(8);
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

    public void cjQ() {
        if (this.hLm != null) {
            this.hLm.hMi.setVisibility(8);
            this.hLm.hMj.setVisibility(8);
            this.hLm.hLJ.setVisibility(0);
        }
    }

    public void cjR() {
        if (this.hLm != null) {
            this.hLm.hMi.setVisibility(0);
            this.hLm.hMj.setVisibility(0);
            if (this.hLs) {
                this.hLm.hLJ.setVisibility(0);
            } else {
                this.hLm.hLJ.setVisibility(8);
            }
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.hLm != null) {
            if (i3 == 2) {
                cjR();
            } else if (i3 == 1) {
                cjQ();
            }
            cjO();
            cjS();
        }
    }

    private void cjS() {
        if (this.hLm != null) {
            this.hLm.bkp();
        }
    }

    public void wa(int i) {
        if (this.hLm != null && this.hLm.hIe != null) {
            this.hLm.hIe.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.hLm != null && this.hLm.hLF != null) {
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
                            FrameLayout frameLayout = a.this.hLm.hLF;
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
        if (this.hLm != null) {
            return this.hLm.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.hLr = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.hLt);
        MessageManager.getInstance().unRegisterListener(this.hLu);
        MessageManager.getInstance().unRegisterListener(this.hLv);
        MessageManager.getInstance().unRegisterListener(this.hLw);
        MessageManager.getInstance().unRegisterListener(this.hLx);
        MessageManager.getInstance().unRegisterListener(this.hLy);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TURN_TAB_LOC);
        this.hLq = null;
        if (this.hLm != null) {
            if (this.hLp != null) {
                this.hLm.hMf.removeOnLayoutChangeListener(this.hLp);
            }
            this.hLm.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjT() {
        if (this.hLm != null && this.hLm.hMg != null) {
            this.hLm.hMg.setScaleX(1.1f);
            this.hLm.hMg.setScaleY(1.1f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hLm.hMg, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hLm.hMg, View.SCALE_Y, 1.1f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hLm.hMg, View.SCALE_X, 1.0f, 1.1f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hLm.hMg, View.SCALE_Y, 1.0f, 1.1f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(100L);
            animatorSet2.playTogether(ofFloat3, ofFloat4);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hLm.hMg, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.hLm.hMg, View.SCALE_Y, 1.1f, 1.0f);
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
