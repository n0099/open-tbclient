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
/* loaded from: classes11.dex */
public class a extends b implements com.baidu.live.m.c, e {
    private PendantParentView byA;
    private com.baidu.live.e.a hqA;
    private i hqB;
    private h hqC;
    private com.baidu.tieba.ala.liveroom.b.a hqD;
    private com.baidu.live.im.b.a hqE;
    private com.baidu.tieba.ala.liveroom.share.b hqF;
    private com.baidu.live.ad.a hqG;
    private FrameLayout hqH;
    private FrameLayout hqI;
    private ImageView hqJ;
    private com.baidu.live.tieba.e.b hqK;
    private ah hqP;
    private com.baidu.tieba.ala.liveroom.i.b hqQ;
    private com.baidu.tieba.ala.liveroom.audiencelist.c hqt;
    private com.baidu.tieba.ala.liveroom.m.a hqu;
    private com.baidu.tieba.ala.liveroom.f.b hqv;
    private com.baidu.tieba.ala.liveroom.t.b hqw;
    private com.baidu.tieba.ala.liveroom.audiencelist.b hqx;
    private com.baidu.tieba.ala.liveroom.k.a hqy;
    private com.baidu.tieba.ala.liveroom.activeview.b hqz;
    private long lastClickTime = 0;
    private boolean hqL = false;
    private boolean hqM = false;
    private boolean hqN = false;
    private Handler hqO = new Handler();
    private HttpRule hqR = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.hqB != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.hqB.AG()) {
                httpMessage.addParam("ala_challenge_id", a.this.hqB.AJ());
            }
            return httpMessage;
        }
    };
    private HttpRule hqS = new HttpRule(1021229) { // from class: com.baidu.tieba.ala.liveroom.c.a.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.hqB != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.hqB.AG()) {
                httpMessage.addParam("challenge_id", a.this.hqB.AJ());
            }
            return httpMessage;
        }
    };
    private HttpRule hqT = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.c.a.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.hqB != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.hqB.AG()) {
                httpMessage.addParam("challenge_id", a.this.hqB.AJ());
            }
            return httpMessage;
        }
    };
    private HttpRule hqU = new HttpRule(1021232) { // from class: com.baidu.tieba.ala.liveroom.c.a.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.hqB != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.hqB.AG()) {
                httpMessage.addParam("challenge_id", a.this.hqB.AJ());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c hqV = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.c.a.23
        @Override // com.baidu.live.liveroom.g.c
        public void Nd() {
            if (a.this.hrA != null) {
                a.this.hrA.oS(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cI(boolean z) {
            if (z) {
                if (a.this.hrA != null) {
                    a.this.hrA.oS(true);
                }
            } else if (a.this.hrA != null) {
                a.this.hrA.oS(false);
            }
            if (a.this.hrT != null) {
                a.this.hrT.bD(z);
            }
            if (a.this.hqz != null) {
                a.this.hqz.nJ(z ? false : true);
            }
            com.baidu.live.p.a.cJ(z);
        }
    };
    private com.baidu.tieba.ala.liveroom.m.c hqW = new com.baidu.tieba.ala.liveroom.m.c() { // from class: com.baidu.tieba.ala.liveroom.c.a.24
        @Override // com.baidu.tieba.ala.liveroom.m.c
        public void onClick() {
            a.this.hqO.removeCallbacksAndMessages(null);
            a.this.hqL = true;
        }

        @Override // com.baidu.tieba.ala.liveroom.m.c
        public void endAnimation() {
            if (a.this.hqL) {
                a.this.cad();
            }
        }
    };
    private CustomMessageListener hqX = new CustomMessageListener(2913287) { // from class: com.baidu.tieba.ala.liveroom.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hqK != null) {
                a.this.hqK.dh(false);
                a.this.hqK.Ub();
            }
        }
    };
    private CustomMessageListener hqY = new CustomMessageListener(2913290) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hqK != null) {
                a.this.hqK.dh(true);
            }
        }
    };
    private HttpMessageListener hqZ = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Ow() != null) {
                        com.baidu.live.ae.e.Qz().bBd = getQuickGiftHttpResponseMessage.Ow();
                        a.this.cat();
                    }
                }
            }
        }
    };
    private CustomMessageListener hra = new CustomMessageListener(2913276) { // from class: com.baidu.tieba.ala.liveroom.c.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            JSONObject optJSONObject;
            JSONArray optJSONArray;
            if (a.this.mOrientation == 1 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject) && (optJSONObject = ((JSONObject) customResponsedMessage.getData()).optJSONObject("ext_data")) != null && (optJSONArray = optJSONObject.optJSONArray("surprise_prize_member")) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                View inflate = LayoutInflater.from(a.this.activity).inflate(a.g.ala_fudai_dialog_layout, (ViewGroup) null);
                final Dialog dialog = new Dialog(a.this.cbP().pageContext.getPageActivity(), a.i.FudaiDialogStyle);
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
                            aoVar.aJX = -1;
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
    private CustomMessageListener hrb = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.c.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                a.this.hrI.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener hrc = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.c.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.hsv != null && a.this.hsv.biY != null && !a.this.hsv.bjd && !a.this.hsv.bje && a.this.hrS != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.cbP().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                if (a.this.hrF != null && a.this.hrF.Kf().Ml()) {
                    layoutParams.bottomMargin = a.this.cbP().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds88);
                } else {
                    layoutParams.bottomMargin = a.this.cbP().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                }
                a.this.hrS.c(a.this.hqH, layoutParams);
                if (com.baidu.live.guardclub.e.IS() != null) {
                    com.baidu.live.guardclub.e.IS().IX();
                }
            }
        }
    };
    private CustomMessageListener hrd = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.a.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (a.this.bgE != null) {
                    a.this.bgE.dismiss();
                }
                com.baidu.live.im.b.d.KN().setSwitchStatus(true);
                com.baidu.live.im.b.d.KN().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cbg();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener hre = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.c.a.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.hqQ.c(a.this.cbP());
                } else if (a.this.cbb() || !g.vB(2913168)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.cbP().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.cbP().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    a.this.hqQ.c(a.this.hqH, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b hrf = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.a.15
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
                if (i == 2 && a.this.HZ()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel"));
                    a.this.P(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.ae.e.Qz().bBd.ES().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.ae.e.Qz().bBd.ES().DR());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.ae.e.Qz().bBd.ES().DS());
                        if (a.this.cbP().hBH.Fm() != null && a.this.cbP().hBH.Fm().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.cbP().hBH.Fm().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.cbP().hBH.Fm().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.Lo());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.HZ()) {
                        if (com.baidu.live.d.xc().getBoolean("quick_gift_guide_show", true) && !a.this.cbb()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, ah.class, a.this.cbP().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                ah ahVar = (ah) runTask.getData();
                                ahVar.setPageContext(a.this.cbP().pageContext);
                                ahVar.setLiveShowData(a.this.cbP().hBH.Fm());
                                ahVar.setGiftItem(com.baidu.live.ae.e.Qz().bBd.ES());
                                ahVar.setOtherParams(a.this.Lo());
                                ahVar.initView();
                                ahVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.15.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        a.this.nP(false);
                                        a.this.hqP = null;
                                    }
                                });
                                a.this.hqP = ahVar;
                                ahVar.show();
                                a.this.nP(true);
                                return;
                            }
                            return;
                        }
                        n.a(a.this.cbP().pageContext, a.this.cbP().hBH.Fm(), com.baidu.live.ae.e.Qz().bBd.ES(), a.this.Lo());
                    }
                } else if (i == 1) {
                    if (a.this.hrF != null) {
                        a.this.cbg();
                    }
                } else if (i == 3 && a.this.HZ()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    if (a.this.mOrientation == 2 && (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                        if (a.this.hqF != null) {
                            a.this.hqF.U(a.this.cbP().hBH.Fm());
                        }
                    } else {
                        a.this.hrs.d(a.this.cbP().hBH.Fm(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.cbP() != null && a.this.cbP().hBH != null && a.this.cbP().hBH.Fm() != null && a.this.cbP().hBH.Fm().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.cbP().hBH.Fm().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.cbP().hBH.Fm().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.cbP().hBH.Fm().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.Lo());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.cbP() != null && a.this.cbP().hBH != null && a.this.cbP().hBH.Fm() != null && a.this.cbP().hBH.Fm().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.cbP().hBH.Fm().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.cbP().hBH.Fm().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.cbP().hBH.Fm().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.Lo());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.brL != null) {
                        a.this.brL.cC(false);
                    }
                } else if (i == 12) {
                    if (a.this.hrA != null) {
                        String valueOf = String.valueOf(a.this.cbP().hBH.Fm().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.cbP().hBH.Fm().mLiveInfo.room_id);
                        String str3 = null;
                        AlaLiveSdkInfo alaLiveSdkInfo = a.this.cbP().hBH.Fm().mLiveSdkInfo;
                        if (alaLiveSdkInfo != null && alaLiveSdkInfo.mCastIds != null) {
                            str3 = String.valueOf(a.this.cbP().hBH.Fm().mLiveSdkInfo.mCastIds.chatMCastId);
                        }
                        a.this.hrA.ax(valueOf, valueOf2, str3);
                        com.baidu.live.p.a.c(a.this.cbP().hBH.Fm().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    ab Fm = a.this.cbP().hBH.Fm();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.cbP().pageContext.getPageActivity(), Fm.aId.userName, Long.toString(Fm.aId.userId), Long.toString(Fm.aId.charmCount), String.valueOf(Fm.mLiveInfo.group_id), String.valueOf(Fm.mLiveInfo.live_id), false, String.valueOf(Fm.aId.userId), Long.toString(Fm.aIz.userId), Fm.aIz.userName, Fm.aIz.portrait, a.this.hqx.getCount(), a.this.Lo())));
                    LogManager.getCommonLogger().doClickGusetNumLog(Fm.mLiveInfo.feed_id, a.this.hqx.getCount() + "", a.this.Lo());
                } else if (i == 11) {
                    a.this.cbl();
                    a.this.cbm();
                } else if (i == 16) {
                    if (a.this.cbP() != null && (bvVar2 = com.baidu.live.ae.a.Qj().bAS) != null && (coVar = bvVar2.aPM) != null) {
                        String str4 = coVar.aRu.aRD;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (a.this.cbP().hBH != null && a.this.cbP().hBH.Fm() != null && a.this.cbP().hBH.Fm().mLiveInfo != null) {
                                j = a.this.cbP().hBH.Fm().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", a.this.cbP().hBH.Fm().mLiveInfo.room_id + "", a.this.cbP().hBH.Fm().mLiveInfo.feed_id, a.this.Lo());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.cbP().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (a.this.cbP() != null) {
                        ab abVar = null;
                        if (a.this.cbP().hBH != null) {
                            abVar = a.this.cbP().hBH.Fm();
                        }
                        if (abVar != null && abVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.u.b.ckE().bvg != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.u.b.ckE().bvg.aHq;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + abVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + abVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(a.this.cbP().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17) {
                    if (a.this.HZ() && a.this.cbP() != null && (bvVar = com.baidu.live.ae.a.Qj().bAS) != null && bvVar.aPM != null) {
                        String str6 = bvVar.aPM.aRA;
                        if (!TextUtils.isEmpty(str6)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                            if (a.this.cbP().hBH != null && a.this.cbP().hBH.Fm() != null) {
                                if (a.this.hrU == null) {
                                    a.this.hrU = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.cbP().pageContext.getPageActivity());
                                }
                                ab Fm2 = a.this.cbP().hBH.Fm();
                                String b2 = a.this.hrU.b(str6, Fm2.mLiveInfo.live_id, Fm2.aIz.userId, Fm2.aId.userId);
                                com.baidu.live.an.c cVar = new com.baidu.live.an.c();
                                cVar.url = b2;
                                a.this.bgE.a(cVar, new com.baidu.live.an.b() { // from class: com.baidu.tieba.ala.liveroom.c.a.15.2
                                    @Override // com.baidu.live.an.b
                                    public void onShow() {
                                        a.this.hqK.dh(false);
                                        a.this.hqK.Ub();
                                    }

                                    @Override // com.baidu.live.an.b
                                    public void onDismiss() {
                                        a.this.hqK.dh(true);
                                    }
                                });
                            }
                        }
                    }
                } else if (i == 18) {
                    if (a.this.hqN) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.hqN = !a.this.hqN;
                } else if (i == 19 && a.this.hqK != null) {
                    a.this.hqK.Ub();
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.hru = new com.baidu.tieba.ala.liveroom.guide.c(cbP().pageContext, this, false);
        this.hqS.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hqS);
        this.hqR.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hqR);
        this.hqT.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hqT);
        this.hqU.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hqU);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean isVertical() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cad() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.25
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.hqM) {
                    a.this.nK(false);
                }
            }
        }, 5000L);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void m(ab abVar) {
        super.m(abVar);
        g.cfs();
        this.hqN = false;
        if (this.hrx != null) {
            this.hrx.b(this.hrf);
        }
        if (this.hqK == null) {
            this.hqK = new com.baidu.live.tieba.e.b(cbP().pageContext.getPageActivity());
            this.hqK.start();
        }
        this.hqK.dh(true);
        cbP().pageContext.getPageActivity().setRequestedOrientation(-1);
        cbP().hBI.setIsForceHandledTouch(false);
        cbP().hBI.setSwipeClearEnable(true);
        cbP().hBI.setOnLiveViewScrollListener(this.hqV);
        cbP().hBI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hqO.removeCallbacksAndMessages(null);
                a.this.hqL = false;
                a.this.nK(false);
                if (!a.this.hqM) {
                    a.this.cad();
                }
            }
        });
        if (this.hso != null) {
            this.hso.setVisibility(0);
        }
        cal();
        if (this.hrQ != null) {
            this.hrQ.a(abVar, this.byA);
            this.hrQ.U(this.hsp);
            this.hrQ.a(this);
        }
        cbw();
        cax();
        caX();
        caW();
        cay();
        cai();
        caC();
        caz();
        cae();
        nQ(false);
        caE();
        cbv();
        cbD();
        cbp();
        cbu();
        cau();
        cav();
        cbo();
        caw();
        cbq();
        cag();
        caF();
        nS(true);
        cbx();
        can();
        cat();
        cbH();
        cao();
        cap();
        caq();
        car();
        caj();
        caH();
        caG();
        caf();
        cbG();
        cbC();
        cak();
        c(this.grF);
        MessageManager.getInstance().registerListener(this.hqZ);
        MessageManager.getInstance().registerListener(this.hrc);
        MessageManager.getInstance().registerListener(this.hrd);
        MessageManager.getInstance().registerListener(this.hre);
        MessageManager.getInstance().registerListener(this.hrb);
        MessageManager.getInstance().registerListener(this.hra);
        MessageManager.getInstance().registerListener(this.hqX);
        MessageManager.getInstance().registerListener(this.hqY);
        caI();
        caB();
        if (this.mOrientation == 2) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(cbP().pageContext.getPageActivity());
            l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(cbP().pageContext.getPageActivity()));
        }
        if (this.hsf != null) {
            this.hsf.L(abVar);
        }
        cbs();
    }

    private void cae() {
        if (this.hsf == null) {
            View view = null;
            if (this.hrx != null && this.hrx.getView() != null) {
                view = this.hrx.getView();
            }
            this.hsf = new com.baidu.tieba.ala.liveroom.exclusive.b(cbP().pageContext, MZ(), cbP().hBI, view, this.hqt.htX, this);
        }
    }

    private void caf() {
        if (this.hse != null) {
            this.hse.a(new com.baidu.live.y.c() { // from class: com.baidu.tieba.ala.liveroom.c.a.27
                @Override // com.baidu.live.y.c
                public void cP(boolean z) {
                    if (a.this.hqC != null) {
                        a.this.hqC.setNeedCloseRecommendFloat(z);
                    }
                    if (a.this.cbP().hBI.hRw) {
                        if (a.this.hrA != null) {
                            a.this.hrA.oK(z);
                            a.this.hrA.oS(!z);
                        }
                        if (a.this.hrx != null) {
                            a.this.hrx.oK(z);
                            a.this.hrx.setPraiseEnable(!z);
                            a.this.hrx.oJ(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nK(boolean z) {
        View Fl;
        if (cbP() != null && cbP().pageContext != null && cbP().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(cbP().pageContext.getPageActivity()) == 2 || z) {
                if (this.hrI != null && (Fl = this.hrI.Fl()) != null) {
                    if (this.hqM) {
                        Fl.setVisibility(0);
                    } else {
                        Fl.setVisibility(8);
                    }
                }
                if (this.hqM) {
                    if (this.hso != null) {
                        this.hso.setVisibility(0);
                    }
                    if (this.hsp != null) {
                        this.hsp.setVisibility(0);
                    }
                    if (this.byA != null) {
                        this.byA.setVisibility(0);
                    }
                    if (this.byA != null) {
                        this.byA.setVisibility(0);
                    }
                    if (this.hrH != null) {
                        this.hrH.bB(false);
                    }
                } else {
                    if (this.hso != null) {
                        this.hso.setVisibility(8);
                    }
                    if (this.hsp != null) {
                        this.hsp.setVisibility(8);
                    }
                    if (this.byA != null) {
                        this.byA.setVisibility(8);
                    }
                    if (this.byA != null) {
                        this.byA.setVisibility(8);
                    }
                    if (this.hrH != null) {
                        this.hrH.bB(true);
                    }
                }
                this.hqM = this.hqM ? false : true;
                if (this.hqz != null) {
                    this.hqz.nJ(this.hqM);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, boolean z2) {
        ImageView imageView;
        View EJ;
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view;
        }
        if (z) {
            if (imageView != null) {
                imageView.setImageResource(a.e.icon_live_barrage_off);
            }
            if (this.hqI != null) {
                this.hqI.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.e.icon_live_barrage_on);
            }
            if (this.hqI != null) {
                this.hqI.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.hrH != null && (EJ = this.hrH.EJ()) != null) {
            if (z) {
                EJ.setVisibility(8);
            } else {
                EJ.setVisibility(0);
            }
        }
    }

    private void cag() {
        CustomResponsedMessage runTask;
        if (this.hqE == null && (runTask = MessageManager.getInstance().runTask(2913164, com.baidu.live.im.b.a.class, cbP().pageContext)) != null) {
            this.hqE = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hqE != null) {
            this.hqE.setOtherParams(this.otherParams);
            this.hqE.a(new a.InterfaceC0179a() { // from class: com.baidu.tieba.ala.liveroom.c.a.2
                @Override // com.baidu.live.im.b.a.InterfaceC0179a
                public void KM() {
                    a.this.cbA();
                }
            });
        }
    }

    private void cah() {
        if (this.hrz != null) {
            this.hrz.aJ(cbP().hBG.getLiveContainerView());
        }
    }

    private void cai() {
        if (this.hqF == null) {
            this.hqF = new com.baidu.tieba.ala.liveroom.share.b(cbP().pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void caj() {
        if (cbP() != null) {
            if (this.hqG == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.ad.a.class, cbP().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hqG = (com.baidu.live.ad.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hqG.setIsHost(false);
            this.hqG.a(this.byA, cbP().hBH.Fm().aJc);
        }
    }

    private void cak() {
        if (cbP() != null) {
            if (this.hsa == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913271, com.baidu.live.a.a.class, cbP().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hsa = (com.baidu.live.a.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hsa.setIsHorizontal(true);
            this.hsa.setIsHost(false);
            this.hsa.a(caN(), cbP().hBH.Fm());
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cv(int i) {
        super.cv(i);
        if (this.hqJ != null && UtilHelper.getRealScreenOrientation(cbP().pageContext.getPageActivity()) != 2) {
            this.hqJ.setVisibility(0);
        }
        cah();
        if (this.hqC != null) {
            this.hqC.cv(i);
        }
        if (this.hqC == null || !this.hqC.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
        if (this.hsf != null) {
            this.hsf.ceQ();
        }
    }

    private void cal() {
        if (this.byA == null) {
            PendantParentView.Model model = PendantParentView.Model.HORIZONTAL;
            if (this.mOrientation == 2) {
                model = PendantParentView.Model.HORIZONTAL_FULL;
            }
            this.byA = new PendantParentView(cbP().pageContext.getPageActivity(), model);
            cbP().hBI.addView(this.byA, ((cbP().hBI.getView() == null || this.hrx == null || this.hrx.getView() == null) ? -1 : cbP().hBI.getView().indexOfChild(this.hrx.getView())) + 1, new RelativeLayout.LayoutParams(-1, cam()));
            this.byA.setDefaultItemMargin(cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            K(this.mOrientation, false);
        }
    }

    private int cam() {
        int bottom;
        int bottom2;
        if (cbP().brO.getLivePlayer().getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) cbP().brO.getLivePlayer().getLayoutParams();
            bottom = layoutParams.topMargin + layoutParams.height;
        } else {
            bottom = cbP().brO.getLivePlayer().getBottom();
        }
        if (cbP().hBI.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) cbP().hBI.getLayoutParams();
            bottom2 = layoutParams2.topMargin + layoutParams2.height;
        } else {
            bottom2 = cbP().hBI.getBottom();
        }
        int i = 0;
        if (this.hsf != null) {
            i = this.hsf.getHeight();
        }
        return (((bottom2 - bottom) - i) - cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
    }

    private void can() {
        if (this.hqz == null) {
            this.hqz = new com.baidu.tieba.ala.liveroom.activeview.b(cbP().pageContext);
        }
        if (cbP() != null && cbP().hBH != null) {
            this.hqz.Ht(cbP().hBH.cjK());
        }
        this.hqz.setOtherParams(Lo());
        this.hqz.c(cbP().hBH.Fm(), true);
        this.hqz.setHost(false);
        this.hqz.a(1, this.byA);
        this.hqz.a(2, this.byA);
        this.hqz.setVisible(this.hss ? 8 : 0);
    }

    private void cao() {
        if (this.byA != null) {
            if (this.hqy == null) {
                this.hqy = new com.baidu.tieba.ala.liveroom.k.a(cbP().pageContext, this);
            }
            this.hqy.setOtherParams(Lo());
            this.hqy.a((ViewGroup) this.byA, cas());
            this.hqy.M(cbP().hBH.Fm());
        }
    }

    private void cap() {
        if (this.hrS == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, j.class, cbP().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hrS = (j) runTask.getData();
            } else {
                return;
            }
        }
        this.hrS.setOtherParams(Lo());
        if (this.hqH != null && this.hqH.indexOfChild(this.hrS.getView()) >= 0) {
            this.hqH.removeView(this.hrS.getView());
        }
    }

    private void caq() {
        if (this.hrp != null) {
            this.hrp.a(new a.InterfaceC0671a() { // from class: com.baidu.tieba.ala.liveroom.c.a.11
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0671a
                public void bP(int i, int i2) {
                    ab Fm = a.this.cbP().hBH.Fm();
                    if (Fm != null && Fm.mLiveInfo != null) {
                        if (a.this.hrU == null) {
                            a.this.hrU = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.cbP().pageContext.getPageActivity());
                        }
                        a.this.hrU.d(a.this.hsp, i, i2);
                        a.this.hrU.a(String.valueOf(Fm.mLiveInfo.live_id), new a.InterfaceC0675a() { // from class: com.baidu.tieba.ala.liveroom.c.a.11.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0675a
                            public void a(float f, String str) {
                                if (a.this.hrp != null) {
                                    a.this.hrp.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0671a
                public void bQ(int i, int i2) {
                    if (a.this.hrU != null) {
                        a.this.hrU.bV(i, i2);
                    }
                }
            });
        }
    }

    private void car() {
        if (this.hsE == null) {
            this.hsE = new com.baidu.tieba.ala.liveroom.i.e(cbP().pageContext);
        }
        this.hsE.setRoomId(cbP().hBH.Fm().mLiveInfo.room_id);
        this.hsE.HO("");
        this.hsE.b(cbP().hBH.Fm(), this.byA);
        if (this.hqQ == null) {
            this.hqQ = new com.baidu.tieba.ala.liveroom.i.b(cbP().pageContext, Lo(), this.hsE, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.13
                @Override // com.baidu.tieba.ala.liveroom.i.b.a
                public void caQ() {
                    a.this.nP(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.i.b.a
                public void caR() {
                    a.this.nP(false);
                }
            });
        }
        this.hqQ.setRoomId(cbP().hBH.Fm().mLiveInfo.room_id);
        if (this.hqH != null && this.hqH.indexOfChild(this.hqQ.getView()) >= 0) {
            this.hqH.removeView(this.hqQ.getView());
        }
        if (this.hqQ != null) {
            this.hqQ.b(cbP());
        }
    }

    private LinearLayout.LayoutParams cas() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = cbP().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cat() {
        if (this.hrp == null) {
            caz();
        }
        this.hrp.a(com.baidu.live.ae.e.Qz().bBd, cbP().hBH.Fm());
    }

    private void cau() {
        CustomResponsedMessage runTask;
        boolean z = true;
        if (this.hrF == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, cbP().pageContext)) != null && runTask.getData() != null) {
            this.hrF = (k) runTask.getData();
            this.hrF.setFromMaster(false);
            this.hrF.Kd().getView().setId(a.f.ala_liveroom_msg_list);
            this.hrF.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.14
                @Override // com.baidu.live.im.k.a
                public boolean Kh() {
                    return a.this.HZ();
                }

                @Override // com.baidu.live.im.k.a
                public void Ki() {
                    a.this.hsw = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hb(String str) {
                    if (!a.this.hss) {
                        a.this.nN(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.cbP().pageContext.getPageActivity(), a.this.cbP().hBG.getLiveContainerView());
                    }
                    a.this.HA(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Kj() {
                    if (a.this.hss) {
                        a.this.nN(true);
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.cbP().pageContext.getPageActivity(), a.this.cbP().hBG.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (a.this.hrF != null) {
                        a.this.hrF.Ke().setQuickInputPanelVisible(false);
                        a.this.hrF.Ke().LZ();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Kk() {
                }

                @Override // com.baidu.live.im.k.a
                public void Kl() {
                    if (a.this.hss) {
                        a.this.caP();
                        if (a.this.hrG != null) {
                            a.this.hrG.zQ();
                        }
                        if (a.this.hqE != null) {
                            a.this.hqE.zQ();
                        }
                    } else if (a.this.hrF != null) {
                        a.this.hrF.Ke().setQuickInputPanelVisible(false);
                        a.this.hrF.Ke().LZ();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Km() {
                    return a.this.cbc();
                }

                @Override // com.baidu.live.im.k.a
                public int Kn() {
                    return a.this.cbd();
                }

                @Override // com.baidu.live.im.k.a
                public boolean Ko() {
                    ab Fm = a.this.cbP().hBH.Fm();
                    if (Fm == null || Fm.aIz == null) {
                        return false;
                    }
                    return Fm.aIz.isMysteriousMan;
                }
            });
            this.hqH = new FrameLayout(cbP().pageContext.getPageActivity());
            this.hqH.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.hrF != null && this.hqH != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(cbP().pageContext.getPageActivity()) * 0.7f);
            int j = com.baidu.live.aj.c.j(true, false);
            if (this.hsp.indexOfChild(this.hqH) < 0) {
                if (this.hqH.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hqH.getParent()).removeView(this.hqH);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, j);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
                this.hsp.addView(this.hqH, layoutParams);
            }
            if (this.hqH.indexOfChild(this.hrF.Kd().getView()) < 0) {
                if (this.hrF.Kd().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hrF.Kd().getView()).removeView(this.hrF.Kd().getView());
                }
                if (UtilHelper.getRealScreenOrientation(cbP().pageContext.getPageActivity()) != 2) {
                    this.hqH.addView(this.hrF.Kd().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, j));
                }
            }
            if (cbP().hBI.indexOfChild(this.hrF.Ke().getView()) < 0) {
                if (this.hrF.Ke().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hrF.Ke().getView().getParent()).removeView(this.hrF.Ke().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                cbj();
                cbP().hBI.addView(this.hrF.Ke().getView(), layoutParams2);
            }
            ab Fm = cbP().hBH.Fm();
            if (Fm != null && Fm.mLiveInfo != null) {
                this.hrF.setLogData(Fm.mLiveInfo.feed_id, Lo());
            }
            if (Fm == null || Fm.aIR == null || !Fm.aIR.Bf()) {
                z = false;
            }
            this.hrF.a(String.valueOf(cbP().hBH.Fm().mLiveInfo.group_id), String.valueOf(cbP().hBH.Fm().mLiveInfo.last_msg_id), String.valueOf(cbP().hBH.Fm().aId.userId), String.valueOf(cbP().hBH.Fm().mLiveInfo.live_id), cbP().hBH.Fm().aId.appId, z, cbP().hBH.Fm().getGuardName());
            nN(false);
        }
    }

    private void cav() {
        cbh();
    }

    private void caw() {
        if (this.hqI == null) {
            this.hqI = new FrameLayout(cbP().pageContext.getPageActivity());
            this.hqI.setId(a.f.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void cax() {
        if (this.hqu == null) {
            this.hqu = new com.baidu.tieba.ala.liveroom.m.a(cbP().pageContext, false, this);
        }
        this.hqu.e(this.hso, cbP().hBH.Fm());
        this.hqu.a(this.hqW);
        this.hqu.a(this.hrf);
    }

    private void cay() {
        if (this.hqt == null) {
            this.hqt = new com.baidu.tieba.ala.liveroom.audiencelist.c(cbP().pageContext, this, false);
        }
        this.hqt.a(String.valueOf(cbP().hBH.Fm().mLiveInfo.group_id), String.valueOf(cbP().hBH.Fm().mLiveInfo.live_id), String.valueOf(cbP().hBH.Fm().aId.userId), cbP().hBH.Fm());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.f.ala_liveroom_hostheader;
            if (this.hrq != null && this.hrq.getView() != null && this.hrq.getView().getParent() != null) {
                i = a.f.ala_liveroom_guardthrone;
            }
            this.hqt.c(this.hso, i, a.f.ala_liveroom_audience_count_layout);
            this.hqt.e(cbP().hBH.bTR());
        }
    }

    private void caz() {
        com.baidu.live.core.a.a Mq;
        if (this.hrp == null) {
            this.hrp = new com.baidu.tieba.ala.liveroom.operation.a(cbP().pageContext);
        }
        this.hrp.a(cbP(), this.hsp, cbP().hBH.Fm().mLiveInfo, true, this.hrf);
        this.hrp.setOtherParams(Lo());
        if (this.hrQ != null && (Mq = this.hrQ.Mq()) != null) {
            View rootLayout = Mq.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.hrp.cu(rootLayout);
        }
        this.hrp.S(cbP().hBH.Fm());
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void caA() {
        caB();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void nL(boolean z) {
    }

    private void caB() {
        if (this.hrp != null) {
            int i = cbP().hBH.Fm().aIz.isUegBlock;
            int i2 = cbP().hBH.Fm().aIz.isBlock;
            String str = cbP().hBH.Fm().aIz.userName;
            if (i > 0 || i2 > 0) {
                this.hrp.b(true, i, i2, str);
                this.hrF.a(true, i, i2, str);
                this.hrL.b(true, i, i2, str);
                return;
            }
            this.hrp.b(false, i, i2, str);
            this.hrF.a(false, i, i2, str);
            this.hrL.b(false, i, i2, str);
        }
    }

    private void caC() {
        if (this.hqx == null) {
            this.hqx = new com.baidu.tieba.ala.liveroom.audiencelist.b(cbP().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (cbP().hBH.bTR() != null) {
            j = cbP().hBH.bTR().getCount();
        }
        this.hqx.a(this.hrf);
        this.hqx.a(this.hso, a.f.ala_liveroom_hostheader, j);
        this.hqx.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.hqx.nZ(false);
        } else {
            this.hqx.nZ(true);
        }
    }

    public void caD() {
        this.hrs.d(cbP().hBH.Fm(), false);
    }

    public void caE() {
        if (cbP().hBH.Fm() != null && cbP().hBH.Fm().aId != null && cbP().hBH.Fm().mLiveInfo != null) {
            if (this.hqw == null) {
                this.hqw = new com.baidu.tieba.ala.liveroom.t.b(cbP().pageContext);
            }
            long j = cbP().hBH.Fm().aId.userId;
            int i = cbP().hBH.Fm().mLiveInfo.live_type;
            String str = cbP().hBH.Fm().aId.portrait;
            String str2 = cbP().hBH.Fm().mLiveInfo.feed_id;
            long j2 = cbP().hBH.Fm().mLiveInfo.live_id;
            this.hqw.a(i, j, cbP().hBH.Fm().aId.userName, false, str, Lo(), str2, j2);
            this.hqw.aF(this.hso);
        }
    }

    private void caF() {
        boolean z = false;
        if (this.hrA == null) {
            this.hrA = new com.baidu.tieba.ala.liveroom.v.a(cbP().pageContext, this);
        }
        this.hrA.c(cbP().hBI, false);
        boolean cbO = cbO();
        AlaLiveInfoData alaLiveInfoData = cbP().hBH.Fm().mLiveInfo;
        boolean isZanAnimUnabled = (alaLiveInfoData == null || alaLiveInfoData.mAlaLiveSwitchData == null) ? false : alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled();
        if (cbO && !isZanAnimUnabled) {
            z = true;
        }
        this.hrA.oR(z);
    }

    private void caG() {
        if (cbP() != null && cbP().brO != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(cbP().pageContext.getPageActivity());
            Activity pageActivity = cbP().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + p.br(pageActivity)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.hqJ = new ImageView(cbP().pageContext.getPageActivity());
            this.hqJ.setVisibility(8);
            this.hqJ.setBackgroundResource(a.e.sdk_round_btn_close_bg);
            this.hqJ.setImageResource(a.e.icon_live_enlarge);
            this.hqJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hqK != null) {
                        a.this.hqK.Ua();
                        a.this.hqJ.setVisibility(4);
                        a.this.hrF.Kf().cw(false);
                    }
                }
            });
            cbP().hBI.addView(this.hqJ, layoutParams);
            if (UtilHelper.getRealScreenOrientation(cbP().pageContext.getPageActivity()) != 2) {
                if (cbP().hBO) {
                    this.hqJ.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.17
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.hqJ != null && UtilHelper.getRealScreenOrientation(a.this.cbP().pageContext.getPageActivity()) != 2) {
                                a.this.hqJ.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
        }
    }

    private void caH() {
        if (this.hsn == null) {
            this.hsn = new com.baidu.tieba.ala.liveroom.apppromotion.a(cbP().pageContext);
        }
        this.hsn.b(caN(), cbP().hBH.Fm());
    }

    private void caI() {
        if (this.hsw || this.hsx) {
            if ((TbadkCoreApplication.isLogin() && this.hrF.Ke().hasText()) || this.hsx) {
                this.hsw = false;
                this.hsx = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.18
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cbg();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void t(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        super.t(bVar);
        if (this.hqz != null) {
            this.hqz.N(bVar);
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
        if (this.hqG == null || !this.hqG.Z(jSONObject)) {
            if ((bVar.getMsgType() == 12 || bVar.getMsgType() == 13) && jSONObject != null) {
                String optString = jSONObject.optString("content_type");
                if ("task".equals(optString)) {
                    if (this.hqy != null) {
                        this.hqy.Q(jSONObject);
                    }
                } else if ("enter_live".equals(optString)) {
                    if (this.hqx != null && this.hqx.getCount() > 20) {
                        this.hqx.ff(this.hqx.getCount() + 1);
                    } else if (this.hqt != null) {
                        com.baidu.live.data.a KZ = bVar.KZ();
                        u uVar = new u();
                        uVar.aIe = new AlaLocationData();
                        uVar.aIf = new AlaRelationData();
                        uVar.aId = new AlaLiveUserInfoData();
                        uVar.aId.userId = JavaTypesHelper.toLong(KZ.userId, 0L);
                        uVar.aId.userName = KZ.userName;
                        uVar.aId.portrait = KZ.portrait;
                        if (this.hqx != null && this.hqt.c(uVar)) {
                            this.hqx.ff(this.hqx.getCount() + 1);
                        }
                    }
                } else if ("update_liveinfo".equals(optString)) {
                    if (cbP().hBH.Fm() != null && cbP().hBH.Fm().mLiveInfo != null) {
                        cbP().hBH.a(cbP().hBH.Fm().mLiveInfo.live_id, cbP().fromType, cbP().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && cbP().hBH.Fm() != null && cbP().hBH.Fm().mLiveInfo != null && cbP().hBH.Fm().aIz != null && this.hqC != null) {
                    long optLong = jSONObject.optLong("mvp_user_id");
                    long optLong2 = jSONObject.optLong("winner_live_id");
                    if (optLong == cbP().hBH.Fm().aIz.userId && optLong2 == cbP().hBH.Fm().mLiveInfo.live_id) {
                        this.hqC.g(jSONObject.optInt("challenge_status"), jSONObject.optLong("challenge_id"));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void Hv(String str) {
        if (this.hqz != null) {
            this.hqz.Hv(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(ab abVar) {
        super.k(abVar);
        if (this.hqu != null) {
            this.hqu.N(abVar);
        }
        if (this.hqv != null) {
            this.hqv.J(abVar);
        }
        if (this.hqy != null) {
            this.hqy.M(abVar);
        }
        if (this.hqC != null) {
            this.hqC.a(abVar);
        }
        if (this.hqE != null) {
            this.hqE.a(abVar);
        }
        if (this.hqz != null) {
            this.hqz.j(abVar);
            if (abVar != null && this.hsg != null && !this.hsg.hasInit && !TextUtils.isEmpty(this.hsg.aQj)) {
                this.hsg.hasInit = true;
                this.hqz.Hw(this.hsg.aQj);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(v vVar) {
        if (vVar != null) {
            if (this.hqt != null && vVar.getList() != null) {
                this.hqt.e(vVar);
            }
            if (this.hqx != null) {
                this.hqx.ff(vVar.getCount());
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void cH(boolean z) {
        super.cH(z);
        if (cbP().hBI != null) {
            cbP().hBI.clq();
            cbP().hBI.setLiveViewOnDispatchTouchEventListener(null);
            cbP().hBI.setLiveViewOnTouchEventListener(null);
            cbP().hBI.setOnLiveViewScrollListener(null);
        }
        if (cbP().brO != null) {
            cbP().brO.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
        }
        if (this.hqC != null) {
            this.hqC.Ar();
        }
        caJ();
        if (this.hqw != null) {
            this.hqw.Ar();
        }
        if (this.hrA != null) {
            this.hrA.release();
        }
        if (this.hqy != null) {
            this.hqy.Ar();
        }
        if (this.hqG != null) {
            this.hqG.xh();
        }
        if (this.hrp != null) {
            this.hrp.cjW();
        }
        if (this.hqv != null) {
            this.hqv.cet();
            this.hqv.setVisible(8);
        }
        if (this.hqA != null) {
            this.hqA.Ar();
        }
        if (this.hqz != null) {
            this.hqz.release();
        }
        if (this.byA != null) {
            this.byA.removeAllViews();
            this.byA = null;
        }
        if (this.hqB != null) {
            this.hqB.Ar();
        }
        if (this.hqE != null) {
            this.hqE.a((a.InterfaceC0179a) null);
            this.hqE.zR();
        }
        if (this.hqu != null) {
            this.hqu.cgq();
        }
        if (this.hqJ != null && (this.hqJ.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hqJ.getParent()).removeView(this.hqJ);
        }
        if (this.hqF != null) {
            this.hqF.dismiss();
        }
        if (this.hqK != null) {
            this.hqK.dh(false);
            this.hqK.Ub();
        }
        if (this.hqQ != null) {
            this.hqQ.Ar();
        }
        if (this.hsE != null) {
            this.hsE.cdn();
        }
        if (this.hsi != null) {
            this.hsi.Ar();
        }
        if (this.hsn != null) {
            this.hsn.xh();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void n(ab abVar) {
        View zP;
        super.n(abVar);
        if (this.hqE != null && (zP = this.hqE.zP()) != null && zP.getParent() != null) {
            ((ViewGroup) zP.getParent()).removeView(zP);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.hqE != null) {
            this.hqE.setOtherParams(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cF(boolean z) {
        super.cF(z);
        this.hqO.removeCallbacksAndMessages(null);
        caJ();
        this.hqM = false;
        this.hqN = false;
        if (this.hqu != null) {
            this.hqu.onDestroy();
        }
        if (this.hqw != null) {
            this.hqw.onDestroy();
        }
        if (this.hqy != null) {
            this.hqy.onDestroy();
        }
        if (this.hqA != null) {
            this.hqA.onDestroy();
        }
        if (this.hqB != null) {
            this.hqB.onDestroy();
        }
        if (this.hqC != null) {
            this.hqC.onDestroy();
        }
        if (this.hqD != null) {
            this.hqD.onDestroy();
        }
        if (this.hqF != null) {
            this.hqF.onDestroy();
        }
        if (this.hqv != null) {
            this.hqv.onDestroy();
        }
        if (this.hqK != null) {
            this.hqK.stop();
        }
        if (this.hrA != null) {
            this.hrA.onDestroy();
        }
        if (this.hqt != null) {
            this.hqt.onDestroy();
        }
        if (this.hrF != null) {
            this.hrF.onDestroy();
        }
        if (this.hrp != null) {
            this.hrp.onDestory();
        }
        if (this.hqE != null) {
            this.hqE.a((a.InterfaceC0179a) null);
            this.hqE.release();
            this.hqE = null;
        }
        if (this.hsE != null) {
            this.hsE.cF(z ? false : true);
        }
        if (this.hqQ != null) {
            this.hqQ.onDestroy();
            this.hqQ = null;
        }
        if (this.hsi != null) {
            this.hsi.onDestroy();
        }
        if (this.hqG != null) {
            this.hqG.onDestroy();
        }
        if (this.hsn != null) {
            this.hsn.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.hqS);
        MessageManager.getInstance().removeMessageRule(this.hqR);
        MessageManager.getInstance().removeMessageRule(this.hqT);
        MessageManager.getInstance().removeMessageRule(this.hqU);
        MessageManager.getInstance().unRegisterListener(this.hqZ);
        MessageManager.getInstance().unRegisterListener(this.hrc);
        MessageManager.getInstance().unRegisterListener(this.hrd);
        MessageManager.getInstance().unRegisterListener(this.hre);
        MessageManager.getInstance().unRegisterListener(this.hrb);
        MessageManager.getInstance().unRegisterListener(this.hra);
        MessageManager.getInstance().unRegisterListener(this.hqX);
        MessageManager.getInstance().unRegisterListener(this.hqY);
    }

    private void caJ() {
        if (this.hrF != null && this.hrF.Kd().getView() != null && this.hrF.Kd().getView().getParent() != null) {
            ((ViewGroup) this.hrF.Kd().getView().getParent()).removeView(this.hrF.Kd().getView());
        }
        if (this.hqH != null && this.hqH.getParent() != null) {
            ((ViewGroup) this.hqH.getParent()).removeView(this.hqH);
        }
        if (this.hqI != null && this.hqI.getParent() != null) {
            ((ViewGroup) this.hqI.getParent()).removeView(this.hqI);
        }
        if (this.hrF != null && this.hrF.Ke().getView() != null) {
            this.hsp.removeView(this.hrF.Ke().getView());
        }
        if (this.hrF != null) {
            this.hrF.Kd().setMsgData(new LinkedList());
            this.hrF.zR();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void a(ax axVar) {
        if (this.hrF != null) {
            cbg();
            String nameShow = axVar.getNameShow();
            if (axVar.extInfoJson != null) {
                if (axVar.extInfoJson.optInt("is_mysterious_man") == 1) {
                    nameShow = axVar.extInfoJson.optString("mysterious_man_nickname");
                    if (TextUtils.isEmpty(nameShow)) {
                        nameShow = "神秘人";
                    }
                }
            }
            this.hrF.Ke().setEditText(" @" + nameShow + " ");
        }
        if (this.hrp != null) {
            this.hrp.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void g(com.baidu.live.data.a aVar) {
        if (this.hrF != null) {
            cbg();
            String nameShow = aVar.getNameShow();
            if (aVar.extInfoJson != null) {
                if (aVar.extInfoJson.optInt("is_mysterious_man") == 1) {
                    nameShow = aVar.extInfoJson.optString("mysterious_man_nickname");
                    if (TextUtils.isEmpty(nameShow)) {
                        nameShow = "神秘人";
                    }
                }
            }
            this.hrF.Ke().setEditText(" @" + nameShow + " ");
        }
        if (this.hrp != null) {
            this.hrp.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void Hy(String str) {
        if (this.hrF != null) {
            cbg();
            StringBuilder sb = new StringBuilder();
            sb.append(" @");
            sb.append(str);
            sb.append(" ");
            if (com.baidu.live.ae.a.Qj().buX.aME != null && com.baidu.live.ae.a.Qj().buX.aME.originTexts != null && com.baidu.live.ae.a.Qj().buX.aME.originTexts.size() > 0) {
                this.hrF.Ke().Ma();
                this.hrF.Ke().setEditText(sb.toString() + com.baidu.live.ae.a.Qj().buX.aME.originTexts.get(0));
            } else {
                this.hrF.Ke().setEditText(sb.toString());
            }
        }
        if (this.hrp != null) {
            this.hrp.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void b(ax axVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected View caK() {
        if (this.hrF != null) {
            return this.hrF.Ke().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean caL() {
        if (this.hrF == null || !this.hrF.Ke().LY()) {
            return false;
        }
        nN(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean caM() {
        return this.hqu == null || this.hqu.caM();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup caN() {
        return this.byA;
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
                    this.hst = false;
                    P(intExtra, intExtra2, intExtra3);
                    return;
                }
                caD();
                return;
            }
            awo();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.hss;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(cbP().pageContext.getPageActivity()) || z2) {
            nM(z);
        }
    }

    private void nM(boolean z) {
        if (this.hrF != null && this.hrF.Kd() != null) {
            this.hrF.Kd().onKeyboardVisibilityChanged(z);
        }
        if (z || this.hrF == null || !this.hrF.Ke().LY()) {
            if (z) {
                if (this.hrp != null) {
                    this.hrp.setVisibility(8);
                }
                if (this.hrH != null && this.hrH.EJ() != null) {
                    this.hrH.EJ().setVisibility(8);
                }
                caP();
                if (this.hrF != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hrF.Ke().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.hrF.Ke().getView().setLayoutParams(layoutParams);
                    this.hrF.Ke().getView().setVisibility(0);
                    this.hrF.Ke().setQuickInputPanelVisible(false);
                    this.hrF.Kf().cw(false);
                }
                if (this.hso != null) {
                    this.hso.setVisibility(8);
                }
                if (this.hqz != null) {
                    this.hqz.setVisible(8);
                }
                if (this.hrG != null) {
                    this.hrG.zQ();
                }
                if (this.hsh != null) {
                    this.hsh.setCanVisible(false);
                }
                if (this.hrX != null) {
                    this.hrX.setCanVisible(false);
                }
                if (this.hsb != null) {
                    this.hsb.setCanVisible(false);
                }
                if (this.hsc != null) {
                    this.hsc.setVisible(8);
                }
                if (this.hsa != null) {
                    this.hsa.setCanVisible(false);
                }
                if (this.hsn != null) {
                    this.hsn.setCanVisible(false);
                }
                if (this.hsd != null) {
                    this.hsd.setCanVisible(false);
                }
            } else {
                caO();
            }
            if (this.hrF != null && this.hqH != null) {
                if (this.hsp.indexOfChild(this.hqH) != -1 && this.hqH.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hqH.getLayoutParams();
                    layoutParams2.height = com.baidu.live.aj.c.j(true, z);
                    this.hqH.setLayoutParams(layoutParams2);
                }
                if (this.hqH.indexOfChild(this.hrF.Kd().getView()) != -1 && this.hrF.Kd().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.hrF.Kd().getView().getLayoutParams();
                    layoutParams3.height = com.baidu.live.aj.c.j(true, z);
                    this.hrF.Kd().getView().setLayoutParams(layoutParams3);
                }
                this.hrF.Kd().Kc();
            }
        }
    }

    private void caO() {
        if (this.hrp != null) {
            this.hrp.setVisibility(0);
        }
        if (this.hqH != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqH.getLayoutParams();
            layoutParams.bottomMargin = cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            this.hqH.setLayoutParams(layoutParams);
        }
        if (this.hrF != null) {
            cbj();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hrF.Ke().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.hrF.Ke().getView().setLayoutParams(layoutParams2);
            if (this.aMG) {
                if (UtilHelper.getRealScreenOrientation(cbP().pageContext.getPageActivity()) != 2 && !this.hrF.Kf().isClicked()) {
                    this.hrF.Kf().cw(true);
                }
            } else {
                this.hrF.Kf().cw(false);
            }
        }
        if (this.hrp != null) {
            this.hrp.setVisibility(0);
        }
        if (this.hrH != null && this.hrH.EJ() != null) {
            this.hrH.EJ().setVisibility(0);
        }
        if (this.hso != null && (!this.hqM || UtilHelper.getRealScreenOrientation(cbP().pageContext.getPageActivity()) != 2)) {
            this.hso.setVisibility(0);
        }
        if (this.hqz != null) {
            this.hqz.setVisible(0);
        }
        if (this.hrG != null) {
            this.hrG.zQ();
        }
        if (this.hsh != null) {
            this.hsh.setCanVisible(true);
        }
        if (this.hrX != null) {
            this.hrX.setCanVisible(true);
        }
        if (this.hsb != null) {
            this.hsb.setCanVisible(true);
        }
        if (this.hsc != null) {
            this.hsc.setVisible(0);
        }
        if (this.hsa != null) {
            this.hsa.setCanVisible(true);
        }
        if (this.hsn != null) {
            this.hsn.setCanVisible(true);
        }
        if (this.hsd != null) {
            this.hsd.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caP() {
        boolean z;
        boolean z2;
        if (this.hqH != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqH.getLayoutParams();
            if (this.hrF == null || this.hrF.Ke() == null) {
                z = false;
                z2 = false;
            } else {
                boolean LW = this.hrF.Ke().LW();
                z = this.hrF.Ke().LX();
                z2 = LW;
            }
            int O = O(z2, z);
            if (layoutParams.bottomMargin != O) {
                layoutParams.bottomMargin = O;
                this.hqH.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nN(boolean z) {
        if (z) {
            this.hrF.Ke().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqH.getLayoutParams();
            int quickInputPanelExpandHeight = this.hrF.Ke().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.hqH.setLayoutParams(layoutParams);
                if (this.hrF.Kd() != null) {
                    this.hrF.Kd().Kc();
                    return;
                }
                return;
            }
            return;
        }
        caO();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        FrameLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = cbP().pageContext.getPageActivity();
        if (i3 == 1) {
            if (cbP().pageContext.getPageActivity() != null) {
                r.e(cbP().pageContext.getPageActivity(), true);
            }
            if (this.hso != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.hso.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.hqF != null) {
                this.hqF.dismiss();
            }
            if (this.hqE != null) {
                this.hqE.a((a.InterfaceC0179a) null);
                this.hqE.zR();
            }
            if (this.brL != null) {
                this.brL.e(true, true);
            }
            if (this.hqJ != null) {
                this.hqJ.setVisibility(0);
                this.hqJ.bringToFront();
            }
            if (this.hrv != null) {
                this.hrv.setVisibility(0);
            }
            if (this.hrF != null && this.hrF.Kd().getView().getParent() != null && (this.hrF.Kd().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hrF.Kd().getView().getParent()).removeView(this.hrF.Kd().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(cbP().pageContext.getPageActivity()) * 0.7f);
            int j = com.baidu.live.aj.c.j(true, false);
            if (this.hqH != null && this.hrF != null) {
                this.hqH.addView(this.hrF.Kd().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, j));
            }
            if (this.hqI != null && (this.hqI.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hqI.getParent()).removeView(this.hqI);
            }
            if (this.hrG != null) {
                this.hrG.a(cbP().hBH.Fm(), false);
                this.hrG.a(new a.InterfaceC0179a() { // from class: com.baidu.tieba.ala.liveroom.c.a.19
                    @Override // com.baidu.live.im.b.a.InterfaceC0179a
                    public void KM() {
                        a.this.cbA();
                    }
                });
                View zP = this.hrG.zP();
                if (zP != null && this.hsp != null && zP.getParent() == null) {
                    Resources resources = cbP().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(cbP().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                    layoutParams5.addRule(2, a.f.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                    this.hsp.addView(zP, layoutParams5);
                }
            }
            if (this.hrx != null) {
                this.hrx.setPraiseEnable(true);
                cbP().hBI.hRw = true;
            }
            if (this.hqt != null && this.hqt.htY != null && (layoutParams3 = (FrameLayout.LayoutParams) this.hqt.htY.getLayoutParams()) != null) {
                layoutParams3.width = -2;
                this.hqt.htY.setLayoutParams(layoutParams3);
            }
            if (this.hrA != null) {
                this.hrA.clQ();
            }
            if (this.hqM) {
                nK(true);
            }
            if (this.hqN) {
                if (this.hrp != null && this.hrp.getLandscapeBarrageImageView() != null) {
                    b(this.hrp.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.hrp != null) {
                this.hrp.wa(0);
            }
            if (this.hqx != null) {
                this.hqx.nY(true);
            }
            this.hqO.removeCallbacksAndMessages(null);
            if (this.hqy != null) {
                this.hqy.setCanVisible(true);
                this.hqy.M(cbP().hBH.Fm());
            }
            if (this.hqG != null) {
                this.hqG.cT(true);
            }
            if (this.hrF != null) {
                if (this.aMG) {
                    if (!this.hrF.Kf().isClicked()) {
                        this.hrF.Kf().cw(true);
                    }
                } else {
                    this.hrF.Kf().cw(false);
                }
            }
        } else if (i3 == 2) {
            if (cbP().pageContext.getPageActivity() != null) {
                r.e(cbP().pageContext.getPageActivity(), false);
            }
            if (this.hrA != null) {
                this.hrA.clR();
            }
            if (this.hso != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.hso.getLayoutParams()) != null) {
                layoutParams2.topMargin = cbP().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
            }
            if (this.hrG != null) {
                this.hrG.a((a.InterfaceC0179a) null);
                this.hrG.zR();
            }
            cbP().hBI.cls();
            if (this.brL != null) {
                this.brL.e(false, true);
            }
            if (this.hqJ != null) {
                this.hqJ.setVisibility(4);
            }
            if (this.hrF != null && this.hrF.Kd().getView().getParent() != null && (this.hrF.Kd().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hrF.Kd().getView().getParent()).removeView(this.hrF.Kd().getView());
                this.hrF.Kf().cw(false);
            }
            int max = Math.max(i, i2);
            if (this.hqI != null) {
                if (this.hqI.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hqI.getParent()).removeView(this.hqI);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100);
                cbP().hBI.addView(this.hqI, this.byA != null ? cbP().hBI.indexOfChild(this.byA) : -1, layoutParams6);
            }
            if (this.hqI != null && this.hqE != null) {
                this.hqE.a(cbP().hBH.Fm(), false);
                this.hqE.a(new a.InterfaceC0179a() { // from class: com.baidu.tieba.ala.liveroom.c.a.20
                    @Override // com.baidu.live.im.b.a.InterfaceC0179a
                    public void KM() {
                        a.this.cbA();
                    }
                });
                View zP2 = this.hqE.zP();
                if (zP2 != null && this.hqI.indexOfChild(zP2) < 0) {
                    this.hqI.addView(zP2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(cbP().pageContext.getPageActivity()), -1));
                }
            }
            if (this.hrx != null) {
                this.hrx.aM(cbP().hBI);
                this.hrx.setPraiseEnable(false);
                cbP().hBI.hRw = false;
            }
            if (this.hqt != null && this.hqt.htY != null && (layoutParams = (FrameLayout.LayoutParams) this.hqt.htY.getLayoutParams()) != null) {
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                layoutParams.width = (int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f);
                this.hqt.htY.setLayoutParams(layoutParams);
            }
            if (this.hrp != null) {
                this.hrp.wa(8);
            }
            if (this.hqx != null) {
                this.hqx.nY(false);
            }
            if (al.FB() != null) {
                al.FB().FA();
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.ag.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.ag.c) runTask.getData()).FA();
            }
            if (this.hrp != null && this.hrp.getLandscapeBarrageImageView() != null) {
                b(this.hrp.getLandscapeBarrageImageView(), this.hqN, false);
            }
            cad();
            if (this.hrH != null) {
                this.hrH.EL();
            }
            if (this.hqy != null) {
                this.hqy.setCanVisible(false);
                this.hqy.cfw();
            }
            if (this.hqG != null) {
                this.hqG.setCanVisible(false);
            }
        }
        if (this.hsb != null) {
            this.hsb.cK(i3);
        }
        if (this.hrO != null) {
            this.hrO.cK(i3);
        }
        if (this.hrI != null) {
            this.hrI.cK(i3);
        }
        if (this.hrF != null) {
            this.hrF.Kf().cK(i3);
        }
        if (this.hrp != null) {
            this.hrp.l(i, i2, i3);
        }
        K(i3, true);
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.hqt != null) {
                this.hqt.cr(i3);
            }
            if (this.hqv != null) {
                this.hqv.cr(i3);
            }
            if (this.hqz != null) {
                this.hqz.cr(i3);
            }
            if (this.hrQ != null) {
                this.hrQ.cr(i3);
            }
            if (this.hrL != null) {
                this.hrL.cr(i3);
            }
            if (this.bgE != null) {
                this.bgE.cr(i3);
            }
            if (this.hqP != null && this.hqP.isShowing()) {
                this.hqP.resize();
            }
            if (this.hsh != null) {
                this.hsh.cr(i3);
            }
            if (this.hsi != null) {
                this.hsi.cr(i3);
            }
            if (this.hsf != null) {
                this.hsf.cK(i3);
            }
            if (this.hsl != null) {
                this.hsl.cr(i3);
            }
        }
        if (this.hrH != null) {
            this.hrH.EK();
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public boolean dF(int i) {
        boolean dF = super.dF(i);
        if (dF && 2 == i) {
            if (this.hqu.caM()) {
                return false;
            }
            if (dF && this.hrA != null) {
                this.hrA.oS(false);
            }
        }
        return dF;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void vo(int i) {
        super.vo(i);
        if (i == 7 || i == 11) {
            if (i != 7 || UtilHelper.getRealScreenOrientation(cbP().pageContext.getPageActivity()) != 2) {
                if (this.hrp != null) {
                    this.hrp.setVisibility(8);
                }
                if (this.hrF != null) {
                    this.hrF.Kd().getView().setVisibility(4);
                    this.hrF.Kf().cw(false);
                }
                if (this.hrU != null) {
                    this.hrU.oM(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public void dG(int i) {
        super.dG(i);
        if (i == 7 || i == 11) {
            if (this.hrp != null) {
                this.hrp.setVisibility(0);
            }
            if (this.hrF != null) {
                this.hrF.Kd().getView().setVisibility(0);
                if (this.aMG && UtilHelper.getRealScreenOrientation(cbP().pageContext.getPageActivity()) != 2 && !this.hrF.Kf().isClicked()) {
                    this.hrF.Kf().cw(true);
                }
            }
            if (this.hrU != null) {
                this.hrU.oM(true);
            }
            if (!this.hqM || UtilHelper.getRealScreenOrientation(cbP().pageContext.getPageActivity()) != 2) {
                this.hso.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.hqw != null) {
            this.hqw.ckt();
        }
        if (this.hqB != null) {
            this.hqB.AA();
        }
        if (this.hqz != null) {
            this.hqz.onStop();
        }
        if (cbP() != null) {
            BdUtilHelper.hideSoftKeyPad(cbP().pageContext.getPageActivity(), cbP().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.hqw != null) {
            this.hqw.cks();
        }
        if (this.hqB != null) {
            this.hqB.AB();
        }
        if (this.hqz != null) {
            this.hqz.onStart();
        }
        if (this.hsf != null) {
            this.hsf.onStart();
        }
        if (this.hsn != null) {
            this.hsn.onStart();
        }
    }

    private void K(int i, boolean z) {
        if (this.byA != null) {
            int dimensionPixelSize = cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.byA.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                layoutParams.rightMargin = cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6);
                layoutParams.height = cam();
                this.byA.setPosition(dimensionPixelSize, 0, dimensionPixelSize, 0);
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                int dimensionPixelSize2 = cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds72) + 0 + cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100) + cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
                layoutParams.height = -1;
                this.byA.setPosition(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
            }
            layoutParams.bottomMargin = cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds114);
            this.byA.setLayoutParams(layoutParams);
            this.byA.setModel(i == 1 ? PendantParentView.Model.HORIZONTAL : PendantParentView.Model.HORIZONTAL_FULL);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.e
    public void vp(int i) {
        K(this.mOrientation, false);
    }
}
