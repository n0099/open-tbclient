package com.baidu.tieba.ala.liveroom.d;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.android.imsdk.internal.IMConnection;
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
import com.baidu.live.challenge.e;
import com.baidu.live.challenge.h;
import com.baidu.live.challenge.i;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.am;
import com.baidu.live.data.au;
import com.baidu.live.data.ay;
import com.baidu.live.data.bj;
import com.baidu.live.data.bw;
import com.baidu.live.data.cc;
import com.baidu.live.data.m;
import com.baidu.live.data.s;
import com.baidu.live.data.u;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.n;
import com.baidu.live.guardclub.j;
import com.baidu.live.im.k;
import com.baidu.live.message.GetQuickGiftHttpResponseMessage;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
import com.baidu.live.tbadk.core.atomdata.CommonWebViewActivityConfig;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.ala.liveroom.guide.a;
import com.baidu.tieba.ala.liveroom.j.b;
import com.baidu.tieba.ala.liveroom.j.g;
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends b implements com.baidu.live.j.c {
    private PendantParentView bkG;
    private com.baidu.tieba.ala.liveroom.v.b gpA;
    private com.baidu.tieba.ala.liveroom.audiencelist.b gpB;
    private com.baidu.tieba.ala.liveroom.l.a gpC;
    private com.baidu.tieba.ala.liveroom.activeview.b gpD;
    private com.baidu.live.d.a gpE;
    private i gpF;
    private h gpG;
    private com.baidu.tieba.ala.liveroom.c.a gpH;
    private FrameLayout gpK;
    private com.baidu.tieba.ala.liveroom.j.b gpT;
    private com.baidu.tieba.ala.liveroom.audiencelist.c gpx;
    private com.baidu.tieba.ala.liveroom.p.a gpy;
    private com.baidu.tieba.ala.liveroom.g.b gpz;
    private LinearLayout gse;
    private e gsf;
    private boolean gsg;
    private long lastClickTime = 0;
    private boolean gsh = false;
    private HttpRule gpU = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.gpF != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.gpF.Ce()) {
                httpMessage.addParam("ala_challenge_id", d.this.gpF.Ch());
            }
            return httpMessage;
        }
    };
    private HttpRule gpV = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.gpF != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.gpF.Ce()) {
                httpMessage.addParam("challenge_id", d.this.gpF.Ch());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c gpW = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.d.16
        @Override // com.baidu.live.liveroom.g.c
        public void Mc() {
            if (d.this.gqw != null) {
                d.this.gqw.mO(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void ce(boolean z) {
            if (z) {
                if (d.this.gqw != null) {
                    d.this.gqw.mO(true);
                }
            } else if (d.this.gqw != null) {
                d.this.gqw.mO(false);
            }
            if (d.this.gqO != null) {
                d.this.gqO.bm(z);
            }
            if (d.this.gpD != null) {
                d.this.gpD.lF(z ? false : true);
            }
            com.baidu.live.m.a.cf(z);
        }
    };
    private HttpMessageListener gpY = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.d.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Ml() != null) {
                        com.baidu.live.x.c.NS().bne = getQuickGiftHttpResponseMessage.Ml();
                        d.this.bOE();
                    }
                }
            }
        }
    };
    CustomMessageListener gqd = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.d.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.gpT.c(d.this.bPS());
                } else if (d.this.bPl() || !g.uw(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.19.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.bPS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.bPS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    d.this.gpT.c(d.this.gpK, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener gsi = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.d.d.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.bPl() || !g.uw(2913128)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.uu(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    d.this.Gq(str);
                }
            }
        }
    };
    private CustomMessageListener gpZ = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.gqE.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gqa = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.d.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.this.gqS != null) {
                    d.this.gqS.hn(str);
                }
            }
        }
    };
    CustomMessageListener gqb = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.grl != null && d.this.grl.bat != null && !d.this.grl.baw && !d.this.grl.bax && d.this.gqN != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.bPS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = d.this.bPS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                d.this.gqN.c(d.this.gpK, layoutParams);
                if (com.baidu.live.guardclub.e.IO() != null) {
                    com.baidu.live.guardclub.e.IO().IU();
                }
            }
        }
    };
    private CustomMessageListener gqc = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.gqP != null) {
                    d.this.gqP.dismiss();
                }
                if (d.this.gqS != null) {
                    d.this.gqS.dismiss();
                }
                if (d.this.gqQ != null) {
                    d.this.gqQ.dismiss();
                }
                if (d.this.grd != null) {
                    d.this.grd.dismiss();
                }
                com.baidu.live.im.b.d.Kh().setSwitchStatus(true);
                com.baidu.live.im.b.d.Kh().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bPs();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gqe = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.d.14
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void n(View view, int i) {
            bj bjVar;
            bw bwVar;
            cc ccVar;
            String str;
            bj bjVar2;
            bw bwVar2;
            String str2;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - d.this.lastClickTime >= 300) {
                d.this.lastClickTime = currentTimeMillis;
                if (i == 2) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel"));
                    d.this.K(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.x.c.NS().bne.Fe().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.x.c.NS().bne.Fe().Eh());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.x.c.NS().bne.Fe().Ei());
                        if (d.this.bPS().gAu.Fq() != null && d.this.bPS().gAu.Fq().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.bPS().gAu.Fq().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.bPS().gAu.Fq().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.KD());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.HV()) {
                        if (com.baidu.live.c.AR().getBoolean("quick_gift_guide_show", true) && !d.this.bPl()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, aa.class, d.this.bPS().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                aa aaVar = (aa) runTask.getData();
                                aaVar.setPageContext(d.this.bPS().pageContext);
                                aaVar.d(d.this.bPS().gAu.Fq());
                                aaVar.setGiftItem(com.baidu.live.x.c.NS().bne.Fe());
                                aaVar.setOtherParams(d.this.KD());
                                aaVar.initView();
                                aaVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.d.d.14.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        d.this.lM(false);
                                    }
                                });
                                aaVar.show();
                                d.this.lM(true);
                                return;
                            }
                            return;
                        }
                        n.a(d.this.bPS().pageContext, d.this.bPS().gAu.Fq(), com.baidu.live.x.c.NS().bne.Fe(), d.this.KD());
                    }
                } else if (i == 1) {
                    if (d.this.gqB != null) {
                        d.this.bPs();
                    }
                } else if (i == 3 && d.this.HV()) {
                    if (com.baidu.live.m.a.isDebug()) {
                        com.baidu.live.m.a.b(d.this.bPS().gAu.Fq().mLiveInfo.live_id, 0);
                        return;
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    d.this.gqo.c(d.this.bPS().gAu.Fq(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.bPS() != null && d.this.bPS().gAu != null && d.this.bPS().gAu.Fq() != null && d.this.bPS().gAu.Fq().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.bPS().gAu.Fq().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.bPS().gAu.Fq().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.bPS().gAu.Fq().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.KD());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.bPS() != null && d.this.bPS().gAu != null && d.this.bPS().gAu.Fq() != null && d.this.bPS().gAu.Fq().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.bPS().gAu.Fq().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.bPS().gAu.Fq().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.bPS().gAu.Fq().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.KD());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.bhb != null) {
                        d.this.bhb.bY(false);
                    }
                } else if (i == 12) {
                    if (d.this.gqw != null && d.this.bPS().gAu.Fq() != null && d.this.bPS().gAu.Fq().mLiveInfo != null) {
                        String valueOf = String.valueOf(d.this.bPS().gAu.Fq().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.bPS().gAu.Fq().mLiveInfo.room_id);
                        String str3 = null;
                        s sVar = d.this.bPS().gAu.Fq().mLiveSdkInfo;
                        if (sVar != null && sVar.mCastIds != null) {
                            str3 = String.valueOf(d.this.bPS().gAu.Fq().mLiveSdkInfo.mCastIds.aEU);
                        }
                        d.this.gqw.ai(valueOf, valueOf2, str3);
                        com.baidu.live.m.a.b(d.this.bPS().gAu.Fq().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    u Fq = d.this.bPS().gAu.Fq();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.bPS().pageContext.getPageActivity(), Fq.aEz.userName, Long.toString(Fq.aEz.userId), Long.toString(Fq.aEz.charmCount), String.valueOf(Fq.mLiveInfo.group_id), String.valueOf(Fq.mLiveInfo.live_id), false, String.valueOf(Fq.aEz.userId), Long.toString(Fq.aFb.userId), Fq.aFb.userName, Fq.aFb.portrait, d.this.gpB.getCount(), d.this.KD())));
                    LogManager.getCommonLogger().doClickGusetNumLog(Fq.mLiveInfo.feed_id, d.this.gpB.getCount() + "", d.this.KD());
                } else if (i == 11) {
                    d.this.bPv();
                    d.this.bPw();
                } else if (i == 16) {
                    if (d.this.bPS() != null && (bjVar2 = com.baidu.live.x.a.NN().bmW) != null && (bwVar2 = bjVar2.aKQ) != null) {
                        String str4 = bwVar2.aMb.aMi;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (d.this.bPS().gAu != null && d.this.bPS().gAu.Fq() != null && d.this.bPS().gAu.Fq().mLiveInfo != null) {
                                j = d.this.bPS().gAu.Fq().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", d.this.bPS().gAu.Fq().mLiveInfo.room_id + "", d.this.bPS().gAu.Fq().mLiveInfo.feed_id, d.this.KD());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.bPS().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (d.this.bPS() != null) {
                        u uVar = null;
                        if (d.this.bPS().gAu != null) {
                            uVar = d.this.bPS().gAu.Fq();
                        }
                        if (uVar != null && uVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.w.b.bYg().bhH != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.w.b.bYg().bhH.aEb;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + uVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + uVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(d.this.bPS().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17 && d.this.HV() && d.this.bPS() != null && (bjVar = com.baidu.live.x.a.NN().bmW) != null && (bwVar = bjVar.aKQ) != null && (ccVar = bwVar.aMc) != null && !TextUtils.isEmpty(ccVar.webUrl)) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                    if (d.this.gqP != null && d.this.bPS().gAu != null && d.this.bPS().gAu.Fq() != null) {
                        u Fq2 = d.this.bPS().gAu.Fq();
                        d.this.gqP.a(ccVar.webUrl, Fq2.mLiveInfo.live_id, Fq2.aFb.userId, Fq2.aEz.userId);
                    }
                }
            }
        }
    };
    private boolean gsj = false;
    private boolean gsk = false;

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.gqq = new com.baidu.tieba.ala.liveroom.guide.c(bPS().pageContext, this, false);
        this.gpU.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.gpU);
        this.gpV.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.gpV);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean bOo() {
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void n(u uVar) {
        super.n(uVar);
        g.bTk();
        this.gsh = true;
        this.gsk = false;
        this.gsj = false;
        bPS().gAv.setIsForceHandledTouch(false);
        bPS().gAv.setSwipeClearEnable(true);
        bPS().gAv.setOnLiveViewScrollListener(this.gpW);
        bPS().gAv.setOnClickListener(null);
        bPS().gAv.setClickable(false);
        if (this.gqt != null) {
            this.gqt.b(this.gqe);
        }
        if (this.gre != null) {
            this.gre.setVisibility(0);
        }
        bOv();
        if (this.gqL != null) {
            this.gqL.a(uVar, this.bkG);
            this.gqL.U(this.grf);
            this.gqL.a(this);
        }
        bQk();
        bOH();
        bPh();
        bOI();
        bOM();
        bOJ();
        lN(false);
        bPz();
        bPy();
        bOy();
        bOF();
        bPA();
        bOO();
        bOP();
        bQd();
        bQe();
        lO(false);
        bPC();
        bPK();
        bOx();
        bOE();
        bOz();
        bOA();
        bOB();
        bOC();
        bPG();
        bOr();
        lS(true);
        bPJ();
        c(this.fAJ);
        MessageManager.getInstance().registerListener(this.gpY);
        MessageManager.getInstance().registerListener(this.gpZ);
        MessageManager.getInstance().registerListener(this.gqb);
        MessageManager.getInstance().registerListener(this.gqc);
        MessageManager.getInstance().registerListener(this.gsi);
        MessageManager.getInstance().registerListener(this.gqd);
        MessageManager.getInstance().registerListener(this.gqa);
        bOR();
        bOL();
    }

    private void bOr() {
        if (this.gqY != null) {
            this.gqY.a(new com.baidu.live.t.c() { // from class: com.baidu.tieba.ala.liveroom.d.d.17
                @Override // com.baidu.live.t.c
                public void cl(boolean z) {
                    if (d.this.gpG != null) {
                        d.this.gpG.setNeedCloseRecommendFloat(z);
                    }
                    if (d.this.bPS().gAv.gPq) {
                        if (d.this.gqw != null) {
                            d.this.gqw.mH(z);
                            d.this.gqw.mO(!z);
                        }
                        if (d.this.gqt != null) {
                            d.this.gqt.mH(z);
                            d.this.gqt.setPraiseEnable(!z);
                            d.this.gqt.mG(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void l(u uVar) {
        super.l(uVar);
        if (this.gpy != null) {
            this.gpy.y(uVar);
        }
        if (this.gpz != null) {
            this.gpz.u(uVar);
        }
        if (this.gpC != null) {
            this.gpC.x(uVar);
        }
        if (this.gpG != null) {
            this.gpG.a(uVar);
        }
        lS(false);
        if (this.gpD != null) {
            this.gpD.k(uVar);
            this.gpD.lE(this.gro);
            this.gpD.updateView();
            if (uVar != null && this.gra != null && !this.gra.hasInit && !TextUtils.isEmpty(this.gra.aLk)) {
                this.gra.hasInit = true;
                this.gpD.Gm(this.gra.aLk);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(com.baidu.live.data.n nVar) {
        if (nVar != null) {
            if (this.gpx != null && nVar.getList() != null) {
                this.gpx.e(nVar);
            }
            if (this.gpB != null) {
                this.gpB.dP(nVar.getCount());
            }
        }
    }

    private void bOt() {
        if (this.gqv != null) {
            this.gqv.ax(bPS().gAt.getLiveContainerView());
        }
    }

    private void bQd() {
        if (this.gpH == null) {
            this.gpH = new com.baidu.tieba.ala.liveroom.c.a(bPS().pageContext);
        }
        if (bPS().gAu != null && bPS().gAu.Fq() != null && bPS().gAu.Fq().mLiveInfo != null) {
            this.gpH.Gn(String.valueOf(bPS().gAu.Fq().mLiveInfo.user_id));
        }
    }

    private void bQe() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (bPS() != null && bPS().gAu != null && bPS().gAu.Fq() != null && bPS().gAu.Fq().mLiveInfo != null) {
                j = bPS().gAu.Fq().mLiveInfo.room_id;
            }
            if (this.gqJ == null) {
                this.gqJ = new com.baidu.tieba.ala.liveroom.guide.a(bPS().pageContext, j);
            }
            this.gqJ.lL(this.grh);
            this.gqJ.a(new a.InterfaceC0627a() { // from class: com.baidu.tieba.ala.liveroom.d.d.4
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0627a
                public void bQn() {
                    if (d.this.bhb != null) {
                        d.this.bhb.bY(true);
                    }
                }
            });
            this.gqJ.at(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void dH(int i) {
        super.dH(i);
        bOt();
        if (this.gpG != null) {
            this.gpG.dH(i);
        }
    }

    private void bOv() {
        if (this.bkG == null) {
            this.bkG = new PendantParentView(bPS().pageContext.getPageActivity(), this.gsg ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            bPS().gAv.addView(this.bkG, new ViewGroup.LayoutParams(-1, -1));
            this.bkG.setDefaultItemMargin(bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.bkG.setPadding(bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20), 0, bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6), 0);
            bQf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQf() {
        int dimensionPixelSize;
        if (this.bkG != null) {
            this.bkG.setModel(this.gsg ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            int dimensionPixelSize2 = bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds220);
            int dimensionPixelSize3 = bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            if (this.gsg) {
                dimensionPixelSize = bQl();
            } else {
                dimensionPixelSize = bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200);
            }
            this.bkG.setPosition(dimensionPixelSize2, 0, dimensionPixelSize, dimensionPixelSize3);
            return;
        }
        bOv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQg() {
        if (bPS().gAv != null && !this.gsk) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.5
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.gpK != null && d.this.gqB != null && d.this.gqB.JJ() != null && d.this.gqB.JJ().getView() != null) {
                        if (d.this.gsg && !d.this.gri && d.this.bPS().gAv != null && d.this.bPS().gAv.getHeight() > 0) {
                            int be = d.this.gpG != null ? d.this.gpG.be(false) : 0;
                            ViewGroup.LayoutParams layoutParams = d.this.gpK.getLayoutParams();
                            int height = d.this.bPS().gAv.getHeight() - be;
                            int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                i += UtilHelper.getStatusBarHeight();
                            }
                            if (layoutParams != null && d.this.gqB != null) {
                                layoutParams.height = i + d.this.bPS().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height);
                                d.this.gpK.setLayoutParams(layoutParams);
                                ViewGroup.LayoutParams layoutParams2 = d.this.gqB.JJ().getView().getLayoutParams();
                                if (layoutParams2 != null) {
                                    layoutParams2.height = layoutParams.height - com.baidu.live.ac.b.cF(false);
                                    d.this.gqB.JJ().getView().setLayoutParams(layoutParams2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        int i2 = com.baidu.live.ac.b.i(false, d.this.gri);
                        if (d.this.grf.indexOfChild(d.this.gpK) != -1 && d.this.gpK.getLayoutParams() != null) {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) d.this.gpK.getLayoutParams();
                            layoutParams3.height = com.baidu.live.ac.b.c(false, false, d.this.gri);
                            d.this.gpK.setLayoutParams(layoutParams3);
                        }
                        if (d.this.gpK.indexOfChild(d.this.gqB.JJ().getView()) != -1 && d.this.gqB.JJ().getView().getLayoutParams() != null) {
                            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) d.this.gqB.JJ().getView().getLayoutParams();
                            layoutParams4.height = i2;
                            d.this.gqB.JJ().getView().setLayoutParams(layoutParams4);
                        }
                        d.this.gqB.JJ().JI();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQh() {
        if (bPS().gAv != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.6
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.gqD != null) {
                        if (d.this.gsg && !d.this.gri && d.this.bPS().gAv != null && d.this.bPS().gAv.getHeight() > 0) {
                            int height = (d.this.bPS().gAv.getHeight() - (d.this.gpG != null ? d.this.gpG.be(false) : 0)) + d.this.bPS().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            if (d.this.gqD != null) {
                                d.this.gqD.dP(height);
                            }
                        } else if (d.this.gqD != null) {
                            d.this.gqD.dP(com.baidu.live.ac.a.a(d.this.bPS().pageContext.getPageActivity(), false, false, d.this.gri));
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQi() {
        if (bPS().gAv != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.7
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    if (d.this.gqD != null) {
                        int h = com.baidu.live.ac.a.h(false, false);
                        if (!d.this.gsg || d.this.bPS().gAv == null || d.this.bPS().gAv.getHeight() <= 0) {
                            i = h;
                        } else {
                            int height = d.this.bPS().gAv.getHeight() - (d.this.gpG != null ? d.this.gpG.be(false) : 0);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            i = height + d.this.bPS().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height);
                        }
                        if (d.this.gqD != null) {
                            d.this.gqD.dQ(i);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQj() {
        if (this.gqC != null && this.gqC.Bo() != null) {
            ViewGroup.LayoutParams layoutParams = this.gqC.Bo().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bPS().pageContext.getResources().getDimensionPixelOffset(this.gsg ? a.e.sdk_ds100 : a.e.sdk_ds20);
                this.gqC.Bo().setLayoutParams(layoutParams);
            }
        }
    }

    private void bQk() {
        if (this.gse == null) {
            this.gse = new LinearLayout(bPS().pageContext.getPageActivity());
            this.gse.setOrientation(1);
        }
        if (this.gse.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds160);
            layoutParams.leftMargin = bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bPS().gAv.addView(this.gse, layoutParams);
        }
    }

    private void bOy() {
        if (this.gqs != null && bPS() != null && bPS().gAu != null) {
            this.gqs.c(bPS().gAt.getLiveContainerView(), bPS().gAu.Fq());
        }
    }

    private void bOx() {
        if (this.gpD == null) {
            this.gpD = new com.baidu.tieba.ala.liveroom.activeview.b(bPS().pageContext);
        }
        if (bPS() != null && bPS().gAu != null) {
            this.gpD.Gj(bPS().gAu.bXB());
        }
        this.gpD.lD(this.gsg);
        this.gpD.setOtherParams(KD());
        this.gpD.b(bPS().gAu.Fq(), false);
        this.gpD.setHost(false);
        this.gpD.lE(this.gro);
        this.gpD.a(1, this.bkG);
        this.gpD.a(2, this.bkG);
        this.gpD.setVisible(this.gri ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOE() {
        if (this.gqm == null) {
            bOJ();
        }
        this.gqm.setOtherParams(KD());
        this.gqm.a(com.baidu.live.x.c.NS().bne, bPS().gAu.Fq());
    }

    private void bOz() {
        if (this.gpC == null) {
            this.gpC = new com.baidu.tieba.ala.liveroom.l.a(bPS().pageContext, this);
        }
        this.gpC.setOtherParams(KD());
        this.gpC.a((ViewGroup) this.bkG, bOD());
        this.gpC.x(bPS().gAu.Fq());
    }

    private void bOA() {
        if (this.gqN == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, j.class, bPS().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gqN = (j) runTask.getData();
            } else {
                return;
            }
        }
        this.gqN.setOtherParams(KD());
        if (this.gpK != null && this.gpK.indexOfChild(this.gqN.getView()) >= 0) {
            this.gpK.removeView(this.gqN.getView());
        }
    }

    private void bOB() {
        if (this.gqm != null) {
            this.gqm.a(new a.InterfaceC0634a() { // from class: com.baidu.tieba.ala.liveroom.d.d.8
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0634a
                public void bK(int i, int i2) {
                    u Fq = d.this.bPS().gAu.Fq();
                    if (Fq != null && Fq.mLiveInfo != null) {
                        if (d.this.gqR == null) {
                            d.this.gqR = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.bPS().pageContext.getPageActivity());
                        }
                        d.this.gqR.d(d.this.grf, i, i2);
                        d.this.gqR.a(String.valueOf(Fq.mLiveInfo.live_id), new a.InterfaceC0638a() { // from class: com.baidu.tieba.ala.liveroom.d.d.8.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0638a
                            public void a(float f, String str) {
                                if (d.this.gqm != null) {
                                    d.this.gqm.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0634a
                public void bL(int i, int i2) {
                    if (d.this.gqR != null) {
                        d.this.gqR.bQ(i, i2);
                    }
                }
            });
        }
    }

    private void bOC() {
        if (this.grt == null) {
            this.grt = new com.baidu.tieba.ala.liveroom.j.e(bPS().pageContext);
        }
        this.grt.setRoomId(bPS().gAu.Fq().mLiveInfo.room_id);
        this.grt.GC("");
        this.grt.b(bPS().gAu.Fq(), this.bkG);
        if (this.gpT == null) {
            this.gpT = new com.baidu.tieba.ala.liveroom.j.b(bPS().pageContext, KD(), this.grt, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.9
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bPa() {
                    d.this.lM(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bPb() {
                    d.this.lM(false);
                }
            });
        }
        this.gpT.setRoomId(bPS().gAu.Fq().mLiveInfo.room_id);
        if (this.gpK != null && this.gpK.indexOfChild(this.gpT.getView()) >= 0) {
            this.gpK.removeView(this.gpT.getView());
        }
        if (this.gpT != null) {
            this.gpT.b(bPS());
        }
    }

    private LinearLayout.LayoutParams bOD() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    private void bOF() {
        CustomResponsedMessage runTask;
        if (this.gqB == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, bPS().pageContext)) != null && runTask.getData() != null) {
            this.gqB = (k) runTask.getData();
            this.gqB.setFromMaster(false);
            this.gqB.JJ().getView().setId(a.g.ala_liveroom_msg_list);
            this.gqB.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.10
                @Override // com.baidu.live.im.k.a
                public boolean JM() {
                    return d.this.HV();
                }

                @Override // com.baidu.live.im.k.a
                public void JN() {
                    d.this.grm = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hd(String str) {
                    if (!d.this.gri) {
                        d.this.lK(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.bPS().pageContext.getPageActivity(), d.this.bPS().gAt.getLiveContainerView());
                    }
                    d.this.Gp(str);
                }

                @Override // com.baidu.live.im.k.a
                public void JO() {
                    if (d.this.gri) {
                        d.this.lK(true);
                        d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.bPS().pageContext.getPageActivity(), d.this.bPS().gAt.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.gqB != null) {
                        d.this.gqB.JK().setQuickInputPanelVisible(false);
                        d.this.gqB.JK().Lg();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void JP() {
                    if (d.this.gri) {
                        d.this.bOZ();
                        if (d.this.gqC != null) {
                            d.this.gqC.Bp();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean JQ() {
                    return d.this.bPm();
                }

                @Override // com.baidu.live.im.k.a
                public int JR() {
                    return d.this.bPn();
                }
            });
            this.gpK = new FrameLayout(bPS().pageContext.getPageActivity());
            this.gpK.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.gqB != null && this.gpK != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bPS().pageContext.getPageActivity()) * 0.7f);
            int i = com.baidu.live.ac.b.i(false, false);
            if (this.grf.indexOfChild(this.gpK) < 0) {
                if (this.gpK.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gpK.getParent()).removeView(this.gpK);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.live.ac.b.c(false, false, false));
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.live.ac.b.cE(false);
                this.grf.addView(this.gpK, layoutParams);
            }
            if (this.gpK.indexOfChild(this.gqB.JJ().getView()) < 0) {
                if (this.gqB.JJ().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gqB.JJ().getView()).removeView(this.gqB.JJ().getView());
                }
                this.gpK.addView(this.gqB.JJ().getView(), new FrameLayout.LayoutParams(equipmentWidth, i));
            }
            if (bPS().gAv.indexOfChild(this.gqB.JK().getView()) < 0) {
                if (this.gqB.JK().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gqB.JK().getView().getParent()).removeView(this.gqB.JK().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bPt();
                bPS().gAv.addView(this.gqB.JK().getView(), layoutParams2);
            }
            u Fq = bPS().gAu.Fq();
            if (Fq != null && Fq.mLiveInfo != null) {
                this.gqB.setLogData(Fq.mLiveInfo.feed_id, KD());
            }
            this.gqB.a(String.valueOf(bPS().gAu.Fq().mLiveInfo.group_id), String.valueOf(bPS().gAu.Fq().mLiveInfo.last_msg_id), String.valueOf(bPS().gAu.Fq().aEz.userId), String.valueOf(bPS().gAu.Fq().mLiveInfo.live_id), bPS().gAu.Fq().aEz.appId, (Fq == null || Fq.aFp == null || !Fq.aFp.CD()) ? false : true);
            lK(false);
        }
    }

    private void bOH() {
        if (this.gpy == null) {
            this.gpy = new com.baidu.tieba.ala.liveroom.p.a(bPS().pageContext, false, this);
        }
        this.gpy.d(this.gre, bPS().gAu.Fq());
        this.gpy.a(this.gqe);
        this.gpy.setOtherParams(KD());
    }

    private void bOI() {
        if (this.gpx == null) {
            this.gpx = new com.baidu.tieba.ala.liveroom.audiencelist.c(bPS().pageContext, this, false);
        }
        this.gpx.a(String.valueOf(bPS().gAu.Fq().mLiveInfo.group_id), String.valueOf(bPS().gAu.Fq().mLiveInfo.live_id), String.valueOf(bPS().gAu.Fq().aEz.userId), bPS().gAu.Fq());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.gqn != null && this.gqn.getView() != null && this.gqn.getView().getParent() != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.gpx.c(this.gre, i, a.g.ala_liveroom_audience_count_layout);
            this.gpx.e(bPS().gAu.bJE());
            this.gpx.setOtherParams(KD());
        }
    }

    private void bOJ() {
        com.baidu.live.core.a.a Lu;
        if (this.gqm == null) {
            this.gqm = new com.baidu.tieba.ala.liveroom.operation.a(bPS().pageContext);
        }
        this.gqm.a(bPS(), this.grf, bPS().gAu.Fq().mLiveInfo, true, this.gqe);
        this.gqm.setOtherParams(KD());
        if (this.gqL != null && (Lu = this.gqL.Lu()) != null) {
            View rootLayout = Lu.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.gqm.bT(rootLayout);
        }
    }

    public void lR(boolean z) {
        if (this.gqm != null) {
            this.gqm.lR(z);
        }
    }

    private void bOM() {
        if (this.gpB == null) {
            this.gpB = new com.baidu.tieba.ala.liveroom.audiencelist.b(bPS().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (bPS().gAu.bJE() != null) {
            j = bPS().gAu.bJE().getCount();
        }
        this.gpB.a(this.gqe);
        this.gpB.a(this.gre, a.g.ala_liveroom_hostheader, j);
        this.gpB.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.gpB.lV(false);
        } else {
            this.gpB.lV(true);
        }
    }

    protected void Gq(String str) {
        if (this.grs == null) {
            this.grs = new com.baidu.tieba.ala.liveroom.u.b(bPS().pageContext);
        }
        this.grs.b(this.grf, str);
        lM(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.11
            @Override // java.lang.Runnable
            public void run() {
                d.this.grs.bXT();
                d.this.lM(false);
            }
        }, 5000L);
    }

    private void lS(boolean z) {
        CustomResponsedMessage runTask;
        if (bPS().gAu.Fq().mLiveInfo.live_type == 1 && this.gsh) {
            if (this.gsf == null && (runTask = MessageManager.getInstance().runTask(2913074, e.class, bPS().pageContext)) != null && runTask.getData() != null) {
                this.gsf = (e) runTask.getData();
            }
            if (this.gsf != null) {
                if (this.gpF == null) {
                    this.gpF = this.gsf.a(bPS().pageContext);
                }
                if (bPS().gAu.Fq().mLiveInfo.challengeId > 0 && !this.gpF.Cf()) {
                    this.gpF.e(bPS().gAu.Fq().mLiveInfo.live_id, bPS().gAu.Fq().aEz.userId);
                    lT(z);
                    if (z) {
                        this.gpF.a(bPS().gAu.bWI());
                    }
                    this.gpF.c(bPS().gAu.Fq());
                }
            }
        }
    }

    private void lT(boolean z) {
        if (this.gpG == null) {
            this.gpG = this.gsf.b(bPS().pageContext);
            this.gpG.a(new com.baidu.live.challenge.g() { // from class: com.baidu.tieba.ala.liveroom.d.d.13
                @Override // com.baidu.live.challenge.g
                public void BU() {
                    d.this.bPS().gAv.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.g
                public void a(au auVar, ay ayVar, ay ayVar2) {
                    d.this.gsg = true;
                    if (d.this.gqt != null) {
                        d.this.gqt.setPraiseEnable(false);
                        d.this.bPS().gAv.gPq = false;
                    }
                    if (d.this.gqW != null) {
                        d.this.gqW.setCanVisible(false);
                    }
                    if (d.this.gqu != null) {
                        d.this.gqu.bYe();
                    }
                    if (d.this.gpC != null) {
                        d.this.gpC.setCanVisible(false);
                        d.this.gpC.bTo();
                    }
                    if (d.this.gpD != null) {
                        d.this.gpD.lD(true);
                    }
                    if (d.this.grt != null) {
                        d.this.grt.setVisible(8);
                    }
                    if (d.this.gpE != null) {
                        d.this.gpE.setCanVisible(false);
                        d.this.gpE.setVisible(8);
                    }
                    d.this.bQf();
                    d.this.bQg();
                    d.this.bQh();
                    d.this.bQi();
                    d.this.bQj();
                    if (d.this.bPS().bhe != null) {
                        d.this.bPS().bhe.getLivePlayer().setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                    }
                    if (d.this.gqr != null) {
                        d.this.gqr.setTimeTextMode(true);
                    }
                    if (d.this.bhb != null && ayVar != null && ayVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(ayVar.aJW);
                        arrayList.add(ayVar2.aJW);
                        com.baidu.live.liveroom.a.c cVar = d.this.bhb;
                        if (d.this.grp) {
                            arrayList = null;
                        }
                        cVar.o(arrayList);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void BV() {
                }

                @Override // com.baidu.live.challenge.g
                public void BW() {
                }

                @Override // com.baidu.live.challenge.g
                public void bc(boolean z2) {
                    d.this.bPS().gAv.setSwipeClearEnable(true);
                    d.this.gsg = false;
                    if (d.this.gqt != null) {
                        d.this.gqt.setPraiseEnable(true);
                        d.this.bPS().gAv.gPq = true;
                    }
                    if (d.this.gqW != null) {
                        d.this.gqW.setCanVisible(true);
                    }
                    if (d.this.gqu != null) {
                        d.this.gqu.bYf();
                    }
                    if (d.this.gpC != null) {
                        d.this.gpC.setCanVisible(true);
                        d.this.gpC.x(d.this.bPS().gAu.Fq());
                    }
                    if (d.this.gqw != null) {
                        d.this.gqw.mO(true);
                    }
                    if (d.this.gpD != null) {
                        d.this.gpD.lD(false);
                    }
                    if (d.this.grt != null) {
                        d.this.grt.setVisible(0);
                    }
                    if (d.this.gpE != null) {
                        d.this.gpE.setCanVisible(true);
                        d.this.gpE.setVisible(0);
                    }
                    d.this.bQf();
                    d.this.bQg();
                    d.this.bQh();
                    d.this.bQi();
                    d.this.bQj();
                    if (d.this.bhb != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.bPS().gAu.bXx());
                        com.baidu.live.liveroom.a.c cVar = d.this.bhb;
                        if (d.this.grp) {
                            arrayList = null;
                        }
                        cVar.o(arrayList);
                    }
                    if (d.this.bPS().bhe != null) {
                        d.this.bPS().bhe.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
                    }
                    if (d.this.gqr != null) {
                        d.this.gqr.setTimeTextMode(false);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void bd(boolean z2) {
                    if (z2 && d.this.gqY != null) {
                        d.this.gqY.onClose();
                    }
                }
            });
        }
        this.gpG.a(this.gpF);
        this.gpG.m(bPS().gAt.getLiveContainerView());
        this.gpG.b(z, false, false);
        this.gpF.a((i.c) this.gpG);
    }

    public void bON() {
        this.gqo.c(bPS().gAu.Fq(), false);
    }

    public void bOO() {
        if (bPS().gAu.Fq() != null && bPS().gAu.Fq().aEz != null && bPS().gAu.Fq().mLiveInfo != null) {
            if (this.gpA == null) {
                this.gpA = new com.baidu.tieba.ala.liveroom.v.b(bPS().pageContext);
            }
            long j = bPS().gAu.Fq().aEz.userId;
            int i = bPS().gAu.Fq().mLiveInfo.live_type;
            String str = bPS().gAu.Fq().aEz.portrait;
            String str2 = bPS().gAu.Fq().mLiveInfo.feed_id;
            long j2 = bPS().gAu.Fq().mLiveInfo.live_id;
            this.gpA.a(i, j, bPS().gAu.Fq().aEz.userName, false, str, KD(), str2, j2);
            this.gpA.at(this.gre);
        }
    }

    private int bQl() {
        return (this.gpG != null ? this.gpG.be(false) : 0) + bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    private void bOP() {
        boolean z = true;
        if (this.gqw == null) {
            this.gqw = new com.baidu.tieba.ala.liveroom.x.a(bPS().pageContext, this);
        }
        this.gqw.d(bPS().gAv, false);
        AlaLiveInfoData alaLiveInfoData = bPS().gAu.Fq().mLiveInfo;
        if (alaLiveInfoData != null) {
            boolean z2 = bPR() && alaLiveInfoData.screen_direction != 2;
            boolean isZanAnimUnabled = alaLiveInfoData.mAlaLiveSwitchData != null ? alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled() : false;
            if (!z2 || isZanAnimUnabled) {
                z = false;
            }
            this.gqw.mN(z);
        }
    }

    private void bOR() {
        if (this.grm || this.grn) {
            if ((TbadkCoreApplication.isLogin() && this.gqB.JK().hasText()) || this.grn) {
                this.grm = false;
                this.grn = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.15
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bPs();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void bOK() {
        bOL();
    }

    private void bOL() {
        if (this.gqm != null) {
            int i = bPS().gAu.Fq().aFb.isUegBlock;
            int i2 = bPS().gAu.Fq().aFb.isBlock;
            String str = bPS().gAu.Fq().aFb.userName;
            if (i > 0 || i2 > 0) {
                this.gqm.b(true, i, i2, str);
                this.gqB.a(true, i, i2, str);
                this.gqH.b(true, i, i2, str);
                return;
            }
            this.gqm.b(false, i, i2, str);
            this.gqB.a(false, i, i2, str);
            this.gqH.b(false, i, i2, str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        super.r(aVar);
        if (this.gpD != null) {
            this.gpD.y(aVar);
        }
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
        } catch (JSONException e) {
            jSONObject = null;
        }
        try {
            jSONObject.put("log_id", aVar.getMsgId());
            jSONObject2 = jSONObject;
        } catch (JSONException e2) {
            jSONObject2 = jSONObject;
            if (aVar.getMsgType() != 12) {
            }
            if (jSONObject2 == null) {
            }
        }
        if (aVar.getMsgType() != 12 || aVar.getMsgType() == 13) {
            if (jSONObject2 == null) {
                String optString = jSONObject2.optString("content_type");
                if ("task".equals(optString)) {
                    if (this.gpC != null) {
                        this.gpC.J(jSONObject2);
                    }
                } else if ("enter_live".equals(optString)) {
                    if (this.gpB != null && this.gpB.getCount() > 20) {
                        this.gpB.dP(this.gpB.getCount() + 1);
                    } else if (this.gpx != null) {
                        com.baidu.live.data.a Ko = aVar.Ko();
                        m mVar = new m();
                        mVar.aEA = new AlaLocationData();
                        mVar.aEB = new AlaRelationData();
                        mVar.aEz = new AlaLiveUserInfoData();
                        mVar.aEz.userId = JavaTypesHelper.toLong(Ko.userId, 0L);
                        mVar.aEz.userName = Ko.userName;
                        mVar.aEz.portrait = Ko.portrait;
                        if (this.gpB != null && this.gpx.c(mVar)) {
                            this.gpB.dP(this.gpB.getCount() + 1);
                        }
                    }
                } else if ("update_liveinfo".equals(optString)) {
                    if (bPS().gAu.Fq() != null && bPS().gAu.Fq().mLiveInfo != null) {
                        bPS().gAu.a(bPS().gAu.Fq().mLiveInfo.live_id, bPS().fromType, bPS().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && bPS().gAu.Fq() != null && bPS().gAu.Fq().mLiveInfo != null && bPS().gAu.Fq().aFb != null && this.gpG != null) {
                    long optLong = jSONObject2.optLong("mvp_user_id");
                    long optLong2 = jSONObject2.optLong("winner_live_id");
                    if (optLong == bPS().gAu.Fq().aFb.userId && optLong2 == bPS().gAu.Fq().mLiveInfo.live_id) {
                        this.gpG.c(jSONObject2.optInt("challenge_status"), jSONObject2.optLong("challenge_id"));
                    }
                }
            } else {
                return;
            }
        }
        if (this.gqW == null || this.gqW.N(jSONObject2)) {
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void Gl(String str) {
        if (this.gpD != null) {
            this.gpD.Gl(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void cd(boolean z) {
        super.cd(z);
        if (bPS().gAv != null) {
            bPS().gAv.bYR();
            bPS().gAv.setLiveViewOnDispatchTouchEventListener(null);
            bPS().gAv.setLiveViewOnTouchEventListener(null);
            bPS().gAv.setOnLiveViewScrollListener(null);
        }
        if (bPS().bhe != null) {
            bPS().bhe.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.gpG != null) {
            this.gpG.BQ();
        }
        bOS();
        if (this.gpA != null) {
            this.gpA.BQ();
        }
        if (this.gqw != null) {
            this.gqw.release();
        }
        if (this.gpC != null) {
            this.gpC.BQ();
        }
        if (this.gqm != null) {
            this.gqm.bXE();
        }
        if (this.gpz != null) {
            this.gpz.bSj();
            this.gpz.setVisible(8);
        }
        if (this.gpE != null) {
            this.gpE.BQ();
        }
        if (this.gpD != null) {
            this.gpD.release();
        }
        if (this.bkG != null) {
            this.bkG.removeAllViews();
            this.bkG = null;
        }
        if (this.gse != null) {
            this.gse.removeAllViews();
            this.gse = null;
        }
        if (this.gqw != null) {
            this.gqw.onDestroy();
        }
        if (this.gpF != null) {
            this.gpF.BQ();
        }
        if (this.gpy != null) {
            this.gpy.bUo();
        }
        if (this.gpT != null) {
            this.gpT.cancel();
        }
        if (this.grt != null) {
            this.grt.bRc();
        }
        if (this.gqW != null) {
            this.gqW.IT();
        }
        if (this.gpT != null) {
            this.gpT.BQ();
        }
        if (this.grc != null) {
            this.grc.BQ();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cb(boolean z) {
        super.cb(z);
        bOS();
        if (this.gpy != null) {
            this.gpy.onDestroy();
        }
        if (this.gpA != null) {
            this.gpA.onDestroy();
        }
        if (this.gpC != null) {
            this.gpC.onDestroy();
        }
        if (this.gpE != null) {
            this.gpE.onDestroy();
        }
        if (this.gpF != null) {
            this.gpF.onDestroy();
        }
        if (this.gpG != null) {
            this.gpG.onDestroy();
        }
        if (this.gpH != null) {
            this.gpH.onDestroy();
        }
        if (this.gqJ != null) {
            this.gqJ.onDestroy();
        }
        if (this.gpz != null) {
            this.gpz.onDestroy();
        }
        if (this.gpx != null) {
            this.gpx.onDestroy();
        }
        if (this.gqB != null) {
            this.gqB.onDestroy();
        }
        if (this.gqm != null) {
            this.gqm.onDestory();
        }
        if (this.gpD != null) {
            this.gpD.release();
        }
        if (this.grt != null) {
            this.grt.cb(!z);
        }
        if (this.gpT != null) {
            this.gpT.onDestroy();
            this.gpT = null;
        }
        if (this.grc != null) {
            this.grc.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.gpU);
        MessageManager.getInstance().removeMessageRule(this.gpV);
        MessageManager.getInstance().unRegisterListener(this.gpY);
        MessageManager.getInstance().unRegisterListener(this.gpZ);
        MessageManager.getInstance().unRegisterListener(this.gqb);
        MessageManager.getInstance().unRegisterListener(this.gqc);
        MessageManager.getInstance().unRegisterListener(this.gsi);
        MessageManager.getInstance().unRegisterListener(this.gqd);
        MessageManager.getInstance().unRegisterListener(this.gqa);
    }

    private void bOS() {
        if (this.gqB != null && this.gqB.JJ().getView() != null && this.gqB.JJ().getView().getParent() != null) {
            ((ViewGroup) this.gqB.JJ().getView().getParent()).removeView(this.gqB.JJ().getView());
        }
        if (this.gpK != null && this.gpK.getParent() != null) {
            ((ViewGroup) this.gpK.getParent()).removeView(this.gpK);
        }
        if (this.gqB != null && this.gqB.JK().getView() != null) {
            this.grf.removeView(this.gqB.JK().getView());
        }
        if (this.gqB != null) {
            this.gqB.JJ().setMsgData(new LinkedList());
            this.gqB.Bq();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void a(am amVar) {
        if (this.gqB != null) {
            bPs();
            this.gqB.JK().setEditText(" @" + amVar.getNameShow() + " ");
        }
        if (this.gqm != null) {
            this.gqm.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void g(com.baidu.live.data.a aVar) {
        if (this.gqB != null) {
            bPs();
            this.gqB.JK().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.gqm != null) {
            this.gqm.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void b(am amVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected View bOT() {
        if (this.gqB != null) {
            return this.gqB.JK().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean bOU() {
        if (this.gqB == null || !this.gqB.JK().Lf()) {
            return false;
        }
        lK(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected boolean bOV() {
        return this.gpy == null || this.gpy.bOV();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    /* renamed from: bQm */
    public PendantParentView bOW() {
        return this.bkG;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected ViewGroup bOX() {
        return this.gse;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 24009) {
            if (i2 == -1) {
                if (intent != null && "ala_live_room_show_gift_panel".equals(intent.getStringExtra("ala_live_room_show_panel_key"))) {
                    int intExtra = intent.getIntExtra("ala_live_room_gift_panel_tab_id", -1);
                    int intExtra2 = intent.getIntExtra("ala_live_room_gift_panel_category_id", -1);
                    int intExtra3 = intent.getIntExtra("ala_live_room_gift_panel_gift_id", -1);
                    this.grj = false;
                    K(intExtra, intExtra2, intExtra3);
                    return;
                }
                bON();
                return;
            }
            aoL();
        } else if (i == 25051 && i2 == -1 && this.grt != null) {
            this.grt.bTf();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.gqB != null && this.gqB.JJ() != null) {
            this.gqB.JJ().onKeyboardVisibilityChanged(z);
        }
        if (z || this.gqB == null || this.gqB.JK() == null || !this.gqB.JK().Lf()) {
            if (z) {
                if (this.gqm != null) {
                    this.gqm.setVisibility(8);
                }
                if (this.gqD != null && this.gqD.EV() != null) {
                    this.gqD.EV().setVisibility(8);
                }
                bOZ();
                if (this.gqB != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gqB.JK().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.gqB.JK().getView().setLayoutParams(layoutParams);
                    this.gqB.JK().getView().setVisibility(0);
                    this.gqB.JK().setQuickInputPanelVisible(false);
                }
                if (this.gre != null) {
                    this.gre.setVisibility(8);
                }
                if (this.gpD != null) {
                    this.gpD.setVisible(8);
                }
                if (this.gqC != null) {
                    this.gqC.Bp();
                }
                if (this.grb != null) {
                    this.grb.setCanVisible(false);
                }
                if (this.gqV != null) {
                    this.gqV.setCanVisible(false);
                }
                if (this.gqW != null) {
                    this.gqW.setCanVisible(false);
                }
            } else {
                bOY();
            }
            bQg();
            if (this.gqO != null) {
                this.gqO.bl(z);
            }
        }
    }

    private void bOY() {
        if (this.gqm != null) {
            this.gqm.setVisibility(0);
        }
        if (this.gpK != null) {
            if (this.gsk) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gpK.getLayoutParams();
                layoutParams.bottomMargin = (J(false, false) - bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) + com.baidu.live.ac.b.PI();
                this.gpK.setLayoutParams(layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gpK.getLayoutParams();
                layoutParams2.bottomMargin = bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
                this.gpK.setLayoutParams(layoutParams2);
            }
        }
        if (this.gqB != null) {
            bPt();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gqB.JK().getView().getLayoutParams();
            layoutParams3.bottomMargin = 0;
            this.gqB.JK().getView().setLayoutParams(layoutParams3);
        }
        if (this.gqm != null) {
            this.gqm.setVisibility(0);
        }
        if (this.gqD != null && this.gqD.EV() != null) {
            this.gqD.EV().setVisibility(0);
        }
        if (this.gre != null) {
            this.gre.setVisibility(0);
        }
        if (this.gpD != null) {
            this.gpD.setVisible(0);
        }
        if (this.gqC != null) {
            this.gqC.Bp();
        }
        if (this.grb != null) {
            this.grb.setCanVisible(true);
        }
        if (this.gqV != null) {
            this.gqV.setCanVisible(true);
        }
        if (this.gqW != null) {
            this.gqW.setCanVisible(!this.gsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOZ() {
        boolean z;
        boolean z2 = false;
        if (this.gpK != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gpK.getLayoutParams();
            if (this.gqB == null || this.gqB.JK() == null) {
                z = false;
            } else {
                z = this.gqB.JK().Ld();
                z2 = this.gqB.JK().Le();
            }
            int J = J(z, z2);
            if (layoutParams.bottomMargin != J) {
                layoutParams.bottomMargin = J;
                this.gpK.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lK(boolean z) {
        this.gsj = z;
        if (z) {
            this.gqB.JK().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gpK.getLayoutParams();
            int quickInputPanelExpandHeight = this.gqB.JK().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.gpK.setLayoutParams(layoutParams);
                if (this.gqB.JJ() != null) {
                    this.gqB.JJ().JI();
                    return;
                }
                return;
            }
            return;
        }
        bOY();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.gpx != null) {
                this.gpx.dD(i3);
            }
            if (this.gpz != null) {
                this.gpz.dD(i3);
            }
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public boolean eC(int i) {
        boolean eC = super.eC(i);
        if (eC && 2 == i) {
            if (this.gpy.bOV()) {
                return false;
            }
            if (eC && this.gqw != null) {
                this.gqw.mO(false);
            }
        }
        return eC;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void uj(int i) {
        super.uj(i);
        if (i == 7 || i == 11) {
            if (this.gqm != null) {
                this.gqm.setVisibility(8);
            }
            if (this.gqB != null) {
                this.gqB.JJ().getView().setVisibility(4);
            }
            if (this.gpD != null) {
                this.gpD.bI(2, 8);
                if (this.gsg) {
                    this.gpD.bI(1, 8);
                }
            }
            if (this.gqR != null) {
                this.gqR.mJ(false);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public void eD(int i) {
        super.eD(i);
        if (i == 7 || i == 11) {
            if (this.gqm != null) {
                this.gqm.setVisibility(0);
            }
            if (this.gqB != null) {
                this.gqB.JJ().getView().setVisibility(0);
            }
            if (this.gpD != null) {
                this.gpD.setVisible(0);
            }
            if (this.gqR != null) {
                this.gqR.mJ(true);
            }
            this.gre.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.gpA != null) {
            this.gpA.bXV();
        }
        if (this.gpF != null) {
            this.gpF.BY();
        }
        if (this.gpD != null) {
            this.gpD.onStop();
        }
        if (this.gpE != null) {
            this.gpE.bb(true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.gpA != null) {
            this.gpA.bXU();
        }
        if (this.gpF != null && this.gsh) {
            this.gpF.BZ();
        }
        if (this.gpD != null) {
            this.gpD.onStart();
        }
        if (this.gpE != null) {
            this.gpE.bb(false);
        }
    }
}
