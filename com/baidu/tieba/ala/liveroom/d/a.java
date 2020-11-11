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
import com.baidu.live.data.aq;
import com.baidu.live.data.bn;
import com.baidu.live.data.cd;
import com.baidu.live.data.cj;
import com.baidu.live.data.p;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.gift.af;
import com.baidu.live.gift.aj;
import com.baidu.live.gift.m;
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
    private com.baidu.live.im.b.a gVT;
    private com.baidu.tieba.ala.liveroom.share.b gVU;
    private com.baidu.live.z.a gVV;
    private FrameLayout gVW;
    private FrameLayout gVX;
    private ImageView gVY;
    private com.baidu.live.tieba.e.b gVZ;
    private af gWe;
    private com.baidu.tieba.ala.liveroom.j.b gWf;
    private long lastClickTime = 0;
    private boolean gWa = false;
    private boolean gWb = false;
    private boolean gWc = false;
    private Handler gWd = new Handler();
    private HttpRule gWg = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.gVQ != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.gVQ.DB()) {
                httpMessage.addParam("ala_challenge_id", a.this.gVQ.DE());
            }
            return httpMessage;
        }
    };
    private HttpRule gWh = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.a.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.gVQ != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.gVQ.DB()) {
                httpMessage.addParam("challenge_id", a.this.gVQ.DE());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c gWi = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.19
        @Override // com.baidu.live.liveroom.g.c
        public void Ob() {
            if (a.this.gWI != null) {
                a.this.gWI.nR(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void ck(boolean z) {
            if (z) {
                if (a.this.gWI != null) {
                    a.this.gWI.nR(true);
                }
            } else if (a.this.gWI != null) {
                a.this.gWI.nR(false);
            }
            if (a.this.gXa != null) {
                a.this.gXa.bt(z);
            }
            if (a.this.gVO != null) {
                a.this.gVO.mI(z ? false : true);
            }
            com.baidu.live.n.a.cl(z);
        }
    };
    private com.baidu.tieba.ala.liveroom.p.c gWj = new com.baidu.tieba.ala.liveroom.p.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.20
        @Override // com.baidu.tieba.ala.liveroom.p.c
        public void onClick() {
            a.this.gWd.removeCallbacksAndMessages(null);
            a.this.gWa = true;
        }

        @Override // com.baidu.tieba.ala.liveroom.p.c
        public void endAnimation() {
            if (a.this.gWa) {
                a.this.bXd();
            }
        }
    };
    private HttpMessageListener gWk = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Ok() != null) {
                        com.baidu.live.aa.e.Qe().bue = getQuickGiftHttpResponseMessage.Ok();
                        a.this.bXs();
                    }
                }
            }
        }
    };
    private CustomMessageListener gWl = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                a.this.gWQ.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gWm = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.gXe != null) {
                    a.this.gXe.hT(str);
                }
            }
        }
    };
    CustomMessageListener gWn = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.gXB != null && a.this.gXB.bgz != null && !a.this.gXB.bgC && !a.this.gXB.bgD && a.this.gWZ != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.bYK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                layoutParams.bottomMargin = a.this.bYK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                a.this.gWZ.c(a.this.gVW, layoutParams);
                if (com.baidu.live.guardclub.e.KE() != null) {
                    com.baidu.live.guardclub.e.KE().KK();
                }
            }
        }
    };
    private CustomMessageListener gWo = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (a.this.gXb != null) {
                    a.this.gXb.dismiss();
                }
                if (a.this.gXe != null) {
                    a.this.gXe.dismiss();
                }
                if (a.this.gXc != null) {
                    a.this.gXc.dismiss();
                }
                if (a.this.gKY != null) {
                    a.this.gKY.dismiss();
                }
                com.baidu.live.im.b.d.Mg().setSwitchStatus(true);
                com.baidu.live.im.b.d.Mg().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bYg();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener gWp = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.gWf.c(a.this.bYK());
                } else if (a.this.bXZ() || !g.vI(2913168)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.bYK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.bYK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    a.this.gWf.c(a.this.gVW, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gWq = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.a.13
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
            if (currentTimeMillis - a.this.lastClickTime >= 300) {
                a.this.lastClickTime = currentTimeMillis;
                if (i == 2 && a.this.JM()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel"));
                    a.this.M(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.aa.e.Qe().bue.GQ().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.aa.e.Qe().bue.GQ().FT());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.aa.e.Qe().bue.GQ().FU());
                        if (a.this.bYK().hgD.Hi() != null && a.this.bYK().hgD.Hi().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.bYK().hgD.Hi().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.bYK().hgD.Hi().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.MD());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.JM()) {
                        if (com.baidu.live.d.AZ().getBoolean("quick_gift_guide_show", true) && !a.this.bXZ()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, af.class, a.this.bYK().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                af afVar = (af) runTask.getData();
                                afVar.setPageContext(a.this.bYK().pageContext);
                                afVar.setLiveShowData(a.this.bYK().hgD.Hi());
                                afVar.setGiftItem(com.baidu.live.aa.e.Qe().bue.GQ());
                                afVar.setOtherParams(a.this.MD());
                                afVar.initView();
                                afVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.13.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        a.this.mN(false);
                                        a.this.gWe = null;
                                    }
                                });
                                a.this.gWe = afVar;
                                afVar.show();
                                a.this.mN(true);
                                return;
                            }
                            return;
                        }
                        m.a(a.this.bYK().pageContext, a.this.bYK().hgD.Hi(), com.baidu.live.aa.e.Qe().bue.GQ(), a.this.MD());
                    }
                } else if (i == 1) {
                    if (a.this.gWN != null) {
                        a.this.bYg();
                    }
                } else if (i == 3 && a.this.JM()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    if (a.this.mOrientation == 2 && (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                        if (a.this.gVU != null) {
                            a.this.gVU.M(a.this.bYK().hgD.Hi());
                        }
                    } else {
                        a.this.gWA.c(a.this.bYK().hgD.Hi(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.bYK() != null && a.this.bYK().hgD != null && a.this.bYK().hgD.Hi() != null && a.this.bYK().hgD.Hi().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.bYK().hgD.Hi().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.bYK().hgD.Hi().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.bYK().hgD.Hi().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.MD());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.bYK() != null && a.this.bYK().hgD != null && a.this.bYK().hgD.Hi() != null && a.this.bYK().hgD.Hi().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.bYK().hgD.Hi().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.bYK().hgD.Hi().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.bYK().hgD.Hi().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.MD());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.bnG != null) {
                        a.this.bnG.ce(false);
                    }
                } else if (i == 12) {
                    if (a.this.gWI != null) {
                        String valueOf = String.valueOf(a.this.bYK().hgD.Hi().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.bYK().hgD.Hi().mLiveInfo.room_id);
                        String str3 = null;
                        AlaLiveSdkInfo alaLiveSdkInfo = a.this.bYK().hgD.Hi().mLiveSdkInfo;
                        if (alaLiveSdkInfo != null && alaLiveSdkInfo.mCastIds != null) {
                            str3 = String.valueOf(a.this.bYK().hgD.Hi().mLiveSdkInfo.mCastIds.chatMCastId);
                        }
                        a.this.gWI.as(valueOf, valueOf2, str3);
                        com.baidu.live.n.a.b(a.this.bYK().hgD.Hi().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    w Hi = a.this.bYK().hgD.Hi();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.bYK().pageContext.getPageActivity(), Hi.aIV.userName, Long.toString(Hi.aIV.userId), Long.toString(Hi.aIV.charmCount), String.valueOf(Hi.mLiveInfo.group_id), String.valueOf(Hi.mLiveInfo.live_id), false, String.valueOf(Hi.aIV.userId), Long.toString(Hi.aJr.userId), Hi.aJr.userName, Hi.aJr.portrait, a.this.gVM.getCount(), a.this.MD())));
                    LogManager.getCommonLogger().doClickGusetNumLog(Hi.mLiveInfo.feed_id, a.this.gVM.getCount() + "", a.this.MD());
                } else if (i == 11) {
                    a.this.bYj();
                    a.this.bYk();
                } else if (i == 16) {
                    if (a.this.bYK() != null && (bnVar2 = com.baidu.live.aa.a.PQ().btT) != null && (cdVar2 = bnVar2.aPx) != null) {
                        String str4 = cdVar2.aQS.aQZ;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (a.this.bYK().hgD != null && a.this.bYK().hgD.Hi() != null && a.this.bYK().hgD.Hi().mLiveInfo != null) {
                                j = a.this.bYK().hgD.Hi().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", a.this.bYK().hgD.Hi().mLiveInfo.room_id + "", a.this.bYK().hgD.Hi().mLiveInfo.feed_id, a.this.MD());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.bYK().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (a.this.bYK() != null) {
                        w wVar = null;
                        if (a.this.bYK().hgD != null) {
                            wVar = a.this.bYK().hgD.Hi();
                        }
                        if (wVar != null && wVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.w.b.chn().bom != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.w.b.chn().bom.aIk;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(a.this.bYK().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17) {
                    if (a.this.JM() && a.this.bYK() != null && (bnVar = com.baidu.live.aa.a.PQ().btT) != null && (cdVar = bnVar.aPx) != null && (cjVar = cdVar.aQT) != null && !TextUtils.isEmpty(cjVar.webUrl)) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                        if (a.this.gXb != null && a.this.bYK().hgD != null && a.this.bYK().hgD.Hi() != null) {
                            w Hi2 = a.this.bYK().hgD.Hi();
                            a.this.gXb.a(cjVar.webUrl, Hi2.mLiveInfo.live_id, Hi2.aJr.userId, Hi2.aIV.userId);
                            a.this.gVZ.cK(false);
                            a.this.gVZ.Ts();
                        }
                    }
                } else if (i == 18) {
                    if (a.this.gWc) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.gWc = !a.this.gWc;
                } else if (i == 19 && a.this.gVZ != null) {
                    a.this.gVZ.Ts();
                }
            }
        }
    };

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
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXd() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.21
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gWb) {
                    a.this.mJ(false);
                }
            }
        }, 5000L);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(w wVar) {
        super.l(wVar);
        g.cce();
        this.gWc = false;
        if (this.gWF != null) {
            this.gWF.b(this.gWq);
        }
        if (this.gVZ == null) {
            this.gVZ = new com.baidu.live.tieba.e.b(bYK().pageContext.getPageActivity());
            this.gVZ.start();
        }
        this.gVZ.cK(true);
        bYK().pageContext.getPageActivity().setRequestedOrientation(-1);
        bYK().hgE.setIsForceHandledTouch(false);
        bYK().hgE.setSwipeClearEnable(true);
        bYK().hgE.setOnLiveViewScrollListener(this.gWi);
        bYK().hgE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gWd.removeCallbacksAndMessages(null);
                a.this.gWa = false;
                a.this.mJ(false);
                if (!a.this.gWb) {
                    a.this.bXd();
                }
            }
        });
        if (this.gXu != null) {
            this.gXu.setVisibility(0);
        }
        bXk();
        if (this.gWX != null) {
            this.gWX.a(wVar, this.brz);
            this.gWX.U(this.gXv);
            this.gWX.a(this);
        }
        bXv();
        bXU();
        bXw();
        bXi();
        bXA();
        bXx();
        bXe();
        mO(false);
        bYm();
        bXC();
        bYs();
        bYy();
        bYn();
        bYr();
        bXt();
        bXu();
        bYo();
        bXg();
        bXD();
        mP(true);
        bXm();
        bXs();
        bYC();
        bXn();
        bXo();
        bXp();
        bXq();
        bXj();
        bXE();
        bXf();
        bYB();
        bYx();
        if (this.gXb != null && this.gXb.chu() == null) {
            this.gXb.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.23
                @Override // com.baidu.tieba.ala.liveroom.turntable.d.a
                public void onDismiss() {
                    a.this.gVZ.cK(true);
                }
            });
        }
        if (this.gXc != null && this.gXc.ccj() == null) {
            this.gXc.a(new a.InterfaceC0679a() { // from class: com.baidu.tieba.ala.liveroom.d.a.24
                @Override // com.baidu.tieba.ala.liveroom.m.a.InterfaceC0679a
                public void onDismiss() {
                    a.this.gVZ.cK(true);
                }
            });
        }
        c(this.gaY);
        MessageManager.getInstance().registerListener(this.gWk);
        MessageManager.getInstance().registerListener(this.gWn);
        MessageManager.getInstance().registerListener(this.gWo);
        MessageManager.getInstance().registerListener(this.gWp);
        MessageManager.getInstance().registerListener(this.gWm);
        MessageManager.getInstance().registerListener(this.gWl);
        bXF();
        bXz();
        if (this.mOrientation == 2) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(bYK().pageContext.getPageActivity());
            l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(bYK().pageContext.getPageActivity()));
        }
        if (this.gXm != null) {
            this.gXm.F(wVar);
        }
    }

    private void bXe() {
        if (this.gXm == null) {
            View view = null;
            if (this.gWF != null && this.gWF.getView() != null) {
                view = this.gWF.getView();
            }
            this.gXm = new com.baidu.tieba.ala.liveroom.exclusive.b(bYK().pageContext, NX(), bYK().hgE, view, this.gVI.gYQ, this);
        }
    }

    private void bXf() {
        if (this.gXl != null) {
            this.gXl.a(new com.baidu.live.v.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.25
                @Override // com.baidu.live.v.c
                public void cr(boolean z) {
                    if (a.this.gVR != null) {
                        a.this.gVR.setNeedCloseRecommendFloat(z);
                    }
                    if (a.this.bYK().hgE.hwh) {
                        if (a.this.gWI != null) {
                            a.this.gWI.nJ(z);
                            a.this.gWI.nR(!z);
                        }
                        if (a.this.gWF != null) {
                            a.this.gWF.nJ(z);
                            a.this.gWF.setPraiseEnable(!z);
                            a.this.gWF.nI(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mJ(boolean z) {
        View Hh;
        if (bYK() != null && bYK().pageContext != null && bYK().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(bYK().pageContext.getPageActivity()) == 2 || z) {
                if (this.gWQ != null && (Hh = this.gWQ.Hh()) != null) {
                    if (this.gWb) {
                        Hh.setVisibility(0);
                    } else {
                        Hh.setVisibility(8);
                    }
                }
                if (this.gWb) {
                    if (this.gXu != null) {
                        this.gXu.setVisibility(0);
                    }
                    if (this.gXv != null) {
                        this.gXv.setVisibility(0);
                    }
                    if (this.brz != null) {
                        this.brz.setVisibility(0);
                    }
                    if (this.brz != null) {
                        this.brz.setVisibility(0);
                    }
                    if (this.gWP != null) {
                        this.gWP.br(false);
                    }
                } else {
                    if (this.gXu != null) {
                        this.gXu.setVisibility(8);
                    }
                    if (this.gXv != null) {
                        this.gXv.setVisibility(8);
                    }
                    if (this.brz != null) {
                        this.brz.setVisibility(8);
                    }
                    if (this.brz != null) {
                        this.brz.setVisibility(8);
                    }
                    if (this.gWP != null) {
                        this.gWP.br(true);
                    }
                }
                this.gWb = this.gWb ? false : true;
                if (this.gVO != null) {
                    this.gVO.mI(this.gWb);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, boolean z2) {
        ImageView imageView;
        View GH;
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view;
        }
        if (z) {
            if (imageView != null) {
                imageView.setImageResource(a.e.icon_live_barrage_off);
            }
            if (this.gVX != null) {
                this.gVX.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.e.icon_live_barrage_on);
            }
            if (this.gVX != null) {
                this.gVX.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.gWP != null && (GH = this.gWP.GH()) != null) {
            if (z) {
                GH.setVisibility(8);
            } else {
                GH.setVisibility(0);
            }
        }
    }

    private void bXg() {
        CustomResponsedMessage runTask;
        if (this.gVT == null && (runTask = MessageManager.getInstance().runTask(2913164, com.baidu.live.im.b.a.class, bYK().pageContext)) != null) {
            this.gVT = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gVT != null) {
            this.gVT.setOtherParams(this.otherParams);
            this.gVT.a(new a.InterfaceC0188a() { // from class: com.baidu.tieba.ala.liveroom.d.a.2
                @Override // com.baidu.live.im.b.a.InterfaceC0188a
                public void Mf() {
                    a.this.bYv();
                }
            });
        }
    }

    private void bXh() {
        if (this.gWH != null) {
            this.gWH.aB(bYK().hgC.getLiveContainerView());
        }
    }

    private void bXi() {
        if (this.gVU == null) {
            this.gVU = new com.baidu.tieba.ala.liveroom.share.b(bYK().pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void bXj() {
        if (bYK() != null) {
            if (this.gVV == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.z.a.class, bYK().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gVV = (com.baidu.live.z.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.gVV.setIsHost(false);
            this.gVV.a(this.brz, bYK().hgD.Hi().aJT);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void dM(int i) {
        super.dM(i);
        if (this.gVY != null && UtilHelper.getRealScreenOrientation(bYK().pageContext.getPageActivity()) != 2) {
            this.gVY.setVisibility(0);
        }
        bXh();
        if (this.gVR != null) {
            this.gVR.dM(i);
        }
        if (this.gVR == null || !this.gVR.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
        if (this.gXm != null) {
            this.gXm.cbC();
        }
    }

    private void bXk() {
        if (this.brz == null) {
            PendantParentView.Model model = PendantParentView.Model.HORIZONTAL;
            if (this.mOrientation == 2) {
                model = PendantParentView.Model.HORIZONTAL_FULL;
            }
            this.brz = new PendantParentView(bYK().pageContext.getPageActivity(), model);
            bYK().hgE.addView(this.brz, ((bYK().hgE.getView() == null || this.gWF == null || this.gWF.getView() == null) ? -1 : bYK().hgE.getView().indexOfChild(this.gWF.getView())) + 1, new RelativeLayout.LayoutParams(-1, bXl()));
            this.brz.setDefaultItemMargin(bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            K(this.mOrientation, false);
        }
    }

    private int bXl() {
        int bottom;
        int bottom2;
        if (bYK().bnJ.getLivePlayer().getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bYK().bnJ.getLivePlayer().getLayoutParams();
            bottom = layoutParams.topMargin + layoutParams.height;
        } else {
            bottom = bYK().bnJ.getLivePlayer().getBottom();
        }
        if (bYK().hgE.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) bYK().hgE.getLayoutParams();
            bottom2 = layoutParams2.topMargin + layoutParams2.height;
        } else {
            bottom2 = bYK().hgE.getBottom();
        }
        int i = 0;
        if (this.gXm != null) {
            i = this.gXm.getHeight();
        }
        return (((bottom2 - bottom) - i) - bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
    }

    private void bXm() {
        if (this.gVO == null) {
            this.gVO = new com.baidu.tieba.ala.liveroom.activeview.b(bYK().pageContext);
        }
        if (bYK() != null && bYK().hgD != null) {
            this.gVO.HL(bYK().hgD.cgB());
        }
        this.gVO.setOtherParams(MD());
        this.gVO.b(bYK().hgD.Hi(), true);
        this.gVO.setHost(false);
        this.gVO.a(1, this.brz);
        this.gVO.a(2, this.brz);
        this.gVO.setVisible(this.gXy ? 8 : 0);
    }

    private void bXn() {
        if (this.brz != null) {
            if (this.gVN == null) {
                this.gVN = new com.baidu.tieba.ala.liveroom.l.a(bYK().pageContext, this);
            }
            this.gVN.setOtherParams(MD());
            this.gVN.a((ViewGroup) this.brz, bXr());
            this.gVN.G(bYK().hgD.Hi());
        }
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
            this.gWy.a(new a.InterfaceC0682a() { // from class: com.baidu.tieba.ala.liveroom.d.a.9
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0682a
                public void bO(int i, int i2) {
                    w Hi = a.this.bYK().hgD.Hi();
                    if (Hi != null && Hi.mLiveInfo != null) {
                        if (a.this.gXd == null) {
                            a.this.gXd = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.bYK().pageContext.getPageActivity());
                        }
                        a.this.gXd.d(a.this.gXv, i, i2);
                        a.this.gXd.a(String.valueOf(Hi.mLiveInfo.live_id), new a.InterfaceC0686a() { // from class: com.baidu.tieba.ala.liveroom.d.a.9.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0686a
                            public void a(float f, String str) {
                                if (a.this.gWy != null) {
                                    a.this.gWy.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0682a
                public void bP(int i, int i2) {
                    if (a.this.gXd != null) {
                        a.this.gXd.bU(i, i2);
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
            this.gWf = new com.baidu.tieba.ala.liveroom.j.b(bYK().pageContext, MD(), this.gXK, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.10
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bXN() {
                    a.this.mN(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bXO() {
                    a.this.mN(false);
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
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = bYK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXs() {
        if (this.gWy == null) {
            bXx();
        }
        this.gWy.a(com.baidu.live.aa.e.Qe().bue, bYK().hgD.Hi());
    }

    private void bXt() {
        CustomResponsedMessage runTask;
        boolean z = true;
        if (this.gWN == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, bYK().pageContext)) != null && runTask.getData() != null) {
            this.gWN = (k) runTask.getData();
            this.gWN.setFromMaster(false);
            this.gWN.LJ().getView().setId(a.f.ala_liveroom_msg_list);
            this.gWN.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.11
                @Override // com.baidu.live.im.k.a
                public boolean LM() {
                    return a.this.JM();
                }

                @Override // com.baidu.live.im.k.a
                public void LN() {
                    a.this.gXC = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hJ(String str) {
                    if (!a.this.gXy) {
                        a.this.mL(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.bYK().pageContext.getPageActivity(), a.this.bYK().hgC.getLiveContainerView());
                    }
                    a.this.HR(str);
                }

                @Override // com.baidu.live.im.k.a
                public void LO() {
                    if (a.this.gXy) {
                        a.this.mL(true);
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.bYK().pageContext.getPageActivity(), a.this.bYK().hgC.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (a.this.gWN != null) {
                        a.this.gWN.LK().setQuickInputPanelVisible(false);
                        a.this.gWN.LK().Nf();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void LP() {
                    if (a.this.gXy) {
                        a.this.bXM();
                        if (a.this.gWO != null) {
                            a.this.gWO.CL();
                        }
                        if (a.this.gVT != null) {
                            a.this.gVT.CL();
                        }
                    } else if (a.this.gWN != null) {
                        a.this.gWN.LK().setQuickInputPanelVisible(false);
                        a.this.gWN.LK().Nf();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean LQ() {
                    return a.this.bYa();
                }

                @Override // com.baidu.live.im.k.a
                public int LR() {
                    return a.this.bYb();
                }
            });
            this.gVW = new FrameLayout(bYK().pageContext.getPageActivity());
            this.gVW.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.gWN != null && this.gVW != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bYK().pageContext.getPageActivity()) * 0.7f);
            int i = com.baidu.live.ag.b.i(true, false);
            if (this.gXv.indexOfChild(this.gVW) < 0) {
                if (this.gVW.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gVW.getParent()).removeView(this.gVW);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
                this.gXv.addView(this.gVW, layoutParams);
            }
            if (this.gVW.indexOfChild(this.gWN.LJ().getView()) < 0) {
                if (this.gWN.LJ().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gWN.LJ().getView()).removeView(this.gWN.LJ().getView());
                }
                if (UtilHelper.getRealScreenOrientation(bYK().pageContext.getPageActivity()) != 2) {
                    this.gVW.addView(this.gWN.LJ().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, i));
                }
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
            if (Hi == null || Hi.aJH == null || !Hi.aJH.Ea()) {
                z = false;
            }
            this.gWN.a(String.valueOf(bYK().hgD.Hi().mLiveInfo.group_id), String.valueOf(bYK().hgD.Hi().mLiveInfo.last_msg_id), String.valueOf(bYK().hgD.Hi().aIV.userId), String.valueOf(bYK().hgD.Hi().mLiveInfo.live_id), bYK().hgD.Hi().aIV.appId, z);
            mL(false);
        }
    }

    private void bXu() {
        if (this.gVX == null) {
            this.gVX = new FrameLayout(bYK().pageContext.getPageActivity());
            this.gVX.setId(a.f.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void bXv() {
        if (this.gVJ == null) {
            this.gVJ = new com.baidu.tieba.ala.liveroom.p.a(bYK().pageContext, false, this);
        }
        this.gVJ.d(this.gXu, bYK().hgD.Hi());
        this.gVJ.a(this.gWj);
        this.gVJ.a(this.gWq);
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

    private void bXD() {
        boolean z = false;
        if (this.gWI == null) {
            this.gWI = new com.baidu.tieba.ala.liveroom.x.a(bYK().pageContext, this);
        }
        this.gWI.d(bYK().hgE, false);
        boolean bYJ = bYJ();
        AlaLiveInfoData alaLiveInfoData = bYK().hgD.Hi().mLiveInfo;
        boolean isZanAnimUnabled = (alaLiveInfoData == null || alaLiveInfoData.mAlaLiveSwitchData == null) ? false : alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled();
        if (bYJ && !isZanAnimUnabled) {
            z = true;
        }
        this.gWI.nQ(z);
    }

    private void bXE() {
        if (bYK() != null && bYK().bnJ != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(bYK().pageContext.getPageActivity());
            Activity pageActivity = bYK().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + o.aI(pageActivity)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.gVY = new ImageView(bYK().pageContext.getPageActivity());
            this.gVY.setVisibility(8);
            this.gVY.setBackgroundResource(a.e.sdk_round_btn_close_bg);
            this.gVY.setImageResource(a.e.icon_live_enlarge);
            this.gVY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.gVZ != null) {
                        a.this.gVZ.Tr();
                        a.this.gVY.setVisibility(4);
                    }
                }
            });
            bYK().hgE.addView(this.gVY, layoutParams);
            if (UtilHelper.getRealScreenOrientation(bYK().pageContext.getPageActivity()) != 2) {
                if (bYK().hgK) {
                    this.gVY.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.15
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.gVY != null && UtilHelper.getRealScreenOrientation(a.this.bYK().pageContext.getPageActivity()) != 2) {
                                a.this.gVY.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
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
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.16
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bYg();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void t(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
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
            e.printStackTrace();
            jSONObject = null;
        }
        if (this.gVV == null || !this.gVV.R(jSONObject)) {
            if ((aVar.getMsgType() == 12 || aVar.getMsgType() == 13) && jSONObject != null) {
                String optString = jSONObject.optString("content_type");
                if ("task".equals(optString)) {
                    if (this.gVN != null) {
                        this.gVN.O(jSONObject);
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
                    long optLong = jSONObject.optLong("mvp_user_id");
                    long optLong2 = jSONObject.optLong("winner_live_id");
                    if (optLong == bYK().hgD.Hi().aJr.userId && optLong2 == bYK().hgD.Hi().mLiveInfo.live_id) {
                        this.gVR.c(jSONObject.optInt("challenge_status"), jSONObject.optLong("challenge_id"));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void HN(String str) {
        if (this.gVO != null) {
            this.gVO.HN(str);
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
        if (this.gVT != null) {
            this.gVT.a(wVar);
        }
        if (this.gVO != null) {
            this.gVO.i(wVar);
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
        if (this.gVV != null) {
            this.gVV.KJ();
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
        if (this.gVQ != null) {
            this.gVQ.Dm();
        }
        if (this.gVT != null) {
            this.gVT.a((a.InterfaceC0188a) null);
            this.gVT.CM();
        }
        if (this.gVJ != null) {
            this.gVJ.cdh();
        }
        if (this.gVY != null && (this.gVY.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gVY.getParent()).removeView(this.gVY);
        }
        if (this.gVU != null) {
            this.gVU.dismiss();
        }
        if (this.gVZ != null) {
            this.gVZ.cK(false);
            this.gVZ.Ts();
        }
        if (this.gWf != null) {
            this.gWf.Dm();
        }
        if (this.gXK != null) {
            this.gXK.bZX();
        }
        if (this.gXp != null) {
            this.gXp.Dm();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void m(w wVar) {
        View CK;
        super.m(wVar);
        if (this.gVT != null && (CK = this.gVT.CK()) != null && CK.getParent() != null) {
            ((ViewGroup) CK.getParent()).removeView(CK);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.gVT != null) {
            this.gVT.setOtherParams(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void ch(boolean z) {
        super.ch(z);
        this.gWd.removeCallbacksAndMessages(null);
        bXG();
        this.gWb = false;
        this.gWc = false;
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
        if (this.gVU != null) {
            this.gVU.onDestroy();
        }
        if (this.gVK != null) {
            this.gVK.onDestroy();
        }
        if (this.gVZ != null) {
            this.gVZ.stop();
        }
        if (this.gWI != null) {
            this.gWI.onDestroy();
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
        if (this.gVT != null) {
            this.gVT.a((a.InterfaceC0188a) null);
            this.gVT.release();
            this.gVT = null;
        }
        if (this.gXK != null) {
            this.gXK.ch(z ? false : true);
        }
        if (this.gWf != null) {
            this.gWf.onDestroy();
            this.gWf = null;
        }
        if (this.gXp != null) {
            this.gXp.onDestroy();
        }
        if (this.gVV != null) {
            this.gVV.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.gWg);
        MessageManager.getInstance().removeMessageRule(this.gWh);
        MessageManager.getInstance().unRegisterListener(this.gWk);
        MessageManager.getInstance().unRegisterListener(this.gWn);
        MessageManager.getInstance().unRegisterListener(this.gWo);
        MessageManager.getInstance().unRegisterListener(this.gWp);
        MessageManager.getInstance().unRegisterListener(this.gWm);
        MessageManager.getInstance().unRegisterListener(this.gWl);
    }

    private void bXG() {
        if (this.gWN != null && this.gWN.LJ().getView() != null && this.gWN.LJ().getView().getParent() != null) {
            ((ViewGroup) this.gWN.LJ().getView().getParent()).removeView(this.gWN.LJ().getView());
        }
        if (this.gVW != null && this.gVW.getParent() != null) {
            ((ViewGroup) this.gVW.getParent()).removeView(this.gVW);
        }
        if (this.gVX != null && this.gVX.getParent() != null) {
            ((ViewGroup) this.gVX.getParent()).removeView(this.gVX);
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

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected ViewGroup bXK() {
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
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.gXy;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(bYK().pageContext.getPageActivity()) || z2) {
            mK(z);
        }
    }

    private void mK(boolean z) {
        if (this.gWN != null && this.gWN.LJ() != null) {
            this.gWN.LJ().onKeyboardVisibilityChanged(z);
        }
        if (z || this.gWN == null || !this.gWN.LK().Ne()) {
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
                if (this.gXj != null) {
                    this.gXj.setCanVisible(false);
                }
                if (this.gXk != null) {
                    this.gXk.setVisible(8);
                }
            } else {
                bXL();
            }
            if (this.gWN != null && this.gVW != null) {
                if (this.gXv.indexOfChild(this.gVW) != -1 && this.gVW.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gVW.getLayoutParams();
                    layoutParams2.height = com.baidu.live.ag.b.i(true, z);
                    this.gVW.setLayoutParams(layoutParams2);
                }
                if (this.gVW.indexOfChild(this.gWN.LJ().getView()) != -1 && this.gWN.LJ().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.gWN.LJ().getView().getLayoutParams();
                    layoutParams3.height = com.baidu.live.ag.b.i(true, z);
                    this.gWN.LJ().getView().setLayoutParams(layoutParams3);
                }
                this.gWN.LJ().LI();
            }
        }
    }

    private void bXL() {
        if (this.gWy != null) {
            this.gWy.setVisibility(0);
        }
        if (this.gVW != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gVW.getLayoutParams();
            layoutParams.bottomMargin = bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            this.gVW.setLayoutParams(layoutParams);
        }
        if (this.gWN != null) {
            bYh();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gWN.LK().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.gWN.LK().getView().setLayoutParams(layoutParams2);
        }
        if (this.gWy != null) {
            this.gWy.setVisibility(0);
        }
        if (this.gWP != null && this.gWP.GH() != null) {
            this.gWP.GH().setVisibility(0);
        }
        if (this.gXu != null && (!this.gWb || UtilHelper.getRealScreenOrientation(bYK().pageContext.getPageActivity()) != 2)) {
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
        FrameLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        FrameLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = bYK().pageContext.getPageActivity();
        if (i3 == 1) {
            if (bYK().pageContext.getPageActivity() != null && !UtilHelper.canUseStyleImmersiveSticky()) {
                com.baidu.live.utils.q.e(bYK().pageContext.getPageActivity(), true);
            }
            if (this.gXu != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.gXu.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.gVU != null) {
                this.gVU.dismiss();
            }
            if (this.gVT != null) {
                this.gVT.a((a.InterfaceC0188a) null);
                this.gVT.CM();
            }
            if (this.bnG != null) {
                this.bnG.e(true, true);
            }
            if (this.gVY != null) {
                this.gVY.setVisibility(0);
                this.gVY.bringToFront();
            }
            if (this.gWD != null) {
                this.gWD.setVisibility(0);
            }
            if (this.gWN != null && this.gWN.LJ().getView().getParent() != null && (this.gWN.LJ().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gWN.LJ().getView().getParent()).removeView(this.gWN.LJ().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bYK().pageContext.getPageActivity()) * 0.7f);
            int i4 = com.baidu.live.ag.b.i(true, false);
            if (this.gVW != null && this.gWN != null) {
                this.gVW.addView(this.gWN.LJ().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, i4));
            }
            if (this.gVX != null && (this.gVX.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gVX.getParent()).removeView(this.gVX);
            }
            if (this.gWO != null) {
                this.gWO.a(bYK().hgD.Hi(), false);
                this.gWO.a(new a.InterfaceC0188a() { // from class: com.baidu.tieba.ala.liveroom.d.a.17
                    @Override // com.baidu.live.im.b.a.InterfaceC0188a
                    public void Mf() {
                        a.this.bYv();
                    }
                });
                View CK = this.gWO.CK();
                if (CK != null && this.gXv != null && CK.getParent() == null) {
                    Resources resources = bYK().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bYK().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                    layoutParams5.addRule(2, a.f.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                    this.gXv.addView(CK, layoutParams5);
                }
            }
            if (this.gWF != null) {
                this.gWF.setPraiseEnable(true);
                bYK().hgE.hwh = true;
            }
            if (this.gVI != null && this.gVI.gYR != null && (layoutParams3 = (FrameLayout.LayoutParams) this.gVI.gYR.getLayoutParams()) != null) {
                layoutParams3.width = -2;
                this.gVI.gYR.setLayoutParams(layoutParams3);
            }
            if (this.gWI != null) {
                this.gWI.ciw();
            }
            if (this.gWb) {
                mJ(true);
            }
            if (this.gWc) {
                if (this.gWy != null && this.gWy.getLandscapeBarrageImageView() != null) {
                    b(this.gWy.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.gWy != null) {
                this.gWy.wh(0);
            }
            if (this.gVM != null) {
                this.gVM.mV(true);
            }
            this.gWd.removeCallbacksAndMessages(null);
            if (this.gVN != null) {
                this.gVN.setCanVisible(true);
                this.gVN.G(bYK().hgD.Hi());
            }
            if (this.gVV != null) {
                this.gVV.cv(true);
            }
        } else if (i3 == 2) {
            if (bYK().pageContext.getPageActivity() != null && !UtilHelper.canUseStyleImmersiveSticky()) {
                com.baidu.live.utils.q.e(bYK().pageContext.getPageActivity(), false);
            }
            if (this.gWI != null) {
                this.gWI.cix();
            }
            if (this.gXu != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.gXu.getLayoutParams()) != null) {
                layoutParams2.topMargin = bYK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
            }
            if (this.gWO != null) {
                this.gWO.a((a.InterfaceC0188a) null);
                this.gWO.CM();
            }
            bYK().hgE.chY();
            if (this.bnG != null) {
                this.bnG.e(false, true);
            }
            if (this.gVY != null) {
                this.gVY.setVisibility(4);
            }
            if (this.gWN != null && this.gWN.LJ().getView().getParent() != null && (this.gWN.LJ().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gWN.LJ().getView().getParent()).removeView(this.gWN.LJ().getView());
            }
            int max = Math.max(i, i2);
            if (this.gVX != null) {
                if (this.gVX.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gVX.getParent()).removeView(this.gVX);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100);
                bYK().hgE.addView(this.gVX, this.brz != null ? bYK().hgE.indexOfChild(this.brz) : -1, layoutParams6);
            }
            if (this.gVX != null && this.gVT != null) {
                this.gVT.a(bYK().hgD.Hi(), false);
                this.gVT.a(new a.InterfaceC0188a() { // from class: com.baidu.tieba.ala.liveroom.d.a.18
                    @Override // com.baidu.live.im.b.a.InterfaceC0188a
                    public void Mf() {
                        a.this.bYv();
                    }
                });
                View CK2 = this.gVT.CK();
                if (CK2 != null && this.gVX.indexOfChild(CK2) < 0) {
                    this.gVX.addView(CK2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bYK().pageContext.getPageActivity()), -1));
                }
            }
            if (this.gWF != null) {
                this.gWF.aE(bYK().hgE);
                this.gWF.setPraiseEnable(false);
                bYK().hgE.hwh = false;
            }
            if (this.gVI != null && this.gVI.gYR != null && (layoutParams = (FrameLayout.LayoutParams) this.gVI.gYR.getLayoutParams()) != null) {
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                layoutParams.width = (int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f);
                this.gVI.gYR.setLayoutParams(layoutParams);
            }
            if (this.gWy != null) {
                this.gWy.wh(8);
            }
            if (this.gVM != null) {
                this.gVM.mV(false);
            }
            if (aj.Hw() != null) {
                aj.Hw().Hv();
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.ad.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.ad.c) runTask.getData()).Hv();
            }
            if (this.gWy != null && this.gWy.getLandscapeBarrageImageView() != null) {
                b(this.gWy.getLandscapeBarrageImageView(), this.gWc, false);
            }
            bXd();
            if (this.gWP != null) {
                this.gWP.GJ();
            }
            if (this.gVN != null) {
                this.gVN.setCanVisible(false);
                this.gVN.cci();
            }
            if (this.gVV != null) {
                this.gVV.setCanVisible(false);
            }
        }
        if (this.gXj != null) {
            this.gXj.dX(i3);
        }
        if (this.gWQ != null) {
            this.gWQ.dX(i3);
        }
        if (this.gWy != null) {
            this.gWy.l(i, i2, i3);
        }
        K(i3, true);
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.gVI != null) {
                this.gVI.dI(i3);
            }
            if (this.gVK != null) {
                this.gVK.dI(i3);
            }
            if (this.gVO != null) {
                this.gVO.dI(i3);
            }
            if (this.gWX != null) {
                this.gWX.dI(i3);
            }
            if (this.gWT != null) {
                this.gWT.dI(i3);
            }
            if (this.gXb != null) {
                this.gXb.dI(i3);
            }
            if (this.gXe != null) {
                this.gXe.dI(i3);
            }
            if (this.gXc != null) {
                this.gXc.dI(i3);
            }
            if (this.gKY != null) {
                this.gKY.dI(i3);
            }
            if (this.gWe != null && this.gWe.isShowing()) {
                this.gWe.resize();
            }
            if (this.gXo != null) {
                this.gXo.dI(i3);
            }
            if (this.gXp != null) {
                this.gXp.dI(i3);
            }
            if (this.gXm != null) {
                this.gXm.dX(i3);
            }
            if (this.gXs != null) {
                this.gXs.dI(i3);
            }
        }
        if (this.gWP != null) {
            this.gWP.GI();
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
            if (i != 7 || UtilHelper.getRealScreenOrientation(bYK().pageContext.getPageActivity()) != 2) {
                if (this.gWy != null) {
                    this.gWy.setVisibility(8);
                }
                if (this.gWN != null) {
                    this.gWN.LJ().getView().setVisibility(4);
                }
                if (this.gXd != null) {
                    this.gXd.nL(false);
                }
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
            if (this.gXd != null) {
                this.gXd.nL(true);
            }
            if (!this.gWb || UtilHelper.getRealScreenOrientation(bYK().pageContext.getPageActivity()) != 2) {
                this.gXu.setVisibility(0);
            }
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
        if (this.gXs != null) {
            this.gXs.onStop();
        }
        if (bYK() != null) {
            BdUtilHelper.hideSoftKeyPad(bYK().pageContext.getPageActivity(), bYK().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.gVL != null) {
            this.gVL.chb();
        }
        if (this.gVQ != null) {
            this.gVQ.Dw();
        }
        if (this.gVO != null) {
            this.gVO.onStart();
        }
        if (this.gXm != null) {
            this.gXm.onStart();
        }
        if (this.gXs != null) {
            this.gXs.onStart();
        }
    }

    private void K(int i, boolean z) {
        if (this.brz != null) {
            int dimensionPixelSize = bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.brz.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                layoutParams.rightMargin = bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6);
                layoutParams.height = bXl();
                this.brz.setPosition(dimensionPixelSize, 0, dimensionPixelSize, 0);
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                int dimensionPixelSize2 = bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds72) + 0 + bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100) + bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
                layoutParams.height = -1;
                this.brz.setPosition(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
            }
            layoutParams.bottomMargin = bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            this.brz.setLayoutParams(layoutParams);
            this.brz.setModel(i == 1 ? PendantParentView.Model.HORIZONTAL : PendantParentView.Model.HORIZONTAL_FULL);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.e
    public void vw(int i) {
        K(this.mOrientation, false);
    }
}
