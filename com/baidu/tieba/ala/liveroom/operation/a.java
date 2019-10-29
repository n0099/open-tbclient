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
    private int Qc;
    private List<y> akk;
    private ViewGroup dYV;
    private AlaLiveBottomOperationView emq;
    private com.baidu.tieba.ala.liveroom.data.a emr;
    private FrameLayout ems;
    private b emt;
    private View.OnLayoutChangeListener emu;
    private InterfaceC0369a emv;
    private CustomMessageListener emw;
    CustomMessageListener emx;
    CustomMessageListener emy;
    private CustomMessageListener emz;
    private Handler handler;
    private String otherParams;

    /* renamed from: com.baidu.tieba.ala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0369a {
        void aS(int i, int i2);

        void aT(int i, int i2);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.emw = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
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
                    af afVar = com.baidu.live.l.a.uA().akM;
                    if (afVar != null && (asVar = afVar.Uf) != null) {
                        str = asVar.Vs;
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
        this.emx = new CustomMessageListener(2913111) { // from class: com.baidu.tieba.ala.liveroom.operation.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.emq != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) customResponsedMessage.getData();
                    int i = getVideoGoodsListHttpResponseMessage.count;
                    if (i <= 0) {
                        a.this.emq.ejJ.setVisibility(8);
                        a.this.emq.ejL.setVisibility(8);
                        a.this.emq.ejL.setText("");
                    } else {
                        a.this.emq.ejL.setText(i + "");
                        a.this.emq.ejL.setVisibility(0);
                        a.this.emq.ejJ.setVisibility(0);
                        if (a.this.emr != null && a.this.emr.efC != null && a.this.emr.efC.uj() != null && a.this.emr.efC.uj().mLiveInfo != null) {
                            long j = a.this.emr.efC.uj().mLiveInfo.live_id;
                            long j2 = a.this.emr.efC.uj().mLiveInfo.room_id;
                            String str = a.this.emr.efC.uj().mLiveInfo.feed_id;
                            if (!ILiveGoodsLogger.displayStoreIconMap.contains(Long.valueOf(j))) {
                                ILiveGoodsLogger.displayStoreIconMap.add(Long.valueOf(j));
                                LogManager.getLiveGoodsLogger().doDisplayStoreIconLog(j + "", j2 + "", str, a.this.otherParams);
                            }
                        }
                    }
                    a.this.akk = getVideoGoodsListHttpResponseMessage.akk;
                    if (getVideoGoodsListHttpResponseMessage.getOrginalMessage() != null && (getVideoGoodsListHttpResponseMessage.getOrginalMessage() instanceof f) && ((f) getVideoGoodsListHttpResponseMessage.getOrginalMessage()).akj && i > 0 && a.this.akk != null && a.this.akk.size() > 0) {
                        a.this.aVu();
                    }
                }
            }
        };
        this.emy = new CustomMessageListener(2913112) { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.emq != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaLiveInfoData)) {
                    AlaLiveInfoData alaLiveInfoData = (AlaLiveInfoData) customResponsedMessage.getData();
                    m.a(alaLiveInfoData.feed_id, alaLiveInfoData.live_id, true);
                }
            }
        };
        this.emz = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.emq != null) {
                    a.this.emq.a(false, null, a.this.tm());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.emw);
        MessageManager.getInstance().registerListener(this.emx);
        MessageManager.getInstance().registerListener(this.emy);
        MessageManager.getInstance().registerListener(this.emz);
    }

    public void hz(boolean z) {
        if (this.emq != null) {
            this.emq.hz(z);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, int i, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.emr = aVar;
            this.Qc = i;
            this.dYV = viewGroup;
            if (this.emq == null) {
                this.emq = new AlaLiveBottomOperationView(getPageContext().getPageActivity());
            }
            this.emt = bVar;
            this.emq.setOnLiveViewOperationBtnClickListener(bVar);
            this.emq.getRootView().setId(a.g.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.emq.getRootView()) >= 0) {
                viewGroup.removeView(this.emq.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.emq.getRootView().setBackgroundResource(a.f.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.emq.getRootView().setBackgroundResource(a.d.sdk_transparent);
            }
            viewGroup.addView(this.emq.getRootView(), layoutParams);
            if (this.ems == null) {
                this.ems = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.ems.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.n(view, 8);
                        }
                    }
                });
            }
            this.emq.ejJ.setVisibility(8);
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                aVp();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.emq.emJ != null) {
                this.emq.emJ.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) && this.emq != null && this.emq.emX != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds68));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds22);
                    layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds28);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds10) + UtilHelper.getStatusBarHeight();
                    }
                    layoutParams2.gravity = 53;
                    this.emq.emX.setVisibility(8);
                    if (this.emq.emX.getParent() != null && (this.emq.emX.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.emq.emX.getParent()).removeView(this.emq.emX);
                    }
                    aVar.efE.addView(this.emq.emX, layoutParams2);
                    return;
                }
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds96));
                layoutParams3.gravity = 83;
                if (this.ems.getParent() != null && (this.ems.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.ems.getParent()).removeView(this.ems);
                }
                aVar.efE.addView(this.ems, layoutParams3);
            }
        }
    }

    private void aVp() {
        ap apVar;
        al alVar;
        if (this.emu != null) {
            this.emq.enb.removeOnLayoutChangeListener(this.emu);
        }
        af afVar = com.baidu.live.l.a.uA().akM;
        if (afVar != null && (apVar = afVar.Uh) != null && apVar.Vo && (alVar = afVar.Ue) != null && alVar.UN != null && !TextUtils.isEmpty(alVar.UN.webUrl)) {
            this.emq.enb.setVisibility(0);
            this.emq.enc.setVisibility(0);
            this.emq.ene.setVisibility(8);
            return;
        }
        this.emq.enb.setVisibility(8);
    }

    public void a(InterfaceC0369a interfaceC0369a) {
        if (this.emq != null && this.emq.enb != null && this.emq.enb.getVisibility() == 0) {
            this.emv = interfaceC0369a;
            this.emu = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.aVq();
                }
            };
            this.emq.enb.addOnLayoutChangeListener(this.emu);
            this.emq.enb.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.emv != null) {
                        int[] iArr = new int[2];
                        a.this.emq.enb.getLocationInWindow(iArr);
                        a.this.emv.aS((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.emq.enb.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.emq.enb.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVq() {
        if (this.emq != null && this.emq.enb != null && this.emq.enb.getVisibility() == 0) {
            this.emq.enb.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.emq != null && a.this.emq.enb != null && a.this.emq.enb.getVisibility() == 0 && a.this.emv != null) {
                        int[] iArr = new int[2];
                        a.this.emq.enb.getLocationInWindow(iArr);
                        a.this.emv.aT((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.emq.enb.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.emq.enb.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.emq != null && this.emq.enb != null && this.emq.enb.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.emq.enc.getVisibility() == 0) {
                    this.emq.enc.setVisibility(8);
                }
                if (this.emq.ene.getVisibility() != 0) {
                    this.emq.ene.setVisibility(0);
                }
                this.emq.ene.setTimer(str, f);
                return;
            }
            if (this.emq.enc.getVisibility() != 0) {
                this.emq.enc.setVisibility(0);
            }
            if (this.emq.ene.getVisibility() == 0) {
                this.emq.ene.setVisibility(8);
            }
        }
    }

    public void aVr() {
        if (this.emq != null && this.emq.enb != null && this.emu != null) {
            this.emq.enb.removeOnLayoutChangeListener(this.emu);
        }
        if (this.dYV != null && this.emq != null && this.dYV.indexOfChild(this.emq.getRootView()) > 0) {
            this.dYV.removeView(this.emq.getRootView());
        }
        if (this.ems != null && (this.ems.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ems.getParent()).removeView(this.ems);
        }
        if (this.emq != null && this.emq.emX != null && (this.emq.emX.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.emq.emX.getParent()).removeView(this.emq.emX);
        }
    }

    public void setVisibility(int i) {
        if (this.emq != null && this.emq.getRootView() != null) {
            this.emq.getRootView().setVisibility(i);
        }
        if (this.ems != null) {
            this.ems.setVisibility(i);
        }
    }

    public void a(l lVar, i iVar) {
        if (this.emq != null) {
            if (iVar != null && iVar.PN != null) {
                this.emq.a(iVar.PN.isNewUser, iVar.mLiveInfo, tm());
            } else {
                this.emq.a(false, null, tm());
            }
            if (lVar == null || TextUtils.isEmpty(lVar.pH()) || lVar.pG() != 1) {
                this.emq.emH.setVisibility(8);
                return;
            }
            this.emq.emH.setVisibility(0);
            this.emq.emG.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.emq.emG.startLoad(lVar.pH(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.emq.emY.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.emq.emH.setVisibility(8);
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

    public String tm() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void aVs() {
        if (this.emq != null) {
            this.emq.setMsgLayoutWidth(false);
            this.emq.enf.setVisibility(8);
            this.emq.eng.setVisibility(8);
        }
    }

    public void aVt() {
        if (this.emq != null) {
            this.emq.setMsgLayoutWidth(true);
            this.emq.enf.setVisibility(0);
            this.emq.eng.setVisibility(0);
        }
    }

    public void E(int i, int i2, int i3) {
        if (this.emq != null) {
            if (i3 == 2) {
                aVt();
            } else if (i3 == 1) {
                aVs();
            }
            aVq();
        }
    }

    public void nX(int i) {
        if (this.emq != null && this.emq.emX != null) {
            this.emq.emX.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, long j) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.emq != null && this.emq.emF != null) {
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
            if (this.dYV != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (a.this.dYV != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout = a.this.emq.emF;
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
                            a.this.dYV.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.dYV != null) {
                            a.this.dYV.removeView(inflate);
                        }
                    }
                }, 3000 + j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVu() {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.emq != null && this.emq.emF != null && this.akk != null && !this.akk.isEmpty()) {
            try {
                y yVar = this.akk.get((int) (Math.random() * this.akk.size()));
                final View inflate = getPageContext().getPageActivity().getLayoutInflater().inflate(a.h.toast_goods_guide, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) inflate.findViewById(a.g.conver_imageView);
                tbImageView.setDefaultBgResource(a.f.sdk_shape_transparent);
                if (!TextUtils.isEmpty(yVar.Tl)) {
                    try {
                        JSONArray jSONArray = new JSONArray(yVar.Tl);
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
                        if (a.this.dYV != null) {
                            a.this.dYV.removeView(inflate);
                        }
                        if (a.this.emt != null) {
                            a.this.emt.n(view, 15);
                        }
                        if (a.this.emr != null && a.this.emr.efC != null && a.this.emr.efC.uj() != null && a.this.emr.efC.uj().mLiveInfo != null) {
                            long j = a.this.emr.efC.uj().mLiveInfo.live_id;
                            long j2 = a.this.emr.efC.uj().mLiveInfo.room_id;
                            LogManager.getLiveGoodsLogger().doClickGoodsGuideLog(j + "", j2 + "", a.this.emr.efC.uj().mLiveInfo.feed_id, a.this.otherParams);
                        }
                    }
                });
                if (this.dYV != null) {
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.13
                        @Override // java.lang.Runnable
                        public void run() {
                            Activity pageActivity;
                            if (a.this.dYV != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                                inflate.measure(0, 0);
                                View view = a.this.emq.ejJ;
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
                                a.this.dYV.addView(inflate, layoutParams);
                                if (a.this.emr != null && a.this.emr.efC != null && a.this.emr.efC.uj() != null && a.this.emr.efC.uj().mLiveInfo != null) {
                                    long j = a.this.emr.efC.uj().mLiveInfo.live_id;
                                    long j2 = a.this.emr.efC.uj().mLiveInfo.room_id;
                                    String str2 = a.this.emr.efC.uj().mLiveInfo.feed_id;
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
                            if (a.this.dYV != null) {
                                a.this.dYV.removeView(inflate);
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
        if (this.emq != null) {
            return this.emq.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.emw);
        MessageManager.getInstance().unRegisterListener(this.emx);
        MessageManager.getInstance().unRegisterListener(this.emy);
        MessageManager.getInstance().unRegisterListener(this.emz);
        this.emv = null;
        if (this.emq != null) {
            if (this.emu != null) {
                this.emq.enb.removeOnLayoutChangeListener(this.emu);
            }
            this.emq.onDestory();
        }
    }
}
