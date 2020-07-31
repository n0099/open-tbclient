package com.baidu.tieba.ala.liveroom.d;

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
import com.baidu.live.challenge.h;
import com.baidu.live.challenge.i;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.af;
import com.baidu.live.data.bc;
import com.baidu.live.data.bm;
import com.baidu.live.data.bs;
import com.baidu.live.data.o;
import com.baidu.live.data.q;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.n;
import com.baidu.live.gift.z;
import com.baidu.live.guardclub.e;
import com.baidu.live.guardclub.j;
import com.baidu.live.im.b.a;
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
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
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
import com.baidu.tieba.ala.liveroom.j.b;
import com.baidu.tieba.ala.liveroom.j.g;
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.recommend.a;
import com.baidu.tieba.ala.liveroom.turntable.d;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends b implements com.baidu.live.j.c {
    private PendantParentView bcj;
    private com.baidu.live.tieba.e.b gaA;
    private z gaE;
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
    private com.baidu.live.im.b.a gav;
    private com.baidu.tieba.ala.liveroom.share.b gaw;
    private FrameLayout gax;
    private FrameLayout gay;
    private ImageView gaz;
    private long lastClickTime = 0;
    private boolean gaB = false;
    private boolean gaC = false;
    private Handler gaD = new Handler();
    private HttpRule gaG = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.gas != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.gas.wr()) {
                httpMessage.addParam("ala_challenge_id", a.this.gas.wu());
            }
            return httpMessage;
        }
    };
    private HttpRule gaH = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.gas != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.gas.wr()) {
                httpMessage.addParam("challenge_id", a.this.gas.wu());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c gaI = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.19
        @Override // com.baidu.live.liveroom.g.c
        public void FM() {
            if (a.this.gbj != null) {
                a.this.gbj.mg(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bW(boolean z) {
            if (z) {
                if (a.this.gaZ != null) {
                    a.this.gaZ.sm(8);
                }
                if (a.this.gbj != null) {
                    a.this.gbj.mg(true);
                }
            } else {
                if (a.this.gaZ != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                        a.this.gaZ.sm(0);
                    } else {
                        a.this.gaZ.sm(8);
                    }
                }
                if (a.this.gbj != null) {
                    a.this.gbj.mg(false);
                }
            }
            if (a.this.gbB != null) {
                a.this.gbB.bh(z);
            }
        }
    };
    private HttpMessageListener gaJ = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.a.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.FW() != null) {
                        com.baidu.live.v.c.Hx().bex = getQuickGiftHttpResponseMessage.FW();
                        a.this.bDR();
                    }
                }
            }
        }
    };
    private CustomMessageListener gaK = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.d.a.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bEc();
        }
    };
    private CustomMessageListener gaL = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                a.this.gbr.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gaM = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.gbF != null) {
                    a.this.gbF.DO(str);
                }
            }
        }
    };
    CustomMessageListener gaN = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.gbV != null && a.this.gbV.aSF != null && !a.this.gbV.aSI && !a.this.gbV.aSJ && a.this.gbA != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.bFe().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = a.this.bFe().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                a.this.gbA.b(a.this.gax, layoutParams);
                if (e.CI() != null) {
                    e.CI().CO();
                }
            }
        }
    };
    private CustomMessageListener gaO = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (a.this.gbD != null) {
                    a.this.gbD.dismiss();
                }
                com.baidu.live.im.b.d.Ea().setSwitchStatus(true);
                com.baidu.live.im.b.d.Ea().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bEE();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener gaP = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.gaF.c(a.this.bFe());
                } else if (a.this.bEy() || !g.rN(2913168)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, 3000L);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.bFe().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.bFe().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    a.this.gaF.b(a.this.gax, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gaQ = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.a.10
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
            if (currentTimeMillis - a.this.lastClickTime >= 300) {
                a.this.lastClickTime = currentTimeMillis;
                if (i == 2 && a.this.BR()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel"));
                    a.this.K(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.v.c.Hx().bex.zk().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.v.c.Hx().bex.zk().yo());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.v.c.Hx().bex.zk().yp());
                        if (a.this.bFe().gla.FO() != null && a.this.bFe().gla.FO().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.bFe().gla.FO().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.bFe().gla.FO().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.Et());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.BR()) {
                        if (com.baidu.live.c.vf().getBoolean("quick_gift_guide_show", true) && !a.this.bEy()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, z.class, a.this.bFe().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                z zVar = (z) runTask.getData();
                                zVar.setPageContext(a.this.bFe().pageContext);
                                zVar.d(a.this.bFe().gla.FO());
                                zVar.setGiftItem(com.baidu.live.v.c.Hx().bex.zk());
                                zVar.setOtherParams(a.this.Et());
                                zVar.initView();
                                zVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.10.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        a.this.li(false);
                                        a.this.gaE = null;
                                    }
                                });
                                a.this.gaE = zVar;
                                zVar.show();
                                a.this.li(true);
                                return;
                            }
                            return;
                        }
                        n.a(a.this.bFe().pageContext, a.this.bFe().gla.FO(), com.baidu.live.v.c.Hx().bex.zk(), a.this.Et());
                    }
                } else if (i == 1) {
                    if (a.this.gbo != null) {
                        a.this.bEE();
                    }
                } else if (i == 3 && a.this.BR()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    if (a.this.mOrientation == 2 && TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.gaw != null) {
                            a.this.gaw.y(a.this.bFe().gla.FO());
                        }
                    } else {
                        a.this.gbb.c(a.this.bFe().gla.FO(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.bFe() != null && a.this.bFe().gla != null && a.this.bFe().gla.FO() != null && a.this.bFe().gla.FO().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.bFe().gla.FO().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.bFe().gla.FO().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.bFe().gla.FO().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.Et());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.bFe() != null && a.this.bFe().gla != null && a.this.bFe().gla.FO() != null && a.this.bFe().gla.FO().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.bFe().gla.FO().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.bFe().gla.FO().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.bFe().gla.FO().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.Et());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.aYP != null) {
                        a.this.aYP.bR(false);
                    }
                } else if (i == 12) {
                    if (a.this.gbj != null) {
                        String valueOf = String.valueOf(a.this.bFe().gla.FO().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.bFe().gla.FO().mLiveInfo.room_id);
                        String str3 = null;
                        o oVar = a.this.bFe().gla.FO().mLiveSdkInfo;
                        if (oVar != null && oVar.mCastIds != null) {
                            str3 = String.valueOf(a.this.bFe().gla.FO().mLiveSdkInfo.mCastIds.ayO);
                        }
                        a.this.gbj.ai(valueOf, valueOf2, str3);
                        if (com.baidu.live.liveroom.a.Fj().Fk()) {
                            a.this.bEc();
                        }
                    }
                } else if (i == 14) {
                    q FO = a.this.bFe().gla.FO();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.bFe().pageContext.getPageActivity(), FO.ayC.userName, Long.toString(FO.ayC.userId), Long.toString(FO.ayC.charmCount), String.valueOf(FO.mLiveInfo.group_id), String.valueOf(FO.mLiveInfo.live_id), false, String.valueOf(FO.ayC.userId), Long.toString(FO.ayV.userId), FO.ayV.userName, FO.ayV.portrait, a.this.gan.getCount(), a.this.Et())));
                    LogManager.getCommonLogger().doClickGusetNumLog(FO.mLiveInfo.feed_id, a.this.gan.getCount() + "", a.this.Et());
                } else if (i == 11) {
                    a.this.bEH();
                    a.this.bEI();
                } else if (i == 16) {
                    if (a.this.bFe() != null && (bcVar2 = com.baidu.live.v.a.Hs().beo) != null && (bmVar2 = bcVar2.aEo) != null) {
                        String str4 = bmVar2.aFk.aFr;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (a.this.bFe().gla != null && a.this.bFe().gla.FO() != null && a.this.bFe().gla.FO().mLiveInfo != null) {
                                j = a.this.bFe().gla.FO().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", a.this.bFe().gla.FO().mLiveInfo.room_id + "", a.this.bFe().gla.FO().mLiveInfo.feed_id, a.this.Et());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.bFe().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (a.this.bFe() != null) {
                        q qVar = null;
                        if (a.this.bFe().gla != null) {
                            qVar = a.this.bFe().gla.FO();
                        }
                        if (qVar != null && qVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.v.b.bMA().aZy != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.v.b.bMA().aZy.aye;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + qVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + qVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(a.this.bFe().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17) {
                    if (a.this.BR() && a.this.bFe() != null && (bcVar = com.baidu.live.v.a.Hs().beo) != null && (bmVar = bcVar.aEo) != null && (bsVar = bmVar.aFl) != null && !TextUtils.isEmpty(bsVar.webUrl)) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                        if (a.this.gbD != null && a.this.bFe().gla != null && a.this.bFe().gla.FO() != null) {
                            q FO2 = a.this.bFe().gla.FO();
                            a.this.gbD.a(bsVar.webUrl, FO2.mLiveInfo.live_id, FO2.ayV.userId, FO2.ayC.userId);
                            a.this.gaA.cj(false);
                            a.this.gaA.Iq();
                        }
                    }
                } else if (i == 18) {
                    if (a.this.gaC) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.gaC = !a.this.gaC;
                } else if (i == 19 && a.this.gaA != null) {
                    a.this.gaA.Iq();
                }
            }
        }
    };

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
        return false;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void m(q qVar) {
        super.m(qVar);
        g.bHO();
        this.gaC = false;
        if (this.gbg != null) {
            this.gbg.b(this.gaQ);
        }
        if (this.gaA == null) {
            this.gaA = new com.baidu.live.tieba.e.b(bFe().pageContext.getPageActivity());
            this.gaA.start();
        }
        this.gaA.cj(true);
        bFe().pageContext.getPageActivity().setRequestedOrientation(-1);
        bFe().glb.setIsForceHandledTouch(false);
        bFe().glb.setSwipeClearEnable(true);
        bFe().glb.setOnLiveViewScrollListener(this.gaI);
        bFe().glb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gaD.removeCallbacksAndMessages(null);
                a.this.lc(false);
                if (!a.this.gaB) {
                    a.this.gaD.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.gaB) {
                                a.this.lc(false);
                            }
                        }
                    }, 5000L);
                }
            }
        });
        if (this.gbO != null) {
            this.gbO.setVisibility(0);
        }
        bDI();
        if (this.gby != null) {
            this.gby.a(qVar, this.bcj);
            this.gby.S(this.gbP);
            this.gby.a(this);
        }
        bDU();
        bEu();
        bDV();
        bDH();
        bDZ();
        bDW();
        ld(false);
        bEL();
        bEK();
        bDL();
        bDS();
        bDT();
        bEM();
        bDF();
        bEb();
        bEd();
        lj(true);
        bDK();
        bDR();
        bEV();
        bDM();
        bDN();
        bDO();
        bDP();
        bEe();
        bER();
        bDE();
        bEU();
        if (this.gbD != null && this.gbD.bMI() == null) {
            this.gbD.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.21
                @Override // com.baidu.tieba.ala.liveroom.turntable.d.a
                public void onDismiss() {
                    a.this.gaA.cj(true);
                }
            });
        }
        c(this.flX);
        MessageManager.getInstance().registerListener(this.gaJ);
        MessageManager.getInstance().registerListener(this.gaK);
        MessageManager.getInstance().registerListener(this.gaN);
        MessageManager.getInstance().registerListener(this.gaO);
        MessageManager.getInstance().registerListener(this.gaP);
        MessageManager.getInstance().registerListener(this.gaM);
        MessageManager.getInstance().registerListener(this.gaL);
        bEf();
        bDY();
        if (this.mOrientation == 2) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(bFe().pageContext.getPageActivity());
            l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(bFe().pageContext.getPageActivity()));
        }
    }

    private void bDE() {
        if (this.gbK != null) {
            this.gbK.a(new a.InterfaceC0588a() { // from class: com.baidu.tieba.ala.liveroom.d.a.22
                @Override // com.baidu.tieba.ala.liveroom.recommend.a.InterfaceC0588a
                public void lg(boolean z) {
                    if (a.this.gat != null) {
                        a.this.gat.setNeedCloseRecommendFloat(z);
                    }
                    if (a.this.bFe().glb.gzz) {
                        if (a.this.gbj != null) {
                            a.this.gbj.lX(z);
                            a.this.gbj.mg(!z);
                        }
                        if (a.this.gbg != null) {
                            a.this.gbg.lX(z);
                            a.this.gbg.setPraiseEnable(!z);
                            a.this.gbg.lW(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lc(boolean z) {
        View zs;
        if (bFe() != null && bFe().pageContext != null && bFe().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(bFe().pageContext.getPageActivity()) == 2 || z) {
                if (this.gbr != null && (zs = this.gbr.zs()) != null) {
                    if (this.gaB) {
                        zs.setVisibility(0);
                    } else {
                        zs.setVisibility(8);
                    }
                }
                if (this.gaB) {
                    if (this.gbO != null) {
                        this.gbO.setVisibility(0);
                    }
                    if (this.gbP != null) {
                        this.gbP.setVisibility(0);
                    }
                    if (this.bcj != null) {
                        this.bcj.setVisibility(0);
                    }
                    if (this.bcj != null) {
                        this.bcj.setVisibility(0);
                    }
                    if (this.gbq != null) {
                        this.gbq.bf(false);
                    }
                } else {
                    if (this.gbO != null) {
                        this.gbO.setVisibility(8);
                    }
                    if (this.gbP != null) {
                        this.gbP.setVisibility(8);
                    }
                    if (this.bcj != null) {
                        this.bcj.setVisibility(8);
                    }
                    if (this.bcj != null) {
                        this.bcj.setVisibility(8);
                    }
                    if (this.gbq != null) {
                        this.gbq.bf(true);
                    }
                }
                this.gaB = this.gaB ? false : true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, boolean z2) {
        ImageView imageView;
        View zb;
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view;
        }
        if (z) {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_off);
            }
            if (this.gay != null) {
                this.gay.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_on);
            }
            if (this.gay != null) {
                this.gay.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.gbq != null && (zb = this.gbq.zb()) != null) {
            if (z) {
                zb.setVisibility(8);
            } else {
                zb.setVisibility(0);
            }
        }
    }

    private void bDF() {
        CustomResponsedMessage runTask;
        if (this.gav == null && (runTask = MessageManager.getInstance().runTask(2913164, com.baidu.live.im.b.a.class, bFe().pageContext)) != null) {
            this.gav = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gav != null) {
            this.gav.setOtherParams(this.otherParams);
            this.gav.a(new a.InterfaceC0167a() { // from class: com.baidu.tieba.ala.liveroom.d.a.23
                @Override // com.baidu.live.im.b.a.InterfaceC0167a
                public void DZ() {
                    a.this.bEP();
                }
            });
        }
    }

    private void bDG() {
        if (this.gbi != null) {
            this.gbi.av(bFe().gkZ.getLiveContainerView());
        }
    }

    private void bDH() {
        if (this.gaw == null) {
            this.gaw = new com.baidu.tieba.ala.liveroom.share.b(bFe().pageContext);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bR(int i) {
        super.bR(i);
        if (this.gaz != null && UtilHelper.getRealScreenOrientation(bFe().pageContext.getPageActivity()) != 2) {
            this.gaz.setVisibility(0);
        }
        bDG();
        if (this.gat != null) {
            this.gat.bR(i);
        }
        if (this.gat == null || !this.gat.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void ld(boolean z) {
        super.ld(z);
        this.gbq.bZ(bFe().gla.FO().mLiveInfo.screen_direction);
    }

    private void bDI() {
        if (this.bcj == null) {
            PendantParentView.Model model = PendantParentView.Model.HORIZONTAL;
            if (this.mOrientation == 2) {
                model = PendantParentView.Model.HORIZONTAL_FULL;
            }
            this.bcj = new PendantParentView(bFe().pageContext.getPageActivity(), model);
            bFe().glb.addView(this.bcj, ((bFe().glb.getView() == null || this.gbg == null || this.gbg.getView() == null) ? -1 : bFe().glb.getView().indexOfChild(this.gbg.getView())) + 1, new RelativeLayout.LayoutParams(-1, bDJ()));
            this.bcj.setDefaultItemMargin(bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            rF(this.mOrientation);
        }
    }

    private int bDJ() {
        int bottom;
        int bottom2;
        if (bFe().aYS.getLivePlayer().getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bFe().aYS.getLivePlayer().getLayoutParams();
            bottom = layoutParams.topMargin + layoutParams.height;
        } else {
            bottom = bFe().aYS.getLivePlayer().getBottom();
        }
        if (bFe().glb.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) bFe().glb.getLayoutParams();
            bottom2 = layoutParams2.topMargin + layoutParams2.height;
        } else {
            bottom2 = bFe().glb.getBottom();
        }
        return ((bottom2 - bottom) - bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
    }

    private void bDK() {
        if (this.gaq == null) {
            this.gaq = new com.baidu.tieba.ala.liveroom.activeview.b(bFe().pageContext);
        }
        if (bFe() != null && bFe().gla != null) {
            this.gaq.Dp(bFe().gla.bLO());
        }
        this.gaq.setOtherParams(Et());
        this.gaq.b(bFe().gla.FO(), true);
        this.gaq.setHost(false);
        this.gaq.a(1, this.bcj);
        this.gaq.a(2, this.bcj);
        this.gaq.setVisible(this.gbS ? 8 : 0);
    }

    private void bDL() {
        if (this.gbf != null && bFe() != null && bFe().gla != null) {
            this.gbf.b(this.gbO, bFe().gla.FO());
        }
    }

    private void bDM() {
        if (this.bcj != null) {
            if (this.gao == null) {
                this.gao = new com.baidu.tieba.ala.liveroom.l.a(bFe().pageContext, this);
            }
            this.gao.setOtherParams(Et());
            this.gao.a((ViewGroup) this.bcj, bDQ());
            this.gao.u(bFe().gla.FO());
        }
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
            this.gaZ.a(new a.InterfaceC0586a() { // from class: com.baidu.tieba.ala.liveroom.d.a.7
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0586a
                public void bC(int i, int i2) {
                    q FO = a.this.bFe().gla.FO();
                    if (FO != null && FO.mLiveInfo != null) {
                        if (a.this.gbE == null) {
                            a.this.gbE = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.bFe().pageContext.getPageActivity());
                        }
                        a.this.gbE.d(a.this.gbP, i, i2);
                        a.this.gbE.a(String.valueOf(FO.mLiveInfo.live_id), new a.InterfaceC0592a() { // from class: com.baidu.tieba.ala.liveroom.d.a.7.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0592a
                            public void a(float f, String str) {
                                if (a.this.gaZ != null) {
                                    a.this.gaZ.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0586a
                public void bD(int i, int i2) {
                    if (a.this.gbE != null) {
                        a.this.gbE.bI(i, i2);
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
            this.gaF = new com.baidu.tieba.ala.liveroom.j.b(bFe().pageContext, Et(), this.gcd, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.8
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bEo() {
                    a.this.li(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bEp() {
                    a.this.li(false);
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
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = bFe().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDR() {
        if (this.gaZ == null) {
            bDW();
        }
        this.gaZ.a(com.baidu.live.v.c.Hx().bex, bFe().gla.FO());
    }

    private void bDS() {
        CustomResponsedMessage runTask;
        if (this.gbo == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, bFe().pageContext)) != null && runTask.getData() != null) {
            this.gbo = (k) runTask.getData();
            this.gbo.setFromMaster(false);
            this.gbo.DC().getView().setId(a.g.ala_liveroom_msg_list);
            this.gbo.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.9
                @Override // com.baidu.live.im.k.a
                public boolean DF() {
                    return a.this.BR();
                }

                @Override // com.baidu.live.im.k.a
                public void DG() {
                    a.this.gbW = true;
                }

                @Override // com.baidu.live.im.k.a
                public void fv(String str) {
                    if (!a.this.gbS) {
                        a.this.lf(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.bFe().pageContext.getPageActivity(), a.this.bFe().gkZ.getLiveContainerView());
                    }
                    a.this.Du(str);
                }

                @Override // com.baidu.live.im.k.a
                public void DH() {
                    if (a.this.gbS) {
                        a.this.lf(true);
                        a.this.bFe().gkZ.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.bFe().pageContext.getPageActivity(), a.this.bFe().gkZ.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (a.this.gbo != null) {
                        a.this.gbo.DD().setQuickInputPanelVisible(false);
                        a.this.gbo.DD().EU();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void DI() {
                    if (a.this.gbS) {
                        a.this.bEn();
                        if (a.this.gbp != null) {
                            a.this.gbp.vC();
                        }
                        if (a.this.gav != null) {
                            a.this.gav.vC();
                        }
                    } else if (a.this.gbo != null) {
                        a.this.gbo.DD().setQuickInputPanelVisible(false);
                        a.this.gbo.DD().EU();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean DJ() {
                    return a.this.bEz();
                }

                @Override // com.baidu.live.im.k.a
                public int DK() {
                    return a.this.bEA();
                }
            });
            this.gax = new FrameLayout(bFe().pageContext.getPageActivity());
            this.gax.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.gbo != null && this.gax != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bFe().pageContext.getPageActivity()) * 0.75f);
            int dimensionPixelSize = bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds120) + ((int) (BdUtilHelper.getEquipmentHeight(bFe().pageContext.getPageActivity()) * 0.33f));
            if (this.gbP.indexOfChild(this.gax) < 0) {
                if (this.gax.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gax.getParent()).removeView(this.gax);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                this.gbP.addView(this.gax, layoutParams);
            }
            if (this.gax.indexOfChild(this.gbo.DC().getView()) < 0) {
                if (this.gbo.DC().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gbo.DC().getView()).removeView(this.gbo.DC().getView());
                }
                if (UtilHelper.getRealScreenOrientation(bFe().pageContext.getPageActivity()) != 2) {
                    this.gax.addView(this.gbo.DC().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, dimensionPixelSize));
                }
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

    private void bDT() {
        if (this.gay == null) {
            this.gay = new FrameLayout(bFe().pageContext.getPageActivity());
            this.gay.setId(a.g.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void bDU() {
        if (this.gak == null) {
            this.gak = new com.baidu.tieba.ala.liveroom.n.a(bFe().pageContext, false, this);
        }
        this.gak.c(this.gbO, bFe().gla.FO());
        this.gak.a(this.gaQ);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void bEc() {
        String str;
        if (bFe() != null && bFe().gla != null && bFe().gla.FO() != null && bFe().gla.FO().ayV != null && (str = bFe().gla.FO().ayV.userName) != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bFe().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !bEy()) {
            com.baidu.live.c.vf().putInt("guide_rename_show_count", com.baidu.live.c.vf().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.Fj().bQ(true);
            if (this.gbH == null) {
                this.gbH = new com.baidu.tieba.ala.liveroom.u.a(bFe().pageContext);
            }
            this.gbH.setOtherParams(Et());
            this.gbH.e(this.gbP, bFe().gla.FO());
            li(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.12
                @Override // java.lang.Runnable
                public void run() {
                    a.this.gbH.bMp();
                    a.this.li(false);
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
        if (this.gbj == null) {
            this.gbj = new com.baidu.tieba.ala.liveroom.w.a(bFe().pageContext, this);
        }
        this.gbj.d(bFe().glb, false);
        this.gbj.mf(bFd());
    }

    private void bEe() {
        if (bFe() != null && bFe().aYS != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(bFe().pageContext.getPageActivity());
            Activity pageActivity = bFe().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + pageActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds176)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.gaz = new ImageView(bFe().pageContext.getPageActivity());
            this.gaz.setVisibility(8);
            this.gaz.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.gaz.setImageResource(a.f.icon_live_enlarge);
            this.gaz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.gaA != null) {
                        a.this.gaA.Ip();
                        a.this.gaz.setVisibility(4);
                    }
                }
            });
            bFe().glb.addView(this.gaz, layoutParams);
            if (UtilHelper.getRealScreenOrientation(bFe().pageContext.getPageActivity()) != 2) {
                if (bFe().glg) {
                    this.gaz.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.14
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.gaz != null && UtilHelper.getRealScreenOrientation(a.this.bFe().pageContext.getPageActivity()) != 2) {
                                a.this.gaz.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
        }
    }

    private void bEf() {
        if (this.gbW || this.gbX) {
            if ((TbadkCoreApplication.isLogin() && this.gbo.DD().hasText()) || this.gbX) {
                this.gbW = false;
                this.gbX = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.15
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bEE();
                    }
                }, 500L);
            }
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
            e.printStackTrace();
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
        if (this.gav != null) {
            this.gav.a(qVar);
        }
        if (this.gaq != null) {
            this.gaq.j(qVar);
            if (qVar != null && this.gbL != null && !this.gbL.hasInit && !TextUtils.isEmpty(this.gbL.aEI)) {
                this.gbL.hasInit = true;
                this.gaq.Dr(this.gbL.aEI);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(com.baidu.live.data.k kVar) {
        if (kVar != null) {
            if (this.gaj != null && kVar.getList() != null) {
                this.gaj.e(kVar);
            }
            if (this.gan != null) {
                this.gan.dD(kVar.getCount());
            }
        }
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
        if (this.gas != null) {
            this.gas.wd();
        }
        if (this.gav != null) {
            this.gav.a((a.InterfaceC0167a) null);
            this.gav.vD();
        }
        if (this.gaz != null && (this.gaz.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gaz.getParent()).removeView(this.gaz);
        }
        if (this.gaw != null) {
            this.gaw.dismiss();
        }
        if (this.gaA != null) {
            this.gaA.cj(false);
            this.gaA.Iq();
        }
        if (this.gaF != null) {
            this.gaF.wd();
        }
        if (this.gcd != null) {
            this.gcd.bGe();
        }
        if (this.gbN != null) {
            this.gbN.wd();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void n(q qVar) {
        View vB;
        super.n(qVar);
        if (this.gav != null && (vB = this.gav.vB()) != null && vB.getParent() != null) {
            ((ViewGroup) vB.getParent()).removeView(vB);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.gav != null) {
            this.gav.setOtherParams(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void bU(boolean z) {
        super.bU(z);
        this.gaD.removeCallbacksAndMessages(null);
        bEg();
        this.gaB = false;
        this.gaC = false;
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
        if (this.gaw != null) {
            this.gaw.onDestroy();
        }
        if (this.gal != null) {
            this.gal.onDestroy();
        }
        if (this.gaA != null) {
            this.gaA.stop();
        }
        if (this.gbj != null) {
            this.gbj.onDestroy();
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
        if (this.gav != null) {
            this.gav.a((a.InterfaceC0167a) null);
            this.gav.release();
            this.gav = null;
        }
        if (this.gcd != null) {
            this.gcd.bU(z ? false : true);
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
        MessageManager.getInstance().unRegisterListener(this.gaN);
        MessageManager.getInstance().unRegisterListener(this.gaO);
        MessageManager.getInstance().unRegisterListener(this.gaP);
        MessageManager.getInstance().unRegisterListener(this.gaM);
        MessageManager.getInstance().unRegisterListener(this.gaL);
    }

    private void bEg() {
        if (this.gbo != null && this.gbo.DC().getView() != null && this.gbo.DC().getView().getParent() != null) {
            ((ViewGroup) this.gbo.DC().getView().getParent()).removeView(this.gbo.DC().getView());
        }
        if (this.gax != null && this.gax.getParent() != null) {
            ((ViewGroup) this.gax.getParent()).removeView(this.gax);
        }
        if (this.gay != null && this.gay.getParent() != null) {
            ((ViewGroup) this.gay.getParent()).removeView(this.gay);
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

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected ViewGroup bEk() {
        return this.bcj;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected ViewGroup bEl() {
        return null;
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
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.gbS;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(bFe().pageContext.getPageActivity()) || z2) {
            le(z);
        }
    }

    private void le(boolean z) {
        int dimensionPixelSize;
        if (this.gbo != null && this.gbo.DC() != null) {
            this.gbo.DC().onKeyboardVisibilityChanged(z);
        }
        if (z || this.gbo == null || !this.gbo.DD().ET()) {
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
            if (this.gbo != null && this.gax != null) {
                int equipmentHeight = (int) ((z ? 0.2f : 0.33f) * BdUtilHelper.getEquipmentHeight(bFe().pageContext.getPageActivity()));
                if (z) {
                    dimensionPixelSize = equipmentHeight + bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64);
                } else {
                    dimensionPixelSize = equipmentHeight + bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
                }
                if (this.gbP.indexOfChild(this.gax) != -1 && this.gax.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gax.getLayoutParams();
                    layoutParams2.height = dimensionPixelSize;
                    this.gax.setLayoutParams(layoutParams2);
                }
                if (this.gax.indexOfChild(this.gbo.DC().getView()) != -1 && this.gbo.DC().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.gbo.DC().getView().getLayoutParams();
                    layoutParams3.height = dimensionPixelSize;
                    this.gbo.DC().getView().setLayoutParams(layoutParams3);
                }
                this.gbo.DC().DB();
            }
        }
    }

    private void bEm() {
        if (this.gaZ != null) {
            this.gaZ.setVisibility(0);
        }
        if (this.gax != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gax.getLayoutParams();
            layoutParams.bottomMargin = bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            this.gax.setLayoutParams(layoutParams);
        }
        if (this.gbo != null) {
            bEF();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gbo.DD().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.gbo.DD().getView().setLayoutParams(layoutParams2);
        }
        if (this.gaZ != null) {
            this.gaZ.setVisibility(0);
        }
        if (this.gbq != null && this.gbq.zb() != null) {
            this.gbq.zb().setVisibility(0);
        }
        if (this.gbO != null && (!this.gaB || UtilHelper.getRealScreenOrientation(bFe().pageContext.getPageActivity()) != 2)) {
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
        FrameLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        FrameLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = bFe().pageContext.getPageActivity();
        if (i3 == 1) {
            if (this.gbO != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.gbO.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.gaw != null) {
                this.gaw.dismiss();
            }
            if (this.gav != null) {
                this.gav.a((a.InterfaceC0167a) null);
                this.gav.vD();
            }
            if (this.aYP != null) {
                this.aYP.e(true, true);
            }
            if (this.gaz != null) {
                this.gaz.setVisibility(0);
                this.gaz.bringToFront();
            }
            if (this.gbe != null) {
                this.gbe.setVisibility(0);
            }
            if (this.gbo != null && this.gbo.DC().getView().getParent() != null && (this.gbo.DC().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gbo.DC().getView().getParent()).removeView(this.gbo.DC().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bFe().pageContext.getPageActivity()) * 0.7f);
            int equipmentHeight = ((int) (BdUtilHelper.getEquipmentHeight(bFe().pageContext.getPageActivity()) * 0.33f)) + bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
            if (this.gax != null && this.gbo != null) {
                this.gax.addView(this.gbo.DC().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, equipmentHeight));
            }
            if (this.gay != null && (this.gay.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gay.getParent()).removeView(this.gay);
            }
            if (this.gbp != null) {
                this.gbp.a(bFe().gla.FO(), false);
                this.gbp.a(new a.InterfaceC0167a() { // from class: com.baidu.tieba.ala.liveroom.d.a.16
                    @Override // com.baidu.live.im.b.a.InterfaceC0167a
                    public void DZ() {
                        a.this.bEP();
                    }
                });
                View vB = this.gbp.vB();
                if (vB != null && this.gbP != null && vB.getParent() == null) {
                    Resources resources = bFe().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bFe().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds98));
                    layoutParams5.addRule(2, a.g.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                    this.gbP.addView(vB, layoutParams5);
                }
            }
            if (this.gbg != null) {
                this.gbg.setPraiseEnable(true);
                bFe().glb.gzz = true;
            }
            if (this.gaj != null && this.gaj.gdc != null && (layoutParams3 = (FrameLayout.LayoutParams) this.gaj.gdc.getLayoutParams()) != null) {
                layoutParams3.width = -2;
                this.gaj.gdc.setLayoutParams(layoutParams3);
            }
            if (this.gbj != null) {
                this.gbj.bNI();
            }
            if (this.gaB) {
                lc(true);
            }
            if (this.gaC) {
                if (this.gaZ != null && this.gaZ.getLandscapeBarrageImageView() != null) {
                    b(this.gaZ.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.gan != null) {
                this.gan.lp(true);
            }
            this.gaD.removeCallbacksAndMessages(null);
            if (this.gao != null) {
                this.gao.setCanVisible(true);
                this.gao.u(bFe().gla.FO());
            }
        } else if (i3 == 2) {
            if (this.gbj != null) {
                this.gbj.bNJ();
            }
            if (this.gbO != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.gbO.getLayoutParams()) != null) {
                layoutParams2.topMargin = bFe().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
            }
            if (this.gbp != null) {
                this.gbp.a((a.InterfaceC0167a) null);
                this.gbp.vD();
            }
            bFe().glb.bNl();
            if (this.aYP != null) {
                this.aYP.e(false, true);
            }
            if (this.gaz != null) {
                this.gaz.setVisibility(4);
            }
            if (this.gbo != null && this.gbo.DC().getView().getParent() != null && (this.gbo.DC().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gbo.DC().getView().getParent()).removeView(this.gbo.DC().getView());
            }
            int max = Math.max(i, i2);
            if (this.gay != null) {
                if (this.gay.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gay.getParent()).removeView(this.gay);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
                bFe().glb.addView(this.gay, layoutParams6);
            }
            if (this.gay != null && this.gav != null) {
                this.gav.a(bFe().gla.FO(), false);
                this.gav.a(new a.InterfaceC0167a() { // from class: com.baidu.tieba.ala.liveroom.d.a.17
                    @Override // com.baidu.live.im.b.a.InterfaceC0167a
                    public void DZ() {
                        a.this.bEP();
                    }
                });
                View vB2 = this.gav.vB();
                if (vB2 != null && this.gay.indexOfChild(vB2) < 0) {
                    this.gay.addView(vB2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bFe().pageContext.getPageActivity()), -1));
                }
            }
            if (this.gbg != null) {
                this.gbg.ay(bFe().glb);
                this.gbg.setPraiseEnable(false);
                bFe().glb.gzz = false;
            }
            if (this.gaj != null && this.gaj.gdc != null && (layoutParams = (FrameLayout.LayoutParams) this.gaj.gdc.getLayoutParams()) != null) {
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                layoutParams.width = (int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f);
                this.gaj.gdc.setLayoutParams(layoutParams);
            }
            if (this.gan != null) {
                this.gan.lp(false);
            }
            if (ac.zB() != null) {
                ac.zB().zA();
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.x.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.x.c) runTask.getData()).zA();
            }
            if (this.gaZ != null && this.gaZ.getLandscapeBarrageImageView() != null) {
                b(this.gaZ.getLandscapeBarrageImageView(), this.gaC, false);
            }
            this.gaD.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.18
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.gaB) {
                        a.this.lc(false);
                    }
                }
            }, 5000L);
            if (this.gbq != null) {
                this.gbq.zd();
            }
            if (this.gao != null) {
                this.gao.setCanVisible(false);
                this.gao.bHS();
            }
        }
        if (this.gbr != null) {
            if (i3 == 2) {
                View zs = this.gbr.zs();
                if (zs != null) {
                    if (zs.getParent() != null && (zs.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) zs.getParent()).removeView(zs);
                    }
                    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams7.addRule(5, a.g.ala_liveroom_hostheader);
                    layoutParams7.addRule(3, a.g.ala_liveroom_hostheader);
                    layoutParams7.topMargin = bFe().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                    if (this.gbO != null) {
                        this.gbO.addView(zs, layoutParams7);
                    }
                }
            } else {
                View zs2 = this.gbr.zs();
                if (zs2 != null) {
                    if (zs2.getParent() != null && (zs2.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) zs2.getParent()).removeView(zs2);
                    }
                    RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams8.topMargin = bFe().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18) * (-1);
                    layoutParams8.addRule(3, a.g.ala_live_header_view);
                    bFe().glb.addView(zs2, layoutParams8);
                }
            }
        }
        if (this.gaZ != null) {
            this.gaZ.l(i, i2, i3);
        }
        rF(i3);
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.gaj != null) {
                this.gaj.bN(i3);
            }
            if (this.gal != null) {
                this.gal.bN(i3);
            }
            if (this.gaq != null) {
                this.gaq.bN(i3);
            }
            if (this.gbu != null) {
                this.gbu.bN(i3);
            }
            if (this.gbD != null) {
                this.gbD.bN(i3);
            }
            if (this.gaE != null && this.gaE.isShowing()) {
                this.gaE.resize();
            }
            if (this.gbM != null) {
                this.gbM.bN(i3);
            }
            if (this.gbN != null) {
                this.gbN.bN(i3);
            }
        }
        if (this.gbq != null) {
            this.gbq.zc();
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
            if (i != 7 || UtilHelper.getRealScreenOrientation(bFe().pageContext.getPageActivity()) != 2) {
                if (this.gaZ != null) {
                    this.gaZ.setVisibility(8);
                }
                if (this.gbo != null) {
                    this.gbo.DC().getView().setVisibility(4);
                }
                if (this.gbE != null) {
                    this.gbE.mb(false);
                }
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
            if (this.gbE != null) {
                this.gbE.mb(true);
            }
            if (!this.gaB || UtilHelper.getRealScreenOrientation(bFe().pageContext.getPageActivity()) != 2) {
                this.gbO.setVisibility(0);
            }
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
        if (bFe() != null) {
            BdUtilHelper.hideSoftKeyPad(bFe().pageContext.getPageActivity(), bFe().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.gam != null) {
            this.gam.bMh();
        }
        if (this.gas != null) {
            this.gas.wm();
        }
        if (this.gaq != null) {
            this.gaq.onStart();
        }
    }

    private void rF(int i) {
        if (this.bcj != null) {
            int dimensionPixelSize = bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bcj.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                layoutParams.rightMargin = bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.height = bDJ();
                this.bcj.setPosition(dimensionPixelSize, 0, dimensionPixelSize, 0);
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                int dimensionPixelSize2 = bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds72) + 0 + bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100) + bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
                layoutParams.height = -1;
                this.bcj.setPosition(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
            }
            layoutParams.bottomMargin = bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            this.bcj.setLayoutParams(layoutParams);
            this.bcj.setModel(i == 1 ? PendantParentView.Model.HORIZONTAL : PendantParentView.Model.HORIZONTAL_FULL);
        }
    }
}
