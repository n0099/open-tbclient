package com.baidu.tieba.ala.liveroom.c;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.controller.HttpRule;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.f;
import com.baidu.live.challenge.i;
import com.baidu.live.challenge.j;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.ag;
import com.baidu.live.data.ah;
import com.baidu.live.data.as;
import com.baidu.live.data.bb;
import com.baidu.live.data.bh;
import com.baidu.live.data.h;
import com.baidu.live.data.l;
import com.baidu.live.data.z;
import com.baidu.live.gift.n;
import com.baidu.live.gift.y;
import com.baidu.live.guardclub.e;
import com.baidu.live.im.k;
import com.baidu.live.im.m;
import com.baidu.live.message.GetQuickGiftHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
import com.baidu.live.tbadk.core.atomdata.CommonWebViewActivityConfig;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.ILiveGoodsLogger;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.u.a;
import com.baidu.live.utils.o;
import com.baidu.live.view.dispatch.DispatchedPvlLayout;
import com.baidu.live.view.dispatch.DispatchedRelativeLayout;
import com.baidu.tieba.ala.liveroom.guide.a;
import com.baidu.tieba.ala.liveroom.h.b;
import com.baidu.tieba.ala.liveroom.h.g;
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends b {
    private LinearLayout fvY;
    private com.baidu.tieba.ala.liveroom.audiencelist.c fvZ;
    private boolean fvf;
    private com.baidu.tieba.ala.liveroom.l.a fwa;
    private com.baidu.tieba.ala.liveroom.e.b fwb;
    private com.baidu.tieba.ala.liveroom.r.b fwc;
    private com.baidu.tieba.ala.liveroom.operation.a fwd;
    private com.baidu.tieba.ala.liveroom.audiencelist.b fwe;
    private com.baidu.tieba.ala.liveroom.j.a fwf;
    private com.baidu.tieba.ala.liveroom.activeview.b fwg;
    private com.baidu.live.d.a fwh;
    private j fwi;
    private i fwj;
    private com.baidu.tieba.ala.liveroom.attentionpop.b fwk;
    private FrameLayout fwn;
    private com.baidu.tieba.ala.liveroom.h.b fwv;
    private DispatchedPvlLayout fym;
    private View fyn;
    private DispatchedRelativeLayout fyo;
    private f fyp;
    private long lastClickTime = 0;
    private boolean fyq = false;
    private HttpRule fww = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.fwi != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.fwi.uv()) {
                httpMessage.addParam("ala_challenge_id", d.this.fwi.uy());
            }
            return httpMessage;
        }
    };
    private HttpRule fwx = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.c.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.fwi != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.fwi.uv()) {
                httpMessage.addParam("challenge_id", d.this.fwi.uy());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c fwy = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.c.d.17
        @Override // com.baidu.live.liveroom.g.c
        public void DK() {
            if (d.this.fwX != null) {
                d.this.fwX.kX(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bK(boolean z) {
            if (z) {
                if (d.this.fwd != null) {
                    d.this.fwd.qU(8);
                }
                if (d.this.fwX != null) {
                    d.this.fwX.kX(true);
                }
            } else {
                if (d.this.fwd != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                        d.this.fwd.qU(0);
                    } else {
                        d.this.fwd.qU(8);
                    }
                }
                if (d.this.fwX != null) {
                    d.this.fwX.kX(false);
                }
            }
            if (d.this.fxo != null) {
                d.this.fxo.aZ(z);
            }
        }
    };
    private HttpMessageListener fwz = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.d.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.DU() != null) {
                        com.baidu.live.v.c.Es().aRJ = getQuickGiftHttpResponseMessage.DU();
                        d.this.brX();
                    }
                }
            }
        }
    };
    private CustomMessageListener fwA = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.d.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.bsi();
        }
    };
    CustomMessageListener fwE = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.c.d.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.fwv.c(d.this.btg());
                } else if (d.this.bsC() || !g.qv(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, 3000L);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.btg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.btg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    d.this.fwv.b(d.this.fwn, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener fyr = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.c.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.bsC() || !g.qv(2913128)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.21.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.qt(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, 3000L);
                } else {
                    d.this.AC(str);
                }
            }
        }
    };
    private CustomMessageListener fys = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.c.d.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.fxe.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fwB = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.c.d.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.this.fxs != null) {
                    d.this.fxs.AE(str);
                }
            }
        }
    };
    CustomMessageListener fwC = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.c.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.fxG != null && d.this.fxG.aIX != null && !d.this.fxG.aJa && !d.this.fxG.aJb && d.this.fxn != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.btg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = d.this.btg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                d.this.fxn.b(d.this.fwn, layoutParams);
                if (e.Aq() != null) {
                    e.Aq().Aw();
                }
            }
        }
    };
    private CustomMessageListener fwD = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.fxq != null) {
                    d.this.fxq.dismiss();
                }
                if (d.this.fxs != null) {
                    d.this.fxs.dismiss();
                }
                m.Bo().setSwitchStatus(true);
                m.Bo().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bsI();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b fwF = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.d.13
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void l(View view, int i) {
            as asVar;
            bb bbVar;
            bh bhVar;
            String str;
            as asVar2;
            bb bbVar2;
            String str2;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - d.this.lastClickTime >= 300) {
                d.this.lastClickTime = currentTimeMillis;
                if (i == 2) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "gift_panel"));
                    d.this.M(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.v.c.Es().aRJ.wR().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.v.c.Es().aRJ.wR().vU());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.v.c.Es().aRJ.wR().vV());
                        if (d.this.btg().fFh.DM() != null && d.this.btg().fFh.DM().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.btg().fFh.DM().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.btg().fFh.DM().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.Cq());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.zz()) {
                        if (com.baidu.live.c.tG().getBoolean("quick_gift_guide_show", true) && !d.this.bsC()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, y.class, d.this.btg().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                y yVar = (y) runTask.getData();
                                yVar.setPageContext(d.this.btg().pageContext);
                                yVar.d(d.this.btg().fFh.DM());
                                yVar.setGiftItem(com.baidu.live.v.c.Es().aRJ.wR());
                                yVar.setOtherParams(d.this.Cq());
                                yVar.initView();
                                yVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.d.13.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        d.this.jY(false);
                                    }
                                });
                                yVar.show();
                                d.this.jY(true);
                                return;
                            }
                            return;
                        }
                        n.a(d.this.btg().pageContext, d.this.btg().fFh.DM(), com.baidu.live.v.c.Es().aRJ.wR(), d.this.Cq());
                    }
                } else if (i == 1) {
                    if (d.this.fxb != null) {
                        d.this.bsI();
                    }
                } else if (i == 3 && d.this.zz()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "share_clk"));
                    d.this.fwQ.c(d.this.btg().fFh.DM(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.btg() != null && d.this.btg().fFh != null && d.this.btg().fFh.DM() != null && d.this.btg().fFh.DM().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.btg().fFh.DM().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.btg().fFh.DM().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.btg().fFh.DM().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.Cq());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.btg() != null && d.this.btg().fFh != null && d.this.btg().fFh.DM() != null && d.this.btg().fFh.DM().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.btg().fFh.DM().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.btg().fFh.DM().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.btg().fFh.DM().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.Cq());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.aPZ != null) {
                        d.this.aPZ.bF(false);
                    }
                } else if (i == 12) {
                    if (d.this.fwX != null && d.this.btg().fFh.DM() != null && d.this.btg().fFh.DM().mLiveInfo != null) {
                        String valueOf = String.valueOf(d.this.btg().fFh.DM().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.btg().fFh.DM().mLiveInfo.room_id);
                        String str3 = null;
                        l lVar = d.this.btg().fFh.DM().mLiveSdkInfo;
                        if (lVar != null && lVar.mCastIds != null) {
                            str3 = String.valueOf(d.this.btg().fFh.DM().mLiveSdkInfo.mCastIds.aqw);
                        }
                        d.this.fwX.ac(valueOf, valueOf2, str3);
                        if (com.baidu.live.liveroom.a.Dk().Dl()) {
                            d.this.bsi();
                        }
                    }
                } else if (i == 14) {
                    com.baidu.live.data.n DM = d.this.btg().fFh.DM();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.btg().pageContext.getPageActivity(), DM.aqk.userName, Long.toString(DM.aqk.userId), Long.toString(DM.aqk.charmCount), String.valueOf(DM.mLiveInfo.group_id), String.valueOf(DM.mLiveInfo.live_id), false, String.valueOf(DM.aqk.userId), Long.toString(DM.aqD.userId), DM.aqD.userName, DM.aqD.portrait, d.this.fwe.getCount(), d.this.Cq())));
                    LogManager.getCommonLogger().doClickGusetNumLog(DM.mLiveInfo.feed_id, d.this.fwe.getCount() + "", d.this.Cq());
                } else if (i == 11) {
                    d.this.bsL();
                    d.this.bsM();
                } else if (i == 15) {
                    if (d.this.fxl != null && d.this.btg() != null && d.this.btg().fFh != null && d.this.btg().fFh.DM() != null && d.this.btg().fFh.DM().mLiveInfo != null) {
                        long j = d.this.btg().fFh.DM().mLiveInfo.live_id;
                        String valueOf3 = String.valueOf(d.this.btg().fFh.DM().mLiveInfo.feed_id);
                        long j2 = d.this.btg().fFh.DM().mLiveInfo.room_id;
                        String str4 = d.this.btg().fFh.DM().mLiveInfo.cover;
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        String str8 = "";
                        if (d.this.btg().fFh.DM().mLiveInfo.session_info != null) {
                            str5 = d.this.btg().fFh.DM().mLiveInfo.session_info.flvUrl;
                        }
                        if (!TextUtils.isEmpty(d.this.Cq())) {
                            try {
                                JSONObject jSONObject = new JSONObject(d.this.Cq());
                                str6 = jSONObject.optString("tab");
                                str7 = jSONObject.optString("tag");
                                str8 = jSONObject.optString("source");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        d.this.fxl.AE(o.a(valueOf3, j + "", j2, false, 1, str4, str5, str6, str7, str8, String.valueOf(d.this.btg().fFh.DM().aqD.userId), d.this.btg().fFh.DM().aqD.userName, String.valueOf(d.this.btg().fFh.DM().mLiveInfo.group_id), String.valueOf(d.this.btg().fFh.DM().aqk.userId)));
                        o.aXW = j;
                        if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                            ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                            LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf3, d.this.Cq());
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "shopcart_clk"));
                    }
                } else if (i == 16) {
                    if (d.this.btg() != null && (asVar2 = com.baidu.live.v.a.En().aRB) != null && (bbVar2 = asVar2.avA) != null) {
                        String str9 = bbVar2.aww.awC;
                        if (!TextUtils.isEmpty(str9)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "quick_gift"));
                            long j3 = 0;
                            if (d.this.btg().fFh != null && d.this.btg().fFh.DM() != null && d.this.btg().fFh.DM().mLiveInfo != null) {
                                j3 = d.this.btg().fFh.DM().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j3 + "", d.this.btg().fFh.DM().mLiveInfo.room_id + "", d.this.btg().fFh.DM().mLiveInfo.feed_id, d.this.Cq());
                            }
                            if (str9.contains("?")) {
                                str2 = str9 + "&liveId=" + j3;
                            } else {
                                str2 = str9 + "?liveId=" + j3;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.btg().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (d.this.btg() != null) {
                        com.baidu.live.data.n nVar = null;
                        if (d.this.btg().fFh != null) {
                            nVar = d.this.btg().fFh.DM();
                        }
                        if (nVar != null && nVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.t.a.bzX().aQF != null) {
                            String str10 = com.baidu.tieba.ala.liveroom.t.a.bzX().aQF.arb;
                            if (!TextUtils.isEmpty(str10)) {
                                if (str10.contains("?")) {
                                    str = str10 + "&live_id=" + nVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str10 + "?live_id=" + nVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(d.this.btg().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17 && d.this.zz() && d.this.btg() != null && (asVar = com.baidu.live.v.a.En().aRB) != null && (bbVar = asVar.avA) != null && (bhVar = bbVar.awx) != null && !TextUtils.isEmpty(bhVar.webUrl)) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "turntable"));
                    if (d.this.fxq != null && d.this.btg().fFh != null && d.this.btg().fFh.DM() != null) {
                        com.baidu.live.data.n DM2 = d.this.btg().fFh.DM();
                        d.this.fxq.a(bhVar.webUrl, DM2.mLiveInfo.live_id, DM2.aqD.userId, DM2.aqk.userId);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.fwS = new com.baidu.tieba.ala.liveroom.guide.c(btg().pageContext, this, false);
        this.fww.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.fww);
        this.fwx.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.fwx);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean brI() {
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void k(com.baidu.live.data.n nVar) {
        super.k(nVar);
        g.bvv();
        this.fyq = true;
        btg().fFi.setIsForceHandledTouch(false);
        btg().fFi.setSwipeClearEnable(true);
        btg().fFi.setOnLiveViewScrollListener(this.fwy);
        if (this.fwV != null) {
            this.fwV.b(this.fwF);
        }
        if (this.fxz != null) {
            this.fxz.setVisibility(0);
        }
        brM();
        brP();
        bsa();
        bsy();
        bsb();
        bsf();
        bsc();
        jU(false);
        bsP();
        bsO();
        brR();
        brY();
        bsR();
        bsh();
        bsj();
        kg(true);
        btq();
        btr();
        jZ(false);
        bsX();
        brQ();
        brX();
        brS();
        brT();
        brU();
        brV();
        ke(true);
        bsW();
        MessageManager.getInstance().registerListener(this.fwz);
        MessageManager.getInstance().registerListener(this.fwA);
        MessageManager.getInstance().registerListener(this.fys);
        MessageManager.getInstance().registerListener(this.fwC);
        MessageManager.getInstance().registerListener(this.fwD);
        MessageManager.getInstance().registerListener(this.fyr);
        MessageManager.getInstance().registerListener(this.fwE);
        MessageManager.getInstance().registerListener(this.fwB);
        bsl();
        bse();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void i(com.baidu.live.data.n nVar) {
        super.i(nVar);
        if (this.fwa != null) {
            this.fwa.t(nVar);
        }
        if (this.fwb != null) {
            this.fwb.p(nVar);
        }
        if (this.fwf != null) {
            this.fwf.s(nVar);
        }
        if (this.fwj != null) {
            this.fwj.a(nVar);
        }
        kg(false);
        ke(false);
        if (this.fwg != null) {
            this.fwg.h(nVar);
            this.fwg.jQ(this.fxJ);
            this.fwg.updateView();
            if (nVar != null && this.fxx != null && !this.fxx.hasInit && !TextUtils.isEmpty(this.fxx.avT)) {
                this.fxx.hasInit = true;
                this.fwg.Ay(this.fxx.avT);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(h hVar) {
        if (hVar != null) {
            if (this.fvZ != null && hVar.getList() != null) {
                this.fvZ.e(hVar);
            }
            if (this.fwe != null) {
                this.fwe.dk(hVar.getCount());
            }
        }
    }

    private void brK() {
        if (this.fwW != null) {
            this.fwW.ak(btg().fFg.getLiveContainerView());
        }
    }

    private void btq() {
        if (this.fwk == null) {
            this.fwk = new com.baidu.tieba.ala.liveroom.attentionpop.b(btg().pageContext);
        }
        if (btg().fFh != null && btg().fFh.DM() != null && btg().fFh.DM().mLiveInfo != null) {
            this.fwk.Az(String.valueOf(btg().fFh.DM().mLiveInfo.user_id));
        }
    }

    private void btr() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (btg() != null && btg().fFh != null && btg().fFh.DM() != null && btg().fFh.DM().mLiveInfo != null) {
                j = btg().fFh.DM().mLiveInfo.room_id;
            }
            if (this.fxj == null) {
                this.fxj = new com.baidu.tieba.ala.liveroom.guide.a(btg().pageContext, j);
            }
            this.fxj.jX(this.fxC);
            this.fxj.a(new a.InterfaceC0515a() { // from class: com.baidu.tieba.ala.liveroom.c.d.4
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0515a
                public void btv() {
                    if (d.this.aPZ != null) {
                        d.this.aPZ.bF(true);
                    }
                }
            });
            this.fxj.ah(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bx(int i) {
        super.bx(i);
        brK();
        if (this.fwj != null) {
            this.fwj.bx(i);
        }
    }

    private void brM() {
        if (this.fyo == null) {
            this.fyo = new DispatchedRelativeLayout(btg().pageContext.getPageActivity());
            this.fyo.setViewActionDispatched(false);
            this.fyo.setViewActionDispatchListener(new com.baidu.live.view.dispatch.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.5
                @Override // com.baidu.live.view.dispatch.a
                public boolean Y(View view) {
                    return (d.this.fym == null || d.this.fym.HE() || view == null || !(view.getTag(a.g.sdk_pvl_layout_priority_tag_key) instanceof Integer)) ? false : true;
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewAdded(View view) {
                    view.setTag(a.g.ala_live_room_vertival_widgets_bk_lp_key, view.getLayoutParams());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(view.getLayoutParams().width, view.getLayoutParams().height);
                    layoutParams.gravity = 5;
                    view.setLayoutParams(layoutParams);
                    if (d.this.fym != null) {
                        d.this.fym.addView(view);
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewRemoved(View view) {
                    if (d.this.fym != null) {
                        d.this.fym.removeView(view);
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public void HG() {
                    if (d.this.fym != null && !d.this.fym.HE()) {
                        d.this.fym.removeAllViews();
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public int indexOfChild(View view) {
                    if (d.this.fym != null) {
                        return d.this.fym.indexOfChild(view);
                    }
                    return 0;
                }
            });
        }
        if (this.fyo.getParent() == null) {
            btg().fFi.addView(this.fyo, kj(false));
        }
        if (this.fym == null) {
            this.fym = new DispatchedPvlLayout(btg().pageContext.getPageActivity());
            this.fym.setDefaultItemMargin(btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.fym.setViewActionDispatched(false);
            this.fym.setViewActionDispatchListener(new com.baidu.live.view.dispatch.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.6
                @Override // com.baidu.live.view.dispatch.a
                public boolean Y(View view) {
                    return (d.this.fyo == null || d.this.fyo.HE() || view == null || !(view.getTag(a.g.ala_live_room_vertival_widgets_bk_lp_key) instanceof ViewGroup.LayoutParams)) ? false : true;
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewAdded(View view) {
                    view.setLayoutParams(new LinearLayout.LayoutParams(view.getLayoutParams().width, view.getLayoutParams().height));
                    d.this.fyo.addView(view, (ViewGroup.LayoutParams) view.getTag(a.g.ala_live_room_vertival_widgets_bk_lp_key));
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewRemoved(View view) {
                    d.this.fyo.removeView(view);
                }

                @Override // com.baidu.live.view.dispatch.a
                public void HG() {
                    if (d.this.fyo != null && !d.this.fyo.HE()) {
                        d.this.fyo.removeAllViews();
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public int indexOfChild(View view) {
                    return d.this.fyo.indexOfChild(view);
                }
            });
        }
        if (this.fym.getParent() == null) {
            btg().fFi.addView(this.fym, btu());
        }
    }

    private void brO() {
        if (this.fyn == null) {
            this.fyn = new View(btg().pageContext.getPageActivity());
            this.fyn.setTag(a.g.sdk_pvl_layout_priority_tag_key, 20);
        }
        if (this.fyn.getParent() == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(1, 0);
            layoutParams.weight = 1.0f;
            this.fym.addView(this.fyn, layoutParams);
        }
    }

    private void bts() {
        if (this.fyn != null) {
            this.fym.removeView(this.fyn);
        }
    }

    private void brP() {
        if (this.fvY == null) {
            this.fvY = new LinearLayout(btg().pageContext.getPageActivity());
            this.fvY.setOrientation(1);
        }
        if (this.fvY.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds160);
            layoutParams.leftMargin = btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            btg().fFi.addView(this.fvY, layoutParams);
        }
    }

    private void brR() {
        if (this.fwU != null && btg() != null && btg().fFh != null) {
            this.fwU.b(this.fxz, btg().fFh.DM());
        }
    }

    private void brQ() {
        if (this.fwg == null) {
            this.fwg = new com.baidu.tieba.ala.liveroom.activeview.b(btg().pageContext);
        }
        this.fwg.jP(this.fvf);
        this.fwg.setOtherParams(Cq());
        this.fwg.b(btg().fFh.DM(), false);
        this.fwg.setHost(false);
        this.fwg.jQ(this.fxJ);
        this.fwg.a(1, this.fvY, qm(1));
        this.fwg.a(2, this.fym, qm(2));
        this.fwg.setVisible(this.fxD ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brX() {
        if (this.fwd == null) {
            bsc();
        }
        this.fwd.setOtherParams(Cq());
        this.fwd.a(com.baidu.live.v.c.Es().aRJ, btg().fFh.DM());
    }

    private ViewGroup.LayoutParams qm(int i) {
        switch (i) {
            case 1:
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (this.fvY == null || this.fvY.getChildCount() == 0) {
                    return layoutParams;
                }
                layoutParams.topMargin = btg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                return layoutParams;
            case 2:
                ViewGroup.LayoutParams layoutParams2 = this.fyo.getLayoutParams();
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(((int) (BdUtilHelper.getEquipmentWidth(btg().pageContext.getPageActivity()) * 0.25f)) - ((layoutParams2 instanceof LinearLayout.LayoutParams ? ((LinearLayout.LayoutParams) layoutParams2).rightMargin : 0) * 2), -2);
                layoutParams3.gravity = 5;
                return layoutParams3;
            default:
                return new RelativeLayout.LayoutParams(-2, -2);
        }
    }

    private void brS() {
        if (this.fwf == null) {
            this.fwf = new com.baidu.tieba.ala.liveroom.j.a(btg().pageContext, this);
        }
        this.fwf.setOtherParams(Cq());
        this.fwf.d(this.fyo, brW());
        this.fwf.s(btg().fFh.DM());
    }

    private void brT() {
        if (this.fxn == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, com.baidu.live.guardclub.j.class, btg().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.fxn = (com.baidu.live.guardclub.j) runTask.getData();
            } else {
                return;
            }
        }
        this.fxn.setOtherParams(Cq());
        if (this.fwn != null && this.fwn.indexOfChild(this.fxn.getView()) >= 0) {
            this.fwn.removeView(this.fxn.getView());
        }
    }

    private void brU() {
        if (this.fwd != null) {
            this.fwd.a(new a.InterfaceC0521a() { // from class: com.baidu.tieba.ala.liveroom.c.d.7
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0521a
                public void br(int i, int i2) {
                    com.baidu.live.data.n DM = d.this.btg().fFh.DM();
                    if (DM != null && DM.mLiveInfo != null) {
                        if (d.this.fxr == null) {
                            d.this.fxr = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.btg().pageContext.getPageActivity());
                        }
                        d.this.fxr.d(d.this.fxA, i, i2);
                        d.this.fxr.a(String.valueOf(DM.mLiveInfo.live_id), new a.InterfaceC0524a() { // from class: com.baidu.tieba.ala.liveroom.c.d.7.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0524a
                            public void a(float f, String str) {
                                if (d.this.fwd != null) {
                                    d.this.fwd.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0521a
                public void bs(int i, int i2) {
                    if (d.this.fxr != null) {
                        d.this.fxr.bx(i, i2);
                    }
                }
            });
        }
    }

    private void brV() {
        if (this.fxO == null) {
            this.fxO = new com.baidu.tieba.ala.liveroom.h.e(btg().pageContext);
        }
        this.fxO.setRoomId(btg().fFh.DM().mLiveInfo.room_id);
        this.fxO.AM("");
        this.fxO.a(btg().fFh.DM(), this.fym);
        if (this.fwv == null) {
            this.fwv = new com.baidu.tieba.ala.liveroom.h.b(btg().pageContext, Cq(), this.fxO, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.8
                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void bsu() {
                    d.this.jY(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void bsv() {
                    d.this.jY(false);
                }
            });
        }
        this.fwv.setRoomId(btg().fFh.DM().mLiveInfo.room_id);
        if (this.fwn != null && this.fwn.indexOfChild(this.fwv.getView()) >= 0) {
            this.fwn.removeView(this.fwv.getView());
        }
        if (this.fwv != null) {
            this.fwv.b(btg());
        }
    }

    private ViewGroup.LayoutParams brW() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.topMargin = (ScreenHelper.getRealScreenHeight(btg().pageContext.getPageActivity()) - this.fyo.getTop()) - btg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds814);
        return layoutParams;
    }

    private void brY() {
        CustomResponsedMessage runTask;
        if (this.fxb == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, btg().pageContext)) != null && runTask.getData() != null) {
            this.fxb = (k) runTask.getData();
            this.fxb.setFromMaster(false);
            this.fxb.Be().getView().setId(a.g.ala_liveroom_msg_list);
            this.fxb.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.9
                @Override // com.baidu.live.im.k.a
                public boolean Bg() {
                    return d.this.zz();
                }

                @Override // com.baidu.live.im.k.a
                public void Bh() {
                    d.this.fxH = true;
                }

                @Override // com.baidu.live.im.k.a
                public void eE(String str) {
                    if (!d.this.fxD) {
                        d.this.jW(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.btg().pageContext.getPageActivity(), d.this.btg().fFg.getLiveContainerView());
                    }
                    d.this.AB(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Bi() {
                    if (d.this.fxD) {
                        d.this.jW(true);
                        d.this.btg().fFg.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.btg().pageContext.getPageActivity(), d.this.btg().fFg.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.fxb != null) {
                        d.this.fxb.Bf().setQuickInputPanelVisible(false);
                        d.this.fxb.Bf().CN();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Bj() {
                    if (d.this.fxD) {
                        d.this.bst();
                        if (d.this.fxc != null) {
                            d.this.fxc.Bm();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Bk() {
                    return d.this.bsD();
                }
            });
            this.fwn = new FrameLayout(btg().pageContext.getPageActivity());
            this.fwn.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.fxb != null && this.fwn != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(btg().pageContext.getPageActivity()) * 0.75f);
            int dimensionPixelSize = btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64) + ((int) (BdUtilHelper.getEquipmentHeight(btg().pageContext.getPageActivity()) * 0.27f));
            if (this.fxA.indexOfChild(this.fwn) < 0) {
                if (this.fwn.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fwn.getParent()).removeView(this.fwn);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds27) + dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
                this.fxA.addView(this.fwn, layoutParams);
            }
            if (this.fwn.indexOfChild(this.fxb.Be().getView()) < 0) {
                if (this.fxb.Be().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fxb.Be().getView()).removeView(this.fxb.Be().getView());
                }
                this.fwn.addView(this.fxb.Be().getView(), new FrameLayout.LayoutParams(equipmentWidth, dimensionPixelSize));
            }
            if (btg().fFi.indexOfChild(this.fxb.Bf().getView()) < 0) {
                if (this.fxb.Bf().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fxb.Bf().getView().getParent()).removeView(this.fxb.Bf().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bsJ();
                btg().fFi.addView(this.fxb.Bf().getView(), layoutParams2);
            }
            com.baidu.live.data.n DM = btg().fFh.DM();
            if (DM != null && DM.mLiveInfo != null) {
                this.fxb.setLogData(DM.mLiveInfo.feed_id, Cq());
            }
            this.fxb.e(String.valueOf(btg().fFh.DM().mLiveInfo.group_id), String.valueOf(btg().fFh.DM().mLiveInfo.last_msg_id), String.valueOf(btg().fFh.DM().aqk.userId), String.valueOf(btg().fFh.DM().mLiveInfo.live_id), btg().fFh.DM().aqk.appId);
            jW(false);
        }
    }

    private void bsa() {
        if (this.fwa == null) {
            this.fwa = new com.baidu.tieba.ala.liveroom.l.a(btg().pageContext, false, this);
        }
        this.fwa.c(this.fxz, btg().fFh.DM());
        this.fwa.a(this.fwF);
        this.fwa.setOtherParams(Cq());
    }

    private void bsb() {
        if (this.fvZ == null) {
            this.fvZ = new com.baidu.tieba.ala.liveroom.audiencelist.c(btg().pageContext, this, false);
        }
        this.fvZ.a(String.valueOf(btg().fFh.DM().mLiveInfo.group_id), String.valueOf(btg().fFh.DM().mLiveInfo.live_id), String.valueOf(btg().fFh.DM().aqk.userId), btg().fFh.DM());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.fwP != null && this.fwP.getView() != null && this.fwP.getView().getParent() != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.fvZ.c(this.fxz, i, a.g.ala_liveroom_audience_count_layout);
            this.fvZ.e(btg().fFh.bnp());
            this.fvZ.setOtherParams(Cq());
        }
    }

    private void bsc() {
        if (this.fwd == null) {
            this.fwd = new com.baidu.tieba.ala.liveroom.operation.a(btg().pageContext);
        }
        this.fwd.a(btg(), this.fxA, btg().fFh.DM().mLiveInfo.live_type, true, this.fwF);
        this.fwd.setOtherParams(Cq());
    }

    public void kd(boolean z) {
        if (this.fwd != null) {
            this.fwd.kd(z);
        }
    }

    private void bsf() {
        if (this.fwe == null) {
            this.fwe = new com.baidu.tieba.ala.liveroom.audiencelist.b(btg().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (btg().fFh.bnp() != null) {
            j = btg().fFh.bnp().getCount();
        }
        this.fwe.a(this.fwF);
        this.fwe.a(this.fxz, a.g.ala_liveroom_audience, j);
        this.fwe.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.fwe.kl(false);
        } else {
            this.fwe.kl(true);
        }
    }

    protected void AC(String str) {
        if (this.fxN == null) {
            this.fxN = new com.baidu.tieba.ala.liveroom.q.b(btg().pageContext);
        }
        this.fxN.b(this.fxA, str);
        jY(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.10
            @Override // java.lang.Runnable
            public void run() {
                d.this.fxN.bzK();
                d.this.jY(false);
            }
        }, 5000L);
    }

    private void ke(boolean z) {
        CustomResponsedMessage runTask;
        if (btg().fFh.DM().mLiveInfo.live_type == 1 && this.fyq) {
            if (this.fyp == null && (runTask = MessageManager.getInstance().runTask(2913074, f.class, btg().pageContext)) != null && runTask.getData() != null) {
                this.fyp = (f) runTask.getData();
            }
            if (this.fyp != null) {
                if (this.fwi == null) {
                    this.fwi = this.fyp.a(btg().pageContext);
                }
                if (btg().fFh.DM().mLiveInfo.challengeId > 0 && !this.fwi.uw()) {
                    this.fwi.d(btg().fFh.DM().mLiveInfo.live_id, btg().fFh.DM().aqk.userId);
                    kf(z);
                    if (z) {
                        this.fwi.a(btg().fFh.byC());
                    }
                    this.fwi.c(btg().fFh.DM());
                }
            }
        }
    }

    private void kf(boolean z) {
        if (this.fwj == null) {
            this.fwj = this.fyp.b(btg().pageContext);
            this.fwj.a(new com.baidu.live.challenge.h() { // from class: com.baidu.tieba.ala.liveroom.c.d.11
                @Override // com.baidu.live.challenge.h
                public void ul() {
                    d.this.btg().fFi.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.h
                public void a(ag agVar, ah ahVar, ah ahVar2) {
                    d.this.fvf = true;
                    if (d.this.fwV != null) {
                        d.this.fwV.setPraiseEnable(false);
                        d.this.btg().fFi.fSj = false;
                    }
                    if (d.this.fwf != null) {
                        d.this.fwf.setCanVisible(false);
                        d.this.fwf.bvB();
                    }
                    if (d.this.fwg != null) {
                        d.this.fwg.jP(true);
                    }
                    if (d.this.fxO != null) {
                        d.this.fxO.setVisible(8);
                    }
                    if (d.this.fwh != null) {
                        d.this.fwh.setCanVisible(false);
                        d.this.fwh.setVisible(8);
                    }
                    d.this.kh(true);
                    d.this.ki(true);
                    if (d.this.btg().aQc != null) {
                        d.this.btg().aQc.getLivePlayer().setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                    }
                    if (d.this.fwT != null) {
                        d.this.fwT.setTimeTextMode(true);
                    }
                    if (d.this.aPZ != null && ahVar != null && ahVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(ahVar.auw);
                        arrayList.add(ahVar2.auw);
                        com.baidu.live.liveroom.a.b bVar = d.this.aPZ;
                        if (d.this.fxK) {
                            arrayList = null;
                        }
                        bVar.j(arrayList);
                    }
                }

                @Override // com.baidu.live.challenge.h
                public void um() {
                }

                @Override // com.baidu.live.challenge.h
                public void un() {
                }

                @Override // com.baidu.live.challenge.h
                public void aR(boolean z2) {
                    d.this.btg().fFi.setSwipeClearEnable(true);
                    d.this.fvf = false;
                    if (d.this.fwV != null) {
                        d.this.fwV.setPraiseEnable(true);
                        d.this.btg().fFi.fSj = true;
                    }
                    if (d.this.fwf != null) {
                        d.this.fwf.setCanVisible(true);
                        d.this.fwf.s(d.this.btg().fFh.DM());
                    }
                    if (d.this.fwX != null) {
                        d.this.fwX.kX(true);
                    }
                    if (d.this.fwg != null) {
                        d.this.fwg.jP(false);
                    }
                    if (d.this.fxO != null) {
                        d.this.fxO.setVisible(0);
                    }
                    if (d.this.fwh != null) {
                        d.this.fwh.setCanVisible(true);
                        d.this.fwh.setVisible(0);
                    }
                    d.this.kh(false);
                    d.this.ki(false);
                    if (d.this.aPZ != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.btg().fFh.bzp());
                        com.baidu.live.liveroom.a.b bVar = d.this.aPZ;
                        if (d.this.fxK) {
                            arrayList = null;
                        }
                        bVar.j(arrayList);
                    }
                    if (d.this.btg().aQc != null) {
                        d.this.btg().aQc.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
                    }
                    if (d.this.fwT != null) {
                        d.this.fwT.setTimeTextMode(false);
                    }
                }
            });
        }
        this.fwj.a(this.fwi);
        this.fwj.f(btg().fFg.getLiveContainerView());
        this.fwj.b(z, false, false);
        this.fwi.a((j.c) this.fwj);
    }

    private void kg(boolean z) {
        CustomResponsedMessage runTask;
        if (btg().fFh.DM().mLiveInfo.live_type == 1 && com.baidu.live.v.a.En().aQu.asA) {
            if (this.fwh == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, btg().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.fwh = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.fwh != null) {
                this.fwh.a(btg().fFh.bzr(), false, false);
                if (btg().fFh.DM().mLiveInfo.pkId > 0 && this.fwh.getRootView() != null && this.fwh.getRootView().getParent() == null && this.fyo != null) {
                    if (this.fyo.getChildCount() <= 0) {
                        this.fyo.addView(this.fwh.getRootView(), new LinearLayout.LayoutParams(-2, -2));
                    } else {
                        View childAt = this.fyo.getChildAt(0);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.topMargin = btg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                        childAt.setLayoutParams(layoutParams);
                        this.fyo.addView(this.fwh.getRootView(), 0, new LinearLayout.LayoutParams(-2, -2));
                    }
                }
                if (z) {
                    this.fwh.a(null, btg().fFh.DM());
                } else {
                    this.fwh.b(btg().fFh.DM());
                }
            }
        }
    }

    public void bsg() {
        this.fwQ.c(btg().fFh.DM(), false);
    }

    public void bsh() {
        if (btg().fFh.DM() != null && btg().fFh.DM().aqk != null && btg().fFh.DM().mLiveInfo != null) {
            if (this.fwc == null) {
                this.fwc = new com.baidu.tieba.ala.liveroom.r.b(btg().pageContext);
            }
            long j = btg().fFh.DM().aqk.userId;
            int i = btg().fFh.DM().mLiveInfo.live_type;
            String str = btg().fFh.DM().aqk.portrait;
            String str2 = btg().fFh.DM().mLiveInfo.feed_id;
            long j2 = btg().fFh.DM().mLiveInfo.live_id;
            this.fwc.a(i, j, btg().fFh.DM().aqk.userName, false, str, Cq(), str2, j2);
            this.fwc.ah(this.fxz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kh(boolean z) {
        if (this.fym != null && this.fyo != null) {
            if (z) {
                this.fym.setViewActionDispatched(false);
                this.fyo.setViewActionDispatched(true);
                ViewGroup.LayoutParams layoutParams = this.fym.getLayoutParams();
                layoutParams.height = btt();
                this.fym.setLayoutParams(layoutParams);
                brO();
                return;
            }
            this.fyo.setViewActionDispatched(false);
            this.fym.setViewActionDispatched(true);
            ViewGroup.LayoutParams layoutParams2 = this.fym.getLayoutParams();
            layoutParams2.height = -2;
            this.fym.setLayoutParams(layoutParams2);
            bts();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:7:0x0014 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.LinearLayout$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.tieba.ala.liveroom.activeview.b] */
    public void ki(boolean z) {
        if (this.fwg != null) {
            ?? layoutParams = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams) layoutParams).gravity = 5;
            ?? r2 = this.fwg;
            ViewGroup viewGroup = z ? this.fym : this.fvY;
            if (!z) {
                layoutParams = qm(1);
            }
            r2.a(1, viewGroup, layoutParams, 21);
            this.fwg.updateView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int btt() {
        return (((btg().fFi.getBottom() - (this.fwj != null ? this.fwj.aS(false) : 0)) - (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0)) - btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsi() {
        if (btg() == null || btg().fFh == null || btg().fFh.DM() == null || btg().fFh.DM().aqD == null) {
            if (btg().fFh == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (btg().fFh.DM() == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (btg().fFh.DM().aqD == null) {
                Log.i("RenameLog", "getLiveContext().liveModel.getLiveShowData().mLoginUserInfo == null");
                return;
            } else {
                return;
            }
        }
        String str = btg().fFh.DM().aqD.userName;
        Log.i("RenameLog", "loginUserName:" + str);
        if (str != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), btg().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !bsC()) {
            com.baidu.live.c.tG().putInt("guide_rename_show_count", com.baidu.live.c.tG().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.Dk().bE(true);
            if (this.fxu == null) {
                this.fxu = new com.baidu.tieba.ala.liveroom.s.a(btg().pageContext);
            }
            this.fxu.setOtherParams(Cq());
            this.fxu.e(this.fxA, btg().fFh.DM());
            jY(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.14
                @Override // java.lang.Runnable
                public void run() {
                    d.this.fxu.bzO();
                    d.this.jY(false);
                }
            }, 5000L);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_SHOW);
                alaStaticItem.addParams("other_params", Cq());
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    private void bsj() {
        boolean z = false;
        if (this.fwX == null) {
            this.fwX = new com.baidu.tieba.ala.liveroom.v.a(btg().pageContext, this);
        }
        this.fwX.d(btg().fFi, false);
        if (btf() && btg().fFh.DM().mLiveInfo.screen_direction != 2) {
            z = true;
        }
        this.fwX.kW(z);
    }

    private void bsl() {
        if (this.fxH || this.fxI) {
            if ((TbadkCoreApplication.isLogin() && this.fxb.Bf().hasText()) || this.fxI) {
                this.fxH = false;
                this.fxI = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.15
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bsI();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void bsd() {
        bse();
    }

    private void bse() {
        if (this.fwd != null) {
            int i = btg().fFh.DM().aqD.isUegBlock;
            int i2 = btg().fFh.DM().aqD.isBlock;
            String str = btg().fFh.DM().aqD.userName;
            if (i > 0 || i2 > 0) {
                this.fwd.b(true, i, i2, str);
                this.fxb.a(true, i, i2, str);
                this.fxh.b(true, i, i2, str);
                return;
            }
            this.fwd.b(false, i, i2, str);
            this.fxb.a(false, i, i2, str);
            this.fxh.b(false, i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void k(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        super.k(aVar);
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
        } catch (JSONException e) {
            jSONObject = null;
        }
        if ((aVar.getMsgType() == 12 || aVar.getMsgType() == 13) && jSONObject != null) {
            String optString = jSONObject.optString("content_type");
            if ("task".equals(optString)) {
                if (this.fwf != null) {
                    this.fwf.A(jSONObject);
                }
            } else if ("enter_live".equals(optString)) {
                if (this.fwe != null && this.fwe.getCount() > 20) {
                    this.fwe.dk(this.fwe.getCount() + 1);
                } else if (this.fvZ != null) {
                    com.baidu.live.data.a Ce = aVar.Ce();
                    com.baidu.live.data.g gVar = new com.baidu.live.data.g();
                    gVar.aql = new AlaLocationData();
                    gVar.aqm = new AlaRelationData();
                    gVar.aqk = new AlaLiveUserInfoData();
                    gVar.aqk.userId = JavaTypesHelper.toLong(Ce.userId, 0L);
                    gVar.aqk.userName = Ce.userName;
                    gVar.aqk.portrait = Ce.portrait;
                    if (this.fwe != null && this.fvZ.c(gVar)) {
                        this.fwe.dk(this.fwe.getCount() + 1);
                    }
                }
            } else if ("update_liveinfo".equals(optString) && btg().fFh.DM() != null && btg().fFh.DM().mLiveInfo != null) {
                btg().fFh.a(btg().fFh.DM().mLiveInfo.live_id, btg().fromType, btg().enterTime);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void Ax(String str) {
        if (this.fwg != null) {
            this.fwg.Ax(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void bJ(boolean z) {
        super.bJ(z);
        if (btg().fFi != null) {
            btg().fFi.bAE();
            btg().fFi.setLiveViewOnDispatchTouchEventListener(null);
            btg().fFi.setOnLiveViewScrollListener(null);
        }
        if (btg().aQc != null) {
            btg().aQc.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.fwj != null) {
            this.fwj.uf();
        }
        bsm();
        if (this.fwc != null) {
            this.fwc.uf();
        }
        if (this.fwX != null) {
            this.fwX.release();
        }
        if (this.fwf != null) {
            this.fwf.uf();
        }
        if (this.fwd != null) {
            this.fwd.bzu();
        }
        if (this.fwb != null) {
            this.fwb.buR();
            this.fwb.setVisible(8);
        }
        if (this.fwh != null) {
            this.fwh.uf();
        }
        if (this.fwg != null) {
            this.fwg.release();
        }
        if (this.fyo != null) {
            this.fyo.setViewActionDispatched(false);
            this.fyo.removeAllViews();
            this.fyo = null;
        }
        if (this.fym != null) {
            this.fym.setViewActionDispatched(false);
            this.fym.removeAllViews();
            this.fym = null;
        }
        if (this.fvY != null) {
            this.fvY.removeAllViews();
            this.fvY = null;
        }
        if (this.fwX != null) {
            this.fwX.onDestroy();
        }
        if (this.fwi != null) {
            this.fwi.uf();
        }
        if (this.fwv != null) {
            this.fwv.cancel();
        }
        if (this.fxO != null) {
            this.fxO.btW();
        }
        if (this.fwv != null) {
            this.fwv.uf();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void bI(boolean z) {
        super.bI(z);
        bsm();
        if (this.fwa != null) {
            this.fwa.onDestroy();
        }
        if (this.fwc != null) {
            this.fwc.onDestroy();
        }
        if (this.fwf != null) {
            this.fwf.onDestroy();
        }
        if (this.fwh != null) {
            this.fwh.onDestroy();
        }
        if (this.fwi != null) {
            this.fwi.onDestroy();
        }
        if (this.fwj != null) {
            this.fwj.onDestroy();
        }
        if (this.fwk != null) {
            this.fwk.onDestroy();
        }
        if (this.fxj != null) {
            this.fxj.onDestroy();
        }
        if (this.fwb != null) {
            this.fwb.onDestroy();
        }
        if (this.fvZ != null) {
            this.fvZ.onDestroy();
        }
        if (this.fxb != null) {
            this.fxb.onDestroy();
        }
        if (this.fwd != null) {
            this.fwd.onDestory();
        }
        if (this.fwg != null) {
            this.fwg.release();
        }
        if (this.fxO != null) {
            this.fxO.bI(!z);
        }
        if (this.fwv != null) {
            this.fwv.onDestroy();
            this.fwv = null;
        }
        MessageManager.getInstance().removeMessageRule(this.fww);
        MessageManager.getInstance().removeMessageRule(this.fwx);
        MessageManager.getInstance().unRegisterListener(this.fwz);
        MessageManager.getInstance().unRegisterListener(this.fwA);
        MessageManager.getInstance().unRegisterListener(this.fys);
        MessageManager.getInstance().unRegisterListener(this.fwC);
        MessageManager.getInstance().unRegisterListener(this.fwD);
        MessageManager.getInstance().unRegisterListener(this.fyr);
        MessageManager.getInstance().unRegisterListener(this.fwE);
        MessageManager.getInstance().unRegisterListener(this.fwB);
    }

    private void bsm() {
        if (this.fxb != null && this.fxb.Be().getView() != null && this.fxb.Be().getView().getParent() != null) {
            ((ViewGroup) this.fxb.Be().getView().getParent()).removeView(this.fxb.Be().getView());
        }
        if (this.fwn != null && this.fwn.getParent() != null) {
            ((ViewGroup) this.fwn.getParent()).removeView(this.fwn);
        }
        if (this.fxb != null && this.fxb.Bf().getView() != null) {
            this.fxA.removeView(this.fxb.Bf().getView());
        }
        if (this.fxb != null) {
            this.fxb.Be().setMsgData(new LinkedList());
            this.fxb.AJ();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void a(z zVar) {
        if (this.fxb != null) {
            bsI();
            this.fxb.Bf().setEditText(" @" + zVar.getNameShow() + " ");
        }
        if (this.fwd != null) {
            this.fwd.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void f(com.baidu.live.data.a aVar) {
        if (this.fxb != null) {
            bsI();
            this.fxb.Bf().setEditText(" @" + aVar.userName + " ");
        }
        if (this.fwd != null) {
            this.fwd.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void b(z zVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected View bsn() {
        if (this.fxb != null) {
            return this.fxb.Bf().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean bso() {
        if (this.fxb == null || !this.fxb.Bf().CM()) {
            return false;
        }
        jW(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean bsp() {
        return this.fwa == null || this.fwa.bsp();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup bsq() {
        return this.fyo;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup bsr() {
        return this.fvY;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 24009) {
            if (i2 == -1) {
                if (intent != null && "ala_live_room_show_gift_panel".equals(intent.getStringExtra("ala_live_room_show_panel_key"))) {
                    int intExtra = intent.getIntExtra("ala_live_room_gift_panel_tab_id", -1);
                    int intExtra2 = intent.getIntExtra("ala_live_room_gift_panel_category_id", -1);
                    int intExtra3 = intent.getIntExtra("ala_live_room_gift_panel_gift_id", -1);
                    this.fxE = false;
                    M(intExtra, intExtra2, intExtra3);
                    return;
                }
                bsg();
                return;
            }
            bte();
        } else if (i == 25051 && i2 == -1 && this.fxO != null) {
            this.fxO.bvq();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.fxb != null && this.fxb.Be() != null) {
            this.fxb.Be().onKeyboardVisibilityChanged(z);
        }
        if (z || this.fxb == null || this.fxb.Bf() == null || !this.fxb.Bf().CM()) {
            if (z) {
                if (this.fwd != null) {
                    this.fwd.setVisibility(8);
                }
                if (this.fxd != null && this.fxd.wI() != null) {
                    this.fxd.wI().setVisibility(8);
                }
                bst();
                if (this.fxb != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fxb.Bf().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.fxb.Bf().getView().setLayoutParams(layoutParams);
                    this.fxb.Bf().getView().setVisibility(0);
                    this.fxb.Bf().setQuickInputPanelVisible(false);
                }
                if (this.fxz != null) {
                    this.fxz.setVisibility(8);
                }
                if (this.fwg != null) {
                    this.fwg.setVisible(8);
                }
                if (this.fxc != null) {
                    this.fxc.Bm();
                }
                if (this.fxy != null) {
                    this.fxy.setCanVisible(false);
                }
            } else {
                bss();
            }
            if (this.fxb != null && this.fwn != null) {
                int equipmentHeight = (int) (((z ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(btg().pageContext.getPageActivity())) + btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
                if (this.fxA.indexOfChild(this.fwn) != -1 && this.fwn.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fwn.getLayoutParams();
                    layoutParams2.height = btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds27) + equipmentHeight;
                    this.fwn.setLayoutParams(layoutParams2);
                }
                if (this.fwn.indexOfChild(this.fxb.Be().getView()) != -1 && this.fxb.Be().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.fxb.Be().getView().getLayoutParams();
                    layoutParams3.height = equipmentHeight;
                    this.fxb.Be().getView().setLayoutParams(layoutParams3);
                }
                this.fxb.Be().Bd();
            }
            if (this.fxo != null) {
                this.fxo.aY(z);
            }
        }
    }

    private void bss() {
        if (this.fwd != null) {
            this.fwd.setVisibility(0);
        }
        if (this.fwn != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fwn.getLayoutParams();
            layoutParams.bottomMargin = btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
            this.fwn.setLayoutParams(layoutParams);
        }
        if (this.fxb != null) {
            bsJ();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fxb.Bf().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.fxb.Bf().getView().setLayoutParams(layoutParams2);
        }
        if (this.fwd != null) {
            this.fwd.setVisibility(0);
        }
        if (this.fxd != null && this.fxd.wI() != null) {
            this.fxd.wI().setVisibility(0);
        }
        if (this.fxz != null) {
            this.fxz.setVisibility(0);
        }
        if (this.fwg != null) {
            this.fwg.setVisible(0);
        }
        if (this.fxc != null) {
            this.fxc.Bm();
        }
        if (this.fxy != null) {
            this.fxy.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bst() {
        if (this.fwn != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fwn.getLayoutParams();
            boolean z = false;
            if (this.fxb != null && this.fxb.Bf() != null) {
                z = this.fxb.Bf().CL();
            }
            int ka = ka(z);
            if (layoutParams.bottomMargin != ka) {
                layoutParams.bottomMargin = ka;
                this.fwn.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jW(boolean z) {
        if (z) {
            this.fxb.Bf().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fwn.getLayoutParams();
            int quickInputPanelExpandHeight = this.fxb.Bf().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.fwn.setLayoutParams(layoutParams);
                if (this.fxb.Be() != null) {
                    this.fxb.Be().Bd();
                    return;
                }
                return;
            }
            return;
        }
        bss();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.fvZ != null) {
                this.fvZ.cl(i3);
            }
            if (this.fwb != null) {
                this.fwb.cl(i3);
            }
        }
        super.l(i, i2, i3);
        if (this.fvf && this.fym != null) {
            this.fym.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.16
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (d.this.fym != null && (layoutParams = d.this.fym.getLayoutParams()) != null) {
                        int i4 = layoutParams.height;
                        int btt = d.this.btt();
                        if (btt != i4) {
                            layoutParams.height = btt;
                            d.this.fym.setLayoutParams(layoutParams);
                        }
                    }
                }
            }, 100L);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public boolean cr(int i) {
        boolean cr = super.cr(i);
        if (cr && 2 == i) {
            if (this.fwa.bsp()) {
                return false;
            }
            if (cr && this.fwX != null) {
                this.fwX.kX(false);
            }
        }
        return cr;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void qn(int i) {
        super.qn(i);
        if (i == 7 || i == 11) {
            if (this.fwd != null) {
                this.fwd.setVisibility(8);
            }
            if (this.fxb != null) {
                this.fxb.Be().getView().setVisibility(4);
            }
            if (this.fwg != null) {
                this.fwg.bp(2, 8);
                if (this.fvf) {
                    this.fwg.bp(1, 8);
                }
            }
            if (this.fxr != null) {
                this.fxr.kS(false);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public void cs(int i) {
        super.cs(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public void ct(int i) {
        super.ct(i);
        if (i == 7 || i == 11) {
            if (this.fwd != null) {
                this.fwd.setVisibility(0);
            }
            if (this.fxb != null) {
                this.fxb.Be().getView().setVisibility(0);
            }
            if (this.fwg != null) {
                this.fwg.setVisible(0);
            }
            if (this.fxr != null) {
                this.fxr.kS(true);
            }
            this.fxz.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.fwc != null) {
            this.fwc.bzM();
        }
        if (this.fwi != null) {
            this.fwi.up();
        }
        if (this.fwg != null) {
            this.fwg.onStop();
        }
        if (this.fwh != null) {
            this.fwh.aP(true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.fwc != null) {
            this.fwc.bzL();
        }
        if (this.fwi != null && this.fyq) {
            this.fwi.uq();
        }
        if (this.fwg != null) {
            this.fwg.onStart();
        }
        if (this.fwh != null) {
            this.fwh.aP(false);
        }
    }

    private ViewGroup.LayoutParams kj(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.fyo == null) {
            return null;
        }
        int btt = this.fvf ? btt() : -2;
        ViewGroup.LayoutParams layoutParams2 = this.fyo.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, btt);
        }
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.rightMargin = btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds112);
        layoutParams.topMargin = btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200);
        return layoutParams;
    }

    private ViewGroup.LayoutParams btu() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.fym == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams2 = this.fym.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.rightMargin = btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
        return layoutParams;
    }
}
