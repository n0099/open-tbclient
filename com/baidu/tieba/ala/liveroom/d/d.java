package com.baidu.tieba.ala.liveroom.d;

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
import com.baidu.live.challenge.e;
import com.baidu.live.challenge.h;
import com.baidu.live.challenge.i;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.af;
import com.baidu.live.data.an;
import com.baidu.live.data.ar;
import com.baidu.live.data.bc;
import com.baidu.live.data.bm;
import com.baidu.live.data.bs;
import com.baidu.live.data.k;
import com.baidu.live.data.o;
import com.baidu.live.data.q;
import com.baidu.live.gift.n;
import com.baidu.live.gift.z;
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
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.tieba.ala.liveroom.guide.a;
import com.baidu.tieba.ala.liveroom.j.b;
import com.baidu.tieba.ala.liveroom.j.g;
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.recommend.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends b implements com.baidu.live.j.c {
    private PendantParentView bcj;
    private com.baidu.tieba.ala.liveroom.j.b gaF;
    private com.baidu.tieba.ala.liveroom.audiencelist.c gaj;
    private com.baidu.tieba.ala.liveroom.n.a gak;
    private com.baidu.tieba.ala.liveroom.g.b gal;
    private com.baidu.tieba.ala.liveroom.t.b gam;
    private com.baidu.tieba.ala.liveroom.audiencelist.b gan;
    private com.baidu.tieba.ala.liveroom.l.a gao;
    private com.baidu.tieba.ala.liveroom.activeview.b gaq;
    private com.baidu.live.d.a gar;
    private i gas;
    private h gat;
    private com.baidu.tieba.ala.liveroom.c.a gau;
    private FrameLayout gax;
    private LinearLayout gcE;
    private e gcF;
    private boolean gcG;
    private long lastClickTime = 0;
    private boolean gcH = false;
    private HttpRule gaG = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.gas != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.gas.wr()) {
                httpMessage.addParam("ala_challenge_id", d.this.gas.wu());
            }
            return httpMessage;
        }
    };
    private HttpRule gaH = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.gas != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.gas.wr()) {
                httpMessage.addParam("challenge_id", d.this.gas.wu());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c gaI = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.d.15
        @Override // com.baidu.live.liveroom.g.c
        public void FM() {
            if (d.this.gbj != null) {
                d.this.gbj.mg(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bW(boolean z) {
            if (z) {
                if (d.this.gaZ != null) {
                    d.this.gaZ.sm(8);
                }
                if (d.this.gbj != null) {
                    d.this.gbj.mg(true);
                }
            } else {
                if (d.this.gaZ != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                        d.this.gaZ.sm(0);
                    } else {
                        d.this.gaZ.sm(8);
                    }
                }
                if (d.this.gbj != null) {
                    d.this.gbj.mg(false);
                }
            }
            if (d.this.gbB != null) {
                d.this.gbB.bh(z);
            }
        }
    };
    private HttpMessageListener gaJ = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.d.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.FW() != null) {
                        com.baidu.live.v.c.Hx().bex = getQuickGiftHttpResponseMessage.FW();
                        d.this.bDR();
                    }
                }
            }
        }
    };
    private CustomMessageListener gaK = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.d.d.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.bEc();
        }
    };
    CustomMessageListener gaP = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.d.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.gaF.c(d.this.bFe());
                } else if (d.this.bEy() || !g.rN(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.19.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, 3000L);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.bFe().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.bFe().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    d.this.gaF.b(d.this.gax, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener gcI = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.d.d.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.bEy() || !g.rN(2913128)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.rL(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, 3000L);
                } else {
                    d.this.Dv(str);
                }
            }
        }
    };
    private CustomMessageListener gaL = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.gbr.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gaM = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.this.gbF != null) {
                    d.this.gbF.DO(str);
                }
            }
        }
    };
    CustomMessageListener gaN = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.gbV != null && d.this.gbV.aSF != null && !d.this.gbV.aSI && !d.this.gbV.aSJ && d.this.gbA != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.bFe().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = d.this.bFe().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                d.this.gbA.b(d.this.gax, layoutParams);
                if (com.baidu.live.guardclub.e.CI() != null) {
                    com.baidu.live.guardclub.e.CI().CO();
                }
            }
        }
    };
    private CustomMessageListener gaO = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.gbD != null) {
                    d.this.gbD.dismiss();
                }
                if (d.this.gbF != null) {
                    d.this.gbF.dismiss();
                }
                com.baidu.live.im.b.d.Ea().setSwitchStatus(true);
                com.baidu.live.im.b.d.Ea().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bEE();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gaQ = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.d.11
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void m(View view, int i) {
            bc bcVar;
            bm bmVar;
            bs bsVar;
            String str;
            bc bcVar2;
            bm bmVar2;
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
                        alaStaticItem.addParams("gifts_value", com.baidu.live.v.c.Hx().bex.zk().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.v.c.Hx().bex.zk().yo());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.v.c.Hx().bex.zk().yp());
                        if (d.this.bFe().gla.FO() != null && d.this.bFe().gla.FO().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.bFe().gla.FO().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.bFe().gla.FO().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.Et());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.BR()) {
                        if (com.baidu.live.c.vf().getBoolean("quick_gift_guide_show", true) && !d.this.bEy()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, z.class, d.this.bFe().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                z zVar = (z) runTask.getData();
                                zVar.setPageContext(d.this.bFe().pageContext);
                                zVar.d(d.this.bFe().gla.FO());
                                zVar.setGiftItem(com.baidu.live.v.c.Hx().bex.zk());
                                zVar.setOtherParams(d.this.Et());
                                zVar.initView();
                                zVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.d.d.11.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        d.this.li(false);
                                    }
                                });
                                zVar.show();
                                d.this.li(true);
                                return;
                            }
                            return;
                        }
                        n.a(d.this.bFe().pageContext, d.this.bFe().gla.FO(), com.baidu.live.v.c.Hx().bex.zk(), d.this.Et());
                    }
                } else if (i == 1) {
                    if (d.this.gbo != null) {
                        d.this.bEE();
                    }
                } else if (i == 3 && d.this.BR()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    d.this.gbb.c(d.this.bFe().gla.FO(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.bFe() != null && d.this.bFe().gla != null && d.this.bFe().gla.FO() != null && d.this.bFe().gla.FO().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.bFe().gla.FO().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.bFe().gla.FO().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.bFe().gla.FO().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.Et());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.bFe() != null && d.this.bFe().gla != null && d.this.bFe().gla.FO() != null && d.this.bFe().gla.FO().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.bFe().gla.FO().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.bFe().gla.FO().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.bFe().gla.FO().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.Et());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.aYP != null) {
                        d.this.aYP.bR(false);
                    }
                } else if (i == 12) {
                    if (d.this.gbj != null && d.this.bFe().gla.FO() != null && d.this.bFe().gla.FO().mLiveInfo != null) {
                        String valueOf = String.valueOf(d.this.bFe().gla.FO().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.bFe().gla.FO().mLiveInfo.room_id);
                        String str3 = null;
                        o oVar = d.this.bFe().gla.FO().mLiveSdkInfo;
                        if (oVar != null && oVar.mCastIds != null) {
                            str3 = String.valueOf(d.this.bFe().gla.FO().mLiveSdkInfo.mCastIds.ayO);
                        }
                        d.this.gbj.ai(valueOf, valueOf2, str3);
                        if (com.baidu.live.liveroom.a.Fj().Fk()) {
                            d.this.bEc();
                        }
                    }
                } else if (i == 14) {
                    q FO = d.this.bFe().gla.FO();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.bFe().pageContext.getPageActivity(), FO.ayC.userName, Long.toString(FO.ayC.userId), Long.toString(FO.ayC.charmCount), String.valueOf(FO.mLiveInfo.group_id), String.valueOf(FO.mLiveInfo.live_id), false, String.valueOf(FO.ayC.userId), Long.toString(FO.ayV.userId), FO.ayV.userName, FO.ayV.portrait, d.this.gan.getCount(), d.this.Et())));
                    LogManager.getCommonLogger().doClickGusetNumLog(FO.mLiveInfo.feed_id, d.this.gan.getCount() + "", d.this.Et());
                } else if (i == 11) {
                    d.this.bEH();
                    d.this.bEI();
                } else if (i == 16) {
                    if (d.this.bFe() != null && (bcVar2 = com.baidu.live.v.a.Hs().beo) != null && (bmVar2 = bcVar2.aEo) != null) {
                        String str4 = bmVar2.aFk.aFr;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (d.this.bFe().gla != null && d.this.bFe().gla.FO() != null && d.this.bFe().gla.FO().mLiveInfo != null) {
                                j = d.this.bFe().gla.FO().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", d.this.bFe().gla.FO().mLiveInfo.room_id + "", d.this.bFe().gla.FO().mLiveInfo.feed_id, d.this.Et());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.bFe().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (d.this.bFe() != null) {
                        q qVar = null;
                        if (d.this.bFe().gla != null) {
                            qVar = d.this.bFe().gla.FO();
                        }
                        if (qVar != null && qVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.v.b.bMA().aZy != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.v.b.bMA().aZy.aye;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + qVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + qVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(d.this.bFe().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17 && d.this.BR() && d.this.bFe() != null && (bcVar = com.baidu.live.v.a.Hs().beo) != null && (bmVar = bcVar.aEo) != null && (bsVar = bmVar.aFl) != null && !TextUtils.isEmpty(bsVar.webUrl)) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                    if (d.this.gbD != null && d.this.bFe().gla != null && d.this.bFe().gla.FO() != null) {
                        q FO2 = d.this.bFe().gla.FO();
                        d.this.gbD.a(bsVar.webUrl, FO2.mLiveInfo.live_id, FO2.ayV.userId, FO2.ayC.userId);
                    }
                }
            }
        }
    };
    private boolean gcJ = false;
    private boolean gcK = false;

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.gbd = new com.baidu.tieba.ala.liveroom.guide.c(bFe().pageContext, this, false);
        this.gaG.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.gaG);
        this.gaH.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.gaH);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean bDD() {
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void m(q qVar) {
        super.m(qVar);
        g.bHO();
        this.gcH = true;
        this.gcK = false;
        this.gcJ = false;
        bFe().glb.setIsForceHandledTouch(false);
        bFe().glb.setSwipeClearEnable(true);
        bFe().glb.setOnLiveViewScrollListener(this.gaI);
        bFe().glb.setOnClickListener(null);
        bFe().glb.setClickable(false);
        if (this.gbg != null) {
            this.gbg.b(this.gaQ);
        }
        if (this.gbO != null) {
            this.gbO.setVisibility(0);
        }
        bDI();
        if (this.gby != null) {
            this.gby.a(qVar, this.bcj);
            this.gby.S(this.gbP);
            this.gby.a(this);
        }
        bFs();
        bDU();
        bEu();
        bDV();
        bDZ();
        bDW();
        ld(false);
        bEL();
        bEK();
        bDL();
        bDS();
        bEM();
        bEb();
        bEd();
        bFo();
        bFp();
        lj(false);
        bEV();
        bDK();
        bDR();
        bDM();
        bDN();
        bDO();
        bDP();
        bER();
        bDE();
        ln(true);
        bEU();
        c(this.flX);
        MessageManager.getInstance().registerListener(this.gaJ);
        MessageManager.getInstance().registerListener(this.gaK);
        MessageManager.getInstance().registerListener(this.gaL);
        MessageManager.getInstance().registerListener(this.gaN);
        MessageManager.getInstance().registerListener(this.gaO);
        MessageManager.getInstance().registerListener(this.gcI);
        MessageManager.getInstance().registerListener(this.gaP);
        MessageManager.getInstance().registerListener(this.gaM);
        bEf();
        bDY();
    }

    private void bDE() {
        if (this.gbK != null) {
            this.gbK.a(new a.InterfaceC0588a() { // from class: com.baidu.tieba.ala.liveroom.d.d.16
                @Override // com.baidu.tieba.ala.liveroom.recommend.a.InterfaceC0588a
                public void lg(boolean z) {
                    if (d.this.gat != null) {
                        d.this.gat.setNeedCloseRecommendFloat(z);
                    }
                    if (d.this.bFe().glb.gzz) {
                        if (d.this.gbj != null) {
                            d.this.gbj.lX(z);
                            d.this.gbj.mg(!z);
                        }
                        if (d.this.gbg != null) {
                            d.this.gbg.lX(z);
                            d.this.gbg.setPraiseEnable(!z);
                            d.this.gbg.lW(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(q qVar) {
        super.k(qVar);
        if (this.gak != null) {
            this.gak.v(qVar);
        }
        if (this.gal != null) {
            this.gal.r(qVar);
        }
        if (this.gao != null) {
            this.gao.u(qVar);
        }
        if (this.gat != null) {
            this.gat.a(qVar);
        }
        ln(false);
        if (this.gaq != null) {
            this.gaq.j(qVar);
            this.gaq.lb(this.gbY);
            this.gaq.updateView();
            if (qVar != null && this.gbL != null && !this.gbL.hasInit && !TextUtils.isEmpty(this.gbL.aEI)) {
                this.gbL.hasInit = true;
                this.gaq.Dr(this.gbL.aEI);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(k kVar) {
        if (kVar != null) {
            if (this.gaj != null && kVar.getList() != null) {
                this.gaj.e(kVar);
            }
            if (this.gan != null) {
                this.gan.dD(kVar.getCount());
            }
        }
    }

    private void bDG() {
        if (this.gbi != null) {
            this.gbi.av(bFe().gkZ.getLiveContainerView());
        }
    }

    private void bFo() {
        if (this.gau == null) {
            this.gau = new com.baidu.tieba.ala.liveroom.c.a(bFe().pageContext);
        }
        if (bFe().gla != null && bFe().gla.FO() != null && bFe().gla.FO().mLiveInfo != null) {
            this.gau.Ds(String.valueOf(bFe().gla.FO().mLiveInfo.user_id));
        }
    }

    private void bFp() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (bFe() != null && bFe().gla != null && bFe().gla.FO() != null && bFe().gla.FO().mLiveInfo != null) {
                j = bFe().gla.FO().mLiveInfo.room_id;
            }
            if (this.gbw == null) {
                this.gbw = new com.baidu.tieba.ala.liveroom.guide.a(bFe().pageContext, j);
            }
            this.gbw.lh(this.gbR);
            this.gbw.a(new a.InterfaceC0580a() { // from class: com.baidu.tieba.ala.liveroom.d.d.5
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0580a
                public void bFv() {
                    if (d.this.aYP != null) {
                        d.this.aYP.bR(true);
                    }
                }
            });
            this.gbw.ar(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bR(int i) {
        super.bR(i);
        bDG();
        if (this.gat != null) {
            this.gat.bR(i);
        }
    }

    private void bDI() {
        if (this.bcj == null) {
            this.bcj = new PendantParentView(bFe().pageContext.getPageActivity(), this.gcG ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            bFe().glb.addView(this.bcj, new ViewGroup.LayoutParams(-1, -1));
            this.bcj.setDefaultItemMargin(bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.bcj.setPadding(bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20), 0, bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6), 0);
            bFq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFq() {
        int dimensionPixelSize;
        if (this.bcj != null) {
            this.bcj.setModel(this.gcG ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            int dimensionPixelSize2 = bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds220);
            int dimensionPixelSize3 = bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            if (this.gcG) {
                dimensionPixelSize = bFt();
            } else {
                dimensionPixelSize = bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200);
            }
            this.bcj.setPosition(dimensionPixelSize2, 0, dimensionPixelSize, dimensionPixelSize3);
            return;
        }
        bDI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFr() {
        if (this.gbo != null && this.gax != null && this.gbo.DC() != null && this.gbo.DC().getView() != null && !this.gcK) {
            if (this.gcG) {
                int screenHeight = (ScreenHelper.getScreenHeight(bFe().pageContext.getPageActivity()) - (this.gat != null ? this.gat.aZ(false) : 0)) - bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                ViewGroup.LayoutParams layoutParams = this.gbo.DC().getView().getLayoutParams();
                if (layoutParams != null && layoutParams.height > 0 && layoutParams.height >= screenHeight) {
                    layoutParams.height = screenHeight;
                    this.gbo.DC().getView().setLayoutParams(layoutParams);
                    if (this.gax != null) {
                        ViewGroup.LayoutParams layoutParams2 = this.gax.getLayoutParams();
                        layoutParams2.height = com.baidu.live.aa.a.cv(false) + layoutParams.height;
                        this.gax.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
            }
            int ct = com.baidu.live.aa.a.ct(this.gbS);
            if (this.gbP.indexOfChild(this.gax) != -1 && this.gax.getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gax.getLayoutParams();
                layoutParams3.height = com.baidu.live.aa.a.h(false, this.gbS);
                this.gax.setLayoutParams(layoutParams3);
            }
            if (this.gax.indexOfChild(this.gbo.DC().getView()) != -1 && this.gbo.DC().getView().getLayoutParams() != null) {
                FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.gbo.DC().getView().getLayoutParams();
                layoutParams4.height = ct;
                this.gbo.DC().getView().setLayoutParams(layoutParams4);
            }
            this.gbo.DC().DB();
        }
    }

    private void bFs() {
        if (this.gcE == null) {
            this.gcE = new LinearLayout(bFe().pageContext.getPageActivity());
            this.gcE.setOrientation(1);
        }
        if (this.gcE.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds160);
            layoutParams.leftMargin = bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bFe().glb.addView(this.gcE, layoutParams);
        }
    }

    private void bDL() {
        if (this.gbf != null && bFe() != null && bFe().gla != null) {
            this.gbf.b(this.gbO, bFe().gla.FO());
        }
    }

    private void bDK() {
        if (this.gaq == null) {
            this.gaq = new com.baidu.tieba.ala.liveroom.activeview.b(bFe().pageContext);
        }
        if (bFe() != null && bFe().gla != null) {
            this.gaq.Dp(bFe().gla.bLO());
        }
        this.gaq.la(this.gcG);
        this.gaq.setOtherParams(Et());
        this.gaq.b(bFe().gla.FO(), false);
        this.gaq.setHost(false);
        this.gaq.lb(this.gbY);
        this.gaq.a(1, this.bcj);
        this.gaq.a(2, this.bcj);
        this.gaq.setVisible(this.gbS ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDR() {
        if (this.gaZ == null) {
            bDW();
        }
        this.gaZ.setOtherParams(Et());
        this.gaZ.a(com.baidu.live.v.c.Hx().bex, bFe().gla.FO());
    }

    private void bDM() {
        if (this.gao == null) {
            this.gao = new com.baidu.tieba.ala.liveroom.l.a(bFe().pageContext, this);
        }
        this.gao.setOtherParams(Et());
        this.gao.a((ViewGroup) this.bcj, bDQ());
        this.gao.u(bFe().gla.FO());
    }

    private void bDN() {
        if (this.gbA == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, j.class, bFe().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gbA = (j) runTask.getData();
            } else {
                return;
            }
        }
        this.gbA.setOtherParams(Et());
        if (this.gax != null && this.gax.indexOfChild(this.gbA.getView()) >= 0) {
            this.gax.removeView(this.gbA.getView());
        }
    }

    private void bDO() {
        if (this.gaZ != null) {
            this.gaZ.a(new a.InterfaceC0586a() { // from class: com.baidu.tieba.ala.liveroom.d.d.6
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0586a
                public void bC(int i, int i2) {
                    q FO = d.this.bFe().gla.FO();
                    if (FO != null && FO.mLiveInfo != null) {
                        if (d.this.gbE == null) {
                            d.this.gbE = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.bFe().pageContext.getPageActivity());
                        }
                        d.this.gbE.d(d.this.gbP, i, i2);
                        d.this.gbE.a(String.valueOf(FO.mLiveInfo.live_id), new a.InterfaceC0592a() { // from class: com.baidu.tieba.ala.liveroom.d.d.6.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0592a
                            public void a(float f, String str) {
                                if (d.this.gaZ != null) {
                                    d.this.gaZ.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0586a
                public void bD(int i, int i2) {
                    if (d.this.gbE != null) {
                        d.this.gbE.bI(i, i2);
                    }
                }
            });
        }
    }

    private void bDP() {
        if (this.gcd == null) {
            this.gcd = new com.baidu.tieba.ala.liveroom.j.e(bFe().pageContext);
        }
        this.gcd.setRoomId(bFe().gla.FO().mLiveInfo.room_id);
        this.gcd.DF("");
        this.gcd.b(bFe().gla.FO(), this.bcj);
        if (this.gaF == null) {
            this.gaF = new com.baidu.tieba.ala.liveroom.j.b(bFe().pageContext, Et(), this.gcd, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.7
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bEo() {
                    d.this.li(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bEp() {
                    d.this.li(false);
                }
            });
        }
        this.gaF.setRoomId(bFe().gla.FO().mLiveInfo.room_id);
        if (this.gax != null && this.gax.indexOfChild(this.gaF.getView()) >= 0) {
            this.gax.removeView(this.gaF.getView());
        }
        if (this.gaF != null) {
            this.gaF.b(bFe());
        }
    }

    private LinearLayout.LayoutParams bDQ() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    private void bDS() {
        CustomResponsedMessage runTask;
        if (this.gbo == null && (runTask = MessageManager.getInstance().runTask(2913039, com.baidu.live.im.k.class, bFe().pageContext)) != null && runTask.getData() != null) {
            this.gbo = (com.baidu.live.im.k) runTask.getData();
            this.gbo.setFromMaster(false);
            this.gbo.DC().getView().setId(a.g.ala_liveroom_msg_list);
            this.gbo.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.8
                @Override // com.baidu.live.im.k.a
                public boolean DF() {
                    return d.this.BR();
                }

                @Override // com.baidu.live.im.k.a
                public void DG() {
                    d.this.gbW = true;
                }

                @Override // com.baidu.live.im.k.a
                public void fv(String str) {
                    if (!d.this.gbS) {
                        d.this.lf(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.bFe().pageContext.getPageActivity(), d.this.bFe().gkZ.getLiveContainerView());
                    }
                    d.this.Du(str);
                }

                @Override // com.baidu.live.im.k.a
                public void DH() {
                    if (d.this.gbS) {
                        d.this.lf(true);
                        d.this.bFe().gkZ.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.bFe().pageContext.getPageActivity(), d.this.bFe().gkZ.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.gbo != null) {
                        d.this.gbo.DD().setQuickInputPanelVisible(false);
                        d.this.gbo.DD().EU();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void DI() {
                    if (d.this.gbS) {
                        d.this.bEn();
                        if (d.this.gbp != null) {
                            d.this.gbp.vC();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean DJ() {
                    return d.this.bEz();
                }

                @Override // com.baidu.live.im.k.a
                public int DK() {
                    return d.this.bEA();
                }
            });
            this.gax = new FrameLayout(bFe().pageContext.getPageActivity());
            this.gax.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.gbo != null && this.gax != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bFe().pageContext.getPageActivity()) * 0.7f);
            int ct = com.baidu.live.aa.a.ct(false);
            if (this.gbP.indexOfChild(this.gax) < 0) {
                if (this.gax.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gax.getParent()).removeView(this.gax);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.live.aa.a.h(false, false));
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.live.aa.a.cu(false);
                this.gbP.addView(this.gax, layoutParams);
            }
            if (this.gax.indexOfChild(this.gbo.DC().getView()) < 0) {
                if (this.gbo.DC().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gbo.DC().getView()).removeView(this.gbo.DC().getView());
                }
                this.gax.addView(this.gbo.DC().getView(), new FrameLayout.LayoutParams(equipmentWidth, ct));
            }
            if (bFe().glb.indexOfChild(this.gbo.DD().getView()) < 0) {
                if (this.gbo.DD().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gbo.DD().getView().getParent()).removeView(this.gbo.DD().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bEF();
                bFe().glb.addView(this.gbo.DD().getView(), layoutParams2);
            }
            q FO = bFe().gla.FO();
            if (FO != null && FO.mLiveInfo != null) {
                this.gbo.setLogData(FO.mLiveInfo.feed_id, Et());
            }
            this.gbo.a(String.valueOf(bFe().gla.FO().mLiveInfo.group_id), String.valueOf(bFe().gla.FO().mLiveInfo.last_msg_id), String.valueOf(bFe().gla.FO().ayC.userId), String.valueOf(bFe().gla.FO().mLiveInfo.live_id), bFe().gla.FO().ayC.appId, (FO == null || FO.azi == null || !FO.azi.wQ()) ? false : true);
            lf(false);
        }
    }

    private void bDU() {
        if (this.gak == null) {
            this.gak = new com.baidu.tieba.ala.liveroom.n.a(bFe().pageContext, false, this);
        }
        this.gak.c(this.gbO, bFe().gla.FO());
        this.gak.a(this.gaQ);
        this.gak.setOtherParams(Et());
    }

    private void bDV() {
        if (this.gaj == null) {
            this.gaj = new com.baidu.tieba.ala.liveroom.audiencelist.c(bFe().pageContext, this, false);
        }
        this.gaj.a(String.valueOf(bFe().gla.FO().mLiveInfo.group_id), String.valueOf(bFe().gla.FO().mLiveInfo.live_id), String.valueOf(bFe().gla.FO().ayC.userId), bFe().gla.FO());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.gba != null && this.gba.getView() != null && this.gba.getView().getParent() != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.gaj.c(this.gbO, i, a.g.ala_liveroom_audience_count_layout);
            this.gaj.e(bFe().gla.bzs());
            this.gaj.setOtherParams(Et());
        }
    }

    private void bDW() {
        com.baidu.live.core.a.a Fh;
        if (this.gaZ == null) {
            this.gaZ = new com.baidu.tieba.ala.liveroom.operation.a(bFe().pageContext);
        }
        this.gaZ.a(bFe(), this.gbP, bFe().gla.FO().mLiveInfo, true, this.gaQ);
        this.gaZ.setOtherParams(Et());
        if (this.gby != null && (Fh = this.gby.Fh()) != null) {
            View rootLayout = Fh.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.gaZ.bM(rootLayout);
        }
    }

    public void lm(boolean z) {
        if (this.gaZ != null) {
            this.gaZ.lm(z);
        }
    }

    private void bDZ() {
        if (this.gan == null) {
            this.gan = new com.baidu.tieba.ala.liveroom.audiencelist.b(bFe().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (bFe().gla.bzs() != null) {
            j = bFe().gla.bzs().getCount();
        }
        this.gan.a(this.gaQ);
        this.gan.a(this.gbO, a.g.ala_liveroom_audience, j);
        this.gan.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.gan.lq(false);
        } else {
            this.gan.lq(true);
        }
    }

    protected void Dv(String str) {
        if (this.gcc == null) {
            this.gcc = new com.baidu.tieba.ala.liveroom.s.b(bFe().pageContext);
        }
        this.gcc.b(this.gbP, str);
        li(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.9
            @Override // java.lang.Runnable
            public void run() {
                d.this.gcc.bMg();
                d.this.li(false);
            }
        }, 5000L);
    }

    private void ln(boolean z) {
        CustomResponsedMessage runTask;
        if (bFe().gla.FO().mLiveInfo.live_type == 1 && this.gcH) {
            if (this.gcF == null && (runTask = MessageManager.getInstance().runTask(2913074, e.class, bFe().pageContext)) != null && runTask.getData() != null) {
                this.gcF = (e) runTask.getData();
            }
            if (this.gcF != null) {
                if (this.gas == null) {
                    this.gas = this.gcF.a(bFe().pageContext);
                }
                if (bFe().gla.FO().mLiveInfo.challengeId > 0 && !this.gas.ws()) {
                    this.gas.e(bFe().gla.FO().mLiveInfo.live_id, bFe().gla.FO().ayC.userId);
                    lo(z);
                    if (z) {
                        this.gas.a(bFe().gla.bKU());
                    }
                    this.gas.c(bFe().gla.FO());
                }
            }
        }
    }

    private void lo(boolean z) {
        if (this.gat == null) {
            this.gat = this.gcF.b(bFe().pageContext);
            this.gat.a(new com.baidu.live.challenge.g() { // from class: com.baidu.tieba.ala.liveroom.d.d.10
                @Override // com.baidu.live.challenge.g
                public void wh() {
                    d.this.bFe().glb.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.g
                public void a(an anVar, ar arVar, ar arVar2) {
                    d.this.gcG = true;
                    if (d.this.gbg != null) {
                        d.this.gbg.setPraiseEnable(false);
                        d.this.bFe().glb.gzz = false;
                    }
                    if (d.this.gbh != null) {
                        d.this.gbh.bMy();
                    }
                    if (d.this.gao != null) {
                        d.this.gao.setCanVisible(false);
                        d.this.gao.bHS();
                    }
                    if (d.this.gaq != null) {
                        d.this.gaq.la(true);
                    }
                    if (d.this.gcd != null) {
                        d.this.gcd.setVisible(8);
                    }
                    if (d.this.gar != null) {
                        d.this.gar.setCanVisible(false);
                        d.this.gar.setVisible(8);
                    }
                    d.this.bFq();
                    d.this.bFr();
                    if (d.this.bFe().aYS != null) {
                        d.this.bFe().aYS.getLivePlayer().setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                    }
                    if (d.this.gbe != null) {
                        d.this.gbe.setTimeTextMode(true);
                    }
                    if (d.this.aYP != null && arVar != null && arVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(arVar.aDu);
                        arrayList.add(arVar2.aDu);
                        com.baidu.live.liveroom.a.c cVar = d.this.aYP;
                        if (d.this.gbZ) {
                            arrayList = null;
                        }
                        cVar.j(arrayList);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void wi() {
                }

                @Override // com.baidu.live.challenge.g
                public void wj() {
                }

                @Override // com.baidu.live.challenge.g
                public void aX(boolean z2) {
                    d.this.bFe().glb.setSwipeClearEnable(true);
                    d.this.gcG = false;
                    if (d.this.gbg != null) {
                        d.this.gbg.setPraiseEnable(true);
                        d.this.bFe().glb.gzz = true;
                    }
                    if (d.this.gbh != null) {
                        d.this.gbh.bMz();
                    }
                    if (d.this.gao != null) {
                        d.this.gao.setCanVisible(true);
                        d.this.gao.u(d.this.bFe().gla.FO());
                    }
                    if (d.this.gbj != null) {
                        d.this.gbj.mg(true);
                    }
                    if (d.this.gaq != null) {
                        d.this.gaq.la(false);
                    }
                    if (d.this.gcd != null) {
                        d.this.gcd.setVisible(0);
                    }
                    if (d.this.gar != null) {
                        d.this.gar.setCanVisible(true);
                        d.this.gar.setVisible(0);
                    }
                    d.this.bFq();
                    d.this.bFr();
                    if (d.this.aYP != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.bFe().gla.bLJ());
                        com.baidu.live.liveroom.a.c cVar = d.this.aYP;
                        if (d.this.gbZ) {
                            arrayList = null;
                        }
                        cVar.j(arrayList);
                    }
                    if (d.this.bFe().aYS != null) {
                        d.this.bFe().aYS.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
                    }
                    if (d.this.gbe != null) {
                        d.this.gbe.setTimeTextMode(false);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void aY(boolean z2) {
                    if (z2 && d.this.gbK != null) {
                        d.this.gbK.onClose();
                    }
                }
            });
        }
        this.gat.a(this.gas);
        this.gat.k(bFe().gkZ.getLiveContainerView());
        this.gat.b(z, false, false);
        this.gas.a((i.c) this.gat);
    }

    public void bEa() {
        this.gbb.c(bFe().gla.FO(), false);
    }

    public void bEb() {
        if (bFe().gla.FO() != null && bFe().gla.FO().ayC != null && bFe().gla.FO().mLiveInfo != null) {
            if (this.gam == null) {
                this.gam = new com.baidu.tieba.ala.liveroom.t.b(bFe().pageContext);
            }
            long j = bFe().gla.FO().ayC.userId;
            int i = bFe().gla.FO().mLiveInfo.live_type;
            String str = bFe().gla.FO().ayC.portrait;
            String str2 = bFe().gla.FO().mLiveInfo.feed_id;
            long j2 = bFe().gla.FO().mLiveInfo.live_id;
            this.gam.a(i, j, bFe().gla.FO().ayC.userName, false, str, Et(), str2, j2);
            this.gam.ar(this.gbO);
        }
    }

    private int bFt() {
        return (this.gat != null ? this.gat.aZ(false) : 0) + bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEc() {
        if (bFe() == null || bFe().gla == null || bFe().gla.FO() == null || bFe().gla.FO().ayV == null) {
            if (bFe().gla == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bFe().gla.FO() == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bFe().gla.FO().ayV == null) {
                Log.i("RenameLog", "getLiveContext().liveModel.getLiveShowData().mLoginUserInfo == null");
                return;
            } else {
                return;
            }
        }
        String str = bFe().gla.FO().ayV.userName;
        Log.i("RenameLog", "loginUserName:" + str);
        if (str != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bFe().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !bEy()) {
            com.baidu.live.c.vf().putInt("guide_rename_show_count", com.baidu.live.c.vf().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.Fj().bQ(true);
            if (this.gbH == null) {
                this.gbH = new com.baidu.tieba.ala.liveroom.u.a(bFe().pageContext);
            }
            this.gbH.setOtherParams(Et());
            this.gbH.e(this.gbP, bFe().gla.FO());
            li(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.13
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gbH.bMp();
                    d.this.li(false);
                }
            }, 5000L);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_SHOW);
                alaStaticItem.addParams("other_params", Et());
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    private void bEd() {
        boolean z = false;
        if (this.gbj == null) {
            this.gbj = new com.baidu.tieba.ala.liveroom.w.a(bFe().pageContext, this);
        }
        this.gbj.d(bFe().glb, false);
        if (bFd() && bFe().gla.FO().mLiveInfo.screen_direction != 2) {
            z = true;
        }
        this.gbj.mf(z);
    }

    private void bEf() {
        if (this.gbW || this.gbX) {
            if ((TbadkCoreApplication.isLogin() && this.gbo.DD().hasText()) || this.gbX) {
                this.gbW = false;
                this.gbX = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.14
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bEE();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void bDX() {
        bDY();
    }

    private void bDY() {
        if (this.gaZ != null) {
            int i = bFe().gla.FO().ayV.isUegBlock;
            int i2 = bFe().gla.FO().ayV.isBlock;
            String str = bFe().gla.FO().ayV.userName;
            if (i > 0 || i2 > 0) {
                this.gaZ.b(true, i, i2, str);
                this.gbo.a(true, i, i2, str);
                this.gbu.b(true, i, i2, str);
                return;
            }
            this.gaZ.b(false, i, i2, str);
            this.gbo.a(false, i, i2, str);
            this.gbu.b(false, i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void r(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        super.r(aVar);
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
                if (this.gao != null) {
                    this.gao.G(jSONObject);
                }
            } else if ("enter_live".equals(optString)) {
                if (this.gan != null && this.gan.getCount() > 20) {
                    this.gan.dD(this.gan.getCount() + 1);
                } else if (this.gaj != null) {
                    com.baidu.live.data.a Eh = aVar.Eh();
                    com.baidu.live.data.j jVar = new com.baidu.live.data.j();
                    jVar.ayD = new AlaLocationData();
                    jVar.ayE = new AlaRelationData();
                    jVar.ayC = new AlaLiveUserInfoData();
                    jVar.ayC.userId = JavaTypesHelper.toLong(Eh.userId, 0L);
                    jVar.ayC.userName = Eh.userName;
                    jVar.ayC.portrait = Eh.portrait;
                    if (this.gan != null && this.gaj.c(jVar)) {
                        this.gan.dD(this.gan.getCount() + 1);
                    }
                }
            } else if ("update_liveinfo".equals(optString)) {
                if (bFe().gla.FO() != null && bFe().gla.FO().mLiveInfo != null) {
                    bFe().gla.a(bFe().gla.FO().mLiveInfo.live_id, bFe().fromType, bFe().enterTime);
                }
            } else if ("challenge_mvp".equals(optString) && bFe().gla.FO() != null && bFe().gla.FO().mLiveInfo != null && bFe().gla.FO().ayV != null && this.gat != null) {
                long optLong = jSONObject.optLong("mvp_user_id");
                long optLong2 = jSONObject.optLong("winner_live_id");
                if (optLong == bFe().gla.FO().ayV.userId && optLong2 == bFe().gla.FO().mLiveInfo.live_id) {
                    this.gat.c(jSONObject.optInt("challenge_status"), jSONObject.optLong("challenge_id"));
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void Dq(String str) {
        if (this.gaq != null) {
            this.gaq.Dq(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void bV(boolean z) {
        super.bV(z);
        if (bFe().glb != null) {
            bFe().glb.bNj();
            bFe().glb.setLiveViewOnDispatchTouchEventListener(null);
            bFe().glb.setLiveViewOnTouchEventListener(null);
            bFe().glb.setOnLiveViewScrollListener(null);
        }
        if (bFe().aYS != null) {
            bFe().aYS.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.gat != null) {
            this.gat.wd();
        }
        bEg();
        if (this.gam != null) {
            this.gam.wd();
        }
        if (this.gbj != null) {
            this.gbj.release();
        }
        if (this.gao != null) {
            this.gao.wd();
        }
        if (this.gaZ != null) {
            this.gaZ.bLR();
        }
        if (this.gal != null) {
            this.gal.bHi();
            this.gal.setVisible(8);
        }
        if (this.gar != null) {
            this.gar.wd();
        }
        if (this.gaq != null) {
            this.gaq.release();
        }
        if (this.bcj != null) {
            this.bcj.removeAllViews();
            this.bcj = null;
        }
        if (this.gcE != null) {
            this.gcE.removeAllViews();
            this.gcE = null;
        }
        if (this.gbj != null) {
            this.gbj.onDestroy();
        }
        if (this.gas != null) {
            this.gas.wd();
        }
        if (this.gaF != null) {
            this.gaF.cancel();
        }
        if (this.gcd != null) {
            this.gcd.bGe();
        }
        if (this.gaF != null) {
            this.gaF.wd();
        }
        if (this.gbN != null) {
            this.gbN.wd();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void bU(boolean z) {
        super.bU(z);
        bEg();
        if (this.gak != null) {
            this.gak.onDestroy();
        }
        if (this.gam != null) {
            this.gam.onDestroy();
        }
        if (this.gao != null) {
            this.gao.onDestroy();
        }
        if (this.gar != null) {
            this.gar.onDestroy();
        }
        if (this.gas != null) {
            this.gas.onDestroy();
        }
        if (this.gat != null) {
            this.gat.onDestroy();
        }
        if (this.gau != null) {
            this.gau.onDestroy();
        }
        if (this.gbw != null) {
            this.gbw.onDestroy();
        }
        if (this.gal != null) {
            this.gal.onDestroy();
        }
        if (this.gaj != null) {
            this.gaj.onDestroy();
        }
        if (this.gbo != null) {
            this.gbo.onDestroy();
        }
        if (this.gaZ != null) {
            this.gaZ.onDestory();
        }
        if (this.gaq != null) {
            this.gaq.release();
        }
        if (this.gcd != null) {
            this.gcd.bU(!z);
        }
        if (this.gaF != null) {
            this.gaF.onDestroy();
            this.gaF = null;
        }
        if (this.gbN != null) {
            this.gbN.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.gaG);
        MessageManager.getInstance().removeMessageRule(this.gaH);
        MessageManager.getInstance().unRegisterListener(this.gaJ);
        MessageManager.getInstance().unRegisterListener(this.gaK);
        MessageManager.getInstance().unRegisterListener(this.gaL);
        MessageManager.getInstance().unRegisterListener(this.gaN);
        MessageManager.getInstance().unRegisterListener(this.gaO);
        MessageManager.getInstance().unRegisterListener(this.gcI);
        MessageManager.getInstance().unRegisterListener(this.gaP);
        MessageManager.getInstance().unRegisterListener(this.gaM);
    }

    private void bEg() {
        if (this.gbo != null && this.gbo.DC().getView() != null && this.gbo.DC().getView().getParent() != null) {
            ((ViewGroup) this.gbo.DC().getView().getParent()).removeView(this.gbo.DC().getView());
        }
        if (this.gax != null && this.gax.getParent() != null) {
            ((ViewGroup) this.gax.getParent()).removeView(this.gax);
        }
        if (this.gbo != null && this.gbo.DD().getView() != null) {
            this.gbP.removeView(this.gbo.DD().getView());
        }
        if (this.gbo != null) {
            this.gbo.DC().setMsgData(new LinkedList());
            this.gbo.vD();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void a(af afVar) {
        if (this.gbo != null) {
            bEE();
            this.gbo.DD().setEditText(" @" + afVar.getNameShow() + " ");
        }
        if (this.gaZ != null) {
            this.gaZ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void g(com.baidu.live.data.a aVar) {
        if (this.gbo != null) {
            bEE();
            this.gbo.DD().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.gaZ != null) {
            this.gaZ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void b(af afVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected View bEh() {
        if (this.gbo != null) {
            return this.gbo.DD().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean bEi() {
        if (this.gbo == null || !this.gbo.DD().ET()) {
            return false;
        }
        lf(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected boolean bEj() {
        return this.gak == null || this.gak.bEj();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    /* renamed from: bFu */
    public PendantParentView bEk() {
        return this.bcj;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected ViewGroup bEl() {
        return this.gcE;
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
                    this.gbT = false;
                    K(intExtra, intExtra2, intExtra3);
                    return;
                }
                bEa();
                return;
            }
            bFc();
        } else if (i == 25051 && i2 == -1 && this.gcd != null) {
            this.gcd.bHJ();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.gbo != null && this.gbo.DC() != null) {
            this.gbo.DC().onKeyboardVisibilityChanged(z);
        }
        if (z || this.gbo == null || this.gbo.DD() == null || !this.gbo.DD().ET()) {
            if (z) {
                if (this.gaZ != null) {
                    this.gaZ.setVisibility(8);
                }
                if (this.gbq != null && this.gbq.zb() != null) {
                    this.gbq.zb().setVisibility(8);
                }
                bEn();
                if (this.gbo != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gbo.DD().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.gbo.DD().getView().setLayoutParams(layoutParams);
                    this.gbo.DD().getView().setVisibility(0);
                    this.gbo.DD().setQuickInputPanelVisible(false);
                }
                if (this.gbO != null) {
                    this.gbO.setVisibility(8);
                }
                if (this.gaq != null) {
                    this.gaq.setVisible(8);
                }
                if (this.gbp != null) {
                    this.gbp.vC();
                }
                if (this.gbM != null) {
                    this.gbM.setCanVisible(false);
                }
            } else {
                bEm();
            }
            bFr();
            if (this.gbB != null) {
                this.gbB.bg(z);
            }
        }
    }

    private void bEm() {
        if (this.gaZ != null) {
            this.gaZ.setVisibility(0);
        }
        if (this.gax != null) {
            if (this.gcK) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gax.getLayoutParams();
                layoutParams.bottomMargin = (G(false, false) - bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) + com.baidu.live.aa.a.Jn();
                this.gax.setLayoutParams(layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gax.getLayoutParams();
                layoutParams2.bottomMargin = bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
                this.gax.setLayoutParams(layoutParams2);
            }
        }
        if (this.gbo != null) {
            bEF();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gbo.DD().getView().getLayoutParams();
            layoutParams3.bottomMargin = 0;
            this.gbo.DD().getView().setLayoutParams(layoutParams3);
        }
        if (this.gaZ != null) {
            this.gaZ.setVisibility(0);
        }
        if (this.gbq != null && this.gbq.zb() != null) {
            this.gbq.zb().setVisibility(0);
        }
        if (this.gbO != null) {
            this.gbO.setVisibility(0);
        }
        if (this.gaq != null) {
            this.gaq.setVisible(0);
        }
        if (this.gbp != null) {
            this.gbp.vC();
        }
        if (this.gbM != null) {
            this.gbM.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEn() {
        boolean z;
        boolean z2 = false;
        if (this.gax != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gax.getLayoutParams();
            if (this.gbo == null || this.gbo.DD() == null) {
                z = false;
            } else {
                z = this.gbo.DD().ER();
                z2 = this.gbo.DD().ES();
            }
            int G = G(z, z2);
            if (layoutParams.bottomMargin != G) {
                layoutParams.bottomMargin = G;
                this.gax.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lf(boolean z) {
        this.gcJ = z;
        if (z) {
            this.gbo.DD().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gax.getLayoutParams();
            int quickInputPanelExpandHeight = this.gbo.DD().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.gax.setLayoutParams(layoutParams);
                if (this.gbo.DC() != null) {
                    this.gbo.DC().DB();
                    return;
                }
                return;
            }
            return;
        }
        bEm();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.gaj != null) {
                this.gaj.bN(i3);
            }
            if (this.gal != null) {
                this.gal.bN(i3);
            }
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public boolean cI(int i) {
        boolean cI = super.cI(i);
        if (cI && 2 == i) {
            if (this.gak.bEj()) {
                return false;
            }
            if (cI && this.gbj != null) {
                this.gbj.mg(false);
            }
        }
        return cI;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void rE(int i) {
        super.rE(i);
        if (i == 7 || i == 11) {
            if (this.gaZ != null) {
                this.gaZ.setVisibility(8);
            }
            if (this.gbo != null) {
                this.gbo.DC().getView().setVisibility(4);
            }
            if (this.gaq != null) {
                this.gaq.bA(2, 8);
                if (this.gcG) {
                    this.gaq.bA(1, 8);
                }
            }
            if (this.gbE != null) {
                this.gbE.mb(false);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public void cJ(int i) {
        super.cJ(i);
        if (i == 7 || i == 11) {
            if (this.gaZ != null) {
                this.gaZ.setVisibility(0);
            }
            if (this.gbo != null) {
                this.gbo.DC().getView().setVisibility(0);
            }
            if (this.gaq != null) {
                this.gaq.setVisible(0);
            }
            if (this.gbE != null) {
                this.gbE.mb(true);
            }
            this.gbO.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.gam != null) {
            this.gam.bMi();
        }
        if (this.gas != null) {
            this.gas.wl();
        }
        if (this.gaq != null) {
            this.gaq.onStop();
        }
        if (this.gar != null) {
            this.gar.aW(true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.gam != null) {
            this.gam.bMh();
        }
        if (this.gas != null && this.gcH) {
            this.gas.wm();
        }
        if (this.gaq != null) {
            this.gaq.onStart();
        }
        if (this.gar != null) {
            this.gar.aW(false);
        }
    }
}
