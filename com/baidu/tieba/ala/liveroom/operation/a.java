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
import com.baidu.live.ap.c;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.bq;
import com.baidu.live.data.ch;
import com.baidu.live.data.cn;
import com.baidu.live.data.cs;
import com.baidu.live.data.x;
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
    private ViewGroup bNl;
    CustomMessageTask.CustomRunnable bxt;
    private AlaLiveBottomOperationView hGO;
    private com.baidu.tieba.ala.liveroom.data.a hGP;
    private FrameLayout hGQ;
    private View.OnLayoutChangeListener hGR;
    private InterfaceC0670a hGS;
    private long hGT;
    private boolean hGU;
    private CustomMessageListener hGV;
    private CustomMessageListener hGW;
    private CustomMessageListener hGX;
    private CustomMessageListener hGY;
    private CustomMessageListener hGZ;
    private CustomMessageListener hHa;
    private Handler handler;
    private String otherParams;

    /* renamed from: com.baidu.tieba.ala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0670a {
        void bR(int i, int i2);

        void bS(int i, int i2);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.hGU = true;
        this.hGV = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                cs csVar;
                String str;
                long j = 1000;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                } else {
                    bq bqVar = com.baidu.live.af.a.OJ().bxp;
                    if (bqVar != null && (csVar = bqVar.aMP) != null) {
                        str = csVar.aPS;
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
        this.hGW = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.ala.liveroom.operation.a.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.ala.liveroom.v.b.cjy().brD != null) {
                    str = com.baidu.tieba.ala.liveroom.v.b.cjy().brD.aFY;
                    i = com.baidu.tieba.ala.liveroom.v.b.cjy().brD.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, 1000L, i);
                }
            }
        };
        this.hGX = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hGO != null) {
                    a.this.hGO.a(false, null, a.this.JQ());
                }
            }
        };
        this.hGY = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    x DW = (a.this.hGP == null || a.this.hGP.hxj == null) ? null : a.this.hGP.hxj.DW();
                    if (DW == null || DW.aGd == null) {
                        a.this.hGO.a(false, null, a.this.JQ());
                    } else {
                        a.this.hGO.a(DW.aGd.isNewUser, DW.mLiveInfo, a.this.JQ());
                    }
                }
            }
        };
        this.hGZ = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hGO != null && a.this.hGO.hHH != null) {
                    a.this.hGO.hHH.performClick();
                }
            }
        };
        this.bxt = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.hGO != null && a.this.hGO.hHH != null) {
                        int[] iArr = new int[2];
                        a.this.hGO.hHH.getLocationOnScreen(iArr);
                        jSONObject.putOpt("turn_tab_x", Integer.valueOf(iArr[0]));
                        jSONObject.putOpt("turn_tab_y", Integer.valueOf(iArr[1]));
                    }
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_TURN_TAB_LOC, jSONObject.toString());
                } catch (JSONException e) {
                    return null;
                }
            }
        };
        this.hHa = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.ciU();
            }
        };
        MessageManager.getInstance().registerListener(this.hGV);
        MessageManager.getInstance().registerListener(this.hGW);
        MessageManager.getInstance().registerListener(this.hGX);
        MessageManager.getInstance().registerListener(this.hGY);
        MessageManager.getInstance().registerListener(this.hGZ);
        MessageManager.getInstance().registerListener(this.hHa);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_TURN_TAB_LOC, this.bxt);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913260, (Class) null);
        if (runTask != null && runTask.getData() != null) {
            this.hGU = ((Boolean) runTask.getData()).booleanValue();
        }
    }

    public void nK(boolean z) {
        if (this.hGO != null) {
            this.hGO.nK(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.hGO != null) {
            this.hGO.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.hGP = aVar;
            this.bNl = viewGroup;
            if (this.hGO == null) {
                this.hGO = new AlaLiveBottomOperationView(getPageContext());
            }
            this.hGO.RP();
            this.hGO.registerListeners();
            this.hGO.setOnLiveViewOperationBtnClickListener(bVar);
            this.hGO.getRootView().setId(a.f.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.hGO.getRootView()) >= 0) {
                viewGroup.removeView(this.hGO.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.hGO.getRootView().setBackgroundResource(a.e.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.hGO.getRootView().setBackgroundResource(a.c.sdk_transparent);
            }
            viewGroup.addView(this.hGO.getRootView(), layoutParams);
            if (this.hGQ == null) {
                this.hGQ = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.hGQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.v(view, 8);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                ciO();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.hGO.hHl != null) {
                this.hGO.hHl.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.hGO != null && this.hGO.hDS != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds72));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds8);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12) + UtilHelper.getStatusBarHeight();
                    } else {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds25);
                    }
                    layoutParams2.gravity = 53;
                    if (this.hGO.hDS.getParent() != null && (this.hGO.hDS.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hGO.hDS.getParent()).removeView(this.hGO.hDS);
                    }
                    aVar.hxi.getLiveContainerView().addView(this.hGO.hDS, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.hGQ.getParent() != null && (this.hGQ.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hGQ.getParent()).removeView(this.hGQ);
                    }
                    aVar.hxi.getLiveContainerView().addView(this.hGQ, layoutParams3);
                }
            }
            if (this.hGO != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isGiftPanelUnabled()) {
                    this.hGO.setGiftBtnVisible(false);
                } else {
                    this.hGO.setGiftBtnVisible(true);
                }
            }
            if (this.hGO != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isQuickChatUnabled()) {
                    this.hGO.setQuickImInputVisible(false);
                } else {
                    this.hGO.setQuickImInputVisible(true);
                }
            }
        }
    }

    public void cy(View view) {
        if (this.hGO != null) {
            this.hGO.cy(view);
        }
    }

    public void Q(final x xVar) {
        if (xVar.aGs.aKV) {
            if (xVar.mLiveInfo.isGoodsListVisible() && this.hGO.hHH.getVisibility() == 0) {
                this.hGO.hHz.setVisibility(8);
            } else {
                this.hGO.hHz.setVisibility(0);
                ciN();
            }
            if (xVar.aGs.aKT == 2) {
                this.hGO.hHA.setVisibility(0);
            } else {
                this.hGO.hHA.setVisibility(8);
            }
            this.hGO.hHz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hGO.hHA.setVisibility(8);
                    if (!TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity();
                    } else {
                        c cVar = new c();
                        cVar.url = xVar.aGs.aKW;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                    }
                    a.this.ciM();
                }
            });
        }
    }

    public void ciL() {
        if (this.hGO != null && this.hGO.hHA != null) {
            this.hGO.hHA.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciM() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("task_from", "task_icon");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_DAILY_TASK_BUTTON_CLICK).setContentExt(jSONObject));
    }

    private void ciN() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_DAILY_TASK_BUTTON_SHOW));
    }

    public boolean V(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.optString("content_type").equals("daily_task_status")) {
            if (jSONObject.optInt("received", 0) == 2) {
                this.hGO.hHA.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    public void cz(View view) {
        if (this.hGO != null) {
            this.hGO.cz(view);
        }
    }

    private void ciO() {
        ch chVar;
        if (this.hGR != null) {
            this.hGO.hHH.removeOnLayoutChangeListener(this.hGR);
        }
        if (com.baidu.live.af.a.OJ() != null && com.baidu.live.af.a.OJ().bxp != null && com.baidu.live.af.a.OJ().bxp.aMO != null && (chVar = com.baidu.live.af.a.OJ().bxp.aMO) != null) {
            String str = chVar.aOy;
            String str2 = chVar.aOx;
            if (str != null && str2 != null && !str2.isEmpty() && !str.isEmpty() && !TextUtils.isEmpty(new cn(str).webUrl)) {
                this.hGO.hHI.startLoad(str2, 10, false);
                this.hGO.hHH.setVisibility(0);
                this.hGO.hHI.setVisibility(0);
                this.hGO.hHJ.setVisibility(8);
                return;
            }
        }
        this.hGO.hHH.setVisibility(8);
    }

    public void a(InterfaceC0670a interfaceC0670a) {
        if (this.hGO != null && this.hGO.hHH != null && this.hGO.hHH.getVisibility() == 0) {
            this.hGS = interfaceC0670a;
            this.hGR = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.ciP();
                }
            };
            this.hGO.hHH.addOnLayoutChangeListener(this.hGR);
            this.hGO.hHH.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hGS != null) {
                        int[] iArr = new int[2];
                        a.this.hGO.hHH.getLocationInWindow(iArr);
                        a.this.hGS.bR((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.hGO.hHH.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20) + a.this.hGO.hHH.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciP() {
        if (this.hGO != null && this.hGO.hHH != null && this.hGO.hHH.getVisibility() == 0) {
            this.hGO.hHH.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hGO != null && a.this.hGO.hHH != null && a.this.hGO.hHH.getVisibility() == 0 && a.this.hGS != null) {
                        int[] iArr = new int[2];
                        a.this.hGO.hHH.getLocationInWindow(iArr);
                        a.this.hGS.bS((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.hGO.hHH.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20) + a.this.hGO.hHH.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.hGO != null && this.hGO.hHH != null && this.hGO.hHH.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.hGO.hHI.getVisibility() == 0) {
                    this.hGO.hHI.setVisibility(8);
                }
                if (this.hGO.hHJ.getVisibility() != 0) {
                    this.hGO.hHJ.setVisibility(0);
                }
                this.hGO.hHJ.setTimer(str, f);
                return;
            }
            if (this.hGO.hHI.getVisibility() != 0) {
                this.hGO.hHI.setVisibility(0);
            }
            if (this.hGO.hHJ.getVisibility() == 0) {
                this.hGO.hHJ.setVisibility(8);
            }
        }
    }

    public void ciQ() {
        if (this.hGO != null && this.hGO.hHH != null && this.hGR != null) {
            this.hGO.hHH.removeOnLayoutChangeListener(this.hGR);
        }
        this.hGT = 0L;
        if (this.bNl != null && this.hGO != null && this.bNl.indexOfChild(this.hGO.getRootView()) > 0) {
            this.bNl.removeView(this.hGO.getRootView());
        }
        if (this.hGQ != null && (this.hGQ.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hGQ.getParent()).removeView(this.hGQ);
        }
        if (this.hGO != null && this.hGO.hDS != null && (this.hGO.hDS.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hGO.hDS.getParent()).removeView(this.hGO.hDS);
        }
        if (this.hGO != null) {
            this.hGO.cbC();
        }
    }

    public void setVisibility(int i) {
        if (this.hGO != null && this.hGO.getRootView() != null) {
            this.hGO.getRootView().setVisibility(i);
        }
        if (this.hGQ != null) {
            this.hGQ.setVisibility(i);
        }
    }

    public void a(o oVar, x xVar) {
        if (this.hGO != null) {
            if (xVar != null && xVar.aGd != null) {
                this.hGO.a(xVar.aGd.isNewUser, xVar.mLiveInfo, JQ());
            } else {
                this.hGO.a(false, null, JQ());
            }
            if (oVar == null || TextUtils.isEmpty(oVar.DE()) || oVar.DD() != 1) {
                this.hGO.hHj.setVisibility(8);
                return;
            }
            this.hGO.hHj.setVisibility(0);
            this.hGO.hHi.setDefaultBgResource(a.e.sdk_shape_transparent);
            this.hGO.hHi.startLoad(oVar.DE(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.hGO.hHB.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.hGO.hHj.setVisibility(8);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (oVar.DC() != null) {
                    alaStaticItem.addParams("gifts_value", oVar.DC().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, oVar.DC().CC());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, oVar.DC().CD());
                }
                if (xVar != null && xVar.mLiveInfo != null) {
                    alaStaticItem.addParams("feed_id", xVar.mLiveInfo.feed_id);
                    alaStaticItem.addParams("room_id", xVar.mLiveInfo.room_id);
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(LogConfig.LOG_GIFT_ID, oVar.DC().CC());
                jSONObject.putOpt("gift_name", oVar.DC().CD());
                jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, oVar.DC().getPrice());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "show", "liveroom", "quickgift_show").setContentExt(null, null, jSONObject));
        }
    }

    public String JQ() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void ciR() {
        if (this.hGO != null) {
            this.hGO.setMsgLayoutWidth(false);
            this.hGO.hHK.setVisibility(8);
            this.hGO.hHL.setVisibility(8);
            this.hGO.hHl.setVisibility(0);
        }
    }

    public void ciS() {
        if (this.hGO != null) {
            this.hGO.setMsgLayoutWidth(true);
            this.hGO.hHK.setVisibility(0);
            this.hGO.hHL.setVisibility(0);
            if (this.hGU) {
                this.hGO.hHl.setVisibility(0);
            } else {
                this.hGO.hHl.setVisibility(8);
            }
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.hGO != null) {
            if (i3 == 2) {
                ciS();
            } else if (i3 == 1) {
                ciR();
            }
            ciP();
            ciT();
        }
    }

    private void ciT() {
        if (this.hGO != null) {
            this.hGO.bjV();
        }
    }

    public void vP(int i) {
        if (this.hGO != null && this.hGO.hDS != null) {
            this.hGO.hDS.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.hGO != null && this.hGO.hHh != null) {
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
            if (this.bNl != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.12
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (a.this.bNl != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout = a.this.hGO.hHh;
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
                            a.this.bNl.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.bNl != null) {
                            a.this.bNl.removeView(inflate);
                        }
                    }
                }, i + j);
            }
        }
    }

    public ImageView getLandscapeBarrageImageView() {
        if (this.hGO != null) {
            return this.hGO.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.hGT = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.hGV);
        MessageManager.getInstance().unRegisterListener(this.hGW);
        MessageManager.getInstance().unRegisterListener(this.hGX);
        MessageManager.getInstance().unRegisterListener(this.hGY);
        MessageManager.getInstance().unRegisterListener(this.hGZ);
        MessageManager.getInstance().unRegisterListener(this.hHa);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TURN_TAB_LOC);
        this.hGS = null;
        if (this.hGO != null) {
            if (this.hGR != null) {
                this.hGO.hHH.removeOnLayoutChangeListener(this.hGR);
            }
            this.hGO.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciU() {
        if (this.hGO != null && this.hGO.hHI != null) {
            this.hGO.hHI.setScaleX(1.1f);
            this.hGO.hHI.setScaleY(1.1f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hGO.hHI, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hGO.hHI, View.SCALE_Y, 1.1f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hGO.hHI, View.SCALE_X, 1.0f, 1.1f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hGO.hHI, View.SCALE_Y, 1.0f, 1.1f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(100L);
            animatorSet2.playTogether(ofFloat3, ofFloat4);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hGO.hHI, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.hGO.hHI, View.SCALE_Y, 1.1f, 1.0f);
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
