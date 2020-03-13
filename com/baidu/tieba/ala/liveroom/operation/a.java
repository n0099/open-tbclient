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
    private int Yx;
    private List<ag> awO;
    CustomMessageTask.CustomRunnable axH;
    private ViewGroup ewr;
    private FrameLayout fiA;
    private b fiB;
    private View.OnLayoutChangeListener fiC;
    private InterfaceC0465a fiD;
    private CustomMessageListener fiE;
    CustomMessageListener fiF;
    CustomMessageListener fiG;
    private CustomMessageListener fiH;
    private CustomMessageListener fiI;
    private CustomMessageListener fiJ;
    private AlaLiveBottomOperationView fiy;
    private com.baidu.tieba.ala.liveroom.data.a fiz;
    private Handler handler;
    private String otherParams;

    /* renamed from: com.baidu.tieba.ala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0465a {
        void bl(int i, int i2);

        void bm(int i, int i2);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.fiE = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.12
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
                    ap apVar = com.baidu.live.v.a.zl().axD;
                    if (apVar != null && (bhVar = apVar.acT) != null) {
                        str = bhVar.aeK;
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
        this.fiF = new CustomMessageListener(2913111) { // from class: com.baidu.tieba.ala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fiy != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) customResponsedMessage.getData();
                    int i = getVideoGoodsListHttpResponseMessage.count;
                    if (i <= 0) {
                        a.this.fiy.ffg.setVisibility(8);
                        a.this.fiy.ffi.setVisibility(8);
                        a.this.fiy.ffi.setText("");
                    } else {
                        a.this.fiy.ffi.setText(i + "");
                        a.this.fiy.ffi.setVisibility(0);
                        a.this.fiy.ffg.setVisibility(0);
                        if (a.this.fiz != null && a.this.fiz.fav != null && a.this.fiz.fav.yO() != null && a.this.fiz.fav.yO().mLiveInfo != null) {
                            long j = a.this.fiz.fav.yO().mLiveInfo.live_id;
                            long j2 = a.this.fiz.fav.yO().mLiveInfo.room_id;
                            String str = a.this.fiz.fav.yO().mLiveInfo.feed_id;
                            if (!ILiveGoodsLogger.displayStoreIconMap.contains(Long.valueOf(j))) {
                                ILiveGoodsLogger.displayStoreIconMap.add(Long.valueOf(j));
                                LogManager.getLiveGoodsLogger().doDisplayStoreIconLog(j + "", j2 + "", str, a.this.otherParams);
                            }
                        }
                    }
                    a.this.awO = getVideoGoodsListHttpResponseMessage.awO;
                    if (getVideoGoodsListHttpResponseMessage.getOrginalMessage() != null && (getVideoGoodsListHttpResponseMessage.getOrginalMessage() instanceof h) && ((h) getVideoGoodsListHttpResponseMessage.getOrginalMessage()).awN && i > 0 && a.this.awO != null && a.this.awO.size() > 0) {
                        a.this.bpZ();
                    }
                }
            }
        };
        this.fiG = new CustomMessageListener(2913112) { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fiy != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaLiveInfoData)) {
                    AlaLiveInfoData alaLiveInfoData = (AlaLiveInfoData) customResponsedMessage.getData();
                    o.b(alaLiveInfoData.feed_id, alaLiveInfoData.live_id, true);
                }
            }
        };
        this.fiH = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fiy != null) {
                    a.this.fiy.a(false, null, a.this.xx());
                }
            }
        };
        this.fiI = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fiy != null && a.this.fiy.fjl != null) {
                    a.this.fiy.fjl.performClick();
                }
            }
        };
        this.axH = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.fiy != null && a.this.fiy.fjl != null) {
                        int[] iArr = new int[2];
                        a.this.fiy.fjl.getLocationOnScreen(iArr);
                        jSONObject.putOpt("turn_tab_x", Integer.valueOf(iArr[0]));
                        jSONObject.putOpt("turn_tab_y", Integer.valueOf(iArr[1]));
                    }
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_TURN_TAB_LOC, jSONObject.toString());
                } catch (JSONException e) {
                    return null;
                }
            }
        };
        this.fiJ = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.bqa();
            }
        };
        MessageManager.getInstance().registerListener(this.fiE);
        MessageManager.getInstance().registerListener(this.fiF);
        MessageManager.getInstance().registerListener(this.fiG);
        MessageManager.getInstance().registerListener(this.fiH);
        MessageManager.getInstance().registerListener(this.fiI);
        MessageManager.getInstance().registerListener(this.fiJ);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_TURN_TAB_LOC, this.axH);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void ja(boolean z) {
        if (this.fiy != null) {
            this.fiy.ja(z);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, int i, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.fiz = aVar;
            this.Yx = i;
            this.ewr = viewGroup;
            if (this.fiy == null) {
                this.fiy = new AlaLiveBottomOperationView(getPageContext().getPageActivity());
            }
            this.fiB = bVar;
            this.fiy.setOnLiveViewOperationBtnClickListener(bVar);
            this.fiy.getRootView().setId(a.g.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.fiy.getRootView()) >= 0) {
                viewGroup.removeView(this.fiy.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.fiy.getRootView().setBackgroundResource(a.f.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.fiy.getRootView().setBackgroundResource(a.d.sdk_transparent);
            }
            viewGroup.addView(this.fiy.getRootView(), layoutParams);
            if (this.fiA == null) {
                this.fiA = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.fiA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.m(view, 8);
                        }
                    }
                });
            }
            this.fiy.ffg.setVisibility(8);
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                bpU();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.fiy.fiT != null) {
                this.fiy.fiT.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.fiy != null && this.fiy.fjh != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds68));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds22);
                    layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds28);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds10) + UtilHelper.getStatusBarHeight();
                    }
                    layoutParams2.gravity = 53;
                    this.fiy.fjh.setVisibility(8);
                    if (this.fiy.fjh.getParent() != null && (this.fiy.fjh.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.fiy.fjh.getParent()).removeView(this.fiy.fjh);
                    }
                    aVar.fau.getLiveContainerView().addView(this.fiy.fjh, layoutParams2);
                    return;
                }
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds96));
                layoutParams3.gravity = 83;
                if (this.fiA.getParent() != null && (this.fiA.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.fiA.getParent()).removeView(this.fiA);
                }
                aVar.fau.getLiveContainerView().addView(this.fiA, layoutParams3);
            }
        }
    }

    private void bpU() {
        bd bdVar;
        ay ayVar;
        if (this.fiC != null) {
            this.fiy.fjl.removeOnLayoutChangeListener(this.fiC);
        }
        ap apVar = com.baidu.live.v.a.zl().axD;
        if (apVar != null && (bdVar = apVar.acV) != null && bdVar.aeB && (ayVar = apVar.acS) != null && ayVar.adQ != null && !TextUtils.isEmpty(ayVar.adQ.webUrl)) {
            this.fiy.fjl.setVisibility(0);
            this.fiy.fjm.setVisibility(0);
            this.fiy.fjn.setVisibility(8);
            return;
        }
        this.fiy.fjl.setVisibility(8);
    }

    public void a(InterfaceC0465a interfaceC0465a) {
        if (this.fiy != null && this.fiy.fjl != null && this.fiy.fjl.getVisibility() == 0) {
            this.fiD = interfaceC0465a;
            this.fiC = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.bpV();
                }
            };
            this.fiy.fjl.addOnLayoutChangeListener(this.fiC);
            this.fiy.fjl.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.fiD != null) {
                        int[] iArr = new int[2];
                        a.this.fiy.fjl.getLocationInWindow(iArr);
                        a.this.fiD.bl((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.fiy.fjl.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.fiy.fjl.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpV() {
        if (this.fiy != null && this.fiy.fjl != null && this.fiy.fjl.getVisibility() == 0) {
            this.fiy.fjl.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.fiy != null && a.this.fiy.fjl != null && a.this.fiy.fjl.getVisibility() == 0 && a.this.fiD != null) {
                        int[] iArr = new int[2];
                        a.this.fiy.fjl.getLocationInWindow(iArr);
                        a.this.fiD.bm((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.fiy.fjl.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.fiy.fjl.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.fiy != null && this.fiy.fjl != null && this.fiy.fjl.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.fiy.fjm.getVisibility() == 0) {
                    this.fiy.fjm.setVisibility(8);
                }
                if (this.fiy.fjn.getVisibility() != 0) {
                    this.fiy.fjn.setVisibility(0);
                }
                this.fiy.fjn.setTimer(str, f);
                return;
            }
            if (this.fiy.fjm.getVisibility() != 0) {
                this.fiy.fjm.setVisibility(0);
            }
            if (this.fiy.fjn.getVisibility() == 0) {
                this.fiy.fjn.setVisibility(8);
            }
        }
    }

    public void bpW() {
        if (this.fiy != null && this.fiy.fjl != null && this.fiC != null) {
            this.fiy.fjl.removeOnLayoutChangeListener(this.fiC);
        }
        if (this.ewr != null && this.fiy != null && this.ewr.indexOfChild(this.fiy.getRootView()) > 0) {
            this.ewr.removeView(this.fiy.getRootView());
        }
        if (this.fiA != null && (this.fiA.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fiA.getParent()).removeView(this.fiA);
        }
        if (this.fiy != null && this.fiy.fjh != null && (this.fiy.fjh.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fiy.fjh.getParent()).removeView(this.fiy.fjh);
        }
    }

    public void setVisibility(int i) {
        if (this.fiy != null && this.fiy.getRootView() != null) {
            this.fiy.getRootView().setVisibility(i);
        }
        if (this.fiA != null) {
            this.fiA.setVisibility(i);
        }
    }

    public void a(com.baidu.live.gift.o oVar, m mVar) {
        if (this.fiy != null) {
            if (mVar != null && mVar.Ye != null) {
                this.fiy.a(mVar.Ye.isNewUser, mVar.mLiveInfo, xx());
            } else {
                this.fiy.a(false, null, xx());
            }
            if (oVar == null || TextUtils.isEmpty(oVar.sw()) || oVar.sv() != 1) {
                this.fiy.fiR.setVisibility(8);
                return;
            }
            this.fiy.fiR.setVisibility(0);
            this.fiy.fiQ.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.fiy.fiQ.startLoad(oVar.sw(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.fiy.fji.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.fiy.fiR.setVisibility(8);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (oVar.su() != null) {
                    alaStaticItem.addParams("gifts_value", oVar.su().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, oVar.su().rx());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, oVar.su().ry());
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

    public String xx() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void bpX() {
        if (this.fiy != null) {
            this.fiy.setMsgLayoutWidth(false);
            this.fiy.fjo.setVisibility(8);
            this.fiy.fjp.setVisibility(8);
        }
    }

    public void bpY() {
        if (this.fiy != null) {
            this.fiy.setMsgLayoutWidth(true);
            this.fiy.fjo.setVisibility(0);
            this.fiy.fjp.setVisibility(0);
        }
    }

    public void j(int i, int i2, int i3) {
        if (this.fiy != null) {
            if (i3 == 2) {
                bpY();
            } else if (i3 == 1) {
                bpX();
            }
            bpV();
        }
    }

    public void qz(int i) {
        if (this.fiy != null && this.fiy.fjh != null) {
            this.fiy.fjh.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, long j) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.fiy != null && this.fiy.fiP != null) {
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
            if (this.ewr != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (a.this.ewr != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout = a.this.fiy.fiP;
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
                            a.this.ewr.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.14
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.ewr != null) {
                            a.this.ewr.removeView(inflate);
                        }
                    }
                }, 3000 + j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpZ() {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.fiy != null && this.fiy.fiP != null && this.awO != null && !this.awO.isEmpty()) {
            try {
                ag agVar = this.awO.get((int) (Math.random() * this.awO.size()));
                final View inflate = getPageContext().getPageActivity().getLayoutInflater().inflate(a.h.toast_goods_guide, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) inflate.findViewById(a.g.conver_imageView);
                tbImageView.setDefaultBgResource(a.f.sdk_shape_transparent);
                if (!TextUtils.isEmpty(agVar.abR)) {
                    try {
                        JSONArray jSONArray = new JSONArray(agVar.abR);
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
                        if (a.this.ewr != null) {
                            a.this.ewr.removeView(inflate);
                        }
                        if (a.this.fiB != null) {
                            a.this.fiB.m(view, 15);
                        }
                        if (a.this.fiz != null && a.this.fiz.fav != null && a.this.fiz.fav.yO() != null && a.this.fiz.fav.yO().mLiveInfo != null) {
                            long j = a.this.fiz.fav.yO().mLiveInfo.live_id;
                            long j2 = a.this.fiz.fav.yO().mLiveInfo.room_id;
                            LogManager.getLiveGoodsLogger().doClickGoodsGuideLog(j + "", j2 + "", a.this.fiz.fav.yO().mLiveInfo.feed_id, a.this.otherParams);
                        }
                    }
                });
                if (this.ewr != null) {
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.16
                        @Override // java.lang.Runnable
                        public void run() {
                            Activity pageActivity;
                            if (a.this.ewr != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                                inflate.measure(0, 0);
                                View view = a.this.fiy.ffg;
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
                                a.this.ewr.addView(inflate, layoutParams);
                                if (a.this.fiz != null && a.this.fiz.fav != null && a.this.fiz.fav.yO() != null && a.this.fiz.fav.yO().mLiveInfo != null) {
                                    long j = a.this.fiz.fav.yO().mLiveInfo.live_id;
                                    long j2 = a.this.fiz.fav.yO().mLiveInfo.room_id;
                                    String str2 = a.this.fiz.fav.yO().mLiveInfo.feed_id;
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
                            if (a.this.ewr != null) {
                                a.this.ewr.removeView(inflate);
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
        if (this.fiy != null) {
            return this.fiy.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fiE);
        MessageManager.getInstance().unRegisterListener(this.fiF);
        MessageManager.getInstance().unRegisterListener(this.fiG);
        MessageManager.getInstance().unRegisterListener(this.fiH);
        MessageManager.getInstance().unRegisterListener(this.fiI);
        MessageManager.getInstance().unRegisterListener(this.fiJ);
        this.fiD = null;
        if (this.fiy != null) {
            if (this.fiC != null) {
                this.fiy.fjl.removeOnLayoutChangeListener(this.fiC);
            }
            this.fiy.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqa() {
        if (this.fiy != null && this.fiy.fjm != null) {
            this.fiy.fjm.setScaleX(1.1f);
            this.fiy.fjm.setScaleY(1.1f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fiy.fjm, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fiy.fjm, View.SCALE_Y, 1.1f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fiy.fjm, View.SCALE_X, 1.0f, 1.1f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fiy.fjm, View.SCALE_Y, 1.0f, 1.1f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(100L);
            animatorSet2.playTogether(ofFloat3, ofFloat4);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fiy.fjm, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.fiy.fjm, View.SCALE_Y, 1.1f, 1.0f);
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
