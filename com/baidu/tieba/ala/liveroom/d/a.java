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
    private PendantParentView bpO;
    private com.baidu.live.im.b.a gVA;
    private com.baidu.tieba.ala.liveroom.share.b gVB;
    private com.baidu.live.z.a gVC;
    private FrameLayout gVD;
    private FrameLayout gVE;
    private ImageView gVF;
    private com.baidu.live.tieba.e.b gVG;
    private af gVL;
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
    private long lastClickTime = 0;
    private boolean gVH = false;
    private boolean gVI = false;
    private boolean gVJ = false;
    private Handler gVK = new Handler();
    private HttpRule gVN = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.gVx != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.gVx.CS()) {
                httpMessage.addParam("ala_challenge_id", a.this.gVx.CV());
            }
            return httpMessage;
        }
    };
    private HttpRule gVO = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.a.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.gVx != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.gVx.CS()) {
                httpMessage.addParam("challenge_id", a.this.gVx.CV());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c gVP = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.19
        @Override // com.baidu.live.liveroom.g.c
        public void Ns() {
            if (a.this.gWp != null) {
                a.this.gWp.nS(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cm(boolean z) {
            if (z) {
                if (a.this.gWp != null) {
                    a.this.gWp.nS(true);
                }
            } else if (a.this.gWp != null) {
                a.this.gWp.nS(false);
            }
            if (a.this.gWH != null) {
                a.this.gWH.bv(z);
            }
            if (a.this.gVv != null) {
                a.this.gVv.mJ(z ? false : true);
            }
            com.baidu.live.n.a.cn(z);
        }
    };
    private com.baidu.tieba.ala.liveroom.p.c gVQ = new com.baidu.tieba.ala.liveroom.p.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.20
        @Override // com.baidu.tieba.ala.liveroom.p.c
        public void onClick() {
            a.this.gVK.removeCallbacksAndMessages(null);
            a.this.gVH = true;
        }

        @Override // com.baidu.tieba.ala.liveroom.p.c
        public void endAnimation() {
            if (a.this.gVH) {
                a.this.bWw();
            }
        }
    };
    private HttpMessageListener gVR = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.NB() != null) {
                        com.baidu.live.aa.e.Pv().bss = getQuickGiftHttpResponseMessage.NB();
                        a.this.bWL();
                    }
                }
            }
        }
    };
    private CustomMessageListener gVS = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                a.this.gWx.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gVT = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.gWL != null) {
                    a.this.gWL.hN(str);
                }
            }
        }
    };
    CustomMessageListener gVU = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.gXi != null && a.this.gXi.beL != null && !a.this.gXi.beO && !a.this.gXi.beP && a.this.gWG != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.bYd().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                layoutParams.bottomMargin = a.this.bYd().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                a.this.gWG.c(a.this.gVD, layoutParams);
                if (com.baidu.live.guardclub.e.JV() != null) {
                    com.baidu.live.guardclub.e.JV().Kb();
                }
            }
        }
    };
    private CustomMessageListener gVV = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (a.this.gWI != null) {
                    a.this.gWI.dismiss();
                }
                if (a.this.gWL != null) {
                    a.this.gWL.dismiss();
                }
                if (a.this.gWJ != null) {
                    a.this.gWJ.dismiss();
                }
                if (a.this.gKF != null) {
                    a.this.gKF.dismiss();
                }
                com.baidu.live.im.b.d.Lx().setSwitchStatus(true);
                com.baidu.live.im.b.d.Lx().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bXz();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener gVW = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.gVM.c(a.this.bYd());
                } else if (a.this.bXs() || !g.wg(2913168)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.bYd().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.bYd().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    a.this.gVM.c(a.this.gVD, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gVX = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.a.13
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
            if (currentTimeMillis - a.this.lastClickTime >= 300) {
                a.this.lastClickTime = currentTimeMillis;
                if (i == 2 && a.this.Jd()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel"));
                    a.this.O(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.aa.e.Pv().bss.Gh().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.aa.e.Pv().bss.Gh().Fk());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.aa.e.Pv().bss.Gh().Fl());
                        if (a.this.bYd().hgk.Gz() != null && a.this.bYd().hgk.Gz().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.bYd().hgk.Gz().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.bYd().hgk.Gz().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.LU());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.Jd()) {
                        if (com.baidu.live.d.Aq().getBoolean("quick_gift_guide_show", true) && !a.this.bXs()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, af.class, a.this.bYd().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                af afVar = (af) runTask.getData();
                                afVar.setPageContext(a.this.bYd().pageContext);
                                afVar.setLiveShowData(a.this.bYd().hgk.Gz());
                                afVar.setGiftItem(com.baidu.live.aa.e.Pv().bss.Gh());
                                afVar.setOtherParams(a.this.LU());
                                afVar.initView();
                                afVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.13.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        a.this.mO(false);
                                        a.this.gVL = null;
                                    }
                                });
                                a.this.gVL = afVar;
                                afVar.show();
                                a.this.mO(true);
                                return;
                            }
                            return;
                        }
                        m.a(a.this.bYd().pageContext, a.this.bYd().hgk.Gz(), com.baidu.live.aa.e.Pv().bss.Gh(), a.this.LU());
                    }
                } else if (i == 1) {
                    if (a.this.gWu != null) {
                        a.this.bXz();
                    }
                } else if (i == 3 && a.this.Jd()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    if (a.this.mOrientation == 2 && (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                        if (a.this.gVB != null) {
                            a.this.gVB.M(a.this.bYd().hgk.Gz());
                        }
                    } else {
                        a.this.gWh.c(a.this.bYd().hgk.Gz(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.bYd() != null && a.this.bYd().hgk != null && a.this.bYd().hgk.Gz() != null && a.this.bYd().hgk.Gz().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.bYd().hgk.Gz().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.bYd().hgk.Gz().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.bYd().hgk.Gz().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.LU());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.bYd() != null && a.this.bYd().hgk != null && a.this.bYd().hgk.Gz() != null && a.this.bYd().hgk.Gz().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.bYd().hgk.Gz().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.bYd().hgk.Gz().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.bYd().hgk.Gz().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.LU());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.blV != null) {
                        a.this.blV.cg(false);
                    }
                } else if (i == 12) {
                    if (a.this.gWp != null) {
                        String valueOf = String.valueOf(a.this.bYd().hgk.Gz().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.bYd().hgk.Gz().mLiveInfo.room_id);
                        String str3 = null;
                        AlaLiveSdkInfo alaLiveSdkInfo = a.this.bYd().hgk.Gz().mLiveSdkInfo;
                        if (alaLiveSdkInfo != null && alaLiveSdkInfo.mCastIds != null) {
                            str3 = String.valueOf(a.this.bYd().hgk.Gz().mLiveSdkInfo.mCastIds.chatMCastId);
                        }
                        a.this.gWp.as(valueOf, valueOf2, str3);
                        com.baidu.live.n.a.b(a.this.bYd().hgk.Gz().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    w Gz = a.this.bYd().hgk.Gz();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.bYd().pageContext.getPageActivity(), Gz.aHk.userName, Long.toString(Gz.aHk.userId), Long.toString(Gz.aHk.charmCount), String.valueOf(Gz.mLiveInfo.group_id), String.valueOf(Gz.mLiveInfo.live_id), false, String.valueOf(Gz.aHk.userId), Long.toString(Gz.aHG.userId), Gz.aHG.userName, Gz.aHG.portrait, a.this.gVt.getCount(), a.this.LU())));
                    LogManager.getCommonLogger().doClickGusetNumLog(Gz.mLiveInfo.feed_id, a.this.gVt.getCount() + "", a.this.LU());
                } else if (i == 11) {
                    a.this.bXC();
                    a.this.bXD();
                } else if (i == 16) {
                    if (a.this.bYd() != null && (bnVar2 = com.baidu.live.aa.a.Ph().bsh) != null && (cdVar2 = bnVar2.aNM) != null) {
                        String str4 = cdVar2.aPh.aPo;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (a.this.bYd().hgk != null && a.this.bYd().hgk.Gz() != null && a.this.bYd().hgk.Gz().mLiveInfo != null) {
                                j = a.this.bYd().hgk.Gz().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", a.this.bYd().hgk.Gz().mLiveInfo.room_id + "", a.this.bYd().hgk.Gz().mLiveInfo.feed_id, a.this.LU());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.bYd().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (a.this.bYd() != null) {
                        w wVar = null;
                        if (a.this.bYd().hgk != null) {
                            wVar = a.this.bYd().hgk.Gz();
                        }
                        if (wVar != null && wVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.w.b.cgG().bmB != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.w.b.cgG().bmB.aGz;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(a.this.bYd().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17) {
                    if (a.this.Jd() && a.this.bYd() != null && (bnVar = com.baidu.live.aa.a.Ph().bsh) != null && (cdVar = bnVar.aNM) != null && (cjVar = cdVar.aPi) != null && !TextUtils.isEmpty(cjVar.webUrl)) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                        if (a.this.gWI != null && a.this.bYd().hgk != null && a.this.bYd().hgk.Gz() != null) {
                            w Gz2 = a.this.bYd().hgk.Gz();
                            a.this.gWI.a(cjVar.webUrl, Gz2.mLiveInfo.live_id, Gz2.aHG.userId, Gz2.aHk.userId);
                            a.this.gVG.cM(false);
                            a.this.gVG.SJ();
                        }
                    }
                } else if (i == 18) {
                    if (a.this.gVJ) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.gVJ = !a.this.gVJ;
                } else if (i == 19 && a.this.gVG != null) {
                    a.this.gVG.SJ();
                }
            }
        }
    };

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
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWw() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.21
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gVI) {
                    a.this.mK(false);
                }
            }
        }, 5000L);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(w wVar) {
        super.l(wVar);
        g.cbx();
        this.gVJ = false;
        if (this.gWm != null) {
            this.gWm.b(this.gVX);
        }
        if (this.gVG == null) {
            this.gVG = new com.baidu.live.tieba.e.b(bYd().pageContext.getPageActivity());
            this.gVG.start();
        }
        this.gVG.cM(true);
        bYd().pageContext.getPageActivity().setRequestedOrientation(-1);
        bYd().hgl.setIsForceHandledTouch(false);
        bYd().hgl.setSwipeClearEnable(true);
        bYd().hgl.setOnLiveViewScrollListener(this.gVP);
        bYd().hgl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gVK.removeCallbacksAndMessages(null);
                a.this.gVH = false;
                a.this.mK(false);
                if (!a.this.gVI) {
                    a.this.bWw();
                }
            }
        });
        if (this.gXb != null) {
            this.gXb.setVisibility(0);
        }
        bWD();
        if (this.gWE != null) {
            this.gWE.a(wVar, this.bpO);
            this.gWE.U(this.gXc);
            this.gWE.a(this);
        }
        bWO();
        bXn();
        bWP();
        bWB();
        bWT();
        bWQ();
        bWx();
        mP(false);
        bXF();
        bWV();
        bXL();
        bXR();
        bXG();
        bXK();
        bWM();
        bWN();
        bXH();
        bWz();
        bWW();
        mQ(true);
        bWF();
        bWL();
        bXV();
        bWG();
        bWH();
        bWI();
        bWJ();
        bWC();
        bWX();
        bWy();
        bXU();
        bXQ();
        if (this.gWI != null && this.gWI.cgN() == null) {
            this.gWI.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.23
                @Override // com.baidu.tieba.ala.liveroom.turntable.d.a
                public void onDismiss() {
                    a.this.gVG.cM(true);
                }
            });
        }
        if (this.gWJ != null && this.gWJ.cbC() == null) {
            this.gWJ.a(new a.InterfaceC0679a() { // from class: com.baidu.tieba.ala.liveroom.d.a.24
                @Override // com.baidu.tieba.ala.liveroom.m.a.InterfaceC0679a
                public void onDismiss() {
                    a.this.gVG.cM(true);
                }
            });
        }
        c(this.gaF);
        MessageManager.getInstance().registerListener(this.gVR);
        MessageManager.getInstance().registerListener(this.gVU);
        MessageManager.getInstance().registerListener(this.gVV);
        MessageManager.getInstance().registerListener(this.gVW);
        MessageManager.getInstance().registerListener(this.gVT);
        MessageManager.getInstance().registerListener(this.gVS);
        bWY();
        bWS();
        if (this.mOrientation == 2) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(bYd().pageContext.getPageActivity());
            l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(bYd().pageContext.getPageActivity()));
        }
        if (this.gWT != null) {
            this.gWT.F(wVar);
        }
    }

    private void bWx() {
        if (this.gWT == null) {
            View view = null;
            if (this.gWm != null && this.gWm.getView() != null) {
                view = this.gWm.getView();
            }
            this.gWT = new com.baidu.tieba.ala.liveroom.exclusive.b(bYd().pageContext, No(), bYd().hgl, view, this.gVp.gYx, this);
        }
    }

    private void bWy() {
        if (this.gWS != null) {
            this.gWS.a(new com.baidu.live.v.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.25
                @Override // com.baidu.live.v.c
                public void ct(boolean z) {
                    if (a.this.gVy != null) {
                        a.this.gVy.setNeedCloseRecommendFloat(z);
                    }
                    if (a.this.bYd().hgl.hvO) {
                        if (a.this.gWp != null) {
                            a.this.gWp.nK(z);
                            a.this.gWp.nS(!z);
                        }
                        if (a.this.gWm != null) {
                            a.this.gWm.nK(z);
                            a.this.gWm.setPraiseEnable(!z);
                            a.this.gWm.nJ(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mK(boolean z) {
        View Gy;
        if (bYd() != null && bYd().pageContext != null && bYd().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(bYd().pageContext.getPageActivity()) == 2 || z) {
                if (this.gWx != null && (Gy = this.gWx.Gy()) != null) {
                    if (this.gVI) {
                        Gy.setVisibility(0);
                    } else {
                        Gy.setVisibility(8);
                    }
                }
                if (this.gVI) {
                    if (this.gXb != null) {
                        this.gXb.setVisibility(0);
                    }
                    if (this.gXc != null) {
                        this.gXc.setVisibility(0);
                    }
                    if (this.bpO != null) {
                        this.bpO.setVisibility(0);
                    }
                    if (this.bpO != null) {
                        this.bpO.setVisibility(0);
                    }
                    if (this.gWw != null) {
                        this.gWw.bt(false);
                    }
                } else {
                    if (this.gXb != null) {
                        this.gXb.setVisibility(8);
                    }
                    if (this.gXc != null) {
                        this.gXc.setVisibility(8);
                    }
                    if (this.bpO != null) {
                        this.bpO.setVisibility(8);
                    }
                    if (this.bpO != null) {
                        this.bpO.setVisibility(8);
                    }
                    if (this.gWw != null) {
                        this.gWw.bt(true);
                    }
                }
                this.gVI = this.gVI ? false : true;
                if (this.gVv != null) {
                    this.gVv.mJ(this.gVI);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, boolean z2) {
        ImageView imageView;
        View FY;
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view;
        }
        if (z) {
            if (imageView != null) {
                imageView.setImageResource(a.e.icon_live_barrage_off);
            }
            if (this.gVE != null) {
                this.gVE.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.e.icon_live_barrage_on);
            }
            if (this.gVE != null) {
                this.gVE.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.gWw != null && (FY = this.gWw.FY()) != null) {
            if (z) {
                FY.setVisibility(8);
            } else {
                FY.setVisibility(0);
            }
        }
    }

    private void bWz() {
        CustomResponsedMessage runTask;
        if (this.gVA == null && (runTask = MessageManager.getInstance().runTask(2913164, com.baidu.live.im.b.a.class, bYd().pageContext)) != null) {
            this.gVA = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gVA != null) {
            this.gVA.setOtherParams(this.otherParams);
            this.gVA.a(new a.InterfaceC0186a() { // from class: com.baidu.tieba.ala.liveroom.d.a.2
                @Override // com.baidu.live.im.b.a.InterfaceC0186a
                public void Lw() {
                    a.this.bXO();
                }
            });
        }
    }

    private void bWA() {
        if (this.gWo != null) {
            this.gWo.ax(bYd().hgj.getLiveContainerView());
        }
    }

    private void bWB() {
        if (this.gVB == null) {
            this.gVB = new com.baidu.tieba.ala.liveroom.share.b(bYd().pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void bWC() {
        if (bYd() != null) {
            if (this.gVC == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.z.a.class, bYd().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gVC = (com.baidu.live.z.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.gVC.setIsHost(false);
            this.gVC.a(this.bpO, bYd().hgk.Gz().aIi);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void dI(int i) {
        super.dI(i);
        if (this.gVF != null && UtilHelper.getRealScreenOrientation(bYd().pageContext.getPageActivity()) != 2) {
            this.gVF.setVisibility(0);
        }
        bWA();
        if (this.gVy != null) {
            this.gVy.dI(i);
        }
        if (this.gVy == null || !this.gVy.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
        if (this.gWT != null) {
            this.gWT.caV();
        }
    }

    private void bWD() {
        if (this.bpO == null) {
            PendantParentView.Model model = PendantParentView.Model.HORIZONTAL;
            if (this.mOrientation == 2) {
                model = PendantParentView.Model.HORIZONTAL_FULL;
            }
            this.bpO = new PendantParentView(bYd().pageContext.getPageActivity(), model);
            bYd().hgl.addView(this.bpO, ((bYd().hgl.getView() == null || this.gWm == null || this.gWm.getView() == null) ? -1 : bYd().hgl.getView().indexOfChild(this.gWm.getView())) + 1, new RelativeLayout.LayoutParams(-1, bWE()));
            this.bpO.setDefaultItemMargin(bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            K(this.mOrientation, false);
        }
    }

    private int bWE() {
        int bottom;
        int bottom2;
        if (bYd().blY.getLivePlayer().getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bYd().blY.getLivePlayer().getLayoutParams();
            bottom = layoutParams.topMargin + layoutParams.height;
        } else {
            bottom = bYd().blY.getLivePlayer().getBottom();
        }
        if (bYd().hgl.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) bYd().hgl.getLayoutParams();
            bottom2 = layoutParams2.topMargin + layoutParams2.height;
        } else {
            bottom2 = bYd().hgl.getBottom();
        }
        int i = 0;
        if (this.gWT != null) {
            i = this.gWT.getHeight();
        }
        return (((bottom2 - bottom) - i) - bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
    }

    private void bWF() {
        if (this.gVv == null) {
            this.gVv = new com.baidu.tieba.ala.liveroom.activeview.b(bYd().pageContext);
        }
        if (bYd() != null && bYd().hgk != null) {
            this.gVv.Hm(bYd().hgk.cfU());
        }
        this.gVv.setOtherParams(LU());
        this.gVv.b(bYd().hgk.Gz(), true);
        this.gVv.setHost(false);
        this.gVv.a(1, this.bpO);
        this.gVv.a(2, this.bpO);
        this.gVv.setVisible(this.gXf ? 8 : 0);
    }

    private void bWG() {
        if (this.bpO != null) {
            if (this.gVu == null) {
                this.gVu = new com.baidu.tieba.ala.liveroom.l.a(bYd().pageContext, this);
            }
            this.gVu.setOtherParams(LU());
            this.gVu.a((ViewGroup) this.bpO, bWK());
            this.gVu.G(bYd().hgk.Gz());
        }
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
            this.gWf.a(new a.InterfaceC0682a() { // from class: com.baidu.tieba.ala.liveroom.d.a.9
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0682a
                public void bO(int i, int i2) {
                    w Gz = a.this.bYd().hgk.Gz();
                    if (Gz != null && Gz.mLiveInfo != null) {
                        if (a.this.gWK == null) {
                            a.this.gWK = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.bYd().pageContext.getPageActivity());
                        }
                        a.this.gWK.d(a.this.gXc, i, i2);
                        a.this.gWK.a(String.valueOf(Gz.mLiveInfo.live_id), new a.InterfaceC0686a() { // from class: com.baidu.tieba.ala.liveroom.d.a.9.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0686a
                            public void a(float f, String str) {
                                if (a.this.gWf != null) {
                                    a.this.gWf.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0682a
                public void bP(int i, int i2) {
                    if (a.this.gWK != null) {
                        a.this.gWK.bU(i, i2);
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
            this.gVM = new com.baidu.tieba.ala.liveroom.j.b(bYd().pageContext, LU(), this.gXr, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.10
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bXg() {
                    a.this.mO(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bXh() {
                    a.this.mO(false);
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
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = bYd().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWL() {
        if (this.gWf == null) {
            bWQ();
        }
        this.gWf.a(com.baidu.live.aa.e.Pv().bss, bYd().hgk.Gz());
    }

    private void bWM() {
        CustomResponsedMessage runTask;
        boolean z = true;
        if (this.gWu == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, bYd().pageContext)) != null && runTask.getData() != null) {
            this.gWu = (k) runTask.getData();
            this.gWu.setFromMaster(false);
            this.gWu.La().getView().setId(a.f.ala_liveroom_msg_list);
            this.gWu.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.11
                @Override // com.baidu.live.im.k.a
                public boolean Ld() {
                    return a.this.Jd();
                }

                @Override // com.baidu.live.im.k.a
                public void Le() {
                    a.this.gXj = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hD(String str) {
                    if (!a.this.gXf) {
                        a.this.mM(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.bYd().pageContext.getPageActivity(), a.this.bYd().hgj.getLiveContainerView());
                    }
                    a.this.Hs(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Lf() {
                    if (a.this.gXf) {
                        a.this.mM(true);
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.bYd().pageContext.getPageActivity(), a.this.bYd().hgj.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (a.this.gWu != null) {
                        a.this.gWu.Lb().setQuickInputPanelVisible(false);
                        a.this.gWu.Lb().Mw();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Lg() {
                    if (a.this.gXf) {
                        a.this.bXf();
                        if (a.this.gWv != null) {
                            a.this.gWv.Cc();
                        }
                        if (a.this.gVA != null) {
                            a.this.gVA.Cc();
                        }
                    } else if (a.this.gWu != null) {
                        a.this.gWu.Lb().setQuickInputPanelVisible(false);
                        a.this.gWu.Lb().Mw();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Lh() {
                    return a.this.bXt();
                }

                @Override // com.baidu.live.im.k.a
                public int Li() {
                    return a.this.bXu();
                }
            });
            this.gVD = new FrameLayout(bYd().pageContext.getPageActivity());
            this.gVD.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.gWu != null && this.gVD != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bYd().pageContext.getPageActivity()) * 0.7f);
            int i = com.baidu.live.ag.b.i(true, false);
            if (this.gXc.indexOfChild(this.gVD) < 0) {
                if (this.gVD.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gVD.getParent()).removeView(this.gVD);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
                this.gXc.addView(this.gVD, layoutParams);
            }
            if (this.gVD.indexOfChild(this.gWu.La().getView()) < 0) {
                if (this.gWu.La().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gWu.La().getView()).removeView(this.gWu.La().getView());
                }
                if (UtilHelper.getRealScreenOrientation(bYd().pageContext.getPageActivity()) != 2) {
                    this.gVD.addView(this.gWu.La().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, i));
                }
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
            if (Gz == null || Gz.aHW == null || !Gz.aHW.Dr()) {
                z = false;
            }
            this.gWu.a(String.valueOf(bYd().hgk.Gz().mLiveInfo.group_id), String.valueOf(bYd().hgk.Gz().mLiveInfo.last_msg_id), String.valueOf(bYd().hgk.Gz().aHk.userId), String.valueOf(bYd().hgk.Gz().mLiveInfo.live_id), bYd().hgk.Gz().aHk.appId, z);
            mM(false);
        }
    }

    private void bWN() {
        if (this.gVE == null) {
            this.gVE = new FrameLayout(bYd().pageContext.getPageActivity());
            this.gVE.setId(a.f.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void bWO() {
        if (this.gVq == null) {
            this.gVq = new com.baidu.tieba.ala.liveroom.p.a(bYd().pageContext, false, this);
        }
        this.gVq.d(this.gXb, bYd().hgk.Gz());
        this.gVq.a(this.gVQ);
        this.gVq.a(this.gVX);
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

    private void bWW() {
        boolean z = false;
        if (this.gWp == null) {
            this.gWp = new com.baidu.tieba.ala.liveroom.x.a(bYd().pageContext, this);
        }
        this.gWp.d(bYd().hgl, false);
        boolean bYc = bYc();
        AlaLiveInfoData alaLiveInfoData = bYd().hgk.Gz().mLiveInfo;
        boolean isZanAnimUnabled = (alaLiveInfoData == null || alaLiveInfoData.mAlaLiveSwitchData == null) ? false : alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled();
        if (bYc && !isZanAnimUnabled) {
            z = true;
        }
        this.gWp.nR(z);
    }

    private void bWX() {
        if (bYd() != null && bYd().blY != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(bYd().pageContext.getPageActivity());
            Activity pageActivity = bYd().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + o.aI(pageActivity)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.gVF = new ImageView(bYd().pageContext.getPageActivity());
            this.gVF.setVisibility(8);
            this.gVF.setBackgroundResource(a.e.sdk_round_btn_close_bg);
            this.gVF.setImageResource(a.e.icon_live_enlarge);
            this.gVF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.gVG != null) {
                        a.this.gVG.SI();
                        a.this.gVF.setVisibility(4);
                    }
                }
            });
            bYd().hgl.addView(this.gVF, layoutParams);
            if (UtilHelper.getRealScreenOrientation(bYd().pageContext.getPageActivity()) != 2) {
                if (bYd().hgr) {
                    this.gVF.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.15
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.gVF != null && UtilHelper.getRealScreenOrientation(a.this.bYd().pageContext.getPageActivity()) != 2) {
                                a.this.gVF.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
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
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.16
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bXz();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void t(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
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
            e.printStackTrace();
            jSONObject = null;
        }
        if (this.gVC == null || !this.gVC.L(jSONObject)) {
            if ((aVar.getMsgType() == 12 || aVar.getMsgType() == 13) && jSONObject != null) {
                String optString = jSONObject.optString("content_type");
                if ("task".equals(optString)) {
                    if (this.gVu != null) {
                        this.gVu.I(jSONObject);
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
                    long optLong = jSONObject.optLong("mvp_user_id");
                    long optLong2 = jSONObject.optLong("winner_live_id");
                    if (optLong == bYd().hgk.Gz().aHG.userId && optLong2 == bYd().hgk.Gz().mLiveInfo.live_id) {
                        this.gVy.c(jSONObject.optInt("challenge_status"), jSONObject.optLong("challenge_id"));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void Ho(String str) {
        if (this.gVv != null) {
            this.gVv.Ho(str);
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
        if (this.gVA != null) {
            this.gVA.a(wVar);
        }
        if (this.gVv != null) {
            this.gVv.i(wVar);
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
        if (this.gVC != null) {
            this.gVC.Ka();
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
        if (this.gVx != null) {
            this.gVx.CD();
        }
        if (this.gVA != null) {
            this.gVA.a((a.InterfaceC0186a) null);
            this.gVA.Cd();
        }
        if (this.gVq != null) {
            this.gVq.ccA();
        }
        if (this.gVF != null && (this.gVF.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gVF.getParent()).removeView(this.gVF);
        }
        if (this.gVB != null) {
            this.gVB.dismiss();
        }
        if (this.gVG != null) {
            this.gVG.cM(false);
            this.gVG.SJ();
        }
        if (this.gVM != null) {
            this.gVM.CD();
        }
        if (this.gXr != null) {
            this.gXr.bZq();
        }
        if (this.gWW != null) {
            this.gWW.CD();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void m(w wVar) {
        View Cb;
        super.m(wVar);
        if (this.gVA != null && (Cb = this.gVA.Cb()) != null && Cb.getParent() != null) {
            ((ViewGroup) Cb.getParent()).removeView(Cb);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.gVA != null) {
            this.gVA.setOtherParams(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cj(boolean z) {
        super.cj(z);
        this.gVK.removeCallbacksAndMessages(null);
        bWZ();
        this.gVI = false;
        this.gVJ = false;
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
        if (this.gVB != null) {
            this.gVB.onDestroy();
        }
        if (this.gVr != null) {
            this.gVr.onDestroy();
        }
        if (this.gVG != null) {
            this.gVG.stop();
        }
        if (this.gWp != null) {
            this.gWp.onDestroy();
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
        if (this.gVA != null) {
            this.gVA.a((a.InterfaceC0186a) null);
            this.gVA.release();
            this.gVA = null;
        }
        if (this.gXr != null) {
            this.gXr.cj(z ? false : true);
        }
        if (this.gVM != null) {
            this.gVM.onDestroy();
            this.gVM = null;
        }
        if (this.gWW != null) {
            this.gWW.onDestroy();
        }
        if (this.gVC != null) {
            this.gVC.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.gVN);
        MessageManager.getInstance().removeMessageRule(this.gVO);
        MessageManager.getInstance().unRegisterListener(this.gVR);
        MessageManager.getInstance().unRegisterListener(this.gVU);
        MessageManager.getInstance().unRegisterListener(this.gVV);
        MessageManager.getInstance().unRegisterListener(this.gVW);
        MessageManager.getInstance().unRegisterListener(this.gVT);
        MessageManager.getInstance().unRegisterListener(this.gVS);
    }

    private void bWZ() {
        if (this.gWu != null && this.gWu.La().getView() != null && this.gWu.La().getView().getParent() != null) {
            ((ViewGroup) this.gWu.La().getView().getParent()).removeView(this.gWu.La().getView());
        }
        if (this.gVD != null && this.gVD.getParent() != null) {
            ((ViewGroup) this.gVD.getParent()).removeView(this.gVD);
        }
        if (this.gVE != null && this.gVE.getParent() != null) {
            ((ViewGroup) this.gVE.getParent()).removeView(this.gVE);
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

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected ViewGroup bXd() {
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
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.gXf;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(bYd().pageContext.getPageActivity()) || z2) {
            mL(z);
        }
    }

    private void mL(boolean z) {
        if (this.gWu != null && this.gWu.La() != null) {
            this.gWu.La().onKeyboardVisibilityChanged(z);
        }
        if (z || this.gWu == null || !this.gWu.Lb().Mv()) {
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
                if (this.gWQ != null) {
                    this.gWQ.setCanVisible(false);
                }
                if (this.gWR != null) {
                    this.gWR.setVisible(8);
                }
            } else {
                bXe();
            }
            if (this.gWu != null && this.gVD != null) {
                if (this.gXc.indexOfChild(this.gVD) != -1 && this.gVD.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gVD.getLayoutParams();
                    layoutParams2.height = com.baidu.live.ag.b.i(true, z);
                    this.gVD.setLayoutParams(layoutParams2);
                }
                if (this.gVD.indexOfChild(this.gWu.La().getView()) != -1 && this.gWu.La().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.gWu.La().getView().getLayoutParams();
                    layoutParams3.height = com.baidu.live.ag.b.i(true, z);
                    this.gWu.La().getView().setLayoutParams(layoutParams3);
                }
                this.gWu.La().KZ();
            }
        }
    }

    private void bXe() {
        if (this.gWf != null) {
            this.gWf.setVisibility(0);
        }
        if (this.gVD != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gVD.getLayoutParams();
            layoutParams.bottomMargin = bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            this.gVD.setLayoutParams(layoutParams);
        }
        if (this.gWu != null) {
            bXA();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gWu.Lb().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.gWu.Lb().getView().setLayoutParams(layoutParams2);
        }
        if (this.gWf != null) {
            this.gWf.setVisibility(0);
        }
        if (this.gWw != null && this.gWw.FY() != null) {
            this.gWw.FY().setVisibility(0);
        }
        if (this.gXb != null && (!this.gVI || UtilHelper.getRealScreenOrientation(bYd().pageContext.getPageActivity()) != 2)) {
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
        FrameLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        FrameLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = bYd().pageContext.getPageActivity();
        if (i3 == 1) {
            if (bYd().pageContext.getPageActivity() != null && !UtilHelper.canUseStyleImmersiveSticky()) {
                com.baidu.live.utils.q.e(bYd().pageContext.getPageActivity(), true);
            }
            if (this.gXb != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.gXb.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.gVB != null) {
                this.gVB.dismiss();
            }
            if (this.gVA != null) {
                this.gVA.a((a.InterfaceC0186a) null);
                this.gVA.Cd();
            }
            if (this.blV != null) {
                this.blV.e(true, true);
            }
            if (this.gVF != null) {
                this.gVF.setVisibility(0);
                this.gVF.bringToFront();
            }
            if (this.gWk != null) {
                this.gWk.setVisibility(0);
            }
            if (this.gWu != null && this.gWu.La().getView().getParent() != null && (this.gWu.La().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gWu.La().getView().getParent()).removeView(this.gWu.La().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bYd().pageContext.getPageActivity()) * 0.7f);
            int i4 = com.baidu.live.ag.b.i(true, false);
            if (this.gVD != null && this.gWu != null) {
                this.gVD.addView(this.gWu.La().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, i4));
            }
            if (this.gVE != null && (this.gVE.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gVE.getParent()).removeView(this.gVE);
            }
            if (this.gWv != null) {
                this.gWv.a(bYd().hgk.Gz(), false);
                this.gWv.a(new a.InterfaceC0186a() { // from class: com.baidu.tieba.ala.liveroom.d.a.17
                    @Override // com.baidu.live.im.b.a.InterfaceC0186a
                    public void Lw() {
                        a.this.bXO();
                    }
                });
                View Cb = this.gWv.Cb();
                if (Cb != null && this.gXc != null && Cb.getParent() == null) {
                    Resources resources = bYd().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bYd().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                    layoutParams5.addRule(2, a.f.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                    this.gXc.addView(Cb, layoutParams5);
                }
            }
            if (this.gWm != null) {
                this.gWm.setPraiseEnable(true);
                bYd().hgl.hvO = true;
            }
            if (this.gVp != null && this.gVp.gYy != null && (layoutParams3 = (FrameLayout.LayoutParams) this.gVp.gYy.getLayoutParams()) != null) {
                layoutParams3.width = -2;
                this.gVp.gYy.setLayoutParams(layoutParams3);
            }
            if (this.gWp != null) {
                this.gWp.chP();
            }
            if (this.gVI) {
                mK(true);
            }
            if (this.gVJ) {
                if (this.gWf != null && this.gWf.getLandscapeBarrageImageView() != null) {
                    b(this.gWf.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.gWf != null) {
                this.gWf.wF(0);
            }
            if (this.gVt != null) {
                this.gVt.mW(true);
            }
            this.gVK.removeCallbacksAndMessages(null);
            if (this.gVu != null) {
                this.gVu.setCanVisible(true);
                this.gVu.G(bYd().hgk.Gz());
            }
            if (this.gVC != null) {
                this.gVC.cx(true);
            }
        } else if (i3 == 2) {
            if (bYd().pageContext.getPageActivity() != null && !UtilHelper.canUseStyleImmersiveSticky()) {
                com.baidu.live.utils.q.e(bYd().pageContext.getPageActivity(), false);
            }
            if (this.gWp != null) {
                this.gWp.chQ();
            }
            if (this.gXb != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.gXb.getLayoutParams()) != null) {
                layoutParams2.topMargin = bYd().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
            }
            if (this.gWv != null) {
                this.gWv.a((a.InterfaceC0186a) null);
                this.gWv.Cd();
            }
            bYd().hgl.chr();
            if (this.blV != null) {
                this.blV.e(false, true);
            }
            if (this.gVF != null) {
                this.gVF.setVisibility(4);
            }
            if (this.gWu != null && this.gWu.La().getView().getParent() != null && (this.gWu.La().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gWu.La().getView().getParent()).removeView(this.gWu.La().getView());
            }
            int max = Math.max(i, i2);
            if (this.gVE != null) {
                if (this.gVE.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gVE.getParent()).removeView(this.gVE);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100);
                bYd().hgl.addView(this.gVE, this.bpO != null ? bYd().hgl.indexOfChild(this.bpO) : -1, layoutParams6);
            }
            if (this.gVE != null && this.gVA != null) {
                this.gVA.a(bYd().hgk.Gz(), false);
                this.gVA.a(new a.InterfaceC0186a() { // from class: com.baidu.tieba.ala.liveroom.d.a.18
                    @Override // com.baidu.live.im.b.a.InterfaceC0186a
                    public void Lw() {
                        a.this.bXO();
                    }
                });
                View Cb2 = this.gVA.Cb();
                if (Cb2 != null && this.gVE.indexOfChild(Cb2) < 0) {
                    this.gVE.addView(Cb2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bYd().pageContext.getPageActivity()), -1));
                }
            }
            if (this.gWm != null) {
                this.gWm.aA(bYd().hgl);
                this.gWm.setPraiseEnable(false);
                bYd().hgl.hvO = false;
            }
            if (this.gVp != null && this.gVp.gYy != null && (layoutParams = (FrameLayout.LayoutParams) this.gVp.gYy.getLayoutParams()) != null) {
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                layoutParams.width = (int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f);
                this.gVp.gYy.setLayoutParams(layoutParams);
            }
            if (this.gWf != null) {
                this.gWf.wF(8);
            }
            if (this.gVt != null) {
                this.gVt.mW(false);
            }
            if (aj.GN() != null) {
                aj.GN().GM();
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.ad.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.ad.c) runTask.getData()).GM();
            }
            if (this.gWf != null && this.gWf.getLandscapeBarrageImageView() != null) {
                b(this.gWf.getLandscapeBarrageImageView(), this.gVJ, false);
            }
            bWw();
            if (this.gWw != null) {
                this.gWw.Ga();
            }
            if (this.gVu != null) {
                this.gVu.setCanVisible(false);
                this.gVu.cbB();
            }
            if (this.gVC != null) {
                this.gVC.setCanVisible(false);
            }
        }
        if (this.gWQ != null) {
            this.gWQ.dT(i3);
        }
        if (this.gWx != null) {
            this.gWx.dT(i3);
        }
        if (this.gWf != null) {
            this.gWf.l(i, i2, i3);
        }
        K(i3, true);
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.gVp != null) {
                this.gVp.dE(i3);
            }
            if (this.gVr != null) {
                this.gVr.dE(i3);
            }
            if (this.gVv != null) {
                this.gVv.dE(i3);
            }
            if (this.gWE != null) {
                this.gWE.dE(i3);
            }
            if (this.gWA != null) {
                this.gWA.dE(i3);
            }
            if (this.gWI != null) {
                this.gWI.dE(i3);
            }
            if (this.gWL != null) {
                this.gWL.dE(i3);
            }
            if (this.gWJ != null) {
                this.gWJ.dE(i3);
            }
            if (this.gKF != null) {
                this.gKF.dE(i3);
            }
            if (this.gVL != null && this.gVL.isShowing()) {
                this.gVL.resize();
            }
            if (this.gWV != null) {
                this.gWV.dE(i3);
            }
            if (this.gWW != null) {
                this.gWW.dE(i3);
            }
            if (this.gWT != null) {
                this.gWT.dT(i3);
            }
            if (this.gWZ != null) {
                this.gWZ.dE(i3);
            }
        }
        if (this.gWw != null) {
            this.gWw.FZ();
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
            if (i != 7 || UtilHelper.getRealScreenOrientation(bYd().pageContext.getPageActivity()) != 2) {
                if (this.gWf != null) {
                    this.gWf.setVisibility(8);
                }
                if (this.gWu != null) {
                    this.gWu.La().getView().setVisibility(4);
                }
                if (this.gWK != null) {
                    this.gWK.nM(false);
                }
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
            if (this.gWK != null) {
                this.gWK.nM(true);
            }
            if (!this.gVI || UtilHelper.getRealScreenOrientation(bYd().pageContext.getPageActivity()) != 2) {
                this.gXb.setVisibility(0);
            }
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
        if (this.gWZ != null) {
            this.gWZ.onStop();
        }
        if (bYd() != null) {
            BdUtilHelper.hideSoftKeyPad(bYd().pageContext.getPageActivity(), bYd().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.gVs != null) {
            this.gVs.cgu();
        }
        if (this.gVx != null) {
            this.gVx.CN();
        }
        if (this.gVv != null) {
            this.gVv.onStart();
        }
        if (this.gWT != null) {
            this.gWT.onStart();
        }
        if (this.gWZ != null) {
            this.gWZ.onStart();
        }
    }

    private void K(int i, boolean z) {
        if (this.bpO != null) {
            int dimensionPixelSize = bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bpO.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                layoutParams.rightMargin = bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6);
                layoutParams.height = bWE();
                this.bpO.setPosition(dimensionPixelSize, 0, dimensionPixelSize, 0);
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                int dimensionPixelSize2 = bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds72) + 0 + bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100) + bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
                layoutParams.height = -1;
                this.bpO.setPosition(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
            }
            layoutParams.bottomMargin = bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            this.bpO.setLayoutParams(layoutParams);
            this.bpO.setModel(i == 1 ? PendantParentView.Model.HORIZONTAL : PendantParentView.Model.HORIZONTAL_FULL);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.e
    public void vU(int i) {
        K(this.mOrientation, false);
    }
}
