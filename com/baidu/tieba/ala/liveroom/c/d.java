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
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
import com.baidu.live.data.ad;
import com.baidu.live.data.ae;
import com.baidu.live.data.ap;
import com.baidu.live.data.ay;
import com.baidu.live.data.be;
import com.baidu.live.data.h;
import com.baidu.live.data.m;
import com.baidu.live.gift.n;
import com.baidu.live.gift.x;
import com.baidu.live.guardclub.e;
import com.baidu.live.im.i;
import com.baidu.live.im.k;
import com.baidu.live.message.GetQuickGiftHttpResponseMessage;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
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
    private boolean ePU;
    private LinearLayout eQN;
    private com.baidu.tieba.ala.liveroom.audiencelist.c eQO;
    private com.baidu.tieba.ala.liveroom.l.a eQP;
    private com.baidu.tieba.ala.liveroom.e.b eQQ;
    private com.baidu.tieba.ala.liveroom.r.b eQR;
    private com.baidu.tieba.ala.liveroom.operation.a eQS;
    private com.baidu.tieba.ala.liveroom.audiencelist.b eQT;
    private com.baidu.tieba.ala.liveroom.j.a eQU;
    private com.baidu.tieba.ala.liveroom.activeview.b eQV;
    private com.baidu.live.d.a eQW;
    private j eQX;
    private i eQY;
    private com.baidu.tieba.ala.liveroom.attentionpop.b eQZ;
    private FrameLayout eRc;
    private com.baidu.tieba.ala.liveroom.h.b eRk;
    private DispatchedPvlLayout eTb;
    private View eTc;
    private DispatchedRelativeLayout eTd;
    private f eTe;
    private long lastClickTime = 0;
    private boolean eTf = false;
    private HttpRule eRl = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.eQX != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.eQX.qa()) {
                httpMessage.addParam("ala_challenge_id", d.this.eQX.qd());
            }
            return httpMessage;
        }
    };
    private HttpRule eRm = new HttpRule(1021151) { // from class: com.baidu.tieba.ala.liveroom.c.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.eQX != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.eQX.qa()) {
                httpMessage.addParam("challenge_id", d.this.eQX.qd());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c eRn = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.c.d.17
        @Override // com.baidu.live.liveroom.g.c
        public void yL() {
            if (d.this.eRM != null) {
                d.this.eRM.jR(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bg(boolean z) {
            if (z) {
                if (d.this.eQS != null) {
                    d.this.eQS.qz(8);
                }
                if (d.this.eRM != null) {
                    d.this.eRM.jR(true);
                }
            } else {
                if (d.this.eQS != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                        d.this.eQS.qz(0);
                    } else {
                        d.this.eQS.qz(8);
                    }
                }
                if (d.this.eRM != null) {
                    d.this.eRM.jR(false);
                }
            }
            if (d.this.eSd != null) {
                d.this.eSd.aB(z);
            }
        }
    };
    private HttpMessageListener eRo = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.d.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.yV() != null) {
                        com.baidu.live.v.c.zo().axL = getQuickGiftHttpResponseMessage.yV();
                        d.this.biz();
                    }
                }
            }
        }
    };
    private CustomMessageListener eRp = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.d.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.biI();
        }
    };
    CustomMessageListener eRt = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.c.d.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.eRk.c(d.this.bjG());
                } else if (d.this.bjc() || !g.qa(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, 3000L);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.bjG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.bjG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    d.this.eRk.b(d.this.eRc, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener eTg = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.c.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.bjc() || !g.qa(2913128)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.21.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.pY(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, 3000L);
                } else {
                    d.this.yP(str);
                }
            }
        }
    };
    private CustomMessageListener eTh = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.c.d.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.eRT.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eRq = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.c.d.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.this.eSh != null) {
                    d.this.eSh.yR(str);
                }
            }
        }
    };
    CustomMessageListener eRr = new CustomMessageListener(CmdConfigCustom.CMD_HOST_GET_WALLET_UA) { // from class: com.baidu.tieba.ala.liveroom.c.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.eSv != null && d.this.eSv.apX != null && !d.this.eSv.aqa && !d.this.eSv.aqb && d.this.eSc != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.bjG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = d.this.bjG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                d.this.eSc.b(d.this.eRc, layoutParams);
                if (e.vG() != null) {
                    e.vG().vM();
                }
            }
        }
    };
    private CustomMessageListener eRs = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.eSf != null) {
                    d.this.eSf.dismiss();
                }
                if (d.this.eSh != null) {
                    d.this.eSh.dismiss();
                }
                k.wA().setSwitchStatus(true);
                k.wA().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bji();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b eRu = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.d.13
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void m(View view, int i) {
            ap apVar;
            ay ayVar;
            be beVar;
            ap apVar2;
            ay ayVar2;
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - d.this.lastClickTime >= 300) {
                d.this.lastClickTime = currentTimeMillis;
                if (i == 2) {
                    d.this.J(-1, -1, -1);
                } else if (i == 13) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.v.c.zo().axL.su().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.v.c.zo().axL.su().rx());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.v.c.zo().axL.su().ry());
                        if (d.this.bjG().fah.yN() != null && d.this.bjG().fah.yN().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.bjG().fah.yN().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.bjG().fah.yN().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.xx());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.uX()) {
                        if (com.baidu.live.c.pr().getBoolean("quick_gift_guide_show", true) && !d.this.bjc()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, x.class, d.this.bjG().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                x xVar = (x) runTask.getData();
                                xVar.setPageContext(d.this.bjG().pageContext);
                                xVar.d(d.this.bjG().fah.yN());
                                xVar.a(com.baidu.live.v.c.zo().axL.su());
                                xVar.setOtherParams(d.this.xx());
                                xVar.initView();
                                xVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.d.13.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        d.this.iV(false);
                                    }
                                });
                                xVar.show();
                                d.this.iV(true);
                                return;
                            }
                            return;
                        }
                        n.a(d.this.bjG().pageContext, d.this.bjG().fah.yN(), com.baidu.live.v.c.zo().axL.su(), d.this.xx());
                    }
                } else if (i == 1) {
                    if (d.this.eRQ != null) {
                        d.this.bji();
                    }
                } else if (i == 3 && d.this.uX()) {
                    d.this.eRF.c(d.this.bjG().fah.yN(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.bjG() != null && d.this.bjG().fah != null && d.this.bjG().fah.yN() != null && d.this.bjG().fah.yN().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.bjG().fah.yN().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.bjG().fah.yN().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.bjG().fah.yN().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.xx());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.bjG() != null && d.this.bjG().fah != null && d.this.bjG().fah.yN() != null && d.this.bjG().fah.yN().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.bjG().fah.yN().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.bjG().fah.yN().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.bjG().fah.yN().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.xx());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.awe != null) {
                        d.this.awe.bb(false);
                    }
                } else if (i == 12) {
                    if (d.this.eRM != null) {
                        String valueOf = String.valueOf(d.this.bjG().fah.yN().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.bjG().fah.yN().mLiveInfo.room_id);
                        String str2 = null;
                        com.baidu.live.data.k kVar = d.this.bjG().fah.yN().mLiveSdkInfo;
                        if (kVar != null && kVar.mCastIds != null) {
                            str2 = String.valueOf(d.this.bjG().fah.yN().mLiveSdkInfo.mCastIds.XX);
                        }
                        d.this.eRM.ad(valueOf, valueOf2, str2);
                        if (com.baidu.live.liveroom.a.ym().yn()) {
                            d.this.biI();
                        }
                    }
                } else if (i == 14) {
                    m yN = d.this.bjG().fah.yN();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.bjG().pageContext.getPageActivity(), yN.XQ.userName, Long.toString(yN.XQ.userId), Long.toString(yN.XQ.charmCount), String.valueOf(yN.mLiveInfo.group_id), String.valueOf(yN.mLiveInfo.live_id), false, String.valueOf(yN.XQ.userId), Long.toString(yN.Ye.userId), yN.Ye.userName, yN.Ye.portrait, d.this.eQT.getCount(), d.this.xx())));
                    LogManager.getCommonLogger().doClickGusetNumLog(yN.mLiveInfo.feed_id, d.this.eQT.getCount() + "", d.this.xx());
                } else if (i == 11) {
                    d.this.bjl();
                    d.this.bjm();
                } else if (i == 15) {
                    if (d.this.eSa != null && d.this.bjG() != null && d.this.bjG().fah != null && d.this.bjG().fah.yN() != null && d.this.bjG().fah.yN().mLiveInfo != null) {
                        long j = d.this.bjG().fah.yN().mLiveInfo.live_id;
                        String valueOf3 = String.valueOf(d.this.bjG().fah.yN().mLiveInfo.feed_id);
                        long j2 = d.this.bjG().fah.yN().mLiveInfo.room_id;
                        String str3 = d.this.bjG().fah.yN().mLiveInfo.cover;
                        String str4 = "";
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        if (d.this.bjG().fah.yN().mLiveInfo.session_info != null) {
                            str4 = d.this.bjG().fah.yN().mLiveInfo.session_info.flvUrl;
                        }
                        if (!TextUtils.isEmpty(d.this.xx())) {
                            try {
                                JSONObject jSONObject = new JSONObject(d.this.xx());
                                str5 = jSONObject.optString("tab");
                                str6 = jSONObject.optString("tag");
                                str7 = jSONObject.optString("source");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        d.this.eSa.yR(o.a(valueOf3, j + "", j2, false, 1, str3, str4, str5, str6, str7));
                        o.aDP = j;
                        if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                            ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                            LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf3, d.this.xx());
                        }
                    }
                } else if (i == 16) {
                    if (d.this.bjG() != null && (apVar2 = com.baidu.live.v.a.zj().axB) != null && (ayVar2 = apVar2.acS) != null) {
                        String str8 = ayVar2.adP.adW;
                        if (!TextUtils.isEmpty(str8)) {
                            long j3 = 0;
                            if (d.this.bjG().fah != null && d.this.bjG().fah.yN() != null && d.this.bjG().fah.yN().mLiveInfo != null) {
                                j3 = d.this.bjG().fah.yN().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j3 + "", d.this.bjG().fah.yN().mLiveInfo.room_id + "", d.this.bjG().fah.yN().mLiveInfo.feed_id, d.this.xx());
                            }
                            if (str8.contains("?")) {
                                str = str8 + "&liveId=" + j3;
                            } else {
                                str = str8 + "?liveId=" + j3;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.bjG().pageContext.getPageActivity(), str);
                        }
                    }
                } else if (i == 17 && d.this.uX() && d.this.bjG() != null && (apVar = com.baidu.live.v.a.zj().axB) != null && (ayVar = apVar.acS) != null && (beVar = ayVar.adQ) != null && !TextUtils.isEmpty(beVar.webUrl) && d.this.eSf != null && d.this.bjG().fah != null && d.this.bjG().fah.yN() != null) {
                    m yN2 = d.this.bjG().fah.yN();
                    d.this.eSf.a(beVar.webUrl, yN2.mLiveInfo.live_id, yN2.Ye.userId, yN2.XQ.userId);
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.eRH = new com.baidu.tieba.ala.liveroom.guide.c(bjG().pageContext, this, false);
        this.eRl.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.eRl);
        this.eRm.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.eRm);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean bik() {
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void k(m mVar) {
        super.k(mVar);
        g.blZ();
        this.eTf = true;
        bjG().fai.setIsForceHandledTouch(false);
        bjG().fai.setSwipeClearEnable(true);
        bjG().fai.setOnLiveViewScrollListener(this.eRn);
        if (this.eRK != null) {
            this.eRK.b(this.eRu);
        }
        if (this.eSo != null) {
            this.eSo.setVisibility(0);
        }
        bio();
        bir();
        biC();
        biY();
        biD();
        biF();
        biE();
        iR(false);
        bjp();
        bjo();
        bit();
        biA();
        bjr();
        biH();
        biJ();
        jd(true);
        bjQ();
        bjR();
        iW(false);
        bjx();
        bis();
        biz();
        biu();
        biv();
        biw();
        bix();
        jb(true);
        bjw();
        MessageManager.getInstance().registerListener(this.eRo);
        MessageManager.getInstance().registerListener(this.eRp);
        MessageManager.getInstance().registerListener(this.eTh);
        MessageManager.getInstance().registerListener(this.eRr);
        MessageManager.getInstance().registerListener(this.eRs);
        MessageManager.getInstance().registerListener(this.eTg);
        MessageManager.getInstance().registerListener(this.eRt);
        MessageManager.getInstance().registerListener(this.eRq);
        biL();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void i(m mVar) {
        super.i(mVar);
        if (this.eQP != null) {
            this.eQP.u(mVar);
        }
        if (this.eQQ != null) {
            this.eQQ.q(mVar);
        }
        if (this.eQU != null) {
            this.eQU.t(mVar);
        }
        if (this.eQY != null) {
            this.eQY.a(mVar);
        }
        jd(false);
        jb(false);
        if (this.eQV != null) {
            this.eQV.h(mVar);
            this.eQV.iN(this.eSy);
            this.eQV.updateView();
            if (mVar != null && this.eSm != null && !this.eSm.hasInit && !TextUtils.isEmpty(this.eSm.adm)) {
                this.eSm.hasInit = true;
                this.eQV.yL(this.eSm.adm);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(h hVar) {
        if (hVar != null) {
            if (this.eQO != null && hVar.getList() != null) {
                this.eQO.f(hVar);
            }
            if (this.eQT != null) {
                this.eQT.cD(hVar.getCount());
            }
        }
    }

    private void bim() {
        if (this.eRL != null) {
            this.eRL.ai(bjG().fag.getLiveContainerView());
        }
    }

    private void bjQ() {
        if (this.eQZ == null) {
            this.eQZ = new com.baidu.tieba.ala.liveroom.attentionpop.b(bjG().pageContext);
        }
        if (bjG().fah != null && bjG().fah.yN() != null && bjG().fah.yN().mLiveInfo != null) {
            this.eQZ.yM(String.valueOf(bjG().fah.yN().mLiveInfo.user_id));
        }
    }

    private void bjR() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (bjG() != null && bjG().fah != null && bjG().fah.yN() != null && bjG().fah.yN().mLiveInfo != null) {
                j = bjG().fah.yN().mLiveInfo.room_id;
            }
            if (this.eRY == null) {
                this.eRY = new com.baidu.tieba.ala.liveroom.guide.a(bjG().pageContext, j);
            }
            this.eRY.iU(this.eSr);
            this.eRY.a(new a.InterfaceC0459a() { // from class: com.baidu.tieba.ala.liveroom.c.d.4
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0459a
                public void bjV() {
                    if (d.this.awe != null) {
                        d.this.awe.bb(true);
                    }
                }
            });
            this.eRY.af(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bk(int i) {
        super.bk(i);
        bim();
        if (this.eQY != null) {
            this.eQY.bk(i);
        }
    }

    private void bio() {
        if (this.eTd == null) {
            this.eTd = new DispatchedRelativeLayout(bjG().pageContext.getPageActivity());
            this.eTd.setViewActionDispatched(false);
            this.eTd.setViewActionDispatchListener(new com.baidu.live.view.dispatch.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.5
                @Override // com.baidu.live.view.dispatch.a
                public boolean W(View view) {
                    return (d.this.eTb == null || d.this.eTb.Bs() || view == null || !(view.getTag(a.g.sdk_pvl_layout_priority_tag_key) instanceof Integer)) ? false : true;
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewAdded(View view) {
                    view.setTag(a.g.ala_live_room_vertival_widgets_bk_lp_key, view.getLayoutParams());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(view.getLayoutParams().width, view.getLayoutParams().height);
                    layoutParams.gravity = 5;
                    view.setLayoutParams(layoutParams);
                    d.this.eTb.addView(view);
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewRemoved(View view) {
                    d.this.eTb.removeView(view);
                }

                @Override // com.baidu.live.view.dispatch.a
                public void Bu() {
                    if (d.this.eTb != null && !d.this.eTb.Bs()) {
                        d.this.eTb.removeAllViews();
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public int indexOfChild(View view) {
                    return d.this.eTb.indexOfChild(view);
                }
            });
        }
        if (this.eTd.getParent() == null) {
            bjG().fai.addView(this.eTd, jg(false));
        }
        if (this.eTb == null) {
            this.eTb = new DispatchedPvlLayout(bjG().pageContext.getPageActivity());
            this.eTb.setDefaultItemMargin(bjG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.eTb.setViewActionDispatched(false);
            this.eTb.setViewActionDispatchListener(new com.baidu.live.view.dispatch.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.6
                @Override // com.baidu.live.view.dispatch.a
                public boolean W(View view) {
                    return (d.this.eTd == null || d.this.eTd.Bs() || view == null || !(view.getTag(a.g.ala_live_room_vertival_widgets_bk_lp_key) instanceof ViewGroup.LayoutParams)) ? false : true;
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewAdded(View view) {
                    view.setLayoutParams(new LinearLayout.LayoutParams(view.getLayoutParams().width, view.getLayoutParams().height));
                    d.this.eTd.addView(view, (ViewGroup.LayoutParams) view.getTag(a.g.ala_live_room_vertival_widgets_bk_lp_key));
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewRemoved(View view) {
                    d.this.eTd.removeView(view);
                }

                @Override // com.baidu.live.view.dispatch.a
                public void Bu() {
                    if (d.this.eTd != null && !d.this.eTd.Bs()) {
                        d.this.eTd.removeAllViews();
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public int indexOfChild(View view) {
                    return d.this.eTd.indexOfChild(view);
                }
            });
        }
        if (this.eTb.getParent() == null) {
            bjG().fai.addView(this.eTb, bjU());
        }
    }

    private void biq() {
        if (this.eTc == null) {
            this.eTc = new View(bjG().pageContext.getPageActivity());
            this.eTc.setTag(a.g.sdk_pvl_layout_priority_tag_key, 20);
        }
        if (this.eTc.getParent() == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(1, 0);
            layoutParams.weight = 1.0f;
            this.eTb.addView(this.eTc, layoutParams);
        }
    }

    private void bjS() {
        if (this.eTc != null) {
            this.eTb.removeView(this.eTc);
        }
    }

    private void bir() {
        if (this.eQN == null) {
            this.eQN = new LinearLayout(bjG().pageContext.getPageActivity());
            this.eQN.setOrientation(1);
        }
        if (this.eQN.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = bjG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds160);
            layoutParams.leftMargin = bjG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bjG().fai.addView(this.eQN, layoutParams);
        }
    }

    private void bit() {
        if (this.eRJ != null && bjG() != null && bjG().fah != null) {
            this.eRJ.b(this.eSo, bjG().fah.yN());
        }
    }

    private void bis() {
        if (this.eQV == null) {
            this.eQV = new com.baidu.tieba.ala.liveroom.activeview.b(bjG().pageContext);
        }
        this.eQV.iM(this.ePU);
        this.eQV.setOtherParams(xx());
        this.eQV.b(bjG().fah.yN(), false);
        this.eQV.setHost(false);
        this.eQV.iN(this.eSy);
        this.eQV.a(1, this.eQN, pQ(1));
        this.eQV.a(2, this.eTb, pQ(2));
        this.eQV.setVisible(this.eSs ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biz() {
        if (this.eQS == null) {
            biE();
        }
        this.eQS.setOtherParams(xx());
        this.eQS.a(com.baidu.live.v.c.zo().axL, bjG().fah.yN());
    }

    private ViewGroup.LayoutParams pQ(int i) {
        switch (i) {
            case 1:
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (this.eQN == null || this.eQN.getChildCount() == 0) {
                    return layoutParams;
                }
                layoutParams.topMargin = bjG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                return layoutParams;
            case 2:
                ViewGroup.LayoutParams layoutParams2 = this.eTd.getLayoutParams();
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(((int) (BdUtilHelper.getEquipmentWidth(bjG().pageContext.getPageActivity()) * 0.25f)) - ((layoutParams2 instanceof LinearLayout.LayoutParams ? ((LinearLayout.LayoutParams) layoutParams2).rightMargin : 0) * 2), -2);
                layoutParams3.gravity = 5;
                return layoutParams3;
            default:
                return new RelativeLayout.LayoutParams(-2, -2);
        }
    }

    private void biu() {
        if (this.eQU == null) {
            this.eQU = new com.baidu.tieba.ala.liveroom.j.a(bjG().pageContext, this);
        }
        this.eQU.setOtherParams(xx());
        this.eQU.d(this.eTd, biy());
        this.eQU.t(bjG().fah.yN());
    }

    private void biv() {
        if (this.eSc == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, com.baidu.live.guardclub.j.class, bjG().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.eSc = (com.baidu.live.guardclub.j) runTask.getData();
            } else {
                return;
            }
        }
        this.eSc.setOtherParams(xx());
        if (this.eRc != null && this.eRc.indexOfChild(this.eSc.getView()) >= 0) {
            this.eRc.removeView(this.eSc.getView());
        }
    }

    private void biw() {
        if (this.eQS != null) {
            this.eQS.a(new a.InterfaceC0465a() { // from class: com.baidu.tieba.ala.liveroom.c.d.7
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0465a
                public void bl(int i, int i2) {
                    m yN = d.this.bjG().fah.yN();
                    if (yN != null && yN.mLiveInfo != null) {
                        if (d.this.eSg == null) {
                            d.this.eSg = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.bjG().pageContext.getPageActivity());
                        }
                        d.this.eSg.d(d.this.eSp, i, i2);
                        d.this.eSg.a(String.valueOf(yN.mLiveInfo.live_id), new a.InterfaceC0467a() { // from class: com.baidu.tieba.ala.liveroom.c.d.7.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0467a
                            public void a(float f, String str) {
                                if (d.this.eQS != null) {
                                    d.this.eQS.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0465a
                public void bm(int i, int i2) {
                    if (d.this.eSg != null) {
                        d.this.eSg.br(i, i2);
                    }
                }
            });
        }
    }

    private void bix() {
        if (this.eSD == null) {
            this.eSD = new com.baidu.tieba.ala.liveroom.h.e(bjG().pageContext);
        }
        this.eSD.setRoomId(bjG().fah.yN().mLiveInfo.room_id);
        this.eSD.za("");
        this.eSD.a(bjG().fah.yN(), this.eTb);
        if (this.eRk == null) {
            this.eRk = new com.baidu.tieba.ala.liveroom.h.b(bjG().pageContext, xx(), this.eSD, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.8
                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void biU() {
                    d.this.iV(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void biV() {
                    d.this.iV(false);
                }
            });
        }
        this.eRk.setRoomId(bjG().fah.yN().mLiveInfo.room_id);
        if (this.eRc != null && this.eRc.indexOfChild(this.eRk.getView()) >= 0) {
            this.eRc.removeView(this.eRk.getView());
        }
        if (this.eRk != null) {
            this.eRk.b(bjG());
        }
    }

    private ViewGroup.LayoutParams biy() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.topMargin = (ScreenHelper.getRealScreenHeight(bjG().pageContext.getPageActivity()) - this.eTd.getTop()) - bjG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds814);
        return layoutParams;
    }

    private void biA() {
        CustomResponsedMessage runTask;
        if (this.eRQ == null && (runTask = MessageManager.getInstance().runTask(2913039, com.baidu.live.im.i.class, bjG().pageContext)) != null && runTask.getData() != null) {
            this.eRQ = (com.baidu.live.im.i) runTask.getData();
            this.eRQ.setFromMaster(false);
            this.eRQ.wq().getView().setId(a.g.ala_liveroom_msg_list);
            this.eRQ.a(new i.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.9
                @Override // com.baidu.live.im.i.a
                public boolean ws() {
                    return d.this.uX();
                }

                @Override // com.baidu.live.im.i.a
                public void wt() {
                    d.this.eSw = true;
                }

                @Override // com.baidu.live.im.i.a
                public void dM(String str) {
                    if (!d.this.eSs) {
                        d.this.iT(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.bjG().pageContext.getPageActivity(), d.this.bjG().fag.getLiveContainerView());
                    }
                    d.this.yO(str);
                }

                @Override // com.baidu.live.im.i.a
                public void wu() {
                    if (d.this.eSs) {
                        d.this.iT(true);
                        d.this.bjG().fag.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.bjG().pageContext.getPageActivity(), d.this.bjG().fag.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.eRQ != null) {
                        d.this.eRQ.wr().setQuickInputPanelVisible(false);
                        d.this.eRQ.wr().xR();
                    }
                }

                @Override // com.baidu.live.im.i.a
                public void wv() {
                    if (d.this.eSs) {
                        d.this.biT();
                        if (d.this.eRR != null) {
                            d.this.eRR.wy();
                        }
                    }
                }

                @Override // com.baidu.live.im.i.a
                public boolean ww() {
                    return d.this.bjd();
                }
            });
            this.eRc = new FrameLayout(bjG().pageContext.getPageActivity());
            this.eRc.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.eRQ != null && this.eRc != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bjG().pageContext.getPageActivity()) * 0.75f);
            int dimensionPixelSize = bjG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64) + ((int) (BdUtilHelper.getEquipmentHeight(bjG().pageContext.getPageActivity()) * 0.27f));
            if (this.eSp.indexOfChild(this.eRc) < 0) {
                if (this.eRc.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eRc.getParent()).removeView(this.eRc);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, bjG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds27) + dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bjG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
                this.eSp.addView(this.eRc, layoutParams);
            }
            if (this.eRc.indexOfChild(this.eRQ.wq().getView()) < 0) {
                if (this.eRQ.wq().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eRQ.wq().getView()).removeView(this.eRQ.wq().getView());
                }
                this.eRc.addView(this.eRQ.wq().getView(), new FrameLayout.LayoutParams(equipmentWidth, dimensionPixelSize));
            }
            if (bjG().fai.indexOfChild(this.eRQ.wr().getView()) < 0) {
                if (this.eRQ.wr().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eRQ.wr().getView().getParent()).removeView(this.eRQ.wr().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bjj();
                bjG().fai.addView(this.eRQ.wr().getView(), layoutParams2);
            }
            m yN = bjG().fah.yN();
            if (yN != null && yN.mLiveInfo != null) {
                this.eRQ.setLogData(yN.mLiveInfo.feed_id, xx());
            }
            this.eRQ.e(String.valueOf(bjG().fah.yN().mLiveInfo.group_id), String.valueOf(bjG().fah.yN().mLiveInfo.last_msg_id), String.valueOf(bjG().fah.yN().XQ.userId), String.valueOf(bjG().fah.yN().mLiveInfo.live_id), bjG().fah.yN().XQ.appId);
            iT(false);
        }
    }

    private void biC() {
        if (this.eQP == null) {
            this.eQP = new com.baidu.tieba.ala.liveroom.l.a(bjG().pageContext, false, this);
        }
        this.eQP.c(this.eSo, bjG().fah.yN());
        this.eQP.a(this.eRu);
        this.eQP.setOtherParams(xx());
    }

    private void biD() {
        if (this.eQO == null) {
            this.eQO = new com.baidu.tieba.ala.liveroom.audiencelist.c(bjG().pageContext, this, false);
        }
        this.eQO.a(String.valueOf(bjG().fah.yN().mLiveInfo.group_id), String.valueOf(bjG().fah.yN().mLiveInfo.live_id), String.valueOf(bjG().fah.yN().XQ.userId), bjG().fah.yN());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.eRE != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.eQO.c(this.eSo, i, a.g.ala_liveroom_audience_count_layout);
            this.eQO.f(bjG().fah.bdW());
            this.eQO.setOtherParams(xx());
        }
    }

    private void biE() {
        if (this.eQS == null) {
            this.eQS = new com.baidu.tieba.ala.liveroom.operation.a(bjG().pageContext);
        }
        this.eQS.a(bjG(), this.eSp, bjG().fah.yN().mLiveInfo.live_type, true, this.eRu);
        this.eQS.setOtherParams(xx());
    }

    public void ja(boolean z) {
        if (this.eQS != null) {
            this.eQS.ja(z);
        }
    }

    private void biF() {
        if (this.eQT == null) {
            this.eQT = new com.baidu.tieba.ala.liveroom.audiencelist.b(bjG().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (bjG().fah.bdW() != null) {
            j = bjG().fah.bdW().getCount();
        }
        this.eQT.a(this.eRu);
        this.eQT.a(this.eSo, a.g.ala_liveroom_audience, j);
        this.eQT.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.eQT.ji(false);
        } else {
            this.eQT.ji(true);
        }
    }

    protected void yP(String str) {
        if (this.eSC == null) {
            this.eSC = new com.baidu.tieba.ala.liveroom.q.b(bjG().pageContext);
        }
        this.eSC.b(this.eSp, str);
        iV(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.10
            @Override // java.lang.Runnable
            public void run() {
                d.this.eSC.bqj();
                d.this.iV(false);
            }
        }, 5000L);
    }

    private void jb(boolean z) {
        CustomResponsedMessage runTask;
        if (bjG().fah.yN().mLiveInfo.live_type == 1 && this.eTf) {
            if (this.eTe == null && (runTask = MessageManager.getInstance().runTask(2913074, f.class, bjG().pageContext)) != null && runTask.getData() != null) {
                this.eTe = (f) runTask.getData();
            }
            if (this.eTe != null) {
                if (this.eQX == null) {
                    this.eQX = this.eTe.a(bjG().pageContext);
                }
                if (bjG().fah.yN().mLiveInfo.challengeId > 0 && !this.eQX.qb()) {
                    this.eQX.d(bjG().fah.yN().mLiveInfo.live_id, bjG().fah.yN().XQ.userId);
                    jc(z);
                    this.eQX.c(bjG().fah.yN());
                }
            }
        }
    }

    private void jc(boolean z) {
        if (this.eQY == null) {
            this.eQY = this.eTe.b(bjG().pageContext);
            this.eQY.a(new com.baidu.live.challenge.h() { // from class: com.baidu.tieba.ala.liveroom.c.d.11
                @Override // com.baidu.live.challenge.h
                public void pQ() {
                    d.this.bjG().fai.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.h
                public void a(ad adVar, ae aeVar, ae aeVar2) {
                    d.this.ePU = true;
                    if (d.this.eRK != null) {
                        d.this.eRK.setPraiseEnable(false);
                        d.this.bjG().fai.fnb = false;
                    }
                    if (d.this.eQU != null) {
                        d.this.eQU.setCanVisible(false);
                        d.this.eQU.bme();
                    }
                    if (d.this.eQV != null) {
                        d.this.eQV.iM(true);
                    }
                    if (d.this.eSD != null) {
                        d.this.eSD.setVisible(8);
                    }
                    if (d.this.eQW != null) {
                        d.this.eQW.setCanVisible(false);
                        d.this.eQW.setVisible(8);
                    }
                    d.this.je(true);
                    d.this.jf(true);
                    if (d.this.bjG().awh != null) {
                        d.this.bjG().awh.getLivePlayer().setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                    }
                    if (d.this.eRI != null) {
                        d.this.eRI.setTimeTextMode(true);
                    }
                    if (d.this.awe != null && aeVar != null && aeVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(aeVar.abJ);
                        arrayList.add(aeVar2.abJ);
                        com.baidu.live.liveroom.a.b bVar = d.this.awe;
                        if (d.this.eSz) {
                            arrayList = null;
                        }
                        bVar.j(arrayList);
                    }
                }

                @Override // com.baidu.live.challenge.h
                public void pR() {
                }

                @Override // com.baidu.live.challenge.h
                public void pS() {
                }

                @Override // com.baidu.live.challenge.h
                public void at(boolean z2) {
                    d.this.bjG().fai.setSwipeClearEnable(true);
                    d.this.ePU = false;
                    if (d.this.eRK != null) {
                        d.this.eRK.setPraiseEnable(true);
                        d.this.bjG().fai.fnb = true;
                    }
                    if (d.this.eQU != null) {
                        d.this.eQU.setCanVisible(true);
                        d.this.eQU.t(d.this.bjG().fah.yN());
                    }
                    if (d.this.eRM != null) {
                        d.this.eRM.jR(true);
                    }
                    if (d.this.eQV != null) {
                        d.this.eQV.iM(false);
                    }
                    if (d.this.eSD != null) {
                        d.this.eSD.setVisible(0);
                    }
                    if (d.this.eQW != null) {
                        d.this.eQW.setCanVisible(true);
                        d.this.eQW.setVisible(0);
                    }
                    d.this.je(false);
                    d.this.jf(false);
                    if (d.this.awe != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.bjG().fah.bpO());
                        com.baidu.live.liveroom.a.b bVar = d.this.awe;
                        if (d.this.eSz) {
                            arrayList = null;
                        }
                        bVar.j(arrayList);
                    }
                    if (d.this.bjG().awh != null) {
                        d.this.bjG().awh.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
                    }
                    if (d.this.eRI != null) {
                        d.this.eRI.setTimeTextMode(false);
                    }
                }
            });
        }
        this.eQY.a(this.eQX);
        this.eQY.e(bjG().fag.getLiveContainerView());
        this.eQY.b(z, false, false);
        this.eQX.a((j.c) this.eQY);
    }

    private void jd(boolean z) {
        CustomResponsedMessage runTask;
        if (bjG().fah.yN().mLiveInfo.live_type == 1 && com.baidu.live.v.a.zj().awA.ZU) {
            if (this.eQW == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bjG().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.eQW = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.eQW != null) {
                this.eQW.a(bjG().fah.bpQ(), false, false);
                if (bjG().fah.yN().mLiveInfo.pkId > 0 && this.eQW.getRootView() != null && this.eQW.getRootView().getParent() == null && this.eTd != null) {
                    if (this.eTd.getChildCount() <= 0) {
                        this.eTd.addView(this.eQW.getRootView(), new LinearLayout.LayoutParams(-2, -2));
                    } else {
                        View childAt = this.eTd.getChildAt(0);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.topMargin = bjG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                        childAt.setLayoutParams(layoutParams);
                        this.eTd.addView(this.eQW.getRootView(), 0, new LinearLayout.LayoutParams(-2, -2));
                    }
                }
                if (z) {
                    this.eQW.a(null, bjG().fah.yN());
                } else {
                    this.eQW.b(bjG().fah.yN());
                }
            }
        }
    }

    public void biG() {
        this.eRF.c(bjG().fah.yN(), false);
    }

    public void biH() {
        if (bjG().fah.yN() != null && bjG().fah.yN().XQ != null && bjG().fah.yN().mLiveInfo != null) {
            if (this.eQR == null) {
                this.eQR = new com.baidu.tieba.ala.liveroom.r.b(bjG().pageContext);
            }
            long j = bjG().fah.yN().XQ.userId;
            int i = bjG().fah.yN().mLiveInfo.live_type;
            String str = bjG().fah.yN().XQ.portrait;
            String str2 = bjG().fah.yN().mLiveInfo.feed_id;
            long j2 = bjG().fah.yN().mLiveInfo.live_id;
            this.eQR.a(i, j, bjG().fah.yN().XQ.userName, false, str, xx(), str2, j2);
            this.eQR.af(this.eSo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void je(boolean z) {
        if (this.eTb != null && this.eTd != null) {
            if (z) {
                this.eTb.setViewActionDispatched(false);
                this.eTd.setViewActionDispatched(true);
                ViewGroup.LayoutParams layoutParams = this.eTb.getLayoutParams();
                layoutParams.height = bjT();
                this.eTb.setLayoutParams(layoutParams);
                biq();
                return;
            }
            this.eTd.setViewActionDispatched(false);
            this.eTb.setViewActionDispatched(true);
            ViewGroup.LayoutParams layoutParams2 = this.eTb.getLayoutParams();
            layoutParams2.height = -2;
            this.eTb.setLayoutParams(layoutParams2);
            bjS();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:7:0x0014 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.LinearLayout$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.tieba.ala.liveroom.activeview.b] */
    public void jf(boolean z) {
        if (this.eQV != null) {
            ?? layoutParams = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams) layoutParams).gravity = 5;
            ?? r2 = this.eQV;
            ViewGroup viewGroup = z ? this.eTb : this.eQN;
            if (!z) {
                layoutParams = pQ(1);
            }
            r2.a(1, viewGroup, layoutParams, 21);
            this.eQV.updateView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bjT() {
        return (((bjG().fai.getBottom() - this.eQY.au(false)) - (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0)) - bjG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - bjG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biI() {
        if (bjG() == null || bjG().fah == null || bjG().fah.yN() == null || bjG().fah.yN().Ye == null) {
            if (bjG().fah == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bjG().fah.yN() == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bjG().fah.yN().Ye == null) {
                Log.i("RenameLog", "getLiveContext().liveModel.getLiveShowData().mLoginUserInfo == null");
                return;
            } else {
                return;
            }
        }
        String str = bjG().fah.yN().Ye.userName;
        Log.i("RenameLog", "loginUserName:" + str);
        if (str != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bjG().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !bjc()) {
            com.baidu.live.c.pr().putInt("guide_rename_show_count", com.baidu.live.c.pr().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.ym().ba(true);
            if (this.eSj == null) {
                this.eSj = new com.baidu.tieba.ala.liveroom.s.a(bjG().pageContext);
            }
            this.eSj.setOtherParams(xx());
            this.eSj.e(this.eSp, bjG().fah.yN());
            iV(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.14
                @Override // java.lang.Runnable
                public void run() {
                    d.this.eSj.bqn();
                    d.this.iV(false);
                }
            }, 5000L);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_SHOW);
                alaStaticItem.addParams("other_params", xx());
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    private void biJ() {
        boolean z = false;
        if (this.eRM == null) {
            this.eRM = new com.baidu.tieba.ala.liveroom.u.a(bjG().pageContext, this);
        }
        this.eRM.d(bjG().fai, false);
        if (bjF() && bjG().fah.yN().mLiveInfo.screen_direction != 2) {
            z = true;
        }
        this.eRM.jQ(z);
    }

    private void biL() {
        if (this.eSw || this.eSx) {
            if ((TbadkCoreApplication.isLogin() && this.eRQ.wr().hasText()) || this.eSx) {
                this.eSw = false;
                this.eSx = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.15
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bji();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void g(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        super.g(aVar);
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
                if (this.eQU != null) {
                    this.eQU.u(jSONObject);
                }
            } else if ("enter_live".equals(optString)) {
                if (this.eQT.getCount() > 20) {
                    this.eQT.cD(this.eQT.getCount() + 1);
                } else if (this.eQO != null) {
                    com.baidu.live.data.a xo = aVar.xo();
                    com.baidu.live.data.g gVar = new com.baidu.live.data.g();
                    gVar.XR = new AlaLocationData();
                    gVar.XS = new AlaRelationData();
                    gVar.XQ = new AlaLiveUserInfoData();
                    gVar.XQ.userId = JavaTypesHelper.toLong(xo.userId, 0L);
                    gVar.XQ.userName = xo.userName;
                    gVar.XQ.portrait = xo.portrait;
                    if (this.eQO.c(gVar)) {
                        this.eQT.cD(this.eQT.getCount() + 1);
                    }
                }
            } else if ("update_liveinfo".equals(optString) && bjG().fah.yN() != null && bjG().fah.yN().mLiveInfo != null) {
                bjG().fah.a(bjG().fah.yN().mLiveInfo.live_id, bjG().fromType, bjG().enterTime);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void yK(String str) {
        if (this.eQV != null) {
            this.eQV.yK(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void bf(boolean z) {
        super.bf(z);
        if (bjG().fai != null) {
            bjG().fai.bqY();
            bjG().fai.setLiveViewOnDispatchTouchEventListener(null);
            bjG().fai.setOnLiveViewScrollListener(null);
        }
        if (bjG().awh != null) {
            bjG().awh.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.eQY != null) {
            this.eQY.pK();
        }
        biM();
        if (this.eQR != null) {
            this.eQR.pK();
        }
        if (this.eRM != null) {
            this.eRM.release();
        }
        if (this.eQU != null) {
            this.eQU.pK();
        }
        if (this.eQS != null) {
            this.eQS.bpT();
        }
        if (this.eQQ != null) {
            this.eQQ.bls();
            this.eQQ.setVisible(8);
        }
        if (this.eQW != null) {
            this.eQW.pK();
        }
        if (this.eQV != null) {
            this.eQV.release();
        }
        if (this.eTd != null) {
            this.eTd.setViewActionDispatched(false);
            this.eTd.removeAllViews();
            this.eTd = null;
        }
        if (this.eTb != null) {
            this.eTb.setViewActionDispatched(false);
            this.eTb.removeAllViews();
            this.eTb = null;
        }
        if (this.eQN != null) {
            this.eQN.removeAllViews();
            this.eQN = null;
        }
        if (this.eRM != null) {
            this.eRM.onDestroy();
        }
        if (this.eQX != null) {
            this.eQX.pK();
        }
        if (this.eRk != null) {
            this.eRk.cancel();
        }
        if (this.eSD != null) {
            this.eSD.bkx();
        }
        if (this.eRk != null) {
            this.eRk.pK();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void be(boolean z) {
        super.be(z);
        biM();
        if (this.eQP != null) {
            this.eQP.onDestroy();
        }
        if (this.eQR != null) {
            this.eQR.onDestroy();
        }
        if (this.eQU != null) {
            this.eQU.onDestroy();
        }
        if (this.eQW != null) {
            this.eQW.onDestroy();
        }
        if (this.eQX != null) {
            this.eQX.onDestroy();
        }
        if (this.eQY != null) {
            this.eQY.onDestroy();
        }
        if (this.eQZ != null) {
            this.eQZ.onDestroy();
        }
        if (this.eRY != null) {
            this.eRY.onDestroy();
        }
        if (this.eQQ != null) {
            this.eQQ.onDestroy();
        }
        if (this.eQO != null) {
            this.eQO.onDestroy();
        }
        if (this.eRQ != null) {
            this.eRQ.onDestroy();
        }
        if (this.eQS != null) {
            this.eQS.onDestory();
        }
        if (this.eQV != null) {
            this.eQV.release();
        }
        if (this.eSD != null) {
            this.eSD.be(!z);
        }
        MessageManager.getInstance().removeMessageRule(this.eRl);
        MessageManager.getInstance().removeMessageRule(this.eRm);
        MessageManager.getInstance().unRegisterListener(this.eRo);
        MessageManager.getInstance().unRegisterListener(this.eRp);
        MessageManager.getInstance().unRegisterListener(this.eTh);
        MessageManager.getInstance().unRegisterListener(this.eRr);
        MessageManager.getInstance().unRegisterListener(this.eRs);
        MessageManager.getInstance().unRegisterListener(this.eTg);
        MessageManager.getInstance().unRegisterListener(this.eRt);
        MessageManager.getInstance().unRegisterListener(this.eRq);
    }

    private void biM() {
        if (this.eRQ != null && this.eRQ.wq().getView() != null && this.eRQ.wq().getView().getParent() != null) {
            ((ViewGroup) this.eRQ.wq().getView().getParent()).removeView(this.eRQ.wq().getView());
        }
        if (this.eRc != null && this.eRc.getParent() != null) {
            ((ViewGroup) this.eRc.getParent()).removeView(this.eRc);
        }
        if (this.eRQ != null && this.eRQ.wr().getView() != null) {
            this.eSp.removeView(this.eRQ.wr().getView());
        }
        if (this.eRQ != null) {
            this.eRQ.wq().setMsgData(new LinkedList());
            this.eRQ.vW();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void a(com.baidu.live.data.x xVar) {
        if (this.eRQ != null) {
            bji();
            this.eRQ.wr().setEditText(" @" + xVar.getNameShow() + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.eQS != null) {
            this.eQS.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void f(com.baidu.live.data.a aVar) {
        if (this.eRQ != null) {
            bji();
            this.eRQ.wr().setEditText(" @" + aVar.userName + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.eQS != null) {
            this.eQS.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void b(com.baidu.live.data.x xVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected View biN() {
        if (this.eRQ != null) {
            return this.eRQ.wr().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean biO() {
        if (this.eRQ == null || !this.eRQ.wr().xQ()) {
            return false;
        }
        iT(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean biP() {
        return this.eQP == null || this.eQP.biP();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup biQ() {
        return this.eTd;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup biR() {
        return this.eQN;
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
                    this.eSt = false;
                    J(intExtra, intExtra2, intExtra3);
                    return;
                }
                biG();
                return;
            }
            bjE();
        } else if (i == 25051 && i2 == -1 && this.eSD != null) {
            this.eSD.blU();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.eRQ != null && this.eRQ.wq() != null) {
            this.eRQ.wq().onKeyboardVisibilityChanged(z);
        }
        if (z || this.eRQ == null || !this.eRQ.wr().xQ()) {
            if (z) {
                if (this.eQS != null) {
                    this.eQS.setVisibility(8);
                }
                if (this.eRS != null && this.eRS.sl() != null) {
                    this.eRS.sl().setVisibility(8);
                }
                biT();
                if (this.eRQ != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRQ.wr().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.eRQ.wr().getView().setLayoutParams(layoutParams);
                    this.eRQ.wr().getView().setVisibility(0);
                    this.eRQ.wr().setQuickInputPanelVisible(false);
                }
                if (this.eSo != null) {
                    this.eSo.setVisibility(8);
                }
                if (this.eQV != null) {
                    this.eQV.setVisible(8);
                }
                if (this.eRR != null) {
                    this.eRR.wy();
                }
                if (this.eSn != null) {
                    this.eSn.setCanVisible(false);
                }
            } else {
                biS();
            }
            if (this.eRQ != null && this.eRc != null) {
                int equipmentHeight = (int) (((z ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(bjG().pageContext.getPageActivity())) + bjG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
                if (this.eSp.indexOfChild(this.eRc) != -1 && this.eRc.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eRc.getLayoutParams();
                    layoutParams2.height = bjG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds27) + equipmentHeight;
                    this.eRc.setLayoutParams(layoutParams2);
                }
                if (this.eRc.indexOfChild(this.eRQ.wq().getView()) != -1 && this.eRQ.wq().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.eRQ.wq().getView().getLayoutParams();
                    layoutParams3.height = equipmentHeight;
                    this.eRQ.wq().getView().setLayoutParams(layoutParams3);
                }
                this.eRQ.wq().wp();
            }
            if (this.eSd != null) {
                this.eSd.aA(z);
            }
        }
    }

    private void biS() {
        if (this.eQS != null) {
            this.eQS.setVisibility(0);
        }
        if (this.eRc != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRc.getLayoutParams();
            layoutParams.bottomMargin = bjG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
            this.eRc.setLayoutParams(layoutParams);
        }
        if (this.eRQ != null) {
            bjj();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eRQ.wr().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.eRQ.wr().getView().setLayoutParams(layoutParams2);
        }
        if (this.eQS != null) {
            this.eQS.setVisibility(0);
        }
        if (this.eRS != null && this.eRS.sl() != null) {
            this.eRS.sl().setVisibility(0);
        }
        if (this.eSo != null) {
            this.eSo.setVisibility(0);
        }
        if (this.eQV != null) {
            this.eQV.setVisible(0);
        }
        if (this.eRR != null) {
            this.eRR.wy();
        }
        if (this.eSn != null) {
            this.eSn.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biT() {
        if (this.eRc != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRc.getLayoutParams();
            boolean z = false;
            if (this.eRQ != null && this.eRQ.wr() != null) {
                z = this.eRQ.wr().xP();
            }
            int iX = iX(z);
            if (layoutParams.bottomMargin != iX) {
                layoutParams.bottomMargin = iX;
                this.eRc.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iT(boolean z) {
        if (z) {
            this.eRQ.wr().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRc.getLayoutParams();
            int quickInputPanelExpandHeight = this.eRQ.wr().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.eRc.setLayoutParams(layoutParams);
                if (this.eRQ.wq() != null) {
                    this.eRQ.wq().wp();
                    return;
                }
                return;
            }
            return;
        }
        biS();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void j(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.eQO != null) {
                this.eQO.bW(i3);
            }
            if (this.eQQ != null) {
                this.eQQ.bW(i3);
            }
        }
        super.j(i, i2, i3);
        if (this.ePU || this.eTb != null) {
            this.eTb.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.16
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams = d.this.eTb.getLayoutParams();
                    if (layoutParams != null) {
                        int i4 = layoutParams.height;
                        int bjT = d.this.bjT();
                        if (bjT != i4) {
                            layoutParams.height = bjT;
                            d.this.eTb.setLayoutParams(layoutParams);
                        }
                    }
                }
            }, 100L);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public boolean cc(int i) {
        boolean cc = super.cc(i);
        if (cc && 2 == i) {
            if (this.eQP.biP()) {
                return false;
            }
            if (cc && this.eRM != null) {
                this.eRM.jR(false);
            }
        }
        return cc;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void pR(int i) {
        super.pR(i);
        if (i == 7 || i == 11) {
            if (this.eQS != null) {
                this.eQS.setVisibility(8);
            }
            if (this.eRQ != null) {
                this.eRQ.wq().getView().setVisibility(4);
            }
            if (this.eQV != null) {
                this.eQV.bj(2, 8);
                if (this.ePU) {
                    this.eQV.bj(1, 8);
                }
            }
            if (this.eSg != null) {
                this.eSg.jM(false);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public void cd(int i) {
        super.cd(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public void ce(int i) {
        super.ce(i);
        if (i == 7 || i == 11) {
            if (this.eQS != null) {
                this.eQS.setVisibility(0);
            }
            if (this.eRQ != null) {
                this.eRQ.wq().getView().setVisibility(0);
            }
            if (this.eQV != null) {
                this.eQV.setVisible(0);
            }
            if (this.eSg != null) {
                this.eSg.jM(true);
            }
            this.eSo.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.eQR != null) {
            this.eQR.bql();
        }
        if (this.eQX != null) {
            this.eQX.pU();
        }
        if (this.eQV != null) {
            this.eQV.onStop();
        }
        if (this.eQW != null) {
            this.eQW.ar(true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.eQR != null) {
            this.eQR.bqk();
        }
        if (this.eQX != null && this.eTf) {
            this.eQX.pV();
        }
        if (this.eQV != null) {
            this.eQV.onStart();
        }
        if (this.eQW != null) {
            this.eQW.ar(false);
        }
    }

    private ViewGroup.LayoutParams jg(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.eTd == null) {
            return null;
        }
        int bjT = this.ePU ? bjT() : -2;
        ViewGroup.LayoutParams layoutParams2 = this.eTd.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, bjT);
        }
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bjG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = bjG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds112);
        layoutParams.topMargin = bjG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200);
        return layoutParams;
    }

    private ViewGroup.LayoutParams bjU() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.eTb == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams2 = this.eTb.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bjG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = bjG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
        return layoutParams;
    }
}
