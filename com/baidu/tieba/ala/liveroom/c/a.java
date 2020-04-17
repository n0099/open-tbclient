package com.baidu.tieba.ala.liveroom.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import com.baidu.live.challenge.i;
import com.baidu.live.challenge.j;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.as;
import com.baidu.live.data.bb;
import com.baidu.live.data.bh;
import com.baidu.live.data.h;
import com.baidu.live.data.z;
import com.baidu.live.gift.ab;
import com.baidu.live.gift.n;
import com.baidu.live.gift.y;
import com.baidu.live.guardclub.e;
import com.baidu.live.im.k;
import com.baidu.live.im.l;
import com.baidu.live.im.m;
import com.baidu.live.message.GetQuickGiftHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
import com.baidu.live.tbadk.core.atomdata.CommonWebViewActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
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
import com.baidu.live.view.PriorityVerticalLinearLayout;
import com.baidu.tieba.ala.liveroom.h.b;
import com.baidu.tieba.ala.liveroom.h.g;
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.turntable.d;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends b {
    private PriorityVerticalLinearLayout fvS;
    private LinearLayout fvT;
    private com.baidu.tieba.ala.liveroom.audiencelist.c fvU;
    private com.baidu.tieba.ala.liveroom.l.a fvV;
    private com.baidu.tieba.ala.liveroom.e.b fvW;
    private com.baidu.tieba.ala.liveroom.r.b fvX;
    private com.baidu.tieba.ala.liveroom.operation.a fvY;
    private com.baidu.tieba.ala.liveroom.audiencelist.b fvZ;
    private com.baidu.tieba.ala.liveroom.j.a fwa;
    private com.baidu.tieba.ala.liveroom.activeview.b fwb;
    private com.baidu.live.d.a fwc;
    private j fwd;
    private i fwe;
    private com.baidu.tieba.ala.liveroom.attentionpop.b fwf;
    private l fwg;
    private com.baidu.tieba.ala.liveroom.share.b fwh;
    private FrameLayout fwi;
    private FrameLayout fwj;
    private ImageView fwk;
    private com.baidu.live.tieba.e.b fwl;
    private y fwp;
    private com.baidu.tieba.ala.liveroom.h.b fwq;
    private long lastClickTime = 0;
    private boolean fwm = false;
    private boolean fwn = false;
    private Handler fwo = new Handler();
    private HttpRule fwr = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.fwd != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.fwd.uw()) {
                httpMessage.addParam("ala_challenge_id", a.this.fwd.uz());
            }
            return httpMessage;
        }
    };
    private HttpRule fws = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.c.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.fwd != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.fwd.uw()) {
                httpMessage.addParam("challenge_id", a.this.fwd.uz());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c fwt = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.c.a.17
        @Override // com.baidu.live.liveroom.g.c
        public void DL() {
            if (a.this.fwS != null) {
                a.this.fwS.kX(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bK(boolean z) {
            if (z) {
                if (a.this.fvY != null) {
                    a.this.fvY.qU(8);
                }
                if (a.this.fwS != null) {
                    a.this.fwS.kX(true);
                }
            } else {
                if (a.this.fvY != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                        a.this.fvY.qU(0);
                    } else {
                        a.this.fvY.qU(8);
                    }
                }
                if (a.this.fwS != null) {
                    a.this.fwS.kX(false);
                }
            }
            if (a.this.fxj != null) {
                a.this.fxj.aZ(z);
            }
        }
    };
    private HttpMessageListener fwu = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.a.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.DV() != null) {
                        com.baidu.live.v.c.Et().aRE = getQuickGiftHttpResponseMessage.DV();
                        a.this.brZ();
                    }
                }
            }
        }
    };
    private CustomMessageListener fwv = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.a.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bsk();
        }
    };
    private CustomMessageListener fww = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.c.a.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.fxn != null) {
                    a.this.fxn.AB(str);
                }
            }
        }
    };
    CustomMessageListener fwx = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.fxB != null && a.this.fxB.aIR != null && !a.this.fxB.aIU && !a.this.fxB.aIV && a.this.fxi != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.bti().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = a.this.bti().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                a.this.fxi.b(a.this.fwi, layoutParams);
                if (e.Ar() != null) {
                    e.Ar().Ax();
                }
            }
        }
    };
    private CustomMessageListener fwy = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (a.this.fxl != null) {
                    a.this.fxl.dismiss();
                }
                m.Bp().setSwitchStatus(true);
                m.Bp().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bsK();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener fwz = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.fwq.c(a.this.bti());
                } else if (a.this.bsE() || !g.qv(2913168)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, 3000L);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.bti().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.bti().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    a.this.fwq.b(a.this.fwi, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b fwA = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.a.8
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
            if (currentTimeMillis - a.this.lastClickTime >= 300) {
                a.this.lastClickTime = currentTimeMillis;
                if (i == 2 && a.this.zA()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "gift_panel"));
                    a.this.M(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.v.c.Et().aRE.wS().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.v.c.Et().aRE.wS().vV());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.v.c.Et().aRE.wS().vW());
                        if (a.this.bti().fFc.DN() != null && a.this.bti().fFc.DN().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.bti().fFc.DN().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.bti().fFc.DN().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.Cr());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.zA()) {
                        if (com.baidu.live.c.tH().getBoolean("quick_gift_guide_show", true) && !a.this.bsE()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, y.class, a.this.bti().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                y yVar = (y) runTask.getData();
                                yVar.setPageContext(a.this.bti().pageContext);
                                yVar.d(a.this.bti().fFc.DN());
                                yVar.setGiftItem(com.baidu.live.v.c.Et().aRE.wS());
                                yVar.setOtherParams(a.this.Cr());
                                yVar.initView();
                                yVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.8.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        a.this.jY(false);
                                        a.this.fwp = null;
                                    }
                                });
                                a.this.fwp = yVar;
                                yVar.show();
                                a.this.jY(true);
                                return;
                            }
                            return;
                        }
                        n.a(a.this.bti().pageContext, a.this.bti().fFc.DN(), com.baidu.live.v.c.Et().aRE.wS(), a.this.Cr());
                    }
                } else if (i == 1) {
                    if (a.this.fwW != null) {
                        a.this.bsK();
                    }
                } else if (i == 3 && a.this.zA()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "share_clk"));
                    if (a.this.mOrientation == 2 && TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.fwh != null) {
                            a.this.fwh.w(a.this.bti().fFc.DN());
                        }
                    } else {
                        a.this.fwL.c(a.this.bti().fFc.DN(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.bti() != null && a.this.bti().fFc != null && a.this.bti().fFc.DN() != null && a.this.bti().fFc.DN().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.bti().fFc.DN().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.bti().fFc.DN().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.bti().fFc.DN().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.Cr());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.bti() != null && a.this.bti().fFc != null && a.this.bti().fFc.DN() != null && a.this.bti().fFc.DN().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.bti().fFc.DN().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.bti().fFc.DN().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.bti().fFc.DN().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.Cr());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.aPT != null) {
                        a.this.aPT.bF(false);
                    }
                } else if (i == 12) {
                    if (a.this.fwS != null) {
                        String valueOf = String.valueOf(a.this.bti().fFc.DN().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.bti().fFc.DN().mLiveInfo.room_id);
                        String str3 = null;
                        com.baidu.live.data.l lVar = a.this.bti().fFc.DN().mLiveSdkInfo;
                        if (lVar != null && lVar.mCastIds != null) {
                            str3 = String.valueOf(a.this.bti().fFc.DN().mLiveSdkInfo.mCastIds.aqq);
                        }
                        a.this.fwS.ac(valueOf, valueOf2, str3);
                        if (com.baidu.live.liveroom.a.Dl().Dm()) {
                            a.this.bsk();
                        }
                    }
                } else if (i == 14) {
                    com.baidu.live.data.n DN = a.this.bti().fFc.DN();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.bti().pageContext.getPageActivity(), DN.aqe.userName, Long.toString(DN.aqe.userId), Long.toString(DN.aqe.charmCount), String.valueOf(DN.mLiveInfo.group_id), String.valueOf(DN.mLiveInfo.live_id), false, String.valueOf(DN.aqe.userId), Long.toString(DN.aqx.userId), DN.aqx.userName, DN.aqx.portrait, a.this.fvZ.getCount(), a.this.Cr())));
                    LogManager.getCommonLogger().doClickGusetNumLog(DN.mLiveInfo.feed_id, a.this.fvZ.getCount() + "", a.this.Cr());
                } else if (i == 11) {
                    a.this.bsN();
                    a.this.bsO();
                } else if (i == 15) {
                    if (a.this.fxg != null && a.this.bti() != null && a.this.bti().fFc != null && a.this.bti().fFc.DN() != null && a.this.bti().fFc.DN().mLiveInfo != null) {
                        long j = a.this.bti().fFc.DN().mLiveInfo.live_id;
                        String valueOf3 = String.valueOf(a.this.bti().fFc.DN().mLiveInfo.feed_id);
                        long j2 = a.this.bti().fFc.DN().mLiveInfo.room_id;
                        String str4 = a.this.bti().fFc.DN().mLiveInfo.cover;
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        String str8 = "";
                        if (a.this.bti().fFc.DN().mLiveInfo.session_info != null) {
                            str5 = a.this.bti().fFc.DN().mLiveInfo.session_info.flvUrl;
                        }
                        if (!TextUtils.isEmpty(a.this.Cr())) {
                            try {
                                JSONObject jSONObject = new JSONObject(a.this.Cr());
                                str6 = jSONObject.optString("tab");
                                str7 = jSONObject.optString("tag");
                                str8 = jSONObject.optString("source");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        a.this.fxg.AB(o.a(valueOf3, j + "", j2, false, 1, str4, str5, str6, str7, str8, String.valueOf(a.this.bti().fFc.DN().mLiveInfo.user_id), a.this.bti().fFc.DN().mLiveInfo.user_name, String.valueOf(a.this.bti().fFc.DN().mLiveInfo.group_id), String.valueOf(a.this.bti().fFc.DN().aqe.userId)));
                        o.aXR = j;
                        if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                            ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                            LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf3, a.this.Cr());
                        }
                    }
                } else if (i == 16) {
                    if (a.this.bti() != null && (asVar2 = com.baidu.live.v.a.Eo().aRw) != null && (bbVar2 = asVar2.avu) != null) {
                        String str9 = bbVar2.awq.aww;
                        if (!TextUtils.isEmpty(str9)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "quick_gift"));
                            long j3 = 0;
                            if (a.this.bti().fFc != null && a.this.bti().fFc.DN() != null && a.this.bti().fFc.DN().mLiveInfo != null) {
                                j3 = a.this.bti().fFc.DN().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j3 + "", a.this.bti().fFc.DN().mLiveInfo.room_id + "", a.this.bti().fFc.DN().mLiveInfo.feed_id, a.this.Cr());
                            }
                            if (str9.contains("?")) {
                                str2 = str9 + "&liveId=" + j3;
                            } else {
                                str2 = str9 + "?liveId=" + j3;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.bti().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (a.this.bti() != null) {
                        com.baidu.live.data.n nVar = null;
                        if (a.this.bti().fFc != null) {
                            nVar = a.this.bti().fFc.DN();
                        }
                        if (nVar != null && nVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.t.a.bzZ().aQA != null) {
                            String str10 = com.baidu.tieba.ala.liveroom.t.a.bzZ().aQA.aqV;
                            if (!TextUtils.isEmpty(str10)) {
                                if (str10.contains("?")) {
                                    str = str10 + "&live_id=" + nVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str10 + "?live_id=" + nVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(a.this.bti().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17) {
                    if (a.this.zA() && a.this.bti() != null && (asVar = com.baidu.live.v.a.Eo().aRw) != null && (bbVar = asVar.avu) != null && (bhVar = bbVar.awr) != null && !TextUtils.isEmpty(bhVar.webUrl)) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "turntable"));
                        if (a.this.fxl != null && a.this.bti().fFc != null && a.this.bti().fFc.DN() != null) {
                            com.baidu.live.data.n DN2 = a.this.bti().fFc.DN();
                            a.this.fxl.a(bhVar.webUrl, DN2.mLiveInfo.live_id, DN2.aqx.userId, DN2.aqe.userId);
                            a.this.fwl.bS(false);
                            a.this.fwl.Fh();
                        }
                    }
                } else if (i == 18) {
                    if (a.this.fwn) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.fwn = !a.this.fwn;
                } else if (i == 19 && a.this.fwl != null) {
                    a.this.fwl.Fh();
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
        return false;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void k(com.baidu.live.data.n nVar) {
        super.k(nVar);
        g.bvx();
        this.fwn = false;
        if (this.fwQ != null) {
            this.fwQ.b(this.fwA);
        }
        if (this.fwl == null) {
            this.fwl = new com.baidu.live.tieba.e.b(bti().pageContext.getPageActivity());
            this.fwl.start();
        }
        this.fwl.bS(true);
        bti().pageContext.getPageActivity().setRequestedOrientation(-1);
        bti().fFd.setIsForceHandledTouch(false);
        bti().fFd.setSwipeClearEnable(true);
        bti().fFd.setOnLiveViewScrollListener(this.fwt);
        bti().fFd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.fwo.removeCallbacksAndMessages(null);
                a.this.jT(false);
                if (!a.this.fwm) {
                    a.this.fwo.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.fwm) {
                                a.this.jT(false);
                            }
                        }
                    }, 5000L);
                }
            }
        });
        if (this.fxu != null) {
            this.fxu.setVisibility(0);
        }
        brO();
        brR();
        bsc();
        bsA();
        bsd();
        brN();
        bsh();
        bse();
        jU(false);
        bsR();
        bsQ();
        brT();
        bsa();
        bsb();
        bsT();
        brL();
        bsj();
        bsl();
        jZ(true);
        brS();
        brZ();
        bsZ();
        brU();
        brV();
        brW();
        brX();
        bsm();
        bsY();
        if (this.fxl != null && this.fxl.bAh() == null) {
            this.fxl.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.19
                @Override // com.baidu.tieba.ala.liveroom.turntable.d.a
                public void onDismiss() {
                    a.this.fwl.bS(true);
                }
            });
        }
        MessageManager.getInstance().registerListener(this.fwu);
        MessageManager.getInstance().registerListener(this.fwv);
        MessageManager.getInstance().registerListener(this.fwx);
        MessageManager.getInstance().registerListener(this.fwy);
        MessageManager.getInstance().registerListener(this.fwz);
        MessageManager.getInstance().registerListener(this.fww);
        bsn();
        bsg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jT(boolean z) {
        View xa;
        if (bti() != null && bti().pageContext != null && bti().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(bti().pageContext.getPageActivity()) == 2 || z) {
                if (this.fwZ != null && (xa = this.fwZ.xa()) != null) {
                    if (this.fwm) {
                        xa.setVisibility(0);
                    } else {
                        xa.setVisibility(8);
                    }
                }
                if (this.fwm) {
                    if (this.fxu != null) {
                        this.fxu.setVisibility(0);
                    }
                    if (this.fxv != null) {
                        this.fxv.setVisibility(0);
                    }
                    if (this.fvT != null) {
                        this.fvT.setVisibility(0);
                    }
                    if (this.fvS != null) {
                        this.fvS.setVisibility(0);
                    }
                    if (this.fwY != null) {
                        this.fwY.aX(false);
                    }
                } else {
                    if (this.fxu != null) {
                        this.fxu.setVisibility(8);
                    }
                    if (this.fxv != null) {
                        this.fxv.setVisibility(8);
                    }
                    if (this.fvT != null) {
                        this.fvT.setVisibility(8);
                    }
                    if (this.fvS != null) {
                        this.fvS.setVisibility(8);
                    }
                    if (this.fwY != null) {
                        this.fwY.aX(true);
                    }
                }
                this.fwm = this.fwm ? false : true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, boolean z2) {
        ImageView imageView;
        View wJ;
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view;
        }
        if (z) {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_off);
            }
            if (this.fwj != null) {
                this.fwj.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_on);
            }
            if (this.fwj != null) {
                this.fwj.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.fwY != null && (wJ = this.fwY.wJ()) != null) {
            if (z) {
                wJ.setVisibility(8);
            } else {
                wJ.setVisibility(0);
            }
        }
    }

    private void brL() {
        CustomResponsedMessage runTask;
        if (this.fwg == null && (runTask = MessageManager.getInstance().runTask(2913164, l.class, bti().pageContext)) != null) {
            this.fwg = (l) runTask.getData();
        }
        if (this.fwg != null) {
            this.fwg.setOtherParams(this.otherParams);
            this.fwg.a(new l.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.20
                @Override // com.baidu.live.im.l.a
                public void Bo() {
                    a.this.bsW();
                }
            });
        }
    }

    private void brM() {
        if (this.fwR != null) {
            this.fwR.ak(bti().fFb.getLiveContainerView());
        }
    }

    private void brN() {
        if (this.fwh == null) {
            this.fwh = new com.baidu.tieba.ala.liveroom.share.b(bti().pageContext);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bx(int i) {
        super.bx(i);
        if (this.fwk != null && UtilHelper.getRealScreenOrientation(bti().pageContext.getPageActivity()) != 2) {
            this.fwk.setVisibility(0);
        }
        brM();
        if (this.fwe != null) {
            this.fwe.bx(i);
        }
        if (this.fwe == null || !this.fwe.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void jU(boolean z) {
        super.jU(z);
        this.fwY.bE(bti().fFc.DN().mLiveInfo.screen_direction);
    }

    private void brO() {
        if (this.fvS == null) {
            this.fvS = new PriorityVerticalLinearLayout(bti().pageContext.getPageActivity());
            this.fvS.setDefaultItemMargin(bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            brQ();
        }
        if (this.fvS.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, brP());
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            layoutParams.rightMargin = bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
            layoutParams.bottomMargin = bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
            bti().fFd.addView(this.fvS, layoutParams);
        }
    }

    private int brP() {
        int bottom;
        int bottom2;
        if (bti().aPW.getLivePlayer().getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bti().aPW.getLivePlayer().getLayoutParams();
            bottom = layoutParams.topMargin + layoutParams.height;
        } else {
            bottom = bti().aPW.getLivePlayer().getBottom();
        }
        if (bti().fFd.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) bti().fFd.getLayoutParams();
            bottom2 = layoutParams2.topMargin + layoutParams2.height;
        } else {
            bottom2 = bti().fFd.getBottom();
        }
        return ((bottom2 - bottom) - bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
    }

    private void brQ() {
        View view = new View(bti().pageContext.getPageActivity());
        view.setTag(a.g.sdk_pvl_layout_priority_tag_key, 20);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(1, 0);
        layoutParams.weight = 1.0f;
        this.fvS.addView(view, layoutParams);
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
            layoutParams.topMargin = bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds228);
            layoutParams.leftMargin = bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bti().fFd.addView(this.fvT, layoutParams);
        }
    }

    private void brS() {
        if (this.fwb == null) {
            this.fwb = new com.baidu.tieba.ala.liveroom.activeview.b(bti().pageContext);
        }
        this.fwb.setOtherParams(Cr());
        this.fwb.b(bti().fFc.DN(), true);
        this.fwb.setHost(false);
        this.fwb.a(1, this.fvS, qm(1));
        this.fwb.a(2, this.fvS, qm(2));
        this.fwb.setVisible(this.fxy ? 8 : 0);
    }

    private void brT() {
        if (this.fwP != null && bti() != null && bti().fFc != null) {
            this.fwP.b(this.fxu, bti().fFc.DN());
        }
    }

    private ViewGroup.LayoutParams qm(int i) {
        switch (i) {
            case 1:
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = bti().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds40);
                return layoutParams;
            case 2:
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 5;
                layoutParams2.topMargin = bti().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                return layoutParams2;
            default:
                return new RelativeLayout.LayoutParams(-1, -2);
        }
    }

    private void brU() {
        if (this.fvS != null) {
            if (this.fwa == null) {
                this.fwa = new com.baidu.tieba.ala.liveroom.j.a(bti().pageContext, this);
            }
            this.fwa.setOtherParams(Cr());
            this.fwa.d(this.fvS, brY());
            this.fwa.s(bti().fFc.DN());
        }
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
            this.fvY.a(new a.InterfaceC0500a() { // from class: com.baidu.tieba.ala.liveroom.c.a.5
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0500a
                public void br(int i, int i2) {
                    com.baidu.live.data.n DN = a.this.bti().fFc.DN();
                    if (DN != null && DN.mLiveInfo != null) {
                        if (a.this.fxm == null) {
                            a.this.fxm = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.bti().pageContext.getPageActivity());
                        }
                        a.this.fxm.d(a.this.fxv, i, i2);
                        a.this.fxm.a(String.valueOf(DN.mLiveInfo.live_id), new a.InterfaceC0503a() { // from class: com.baidu.tieba.ala.liveroom.c.a.5.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0503a
                            public void a(float f, String str) {
                                if (a.this.fvY != null) {
                                    a.this.fvY.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0500a
                public void bs(int i, int i2) {
                    if (a.this.fxm != null) {
                        a.this.fxm.bx(i, i2);
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
        this.fxJ.a(bti().fFc.DN(), this.fvS);
        if (this.fwq == null) {
            this.fwq = new com.baidu.tieba.ala.liveroom.h.b(bti().pageContext, Cr(), this.fxJ, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.6
                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void bsw() {
                    a.this.jY(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void bsx() {
                    a.this.jY(false);
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
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = bti().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brZ() {
        if (this.fvY == null) {
            bse();
        }
        this.fvY.a(com.baidu.live.v.c.Et().aRE, bti().fFc.DN());
    }

    private void bsa() {
        CustomResponsedMessage runTask;
        if (this.fwW == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, bti().pageContext)) != null && runTask.getData() != null) {
            this.fwW = (k) runTask.getData();
            this.fwW.setFromMaster(false);
            this.fwW.Bf().getView().setId(a.g.ala_liveroom_msg_list);
            this.fwW.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.7
                @Override // com.baidu.live.im.k.a
                public boolean Bh() {
                    return a.this.zA();
                }

                @Override // com.baidu.live.im.k.a
                public void Bi() {
                    a.this.fxC = true;
                }

                @Override // com.baidu.live.im.k.a
                public void eE(String str) {
                    if (!a.this.fxy) {
                        a.this.jW(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.bti().pageContext.getPageActivity(), a.this.bti().fFb.getLiveContainerView());
                    }
                    a.this.Ay(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Bj() {
                    if (a.this.fxy) {
                        a.this.jW(true);
                        a.this.bti().fFb.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.bti().pageContext.getPageActivity(), a.this.bti().fFb.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (a.this.fwW != null) {
                        a.this.fwW.Bg().setQuickInputPanelVisible(false);
                        a.this.fwW.Bg().CO();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Bk() {
                    if (a.this.fxy) {
                        a.this.bsv();
                        if (a.this.fwX != null) {
                            a.this.fwX.Bn();
                        }
                        if (a.this.fwg != null) {
                            a.this.fwg.Bn();
                        }
                    } else if (a.this.fwW != null) {
                        a.this.fwW.Bg().setQuickInputPanelVisible(false);
                        a.this.fwW.Bg().CO();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Bl() {
                    return a.this.bsF();
                }
            });
            this.fwi = new FrameLayout(bti().pageContext.getPageActivity());
            this.fwi.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.fwW != null && this.fwi != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bti().pageContext.getPageActivity()) * 0.75f);
            int dimensionPixelSize = bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds120) + ((int) (BdUtilHelper.getEquipmentHeight(bti().pageContext.getPageActivity()) * 0.33f));
            if (this.fxv.indexOfChild(this.fwi) < 0) {
                if (this.fwi.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fwi.getParent()).removeView(this.fwi);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                this.fxv.addView(this.fwi, layoutParams);
            }
            if (this.fwi.indexOfChild(this.fwW.Bf().getView()) < 0) {
                if (this.fwW.Bf().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fwW.Bf().getView()).removeView(this.fwW.Bf().getView());
                }
                if (UtilHelper.getRealScreenOrientation(bti().pageContext.getPageActivity()) != 2) {
                    this.fwi.addView(this.fwW.Bf().getView(), new FrameLayout.LayoutParams(equipmentWidth, dimensionPixelSize));
                }
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

    private void bsb() {
        if (this.fwj == null) {
            this.fwj = new FrameLayout(bti().pageContext.getPageActivity());
            this.fwj.setId(a.g.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void bsc() {
        if (this.fvV == null) {
            this.fvV = new com.baidu.tieba.ala.liveroom.l.a(bti().pageContext, false, this);
        }
        this.fvV.c(this.fxu, bti().fFc.DN());
        this.fvV.a(this.fwA);
    }

    private void bsd() {
        if (this.fvU == null) {
            this.fvU = new com.baidu.tieba.ala.liveroom.audiencelist.c(bti().pageContext, this, false);
        }
        this.fvU.a(String.valueOf(bti().fFc.DN().mLiveInfo.group_id), String.valueOf(bti().fFc.DN().mLiveInfo.live_id), String.valueOf(bti().fFc.DN().aqe.userId), bti().fFc.DN());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.fwK != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.fvU.c(this.fxu, i, a.g.ala_liveroom_audience_count_layout);
            this.fvU.e(bti().fFc.bnr());
        }
    }

    private void bse() {
        if (this.fvY == null) {
            this.fvY = new com.baidu.tieba.ala.liveroom.operation.a(bti().pageContext);
        }
        this.fvY.a(bti(), this.fxv, bti().fFc.DN().mLiveInfo.live_type, true, this.fwA);
        this.fvY.setOtherParams(Cr());
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
    public void bsk() {
        String str;
        if (bti() != null && bti().fFc != null && bti().fFc.DN() != null && bti().fFc.DN().aqx != null && (str = bti().fFc.DN().aqx.userName) != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bti().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !bsE()) {
            com.baidu.live.c.tH().putInt("guide_rename_show_count", com.baidu.live.c.tH().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.Dl().bE(true);
            if (this.fxp == null) {
                this.fxp = new com.baidu.tieba.ala.liveroom.s.a(bti().pageContext);
            }
            this.fxp.setOtherParams(Cr());
            this.fxp.e(this.fxv, bti().fFc.DN());
            jY(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fxp.bzQ();
                    a.this.jY(false);
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
        if (this.fwS == null) {
            this.fwS = new com.baidu.tieba.ala.liveroom.v.a(bti().pageContext, this);
        }
        this.fwS.d(bti().fFd, false);
        this.fwS.kW(bth());
    }

    private void bsm() {
        if (bti() != null && bti().aPW != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(bti().pageContext.getPageActivity());
            Activity pageActivity = bti().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + pageActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds176)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.fwk = new ImageView(bti().pageContext.getPageActivity());
            this.fwk.setVisibility(8);
            this.fwk.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.fwk.setImageResource(a.f.icon_live_enlarge);
            this.fwk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.fwl != null) {
                        a.this.fwl.Fg();
                        a.this.fwk.setVisibility(4);
                    }
                }
            });
            bti().fFd.addView(this.fwk, layoutParams);
            if (UtilHelper.getRealScreenOrientation(bti().pageContext.getPageActivity()) != 2) {
                if (bti().fFi) {
                    this.fwk.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.12
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.fwk != null && UtilHelper.getRealScreenOrientation(a.this.bti().pageContext.getPageActivity()) != 2) {
                                a.this.fwk.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
        }
    }

    private void bsn() {
        if (this.fxC || this.fxD) {
            if ((TbadkCoreApplication.isLogin() && this.fwW.Bg().hasText()) || this.fxD) {
                this.fxC = false;
                this.fxD = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bsK();
                    }
                }, 500L);
            }
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
            e.printStackTrace();
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
        if (this.fwg != null) {
            this.fwg.a(nVar);
        }
        if (this.fwb != null) {
            this.fwb.h(nVar);
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
        if (this.fvS != null) {
            this.fvS.removeAllViews();
            this.fvS = null;
        }
        if (this.fvT != null) {
            this.fvT.removeAllViews();
            this.fvT = null;
        }
        if (this.fwd != null) {
            this.fwd.ug();
        }
        if (this.fwg != null) {
            this.fwg.a((l.a) null);
            this.fwg.AK();
        }
        if (this.fwk != null && (this.fwk.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fwk.getParent()).removeView(this.fwk);
        }
        if (this.fwh != null) {
            this.fwh.dismiss();
        }
        if (this.fwl != null) {
            this.fwl.bS(false);
            this.fwl.Fh();
        }
        if (this.fwq != null) {
            this.fwq.ug();
        }
        if (this.fxJ != null) {
            this.fxJ.btY();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void l(com.baidu.live.data.n nVar) {
        View Bm;
        super.l(nVar);
        if (this.fwg != null && (Bm = this.fwg.Bm()) != null && Bm.getParent() != null) {
            ((ViewGroup) Bm.getParent()).removeView(Bm);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.fwg != null) {
            this.fwg.setOtherParams(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void bI(boolean z) {
        super.bI(z);
        this.fwo.removeCallbacksAndMessages(null);
        bso();
        this.fwm = false;
        this.fwn = false;
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
        if (this.fwh != null) {
            this.fwh.onDestroy();
        }
        if (this.fvW != null) {
            this.fvW.onDestroy();
        }
        if (this.fwl != null) {
            this.fwl.stop();
        }
        if (this.fwS != null) {
            this.fwS.onDestroy();
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
        if (this.fwg != null) {
            this.fwg.a((l.a) null);
            this.fwg.release();
            this.fwg = null;
        }
        if (this.fxJ != null) {
            this.fxJ.bI(z ? false : true);
        }
        if (this.fwq != null) {
            this.fwq.onDestroy();
            this.fwq = null;
        }
        MessageManager.getInstance().removeMessageRule(this.fwr);
        MessageManager.getInstance().removeMessageRule(this.fws);
        MessageManager.getInstance().unRegisterListener(this.fwu);
        MessageManager.getInstance().unRegisterListener(this.fwv);
        MessageManager.getInstance().unRegisterListener(this.fwx);
        MessageManager.getInstance().unRegisterListener(this.fwy);
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
        if (this.fwj != null && this.fwj.getParent() != null) {
            ((ViewGroup) this.fwj.getParent()).removeView(this.fwj);
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
        return this.fvS;
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
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.fxy;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(bti().pageContext.getPageActivity()) || z2) {
            jV(z);
        }
    }

    private void jV(boolean z) {
        int dimensionPixelSize;
        if (this.fwW != null && this.fwW.Bf() != null) {
            this.fwW.Bf().onKeyboardVisibilityChanged(z);
        }
        if (z || this.fwW == null || !this.fwW.Bg().CN()) {
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
                int equipmentHeight = (int) ((z ? 0.2f : 0.33f) * BdUtilHelper.getEquipmentHeight(bti().pageContext.getPageActivity()));
                if (z) {
                    dimensionPixelSize = equipmentHeight + bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64);
                } else {
                    dimensionPixelSize = equipmentHeight + bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
                }
                if (this.fxv.indexOfChild(this.fwi) != -1 && this.fwi.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fwi.getLayoutParams();
                    layoutParams2.height = dimensionPixelSize;
                    this.fwi.setLayoutParams(layoutParams2);
                }
                if (this.fwi.indexOfChild(this.fwW.Bf().getView()) != -1 && this.fwW.Bf().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.fwW.Bf().getView().getLayoutParams();
                    layoutParams3.height = dimensionPixelSize;
                    this.fwW.Bf().getView().setLayoutParams(layoutParams3);
                }
                this.fwW.Bf().Be();
            }
        }
    }

    private void bsu() {
        if (this.fvY != null) {
            this.fvY.setVisibility(0);
        }
        if (this.fwi != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fwi.getLayoutParams();
            layoutParams.bottomMargin = bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
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
        if (this.fxu != null && (!this.fwm || UtilHelper.getRealScreenOrientation(bti().pageContext.getPageActivity()) != 2)) {
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
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        RelativeLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = bti().pageContext.getPageActivity();
        if (i3 == 1) {
            if (this.fxu != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.fxu.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.fwh != null) {
                this.fwh.dismiss();
            }
            if (this.fwg != null) {
                this.fwg.a((l.a) null);
                this.fwg.AK();
            }
            if (this.aPT != null) {
                this.aPT.e(true, true);
            }
            if (this.fwk != null) {
                this.fwk.setVisibility(0);
                this.fwk.bringToFront();
            }
            if (this.fwO != null) {
                this.fwO.setVisibility(0);
            }
            if (this.fwW != null && this.fwW.Bf().getView().getParent() != null && (this.fwW.Bf().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.fwW.Bf().getView().getParent()).removeView(this.fwW.Bf().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bti().pageContext.getPageActivity()) * 0.75f);
            int equipmentHeight = ((int) (BdUtilHelper.getEquipmentHeight(bti().pageContext.getPageActivity()) * 0.33f)) + bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
            if (this.fwi != null && this.fwW != null) {
                this.fwi.addView(this.fwW.Bf().getView(), new FrameLayout.LayoutParams(equipmentWidth, equipmentHeight));
            }
            if (this.fwj != null && (this.fwj.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.fwj.getParent()).removeView(this.fwj);
            }
            if (this.fwX != null) {
                this.fwX.a(bti().fFc.DN(), false);
                this.fwX.a(new l.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.14
                    @Override // com.baidu.live.im.l.a
                    public void Bo() {
                        a.this.bsW();
                    }
                });
                View Bm = this.fwX.Bm();
                if (Bm != null && this.fxv != null && Bm.getParent() == null) {
                    Resources resources = bti().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bti().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds98));
                    layoutParams5.addRule(2, a.g.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                    this.fxv.addView(Bm, layoutParams5);
                }
            }
            if (this.fwQ != null) {
                this.fwQ.setPraiseEnable(true);
                bti().fFd.fSe = true;
            }
            if (this.fvU != null && this.fvU.fyF != null && (layoutParams3 = (RelativeLayout.LayoutParams) this.fvU.fyF.getLayoutParams()) != null) {
                this.fvU.fyF.setPadding(0, 0, 0, 0);
                this.fvU.fyF.setLayoutParams(layoutParams3);
            }
            if (this.fwS != null) {
                this.fwS.bBe();
            }
            if (this.fwm) {
                jT(true);
            }
            if (this.fwn) {
                if (this.fvY != null && this.fvY.getLandscapeBarrageImageView() != null) {
                    b(this.fvY.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.fvZ != null) {
                this.fvZ.kk(true);
            }
            this.fwo.removeCallbacksAndMessages(null);
            if (this.fwa != null) {
                this.fwa.setCanVisible(true);
                this.fwa.s(bti().fFc.DN());
            }
        } else if (i3 == 2) {
            if (this.fwS != null) {
                this.fwS.bBf();
            }
            if (this.fxu != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.fxu.getLayoutParams()) != null) {
                layoutParams2.topMargin = bti().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
            }
            if (this.fwX != null) {
                this.fwX.a((l.a) null);
                this.fwX.AK();
            }
            bti().fFd.bAI();
            if (this.aPT != null) {
                this.aPT.e(false, true);
            }
            if (this.fwk != null) {
                this.fwk.setVisibility(4);
            }
            if (this.fwW != null && this.fwW.Bf().getView().getParent() != null && (this.fwW.Bf().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.fwW.Bf().getView().getParent()).removeView(this.fwW.Bf().getView());
            }
            int max = Math.max(i, i2);
            if (this.fwj != null) {
                if (this.fwj.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fwj.getParent()).removeView(this.fwj);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
                bti().fFd.addView(this.fwj, layoutParams6);
            }
            if (this.fwj != null && this.fwg != null) {
                this.fwg.a(bti().fFc.DN(), false);
                this.fwg.a(new l.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.15
                    @Override // com.baidu.live.im.l.a
                    public void Bo() {
                        a.this.bsW();
                    }
                });
                View Bm2 = this.fwg.Bm();
                if (Bm2 != null && this.fwj.indexOfChild(Bm2) < 0) {
                    this.fwj.addView(Bm2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bti().pageContext.getPageActivity()), -1));
                }
            }
            if (this.fwQ != null) {
                this.fwQ.an(bti().fFd);
                this.fwQ.setPraiseEnable(false);
                bti().fFd.fSe = false;
            }
            if (this.fvU != null && this.fvU.fyF != null && (layoutParams = (RelativeLayout.LayoutParams) this.fvU.fyF.getLayoutParams()) != null) {
                int width = this.fvU.fyF.getWidth();
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                this.fvU.fyF.setPadding(width - ((int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f)), 0, 0, 0);
                this.fvU.fyF.setLayoutParams(layoutParams);
            }
            if (this.fvZ != null) {
                this.fvZ.kk(false);
            }
            if (ab.xm() != null) {
                ab.xm().xl();
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.x.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.x.c) runTask.getData()).xl();
            }
            if (this.fvY != null && this.fvY.getLandscapeBarrageImageView() != null) {
                b(this.fvY.getLandscapeBarrageImageView(), this.fwn, false);
            }
            this.fwo.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.16
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.fwm) {
                        a.this.jT(false);
                    }
                }
            }, 5000L);
            if (this.fwY != null) {
                this.fwY.wL();
            }
            if (this.fwa != null) {
                this.fwa.setCanVisible(false);
                this.fwa.bvD();
            }
        }
        if (this.fwZ != null) {
            if (i3 == 2) {
                View xa = this.fwZ.xa();
                if (xa != null) {
                    if (xa.getParent() != null && (xa.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) xa.getParent()).removeView(xa);
                    }
                    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams7.addRule(5, a.g.ala_liveroom_hostheader);
                    layoutParams7.addRule(3, a.g.ala_liveroom_hostheader);
                    layoutParams7.topMargin = bti().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                    if (this.fxu != null) {
                        this.fxu.addView(xa, layoutParams7);
                    }
                }
            } else {
                View xa2 = this.fwZ.xa();
                if (xa2 != null) {
                    if (xa2.getParent() != null && (xa2.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) xa2.getParent()).removeView(xa2);
                    }
                    RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams8.topMargin = bti().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds4);
                    layoutParams8.addRule(3, a.g.ala_live_header_view);
                    bti().fFd.addView(xa2, layoutParams8);
                }
            }
        }
        if (this.fvY != null) {
            this.fvY.l(i, i2, i3);
        }
        qo(i3);
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.fvU != null) {
                this.fvU.cl(i3);
            }
            if (this.fvW != null) {
                this.fvW.cl(i3);
            }
            if (this.fwb != null) {
                this.fwb.cl(i3);
            }
            if (this.fxc != null) {
                this.fxc.cl(i3);
            }
            if (this.fxl != null) {
                this.fxl.cl(i3);
            }
            if (this.fwp != null && this.fwp.isShowing()) {
                this.fwp.resize();
            }
            if (this.fxt != null) {
                this.fxt.cl(i3);
            }
        }
        if (this.fwY != null) {
            this.fwY.wK();
        }
        super.l(i, i2, i3);
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
            if (i != 7 || UtilHelper.getRealScreenOrientation(bti().pageContext.getPageActivity()) != 2) {
                if (this.fvY != null) {
                    this.fvY.setVisibility(8);
                }
                if (this.fwW != null) {
                    this.fwW.Bf().getView().setVisibility(4);
                }
                if (this.fxm != null) {
                    this.fxm.kS(false);
                }
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
            if (this.fxm != null) {
                this.fxm.kS(true);
            }
            if (!this.fwm || UtilHelper.getRealScreenOrientation(bti().pageContext.getPageActivity()) != 2) {
                this.fxu.setVisibility(0);
            }
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
        if (bti() != null) {
            BdUtilHelper.hideSoftKeyPad(bti().pageContext.getPageActivity(), bti().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.fvX != null) {
            this.fvX.bzN();
        }
        if (this.fwd != null) {
            this.fwd.ur();
        }
        if (this.fwb != null) {
            this.fwb.onStart();
        }
    }

    private void qo(int i) {
        if (this.fvS != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fvS.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.bottomMargin = bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
                layoutParams.height = brP();
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds72) + 0 + bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds22) + bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                layoutParams.rightMargin = bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
                layoutParams.height = -2;
            }
            this.fvS.setLayoutParams(layoutParams);
        }
    }
}
