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
import com.baidu.live.challenge.h;
import com.baidu.live.challenge.i;
import com.baidu.live.challenge.j;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.ac;
import com.baidu.live.data.ad;
import com.baidu.live.data.ao;
import com.baidu.live.data.aw;
import com.baidu.live.data.bc;
import com.baidu.live.data.l;
import com.baidu.live.data.w;
import com.baidu.live.im.i;
import com.baidu.live.im.k;
import com.baidu.live.message.GetQuickGiftHttpResponseMessage;
import com.baidu.live.r.a;
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
import com.baidu.live.utils.o;
import com.baidu.live.view.dispatch.DispatchedPvlLayout;
import com.baidu.live.view.dispatch.DispatchedRelativeLayout;
import com.baidu.tieba.ala.liveroom.guide.a;
import com.baidu.tieba.ala.liveroom.i.b;
import com.baidu.tieba.ala.liveroom.i.g;
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends b {
    private boolean eLS;
    private LinearLayout eMK;
    private com.baidu.tieba.ala.liveroom.audiencelist.c eML;
    private com.baidu.tieba.ala.liveroom.n.a eMM;
    private com.baidu.tieba.ala.liveroom.f.b eMN;
    private com.baidu.tieba.ala.liveroom.u.b eMO;
    private com.baidu.tieba.ala.liveroom.operation.a eMP;
    private com.baidu.tieba.ala.liveroom.audiencelist.b eMQ;
    private com.baidu.tieba.ala.liveroom.k.a eMR;
    private com.baidu.tieba.ala.liveroom.activeview.b eMS;
    private com.baidu.live.d.a eMT;
    private j eMU;
    private i eMV;
    private com.baidu.tieba.ala.liveroom.attentionpop.b eMW;
    private FrameLayout eMZ;
    private com.baidu.tieba.ala.liveroom.i.b eNh;
    private DispatchedPvlLayout eOZ;
    private View ePa;
    private DispatchedRelativeLayout ePb;
    private f ePc;
    private long lastClickTime = 0;
    private boolean ePd = false;
    private HttpRule eNi = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.eMU != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.eMU.pp()) {
                httpMessage.addParam("ala_challenge_id", d.this.eMU.ps());
            }
            return httpMessage;
        }
    };
    private HttpRule eNj = new HttpRule(1021151) { // from class: com.baidu.tieba.ala.liveroom.c.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.eMU != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.eMU.pp()) {
                httpMessage.addParam("challenge_id", d.this.eMU.ps());
            }
            return httpMessage;
        }
    };
    private AlaLiveView.c eNk = new AlaLiveView.c() { // from class: com.baidu.tieba.ala.liveroom.c.d.16
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void bgQ() {
            if (d.this.eNK != null) {
                d.this.eNK.jP(false);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void iN(boolean z) {
            if (z) {
                if (d.this.eMP != null) {
                    d.this.eMP.qs(8);
                }
                if (d.this.eNK != null) {
                    d.this.eNK.jP(true);
                }
            } else {
                if (d.this.eMP != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                        d.this.eMP.qs(0);
                    } else {
                        d.this.eMP.qs(8);
                    }
                }
                if (d.this.eNK != null) {
                    d.this.eNK.jP(false);
                }
            }
            if (d.this.eNS != null) {
                d.this.eNS.ay(z);
            }
        }
    };
    private HttpMessageListener eNl = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.d.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.wE() != null) {
                        com.baidu.live.s.c.wW().atv = getQuickGiftHttpResponseMessage.wE();
                        d.this.bgq();
                    }
                }
            }
        }
    };
    private CustomMessageListener eNm = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.d.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.bgz();
        }
    };
    CustomMessageListener eNq = new CustomMessageListener(2913151) { // from class: com.baidu.tieba.ala.liveroom.c.d.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913151) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.eNh.c(d.this.bhE());
                } else if (d.this.bgX() || !g.pS(2913151)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.19.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, null));
                        }
                    }, 3000L);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.bhE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.bhE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    d.this.eNh.c(d.this.eMZ, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener ePe = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.c.d.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.bgX() || !g.pS(2913128)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.pQ(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, 3000L);
                } else {
                    d.this.yu(str);
                }
            }
        }
    };
    private CustomMessageListener ePf = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.c.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = (AlaBroadcastGiftToastData) customResponsedMessage.getData();
                if (d.this.eNR instanceof com.baidu.live.gift.broadcastgift.a) {
                    ((com.baidu.live.gift.broadcastgift.a) d.this.eNR).b(alaBroadcastGiftToastData);
                }
            }
        }
    };
    private CustomMessageListener eNn = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.liveroom.c.d.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.this.eOf != null) {
                    d.this.eOf.yw(str);
                }
            }
        }
    };
    CustomMessageListener eNo = new CustomMessageListener(CmdConfigCustom.CMD_HOST_GET_WALLET_UA) { // from class: com.baidu.tieba.ala.liveroom.c.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.eOt != null && d.this.eOt.ezN != null && !d.this.eOt.eAt && !d.this.eOt.eCM) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.bhE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = d.this.bhE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                d.this.eOc.c(d.this.eMZ, layoutParams);
                com.baidu.tieba.ala.guardclub.a.bcK().bcL();
            }
        }
    };
    private CustomMessageListener eNp = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.eOd != null) {
                    d.this.eOd.dismiss();
                }
                if (d.this.eOf != null) {
                    d.this.eOf.dismiss();
                }
                k.uW().setSwitchStatus(true);
                k.uW().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bhd();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b eNr = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.d.13
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void m(View view, int i) {
            ao aoVar;
            aw awVar;
            bc bcVar;
            ao aoVar2;
            aw awVar2;
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - d.this.lastClickTime >= 300) {
                d.this.lastClickTime = currentTimeMillis;
                if (i == 2) {
                    d.this.I(-1, -1, -1);
                } else if (i == 13) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.s.c.wW().atv.rt().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.s.c.wW().atv.rt().qE());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.s.c.wW().atv.rt().qF());
                        if (d.this.bhE().eWr.ww() != null && d.this.bhE().eWr.ww().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.bhE().eWr.ww().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.bhE().eWr.ww().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.vz());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.tH()) {
                        if (com.baidu.live.c.oJ().getBoolean("quick_gift_guide_show", true) && !d.this.bgX()) {
                            com.baidu.live.gift.container.e eVar = new com.baidu.live.gift.container.e(d.this.bhE().pageContext.getPageActivity(), d.this.bhE().pageContext, d.this.bhE().eWr.ww(), com.baidu.live.s.c.wW().atv.rt(), d.this.vz());
                            eVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.d.13.1
                                @Override // android.content.DialogInterface.OnDismissListener
                                public void onDismiss(DialogInterface dialogInterface) {
                                    d.this.iP(false);
                                }
                            });
                            eVar.show();
                            d.this.iP(true);
                            return;
                        }
                        com.baidu.live.gift.b.c.a(d.this.bhE().pageContext, d.this.bhE().eWr.ww(), com.baidu.live.s.c.wW().atv.rt(), d.this.vz());
                    }
                } else if (i == 1) {
                    if (d.this.eNO != null) {
                        d.this.bhd();
                    }
                } else if (i == 3 && d.this.tH()) {
                    d.this.eND.c(d.this.bhE().eWr.ww(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.bhE() != null && d.this.bhE().eWr != null && d.this.bhE().eWr.ww() != null && d.this.bhE().eWr.ww().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.bhE().eWr.ww().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.bhE().eWr.ww().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.bhE().eWr.ww().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.vz());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.bhE() != null && d.this.bhE().eWr != null && d.this.bhE().eWr.ww() != null && d.this.bhE().eWr.ww().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.bhE().eWr.ww().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.bhE().eWr.ww().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.bhE().eWr.ww().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.vz());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.eNA != null) {
                        d.this.eNA.ja(false);
                    }
                } else if (i == 12) {
                    if (d.this.eNK != null) {
                        String valueOf = String.valueOf(d.this.bhE().eWr.ww().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.bhE().eWr.ww().mLiveInfo.room_id);
                        String str2 = null;
                        com.baidu.live.data.j jVar = d.this.bhE().eWr.ww().mLiveSdkInfo;
                        if (jVar != null && jVar.mCastIds != null) {
                            str2 = String.valueOf(d.this.bhE().eWr.ww().mLiveSdkInfo.mCastIds.Wm);
                        }
                        d.this.eNK.ad(valueOf, valueOf2, str2);
                        if (com.baidu.live.liveroom.a.wl().wm()) {
                            d.this.bgz();
                        }
                    }
                } else if (i == 14) {
                    l ww = d.this.bhE().eWr.ww();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.bhE().pageContext.getPageActivity(), ww.Wf.userName, Long.toString(ww.Wf.userId), Long.toString(ww.Wf.charmCount), String.valueOf(ww.mLiveInfo.group_id), String.valueOf(ww.mLiveInfo.live_id), false, String.valueOf(ww.Wf.userId), Long.toString(ww.Wt.userId), ww.Wt.userName, ww.Wt.portrait, d.this.eMQ.getCount(), d.this.vz())));
                    LogManager.getCommonLogger().doClickGusetNumLog(ww.mLiveInfo.feed_id, d.this.eMQ.getCount() + "", d.this.vz());
                } else if (i == 11) {
                    d.this.bhg();
                    d.this.bhh();
                } else if (i == 15) {
                    if (d.this.eOa != null && d.this.bhE() != null && d.this.bhE().eWr != null && d.this.bhE().eWr.ww() != null && d.this.bhE().eWr.ww().mLiveInfo != null) {
                        long j = d.this.bhE().eWr.ww().mLiveInfo.live_id;
                        String valueOf3 = String.valueOf(d.this.bhE().eWr.ww().mLiveInfo.feed_id);
                        long j2 = d.this.bhE().eWr.ww().mLiveInfo.room_id;
                        String str3 = d.this.bhE().eWr.ww().mLiveInfo.cover;
                        String str4 = "";
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        if (d.this.bhE().eWr.ww().mLiveInfo.session_info != null) {
                            str4 = d.this.bhE().eWr.ww().mLiveInfo.session_info.flvUrl;
                        }
                        if (!TextUtils.isEmpty(d.this.vz())) {
                            try {
                                JSONObject jSONObject = new JSONObject(d.this.vz());
                                str5 = jSONObject.optString("tab");
                                str6 = jSONObject.optString("tag");
                                str7 = jSONObject.optString("source");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        d.this.eOa.yw(o.a(valueOf3, j + "", j2, false, 1, str3, str4, str5, str6, str7));
                        o.azz = j;
                        if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                            ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                            LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf3, d.this.vz());
                        }
                    }
                } else if (i == 16) {
                    if (d.this.bhE() != null && (aoVar2 = com.baidu.live.s.a.wR().atk) != null && (awVar2 = aoVar2.aaU) != null) {
                        String str8 = awVar2.abK.abR;
                        if (!TextUtils.isEmpty(str8)) {
                            long j3 = 0;
                            if (d.this.bhE().eWr != null && d.this.bhE().eWr.ww() != null && d.this.bhE().eWr.ww().mLiveInfo != null) {
                                j3 = d.this.bhE().eWr.ww().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j3 + "", d.this.bhE().eWr.ww().mLiveInfo.room_id + "", d.this.bhE().eWr.ww().mLiveInfo.feed_id, d.this.vz());
                            }
                            if (str8.contains("?")) {
                                str = str8 + "&liveId=" + j3;
                            } else {
                                str = str8 + "?liveId=" + j3;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.bhE().pageContext.getPageActivity(), str);
                        }
                    }
                } else if (i == 17 && d.this.tH() && d.this.bhE() != null && (aoVar = com.baidu.live.s.a.wR().atk) != null && (awVar = aoVar.aaU) != null && (bcVar = awVar.abL) != null && !TextUtils.isEmpty(bcVar.webUrl) && d.this.eOd != null && d.this.bhE().eWr != null && d.this.bhE().eWr.ww() != null) {
                    l ww2 = d.this.bhE().eWr.ww();
                    d.this.eOd.a(bcVar.webUrl, ww2.mLiveInfo.live_id, ww2.Wt.userId, ww2.Wf.userId);
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void init() {
        super.init();
        this.eNF = new com.baidu.tieba.ala.liveroom.guide.c(bhE().pageContext, this, false);
        this.eNi.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.eNi);
        this.eNj.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.eNj);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean bgb() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void xc() {
        super.xc();
        g.bkl();
        this.ePd = true;
        bhE().eWs.setIsForceHandledTouch(false);
        bhE().eWs.setSwipeClearEnable(true);
        bhE().eWs.setOnLiveViewScrollListener(this.eNk);
        if (this.eNI != null) {
            this.eNI.b(this.eNr);
        }
        if (this.eOm != null) {
            this.eOm.setVisibility(0);
        }
        bgf();
        bgi();
        bgt();
        bgT();
        bgu();
        bgw();
        bgv();
        iI(false);
        bhk();
        bhj();
        bgk();
        bgr();
        bhm();
        bgy();
        bgA();
        iX(true);
        bhQ();
        bhR();
        iQ(false);
        bgj();
        bgq();
        bhs();
        bgl();
        bgm();
        bgn();
        bgo();
        iV(true);
        bhr();
        MessageManager.getInstance().registerListener(this.eNl);
        MessageManager.getInstance().registerListener(this.eNm);
        MessageManager.getInstance().registerListener(this.ePf);
        MessageManager.getInstance().registerListener(this.eNo);
        MessageManager.getInstance().registerListener(this.eNp);
        MessageManager.getInstance().registerListener(this.ePe);
        MessageManager.getInstance().registerListener(this.eNq);
        MessageManager.getInstance().registerListener(this.eNn);
        bgC();
    }

    private void bgd() {
        if (this.eNJ != null) {
            this.eNJ.ah(bhE().eWt);
        }
    }

    private void bhQ() {
        if (this.eMW == null) {
            this.eMW = new com.baidu.tieba.ala.liveroom.attentionpop.b(bhE().pageContext);
        }
        if (bhE().eWr != null && bhE().eWr.ww() != null && bhE().eWr.ww().mLiveInfo != null) {
            this.eMW.yr(String.valueOf(bhE().eWr.ww().mLiveInfo.user_id));
        }
    }

    private void bhR() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (bhE() != null && bhE().eWr != null && bhE().eWr.ww() != null && bhE().eWr.ww().mLiveInfo != null) {
                j = bhE().eWr.ww().mLiveInfo.room_id;
            }
            if (this.eNY == null) {
                this.eNY = new com.baidu.tieba.ala.liveroom.guide.a(bhE().pageContext, j);
            }
            this.eNY.iO(this.eOp);
            this.eNY.a(new a.InterfaceC0447a() { // from class: com.baidu.tieba.ala.liveroom.c.d.4
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0447a
                public void bhV() {
                    if (d.this.eNA != null) {
                        d.this.eNA.ja(true);
                    }
                }
            });
            this.eNY.ad(null);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void bd(int i) {
        super.bd(i);
        bgd();
        if (this.eMV != null) {
            this.eMV.bd(i);
        }
        if (this.eMV == null || !this.eMV.isActive()) {
        }
    }

    private void bgf() {
        if (this.ePb == null) {
            this.ePb = new DispatchedRelativeLayout(bhE().pageContext.getPageActivity());
            this.ePb.setViewActionDispatched(false);
            this.ePb.setViewActionDispatchListener(new com.baidu.live.view.dispatch.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.5
                @Override // com.baidu.live.view.dispatch.a
                public boolean W(View view) {
                    return (d.this.eOZ == null || d.this.eOZ.zc() || view == null || !(view.getTag(a.g.sdk_pvl_layout_priority_tag_key) instanceof Integer)) ? false : true;
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewAdded(View view) {
                    view.setTag(a.g.ala_live_room_vertival_widgets_bk_lp_key, view.getLayoutParams());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(view.getLayoutParams().width, view.getLayoutParams().height);
                    layoutParams.gravity = 5;
                    view.setLayoutParams(layoutParams);
                    d.this.eOZ.addView(view);
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewRemoved(View view) {
                    d.this.eOZ.removeView(view);
                }

                @Override // com.baidu.live.view.dispatch.a
                public void ze() {
                    if (d.this.eOZ != null && !d.this.eOZ.zc()) {
                        d.this.eOZ.removeAllViews();
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public int indexOfChild(View view) {
                    return d.this.eOZ.indexOfChild(view);
                }
            });
        }
        if (this.ePb.getParent() == null) {
            bhE().eWs.addView(this.ePb, iZ(false));
        }
        if (this.eOZ == null) {
            this.eOZ = new DispatchedPvlLayout(bhE().pageContext.getPageActivity());
            this.eOZ.setDefaultItemMargin(bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.eOZ.setViewActionDispatched(false);
            this.eOZ.setViewActionDispatchListener(new com.baidu.live.view.dispatch.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.6
                @Override // com.baidu.live.view.dispatch.a
                public boolean W(View view) {
                    return (d.this.ePb == null || d.this.ePb.zc() || !(view.getTag(a.g.ala_live_room_vertival_widgets_bk_lp_key) instanceof ViewGroup.LayoutParams)) ? false : true;
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewAdded(View view) {
                    view.setLayoutParams(new LinearLayout.LayoutParams(view.getLayoutParams().width, view.getLayoutParams().height));
                    d.this.ePb.addView(view, (ViewGroup.LayoutParams) view.getTag(a.g.ala_live_room_vertival_widgets_bk_lp_key));
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewRemoved(View view) {
                    d.this.ePb.removeView(view);
                }

                @Override // com.baidu.live.view.dispatch.a
                public void ze() {
                    if (d.this.ePb != null && !d.this.ePb.zc()) {
                        d.this.ePb.removeAllViews();
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public int indexOfChild(View view) {
                    return d.this.ePb.indexOfChild(view);
                }
            });
        }
        if (this.eOZ.getParent() == null) {
            bhE().eWs.addView(this.eOZ, bhU());
        }
    }

    private void bgh() {
        if (this.ePa == null) {
            this.ePa = new View(bhE().pageContext.getPageActivity());
            this.ePa.setTag(a.g.sdk_pvl_layout_priority_tag_key, 20);
        }
        if (this.ePa.getParent() == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(1, 0);
            layoutParams.weight = 1.0f;
            this.eOZ.addView(this.ePa, layoutParams);
        }
    }

    private void bhS() {
        this.eOZ.removeView(this.ePa);
    }

    private void bgi() {
        if (this.eMK == null) {
            this.eMK = new LinearLayout(bhE().pageContext.getPageActivity());
            this.eMK.setOrientation(1);
        }
        if (this.eMK.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds160);
            layoutParams.leftMargin = bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bhE().eWs.addView(this.eMK, layoutParams);
        }
    }

    private void bgk() {
        if (this.eNH != null && bhE() != null && bhE().eWr != null) {
            this.eNH.b(this.eOm, bhE().eWr.ww());
        }
    }

    private void bgj() {
        if (this.eMS == null) {
            this.eMS = new com.baidu.tieba.ala.liveroom.activeview.b(bhE().pageContext);
        }
        this.eMS.iE(this.eLS);
        this.eMS.setOtherParams(vz());
        this.eMS.b(bhE().eWr.ww(), false);
        this.eMS.setHost(false);
        this.eMS.a(1, this.eMK, pI(1));
        this.eMS.a(2, this.eOZ, pI(2));
        this.eMS.setVisible(this.eOq ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgq() {
        if (this.eMP == null) {
            bgv();
        }
        this.eMP.setOtherParams(vz());
        this.eMP.a(com.baidu.live.s.c.wW().atv, bhE().eWr.ww());
    }

    private ViewGroup.LayoutParams pI(int i) {
        switch (i) {
            case 1:
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (this.eMK == null || this.eMK.getChildCount() == 0) {
                    return layoutParams;
                }
                layoutParams.topMargin = bhE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                return layoutParams;
            case 2:
                ViewGroup.LayoutParams layoutParams2 = this.ePb.getLayoutParams();
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(((int) (BdUtilHelper.getEquipmentWidth(bhE().pageContext.getPageActivity()) * 0.25f)) - ((layoutParams2 instanceof LinearLayout.LayoutParams ? ((LinearLayout.LayoutParams) layoutParams2).rightMargin : 0) * 2), -2);
                layoutParams3.gravity = 5;
                return layoutParams3;
            default:
                return new RelativeLayout.LayoutParams(-2, -2);
        }
    }

    private void bgl() {
        if (this.eMR == null) {
            this.eMR = new com.baidu.tieba.ala.liveroom.k.a(bhE().pageContext, this);
        }
        this.eMR.setOtherParams(vz());
        this.eMR.d(this.ePb, bgp());
        this.eMR.o(bhE().eWr.ww());
    }

    private void bgm() {
        if (this.eOc == null) {
            this.eOc = new com.baidu.tieba.ala.liveroom.l.c(bhE().pageContext, vz());
        }
        if (this.eMZ != null && this.eMZ.indexOfChild(this.eOc.getView()) >= 0) {
            this.eMZ.removeView(this.eOc.getView());
        }
    }

    private void bgn() {
        if (this.eMP != null) {
            this.eMP.a(new a.InterfaceC0454a() { // from class: com.baidu.tieba.ala.liveroom.c.d.7
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0454a
                public void bk(int i, int i2) {
                    l ww = d.this.bhE().eWr.ww();
                    if (ww != null && ww.mLiveInfo != null) {
                        if (d.this.eOe == null) {
                            d.this.eOe = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.bhE().pageContext.getPageActivity());
                        }
                        d.this.eOe.d(d.this.eOn, i, i2);
                        d.this.eOe.a(String.valueOf(ww.mLiveInfo.live_id), new a.InterfaceC0459a() { // from class: com.baidu.tieba.ala.liveroom.c.d.7.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0459a
                            public void a(float f, String str) {
                                if (d.this.eMP != null) {
                                    d.this.eMP.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0454a
                public void bl(int i, int i2) {
                    if (d.this.eOe != null) {
                        d.this.eOe.bq(i, i2);
                    }
                }
            });
        }
    }

    private void bgo() {
        if (this.eOA == null) {
            this.eOA = new com.baidu.tieba.ala.liveroom.i.e(bhE().pageContext);
        }
        this.eOA.setRoomId(bhE().eWr.ww().mLiveInfo.room_id);
        this.eOA.yG("");
        this.eOA.a(bhE().eWr.ww(), this.eOZ);
        if (this.eNh == null) {
            this.eNh = new com.baidu.tieba.ala.liveroom.i.b(bhE().pageContext, vz(), this.eOA, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.8
                @Override // com.baidu.tieba.ala.liveroom.i.b.a
                public void bgO() {
                    d.this.iP(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.i.b.a
                public void bgP() {
                    d.this.iP(false);
                }
            });
        }
        this.eNh.setRoomId(bhE().eWr.ww().mLiveInfo.room_id);
        if (this.eMZ != null && this.eMZ.indexOfChild(this.eNh.getView()) >= 0) {
            this.eMZ.removeView(this.eNh.getView());
        }
        if (this.eNh != null) {
            this.eNh.b(bhE());
        }
    }

    private ViewGroup.LayoutParams bgp() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.topMargin = (ScreenHelper.getRealScreenHeight(bhE().pageContext.getPageActivity()) - this.ePb.getTop()) - bhE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds814);
        return layoutParams;
    }

    private void bgr() {
        CustomResponsedMessage runTask;
        if (this.eNO == null && (runTask = MessageManager.getInstance().runTask(2913039, com.baidu.live.im.i.class, bhE().pageContext)) != null && runTask.getData() != null) {
            this.eNO = (com.baidu.live.im.i) runTask.getData();
            this.eNO.setFromMaster(false);
            this.eNO.uM().getView().setId(a.g.ala_liveroom_msg_list);
            this.eNO.a(new i.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.9
                @Override // com.baidu.live.im.i.a
                public boolean uO() {
                    return d.this.tH();
                }

                @Override // com.baidu.live.im.i.a
                public void uP() {
                    d.this.eOu = true;
                }

                @Override // com.baidu.live.im.i.a
                public void dB(String str) {
                    if (!d.this.eOq) {
                        d.this.iM(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.bhE().pageContext.getPageActivity(), d.this.bhE().eWt);
                    }
                    d.this.yt(str);
                }

                @Override // com.baidu.live.im.i.a
                public void uQ() {
                    if (d.this.eOq) {
                        d.this.iM(true);
                        d.this.bhE().eWt.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.bhE().pageContext.getPageActivity(), d.this.bhE().eWt);
                            }
                        }, 10L);
                    } else if (d.this.eNO != null) {
                        d.this.eNO.uN().setQuickInputPanelVisible(false);
                        d.this.eNO.uN().vS();
                    }
                }

                @Override // com.baidu.live.im.i.a
                public void uR() {
                    if (d.this.eOq) {
                        d.this.bgL();
                        if (d.this.eNP != null) {
                            d.this.eNP.uU();
                        }
                    }
                }

                @Override // com.baidu.live.im.i.a
                public boolean uS() {
                    return d.this.bgY();
                }
            });
            this.eMZ = new FrameLayout(bhE().pageContext.getPageActivity());
            this.eMZ.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.eNO != null && this.eMZ != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bhE().pageContext.getPageActivity()) * 0.75f);
            int dimensionPixelSize = bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64) + ((int) (BdUtilHelper.getEquipmentHeight(bhE().pageContext.getPageActivity()) * 0.27f));
            if (this.eOn.indexOfChild(this.eMZ) < 0) {
                if (this.eMZ.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eMZ.getParent()).removeView(this.eMZ);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds27) + dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
                this.eOn.addView(this.eMZ, layoutParams);
            }
            if (this.eMZ.indexOfChild(this.eNO.uM().getView()) < 0) {
                if (this.eNO.uM().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eNO.uM().getView()).removeView(this.eNO.uM().getView());
                }
                this.eMZ.addView(this.eNO.uM().getView(), new FrameLayout.LayoutParams(equipmentWidth, dimensionPixelSize));
            }
            if (bhE().eWs.indexOfChild(this.eNO.uN().getView()) < 0) {
                if (this.eNO.uN().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eNO.uN().getView().getParent()).removeView(this.eNO.uN().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bhe();
                bhE().eWs.addView(this.eNO.uN().getView(), layoutParams2);
            }
            l ww = bhE().eWr.ww();
            if (ww != null && ww.mLiveInfo != null) {
                this.eNO.setLogData(ww.mLiveInfo.feed_id, vz());
            }
            this.eNO.e(String.valueOf(bhE().eWr.ww().mLiveInfo.group_id), String.valueOf(bhE().eWr.ww().mLiveInfo.last_msg_id), String.valueOf(bhE().eWr.ww().Wf.userId), String.valueOf(bhE().eWr.ww().mLiveInfo.live_id), bhE().eWr.ww().Wf.appId);
            iM(false);
        }
    }

    private void bgt() {
        if (this.eMM == null) {
            this.eMM = new com.baidu.tieba.ala.liveroom.n.a(bhE().pageContext, false, this);
        }
        this.eMM.d(this.eOm, bhE().eWr.ww());
        this.eMM.a(this.eNr);
        this.eMM.setOtherParams(vz());
    }

    private void bgu() {
        if (this.eML == null) {
            this.eML = new com.baidu.tieba.ala.liveroom.audiencelist.c(bhE().pageContext, this, false);
        }
        this.eML.a(String.valueOf(bhE().eWr.ww().mLiveInfo.group_id), String.valueOf(bhE().eWr.ww().mLiveInfo.live_id), String.valueOf(bhE().eWr.ww().Wf.userId), bhE().eWr.ww());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.eNC != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.eML.c(this.eOm, i, a.g.ala_liveroom_audience_count_layout);
            this.eML.f(bhE().eWr.bbH());
            this.eML.setOtherParams(vz());
        }
    }

    private void bgv() {
        if (this.eMP == null) {
            this.eMP = new com.baidu.tieba.ala.liveroom.operation.a(bhE().pageContext);
        }
        this.eMP.a(bhE(), this.eOn, bhE().eWr.ww().mLiveInfo.live_type, true, this.eNr);
        this.eMP.setOtherParams(vz());
    }

    public void iU(boolean z) {
        if (this.eMP != null) {
            this.eMP.iU(z);
        }
    }

    private void bgw() {
        if (this.eMQ == null) {
            this.eMQ = new com.baidu.tieba.ala.liveroom.audiencelist.b(bhE().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (bhE().eWr.bbH() != null) {
            j = bhE().eWr.bbH().getCount();
        }
        this.eMQ.a(this.eNr);
        this.eMQ.a(this.eOm, a.g.ala_liveroom_audience, j);
        this.eMQ.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.eMQ.je(false);
        } else {
            this.eMQ.je(true);
        }
    }

    protected void yu(String str) {
        if (this.eOz == null) {
            this.eOz = new com.baidu.tieba.ala.liveroom.s.b(bhE().pageContext);
        }
        this.eOz.b(this.eOn, str);
        iP(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.10
            @Override // java.lang.Runnable
            public void run() {
                d.this.eOz.bow();
                d.this.iP(false);
            }
        }, 5000L);
    }

    private void iV(boolean z) {
        CustomResponsedMessage runTask;
        if (bhE().eWr.ww().mLiveInfo.live_type == 1) {
            if (this.ePc == null && (runTask = MessageManager.getInstance().runTask(2913074, f.class, bhE().pageContext)) != null && runTask.getData() != null) {
                this.ePc = (f) runTask.getData();
            }
            if (this.ePc != null) {
                if (this.eMU == null) {
                    this.eMU = this.ePc.a(bhE().pageContext);
                }
                if (bhE().eWr.ww().mLiveInfo.challengeId > 0 && !this.eMU.pq()) {
                    this.eMU.d(bhE().eWr.ww().mLiveInfo.live_id, bhE().eWr.ww().Wf.userId);
                    iW(z);
                    this.eMU.c(bhE().eWr.ww());
                }
            }
        }
    }

    private void iW(boolean z) {
        if (this.eMV == null) {
            this.eMV = this.ePc.b(bhE().pageContext);
            this.eMV.a(new h() { // from class: com.baidu.tieba.ala.liveroom.c.d.11
                @Override // com.baidu.live.challenge.h
                public void pf() {
                    d.this.bhE().eWs.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.h
                public void a(ac acVar, ad adVar, ad adVar2) {
                    d.this.eLS = true;
                    if (d.this.eNI != null) {
                        d.this.eNI.setPraiseEnable(false);
                        d.this.bhE().eWs.fkh = false;
                    }
                    if (d.this.eMR != null) {
                        d.this.eMR.setCanVisible(false);
                        d.this.eMR.bkq();
                    }
                    if (d.this.eMS != null) {
                        d.this.eMS.iE(true);
                        d.this.eMS.setVisible(8);
                    }
                    if (d.this.eMT != null) {
                        d.this.eMT.setCanVisible(false);
                        d.this.eMT.setVisible(8);
                    }
                    d.this.iY(true);
                    if (d.this.bhE().eWq != null) {
                        d.this.bhE().eWq.setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                    }
                    if (d.this.eNG != null) {
                        d.this.eNG.setTimeTextMode(true);
                    }
                    if (d.this.eNA != null && adVar != null && adVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(adVar.ZO);
                        arrayList.add(adVar2.ZO);
                        e eVar = d.this.eNA;
                        if (d.this.eOw) {
                            arrayList = null;
                        }
                        eVar.U(arrayList);
                    }
                }

                @Override // com.baidu.live.challenge.h
                public void pg() {
                }

                @Override // com.baidu.live.challenge.h
                public void ph() {
                }

                @Override // com.baidu.live.challenge.h
                public void aq(boolean z2) {
                    d.this.bhE().eWs.setSwipeClearEnable(true);
                    d.this.eLS = false;
                    if (d.this.eNI != null) {
                        d.this.eNI.setPraiseEnable(true);
                        d.this.bhE().eWs.fkh = true;
                    }
                    if (d.this.eMR != null) {
                        d.this.eMR.setCanVisible(true);
                        d.this.eMR.o(d.this.bhE().eWr.ww());
                    }
                    if (d.this.eNK != null) {
                        d.this.eNK.jP(true);
                    }
                    if (d.this.eMS != null) {
                        d.this.eMS.iE(false);
                        d.this.eMS.setVisible(0);
                    }
                    if (d.this.eMT != null) {
                        d.this.eMT.setCanVisible(true);
                        d.this.eMT.setVisible(0);
                    }
                    d.this.iY(false);
                    if (d.this.eNA != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.bhE().eWr.boc());
                        e eVar = d.this.eNA;
                        if (d.this.eOw) {
                            arrayList = null;
                        }
                        eVar.U(arrayList);
                    }
                    if (d.this.bhE().eWq != null) {
                        d.this.bhE().eWq.setBackgroundResource(a.f.sdk_transparent_bg);
                    }
                    if (d.this.eNG != null) {
                        d.this.eNG.setTimeTextMode(false);
                    }
                }
            });
        }
        this.eMV.a(this.eMU);
        this.eMV.e(bhE().eWt);
        this.eMV.b(z, false, false);
        this.eMU.a((j.c) this.eMV);
    }

    private void iX(boolean z) {
        CustomResponsedMessage runTask;
        if (bhE().eWr.ww().mLiveInfo.live_type == 1 && com.baidu.live.s.a.wR().asq.Yd) {
            if (this.eMT == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bhE().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.eMT = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.eMT != null) {
                this.eMT.a(bhE().eWr.bod(), false, false);
                if (bhE().eWr.ww().mLiveInfo.pkId > 0 && this.eMT.getRootView() != null && this.eMT.getRootView().getParent() == null && this.ePb != null) {
                    if (this.ePb.getChildCount() <= 0) {
                        this.ePb.addView(this.eMT.getRootView(), new LinearLayout.LayoutParams(-2, -2));
                    } else {
                        View childAt = this.ePb.getChildAt(0);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.topMargin = bhE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                        childAt.setLayoutParams(layoutParams);
                        this.ePb.addView(this.eMT.getRootView(), 0, new LinearLayout.LayoutParams(-2, -2));
                    }
                }
                if (z) {
                    this.eMT.a(null, bhE().eWr.ww());
                } else {
                    this.eMT.b(bhE().eWr.ww());
                }
            }
        }
    }

    public void bgx() {
        this.eND.c(bhE().eWr.ww(), false);
    }

    public void bgy() {
        if (bhE().eWr.ww() != null && bhE().eWr.ww().Wf != null && bhE().eWr.ww().mLiveInfo != null) {
            if (this.eMO == null) {
                this.eMO = new com.baidu.tieba.ala.liveroom.u.b(bhE().pageContext);
            }
            long j = bhE().eWr.ww().Wf.userId;
            int i = bhE().eWr.ww().mLiveInfo.live_type;
            String str = bhE().eWr.ww().Wf.portrait;
            String str2 = bhE().eWr.ww().mLiveInfo.feed_id;
            long j2 = bhE().eWr.ww().mLiveInfo.live_id;
            this.eMO.a(i, j, bhE().eWr.ww().Wf.userName, false, str, vz(), str2, j2);
            this.eMO.ad(this.eOm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iY(boolean z) {
        if (z) {
            this.eOZ.setViewActionDispatched(false);
            this.ePb.setViewActionDispatched(true);
            ViewGroup.LayoutParams layoutParams = this.eOZ.getLayoutParams();
            layoutParams.height = bhT();
            this.eOZ.setLayoutParams(layoutParams);
            bgh();
            return;
        }
        this.ePb.setViewActionDispatched(false);
        this.eOZ.setViewActionDispatched(true);
        ViewGroup.LayoutParams layoutParams2 = this.eOZ.getLayoutParams();
        layoutParams2.height = -2;
        this.eOZ.setLayoutParams(layoutParams2);
        bhS();
    }

    private int bhT() {
        return (((bhE().eWs.getBottom() - this.eMV.ar(false)) - (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0)) - bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgz() {
        if (bhE() == null || bhE().eWr == null || bhE().eWr.ww() == null || bhE().eWr.ww().Wt == null) {
            if (bhE().eWr == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bhE().eWr.ww() == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bhE().eWr.ww().Wt == null) {
                Log.i("RenameLog", "getLiveContext().liveModel.getLiveShowData().mLoginUserInfo == null");
                return;
            } else {
                return;
            }
        }
        String str = bhE().eWr.ww().Wt.userName;
        Log.i("RenameLog", "loginUserName:" + str);
        if (str != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bhE().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !bgX()) {
            com.baidu.live.c.oJ().putInt("guide_rename_show_count", com.baidu.live.c.oJ().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.wl().aX(true);
            if (this.eOh == null) {
                this.eOh = new com.baidu.tieba.ala.liveroom.v.a(bhE().pageContext);
            }
            this.eOh.setOtherParams(vz());
            this.eOh.f(this.eOn, bhE().eWr.ww());
            iP(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.14
                @Override // java.lang.Runnable
                public void run() {
                    d.this.eOh.boH();
                    d.this.iP(false);
                }
            }, 5000L);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_SHOW);
                alaStaticItem.addParams("other_params", vz());
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    private void bgA() {
        boolean z = false;
        if (this.eNK == null) {
            this.eNK = new com.baidu.tieba.ala.liveroom.x.a(bhE().pageContext, this);
        }
        this.eNK.d(bhE().eWs, false);
        if (bhD() && bhE().eWr.ww().mLiveInfo.screen_direction != 2) {
            z = true;
        }
        this.eNK.jO(z);
    }

    private void bgC() {
        if (this.eOu || this.eOv) {
            if ((TbadkCoreApplication.isLogin() && this.eNO.uN().hasText()) || this.eOv) {
                this.eOu = false;
                this.eOv = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.15
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bhd();
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
                if (this.eMR != null) {
                    this.eMR.u(jSONObject);
                }
            } else if ("enter_live".equals(optString)) {
                if (this.eMQ.getCount() > 20) {
                    this.eMQ.cA(this.eMQ.getCount() + 1);
                } else if (this.eML != null) {
                    com.baidu.live.data.a vq = aVar.vq();
                    com.baidu.live.data.f fVar = new com.baidu.live.data.f();
                    fVar.Wg = new AlaLocationData();
                    fVar.Wh = new AlaRelationData();
                    fVar.Wf = new AlaLiveUserInfoData();
                    fVar.Wf.userId = JavaTypesHelper.toLong(vq.userId, 0L);
                    fVar.Wf.userName = vq.userName;
                    fVar.Wf.portrait = vq.portrait;
                    if (this.eML.c(fVar)) {
                        this.eMQ.cA(this.eMQ.getCount() + 1);
                    }
                }
            } else if ("update_liveinfo".equals(optString) && bhE().eWr.ww() != null && bhE().eWr.ww().mLiveInfo != null) {
                bhE().eWr.a(bhE().eWr.ww().mLiveInfo.live_id, bhE().fromType, bhE().enterTime);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void yp(String str) {
        if (this.eMS != null) {
            this.eMS.yp(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void b(l lVar) {
        super.b(lVar);
        if (this.eMM != null) {
            this.eMM.p(lVar);
        }
        if (this.eMN != null) {
            this.eMN.l(lVar);
        }
        if (this.eMR != null) {
            this.eMR.o(lVar);
        }
        if (this.eMV != null) {
            this.eMV.a(lVar);
        }
        iX(false);
        iV(false);
        if (this.eMS != null) {
            this.eMS.g(lVar);
            if (lVar != null && this.eOk != null && !this.eOk.hasInit && !TextUtils.isEmpty(this.eOk.eXn)) {
                this.eOk.hasInit = true;
                this.eMS.yq(this.eOk.eXn);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void c(com.baidu.live.data.g gVar) {
        if (gVar != null) {
            if (this.eML != null && gVar.getList() != null) {
                this.eML.f(gVar);
            }
            if (this.eMQ != null) {
                this.eMQ.cA(gVar.getCount());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void iJ(boolean z) {
        super.iJ(z);
        this.ePd = false;
        if (bhE().eWs != null) {
            bhE().eWs.bps();
            bhE().eWs.setOnDispatchTouchEventListener(null);
            bhE().eWs.setOnLiveViewScrollListener(null);
        }
        if (bhE().eWq != null) {
            bhE().eWq.setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.eMV != null) {
            this.eMV.oZ();
        }
        bgE();
        if (this.eMO != null) {
            this.eMO.oZ();
        }
        if (this.eNK != null) {
            this.eNK.release();
        }
        if (this.eMR != null) {
            this.eMR.oZ();
        }
        if (this.eMP != null) {
            this.eMP.bog();
        }
        if (this.eMN != null) {
            this.eMN.bjD();
            this.eMN.setVisible(8);
        }
        if (this.eMT != null) {
            this.eMT.oZ();
        }
        if (this.eMS != null) {
            this.eMS.release();
        }
        if (this.ePb != null) {
            this.ePb.setViewActionDispatched(false);
            this.ePb.removeAllViews();
            this.ePb = null;
        }
        if (this.eOZ != null) {
            this.eOZ.setViewActionDispatched(false);
            this.eOZ.removeAllViews();
            this.eOZ = null;
        }
        if (this.eMK != null) {
            this.eMK.removeAllViews();
            this.eMK = null;
        }
        if (this.eNK != null) {
            this.eNK.onDestroy();
        }
        if (this.eMU != null) {
            this.eMU.oZ();
        }
        if (this.eNh != null) {
            this.eNh.cancel();
        }
        if (this.eOA != null) {
            this.eOA.biH();
        }
        if (this.eNh != null) {
            this.eNh.oZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void iK(boolean z) {
        super.iK(z);
        bgE();
        if (this.eMM != null) {
            this.eMM.onDestroy();
        }
        if (this.eMO != null) {
            this.eMO.onDestroy();
        }
        if (this.eMR != null) {
            this.eMR.onDestroy();
        }
        if (this.eMT != null) {
            this.eMT.onDestroy();
        }
        if (this.eMU != null) {
            this.eMU.onDestroy();
        }
        if (this.eMV != null) {
            this.eMV.onDestroy();
        }
        if (this.eMW != null) {
            this.eMW.onDestroy();
        }
        if (this.eNY != null) {
            this.eNY.onDestroy();
        }
        if (this.eMN != null) {
            this.eMN.onDestroy();
        }
        if (this.eML != null) {
            this.eML.onDestroy();
        }
        if (this.eNO != null) {
            this.eNO.onDestroy();
        }
        if (this.eMP != null) {
            this.eMP.onDestory();
        }
        if (this.eMS != null) {
            this.eMS.release();
        }
        if (this.eOA != null) {
            this.eOA.jn(!z);
        }
        MessageManager.getInstance().removeMessageRule(this.eNi);
        MessageManager.getInstance().removeMessageRule(this.eNj);
        MessageManager.getInstance().unRegisterListener(this.eNl);
        MessageManager.getInstance().unRegisterListener(this.eNm);
        MessageManager.getInstance().unRegisterListener(this.ePf);
        MessageManager.getInstance().unRegisterListener(this.eNo);
        MessageManager.getInstance().unRegisterListener(this.eNp);
        MessageManager.getInstance().unRegisterListener(this.ePe);
        MessageManager.getInstance().unRegisterListener(this.eNq);
        MessageManager.getInstance().unRegisterListener(this.eNn);
    }

    private void bgE() {
        if (this.eNO != null && this.eNO.uM().getView() != null && this.eNO.uM().getView().getParent() != null) {
            ((ViewGroup) this.eNO.uM().getView().getParent()).removeView(this.eNO.uM().getView());
        }
        if (this.eMZ != null && this.eMZ.getParent() != null) {
            ((ViewGroup) this.eMZ.getParent()).removeView(this.eMZ);
        }
        if (this.eNO != null && this.eNO.uN().getView() != null) {
            this.eOn.removeView(this.eNO.uN().getView());
        }
        if (this.eNO != null) {
            this.eNO.uM().setMsgData(new LinkedList());
            this.eNO.us();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void a(w wVar) {
        if (this.eNO != null) {
            bhd();
            this.eNO.uN().setEditText(" @" + wVar.getNameShow() + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.eMP != null) {
            this.eMP.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void e(com.baidu.live.data.a aVar) {
        if (this.eNO != null) {
            bhd();
            this.eNO.uN().setEditText(" @" + aVar.userName + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.eMP != null) {
            this.eMP.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void b(w wVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected View bgF() {
        if (this.eNO != null) {
            return this.eNO.uN().getView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean bgG() {
        if (this.eNO == null || !this.eNO.uN().vR()) {
            return false;
        }
        iM(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean bgH() {
        return this.eMM == null || this.eMM.bgH();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup bgI() {
        return this.ePb;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup bgJ() {
        return this.eMK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 24009) {
            if (i2 == -1) {
                if (intent != null && "ala_live_room_show_gift_panel".equals(intent.getStringExtra("ala_live_room_show_panel_key"))) {
                    int intExtra = intent.getIntExtra("ala_live_room_gift_panel_tab_id", -1);
                    int intExtra2 = intent.getIntExtra("ala_live_room_gift_panel_category_id", -1);
                    int intExtra3 = intent.getIntExtra("ala_live_room_gift_panel_gift_id", -1);
                    this.eOr = false;
                    I(intExtra, intExtra2, intExtra3);
                    return;
                }
                bgx();
                return;
            }
            bhC();
        } else if (i == 25051 && i2 == -1 && this.eOA != null) {
            this.eOA.bkg();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.eNO != null && this.eNO.uM() != null) {
            this.eNO.uM().onKeyboardVisibilityChanged(z);
        }
        if (z || this.eNO == null || !this.eNO.uN().vR()) {
            if (z) {
                if (this.eMP != null) {
                    this.eMP.setVisibility(8);
                }
                if (this.eNQ != null && this.eNQ.rk() != null) {
                    this.eNQ.rk().setVisibility(8);
                }
                bgL();
                if (this.eNO != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eNO.uN().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.eNO.uN().getView().setLayoutParams(layoutParams);
                    this.eNO.uN().getView().setVisibility(0);
                    this.eNO.uN().setQuickInputPanelVisible(false);
                }
                if (this.eOm != null) {
                    this.eOm.setVisibility(8);
                }
                if (this.eMS != null) {
                    this.eMS.setVisible(8);
                }
                if (this.eNP != null) {
                    this.eNP.uU();
                }
                if (this.eOl != null) {
                    this.eOl.setCanVisible(false);
                }
            } else {
                bgK();
            }
            if (this.eNO != null && this.eMZ != null) {
                int equipmentHeight = (int) (((z ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(bhE().pageContext.getPageActivity())) + bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
                if (this.eOn.indexOfChild(this.eMZ) != -1 && this.eMZ.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eMZ.getLayoutParams();
                    layoutParams2.height = bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds27) + equipmentHeight;
                    this.eMZ.setLayoutParams(layoutParams2);
                }
                if (this.eMZ.indexOfChild(this.eNO.uM().getView()) != -1 && this.eNO.uM().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.eNO.uM().getView().getLayoutParams();
                    layoutParams3.height = equipmentHeight;
                    this.eNO.uM().getView().setLayoutParams(layoutParams3);
                }
                this.eNO.uM().uL();
            }
            if (this.eNS != null) {
                this.eNS.ax(z);
            }
        }
    }

    private void bgK() {
        if (this.eMP != null) {
            this.eMP.setVisibility(0);
        }
        if (this.eMZ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eMZ.getLayoutParams();
            layoutParams.bottomMargin = bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
            this.eMZ.setLayoutParams(layoutParams);
        }
        if (this.eNO != null) {
            bhe();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eNO.uN().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.eNO.uN().getView().setLayoutParams(layoutParams2);
        }
        if (this.eMP != null) {
            this.eMP.setVisibility(0);
        }
        if (this.eNQ != null && this.eNQ.rk() != null) {
            this.eNQ.rk().setVisibility(0);
        }
        if (this.eOm != null) {
            this.eOm.setVisibility(0);
        }
        if (this.eMS != null) {
            this.eMS.setVisible(0);
        }
        if (this.eNP != null) {
            this.eNP.uU();
        }
        if (this.eOl != null) {
            this.eOl.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgL() {
        if (this.eMZ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eMZ.getLayoutParams();
            boolean z = false;
            if (this.eNO != null && this.eNO.uN() != null) {
                z = this.eNO.uN().vQ();
            }
            int iR = iR(z);
            if (layoutParams.bottomMargin != iR) {
                layoutParams.bottomMargin = iR;
                this.eMZ.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iM(boolean z) {
        if (z) {
            this.eNO.uN().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eMZ.getLayoutParams();
            int quickInputPanelExpandHeight = this.eNO.uN().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.eMZ.setLayoutParams(layoutParams);
                if (this.eNO.uM() != null) {
                    this.eNO.uM().uL();
                    return;
                }
                return;
            }
            return;
        }
        bgK();
        onKeyboardVisibilityChanged(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void E(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.eML != null) {
                this.eML.bN(i3);
            }
            if (this.eMN != null) {
                this.eMN.bN(i3);
            }
        }
        super.E(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.tieba.ala.liveroom.b
    public boolean pr(int i) {
        boolean pr = super.pr(i);
        if (pr && 2 == i) {
            if (this.eMM.bgH()) {
                return false;
            }
            if (pr && this.eNK != null) {
                this.eNK.jP(false);
            }
        }
        return pr;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void pJ(int i) {
        super.pJ(i);
        if (i == 7 || i == 11) {
            if (this.eMP != null) {
                this.eMP.setVisibility(8);
            }
            if (this.eNO != null) {
                this.eNO.uM().getView().setVisibility(4);
            }
            if (this.eMS != null) {
                this.eMS.bj(2, 8);
            }
            if (this.eOe != null) {
                this.eOe.jK(false);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.tieba.ala.liveroom.b
    public void ps(int i) {
        super.ps(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.tieba.ala.liveroom.b
    public void pt(int i) {
        super.pt(i);
        if (i == 7 || i == 11) {
            if (this.eMP != null) {
                this.eMP.setVisibility(0);
            }
            if (this.eNO != null) {
                this.eNO.uM().getView().setVisibility(0);
            }
            if (this.eMS != null) {
                this.eMS.bj(2, 0);
            }
            if (this.eOe != null) {
                this.eOe.jK(true);
            }
            this.eOm.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void bgM() {
        super.bgM();
        if (this.eMO != null) {
            this.eMO.boF();
        }
        if (this.eMU != null) {
            this.eMU.pj();
        }
        if (this.eMS != null) {
            this.eMS.onStop();
        }
        if (this.eMT != null) {
            this.eMT.ao(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void bgN() {
        super.bgN();
        if (this.eMO != null) {
            this.eMO.boE();
        }
        if (this.eMU != null) {
            this.eMU.pk();
        }
        if (this.eMS != null) {
            this.eMS.onStart();
        }
        if (this.eMT != null) {
            this.eMT.ao(false);
        }
    }

    private ViewGroup.LayoutParams iZ(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.ePb == null) {
            return null;
        }
        int bhT = this.eLS ? bhT() : -2;
        ViewGroup.LayoutParams layoutParams2 = this.ePb.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, bhT);
        }
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds112);
        layoutParams.topMargin = bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200);
        return layoutParams;
    }

    private ViewGroup.LayoutParams bhU() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.eOZ == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams2 = this.eOZ.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
        return layoutParams;
    }
}
