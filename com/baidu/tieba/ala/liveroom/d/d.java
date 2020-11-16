package com.baidu.tieba.ala.liveroom.d;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
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
import com.baidu.live.aj.c;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.e;
import com.baidu.live.challenge.h;
import com.baidu.live.challenge.i;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveSdkInfo;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.aq;
import com.baidu.live.data.az;
import com.baidu.live.data.bd;
import com.baidu.live.data.bn;
import com.baidu.live.data.cd;
import com.baidu.live.data.cj;
import com.baidu.live.data.p;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.gift.af;
import com.baidu.live.gift.m;
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
import com.baidu.live.tbadk.coreextra.data.AlaVideoBCChatData;
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
    private PendantParentView bpO;
    private FrameLayout gVD;
    private com.baidu.tieba.ala.liveroom.j.b gVM;
    private com.baidu.tieba.ala.liveroom.audiencelist.c gVp;
    private com.baidu.tieba.ala.liveroom.p.a gVq;
    private com.baidu.tieba.ala.liveroom.g.b gVr;
    private com.baidu.tieba.ala.liveroom.v.b gVs;
    private com.baidu.tieba.ala.liveroom.audiencelist.b gVt;
    private com.baidu.tieba.ala.liveroom.l.a gVu;
    private com.baidu.tieba.ala.liveroom.activeview.b gVv;
    private com.baidu.live.d.a gVw;
    private i gVx;
    private h gVy;
    private com.baidu.tieba.ala.liveroom.c.a gVz;
    private LinearLayout gYa;
    private e gYb;
    private boolean gYc;
    private long lastClickTime = 0;
    private boolean gYd = false;
    private HttpRule gVN = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.gVx != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.gVx.CS()) {
                httpMessage.addParam("ala_challenge_id", d.this.gVx.CV());
            }
            return httpMessage;
        }
    };
    private HttpRule gVO = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.gVx != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.gVx.CS()) {
                httpMessage.addParam("challenge_id", d.this.gVx.CV());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c gVP = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.d.17
        @Override // com.baidu.live.liveroom.g.c
        public void Ns() {
            if (d.this.gWp != null) {
                d.this.gWp.nS(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cm(boolean z) {
            if (z) {
                if (d.this.gWp != null) {
                    d.this.gWp.nS(true);
                }
            } else if (d.this.gWp != null) {
                d.this.gWp.nS(false);
            }
            if (d.this.gWH != null) {
                d.this.gWH.bv(z);
            }
            if (d.this.gVv != null) {
                d.this.gVv.mJ(z ? false : true);
            }
            com.baidu.live.n.a.cn(z);
        }
    };
    private HttpMessageListener gVR = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.d.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.NB() != null) {
                        com.baidu.live.aa.e.Pv().bss = getQuickGiftHttpResponseMessage.NB();
                        d.this.bWL();
                    }
                }
            }
        }
    };
    CustomMessageListener gVW = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.gVM.c(d.this.bYd());
                } else if (d.this.bXs() || !g.wg(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.21.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.bYd().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.bYd().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    d.this.gVM.c(d.this.gVD, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener gYe = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.d.d.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.bXs() || !g.wg(2913128)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.22.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.we(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    d.this.Ht(str);
                }
            }
        }
    };
    private CustomMessageListener gVS = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.d.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.gWx.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gVT = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.this.gWL != null) {
                    d.this.gWL.hN(str);
                }
            }
        }
    };
    CustomMessageListener gVU = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.gXi != null && d.this.gXi.beL != null && !d.this.gXi.beO && !d.this.gXi.beP && d.this.gWG != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.bYd().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                layoutParams.bottomMargin = d.this.bYd().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                d.this.gWG.c(d.this.gVD, layoutParams);
                if (com.baidu.live.guardclub.e.JV() != null) {
                    com.baidu.live.guardclub.e.JV().Kb();
                }
            }
        }
    };
    private CustomMessageListener gVV = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.gWI != null) {
                    d.this.gWI.dismiss();
                }
                if (d.this.gWL != null) {
                    d.this.gWL.dismiss();
                }
                if (d.this.gWJ != null) {
                    d.this.gWJ.dismiss();
                }
                if (d.this.gKF != null) {
                    d.this.gKF.dismiss();
                }
                com.baidu.live.im.b.d.Lx().setSwitchStatus(true);
                com.baidu.live.im.b.d.Lx().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bXz();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gVX = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.d.15
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void s(View view, int i) {
            bn bnVar;
            cd cdVar;
            cj cjVar;
            String str;
            bn bnVar2;
            cd cdVar2;
            String str2;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - d.this.lastClickTime >= 300) {
                d.this.lastClickTime = currentTimeMillis;
                if (i == 2) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel"));
                    d.this.O(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.aa.e.Pv().bss.Gh().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.aa.e.Pv().bss.Gh().Fk());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.aa.e.Pv().bss.Gh().Fl());
                        if (d.this.bYd().hgk.Gz() != null && d.this.bYd().hgk.Gz().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.bYd().hgk.Gz().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.bYd().hgk.Gz().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.LU());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.Jd()) {
                        if (com.baidu.live.d.Aq().getBoolean("quick_gift_guide_show", true) && !d.this.bXs()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, af.class, d.this.bYd().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                af afVar = (af) runTask.getData();
                                afVar.setPageContext(d.this.bYd().pageContext);
                                afVar.setLiveShowData(d.this.bYd().hgk.Gz());
                                afVar.setGiftItem(com.baidu.live.aa.e.Pv().bss.Gh());
                                afVar.setOtherParams(d.this.LU());
                                afVar.initView();
                                afVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.d.d.15.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        d.this.mO(false);
                                    }
                                });
                                afVar.show();
                                d.this.mO(true);
                                return;
                            }
                            return;
                        }
                        m.a(d.this.bYd().pageContext, d.this.bYd().hgk.Gz(), com.baidu.live.aa.e.Pv().bss.Gh(), d.this.LU());
                    }
                } else if (i == 1) {
                    if (d.this.gWu != null) {
                        d.this.bXz();
                    }
                } else if (i == 3 && d.this.Jd()) {
                    if (com.baidu.live.n.a.isDebug()) {
                        com.baidu.live.n.a.b(d.this.bYd().hgk.Gz().mLiveInfo.live_id, 0);
                        return;
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    d.this.gWh.c(d.this.bYd().hgk.Gz(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.bYd() != null && d.this.bYd().hgk != null && d.this.bYd().hgk.Gz() != null && d.this.bYd().hgk.Gz().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.bYd().hgk.Gz().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.bYd().hgk.Gz().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.bYd().hgk.Gz().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.LU());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.bYd() != null && d.this.bYd().hgk != null && d.this.bYd().hgk.Gz() != null && d.this.bYd().hgk.Gz().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.bYd().hgk.Gz().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.bYd().hgk.Gz().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.bYd().hgk.Gz().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.LU());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.blV != null) {
                        d.this.blV.cg(false);
                    }
                } else if (i == 12) {
                    if (d.this.gWp != null && d.this.bYd().hgk.Gz() != null && d.this.bYd().hgk.Gz().mLiveInfo != null) {
                        String valueOf = String.valueOf(d.this.bYd().hgk.Gz().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.bYd().hgk.Gz().mLiveInfo.room_id);
                        String str3 = null;
                        AlaLiveSdkInfo alaLiveSdkInfo = d.this.bYd().hgk.Gz().mLiveSdkInfo;
                        if (alaLiveSdkInfo != null && alaLiveSdkInfo.mCastIds != null) {
                            str3 = String.valueOf(d.this.bYd().hgk.Gz().mLiveSdkInfo.mCastIds.chatMCastId);
                        }
                        d.this.gWp.as(valueOf, valueOf2, str3);
                        com.baidu.live.n.a.b(d.this.bYd().hgk.Gz().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    w Gz = d.this.bYd().hgk.Gz();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.bYd().pageContext.getPageActivity(), Gz.aHk.userName, Long.toString(Gz.aHk.userId), Long.toString(Gz.aHk.charmCount), String.valueOf(Gz.mLiveInfo.group_id), String.valueOf(Gz.mLiveInfo.live_id), false, String.valueOf(Gz.aHk.userId), Long.toString(Gz.aHG.userId), Gz.aHG.userName, Gz.aHG.portrait, d.this.gVt.getCount(), d.this.LU())));
                    LogManager.getCommonLogger().doClickGusetNumLog(Gz.mLiveInfo.feed_id, d.this.gVt.getCount() + "", d.this.LU());
                } else if (i == 11) {
                    d.this.bXC();
                    d.this.bXD();
                } else if (i == 16) {
                    if (d.this.bYd() != null && (bnVar2 = com.baidu.live.aa.a.Ph().bsh) != null && (cdVar2 = bnVar2.aNM) != null) {
                        String str4 = cdVar2.aPh.aPo;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (d.this.bYd().hgk != null && d.this.bYd().hgk.Gz() != null && d.this.bYd().hgk.Gz().mLiveInfo != null) {
                                j = d.this.bYd().hgk.Gz().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", d.this.bYd().hgk.Gz().mLiveInfo.room_id + "", d.this.bYd().hgk.Gz().mLiveInfo.feed_id, d.this.LU());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.bYd().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (d.this.bYd() != null) {
                        w wVar = null;
                        if (d.this.bYd().hgk != null) {
                            wVar = d.this.bYd().hgk.Gz();
                        }
                        if (wVar != null && wVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.w.b.cgG().bmB != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.w.b.cgG().bmB.aGz;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(d.this.bYd().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17 && d.this.Jd() && d.this.bYd() != null && (bnVar = com.baidu.live.aa.a.Ph().bsh) != null && (cdVar = bnVar.aNM) != null && (cjVar = cdVar.aPi) != null && !TextUtils.isEmpty(cjVar.webUrl)) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                    if (d.this.gWI != null && d.this.bYd().hgk != null && d.this.bYd().hgk.Gz() != null) {
                        w Gz2 = d.this.bYd().hgk.Gz();
                        d.this.gWI.a(cjVar.webUrl, Gz2.mLiveInfo.live_id, Gz2.aHG.userId, Gz2.aHk.userId);
                    }
                }
            }
        }
    };
    private boolean gYf = false;
    private boolean gYg = false;

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.gWj = new com.baidu.tieba.ala.liveroom.guide.c(bYd().pageContext, this, false);
        this.gVN.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.gVN);
        this.gVO.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.gVO);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean bWv() {
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(w wVar) {
        super.l(wVar);
        g.cbx();
        this.gYd = true;
        this.gYg = false;
        this.gYf = false;
        bYd().hgl.setIsForceHandledTouch(false);
        bYd().hgl.setSwipeClearEnable(true);
        bYd().hgl.setOnLiveViewScrollListener(this.gVP);
        bYd().hgl.setOnClickListener(null);
        bYd().hgl.setClickable(false);
        if (this.gWm != null) {
            this.gWm.b(this.gVX);
        }
        if (this.gXb != null) {
            this.gXb.setVisibility(0);
        }
        bWD();
        if (this.gWE != null) {
            this.gWE.a(wVar, this.bpO);
            this.gWE.U(this.gXc);
            this.gWE.a(this);
        }
        bYw();
        bWO();
        bXn();
        bWP();
        bWT();
        bWQ();
        mP(false);
        bXF();
        bWM();
        bXH();
        bWV();
        bWW();
        bYp();
        bYq();
        mQ(false);
        bXJ();
        bWC();
        bXV();
        bWF();
        bWL();
        bWG();
        bWH();
        bWI();
        bWJ();
        bWy();
        bXL();
        bXR();
        bXG();
        bXK();
        mU(true);
        bXU();
        c(this.gaF);
        bYo();
        bXQ();
        MessageManager.getInstance().registerListener(this.gVR);
        MessageManager.getInstance().registerListener(this.gVS);
        MessageManager.getInstance().registerListener(this.gVU);
        MessageManager.getInstance().registerListener(this.gVV);
        MessageManager.getInstance().registerListener(this.gYe);
        MessageManager.getInstance().registerListener(this.gVW);
        MessageManager.getInstance().registerListener(this.gVT);
        bWY();
        bWS();
    }

    private void bYo() {
        AlaVideoBCChatData alaVideoBCChatData;
        CustomResponsedMessage runTask;
        AlaLiveUserInfoData alaLiveUserInfoData = bYd().hgk.Gz().aHG;
        if (alaLiveUserInfoData != null && (alaVideoBCChatData = alaLiveUserInfoData.videoBCEnterData) != null && alaVideoBCChatData.isShowEnter()) {
            if (this.gXa == null && (runTask = MessageManager.getInstance().runTask(2913255, com.baidu.live.aj.c.class, bYd().pageContext)) != null && runTask.getData() != null) {
                this.gXa = (com.baidu.live.aj.c) runTask.getData();
            }
            if (this.gXa != null) {
                this.gXa.a(bYd().blY);
                this.gXa.b(bYd().hgj.getMastView());
                this.gXa.q(bYd().hgk.Gz());
                this.gXa.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.18
                    @Override // com.baidu.live.aj.c.a
                    public void Ui() {
                        if (d.this.gWm != null) {
                            d.this.bYd().hgl.hvO = false;
                            d.this.gWm.setPraiseEnable(false);
                            if (d.this.bYd().hgm != null) {
                                d.this.bYd().hgm.setIsScrollable(false);
                            }
                        }
                    }

                    @Override // com.baidu.live.aj.c.a
                    public void Uj() {
                        if (d.this.gWm != null) {
                            d.this.bYd().hgl.hvO = true;
                            d.this.gWm.setPraiseEnable(true);
                            if (d.this.bYd().hgm != null) {
                                d.this.bYd().hgm.setIsScrollable(true);
                            }
                        }
                    }
                });
                View enterView = this.gXa.getEnterView();
                if (enterView != null) {
                    if (enterView.getParent() != null) {
                        ((ViewGroup) enterView.getParent()).removeView(enterView);
                    }
                    this.gWf.cj(enterView);
                }
            }
        }
    }

    private void bWy() {
        if (this.gWS != null) {
            this.gWS.a(new com.baidu.live.v.c() { // from class: com.baidu.tieba.ala.liveroom.d.d.19
                @Override // com.baidu.live.v.c
                public void ct(boolean z) {
                    if (d.this.gVy != null) {
                        d.this.gVy.setNeedCloseRecommendFloat(z);
                    }
                    if (d.this.bYd().hgl.hvO) {
                        if (d.this.gWp != null) {
                            d.this.gWp.nK(z);
                            d.this.gWp.nS(!z);
                        }
                        if (d.this.gWm != null) {
                            d.this.gWm.nK(z);
                            d.this.gWm.setPraiseEnable(!z);
                            d.this.gWm.nJ(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void j(w wVar) {
        super.j(wVar);
        if (this.gVq != null) {
            this.gVq.H(wVar);
        }
        if (this.gVr != null) {
            this.gVr.D(wVar);
        }
        if (this.gVu != null) {
            this.gVu.G(wVar);
        }
        if (this.gVy != null) {
            this.gVy.a(wVar);
        }
        mU(false);
        if (this.gVv != null) {
            this.gVv.i(wVar);
            this.gVv.mI(this.gXl);
            this.gVv.updateView();
            if (wVar != null && this.gWU != null && !this.gWU.hasInit && !TextUtils.isEmpty(this.gWU.aOg)) {
                this.gWU.hasInit = true;
                this.gVv.Hp(this.gWU.aOg);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(q qVar) {
        if (qVar != null) {
            if (this.gVp != null && qVar.getList() != null) {
                this.gVp.e(qVar);
            }
            if (this.gVt != null) {
                this.gVt.ew(qVar.getCount());
            }
        }
    }

    private void bWA() {
        if (this.gWo != null) {
            this.gWo.ax(bYd().hgj.getLiveContainerView());
        }
    }

    private void bYp() {
        if (this.gVz == null) {
            this.gVz = new com.baidu.tieba.ala.liveroom.c.a(bYd().pageContext);
        }
        if (bYd().hgk != null && bYd().hgk.Gz() != null && bYd().hgk.Gz().mLiveInfo != null) {
            this.gVz.Hq(String.valueOf(bYd().hgk.Gz().mLiveInfo.user_id));
        }
    }

    private void bYq() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (bYd() != null && bYd().hgk != null && bYd().hgk.Gz() != null && bYd().hgk.Gz().mLiveInfo != null) {
                j = bYd().hgk.Gz().mLiveInfo.room_id;
            }
            if (this.gWC == null) {
                this.gWC = new com.baidu.tieba.ala.liveroom.guide.a(bYd().pageContext, j);
            }
            this.gWC.mN(this.gXe);
            this.gWC.a(new a.InterfaceC0675a() { // from class: com.baidu.tieba.ala.liveroom.d.d.5
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0675a
                public void bYz() {
                    if (d.this.blV != null) {
                        d.this.blV.cg(true);
                    }
                }
            });
            this.gWC.at(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void dI(int i) {
        super.dI(i);
        bWA();
        if (this.gVy != null) {
            this.gVy.dI(i);
        }
    }

    private void bWD() {
        if (this.bpO == null) {
            this.bpO = new PendantParentView(bYd().pageContext.getPageActivity(), this.gYc ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            bYd().hgl.addView(this.bpO, new ViewGroup.LayoutParams(-1, -1));
            this.bpO.setDefaultItemMargin(bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.bpO.setPadding(bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            bYr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYr() {
        int dimensionPixelSize;
        if (this.bpO != null) {
            this.bpO.setModel(this.gYc ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            int dimensionPixelSize2 = bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds220);
            int dimensionPixelSize3 = bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            if (this.gYc) {
                dimensionPixelSize = bYx();
            } else {
                dimensionPixelSize = bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds200);
            }
            this.bpO.setPosition(dimensionPixelSize2, 0, dimensionPixelSize, dimensionPixelSize3);
            return;
        }
        bWD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYs() {
        if (bYd().hgl != null && !this.gYg) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.6
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.gVD != null && d.this.gWu != null && d.this.gWu.La() != null && d.this.gWu.La().getView() != null) {
                        if (d.this.gYc && !d.this.gXf && d.this.bYd().hgl != null && d.this.bYd().hgl.getHeight() > 0) {
                            int bm = d.this.gVy != null ? d.this.gVy.bm(false) : 0;
                            ViewGroup.LayoutParams layoutParams = d.this.gVD.getLayoutParams();
                            int height = d.this.bYd().hgl.getHeight() - bm;
                            int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                i += UtilHelper.getStatusBarHeight();
                            }
                            if (layoutParams != null && d.this.gWu != null) {
                                layoutParams.height = i + d.this.bYd().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                                d.this.gVD.setLayoutParams(layoutParams);
                                ViewGroup.LayoutParams layoutParams2 = d.this.gWu.La().getView().getLayoutParams();
                                if (layoutParams2 != null) {
                                    layoutParams2.height = layoutParams.height - com.baidu.live.ag.b.cX(false);
                                    d.this.gWu.La().getView().setLayoutParams(layoutParams2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        int i2 = com.baidu.live.ag.b.i(false, d.this.gXf);
                        if (d.this.gXc.indexOfChild(d.this.gVD) != -1 && d.this.gVD.getLayoutParams() != null) {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) d.this.gVD.getLayoutParams();
                            layoutParams3.height = com.baidu.live.ag.b.c(false, false, d.this.gXf);
                            d.this.gVD.setLayoutParams(layoutParams3);
                        }
                        if (d.this.gVD.indexOfChild(d.this.gWu.La().getView()) != -1 && d.this.gWu.La().getView().getLayoutParams() != null) {
                            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) d.this.gWu.La().getView().getLayoutParams();
                            layoutParams4.height = i2;
                            d.this.gWu.La().getView().setLayoutParams(layoutParams4);
                        }
                        d.this.gWu.La().KZ();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYt() {
        if (bYd().hgl != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.7
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.gWw != null) {
                        if (d.this.gYc && !d.this.gXf && d.this.bYd().hgl != null && d.this.bYd().hgl.getHeight() > 0) {
                            int height = (d.this.bYd().hgl.getHeight() - (d.this.gVy != null ? d.this.gVy.bm(false) : 0)) + d.this.bYd().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            if (d.this.gWw != null) {
                                d.this.gWw.dQ(height);
                            }
                        } else if (d.this.gWw != null) {
                            d.this.gWw.dQ(com.baidu.live.ag.a.a(d.this.bYd().pageContext.getPageActivity(), false, false, d.this.gXf));
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYu() {
        if (bYd().hgl != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.8
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    if (d.this.gWw != null) {
                        int h = com.baidu.live.ag.a.h(false, false);
                        if (!d.this.gYc || d.this.bYd().hgl == null || d.this.bYd().hgl.getHeight() <= 0) {
                            i = h;
                        } else {
                            int height = d.this.bYd().hgl.getHeight() - (d.this.gVy != null ? d.this.gVy.bm(false) : 0);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            i = height + d.this.bYd().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                        }
                        if (d.this.gWw != null) {
                            d.this.gWw.dR(i);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYv() {
        if (this.gWv != null && this.gWv.Cb() != null) {
            ViewGroup.LayoutParams layoutParams = this.gWv.Cb().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bYd().pageContext.getResources().getDimensionPixelOffset(this.gYc ? a.d.sdk_ds100 : a.d.sdk_ds20);
                this.gWv.Cb().setLayoutParams(layoutParams);
            }
        }
    }

    private void bYw() {
        if (this.gYa == null) {
            this.gYa = new LinearLayout(bYd().pageContext.getPageActivity());
            this.gYa.setOrientation(1);
        }
        if (this.gYa.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds160);
            layoutParams.leftMargin = bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            bYd().hgl.addView(this.gYa, layoutParams);
        }
    }

    private void bWF() {
        if (this.gVv == null) {
            this.gVv = new com.baidu.tieba.ala.liveroom.activeview.b(bYd().pageContext);
        }
        if (bYd() != null && bYd().hgk != null) {
            this.gVv.Hm(bYd().hgk.cfU());
        }
        this.gVv.mH(this.gYc);
        this.gVv.setOtherParams(LU());
        this.gVv.b(bYd().hgk.Gz(), false);
        this.gVv.setHost(false);
        this.gVv.mI(this.gXl);
        this.gVv.a(1, this.bpO);
        this.gVv.a(2, this.bpO);
        this.gVv.setVisible(this.gXf ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWL() {
        if (this.gWf == null) {
            bWQ();
        }
        this.gWf.setOtherParams(LU());
        this.gWf.a(com.baidu.live.aa.e.Pv().bss, bYd().hgk.Gz());
    }

    private void bWG() {
        if (this.gVu == null) {
            this.gVu = new com.baidu.tieba.ala.liveroom.l.a(bYd().pageContext, this);
        }
        this.gVu.setOtherParams(LU());
        this.gVu.a((ViewGroup) this.bpO, bWK());
        this.gVu.G(bYd().hgk.Gz());
    }

    private void bWH() {
        if (this.gWG == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, j.class, bYd().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gWG = (j) runTask.getData();
            } else {
                return;
            }
        }
        this.gWG.setOtherParams(LU());
        if (this.gVD != null && this.gVD.indexOfChild(this.gWG.getView()) >= 0) {
            this.gVD.removeView(this.gWG.getView());
        }
    }

    private void bWI() {
        if (this.gWf != null) {
            this.gWf.a(new a.InterfaceC0682a() { // from class: com.baidu.tieba.ala.liveroom.d.d.9
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0682a
                public void bO(int i, int i2) {
                    w Gz = d.this.bYd().hgk.Gz();
                    if (Gz != null && Gz.mLiveInfo != null) {
                        if (d.this.gWK == null) {
                            d.this.gWK = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.bYd().pageContext.getPageActivity());
                        }
                        d.this.gWK.d(d.this.gXc, i, i2);
                        d.this.gWK.a(String.valueOf(Gz.mLiveInfo.live_id), new a.InterfaceC0686a() { // from class: com.baidu.tieba.ala.liveroom.d.d.9.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0686a
                            public void a(float f, String str) {
                                if (d.this.gWf != null) {
                                    d.this.gWf.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0682a
                public void bP(int i, int i2) {
                    if (d.this.gWK != null) {
                        d.this.gWK.bU(i, i2);
                    }
                }
            });
        }
    }

    private void bWJ() {
        if (this.gXr == null) {
            this.gXr = new com.baidu.tieba.ala.liveroom.j.e(bYd().pageContext);
        }
        this.gXr.setRoomId(bYd().hgk.Gz().mLiveInfo.room_id);
        this.gXr.HF("");
        this.gXr.b(bYd().hgk.Gz(), this.bpO);
        if (this.gVM == null) {
            this.gVM = new com.baidu.tieba.ala.liveroom.j.b(bYd().pageContext, LU(), this.gXr, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.10
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bXg() {
                    d.this.mO(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bXh() {
                    d.this.mO(false);
                }
            });
        }
        this.gVM.setRoomId(bYd().hgk.Gz().mLiveInfo.room_id);
        if (this.gVD != null && this.gVD.indexOfChild(this.gVM.getView()) >= 0) {
            this.gVD.removeView(this.gVM.getView());
        }
        if (this.gVM != null) {
            this.gVM.b(bYd());
        }
    }

    private LinearLayout.LayoutParams bWK() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    private void bWM() {
        CustomResponsedMessage runTask;
        if (this.gWu == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, bYd().pageContext)) != null && runTask.getData() != null) {
            this.gWu = (k) runTask.getData();
            this.gWu.setFromMaster(false);
            this.gWu.La().getView().setId(a.f.ala_liveroom_msg_list);
            this.gWu.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.11
                @Override // com.baidu.live.im.k.a
                public boolean Ld() {
                    return d.this.Jd();
                }

                @Override // com.baidu.live.im.k.a
                public void Le() {
                    d.this.gXj = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hD(String str) {
                    if (!d.this.gXf) {
                        d.this.mM(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.bYd().pageContext.getPageActivity(), d.this.bYd().hgj.getLiveContainerView());
                    }
                    d.this.Hs(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Lf() {
                    if (d.this.gXf) {
                        d.this.mM(true);
                        d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.bYd().pageContext.getPageActivity(), d.this.bYd().hgj.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.gWu != null) {
                        d.this.gWu.Lb().setQuickInputPanelVisible(false);
                        d.this.gWu.Lb().Mw();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Lg() {
                    if (d.this.gXf) {
                        d.this.bXf();
                        if (d.this.gWv != null) {
                            d.this.gWv.Cc();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Lh() {
                    return d.this.bXt();
                }

                @Override // com.baidu.live.im.k.a
                public int Li() {
                    return d.this.bXu();
                }
            });
            this.gVD = new FrameLayout(bYd().pageContext.getPageActivity());
            this.gVD.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.gWu != null && this.gVD != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bYd().pageContext.getPageActivity()) * 0.7f);
            int i = com.baidu.live.ag.b.i(false, false);
            if (this.gXc.indexOfChild(this.gVD) < 0) {
                if (this.gVD.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gVD.getParent()).removeView(this.gVD);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.live.ag.b.c(false, false, false));
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.live.ag.b.cW(false);
                this.gXc.addView(this.gVD, layoutParams);
            }
            if (this.gVD.indexOfChild(this.gWu.La().getView()) < 0) {
                if (this.gWu.La().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gWu.La().getView()).removeView(this.gWu.La().getView());
                }
                this.gVD.addView(this.gWu.La().getView(), new FrameLayout.LayoutParams(equipmentWidth, i));
            }
            if (bYd().hgl.indexOfChild(this.gWu.Lb().getView()) < 0) {
                if (this.gWu.Lb().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gWu.Lb().getView().getParent()).removeView(this.gWu.Lb().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bXA();
                bYd().hgl.addView(this.gWu.Lb().getView(), layoutParams2);
            }
            w Gz = bYd().hgk.Gz();
            if (Gz != null && Gz.mLiveInfo != null) {
                this.gWu.setLogData(Gz.mLiveInfo.feed_id, LU());
            }
            this.gWu.a(String.valueOf(bYd().hgk.Gz().mLiveInfo.group_id), String.valueOf(bYd().hgk.Gz().mLiveInfo.last_msg_id), String.valueOf(bYd().hgk.Gz().aHk.userId), String.valueOf(bYd().hgk.Gz().mLiveInfo.live_id), bYd().hgk.Gz().aHk.appId, (Gz == null || Gz.aHW == null || !Gz.aHW.Dr()) ? false : true);
            mM(false);
        }
    }

    private void bWO() {
        if (this.gVq == null) {
            this.gVq = new com.baidu.tieba.ala.liveroom.p.a(bYd().pageContext, false, this);
        }
        this.gVq.d(this.gXb, bYd().hgk.Gz());
        this.gVq.a(this.gVX);
        this.gVq.setOtherParams(LU());
    }

    private void bWP() {
        if (this.gVp == null) {
            this.gVp = new com.baidu.tieba.ala.liveroom.audiencelist.c(bYd().pageContext, this, false);
        }
        this.gVp.a(String.valueOf(bYd().hgk.Gz().mLiveInfo.group_id), String.valueOf(bYd().hgk.Gz().mLiveInfo.live_id), String.valueOf(bYd().hgk.Gz().aHk.userId), bYd().hgk.Gz());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.f.ala_liveroom_hostheader;
            if (this.gWg != null && this.gWg.getView() != null && this.gWg.getView().getParent() != null) {
                i = a.f.ala_liveroom_guardthrone;
            }
            this.gVp.c(this.gXb, i, a.f.ala_liveroom_audience_count_layout);
            this.gVp.e(bYd().hgk.bQJ());
            this.gVp.setOtherParams(LU());
        }
    }

    private void bWQ() {
        com.baidu.live.core.a.a MK;
        if (this.gWf == null) {
            this.gWf = new com.baidu.tieba.ala.liveroom.operation.a(bYd().pageContext);
        }
        this.gWf.a(bYd(), this.gXc, bYd().hgk.Gz().mLiveInfo, true, this.gVX);
        this.gWf.setOtherParams(LU());
        if (this.gWE != null && (MK = this.gWE.MK()) != null) {
            View rootLayout = MK.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.gWf.ci(rootLayout);
        }
    }

    public void mT(boolean z) {
        if (this.gWf != null) {
            this.gWf.mT(z);
        }
    }

    private void bWT() {
        if (this.gVt == null) {
            this.gVt = new com.baidu.tieba.ala.liveroom.audiencelist.b(bYd().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (bYd().hgk.bQJ() != null) {
            j = bYd().hgk.bQJ().getCount();
        }
        this.gVt.a(this.gVX);
        this.gVt.a(this.gXb, a.f.ala_liveroom_hostheader, j);
        this.gVt.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.gVt.mX(false);
        } else {
            this.gVt.mX(true);
        }
    }

    protected void Ht(String str) {
        if (this.gXq == null) {
            this.gXq = new com.baidu.tieba.ala.liveroom.u.b(bYd().pageContext);
        }
        this.gXq.c(this.gXc, str);
        mO(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.13
            @Override // java.lang.Runnable
            public void run() {
                d.this.gXq.cgt();
                d.this.mO(false);
            }
        }, 5000L);
    }

    private void mU(boolean z) {
        CustomResponsedMessage runTask;
        if (bYd().hgk.Gz().mLiveInfo.live_type == 1 && this.gYd) {
            if (this.gYb == null && (runTask = MessageManager.getInstance().runTask(2913074, e.class, bYd().pageContext)) != null && runTask.getData() != null) {
                this.gYb = (e) runTask.getData();
            }
            if (this.gYb != null) {
                if (this.gVx == null) {
                    this.gVx = this.gYb.a(bYd().pageContext);
                }
                if (z) {
                    this.gVx.CL();
                }
                if (bYd().hgk.Gz().mLiveInfo.challengeId > 0 && !this.gVx.CT()) {
                    this.gVx.e(bYd().hgk.Gz().mLiveInfo.live_id, bYd().hgk.Gz().aHk.userId);
                    mV(z);
                    if (z) {
                        this.gVx.a(bYd().hgk.cfb());
                    }
                    this.gVx.c(bYd().hgk.Gz());
                }
            }
        }
    }

    private void mV(boolean z) {
        if (this.gVy == null) {
            this.gVy = this.gYb.b(bYd().pageContext);
            this.gVy.a(new com.baidu.live.challenge.g() { // from class: com.baidu.tieba.ala.liveroom.d.d.14
                @Override // com.baidu.live.challenge.g
                public void CH() {
                    d.this.bYd().hgl.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.g
                public void a(az azVar, bd bdVar, bd bdVar2) {
                    d.this.gYc = true;
                    if (d.this.gWl != null) {
                        d.this.gWl.vR(8);
                    }
                    if (d.this.gWm != null) {
                        d.this.gWm.setPraiseEnable(false);
                        d.this.bYd().hgl.hvO = false;
                    }
                    if (d.this.gWP != null) {
                        d.this.gWP.setCanVisible(false);
                    }
                    if (d.this.gWn != null) {
                        d.this.gWn.cgE();
                    }
                    if (d.this.gVu != null) {
                        d.this.gVu.setCanVisible(false);
                        d.this.gVu.cbB();
                    }
                    if (d.this.gVv != null) {
                        d.this.gVv.mH(true);
                    }
                    if (d.this.gXr != null) {
                        d.this.gXr.setVisible(8);
                    }
                    if (d.this.gVw != null) {
                        d.this.gVw.setCanVisible(false);
                        d.this.gVw.setVisible(8);
                    }
                    d.this.bYr();
                    d.this.bYs();
                    d.this.bYt();
                    d.this.bYu();
                    d.this.bYv();
                    if (d.this.bYd().blY != null) {
                        d.this.bYd().blY.getLivePlayer().setBackgroundResource(a.c.sdk_transparent);
                    }
                    if (d.this.gWk != null) {
                        d.this.gWk.setTimeTextMode(true);
                    }
                    if (d.this.blV != null && bdVar != null && bdVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(bdVar.aMY);
                        arrayList.add(bdVar2.aMY);
                        com.baidu.live.liveroom.a.c cVar = d.this.blV;
                        if (d.this.gXn) {
                            arrayList = null;
                        }
                        cVar.o(arrayList);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void CI() {
                }

                @Override // com.baidu.live.challenge.g
                public void CJ() {
                }

                @Override // com.baidu.live.challenge.g
                public void bk(boolean z2) {
                    d.this.bYd().hgl.setSwipeClearEnable(true);
                    d.this.gYc = false;
                    if (d.this.gWl != null) {
                        d.this.gWl.vR(0);
                    }
                    if (d.this.gWm != null) {
                        d.this.gWm.setPraiseEnable(true);
                        d.this.bYd().hgl.hvO = true;
                    }
                    if (d.this.gWP != null) {
                        d.this.gWP.setCanVisible(true);
                    }
                    if (d.this.gWn != null) {
                        d.this.gWn.cgF();
                    }
                    if (d.this.gVu != null) {
                        d.this.gVu.setCanVisible(true);
                        d.this.gVu.G(d.this.bYd().hgk.Gz());
                    }
                    if (d.this.gWp != null) {
                        d.this.gWp.nS(true);
                    }
                    if (d.this.gVv != null) {
                        d.this.gVv.mH(false);
                    }
                    if (d.this.gXr != null) {
                        d.this.gXr.setVisible(0);
                    }
                    if (d.this.gVw != null) {
                        d.this.gVw.setCanVisible(true);
                        d.this.gVw.setVisible(0);
                    }
                    d.this.bYr();
                    d.this.bYs();
                    d.this.bYt();
                    d.this.bYu();
                    d.this.bYv();
                    if (d.this.blV != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.bYd().hgk.cfQ());
                        com.baidu.live.liveroom.a.c cVar = d.this.blV;
                        if (d.this.gXn) {
                            arrayList = null;
                        }
                        cVar.o(arrayList);
                    }
                    if (d.this.bYd().blY != null) {
                        d.this.bYd().blY.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
                    }
                    if (d.this.gWk != null) {
                        d.this.gWk.setTimeTextMode(false);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void bl(boolean z2) {
                    if (z2 && d.this.gWS != null) {
                        d.this.gWS.onClose();
                    }
                }
            });
        }
        this.gVy.a(this.gVx);
        this.gVy.i(bYd().hgj.getLiveContainerView());
        this.gVy.b(z, false, false);
        this.gVx.a((i.c) this.gVy);
    }

    public void bWU() {
        this.gWh.c(bYd().hgk.Gz(), false);
    }

    public void bWV() {
        if (bYd().hgk.Gz() != null && bYd().hgk.Gz().aHk != null && bYd().hgk.Gz().mLiveInfo != null) {
            if (this.gVs == null) {
                this.gVs = new com.baidu.tieba.ala.liveroom.v.b(bYd().pageContext);
            }
            long j = bYd().hgk.Gz().aHk.userId;
            int i = bYd().hgk.Gz().mLiveInfo.live_type;
            String str = bYd().hgk.Gz().aHk.portrait;
            String str2 = bYd().hgk.Gz().mLiveInfo.feed_id;
            long j2 = bYd().hgk.Gz().mLiveInfo.live_id;
            this.gVs.a(i, j, bYd().hgk.Gz().aHk.userName, false, str, LU(), str2, j2);
            this.gVs.at(this.gXb);
        }
    }

    private int bYx() {
        return (this.gVy != null ? this.gVy.bm(false) : 0) + bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
    }

    private void bWW() {
        boolean z = true;
        if (this.gWp == null) {
            this.gWp = new com.baidu.tieba.ala.liveroom.x.a(bYd().pageContext, this);
        }
        this.gWp.d(bYd().hgl, false);
        AlaLiveInfoData alaLiveInfoData = bYd().hgk.Gz().mLiveInfo;
        if (alaLiveInfoData != null) {
            boolean z2 = bYc() && alaLiveInfoData.screen_direction != 2;
            boolean isZanAnimUnabled = alaLiveInfoData.mAlaLiveSwitchData != null ? alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled() : false;
            if (!z2 || isZanAnimUnabled) {
                z = false;
            }
            this.gWp.nR(z);
        }
    }

    private void bWY() {
        if (this.gXj || this.gXk) {
            if ((TbadkCoreApplication.isLogin() && this.gWu.Lb().hasText()) || this.gXk) {
                this.gXj = false;
                this.gXk = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.16
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bXz();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void bWR() {
        bWS();
    }

    private void bWS() {
        if (this.gWf != null) {
            int i = bYd().hgk.Gz().aHG.isUegBlock;
            int i2 = bYd().hgk.Gz().aHG.isBlock;
            String str = bYd().hgk.Gz().aHG.userName;
            if (i > 0 || i2 > 0) {
                this.gWf.b(true, i, i2, str);
                this.gWu.a(true, i, i2, str);
                this.gWA.b(true, i, i2, str);
                return;
            }
            this.gWf.b(false, i, i2, str);
            this.gWu.a(false, i, i2, str);
            this.gWA.b(false, i, i2, str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        super.t(aVar);
        if (this.gVv != null) {
            this.gVv.F(aVar);
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
                    if (this.gVu != null) {
                        this.gVu.I(jSONObject2);
                    }
                } else if ("enter_live".equals(optString)) {
                    if (this.gVt != null && this.gVt.getCount() > 20) {
                        this.gVt.ew(this.gVt.getCount() + 1);
                    } else if (this.gVp != null) {
                        com.baidu.live.data.a LF = aVar.LF();
                        p pVar = new p();
                        pVar.aHl = new AlaLocationData();
                        pVar.aHm = new AlaRelationData();
                        pVar.aHk = new AlaLiveUserInfoData();
                        pVar.aHk.userId = JavaTypesHelper.toLong(LF.userId, 0L);
                        pVar.aHk.userName = LF.userName;
                        pVar.aHk.portrait = LF.portrait;
                        if (this.gVt != null && this.gVp.c(pVar)) {
                            this.gVt.ew(this.gVt.getCount() + 1);
                        }
                    }
                } else if ("update_liveinfo".equals(optString)) {
                    if (bYd().hgk.Gz() != null && bYd().hgk.Gz().mLiveInfo != null) {
                        bYd().hgk.a(bYd().hgk.Gz().mLiveInfo.live_id, bYd().fromType, bYd().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && bYd().hgk.Gz() != null && bYd().hgk.Gz().mLiveInfo != null && bYd().hgk.Gz().aHG != null && this.gVy != null) {
                    long optLong = jSONObject2.optLong("mvp_user_id");
                    long optLong2 = jSONObject2.optLong("winner_live_id");
                    if (optLong == bYd().hgk.Gz().aHG.userId && optLong2 == bYd().hgk.Gz().mLiveInfo.live_id) {
                        this.gVy.c(jSONObject2.optInt("challenge_status"), jSONObject2.optLong("challenge_id"));
                    }
                }
            } else {
                return;
            }
        }
        if (this.gWP == null || this.gWP.L(jSONObject2)) {
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void Ho(String str) {
        if (this.gVv != null) {
            this.gVv.Ho(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.gXa != null) {
            this.gXa.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void cl(boolean z) {
        super.cl(z);
        if (bYd().hgl != null) {
            bYd().hgl.chp();
            bYd().hgl.setLiveViewOnDispatchTouchEventListener(null);
            bYd().hgl.setLiveViewOnTouchEventListener(null);
            bYd().hgl.setOnLiveViewScrollListener(null);
        }
        if (bYd().blY != null) {
            bYd().blY.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
        }
        if (this.gVy != null) {
            this.gVy.CD();
        }
        bWZ();
        if (this.gVs != null) {
            this.gVs.CD();
        }
        if (this.gWp != null) {
            this.gWp.release();
        }
        if (this.gVu != null) {
            this.gVu.CD();
        }
        if (this.gWf != null) {
            this.gWf.cfX();
        }
        if (this.gVr != null) {
            this.gVr.caw();
            this.gVr.setVisible(8);
        }
        if (this.gVw != null) {
            this.gVw.CD();
        }
        if (this.gVv != null) {
            this.gVv.release();
        }
        if (this.bpO != null) {
            this.bpO.removeAllViews();
            this.bpO = null;
        }
        if (this.gYa != null) {
            this.gYa.removeAllViews();
            this.gYa = null;
        }
        if (this.gWp != null) {
            this.gWp.onDestroy();
        }
        if (this.gVx != null) {
            this.gVx.CD();
        }
        if (this.gVq != null) {
            this.gVq.ccA();
        }
        if (this.gVM != null) {
            this.gVM.cancel();
        }
        if (this.gXr != null) {
            this.gXr.bZq();
        }
        if (this.gWP != null) {
            this.gWP.Ka();
        }
        if (this.gVC != null) {
            this.gVC.Ka();
        }
        if (this.gVM != null) {
            this.gVM.CD();
        }
        if (this.gWW != null) {
            this.gWW.CD();
        }
        if (this.gXa != null) {
            this.gXa.Qd();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cj(boolean z) {
        super.cj(z);
        bWZ();
        if (this.gVq != null) {
            this.gVq.onDestroy();
        }
        if (this.gVs != null) {
            this.gVs.onDestroy();
        }
        if (this.gVu != null) {
            this.gVu.onDestroy();
        }
        if (this.gVw != null) {
            this.gVw.onDestroy();
        }
        if (this.gVx != null) {
            this.gVx.onDestroy();
        }
        if (this.gVy != null) {
            this.gVy.onDestroy();
        }
        if (this.gVz != null) {
            this.gVz.onDestroy();
        }
        if (this.gWC != null) {
            this.gWC.onDestroy();
        }
        if (this.gVr != null) {
            this.gVr.onDestroy();
        }
        if (this.gVp != null) {
            this.gVp.onDestroy();
        }
        if (this.gWu != null) {
            this.gWu.onDestroy();
        }
        if (this.gWf != null) {
            this.gWf.onDestory();
        }
        if (this.gVv != null) {
            this.gVv.release();
        }
        if (this.gXr != null) {
            this.gXr.cj(!z);
        }
        if (this.gVC != null) {
            this.gVC.onDestroy();
        }
        if (this.gVM != null) {
            this.gVM.onDestroy();
            this.gVM = null;
        }
        if (this.gWW != null) {
            this.gWW.onDestroy();
        }
        if (this.gXa != null) {
            this.gXa.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.gVN);
        MessageManager.getInstance().removeMessageRule(this.gVO);
        MessageManager.getInstance().unRegisterListener(this.gVR);
        MessageManager.getInstance().unRegisterListener(this.gVS);
        MessageManager.getInstance().unRegisterListener(this.gVU);
        MessageManager.getInstance().unRegisterListener(this.gVV);
        MessageManager.getInstance().unRegisterListener(this.gYe);
        MessageManager.getInstance().unRegisterListener(this.gVW);
        MessageManager.getInstance().unRegisterListener(this.gVT);
    }

    private void bWZ() {
        if (this.gWu != null && this.gWu.La().getView() != null && this.gWu.La().getView().getParent() != null) {
            ((ViewGroup) this.gWu.La().getView().getParent()).removeView(this.gWu.La().getView());
        }
        if (this.gVD != null && this.gVD.getParent() != null) {
            ((ViewGroup) this.gVD.getParent()).removeView(this.gVD);
        }
        if (this.gWu != null && this.gWu.Lb().getView() != null) {
            this.gXc.removeView(this.gWu.Lb().getView());
        }
        if (this.gWu != null) {
            this.gWu.La().setMsgData(new LinkedList());
            this.gWu.Cd();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void a(aq aqVar) {
        if (this.gWu != null) {
            bXz();
            this.gWu.Lb().setEditText(" @" + aqVar.getNameShow() + " ");
        }
        if (this.gWf != null) {
            this.gWf.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void g(com.baidu.live.data.a aVar) {
        if (this.gWu != null) {
            bXz();
            this.gWu.Lb().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.gWf != null) {
            this.gWf.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void b(aq aqVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected View bXa() {
        if (this.gWu != null) {
            return this.gWu.Lb().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean bXb() {
        if (this.gWu == null || !this.gWu.Lb().Mv()) {
            return false;
        }
        mM(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected boolean bXc() {
        return this.gVq == null || this.gVq.bXc();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    /* renamed from: bYy */
    public PendantParentView bXd() {
        return this.bpO;
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
                    this.gXg = false;
                    O(intExtra, intExtra2, intExtra3);
                    return;
                }
                bWU();
                return;
            }
            avk();
        } else if (i == 25051 && i2 == -1 && this.gXr != null) {
            this.gXr.cbs();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.gWu != null && this.gWu.La() != null) {
            this.gWu.La().onKeyboardVisibilityChanged(z);
        }
        if (z || this.gWu == null || this.gWu.Lb() == null || !this.gWu.Lb().Mv()) {
            if (z) {
                if (this.gWf != null) {
                    this.gWf.setVisibility(8);
                }
                if (this.gWw != null && this.gWw.FY() != null) {
                    this.gWw.FY().setVisibility(8);
                }
                bXf();
                if (this.gWu != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gWu.Lb().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.gWu.Lb().getView().setLayoutParams(layoutParams);
                    this.gWu.Lb().getView().setVisibility(0);
                    this.gWu.Lb().setQuickInputPanelVisible(false);
                }
                if (this.gXb != null) {
                    this.gXb.setVisibility(8);
                }
                if (this.gVv != null) {
                    this.gVv.setVisible(8);
                }
                if (this.gWv != null) {
                    this.gWv.Cc();
                }
                if (this.gWV != null) {
                    this.gWV.setCanVisible(false);
                }
                if (this.gWO != null) {
                    this.gWO.setCanVisible(false);
                }
                if (this.gWP != null) {
                    this.gWP.setCanVisible(false);
                }
                if (this.gWQ != null) {
                    this.gWQ.setCanVisible(false);
                }
                if (this.gWR != null) {
                    this.gWR.setVisible(8);
                }
            } else {
                bXe();
            }
            bYs();
            if (this.gWH != null) {
                this.gWH.bu(z);
            }
        }
    }

    private void bXe() {
        if (this.gWf != null) {
            this.gWf.setVisibility(0);
        }
        if (this.gVD != null) {
            if (this.gYg) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gVD.getLayoutParams();
                layoutParams.bottomMargin = (M(false, false) - bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) + com.baidu.live.ag.b.TS();
                this.gVD.setLayoutParams(layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gVD.getLayoutParams();
                layoutParams2.bottomMargin = bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds90);
                this.gVD.setLayoutParams(layoutParams2);
            }
        }
        if (this.gWu != null) {
            bXA();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gWu.Lb().getView().getLayoutParams();
            layoutParams3.bottomMargin = 0;
            this.gWu.Lb().getView().setLayoutParams(layoutParams3);
        }
        if (this.gWf != null) {
            this.gWf.setVisibility(0);
        }
        if (this.gWw != null && this.gWw.FY() != null) {
            this.gWw.FY().setVisibility(0);
        }
        if (this.gXb != null) {
            this.gXb.setVisibility(0);
        }
        if (this.gVv != null) {
            this.gVv.setVisible(0);
        }
        if (this.gWv != null) {
            this.gWv.Cc();
        }
        if (this.gWV != null) {
            this.gWV.setCanVisible(true);
        }
        if (this.gWO != null) {
            this.gWO.setCanVisible(true);
        }
        if (this.gWQ != null) {
            this.gWQ.setCanVisible(true);
        }
        if (this.gWR != null) {
            this.gWR.setVisible(0);
        }
        if (this.gWP != null) {
            this.gWP.setCanVisible(!this.gYc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXf() {
        boolean z;
        boolean z2 = false;
        if (this.gVD != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gVD.getLayoutParams();
            if (this.gWu == null || this.gWu.Lb() == null) {
                z = false;
            } else {
                z = this.gWu.Lb().Mt();
                z2 = this.gWu.Lb().Mu();
            }
            int M = M(z, z2);
            if (layoutParams.bottomMargin != M) {
                layoutParams.bottomMargin = M;
                this.gVD.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mM(boolean z) {
        this.gYf = z;
        if (z) {
            this.gWu.Lb().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gVD.getLayoutParams();
            int quickInputPanelExpandHeight = this.gWu.Lb().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.gVD.setLayoutParams(layoutParams);
                if (this.gWu.La() != null) {
                    this.gWu.La().KZ();
                    return;
                }
                return;
            }
            return;
        }
        bXe();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.gVp != null) {
                this.gVp.dE(i3);
            }
            if (this.gVr != null) {
                this.gVr.dE(i3);
            }
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public boolean eK(int i) {
        boolean eK = super.eK(i);
        if (eK && 2 == i) {
            if (this.gVq.bXc()) {
                return false;
            }
            if (eK && this.gWp != null) {
                this.gWp.nS(false);
            }
        }
        return eK;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void vT(int i) {
        super.vT(i);
        if (i == 7 || i == 11) {
            if (this.gWf != null) {
                this.gWf.setVisibility(8);
            }
            if (this.gWu != null) {
                this.gWu.La().getView().setVisibility(4);
            }
            if (this.gVv != null) {
                this.gVv.bM(2, 8);
                if (this.gYc) {
                    this.gVv.bM(1, 8);
                }
            }
            if (this.gWK != null) {
                this.gWK.nM(false);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public void eL(int i) {
        super.eL(i);
        if (i == 7 || i == 11) {
            if (this.gWf != null) {
                this.gWf.setVisibility(0);
            }
            if (this.gWu != null) {
                this.gWu.La().getView().setVisibility(0);
            }
            if (this.gVv != null) {
                this.gVv.setVisible(0);
            }
            if (this.gWK != null) {
                this.gWK.nM(true);
            }
            this.gXb.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.gVs != null) {
            this.gVs.cgv();
        }
        if (this.gVx != null) {
            this.gVx.CM();
        }
        if (this.gVv != null) {
            this.gVv.onStop();
        }
        if (this.gVw != null) {
            this.gVw.bj(true);
        }
        if (this.gXa != null) {
            this.gXa.onStopped();
        }
        if (this.gWZ != null) {
            this.gWZ.onStop();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.gVs != null) {
            this.gVs.cgu();
        }
        if (this.gVx != null && this.gYd) {
            this.gVx.CN();
        }
        if (this.gVv != null) {
            this.gVv.onStart();
        }
        if (this.gVw != null) {
            this.gVw.bj(false);
        }
        if (this.gXa != null) {
            this.gXa.onStarted();
        }
        if (this.gWZ != null) {
            this.gWZ.onStart();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        if (!onKeyDown && i == 4 && this.gXa != null && this.gXa.onKeyDown(i, keyEvent)) {
            return true;
        }
        return onKeyDown;
    }
}
