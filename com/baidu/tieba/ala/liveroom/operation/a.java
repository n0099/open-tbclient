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
import com.baidu.live.data.bo;
import com.baidu.live.data.cf;
import com.baidu.live.data.ck;
import com.baidu.live.data.cq;
import com.baidu.live.data.w;
import com.baidu.live.gift.o;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private ViewGroup bNk;
    CustomMessageTask.CustomRunnable bxu;
    private Handler handler;
    private boolean hzA;
    private CustomMessageListener hzB;
    private CustomMessageListener hzC;
    private CustomMessageListener hzD;
    private CustomMessageListener hzE;
    private CustomMessageListener hzF;
    private CustomMessageListener hzG;
    private AlaLiveBottomOperationView hzu;
    private com.baidu.tieba.ala.liveroom.data.a hzv;
    private FrameLayout hzw;
    private View.OnLayoutChangeListener hzx;
    private InterfaceC0695a hzy;
    private long hzz;
    private String otherParams;

    /* renamed from: com.baidu.tieba.ala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0695a {
        void bS(int i, int i2);

        void bT(int i, int i2);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.hzA = true;
        this.hzB = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                cq cqVar;
                String str;
                long j;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                    j = 1000;
                } else {
                    bo boVar = com.baidu.live.ae.a.RB().bxq;
                    if (boVar != null && (cqVar = boVar.aQN) != null) {
                        str = cqVar.aTH;
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
        this.hzC = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.ala.liveroom.operation.a.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.ala.liveroom.v.b.ckA().brJ != null) {
                    str = com.baidu.tieba.ala.liveroom.v.b.ckA().brJ.aKm;
                    i = com.baidu.tieba.ala.liveroom.v.b.ckA().brJ.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, 1000L, i);
                }
            }
        };
        this.hzD = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hzu != null) {
                    a.this.hzu.a(false, null, a.this.Oj());
                }
            }
        };
        this.hzE = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    w Iq = (a.this.hzv == null || a.this.hzv.hpR == null) ? null : a.this.hzv.hpR.Iq();
                    if (Iq == null || Iq.aKr == null) {
                        a.this.hzu.a(false, null, a.this.Oj());
                    } else {
                        a.this.hzu.a(Iq.aKr.isNewUser, Iq.mLiveInfo, a.this.Oj());
                    }
                }
            }
        };
        this.hzF = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.ala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.hzu != null && a.this.hzu.hAl != null) {
                    a.this.hzu.hAl.performClick();
                }
            }
        };
        this.bxu = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.hzu != null && a.this.hzu.hAl != null) {
                        int[] iArr = new int[2];
                        a.this.hzu.hAl.getLocationOnScreen(iArr);
                        jSONObject.putOpt("turn_tab_x", Integer.valueOf(iArr[0]));
                        jSONObject.putOpt("turn_tab_y", Integer.valueOf(iArr[1]));
                    }
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_TURN_TAB_LOC, jSONObject.toString());
                } catch (JSONException e) {
                    return null;
                }
            }
        };
        this.hzG = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.cjV();
            }
        };
        MessageManager.getInstance().registerListener(this.hzB);
        MessageManager.getInstance().registerListener(this.hzC);
        MessageManager.getInstance().registerListener(this.hzD);
        MessageManager.getInstance().registerListener(this.hzE);
        MessageManager.getInstance().registerListener(this.hzF);
        MessageManager.getInstance().registerListener(this.hzG);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_TURN_TAB_LOC, this.bxu);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913260, (Class) null);
        if (runTask != null && runTask.getData() != null) {
            this.hzA = ((Boolean) runTask.getData()).booleanValue();
        }
    }

    public void no(boolean z) {
        if (this.hzu != null) {
            this.hzu.no(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.hzu != null) {
            this.hzu.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.hzv = aVar;
            this.bNk = viewGroup;
            if (this.hzu == null) {
                this.hzu = new AlaLiveBottomOperationView(getPageContext());
            }
            this.hzu.UD();
            this.hzu.registerListeners();
            this.hzu.setOnLiveViewOperationBtnClickListener(bVar);
            this.hzu.getRootView().setId(a.f.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.hzu.getRootView()) >= 0) {
                viewGroup.removeView(this.hzu.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.hzu.getRootView().setBackgroundResource(a.e.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
                this.hzu.getRootView().setBackgroundResource(a.c.sdk_transparent);
            }
            viewGroup.addView(this.hzu.getRootView(), layoutParams);
            if (this.hzw == null) {
                this.hzw = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.hzw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.s(view, 8);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                cjP();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.hzu.hzR != null) {
                this.hzu.hzR.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.hzu != null && this.hzu.hwz != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds72));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds8);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12) + UtilHelper.getStatusBarHeight();
                    } else {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds25);
                    }
                    layoutParams2.gravity = 53;
                    if (this.hzu.hwz.getParent() != null && (this.hzu.hwz.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hzu.hwz.getParent()).removeView(this.hzu.hwz);
                    }
                    aVar.hpQ.getLiveContainerView().addView(this.hzu.hwz, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.hzw.getParent() != null && (this.hzw.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.hzw.getParent()).removeView(this.hzw);
                    }
                    aVar.hpQ.getLiveContainerView().addView(this.hzw, layoutParams3);
                }
            }
            if (this.hzu != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isGiftPanelUnabled()) {
                    this.hzu.setGiftBtnVisible(false);
                } else {
                    this.hzu.setGiftBtnVisible(true);
                }
            }
            if (this.hzu != null) {
                if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.isQuickChatUnabled()) {
                    this.hzu.setQuickImInputVisible(false);
                } else {
                    this.hzu.setQuickImInputVisible(true);
                }
            }
        }
    }

    public void cp(View view) {
        if (this.hzu != null) {
            this.hzu.cp(view);
        }
    }

    public void cq(View view) {
        if (this.hzu != null) {
            this.hzu.cq(view);
        }
    }

    private void cjP() {
        ck ckVar;
        cf cfVar;
        if (this.hzx != null) {
            this.hzu.hAl.removeOnLayoutChangeListener(this.hzx);
        }
        bo boVar = com.baidu.live.ae.a.RB().bxq;
        if (boVar != null && (ckVar = boVar.aQP) != null && ckVar.aTj && (cfVar = boVar.aQM) != null && cfVar.aSk != null && !TextUtils.isEmpty(cfVar.aSk.webUrl)) {
            this.hzu.hAl.setVisibility(0);
            this.hzu.hAm.setVisibility(0);
            this.hzu.hAn.setVisibility(8);
            return;
        }
        this.hzu.hAl.setVisibility(8);
    }

    public void a(InterfaceC0695a interfaceC0695a) {
        if (this.hzu != null && this.hzu.hAl != null && this.hzu.hAl.getVisibility() == 0) {
            this.hzy = interfaceC0695a;
            this.hzx = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.cjQ();
                }
            };
            this.hzu.hAl.addOnLayoutChangeListener(this.hzx);
            this.hzu.hAl.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hzy != null) {
                        int[] iArr = new int[2];
                        a.this.hzu.hAl.getLocationInWindow(iArr);
                        a.this.hzy.bS((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.hzu.hAl.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20) + a.this.hzu.hAl.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjQ() {
        if (this.hzu != null && this.hzu.hAl != null && this.hzu.hAl.getVisibility() == 0) {
            this.hzu.hAl.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hzu != null && a.this.hzu.hAl != null && a.this.hzu.hAl.getVisibility() == 0 && a.this.hzy != null) {
                        int[] iArr = new int[2];
                        a.this.hzu.hAl.getLocationInWindow(iArr);
                        a.this.hzy.bT((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.hzu.hAl.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20) + a.this.hzu.hAl.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.hzu != null && this.hzu.hAl != null && this.hzu.hAl.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.hzu.hAm.getVisibility() == 0) {
                    this.hzu.hAm.setVisibility(8);
                }
                if (this.hzu.hAn.getVisibility() != 0) {
                    this.hzu.hAn.setVisibility(0);
                }
                this.hzu.hAn.setTimer(str, f);
                return;
            }
            if (this.hzu.hAm.getVisibility() != 0) {
                this.hzu.hAm.setVisibility(0);
            }
            if (this.hzu.hAn.getVisibility() == 0) {
                this.hzu.hAn.setVisibility(8);
            }
        }
    }

    public void cjR() {
        if (this.hzu != null && this.hzu.hAl != null && this.hzx != null) {
            this.hzu.hAl.removeOnLayoutChangeListener(this.hzx);
        }
        this.hzz = 0L;
        if (this.bNk != null && this.hzu != null && this.bNk.indexOfChild(this.hzu.getRootView()) > 0) {
            this.bNk.removeView(this.hzu.getRootView());
        }
        if (this.hzw != null && (this.hzw.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hzw.getParent()).removeView(this.hzw);
        }
        if (this.hzu != null && this.hzu.hwz != null && (this.hzu.hwz.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hzu.hwz.getParent()).removeView(this.hzu.hwz);
        }
        if (this.hzu != null) {
            this.hzu.ccC();
        }
    }

    public void setVisibility(int i) {
        if (this.hzu != null && this.hzu.getRootView() != null) {
            this.hzu.getRootView().setVisibility(i);
        }
        if (this.hzw != null) {
            this.hzw.setVisibility(i);
        }
    }

    public void a(o oVar, w wVar) {
        if (this.hzu != null) {
            if (wVar != null && wVar.aKr != null) {
                this.hzu.a(wVar.aKr.isNewUser, wVar.mLiveInfo, Oj());
            } else {
                this.hzu.a(false, null, Oj());
            }
            if (oVar == null || TextUtils.isEmpty(oVar.HY()) || oVar.HX() != 1) {
                this.hzu.hzP.setVisibility(8);
                return;
            }
            this.hzu.hzP.setVisibility(0);
            this.hzu.hzO.setDefaultBgResource(a.e.sdk_shape_transparent);
            this.hzu.hzO.startLoad(oVar.HY(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.hzu.hAf.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.hzu.hzP.setVisibility(8);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (oVar.HW() != null) {
                    alaStaticItem.addParams("gifts_value", oVar.HW().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, oVar.HW().GX());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, oVar.HW().GY());
                }
                if (wVar != null && wVar.mLiveInfo != null) {
                    alaStaticItem.addParams("feed_id", wVar.mLiveInfo.feed_id);
                    alaStaticItem.addParams("room_id", wVar.mLiveInfo.room_id);
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(LogConfig.LOG_GIFT_ID, oVar.HW().GX());
                jSONObject.putOpt("gift_name", oVar.HW().GY());
                jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, oVar.HW().getPrice());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "show", "liveroom", "quickgift_show").setContentExt(null, null, jSONObject));
        }
    }

    public String Oj() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void cjS() {
        if (this.hzu != null) {
            this.hzu.setMsgLayoutWidth(false);
            this.hzu.hAo.setVisibility(8);
            this.hzu.hAp.setVisibility(8);
            this.hzu.hzR.setVisibility(0);
        }
    }

    public void cjT() {
        if (this.hzu != null) {
            this.hzu.setMsgLayoutWidth(true);
            this.hzu.hAo.setVisibility(0);
            this.hzu.hAp.setVisibility(0);
            if (this.hzA) {
                this.hzu.hzR.setVisibility(0);
            } else {
                this.hzu.hzR.setVisibility(8);
            }
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.hzu != null) {
            if (i3 == 2) {
                cjT();
            } else if (i3 == 1) {
                cjS();
            }
            cjQ();
            cjU();
        }
    }

    private void cjU() {
        if (this.hzu != null) {
            this.hzu.blq();
        }
    }

    public void xk(int i) {
        if (this.hzu != null && this.hzu.hwz != null) {
            this.hzu.hwz.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.hzu != null && this.hzu.hzN != null) {
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
            if (this.bNk != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (a.this.bNk != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout = a.this.hzu.hzN;
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
                            a.this.bNk.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.bNk != null) {
                            a.this.bNk.removeView(inflate);
                        }
                    }
                }, i + j);
            }
        }
    }

    public ImageView getLandscapeBarrageImageView() {
        if (this.hzu != null) {
            return this.hzu.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.hzz = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.hzB);
        MessageManager.getInstance().unRegisterListener(this.hzC);
        MessageManager.getInstance().unRegisterListener(this.hzD);
        MessageManager.getInstance().unRegisterListener(this.hzE);
        MessageManager.getInstance().unRegisterListener(this.hzF);
        MessageManager.getInstance().unRegisterListener(this.hzG);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TURN_TAB_LOC);
        this.hzy = null;
        if (this.hzu != null) {
            if (this.hzx != null) {
                this.hzu.hAl.removeOnLayoutChangeListener(this.hzx);
            }
            this.hzu.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjV() {
        if (this.hzu != null && this.hzu.hAm != null) {
            this.hzu.hAm.setScaleX(1.1f);
            this.hzu.hAm.setScaleY(1.1f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hzu.hAm, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hzu.hAm, View.SCALE_Y, 1.1f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hzu.hAm, View.SCALE_X, 1.0f, 1.1f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hzu.hAm, View.SCALE_Y, 1.0f, 1.1f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(100L);
            animatorSet2.playTogether(ofFloat3, ofFloat4);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hzu.hAm, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.hzu.hAm, View.SCALE_Y, 1.1f, 1.0f);
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
