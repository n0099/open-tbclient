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
import com.baidu.live.data.AlaLiveSdkInfo;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.ap;
import com.baidu.live.data.bm;
import com.baidu.live.data.cb;
import com.baidu.live.data.ch;
import com.baidu.live.data.p;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.gift.ag;
import com.baidu.live.gift.ak;
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
import com.baidu.live.utils.o;
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
public class a extends b implements com.baidu.live.k.c, e {
    private PendantParentView bqg;
    private com.baidu.tieba.ala.liveroom.audiencelist.c gPE;
    private com.baidu.tieba.ala.liveroom.p.a gPF;
    private com.baidu.tieba.ala.liveroom.g.b gPG;
    private com.baidu.tieba.ala.liveroom.v.b gPH;
    private com.baidu.tieba.ala.liveroom.audiencelist.b gPI;
    private com.baidu.tieba.ala.liveroom.l.a gPJ;
    private com.baidu.tieba.ala.liveroom.activeview.b gPK;
    private com.baidu.live.d.a gPL;
    private i gPM;
    private h gPN;
    private com.baidu.tieba.ala.liveroom.c.a gPO;
    private com.baidu.live.im.b.a gPP;
    private com.baidu.tieba.ala.liveroom.share.b gPQ;
    private com.baidu.live.y.a gPR;
    private FrameLayout gPS;
    private FrameLayout gPT;
    private ImageView gPU;
    private com.baidu.live.tieba.e.b gPV;
    private ag gQa;
    private com.baidu.tieba.ala.liveroom.j.b gQb;
    private long lastClickTime = 0;
    private boolean gPW = false;
    private boolean gPX = false;
    private boolean gPY = false;
    private Handler gPZ = new Handler();
    private HttpRule gQc = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.gPM != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.gPM.Di()) {
                httpMessage.addParam("ala_challenge_id", a.this.gPM.Dl());
            }
            return httpMessage;
        }
    };
    private HttpRule gQd = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.a.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.gPM != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.gPM.Di()) {
                httpMessage.addParam("challenge_id", a.this.gPM.Dl());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c gQe = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.19
        @Override // com.baidu.live.liveroom.g.c
        public void NB() {
            if (a.this.gQE != null) {
                a.this.gQE.nI(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cj(boolean z) {
            if (z) {
                if (a.this.gQE != null) {
                    a.this.gQE.nI(true);
                }
            } else if (a.this.gQE != null) {
                a.this.gQE.nI(false);
            }
            if (a.this.gQW != null) {
                a.this.gQW.bs(z);
            }
            if (a.this.gPK != null) {
                a.this.gPK.my(z ? false : true);
            }
            com.baidu.live.n.a.ck(z);
        }
    };
    private com.baidu.tieba.ala.liveroom.p.c gQf = new com.baidu.tieba.ala.liveroom.p.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.20
        @Override // com.baidu.tieba.ala.liveroom.p.c
        public void onClick() {
            a.this.gPZ.removeCallbacksAndMessages(null);
            a.this.gPW = true;
        }

        @Override // com.baidu.tieba.ala.liveroom.p.c
        public void endAnimation() {
            if (a.this.gPW) {
                a.this.bUD();
            }
        }
    };
    private HttpMessageListener gQg = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.NK() != null) {
                        com.baidu.live.z.e.PD().bsJ = getQuickGiftHttpResponseMessage.NK();
                        a.this.bUS();
                    }
                }
            }
        }
    };
    private CustomMessageListener gQh = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                a.this.gQM.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gQi = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.gRa != null) {
                    a.this.gRa.hM(str);
                }
            }
        }
    };
    CustomMessageListener gQj = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.gRv != null && a.this.gRv.bfe != null && !a.this.gRv.bfh && !a.this.gRv.bfi && a.this.gQV != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.bWj().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = a.this.bWj().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                a.this.gQV.c(a.this.gPS, layoutParams);
                if (com.baidu.live.guardclub.e.Ke() != null) {
                    com.baidu.live.guardclub.e.Ke().Kk();
                }
            }
        }
    };
    private CustomMessageListener gQk = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (a.this.gQX != null) {
                    a.this.gQX.dismiss();
                }
                if (a.this.gRa != null) {
                    a.this.gRa.dismiss();
                }
                if (a.this.gQY != null) {
                    a.this.gQY.dismiss();
                }
                if (a.this.gFm != null) {
                    a.this.gFm.dismiss();
                }
                com.baidu.live.im.b.d.LG().setSwitchStatus(true);
                com.baidu.live.im.b.d.LG().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bVG();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener gQl = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.gQb.c(a.this.bWj());
                } else if (a.this.bVz() || !g.vv(2913168)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.bWj().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.bWj().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    a.this.gQb.c(a.this.gPS, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gQm = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.a.13
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void p(View view, int i) {
            bm bmVar;
            cb cbVar;
            ch chVar;
            String str;
            bm bmVar2;
            cb cbVar2;
            String str2;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - a.this.lastClickTime >= 300) {
                a.this.lastClickTime = currentTimeMillis;
                if (i == 2 && a.this.Jl()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel"));
                    a.this.M(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.z.e.PD().bsJ.Gp().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.z.e.PD().bsJ.Gp().Fs());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.z.e.PD().bsJ.Gp().Ft());
                        if (a.this.bWj().haB.GH() != null && a.this.bWj().haB.GH().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.bWj().haB.GH().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.bWj().haB.GH().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.Md());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.Jl()) {
                        if (com.baidu.live.d.AZ().getBoolean("quick_gift_guide_show", true) && !a.this.bVz()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, ag.class, a.this.bWj().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                ag agVar = (ag) runTask.getData();
                                agVar.setPageContext(a.this.bWj().pageContext);
                                agVar.d(a.this.bWj().haB.GH());
                                agVar.setGiftItem(com.baidu.live.z.e.PD().bsJ.Gp());
                                agVar.setOtherParams(a.this.Md());
                                agVar.initView();
                                agVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.13.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        a.this.mE(false);
                                        a.this.gQa = null;
                                    }
                                });
                                a.this.gQa = agVar;
                                agVar.show();
                                a.this.mE(true);
                                return;
                            }
                            return;
                        }
                        n.a(a.this.bWj().pageContext, a.this.bWj().haB.GH(), com.baidu.live.z.e.PD().bsJ.Gp(), a.this.Md());
                    }
                } else if (i == 1) {
                    if (a.this.gQJ != null) {
                        a.this.bVG();
                    }
                } else if (i == 3 && a.this.Jl()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    if (a.this.mOrientation == 2 && (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                        if (a.this.gPQ != null) {
                            a.this.gPQ.H(a.this.bWj().haB.GH());
                        }
                    } else {
                        a.this.gQw.c(a.this.bWj().haB.GH(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.bWj() != null && a.this.bWj().haB != null && a.this.bWj().haB.GH() != null && a.this.bWj().haB.GH().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.bWj().haB.GH().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.bWj().haB.GH().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.bWj().haB.GH().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.Md());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.bWj() != null && a.this.bWj().haB != null && a.this.bWj().haB.GH() != null && a.this.bWj().haB.GH().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.bWj().haB.GH().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.bWj().haB.GH().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.bWj().haB.GH().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.Md());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.bmm != null) {
                        a.this.bmm.cd(false);
                    }
                } else if (i == 12) {
                    if (a.this.gQE != null) {
                        String valueOf = String.valueOf(a.this.bWj().haB.GH().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.bWj().haB.GH().mLiveInfo.room_id);
                        String str3 = null;
                        AlaLiveSdkInfo alaLiveSdkInfo = a.this.bWj().haB.GH().mLiveSdkInfo;
                        if (alaLiveSdkInfo != null && alaLiveSdkInfo.mCastIds != null) {
                            str3 = String.valueOf(a.this.bWj().haB.GH().mLiveSdkInfo.mCastIds.chatMCastId);
                        }
                        a.this.gQE.ar(valueOf, valueOf2, str3);
                        com.baidu.live.n.a.b(a.this.bWj().haB.GH().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    w GH = a.this.bWj().haB.GH();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.bWj().pageContext.getPageActivity(), GH.aIe.userName, Long.toString(GH.aIe.userId), Long.toString(GH.aIe.charmCount), String.valueOf(GH.mLiveInfo.group_id), String.valueOf(GH.mLiveInfo.live_id), false, String.valueOf(GH.aIe.userId), Long.toString(GH.aIA.userId), GH.aIA.userName, GH.aIA.portrait, a.this.gPI.getCount(), a.this.Md())));
                    LogManager.getCommonLogger().doClickGusetNumLog(GH.mLiveInfo.feed_id, a.this.gPI.getCount() + "", a.this.Md());
                } else if (i == 11) {
                    a.this.bVJ();
                    a.this.bVK();
                } else if (i == 16) {
                    if (a.this.bWj() != null && (bmVar2 = com.baidu.live.z.a.Pq().bsy) != null && (cbVar2 = bmVar2.aOA) != null) {
                        String str4 = cbVar2.aPQ.aPX;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (a.this.bWj().haB != null && a.this.bWj().haB.GH() != null && a.this.bWj().haB.GH().mLiveInfo != null) {
                                j = a.this.bWj().haB.GH().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", a.this.bWj().haB.GH().mLiveInfo.room_id + "", a.this.bWj().haB.GH().mLiveInfo.feed_id, a.this.Md());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.bWj().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (a.this.bWj() != null) {
                        w wVar = null;
                        if (a.this.bWj().haB != null) {
                            wVar = a.this.bWj().haB.GH();
                        }
                        if (wVar != null && wVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.w.b.ceK().bmT != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.w.b.ceK().bmT.aHs;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(a.this.bWj().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17) {
                    if (a.this.Jl() && a.this.bWj() != null && (bmVar = com.baidu.live.z.a.Pq().bsy) != null && (cbVar = bmVar.aOA) != null && (chVar = cbVar.aPR) != null && !TextUtils.isEmpty(chVar.webUrl)) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                        if (a.this.gQX != null && a.this.bWj().haB != null && a.this.bWj().haB.GH() != null) {
                            w GH2 = a.this.bWj().haB.GH();
                            a.this.gQX.a(chVar.webUrl, GH2.mLiveInfo.live_id, GH2.aIA.userId, GH2.aIe.userId);
                            a.this.gPV.cD(false);
                            a.this.gPV.QK();
                        }
                    }
                } else if (i == 18) {
                    if (a.this.gPY) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.gPY = !a.this.gPY;
                } else if (i == 19 && a.this.gPV != null) {
                    a.this.gPV.QK();
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.gQy = new com.baidu.tieba.ala.liveroom.guide.c(bWj().pageContext, this, false);
        this.gQc.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.gQc);
        this.gQd.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.gQd);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean bUC() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUD() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.21
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gPX) {
                    a.this.mA(false);
                }
            }
        }, 5000L);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void m(w wVar) {
        super.m(wVar);
        g.bZC();
        this.gPY = false;
        if (this.gQB != null) {
            this.gQB.b(this.gQm);
        }
        if (this.gPV == null) {
            this.gPV = new com.baidu.live.tieba.e.b(bWj().pageContext.getPageActivity());
            this.gPV.start();
        }
        this.gPV.cD(true);
        bWj().pageContext.getPageActivity().setRequestedOrientation(-1);
        bWj().haC.setIsForceHandledTouch(false);
        bWj().haC.setSwipeClearEnable(true);
        bWj().haC.setOnLiveViewScrollListener(this.gQe);
        bWj().haC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gPZ.removeCallbacksAndMessages(null);
                a.this.gPW = false;
                a.this.mA(false);
                if (!a.this.gPX) {
                    a.this.bUD();
                }
            }
        });
        if (this.gRo != null) {
            this.gRo.setVisibility(0);
        }
        bUK();
        if (this.gQT != null) {
            this.gQT.a(wVar, this.bqg);
            this.gQT.U(this.gRp);
            this.gQT.a(this);
        }
        bUV();
        bVu();
        bUW();
        bUI();
        bVa();
        bUX();
        bUE();
        mF(false);
        bVM();
        bVc();
        bVS();
        bVX();
        bVN();
        bVR();
        bUT();
        bUU();
        bVO();
        bUG();
        bVd();
        mG(true);
        bUM();
        bUS();
        bWb();
        bUN();
        bUO();
        bUP();
        bUQ();
        bUJ();
        bVe();
        bUF();
        bWa();
        if (this.gQX != null && this.gQX.ceR() == null) {
            this.gQX.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.23
                @Override // com.baidu.tieba.ala.liveroom.turntable.d.a
                public void onDismiss() {
                    a.this.gPV.cD(true);
                }
            });
        }
        if (this.gQY != null && this.gQY.bZH() == null) {
            this.gQY.a(new a.InterfaceC0665a() { // from class: com.baidu.tieba.ala.liveroom.d.a.24
                @Override // com.baidu.tieba.ala.liveroom.m.a.InterfaceC0665a
                public void onDismiss() {
                    a.this.gPV.cD(true);
                }
            });
        }
        c(this.fVh);
        MessageManager.getInstance().registerListener(this.gQg);
        MessageManager.getInstance().registerListener(this.gQj);
        MessageManager.getInstance().registerListener(this.gQk);
        MessageManager.getInstance().registerListener(this.gQl);
        MessageManager.getInstance().registerListener(this.gQi);
        MessageManager.getInstance().registerListener(this.gQh);
        bVf();
        bUZ();
        if (this.mOrientation == 2) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(bWj().pageContext.getPageActivity());
            l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(bWj().pageContext.getPageActivity()));
        }
        if (this.gRi != null) {
            this.gRi.A(wVar);
        }
    }

    private void bUE() {
        if (this.gRi == null) {
            View view = null;
            if (this.gQB != null && this.gQB.getView() != null) {
                view = this.gQB.getView();
            }
            this.gRi = new com.baidu.tieba.ala.liveroom.exclusive.b(bWj().pageContext, Nx(), bWj().haC, view, this.gPE.gSL, this);
        }
    }

    private void bUF() {
        if (this.gRh != null) {
            this.gRh.a(new com.baidu.live.u.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.25
                @Override // com.baidu.live.u.c
                public void cq(boolean z) {
                    if (a.this.gPN != null) {
                        a.this.gPN.setNeedCloseRecommendFloat(z);
                    }
                    if (a.this.bWj().haC.hqj) {
                        if (a.this.gQE != null) {
                            a.this.gQE.nA(z);
                            a.this.gQE.nI(!z);
                        }
                        if (a.this.gQB != null) {
                            a.this.gQB.nA(z);
                            a.this.gQB.setPraiseEnable(!z);
                            a.this.gQB.nz(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mA(boolean z) {
        View GG;
        if (bWj() != null && bWj().pageContext != null && bWj().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(bWj().pageContext.getPageActivity()) == 2 || z) {
                if (this.gQM != null && (GG = this.gQM.GG()) != null) {
                    if (this.gPX) {
                        GG.setVisibility(0);
                    } else {
                        GG.setVisibility(8);
                    }
                }
                if (this.gPX) {
                    if (this.gRo != null) {
                        this.gRo.setVisibility(0);
                    }
                    if (this.gRp != null) {
                        this.gRp.setVisibility(0);
                    }
                    if (this.bqg != null) {
                        this.bqg.setVisibility(0);
                    }
                    if (this.bqg != null) {
                        this.bqg.setVisibility(0);
                    }
                    if (this.gQL != null) {
                        this.gQL.bq(false);
                    }
                } else {
                    if (this.gRo != null) {
                        this.gRo.setVisibility(8);
                    }
                    if (this.gRp != null) {
                        this.gRp.setVisibility(8);
                    }
                    if (this.bqg != null) {
                        this.bqg.setVisibility(8);
                    }
                    if (this.bqg != null) {
                        this.bqg.setVisibility(8);
                    }
                    if (this.gQL != null) {
                        this.gQL.bq(true);
                    }
                }
                this.gPX = this.gPX ? false : true;
                if (this.gPK != null) {
                    this.gPK.my(this.gPX);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, boolean z2) {
        ImageView imageView;
        View Gg;
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view;
        }
        if (z) {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_off);
            }
            if (this.gPT != null) {
                this.gPT.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_on);
            }
            if (this.gPT != null) {
                this.gPT.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.gQL != null && (Gg = this.gQL.Gg()) != null) {
            if (z) {
                Gg.setVisibility(8);
            } else {
                Gg.setVisibility(0);
            }
        }
    }

    private void bUG() {
        CustomResponsedMessage runTask;
        if (this.gPP == null && (runTask = MessageManager.getInstance().runTask(2913164, com.baidu.live.im.b.a.class, bWj().pageContext)) != null) {
            this.gPP = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gPP != null) {
            this.gPP.setOtherParams(this.otherParams);
            this.gPP.a(new a.InterfaceC0186a() { // from class: com.baidu.tieba.ala.liveroom.d.a.2
                @Override // com.baidu.live.im.b.a.InterfaceC0186a
                public void LF() {
                    a.this.bVV();
                }
            });
        }
    }

    private void bUH() {
        if (this.gQD != null) {
            this.gQD.az(bWj().haA.getLiveContainerView());
        }
    }

    private void bUI() {
        if (this.gPQ == null) {
            this.gPQ = new com.baidu.tieba.ala.liveroom.share.b(bWj().pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void bUJ() {
        if (bWj() != null) {
            if (this.gPR == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.y.a.class, bWj().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gPR = (com.baidu.live.y.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.gPR.setIsHost(false);
            this.gPR.a(this.bqg, bWj().haB.GH().aJa);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void dM(int i) {
        super.dM(i);
        if (this.gPU != null && UtilHelper.getRealScreenOrientation(bWj().pageContext.getPageActivity()) != 2) {
            this.gPU.setVisibility(0);
        }
        bUH();
        if (this.gPN != null) {
            this.gPN.dM(i);
        }
        if (this.gPN == null || !this.gPN.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
        if (this.gRi != null) {
            this.gRi.bZa();
        }
    }

    private void bUK() {
        if (this.bqg == null) {
            PendantParentView.Model model = PendantParentView.Model.HORIZONTAL;
            if (this.mOrientation == 2) {
                model = PendantParentView.Model.HORIZONTAL_FULL;
            }
            this.bqg = new PendantParentView(bWj().pageContext.getPageActivity(), model);
            bWj().haC.addView(this.bqg, ((bWj().haC.getView() == null || this.gQB == null || this.gQB.getView() == null) ? -1 : bWj().haC.getView().indexOfChild(this.gQB.getView())) + 1, new RelativeLayout.LayoutParams(-1, bUL()));
            this.bqg.setDefaultItemMargin(bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            K(this.mOrientation, false);
        }
    }

    private int bUL() {
        int bottom;
        int bottom2;
        if (bWj().bmp.getLivePlayer().getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bWj().bmp.getLivePlayer().getLayoutParams();
            bottom = layoutParams.topMargin + layoutParams.height;
        } else {
            bottom = bWj().bmp.getLivePlayer().getBottom();
        }
        if (bWj().haC.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) bWj().haC.getLayoutParams();
            bottom2 = layoutParams2.topMargin + layoutParams2.height;
        } else {
            bottom2 = bWj().haC.getBottom();
        }
        int i = 0;
        if (this.gRi != null) {
            i = this.gRi.getHeight();
        }
        return (((bottom2 - bottom) - i) - bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
    }

    private void bUM() {
        if (this.gPK == null) {
            this.gPK = new com.baidu.tieba.ala.liveroom.activeview.b(bWj().pageContext);
        }
        if (bWj() != null && bWj().haB != null) {
            this.gPK.Ht(bWj().haB.cea());
        }
        this.gPK.setOtherParams(Md());
        this.gPK.b(bWj().haB.GH(), true);
        this.gPK.setHost(false);
        this.gPK.a(1, this.bqg);
        this.gPK.a(2, this.bqg);
        this.gPK.setVisible(this.gRs ? 8 : 0);
    }

    private void bUN() {
        if (this.bqg != null) {
            if (this.gPJ == null) {
                this.gPJ = new com.baidu.tieba.ala.liveroom.l.a(bWj().pageContext, this);
            }
            this.gPJ.setOtherParams(Md());
            this.gPJ.a((ViewGroup) this.bqg, bUR());
            this.gPJ.B(bWj().haB.GH());
        }
    }

    private void bUO() {
        if (this.gQV == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, j.class, bWj().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gQV = (j) runTask.getData();
            } else {
                return;
            }
        }
        this.gQV.setOtherParams(Md());
        if (this.gPS != null && this.gPS.indexOfChild(this.gQV.getView()) >= 0) {
            this.gPS.removeView(this.gQV.getView());
        }
    }

    private void bUP() {
        if (this.gQu != null) {
            this.gQu.a(new a.InterfaceC0668a() { // from class: com.baidu.tieba.ala.liveroom.d.a.9
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0668a
                public void bM(int i, int i2) {
                    w GH = a.this.bWj().haB.GH();
                    if (GH != null && GH.mLiveInfo != null) {
                        if (a.this.gQZ == null) {
                            a.this.gQZ = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.bWj().pageContext.getPageActivity());
                        }
                        a.this.gQZ.d(a.this.gRp, i, i2);
                        a.this.gQZ.a(String.valueOf(GH.mLiveInfo.live_id), new a.InterfaceC0672a() { // from class: com.baidu.tieba.ala.liveroom.d.a.9.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0672a
                            public void a(float f, String str) {
                                if (a.this.gQu != null) {
                                    a.this.gQu.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0668a
                public void bN(int i, int i2) {
                    if (a.this.gQZ != null) {
                        a.this.gQZ.bS(i, i2);
                    }
                }
            });
        }
    }

    private void bUQ() {
        if (this.gRE == null) {
            this.gRE = new com.baidu.tieba.ala.liveroom.j.e(bWj().pageContext);
        }
        this.gRE.setRoomId(bWj().haB.GH().mLiveInfo.room_id);
        this.gRE.HN("");
        this.gRE.b(bWj().haB.GH(), this.bqg);
        if (this.gQb == null) {
            this.gQb = new com.baidu.tieba.ala.liveroom.j.b(bWj().pageContext, Md(), this.gRE, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.10
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bVn() {
                    a.this.mE(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bVo() {
                    a.this.mE(false);
                }
            });
        }
        this.gQb.setRoomId(bWj().haB.GH().mLiveInfo.room_id);
        if (this.gPS != null && this.gPS.indexOfChild(this.gQb.getView()) >= 0) {
            this.gPS.removeView(this.gQb.getView());
        }
        if (this.gQb != null) {
            this.gQb.b(bWj());
        }
    }

    private LinearLayout.LayoutParams bUR() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = bWj().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUS() {
        if (this.gQu == null) {
            bUX();
        }
        this.gQu.a(com.baidu.live.z.e.PD().bsJ, bWj().haB.GH());
    }

    private void bUT() {
        CustomResponsedMessage runTask;
        boolean z = true;
        if (this.gQJ == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, bWj().pageContext)) != null && runTask.getData() != null) {
            this.gQJ = (k) runTask.getData();
            this.gQJ.setFromMaster(false);
            this.gQJ.Lj().getView().setId(a.g.ala_liveroom_msg_list);
            this.gQJ.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.11
                @Override // com.baidu.live.im.k.a
                public boolean Lm() {
                    return a.this.Jl();
                }

                @Override // com.baidu.live.im.k.a
                public void Ln() {
                    a.this.gRw = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hC(String str) {
                    if (!a.this.gRs) {
                        a.this.mC(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.bWj().pageContext.getPageActivity(), a.this.bWj().haA.getLiveContainerView());
                    }
                    a.this.Hz(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Lo() {
                    if (a.this.gRs) {
                        a.this.mC(true);
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.bWj().pageContext.getPageActivity(), a.this.bWj().haA.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (a.this.gQJ != null) {
                        a.this.gQJ.Lk().setQuickInputPanelVisible(false);
                        a.this.gQJ.Lk().MF();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Lp() {
                    if (a.this.gRs) {
                        a.this.bVm();
                        if (a.this.gQK != null) {
                            a.this.gQK.Cs();
                        }
                        if (a.this.gPP != null) {
                            a.this.gPP.Cs();
                        }
                    } else if (a.this.gQJ != null) {
                        a.this.gQJ.Lk().setQuickInputPanelVisible(false);
                        a.this.gQJ.Lk().MF();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Lq() {
                    return a.this.bVA();
                }

                @Override // com.baidu.live.im.k.a
                public int Lr() {
                    return a.this.bVB();
                }
            });
            this.gPS = new FrameLayout(bWj().pageContext.getPageActivity());
            this.gPS.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.gQJ != null && this.gPS != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bWj().pageContext.getPageActivity()) * 0.7f);
            int i = com.baidu.live.af.b.i(true, false);
            if (this.gRp.indexOfChild(this.gPS) < 0) {
                if (this.gPS.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gPS.getParent()).removeView(this.gPS);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                this.gRp.addView(this.gPS, layoutParams);
            }
            if (this.gPS.indexOfChild(this.gQJ.Lj().getView()) < 0) {
                if (this.gQJ.Lj().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gQJ.Lj().getView()).removeView(this.gQJ.Lj().getView());
                }
                if (UtilHelper.getRealScreenOrientation(bWj().pageContext.getPageActivity()) != 2) {
                    this.gPS.addView(this.gQJ.Lj().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, i));
                }
            }
            if (bWj().haC.indexOfChild(this.gQJ.Lk().getView()) < 0) {
                if (this.gQJ.Lk().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gQJ.Lk().getView().getParent()).removeView(this.gQJ.Lk().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bVH();
                bWj().haC.addView(this.gQJ.Lk().getView(), layoutParams2);
            }
            w GH = bWj().haB.GH();
            if (GH != null && GH.mLiveInfo != null) {
                this.gQJ.setLogData(GH.mLiveInfo.feed_id, Md());
            }
            if (GH == null || GH.aIQ == null || !GH.aIQ.DH()) {
                z = false;
            }
            this.gQJ.a(String.valueOf(bWj().haB.GH().mLiveInfo.group_id), String.valueOf(bWj().haB.GH().mLiveInfo.last_msg_id), String.valueOf(bWj().haB.GH().aIe.userId), String.valueOf(bWj().haB.GH().mLiveInfo.live_id), bWj().haB.GH().aIe.appId, z);
            mC(false);
        }
    }

    private void bUU() {
        if (this.gPT == null) {
            this.gPT = new FrameLayout(bWj().pageContext.getPageActivity());
            this.gPT.setId(a.g.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void bUV() {
        if (this.gPF == null) {
            this.gPF = new com.baidu.tieba.ala.liveroom.p.a(bWj().pageContext, false, this);
        }
        this.gPF.d(this.gRo, bWj().haB.GH());
        this.gPF.a(this.gQf);
        this.gPF.a(this.gQm);
    }

    private void bUW() {
        if (this.gPE == null) {
            this.gPE = new com.baidu.tieba.ala.liveroom.audiencelist.c(bWj().pageContext, this, false);
        }
        this.gPE.a(String.valueOf(bWj().haB.GH().mLiveInfo.group_id), String.valueOf(bWj().haB.GH().mLiveInfo.live_id), String.valueOf(bWj().haB.GH().aIe.userId), bWj().haB.GH());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.gQv != null && this.gQv.getView() != null && this.gQv.getView().getParent() != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.gPE.c(this.gRo, i, a.g.ala_liveroom_audience_count_layout);
            this.gPE.e(bWj().haB.bOQ());
        }
    }

    private void bUX() {
        com.baidu.live.core.a.a MT;
        if (this.gQu == null) {
            this.gQu = new com.baidu.tieba.ala.liveroom.operation.a(bWj().pageContext);
        }
        this.gQu.a(bWj(), this.gRp, bWj().haB.GH().mLiveInfo, true, this.gQm);
        this.gQu.setOtherParams(Md());
        if (this.gQT != null && (MT = this.gQT.MT()) != null) {
            View rootLayout = MT.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.gQu.cb(rootLayout);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void bUY() {
        bUZ();
    }

    private void bUZ() {
        if (this.gQu != null) {
            int i = bWj().haB.GH().aIA.isUegBlock;
            int i2 = bWj().haB.GH().aIA.isBlock;
            String str = bWj().haB.GH().aIA.userName;
            if (i > 0 || i2 > 0) {
                this.gQu.b(true, i, i2, str);
                this.gQJ.a(true, i, i2, str);
                this.gQP.b(true, i, i2, str);
                return;
            }
            this.gQu.b(false, i, i2, str);
            this.gQJ.a(false, i, i2, str);
            this.gQP.b(false, i, i2, str);
        }
    }

    private void bVa() {
        if (this.gPI == null) {
            this.gPI = new com.baidu.tieba.ala.liveroom.audiencelist.b(bWj().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (bWj().haB.bOQ() != null) {
            j = bWj().haB.bOQ().getCount();
        }
        this.gPI.a(this.gQm);
        this.gPI.a(this.gRo, a.g.ala_liveroom_hostheader, j);
        this.gPI.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.gPI.mN(false);
        } else {
            this.gPI.mN(true);
        }
    }

    public void bVb() {
        this.gQw.c(bWj().haB.GH(), false);
    }

    public void bVc() {
        if (bWj().haB.GH() != null && bWj().haB.GH().aIe != null && bWj().haB.GH().mLiveInfo != null) {
            if (this.gPH == null) {
                this.gPH = new com.baidu.tieba.ala.liveroom.v.b(bWj().pageContext);
            }
            long j = bWj().haB.GH().aIe.userId;
            int i = bWj().haB.GH().mLiveInfo.live_type;
            String str = bWj().haB.GH().aIe.portrait;
            String str2 = bWj().haB.GH().mLiveInfo.feed_id;
            long j2 = bWj().haB.GH().mLiveInfo.live_id;
            this.gPH.a(i, j, bWj().haB.GH().aIe.userName, false, str, Md(), str2, j2);
            this.gPH.av(this.gRo);
        }
    }

    private void bVd() {
        boolean z = false;
        if (this.gQE == null) {
            this.gQE = new com.baidu.tieba.ala.liveroom.x.a(bWj().pageContext, this);
        }
        this.gQE.d(bWj().haC, false);
        boolean bWi = bWi();
        AlaLiveInfoData alaLiveInfoData = bWj().haB.GH().mLiveInfo;
        boolean isZanAnimUnabled = (alaLiveInfoData == null || alaLiveInfoData.mAlaLiveSwitchData == null) ? false : alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled();
        if (bWi && !isZanAnimUnabled) {
            z = true;
        }
        this.gQE.nH(z);
    }

    private void bVe() {
        if (bWj() != null && bWj().bmp != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(bWj().pageContext.getPageActivity());
            Activity pageActivity = bWj().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + o.aH(pageActivity)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.gPU = new ImageView(bWj().pageContext.getPageActivity());
            this.gPU.setVisibility(8);
            this.gPU.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.gPU.setImageResource(a.f.icon_live_enlarge);
            this.gPU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.gPV != null) {
                        a.this.gPV.QJ();
                        a.this.gPU.setVisibility(4);
                    }
                }
            });
            bWj().haC.addView(this.gPU, layoutParams);
            if (UtilHelper.getRealScreenOrientation(bWj().pageContext.getPageActivity()) != 2) {
                if (bWj().haH) {
                    this.gPU.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.15
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.gPU != null && UtilHelper.getRealScreenOrientation(a.this.bWj().pageContext.getPageActivity()) != 2) {
                                a.this.gPU.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
        }
    }

    private void bVf() {
        if (this.gRw || this.gRx) {
            if ((TbadkCoreApplication.isLogin() && this.gQJ.Lk().hasText()) || this.gRx) {
                this.gRw = false;
                this.gRx = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.16
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bVG();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void s(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        super.s(aVar);
        if (this.gPK != null) {
            this.gPK.C(aVar);
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
        if (this.gPR == null || !this.gPR.O(jSONObject)) {
            if ((aVar.getMsgType() == 12 || aVar.getMsgType() == 13) && jSONObject != null) {
                String optString = jSONObject.optString("content_type");
                if ("task".equals(optString)) {
                    if (this.gPJ != null) {
                        this.gPJ.L(jSONObject);
                    }
                } else if ("enter_live".equals(optString)) {
                    if (this.gPI != null && this.gPI.getCount() > 20) {
                        this.gPI.ea(this.gPI.getCount() + 1);
                    } else if (this.gPE != null) {
                        com.baidu.live.data.a LO = aVar.LO();
                        p pVar = new p();
                        pVar.aIf = new AlaLocationData();
                        pVar.aIg = new AlaRelationData();
                        pVar.aIe = new AlaLiveUserInfoData();
                        pVar.aIe.userId = JavaTypesHelper.toLong(LO.userId, 0L);
                        pVar.aIe.userName = LO.userName;
                        pVar.aIe.portrait = LO.portrait;
                        if (this.gPI != null && this.gPE.c(pVar)) {
                            this.gPI.ea(this.gPI.getCount() + 1);
                        }
                    }
                } else if ("update_liveinfo".equals(optString)) {
                    if (bWj().haB.GH() != null && bWj().haB.GH().mLiveInfo != null) {
                        bWj().haB.a(bWj().haB.GH().mLiveInfo.live_id, bWj().fromType, bWj().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && bWj().haB.GH() != null && bWj().haB.GH().mLiveInfo != null && bWj().haB.GH().aIA != null && this.gPN != null) {
                    long optLong = jSONObject.optLong("mvp_user_id");
                    long optLong2 = jSONObject.optLong("winner_live_id");
                    if (optLong == bWj().haB.GH().aIA.userId && optLong2 == bWj().haB.GH().mLiveInfo.live_id) {
                        this.gPN.d(jSONObject.optInt("challenge_status"), jSONObject.optLong("challenge_id"));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void Hv(String str) {
        if (this.gPK != null) {
            this.gPK.Hv(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(w wVar) {
        super.k(wVar);
        if (this.gPF != null) {
            this.gPF.C(wVar);
        }
        if (this.gPG != null) {
            this.gPG.y(wVar);
        }
        if (this.gPJ != null) {
            this.gPJ.B(wVar);
        }
        if (this.gPN != null) {
            this.gPN.a(wVar);
        }
        if (this.gPP != null) {
            this.gPP.a(wVar);
        }
        if (this.gPK != null) {
            this.gPK.j(wVar);
            if (wVar != null && this.gRj != null && !this.gRj.hasInit && !TextUtils.isEmpty(this.gRj.aOU)) {
                this.gRj.hasInit = true;
                this.gPK.Hw(this.gRj.aOU);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(q qVar) {
        if (qVar != null) {
            if (this.gPE != null && qVar.getList() != null) {
                this.gPE.e(qVar);
            }
            if (this.gPI != null) {
                this.gPI.ea(qVar.getCount());
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void ci(boolean z) {
        super.ci(z);
        if (bWj().haC != null) {
            bWj().haC.cft();
            bWj().haC.setLiveViewOnDispatchTouchEventListener(null);
            bWj().haC.setLiveViewOnTouchEventListener(null);
            bWj().haC.setOnLiveViewScrollListener(null);
        }
        if (bWj().bmp != null) {
            bWj().bmp.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.gPN != null) {
            this.gPN.CT();
        }
        bVg();
        if (this.gPH != null) {
            this.gPH.CT();
        }
        if (this.gQE != null) {
            this.gQE.release();
        }
        if (this.gPJ != null) {
            this.gPJ.CT();
        }
        if (this.gPR != null) {
            this.gPR.Kj();
        }
        if (this.gQu != null) {
            this.gQu.ced();
        }
        if (this.gPG != null) {
            this.gPG.bYB();
            this.gPG.setVisible(8);
        }
        if (this.gPL != null) {
            this.gPL.CT();
        }
        if (this.gPK != null) {
            this.gPK.release();
        }
        if (this.bqg != null) {
            this.bqg.removeAllViews();
            this.bqg = null;
        }
        if (this.gPM != null) {
            this.gPM.CT();
        }
        if (this.gPP != null) {
            this.gPP.a((a.InterfaceC0186a) null);
            this.gPP.Ct();
        }
        if (this.gPF != null) {
            this.gPF.caG();
        }
        if (this.gPU != null && (this.gPU.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gPU.getParent()).removeView(this.gPU);
        }
        if (this.gPQ != null) {
            this.gPQ.dismiss();
        }
        if (this.gPV != null) {
            this.gPV.cD(false);
            this.gPV.QK();
        }
        if (this.gQb != null) {
            this.gQb.CT();
        }
        if (this.gRE != null) {
            this.gRE.bXv();
        }
        if (this.gRl != null) {
            this.gRl.CT();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void n(w wVar) {
        View Cr;
        super.n(wVar);
        if (this.gPP != null && (Cr = this.gPP.Cr()) != null && Cr.getParent() != null) {
            ((ViewGroup) Cr.getParent()).removeView(Cr);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.gPP != null) {
            this.gPP.setOtherParams(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cg(boolean z) {
        super.cg(z);
        this.gPZ.removeCallbacksAndMessages(null);
        bVg();
        this.gPX = false;
        this.gPY = false;
        if (this.gPF != null) {
            this.gPF.onDestroy();
        }
        if (this.gPH != null) {
            this.gPH.onDestroy();
        }
        if (this.gPJ != null) {
            this.gPJ.onDestroy();
        }
        if (this.gPL != null) {
            this.gPL.onDestroy();
        }
        if (this.gPM != null) {
            this.gPM.onDestroy();
        }
        if (this.gPN != null) {
            this.gPN.onDestroy();
        }
        if (this.gPO != null) {
            this.gPO.onDestroy();
        }
        if (this.gPQ != null) {
            this.gPQ.onDestroy();
        }
        if (this.gPG != null) {
            this.gPG.onDestroy();
        }
        if (this.gPV != null) {
            this.gPV.stop();
        }
        if (this.gQE != null) {
            this.gQE.onDestroy();
        }
        if (this.gPE != null) {
            this.gPE.onDestroy();
        }
        if (this.gQJ != null) {
            this.gQJ.onDestroy();
        }
        if (this.gQu != null) {
            this.gQu.onDestory();
        }
        if (this.gPP != null) {
            this.gPP.a((a.InterfaceC0186a) null);
            this.gPP.release();
            this.gPP = null;
        }
        if (this.gRE != null) {
            this.gRE.cg(z ? false : true);
        }
        if (this.gQb != null) {
            this.gQb.onDestroy();
            this.gQb = null;
        }
        if (this.gRl != null) {
            this.gRl.onDestroy();
        }
        if (this.gPR != null) {
            this.gPR.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.gQc);
        MessageManager.getInstance().removeMessageRule(this.gQd);
        MessageManager.getInstance().unRegisterListener(this.gQg);
        MessageManager.getInstance().unRegisterListener(this.gQj);
        MessageManager.getInstance().unRegisterListener(this.gQk);
        MessageManager.getInstance().unRegisterListener(this.gQl);
        MessageManager.getInstance().unRegisterListener(this.gQi);
        MessageManager.getInstance().unRegisterListener(this.gQh);
    }

    private void bVg() {
        if (this.gQJ != null && this.gQJ.Lj().getView() != null && this.gQJ.Lj().getView().getParent() != null) {
            ((ViewGroup) this.gQJ.Lj().getView().getParent()).removeView(this.gQJ.Lj().getView());
        }
        if (this.gPS != null && this.gPS.getParent() != null) {
            ((ViewGroup) this.gPS.getParent()).removeView(this.gPS);
        }
        if (this.gPT != null && this.gPT.getParent() != null) {
            ((ViewGroup) this.gPT.getParent()).removeView(this.gPT);
        }
        if (this.gQJ != null && this.gQJ.Lk().getView() != null) {
            this.gRp.removeView(this.gQJ.Lk().getView());
        }
        if (this.gQJ != null) {
            this.gQJ.Lj().setMsgData(new LinkedList());
            this.gQJ.Ct();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void a(ap apVar) {
        if (this.gQJ != null) {
            bVG();
            this.gQJ.Lk().setEditText(" @" + apVar.getNameShow() + " ");
        }
        if (this.gQu != null) {
            this.gQu.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void g(com.baidu.live.data.a aVar) {
        if (this.gQJ != null) {
            bVG();
            this.gQJ.Lk().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.gQu != null) {
            this.gQu.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void b(ap apVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected View bVh() {
        if (this.gQJ != null) {
            return this.gQJ.Lk().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean bVi() {
        if (this.gQJ == null || !this.gQJ.Lk().ME()) {
            return false;
        }
        mC(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected boolean bVj() {
        return this.gPF == null || this.gPF.bVj();
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected ViewGroup bVk() {
        return this.bqg;
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
                    this.gRt = false;
                    M(intExtra, intExtra2, intExtra3);
                    return;
                }
                bVb();
                return;
            }
            ats();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.gRs;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(bWj().pageContext.getPageActivity()) || z2) {
            mB(z);
        }
    }

    private void mB(boolean z) {
        if (this.gQJ != null && this.gQJ.Lj() != null) {
            this.gQJ.Lj().onKeyboardVisibilityChanged(z);
        }
        if (z || this.gQJ == null || !this.gQJ.Lk().ME()) {
            if (z) {
                if (this.gQu != null) {
                    this.gQu.setVisibility(8);
                }
                if (this.gQL != null && this.gQL.Gg() != null) {
                    this.gQL.Gg().setVisibility(8);
                }
                bVm();
                if (this.gQJ != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gQJ.Lk().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.gQJ.Lk().getView().setLayoutParams(layoutParams);
                    this.gQJ.Lk().getView().setVisibility(0);
                    this.gQJ.Lk().setQuickInputPanelVisible(false);
                }
                if (this.gRo != null) {
                    this.gRo.setVisibility(8);
                }
                if (this.gPK != null) {
                    this.gPK.setVisible(8);
                }
                if (this.gQK != null) {
                    this.gQK.Cs();
                }
                if (this.gRk != null) {
                    this.gRk.setCanVisible(false);
                }
                if (this.gRd != null) {
                    this.gRd.setCanVisible(false);
                }
                if (this.gRf != null) {
                    this.gRf.setCanVisible(false);
                }
                if (this.gRg != null) {
                    this.gRg.setVisible(8);
                }
            } else {
                bVl();
            }
            if (this.gQJ != null && this.gPS != null) {
                if (this.gRp.indexOfChild(this.gPS) != -1 && this.gPS.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gPS.getLayoutParams();
                    layoutParams2.height = com.baidu.live.af.b.i(true, z);
                    this.gPS.setLayoutParams(layoutParams2);
                }
                if (this.gPS.indexOfChild(this.gQJ.Lj().getView()) != -1 && this.gQJ.Lj().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.gQJ.Lj().getView().getLayoutParams();
                    layoutParams3.height = com.baidu.live.af.b.i(true, z);
                    this.gQJ.Lj().getView().setLayoutParams(layoutParams3);
                }
                this.gQJ.Lj().Li();
            }
        }
    }

    private void bVl() {
        if (this.gQu != null) {
            this.gQu.setVisibility(0);
        }
        if (this.gPS != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gPS.getLayoutParams();
            layoutParams.bottomMargin = bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            this.gPS.setLayoutParams(layoutParams);
        }
        if (this.gQJ != null) {
            bVH();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gQJ.Lk().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.gQJ.Lk().getView().setLayoutParams(layoutParams2);
        }
        if (this.gQu != null) {
            this.gQu.setVisibility(0);
        }
        if (this.gQL != null && this.gQL.Gg() != null) {
            this.gQL.Gg().setVisibility(0);
        }
        if (this.gRo != null && (!this.gPX || UtilHelper.getRealScreenOrientation(bWj().pageContext.getPageActivity()) != 2)) {
            this.gRo.setVisibility(0);
        }
        if (this.gPK != null) {
            this.gPK.setVisible(0);
        }
        if (this.gQK != null) {
            this.gQK.Cs();
        }
        if (this.gRk != null) {
            this.gRk.setCanVisible(true);
        }
        if (this.gRd != null) {
            this.gRd.setCanVisible(true);
        }
        if (this.gRf != null) {
            this.gRf.setCanVisible(true);
        }
        if (this.gRg != null) {
            this.gRg.setVisible(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVm() {
        boolean z;
        boolean z2 = false;
        if (this.gPS != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gPS.getLayoutParams();
            if (this.gQJ == null || this.gQJ.Lk() == null) {
                z = false;
            } else {
                z = this.gQJ.Lk().MC();
                z2 = this.gQJ.Lk().MD();
            }
            int M = M(z, z2);
            if (layoutParams.bottomMargin != M) {
                layoutParams.bottomMargin = M;
                this.gPS.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mC(boolean z) {
        if (z) {
            this.gQJ.Lk().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gPS.getLayoutParams();
            int quickInputPanelExpandHeight = this.gQJ.Lk().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.gPS.setLayoutParams(layoutParams);
                if (this.gQJ.Lj() != null) {
                    this.gQJ.Lj().Li();
                    return;
                }
                return;
            }
            return;
        }
        bVl();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        FrameLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = bWj().pageContext.getPageActivity();
        if (i3 == 1) {
            if (bWj().pageContext.getPageActivity() != null && !UtilHelper.canUseStyleImmersiveSticky()) {
                com.baidu.live.utils.q.e(bWj().pageContext.getPageActivity(), true);
            }
            if (this.gRo != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.gRo.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.gPQ != null) {
                this.gPQ.dismiss();
            }
            if (this.gPP != null) {
                this.gPP.a((a.InterfaceC0186a) null);
                this.gPP.Ct();
            }
            if (this.bmm != null) {
                this.bmm.e(true, true);
            }
            if (this.gPU != null) {
                this.gPU.setVisibility(0);
                this.gPU.bringToFront();
            }
            if (this.gQz != null) {
                this.gQz.setVisibility(0);
            }
            if (this.gQJ != null && this.gQJ.Lj().getView().getParent() != null && (this.gQJ.Lj().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gQJ.Lj().getView().getParent()).removeView(this.gQJ.Lj().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bWj().pageContext.getPageActivity()) * 0.7f);
            int i4 = com.baidu.live.af.b.i(true, false);
            if (this.gPS != null && this.gQJ != null) {
                this.gPS.addView(this.gQJ.Lj().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, i4));
            }
            if (this.gPT != null && (this.gPT.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gPT.getParent()).removeView(this.gPT);
            }
            if (this.gQK != null) {
                this.gQK.a(bWj().haB.GH(), false);
                this.gQK.a(new a.InterfaceC0186a() { // from class: com.baidu.tieba.ala.liveroom.d.a.17
                    @Override // com.baidu.live.im.b.a.InterfaceC0186a
                    public void LF() {
                        a.this.bVV();
                    }
                });
                View Cr = this.gQK.Cr();
                if (Cr != null && this.gRp != null && Cr.getParent() == null) {
                    Resources resources = bWj().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bWj().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds98));
                    layoutParams5.addRule(2, a.g.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                    this.gRp.addView(Cr, layoutParams5);
                }
            }
            if (this.gQB != null) {
                this.gQB.setPraiseEnable(true);
                bWj().haC.hqj = true;
            }
            if (this.gPE != null && this.gPE.gSM != null && (layoutParams3 = (FrameLayout.LayoutParams) this.gPE.gSM.getLayoutParams()) != null) {
                layoutParams3.width = -2;
                this.gPE.gSM.setLayoutParams(layoutParams3);
            }
            if (this.gQE != null) {
                this.gQE.cfU();
            }
            if (this.gPX) {
                mA(true);
            }
            if (this.gPY) {
                if (this.gQu != null && this.gQu.getLandscapeBarrageImageView() != null) {
                    b(this.gQu.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.gQu != null) {
                this.gQu.vU(0);
            }
            if (this.gPI != null) {
                this.gPI.mM(true);
            }
            this.gPZ.removeCallbacksAndMessages(null);
            if (this.gPJ != null) {
                this.gPJ.setCanVisible(true);
                this.gPJ.B(bWj().haB.GH());
            }
            if (this.gPR != null) {
                this.gPR.cu(true);
            }
        } else if (i3 == 2) {
            if (bWj().pageContext.getPageActivity() != null && !UtilHelper.canUseStyleImmersiveSticky()) {
                com.baidu.live.utils.q.e(bWj().pageContext.getPageActivity(), false);
            }
            if (this.gQE != null) {
                this.gQE.cfV();
            }
            if (this.gRo != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.gRo.getLayoutParams()) != null) {
                layoutParams2.topMargin = bWj().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
            }
            if (this.gQK != null) {
                this.gQK.a((a.InterfaceC0186a) null);
                this.gQK.Ct();
            }
            bWj().haC.cfv();
            if (this.bmm != null) {
                this.bmm.e(false, true);
            }
            if (this.gPU != null) {
                this.gPU.setVisibility(4);
            }
            if (this.gQJ != null && this.gQJ.Lj().getView().getParent() != null && (this.gQJ.Lj().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gQJ.Lj().getView().getParent()).removeView(this.gQJ.Lj().getView());
            }
            int max = Math.max(i, i2);
            if (this.gPT != null) {
                if (this.gPT.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gPT.getParent()).removeView(this.gPT);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
                bWj().haC.addView(this.gPT, this.bqg != null ? bWj().haC.indexOfChild(this.bqg) : -1, layoutParams6);
            }
            if (this.gPT != null && this.gPP != null) {
                this.gPP.a(bWj().haB.GH(), false);
                this.gPP.a(new a.InterfaceC0186a() { // from class: com.baidu.tieba.ala.liveroom.d.a.18
                    @Override // com.baidu.live.im.b.a.InterfaceC0186a
                    public void LF() {
                        a.this.bVV();
                    }
                });
                View Cr2 = this.gPP.Cr();
                if (Cr2 != null && this.gPT.indexOfChild(Cr2) < 0) {
                    this.gPT.addView(Cr2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bWj().pageContext.getPageActivity()), -1));
                }
            }
            if (this.gQB != null) {
                this.gQB.aC(bWj().haC);
                this.gQB.setPraiseEnable(false);
                bWj().haC.hqj = false;
            }
            if (this.gPE != null && this.gPE.gSM != null && (layoutParams = (FrameLayout.LayoutParams) this.gPE.gSM.getLayoutParams()) != null) {
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                layoutParams.width = (int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f);
                this.gPE.gSM.setLayoutParams(layoutParams);
            }
            if (this.gQu != null) {
                this.gQu.vU(8);
            }
            if (this.gPI != null) {
                this.gPI.mM(false);
            }
            if (ak.GV() != null) {
                ak.GV().GU();
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.ac.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.ac.c) runTask.getData()).GU();
            }
            if (this.gQu != null && this.gQu.getLandscapeBarrageImageView() != null) {
                b(this.gQu.getLandscapeBarrageImageView(), this.gPY, false);
            }
            bUD();
            if (this.gQL != null) {
                this.gQL.Gi();
            }
            if (this.gPJ != null) {
                this.gPJ.setCanVisible(false);
                this.gPJ.bZG();
            }
            if (this.gPR != null) {
                this.gPR.setCanVisible(false);
            }
        }
        if (this.gRf != null) {
            this.gRf.dX(i3);
        }
        if (this.gQM != null) {
            this.gQM.dX(i3);
        }
        if (this.gQu != null) {
            this.gQu.l(i, i2, i3);
        }
        K(i3, true);
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.gPE != null) {
                this.gPE.dI(i3);
            }
            if (this.gPG != null) {
                this.gPG.dI(i3);
            }
            if (this.gPK != null) {
                this.gPK.dI(i3);
            }
            if (this.gQT != null) {
                this.gQT.dI(i3);
            }
            if (this.gQP != null) {
                this.gQP.dI(i3);
            }
            if (this.gQX != null) {
                this.gQX.dI(i3);
            }
            if (this.gRa != null) {
                this.gRa.dI(i3);
            }
            if (this.gQY != null) {
                this.gQY.dI(i3);
            }
            if (this.gFm != null) {
                this.gFm.dI(i3);
            }
            if (this.gQa != null && this.gQa.isShowing()) {
                this.gQa.resize();
            }
            if (this.gRk != null) {
                this.gRk.dI(i3);
            }
            if (this.gRl != null) {
                this.gRl.dI(i3);
            }
            if (this.gRi != null) {
                this.gRi.dX(i3);
            }
        }
        if (this.gQL != null) {
            this.gQL.Gh();
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public boolean eO(int i) {
        boolean eO = super.eO(i);
        if (eO && 2 == i) {
            if (this.gPF.bVj()) {
                return false;
            }
            if (eO && this.gQE != null) {
                this.gQE.nI(false);
            }
        }
        return eO;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void vi(int i) {
        super.vi(i);
        if (i == 7 || i == 11) {
            if (i != 7 || UtilHelper.getRealScreenOrientation(bWj().pageContext.getPageActivity()) != 2) {
                if (this.gQu != null) {
                    this.gQu.setVisibility(8);
                }
                if (this.gQJ != null) {
                    this.gQJ.Lj().getView().setVisibility(4);
                }
                if (this.gQZ != null) {
                    this.gQZ.nC(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public void eP(int i) {
        super.eP(i);
        if (i == 7 || i == 11) {
            if (this.gQu != null) {
                this.gQu.setVisibility(0);
            }
            if (this.gQJ != null) {
                this.gQJ.Lj().getView().setVisibility(0);
            }
            if (this.gQZ != null) {
                this.gQZ.nC(true);
            }
            if (!this.gPX || UtilHelper.getRealScreenOrientation(bWj().pageContext.getPageActivity()) != 2) {
                this.gRo.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.gPH != null) {
            this.gPH.cez();
        }
        if (this.gPM != null) {
            this.gPM.Dc();
        }
        if (this.gPK != null) {
            this.gPK.onStop();
        }
        if (bWj() != null) {
            BdUtilHelper.hideSoftKeyPad(bWj().pageContext.getPageActivity(), bWj().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.gPH != null) {
            this.gPH.cey();
        }
        if (this.gPM != null) {
            this.gPM.Dd();
        }
        if (this.gPK != null) {
            this.gPK.onStart();
        }
        if (this.gRi != null) {
            this.gRi.onStart();
        }
    }

    private void K(int i, boolean z) {
        if (this.bqg != null) {
            int dimensionPixelSize = bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bqg.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                layoutParams.rightMargin = bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.height = bUL();
                this.bqg.setPosition(dimensionPixelSize, 0, dimensionPixelSize, 0);
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                int dimensionPixelSize2 = bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds72) + 0 + bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100) + bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
                layoutParams.height = -1;
                this.bqg.setPosition(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
            }
            layoutParams.bottomMargin = bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            this.bqg.setLayoutParams(layoutParams);
            this.bqg.setModel(i == 1 ? PendantParentView.Model.HORIZONTAL : PendantParentView.Model.HORIZONTAL_FULL);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.e
    public void vj(int i) {
        K(this.mOrientation, false);
    }
}
