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
    private com.baidu.tieba.ala.liveroom.audiencelist.c heJ;
    private com.baidu.tieba.ala.liveroom.o.a heK;
    private com.baidu.tieba.ala.liveroom.g.b heL;
    private com.baidu.tieba.ala.liveroom.u.b heM;
    private com.baidu.tieba.ala.liveroom.audiencelist.b heN;
    private com.baidu.tieba.ala.liveroom.l.a heO;
    private com.baidu.tieba.ala.liveroom.activeview.b heP;
    private com.baidu.live.f.a heQ;
    private i heR;
    private h heS;
    private com.baidu.tieba.ala.liveroom.c.a heT;
    private com.baidu.live.im.b.a heU;
    private com.baidu.tieba.ala.liveroom.share.b heV;
    private com.baidu.live.ad.a heW;
    private FrameLayout heX;
    private FrameLayout heY;
    private ImageView heZ;
    private com.baidu.live.tieba.e.b hfa;
    private ah hff;
    private com.baidu.tieba.ala.liveroom.j.b hfg;
    private long lastClickTime = 0;
    private boolean hfb = false;
    private boolean hfc = false;
    private boolean hfd = false;
    private Handler hfe = new Handler();
    private HttpRule hfh = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.heR != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.heR.EC()) {
                httpMessage.addParam("ala_challenge_id", a.this.heR.EF());
            }
            return httpMessage;
        }
    };
    private HttpRule hfi = new HttpRule(1021229) { // from class: com.baidu.tieba.ala.liveroom.d.a.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.heR != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.heR.EC()) {
                httpMessage.addParam("challenge_id", a.this.heR.EF());
            }
            return httpMessage;
        }
    };
    private HttpRule hfj = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.a.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.heR != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.heR.EC()) {
                httpMessage.addParam("challenge_id", a.this.heR.EF());
            }
            return httpMessage;
        }
    };
    private HttpRule hfk = new HttpRule(1021232) { // from class: com.baidu.tieba.ala.liveroom.d.a.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.heR != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.heR.EC()) {
                httpMessage.addParam("challenge_id", a.this.heR.EF());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c hfl = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.23
        @Override // com.baidu.live.liveroom.g.c
        public void PL() {
            if (a.this.hfP != null) {
                a.this.hfP.on(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cA(boolean z) {
            if (z) {
                if (a.this.hfP != null) {
                    a.this.hfP.on(true);
                }
            } else if (a.this.hfP != null) {
                a.this.hfP.on(false);
            }
            if (a.this.hgi != null) {
                a.this.hgi.bE(z);
            }
            if (a.this.heP != null) {
                a.this.heP.nd(z ? false : true);
            }
            com.baidu.live.p.a.cB(z);
        }
    };
    private com.baidu.tieba.ala.liveroom.o.c hfm = new com.baidu.tieba.ala.liveroom.o.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.24
        @Override // com.baidu.tieba.ala.liveroom.o.c
        public void onClick() {
            a.this.hfe.removeCallbacksAndMessages(null);
            a.this.hfb = true;
        }

        @Override // com.baidu.tieba.ala.liveroom.o.c
        public void endAnimation() {
            if (a.this.hfb) {
                a.this.cak();
            }
        }
    };
    private HttpMessageListener hfn = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.PU() != null) {
                        com.baidu.live.ae.e.RP().bxB = getQuickGiftHttpResponseMessage.PU();
                        a.this.caA();
                    }
                }
            }
        }
    };
    private CustomMessageListener hfo = new CustomMessageListener(2913276) { // from class: com.baidu.tieba.ala.liveroom.d.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            JSONObject optJSONObject;
            JSONArray optJSONArray;
            if (a.this.mOrientation == 1 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject) && (optJSONObject = ((JSONObject) customResponsedMessage.getData()).optJSONObject("ext_data")) != null && (optJSONArray = optJSONObject.optJSONArray("surprise_prize_member")) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                View inflate = LayoutInflater.from(a.this.activity).inflate(a.g.ala_fudai_dialog_layout, (ViewGroup) null);
                final Dialog dialog = new Dialog(a.this.cbW().pageContext.getPageActivity(), a.i.FudaiDialogStyle);
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
    private CustomMessageListener hfp = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                a.this.hfX.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hfq = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.hgl != null) {
                    a.this.hgl.ir(str);
                }
            }
        }
    };
    CustomMessageListener hfr = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.hgL != null && a.this.hgL.bja != null && !a.this.hgL.bjf && !a.this.hgL.bjg && a.this.hgh != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.cbW().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                if (a.this.hfU != null && a.this.hfU.Nf().OY()) {
                    layoutParams.bottomMargin = a.this.cbW().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds70);
                } else {
                    layoutParams.bottomMargin = a.this.cbW().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                }
                a.this.hgh.b(a.this.heX, layoutParams);
                if (com.baidu.live.guardclub.e.LY() != null) {
                    com.baidu.live.guardclub.e.LY().Md();
                }
            }
        }
    };
    private CustomMessageListener hfs = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.a.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (a.this.hgj != null) {
                    a.this.hgj.dismiss();
                }
                if (a.this.hgl != null) {
                    a.this.hgl.dismiss();
                }
                if (a.this.gTR != null) {
                    a.this.gTR.dismiss();
                }
                com.baidu.live.im.b.d.NK().setSwitchStatus(true);
                com.baidu.live.im.b.d.NK().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cbp();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener hft = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.a.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.hfg.c(a.this.cbW());
                } else if (a.this.cbi() || !g.wL(2913168)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.cbW().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.cbW().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    a.this.hfg.b(a.this.heX, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b hfu = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.a.15
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
                        if (a.this.cbW().hpR.Iq() != null && a.this.cbW().hpR.Iq().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.cbW().hpR.Iq().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.cbW().hpR.Iq().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.Oj());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.Le()) {
                        if (com.baidu.live.d.BM().getBoolean("quick_gift_guide_show", true) && !a.this.cbi()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, ah.class, a.this.cbW().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                ah ahVar = (ah) runTask.getData();
                                ahVar.setPageContext(a.this.cbW().pageContext);
                                ahVar.setLiveShowData(a.this.cbW().hpR.Iq());
                                ahVar.setGiftItem(com.baidu.live.ae.e.RP().bxB.HW());
                                ahVar.setOtherParams(a.this.Oj());
                                ahVar.initView();
                                ahVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.15.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        a.this.ni(false);
                                        a.this.hff = null;
                                    }
                                });
                                a.this.hff = ahVar;
                                ahVar.show();
                                a.this.ni(true);
                                return;
                            }
                            return;
                        }
                        n.a(a.this.cbW().pageContext, a.this.cbW().hpR.Iq(), com.baidu.live.ae.e.RP().bxB.HW(), a.this.Oj());
                    }
                } else if (i == 1) {
                    if (a.this.hfU != null) {
                        a.this.cbp();
                    }
                } else if (i == 3 && a.this.Le()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    if (a.this.mOrientation == 2 && (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                        if (a.this.heV != null) {
                            a.this.heV.R(a.this.cbW().hpR.Iq());
                        }
                    } else {
                        a.this.hfH.c(a.this.cbW().hpR.Iq(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.cbW() != null && a.this.cbW().hpR != null && a.this.cbW().hpR.Iq() != null && a.this.cbW().hpR.Iq().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.cbW().hpR.Iq().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.cbW().hpR.Iq().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.cbW().hpR.Iq().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.Oj());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.cbW() != null && a.this.cbW().hpR != null && a.this.cbW().hpR.Iq() != null && a.this.cbW().hpR.Iq().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.cbW().hpR.Iq().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.cbW().hpR.Iq().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.cbW().hpR.Iq().mLiveInfo.feed_id + "");
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
                    if (a.this.hfP != null) {
                        String valueOf = String.valueOf(a.this.cbW().hpR.Iq().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.cbW().hpR.Iq().mLiveInfo.room_id);
                        String str3 = null;
                        AlaLiveSdkInfo alaLiveSdkInfo = a.this.cbW().hpR.Iq().mLiveSdkInfo;
                        if (alaLiveSdkInfo != null && alaLiveSdkInfo.mCastIds != null) {
                            str3 = String.valueOf(a.this.cbW().hpR.Iq().mLiveSdkInfo.mCastIds.chatMCastId);
                        }
                        a.this.hfP.au(valueOf, valueOf2, str3);
                        com.baidu.live.p.a.b(a.this.cbW().hpR.Iq().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    w Iq = a.this.cbW().hpR.Iq();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.cbW().pageContext.getPageActivity(), Iq.aJV.userName, Long.toString(Iq.aJV.userId), Long.toString(Iq.aJV.charmCount), String.valueOf(Iq.mLiveInfo.group_id), String.valueOf(Iq.mLiveInfo.live_id), false, String.valueOf(Iq.aJV.userId), Long.toString(Iq.aKr.userId), Iq.aKr.userName, Iq.aKr.portrait, a.this.heN.getCount(), a.this.Oj())));
                    LogManager.getCommonLogger().doClickGusetNumLog(Iq.mLiveInfo.feed_id, a.this.heN.getCount() + "", a.this.Oj());
                } else if (i == 11) {
                    a.this.cbt();
                    a.this.cbu();
                } else if (i == 16) {
                    if (a.this.cbW() != null && (boVar2 = com.baidu.live.ae.a.RB().bxq) != null && (cfVar2 = boVar2.aQM) != null) {
                        String str4 = cfVar2.aSj.aSq;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (a.this.cbW().hpR != null && a.this.cbW().hpR.Iq() != null && a.this.cbW().hpR.Iq().mLiveInfo != null) {
                                j = a.this.cbW().hpR.Iq().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", a.this.cbW().hpR.Iq().mLiveInfo.room_id + "", a.this.cbW().hpR.Iq().mLiveInfo.feed_id, a.this.Oj());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.cbW().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (a.this.cbW() != null) {
                        w wVar = null;
                        if (a.this.cbW().hpR != null) {
                            wVar = a.this.cbW().hpR.Iq();
                        }
                        if (wVar != null && wVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.v.b.ckA().brJ != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.v.b.ckA().brJ.aJj;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(a.this.cbW().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17) {
                    if (a.this.Le() && a.this.cbW() != null && (boVar = com.baidu.live.ae.a.RB().bxq) != null && (cfVar = boVar.aQM) != null && (clVar = cfVar.aSk) != null && !TextUtils.isEmpty(clVar.webUrl)) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                        if (a.this.hgj != null && a.this.cbW().hpR != null && a.this.cbW().hpR.Iq() != null) {
                            w Iq2 = a.this.cbW().hpR.Iq();
                            a.this.hgj.a(clVar.webUrl, Iq2.mLiveInfo.live_id, Iq2.aKr.userId, Iq2.aJV.userId);
                            a.this.hfa.da(false);
                            a.this.hfa.Vj();
                        }
                    }
                } else if (i == 18) {
                    if (a.this.hfd) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.hfd = !a.this.hfd;
                } else if (i == 19 && a.this.hfa != null) {
                    a.this.hfa.Vj();
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.hfJ = new com.baidu.tieba.ala.liveroom.guide.c(cbW().pageContext, this, false);
        this.hfi.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hfi);
        this.hfh.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hfh);
        this.hfj.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hfj);
        this.hfk.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hfk);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean caj() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cak() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.25
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.hfc) {
                    a.this.ne(false);
                }
            }
        }, 5000L);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(w wVar) {
        super.l(wVar);
        g.cfq();
        this.hfd = false;
        if (this.hfM != null) {
            this.hfM.b(this.hfu);
        }
        if (this.hfa == null) {
            this.hfa = new com.baidu.live.tieba.e.b(cbW().pageContext.getPageActivity());
            this.hfa.start();
        }
        this.hfa.da(true);
        cbW().pageContext.getPageActivity().setRequestedOrientation(-1);
        cbW().hpS.setIsForceHandledTouch(false);
        cbW().hpS.setSwipeClearEnable(true);
        cbW().hpS.setOnLiveViewScrollListener(this.hfl);
        cbW().hpS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hfe.removeCallbacksAndMessages(null);
                a.this.hfb = false;
                a.this.ne(false);
                if (!a.this.hfc) {
                    a.this.cak();
                }
            }
        });
        if (this.hgE != null) {
            this.hgE.setVisibility(0);
        }
        cas();
        if (this.hgf != null) {
            this.hgf.a(wVar, this.buZ);
            this.hgf.U(this.hgF);
            this.hgf.a(this);
        }
        cbE();
        caE();
        cbe();
        cbd();
        caF();
        cap();
        caJ();
        caG();
        cal();
        nj(false);
        caL();
        cbD();
        cbK();
        cbx();
        cbC();
        caB();
        caC();
        cbw();
        caD();
        cby();
        can();
        caM();
        nl(true);
        cau();
        caA();
        cbO();
        cav();
        caw();
        cax();
        cay();
        caq();
        caO();
        caN();
        cam();
        cbN();
        cbJ();
        car();
        if (this.hgj != null && this.hgj.ckH() == null) {
            this.hgj.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.27
                @Override // com.baidu.tieba.ala.liveroom.turntable.d.a
                public void onDismiss() {
                    a.this.hfa.da(true);
                }
            });
        }
        c(this.giQ);
        MessageManager.getInstance().registerListener(this.hfn);
        MessageManager.getInstance().registerListener(this.hfr);
        MessageManager.getInstance().registerListener(this.hfs);
        MessageManager.getInstance().registerListener(this.hft);
        MessageManager.getInstance().registerListener(this.hfq);
        MessageManager.getInstance().registerListener(this.hfp);
        MessageManager.getInstance().registerListener(this.hfo);
        caP();
        caI();
        if (this.mOrientation == 2) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(cbW().pageContext.getPageActivity());
            l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(cbW().pageContext.getPageActivity()));
        }
        if (this.hgv != null) {
            this.hgv.K(wVar);
        }
        cbA();
    }

    private void cal() {
        if (this.hgv == null) {
            View view = null;
            if (this.hfM != null && this.hfM.getView() != null) {
                view = this.hfM.getView();
            }
            this.hgv = new com.baidu.tieba.ala.liveroom.exclusive.b(cbW().pageContext, PH(), cbW().hpS, view, this.heJ.hig, this);
        }
    }

    private void cam() {
        if (this.hgu != null) {
            this.hgu.a(new com.baidu.live.z.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.2
                @Override // com.baidu.live.z.c
                public void cH(boolean z) {
                    if (a.this.heS != null) {
                        a.this.heS.setNeedCloseRecommendFloat(z);
                    }
                    if (a.this.cbW().hpS.hFs) {
                        if (a.this.hfP != null) {
                            a.this.hfP.of(z);
                            a.this.hfP.on(!z);
                        }
                        if (a.this.hfM != null) {
                            a.this.hfM.of(z);
                            a.this.hfM.setPraiseEnable(!z);
                            a.this.hfM.oe(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ne(boolean z) {
        View Ip;
        if (cbW() != null && cbW().pageContext != null && cbW().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(cbW().pageContext.getPageActivity()) == 2 || z) {
                if (this.hfX != null && (Ip = this.hfX.Ip()) != null) {
                    if (this.hfc) {
                        Ip.setVisibility(0);
                    } else {
                        Ip.setVisibility(8);
                    }
                }
                if (this.hfc) {
                    if (this.hgE != null) {
                        this.hgE.setVisibility(0);
                    }
                    if (this.hgF != null) {
                        this.hgF.setVisibility(0);
                    }
                    if (this.buZ != null) {
                        this.buZ.setVisibility(0);
                    }
                    if (this.buZ != null) {
                        this.buZ.setVisibility(0);
                    }
                    if (this.hfW != null) {
                        this.hfW.bC(false);
                    }
                } else {
                    if (this.hgE != null) {
                        this.hgE.setVisibility(8);
                    }
                    if (this.hgF != null) {
                        this.hgF.setVisibility(8);
                    }
                    if (this.buZ != null) {
                        this.buZ.setVisibility(8);
                    }
                    if (this.buZ != null) {
                        this.buZ.setVisibility(8);
                    }
                    if (this.hfW != null) {
                        this.hfW.bC(true);
                    }
                }
                this.hfc = this.hfc ? false : true;
                if (this.heP != null) {
                    this.heP.nd(this.hfc);
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
            if (this.heY != null) {
                this.heY.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.e.icon_live_barrage_on);
            }
            if (this.heY != null) {
                this.heY.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.hfW != null && (HN = this.hfW.HN()) != null) {
            if (z) {
                HN.setVisibility(8);
            } else {
                HN.setVisibility(0);
            }
        }
    }

    private void can() {
        CustomResponsedMessage runTask;
        if (this.heU == null && (runTask = MessageManager.getInstance().runTask(2913164, com.baidu.live.im.b.a.class, cbW().pageContext)) != null) {
            this.heU = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.heU != null) {
            this.heU.setOtherParams(this.otherParams);
            this.heU.a(new a.InterfaceC0193a() { // from class: com.baidu.tieba.ala.liveroom.d.a.3
                @Override // com.baidu.live.im.b.a.InterfaceC0193a
                public void NJ() {
                    a.this.cbH();
                }
            });
        }
    }

    private void cao() {
        if (this.hfO != null) {
            this.hfO.ax(cbW().hpQ.getLiveContainerView());
        }
    }

    private void cap() {
        if (this.heV == null) {
            this.heV = new com.baidu.tieba.ala.liveroom.share.b(cbW().pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void caq() {
        if (cbW() != null) {
            if (this.heW == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.ad.a.class, cbW().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.heW = (com.baidu.live.ad.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.heW.setIsHost(false);
            this.heW.a(this.buZ, cbW().hpR.Iq().aKU);
        }
    }

    private void car() {
        if (cbW() != null) {
            if (this.hgr == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913271, com.baidu.live.a.a.class, cbW().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hgr = (com.baidu.live.a.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hgr.bf(true);
            this.hgr.a(caU(), cbW().hpR.Iq());
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void eb(int i) {
        super.eb(i);
        if (this.heZ != null && UtilHelper.getRealScreenOrientation(cbW().pageContext.getPageActivity()) != 2) {
            this.heZ.setVisibility(0);
        }
        cao();
        if (this.heS != null) {
            this.heS.eb(i);
        }
        if (this.heS == null || !this.heS.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
        if (this.hgv != null) {
            this.hgv.ceO();
        }
    }

    private void cas() {
        if (this.buZ == null) {
            PendantParentView.Model model = PendantParentView.Model.HORIZONTAL;
            if (this.mOrientation == 2) {
                model = PendantParentView.Model.HORIZONTAL_FULL;
            }
            this.buZ = new PendantParentView(cbW().pageContext.getPageActivity(), model);
            cbW().hpS.addView(this.buZ, ((cbW().hpS.getView() == null || this.hfM == null || this.hfM.getView() == null) ? -1 : cbW().hpS.getView().indexOfChild(this.hfM.getView())) + 1, new RelativeLayout.LayoutParams(-1, cat()));
            this.buZ.setDefaultItemMargin(cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            K(this.mOrientation, false);
        }
    }

    private int cat() {
        int bottom;
        int bottom2;
        if (cbW().brf.getLivePlayer().getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) cbW().brf.getLivePlayer().getLayoutParams();
            bottom = layoutParams.topMargin + layoutParams.height;
        } else {
            bottom = cbW().brf.getLivePlayer().getBottom();
        }
        if (cbW().hpS.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) cbW().hpS.getLayoutParams();
            bottom2 = layoutParams2.topMargin + layoutParams2.height;
        } else {
            bottom2 = cbW().hpS.getBottom();
        }
        int i = 0;
        if (this.hgv != null) {
            i = this.hgv.getHeight();
        }
        return (((bottom2 - bottom) - i) - cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
    }

    private void cau() {
        if (this.heP == null) {
            this.heP = new com.baidu.tieba.ala.liveroom.activeview.b(cbW().pageContext);
        }
        if (cbW() != null && cbW().hpR != null) {
            this.heP.Ia(cbW().hpR.cjO());
        }
        this.heP.setOtherParams(Oj());
        this.heP.b(cbW().hpR.Iq(), true);
        this.heP.setHost(false);
        this.heP.a(1, this.buZ);
        this.heP.a(2, this.buZ);
        this.heP.setVisible(this.hgI ? 8 : 0);
    }

    private void cav() {
        if (this.buZ != null) {
            if (this.heO == null) {
                this.heO = new com.baidu.tieba.ala.liveroom.l.a(cbW().pageContext, this);
            }
            this.heO.setOtherParams(Oj());
            this.heO.a((ViewGroup) this.buZ, caz());
            this.heO.L(cbW().hpR.Iq());
        }
    }

    private void caw() {
        if (this.hgh == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, j.class, cbW().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hgh = (j) runTask.getData();
            } else {
                return;
            }
        }
        this.hgh.setOtherParams(Oj());
        if (this.heX != null && this.heX.indexOfChild(this.hgh.getView()) >= 0) {
            this.heX.removeView(this.hgh.getView());
        }
    }

    private void cax() {
        if (this.hfE != null) {
            this.hfE.a(new a.InterfaceC0695a() { // from class: com.baidu.tieba.ala.liveroom.d.a.11
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0695a
                public void bS(int i, int i2) {
                    w Iq = a.this.cbW().hpR.Iq();
                    if (Iq != null && Iq.mLiveInfo != null) {
                        if (a.this.hgk == null) {
                            a.this.hgk = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.cbW().pageContext.getPageActivity());
                        }
                        a.this.hgk.d(a.this.hgF, i, i2);
                        a.this.hgk.a(String.valueOf(Iq.mLiveInfo.live_id), new a.InterfaceC0699a() { // from class: com.baidu.tieba.ala.liveroom.d.a.11.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0699a
                            public void a(float f, String str) {
                                if (a.this.hfE != null) {
                                    a.this.hfE.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0695a
                public void bT(int i, int i2) {
                    if (a.this.hgk != null) {
                        a.this.hgk.bY(i, i2);
                    }
                }
            });
        }
    }

    private void cay() {
        if (this.hgU == null) {
            this.hgU = new com.baidu.tieba.ala.liveroom.j.e(cbW().pageContext);
        }
        this.hgU.setRoomId(cbW().hpR.Iq().mLiveInfo.room_id);
        this.hgU.It("");
        this.hgU.b(cbW().hpR.Iq(), this.buZ);
        if (this.hfg == null) {
            this.hfg = new com.baidu.tieba.ala.liveroom.j.b(cbW().pageContext, Oj(), this.hgU, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.13
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void caX() {
                    a.this.ni(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void caY() {
                    a.this.ni(false);
                }
            });
        }
        this.hfg.setRoomId(cbW().hpR.Iq().mLiveInfo.room_id);
        if (this.heX != null && this.heX.indexOfChild(this.hfg.getView()) >= 0) {
            this.heX.removeView(this.hfg.getView());
        }
        if (this.hfg != null) {
            this.hfg.b(cbW());
        }
    }

    private LinearLayout.LayoutParams caz() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = cbW().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caA() {
        if (this.hfE == null) {
            caG();
        }
        this.hfE.a(com.baidu.live.ae.e.RP().bxB, cbW().hpR.Iq());
    }

    private void caB() {
        CustomResponsedMessage runTask;
        boolean z = true;
        if (this.hfU == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, cbW().pageContext)) != null && runTask.getData() != null) {
            this.hfU = (k) runTask.getData();
            this.hfU.setFromMaster(false);
            this.hfU.Nd().getView().setId(a.f.ala_liveroom_msg_list);
            this.hfU.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.14
                @Override // com.baidu.live.im.k.a
                public boolean Nh() {
                    return a.this.Le();
                }

                @Override // com.baidu.live.im.k.a
                public void Ni() {
                    a.this.hgM = true;
                }

                @Override // com.baidu.live.im.k.a
                public void id(String str) {
                    if (!a.this.hgI) {
                        a.this.ng(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.cbW().pageContext.getPageActivity(), a.this.cbW().hpQ.getLiveContainerView());
                    }
                    a.this.Ih(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Nj() {
                    if (a.this.hgI) {
                        a.this.ng(true);
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.cbW().pageContext.getPageActivity(), a.this.cbW().hpQ.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (a.this.hfU != null) {
                        a.this.hfU.Ne().setQuickInputPanelVisible(false);
                        a.this.hfU.Ne().OR();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Nk() {
                    if (a.this.hgI) {
                        a.this.caW();
                        if (a.this.hfV != null) {
                            a.this.hfV.DM();
                        }
                        if (a.this.heU != null) {
                            a.this.heU.DM();
                        }
                    } else if (a.this.hfU != null) {
                        a.this.hfU.Ne().setQuickInputPanelVisible(false);
                        a.this.hfU.Ne().OR();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Nl() {
                    return a.this.cbj();
                }

                @Override // com.baidu.live.im.k.a
                public int Nm() {
                    return a.this.cbk();
                }
            });
            this.heX = new FrameLayout(cbW().pageContext.getPageActivity());
            this.heX.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.hfU != null && this.heX != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(cbW().pageContext.getPageActivity()) * 0.7f);
            int i = com.baidu.live.ak.c.i(true, false);
            if (this.hgF.indexOfChild(this.heX) < 0) {
                if (this.heX.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.heX.getParent()).removeView(this.heX);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
                this.hgF.addView(this.heX, layoutParams);
            }
            if (this.heX.indexOfChild(this.hfU.Nd().getView()) < 0) {
                if (this.hfU.Nd().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hfU.Nd().getView()).removeView(this.hfU.Nd().getView());
                }
                if (UtilHelper.getRealScreenOrientation(cbW().pageContext.getPageActivity()) != 2) {
                    this.heX.addView(this.hfU.Nd().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, i));
                }
            }
            if (cbW().hpS.indexOfChild(this.hfU.Ne().getView()) < 0) {
                if (this.hfU.Ne().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hfU.Ne().getView().getParent()).removeView(this.hfU.Ne().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                cbr();
                cbW().hpS.addView(this.hfU.Ne().getView(), layoutParams2);
            }
            w Iq = cbW().hpR.Iq();
            if (Iq != null && Iq.mLiveInfo != null) {
                this.hfU.setLogData(Iq.mLiveInfo.feed_id, Oj());
            }
            if (Iq == null || Iq.aKI == null || !Iq.aKI.Fb()) {
                z = false;
            }
            this.hfU.a(String.valueOf(cbW().hpR.Iq().mLiveInfo.group_id), String.valueOf(cbW().hpR.Iq().mLiveInfo.last_msg_id), String.valueOf(cbW().hpR.Iq().aJV.userId), String.valueOf(cbW().hpR.Iq().mLiveInfo.live_id), cbW().hpR.Iq().aJV.appId, z, cbW().hpR.Iq().getGuardName());
            ng(false);
        }
    }

    private void caC() {
        cbq();
    }

    private void caD() {
        if (this.heY == null) {
            this.heY = new FrameLayout(cbW().pageContext.getPageActivity());
            this.heY.setId(a.f.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void caE() {
        if (this.heK == null) {
            this.heK = new com.baidu.tieba.ala.liveroom.o.a(cbW().pageContext, false, this);
        }
        this.heK.e(this.hgE, cbW().hpR.Iq());
        this.heK.a(this.hfm);
        this.heK.a(this.hfu);
    }

    private void caF() {
        if (this.heJ == null) {
            this.heJ = new com.baidu.tieba.ala.liveroom.audiencelist.c(cbW().pageContext, this, false);
        }
        this.heJ.a(String.valueOf(cbW().hpR.Iq().mLiveInfo.group_id), String.valueOf(cbW().hpR.Iq().mLiveInfo.live_id), String.valueOf(cbW().hpR.Iq().aJV.userId), cbW().hpR.Iq());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.f.ala_liveroom_hostheader;
            if (this.hfF != null && this.hfF.getView() != null && this.hfF.getView().getParent() != null) {
                i = a.f.ala_liveroom_guardthrone;
            }
            this.heJ.c(this.hgE, i, a.f.ala_liveroom_audience_count_layout);
            this.heJ.e(cbW().hpR.bUt());
        }
    }

    private void caG() {
        com.baidu.live.core.a.a Pc;
        if (this.hfE == null) {
            this.hfE = new com.baidu.tieba.ala.liveroom.operation.a(cbW().pageContext);
        }
        this.hfE.a(cbW(), this.hgF, cbW().hpR.Iq().mLiveInfo, true, this.hfu);
        this.hfE.setOtherParams(Oj());
        if (this.hgf != null && (Pc = this.hgf.Pc()) != null) {
            View rootLayout = Pc.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.hfE.cp(rootLayout);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void caH() {
        caI();
    }

    private void caI() {
        if (this.hfE != null) {
            int i = cbW().hpR.Iq().aKr.isUegBlock;
            int i2 = cbW().hpR.Iq().aKr.isBlock;
            String str = cbW().hpR.Iq().aKr.userName;
            if (i > 0 || i2 > 0) {
                this.hfE.b(true, i, i2, str);
                this.hfU.a(true, i, i2, str);
                this.hga.b(true, i, i2, str);
                return;
            }
            this.hfE.b(false, i, i2, str);
            this.hfU.a(false, i, i2, str);
            this.hga.b(false, i, i2, str);
        }
    }

    private void caJ() {
        if (this.heN == null) {
            this.heN = new com.baidu.tieba.ala.liveroom.audiencelist.b(cbW().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (cbW().hpR.bUt() != null) {
            j = cbW().hpR.bUt().getCount();
        }
        this.heN.a(this.hfu);
        this.heN.a(this.hgE, a.f.ala_liveroom_hostheader, j);
        this.heN.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.heN.ns(false);
        } else {
            this.heN.ns(true);
        }
    }

    public void caK() {
        this.hfH.c(cbW().hpR.Iq(), false);
    }

    public void caL() {
        if (cbW().hpR.Iq() != null && cbW().hpR.Iq().aJV != null && cbW().hpR.Iq().mLiveInfo != null) {
            if (this.heM == null) {
                this.heM = new com.baidu.tieba.ala.liveroom.u.b(cbW().pageContext);
            }
            long j = cbW().hpR.Iq().aJV.userId;
            int i = cbW().hpR.Iq().mLiveInfo.live_type;
            String str = cbW().hpR.Iq().aJV.portrait;
            String str2 = cbW().hpR.Iq().mLiveInfo.feed_id;
            long j2 = cbW().hpR.Iq().mLiveInfo.live_id;
            this.heM.a(i, j, cbW().hpR.Iq().aJV.userName, false, str, Oj(), str2, j2);
            this.heM.at(this.hgE);
        }
    }

    private void caM() {
        boolean z = false;
        if (this.hfP == null) {
            this.hfP = new com.baidu.tieba.ala.liveroom.w.a(cbW().pageContext, this);
        }
        this.hfP.c(cbW().hpS, false);
        boolean cbV = cbV();
        AlaLiveInfoData alaLiveInfoData = cbW().hpR.Iq().mLiveInfo;
        boolean isZanAnimUnabled = (alaLiveInfoData == null || alaLiveInfoData.mAlaLiveSwitchData == null) ? false : alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled();
        if (cbV && !isZanAnimUnabled) {
            z = true;
        }
        this.hfP.om(z);
    }

    private void caN() {
        if (cbW() != null && cbW().brf != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(cbW().pageContext.getPageActivity());
            Activity pageActivity = cbW().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + o.bm(pageActivity)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.heZ = new ImageView(cbW().pageContext.getPageActivity());
            this.heZ.setVisibility(8);
            this.heZ.setBackgroundResource(a.e.sdk_round_btn_close_bg);
            this.heZ.setImageResource(a.e.icon_live_enlarge);
            this.heZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hfa != null) {
                        a.this.hfa.Vi();
                        a.this.heZ.setVisibility(4);
                        a.this.hfU.Nf().cp(false);
                    }
                }
            });
            cbW().hpS.addView(this.heZ, layoutParams);
            if (UtilHelper.getRealScreenOrientation(cbW().pageContext.getPageActivity()) != 2) {
                if (cbW().hpY) {
                    this.heZ.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.17
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.heZ != null && UtilHelper.getRealScreenOrientation(a.this.cbW().pageContext.getPageActivity()) != 2) {
                                a.this.heZ.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
        }
    }

    private void caO() {
        if (this.hgD == null) {
            this.hgD = new com.baidu.tieba.ala.liveroom.apppromotion.a(cbW().pageContext);
        }
        this.hgD.b(caU(), cbW().hpR.Iq());
    }

    private void caP() {
        if (this.hgM || this.hgN) {
            if ((TbadkCoreApplication.isLogin() && this.hfU.Ne().hasText()) || this.hgN) {
                this.hgM = false;
                this.hgN = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.18
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cbp();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void t(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        super.t(bVar);
        if (this.heP != null) {
            this.heP.G(bVar);
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
        if (this.heW == null || !this.heW.N(jSONObject)) {
            if ((bVar.getMsgType() == 12 || bVar.getMsgType() == 13) && jSONObject != null) {
                String optString = jSONObject.optString("content_type");
                if ("task".equals(optString)) {
                    if (this.heO != null) {
                        this.heO.J(jSONObject);
                    }
                } else if ("enter_live".equals(optString)) {
                    if (this.heN != null && this.heN.getCount() > 20) {
                        this.heN.eZ(this.heN.getCount() + 1);
                    } else if (this.heJ != null) {
                        com.baidu.live.data.a NU = bVar.NU();
                        p pVar = new p();
                        pVar.aJW = new AlaLocationData();
                        pVar.aJX = new AlaRelationData();
                        pVar.aJV = new AlaLiveUserInfoData();
                        pVar.aJV.userId = JavaTypesHelper.toLong(NU.userId, 0L);
                        pVar.aJV.userName = NU.userName;
                        pVar.aJV.portrait = NU.portrait;
                        if (this.heN != null && this.heJ.c(pVar)) {
                            this.heN.eZ(this.heN.getCount() + 1);
                        }
                    }
                } else if ("update_liveinfo".equals(optString)) {
                    if (cbW().hpR.Iq() != null && cbW().hpR.Iq().mLiveInfo != null) {
                        cbW().hpR.a(cbW().hpR.Iq().mLiveInfo.live_id, cbW().fromType, cbW().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && cbW().hpR.Iq() != null && cbW().hpR.Iq().mLiveInfo != null && cbW().hpR.Iq().aKr != null && this.heS != null) {
                    long optLong = jSONObject.optLong("mvp_user_id");
                    long optLong2 = jSONObject.optLong("winner_live_id");
                    if (optLong == cbW().hpR.Iq().aKr.userId && optLong2 == cbW().hpR.Iq().mLiveInfo.live_id) {
                        this.heS.c(jSONObject.optInt("challenge_status"), jSONObject.optLong("challenge_id"));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void Ic(String str) {
        if (this.heP != null) {
            this.heP.Ic(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void j(w wVar) {
        super.j(wVar);
        if (this.heK != null) {
            this.heK.M(wVar);
        }
        if (this.heL != null) {
            this.heL.I(wVar);
        }
        if (this.heO != null) {
            this.heO.L(wVar);
        }
        if (this.heS != null) {
            this.heS.a(wVar);
        }
        if (this.heU != null) {
            this.heU.a(wVar);
        }
        if (this.heP != null) {
            this.heP.i(wVar);
            if (wVar != null && this.hgw != null && !this.hgw.hasInit && !TextUtils.isEmpty(this.hgw.aRg)) {
                this.hgw.hasInit = true;
                this.heP.Id(this.hgw.aRg);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(q qVar) {
        if (qVar != null) {
            if (this.heJ != null && qVar.getList() != null) {
                this.heJ.e(qVar);
            }
            if (this.heN != null) {
                this.heN.eZ(qVar.getCount());
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void cz(boolean z) {
        super.cz(z);
        if (cbW().hpS != null) {
            cbW().hpS.clk();
            cbW().hpS.setLiveViewOnDispatchTouchEventListener(null);
            cbW().hpS.setLiveViewOnTouchEventListener(null);
            cbW().hpS.setOnLiveViewScrollListener(null);
        }
        if (cbW().brf != null) {
            cbW().brf.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
        }
        if (this.heS != null) {
            this.heS.En();
        }
        caQ();
        if (this.heM != null) {
            this.heM.En();
        }
        if (this.hfP != null) {
            this.hfP.release();
        }
        if (this.heO != null) {
            this.heO.En();
        }
        if (this.heW != null) {
            this.heW.Do();
        }
        if (this.hfE != null) {
            this.hfE.cjR();
        }
        if (this.heL != null) {
            this.heL.cer();
            this.heL.setVisible(8);
        }
        if (this.heQ != null) {
            this.heQ.En();
        }
        if (this.heP != null) {
            this.heP.release();
        }
        if (this.buZ != null) {
            this.buZ.removeAllViews();
            this.buZ = null;
        }
        if (this.heR != null) {
            this.heR.En();
        }
        if (this.heU != null) {
            this.heU.a((a.InterfaceC0193a) null);
            this.heU.DN();
        }
        if (this.heK != null) {
            this.heK.cgs();
        }
        if (this.heZ != null && (this.heZ.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.heZ.getParent()).removeView(this.heZ);
        }
        if (this.heV != null) {
            this.heV.dismiss();
        }
        if (this.hfa != null) {
            this.hfa.da(false);
            this.hfa.Vj();
        }
        if (this.hfg != null) {
            this.hfg.En();
        }
        if (this.hgU != null) {
            this.hgU.cdl();
        }
        if (this.hgy != null) {
            this.hgy.En();
        }
        if (this.hgD != null) {
            this.hgD.Do();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void m(w wVar) {
        View DL;
        super.m(wVar);
        if (this.heU != null && (DL = this.heU.DL()) != null && DL.getParent() != null) {
            ((ViewGroup) DL.getParent()).removeView(DL);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.heU != null) {
            this.heU.setOtherParams(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cx(boolean z) {
        super.cx(z);
        this.hfe.removeCallbacksAndMessages(null);
        caQ();
        this.hfc = false;
        this.hfd = false;
        if (this.heK != null) {
            this.heK.onDestroy();
        }
        if (this.heM != null) {
            this.heM.onDestroy();
        }
        if (this.heO != null) {
            this.heO.onDestroy();
        }
        if (this.heQ != null) {
            this.heQ.onDestroy();
        }
        if (this.heR != null) {
            this.heR.onDestroy();
        }
        if (this.heS != null) {
            this.heS.onDestroy();
        }
        if (this.heT != null) {
            this.heT.onDestroy();
        }
        if (this.heV != null) {
            this.heV.onDestroy();
        }
        if (this.heL != null) {
            this.heL.onDestroy();
        }
        if (this.hfa != null) {
            this.hfa.stop();
        }
        if (this.hfP != null) {
            this.hfP.onDestroy();
        }
        if (this.heJ != null) {
            this.heJ.onDestroy();
        }
        if (this.hfU != null) {
            this.hfU.onDestroy();
        }
        if (this.hfE != null) {
            this.hfE.onDestory();
        }
        if (this.heU != null) {
            this.heU.a((a.InterfaceC0193a) null);
            this.heU.release();
            this.heU = null;
        }
        if (this.hgU != null) {
            this.hgU.cx(z ? false : true);
        }
        if (this.hfg != null) {
            this.hfg.onDestroy();
            this.hfg = null;
        }
        if (this.hgy != null) {
            this.hgy.onDestroy();
        }
        if (this.heW != null) {
            this.heW.onDestroy();
        }
        if (this.hgD != null) {
            this.hgD.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.hfi);
        MessageManager.getInstance().removeMessageRule(this.hfh);
        MessageManager.getInstance().removeMessageRule(this.hfj);
        MessageManager.getInstance().removeMessageRule(this.hfk);
        MessageManager.getInstance().unRegisterListener(this.hfn);
        MessageManager.getInstance().unRegisterListener(this.hfr);
        MessageManager.getInstance().unRegisterListener(this.hfs);
        MessageManager.getInstance().unRegisterListener(this.hft);
        MessageManager.getInstance().unRegisterListener(this.hfq);
        MessageManager.getInstance().unRegisterListener(this.hfp);
        MessageManager.getInstance().unRegisterListener(this.hfo);
    }

    private void caQ() {
        if (this.hfU != null && this.hfU.Nd().getView() != null && this.hfU.Nd().getView().getParent() != null) {
            ((ViewGroup) this.hfU.Nd().getView().getParent()).removeView(this.hfU.Nd().getView());
        }
        if (this.heX != null && this.heX.getParent() != null) {
            ((ViewGroup) this.heX.getParent()).removeView(this.heX);
        }
        if (this.heY != null && this.heY.getParent() != null) {
            ((ViewGroup) this.heY.getParent()).removeView(this.heY);
        }
        if (this.hfU != null && this.hfU.Ne().getView() != null) {
            this.hgF.removeView(this.hfU.Ne().getView());
        }
        if (this.hfU != null) {
            this.hfU.Nd().setMsgData(new LinkedList());
            this.hfU.DN();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void a(ar arVar) {
        if (this.hfU != null) {
            cbp();
            this.hfU.Ne().setEditText(" @" + arVar.getNameShow() + " ");
        }
        if (this.hfE != null) {
            this.hfE.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void g(com.baidu.live.data.a aVar) {
        if (this.hfU != null) {
            cbp();
            this.hfU.Ne().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.hfE != null) {
            this.hfE.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void If(String str) {
        if (this.hfU != null) {
            cbp();
            StringBuilder sb = new StringBuilder();
            sb.append(" @");
            sb.append(str);
            sb.append(" ");
            if (com.baidu.live.ae.a.RB().brA.aOc != null && com.baidu.live.ae.a.RB().brA.aOc.originTexts != null && com.baidu.live.ae.a.RB().brA.aOc.originTexts.size() > 0) {
                this.hfU.Ne().OS();
                this.hfU.Ne().setEditText(sb.toString() + com.baidu.live.ae.a.RB().brA.aOc.originTexts.get(0));
            } else {
                this.hfU.Ne().setEditText(sb.toString());
            }
        }
        if (this.hfE != null) {
            this.hfE.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void b(ar arVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected View caR() {
        if (this.hfU != null) {
            return this.hfU.Ne().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean caS() {
        if (this.hfU == null || !this.hfU.Ne().OQ()) {
            return false;
        }
        ng(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected boolean caT() {
        return this.heK == null || this.heK.caT();
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected ViewGroup caU() {
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
                    this.hgJ = false;
                    N(intExtra, intExtra2, intExtra3);
                    return;
                }
                caK();
                return;
            }
            ays();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.hgI;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(cbW().pageContext.getPageActivity()) || z2) {
            nf(z);
        }
    }

    private void nf(boolean z) {
        if (this.hfU != null && this.hfU.Nd() != null) {
            this.hfU.Nd().onKeyboardVisibilityChanged(z);
        }
        if (z || this.hfU == null || !this.hfU.Ne().OQ()) {
            if (z) {
                if (this.hfE != null) {
                    this.hfE.setVisibility(8);
                }
                if (this.hfW != null && this.hfW.HN() != null) {
                    this.hfW.HN().setVisibility(8);
                }
                caW();
                if (this.hfU != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hfU.Ne().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.hfU.Ne().getView().setLayoutParams(layoutParams);
                    this.hfU.Ne().getView().setVisibility(0);
                    this.hfU.Ne().setQuickInputPanelVisible(false);
                    this.hfU.Nf().cp(false);
                }
                if (this.hgE != null) {
                    this.hgE.setVisibility(8);
                }
                if (this.heP != null) {
                    this.heP.setVisible(8);
                }
                if (this.hfV != null) {
                    this.hfV.DM();
                }
                if (this.hgx != null) {
                    this.hgx.setCanVisible(false);
                }
                if (this.hgo != null) {
                    this.hgo.setCanVisible(false);
                }
                if (this.hgs != null) {
                    this.hgs.setCanVisible(false);
                }
                if (this.hgt != null) {
                    this.hgt.setVisible(8);
                }
                if (this.hgr != null) {
                    this.hgr.setCanVisible(false);
                }
                if (this.hgD != null) {
                    this.hgD.setCanVisible(false);
                }
            } else {
                caV();
            }
            if (this.hfU != null && this.heX != null) {
                if (this.hgF.indexOfChild(this.heX) != -1 && this.heX.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.heX.getLayoutParams();
                    layoutParams2.height = com.baidu.live.ak.c.i(true, z);
                    this.heX.setLayoutParams(layoutParams2);
                }
                if (this.heX.indexOfChild(this.hfU.Nd().getView()) != -1 && this.hfU.Nd().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.hfU.Nd().getView().getLayoutParams();
                    layoutParams3.height = com.baidu.live.ak.c.i(true, z);
                    this.hfU.Nd().getView().setLayoutParams(layoutParams3);
                }
                this.hfU.Nd().Nc();
            }
        }
    }

    private void caV() {
        if (this.hfE != null) {
            this.hfE.setVisibility(0);
        }
        if (this.heX != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.heX.getLayoutParams();
            layoutParams.bottomMargin = cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            this.heX.setLayoutParams(layoutParams);
        }
        if (this.hfU != null) {
            cbr();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hfU.Ne().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.hfU.Ne().getView().setLayoutParams(layoutParams2);
            if (UtilHelper.getRealScreenOrientation(cbW().pageContext.getPageActivity()) != 2 && !this.hfU.Nf().isClicked()) {
                this.hfU.Nf().cp(true);
            }
        }
        if (this.hfE != null) {
            this.hfE.setVisibility(0);
        }
        if (this.hfW != null && this.hfW.HN() != null) {
            this.hfW.HN().setVisibility(0);
        }
        if (this.hgE != null && (!this.hfc || UtilHelper.getRealScreenOrientation(cbW().pageContext.getPageActivity()) != 2)) {
            this.hgE.setVisibility(0);
        }
        if (this.heP != null) {
            this.heP.setVisible(0);
        }
        if (this.hfV != null) {
            this.hfV.DM();
        }
        if (this.hgx != null) {
            this.hgx.setCanVisible(true);
        }
        if (this.hgo != null) {
            this.hgo.setCanVisible(true);
        }
        if (this.hgs != null) {
            this.hgs.setCanVisible(true);
        }
        if (this.hgt != null) {
            this.hgt.setVisible(0);
        }
        if (this.hgr != null) {
            this.hgr.setCanVisible(true);
        }
        if (this.hgD != null) {
            this.hgD.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caW() {
        boolean z;
        boolean z2 = false;
        if (this.heX != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.heX.getLayoutParams();
            if (this.hfU == null || this.hfU.Ne() == null) {
                z = false;
            } else {
                z = this.hfU.Ne().OO();
                z2 = this.hfU.Ne().OP();
            }
            int M = M(z, z2);
            if (layoutParams.bottomMargin != M) {
                layoutParams.bottomMargin = M;
                this.heX.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ng(boolean z) {
        if (z) {
            this.hfU.Ne().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.heX.getLayoutParams();
            int quickInputPanelExpandHeight = this.hfU.Ne().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.heX.setLayoutParams(layoutParams);
                if (this.hfU.Nd() != null) {
                    this.hfU.Nd().Nc();
                    return;
                }
                return;
            }
            return;
        }
        caV();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        FrameLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = cbW().pageContext.getPageActivity();
        if (i3 == 1) {
            if (cbW().pageContext.getPageActivity() != null && !UtilHelper.canUseStyleImmersiveSticky()) {
                com.baidu.live.utils.q.e(cbW().pageContext.getPageActivity(), true);
            }
            if (this.hgE != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.hgE.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.heV != null) {
                this.heV.dismiss();
            }
            if (this.heU != null) {
                this.heU.a((a.InterfaceC0193a) null);
                this.heU.DN();
            }
            if (this.brc != null) {
                this.brc.e(true, true);
            }
            if (this.heZ != null) {
                this.heZ.setVisibility(0);
                this.heZ.bringToFront();
            }
            if (this.hfK != null) {
                this.hfK.setVisibility(0);
            }
            if (this.hfU != null && this.hfU.Nd().getView().getParent() != null && (this.hfU.Nd().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hfU.Nd().getView().getParent()).removeView(this.hfU.Nd().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(cbW().pageContext.getPageActivity()) * 0.7f);
            int i4 = com.baidu.live.ak.c.i(true, false);
            if (this.heX != null && this.hfU != null) {
                this.heX.addView(this.hfU.Nd().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, i4));
            }
            if (this.heY != null && (this.heY.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.heY.getParent()).removeView(this.heY);
            }
            if (this.hfV != null) {
                this.hfV.a(cbW().hpR.Iq(), false);
                this.hfV.a(new a.InterfaceC0193a() { // from class: com.baidu.tieba.ala.liveroom.d.a.19
                    @Override // com.baidu.live.im.b.a.InterfaceC0193a
                    public void NJ() {
                        a.this.cbH();
                    }
                });
                View DL = this.hfV.DL();
                if (DL != null && this.hgF != null && DL.getParent() == null) {
                    Resources resources = cbW().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(cbW().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                    layoutParams5.addRule(2, a.f.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                    this.hgF.addView(DL, layoutParams5);
                }
            }
            if (this.hfM != null) {
                this.hfM.setPraiseEnable(true);
                cbW().hpS.hFs = true;
            }
            if (this.heJ != null && this.heJ.hih != null && (layoutParams3 = (FrameLayout.LayoutParams) this.heJ.hih.getLayoutParams()) != null) {
                layoutParams3.width = -2;
                this.heJ.hih.setLayoutParams(layoutParams3);
            }
            if (this.hfP != null) {
                this.hfP.clK();
            }
            if (this.hfc) {
                ne(true);
            }
            if (this.hfd) {
                if (this.hfE != null && this.hfE.getLandscapeBarrageImageView() != null) {
                    b(this.hfE.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.hfE != null) {
                this.hfE.xk(0);
            }
            if (this.heN != null) {
                this.heN.nr(true);
            }
            this.hfe.removeCallbacksAndMessages(null);
            if (this.heO != null) {
                this.heO.setCanVisible(true);
                this.heO.L(cbW().hpR.Iq());
            }
            if (this.heW != null) {
                this.heW.cL(true);
            }
            if (this.hfU != null && !this.hfU.Nf().isClicked()) {
                this.hfU.Nf().cp(true);
            }
        } else if (i3 == 2) {
            if (cbW().pageContext.getPageActivity() != null && !UtilHelper.canUseStyleImmersiveSticky()) {
                com.baidu.live.utils.q.e(cbW().pageContext.getPageActivity(), false);
            }
            if (this.hfP != null) {
                this.hfP.clL();
            }
            if (this.hgE != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.hgE.getLayoutParams()) != null) {
                layoutParams2.topMargin = cbW().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
            }
            if (this.hfV != null) {
                this.hfV.a((a.InterfaceC0193a) null);
                this.hfV.DN();
            }
            cbW().hpS.clm();
            if (this.brc != null) {
                this.brc.e(false, true);
            }
            if (this.heZ != null) {
                this.heZ.setVisibility(4);
            }
            if (this.hfU != null && this.hfU.Nd().getView().getParent() != null && (this.hfU.Nd().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hfU.Nd().getView().getParent()).removeView(this.hfU.Nd().getView());
                this.hfU.Nf().cp(false);
            }
            int max = Math.max(i, i2);
            if (this.heY != null) {
                if (this.heY.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.heY.getParent()).removeView(this.heY);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100);
                cbW().hpS.addView(this.heY, this.buZ != null ? cbW().hpS.indexOfChild(this.buZ) : -1, layoutParams6);
            }
            if (this.heY != null && this.heU != null) {
                this.heU.a(cbW().hpR.Iq(), false);
                this.heU.a(new a.InterfaceC0193a() { // from class: com.baidu.tieba.ala.liveroom.d.a.20
                    @Override // com.baidu.live.im.b.a.InterfaceC0193a
                    public void NJ() {
                        a.this.cbH();
                    }
                });
                View DL2 = this.heU.DL();
                if (DL2 != null && this.heY.indexOfChild(DL2) < 0) {
                    this.heY.addView(DL2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(cbW().pageContext.getPageActivity()), -1));
                }
            }
            if (this.hfM != null) {
                this.hfM.aA(cbW().hpS);
                this.hfM.setPraiseEnable(false);
                cbW().hpS.hFs = false;
            }
            if (this.heJ != null && this.heJ.hih != null && (layoutParams = (FrameLayout.LayoutParams) this.heJ.hih.getLayoutParams()) != null) {
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                layoutParams.width = (int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f);
                this.heJ.hih.setLayoutParams(layoutParams);
            }
            if (this.hfE != null) {
                this.hfE.xk(8);
            }
            if (this.heN != null) {
                this.heN.nr(false);
            }
            if (al.IE() != null) {
                al.IE().ID();
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.ah.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.ah.c) runTask.getData()).ID();
            }
            if (this.hfE != null && this.hfE.getLandscapeBarrageImageView() != null) {
                b(this.hfE.getLandscapeBarrageImageView(), this.hfd, false);
            }
            cak();
            if (this.hfW != null) {
                this.hfW.HP();
            }
            if (this.heO != null) {
                this.heO.setCanVisible(false);
                this.heO.cfu();
            }
            if (this.heW != null) {
                this.heW.setCanVisible(false);
            }
        }
        if (this.hgs != null) {
            this.hgs.en(i3);
        }
        if (this.hgd != null) {
            this.hgd.en(i3);
        }
        if (this.hfX != null) {
            this.hfX.en(i3);
        }
        if (this.hfU != null) {
            this.hfU.Nf().en(i3);
        }
        if (this.hfE != null) {
            this.hfE.l(i, i2, i3);
        }
        K(i3, true);
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.heJ != null) {
                this.heJ.dX(i3);
            }
            if (this.heL != null) {
                this.heL.dX(i3);
            }
            if (this.heP != null) {
                this.heP.dX(i3);
            }
            if (this.hgf != null) {
                this.hgf.dX(i3);
            }
            if (this.hga != null) {
                this.hga.dX(i3);
            }
            if (this.hgj != null) {
                this.hgj.dX(i3);
            }
            if (this.hgl != null) {
                this.hgl.dX(i3);
            }
            if (this.gTR != null) {
                this.gTR.dX(i3);
            }
            if (this.hff != null && this.hff.isShowing()) {
                this.hff.resize();
            }
            if (this.hgx != null) {
                this.hgx.dX(i3);
            }
            if (this.hgy != null) {
                this.hgy.dX(i3);
            }
            if (this.hgv != null) {
                this.hgv.en(i3);
            }
            if (this.hgB != null) {
                this.hgB.dX(i3);
            }
        }
        if (this.hfW != null) {
            this.hfW.HO();
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public boolean fh(int i) {
        boolean fh = super.fh(i);
        if (fh && 2 == i) {
            if (this.heK.caT()) {
                return false;
            }
            if (fh && this.hfP != null) {
                this.hfP.on(false);
            }
        }
        return fh;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void wy(int i) {
        super.wy(i);
        if (i == 7 || i == 11) {
            if (i != 7 || UtilHelper.getRealScreenOrientation(cbW().pageContext.getPageActivity()) != 2) {
                if (this.hfE != null) {
                    this.hfE.setVisibility(8);
                }
                if (this.hfU != null) {
                    this.hfU.Nd().getView().setVisibility(4);
                    this.hfU.Nf().cp(false);
                }
                if (this.hgk != null) {
                    this.hgk.oh(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public void fi(int i) {
        super.fi(i);
        if (i == 7 || i == 11) {
            if (this.hfE != null) {
                this.hfE.setVisibility(0);
            }
            if (this.hfU != null) {
                this.hfU.Nd().getView().setVisibility(0);
                if (UtilHelper.getRealScreenOrientation(cbW().pageContext.getPageActivity()) != 2 && !this.hfU.Nf().isClicked()) {
                    this.hfU.Nf().cp(true);
                }
            }
            if (this.hgk != null) {
                this.hgk.oh(true);
            }
            if (!this.hfc || UtilHelper.getRealScreenOrientation(cbW().pageContext.getPageActivity()) != 2) {
                this.hgE.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.heM != null) {
            this.heM.ckp();
        }
        if (this.heR != null) {
            this.heR.Ew();
        }
        if (this.heP != null) {
            this.heP.onStop();
        }
        if (this.hgB != null) {
            this.hgB.onStop();
        }
        if (cbW() != null) {
            BdUtilHelper.hideSoftKeyPad(cbW().pageContext.getPageActivity(), cbW().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.heM != null) {
            this.heM.cko();
        }
        if (this.heR != null) {
            this.heR.Ex();
        }
        if (this.heP != null) {
            this.heP.onStart();
        }
        if (this.hgv != null) {
            this.hgv.onStart();
        }
        if (this.hgB != null) {
            this.hgB.onStart();
        }
        if (this.hgD != null) {
            this.hgD.onStart();
        }
    }

    private void K(int i, boolean z) {
        if (this.buZ != null) {
            int dimensionPixelSize = cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.buZ.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                layoutParams.rightMargin = cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6);
                layoutParams.height = cat();
                this.buZ.setPosition(dimensionPixelSize, 0, dimensionPixelSize, 0);
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                int dimensionPixelSize2 = cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds72) + 0 + cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100) + cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
                layoutParams.height = -1;
                this.buZ.setPosition(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
            }
            layoutParams.bottomMargin = cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            this.buZ.setLayoutParams(layoutParams);
            this.buZ.setModel(i == 1 ? PendantParentView.Model.HORIZONTAL : PendantParentView.Model.HORIZONTAL_FULL);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.e
    public void wz(int i) {
        K(this.mOrientation, false);
    }
}
