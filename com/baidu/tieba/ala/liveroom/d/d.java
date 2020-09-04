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
    private PendantParentView bhK;
    private com.baidu.tieba.ala.liveroom.c.a gmA;
    private FrameLayout gmD;
    private com.baidu.tieba.ala.liveroom.j.b gmL;
    private com.baidu.tieba.ala.liveroom.audiencelist.c gmq;
    private com.baidu.tieba.ala.liveroom.o.a gmr;
    private com.baidu.tieba.ala.liveroom.g.b gms;
    private com.baidu.tieba.ala.liveroom.u.b gmt;
    private com.baidu.tieba.ala.liveroom.audiencelist.b gmu;
    private com.baidu.tieba.ala.liveroom.l.a gmv;
    private com.baidu.tieba.ala.liveroom.activeview.b gmw;
    private com.baidu.live.d.a gmx;
    private i gmy;
    private h gmz;
    private LinearLayout goQ;
    private e goR;
    private boolean goS;
    private long lastClickTime = 0;
    private boolean goT = false;
    private HttpRule gmM = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.gmy != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.gmy.BP()) {
                httpMessage.addParam("ala_challenge_id", d.this.gmy.BS());
            }
            return httpMessage;
        }
    };
    private HttpRule gmN = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.gmy != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.gmy.BP()) {
                httpMessage.addParam("challenge_id", d.this.gmy.BS());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c gmO = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.d.18
        @Override // com.baidu.live.liveroom.g.c
        public void LA() {
            if (d.this.gnp != null) {
                d.this.gnp.mK(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void ce(boolean z) {
            if (z) {
                if (d.this.gnp != null) {
                    d.this.gnp.mK(true);
                }
            } else if (d.this.gnp != null) {
                d.this.gnp.mK(false);
            }
            if (d.this.gnH != null) {
                d.this.gnH.bl(z);
            }
            if (d.this.gmw != null) {
                d.this.gmw.lD(z ? false : true);
            }
        }
    };
    private HttpMessageListener gmP = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.d.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.LK() != null) {
                        com.baidu.live.w.c.Np().bkl = getQuickGiftHttpResponseMessage.LK();
                        d.this.bNu();
                    }
                }
            }
        }
    };
    private CustomMessageListener gmQ = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.d.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.bNF();
        }
    };
    CustomMessageListener gmV = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.d.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.gmL.c(d.this.bOG());
                } else if (d.this.bOb() || !g.ud(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.22.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.bOG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.bOG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    d.this.gmL.b(d.this.gmD, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener goU = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.d.d.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.bOb() || !g.ud(2913128)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.23.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.ub(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    d.this.FT(str);
                }
            }
        }
    };
    private CustomMessageListener gmR = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.d.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.gnx.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gmS = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.this.gnL != null) {
                    d.this.gnL.Go(str);
                }
            }
        }
    };
    CustomMessageListener gmT = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.goc != null && d.this.goc.aXV != null && !d.this.goc.aXY && !d.this.goc.aXZ && d.this.gnG != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.bOG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = d.this.bOG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                d.this.gnG.b(d.this.gmD, layoutParams);
                if (com.baidu.live.guardclub.e.Il() != null) {
                    com.baidu.live.guardclub.e.Il().Ir();
                }
            }
        }
    };
    private CustomMessageListener gmU = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.gnJ != null) {
                    d.this.gnJ.dismiss();
                }
                if (d.this.gnL != null) {
                    d.this.gnL.dismiss();
                }
                com.baidu.live.im.b.d.JD().setSwitchStatus(true);
                com.baidu.live.im.b.d.JD().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bOh();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gmW = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.d.15
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
                        alaStaticItem.addParams("gifts_value", com.baidu.live.w.c.Np().bkl.EN().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.w.c.Np().bkl.EN().DR());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.w.c.Np().bkl.EN().DS());
                        if (d.this.bOG().gxi.LC() != null && d.this.bOG().gxi.LC().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.bOG().gxi.LC().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.bOG().gxi.LC().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.JY());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.Hu()) {
                        if (com.baidu.live.c.AD().getBoolean("quick_gift_guide_show", true) && !d.this.bOb()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, z.class, d.this.bOG().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                z zVar = (z) runTask.getData();
                                zVar.setPageContext(d.this.bOG().pageContext);
                                zVar.d(d.this.bOG().gxi.LC());
                                zVar.setGiftItem(com.baidu.live.w.c.Np().bkl.EN());
                                zVar.setOtherParams(d.this.JY());
                                zVar.initView();
                                zVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.d.d.15.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        d.this.lK(false);
                                    }
                                });
                                zVar.show();
                                d.this.lK(true);
                                return;
                            }
                            return;
                        }
                        n.a(d.this.bOG().pageContext, d.this.bOG().gxi.LC(), com.baidu.live.w.c.Np().bkl.EN(), d.this.JY());
                    }
                } else if (i == 1) {
                    if (d.this.gnu != null) {
                        d.this.bOh();
                    }
                } else if (i == 3 && d.this.Hu()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    d.this.gnh.c(d.this.bOG().gxi.LC(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.bOG() != null && d.this.bOG().gxi != null && d.this.bOG().gxi.LC() != null && d.this.bOG().gxi.LC().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.bOG().gxi.LC().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.bOG().gxi.LC().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.bOG().gxi.LC().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.JY());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.bOG() != null && d.this.bOG().gxi != null && d.this.bOG().gxi.LC() != null && d.this.bOG().gxi.LC().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.bOG().gxi.LC().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.bOG().gxi.LC().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.bOG().gxi.LC().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.JY());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.bek != null) {
                        d.this.bek.bY(false);
                    }
                } else if (i == 12) {
                    if (d.this.gnp != null && d.this.bOG().gxi.LC() != null && d.this.bOG().gxi.LC().mLiveInfo != null) {
                        String valueOf = String.valueOf(d.this.bOG().gxi.LC().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.bOG().gxi.LC().mLiveInfo.room_id);
                        String str3 = null;
                        p pVar = d.this.bOG().gxi.LC().mLiveSdkInfo;
                        if (pVar != null && pVar.mCastIds != null) {
                            str3 = String.valueOf(d.this.bOG().gxi.LC().mLiveSdkInfo.mCastIds.aDY);
                        }
                        d.this.gnp.ai(valueOf, valueOf2, str3);
                        if (com.baidu.live.liveroom.a.KQ().KR()) {
                            d.this.bNF();
                        }
                    }
                } else if (i == 14) {
                    r LC = d.this.bOG().gxi.LC();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.bOG().pageContext.getPageActivity(), LC.aDG.userName, Long.toString(LC.aDG.userId), Long.toString(LC.aDG.charmCount), String.valueOf(LC.mLiveInfo.group_id), String.valueOf(LC.mLiveInfo.live_id), false, String.valueOf(LC.aDG.userId), Long.toString(LC.aEf.userId), LC.aEf.userName, LC.aEf.portrait, d.this.gmu.getCount(), d.this.JY())));
                    LogManager.getCommonLogger().doClickGusetNumLog(LC.mLiveInfo.feed_id, d.this.gmu.getCount() + "", d.this.JY());
                } else if (i == 11) {
                    d.this.bOk();
                    d.this.bOl();
                } else if (i == 16) {
                    if (d.this.bOG() != null && (beVar2 = com.baidu.live.w.a.Nk().bkd) != null && (boVar2 = beVar2.aJA) != null) {
                        String str4 = boVar2.aKw.aKD;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (d.this.bOG().gxi != null && d.this.bOG().gxi.LC() != null && d.this.bOG().gxi.LC().mLiveInfo != null) {
                                j = d.this.bOG().gxi.LC().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", d.this.bOG().gxi.LC().mLiveInfo.room_id + "", d.this.bOG().gxi.LC().mLiveInfo.feed_id, d.this.JY());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.bOG().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (d.this.bOG() != null) {
                        r rVar = null;
                        if (d.this.bOG().gxi != null) {
                            rVar = d.this.bOG().gxi.LC();
                        }
                        if (rVar != null && rVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.w.b.bWy().beU != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.w.b.bWy().beU.aDi;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + rVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + rVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(d.this.bOG().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17 && d.this.Hu() && d.this.bOG() != null && (beVar = com.baidu.live.w.a.Nk().bkd) != null && (boVar = beVar.aJA) != null && (buVar = boVar.aKx) != null && !TextUtils.isEmpty(buVar.webUrl)) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                    if (d.this.gnJ != null && d.this.bOG().gxi != null && d.this.bOG().gxi.LC() != null) {
                        r LC2 = d.this.bOG().gxi.LC();
                        d.this.gnJ.a(buVar.webUrl, LC2.mLiveInfo.live_id, LC2.aEf.userId, LC2.aDG.userId);
                    }
                }
            }
        }
    };
    private boolean goV = false;
    private boolean goW = false;

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.gnj = new com.baidu.tieba.ala.liveroom.guide.c(bOG().pageContext, this, false);
        this.gmM.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.gmM);
        this.gmN.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.gmN);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean bNf() {
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void m(r rVar) {
        super.m(rVar);
        g.bRO();
        this.goT = true;
        this.goW = false;
        this.goV = false;
        bOG().gxj.setIsForceHandledTouch(false);
        bOG().gxj.setSwipeClearEnable(true);
        bOG().gxj.setOnLiveViewScrollListener(this.gmO);
        bOG().gxj.setOnClickListener(null);
        bOG().gxj.setClickable(false);
        if (this.gnm != null) {
            this.gnm.b(this.gmW);
        }
        if (this.gnV != null) {
            this.gnV.setVisibility(0);
        }
        bNl();
        if (this.gnE != null) {
            this.gnE.a(rVar, this.bhK);
            this.gnE.S(this.gnW);
            this.gnE.a(this);
        }
        bOY();
        bNx();
        bNX();
        bNy();
        bNC();
        bNz();
        lL(false);
        bOo();
        bOn();
        bNo();
        bNv();
        bOp();
        bNE();
        bNG();
        bOR();
        bOS();
        lM(false);
        bOy();
        bNn();
        bNu();
        bNp();
        bNq();
        bNr();
        bNs();
        bOu();
        bNh();
        lQ(true);
        bOx();
        c(this.fxx);
        MessageManager.getInstance().registerListener(this.gmP);
        MessageManager.getInstance().registerListener(this.gmQ);
        MessageManager.getInstance().registerListener(this.gmR);
        MessageManager.getInstance().registerListener(this.gmT);
        MessageManager.getInstance().registerListener(this.gmU);
        MessageManager.getInstance().registerListener(this.goU);
        MessageManager.getInstance().registerListener(this.gmV);
        MessageManager.getInstance().registerListener(this.gmS);
        bNI();
        bNB();
    }

    private void bNh() {
        if (this.gnQ != null) {
            this.gnQ.a(new com.baidu.live.r.c() { // from class: com.baidu.tieba.ala.liveroom.d.d.19
                @Override // com.baidu.live.r.c
                public void ck(boolean z) {
                    if (d.this.gmz != null) {
                        d.this.gmz.setNeedCloseRecommendFloat(z);
                    }
                    if (d.this.bOG().gxj.gMa) {
                        if (d.this.gnp != null) {
                            d.this.gnp.mD(z);
                            d.this.gnp.mK(!z);
                        }
                        if (d.this.gnm != null) {
                            d.this.gnm.mD(z);
                            d.this.gnm.setPraiseEnable(!z);
                            d.this.gnm.mC(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(r rVar) {
        super.k(rVar);
        if (this.gmr != null) {
            this.gmr.w(rVar);
        }
        if (this.gms != null) {
            this.gms.s(rVar);
        }
        if (this.gmv != null) {
            this.gmv.v(rVar);
        }
        if (this.gmz != null) {
            this.gmz.a(rVar);
        }
        lQ(false);
        if (this.gmw != null) {
            this.gmw.j(rVar);
            this.gmw.lC(this.gof);
            this.gmw.updateView();
            if (rVar != null && this.gnS != null && !this.gnS.hasInit && !TextUtils.isEmpty(this.gnS.aJU)) {
                this.gnS.hasInit = true;
                this.gmw.FP(this.gnS.aJU);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(k kVar) {
        if (kVar != null) {
            if (this.gmq != null && kVar.getList() != null) {
                this.gmq.e(kVar);
            }
            if (this.gmu != null) {
                this.gmu.dO(kVar.getCount());
            }
        }
    }

    private void bNj() {
        if (this.gno != null) {
            this.gno.aw(bOG().gxh.getLiveContainerView());
        }
    }

    private void bOR() {
        if (this.gmA == null) {
            this.gmA = new com.baidu.tieba.ala.liveroom.c.a(bOG().pageContext);
        }
        if (bOG().gxi != null && bOG().gxi.LC() != null && bOG().gxi.LC().mLiveInfo != null) {
            this.gmA.FQ(String.valueOf(bOG().gxi.LC().mLiveInfo.user_id));
        }
    }

    private void bOS() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (bOG() != null && bOG().gxi != null && bOG().gxi.LC() != null && bOG().gxi.LC().mLiveInfo != null) {
                j = bOG().gxi.LC().mLiveInfo.room_id;
            }
            if (this.gnC == null) {
                this.gnC = new com.baidu.tieba.ala.liveroom.guide.a(bOG().pageContext, j);
            }
            this.gnC.lJ(this.gnY);
            this.gnC.a(new a.InterfaceC0631a() { // from class: com.baidu.tieba.ala.liveroom.d.d.5
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0631a
                public void bPb() {
                    if (d.this.bek != null) {
                        d.this.bek.bY(true);
                    }
                }
            });
            this.gnC.as(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void dD(int i) {
        super.dD(i);
        bNj();
        if (this.gmz != null) {
            this.gmz.dD(i);
        }
    }

    private void bNl() {
        if (this.bhK == null) {
            this.bhK = new PendantParentView(bOG().pageContext.getPageActivity(), this.goS ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            bOG().gxj.addView(this.bhK, new ViewGroup.LayoutParams(-1, -1));
            this.bhK.setDefaultItemMargin(bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.bhK.setPadding(bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20), 0, bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6), 0);
            bOT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOT() {
        int dimensionPixelSize;
        if (this.bhK != null) {
            this.bhK.setModel(this.goS ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            int dimensionPixelSize2 = bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds220);
            int dimensionPixelSize3 = bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            if (this.goS) {
                dimensionPixelSize = bOZ();
            } else {
                dimensionPixelSize = bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200);
            }
            this.bhK.setPosition(dimensionPixelSize2, 0, dimensionPixelSize, dimensionPixelSize3);
            return;
        }
        bNl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOU() {
        if (bOG().gxj != null && !this.goW) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.6
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.gmD != null && d.this.gnu != null && d.this.gnu.Jf() != null && d.this.gnu.Jf().getView() != null) {
                        if (d.this.goS && !d.this.gnZ && d.this.bOG().gxj != null && d.this.bOG().gxj.getHeight() > 0) {
                            int be = d.this.gmz != null ? d.this.gmz.be(false) : 0;
                            ViewGroup.LayoutParams layoutParams = d.this.gmD.getLayoutParams();
                            int height = d.this.bOG().gxj.getHeight() - be;
                            int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                i += UtilHelper.getStatusBarHeight();
                            }
                            if (layoutParams != null) {
                                layoutParams.height = i + d.this.bOG().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height);
                                d.this.gmD.setLayoutParams(layoutParams);
                                ViewGroup.LayoutParams layoutParams2 = d.this.gnu.Jf().getView().getLayoutParams();
                                if (layoutParams2 != null) {
                                    layoutParams2.height = layoutParams.height - com.baidu.live.ab.b.cE(false);
                                    d.this.gnu.Jf().getView().setLayoutParams(layoutParams2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        int i2 = com.baidu.live.ab.b.i(false, d.this.gnZ);
                        if (d.this.gnW.indexOfChild(d.this.gmD) != -1 && d.this.gmD.getLayoutParams() != null) {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) d.this.gmD.getLayoutParams();
                            layoutParams3.height = com.baidu.live.ab.b.c(false, false, d.this.gnZ);
                            d.this.gmD.setLayoutParams(layoutParams3);
                        }
                        if (d.this.gmD.indexOfChild(d.this.gnu.Jf().getView()) != -1 && d.this.gnu.Jf().getView().getLayoutParams() != null) {
                            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) d.this.gnu.Jf().getView().getLayoutParams();
                            layoutParams4.height = i2;
                            d.this.gnu.Jf().getView().setLayoutParams(layoutParams4);
                        }
                        d.this.gnu.Jf().Je();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOV() {
        if (bOG().gxj != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.7
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.gnw != null) {
                        if (d.this.goS && !d.this.gnZ && d.this.bOG().gxj != null && d.this.bOG().gxj.getHeight() > 0) {
                            int height = (d.this.bOG().gxj.getHeight() - (d.this.gmz != null ? d.this.gmz.be(false) : 0)) + d.this.bOG().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            d.this.gnw.dL(height);
                            return;
                        }
                        d.this.gnw.dL(com.baidu.live.ab.a.a(d.this.bOG().pageContext.getPageActivity(), false, false, d.this.gnZ));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOW() {
        if (bOG().gxj != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.8
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    if (d.this.gnw != null) {
                        int h = com.baidu.live.ab.a.h(false, false);
                        if (!d.this.goS || d.this.bOG().gxj == null || d.this.bOG().gxj.getHeight() <= 0) {
                            i = h;
                        } else {
                            int height = d.this.bOG().gxj.getHeight() - (d.this.gmz != null ? d.this.gmz.be(false) : 0);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            i = height + d.this.bOG().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height);
                        }
                        d.this.gnw.dM(i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOX() {
        if (this.gnv != null && this.gnv.AZ() != null) {
            ViewGroup.LayoutParams layoutParams = this.gnv.AZ().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bOG().pageContext.getResources().getDimensionPixelOffset(this.goS ? a.e.sdk_ds100 : a.e.sdk_ds20);
                this.gnv.AZ().setLayoutParams(layoutParams);
            }
        }
    }

    private void bOY() {
        if (this.goQ == null) {
            this.goQ = new LinearLayout(bOG().pageContext.getPageActivity());
            this.goQ.setOrientation(1);
        }
        if (this.goQ.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds160);
            layoutParams.leftMargin = bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bOG().gxj.addView(this.goQ, layoutParams);
        }
    }

    private void bNo() {
        if (this.gnl != null && bOG() != null && bOG().gxi != null) {
            this.gnl.b(bOG().gxh.getLiveContainerView(), bOG().gxi.LC());
        }
    }

    private void bNn() {
        if (this.gmw == null) {
            this.gmw = new com.baidu.tieba.ala.liveroom.activeview.b(bOG().pageContext);
        }
        if (bOG() != null && bOG().gxi != null) {
            this.gmw.FM(bOG().gxi.bVR());
        }
        this.gmw.lB(this.goS);
        this.gmw.setOtherParams(JY());
        this.gmw.b(bOG().gxi.LC(), false);
        this.gmw.setHost(false);
        this.gmw.lC(this.gof);
        this.gmw.a(1, this.bhK);
        this.gmw.a(2, this.bhK);
        this.gmw.setVisible(this.gnZ ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNu() {
        if (this.gnf == null) {
            bNz();
        }
        this.gnf.setOtherParams(JY());
        this.gnf.a(com.baidu.live.w.c.Np().bkl, bOG().gxi.LC());
    }

    private void bNp() {
        if (this.gmv == null) {
            this.gmv = new com.baidu.tieba.ala.liveroom.l.a(bOG().pageContext, this);
        }
        this.gmv.setOtherParams(JY());
        this.gmv.a((ViewGroup) this.bhK, bNt());
        this.gmv.v(bOG().gxi.LC());
    }

    private void bNq() {
        if (this.gnG == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, j.class, bOG().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gnG = (j) runTask.getData();
            } else {
                return;
            }
        }
        this.gnG.setOtherParams(JY());
        if (this.gmD != null && this.gmD.indexOfChild(this.gnG.getView()) >= 0) {
            this.gmD.removeView(this.gnG.getView());
        }
    }

    private void bNr() {
        if (this.gnf != null) {
            this.gnf.a(new a.InterfaceC0637a() { // from class: com.baidu.tieba.ala.liveroom.d.d.9
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0637a
                public void bK(int i, int i2) {
                    r LC = d.this.bOG().gxi.LC();
                    if (LC != null && LC.mLiveInfo != null) {
                        if (d.this.gnK == null) {
                            d.this.gnK = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.bOG().pageContext.getPageActivity());
                        }
                        d.this.gnK.d(d.this.gnW, i, i2);
                        d.this.gnK.a(String.valueOf(LC.mLiveInfo.live_id), new a.InterfaceC0641a() { // from class: com.baidu.tieba.ala.liveroom.d.d.9.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0641a
                            public void a(float f, String str) {
                                if (d.this.gnf != null) {
                                    d.this.gnf.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0637a
                public void bL(int i, int i2) {
                    if (d.this.gnK != null) {
                        d.this.gnK.bQ(i, i2);
                    }
                }
            });
        }
    }

    private void bNs() {
        if (this.gok == null) {
            this.gok = new com.baidu.tieba.ala.liveroom.j.e(bOG().pageContext);
        }
        this.gok.setRoomId(bOG().gxi.LC().mLiveInfo.room_id);
        this.gok.Ge("");
        this.gok.b(bOG().gxi.LC(), this.bhK);
        if (this.gmL == null) {
            this.gmL = new com.baidu.tieba.ala.liveroom.j.b(bOG().pageContext, JY(), this.gok, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.10
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bNR() {
                    d.this.lK(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bNS() {
                    d.this.lK(false);
                }
            });
        }
        this.gmL.setRoomId(bOG().gxi.LC().mLiveInfo.room_id);
        if (this.gmD != null && this.gmD.indexOfChild(this.gmL.getView()) >= 0) {
            this.gmD.removeView(this.gmL.getView());
        }
        if (this.gmL != null) {
            this.gmL.b(bOG());
        }
    }

    private LinearLayout.LayoutParams bNt() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    private void bNv() {
        CustomResponsedMessage runTask;
        if (this.gnu == null && (runTask = MessageManager.getInstance().runTask(2913039, com.baidu.live.im.k.class, bOG().pageContext)) != null && runTask.getData() != null) {
            this.gnu = (com.baidu.live.im.k) runTask.getData();
            this.gnu.setFromMaster(false);
            this.gnu.Jf().getView().setId(a.g.ala_liveroom_msg_list);
            this.gnu.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.11
                @Override // com.baidu.live.im.k.a
                public boolean Ji() {
                    return d.this.Hu();
                }

                @Override // com.baidu.live.im.k.a
                public void Jj() {
                    d.this.god = true;
                }

                @Override // com.baidu.live.im.k.a
                public void gR(String str) {
                    if (!d.this.gnZ) {
                        d.this.lI(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.bOG().pageContext.getPageActivity(), d.this.bOG().gxh.getLiveContainerView());
                    }
                    d.this.FS(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Jk() {
                    if (d.this.gnZ) {
                        d.this.lI(true);
                        d.this.bOG().gxh.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.bOG().pageContext.getPageActivity(), d.this.bOG().gxh.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.gnu != null) {
                        d.this.gnu.Jg().setQuickInputPanelVisible(false);
                        d.this.gnu.Jg().Kz();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Jl() {
                    if (d.this.gnZ) {
                        d.this.bNQ();
                        if (d.this.gnv != null) {
                            d.this.gnv.Ba();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Jm() {
                    return d.this.bOc();
                }

                @Override // com.baidu.live.im.k.a
                public int Jn() {
                    return d.this.bOd();
                }
            });
            this.gmD = new FrameLayout(bOG().pageContext.getPageActivity());
            this.gmD.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.gnu != null && this.gmD != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bOG().pageContext.getPageActivity()) * 0.7f);
            int i = com.baidu.live.ab.b.i(false, false);
            if (this.gnW.indexOfChild(this.gmD) < 0) {
                if (this.gmD.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gmD.getParent()).removeView(this.gmD);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.live.ab.b.c(false, false, false));
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.live.ab.b.cD(false);
                this.gnW.addView(this.gmD, layoutParams);
            }
            if (this.gmD.indexOfChild(this.gnu.Jf().getView()) < 0) {
                if (this.gnu.Jf().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gnu.Jf().getView()).removeView(this.gnu.Jf().getView());
                }
                this.gmD.addView(this.gnu.Jf().getView(), new FrameLayout.LayoutParams(equipmentWidth, i));
            }
            if (bOG().gxj.indexOfChild(this.gnu.Jg().getView()) < 0) {
                if (this.gnu.Jg().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gnu.Jg().getView().getParent()).removeView(this.gnu.Jg().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bOi();
                bOG().gxj.addView(this.gnu.Jg().getView(), layoutParams2);
            }
            r LC = bOG().gxi.LC();
            if (LC != null && LC.mLiveInfo != null) {
                this.gnu.setLogData(LC.mLiveInfo.feed_id, JY());
            }
            this.gnu.a(String.valueOf(bOG().gxi.LC().mLiveInfo.group_id), String.valueOf(bOG().gxi.LC().mLiveInfo.last_msg_id), String.valueOf(bOG().gxi.LC().aDG.userId), String.valueOf(bOG().gxi.LC().mLiveInfo.live_id), bOG().gxi.LC().aDG.appId, (LC == null || LC.aEs == null || !LC.aEs.Co()) ? false : true);
            lI(false);
        }
    }

    private void bNx() {
        if (this.gmr == null) {
            this.gmr = new com.baidu.tieba.ala.liveroom.o.a(bOG().pageContext, false, this);
        }
        this.gmr.c(this.gnV, bOG().gxi.LC());
        this.gmr.a(this.gmW);
        this.gmr.setOtherParams(JY());
    }

    private void bNy() {
        if (this.gmq == null) {
            this.gmq = new com.baidu.tieba.ala.liveroom.audiencelist.c(bOG().pageContext, this, false);
        }
        this.gmq.a(String.valueOf(bOG().gxi.LC().mLiveInfo.group_id), String.valueOf(bOG().gxi.LC().mLiveInfo.live_id), String.valueOf(bOG().gxi.LC().aDG.userId), bOG().gxi.LC());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.gng != null && this.gng.getView() != null && this.gng.getView().getParent() != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.gmq.c(this.gnV, i, a.g.ala_liveroom_audience_count_layout);
            this.gmq.e(bOG().gxi.bIw());
            this.gmq.setOtherParams(JY());
        }
    }

    private void bNz() {
        com.baidu.live.core.a.a KO;
        if (this.gnf == null) {
            this.gnf = new com.baidu.tieba.ala.liveroom.operation.a(bOG().pageContext);
        }
        this.gnf.a(bOG(), this.gnW, bOG().gxi.LC().mLiveInfo, true, this.gmW);
        this.gnf.setOtherParams(JY());
        if (this.gnE != null && (KO = this.gnE.KO()) != null) {
            View rootLayout = KO.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.gnf.bO(rootLayout);
        }
    }

    public void lP(boolean z) {
        if (this.gnf != null) {
            this.gnf.lP(z);
        }
    }

    private void bNC() {
        if (this.gmu == null) {
            this.gmu = new com.baidu.tieba.ala.liveroom.audiencelist.b(bOG().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (bOG().gxi.bIw() != null) {
            j = bOG().gxi.bIw().getCount();
        }
        this.gmu.a(this.gmW);
        this.gmu.a(this.gnV, a.g.ala_liveroom_hostheader, j);
        this.gmu.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.gmu.lT(false);
        } else {
            this.gmu.lT(true);
        }
    }

    protected void FT(String str) {
        if (this.goj == null) {
            this.goj = new com.baidu.tieba.ala.liveroom.t.b(bOG().pageContext);
        }
        this.goj.b(this.gnW, str);
        lK(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.13
            @Override // java.lang.Runnable
            public void run() {
                d.this.goj.bWj();
                d.this.lK(false);
            }
        }, 5000L);
    }

    private void lQ(boolean z) {
        CustomResponsedMessage runTask;
        if (bOG().gxi.LC().mLiveInfo.live_type == 1 && this.goT) {
            if (this.goR == null && (runTask = MessageManager.getInstance().runTask(2913074, e.class, bOG().pageContext)) != null && runTask.getData() != null) {
                this.goR = (e) runTask.getData();
            }
            if (this.goR != null) {
                if (this.gmy == null) {
                    this.gmy = this.goR.a(bOG().pageContext);
                }
                if (bOG().gxi.LC().mLiveInfo.challengeId > 0 && !this.gmy.BQ()) {
                    this.gmy.e(bOG().gxi.LC().mLiveInfo.live_id, bOG().gxi.LC().aDG.userId);
                    lR(z);
                    if (z) {
                        this.gmy.a(bOG().gxi.bUY());
                    }
                    this.gmy.c(bOG().gxi.LC());
                }
            }
        }
    }

    private void lR(boolean z) {
        if (this.gmz == null) {
            this.gmz = this.goR.b(bOG().pageContext);
            this.gmz.a(new com.baidu.live.challenge.g() { // from class: com.baidu.tieba.ala.liveroom.d.d.14
                @Override // com.baidu.live.challenge.g
                public void BF() {
                    d.this.bOG().gxj.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.g
                public void a(ap apVar, at atVar, at atVar2) {
                    d.this.goS = true;
                    if (d.this.gnm != null) {
                        d.this.gnm.setPraiseEnable(false);
                        d.this.bOG().gxj.gMa = false;
                    }
                    if (d.this.gnn != null) {
                        d.this.gnn.bWw();
                    }
                    if (d.this.gmv != null) {
                        d.this.gmv.setCanVisible(false);
                        d.this.gmv.bRS();
                    }
                    if (d.this.gmw != null) {
                        d.this.gmw.lB(true);
                    }
                    if (d.this.gok != null) {
                        d.this.gok.setVisible(8);
                    }
                    if (d.this.gmx != null) {
                        d.this.gmx.setCanVisible(false);
                        d.this.gmx.setVisible(8);
                    }
                    d.this.bOT();
                    d.this.bOU();
                    d.this.bOV();
                    d.this.bOW();
                    d.this.bOX();
                    if (d.this.bOG().ben != null) {
                        d.this.bOG().ben.getLivePlayer().setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                    }
                    if (d.this.gnk != null) {
                        d.this.gnk.setTimeTextMode(true);
                    }
                    if (d.this.bek != null && atVar != null && atVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(atVar.aIG);
                        arrayList.add(atVar2.aIG);
                        com.baidu.live.liveroom.a.c cVar = d.this.bek;
                        if (d.this.gog) {
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
                    d.this.bOG().gxj.setSwipeClearEnable(true);
                    d.this.goS = false;
                    if (d.this.gnm != null) {
                        d.this.gnm.setPraiseEnable(true);
                        d.this.bOG().gxj.gMa = true;
                    }
                    if (d.this.gnn != null) {
                        d.this.gnn.bWx();
                    }
                    if (d.this.gmv != null) {
                        d.this.gmv.setCanVisible(true);
                        d.this.gmv.v(d.this.bOG().gxi.LC());
                    }
                    if (d.this.gnp != null) {
                        d.this.gnp.mK(true);
                    }
                    if (d.this.gmw != null) {
                        d.this.gmw.lB(false);
                    }
                    if (d.this.gok != null) {
                        d.this.gok.setVisible(0);
                    }
                    if (d.this.gmx != null) {
                        d.this.gmx.setCanVisible(true);
                        d.this.gmx.setVisible(0);
                    }
                    d.this.bOT();
                    d.this.bOU();
                    d.this.bOV();
                    d.this.bOW();
                    d.this.bOX();
                    if (d.this.bek != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.bOG().gxi.bVN());
                        com.baidu.live.liveroom.a.c cVar = d.this.bek;
                        if (d.this.gog) {
                            arrayList = null;
                        }
                        cVar.o(arrayList);
                    }
                    if (d.this.bOG().ben != null) {
                        d.this.bOG().ben.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
                    }
                    if (d.this.gnk != null) {
                        d.this.gnk.setTimeTextMode(false);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void bd(boolean z2) {
                    if (z2 && d.this.gnQ != null) {
                        d.this.gnQ.onClose();
                    }
                }
            });
        }
        this.gmz.a(this.gmy);
        this.gmz.l(bOG().gxh.getLiveContainerView());
        this.gmz.b(z, false, false);
        this.gmy.a((i.c) this.gmz);
    }

    public void bND() {
        this.gnh.c(bOG().gxi.LC(), false);
    }

    public void bNE() {
        if (bOG().gxi.LC() != null && bOG().gxi.LC().aDG != null && bOG().gxi.LC().mLiveInfo != null) {
            if (this.gmt == null) {
                this.gmt = new com.baidu.tieba.ala.liveroom.u.b(bOG().pageContext);
            }
            long j = bOG().gxi.LC().aDG.userId;
            int i = bOG().gxi.LC().mLiveInfo.live_type;
            String str = bOG().gxi.LC().aDG.portrait;
            String str2 = bOG().gxi.LC().mLiveInfo.feed_id;
            long j2 = bOG().gxi.LC().mLiveInfo.live_id;
            this.gmt.a(i, j, bOG().gxi.LC().aDG.userName, false, str, JY(), str2, j2);
            this.gmt.as(this.gnV);
        }
    }

    private int bOZ() {
        return (this.gmz != null ? this.gmz.be(false) : 0) + bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNF() {
        if (bOG() == null || bOG().gxi == null || bOG().gxi.LC() == null || bOG().gxi.LC().aEf == null) {
            if (bOG().gxi == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bOG().gxi.LC() == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bOG().gxi.LC().aEf == null) {
                Log.i("RenameLog", "getLiveContext().liveModel.getLiveShowData().mLoginUserInfo == null");
                return;
            } else {
                return;
            }
        }
        String str = bOG().gxi.LC().aEf.userName;
        Log.i("RenameLog", "loginUserName:" + str);
        if (str != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bOG().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !bOb()) {
            com.baidu.live.c.AD().putInt("guide_rename_show_count", com.baidu.live.c.AD().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.KQ().bX(true);
            if (this.gnN == null) {
                this.gnN = new com.baidu.tieba.ala.liveroom.v.a(bOG().pageContext);
            }
            this.gnN.setOtherParams(JY());
            this.gnN.e(this.gnW, bOG().gxi.LC());
            lK(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.16
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gnN.bWn();
                    d.this.lK(false);
                }
            }, 5000L);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_SHOW);
                alaStaticItem.addParams("other_params", JY());
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    private void bNG() {
        boolean z = true;
        if (this.gnp == null) {
            this.gnp = new com.baidu.tieba.ala.liveroom.x.a(bOG().pageContext, this);
        }
        this.gnp.d(bOG().gxj, false);
        AlaLiveInfoData alaLiveInfoData = bOG().gxi.LC().mLiveInfo;
        if (alaLiveInfoData != null) {
            boolean z2 = bOF() && alaLiveInfoData.screen_direction != 2;
            boolean isZanAnimUnabled = alaLiveInfoData.mAlaLiveSwitchData != null ? alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled() : false;
            if (!z2 || isZanAnimUnabled) {
                z = false;
            }
            this.gnp.mJ(z);
        }
    }

    private void bNI() {
        if (this.god || this.goe) {
            if ((TbadkCoreApplication.isLogin() && this.gnu.Jg().hasText()) || this.goe) {
                this.god = false;
                this.goe = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.17
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bOh();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void bNA() {
        bNB();
    }

    private void bNB() {
        if (this.gnf != null) {
            int i = bOG().gxi.LC().aEf.isUegBlock;
            int i2 = bOG().gxi.LC().aEf.isBlock;
            String str = bOG().gxi.LC().aEf.userName;
            if (i > 0 || i2 > 0) {
                this.gnf.b(true, i, i2, str);
                this.gnu.a(true, i, i2, str);
                this.gnA.b(true, i, i2, str);
                return;
            }
            this.gnf.b(false, i, i2, str);
            this.gnu.a(false, i, i2, str);
            this.gnA.b(false, i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void r(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        super.r(aVar);
        if (this.gmw != null) {
            this.gmw.y(aVar);
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
                if (this.gmv != null) {
                    this.gmv.I(jSONObject);
                }
            } else if ("enter_live".equals(optString)) {
                if (this.gmu != null && this.gmu.getCount() > 20) {
                    this.gmu.dO(this.gmu.getCount() + 1);
                } else if (this.gmq != null) {
                    com.baidu.live.data.a JK = aVar.JK();
                    com.baidu.live.data.j jVar = new com.baidu.live.data.j();
                    jVar.aDH = new AlaLocationData();
                    jVar.aDI = new AlaRelationData();
                    jVar.aDG = new AlaLiveUserInfoData();
                    jVar.aDG.userId = JavaTypesHelper.toLong(JK.userId, 0L);
                    jVar.aDG.userName = JK.userName;
                    jVar.aDG.portrait = JK.portrait;
                    if (this.gmu != null && this.gmq.c(jVar)) {
                        this.gmu.dO(this.gmu.getCount() + 1);
                    }
                }
            } else if ("update_liveinfo".equals(optString)) {
                if (bOG().gxi.LC() != null && bOG().gxi.LC().mLiveInfo != null) {
                    bOG().gxi.a(bOG().gxi.LC().mLiveInfo.live_id, bOG().fromType, bOG().enterTime);
                }
            } else if ("challenge_mvp".equals(optString) && bOG().gxi.LC() != null && bOG().gxi.LC().mLiveInfo != null && bOG().gxi.LC().aEf != null && this.gmz != null) {
                long optLong = jSONObject.optLong("mvp_user_id");
                long optLong2 = jSONObject.optLong("winner_live_id");
                if (optLong == bOG().gxi.LC().aEf.userId && optLong2 == bOG().gxi.LC().mLiveInfo.live_id) {
                    this.gmz.c(jSONObject.optInt("challenge_status"), jSONObject.optLong("challenge_id"));
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void FO(String str) {
        if (this.gmw != null) {
            this.gmw.FO(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void cd(boolean z) {
        super.cd(z);
        if (bOG().gxj != null) {
            bOG().gxj.bXk();
            bOG().gxj.setLiveViewOnDispatchTouchEventListener(null);
            bOG().gxj.setLiveViewOnTouchEventListener(null);
            bOG().gxj.setOnLiveViewScrollListener(null);
        }
        if (bOG().ben != null) {
            bOG().ben.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.gmz != null) {
            this.gmz.BB();
        }
        bNJ();
        if (this.gmt != null) {
            this.gmt.BB();
        }
        if (this.gnp != null) {
            this.gnp.release();
        }
        if (this.gmv != null) {
            this.gmv.BB();
        }
        if (this.gnf != null) {
            this.gnf.bVU();
        }
        if (this.gms != null) {
            this.gms.bQN();
            this.gms.setVisible(8);
        }
        if (this.gmx != null) {
            this.gmx.BB();
        }
        if (this.gmw != null) {
            this.gmw.release();
        }
        if (this.bhK != null) {
            this.bhK.removeAllViews();
            this.bhK = null;
        }
        if (this.goQ != null) {
            this.goQ.removeAllViews();
            this.goQ = null;
        }
        if (this.gnp != null) {
            this.gnp.onDestroy();
        }
        if (this.gmy != null) {
            this.gmy.BB();
        }
        if (this.gmL != null) {
            this.gmL.cancel();
        }
        if (this.gok != null) {
            this.gok.bPK();
        }
        if (this.gmL != null) {
            this.gmL.BB();
        }
        if (this.gnU != null) {
            this.gnU.BB();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cb(boolean z) {
        super.cb(z);
        bNJ();
        if (this.gmr != null) {
            this.gmr.onDestroy();
        }
        if (this.gmt != null) {
            this.gmt.onDestroy();
        }
        if (this.gmv != null) {
            this.gmv.onDestroy();
        }
        if (this.gmx != null) {
            this.gmx.onDestroy();
        }
        if (this.gmy != null) {
            this.gmy.onDestroy();
        }
        if (this.gmz != null) {
            this.gmz.onDestroy();
        }
        if (this.gmA != null) {
            this.gmA.onDestroy();
        }
        if (this.gnC != null) {
            this.gnC.onDestroy();
        }
        if (this.gms != null) {
            this.gms.onDestroy();
        }
        if (this.gmq != null) {
            this.gmq.onDestroy();
        }
        if (this.gnu != null) {
            this.gnu.onDestroy();
        }
        if (this.gnf != null) {
            this.gnf.onDestory();
        }
        if (this.gmw != null) {
            this.gmw.release();
        }
        if (this.gok != null) {
            this.gok.cb(!z);
        }
        if (this.gmL != null) {
            this.gmL.onDestroy();
            this.gmL = null;
        }
        if (this.gnU != null) {
            this.gnU.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.gmM);
        MessageManager.getInstance().removeMessageRule(this.gmN);
        MessageManager.getInstance().unRegisterListener(this.gmP);
        MessageManager.getInstance().unRegisterListener(this.gmQ);
        MessageManager.getInstance().unRegisterListener(this.gmR);
        MessageManager.getInstance().unRegisterListener(this.gmT);
        MessageManager.getInstance().unRegisterListener(this.gmU);
        MessageManager.getInstance().unRegisterListener(this.goU);
        MessageManager.getInstance().unRegisterListener(this.gmV);
        MessageManager.getInstance().unRegisterListener(this.gmS);
    }

    private void bNJ() {
        if (this.gnu != null && this.gnu.Jf().getView() != null && this.gnu.Jf().getView().getParent() != null) {
            ((ViewGroup) this.gnu.Jf().getView().getParent()).removeView(this.gnu.Jf().getView());
        }
        if (this.gmD != null && this.gmD.getParent() != null) {
            ((ViewGroup) this.gmD.getParent()).removeView(this.gmD);
        }
        if (this.gnu != null && this.gnu.Jg().getView() != null) {
            this.gnW.removeView(this.gnu.Jg().getView());
        }
        if (this.gnu != null) {
            this.gnu.Jf().setMsgData(new LinkedList());
            this.gnu.Bb();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void a(ah ahVar) {
        if (this.gnu != null) {
            bOh();
            this.gnu.Jg().setEditText(" @" + ahVar.getNameShow() + " ");
        }
        if (this.gnf != null) {
            this.gnf.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void g(com.baidu.live.data.a aVar) {
        if (this.gnu != null) {
            bOh();
            this.gnu.Jg().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.gnf != null) {
            this.gnf.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void b(ah ahVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected View bNK() {
        if (this.gnu != null) {
            return this.gnu.Jg().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean bNL() {
        if (this.gnu == null || !this.gnu.Jg().Ky()) {
            return false;
        }
        lI(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected boolean bNM() {
        return this.gmr == null || this.gmr.bNM();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    /* renamed from: bPa */
    public PendantParentView bNN() {
        return this.bhK;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected ViewGroup bNO() {
        return this.goQ;
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
                    this.goa = false;
                    K(intExtra, intExtra2, intExtra3);
                    return;
                }
                bND();
                return;
            }
            aob();
        } else if (i == 25051 && i2 == -1 && this.gok != null) {
            this.gok.bRJ();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.gnu != null && this.gnu.Jf() != null) {
            this.gnu.Jf().onKeyboardVisibilityChanged(z);
        }
        if (z || this.gnu == null || this.gnu.Jg() == null || !this.gnu.Jg().Ky()) {
            if (z) {
                if (this.gnf != null) {
                    this.gnf.setVisibility(8);
                }
                if (this.gnw != null && this.gnw.EE() != null) {
                    this.gnw.EE().setVisibility(8);
                }
                bNQ();
                if (this.gnu != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gnu.Jg().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.gnu.Jg().getView().setLayoutParams(layoutParams);
                    this.gnu.Jg().getView().setVisibility(0);
                    this.gnu.Jg().setQuickInputPanelVisible(false);
                }
                if (this.gnV != null) {
                    this.gnV.setVisibility(8);
                }
                if (this.gmw != null) {
                    this.gmw.setVisible(8);
                }
                if (this.gnv != null) {
                    this.gnv.Ba();
                }
                if (this.gnT != null) {
                    this.gnT.setCanVisible(false);
                }
                if (this.gnP != null) {
                    this.gnP.setCanVisible(false);
                }
            } else {
                bNP();
            }
            bOU();
            if (this.gnH != null) {
                this.gnH.bk(z);
            }
        }
    }

    private void bNP() {
        if (this.gnf != null) {
            this.gnf.setVisibility(0);
        }
        if (this.gmD != null) {
            if (this.goW) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gmD.getLayoutParams();
                layoutParams.bottomMargin = (J(false, false) - bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) + com.baidu.live.ab.b.Pf();
                this.gmD.setLayoutParams(layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gmD.getLayoutParams();
                layoutParams2.bottomMargin = bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
                this.gmD.setLayoutParams(layoutParams2);
            }
        }
        if (this.gnu != null) {
            bOi();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gnu.Jg().getView().getLayoutParams();
            layoutParams3.bottomMargin = 0;
            this.gnu.Jg().getView().setLayoutParams(layoutParams3);
        }
        if (this.gnf != null) {
            this.gnf.setVisibility(0);
        }
        if (this.gnw != null && this.gnw.EE() != null) {
            this.gnw.EE().setVisibility(0);
        }
        if (this.gnV != null) {
            this.gnV.setVisibility(0);
        }
        if (this.gmw != null) {
            this.gmw.setVisible(0);
        }
        if (this.gnv != null) {
            this.gnv.Ba();
        }
        if (this.gnT != null) {
            this.gnT.setCanVisible(true);
        }
        if (this.gnP != null) {
            this.gnP.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNQ() {
        boolean z;
        boolean z2 = false;
        if (this.gmD != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gmD.getLayoutParams();
            if (this.gnu == null || this.gnu.Jg() == null) {
                z = false;
            } else {
                z = this.gnu.Jg().Kw();
                z2 = this.gnu.Jg().Kx();
            }
            int J = J(z, z2);
            if (layoutParams.bottomMargin != J) {
                layoutParams.bottomMargin = J;
                this.gmD.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lI(boolean z) {
        this.goV = z;
        if (z) {
            this.gnu.Jg().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gmD.getLayoutParams();
            int quickInputPanelExpandHeight = this.gnu.Jg().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.gmD.setLayoutParams(layoutParams);
                if (this.gnu.Jf() != null) {
                    this.gnu.Jf().Je();
                    return;
                }
                return;
            }
            return;
        }
        bNP();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.gmq != null) {
                this.gmq.dz(i3);
            }
            if (this.gms != null) {
                this.gms.dz(i3);
            }
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public boolean ey(int i) {
        boolean ey = super.ey(i);
        if (ey && 2 == i) {
            if (this.gmr.bNM()) {
                return false;
            }
            if (ey && this.gnp != null) {
                this.gnp.mK(false);
            }
        }
        return ey;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void tQ(int i) {
        super.tQ(i);
        if (i == 7 || i == 11) {
            if (this.gnf != null) {
                this.gnf.setVisibility(8);
            }
            if (this.gnu != null) {
                this.gnu.Jf().getView().setVisibility(4);
            }
            if (this.gmw != null) {
                this.gmw.bI(2, 8);
                if (this.goS) {
                    this.gmw.bI(1, 8);
                }
            }
            if (this.gnK != null) {
                this.gnK.mF(false);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public void ez(int i) {
        super.ez(i);
        if (i == 7 || i == 11) {
            if (this.gnf != null) {
                this.gnf.setVisibility(0);
            }
            if (this.gnu != null) {
                this.gnu.Jf().getView().setVisibility(0);
            }
            if (this.gmw != null) {
                this.gmw.setVisible(0);
            }
            if (this.gnK != null) {
                this.gnK.mF(true);
            }
            this.gnV.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.gmt != null) {
            this.gmt.bWl();
        }
        if (this.gmy != null) {
            this.gmy.BJ();
        }
        if (this.gmw != null) {
            this.gmw.onStop();
        }
        if (this.gmx != null) {
            this.gmx.bb(true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.gmt != null) {
            this.gmt.bWk();
        }
        if (this.gmy != null && this.goT) {
            this.gmy.BK();
        }
        if (this.gmw != null) {
            this.gmw.onStart();
        }
        if (this.gmx != null) {
            this.gmx.bb(false);
        }
    }
}
