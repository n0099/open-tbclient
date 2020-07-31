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
import com.baidu.live.data.bc;
import com.baidu.live.data.bm;
import com.baidu.live.data.br;
import com.baidu.live.data.bv;
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
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    CustomMessageTask.CustomRunnable bes;
    private ViewGroup fNw;
    private com.baidu.tieba.ala.liveroom.data.a gtA;
    private FrameLayout gtB;
    private View.OnLayoutChangeListener gtC;
    private InterfaceC0586a gtD;
    private long gtE;
    private CustomMessageListener gtF;
    private CustomMessageListener gtG;
    private CustomMessageListener gtH;
    private CustomMessageListener gtI;
    private CustomMessageListener gtJ;
    private CustomMessageListener gtK;
    private AlaLiveBottomOperationView gtz;
    private Handler handler;
    private String otherParams;

    /* renamed from: com.baidu.tieba.ala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0586a {
        void bC(int i, int i2);

        void bD(int i, int i2);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.gtF = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                bv bvVar;
                String str;
                long j;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                    j = 1000;
                } else {
                    bc bcVar = com.baidu.live.v.a.Hs().beo;
                    if (bcVar != null && (bvVar = bcVar.aEp) != null) {
                        str = bvVar.aGt;
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
        this.gtG = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.ala.liveroom.operation.a.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.ala.liveroom.v.b.bMA().aZy != null) {
                    str = com.baidu.tieba.ala.liveroom.v.b.bMA().aZy.azw;
                    i = com.baidu.tieba.ala.liveroom.v.b.bMA().aZy.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, 1000L, i);
                }
            }
        };
        this.gtH = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gtz != null) {
                    a.this.gtz.a(false, null, a.this.Et());
                }
            }
        };
        this.gtI = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.operation.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    q FO = (a.this.gtA == null || a.this.gtA.gla == null) ? null : a.this.gtA.gla.FO();
                    if (FO == null || FO.ayV == null) {
                        a.this.gtz.a(false, null, a.this.Et());
                    } else {
                        a.this.gtz.a(FO.ayV.isNewUser, FO.mLiveInfo, a.this.Et());
                    }
                }
            }
        };
        this.gtJ = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.ala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gtz != null && a.this.gtz.guq != null) {
                    a.this.gtz.guq.performClick();
                }
            }
        };
        this.bes = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.gtz != null && a.this.gtz.guq != null) {
                        int[] iArr = new int[2];
                        a.this.gtz.guq.getLocationOnScreen(iArr);
                        jSONObject.putOpt("turn_tab_x", Integer.valueOf(iArr[0]));
                        jSONObject.putOpt("turn_tab_y", Integer.valueOf(iArr[1]));
                    }
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_TURN_TAB_LOC, jSONObject.toString());
                } catch (JSONException e) {
                    return null;
                }
            }
        };
        this.gtK = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.bLU();
            }
        };
        MessageManager.getInstance().registerListener(this.gtF);
        MessageManager.getInstance().registerListener(this.gtG);
        MessageManager.getInstance().registerListener(this.gtH);
        MessageManager.getInstance().registerListener(this.gtI);
        MessageManager.getInstance().registerListener(this.gtJ);
        MessageManager.getInstance().registerListener(this.gtK);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_TURN_TAB_LOC, this.bes);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void lm(boolean z) {
        if (this.gtz != null) {
            this.gtz.lm(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.gtz != null) {
            this.gtz.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, AlaLiveInfoData alaLiveInfoData, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.gtA = aVar;
            this.fNw = viewGroup;
            if (this.gtz == null) {
                this.gtz = new AlaLiveBottomOperationView(getPageContext());
            }
            this.gtz.registerListeners();
            this.gtz.setOnLiveViewOperationBtnClickListener(bVar);
            this.gtz.getRootView().setId(a.g.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.gtz.getRootView()) >= 0) {
                viewGroup.removeView(this.gtz.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.gtz.getRootView().setBackgroundResource(a.f.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.gtz.getRootView().setBackgroundResource(a.d.sdk_transparent);
            }
            viewGroup.addView(this.gtz.getRootView(), layoutParams);
            if (this.gtB == null) {
                this.gtB = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.gtB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.m(view, 8);
                        }
                    }
                });
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                bLP();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.gtz.gtU != null) {
                this.gtz.gtU.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.gtz != null && this.gtz.guj != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds68));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds22);
                    layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds28);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds10) + UtilHelper.getStatusBarHeight();
                    }
                    layoutParams2.gravity = 53;
                    this.gtz.guj.setVisibility(8);
                    if (this.gtz.guj.getParent() != null && (this.gtz.guj.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.gtz.guj.getParent()).removeView(this.gtz.guj);
                    }
                    aVar.gkZ.getLiveContainerView().addView(this.gtz.guj, layoutParams2);
                } else {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds96));
                    layoutParams3.gravity = 83;
                    if (this.gtB.getParent() != null && (this.gtB.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.gtB.getParent()).removeView(this.gtB);
                    }
                    aVar.gkZ.getLiveContainerView().addView(this.gtB, layoutParams3);
                }
            }
            if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.mGiftPanelInvalid) {
                this.gtz.setGiftBtnVisible(false);
            } else {
                this.gtz.setGiftBtnVisible(true);
            }
            if (alaLiveInfoData != null && alaLiveInfoData.mAlaLiveSwitchData != null && alaLiveInfoData.mAlaLiveSwitchData.mQuickChatInvalid) {
                this.gtz.setQuickImInputVisible(false);
            } else {
                this.gtz.setQuickImInputVisible(true);
            }
        }
    }

    public void bM(View view) {
        if (this.gtz != null) {
            this.gtz.bM(view);
        }
    }

    private void bLP() {
        br brVar;
        bm bmVar;
        if (this.gtC != null) {
            this.gtz.guq.removeOnLayoutChangeListener(this.gtC);
        }
        bc bcVar = com.baidu.live.v.a.Hs().beo;
        if (bcVar != null && (brVar = bcVar.aEr) != null && brVar.aGh && (bmVar = bcVar.aEo) != null && bmVar.aFl != null && !TextUtils.isEmpty(bmVar.aFl.webUrl)) {
            this.gtz.guq.setVisibility(0);
            this.gtz.gur.setVisibility(0);
            this.gtz.gus.setVisibility(8);
            return;
        }
        this.gtz.guq.setVisibility(8);
    }

    public void a(InterfaceC0586a interfaceC0586a) {
        if (this.gtz != null && this.gtz.guq != null && this.gtz.guq.getVisibility() == 0) {
            this.gtD = interfaceC0586a;
            this.gtC = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.bLQ();
                }
            };
            this.gtz.guq.addOnLayoutChangeListener(this.gtC);
            this.gtz.guq.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gtD != null) {
                        int[] iArr = new int[2];
                        a.this.gtz.guq.getLocationInWindow(iArr);
                        a.this.gtD.bC((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.gtz.guq.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.gtz.guq.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLQ() {
        if (this.gtz != null && this.gtz.guq != null && this.gtz.guq.getVisibility() == 0) {
            this.gtz.guq.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gtz != null && a.this.gtz.guq != null && a.this.gtz.guq.getVisibility() == 0 && a.this.gtD != null) {
                        int[] iArr = new int[2];
                        a.this.gtz.guq.getLocationInWindow(iArr);
                        a.this.gtD.bD((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.gtz.guq.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.gtz.guq.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.gtz != null && this.gtz.guq != null && this.gtz.guq.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.gtz.gur.getVisibility() == 0) {
                    this.gtz.gur.setVisibility(8);
                }
                if (this.gtz.gus.getVisibility() != 0) {
                    this.gtz.gus.setVisibility(0);
                }
                this.gtz.gus.setTimer(str, f);
                return;
            }
            if (this.gtz.gur.getVisibility() != 0) {
                this.gtz.gur.setVisibility(0);
            }
            if (this.gtz.gus.getVisibility() == 0) {
                this.gtz.gus.setVisibility(8);
            }
        }
    }

    public void bLR() {
        if (this.gtz != null && this.gtz.guq != null && this.gtC != null) {
            this.gtz.guq.removeOnLayoutChangeListener(this.gtC);
        }
        this.gtE = 0L;
        if (this.fNw != null && this.gtz != null && this.fNw.indexOfChild(this.gtz.getRootView()) > 0) {
            this.fNw.removeView(this.gtz.getRootView());
        }
        if (this.gtB != null && (this.gtB.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gtB.getParent()).removeView(this.gtB);
        }
        if (this.gtz != null && this.gtz.guj != null && (this.gtz.guj.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gtz.guj.getParent()).removeView(this.gtz.guj);
        }
    }

    public void setVisibility(int i) {
        if (this.gtz != null && this.gtz.getRootView() != null) {
            this.gtz.getRootView().setVisibility(i);
        }
        if (this.gtB != null) {
            this.gtB.setVisibility(i);
        }
    }

    public void a(o oVar, q qVar) {
        if (this.gtz != null) {
            if (qVar != null && qVar.ayV != null) {
                this.gtz.a(qVar.ayV.isNewUser, qVar.mLiveInfo, Et());
            } else {
                this.gtz.a(false, null, Et());
            }
            if (oVar == null || TextUtils.isEmpty(oVar.zm()) || oVar.zl() != 1) {
                this.gtz.gtS.setVisibility(8);
                return;
            }
            this.gtz.gtS.setVisibility(0);
            this.gtz.gtR.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.gtz.gtR.startLoad(oVar.zm(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.gtz.guk.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.gtz.gtS.setVisibility(8);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (oVar.zk() != null) {
                    alaStaticItem.addParams("gifts_value", oVar.zk().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, oVar.zk().yo());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, oVar.zk().yp());
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

    public String Et() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void bLS() {
        if (this.gtz != null) {
            this.gtz.setMsgLayoutWidth(false);
            this.gtz.gut.setVisibility(8);
            this.gtz.guu.setVisibility(8);
        }
    }

    public void bLT() {
        if (this.gtz != null) {
            this.gtz.setMsgLayoutWidth(true);
            this.gtz.gut.setVisibility(0);
            this.gtz.guu.setVisibility(0);
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.gtz != null) {
            if (i3 == 2) {
                bLT();
            } else if (i3 == 1) {
                bLS();
            }
            bLQ();
        }
    }

    public void sm(int i) {
        if (this.gtz != null && this.gtz.guj != null) {
            this.gtz.guj.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.gtz != null && this.gtz.gtQ != null) {
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
            if (this.fNw != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (a.this.fNw != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout = a.this.gtz.gtQ;
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
                            a.this.fNw.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.fNw != null) {
                            a.this.fNw.removeView(inflate);
                        }
                    }
                }, i + j);
            }
        }
    }

    public ImageView getLandscapeBarrageImageView() {
        if (this.gtz != null) {
            return this.gtz.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.gtE = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gtF);
        MessageManager.getInstance().unRegisterListener(this.gtG);
        MessageManager.getInstance().unRegisterListener(this.gtH);
        MessageManager.getInstance().unRegisterListener(this.gtI);
        MessageManager.getInstance().unRegisterListener(this.gtJ);
        MessageManager.getInstance().unRegisterListener(this.gtK);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TURN_TAB_LOC);
        this.gtD = null;
        if (this.gtz != null) {
            if (this.gtC != null) {
                this.gtz.guq.removeOnLayoutChangeListener(this.gtC);
            }
            this.gtz.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLU() {
        if (this.gtz != null && this.gtz.gur != null) {
            this.gtz.gur.setScaleX(1.1f);
            this.gtz.gur.setScaleY(1.1f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gtz.gur, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gtz.gur, View.SCALE_Y, 1.1f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gtz.gur, View.SCALE_X, 1.0f, 1.1f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.gtz.gur, View.SCALE_Y, 1.0f, 1.1f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(100L);
            animatorSet2.playTogether(ofFloat3, ofFloat4);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.gtz.gur, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.gtz.gur, View.SCALE_Y, 1.1f, 1.0f);
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
