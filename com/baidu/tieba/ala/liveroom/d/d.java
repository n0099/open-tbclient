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
import com.baidu.live.data.AlaLiveSdkInfo;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.ap;
import com.baidu.live.data.ax;
import com.baidu.live.data.bb;
import com.baidu.live.data.bm;
import com.baidu.live.data.cb;
import com.baidu.live.data.ch;
import com.baidu.live.data.p;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.gift.ag;
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
public class d extends b implements com.baidu.live.k.c {
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
    private FrameLayout gPS;
    private com.baidu.tieba.ala.liveroom.j.b gQb;
    private LinearLayout gSo;
    private e gSp;
    private boolean gSq;
    private long lastClickTime = 0;
    private boolean gSr = false;
    private HttpRule gQc = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.gPM != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.gPM.Di()) {
                httpMessage.addParam("ala_challenge_id", d.this.gPM.Dl());
            }
            return httpMessage;
        }
    };
    private HttpRule gQd = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.gPM != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.gPM.Di()) {
                httpMessage.addParam("challenge_id", d.this.gPM.Dl());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c gQe = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.d.16
        @Override // com.baidu.live.liveroom.g.c
        public void NB() {
            if (d.this.gQE != null) {
                d.this.gQE.nI(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cj(boolean z) {
            if (z) {
                if (d.this.gQE != null) {
                    d.this.gQE.nI(true);
                }
            } else if (d.this.gQE != null) {
                d.this.gQE.nI(false);
            }
            if (d.this.gQW != null) {
                d.this.gQW.bs(z);
            }
            if (d.this.gPK != null) {
                d.this.gPK.my(z ? false : true);
            }
            com.baidu.live.n.a.ck(z);
        }
    };
    private HttpMessageListener gQg = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.d.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.NK() != null) {
                        com.baidu.live.z.e.PD().bsJ = getQuickGiftHttpResponseMessage.NK();
                        d.this.bUS();
                    }
                }
            }
        }
    };
    CustomMessageListener gQl = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.d.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.gQb.c(d.this.bWj());
                } else if (d.this.bVz() || !g.vv(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.19.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.bWj().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.bWj().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    d.this.gQb.c(d.this.gPS, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener gSs = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.d.d.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.bVz() || !g.vv(2913128)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.vt(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    d.this.HA(str);
                }
            }
        }
    };
    private CustomMessageListener gQh = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.gQM.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gQi = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.d.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.this.gRa != null) {
                    d.this.gRa.hM(str);
                }
            }
        }
    };
    CustomMessageListener gQj = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.gRv != null && d.this.gRv.bfe != null && !d.this.gRv.bfh && !d.this.gRv.bfi && d.this.gQV != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.bWj().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = d.this.bWj().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                d.this.gQV.c(d.this.gPS, layoutParams);
                if (com.baidu.live.guardclub.e.Ke() != null) {
                    com.baidu.live.guardclub.e.Ke().Kk();
                }
            }
        }
    };
    private CustomMessageListener gQk = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.gQX != null) {
                    d.this.gQX.dismiss();
                }
                if (d.this.gRa != null) {
                    d.this.gRa.dismiss();
                }
                if (d.this.gQY != null) {
                    d.this.gQY.dismiss();
                }
                if (d.this.gFm != null) {
                    d.this.gFm.dismiss();
                }
                com.baidu.live.im.b.d.LG().setSwitchStatus(true);
                com.baidu.live.im.b.d.LG().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bVG();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gQm = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.d.14
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
            if (currentTimeMillis - d.this.lastClickTime >= 300) {
                d.this.lastClickTime = currentTimeMillis;
                if (i == 2) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel"));
                    d.this.M(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.z.e.PD().bsJ.Gp().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.z.e.PD().bsJ.Gp().Fs());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.z.e.PD().bsJ.Gp().Ft());
                        if (d.this.bWj().haB.GH() != null && d.this.bWj().haB.GH().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.bWj().haB.GH().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.bWj().haB.GH().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.Md());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.Jl()) {
                        if (com.baidu.live.d.AZ().getBoolean("quick_gift_guide_show", true) && !d.this.bVz()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, ag.class, d.this.bWj().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                ag agVar = (ag) runTask.getData();
                                agVar.setPageContext(d.this.bWj().pageContext);
                                agVar.d(d.this.bWj().haB.GH());
                                agVar.setGiftItem(com.baidu.live.z.e.PD().bsJ.Gp());
                                agVar.setOtherParams(d.this.Md());
                                agVar.initView();
                                agVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.d.d.14.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        d.this.mE(false);
                                    }
                                });
                                agVar.show();
                                d.this.mE(true);
                                return;
                            }
                            return;
                        }
                        n.a(d.this.bWj().pageContext, d.this.bWj().haB.GH(), com.baidu.live.z.e.PD().bsJ.Gp(), d.this.Md());
                    }
                } else if (i == 1) {
                    if (d.this.gQJ != null) {
                        d.this.bVG();
                    }
                } else if (i == 3 && d.this.Jl()) {
                    if (com.baidu.live.n.a.isDebug()) {
                        com.baidu.live.n.a.b(d.this.bWj().haB.GH().mLiveInfo.live_id, 0);
                        return;
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    d.this.gQw.c(d.this.bWj().haB.GH(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.bWj() != null && d.this.bWj().haB != null && d.this.bWj().haB.GH() != null && d.this.bWj().haB.GH().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.bWj().haB.GH().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.bWj().haB.GH().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.bWj().haB.GH().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.Md());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.bWj() != null && d.this.bWj().haB != null && d.this.bWj().haB.GH() != null && d.this.bWj().haB.GH().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.bWj().haB.GH().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.bWj().haB.GH().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.bWj().haB.GH().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.Md());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.bmm != null) {
                        d.this.bmm.cd(false);
                    }
                } else if (i == 12) {
                    if (d.this.gQE != null && d.this.bWj().haB.GH() != null && d.this.bWj().haB.GH().mLiveInfo != null) {
                        String valueOf = String.valueOf(d.this.bWj().haB.GH().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.bWj().haB.GH().mLiveInfo.room_id);
                        String str3 = null;
                        AlaLiveSdkInfo alaLiveSdkInfo = d.this.bWj().haB.GH().mLiveSdkInfo;
                        if (alaLiveSdkInfo != null && alaLiveSdkInfo.mCastIds != null) {
                            str3 = String.valueOf(d.this.bWj().haB.GH().mLiveSdkInfo.mCastIds.chatMCastId);
                        }
                        d.this.gQE.ar(valueOf, valueOf2, str3);
                        com.baidu.live.n.a.b(d.this.bWj().haB.GH().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    w GH = d.this.bWj().haB.GH();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.bWj().pageContext.getPageActivity(), GH.aIe.userName, Long.toString(GH.aIe.userId), Long.toString(GH.aIe.charmCount), String.valueOf(GH.mLiveInfo.group_id), String.valueOf(GH.mLiveInfo.live_id), false, String.valueOf(GH.aIe.userId), Long.toString(GH.aIA.userId), GH.aIA.userName, GH.aIA.portrait, d.this.gPI.getCount(), d.this.Md())));
                    LogManager.getCommonLogger().doClickGusetNumLog(GH.mLiveInfo.feed_id, d.this.gPI.getCount() + "", d.this.Md());
                } else if (i == 11) {
                    d.this.bVJ();
                    d.this.bVK();
                } else if (i == 16) {
                    if (d.this.bWj() != null && (bmVar2 = com.baidu.live.z.a.Pq().bsy) != null && (cbVar2 = bmVar2.aOA) != null) {
                        String str4 = cbVar2.aPQ.aPX;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (d.this.bWj().haB != null && d.this.bWj().haB.GH() != null && d.this.bWj().haB.GH().mLiveInfo != null) {
                                j = d.this.bWj().haB.GH().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", d.this.bWj().haB.GH().mLiveInfo.room_id + "", d.this.bWj().haB.GH().mLiveInfo.feed_id, d.this.Md());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.bWj().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (d.this.bWj() != null) {
                        w wVar = null;
                        if (d.this.bWj().haB != null) {
                            wVar = d.this.bWj().haB.GH();
                        }
                        if (wVar != null && wVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.w.b.ceK().bmT != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.w.b.ceK().bmT.aHs;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(d.this.bWj().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17 && d.this.Jl() && d.this.bWj() != null && (bmVar = com.baidu.live.z.a.Pq().bsy) != null && (cbVar = bmVar.aOA) != null && (chVar = cbVar.aPR) != null && !TextUtils.isEmpty(chVar.webUrl)) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                    if (d.this.gQX != null && d.this.bWj().haB != null && d.this.bWj().haB.GH() != null) {
                        w GH2 = d.this.bWj().haB.GH();
                        d.this.gQX.a(chVar.webUrl, GH2.mLiveInfo.live_id, GH2.aIA.userId, GH2.aIe.userId);
                    }
                }
            }
        }
    };
    private boolean gSt = false;
    private boolean gSu = false;

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
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void m(w wVar) {
        super.m(wVar);
        g.bZC();
        this.gSr = true;
        this.gSu = false;
        this.gSt = false;
        bWj().haC.setIsForceHandledTouch(false);
        bWj().haC.setSwipeClearEnable(true);
        bWj().haC.setOnLiveViewScrollListener(this.gQe);
        bWj().haC.setOnClickListener(null);
        bWj().haC.setClickable(false);
        if (this.gQB != null) {
            this.gQB.b(this.gQm);
        }
        if (this.gRo != null) {
            this.gRo.setVisibility(0);
        }
        bUK();
        if (this.gQT != null) {
            this.gQT.a(wVar, this.bqg);
            this.gQT.U(this.gRp);
            this.gQT.a(this);
        }
        bWB();
        bUV();
        bVu();
        bUW();
        bVa();
        bUX();
        mF(false);
        bVM();
        bUT();
        bVO();
        bVc();
        bVd();
        bWu();
        bWv();
        mG(false);
        bVQ();
        bUJ();
        bWb();
        bUM();
        bUS();
        bUN();
        bUO();
        bUP();
        bUQ();
        bUF();
        bVS();
        bVX();
        bVN();
        bVR();
        mK(true);
        bWa();
        c(this.fVh);
        MessageManager.getInstance().registerListener(this.gQg);
        MessageManager.getInstance().registerListener(this.gQh);
        MessageManager.getInstance().registerListener(this.gQj);
        MessageManager.getInstance().registerListener(this.gQk);
        MessageManager.getInstance().registerListener(this.gSs);
        MessageManager.getInstance().registerListener(this.gQl);
        MessageManager.getInstance().registerListener(this.gQi);
        bVf();
        bUZ();
    }

    private void bUF() {
        if (this.gRh != null) {
            this.gRh.a(new com.baidu.live.u.c() { // from class: com.baidu.tieba.ala.liveroom.d.d.17
                @Override // com.baidu.live.u.c
                public void cq(boolean z) {
                    if (d.this.gPN != null) {
                        d.this.gPN.setNeedCloseRecommendFloat(z);
                    }
                    if (d.this.bWj().haC.hqj) {
                        if (d.this.gQE != null) {
                            d.this.gQE.nA(z);
                            d.this.gQE.nI(!z);
                        }
                        if (d.this.gQB != null) {
                            d.this.gQB.nA(z);
                            d.this.gQB.setPraiseEnable(!z);
                            d.this.gQB.nz(z ? false : true);
                        }
                    }
                }
            });
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
        mK(false);
        if (this.gPK != null) {
            this.gPK.j(wVar);
            this.gPK.mx(this.gRy);
            this.gPK.updateView();
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

    private void bUH() {
        if (this.gQD != null) {
            this.gQD.az(bWj().haA.getLiveContainerView());
        }
    }

    private void bWu() {
        if (this.gPO == null) {
            this.gPO = new com.baidu.tieba.ala.liveroom.c.a(bWj().pageContext);
        }
        if (bWj().haB != null && bWj().haB.GH() != null && bWj().haB.GH().mLiveInfo != null) {
            this.gPO.Hx(String.valueOf(bWj().haB.GH().mLiveInfo.user_id));
        }
    }

    private void bWv() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (bWj() != null && bWj().haB != null && bWj().haB.GH() != null && bWj().haB.GH().mLiveInfo != null) {
                j = bWj().haB.GH().mLiveInfo.room_id;
            }
            if (this.gQR == null) {
                this.gQR = new com.baidu.tieba.ala.liveroom.guide.a(bWj().pageContext, j);
            }
            this.gQR.mD(this.gRr);
            this.gQR.a(new a.InterfaceC0661a() { // from class: com.baidu.tieba.ala.liveroom.d.d.4
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0661a
                public void bWE() {
                    if (d.this.bmm != null) {
                        d.this.bmm.cd(true);
                    }
                }
            });
            this.gQR.av(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void dM(int i) {
        super.dM(i);
        bUH();
        if (this.gPN != null) {
            this.gPN.dM(i);
        }
    }

    private void bUK() {
        if (this.bqg == null) {
            this.bqg = new PendantParentView(bWj().pageContext.getPageActivity(), this.gSq ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            bWj().haC.addView(this.bqg, new ViewGroup.LayoutParams(-1, -1));
            this.bqg.setDefaultItemMargin(bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.bqg.setPadding(bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20), 0, bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6), 0);
            bWw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWw() {
        int dimensionPixelSize;
        if (this.bqg != null) {
            this.bqg.setModel(this.gSq ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            int dimensionPixelSize2 = bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds220);
            int dimensionPixelSize3 = bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            if (this.gSq) {
                dimensionPixelSize = bWC();
            } else {
                dimensionPixelSize = bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200);
            }
            this.bqg.setPosition(dimensionPixelSize2, 0, dimensionPixelSize, dimensionPixelSize3);
            return;
        }
        bUK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWx() {
        if (bWj().haC != null && !this.gSu) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.5
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.gPS != null && d.this.gQJ != null && d.this.gQJ.Lj() != null && d.this.gQJ.Lj().getView() != null) {
                        if (d.this.gSq && !d.this.gRs && d.this.bWj().haC != null && d.this.bWj().haC.getHeight() > 0) {
                            int bj = d.this.gPN != null ? d.this.gPN.bj(false) : 0;
                            ViewGroup.LayoutParams layoutParams = d.this.gPS.getLayoutParams();
                            int height = d.this.bWj().haC.getHeight() - bj;
                            int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                i += UtilHelper.getStatusBarHeight();
                            }
                            if (layoutParams != null && d.this.gQJ != null) {
                                layoutParams.height = i + d.this.bWj().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height);
                                d.this.gPS.setLayoutParams(layoutParams);
                                ViewGroup.LayoutParams layoutParams2 = d.this.gQJ.Lj().getView().getLayoutParams();
                                if (layoutParams2 != null) {
                                    layoutParams2.height = layoutParams.height - com.baidu.live.af.b.cO(false);
                                    d.this.gQJ.Lj().getView().setLayoutParams(layoutParams2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        int i2 = com.baidu.live.af.b.i(false, d.this.gRs);
                        if (d.this.gRp.indexOfChild(d.this.gPS) != -1 && d.this.gPS.getLayoutParams() != null) {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) d.this.gPS.getLayoutParams();
                            layoutParams3.height = com.baidu.live.af.b.c(false, false, d.this.gRs);
                            d.this.gPS.setLayoutParams(layoutParams3);
                        }
                        if (d.this.gPS.indexOfChild(d.this.gQJ.Lj().getView()) != -1 && d.this.gQJ.Lj().getView().getLayoutParams() != null) {
                            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) d.this.gQJ.Lj().getView().getLayoutParams();
                            layoutParams4.height = i2;
                            d.this.gQJ.Lj().getView().setLayoutParams(layoutParams4);
                        }
                        d.this.gQJ.Lj().Li();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWy() {
        if (bWj().haC != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.6
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.gQL != null) {
                        if (d.this.gSq && !d.this.gRs && d.this.bWj().haC != null && d.this.bWj().haC.getHeight() > 0) {
                            int height = (d.this.bWj().haC.getHeight() - (d.this.gPN != null ? d.this.gPN.bj(false) : 0)) + d.this.bWj().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            if (d.this.gQL != null) {
                                d.this.gQL.dU(height);
                            }
                        } else if (d.this.gQL != null) {
                            d.this.gQL.dU(com.baidu.live.af.a.a(d.this.bWj().pageContext.getPageActivity(), false, false, d.this.gRs));
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWz() {
        if (bWj().haC != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.7
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    if (d.this.gQL != null) {
                        int h = com.baidu.live.af.a.h(false, false);
                        if (!d.this.gSq || d.this.bWj().haC == null || d.this.bWj().haC.getHeight() <= 0) {
                            i = h;
                        } else {
                            int height = d.this.bWj().haC.getHeight() - (d.this.gPN != null ? d.this.gPN.bj(false) : 0);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            i = height + d.this.bWj().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height);
                        }
                        if (d.this.gQL != null) {
                            d.this.gQL.dV(i);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWA() {
        if (this.gQK != null && this.gQK.Cr() != null) {
            ViewGroup.LayoutParams layoutParams = this.gQK.Cr().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bWj().pageContext.getResources().getDimensionPixelOffset(this.gSq ? a.e.sdk_ds100 : a.e.sdk_ds20);
                this.gQK.Cr().setLayoutParams(layoutParams);
            }
        }
    }

    private void bWB() {
        if (this.gSo == null) {
            this.gSo = new LinearLayout(bWj().pageContext.getPageActivity());
            this.gSo.setOrientation(1);
        }
        if (this.gSo.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds160);
            layoutParams.leftMargin = bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bWj().haC.addView(this.gSo, layoutParams);
        }
    }

    private void bUM() {
        if (this.gPK == null) {
            this.gPK = new com.baidu.tieba.ala.liveroom.activeview.b(bWj().pageContext);
        }
        if (bWj() != null && bWj().haB != null) {
            this.gPK.Ht(bWj().haB.cea());
        }
        this.gPK.mw(this.gSq);
        this.gPK.setOtherParams(Md());
        this.gPK.b(bWj().haB.GH(), false);
        this.gPK.setHost(false);
        this.gPK.mx(this.gRy);
        this.gPK.a(1, this.bqg);
        this.gPK.a(2, this.bqg);
        this.gPK.setVisible(this.gRs ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUS() {
        if (this.gQu == null) {
            bUX();
        }
        this.gQu.setOtherParams(Md());
        this.gQu.a(com.baidu.live.z.e.PD().bsJ, bWj().haB.GH());
    }

    private void bUN() {
        if (this.gPJ == null) {
            this.gPJ = new com.baidu.tieba.ala.liveroom.l.a(bWj().pageContext, this);
        }
        this.gPJ.setOtherParams(Md());
        this.gPJ.a((ViewGroup) this.bqg, bUR());
        this.gPJ.B(bWj().haB.GH());
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
            this.gQu.a(new a.InterfaceC0668a() { // from class: com.baidu.tieba.ala.liveroom.d.d.8
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0668a
                public void bM(int i, int i2) {
                    w GH = d.this.bWj().haB.GH();
                    if (GH != null && GH.mLiveInfo != null) {
                        if (d.this.gQZ == null) {
                            d.this.gQZ = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.bWj().pageContext.getPageActivity());
                        }
                        d.this.gQZ.d(d.this.gRp, i, i2);
                        d.this.gQZ.a(String.valueOf(GH.mLiveInfo.live_id), new a.InterfaceC0672a() { // from class: com.baidu.tieba.ala.liveroom.d.d.8.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0672a
                            public void a(float f, String str) {
                                if (d.this.gQu != null) {
                                    d.this.gQu.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0668a
                public void bN(int i, int i2) {
                    if (d.this.gQZ != null) {
                        d.this.gQZ.bS(i, i2);
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
            this.gQb = new com.baidu.tieba.ala.liveroom.j.b(bWj().pageContext, Md(), this.gRE, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.9
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bVn() {
                    d.this.mE(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bVo() {
                    d.this.mE(false);
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
        return new LinearLayout.LayoutParams(-2, -2);
    }

    private void bUT() {
        CustomResponsedMessage runTask;
        if (this.gQJ == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, bWj().pageContext)) != null && runTask.getData() != null) {
            this.gQJ = (k) runTask.getData();
            this.gQJ.setFromMaster(false);
            this.gQJ.Lj().getView().setId(a.g.ala_liveroom_msg_list);
            this.gQJ.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.10
                @Override // com.baidu.live.im.k.a
                public boolean Lm() {
                    return d.this.Jl();
                }

                @Override // com.baidu.live.im.k.a
                public void Ln() {
                    d.this.gRw = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hC(String str) {
                    if (!d.this.gRs) {
                        d.this.mC(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.bWj().pageContext.getPageActivity(), d.this.bWj().haA.getLiveContainerView());
                    }
                    d.this.Hz(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Lo() {
                    if (d.this.gRs) {
                        d.this.mC(true);
                        d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.bWj().pageContext.getPageActivity(), d.this.bWj().haA.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.gQJ != null) {
                        d.this.gQJ.Lk().setQuickInputPanelVisible(false);
                        d.this.gQJ.Lk().MF();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Lp() {
                    if (d.this.gRs) {
                        d.this.bVm();
                        if (d.this.gQK != null) {
                            d.this.gQK.Cs();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Lq() {
                    return d.this.bVA();
                }

                @Override // com.baidu.live.im.k.a
                public int Lr() {
                    return d.this.bVB();
                }
            });
            this.gPS = new FrameLayout(bWj().pageContext.getPageActivity());
            this.gPS.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.gQJ != null && this.gPS != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bWj().pageContext.getPageActivity()) * 0.7f);
            int i = com.baidu.live.af.b.i(false, false);
            if (this.gRp.indexOfChild(this.gPS) < 0) {
                if (this.gPS.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gPS.getParent()).removeView(this.gPS);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.live.af.b.c(false, false, false));
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.live.af.b.cN(false);
                this.gRp.addView(this.gPS, layoutParams);
            }
            if (this.gPS.indexOfChild(this.gQJ.Lj().getView()) < 0) {
                if (this.gQJ.Lj().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gQJ.Lj().getView()).removeView(this.gQJ.Lj().getView());
                }
                this.gPS.addView(this.gQJ.Lj().getView(), new FrameLayout.LayoutParams(equipmentWidth, i));
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
            this.gQJ.a(String.valueOf(bWj().haB.GH().mLiveInfo.group_id), String.valueOf(bWj().haB.GH().mLiveInfo.last_msg_id), String.valueOf(bWj().haB.GH().aIe.userId), String.valueOf(bWj().haB.GH().mLiveInfo.live_id), bWj().haB.GH().aIe.appId, (GH == null || GH.aIQ == null || !GH.aIQ.DH()) ? false : true);
            mC(false);
        }
    }

    private void bUV() {
        if (this.gPF == null) {
            this.gPF = new com.baidu.tieba.ala.liveroom.p.a(bWj().pageContext, false, this);
        }
        this.gPF.d(this.gRo, bWj().haB.GH());
        this.gPF.a(this.gQm);
        this.gPF.setOtherParams(Md());
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
            this.gPE.setOtherParams(Md());
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

    public void mJ(boolean z) {
        if (this.gQu != null) {
            this.gQu.mJ(z);
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

    protected void HA(String str) {
        if (this.gRD == null) {
            this.gRD = new com.baidu.tieba.ala.liveroom.u.b(bWj().pageContext);
        }
        this.gRD.c(this.gRp, str);
        mE(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.11
            @Override // java.lang.Runnable
            public void run() {
                d.this.gRD.cex();
                d.this.mE(false);
            }
        }, 5000L);
    }

    private void mK(boolean z) {
        CustomResponsedMessage runTask;
        if (bWj().haB.GH().mLiveInfo.live_type == 1 && this.gSr) {
            if (this.gSp == null && (runTask = MessageManager.getInstance().runTask(2913074, e.class, bWj().pageContext)) != null && runTask.getData() != null) {
                this.gSp = (e) runTask.getData();
            }
            if (this.gSp != null) {
                if (this.gPM == null) {
                    this.gPM = this.gSp.a(bWj().pageContext);
                }
                if (z) {
                    this.gPM.Db();
                }
                if (bWj().haB.GH().mLiveInfo.challengeId > 0 && !this.gPM.Dj()) {
                    this.gPM.e(bWj().haB.GH().mLiveInfo.live_id, bWj().haB.GH().aIe.userId);
                    mL(z);
                    if (z) {
                        this.gPM.a(bWj().haB.cdh());
                    }
                    this.gPM.c(bWj().haB.GH());
                }
            }
        }
    }

    private void mL(boolean z) {
        if (this.gPN == null) {
            this.gPN = this.gSp.b(bWj().pageContext);
            this.gPN.a(new com.baidu.live.challenge.g() { // from class: com.baidu.tieba.ala.liveroom.d.d.13
                @Override // com.baidu.live.challenge.g
                public void CX() {
                    d.this.bWj().haC.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.g
                public void a(ax axVar, bb bbVar, bb bbVar2) {
                    d.this.gSq = true;
                    if (d.this.gQA != null) {
                        d.this.gQA.vg(8);
                    }
                    if (d.this.gQB != null) {
                        d.this.gQB.setPraiseEnable(false);
                        d.this.bWj().haC.hqj = false;
                    }
                    if (d.this.gRe != null) {
                        d.this.gRe.setCanVisible(false);
                    }
                    if (d.this.gQC != null) {
                        d.this.gQC.ceI();
                    }
                    if (d.this.gPJ != null) {
                        d.this.gPJ.setCanVisible(false);
                        d.this.gPJ.bZG();
                    }
                    if (d.this.gPK != null) {
                        d.this.gPK.mw(true);
                    }
                    if (d.this.gRE != null) {
                        d.this.gRE.setVisible(8);
                    }
                    if (d.this.gPL != null) {
                        d.this.gPL.setCanVisible(false);
                        d.this.gPL.setVisible(8);
                    }
                    d.this.bWw();
                    d.this.bWx();
                    d.this.bWy();
                    d.this.bWz();
                    d.this.bWA();
                    if (d.this.bWj().bmp != null) {
                        d.this.bWj().bmp.getLivePlayer().setBackgroundResource(a.d.sdk_transparent);
                    }
                    if (d.this.gQz != null) {
                        d.this.gQz.setTimeTextMode(true);
                    }
                    if (d.this.bmm != null && bbVar != null && bbVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(bbVar.aNG);
                        arrayList.add(bbVar2.aNG);
                        com.baidu.live.liveroom.a.c cVar = d.this.bmm;
                        if (d.this.gRA) {
                            arrayList = null;
                        }
                        cVar.o(arrayList);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void CY() {
                }

                @Override // com.baidu.live.challenge.g
                public void CZ() {
                }

                @Override // com.baidu.live.challenge.g
                public void bh(boolean z2) {
                    d.this.bWj().haC.setSwipeClearEnable(true);
                    d.this.gSq = false;
                    if (d.this.gQA != null) {
                        d.this.gQA.vg(0);
                    }
                    if (d.this.gQB != null) {
                        d.this.gQB.setPraiseEnable(true);
                        d.this.bWj().haC.hqj = true;
                    }
                    if (d.this.gRe != null) {
                        d.this.gRe.setCanVisible(true);
                    }
                    if (d.this.gQC != null) {
                        d.this.gQC.ceJ();
                    }
                    if (d.this.gPJ != null) {
                        d.this.gPJ.setCanVisible(true);
                        d.this.gPJ.B(d.this.bWj().haB.GH());
                    }
                    if (d.this.gQE != null) {
                        d.this.gQE.nI(true);
                    }
                    if (d.this.gPK != null) {
                        d.this.gPK.mw(false);
                    }
                    if (d.this.gRE != null) {
                        d.this.gRE.setVisible(0);
                    }
                    if (d.this.gPL != null) {
                        d.this.gPL.setCanVisible(true);
                        d.this.gPL.setVisible(0);
                    }
                    d.this.bWw();
                    d.this.bWx();
                    d.this.bWy();
                    d.this.bWz();
                    d.this.bWA();
                    if (d.this.bmm != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.bWj().haB.cdW());
                        com.baidu.live.liveroom.a.c cVar = d.this.bmm;
                        if (d.this.gRA) {
                            arrayList = null;
                        }
                        cVar.o(arrayList);
                    }
                    if (d.this.bWj().bmp != null) {
                        d.this.bWj().bmp.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
                    }
                    if (d.this.gQz != null) {
                        d.this.gQz.setTimeTextMode(false);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void bi(boolean z2) {
                    if (z2 && d.this.gRh != null) {
                        d.this.gRh.onClose();
                    }
                }
            });
        }
        this.gPN.a(this.gPM);
        this.gPN.m(bWj().haA.getLiveContainerView());
        this.gPN.b(z, false, false);
        this.gPM.a((i.c) this.gPN);
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

    private int bWC() {
        return (this.gPN != null ? this.gPN.bj(false) : 0) + bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    private void bVd() {
        boolean z = true;
        if (this.gQE == null) {
            this.gQE = new com.baidu.tieba.ala.liveroom.x.a(bWj().pageContext, this);
        }
        this.gQE.d(bWj().haC, false);
        AlaLiveInfoData alaLiveInfoData = bWj().haB.GH().mLiveInfo;
        if (alaLiveInfoData != null) {
            boolean z2 = bWi() && alaLiveInfoData.screen_direction != 2;
            boolean isZanAnimUnabled = alaLiveInfoData.mAlaLiveSwitchData != null ? alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled() : false;
            if (!z2 || isZanAnimUnabled) {
                z = false;
            }
            this.gQE.nH(z);
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
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.15
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bVG();
                    }
                }, 500L);
            }
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

    /* JADX WARN: Removed duplicated region for block: B:16:0x003a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void s(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
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
                    if (this.gPJ != null) {
                        this.gPJ.L(jSONObject2);
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
                    long optLong = jSONObject2.optLong("mvp_user_id");
                    long optLong2 = jSONObject2.optLong("winner_live_id");
                    if (optLong == bWj().haB.GH().aIA.userId && optLong2 == bWj().haB.GH().mLiveInfo.live_id) {
                        this.gPN.d(jSONObject2.optInt("challenge_status"), jSONObject2.optLong("challenge_id"));
                    }
                }
            } else {
                return;
            }
        }
        if (this.gRe == null || this.gRe.O(jSONObject2)) {
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void Hv(String str) {
        if (this.gPK != null) {
            this.gPK.Hv(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
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
        if (this.gSo != null) {
            this.gSo.removeAllViews();
            this.gSo = null;
        }
        if (this.gQE != null) {
            this.gQE.onDestroy();
        }
        if (this.gPM != null) {
            this.gPM.CT();
        }
        if (this.gPF != null) {
            this.gPF.caG();
        }
        if (this.gQb != null) {
            this.gQb.cancel();
        }
        if (this.gRE != null) {
            this.gRE.bXv();
        }
        if (this.gRe != null) {
            this.gRe.Kj();
        }
        if (this.gPR != null) {
            this.gPR.Kj();
        }
        if (this.gQb != null) {
            this.gQb.CT();
        }
        if (this.gRl != null) {
            this.gRl.CT();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cg(boolean z) {
        super.cg(z);
        bVg();
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
        if (this.gQR != null) {
            this.gQR.onDestroy();
        }
        if (this.gPG != null) {
            this.gPG.onDestroy();
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
        if (this.gPK != null) {
            this.gPK.release();
        }
        if (this.gRE != null) {
            this.gRE.cg(!z);
        }
        if (this.gPR != null) {
            this.gPR.onDestroy();
        }
        if (this.gQb != null) {
            this.gQb.onDestroy();
            this.gQb = null;
        }
        if (this.gRl != null) {
            this.gRl.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.gQc);
        MessageManager.getInstance().removeMessageRule(this.gQd);
        MessageManager.getInstance().unRegisterListener(this.gQg);
        MessageManager.getInstance().unRegisterListener(this.gQh);
        MessageManager.getInstance().unRegisterListener(this.gQj);
        MessageManager.getInstance().unRegisterListener(this.gQk);
        MessageManager.getInstance().unRegisterListener(this.gSs);
        MessageManager.getInstance().unRegisterListener(this.gQl);
        MessageManager.getInstance().unRegisterListener(this.gQi);
    }

    private void bVg() {
        if (this.gQJ != null && this.gQJ.Lj().getView() != null && this.gQJ.Lj().getView().getParent() != null) {
            ((ViewGroup) this.gQJ.Lj().getView().getParent()).removeView(this.gQJ.Lj().getView());
        }
        if (this.gPS != null && this.gPS.getParent() != null) {
            ((ViewGroup) this.gPS.getParent()).removeView(this.gPS);
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    /* renamed from: bWD */
    public PendantParentView bVk() {
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
        } else if (i == 25051 && i2 == -1 && this.gRE != null) {
            this.gRE.bZx();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.gQJ != null && this.gQJ.Lj() != null) {
            this.gQJ.Lj().onKeyboardVisibilityChanged(z);
        }
        if (z || this.gQJ == null || this.gQJ.Lk() == null || !this.gQJ.Lk().ME()) {
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
                if (this.gRe != null) {
                    this.gRe.setCanVisible(false);
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
            bWx();
            if (this.gQW != null) {
                this.gQW.br(z);
            }
        }
    }

    private void bVl() {
        if (this.gQu != null) {
            this.gQu.setVisibility(0);
        }
        if (this.gPS != null) {
            if (this.gSu) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gPS.getLayoutParams();
                layoutParams.bottomMargin = (M(false, false) - bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) + com.baidu.live.af.b.RT();
                this.gPS.setLayoutParams(layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gPS.getLayoutParams();
                layoutParams2.bottomMargin = bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
                this.gPS.setLayoutParams(layoutParams2);
            }
        }
        if (this.gQJ != null) {
            bVH();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gQJ.Lk().getView().getLayoutParams();
            layoutParams3.bottomMargin = 0;
            this.gQJ.Lk().getView().setLayoutParams(layoutParams3);
        }
        if (this.gQu != null) {
            this.gQu.setVisibility(0);
        }
        if (this.gQL != null && this.gQL.Gg() != null) {
            this.gQL.Gg().setVisibility(0);
        }
        if (this.gRo != null) {
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
        if (this.gRe != null) {
            this.gRe.setCanVisible(!this.gSq);
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
        this.gSt = z;
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
        if (this.mOrientation != i3) {
            if (this.gPE != null) {
                this.gPE.dI(i3);
            }
            if (this.gPG != null) {
                this.gPG.dI(i3);
            }
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
            if (this.gQu != null) {
                this.gQu.setVisibility(8);
            }
            if (this.gQJ != null) {
                this.gQJ.Lj().getView().setVisibility(4);
            }
            if (this.gPK != null) {
                this.gPK.bK(2, 8);
                if (this.gSq) {
                    this.gPK.bK(1, 8);
                }
            }
            if (this.gQZ != null) {
                this.gQZ.nC(false);
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
            if (this.gPK != null) {
                this.gPK.setVisible(0);
            }
            if (this.gQZ != null) {
                this.gQZ.nC(true);
            }
            this.gRo.setVisibility(0);
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
        if (this.gPL != null) {
            this.gPL.bg(true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.gPH != null) {
            this.gPH.cey();
        }
        if (this.gPM != null && this.gSr) {
            this.gPM.Dd();
        }
        if (this.gPK != null) {
            this.gPK.onStart();
        }
        if (this.gPL != null) {
            this.gPL.bg(false);
        }
    }
}
