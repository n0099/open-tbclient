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
    private ViewGroup fox;
    CustomMessageListener gbA;
    private CustomMessageListener gbB;
    private CustomMessageListener gbC;
    private CustomMessageListener gbD;
    private CustomMessageListener gbE;
    private AlaLiveBottomOperationView gbq;
    private com.baidu.tieba.ala.liveroom.data.a gbr;
    private FrameLayout gbs;
    private b gbt;
    private View.OnLayoutChangeListener gbu;
    private InterfaceC0568a gbv;
    private long gbw;
    private CustomMessageListener gbx;
    private CustomMessageListener gby;
    CustomMessageListener gbz;
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
        this.gbx = new CustomMessageListener(2913098) { // from class: com.baidu.tieba.ala.liveroom.operation.a.14
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
        this.gby = new CustomMessageListener(2913188) { // from class: com.baidu.tieba.ala.liveroom.operation.a.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str = null;
                int i = 3000;
                if (com.baidu.tieba.ala.liveroom.t.a.bGk().aWQ != null) {
                    str = com.baidu.tieba.ala.liveroom.t.a.bGk().aWQ.awb;
                    i = com.baidu.tieba.ala.liveroom.t.a.bGk().aWQ.duration;
                }
                if (!TextUtils.isEmpty(str)) {
                    a.this.b(str, 1000L, i);
                }
            }
        };
        this.gbz = new CustomMessageListener(2913111) { // from class: com.baidu.tieba.ala.liveroom.operation.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gbq != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) customResponsedMessage.getData();
                    int i = getVideoGoodsListHttpResponseMessage.count;
                    if (i <= 0) {
                        a.this.gbq.fXQ.setVisibility(8);
                    } else {
                        if (a.this.gbq.fXQ.getVisibility() == 8) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "shopcart_show"));
                        }
                        a.this.gbq.fXQ.setVisibility(0);
                        if (a.this.gbw != getVideoGoodsListHttpResponseMessage.liveId) {
                            a.this.gbw = getVideoGoodsListHttpResponseMessage.liveId;
                            a.this.gbq.lk(true);
                        }
                        if (a.this.gbr != null && a.this.gbr.fTb != null && a.this.gbr.fTb.Fk() != null && a.this.gbr.fTb.Fk().mLiveInfo != null) {
                            long j = a.this.gbr.fTb.Fk().mLiveInfo.live_id;
                            long j2 = a.this.gbr.fTb.Fk().mLiveInfo.room_id;
                            String str = a.this.gbr.fTb.Fk().mLiveInfo.feed_id;
                            if (!ILiveGoodsLogger.displayStoreIconMap.contains(Long.valueOf(j))) {
                                ILiveGoodsLogger.displayStoreIconMap.add(Long.valueOf(j));
                                LogManager.getLiveGoodsLogger().doDisplayStoreIconLog(j + "", j2 + "", str, a.this.otherParams);
                            }
                        }
                    }
                    a.this.aWS = getVideoGoodsListHttpResponseMessage.aWS;
                    if (getVideoGoodsListHttpResponseMessage.getOrginalMessage() != null && (getVideoGoodsListHttpResponseMessage.getOrginalMessage() instanceof h) && ((h) getVideoGoodsListHttpResponseMessage.getOrginalMessage()).aWR && i > 0 && a.this.aWS != null && a.this.aWS.size() > 0) {
                        a.this.bFG();
                    }
                }
            }
        };
        this.gbA = new CustomMessageListener(2913112) { // from class: com.baidu.tieba.ala.liveroom.operation.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gbq != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaLiveInfoData)) {
                    AlaLiveInfoData alaLiveInfoData = (AlaLiveInfoData) customResponsedMessage.getData();
                    o.a(alaLiveInfoData.feed_id, alaLiveInfoData.live_id, false, true);
                }
            }
        };
        this.gbB = new CustomMessageListener(2913115) { // from class: com.baidu.tieba.ala.liveroom.operation.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gbq != null) {
                    a.this.gbq.a(false, null, a.this.DN());
                }
            }
        };
        this.gbC = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.operation.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && "refreshInfo".equals(customResponsedMessage.getData())) {
                    BdLog.d("--refreshInfo--");
                    q Fk = (a.this.gbr == null || a.this.gbr.fTb == null) ? null : a.this.gbr.fTb.Fk();
                    if (Fk == null || Fk.avC == null) {
                        a.this.gbq.a(false, null, a.this.DN());
                    } else {
                        a.this.gbq.a(Fk.avC.isNewUser, Fk.mLiveInfo, a.this.DN());
                    }
                }
            }
        };
        this.gbD = new CustomMessageListener(2913173) { // from class: com.baidu.tieba.ala.liveroom.operation.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.gbq != null && a.this.gbq.gcj != null) {
                    a.this.gbq.gcj.performClick();
                }
            }
        };
        this.aYT = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.9
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (a.this.gbq != null && a.this.gbq.gcj != null) {
                        int[] iArr = new int[2];
                        a.this.gbq.gcj.getLocationOnScreen(iArr);
                        jSONObject.putOpt("turn_tab_x", Integer.valueOf(iArr[0]));
                        jSONObject.putOpt("turn_tab_y", Integer.valueOf(iArr[1]));
                    }
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_TURN_TAB_LOC, jSONObject.toString());
                } catch (JSONException e) {
                    return null;
                }
            }
        };
        this.gbE = new CustomMessageListener(2913174) { // from class: com.baidu.tieba.ala.liveroom.operation.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.bFH();
            }
        };
        MessageManager.getInstance().registerListener(this.gbx);
        MessageManager.getInstance().registerListener(this.gby);
        MessageManager.getInstance().registerListener(this.gbz);
        MessageManager.getInstance().registerListener(this.gbA);
        MessageManager.getInstance().registerListener(this.gbB);
        MessageManager.getInstance().registerListener(this.gbC);
        MessageManager.getInstance().registerListener(this.gbD);
        MessageManager.getInstance().registerListener(this.gbE);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_TURN_TAB_LOC, this.aYT);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void kx(boolean z) {
        if (this.gbq != null) {
            this.gbq.kx(z);
        }
    }

    public void b(boolean z, int i, int i2, String str) {
        if (this.gbq != null) {
            this.gbq.b(z, i, i2, str);
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.data.a aVar, ViewGroup viewGroup, int i, boolean z, final b bVar) {
        if (aVar != null && viewGroup != null) {
            this.gbr = aVar;
            this.avX = i;
            this.fox = viewGroup;
            if (this.gbq == null) {
                this.gbq = new AlaLiveBottomOperationView(getPageContext());
            }
            this.gbq.registerListeners();
            this.gbt = bVar;
            this.gbq.setOnLiveViewOperationBtnClickListener(bVar);
            this.gbq.getRootView().setId(a.g.ala_liveroom_bottom_operation);
            if (viewGroup.indexOfChild(this.gbq.getRootView()) >= 0) {
                viewGroup.removeView(this.gbq.getRootView());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (z) {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.gbq.getRootView().setBackgroundResource(a.f.ala_live_room_im_bg_shape);
            } else {
                layoutParams.height = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
                this.gbq.getRootView().setBackgroundResource(a.d.sdk_transparent);
            }
            viewGroup.addView(this.gbq.getRootView(), layoutParams);
            if (this.gbs == null) {
                this.gbs = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_liveroom_bottom_back_layout, (ViewGroup) null);
                this.gbs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (bVar != null) {
                            bVar.l(view, 8);
                        }
                    }
                });
            }
            this.gbq.fXQ.setVisibility(8);
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                bFA();
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isShareBtnUnabled() && this.gbq.gbO != null) {
                this.gbq.gbO.setVisibility(8);
            }
            if (z) {
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.gbq != null && this.gbq.gcc != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds68));
                    layoutParams2.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds22);
                    layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds28);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds10) + UtilHelper.getStatusBarHeight();
                    }
                    layoutParams2.gravity = 53;
                    this.gbq.gcc.setVisibility(8);
                    if (this.gbq.gcc.getParent() != null && (this.gbq.gcc.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.gbq.gcc.getParent()).removeView(this.gbq.gcc);
                    }
                    aVar.fTa.getLiveContainerView().addView(this.gbq.gcc, layoutParams2);
                    return;
                }
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds96));
                layoutParams3.gravity = 83;
                if (this.gbs.getParent() != null && (this.gbs.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.gbs.getParent()).removeView(this.gbs);
                }
                aVar.fTa.getLiveContainerView().addView(this.gbs, layoutParams3);
            }
        }
    }

    private void bFA() {
        bl blVar;
        bg bgVar;
        if (this.gbu != null) {
            this.gbq.gcj.removeOnLayoutChangeListener(this.gbu);
        }
        ax axVar = com.baidu.live.v.a.Ge().aYP;
        if (axVar != null && (blVar = axVar.aAL) != null && blVar.aCw && (bgVar = axVar.aAI) != null && bgVar.aBG != null && !TextUtils.isEmpty(bgVar.aBG.webUrl)) {
            this.gbq.gcj.setVisibility(0);
            this.gbq.gck.setVisibility(0);
            this.gbq.gcl.setVisibility(8);
            return;
        }
        this.gbq.gcj.setVisibility(8);
    }

    public void a(InterfaceC0568a interfaceC0568a) {
        if (this.gbq != null && this.gbq.gcj != null && this.gbq.gcj.getVisibility() == 0) {
            this.gbv = interfaceC0568a;
            this.gbu = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.ala.liveroom.operation.a.11
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.bFB();
                }
            };
            this.gbq.gcj.addOnLayoutChangeListener(this.gbu);
            this.gbq.gcj.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.12
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gbv != null) {
                        int[] iArr = new int[2];
                        a.this.gbq.gcj.getLocationInWindow(iArr);
                        a.this.gbv.bv((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.gbq.gcj.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.gbq.gcj.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFB() {
        if (this.gbq != null && this.gbq.gcj != null && this.gbq.gcj.getVisibility() == 0) {
            this.gbq.gcj.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.13
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gbq != null && a.this.gbq.gcj != null && a.this.gbq.gcj.getVisibility() == 0 && a.this.gbv != null) {
                        int[] iArr = new int[2];
                        a.this.gbq.gcj.getLocationInWindow(iArr);
                        a.this.gbv.bw((ScreenHelper.getScreenWidth(a.this.getPageContext().getPageActivity()) - iArr[0]) - (a.this.gbq.gcj.getWidth() / 2), a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20) + a.this.gbq.gcj.getHeight() + a.this.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds12));
                    }
                }
            });
        }
    }

    public void b(float f, String str) {
        if (this.gbq != null && this.gbq.gcj != null && this.gbq.gcj.getVisibility() == 0) {
            if (f > 0.0f) {
                if (this.gbq.gck.getVisibility() == 0) {
                    this.gbq.gck.setVisibility(8);
                }
                if (this.gbq.gcl.getVisibility() != 0) {
                    this.gbq.gcl.setVisibility(0);
                }
                this.gbq.gcl.setTimer(str, f);
                return;
            }
            if (this.gbq.gck.getVisibility() != 0) {
                this.gbq.gck.setVisibility(0);
            }
            if (this.gbq.gcl.getVisibility() == 0) {
                this.gbq.gcl.setVisibility(8);
            }
        }
    }

    public void bFC() {
        if (this.gbq != null && this.gbq.gcj != null && this.gbu != null) {
            this.gbq.gcj.removeOnLayoutChangeListener(this.gbu);
        }
        this.gbw = 0L;
        if (this.gbq != null) {
            this.gbq.lk(false);
        }
        if (this.fox != null && this.gbq != null && this.fox.indexOfChild(this.gbq.getRootView()) > 0) {
            this.fox.removeView(this.gbq.getRootView());
        }
        if (this.gbs != null && (this.gbs.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gbs.getParent()).removeView(this.gbs);
        }
        if (this.gbq != null && this.gbq.gcc != null && (this.gbq.gcc.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gbq.gcc.getParent()).removeView(this.gbq.gcc);
        }
    }

    public void setVisibility(int i) {
        if (this.gbq != null && this.gbq.getRootView() != null) {
            this.gbq.getRootView().setVisibility(i);
        }
        if (this.gbs != null) {
            this.gbs.setVisibility(i);
        }
    }

    public void a(com.baidu.live.gift.o oVar, q qVar) {
        if (this.gbq != null) {
            if (qVar != null && qVar.avC != null) {
                this.gbq.a(qVar.avC.isNewUser, qVar.mLiveInfo, DN());
            } else {
                this.gbq.a(false, null, DN());
            }
            if (oVar == null || TextUtils.isEmpty(oVar.yk()) || oVar.yj() != 1) {
                this.gbq.gbM.setVisibility(8);
                return;
            }
            this.gbq.gbM.setVisibility(0);
            this.gbq.gbL.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.gbq.gbL.startLoad(oVar.yk(), 10, false);
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFirstChargeUnabled()) {
                this.gbq.gce.setVisibility(8);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isQuickGiftUnabled()) {
                this.gbq.gbM.setVisibility(8);
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

    public View bFD() {
        return this.gbq.fXQ;
    }

    public String DN() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void bFE() {
        if (this.gbq != null) {
            this.gbq.setMsgLayoutWidth(false);
            this.gbq.gcm.setVisibility(8);
            this.gbq.gcn.setVisibility(8);
        }
    }

    public void bFF() {
        if (this.gbq != null) {
            this.gbq.setMsgLayoutWidth(true);
            this.gbq.gcm.setVisibility(0);
            this.gbq.gcn.setVisibility(0);
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.gbq != null) {
            if (i3 == 2) {
                bFF();
            } else if (i3 == 1) {
                bFE();
            }
            bFB();
        }
    }

    public void rv(int i) {
        if (this.gbq != null && this.gbq.gcc != null) {
            this.gbq.gcc.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, int i) {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.gbq != null && this.gbq.gbK != null) {
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
            if (this.fox != null) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.15
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (a.this.fox != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout = a.this.gbq.gbK;
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
                            a.this.fox.addView(inflate, layoutParams);
                        }
                    }
                }, j);
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.fox != null) {
                            a.this.fox.removeView(inflate);
                        }
                    }
                }, i + j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFG() {
        if (getPageContext() != null && getPageContext().getPageActivity() != null && this.gbq != null && this.gbq.gbK != null && this.aWS != null && !this.aWS.isEmpty()) {
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
                        if (a.this.fox != null) {
                            a.this.fox.removeView(inflate);
                        }
                        if (a.this.gbt != null) {
                            a.this.gbt.l(view, 15);
                        }
                        if (a.this.gbr != null && a.this.gbr.fTb != null && a.this.gbr.fTb.Fk() != null && a.this.gbr.fTb.Fk().mLiveInfo != null) {
                            long j = a.this.gbr.fTb.Fk().mLiveInfo.live_id;
                            long j2 = a.this.gbr.fTb.Fk().mLiveInfo.room_id;
                            LogManager.getLiveGoodsLogger().doClickGoodsGuideLog(j + "", j2 + "", a.this.gbr.fTb.Fk().mLiveInfo.feed_id, a.this.otherParams);
                        }
                    }
                });
                if (this.fox != null) {
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.operation.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Activity pageActivity;
                            if (a.this.fox != null && (pageActivity = a.this.getPageContext().getPageActivity()) != null && !pageActivity.isFinishing()) {
                                inflate.measure(0, 0);
                                View view = a.this.gbq.fXQ;
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
                                a.this.fox.addView(inflate, layoutParams);
                                if (a.this.gbr != null && a.this.gbr.fTb != null && a.this.gbr.fTb.Fk() != null && a.this.gbr.fTb.Fk().mLiveInfo != null) {
                                    long j = a.this.gbr.fTb.Fk().mLiveInfo.live_id;
                                    long j2 = a.this.gbr.fTb.Fk().mLiveInfo.room_id;
                                    String str2 = a.this.gbr.fTb.Fk().mLiveInfo.feed_id;
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
                            if (a.this.fox != null) {
                                a.this.fox.removeView(inflate);
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
        if (this.gbq != null) {
            return this.gbq.getLandscapeBarrageImageView();
        }
        return null;
    }

    public void onDestory() {
        this.gbw = 0L;
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gbx);
        MessageManager.getInstance().unRegisterListener(this.gby);
        MessageManager.getInstance().unRegisterListener(this.gbz);
        MessageManager.getInstance().unRegisterListener(this.gbA);
        MessageManager.getInstance().unRegisterListener(this.gbB);
        MessageManager.getInstance().unRegisterListener(this.gbC);
        MessageManager.getInstance().unRegisterListener(this.gbD);
        MessageManager.getInstance().unRegisterListener(this.gbE);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TURN_TAB_LOC);
        this.gbv = null;
        if (this.gbq != null) {
            if (this.gbu != null) {
                this.gbq.gcj.removeOnLayoutChangeListener(this.gbu);
            }
            this.gbq.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFH() {
        if (this.gbq != null && this.gbq.gck != null) {
            this.gbq.gck.setScaleX(1.1f);
            this.gbq.gck.setScaleY(1.1f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gbq.gck, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gbq.gck, View.SCALE_Y, 1.1f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gbq.gck, View.SCALE_X, 1.0f, 1.1f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.gbq.gck, View.SCALE_Y, 1.0f, 1.1f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(100L);
            animatorSet2.playTogether(ofFloat3, ofFloat4);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.gbq.gck, View.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.gbq.gck, View.SCALE_Y, 1.1f, 1.0f);
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
