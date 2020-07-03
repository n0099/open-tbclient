package com.baidu.tieba.ala.liveroom.c;

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
import com.baidu.live.data.ae;
import com.baidu.live.data.am;
import com.baidu.live.data.aq;
import com.baidu.live.data.bb;
import com.baidu.live.data.bl;
import com.baidu.live.data.br;
import com.baidu.live.data.k;
import com.baidu.live.data.o;
import com.baidu.live.data.q;
import com.baidu.live.gift.n;
import com.baidu.live.gift.z;
import com.baidu.live.guardclub.j;
import com.baidu.live.im.k;
import com.baidu.live.im.m;
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
import com.baidu.tieba.ala.liveroom.guide.a;
import com.baidu.tieba.ala.liveroom.i.b;
import com.baidu.tieba.ala.liveroom.i.g;
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.recommend.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends b {
    private PendantParentView bbS;
    private com.baidu.tieba.ala.liveroom.i.b fVA;
    private com.baidu.tieba.ala.liveroom.audiencelist.c fVf;
    private com.baidu.tieba.ala.liveroom.m.a fVg;
    private com.baidu.tieba.ala.liveroom.f.b fVh;
    private com.baidu.tieba.ala.liveroom.s.b fVi;
    private com.baidu.tieba.ala.liveroom.audiencelist.b fVj;
    private com.baidu.tieba.ala.liveroom.k.a fVk;
    private com.baidu.tieba.ala.liveroom.activeview.b fVl;
    private com.baidu.live.d.a fVm;
    private i fVn;
    private h fVo;
    private com.baidu.tieba.ala.liveroom.attentionpop.b fVp;
    private FrameLayout fVs;
    private e fXA;
    private boolean fXB;
    private LinearLayout fXz;
    private long lastClickTime = 0;
    private boolean fXC = false;
    private HttpRule fVB = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.fVn != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.fVn.vV()) {
                httpMessage.addParam("ala_challenge_id", d.this.fVn.vY());
            }
            return httpMessage;
        }
    };
    private HttpRule fVC = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.c.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.fVn != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.fVn.vV()) {
                httpMessage.addParam("challenge_id", d.this.fVn.vY());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c fVD = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.c.d.15
        @Override // com.baidu.live.liveroom.g.c
        public void FS() {
            if (d.this.fWf != null) {
                d.this.fWf.lC(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bV(boolean z) {
            if (z) {
                if (d.this.fVU != null) {
                    d.this.fVU.rV(8);
                }
                if (d.this.fWf != null) {
                    d.this.fWf.lC(true);
                }
            } else {
                if (d.this.fVU != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                        d.this.fVU.rV(0);
                    } else {
                        d.this.fVU.rV(8);
                    }
                }
                if (d.this.fWf != null) {
                    d.this.fWf.lC(false);
                }
            }
            if (d.this.fWw != null) {
                d.this.fWw.be(z);
            }
        }
    };
    private HttpMessageListener fVE = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.d.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Gc() != null) {
                        com.baidu.live.v.c.Hr().bed = getQuickGiftHttpResponseMessage.Gc();
                        d.this.bAF();
                    }
                }
            }
        }
    };
    private CustomMessageListener fVF = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.d.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.bAQ();
        }
    };
    CustomMessageListener fVK = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.c.d.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.fVA.c(d.this.bBS());
                } else if (d.this.bBl() || !g.rx(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.19.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, 3000L);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.bBS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.bBS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    d.this.fVA.b(d.this.fVs, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener fXD = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.c.d.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.bBl() || !g.rx(2913128)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.rv(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, 3000L);
                } else {
                    d.this.CJ(str);
                }
            }
        }
    };
    private CustomMessageListener fVG = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.c.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.fWm.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fVH = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.c.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.this.fWA != null) {
                    d.this.fWA.Dc(str);
                }
            }
        }
    };
    CustomMessageListener fVI = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.c.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.fWQ != null && d.this.fWQ.aRm != null && !d.this.fWQ.aRp && !d.this.fWQ.aRq && d.this.fWv != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.bBS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = d.this.bBS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                d.this.fWv.b(d.this.fVs, layoutParams);
                if (com.baidu.live.guardclub.e.Cg() != null) {
                    com.baidu.live.guardclub.e.Cg().Cm();
                }
            }
        }
    };
    private CustomMessageListener fVJ = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.fWy != null) {
                    d.this.fWy.dismiss();
                }
                if (d.this.fWA != null) {
                    d.this.fWA.dismiss();
                }
                m.Dm().setSwitchStatus(true);
                m.Dm().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bBr();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b fVL = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.d.11
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void l(View view, int i) {
            bb bbVar;
            bl blVar;
            br brVar;
            String str;
            bb bbVar2;
            bl blVar2;
            String str2;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - d.this.lastClickTime >= 300) {
                d.this.lastClickTime = currentTimeMillis;
                if (i == 2) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel"));
                    d.this.L(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.v.c.Hr().bed.yI().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.v.c.Hr().bed.yI().xM());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.v.c.Hr().bed.yI().xN());
                        if (d.this.bBS().gfS.FU() != null && d.this.bBS().gfS.FU().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.bBS().gfS.FU().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.bBS().gfS.FU().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.Ep());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.Bp()) {
                        if (com.baidu.live.c.vf().getBoolean("quick_gift_guide_show", true) && !d.this.bBl()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, z.class, d.this.bBS().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                z zVar = (z) runTask.getData();
                                zVar.setPageContext(d.this.bBS().pageContext);
                                zVar.d(d.this.bBS().gfS.FU());
                                zVar.setGiftItem(com.baidu.live.v.c.Hr().bed.yI());
                                zVar.setOtherParams(d.this.Ep());
                                zVar.initView();
                                zVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.d.11.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        d.this.kF(false);
                                    }
                                });
                                zVar.show();
                                d.this.kF(true);
                                return;
                            }
                            return;
                        }
                        n.a(d.this.bBS().pageContext, d.this.bBS().gfS.FU(), com.baidu.live.v.c.Hr().bed.yI(), d.this.Ep());
                    }
                } else if (i == 1) {
                    if (d.this.fWj != null) {
                        d.this.bBr();
                    }
                } else if (i == 3 && d.this.Bp()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    d.this.fVX.c(d.this.bBS().gfS.FU(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.bBS() != null && d.this.bBS().gfS != null && d.this.bBS().gfS.FU() != null && d.this.bBS().gfS.FU().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.bBS().gfS.FU().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.bBS().gfS.FU().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.bBS().gfS.FU().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.Ep());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.bBS() != null && d.this.bBS().gfS != null && d.this.bBS().gfS.FU() != null && d.this.bBS().gfS.FU().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.bBS().gfS.FU().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.bBS().gfS.FU().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.bBS().gfS.FU().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.Ep());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.aYR != null) {
                        d.this.aYR.bQ(false);
                    }
                } else if (i == 12) {
                    if (d.this.fWf != null && d.this.bBS().gfS.FU() != null && d.this.bBS().gfS.FU().mLiveInfo != null) {
                        String valueOf = String.valueOf(d.this.bBS().gfS.FU().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.bBS().gfS.FU().mLiveInfo.room_id);
                        String str3 = null;
                        o oVar = d.this.bBS().gfS.FU().mLiveSdkInfo;
                        if (oVar != null && oVar.mCastIds != null) {
                            str3 = String.valueOf(d.this.bBS().gfS.FU().mLiveSdkInfo.mCastIds.axB);
                        }
                        d.this.fWf.ah(valueOf, valueOf2, str3);
                        if (com.baidu.live.liveroom.a.Fp().Fq()) {
                            d.this.bAQ();
                        }
                    }
                } else if (i == 14) {
                    q FU = d.this.bBS().gfS.FU();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.bBS().pageContext.getPageActivity(), FU.axp.userName, Long.toString(FU.axp.userId), Long.toString(FU.axp.charmCount), String.valueOf(FU.mLiveInfo.group_id), String.valueOf(FU.mLiveInfo.live_id), false, String.valueOf(FU.axp.userId), Long.toString(FU.axI.userId), FU.axI.userName, FU.axI.portrait, d.this.fVj.getCount(), d.this.Ep())));
                    LogManager.getCommonLogger().doClickGusetNumLog(FU.mLiveInfo.feed_id, d.this.fVj.getCount() + "", d.this.Ep());
                } else if (i == 11) {
                    d.this.bBu();
                    d.this.bBv();
                } else if (i == 16) {
                    if (d.this.bBS() != null && (bbVar2 = com.baidu.live.v.a.Hm().bdV) != null && (blVar2 = bbVar2.aCT) != null) {
                        String str4 = blVar2.aDQ.aDX;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (d.this.bBS().gfS != null && d.this.bBS().gfS.FU() != null && d.this.bBS().gfS.FU().mLiveInfo != null) {
                                j = d.this.bBS().gfS.FU().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", d.this.bBS().gfS.FU().mLiveInfo.room_id + "", d.this.bBS().gfS.FU().mLiveInfo.feed_id, d.this.Ep());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.bBS().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (d.this.bBS() != null) {
                        q qVar = null;
                        if (d.this.bBS().gfS != null) {
                            qVar = d.this.bBS().gfS.FU();
                        }
                        if (qVar != null && qVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.u.a.bJt().aZA != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.u.a.bJt().aZA.awR;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + qVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + qVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(d.this.bBS().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17 && d.this.Bp() && d.this.bBS() != null && (bbVar = com.baidu.live.v.a.Hm().bdV) != null && (blVar = bbVar.aCT) != null && (brVar = blVar.aDR) != null && !TextUtils.isEmpty(brVar.webUrl)) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                    if (d.this.fWy != null && d.this.bBS().gfS != null && d.this.bBS().gfS.FU() != null) {
                        q FU2 = d.this.bBS().gfS.FU();
                        d.this.fWy.a(brVar.webUrl, FU2.mLiveInfo.live_id, FU2.axI.userId, FU2.axp.userId);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.fVZ = new com.baidu.tieba.ala.liveroom.guide.c(bBS().pageContext, this, false);
        this.fVB.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.fVB);
        this.fVC.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.fVC);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean bAr() {
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void m(q qVar) {
        super.m(qVar);
        g.bED();
        this.fXC = true;
        bBS().gfT.setIsForceHandledTouch(false);
        bBS().gfT.setSwipeClearEnable(true);
        bBS().gfT.setOnLiveViewScrollListener(this.fVD);
        if (this.fWc != null) {
            this.fWc.b(this.fVL);
        }
        if (this.fWJ != null) {
            this.fWJ.setVisibility(0);
        }
        bAw();
        if (this.fWt != null) {
            this.fWt.a(qVar, this.bbS);
        }
        bCg();
        bAI();
        bBh();
        bAJ();
        bAN();
        bAK();
        kA(false);
        bBy();
        bBx();
        bAz();
        bAG();
        bBA();
        bAP();
        bAR();
        bCc();
        bCd();
        kG(false);
        bBJ();
        bAy();
        bAF();
        bAA();
        bAB();
        bAC();
        bAD();
        bBF();
        bAs();
        kK(true);
        bBI();
        c(this.fgP);
        MessageManager.getInstance().registerListener(this.fVE);
        MessageManager.getInstance().registerListener(this.fVF);
        MessageManager.getInstance().registerListener(this.fVG);
        MessageManager.getInstance().registerListener(this.fVI);
        MessageManager.getInstance().registerListener(this.fVJ);
        MessageManager.getInstance().registerListener(this.fXD);
        MessageManager.getInstance().registerListener(this.fVK);
        MessageManager.getInstance().registerListener(this.fVH);
        bAT();
        bAM();
    }

    private void bAs() {
        if (this.fWF != null) {
            this.fWF.a(new a.InterfaceC0578a() { // from class: com.baidu.tieba.ala.liveroom.c.d.16
                @Override // com.baidu.tieba.ala.liveroom.recommend.a.InterfaceC0578a
                public void kD(boolean z) {
                    if (d.this.fVo != null) {
                        d.this.fVo.setNeedCloseRecommendFloat(z);
                    }
                    if (d.this.bBS().gfT.guc) {
                        if (d.this.fWf != null) {
                            d.this.fWf.lu(z);
                            d.this.fWf.lC(!z);
                        }
                        if (d.this.fWc != null) {
                            d.this.fWc.lu(z);
                            d.this.fWc.setPraiseEnable(!z);
                            d.this.fWc.lt(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(q qVar) {
        super.k(qVar);
        if (this.fVg != null) {
            this.fVg.v(qVar);
        }
        if (this.fVh != null) {
            this.fVh.r(qVar);
        }
        if (this.fVk != null) {
            this.fVk.u(qVar);
        }
        if (this.fVo != null) {
            this.fVo.a(qVar);
        }
        kK(false);
        if (this.fVl != null) {
            this.fVl.j(qVar);
            this.fVl.kx(this.fWT);
            this.fVl.updateView();
            if (qVar != null && this.fWG != null && !this.fWG.hasInit && !TextUtils.isEmpty(this.fWG.aDn)) {
                this.fWG.hasInit = true;
                this.fVl.CF(this.fWG.aDn);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(k kVar) {
        if (kVar != null) {
            if (this.fVf != null && kVar.getList() != null) {
                this.fVf.e(kVar);
            }
            if (this.fVj != null) {
                this.fVj.dp(kVar.getCount());
            }
        }
    }

    private void bAu() {
        if (this.fWe != null) {
            this.fWe.au(bBS().gfR.getLiveContainerView());
        }
    }

    private void bCc() {
        if (this.fVp == null) {
            this.fVp = new com.baidu.tieba.ala.liveroom.attentionpop.b(bBS().pageContext);
        }
        if (bBS().gfS != null && bBS().gfS.FU() != null && bBS().gfS.FU().mLiveInfo != null) {
            this.fVp.CG(String.valueOf(bBS().gfS.FU().mLiveInfo.user_id));
        }
    }

    private void bCd() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (bBS() != null && bBS().gfS != null && bBS().gfS.FU() != null && bBS().gfS.FU().mLiveInfo != null) {
                j = bBS().gfS.FU().mLiveInfo.room_id;
            }
            if (this.fWr == null) {
                this.fWr = new com.baidu.tieba.ala.liveroom.guide.a(bBS().pageContext, j);
            }
            this.fWr.kE(this.fWM);
            this.fWr.a(new a.InterfaceC0571a() { // from class: com.baidu.tieba.ala.liveroom.c.d.5
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0571a
                public void bCj() {
                    if (d.this.aYR != null) {
                        d.this.aYR.bQ(true);
                    }
                }
            });
            this.fWr.aq(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bL(int i) {
        super.bL(i);
        bAu();
        if (this.fVo != null) {
            this.fVo.bL(i);
        }
    }

    private void bAw() {
        if (this.bbS == null) {
            this.bbS = new PendantParentView(bBS().pageContext.getPageActivity(), this.fXB ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            bBS().gfT.addView(this.bbS, new ViewGroup.LayoutParams(-1, -1));
            this.bbS.setDefaultItemMargin(bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.bbS.setPadding(bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20), 0, bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6), 0);
            bCe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCe() {
        int dimensionPixelSize;
        if (this.bbS != null) {
            this.bbS.setModel(this.fXB ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            int dimensionPixelSize2 = bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds220);
            int dimensionPixelSize3 = bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            if (this.fXB) {
                dimensionPixelSize = bCh();
            } else {
                dimensionPixelSize = bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200);
            }
            this.bbS.setPosition(dimensionPixelSize2, 0, dimensionPixelSize, dimensionPixelSize3);
            return;
        }
        bAw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCf() {
        if (this.fWj != null && this.fVs != null && this.fWj.Da() != null && this.fWj.Da().getView() != null) {
            if (this.fXB) {
                int screenHeight = (ScreenHelper.getScreenHeight(bBS().pageContext.getPageActivity()) - (this.fVo != null ? this.fVo.aW(false) : 0)) - bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                ViewGroup.LayoutParams layoutParams = this.fWj.Da().getView().getLayoutParams();
                if (layoutParams != null && layoutParams.height > 0 && layoutParams.height >= screenHeight) {
                    layoutParams.height = screenHeight;
                    this.fWj.Da().getView().setLayoutParams(layoutParams);
                    if (this.fVs != null) {
                        ViewGroup.LayoutParams layoutParams2 = this.fVs.getLayoutParams();
                        layoutParams2.height = com.baidu.live.aa.a.ct(false) + layoutParams.height;
                        this.fVs.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
            }
            int cr = com.baidu.live.aa.a.cr(this.fWN);
            if (this.fWK.indexOfChild(this.fVs) != -1 && this.fVs.getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fVs.getLayoutParams();
                layoutParams3.height = com.baidu.live.aa.a.h(false, this.fWN);
                this.fVs.setLayoutParams(layoutParams3);
            }
            if (this.fVs.indexOfChild(this.fWj.Da().getView()) != -1 && this.fWj.Da().getView().getLayoutParams() != null) {
                FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.fWj.Da().getView().getLayoutParams();
                layoutParams4.height = cr;
                this.fWj.Da().getView().setLayoutParams(layoutParams4);
            }
            this.fWj.Da().CZ();
        }
    }

    private void bCg() {
        if (this.fXz == null) {
            this.fXz = new LinearLayout(bBS().pageContext.getPageActivity());
            this.fXz.setOrientation(1);
        }
        if (this.fXz.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds160);
            layoutParams.leftMargin = bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bBS().gfT.addView(this.fXz, layoutParams);
        }
    }

    private void bAz() {
        if (this.fWb != null && bBS() != null && bBS().gfS != null) {
            this.fWb.b(this.fWJ, bBS().gfS.FU());
        }
    }

    private void bAy() {
        if (this.fVl == null) {
            this.fVl = new com.baidu.tieba.ala.liveroom.activeview.b(bBS().pageContext);
        }
        if (bBS() != null && bBS().gfS != null) {
            this.fVl.CD(bBS().gfS.bII());
        }
        this.fVl.kw(this.fXB);
        this.fVl.setOtherParams(Ep());
        this.fVl.b(bBS().gfS.FU(), false);
        this.fVl.setHost(false);
        this.fVl.kx(this.fWT);
        this.fVl.a(1, this.bbS);
        this.fVl.a(2, this.bbS);
        this.fVl.setVisible(this.fWN ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAF() {
        if (this.fVU == null) {
            bAK();
        }
        this.fVU.setOtherParams(Ep());
        this.fVU.a(com.baidu.live.v.c.Hr().bed, bBS().gfS.FU());
    }

    private void bAA() {
        if (this.fVk == null) {
            this.fVk = new com.baidu.tieba.ala.liveroom.k.a(bBS().pageContext, this);
        }
        this.fVk.setOtherParams(Ep());
        this.fVk.a((ViewGroup) this.bbS, bAE());
        this.fVk.u(bBS().gfS.FU());
    }

    private void bAB() {
        if (this.fWv == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, j.class, bBS().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.fWv = (j) runTask.getData();
            } else {
                return;
            }
        }
        this.fWv.setOtherParams(Ep());
        if (this.fVs != null && this.fVs.indexOfChild(this.fWv.getView()) >= 0) {
            this.fVs.removeView(this.fWv.getView());
        }
    }

    private void bAC() {
        if (this.fVU != null) {
            this.fVU.a(new a.InterfaceC0576a() { // from class: com.baidu.tieba.ala.liveroom.c.d.6
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0576a
                public void bz(int i, int i2) {
                    q FU = d.this.bBS().gfS.FU();
                    if (FU != null && FU.mLiveInfo != null) {
                        if (d.this.fWz == null) {
                            d.this.fWz = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.bBS().pageContext.getPageActivity());
                        }
                        d.this.fWz.d(d.this.fWK, i, i2);
                        d.this.fWz.a(String.valueOf(FU.mLiveInfo.live_id), new a.InterfaceC0583a() { // from class: com.baidu.tieba.ala.liveroom.c.d.6.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0583a
                            public void a(float f, String str) {
                                if (d.this.fVU != null) {
                                    d.this.fVU.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0576a
                public void bA(int i, int i2) {
                    if (d.this.fWz != null) {
                        d.this.fWz.bF(i, i2);
                    }
                }
            });
        }
    }

    private void bAD() {
        if (this.fWY == null) {
            this.fWY = new com.baidu.tieba.ala.liveroom.i.e(bBS().pageContext);
        }
        this.fWY.setRoomId(bBS().gfS.FU().mLiveInfo.room_id);
        this.fWY.CT("");
        this.fWY.b(bBS().gfS.FU(), this.bbS);
        if (this.fVA == null) {
            this.fVA = new com.baidu.tieba.ala.liveroom.i.b(bBS().pageContext, Ep(), this.fWY, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.7
                @Override // com.baidu.tieba.ala.liveroom.i.b.a
                public void bBc() {
                    d.this.kF(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.i.b.a
                public void bBd() {
                    d.this.kF(false);
                }
            });
        }
        this.fVA.setRoomId(bBS().gfS.FU().mLiveInfo.room_id);
        if (this.fVs != null && this.fVs.indexOfChild(this.fVA.getView()) >= 0) {
            this.fVs.removeView(this.fVA.getView());
        }
        if (this.fVA != null) {
            this.fVA.b(bBS());
        }
    }

    private LinearLayout.LayoutParams bAE() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    private void bAG() {
        CustomResponsedMessage runTask;
        if (this.fWj == null && (runTask = MessageManager.getInstance().runTask(2913039, com.baidu.live.im.k.class, bBS().pageContext)) != null && runTask.getData() != null) {
            this.fWj = (com.baidu.live.im.k) runTask.getData();
            this.fWj.setFromMaster(false);
            this.fWj.Da().getView().setId(a.g.ala_liveroom_msg_list);
            this.fWj.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.8
                @Override // com.baidu.live.im.k.a
                public boolean Dd() {
                    return d.this.Bp();
                }

                @Override // com.baidu.live.im.k.a
                public void De() {
                    d.this.fWR = true;
                }

                @Override // com.baidu.live.im.k.a
                public void fw(String str) {
                    if (!d.this.fWN) {
                        d.this.kC(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.bBS().pageContext.getPageActivity(), d.this.bBS().gfR.getLiveContainerView());
                    }
                    d.this.CI(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Df() {
                    if (d.this.fWN) {
                        d.this.kC(true);
                        d.this.bBS().gfR.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.bBS().pageContext.getPageActivity(), d.this.bBS().gfR.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.fWj != null) {
                        d.this.fWj.Db().setQuickInputPanelVisible(false);
                        d.this.fWj.Db().EN();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Dg() {
                    if (d.this.fWN) {
                        d.this.bBb();
                        if (d.this.fWk != null) {
                            d.this.fWk.Dk();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Dh() {
                    return d.this.bBm();
                }

                @Override // com.baidu.live.im.k.a
                public int Di() {
                    return d.this.bBn();
                }
            });
            this.fVs = new FrameLayout(bBS().pageContext.getPageActivity());
            this.fVs.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.fWj != null && this.fVs != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bBS().pageContext.getPageActivity()) * 0.7f);
            int cr = com.baidu.live.aa.a.cr(false);
            if (this.fWK.indexOfChild(this.fVs) < 0) {
                if (this.fVs.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fVs.getParent()).removeView(this.fVs);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.live.aa.a.h(false, false));
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.live.aa.a.cs(false);
                this.fWK.addView(this.fVs, layoutParams);
            }
            if (this.fVs.indexOfChild(this.fWj.Da().getView()) < 0) {
                if (this.fWj.Da().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fWj.Da().getView()).removeView(this.fWj.Da().getView());
                }
                this.fVs.addView(this.fWj.Da().getView(), new FrameLayout.LayoutParams(equipmentWidth, cr));
            }
            if (bBS().gfT.indexOfChild(this.fWj.Db().getView()) < 0) {
                if (this.fWj.Db().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fWj.Db().getView().getParent()).removeView(this.fWj.Db().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bBs();
                bBS().gfT.addView(this.fWj.Db().getView(), layoutParams2);
            }
            q FU = bBS().gfS.FU();
            if (FU != null && FU.mLiveInfo != null) {
                this.fWj.setLogData(FU.mLiveInfo.feed_id, Ep());
            }
            this.fWj.a(String.valueOf(bBS().gfS.FU().mLiveInfo.group_id), String.valueOf(bBS().gfS.FU().mLiveInfo.last_msg_id), String.valueOf(bBS().gfS.FU().axp.userId), String.valueOf(bBS().gfS.FU().mLiveInfo.live_id), bBS().gfS.FU().axp.appId, (FU == null || FU.axV == null || !FU.axV.wo()) ? false : true);
            kC(false);
        }
    }

    private void bAI() {
        if (this.fVg == null) {
            this.fVg = new com.baidu.tieba.ala.liveroom.m.a(bBS().pageContext, false, this);
        }
        this.fVg.c(this.fWJ, bBS().gfS.FU());
        this.fVg.a(this.fVL);
        this.fVg.setOtherParams(Ep());
    }

    private void bAJ() {
        if (this.fVf == null) {
            this.fVf = new com.baidu.tieba.ala.liveroom.audiencelist.c(bBS().pageContext, this, false);
        }
        this.fVf.a(String.valueOf(bBS().gfS.FU().mLiveInfo.group_id), String.valueOf(bBS().gfS.FU().mLiveInfo.live_id), String.valueOf(bBS().gfS.FU().axp.userId), bBS().gfS.FU());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.fVW != null && this.fVW.getView() != null && this.fVW.getView().getParent() != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.fVf.c(this.fWJ, i, a.g.ala_liveroom_audience_count_layout);
            this.fVf.e(bBS().gfS.bwd());
            this.fVf.setOtherParams(Ep());
        }
    }

    private void bAK() {
        com.baidu.live.core.a.a Fn;
        if (this.fVU == null) {
            this.fVU = new com.baidu.tieba.ala.liveroom.operation.a(bBS().pageContext);
        }
        this.fVU.a(bBS(), this.fWK, bBS().gfS.FU().mLiveInfo, true, this.fVL);
        this.fVU.setOtherParams(Ep());
        if (this.fWt != null && (Fn = this.fWt.Fn()) != null) {
            View rootLayout = Fn.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.fVU.bG(rootLayout);
        }
    }

    public void kJ(boolean z) {
        if (this.fVU != null) {
            this.fVU.kJ(z);
        }
    }

    private void bAN() {
        if (this.fVj == null) {
            this.fVj = new com.baidu.tieba.ala.liveroom.audiencelist.b(bBS().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (bBS().gfS.bwd() != null) {
            j = bBS().gfS.bwd().getCount();
        }
        this.fVj.a(this.fVL);
        this.fVj.a(this.fWJ, a.g.ala_liveroom_audience, j);
        this.fVj.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.fVj.kN(false);
        } else {
            this.fVj.kN(true);
        }
    }

    protected void CJ(String str) {
        if (this.fWX == null) {
            this.fWX = new com.baidu.tieba.ala.liveroom.r.b(bBS().pageContext);
        }
        this.fWX.b(this.fWK, str);
        kF(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.9
            @Override // java.lang.Runnable
            public void run() {
                d.this.fWX.bJa();
                d.this.kF(false);
            }
        }, 5000L);
    }

    private void kK(boolean z) {
        CustomResponsedMessage runTask;
        if (bBS().gfS.FU().mLiveInfo.live_type == 1 && this.fXC) {
            if (this.fXA == null && (runTask = MessageManager.getInstance().runTask(2913074, e.class, bBS().pageContext)) != null && runTask.getData() != null) {
                this.fXA = (e) runTask.getData();
            }
            if (this.fXA != null) {
                if (this.fVn == null) {
                    this.fVn = this.fXA.a(bBS().pageContext);
                }
                if (bBS().gfS.FU().mLiveInfo.challengeId > 0 && !this.fVn.vW()) {
                    this.fVn.e(bBS().gfS.FU().mLiveInfo.live_id, bBS().gfS.FU().axp.userId);
                    kL(z);
                    if (z) {
                        this.fVn.a(bBS().gfS.bHN());
                    }
                    this.fVn.c(bBS().gfS.FU());
                }
            }
        }
    }

    private void kL(boolean z) {
        if (this.fVo == null) {
            this.fVo = this.fXA.b(bBS().pageContext);
            this.fVo.a(new com.baidu.live.challenge.g() { // from class: com.baidu.tieba.ala.liveroom.c.d.10
                @Override // com.baidu.live.challenge.g
                public void vL() {
                    d.this.bBS().gfT.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.g
                public void a(am amVar, aq aqVar, aq aqVar2) {
                    d.this.fXB = true;
                    if (d.this.fWc != null) {
                        d.this.fWc.setPraiseEnable(false);
                        d.this.bBS().gfT.guc = false;
                    }
                    if (d.this.fWd != null) {
                        d.this.fWd.bJr();
                    }
                    if (d.this.fVk != null) {
                        d.this.fVk.setCanVisible(false);
                        d.this.fVk.bEJ();
                    }
                    if (d.this.fVl != null) {
                        d.this.fVl.kw(true);
                    }
                    if (d.this.fWY != null) {
                        d.this.fWY.setVisible(8);
                    }
                    if (d.this.fVm != null) {
                        d.this.fVm.setCanVisible(false);
                        d.this.fVm.setVisible(8);
                    }
                    d.this.bCe();
                    d.this.bCf();
                    if (d.this.bBS().aYU != null) {
                        d.this.bBS().aYU.getLivePlayer().setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                    }
                    if (d.this.fWa != null) {
                        d.this.fWa.setTimeTextMode(true);
                    }
                    if (d.this.aYR != null && aqVar != null && aqVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(aqVar.aBZ);
                        arrayList.add(aqVar2.aBZ);
                        com.baidu.live.liveroom.a.c cVar = d.this.aYR;
                        if (d.this.fWU) {
                            arrayList = null;
                        }
                        cVar.j(arrayList);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void vM() {
                }

                @Override // com.baidu.live.challenge.g
                public void vN() {
                }

                @Override // com.baidu.live.challenge.g
                public void aU(boolean z2) {
                    d.this.bBS().gfT.setSwipeClearEnable(true);
                    d.this.fXB = false;
                    if (d.this.fWc != null) {
                        d.this.fWc.setPraiseEnable(true);
                        d.this.bBS().gfT.guc = true;
                    }
                    if (d.this.fWd != null) {
                        d.this.fWd.bJs();
                    }
                    if (d.this.fVk != null) {
                        d.this.fVk.setCanVisible(true);
                        d.this.fVk.u(d.this.bBS().gfS.FU());
                    }
                    if (d.this.fWf != null) {
                        d.this.fWf.lC(true);
                    }
                    if (d.this.fVl != null) {
                        d.this.fVl.kw(false);
                    }
                    if (d.this.fWY != null) {
                        d.this.fWY.setVisible(0);
                    }
                    if (d.this.fVm != null) {
                        d.this.fVm.setCanVisible(true);
                        d.this.fVm.setVisible(0);
                    }
                    d.this.bCe();
                    d.this.bCf();
                    if (d.this.aYR != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.bBS().gfS.bID());
                        com.baidu.live.liveroom.a.c cVar = d.this.aYR;
                        if (d.this.fWU) {
                            arrayList = null;
                        }
                        cVar.j(arrayList);
                    }
                    if (d.this.bBS().aYU != null) {
                        d.this.bBS().aYU.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
                    }
                    if (d.this.fWa != null) {
                        d.this.fWa.setTimeTextMode(false);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void aV(boolean z2) {
                    if (z2 && d.this.fWF != null) {
                        d.this.fWF.onClose();
                    }
                }
            });
        }
        this.fVo.a(this.fVn);
        this.fVo.j(bBS().gfR.getLiveContainerView());
        this.fVo.b(z, false, false);
        this.fVn.a((i.c) this.fVo);
    }

    public void bAO() {
        this.fVX.c(bBS().gfS.FU(), false);
    }

    public void bAP() {
        if (bBS().gfS.FU() != null && bBS().gfS.FU().axp != null && bBS().gfS.FU().mLiveInfo != null) {
            if (this.fVi == null) {
                this.fVi = new com.baidu.tieba.ala.liveroom.s.b(bBS().pageContext);
            }
            long j = bBS().gfS.FU().axp.userId;
            int i = bBS().gfS.FU().mLiveInfo.live_type;
            String str = bBS().gfS.FU().axp.portrait;
            String str2 = bBS().gfS.FU().mLiveInfo.feed_id;
            long j2 = bBS().gfS.FU().mLiveInfo.live_id;
            this.fVi.a(i, j, bBS().gfS.FU().axp.userName, false, str, Ep(), str2, j2);
            this.fVi.aq(this.fWJ);
        }
    }

    private int bCh() {
        return (this.fVo != null ? this.fVo.aW(false) : 0) + bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAQ() {
        if (bBS() == null || bBS().gfS == null || bBS().gfS.FU() == null || bBS().gfS.FU().axI == null) {
            if (bBS().gfS == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bBS().gfS.FU() == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bBS().gfS.FU().axI == null) {
                Log.i("RenameLog", "getLiveContext().liveModel.getLiveShowData().mLoginUserInfo == null");
                return;
            } else {
                return;
            }
        }
        String str = bBS().gfS.FU().axI.userName;
        Log.i("RenameLog", "loginUserName:" + str);
        if (str != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bBS().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !bBl()) {
            com.baidu.live.c.vf().putInt("guide_rename_show_count", com.baidu.live.c.vf().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.Fp().bP(true);
            if (this.fWC == null) {
                this.fWC = new com.baidu.tieba.ala.liveroom.t.a(bBS().pageContext);
            }
            this.fWC.setOtherParams(Ep());
            this.fWC.e(this.fWK, bBS().gfS.FU());
            kF(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.13
                @Override // java.lang.Runnable
                public void run() {
                    d.this.fWC.bJi();
                    d.this.kF(false);
                }
            }, 5000L);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_SHOW);
                alaStaticItem.addParams("other_params", Ep());
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    private void bAR() {
        boolean z = false;
        if (this.fWf == null) {
            this.fWf = new com.baidu.tieba.ala.liveroom.w.a(bBS().pageContext, this);
        }
        this.fWf.d(bBS().gfT, false);
        if (bBR() && bBS().gfS.FU().mLiveInfo.screen_direction != 2) {
            z = true;
        }
        this.fWf.lB(z);
    }

    private void bAT() {
        if (this.fWR || this.fWS) {
            if ((TbadkCoreApplication.isLogin() && this.fWj.Db().hasText()) || this.fWS) {
                this.fWR = false;
                this.fWS = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.14
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bBr();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void bAL() {
        bAM();
    }

    private void bAM() {
        if (this.fVU != null) {
            int i = bBS().gfS.FU().axI.isUegBlock;
            int i2 = bBS().gfS.FU().axI.isBlock;
            String str = bBS().gfS.FU().axI.userName;
            if (i > 0 || i2 > 0) {
                this.fVU.b(true, i, i2, str);
                this.fWj.a(true, i, i2, str);
                this.fWp.b(true, i, i2, str);
                return;
            }
            this.fVU.b(false, i, i2, str);
            this.fWj.a(false, i, i2, str);
            this.fWp.b(false, i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void k(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        super.k(aVar);
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
                if (this.fVk != null) {
                    this.fVk.G(jSONObject);
                }
            } else if ("enter_live".equals(optString)) {
                if (this.fVj != null && this.fVj.getCount() > 20) {
                    this.fVj.dp(this.fVj.getCount() + 1);
                } else if (this.fVf != null) {
                    com.baidu.live.data.a Ed = aVar.Ed();
                    com.baidu.live.data.j jVar = new com.baidu.live.data.j();
                    jVar.axq = new AlaLocationData();
                    jVar.axr = new AlaRelationData();
                    jVar.axp = new AlaLiveUserInfoData();
                    jVar.axp.userId = JavaTypesHelper.toLong(Ed.userId, 0L);
                    jVar.axp.userName = Ed.userName;
                    jVar.axp.portrait = Ed.portrait;
                    if (this.fVj != null && this.fVf.c(jVar)) {
                        this.fVj.dp(this.fVj.getCount() + 1);
                    }
                }
            } else if ("update_liveinfo".equals(optString)) {
                if (bBS().gfS.FU() != null && bBS().gfS.FU().mLiveInfo != null) {
                    bBS().gfS.a(bBS().gfS.FU().mLiveInfo.live_id, bBS().fromType, bBS().enterTime);
                }
            } else if ("challenge_mvp".equals(optString) && bBS().gfS.FU() != null && bBS().gfS.FU().mLiveInfo != null && bBS().gfS.FU().axI != null && this.fVo != null) {
                long optLong = jSONObject.optLong("mvp_user_id");
                long optLong2 = jSONObject.optLong("winner_live_id");
                if (optLong == bBS().gfS.FU().axI.userId && optLong2 == bBS().gfS.FU().mLiveInfo.live_id) {
                    this.fVo.c(jSONObject.optInt("challenge_status"), jSONObject.optLong("challenge_id"));
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void CE(String str) {
        if (this.fVl != null) {
            this.fVl.CE(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void bU(boolean z) {
        super.bU(z);
        if (bBS().gfT != null) {
            bBS().gfT.bKc();
            bBS().gfT.setLiveViewOnDispatchTouchEventListener(null);
            bBS().gfT.setLiveViewOnTouchEventListener(null);
            bBS().gfT.setOnLiveViewScrollListener(null);
        }
        if (bBS().aYU != null) {
            bBS().aYU.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.fVo != null) {
            this.fVo.vH();
        }
        bAU();
        if (this.fVi != null) {
            this.fVi.vH();
        }
        if (this.fWf != null) {
            this.fWf.release();
        }
        if (this.fVk != null) {
            this.fVk.vH();
        }
        if (this.fVU != null) {
            this.fVU.bIL();
        }
        if (this.fVh != null) {
            this.fVh.bDW();
            this.fVh.setVisible(8);
        }
        if (this.fVm != null) {
            this.fVm.vH();
        }
        if (this.fVl != null) {
            this.fVl.release();
        }
        if (this.bbS != null) {
            this.bbS.removeAllViews();
            this.bbS = null;
        }
        if (this.fXz != null) {
            this.fXz.removeAllViews();
            this.fXz = null;
        }
        if (this.fWf != null) {
            this.fWf.onDestroy();
        }
        if (this.fVn != null) {
            this.fVn.vH();
        }
        if (this.fVA != null) {
            this.fVA.cancel();
        }
        if (this.fWY != null) {
            this.fWY.bCS();
        }
        if (this.fVA != null) {
            this.fVA.vH();
        }
        if (this.fWI != null) {
            this.fWI.vH();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void bT(boolean z) {
        super.bT(z);
        bAU();
        if (this.fVg != null) {
            this.fVg.onDestroy();
        }
        if (this.fVi != null) {
            this.fVi.onDestroy();
        }
        if (this.fVk != null) {
            this.fVk.onDestroy();
        }
        if (this.fVm != null) {
            this.fVm.onDestroy();
        }
        if (this.fVn != null) {
            this.fVn.onDestroy();
        }
        if (this.fVo != null) {
            this.fVo.onDestroy();
        }
        if (this.fVp != null) {
            this.fVp.onDestroy();
        }
        if (this.fWr != null) {
            this.fWr.onDestroy();
        }
        if (this.fVh != null) {
            this.fVh.onDestroy();
        }
        if (this.fVf != null) {
            this.fVf.onDestroy();
        }
        if (this.fWj != null) {
            this.fWj.onDestroy();
        }
        if (this.fVU != null) {
            this.fVU.onDestory();
        }
        if (this.fVl != null) {
            this.fVl.release();
        }
        if (this.fWY != null) {
            this.fWY.bT(!z);
        }
        if (this.fVA != null) {
            this.fVA.onDestroy();
            this.fVA = null;
        }
        if (this.fWI != null) {
            this.fWI.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.fVB);
        MessageManager.getInstance().removeMessageRule(this.fVC);
        MessageManager.getInstance().unRegisterListener(this.fVE);
        MessageManager.getInstance().unRegisterListener(this.fVF);
        MessageManager.getInstance().unRegisterListener(this.fVG);
        MessageManager.getInstance().unRegisterListener(this.fVI);
        MessageManager.getInstance().unRegisterListener(this.fVJ);
        MessageManager.getInstance().unRegisterListener(this.fXD);
        MessageManager.getInstance().unRegisterListener(this.fVK);
        MessageManager.getInstance().unRegisterListener(this.fVH);
    }

    private void bAU() {
        if (this.fWj != null && this.fWj.Da().getView() != null && this.fWj.Da().getView().getParent() != null) {
            ((ViewGroup) this.fWj.Da().getView().getParent()).removeView(this.fWj.Da().getView());
        }
        if (this.fVs != null && this.fVs.getParent() != null) {
            ((ViewGroup) this.fVs.getParent()).removeView(this.fVs);
        }
        if (this.fWj != null && this.fWj.Db().getView() != null) {
            this.fWK.removeView(this.fWj.Db().getView());
        }
        if (this.fWj != null) {
            this.fWj.Da().setMsgData(new LinkedList());
            this.fWj.Cz();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void a(ae aeVar) {
        if (this.fWj != null) {
            bBr();
            this.fWj.Db().setEditText(" @" + aeVar.getNameShow() + " ");
        }
        if (this.fVU != null) {
            this.fVU.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void g(com.baidu.live.data.a aVar) {
        if (this.fWj != null) {
            bBr();
            this.fWj.Db().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.fVU != null) {
            this.fVU.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void b(ae aeVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected View bAV() {
        if (this.fWj != null) {
            return this.fWj.Db().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean bAW() {
        if (this.fWj == null || !this.fWj.Db().EM()) {
            return false;
        }
        kC(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean bAX() {
        return this.fVg == null || this.fVg.bAX();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    /* renamed from: bCi */
    public PendantParentView bAY() {
        return this.bbS;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup bAZ() {
        return this.fXz;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 24009) {
            if (i2 == -1) {
                if (intent != null && "ala_live_room_show_gift_panel".equals(intent.getStringExtra("ala_live_room_show_panel_key"))) {
                    int intExtra = intent.getIntExtra("ala_live_room_gift_panel_tab_id", -1);
                    int intExtra2 = intent.getIntExtra("ala_live_room_gift_panel_category_id", -1);
                    int intExtra3 = intent.getIntExtra("ala_live_room_gift_panel_gift_id", -1);
                    this.fWO = false;
                    L(intExtra, intExtra2, intExtra3);
                    return;
                }
                bAO();
                return;
            }
            bBQ();
        } else if (i == 25051 && i2 == -1 && this.fWY != null) {
            this.fWY.bEy();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.fWj != null && this.fWj.Da() != null) {
            this.fWj.Da().onKeyboardVisibilityChanged(z);
        }
        if (z || this.fWj == null || this.fWj.Db() == null || !this.fWj.Db().EM()) {
            if (z) {
                if (this.fVU != null) {
                    this.fVU.setVisibility(8);
                }
                if (this.fWl != null && this.fWl.yz() != null) {
                    this.fWl.yz().setVisibility(8);
                }
                bBb();
                if (this.fWj != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fWj.Db().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.fWj.Db().getView().setLayoutParams(layoutParams);
                    this.fWj.Db().getView().setVisibility(0);
                    this.fWj.Db().setQuickInputPanelVisible(false);
                }
                if (this.fWJ != null) {
                    this.fWJ.setVisibility(8);
                }
                if (this.fVl != null) {
                    this.fVl.setVisible(8);
                }
                if (this.fWk != null) {
                    this.fWk.Dk();
                }
                if (this.fWH != null) {
                    this.fWH.setCanVisible(false);
                }
            } else {
                bBa();
            }
            bCf();
            if (this.fWw != null) {
                this.fWw.bd(z);
            }
        }
    }

    private void bBa() {
        if (this.fVU != null) {
            this.fVU.setVisibility(0);
        }
        if (this.fVs != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fVs.getLayoutParams();
            layoutParams.bottomMargin = bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
            this.fVs.setLayoutParams(layoutParams);
        }
        if (this.fWj != null) {
            bBs();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fWj.Db().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.fWj.Db().getView().setLayoutParams(layoutParams2);
        }
        if (this.fVU != null) {
            this.fVU.setVisibility(0);
        }
        if (this.fWl != null && this.fWl.yz() != null) {
            this.fWl.yz().setVisibility(0);
        }
        if (this.fWJ != null) {
            this.fWJ.setVisibility(0);
        }
        if (this.fVl != null) {
            this.fVl.setVisible(0);
        }
        if (this.fWk != null) {
            this.fWk.Dk();
        }
        if (this.fWH != null) {
            this.fWH.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBb() {
        boolean z;
        boolean z2 = false;
        if (this.fVs != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fVs.getLayoutParams();
            if (this.fWj == null || this.fWj.Db() == null) {
                z = false;
            } else {
                z = this.fWj.Db().EK();
                z2 = this.fWj.Db().EL();
            }
            int F = F(z, z2);
            if (layoutParams.bottomMargin != F) {
                layoutParams.bottomMargin = F;
                this.fVs.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kC(boolean z) {
        if (z) {
            this.fWj.Db().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fVs.getLayoutParams();
            int quickInputPanelExpandHeight = this.fWj.Db().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.fVs.setLayoutParams(layoutParams);
                if (this.fWj.Da() != null) {
                    this.fWj.Da().CZ();
                    return;
                }
                return;
            }
            return;
        }
        bBa();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.fVf != null) {
                this.fVf.cA(i3);
            }
            if (this.fVh != null) {
                this.fVh.cA(i3);
            }
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public boolean cG(int i) {
        boolean cG = super.cG(i);
        if (cG && 2 == i) {
            if (this.fVg.bAX()) {
                return false;
            }
            if (cG && this.fWf != null) {
                this.fWf.lC(false);
            }
        }
        return cG;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void ro(int i) {
        super.ro(i);
        if (i == 7 || i == 11) {
            if (this.fVU != null) {
                this.fVU.setVisibility(8);
            }
            if (this.fWj != null) {
                this.fWj.Da().getView().setVisibility(4);
            }
            if (this.fVl != null) {
                this.fVl.bx(2, 8);
                if (this.fXB) {
                    this.fVl.bx(1, 8);
                }
            }
            if (this.fWz != null) {
                this.fWz.lx(false);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public void cH(int i) {
        super.cH(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public void cI(int i) {
        super.cI(i);
        if (i == 7 || i == 11) {
            if (this.fVU != null) {
                this.fVU.setVisibility(0);
            }
            if (this.fWj != null) {
                this.fWj.Da().getView().setVisibility(0);
            }
            if (this.fVl != null) {
                this.fVl.setVisible(0);
            }
            if (this.fWz != null) {
                this.fWz.lx(true);
            }
            this.fWJ.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.fVi != null) {
            this.fVi.bJc();
        }
        if (this.fVn != null) {
            this.fVn.vP();
        }
        if (this.fVl != null) {
            this.fVl.onStop();
        }
        if (this.fVm != null) {
            this.fVm.aT(true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.fVi != null) {
            this.fVi.bJb();
        }
        if (this.fVn != null && this.fXC) {
            this.fVn.vQ();
        }
        if (this.fVl != null) {
            this.fVl.onStart();
        }
        if (this.fVm != null) {
            this.fVm.aT(false);
        }
    }
}
