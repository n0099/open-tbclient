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
    private PendantParentView bot;
    private com.baidu.tieba.ala.liveroom.audiencelist.c gDQ;
    private com.baidu.tieba.ala.liveroom.p.a gDR;
    private com.baidu.tieba.ala.liveroom.g.b gDS;
    private com.baidu.tieba.ala.liveroom.v.b gDT;
    private com.baidu.tieba.ala.liveroom.audiencelist.b gDU;
    private com.baidu.tieba.ala.liveroom.l.a gDV;
    private com.baidu.tieba.ala.liveroom.activeview.b gDW;
    private com.baidu.live.d.a gDX;
    private i gDY;
    private h gDZ;
    private com.baidu.tieba.ala.liveroom.c.a gEa;
    private FrameLayout gEd;
    private com.baidu.tieba.ala.liveroom.j.b gEm;
    private e gGA;
    private boolean gGB;
    private LinearLayout gGz;
    private long lastClickTime = 0;
    private boolean gGC = false;
    private HttpRule gEn = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.gDY != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.gDY.Db()) {
                httpMessage.addParam("ala_challenge_id", d.this.gDY.De());
            }
            return httpMessage;
        }
    };
    private HttpRule gEo = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.gDY != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.gDY.Db()) {
                httpMessage.addParam("challenge_id", d.this.gDY.De());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c gEp = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.d.16
        @Override // com.baidu.live.liveroom.g.c
        public void Nh() {
            if (d.this.gEP != null) {
                d.this.gEP.nr(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void ch(boolean z) {
            if (z) {
                if (d.this.gEP != null) {
                    d.this.gEP.nr(true);
                }
            } else if (d.this.gEP != null) {
                d.this.gEP.nr(false);
            }
            if (d.this.gFh != null) {
                d.this.gFh.bq(z);
            }
            if (d.this.gDW != null) {
                d.this.gDW.mh(z ? false : true);
            }
            com.baidu.live.m.a.ci(z);
        }
    };
    private HttpMessageListener gEr = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.d.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Nq() != null) {
                        com.baidu.live.x.c.OX().bqR = getQuickGiftHttpResponseMessage.Nq();
                        d.this.bRV();
                    }
                }
            }
        }
    };
    CustomMessageListener gEw = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.d.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.gEm.c(d.this.bTl());
                } else if (d.this.bSD() || !g.vb(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.19.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.bTl().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.bTl().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    d.this.gEm.c(d.this.gEd, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener gGD = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.d.d.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.bSD() || !g.vb(2913128)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.uZ(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    d.this.Hc(str);
                }
            }
        }
    };
    private CustomMessageListener gEs = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.gEX.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gEt = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.d.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.this.gFl != null) {
                    d.this.gFl.hE(str);
                }
            }
        }
    };
    CustomMessageListener gEu = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.gFG != null && d.this.gFG.bdN != null && !d.this.gFG.bdQ && !d.this.gFG.bdR && d.this.gFg != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.bTl().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = d.this.bTl().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                d.this.gFg.c(d.this.gEd, layoutParams);
                if (com.baidu.live.guardclub.e.JL() != null) {
                    com.baidu.live.guardclub.e.JL().JR();
                }
            }
        }
    };
    private CustomMessageListener gEv = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.gFi != null) {
                    d.this.gFi.dismiss();
                }
                if (d.this.gFl != null) {
                    d.this.gFl.dismiss();
                }
                if (d.this.gFj != null) {
                    d.this.gFj.dismiss();
                }
                if (d.this.gFw != null) {
                    d.this.gFw.dismiss();
                }
                com.baidu.live.im.b.d.Lm().setSwitchStatus(true);
                com.baidu.live.im.b.d.Lm().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bSK();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gEx = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.d.14
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void o(View view, int i) {
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
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.x.c.OX().bqR.Ga().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.x.c.OX().bqR.Ga().Fd());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.x.c.OX().bqR.Ga().Fe());
                        if (d.this.bTl().gON.Gm() != null && d.this.bTl().gON.Gm().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.bTl().gON.Gm().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.bTl().gON.Gm().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.LI());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.IS()) {
                        if (com.baidu.live.c.AZ().getBoolean("quick_gift_guide_show", true) && !d.this.bSD()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, aa.class, d.this.bTl().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                aa aaVar = (aa) runTask.getData();
                                aaVar.setPageContext(d.this.bTl().pageContext);
                                aaVar.d(d.this.bTl().gON.Gm());
                                aaVar.setGiftItem(com.baidu.live.x.c.OX().bqR.Ga());
                                aaVar.setOtherParams(d.this.LI());
                                aaVar.initView();
                                aaVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.d.d.14.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        d.this.mo(false);
                                    }
                                });
                                aaVar.show();
                                d.this.mo(true);
                                return;
                            }
                            return;
                        }
                        n.a(d.this.bTl().pageContext, d.this.bTl().gON.Gm(), com.baidu.live.x.c.OX().bqR.Ga(), d.this.LI());
                    }
                } else if (i == 1) {
                    if (d.this.gEU != null) {
                        d.this.bSK();
                    }
                } else if (i == 3 && d.this.IS()) {
                    if (com.baidu.live.m.a.isDebug()) {
                        com.baidu.live.m.a.b(d.this.bTl().gON.Gm().mLiveInfo.live_id, 0);
                        return;
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    d.this.gEH.c(d.this.bTl().gON.Gm(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.bTl() != null && d.this.bTl().gON != null && d.this.bTl().gON.Gm() != null && d.this.bTl().gON.Gm().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.bTl().gON.Gm().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.bTl().gON.Gm().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.bTl().gON.Gm().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.LI());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.bTl() != null && d.this.bTl().gON != null && d.this.bTl().gON.Gm() != null && d.this.bTl().gON.Gm().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.bTl().gON.Gm().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.bTl().gON.Gm().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.bTl().gON.Gm().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.LI());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.bkR != null) {
                        d.this.bkR.cb(false);
                    }
                } else if (i == 12) {
                    if (d.this.gEP != null && d.this.bTl().gON.Gm() != null && d.this.bTl().gON.Gm().mLiveInfo != null) {
                        String valueOf = String.valueOf(d.this.bTl().gON.Gm().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.bTl().gON.Gm().mLiveInfo.room_id);
                        String str3 = null;
                        s sVar = d.this.bTl().gON.Gm().mLiveSdkInfo;
                        if (sVar != null && sVar.mCastIds != null) {
                            str3 = String.valueOf(d.this.bTl().gON.Gm().mLiveSdkInfo.mCastIds.aHY);
                        }
                        d.this.gEP.ak(valueOf, valueOf2, str3);
                        com.baidu.live.m.a.b(d.this.bTl().gON.Gm().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    u Gm = d.this.bTl().gON.Gm();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.bTl().pageContext.getPageActivity(), Gm.aHD.userName, Long.toString(Gm.aHD.userId), Long.toString(Gm.aHD.charmCount), String.valueOf(Gm.mLiveInfo.group_id), String.valueOf(Gm.mLiveInfo.live_id), false, String.valueOf(Gm.aHD.userId), Long.toString(Gm.aIf.userId), Gm.aIf.userName, Gm.aIf.portrait, d.this.gDU.getCount(), d.this.LI())));
                    LogManager.getCommonLogger().doClickGusetNumLog(Gm.mLiveInfo.feed_id, d.this.gDU.getCount() + "", d.this.LI());
                } else if (i == 11) {
                    d.this.bSN();
                    d.this.bSO();
                } else if (i == 16) {
                    if (d.this.bTl() != null && (bjVar2 = com.baidu.live.x.a.OS().bqJ) != null && (bwVar2 = bjVar2.aNV) != null) {
                        String str4 = bwVar2.aPg.aPn;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (d.this.bTl().gON != null && d.this.bTl().gON.Gm() != null && d.this.bTl().gON.Gm().mLiveInfo != null) {
                                j = d.this.bTl().gON.Gm().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", d.this.bTl().gON.Gm().mLiveInfo.room_id + "", d.this.bTl().gON.Gm().mLiveInfo.feed_id, d.this.LI());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.bTl().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (d.this.bTl() != null) {
                        u uVar = null;
                        if (d.this.bTl().gON != null) {
                            uVar = d.this.bTl().gON.Gm();
                        }
                        if (uVar != null && uVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.w.b.cbG().blx != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.w.b.cbG().blx.aHf;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + uVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + uVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(d.this.bTl().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17 && d.this.IS() && d.this.bTl() != null && (bjVar = com.baidu.live.x.a.OS().bqJ) != null && (bwVar = bjVar.aNV) != null && (ccVar = bwVar.aPh) != null && !TextUtils.isEmpty(ccVar.webUrl)) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                    if (d.this.gFi != null && d.this.bTl().gON != null && d.this.bTl().gON.Gm() != null) {
                        u Gm2 = d.this.bTl().gON.Gm();
                        d.this.gFi.a(ccVar.webUrl, Gm2.mLiveInfo.live_id, Gm2.aIf.userId, Gm2.aHD.userId);
                    }
                }
            }
        }
    };
    private boolean gGE = false;
    private boolean gGF = false;

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.gEJ = new com.baidu.tieba.ala.liveroom.guide.c(bTl().pageContext, this, false);
        this.gEn.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.gEn);
        this.gEo.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.gEo);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean bRF() {
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void n(u uVar) {
        super.n(uVar);
        g.bWD();
        this.gGC = true;
        this.gGF = false;
        this.gGE = false;
        bTl().gOO.setIsForceHandledTouch(false);
        bTl().gOO.setSwipeClearEnable(true);
        bTl().gOO.setOnLiveViewScrollListener(this.gEp);
        bTl().gOO.setOnClickListener(null);
        bTl().gOO.setClickable(false);
        if (this.gEM != null) {
            this.gEM.b(this.gEx);
        }
        if (this.gFz != null) {
            this.gFz.setVisibility(0);
        }
        bRM();
        if (this.gFe != null) {
            this.gFe.a(uVar, this.bot);
            this.gFe.U(this.gFA);
            this.gFe.a(this);
        }
        bTD();
        bRY();
        bSy();
        bRZ();
        bSd();
        bSa();
        mp(false);
        bSR();
        bSQ();
        bRP();
        bRW();
        bSS();
        bSf();
        bSg();
        bTw();
        bTx();
        mq(false);
        bSU();
        bTd();
        bRO();
        bRV();
        bRQ();
        bRR();
        bRS();
        bRT();
        bSZ();
        bRI();
        mu(true);
        bTc();
        c(this.fMS);
        MessageManager.getInstance().registerListener(this.gEr);
        MessageManager.getInstance().registerListener(this.gEs);
        MessageManager.getInstance().registerListener(this.gEu);
        MessageManager.getInstance().registerListener(this.gEv);
        MessageManager.getInstance().registerListener(this.gGD);
        MessageManager.getInstance().registerListener(this.gEw);
        MessageManager.getInstance().registerListener(this.gEt);
        bSi();
        bSc();
    }

    private void bRI() {
        if (this.gFr != null) {
            this.gFr.a(new com.baidu.live.t.c() { // from class: com.baidu.tieba.ala.liveroom.d.d.17
                @Override // com.baidu.live.t.c
                public void co(boolean z) {
                    if (d.this.gDZ != null) {
                        d.this.gDZ.setNeedCloseRecommendFloat(z);
                    }
                    if (d.this.bTl().gOO.hen) {
                        if (d.this.gEP != null) {
                            d.this.gEP.nk(z);
                            d.this.gEP.nr(!z);
                        }
                        if (d.this.gEM != null) {
                            d.this.gEM.nk(z);
                            d.this.gEM.setPraiseEnable(!z);
                            d.this.gEM.nj(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void l(u uVar) {
        super.l(uVar);
        if (this.gDR != null) {
            this.gDR.z(uVar);
        }
        if (this.gDS != null) {
            this.gDS.v(uVar);
        }
        if (this.gDV != null) {
            this.gDV.y(uVar);
        }
        if (this.gDZ != null) {
            this.gDZ.a(uVar);
        }
        mu(false);
        if (this.gDW != null) {
            this.gDW.k(uVar);
            this.gDW.mg(this.gFJ);
            this.gDW.updateView();
            if (uVar != null && this.gFt != null && !this.gFt.hasInit && !TextUtils.isEmpty(this.gFt.aOp)) {
                this.gFt.hasInit = true;
                this.gDW.GY(this.gFt.aOp);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(com.baidu.live.data.n nVar) {
        if (nVar != null) {
            if (this.gDQ != null && nVar.getList() != null) {
                this.gDQ.e(nVar);
            }
            if (this.gDU != null) {
                this.gDU.dY(nVar.getCount());
            }
        }
    }

    private void bRK() {
        if (this.gEO != null) {
            this.gEO.az(bTl().gOM.getLiveContainerView());
        }
    }

    private void bTw() {
        if (this.gEa == null) {
            this.gEa = new com.baidu.tieba.ala.liveroom.c.a(bTl().pageContext);
        }
        if (bTl().gON != null && bTl().gON.Gm() != null && bTl().gON.Gm().mLiveInfo != null) {
            this.gEa.GZ(String.valueOf(bTl().gON.Gm().mLiveInfo.user_id));
        }
    }

    private void bTx() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (bTl() != null && bTl().gON != null && bTl().gON.Gm() != null && bTl().gON.Gm().mLiveInfo != null) {
                j = bTl().gON.Gm().mLiveInfo.room_id;
            }
            if (this.gFc == null) {
                this.gFc = new com.baidu.tieba.ala.liveroom.guide.a(bTl().pageContext, j);
            }
            this.gFc.mn(this.gFC);
            this.gFc.a(new a.InterfaceC0645a() { // from class: com.baidu.tieba.ala.liveroom.d.d.4
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0645a
                public void bTG() {
                    if (d.this.bkR != null) {
                        d.this.bkR.cb(true);
                    }
                }
            });
            this.gFc.av(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void dM(int i) {
        super.dM(i);
        bRK();
        if (this.gDZ != null) {
            this.gDZ.dM(i);
        }
    }

    private void bRM() {
        if (this.bot == null) {
            this.bot = new PendantParentView(bTl().pageContext.getPageActivity(), this.gGB ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            bTl().gOO.addView(this.bot, new ViewGroup.LayoutParams(-1, -1));
            this.bot.setDefaultItemMargin(bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.bot.setPadding(bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20), 0, bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6), 0);
            bTy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTy() {
        int dimensionPixelSize;
        if (this.bot != null) {
            this.bot.setModel(this.gGB ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            int dimensionPixelSize2 = bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds220);
            int dimensionPixelSize3 = bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            if (this.gGB) {
                dimensionPixelSize = bTE();
            } else {
                dimensionPixelSize = bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200);
            }
            this.bot.setPosition(dimensionPixelSize2, 0, dimensionPixelSize, dimensionPixelSize3);
            return;
        }
        bRM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTz() {
        if (bTl().gOO != null && !this.gGF) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.5
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.gEd != null && d.this.gEU != null && d.this.gEU.KP() != null && d.this.gEU.KP().getView() != null) {
                        if (d.this.gGB && !d.this.gFD && d.this.bTl().gOO != null && d.this.bTl().gOO.getHeight() > 0) {
                            int bi = d.this.gDZ != null ? d.this.gDZ.bi(false) : 0;
                            ViewGroup.LayoutParams layoutParams = d.this.gEd.getLayoutParams();
                            int height = d.this.bTl().gOO.getHeight() - bi;
                            int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                i += UtilHelper.getStatusBarHeight();
                            }
                            if (layoutParams != null && d.this.gEU != null) {
                                layoutParams.height = i + d.this.bTl().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height);
                                d.this.gEd.setLayoutParams(layoutParams);
                                ViewGroup.LayoutParams layoutParams2 = d.this.gEU.KP().getView().getLayoutParams();
                                if (layoutParams2 != null) {
                                    layoutParams2.height = layoutParams.height - com.baidu.live.ac.b.cI(false);
                                    d.this.gEU.KP().getView().setLayoutParams(layoutParams2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        int i2 = com.baidu.live.ac.b.i(false, d.this.gFD);
                        if (d.this.gFA.indexOfChild(d.this.gEd) != -1 && d.this.gEd.getLayoutParams() != null) {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) d.this.gEd.getLayoutParams();
                            layoutParams3.height = com.baidu.live.ac.b.c(false, false, d.this.gFD);
                            d.this.gEd.setLayoutParams(layoutParams3);
                        }
                        if (d.this.gEd.indexOfChild(d.this.gEU.KP().getView()) != -1 && d.this.gEU.KP().getView().getLayoutParams() != null) {
                            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) d.this.gEU.KP().getView().getLayoutParams();
                            layoutParams4.height = i2;
                            d.this.gEU.KP().getView().setLayoutParams(layoutParams4);
                        }
                        d.this.gEU.KP().KO();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTA() {
        if (bTl().gOO != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.6
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.gEW != null) {
                        if (d.this.gGB && !d.this.gFD && d.this.bTl().gOO != null && d.this.bTl().gOO.getHeight() > 0) {
                            int height = (d.this.bTl().gOO.getHeight() - (d.this.gDZ != null ? d.this.gDZ.bi(false) : 0)) + d.this.bTl().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            if (d.this.gEW != null) {
                                d.this.gEW.dU(height);
                            }
                        } else if (d.this.gEW != null) {
                            d.this.gEW.dU(com.baidu.live.ac.a.a(d.this.bTl().pageContext.getPageActivity(), false, false, d.this.gFD));
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTB() {
        if (bTl().gOO != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.7
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    if (d.this.gEW != null) {
                        int h = com.baidu.live.ac.a.h(false, false);
                        if (!d.this.gGB || d.this.bTl().gOO == null || d.this.bTl().gOO.getHeight() <= 0) {
                            i = h;
                        } else {
                            int height = d.this.bTl().gOO.getHeight() - (d.this.gDZ != null ? d.this.gDZ.bi(false) : 0);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            i = height + d.this.bTl().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height);
                        }
                        if (d.this.gEW != null) {
                            d.this.gEW.dV(i);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTC() {
        if (this.gEV != null && this.gEV.Cl() != null) {
            ViewGroup.LayoutParams layoutParams = this.gEV.Cl().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bTl().pageContext.getResources().getDimensionPixelOffset(this.gGB ? a.e.sdk_ds100 : a.e.sdk_ds20);
                this.gEV.Cl().setLayoutParams(layoutParams);
            }
        }
    }

    private void bTD() {
        if (this.gGz == null) {
            this.gGz = new LinearLayout(bTl().pageContext.getPageActivity());
            this.gGz.setOrientation(1);
        }
        if (this.gGz.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds160);
            layoutParams.leftMargin = bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bTl().gOO.addView(this.gGz, layoutParams);
        }
    }

    private void bRP() {
        if (this.gEL != null && bTl() != null && bTl().gON != null) {
            this.gEL.c(bTl().gOM.getLiveContainerView(), bTl().gON.Gm());
        }
    }

    private void bRO() {
        if (this.gDW == null) {
            this.gDW = new com.baidu.tieba.ala.liveroom.activeview.b(bTl().pageContext);
        }
        if (bTl() != null && bTl().gON != null) {
            this.gDW.GV(bTl().gON.caW());
        }
        this.gDW.mf(this.gGB);
        this.gDW.setOtherParams(LI());
        this.gDW.b(bTl().gON.Gm(), false);
        this.gDW.setHost(false);
        this.gDW.mg(this.gFJ);
        this.gDW.a(1, this.bot);
        this.gDW.a(2, this.bot);
        this.gDW.setVisible(this.gFD ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRV() {
        if (this.gEF == null) {
            bSa();
        }
        this.gEF.setOtherParams(LI());
        this.gEF.a(com.baidu.live.x.c.OX().bqR, bTl().gON.Gm());
    }

    private void bRQ() {
        if (this.gDV == null) {
            this.gDV = new com.baidu.tieba.ala.liveroom.l.a(bTl().pageContext, this);
        }
        this.gDV.setOtherParams(LI());
        this.gDV.a((ViewGroup) this.bot, bRU());
        this.gDV.y(bTl().gON.Gm());
    }

    private void bRR() {
        if (this.gFg == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, j.class, bTl().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gFg = (j) runTask.getData();
            } else {
                return;
            }
        }
        this.gFg.setOtherParams(LI());
        if (this.gEd != null && this.gEd.indexOfChild(this.gFg.getView()) >= 0) {
            this.gEd.removeView(this.gFg.getView());
        }
    }

    private void bRS() {
        if (this.gEF != null) {
            this.gEF.a(new a.InterfaceC0652a() { // from class: com.baidu.tieba.ala.liveroom.d.d.8
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0652a
                public void bK(int i, int i2) {
                    u Gm = d.this.bTl().gON.Gm();
                    if (Gm != null && Gm.mLiveInfo != null) {
                        if (d.this.gFk == null) {
                            d.this.gFk = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.bTl().pageContext.getPageActivity());
                        }
                        d.this.gFk.d(d.this.gFA, i, i2);
                        d.this.gFk.a(String.valueOf(Gm.mLiveInfo.live_id), new a.InterfaceC0656a() { // from class: com.baidu.tieba.ala.liveroom.d.d.8.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0656a
                            public void a(float f, String str) {
                                if (d.this.gEF != null) {
                                    d.this.gEF.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0652a
                public void bL(int i, int i2) {
                    if (d.this.gFk != null) {
                        d.this.gFk.bQ(i, i2);
                    }
                }
            });
        }
    }

    private void bRT() {
        if (this.gFO == null) {
            this.gFO = new com.baidu.tieba.ala.liveroom.j.e(bTl().pageContext);
        }
        this.gFO.setRoomId(bTl().gON.Gm().mLiveInfo.room_id);
        this.gFO.Ho("");
        this.gFO.b(bTl().gON.Gm(), this.bot);
        if (this.gEm == null) {
            this.gEm = new com.baidu.tieba.ala.liveroom.j.b(bTl().pageContext, LI(), this.gFO, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.9
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bSr() {
                    d.this.mo(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bSs() {
                    d.this.mo(false);
                }
            });
        }
        this.gEm.setRoomId(bTl().gON.Gm().mLiveInfo.room_id);
        if (this.gEd != null && this.gEd.indexOfChild(this.gEm.getView()) >= 0) {
            this.gEd.removeView(this.gEm.getView());
        }
        if (this.gEm != null) {
            this.gEm.b(bTl());
        }
    }

    private LinearLayout.LayoutParams bRU() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    private void bRW() {
        CustomResponsedMessage runTask;
        if (this.gEU == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, bTl().pageContext)) != null && runTask.getData() != null) {
            this.gEU = (k) runTask.getData();
            this.gEU.setFromMaster(false);
            this.gEU.KP().getView().setId(a.g.ala_liveroom_msg_list);
            this.gEU.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.10
                @Override // com.baidu.live.im.k.a
                public boolean KS() {
                    return d.this.IS();
                }

                @Override // com.baidu.live.im.k.a
                public void KT() {
                    d.this.gFH = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hu(String str) {
                    if (!d.this.gFD) {
                        d.this.mm(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.bTl().pageContext.getPageActivity(), d.this.bTl().gOM.getLiveContainerView());
                    }
                    d.this.Hb(str);
                }

                @Override // com.baidu.live.im.k.a
                public void KU() {
                    if (d.this.gFD) {
                        d.this.mm(true);
                        d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.bTl().pageContext.getPageActivity(), d.this.bTl().gOM.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.gEU != null) {
                        d.this.gEU.KQ().setQuickInputPanelVisible(false);
                        d.this.gEU.KQ().Ml();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void KV() {
                    if (d.this.gFD) {
                        d.this.bSq();
                        if (d.this.gEV != null) {
                            d.this.gEV.Cm();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean KW() {
                    return d.this.bSE();
                }

                @Override // com.baidu.live.im.k.a
                public int KX() {
                    return d.this.bSF();
                }
            });
            this.gEd = new FrameLayout(bTl().pageContext.getPageActivity());
            this.gEd.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.gEU != null && this.gEd != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bTl().pageContext.getPageActivity()) * 0.7f);
            int i = com.baidu.live.ac.b.i(false, false);
            if (this.gFA.indexOfChild(this.gEd) < 0) {
                if (this.gEd.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gEd.getParent()).removeView(this.gEd);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.live.ac.b.c(false, false, false));
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.live.ac.b.cH(false);
                this.gFA.addView(this.gEd, layoutParams);
            }
            if (this.gEd.indexOfChild(this.gEU.KP().getView()) < 0) {
                if (this.gEU.KP().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gEU.KP().getView()).removeView(this.gEU.KP().getView());
                }
                this.gEd.addView(this.gEU.KP().getView(), new FrameLayout.LayoutParams(equipmentWidth, i));
            }
            if (bTl().gOO.indexOfChild(this.gEU.KQ().getView()) < 0) {
                if (this.gEU.KQ().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gEU.KQ().getView().getParent()).removeView(this.gEU.KQ().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bSL();
                bTl().gOO.addView(this.gEU.KQ().getView(), layoutParams2);
            }
            u Gm = bTl().gON.Gm();
            if (Gm != null && Gm.mLiveInfo != null) {
                this.gEU.setLogData(Gm.mLiveInfo.feed_id, LI());
            }
            this.gEU.b(String.valueOf(bTl().gON.Gm().mLiveInfo.group_id), String.valueOf(bTl().gON.Gm().mLiveInfo.last_msg_id), String.valueOf(bTl().gON.Gm().aHD.userId), String.valueOf(bTl().gON.Gm().mLiveInfo.live_id), bTl().gON.Gm().aHD.appId, (Gm == null || Gm.aIt == null || !Gm.aIt.DA()) ? false : true);
            mm(false);
        }
    }

    private void bRY() {
        if (this.gDR == null) {
            this.gDR = new com.baidu.tieba.ala.liveroom.p.a(bTl().pageContext, false, this);
        }
        this.gDR.d(this.gFz, bTl().gON.Gm());
        this.gDR.a(this.gEx);
        this.gDR.setOtherParams(LI());
    }

    private void bRZ() {
        if (this.gDQ == null) {
            this.gDQ = new com.baidu.tieba.ala.liveroom.audiencelist.c(bTl().pageContext, this, false);
        }
        this.gDQ.a(String.valueOf(bTl().gON.Gm().mLiveInfo.group_id), String.valueOf(bTl().gON.Gm().mLiveInfo.live_id), String.valueOf(bTl().gON.Gm().aHD.userId), bTl().gON.Gm());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.gEG != null && this.gEG.getView() != null && this.gEG.getView().getParent() != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.gDQ.c(this.gFz, i, a.g.ala_liveroom_audience_count_layout);
            this.gDQ.e(bTl().gON.bMo());
            this.gDQ.setOtherParams(LI());
        }
    }

    private void bSa() {
        com.baidu.live.core.a.a Mz;
        if (this.gEF == null) {
            this.gEF = new com.baidu.tieba.ala.liveroom.operation.a(bTl().pageContext);
        }
        this.gEF.a(bTl(), this.gFA, bTl().gON.Gm().mLiveInfo, true, this.gEx);
        this.gEF.setOtherParams(LI());
        if (this.gFe != null && (Mz = this.gFe.Mz()) != null) {
            View rootLayout = Mz.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.gEF.bX(rootLayout);
        }
    }

    public void mt(boolean z) {
        if (this.gEF != null) {
            this.gEF.mt(z);
        }
    }

    private void bSd() {
        if (this.gDU == null) {
            this.gDU = new com.baidu.tieba.ala.liveroom.audiencelist.b(bTl().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (bTl().gON.bMo() != null) {
            j = bTl().gON.bMo().getCount();
        }
        this.gDU.a(this.gEx);
        this.gDU.a(this.gFz, a.g.ala_liveroom_hostheader, j);
        this.gDU.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.gDU.mx(false);
        } else {
            this.gDU.mx(true);
        }
    }

    protected void Hc(String str) {
        if (this.gFN == null) {
            this.gFN = new com.baidu.tieba.ala.liveroom.u.b(bTl().pageContext);
        }
        this.gFN.b(this.gFA, str);
        mo(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.11
            @Override // java.lang.Runnable
            public void run() {
                d.this.gFN.cbt();
                d.this.mo(false);
            }
        }, 5000L);
    }

    private void mu(boolean z) {
        CustomResponsedMessage runTask;
        if (bTl().gON.Gm().mLiveInfo.live_type == 1 && this.gGC) {
            if (this.gGA == null && (runTask = MessageManager.getInstance().runTask(2913074, e.class, bTl().pageContext)) != null && runTask.getData() != null) {
                this.gGA = (e) runTask.getData();
            }
            if (this.gGA != null) {
                if (this.gDY == null) {
                    this.gDY = this.gGA.a(bTl().pageContext);
                }
                if (bTl().gON.Gm().mLiveInfo.challengeId > 0 && !this.gDY.Dc()) {
                    this.gDY.e(bTl().gON.Gm().mLiveInfo.live_id, bTl().gON.Gm().aHD.userId);
                    mv(z);
                    if (z) {
                        this.gDY.a(bTl().gON.cad());
                    }
                    this.gDY.c(bTl().gON.Gm());
                }
            }
        }
    }

    private void mv(boolean z) {
        if (this.gDZ == null) {
            this.gDZ = this.gGA.b(bTl().pageContext);
            this.gDZ.a(new com.baidu.live.challenge.g() { // from class: com.baidu.tieba.ala.liveroom.d.d.13
                @Override // com.baidu.live.challenge.g
                public void CR() {
                    d.this.bTl().gOO.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.g
                public void a(au auVar, ay ayVar, ay ayVar2) {
                    d.this.gGB = true;
                    if (d.this.gEM != null) {
                        d.this.gEM.setPraiseEnable(false);
                        d.this.bTl().gOO.hen = false;
                    }
                    if (d.this.gFp != null) {
                        d.this.gFp.setCanVisible(false);
                    }
                    if (d.this.gEN != null) {
                        d.this.gEN.cbE();
                    }
                    if (d.this.gDV != null) {
                        d.this.gDV.setCanVisible(false);
                        d.this.gDV.bWH();
                    }
                    if (d.this.gDW != null) {
                        d.this.gDW.mf(true);
                    }
                    if (d.this.gFO != null) {
                        d.this.gFO.setVisible(8);
                    }
                    if (d.this.gDX != null) {
                        d.this.gDX.setCanVisible(false);
                        d.this.gDX.setVisible(8);
                    }
                    d.this.bTy();
                    d.this.bTz();
                    d.this.bTA();
                    d.this.bTB();
                    d.this.bTC();
                    if (d.this.bTl().bkU != null) {
                        d.this.bTl().bkU.getLivePlayer().setBackgroundResource(a.d.sdk_transparent);
                    }
                    if (d.this.gEK != null) {
                        d.this.gEK.setTimeTextMode(true);
                    }
                    if (d.this.bkR != null && ayVar != null && ayVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(ayVar.aNb);
                        arrayList.add(ayVar2.aNb);
                        com.baidu.live.liveroom.a.c cVar = d.this.bkR;
                        if (d.this.gFK) {
                            arrayList = null;
                        }
                        cVar.o(arrayList);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void CS() {
                }

                @Override // com.baidu.live.challenge.g
                public void CT() {
                }

                @Override // com.baidu.live.challenge.g
                public void bg(boolean z2) {
                    d.this.bTl().gOO.setSwipeClearEnable(true);
                    d.this.gGB = false;
                    if (d.this.gEM != null) {
                        d.this.gEM.setPraiseEnable(true);
                        d.this.bTl().gOO.hen = true;
                    }
                    if (d.this.gFp != null) {
                        d.this.gFp.setCanVisible(true);
                    }
                    if (d.this.gEN != null) {
                        d.this.gEN.cbF();
                    }
                    if (d.this.gDV != null) {
                        d.this.gDV.setCanVisible(true);
                        d.this.gDV.y(d.this.bTl().gON.Gm());
                    }
                    if (d.this.gEP != null) {
                        d.this.gEP.nr(true);
                    }
                    if (d.this.gDW != null) {
                        d.this.gDW.mf(false);
                    }
                    if (d.this.gFO != null) {
                        d.this.gFO.setVisible(0);
                    }
                    if (d.this.gDX != null) {
                        d.this.gDX.setCanVisible(true);
                        d.this.gDX.setVisible(0);
                    }
                    d.this.bTy();
                    d.this.bTz();
                    d.this.bTA();
                    d.this.bTB();
                    d.this.bTC();
                    if (d.this.bkR != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.bTl().gON.caS());
                        com.baidu.live.liveroom.a.c cVar = d.this.bkR;
                        if (d.this.gFK) {
                            arrayList = null;
                        }
                        cVar.o(arrayList);
                    }
                    if (d.this.bTl().bkU != null) {
                        d.this.bTl().bkU.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
                    }
                    if (d.this.gEK != null) {
                        d.this.gEK.setTimeTextMode(false);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void bh(boolean z2) {
                    if (z2 && d.this.gFr != null) {
                        d.this.gFr.onClose();
                    }
                }
            });
        }
        this.gDZ.a(this.gDY);
        this.gDZ.m(bTl().gOM.getLiveContainerView());
        this.gDZ.b(z, false, false);
        this.gDY.a((i.c) this.gDZ);
    }

    public void bSe() {
        this.gEH.c(bTl().gON.Gm(), false);
    }

    public void bSf() {
        if (bTl().gON.Gm() != null && bTl().gON.Gm().aHD != null && bTl().gON.Gm().mLiveInfo != null) {
            if (this.gDT == null) {
                this.gDT = new com.baidu.tieba.ala.liveroom.v.b(bTl().pageContext);
            }
            long j = bTl().gON.Gm().aHD.userId;
            int i = bTl().gON.Gm().mLiveInfo.live_type;
            String str = bTl().gON.Gm().aHD.portrait;
            String str2 = bTl().gON.Gm().mLiveInfo.feed_id;
            long j2 = bTl().gON.Gm().mLiveInfo.live_id;
            this.gDT.a(i, j, bTl().gON.Gm().aHD.userName, false, str, LI(), str2, j2);
            this.gDT.av(this.gFz);
        }
    }

    private int bTE() {
        return (this.gDZ != null ? this.gDZ.bi(false) : 0) + bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    private void bSg() {
        boolean z = true;
        if (this.gEP == null) {
            this.gEP = new com.baidu.tieba.ala.liveroom.x.a(bTl().pageContext, this);
        }
        this.gEP.d(bTl().gOO, false);
        AlaLiveInfoData alaLiveInfoData = bTl().gON.Gm().mLiveInfo;
        if (alaLiveInfoData != null) {
            boolean z2 = bTk() && alaLiveInfoData.screen_direction != 2;
            boolean isZanAnimUnabled = alaLiveInfoData.mAlaLiveSwitchData != null ? alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled() : false;
            if (!z2 || isZanAnimUnabled) {
                z = false;
            }
            this.gEP.nq(z);
        }
    }

    private void bSi() {
        if (this.gFH || this.gFI) {
            if ((TbadkCoreApplication.isLogin() && this.gEU.KQ().hasText()) || this.gFI) {
                this.gFH = false;
                this.gFI = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.15
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bSK();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void bSb() {
        bSc();
    }

    private void bSc() {
        if (this.gEF != null) {
            int i = bTl().gON.Gm().aIf.isUegBlock;
            int i2 = bTl().gON.Gm().aIf.isBlock;
            String str = bTl().gON.Gm().aIf.userName;
            if (i > 0 || i2 > 0) {
                this.gEF.b(true, i, i2, str);
                this.gEU.a(true, i, i2, str);
                this.gFa.b(true, i, i2, str);
                return;
            }
            this.gEF.b(false, i, i2, str);
            this.gEU.a(false, i, i2, str);
            this.gFa.b(false, i, i2, str);
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
        if (this.gDW != null) {
            this.gDW.y(aVar);
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
                    if (this.gDV != null) {
                        this.gDV.J(jSONObject2);
                    }
                } else if ("enter_live".equals(optString)) {
                    if (this.gDU != null && this.gDU.getCount() > 20) {
                        this.gDU.dY(this.gDU.getCount() + 1);
                    } else if (this.gDQ != null) {
                        com.baidu.live.data.a Lt = aVar.Lt();
                        m mVar = new m();
                        mVar.aHE = new AlaLocationData();
                        mVar.aHF = new AlaRelationData();
                        mVar.aHD = new AlaLiveUserInfoData();
                        mVar.aHD.userId = JavaTypesHelper.toLong(Lt.userId, 0L);
                        mVar.aHD.userName = Lt.userName;
                        mVar.aHD.portrait = Lt.portrait;
                        if (this.gDU != null && this.gDQ.c(mVar)) {
                            this.gDU.dY(this.gDU.getCount() + 1);
                        }
                    }
                } else if ("update_liveinfo".equals(optString)) {
                    if (bTl().gON.Gm() != null && bTl().gON.Gm().mLiveInfo != null) {
                        bTl().gON.a(bTl().gON.Gm().mLiveInfo.live_id, bTl().fromType, bTl().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && bTl().gON.Gm() != null && bTl().gON.Gm().mLiveInfo != null && bTl().gON.Gm().aIf != null && this.gDZ != null) {
                    long optLong = jSONObject2.optLong("mvp_user_id");
                    long optLong2 = jSONObject2.optLong("winner_live_id");
                    if (optLong == bTl().gON.Gm().aIf.userId && optLong2 == bTl().gON.Gm().mLiveInfo.live_id) {
                        this.gDZ.d(jSONObject2.optInt("challenge_status"), jSONObject2.optLong("challenge_id"));
                    }
                }
            } else {
                return;
            }
        }
        if (this.gFp == null || this.gFp.M(jSONObject2)) {
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void GX(String str) {
        if (this.gDW != null) {
            this.gDW.GX(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void cg(boolean z) {
        super.cg(z);
        if (bTl().gOO != null) {
            bTl().gOO.ccp();
            bTl().gOO.setLiveViewOnDispatchTouchEventListener(null);
            bTl().gOO.setLiveViewOnTouchEventListener(null);
            bTl().gOO.setOnLiveViewScrollListener(null);
        }
        if (bTl().bkU != null) {
            bTl().bkU.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.gDZ != null) {
            this.gDZ.CN();
        }
        bSj();
        if (this.gDT != null) {
            this.gDT.CN();
        }
        if (this.gEP != null) {
            this.gEP.release();
        }
        if (this.gDV != null) {
            this.gDV.CN();
        }
        if (this.gEF != null) {
            this.gEF.caZ();
        }
        if (this.gDS != null) {
            this.gDS.bVC();
            this.gDS.setVisible(8);
        }
        if (this.gDX != null) {
            this.gDX.CN();
        }
        if (this.gDW != null) {
            this.gDW.release();
        }
        if (this.bot != null) {
            this.bot.removeAllViews();
            this.bot = null;
        }
        if (this.gGz != null) {
            this.gGz.removeAllViews();
            this.gGz = null;
        }
        if (this.gEP != null) {
            this.gEP.onDestroy();
        }
        if (this.gDY != null) {
            this.gDY.CN();
        }
        if (this.gDR != null) {
            this.gDR.bXH();
        }
        if (this.gEm != null) {
            this.gEm.cancel();
        }
        if (this.gFO != null) {
            this.gFO.bUw();
        }
        if (this.gFp != null) {
            this.gFp.JQ();
        }
        if (this.gEm != null) {
            this.gEm.CN();
        }
        if (this.gFv != null) {
            this.gFv.CN();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void ce(boolean z) {
        super.ce(z);
        bSj();
        if (this.gDR != null) {
            this.gDR.onDestroy();
        }
        if (this.gDT != null) {
            this.gDT.onDestroy();
        }
        if (this.gDV != null) {
            this.gDV.onDestroy();
        }
        if (this.gDX != null) {
            this.gDX.onDestroy();
        }
        if (this.gDY != null) {
            this.gDY.onDestroy();
        }
        if (this.gDZ != null) {
            this.gDZ.onDestroy();
        }
        if (this.gEa != null) {
            this.gEa.onDestroy();
        }
        if (this.gFc != null) {
            this.gFc.onDestroy();
        }
        if (this.gDS != null) {
            this.gDS.onDestroy();
        }
        if (this.gDQ != null) {
            this.gDQ.onDestroy();
        }
        if (this.gEU != null) {
            this.gEU.onDestroy();
        }
        if (this.gEF != null) {
            this.gEF.onDestory();
        }
        if (this.gDW != null) {
            this.gDW.release();
        }
        if (this.gFO != null) {
            this.gFO.ce(!z);
        }
        if (this.gEm != null) {
            this.gEm.onDestroy();
            this.gEm = null;
        }
        if (this.gFv != null) {
            this.gFv.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.gEn);
        MessageManager.getInstance().removeMessageRule(this.gEo);
        MessageManager.getInstance().unRegisterListener(this.gEr);
        MessageManager.getInstance().unRegisterListener(this.gEs);
        MessageManager.getInstance().unRegisterListener(this.gEu);
        MessageManager.getInstance().unRegisterListener(this.gEv);
        MessageManager.getInstance().unRegisterListener(this.gGD);
        MessageManager.getInstance().unRegisterListener(this.gEw);
        MessageManager.getInstance().unRegisterListener(this.gEt);
    }

    private void bSj() {
        if (this.gEU != null && this.gEU.KP().getView() != null && this.gEU.KP().getView().getParent() != null) {
            ((ViewGroup) this.gEU.KP().getView().getParent()).removeView(this.gEU.KP().getView());
        }
        if (this.gEd != null && this.gEd.getParent() != null) {
            ((ViewGroup) this.gEd.getParent()).removeView(this.gEd);
        }
        if (this.gEU != null && this.gEU.KQ().getView() != null) {
            this.gFA.removeView(this.gEU.KQ().getView());
        }
        if (this.gEU != null) {
            this.gEU.KP().setMsgData(new LinkedList());
            this.gEU.Cn();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void a(am amVar) {
        if (this.gEU != null) {
            bSK();
            this.gEU.KQ().setEditText(" @" + amVar.getNameShow() + " ");
        }
        if (this.gEF != null) {
            this.gEF.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void g(com.baidu.live.data.a aVar) {
        if (this.gEU != null) {
            bSK();
            this.gEU.KQ().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.gEF != null) {
            this.gEF.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void b(am amVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected View bSk() {
        if (this.gEU != null) {
            return this.gEU.KQ().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean bSl() {
        if (this.gEU == null || !this.gEU.KQ().Mk()) {
            return false;
        }
        mm(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected boolean bSm() {
        return this.gDR == null || this.gDR.bSm();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    /* renamed from: bTF */
    public PendantParentView bSn() {
        return this.bot;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected ViewGroup bSo() {
        return this.gGz;
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
                    this.gFE = false;
                    K(intExtra, intExtra2, intExtra3);
                    return;
                }
                bSe();
                return;
            }
            arx();
        } else if (i == 25051 && i2 == -1 && this.gFO != null) {
            this.gFO.bWy();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.gEU != null && this.gEU.KP() != null) {
            this.gEU.KP().onKeyboardVisibilityChanged(z);
        }
        if (z || this.gEU == null || this.gEU.KQ() == null || !this.gEU.KQ().Mk()) {
            if (z) {
                if (this.gEF != null) {
                    this.gEF.setVisibility(8);
                }
                if (this.gEW != null && this.gEW.FR() != null) {
                    this.gEW.FR().setVisibility(8);
                }
                bSq();
                if (this.gEU != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gEU.KQ().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.gEU.KQ().getView().setLayoutParams(layoutParams);
                    this.gEU.KQ().getView().setVisibility(0);
                    this.gEU.KQ().setQuickInputPanelVisible(false);
                }
                if (this.gFz != null) {
                    this.gFz.setVisibility(8);
                }
                if (this.gDW != null) {
                    this.gDW.setVisible(8);
                }
                if (this.gEV != null) {
                    this.gEV.Cm();
                }
                if (this.gFu != null) {
                    this.gFu.setCanVisible(false);
                }
                if (this.gFo != null) {
                    this.gFo.setCanVisible(false);
                }
                if (this.gFp != null) {
                    this.gFp.setCanVisible(false);
                }
            } else {
                bSp();
            }
            bTz();
            if (this.gFh != null) {
                this.gFh.bp(z);
            }
        }
    }

    private void bSp() {
        if (this.gEF != null) {
            this.gEF.setVisibility(0);
        }
        if (this.gEd != null) {
            if (this.gGF) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gEd.getLayoutParams();
                layoutParams.bottomMargin = (J(false, false) - bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) + com.baidu.live.ac.b.QN();
                this.gEd.setLayoutParams(layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gEd.getLayoutParams();
                layoutParams2.bottomMargin = bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
                this.gEd.setLayoutParams(layoutParams2);
            }
        }
        if (this.gEU != null) {
            bSL();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gEU.KQ().getView().getLayoutParams();
            layoutParams3.bottomMargin = 0;
            this.gEU.KQ().getView().setLayoutParams(layoutParams3);
        }
        if (this.gEF != null) {
            this.gEF.setVisibility(0);
        }
        if (this.gEW != null && this.gEW.FR() != null) {
            this.gEW.FR().setVisibility(0);
        }
        if (this.gFz != null) {
            this.gFz.setVisibility(0);
        }
        if (this.gDW != null) {
            this.gDW.setVisible(0);
        }
        if (this.gEV != null) {
            this.gEV.Cm();
        }
        if (this.gFu != null) {
            this.gFu.setCanVisible(true);
        }
        if (this.gFo != null) {
            this.gFo.setCanVisible(true);
        }
        if (this.gFp != null) {
            this.gFp.setCanVisible(!this.gGB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSq() {
        boolean z;
        boolean z2 = false;
        if (this.gEd != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gEd.getLayoutParams();
            if (this.gEU == null || this.gEU.KQ() == null) {
                z = false;
            } else {
                z = this.gEU.KQ().Mi();
                z2 = this.gEU.KQ().Mj();
            }
            int J = J(z, z2);
            if (layoutParams.bottomMargin != J) {
                layoutParams.bottomMargin = J;
                this.gEd.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mm(boolean z) {
        this.gGE = z;
        if (z) {
            this.gEU.KQ().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gEd.getLayoutParams();
            int quickInputPanelExpandHeight = this.gEU.KQ().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.gEd.setLayoutParams(layoutParams);
                if (this.gEU.KP() != null) {
                    this.gEU.KP().KO();
                    return;
                }
                return;
            }
            return;
        }
        bSp();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.gDQ != null) {
                this.gDQ.dI(i3);
            }
            if (this.gDS != null) {
                this.gDS.dI(i3);
            }
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public boolean eL(int i) {
        boolean eL = super.eL(i);
        if (eL && 2 == i) {
            if (this.gDR.bSm()) {
                return false;
            }
            if (eL && this.gEP != null) {
                this.gEP.nr(false);
            }
        }
        return eL;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void uO(int i) {
        super.uO(i);
        if (i == 7 || i == 11) {
            if (this.gEF != null) {
                this.gEF.setVisibility(8);
            }
            if (this.gEU != null) {
                this.gEU.KP().getView().setVisibility(4);
            }
            if (this.gDW != null) {
                this.gDW.bI(2, 8);
                if (this.gGB) {
                    this.gDW.bI(1, 8);
                }
            }
            if (this.gFk != null) {
                this.gFk.nm(false);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public void eM(int i) {
        super.eM(i);
        if (i == 7 || i == 11) {
            if (this.gEF != null) {
                this.gEF.setVisibility(0);
            }
            if (this.gEU != null) {
                this.gEU.KP().getView().setVisibility(0);
            }
            if (this.gDW != null) {
                this.gDW.setVisible(0);
            }
            if (this.gFk != null) {
                this.gFk.nm(true);
            }
            this.gFz.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.gDT != null) {
            this.gDT.cbv();
        }
        if (this.gDY != null) {
            this.gDY.CV();
        }
        if (this.gDW != null) {
            this.gDW.onStop();
        }
        if (this.gDX != null) {
            this.gDX.bf(true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.gDT != null) {
            this.gDT.cbu();
        }
        if (this.gDY != null && this.gGC) {
            this.gDY.CW();
        }
        if (this.gDW != null) {
            this.gDW.onStart();
        }
        if (this.gDX != null) {
            this.gDX.bf(false);
        }
    }
}
