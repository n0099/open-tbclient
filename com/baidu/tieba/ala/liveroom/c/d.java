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
    private boolean ePV;
    private LinearLayout eQO;
    private com.baidu.tieba.ala.liveroom.audiencelist.c eQP;
    private com.baidu.tieba.ala.liveroom.l.a eQQ;
    private com.baidu.tieba.ala.liveroom.e.b eQR;
    private com.baidu.tieba.ala.liveroom.r.b eQS;
    private com.baidu.tieba.ala.liveroom.operation.a eQT;
    private com.baidu.tieba.ala.liveroom.audiencelist.b eQU;
    private com.baidu.tieba.ala.liveroom.j.a eQV;
    private com.baidu.tieba.ala.liveroom.activeview.b eQW;
    private com.baidu.live.d.a eQX;
    private j eQY;
    private i eQZ;
    private com.baidu.tieba.ala.liveroom.attentionpop.b eRa;
    private FrameLayout eRd;
    private com.baidu.tieba.ala.liveroom.h.b eRl;
    private DispatchedPvlLayout eTc;
    private View eTd;
    private DispatchedRelativeLayout eTe;
    private f eTf;
    private long lastClickTime = 0;
    private boolean eTg = false;
    private HttpRule eRm = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.eQY != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.eQY.qa()) {
                httpMessage.addParam("ala_challenge_id", d.this.eQY.qd());
            }
            return httpMessage;
        }
    };
    private HttpRule eRn = new HttpRule(1021151) { // from class: com.baidu.tieba.ala.liveroom.c.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.eQY != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.eQY.qa()) {
                httpMessage.addParam("challenge_id", d.this.eQY.qd());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c eRo = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.c.d.17
        @Override // com.baidu.live.liveroom.g.c
        public void yM() {
            if (d.this.eRN != null) {
                d.this.eRN.jR(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bg(boolean z) {
            if (z) {
                if (d.this.eQT != null) {
                    d.this.eQT.qz(8);
                }
                if (d.this.eRN != null) {
                    d.this.eRN.jR(true);
                }
            } else {
                if (d.this.eQT != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                        d.this.eQT.qz(0);
                    } else {
                        d.this.eQT.qz(8);
                    }
                }
                if (d.this.eRN != null) {
                    d.this.eRN.jR(false);
                }
            }
            if (d.this.eSe != null) {
                d.this.eSe.aB(z);
            }
        }
    };
    private HttpMessageListener eRp = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.d.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.yW() != null) {
                        com.baidu.live.v.c.zq().axM = getQuickGiftHttpResponseMessage.yW();
                        d.this.biB();
                    }
                }
            }
        }
    };
    private CustomMessageListener eRq = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.d.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.biK();
        }
    };
    CustomMessageListener eRu = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.c.d.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.eRl.c(d.this.bjI());
                } else if (d.this.bje() || !g.qa(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, 3000L);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.bjI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.bjI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    d.this.eRl.b(d.this.eRd, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener eTh = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.c.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.bje() || !g.qa(2913128)) {
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
    private CustomMessageListener eTi = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.c.d.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.eRU.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eRr = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.c.d.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.this.eSi != null) {
                    d.this.eSi.yR(str);
                }
            }
        }
    };
    CustomMessageListener eRs = new CustomMessageListener(CmdConfigCustom.CMD_HOST_GET_WALLET_UA) { // from class: com.baidu.tieba.ala.liveroom.c.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.eSw != null && d.this.eSw.apX != null && !d.this.eSw.aqa && !d.this.eSw.aqb && d.this.eSd != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.bjI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = d.this.bjI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                d.this.eSd.b(d.this.eRd, layoutParams);
                if (e.vG() != null) {
                    e.vG().vM();
                }
            }
        }
    };
    private CustomMessageListener eRt = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.eSg != null) {
                    d.this.eSg.dismiss();
                }
                if (d.this.eSi != null) {
                    d.this.eSi.dismiss();
                }
                k.wA().setSwitchStatus(true);
                k.wA().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bjk();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b eRv = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.d.13
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
                        alaStaticItem.addParams("gifts_value", com.baidu.live.v.c.zq().axM.su().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.v.c.zq().axM.su().rx());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.v.c.zq().axM.su().ry());
                        if (d.this.bjI().fai.yO() != null && d.this.bjI().fai.yO().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.bjI().fai.yO().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.bjI().fai.yO().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.xx());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.uX()) {
                        if (com.baidu.live.c.pr().getBoolean("quick_gift_guide_show", true) && !d.this.bje()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, x.class, d.this.bjI().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                x xVar = (x) runTask.getData();
                                xVar.setPageContext(d.this.bjI().pageContext);
                                xVar.d(d.this.bjI().fai.yO());
                                xVar.a(com.baidu.live.v.c.zq().axM.su());
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
                        n.a(d.this.bjI().pageContext, d.this.bjI().fai.yO(), com.baidu.live.v.c.zq().axM.su(), d.this.xx());
                    }
                } else if (i == 1) {
                    if (d.this.eRR != null) {
                        d.this.bjk();
                    }
                } else if (i == 3 && d.this.uX()) {
                    d.this.eRG.c(d.this.bjI().fai.yO(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.bjI() != null && d.this.bjI().fai != null && d.this.bjI().fai.yO() != null && d.this.bjI().fai.yO().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.bjI().fai.yO().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.bjI().fai.yO().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.bjI().fai.yO().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.xx());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.bjI() != null && d.this.bjI().fai != null && d.this.bjI().fai.yO() != null && d.this.bjI().fai.yO().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.bjI().fai.yO().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.bjI().fai.yO().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.bjI().fai.yO().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.xx());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.awf != null) {
                        d.this.awf.bb(false);
                    }
                } else if (i == 12) {
                    if (d.this.eRN != null) {
                        String valueOf = String.valueOf(d.this.bjI().fai.yO().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.bjI().fai.yO().mLiveInfo.room_id);
                        String str2 = null;
                        com.baidu.live.data.k kVar = d.this.bjI().fai.yO().mLiveSdkInfo;
                        if (kVar != null && kVar.mCastIds != null) {
                            str2 = String.valueOf(d.this.bjI().fai.yO().mLiveSdkInfo.mCastIds.XX);
                        }
                        d.this.eRN.ad(valueOf, valueOf2, str2);
                        if (com.baidu.live.liveroom.a.ym().yn()) {
                            d.this.biK();
                        }
                    }
                } else if (i == 14) {
                    m yO = d.this.bjI().fai.yO();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.bjI().pageContext.getPageActivity(), yO.XQ.userName, Long.toString(yO.XQ.userId), Long.toString(yO.XQ.charmCount), String.valueOf(yO.mLiveInfo.group_id), String.valueOf(yO.mLiveInfo.live_id), false, String.valueOf(yO.XQ.userId), Long.toString(yO.Ye.userId), yO.Ye.userName, yO.Ye.portrait, d.this.eQU.getCount(), d.this.xx())));
                    LogManager.getCommonLogger().doClickGusetNumLog(yO.mLiveInfo.feed_id, d.this.eQU.getCount() + "", d.this.xx());
                } else if (i == 11) {
                    d.this.bjn();
                    d.this.bjo();
                } else if (i == 15) {
                    if (d.this.eSb != null && d.this.bjI() != null && d.this.bjI().fai != null && d.this.bjI().fai.yO() != null && d.this.bjI().fai.yO().mLiveInfo != null) {
                        long j = d.this.bjI().fai.yO().mLiveInfo.live_id;
                        String valueOf3 = String.valueOf(d.this.bjI().fai.yO().mLiveInfo.feed_id);
                        long j2 = d.this.bjI().fai.yO().mLiveInfo.room_id;
                        String str3 = d.this.bjI().fai.yO().mLiveInfo.cover;
                        String str4 = "";
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        if (d.this.bjI().fai.yO().mLiveInfo.session_info != null) {
                            str4 = d.this.bjI().fai.yO().mLiveInfo.session_info.flvUrl;
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
                        d.this.eSb.yR(o.a(valueOf3, j + "", j2, false, 1, str3, str4, str5, str6, str7));
                        o.aDQ = j;
                        if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                            ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                            LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf3, d.this.xx());
                        }
                    }
                } else if (i == 16) {
                    if (d.this.bjI() != null && (apVar2 = com.baidu.live.v.a.zl().axC) != null && (ayVar2 = apVar2.acS) != null) {
                        String str8 = ayVar2.adP.adW;
                        if (!TextUtils.isEmpty(str8)) {
                            long j3 = 0;
                            if (d.this.bjI().fai != null && d.this.bjI().fai.yO() != null && d.this.bjI().fai.yO().mLiveInfo != null) {
                                j3 = d.this.bjI().fai.yO().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j3 + "", d.this.bjI().fai.yO().mLiveInfo.room_id + "", d.this.bjI().fai.yO().mLiveInfo.feed_id, d.this.xx());
                            }
                            if (str8.contains("?")) {
                                str = str8 + "&liveId=" + j3;
                            } else {
                                str = str8 + "?liveId=" + j3;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.bjI().pageContext.getPageActivity(), str);
                        }
                    }
                } else if (i == 17 && d.this.uX() && d.this.bjI() != null && (apVar = com.baidu.live.v.a.zl().axC) != null && (ayVar = apVar.acS) != null && (beVar = ayVar.adQ) != null && !TextUtils.isEmpty(beVar.webUrl) && d.this.eSg != null && d.this.bjI().fai != null && d.this.bjI().fai.yO() != null) {
                    m yO2 = d.this.bjI().fai.yO();
                    d.this.eSg.a(beVar.webUrl, yO2.mLiveInfo.live_id, yO2.Ye.userId, yO2.XQ.userId);
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.eRI = new com.baidu.tieba.ala.liveroom.guide.c(bjI().pageContext, this, false);
        this.eRm.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.eRm);
        this.eRn.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.eRn);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean bim() {
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void k(m mVar) {
        super.k(mVar);
        g.bmb();
        this.eTg = true;
        bjI().faj.setIsForceHandledTouch(false);
        bjI().faj.setSwipeClearEnable(true);
        bjI().faj.setOnLiveViewScrollListener(this.eRo);
        if (this.eRL != null) {
            this.eRL.b(this.eRv);
        }
        if (this.eSp != null) {
            this.eSp.setVisibility(0);
        }
        biq();
        bit();
        biE();
        bja();
        biF();
        biH();
        biG();
        iR(false);
        bjr();
        bjq();
        biv();
        biC();
        bjt();
        biJ();
        biL();
        jd(true);
        bjS();
        bjT();
        iW(false);
        bjz();
        biu();
        biB();
        biw();
        bix();
        biy();
        biz();
        jb(true);
        bjy();
        MessageManager.getInstance().registerListener(this.eRp);
        MessageManager.getInstance().registerListener(this.eRq);
        MessageManager.getInstance().registerListener(this.eTi);
        MessageManager.getInstance().registerListener(this.eRs);
        MessageManager.getInstance().registerListener(this.eRt);
        MessageManager.getInstance().registerListener(this.eTh);
        MessageManager.getInstance().registerListener(this.eRu);
        MessageManager.getInstance().registerListener(this.eRr);
        biN();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void i(m mVar) {
        super.i(mVar);
        if (this.eQQ != null) {
            this.eQQ.u(mVar);
        }
        if (this.eQR != null) {
            this.eQR.q(mVar);
        }
        if (this.eQV != null) {
            this.eQV.t(mVar);
        }
        if (this.eQZ != null) {
            this.eQZ.a(mVar);
        }
        jd(false);
        jb(false);
        if (this.eQW != null) {
            this.eQW.h(mVar);
            this.eQW.iN(this.eSz);
            this.eQW.updateView();
            if (mVar != null && this.eSn != null && !this.eSn.hasInit && !TextUtils.isEmpty(this.eSn.adm)) {
                this.eSn.hasInit = true;
                this.eQW.yL(this.eSn.adm);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(h hVar) {
        if (hVar != null) {
            if (this.eQP != null && hVar.getList() != null) {
                this.eQP.f(hVar);
            }
            if (this.eQU != null) {
                this.eQU.cD(hVar.getCount());
            }
        }
    }

    private void bio() {
        if (this.eRM != null) {
            this.eRM.ai(bjI().fah.getLiveContainerView());
        }
    }

    private void bjS() {
        if (this.eRa == null) {
            this.eRa = new com.baidu.tieba.ala.liveroom.attentionpop.b(bjI().pageContext);
        }
        if (bjI().fai != null && bjI().fai.yO() != null && bjI().fai.yO().mLiveInfo != null) {
            this.eRa.yM(String.valueOf(bjI().fai.yO().mLiveInfo.user_id));
        }
    }

    private void bjT() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (bjI() != null && bjI().fai != null && bjI().fai.yO() != null && bjI().fai.yO().mLiveInfo != null) {
                j = bjI().fai.yO().mLiveInfo.room_id;
            }
            if (this.eRZ == null) {
                this.eRZ = new com.baidu.tieba.ala.liveroom.guide.a(bjI().pageContext, j);
            }
            this.eRZ.iU(this.eSs);
            this.eRZ.a(new a.InterfaceC0459a() { // from class: com.baidu.tieba.ala.liveroom.c.d.4
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0459a
                public void bjX() {
                    if (d.this.awf != null) {
                        d.this.awf.bb(true);
                    }
                }
            });
            this.eRZ.af(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bk(int i) {
        super.bk(i);
        bio();
        if (this.eQZ != null) {
            this.eQZ.bk(i);
        }
    }

    private void biq() {
        if (this.eTe == null) {
            this.eTe = new DispatchedRelativeLayout(bjI().pageContext.getPageActivity());
            this.eTe.setViewActionDispatched(false);
            this.eTe.setViewActionDispatchListener(new com.baidu.live.view.dispatch.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.5
                @Override // com.baidu.live.view.dispatch.a
                public boolean W(View view) {
                    return (d.this.eTc == null || d.this.eTc.Bu() || view == null || !(view.getTag(a.g.sdk_pvl_layout_priority_tag_key) instanceof Integer)) ? false : true;
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewAdded(View view) {
                    view.setTag(a.g.ala_live_room_vertival_widgets_bk_lp_key, view.getLayoutParams());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(view.getLayoutParams().width, view.getLayoutParams().height);
                    layoutParams.gravity = 5;
                    view.setLayoutParams(layoutParams);
                    if (d.this.eTc != null) {
                        d.this.eTc.addView(view);
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewRemoved(View view) {
                    if (d.this.eTc != null) {
                        d.this.eTc.removeView(view);
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public void Bw() {
                    if (d.this.eTc != null && !d.this.eTc.Bu()) {
                        d.this.eTc.removeAllViews();
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public int indexOfChild(View view) {
                    if (d.this.eTc != null) {
                        return d.this.eTc.indexOfChild(view);
                    }
                    return 0;
                }
            });
        }
        if (this.eTe.getParent() == null) {
            bjI().faj.addView(this.eTe, jg(false));
        }
        if (this.eTc == null) {
            this.eTc = new DispatchedPvlLayout(bjI().pageContext.getPageActivity());
            this.eTc.setDefaultItemMargin(bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.eTc.setViewActionDispatched(false);
            this.eTc.setViewActionDispatchListener(new com.baidu.live.view.dispatch.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.6
                @Override // com.baidu.live.view.dispatch.a
                public boolean W(View view) {
                    return (d.this.eTe == null || d.this.eTe.Bu() || view == null || !(view.getTag(a.g.ala_live_room_vertival_widgets_bk_lp_key) instanceof ViewGroup.LayoutParams)) ? false : true;
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewAdded(View view) {
                    view.setLayoutParams(new LinearLayout.LayoutParams(view.getLayoutParams().width, view.getLayoutParams().height));
                    d.this.eTe.addView(view, (ViewGroup.LayoutParams) view.getTag(a.g.ala_live_room_vertival_widgets_bk_lp_key));
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewRemoved(View view) {
                    d.this.eTe.removeView(view);
                }

                @Override // com.baidu.live.view.dispatch.a
                public void Bw() {
                    if (d.this.eTe != null && !d.this.eTe.Bu()) {
                        d.this.eTe.removeAllViews();
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public int indexOfChild(View view) {
                    return d.this.eTe.indexOfChild(view);
                }
            });
        }
        if (this.eTc.getParent() == null) {
            bjI().faj.addView(this.eTc, bjW());
        }
    }

    private void bis() {
        if (this.eTd == null) {
            this.eTd = new View(bjI().pageContext.getPageActivity());
            this.eTd.setTag(a.g.sdk_pvl_layout_priority_tag_key, 20);
        }
        if (this.eTd.getParent() == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(1, 0);
            layoutParams.weight = 1.0f;
            this.eTc.addView(this.eTd, layoutParams);
        }
    }

    private void bjU() {
        if (this.eTd != null) {
            this.eTc.removeView(this.eTd);
        }
    }

    private void bit() {
        if (this.eQO == null) {
            this.eQO = new LinearLayout(bjI().pageContext.getPageActivity());
            this.eQO.setOrientation(1);
        }
        if (this.eQO.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds160);
            layoutParams.leftMargin = bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bjI().faj.addView(this.eQO, layoutParams);
        }
    }

    private void biv() {
        if (this.eRK != null && bjI() != null && bjI().fai != null) {
            this.eRK.b(this.eSp, bjI().fai.yO());
        }
    }

    private void biu() {
        if (this.eQW == null) {
            this.eQW = new com.baidu.tieba.ala.liveroom.activeview.b(bjI().pageContext);
        }
        this.eQW.iM(this.ePV);
        this.eQW.setOtherParams(xx());
        this.eQW.b(bjI().fai.yO(), false);
        this.eQW.setHost(false);
        this.eQW.iN(this.eSz);
        this.eQW.a(1, this.eQO, pQ(1));
        this.eQW.a(2, this.eTc, pQ(2));
        this.eQW.setVisible(this.eSt ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biB() {
        if (this.eQT == null) {
            biG();
        }
        this.eQT.setOtherParams(xx());
        this.eQT.a(com.baidu.live.v.c.zq().axM, bjI().fai.yO());
    }

    private ViewGroup.LayoutParams pQ(int i) {
        switch (i) {
            case 1:
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (this.eQO == null || this.eQO.getChildCount() == 0) {
                    return layoutParams;
                }
                layoutParams.topMargin = bjI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                return layoutParams;
            case 2:
                ViewGroup.LayoutParams layoutParams2 = this.eTe.getLayoutParams();
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(((int) (BdUtilHelper.getEquipmentWidth(bjI().pageContext.getPageActivity()) * 0.25f)) - ((layoutParams2 instanceof LinearLayout.LayoutParams ? ((LinearLayout.LayoutParams) layoutParams2).rightMargin : 0) * 2), -2);
                layoutParams3.gravity = 5;
                return layoutParams3;
            default:
                return new RelativeLayout.LayoutParams(-2, -2);
        }
    }

    private void biw() {
        if (this.eQV == null) {
            this.eQV = new com.baidu.tieba.ala.liveroom.j.a(bjI().pageContext, this);
        }
        this.eQV.setOtherParams(xx());
        this.eQV.d(this.eTe, biA());
        this.eQV.t(bjI().fai.yO());
    }

    private void bix() {
        if (this.eSd == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, com.baidu.live.guardclub.j.class, bjI().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.eSd = (com.baidu.live.guardclub.j) runTask.getData();
            } else {
                return;
            }
        }
        this.eSd.setOtherParams(xx());
        if (this.eRd != null && this.eRd.indexOfChild(this.eSd.getView()) >= 0) {
            this.eRd.removeView(this.eSd.getView());
        }
    }

    private void biy() {
        if (this.eQT != null) {
            this.eQT.a(new a.InterfaceC0465a() { // from class: com.baidu.tieba.ala.liveroom.c.d.7
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0465a
                public void bl(int i, int i2) {
                    m yO = d.this.bjI().fai.yO();
                    if (yO != null && yO.mLiveInfo != null) {
                        if (d.this.eSh == null) {
                            d.this.eSh = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.bjI().pageContext.getPageActivity());
                        }
                        d.this.eSh.d(d.this.eSq, i, i2);
                        d.this.eSh.a(String.valueOf(yO.mLiveInfo.live_id), new a.InterfaceC0467a() { // from class: com.baidu.tieba.ala.liveroom.c.d.7.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0467a
                            public void a(float f, String str) {
                                if (d.this.eQT != null) {
                                    d.this.eQT.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0465a
                public void bm(int i, int i2) {
                    if (d.this.eSh != null) {
                        d.this.eSh.br(i, i2);
                    }
                }
            });
        }
    }

    private void biz() {
        if (this.eSE == null) {
            this.eSE = new com.baidu.tieba.ala.liveroom.h.e(bjI().pageContext);
        }
        this.eSE.setRoomId(bjI().fai.yO().mLiveInfo.room_id);
        this.eSE.za("");
        this.eSE.a(bjI().fai.yO(), this.eTc);
        if (this.eRl == null) {
            this.eRl = new com.baidu.tieba.ala.liveroom.h.b(bjI().pageContext, xx(), this.eSE, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.8
                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void biW() {
                    d.this.iV(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void biX() {
                    d.this.iV(false);
                }
            });
        }
        this.eRl.setRoomId(bjI().fai.yO().mLiveInfo.room_id);
        if (this.eRd != null && this.eRd.indexOfChild(this.eRl.getView()) >= 0) {
            this.eRd.removeView(this.eRl.getView());
        }
        if (this.eRl != null) {
            this.eRl.b(bjI());
        }
    }

    private ViewGroup.LayoutParams biA() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.topMargin = (ScreenHelper.getRealScreenHeight(bjI().pageContext.getPageActivity()) - this.eTe.getTop()) - bjI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds814);
        return layoutParams;
    }

    private void biC() {
        CustomResponsedMessage runTask;
        if (this.eRR == null && (runTask = MessageManager.getInstance().runTask(2913039, com.baidu.live.im.i.class, bjI().pageContext)) != null && runTask.getData() != null) {
            this.eRR = (com.baidu.live.im.i) runTask.getData();
            this.eRR.setFromMaster(false);
            this.eRR.wq().getView().setId(a.g.ala_liveroom_msg_list);
            this.eRR.a(new i.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.9
                @Override // com.baidu.live.im.i.a
                public boolean ws() {
                    return d.this.uX();
                }

                @Override // com.baidu.live.im.i.a
                public void wt() {
                    d.this.eSx = true;
                }

                @Override // com.baidu.live.im.i.a
                public void dM(String str) {
                    if (!d.this.eSt) {
                        d.this.iT(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.bjI().pageContext.getPageActivity(), d.this.bjI().fah.getLiveContainerView());
                    }
                    d.this.yO(str);
                }

                @Override // com.baidu.live.im.i.a
                public void wu() {
                    if (d.this.eSt) {
                        d.this.iT(true);
                        d.this.bjI().fah.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.bjI().pageContext.getPageActivity(), d.this.bjI().fah.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.eRR != null) {
                        d.this.eRR.wr().setQuickInputPanelVisible(false);
                        d.this.eRR.wr().xR();
                    }
                }

                @Override // com.baidu.live.im.i.a
                public void wv() {
                    if (d.this.eSt) {
                        d.this.biV();
                        if (d.this.eRS != null) {
                            d.this.eRS.wy();
                        }
                    }
                }

                @Override // com.baidu.live.im.i.a
                public boolean ww() {
                    return d.this.bjf();
                }
            });
            this.eRd = new FrameLayout(bjI().pageContext.getPageActivity());
            this.eRd.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.eRR != null && this.eRd != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bjI().pageContext.getPageActivity()) * 0.75f);
            int dimensionPixelSize = bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64) + ((int) (BdUtilHelper.getEquipmentHeight(bjI().pageContext.getPageActivity()) * 0.27f));
            if (this.eSq.indexOfChild(this.eRd) < 0) {
                if (this.eRd.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eRd.getParent()).removeView(this.eRd);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds27) + dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
                this.eSq.addView(this.eRd, layoutParams);
            }
            if (this.eRd.indexOfChild(this.eRR.wq().getView()) < 0) {
                if (this.eRR.wq().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eRR.wq().getView()).removeView(this.eRR.wq().getView());
                }
                this.eRd.addView(this.eRR.wq().getView(), new FrameLayout.LayoutParams(equipmentWidth, dimensionPixelSize));
            }
            if (bjI().faj.indexOfChild(this.eRR.wr().getView()) < 0) {
                if (this.eRR.wr().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eRR.wr().getView().getParent()).removeView(this.eRR.wr().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bjl();
                bjI().faj.addView(this.eRR.wr().getView(), layoutParams2);
            }
            m yO = bjI().fai.yO();
            if (yO != null && yO.mLiveInfo != null) {
                this.eRR.setLogData(yO.mLiveInfo.feed_id, xx());
            }
            this.eRR.e(String.valueOf(bjI().fai.yO().mLiveInfo.group_id), String.valueOf(bjI().fai.yO().mLiveInfo.last_msg_id), String.valueOf(bjI().fai.yO().XQ.userId), String.valueOf(bjI().fai.yO().mLiveInfo.live_id), bjI().fai.yO().XQ.appId);
            iT(false);
        }
    }

    private void biE() {
        if (this.eQQ == null) {
            this.eQQ = new com.baidu.tieba.ala.liveroom.l.a(bjI().pageContext, false, this);
        }
        this.eQQ.c(this.eSp, bjI().fai.yO());
        this.eQQ.a(this.eRv);
        this.eQQ.setOtherParams(xx());
    }

    private void biF() {
        if (this.eQP == null) {
            this.eQP = new com.baidu.tieba.ala.liveroom.audiencelist.c(bjI().pageContext, this, false);
        }
        this.eQP.a(String.valueOf(bjI().fai.yO().mLiveInfo.group_id), String.valueOf(bjI().fai.yO().mLiveInfo.live_id), String.valueOf(bjI().fai.yO().XQ.userId), bjI().fai.yO());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.eRF != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.eQP.c(this.eSp, i, a.g.ala_liveroom_audience_count_layout);
            this.eQP.f(bjI().fai.bdY());
            this.eQP.setOtherParams(xx());
        }
    }

    private void biG() {
        if (this.eQT == null) {
            this.eQT = new com.baidu.tieba.ala.liveroom.operation.a(bjI().pageContext);
        }
        this.eQT.a(bjI(), this.eSq, bjI().fai.yO().mLiveInfo.live_type, true, this.eRv);
        this.eQT.setOtherParams(xx());
    }

    public void ja(boolean z) {
        if (this.eQT != null) {
            this.eQT.ja(z);
        }
    }

    private void biH() {
        if (this.eQU == null) {
            this.eQU = new com.baidu.tieba.ala.liveroom.audiencelist.b(bjI().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (bjI().fai.bdY() != null) {
            j = bjI().fai.bdY().getCount();
        }
        this.eQU.a(this.eRv);
        this.eQU.a(this.eSp, a.g.ala_liveroom_audience, j);
        this.eQU.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.eQU.ji(false);
        } else {
            this.eQU.ji(true);
        }
    }

    protected void yP(String str) {
        if (this.eSD == null) {
            this.eSD = new com.baidu.tieba.ala.liveroom.q.b(bjI().pageContext);
        }
        this.eSD.b(this.eSq, str);
        iV(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.10
            @Override // java.lang.Runnable
            public void run() {
                d.this.eSD.bql();
                d.this.iV(false);
            }
        }, 5000L);
    }

    private void jb(boolean z) {
        CustomResponsedMessage runTask;
        if (bjI().fai.yO().mLiveInfo.live_type == 1 && this.eTg) {
            if (this.eTf == null && (runTask = MessageManager.getInstance().runTask(2913074, f.class, bjI().pageContext)) != null && runTask.getData() != null) {
                this.eTf = (f) runTask.getData();
            }
            if (this.eTf != null) {
                if (this.eQY == null) {
                    this.eQY = this.eTf.a(bjI().pageContext);
                }
                if (bjI().fai.yO().mLiveInfo.challengeId > 0 && !this.eQY.qb()) {
                    this.eQY.d(bjI().fai.yO().mLiveInfo.live_id, bjI().fai.yO().XQ.userId);
                    jc(z);
                    this.eQY.c(bjI().fai.yO());
                }
            }
        }
    }

    private void jc(boolean z) {
        if (this.eQZ == null) {
            this.eQZ = this.eTf.b(bjI().pageContext);
            this.eQZ.a(new com.baidu.live.challenge.h() { // from class: com.baidu.tieba.ala.liveroom.c.d.11
                @Override // com.baidu.live.challenge.h
                public void pQ() {
                    d.this.bjI().faj.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.h
                public void a(ad adVar, ae aeVar, ae aeVar2) {
                    d.this.ePV = true;
                    if (d.this.eRL != null) {
                        d.this.eRL.setPraiseEnable(false);
                        d.this.bjI().faj.fnc = false;
                    }
                    if (d.this.eQV != null) {
                        d.this.eQV.setCanVisible(false);
                        d.this.eQV.bmg();
                    }
                    if (d.this.eQW != null) {
                        d.this.eQW.iM(true);
                    }
                    if (d.this.eSE != null) {
                        d.this.eSE.setVisible(8);
                    }
                    if (d.this.eQX != null) {
                        d.this.eQX.setCanVisible(false);
                        d.this.eQX.setVisible(8);
                    }
                    d.this.je(true);
                    d.this.jf(true);
                    if (d.this.bjI().awi != null) {
                        d.this.bjI().awi.getLivePlayer().setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                    }
                    if (d.this.eRJ != null) {
                        d.this.eRJ.setTimeTextMode(true);
                    }
                    if (d.this.awf != null && aeVar != null && aeVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(aeVar.abJ);
                        arrayList.add(aeVar2.abJ);
                        com.baidu.live.liveroom.a.b bVar = d.this.awf;
                        if (d.this.eSA) {
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
                    d.this.bjI().faj.setSwipeClearEnable(true);
                    d.this.ePV = false;
                    if (d.this.eRL != null) {
                        d.this.eRL.setPraiseEnable(true);
                        d.this.bjI().faj.fnc = true;
                    }
                    if (d.this.eQV != null) {
                        d.this.eQV.setCanVisible(true);
                        d.this.eQV.t(d.this.bjI().fai.yO());
                    }
                    if (d.this.eRN != null) {
                        d.this.eRN.jR(true);
                    }
                    if (d.this.eQW != null) {
                        d.this.eQW.iM(false);
                    }
                    if (d.this.eSE != null) {
                        d.this.eSE.setVisible(0);
                    }
                    if (d.this.eQX != null) {
                        d.this.eQX.setCanVisible(true);
                        d.this.eQX.setVisible(0);
                    }
                    d.this.je(false);
                    d.this.jf(false);
                    if (d.this.awf != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.bjI().fai.bpQ());
                        com.baidu.live.liveroom.a.b bVar = d.this.awf;
                        if (d.this.eSA) {
                            arrayList = null;
                        }
                        bVar.j(arrayList);
                    }
                    if (d.this.bjI().awi != null) {
                        d.this.bjI().awi.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
                    }
                    if (d.this.eRJ != null) {
                        d.this.eRJ.setTimeTextMode(false);
                    }
                }
            });
        }
        this.eQZ.a(this.eQY);
        this.eQZ.e(bjI().fah.getLiveContainerView());
        this.eQZ.b(z, false, false);
        this.eQY.a((j.c) this.eQZ);
    }

    private void jd(boolean z) {
        CustomResponsedMessage runTask;
        if (bjI().fai.yO().mLiveInfo.live_type == 1 && com.baidu.live.v.a.zl().awB.ZU) {
            if (this.eQX == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bjI().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.eQX = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.eQX != null) {
                this.eQX.a(bjI().fai.bpS(), false, false);
                if (bjI().fai.yO().mLiveInfo.pkId > 0 && this.eQX.getRootView() != null && this.eQX.getRootView().getParent() == null && this.eTe != null) {
                    if (this.eTe.getChildCount() <= 0) {
                        this.eTe.addView(this.eQX.getRootView(), new LinearLayout.LayoutParams(-2, -2));
                    } else {
                        View childAt = this.eTe.getChildAt(0);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.topMargin = bjI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                        childAt.setLayoutParams(layoutParams);
                        this.eTe.addView(this.eQX.getRootView(), 0, new LinearLayout.LayoutParams(-2, -2));
                    }
                }
                if (z) {
                    this.eQX.a(null, bjI().fai.yO());
                } else {
                    this.eQX.b(bjI().fai.yO());
                }
            }
        }
    }

    public void biI() {
        this.eRG.c(bjI().fai.yO(), false);
    }

    public void biJ() {
        if (bjI().fai.yO() != null && bjI().fai.yO().XQ != null && bjI().fai.yO().mLiveInfo != null) {
            if (this.eQS == null) {
                this.eQS = new com.baidu.tieba.ala.liveroom.r.b(bjI().pageContext);
            }
            long j = bjI().fai.yO().XQ.userId;
            int i = bjI().fai.yO().mLiveInfo.live_type;
            String str = bjI().fai.yO().XQ.portrait;
            String str2 = bjI().fai.yO().mLiveInfo.feed_id;
            long j2 = bjI().fai.yO().mLiveInfo.live_id;
            this.eQS.a(i, j, bjI().fai.yO().XQ.userName, false, str, xx(), str2, j2);
            this.eQS.af(this.eSp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void je(boolean z) {
        if (this.eTc != null && this.eTe != null) {
            if (z) {
                this.eTc.setViewActionDispatched(false);
                this.eTe.setViewActionDispatched(true);
                ViewGroup.LayoutParams layoutParams = this.eTc.getLayoutParams();
                layoutParams.height = bjV();
                this.eTc.setLayoutParams(layoutParams);
                bis();
                return;
            }
            this.eTe.setViewActionDispatched(false);
            this.eTc.setViewActionDispatched(true);
            ViewGroup.LayoutParams layoutParams2 = this.eTc.getLayoutParams();
            layoutParams2.height = -2;
            this.eTc.setLayoutParams(layoutParams2);
            bjU();
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
        if (this.eQW != null) {
            ?? layoutParams = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams) layoutParams).gravity = 5;
            ?? r2 = this.eQW;
            ViewGroup viewGroup = z ? this.eTc : this.eQO;
            if (!z) {
                layoutParams = pQ(1);
            }
            r2.a(1, viewGroup, layoutParams, 21);
            this.eQW.updateView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bjV() {
        return (((bjI().faj.getBottom() - (this.eQZ != null ? this.eQZ.au(false) : 0)) - (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0)) - bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biK() {
        if (bjI() == null || bjI().fai == null || bjI().fai.yO() == null || bjI().fai.yO().Ye == null) {
            if (bjI().fai == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bjI().fai.yO() == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bjI().fai.yO().Ye == null) {
                Log.i("RenameLog", "getLiveContext().liveModel.getLiveShowData().mLoginUserInfo == null");
                return;
            } else {
                return;
            }
        }
        String str = bjI().fai.yO().Ye.userName;
        Log.i("RenameLog", "loginUserName:" + str);
        if (str != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bjI().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !bje()) {
            com.baidu.live.c.pr().putInt("guide_rename_show_count", com.baidu.live.c.pr().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.ym().ba(true);
            if (this.eSk == null) {
                this.eSk = new com.baidu.tieba.ala.liveroom.s.a(bjI().pageContext);
            }
            this.eSk.setOtherParams(xx());
            this.eSk.e(this.eSq, bjI().fai.yO());
            iV(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.14
                @Override // java.lang.Runnable
                public void run() {
                    d.this.eSk.bqp();
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

    private void biL() {
        boolean z = false;
        if (this.eRN == null) {
            this.eRN = new com.baidu.tieba.ala.liveroom.u.a(bjI().pageContext, this);
        }
        this.eRN.d(bjI().faj, false);
        if (bjH() && bjI().fai.yO().mLiveInfo.screen_direction != 2) {
            z = true;
        }
        this.eRN.jQ(z);
    }

    private void biN() {
        if (this.eSx || this.eSy) {
            if ((TbadkCoreApplication.isLogin() && this.eRR.wr().hasText()) || this.eSy) {
                this.eSx = false;
                this.eSy = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.15
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bjk();
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
                if (this.eQV != null) {
                    this.eQV.u(jSONObject);
                }
            } else if ("enter_live".equals(optString)) {
                if (this.eQU.getCount() > 20) {
                    this.eQU.cD(this.eQU.getCount() + 1);
                } else if (this.eQP != null) {
                    com.baidu.live.data.a xo = aVar.xo();
                    com.baidu.live.data.g gVar = new com.baidu.live.data.g();
                    gVar.XR = new AlaLocationData();
                    gVar.XS = new AlaRelationData();
                    gVar.XQ = new AlaLiveUserInfoData();
                    gVar.XQ.userId = JavaTypesHelper.toLong(xo.userId, 0L);
                    gVar.XQ.userName = xo.userName;
                    gVar.XQ.portrait = xo.portrait;
                    if (this.eQP.c(gVar)) {
                        this.eQU.cD(this.eQU.getCount() + 1);
                    }
                }
            } else if ("update_liveinfo".equals(optString) && bjI().fai.yO() != null && bjI().fai.yO().mLiveInfo != null) {
                bjI().fai.a(bjI().fai.yO().mLiveInfo.live_id, bjI().fromType, bjI().enterTime);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void yK(String str) {
        if (this.eQW != null) {
            this.eQW.yK(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void bf(boolean z) {
        super.bf(z);
        if (bjI().faj != null) {
            bjI().faj.bra();
            bjI().faj.setLiveViewOnDispatchTouchEventListener(null);
            bjI().faj.setOnLiveViewScrollListener(null);
        }
        if (bjI().awi != null) {
            bjI().awi.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.eQZ != null) {
            this.eQZ.pK();
        }
        biO();
        if (this.eQS != null) {
            this.eQS.pK();
        }
        if (this.eRN != null) {
            this.eRN.release();
        }
        if (this.eQV != null) {
            this.eQV.pK();
        }
        if (this.eQT != null) {
            this.eQT.bpV();
        }
        if (this.eQR != null) {
            this.eQR.blu();
            this.eQR.setVisible(8);
        }
        if (this.eQX != null) {
            this.eQX.pK();
        }
        if (this.eQW != null) {
            this.eQW.release();
        }
        if (this.eTe != null) {
            this.eTe.setViewActionDispatched(false);
            this.eTe.removeAllViews();
            this.eTe = null;
        }
        if (this.eTc != null) {
            this.eTc.setViewActionDispatched(false);
            this.eTc.removeAllViews();
            this.eTc = null;
        }
        if (this.eQO != null) {
            this.eQO.removeAllViews();
            this.eQO = null;
        }
        if (this.eRN != null) {
            this.eRN.onDestroy();
        }
        if (this.eQY != null) {
            this.eQY.pK();
        }
        if (this.eRl != null) {
            this.eRl.cancel();
        }
        if (this.eSE != null) {
            this.eSE.bkz();
        }
        if (this.eRl != null) {
            this.eRl.pK();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void be(boolean z) {
        super.be(z);
        biO();
        if (this.eQQ != null) {
            this.eQQ.onDestroy();
        }
        if (this.eQS != null) {
            this.eQS.onDestroy();
        }
        if (this.eQV != null) {
            this.eQV.onDestroy();
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
        if (this.eRa != null) {
            this.eRa.onDestroy();
        }
        if (this.eRZ != null) {
            this.eRZ.onDestroy();
        }
        if (this.eQR != null) {
            this.eQR.onDestroy();
        }
        if (this.eQP != null) {
            this.eQP.onDestroy();
        }
        if (this.eRR != null) {
            this.eRR.onDestroy();
        }
        if (this.eQT != null) {
            this.eQT.onDestory();
        }
        if (this.eQW != null) {
            this.eQW.release();
        }
        if (this.eSE != null) {
            this.eSE.be(!z);
        }
        MessageManager.getInstance().removeMessageRule(this.eRm);
        MessageManager.getInstance().removeMessageRule(this.eRn);
        MessageManager.getInstance().unRegisterListener(this.eRp);
        MessageManager.getInstance().unRegisterListener(this.eRq);
        MessageManager.getInstance().unRegisterListener(this.eTi);
        MessageManager.getInstance().unRegisterListener(this.eRs);
        MessageManager.getInstance().unRegisterListener(this.eRt);
        MessageManager.getInstance().unRegisterListener(this.eTh);
        MessageManager.getInstance().unRegisterListener(this.eRu);
        MessageManager.getInstance().unRegisterListener(this.eRr);
    }

    private void biO() {
        if (this.eRR != null && this.eRR.wq().getView() != null && this.eRR.wq().getView().getParent() != null) {
            ((ViewGroup) this.eRR.wq().getView().getParent()).removeView(this.eRR.wq().getView());
        }
        if (this.eRd != null && this.eRd.getParent() != null) {
            ((ViewGroup) this.eRd.getParent()).removeView(this.eRd);
        }
        if (this.eRR != null && this.eRR.wr().getView() != null) {
            this.eSq.removeView(this.eRR.wr().getView());
        }
        if (this.eRR != null) {
            this.eRR.wq().setMsgData(new LinkedList());
            this.eRR.vW();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void a(com.baidu.live.data.x xVar) {
        if (this.eRR != null) {
            bjk();
            this.eRR.wr().setEditText(" @" + xVar.getNameShow() + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.eQT != null) {
            this.eQT.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void f(com.baidu.live.data.a aVar) {
        if (this.eRR != null) {
            bjk();
            this.eRR.wr().setEditText(" @" + aVar.userName + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.eQT != null) {
            this.eQT.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void b(com.baidu.live.data.x xVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected View biP() {
        if (this.eRR != null) {
            return this.eRR.wr().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean biQ() {
        if (this.eRR == null || !this.eRR.wr().xQ()) {
            return false;
        }
        iT(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean biR() {
        return this.eQQ == null || this.eQQ.biR();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup biS() {
        return this.eTe;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup biT() {
        return this.eQO;
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
                    this.eSu = false;
                    J(intExtra, intExtra2, intExtra3);
                    return;
                }
                biI();
                return;
            }
            bjG();
        } else if (i == 25051 && i2 == -1 && this.eSE != null) {
            this.eSE.blW();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.eRR != null && this.eRR.wq() != null) {
            this.eRR.wq().onKeyboardVisibilityChanged(z);
        }
        if (z || this.eRR == null || !this.eRR.wr().xQ()) {
            if (z) {
                if (this.eQT != null) {
                    this.eQT.setVisibility(8);
                }
                if (this.eRT != null && this.eRT.sl() != null) {
                    this.eRT.sl().setVisibility(8);
                }
                biV();
                if (this.eRR != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRR.wr().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.eRR.wr().getView().setLayoutParams(layoutParams);
                    this.eRR.wr().getView().setVisibility(0);
                    this.eRR.wr().setQuickInputPanelVisible(false);
                }
                if (this.eSp != null) {
                    this.eSp.setVisibility(8);
                }
                if (this.eQW != null) {
                    this.eQW.setVisible(8);
                }
                if (this.eRS != null) {
                    this.eRS.wy();
                }
                if (this.eSo != null) {
                    this.eSo.setCanVisible(false);
                }
            } else {
                biU();
            }
            if (this.eRR != null && this.eRd != null) {
                int equipmentHeight = (int) (((z ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(bjI().pageContext.getPageActivity())) + bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
                if (this.eSq.indexOfChild(this.eRd) != -1 && this.eRd.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eRd.getLayoutParams();
                    layoutParams2.height = bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds27) + equipmentHeight;
                    this.eRd.setLayoutParams(layoutParams2);
                }
                if (this.eRd.indexOfChild(this.eRR.wq().getView()) != -1 && this.eRR.wq().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.eRR.wq().getView().getLayoutParams();
                    layoutParams3.height = equipmentHeight;
                    this.eRR.wq().getView().setLayoutParams(layoutParams3);
                }
                this.eRR.wq().wp();
            }
            if (this.eSe != null) {
                this.eSe.aA(z);
            }
        }
    }

    private void biU() {
        if (this.eQT != null) {
            this.eQT.setVisibility(0);
        }
        if (this.eRd != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRd.getLayoutParams();
            layoutParams.bottomMargin = bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
            this.eRd.setLayoutParams(layoutParams);
        }
        if (this.eRR != null) {
            bjl();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eRR.wr().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.eRR.wr().getView().setLayoutParams(layoutParams2);
        }
        if (this.eQT != null) {
            this.eQT.setVisibility(0);
        }
        if (this.eRT != null && this.eRT.sl() != null) {
            this.eRT.sl().setVisibility(0);
        }
        if (this.eSp != null) {
            this.eSp.setVisibility(0);
        }
        if (this.eQW != null) {
            this.eQW.setVisible(0);
        }
        if (this.eRS != null) {
            this.eRS.wy();
        }
        if (this.eSo != null) {
            this.eSo.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biV() {
        if (this.eRd != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRd.getLayoutParams();
            boolean z = false;
            if (this.eRR != null && this.eRR.wr() != null) {
                z = this.eRR.wr().xP();
            }
            int iX = iX(z);
            if (layoutParams.bottomMargin != iX) {
                layoutParams.bottomMargin = iX;
                this.eRd.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iT(boolean z) {
        if (z) {
            this.eRR.wr().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRd.getLayoutParams();
            int quickInputPanelExpandHeight = this.eRR.wr().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.eRd.setLayoutParams(layoutParams);
                if (this.eRR.wq() != null) {
                    this.eRR.wq().wp();
                    return;
                }
                return;
            }
            return;
        }
        biU();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void j(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.eQP != null) {
                this.eQP.bW(i3);
            }
            if (this.eQR != null) {
                this.eQR.bW(i3);
            }
        }
        super.j(i, i2, i3);
        if (this.ePV && this.eTc != null) {
            this.eTc.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.16
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (d.this.eTc != null && (layoutParams = d.this.eTc.getLayoutParams()) != null) {
                        int i4 = layoutParams.height;
                        int bjV = d.this.bjV();
                        if (bjV != i4) {
                            layoutParams.height = bjV;
                            d.this.eTc.setLayoutParams(layoutParams);
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
            if (this.eQQ.biR()) {
                return false;
            }
            if (cc && this.eRN != null) {
                this.eRN.jR(false);
            }
        }
        return cc;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void pR(int i) {
        super.pR(i);
        if (i == 7 || i == 11) {
            if (this.eQT != null) {
                this.eQT.setVisibility(8);
            }
            if (this.eRR != null) {
                this.eRR.wq().getView().setVisibility(4);
            }
            if (this.eQW != null) {
                this.eQW.bj(2, 8);
                if (this.ePV) {
                    this.eQW.bj(1, 8);
                }
            }
            if (this.eSh != null) {
                this.eSh.jM(false);
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
            if (this.eQT != null) {
                this.eQT.setVisibility(0);
            }
            if (this.eRR != null) {
                this.eRR.wq().getView().setVisibility(0);
            }
            if (this.eQW != null) {
                this.eQW.setVisible(0);
            }
            if (this.eSh != null) {
                this.eSh.jM(true);
            }
            this.eSp.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.eQS != null) {
            this.eQS.bqn();
        }
        if (this.eQY != null) {
            this.eQY.pU();
        }
        if (this.eQW != null) {
            this.eQW.onStop();
        }
        if (this.eQX != null) {
            this.eQX.ar(true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.eQS != null) {
            this.eQS.bqm();
        }
        if (this.eQY != null && this.eTg) {
            this.eQY.pV();
        }
        if (this.eQW != null) {
            this.eQW.onStart();
        }
        if (this.eQX != null) {
            this.eQX.ar(false);
        }
    }

    private ViewGroup.LayoutParams jg(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.eTe == null) {
            return null;
        }
        int bjV = this.ePV ? bjV() : -2;
        ViewGroup.LayoutParams layoutParams2 = this.eTe.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, bjV);
        }
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds112);
        layoutParams.topMargin = bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200);
        return layoutParams;
    }

    private ViewGroup.LayoutParams bjW() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.eTc == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams2 = this.eTc.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
        return layoutParams;
    }
}
