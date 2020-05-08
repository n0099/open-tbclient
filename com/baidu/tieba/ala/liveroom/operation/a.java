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
    private List<aj> aQH;
    CustomMessageTask.CustomRunnable aRF;
    private int aqX;
    private AlaLiveBottomOperationView fNl;
    private com.baidu.tieba.ala.liveroom.data.a fNm;
    private FrameLayout fNn;
    private b fNo;
    private View.OnLayoutChangeListener fNp;
    private InterfaceC0521a fNq;
    private long fNr;
    private CustomMessageListener fNs;
    private CustomMessageListener fNt;
    CustomMessageListener fNu;
    CustomMessageListener fNv;
    private CustomMessageListener fNw;
    private CustomMessageListener fNx;
    private CustomMessageListener fNy;
    private CustomMessageListener fNz;
    private ViewGroup faV;
    private Handler handler;
    private String otherParams;

    /* renamed from: com.baidu.tieba.ala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0521a {
        void br(int i, int i2);

        void bs(int i, int i2);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.fNs = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.14
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
                    as asVar = com.baidu.live.v.a.En().aRB;
                    if (asVar != null && (bkVar = asVar.avB) != null) {
                        str = bkVar.axq;
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
        this.fNt = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.ala.liveroom.operation.a.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.ala.liveroom.t.a.bzX().aQF != null) {
                    str = com.baidu.tieba.ala.liveroom.t.a.bzX().aQF.arc;
                    i = com.baidu.tieba.ala.liveroom.t.a.bzX().aQF.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, 1000L, i);
                }
            }
        };
        this.fNu = new CustomMessageListener(2913111) { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fNl != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) customResponsedMessage.getData();
                    int i = getVideoGoodsListHttpResponseMessage.count;
                    if (i <= 0) {
                        a.this.fNl.fJS.setVisibility(8);
                    } else {
                        a.this.fNl.fJS.setVisibility(0);
                        if (a.this.fNr != getVideoGoodsListHttpResponseMessage.liveId) {
                            a.this.fNr = getVideoGoodsListHttpResponseMessage.liveId;
                            a.this.fNl.kP(true);
                        }
                        if (a.this.fNm != null && a.this.fNm.fFh != null && a.this.fNm.fFh.DM() != null && a.this.fNm.fFh.DM().mLiveInfo != null) {
                            long j = a.this.fNm.fFh.DM().mLiveInfo.live_id;
                            long j2 = a.this.fNm.fFh.DM().mLiveInfo.room_id;
                            String str = a.this.fNm.fFh.DM().mLiveInfo.feed_id;
                            if (!ILiveGoodsLogger.displayStoreIconMap.contains(Long.valueOf(j))) {
                                ILiveGoodsLogger.displayStoreIconMap.add(Long.valueOf(j));
                                LogManager.getLiveGoodsLogger().doDisplayStoreIconLog(j + "", j2 + "", str, a.this.otherParams);
                            }
                        }
                    }
                    a.this.aQH = getVideoGoodsListHttpResponseMessage.aQH;
                    if (getVideoGoodsListHttpResponseMessage.getOrginalMessage() != null && (getVideoGoodsListHttpResponseMessage.getOrginalMessage() instanceof h) && ((h) getVideoGoodsListHttpResponseMessage.getOrginalMessage()).aQG && i > 0 && a.this.aQH != null && a.this.aQH.size() > 0) {
                        a.this.bzx();
                    }
                }
            }
        };
        this.fNv = new CustomMessageListener(2913112) { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fNl != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaLiveInfoData)) {
                    AlaLiveInfoData alaLiveInfoData = (AlaLiveInfoData) customResponsedMessage.getData();
                    o.a(alaLiveInfoData.feed_id, alaLiveInfoData.live_id, true);
                }
            }
        };
        this.fNw = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fNl != null) {
                    a.this.fNl.a(false, null, a.this.Cq());
                }
            }
        };
        this.fNx = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    n DM = (a.this.fNm == null || a.this.fNm.fFh == null) ? null : a.this.fNm.fFh.DM();
                    if (DM == null || DM.aqD == null) {
                        a.this.fNl.a(false, null, a.this.Cq());
                    } else {
                        a.this.fNl.a(DM.aqD.isNewUser, DM.mLiveInfo, a.this.Cq());
                    }
                }
            }
        };
        this.fNy = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.fNl != null && a.this.fNl.fOe != null) {
                    a.this.fNl.fOe.performClick();
                }
            }
        };
        this.aRF = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.fNl != null && a.this.fNl.fOe != null) {
                        int[] iArr = new int[2];
                        a.this.fNl.fOe.getLocationOnScreen(iArr);
                        jSONObject.putOpt("turn_tab_x", Integer.valueOf(iArr[0]));
                        jSONObject.putOpt("turn_tab_y", Integer.valueOf(iArr[1]));
                    }
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_TURN_TAB_LOC, jSONObject.toString());
                } catch (JSONException e) {
                    return null;
                }
            }
        };
        this.fNz = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.bzy();
            }
        };
        MessageManager.getInstance().registerListener(this.fNs);
        MessageManager.getInstance().registerListener(this.fNt);
        MessageManager.getInstance().registerListener(this.fNu);
        MessageManager.getInstance().registerListener(this.fNv);
        MessageManager.getInstance().registerListener(this.fNw);
        MessageManager.getInstance().registerListener(this.fNx);
        MessageManager.getInstance().registerListener(this.fNy);
        MessageManager.getInstance().registerListener(this.fNz);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_TURN_TAB_LOC, this.aRF);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void kd(boolean z) {
        if (this.fNl != null) {
            this.fNl.kd(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.fNl != null) {
            this.fNl.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, int i, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.fNm = aVar;
            this.aqX = i;
            this.faV = viewGroup;
            if (this.fNl == null) {
                this.fNl = new AlaLiveBottomOperationView(getPageContext());
            }
            this.fNl.registerListeners();
            this.fNo = bVar;
            this.fNl.setOnLiveViewOperationBtnClickListener(bVar);
            this.fNl.getRootView().setId(a.g.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.fNl.getRootView()) >= 0) {
                viewGroup.removeView(this.fNl.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.fNl.getRootView().setBackgroundResource(a.f.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.fNl.getRootView().setBackgroundResource(a.d.sdk_transparent);
            }
            viewGroup.addView(this.fNl.getRootView(), layoutParams);
            if (this.fNn == null) {
                this.fNn = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.fNn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.l(view, 8);
                        }
                    }
                });
            }
            this.fNl.fJS.setVisibility(8);
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                bzs();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.fNl.fNJ != null) {
                this.fNl.fNJ.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.fNl != null && this.fNl.fNX != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds68));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds22);
                    layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds28);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds10) + UtilHelper.getStatusBarHeight();
                    }
                    layoutParams2.gravity = 53;
                    this.fNl.fNX.setVisibility(8);
                    if (this.fNl.fNX.getParent() != null && (this.fNl.fNX.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.fNl.fNX.getParent()).removeView(this.fNl.fNX);
                    }
                    aVar.fFg.getLiveContainerView().addView(this.fNl.fNX, layoutParams2);
                    return;
                }
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds96));
                layoutParams3.gravity = 83;
                if (this.fNn.getParent() != null && (this.fNn.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.fNn.getParent()).removeView(this.fNn);
                }
                aVar.fFg.getLiveContainerView().addView(this.fNn, layoutParams3);
            }
        }
    }

    private void bzs() {
        bg bgVar;
        bb bbVar;
        if (this.fNp != null) {
            this.fNl.fOe.removeOnLayoutChangeListener(this.fNp);
        }
        as asVar = com.baidu.live.v.a.En().aRB;
        if (asVar != null && (bgVar = asVar.avD) != null && bgVar.axh && (bbVar = asVar.avA) != null && bbVar.awx != null && !TextUtils.isEmpty(bbVar.awx.webUrl)) {
            this.fNl.fOe.setVisibility(0);
            this.fNl.fOf.setVisibility(0);
            this.fNl.fOg.setVisibility(8);
            return;
        }
        this.fNl.fOe.setVisibility(8);
    }

    public void a(InterfaceC0521a interfaceC0521a) {
        if (this.fNl != null && this.fNl.fOe != null && this.fNl.fOe.getVisibility() == 0) {
            this.fNq = interfaceC0521a;
            this.fNp = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.bzt();
                }
            };
            this.fNl.fOe.addOnLayoutChangeListener(this.fNp);
            this.fNl.fOe.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.12
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.fNq != null) {
                        int[] iArr = new int[2];
                        a.this.fNl.fOe.getLocationInWindow(iArr);
                        a.this.fNq.br((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.fNl.fOe.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.fNl.fOe.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzt() {
        if (this.fNl != null && this.fNl.fOe != null && this.fNl.fOe.getVisibility() == 0) {
            this.fNl.fOe.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.13
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.fNl != null && a.this.fNl.fOe != null && a.this.fNl.fOe.getVisibility() == 0 && a.this.fNq != null) {
                        int[] iArr = new int[2];
                        a.this.fNl.fOe.getLocationInWindow(iArr);
                        a.this.fNq.bs((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.fNl.fOe.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.fNl.fOe.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.fNl != null && this.fNl.fOe != null && this.fNl.fOe.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.fNl.fOf.getVisibility() == 0) {
                    this.fNl.fOf.setVisibility(8);
                }
                if (this.fNl.fOg.getVisibility() != 0) {
                    this.fNl.fOg.setVisibility(0);
                }
                this.fNl.fOg.setTimer(str, f);
                return;
            }
            if (this.fNl.fOf.getVisibility() != 0) {
                this.fNl.fOf.setVisibility(0);
            }
            if (this.fNl.fOg.getVisibility() == 0) {
                this.fNl.fOg.setVisibility(8);
            }
        }
    }

    public void bzu() {
        if (this.fNl != null && this.fNl.fOe != null && this.fNp != null) {
            this.fNl.fOe.removeOnLayoutChangeListener(this.fNp);
        }
        this.fNr = 0L;
        if (this.fNl != null) {
            this.fNl.kP(false);
        }
        if (this.faV != null && this.fNl != null && this.faV.indexOfChild(this.fNl.getRootView()) > 0) {
            this.faV.removeView(this.fNl.getRootView());
        }
        if (this.fNn != null && (this.fNn.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fNn.getParent()).removeView(this.fNn);
        }
        if (this.fNl != null && this.fNl.fNX != null && (this.fNl.fNX.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fNl.fNX.getParent()).removeView(this.fNl.fNX);
        }
    }

    public void setVisibility(int i) {
        if (this.fNl != null && this.fNl.getRootView() != null) {
            this.fNl.getRootView().setVisibility(i);
        }
        if (this.fNn != null) {
            this.fNn.setVisibility(i);
        }
    }

    public void a(com.baidu.live.gift.o oVar, n nVar) {
        if (this.fNl != null) {
            if (nVar != null && nVar.aqD != null) {
                this.fNl.a(nVar.aqD.isNewUser, nVar.mLiveInfo, Cq());
            } else {
                this.fNl.a(false, null, Cq());
            }
            if (oVar == null || TextUtils.isEmpty(oVar.wT()) || oVar.wS() != 1) {
                this.fNl.fNH.setVisibility(8);
                return;
            }
            this.fNl.fNH.setVisibility(0);
            this.fNl.fNG.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.fNl.fNG.startLoad(oVar.wT(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.fNl.fNZ.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.fNl.fNH.setVisibility(8);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (oVar.wR() != null) {
                    alaStaticItem.addParams("gifts_value", oVar.wR().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, oVar.wR().vU());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, oVar.wR().vV());
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

    public String Cq() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void bzv() {
        if (this.fNl != null) {
            this.fNl.setMsgLayoutWidth(false);
            this.fNl.fOh.setVisibility(8);
            this.fNl.fOi.setVisibility(8);
        }
    }

    public void bzw() {
        if (this.fNl != null) {
            this.fNl.setMsgLayoutWidth(true);
            this.fNl.fOh.setVisibility(0);
            this.fNl.fOi.setVisibility(0);
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.fNl != null) {
            if (i3 == 2) {
                bzw();
            } else if (i3 == 1) {
                bzv();
            }
            bzt();
        }
    }

    public void qU(int i) {
        if (this.fNl != null && this.fNl.fNX != null) {
            this.fNl.fNX.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.fNl != null && this.fNl.fNF != null) {
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
            if (this.faV != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.15
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (a.this.faV != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout = a.this.fNl.fNF;
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
                            a.this.faV.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.faV != null) {
                            a.this.faV.removeView(inflate);
                        }
                    }
                }, i + j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzx() {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.fNl != null && this.fNl.fNF != null && this.aQH != null && !this.aQH.isEmpty()) {
            try {
                aj ajVar = this.aQH.get((int) (Math.random() * this.aQH.size()));
                final View inflate = getPageContext().getPageActivity().getLayoutInflater().inflate(a.h.toast_goods_guide, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) inflate.findViewById(a.g.conver_imageView);
                tbImageView.setDefaultBgResource(a.f.sdk_shape_transparent);
                if (!TextUtils.isEmpty(ajVar.auE)) {
                    try {
                        JSONArray jSONArray = new JSONArray(ajVar.auE);
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
                        if (a.this.faV != null) {
                            a.this.faV.removeView(inflate);
                        }
                        if (a.this.fNo != null) {
                            a.this.fNo.l(view, 15);
                        }
                        if (a.this.fNm != null && a.this.fNm.fFh != null && a.this.fNm.fFh.DM() != null && a.this.fNm.fFh.DM().mLiveInfo != null) {
                            long j = a.this.fNm.fFh.DM().mLiveInfo.live_id;
                            long j2 = a.this.fNm.fFh.DM().mLiveInfo.room_id;
                            LogManager.getLiveGoodsLogger().doClickGoodsGuideLog(j + "", j2 + "", a.this.fNm.fFh.DM().mLiveInfo.feed_id, a.this.otherParams);
                        }
                    }
                });
                if (this.faV != null) {
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Activity pageActivity;
                            if (a.this.faV != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                                inflate.measure(0, 0);
                                View view = a.this.fNl.fJS;
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
                                a.this.faV.addView(inflate, layoutParams);
                                if (a.this.fNm != null && a.this.fNm.fFh != null && a.this.fNm.fFh.DM() != null && a.this.fNm.fFh.DM().mLiveInfo != null) {
                                    long j = a.this.fNm.fFh.DM().mLiveInfo.live_id;
                                    long j2 = a.this.fNm.fFh.DM().mLiveInfo.room_id;
                                    String str2 = a.this.fNm.fFh.DM().mLiveInfo.feed_id;
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
                            if (a.this.faV != null) {
                                a.this.faV.removeView(inflate);
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
        if (this.fNl != null) {
            return this.fNl.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.fNr = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fNs);
        MessageManager.getInstance().unRegisterListener(this.fNt);
        MessageManager.getInstance().unRegisterListener(this.fNu);
        MessageManager.getInstance().unRegisterListener(this.fNv);
        MessageManager.getInstance().unRegisterListener(this.fNw);
        MessageManager.getInstance().unRegisterListener(this.fNx);
        MessageManager.getInstance().unRegisterListener(this.fNy);
        MessageManager.getInstance().unRegisterListener(this.fNz);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TURN_TAB_LOC);
        this.fNq = null;
        if (this.fNl != null) {
            if (this.fNp != null) {
                this.fNl.fOe.removeOnLayoutChangeListener(this.fNp);
            }
            this.fNl.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzy() {
        if (this.fNl != null && this.fNl.fOf != null) {
            this.fNl.fOf.setScaleX(1.1f);
            this.fNl.fOf.setScaleY(1.1f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fNl.fOf, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fNl.fOf, View.SCALE_Y, 1.1f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fNl.fOf, View.SCALE_X, 1.0f, 1.1f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fNl.fOf, View.SCALE_Y, 1.0f, 1.1f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(100L);
            animatorSet2.playTogether(ofFloat3, ofFloat4);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fNl.fOf, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.fNl.fOf, View.SCALE_Y, 1.1f, 1.0f);
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
