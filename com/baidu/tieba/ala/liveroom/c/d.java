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
    private boolean eQi;
    private LinearLayout eRb;
    private com.baidu.tieba.ala.liveroom.audiencelist.c eRc;
    private com.baidu.tieba.ala.liveroom.l.a eRd;
    private com.baidu.tieba.ala.liveroom.e.b eRe;
    private com.baidu.tieba.ala.liveroom.r.b eRf;
    private com.baidu.tieba.ala.liveroom.operation.a eRg;
    private com.baidu.tieba.ala.liveroom.audiencelist.b eRh;
    private com.baidu.tieba.ala.liveroom.j.a eRi;
    private com.baidu.tieba.ala.liveroom.activeview.b eRj;
    private com.baidu.live.d.a eRk;
    private j eRl;
    private i eRm;
    private com.baidu.tieba.ala.liveroom.attentionpop.b eRn;
    private FrameLayout eRq;
    private com.baidu.tieba.ala.liveroom.h.b eRy;
    private DispatchedPvlLayout eTp;
    private View eTq;
    private DispatchedRelativeLayout eTr;
    private f eTs;
    private long lastClickTime = 0;
    private boolean eTt = false;
    private HttpRule eRz = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.eRl != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.eRl.qa()) {
                httpMessage.addParam("ala_challenge_id", d.this.eRl.qd());
            }
            return httpMessage;
        }
    };
    private HttpRule eRA = new HttpRule(1021151) { // from class: com.baidu.tieba.ala.liveroom.c.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.eRl != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.eRl.qa()) {
                httpMessage.addParam("challenge_id", d.this.eRl.qd());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c eRB = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.c.d.17
        @Override // com.baidu.live.liveroom.g.c
        public void yM() {
            if (d.this.eSa != null) {
                d.this.eSa.jR(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bg(boolean z) {
            if (z) {
                if (d.this.eRg != null) {
                    d.this.eRg.qz(8);
                }
                if (d.this.eSa != null) {
                    d.this.eSa.jR(true);
                }
            } else {
                if (d.this.eRg != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                        d.this.eRg.qz(0);
                    } else {
                        d.this.eRg.qz(8);
                    }
                }
                if (d.this.eSa != null) {
                    d.this.eSa.jR(false);
                }
            }
            if (d.this.eSr != null) {
                d.this.eSr.aB(z);
            }
        }
    };
    private HttpMessageListener eRC = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.d.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.yW() != null) {
                        com.baidu.live.v.c.zq().axN = getQuickGiftHttpResponseMessage.yW();
                        d.this.biC();
                    }
                }
            }
        }
    };
    private CustomMessageListener eRD = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.d.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.biL();
        }
    };
    CustomMessageListener eRH = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.c.d.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.eRy.c(d.this.bjJ());
                } else if (d.this.bjf() || !g.qa(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, 3000L);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.bjJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.bjJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    d.this.eRy.b(d.this.eRq, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener eTu = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.c.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.bjf() || !g.qa(2913128)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.21.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.pY(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, 3000L);
                } else {
                    d.this.yQ(str);
                }
            }
        }
    };
    private CustomMessageListener eTv = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.c.d.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.eSh.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eRE = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.c.d.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.this.eSv != null) {
                    d.this.eSv.yS(str);
                }
            }
        }
    };
    CustomMessageListener eRF = new CustomMessageListener(CmdConfigCustom.CMD_HOST_GET_WALLET_UA) { // from class: com.baidu.tieba.ala.liveroom.c.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.eSJ != null && d.this.eSJ.apY != null && !d.this.eSJ.aqb && !d.this.eSJ.aqc && d.this.eSq != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.bjJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = d.this.bjJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                d.this.eSq.b(d.this.eRq, layoutParams);
                if (e.vG() != null) {
                    e.vG().vM();
                }
            }
        }
    };
    private CustomMessageListener eRG = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.eSt != null) {
                    d.this.eSt.dismiss();
                }
                if (d.this.eSv != null) {
                    d.this.eSv.dismiss();
                }
                k.wA().setSwitchStatus(true);
                k.wA().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bjl();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b eRI = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.d.13
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
                        alaStaticItem.addParams("gifts_value", com.baidu.live.v.c.zq().axN.su().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.v.c.zq().axN.su().rx());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.v.c.zq().axN.su().ry());
                        if (d.this.bjJ().fav.yO() != null && d.this.bjJ().fav.yO().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.bjJ().fav.yO().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.bjJ().fav.yO().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.xx());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.uX()) {
                        if (com.baidu.live.c.pr().getBoolean("quick_gift_guide_show", true) && !d.this.bjf()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, x.class, d.this.bjJ().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                x xVar = (x) runTask.getData();
                                xVar.setPageContext(d.this.bjJ().pageContext);
                                xVar.d(d.this.bjJ().fav.yO());
                                xVar.a(com.baidu.live.v.c.zq().axN.su());
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
                        n.a(d.this.bjJ().pageContext, d.this.bjJ().fav.yO(), com.baidu.live.v.c.zq().axN.su(), d.this.xx());
                    }
                } else if (i == 1) {
                    if (d.this.eSe != null) {
                        d.this.bjl();
                    }
                } else if (i == 3 && d.this.uX()) {
                    d.this.eRT.c(d.this.bjJ().fav.yO(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.bjJ() != null && d.this.bjJ().fav != null && d.this.bjJ().fav.yO() != null && d.this.bjJ().fav.yO().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.bjJ().fav.yO().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.bjJ().fav.yO().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.bjJ().fav.yO().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.xx());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.bjJ() != null && d.this.bjJ().fav != null && d.this.bjJ().fav.yO() != null && d.this.bjJ().fav.yO().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.bjJ().fav.yO().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.bjJ().fav.yO().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.bjJ().fav.yO().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.xx());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.awg != null) {
                        d.this.awg.bb(false);
                    }
                } else if (i == 12) {
                    if (d.this.eSa != null) {
                        String valueOf = String.valueOf(d.this.bjJ().fav.yO().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.bjJ().fav.yO().mLiveInfo.room_id);
                        String str2 = null;
                        com.baidu.live.data.k kVar = d.this.bjJ().fav.yO().mLiveSdkInfo;
                        if (kVar != null && kVar.mCastIds != null) {
                            str2 = String.valueOf(d.this.bjJ().fav.yO().mLiveSdkInfo.mCastIds.XX);
                        }
                        d.this.eSa.ad(valueOf, valueOf2, str2);
                        if (com.baidu.live.liveroom.a.ym().yn()) {
                            d.this.biL();
                        }
                    }
                } else if (i == 14) {
                    m yO = d.this.bjJ().fav.yO();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.bjJ().pageContext.getPageActivity(), yO.XQ.userName, Long.toString(yO.XQ.userId), Long.toString(yO.XQ.charmCount), String.valueOf(yO.mLiveInfo.group_id), String.valueOf(yO.mLiveInfo.live_id), false, String.valueOf(yO.XQ.userId), Long.toString(yO.Ye.userId), yO.Ye.userName, yO.Ye.portrait, d.this.eRh.getCount(), d.this.xx())));
                    LogManager.getCommonLogger().doClickGusetNumLog(yO.mLiveInfo.feed_id, d.this.eRh.getCount() + "", d.this.xx());
                } else if (i == 11) {
                    d.this.bjo();
                    d.this.bjp();
                } else if (i == 15) {
                    if (d.this.eSo != null && d.this.bjJ() != null && d.this.bjJ().fav != null && d.this.bjJ().fav.yO() != null && d.this.bjJ().fav.yO().mLiveInfo != null) {
                        long j = d.this.bjJ().fav.yO().mLiveInfo.live_id;
                        String valueOf3 = String.valueOf(d.this.bjJ().fav.yO().mLiveInfo.feed_id);
                        long j2 = d.this.bjJ().fav.yO().mLiveInfo.room_id;
                        String str3 = d.this.bjJ().fav.yO().mLiveInfo.cover;
                        String str4 = "";
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        if (d.this.bjJ().fav.yO().mLiveInfo.session_info != null) {
                            str4 = d.this.bjJ().fav.yO().mLiveInfo.session_info.flvUrl;
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
                        d.this.eSo.yS(o.a(valueOf3, j + "", j2, false, 1, str3, str4, str5, str6, str7));
                        o.aDR = j;
                        if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                            ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                            LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf3, d.this.xx());
                        }
                    }
                } else if (i == 16) {
                    if (d.this.bjJ() != null && (apVar2 = com.baidu.live.v.a.zl().axD) != null && (ayVar2 = apVar2.acS) != null) {
                        String str8 = ayVar2.adP.adW;
                        if (!TextUtils.isEmpty(str8)) {
                            long j3 = 0;
                            if (d.this.bjJ().fav != null && d.this.bjJ().fav.yO() != null && d.this.bjJ().fav.yO().mLiveInfo != null) {
                                j3 = d.this.bjJ().fav.yO().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j3 + "", d.this.bjJ().fav.yO().mLiveInfo.room_id + "", d.this.bjJ().fav.yO().mLiveInfo.feed_id, d.this.xx());
                            }
                            if (str8.contains("?")) {
                                str = str8 + "&liveId=" + j3;
                            } else {
                                str = str8 + "?liveId=" + j3;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.bjJ().pageContext.getPageActivity(), str);
                        }
                    }
                } else if (i == 17 && d.this.uX() && d.this.bjJ() != null && (apVar = com.baidu.live.v.a.zl().axD) != null && (ayVar = apVar.acS) != null && (beVar = ayVar.adQ) != null && !TextUtils.isEmpty(beVar.webUrl) && d.this.eSt != null && d.this.bjJ().fav != null && d.this.bjJ().fav.yO() != null) {
                    m yO2 = d.this.bjJ().fav.yO();
                    d.this.eSt.a(beVar.webUrl, yO2.mLiveInfo.live_id, yO2.Ye.userId, yO2.XQ.userId);
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.eRV = new com.baidu.tieba.ala.liveroom.guide.c(bjJ().pageContext, this, false);
        this.eRz.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.eRz);
        this.eRA.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.eRA);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean bin() {
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void k(m mVar) {
        super.k(mVar);
        g.bmc();
        this.eTt = true;
        bjJ().faw.setIsForceHandledTouch(false);
        bjJ().faw.setSwipeClearEnable(true);
        bjJ().faw.setOnLiveViewScrollListener(this.eRB);
        if (this.eRY != null) {
            this.eRY.b(this.eRI);
        }
        if (this.eSC != null) {
            this.eSC.setVisibility(0);
        }
        bir();
        biu();
        biF();
        bjb();
        biG();
        biI();
        biH();
        iR(false);
        bjs();
        bjr();
        biw();
        biD();
        bju();
        biK();
        biM();
        jd(true);
        bjT();
        bjU();
        iW(false);
        bjA();
        biv();
        biC();
        bix();
        biy();
        biz();
        biA();
        jb(true);
        bjz();
        MessageManager.getInstance().registerListener(this.eRC);
        MessageManager.getInstance().registerListener(this.eRD);
        MessageManager.getInstance().registerListener(this.eTv);
        MessageManager.getInstance().registerListener(this.eRF);
        MessageManager.getInstance().registerListener(this.eRG);
        MessageManager.getInstance().registerListener(this.eTu);
        MessageManager.getInstance().registerListener(this.eRH);
        MessageManager.getInstance().registerListener(this.eRE);
        biO();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void i(m mVar) {
        super.i(mVar);
        if (this.eRd != null) {
            this.eRd.u(mVar);
        }
        if (this.eRe != null) {
            this.eRe.q(mVar);
        }
        if (this.eRi != null) {
            this.eRi.t(mVar);
        }
        if (this.eRm != null) {
            this.eRm.a(mVar);
        }
        jd(false);
        jb(false);
        if (this.eRj != null) {
            this.eRj.h(mVar);
            this.eRj.iN(this.eSM);
            this.eRj.updateView();
            if (mVar != null && this.eSA != null && !this.eSA.hasInit && !TextUtils.isEmpty(this.eSA.adm)) {
                this.eSA.hasInit = true;
                this.eRj.yM(this.eSA.adm);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(h hVar) {
        if (hVar != null) {
            if (this.eRc != null && hVar.getList() != null) {
                this.eRc.f(hVar);
            }
            if (this.eRh != null) {
                this.eRh.cD(hVar.getCount());
            }
        }
    }

    private void bip() {
        if (this.eRZ != null) {
            this.eRZ.ai(bjJ().fau.getLiveContainerView());
        }
    }

    private void bjT() {
        if (this.eRn == null) {
            this.eRn = new com.baidu.tieba.ala.liveroom.attentionpop.b(bjJ().pageContext);
        }
        if (bjJ().fav != null && bjJ().fav.yO() != null && bjJ().fav.yO().mLiveInfo != null) {
            this.eRn.yN(String.valueOf(bjJ().fav.yO().mLiveInfo.user_id));
        }
    }

    private void bjU() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (bjJ() != null && bjJ().fav != null && bjJ().fav.yO() != null && bjJ().fav.yO().mLiveInfo != null) {
                j = bjJ().fav.yO().mLiveInfo.room_id;
            }
            if (this.eSm == null) {
                this.eSm = new com.baidu.tieba.ala.liveroom.guide.a(bjJ().pageContext, j);
            }
            this.eSm.iU(this.eSF);
            this.eSm.a(new a.InterfaceC0459a() { // from class: com.baidu.tieba.ala.liveroom.c.d.4
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0459a
                public void bjY() {
                    if (d.this.awg != null) {
                        d.this.awg.bb(true);
                    }
                }
            });
            this.eSm.af(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bk(int i) {
        super.bk(i);
        bip();
        if (this.eRm != null) {
            this.eRm.bk(i);
        }
    }

    private void bir() {
        if (this.eTr == null) {
            this.eTr = new DispatchedRelativeLayout(bjJ().pageContext.getPageActivity());
            this.eTr.setViewActionDispatched(false);
            this.eTr.setViewActionDispatchListener(new com.baidu.live.view.dispatch.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.5
                @Override // com.baidu.live.view.dispatch.a
                public boolean W(View view) {
                    return (d.this.eTp == null || d.this.eTp.Bu() || view == null || !(view.getTag(a.g.sdk_pvl_layout_priority_tag_key) instanceof Integer)) ? false : true;
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewAdded(View view) {
                    view.setTag(a.g.ala_live_room_vertival_widgets_bk_lp_key, view.getLayoutParams());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(view.getLayoutParams().width, view.getLayoutParams().height);
                    layoutParams.gravity = 5;
                    view.setLayoutParams(layoutParams);
                    if (d.this.eTp != null) {
                        d.this.eTp.addView(view);
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewRemoved(View view) {
                    if (d.this.eTp != null) {
                        d.this.eTp.removeView(view);
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public void Bw() {
                    if (d.this.eTp != null && !d.this.eTp.Bu()) {
                        d.this.eTp.removeAllViews();
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public int indexOfChild(View view) {
                    if (d.this.eTp != null) {
                        return d.this.eTp.indexOfChild(view);
                    }
                    return 0;
                }
            });
        }
        if (this.eTr.getParent() == null) {
            bjJ().faw.addView(this.eTr, jg(false));
        }
        if (this.eTp == null) {
            this.eTp = new DispatchedPvlLayout(bjJ().pageContext.getPageActivity());
            this.eTp.setDefaultItemMargin(bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.eTp.setViewActionDispatched(false);
            this.eTp.setViewActionDispatchListener(new com.baidu.live.view.dispatch.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.6
                @Override // com.baidu.live.view.dispatch.a
                public boolean W(View view) {
                    return (d.this.eTr == null || d.this.eTr.Bu() || view == null || !(view.getTag(a.g.ala_live_room_vertival_widgets_bk_lp_key) instanceof ViewGroup.LayoutParams)) ? false : true;
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewAdded(View view) {
                    view.setLayoutParams(new LinearLayout.LayoutParams(view.getLayoutParams().width, view.getLayoutParams().height));
                    d.this.eTr.addView(view, (ViewGroup.LayoutParams) view.getTag(a.g.ala_live_room_vertival_widgets_bk_lp_key));
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewRemoved(View view) {
                    d.this.eTr.removeView(view);
                }

                @Override // com.baidu.live.view.dispatch.a
                public void Bw() {
                    if (d.this.eTr != null && !d.this.eTr.Bu()) {
                        d.this.eTr.removeAllViews();
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public int indexOfChild(View view) {
                    return d.this.eTr.indexOfChild(view);
                }
            });
        }
        if (this.eTp.getParent() == null) {
            bjJ().faw.addView(this.eTp, bjX());
        }
    }

    private void bit() {
        if (this.eTq == null) {
            this.eTq = new View(bjJ().pageContext.getPageActivity());
            this.eTq.setTag(a.g.sdk_pvl_layout_priority_tag_key, 20);
        }
        if (this.eTq.getParent() == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(1, 0);
            layoutParams.weight = 1.0f;
            this.eTp.addView(this.eTq, layoutParams);
        }
    }

    private void bjV() {
        if (this.eTq != null) {
            this.eTp.removeView(this.eTq);
        }
    }

    private void biu() {
        if (this.eRb == null) {
            this.eRb = new LinearLayout(bjJ().pageContext.getPageActivity());
            this.eRb.setOrientation(1);
        }
        if (this.eRb.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds160);
            layoutParams.leftMargin = bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bjJ().faw.addView(this.eRb, layoutParams);
        }
    }

    private void biw() {
        if (this.eRX != null && bjJ() != null && bjJ().fav != null) {
            this.eRX.b(this.eSC, bjJ().fav.yO());
        }
    }

    private void biv() {
        if (this.eRj == null) {
            this.eRj = new com.baidu.tieba.ala.liveroom.activeview.b(bjJ().pageContext);
        }
        this.eRj.iM(this.eQi);
        this.eRj.setOtherParams(xx());
        this.eRj.b(bjJ().fav.yO(), false);
        this.eRj.setHost(false);
        this.eRj.iN(this.eSM);
        this.eRj.a(1, this.eRb, pQ(1));
        this.eRj.a(2, this.eTp, pQ(2));
        this.eRj.setVisible(this.eSG ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biC() {
        if (this.eRg == null) {
            biH();
        }
        this.eRg.setOtherParams(xx());
        this.eRg.a(com.baidu.live.v.c.zq().axN, bjJ().fav.yO());
    }

    private ViewGroup.LayoutParams pQ(int i) {
        switch (i) {
            case 1:
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (this.eRb == null || this.eRb.getChildCount() == 0) {
                    return layoutParams;
                }
                layoutParams.topMargin = bjJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                return layoutParams;
            case 2:
                ViewGroup.LayoutParams layoutParams2 = this.eTr.getLayoutParams();
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(((int) (BdUtilHelper.getEquipmentWidth(bjJ().pageContext.getPageActivity()) * 0.25f)) - ((layoutParams2 instanceof LinearLayout.LayoutParams ? ((LinearLayout.LayoutParams) layoutParams2).rightMargin : 0) * 2), -2);
                layoutParams3.gravity = 5;
                return layoutParams3;
            default:
                return new RelativeLayout.LayoutParams(-2, -2);
        }
    }

    private void bix() {
        if (this.eRi == null) {
            this.eRi = new com.baidu.tieba.ala.liveroom.j.a(bjJ().pageContext, this);
        }
        this.eRi.setOtherParams(xx());
        this.eRi.d(this.eTr, biB());
        this.eRi.t(bjJ().fav.yO());
    }

    private void biy() {
        if (this.eSq == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, com.baidu.live.guardclub.j.class, bjJ().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.eSq = (com.baidu.live.guardclub.j) runTask.getData();
            } else {
                return;
            }
        }
        this.eSq.setOtherParams(xx());
        if (this.eRq != null && this.eRq.indexOfChild(this.eSq.getView()) >= 0) {
            this.eRq.removeView(this.eSq.getView());
        }
    }

    private void biz() {
        if (this.eRg != null) {
            this.eRg.a(new a.InterfaceC0465a() { // from class: com.baidu.tieba.ala.liveroom.c.d.7
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0465a
                public void bl(int i, int i2) {
                    m yO = d.this.bjJ().fav.yO();
                    if (yO != null && yO.mLiveInfo != null) {
                        if (d.this.eSu == null) {
                            d.this.eSu = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.bjJ().pageContext.getPageActivity());
                        }
                        d.this.eSu.d(d.this.eSD, i, i2);
                        d.this.eSu.a(String.valueOf(yO.mLiveInfo.live_id), new a.InterfaceC0467a() { // from class: com.baidu.tieba.ala.liveroom.c.d.7.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0467a
                            public void a(float f, String str) {
                                if (d.this.eRg != null) {
                                    d.this.eRg.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0465a
                public void bm(int i, int i2) {
                    if (d.this.eSu != null) {
                        d.this.eSu.br(i, i2);
                    }
                }
            });
        }
    }

    private void biA() {
        if (this.eSR == null) {
            this.eSR = new com.baidu.tieba.ala.liveroom.h.e(bjJ().pageContext);
        }
        this.eSR.setRoomId(bjJ().fav.yO().mLiveInfo.room_id);
        this.eSR.zb("");
        this.eSR.a(bjJ().fav.yO(), this.eTp);
        if (this.eRy == null) {
            this.eRy = new com.baidu.tieba.ala.liveroom.h.b(bjJ().pageContext, xx(), this.eSR, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.8
                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void biX() {
                    d.this.iV(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void biY() {
                    d.this.iV(false);
                }
            });
        }
        this.eRy.setRoomId(bjJ().fav.yO().mLiveInfo.room_id);
        if (this.eRq != null && this.eRq.indexOfChild(this.eRy.getView()) >= 0) {
            this.eRq.removeView(this.eRy.getView());
        }
        if (this.eRy != null) {
            this.eRy.b(bjJ());
        }
    }

    private ViewGroup.LayoutParams biB() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.topMargin = (ScreenHelper.getRealScreenHeight(bjJ().pageContext.getPageActivity()) - this.eTr.getTop()) - bjJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds814);
        return layoutParams;
    }

    private void biD() {
        CustomResponsedMessage runTask;
        if (this.eSe == null && (runTask = MessageManager.getInstance().runTask(2913039, com.baidu.live.im.i.class, bjJ().pageContext)) != null && runTask.getData() != null) {
            this.eSe = (com.baidu.live.im.i) runTask.getData();
            this.eSe.setFromMaster(false);
            this.eSe.wq().getView().setId(a.g.ala_liveroom_msg_list);
            this.eSe.a(new i.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.9
                @Override // com.baidu.live.im.i.a
                public boolean ws() {
                    return d.this.uX();
                }

                @Override // com.baidu.live.im.i.a
                public void wt() {
                    d.this.eSK = true;
                }

                @Override // com.baidu.live.im.i.a
                public void dM(String str) {
                    if (!d.this.eSG) {
                        d.this.iT(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.bjJ().pageContext.getPageActivity(), d.this.bjJ().fau.getLiveContainerView());
                    }
                    d.this.yP(str);
                }

                @Override // com.baidu.live.im.i.a
                public void wu() {
                    if (d.this.eSG) {
                        d.this.iT(true);
                        d.this.bjJ().fau.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.bjJ().pageContext.getPageActivity(), d.this.bjJ().fau.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.eSe != null) {
                        d.this.eSe.wr().setQuickInputPanelVisible(false);
                        d.this.eSe.wr().xR();
                    }
                }

                @Override // com.baidu.live.im.i.a
                public void wv() {
                    if (d.this.eSG) {
                        d.this.biW();
                        if (d.this.eSf != null) {
                            d.this.eSf.wy();
                        }
                    }
                }

                @Override // com.baidu.live.im.i.a
                public boolean ww() {
                    return d.this.bjg();
                }
            });
            this.eRq = new FrameLayout(bjJ().pageContext.getPageActivity());
            this.eRq.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.eSe != null && this.eRq != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bjJ().pageContext.getPageActivity()) * 0.75f);
            int dimensionPixelSize = bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64) + ((int) (BdUtilHelper.getEquipmentHeight(bjJ().pageContext.getPageActivity()) * 0.27f));
            if (this.eSD.indexOfChild(this.eRq) < 0) {
                if (this.eRq.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eRq.getParent()).removeView(this.eRq);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds27) + dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
                this.eSD.addView(this.eRq, layoutParams);
            }
            if (this.eRq.indexOfChild(this.eSe.wq().getView()) < 0) {
                if (this.eSe.wq().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eSe.wq().getView()).removeView(this.eSe.wq().getView());
                }
                this.eRq.addView(this.eSe.wq().getView(), new FrameLayout.LayoutParams(equipmentWidth, dimensionPixelSize));
            }
            if (bjJ().faw.indexOfChild(this.eSe.wr().getView()) < 0) {
                if (this.eSe.wr().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eSe.wr().getView().getParent()).removeView(this.eSe.wr().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bjm();
                bjJ().faw.addView(this.eSe.wr().getView(), layoutParams2);
            }
            m yO = bjJ().fav.yO();
            if (yO != null && yO.mLiveInfo != null) {
                this.eSe.setLogData(yO.mLiveInfo.feed_id, xx());
            }
            this.eSe.e(String.valueOf(bjJ().fav.yO().mLiveInfo.group_id), String.valueOf(bjJ().fav.yO().mLiveInfo.last_msg_id), String.valueOf(bjJ().fav.yO().XQ.userId), String.valueOf(bjJ().fav.yO().mLiveInfo.live_id), bjJ().fav.yO().XQ.appId);
            iT(false);
        }
    }

    private void biF() {
        if (this.eRd == null) {
            this.eRd = new com.baidu.tieba.ala.liveroom.l.a(bjJ().pageContext, false, this);
        }
        this.eRd.c(this.eSC, bjJ().fav.yO());
        this.eRd.a(this.eRI);
        this.eRd.setOtherParams(xx());
    }

    private void biG() {
        if (this.eRc == null) {
            this.eRc = new com.baidu.tieba.ala.liveroom.audiencelist.c(bjJ().pageContext, this, false);
        }
        this.eRc.a(String.valueOf(bjJ().fav.yO().mLiveInfo.group_id), String.valueOf(bjJ().fav.yO().mLiveInfo.live_id), String.valueOf(bjJ().fav.yO().XQ.userId), bjJ().fav.yO());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.eRS != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.eRc.c(this.eSC, i, a.g.ala_liveroom_audience_count_layout);
            this.eRc.f(bjJ().fav.bdZ());
            this.eRc.setOtherParams(xx());
        }
    }

    private void biH() {
        if (this.eRg == null) {
            this.eRg = new com.baidu.tieba.ala.liveroom.operation.a(bjJ().pageContext);
        }
        this.eRg.a(bjJ(), this.eSD, bjJ().fav.yO().mLiveInfo.live_type, true, this.eRI);
        this.eRg.setOtherParams(xx());
    }

    public void ja(boolean z) {
        if (this.eRg != null) {
            this.eRg.ja(z);
        }
    }

    private void biI() {
        if (this.eRh == null) {
            this.eRh = new com.baidu.tieba.ala.liveroom.audiencelist.b(bjJ().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (bjJ().fav.bdZ() != null) {
            j = bjJ().fav.bdZ().getCount();
        }
        this.eRh.a(this.eRI);
        this.eRh.a(this.eSC, a.g.ala_liveroom_audience, j);
        this.eRh.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.eRh.ji(false);
        } else {
            this.eRh.ji(true);
        }
    }

    protected void yQ(String str) {
        if (this.eSQ == null) {
            this.eSQ = new com.baidu.tieba.ala.liveroom.q.b(bjJ().pageContext);
        }
        this.eSQ.b(this.eSD, str);
        iV(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.10
            @Override // java.lang.Runnable
            public void run() {
                d.this.eSQ.bqm();
                d.this.iV(false);
            }
        }, 5000L);
    }

    private void jb(boolean z) {
        CustomResponsedMessage runTask;
        if (bjJ().fav.yO().mLiveInfo.live_type == 1 && this.eTt) {
            if (this.eTs == null && (runTask = MessageManager.getInstance().runTask(2913074, f.class, bjJ().pageContext)) != null && runTask.getData() != null) {
                this.eTs = (f) runTask.getData();
            }
            if (this.eTs != null) {
                if (this.eRl == null) {
                    this.eRl = this.eTs.a(bjJ().pageContext);
                }
                if (bjJ().fav.yO().mLiveInfo.challengeId > 0 && !this.eRl.qb()) {
                    this.eRl.d(bjJ().fav.yO().mLiveInfo.live_id, bjJ().fav.yO().XQ.userId);
                    jc(z);
                    this.eRl.c(bjJ().fav.yO());
                }
            }
        }
    }

    private void jc(boolean z) {
        if (this.eRm == null) {
            this.eRm = this.eTs.b(bjJ().pageContext);
            this.eRm.a(new com.baidu.live.challenge.h() { // from class: com.baidu.tieba.ala.liveroom.c.d.11
                @Override // com.baidu.live.challenge.h
                public void pQ() {
                    d.this.bjJ().faw.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.h
                public void a(ad adVar, ae aeVar, ae aeVar2) {
                    d.this.eQi = true;
                    if (d.this.eRY != null) {
                        d.this.eRY.setPraiseEnable(false);
                        d.this.bjJ().faw.fnp = false;
                    }
                    if (d.this.eRi != null) {
                        d.this.eRi.setCanVisible(false);
                        d.this.eRi.bmh();
                    }
                    if (d.this.eRj != null) {
                        d.this.eRj.iM(true);
                    }
                    if (d.this.eSR != null) {
                        d.this.eSR.setVisible(8);
                    }
                    if (d.this.eRk != null) {
                        d.this.eRk.setCanVisible(false);
                        d.this.eRk.setVisible(8);
                    }
                    d.this.je(true);
                    d.this.jf(true);
                    if (d.this.bjJ().awj != null) {
                        d.this.bjJ().awj.getLivePlayer().setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                    }
                    if (d.this.eRW != null) {
                        d.this.eRW.setTimeTextMode(true);
                    }
                    if (d.this.awg != null && aeVar != null && aeVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(aeVar.abJ);
                        arrayList.add(aeVar2.abJ);
                        com.baidu.live.liveroom.a.b bVar = d.this.awg;
                        if (d.this.eSN) {
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
                    d.this.bjJ().faw.setSwipeClearEnable(true);
                    d.this.eQi = false;
                    if (d.this.eRY != null) {
                        d.this.eRY.setPraiseEnable(true);
                        d.this.bjJ().faw.fnp = true;
                    }
                    if (d.this.eRi != null) {
                        d.this.eRi.setCanVisible(true);
                        d.this.eRi.t(d.this.bjJ().fav.yO());
                    }
                    if (d.this.eSa != null) {
                        d.this.eSa.jR(true);
                    }
                    if (d.this.eRj != null) {
                        d.this.eRj.iM(false);
                    }
                    if (d.this.eSR != null) {
                        d.this.eSR.setVisible(0);
                    }
                    if (d.this.eRk != null) {
                        d.this.eRk.setCanVisible(true);
                        d.this.eRk.setVisible(0);
                    }
                    d.this.je(false);
                    d.this.jf(false);
                    if (d.this.awg != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.bjJ().fav.bpR());
                        com.baidu.live.liveroom.a.b bVar = d.this.awg;
                        if (d.this.eSN) {
                            arrayList = null;
                        }
                        bVar.j(arrayList);
                    }
                    if (d.this.bjJ().awj != null) {
                        d.this.bjJ().awj.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
                    }
                    if (d.this.eRW != null) {
                        d.this.eRW.setTimeTextMode(false);
                    }
                }
            });
        }
        this.eRm.a(this.eRl);
        this.eRm.e(bjJ().fau.getLiveContainerView());
        this.eRm.b(z, false, false);
        this.eRl.a((j.c) this.eRm);
    }

    private void jd(boolean z) {
        CustomResponsedMessage runTask;
        if (bjJ().fav.yO().mLiveInfo.live_type == 1 && com.baidu.live.v.a.zl().awC.ZU) {
            if (this.eRk == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bjJ().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.eRk = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.eRk != null) {
                this.eRk.a(bjJ().fav.bpT(), false, false);
                if (bjJ().fav.yO().mLiveInfo.pkId > 0 && this.eRk.getRootView() != null && this.eRk.getRootView().getParent() == null && this.eTr != null) {
                    if (this.eTr.getChildCount() <= 0) {
                        this.eTr.addView(this.eRk.getRootView(), new LinearLayout.LayoutParams(-2, -2));
                    } else {
                        View childAt = this.eTr.getChildAt(0);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.topMargin = bjJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                        childAt.setLayoutParams(layoutParams);
                        this.eTr.addView(this.eRk.getRootView(), 0, new LinearLayout.LayoutParams(-2, -2));
                    }
                }
                if (z) {
                    this.eRk.a(null, bjJ().fav.yO());
                } else {
                    this.eRk.b(bjJ().fav.yO());
                }
            }
        }
    }

    public void biJ() {
        this.eRT.c(bjJ().fav.yO(), false);
    }

    public void biK() {
        if (bjJ().fav.yO() != null && bjJ().fav.yO().XQ != null && bjJ().fav.yO().mLiveInfo != null) {
            if (this.eRf == null) {
                this.eRf = new com.baidu.tieba.ala.liveroom.r.b(bjJ().pageContext);
            }
            long j = bjJ().fav.yO().XQ.userId;
            int i = bjJ().fav.yO().mLiveInfo.live_type;
            String str = bjJ().fav.yO().XQ.portrait;
            String str2 = bjJ().fav.yO().mLiveInfo.feed_id;
            long j2 = bjJ().fav.yO().mLiveInfo.live_id;
            this.eRf.a(i, j, bjJ().fav.yO().XQ.userName, false, str, xx(), str2, j2);
            this.eRf.af(this.eSC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void je(boolean z) {
        if (this.eTp != null && this.eTr != null) {
            if (z) {
                this.eTp.setViewActionDispatched(false);
                this.eTr.setViewActionDispatched(true);
                ViewGroup.LayoutParams layoutParams = this.eTp.getLayoutParams();
                layoutParams.height = bjW();
                this.eTp.setLayoutParams(layoutParams);
                bit();
                return;
            }
            this.eTr.setViewActionDispatched(false);
            this.eTp.setViewActionDispatched(true);
            ViewGroup.LayoutParams layoutParams2 = this.eTp.getLayoutParams();
            layoutParams2.height = -2;
            this.eTp.setLayoutParams(layoutParams2);
            bjV();
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
        if (this.eRj != null) {
            ?? layoutParams = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams) layoutParams).gravity = 5;
            ?? r2 = this.eRj;
            ViewGroup viewGroup = z ? this.eTp : this.eRb;
            if (!z) {
                layoutParams = pQ(1);
            }
            r2.a(1, viewGroup, layoutParams, 21);
            this.eRj.updateView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bjW() {
        return (((bjJ().faw.getBottom() - (this.eRm != null ? this.eRm.au(false) : 0)) - (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0)) - bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biL() {
        if (bjJ() == null || bjJ().fav == null || bjJ().fav.yO() == null || bjJ().fav.yO().Ye == null) {
            if (bjJ().fav == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bjJ().fav.yO() == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bjJ().fav.yO().Ye == null) {
                Log.i("RenameLog", "getLiveContext().liveModel.getLiveShowData().mLoginUserInfo == null");
                return;
            } else {
                return;
            }
        }
        String str = bjJ().fav.yO().Ye.userName;
        Log.i("RenameLog", "loginUserName:" + str);
        if (str != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bjJ().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !bjf()) {
            com.baidu.live.c.pr().putInt("guide_rename_show_count", com.baidu.live.c.pr().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.ym().ba(true);
            if (this.eSx == null) {
                this.eSx = new com.baidu.tieba.ala.liveroom.s.a(bjJ().pageContext);
            }
            this.eSx.setOtherParams(xx());
            this.eSx.e(this.eSD, bjJ().fav.yO());
            iV(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.14
                @Override // java.lang.Runnable
                public void run() {
                    d.this.eSx.bqq();
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

    private void biM() {
        boolean z = false;
        if (this.eSa == null) {
            this.eSa = new com.baidu.tieba.ala.liveroom.u.a(bjJ().pageContext, this);
        }
        this.eSa.d(bjJ().faw, false);
        if (bjI() && bjJ().fav.yO().mLiveInfo.screen_direction != 2) {
            z = true;
        }
        this.eSa.jQ(z);
    }

    private void biO() {
        if (this.eSK || this.eSL) {
            if ((TbadkCoreApplication.isLogin() && this.eSe.wr().hasText()) || this.eSL) {
                this.eSK = false;
                this.eSL = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.15
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bjl();
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
                if (this.eRi != null) {
                    this.eRi.u(jSONObject);
                }
            } else if ("enter_live".equals(optString)) {
                if (this.eRh.getCount() > 20) {
                    this.eRh.cD(this.eRh.getCount() + 1);
                } else if (this.eRc != null) {
                    com.baidu.live.data.a xo = aVar.xo();
                    com.baidu.live.data.g gVar = new com.baidu.live.data.g();
                    gVar.XR = new AlaLocationData();
                    gVar.XS = new AlaRelationData();
                    gVar.XQ = new AlaLiveUserInfoData();
                    gVar.XQ.userId = JavaTypesHelper.toLong(xo.userId, 0L);
                    gVar.XQ.userName = xo.userName;
                    gVar.XQ.portrait = xo.portrait;
                    if (this.eRc.c(gVar)) {
                        this.eRh.cD(this.eRh.getCount() + 1);
                    }
                }
            } else if ("update_liveinfo".equals(optString) && bjJ().fav.yO() != null && bjJ().fav.yO().mLiveInfo != null) {
                bjJ().fav.a(bjJ().fav.yO().mLiveInfo.live_id, bjJ().fromType, bjJ().enterTime);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void yL(String str) {
        if (this.eRj != null) {
            this.eRj.yL(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void bf(boolean z) {
        super.bf(z);
        if (bjJ().faw != null) {
            bjJ().faw.brb();
            bjJ().faw.setLiveViewOnDispatchTouchEventListener(null);
            bjJ().faw.setOnLiveViewScrollListener(null);
        }
        if (bjJ().awj != null) {
            bjJ().awj.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.eRm != null) {
            this.eRm.pK();
        }
        biP();
        if (this.eRf != null) {
            this.eRf.pK();
        }
        if (this.eSa != null) {
            this.eSa.release();
        }
        if (this.eRi != null) {
            this.eRi.pK();
        }
        if (this.eRg != null) {
            this.eRg.bpW();
        }
        if (this.eRe != null) {
            this.eRe.blv();
            this.eRe.setVisible(8);
        }
        if (this.eRk != null) {
            this.eRk.pK();
        }
        if (this.eRj != null) {
            this.eRj.release();
        }
        if (this.eTr != null) {
            this.eTr.setViewActionDispatched(false);
            this.eTr.removeAllViews();
            this.eTr = null;
        }
        if (this.eTp != null) {
            this.eTp.setViewActionDispatched(false);
            this.eTp.removeAllViews();
            this.eTp = null;
        }
        if (this.eRb != null) {
            this.eRb.removeAllViews();
            this.eRb = null;
        }
        if (this.eSa != null) {
            this.eSa.onDestroy();
        }
        if (this.eRl != null) {
            this.eRl.pK();
        }
        if (this.eRy != null) {
            this.eRy.cancel();
        }
        if (this.eSR != null) {
            this.eSR.bkA();
        }
        if (this.eRy != null) {
            this.eRy.pK();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void be(boolean z) {
        super.be(z);
        biP();
        if (this.eRd != null) {
            this.eRd.onDestroy();
        }
        if (this.eRf != null) {
            this.eRf.onDestroy();
        }
        if (this.eRi != null) {
            this.eRi.onDestroy();
        }
        if (this.eRk != null) {
            this.eRk.onDestroy();
        }
        if (this.eRl != null) {
            this.eRl.onDestroy();
        }
        if (this.eRm != null) {
            this.eRm.onDestroy();
        }
        if (this.eRn != null) {
            this.eRn.onDestroy();
        }
        if (this.eSm != null) {
            this.eSm.onDestroy();
        }
        if (this.eRe != null) {
            this.eRe.onDestroy();
        }
        if (this.eRc != null) {
            this.eRc.onDestroy();
        }
        if (this.eSe != null) {
            this.eSe.onDestroy();
        }
        if (this.eRg != null) {
            this.eRg.onDestory();
        }
        if (this.eRj != null) {
            this.eRj.release();
        }
        if (this.eSR != null) {
            this.eSR.be(!z);
        }
        MessageManager.getInstance().removeMessageRule(this.eRz);
        MessageManager.getInstance().removeMessageRule(this.eRA);
        MessageManager.getInstance().unRegisterListener(this.eRC);
        MessageManager.getInstance().unRegisterListener(this.eRD);
        MessageManager.getInstance().unRegisterListener(this.eTv);
        MessageManager.getInstance().unRegisterListener(this.eRF);
        MessageManager.getInstance().unRegisterListener(this.eRG);
        MessageManager.getInstance().unRegisterListener(this.eTu);
        MessageManager.getInstance().unRegisterListener(this.eRH);
        MessageManager.getInstance().unRegisterListener(this.eRE);
    }

    private void biP() {
        if (this.eSe != null && this.eSe.wq().getView() != null && this.eSe.wq().getView().getParent() != null) {
            ((ViewGroup) this.eSe.wq().getView().getParent()).removeView(this.eSe.wq().getView());
        }
        if (this.eRq != null && this.eRq.getParent() != null) {
            ((ViewGroup) this.eRq.getParent()).removeView(this.eRq);
        }
        if (this.eSe != null && this.eSe.wr().getView() != null) {
            this.eSD.removeView(this.eSe.wr().getView());
        }
        if (this.eSe != null) {
            this.eSe.wq().setMsgData(new LinkedList());
            this.eSe.vW();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void a(com.baidu.live.data.x xVar) {
        if (this.eSe != null) {
            bjl();
            this.eSe.wr().setEditText(" @" + xVar.getNameShow() + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.eRg != null) {
            this.eRg.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void f(com.baidu.live.data.a aVar) {
        if (this.eSe != null) {
            bjl();
            this.eSe.wr().setEditText(" @" + aVar.userName + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.eRg != null) {
            this.eRg.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void b(com.baidu.live.data.x xVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected View biQ() {
        if (this.eSe != null) {
            return this.eSe.wr().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean biR() {
        if (this.eSe == null || !this.eSe.wr().xQ()) {
            return false;
        }
        iT(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean biS() {
        return this.eRd == null || this.eRd.biS();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup biT() {
        return this.eTr;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup biU() {
        return this.eRb;
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
                    this.eSH = false;
                    J(intExtra, intExtra2, intExtra3);
                    return;
                }
                biJ();
                return;
            }
            bjH();
        } else if (i == 25051 && i2 == -1 && this.eSR != null) {
            this.eSR.blX();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.eSe != null && this.eSe.wq() != null) {
            this.eSe.wq().onKeyboardVisibilityChanged(z);
        }
        if (z || this.eSe == null || !this.eSe.wr().xQ()) {
            if (z) {
                if (this.eRg != null) {
                    this.eRg.setVisibility(8);
                }
                if (this.eSg != null && this.eSg.sl() != null) {
                    this.eSg.sl().setVisibility(8);
                }
                biW();
                if (this.eSe != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eSe.wr().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.eSe.wr().getView().setLayoutParams(layoutParams);
                    this.eSe.wr().getView().setVisibility(0);
                    this.eSe.wr().setQuickInputPanelVisible(false);
                }
                if (this.eSC != null) {
                    this.eSC.setVisibility(8);
                }
                if (this.eRj != null) {
                    this.eRj.setVisible(8);
                }
                if (this.eSf != null) {
                    this.eSf.wy();
                }
                if (this.eSB != null) {
                    this.eSB.setCanVisible(false);
                }
            } else {
                biV();
            }
            if (this.eSe != null && this.eRq != null) {
                int equipmentHeight = (int) (((z ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(bjJ().pageContext.getPageActivity())) + bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
                if (this.eSD.indexOfChild(this.eRq) != -1 && this.eRq.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eRq.getLayoutParams();
                    layoutParams2.height = bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds27) + equipmentHeight;
                    this.eRq.setLayoutParams(layoutParams2);
                }
                if (this.eRq.indexOfChild(this.eSe.wq().getView()) != -1 && this.eSe.wq().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.eSe.wq().getView().getLayoutParams();
                    layoutParams3.height = equipmentHeight;
                    this.eSe.wq().getView().setLayoutParams(layoutParams3);
                }
                this.eSe.wq().wp();
            }
            if (this.eSr != null) {
                this.eSr.aA(z);
            }
        }
    }

    private void biV() {
        if (this.eRg != null) {
            this.eRg.setVisibility(0);
        }
        if (this.eRq != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRq.getLayoutParams();
            layoutParams.bottomMargin = bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
            this.eRq.setLayoutParams(layoutParams);
        }
        if (this.eSe != null) {
            bjm();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eSe.wr().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.eSe.wr().getView().setLayoutParams(layoutParams2);
        }
        if (this.eRg != null) {
            this.eRg.setVisibility(0);
        }
        if (this.eSg != null && this.eSg.sl() != null) {
            this.eSg.sl().setVisibility(0);
        }
        if (this.eSC != null) {
            this.eSC.setVisibility(0);
        }
        if (this.eRj != null) {
            this.eRj.setVisible(0);
        }
        if (this.eSf != null) {
            this.eSf.wy();
        }
        if (this.eSB != null) {
            this.eSB.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biW() {
        if (this.eRq != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRq.getLayoutParams();
            boolean z = false;
            if (this.eSe != null && this.eSe.wr() != null) {
                z = this.eSe.wr().xP();
            }
            int iX = iX(z);
            if (layoutParams.bottomMargin != iX) {
                layoutParams.bottomMargin = iX;
                this.eRq.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iT(boolean z) {
        if (z) {
            this.eSe.wr().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRq.getLayoutParams();
            int quickInputPanelExpandHeight = this.eSe.wr().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.eRq.setLayoutParams(layoutParams);
                if (this.eSe.wq() != null) {
                    this.eSe.wq().wp();
                    return;
                }
                return;
            }
            return;
        }
        biV();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void j(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.eRc != null) {
                this.eRc.bW(i3);
            }
            if (this.eRe != null) {
                this.eRe.bW(i3);
            }
        }
        super.j(i, i2, i3);
        if (this.eQi && this.eTp != null) {
            this.eTp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.16
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (d.this.eTp != null && (layoutParams = d.this.eTp.getLayoutParams()) != null) {
                        int i4 = layoutParams.height;
                        int bjW = d.this.bjW();
                        if (bjW != i4) {
                            layoutParams.height = bjW;
                            d.this.eTp.setLayoutParams(layoutParams);
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
            if (this.eRd.biS()) {
                return false;
            }
            if (cc && this.eSa != null) {
                this.eSa.jR(false);
            }
        }
        return cc;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void pR(int i) {
        super.pR(i);
        if (i == 7 || i == 11) {
            if (this.eRg != null) {
                this.eRg.setVisibility(8);
            }
            if (this.eSe != null) {
                this.eSe.wq().getView().setVisibility(4);
            }
            if (this.eRj != null) {
                this.eRj.bj(2, 8);
                if (this.eQi) {
                    this.eRj.bj(1, 8);
                }
            }
            if (this.eSu != null) {
                this.eSu.jM(false);
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
            if (this.eRg != null) {
                this.eRg.setVisibility(0);
            }
            if (this.eSe != null) {
                this.eSe.wq().getView().setVisibility(0);
            }
            if (this.eRj != null) {
                this.eRj.setVisible(0);
            }
            if (this.eSu != null) {
                this.eSu.jM(true);
            }
            this.eSC.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.eRf != null) {
            this.eRf.bqo();
        }
        if (this.eRl != null) {
            this.eRl.pU();
        }
        if (this.eRj != null) {
            this.eRj.onStop();
        }
        if (this.eRk != null) {
            this.eRk.ar(true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.eRf != null) {
            this.eRf.bqn();
        }
        if (this.eRl != null && this.eTt) {
            this.eRl.pV();
        }
        if (this.eRj != null) {
            this.eRj.onStart();
        }
        if (this.eRk != null) {
            this.eRk.ar(false);
        }
    }

    private ViewGroup.LayoutParams jg(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.eTr == null) {
            return null;
        }
        int bjW = this.eQi ? bjW() : -2;
        ViewGroup.LayoutParams layoutParams2 = this.eTr.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, bjW);
        }
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds112);
        layoutParams.topMargin = bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200);
        return layoutParams;
    }

    private ViewGroup.LayoutParams bjX() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.eTp == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams2 = this.eTp.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
        return layoutParams;
    }
}
