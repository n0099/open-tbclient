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
    private PendantParentView bkG;
    private com.baidu.tieba.ala.liveroom.v.b gpA;
    private com.baidu.tieba.ala.liveroom.audiencelist.b gpB;
    private com.baidu.tieba.ala.liveroom.l.a gpC;
    private com.baidu.tieba.ala.liveroom.activeview.b gpD;
    private com.baidu.live.d.a gpE;
    private i gpF;
    private h gpG;
    private com.baidu.tieba.ala.liveroom.c.a gpH;
    private com.baidu.live.im.b.a gpI;
    private com.baidu.tieba.ala.liveroom.share.b gpJ;
    private FrameLayout gpK;
    private FrameLayout gpL;
    private ImageView gpM;
    private com.baidu.live.tieba.e.b gpN;
    private aa gpS;
    private com.baidu.tieba.ala.liveroom.j.b gpT;
    private com.baidu.tieba.ala.liveroom.audiencelist.c gpx;
    private com.baidu.tieba.ala.liveroom.p.a gpy;
    private com.baidu.tieba.ala.liveroom.g.b gpz;
    private long lastClickTime = 0;
    private boolean gpO = false;
    private boolean gpP = false;
    private boolean gpQ = false;
    private Handler gpR = new Handler();
    private HttpRule gpU = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.gpF != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.gpF.Ce()) {
                httpMessage.addParam("ala_challenge_id", a.this.gpF.Ch());
            }
            return httpMessage;
        }
    };
    private HttpRule gpV = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.a.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.gpF != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.gpF.Ce()) {
                httpMessage.addParam("challenge_id", a.this.gpF.Ch());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c gpW = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.19
        @Override // com.baidu.live.liveroom.g.c
        public void Mc() {
            if (a.this.gqw != null) {
                a.this.gqw.mO(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void ce(boolean z) {
            if (z) {
                if (a.this.gqw != null) {
                    a.this.gqw.mO(true);
                }
            } else if (a.this.gqw != null) {
                a.this.gqw.mO(false);
            }
            if (a.this.gqO != null) {
                a.this.gqO.bm(z);
            }
            if (a.this.gpD != null) {
                a.this.gpD.lF(z ? false : true);
            }
            com.baidu.live.m.a.cf(z);
        }
    };
    private com.baidu.tieba.ala.liveroom.p.c gpX = new com.baidu.tieba.ala.liveroom.p.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.20
        @Override // com.baidu.tieba.ala.liveroom.p.c
        public void onClick() {
            a.this.gpR.removeCallbacksAndMessages(null);
            a.this.gpO = true;
        }

        @Override // com.baidu.tieba.ala.liveroom.p.c
        public void endAnimation() {
            if (a.this.gpO) {
                a.this.bOp();
            }
        }
    };
    private HttpMessageListener gpY = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Ml() != null) {
                        com.baidu.live.x.c.NS().bne = getQuickGiftHttpResponseMessage.Ml();
                        a.this.bOE();
                    }
                }
            }
        }
    };
    private CustomMessageListener gpZ = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                a.this.gqE.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gqa = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.gqS != null) {
                    a.this.gqS.hn(str);
                }
            }
        }
    };
    CustomMessageListener gqb = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.grl != null && a.this.grl.bat != null && !a.this.grl.baw && !a.this.grl.bax && a.this.gqN != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.bPS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = a.this.bPS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                a.this.gqN.c(a.this.gpK, layoutParams);
                if (com.baidu.live.guardclub.e.IO() != null) {
                    com.baidu.live.guardclub.e.IO().IU();
                }
            }
        }
    };
    private CustomMessageListener gqc = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (a.this.gqP != null) {
                    a.this.gqP.dismiss();
                }
                if (a.this.gqS != null) {
                    a.this.gqS.dismiss();
                }
                if (a.this.gqQ != null) {
                    a.this.gqQ.dismiss();
                }
                if (a.this.grd != null) {
                    a.this.grd.dismiss();
                }
                com.baidu.live.im.b.d.Kh().setSwitchStatus(true);
                com.baidu.live.im.b.d.Kh().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bPs();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener gqd = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.gpT.c(a.this.bPS());
                } else if (a.this.bPl() || !g.uw(2913168)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.bPS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.bPS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    a.this.gpT.c(a.this.gpK, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gqe = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.a.13
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
            if (currentTimeMillis - a.this.lastClickTime >= 300) {
                a.this.lastClickTime = currentTimeMillis;
                if (i == 2 && a.this.HV()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel"));
                    a.this.K(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.x.c.NS().bne.Fe().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.x.c.NS().bne.Fe().Eh());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.x.c.NS().bne.Fe().Ei());
                        if (a.this.bPS().gAu.Fq() != null && a.this.bPS().gAu.Fq().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.bPS().gAu.Fq().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.bPS().gAu.Fq().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.KD());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.HV()) {
                        if (com.baidu.live.c.AR().getBoolean("quick_gift_guide_show", true) && !a.this.bPl()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, aa.class, a.this.bPS().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                aa aaVar = (aa) runTask.getData();
                                aaVar.setPageContext(a.this.bPS().pageContext);
                                aaVar.d(a.this.bPS().gAu.Fq());
                                aaVar.setGiftItem(com.baidu.live.x.c.NS().bne.Fe());
                                aaVar.setOtherParams(a.this.KD());
                                aaVar.initView();
                                aaVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.13.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        a.this.lM(false);
                                        a.this.gpS = null;
                                    }
                                });
                                a.this.gpS = aaVar;
                                aaVar.show();
                                a.this.lM(true);
                                return;
                            }
                            return;
                        }
                        n.a(a.this.bPS().pageContext, a.this.bPS().gAu.Fq(), com.baidu.live.x.c.NS().bne.Fe(), a.this.KD());
                    }
                } else if (i == 1) {
                    if (a.this.gqB != null) {
                        a.this.bPs();
                    }
                } else if (i == 3 && a.this.HV()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    if (a.this.mOrientation == 2 && TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.gpJ != null) {
                            a.this.gpJ.D(a.this.bPS().gAu.Fq());
                        }
                    } else {
                        a.this.gqo.c(a.this.bPS().gAu.Fq(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.bPS() != null && a.this.bPS().gAu != null && a.this.bPS().gAu.Fq() != null && a.this.bPS().gAu.Fq().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.bPS().gAu.Fq().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.bPS().gAu.Fq().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.bPS().gAu.Fq().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.KD());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.bPS() != null && a.this.bPS().gAu != null && a.this.bPS().gAu.Fq() != null && a.this.bPS().gAu.Fq().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.bPS().gAu.Fq().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.bPS().gAu.Fq().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.bPS().gAu.Fq().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.KD());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.bhb != null) {
                        a.this.bhb.bY(false);
                    }
                } else if (i == 12) {
                    if (a.this.gqw != null) {
                        String valueOf = String.valueOf(a.this.bPS().gAu.Fq().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.bPS().gAu.Fq().mLiveInfo.room_id);
                        String str3 = null;
                        s sVar = a.this.bPS().gAu.Fq().mLiveSdkInfo;
                        if (sVar != null && sVar.mCastIds != null) {
                            str3 = String.valueOf(a.this.bPS().gAu.Fq().mLiveSdkInfo.mCastIds.aEU);
                        }
                        a.this.gqw.ai(valueOf, valueOf2, str3);
                        com.baidu.live.m.a.b(a.this.bPS().gAu.Fq().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    u Fq = a.this.bPS().gAu.Fq();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.bPS().pageContext.getPageActivity(), Fq.aEz.userName, Long.toString(Fq.aEz.userId), Long.toString(Fq.aEz.charmCount), String.valueOf(Fq.mLiveInfo.group_id), String.valueOf(Fq.mLiveInfo.live_id), false, String.valueOf(Fq.aEz.userId), Long.toString(Fq.aFb.userId), Fq.aFb.userName, Fq.aFb.portrait, a.this.gpB.getCount(), a.this.KD())));
                    LogManager.getCommonLogger().doClickGusetNumLog(Fq.mLiveInfo.feed_id, a.this.gpB.getCount() + "", a.this.KD());
                } else if (i == 11) {
                    a.this.bPv();
                    a.this.bPw();
                } else if (i == 16) {
                    if (a.this.bPS() != null && (bjVar2 = com.baidu.live.x.a.NN().bmW) != null && (bwVar2 = bjVar2.aKQ) != null) {
                        String str4 = bwVar2.aMb.aMi;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (a.this.bPS().gAu != null && a.this.bPS().gAu.Fq() != null && a.this.bPS().gAu.Fq().mLiveInfo != null) {
                                j = a.this.bPS().gAu.Fq().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", a.this.bPS().gAu.Fq().mLiveInfo.room_id + "", a.this.bPS().gAu.Fq().mLiveInfo.feed_id, a.this.KD());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.bPS().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (a.this.bPS() != null) {
                        u uVar = null;
                        if (a.this.bPS().gAu != null) {
                            uVar = a.this.bPS().gAu.Fq();
                        }
                        if (uVar != null && uVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.w.b.bYg().bhH != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.w.b.bYg().bhH.aEb;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + uVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + uVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(a.this.bPS().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17) {
                    if (a.this.HV() && a.this.bPS() != null && (bjVar = com.baidu.live.x.a.NN().bmW) != null && (bwVar = bjVar.aKQ) != null && (ccVar = bwVar.aMc) != null && !TextUtils.isEmpty(ccVar.webUrl)) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                        if (a.this.gqP != null && a.this.bPS().gAu != null && a.this.bPS().gAu.Fq() != null) {
                            u Fq2 = a.this.bPS().gAu.Fq();
                            a.this.gqP.a(ccVar.webUrl, Fq2.mLiveInfo.live_id, Fq2.aFb.userId, Fq2.aEz.userId);
                            a.this.gpN.cu(false);
                            a.this.gpN.OM();
                        }
                    }
                } else if (i == 18) {
                    if (a.this.gpQ) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.gpQ = !a.this.gpQ;
                } else if (i == 19 && a.this.gpN != null) {
                    a.this.gpN.OM();
                }
            }
        }
    };

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
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOp() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.21
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gpP) {
                    a.this.lI(false);
                }
            }
        }, 5000L);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void n(u uVar) {
        super.n(uVar);
        g.bTk();
        this.gpQ = false;
        if (this.gqt != null) {
            this.gqt.b(this.gqe);
        }
        if (this.gpN == null) {
            this.gpN = new com.baidu.live.tieba.e.b(bPS().pageContext.getPageActivity());
            this.gpN.start();
        }
        this.gpN.cu(true);
        bPS().pageContext.getPageActivity().setRequestedOrientation(-1);
        bPS().gAv.setIsForceHandledTouch(false);
        bPS().gAv.setSwipeClearEnable(true);
        bPS().gAv.setOnLiveViewScrollListener(this.gpW);
        bPS().gAv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gpR.removeCallbacksAndMessages(null);
                a.this.gpO = false;
                a.this.lI(false);
                if (!a.this.gpP) {
                    a.this.bOp();
                }
            }
        });
        if (this.gre != null) {
            this.gre.setVisibility(0);
        }
        bOv();
        if (this.gqL != null) {
            this.gqL.a(uVar, this.bkG);
            this.gqL.U(this.grf);
            this.gqL.a(this);
        }
        bOH();
        bPh();
        bOI();
        bOu();
        bOM();
        bOJ();
        bOq();
        lN(false);
        bPz();
        bPy();
        bOy();
        bOF();
        bOG();
        bPA();
        bOs();
        bOO();
        bOP();
        lO(true);
        bOx();
        bOE();
        bPK();
        bOz();
        bOA();
        bOB();
        bOC();
        bOQ();
        bPG();
        bOr();
        bPJ();
        if (this.gqP != null && this.gqP.bYn() == null) {
            this.gqP.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.23
                @Override // com.baidu.tieba.ala.liveroom.turntable.d.a
                public void onDismiss() {
                    a.this.gpN.cu(true);
                }
            });
        }
        if (this.gqQ != null && this.gqQ.bTp() == null) {
            this.gqQ.a(new a.InterfaceC0631a() { // from class: com.baidu.tieba.ala.liveroom.d.a.24
                @Override // com.baidu.tieba.ala.liveroom.m.a.InterfaceC0631a
                public void onDismiss() {
                    a.this.gpN.cu(true);
                }
            });
        }
        c(this.fAJ);
        MessageManager.getInstance().registerListener(this.gpY);
        MessageManager.getInstance().registerListener(this.gqb);
        MessageManager.getInstance().registerListener(this.gqc);
        MessageManager.getInstance().registerListener(this.gqd);
        MessageManager.getInstance().registerListener(this.gqa);
        MessageManager.getInstance().registerListener(this.gpZ);
        bOR();
        bOL();
        if (this.mOrientation == 2) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(bPS().pageContext.getPageActivity());
            l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(bPS().pageContext.getPageActivity()));
        }
        if (this.gqZ != null) {
            this.gqZ.w(uVar);
        }
    }

    private void bOq() {
        if (this.gqZ == null) {
            View view = null;
            if (this.gqt != null && this.gqt.getView() != null) {
                view = this.gqt.getView();
            }
            this.gqZ = new com.baidu.tieba.ala.liveroom.exclusive.b(bPS().pageContext, LY(), bPS().gAv, view, this.gpx.gsB, this);
        }
    }

    private void bOr() {
        if (this.gqY != null) {
            this.gqY.a(new com.baidu.live.t.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.25
                @Override // com.baidu.live.t.c
                public void cl(boolean z) {
                    if (a.this.gpG != null) {
                        a.this.gpG.setNeedCloseRecommendFloat(z);
                    }
                    if (a.this.bPS().gAv.gPq) {
                        if (a.this.gqw != null) {
                            a.this.gqw.mH(z);
                            a.this.gqw.mO(!z);
                        }
                        if (a.this.gqt != null) {
                            a.this.gqt.mH(z);
                            a.this.gqt.setPraiseEnable(!z);
                            a.this.gqt.mG(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lI(boolean z) {
        View Fp;
        if (bPS() != null && bPS().pageContext != null && bPS().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(bPS().pageContext.getPageActivity()) == 2 || z) {
                if (this.gqE != null && (Fp = this.gqE.Fp()) != null) {
                    if (this.gpP) {
                        Fp.setVisibility(0);
                    } else {
                        Fp.setVisibility(8);
                    }
                }
                if (this.gpP) {
                    if (this.gre != null) {
                        this.gre.setVisibility(0);
                    }
                    if (this.grf != null) {
                        this.grf.setVisibility(0);
                    }
                    if (this.bkG != null) {
                        this.bkG.setVisibility(0);
                    }
                    if (this.bkG != null) {
                        this.bkG.setVisibility(0);
                    }
                    if (this.gqD != null) {
                        this.gqD.bk(false);
                    }
                } else {
                    if (this.gre != null) {
                        this.gre.setVisibility(8);
                    }
                    if (this.grf != null) {
                        this.grf.setVisibility(8);
                    }
                    if (this.bkG != null) {
                        this.bkG.setVisibility(8);
                    }
                    if (this.bkG != null) {
                        this.bkG.setVisibility(8);
                    }
                    if (this.gqD != null) {
                        this.gqD.bk(true);
                    }
                }
                this.gpP = this.gpP ? false : true;
                if (this.gpD != null) {
                    this.gpD.lF(this.gpP);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, boolean z2) {
        ImageView imageView;
        View EV;
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view;
        }
        if (z) {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_off);
            }
            if (this.gpL != null) {
                this.gpL.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_on);
            }
            if (this.gpL != null) {
                this.gpL.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.gqD != null && (EV = this.gqD.EV()) != null) {
            if (z) {
                EV.setVisibility(8);
            } else {
                EV.setVisibility(0);
            }
        }
    }

    private void bOs() {
        CustomResponsedMessage runTask;
        if (this.gpI == null && (runTask = MessageManager.getInstance().runTask(2913164, com.baidu.live.im.b.a.class, bPS().pageContext)) != null) {
            this.gpI = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gpI != null) {
            this.gpI.setOtherParams(this.otherParams);
            this.gpI.a(new a.InterfaceC0177a() { // from class: com.baidu.tieba.ala.liveroom.d.a.2
                @Override // com.baidu.live.im.b.a.InterfaceC0177a
                public void Kg() {
                    a.this.bPE();
                }
            });
        }
    }

    private void bOt() {
        if (this.gqv != null) {
            this.gqv.ax(bPS().gAt.getLiveContainerView());
        }
    }

    private void bOu() {
        if (this.gpJ == null) {
            this.gpJ = new com.baidu.tieba.ala.liveroom.share.b(bPS().pageContext);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void dH(int i) {
        super.dH(i);
        if (this.gpM != null && UtilHelper.getRealScreenOrientation(bPS().pageContext.getPageActivity()) != 2) {
            this.gpM.setVisibility(0);
        }
        bOt();
        if (this.gpG != null) {
            this.gpG.dH(i);
        }
        if (this.gpG == null || !this.gpG.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
        if (this.gqZ != null) {
            this.gqZ.bSI();
        }
    }

    private void bOv() {
        if (this.bkG == null) {
            PendantParentView.Model model = PendantParentView.Model.HORIZONTAL;
            if (this.mOrientation == 2) {
                model = PendantParentView.Model.HORIZONTAL_FULL;
            }
            this.bkG = new PendantParentView(bPS().pageContext.getPageActivity(), model);
            bPS().gAv.addView(this.bkG, ((bPS().gAv.getView() == null || this.gqt == null || this.gqt.getView() == null) ? -1 : bPS().gAv.getView().indexOfChild(this.gqt.getView())) + 1, new RelativeLayout.LayoutParams(-1, bOw()));
            this.bkG.setDefaultItemMargin(bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            I(this.mOrientation, false);
        }
    }

    private int bOw() {
        int bottom;
        int bottom2;
        if (bPS().bhe.getLivePlayer().getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bPS().bhe.getLivePlayer().getLayoutParams();
            bottom = layoutParams.topMargin + layoutParams.height;
        } else {
            bottom = bPS().bhe.getLivePlayer().getBottom();
        }
        if (bPS().gAv.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) bPS().gAv.getLayoutParams();
            bottom2 = layoutParams2.topMargin + layoutParams2.height;
        } else {
            bottom2 = bPS().gAv.getBottom();
        }
        int i = 0;
        if (this.gqZ != null) {
            i = this.gqZ.getHeight();
        }
        return (((bottom2 - bottom) - i) - bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
    }

    private void bOx() {
        if (this.gpD == null) {
            this.gpD = new com.baidu.tieba.ala.liveroom.activeview.b(bPS().pageContext);
        }
        if (bPS() != null && bPS().gAu != null) {
            this.gpD.Gj(bPS().gAu.bXB());
        }
        this.gpD.setOtherParams(KD());
        this.gpD.b(bPS().gAu.Fq(), true);
        this.gpD.setHost(false);
        this.gpD.a(1, this.bkG);
        this.gpD.a(2, this.bkG);
        this.gpD.setVisible(this.gri ? 8 : 0);
    }

    private void bOy() {
        if (this.gqs != null && bPS() != null && bPS().gAu != null) {
            this.gqs.c(bPS().gAt.getLiveContainerView(), bPS().gAu.Fq());
        }
    }

    private void bOz() {
        if (this.bkG != null) {
            if (this.gpC == null) {
                this.gpC = new com.baidu.tieba.ala.liveroom.l.a(bPS().pageContext, this);
            }
            this.gpC.setOtherParams(KD());
            this.gpC.a((ViewGroup) this.bkG, bOD());
            this.gpC.x(bPS().gAu.Fq());
        }
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
            this.gqm.a(new a.InterfaceC0634a() { // from class: com.baidu.tieba.ala.liveroom.d.a.9
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0634a
                public void bK(int i, int i2) {
                    u Fq = a.this.bPS().gAu.Fq();
                    if (Fq != null && Fq.mLiveInfo != null) {
                        if (a.this.gqR == null) {
                            a.this.gqR = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.bPS().pageContext.getPageActivity());
                        }
                        a.this.gqR.d(a.this.grf, i, i2);
                        a.this.gqR.a(String.valueOf(Fq.mLiveInfo.live_id), new a.InterfaceC0638a() { // from class: com.baidu.tieba.ala.liveroom.d.a.9.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0638a
                            public void a(float f, String str) {
                                if (a.this.gqm != null) {
                                    a.this.gqm.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0634a
                public void bL(int i, int i2) {
                    if (a.this.gqR != null) {
                        a.this.gqR.bQ(i, i2);
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
            this.gpT = new com.baidu.tieba.ala.liveroom.j.b(bPS().pageContext, KD(), this.grt, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.10
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bPa() {
                    a.this.lM(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bPb() {
                    a.this.lM(false);
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
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = bPS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOE() {
        if (this.gqm == null) {
            bOJ();
        }
        this.gqm.a(com.baidu.live.x.c.NS().bne, bPS().gAu.Fq());
    }

    private void bOF() {
        CustomResponsedMessage runTask;
        boolean z = true;
        if (this.gqB == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, bPS().pageContext)) != null && runTask.getData() != null) {
            this.gqB = (k) runTask.getData();
            this.gqB.setFromMaster(false);
            this.gqB.JJ().getView().setId(a.g.ala_liveroom_msg_list);
            this.gqB.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.11
                @Override // com.baidu.live.im.k.a
                public boolean JM() {
                    return a.this.HV();
                }

                @Override // com.baidu.live.im.k.a
                public void JN() {
                    a.this.grm = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hd(String str) {
                    if (!a.this.gri) {
                        a.this.lK(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.bPS().pageContext.getPageActivity(), a.this.bPS().gAt.getLiveContainerView());
                    }
                    a.this.Gp(str);
                }

                @Override // com.baidu.live.im.k.a
                public void JO() {
                    if (a.this.gri) {
                        a.this.lK(true);
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.bPS().pageContext.getPageActivity(), a.this.bPS().gAt.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (a.this.gqB != null) {
                        a.this.gqB.JK().setQuickInputPanelVisible(false);
                        a.this.gqB.JK().Lg();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void JP() {
                    if (a.this.gri) {
                        a.this.bOZ();
                        if (a.this.gqC != null) {
                            a.this.gqC.Bp();
                        }
                        if (a.this.gpI != null) {
                            a.this.gpI.Bp();
                        }
                    } else if (a.this.gqB != null) {
                        a.this.gqB.JK().setQuickInputPanelVisible(false);
                        a.this.gqB.JK().Lg();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean JQ() {
                    return a.this.bPm();
                }

                @Override // com.baidu.live.im.k.a
                public int JR() {
                    return a.this.bPn();
                }
            });
            this.gpK = new FrameLayout(bPS().pageContext.getPageActivity());
            this.gpK.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.gqB != null && this.gpK != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bPS().pageContext.getPageActivity()) * 0.7f);
            int i = com.baidu.live.ac.b.i(true, false);
            if (this.grf.indexOfChild(this.gpK) < 0) {
                if (this.gpK.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gpK.getParent()).removeView(this.gpK);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                this.grf.addView(this.gpK, layoutParams);
            }
            if (this.gpK.indexOfChild(this.gqB.JJ().getView()) < 0) {
                if (this.gqB.JJ().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gqB.JJ().getView()).removeView(this.gqB.JJ().getView());
                }
                if (UtilHelper.getRealScreenOrientation(bPS().pageContext.getPageActivity()) != 2) {
                    this.gpK.addView(this.gqB.JJ().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, i));
                }
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
            if (Fq == null || Fq.aFp == null || !Fq.aFp.CD()) {
                z = false;
            }
            this.gqB.a(String.valueOf(bPS().gAu.Fq().mLiveInfo.group_id), String.valueOf(bPS().gAu.Fq().mLiveInfo.last_msg_id), String.valueOf(bPS().gAu.Fq().aEz.userId), String.valueOf(bPS().gAu.Fq().mLiveInfo.live_id), bPS().gAu.Fq().aEz.appId, z);
            lK(false);
        }
    }

    private void bOG() {
        if (this.gpL == null) {
            this.gpL = new FrameLayout(bPS().pageContext.getPageActivity());
            this.gpL.setId(a.g.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void bOH() {
        if (this.gpy == null) {
            this.gpy = new com.baidu.tieba.ala.liveroom.p.a(bPS().pageContext, false, this);
        }
        this.gpy.d(this.gre, bPS().gAu.Fq());
        this.gpy.a(this.gpX);
        this.gpy.a(this.gqe);
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

    private void bOP() {
        boolean z = false;
        if (this.gqw == null) {
            this.gqw = new com.baidu.tieba.ala.liveroom.x.a(bPS().pageContext, this);
        }
        this.gqw.d(bPS().gAv, false);
        boolean bPR = bPR();
        AlaLiveInfoData alaLiveInfoData = bPS().gAu.Fq().mLiveInfo;
        boolean isZanAnimUnabled = (alaLiveInfoData == null || alaLiveInfoData.mAlaLiveSwitchData == null) ? false : alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled();
        if (bPR && !isZanAnimUnabled) {
            z = true;
        }
        this.gqw.mN(z);
    }

    private void bOQ() {
        if (bPS() != null && bPS().bhe != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(bPS().pageContext.getPageActivity());
            Activity pageActivity = bPS().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + pageActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds176)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.gpM = new ImageView(bPS().pageContext.getPageActivity());
            this.gpM.setVisibility(8);
            this.gpM.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.gpM.setImageResource(a.f.icon_live_enlarge);
            this.gpM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.gpN != null) {
                        a.this.gpN.OL();
                        a.this.gpM.setVisibility(4);
                    }
                }
            });
            bPS().gAv.addView(this.gpM, layoutParams);
            if (UtilHelper.getRealScreenOrientation(bPS().pageContext.getPageActivity()) != 2) {
                if (bPS().gAA) {
                    this.gpM.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.15
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.gpM != null && UtilHelper.getRealScreenOrientation(a.this.bPS().pageContext.getPageActivity()) != 2) {
                                a.this.gpM.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
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
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.16
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bPs();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void r(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
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
            e.printStackTrace();
            jSONObject = null;
        }
        if ((aVar.getMsgType() == 12 || aVar.getMsgType() == 13) && jSONObject != null) {
            String optString = jSONObject.optString("content_type");
            if ("task".equals(optString)) {
                if (this.gpC != null) {
                    this.gpC.J(jSONObject);
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
                long optLong = jSONObject.optLong("mvp_user_id");
                long optLong2 = jSONObject.optLong("winner_live_id");
                if (optLong == bPS().gAu.Fq().aFb.userId && optLong2 == bPS().gAu.Fq().mLiveInfo.live_id) {
                    this.gpG.c(jSONObject.optInt("challenge_status"), jSONObject.optLong("challenge_id"));
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void Gl(String str) {
        if (this.gpD != null) {
            this.gpD.Gl(str);
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
        if (this.gpI != null) {
            this.gpI.a(uVar);
        }
        if (this.gpD != null) {
            this.gpD.k(uVar);
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
        if (this.gpF != null) {
            this.gpF.BQ();
        }
        if (this.gpI != null) {
            this.gpI.a((a.InterfaceC0177a) null);
            this.gpI.Bq();
        }
        if (this.gpy != null) {
            this.gpy.bUo();
        }
        if (this.gpM != null && (this.gpM.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gpM.getParent()).removeView(this.gpM);
        }
        if (this.gpJ != null) {
            this.gpJ.dismiss();
        }
        if (this.gpN != null) {
            this.gpN.cu(false);
            this.gpN.OM();
        }
        if (this.gpT != null) {
            this.gpT.BQ();
        }
        if (this.grt != null) {
            this.grt.bRc();
        }
        if (this.grc != null) {
            this.grc.BQ();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void o(u uVar) {
        View Bo;
        super.o(uVar);
        if (this.gpI != null && (Bo = this.gpI.Bo()) != null && Bo.getParent() != null) {
            ((ViewGroup) Bo.getParent()).removeView(Bo);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.gpI != null) {
            this.gpI.setOtherParams(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cb(boolean z) {
        super.cb(z);
        this.gpR.removeCallbacksAndMessages(null);
        bOS();
        this.gpP = false;
        this.gpQ = false;
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
        if (this.gpJ != null) {
            this.gpJ.onDestroy();
        }
        if (this.gpz != null) {
            this.gpz.onDestroy();
        }
        if (this.gpN != null) {
            this.gpN.stop();
        }
        if (this.gqw != null) {
            this.gqw.onDestroy();
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
        if (this.gpI != null) {
            this.gpI.a((a.InterfaceC0177a) null);
            this.gpI.release();
            this.gpI = null;
        }
        if (this.grt != null) {
            this.grt.cb(z ? false : true);
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
        MessageManager.getInstance().unRegisterListener(this.gqb);
        MessageManager.getInstance().unRegisterListener(this.gqc);
        MessageManager.getInstance().unRegisterListener(this.gqd);
        MessageManager.getInstance().unRegisterListener(this.gqa);
        MessageManager.getInstance().unRegisterListener(this.gpZ);
    }

    private void bOS() {
        if (this.gqB != null && this.gqB.JJ().getView() != null && this.gqB.JJ().getView().getParent() != null) {
            ((ViewGroup) this.gqB.JJ().getView().getParent()).removeView(this.gqB.JJ().getView());
        }
        if (this.gpK != null && this.gpK.getParent() != null) {
            ((ViewGroup) this.gpK.getParent()).removeView(this.gpK);
        }
        if (this.gpL != null && this.gpL.getParent() != null) {
            ((ViewGroup) this.gpL.getParent()).removeView(this.gpL);
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

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected ViewGroup bOW() {
        return this.bkG;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected ViewGroup bOX() {
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
                    this.grj = false;
                    K(intExtra, intExtra2, intExtra3);
                    return;
                }
                bON();
                return;
            }
            aoL();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.gri;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(bPS().pageContext.getPageActivity()) || z2) {
            lJ(z);
        }
    }

    private void lJ(boolean z) {
        if (this.gqB != null && this.gqB.JJ() != null) {
            this.gqB.JJ().onKeyboardVisibilityChanged(z);
        }
        if (z || this.gqB == null || !this.gqB.JK().Lf()) {
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
            } else {
                bOY();
            }
            if (this.gqB != null && this.gpK != null) {
                if (this.grf.indexOfChild(this.gpK) != -1 && this.gpK.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gpK.getLayoutParams();
                    layoutParams2.height = com.baidu.live.ac.b.i(true, z);
                    this.gpK.setLayoutParams(layoutParams2);
                }
                if (this.gpK.indexOfChild(this.gqB.JJ().getView()) != -1 && this.gqB.JJ().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.gqB.JJ().getView().getLayoutParams();
                    layoutParams3.height = com.baidu.live.ac.b.i(true, z);
                    this.gqB.JJ().getView().setLayoutParams(layoutParams3);
                }
                this.gqB.JJ().JI();
            }
        }
    }

    private void bOY() {
        if (this.gqm != null) {
            this.gqm.setVisibility(0);
        }
        if (this.gpK != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gpK.getLayoutParams();
            layoutParams.bottomMargin = bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            this.gpK.setLayoutParams(layoutParams);
        }
        if (this.gqB != null) {
            bPt();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gqB.JK().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.gqB.JK().getView().setLayoutParams(layoutParams2);
        }
        if (this.gqm != null) {
            this.gqm.setVisibility(0);
        }
        if (this.gqD != null && this.gqD.EV() != null) {
            this.gqD.EV().setVisibility(0);
        }
        if (this.gre != null && (!this.gpP || UtilHelper.getRealScreenOrientation(bPS().pageContext.getPageActivity()) != 2)) {
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
        FrameLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        FrameLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = bPS().pageContext.getPageActivity();
        if (i3 == 1) {
            if (bPS().pageContext.getPageActivity() != null && !UtilHelper.canUseStyleImmersiveSticky()) {
                q.e(bPS().pageContext.getPageActivity(), true);
            }
            if (this.gre != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.gre.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.gpJ != null) {
                this.gpJ.dismiss();
            }
            if (this.gpI != null) {
                this.gpI.a((a.InterfaceC0177a) null);
                this.gpI.Bq();
            }
            if (this.bhb != null) {
                this.bhb.e(true, true);
            }
            if (this.gpM != null) {
                this.gpM.setVisibility(0);
                this.gpM.bringToFront();
            }
            if (this.gqr != null) {
                this.gqr.setVisibility(0);
            }
            if (this.gqB != null && this.gqB.JJ().getView().getParent() != null && (this.gqB.JJ().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gqB.JJ().getView().getParent()).removeView(this.gqB.JJ().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bPS().pageContext.getPageActivity()) * 0.7f);
            int i4 = com.baidu.live.ac.b.i(true, false);
            if (this.gpK != null && this.gqB != null) {
                this.gpK.addView(this.gqB.JJ().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, i4));
            }
            if (this.gpL != null && (this.gpL.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gpL.getParent()).removeView(this.gpL);
            }
            if (this.gqC != null) {
                this.gqC.a(bPS().gAu.Fq(), false);
                this.gqC.a(new a.InterfaceC0177a() { // from class: com.baidu.tieba.ala.liveroom.d.a.17
                    @Override // com.baidu.live.im.b.a.InterfaceC0177a
                    public void Kg() {
                        a.this.bPE();
                    }
                });
                View Bo = this.gqC.Bo();
                if (Bo != null && this.grf != null && Bo.getParent() == null) {
                    Resources resources = bPS().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bPS().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds98));
                    layoutParams5.addRule(2, a.g.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                    this.grf.addView(Bo, layoutParams5);
                }
            }
            if (this.gqt != null) {
                this.gqt.setPraiseEnable(true);
                bPS().gAv.gPq = true;
            }
            if (this.gpx != null && this.gpx.gsC != null && (layoutParams3 = (FrameLayout.LayoutParams) this.gpx.gsC.getLayoutParams()) != null) {
                layoutParams3.width = -2;
                this.gpx.gsC.setLayoutParams(layoutParams3);
            }
            if (this.gqw != null) {
                this.gqw.bZq();
            }
            if (this.gpP) {
                lI(true);
            }
            if (this.gpQ) {
                if (this.gqm != null && this.gqm.getLandscapeBarrageImageView() != null) {
                    b(this.gqm.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.gqm != null) {
                this.gqm.uV(0);
            }
            if (this.gpB != null) {
                this.gpB.lU(true);
            }
            this.gpR.removeCallbacksAndMessages(null);
            if (this.gpC != null) {
                this.gpC.setCanVisible(true);
                this.gpC.x(bPS().gAu.Fq());
            }
        } else if (i3 == 2) {
            if (bPS().pageContext.getPageActivity() != null && !UtilHelper.canUseStyleImmersiveSticky()) {
                q.e(bPS().pageContext.getPageActivity(), false);
            }
            if (this.gqw != null) {
                this.gqw.bZr();
            }
            if (this.gre != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.gre.getLayoutParams()) != null) {
                layoutParams2.topMargin = bPS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
            }
            if (this.gqC != null) {
                this.gqC.a((a.InterfaceC0177a) null);
                this.gqC.Bq();
            }
            bPS().gAv.bYT();
            if (this.bhb != null) {
                this.bhb.e(false, true);
            }
            if (this.gpM != null) {
                this.gpM.setVisibility(4);
            }
            if (this.gqB != null && this.gqB.JJ().getView().getParent() != null && (this.gqB.JJ().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gqB.JJ().getView().getParent()).removeView(this.gqB.JJ().getView());
            }
            int max = Math.max(i, i2);
            if (this.gpL != null) {
                if (this.gpL.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gpL.getParent()).removeView(this.gpL);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
                bPS().gAv.addView(this.gpL, this.bkG != null ? bPS().gAv.indexOfChild(this.bkG) : -1, layoutParams6);
            }
            if (this.gpL != null && this.gpI != null) {
                this.gpI.a(bPS().gAu.Fq(), false);
                this.gpI.a(new a.InterfaceC0177a() { // from class: com.baidu.tieba.ala.liveroom.d.a.18
                    @Override // com.baidu.live.im.b.a.InterfaceC0177a
                    public void Kg() {
                        a.this.bPE();
                    }
                });
                View Bo2 = this.gpI.Bo();
                if (Bo2 != null && this.gpL.indexOfChild(Bo2) < 0) {
                    this.gpL.addView(Bo2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bPS().pageContext.getPageActivity()), -1));
                }
            }
            if (this.gqt != null) {
                this.gqt.aA(bPS().gAv);
                this.gqt.setPraiseEnable(false);
                bPS().gAv.gPq = false;
            }
            if (this.gpx != null && this.gpx.gsC != null && (layoutParams = (FrameLayout.LayoutParams) this.gpx.gsC.getLayoutParams()) != null) {
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                layoutParams.width = (int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f);
                this.gpx.gsC.setLayoutParams(layoutParams);
            }
            if (this.gqm != null) {
                this.gqm.uV(8);
            }
            if (this.gpB != null) {
                this.gpB.lU(false);
            }
            if (ad.FE() != null) {
                ad.FE().FD();
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.z.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.z.c) runTask.getData()).FD();
            }
            if (this.gqm != null && this.gqm.getLandscapeBarrageImageView() != null) {
                b(this.gqm.getLandscapeBarrageImageView(), this.gpQ, false);
            }
            bOp();
            if (this.gqD != null) {
                this.gqD.EX();
            }
            if (this.gpC != null) {
                this.gpC.setCanVisible(false);
                this.gpC.bTo();
            }
        }
        if (this.gqE != null) {
            if (i3 == 2) {
                View Fp = this.gqE.Fp();
                if (Fp != null) {
                    if (Fp.getParent() != null && (Fp.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) Fp.getParent()).removeView(Fp);
                    }
                    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams7.addRule(5, a.g.ala_liveroom_hostheader);
                    layoutParams7.addRule(3, a.g.ala_liveroom_hostheader);
                    layoutParams7.topMargin = bPS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                    if (this.gre != null) {
                        this.gre.addView(Fp, layoutParams7);
                    }
                }
            } else {
                View Fp2 = this.gqE.Fp();
                if (Fp2 != null) {
                    if (Fp2.getParent() != null && (Fp2.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) Fp2.getParent()).removeView(Fp2);
                    }
                    RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams8.topMargin = bPS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18) * (-1);
                    layoutParams8.addRule(3, a.g.ala_live_header_view);
                    bPS().gAv.addView(Fp2, layoutParams8);
                }
            }
        }
        if (this.gqm != null) {
            this.gqm.l(i, i2, i3);
        }
        I(i3, true);
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.gpx != null) {
                this.gpx.dD(i3);
            }
            if (this.gpz != null) {
                this.gpz.dD(i3);
            }
            if (this.gpD != null) {
                this.gpD.dD(i3);
            }
            if (this.gqL != null) {
                this.gqL.dD(i3);
            }
            if (this.gqH != null) {
                this.gqH.dD(i3);
            }
            if (this.gqP != null) {
                this.gqP.dD(i3);
            }
            if (this.gqS != null) {
                this.gqS.dD(i3);
            }
            if (this.gqQ != null) {
                this.gqQ.dD(i3);
            }
            if (this.grd != null) {
                this.grd.dD(i3);
            }
            if (this.gpS != null && this.gpS.isShowing()) {
                this.gpS.resize();
            }
            if (this.grb != null) {
                this.grb.dD(i3);
            }
            if (this.grc != null) {
                this.grc.dD(i3);
            }
            if (this.gqZ != null) {
                this.gqZ.eQ(i3);
            }
        }
        if (this.gqD != null) {
            this.gqD.EW();
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
            if (i != 7 || UtilHelper.getRealScreenOrientation(bPS().pageContext.getPageActivity()) != 2) {
                if (this.gqm != null) {
                    this.gqm.setVisibility(8);
                }
                if (this.gqB != null) {
                    this.gqB.JJ().getView().setVisibility(4);
                }
                if (this.gqR != null) {
                    this.gqR.mJ(false);
                }
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
            if (this.gqR != null) {
                this.gqR.mJ(true);
            }
            if (!this.gpP || UtilHelper.getRealScreenOrientation(bPS().pageContext.getPageActivity()) != 2) {
                this.gre.setVisibility(0);
            }
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
        if (bPS() != null) {
            BdUtilHelper.hideSoftKeyPad(bPS().pageContext.getPageActivity(), bPS().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.gpA != null) {
            this.gpA.bXU();
        }
        if (this.gpF != null) {
            this.gpF.BZ();
        }
        if (this.gpD != null) {
            this.gpD.onStart();
        }
        if (this.gqZ != null) {
            this.gqZ.onStart();
        }
    }

    private void I(int i, boolean z) {
        if (this.bkG != null) {
            int dimensionPixelSize = bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bkG.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                layoutParams.rightMargin = bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.height = bOw();
                this.bkG.setPosition(dimensionPixelSize, 0, dimensionPixelSize, 0);
                if (z) {
                    this.gqs.lH(true);
                }
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                int dimensionPixelSize2 = bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds72) + 0 + bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100) + bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
                layoutParams.height = -1;
                this.bkG.setPosition(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
                this.gqs.lH(false);
            }
            layoutParams.bottomMargin = bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            this.bkG.setLayoutParams(layoutParams);
            this.bkG.setModel(i == 1 ? PendantParentView.Model.HORIZONTAL : PendantParentView.Model.HORIZONTAL_FULL);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.e
    public void uk(int i) {
        I(this.mOrientation, false);
    }
}
