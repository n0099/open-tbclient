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
import com.baidu.live.data.ah;
import com.baidu.live.data.ap;
import com.baidu.live.data.at;
import com.baidu.live.data.be;
import com.baidu.live.data.bo;
import com.baidu.live.data.bu;
import com.baidu.live.data.k;
import com.baidu.live.data.p;
import com.baidu.live.data.r;
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
/* loaded from: classes7.dex */
public class d extends b implements com.baidu.live.j.c {
    private PendantParentView bhH;
    private com.baidu.tieba.ala.liveroom.j.b gmH;
    private com.baidu.tieba.ala.liveroom.audiencelist.c gmm;
    private com.baidu.tieba.ala.liveroom.o.a gmn;
    private com.baidu.tieba.ala.liveroom.g.b gmo;
    private com.baidu.tieba.ala.liveroom.u.b gmp;
    private com.baidu.tieba.ala.liveroom.audiencelist.b gmq;
    private com.baidu.tieba.ala.liveroom.l.a gmr;
    private com.baidu.tieba.ala.liveroom.activeview.b gms;
    private com.baidu.live.d.a gmt;
    private i gmu;
    private h gmv;
    private com.baidu.tieba.ala.liveroom.c.a gmw;
    private FrameLayout gmz;
    private LinearLayout goM;
    private e goN;
    private boolean goO;
    private long lastClickTime = 0;
    private boolean goP = false;
    private HttpRule gmI = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.gmu != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.gmu.BP()) {
                httpMessage.addParam("ala_challenge_id", d.this.gmu.BS());
            }
            return httpMessage;
        }
    };
    private HttpRule gmJ = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.gmu != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.gmu.BP()) {
                httpMessage.addParam("challenge_id", d.this.gmu.BS());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c gmK = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.d.18
        @Override // com.baidu.live.liveroom.g.c
        public void LA() {
            if (d.this.gnl != null) {
                d.this.gnl.mI(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void ce(boolean z) {
            if (z) {
                if (d.this.gnl != null) {
                    d.this.gnl.mI(true);
                }
            } else if (d.this.gnl != null) {
                d.this.gnl.mI(false);
            }
            if (d.this.gnD != null) {
                d.this.gnD.bl(z);
            }
            if (d.this.gms != null) {
                d.this.gms.lB(z ? false : true);
            }
        }
    };
    private HttpMessageListener gmL = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.d.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.LK() != null) {
                        com.baidu.live.w.c.Np().bki = getQuickGiftHttpResponseMessage.LK();
                        d.this.bNt();
                    }
                }
            }
        }
    };
    private CustomMessageListener gmM = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.d.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.bNE();
        }
    };
    CustomMessageListener gmR = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.d.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.gmH.c(d.this.bOF());
                } else if (d.this.bOa() || !g.ud(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.22.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.bOF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.bOF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    d.this.gmH.b(d.this.gmz, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener goQ = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.d.d.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.bOa() || !g.ud(2913128)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.23.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.ub(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    d.this.FS(str);
                }
            }
        }
    };
    private CustomMessageListener gmN = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.d.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.gnt.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gmO = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.this.gnH != null) {
                    d.this.gnH.Gn(str);
                }
            }
        }
    };
    CustomMessageListener gmP = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.gnY != null && d.this.gnY.aXT != null && !d.this.gnY.aXW && !d.this.gnY.aXX && d.this.gnC != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.bOF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = d.this.bOF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                d.this.gnC.b(d.this.gmz, layoutParams);
                if (com.baidu.live.guardclub.e.Il() != null) {
                    com.baidu.live.guardclub.e.Il().Ir();
                }
            }
        }
    };
    private CustomMessageListener gmQ = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.gnF != null) {
                    d.this.gnF.dismiss();
                }
                if (d.this.gnH != null) {
                    d.this.gnH.dismiss();
                }
                com.baidu.live.im.b.d.JD().setSwitchStatus(true);
                com.baidu.live.im.b.d.JD().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bOg();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gmS = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.d.15
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void m(View view, int i) {
            be beVar;
            bo boVar;
            bu buVar;
            String str;
            be beVar2;
            bo boVar2;
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
                        alaStaticItem.addParams("gifts_value", com.baidu.live.w.c.Np().bki.EN().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.w.c.Np().bki.EN().DR());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.w.c.Np().bki.EN().DS());
                        if (d.this.bOF().gxe.LC() != null && d.this.bOF().gxe.LC().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.bOF().gxe.LC().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.bOF().gxe.LC().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.JY());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.Hu()) {
                        if (com.baidu.live.c.AD().getBoolean("quick_gift_guide_show", true) && !d.this.bOa()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, z.class, d.this.bOF().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                z zVar = (z) runTask.getData();
                                zVar.setPageContext(d.this.bOF().pageContext);
                                zVar.d(d.this.bOF().gxe.LC());
                                zVar.setGiftItem(com.baidu.live.w.c.Np().bki.EN());
                                zVar.setOtherParams(d.this.JY());
                                zVar.initView();
                                zVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.d.d.15.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        d.this.lI(false);
                                    }
                                });
                                zVar.show();
                                d.this.lI(true);
                                return;
                            }
                            return;
                        }
                        n.a(d.this.bOF().pageContext, d.this.bOF().gxe.LC(), com.baidu.live.w.c.Np().bki.EN(), d.this.JY());
                    }
                } else if (i == 1) {
                    if (d.this.gnq != null) {
                        d.this.bOg();
                    }
                } else if (i == 3 && d.this.Hu()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    d.this.gnd.c(d.this.bOF().gxe.LC(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.bOF() != null && d.this.bOF().gxe != null && d.this.bOF().gxe.LC() != null && d.this.bOF().gxe.LC().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.bOF().gxe.LC().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.bOF().gxe.LC().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.bOF().gxe.LC().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.JY());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.bOF() != null && d.this.bOF().gxe != null && d.this.bOF().gxe.LC() != null && d.this.bOF().gxe.LC().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.bOF().gxe.LC().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.bOF().gxe.LC().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.bOF().gxe.LC().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.JY());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.bei != null) {
                        d.this.bei.bY(false);
                    }
                } else if (i == 12) {
                    if (d.this.gnl != null && d.this.bOF().gxe.LC() != null && d.this.bOF().gxe.LC().mLiveInfo != null) {
                        String valueOf = String.valueOf(d.this.bOF().gxe.LC().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.bOF().gxe.LC().mLiveInfo.room_id);
                        String str3 = null;
                        p pVar = d.this.bOF().gxe.LC().mLiveSdkInfo;
                        if (pVar != null && pVar.mCastIds != null) {
                            str3 = String.valueOf(d.this.bOF().gxe.LC().mLiveSdkInfo.mCastIds.aDW);
                        }
                        d.this.gnl.ai(valueOf, valueOf2, str3);
                        if (com.baidu.live.liveroom.a.KQ().KR()) {
                            d.this.bNE();
                        }
                    }
                } else if (i == 14) {
                    r LC = d.this.bOF().gxe.LC();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.bOF().pageContext.getPageActivity(), LC.aDE.userName, Long.toString(LC.aDE.userId), Long.toString(LC.aDE.charmCount), String.valueOf(LC.mLiveInfo.group_id), String.valueOf(LC.mLiveInfo.live_id), false, String.valueOf(LC.aDE.userId), Long.toString(LC.aEd.userId), LC.aEd.userName, LC.aEd.portrait, d.this.gmq.getCount(), d.this.JY())));
                    LogManager.getCommonLogger().doClickGusetNumLog(LC.mLiveInfo.feed_id, d.this.gmq.getCount() + "", d.this.JY());
                } else if (i == 11) {
                    d.this.bOj();
                    d.this.bOk();
                } else if (i == 16) {
                    if (d.this.bOF() != null && (beVar2 = com.baidu.live.w.a.Nk().bka) != null && (boVar2 = beVar2.aJy) != null) {
                        String str4 = boVar2.aKu.aKB;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (d.this.bOF().gxe != null && d.this.bOF().gxe.LC() != null && d.this.bOF().gxe.LC().mLiveInfo != null) {
                                j = d.this.bOF().gxe.LC().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", d.this.bOF().gxe.LC().mLiveInfo.room_id + "", d.this.bOF().gxe.LC().mLiveInfo.feed_id, d.this.JY());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.bOF().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (d.this.bOF() != null) {
                        r rVar = null;
                        if (d.this.bOF().gxe != null) {
                            rVar = d.this.bOF().gxe.LC();
                        }
                        if (rVar != null && rVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.w.b.bWx().beS != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.w.b.bWx().beS.aDg;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + rVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + rVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(d.this.bOF().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17 && d.this.Hu() && d.this.bOF() != null && (beVar = com.baidu.live.w.a.Nk().bka) != null && (boVar = beVar.aJy) != null && (buVar = boVar.aKv) != null && !TextUtils.isEmpty(buVar.webUrl)) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                    if (d.this.gnF != null && d.this.bOF().gxe != null && d.this.bOF().gxe.LC() != null) {
                        r LC2 = d.this.bOF().gxe.LC();
                        d.this.gnF.a(buVar.webUrl, LC2.mLiveInfo.live_id, LC2.aEd.userId, LC2.aDE.userId);
                    }
                }
            }
        }
    };
    private boolean goR = false;
    private boolean goS = false;

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.gnf = new com.baidu.tieba.ala.liveroom.guide.c(bOF().pageContext, this, false);
        this.gmI.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.gmI);
        this.gmJ.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.gmJ);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean bNe() {
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void m(r rVar) {
        super.m(rVar);
        g.bRN();
        this.goP = true;
        this.goS = false;
        this.goR = false;
        bOF().gxf.setIsForceHandledTouch(false);
        bOF().gxf.setSwipeClearEnable(true);
        bOF().gxf.setOnLiveViewScrollListener(this.gmK);
        bOF().gxf.setOnClickListener(null);
        bOF().gxf.setClickable(false);
        if (this.gni != null) {
            this.gni.b(this.gmS);
        }
        if (this.gnR != null) {
            this.gnR.setVisibility(0);
        }
        bNk();
        if (this.gnA != null) {
            this.gnA.a(rVar, this.bhH);
            this.gnA.S(this.gnS);
            this.gnA.a(this);
        }
        bOX();
        bNw();
        bNW();
        bNx();
        bNB();
        bNy();
        lJ(false);
        bOn();
        bOm();
        bNn();
        bNu();
        bOo();
        bND();
        bNF();
        bOQ();
        bOR();
        lK(false);
        bOx();
        bNm();
        bNt();
        bNo();
        bNp();
        bNq();
        bNr();
        bOt();
        bNg();
        lO(true);
        bOw();
        c(this.fxt);
        MessageManager.getInstance().registerListener(this.gmL);
        MessageManager.getInstance().registerListener(this.gmM);
        MessageManager.getInstance().registerListener(this.gmN);
        MessageManager.getInstance().registerListener(this.gmP);
        MessageManager.getInstance().registerListener(this.gmQ);
        MessageManager.getInstance().registerListener(this.goQ);
        MessageManager.getInstance().registerListener(this.gmR);
        MessageManager.getInstance().registerListener(this.gmO);
        bNH();
        bNA();
    }

    private void bNg() {
        if (this.gnM != null) {
            this.gnM.a(new com.baidu.live.r.c() { // from class: com.baidu.tieba.ala.liveroom.d.d.19
                @Override // com.baidu.live.r.c
                public void cj(boolean z) {
                    if (d.this.gmv != null) {
                        d.this.gmv.setNeedCloseRecommendFloat(z);
                    }
                    if (d.this.bOF().gxf.gLW) {
                        if (d.this.gnl != null) {
                            d.this.gnl.mB(z);
                            d.this.gnl.mI(!z);
                        }
                        if (d.this.gni != null) {
                            d.this.gni.mB(z);
                            d.this.gni.setPraiseEnable(!z);
                            d.this.gni.mA(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(r rVar) {
        super.k(rVar);
        if (this.gmn != null) {
            this.gmn.w(rVar);
        }
        if (this.gmo != null) {
            this.gmo.s(rVar);
        }
        if (this.gmr != null) {
            this.gmr.v(rVar);
        }
        if (this.gmv != null) {
            this.gmv.a(rVar);
        }
        lO(false);
        if (this.gms != null) {
            this.gms.j(rVar);
            this.gms.lA(this.gob);
            this.gms.updateView();
            if (rVar != null && this.gnO != null && !this.gnO.hasInit && !TextUtils.isEmpty(this.gnO.aJS)) {
                this.gnO.hasInit = true;
                this.gms.FO(this.gnO.aJS);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(k kVar) {
        if (kVar != null) {
            if (this.gmm != null && kVar.getList() != null) {
                this.gmm.e(kVar);
            }
            if (this.gmq != null) {
                this.gmq.dO(kVar.getCount());
            }
        }
    }

    private void bNi() {
        if (this.gnk != null) {
            this.gnk.aw(bOF().gxd.getLiveContainerView());
        }
    }

    private void bOQ() {
        if (this.gmw == null) {
            this.gmw = new com.baidu.tieba.ala.liveroom.c.a(bOF().pageContext);
        }
        if (bOF().gxe != null && bOF().gxe.LC() != null && bOF().gxe.LC().mLiveInfo != null) {
            this.gmw.FP(String.valueOf(bOF().gxe.LC().mLiveInfo.user_id));
        }
    }

    private void bOR() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (bOF() != null && bOF().gxe != null && bOF().gxe.LC() != null && bOF().gxe.LC().mLiveInfo != null) {
                j = bOF().gxe.LC().mLiveInfo.room_id;
            }
            if (this.gny == null) {
                this.gny = new com.baidu.tieba.ala.liveroom.guide.a(bOF().pageContext, j);
            }
            this.gny.lH(this.gnU);
            this.gny.a(new a.InterfaceC0631a() { // from class: com.baidu.tieba.ala.liveroom.d.d.5
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0631a
                public void bPa() {
                    if (d.this.bei != null) {
                        d.this.bei.bY(true);
                    }
                }
            });
            this.gny.as(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void dD(int i) {
        super.dD(i);
        bNi();
        if (this.gmv != null) {
            this.gmv.dD(i);
        }
    }

    private void bNk() {
        if (this.bhH == null) {
            this.bhH = new PendantParentView(bOF().pageContext.getPageActivity(), this.goO ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            bOF().gxf.addView(this.bhH, new ViewGroup.LayoutParams(-1, -1));
            this.bhH.setDefaultItemMargin(bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.bhH.setPadding(bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20), 0, bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6), 0);
            bOS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOS() {
        int dimensionPixelSize;
        if (this.bhH != null) {
            this.bhH.setModel(this.goO ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            int dimensionPixelSize2 = bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds220);
            int dimensionPixelSize3 = bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            if (this.goO) {
                dimensionPixelSize = bOY();
            } else {
                dimensionPixelSize = bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200);
            }
            this.bhH.setPosition(dimensionPixelSize2, 0, dimensionPixelSize, dimensionPixelSize3);
            return;
        }
        bNk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOT() {
        if (bOF().gxf != null && !this.goS) {
            bOF().gxf.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.6
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.gmz != null && d.this.gnq != null && d.this.gnq.Jf() != null && d.this.gnq.Jf().getView() != null) {
                        if (d.this.goO && !d.this.gnV && d.this.bOF().gxf != null && d.this.bOF().gxf.getHeight() > 0) {
                            int be = d.this.gmv != null ? d.this.gmv.be(false) : 0;
                            ViewGroup.LayoutParams layoutParams = d.this.gmz.getLayoutParams();
                            int height = d.this.bOF().gxf.getHeight() - be;
                            int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                i += UtilHelper.getStatusBarHeight();
                            }
                            if (layoutParams != null) {
                                layoutParams.height = i + d.this.bOF().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height);
                                d.this.gmz.setLayoutParams(layoutParams);
                                ViewGroup.LayoutParams layoutParams2 = d.this.gnq.Jf().getView().getLayoutParams();
                                if (layoutParams2 != null) {
                                    layoutParams2.height = layoutParams.height - com.baidu.live.ab.b.cD(false);
                                    d.this.gnq.Jf().getView().setLayoutParams(layoutParams2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        int i2 = com.baidu.live.ab.b.i(false, d.this.gnV);
                        if (d.this.gnS.indexOfChild(d.this.gmz) != -1 && d.this.gmz.getLayoutParams() != null) {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) d.this.gmz.getLayoutParams();
                            layoutParams3.height = com.baidu.live.ab.b.c(false, false, d.this.gnV);
                            d.this.gmz.setLayoutParams(layoutParams3);
                        }
                        if (d.this.gmz.indexOfChild(d.this.gnq.Jf().getView()) != -1 && d.this.gnq.Jf().getView().getLayoutParams() != null) {
                            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) d.this.gnq.Jf().getView().getLayoutParams();
                            layoutParams4.height = i2;
                            d.this.gnq.Jf().getView().setLayoutParams(layoutParams4);
                        }
                        d.this.gnq.Jf().Je();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOU() {
        if (bOF().gxf != null) {
            bOF().gxf.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.7
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.gns != null) {
                        if (d.this.goO && !d.this.gnV && d.this.bOF().gxf != null && d.this.bOF().gxf.getHeight() > 0) {
                            int height = (d.this.bOF().gxf.getHeight() - (d.this.gmv != null ? d.this.gmv.be(false) : 0)) + d.this.bOF().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            d.this.gns.dL(height);
                            return;
                        }
                        d.this.gns.dL(com.baidu.live.ab.a.a(d.this.bOF().pageContext.getPageActivity(), false, false, d.this.gnV));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOV() {
        if (bOF().gxf != null) {
            bOF().gxf.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.8
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    if (d.this.gns != null) {
                        int h = com.baidu.live.ab.a.h(false, false);
                        if (!d.this.goO || d.this.bOF().gxf == null || d.this.bOF().gxf.getHeight() <= 0) {
                            i = h;
                        } else {
                            int height = d.this.bOF().gxf.getHeight() - (d.this.gmv != null ? d.this.gmv.be(false) : 0);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            i = height + d.this.bOF().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height);
                        }
                        d.this.gns.dM(i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOW() {
        if (this.gnr != null && this.gnr.AZ() != null) {
            ViewGroup.LayoutParams layoutParams = this.gnr.AZ().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bOF().pageContext.getResources().getDimensionPixelOffset(this.goO ? a.e.sdk_ds100 : a.e.sdk_ds20);
                this.gnr.AZ().setLayoutParams(layoutParams);
            }
        }
    }

    private void bOX() {
        if (this.goM == null) {
            this.goM = new LinearLayout(bOF().pageContext.getPageActivity());
            this.goM.setOrientation(1);
        }
        if (this.goM.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds160);
            layoutParams.leftMargin = bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bOF().gxf.addView(this.goM, layoutParams);
        }
    }

    private void bNn() {
        if (this.gnh != null && bOF() != null && bOF().gxe != null) {
            this.gnh.b(bOF().gxd.getLiveContainerView(), bOF().gxe.LC());
        }
    }

    private void bNm() {
        if (this.gms == null) {
            this.gms = new com.baidu.tieba.ala.liveroom.activeview.b(bOF().pageContext);
        }
        if (bOF() != null && bOF().gxe != null) {
            this.gms.FL(bOF().gxe.bVQ());
        }
        this.gms.lz(this.goO);
        this.gms.setOtherParams(JY());
        this.gms.b(bOF().gxe.LC(), false);
        this.gms.setHost(false);
        this.gms.lA(this.gob);
        this.gms.a(1, this.bhH);
        this.gms.a(2, this.bhH);
        this.gms.setVisible(this.gnV ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNt() {
        if (this.gnb == null) {
            bNy();
        }
        this.gnb.setOtherParams(JY());
        this.gnb.a(com.baidu.live.w.c.Np().bki, bOF().gxe.LC());
    }

    private void bNo() {
        if (this.gmr == null) {
            this.gmr = new com.baidu.tieba.ala.liveroom.l.a(bOF().pageContext, this);
        }
        this.gmr.setOtherParams(JY());
        this.gmr.a((ViewGroup) this.bhH, bNs());
        this.gmr.v(bOF().gxe.LC());
    }

    private void bNp() {
        if (this.gnC == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, j.class, bOF().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gnC = (j) runTask.getData();
            } else {
                return;
            }
        }
        this.gnC.setOtherParams(JY());
        if (this.gmz != null && this.gmz.indexOfChild(this.gnC.getView()) >= 0) {
            this.gmz.removeView(this.gnC.getView());
        }
    }

    private void bNq() {
        if (this.gnb != null) {
            this.gnb.a(new a.InterfaceC0637a() { // from class: com.baidu.tieba.ala.liveroom.d.d.9
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0637a
                public void bK(int i, int i2) {
                    r LC = d.this.bOF().gxe.LC();
                    if (LC != null && LC.mLiveInfo != null) {
                        if (d.this.gnG == null) {
                            d.this.gnG = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.bOF().pageContext.getPageActivity());
                        }
                        d.this.gnG.d(d.this.gnS, i, i2);
                        d.this.gnG.a(String.valueOf(LC.mLiveInfo.live_id), new a.InterfaceC0641a() { // from class: com.baidu.tieba.ala.liveroom.d.d.9.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0641a
                            public void a(float f, String str) {
                                if (d.this.gnb != null) {
                                    d.this.gnb.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0637a
                public void bL(int i, int i2) {
                    if (d.this.gnG != null) {
                        d.this.gnG.bQ(i, i2);
                    }
                }
            });
        }
    }

    private void bNr() {
        if (this.gog == null) {
            this.gog = new com.baidu.tieba.ala.liveroom.j.e(bOF().pageContext);
        }
        this.gog.setRoomId(bOF().gxe.LC().mLiveInfo.room_id);
        this.gog.Gd("");
        this.gog.b(bOF().gxe.LC(), this.bhH);
        if (this.gmH == null) {
            this.gmH = new com.baidu.tieba.ala.liveroom.j.b(bOF().pageContext, JY(), this.gog, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.10
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bNQ() {
                    d.this.lI(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bNR() {
                    d.this.lI(false);
                }
            });
        }
        this.gmH.setRoomId(bOF().gxe.LC().mLiveInfo.room_id);
        if (this.gmz != null && this.gmz.indexOfChild(this.gmH.getView()) >= 0) {
            this.gmz.removeView(this.gmH.getView());
        }
        if (this.gmH != null) {
            this.gmH.b(bOF());
        }
    }

    private LinearLayout.LayoutParams bNs() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    private void bNu() {
        CustomResponsedMessage runTask;
        if (this.gnq == null && (runTask = MessageManager.getInstance().runTask(2913039, com.baidu.live.im.k.class, bOF().pageContext)) != null && runTask.getData() != null) {
            this.gnq = (com.baidu.live.im.k) runTask.getData();
            this.gnq.setFromMaster(false);
            this.gnq.Jf().getView().setId(a.g.ala_liveroom_msg_list);
            this.gnq.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.11
                @Override // com.baidu.live.im.k.a
                public boolean Ji() {
                    return d.this.Hu();
                }

                @Override // com.baidu.live.im.k.a
                public void Jj() {
                    d.this.gnZ = true;
                }

                @Override // com.baidu.live.im.k.a
                public void gQ(String str) {
                    if (!d.this.gnV) {
                        d.this.lG(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.bOF().pageContext.getPageActivity(), d.this.bOF().gxd.getLiveContainerView());
                    }
                    d.this.FR(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Jk() {
                    if (d.this.gnV) {
                        d.this.lG(true);
                        d.this.bOF().gxd.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.bOF().pageContext.getPageActivity(), d.this.bOF().gxd.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.gnq != null) {
                        d.this.gnq.Jg().setQuickInputPanelVisible(false);
                        d.this.gnq.Jg().Kz();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Jl() {
                    if (d.this.gnV) {
                        d.this.bNP();
                        if (d.this.gnr != null) {
                            d.this.gnr.Ba();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Jm() {
                    return d.this.bOb();
                }

                @Override // com.baidu.live.im.k.a
                public int Jn() {
                    return d.this.bOc();
                }
            });
            this.gmz = new FrameLayout(bOF().pageContext.getPageActivity());
            this.gmz.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.gnq != null && this.gmz != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bOF().pageContext.getPageActivity()) * 0.7f);
            int i = com.baidu.live.ab.b.i(false, false);
            if (this.gnS.indexOfChild(this.gmz) < 0) {
                if (this.gmz.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gmz.getParent()).removeView(this.gmz);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.live.ab.b.c(false, false, false));
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.live.ab.b.cC(false);
                this.gnS.addView(this.gmz, layoutParams);
            }
            if (this.gmz.indexOfChild(this.gnq.Jf().getView()) < 0) {
                if (this.gnq.Jf().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gnq.Jf().getView()).removeView(this.gnq.Jf().getView());
                }
                this.gmz.addView(this.gnq.Jf().getView(), new FrameLayout.LayoutParams(equipmentWidth, i));
            }
            if (bOF().gxf.indexOfChild(this.gnq.Jg().getView()) < 0) {
                if (this.gnq.Jg().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gnq.Jg().getView().getParent()).removeView(this.gnq.Jg().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bOh();
                bOF().gxf.addView(this.gnq.Jg().getView(), layoutParams2);
            }
            r LC = bOF().gxe.LC();
            if (LC != null && LC.mLiveInfo != null) {
                this.gnq.setLogData(LC.mLiveInfo.feed_id, JY());
            }
            this.gnq.a(String.valueOf(bOF().gxe.LC().mLiveInfo.group_id), String.valueOf(bOF().gxe.LC().mLiveInfo.last_msg_id), String.valueOf(bOF().gxe.LC().aDE.userId), String.valueOf(bOF().gxe.LC().mLiveInfo.live_id), bOF().gxe.LC().aDE.appId, (LC == null || LC.aEq == null || !LC.aEq.Co()) ? false : true);
            lG(false);
        }
    }

    private void bNw() {
        if (this.gmn == null) {
            this.gmn = new com.baidu.tieba.ala.liveroom.o.a(bOF().pageContext, false, this);
        }
        this.gmn.c(this.gnR, bOF().gxe.LC());
        this.gmn.a(this.gmS);
        this.gmn.setOtherParams(JY());
    }

    private void bNx() {
        if (this.gmm == null) {
            this.gmm = new com.baidu.tieba.ala.liveroom.audiencelist.c(bOF().pageContext, this, false);
        }
        this.gmm.a(String.valueOf(bOF().gxe.LC().mLiveInfo.group_id), String.valueOf(bOF().gxe.LC().mLiveInfo.live_id), String.valueOf(bOF().gxe.LC().aDE.userId), bOF().gxe.LC());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.gnc != null && this.gnc.getView() != null && this.gnc.getView().getParent() != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.gmm.c(this.gnR, i, a.g.ala_liveroom_audience_count_layout);
            this.gmm.e(bOF().gxe.bIv());
            this.gmm.setOtherParams(JY());
        }
    }

    private void bNy() {
        com.baidu.live.core.a.a KO;
        if (this.gnb == null) {
            this.gnb = new com.baidu.tieba.ala.liveroom.operation.a(bOF().pageContext);
        }
        this.gnb.a(bOF(), this.gnS, bOF().gxe.LC().mLiveInfo, true, this.gmS);
        this.gnb.setOtherParams(JY());
        if (this.gnA != null && (KO = this.gnA.KO()) != null) {
            View rootLayout = KO.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.gnb.bO(rootLayout);
        }
    }

    public void lN(boolean z) {
        if (this.gnb != null) {
            this.gnb.lN(z);
        }
    }

    private void bNB() {
        if (this.gmq == null) {
            this.gmq = new com.baidu.tieba.ala.liveroom.audiencelist.b(bOF().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (bOF().gxe.bIv() != null) {
            j = bOF().gxe.bIv().getCount();
        }
        this.gmq.a(this.gmS);
        this.gmq.a(this.gnR, a.g.ala_liveroom_hostheader, j);
        this.gmq.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.gmq.lR(false);
        } else {
            this.gmq.lR(true);
        }
    }

    protected void FS(String str) {
        if (this.gof == null) {
            this.gof = new com.baidu.tieba.ala.liveroom.t.b(bOF().pageContext);
        }
        this.gof.b(this.gnS, str);
        lI(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.13
            @Override // java.lang.Runnable
            public void run() {
                d.this.gof.bWi();
                d.this.lI(false);
            }
        }, 5000L);
    }

    private void lO(boolean z) {
        CustomResponsedMessage runTask;
        if (bOF().gxe.LC().mLiveInfo.live_type == 1 && this.goP) {
            if (this.goN == null && (runTask = MessageManager.getInstance().runTask(2913074, e.class, bOF().pageContext)) != null && runTask.getData() != null) {
                this.goN = (e) runTask.getData();
            }
            if (this.goN != null) {
                if (this.gmu == null) {
                    this.gmu = this.goN.a(bOF().pageContext);
                }
                if (bOF().gxe.LC().mLiveInfo.challengeId > 0 && !this.gmu.BQ()) {
                    this.gmu.e(bOF().gxe.LC().mLiveInfo.live_id, bOF().gxe.LC().aDE.userId);
                    lP(z);
                    if (z) {
                        this.gmu.a(bOF().gxe.bUX());
                    }
                    this.gmu.c(bOF().gxe.LC());
                }
            }
        }
    }

    private void lP(boolean z) {
        if (this.gmv == null) {
            this.gmv = this.goN.b(bOF().pageContext);
            this.gmv.a(new com.baidu.live.challenge.g() { // from class: com.baidu.tieba.ala.liveroom.d.d.14
                @Override // com.baidu.live.challenge.g
                public void BF() {
                    d.this.bOF().gxf.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.g
                public void a(ap apVar, at atVar, at atVar2) {
                    d.this.goO = true;
                    if (d.this.gni != null) {
                        d.this.gni.setPraiseEnable(false);
                        d.this.bOF().gxf.gLW = false;
                    }
                    if (d.this.gnj != null) {
                        d.this.gnj.bWv();
                    }
                    if (d.this.gmr != null) {
                        d.this.gmr.setCanVisible(false);
                        d.this.gmr.bRR();
                    }
                    if (d.this.gms != null) {
                        d.this.gms.lz(true);
                    }
                    if (d.this.gog != null) {
                        d.this.gog.setVisible(8);
                    }
                    if (d.this.gmt != null) {
                        d.this.gmt.setCanVisible(false);
                        d.this.gmt.setVisible(8);
                    }
                    d.this.bOS();
                    d.this.bOT();
                    d.this.bOU();
                    d.this.bOV();
                    d.this.bOW();
                    if (d.this.bOF().bel != null) {
                        d.this.bOF().bel.getLivePlayer().setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                    }
                    if (d.this.gng != null) {
                        d.this.gng.setTimeTextMode(true);
                    }
                    if (d.this.bei != null && atVar != null && atVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(atVar.aIE);
                        arrayList.add(atVar2.aIE);
                        com.baidu.live.liveroom.a.c cVar = d.this.bei;
                        if (d.this.goc) {
                            arrayList = null;
                        }
                        cVar.o(arrayList);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void BG() {
                }

                @Override // com.baidu.live.challenge.g
                public void BH() {
                }

                @Override // com.baidu.live.challenge.g
                public void bc(boolean z2) {
                    d.this.bOF().gxf.setSwipeClearEnable(true);
                    d.this.goO = false;
                    if (d.this.gni != null) {
                        d.this.gni.setPraiseEnable(true);
                        d.this.bOF().gxf.gLW = true;
                    }
                    if (d.this.gnj != null) {
                        d.this.gnj.bWw();
                    }
                    if (d.this.gmr != null) {
                        d.this.gmr.setCanVisible(true);
                        d.this.gmr.v(d.this.bOF().gxe.LC());
                    }
                    if (d.this.gnl != null) {
                        d.this.gnl.mI(true);
                    }
                    if (d.this.gms != null) {
                        d.this.gms.lz(false);
                    }
                    if (d.this.gog != null) {
                        d.this.gog.setVisible(0);
                    }
                    if (d.this.gmt != null) {
                        d.this.gmt.setCanVisible(true);
                        d.this.gmt.setVisible(0);
                    }
                    d.this.bOS();
                    d.this.bOT();
                    d.this.bOU();
                    d.this.bOV();
                    d.this.bOW();
                    if (d.this.bei != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.bOF().gxe.bVM());
                        com.baidu.live.liveroom.a.c cVar = d.this.bei;
                        if (d.this.goc) {
                            arrayList = null;
                        }
                        cVar.o(arrayList);
                    }
                    if (d.this.bOF().bel != null) {
                        d.this.bOF().bel.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
                    }
                    if (d.this.gng != null) {
                        d.this.gng.setTimeTextMode(false);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void bd(boolean z2) {
                    if (z2 && d.this.gnM != null) {
                        d.this.gnM.onClose();
                    }
                }
            });
        }
        this.gmv.a(this.gmu);
        this.gmv.l(bOF().gxd.getLiveContainerView());
        this.gmv.b(z, false, false);
        this.gmu.a((i.c) this.gmv);
    }

    public void bNC() {
        this.gnd.c(bOF().gxe.LC(), false);
    }

    public void bND() {
        if (bOF().gxe.LC() != null && bOF().gxe.LC().aDE != null && bOF().gxe.LC().mLiveInfo != null) {
            if (this.gmp == null) {
                this.gmp = new com.baidu.tieba.ala.liveroom.u.b(bOF().pageContext);
            }
            long j = bOF().gxe.LC().aDE.userId;
            int i = bOF().gxe.LC().mLiveInfo.live_type;
            String str = bOF().gxe.LC().aDE.portrait;
            String str2 = bOF().gxe.LC().mLiveInfo.feed_id;
            long j2 = bOF().gxe.LC().mLiveInfo.live_id;
            this.gmp.a(i, j, bOF().gxe.LC().aDE.userName, false, str, JY(), str2, j2);
            this.gmp.as(this.gnR);
        }
    }

    private int bOY() {
        return (this.gmv != null ? this.gmv.be(false) : 0) + bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNE() {
        if (bOF() == null || bOF().gxe == null || bOF().gxe.LC() == null || bOF().gxe.LC().aEd == null) {
            if (bOF().gxe == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bOF().gxe.LC() == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bOF().gxe.LC().aEd == null) {
                Log.i("RenameLog", "getLiveContext().liveModel.getLiveShowData().mLoginUserInfo == null");
                return;
            } else {
                return;
            }
        }
        String str = bOF().gxe.LC().aEd.userName;
        Log.i("RenameLog", "loginUserName:" + str);
        if (str != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bOF().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !bOa()) {
            com.baidu.live.c.AD().putInt("guide_rename_show_count", com.baidu.live.c.AD().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.KQ().bX(true);
            if (this.gnJ == null) {
                this.gnJ = new com.baidu.tieba.ala.liveroom.v.a(bOF().pageContext);
            }
            this.gnJ.setOtherParams(JY());
            this.gnJ.e(this.gnS, bOF().gxe.LC());
            lI(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.16
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gnJ.bWm();
                    d.this.lI(false);
                }
            }, 5000L);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_SHOW);
                alaStaticItem.addParams("other_params", JY());
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    private void bNF() {
        boolean z = true;
        if (this.gnl == null) {
            this.gnl = new com.baidu.tieba.ala.liveroom.x.a(bOF().pageContext, this);
        }
        this.gnl.d(bOF().gxf, false);
        AlaLiveInfoData alaLiveInfoData = bOF().gxe.LC().mLiveInfo;
        if (alaLiveInfoData != null) {
            boolean z2 = bOE() && alaLiveInfoData.screen_direction != 2;
            boolean isZanAnimUnabled = alaLiveInfoData.mAlaLiveSwitchData != null ? alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled() : false;
            if (!z2 || isZanAnimUnabled) {
                z = false;
            }
            this.gnl.mH(z);
        }
    }

    private void bNH() {
        if (this.gnZ || this.goa) {
            if ((TbadkCoreApplication.isLogin() && this.gnq.Jg().hasText()) || this.goa) {
                this.gnZ = false;
                this.goa = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.17
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bOg();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void bNz() {
        bNA();
    }

    private void bNA() {
        if (this.gnb != null) {
            int i = bOF().gxe.LC().aEd.isUegBlock;
            int i2 = bOF().gxe.LC().aEd.isBlock;
            String str = bOF().gxe.LC().aEd.userName;
            if (i > 0 || i2 > 0) {
                this.gnb.b(true, i, i2, str);
                this.gnq.a(true, i, i2, str);
                this.gnw.b(true, i, i2, str);
                return;
            }
            this.gnb.b(false, i, i2, str);
            this.gnq.a(false, i, i2, str);
            this.gnw.b(false, i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void r(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        super.r(aVar);
        if (this.gms != null) {
            this.gms.y(aVar);
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
        if ((aVar.getMsgType() == 12 || aVar.getMsgType() == 13) && jSONObject != null) {
            String optString = jSONObject.optString("content_type");
            if ("task".equals(optString)) {
                if (this.gmr != null) {
                    this.gmr.I(jSONObject);
                }
            } else if ("enter_live".equals(optString)) {
                if (this.gmq != null && this.gmq.getCount() > 20) {
                    this.gmq.dO(this.gmq.getCount() + 1);
                } else if (this.gmm != null) {
                    com.baidu.live.data.a JK = aVar.JK();
                    com.baidu.live.data.j jVar = new com.baidu.live.data.j();
                    jVar.aDF = new AlaLocationData();
                    jVar.aDG = new AlaRelationData();
                    jVar.aDE = new AlaLiveUserInfoData();
                    jVar.aDE.userId = JavaTypesHelper.toLong(JK.userId, 0L);
                    jVar.aDE.userName = JK.userName;
                    jVar.aDE.portrait = JK.portrait;
                    if (this.gmq != null && this.gmm.c(jVar)) {
                        this.gmq.dO(this.gmq.getCount() + 1);
                    }
                }
            } else if ("update_liveinfo".equals(optString)) {
                if (bOF().gxe.LC() != null && bOF().gxe.LC().mLiveInfo != null) {
                    bOF().gxe.a(bOF().gxe.LC().mLiveInfo.live_id, bOF().fromType, bOF().enterTime);
                }
            } else if ("challenge_mvp".equals(optString) && bOF().gxe.LC() != null && bOF().gxe.LC().mLiveInfo != null && bOF().gxe.LC().aEd != null && this.gmv != null) {
                long optLong = jSONObject.optLong("mvp_user_id");
                long optLong2 = jSONObject.optLong("winner_live_id");
                if (optLong == bOF().gxe.LC().aEd.userId && optLong2 == bOF().gxe.LC().mLiveInfo.live_id) {
                    this.gmv.c(jSONObject.optInt("challenge_status"), jSONObject.optLong("challenge_id"));
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void FN(String str) {
        if (this.gms != null) {
            this.gms.FN(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void cd(boolean z) {
        super.cd(z);
        if (bOF().gxf != null) {
            bOF().gxf.bXj();
            bOF().gxf.setLiveViewOnDispatchTouchEventListener(null);
            bOF().gxf.setLiveViewOnTouchEventListener(null);
            bOF().gxf.setOnLiveViewScrollListener(null);
        }
        if (bOF().bel != null) {
            bOF().bel.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.gmv != null) {
            this.gmv.BB();
        }
        bNI();
        if (this.gmp != null) {
            this.gmp.BB();
        }
        if (this.gnl != null) {
            this.gnl.release();
        }
        if (this.gmr != null) {
            this.gmr.BB();
        }
        if (this.gnb != null) {
            this.gnb.bVT();
        }
        if (this.gmo != null) {
            this.gmo.bQM();
            this.gmo.setVisible(8);
        }
        if (this.gmt != null) {
            this.gmt.BB();
        }
        if (this.gms != null) {
            this.gms.release();
        }
        if (this.bhH != null) {
            this.bhH.removeAllViews();
            this.bhH = null;
        }
        if (this.goM != null) {
            this.goM.removeAllViews();
            this.goM = null;
        }
        if (this.gnl != null) {
            this.gnl.onDestroy();
        }
        if (this.gmu != null) {
            this.gmu.BB();
        }
        if (this.gmH != null) {
            this.gmH.cancel();
        }
        if (this.gog != null) {
            this.gog.bPJ();
        }
        if (this.gmH != null) {
            this.gmH.BB();
        }
        if (this.gnQ != null) {
            this.gnQ.BB();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cb(boolean z) {
        super.cb(z);
        bNI();
        if (this.gmn != null) {
            this.gmn.onDestroy();
        }
        if (this.gmp != null) {
            this.gmp.onDestroy();
        }
        if (this.gmr != null) {
            this.gmr.onDestroy();
        }
        if (this.gmt != null) {
            this.gmt.onDestroy();
        }
        if (this.gmu != null) {
            this.gmu.onDestroy();
        }
        if (this.gmv != null) {
            this.gmv.onDestroy();
        }
        if (this.gmw != null) {
            this.gmw.onDestroy();
        }
        if (this.gny != null) {
            this.gny.onDestroy();
        }
        if (this.gmo != null) {
            this.gmo.onDestroy();
        }
        if (this.gmm != null) {
            this.gmm.onDestroy();
        }
        if (this.gnq != null) {
            this.gnq.onDestroy();
        }
        if (this.gnb != null) {
            this.gnb.onDestory();
        }
        if (this.gms != null) {
            this.gms.release();
        }
        if (this.gog != null) {
            this.gog.cb(!z);
        }
        if (this.gmH != null) {
            this.gmH.onDestroy();
            this.gmH = null;
        }
        if (this.gnQ != null) {
            this.gnQ.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.gmI);
        MessageManager.getInstance().removeMessageRule(this.gmJ);
        MessageManager.getInstance().unRegisterListener(this.gmL);
        MessageManager.getInstance().unRegisterListener(this.gmM);
        MessageManager.getInstance().unRegisterListener(this.gmN);
        MessageManager.getInstance().unRegisterListener(this.gmP);
        MessageManager.getInstance().unRegisterListener(this.gmQ);
        MessageManager.getInstance().unRegisterListener(this.goQ);
        MessageManager.getInstance().unRegisterListener(this.gmR);
        MessageManager.getInstance().unRegisterListener(this.gmO);
    }

    private void bNI() {
        if (this.gnq != null && this.gnq.Jf().getView() != null && this.gnq.Jf().getView().getParent() != null) {
            ((ViewGroup) this.gnq.Jf().getView().getParent()).removeView(this.gnq.Jf().getView());
        }
        if (this.gmz != null && this.gmz.getParent() != null) {
            ((ViewGroup) this.gmz.getParent()).removeView(this.gmz);
        }
        if (this.gnq != null && this.gnq.Jg().getView() != null) {
            this.gnS.removeView(this.gnq.Jg().getView());
        }
        if (this.gnq != null) {
            this.gnq.Jf().setMsgData(new LinkedList());
            this.gnq.Bb();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void a(ah ahVar) {
        if (this.gnq != null) {
            bOg();
            this.gnq.Jg().setEditText(" @" + ahVar.getNameShow() + " ");
        }
        if (this.gnb != null) {
            this.gnb.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void g(com.baidu.live.data.a aVar) {
        if (this.gnq != null) {
            bOg();
            this.gnq.Jg().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.gnb != null) {
            this.gnb.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void b(ah ahVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected View bNJ() {
        if (this.gnq != null) {
            return this.gnq.Jg().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean bNK() {
        if (this.gnq == null || !this.gnq.Jg().Ky()) {
            return false;
        }
        lG(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected boolean bNL() {
        return this.gmn == null || this.gmn.bNL();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    /* renamed from: bOZ */
    public PendantParentView bNM() {
        return this.bhH;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected ViewGroup bNN() {
        return this.goM;
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
                    this.gnW = false;
                    K(intExtra, intExtra2, intExtra3);
                    return;
                }
                bNC();
                return;
            }
            aob();
        } else if (i == 25051 && i2 == -1 && this.gog != null) {
            this.gog.bRI();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.gnq != null && this.gnq.Jf() != null) {
            this.gnq.Jf().onKeyboardVisibilityChanged(z);
        }
        if (z || this.gnq == null || this.gnq.Jg() == null || !this.gnq.Jg().Ky()) {
            if (z) {
                if (this.gnb != null) {
                    this.gnb.setVisibility(8);
                }
                if (this.gns != null && this.gns.EE() != null) {
                    this.gns.EE().setVisibility(8);
                }
                bNP();
                if (this.gnq != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gnq.Jg().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.gnq.Jg().getView().setLayoutParams(layoutParams);
                    this.gnq.Jg().getView().setVisibility(0);
                    this.gnq.Jg().setQuickInputPanelVisible(false);
                }
                if (this.gnR != null) {
                    this.gnR.setVisibility(8);
                }
                if (this.gms != null) {
                    this.gms.setVisible(8);
                }
                if (this.gnr != null) {
                    this.gnr.Ba();
                }
                if (this.gnP != null) {
                    this.gnP.setCanVisible(false);
                }
                if (this.gnL != null) {
                    this.gnL.setCanVisible(false);
                }
            } else {
                bNO();
            }
            bOT();
            if (this.gnD != null) {
                this.gnD.bk(z);
            }
        }
    }

    private void bNO() {
        if (this.gnb != null) {
            this.gnb.setVisibility(0);
        }
        if (this.gmz != null) {
            if (this.goS) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gmz.getLayoutParams();
                layoutParams.bottomMargin = (J(false, false) - bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) + com.baidu.live.ab.b.Pf();
                this.gmz.setLayoutParams(layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gmz.getLayoutParams();
                layoutParams2.bottomMargin = bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
                this.gmz.setLayoutParams(layoutParams2);
            }
        }
        if (this.gnq != null) {
            bOh();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gnq.Jg().getView().getLayoutParams();
            layoutParams3.bottomMargin = 0;
            this.gnq.Jg().getView().setLayoutParams(layoutParams3);
        }
        if (this.gnb != null) {
            this.gnb.setVisibility(0);
        }
        if (this.gns != null && this.gns.EE() != null) {
            this.gns.EE().setVisibility(0);
        }
        if (this.gnR != null) {
            this.gnR.setVisibility(0);
        }
        if (this.gms != null) {
            this.gms.setVisible(0);
        }
        if (this.gnr != null) {
            this.gnr.Ba();
        }
        if (this.gnP != null) {
            this.gnP.setCanVisible(true);
        }
        if (this.gnL != null) {
            this.gnL.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNP() {
        boolean z;
        boolean z2 = false;
        if (this.gmz != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gmz.getLayoutParams();
            if (this.gnq == null || this.gnq.Jg() == null) {
                z = false;
            } else {
                z = this.gnq.Jg().Kw();
                z2 = this.gnq.Jg().Kx();
            }
            int J = J(z, z2);
            if (layoutParams.bottomMargin != J) {
                layoutParams.bottomMargin = J;
                this.gmz.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lG(boolean z) {
        this.goR = z;
        if (z) {
            this.gnq.Jg().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gmz.getLayoutParams();
            int quickInputPanelExpandHeight = this.gnq.Jg().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.gmz.setLayoutParams(layoutParams);
                if (this.gnq.Jf() != null) {
                    this.gnq.Jf().Je();
                    return;
                }
                return;
            }
            return;
        }
        bNO();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.gmm != null) {
                this.gmm.dz(i3);
            }
            if (this.gmo != null) {
                this.gmo.dz(i3);
            }
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public boolean ey(int i) {
        boolean ey = super.ey(i);
        if (ey && 2 == i) {
            if (this.gmn.bNL()) {
                return false;
            }
            if (ey && this.gnl != null) {
                this.gnl.mI(false);
            }
        }
        return ey;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void tQ(int i) {
        super.tQ(i);
        if (i == 7 || i == 11) {
            if (this.gnb != null) {
                this.gnb.setVisibility(8);
            }
            if (this.gnq != null) {
                this.gnq.Jf().getView().setVisibility(4);
            }
            if (this.gms != null) {
                this.gms.bI(2, 8);
                if (this.goO) {
                    this.gms.bI(1, 8);
                }
            }
            if (this.gnG != null) {
                this.gnG.mD(false);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public void ez(int i) {
        super.ez(i);
        if (i == 7 || i == 11) {
            if (this.gnb != null) {
                this.gnb.setVisibility(0);
            }
            if (this.gnq != null) {
                this.gnq.Jf().getView().setVisibility(0);
            }
            if (this.gms != null) {
                this.gms.setVisible(0);
            }
            if (this.gnG != null) {
                this.gnG.mD(true);
            }
            this.gnR.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.gmp != null) {
            this.gmp.bWk();
        }
        if (this.gmu != null) {
            this.gmu.BJ();
        }
        if (this.gms != null) {
            this.gms.onStop();
        }
        if (this.gmt != null) {
            this.gmt.bb(true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.gmp != null) {
            this.gmp.bWj();
        }
        if (this.gmu != null && this.goP) {
            this.gmu.BK();
        }
        if (this.gms != null) {
            this.gms.onStart();
        }
        if (this.gmt != null) {
            this.gmt.bb(false);
        }
    }
}
