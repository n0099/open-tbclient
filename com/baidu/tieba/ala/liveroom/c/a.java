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
import com.baidu.live.challenge.i;
import com.baidu.live.challenge.j;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.as;
import com.baidu.live.data.bb;
import com.baidu.live.data.bh;
import com.baidu.live.data.h;
import com.baidu.live.data.z;
import com.baidu.live.gift.ab;
import com.baidu.live.gift.n;
import com.baidu.live.gift.y;
import com.baidu.live.guardclub.e;
import com.baidu.live.im.k;
import com.baidu.live.im.l;
import com.baidu.live.im.m;
import com.baidu.live.message.GetQuickGiftHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
import com.baidu.live.tbadk.core.atomdata.CommonWebViewActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.log.ILiveGoodsLogger;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.u.a;
import com.baidu.live.utils.o;
import com.baidu.live.view.PriorityVerticalLinearLayout;
import com.baidu.tieba.ala.liveroom.h.b;
import com.baidu.tieba.ala.liveroom.h.g;
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.turntable.d;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends b {
    private PriorityVerticalLinearLayout fvX;
    private LinearLayout fvY;
    private com.baidu.tieba.ala.liveroom.audiencelist.c fvZ;
    private com.baidu.tieba.ala.liveroom.l.a fwa;
    private com.baidu.tieba.ala.liveroom.e.b fwb;
    private com.baidu.tieba.ala.liveroom.r.b fwc;
    private com.baidu.tieba.ala.liveroom.operation.a fwd;
    private com.baidu.tieba.ala.liveroom.audiencelist.b fwe;
    private com.baidu.tieba.ala.liveroom.j.a fwf;
    private com.baidu.tieba.ala.liveroom.activeview.b fwg;
    private com.baidu.live.d.a fwh;
    private j fwi;
    private i fwj;
    private com.baidu.tieba.ala.liveroom.attentionpop.b fwk;
    private l fwl;
    private com.baidu.tieba.ala.liveroom.share.b fwm;
    private FrameLayout fwn;
    private FrameLayout fwo;
    private ImageView fwp;
    private com.baidu.live.tieba.e.b fwq;
    private y fwu;
    private com.baidu.tieba.ala.liveroom.h.b fwv;
    private long lastClickTime = 0;
    private boolean fwr = false;
    private boolean fws = false;
    private Handler fwt = new Handler();
    private HttpRule fww = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.fwi != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.fwi.uv()) {
                httpMessage.addParam("ala_challenge_id", a.this.fwi.uy());
            }
            return httpMessage;
        }
    };
    private HttpRule fwx = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.c.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.fwi != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.fwi.uv()) {
                httpMessage.addParam("challenge_id", a.this.fwi.uy());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c fwy = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.c.a.17
        @Override // com.baidu.live.liveroom.g.c
        public void DK() {
            if (a.this.fwX != null) {
                a.this.fwX.kX(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bK(boolean z) {
            if (z) {
                if (a.this.fwd != null) {
                    a.this.fwd.qU(8);
                }
                if (a.this.fwX != null) {
                    a.this.fwX.kX(true);
                }
            } else {
                if (a.this.fwd != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                        a.this.fwd.qU(0);
                    } else {
                        a.this.fwd.qU(8);
                    }
                }
                if (a.this.fwX != null) {
                    a.this.fwX.kX(false);
                }
            }
            if (a.this.fxo != null) {
                a.this.fxo.aZ(z);
            }
        }
    };
    private HttpMessageListener fwz = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.a.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.DU() != null) {
                        com.baidu.live.v.c.Es().aRJ = getQuickGiftHttpResponseMessage.DU();
                        a.this.brX();
                    }
                }
            }
        }
    };
    private CustomMessageListener fwA = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.a.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bsi();
        }
    };
    private CustomMessageListener fwB = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.c.a.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.fxs != null) {
                    a.this.fxs.AE(str);
                }
            }
        }
    };
    CustomMessageListener fwC = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.fxG != null && a.this.fxG.aIX != null && !a.this.fxG.aJa && !a.this.fxG.aJb && a.this.fxn != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.btg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = a.this.btg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                a.this.fxn.b(a.this.fwn, layoutParams);
                if (e.Aq() != null) {
                    e.Aq().Aw();
                }
            }
        }
    };
    private CustomMessageListener fwD = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (a.this.fxq != null) {
                    a.this.fxq.dismiss();
                }
                m.Bo().setSwitchStatus(true);
                m.Bo().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bsI();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener fwE = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.fwv.c(a.this.btg());
                } else if (a.this.bsC() || !g.qv(2913168)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, 3000L);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.btg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.btg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    a.this.fwv.b(a.this.fwn, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b fwF = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.a.8
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void l(View view, int i) {
            as asVar;
            bb bbVar;
            bh bhVar;
            String str;
            as asVar2;
            bb bbVar2;
            String str2;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - a.this.lastClickTime >= 300) {
                a.this.lastClickTime = currentTimeMillis;
                if (i == 2 && a.this.zz()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "gift_panel"));
                    a.this.M(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.v.c.Es().aRJ.wR().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.v.c.Es().aRJ.wR().vU());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.v.c.Es().aRJ.wR().vV());
                        if (a.this.btg().fFh.DM() != null && a.this.btg().fFh.DM().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.btg().fFh.DM().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.btg().fFh.DM().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.Cq());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.zz()) {
                        if (com.baidu.live.c.tG().getBoolean("quick_gift_guide_show", true) && !a.this.bsC()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, y.class, a.this.btg().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                y yVar = (y) runTask.getData();
                                yVar.setPageContext(a.this.btg().pageContext);
                                yVar.d(a.this.btg().fFh.DM());
                                yVar.setGiftItem(com.baidu.live.v.c.Es().aRJ.wR());
                                yVar.setOtherParams(a.this.Cq());
                                yVar.initView();
                                yVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.8.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        a.this.jY(false);
                                        a.this.fwu = null;
                                    }
                                });
                                a.this.fwu = yVar;
                                yVar.show();
                                a.this.jY(true);
                                return;
                            }
                            return;
                        }
                        n.a(a.this.btg().pageContext, a.this.btg().fFh.DM(), com.baidu.live.v.c.Es().aRJ.wR(), a.this.Cq());
                    }
                } else if (i == 1) {
                    if (a.this.fxb != null) {
                        a.this.bsI();
                    }
                } else if (i == 3 && a.this.zz()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "share_clk"));
                    if (a.this.mOrientation == 2 && TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.fwm != null) {
                            a.this.fwm.w(a.this.btg().fFh.DM());
                        }
                    } else {
                        a.this.fwQ.c(a.this.btg().fFh.DM(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.btg() != null && a.this.btg().fFh != null && a.this.btg().fFh.DM() != null && a.this.btg().fFh.DM().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.btg().fFh.DM().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.btg().fFh.DM().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.btg().fFh.DM().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.Cq());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.btg() != null && a.this.btg().fFh != null && a.this.btg().fFh.DM() != null && a.this.btg().fFh.DM().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.btg().fFh.DM().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.btg().fFh.DM().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.btg().fFh.DM().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.Cq());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.aPZ != null) {
                        a.this.aPZ.bF(false);
                    }
                } else if (i == 12) {
                    if (a.this.fwX != null) {
                        String valueOf = String.valueOf(a.this.btg().fFh.DM().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.btg().fFh.DM().mLiveInfo.room_id);
                        String str3 = null;
                        com.baidu.live.data.l lVar = a.this.btg().fFh.DM().mLiveSdkInfo;
                        if (lVar != null && lVar.mCastIds != null) {
                            str3 = String.valueOf(a.this.btg().fFh.DM().mLiveSdkInfo.mCastIds.aqw);
                        }
                        a.this.fwX.ac(valueOf, valueOf2, str3);
                        if (com.baidu.live.liveroom.a.Dk().Dl()) {
                            a.this.bsi();
                        }
                    }
                } else if (i == 14) {
                    com.baidu.live.data.n DM = a.this.btg().fFh.DM();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.btg().pageContext.getPageActivity(), DM.aqk.userName, Long.toString(DM.aqk.userId), Long.toString(DM.aqk.charmCount), String.valueOf(DM.mLiveInfo.group_id), String.valueOf(DM.mLiveInfo.live_id), false, String.valueOf(DM.aqk.userId), Long.toString(DM.aqD.userId), DM.aqD.userName, DM.aqD.portrait, a.this.fwe.getCount(), a.this.Cq())));
                    LogManager.getCommonLogger().doClickGusetNumLog(DM.mLiveInfo.feed_id, a.this.fwe.getCount() + "", a.this.Cq());
                } else if (i == 11) {
                    a.this.bsL();
                    a.this.bsM();
                } else if (i == 15) {
                    if (a.this.fxl != null && a.this.btg() != null && a.this.btg().fFh != null && a.this.btg().fFh.DM() != null && a.this.btg().fFh.DM().mLiveInfo != null) {
                        long j = a.this.btg().fFh.DM().mLiveInfo.live_id;
                        String valueOf3 = String.valueOf(a.this.btg().fFh.DM().mLiveInfo.feed_id);
                        long j2 = a.this.btg().fFh.DM().mLiveInfo.room_id;
                        String str4 = a.this.btg().fFh.DM().mLiveInfo.cover;
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        String str8 = "";
                        if (a.this.btg().fFh.DM().mLiveInfo.session_info != null) {
                            str5 = a.this.btg().fFh.DM().mLiveInfo.session_info.flvUrl;
                        }
                        if (!TextUtils.isEmpty(a.this.Cq())) {
                            try {
                                JSONObject jSONObject = new JSONObject(a.this.Cq());
                                str6 = jSONObject.optString("tab");
                                str7 = jSONObject.optString("tag");
                                str8 = jSONObject.optString("source");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        a.this.fxl.AE(o.a(valueOf3, j + "", j2, false, 1, str4, str5, str6, str7, str8, String.valueOf(a.this.btg().fFh.DM().mLiveInfo.user_id), a.this.btg().fFh.DM().mLiveInfo.user_name, String.valueOf(a.this.btg().fFh.DM().mLiveInfo.group_id), String.valueOf(a.this.btg().fFh.DM().aqk.userId)));
                        o.aXW = j;
                        if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                            ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                            LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf3, a.this.Cq());
                        }
                    }
                } else if (i == 16) {
                    if (a.this.btg() != null && (asVar2 = com.baidu.live.v.a.En().aRB) != null && (bbVar2 = asVar2.avA) != null) {
                        String str9 = bbVar2.aww.awC;
                        if (!TextUtils.isEmpty(str9)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "quick_gift"));
                            long j3 = 0;
                            if (a.this.btg().fFh != null && a.this.btg().fFh.DM() != null && a.this.btg().fFh.DM().mLiveInfo != null) {
                                j3 = a.this.btg().fFh.DM().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j3 + "", a.this.btg().fFh.DM().mLiveInfo.room_id + "", a.this.btg().fFh.DM().mLiveInfo.feed_id, a.this.Cq());
                            }
                            if (str9.contains("?")) {
                                str2 = str9 + "&liveId=" + j3;
                            } else {
                                str2 = str9 + "?liveId=" + j3;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.btg().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (a.this.btg() != null) {
                        com.baidu.live.data.n nVar = null;
                        if (a.this.btg().fFh != null) {
                            nVar = a.this.btg().fFh.DM();
                        }
                        if (nVar != null && nVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.t.a.bzX().aQF != null) {
                            String str10 = com.baidu.tieba.ala.liveroom.t.a.bzX().aQF.arb;
                            if (!TextUtils.isEmpty(str10)) {
                                if (str10.contains("?")) {
                                    str = str10 + "&live_id=" + nVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str10 + "?live_id=" + nVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(a.this.btg().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17) {
                    if (a.this.zz() && a.this.btg() != null && (asVar = com.baidu.live.v.a.En().aRB) != null && (bbVar = asVar.avA) != null && (bhVar = bbVar.awx) != null && !TextUtils.isEmpty(bhVar.webUrl)) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "turntable"));
                        if (a.this.fxq != null && a.this.btg().fFh != null && a.this.btg().fFh.DM() != null) {
                            com.baidu.live.data.n DM2 = a.this.btg().fFh.DM();
                            a.this.fxq.a(bhVar.webUrl, DM2.mLiveInfo.live_id, DM2.aqD.userId, DM2.aqk.userId);
                            a.this.fwq.bS(false);
                            a.this.fwq.Fg();
                        }
                    }
                } else if (i == 18) {
                    if (a.this.fws) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.fws = !a.this.fws;
                } else if (i == 19 && a.this.fwq != null) {
                    a.this.fwq.Fg();
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.fwS = new com.baidu.tieba.ala.liveroom.guide.c(btg().pageContext, this, false);
        this.fww.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.fww);
        this.fwx.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.fwx);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean brI() {
        return false;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void k(com.baidu.live.data.n nVar) {
        super.k(nVar);
        g.bvv();
        this.fws = false;
        if (this.fwV != null) {
            this.fwV.b(this.fwF);
        }
        if (this.fwq == null) {
            this.fwq = new com.baidu.live.tieba.e.b(btg().pageContext.getPageActivity());
            this.fwq.start();
        }
        this.fwq.bS(true);
        btg().pageContext.getPageActivity().setRequestedOrientation(-1);
        btg().fFi.setIsForceHandledTouch(false);
        btg().fFi.setSwipeClearEnable(true);
        btg().fFi.setOnLiveViewScrollListener(this.fwy);
        btg().fFi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.fwt.removeCallbacksAndMessages(null);
                a.this.jT(false);
                if (!a.this.fwr) {
                    a.this.fwt.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.fwr) {
                                a.this.jT(false);
                            }
                        }
                    }, 5000L);
                }
            }
        });
        if (this.fxz != null) {
            this.fxz.setVisibility(0);
        }
        brM();
        brP();
        bsa();
        bsy();
        bsb();
        brL();
        bsf();
        bsc();
        jU(false);
        bsP();
        bsO();
        brR();
        brY();
        brZ();
        bsR();
        brJ();
        bsh();
        bsj();
        jZ(true);
        brQ();
        brX();
        bsX();
        brS();
        brT();
        brU();
        brV();
        bsk();
        bsW();
        if (this.fxq != null && this.fxq.bAf() == null) {
            this.fxq.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.19
                @Override // com.baidu.tieba.ala.liveroom.turntable.d.a
                public void onDismiss() {
                    a.this.fwq.bS(true);
                }
            });
        }
        MessageManager.getInstance().registerListener(this.fwz);
        MessageManager.getInstance().registerListener(this.fwA);
        MessageManager.getInstance().registerListener(this.fwC);
        MessageManager.getInstance().registerListener(this.fwD);
        MessageManager.getInstance().registerListener(this.fwE);
        MessageManager.getInstance().registerListener(this.fwB);
        bsl();
        bse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jT(boolean z) {
        View wZ;
        if (btg() != null && btg().pageContext != null && btg().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(btg().pageContext.getPageActivity()) == 2 || z) {
                if (this.fxe != null && (wZ = this.fxe.wZ()) != null) {
                    if (this.fwr) {
                        wZ.setVisibility(0);
                    } else {
                        wZ.setVisibility(8);
                    }
                }
                if (this.fwr) {
                    if (this.fxz != null) {
                        this.fxz.setVisibility(0);
                    }
                    if (this.fxA != null) {
                        this.fxA.setVisibility(0);
                    }
                    if (this.fvY != null) {
                        this.fvY.setVisibility(0);
                    }
                    if (this.fvX != null) {
                        this.fvX.setVisibility(0);
                    }
                    if (this.fxd != null) {
                        this.fxd.aX(false);
                    }
                } else {
                    if (this.fxz != null) {
                        this.fxz.setVisibility(8);
                    }
                    if (this.fxA != null) {
                        this.fxA.setVisibility(8);
                    }
                    if (this.fvY != null) {
                        this.fvY.setVisibility(8);
                    }
                    if (this.fvX != null) {
                        this.fvX.setVisibility(8);
                    }
                    if (this.fxd != null) {
                        this.fxd.aX(true);
                    }
                }
                this.fwr = this.fwr ? false : true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, boolean z2) {
        ImageView imageView;
        View wI;
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view;
        }
        if (z) {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_off);
            }
            if (this.fwo != null) {
                this.fwo.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_on);
            }
            if (this.fwo != null) {
                this.fwo.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.fxd != null && (wI = this.fxd.wI()) != null) {
            if (z) {
                wI.setVisibility(8);
            } else {
                wI.setVisibility(0);
            }
        }
    }

    private void brJ() {
        CustomResponsedMessage runTask;
        if (this.fwl == null && (runTask = MessageManager.getInstance().runTask(2913164, l.class, btg().pageContext)) != null) {
            this.fwl = (l) runTask.getData();
        }
        if (this.fwl != null) {
            this.fwl.setOtherParams(this.otherParams);
            this.fwl.a(new l.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.20
                @Override // com.baidu.live.im.l.a
                public void Bn() {
                    a.this.bsU();
                }
            });
        }
    }

    private void brK() {
        if (this.fwW != null) {
            this.fwW.ak(btg().fFg.getLiveContainerView());
        }
    }

    private void brL() {
        if (this.fwm == null) {
            this.fwm = new com.baidu.tieba.ala.liveroom.share.b(btg().pageContext);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bx(int i) {
        super.bx(i);
        if (this.fwp != null && UtilHelper.getRealScreenOrientation(btg().pageContext.getPageActivity()) != 2) {
            this.fwp.setVisibility(0);
        }
        brK();
        if (this.fwj != null) {
            this.fwj.bx(i);
        }
        if (this.fwj == null || !this.fwj.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void jU(boolean z) {
        super.jU(z);
        this.fxd.bE(btg().fFh.DM().mLiveInfo.screen_direction);
    }

    private void brM() {
        if (this.fvX == null) {
            this.fvX = new PriorityVerticalLinearLayout(btg().pageContext.getPageActivity());
            this.fvX.setDefaultItemMargin(btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            brO();
        }
        if (this.fvX.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, brN());
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            layoutParams.rightMargin = btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
            layoutParams.bottomMargin = btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
            btg().fFi.addView(this.fvX, layoutParams);
        }
    }

    private int brN() {
        int bottom;
        int bottom2;
        if (btg().aQc.getLivePlayer().getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) btg().aQc.getLivePlayer().getLayoutParams();
            bottom = layoutParams.topMargin + layoutParams.height;
        } else {
            bottom = btg().aQc.getLivePlayer().getBottom();
        }
        if (btg().fFi.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) btg().fFi.getLayoutParams();
            bottom2 = layoutParams2.topMargin + layoutParams2.height;
        } else {
            bottom2 = btg().fFi.getBottom();
        }
        return ((bottom2 - bottom) - btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
    }

    private void brO() {
        View view = new View(btg().pageContext.getPageActivity());
        view.setTag(a.g.sdk_pvl_layout_priority_tag_key, 20);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(1, 0);
        layoutParams.weight = 1.0f;
        this.fvX.addView(view, layoutParams);
    }

    private void brP() {
        if (this.fvY == null) {
            this.fvY = new LinearLayout(btg().pageContext.getPageActivity());
            this.fvY.setOrientation(1);
        }
        if (this.fvY.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds228);
            layoutParams.leftMargin = btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            btg().fFi.addView(this.fvY, layoutParams);
        }
    }

    private void brQ() {
        if (this.fwg == null) {
            this.fwg = new com.baidu.tieba.ala.liveroom.activeview.b(btg().pageContext);
        }
        this.fwg.setOtherParams(Cq());
        this.fwg.b(btg().fFh.DM(), true);
        this.fwg.setHost(false);
        this.fwg.a(1, this.fvX, qm(1));
        this.fwg.a(2, this.fvX, qm(2));
        this.fwg.setVisible(this.fxD ? 8 : 0);
    }

    private void brR() {
        if (this.fwU != null && btg() != null && btg().fFh != null) {
            this.fwU.b(this.fxz, btg().fFh.DM());
        }
    }

    private ViewGroup.LayoutParams qm(int i) {
        switch (i) {
            case 1:
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = btg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds40);
                return layoutParams;
            case 2:
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 5;
                layoutParams2.topMargin = btg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                return layoutParams2;
            default:
                return new RelativeLayout.LayoutParams(-1, -2);
        }
    }

    private void brS() {
        if (this.fvX != null) {
            if (this.fwf == null) {
                this.fwf = new com.baidu.tieba.ala.liveroom.j.a(btg().pageContext, this);
            }
            this.fwf.setOtherParams(Cq());
            this.fwf.d(this.fvX, brW());
            this.fwf.s(btg().fFh.DM());
        }
    }

    private void brT() {
        if (this.fxn == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, com.baidu.live.guardclub.j.class, btg().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.fxn = (com.baidu.live.guardclub.j) runTask.getData();
            } else {
                return;
            }
        }
        this.fxn.setOtherParams(Cq());
        if (this.fwn != null && this.fwn.indexOfChild(this.fxn.getView()) >= 0) {
            this.fwn.removeView(this.fxn.getView());
        }
    }

    private void brU() {
        if (this.fwd != null) {
            this.fwd.a(new a.InterfaceC0521a() { // from class: com.baidu.tieba.ala.liveroom.c.a.5
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0521a
                public void br(int i, int i2) {
                    com.baidu.live.data.n DM = a.this.btg().fFh.DM();
                    if (DM != null && DM.mLiveInfo != null) {
                        if (a.this.fxr == null) {
                            a.this.fxr = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.btg().pageContext.getPageActivity());
                        }
                        a.this.fxr.d(a.this.fxA, i, i2);
                        a.this.fxr.a(String.valueOf(DM.mLiveInfo.live_id), new a.InterfaceC0524a() { // from class: com.baidu.tieba.ala.liveroom.c.a.5.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0524a
                            public void a(float f, String str) {
                                if (a.this.fwd != null) {
                                    a.this.fwd.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0521a
                public void bs(int i, int i2) {
                    if (a.this.fxr != null) {
                        a.this.fxr.bx(i, i2);
                    }
                }
            });
        }
    }

    private void brV() {
        if (this.fxO == null) {
            this.fxO = new com.baidu.tieba.ala.liveroom.h.e(btg().pageContext);
        }
        this.fxO.setRoomId(btg().fFh.DM().mLiveInfo.room_id);
        this.fxO.AM("");
        this.fxO.a(btg().fFh.DM(), this.fvX);
        if (this.fwv == null) {
            this.fwv = new com.baidu.tieba.ala.liveroom.h.b(btg().pageContext, Cq(), this.fxO, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.6
                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void bsu() {
                    a.this.jY(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void bsv() {
                    a.this.jY(false);
                }
            });
        }
        this.fwv.setRoomId(btg().fFh.DM().mLiveInfo.room_id);
        if (this.fwn != null && this.fwn.indexOfChild(this.fwv.getView()) >= 0) {
            this.fwn.removeView(this.fwv.getView());
        }
        if (this.fwv != null) {
            this.fwv.b(btg());
        }
    }

    private ViewGroup.LayoutParams brW() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = btg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brX() {
        if (this.fwd == null) {
            bsc();
        }
        this.fwd.a(com.baidu.live.v.c.Es().aRJ, btg().fFh.DM());
    }

    private void brY() {
        CustomResponsedMessage runTask;
        if (this.fxb == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, btg().pageContext)) != null && runTask.getData() != null) {
            this.fxb = (k) runTask.getData();
            this.fxb.setFromMaster(false);
            this.fxb.Be().getView().setId(a.g.ala_liveroom_msg_list);
            this.fxb.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.7
                @Override // com.baidu.live.im.k.a
                public boolean Bg() {
                    return a.this.zz();
                }

                @Override // com.baidu.live.im.k.a
                public void Bh() {
                    a.this.fxH = true;
                }

                @Override // com.baidu.live.im.k.a
                public void eE(String str) {
                    if (!a.this.fxD) {
                        a.this.jW(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.btg().pageContext.getPageActivity(), a.this.btg().fFg.getLiveContainerView());
                    }
                    a.this.AB(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Bi() {
                    if (a.this.fxD) {
                        a.this.jW(true);
                        a.this.btg().fFg.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.btg().pageContext.getPageActivity(), a.this.btg().fFg.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (a.this.fxb != null) {
                        a.this.fxb.Bf().setQuickInputPanelVisible(false);
                        a.this.fxb.Bf().CN();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Bj() {
                    if (a.this.fxD) {
                        a.this.bst();
                        if (a.this.fxc != null) {
                            a.this.fxc.Bm();
                        }
                        if (a.this.fwl != null) {
                            a.this.fwl.Bm();
                        }
                    } else if (a.this.fxb != null) {
                        a.this.fxb.Bf().setQuickInputPanelVisible(false);
                        a.this.fxb.Bf().CN();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Bk() {
                    return a.this.bsD();
                }
            });
            this.fwn = new FrameLayout(btg().pageContext.getPageActivity());
            this.fwn.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.fxb != null && this.fwn != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(btg().pageContext.getPageActivity()) * 0.75f);
            int dimensionPixelSize = btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds120) + ((int) (BdUtilHelper.getEquipmentHeight(btg().pageContext.getPageActivity()) * 0.33f));
            if (this.fxA.indexOfChild(this.fwn) < 0) {
                if (this.fwn.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fwn.getParent()).removeView(this.fwn);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                this.fxA.addView(this.fwn, layoutParams);
            }
            if (this.fwn.indexOfChild(this.fxb.Be().getView()) < 0) {
                if (this.fxb.Be().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fxb.Be().getView()).removeView(this.fxb.Be().getView());
                }
                if (UtilHelper.getRealScreenOrientation(btg().pageContext.getPageActivity()) != 2) {
                    this.fwn.addView(this.fxb.Be().getView(), new FrameLayout.LayoutParams(equipmentWidth, dimensionPixelSize));
                }
            }
            if (btg().fFi.indexOfChild(this.fxb.Bf().getView()) < 0) {
                if (this.fxb.Bf().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fxb.Bf().getView().getParent()).removeView(this.fxb.Bf().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bsJ();
                btg().fFi.addView(this.fxb.Bf().getView(), layoutParams2);
            }
            com.baidu.live.data.n DM = btg().fFh.DM();
            if (DM != null && DM.mLiveInfo != null) {
                this.fxb.setLogData(DM.mLiveInfo.feed_id, Cq());
            }
            this.fxb.e(String.valueOf(btg().fFh.DM().mLiveInfo.group_id), String.valueOf(btg().fFh.DM().mLiveInfo.last_msg_id), String.valueOf(btg().fFh.DM().aqk.userId), String.valueOf(btg().fFh.DM().mLiveInfo.live_id), btg().fFh.DM().aqk.appId);
            jW(false);
        }
    }

    private void brZ() {
        if (this.fwo == null) {
            this.fwo = new FrameLayout(btg().pageContext.getPageActivity());
            this.fwo.setId(a.g.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void bsa() {
        if (this.fwa == null) {
            this.fwa = new com.baidu.tieba.ala.liveroom.l.a(btg().pageContext, false, this);
        }
        this.fwa.c(this.fxz, btg().fFh.DM());
        this.fwa.a(this.fwF);
    }

    private void bsb() {
        if (this.fvZ == null) {
            this.fvZ = new com.baidu.tieba.ala.liveroom.audiencelist.c(btg().pageContext, this, false);
        }
        this.fvZ.a(String.valueOf(btg().fFh.DM().mLiveInfo.group_id), String.valueOf(btg().fFh.DM().mLiveInfo.live_id), String.valueOf(btg().fFh.DM().aqk.userId), btg().fFh.DM());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.fwP != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.fvZ.c(this.fxz, i, a.g.ala_liveroom_audience_count_layout);
            this.fvZ.e(btg().fFh.bnp());
        }
    }

    private void bsc() {
        if (this.fwd == null) {
            this.fwd = new com.baidu.tieba.ala.liveroom.operation.a(btg().pageContext);
        }
        this.fwd.a(btg(), this.fxA, btg().fFh.DM().mLiveInfo.live_type, true, this.fwF);
        this.fwd.setOtherParams(Cq());
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void bsd() {
        bse();
    }

    private void bse() {
        if (this.fwd != null) {
            int i = btg().fFh.DM().aqD.isUegBlock;
            int i2 = btg().fFh.DM().aqD.isBlock;
            String str = btg().fFh.DM().aqD.userName;
            if (i > 0 || i2 > 0) {
                this.fwd.b(true, i, i2, str);
                this.fxb.a(true, i, i2, str);
                this.fxh.b(true, i, i2, str);
                return;
            }
            this.fwd.b(false, i, i2, str);
            this.fxb.a(false, i, i2, str);
            this.fxh.b(false, i, i2, str);
        }
    }

    private void bsf() {
        if (this.fwe == null) {
            this.fwe = new com.baidu.tieba.ala.liveroom.audiencelist.b(btg().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (btg().fFh.bnp() != null) {
            j = btg().fFh.bnp().getCount();
        }
        this.fwe.a(this.fwF);
        this.fwe.a(this.fxz, a.g.ala_liveroom_audience, j);
        this.fwe.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.fwe.kl(false);
        } else {
            this.fwe.kl(true);
        }
    }

    public void bsg() {
        this.fwQ.c(btg().fFh.DM(), false);
    }

    public void bsh() {
        if (btg().fFh.DM() != null && btg().fFh.DM().aqk != null && btg().fFh.DM().mLiveInfo != null) {
            if (this.fwc == null) {
                this.fwc = new com.baidu.tieba.ala.liveroom.r.b(btg().pageContext);
            }
            long j = btg().fFh.DM().aqk.userId;
            int i = btg().fFh.DM().mLiveInfo.live_type;
            String str = btg().fFh.DM().aqk.portrait;
            String str2 = btg().fFh.DM().mLiveInfo.feed_id;
            long j2 = btg().fFh.DM().mLiveInfo.live_id;
            this.fwc.a(i, j, btg().fFh.DM().aqk.userName, false, str, Cq(), str2, j2);
            this.fwc.ah(this.fxz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsi() {
        String str;
        if (btg() != null && btg().fFh != null && btg().fFh.DM() != null && btg().fFh.DM().aqD != null && (str = btg().fFh.DM().aqD.userName) != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), btg().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !bsC()) {
            com.baidu.live.c.tG().putInt("guide_rename_show_count", com.baidu.live.c.tG().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.Dk().bE(true);
            if (this.fxu == null) {
                this.fxu = new com.baidu.tieba.ala.liveroom.s.a(btg().pageContext);
            }
            this.fxu.setOtherParams(Cq());
            this.fxu.e(this.fxA, btg().fFh.DM());
            jY(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fxu.bzO();
                    a.this.jY(false);
                }
            }, 5000L);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_SHOW);
                alaStaticItem.addParams("other_params", Cq());
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    private void bsj() {
        if (this.fwX == null) {
            this.fwX = new com.baidu.tieba.ala.liveroom.v.a(btg().pageContext, this);
        }
        this.fwX.d(btg().fFi, false);
        this.fwX.kW(btf());
    }

    private void bsk() {
        if (btg() != null && btg().aQc != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(btg().pageContext.getPageActivity());
            Activity pageActivity = btg().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + pageActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds176)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.fwp = new ImageView(btg().pageContext.getPageActivity());
            this.fwp.setVisibility(8);
            this.fwp.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.fwp.setImageResource(a.f.icon_live_enlarge);
            this.fwp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.fwq != null) {
                        a.this.fwq.Ff();
                        a.this.fwp.setVisibility(4);
                    }
                }
            });
            btg().fFi.addView(this.fwp, layoutParams);
            if (UtilHelper.getRealScreenOrientation(btg().pageContext.getPageActivity()) != 2) {
                if (btg().fFn) {
                    this.fwp.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.12
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.fwp != null && UtilHelper.getRealScreenOrientation(a.this.btg().pageContext.getPageActivity()) != 2) {
                                a.this.fwp.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
        }
    }

    private void bsl() {
        if (this.fxH || this.fxI) {
            if ((TbadkCoreApplication.isLogin() && this.fxb.Bf().hasText()) || this.fxI) {
                this.fxH = false;
                this.fxI = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bsI();
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
                if (this.fwf != null) {
                    this.fwf.A(jSONObject);
                }
            } else if ("enter_live".equals(optString)) {
                if (this.fwe != null && this.fwe.getCount() > 20) {
                    this.fwe.dk(this.fwe.getCount() + 1);
                } else if (this.fvZ != null) {
                    com.baidu.live.data.a Ce = aVar.Ce();
                    com.baidu.live.data.g gVar = new com.baidu.live.data.g();
                    gVar.aql = new AlaLocationData();
                    gVar.aqm = new AlaRelationData();
                    gVar.aqk = new AlaLiveUserInfoData();
                    gVar.aqk.userId = JavaTypesHelper.toLong(Ce.userId, 0L);
                    gVar.aqk.userName = Ce.userName;
                    gVar.aqk.portrait = Ce.portrait;
                    if (this.fwe != null && this.fvZ.c(gVar)) {
                        this.fwe.dk(this.fwe.getCount() + 1);
                    }
                }
            } else if ("update_liveinfo".equals(optString) && btg().fFh.DM() != null && btg().fFh.DM().mLiveInfo != null) {
                btg().fFh.a(btg().fFh.DM().mLiveInfo.live_id, btg().fromType, btg().enterTime);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void Ax(String str) {
        if (this.fwg != null) {
            this.fwg.Ax(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void i(com.baidu.live.data.n nVar) {
        super.i(nVar);
        if (this.fwa != null) {
            this.fwa.t(nVar);
        }
        if (this.fwb != null) {
            this.fwb.p(nVar);
        }
        if (this.fwf != null) {
            this.fwf.s(nVar);
        }
        if (this.fwj != null) {
            this.fwj.a(nVar);
        }
        if (this.fwl != null) {
            this.fwl.a(nVar);
        }
        if (this.fwg != null) {
            this.fwg.h(nVar);
            if (nVar != null && this.fxx != null && !this.fxx.hasInit && !TextUtils.isEmpty(this.fxx.avT)) {
                this.fxx.hasInit = true;
                this.fwg.Ay(this.fxx.avT);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(h hVar) {
        if (hVar != null) {
            if (this.fvZ != null && hVar.getList() != null) {
                this.fvZ.e(hVar);
            }
            if (this.fwe != null) {
                this.fwe.dk(hVar.getCount());
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void bJ(boolean z) {
        super.bJ(z);
        if (btg().fFi != null) {
            btg().fFi.bAE();
            btg().fFi.setLiveViewOnDispatchTouchEventListener(null);
            btg().fFi.setOnLiveViewScrollListener(null);
        }
        if (btg().aQc != null) {
            btg().aQc.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.fwj != null) {
            this.fwj.uf();
        }
        bsm();
        if (this.fwc != null) {
            this.fwc.uf();
        }
        if (this.fwX != null) {
            this.fwX.release();
        }
        if (this.fwf != null) {
            this.fwf.uf();
        }
        if (this.fwd != null) {
            this.fwd.bzu();
        }
        if (this.fwb != null) {
            this.fwb.buR();
            this.fwb.setVisible(8);
        }
        if (this.fwh != null) {
            this.fwh.uf();
        }
        if (this.fwg != null) {
            this.fwg.release();
        }
        if (this.fvX != null) {
            this.fvX.removeAllViews();
            this.fvX = null;
        }
        if (this.fvY != null) {
            this.fvY.removeAllViews();
            this.fvY = null;
        }
        if (this.fwi != null) {
            this.fwi.uf();
        }
        if (this.fwl != null) {
            this.fwl.a((l.a) null);
            this.fwl.AJ();
        }
        if (this.fwp != null && (this.fwp.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fwp.getParent()).removeView(this.fwp);
        }
        if (this.fwm != null) {
            this.fwm.dismiss();
        }
        if (this.fwq != null) {
            this.fwq.bS(false);
            this.fwq.Fg();
        }
        if (this.fwv != null) {
            this.fwv.uf();
        }
        if (this.fxO != null) {
            this.fxO.btW();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void l(com.baidu.live.data.n nVar) {
        View Bl;
        super.l(nVar);
        if (this.fwl != null && (Bl = this.fwl.Bl()) != null && Bl.getParent() != null) {
            ((ViewGroup) Bl.getParent()).removeView(Bl);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.fwl != null) {
            this.fwl.setOtherParams(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void bI(boolean z) {
        super.bI(z);
        this.fwt.removeCallbacksAndMessages(null);
        bsm();
        this.fwr = false;
        this.fws = false;
        if (this.fwa != null) {
            this.fwa.onDestroy();
        }
        if (this.fwc != null) {
            this.fwc.onDestroy();
        }
        if (this.fwf != null) {
            this.fwf.onDestroy();
        }
        if (this.fwh != null) {
            this.fwh.onDestroy();
        }
        if (this.fwi != null) {
            this.fwi.onDestroy();
        }
        if (this.fwj != null) {
            this.fwj.onDestroy();
        }
        if (this.fwk != null) {
            this.fwk.onDestroy();
        }
        if (this.fwm != null) {
            this.fwm.onDestroy();
        }
        if (this.fwb != null) {
            this.fwb.onDestroy();
        }
        if (this.fwq != null) {
            this.fwq.stop();
        }
        if (this.fwX != null) {
            this.fwX.onDestroy();
        }
        if (this.fvZ != null) {
            this.fvZ.onDestroy();
        }
        if (this.fxb != null) {
            this.fxb.onDestroy();
        }
        if (this.fwd != null) {
            this.fwd.onDestory();
        }
        if (this.fwl != null) {
            this.fwl.a((l.a) null);
            this.fwl.release();
            this.fwl = null;
        }
        if (this.fxO != null) {
            this.fxO.bI(z ? false : true);
        }
        if (this.fwv != null) {
            this.fwv.onDestroy();
            this.fwv = null;
        }
        MessageManager.getInstance().removeMessageRule(this.fww);
        MessageManager.getInstance().removeMessageRule(this.fwx);
        MessageManager.getInstance().unRegisterListener(this.fwz);
        MessageManager.getInstance().unRegisterListener(this.fwA);
        MessageManager.getInstance().unRegisterListener(this.fwC);
        MessageManager.getInstance().unRegisterListener(this.fwD);
        MessageManager.getInstance().unRegisterListener(this.fwE);
        MessageManager.getInstance().unRegisterListener(this.fwB);
    }

    private void bsm() {
        if (this.fxb != null && this.fxb.Be().getView() != null && this.fxb.Be().getView().getParent() != null) {
            ((ViewGroup) this.fxb.Be().getView().getParent()).removeView(this.fxb.Be().getView());
        }
        if (this.fwn != null && this.fwn.getParent() != null) {
            ((ViewGroup) this.fwn.getParent()).removeView(this.fwn);
        }
        if (this.fwo != null && this.fwo.getParent() != null) {
            ((ViewGroup) this.fwo.getParent()).removeView(this.fwo);
        }
        if (this.fxb != null && this.fxb.Bf().getView() != null) {
            this.fxA.removeView(this.fxb.Bf().getView());
        }
        if (this.fxb != null) {
            this.fxb.Be().setMsgData(new LinkedList());
            this.fxb.AJ();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void a(z zVar) {
        if (this.fxb != null) {
            bsI();
            this.fxb.Bf().setEditText(" @" + zVar.getNameShow() + " ");
        }
        if (this.fwd != null) {
            this.fwd.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void f(com.baidu.live.data.a aVar) {
        if (this.fxb != null) {
            bsI();
            this.fxb.Bf().setEditText(" @" + aVar.userName + " ");
        }
        if (this.fwd != null) {
            this.fwd.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void b(z zVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected View bsn() {
        if (this.fxb != null) {
            return this.fxb.Bf().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean bso() {
        if (this.fxb == null || !this.fxb.Bf().CM()) {
            return false;
        }
        jW(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean bsp() {
        return this.fwa == null || this.fwa.bsp();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup bsq() {
        return this.fvX;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup bsr() {
        return this.fvY;
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
                    this.fxE = false;
                    M(intExtra, intExtra2, intExtra3);
                    return;
                }
                bsg();
                return;
            }
            bte();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.fxD;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(btg().pageContext.getPageActivity()) || z2) {
            jV(z);
        }
    }

    private void jV(boolean z) {
        int dimensionPixelSize;
        if (this.fxb != null && this.fxb.Be() != null) {
            this.fxb.Be().onKeyboardVisibilityChanged(z);
        }
        if (z || this.fxb == null || !this.fxb.Bf().CM()) {
            if (z) {
                if (this.fwd != null) {
                    this.fwd.setVisibility(8);
                }
                if (this.fxd != null && this.fxd.wI() != null) {
                    this.fxd.wI().setVisibility(8);
                }
                bst();
                if (this.fxb != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fxb.Bf().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.fxb.Bf().getView().setLayoutParams(layoutParams);
                    this.fxb.Bf().getView().setVisibility(0);
                    this.fxb.Bf().setQuickInputPanelVisible(false);
                }
                if (this.fxz != null) {
                    this.fxz.setVisibility(8);
                }
                if (this.fwg != null) {
                    this.fwg.setVisible(8);
                }
                if (this.fxc != null) {
                    this.fxc.Bm();
                }
                if (this.fxy != null) {
                    this.fxy.setCanVisible(false);
                }
            } else {
                bss();
            }
            if (this.fxb != null && this.fwn != null) {
                int equipmentHeight = (int) ((z ? 0.2f : 0.33f) * BdUtilHelper.getEquipmentHeight(btg().pageContext.getPageActivity()));
                if (z) {
                    dimensionPixelSize = equipmentHeight + btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64);
                } else {
                    dimensionPixelSize = equipmentHeight + btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
                }
                if (this.fxA.indexOfChild(this.fwn) != -1 && this.fwn.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fwn.getLayoutParams();
                    layoutParams2.height = dimensionPixelSize;
                    this.fwn.setLayoutParams(layoutParams2);
                }
                if (this.fwn.indexOfChild(this.fxb.Be().getView()) != -1 && this.fxb.Be().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.fxb.Be().getView().getLayoutParams();
                    layoutParams3.height = dimensionPixelSize;
                    this.fxb.Be().getView().setLayoutParams(layoutParams3);
                }
                this.fxb.Be().Bd();
            }
        }
    }

    private void bss() {
        if (this.fwd != null) {
            this.fwd.setVisibility(0);
        }
        if (this.fwn != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fwn.getLayoutParams();
            layoutParams.bottomMargin = btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            this.fwn.setLayoutParams(layoutParams);
        }
        if (this.fxb != null) {
            bsJ();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fxb.Bf().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.fxb.Bf().getView().setLayoutParams(layoutParams2);
        }
        if (this.fwd != null) {
            this.fwd.setVisibility(0);
        }
        if (this.fxd != null && this.fxd.wI() != null) {
            this.fxd.wI().setVisibility(0);
        }
        if (this.fxz != null && (!this.fwr || UtilHelper.getRealScreenOrientation(btg().pageContext.getPageActivity()) != 2)) {
            this.fxz.setVisibility(0);
        }
        if (this.fwg != null) {
            this.fwg.setVisible(0);
        }
        if (this.fxc != null) {
            this.fxc.Bm();
        }
        if (this.fxy != null) {
            this.fxy.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bst() {
        if (this.fwn != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fwn.getLayoutParams();
            boolean z = false;
            if (this.fxb != null && this.fxb.Bf() != null) {
                z = this.fxb.Bf().CL();
            }
            int ka = ka(z);
            if (layoutParams.bottomMargin != ka) {
                layoutParams.bottomMargin = ka;
                this.fwn.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jW(boolean z) {
        if (z) {
            this.fxb.Bf().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fwn.getLayoutParams();
            int quickInputPanelExpandHeight = this.fxb.Bf().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.fwn.setLayoutParams(layoutParams);
                if (this.fxb.Be() != null) {
                    this.fxb.Be().Bd();
                    return;
                }
                return;
            }
            return;
        }
        bss();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        RelativeLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = btg().pageContext.getPageActivity();
        if (i3 == 1) {
            if (this.fxz != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.fxz.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.fwm != null) {
                this.fwm.dismiss();
            }
            if (this.fwl != null) {
                this.fwl.a((l.a) null);
                this.fwl.AJ();
            }
            if (this.aPZ != null) {
                this.aPZ.e(true, true);
            }
            if (this.fwp != null) {
                this.fwp.setVisibility(0);
                this.fwp.bringToFront();
            }
            if (this.fwT != null) {
                this.fwT.setVisibility(0);
            }
            if (this.fxb != null && this.fxb.Be().getView().getParent() != null && (this.fxb.Be().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.fxb.Be().getView().getParent()).removeView(this.fxb.Be().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(btg().pageContext.getPageActivity()) * 0.75f);
            int equipmentHeight = ((int) (BdUtilHelper.getEquipmentHeight(btg().pageContext.getPageActivity()) * 0.33f)) + btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
            if (this.fwn != null && this.fxb != null) {
                this.fwn.addView(this.fxb.Be().getView(), new FrameLayout.LayoutParams(equipmentWidth, equipmentHeight));
            }
            if (this.fwo != null && (this.fwo.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.fwo.getParent()).removeView(this.fwo);
            }
            if (this.fxc != null) {
                this.fxc.a(btg().fFh.DM(), false);
                this.fxc.a(new l.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.14
                    @Override // com.baidu.live.im.l.a
                    public void Bn() {
                        a.this.bsU();
                    }
                });
                View Bl = this.fxc.Bl();
                if (Bl != null && this.fxA != null && Bl.getParent() == null) {
                    Resources resources = btg().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(btg().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds98));
                    layoutParams5.addRule(2, a.g.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                    this.fxA.addView(Bl, layoutParams5);
                }
            }
            if (this.fwV != null) {
                this.fwV.setPraiseEnable(true);
                btg().fFi.fSj = true;
            }
            if (this.fvZ != null && this.fvZ.fyK != null && (layoutParams3 = (RelativeLayout.LayoutParams) this.fvZ.fyK.getLayoutParams()) != null) {
                this.fvZ.fyK.setPadding(0, 0, 0, 0);
                this.fvZ.fyK.setLayoutParams(layoutParams3);
            }
            if (this.fwX != null) {
                this.fwX.bBc();
            }
            if (this.fwr) {
                jT(true);
            }
            if (this.fws) {
                if (this.fwd != null && this.fwd.getLandscapeBarrageImageView() != null) {
                    b(this.fwd.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.fwe != null) {
                this.fwe.kk(true);
            }
            this.fwt.removeCallbacksAndMessages(null);
            if (this.fwf != null) {
                this.fwf.setCanVisible(true);
                this.fwf.s(btg().fFh.DM());
            }
        } else if (i3 == 2) {
            if (this.fwX != null) {
                this.fwX.bBd();
            }
            if (this.fxz != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.fxz.getLayoutParams()) != null) {
                layoutParams2.topMargin = btg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
            }
            if (this.fxc != null) {
                this.fxc.a((l.a) null);
                this.fxc.AJ();
            }
            btg().fFi.bAG();
            if (this.aPZ != null) {
                this.aPZ.e(false, true);
            }
            if (this.fwp != null) {
                this.fwp.setVisibility(4);
            }
            if (this.fxb != null && this.fxb.Be().getView().getParent() != null && (this.fxb.Be().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.fxb.Be().getView().getParent()).removeView(this.fxb.Be().getView());
            }
            int max = Math.max(i, i2);
            if (this.fwo != null) {
                if (this.fwo.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fwo.getParent()).removeView(this.fwo);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
                btg().fFi.addView(this.fwo, layoutParams6);
            }
            if (this.fwo != null && this.fwl != null) {
                this.fwl.a(btg().fFh.DM(), false);
                this.fwl.a(new l.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.15
                    @Override // com.baidu.live.im.l.a
                    public void Bn() {
                        a.this.bsU();
                    }
                });
                View Bl2 = this.fwl.Bl();
                if (Bl2 != null && this.fwo.indexOfChild(Bl2) < 0) {
                    this.fwo.addView(Bl2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(btg().pageContext.getPageActivity()), -1));
                }
            }
            if (this.fwV != null) {
                this.fwV.an(btg().fFi);
                this.fwV.setPraiseEnable(false);
                btg().fFi.fSj = false;
            }
            if (this.fvZ != null && this.fvZ.fyK != null && (layoutParams = (RelativeLayout.LayoutParams) this.fvZ.fyK.getLayoutParams()) != null) {
                int width = this.fvZ.fyK.getWidth();
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                this.fvZ.fyK.setPadding(width - ((int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f)), 0, 0, 0);
                this.fvZ.fyK.setLayoutParams(layoutParams);
            }
            if (this.fwe != null) {
                this.fwe.kk(false);
            }
            if (ab.xl() != null) {
                ab.xl().xk();
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.x.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.x.c) runTask.getData()).xk();
            }
            if (this.fwd != null && this.fwd.getLandscapeBarrageImageView() != null) {
                b(this.fwd.getLandscapeBarrageImageView(), this.fws, false);
            }
            this.fwt.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.16
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.fwr) {
                        a.this.jT(false);
                    }
                }
            }, 5000L);
            if (this.fxd != null) {
                this.fxd.wK();
            }
            if (this.fwf != null) {
                this.fwf.setCanVisible(false);
                this.fwf.bvB();
            }
        }
        if (this.fxe != null) {
            if (i3 == 2) {
                View wZ = this.fxe.wZ();
                if (wZ != null) {
                    if (wZ.getParent() != null && (wZ.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) wZ.getParent()).removeView(wZ);
                    }
                    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams7.addRule(5, a.g.ala_liveroom_hostheader);
                    layoutParams7.addRule(3, a.g.ala_liveroom_hostheader);
                    layoutParams7.topMargin = btg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                    if (this.fxz != null) {
                        this.fxz.addView(wZ, layoutParams7);
                    }
                }
            } else {
                View wZ2 = this.fxe.wZ();
                if (wZ2 != null) {
                    if (wZ2.getParent() != null && (wZ2.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) wZ2.getParent()).removeView(wZ2);
                    }
                    RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams8.topMargin = btg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds4);
                    layoutParams8.addRule(3, a.g.ala_live_header_view);
                    btg().fFi.addView(wZ2, layoutParams8);
                }
            }
        }
        if (this.fwd != null) {
            this.fwd.l(i, i2, i3);
        }
        qo(i3);
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.fvZ != null) {
                this.fvZ.cl(i3);
            }
            if (this.fwb != null) {
                this.fwb.cl(i3);
            }
            if (this.fwg != null) {
                this.fwg.cl(i3);
            }
            if (this.fxh != null) {
                this.fxh.cl(i3);
            }
            if (this.fxq != null) {
                this.fxq.cl(i3);
            }
            if (this.fwu != null && this.fwu.isShowing()) {
                this.fwu.resize();
            }
            if (this.fxy != null) {
                this.fxy.cl(i3);
            }
        }
        if (this.fxd != null) {
            this.fxd.wJ();
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public boolean cr(int i) {
        boolean cr = super.cr(i);
        if (cr && 2 == i) {
            if (this.fwa.bsp()) {
                return false;
            }
            if (cr && this.fwX != null) {
                this.fwX.kX(false);
            }
        }
        return cr;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void qn(int i) {
        super.qn(i);
        if (i == 7 || i == 11) {
            if (i != 7 || UtilHelper.getRealScreenOrientation(btg().pageContext.getPageActivity()) != 2) {
                if (this.fwd != null) {
                    this.fwd.setVisibility(8);
                }
                if (this.fxb != null) {
                    this.fxb.Be().getView().setVisibility(4);
                }
                if (this.fxr != null) {
                    this.fxr.kS(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public void cs(int i) {
        super.cs(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public void ct(int i) {
        super.ct(i);
        if (i == 7 || i == 11) {
            if (this.fwd != null) {
                this.fwd.setVisibility(0);
            }
            if (this.fxb != null) {
                this.fxb.Be().getView().setVisibility(0);
            }
            if (this.fxr != null) {
                this.fxr.kS(true);
            }
            if (!this.fwr || UtilHelper.getRealScreenOrientation(btg().pageContext.getPageActivity()) != 2) {
                this.fxz.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.fwc != null) {
            this.fwc.bzM();
        }
        if (this.fwi != null) {
            this.fwi.up();
        }
        if (this.fwg != null) {
            this.fwg.onStop();
        }
        if (btg() != null) {
            BdUtilHelper.hideSoftKeyPad(btg().pageContext.getPageActivity(), btg().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.fwc != null) {
            this.fwc.bzL();
        }
        if (this.fwi != null) {
            this.fwi.uq();
        }
        if (this.fwg != null) {
            this.fwg.onStart();
        }
    }

    private void qo(int i) {
        if (this.fvX != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fvX.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.bottomMargin = btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
                layoutParams.height = brN();
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds72) + 0 + btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds22) + btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                layoutParams.rightMargin = btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
                layoutParams.height = -2;
            }
            this.fvX.setLayoutParams(layoutParams);
        }
    }
}
