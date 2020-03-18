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
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.ag;
import com.baidu.live.data.ap;
import com.baidu.live.data.ay;
import com.baidu.live.data.bd;
import com.baidu.live.data.bh;
import com.baidu.live.data.m;
import com.baidu.live.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.message.h;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.ILiveGoodsLogger;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.o;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private int YH;
    private List<ag> awY;
    CustomMessageTask.CustomRunnable axV;
    private ViewGroup ewN;
    private AlaLiveBottomOperationView fiX;
    private com.baidu.tieba.ala.liveroom.data.a fiY;
    private FrameLayout fiZ;
    private b fja;
    private View.OnLayoutChangeListener fjb;
    private InterfaceC0465a fjc;
    private CustomMessageListener fjd;
    CustomMessageListener fje;
    CustomMessageListener fjf;
    private CustomMessageListener fjg;
    private CustomMessageListener fjh;
    private CustomMessageListener fji;
    private Handler handler;
    private String otherParams;

    /* renamed from: com.baidu.tieba.ala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0465a {
        void bm(int i, int i2);

        void bn(int i, int i2);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.fjd = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                bh bhVar;
                String str;
                long j;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                    j = 1000;
                } else {
                    ap apVar = com.baidu.live.v.a.zs().axR;
                    if (apVar != null && (bhVar = apVar.ade) != null) {
                        str = bhVar.aeU;
                        j = 3000;
                    } else {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.x(str, j);
                }
            }
        };
        this.fje = new CustomMessageListener(2913111) { // from class: com.baidu.tieba.ala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fiX != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) customResponsedMessage.getData();
                    int i = getVideoGoodsListHttpResponseMessage.count;
                    if (i <= 0) {
                        a.this.fiX.ffF.setVisibility(8);
                        a.this.fiX.ffH.setVisibility(8);
                        a.this.fiX.ffH.setText("");
                    } else {
                        a.this.fiX.ffH.setText(i + "");
                        a.this.fiX.ffH.setVisibility(0);
                        a.this.fiX.ffF.setVisibility(0);
                        if (a.this.fiY != null && a.this.fiY.faT != null && a.this.fiY.faT.yT() != null && a.this.fiY.faT.yT().mLiveInfo != null) {
                            long j = a.this.fiY.faT.yT().mLiveInfo.live_id;
                            long j2 = a.this.fiY.faT.yT().mLiveInfo.room_id;
                            String str = a.this.fiY.faT.yT().mLiveInfo.feed_id;
                            if (!ILiveGoodsLogger.displayStoreIconMap.contains(Long.valueOf(j))) {
                                ILiveGoodsLogger.displayStoreIconMap.add(Long.valueOf(j));
                                LogManager.getLiveGoodsLogger().doDisplayStoreIconLog(j + "", j2 + "", str, a.this.otherParams);
                            }
                        }
                    }
                    a.this.awY = getVideoGoodsListHttpResponseMessage.awY;
                    if (getVideoGoodsListHttpResponseMessage.getOrginalMessage() != null && (getVideoGoodsListHttpResponseMessage.getOrginalMessage() instanceof h) && ((h) getVideoGoodsListHttpResponseMessage.getOrginalMessage()).awX && i > 0 && a.this.awY != null && a.this.awY.size() > 0) {
                        a.this.bqe();
                    }
                }
            }
        };
        this.fjf = new CustomMessageListener(2913112) { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fiX != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaLiveInfoData)) {
                    AlaLiveInfoData alaLiveInfoData = (AlaLiveInfoData) customResponsedMessage.getData();
                    o.b(alaLiveInfoData.feed_id, alaLiveInfoData.live_id, true);
                }
            }
        };
        this.fjg = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fiX != null) {
                    a.this.fiX.a(false, null, a.this.xC());
                }
            }
        };
        this.fjh = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fiX != null && a.this.fiX.fjK != null) {
                    a.this.fiX.fjK.performClick();
                }
            }
        };
        this.axV = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.fiX != null && a.this.fiX.fjK != null) {
                        int[] iArr = new int[2];
                        a.this.fiX.fjK.getLocationOnScreen(iArr);
                        jSONObject.putOpt("turn_tab_x", Integer.valueOf(iArr[0]));
                        jSONObject.putOpt("turn_tab_y", Integer.valueOf(iArr[1]));
                    }
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_TURN_TAB_LOC, jSONObject.toString());
                } catch (JSONException e) {
                    return null;
                }
            }
        };
        this.fji = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.bqf();
            }
        };
        MessageManager.getInstance().registerListener(this.fjd);
        MessageManager.getInstance().registerListener(this.fje);
        MessageManager.getInstance().registerListener(this.fjf);
        MessageManager.getInstance().registerListener(this.fjg);
        MessageManager.getInstance().registerListener(this.fjh);
        MessageManager.getInstance().registerListener(this.fji);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_TURN_TAB_LOC, this.axV);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void jc(boolean z) {
        if (this.fiX != null) {
            this.fiX.jc(z);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, int i, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.fiY = aVar;
            this.YH = i;
            this.ewN = viewGroup;
            if (this.fiX == null) {
                this.fiX = new AlaLiveBottomOperationView(getPageContext().getPageActivity());
            }
            this.fja = bVar;
            this.fiX.setOnLiveViewOperationBtnClickListener(bVar);
            this.fiX.getRootView().setId(a.g.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.fiX.getRootView()) >= 0) {
                viewGroup.removeView(this.fiX.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.fiX.getRootView().setBackgroundResource(a.f.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.fiX.getRootView().setBackgroundResource(a.d.sdk_transparent);
            }
            viewGroup.addView(this.fiX.getRootView(), layoutParams);
            if (this.fiZ == null) {
                this.fiZ = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.fiZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.m(view, 8);
                        }
                    }
                });
            }
            this.fiX.ffF.setVisibility(8);
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                bpZ();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.fiX.fjs != null) {
                this.fiX.fjs.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.fiX != null && this.fiX.fjG != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds68));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds22);
                    layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds28);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds10) + UtilHelper.getStatusBarHeight();
                    }
                    layoutParams2.gravity = 53;
                    this.fiX.fjG.setVisibility(8);
                    if (this.fiX.fjG.getParent() != null && (this.fiX.fjG.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.fiX.fjG.getParent()).removeView(this.fiX.fjG);
                    }
                    aVar.faS.getLiveContainerView().addView(this.fiX.fjG, layoutParams2);
                    return;
                }
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds96));
                layoutParams3.gravity = 83;
                if (this.fiZ.getParent() != null && (this.fiZ.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.fiZ.getParent()).removeView(this.fiZ);
                }
                aVar.faS.getLiveContainerView().addView(this.fiZ, layoutParams3);
            }
        }
    }

    private void bpZ() {
        bd bdVar;
        ay ayVar;
        if (this.fjb != null) {
            this.fiX.fjK.removeOnLayoutChangeListener(this.fjb);
        }
        ap apVar = com.baidu.live.v.a.zs().axR;
        if (apVar != null && (bdVar = apVar.adg) != null && bdVar.aeL && (ayVar = apVar.adc) != null && ayVar.aea != null && !TextUtils.isEmpty(ayVar.aea.webUrl)) {
            this.fiX.fjK.setVisibility(0);
            this.fiX.fjL.setVisibility(0);
            this.fiX.fjM.setVisibility(8);
            return;
        }
        this.fiX.fjK.setVisibility(8);
    }

    public void a(InterfaceC0465a interfaceC0465a) {
        if (this.fiX != null && this.fiX.fjK != null && this.fiX.fjK.getVisibility() == 0) {
            this.fjc = interfaceC0465a;
            this.fjb = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.bqa();
                }
            };
            this.fiX.fjK.addOnLayoutChangeListener(this.fjb);
            this.fiX.fjK.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.fjc != null) {
                        int[] iArr = new int[2];
                        a.this.fiX.fjK.getLocationInWindow(iArr);
                        a.this.fjc.bm((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.fiX.fjK.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.fiX.fjK.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqa() {
        if (this.fiX != null && this.fiX.fjK != null && this.fiX.fjK.getVisibility() == 0) {
            this.fiX.fjK.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.fiX != null && a.this.fiX.fjK != null && a.this.fiX.fjK.getVisibility() == 0 && a.this.fjc != null) {
                        int[] iArr = new int[2];
                        a.this.fiX.fjK.getLocationInWindow(iArr);
                        a.this.fjc.bn((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.fiX.fjK.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.fiX.fjK.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.fiX != null && this.fiX.fjK != null && this.fiX.fjK.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.fiX.fjL.getVisibility() == 0) {
                    this.fiX.fjL.setVisibility(8);
                }
                if (this.fiX.fjM.getVisibility() != 0) {
                    this.fiX.fjM.setVisibility(0);
                }
                this.fiX.fjM.setTimer(str, f);
                return;
            }
            if (this.fiX.fjL.getVisibility() != 0) {
                this.fiX.fjL.setVisibility(0);
            }
            if (this.fiX.fjM.getVisibility() == 0) {
                this.fiX.fjM.setVisibility(8);
            }
        }
    }

    public void bqb() {
        if (this.fiX != null && this.fiX.fjK != null && this.fjb != null) {
            this.fiX.fjK.removeOnLayoutChangeListener(this.fjb);
        }
        if (this.ewN != null && this.fiX != null && this.ewN.indexOfChild(this.fiX.getRootView()) > 0) {
            this.ewN.removeView(this.fiX.getRootView());
        }
        if (this.fiZ != null && (this.fiZ.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fiZ.getParent()).removeView(this.fiZ);
        }
        if (this.fiX != null && this.fiX.fjG != null && (this.fiX.fjG.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fiX.fjG.getParent()).removeView(this.fiX.fjG);
        }
    }

    public void setVisibility(int i) {
        if (this.fiX != null && this.fiX.getRootView() != null) {
            this.fiX.getRootView().setVisibility(i);
        }
        if (this.fiZ != null) {
            this.fiZ.setVisibility(i);
        }
    }

    public void a(com.baidu.live.gift.o oVar, m mVar) {
        if (this.fiX != null) {
            if (mVar != null && mVar.Yo != null) {
                this.fiX.a(mVar.Yo.isNewUser, mVar.mLiveInfo, xC());
            } else {
                this.fiX.a(false, null, xC());
            }
            if (oVar == null || TextUtils.isEmpty(oVar.sB()) || oVar.sA() != 1) {
                this.fiX.fjq.setVisibility(8);
                return;
            }
            this.fiX.fjq.setVisibility(0);
            this.fiX.fjp.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.fiX.fjp.startLoad(oVar.sB(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.fiX.fjH.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.fiX.fjq.setVisibility(8);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (oVar.sz() != null) {
                    alaStaticItem.addParams("gifts_value", oVar.sz().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, oVar.sz().rC());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, oVar.sz().rD());
                }
                if (mVar != null && mVar.mLiveInfo != null) {
                    alaStaticItem.addParams("feed_id", mVar.mLiveInfo.feed_id);
                    alaStaticItem.addParams("room_id", mVar.mLiveInfo.room_id);
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    public String xC() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void bqc() {
        if (this.fiX != null) {
            this.fiX.setMsgLayoutWidth(false);
            this.fiX.fjN.setVisibility(8);
            this.fiX.fjO.setVisibility(8);
        }
    }

    public void bqd() {
        if (this.fiX != null) {
            this.fiX.setMsgLayoutWidth(true);
            this.fiX.fjN.setVisibility(0);
            this.fiX.fjO.setVisibility(0);
        }
    }

    public void j(int i, int i2, int i3) {
        if (this.fiX != null) {
            if (i3 == 2) {
                bqd();
            } else if (i3 == 1) {
                bqc();
            }
            bqa();
        }
    }

    public void qB(int i) {
        if (this.fiX != null && this.fiX.fjG != null) {
            this.fiX.fjG.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, long j) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.fiX != null && this.fiX.fjo != null) {
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
            if (this.ewN != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (a.this.ewN != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout = a.this.fiX.fjo;
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
                            a.this.ewN.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.14
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.ewN != null) {
                            a.this.ewN.removeView(inflate);
                        }
                    }
                }, 3000 + j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqe() {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.fiX != null && this.fiX.fjo != null && this.awY != null && !this.awY.isEmpty()) {
            try {
                ag agVar = this.awY.get((int) (Math.random() * this.awY.size()));
                final View inflate = getPageContext().getPageActivity().getLayoutInflater().inflate(a.h.toast_goods_guide, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) inflate.findViewById(a.g.conver_imageView);
                tbImageView.setDefaultBgResource(a.f.sdk_shape_transparent);
                if (!TextUtils.isEmpty(agVar.acb)) {
                    try {
                        JSONArray jSONArray = new JSONArray(agVar.acb);
                        if (jSONArray.length() > 0) {
                            tbImageView.startLoad(jSONArray.optJSONObject(0).optString(UserAccountActionItem.KEY_SRC), 10, false);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                TextView textView = (TextView) inflate.findViewById(a.g.title_textView);
                TextView textView2 = (TextView) inflate.findViewById(a.g.price_textView);
                String str = agVar.title;
                if (str == null) {
                    str = "";
                } else if (str.length() > 8) {
                    str = str.substring(0, 8) + StringHelper.STRING_MORE;
                }
                textView.setText(str);
                textView2.setText(agVar.price);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.handler.removeCallbacksAndMessages(null);
                        if (a.this.ewN != null) {
                            a.this.ewN.removeView(inflate);
                        }
                        if (a.this.fja != null) {
                            a.this.fja.m(view, 15);
                        }
                        if (a.this.fiY != null && a.this.fiY.faT != null && a.this.fiY.faT.yT() != null && a.this.fiY.faT.yT().mLiveInfo != null) {
                            long j = a.this.fiY.faT.yT().mLiveInfo.live_id;
                            long j2 = a.this.fiY.faT.yT().mLiveInfo.room_id;
                            LogManager.getLiveGoodsLogger().doClickGoodsGuideLog(j + "", j2 + "", a.this.fiY.faT.yT().mLiveInfo.feed_id, a.this.otherParams);
                        }
                    }
                });
                if (this.ewN != null) {
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.16
                        @Override // java.lang.Runnable
                        public void run() {
                            Activity pageActivity;
                            if (a.this.ewN != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                                inflate.measure(0, 0);
                                View view = a.this.fiX.ffF;
                                int[] iArr = new int[2];
                                view.getLocationOnScreen(iArr);
                                int width = view.getWidth();
                                if (width <= 0) {
                                    view.measure(0, 0);
                                    width = view.getMeasuredWidth();
                                }
                                int measuredWidth = ((width / 2) + iArr[0]) - (inflate.getMeasuredWidth() / 2);
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                                layoutParams.addRule(12);
                                layoutParams.addRule(9);
                                layoutParams.leftMargin = measuredWidth;
                                layoutParams.bottomMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds110);
                                a.this.ewN.addView(inflate, layoutParams);
                                if (a.this.fiY != null && a.this.fiY.faT != null && a.this.fiY.faT.yT() != null && a.this.fiY.faT.yT().mLiveInfo != null) {
                                    long j = a.this.fiY.faT.yT().mLiveInfo.live_id;
                                    long j2 = a.this.fiY.faT.yT().mLiveInfo.room_id;
                                    String str2 = a.this.fiY.faT.yT().mLiveInfo.feed_id;
                                    if (!ILiveGoodsLogger.displayGoodsGuideMap.contains(Long.valueOf(j))) {
                                        ILiveGoodsLogger.displayGoodsGuideMap.add(Long.valueOf(j));
                                        LogManager.getLiveGoodsLogger().doDisplayGoodsGuideLog(j + "", j2 + "", str2, a.this.otherParams);
                                    }
                                }
                            }
                        }
                    }, 200L);
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.ewN != null) {
                                a.this.ewN.removeView(inflate);
                            }
                        }
                    }, 5000L);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public ImageView getLandscapeBarrageImageView() {
        if (this.fiX != null) {
            return this.fiX.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fjd);
        MessageManager.getInstance().unRegisterListener(this.fje);
        MessageManager.getInstance().unRegisterListener(this.fjf);
        MessageManager.getInstance().unRegisterListener(this.fjg);
        MessageManager.getInstance().unRegisterListener(this.fjh);
        MessageManager.getInstance().unRegisterListener(this.fji);
        this.fjc = null;
        if (this.fiX != null) {
            if (this.fjb != null) {
                this.fiX.fjK.removeOnLayoutChangeListener(this.fjb);
            }
            this.fiX.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqf() {
        if (this.fiX != null && this.fiX.fjL != null) {
            this.fiX.fjL.setScaleX(1.1f);
            this.fiX.fjL.setScaleY(1.1f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fiX.fjL, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fiX.fjL, View.SCALE_Y, 1.1f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fiX.fjL, View.SCALE_X, 1.0f, 1.1f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fiX.fjL, View.SCALE_Y, 1.0f, 1.1f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(100L);
            animatorSet2.playTogether(ofFloat3, ofFloat4);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fiX.fjL, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.fiX.fjL, View.SCALE_Y, 1.1f, 1.0f);
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
