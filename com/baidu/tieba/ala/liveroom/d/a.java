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
import com.baidu.live.challenge.h;
import com.baidu.live.challenge.i;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.am;
import com.baidu.live.data.bj;
import com.baidu.live.data.bw;
import com.baidu.live.data.cc;
import com.baidu.live.data.m;
import com.baidu.live.data.s;
import com.baidu.live.data.u;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.ad;
import com.baidu.live.gift.n;
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
import com.baidu.live.utils.q;
import com.baidu.tieba.ala.liveroom.exclusive.e;
import com.baidu.tieba.ala.liveroom.j.b;
import com.baidu.tieba.ala.liveroom.j.g;
import com.baidu.tieba.ala.liveroom.m.a;
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.turntable.d;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends b implements com.baidu.live.j.c, e {
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
    private com.baidu.live.im.b.a gEb;
    private com.baidu.tieba.ala.liveroom.share.b gEc;
    private FrameLayout gEd;
    private FrameLayout gEe;
    private ImageView gEf;
    private com.baidu.live.tieba.e.b gEg;
    private aa gEl;
    private com.baidu.tieba.ala.liveroom.j.b gEm;
    private long lastClickTime = 0;
    private boolean gEh = false;
    private boolean gEi = false;
    private boolean gEj = false;
    private Handler gEk = new Handler();
    private HttpRule gEn = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.gDY != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.gDY.Db()) {
                httpMessage.addParam("ala_challenge_id", a.this.gDY.De());
            }
            return httpMessage;
        }
    };
    private HttpRule gEo = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.a.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.gDY != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.gDY.Db()) {
                httpMessage.addParam("challenge_id", a.this.gDY.De());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c gEp = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.19
        @Override // com.baidu.live.liveroom.g.c
        public void Nh() {
            if (a.this.gEP != null) {
                a.this.gEP.nr(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void ch(boolean z) {
            if (z) {
                if (a.this.gEP != null) {
                    a.this.gEP.nr(true);
                }
            } else if (a.this.gEP != null) {
                a.this.gEP.nr(false);
            }
            if (a.this.gFh != null) {
                a.this.gFh.bq(z);
            }
            if (a.this.gDW != null) {
                a.this.gDW.mh(z ? false : true);
            }
            com.baidu.live.m.a.ci(z);
        }
    };
    private com.baidu.tieba.ala.liveroom.p.c gEq = new com.baidu.tieba.ala.liveroom.p.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.20
        @Override // com.baidu.tieba.ala.liveroom.p.c
        public void onClick() {
            a.this.gEk.removeCallbacksAndMessages(null);
            a.this.gEh = true;
        }

        @Override // com.baidu.tieba.ala.liveroom.p.c
        public void endAnimation() {
            if (a.this.gEh) {
                a.this.bRG();
            }
        }
    };
    private HttpMessageListener gEr = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Nq() != null) {
                        com.baidu.live.x.c.OX().bqR = getQuickGiftHttpResponseMessage.Nq();
                        a.this.bRV();
                    }
                }
            }
        }
    };
    private CustomMessageListener gEs = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                a.this.gEX.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gEt = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.gFl != null) {
                    a.this.gFl.hE(str);
                }
            }
        }
    };
    CustomMessageListener gEu = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.gFG != null && a.this.gFG.bdN != null && !a.this.gFG.bdQ && !a.this.gFG.bdR && a.this.gFg != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.bTl().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = a.this.bTl().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                a.this.gFg.c(a.this.gEd, layoutParams);
                if (com.baidu.live.guardclub.e.JL() != null) {
                    com.baidu.live.guardclub.e.JL().JR();
                }
            }
        }
    };
    private CustomMessageListener gEv = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (a.this.gFi != null) {
                    a.this.gFi.dismiss();
                }
                if (a.this.gFl != null) {
                    a.this.gFl.dismiss();
                }
                if (a.this.gFj != null) {
                    a.this.gFj.dismiss();
                }
                if (a.this.gFw != null) {
                    a.this.gFw.dismiss();
                }
                com.baidu.live.im.b.d.Lm().setSwitchStatus(true);
                com.baidu.live.im.b.d.Lm().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bSK();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener gEw = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.gEm.c(a.this.bTl());
                } else if (a.this.bSD() || !g.vb(2913168)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.bTl().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.bTl().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    a.this.gEm.c(a.this.gEd, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gEx = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.a.13
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
            if (currentTimeMillis - a.this.lastClickTime >= 300) {
                a.this.lastClickTime = currentTimeMillis;
                if (i == 2 && a.this.IS()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel"));
                    a.this.K(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.x.c.OX().bqR.Ga().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.x.c.OX().bqR.Ga().Fd());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.x.c.OX().bqR.Ga().Fe());
                        if (a.this.bTl().gON.Gm() != null && a.this.bTl().gON.Gm().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.bTl().gON.Gm().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.bTl().gON.Gm().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.LI());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.IS()) {
                        if (com.baidu.live.c.AZ().getBoolean("quick_gift_guide_show", true) && !a.this.bSD()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, aa.class, a.this.bTl().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                aa aaVar = (aa) runTask.getData();
                                aaVar.setPageContext(a.this.bTl().pageContext);
                                aaVar.d(a.this.bTl().gON.Gm());
                                aaVar.setGiftItem(com.baidu.live.x.c.OX().bqR.Ga());
                                aaVar.setOtherParams(a.this.LI());
                                aaVar.initView();
                                aaVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.13.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        a.this.mo(false);
                                        a.this.gEl = null;
                                    }
                                });
                                a.this.gEl = aaVar;
                                aaVar.show();
                                a.this.mo(true);
                                return;
                            }
                            return;
                        }
                        n.a(a.this.bTl().pageContext, a.this.bTl().gON.Gm(), com.baidu.live.x.c.OX().bqR.Ga(), a.this.LI());
                    }
                } else if (i == 1) {
                    if (a.this.gEU != null) {
                        a.this.bSK();
                    }
                } else if (i == 3 && a.this.IS()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    if (a.this.mOrientation == 2 && (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                        if (a.this.gEc != null) {
                            a.this.gEc.E(a.this.bTl().gON.Gm());
                        }
                    } else {
                        a.this.gEH.c(a.this.bTl().gON.Gm(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.bTl() != null && a.this.bTl().gON != null && a.this.bTl().gON.Gm() != null && a.this.bTl().gON.Gm().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.bTl().gON.Gm().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.bTl().gON.Gm().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.bTl().gON.Gm().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.LI());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.bTl() != null && a.this.bTl().gON != null && a.this.bTl().gON.Gm() != null && a.this.bTl().gON.Gm().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.bTl().gON.Gm().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.bTl().gON.Gm().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.bTl().gON.Gm().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.LI());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.bkR != null) {
                        a.this.bkR.cb(false);
                    }
                } else if (i == 12) {
                    if (a.this.gEP != null) {
                        String valueOf = String.valueOf(a.this.bTl().gON.Gm().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.bTl().gON.Gm().mLiveInfo.room_id);
                        String str3 = null;
                        s sVar = a.this.bTl().gON.Gm().mLiveSdkInfo;
                        if (sVar != null && sVar.mCastIds != null) {
                            str3 = String.valueOf(a.this.bTl().gON.Gm().mLiveSdkInfo.mCastIds.aHY);
                        }
                        a.this.gEP.ak(valueOf, valueOf2, str3);
                        com.baidu.live.m.a.b(a.this.bTl().gON.Gm().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    u Gm = a.this.bTl().gON.Gm();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.bTl().pageContext.getPageActivity(), Gm.aHD.userName, Long.toString(Gm.aHD.userId), Long.toString(Gm.aHD.charmCount), String.valueOf(Gm.mLiveInfo.group_id), String.valueOf(Gm.mLiveInfo.live_id), false, String.valueOf(Gm.aHD.userId), Long.toString(Gm.aIf.userId), Gm.aIf.userName, Gm.aIf.portrait, a.this.gDU.getCount(), a.this.LI())));
                    LogManager.getCommonLogger().doClickGusetNumLog(Gm.mLiveInfo.feed_id, a.this.gDU.getCount() + "", a.this.LI());
                } else if (i == 11) {
                    a.this.bSN();
                    a.this.bSO();
                } else if (i == 16) {
                    if (a.this.bTl() != null && (bjVar2 = com.baidu.live.x.a.OS().bqJ) != null && (bwVar2 = bjVar2.aNV) != null) {
                        String str4 = bwVar2.aPg.aPn;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (a.this.bTl().gON != null && a.this.bTl().gON.Gm() != null && a.this.bTl().gON.Gm().mLiveInfo != null) {
                                j = a.this.bTl().gON.Gm().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", a.this.bTl().gON.Gm().mLiveInfo.room_id + "", a.this.bTl().gON.Gm().mLiveInfo.feed_id, a.this.LI());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.bTl().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (a.this.bTl() != null) {
                        u uVar = null;
                        if (a.this.bTl().gON != null) {
                            uVar = a.this.bTl().gON.Gm();
                        }
                        if (uVar != null && uVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.w.b.cbG().blx != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.w.b.cbG().blx.aHf;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + uVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + uVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(a.this.bTl().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17) {
                    if (a.this.IS() && a.this.bTl() != null && (bjVar = com.baidu.live.x.a.OS().bqJ) != null && (bwVar = bjVar.aNV) != null && (ccVar = bwVar.aPh) != null && !TextUtils.isEmpty(ccVar.webUrl)) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                        if (a.this.gFi != null && a.this.bTl().gON != null && a.this.bTl().gON.Gm() != null) {
                            u Gm2 = a.this.bTl().gON.Gm();
                            a.this.gFi.a(ccVar.webUrl, Gm2.mLiveInfo.live_id, Gm2.aIf.userId, Gm2.aHD.userId);
                            a.this.gEg.cx(false);
                            a.this.gEg.PR();
                        }
                    }
                } else if (i == 18) {
                    if (a.this.gEj) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.gEj = !a.this.gEj;
                } else if (i == 19 && a.this.gEg != null) {
                    a.this.gEg.PR();
                }
            }
        }
    };

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
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRG() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.21
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gEi) {
                    a.this.mk(false);
                }
            }
        }, 5000L);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void n(u uVar) {
        super.n(uVar);
        g.bWD();
        this.gEj = false;
        if (this.gEM != null) {
            this.gEM.b(this.gEx);
        }
        if (this.gEg == null) {
            this.gEg = new com.baidu.live.tieba.e.b(bTl().pageContext.getPageActivity());
            this.gEg.start();
        }
        this.gEg.cx(true);
        bTl().pageContext.getPageActivity().setRequestedOrientation(-1);
        bTl().gOO.setIsForceHandledTouch(false);
        bTl().gOO.setSwipeClearEnable(true);
        bTl().gOO.setOnLiveViewScrollListener(this.gEp);
        bTl().gOO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gEk.removeCallbacksAndMessages(null);
                a.this.gEh = false;
                a.this.mk(false);
                if (!a.this.gEi) {
                    a.this.bRG();
                }
            }
        });
        if (this.gFz != null) {
            this.gFz.setVisibility(0);
        }
        bRM();
        if (this.gFe != null) {
            this.gFe.a(uVar, this.bot);
            this.gFe.U(this.gFA);
            this.gFe.a(this);
        }
        bRY();
        bSy();
        bRZ();
        bRL();
        bSd();
        bSa();
        bRH();
        mp(false);
        bSR();
        bSQ();
        bRP();
        bRW();
        bRX();
        bSS();
        bRJ();
        bSf();
        bSg();
        mq(true);
        bRO();
        bRV();
        bTd();
        bRQ();
        bRR();
        bRS();
        bRT();
        bSh();
        bSZ();
        bRI();
        bTc();
        if (this.gFi != null && this.gFi.cbN() == null) {
            this.gFi.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.23
                @Override // com.baidu.tieba.ala.liveroom.turntable.d.a
                public void onDismiss() {
                    a.this.gEg.cx(true);
                }
            });
        }
        if (this.gFj != null && this.gFj.bWI() == null) {
            this.gFj.a(new a.InterfaceC0649a() { // from class: com.baidu.tieba.ala.liveroom.d.a.24
                @Override // com.baidu.tieba.ala.liveroom.m.a.InterfaceC0649a
                public void onDismiss() {
                    a.this.gEg.cx(true);
                }
            });
        }
        c(this.fMS);
        MessageManager.getInstance().registerListener(this.gEr);
        MessageManager.getInstance().registerListener(this.gEu);
        MessageManager.getInstance().registerListener(this.gEv);
        MessageManager.getInstance().registerListener(this.gEw);
        MessageManager.getInstance().registerListener(this.gEt);
        MessageManager.getInstance().registerListener(this.gEs);
        bSi();
        bSc();
        if (this.mOrientation == 2) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(bTl().pageContext.getPageActivity());
            l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(bTl().pageContext.getPageActivity()));
        }
        if (this.gFs != null) {
            this.gFs.x(uVar);
        }
    }

    private void bRH() {
        if (this.gFs == null) {
            View view = null;
            if (this.gEM != null && this.gEM.getView() != null) {
                view = this.gEM.getView();
            }
            this.gFs = new com.baidu.tieba.ala.liveroom.exclusive.b(bTl().pageContext, Nd(), bTl().gOO, view, this.gDQ.gGW, this);
        }
    }

    private void bRI() {
        if (this.gFr != null) {
            this.gFr.a(new com.baidu.live.t.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.25
                @Override // com.baidu.live.t.c
                public void co(boolean z) {
                    if (a.this.gDZ != null) {
                        a.this.gDZ.setNeedCloseRecommendFloat(z);
                    }
                    if (a.this.bTl().gOO.hen) {
                        if (a.this.gEP != null) {
                            a.this.gEP.nk(z);
                            a.this.gEP.nr(!z);
                        }
                        if (a.this.gEM != null) {
                            a.this.gEM.nk(z);
                            a.this.gEM.setPraiseEnable(!z);
                            a.this.gEM.nj(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mk(boolean z) {
        View Gl;
        if (bTl() != null && bTl().pageContext != null && bTl().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(bTl().pageContext.getPageActivity()) == 2 || z) {
                if (this.gEX != null && (Gl = this.gEX.Gl()) != null) {
                    if (this.gEi) {
                        Gl.setVisibility(0);
                    } else {
                        Gl.setVisibility(8);
                    }
                }
                if (this.gEi) {
                    if (this.gFz != null) {
                        this.gFz.setVisibility(0);
                    }
                    if (this.gFA != null) {
                        this.gFA.setVisibility(0);
                    }
                    if (this.bot != null) {
                        this.bot.setVisibility(0);
                    }
                    if (this.bot != null) {
                        this.bot.setVisibility(0);
                    }
                    if (this.gEW != null) {
                        this.gEW.bo(false);
                    }
                } else {
                    if (this.gFz != null) {
                        this.gFz.setVisibility(8);
                    }
                    if (this.gFA != null) {
                        this.gFA.setVisibility(8);
                    }
                    if (this.bot != null) {
                        this.bot.setVisibility(8);
                    }
                    if (this.bot != null) {
                        this.bot.setVisibility(8);
                    }
                    if (this.gEW != null) {
                        this.gEW.bo(true);
                    }
                }
                this.gEi = this.gEi ? false : true;
                if (this.gDW != null) {
                    this.gDW.mh(this.gEi);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, boolean z2) {
        ImageView imageView;
        View FR;
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view;
        }
        if (z) {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_off);
            }
            if (this.gEe != null) {
                this.gEe.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_on);
            }
            if (this.gEe != null) {
                this.gEe.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.gEW != null && (FR = this.gEW.FR()) != null) {
            if (z) {
                FR.setVisibility(8);
            } else {
                FR.setVisibility(0);
            }
        }
    }

    private void bRJ() {
        CustomResponsedMessage runTask;
        if (this.gEb == null && (runTask = MessageManager.getInstance().runTask(2913164, com.baidu.live.im.b.a.class, bTl().pageContext)) != null) {
            this.gEb = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gEb != null) {
            this.gEb.setOtherParams(this.otherParams);
            this.gEb.a(new a.InterfaceC0185a() { // from class: com.baidu.tieba.ala.liveroom.d.a.2
                @Override // com.baidu.live.im.b.a.InterfaceC0185a
                public void Ll() {
                    a.this.bSX();
                }
            });
        }
    }

    private void bRK() {
        if (this.gEO != null) {
            this.gEO.az(bTl().gOM.getLiveContainerView());
        }
    }

    private void bRL() {
        if (this.gEc == null) {
            this.gEc = new com.baidu.tieba.ala.liveroom.share.b(bTl().pageContext);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void dM(int i) {
        super.dM(i);
        if (this.gEf != null && UtilHelper.getRealScreenOrientation(bTl().pageContext.getPageActivity()) != 2) {
            this.gEf.setVisibility(0);
        }
        bRK();
        if (this.gDZ != null) {
            this.gDZ.dM(i);
        }
        if (this.gDZ == null || !this.gDZ.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
        if (this.gFs != null) {
            this.gFs.bWb();
        }
    }

    private void bRM() {
        if (this.bot == null) {
            PendantParentView.Model model = PendantParentView.Model.HORIZONTAL;
            if (this.mOrientation == 2) {
                model = PendantParentView.Model.HORIZONTAL_FULL;
            }
            this.bot = new PendantParentView(bTl().pageContext.getPageActivity(), model);
            bTl().gOO.addView(this.bot, ((bTl().gOO.getView() == null || this.gEM == null || this.gEM.getView() == null) ? -1 : bTl().gOO.getView().indexOfChild(this.gEM.getView())) + 1, new RelativeLayout.LayoutParams(-1, bRN()));
            this.bot.setDefaultItemMargin(bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            K(this.mOrientation, false);
        }
    }

    private int bRN() {
        int bottom;
        int bottom2;
        if (bTl().bkU.getLivePlayer().getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bTl().bkU.getLivePlayer().getLayoutParams();
            bottom = layoutParams.topMargin + layoutParams.height;
        } else {
            bottom = bTl().bkU.getLivePlayer().getBottom();
        }
        if (bTl().gOO.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) bTl().gOO.getLayoutParams();
            bottom2 = layoutParams2.topMargin + layoutParams2.height;
        } else {
            bottom2 = bTl().gOO.getBottom();
        }
        int i = 0;
        if (this.gFs != null) {
            i = this.gFs.getHeight();
        }
        return (((bottom2 - bottom) - i) - bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
    }

    private void bRO() {
        if (this.gDW == null) {
            this.gDW = new com.baidu.tieba.ala.liveroom.activeview.b(bTl().pageContext);
        }
        if (bTl() != null && bTl().gON != null) {
            this.gDW.GV(bTl().gON.caW());
        }
        this.gDW.setOtherParams(LI());
        this.gDW.b(bTl().gON.Gm(), true);
        this.gDW.setHost(false);
        this.gDW.a(1, this.bot);
        this.gDW.a(2, this.bot);
        this.gDW.setVisible(this.gFD ? 8 : 0);
    }

    private void bRP() {
        if (this.gEL != null && bTl() != null && bTl().gON != null) {
            this.gEL.c(bTl().gOM.getLiveContainerView(), bTl().gON.Gm());
        }
    }

    private void bRQ() {
        if (this.bot != null) {
            if (this.gDV == null) {
                this.gDV = new com.baidu.tieba.ala.liveroom.l.a(bTl().pageContext, this);
            }
            this.gDV.setOtherParams(LI());
            this.gDV.a((ViewGroup) this.bot, bRU());
            this.gDV.y(bTl().gON.Gm());
        }
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
            this.gEF.a(new a.InterfaceC0652a() { // from class: com.baidu.tieba.ala.liveroom.d.a.9
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0652a
                public void bK(int i, int i2) {
                    u Gm = a.this.bTl().gON.Gm();
                    if (Gm != null && Gm.mLiveInfo != null) {
                        if (a.this.gFk == null) {
                            a.this.gFk = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.bTl().pageContext.getPageActivity());
                        }
                        a.this.gFk.d(a.this.gFA, i, i2);
                        a.this.gFk.a(String.valueOf(Gm.mLiveInfo.live_id), new a.InterfaceC0656a() { // from class: com.baidu.tieba.ala.liveroom.d.a.9.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0656a
                            public void a(float f, String str) {
                                if (a.this.gEF != null) {
                                    a.this.gEF.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0652a
                public void bL(int i, int i2) {
                    if (a.this.gFk != null) {
                        a.this.gFk.bQ(i, i2);
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
            this.gEm = new com.baidu.tieba.ala.liveroom.j.b(bTl().pageContext, LI(), this.gFO, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.10
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bSr() {
                    a.this.mo(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bSs() {
                    a.this.mo(false);
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
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = bTl().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRV() {
        if (this.gEF == null) {
            bSa();
        }
        this.gEF.a(com.baidu.live.x.c.OX().bqR, bTl().gON.Gm());
    }

    private void bRW() {
        CustomResponsedMessage runTask;
        boolean z = true;
        if (this.gEU == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, bTl().pageContext)) != null && runTask.getData() != null) {
            this.gEU = (k) runTask.getData();
            this.gEU.setFromMaster(false);
            this.gEU.KP().getView().setId(a.g.ala_liveroom_msg_list);
            this.gEU.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.11
                @Override // com.baidu.live.im.k.a
                public boolean KS() {
                    return a.this.IS();
                }

                @Override // com.baidu.live.im.k.a
                public void KT() {
                    a.this.gFH = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hu(String str) {
                    if (!a.this.gFD) {
                        a.this.mm(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.bTl().pageContext.getPageActivity(), a.this.bTl().gOM.getLiveContainerView());
                    }
                    a.this.Hb(str);
                }

                @Override // com.baidu.live.im.k.a
                public void KU() {
                    if (a.this.gFD) {
                        a.this.mm(true);
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.bTl().pageContext.getPageActivity(), a.this.bTl().gOM.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (a.this.gEU != null) {
                        a.this.gEU.KQ().setQuickInputPanelVisible(false);
                        a.this.gEU.KQ().Ml();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void KV() {
                    if (a.this.gFD) {
                        a.this.bSq();
                        if (a.this.gEV != null) {
                            a.this.gEV.Cm();
                        }
                        if (a.this.gEb != null) {
                            a.this.gEb.Cm();
                        }
                    } else if (a.this.gEU != null) {
                        a.this.gEU.KQ().setQuickInputPanelVisible(false);
                        a.this.gEU.KQ().Ml();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean KW() {
                    return a.this.bSE();
                }

                @Override // com.baidu.live.im.k.a
                public int KX() {
                    return a.this.bSF();
                }
            });
            this.gEd = new FrameLayout(bTl().pageContext.getPageActivity());
            this.gEd.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.gEU != null && this.gEd != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bTl().pageContext.getPageActivity()) * 0.7f);
            int i = com.baidu.live.ac.b.i(true, false);
            if (this.gFA.indexOfChild(this.gEd) < 0) {
                if (this.gEd.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gEd.getParent()).removeView(this.gEd);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                this.gFA.addView(this.gEd, layoutParams);
            }
            if (this.gEd.indexOfChild(this.gEU.KP().getView()) < 0) {
                if (this.gEU.KP().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gEU.KP().getView()).removeView(this.gEU.KP().getView());
                }
                if (UtilHelper.getRealScreenOrientation(bTl().pageContext.getPageActivity()) != 2) {
                    this.gEd.addView(this.gEU.KP().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, i));
                }
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
            if (Gm == null || Gm.aIt == null || !Gm.aIt.DA()) {
                z = false;
            }
            this.gEU.b(String.valueOf(bTl().gON.Gm().mLiveInfo.group_id), String.valueOf(bTl().gON.Gm().mLiveInfo.last_msg_id), String.valueOf(bTl().gON.Gm().aHD.userId), String.valueOf(bTl().gON.Gm().mLiveInfo.live_id), bTl().gON.Gm().aHD.appId, z);
            mm(false);
        }
    }

    private void bRX() {
        if (this.gEe == null) {
            this.gEe = new FrameLayout(bTl().pageContext.getPageActivity());
            this.gEe.setId(a.g.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void bRY() {
        if (this.gDR == null) {
            this.gDR = new com.baidu.tieba.ala.liveroom.p.a(bTl().pageContext, false, this);
        }
        this.gDR.d(this.gFz, bTl().gON.Gm());
        this.gDR.a(this.gEq);
        this.gDR.a(this.gEx);
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

    private void bSg() {
        boolean z = false;
        if (this.gEP == null) {
            this.gEP = new com.baidu.tieba.ala.liveroom.x.a(bTl().pageContext, this);
        }
        this.gEP.d(bTl().gOO, false);
        boolean bTk = bTk();
        AlaLiveInfoData alaLiveInfoData = bTl().gON.Gm().mLiveInfo;
        boolean isZanAnimUnabled = (alaLiveInfoData == null || alaLiveInfoData.mAlaLiveSwitchData == null) ? false : alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled();
        if (bTk && !isZanAnimUnabled) {
            z = true;
        }
        this.gEP.nq(z);
    }

    private void bSh() {
        if (bTl() != null && bTl().bkU != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(bTl().pageContext.getPageActivity());
            Activity pageActivity = bTl().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + pageActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds176)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.gEf = new ImageView(bTl().pageContext.getPageActivity());
            this.gEf.setVisibility(8);
            this.gEf.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.gEf.setImageResource(a.f.icon_live_enlarge);
            this.gEf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.gEg != null) {
                        a.this.gEg.PQ();
                        a.this.gEf.setVisibility(4);
                    }
                }
            });
            bTl().gOO.addView(this.gEf, layoutParams);
            if (UtilHelper.getRealScreenOrientation(bTl().pageContext.getPageActivity()) != 2) {
                if (bTl().gOT) {
                    this.gEf.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.15
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.gEf != null && UtilHelper.getRealScreenOrientation(a.this.bTl().pageContext.getPageActivity()) != 2) {
                                a.this.gEf.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
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
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.16
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bSK();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void r(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
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
            e.printStackTrace();
            jSONObject = null;
        }
        if ((aVar.getMsgType() == 12 || aVar.getMsgType() == 13) && jSONObject != null) {
            String optString = jSONObject.optString("content_type");
            if ("task".equals(optString)) {
                if (this.gDV != null) {
                    this.gDV.J(jSONObject);
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
                long optLong = jSONObject.optLong("mvp_user_id");
                long optLong2 = jSONObject.optLong("winner_live_id");
                if (optLong == bTl().gON.Gm().aIf.userId && optLong2 == bTl().gON.Gm().mLiveInfo.live_id) {
                    this.gDZ.d(jSONObject.optInt("challenge_status"), jSONObject.optLong("challenge_id"));
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void GX(String str) {
        if (this.gDW != null) {
            this.gDW.GX(str);
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
        if (this.gEb != null) {
            this.gEb.a(uVar);
        }
        if (this.gDW != null) {
            this.gDW.k(uVar);
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
        if (this.gDY != null) {
            this.gDY.CN();
        }
        if (this.gEb != null) {
            this.gEb.a((a.InterfaceC0185a) null);
            this.gEb.Cn();
        }
        if (this.gDR != null) {
            this.gDR.bXH();
        }
        if (this.gEf != null && (this.gEf.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gEf.getParent()).removeView(this.gEf);
        }
        if (this.gEc != null) {
            this.gEc.dismiss();
        }
        if (this.gEg != null) {
            this.gEg.cx(false);
            this.gEg.PR();
        }
        if (this.gEm != null) {
            this.gEm.CN();
        }
        if (this.gFO != null) {
            this.gFO.bUw();
        }
        if (this.gFv != null) {
            this.gFv.CN();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void o(u uVar) {
        View Cl;
        super.o(uVar);
        if (this.gEb != null && (Cl = this.gEb.Cl()) != null && Cl.getParent() != null) {
            ((ViewGroup) Cl.getParent()).removeView(Cl);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.gEb != null) {
            this.gEb.setOtherParams(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void ce(boolean z) {
        super.ce(z);
        this.gEk.removeCallbacksAndMessages(null);
        bSj();
        this.gEi = false;
        this.gEj = false;
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
        if (this.gEc != null) {
            this.gEc.onDestroy();
        }
        if (this.gDS != null) {
            this.gDS.onDestroy();
        }
        if (this.gEg != null) {
            this.gEg.stop();
        }
        if (this.gEP != null) {
            this.gEP.onDestroy();
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
        if (this.gEb != null) {
            this.gEb.a((a.InterfaceC0185a) null);
            this.gEb.release();
            this.gEb = null;
        }
        if (this.gFO != null) {
            this.gFO.ce(z ? false : true);
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
        MessageManager.getInstance().unRegisterListener(this.gEu);
        MessageManager.getInstance().unRegisterListener(this.gEv);
        MessageManager.getInstance().unRegisterListener(this.gEw);
        MessageManager.getInstance().unRegisterListener(this.gEt);
        MessageManager.getInstance().unRegisterListener(this.gEs);
    }

    private void bSj() {
        if (this.gEU != null && this.gEU.KP().getView() != null && this.gEU.KP().getView().getParent() != null) {
            ((ViewGroup) this.gEU.KP().getView().getParent()).removeView(this.gEU.KP().getView());
        }
        if (this.gEd != null && this.gEd.getParent() != null) {
            ((ViewGroup) this.gEd.getParent()).removeView(this.gEd);
        }
        if (this.gEe != null && this.gEe.getParent() != null) {
            ((ViewGroup) this.gEe.getParent()).removeView(this.gEe);
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

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected ViewGroup bSn() {
        return this.bot;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected ViewGroup bSo() {
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
                    this.gFE = false;
                    K(intExtra, intExtra2, intExtra3);
                    return;
                }
                bSe();
                return;
            }
            arx();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.gFD;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(bTl().pageContext.getPageActivity()) || z2) {
            ml(z);
        }
    }

    private void ml(boolean z) {
        if (this.gEU != null && this.gEU.KP() != null) {
            this.gEU.KP().onKeyboardVisibilityChanged(z);
        }
        if (z || this.gEU == null || !this.gEU.KQ().Mk()) {
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
            } else {
                bSp();
            }
            if (this.gEU != null && this.gEd != null) {
                if (this.gFA.indexOfChild(this.gEd) != -1 && this.gEd.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gEd.getLayoutParams();
                    layoutParams2.height = com.baidu.live.ac.b.i(true, z);
                    this.gEd.setLayoutParams(layoutParams2);
                }
                if (this.gEd.indexOfChild(this.gEU.KP().getView()) != -1 && this.gEU.KP().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.gEU.KP().getView().getLayoutParams();
                    layoutParams3.height = com.baidu.live.ac.b.i(true, z);
                    this.gEU.KP().getView().setLayoutParams(layoutParams3);
                }
                this.gEU.KP().KO();
            }
        }
    }

    private void bSp() {
        if (this.gEF != null) {
            this.gEF.setVisibility(0);
        }
        if (this.gEd != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gEd.getLayoutParams();
            layoutParams.bottomMargin = bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            this.gEd.setLayoutParams(layoutParams);
        }
        if (this.gEU != null) {
            bSL();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gEU.KQ().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.gEU.KQ().getView().setLayoutParams(layoutParams2);
        }
        if (this.gEF != null) {
            this.gEF.setVisibility(0);
        }
        if (this.gEW != null && this.gEW.FR() != null) {
            this.gEW.FR().setVisibility(0);
        }
        if (this.gFz != null && (!this.gEi || UtilHelper.getRealScreenOrientation(bTl().pageContext.getPageActivity()) != 2)) {
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
        FrameLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        FrameLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = bTl().pageContext.getPageActivity();
        if (i3 == 1) {
            if (bTl().pageContext.getPageActivity() != null && !UtilHelper.canUseStyleImmersiveSticky()) {
                q.e(bTl().pageContext.getPageActivity(), true);
            }
            if (this.gFz != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.gFz.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.gEc != null) {
                this.gEc.dismiss();
            }
            if (this.gEb != null) {
                this.gEb.a((a.InterfaceC0185a) null);
                this.gEb.Cn();
            }
            if (this.bkR != null) {
                this.bkR.e(true, true);
            }
            if (this.gEf != null) {
                this.gEf.setVisibility(0);
                this.gEf.bringToFront();
            }
            if (this.gEK != null) {
                this.gEK.setVisibility(0);
            }
            if (this.gEU != null && this.gEU.KP().getView().getParent() != null && (this.gEU.KP().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gEU.KP().getView().getParent()).removeView(this.gEU.KP().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bTl().pageContext.getPageActivity()) * 0.7f);
            int i4 = com.baidu.live.ac.b.i(true, false);
            if (this.gEd != null && this.gEU != null) {
                this.gEd.addView(this.gEU.KP().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, i4));
            }
            if (this.gEe != null && (this.gEe.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gEe.getParent()).removeView(this.gEe);
            }
            if (this.gEV != null) {
                this.gEV.a(bTl().gON.Gm(), false);
                this.gEV.a(new a.InterfaceC0185a() { // from class: com.baidu.tieba.ala.liveroom.d.a.17
                    @Override // com.baidu.live.im.b.a.InterfaceC0185a
                    public void Ll() {
                        a.this.bSX();
                    }
                });
                View Cl = this.gEV.Cl();
                if (Cl != null && this.gFA != null && Cl.getParent() == null) {
                    Resources resources = bTl().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bTl().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds98));
                    layoutParams5.addRule(2, a.g.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                    this.gFA.addView(Cl, layoutParams5);
                }
            }
            if (this.gEM != null) {
                this.gEM.setPraiseEnable(true);
                bTl().gOO.hen = true;
            }
            if (this.gDQ != null && this.gDQ.gGX != null && (layoutParams3 = (FrameLayout.LayoutParams) this.gDQ.gGX.getLayoutParams()) != null) {
                layoutParams3.width = -2;
                this.gDQ.gGX.setLayoutParams(layoutParams3);
            }
            if (this.gEP != null) {
                this.gEP.ccO();
            }
            if (this.gEi) {
                mk(true);
            }
            if (this.gEj) {
                if (this.gEF != null && this.gEF.getLandscapeBarrageImageView() != null) {
                    b(this.gEF.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.gEF != null) {
                this.gEF.vA(0);
            }
            if (this.gDU != null) {
                this.gDU.mw(true);
            }
            this.gEk.removeCallbacksAndMessages(null);
            if (this.gDV != null) {
                this.gDV.setCanVisible(true);
                this.gDV.y(bTl().gON.Gm());
            }
        } else if (i3 == 2) {
            if (bTl().pageContext.getPageActivity() != null && !UtilHelper.canUseStyleImmersiveSticky()) {
                q.e(bTl().pageContext.getPageActivity(), false);
            }
            if (this.gEP != null) {
                this.gEP.ccP();
            }
            if (this.gFz != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.gFz.getLayoutParams()) != null) {
                layoutParams2.topMargin = bTl().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
            }
            if (this.gEV != null) {
                this.gEV.a((a.InterfaceC0185a) null);
                this.gEV.Cn();
            }
            bTl().gOO.ccr();
            if (this.bkR != null) {
                this.bkR.e(false, true);
            }
            if (this.gEf != null) {
                this.gEf.setVisibility(4);
            }
            if (this.gEU != null && this.gEU.KP().getView().getParent() != null && (this.gEU.KP().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gEU.KP().getView().getParent()).removeView(this.gEU.KP().getView());
            }
            int max = Math.max(i, i2);
            if (this.gEe != null) {
                if (this.gEe.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gEe.getParent()).removeView(this.gEe);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
                bTl().gOO.addView(this.gEe, this.bot != null ? bTl().gOO.indexOfChild(this.bot) : -1, layoutParams6);
            }
            if (this.gEe != null && this.gEb != null) {
                this.gEb.a(bTl().gON.Gm(), false);
                this.gEb.a(new a.InterfaceC0185a() { // from class: com.baidu.tieba.ala.liveroom.d.a.18
                    @Override // com.baidu.live.im.b.a.InterfaceC0185a
                    public void Ll() {
                        a.this.bSX();
                    }
                });
                View Cl2 = this.gEb.Cl();
                if (Cl2 != null && this.gEe.indexOfChild(Cl2) < 0) {
                    this.gEe.addView(Cl2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bTl().pageContext.getPageActivity()), -1));
                }
            }
            if (this.gEM != null) {
                this.gEM.aC(bTl().gOO);
                this.gEM.setPraiseEnable(false);
                bTl().gOO.hen = false;
            }
            if (this.gDQ != null && this.gDQ.gGX != null && (layoutParams = (FrameLayout.LayoutParams) this.gDQ.gGX.getLayoutParams()) != null) {
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                layoutParams.width = (int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f);
                this.gDQ.gGX.setLayoutParams(layoutParams);
            }
            if (this.gEF != null) {
                this.gEF.vA(8);
            }
            if (this.gDU != null) {
                this.gDU.mw(false);
            }
            if (ad.GA() != null) {
                ad.GA().Gz();
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.z.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.z.c) runTask.getData()).Gz();
            }
            if (this.gEF != null && this.gEF.getLandscapeBarrageImageView() != null) {
                b(this.gEF.getLandscapeBarrageImageView(), this.gEj, false);
            }
            bRG();
            if (this.gEW != null) {
                this.gEW.FT();
            }
            if (this.gDV != null) {
                this.gDV.setCanVisible(false);
                this.gDV.bWH();
            }
        }
        if (this.gEX != null) {
            if (i3 == 2) {
                View Gl = this.gEX.Gl();
                if (Gl != null) {
                    if (Gl.getParent() != null && (Gl.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) Gl.getParent()).removeView(Gl);
                    }
                    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams7.addRule(5, a.g.ala_liveroom_hostheader);
                    layoutParams7.addRule(3, a.g.ala_liveroom_hostheader);
                    layoutParams7.topMargin = bTl().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                    if (this.gFz != null) {
                        this.gFz.addView(Gl, layoutParams7);
                    }
                }
            } else {
                View Gl2 = this.gEX.Gl();
                if (Gl2 != null) {
                    if (Gl2.getParent() != null && (Gl2.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) Gl2.getParent()).removeView(Gl2);
                    }
                    RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams8.topMargin = bTl().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18) * (-1);
                    layoutParams8.addRule(3, a.g.ala_live_header_view);
                    bTl().gOO.addView(Gl2, layoutParams8);
                }
            }
        }
        if (this.gEF != null) {
            this.gEF.l(i, i2, i3);
        }
        K(i3, true);
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.gDQ != null) {
                this.gDQ.dI(i3);
            }
            if (this.gDS != null) {
                this.gDS.dI(i3);
            }
            if (this.gDW != null) {
                this.gDW.dI(i3);
            }
            if (this.gFe != null) {
                this.gFe.dI(i3);
            }
            if (this.gFa != null) {
                this.gFa.dI(i3);
            }
            if (this.gFi != null) {
                this.gFi.dI(i3);
            }
            if (this.gFl != null) {
                this.gFl.dI(i3);
            }
            if (this.gFj != null) {
                this.gFj.dI(i3);
            }
            if (this.gFw != null) {
                this.gFw.dI(i3);
            }
            if (this.gEl != null && this.gEl.isShowing()) {
                this.gEl.resize();
            }
            if (this.gFu != null) {
                this.gFu.dI(i3);
            }
            if (this.gFv != null) {
                this.gFv.dI(i3);
            }
            if (this.gFs != null) {
                this.gFs.eZ(i3);
            }
        }
        if (this.gEW != null) {
            this.gEW.FS();
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
            if (i != 7 || UtilHelper.getRealScreenOrientation(bTl().pageContext.getPageActivity()) != 2) {
                if (this.gEF != null) {
                    this.gEF.setVisibility(8);
                }
                if (this.gEU != null) {
                    this.gEU.KP().getView().setVisibility(4);
                }
                if (this.gFk != null) {
                    this.gFk.nm(false);
                }
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
            if (this.gFk != null) {
                this.gFk.nm(true);
            }
            if (!this.gEi || UtilHelper.getRealScreenOrientation(bTl().pageContext.getPageActivity()) != 2) {
                this.gFz.setVisibility(0);
            }
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
        if (bTl() != null) {
            BdUtilHelper.hideSoftKeyPad(bTl().pageContext.getPageActivity(), bTl().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.gDT != null) {
            this.gDT.cbu();
        }
        if (this.gDY != null) {
            this.gDY.CW();
        }
        if (this.gDW != null) {
            this.gDW.onStart();
        }
        if (this.gFs != null) {
            this.gFs.onStart();
        }
    }

    private void K(int i, boolean z) {
        if (this.bot != null) {
            int dimensionPixelSize = bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bot.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                layoutParams.rightMargin = bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.height = bRN();
                this.bot.setPosition(dimensionPixelSize, 0, dimensionPixelSize, 0);
                if (z) {
                    this.gEL.mj(true);
                }
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                int dimensionPixelSize2 = bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds72) + 0 + bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100) + bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
                layoutParams.height = -1;
                this.bot.setPosition(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
                this.gEL.mj(false);
            }
            layoutParams.bottomMargin = bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            this.bot.setLayoutParams(layoutParams);
            this.bot.setModel(i == 1 ? PendantParentView.Model.HORIZONTAL : PendantParentView.Model.HORIZONTAL_FULL);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.e
    public void uP(int i) {
        K(this.mOrientation, false);
    }
}
