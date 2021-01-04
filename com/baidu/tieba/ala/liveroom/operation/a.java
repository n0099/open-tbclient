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
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    CustomMessageTask.CustomRunnable bCf;
    private ViewGroup bRX;
    private boolean hLA;
    private CustomMessageListener hLB;
    private CustomMessageListener hLC;
    private CustomMessageListener hLD;
    private CustomMessageListener hLE;
    private CustomMessageListener hLF;
    private CustomMessageListener hLG;
    private AlaLiveBottomOperationView hLu;
    private com.baidu.tieba.ala.liveroom.data.a hLv;
    private FrameLayout hLw;
    private View.OnLayoutChangeListener hLx;
    private InterfaceC0687a hLy;
    private long hLz;
    private Handler handler;
    private String otherParams;

    /* renamed from: com.baidu.tieba.ala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0687a {
        void bR(int i, int i2);

        void bS(int i, int i2);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.hLA = true;
        this.hLB = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                cs csVar;
                String str;
                long j = 1000;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                } else {
                    bq bqVar = com.baidu.live.af.a.SE().bCb;
                    if (bqVar != null && (csVar = bqVar.aRC) != null) {
                        str = csVar.aUF;
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
        this.hLC = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.ala.liveroom.operation.a.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.ala.liveroom.v.b.cnp().bwr != null) {
                    str = com.baidu.tieba.ala.liveroom.v.b.cnp().bwr.aKL;
                    i = com.baidu.tieba.ala.liveroom.v.b.cnp().bwr.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, 1000L, i);
                }
            }
        };
        this.hLD = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hLu != null) {
                    a.this.hLu.a(false, null, a.this.NL());
                }
            }
        };
        this.hLE = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    x HR = (a.this.hLv == null || a.this.hLv.hBP == null) ? null : a.this.hLv.hBP.HR();
                    if (HR == null || HR.aKQ == null) {
                        a.this.hLu.a(false, null, a.this.NL());
                    } else {
                        a.this.hLu.a(HR.aKQ.isNewUser, HR.mLiveInfo, a.this.NL());
                    }
                }
            }
        };
        this.hLF = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hLu != null && a.this.hLu.hMn != null) {
                    a.this.hLu.hMn.performClick();
                }
            }
        };
        this.bCf = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.hLu != null && a.this.hLu.hMn != null) {
                        int[] iArr = new int[2];
                        a.this.hLu.hMn.getLocationOnScreen(iArr);
                        jSONObject.putOpt("turn_tab_x", Integer.valueOf(iArr[0]));
                        jSONObject.putOpt("turn_tab_y", Integer.valueOf(iArr[1]));
                    }
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_TURN_TAB_LOC, jSONObject.toString());
                } catch (JSONException e) {
                    return null;
                }
            }
        };
        this.hLG = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.cmL();
            }
        };
        MessageManager.getInstance().registerListener(this.hLB);
        MessageManager.getInstance().registerListener(this.hLC);
        MessageManager.getInstance().registerListener(this.hLD);
        MessageManager.getInstance().registerListener(this.hLE);
        MessageManager.getInstance().registerListener(this.hLF);
        MessageManager.getInstance().registerListener(this.hLG);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_TURN_TAB_LOC, this.bCf);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913260, (Class) null);
        if (runTask != null && runTask.getData() != null) {
            this.hLA = ((Boolean) runTask.getData()).booleanValue();
        }
    }

    public void nO(boolean z) {
        if (this.hLu != null) {
            this.hLu.nO(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.hLu != null) {
            this.hLu.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.hLv = aVar;
            this.bRX = viewGroup;
            if (this.hLu == null) {
                this.hLu = new AlaLiveBottomOperationView(getPageContext());
            }
            this.hLu.VI();
            this.hLu.registerListeners();
            this.hLu.setOnLiveViewOperationBtnClickListener(bVar);
            this.hLu.getRootView().setId(a.f.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.hLu.getRootView()) >= 0) {
                viewGroup.removeView(this.hLu.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.hLu.getRootView().setBackgroundResource(a.e.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.hLu.getRootView().setBackgroundResource(a.c.sdk_transparent);
            }
            viewGroup.addView(this.hLu.getRootView(), layoutParams);
            if (this.hLw == null) {
                this.hLw = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.hLw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.v(view, 8);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                cmF();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.hLu.hLR != null) {
                this.hLu.hLR.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.hLu != null && this.hLu.hIy != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds72));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds8);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12) + UtilHelper.getStatusBarHeight();
                    } else {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds25);
                    }
                    layoutParams2.gravity = 53;
                    if (this.hLu.hIy.getParent() != null && (this.hLu.hIy.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hLu.hIy.getParent()).removeView(this.hLu.hIy);
                    }
                    aVar.hBO.getLiveContainerView().addView(this.hLu.hIy, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.hLw.getParent() != null && (this.hLw.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hLw.getParent()).removeView(this.hLw);
                    }
                    aVar.hBO.getLiveContainerView().addView(this.hLw, layoutParams3);
                }
            }
            if (this.hLu != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isGiftPanelUnabled()) {
                    this.hLu.setGiftBtnVisible(false);
                } else {
                    this.hLu.setGiftBtnVisible(true);
                }
            }
            if (this.hLu != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isQuickChatUnabled()) {
                    this.hLu.setQuickImInputVisible(false);
                } else {
                    this.hLu.setQuickImInputVisible(true);
                }
            }
        }
    }

    public void cy(View view) {
        if (this.hLu != null) {
            this.hLu.cy(view);
        }
    }

    public void Q(final x xVar) {
        if (xVar.aLf.aPI) {
            if (xVar.mLiveInfo.isGoodsListVisible() && this.hLu.hMn.getVisibility() == 0) {
                this.hLu.hMf.setVisibility(8);
            } else {
                this.hLu.hMf.setVisibility(0);
                cmE();
            }
            if (xVar.aLf.aPG == 2) {
                this.hLu.hMg.setVisibility(0);
            } else {
                this.hLu.hMg.setVisibility(8);
            }
            this.hLu.hMf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hLu.hMg.setVisibility(8);
                    if (!TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity();
                    } else {
                        c cVar = new c();
                        cVar.url = xVar.aLf.aPJ;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                    }
                    a.this.cmD();
                }
            });
        }
    }

    public void cmC() {
        if (this.hLu != null && this.hLu.hMg != null) {
            this.hLu.hMg.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmD() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("task_from", "task_icon");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_DAILY_TASK_BUTTON_CLICK).setContentExt(jSONObject));
    }

    private void cmE() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_DAILY_TASK_BUTTON_SHOW));
    }

    public boolean V(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.optString("content_type").equals("daily_task_status")) {
            if (jSONObject.optInt("received", 0) == 2) {
                this.hLu.hMg.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    public void cz(View view) {
        if (this.hLu != null) {
            this.hLu.cz(view);
        }
    }

    private void cmF() {
        ch chVar;
        if (this.hLx != null) {
            this.hLu.hMn.removeOnLayoutChangeListener(this.hLx);
        }
        if (com.baidu.live.af.a.SE() != null && com.baidu.live.af.a.SE().bCb != null && com.baidu.live.af.a.SE().bCb.aRB != null && (chVar = com.baidu.live.af.a.SE().bCb.aRB) != null) {
            String str = chVar.aTl;
            String str2 = chVar.aTk;
            if (str != null && str2 != null && !str2.isEmpty() && !str.isEmpty() && !TextUtils.isEmpty(new cn(str).webUrl)) {
                this.hLu.hMo.startLoad(str2, 10, false);
                this.hLu.hMn.setVisibility(0);
                this.hLu.hMo.setVisibility(0);
                this.hLu.hMp.setVisibility(8);
                return;
            }
        }
        this.hLu.hMn.setVisibility(8);
    }

    public void a(InterfaceC0687a interfaceC0687a) {
        if (this.hLu != null && this.hLu.hMn != null && this.hLu.hMn.getVisibility() == 0) {
            this.hLy = interfaceC0687a;
            this.hLx = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.cmG();
                }
            };
            this.hLu.hMn.addOnLayoutChangeListener(this.hLx);
            this.hLu.hMn.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hLy != null) {
                        int[] iArr = new int[2];
                        a.this.hLu.hMn.getLocationInWindow(iArr);
                        a.this.hLy.bR((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.hLu.hMn.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20) + a.this.hLu.hMn.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmG() {
        if (this.hLu != null && this.hLu.hMn != null && this.hLu.hMn.getVisibility() == 0) {
            this.hLu.hMn.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hLu != null && a.this.hLu.hMn != null && a.this.hLu.hMn.getVisibility() == 0 && a.this.hLy != null) {
                        int[] iArr = new int[2];
                        a.this.hLu.hMn.getLocationInWindow(iArr);
                        a.this.hLy.bS((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.hLu.hMn.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20) + a.this.hLu.hMn.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.hLu != null && this.hLu.hMn != null && this.hLu.hMn.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.hLu.hMo.getVisibility() == 0) {
                    this.hLu.hMo.setVisibility(8);
                }
                if (this.hLu.hMp.getVisibility() != 0) {
                    this.hLu.hMp.setVisibility(0);
                }
                this.hLu.hMp.setTimer(str, f);
                return;
            }
            if (this.hLu.hMo.getVisibility() != 0) {
                this.hLu.hMo.setVisibility(0);
            }
            if (this.hLu.hMp.getVisibility() == 0) {
                this.hLu.hMp.setVisibility(8);
            }
        }
    }

    public void cmH() {
        if (this.hLu != null && this.hLu.hMn != null && this.hLx != null) {
            this.hLu.hMn.removeOnLayoutChangeListener(this.hLx);
        }
        this.hLz = 0L;
        if (this.bRX != null && this.hLu != null && this.bRX.indexOfChild(this.hLu.getRootView()) > 0) {
            this.bRX.removeView(this.hLu.getRootView());
        }
        if (this.hLw != null && (this.hLw.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hLw.getParent()).removeView(this.hLw);
        }
        if (this.hLu != null && this.hLu.hIy != null && (this.hLu.hIy.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hLu.hIy.getParent()).removeView(this.hLu.hIy);
        }
        if (this.hLu != null) {
            this.hLu.cft();
        }
    }

    public void setVisibility(int i) {
        if (this.hLu != null && this.hLu.getRootView() != null) {
            this.hLu.getRootView().setVisibility(i);
        }
        if (this.hLw != null) {
            this.hLw.setVisibility(i);
        }
    }

    public void a(o oVar, x xVar) {
        if (this.hLu != null) {
            if (xVar != null && xVar.aKQ != null) {
                this.hLu.a(xVar.aKQ.isNewUser, xVar.mLiveInfo, NL());
            } else {
                this.hLu.a(false, null, NL());
            }
            if (oVar == null || TextUtils.isEmpty(oVar.Hz()) || oVar.Hy() != 1) {
                this.hLu.hLP.setVisibility(8);
                return;
            }
            this.hLu.hLP.setVisibility(0);
            this.hLu.hLO.setDefaultBgResource(a.e.sdk_shape_transparent);
            this.hLu.hLO.startLoad(oVar.Hz(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.hLu.hMh.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.hLu.hLP.setVisibility(8);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (oVar.Hx() != null) {
                    alaStaticItem.addParams("gifts_value", oVar.Hx().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, oVar.Hx().Gx());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, oVar.Hx().Gy());
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
                jSONObject.putOpt(LogConfig.LOG_GIFT_ID, oVar.Hx().Gx());
                jSONObject.putOpt("gift_name", oVar.Hx().Gy());
                jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, oVar.Hx().getPrice());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "show", "liveroom", "quickgift_show").setContentExt(null, null, jSONObject));
        }
    }

    public String NL() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void cmI() {
        if (this.hLu != null) {
            this.hLu.setMsgLayoutWidth(false);
            this.hLu.hMq.setVisibility(8);
            this.hLu.hMr.setVisibility(8);
            this.hLu.hLR.setVisibility(0);
        }
    }

    public void cmJ() {
        if (this.hLu != null) {
            this.hLu.setMsgLayoutWidth(true);
            this.hLu.hMq.setVisibility(0);
            this.hLu.hMr.setVisibility(0);
            if (this.hLA) {
                this.hLu.hLR.setVisibility(0);
            } else {
                this.hLu.hLR.setVisibility(8);
            }
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.hLu != null) {
            if (i3 == 2) {
                cmJ();
            } else if (i3 == 1) {
                cmI();
            }
            cmG();
            cmK();
        }
    }

    private void cmK() {
        if (this.hLu != null) {
            this.hLu.bnO();
        }
    }

    public void xv(int i) {
        if (this.hLu != null && this.hLu.hIy != null) {
            this.hLu.hIy.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.hLu != null && this.hLu.hLN != null) {
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
            if (this.bRX != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.12
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (a.this.bRX != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout = a.this.hLu.hLN;
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
                            a.this.bRX.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.bRX != null) {
                            a.this.bRX.removeView(inflate);
                        }
                    }
                }, i + j);
            }
        }
    }

    public ImageView getLandscapeBarrageImageView() {
        if (this.hLu != null) {
            return this.hLu.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.hLz = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.hLB);
        MessageManager.getInstance().unRegisterListener(this.hLC);
        MessageManager.getInstance().unRegisterListener(this.hLD);
        MessageManager.getInstance().unRegisterListener(this.hLE);
        MessageManager.getInstance().unRegisterListener(this.hLF);
        MessageManager.getInstance().unRegisterListener(this.hLG);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TURN_TAB_LOC);
        this.hLy = null;
        if (this.hLu != null) {
            if (this.hLx != null) {
                this.hLu.hMn.removeOnLayoutChangeListener(this.hLx);
            }
            this.hLu.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmL() {
        if (this.hLu != null && this.hLu.hMo != null) {
            this.hLu.hMo.setScaleX(1.1f);
            this.hLu.hMo.setScaleY(1.1f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hLu.hMo, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hLu.hMo, View.SCALE_Y, 1.1f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hLu.hMo, View.SCALE_X, 1.0f, 1.1f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hLu.hMo, View.SCALE_Y, 1.0f, 1.1f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(100L);
            animatorSet2.playTogether(ofFloat3, ofFloat4);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hLu.hMo, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.hLu.hMo, View.SCALE_Y, 1.1f, 1.0f);
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
