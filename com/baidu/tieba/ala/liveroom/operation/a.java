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
import com.baidu.live.data.an;
import com.baidu.live.data.ax;
import com.baidu.live.data.bg;
import com.baidu.live.data.bl;
import com.baidu.live.data.bp;
import com.baidu.live.data.q;
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
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
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
    private List<an> aWS;
    CustomMessageTask.CustomRunnable aYT;
    private int avX;
    private ViewGroup foI;
    private AlaLiveBottomOperationView gbB;
    private com.baidu.tieba.ala.liveroom.data.a gbC;
    private FrameLayout gbD;
    private b gbE;
    private View.OnLayoutChangeListener gbF;
    private InterfaceC0568a gbG;
    private long gbH;
    private CustomMessageListener gbI;
    private CustomMessageListener gbJ;
    CustomMessageListener gbK;
    CustomMessageListener gbL;
    private CustomMessageListener gbM;
    private CustomMessageListener gbN;
    private CustomMessageListener gbO;
    private CustomMessageListener gbP;
    private Handler handler;
    private String otherParams;

    /* renamed from: com.baidu.tieba.ala.liveroom.operation.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0568a {
        void bv(int i, int i2);

        void bw(int i, int i2);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.gbI = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                bp bpVar;
                String str;
                long j;
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    str = (String) customResponsedMessage.getData();
                    j = 1000;
                } else {
                    ax axVar = com.baidu.live.v.a.Ge().aYP;
                    if (axVar != null && (bpVar = axVar.aAJ) != null) {
                        str = bpVar.aCG;
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
        this.gbJ = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.ala.liveroom.operation.a.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.ala.liveroom.t.a.bGm().aWQ != null) {
                    str = com.baidu.tieba.ala.liveroom.t.a.bGm().aWQ.awb;
                    i = com.baidu.tieba.ala.liveroom.t.a.bGm().aWQ.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, 1000L, i);
                }
            }
        };
        this.gbK = new CustomMessageListener(2913111) { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gbB != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) customResponsedMessage.getData();
                    int i = getVideoGoodsListHttpResponseMessage.count;
                    if (i <= 0) {
                        a.this.gbB.fYb.setVisibility(8);
                    } else {
                        if (a.this.gbB.fYb.getVisibility() == 8) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "shopcart_show"));
                        }
                        a.this.gbB.fYb.setVisibility(0);
                        if (a.this.gbH != getVideoGoodsListHttpResponseMessage.liveId) {
                            a.this.gbH = getVideoGoodsListHttpResponseMessage.liveId;
                            a.this.gbB.lk(true);
                        }
                        if (a.this.gbC != null && a.this.gbC.fTm != null && a.this.gbC.fTm.Fk() != null && a.this.gbC.fTm.Fk().mLiveInfo != null) {
                            long j = a.this.gbC.fTm.Fk().mLiveInfo.live_id;
                            long j2 = a.this.gbC.fTm.Fk().mLiveInfo.room_id;
                            String str = a.this.gbC.fTm.Fk().mLiveInfo.feed_id;
                            if (!ILiveGoodsLogger.displayStoreIconMap.contains(Long.valueOf(j))) {
                                ILiveGoodsLogger.displayStoreIconMap.add(Long.valueOf(j));
                                LogManager.getLiveGoodsLogger().doDisplayStoreIconLog(j + "", j2 + "", str, a.this.otherParams);
                            }
                        }
                    }
                    a.this.aWS = getVideoGoodsListHttpResponseMessage.aWS;
                    if (getVideoGoodsListHttpResponseMessage.getOrginalMessage() != null && (getVideoGoodsListHttpResponseMessage.getOrginalMessage() instanceof h) && ((h) getVideoGoodsListHttpResponseMessage.getOrginalMessage()).aWR && i > 0 && a.this.aWS != null && a.this.aWS.size() > 0) {
                        a.this.bFI();
                    }
                }
            }
        };
        this.gbL = new CustomMessageListener(2913112) { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gbB != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaLiveInfoData)) {
                    AlaLiveInfoData alaLiveInfoData = (AlaLiveInfoData) customResponsedMessage.getData();
                    o.a(alaLiveInfoData.feed_id, alaLiveInfoData.live_id, false, true);
                }
            }
        };
        this.gbM = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gbB != null) {
                    a.this.gbB.a(false, null, a.this.DN());
                }
            }
        };
        this.gbN = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    q Fk = (a.this.gbC == null || a.this.gbC.fTm == null) ? null : a.this.gbC.fTm.Fk();
                    if (Fk == null || Fk.avC == null) {
                        a.this.gbB.a(false, null, a.this.DN());
                    } else {
                        a.this.gbB.a(Fk.avC.isNewUser, Fk.mLiveInfo, a.this.DN());
                    }
                }
            }
        };
        this.gbO = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gbB != null && a.this.gbB.gcu != null) {
                    a.this.gbB.gcu.performClick();
                }
            }
        };
        this.aYT = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.gbB != null && a.this.gbB.gcu != null) {
                        int[] iArr = new int[2];
                        a.this.gbB.gcu.getLocationOnScreen(iArr);
                        jSONObject.putOpt("turn_tab_x", Integer.valueOf(iArr[0]));
                        jSONObject.putOpt("turn_tab_y", Integer.valueOf(iArr[1]));
                    }
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_TURN_TAB_LOC, jSONObject.toString());
                } catch (JSONException e) {
                    return null;
                }
            }
        };
        this.gbP = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.bFJ();
            }
        };
        MessageManager.getInstance().registerListener(this.gbI);
        MessageManager.getInstance().registerListener(this.gbJ);
        MessageManager.getInstance().registerListener(this.gbK);
        MessageManager.getInstance().registerListener(this.gbL);
        MessageManager.getInstance().registerListener(this.gbM);
        MessageManager.getInstance().registerListener(this.gbN);
        MessageManager.getInstance().registerListener(this.gbO);
        MessageManager.getInstance().registerListener(this.gbP);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_TURN_TAB_LOC, this.aYT);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void kx(boolean z) {
        if (this.gbB != null) {
            this.gbB.kx(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.gbB != null) {
            this.gbB.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, int i, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.gbC = aVar;
            this.avX = i;
            this.foI = viewGroup;
            if (this.gbB == null) {
                this.gbB = new AlaLiveBottomOperationView(getPageContext());
            }
            this.gbB.registerListeners();
            this.gbE = bVar;
            this.gbB.setOnLiveViewOperationBtnClickListener(bVar);
            this.gbB.getRootView().setId(a.g.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.gbB.getRootView()) >= 0) {
                viewGroup.removeView(this.gbB.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.gbB.getRootView().setBackgroundResource(a.f.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.gbB.getRootView().setBackgroundResource(a.d.sdk_transparent);
            }
            viewGroup.addView(this.gbB.getRootView(), layoutParams);
            if (this.gbD == null) {
                this.gbD = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.gbD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.l(view, 8);
                        }
                    }
                });
            }
            this.gbB.fYb.setVisibility(8);
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                bFC();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.gbB.gbZ != null) {
                this.gbB.gbZ.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.gbB != null && this.gbB.gcn != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds68));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds22);
                    layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds28);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds10) + UtilHelper.getStatusBarHeight();
                    }
                    layoutParams2.gravity = 53;
                    this.gbB.gcn.setVisibility(8);
                    if (this.gbB.gcn.getParent() != null && (this.gbB.gcn.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.gbB.gcn.getParent()).removeView(this.gbB.gcn);
                    }
                    aVar.fTl.getLiveContainerView().addView(this.gbB.gcn, layoutParams2);
                    return;
                }
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds96));
                layoutParams3.gravity = 83;
                if (this.gbD.getParent() != null && (this.gbD.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.gbD.getParent()).removeView(this.gbD);
                }
                aVar.fTl.getLiveContainerView().addView(this.gbD, layoutParams3);
            }
        }
    }

    private void bFC() {
        bl blVar;
        bg bgVar;
        if (this.gbF != null) {
            this.gbB.gcu.removeOnLayoutChangeListener(this.gbF);
        }
        ax axVar = com.baidu.live.v.a.Ge().aYP;
        if (axVar != null && (blVar = axVar.aAL) != null && blVar.aCw && (bgVar = axVar.aAI) != null && bgVar.aBG != null && !TextUtils.isEmpty(bgVar.aBG.webUrl)) {
            this.gbB.gcu.setVisibility(0);
            this.gbB.gcv.setVisibility(0);
            this.gbB.gcw.setVisibility(8);
            return;
        }
        this.gbB.gcu.setVisibility(8);
    }

    public void a(InterfaceC0568a interfaceC0568a) {
        if (this.gbB != null && this.gbB.gcu != null && this.gbB.gcu.getVisibility() == 0) {
            this.gbG = interfaceC0568a;
            this.gbF = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.bFD();
                }
            };
            this.gbB.gcu.addOnLayoutChangeListener(this.gbF);
            this.gbB.gcu.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.12
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gbG != null) {
                        int[] iArr = new int[2];
                        a.this.gbB.gcu.getLocationInWindow(iArr);
                        a.this.gbG.bv((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.gbB.gcu.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.gbB.gcu.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFD() {
        if (this.gbB != null && this.gbB.gcu != null && this.gbB.gcu.getVisibility() == 0) {
            this.gbB.gcu.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.13
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gbB != null && a.this.gbB.gcu != null && a.this.gbB.gcu.getVisibility() == 0 && a.this.gbG != null) {
                        int[] iArr = new int[2];
                        a.this.gbB.gcu.getLocationInWindow(iArr);
                        a.this.gbG.bw((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.gbB.gcu.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.gbB.gcu.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.gbB != null && this.gbB.gcu != null && this.gbB.gcu.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.gbB.gcv.getVisibility() == 0) {
                    this.gbB.gcv.setVisibility(8);
                }
                if (this.gbB.gcw.getVisibility() != 0) {
                    this.gbB.gcw.setVisibility(0);
                }
                this.gbB.gcw.setTimer(str, f);
                return;
            }
            if (this.gbB.gcv.getVisibility() != 0) {
                this.gbB.gcv.setVisibility(0);
            }
            if (this.gbB.gcw.getVisibility() == 0) {
                this.gbB.gcw.setVisibility(8);
            }
        }
    }

    public void bFE() {
        if (this.gbB != null && this.gbB.gcu != null && this.gbF != null) {
            this.gbB.gcu.removeOnLayoutChangeListener(this.gbF);
        }
        this.gbH = 0L;
        if (this.gbB != null) {
            this.gbB.lk(false);
        }
        if (this.foI != null && this.gbB != null && this.foI.indexOfChild(this.gbB.getRootView()) > 0) {
            this.foI.removeView(this.gbB.getRootView());
        }
        if (this.gbD != null && (this.gbD.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gbD.getParent()).removeView(this.gbD);
        }
        if (this.gbB != null && this.gbB.gcn != null && (this.gbB.gcn.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gbB.gcn.getParent()).removeView(this.gbB.gcn);
        }
    }

    public void setVisibility(int i) {
        if (this.gbB != null && this.gbB.getRootView() != null) {
            this.gbB.getRootView().setVisibility(i);
        }
        if (this.gbD != null) {
            this.gbD.setVisibility(i);
        }
    }

    public void a(com.baidu.live.gift.o oVar, q qVar) {
        if (this.gbB != null) {
            if (qVar != null && qVar.avC != null) {
                this.gbB.a(qVar.avC.isNewUser, qVar.mLiveInfo, DN());
            } else {
                this.gbB.a(false, null, DN());
            }
            if (oVar == null || TextUtils.isEmpty(oVar.yk()) || oVar.yj() != 1) {
                this.gbB.gbX.setVisibility(8);
                return;
            }
            this.gbB.gbX.setVisibility(0);
            this.gbB.gbW.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.gbB.gbW.startLoad(oVar.yk(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.gbB.gcp.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.gbB.gbX.setVisibility(8);
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_SHOW);
                if (oVar.yi() != null) {
                    alaStaticItem.addParams("gifts_value", oVar.yi().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, oVar.yi().xl());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, oVar.yi().xm());
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

    public View bFF() {
        return this.gbB.fYb;
    }

    public String DN() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void bFG() {
        if (this.gbB != null) {
            this.gbB.setMsgLayoutWidth(false);
            this.gbB.gcx.setVisibility(8);
            this.gbB.gcy.setVisibility(8);
        }
    }

    public void bFH() {
        if (this.gbB != null) {
            this.gbB.setMsgLayoutWidth(true);
            this.gbB.gcx.setVisibility(0);
            this.gbB.gcy.setVisibility(0);
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.gbB != null) {
            if (i3 == 2) {
                bFH();
            } else if (i3 == 1) {
                bFG();
            }
            bFD();
        }
    }

    public void rx(int i) {
        if (this.gbB != null && this.gbB.gcn != null) {
            this.gbB.gcn.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.gbB != null && this.gbB.gbV != null) {
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
            if (this.foI != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.15
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (a.this.foI != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout = a.this.gbB.gbV;
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
                            a.this.foI.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.foI != null) {
                            a.this.foI.removeView(inflate);
                        }
                    }
                }, i + j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFI() {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.gbB != null && this.gbB.gbV != null && this.aWS != null && !this.aWS.isEmpty()) {
            try {
                an anVar = this.aWS.get((int) (Math.random() * this.aWS.size()));
                final View inflate = getPageContext().getPageActivity().getLayoutInflater().inflate(a.h.toast_goods_guide, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) inflate.findViewById(a.g.conver_imageView);
                tbImageView.setDefaultBgResource(a.f.sdk_shape_transparent);
                if (!TextUtils.isEmpty(anVar.azI)) {
                    try {
                        JSONArray jSONArray = new JSONArray(anVar.azI);
                        if (jSONArray.length() > 0) {
                            tbImageView.startLoad(jSONArray.optJSONObject(0).optString(UserAccountActionItem.KEY_SRC), 10, false);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                TextView textView = (TextView) inflate.findViewById(a.g.title_textView);
                TextView textView2 = (TextView) inflate.findViewById(a.g.price_textView);
                String str = anVar.title;
                if (str == null) {
                    str = "";
                } else if (str.length() > 8) {
                    str = str.substring(0, 8) + StringHelper.STRING_MORE;
                }
                textView.setText(str);
                textView2.setText(anVar.price);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.18
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.handler.removeCallbacksAndMessages(null);
                        if (a.this.foI != null) {
                            a.this.foI.removeView(inflate);
                        }
                        if (a.this.gbE != null) {
                            a.this.gbE.l(view, 15);
                        }
                        if (a.this.gbC != null && a.this.gbC.fTm != null && a.this.gbC.fTm.Fk() != null && a.this.gbC.fTm.Fk().mLiveInfo != null) {
                            long j = a.this.gbC.fTm.Fk().mLiveInfo.live_id;
                            long j2 = a.this.gbC.fTm.Fk().mLiveInfo.room_id;
                            LogManager.getLiveGoodsLogger().doClickGoodsGuideLog(j + "", j2 + "", a.this.gbC.fTm.Fk().mLiveInfo.feed_id, a.this.otherParams);
                        }
                    }
                });
                if (this.foI != null) {
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Activity pageActivity;
                            if (a.this.foI != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                                inflate.measure(0, 0);
                                View view = a.this.gbB.fYb;
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
                                a.this.foI.addView(inflate, layoutParams);
                                if (a.this.gbC != null && a.this.gbC.fTm != null && a.this.gbC.fTm.Fk() != null && a.this.gbC.fTm.Fk().mLiveInfo != null) {
                                    long j = a.this.gbC.fTm.Fk().mLiveInfo.live_id;
                                    long j2 = a.this.gbC.fTm.Fk().mLiveInfo.room_id;
                                    String str2 = a.this.gbC.fTm.Fk().mLiveInfo.feed_id;
                                    if (!ILiveGoodsLogger.displayGoodsGuideMap.contains(Long.valueOf(j))) {
                                        ILiveGoodsLogger.displayGoodsGuideMap.add(Long.valueOf(j));
                                        LogManager.getLiveGoodsLogger().doDisplayGoodsGuideLog(j + "", j2 + "", str2, a.this.otherParams);
                                    }
                                }
                            }
                        }
                    }, 200L);
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.foI != null) {
                                a.this.foI.removeView(inflate);
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
        if (this.gbB != null) {
            return this.gbB.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.gbH = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gbI);
        MessageManager.getInstance().unRegisterListener(this.gbJ);
        MessageManager.getInstance().unRegisterListener(this.gbK);
        MessageManager.getInstance().unRegisterListener(this.gbL);
        MessageManager.getInstance().unRegisterListener(this.gbM);
        MessageManager.getInstance().unRegisterListener(this.gbN);
        MessageManager.getInstance().unRegisterListener(this.gbO);
        MessageManager.getInstance().unRegisterListener(this.gbP);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TURN_TAB_LOC);
        this.gbG = null;
        if (this.gbB != null) {
            if (this.gbF != null) {
                this.gbB.gcu.removeOnLayoutChangeListener(this.gbF);
            }
            this.gbB.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFJ() {
        if (this.gbB != null && this.gbB.gcv != null) {
            this.gbB.gcv.setScaleX(1.1f);
            this.gbB.gcv.setScaleY(1.1f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gbB.gcv, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gbB.gcv, View.SCALE_Y, 1.1f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gbB.gcv, View.SCALE_X, 1.0f, 1.1f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.gbB.gcv, View.SCALE_Y, 1.0f, 1.1f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(100L);
            animatorSet2.playTogether(ofFloat3, ofFloat4);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.gbB.gcv, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.gbB.gcv, View.SCALE_Y, 1.1f, 1.0f);
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
