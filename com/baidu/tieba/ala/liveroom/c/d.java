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
    private boolean eQG;
    private com.baidu.tieba.ala.liveroom.audiencelist.c eRA;
    private com.baidu.tieba.ala.liveroom.l.a eRB;
    private com.baidu.tieba.ala.liveroom.e.b eRC;
    private com.baidu.tieba.ala.liveroom.r.b eRD;
    private com.baidu.tieba.ala.liveroom.operation.a eRE;
    private com.baidu.tieba.ala.liveroom.audiencelist.b eRF;
    private com.baidu.tieba.ala.liveroom.j.a eRG;
    private com.baidu.tieba.ala.liveroom.activeview.b eRH;
    private com.baidu.live.d.a eRI;
    private j eRJ;
    private i eRK;
    private com.baidu.tieba.ala.liveroom.attentionpop.b eRL;
    private FrameLayout eRO;
    private com.baidu.tieba.ala.liveroom.h.b eRW;
    private LinearLayout eRz;
    private DispatchedPvlLayout eTN;
    private View eTO;
    private DispatchedRelativeLayout eTP;
    private f eTQ;
    private long lastClickTime = 0;
    private boolean eTR = false;
    private HttpRule eRX = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.eRJ != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.eRJ.qf()) {
                httpMessage.addParam("ala_challenge_id", d.this.eRJ.qi());
            }
            return httpMessage;
        }
    };
    private HttpRule eRY = new HttpRule(1021151) { // from class: com.baidu.tieba.ala.liveroom.c.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.eRJ != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.eRJ.qf()) {
                httpMessage.addParam("challenge_id", d.this.eRJ.qi());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c eRZ = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.c.d.17
        @Override // com.baidu.live.liveroom.g.c
        public void yR() {
            if (d.this.eSy != null) {
                d.this.eSy.jT(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bg(boolean z) {
            if (z) {
                if (d.this.eRE != null) {
                    d.this.eRE.qB(8);
                }
                if (d.this.eSy != null) {
                    d.this.eSy.jT(true);
                }
            } else {
                if (d.this.eRE != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                        d.this.eRE.qB(0);
                    } else {
                        d.this.eRE.qB(8);
                    }
                }
                if (d.this.eSy != null) {
                    d.this.eSy.jT(false);
                }
            }
            if (d.this.eSP != null) {
                d.this.eSP.aB(z);
            }
        }
    };
    private HttpMessageListener eSa = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.d.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.zb() != null) {
                        com.baidu.live.v.c.zx().ayb = getQuickGiftHttpResponseMessage.zb();
                        d.this.biH();
                    }
                }
            }
        }
    };
    private CustomMessageListener eSb = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.d.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.biQ();
        }
    };
    CustomMessageListener eSf = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.c.d.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.eRW.c(d.this.bjO());
                } else if (d.this.bjk() || !g.qc(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, 3000L);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.bjO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.bjO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    d.this.eRW.b(d.this.eRO, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener eTS = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.c.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.bjk() || !g.qc(2913128)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.21.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.qa(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, 3000L);
                } else {
                    d.this.yQ(str);
                }
            }
        }
    };
    private CustomMessageListener eTT = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.c.d.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.eSF.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eSc = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.c.d.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.this.eST != null) {
                    d.this.eST.yS(str);
                }
            }
        }
    };
    CustomMessageListener eSd = new CustomMessageListener(CmdConfigCustom.CMD_HOST_GET_WALLET_UA) { // from class: com.baidu.tieba.ala.liveroom.c.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.eTh != null && d.this.eTh.aqi != null && !d.this.eTh.aql && !d.this.eTh.aqm && d.this.eSO != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.bjO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = d.this.bjO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                d.this.eSO.b(d.this.eRO, layoutParams);
                if (e.vL() != null) {
                    e.vL().vR();
                }
            }
        }
    };
    private CustomMessageListener eSe = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.eSR != null) {
                    d.this.eSR.dismiss();
                }
                if (d.this.eST != null) {
                    d.this.eST.dismiss();
                }
                k.wF().setSwitchStatus(true);
                k.wF().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bjq();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b eSg = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.d.13
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
                        alaStaticItem.addParams("gifts_value", com.baidu.live.v.c.zx().ayb.sz().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.v.c.zx().ayb.sz().rC());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.v.c.zx().ayb.sz().rD());
                        if (d.this.bjO().faT.yT() != null && d.this.bjO().faT.yT().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.bjO().faT.yT().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.bjO().faT.yT().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.xC());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.vc()) {
                        if (com.baidu.live.c.pw().getBoolean("quick_gift_guide_show", true) && !d.this.bjk()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, x.class, d.this.bjO().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                x xVar = (x) runTask.getData();
                                xVar.setPageContext(d.this.bjO().pageContext);
                                xVar.d(d.this.bjO().faT.yT());
                                xVar.a(com.baidu.live.v.c.zx().ayb.sz());
                                xVar.setOtherParams(d.this.xC());
                                xVar.initView();
                                xVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.d.13.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        d.this.iX(false);
                                    }
                                });
                                xVar.show();
                                d.this.iX(true);
                                return;
                            }
                            return;
                        }
                        n.a(d.this.bjO().pageContext, d.this.bjO().faT.yT(), com.baidu.live.v.c.zx().ayb.sz(), d.this.xC());
                    }
                } else if (i == 1) {
                    if (d.this.eSC != null) {
                        d.this.bjq();
                    }
                } else if (i == 3 && d.this.vc()) {
                    d.this.eSr.c(d.this.bjO().faT.yT(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.bjO() != null && d.this.bjO().faT != null && d.this.bjO().faT.yT() != null && d.this.bjO().faT.yT().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.bjO().faT.yT().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.bjO().faT.yT().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.bjO().faT.yT().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.xC());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.bjO() != null && d.this.bjO().faT != null && d.this.bjO().faT.yT() != null && d.this.bjO().faT.yT().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.bjO().faT.yT().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.bjO().faT.yT().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.bjO().faT.yT().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.xC());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.awq != null) {
                        d.this.awq.bb(false);
                    }
                } else if (i == 12) {
                    if (d.this.eSy != null) {
                        String valueOf = String.valueOf(d.this.bjO().faT.yT().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.bjO().faT.yT().mLiveInfo.room_id);
                        String str2 = null;
                        com.baidu.live.data.k kVar = d.this.bjO().faT.yT().mLiveSdkInfo;
                        if (kVar != null && kVar.mCastIds != null) {
                            str2 = String.valueOf(d.this.bjO().faT.yT().mLiveSdkInfo.mCastIds.Yh);
                        }
                        d.this.eSy.ad(valueOf, valueOf2, str2);
                        if (com.baidu.live.liveroom.a.yr().ys()) {
                            d.this.biQ();
                        }
                    }
                } else if (i == 14) {
                    m yT = d.this.bjO().faT.yT();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.bjO().pageContext.getPageActivity(), yT.Ya.userName, Long.toString(yT.Ya.userId), Long.toString(yT.Ya.charmCount), String.valueOf(yT.mLiveInfo.group_id), String.valueOf(yT.mLiveInfo.live_id), false, String.valueOf(yT.Ya.userId), Long.toString(yT.Yo.userId), yT.Yo.userName, yT.Yo.portrait, d.this.eRF.getCount(), d.this.xC())));
                    LogManager.getCommonLogger().doClickGusetNumLog(yT.mLiveInfo.feed_id, d.this.eRF.getCount() + "", d.this.xC());
                } else if (i == 11) {
                    d.this.bjt();
                    d.this.bju();
                } else if (i == 15) {
                    if (d.this.eSM != null && d.this.bjO() != null && d.this.bjO().faT != null && d.this.bjO().faT.yT() != null && d.this.bjO().faT.yT().mLiveInfo != null) {
                        long j = d.this.bjO().faT.yT().mLiveInfo.live_id;
                        String valueOf3 = String.valueOf(d.this.bjO().faT.yT().mLiveInfo.feed_id);
                        long j2 = d.this.bjO().faT.yT().mLiveInfo.room_id;
                        String str3 = d.this.bjO().faT.yT().mLiveInfo.cover;
                        String str4 = "";
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        if (d.this.bjO().faT.yT().mLiveInfo.session_info != null) {
                            str4 = d.this.bjO().faT.yT().mLiveInfo.session_info.flvUrl;
                        }
                        if (!TextUtils.isEmpty(d.this.xC())) {
                            try {
                                JSONObject jSONObject = new JSONObject(d.this.xC());
                                str5 = jSONObject.optString("tab");
                                str6 = jSONObject.optString("tag");
                                str7 = jSONObject.optString("source");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        d.this.eSM.yS(o.a(valueOf3, j + "", j2, false, 1, str3, str4, str5, str6, str7));
                        o.aEf = j;
                        if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                            ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                            LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf3, d.this.xC());
                        }
                    }
                } else if (i == 16) {
                    if (d.this.bjO() != null && (apVar2 = com.baidu.live.v.a.zs().axR) != null && (ayVar2 = apVar2.adc) != null) {
                        String str8 = ayVar2.adZ.aeg;
                        if (!TextUtils.isEmpty(str8)) {
                            long j3 = 0;
                            if (d.this.bjO().faT != null && d.this.bjO().faT.yT() != null && d.this.bjO().faT.yT().mLiveInfo != null) {
                                j3 = d.this.bjO().faT.yT().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j3 + "", d.this.bjO().faT.yT().mLiveInfo.room_id + "", d.this.bjO().faT.yT().mLiveInfo.feed_id, d.this.xC());
                            }
                            if (str8.contains("?")) {
                                str = str8 + "&liveId=" + j3;
                            } else {
                                str = str8 + "?liveId=" + j3;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.bjO().pageContext.getPageActivity(), str);
                        }
                    }
                } else if (i == 17 && d.this.vc() && d.this.bjO() != null && (apVar = com.baidu.live.v.a.zs().axR) != null && (ayVar = apVar.adc) != null && (beVar = ayVar.aea) != null && !TextUtils.isEmpty(beVar.webUrl) && d.this.eSR != null && d.this.bjO().faT != null && d.this.bjO().faT.yT() != null) {
                    m yT2 = d.this.bjO().faT.yT();
                    d.this.eSR.a(beVar.webUrl, yT2.mLiveInfo.live_id, yT2.Yo.userId, yT2.Ya.userId);
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.eSt = new com.baidu.tieba.ala.liveroom.guide.c(bjO().pageContext, this, false);
        this.eRX.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.eRX);
        this.eRY.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.eRY);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean bis() {
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void k(m mVar) {
        super.k(mVar);
        g.bmh();
        this.eTR = true;
        bjO().faU.setIsForceHandledTouch(false);
        bjO().faU.setSwipeClearEnable(true);
        bjO().faU.setOnLiveViewScrollListener(this.eRZ);
        if (this.eSw != null) {
            this.eSw.b(this.eSg);
        }
        if (this.eTa != null) {
            this.eTa.setVisibility(0);
        }
        biw();
        biz();
        biK();
        bjg();
        biL();
        biN();
        biM();
        iT(false);
        bjx();
        bjw();
        biB();
        biI();
        bjz();
        biP();
        biR();
        jf(true);
        bjY();
        bjZ();
        iY(false);
        bjF();
        biA();
        biH();
        biC();
        biD();
        biE();
        biF();
        jd(true);
        bjE();
        MessageManager.getInstance().registerListener(this.eSa);
        MessageManager.getInstance().registerListener(this.eSb);
        MessageManager.getInstance().registerListener(this.eTT);
        MessageManager.getInstance().registerListener(this.eSd);
        MessageManager.getInstance().registerListener(this.eSe);
        MessageManager.getInstance().registerListener(this.eTS);
        MessageManager.getInstance().registerListener(this.eSf);
        MessageManager.getInstance().registerListener(this.eSc);
        biT();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void i(m mVar) {
        super.i(mVar);
        if (this.eRB != null) {
            this.eRB.u(mVar);
        }
        if (this.eRC != null) {
            this.eRC.q(mVar);
        }
        if (this.eRG != null) {
            this.eRG.t(mVar);
        }
        if (this.eRK != null) {
            this.eRK.a(mVar);
        }
        jf(false);
        jd(false);
        if (this.eRH != null) {
            this.eRH.h(mVar);
            this.eRH.iP(this.eTk);
            this.eRH.updateView();
            if (mVar != null && this.eSY != null && !this.eSY.hasInit && !TextUtils.isEmpty(this.eSY.adw)) {
                this.eSY.hasInit = true;
                this.eRH.yM(this.eSY.adw);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(h hVar) {
        if (hVar != null) {
            if (this.eRA != null && hVar.getList() != null) {
                this.eRA.f(hVar);
            }
            if (this.eRF != null) {
                this.eRF.cD(hVar.getCount());
            }
        }
    }

    private void biu() {
        if (this.eSx != null) {
            this.eSx.aj(bjO().faS.getLiveContainerView());
        }
    }

    private void bjY() {
        if (this.eRL == null) {
            this.eRL = new com.baidu.tieba.ala.liveroom.attentionpop.b(bjO().pageContext);
        }
        if (bjO().faT != null && bjO().faT.yT() != null && bjO().faT.yT().mLiveInfo != null) {
            this.eRL.yN(String.valueOf(bjO().faT.yT().mLiveInfo.user_id));
        }
    }

    private void bjZ() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (bjO() != null && bjO().faT != null && bjO().faT.yT() != null && bjO().faT.yT().mLiveInfo != null) {
                j = bjO().faT.yT().mLiveInfo.room_id;
            }
            if (this.eSK == null) {
                this.eSK = new com.baidu.tieba.ala.liveroom.guide.a(bjO().pageContext, j);
            }
            this.eSK.iW(this.eTd);
            this.eSK.a(new a.InterfaceC0459a() { // from class: com.baidu.tieba.ala.liveroom.c.d.4
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0459a
                public void bkd() {
                    if (d.this.awq != null) {
                        d.this.awq.bb(true);
                    }
                }
            });
            this.eSK.ag(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bk(int i) {
        super.bk(i);
        biu();
        if (this.eRK != null) {
            this.eRK.bk(i);
        }
    }

    private void biw() {
        if (this.eTP == null) {
            this.eTP = new DispatchedRelativeLayout(bjO().pageContext.getPageActivity());
            this.eTP.setViewActionDispatched(false);
            this.eTP.setViewActionDispatchListener(new com.baidu.live.view.dispatch.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.5
                @Override // com.baidu.live.view.dispatch.a
                public boolean W(View view) {
                    return (d.this.eTN == null || d.this.eTN.BB() || view == null || !(view.getTag(a.g.sdk_pvl_layout_priority_tag_key) instanceof Integer)) ? false : true;
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewAdded(View view) {
                    view.setTag(a.g.ala_live_room_vertival_widgets_bk_lp_key, view.getLayoutParams());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(view.getLayoutParams().width, view.getLayoutParams().height);
                    layoutParams.gravity = 5;
                    view.setLayoutParams(layoutParams);
                    if (d.this.eTN != null) {
                        d.this.eTN.addView(view);
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewRemoved(View view) {
                    if (d.this.eTN != null) {
                        d.this.eTN.removeView(view);
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public void BD() {
                    if (d.this.eTN != null && !d.this.eTN.BB()) {
                        d.this.eTN.removeAllViews();
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public int indexOfChild(View view) {
                    if (d.this.eTN != null) {
                        return d.this.eTN.indexOfChild(view);
                    }
                    return 0;
                }
            });
        }
        if (this.eTP.getParent() == null) {
            bjO().faU.addView(this.eTP, ji(false));
        }
        if (this.eTN == null) {
            this.eTN = new DispatchedPvlLayout(bjO().pageContext.getPageActivity());
            this.eTN.setDefaultItemMargin(bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.eTN.setViewActionDispatched(false);
            this.eTN.setViewActionDispatchListener(new com.baidu.live.view.dispatch.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.6
                @Override // com.baidu.live.view.dispatch.a
                public boolean W(View view) {
                    return (d.this.eTP == null || d.this.eTP.BB() || view == null || !(view.getTag(a.g.ala_live_room_vertival_widgets_bk_lp_key) instanceof ViewGroup.LayoutParams)) ? false : true;
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewAdded(View view) {
                    view.setLayoutParams(new LinearLayout.LayoutParams(view.getLayoutParams().width, view.getLayoutParams().height));
                    d.this.eTP.addView(view, (ViewGroup.LayoutParams) view.getTag(a.g.ala_live_room_vertival_widgets_bk_lp_key));
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewRemoved(View view) {
                    d.this.eTP.removeView(view);
                }

                @Override // com.baidu.live.view.dispatch.a
                public void BD() {
                    if (d.this.eTP != null && !d.this.eTP.BB()) {
                        d.this.eTP.removeAllViews();
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public int indexOfChild(View view) {
                    return d.this.eTP.indexOfChild(view);
                }
            });
        }
        if (this.eTN.getParent() == null) {
            bjO().faU.addView(this.eTN, bkc());
        }
    }

    private void biy() {
        if (this.eTO == null) {
            this.eTO = new View(bjO().pageContext.getPageActivity());
            this.eTO.setTag(a.g.sdk_pvl_layout_priority_tag_key, 20);
        }
        if (this.eTO.getParent() == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(1, 0);
            layoutParams.weight = 1.0f;
            this.eTN.addView(this.eTO, layoutParams);
        }
    }

    private void bka() {
        if (this.eTO != null) {
            this.eTN.removeView(this.eTO);
        }
    }

    private void biz() {
        if (this.eRz == null) {
            this.eRz = new LinearLayout(bjO().pageContext.getPageActivity());
            this.eRz.setOrientation(1);
        }
        if (this.eRz.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds160);
            layoutParams.leftMargin = bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bjO().faU.addView(this.eRz, layoutParams);
        }
    }

    private void biB() {
        if (this.eSv != null && bjO() != null && bjO().faT != null) {
            this.eSv.b(this.eTa, bjO().faT.yT());
        }
    }

    private void biA() {
        if (this.eRH == null) {
            this.eRH = new com.baidu.tieba.ala.liveroom.activeview.b(bjO().pageContext);
        }
        this.eRH.iO(this.eQG);
        this.eRH.setOtherParams(xC());
        this.eRH.b(bjO().faT.yT(), false);
        this.eRH.setHost(false);
        this.eRH.iP(this.eTk);
        this.eRH.a(1, this.eRz, pS(1));
        this.eRH.a(2, this.eTN, pS(2));
        this.eRH.setVisible(this.eTe ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biH() {
        if (this.eRE == null) {
            biM();
        }
        this.eRE.setOtherParams(xC());
        this.eRE.a(com.baidu.live.v.c.zx().ayb, bjO().faT.yT());
    }

    private ViewGroup.LayoutParams pS(int i) {
        switch (i) {
            case 1:
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (this.eRz == null || this.eRz.getChildCount() == 0) {
                    return layoutParams;
                }
                layoutParams.topMargin = bjO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                return layoutParams;
            case 2:
                ViewGroup.LayoutParams layoutParams2 = this.eTP.getLayoutParams();
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(((int) (BdUtilHelper.getEquipmentWidth(bjO().pageContext.getPageActivity()) * 0.25f)) - ((layoutParams2 instanceof LinearLayout.LayoutParams ? ((LinearLayout.LayoutParams) layoutParams2).rightMargin : 0) * 2), -2);
                layoutParams3.gravity = 5;
                return layoutParams3;
            default:
                return new RelativeLayout.LayoutParams(-2, -2);
        }
    }

    private void biC() {
        if (this.eRG == null) {
            this.eRG = new com.baidu.tieba.ala.liveroom.j.a(bjO().pageContext, this);
        }
        this.eRG.setOtherParams(xC());
        this.eRG.d(this.eTP, biG());
        this.eRG.t(bjO().faT.yT());
    }

    private void biD() {
        if (this.eSO == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, com.baidu.live.guardclub.j.class, bjO().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.eSO = (com.baidu.live.guardclub.j) runTask.getData();
            } else {
                return;
            }
        }
        this.eSO.setOtherParams(xC());
        if (this.eRO != null && this.eRO.indexOfChild(this.eSO.getView()) >= 0) {
            this.eRO.removeView(this.eSO.getView());
        }
    }

    private void biE() {
        if (this.eRE != null) {
            this.eRE.a(new a.InterfaceC0465a() { // from class: com.baidu.tieba.ala.liveroom.c.d.7
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0465a
                public void bm(int i, int i2) {
                    m yT = d.this.bjO().faT.yT();
                    if (yT != null && yT.mLiveInfo != null) {
                        if (d.this.eSS == null) {
                            d.this.eSS = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.bjO().pageContext.getPageActivity());
                        }
                        d.this.eSS.d(d.this.eTb, i, i2);
                        d.this.eSS.a(String.valueOf(yT.mLiveInfo.live_id), new a.InterfaceC0467a() { // from class: com.baidu.tieba.ala.liveroom.c.d.7.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0467a
                            public void a(float f, String str) {
                                if (d.this.eRE != null) {
                                    d.this.eRE.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0465a
                public void bn(int i, int i2) {
                    if (d.this.eSS != null) {
                        d.this.eSS.bs(i, i2);
                    }
                }
            });
        }
    }

    private void biF() {
        if (this.eTp == null) {
            this.eTp = new com.baidu.tieba.ala.liveroom.h.e(bjO().pageContext);
        }
        this.eTp.setRoomId(bjO().faT.yT().mLiveInfo.room_id);
        this.eTp.zb("");
        this.eTp.a(bjO().faT.yT(), this.eTN);
        if (this.eRW == null) {
            this.eRW = new com.baidu.tieba.ala.liveroom.h.b(bjO().pageContext, xC(), this.eTp, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.8
                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void bjc() {
                    d.this.iX(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void bjd() {
                    d.this.iX(false);
                }
            });
        }
        this.eRW.setRoomId(bjO().faT.yT().mLiveInfo.room_id);
        if (this.eRO != null && this.eRO.indexOfChild(this.eRW.getView()) >= 0) {
            this.eRO.removeView(this.eRW.getView());
        }
        if (this.eRW != null) {
            this.eRW.b(bjO());
        }
    }

    private ViewGroup.LayoutParams biG() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.topMargin = (ScreenHelper.getRealScreenHeight(bjO().pageContext.getPageActivity()) - this.eTP.getTop()) - bjO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds814);
        return layoutParams;
    }

    private void biI() {
        CustomResponsedMessage runTask;
        if (this.eSC == null && (runTask = MessageManager.getInstance().runTask(2913039, com.baidu.live.im.i.class, bjO().pageContext)) != null && runTask.getData() != null) {
            this.eSC = (com.baidu.live.im.i) runTask.getData();
            this.eSC.setFromMaster(false);
            this.eSC.wv().getView().setId(a.g.ala_liveroom_msg_list);
            this.eSC.a(new i.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.9
                @Override // com.baidu.live.im.i.a
                public boolean wx() {
                    return d.this.vc();
                }

                @Override // com.baidu.live.im.i.a
                public void wy() {
                    d.this.eTi = true;
                }

                @Override // com.baidu.live.im.i.a
                public void dL(String str) {
                    if (!d.this.eTe) {
                        d.this.iV(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.bjO().pageContext.getPageActivity(), d.this.bjO().faS.getLiveContainerView());
                    }
                    d.this.yP(str);
                }

                @Override // com.baidu.live.im.i.a
                public void wz() {
                    if (d.this.eTe) {
                        d.this.iV(true);
                        d.this.bjO().faS.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.bjO().pageContext.getPageActivity(), d.this.bjO().faS.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.eSC != null) {
                        d.this.eSC.ww().setQuickInputPanelVisible(false);
                        d.this.eSC.ww().xW();
                    }
                }

                @Override // com.baidu.live.im.i.a
                public void wA() {
                    if (d.this.eTe) {
                        d.this.bjb();
                        if (d.this.eSD != null) {
                            d.this.eSD.wD();
                        }
                    }
                }

                @Override // com.baidu.live.im.i.a
                public boolean wB() {
                    return d.this.bjl();
                }
            });
            this.eRO = new FrameLayout(bjO().pageContext.getPageActivity());
            this.eRO.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.eSC != null && this.eRO != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bjO().pageContext.getPageActivity()) * 0.75f);
            int dimensionPixelSize = bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64) + ((int) (BdUtilHelper.getEquipmentHeight(bjO().pageContext.getPageActivity()) * 0.27f));
            if (this.eTb.indexOfChild(this.eRO) < 0) {
                if (this.eRO.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eRO.getParent()).removeView(this.eRO);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds27) + dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
                this.eTb.addView(this.eRO, layoutParams);
            }
            if (this.eRO.indexOfChild(this.eSC.wv().getView()) < 0) {
                if (this.eSC.wv().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eSC.wv().getView()).removeView(this.eSC.wv().getView());
                }
                this.eRO.addView(this.eSC.wv().getView(), new FrameLayout.LayoutParams(equipmentWidth, dimensionPixelSize));
            }
            if (bjO().faU.indexOfChild(this.eSC.ww().getView()) < 0) {
                if (this.eSC.ww().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eSC.ww().getView().getParent()).removeView(this.eSC.ww().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bjr();
                bjO().faU.addView(this.eSC.ww().getView(), layoutParams2);
            }
            m yT = bjO().faT.yT();
            if (yT != null && yT.mLiveInfo != null) {
                this.eSC.setLogData(yT.mLiveInfo.feed_id, xC());
            }
            this.eSC.e(String.valueOf(bjO().faT.yT().mLiveInfo.group_id), String.valueOf(bjO().faT.yT().mLiveInfo.last_msg_id), String.valueOf(bjO().faT.yT().Ya.userId), String.valueOf(bjO().faT.yT().mLiveInfo.live_id), bjO().faT.yT().Ya.appId);
            iV(false);
        }
    }

    private void biK() {
        if (this.eRB == null) {
            this.eRB = new com.baidu.tieba.ala.liveroom.l.a(bjO().pageContext, false, this);
        }
        this.eRB.c(this.eTa, bjO().faT.yT());
        this.eRB.a(this.eSg);
        this.eRB.setOtherParams(xC());
    }

    private void biL() {
        if (this.eRA == null) {
            this.eRA = new com.baidu.tieba.ala.liveroom.audiencelist.c(bjO().pageContext, this, false);
        }
        this.eRA.a(String.valueOf(bjO().faT.yT().mLiveInfo.group_id), String.valueOf(bjO().faT.yT().mLiveInfo.live_id), String.valueOf(bjO().faT.yT().Ya.userId), bjO().faT.yT());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.eSq != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.eRA.c(this.eTa, i, a.g.ala_liveroom_audience_count_layout);
            this.eRA.f(bjO().faT.bee());
            this.eRA.setOtherParams(xC());
        }
    }

    private void biM() {
        if (this.eRE == null) {
            this.eRE = new com.baidu.tieba.ala.liveroom.operation.a(bjO().pageContext);
        }
        this.eRE.a(bjO(), this.eTb, bjO().faT.yT().mLiveInfo.live_type, true, this.eSg);
        this.eRE.setOtherParams(xC());
    }

    public void jc(boolean z) {
        if (this.eRE != null) {
            this.eRE.jc(z);
        }
    }

    private void biN() {
        if (this.eRF == null) {
            this.eRF = new com.baidu.tieba.ala.liveroom.audiencelist.b(bjO().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (bjO().faT.bee() != null) {
            j = bjO().faT.bee().getCount();
        }
        this.eRF.a(this.eSg);
        this.eRF.a(this.eTa, a.g.ala_liveroom_audience, j);
        this.eRF.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.eRF.jk(false);
        } else {
            this.eRF.jk(true);
        }
    }

    protected void yQ(String str) {
        if (this.eTo == null) {
            this.eTo = new com.baidu.tieba.ala.liveroom.q.b(bjO().pageContext);
        }
        this.eTo.b(this.eTb, str);
        iX(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.10
            @Override // java.lang.Runnable
            public void run() {
                d.this.eTo.bqr();
                d.this.iX(false);
            }
        }, 5000L);
    }

    private void jd(boolean z) {
        CustomResponsedMessage runTask;
        if (bjO().faT.yT().mLiveInfo.live_type == 1 && this.eTR) {
            if (this.eTQ == null && (runTask = MessageManager.getInstance().runTask(2913074, f.class, bjO().pageContext)) != null && runTask.getData() != null) {
                this.eTQ = (f) runTask.getData();
            }
            if (this.eTQ != null) {
                if (this.eRJ == null) {
                    this.eRJ = this.eTQ.a(bjO().pageContext);
                }
                if (bjO().faT.yT().mLiveInfo.challengeId > 0 && !this.eRJ.qg()) {
                    this.eRJ.d(bjO().faT.yT().mLiveInfo.live_id, bjO().faT.yT().Ya.userId);
                    je(z);
                    this.eRJ.c(bjO().faT.yT());
                }
            }
        }
    }

    private void je(boolean z) {
        if (this.eRK == null) {
            this.eRK = this.eTQ.b(bjO().pageContext);
            this.eRK.a(new com.baidu.live.challenge.h() { // from class: com.baidu.tieba.ala.liveroom.c.d.11
                @Override // com.baidu.live.challenge.h
                public void pV() {
                    d.this.bjO().faU.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.h
                public void a(ad adVar, ae aeVar, ae aeVar2) {
                    d.this.eQG = true;
                    if (d.this.eSw != null) {
                        d.this.eSw.setPraiseEnable(false);
                        d.this.bjO().faU.fnO = false;
                    }
                    if (d.this.eRG != null) {
                        d.this.eRG.setCanVisible(false);
                        d.this.eRG.bmm();
                    }
                    if (d.this.eRH != null) {
                        d.this.eRH.iO(true);
                    }
                    if (d.this.eTp != null) {
                        d.this.eTp.setVisible(8);
                    }
                    if (d.this.eRI != null) {
                        d.this.eRI.setCanVisible(false);
                        d.this.eRI.setVisible(8);
                    }
                    d.this.jg(true);
                    d.this.jh(true);
                    if (d.this.bjO().awt != null) {
                        d.this.bjO().awt.getLivePlayer().setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                    }
                    if (d.this.eSu != null) {
                        d.this.eSu.setTimeTextMode(true);
                    }
                    if (d.this.awq != null && aeVar != null && aeVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(aeVar.abT);
                        arrayList.add(aeVar2.abT);
                        com.baidu.live.liveroom.a.b bVar = d.this.awq;
                        if (d.this.eTl) {
                            arrayList = null;
                        }
                        bVar.j(arrayList);
                    }
                }

                @Override // com.baidu.live.challenge.h
                public void pW() {
                }

                @Override // com.baidu.live.challenge.h
                public void pX() {
                }

                @Override // com.baidu.live.challenge.h
                public void at(boolean z2) {
                    d.this.bjO().faU.setSwipeClearEnable(true);
                    d.this.eQG = false;
                    if (d.this.eSw != null) {
                        d.this.eSw.setPraiseEnable(true);
                        d.this.bjO().faU.fnO = true;
                    }
                    if (d.this.eRG != null) {
                        d.this.eRG.setCanVisible(true);
                        d.this.eRG.t(d.this.bjO().faT.yT());
                    }
                    if (d.this.eSy != null) {
                        d.this.eSy.jT(true);
                    }
                    if (d.this.eRH != null) {
                        d.this.eRH.iO(false);
                    }
                    if (d.this.eTp != null) {
                        d.this.eTp.setVisible(0);
                    }
                    if (d.this.eRI != null) {
                        d.this.eRI.setCanVisible(true);
                        d.this.eRI.setVisible(0);
                    }
                    d.this.jg(false);
                    d.this.jh(false);
                    if (d.this.awq != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.bjO().faT.bpW());
                        com.baidu.live.liveroom.a.b bVar = d.this.awq;
                        if (d.this.eTl) {
                            arrayList = null;
                        }
                        bVar.j(arrayList);
                    }
                    if (d.this.bjO().awt != null) {
                        d.this.bjO().awt.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
                    }
                    if (d.this.eSu != null) {
                        d.this.eSu.setTimeTextMode(false);
                    }
                }
            });
        }
        this.eRK.a(this.eRJ);
        this.eRK.e(bjO().faS.getLiveContainerView());
        this.eRK.b(z, false, false);
        this.eRJ.a((j.c) this.eRK);
    }

    private void jf(boolean z) {
        CustomResponsedMessage runTask;
        if (bjO().faT.yT().mLiveInfo.live_type == 1 && com.baidu.live.v.a.zs().awM.aaf) {
            if (this.eRI == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bjO().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.eRI = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.eRI != null) {
                this.eRI.a(bjO().faT.bpY(), false, false);
                if (bjO().faT.yT().mLiveInfo.pkId > 0 && this.eRI.getRootView() != null && this.eRI.getRootView().getParent() == null && this.eTP != null) {
                    if (this.eTP.getChildCount() <= 0) {
                        this.eTP.addView(this.eRI.getRootView(), new LinearLayout.LayoutParams(-2, -2));
                    } else {
                        View childAt = this.eTP.getChildAt(0);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.topMargin = bjO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                        childAt.setLayoutParams(layoutParams);
                        this.eTP.addView(this.eRI.getRootView(), 0, new LinearLayout.LayoutParams(-2, -2));
                    }
                }
                if (z) {
                    this.eRI.a(null, bjO().faT.yT());
                } else {
                    this.eRI.b(bjO().faT.yT());
                }
            }
        }
    }

    public void biO() {
        this.eSr.c(bjO().faT.yT(), false);
    }

    public void biP() {
        if (bjO().faT.yT() != null && bjO().faT.yT().Ya != null && bjO().faT.yT().mLiveInfo != null) {
            if (this.eRD == null) {
                this.eRD = new com.baidu.tieba.ala.liveroom.r.b(bjO().pageContext);
            }
            long j = bjO().faT.yT().Ya.userId;
            int i = bjO().faT.yT().mLiveInfo.live_type;
            String str = bjO().faT.yT().Ya.portrait;
            String str2 = bjO().faT.yT().mLiveInfo.feed_id;
            long j2 = bjO().faT.yT().mLiveInfo.live_id;
            this.eRD.a(i, j, bjO().faT.yT().Ya.userName, false, str, xC(), str2, j2);
            this.eRD.ag(this.eTa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jg(boolean z) {
        if (this.eTN != null && this.eTP != null) {
            if (z) {
                this.eTN.setViewActionDispatched(false);
                this.eTP.setViewActionDispatched(true);
                ViewGroup.LayoutParams layoutParams = this.eTN.getLayoutParams();
                layoutParams.height = bkb();
                this.eTN.setLayoutParams(layoutParams);
                biy();
                return;
            }
            this.eTP.setViewActionDispatched(false);
            this.eTN.setViewActionDispatched(true);
            ViewGroup.LayoutParams layoutParams2 = this.eTN.getLayoutParams();
            layoutParams2.height = -2;
            this.eTN.setLayoutParams(layoutParams2);
            bka();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:7:0x0014 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.LinearLayout$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.tieba.ala.liveroom.activeview.b] */
    public void jh(boolean z) {
        if (this.eRH != null) {
            ?? layoutParams = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams) layoutParams).gravity = 5;
            ?? r2 = this.eRH;
            ViewGroup viewGroup = z ? this.eTN : this.eRz;
            if (!z) {
                layoutParams = pS(1);
            }
            r2.a(1, viewGroup, layoutParams, 21);
            this.eRH.updateView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bkb() {
        return (((bjO().faU.getBottom() - (this.eRK != null ? this.eRK.au(false) : 0)) - (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0)) - bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biQ() {
        if (bjO() == null || bjO().faT == null || bjO().faT.yT() == null || bjO().faT.yT().Yo == null) {
            if (bjO().faT == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bjO().faT.yT() == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bjO().faT.yT().Yo == null) {
                Log.i("RenameLog", "getLiveContext().liveModel.getLiveShowData().mLoginUserInfo == null");
                return;
            } else {
                return;
            }
        }
        String str = bjO().faT.yT().Yo.userName;
        Log.i("RenameLog", "loginUserName:" + str);
        if (str != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bjO().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !bjk()) {
            com.baidu.live.c.pw().putInt("guide_rename_show_count", com.baidu.live.c.pw().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.yr().ba(true);
            if (this.eSV == null) {
                this.eSV = new com.baidu.tieba.ala.liveroom.s.a(bjO().pageContext);
            }
            this.eSV.setOtherParams(xC());
            this.eSV.e(this.eTb, bjO().faT.yT());
            iX(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.14
                @Override // java.lang.Runnable
                public void run() {
                    d.this.eSV.bqv();
                    d.this.iX(false);
                }
            }, 5000L);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_SHOW);
                alaStaticItem.addParams("other_params", xC());
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    private void biR() {
        boolean z = false;
        if (this.eSy == null) {
            this.eSy = new com.baidu.tieba.ala.liveroom.u.a(bjO().pageContext, this);
        }
        this.eSy.d(bjO().faU, false);
        if (bjN() && bjO().faT.yT().mLiveInfo.screen_direction != 2) {
            z = true;
        }
        this.eSy.jS(z);
    }

    private void biT() {
        if (this.eTi || this.eTj) {
            if ((TbadkCoreApplication.isLogin() && this.eSC.ww().hasText()) || this.eTj) {
                this.eTi = false;
                this.eTj = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.15
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bjq();
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
                if (this.eRG != null) {
                    this.eRG.u(jSONObject);
                }
            } else if ("enter_live".equals(optString)) {
                if (this.eRF.getCount() > 20) {
                    this.eRF.cD(this.eRF.getCount() + 1);
                } else if (this.eRA != null) {
                    com.baidu.live.data.a xt = aVar.xt();
                    com.baidu.live.data.g gVar = new com.baidu.live.data.g();
                    gVar.Yb = new AlaLocationData();
                    gVar.Yc = new AlaRelationData();
                    gVar.Ya = new AlaLiveUserInfoData();
                    gVar.Ya.userId = JavaTypesHelper.toLong(xt.userId, 0L);
                    gVar.Ya.userName = xt.userName;
                    gVar.Ya.portrait = xt.portrait;
                    if (this.eRA.c(gVar)) {
                        this.eRF.cD(this.eRF.getCount() + 1);
                    }
                }
            } else if ("update_liveinfo".equals(optString) && bjO().faT.yT() != null && bjO().faT.yT().mLiveInfo != null) {
                bjO().faT.a(bjO().faT.yT().mLiveInfo.live_id, bjO().fromType, bjO().enterTime);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void yL(String str) {
        if (this.eRH != null) {
            this.eRH.yL(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void bf(boolean z) {
        super.bf(z);
        if (bjO().faU != null) {
            bjO().faU.brg();
            bjO().faU.setLiveViewOnDispatchTouchEventListener(null);
            bjO().faU.setOnLiveViewScrollListener(null);
        }
        if (bjO().awt != null) {
            bjO().awt.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.eRK != null) {
            this.eRK.pP();
        }
        biU();
        if (this.eRD != null) {
            this.eRD.pP();
        }
        if (this.eSy != null) {
            this.eSy.release();
        }
        if (this.eRG != null) {
            this.eRG.pP();
        }
        if (this.eRE != null) {
            this.eRE.bqb();
        }
        if (this.eRC != null) {
            this.eRC.blA();
            this.eRC.setVisible(8);
        }
        if (this.eRI != null) {
            this.eRI.pP();
        }
        if (this.eRH != null) {
            this.eRH.release();
        }
        if (this.eTP != null) {
            this.eTP.setViewActionDispatched(false);
            this.eTP.removeAllViews();
            this.eTP = null;
        }
        if (this.eTN != null) {
            this.eTN.setViewActionDispatched(false);
            this.eTN.removeAllViews();
            this.eTN = null;
        }
        if (this.eRz != null) {
            this.eRz.removeAllViews();
            this.eRz = null;
        }
        if (this.eSy != null) {
            this.eSy.onDestroy();
        }
        if (this.eRJ != null) {
            this.eRJ.pP();
        }
        if (this.eRW != null) {
            this.eRW.cancel();
        }
        if (this.eTp != null) {
            this.eTp.bkF();
        }
        if (this.eRW != null) {
            this.eRW.pP();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void be(boolean z) {
        super.be(z);
        biU();
        if (this.eRB != null) {
            this.eRB.onDestroy();
        }
        if (this.eRD != null) {
            this.eRD.onDestroy();
        }
        if (this.eRG != null) {
            this.eRG.onDestroy();
        }
        if (this.eRI != null) {
            this.eRI.onDestroy();
        }
        if (this.eRJ != null) {
            this.eRJ.onDestroy();
        }
        if (this.eRK != null) {
            this.eRK.onDestroy();
        }
        if (this.eRL != null) {
            this.eRL.onDestroy();
        }
        if (this.eSK != null) {
            this.eSK.onDestroy();
        }
        if (this.eRC != null) {
            this.eRC.onDestroy();
        }
        if (this.eRA != null) {
            this.eRA.onDestroy();
        }
        if (this.eSC != null) {
            this.eSC.onDestroy();
        }
        if (this.eRE != null) {
            this.eRE.onDestory();
        }
        if (this.eRH != null) {
            this.eRH.release();
        }
        if (this.eTp != null) {
            this.eTp.be(!z);
        }
        MessageManager.getInstance().removeMessageRule(this.eRX);
        MessageManager.getInstance().removeMessageRule(this.eRY);
        MessageManager.getInstance().unRegisterListener(this.eSa);
        MessageManager.getInstance().unRegisterListener(this.eSb);
        MessageManager.getInstance().unRegisterListener(this.eTT);
        MessageManager.getInstance().unRegisterListener(this.eSd);
        MessageManager.getInstance().unRegisterListener(this.eSe);
        MessageManager.getInstance().unRegisterListener(this.eTS);
        MessageManager.getInstance().unRegisterListener(this.eSf);
        MessageManager.getInstance().unRegisterListener(this.eSc);
    }

    private void biU() {
        if (this.eSC != null && this.eSC.wv().getView() != null && this.eSC.wv().getView().getParent() != null) {
            ((ViewGroup) this.eSC.wv().getView().getParent()).removeView(this.eSC.wv().getView());
        }
        if (this.eRO != null && this.eRO.getParent() != null) {
            ((ViewGroup) this.eRO.getParent()).removeView(this.eRO);
        }
        if (this.eSC != null && this.eSC.ww().getView() != null) {
            this.eTb.removeView(this.eSC.ww().getView());
        }
        if (this.eSC != null) {
            this.eSC.wv().setMsgData(new LinkedList());
            this.eSC.wb();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void a(com.baidu.live.data.x xVar) {
        if (this.eSC != null) {
            bjq();
            this.eSC.ww().setEditText(" @" + xVar.getNameShow() + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.eRE != null) {
            this.eRE.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void f(com.baidu.live.data.a aVar) {
        if (this.eSC != null) {
            bjq();
            this.eSC.ww().setEditText(" @" + aVar.userName + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.eRE != null) {
            this.eRE.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void b(com.baidu.live.data.x xVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected View biV() {
        if (this.eSC != null) {
            return this.eSC.ww().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean biW() {
        if (this.eSC == null || !this.eSC.ww().xV()) {
            return false;
        }
        iV(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean biX() {
        return this.eRB == null || this.eRB.biX();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup biY() {
        return this.eTP;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup biZ() {
        return this.eRz;
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
                    this.eTf = false;
                    J(intExtra, intExtra2, intExtra3);
                    return;
                }
                biO();
                return;
            }
            bjM();
        } else if (i == 25051 && i2 == -1 && this.eTp != null) {
            this.eTp.bmc();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.eSC != null && this.eSC.wv() != null) {
            this.eSC.wv().onKeyboardVisibilityChanged(z);
        }
        if (z || this.eSC == null || !this.eSC.ww().xV()) {
            if (z) {
                if (this.eRE != null) {
                    this.eRE.setVisibility(8);
                }
                if (this.eSE != null && this.eSE.sq() != null) {
                    this.eSE.sq().setVisibility(8);
                }
                bjb();
                if (this.eSC != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eSC.ww().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.eSC.ww().getView().setLayoutParams(layoutParams);
                    this.eSC.ww().getView().setVisibility(0);
                    this.eSC.ww().setQuickInputPanelVisible(false);
                }
                if (this.eTa != null) {
                    this.eTa.setVisibility(8);
                }
                if (this.eRH != null) {
                    this.eRH.setVisible(8);
                }
                if (this.eSD != null) {
                    this.eSD.wD();
                }
                if (this.eSZ != null) {
                    this.eSZ.setCanVisible(false);
                }
            } else {
                bja();
            }
            if (this.eSC != null && this.eRO != null) {
                int equipmentHeight = (int) (((z ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(bjO().pageContext.getPageActivity())) + bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
                if (this.eTb.indexOfChild(this.eRO) != -1 && this.eRO.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eRO.getLayoutParams();
                    layoutParams2.height = bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds27) + equipmentHeight;
                    this.eRO.setLayoutParams(layoutParams2);
                }
                if (this.eRO.indexOfChild(this.eSC.wv().getView()) != -1 && this.eSC.wv().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.eSC.wv().getView().getLayoutParams();
                    layoutParams3.height = equipmentHeight;
                    this.eSC.wv().getView().setLayoutParams(layoutParams3);
                }
                this.eSC.wv().wu();
            }
            if (this.eSP != null) {
                this.eSP.aA(z);
            }
        }
    }

    private void bja() {
        if (this.eRE != null) {
            this.eRE.setVisibility(0);
        }
        if (this.eRO != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRO.getLayoutParams();
            layoutParams.bottomMargin = bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
            this.eRO.setLayoutParams(layoutParams);
        }
        if (this.eSC != null) {
            bjr();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eSC.ww().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.eSC.ww().getView().setLayoutParams(layoutParams2);
        }
        if (this.eRE != null) {
            this.eRE.setVisibility(0);
        }
        if (this.eSE != null && this.eSE.sq() != null) {
            this.eSE.sq().setVisibility(0);
        }
        if (this.eTa != null) {
            this.eTa.setVisibility(0);
        }
        if (this.eRH != null) {
            this.eRH.setVisible(0);
        }
        if (this.eSD != null) {
            this.eSD.wD();
        }
        if (this.eSZ != null) {
            this.eSZ.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjb() {
        if (this.eRO != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRO.getLayoutParams();
            boolean z = false;
            if (this.eSC != null && this.eSC.ww() != null) {
                z = this.eSC.ww().xU();
            }
            int iZ = iZ(z);
            if (layoutParams.bottomMargin != iZ) {
                layoutParams.bottomMargin = iZ;
                this.eRO.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iV(boolean z) {
        if (z) {
            this.eSC.ww().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRO.getLayoutParams();
            int quickInputPanelExpandHeight = this.eSC.ww().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.eRO.setLayoutParams(layoutParams);
                if (this.eSC.wv() != null) {
                    this.eSC.wv().wu();
                    return;
                }
                return;
            }
            return;
        }
        bja();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void j(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.eRA != null) {
                this.eRA.bW(i3);
            }
            if (this.eRC != null) {
                this.eRC.bW(i3);
            }
        }
        super.j(i, i2, i3);
        if (this.eQG && this.eTN != null) {
            this.eTN.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.16
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (d.this.eTN != null && (layoutParams = d.this.eTN.getLayoutParams()) != null) {
                        int i4 = layoutParams.height;
                        int bkb = d.this.bkb();
                        if (bkb != i4) {
                            layoutParams.height = bkb;
                            d.this.eTN.setLayoutParams(layoutParams);
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
            if (this.eRB.biX()) {
                return false;
            }
            if (cc && this.eSy != null) {
                this.eSy.jT(false);
            }
        }
        return cc;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void pT(int i) {
        super.pT(i);
        if (i == 7 || i == 11) {
            if (this.eRE != null) {
                this.eRE.setVisibility(8);
            }
            if (this.eSC != null) {
                this.eSC.wv().getView().setVisibility(4);
            }
            if (this.eRH != null) {
                this.eRH.bk(2, 8);
                if (this.eQG) {
                    this.eRH.bk(1, 8);
                }
            }
            if (this.eSS != null) {
                this.eSS.jO(false);
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
            if (this.eRE != null) {
                this.eRE.setVisibility(0);
            }
            if (this.eSC != null) {
                this.eSC.wv().getView().setVisibility(0);
            }
            if (this.eRH != null) {
                this.eRH.setVisible(0);
            }
            if (this.eSS != null) {
                this.eSS.jO(true);
            }
            this.eTa.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.eRD != null) {
            this.eRD.bqt();
        }
        if (this.eRJ != null) {
            this.eRJ.pZ();
        }
        if (this.eRH != null) {
            this.eRH.onStop();
        }
        if (this.eRI != null) {
            this.eRI.ar(true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.eRD != null) {
            this.eRD.bqs();
        }
        if (this.eRJ != null && this.eTR) {
            this.eRJ.qa();
        }
        if (this.eRH != null) {
            this.eRH.onStart();
        }
        if (this.eRI != null) {
            this.eRI.ar(false);
        }
    }

    private ViewGroup.LayoutParams ji(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.eTP == null) {
            return null;
        }
        int bkb = this.eQG ? bkb() : -2;
        ViewGroup.LayoutParams layoutParams2 = this.eTP.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, bkb);
        }
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds112);
        layoutParams.topMargin = bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200);
        return layoutParams;
    }

    private ViewGroup.LayoutParams bkc() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.eTN == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams2 = this.eTN.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
        return layoutParams;
    }
}
