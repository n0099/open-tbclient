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
    private PendantParentView brz;
    private com.baidu.tieba.ala.liveroom.audiencelist.c gVI;
    private com.baidu.tieba.ala.liveroom.p.a gVJ;
    private com.baidu.tieba.ala.liveroom.g.b gVK;
    private com.baidu.tieba.ala.liveroom.v.b gVL;
    private com.baidu.tieba.ala.liveroom.audiencelist.b gVM;
    private com.baidu.tieba.ala.liveroom.l.a gVN;
    private com.baidu.tieba.ala.liveroom.activeview.b gVO;
    private com.baidu.live.d.a gVP;
    private i gVQ;
    private h gVR;
    private com.baidu.tieba.ala.liveroom.c.a gVS;
    private FrameLayout gVW;
    private com.baidu.tieba.ala.liveroom.j.b gWf;
    private LinearLayout gYt;
    private e gYu;
    private boolean gYv;
    private long lastClickTime = 0;
    private boolean gYw = false;
    private HttpRule gWg = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.gVQ != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.gVQ.DB()) {
                httpMessage.addParam("ala_challenge_id", d.this.gVQ.DE());
            }
            return httpMessage;
        }
    };
    private HttpRule gWh = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.gVQ != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.gVQ.DB()) {
                httpMessage.addParam("challenge_id", d.this.gVQ.DE());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c gWi = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.d.17
        @Override // com.baidu.live.liveroom.g.c
        public void Ob() {
            if (d.this.gWI != null) {
                d.this.gWI.nR(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void ck(boolean z) {
            if (z) {
                if (d.this.gWI != null) {
                    d.this.gWI.nR(true);
                }
            } else if (d.this.gWI != null) {
                d.this.gWI.nR(false);
            }
            if (d.this.gXa != null) {
                d.this.gXa.bt(z);
            }
            if (d.this.gVO != null) {
                d.this.gVO.mI(z ? false : true);
            }
            com.baidu.live.n.a.cl(z);
        }
    };
    private HttpMessageListener gWk = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.d.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Ok() != null) {
                        com.baidu.live.aa.e.Qe().bue = getQuickGiftHttpResponseMessage.Ok();
                        d.this.bXs();
                    }
                }
            }
        }
    };
    CustomMessageListener gWp = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.gWf.c(d.this.bYK());
                } else if (d.this.bXZ() || !g.vI(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.21.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.bYK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.bYK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    d.this.gWf.c(d.this.gVW, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener gYx = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.d.d.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.bXZ() || !g.vI(2913128)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.22.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.vG(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    d.this.HS(str);
                }
            }
        }
    };
    private CustomMessageListener gWl = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.d.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.gWQ.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gWm = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.this.gXe != null) {
                    d.this.gXe.hT(str);
                }
            }
        }
    };
    CustomMessageListener gWn = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.gXB != null && d.this.gXB.bgz != null && !d.this.gXB.bgC && !d.this.gXB.bgD && d.this.gWZ != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.bYK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                layoutParams.bottomMargin = d.this.bYK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                d.this.gWZ.c(d.this.gVW, layoutParams);
                if (com.baidu.live.guardclub.e.KE() != null) {
                    com.baidu.live.guardclub.e.KE().KK();
                }
            }
        }
    };
    private CustomMessageListener gWo = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.gXb != null) {
                    d.this.gXb.dismiss();
                }
                if (d.this.gXe != null) {
                    d.this.gXe.dismiss();
                }
                if (d.this.gXc != null) {
                    d.this.gXc.dismiss();
                }
                if (d.this.gKY != null) {
                    d.this.gKY.dismiss();
                }
                com.baidu.live.im.b.d.Mg().setSwitchStatus(true);
                com.baidu.live.im.b.d.Mg().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bYg();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gWq = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.d.15
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void p(View view, int i) {
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
                    d.this.M(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.aa.e.Qe().bue.GQ().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.aa.e.Qe().bue.GQ().FT());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.aa.e.Qe().bue.GQ().FU());
                        if (d.this.bYK().hgD.Hi() != null && d.this.bYK().hgD.Hi().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.bYK().hgD.Hi().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.bYK().hgD.Hi().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.MD());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.JM()) {
                        if (com.baidu.live.d.AZ().getBoolean("quick_gift_guide_show", true) && !d.this.bXZ()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, af.class, d.this.bYK().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                af afVar = (af) runTask.getData();
                                afVar.setPageContext(d.this.bYK().pageContext);
                                afVar.setLiveShowData(d.this.bYK().hgD.Hi());
                                afVar.setGiftItem(com.baidu.live.aa.e.Qe().bue.GQ());
                                afVar.setOtherParams(d.this.MD());
                                afVar.initView();
                                afVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.d.d.15.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        d.this.mN(false);
                                    }
                                });
                                afVar.show();
                                d.this.mN(true);
                                return;
                            }
                            return;
                        }
                        m.a(d.this.bYK().pageContext, d.this.bYK().hgD.Hi(), com.baidu.live.aa.e.Qe().bue.GQ(), d.this.MD());
                    }
                } else if (i == 1) {
                    if (d.this.gWN != null) {
                        d.this.bYg();
                    }
                } else if (i == 3 && d.this.JM()) {
                    if (com.baidu.live.n.a.isDebug()) {
                        com.baidu.live.n.a.b(d.this.bYK().hgD.Hi().mLiveInfo.live_id, 0);
                        return;
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    d.this.gWA.c(d.this.bYK().hgD.Hi(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.bYK() != null && d.this.bYK().hgD != null && d.this.bYK().hgD.Hi() != null && d.this.bYK().hgD.Hi().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.bYK().hgD.Hi().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.bYK().hgD.Hi().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.bYK().hgD.Hi().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.MD());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.bYK() != null && d.this.bYK().hgD != null && d.this.bYK().hgD.Hi() != null && d.this.bYK().hgD.Hi().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.bYK().hgD.Hi().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.bYK().hgD.Hi().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.bYK().hgD.Hi().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.MD());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.bnG != null) {
                        d.this.bnG.ce(false);
                    }
                } else if (i == 12) {
                    if (d.this.gWI != null && d.this.bYK().hgD.Hi() != null && d.this.bYK().hgD.Hi().mLiveInfo != null) {
                        String valueOf = String.valueOf(d.this.bYK().hgD.Hi().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.bYK().hgD.Hi().mLiveInfo.room_id);
                        String str3 = null;
                        AlaLiveSdkInfo alaLiveSdkInfo = d.this.bYK().hgD.Hi().mLiveSdkInfo;
                        if (alaLiveSdkInfo != null && alaLiveSdkInfo.mCastIds != null) {
                            str3 = String.valueOf(d.this.bYK().hgD.Hi().mLiveSdkInfo.mCastIds.chatMCastId);
                        }
                        d.this.gWI.as(valueOf, valueOf2, str3);
                        com.baidu.live.n.a.b(d.this.bYK().hgD.Hi().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    w Hi = d.this.bYK().hgD.Hi();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.bYK().pageContext.getPageActivity(), Hi.aIV.userName, Long.toString(Hi.aIV.userId), Long.toString(Hi.aIV.charmCount), String.valueOf(Hi.mLiveInfo.group_id), String.valueOf(Hi.mLiveInfo.live_id), false, String.valueOf(Hi.aIV.userId), Long.toString(Hi.aJr.userId), Hi.aJr.userName, Hi.aJr.portrait, d.this.gVM.getCount(), d.this.MD())));
                    LogManager.getCommonLogger().doClickGusetNumLog(Hi.mLiveInfo.feed_id, d.this.gVM.getCount() + "", d.this.MD());
                } else if (i == 11) {
                    d.this.bYj();
                    d.this.bYk();
                } else if (i == 16) {
                    if (d.this.bYK() != null && (bnVar2 = com.baidu.live.aa.a.PQ().btT) != null && (cdVar2 = bnVar2.aPx) != null) {
                        String str4 = cdVar2.aQS.aQZ;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (d.this.bYK().hgD != null && d.this.bYK().hgD.Hi() != null && d.this.bYK().hgD.Hi().mLiveInfo != null) {
                                j = d.this.bYK().hgD.Hi().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", d.this.bYK().hgD.Hi().mLiveInfo.room_id + "", d.this.bYK().hgD.Hi().mLiveInfo.feed_id, d.this.MD());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.bYK().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (d.this.bYK() != null) {
                        w wVar = null;
                        if (d.this.bYK().hgD != null) {
                            wVar = d.this.bYK().hgD.Hi();
                        }
                        if (wVar != null && wVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.w.b.chn().bom != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.w.b.chn().bom.aIk;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(d.this.bYK().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17 && d.this.JM() && d.this.bYK() != null && (bnVar = com.baidu.live.aa.a.PQ().btT) != null && (cdVar = bnVar.aPx) != null && (cjVar = cdVar.aQT) != null && !TextUtils.isEmpty(cjVar.webUrl)) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                    if (d.this.gXb != null && d.this.bYK().hgD != null && d.this.bYK().hgD.Hi() != null) {
                        w Hi2 = d.this.bYK().hgD.Hi();
                        d.this.gXb.a(cjVar.webUrl, Hi2.mLiveInfo.live_id, Hi2.aJr.userId, Hi2.aIV.userId);
                    }
                }
            }
        }
    };
    private boolean gYy = false;
    private boolean gYz = false;

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.gWC = new com.baidu.tieba.ala.liveroom.guide.c(bYK().pageContext, this, false);
        this.gWg.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.gWg);
        this.gWh.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.gWh);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean bXc() {
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(w wVar) {
        super.l(wVar);
        g.cce();
        this.gYw = true;
        this.gYz = false;
        this.gYy = false;
        bYK().hgE.setIsForceHandledTouch(false);
        bYK().hgE.setSwipeClearEnable(true);
        bYK().hgE.setOnLiveViewScrollListener(this.gWi);
        bYK().hgE.setOnClickListener(null);
        bYK().hgE.setClickable(false);
        if (this.gWF != null) {
            this.gWF.b(this.gWq);
        }
        if (this.gXu != null) {
            this.gXu.setVisibility(0);
        }
        bXk();
        if (this.gWX != null) {
            this.gWX.a(wVar, this.brz);
            this.gWX.U(this.gXv);
            this.gWX.a(this);
        }
        bZd();
        bXv();
        bXU();
        bXw();
        bXA();
        bXx();
        mO(false);
        bYm();
        bXt();
        bYo();
        bXC();
        bXD();
        bYW();
        bYX();
        mP(false);
        bYq();
        bXj();
        bYC();
        bXm();
        bXs();
        bXn();
        bXo();
        bXp();
        bXq();
        bXf();
        bYs();
        bYy();
        bYn();
        bYr();
        mT(true);
        bYB();
        c(this.gaY);
        bYV();
        bYx();
        MessageManager.getInstance().registerListener(this.gWk);
        MessageManager.getInstance().registerListener(this.gWl);
        MessageManager.getInstance().registerListener(this.gWn);
        MessageManager.getInstance().registerListener(this.gWo);
        MessageManager.getInstance().registerListener(this.gYx);
        MessageManager.getInstance().registerListener(this.gWp);
        MessageManager.getInstance().registerListener(this.gWm);
        bXF();
        bXz();
    }

    private void bYV() {
        AlaVideoBCChatData alaVideoBCChatData;
        CustomResponsedMessage runTask;
        AlaLiveUserInfoData alaLiveUserInfoData = bYK().hgD.Hi().aJr;
        if (alaLiveUserInfoData != null && (alaVideoBCChatData = alaLiveUserInfoData.videoBCEnterData) != null && alaVideoBCChatData.isShowEnter()) {
            if (this.gXt == null && (runTask = MessageManager.getInstance().runTask(2913255, com.baidu.live.aj.c.class, bYK().pageContext)) != null && runTask.getData() != null) {
                this.gXt = (com.baidu.live.aj.c) runTask.getData();
            }
            if (this.gXt != null) {
                this.gXt.a(bYK().bnJ);
                this.gXt.b(bYK().hgC.getMastView());
                this.gXt.q(bYK().hgD.Hi());
                this.gXt.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.18
                    @Override // com.baidu.live.aj.c.a
                    public void UR() {
                        if (d.this.gWF != null) {
                            d.this.bYK().hgE.hwh = false;
                            d.this.gWF.setPraiseEnable(false);
                            if (d.this.bYK().hgF != null) {
                                d.this.bYK().hgF.setIsScrollable(false);
                            }
                        }
                    }

                    @Override // com.baidu.live.aj.c.a
                    public void US() {
                        if (d.this.gWF != null) {
                            d.this.bYK().hgE.hwh = true;
                            d.this.gWF.setPraiseEnable(true);
                            if (d.this.bYK().hgF != null) {
                                d.this.bYK().hgF.setIsScrollable(true);
                            }
                        }
                    }
                });
                View enterView = this.gXt.getEnterView();
                if (enterView != null) {
                    if (enterView.getParent() != null) {
                        ((ViewGroup) enterView.getParent()).removeView(enterView);
                    }
                    this.gWy.cg(enterView);
                }
            }
        }
    }

    private void bXf() {
        if (this.gXl != null) {
            this.gXl.a(new com.baidu.live.v.c() { // from class: com.baidu.tieba.ala.liveroom.d.d.19
                @Override // com.baidu.live.v.c
                public void cr(boolean z) {
                    if (d.this.gVR != null) {
                        d.this.gVR.setNeedCloseRecommendFloat(z);
                    }
                    if (d.this.bYK().hgE.hwh) {
                        if (d.this.gWI != null) {
                            d.this.gWI.nJ(z);
                            d.this.gWI.nR(!z);
                        }
                        if (d.this.gWF != null) {
                            d.this.gWF.nJ(z);
                            d.this.gWF.setPraiseEnable(!z);
                            d.this.gWF.nI(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void j(w wVar) {
        super.j(wVar);
        if (this.gVJ != null) {
            this.gVJ.H(wVar);
        }
        if (this.gVK != null) {
            this.gVK.D(wVar);
        }
        if (this.gVN != null) {
            this.gVN.G(wVar);
        }
        if (this.gVR != null) {
            this.gVR.a(wVar);
        }
        mT(false);
        if (this.gVO != null) {
            this.gVO.i(wVar);
            this.gVO.mH(this.gXE);
            this.gVO.updateView();
            if (wVar != null && this.gXn != null && !this.gXn.hasInit && !TextUtils.isEmpty(this.gXn.aPR)) {
                this.gXn.hasInit = true;
                this.gVO.HO(this.gXn.aPR);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(q qVar) {
        if (qVar != null) {
            if (this.gVI != null && qVar.getList() != null) {
                this.gVI.e(qVar);
            }
            if (this.gVM != null) {
                this.gVM.ew(qVar.getCount());
            }
        }
    }

    private void bXh() {
        if (this.gWH != null) {
            this.gWH.aB(bYK().hgC.getLiveContainerView());
        }
    }

    private void bYW() {
        if (this.gVS == null) {
            this.gVS = new com.baidu.tieba.ala.liveroom.c.a(bYK().pageContext);
        }
        if (bYK().hgD != null && bYK().hgD.Hi() != null && bYK().hgD.Hi().mLiveInfo != null) {
            this.gVS.HP(String.valueOf(bYK().hgD.Hi().mLiveInfo.user_id));
        }
    }

    private void bYX() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (bYK() != null && bYK().hgD != null && bYK().hgD.Hi() != null && bYK().hgD.Hi().mLiveInfo != null) {
                j = bYK().hgD.Hi().mLiveInfo.room_id;
            }
            if (this.gWV == null) {
                this.gWV = new com.baidu.tieba.ala.liveroom.guide.a(bYK().pageContext, j);
            }
            this.gWV.mM(this.gXx);
            this.gWV.a(new a.InterfaceC0675a() { // from class: com.baidu.tieba.ala.liveroom.d.d.5
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0675a
                public void bZg() {
                    if (d.this.bnG != null) {
                        d.this.bnG.ce(true);
                    }
                }
            });
            this.gWV.ax(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void dM(int i) {
        super.dM(i);
        bXh();
        if (this.gVR != null) {
            this.gVR.dM(i);
        }
    }

    private void bXk() {
        if (this.brz == null) {
            this.brz = new PendantParentView(bYK().pageContext.getPageActivity(), this.gYv ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            bYK().hgE.addView(this.brz, new ViewGroup.LayoutParams(-1, -1));
            this.brz.setDefaultItemMargin(bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.brz.setPadding(bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            bYY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYY() {
        int dimensionPixelSize;
        if (this.brz != null) {
            this.brz.setModel(this.gYv ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            int dimensionPixelSize2 = bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds220);
            int dimensionPixelSize3 = bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            if (this.gYv) {
                dimensionPixelSize = bZe();
            } else {
                dimensionPixelSize = bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds200);
            }
            this.brz.setPosition(dimensionPixelSize2, 0, dimensionPixelSize, dimensionPixelSize3);
            return;
        }
        bXk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYZ() {
        if (bYK().hgE != null && !this.gYz) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.6
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.gVW != null && d.this.gWN != null && d.this.gWN.LJ() != null && d.this.gWN.LJ().getView() != null) {
                        if (d.this.gYv && !d.this.gXy && d.this.bYK().hgE != null && d.this.bYK().hgE.getHeight() > 0) {
                            int bk = d.this.gVR != null ? d.this.gVR.bk(false) : 0;
                            ViewGroup.LayoutParams layoutParams = d.this.gVW.getLayoutParams();
                            int height = d.this.bYK().hgE.getHeight() - bk;
                            int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                i += UtilHelper.getStatusBarHeight();
                            }
                            if (layoutParams != null && d.this.gWN != null) {
                                layoutParams.height = i + d.this.bYK().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                                d.this.gVW.setLayoutParams(layoutParams);
                                ViewGroup.LayoutParams layoutParams2 = d.this.gWN.LJ().getView().getLayoutParams();
                                if (layoutParams2 != null) {
                                    layoutParams2.height = layoutParams.height - com.baidu.live.ag.b.cV(false);
                                    d.this.gWN.LJ().getView().setLayoutParams(layoutParams2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        int i2 = com.baidu.live.ag.b.i(false, d.this.gXy);
                        if (d.this.gXv.indexOfChild(d.this.gVW) != -1 && d.this.gVW.getLayoutParams() != null) {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) d.this.gVW.getLayoutParams();
                            layoutParams3.height = com.baidu.live.ag.b.c(false, false, d.this.gXy);
                            d.this.gVW.setLayoutParams(layoutParams3);
                        }
                        if (d.this.gVW.indexOfChild(d.this.gWN.LJ().getView()) != -1 && d.this.gWN.LJ().getView().getLayoutParams() != null) {
                            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) d.this.gWN.LJ().getView().getLayoutParams();
                            layoutParams4.height = i2;
                            d.this.gWN.LJ().getView().setLayoutParams(layoutParams4);
                        }
                        d.this.gWN.LJ().LI();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZa() {
        if (bYK().hgE != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.7
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.gWP != null) {
                        if (d.this.gYv && !d.this.gXy && d.this.bYK().hgE != null && d.this.bYK().hgE.getHeight() > 0) {
                            int height = (d.this.bYK().hgE.getHeight() - (d.this.gVR != null ? d.this.gVR.bk(false) : 0)) + d.this.bYK().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            if (d.this.gWP != null) {
                                d.this.gWP.dU(height);
                            }
                        } else if (d.this.gWP != null) {
                            d.this.gWP.dU(com.baidu.live.ag.a.a(d.this.bYK().pageContext.getPageActivity(), false, false, d.this.gXy));
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZb() {
        if (bYK().hgE != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.8
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    if (d.this.gWP != null) {
                        int h = com.baidu.live.ag.a.h(false, false);
                        if (!d.this.gYv || d.this.bYK().hgE == null || d.this.bYK().hgE.getHeight() <= 0) {
                            i = h;
                        } else {
                            int height = d.this.bYK().hgE.getHeight() - (d.this.gVR != null ? d.this.gVR.bk(false) : 0);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            i = height + d.this.bYK().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                        }
                        if (d.this.gWP != null) {
                            d.this.gWP.dV(i);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZc() {
        if (this.gWO != null && this.gWO.CK() != null) {
            ViewGroup.LayoutParams layoutParams = this.gWO.CK().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bYK().pageContext.getResources().getDimensionPixelOffset(this.gYv ? a.d.sdk_ds100 : a.d.sdk_ds20);
                this.gWO.CK().setLayoutParams(layoutParams);
            }
        }
    }

    private void bZd() {
        if (this.gYt == null) {
            this.gYt = new LinearLayout(bYK().pageContext.getPageActivity());
            this.gYt.setOrientation(1);
        }
        if (this.gYt.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds160);
            layoutParams.leftMargin = bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            bYK().hgE.addView(this.gYt, layoutParams);
        }
    }

    private void bXm() {
        if (this.gVO == null) {
            this.gVO = new com.baidu.tieba.ala.liveroom.activeview.b(bYK().pageContext);
        }
        if (bYK() != null && bYK().hgD != null) {
            this.gVO.HL(bYK().hgD.cgB());
        }
        this.gVO.mG(this.gYv);
        this.gVO.setOtherParams(MD());
        this.gVO.b(bYK().hgD.Hi(), false);
        this.gVO.setHost(false);
        this.gVO.mH(this.gXE);
        this.gVO.a(1, this.brz);
        this.gVO.a(2, this.brz);
        this.gVO.setVisible(this.gXy ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXs() {
        if (this.gWy == null) {
            bXx();
        }
        this.gWy.setOtherParams(MD());
        this.gWy.a(com.baidu.live.aa.e.Qe().bue, bYK().hgD.Hi());
    }

    private void bXn() {
        if (this.gVN == null) {
            this.gVN = new com.baidu.tieba.ala.liveroom.l.a(bYK().pageContext, this);
        }
        this.gVN.setOtherParams(MD());
        this.gVN.a((ViewGroup) this.brz, bXr());
        this.gVN.G(bYK().hgD.Hi());
    }

    private void bXo() {
        if (this.gWZ == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, j.class, bYK().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gWZ = (j) runTask.getData();
            } else {
                return;
            }
        }
        this.gWZ.setOtherParams(MD());
        if (this.gVW != null && this.gVW.indexOfChild(this.gWZ.getView()) >= 0) {
            this.gVW.removeView(this.gWZ.getView());
        }
    }

    private void bXp() {
        if (this.gWy != null) {
            this.gWy.a(new a.InterfaceC0682a() { // from class: com.baidu.tieba.ala.liveroom.d.d.9
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0682a
                public void bO(int i, int i2) {
                    w Hi = d.this.bYK().hgD.Hi();
                    if (Hi != null && Hi.mLiveInfo != null) {
                        if (d.this.gXd == null) {
                            d.this.gXd = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.bYK().pageContext.getPageActivity());
                        }
                        d.this.gXd.d(d.this.gXv, i, i2);
                        d.this.gXd.a(String.valueOf(Hi.mLiveInfo.live_id), new a.InterfaceC0686a() { // from class: com.baidu.tieba.ala.liveroom.d.d.9.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0686a
                            public void a(float f, String str) {
                                if (d.this.gWy != null) {
                                    d.this.gWy.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0682a
                public void bP(int i, int i2) {
                    if (d.this.gXd != null) {
                        d.this.gXd.bU(i, i2);
                    }
                }
            });
        }
    }

    private void bXq() {
        if (this.gXK == null) {
            this.gXK = new com.baidu.tieba.ala.liveroom.j.e(bYK().pageContext);
        }
        this.gXK.setRoomId(bYK().hgD.Hi().mLiveInfo.room_id);
        this.gXK.Ie("");
        this.gXK.b(bYK().hgD.Hi(), this.brz);
        if (this.gWf == null) {
            this.gWf = new com.baidu.tieba.ala.liveroom.j.b(bYK().pageContext, MD(), this.gXK, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.10
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bXN() {
                    d.this.mN(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bXO() {
                    d.this.mN(false);
                }
            });
        }
        this.gWf.setRoomId(bYK().hgD.Hi().mLiveInfo.room_id);
        if (this.gVW != null && this.gVW.indexOfChild(this.gWf.getView()) >= 0) {
            this.gVW.removeView(this.gWf.getView());
        }
        if (this.gWf != null) {
            this.gWf.b(bYK());
        }
    }

    private LinearLayout.LayoutParams bXr() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    private void bXt() {
        CustomResponsedMessage runTask;
        if (this.gWN == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, bYK().pageContext)) != null && runTask.getData() != null) {
            this.gWN = (k) runTask.getData();
            this.gWN.setFromMaster(false);
            this.gWN.LJ().getView().setId(a.f.ala_liveroom_msg_list);
            this.gWN.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.11
                @Override // com.baidu.live.im.k.a
                public boolean LM() {
                    return d.this.JM();
                }

                @Override // com.baidu.live.im.k.a
                public void LN() {
                    d.this.gXC = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hJ(String str) {
                    if (!d.this.gXy) {
                        d.this.mL(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.bYK().pageContext.getPageActivity(), d.this.bYK().hgC.getLiveContainerView());
                    }
                    d.this.HR(str);
                }

                @Override // com.baidu.live.im.k.a
                public void LO() {
                    if (d.this.gXy) {
                        d.this.mL(true);
                        d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.bYK().pageContext.getPageActivity(), d.this.bYK().hgC.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.gWN != null) {
                        d.this.gWN.LK().setQuickInputPanelVisible(false);
                        d.this.gWN.LK().Nf();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void LP() {
                    if (d.this.gXy) {
                        d.this.bXM();
                        if (d.this.gWO != null) {
                            d.this.gWO.CL();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean LQ() {
                    return d.this.bYa();
                }

                @Override // com.baidu.live.im.k.a
                public int LR() {
                    return d.this.bYb();
                }
            });
            this.gVW = new FrameLayout(bYK().pageContext.getPageActivity());
            this.gVW.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.gWN != null && this.gVW != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bYK().pageContext.getPageActivity()) * 0.7f);
            int i = com.baidu.live.ag.b.i(false, false);
            if (this.gXv.indexOfChild(this.gVW) < 0) {
                if (this.gVW.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gVW.getParent()).removeView(this.gVW);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.live.ag.b.c(false, false, false));
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.live.ag.b.cU(false);
                this.gXv.addView(this.gVW, layoutParams);
            }
            if (this.gVW.indexOfChild(this.gWN.LJ().getView()) < 0) {
                if (this.gWN.LJ().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gWN.LJ().getView()).removeView(this.gWN.LJ().getView());
                }
                this.gVW.addView(this.gWN.LJ().getView(), new FrameLayout.LayoutParams(equipmentWidth, i));
            }
            if (bYK().hgE.indexOfChild(this.gWN.LK().getView()) < 0) {
                if (this.gWN.LK().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gWN.LK().getView().getParent()).removeView(this.gWN.LK().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bYh();
                bYK().hgE.addView(this.gWN.LK().getView(), layoutParams2);
            }
            w Hi = bYK().hgD.Hi();
            if (Hi != null && Hi.mLiveInfo != null) {
                this.gWN.setLogData(Hi.mLiveInfo.feed_id, MD());
            }
            this.gWN.a(String.valueOf(bYK().hgD.Hi().mLiveInfo.group_id), String.valueOf(bYK().hgD.Hi().mLiveInfo.last_msg_id), String.valueOf(bYK().hgD.Hi().aIV.userId), String.valueOf(bYK().hgD.Hi().mLiveInfo.live_id), bYK().hgD.Hi().aIV.appId, (Hi == null || Hi.aJH == null || !Hi.aJH.Ea()) ? false : true);
            mL(false);
        }
    }

    private void bXv() {
        if (this.gVJ == null) {
            this.gVJ = new com.baidu.tieba.ala.liveroom.p.a(bYK().pageContext, false, this);
        }
        this.gVJ.d(this.gXu, bYK().hgD.Hi());
        this.gVJ.a(this.gWq);
        this.gVJ.setOtherParams(MD());
    }

    private void bXw() {
        if (this.gVI == null) {
            this.gVI = new com.baidu.tieba.ala.liveroom.audiencelist.c(bYK().pageContext, this, false);
        }
        this.gVI.a(String.valueOf(bYK().hgD.Hi().mLiveInfo.group_id), String.valueOf(bYK().hgD.Hi().mLiveInfo.live_id), String.valueOf(bYK().hgD.Hi().aIV.userId), bYK().hgD.Hi());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.f.ala_liveroom_hostheader;
            if (this.gWz != null && this.gWz.getView() != null && this.gWz.getView().getParent() != null) {
                i = a.f.ala_liveroom_guardthrone;
            }
            this.gVI.c(this.gXu, i, a.f.ala_liveroom_audience_count_layout);
            this.gVI.e(bYK().hgD.bRq());
            this.gVI.setOtherParams(MD());
        }
    }

    private void bXx() {
        com.baidu.live.core.a.a Nt;
        if (this.gWy == null) {
            this.gWy = new com.baidu.tieba.ala.liveroom.operation.a(bYK().pageContext);
        }
        this.gWy.a(bYK(), this.gXv, bYK().hgD.Hi().mLiveInfo, true, this.gWq);
        this.gWy.setOtherParams(MD());
        if (this.gWX != null && (Nt = this.gWX.Nt()) != null) {
            View rootLayout = Nt.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.gWy.cf(rootLayout);
        }
    }

    public void mS(boolean z) {
        if (this.gWy != null) {
            this.gWy.mS(z);
        }
    }

    private void bXA() {
        if (this.gVM == null) {
            this.gVM = new com.baidu.tieba.ala.liveroom.audiencelist.b(bYK().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (bYK().hgD.bRq() != null) {
            j = bYK().hgD.bRq().getCount();
        }
        this.gVM.a(this.gWq);
        this.gVM.a(this.gXu, a.f.ala_liveroom_hostheader, j);
        this.gVM.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.gVM.mW(false);
        } else {
            this.gVM.mW(true);
        }
    }

    protected void HS(String str) {
        if (this.gXJ == null) {
            this.gXJ = new com.baidu.tieba.ala.liveroom.u.b(bYK().pageContext);
        }
        this.gXJ.c(this.gXv, str);
        mN(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.13
            @Override // java.lang.Runnable
            public void run() {
                d.this.gXJ.cha();
                d.this.mN(false);
            }
        }, 5000L);
    }

    private void mT(boolean z) {
        CustomResponsedMessage runTask;
        if (bYK().hgD.Hi().mLiveInfo.live_type == 1 && this.gYw) {
            if (this.gYu == null && (runTask = MessageManager.getInstance().runTask(2913074, e.class, bYK().pageContext)) != null && runTask.getData() != null) {
                this.gYu = (e) runTask.getData();
            }
            if (this.gYu != null) {
                if (this.gVQ == null) {
                    this.gVQ = this.gYu.a(bYK().pageContext);
                }
                if (z) {
                    this.gVQ.Du();
                }
                if (bYK().hgD.Hi().mLiveInfo.challengeId > 0 && !this.gVQ.DC()) {
                    this.gVQ.e(bYK().hgD.Hi().mLiveInfo.live_id, bYK().hgD.Hi().aIV.userId);
                    mU(z);
                    if (z) {
                        this.gVQ.a(bYK().hgD.cfI());
                    }
                    this.gVQ.c(bYK().hgD.Hi());
                }
            }
        }
    }

    private void mU(boolean z) {
        if (this.gVR == null) {
            this.gVR = this.gYu.b(bYK().pageContext);
            this.gVR.a(new com.baidu.live.challenge.g() { // from class: com.baidu.tieba.ala.liveroom.d.d.14
                @Override // com.baidu.live.challenge.g
                public void Dq() {
                    d.this.bYK().hgE.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.g
                public void a(az azVar, bd bdVar, bd bdVar2) {
                    d.this.gYv = true;
                    if (d.this.gWE != null) {
                        d.this.gWE.vt(8);
                    }
                    if (d.this.gWF != null) {
                        d.this.gWF.setPraiseEnable(false);
                        d.this.bYK().hgE.hwh = false;
                    }
                    if (d.this.gXi != null) {
                        d.this.gXi.setCanVisible(false);
                    }
                    if (d.this.gWG != null) {
                        d.this.gWG.chl();
                    }
                    if (d.this.gVN != null) {
                        d.this.gVN.setCanVisible(false);
                        d.this.gVN.cci();
                    }
                    if (d.this.gVO != null) {
                        d.this.gVO.mG(true);
                    }
                    if (d.this.gXK != null) {
                        d.this.gXK.setVisible(8);
                    }
                    if (d.this.gVP != null) {
                        d.this.gVP.setCanVisible(false);
                        d.this.gVP.setVisible(8);
                    }
                    d.this.bYY();
                    d.this.bYZ();
                    d.this.bZa();
                    d.this.bZb();
                    d.this.bZc();
                    if (d.this.bYK().bnJ != null) {
                        d.this.bYK().bnJ.getLivePlayer().setBackgroundResource(a.c.sdk_transparent);
                    }
                    if (d.this.gWD != null) {
                        d.this.gWD.setTimeTextMode(true);
                    }
                    if (d.this.bnG != null && bdVar != null && bdVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(bdVar.aOJ);
                        arrayList.add(bdVar2.aOJ);
                        com.baidu.live.liveroom.a.c cVar = d.this.bnG;
                        if (d.this.gXG) {
                            arrayList = null;
                        }
                        cVar.o(arrayList);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void Dr() {
                }

                @Override // com.baidu.live.challenge.g
                public void Ds() {
                }

                @Override // com.baidu.live.challenge.g
                public void bi(boolean z2) {
                    d.this.bYK().hgE.setSwipeClearEnable(true);
                    d.this.gYv = false;
                    if (d.this.gWE != null) {
                        d.this.gWE.vt(0);
                    }
                    if (d.this.gWF != null) {
                        d.this.gWF.setPraiseEnable(true);
                        d.this.bYK().hgE.hwh = true;
                    }
                    if (d.this.gXi != null) {
                        d.this.gXi.setCanVisible(true);
                    }
                    if (d.this.gWG != null) {
                        d.this.gWG.chm();
                    }
                    if (d.this.gVN != null) {
                        d.this.gVN.setCanVisible(true);
                        d.this.gVN.G(d.this.bYK().hgD.Hi());
                    }
                    if (d.this.gWI != null) {
                        d.this.gWI.nR(true);
                    }
                    if (d.this.gVO != null) {
                        d.this.gVO.mG(false);
                    }
                    if (d.this.gXK != null) {
                        d.this.gXK.setVisible(0);
                    }
                    if (d.this.gVP != null) {
                        d.this.gVP.setCanVisible(true);
                        d.this.gVP.setVisible(0);
                    }
                    d.this.bYY();
                    d.this.bYZ();
                    d.this.bZa();
                    d.this.bZb();
                    d.this.bZc();
                    if (d.this.bnG != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.bYK().hgD.cgx());
                        com.baidu.live.liveroom.a.c cVar = d.this.bnG;
                        if (d.this.gXG) {
                            arrayList = null;
                        }
                        cVar.o(arrayList);
                    }
                    if (d.this.bYK().bnJ != null) {
                        d.this.bYK().bnJ.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
                    }
                    if (d.this.gWD != null) {
                        d.this.gWD.setTimeTextMode(false);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void bj(boolean z2) {
                    if (z2 && d.this.gXl != null) {
                        d.this.gXl.onClose();
                    }
                }
            });
        }
        this.gVR.a(this.gVQ);
        this.gVR.m(bYK().hgC.getLiveContainerView());
        this.gVR.b(z, false, false);
        this.gVQ.a((i.c) this.gVR);
    }

    public void bXB() {
        this.gWA.c(bYK().hgD.Hi(), false);
    }

    public void bXC() {
        if (bYK().hgD.Hi() != null && bYK().hgD.Hi().aIV != null && bYK().hgD.Hi().mLiveInfo != null) {
            if (this.gVL == null) {
                this.gVL = new com.baidu.tieba.ala.liveroom.v.b(bYK().pageContext);
            }
            long j = bYK().hgD.Hi().aIV.userId;
            int i = bYK().hgD.Hi().mLiveInfo.live_type;
            String str = bYK().hgD.Hi().aIV.portrait;
            String str2 = bYK().hgD.Hi().mLiveInfo.feed_id;
            long j2 = bYK().hgD.Hi().mLiveInfo.live_id;
            this.gVL.a(i, j, bYK().hgD.Hi().aIV.userName, false, str, MD(), str2, j2);
            this.gVL.ax(this.gXu);
        }
    }

    private int bZe() {
        return (this.gVR != null ? this.gVR.bk(false) : 0) + bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
    }

    private void bXD() {
        boolean z = true;
        if (this.gWI == null) {
            this.gWI = new com.baidu.tieba.ala.liveroom.x.a(bYK().pageContext, this);
        }
        this.gWI.d(bYK().hgE, false);
        AlaLiveInfoData alaLiveInfoData = bYK().hgD.Hi().mLiveInfo;
        if (alaLiveInfoData != null) {
            boolean z2 = bYJ() && alaLiveInfoData.screen_direction != 2;
            boolean isZanAnimUnabled = alaLiveInfoData.mAlaLiveSwitchData != null ? alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled() : false;
            if (!z2 || isZanAnimUnabled) {
                z = false;
            }
            this.gWI.nQ(z);
        }
    }

    private void bXF() {
        if (this.gXC || this.gXD) {
            if ((TbadkCoreApplication.isLogin() && this.gWN.LK().hasText()) || this.gXD) {
                this.gXC = false;
                this.gXD = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.16
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bYg();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void bXy() {
        bXz();
    }

    private void bXz() {
        if (this.gWy != null) {
            int i = bYK().hgD.Hi().aJr.isUegBlock;
            int i2 = bYK().hgD.Hi().aJr.isBlock;
            String str = bYK().hgD.Hi().aJr.userName;
            if (i > 0 || i2 > 0) {
                this.gWy.b(true, i, i2, str);
                this.gWN.a(true, i, i2, str);
                this.gWT.b(true, i, i2, str);
                return;
            }
            this.gWy.b(false, i, i2, str);
            this.gWN.a(false, i, i2, str);
            this.gWT.b(false, i, i2, str);
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
        if (this.gVO != null) {
            this.gVO.F(aVar);
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
                    if (this.gVN != null) {
                        this.gVN.O(jSONObject2);
                    }
                } else if ("enter_live".equals(optString)) {
                    if (this.gVM != null && this.gVM.getCount() > 20) {
                        this.gVM.ew(this.gVM.getCount() + 1);
                    } else if (this.gVI != null) {
                        com.baidu.live.data.a Mo = aVar.Mo();
                        p pVar = new p();
                        pVar.aIW = new AlaLocationData();
                        pVar.aIX = new AlaRelationData();
                        pVar.aIV = new AlaLiveUserInfoData();
                        pVar.aIV.userId = JavaTypesHelper.toLong(Mo.userId, 0L);
                        pVar.aIV.userName = Mo.userName;
                        pVar.aIV.portrait = Mo.portrait;
                        if (this.gVM != null && this.gVI.c(pVar)) {
                            this.gVM.ew(this.gVM.getCount() + 1);
                        }
                    }
                } else if ("update_liveinfo".equals(optString)) {
                    if (bYK().hgD.Hi() != null && bYK().hgD.Hi().mLiveInfo != null) {
                        bYK().hgD.a(bYK().hgD.Hi().mLiveInfo.live_id, bYK().fromType, bYK().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && bYK().hgD.Hi() != null && bYK().hgD.Hi().mLiveInfo != null && bYK().hgD.Hi().aJr != null && this.gVR != null) {
                    long optLong = jSONObject2.optLong("mvp_user_id");
                    long optLong2 = jSONObject2.optLong("winner_live_id");
                    if (optLong == bYK().hgD.Hi().aJr.userId && optLong2 == bYK().hgD.Hi().mLiveInfo.live_id) {
                        this.gVR.c(jSONObject2.optInt("challenge_status"), jSONObject2.optLong("challenge_id"));
                    }
                }
            } else {
                return;
            }
        }
        if (this.gXi == null || this.gXi.R(jSONObject2)) {
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void HN(String str) {
        if (this.gVO != null) {
            this.gVO.HN(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.gXt != null) {
            this.gXt.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void cj(boolean z) {
        super.cj(z);
        if (bYK().hgE != null) {
            bYK().hgE.chW();
            bYK().hgE.setLiveViewOnDispatchTouchEventListener(null);
            bYK().hgE.setLiveViewOnTouchEventListener(null);
            bYK().hgE.setOnLiveViewScrollListener(null);
        }
        if (bYK().bnJ != null) {
            bYK().bnJ.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
        }
        if (this.gVR != null) {
            this.gVR.Dm();
        }
        bXG();
        if (this.gVL != null) {
            this.gVL.Dm();
        }
        if (this.gWI != null) {
            this.gWI.release();
        }
        if (this.gVN != null) {
            this.gVN.Dm();
        }
        if (this.gWy != null) {
            this.gWy.cgE();
        }
        if (this.gVK != null) {
            this.gVK.cbd();
            this.gVK.setVisible(8);
        }
        if (this.gVP != null) {
            this.gVP.Dm();
        }
        if (this.gVO != null) {
            this.gVO.release();
        }
        if (this.brz != null) {
            this.brz.removeAllViews();
            this.brz = null;
        }
        if (this.gYt != null) {
            this.gYt.removeAllViews();
            this.gYt = null;
        }
        if (this.gWI != null) {
            this.gWI.onDestroy();
        }
        if (this.gVQ != null) {
            this.gVQ.Dm();
        }
        if (this.gVJ != null) {
            this.gVJ.cdh();
        }
        if (this.gWf != null) {
            this.gWf.cancel();
        }
        if (this.gXK != null) {
            this.gXK.bZX();
        }
        if (this.gXi != null) {
            this.gXi.KJ();
        }
        if (this.gVV != null) {
            this.gVV.KJ();
        }
        if (this.gWf != null) {
            this.gWf.Dm();
        }
        if (this.gXp != null) {
            this.gXp.Dm();
        }
        if (this.gXt != null) {
            this.gXt.QM();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void ch(boolean z) {
        super.ch(z);
        bXG();
        if (this.gVJ != null) {
            this.gVJ.onDestroy();
        }
        if (this.gVL != null) {
            this.gVL.onDestroy();
        }
        if (this.gVN != null) {
            this.gVN.onDestroy();
        }
        if (this.gVP != null) {
            this.gVP.onDestroy();
        }
        if (this.gVQ != null) {
            this.gVQ.onDestroy();
        }
        if (this.gVR != null) {
            this.gVR.onDestroy();
        }
        if (this.gVS != null) {
            this.gVS.onDestroy();
        }
        if (this.gWV != null) {
            this.gWV.onDestroy();
        }
        if (this.gVK != null) {
            this.gVK.onDestroy();
        }
        if (this.gVI != null) {
            this.gVI.onDestroy();
        }
        if (this.gWN != null) {
            this.gWN.onDestroy();
        }
        if (this.gWy != null) {
            this.gWy.onDestory();
        }
        if (this.gVO != null) {
            this.gVO.release();
        }
        if (this.gXK != null) {
            this.gXK.ch(!z);
        }
        if (this.gVV != null) {
            this.gVV.onDestroy();
        }
        if (this.gWf != null) {
            this.gWf.onDestroy();
            this.gWf = null;
        }
        if (this.gXp != null) {
            this.gXp.onDestroy();
        }
        if (this.gXt != null) {
            this.gXt.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.gWg);
        MessageManager.getInstance().removeMessageRule(this.gWh);
        MessageManager.getInstance().unRegisterListener(this.gWk);
        MessageManager.getInstance().unRegisterListener(this.gWl);
        MessageManager.getInstance().unRegisterListener(this.gWn);
        MessageManager.getInstance().unRegisterListener(this.gWo);
        MessageManager.getInstance().unRegisterListener(this.gYx);
        MessageManager.getInstance().unRegisterListener(this.gWp);
        MessageManager.getInstance().unRegisterListener(this.gWm);
    }

    private void bXG() {
        if (this.gWN != null && this.gWN.LJ().getView() != null && this.gWN.LJ().getView().getParent() != null) {
            ((ViewGroup) this.gWN.LJ().getView().getParent()).removeView(this.gWN.LJ().getView());
        }
        if (this.gVW != null && this.gVW.getParent() != null) {
            ((ViewGroup) this.gVW.getParent()).removeView(this.gVW);
        }
        if (this.gWN != null && this.gWN.LK().getView() != null) {
            this.gXv.removeView(this.gWN.LK().getView());
        }
        if (this.gWN != null) {
            this.gWN.LJ().setMsgData(new LinkedList());
            this.gWN.CM();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void a(aq aqVar) {
        if (this.gWN != null) {
            bYg();
            this.gWN.LK().setEditText(" @" + aqVar.getNameShow() + " ");
        }
        if (this.gWy != null) {
            this.gWy.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void g(com.baidu.live.data.a aVar) {
        if (this.gWN != null) {
            bYg();
            this.gWN.LK().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.gWy != null) {
            this.gWy.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void b(aq aqVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected View bXH() {
        if (this.gWN != null) {
            return this.gWN.LK().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean bXI() {
        if (this.gWN == null || !this.gWN.LK().Ne()) {
            return false;
        }
        mL(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected boolean bXJ() {
        return this.gVJ == null || this.gVJ.bXJ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    /* renamed from: bZf */
    public PendantParentView bXK() {
        return this.brz;
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
                    this.gXz = false;
                    M(intExtra, intExtra2, intExtra3);
                    return;
                }
                bXB();
                return;
            }
            avS();
        } else if (i == 25051 && i2 == -1 && this.gXK != null) {
            this.gXK.cbZ();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.gWN != null && this.gWN.LJ() != null) {
            this.gWN.LJ().onKeyboardVisibilityChanged(z);
        }
        if (z || this.gWN == null || this.gWN.LK() == null || !this.gWN.LK().Ne()) {
            if (z) {
                if (this.gWy != null) {
                    this.gWy.setVisibility(8);
                }
                if (this.gWP != null && this.gWP.GH() != null) {
                    this.gWP.GH().setVisibility(8);
                }
                bXM();
                if (this.gWN != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gWN.LK().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.gWN.LK().getView().setLayoutParams(layoutParams);
                    this.gWN.LK().getView().setVisibility(0);
                    this.gWN.LK().setQuickInputPanelVisible(false);
                }
                if (this.gXu != null) {
                    this.gXu.setVisibility(8);
                }
                if (this.gVO != null) {
                    this.gVO.setVisible(8);
                }
                if (this.gWO != null) {
                    this.gWO.CL();
                }
                if (this.gXo != null) {
                    this.gXo.setCanVisible(false);
                }
                if (this.gXh != null) {
                    this.gXh.setCanVisible(false);
                }
                if (this.gXi != null) {
                    this.gXi.setCanVisible(false);
                }
                if (this.gXj != null) {
                    this.gXj.setCanVisible(false);
                }
                if (this.gXk != null) {
                    this.gXk.setVisible(8);
                }
            } else {
                bXL();
            }
            bYZ();
            if (this.gXa != null) {
                this.gXa.bs(z);
            }
        }
    }

    private void bXL() {
        if (this.gWy != null) {
            this.gWy.setVisibility(0);
        }
        if (this.gVW != null) {
            if (this.gYz) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gVW.getLayoutParams();
                layoutParams.bottomMargin = (M(false, false) - bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) + com.baidu.live.ag.b.UB();
                this.gVW.setLayoutParams(layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gVW.getLayoutParams();
                layoutParams2.bottomMargin = bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds90);
                this.gVW.setLayoutParams(layoutParams2);
            }
        }
        if (this.gWN != null) {
            bYh();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gWN.LK().getView().getLayoutParams();
            layoutParams3.bottomMargin = 0;
            this.gWN.LK().getView().setLayoutParams(layoutParams3);
        }
        if (this.gWy != null) {
            this.gWy.setVisibility(0);
        }
        if (this.gWP != null && this.gWP.GH() != null) {
            this.gWP.GH().setVisibility(0);
        }
        if (this.gXu != null) {
            this.gXu.setVisibility(0);
        }
        if (this.gVO != null) {
            this.gVO.setVisible(0);
        }
        if (this.gWO != null) {
            this.gWO.CL();
        }
        if (this.gXo != null) {
            this.gXo.setCanVisible(true);
        }
        if (this.gXh != null) {
            this.gXh.setCanVisible(true);
        }
        if (this.gXj != null) {
            this.gXj.setCanVisible(true);
        }
        if (this.gXk != null) {
            this.gXk.setVisible(0);
        }
        if (this.gXi != null) {
            this.gXi.setCanVisible(!this.gYv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXM() {
        boolean z;
        boolean z2 = false;
        if (this.gVW != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gVW.getLayoutParams();
            if (this.gWN == null || this.gWN.LK() == null) {
                z = false;
            } else {
                z = this.gWN.LK().Nc();
                z2 = this.gWN.LK().Nd();
            }
            int M = M(z, z2);
            if (layoutParams.bottomMargin != M) {
                layoutParams.bottomMargin = M;
                this.gVW.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mL(boolean z) {
        this.gYy = z;
        if (z) {
            this.gWN.LK().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gVW.getLayoutParams();
            int quickInputPanelExpandHeight = this.gWN.LK().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.gVW.setLayoutParams(layoutParams);
                if (this.gWN.LJ() != null) {
                    this.gWN.LJ().LI();
                    return;
                }
                return;
            }
            return;
        }
        bXL();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.gVI != null) {
                this.gVI.dI(i3);
            }
            if (this.gVK != null) {
                this.gVK.dI(i3);
            }
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public boolean eO(int i) {
        boolean eO = super.eO(i);
        if (eO && 2 == i) {
            if (this.gVJ.bXJ()) {
                return false;
            }
            if (eO && this.gWI != null) {
                this.gWI.nR(false);
            }
        }
        return eO;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void vv(int i) {
        super.vv(i);
        if (i == 7 || i == 11) {
            if (this.gWy != null) {
                this.gWy.setVisibility(8);
            }
            if (this.gWN != null) {
                this.gWN.LJ().getView().setVisibility(4);
            }
            if (this.gVO != null) {
                this.gVO.bM(2, 8);
                if (this.gYv) {
                    this.gVO.bM(1, 8);
                }
            }
            if (this.gXd != null) {
                this.gXd.nL(false);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public void eP(int i) {
        super.eP(i);
        if (i == 7 || i == 11) {
            if (this.gWy != null) {
                this.gWy.setVisibility(0);
            }
            if (this.gWN != null) {
                this.gWN.LJ().getView().setVisibility(0);
            }
            if (this.gVO != null) {
                this.gVO.setVisible(0);
            }
            if (this.gXd != null) {
                this.gXd.nL(true);
            }
            this.gXu.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.gVL != null) {
            this.gVL.chc();
        }
        if (this.gVQ != null) {
            this.gVQ.Dv();
        }
        if (this.gVO != null) {
            this.gVO.onStop();
        }
        if (this.gVP != null) {
            this.gVP.bh(true);
        }
        if (this.gXt != null) {
            this.gXt.onStopped();
        }
        if (this.gXs != null) {
            this.gXs.onStop();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.gVL != null) {
            this.gVL.chb();
        }
        if (this.gVQ != null && this.gYw) {
            this.gVQ.Dw();
        }
        if (this.gVO != null) {
            this.gVO.onStart();
        }
        if (this.gVP != null) {
            this.gVP.bh(false);
        }
        if (this.gXt != null) {
            this.gXt.onStarted();
        }
        if (this.gXs != null) {
            this.gXs.onStart();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        if (!onKeyDown && i == 4 && this.gXt != null && this.gXt.onKeyDown(i, keyEvent)) {
            return true;
        }
        return onKeyDown;
    }
}
