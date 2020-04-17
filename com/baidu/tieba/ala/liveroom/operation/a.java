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
import com.baidu.live.data.aj;
import com.baidu.live.data.as;
import com.baidu.live.data.bb;
import com.baidu.live.data.bg;
import com.baidu.live.data.bk;
import com.baidu.live.data.n;
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
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
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
    private List<aj> aQC;
    CustomMessageTask.CustomRunnable aRA;
    private int aqR;
    private AlaLiveBottomOperationView fNg;
    private com.baidu.tieba.ala.liveroom.data.a fNh;
    private FrameLayout fNi;
    private b fNj;
    private View.OnLayoutChangeListener fNk;
    private InterfaceC0500a fNl;
    private long fNm;
    private CustomMessageListener fNn;
    private CustomMessageListener fNo;
    CustomMessageListener fNp;
    CustomMessageListener fNq;
    private CustomMessageListener fNr;
    private CustomMessageListener fNs;
    private CustomMessageListener fNt;
    private CustomMessageListener fNu;
    private ViewGroup faQ;
    private Handler handler;
    private String otherParams;

    /* renamed from: com.baidu.tieba.ala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0500a {
        void br(int i, int i2);

        void bs(int i, int i2);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.fNn = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                bk bkVar;
                String str;
                long j;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                    j = 1000;
                } else {
                    as asVar = com.baidu.live.v.a.Eo().aRw;
                    if (asVar != null && (bkVar = asVar.avv) != null) {
                        str = bkVar.axk;
                        j = 3000;
                    } else {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.c(str, j, 3000);
                }
            }
        };
        this.fNo = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.ala.liveroom.operation.a.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.ala.liveroom.t.a.bzZ().aQA != null) {
                    str = com.baidu.tieba.ala.liveroom.t.a.bzZ().aQA.aqW;
                    i = com.baidu.tieba.ala.liveroom.t.a.bzZ().aQA.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.c(str, 1000L, i);
                }
            }
        };
        this.fNp = new CustomMessageListener(2913111) { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fNg != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) customResponsedMessage.getData();
                    int i = getVideoGoodsListHttpResponseMessage.count;
                    if (i <= 0) {
                        a.this.fNg.fJN.setVisibility(8);
                    } else {
                        a.this.fNg.fJN.setVisibility(0);
                        if (a.this.fNm != getVideoGoodsListHttpResponseMessage.liveId) {
                            a.this.fNm = getVideoGoodsListHttpResponseMessage.liveId;
                            a.this.fNg.kP(true);
                        }
                        if (a.this.fNh != null && a.this.fNh.fFc != null && a.this.fNh.fFc.DN() != null && a.this.fNh.fFc.DN().mLiveInfo != null) {
                            long j = a.this.fNh.fFc.DN().mLiveInfo.live_id;
                            long j2 = a.this.fNh.fFc.DN().mLiveInfo.room_id;
                            String str = a.this.fNh.fFc.DN().mLiveInfo.feed_id;
                            if (!ILiveGoodsLogger.displayStoreIconMap.contains(Long.valueOf(j))) {
                                ILiveGoodsLogger.displayStoreIconMap.add(Long.valueOf(j));
                                LogManager.getLiveGoodsLogger().doDisplayStoreIconLog(j + "", j2 + "", str, a.this.otherParams);
                            }
                        }
                    }
                    a.this.aQC = getVideoGoodsListHttpResponseMessage.aQC;
                    if (getVideoGoodsListHttpResponseMessage.getOrginalMessage() != null && (getVideoGoodsListHttpResponseMessage.getOrginalMessage() instanceof h) && ((h) getVideoGoodsListHttpResponseMessage.getOrginalMessage()).aQB && i > 0 && a.this.aQC != null && a.this.aQC.size() > 0) {
                        a.this.bzz();
                    }
                }
            }
        };
        this.fNq = new CustomMessageListener(2913112) { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fNg != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaLiveInfoData)) {
                    AlaLiveInfoData alaLiveInfoData = (AlaLiveInfoData) customResponsedMessage.getData();
                    o.a(alaLiveInfoData.feed_id, alaLiveInfoData.live_id, true);
                }
            }
        };
        this.fNr = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fNg != null) {
                    a.this.fNg.a(false, null, a.this.Cr());
                }
            }
        };
        this.fNs = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    n DN = (a.this.fNh == null || a.this.fNh.fFc == null) ? null : a.this.fNh.fFc.DN();
                    if (DN == null || DN.aqx == null) {
                        a.this.fNg.a(false, null, a.this.Cr());
                    } else {
                        a.this.fNg.a(DN.aqx.isNewUser, DN.mLiveInfo, a.this.Cr());
                    }
                }
            }
        };
        this.fNt = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fNg != null && a.this.fNg.fNZ != null) {
                    a.this.fNg.fNZ.performClick();
                }
            }
        };
        this.aRA = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.fNg != null && a.this.fNg.fNZ != null) {
                        int[] iArr = new int[2];
                        a.this.fNg.fNZ.getLocationOnScreen(iArr);
                        jSONObject.putOpt("turn_tab_x", Integer.valueOf(iArr[0]));
                        jSONObject.putOpt("turn_tab_y", Integer.valueOf(iArr[1]));
                    }
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_TURN_TAB_LOC, jSONObject.toString());
                } catch (JSONException e) {
                    return null;
                }
            }
        };
        this.fNu = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.bzA();
            }
        };
        MessageManager.getInstance().registerListener(this.fNn);
        MessageManager.getInstance().registerListener(this.fNo);
        MessageManager.getInstance().registerListener(this.fNp);
        MessageManager.getInstance().registerListener(this.fNq);
        MessageManager.getInstance().registerListener(this.fNr);
        MessageManager.getInstance().registerListener(this.fNs);
        MessageManager.getInstance().registerListener(this.fNt);
        MessageManager.getInstance().registerListener(this.fNu);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_TURN_TAB_LOC, this.aRA);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void kd(boolean z) {
        if (this.fNg != null) {
            this.fNg.kd(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.fNg != null) {
            this.fNg.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, int i, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.fNh = aVar;
            this.aqR = i;
            this.faQ = viewGroup;
            if (this.fNg == null) {
                this.fNg = new AlaLiveBottomOperationView(getPageContext());
            }
            this.fNg.registerListeners();
            this.fNj = bVar;
            this.fNg.setOnLiveViewOperationBtnClickListener(bVar);
            this.fNg.getRootView().setId(a.g.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.fNg.getRootView()) >= 0) {
                viewGroup.removeView(this.fNg.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.fNg.getRootView().setBackgroundResource(a.f.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.fNg.getRootView().setBackgroundResource(a.d.sdk_transparent);
            }
            viewGroup.addView(this.fNg.getRootView(), layoutParams);
            if (this.fNi == null) {
                this.fNi = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.fNi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.l(view, 8);
                        }
                    }
                });
            }
            this.fNg.fJN.setVisibility(8);
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                bzu();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.fNg.fNE != null) {
                this.fNg.fNE.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.fNg != null && this.fNg.fNS != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds68));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds22);
                    layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds28);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds10) + UtilHelper.getStatusBarHeight();
                    }
                    layoutParams2.gravity = 53;
                    this.fNg.fNS.setVisibility(8);
                    if (this.fNg.fNS.getParent() != null && (this.fNg.fNS.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.fNg.fNS.getParent()).removeView(this.fNg.fNS);
                    }
                    aVar.fFb.getLiveContainerView().addView(this.fNg.fNS, layoutParams2);
                    return;
                }
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds96));
                layoutParams3.gravity = 83;
                if (this.fNi.getParent() != null && (this.fNi.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.fNi.getParent()).removeView(this.fNi);
                }
                aVar.fFb.getLiveContainerView().addView(this.fNi, layoutParams3);
            }
        }
    }

    private void bzu() {
        bg bgVar;
        bb bbVar;
        if (this.fNk != null) {
            this.fNg.fNZ.removeOnLayoutChangeListener(this.fNk);
        }
        as asVar = com.baidu.live.v.a.Eo().aRw;
        if (asVar != null && (bgVar = asVar.avx) != null && bgVar.axb && (bbVar = asVar.avu) != null && bbVar.awr != null && !TextUtils.isEmpty(bbVar.awr.webUrl)) {
            this.fNg.fNZ.setVisibility(0);
            this.fNg.fOa.setVisibility(0);
            this.fNg.fOb.setVisibility(8);
            return;
        }
        this.fNg.fNZ.setVisibility(8);
    }

    public void a(InterfaceC0500a interfaceC0500a) {
        if (this.fNg != null && this.fNg.fNZ != null && this.fNg.fNZ.getVisibility() == 0) {
            this.fNl = interfaceC0500a;
            this.fNk = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.bzv();
                }
            };
            this.fNg.fNZ.addOnLayoutChangeListener(this.fNk);
            this.fNg.fNZ.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.12
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.fNl != null) {
                        int[] iArr = new int[2];
                        a.this.fNg.fNZ.getLocationInWindow(iArr);
                        a.this.fNl.br((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.fNg.fNZ.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.fNg.fNZ.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzv() {
        if (this.fNg != null && this.fNg.fNZ != null && this.fNg.fNZ.getVisibility() == 0) {
            this.fNg.fNZ.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.13
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.fNg != null && a.this.fNg.fNZ != null && a.this.fNg.fNZ.getVisibility() == 0 && a.this.fNl != null) {
                        int[] iArr = new int[2];
                        a.this.fNg.fNZ.getLocationInWindow(iArr);
                        a.this.fNl.bs((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.fNg.fNZ.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.fNg.fNZ.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.fNg != null && this.fNg.fNZ != null && this.fNg.fNZ.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.fNg.fOa.getVisibility() == 0) {
                    this.fNg.fOa.setVisibility(8);
                }
                if (this.fNg.fOb.getVisibility() != 0) {
                    this.fNg.fOb.setVisibility(0);
                }
                this.fNg.fOb.setTimer(str, f);
                return;
            }
            if (this.fNg.fOa.getVisibility() != 0) {
                this.fNg.fOa.setVisibility(0);
            }
            if (this.fNg.fOb.getVisibility() == 0) {
                this.fNg.fOb.setVisibility(8);
            }
        }
    }

    public void bzw() {
        if (this.fNg != null && this.fNg.fNZ != null && this.fNk != null) {
            this.fNg.fNZ.removeOnLayoutChangeListener(this.fNk);
        }
        this.fNm = 0L;
        if (this.fNg != null) {
            this.fNg.kP(false);
        }
        if (this.faQ != null && this.fNg != null && this.faQ.indexOfChild(this.fNg.getRootView()) > 0) {
            this.faQ.removeView(this.fNg.getRootView());
        }
        if (this.fNi != null && (this.fNi.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fNi.getParent()).removeView(this.fNi);
        }
        if (this.fNg != null && this.fNg.fNS != null && (this.fNg.fNS.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fNg.fNS.getParent()).removeView(this.fNg.fNS);
        }
    }

    public void setVisibility(int i) {
        if (this.fNg != null && this.fNg.getRootView() != null) {
            this.fNg.getRootView().setVisibility(i);
        }
        if (this.fNi != null) {
            this.fNi.setVisibility(i);
        }
    }

    public void a(com.baidu.live.gift.o oVar, n nVar) {
        if (this.fNg != null) {
            if (nVar != null && nVar.aqx != null) {
                this.fNg.a(nVar.aqx.isNewUser, nVar.mLiveInfo, Cr());
            } else {
                this.fNg.a(false, null, Cr());
            }
            if (oVar == null || TextUtils.isEmpty(oVar.wU()) || oVar.wT() != 1) {
                this.fNg.fNC.setVisibility(8);
                return;
            }
            this.fNg.fNC.setVisibility(0);
            this.fNg.fNB.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.fNg.fNB.startLoad(oVar.wU(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.fNg.fNU.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.fNg.fNC.setVisibility(8);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (oVar.wS() != null) {
                    alaStaticItem.addParams("gifts_value", oVar.wS().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, oVar.wS().vV());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, oVar.wS().vW());
                }
                if (nVar != null && nVar.mLiveInfo != null) {
                    alaStaticItem.addParams("feed_id", nVar.mLiveInfo.feed_id);
                    alaStaticItem.addParams("room_id", nVar.mLiveInfo.room_id);
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    public String Cr() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void bzx() {
        if (this.fNg != null) {
            this.fNg.setMsgLayoutWidth(false);
            this.fNg.fOc.setVisibility(8);
            this.fNg.fOd.setVisibility(8);
        }
    }

    public void bzy() {
        if (this.fNg != null) {
            this.fNg.setMsgLayoutWidth(true);
            this.fNg.fOc.setVisibility(0);
            this.fNg.fOd.setVisibility(0);
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.fNg != null) {
            if (i3 == 2) {
                bzy();
            } else if (i3 == 1) {
                bzx();
            }
            bzv();
        }
    }

    public void qU(int i) {
        if (this.fNg != null && this.fNg.fNS != null) {
            this.fNg.fNS.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.fNg != null && this.fNg.fNA != null) {
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
            if (this.faQ != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.15
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (a.this.faQ != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout = a.this.fNg.fNA;
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
                            a.this.faQ.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.faQ != null) {
                            a.this.faQ.removeView(inflate);
                        }
                    }
                }, i + j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzz() {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.fNg != null && this.fNg.fNA != null && this.aQC != null && !this.aQC.isEmpty()) {
            try {
                aj ajVar = this.aQC.get((int) (Math.random() * this.aQC.size()));
                final View inflate = getPageContext().getPageActivity().getLayoutInflater().inflate(a.h.toast_goods_guide, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) inflate.findViewById(a.g.conver_imageView);
                tbImageView.setDefaultBgResource(a.f.sdk_shape_transparent);
                if (!TextUtils.isEmpty(ajVar.auy)) {
                    try {
                        JSONArray jSONArray = new JSONArray(ajVar.auy);
                        if (jSONArray.length() > 0) {
                            tbImageView.startLoad(jSONArray.optJSONObject(0).optString(UserAccountActionItem.KEY_SRC), 10, false);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                TextView textView = (TextView) inflate.findViewById(a.g.title_textView);
                TextView textView2 = (TextView) inflate.findViewById(a.g.price_textView);
                String str = ajVar.title;
                if (str == null) {
                    str = "";
                } else if (str.length() > 8) {
                    str = str.substring(0, 8) + StringHelper.STRING_MORE;
                }
                textView.setText(str);
                textView2.setText(ajVar.price);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.18
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.handler.removeCallbacksAndMessages(null);
                        if (a.this.faQ != null) {
                            a.this.faQ.removeView(inflate);
                        }
                        if (a.this.fNj != null) {
                            a.this.fNj.l(view, 15);
                        }
                        if (a.this.fNh != null && a.this.fNh.fFc != null && a.this.fNh.fFc.DN() != null && a.this.fNh.fFc.DN().mLiveInfo != null) {
                            long j = a.this.fNh.fFc.DN().mLiveInfo.live_id;
                            long j2 = a.this.fNh.fFc.DN().mLiveInfo.room_id;
                            LogManager.getLiveGoodsLogger().doClickGoodsGuideLog(j + "", j2 + "", a.this.fNh.fFc.DN().mLiveInfo.feed_id, a.this.otherParams);
                        }
                    }
                });
                if (this.faQ != null) {
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Activity pageActivity;
                            if (a.this.faQ != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                                inflate.measure(0, 0);
                                View view = a.this.fNg.fJN;
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
                                a.this.faQ.addView(inflate, layoutParams);
                                if (a.this.fNh != null && a.this.fNh.fFc != null && a.this.fNh.fFc.DN() != null && a.this.fNh.fFc.DN().mLiveInfo != null) {
                                    long j = a.this.fNh.fFc.DN().mLiveInfo.live_id;
                                    long j2 = a.this.fNh.fFc.DN().mLiveInfo.room_id;
                                    String str2 = a.this.fNh.fFc.DN().mLiveInfo.feed_id;
                                    if (!ILiveGoodsLogger.displayGoodsGuideMap.contains(Long.valueOf(j))) {
                                        ILiveGoodsLogger.displayGoodsGuideMap.add(Long.valueOf(j));
                                        LogManager.getLiveGoodsLogger().doDisplayGoodsGuideLog(j + "", j2 + "", str2, a.this.otherParams);
                                    }
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1394", "display", "liveroom", "shopcart_show"));
                                }
                            }
                        }
                    }, 200L);
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.faQ != null) {
                                a.this.faQ.removeView(inflate);
                            }
                        }
                    }, 7000L);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public ImageView getLandscapeBarrageImageView() {
        if (this.fNg != null) {
            return this.fNg.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.fNm = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fNn);
        MessageManager.getInstance().unRegisterListener(this.fNo);
        MessageManager.getInstance().unRegisterListener(this.fNp);
        MessageManager.getInstance().unRegisterListener(this.fNq);
        MessageManager.getInstance().unRegisterListener(this.fNr);
        MessageManager.getInstance().unRegisterListener(this.fNs);
        MessageManager.getInstance().unRegisterListener(this.fNt);
        MessageManager.getInstance().unRegisterListener(this.fNu);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TURN_TAB_LOC);
        this.fNl = null;
        if (this.fNg != null) {
            if (this.fNk != null) {
                this.fNg.fNZ.removeOnLayoutChangeListener(this.fNk);
            }
            this.fNg.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzA() {
        if (this.fNg != null && this.fNg.fOa != null) {
            this.fNg.fOa.setScaleX(1.1f);
            this.fNg.fOa.setScaleY(1.1f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fNg.fOa, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fNg.fOa, View.SCALE_Y, 1.1f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fNg.fOa, View.SCALE_X, 1.0f, 1.1f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fNg.fOa, View.SCALE_Y, 1.0f, 1.1f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(100L);
            animatorSet2.playTogether(ofFloat3, ofFloat4);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fNg.fOa, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.fNg.fOa, View.SCALE_Y, 1.1f, 1.0f);
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
