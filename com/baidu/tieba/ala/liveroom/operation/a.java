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
import com.baidu.live.data.ab;
import com.baidu.live.data.ak;
import com.baidu.live.data.as;
import com.baidu.live.data.ax;
import com.baidu.live.data.bb;
import com.baidu.live.data.k;
import com.baidu.live.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.message.h;
import com.baidu.live.q.a;
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
import com.baidu.live.utils.n;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private int Ws;
    private List<ab> arQ;
    private ViewGroup eqG;
    private AlaLiveBottomOperationView fbR;
    private com.baidu.tieba.ala.liveroom.data.a fbS;
    private FrameLayout fbT;
    private b fbU;
    private View.OnLayoutChangeListener fbV;
    private InterfaceC0451a fbW;
    private CustomMessageListener fbX;
    CustomMessageListener fbY;
    CustomMessageListener fbZ;
    private CustomMessageListener fca;
    private Handler handler;
    private String otherParams;

    /* renamed from: com.baidu.tieba.ala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0451a {
        void bg(int i, int i2);

        void bh(int i, int i2);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.fbX = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                bb bbVar;
                String str;
                long j;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                    j = 1000;
                } else {
                    ak akVar = com.baidu.live.r.a.wA().asy;
                    if (akVar != null && (bbVar = akVar.aaI) != null) {
                        str = bbVar.acv;
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
        this.fbY = new CustomMessageListener(2913111) { // from class: com.baidu.tieba.ala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fbR != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) customResponsedMessage.getData();
                    int i = getVideoGoodsListHttpResponseMessage.count;
                    if (i <= 0) {
                        a.this.fbR.eZd.setVisibility(8);
                        a.this.fbR.eZf.setVisibility(8);
                        a.this.fbR.eZf.setText("");
                    } else {
                        a.this.fbR.eZf.setText(i + "");
                        a.this.fbR.eZf.setVisibility(0);
                        a.this.fbR.eZd.setVisibility(0);
                        if (a.this.fbS != null && a.this.fbS.eUF != null && a.this.fbS.eUF.wf() != null && a.this.fbS.eUF.wf().mLiveInfo != null) {
                            long j = a.this.fbS.eUF.wf().mLiveInfo.live_id;
                            long j2 = a.this.fbS.eUF.wf().mLiveInfo.room_id;
                            String str = a.this.fbS.eUF.wf().mLiveInfo.feed_id;
                            if (!ILiveGoodsLogger.displayStoreIconMap.contains(Long.valueOf(j))) {
                                ILiveGoodsLogger.displayStoreIconMap.add(Long.valueOf(j));
                                LogManager.getLiveGoodsLogger().doDisplayStoreIconLog(j + "", j2 + "", str, a.this.otherParams);
                            }
                        }
                    }
                    a.this.arQ = getVideoGoodsListHttpResponseMessage.arQ;
                    if (getVideoGoodsListHttpResponseMessage.getOrginalMessage() != null && (getVideoGoodsListHttpResponseMessage.getOrginalMessage() instanceof h) && ((h) getVideoGoodsListHttpResponseMessage.getOrginalMessage()).arP && i > 0 && a.this.arQ != null && a.this.arQ.size() > 0) {
                        a.this.bnk();
                    }
                }
            }
        };
        this.fbZ = new CustomMessageListener(2913112) { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fbR != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaLiveInfoData)) {
                    AlaLiveInfoData alaLiveInfoData = (AlaLiveInfoData) customResponsedMessage.getData();
                    n.b(alaLiveInfoData.feed_id, alaLiveInfoData.live_id, true);
                }
            }
        };
        this.fca = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fbR != null) {
                    a.this.fbR.a(false, null, a.this.vi());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fbX);
        MessageManager.getInstance().registerListener(this.fbY);
        MessageManager.getInstance().registerListener(this.fbZ);
        MessageManager.getInstance().registerListener(this.fca);
    }

    public void iN(boolean z) {
        if (this.fbR != null) {
            this.fbR.iN(z);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, int i, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.fbS = aVar;
            this.Ws = i;
            this.eqG = viewGroup;
            if (this.fbR == null) {
                this.fbR = new AlaLiveBottomOperationView(getPageContext().getPageActivity());
            }
            this.fbU = bVar;
            this.fbR.setOnLiveViewOperationBtnClickListener(bVar);
            this.fbR.getRootView().setId(a.g.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.fbR.getRootView()) >= 0) {
                viewGroup.removeView(this.fbR.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.fbR.getRootView().setBackgroundResource(a.f.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.fbR.getRootView().setBackgroundResource(a.d.sdk_transparent);
            }
            viewGroup.addView(this.fbR.getRootView(), layoutParams);
            if (this.fbT == null) {
                this.fbT = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.fbT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.m(view, 8);
                        }
                    }
                });
            }
            this.fbR.eZd.setVisibility(8);
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                bnf();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.fbR.fck != null) {
                this.fbR.fck.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.fbR != null && this.fbR.fcy != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds68));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds22);
                    layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds28);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds10) + UtilHelper.getStatusBarHeight();
                    }
                    layoutParams2.gravity = 53;
                    this.fbR.fcy.setVisibility(8);
                    if (this.fbR.fcy.getParent() != null && (this.fbR.fcy.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.fbR.fcy.getParent()).removeView(this.fbR.fcy);
                    }
                    aVar.eUH.addView(this.fbR.fcy, layoutParams2);
                    return;
                }
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds96));
                layoutParams3.gravity = 83;
                if (this.fbT.getParent() != null && (this.fbT.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.fbT.getParent()).removeView(this.fbT);
                }
                aVar.eUH.addView(this.fbT, layoutParams3);
            }
        }
    }

    private void bnf() {
        ax axVar;
        as asVar;
        if (this.fbV != null) {
            this.fbR.fcC.removeOnLayoutChangeListener(this.fbV);
        }
        ak akVar = com.baidu.live.r.a.wA().asy;
        if (akVar != null && (axVar = akVar.aaK) != null && axVar.acn && (asVar = akVar.aaH) != null && asVar.abA != null && !TextUtils.isEmpty(asVar.abA.webUrl)) {
            this.fbR.fcC.setVisibility(0);
            this.fbR.fcD.setVisibility(0);
            this.fbR.fcE.setVisibility(8);
            return;
        }
        this.fbR.fcC.setVisibility(8);
    }

    public void a(InterfaceC0451a interfaceC0451a) {
        if (this.fbR != null && this.fbR.fcC != null && this.fbR.fcC.getVisibility() == 0) {
            this.fbW = interfaceC0451a;
            this.fbV = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.bng();
                }
            };
            this.fbR.fcC.addOnLayoutChangeListener(this.fbV);
            this.fbR.fcC.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.fbW != null) {
                        int[] iArr = new int[2];
                        a.this.fbR.fcC.getLocationInWindow(iArr);
                        a.this.fbW.bg((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.fbR.fcC.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.fbR.fcC.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bng() {
        if (this.fbR != null && this.fbR.fcC != null && this.fbR.fcC.getVisibility() == 0) {
            this.fbR.fcC.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.fbR != null && a.this.fbR.fcC != null && a.this.fbR.fcC.getVisibility() == 0 && a.this.fbW != null) {
                        int[] iArr = new int[2];
                        a.this.fbR.fcC.getLocationInWindow(iArr);
                        a.this.fbW.bh((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.fbR.fcC.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.fbR.fcC.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.fbR != null && this.fbR.fcC != null && this.fbR.fcC.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.fbR.fcD.getVisibility() == 0) {
                    this.fbR.fcD.setVisibility(8);
                }
                if (this.fbR.fcE.getVisibility() != 0) {
                    this.fbR.fcE.setVisibility(0);
                }
                this.fbR.fcE.setTimer(str, f);
                return;
            }
            if (this.fbR.fcD.getVisibility() != 0) {
                this.fbR.fcD.setVisibility(0);
            }
            if (this.fbR.fcE.getVisibility() == 0) {
                this.fbR.fcE.setVisibility(8);
            }
        }
    }

    public void bnh() {
        if (this.fbR != null && this.fbR.fcC != null && this.fbV != null) {
            this.fbR.fcC.removeOnLayoutChangeListener(this.fbV);
        }
        if (this.eqG != null && this.fbR != null && this.eqG.indexOfChild(this.fbR.getRootView()) > 0) {
            this.eqG.removeView(this.fbR.getRootView());
        }
        if (this.fbT != null && (this.fbT.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fbT.getParent()).removeView(this.fbT);
        }
        if (this.fbR != null && this.fbR.fcy != null && (this.fbR.fcy.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fbR.fcy.getParent()).removeView(this.fbR.fcy);
        }
    }

    public void setVisibility(int i) {
        if (this.fbR != null && this.fbR.getRootView() != null) {
            this.fbR.getRootView().setVisibility(i);
        }
        if (this.fbT != null) {
            this.fbT.setVisibility(i);
        }
    }

    public void a(com.baidu.live.gift.n nVar, k kVar) {
        if (this.fbR != null) {
            if (kVar != null && kVar.Wc != null) {
                this.fbR.a(kVar.Wc.isNewUser, kVar.mLiveInfo, vi());
            } else {
                this.fbR.a(false, null, vi());
            }
            if (nVar == null || TextUtils.isEmpty(nVar.rj()) || nVar.ri() != 1) {
                this.fbR.fci.setVisibility(8);
                return;
            }
            this.fbR.fci.setVisibility(0);
            this.fbR.fch.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.fbR.fch.startLoad(nVar.rj(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.fbR.fcz.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.fbR.fci.setVisibility(8);
            }
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
            if (nVar.rh() != null) {
                alaStaticItem.addParams("gifts_value", nVar.rh().getPrice());
                alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, nVar.rh().qx());
                alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, nVar.rh().qy());
            }
            if (kVar != null && kVar.mLiveInfo != null) {
                alaStaticItem.addParams("feed_id", kVar.mLiveInfo.feed_id);
                alaStaticItem.addParams("room_id", kVar.mLiveInfo.room_id);
            }
            alaStaticItem.addParams("other_params", this.otherParams);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    public String vi() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void bni() {
        if (this.fbR != null) {
            this.fbR.setMsgLayoutWidth(false);
            this.fbR.fcF.setVisibility(8);
            this.fbR.fcG.setVisibility(8);
        }
    }

    public void bnj() {
        if (this.fbR != null) {
            this.fbR.setMsgLayoutWidth(true);
            this.fbR.fcF.setVisibility(0);
            this.fbR.fcG.setVisibility(0);
        }
    }

    public void E(int i, int i2, int i3) {
        if (this.fbR != null) {
            if (i3 == 2) {
                bnj();
            } else if (i3 == 1) {
                bni();
            }
            bng();
        }
    }

    public void qn(int i) {
        if (this.fbR != null && this.fbR.fcy != null) {
            this.fbR.fcy.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, long j) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.fbR != null && this.fbR.fcg != null) {
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
            if (this.eqG != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (a.this.eqG != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout = a.this.fbR.fcg;
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
                            a.this.eqG.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.eqG != null) {
                            a.this.eqG.removeView(inflate);
                        }
                    }
                }, 3000 + j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnk() {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.fbR != null && this.fbR.fcg != null && this.arQ != null && !this.arQ.isEmpty()) {
            try {
                ab abVar = this.arQ.get((int) (Math.random() * this.arQ.size()));
                final View inflate = getPageContext().getPageActivity().getLayoutInflater().inflate(a.h.toast_goods_guide, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) inflate.findViewById(a.g.conver_imageView);
                tbImageView.setDefaultBgResource(a.f.sdk_shape_transparent);
                if (!TextUtils.isEmpty(abVar.ZJ)) {
                    try {
                        JSONArray jSONArray = new JSONArray(abVar.ZJ);
                        if (jSONArray.length() > 0) {
                            tbImageView.startLoad(jSONArray.optJSONObject(0).optString(UserAccountActionItem.KEY_SRC), 10, false);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                TextView textView = (TextView) inflate.findViewById(a.g.title_textView);
                TextView textView2 = (TextView) inflate.findViewById(a.g.price_textView);
                String str = abVar.title;
                if (str == null) {
                    str = "";
                } else if (str.length() > 8) {
                    str = str.substring(0, 8) + StringHelper.STRING_MORE;
                }
                textView.setText(str);
                textView2.setText(abVar.price);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.handler.removeCallbacksAndMessages(null);
                        if (a.this.eqG != null) {
                            a.this.eqG.removeView(inflate);
                        }
                        if (a.this.fbU != null) {
                            a.this.fbU.m(view, 15);
                        }
                        if (a.this.fbS != null && a.this.fbS.eUF != null && a.this.fbS.eUF.wf() != null && a.this.fbS.eUF.wf().mLiveInfo != null) {
                            long j = a.this.fbS.eUF.wf().mLiveInfo.live_id;
                            long j2 = a.this.fbS.eUF.wf().mLiveInfo.room_id;
                            LogManager.getLiveGoodsLogger().doClickGoodsGuideLog(j + "", j2 + "", a.this.fbS.eUF.wf().mLiveInfo.feed_id, a.this.otherParams);
                        }
                    }
                });
                if (this.eqG != null) {
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.13
                        @Override // java.lang.Runnable
                        public void run() {
                            Activity pageActivity;
                            if (a.this.eqG != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                                inflate.measure(0, 0);
                                View view = a.this.fbR.eZd;
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
                                a.this.eqG.addView(inflate, layoutParams);
                                if (a.this.fbS != null && a.this.fbS.eUF != null && a.this.fbS.eUF.wf() != null && a.this.fbS.eUF.wf().mLiveInfo != null) {
                                    long j = a.this.fbS.eUF.wf().mLiveInfo.live_id;
                                    long j2 = a.this.fbS.eUF.wf().mLiveInfo.room_id;
                                    String str2 = a.this.fbS.eUF.wf().mLiveInfo.feed_id;
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
                            if (a.this.eqG != null) {
                                a.this.eqG.removeView(inflate);
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
        if (this.fbR != null) {
            return this.fbR.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fbX);
        MessageManager.getInstance().unRegisterListener(this.fbY);
        MessageManager.getInstance().unRegisterListener(this.fbZ);
        MessageManager.getInstance().unRegisterListener(this.fca);
        this.fbW = null;
        if (this.fbR != null) {
            if (this.fbV != null) {
                this.fbR.fcC.removeOnLayoutChangeListener(this.fbV);
            }
            this.fbR.onDestory();
        }
    }
}
