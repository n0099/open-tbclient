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
import com.baidu.live.data.ah;
import com.baidu.live.data.be;
import com.baidu.live.data.bo;
import com.baidu.live.data.bu;
import com.baidu.live.data.p;
import com.baidu.live.data.r;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.n;
import com.baidu.live.gift.z;
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
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.turntable.d;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends b implements com.baidu.live.j.c, e {
    private PendantParentView bhH;
    private FrameLayout gmA;
    private ImageView gmB;
    private com.baidu.live.tieba.e.b gmC;
    private z gmG;
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
    private com.baidu.live.im.b.a gmx;
    private com.baidu.tieba.ala.liveroom.share.b gmy;
    private FrameLayout gmz;
    private long lastClickTime = 0;
    private boolean gmD = false;
    private boolean gmE = false;
    private Handler gmF = new Handler();
    private HttpRule gmI = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.gmu != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.gmu.BP()) {
                httpMessage.addParam("ala_challenge_id", a.this.gmu.BS());
            }
            return httpMessage;
        }
    };
    private HttpRule gmJ = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.gmu != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.gmu.BP()) {
                httpMessage.addParam("challenge_id", a.this.gmu.BS());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c gmK = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.19
        @Override // com.baidu.live.liveroom.g.c
        public void LA() {
            if (a.this.gnl != null) {
                a.this.gnl.mI(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void ce(boolean z) {
            if (z) {
                if (a.this.gnl != null) {
                    a.this.gnl.mI(true);
                }
            } else if (a.this.gnl != null) {
                a.this.gnl.mI(false);
            }
            if (a.this.gnD != null) {
                a.this.gnD.bl(z);
            }
            if (a.this.gms != null) {
                a.this.gms.lB(z ? false : true);
            }
        }
    };
    private HttpMessageListener gmL = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.a.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.LK() != null) {
                        com.baidu.live.w.c.Np().bki = getQuickGiftHttpResponseMessage.LK();
                        a.this.bNt();
                    }
                }
            }
        }
    };
    private CustomMessageListener gmM = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.d.a.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bNE();
        }
    };
    private CustomMessageListener gmN = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                a.this.gnt.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gmO = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.gnH != null) {
                    a.this.gnH.Gn(str);
                }
            }
        }
    };
    CustomMessageListener gmP = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.gnY != null && a.this.gnY.aXT != null && !a.this.gnY.aXW && !a.this.gnY.aXX && a.this.gnC != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.bOF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = a.this.bOF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                a.this.gnC.b(a.this.gmz, layoutParams);
                if (com.baidu.live.guardclub.e.Il() != null) {
                    com.baidu.live.guardclub.e.Il().Ir();
                }
            }
        }
    };
    private CustomMessageListener gmQ = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (a.this.gnF != null) {
                    a.this.gnF.dismiss();
                }
                com.baidu.live.im.b.d.JD().setSwitchStatus(true);
                com.baidu.live.im.b.d.JD().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bOg();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener gmR = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.gmH.c(a.this.bOF());
                } else if (a.this.bOa() || !g.ud(2913168)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.bOF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.bOF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    a.this.gmH.b(a.this.gmz, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gmS = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.a.10
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
            if (currentTimeMillis - a.this.lastClickTime >= 300) {
                a.this.lastClickTime = currentTimeMillis;
                if (i == 2 && a.this.Hu()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel"));
                    a.this.K(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.w.c.Np().bki.EN().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.w.c.Np().bki.EN().DR());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.w.c.Np().bki.EN().DS());
                        if (a.this.bOF().gxe.LC() != null && a.this.bOF().gxe.LC().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.bOF().gxe.LC().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.bOF().gxe.LC().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.JY());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.Hu()) {
                        if (com.baidu.live.c.AD().getBoolean("quick_gift_guide_show", true) && !a.this.bOa()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, z.class, a.this.bOF().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                z zVar = (z) runTask.getData();
                                zVar.setPageContext(a.this.bOF().pageContext);
                                zVar.d(a.this.bOF().gxe.LC());
                                zVar.setGiftItem(com.baidu.live.w.c.Np().bki.EN());
                                zVar.setOtherParams(a.this.JY());
                                zVar.initView();
                                zVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.10.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        a.this.lI(false);
                                        a.this.gmG = null;
                                    }
                                });
                                a.this.gmG = zVar;
                                zVar.show();
                                a.this.lI(true);
                                return;
                            }
                            return;
                        }
                        n.a(a.this.bOF().pageContext, a.this.bOF().gxe.LC(), com.baidu.live.w.c.Np().bki.EN(), a.this.JY());
                    }
                } else if (i == 1) {
                    if (a.this.gnq != null) {
                        a.this.bOg();
                    }
                } else if (i == 3 && a.this.Hu()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    if (a.this.mOrientation == 2 && TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.gmy != null) {
                            a.this.gmy.A(a.this.bOF().gxe.LC());
                        }
                    } else {
                        a.this.gnd.c(a.this.bOF().gxe.LC(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.bOF() != null && a.this.bOF().gxe != null && a.this.bOF().gxe.LC() != null && a.this.bOF().gxe.LC().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.bOF().gxe.LC().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.bOF().gxe.LC().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.bOF().gxe.LC().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.JY());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.bOF() != null && a.this.bOF().gxe != null && a.this.bOF().gxe.LC() != null && a.this.bOF().gxe.LC().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.bOF().gxe.LC().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.bOF().gxe.LC().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.bOF().gxe.LC().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.JY());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.bei != null) {
                        a.this.bei.bY(false);
                    }
                } else if (i == 12) {
                    if (a.this.gnl != null) {
                        String valueOf = String.valueOf(a.this.bOF().gxe.LC().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.bOF().gxe.LC().mLiveInfo.room_id);
                        String str3 = null;
                        p pVar = a.this.bOF().gxe.LC().mLiveSdkInfo;
                        if (pVar != null && pVar.mCastIds != null) {
                            str3 = String.valueOf(a.this.bOF().gxe.LC().mLiveSdkInfo.mCastIds.aDW);
                        }
                        a.this.gnl.ai(valueOf, valueOf2, str3);
                        if (com.baidu.live.liveroom.a.KQ().KR()) {
                            a.this.bNE();
                        }
                    }
                } else if (i == 14) {
                    r LC = a.this.bOF().gxe.LC();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.bOF().pageContext.getPageActivity(), LC.aDE.userName, Long.toString(LC.aDE.userId), Long.toString(LC.aDE.charmCount), String.valueOf(LC.mLiveInfo.group_id), String.valueOf(LC.mLiveInfo.live_id), false, String.valueOf(LC.aDE.userId), Long.toString(LC.aEd.userId), LC.aEd.userName, LC.aEd.portrait, a.this.gmq.getCount(), a.this.JY())));
                    LogManager.getCommonLogger().doClickGusetNumLog(LC.mLiveInfo.feed_id, a.this.gmq.getCount() + "", a.this.JY());
                } else if (i == 11) {
                    a.this.bOj();
                    a.this.bOk();
                } else if (i == 16) {
                    if (a.this.bOF() != null && (beVar2 = com.baidu.live.w.a.Nk().bka) != null && (boVar2 = beVar2.aJy) != null) {
                        String str4 = boVar2.aKu.aKB;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (a.this.bOF().gxe != null && a.this.bOF().gxe.LC() != null && a.this.bOF().gxe.LC().mLiveInfo != null) {
                                j = a.this.bOF().gxe.LC().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", a.this.bOF().gxe.LC().mLiveInfo.room_id + "", a.this.bOF().gxe.LC().mLiveInfo.feed_id, a.this.JY());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.bOF().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (a.this.bOF() != null) {
                        r rVar = null;
                        if (a.this.bOF().gxe != null) {
                            rVar = a.this.bOF().gxe.LC();
                        }
                        if (rVar != null && rVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.w.b.bWx().beS != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.w.b.bWx().beS.aDg;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + rVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + rVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(a.this.bOF().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17) {
                    if (a.this.Hu() && a.this.bOF() != null && (beVar = com.baidu.live.w.a.Nk().bka) != null && (boVar = beVar.aJy) != null && (buVar = boVar.aKv) != null && !TextUtils.isEmpty(buVar.webUrl)) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                        if (a.this.gnF != null && a.this.bOF().gxe != null && a.this.bOF().gxe.LC() != null) {
                            r LC2 = a.this.bOF().gxe.LC();
                            a.this.gnF.a(buVar.webUrl, LC2.mLiveInfo.live_id, LC2.aEd.userId, LC2.aDE.userId);
                            a.this.gmC.cs(false);
                            a.this.gmC.Oj();
                        }
                    }
                } else if (i == 18) {
                    if (a.this.gmE) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.gmE = !a.this.gmE;
                } else if (i == 19 && a.this.gmC != null) {
                    a.this.gmC.Oj();
                }
            }
        }
    };

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
        return false;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void m(r rVar) {
        super.m(rVar);
        g.bRN();
        this.gmE = false;
        if (this.gni != null) {
            this.gni.b(this.gmS);
        }
        if (this.gmC == null) {
            this.gmC = new com.baidu.live.tieba.e.b(bOF().pageContext.getPageActivity());
            this.gmC.start();
        }
        this.gmC.cs(true);
        bOF().pageContext.getPageActivity().setRequestedOrientation(-1);
        bOF().gxf.setIsForceHandledTouch(false);
        bOF().gxf.setSwipeClearEnable(true);
        bOF().gxf.setOnLiveViewScrollListener(this.gmK);
        bOF().gxf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gmF.removeCallbacksAndMessages(null);
                a.this.lE(false);
                if (!a.this.gmD) {
                    a.this.gmF.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.gmD) {
                                a.this.lE(false);
                            }
                        }
                    }, 5000L);
                }
            }
        });
        if (this.gnR != null) {
            this.gnR.setVisibility(0);
        }
        bNk();
        if (this.gnA != null) {
            this.gnA.a(rVar, this.bhH);
            this.gnA.S(this.gnS);
            this.gnA.a(this);
        }
        bNw();
        bNW();
        bNx();
        bNj();
        bNB();
        bNy();
        bNf();
        lJ(false);
        bOn();
        bOm();
        bNn();
        bNu();
        bNv();
        bOo();
        bNh();
        bND();
        bNF();
        lK(true);
        bNm();
        bNt();
        bOx();
        bNo();
        bNp();
        bNq();
        bNr();
        bNG();
        bOt();
        bNg();
        bOw();
        if (this.gnF != null && this.gnF.bWF() == null) {
            this.gnF.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.21
                @Override // com.baidu.tieba.ala.liveroom.turntable.d.a
                public void onDismiss() {
                    a.this.gmC.cs(true);
                }
            });
        }
        c(this.fxt);
        MessageManager.getInstance().registerListener(this.gmL);
        MessageManager.getInstance().registerListener(this.gmM);
        MessageManager.getInstance().registerListener(this.gmP);
        MessageManager.getInstance().registerListener(this.gmQ);
        MessageManager.getInstance().registerListener(this.gmR);
        MessageManager.getInstance().registerListener(this.gmO);
        MessageManager.getInstance().registerListener(this.gmN);
        bNH();
        bNA();
        if (this.mOrientation == 2) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(bOF().pageContext.getPageActivity());
            l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(bOF().pageContext.getPageActivity()));
        }
        if (this.gnN != null) {
            this.gnN.u(rVar);
        }
    }

    private void bNf() {
        if (this.gnN == null) {
            View view = null;
            if (this.gni != null && this.gni.getView() != null) {
                view = this.gni.getView();
            }
            this.gnN = new com.baidu.tieba.ala.liveroom.exclusive.b(bOF().pageContext, Lw(), bOF().gxf, view, this.gmm.gpj, this);
        }
    }

    private void bNg() {
        if (this.gnM != null) {
            this.gnM.a(new com.baidu.live.r.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.22
                @Override // com.baidu.live.r.c
                public void cj(boolean z) {
                    if (a.this.gmv != null) {
                        a.this.gmv.setNeedCloseRecommendFloat(z);
                    }
                    if (a.this.bOF().gxf.gLW) {
                        if (a.this.gnl != null) {
                            a.this.gnl.mB(z);
                            a.this.gnl.mI(!z);
                        }
                        if (a.this.gni != null) {
                            a.this.gni.mB(z);
                            a.this.gni.setPraiseEnable(!z);
                            a.this.gni.mA(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lE(boolean z) {
        View EV;
        if (bOF() != null && bOF().pageContext != null && bOF().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(bOF().pageContext.getPageActivity()) == 2 || z) {
                if (this.gnt != null && (EV = this.gnt.EV()) != null) {
                    if (this.gmD) {
                        EV.setVisibility(0);
                    } else {
                        EV.setVisibility(8);
                    }
                }
                if (this.gmD) {
                    if (this.gnR != null) {
                        this.gnR.setVisibility(0);
                    }
                    if (this.gnS != null) {
                        this.gnS.setVisibility(0);
                    }
                    if (this.bhH != null) {
                        this.bhH.setVisibility(0);
                    }
                    if (this.bhH != null) {
                        this.bhH.setVisibility(0);
                    }
                    if (this.gns != null) {
                        this.gns.bj(false);
                    }
                } else {
                    if (this.gnR != null) {
                        this.gnR.setVisibility(8);
                    }
                    if (this.gnS != null) {
                        this.gnS.setVisibility(8);
                    }
                    if (this.bhH != null) {
                        this.bhH.setVisibility(8);
                    }
                    if (this.bhH != null) {
                        this.bhH.setVisibility(8);
                    }
                    if (this.gns != null) {
                        this.gns.bj(true);
                    }
                }
                this.gmD = this.gmD ? false : true;
                if (this.gms != null) {
                    this.gms.lB(this.gmD);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, boolean z2) {
        ImageView imageView;
        View EE;
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view;
        }
        if (z) {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_off);
            }
            if (this.gmA != null) {
                this.gmA.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_on);
            }
            if (this.gmA != null) {
                this.gmA.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.gns != null && (EE = this.gns.EE()) != null) {
            if (z) {
                EE.setVisibility(8);
            } else {
                EE.setVisibility(0);
            }
        }
    }

    private void bNh() {
        CustomResponsedMessage runTask;
        if (this.gmx == null && (runTask = MessageManager.getInstance().runTask(2913164, com.baidu.live.im.b.a.class, bOF().pageContext)) != null) {
            this.gmx = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gmx != null) {
            this.gmx.setOtherParams(this.otherParams);
            this.gmx.a(new a.InterfaceC0175a() { // from class: com.baidu.tieba.ala.liveroom.d.a.23
                @Override // com.baidu.live.im.b.a.InterfaceC0175a
                public void JC() {
                    a.this.bOr();
                }
            });
        }
    }

    private void bNi() {
        if (this.gnk != null) {
            this.gnk.aw(bOF().gxd.getLiveContainerView());
        }
    }

    private void bNj() {
        if (this.gmy == null) {
            this.gmy = new com.baidu.tieba.ala.liveroom.share.b(bOF().pageContext);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void dD(int i) {
        super.dD(i);
        if (this.gmB != null && UtilHelper.getRealScreenOrientation(bOF().pageContext.getPageActivity()) != 2) {
            this.gmB.setVisibility(0);
        }
        bNi();
        if (this.gmv != null) {
            this.gmv.dD(i);
        }
        if (this.gmv == null || !this.gmv.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
        if (this.gnN != null) {
            this.gnN.bRl();
        }
    }

    private void bNk() {
        if (this.bhH == null) {
            PendantParentView.Model model = PendantParentView.Model.HORIZONTAL;
            if (this.mOrientation == 2) {
                model = PendantParentView.Model.HORIZONTAL_FULL;
            }
            this.bhH = new PendantParentView(bOF().pageContext.getPageActivity(), model);
            bOF().gxf.addView(this.bhH, ((bOF().gxf.getView() == null || this.gni == null || this.gni.getView() == null) ? -1 : bOF().gxf.getView().indexOfChild(this.gni.getView())) + 1, new RelativeLayout.LayoutParams(-1, bNl()));
            this.bhH.setDefaultItemMargin(bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            I(this.mOrientation, false);
        }
    }

    private int bNl() {
        int bottom;
        int bottom2;
        if (bOF().bel.getLivePlayer().getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bOF().bel.getLivePlayer().getLayoutParams();
            bottom = layoutParams.topMargin + layoutParams.height;
        } else {
            bottom = bOF().bel.getLivePlayer().getBottom();
        }
        if (bOF().gxf.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) bOF().gxf.getLayoutParams();
            bottom2 = layoutParams2.topMargin + layoutParams2.height;
        } else {
            bottom2 = bOF().gxf.getBottom();
        }
        int i = 0;
        if (this.gnN != null) {
            i = this.gnN.getHeight();
        }
        return (((bottom2 - bottom) - i) - bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
    }

    private void bNm() {
        if (this.gms == null) {
            this.gms = new com.baidu.tieba.ala.liveroom.activeview.b(bOF().pageContext);
        }
        if (bOF() != null && bOF().gxe != null) {
            this.gms.FL(bOF().gxe.bVQ());
        }
        this.gms.setOtherParams(JY());
        this.gms.b(bOF().gxe.LC(), true);
        this.gms.setHost(false);
        this.gms.a(1, this.bhH);
        this.gms.a(2, this.bhH);
        this.gms.setVisible(this.gnV ? 8 : 0);
    }

    private void bNn() {
        if (this.gnh != null && bOF() != null && bOF().gxe != null) {
            this.gnh.b(bOF().gxd.getLiveContainerView(), bOF().gxe.LC());
        }
    }

    private void bNo() {
        if (this.bhH != null) {
            if (this.gmr == null) {
                this.gmr = new com.baidu.tieba.ala.liveroom.l.a(bOF().pageContext, this);
            }
            this.gmr.setOtherParams(JY());
            this.gmr.a((ViewGroup) this.bhH, bNs());
            this.gmr.v(bOF().gxe.LC());
        }
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
            this.gnb.a(new a.InterfaceC0637a() { // from class: com.baidu.tieba.ala.liveroom.d.a.7
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0637a
                public void bK(int i, int i2) {
                    r LC = a.this.bOF().gxe.LC();
                    if (LC != null && LC.mLiveInfo != null) {
                        if (a.this.gnG == null) {
                            a.this.gnG = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.bOF().pageContext.getPageActivity());
                        }
                        a.this.gnG.d(a.this.gnS, i, i2);
                        a.this.gnG.a(String.valueOf(LC.mLiveInfo.live_id), new a.InterfaceC0641a() { // from class: com.baidu.tieba.ala.liveroom.d.a.7.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0641a
                            public void a(float f, String str) {
                                if (a.this.gnb != null) {
                                    a.this.gnb.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0637a
                public void bL(int i, int i2) {
                    if (a.this.gnG != null) {
                        a.this.gnG.bQ(i, i2);
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
            this.gmH = new com.baidu.tieba.ala.liveroom.j.b(bOF().pageContext, JY(), this.gog, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.8
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bNQ() {
                    a.this.lI(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bNR() {
                    a.this.lI(false);
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
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = bOF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNt() {
        if (this.gnb == null) {
            bNy();
        }
        this.gnb.a(com.baidu.live.w.c.Np().bki, bOF().gxe.LC());
    }

    private void bNu() {
        CustomResponsedMessage runTask;
        boolean z = true;
        if (this.gnq == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, bOF().pageContext)) != null && runTask.getData() != null) {
            this.gnq = (k) runTask.getData();
            this.gnq.setFromMaster(false);
            this.gnq.Jf().getView().setId(a.g.ala_liveroom_msg_list);
            this.gnq.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.9
                @Override // com.baidu.live.im.k.a
                public boolean Ji() {
                    return a.this.Hu();
                }

                @Override // com.baidu.live.im.k.a
                public void Jj() {
                    a.this.gnZ = true;
                }

                @Override // com.baidu.live.im.k.a
                public void gQ(String str) {
                    if (!a.this.gnV) {
                        a.this.lG(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.bOF().pageContext.getPageActivity(), a.this.bOF().gxd.getLiveContainerView());
                    }
                    a.this.FR(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Jk() {
                    if (a.this.gnV) {
                        a.this.lG(true);
                        a.this.bOF().gxd.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.bOF().pageContext.getPageActivity(), a.this.bOF().gxd.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (a.this.gnq != null) {
                        a.this.gnq.Jg().setQuickInputPanelVisible(false);
                        a.this.gnq.Jg().Kz();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Jl() {
                    if (a.this.gnV) {
                        a.this.bNP();
                        if (a.this.gnr != null) {
                            a.this.gnr.Ba();
                        }
                        if (a.this.gmx != null) {
                            a.this.gmx.Ba();
                        }
                    } else if (a.this.gnq != null) {
                        a.this.gnq.Jg().setQuickInputPanelVisible(false);
                        a.this.gnq.Jg().Kz();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Jm() {
                    return a.this.bOb();
                }

                @Override // com.baidu.live.im.k.a
                public int Jn() {
                    return a.this.bOc();
                }
            });
            this.gmz = new FrameLayout(bOF().pageContext.getPageActivity());
            this.gmz.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.gnq != null && this.gmz != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bOF().pageContext.getPageActivity()) * 0.7f);
            int i = com.baidu.live.ab.b.i(true, false);
            if (this.gnS.indexOfChild(this.gmz) < 0) {
                if (this.gmz.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gmz.getParent()).removeView(this.gmz);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                this.gnS.addView(this.gmz, layoutParams);
            }
            if (this.gmz.indexOfChild(this.gnq.Jf().getView()) < 0) {
                if (this.gnq.Jf().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gnq.Jf().getView()).removeView(this.gnq.Jf().getView());
                }
                if (UtilHelper.getRealScreenOrientation(bOF().pageContext.getPageActivity()) != 2) {
                    this.gmz.addView(this.gnq.Jf().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, i));
                }
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
            if (LC == null || LC.aEq == null || !LC.aEq.Co()) {
                z = false;
            }
            this.gnq.a(String.valueOf(bOF().gxe.LC().mLiveInfo.group_id), String.valueOf(bOF().gxe.LC().mLiveInfo.last_msg_id), String.valueOf(bOF().gxe.LC().aDE.userId), String.valueOf(bOF().gxe.LC().mLiveInfo.live_id), bOF().gxe.LC().aDE.appId, z);
            lG(false);
        }
    }

    private void bNv() {
        if (this.gmA == null) {
            this.gmA = new FrameLayout(bOF().pageContext.getPageActivity());
            this.gmA.setId(a.g.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void bNw() {
        if (this.gmn == null) {
            this.gmn = new com.baidu.tieba.ala.liveroom.o.a(bOF().pageContext, false, this);
        }
        this.gmn.c(this.gnR, bOF().gxe.LC());
        this.gmn.a(this.gmS);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void bNE() {
        String str;
        if (bOF() != null && bOF().gxe != null && bOF().gxe.LC() != null && bOF().gxe.LC().aEd != null && (str = bOF().gxe.LC().aEd.userName) != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bOF().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !bOa()) {
            com.baidu.live.c.AD().putInt("guide_rename_show_count", com.baidu.live.c.AD().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.KQ().bX(true);
            if (this.gnJ == null) {
                this.gnJ = new com.baidu.tieba.ala.liveroom.v.a(bOF().pageContext);
            }
            this.gnJ.setOtherParams(JY());
            this.gnJ.e(this.gnS, bOF().gxe.LC());
            lI(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.12
                @Override // java.lang.Runnable
                public void run() {
                    a.this.gnJ.bWm();
                    a.this.lI(false);
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
        boolean z = false;
        if (this.gnl == null) {
            this.gnl = new com.baidu.tieba.ala.liveroom.x.a(bOF().pageContext, this);
        }
        this.gnl.d(bOF().gxf, false);
        boolean bOE = bOE();
        AlaLiveInfoData alaLiveInfoData = bOF().gxe.LC().mLiveInfo;
        boolean isZanAnimUnabled = (alaLiveInfoData == null || alaLiveInfoData.mAlaLiveSwitchData == null) ? false : alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled();
        if (bOE && !isZanAnimUnabled) {
            z = true;
        }
        this.gnl.mH(z);
    }

    private void bNG() {
        if (bOF() != null && bOF().bel != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(bOF().pageContext.getPageActivity());
            Activity pageActivity = bOF().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + pageActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds176)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.gmB = new ImageView(bOF().pageContext.getPageActivity());
            this.gmB.setVisibility(8);
            this.gmB.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.gmB.setImageResource(a.f.icon_live_enlarge);
            this.gmB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.gmC != null) {
                        a.this.gmC.Oi();
                        a.this.gmB.setVisibility(4);
                    }
                }
            });
            bOF().gxf.addView(this.gmB, layoutParams);
            if (UtilHelper.getRealScreenOrientation(bOF().pageContext.getPageActivity()) != 2) {
                if (bOF().gxk) {
                    this.gmB.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.14
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.gmB != null && UtilHelper.getRealScreenOrientation(a.this.bOF().pageContext.getPageActivity()) != 2) {
                                a.this.gmB.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
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
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.15
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bOg();
                    }
                }, 500L);
            }
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
            e.printStackTrace();
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
        if (this.gmx != null) {
            this.gmx.a(rVar);
        }
        if (this.gms != null) {
            this.gms.j(rVar);
            if (rVar != null && this.gnO != null && !this.gnO.hasInit && !TextUtils.isEmpty(this.gnO.aJS)) {
                this.gnO.hasInit = true;
                this.gms.FO(this.gnO.aJS);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(com.baidu.live.data.k kVar) {
        if (kVar != null) {
            if (this.gmm != null && kVar.getList() != null) {
                this.gmm.e(kVar);
            }
            if (this.gmq != null) {
                this.gmq.dO(kVar.getCount());
            }
        }
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
        if (this.gmu != null) {
            this.gmu.BB();
        }
        if (this.gmx != null) {
            this.gmx.a((a.InterfaceC0175a) null);
            this.gmx.Bb();
        }
        if (this.gmB != null && (this.gmB.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gmB.getParent()).removeView(this.gmB);
        }
        if (this.gmy != null) {
            this.gmy.dismiss();
        }
        if (this.gmC != null) {
            this.gmC.cs(false);
            this.gmC.Oj();
        }
        if (this.gmH != null) {
            this.gmH.BB();
        }
        if (this.gog != null) {
            this.gog.bPJ();
        }
        if (this.gnQ != null) {
            this.gnQ.BB();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void n(r rVar) {
        View AZ;
        super.n(rVar);
        if (this.gmx != null && (AZ = this.gmx.AZ()) != null && AZ.getParent() != null) {
            ((ViewGroup) AZ.getParent()).removeView(AZ);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.gmx != null) {
            this.gmx.setOtherParams(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cb(boolean z) {
        super.cb(z);
        this.gmF.removeCallbacksAndMessages(null);
        bNI();
        this.gmD = false;
        this.gmE = false;
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
        if (this.gmy != null) {
            this.gmy.onDestroy();
        }
        if (this.gmo != null) {
            this.gmo.onDestroy();
        }
        if (this.gmC != null) {
            this.gmC.stop();
        }
        if (this.gnl != null) {
            this.gnl.onDestroy();
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
        if (this.gmx != null) {
            this.gmx.a((a.InterfaceC0175a) null);
            this.gmx.release();
            this.gmx = null;
        }
        if (this.gog != null) {
            this.gog.cb(z ? false : true);
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
        MessageManager.getInstance().unRegisterListener(this.gmP);
        MessageManager.getInstance().unRegisterListener(this.gmQ);
        MessageManager.getInstance().unRegisterListener(this.gmR);
        MessageManager.getInstance().unRegisterListener(this.gmO);
        MessageManager.getInstance().unRegisterListener(this.gmN);
    }

    private void bNI() {
        if (this.gnq != null && this.gnq.Jf().getView() != null && this.gnq.Jf().getView().getParent() != null) {
            ((ViewGroup) this.gnq.Jf().getView().getParent()).removeView(this.gnq.Jf().getView());
        }
        if (this.gmz != null && this.gmz.getParent() != null) {
            ((ViewGroup) this.gmz.getParent()).removeView(this.gmz);
        }
        if (this.gmA != null && this.gmA.getParent() != null) {
            ((ViewGroup) this.gmA.getParent()).removeView(this.gmA);
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

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected ViewGroup bNM() {
        return this.bhH;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected ViewGroup bNN() {
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
                    this.gnW = false;
                    K(intExtra, intExtra2, intExtra3);
                    return;
                }
                bNC();
                return;
            }
            aob();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.gnV;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(bOF().pageContext.getPageActivity()) || z2) {
            lF(z);
        }
    }

    private void lF(boolean z) {
        if (this.gnq != null && this.gnq.Jf() != null) {
            this.gnq.Jf().onKeyboardVisibilityChanged(z);
        }
        if (z || this.gnq == null || !this.gnq.Jg().Ky()) {
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
            if (this.gnq != null && this.gmz != null) {
                if (this.gnS.indexOfChild(this.gmz) != -1 && this.gmz.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gmz.getLayoutParams();
                    layoutParams2.height = com.baidu.live.ab.b.i(true, z);
                    this.gmz.setLayoutParams(layoutParams2);
                }
                if (this.gmz.indexOfChild(this.gnq.Jf().getView()) != -1 && this.gnq.Jf().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.gnq.Jf().getView().getLayoutParams();
                    layoutParams3.height = com.baidu.live.ab.b.i(true, z);
                    this.gnq.Jf().getView().setLayoutParams(layoutParams3);
                }
                this.gnq.Jf().Je();
            }
        }
    }

    private void bNO() {
        if (this.gnb != null) {
            this.gnb.setVisibility(0);
        }
        if (this.gmz != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gmz.getLayoutParams();
            layoutParams.bottomMargin = bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            this.gmz.setLayoutParams(layoutParams);
        }
        if (this.gnq != null) {
            bOh();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gnq.Jg().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.gnq.Jg().getView().setLayoutParams(layoutParams2);
        }
        if (this.gnb != null) {
            this.gnb.setVisibility(0);
        }
        if (this.gns != null && this.gns.EE() != null) {
            this.gns.EE().setVisibility(0);
        }
        if (this.gnR != null && (!this.gmD || UtilHelper.getRealScreenOrientation(bOF().pageContext.getPageActivity()) != 2)) {
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
        FrameLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        FrameLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = bOF().pageContext.getPageActivity();
        if (i3 == 1) {
            if (bOF().pageContext.getPageActivity() != null && !UtilHelper.canUseStyleImmersiveSticky()) {
                q.e(bOF().pageContext.getPageActivity(), true);
            }
            if (this.gnR != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.gnR.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.gmy != null) {
                this.gmy.dismiss();
            }
            if (this.gmx != null) {
                this.gmx.a((a.InterfaceC0175a) null);
                this.gmx.Bb();
            }
            if (this.bei != null) {
                this.bei.e(true, true);
            }
            if (this.gmB != null) {
                this.gmB.setVisibility(0);
                this.gmB.bringToFront();
            }
            if (this.gng != null) {
                this.gng.setVisibility(0);
            }
            if (this.gnq != null && this.gnq.Jf().getView().getParent() != null && (this.gnq.Jf().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gnq.Jf().getView().getParent()).removeView(this.gnq.Jf().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bOF().pageContext.getPageActivity()) * 0.7f);
            int i4 = com.baidu.live.ab.b.i(true, false);
            if (this.gmz != null && this.gnq != null) {
                this.gmz.addView(this.gnq.Jf().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, i4));
            }
            if (this.gmA != null && (this.gmA.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gmA.getParent()).removeView(this.gmA);
            }
            if (this.gnr != null) {
                this.gnr.a(bOF().gxe.LC(), false);
                this.gnr.a(new a.InterfaceC0175a() { // from class: com.baidu.tieba.ala.liveroom.d.a.16
                    @Override // com.baidu.live.im.b.a.InterfaceC0175a
                    public void JC() {
                        a.this.bOr();
                    }
                });
                View AZ = this.gnr.AZ();
                if (AZ != null && this.gnS != null && AZ.getParent() == null) {
                    Resources resources = bOF().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bOF().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds98));
                    layoutParams5.addRule(2, a.g.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                    this.gnS.addView(AZ, layoutParams5);
                }
            }
            if (this.gni != null) {
                this.gni.setPraiseEnable(true);
                bOF().gxf.gLW = true;
            }
            if (this.gmm != null && this.gmm.gpk != null && (layoutParams3 = (FrameLayout.LayoutParams) this.gmm.gpk.getLayoutParams()) != null) {
                layoutParams3.width = -2;
                this.gmm.gpk.setLayoutParams(layoutParams3);
            }
            if (this.gnl != null) {
                this.gnl.bXI();
            }
            if (this.gmD) {
                lE(true);
            }
            if (this.gmE) {
                if (this.gnb != null && this.gnb.getLandscapeBarrageImageView() != null) {
                    b(this.gnb.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.gnb != null) {
                this.gnb.uC(0);
            }
            if (this.gmq != null) {
                this.gmq.lQ(true);
            }
            this.gmF.removeCallbacksAndMessages(null);
            if (this.gmr != null) {
                this.gmr.setCanVisible(true);
                this.gmr.v(bOF().gxe.LC());
            }
        } else if (i3 == 2) {
            if (bOF().pageContext.getPageActivity() != null && !UtilHelper.canUseStyleImmersiveSticky()) {
                q.e(bOF().pageContext.getPageActivity(), false);
            }
            if (this.gnl != null) {
                this.gnl.bXJ();
            }
            if (this.gnR != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.gnR.getLayoutParams()) != null) {
                layoutParams2.topMargin = bOF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
            }
            if (this.gnr != null) {
                this.gnr.a((a.InterfaceC0175a) null);
                this.gnr.Bb();
            }
            bOF().gxf.bXl();
            if (this.bei != null) {
                this.bei.e(false, true);
            }
            if (this.gmB != null) {
                this.gmB.setVisibility(4);
            }
            if (this.gnq != null && this.gnq.Jf().getView().getParent() != null && (this.gnq.Jf().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gnq.Jf().getView().getParent()).removeView(this.gnq.Jf().getView());
            }
            int max = Math.max(i, i2);
            if (this.gmA != null) {
                if (this.gmA.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gmA.getParent()).removeView(this.gmA);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
                bOF().gxf.addView(this.gmA, this.bhH != null ? bOF().gxf.indexOfChild(this.bhH) : -1, layoutParams6);
            }
            if (this.gmA != null && this.gmx != null) {
                this.gmx.a(bOF().gxe.LC(), false);
                this.gmx.a(new a.InterfaceC0175a() { // from class: com.baidu.tieba.ala.liveroom.d.a.17
                    @Override // com.baidu.live.im.b.a.InterfaceC0175a
                    public void JC() {
                        a.this.bOr();
                    }
                });
                View AZ2 = this.gmx.AZ();
                if (AZ2 != null && this.gmA.indexOfChild(AZ2) < 0) {
                    this.gmA.addView(AZ2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bOF().pageContext.getPageActivity()), -1));
                }
            }
            if (this.gni != null) {
                this.gni.az(bOF().gxf);
                this.gni.setPraiseEnable(false);
                bOF().gxf.gLW = false;
            }
            if (this.gmm != null && this.gmm.gpk != null && (layoutParams = (FrameLayout.LayoutParams) this.gmm.gpk.getLayoutParams()) != null) {
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                layoutParams.width = (int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f);
                this.gmm.gpk.setLayoutParams(layoutParams);
            }
            if (this.gnb != null) {
                this.gnb.uC(8);
            }
            if (this.gmq != null) {
                this.gmq.lQ(false);
            }
            if (ac.Fe() != null) {
                ac.Fe().Fd();
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.y.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.y.c) runTask.getData()).Fd();
            }
            if (this.gnb != null && this.gnb.getLandscapeBarrageImageView() != null) {
                b(this.gnb.getLandscapeBarrageImageView(), this.gmE, false);
            }
            this.gmF.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.18
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.gmD) {
                        a.this.lE(false);
                    }
                }
            }, 5000L);
            if (this.gns != null) {
                this.gns.EG();
            }
            if (this.gmr != null) {
                this.gmr.setCanVisible(false);
                this.gmr.bRR();
            }
        }
        if (this.gnt != null) {
            if (i3 == 2) {
                View EV = this.gnt.EV();
                if (EV != null) {
                    if (EV.getParent() != null && (EV.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) EV.getParent()).removeView(EV);
                    }
                    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams7.addRule(5, a.g.ala_liveroom_hostheader);
                    layoutParams7.addRule(3, a.g.ala_liveroom_hostheader);
                    layoutParams7.topMargin = bOF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                    if (this.gnR != null) {
                        this.gnR.addView(EV, layoutParams7);
                    }
                }
            } else {
                View EV2 = this.gnt.EV();
                if (EV2 != null) {
                    if (EV2.getParent() != null && (EV2.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) EV2.getParent()).removeView(EV2);
                    }
                    RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams8.topMargin = bOF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18) * (-1);
                    layoutParams8.addRule(3, a.g.ala_live_header_view);
                    bOF().gxf.addView(EV2, layoutParams8);
                }
            }
        }
        if (this.gnb != null) {
            this.gnb.l(i, i2, i3);
        }
        I(i3, true);
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.gmm != null) {
                this.gmm.dz(i3);
            }
            if (this.gmo != null) {
                this.gmo.dz(i3);
            }
            if (this.gms != null) {
                this.gms.dz(i3);
            }
            if (this.gnA != null) {
                this.gnA.dz(i3);
            }
            if (this.gnw != null) {
                this.gnw.dz(i3);
            }
            if (this.gnF != null) {
                this.gnF.dz(i3);
            }
            if (this.gmG != null && this.gmG.isShowing()) {
                this.gmG.resize();
            }
            if (this.gnP != null) {
                this.gnP.dz(i3);
            }
            if (this.gnQ != null) {
                this.gnQ.dz(i3);
            }
            if (this.gnN != null) {
                this.gnN.eD(i3);
            }
        }
        if (this.gns != null) {
            this.gns.EF();
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
            if (i != 7 || UtilHelper.getRealScreenOrientation(bOF().pageContext.getPageActivity()) != 2) {
                if (this.gnb != null) {
                    this.gnb.setVisibility(8);
                }
                if (this.gnq != null) {
                    this.gnq.Jf().getView().setVisibility(4);
                }
                if (this.gnG != null) {
                    this.gnG.mD(false);
                }
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
            if (this.gnG != null) {
                this.gnG.mD(true);
            }
            if (!this.gmD || UtilHelper.getRealScreenOrientation(bOF().pageContext.getPageActivity()) != 2) {
                this.gnR.setVisibility(0);
            }
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
        if (bOF() != null) {
            BdUtilHelper.hideSoftKeyPad(bOF().pageContext.getPageActivity(), bOF().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.gmp != null) {
            this.gmp.bWj();
        }
        if (this.gmu != null) {
            this.gmu.BK();
        }
        if (this.gms != null) {
            this.gms.onStart();
        }
        if (this.gnN != null) {
            this.gnN.onStart();
        }
    }

    private void I(int i, boolean z) {
        if (this.bhH != null) {
            int dimensionPixelSize = bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bhH.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                layoutParams.rightMargin = bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.height = bNl();
                this.bhH.setPosition(dimensionPixelSize, 0, dimensionPixelSize, 0);
                if (z) {
                    this.gnh.lD(true);
                }
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                int dimensionPixelSize2 = bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds72) + 0 + bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100) + bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
                layoutParams.height = -1;
                this.bhH.setPosition(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
                this.gnh.lD(false);
            }
            layoutParams.bottomMargin = bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            this.bhH.setLayoutParams(layoutParams);
            this.bhH.setModel(i == 1 ? PendantParentView.Model.HORIZONTAL : PendantParentView.Model.HORIZONTAL_FULL);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.e
    public void tR(int i) {
        I(this.mOrientation, false);
    }
}
