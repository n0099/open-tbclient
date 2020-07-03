package com.baidu.tieba.ala.liveroom.c;

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
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.ae;
import com.baidu.live.data.bb;
import com.baidu.live.data.bl;
import com.baidu.live.data.br;
import com.baidu.live.data.o;
import com.baidu.live.data.q;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.n;
import com.baidu.live.gift.z;
import com.baidu.live.guardclub.e;
import com.baidu.live.guardclub.j;
import com.baidu.live.im.k;
import com.baidu.live.im.l;
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
import com.baidu.tieba.ala.liveroom.i.b;
import com.baidu.tieba.ala.liveroom.i.g;
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.recommend.a;
import com.baidu.tieba.ala.liveroom.turntable.d;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends b {
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
    private l fVq;
    private com.baidu.tieba.ala.liveroom.share.b fVr;
    private FrameLayout fVs;
    private FrameLayout fVt;
    private ImageView fVu;
    private com.baidu.live.tieba.e.b fVv;
    private z fVz;
    private long lastClickTime = 0;
    private boolean fVw = false;
    private boolean fVx = false;
    private Handler fVy = new Handler();
    private HttpRule fVB = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.fVn != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.fVn.vV()) {
                httpMessage.addParam("ala_challenge_id", a.this.fVn.vY());
            }
            return httpMessage;
        }
    };
    private HttpRule fVC = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.c.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.fVn != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.fVn.vV()) {
                httpMessage.addParam("challenge_id", a.this.fVn.vY());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c fVD = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.c.a.19
        @Override // com.baidu.live.liveroom.g.c
        public void FS() {
            if (a.this.fWf != null) {
                a.this.fWf.lC(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bV(boolean z) {
            if (z) {
                if (a.this.fVU != null) {
                    a.this.fVU.rV(8);
                }
                if (a.this.fWf != null) {
                    a.this.fWf.lC(true);
                }
            } else {
                if (a.this.fVU != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                        a.this.fVU.rV(0);
                    } else {
                        a.this.fVU.rV(8);
                    }
                }
                if (a.this.fWf != null) {
                    a.this.fWf.lC(false);
                }
            }
            if (a.this.fWw != null) {
                a.this.fWw.be(z);
            }
        }
    };
    private HttpMessageListener fVE = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.a.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Gc() != null) {
                        com.baidu.live.v.c.Hr().bed = getQuickGiftHttpResponseMessage.Gc();
                        a.this.bAF();
                    }
                }
            }
        }
    };
    private CustomMessageListener fVF = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.a.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bAQ();
        }
    };
    private CustomMessageListener fVG = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                a.this.fWm.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fVH = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.fWA != null) {
                    a.this.fWA.Dc(str);
                }
            }
        }
    };
    CustomMessageListener fVI = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.fWQ != null && a.this.fWQ.aRm != null && !a.this.fWQ.aRp && !a.this.fWQ.aRq && a.this.fWv != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.bBS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = a.this.bBS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                a.this.fWv.b(a.this.fVs, layoutParams);
                if (e.Cg() != null) {
                    e.Cg().Cm();
                }
            }
        }
    };
    private CustomMessageListener fVJ = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (a.this.fWy != null) {
                    a.this.fWy.dismiss();
                }
                m.Dm().setSwitchStatus(true);
                m.Dm().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bBr();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener fVK = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.c.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.fVA.c(a.this.bBS());
                } else if (a.this.bBl() || !g.rx(2913168)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, 3000L);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.bBS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.bBS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    a.this.fVA.b(a.this.fVs, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b fVL = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.a.10
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
            if (currentTimeMillis - a.this.lastClickTime >= 300) {
                a.this.lastClickTime = currentTimeMillis;
                if (i == 2 && a.this.Bp()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel"));
                    a.this.L(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.v.c.Hr().bed.yI().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.v.c.Hr().bed.yI().xM());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.v.c.Hr().bed.yI().xN());
                        if (a.this.bBS().gfS.FU() != null && a.this.bBS().gfS.FU().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.bBS().gfS.FU().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.bBS().gfS.FU().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.Ep());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.Bp()) {
                        if (com.baidu.live.c.vf().getBoolean("quick_gift_guide_show", true) && !a.this.bBl()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, z.class, a.this.bBS().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                z zVar = (z) runTask.getData();
                                zVar.setPageContext(a.this.bBS().pageContext);
                                zVar.d(a.this.bBS().gfS.FU());
                                zVar.setGiftItem(com.baidu.live.v.c.Hr().bed.yI());
                                zVar.setOtherParams(a.this.Ep());
                                zVar.initView();
                                zVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.10.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        a.this.kF(false);
                                        a.this.fVz = null;
                                    }
                                });
                                a.this.fVz = zVar;
                                zVar.show();
                                a.this.kF(true);
                                return;
                            }
                            return;
                        }
                        n.a(a.this.bBS().pageContext, a.this.bBS().gfS.FU(), com.baidu.live.v.c.Hr().bed.yI(), a.this.Ep());
                    }
                } else if (i == 1) {
                    if (a.this.fWj != null) {
                        a.this.bBr();
                    }
                } else if (i == 3 && a.this.Bp()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    if (a.this.mOrientation == 2 && TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.fVr != null) {
                            a.this.fVr.y(a.this.bBS().gfS.FU());
                        }
                    } else {
                        a.this.fVX.c(a.this.bBS().gfS.FU(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.bBS() != null && a.this.bBS().gfS != null && a.this.bBS().gfS.FU() != null && a.this.bBS().gfS.FU().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.bBS().gfS.FU().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.bBS().gfS.FU().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.bBS().gfS.FU().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.Ep());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.bBS() != null && a.this.bBS().gfS != null && a.this.bBS().gfS.FU() != null && a.this.bBS().gfS.FU().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.bBS().gfS.FU().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.bBS().gfS.FU().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.bBS().gfS.FU().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.Ep());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.aYR != null) {
                        a.this.aYR.bQ(false);
                    }
                } else if (i == 12) {
                    if (a.this.fWf != null) {
                        String valueOf = String.valueOf(a.this.bBS().gfS.FU().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.bBS().gfS.FU().mLiveInfo.room_id);
                        String str3 = null;
                        o oVar = a.this.bBS().gfS.FU().mLiveSdkInfo;
                        if (oVar != null && oVar.mCastIds != null) {
                            str3 = String.valueOf(a.this.bBS().gfS.FU().mLiveSdkInfo.mCastIds.axB);
                        }
                        a.this.fWf.ah(valueOf, valueOf2, str3);
                        if (com.baidu.live.liveroom.a.Fp().Fq()) {
                            a.this.bAQ();
                        }
                    }
                } else if (i == 14) {
                    q FU = a.this.bBS().gfS.FU();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.bBS().pageContext.getPageActivity(), FU.axp.userName, Long.toString(FU.axp.userId), Long.toString(FU.axp.charmCount), String.valueOf(FU.mLiveInfo.group_id), String.valueOf(FU.mLiveInfo.live_id), false, String.valueOf(FU.axp.userId), Long.toString(FU.axI.userId), FU.axI.userName, FU.axI.portrait, a.this.fVj.getCount(), a.this.Ep())));
                    LogManager.getCommonLogger().doClickGusetNumLog(FU.mLiveInfo.feed_id, a.this.fVj.getCount() + "", a.this.Ep());
                } else if (i == 11) {
                    a.this.bBu();
                    a.this.bBv();
                } else if (i == 16) {
                    if (a.this.bBS() != null && (bbVar2 = com.baidu.live.v.a.Hm().bdV) != null && (blVar2 = bbVar2.aCT) != null) {
                        String str4 = blVar2.aDQ.aDX;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (a.this.bBS().gfS != null && a.this.bBS().gfS.FU() != null && a.this.bBS().gfS.FU().mLiveInfo != null) {
                                j = a.this.bBS().gfS.FU().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", a.this.bBS().gfS.FU().mLiveInfo.room_id + "", a.this.bBS().gfS.FU().mLiveInfo.feed_id, a.this.Ep());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.bBS().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (a.this.bBS() != null) {
                        q qVar = null;
                        if (a.this.bBS().gfS != null) {
                            qVar = a.this.bBS().gfS.FU();
                        }
                        if (qVar != null && qVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.u.a.bJt().aZA != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.u.a.bJt().aZA.awR;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + qVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + qVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(a.this.bBS().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17) {
                    if (a.this.Bp() && a.this.bBS() != null && (bbVar = com.baidu.live.v.a.Hm().bdV) != null && (blVar = bbVar.aCT) != null && (brVar = blVar.aDR) != null && !TextUtils.isEmpty(brVar.webUrl)) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                        if (a.this.fWy != null && a.this.bBS().gfS != null && a.this.bBS().gfS.FU() != null) {
                            q FU2 = a.this.bBS().gfS.FU();
                            a.this.fWy.a(brVar.webUrl, FU2.mLiveInfo.live_id, FU2.axI.userId, FU2.axp.userId);
                            a.this.fVv.ch(false);
                            a.this.fVv.Ik();
                        }
                    }
                } else if (i == 18) {
                    if (a.this.fVx) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.fVx = !a.this.fVx;
                } else if (i == 19 && a.this.fVv != null) {
                    a.this.fVv.Ik();
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
        return false;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void m(q qVar) {
        super.m(qVar);
        g.bED();
        this.fVx = false;
        if (this.fWc != null) {
            this.fWc.b(this.fVL);
        }
        if (this.fVv == null) {
            this.fVv = new com.baidu.live.tieba.e.b(bBS().pageContext.getPageActivity());
            this.fVv.start();
        }
        this.fVv.ch(true);
        bBS().pageContext.getPageActivity().setRequestedOrientation(-1);
        bBS().gfT.setIsForceHandledTouch(false);
        bBS().gfT.setSwipeClearEnable(true);
        bBS().gfT.setOnLiveViewScrollListener(this.fVD);
        bBS().gfT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.fVy.removeCallbacksAndMessages(null);
                a.this.kz(false);
                if (!a.this.fVw) {
                    a.this.fVy.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.fVw) {
                                a.this.kz(false);
                            }
                        }
                    }, 5000L);
                }
            }
        });
        if (this.fWJ != null) {
            this.fWJ.setVisibility(0);
        }
        bAw();
        if (this.fWt != null) {
            this.fWt.a(qVar, this.bbS);
        }
        bAI();
        bBh();
        bAJ();
        bAv();
        bAN();
        bAK();
        kA(false);
        bBy();
        bBx();
        bAz();
        bAG();
        bAH();
        bBA();
        bAt();
        bAP();
        bAR();
        kG(true);
        bAy();
        bAF();
        bBJ();
        bAA();
        bAB();
        bAC();
        bAD();
        bAS();
        bBF();
        bAs();
        bBI();
        if (this.fWy != null && this.fWy.bJB() == null) {
            this.fWy.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.21
                @Override // com.baidu.tieba.ala.liveroom.turntable.d.a
                public void onDismiss() {
                    a.this.fVv.ch(true);
                }
            });
        }
        c(this.fgP);
        MessageManager.getInstance().registerListener(this.fVE);
        MessageManager.getInstance().registerListener(this.fVF);
        MessageManager.getInstance().registerListener(this.fVI);
        MessageManager.getInstance().registerListener(this.fVJ);
        MessageManager.getInstance().registerListener(this.fVK);
        MessageManager.getInstance().registerListener(this.fVH);
        MessageManager.getInstance().registerListener(this.fVG);
        bAT();
        bAM();
        if (this.mOrientation == 2) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(bBS().pageContext.getPageActivity());
            l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(bBS().pageContext.getPageActivity()));
        }
    }

    private void bAs() {
        if (this.fWF != null) {
            this.fWF.a(new a.InterfaceC0578a() { // from class: com.baidu.tieba.ala.liveroom.c.a.22
                @Override // com.baidu.tieba.ala.liveroom.recommend.a.InterfaceC0578a
                public void kD(boolean z) {
                    if (a.this.fVo != null) {
                        a.this.fVo.setNeedCloseRecommendFloat(z);
                    }
                    if (a.this.bBS().gfT.guc) {
                        if (a.this.fWf != null) {
                            a.this.fWf.lu(z);
                            a.this.fWf.lC(!z);
                        }
                        if (a.this.fWc != null) {
                            a.this.fWc.lu(z);
                            a.this.fWc.setPraiseEnable(!z);
                            a.this.fWc.lt(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kz(boolean z) {
        View yQ;
        if (bBS() != null && bBS().pageContext != null && bBS().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(bBS().pageContext.getPageActivity()) == 2 || z) {
                if (this.fWm != null && (yQ = this.fWm.yQ()) != null) {
                    if (this.fVw) {
                        yQ.setVisibility(0);
                    } else {
                        yQ.setVisibility(8);
                    }
                }
                if (this.fVw) {
                    if (this.fWJ != null) {
                        this.fWJ.setVisibility(0);
                    }
                    if (this.fWK != null) {
                        this.fWK.setVisibility(0);
                    }
                    if (this.bbS != null) {
                        this.bbS.setVisibility(0);
                    }
                    if (this.bbS != null) {
                        this.bbS.setVisibility(0);
                    }
                    if (this.fWl != null) {
                        this.fWl.bc(false);
                    }
                } else {
                    if (this.fWJ != null) {
                        this.fWJ.setVisibility(8);
                    }
                    if (this.fWK != null) {
                        this.fWK.setVisibility(8);
                    }
                    if (this.bbS != null) {
                        this.bbS.setVisibility(8);
                    }
                    if (this.bbS != null) {
                        this.bbS.setVisibility(8);
                    }
                    if (this.fWl != null) {
                        this.fWl.bc(true);
                    }
                }
                this.fVw = this.fVw ? false : true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, boolean z2) {
        ImageView imageView;
        View yz;
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view;
        }
        if (z) {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_off);
            }
            if (this.fVt != null) {
                this.fVt.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_on);
            }
            if (this.fVt != null) {
                this.fVt.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.fWl != null && (yz = this.fWl.yz()) != null) {
            if (z) {
                yz.setVisibility(8);
            } else {
                yz.setVisibility(0);
            }
        }
    }

    private void bAt() {
        CustomResponsedMessage runTask;
        if (this.fVq == null && (runTask = MessageManager.getInstance().runTask(2913164, l.class, bBS().pageContext)) != null) {
            this.fVq = (l) runTask.getData();
        }
        if (this.fVq != null) {
            this.fVq.setOtherParams(this.otherParams);
            this.fVq.a(new l.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.23
                @Override // com.baidu.live.im.l.a
                public void Dl() {
                    a.this.bBD();
                }
            });
        }
    }

    private void bAu() {
        if (this.fWe != null) {
            this.fWe.au(bBS().gfR.getLiveContainerView());
        }
    }

    private void bAv() {
        if (this.fVr == null) {
            this.fVr = new com.baidu.tieba.ala.liveroom.share.b(bBS().pageContext);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bL(int i) {
        super.bL(i);
        if (this.fVu != null && UtilHelper.getRealScreenOrientation(bBS().pageContext.getPageActivity()) != 2) {
            this.fVu.setVisibility(0);
        }
        bAu();
        if (this.fVo != null) {
            this.fVo.bL(i);
        }
        if (this.fVo == null || !this.fVo.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void kA(boolean z) {
        super.kA(z);
        this.fWl.bT(bBS().gfS.FU().mLiveInfo.screen_direction);
    }

    private void bAw() {
        if (this.bbS == null) {
            PendantParentView.Model model = PendantParentView.Model.HORIZONTAL;
            if (this.mOrientation == 2) {
                model = PendantParentView.Model.HORIZONTAL_FULL;
            }
            this.bbS = new PendantParentView(bBS().pageContext.getPageActivity(), model);
            bBS().gfT.addView(this.bbS, ((bBS().gfT.getView() == null || this.fWc == null || this.fWc.getView() == null) ? -1 : bBS().gfT.getView().indexOfChild(this.fWc.getView())) + 1, new RelativeLayout.LayoutParams(-1, bAx()));
            this.bbS.setDefaultItemMargin(bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            rp(this.mOrientation);
        }
    }

    private int bAx() {
        int bottom;
        int bottom2;
        if (bBS().aYU.getLivePlayer().getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bBS().aYU.getLivePlayer().getLayoutParams();
            bottom = layoutParams.topMargin + layoutParams.height;
        } else {
            bottom = bBS().aYU.getLivePlayer().getBottom();
        }
        if (bBS().gfT.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) bBS().gfT.getLayoutParams();
            bottom2 = layoutParams2.topMargin + layoutParams2.height;
        } else {
            bottom2 = bBS().gfT.getBottom();
        }
        return ((bottom2 - bottom) - bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
    }

    private void bAy() {
        if (this.fVl == null) {
            this.fVl = new com.baidu.tieba.ala.liveroom.activeview.b(bBS().pageContext);
        }
        if (bBS() != null && bBS().gfS != null) {
            this.fVl.CD(bBS().gfS.bII());
        }
        this.fVl.setOtherParams(Ep());
        this.fVl.b(bBS().gfS.FU(), true);
        this.fVl.setHost(false);
        this.fVl.a(1, this.bbS);
        this.fVl.a(2, this.bbS);
        this.fVl.setVisible(this.fWN ? 8 : 0);
    }

    private void bAz() {
        if (this.fWb != null && bBS() != null && bBS().gfS != null) {
            this.fWb.b(this.fWJ, bBS().gfS.FU());
        }
    }

    private void bAA() {
        if (this.bbS != null) {
            if (this.fVk == null) {
                this.fVk = new com.baidu.tieba.ala.liveroom.k.a(bBS().pageContext, this);
            }
            this.fVk.setOtherParams(Ep());
            this.fVk.a((ViewGroup) this.bbS, bAE());
            this.fVk.u(bBS().gfS.FU());
        }
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
            this.fVU.a(new a.InterfaceC0576a() { // from class: com.baidu.tieba.ala.liveroom.c.a.7
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0576a
                public void bz(int i, int i2) {
                    q FU = a.this.bBS().gfS.FU();
                    if (FU != null && FU.mLiveInfo != null) {
                        if (a.this.fWz == null) {
                            a.this.fWz = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.bBS().pageContext.getPageActivity());
                        }
                        a.this.fWz.d(a.this.fWK, i, i2);
                        a.this.fWz.a(String.valueOf(FU.mLiveInfo.live_id), new a.InterfaceC0583a() { // from class: com.baidu.tieba.ala.liveroom.c.a.7.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0583a
                            public void a(float f, String str) {
                                if (a.this.fVU != null) {
                                    a.this.fVU.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0576a
                public void bA(int i, int i2) {
                    if (a.this.fWz != null) {
                        a.this.fWz.bF(i, i2);
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
            this.fVA = new com.baidu.tieba.ala.liveroom.i.b(bBS().pageContext, Ep(), this.fWY, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.8
                @Override // com.baidu.tieba.ala.liveroom.i.b.a
                public void bBc() {
                    a.this.kF(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.i.b.a
                public void bBd() {
                    a.this.kF(false);
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
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = bBS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAF() {
        if (this.fVU == null) {
            bAK();
        }
        this.fVU.a(com.baidu.live.v.c.Hr().bed, bBS().gfS.FU());
    }

    private void bAG() {
        CustomResponsedMessage runTask;
        if (this.fWj == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, bBS().pageContext)) != null && runTask.getData() != null) {
            this.fWj = (k) runTask.getData();
            this.fWj.setFromMaster(false);
            this.fWj.Da().getView().setId(a.g.ala_liveroom_msg_list);
            this.fWj.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.9
                @Override // com.baidu.live.im.k.a
                public boolean Dd() {
                    return a.this.Bp();
                }

                @Override // com.baidu.live.im.k.a
                public void De() {
                    a.this.fWR = true;
                }

                @Override // com.baidu.live.im.k.a
                public void fw(String str) {
                    if (!a.this.fWN) {
                        a.this.kC(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.bBS().pageContext.getPageActivity(), a.this.bBS().gfR.getLiveContainerView());
                    }
                    a.this.CI(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Df() {
                    if (a.this.fWN) {
                        a.this.kC(true);
                        a.this.bBS().gfR.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.bBS().pageContext.getPageActivity(), a.this.bBS().gfR.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (a.this.fWj != null) {
                        a.this.fWj.Db().setQuickInputPanelVisible(false);
                        a.this.fWj.Db().EN();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Dg() {
                    if (a.this.fWN) {
                        a.this.bBb();
                        if (a.this.fWk != null) {
                            a.this.fWk.Dk();
                        }
                        if (a.this.fVq != null) {
                            a.this.fVq.Dk();
                        }
                    } else if (a.this.fWj != null) {
                        a.this.fWj.Db().setQuickInputPanelVisible(false);
                        a.this.fWj.Db().EN();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Dh() {
                    return a.this.bBm();
                }

                @Override // com.baidu.live.im.k.a
                public int Di() {
                    return a.this.bBn();
                }
            });
            this.fVs = new FrameLayout(bBS().pageContext.getPageActivity());
            this.fVs.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.fWj != null && this.fVs != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bBS().pageContext.getPageActivity()) * 0.75f);
            int dimensionPixelSize = bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds120) + ((int) (BdUtilHelper.getEquipmentHeight(bBS().pageContext.getPageActivity()) * 0.33f));
            if (this.fWK.indexOfChild(this.fVs) < 0) {
                if (this.fVs.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fVs.getParent()).removeView(this.fVs);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                this.fWK.addView(this.fVs, layoutParams);
            }
            if (this.fVs.indexOfChild(this.fWj.Da().getView()) < 0) {
                if (this.fWj.Da().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fWj.Da().getView()).removeView(this.fWj.Da().getView());
                }
                if (UtilHelper.getRealScreenOrientation(bBS().pageContext.getPageActivity()) != 2) {
                    this.fVs.addView(this.fWj.Da().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, dimensionPixelSize));
                }
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

    private void bAH() {
        if (this.fVt == null) {
            this.fVt = new FrameLayout(bBS().pageContext.getPageActivity());
            this.fVt.setId(a.g.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void bAI() {
        if (this.fVg == null) {
            this.fVg = new com.baidu.tieba.ala.liveroom.m.a(bBS().pageContext, false, this);
        }
        this.fVg.c(this.fWJ, bBS().gfS.FU());
        this.fVg.a(this.fVL);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void bAQ() {
        String str;
        if (bBS() != null && bBS().gfS != null && bBS().gfS.FU() != null && bBS().gfS.FU().axI != null && (str = bBS().gfS.FU().axI.userName) != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bBS().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !bBl()) {
            com.baidu.live.c.vf().putInt("guide_rename_show_count", com.baidu.live.c.vf().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.Fp().bP(true);
            if (this.fWC == null) {
                this.fWC = new com.baidu.tieba.ala.liveroom.t.a(bBS().pageContext);
            }
            this.fWC.setOtherParams(Ep());
            this.fWC.e(this.fWK, bBS().gfS.FU());
            kF(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.12
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fWC.bJi();
                    a.this.kF(false);
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
        if (this.fWf == null) {
            this.fWf = new com.baidu.tieba.ala.liveroom.w.a(bBS().pageContext, this);
        }
        this.fWf.d(bBS().gfT, false);
        this.fWf.lB(bBR());
    }

    private void bAS() {
        if (bBS() != null && bBS().aYU != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(bBS().pageContext.getPageActivity());
            Activity pageActivity = bBS().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + pageActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds176)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.fVu = new ImageView(bBS().pageContext.getPageActivity());
            this.fVu.setVisibility(8);
            this.fVu.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.fVu.setImageResource(a.f.icon_live_enlarge);
            this.fVu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.fVv != null) {
                        a.this.fVv.Ij();
                        a.this.fVu.setVisibility(4);
                    }
                }
            });
            bBS().gfT.addView(this.fVu, layoutParams);
            if (UtilHelper.getRealScreenOrientation(bBS().pageContext.getPageActivity()) != 2) {
                if (bBS().gfY) {
                    this.fVu.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.14
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.fVu != null && UtilHelper.getRealScreenOrientation(a.this.bBS().pageContext.getPageActivity()) != 2) {
                                a.this.fVu.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
        }
    }

    private void bAT() {
        if (this.fWR || this.fWS) {
            if ((TbadkCoreApplication.isLogin() && this.fWj.Db().hasText()) || this.fWS) {
                this.fWR = false;
                this.fWS = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.15
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bBr();
                    }
                }, 500L);
            }
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
            e.printStackTrace();
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
        if (this.fVq != null) {
            this.fVq.a(qVar);
        }
        if (this.fVl != null) {
            this.fVl.j(qVar);
            if (qVar != null && this.fWG != null && !this.fWG.hasInit && !TextUtils.isEmpty(this.fWG.aDn)) {
                this.fWG.hasInit = true;
                this.fVl.CF(this.fWG.aDn);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(com.baidu.live.data.k kVar) {
        if (kVar != null) {
            if (this.fVf != null && kVar.getList() != null) {
                this.fVf.e(kVar);
            }
            if (this.fVj != null) {
                this.fVj.dp(kVar.getCount());
            }
        }
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
        if (this.fVn != null) {
            this.fVn.vH();
        }
        if (this.fVq != null) {
            this.fVq.a((l.a) null);
            this.fVq.Cz();
        }
        if (this.fVu != null && (this.fVu.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fVu.getParent()).removeView(this.fVu);
        }
        if (this.fVr != null) {
            this.fVr.dismiss();
        }
        if (this.fVv != null) {
            this.fVv.ch(false);
            this.fVv.Ik();
        }
        if (this.fVA != null) {
            this.fVA.vH();
        }
        if (this.fWY != null) {
            this.fWY.bCS();
        }
        if (this.fWI != null) {
            this.fWI.vH();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void n(q qVar) {
        View Dj;
        super.n(qVar);
        if (this.fVq != null && (Dj = this.fVq.Dj()) != null && Dj.getParent() != null) {
            ((ViewGroup) Dj.getParent()).removeView(Dj);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.fVq != null) {
            this.fVq.setOtherParams(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void bT(boolean z) {
        super.bT(z);
        this.fVy.removeCallbacksAndMessages(null);
        bAU();
        this.fVw = false;
        this.fVx = false;
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
        if (this.fVr != null) {
            this.fVr.onDestroy();
        }
        if (this.fVh != null) {
            this.fVh.onDestroy();
        }
        if (this.fVv != null) {
            this.fVv.stop();
        }
        if (this.fWf != null) {
            this.fWf.onDestroy();
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
        if (this.fVq != null) {
            this.fVq.a((l.a) null);
            this.fVq.release();
            this.fVq = null;
        }
        if (this.fWY != null) {
            this.fWY.bT(z ? false : true);
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
        MessageManager.getInstance().unRegisterListener(this.fVI);
        MessageManager.getInstance().unRegisterListener(this.fVJ);
        MessageManager.getInstance().unRegisterListener(this.fVK);
        MessageManager.getInstance().unRegisterListener(this.fVH);
        MessageManager.getInstance().unRegisterListener(this.fVG);
    }

    private void bAU() {
        if (this.fWj != null && this.fWj.Da().getView() != null && this.fWj.Da().getView().getParent() != null) {
            ((ViewGroup) this.fWj.Da().getView().getParent()).removeView(this.fWj.Da().getView());
        }
        if (this.fVs != null && this.fVs.getParent() != null) {
            ((ViewGroup) this.fVs.getParent()).removeView(this.fVs);
        }
        if (this.fVt != null && this.fVt.getParent() != null) {
            ((ViewGroup) this.fVt.getParent()).removeView(this.fVt);
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

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup bAY() {
        return this.bbS;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup bAZ() {
        return null;
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
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.fWN;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(bBS().pageContext.getPageActivity()) || z2) {
            kB(z);
        }
    }

    private void kB(boolean z) {
        int dimensionPixelSize;
        if (this.fWj != null && this.fWj.Da() != null) {
            this.fWj.Da().onKeyboardVisibilityChanged(z);
        }
        if (z || this.fWj == null || !this.fWj.Db().EM()) {
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
            if (this.fWj != null && this.fVs != null) {
                int equipmentHeight = (int) ((z ? 0.2f : 0.33f) * BdUtilHelper.getEquipmentHeight(bBS().pageContext.getPageActivity()));
                if (z) {
                    dimensionPixelSize = equipmentHeight + bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64);
                } else {
                    dimensionPixelSize = equipmentHeight + bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
                }
                if (this.fWK.indexOfChild(this.fVs) != -1 && this.fVs.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fVs.getLayoutParams();
                    layoutParams2.height = dimensionPixelSize;
                    this.fVs.setLayoutParams(layoutParams2);
                }
                if (this.fVs.indexOfChild(this.fWj.Da().getView()) != -1 && this.fWj.Da().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.fWj.Da().getView().getLayoutParams();
                    layoutParams3.height = dimensionPixelSize;
                    this.fWj.Da().getView().setLayoutParams(layoutParams3);
                }
                this.fWj.Da().CZ();
            }
        }
    }

    private void bBa() {
        if (this.fVU != null) {
            this.fVU.setVisibility(0);
        }
        if (this.fVs != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fVs.getLayoutParams();
            layoutParams.bottomMargin = bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
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
        if (this.fWJ != null && (!this.fVw || UtilHelper.getRealScreenOrientation(bBS().pageContext.getPageActivity()) != 2)) {
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
        FrameLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        FrameLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = bBS().pageContext.getPageActivity();
        if (i3 == 1) {
            if (this.fWJ != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.fWJ.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.fVr != null) {
                this.fVr.dismiss();
            }
            if (this.fVq != null) {
                this.fVq.a((l.a) null);
                this.fVq.Cz();
            }
            if (this.aYR != null) {
                this.aYR.e(true, true);
            }
            if (this.fVu != null) {
                this.fVu.setVisibility(0);
                this.fVu.bringToFront();
            }
            if (this.fWa != null) {
                this.fWa.setVisibility(0);
            }
            if (this.fWj != null && this.fWj.Da().getView().getParent() != null && (this.fWj.Da().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.fWj.Da().getView().getParent()).removeView(this.fWj.Da().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bBS().pageContext.getPageActivity()) * 0.75f);
            int equipmentHeight = ((int) (BdUtilHelper.getEquipmentHeight(bBS().pageContext.getPageActivity()) * 0.33f)) + bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
            if (this.fVs != null && this.fWj != null) {
                this.fVs.addView(this.fWj.Da().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, equipmentHeight));
            }
            if (this.fVt != null && (this.fVt.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.fVt.getParent()).removeView(this.fVt);
            }
            if (this.fWk != null) {
                this.fWk.a(bBS().gfS.FU(), false);
                this.fWk.a(new l.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.16
                    @Override // com.baidu.live.im.l.a
                    public void Dl() {
                        a.this.bBD();
                    }
                });
                View Dj = this.fWk.Dj();
                if (Dj != null && this.fWK != null && Dj.getParent() == null) {
                    Resources resources = bBS().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bBS().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds98));
                    layoutParams5.addRule(2, a.g.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                    this.fWK.addView(Dj, layoutParams5);
                }
            }
            if (this.fWc != null) {
                this.fWc.setPraiseEnable(true);
                bBS().gfT.guc = true;
            }
            if (this.fVf != null && this.fVf.fXV != null && (layoutParams3 = (FrameLayout.LayoutParams) this.fVf.fXV.getLayoutParams()) != null) {
                layoutParams3.width = -2;
                this.fVf.fXV.setLayoutParams(layoutParams3);
            }
            if (this.fWf != null) {
                this.fWf.bKC();
            }
            if (this.fVw) {
                kz(true);
            }
            if (this.fVx) {
                if (this.fVU != null && this.fVU.getLandscapeBarrageImageView() != null) {
                    b(this.fVU.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.fVj != null) {
                this.fVj.kM(true);
            }
            this.fVy.removeCallbacksAndMessages(null);
            if (this.fVk != null) {
                this.fVk.setCanVisible(true);
                this.fVk.u(bBS().gfS.FU());
            }
        } else if (i3 == 2) {
            if (this.fWf != null) {
                this.fWf.bKD();
            }
            if (this.fWJ != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.fWJ.getLayoutParams()) != null) {
                layoutParams2.topMargin = bBS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
            }
            if (this.fWk != null) {
                this.fWk.a((l.a) null);
                this.fWk.Cz();
            }
            bBS().gfT.bKe();
            if (this.aYR != null) {
                this.aYR.e(false, true);
            }
            if (this.fVu != null) {
                this.fVu.setVisibility(4);
            }
            if (this.fWj != null && this.fWj.Da().getView().getParent() != null && (this.fWj.Da().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.fWj.Da().getView().getParent()).removeView(this.fWj.Da().getView());
            }
            int max = Math.max(i, i2);
            if (this.fVt != null) {
                if (this.fVt.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fVt.getParent()).removeView(this.fVt);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
                bBS().gfT.addView(this.fVt, layoutParams6);
            }
            if (this.fVt != null && this.fVq != null) {
                this.fVq.a(bBS().gfS.FU(), false);
                this.fVq.a(new l.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.17
                    @Override // com.baidu.live.im.l.a
                    public void Dl() {
                        a.this.bBD();
                    }
                });
                View Dj2 = this.fVq.Dj();
                if (Dj2 != null && this.fVt.indexOfChild(Dj2) < 0) {
                    this.fVt.addView(Dj2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bBS().pageContext.getPageActivity()), -1));
                }
            }
            if (this.fWc != null) {
                this.fWc.ax(bBS().gfT);
                this.fWc.setPraiseEnable(false);
                bBS().gfT.guc = false;
            }
            if (this.fVf != null && this.fVf.fXV != null && (layoutParams = (FrameLayout.LayoutParams) this.fVf.fXV.getLayoutParams()) != null) {
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                layoutParams.width = (int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f);
                this.fVf.fXV.setLayoutParams(layoutParams);
            }
            if (this.fVj != null) {
                this.fVj.kM(false);
            }
            if (ac.yZ() != null) {
                ac.yZ().yY();
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.x.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.x.c) runTask.getData()).yY();
            }
            if (this.fVU != null && this.fVU.getLandscapeBarrageImageView() != null) {
                b(this.fVU.getLandscapeBarrageImageView(), this.fVx, false);
            }
            this.fVy.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.18
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.fVw) {
                        a.this.kz(false);
                    }
                }
            }, 5000L);
            if (this.fWl != null) {
                this.fWl.yB();
            }
            if (this.fVk != null) {
                this.fVk.setCanVisible(false);
                this.fVk.bEJ();
            }
        }
        if (this.fWm != null) {
            if (i3 == 2) {
                View yQ = this.fWm.yQ();
                if (yQ != null) {
                    if (yQ.getParent() != null && (yQ.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) yQ.getParent()).removeView(yQ);
                    }
                    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams7.addRule(5, a.g.ala_liveroom_hostheader);
                    layoutParams7.addRule(3, a.g.ala_liveroom_hostheader);
                    layoutParams7.topMargin = bBS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                    if (this.fWJ != null) {
                        this.fWJ.addView(yQ, layoutParams7);
                    }
                }
            } else {
                View yQ2 = this.fWm.yQ();
                if (yQ2 != null) {
                    if (yQ2.getParent() != null && (yQ2.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) yQ2.getParent()).removeView(yQ2);
                    }
                    RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams8.topMargin = bBS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18) * (-1);
                    layoutParams8.addRule(3, a.g.ala_live_header_view);
                    bBS().gfT.addView(yQ2, layoutParams8);
                }
            }
        }
        if (this.fVU != null) {
            this.fVU.l(i, i2, i3);
        }
        rp(i3);
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.fVf != null) {
                this.fVf.cA(i3);
            }
            if (this.fVh != null) {
                this.fVh.cA(i3);
            }
            if (this.fVl != null) {
                this.fVl.cA(i3);
            }
            if (this.fWp != null) {
                this.fWp.cA(i3);
            }
            if (this.fWy != null) {
                this.fWy.cA(i3);
            }
            if (this.fVz != null && this.fVz.isShowing()) {
                this.fVz.resize();
            }
            if (this.fWH != null) {
                this.fWH.cA(i3);
            }
            if (this.fWI != null) {
                this.fWI.cA(i3);
            }
        }
        if (this.fWl != null) {
            this.fWl.yA();
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
            if (i != 7 || UtilHelper.getRealScreenOrientation(bBS().pageContext.getPageActivity()) != 2) {
                if (this.fVU != null) {
                    this.fVU.setVisibility(8);
                }
                if (this.fWj != null) {
                    this.fWj.Da().getView().setVisibility(4);
                }
                if (this.fWz != null) {
                    this.fWz.lx(false);
                }
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
            if (this.fWz != null) {
                this.fWz.lx(true);
            }
            if (!this.fVw || UtilHelper.getRealScreenOrientation(bBS().pageContext.getPageActivity()) != 2) {
                this.fWJ.setVisibility(0);
            }
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
        if (bBS() != null) {
            BdUtilHelper.hideSoftKeyPad(bBS().pageContext.getPageActivity(), bBS().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.fVi != null) {
            this.fVi.bJb();
        }
        if (this.fVn != null) {
            this.fVn.vQ();
        }
        if (this.fVl != null) {
            this.fVl.onStart();
        }
    }

    private void rp(int i) {
        if (this.bbS != null) {
            int dimensionPixelSize = bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bbS.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                layoutParams.rightMargin = bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.height = bAx();
                this.bbS.setPosition(dimensionPixelSize, 0, dimensionPixelSize, 0);
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                int dimensionPixelSize2 = bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds72) + 0 + bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100) + bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
                layoutParams.height = -1;
                this.bbS.setPosition(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
            }
            layoutParams.bottomMargin = bBS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            this.bbS.setLayoutParams(layoutParams);
            this.bbS.setModel(i == 1 ? PendantParentView.Model.HORIZONTAL : PendantParentView.Model.HORIZONTAL_FULL);
        }
    }
}
