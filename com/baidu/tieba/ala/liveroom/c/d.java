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
    private LinearLayout fvT;
    private com.baidu.tieba.ala.liveroom.audiencelist.c fvU;
    private com.baidu.tieba.ala.liveroom.l.a fvV;
    private com.baidu.tieba.ala.liveroom.e.b fvW;
    private com.baidu.tieba.ala.liveroom.r.b fvX;
    private com.baidu.tieba.ala.liveroom.operation.a fvY;
    private com.baidu.tieba.ala.liveroom.audiencelist.b fvZ;
    private boolean fva;
    private com.baidu.tieba.ala.liveroom.j.a fwa;
    private com.baidu.tieba.ala.liveroom.activeview.b fwb;
    private com.baidu.live.d.a fwc;
    private j fwd;
    private i fwe;
    private com.baidu.tieba.ala.liveroom.attentionpop.b fwf;
    private FrameLayout fwi;
    private com.baidu.tieba.ala.liveroom.h.b fwq;
    private DispatchedPvlLayout fyh;
    private View fyi;
    private DispatchedRelativeLayout fyj;
    private f fyk;
    private long lastClickTime = 0;
    private boolean fyl = false;
    private HttpRule fwr = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.fwd != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.fwd.uw()) {
                httpMessage.addParam("ala_challenge_id", d.this.fwd.uz());
            }
            return httpMessage;
        }
    };
    private HttpRule fws = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.c.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.fwd != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.fwd.uw()) {
                httpMessage.addParam("challenge_id", d.this.fwd.uz());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c fwt = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.c.d.17
        @Override // com.baidu.live.liveroom.g.c
        public void DL() {
            if (d.this.fwS != null) {
                d.this.fwS.kX(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bK(boolean z) {
            if (z) {
                if (d.this.fvY != null) {
                    d.this.fvY.qU(8);
                }
                if (d.this.fwS != null) {
                    d.this.fwS.kX(true);
                }
            } else {
                if (d.this.fvY != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                        d.this.fvY.qU(0);
                    } else {
                        d.this.fvY.qU(8);
                    }
                }
                if (d.this.fwS != null) {
                    d.this.fwS.kX(false);
                }
            }
            if (d.this.fxj != null) {
                d.this.fxj.aZ(z);
            }
        }
    };
    private HttpMessageListener fwu = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.d.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.DV() != null) {
                        com.baidu.live.v.c.Et().aRE = getQuickGiftHttpResponseMessage.DV();
                        d.this.brZ();
                    }
                }
            }
        }
    };
    private CustomMessageListener fwv = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.d.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.bsk();
        }
    };
    CustomMessageListener fwz = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.c.d.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.fwq.c(d.this.bti());
                } else if (d.this.bsE() || !g.qv(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, 3000L);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.bti().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.bti().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    d.this.fwq.b(d.this.fwi, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener fym = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.c.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.bsE() || !g.qv(2913128)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.21.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.qt(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, 3000L);
                } else {
                    d.this.Az(str);
                }
            }
        }
    };
    private CustomMessageListener fyn = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.c.d.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.fwZ.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fww = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.c.d.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.this.fxn != null) {
                    d.this.fxn.AB(str);
                }
            }
        }
    };
    CustomMessageListener fwx = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.c.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.fxB != null && d.this.fxB.aIR != null && !d.this.fxB.aIU && !d.this.fxB.aIV && d.this.fxi != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.bti().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = d.this.bti().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                d.this.fxi.b(d.this.fwi, layoutParams);
                if (e.Ar() != null) {
                    e.Ar().Ax();
                }
            }
        }
    };
    private CustomMessageListener fwy = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.fxl != null) {
                    d.this.fxl.dismiss();
                }
                if (d.this.fxn != null) {
                    d.this.fxn.dismiss();
                }
                m.Bp().setSwitchStatus(true);
                m.Bp().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bsK();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b fwA = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.d.13
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
                        alaStaticItem.addParams("gifts_value", com.baidu.live.v.c.Et().aRE.wS().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.v.c.Et().aRE.wS().vV());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.v.c.Et().aRE.wS().vW());
                        if (d.this.bti().fFc.DN() != null && d.this.bti().fFc.DN().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.bti().fFc.DN().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.bti().fFc.DN().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.Cr());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.zA()) {
                        if (com.baidu.live.c.tH().getBoolean("quick_gift_guide_show", true) && !d.this.bsE()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, y.class, d.this.bti().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                y yVar = (y) runTask.getData();
                                yVar.setPageContext(d.this.bti().pageContext);
                                yVar.d(d.this.bti().fFc.DN());
                                yVar.setGiftItem(com.baidu.live.v.c.Et().aRE.wS());
                                yVar.setOtherParams(d.this.Cr());
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
                        n.a(d.this.bti().pageContext, d.this.bti().fFc.DN(), com.baidu.live.v.c.Et().aRE.wS(), d.this.Cr());
                    }
                } else if (i == 1) {
                    if (d.this.fwW != null) {
                        d.this.bsK();
                    }
                } else if (i == 3 && d.this.zA()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "share_clk"));
                    d.this.fwL.c(d.this.bti().fFc.DN(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.bti() != null && d.this.bti().fFc != null && d.this.bti().fFc.DN() != null && d.this.bti().fFc.DN().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.bti().fFc.DN().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.bti().fFc.DN().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.bti().fFc.DN().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.Cr());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.bti() != null && d.this.bti().fFc != null && d.this.bti().fFc.DN() != null && d.this.bti().fFc.DN().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.bti().fFc.DN().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.bti().fFc.DN().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.bti().fFc.DN().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.Cr());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.aPT != null) {
                        d.this.aPT.bF(false);
                    }
                } else if (i == 12) {
                    if (d.this.fwS != null && d.this.bti().fFc.DN() != null && d.this.bti().fFc.DN().mLiveInfo != null) {
                        String valueOf = String.valueOf(d.this.bti().fFc.DN().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.bti().fFc.DN().mLiveInfo.room_id);
                        String str3 = null;
                        l lVar = d.this.bti().fFc.DN().mLiveSdkInfo;
                        if (lVar != null && lVar.mCastIds != null) {
                            str3 = String.valueOf(d.this.bti().fFc.DN().mLiveSdkInfo.mCastIds.aqq);
                        }
                        d.this.fwS.ac(valueOf, valueOf2, str3);
                        if (com.baidu.live.liveroom.a.Dl().Dm()) {
                            d.this.bsk();
                        }
                    }
                } else if (i == 14) {
                    com.baidu.live.data.n DN = d.this.bti().fFc.DN();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.bti().pageContext.getPageActivity(), DN.aqe.userName, Long.toString(DN.aqe.userId), Long.toString(DN.aqe.charmCount), String.valueOf(DN.mLiveInfo.group_id), String.valueOf(DN.mLiveInfo.live_id), false, String.valueOf(DN.aqe.userId), Long.toString(DN.aqx.userId), DN.aqx.userName, DN.aqx.portrait, d.this.fvZ.getCount(), d.this.Cr())));
                    LogManager.getCommonLogger().doClickGusetNumLog(DN.mLiveInfo.feed_id, d.this.fvZ.getCount() + "", d.this.Cr());
                } else if (i == 11) {
                    d.this.bsN();
                    d.this.bsO();
                } else if (i == 15) {
                    if (d.this.fxg != null && d.this.bti() != null && d.this.bti().fFc != null && d.this.bti().fFc.DN() != null && d.this.bti().fFc.DN().mLiveInfo != null) {
                        long j = d.this.bti().fFc.DN().mLiveInfo.live_id;
                        String valueOf3 = String.valueOf(d.this.bti().fFc.DN().mLiveInfo.feed_id);
                        long j2 = d.this.bti().fFc.DN().mLiveInfo.room_id;
                        String str4 = d.this.bti().fFc.DN().mLiveInfo.cover;
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        String str8 = "";
                        if (d.this.bti().fFc.DN().mLiveInfo.session_info != null) {
                            str5 = d.this.bti().fFc.DN().mLiveInfo.session_info.flvUrl;
                        }
                        if (!TextUtils.isEmpty(d.this.Cr())) {
                            try {
                                JSONObject jSONObject = new JSONObject(d.this.Cr());
                                str6 = jSONObject.optString("tab");
                                str7 = jSONObject.optString("tag");
                                str8 = jSONObject.optString("source");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        d.this.fxg.AB(o.a(valueOf3, j + "", j2, false, 1, str4, str5, str6, str7, str8, String.valueOf(d.this.bti().fFc.DN().aqx.userId), d.this.bti().fFc.DN().aqx.userName, String.valueOf(d.this.bti().fFc.DN().mLiveInfo.group_id), String.valueOf(d.this.bti().fFc.DN().aqe.userId)));
                        o.aXR = j;
                        if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                            ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                            LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf3, d.this.Cr());
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "shopcart_clk"));
                    }
                } else if (i == 16) {
                    if (d.this.bti() != null && (asVar2 = com.baidu.live.v.a.Eo().aRw) != null && (bbVar2 = asVar2.avu) != null) {
                        String str9 = bbVar2.awq.aww;
                        if (!TextUtils.isEmpty(str9)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "quick_gift"));
                            long j3 = 0;
                            if (d.this.bti().fFc != null && d.this.bti().fFc.DN() != null && d.this.bti().fFc.DN().mLiveInfo != null) {
                                j3 = d.this.bti().fFc.DN().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j3 + "", d.this.bti().fFc.DN().mLiveInfo.room_id + "", d.this.bti().fFc.DN().mLiveInfo.feed_id, d.this.Cr());
                            }
                            if (str9.contains("?")) {
                                str2 = str9 + "&liveId=" + j3;
                            } else {
                                str2 = str9 + "?liveId=" + j3;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.bti().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (d.this.bti() != null) {
                        com.baidu.live.data.n nVar = null;
                        if (d.this.bti().fFc != null) {
                            nVar = d.this.bti().fFc.DN();
                        }
                        if (nVar != null && nVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.t.a.bzZ().aQA != null) {
                            String str10 = com.baidu.tieba.ala.liveroom.t.a.bzZ().aQA.aqV;
                            if (!TextUtils.isEmpty(str10)) {
                                if (str10.contains("?")) {
                                    str = str10 + "&live_id=" + nVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str10 + "?live_id=" + nVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(d.this.bti().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17 && d.this.zA() && d.this.bti() != null && (asVar = com.baidu.live.v.a.Eo().aRw) != null && (bbVar = asVar.avu) != null && (bhVar = bbVar.awr) != null && !TextUtils.isEmpty(bhVar.webUrl)) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "turntable"));
                    if (d.this.fxl != null && d.this.bti().fFc != null && d.this.bti().fFc.DN() != null) {
                        com.baidu.live.data.n DN2 = d.this.bti().fFc.DN();
                        d.this.fxl.a(bhVar.webUrl, DN2.mLiveInfo.live_id, DN2.aqx.userId, DN2.aqe.userId);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.fwN = new com.baidu.tieba.ala.liveroom.guide.c(bti().pageContext, this, false);
        this.fwr.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.fwr);
        this.fws.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.fws);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean brK() {
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void k(com.baidu.live.data.n nVar) {
        super.k(nVar);
        g.bvx();
        this.fyl = true;
        bti().fFd.setIsForceHandledTouch(false);
        bti().fFd.setSwipeClearEnable(true);
        bti().fFd.setOnLiveViewScrollListener(this.fwt);
        if (this.fwQ != null) {
            this.fwQ.b(this.fwA);
        }
        if (this.fxu != null) {
            this.fxu.setVisibility(0);
        }
        brO();
        brR();
        bsc();
        bsA();
        bsd();
        bsh();
        bse();
        jU(false);
        bsR();
        bsQ();
        brT();
        bsa();
        bsT();
        bsj();
        bsl();
        kg(true);
        bts();
        btt();
        jZ(false);
        bsZ();
        brS();
        brZ();
        brU();
        brV();
        brW();
        brX();
        ke(true);
        bsY();
        MessageManager.getInstance().registerListener(this.fwu);
        MessageManager.getInstance().registerListener(this.fwv);
        MessageManager.getInstance().registerListener(this.fyn);
        MessageManager.getInstance().registerListener(this.fwx);
        MessageManager.getInstance().registerListener(this.fwy);
        MessageManager.getInstance().registerListener(this.fym);
        MessageManager.getInstance().registerListener(this.fwz);
        MessageManager.getInstance().registerListener(this.fww);
        bsn();
        bsg();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void i(com.baidu.live.data.n nVar) {
        super.i(nVar);
        if (this.fvV != null) {
            this.fvV.t(nVar);
        }
        if (this.fvW != null) {
            this.fvW.p(nVar);
        }
        if (this.fwa != null) {
            this.fwa.s(nVar);
        }
        if (this.fwe != null) {
            this.fwe.a(nVar);
        }
        kg(false);
        ke(false);
        if (this.fwb != null) {
            this.fwb.h(nVar);
            this.fwb.jQ(this.fxE);
            this.fwb.updateView();
            if (nVar != null && this.fxs != null && !this.fxs.hasInit && !TextUtils.isEmpty(this.fxs.avN)) {
                this.fxs.hasInit = true;
                this.fwb.Av(this.fxs.avN);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(h hVar) {
        if (hVar != null) {
            if (this.fvU != null && hVar.getList() != null) {
                this.fvU.e(hVar);
            }
            if (this.fvZ != null) {
                this.fvZ.dk(hVar.getCount());
            }
        }
    }

    private void brM() {
        if (this.fwR != null) {
            this.fwR.ak(bti().fFb.getLiveContainerView());
        }
    }

    private void bts() {
        if (this.fwf == null) {
            this.fwf = new com.baidu.tieba.ala.liveroom.attentionpop.b(bti().pageContext);
        }
        if (bti().fFc != null && bti().fFc.DN() != null && bti().fFc.DN().mLiveInfo != null) {
            this.fwf.Aw(String.valueOf(bti().fFc.DN().mLiveInfo.user_id));
        }
    }

    private void btt() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (bti() != null && bti().fFc != null && bti().fFc.DN() != null && bti().fFc.DN().mLiveInfo != null) {
                j = bti().fFc.DN().mLiveInfo.room_id;
            }
            if (this.fxe == null) {
                this.fxe = new com.baidu.tieba.ala.liveroom.guide.a(bti().pageContext, j);
            }
            this.fxe.jX(this.fxx);
            this.fxe.a(new a.InterfaceC0494a() { // from class: com.baidu.tieba.ala.liveroom.c.d.4
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0494a
                public void btx() {
                    if (d.this.aPT != null) {
                        d.this.aPT.bF(true);
                    }
                }
            });
            this.fxe.ah(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bx(int i) {
        super.bx(i);
        brM();
        if (this.fwe != null) {
            this.fwe.bx(i);
        }
    }

    private void brO() {
        if (this.fyj == null) {
            this.fyj = new DispatchedRelativeLayout(bti().pageContext.getPageActivity());
            this.fyj.setViewActionDispatched(false);
            this.fyj.setViewActionDispatchListener(new com.baidu.live.view.dispatch.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.5
                @Override // com.baidu.live.view.dispatch.a
                public boolean Y(View view) {
                    return (d.this.fyh == null || d.this.fyh.HF() || view == null || !(view.getTag(a.g.sdk_pvl_layout_priority_tag_key) instanceof Integer)) ? false : true;
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewAdded(View view) {
                    view.setTag(a.g.ala_live_room_vertival_widgets_bk_lp_key, view.getLayoutParams());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(view.getLayoutParams().width, view.getLayoutParams().height);
                    layoutParams.gravity = 5;
                    view.setLayoutParams(layoutParams);
                    if (d.this.fyh != null) {
                        d.this.fyh.addView(view);
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewRemoved(View view) {
                    if (d.this.fyh != null) {
                        d.this.fyh.removeView(view);
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public void HH() {
                    if (d.this.fyh != null && !d.this.fyh.HF()) {
                        d.this.fyh.removeAllViews();
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public int indexOfChild(View view) {
                    if (d.this.fyh != null) {
                        return d.this.fyh.indexOfChild(view);
                    }
                    return 0;
                }
            });
        }
        if (this.fyj.getParent() == null) {
            bti().fFd.addView(this.fyj, kj(false));
        }
        if (this.fyh == null) {
            this.fyh = new DispatchedPvlLayout(bti().pageContext.getPageActivity());
            this.fyh.setDefaultItemMargin(bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.fyh.setViewActionDispatched(false);
            this.fyh.setViewActionDispatchListener(new com.baidu.live.view.dispatch.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.6
                @Override // com.baidu.live.view.dispatch.a
                public boolean Y(View view) {
                    return (d.this.fyj == null || d.this.fyj.HF() || view == null || !(view.getTag(a.g.ala_live_room_vertival_widgets_bk_lp_key) instanceof ViewGroup.LayoutParams)) ? false : true;
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewAdded(View view) {
                    view.setLayoutParams(new LinearLayout.LayoutParams(view.getLayoutParams().width, view.getLayoutParams().height));
                    d.this.fyj.addView(view, (ViewGroup.LayoutParams) view.getTag(a.g.ala_live_room_vertival_widgets_bk_lp_key));
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewRemoved(View view) {
                    d.this.fyj.removeView(view);
                }

                @Override // com.baidu.live.view.dispatch.a
                public void HH() {
                    if (d.this.fyj != null && !d.this.fyj.HF()) {
                        d.this.fyj.removeAllViews();
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public int indexOfChild(View view) {
                    return d.this.fyj.indexOfChild(view);
                }
            });
        }
        if (this.fyh.getParent() == null) {
            bti().fFd.addView(this.fyh, btw());
        }
    }

    private void brQ() {
        if (this.fyi == null) {
            this.fyi = new View(bti().pageContext.getPageActivity());
            this.fyi.setTag(a.g.sdk_pvl_layout_priority_tag_key, 20);
        }
        if (this.fyi.getParent() == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(1, 0);
            layoutParams.weight = 1.0f;
            this.fyh.addView(this.fyi, layoutParams);
        }
    }

    private void btu() {
        if (this.fyi != null) {
            this.fyh.removeView(this.fyi);
        }
    }

    private void brR() {
        if (this.fvT == null) {
            this.fvT = new LinearLayout(bti().pageContext.getPageActivity());
            this.fvT.setOrientation(1);
        }
        if (this.fvT.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds160);
            layoutParams.leftMargin = bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bti().fFd.addView(this.fvT, layoutParams);
        }
    }

    private void brT() {
        if (this.fwP != null && bti() != null && bti().fFc != null) {
            this.fwP.b(this.fxu, bti().fFc.DN());
        }
    }

    private void brS() {
        if (this.fwb == null) {
            this.fwb = new com.baidu.tieba.ala.liveroom.activeview.b(bti().pageContext);
        }
        this.fwb.jP(this.fva);
        this.fwb.setOtherParams(Cr());
        this.fwb.b(bti().fFc.DN(), false);
        this.fwb.setHost(false);
        this.fwb.jQ(this.fxE);
        this.fwb.a(1, this.fvT, qm(1));
        this.fwb.a(2, this.fyh, qm(2));
        this.fwb.setVisible(this.fxy ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brZ() {
        if (this.fvY == null) {
            bse();
        }
        this.fvY.setOtherParams(Cr());
        this.fvY.a(com.baidu.live.v.c.Et().aRE, bti().fFc.DN());
    }

    private ViewGroup.LayoutParams qm(int i) {
        switch (i) {
            case 1:
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (this.fvT == null || this.fvT.getChildCount() == 0) {
                    return layoutParams;
                }
                layoutParams.topMargin = bti().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                return layoutParams;
            case 2:
                ViewGroup.LayoutParams layoutParams2 = this.fyj.getLayoutParams();
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(((int) (BdUtilHelper.getEquipmentWidth(bti().pageContext.getPageActivity()) * 0.25f)) - ((layoutParams2 instanceof LinearLayout.LayoutParams ? ((LinearLayout.LayoutParams) layoutParams2).rightMargin : 0) * 2), -2);
                layoutParams3.gravity = 5;
                return layoutParams3;
            default:
                return new RelativeLayout.LayoutParams(-2, -2);
        }
    }

    private void brU() {
        if (this.fwa == null) {
            this.fwa = new com.baidu.tieba.ala.liveroom.j.a(bti().pageContext, this);
        }
        this.fwa.setOtherParams(Cr());
        this.fwa.d(this.fyj, brY());
        this.fwa.s(bti().fFc.DN());
    }

    private void brV() {
        if (this.fxi == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, com.baidu.live.guardclub.j.class, bti().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.fxi = (com.baidu.live.guardclub.j) runTask.getData();
            } else {
                return;
            }
        }
        this.fxi.setOtherParams(Cr());
        if (this.fwi != null && this.fwi.indexOfChild(this.fxi.getView()) >= 0) {
            this.fwi.removeView(this.fxi.getView());
        }
    }

    private void brW() {
        if (this.fvY != null) {
            this.fvY.a(new a.InterfaceC0500a() { // from class: com.baidu.tieba.ala.liveroom.c.d.7
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0500a
                public void br(int i, int i2) {
                    com.baidu.live.data.n DN = d.this.bti().fFc.DN();
                    if (DN != null && DN.mLiveInfo != null) {
                        if (d.this.fxm == null) {
                            d.this.fxm = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.bti().pageContext.getPageActivity());
                        }
                        d.this.fxm.d(d.this.fxv, i, i2);
                        d.this.fxm.a(String.valueOf(DN.mLiveInfo.live_id), new a.InterfaceC0503a() { // from class: com.baidu.tieba.ala.liveroom.c.d.7.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0503a
                            public void a(float f, String str) {
                                if (d.this.fvY != null) {
                                    d.this.fvY.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0500a
                public void bs(int i, int i2) {
                    if (d.this.fxm != null) {
                        d.this.fxm.bx(i, i2);
                    }
                }
            });
        }
    }

    private void brX() {
        if (this.fxJ == null) {
            this.fxJ = new com.baidu.tieba.ala.liveroom.h.e(bti().pageContext);
        }
        this.fxJ.setRoomId(bti().fFc.DN().mLiveInfo.room_id);
        this.fxJ.AJ("");
        this.fxJ.a(bti().fFc.DN(), this.fyh);
        if (this.fwq == null) {
            this.fwq = new com.baidu.tieba.ala.liveroom.h.b(bti().pageContext, Cr(), this.fxJ, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.8
                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void bsw() {
                    d.this.jY(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void bsx() {
                    d.this.jY(false);
                }
            });
        }
        this.fwq.setRoomId(bti().fFc.DN().mLiveInfo.room_id);
        if (this.fwi != null && this.fwi.indexOfChild(this.fwq.getView()) >= 0) {
            this.fwi.removeView(this.fwq.getView());
        }
        if (this.fwq != null) {
            this.fwq.b(bti());
        }
    }

    private ViewGroup.LayoutParams brY() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.topMargin = (ScreenHelper.getRealScreenHeight(bti().pageContext.getPageActivity()) - this.fyj.getTop()) - bti().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds814);
        return layoutParams;
    }

    private void bsa() {
        CustomResponsedMessage runTask;
        if (this.fwW == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, bti().pageContext)) != null && runTask.getData() != null) {
            this.fwW = (k) runTask.getData();
            this.fwW.setFromMaster(false);
            this.fwW.Bf().getView().setId(a.g.ala_liveroom_msg_list);
            this.fwW.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.9
                @Override // com.baidu.live.im.k.a
                public boolean Bh() {
                    return d.this.zA();
                }

                @Override // com.baidu.live.im.k.a
                public void Bi() {
                    d.this.fxC = true;
                }

                @Override // com.baidu.live.im.k.a
                public void eE(String str) {
                    if (!d.this.fxy) {
                        d.this.jW(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.bti().pageContext.getPageActivity(), d.this.bti().fFb.getLiveContainerView());
                    }
                    d.this.Ay(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Bj() {
                    if (d.this.fxy) {
                        d.this.jW(true);
                        d.this.bti().fFb.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.bti().pageContext.getPageActivity(), d.this.bti().fFb.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.fwW != null) {
                        d.this.fwW.Bg().setQuickInputPanelVisible(false);
                        d.this.fwW.Bg().CO();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Bk() {
                    if (d.this.fxy) {
                        d.this.bsv();
                        if (d.this.fwX != null) {
                            d.this.fwX.Bn();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Bl() {
                    return d.this.bsF();
                }
            });
            this.fwi = new FrameLayout(bti().pageContext.getPageActivity());
            this.fwi.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.fwW != null && this.fwi != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bti().pageContext.getPageActivity()) * 0.75f);
            int dimensionPixelSize = bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64) + ((int) (BdUtilHelper.getEquipmentHeight(bti().pageContext.getPageActivity()) * 0.27f));
            if (this.fxv.indexOfChild(this.fwi) < 0) {
                if (this.fwi.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fwi.getParent()).removeView(this.fwi);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds27) + dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
                this.fxv.addView(this.fwi, layoutParams);
            }
            if (this.fwi.indexOfChild(this.fwW.Bf().getView()) < 0) {
                if (this.fwW.Bf().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fwW.Bf().getView()).removeView(this.fwW.Bf().getView());
                }
                this.fwi.addView(this.fwW.Bf().getView(), new FrameLayout.LayoutParams(equipmentWidth, dimensionPixelSize));
            }
            if (bti().fFd.indexOfChild(this.fwW.Bg().getView()) < 0) {
                if (this.fwW.Bg().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fwW.Bg().getView().getParent()).removeView(this.fwW.Bg().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bsL();
                bti().fFd.addView(this.fwW.Bg().getView(), layoutParams2);
            }
            com.baidu.live.data.n DN = bti().fFc.DN();
            if (DN != null && DN.mLiveInfo != null) {
                this.fwW.setLogData(DN.mLiveInfo.feed_id, Cr());
            }
            this.fwW.e(String.valueOf(bti().fFc.DN().mLiveInfo.group_id), String.valueOf(bti().fFc.DN().mLiveInfo.last_msg_id), String.valueOf(bti().fFc.DN().aqe.userId), String.valueOf(bti().fFc.DN().mLiveInfo.live_id), bti().fFc.DN().aqe.appId);
            jW(false);
        }
    }

    private void bsc() {
        if (this.fvV == null) {
            this.fvV = new com.baidu.tieba.ala.liveroom.l.a(bti().pageContext, false, this);
        }
        this.fvV.c(this.fxu, bti().fFc.DN());
        this.fvV.a(this.fwA);
        this.fvV.setOtherParams(Cr());
    }

    private void bsd() {
        if (this.fvU == null) {
            this.fvU = new com.baidu.tieba.ala.liveroom.audiencelist.c(bti().pageContext, this, false);
        }
        this.fvU.a(String.valueOf(bti().fFc.DN().mLiveInfo.group_id), String.valueOf(bti().fFc.DN().mLiveInfo.live_id), String.valueOf(bti().fFc.DN().aqe.userId), bti().fFc.DN());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.fwK != null && this.fwK.getView() != null && this.fwK.getView().getParent() != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.fvU.c(this.fxu, i, a.g.ala_liveroom_audience_count_layout);
            this.fvU.e(bti().fFc.bnr());
            this.fvU.setOtherParams(Cr());
        }
    }

    private void bse() {
        if (this.fvY == null) {
            this.fvY = new com.baidu.tieba.ala.liveroom.operation.a(bti().pageContext);
        }
        this.fvY.a(bti(), this.fxv, bti().fFc.DN().mLiveInfo.live_type, true, this.fwA);
        this.fvY.setOtherParams(Cr());
    }

    public void kd(boolean z) {
        if (this.fvY != null) {
            this.fvY.kd(z);
        }
    }

    private void bsh() {
        if (this.fvZ == null) {
            this.fvZ = new com.baidu.tieba.ala.liveroom.audiencelist.b(bti().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (bti().fFc.bnr() != null) {
            j = bti().fFc.bnr().getCount();
        }
        this.fvZ.a(this.fwA);
        this.fvZ.a(this.fxu, a.g.ala_liveroom_audience, j);
        this.fvZ.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.fvZ.kl(false);
        } else {
            this.fvZ.kl(true);
        }
    }

    protected void Az(String str) {
        if (this.fxI == null) {
            this.fxI = new com.baidu.tieba.ala.liveroom.q.b(bti().pageContext);
        }
        this.fxI.b(this.fxv, str);
        jY(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.10
            @Override // java.lang.Runnable
            public void run() {
                d.this.fxI.bzM();
                d.this.jY(false);
            }
        }, 5000L);
    }

    private void ke(boolean z) {
        CustomResponsedMessage runTask;
        if (bti().fFc.DN().mLiveInfo.live_type == 1 && this.fyl) {
            if (this.fyk == null && (runTask = MessageManager.getInstance().runTask(2913074, f.class, bti().pageContext)) != null && runTask.getData() != null) {
                this.fyk = (f) runTask.getData();
            }
            if (this.fyk != null) {
                if (this.fwd == null) {
                    this.fwd = this.fyk.a(bti().pageContext);
                }
                if (bti().fFc.DN().mLiveInfo.challengeId > 0 && !this.fwd.ux()) {
                    this.fwd.d(bti().fFc.DN().mLiveInfo.live_id, bti().fFc.DN().aqe.userId);
                    kf(z);
                    if (z) {
                        this.fwd.a(bti().fFc.byE());
                    }
                    this.fwd.c(bti().fFc.DN());
                }
            }
        }
    }

    private void kf(boolean z) {
        if (this.fwe == null) {
            this.fwe = this.fyk.b(bti().pageContext);
            this.fwe.a(new com.baidu.live.challenge.h() { // from class: com.baidu.tieba.ala.liveroom.c.d.11
                @Override // com.baidu.live.challenge.h
                public void um() {
                    d.this.bti().fFd.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.h
                public void a(ag agVar, ah ahVar, ah ahVar2) {
                    d.this.fva = true;
                    if (d.this.fwQ != null) {
                        d.this.fwQ.setPraiseEnable(false);
                        d.this.bti().fFd.fSe = false;
                    }
                    if (d.this.fwa != null) {
                        d.this.fwa.setCanVisible(false);
                        d.this.fwa.bvD();
                    }
                    if (d.this.fwb != null) {
                        d.this.fwb.jP(true);
                    }
                    if (d.this.fxJ != null) {
                        d.this.fxJ.setVisible(8);
                    }
                    if (d.this.fwc != null) {
                        d.this.fwc.setCanVisible(false);
                        d.this.fwc.setVisible(8);
                    }
                    d.this.kh(true);
                    d.this.ki(true);
                    if (d.this.bti().aPW != null) {
                        d.this.bti().aPW.getLivePlayer().setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                    }
                    if (d.this.fwO != null) {
                        d.this.fwO.setTimeTextMode(true);
                    }
                    if (d.this.aPT != null && ahVar != null && ahVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(ahVar.auq);
                        arrayList.add(ahVar2.auq);
                        com.baidu.live.liveroom.a.b bVar = d.this.aPT;
                        if (d.this.fxF) {
                            arrayList = null;
                        }
                        bVar.j(arrayList);
                    }
                }

                @Override // com.baidu.live.challenge.h
                public void un() {
                }

                @Override // com.baidu.live.challenge.h
                public void uo() {
                }

                @Override // com.baidu.live.challenge.h
                public void aR(boolean z2) {
                    d.this.bti().fFd.setSwipeClearEnable(true);
                    d.this.fva = false;
                    if (d.this.fwQ != null) {
                        d.this.fwQ.setPraiseEnable(true);
                        d.this.bti().fFd.fSe = true;
                    }
                    if (d.this.fwa != null) {
                        d.this.fwa.setCanVisible(true);
                        d.this.fwa.s(d.this.bti().fFc.DN());
                    }
                    if (d.this.fwS != null) {
                        d.this.fwS.kX(true);
                    }
                    if (d.this.fwb != null) {
                        d.this.fwb.jP(false);
                    }
                    if (d.this.fxJ != null) {
                        d.this.fxJ.setVisible(0);
                    }
                    if (d.this.fwc != null) {
                        d.this.fwc.setCanVisible(true);
                        d.this.fwc.setVisible(0);
                    }
                    d.this.kh(false);
                    d.this.ki(false);
                    if (d.this.aPT != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.bti().fFc.bzr());
                        com.baidu.live.liveroom.a.b bVar = d.this.aPT;
                        if (d.this.fxF) {
                            arrayList = null;
                        }
                        bVar.j(arrayList);
                    }
                    if (d.this.bti().aPW != null) {
                        d.this.bti().aPW.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
                    }
                    if (d.this.fwO != null) {
                        d.this.fwO.setTimeTextMode(false);
                    }
                }
            });
        }
        this.fwe.a(this.fwd);
        this.fwe.f(bti().fFb.getLiveContainerView());
        this.fwe.b(z, false, false);
        this.fwd.a((j.c) this.fwe);
    }

    private void kg(boolean z) {
        CustomResponsedMessage runTask;
        if (bti().fFc.DN().mLiveInfo.live_type == 1 && com.baidu.live.v.a.Eo().aQp.asu) {
            if (this.fwc == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bti().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.fwc = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.fwc != null) {
                this.fwc.a(bti().fFc.bzt(), false, false);
                if (bti().fFc.DN().mLiveInfo.pkId > 0 && this.fwc.getRootView() != null && this.fwc.getRootView().getParent() == null && this.fyj != null) {
                    if (this.fyj.getChildCount() <= 0) {
                        this.fyj.addView(this.fwc.getRootView(), new LinearLayout.LayoutParams(-2, -2));
                    } else {
                        View childAt = this.fyj.getChildAt(0);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.topMargin = bti().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                        childAt.setLayoutParams(layoutParams);
                        this.fyj.addView(this.fwc.getRootView(), 0, new LinearLayout.LayoutParams(-2, -2));
                    }
                }
                if (z) {
                    this.fwc.a(null, bti().fFc.DN());
                } else {
                    this.fwc.b(bti().fFc.DN());
                }
            }
        }
    }

    public void bsi() {
        this.fwL.c(bti().fFc.DN(), false);
    }

    public void bsj() {
        if (bti().fFc.DN() != null && bti().fFc.DN().aqe != null && bti().fFc.DN().mLiveInfo != null) {
            if (this.fvX == null) {
                this.fvX = new com.baidu.tieba.ala.liveroom.r.b(bti().pageContext);
            }
            long j = bti().fFc.DN().aqe.userId;
            int i = bti().fFc.DN().mLiveInfo.live_type;
            String str = bti().fFc.DN().aqe.portrait;
            String str2 = bti().fFc.DN().mLiveInfo.feed_id;
            long j2 = bti().fFc.DN().mLiveInfo.live_id;
            this.fvX.a(i, j, bti().fFc.DN().aqe.userName, false, str, Cr(), str2, j2);
            this.fvX.ah(this.fxu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kh(boolean z) {
        if (this.fyh != null && this.fyj != null) {
            if (z) {
                this.fyh.setViewActionDispatched(false);
                this.fyj.setViewActionDispatched(true);
                ViewGroup.LayoutParams layoutParams = this.fyh.getLayoutParams();
                layoutParams.height = btv();
                this.fyh.setLayoutParams(layoutParams);
                brQ();
                return;
            }
            this.fyj.setViewActionDispatched(false);
            this.fyh.setViewActionDispatched(true);
            ViewGroup.LayoutParams layoutParams2 = this.fyh.getLayoutParams();
            layoutParams2.height = -2;
            this.fyh.setLayoutParams(layoutParams2);
            btu();
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
        if (this.fwb != null) {
            ?? layoutParams = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams) layoutParams).gravity = 5;
            ?? r2 = this.fwb;
            ViewGroup viewGroup = z ? this.fyh : this.fvT;
            if (!z) {
                layoutParams = qm(1);
            }
            r2.a(1, viewGroup, layoutParams, 21);
            this.fwb.updateView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int btv() {
        return (((bti().fFd.getBottom() - (this.fwe != null ? this.fwe.aS(false) : 0)) - (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0)) - bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsk() {
        if (bti() == null || bti().fFc == null || bti().fFc.DN() == null || bti().fFc.DN().aqx == null) {
            if (bti().fFc == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bti().fFc.DN() == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bti().fFc.DN().aqx == null) {
                Log.i("RenameLog", "getLiveContext().liveModel.getLiveShowData().mLoginUserInfo == null");
                return;
            } else {
                return;
            }
        }
        String str = bti().fFc.DN().aqx.userName;
        Log.i("RenameLog", "loginUserName:" + str);
        if (str != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bti().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !bsE()) {
            com.baidu.live.c.tH().putInt("guide_rename_show_count", com.baidu.live.c.tH().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.Dl().bE(true);
            if (this.fxp == null) {
                this.fxp = new com.baidu.tieba.ala.liveroom.s.a(bti().pageContext);
            }
            this.fxp.setOtherParams(Cr());
            this.fxp.e(this.fxv, bti().fFc.DN());
            jY(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.14
                @Override // java.lang.Runnable
                public void run() {
                    d.this.fxp.bzQ();
                    d.this.jY(false);
                }
            }, 5000L);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_SHOW);
                alaStaticItem.addParams("other_params", Cr());
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    private void bsl() {
        boolean z = false;
        if (this.fwS == null) {
            this.fwS = new com.baidu.tieba.ala.liveroom.v.a(bti().pageContext, this);
        }
        this.fwS.d(bti().fFd, false);
        if (bth() && bti().fFc.DN().mLiveInfo.screen_direction != 2) {
            z = true;
        }
        this.fwS.kW(z);
    }

    private void bsn() {
        if (this.fxC || this.fxD) {
            if ((TbadkCoreApplication.isLogin() && this.fwW.Bg().hasText()) || this.fxD) {
                this.fxC = false;
                this.fxD = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.15
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bsK();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void bsf() {
        bsg();
    }

    private void bsg() {
        if (this.fvY != null) {
            int i = bti().fFc.DN().aqx.isUegBlock;
            int i2 = bti().fFc.DN().aqx.isBlock;
            String str = bti().fFc.DN().aqx.userName;
            if (i > 0 || i2 > 0) {
                this.fvY.b(true, i, i2, str);
                this.fwW.a(true, i, i2, str);
                this.fxc.b(true, i, i2, str);
                return;
            }
            this.fvY.b(false, i, i2, str);
            this.fwW.a(false, i, i2, str);
            this.fxc.b(false, i, i2, str);
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
                if (this.fwa != null) {
                    this.fwa.A(jSONObject);
                }
            } else if ("enter_live".equals(optString)) {
                if (this.fvZ != null && this.fvZ.getCount() > 20) {
                    this.fvZ.dk(this.fvZ.getCount() + 1);
                } else if (this.fvU != null) {
                    com.baidu.live.data.a Cf = aVar.Cf();
                    com.baidu.live.data.g gVar = new com.baidu.live.data.g();
                    gVar.aqf = new AlaLocationData();
                    gVar.aqg = new AlaRelationData();
                    gVar.aqe = new AlaLiveUserInfoData();
                    gVar.aqe.userId = JavaTypesHelper.toLong(Cf.userId, 0L);
                    gVar.aqe.userName = Cf.userName;
                    gVar.aqe.portrait = Cf.portrait;
                    if (this.fvZ != null && this.fvU.c(gVar)) {
                        this.fvZ.dk(this.fvZ.getCount() + 1);
                    }
                }
            } else if ("update_liveinfo".equals(optString) && bti().fFc.DN() != null && bti().fFc.DN().mLiveInfo != null) {
                bti().fFc.a(bti().fFc.DN().mLiveInfo.live_id, bti().fromType, bti().enterTime);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void Au(String str) {
        if (this.fwb != null) {
            this.fwb.Au(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void bJ(boolean z) {
        super.bJ(z);
        if (bti().fFd != null) {
            bti().fFd.bAG();
            bti().fFd.setLiveViewOnDispatchTouchEventListener(null);
            bti().fFd.setOnLiveViewScrollListener(null);
        }
        if (bti().aPW != null) {
            bti().aPW.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.fwe != null) {
            this.fwe.ug();
        }
        bso();
        if (this.fvX != null) {
            this.fvX.ug();
        }
        if (this.fwS != null) {
            this.fwS.release();
        }
        if (this.fwa != null) {
            this.fwa.ug();
        }
        if (this.fvY != null) {
            this.fvY.bzw();
        }
        if (this.fvW != null) {
            this.fvW.buT();
            this.fvW.setVisible(8);
        }
        if (this.fwc != null) {
            this.fwc.ug();
        }
        if (this.fwb != null) {
            this.fwb.release();
        }
        if (this.fyj != null) {
            this.fyj.setViewActionDispatched(false);
            this.fyj.removeAllViews();
            this.fyj = null;
        }
        if (this.fyh != null) {
            this.fyh.setViewActionDispatched(false);
            this.fyh.removeAllViews();
            this.fyh = null;
        }
        if (this.fvT != null) {
            this.fvT.removeAllViews();
            this.fvT = null;
        }
        if (this.fwS != null) {
            this.fwS.onDestroy();
        }
        if (this.fwd != null) {
            this.fwd.ug();
        }
        if (this.fwq != null) {
            this.fwq.cancel();
        }
        if (this.fxJ != null) {
            this.fxJ.btY();
        }
        if (this.fwq != null) {
            this.fwq.ug();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void bI(boolean z) {
        super.bI(z);
        bso();
        if (this.fvV != null) {
            this.fvV.onDestroy();
        }
        if (this.fvX != null) {
            this.fvX.onDestroy();
        }
        if (this.fwa != null) {
            this.fwa.onDestroy();
        }
        if (this.fwc != null) {
            this.fwc.onDestroy();
        }
        if (this.fwd != null) {
            this.fwd.onDestroy();
        }
        if (this.fwe != null) {
            this.fwe.onDestroy();
        }
        if (this.fwf != null) {
            this.fwf.onDestroy();
        }
        if (this.fxe != null) {
            this.fxe.onDestroy();
        }
        if (this.fvW != null) {
            this.fvW.onDestroy();
        }
        if (this.fvU != null) {
            this.fvU.onDestroy();
        }
        if (this.fwW != null) {
            this.fwW.onDestroy();
        }
        if (this.fvY != null) {
            this.fvY.onDestory();
        }
        if (this.fwb != null) {
            this.fwb.release();
        }
        if (this.fxJ != null) {
            this.fxJ.bI(!z);
        }
        if (this.fwq != null) {
            this.fwq.onDestroy();
            this.fwq = null;
        }
        MessageManager.getInstance().removeMessageRule(this.fwr);
        MessageManager.getInstance().removeMessageRule(this.fws);
        MessageManager.getInstance().unRegisterListener(this.fwu);
        MessageManager.getInstance().unRegisterListener(this.fwv);
        MessageManager.getInstance().unRegisterListener(this.fyn);
        MessageManager.getInstance().unRegisterListener(this.fwx);
        MessageManager.getInstance().unRegisterListener(this.fwy);
        MessageManager.getInstance().unRegisterListener(this.fym);
        MessageManager.getInstance().unRegisterListener(this.fwz);
        MessageManager.getInstance().unRegisterListener(this.fww);
    }

    private void bso() {
        if (this.fwW != null && this.fwW.Bf().getView() != null && this.fwW.Bf().getView().getParent() != null) {
            ((ViewGroup) this.fwW.Bf().getView().getParent()).removeView(this.fwW.Bf().getView());
        }
        if (this.fwi != null && this.fwi.getParent() != null) {
            ((ViewGroup) this.fwi.getParent()).removeView(this.fwi);
        }
        if (this.fwW != null && this.fwW.Bg().getView() != null) {
            this.fxv.removeView(this.fwW.Bg().getView());
        }
        if (this.fwW != null) {
            this.fwW.Bf().setMsgData(new LinkedList());
            this.fwW.AK();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void a(z zVar) {
        if (this.fwW != null) {
            bsK();
            this.fwW.Bg().setEditText(" @" + zVar.getNameShow() + " ");
        }
        if (this.fvY != null) {
            this.fvY.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void f(com.baidu.live.data.a aVar) {
        if (this.fwW != null) {
            bsK();
            this.fwW.Bg().setEditText(" @" + aVar.userName + " ");
        }
        if (this.fvY != null) {
            this.fvY.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void b(z zVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected View bsp() {
        if (this.fwW != null) {
            return this.fwW.Bg().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean bsq() {
        if (this.fwW == null || !this.fwW.Bg().CN()) {
            return false;
        }
        jW(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean bsr() {
        return this.fvV == null || this.fvV.bsr();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup bss() {
        return this.fyj;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup bst() {
        return this.fvT;
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
                    this.fxz = false;
                    M(intExtra, intExtra2, intExtra3);
                    return;
                }
                bsi();
                return;
            }
            btg();
        } else if (i == 25051 && i2 == -1 && this.fxJ != null) {
            this.fxJ.bvs();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.fwW != null && this.fwW.Bf() != null) {
            this.fwW.Bf().onKeyboardVisibilityChanged(z);
        }
        if (z || this.fwW == null || this.fwW.Bg() == null || !this.fwW.Bg().CN()) {
            if (z) {
                if (this.fvY != null) {
                    this.fvY.setVisibility(8);
                }
                if (this.fwY != null && this.fwY.wJ() != null) {
                    this.fwY.wJ().setVisibility(8);
                }
                bsv();
                if (this.fwW != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fwW.Bg().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.fwW.Bg().getView().setLayoutParams(layoutParams);
                    this.fwW.Bg().getView().setVisibility(0);
                    this.fwW.Bg().setQuickInputPanelVisible(false);
                }
                if (this.fxu != null) {
                    this.fxu.setVisibility(8);
                }
                if (this.fwb != null) {
                    this.fwb.setVisible(8);
                }
                if (this.fwX != null) {
                    this.fwX.Bn();
                }
                if (this.fxt != null) {
                    this.fxt.setCanVisible(false);
                }
            } else {
                bsu();
            }
            if (this.fwW != null && this.fwi != null) {
                int equipmentHeight = (int) (((z ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(bti().pageContext.getPageActivity())) + bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
                if (this.fxv.indexOfChild(this.fwi) != -1 && this.fwi.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fwi.getLayoutParams();
                    layoutParams2.height = bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds27) + equipmentHeight;
                    this.fwi.setLayoutParams(layoutParams2);
                }
                if (this.fwi.indexOfChild(this.fwW.Bf().getView()) != -1 && this.fwW.Bf().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.fwW.Bf().getView().getLayoutParams();
                    layoutParams3.height = equipmentHeight;
                    this.fwW.Bf().getView().setLayoutParams(layoutParams3);
                }
                this.fwW.Bf().Be();
            }
            if (this.fxj != null) {
                this.fxj.aY(z);
            }
        }
    }

    private void bsu() {
        if (this.fvY != null) {
            this.fvY.setVisibility(0);
        }
        if (this.fwi != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fwi.getLayoutParams();
            layoutParams.bottomMargin = bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
            this.fwi.setLayoutParams(layoutParams);
        }
        if (this.fwW != null) {
            bsL();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fwW.Bg().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.fwW.Bg().getView().setLayoutParams(layoutParams2);
        }
        if (this.fvY != null) {
            this.fvY.setVisibility(0);
        }
        if (this.fwY != null && this.fwY.wJ() != null) {
            this.fwY.wJ().setVisibility(0);
        }
        if (this.fxu != null) {
            this.fxu.setVisibility(0);
        }
        if (this.fwb != null) {
            this.fwb.setVisible(0);
        }
        if (this.fwX != null) {
            this.fwX.Bn();
        }
        if (this.fxt != null) {
            this.fxt.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsv() {
        if (this.fwi != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fwi.getLayoutParams();
            boolean z = false;
            if (this.fwW != null && this.fwW.Bg() != null) {
                z = this.fwW.Bg().CM();
            }
            int ka = ka(z);
            if (layoutParams.bottomMargin != ka) {
                layoutParams.bottomMargin = ka;
                this.fwi.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jW(boolean z) {
        if (z) {
            this.fwW.Bg().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fwi.getLayoutParams();
            int quickInputPanelExpandHeight = this.fwW.Bg().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.fwi.setLayoutParams(layoutParams);
                if (this.fwW.Bf() != null) {
                    this.fwW.Bf().Be();
                    return;
                }
                return;
            }
            return;
        }
        bsu();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.fvU != null) {
                this.fvU.cl(i3);
            }
            if (this.fvW != null) {
                this.fvW.cl(i3);
            }
        }
        super.l(i, i2, i3);
        if (this.fva && this.fyh != null) {
            this.fyh.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.16
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (d.this.fyh != null && (layoutParams = d.this.fyh.getLayoutParams()) != null) {
                        int i4 = layoutParams.height;
                        int btv = d.this.btv();
                        if (btv != i4) {
                            layoutParams.height = btv;
                            d.this.fyh.setLayoutParams(layoutParams);
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
            if (this.fvV.bsr()) {
                return false;
            }
            if (cr && this.fwS != null) {
                this.fwS.kX(false);
            }
        }
        return cr;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void qn(int i) {
        super.qn(i);
        if (i == 7 || i == 11) {
            if (this.fvY != null) {
                this.fvY.setVisibility(8);
            }
            if (this.fwW != null) {
                this.fwW.Bf().getView().setVisibility(4);
            }
            if (this.fwb != null) {
                this.fwb.bp(2, 8);
                if (this.fva) {
                    this.fwb.bp(1, 8);
                }
            }
            if (this.fxm != null) {
                this.fxm.kS(false);
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
            if (this.fvY != null) {
                this.fvY.setVisibility(0);
            }
            if (this.fwW != null) {
                this.fwW.Bf().getView().setVisibility(0);
            }
            if (this.fwb != null) {
                this.fwb.setVisible(0);
            }
            if (this.fxm != null) {
                this.fxm.kS(true);
            }
            this.fxu.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.fvX != null) {
            this.fvX.bzO();
        }
        if (this.fwd != null) {
            this.fwd.uq();
        }
        if (this.fwb != null) {
            this.fwb.onStop();
        }
        if (this.fwc != null) {
            this.fwc.aP(true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.fvX != null) {
            this.fvX.bzN();
        }
        if (this.fwd != null && this.fyl) {
            this.fwd.ur();
        }
        if (this.fwb != null) {
            this.fwb.onStart();
        }
        if (this.fwc != null) {
            this.fwc.aP(false);
        }
    }

    private ViewGroup.LayoutParams kj(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.fyj == null) {
            return null;
        }
        int btv = this.fva ? btv() : -2;
        ViewGroup.LayoutParams layoutParams2 = this.fyj.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, btv);
        }
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds112);
        layoutParams.topMargin = bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200);
        return layoutParams;
    }

    private ViewGroup.LayoutParams btw() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.fyh == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams2 = this.fyh.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
        return layoutParams;
    }
}
