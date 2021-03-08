package com.baidu.tieba.ala.liveroom.c;

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
import com.baidu.live.data.ab;
import com.baidu.live.data.ao;
import com.baidu.live.data.ax;
import com.baidu.live.data.bv;
import com.baidu.live.data.co;
import com.baidu.live.data.u;
import com.baidu.live.data.v;
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
import com.baidu.live.utils.p;
import com.baidu.live.utils.r;
import com.baidu.tieba.ala.liveroom.exclusive.e;
import com.baidu.tieba.ala.liveroom.i.b;
import com.baidu.tieba.ala.liveroom.i.g;
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends b implements com.baidu.live.m.c, e {
    private PendantParentView bAa;
    private com.baidu.tieba.ala.liveroom.audiencelist.c hsc;
    private com.baidu.tieba.ala.liveroom.m.a hsd;
    private com.baidu.tieba.ala.liveroom.f.b hse;
    private com.baidu.tieba.ala.liveroom.t.b hsf;
    private com.baidu.tieba.ala.liveroom.audiencelist.b hsg;
    private com.baidu.tieba.ala.liveroom.k.a hsh;
    private com.baidu.tieba.ala.liveroom.activeview.b hsi;
    private com.baidu.live.e.a hsj;
    private i hsk;
    private h hsl;
    private com.baidu.tieba.ala.liveroom.b.a hsm;
    private com.baidu.live.im.b.a hsn;
    private com.baidu.tieba.ala.liveroom.share.b hso;
    private com.baidu.live.ad.a hsp;
    private FrameLayout hsq;
    private FrameLayout hsr;
    private ImageView hss;
    private com.baidu.live.tieba.e.b hst;
    private ah hsy;
    private com.baidu.tieba.ala.liveroom.i.b hsz;
    private long lastClickTime = 0;
    private boolean hsu = false;
    private boolean hsv = false;
    private boolean hsw = false;
    private Handler hsx = new Handler();
    private HttpRule hsA = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.hsk != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.hsk.AJ()) {
                httpMessage.addParam("ala_challenge_id", a.this.hsk.AM());
            }
            return httpMessage;
        }
    };
    private HttpRule hsB = new HttpRule(1021229) { // from class: com.baidu.tieba.ala.liveroom.c.a.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.hsk != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.hsk.AJ()) {
                httpMessage.addParam("challenge_id", a.this.hsk.AM());
            }
            return httpMessage;
        }
    };
    private HttpRule hsC = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.c.a.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.hsk != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.hsk.AJ()) {
                httpMessage.addParam("challenge_id", a.this.hsk.AM());
            }
            return httpMessage;
        }
    };
    private HttpRule hsD = new HttpRule(1021232) { // from class: com.baidu.tieba.ala.liveroom.c.a.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.hsk != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.hsk.AJ()) {
                httpMessage.addParam("challenge_id", a.this.hsk.AM());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c hsE = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.c.a.23
        @Override // com.baidu.live.liveroom.g.c
        public void Ng() {
            if (a.this.htj != null) {
                a.this.htj.oS(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cI(boolean z) {
            if (z) {
                if (a.this.htj != null) {
                    a.this.htj.oS(true);
                }
            } else if (a.this.htj != null) {
                a.this.htj.oS(false);
            }
            if (a.this.htC != null) {
                a.this.htC.bD(z);
            }
            if (a.this.hsi != null) {
                a.this.hsi.nJ(z ? false : true);
            }
            com.baidu.live.p.a.cJ(z);
        }
    };
    private com.baidu.tieba.ala.liveroom.m.c hsF = new com.baidu.tieba.ala.liveroom.m.c() { // from class: com.baidu.tieba.ala.liveroom.c.a.24
        @Override // com.baidu.tieba.ala.liveroom.m.c
        public void onClick() {
            a.this.hsx.removeCallbacksAndMessages(null);
            a.this.hsu = true;
        }

        @Override // com.baidu.tieba.ala.liveroom.m.c
        public void endAnimation() {
            if (a.this.hsu) {
                a.this.caj();
            }
        }
    };
    private CustomMessageListener hsG = new CustomMessageListener(2913287) { // from class: com.baidu.tieba.ala.liveroom.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hst != null) {
                a.this.hst.dh(false);
                a.this.hst.Ue();
            }
        }
    };
    private CustomMessageListener hsH = new CustomMessageListener(2913290) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hst != null) {
                a.this.hst.dh(true);
            }
        }
    };
    private HttpMessageListener hsI = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Oz() != null) {
                        com.baidu.live.ae.e.QC().bCD = getQuickGiftHttpResponseMessage.Oz();
                        a.this.caz();
                    }
                }
            }
        }
    };
    private CustomMessageListener hsJ = new CustomMessageListener(2913276) { // from class: com.baidu.tieba.ala.liveroom.c.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            JSONObject optJSONObject;
            JSONArray optJSONArray;
            if (a.this.mOrientation == 1 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject) && (optJSONObject = ((JSONObject) customResponsedMessage.getData()).optJSONObject("ext_data")) != null && (optJSONArray = optJSONObject.optJSONArray("surprise_prize_member")) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                View inflate = LayoutInflater.from(a.this.activity).inflate(a.g.ala_fudai_dialog_layout, (ViewGroup) null);
                final Dialog dialog = new Dialog(a.this.cbV().pageContext.getPageActivity(), a.i.FudaiDialogStyle);
                dialog.requestWindowFeature(1);
                dialog.setContentView(inflate);
                dialog.setCancelable(false);
                View findViewById = inflate.findViewById(a.f.ala_fudai_negative_btn);
                View findViewById2 = inflate.findViewById(a.f.ala_fudai_positive_btn);
                TextView textView = (TextView) inflate.findViewById(a.f.ala_fudai_tbean_num);
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.6.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialog.dismiss();
                        if (TbadkCoreApplication.isLogin()) {
                            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
                            httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
                            MessageManager.getInstance().sendMessage(httpMessage);
                            ao aoVar = new ao();
                            aoVar.aLx = -1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar));
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
    private CustomMessageListener hsK = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.c.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                a.this.htr.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener hsL = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.c.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.hue != null && a.this.hue.bky != null && !a.this.hue.bkD && !a.this.hue.bkE && a.this.htB != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.cbV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                if (a.this.hto != null && a.this.hto.Ki().Mo()) {
                    layoutParams.bottomMargin = a.this.cbV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds88);
                } else {
                    layoutParams.bottomMargin = a.this.cbV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                }
                a.this.htB.c(a.this.hsq, layoutParams);
                if (com.baidu.live.guardclub.e.IV() != null) {
                    com.baidu.live.guardclub.e.IV().Ja();
                }
            }
        }
    };
    private CustomMessageListener hsM = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.a.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (a.this.bif != null) {
                    a.this.bif.dismiss();
                }
                com.baidu.live.im.b.d.KQ().setSwitchStatus(true);
                com.baidu.live.im.b.d.KQ().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cbm();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener hsN = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.c.a.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.hsz.c(a.this.cbV());
                } else if (a.this.cbh() || !g.vD(2913168)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.cbV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.cbV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    a.this.hsz.c(a.this.hsq, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b hsO = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.a.15
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void v(View view, int i) {
            bv bvVar;
            String str;
            bv bvVar2;
            co coVar;
            String str2;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - a.this.lastClickTime >= 300) {
                a.this.lastClickTime = currentTimeMillis;
                if (i == 2 && a.this.Ic()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel"));
                    a.this.P(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.ae.e.QC().bCD.EV().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.ae.e.QC().bCD.EV().DU());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.ae.e.QC().bCD.EV().DV());
                        if (a.this.cbV().hDq.Fp() != null && a.this.cbV().hDq.Fp().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.cbV().hDq.Fp().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.cbV().hDq.Fp().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.Lr());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.Ic()) {
                        if (com.baidu.live.d.xf().getBoolean("quick_gift_guide_show", true) && !a.this.cbh()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, ah.class, a.this.cbV().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                ah ahVar = (ah) runTask.getData();
                                ahVar.setPageContext(a.this.cbV().pageContext);
                                ahVar.setLiveShowData(a.this.cbV().hDq.Fp());
                                ahVar.setGiftItem(com.baidu.live.ae.e.QC().bCD.EV());
                                ahVar.setOtherParams(a.this.Lr());
                                ahVar.initView();
                                ahVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.15.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        a.this.nP(false);
                                        a.this.hsy = null;
                                    }
                                });
                                a.this.hsy = ahVar;
                                ahVar.show();
                                a.this.nP(true);
                                return;
                            }
                            return;
                        }
                        n.a(a.this.cbV().pageContext, a.this.cbV().hDq.Fp(), com.baidu.live.ae.e.QC().bCD.EV(), a.this.Lr());
                    }
                } else if (i == 1) {
                    if (a.this.hto != null) {
                        a.this.cbm();
                    }
                } else if (i == 3 && a.this.Ic()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    if (a.this.mOrientation == 2 && (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                        if (a.this.hso != null) {
                            a.this.hso.U(a.this.cbV().hDq.Fp());
                        }
                    } else {
                        a.this.htb.d(a.this.cbV().hDq.Fp(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.cbV() != null && a.this.cbV().hDq != null && a.this.cbV().hDq.Fp() != null && a.this.cbV().hDq.Fp().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.cbV().hDq.Fp().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.cbV().hDq.Fp().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.cbV().hDq.Fp().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.Lr());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.cbV() != null && a.this.cbV().hDq != null && a.this.cbV().hDq.Fp() != null && a.this.cbV().hDq.Fp().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.cbV().hDq.Fp().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.cbV().hDq.Fp().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.cbV().hDq.Fp().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.Lr());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.btl != null) {
                        a.this.btl.cC(false);
                    }
                } else if (i == 12) {
                    if (a.this.htj != null) {
                        String valueOf = String.valueOf(a.this.cbV().hDq.Fp().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.cbV().hDq.Fp().mLiveInfo.room_id);
                        String str3 = null;
                        AlaLiveSdkInfo alaLiveSdkInfo = a.this.cbV().hDq.Fp().mLiveSdkInfo;
                        if (alaLiveSdkInfo != null && alaLiveSdkInfo.mCastIds != null) {
                            str3 = String.valueOf(a.this.cbV().hDq.Fp().mLiveSdkInfo.mCastIds.chatMCastId);
                        }
                        a.this.htj.ax(valueOf, valueOf2, str3);
                        com.baidu.live.p.a.c(a.this.cbV().hDq.Fp().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    ab Fp = a.this.cbV().hDq.Fp();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.cbV().pageContext.getPageActivity(), Fp.aJD.userName, Long.toString(Fp.aJD.userId), Long.toString(Fp.aJD.charmCount), String.valueOf(Fp.mLiveInfo.group_id), String.valueOf(Fp.mLiveInfo.live_id), false, String.valueOf(Fp.aJD.userId), Long.toString(Fp.aJZ.userId), Fp.aJZ.userName, Fp.aJZ.portrait, a.this.hsg.getCount(), a.this.Lr())));
                    LogManager.getCommonLogger().doClickGusetNumLog(Fp.mLiveInfo.feed_id, a.this.hsg.getCount() + "", a.this.Lr());
                } else if (i == 11) {
                    a.this.cbr();
                    a.this.cbs();
                } else if (i == 16) {
                    if (a.this.cbV() != null && (bvVar2 = com.baidu.live.ae.a.Qm().bCs) != null && (coVar = bvVar2.aRm) != null) {
                        String str4 = coVar.aSU.aTd;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (a.this.cbV().hDq != null && a.this.cbV().hDq.Fp() != null && a.this.cbV().hDq.Fp().mLiveInfo != null) {
                                j = a.this.cbV().hDq.Fp().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", a.this.cbV().hDq.Fp().mLiveInfo.room_id + "", a.this.cbV().hDq.Fp().mLiveInfo.feed_id, a.this.Lr());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.cbV().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (a.this.cbV() != null) {
                        ab abVar = null;
                        if (a.this.cbV().hDq != null) {
                            abVar = a.this.cbV().hDq.Fp();
                        }
                        if (abVar != null && abVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.u.b.ckK().bwG != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.u.b.ckK().bwG.aIQ;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + abVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + abVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(a.this.cbV().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17) {
                    if (a.this.Ic() && a.this.cbV() != null && (bvVar = com.baidu.live.ae.a.Qm().bCs) != null && bvVar.aRm != null) {
                        String str6 = bvVar.aRm.aTa;
                        if (!TextUtils.isEmpty(str6)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                            if (a.this.cbV().hDq != null && a.this.cbV().hDq.Fp() != null) {
                                if (a.this.htD == null) {
                                    a.this.htD = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.cbV().pageContext.getPageActivity());
                                }
                                ab Fp2 = a.this.cbV().hDq.Fp();
                                String b = a.this.htD.b(str6, Fp2.mLiveInfo.live_id, Fp2.aJZ.userId, Fp2.aJD.userId);
                                com.baidu.live.an.c cVar = new com.baidu.live.an.c();
                                cVar.url = b;
                                a.this.bif.a(cVar, new com.baidu.live.an.b() { // from class: com.baidu.tieba.ala.liveroom.c.a.15.2
                                    @Override // com.baidu.live.an.b
                                    public void onShow() {
                                        a.this.hst.dh(false);
                                        a.this.hst.Ue();
                                    }

                                    @Override // com.baidu.live.an.b
                                    public void onDismiss() {
                                        a.this.hst.dh(true);
                                    }
                                });
                            }
                        }
                    }
                } else if (i == 18) {
                    if (a.this.hsw) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.hsw = !a.this.hsw;
                } else if (i == 19 && a.this.hst != null) {
                    a.this.hst.Ue();
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.htd = new com.baidu.tieba.ala.liveroom.guide.c(cbV().pageContext, this, false);
        this.hsB.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hsB);
        this.hsA.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hsA);
        this.hsC.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hsC);
        this.hsD.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hsD);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean isVertical() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caj() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.25
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.hsv) {
                    a.this.nK(false);
                }
            }
        }, 5000L);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void m(ab abVar) {
        super.m(abVar);
        g.cfy();
        this.hsw = false;
        if (this.htg != null) {
            this.htg.b(this.hsO);
        }
        if (this.hst == null) {
            this.hst = new com.baidu.live.tieba.e.b(cbV().pageContext.getPageActivity());
            this.hst.start();
        }
        this.hst.dh(true);
        cbV().pageContext.getPageActivity().setRequestedOrientation(-1);
        cbV().hDr.setIsForceHandledTouch(false);
        cbV().hDr.setSwipeClearEnable(true);
        cbV().hDr.setOnLiveViewScrollListener(this.hsE);
        cbV().hDr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hsx.removeCallbacksAndMessages(null);
                a.this.hsu = false;
                a.this.nK(false);
                if (!a.this.hsv) {
                    a.this.caj();
                }
            }
        });
        if (this.htX != null) {
            this.htX.setVisibility(0);
        }
        car();
        if (this.htz != null) {
            this.htz.a(abVar, this.bAa);
            this.htz.U(this.htY);
            this.htz.a(this);
        }
        cbC();
        caD();
        cbd();
        cbc();
        caE();
        cao();
        caI();
        caF();
        cak();
        nQ(false);
        caK();
        cbB();
        cbJ();
        cbv();
        cbA();
        caA();
        caB();
        cbu();
        caC();
        cbw();
        cam();
        caL();
        nS(true);
        cbD();
        cat();
        caz();
        cbN();
        cau();
        cav();
        caw();
        cax();
        cap();
        caN();
        caM();
        cal();
        cbM();
        cbI();
        caq();
        c(this.gto);
        MessageManager.getInstance().registerListener(this.hsI);
        MessageManager.getInstance().registerListener(this.hsL);
        MessageManager.getInstance().registerListener(this.hsM);
        MessageManager.getInstance().registerListener(this.hsN);
        MessageManager.getInstance().registerListener(this.hsK);
        MessageManager.getInstance().registerListener(this.hsJ);
        MessageManager.getInstance().registerListener(this.hsG);
        MessageManager.getInstance().registerListener(this.hsH);
        caO();
        caH();
        if (this.mOrientation == 2) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(cbV().pageContext.getPageActivity());
            l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(cbV().pageContext.getPageActivity()));
        }
        if (this.htO != null) {
            this.htO.L(abVar);
        }
        cby();
    }

    private void cak() {
        if (this.htO == null) {
            View view = null;
            if (this.htg != null && this.htg.getView() != null) {
                view = this.htg.getView();
            }
            this.htO = new com.baidu.tieba.ala.liveroom.exclusive.b(cbV().pageContext, Nc(), cbV().hDr, view, this.hsc.hvG, this);
        }
    }

    private void cal() {
        if (this.htN != null) {
            this.htN.a(new com.baidu.live.y.c() { // from class: com.baidu.tieba.ala.liveroom.c.a.27
                @Override // com.baidu.live.y.c
                public void cP(boolean z) {
                    if (a.this.hsl != null) {
                        a.this.hsl.setNeedCloseRecommendFloat(z);
                    }
                    if (a.this.cbV().hDr.hTf) {
                        if (a.this.htj != null) {
                            a.this.htj.oK(z);
                            a.this.htj.oS(!z);
                        }
                        if (a.this.htg != null) {
                            a.this.htg.oK(z);
                            a.this.htg.setPraiseEnable(!z);
                            a.this.htg.oJ(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nK(boolean z) {
        View Fo;
        if (cbV() != null && cbV().pageContext != null && cbV().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(cbV().pageContext.getPageActivity()) == 2 || z) {
                if (this.htr != null && (Fo = this.htr.Fo()) != null) {
                    if (this.hsv) {
                        Fo.setVisibility(0);
                    } else {
                        Fo.setVisibility(8);
                    }
                }
                if (this.hsv) {
                    if (this.htX != null) {
                        this.htX.setVisibility(0);
                    }
                    if (this.htY != null) {
                        this.htY.setVisibility(0);
                    }
                    if (this.bAa != null) {
                        this.bAa.setVisibility(0);
                    }
                    if (this.bAa != null) {
                        this.bAa.setVisibility(0);
                    }
                    if (this.htq != null) {
                        this.htq.bB(false);
                    }
                } else {
                    if (this.htX != null) {
                        this.htX.setVisibility(8);
                    }
                    if (this.htY != null) {
                        this.htY.setVisibility(8);
                    }
                    if (this.bAa != null) {
                        this.bAa.setVisibility(8);
                    }
                    if (this.bAa != null) {
                        this.bAa.setVisibility(8);
                    }
                    if (this.htq != null) {
                        this.htq.bB(true);
                    }
                }
                this.hsv = this.hsv ? false : true;
                if (this.hsi != null) {
                    this.hsi.nJ(this.hsv);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, boolean z2) {
        ImageView imageView;
        View EM;
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view;
        }
        if (z) {
            if (imageView != null) {
                imageView.setImageResource(a.e.icon_live_barrage_off);
            }
            if (this.hsr != null) {
                this.hsr.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.e.icon_live_barrage_on);
            }
            if (this.hsr != null) {
                this.hsr.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.htq != null && (EM = this.htq.EM()) != null) {
            if (z) {
                EM.setVisibility(8);
            } else {
                EM.setVisibility(0);
            }
        }
    }

    private void cam() {
        CustomResponsedMessage runTask;
        if (this.hsn == null && (runTask = MessageManager.getInstance().runTask(2913164, com.baidu.live.im.b.a.class, cbV().pageContext)) != null) {
            this.hsn = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hsn != null) {
            this.hsn.setOtherParams(this.otherParams);
            this.hsn.a(new a.InterfaceC0185a() { // from class: com.baidu.tieba.ala.liveroom.c.a.2
                @Override // com.baidu.live.im.b.a.InterfaceC0185a
                public void KP() {
                    a.this.cbG();
                }
            });
        }
    }

    private void can() {
        if (this.hti != null) {
            this.hti.aJ(cbV().hDp.getLiveContainerView());
        }
    }

    private void cao() {
        if (this.hso == null) {
            this.hso = new com.baidu.tieba.ala.liveroom.share.b(cbV().pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void cap() {
        if (cbV() != null) {
            if (this.hsp == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.ad.a.class, cbV().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hsp = (com.baidu.live.ad.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hsp.setIsHost(false);
            this.hsp.a(this.bAa, cbV().hDq.Fp().aKC);
        }
    }

    private void caq() {
        if (cbV() != null) {
            if (this.htJ == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913271, com.baidu.live.a.a.class, cbV().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.htJ = (com.baidu.live.a.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.htJ.setIsHorizontal(true);
            this.htJ.setIsHost(false);
            this.htJ.a(caT(), cbV().hDq.Fp());
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cw(int i) {
        super.cw(i);
        if (this.hss != null && UtilHelper.getRealScreenOrientation(cbV().pageContext.getPageActivity()) != 2) {
            this.hss.setVisibility(0);
        }
        can();
        if (this.hsl != null) {
            this.hsl.cw(i);
        }
        if (this.hsl == null || !this.hsl.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
        if (this.htO != null) {
            this.htO.ceW();
        }
    }

    private void car() {
        if (this.bAa == null) {
            PendantParentView.Model model = PendantParentView.Model.HORIZONTAL;
            if (this.mOrientation == 2) {
                model = PendantParentView.Model.HORIZONTAL_FULL;
            }
            this.bAa = new PendantParentView(cbV().pageContext.getPageActivity(), model);
            cbV().hDr.addView(this.bAa, ((cbV().hDr.getView() == null || this.htg == null || this.htg.getView() == null) ? -1 : cbV().hDr.getView().indexOfChild(this.htg.getView())) + 1, new RelativeLayout.LayoutParams(-1, cas()));
            this.bAa.setDefaultItemMargin(cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            K(this.mOrientation, false);
        }
    }

    private int cas() {
        int bottom;
        int bottom2;
        if (cbV().btp.getLivePlayer().getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) cbV().btp.getLivePlayer().getLayoutParams();
            bottom = layoutParams.topMargin + layoutParams.height;
        } else {
            bottom = cbV().btp.getLivePlayer().getBottom();
        }
        if (cbV().hDr.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) cbV().hDr.getLayoutParams();
            bottom2 = layoutParams2.topMargin + layoutParams2.height;
        } else {
            bottom2 = cbV().hDr.getBottom();
        }
        int i = 0;
        if (this.htO != null) {
            i = this.htO.getHeight();
        }
        return (((bottom2 - bottom) - i) - cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
    }

    private void cat() {
        if (this.hsi == null) {
            this.hsi = new com.baidu.tieba.ala.liveroom.activeview.b(cbV().pageContext);
        }
        if (cbV() != null && cbV().hDq != null) {
            this.hsi.HC(cbV().hDq.cjQ());
        }
        this.hsi.setOtherParams(Lr());
        this.hsi.c(cbV().hDq.Fp(), true);
        this.hsi.setHost(false);
        this.hsi.a(1, this.bAa);
        this.hsi.a(2, this.bAa);
        this.hsi.setVisible(this.hub ? 8 : 0);
    }

    private void cau() {
        if (this.bAa != null) {
            if (this.hsh == null) {
                this.hsh = new com.baidu.tieba.ala.liveroom.k.a(cbV().pageContext, this);
            }
            this.hsh.setOtherParams(Lr());
            this.hsh.a((ViewGroup) this.bAa, cay());
            this.hsh.M(cbV().hDq.Fp());
        }
    }

    private void cav() {
        if (this.htB == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, j.class, cbV().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.htB = (j) runTask.getData();
            } else {
                return;
            }
        }
        this.htB.setOtherParams(Lr());
        if (this.hsq != null && this.hsq.indexOfChild(this.htB.getView()) >= 0) {
            this.hsq.removeView(this.htB.getView());
        }
    }

    private void caw() {
        if (this.hsY != null) {
            this.hsY.a(new a.InterfaceC0677a() { // from class: com.baidu.tieba.ala.liveroom.c.a.11
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0677a
                public void bP(int i, int i2) {
                    ab Fp = a.this.cbV().hDq.Fp();
                    if (Fp != null && Fp.mLiveInfo != null) {
                        if (a.this.htD == null) {
                            a.this.htD = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.cbV().pageContext.getPageActivity());
                        }
                        a.this.htD.d(a.this.htY, i, i2);
                        a.this.htD.a(String.valueOf(Fp.mLiveInfo.live_id), new a.InterfaceC0681a() { // from class: com.baidu.tieba.ala.liveroom.c.a.11.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0681a
                            public void a(float f, String str) {
                                if (a.this.hsY != null) {
                                    a.this.hsY.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0677a
                public void bQ(int i, int i2) {
                    if (a.this.htD != null) {
                        a.this.htD.bV(i, i2);
                    }
                }
            });
        }
    }

    private void cax() {
        if (this.hun == null) {
            this.hun = new com.baidu.tieba.ala.liveroom.i.e(cbV().pageContext);
        }
        this.hun.setRoomId(cbV().hDq.Fp().mLiveInfo.room_id);
        this.hun.HX("");
        this.hun.b(cbV().hDq.Fp(), this.bAa);
        if (this.hsz == null) {
            this.hsz = new com.baidu.tieba.ala.liveroom.i.b(cbV().pageContext, Lr(), this.hun, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.13
                @Override // com.baidu.tieba.ala.liveroom.i.b.a
                public void caW() {
                    a.this.nP(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.i.b.a
                public void caX() {
                    a.this.nP(false);
                }
            });
        }
        this.hsz.setRoomId(cbV().hDq.Fp().mLiveInfo.room_id);
        if (this.hsq != null && this.hsq.indexOfChild(this.hsz.getView()) >= 0) {
            this.hsq.removeView(this.hsz.getView());
        }
        if (this.hsz != null) {
            this.hsz.b(cbV());
        }
    }

    private LinearLayout.LayoutParams cay() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = cbV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caz() {
        if (this.hsY == null) {
            caF();
        }
        this.hsY.a(com.baidu.live.ae.e.QC().bCD, cbV().hDq.Fp());
    }

    private void caA() {
        CustomResponsedMessage runTask;
        boolean z = true;
        if (this.hto == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, cbV().pageContext)) != null && runTask.getData() != null) {
            this.hto = (k) runTask.getData();
            this.hto.setFromMaster(false);
            this.hto.Kg().getView().setId(a.f.ala_liveroom_msg_list);
            this.hto.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.14
                @Override // com.baidu.live.im.k.a
                public boolean Kk() {
                    return a.this.Ic();
                }

                @Override // com.baidu.live.im.k.a
                public void Kl() {
                    a.this.huf = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hh(String str) {
                    if (!a.this.hub) {
                        a.this.nN(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.cbV().pageContext.getPageActivity(), a.this.cbV().hDp.getLiveContainerView());
                    }
                    a.this.HJ(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Km() {
                    if (a.this.hub) {
                        a.this.nN(true);
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.cbV().pageContext.getPageActivity(), a.this.cbV().hDp.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (a.this.hto != null) {
                        a.this.hto.Kh().setQuickInputPanelVisible(false);
                        a.this.hto.Kh().Mc();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Kn() {
                }

                @Override // com.baidu.live.im.k.a
                public void Ko() {
                    if (a.this.hub) {
                        a.this.caV();
                        if (a.this.htp != null) {
                            a.this.htp.zT();
                        }
                        if (a.this.hsn != null) {
                            a.this.hsn.zT();
                        }
                    } else if (a.this.hto != null) {
                        a.this.hto.Kh().setQuickInputPanelVisible(false);
                        a.this.hto.Kh().Mc();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Kp() {
                    return a.this.cbi();
                }

                @Override // com.baidu.live.im.k.a
                public int Kq() {
                    return a.this.cbj();
                }

                @Override // com.baidu.live.im.k.a
                public boolean Kr() {
                    ab Fp = a.this.cbV().hDq.Fp();
                    if (Fp == null || Fp.aJZ == null) {
                        return false;
                    }
                    return Fp.aJZ.isMysteriousMan;
                }
            });
            this.hsq = new FrameLayout(cbV().pageContext.getPageActivity());
            this.hsq.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.hto != null && this.hsq != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(cbV().pageContext.getPageActivity()) * 0.7f);
            int j = com.baidu.live.aj.c.j(true, false);
            if (this.htY.indexOfChild(this.hsq) < 0) {
                if (this.hsq.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hsq.getParent()).removeView(this.hsq);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, j);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
                this.htY.addView(this.hsq, layoutParams);
            }
            if (this.hsq.indexOfChild(this.hto.Kg().getView()) < 0) {
                if (this.hto.Kg().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hto.Kg().getView()).removeView(this.hto.Kg().getView());
                }
                if (UtilHelper.getRealScreenOrientation(cbV().pageContext.getPageActivity()) != 2) {
                    this.hsq.addView(this.hto.Kg().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, j));
                }
            }
            if (cbV().hDr.indexOfChild(this.hto.Kh().getView()) < 0) {
                if (this.hto.Kh().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hto.Kh().getView().getParent()).removeView(this.hto.Kh().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                cbp();
                cbV().hDr.addView(this.hto.Kh().getView(), layoutParams2);
            }
            ab Fp = cbV().hDq.Fp();
            if (Fp != null && Fp.mLiveInfo != null) {
                this.hto.setLogData(Fp.mLiveInfo.feed_id, Lr());
            }
            if (Fp == null || Fp.aKr == null || !Fp.aKr.Bi()) {
                z = false;
            }
            this.hto.a(String.valueOf(cbV().hDq.Fp().mLiveInfo.group_id), String.valueOf(cbV().hDq.Fp().mLiveInfo.last_msg_id), String.valueOf(cbV().hDq.Fp().aJD.userId), String.valueOf(cbV().hDq.Fp().mLiveInfo.live_id), cbV().hDq.Fp().aJD.appId, z, cbV().hDq.Fp().getGuardName());
            nN(false);
        }
    }

    private void caB() {
        cbn();
    }

    private void caC() {
        if (this.hsr == null) {
            this.hsr = new FrameLayout(cbV().pageContext.getPageActivity());
            this.hsr.setId(a.f.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void caD() {
        if (this.hsd == null) {
            this.hsd = new com.baidu.tieba.ala.liveroom.m.a(cbV().pageContext, false, this);
        }
        this.hsd.e(this.htX, cbV().hDq.Fp());
        this.hsd.a(this.hsF);
        this.hsd.a(this.hsO);
    }

    private void caE() {
        if (this.hsc == null) {
            this.hsc = new com.baidu.tieba.ala.liveroom.audiencelist.c(cbV().pageContext, this, false);
        }
        this.hsc.a(String.valueOf(cbV().hDq.Fp().mLiveInfo.group_id), String.valueOf(cbV().hDq.Fp().mLiveInfo.live_id), String.valueOf(cbV().hDq.Fp().aJD.userId), cbV().hDq.Fp());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.f.ala_liveroom_hostheader;
            if (this.hsZ != null && this.hsZ.getView() != null && this.hsZ.getView().getParent() != null) {
                i = a.f.ala_liveroom_guardthrone;
            }
            this.hsc.c(this.htX, i, a.f.ala_liveroom_audience_count_layout);
            this.hsc.e(cbV().hDq.bTX());
        }
    }

    private void caF() {
        com.baidu.live.core.a.a Mt;
        if (this.hsY == null) {
            this.hsY = new com.baidu.tieba.ala.liveroom.operation.a(cbV().pageContext);
        }
        this.hsY.a(cbV(), this.htY, cbV().hDq.Fp().mLiveInfo, true, this.hsO);
        this.hsY.setOtherParams(Lr());
        if (this.htz != null && (Mt = this.htz.Mt()) != null) {
            View rootLayout = Mt.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.hsY.cu(rootLayout);
        }
        this.hsY.S(cbV().hDq.Fp());
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void caG() {
        caH();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void nL(boolean z) {
    }

    private void caH() {
        if (this.hsY != null) {
            int i = cbV().hDq.Fp().aJZ.isUegBlock;
            int i2 = cbV().hDq.Fp().aJZ.isBlock;
            String str = cbV().hDq.Fp().aJZ.userName;
            if (i > 0 || i2 > 0) {
                this.hsY.b(true, i, i2, str);
                this.hto.a(true, i, i2, str);
                this.htu.b(true, i, i2, str);
                return;
            }
            this.hsY.b(false, i, i2, str);
            this.hto.a(false, i, i2, str);
            this.htu.b(false, i, i2, str);
        }
    }

    private void caI() {
        if (this.hsg == null) {
            this.hsg = new com.baidu.tieba.ala.liveroom.audiencelist.b(cbV().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (cbV().hDq.bTX() != null) {
            j = cbV().hDq.bTX().getCount();
        }
        this.hsg.a(this.hsO);
        this.hsg.a(this.htX, a.f.ala_liveroom_hostheader, j);
        this.hsg.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.hsg.nZ(false);
        } else {
            this.hsg.nZ(true);
        }
    }

    public void caJ() {
        this.htb.d(cbV().hDq.Fp(), false);
    }

    public void caK() {
        if (cbV().hDq.Fp() != null && cbV().hDq.Fp().aJD != null && cbV().hDq.Fp().mLiveInfo != null) {
            if (this.hsf == null) {
                this.hsf = new com.baidu.tieba.ala.liveroom.t.b(cbV().pageContext);
            }
            long j = cbV().hDq.Fp().aJD.userId;
            int i = cbV().hDq.Fp().mLiveInfo.live_type;
            String str = cbV().hDq.Fp().aJD.portrait;
            String str2 = cbV().hDq.Fp().mLiveInfo.feed_id;
            long j2 = cbV().hDq.Fp().mLiveInfo.live_id;
            this.hsf.a(i, j, cbV().hDq.Fp().aJD.userName, false, str, Lr(), str2, j2);
            this.hsf.aF(this.htX);
        }
    }

    private void caL() {
        boolean z = false;
        if (this.htj == null) {
            this.htj = new com.baidu.tieba.ala.liveroom.v.a(cbV().pageContext, this);
        }
        this.htj.c(cbV().hDr, false);
        boolean cbU = cbU();
        AlaLiveInfoData alaLiveInfoData = cbV().hDq.Fp().mLiveInfo;
        boolean isZanAnimUnabled = (alaLiveInfoData == null || alaLiveInfoData.mAlaLiveSwitchData == null) ? false : alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled();
        if (cbU && !isZanAnimUnabled) {
            z = true;
        }
        this.htj.oR(z);
    }

    private void caM() {
        if (cbV() != null && cbV().btp != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(cbV().pageContext.getPageActivity());
            Activity pageActivity = cbV().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + p.bq(pageActivity)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.hss = new ImageView(cbV().pageContext.getPageActivity());
            this.hss.setVisibility(8);
            this.hss.setBackgroundResource(a.e.sdk_round_btn_close_bg);
            this.hss.setImageResource(a.e.icon_live_enlarge);
            this.hss.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hst != null) {
                        a.this.hst.Ud();
                        a.this.hss.setVisibility(4);
                        a.this.hto.Ki().cw(false);
                    }
                }
            });
            cbV().hDr.addView(this.hss, layoutParams);
            if (UtilHelper.getRealScreenOrientation(cbV().pageContext.getPageActivity()) != 2) {
                if (cbV().hDx) {
                    this.hss.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.17
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.hss != null && UtilHelper.getRealScreenOrientation(a.this.cbV().pageContext.getPageActivity()) != 2) {
                                a.this.hss.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
        }
    }

    private void caN() {
        if (this.htW == null) {
            this.htW = new com.baidu.tieba.ala.liveroom.apppromotion.a(cbV().pageContext);
        }
        this.htW.b(caT(), cbV().hDq.Fp());
    }

    private void caO() {
        if (this.huf || this.hug) {
            if ((TbadkCoreApplication.isLogin() && this.hto.Kh().hasText()) || this.hug) {
                this.huf = false;
                this.hug = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.18
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cbm();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void t(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        super.t(bVar);
        if (this.hsi != null) {
            this.hsi.N(bVar);
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
        if (this.hsp == null || !this.hsp.ab(jSONObject)) {
            if ((bVar.getMsgType() == 12 || bVar.getMsgType() == 13) && jSONObject != null) {
                String optString = jSONObject.optString("content_type");
                if ("task".equals(optString)) {
                    if (this.hsh != null) {
                        this.hsh.S(jSONObject);
                    }
                } else if ("enter_live".equals(optString)) {
                    if (this.hsg != null && this.hsg.getCount() > 20) {
                        this.hsg.ff(this.hsg.getCount() + 1);
                    } else if (this.hsc != null) {
                        com.baidu.live.data.a Lc = bVar.Lc();
                        u uVar = new u();
                        uVar.aJE = new AlaLocationData();
                        uVar.aJF = new AlaRelationData();
                        uVar.aJD = new AlaLiveUserInfoData();
                        uVar.aJD.userId = JavaTypesHelper.toLong(Lc.userId, 0L);
                        uVar.aJD.userName = Lc.userName;
                        uVar.aJD.portrait = Lc.portrait;
                        if (this.hsg != null && this.hsc.c(uVar)) {
                            this.hsg.ff(this.hsg.getCount() + 1);
                        }
                    }
                } else if ("update_liveinfo".equals(optString)) {
                    if (cbV().hDq.Fp() != null && cbV().hDq.Fp().mLiveInfo != null) {
                        cbV().hDq.a(cbV().hDq.Fp().mLiveInfo.live_id, cbV().fromType, cbV().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && cbV().hDq.Fp() != null && cbV().hDq.Fp().mLiveInfo != null && cbV().hDq.Fp().aJZ != null && this.hsl != null) {
                    long optLong = jSONObject.optLong("mvp_user_id");
                    long optLong2 = jSONObject.optLong("winner_live_id");
                    if (optLong == cbV().hDq.Fp().aJZ.userId && optLong2 == cbV().hDq.Fp().mLiveInfo.live_id) {
                        this.hsl.g(jSONObject.optInt("challenge_status"), jSONObject.optLong("challenge_id"));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void HE(String str) {
        if (this.hsi != null) {
            this.hsi.HE(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(ab abVar) {
        super.k(abVar);
        if (this.hsd != null) {
            this.hsd.N(abVar);
        }
        if (this.hse != null) {
            this.hse.J(abVar);
        }
        if (this.hsh != null) {
            this.hsh.M(abVar);
        }
        if (this.hsl != null) {
            this.hsl.a(abVar);
        }
        if (this.hsn != null) {
            this.hsn.a(abVar);
        }
        if (this.hsi != null) {
            this.hsi.j(abVar);
            if (abVar != null && this.htP != null && !this.htP.hasInit && !TextUtils.isEmpty(this.htP.aRJ)) {
                this.htP.hasInit = true;
                this.hsi.HF(this.htP.aRJ);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(v vVar) {
        if (vVar != null) {
            if (this.hsc != null && vVar.getList() != null) {
                this.hsc.e(vVar);
            }
            if (this.hsg != null) {
                this.hsg.ff(vVar.getCount());
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void cH(boolean z) {
        super.cH(z);
        if (cbV().hDr != null) {
            cbV().hDr.clw();
            cbV().hDr.setLiveViewOnDispatchTouchEventListener(null);
            cbV().hDr.setLiveViewOnTouchEventListener(null);
            cbV().hDr.setOnLiveViewScrollListener(null);
        }
        if (cbV().btp != null) {
            cbV().btp.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
        }
        if (this.hsl != null) {
            this.hsl.Au();
        }
        caP();
        if (this.hsf != null) {
            this.hsf.Au();
        }
        if (this.htj != null) {
            this.htj.release();
        }
        if (this.hsh != null) {
            this.hsh.Au();
        }
        if (this.hsp != null) {
            this.hsp.xk();
        }
        if (this.hsY != null) {
            this.hsY.ckc();
        }
        if (this.hse != null) {
            this.hse.cez();
            this.hse.setVisible(8);
        }
        if (this.hsj != null) {
            this.hsj.Au();
        }
        if (this.hsi != null) {
            this.hsi.release();
        }
        if (this.bAa != null) {
            this.bAa.removeAllViews();
            this.bAa = null;
        }
        if (this.hsk != null) {
            this.hsk.Au();
        }
        if (this.hsn != null) {
            this.hsn.a((a.InterfaceC0185a) null);
            this.hsn.zU();
        }
        if (this.hsd != null) {
            this.hsd.cgw();
        }
        if (this.hss != null && (this.hss.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hss.getParent()).removeView(this.hss);
        }
        if (this.hso != null) {
            this.hso.dismiss();
        }
        if (this.hst != null) {
            this.hst.dh(false);
            this.hst.Ue();
        }
        if (this.hsz != null) {
            this.hsz.Au();
        }
        if (this.hun != null) {
            this.hun.cdt();
        }
        if (this.htR != null) {
            this.htR.Au();
        }
        if (this.htW != null) {
            this.htW.xk();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void n(ab abVar) {
        View zS;
        super.n(abVar);
        if (this.hsn != null && (zS = this.hsn.zS()) != null && zS.getParent() != null) {
            ((ViewGroup) zS.getParent()).removeView(zS);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.hsn != null) {
            this.hsn.setOtherParams(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cF(boolean z) {
        super.cF(z);
        this.hsx.removeCallbacksAndMessages(null);
        caP();
        this.hsv = false;
        this.hsw = false;
        if (this.hsd != null) {
            this.hsd.onDestroy();
        }
        if (this.hsf != null) {
            this.hsf.onDestroy();
        }
        if (this.hsh != null) {
            this.hsh.onDestroy();
        }
        if (this.hsj != null) {
            this.hsj.onDestroy();
        }
        if (this.hsk != null) {
            this.hsk.onDestroy();
        }
        if (this.hsl != null) {
            this.hsl.onDestroy();
        }
        if (this.hsm != null) {
            this.hsm.onDestroy();
        }
        if (this.hso != null) {
            this.hso.onDestroy();
        }
        if (this.hse != null) {
            this.hse.onDestroy();
        }
        if (this.hst != null) {
            this.hst.stop();
        }
        if (this.htj != null) {
            this.htj.onDestroy();
        }
        if (this.hsc != null) {
            this.hsc.onDestroy();
        }
        if (this.hto != null) {
            this.hto.onDestroy();
        }
        if (this.hsY != null) {
            this.hsY.onDestory();
        }
        if (this.hsn != null) {
            this.hsn.a((a.InterfaceC0185a) null);
            this.hsn.release();
            this.hsn = null;
        }
        if (this.hun != null) {
            this.hun.cF(z ? false : true);
        }
        if (this.hsz != null) {
            this.hsz.onDestroy();
            this.hsz = null;
        }
        if (this.htR != null) {
            this.htR.onDestroy();
        }
        if (this.hsp != null) {
            this.hsp.onDestroy();
        }
        if (this.htW != null) {
            this.htW.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.hsB);
        MessageManager.getInstance().removeMessageRule(this.hsA);
        MessageManager.getInstance().removeMessageRule(this.hsC);
        MessageManager.getInstance().removeMessageRule(this.hsD);
        MessageManager.getInstance().unRegisterListener(this.hsI);
        MessageManager.getInstance().unRegisterListener(this.hsL);
        MessageManager.getInstance().unRegisterListener(this.hsM);
        MessageManager.getInstance().unRegisterListener(this.hsN);
        MessageManager.getInstance().unRegisterListener(this.hsK);
        MessageManager.getInstance().unRegisterListener(this.hsJ);
        MessageManager.getInstance().unRegisterListener(this.hsG);
        MessageManager.getInstance().unRegisterListener(this.hsH);
    }

    private void caP() {
        if (this.hto != null && this.hto.Kg().getView() != null && this.hto.Kg().getView().getParent() != null) {
            ((ViewGroup) this.hto.Kg().getView().getParent()).removeView(this.hto.Kg().getView());
        }
        if (this.hsq != null && this.hsq.getParent() != null) {
            ((ViewGroup) this.hsq.getParent()).removeView(this.hsq);
        }
        if (this.hsr != null && this.hsr.getParent() != null) {
            ((ViewGroup) this.hsr.getParent()).removeView(this.hsr);
        }
        if (this.hto != null && this.hto.Kh().getView() != null) {
            this.htY.removeView(this.hto.Kh().getView());
        }
        if (this.hto != null) {
            this.hto.Kg().setMsgData(new LinkedList());
            this.hto.zU();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void a(ax axVar) {
        if (this.hto != null) {
            cbm();
            String nameShow = axVar.getNameShow();
            if (axVar.extInfoJson != null) {
                if (axVar.extInfoJson.optInt("is_mysterious_man") == 1) {
                    nameShow = axVar.extInfoJson.optString("mysterious_man_nickname");
                    if (TextUtils.isEmpty(nameShow)) {
                        nameShow = "神秘人";
                    }
                }
            }
            this.hto.Kh().setEditText(" @" + nameShow + " ");
        }
        if (this.hsY != null) {
            this.hsY.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void g(com.baidu.live.data.a aVar) {
        if (this.hto != null) {
            cbm();
            String nameShow = aVar.getNameShow();
            if (aVar.extInfoJson != null) {
                if (aVar.extInfoJson.optInt("is_mysterious_man") == 1) {
                    nameShow = aVar.extInfoJson.optString("mysterious_man_nickname");
                    if (TextUtils.isEmpty(nameShow)) {
                        nameShow = "神秘人";
                    }
                }
            }
            this.hto.Kh().setEditText(" @" + nameShow + " ");
        }
        if (this.hsY != null) {
            this.hsY.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void HH(String str) {
        if (this.hto != null) {
            cbm();
            StringBuilder sb = new StringBuilder();
            sb.append(" @");
            sb.append(str);
            sb.append(" ");
            if (com.baidu.live.ae.a.Qm().bwx.aOe != null && com.baidu.live.ae.a.Qm().bwx.aOe.originTexts != null && com.baidu.live.ae.a.Qm().bwx.aOe.originTexts.size() > 0) {
                this.hto.Kh().Md();
                this.hto.Kh().setEditText(sb.toString() + com.baidu.live.ae.a.Qm().bwx.aOe.originTexts.get(0));
            } else {
                this.hto.Kh().setEditText(sb.toString());
            }
        }
        if (this.hsY != null) {
            this.hsY.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void b(ax axVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected View caQ() {
        if (this.hto != null) {
            return this.hto.Kh().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean caR() {
        if (this.hto == null || !this.hto.Kh().Mb()) {
            return false;
        }
        nN(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean caS() {
        return this.hsd == null || this.hsd.caS();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup caT() {
        return this.bAa;
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
                    this.huc = false;
                    P(intExtra, intExtra2, intExtra3);
                    return;
                }
                caJ();
                return;
            }
            awr();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.hub;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(cbV().pageContext.getPageActivity()) || z2) {
            nM(z);
        }
    }

    private void nM(boolean z) {
        if (this.hto != null && this.hto.Kg() != null) {
            this.hto.Kg().onKeyboardVisibilityChanged(z);
        }
        if (z || this.hto == null || !this.hto.Kh().Mb()) {
            if (z) {
                if (this.hsY != null) {
                    this.hsY.setVisibility(8);
                }
                if (this.htq != null && this.htq.EM() != null) {
                    this.htq.EM().setVisibility(8);
                }
                caV();
                if (this.hto != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hto.Kh().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.hto.Kh().getView().setLayoutParams(layoutParams);
                    this.hto.Kh().getView().setVisibility(0);
                    this.hto.Kh().setQuickInputPanelVisible(false);
                    this.hto.Ki().cw(false);
                }
                if (this.htX != null) {
                    this.htX.setVisibility(8);
                }
                if (this.hsi != null) {
                    this.hsi.setVisible(8);
                }
                if (this.htp != null) {
                    this.htp.zT();
                }
                if (this.htQ != null) {
                    this.htQ.setCanVisible(false);
                }
                if (this.htG != null) {
                    this.htG.setCanVisible(false);
                }
                if (this.htK != null) {
                    this.htK.setCanVisible(false);
                }
                if (this.htL != null) {
                    this.htL.setVisible(8);
                }
                if (this.htJ != null) {
                    this.htJ.setCanVisible(false);
                }
                if (this.htW != null) {
                    this.htW.setCanVisible(false);
                }
                if (this.htM != null) {
                    this.htM.setCanVisible(false);
                }
            } else {
                caU();
            }
            if (this.hto != null && this.hsq != null) {
                if (this.htY.indexOfChild(this.hsq) != -1 && this.hsq.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hsq.getLayoutParams();
                    layoutParams2.height = com.baidu.live.aj.c.j(true, z);
                    this.hsq.setLayoutParams(layoutParams2);
                }
                if (this.hsq.indexOfChild(this.hto.Kg().getView()) != -1 && this.hto.Kg().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.hto.Kg().getView().getLayoutParams();
                    layoutParams3.height = com.baidu.live.aj.c.j(true, z);
                    this.hto.Kg().getView().setLayoutParams(layoutParams3);
                }
                this.hto.Kg().Kf();
            }
        }
    }

    private void caU() {
        if (this.hsY != null) {
            this.hsY.setVisibility(0);
        }
        if (this.hsq != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hsq.getLayoutParams();
            layoutParams.bottomMargin = cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            this.hsq.setLayoutParams(layoutParams);
        }
        if (this.hto != null) {
            cbp();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hto.Kh().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.hto.Kh().getView().setLayoutParams(layoutParams2);
            if (this.aOg) {
                if (UtilHelper.getRealScreenOrientation(cbV().pageContext.getPageActivity()) != 2 && !this.hto.Ki().isClicked()) {
                    this.hto.Ki().cw(true);
                }
            } else {
                this.hto.Ki().cw(false);
            }
        }
        if (this.hsY != null) {
            this.hsY.setVisibility(0);
        }
        if (this.htq != null && this.htq.EM() != null) {
            this.htq.EM().setVisibility(0);
        }
        if (this.htX != null && (!this.hsv || UtilHelper.getRealScreenOrientation(cbV().pageContext.getPageActivity()) != 2)) {
            this.htX.setVisibility(0);
        }
        if (this.hsi != null) {
            this.hsi.setVisible(0);
        }
        if (this.htp != null) {
            this.htp.zT();
        }
        if (this.htQ != null) {
            this.htQ.setCanVisible(true);
        }
        if (this.htG != null) {
            this.htG.setCanVisible(true);
        }
        if (this.htK != null) {
            this.htK.setCanVisible(true);
        }
        if (this.htL != null) {
            this.htL.setVisible(0);
        }
        if (this.htJ != null) {
            this.htJ.setCanVisible(true);
        }
        if (this.htW != null) {
            this.htW.setCanVisible(true);
        }
        if (this.htM != null) {
            this.htM.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caV() {
        boolean z;
        boolean z2;
        if (this.hsq != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hsq.getLayoutParams();
            if (this.hto == null || this.hto.Kh() == null) {
                z = false;
                z2 = false;
            } else {
                boolean LZ = this.hto.Kh().LZ();
                z = this.hto.Kh().Ma();
                z2 = LZ;
            }
            int O = O(z2, z);
            if (layoutParams.bottomMargin != O) {
                layoutParams.bottomMargin = O;
                this.hsq.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nN(boolean z) {
        if (z) {
            this.hto.Kh().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hsq.getLayoutParams();
            int quickInputPanelExpandHeight = this.hto.Kh().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.hsq.setLayoutParams(layoutParams);
                if (this.hto.Kg() != null) {
                    this.hto.Kg().Kf();
                    return;
                }
                return;
            }
            return;
        }
        caU();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        FrameLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = cbV().pageContext.getPageActivity();
        if (i3 == 1) {
            if (cbV().pageContext.getPageActivity() != null) {
                r.e(cbV().pageContext.getPageActivity(), true);
            }
            if (this.htX != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.htX.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.hso != null) {
                this.hso.dismiss();
            }
            if (this.hsn != null) {
                this.hsn.a((a.InterfaceC0185a) null);
                this.hsn.zU();
            }
            if (this.btl != null) {
                this.btl.e(true, true);
            }
            if (this.hss != null) {
                this.hss.setVisibility(0);
                this.hss.bringToFront();
            }
            if (this.hte != null) {
                this.hte.setVisibility(0);
            }
            if (this.hto != null && this.hto.Kg().getView().getParent() != null && (this.hto.Kg().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hto.Kg().getView().getParent()).removeView(this.hto.Kg().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(cbV().pageContext.getPageActivity()) * 0.7f);
            int j = com.baidu.live.aj.c.j(true, false);
            if (this.hsq != null && this.hto != null) {
                this.hsq.addView(this.hto.Kg().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, j));
            }
            if (this.hsr != null && (this.hsr.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hsr.getParent()).removeView(this.hsr);
            }
            if (this.htp != null) {
                this.htp.a(cbV().hDq.Fp(), false);
                this.htp.a(new a.InterfaceC0185a() { // from class: com.baidu.tieba.ala.liveroom.c.a.19
                    @Override // com.baidu.live.im.b.a.InterfaceC0185a
                    public void KP() {
                        a.this.cbG();
                    }
                });
                View zS = this.htp.zS();
                if (zS != null && this.htY != null && zS.getParent() == null) {
                    Resources resources = cbV().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(cbV().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                    layoutParams5.addRule(2, a.f.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                    this.htY.addView(zS, layoutParams5);
                }
            }
            if (this.htg != null) {
                this.htg.setPraiseEnable(true);
                cbV().hDr.hTf = true;
            }
            if (this.hsc != null && this.hsc.hvH != null && (layoutParams3 = (FrameLayout.LayoutParams) this.hsc.hvH.getLayoutParams()) != null) {
                layoutParams3.width = -2;
                this.hsc.hvH.setLayoutParams(layoutParams3);
            }
            if (this.htj != null) {
                this.htj.clW();
            }
            if (this.hsv) {
                nK(true);
            }
            if (this.hsw) {
                if (this.hsY != null && this.hsY.getLandscapeBarrageImageView() != null) {
                    b(this.hsY.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.hsY != null) {
                this.hsY.wc(0);
            }
            if (this.hsg != null) {
                this.hsg.nY(true);
            }
            this.hsx.removeCallbacksAndMessages(null);
            if (this.hsh != null) {
                this.hsh.setCanVisible(true);
                this.hsh.M(cbV().hDq.Fp());
            }
            if (this.hsp != null) {
                this.hsp.cT(true);
            }
            if (this.hto != null) {
                if (this.aOg) {
                    if (!this.hto.Ki().isClicked()) {
                        this.hto.Ki().cw(true);
                    }
                } else {
                    this.hto.Ki().cw(false);
                }
            }
        } else if (i3 == 2) {
            if (cbV().pageContext.getPageActivity() != null) {
                r.e(cbV().pageContext.getPageActivity(), false);
            }
            if (this.htj != null) {
                this.htj.clX();
            }
            if (this.htX != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.htX.getLayoutParams()) != null) {
                layoutParams2.topMargin = cbV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
            }
            if (this.htp != null) {
                this.htp.a((a.InterfaceC0185a) null);
                this.htp.zU();
            }
            cbV().hDr.cly();
            if (this.btl != null) {
                this.btl.e(false, true);
            }
            if (this.hss != null) {
                this.hss.setVisibility(4);
            }
            if (this.hto != null && this.hto.Kg().getView().getParent() != null && (this.hto.Kg().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hto.Kg().getView().getParent()).removeView(this.hto.Kg().getView());
                this.hto.Ki().cw(false);
            }
            int max = Math.max(i, i2);
            if (this.hsr != null) {
                if (this.hsr.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hsr.getParent()).removeView(this.hsr);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100);
                cbV().hDr.addView(this.hsr, this.bAa != null ? cbV().hDr.indexOfChild(this.bAa) : -1, layoutParams6);
            }
            if (this.hsr != null && this.hsn != null) {
                this.hsn.a(cbV().hDq.Fp(), false);
                this.hsn.a(new a.InterfaceC0185a() { // from class: com.baidu.tieba.ala.liveroom.c.a.20
                    @Override // com.baidu.live.im.b.a.InterfaceC0185a
                    public void KP() {
                        a.this.cbG();
                    }
                });
                View zS2 = this.hsn.zS();
                if (zS2 != null && this.hsr.indexOfChild(zS2) < 0) {
                    this.hsr.addView(zS2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(cbV().pageContext.getPageActivity()), -1));
                }
            }
            if (this.htg != null) {
                this.htg.aM(cbV().hDr);
                this.htg.setPraiseEnable(false);
                cbV().hDr.hTf = false;
            }
            if (this.hsc != null && this.hsc.hvH != null && (layoutParams = (FrameLayout.LayoutParams) this.hsc.hvH.getLayoutParams()) != null) {
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                layoutParams.width = (int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f);
                this.hsc.hvH.setLayoutParams(layoutParams);
            }
            if (this.hsY != null) {
                this.hsY.wc(8);
            }
            if (this.hsg != null) {
                this.hsg.nY(false);
            }
            if (al.FE() != null) {
                al.FE().FD();
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.ag.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.ag.c) runTask.getData()).FD();
            }
            if (this.hsY != null && this.hsY.getLandscapeBarrageImageView() != null) {
                b(this.hsY.getLandscapeBarrageImageView(), this.hsw, false);
            }
            caj();
            if (this.htq != null) {
                this.htq.EO();
            }
            if (this.hsh != null) {
                this.hsh.setCanVisible(false);
                this.hsh.cfC();
            }
            if (this.hsp != null) {
                this.hsp.setCanVisible(false);
            }
        }
        if (this.htK != null) {
            this.htK.cL(i3);
        }
        if (this.htx != null) {
            this.htx.cL(i3);
        }
        if (this.htr != null) {
            this.htr.cL(i3);
        }
        if (this.hto != null) {
            this.hto.Ki().cL(i3);
        }
        if (this.hsY != null) {
            this.hsY.l(i, i2, i3);
        }
        K(i3, true);
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.hsc != null) {
                this.hsc.cs(i3);
            }
            if (this.hse != null) {
                this.hse.cs(i3);
            }
            if (this.hsi != null) {
                this.hsi.cs(i3);
            }
            if (this.htz != null) {
                this.htz.cs(i3);
            }
            if (this.htu != null) {
                this.htu.cs(i3);
            }
            if (this.bif != null) {
                this.bif.cs(i3);
            }
            if (this.hsy != null && this.hsy.isShowing()) {
                this.hsy.resize();
            }
            if (this.htQ != null) {
                this.htQ.cs(i3);
            }
            if (this.htR != null) {
                this.htR.cs(i3);
            }
            if (this.htO != null) {
                this.htO.cL(i3);
            }
            if (this.htU != null) {
                this.htU.cs(i3);
            }
        }
        if (this.htq != null) {
            this.htq.EN();
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public boolean dG(int i) {
        boolean dG = super.dG(i);
        if (dG && 2 == i) {
            if (this.hsd.caS()) {
                return false;
            }
            if (dG && this.htj != null) {
                this.htj.oS(false);
            }
        }
        return dG;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void vq(int i) {
        super.vq(i);
        if (i == 7 || i == 11) {
            if (i != 7 || UtilHelper.getRealScreenOrientation(cbV().pageContext.getPageActivity()) != 2) {
                if (this.hsY != null) {
                    this.hsY.setVisibility(8);
                }
                if (this.hto != null) {
                    this.hto.Kg().getView().setVisibility(4);
                    this.hto.Ki().cw(false);
                }
                if (this.htD != null) {
                    this.htD.oM(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public void dH(int i) {
        super.dH(i);
        if (i == 7 || i == 11) {
            if (this.hsY != null) {
                this.hsY.setVisibility(0);
            }
            if (this.hto != null) {
                this.hto.Kg().getView().setVisibility(0);
                if (this.aOg && UtilHelper.getRealScreenOrientation(cbV().pageContext.getPageActivity()) != 2 && !this.hto.Ki().isClicked()) {
                    this.hto.Ki().cw(true);
                }
            }
            if (this.htD != null) {
                this.htD.oM(true);
            }
            if (!this.hsv || UtilHelper.getRealScreenOrientation(cbV().pageContext.getPageActivity()) != 2) {
                this.htX.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.hsf != null) {
            this.hsf.ckz();
        }
        if (this.hsk != null) {
            this.hsk.AD();
        }
        if (this.hsi != null) {
            this.hsi.onStop();
        }
        if (cbV() != null) {
            BdUtilHelper.hideSoftKeyPad(cbV().pageContext.getPageActivity(), cbV().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.hsf != null) {
            this.hsf.cky();
        }
        if (this.hsk != null) {
            this.hsk.AE();
        }
        if (this.hsi != null) {
            this.hsi.onStart();
        }
        if (this.htO != null) {
            this.htO.onStart();
        }
        if (this.htW != null) {
            this.htW.onStart();
        }
    }

    private void K(int i, boolean z) {
        if (this.bAa != null) {
            int dimensionPixelSize = cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bAa.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                layoutParams.rightMargin = cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6);
                layoutParams.height = cas();
                this.bAa.setPosition(dimensionPixelSize, 0, dimensionPixelSize, 0);
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                int dimensionPixelSize2 = cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds72) + 0 + cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100) + cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
                layoutParams.height = -1;
                this.bAa.setPosition(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
            }
            layoutParams.bottomMargin = cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds114);
            this.bAa.setLayoutParams(layoutParams);
            this.bAa.setModel(i == 1 ? PendantParentView.Model.HORIZONTAL : PendantParentView.Model.HORIZONTAL_FULL);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.e
    public void vr(int i) {
        K(this.mOrientation, false);
    }
}
