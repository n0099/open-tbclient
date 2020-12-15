package com.baidu.tieba.ala.liveroom.d;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ala.AlaCmdConfigCustom;
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
import com.baidu.live.data.ai;
import com.baidu.live.data.ar;
import com.baidu.live.data.bo;
import com.baidu.live.data.cf;
import com.baidu.live.data.cl;
import com.baidu.live.data.p;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.gift.ah;
import com.baidu.live.gift.al;
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
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.turntable.d;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends b implements com.baidu.live.m.c, e {
    private PendantParentView buZ;
    private com.baidu.tieba.ala.liveroom.audiencelist.c heL;
    private com.baidu.tieba.ala.liveroom.o.a heM;
    private com.baidu.tieba.ala.liveroom.g.b heN;
    private com.baidu.tieba.ala.liveroom.u.b heO;
    private com.baidu.tieba.ala.liveroom.audiencelist.b heP;
    private com.baidu.tieba.ala.liveroom.l.a heQ;
    private com.baidu.tieba.ala.liveroom.activeview.b heR;
    private com.baidu.live.f.a heS;
    private i heT;
    private h heU;
    private com.baidu.tieba.ala.liveroom.c.a heV;
    private com.baidu.live.im.b.a heW;
    private com.baidu.tieba.ala.liveroom.share.b heX;
    private com.baidu.live.ad.a heY;
    private FrameLayout heZ;
    private FrameLayout hfa;
    private ImageView hfb;
    private com.baidu.live.tieba.e.b hfc;
    private ah hfh;
    private com.baidu.tieba.ala.liveroom.j.b hfi;
    private long lastClickTime = 0;
    private boolean hfd = false;
    private boolean hfe = false;
    private boolean hff = false;
    private Handler hfg = new Handler();
    private HttpRule hfj = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.heT != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.heT.EC()) {
                httpMessage.addParam("ala_challenge_id", a.this.heT.EF());
            }
            return httpMessage;
        }
    };
    private HttpRule hfk = new HttpRule(1021229) { // from class: com.baidu.tieba.ala.liveroom.d.a.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.heT != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.heT.EC()) {
                httpMessage.addParam("challenge_id", a.this.heT.EF());
            }
            return httpMessage;
        }
    };
    private HttpRule hfl = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.a.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.heT != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.heT.EC()) {
                httpMessage.addParam("challenge_id", a.this.heT.EF());
            }
            return httpMessage;
        }
    };
    private HttpRule hfm = new HttpRule(1021232) { // from class: com.baidu.tieba.ala.liveroom.d.a.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.heT != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.heT.EC()) {
                httpMessage.addParam("challenge_id", a.this.heT.EF());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c hfn = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.23
        @Override // com.baidu.live.liveroom.g.c
        public void PL() {
            if (a.this.hfR != null) {
                a.this.hfR.on(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cA(boolean z) {
            if (z) {
                if (a.this.hfR != null) {
                    a.this.hfR.on(true);
                }
            } else if (a.this.hfR != null) {
                a.this.hfR.on(false);
            }
            if (a.this.hgk != null) {
                a.this.hgk.bE(z);
            }
            if (a.this.heR != null) {
                a.this.heR.nd(z ? false : true);
            }
            com.baidu.live.p.a.cB(z);
        }
    };
    private com.baidu.tieba.ala.liveroom.o.c hfo = new com.baidu.tieba.ala.liveroom.o.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.24
        @Override // com.baidu.tieba.ala.liveroom.o.c
        public void onClick() {
            a.this.hfg.removeCallbacksAndMessages(null);
            a.this.hfd = true;
        }

        @Override // com.baidu.tieba.ala.liveroom.o.c
        public void endAnimation() {
            if (a.this.hfd) {
                a.this.cal();
            }
        }
    };
    private HttpMessageListener hfp = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.PU() != null) {
                        com.baidu.live.ae.e.RP().bxB = getQuickGiftHttpResponseMessage.PU();
                        a.this.caB();
                    }
                }
            }
        }
    };
    private CustomMessageListener hfq = new CustomMessageListener(2913276) { // from class: com.baidu.tieba.ala.liveroom.d.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            JSONObject optJSONObject;
            JSONArray optJSONArray;
            if (a.this.mOrientation == 1 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject) && (optJSONObject = ((JSONObject) customResponsedMessage.getData()).optJSONObject("ext_data")) != null && (optJSONArray = optJSONObject.optJSONArray("surprise_prize_member")) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                View inflate = LayoutInflater.from(a.this.activity).inflate(a.g.ala_fudai_dialog_layout, (ViewGroup) null);
                final Dialog dialog = new Dialog(a.this.cbX().pageContext.getPageActivity(), a.i.FudaiDialogStyle);
                dialog.requestWindowFeature(1);
                dialog.setContentView(inflate);
                dialog.setCancelable(false);
                View findViewById = inflate.findViewById(a.f.ala_fudai_negative_btn);
                View findViewById2 = inflate.findViewById(a.f.ala_fudai_positive_btn);
                TextView textView = (TextView) inflate.findViewById(a.f.ala_fudai_tbean_num);
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.5.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialog.dismiss();
                        if (TbadkCoreApplication.isLogin()) {
                            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
                            httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
                            MessageManager.getInstance().sendMessage(httpMessage);
                            ai aiVar = new ai();
                            aiVar.aLB = -1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aiVar));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                        }
                    }
                });
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (optJSONArray.getJSONObject(i).optInt("prize_type") != 7) {
                        continue;
                    } else {
                        textView.setText(" " + optJSONArray.getJSONObject(i).optInt("prize_value"));
                        dialog.show();
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener hfr = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                a.this.hfZ.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hfs = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.hgn != null) {
                    a.this.hgn.ir(str);
                }
            }
        }
    };
    CustomMessageListener hft = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.hgN != null && a.this.hgN.bja != null && !a.this.hgN.bjf && !a.this.hgN.bjg && a.this.hgj != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.cbX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                if (a.this.hfW != null && a.this.hfW.Nf().OY()) {
                    layoutParams.bottomMargin = a.this.cbX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds70);
                } else {
                    layoutParams.bottomMargin = a.this.cbX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                }
                a.this.hgj.b(a.this.heZ, layoutParams);
                if (com.baidu.live.guardclub.e.LY() != null) {
                    com.baidu.live.guardclub.e.LY().Md();
                }
            }
        }
    };
    private CustomMessageListener hfu = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.a.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (a.this.hgl != null) {
                    a.this.hgl.dismiss();
                }
                if (a.this.hgn != null) {
                    a.this.hgn.dismiss();
                }
                if (a.this.gTT != null) {
                    a.this.gTT.dismiss();
                }
                com.baidu.live.im.b.d.NK().setSwitchStatus(true);
                com.baidu.live.im.b.d.NK().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cbq();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener hfv = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.a.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.hfi.c(a.this.cbX());
                } else if (a.this.cbj() || !g.wL(2913168)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.cbX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.cbX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    a.this.hfi.b(a.this.heZ, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b hfw = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.a.15
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void s(View view, int i) {
            bo boVar;
            cf cfVar;
            cl clVar;
            String str;
            bo boVar2;
            cf cfVar2;
            String str2;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - a.this.lastClickTime >= 300) {
                a.this.lastClickTime = currentTimeMillis;
                if (i == 2 && a.this.Le()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel"));
                    a.this.N(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.ae.e.RP().bxB.HW().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.ae.e.RP().bxB.HW().GX());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.ae.e.RP().bxB.HW().GY());
                        if (a.this.cbX().hpT.Iq() != null && a.this.cbX().hpT.Iq().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.cbX().hpT.Iq().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.cbX().hpT.Iq().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.Oj());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.Le()) {
                        if (com.baidu.live.d.BM().getBoolean("quick_gift_guide_show", true) && !a.this.cbj()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, ah.class, a.this.cbX().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                ah ahVar = (ah) runTask.getData();
                                ahVar.setPageContext(a.this.cbX().pageContext);
                                ahVar.setLiveShowData(a.this.cbX().hpT.Iq());
                                ahVar.setGiftItem(com.baidu.live.ae.e.RP().bxB.HW());
                                ahVar.setOtherParams(a.this.Oj());
                                ahVar.initView();
                                ahVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.15.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        a.this.ni(false);
                                        a.this.hfh = null;
                                    }
                                });
                                a.this.hfh = ahVar;
                                ahVar.show();
                                a.this.ni(true);
                                return;
                            }
                            return;
                        }
                        n.a(a.this.cbX().pageContext, a.this.cbX().hpT.Iq(), com.baidu.live.ae.e.RP().bxB.HW(), a.this.Oj());
                    }
                } else if (i == 1) {
                    if (a.this.hfW != null) {
                        a.this.cbq();
                    }
                } else if (i == 3 && a.this.Le()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    if (a.this.mOrientation == 2 && (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                        if (a.this.heX != null) {
                            a.this.heX.R(a.this.cbX().hpT.Iq());
                        }
                    } else {
                        a.this.hfJ.c(a.this.cbX().hpT.Iq(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.cbX() != null && a.this.cbX().hpT != null && a.this.cbX().hpT.Iq() != null && a.this.cbX().hpT.Iq().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.cbX().hpT.Iq().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.cbX().hpT.Iq().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.cbX().hpT.Iq().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.Oj());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.cbX() != null && a.this.cbX().hpT != null && a.this.cbX().hpT.Iq() != null && a.this.cbX().hpT.Iq().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.cbX().hpT.Iq().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.cbX().hpT.Iq().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.cbX().hpT.Iq().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.Oj());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.brc != null) {
                        a.this.brc.cu(false);
                    }
                } else if (i == 12) {
                    if (a.this.hfR != null) {
                        String valueOf = String.valueOf(a.this.cbX().hpT.Iq().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.cbX().hpT.Iq().mLiveInfo.room_id);
                        String str3 = null;
                        AlaLiveSdkInfo alaLiveSdkInfo = a.this.cbX().hpT.Iq().mLiveSdkInfo;
                        if (alaLiveSdkInfo != null && alaLiveSdkInfo.mCastIds != null) {
                            str3 = String.valueOf(a.this.cbX().hpT.Iq().mLiveSdkInfo.mCastIds.chatMCastId);
                        }
                        a.this.hfR.au(valueOf, valueOf2, str3);
                        com.baidu.live.p.a.b(a.this.cbX().hpT.Iq().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    w Iq = a.this.cbX().hpT.Iq();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.cbX().pageContext.getPageActivity(), Iq.aJV.userName, Long.toString(Iq.aJV.userId), Long.toString(Iq.aJV.charmCount), String.valueOf(Iq.mLiveInfo.group_id), String.valueOf(Iq.mLiveInfo.live_id), false, String.valueOf(Iq.aJV.userId), Long.toString(Iq.aKr.userId), Iq.aKr.userName, Iq.aKr.portrait, a.this.heP.getCount(), a.this.Oj())));
                    LogManager.getCommonLogger().doClickGusetNumLog(Iq.mLiveInfo.feed_id, a.this.heP.getCount() + "", a.this.Oj());
                } else if (i == 11) {
                    a.this.cbu();
                    a.this.cbv();
                } else if (i == 16) {
                    if (a.this.cbX() != null && (boVar2 = com.baidu.live.ae.a.RB().bxq) != null && (cfVar2 = boVar2.aQM) != null) {
                        String str4 = cfVar2.aSj.aSq;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (a.this.cbX().hpT != null && a.this.cbX().hpT.Iq() != null && a.this.cbX().hpT.Iq().mLiveInfo != null) {
                                j = a.this.cbX().hpT.Iq().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", a.this.cbX().hpT.Iq().mLiveInfo.room_id + "", a.this.cbX().hpT.Iq().mLiveInfo.feed_id, a.this.Oj());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.cbX().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (a.this.cbX() != null) {
                        w wVar = null;
                        if (a.this.cbX().hpT != null) {
                            wVar = a.this.cbX().hpT.Iq();
                        }
                        if (wVar != null && wVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.v.b.ckB().brJ != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.v.b.ckB().brJ.aJj;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(a.this.cbX().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17) {
                    if (a.this.Le() && a.this.cbX() != null && (boVar = com.baidu.live.ae.a.RB().bxq) != null && (cfVar = boVar.aQM) != null && (clVar = cfVar.aSk) != null && !TextUtils.isEmpty(clVar.webUrl)) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                        if (a.this.hgl != null && a.this.cbX().hpT != null && a.this.cbX().hpT.Iq() != null) {
                            w Iq2 = a.this.cbX().hpT.Iq();
                            a.this.hgl.a(clVar.webUrl, Iq2.mLiveInfo.live_id, Iq2.aKr.userId, Iq2.aJV.userId);
                            a.this.hfc.da(false);
                            a.this.hfc.Vj();
                        }
                    }
                } else if (i == 18) {
                    if (a.this.hff) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.hff = !a.this.hff;
                } else if (i == 19 && a.this.hfc != null) {
                    a.this.hfc.Vj();
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.hfL = new com.baidu.tieba.ala.liveroom.guide.c(cbX().pageContext, this, false);
        this.hfk.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hfk);
        this.hfj.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hfj);
        this.hfl.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hfl);
        this.hfm.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hfm);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean cak() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cal() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.25
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.hfe) {
                    a.this.ne(false);
                }
            }
        }, 5000L);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(w wVar) {
        super.l(wVar);
        g.cfr();
        this.hff = false;
        if (this.hfO != null) {
            this.hfO.b(this.hfw);
        }
        if (this.hfc == null) {
            this.hfc = new com.baidu.live.tieba.e.b(cbX().pageContext.getPageActivity());
            this.hfc.start();
        }
        this.hfc.da(true);
        cbX().pageContext.getPageActivity().setRequestedOrientation(-1);
        cbX().hpU.setIsForceHandledTouch(false);
        cbX().hpU.setSwipeClearEnable(true);
        cbX().hpU.setOnLiveViewScrollListener(this.hfn);
        cbX().hpU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hfg.removeCallbacksAndMessages(null);
                a.this.hfd = false;
                a.this.ne(false);
                if (!a.this.hfe) {
                    a.this.cal();
                }
            }
        });
        if (this.hgG != null) {
            this.hgG.setVisibility(0);
        }
        cat();
        if (this.hgh != null) {
            this.hgh.a(wVar, this.buZ);
            this.hgh.U(this.hgH);
            this.hgh.a(this);
        }
        cbF();
        caF();
        cbf();
        cbe();
        caG();
        caq();
        caK();
        caH();
        cam();
        nj(false);
        caM();
        cbE();
        cbL();
        cby();
        cbD();
        caC();
        caD();
        cbx();
        caE();
        cbz();
        cao();
        caN();
        nl(true);
        cav();
        caB();
        cbP();
        caw();
        cax();
        cay();
        caz();
        car();
        caP();
        caO();
        can();
        cbO();
        cbK();
        cas();
        if (this.hgl != null && this.hgl.ckI() == null) {
            this.hgl.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.27
                @Override // com.baidu.tieba.ala.liveroom.turntable.d.a
                public void onDismiss() {
                    a.this.hfc.da(true);
                }
            });
        }
        c(this.giS);
        MessageManager.getInstance().registerListener(this.hfp);
        MessageManager.getInstance().registerListener(this.hft);
        MessageManager.getInstance().registerListener(this.hfu);
        MessageManager.getInstance().registerListener(this.hfv);
        MessageManager.getInstance().registerListener(this.hfs);
        MessageManager.getInstance().registerListener(this.hfr);
        MessageManager.getInstance().registerListener(this.hfq);
        caQ();
        caJ();
        if (this.mOrientation == 2) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(cbX().pageContext.getPageActivity());
            l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(cbX().pageContext.getPageActivity()));
        }
        if (this.hgx != null) {
            this.hgx.K(wVar);
        }
        cbB();
    }

    private void cam() {
        if (this.hgx == null) {
            View view = null;
            if (this.hfO != null && this.hfO.getView() != null) {
                view = this.hfO.getView();
            }
            this.hgx = new com.baidu.tieba.ala.liveroom.exclusive.b(cbX().pageContext, PH(), cbX().hpU, view, this.heL.hii, this);
        }
    }

    private void can() {
        if (this.hgw != null) {
            this.hgw.a(new com.baidu.live.z.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.2
                @Override // com.baidu.live.z.c
                public void cH(boolean z) {
                    if (a.this.heU != null) {
                        a.this.heU.setNeedCloseRecommendFloat(z);
                    }
                    if (a.this.cbX().hpU.hFu) {
                        if (a.this.hfR != null) {
                            a.this.hfR.of(z);
                            a.this.hfR.on(!z);
                        }
                        if (a.this.hfO != null) {
                            a.this.hfO.of(z);
                            a.this.hfO.setPraiseEnable(!z);
                            a.this.hfO.oe(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ne(boolean z) {
        View Ip;
        if (cbX() != null && cbX().pageContext != null && cbX().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(cbX().pageContext.getPageActivity()) == 2 || z) {
                if (this.hfZ != null && (Ip = this.hfZ.Ip()) != null) {
                    if (this.hfe) {
                        Ip.setVisibility(0);
                    } else {
                        Ip.setVisibility(8);
                    }
                }
                if (this.hfe) {
                    if (this.hgG != null) {
                        this.hgG.setVisibility(0);
                    }
                    if (this.hgH != null) {
                        this.hgH.setVisibility(0);
                    }
                    if (this.buZ != null) {
                        this.buZ.setVisibility(0);
                    }
                    if (this.buZ != null) {
                        this.buZ.setVisibility(0);
                    }
                    if (this.hfY != null) {
                        this.hfY.bC(false);
                    }
                } else {
                    if (this.hgG != null) {
                        this.hgG.setVisibility(8);
                    }
                    if (this.hgH != null) {
                        this.hgH.setVisibility(8);
                    }
                    if (this.buZ != null) {
                        this.buZ.setVisibility(8);
                    }
                    if (this.buZ != null) {
                        this.buZ.setVisibility(8);
                    }
                    if (this.hfY != null) {
                        this.hfY.bC(true);
                    }
                }
                this.hfe = this.hfe ? false : true;
                if (this.heR != null) {
                    this.heR.nd(this.hfe);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, boolean z2) {
        ImageView imageView;
        View HN;
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view;
        }
        if (z) {
            if (imageView != null) {
                imageView.setImageResource(a.e.icon_live_barrage_off);
            }
            if (this.hfa != null) {
                this.hfa.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.e.icon_live_barrage_on);
            }
            if (this.hfa != null) {
                this.hfa.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.hfY != null && (HN = this.hfY.HN()) != null) {
            if (z) {
                HN.setVisibility(8);
            } else {
                HN.setVisibility(0);
            }
        }
    }

    private void cao() {
        CustomResponsedMessage runTask;
        if (this.heW == null && (runTask = MessageManager.getInstance().runTask(2913164, com.baidu.live.im.b.a.class, cbX().pageContext)) != null) {
            this.heW = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.heW != null) {
            this.heW.setOtherParams(this.otherParams);
            this.heW.a(new a.InterfaceC0193a() { // from class: com.baidu.tieba.ala.liveroom.d.a.3
                @Override // com.baidu.live.im.b.a.InterfaceC0193a
                public void NJ() {
                    a.this.cbI();
                }
            });
        }
    }

    private void cap() {
        if (this.hfQ != null) {
            this.hfQ.ax(cbX().hpS.getLiveContainerView());
        }
    }

    private void caq() {
        if (this.heX == null) {
            this.heX = new com.baidu.tieba.ala.liveroom.share.b(cbX().pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void car() {
        if (cbX() != null) {
            if (this.heY == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.ad.a.class, cbX().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.heY = (com.baidu.live.ad.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.heY.setIsHost(false);
            this.heY.a(this.buZ, cbX().hpT.Iq().aKU);
        }
    }

    private void cas() {
        if (cbX() != null) {
            if (this.hgt == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913271, com.baidu.live.a.a.class, cbX().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hgt = (com.baidu.live.a.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hgt.bf(true);
            this.hgt.a(caV(), cbX().hpT.Iq());
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void eb(int i) {
        super.eb(i);
        if (this.hfb != null && UtilHelper.getRealScreenOrientation(cbX().pageContext.getPageActivity()) != 2) {
            this.hfb.setVisibility(0);
        }
        cap();
        if (this.heU != null) {
            this.heU.eb(i);
        }
        if (this.heU == null || !this.heU.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
        if (this.hgx != null) {
            this.hgx.ceP();
        }
    }

    private void cat() {
        if (this.buZ == null) {
            PendantParentView.Model model = PendantParentView.Model.HORIZONTAL;
            if (this.mOrientation == 2) {
                model = PendantParentView.Model.HORIZONTAL_FULL;
            }
            this.buZ = new PendantParentView(cbX().pageContext.getPageActivity(), model);
            cbX().hpU.addView(this.buZ, ((cbX().hpU.getView() == null || this.hfO == null || this.hfO.getView() == null) ? -1 : cbX().hpU.getView().indexOfChild(this.hfO.getView())) + 1, new RelativeLayout.LayoutParams(-1, cau()));
            this.buZ.setDefaultItemMargin(cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            K(this.mOrientation, false);
        }
    }

    private int cau() {
        int bottom;
        int bottom2;
        if (cbX().brf.getLivePlayer().getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) cbX().brf.getLivePlayer().getLayoutParams();
            bottom = layoutParams.topMargin + layoutParams.height;
        } else {
            bottom = cbX().brf.getLivePlayer().getBottom();
        }
        if (cbX().hpU.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) cbX().hpU.getLayoutParams();
            bottom2 = layoutParams2.topMargin + layoutParams2.height;
        } else {
            bottom2 = cbX().hpU.getBottom();
        }
        int i = 0;
        if (this.hgx != null) {
            i = this.hgx.getHeight();
        }
        return (((bottom2 - bottom) - i) - cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
    }

    private void cav() {
        if (this.heR == null) {
            this.heR = new com.baidu.tieba.ala.liveroom.activeview.b(cbX().pageContext);
        }
        if (cbX() != null && cbX().hpT != null) {
            this.heR.Ia(cbX().hpT.cjP());
        }
        this.heR.setOtherParams(Oj());
        this.heR.b(cbX().hpT.Iq(), true);
        this.heR.setHost(false);
        this.heR.a(1, this.buZ);
        this.heR.a(2, this.buZ);
        this.heR.setVisible(this.hgK ? 8 : 0);
    }

    private void caw() {
        if (this.buZ != null) {
            if (this.heQ == null) {
                this.heQ = new com.baidu.tieba.ala.liveroom.l.a(cbX().pageContext, this);
            }
            this.heQ.setOtherParams(Oj());
            this.heQ.a((ViewGroup) this.buZ, caA());
            this.heQ.L(cbX().hpT.Iq());
        }
    }

    private void cax() {
        if (this.hgj == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, j.class, cbX().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hgj = (j) runTask.getData();
            } else {
                return;
            }
        }
        this.hgj.setOtherParams(Oj());
        if (this.heZ != null && this.heZ.indexOfChild(this.hgj.getView()) >= 0) {
            this.heZ.removeView(this.hgj.getView());
        }
    }

    private void cay() {
        if (this.hfG != null) {
            this.hfG.a(new a.InterfaceC0695a() { // from class: com.baidu.tieba.ala.liveroom.d.a.11
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0695a
                public void bS(int i, int i2) {
                    w Iq = a.this.cbX().hpT.Iq();
                    if (Iq != null && Iq.mLiveInfo != null) {
                        if (a.this.hgm == null) {
                            a.this.hgm = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.cbX().pageContext.getPageActivity());
                        }
                        a.this.hgm.d(a.this.hgH, i, i2);
                        a.this.hgm.a(String.valueOf(Iq.mLiveInfo.live_id), new a.InterfaceC0699a() { // from class: com.baidu.tieba.ala.liveroom.d.a.11.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0699a
                            public void a(float f, String str) {
                                if (a.this.hfG != null) {
                                    a.this.hfG.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0695a
                public void bT(int i, int i2) {
                    if (a.this.hgm != null) {
                        a.this.hgm.bY(i, i2);
                    }
                }
            });
        }
    }

    private void caz() {
        if (this.hgW == null) {
            this.hgW = new com.baidu.tieba.ala.liveroom.j.e(cbX().pageContext);
        }
        this.hgW.setRoomId(cbX().hpT.Iq().mLiveInfo.room_id);
        this.hgW.It("");
        this.hgW.b(cbX().hpT.Iq(), this.buZ);
        if (this.hfi == null) {
            this.hfi = new com.baidu.tieba.ala.liveroom.j.b(cbX().pageContext, Oj(), this.hgW, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.13
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void caY() {
                    a.this.ni(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void caZ() {
                    a.this.ni(false);
                }
            });
        }
        this.hfi.setRoomId(cbX().hpT.Iq().mLiveInfo.room_id);
        if (this.heZ != null && this.heZ.indexOfChild(this.hfi.getView()) >= 0) {
            this.heZ.removeView(this.hfi.getView());
        }
        if (this.hfi != null) {
            this.hfi.b(cbX());
        }
    }

    private LinearLayout.LayoutParams caA() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = cbX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caB() {
        if (this.hfG == null) {
            caH();
        }
        this.hfG.a(com.baidu.live.ae.e.RP().bxB, cbX().hpT.Iq());
    }

    private void caC() {
        CustomResponsedMessage runTask;
        boolean z = true;
        if (this.hfW == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, cbX().pageContext)) != null && runTask.getData() != null) {
            this.hfW = (k) runTask.getData();
            this.hfW.setFromMaster(false);
            this.hfW.Nd().getView().setId(a.f.ala_liveroom_msg_list);
            this.hfW.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.14
                @Override // com.baidu.live.im.k.a
                public boolean Nh() {
                    return a.this.Le();
                }

                @Override // com.baidu.live.im.k.a
                public void Ni() {
                    a.this.hgO = true;
                }

                @Override // com.baidu.live.im.k.a
                public void id(String str) {
                    if (!a.this.hgK) {
                        a.this.ng(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.cbX().pageContext.getPageActivity(), a.this.cbX().hpS.getLiveContainerView());
                    }
                    a.this.Ih(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Nj() {
                    if (a.this.hgK) {
                        a.this.ng(true);
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.cbX().pageContext.getPageActivity(), a.this.cbX().hpS.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (a.this.hfW != null) {
                        a.this.hfW.Ne().setQuickInputPanelVisible(false);
                        a.this.hfW.Ne().OR();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Nk() {
                    if (a.this.hgK) {
                        a.this.caX();
                        if (a.this.hfX != null) {
                            a.this.hfX.DM();
                        }
                        if (a.this.heW != null) {
                            a.this.heW.DM();
                        }
                    } else if (a.this.hfW != null) {
                        a.this.hfW.Ne().setQuickInputPanelVisible(false);
                        a.this.hfW.Ne().OR();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Nl() {
                    return a.this.cbk();
                }

                @Override // com.baidu.live.im.k.a
                public int Nm() {
                    return a.this.cbl();
                }
            });
            this.heZ = new FrameLayout(cbX().pageContext.getPageActivity());
            this.heZ.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.hfW != null && this.heZ != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(cbX().pageContext.getPageActivity()) * 0.7f);
            int i = com.baidu.live.ak.c.i(true, false);
            if (this.hgH.indexOfChild(this.heZ) < 0) {
                if (this.heZ.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.heZ.getParent()).removeView(this.heZ);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
                this.hgH.addView(this.heZ, layoutParams);
            }
            if (this.heZ.indexOfChild(this.hfW.Nd().getView()) < 0) {
                if (this.hfW.Nd().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hfW.Nd().getView()).removeView(this.hfW.Nd().getView());
                }
                if (UtilHelper.getRealScreenOrientation(cbX().pageContext.getPageActivity()) != 2) {
                    this.heZ.addView(this.hfW.Nd().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, i));
                }
            }
            if (cbX().hpU.indexOfChild(this.hfW.Ne().getView()) < 0) {
                if (this.hfW.Ne().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hfW.Ne().getView().getParent()).removeView(this.hfW.Ne().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                cbs();
                cbX().hpU.addView(this.hfW.Ne().getView(), layoutParams2);
            }
            w Iq = cbX().hpT.Iq();
            if (Iq != null && Iq.mLiveInfo != null) {
                this.hfW.setLogData(Iq.mLiveInfo.feed_id, Oj());
            }
            if (Iq == null || Iq.aKI == null || !Iq.aKI.Fb()) {
                z = false;
            }
            this.hfW.a(String.valueOf(cbX().hpT.Iq().mLiveInfo.group_id), String.valueOf(cbX().hpT.Iq().mLiveInfo.last_msg_id), String.valueOf(cbX().hpT.Iq().aJV.userId), String.valueOf(cbX().hpT.Iq().mLiveInfo.live_id), cbX().hpT.Iq().aJV.appId, z, cbX().hpT.Iq().getGuardName());
            ng(false);
        }
    }

    private void caD() {
        cbr();
    }

    private void caE() {
        if (this.hfa == null) {
            this.hfa = new FrameLayout(cbX().pageContext.getPageActivity());
            this.hfa.setId(a.f.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void caF() {
        if (this.heM == null) {
            this.heM = new com.baidu.tieba.ala.liveroom.o.a(cbX().pageContext, false, this);
        }
        this.heM.e(this.hgG, cbX().hpT.Iq());
        this.heM.a(this.hfo);
        this.heM.a(this.hfw);
    }

    private void caG() {
        if (this.heL == null) {
            this.heL = new com.baidu.tieba.ala.liveroom.audiencelist.c(cbX().pageContext, this, false);
        }
        this.heL.a(String.valueOf(cbX().hpT.Iq().mLiveInfo.group_id), String.valueOf(cbX().hpT.Iq().mLiveInfo.live_id), String.valueOf(cbX().hpT.Iq().aJV.userId), cbX().hpT.Iq());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.f.ala_liveroom_hostheader;
            if (this.hfH != null && this.hfH.getView() != null && this.hfH.getView().getParent() != null) {
                i = a.f.ala_liveroom_guardthrone;
            }
            this.heL.c(this.hgG, i, a.f.ala_liveroom_audience_count_layout);
            this.heL.e(cbX().hpT.bUu());
        }
    }

    private void caH() {
        com.baidu.live.core.a.a Pc;
        if (this.hfG == null) {
            this.hfG = new com.baidu.tieba.ala.liveroom.operation.a(cbX().pageContext);
        }
        this.hfG.a(cbX(), this.hgH, cbX().hpT.Iq().mLiveInfo, true, this.hfw);
        this.hfG.setOtherParams(Oj());
        if (this.hgh != null && (Pc = this.hgh.Pc()) != null) {
            View rootLayout = Pc.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.hfG.cp(rootLayout);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void caI() {
        caJ();
    }

    private void caJ() {
        if (this.hfG != null) {
            int i = cbX().hpT.Iq().aKr.isUegBlock;
            int i2 = cbX().hpT.Iq().aKr.isBlock;
            String str = cbX().hpT.Iq().aKr.userName;
            if (i > 0 || i2 > 0) {
                this.hfG.b(true, i, i2, str);
                this.hfW.a(true, i, i2, str);
                this.hgc.b(true, i, i2, str);
                return;
            }
            this.hfG.b(false, i, i2, str);
            this.hfW.a(false, i, i2, str);
            this.hgc.b(false, i, i2, str);
        }
    }

    private void caK() {
        if (this.heP == null) {
            this.heP = new com.baidu.tieba.ala.liveroom.audiencelist.b(cbX().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (cbX().hpT.bUu() != null) {
            j = cbX().hpT.bUu().getCount();
        }
        this.heP.a(this.hfw);
        this.heP.a(this.hgG, a.f.ala_liveroom_hostheader, j);
        this.heP.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.heP.ns(false);
        } else {
            this.heP.ns(true);
        }
    }

    public void caL() {
        this.hfJ.c(cbX().hpT.Iq(), false);
    }

    public void caM() {
        if (cbX().hpT.Iq() != null && cbX().hpT.Iq().aJV != null && cbX().hpT.Iq().mLiveInfo != null) {
            if (this.heO == null) {
                this.heO = new com.baidu.tieba.ala.liveroom.u.b(cbX().pageContext);
            }
            long j = cbX().hpT.Iq().aJV.userId;
            int i = cbX().hpT.Iq().mLiveInfo.live_type;
            String str = cbX().hpT.Iq().aJV.portrait;
            String str2 = cbX().hpT.Iq().mLiveInfo.feed_id;
            long j2 = cbX().hpT.Iq().mLiveInfo.live_id;
            this.heO.a(i, j, cbX().hpT.Iq().aJV.userName, false, str, Oj(), str2, j2);
            this.heO.at(this.hgG);
        }
    }

    private void caN() {
        boolean z = false;
        if (this.hfR == null) {
            this.hfR = new com.baidu.tieba.ala.liveroom.w.a(cbX().pageContext, this);
        }
        this.hfR.c(cbX().hpU, false);
        boolean cbW = cbW();
        AlaLiveInfoData alaLiveInfoData = cbX().hpT.Iq().mLiveInfo;
        boolean isZanAnimUnabled = (alaLiveInfoData == null || alaLiveInfoData.mAlaLiveSwitchData == null) ? false : alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled();
        if (cbW && !isZanAnimUnabled) {
            z = true;
        }
        this.hfR.om(z);
    }

    private void caO() {
        if (cbX() != null && cbX().brf != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(cbX().pageContext.getPageActivity());
            Activity pageActivity = cbX().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + o.bm(pageActivity)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.hfb = new ImageView(cbX().pageContext.getPageActivity());
            this.hfb.setVisibility(8);
            this.hfb.setBackgroundResource(a.e.sdk_round_btn_close_bg);
            this.hfb.setImageResource(a.e.icon_live_enlarge);
            this.hfb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hfc != null) {
                        a.this.hfc.Vi();
                        a.this.hfb.setVisibility(4);
                        a.this.hfW.Nf().cp(false);
                    }
                }
            });
            cbX().hpU.addView(this.hfb, layoutParams);
            if (UtilHelper.getRealScreenOrientation(cbX().pageContext.getPageActivity()) != 2) {
                if (cbX().hqa) {
                    this.hfb.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.17
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.hfb != null && UtilHelper.getRealScreenOrientation(a.this.cbX().pageContext.getPageActivity()) != 2) {
                                a.this.hfb.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
        }
    }

    private void caP() {
        if (this.hgF == null) {
            this.hgF = new com.baidu.tieba.ala.liveroom.apppromotion.a(cbX().pageContext);
        }
        this.hgF.b(caV(), cbX().hpT.Iq());
    }

    private void caQ() {
        if (this.hgO || this.hgP) {
            if ((TbadkCoreApplication.isLogin() && this.hfW.Ne().hasText()) || this.hgP) {
                this.hgO = false;
                this.hgP = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.18
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cbq();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void t(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        super.t(bVar);
        if (this.heR != null) {
            this.heR.G(bVar);
        }
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject = new JSONObject(bVar.getContent());
            }
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (this.heY == null || !this.heY.N(jSONObject)) {
            if ((bVar.getMsgType() == 12 || bVar.getMsgType() == 13) && jSONObject != null) {
                String optString = jSONObject.optString("content_type");
                if ("task".equals(optString)) {
                    if (this.heQ != null) {
                        this.heQ.J(jSONObject);
                    }
                } else if ("enter_live".equals(optString)) {
                    if (this.heP != null && this.heP.getCount() > 20) {
                        this.heP.eZ(this.heP.getCount() + 1);
                    } else if (this.heL != null) {
                        com.baidu.live.data.a NU = bVar.NU();
                        p pVar = new p();
                        pVar.aJW = new AlaLocationData();
                        pVar.aJX = new AlaRelationData();
                        pVar.aJV = new AlaLiveUserInfoData();
                        pVar.aJV.userId = JavaTypesHelper.toLong(NU.userId, 0L);
                        pVar.aJV.userName = NU.userName;
                        pVar.aJV.portrait = NU.portrait;
                        if (this.heP != null && this.heL.c(pVar)) {
                            this.heP.eZ(this.heP.getCount() + 1);
                        }
                    }
                } else if ("update_liveinfo".equals(optString)) {
                    if (cbX().hpT.Iq() != null && cbX().hpT.Iq().mLiveInfo != null) {
                        cbX().hpT.a(cbX().hpT.Iq().mLiveInfo.live_id, cbX().fromType, cbX().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && cbX().hpT.Iq() != null && cbX().hpT.Iq().mLiveInfo != null && cbX().hpT.Iq().aKr != null && this.heU != null) {
                    long optLong = jSONObject.optLong("mvp_user_id");
                    long optLong2 = jSONObject.optLong("winner_live_id");
                    if (optLong == cbX().hpT.Iq().aKr.userId && optLong2 == cbX().hpT.Iq().mLiveInfo.live_id) {
                        this.heU.c(jSONObject.optInt("challenge_status"), jSONObject.optLong("challenge_id"));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void Ic(String str) {
        if (this.heR != null) {
            this.heR.Ic(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void j(w wVar) {
        super.j(wVar);
        if (this.heM != null) {
            this.heM.M(wVar);
        }
        if (this.heN != null) {
            this.heN.I(wVar);
        }
        if (this.heQ != null) {
            this.heQ.L(wVar);
        }
        if (this.heU != null) {
            this.heU.a(wVar);
        }
        if (this.heW != null) {
            this.heW.a(wVar);
        }
        if (this.heR != null) {
            this.heR.i(wVar);
            if (wVar != null && this.hgy != null && !this.hgy.hasInit && !TextUtils.isEmpty(this.hgy.aRg)) {
                this.hgy.hasInit = true;
                this.heR.Id(this.hgy.aRg);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(q qVar) {
        if (qVar != null) {
            if (this.heL != null && qVar.getList() != null) {
                this.heL.e(qVar);
            }
            if (this.heP != null) {
                this.heP.eZ(qVar.getCount());
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void cz(boolean z) {
        super.cz(z);
        if (cbX().hpU != null) {
            cbX().hpU.cll();
            cbX().hpU.setLiveViewOnDispatchTouchEventListener(null);
            cbX().hpU.setLiveViewOnTouchEventListener(null);
            cbX().hpU.setOnLiveViewScrollListener(null);
        }
        if (cbX().brf != null) {
            cbX().brf.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
        }
        if (this.heU != null) {
            this.heU.En();
        }
        caR();
        if (this.heO != null) {
            this.heO.En();
        }
        if (this.hfR != null) {
            this.hfR.release();
        }
        if (this.heQ != null) {
            this.heQ.En();
        }
        if (this.heY != null) {
            this.heY.Do();
        }
        if (this.hfG != null) {
            this.hfG.cjS();
        }
        if (this.heN != null) {
            this.heN.ces();
            this.heN.setVisible(8);
        }
        if (this.heS != null) {
            this.heS.En();
        }
        if (this.heR != null) {
            this.heR.release();
        }
        if (this.buZ != null) {
            this.buZ.removeAllViews();
            this.buZ = null;
        }
        if (this.heT != null) {
            this.heT.En();
        }
        if (this.heW != null) {
            this.heW.a((a.InterfaceC0193a) null);
            this.heW.DN();
        }
        if (this.heM != null) {
            this.heM.cgt();
        }
        if (this.hfb != null && (this.hfb.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hfb.getParent()).removeView(this.hfb);
        }
        if (this.heX != null) {
            this.heX.dismiss();
        }
        if (this.hfc != null) {
            this.hfc.da(false);
            this.hfc.Vj();
        }
        if (this.hfi != null) {
            this.hfi.En();
        }
        if (this.hgW != null) {
            this.hgW.cdm();
        }
        if (this.hgA != null) {
            this.hgA.En();
        }
        if (this.hgF != null) {
            this.hgF.Do();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void m(w wVar) {
        View DL;
        super.m(wVar);
        if (this.heW != null && (DL = this.heW.DL()) != null && DL.getParent() != null) {
            ((ViewGroup) DL.getParent()).removeView(DL);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.heW != null) {
            this.heW.setOtherParams(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cx(boolean z) {
        super.cx(z);
        this.hfg.removeCallbacksAndMessages(null);
        caR();
        this.hfe = false;
        this.hff = false;
        if (this.heM != null) {
            this.heM.onDestroy();
        }
        if (this.heO != null) {
            this.heO.onDestroy();
        }
        if (this.heQ != null) {
            this.heQ.onDestroy();
        }
        if (this.heS != null) {
            this.heS.onDestroy();
        }
        if (this.heT != null) {
            this.heT.onDestroy();
        }
        if (this.heU != null) {
            this.heU.onDestroy();
        }
        if (this.heV != null) {
            this.heV.onDestroy();
        }
        if (this.heX != null) {
            this.heX.onDestroy();
        }
        if (this.heN != null) {
            this.heN.onDestroy();
        }
        if (this.hfc != null) {
            this.hfc.stop();
        }
        if (this.hfR != null) {
            this.hfR.onDestroy();
        }
        if (this.heL != null) {
            this.heL.onDestroy();
        }
        if (this.hfW != null) {
            this.hfW.onDestroy();
        }
        if (this.hfG != null) {
            this.hfG.onDestory();
        }
        if (this.heW != null) {
            this.heW.a((a.InterfaceC0193a) null);
            this.heW.release();
            this.heW = null;
        }
        if (this.hgW != null) {
            this.hgW.cx(z ? false : true);
        }
        if (this.hfi != null) {
            this.hfi.onDestroy();
            this.hfi = null;
        }
        if (this.hgA != null) {
            this.hgA.onDestroy();
        }
        if (this.heY != null) {
            this.heY.onDestroy();
        }
        if (this.hgF != null) {
            this.hgF.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.hfk);
        MessageManager.getInstance().removeMessageRule(this.hfj);
        MessageManager.getInstance().removeMessageRule(this.hfl);
        MessageManager.getInstance().removeMessageRule(this.hfm);
        MessageManager.getInstance().unRegisterListener(this.hfp);
        MessageManager.getInstance().unRegisterListener(this.hft);
        MessageManager.getInstance().unRegisterListener(this.hfu);
        MessageManager.getInstance().unRegisterListener(this.hfv);
        MessageManager.getInstance().unRegisterListener(this.hfs);
        MessageManager.getInstance().unRegisterListener(this.hfr);
        MessageManager.getInstance().unRegisterListener(this.hfq);
    }

    private void caR() {
        if (this.hfW != null && this.hfW.Nd().getView() != null && this.hfW.Nd().getView().getParent() != null) {
            ((ViewGroup) this.hfW.Nd().getView().getParent()).removeView(this.hfW.Nd().getView());
        }
        if (this.heZ != null && this.heZ.getParent() != null) {
            ((ViewGroup) this.heZ.getParent()).removeView(this.heZ);
        }
        if (this.hfa != null && this.hfa.getParent() != null) {
            ((ViewGroup) this.hfa.getParent()).removeView(this.hfa);
        }
        if (this.hfW != null && this.hfW.Ne().getView() != null) {
            this.hgH.removeView(this.hfW.Ne().getView());
        }
        if (this.hfW != null) {
            this.hfW.Nd().setMsgData(new LinkedList());
            this.hfW.DN();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void a(ar arVar) {
        if (this.hfW != null) {
            cbq();
            this.hfW.Ne().setEditText(" @" + arVar.getNameShow() + " ");
        }
        if (this.hfG != null) {
            this.hfG.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void g(com.baidu.live.data.a aVar) {
        if (this.hfW != null) {
            cbq();
            this.hfW.Ne().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.hfG != null) {
            this.hfG.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void If(String str) {
        if (this.hfW != null) {
            cbq();
            StringBuilder sb = new StringBuilder();
            sb.append(" @");
            sb.append(str);
            sb.append(" ");
            if (com.baidu.live.ae.a.RB().brA.aOc != null && com.baidu.live.ae.a.RB().brA.aOc.originTexts != null && com.baidu.live.ae.a.RB().brA.aOc.originTexts.size() > 0) {
                this.hfW.Ne().OS();
                this.hfW.Ne().setEditText(sb.toString() + com.baidu.live.ae.a.RB().brA.aOc.originTexts.get(0));
            } else {
                this.hfW.Ne().setEditText(sb.toString());
            }
        }
        if (this.hfG != null) {
            this.hfG.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void b(ar arVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected View caS() {
        if (this.hfW != null) {
            return this.hfW.Ne().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean caT() {
        if (this.hfW == null || !this.hfW.Ne().OQ()) {
            return false;
        }
        ng(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected boolean caU() {
        return this.heM == null || this.heM.caU();
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected ViewGroup caV() {
        return this.buZ;
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
                    this.hgL = false;
                    N(intExtra, intExtra2, intExtra3);
                    return;
                }
                caL();
                return;
            }
            ays();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.hgK;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(cbX().pageContext.getPageActivity()) || z2) {
            nf(z);
        }
    }

    private void nf(boolean z) {
        if (this.hfW != null && this.hfW.Nd() != null) {
            this.hfW.Nd().onKeyboardVisibilityChanged(z);
        }
        if (z || this.hfW == null || !this.hfW.Ne().OQ()) {
            if (z) {
                if (this.hfG != null) {
                    this.hfG.setVisibility(8);
                }
                if (this.hfY != null && this.hfY.HN() != null) {
                    this.hfY.HN().setVisibility(8);
                }
                caX();
                if (this.hfW != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hfW.Ne().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.hfW.Ne().getView().setLayoutParams(layoutParams);
                    this.hfW.Ne().getView().setVisibility(0);
                    this.hfW.Ne().setQuickInputPanelVisible(false);
                    this.hfW.Nf().cp(false);
                }
                if (this.hgG != null) {
                    this.hgG.setVisibility(8);
                }
                if (this.heR != null) {
                    this.heR.setVisible(8);
                }
                if (this.hfX != null) {
                    this.hfX.DM();
                }
                if (this.hgz != null) {
                    this.hgz.setCanVisible(false);
                }
                if (this.hgq != null) {
                    this.hgq.setCanVisible(false);
                }
                if (this.hgu != null) {
                    this.hgu.setCanVisible(false);
                }
                if (this.hgv != null) {
                    this.hgv.setVisible(8);
                }
                if (this.hgt != null) {
                    this.hgt.setCanVisible(false);
                }
                if (this.hgF != null) {
                    this.hgF.setCanVisible(false);
                }
            } else {
                caW();
            }
            if (this.hfW != null && this.heZ != null) {
                if (this.hgH.indexOfChild(this.heZ) != -1 && this.heZ.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.heZ.getLayoutParams();
                    layoutParams2.height = com.baidu.live.ak.c.i(true, z);
                    this.heZ.setLayoutParams(layoutParams2);
                }
                if (this.heZ.indexOfChild(this.hfW.Nd().getView()) != -1 && this.hfW.Nd().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.hfW.Nd().getView().getLayoutParams();
                    layoutParams3.height = com.baidu.live.ak.c.i(true, z);
                    this.hfW.Nd().getView().setLayoutParams(layoutParams3);
                }
                this.hfW.Nd().Nc();
            }
        }
    }

    private void caW() {
        if (this.hfG != null) {
            this.hfG.setVisibility(0);
        }
        if (this.heZ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.heZ.getLayoutParams();
            layoutParams.bottomMargin = cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            this.heZ.setLayoutParams(layoutParams);
        }
        if (this.hfW != null) {
            cbs();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hfW.Ne().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.hfW.Ne().getView().setLayoutParams(layoutParams2);
            if (UtilHelper.getRealScreenOrientation(cbX().pageContext.getPageActivity()) != 2 && !this.hfW.Nf().isClicked()) {
                this.hfW.Nf().cp(true);
            }
        }
        if (this.hfG != null) {
            this.hfG.setVisibility(0);
        }
        if (this.hfY != null && this.hfY.HN() != null) {
            this.hfY.HN().setVisibility(0);
        }
        if (this.hgG != null && (!this.hfe || UtilHelper.getRealScreenOrientation(cbX().pageContext.getPageActivity()) != 2)) {
            this.hgG.setVisibility(0);
        }
        if (this.heR != null) {
            this.heR.setVisible(0);
        }
        if (this.hfX != null) {
            this.hfX.DM();
        }
        if (this.hgz != null) {
            this.hgz.setCanVisible(true);
        }
        if (this.hgq != null) {
            this.hgq.setCanVisible(true);
        }
        if (this.hgu != null) {
            this.hgu.setCanVisible(true);
        }
        if (this.hgv != null) {
            this.hgv.setVisible(0);
        }
        if (this.hgt != null) {
            this.hgt.setCanVisible(true);
        }
        if (this.hgF != null) {
            this.hgF.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caX() {
        boolean z;
        boolean z2 = false;
        if (this.heZ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.heZ.getLayoutParams();
            if (this.hfW == null || this.hfW.Ne() == null) {
                z = false;
            } else {
                z = this.hfW.Ne().OO();
                z2 = this.hfW.Ne().OP();
            }
            int M = M(z, z2);
            if (layoutParams.bottomMargin != M) {
                layoutParams.bottomMargin = M;
                this.heZ.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ng(boolean z) {
        if (z) {
            this.hfW.Ne().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.heZ.getLayoutParams();
            int quickInputPanelExpandHeight = this.hfW.Ne().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.heZ.setLayoutParams(layoutParams);
                if (this.hfW.Nd() != null) {
                    this.hfW.Nd().Nc();
                    return;
                }
                return;
            }
            return;
        }
        caW();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        FrameLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = cbX().pageContext.getPageActivity();
        if (i3 == 1) {
            if (cbX().pageContext.getPageActivity() != null && !UtilHelper.canUseStyleImmersiveSticky()) {
                com.baidu.live.utils.q.e(cbX().pageContext.getPageActivity(), true);
            }
            if (this.hgG != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.hgG.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.heX != null) {
                this.heX.dismiss();
            }
            if (this.heW != null) {
                this.heW.a((a.InterfaceC0193a) null);
                this.heW.DN();
            }
            if (this.brc != null) {
                this.brc.e(true, true);
            }
            if (this.hfb != null) {
                this.hfb.setVisibility(0);
                this.hfb.bringToFront();
            }
            if (this.hfM != null) {
                this.hfM.setVisibility(0);
            }
            if (this.hfW != null && this.hfW.Nd().getView().getParent() != null && (this.hfW.Nd().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hfW.Nd().getView().getParent()).removeView(this.hfW.Nd().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(cbX().pageContext.getPageActivity()) * 0.7f);
            int i4 = com.baidu.live.ak.c.i(true, false);
            if (this.heZ != null && this.hfW != null) {
                this.heZ.addView(this.hfW.Nd().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, i4));
            }
            if (this.hfa != null && (this.hfa.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hfa.getParent()).removeView(this.hfa);
            }
            if (this.hfX != null) {
                this.hfX.a(cbX().hpT.Iq(), false);
                this.hfX.a(new a.InterfaceC0193a() { // from class: com.baidu.tieba.ala.liveroom.d.a.19
                    @Override // com.baidu.live.im.b.a.InterfaceC0193a
                    public void NJ() {
                        a.this.cbI();
                    }
                });
                View DL = this.hfX.DL();
                if (DL != null && this.hgH != null && DL.getParent() == null) {
                    Resources resources = cbX().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(cbX().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                    layoutParams5.addRule(2, a.f.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                    this.hgH.addView(DL, layoutParams5);
                }
            }
            if (this.hfO != null) {
                this.hfO.setPraiseEnable(true);
                cbX().hpU.hFu = true;
            }
            if (this.heL != null && this.heL.hij != null && (layoutParams3 = (FrameLayout.LayoutParams) this.heL.hij.getLayoutParams()) != null) {
                layoutParams3.width = -2;
                this.heL.hij.setLayoutParams(layoutParams3);
            }
            if (this.hfR != null) {
                this.hfR.clL();
            }
            if (this.hfe) {
                ne(true);
            }
            if (this.hff) {
                if (this.hfG != null && this.hfG.getLandscapeBarrageImageView() != null) {
                    b(this.hfG.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.hfG != null) {
                this.hfG.xk(0);
            }
            if (this.heP != null) {
                this.heP.nr(true);
            }
            this.hfg.removeCallbacksAndMessages(null);
            if (this.heQ != null) {
                this.heQ.setCanVisible(true);
                this.heQ.L(cbX().hpT.Iq());
            }
            if (this.heY != null) {
                this.heY.cL(true);
            }
            if (this.hfW != null && !this.hfW.Nf().isClicked()) {
                this.hfW.Nf().cp(true);
            }
        } else if (i3 == 2) {
            if (cbX().pageContext.getPageActivity() != null && !UtilHelper.canUseStyleImmersiveSticky()) {
                com.baidu.live.utils.q.e(cbX().pageContext.getPageActivity(), false);
            }
            if (this.hfR != null) {
                this.hfR.clM();
            }
            if (this.hgG != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.hgG.getLayoutParams()) != null) {
                layoutParams2.topMargin = cbX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
            }
            if (this.hfX != null) {
                this.hfX.a((a.InterfaceC0193a) null);
                this.hfX.DN();
            }
            cbX().hpU.cln();
            if (this.brc != null) {
                this.brc.e(false, true);
            }
            if (this.hfb != null) {
                this.hfb.setVisibility(4);
            }
            if (this.hfW != null && this.hfW.Nd().getView().getParent() != null && (this.hfW.Nd().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hfW.Nd().getView().getParent()).removeView(this.hfW.Nd().getView());
                this.hfW.Nf().cp(false);
            }
            int max = Math.max(i, i2);
            if (this.hfa != null) {
                if (this.hfa.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hfa.getParent()).removeView(this.hfa);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100);
                cbX().hpU.addView(this.hfa, this.buZ != null ? cbX().hpU.indexOfChild(this.buZ) : -1, layoutParams6);
            }
            if (this.hfa != null && this.heW != null) {
                this.heW.a(cbX().hpT.Iq(), false);
                this.heW.a(new a.InterfaceC0193a() { // from class: com.baidu.tieba.ala.liveroom.d.a.20
                    @Override // com.baidu.live.im.b.a.InterfaceC0193a
                    public void NJ() {
                        a.this.cbI();
                    }
                });
                View DL2 = this.heW.DL();
                if (DL2 != null && this.hfa.indexOfChild(DL2) < 0) {
                    this.hfa.addView(DL2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(cbX().pageContext.getPageActivity()), -1));
                }
            }
            if (this.hfO != null) {
                this.hfO.aA(cbX().hpU);
                this.hfO.setPraiseEnable(false);
                cbX().hpU.hFu = false;
            }
            if (this.heL != null && this.heL.hij != null && (layoutParams = (FrameLayout.LayoutParams) this.heL.hij.getLayoutParams()) != null) {
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                layoutParams.width = (int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f);
                this.heL.hij.setLayoutParams(layoutParams);
            }
            if (this.hfG != null) {
                this.hfG.xk(8);
            }
            if (this.heP != null) {
                this.heP.nr(false);
            }
            if (al.IE() != null) {
                al.IE().ID();
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.ah.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.ah.c) runTask.getData()).ID();
            }
            if (this.hfG != null && this.hfG.getLandscapeBarrageImageView() != null) {
                b(this.hfG.getLandscapeBarrageImageView(), this.hff, false);
            }
            cal();
            if (this.hfY != null) {
                this.hfY.HP();
            }
            if (this.heQ != null) {
                this.heQ.setCanVisible(false);
                this.heQ.cfv();
            }
            if (this.heY != null) {
                this.heY.setCanVisible(false);
            }
        }
        if (this.hgu != null) {
            this.hgu.en(i3);
        }
        if (this.hgf != null) {
            this.hgf.en(i3);
        }
        if (this.hfZ != null) {
            this.hfZ.en(i3);
        }
        if (this.hfW != null) {
            this.hfW.Nf().en(i3);
        }
        if (this.hfG != null) {
            this.hfG.l(i, i2, i3);
        }
        K(i3, true);
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.heL != null) {
                this.heL.dX(i3);
            }
            if (this.heN != null) {
                this.heN.dX(i3);
            }
            if (this.heR != null) {
                this.heR.dX(i3);
            }
            if (this.hgh != null) {
                this.hgh.dX(i3);
            }
            if (this.hgc != null) {
                this.hgc.dX(i3);
            }
            if (this.hgl != null) {
                this.hgl.dX(i3);
            }
            if (this.hgn != null) {
                this.hgn.dX(i3);
            }
            if (this.gTT != null) {
                this.gTT.dX(i3);
            }
            if (this.hfh != null && this.hfh.isShowing()) {
                this.hfh.resize();
            }
            if (this.hgz != null) {
                this.hgz.dX(i3);
            }
            if (this.hgA != null) {
                this.hgA.dX(i3);
            }
            if (this.hgx != null) {
                this.hgx.en(i3);
            }
            if (this.hgD != null) {
                this.hgD.dX(i3);
            }
        }
        if (this.hfY != null) {
            this.hfY.HO();
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public boolean fh(int i) {
        boolean fh = super.fh(i);
        if (fh && 2 == i) {
            if (this.heM.caU()) {
                return false;
            }
            if (fh && this.hfR != null) {
                this.hfR.on(false);
            }
        }
        return fh;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void wy(int i) {
        super.wy(i);
        if (i == 7 || i == 11) {
            if (i != 7 || UtilHelper.getRealScreenOrientation(cbX().pageContext.getPageActivity()) != 2) {
                if (this.hfG != null) {
                    this.hfG.setVisibility(8);
                }
                if (this.hfW != null) {
                    this.hfW.Nd().getView().setVisibility(4);
                    this.hfW.Nf().cp(false);
                }
                if (this.hgm != null) {
                    this.hgm.oh(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public void fi(int i) {
        super.fi(i);
        if (i == 7 || i == 11) {
            if (this.hfG != null) {
                this.hfG.setVisibility(0);
            }
            if (this.hfW != null) {
                this.hfW.Nd().getView().setVisibility(0);
                if (UtilHelper.getRealScreenOrientation(cbX().pageContext.getPageActivity()) != 2 && !this.hfW.Nf().isClicked()) {
                    this.hfW.Nf().cp(true);
                }
            }
            if (this.hgm != null) {
                this.hgm.oh(true);
            }
            if (!this.hfe || UtilHelper.getRealScreenOrientation(cbX().pageContext.getPageActivity()) != 2) {
                this.hgG.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.heO != null) {
            this.heO.ckq();
        }
        if (this.heT != null) {
            this.heT.Ew();
        }
        if (this.heR != null) {
            this.heR.onStop();
        }
        if (this.hgD != null) {
            this.hgD.onStop();
        }
        if (cbX() != null) {
            BdUtilHelper.hideSoftKeyPad(cbX().pageContext.getPageActivity(), cbX().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.heO != null) {
            this.heO.ckp();
        }
        if (this.heT != null) {
            this.heT.Ex();
        }
        if (this.heR != null) {
            this.heR.onStart();
        }
        if (this.hgx != null) {
            this.hgx.onStart();
        }
        if (this.hgD != null) {
            this.hgD.onStart();
        }
        if (this.hgF != null) {
            this.hgF.onStart();
        }
    }

    private void K(int i, boolean z) {
        if (this.buZ != null) {
            int dimensionPixelSize = cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.buZ.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                layoutParams.rightMargin = cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6);
                layoutParams.height = cau();
                this.buZ.setPosition(dimensionPixelSize, 0, dimensionPixelSize, 0);
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                int dimensionPixelSize2 = cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds72) + 0 + cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100) + cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
                layoutParams.height = -1;
                this.buZ.setPosition(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
            }
            layoutParams.bottomMargin = cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            this.buZ.setLayoutParams(layoutParams);
            this.buZ.setModel(i == 1 ? PendantParentView.Model.HORIZONTAL : PendantParentView.Model.HORIZONTAL_FULL);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.e
    public void wz(int i) {
        K(this.mOrientation, false);
    }
}
