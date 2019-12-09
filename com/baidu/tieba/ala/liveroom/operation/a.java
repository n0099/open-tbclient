package com.baidu.tieba.ala.liveroom.operation;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.af;
import com.baidu.live.data.al;
import com.baidu.live.data.ap;
import com.baidu.live.data.as;
import com.baidu.live.data.i;
import com.baidu.live.data.y;
import com.baidu.live.gift.l;
import com.baidu.live.k.a;
import com.baidu.live.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.message.f;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
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
import com.baidu.live.utils.m;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private int Pw;
    private List<y> ajS;
    private ViewGroup dYe;
    private com.baidu.tieba.ala.liveroom.data.a elA;
    private FrameLayout elB;
    private b elC;
    private View.OnLayoutChangeListener elD;
    private InterfaceC0364a elE;
    private CustomMessageListener elF;
    CustomMessageListener elG;
    CustomMessageListener elH;
    private CustomMessageListener elI;
    private AlaLiveBottomOperationView elz;
    private Handler handler;
    private String otherParams;

    /* renamed from: com.baidu.tieba.ala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0364a {
        void aQ(int i, int i2);

        void aR(int i, int i2);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.elF = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                as asVar;
                String str;
                long j;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                    j = 1000;
                } else {
                    af afVar = com.baidu.live.l.a.uB().aku;
                    if (afVar != null && (asVar = afVar.TL) != null) {
                        str = asVar.UZ;
                        j = 3000;
                    } else {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.v(str, j);
                }
            }
        };
        this.elG = new CustomMessageListener(2913111) { // from class: com.baidu.tieba.ala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.elz != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) customResponsedMessage.getData();
                    int i = getVideoGoodsListHttpResponseMessage.count;
                    if (i <= 0) {
                        a.this.elz.eiS.setVisibility(8);
                        a.this.elz.eiU.setVisibility(8);
                        a.this.elz.eiU.setText("");
                    } else {
                        a.this.elz.eiU.setText(i + "");
                        a.this.elz.eiU.setVisibility(0);
                        a.this.elz.eiS.setVisibility(0);
                        if (a.this.elA != null && a.this.elA.eeL != null && a.this.elA.eeL.uk() != null && a.this.elA.eeL.uk().mLiveInfo != null) {
                            long j = a.this.elA.eeL.uk().mLiveInfo.live_id;
                            long j2 = a.this.elA.eeL.uk().mLiveInfo.room_id;
                            String str = a.this.elA.eeL.uk().mLiveInfo.feed_id;
                            if (!ILiveGoodsLogger.displayStoreIconMap.contains(Long.valueOf(j))) {
                                ILiveGoodsLogger.displayStoreIconMap.add(Long.valueOf(j));
                                LogManager.getLiveGoodsLogger().doDisplayStoreIconLog(j + "", j2 + "", str, a.this.otherParams);
                            }
                        }
                    }
                    a.this.ajS = getVideoGoodsListHttpResponseMessage.ajS;
                    if (getVideoGoodsListHttpResponseMessage.getOrginalMessage() != null && (getVideoGoodsListHttpResponseMessage.getOrginalMessage() instanceof f) && ((f) getVideoGoodsListHttpResponseMessage.getOrginalMessage()).ajR && i > 0 && a.this.ajS != null && a.this.ajS.size() > 0) {
                        a.this.aVs();
                    }
                }
            }
        };
        this.elH = new CustomMessageListener(2913112) { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.elz != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaLiveInfoData)) {
                    AlaLiveInfoData alaLiveInfoData = (AlaLiveInfoData) customResponsedMessage.getData();
                    m.a(alaLiveInfoData.feed_id, alaLiveInfoData.live_id, true);
                }
            }
        };
        this.elI = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.elz != null) {
                    a.this.elz.a(false, null, a.this.tn());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.elF);
        MessageManager.getInstance().registerListener(this.elG);
        MessageManager.getInstance().registerListener(this.elH);
        MessageManager.getInstance().registerListener(this.elI);
    }

    public void hz(boolean z) {
        if (this.elz != null) {
            this.elz.hz(z);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, int i, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.elA = aVar;
            this.Pw = i;
            this.dYe = viewGroup;
            if (this.elz == null) {
                this.elz = new AlaLiveBottomOperationView(getPageContext().getPageActivity());
            }
            this.elC = bVar;
            this.elz.setOnLiveViewOperationBtnClickListener(bVar);
            this.elz.getRootView().setId(a.g.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.elz.getRootView()) >= 0) {
                viewGroup.removeView(this.elz.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.elz.getRootView().setBackgroundResource(a.f.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.elz.getRootView().setBackgroundResource(a.d.sdk_transparent);
            }
            viewGroup.addView(this.elz.getRootView(), layoutParams);
            if (this.elB == null) {
                this.elB = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.elB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.n(view, 8);
                        }
                    }
                });
            }
            this.elz.eiS.setVisibility(8);
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                aVn();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.elz.elS != null) {
                this.elz.elS.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) && this.elz != null && this.elz.emg != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds68));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds22);
                    layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds28);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds10) + UtilHelper.getStatusBarHeight();
                    }
                    layoutParams2.gravity = 53;
                    this.elz.emg.setVisibility(8);
                    if (this.elz.emg.getParent() != null && (this.elz.emg.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.elz.emg.getParent()).removeView(this.elz.emg);
                    }
                    aVar.eeN.addView(this.elz.emg, layoutParams2);
                    return;
                }
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds96));
                layoutParams3.gravity = 83;
                if (this.elB.getParent() != null && (this.elB.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.elB.getParent()).removeView(this.elB);
                }
                aVar.eeN.addView(this.elB, layoutParams3);
            }
        }
    }

    private void aVn() {
        ap apVar;
        al alVar;
        if (this.elD != null) {
            this.elz.emk.removeOnLayoutChangeListener(this.elD);
        }
        af afVar = com.baidu.live.l.a.uB().aku;
        if (afVar != null && (apVar = afVar.TO) != null && apVar.UV && (alVar = afVar.TK) != null && alVar.Us != null && !TextUtils.isEmpty(alVar.Us.webUrl)) {
            this.elz.emk.setVisibility(0);
            this.elz.eml.setVisibility(0);
            this.elz.emm.setVisibility(8);
            return;
        }
        this.elz.emk.setVisibility(8);
    }

    public void a(InterfaceC0364a interfaceC0364a) {
        if (this.elz != null && this.elz.emk != null && this.elz.emk.getVisibility() == 0) {
            this.elE = interfaceC0364a;
            this.elD = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.aVo();
                }
            };
            this.elz.emk.addOnLayoutChangeListener(this.elD);
            this.elz.emk.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.elE != null) {
                        int[] iArr = new int[2];
                        a.this.elz.emk.getLocationInWindow(iArr);
                        a.this.elE.aQ((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.elz.emk.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.elz.emk.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVo() {
        if (this.elz != null && this.elz.emk != null && this.elz.emk.getVisibility() == 0) {
            this.elz.emk.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.elz != null && a.this.elz.emk != null && a.this.elz.emk.getVisibility() == 0 && a.this.elE != null) {
                        int[] iArr = new int[2];
                        a.this.elz.emk.getLocationInWindow(iArr);
                        a.this.elE.aR((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.elz.emk.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.elz.emk.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.elz != null && this.elz.emk != null && this.elz.emk.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.elz.eml.getVisibility() == 0) {
                    this.elz.eml.setVisibility(8);
                }
                if (this.elz.emm.getVisibility() != 0) {
                    this.elz.emm.setVisibility(0);
                }
                this.elz.emm.setTimer(str, f);
                return;
            }
            if (this.elz.eml.getVisibility() != 0) {
                this.elz.eml.setVisibility(0);
            }
            if (this.elz.emm.getVisibility() == 0) {
                this.elz.emm.setVisibility(8);
            }
        }
    }

    public void aVp() {
        if (this.elz != null && this.elz.emk != null && this.elD != null) {
            this.elz.emk.removeOnLayoutChangeListener(this.elD);
        }
        if (this.dYe != null && this.elz != null && this.dYe.indexOfChild(this.elz.getRootView()) > 0) {
            this.dYe.removeView(this.elz.getRootView());
        }
        if (this.elB != null && (this.elB.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.elB.getParent()).removeView(this.elB);
        }
        if (this.elz != null && this.elz.emg != null && (this.elz.emg.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.elz.emg.getParent()).removeView(this.elz.emg);
        }
    }

    public void setVisibility(int i) {
        if (this.elz != null && this.elz.getRootView() != null) {
            this.elz.getRootView().setVisibility(i);
        }
        if (this.elB != null) {
            this.elB.setVisibility(i);
        }
    }

    public void a(l lVar, i iVar) {
        if (this.elz != null) {
            if (iVar != null && iVar.Pj != null) {
                this.elz.a(iVar.Pj.isNewUser, iVar.mLiveInfo, tn());
            } else {
                this.elz.a(false, null, tn());
            }
            if (lVar == null || TextUtils.isEmpty(lVar.pH()) || lVar.pG() != 1) {
                this.elz.elQ.setVisibility(8);
                return;
            }
            this.elz.elQ.setVisibility(0);
            this.elz.elP.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.elz.elP.startLoad(lVar.pH(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.elz.emh.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.elz.elQ.setVisibility(8);
            }
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
            if (lVar.pF() != null) {
                alaStaticItem.addParams("gifts_value", lVar.pF().getPrice());
                alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, lVar.pF().pc());
                alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, lVar.pF().pd());
            }
            if (iVar != null && iVar.mLiveInfo != null) {
                alaStaticItem.addParams("feed_id", iVar.mLiveInfo.feed_id);
                alaStaticItem.addParams("room_id", iVar.mLiveInfo.room_id);
            }
            alaStaticItem.addParams("other_params", this.otherParams);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    public String tn() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void aVq() {
        if (this.elz != null) {
            this.elz.setMsgLayoutWidth(false);
            this.elz.emn.setVisibility(8);
            this.elz.emo.setVisibility(8);
        }
    }

    public void aVr() {
        if (this.elz != null) {
            this.elz.setMsgLayoutWidth(true);
            this.elz.emn.setVisibility(0);
            this.elz.emo.setVisibility(0);
        }
    }

    public void E(int i, int i2, int i3) {
        if (this.elz != null) {
            if (i3 == 2) {
                aVr();
            } else if (i3 == 1) {
                aVq();
            }
            aVo();
        }
    }

    public void nW(int i) {
        if (this.elz != null && this.elz.emg != null) {
            this.elz.emg.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, long j) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.elz != null && this.elz.elO != null) {
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
            if (this.dYe != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (a.this.dYe != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout = a.this.elz.elO;
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
                            a.this.dYe.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.dYe != null) {
                            a.this.dYe.removeView(inflate);
                        }
                    }
                }, 3000 + j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVs() {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.elz != null && this.elz.elO != null && this.ajS != null && !this.ajS.isEmpty()) {
            try {
                y yVar = this.ajS.get((int) (Math.random() * this.ajS.size()));
                final View inflate = getPageContext().getPageActivity().getLayoutInflater().inflate(a.h.toast_goods_guide, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) inflate.findViewById(a.g.conver_imageView);
                tbImageView.setDefaultBgResource(a.f.sdk_shape_transparent);
                if (!TextUtils.isEmpty(yVar.SS)) {
                    try {
                        JSONArray jSONArray = new JSONArray(yVar.SS);
                        if (jSONArray.length() > 0) {
                            tbImageView.startLoad(jSONArray.optJSONObject(0).optString("src"), 10, false);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                TextView textView = (TextView) inflate.findViewById(a.g.title_textView);
                TextView textView2 = (TextView) inflate.findViewById(a.g.price_textView);
                String str = yVar.title;
                if (str == null) {
                    str = "";
                } else if (str.length() > 8) {
                    str = str.substring(0, 8) + StringHelper.STRING_MORE;
                }
                textView.setText(str);
                textView2.setText(yVar.price);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.handler.removeCallbacksAndMessages(null);
                        if (a.this.dYe != null) {
                            a.this.dYe.removeView(inflate);
                        }
                        if (a.this.elC != null) {
                            a.this.elC.n(view, 15);
                        }
                        if (a.this.elA != null && a.this.elA.eeL != null && a.this.elA.eeL.uk() != null && a.this.elA.eeL.uk().mLiveInfo != null) {
                            long j = a.this.elA.eeL.uk().mLiveInfo.live_id;
                            long j2 = a.this.elA.eeL.uk().mLiveInfo.room_id;
                            LogManager.getLiveGoodsLogger().doClickGoodsGuideLog(j + "", j2 + "", a.this.elA.eeL.uk().mLiveInfo.feed_id, a.this.otherParams);
                        }
                    }
                });
                if (this.dYe != null) {
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.13
                        @Override // java.lang.Runnable
                        public void run() {
                            Activity pageActivity;
                            if (a.this.dYe != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                                inflate.measure(0, 0);
                                View view = a.this.elz.eiS;
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
                                a.this.dYe.addView(inflate, layoutParams);
                                if (a.this.elA != null && a.this.elA.eeL != null && a.this.elA.eeL.uk() != null && a.this.elA.eeL.uk().mLiveInfo != null) {
                                    long j = a.this.elA.eeL.uk().mLiveInfo.live_id;
                                    long j2 = a.this.elA.eeL.uk().mLiveInfo.room_id;
                                    String str2 = a.this.elA.eeL.uk().mLiveInfo.feed_id;
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
                            if (a.this.dYe != null) {
                                a.this.dYe.removeView(inflate);
                            }
                        }
                    }, 3200L);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public ImageView getLandscapeBarrageImageView() {
        if (this.elz != null) {
            return this.elz.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.elF);
        MessageManager.getInstance().unRegisterListener(this.elG);
        MessageManager.getInstance().unRegisterListener(this.elH);
        MessageManager.getInstance().unRegisterListener(this.elI);
        this.elE = null;
        if (this.elz != null) {
            if (this.elD != null) {
                this.elz.emk.removeOnLayoutChangeListener(this.elD);
            }
            this.elz.onDestory();
        }
    }
}
