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
import com.baidu.live.data.ak;
import com.baidu.live.data.at;
import com.baidu.live.data.bq;
import com.baidu.live.data.ch;
import com.baidu.live.data.cn;
import com.baidu.live.data.q;
import com.baidu.live.data.r;
import com.baidu.live.data.x;
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
/* loaded from: classes10.dex */
public class a extends b implements com.baidu.live.n.c, e {
    private PendantParentView buY;
    private com.baidu.tieba.ala.liveroom.audiencelist.c hlR;
    private com.baidu.tieba.ala.liveroom.o.a hlS;
    private com.baidu.tieba.ala.liveroom.g.b hlT;
    private com.baidu.tieba.ala.liveroom.u.b hlU;
    private com.baidu.tieba.ala.liveroom.audiencelist.b hlV;
    private com.baidu.tieba.ala.liveroom.l.a hlW;
    private com.baidu.tieba.ala.liveroom.activeview.b hlX;
    private com.baidu.live.f.a hlY;
    private i hlZ;
    private h hma;
    private com.baidu.tieba.ala.liveroom.c.a hmb;
    private com.baidu.live.im.b.a hmc;
    private com.baidu.tieba.ala.liveroom.share.b hmd;
    private com.baidu.live.ae.a hme;
    private FrameLayout hmf;
    private FrameLayout hmg;
    private ImageView hmh;
    private com.baidu.live.tieba.e.b hmi;
    private ah hmn;
    private com.baidu.tieba.ala.liveroom.j.b hmo;
    private long lastClickTime = 0;
    private boolean hmj = false;
    private boolean hmk = false;
    private boolean hml = false;
    private Handler hmm = new Handler();
    private HttpRule hmp = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.hlZ != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.hlZ.zW()) {
                httpMessage.addParam("ala_challenge_id", a.this.hlZ.zZ());
            }
            return httpMessage;
        }
    };
    private HttpRule hmq = new HttpRule(1021229) { // from class: com.baidu.tieba.ala.liveroom.d.a.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.hlZ != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.hlZ.zW()) {
                httpMessage.addParam("challenge_id", a.this.hlZ.zZ());
            }
            return httpMessage;
        }
    };
    private HttpRule hmr = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.a.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.hlZ != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.hlZ.zW()) {
                httpMessage.addParam("challenge_id", a.this.hlZ.zZ());
            }
            return httpMessage;
        }
    };
    private HttpRule hms = new HttpRule(1021232) { // from class: com.baidu.tieba.ala.liveroom.d.a.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.hlZ != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.hlZ.zW()) {
                httpMessage.addParam("challenge_id", a.this.hlZ.zZ());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c hmt = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.25
        @Override // com.baidu.live.liveroom.g.c
        public void LF() {
            if (a.this.hmZ != null) {
                a.this.hmZ.oI(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cz(boolean z) {
            if (z) {
                if (a.this.hmZ != null) {
                    a.this.hmZ.oI(true);
                }
            } else if (a.this.hmZ != null) {
                a.this.hmZ.oI(false);
            }
            if (a.this.hns != null) {
                a.this.hns.by(z);
            }
            if (a.this.hlX != null) {
                a.this.hlX.ny(z ? false : true);
            }
            com.baidu.live.q.a.cA(z);
        }
    };
    private com.baidu.tieba.ala.liveroom.o.c hmu = new com.baidu.tieba.ala.liveroom.o.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.26
        @Override // com.baidu.tieba.ala.liveroom.o.c
        public void onClick() {
            a.this.hmm.removeCallbacksAndMessages(null);
            a.this.hmj = true;
        }

        @Override // com.baidu.tieba.ala.liveroom.o.c
        public void endAnimation() {
            if (a.this.hmj) {
                a.this.bZa();
            }
        }
    };
    private CustomMessageListener hmv = new CustomMessageListener(2913287) { // from class: com.baidu.tieba.ala.liveroom.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hmi != null) {
                a.this.hmi.cZ(false);
                a.this.hmi.Su();
            }
        }
    };
    private CustomMessageListener hmw = new CustomMessageListener(2913290) { // from class: com.baidu.tieba.ala.liveroom.d.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hmi != null) {
                a.this.hmi.cZ(true);
            }
        }
    };
    private HttpMessageListener hmx = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.MY() != null) {
                        com.baidu.live.af.e.OY().bxA = getQuickGiftHttpResponseMessage.MY();
                        a.this.bZq();
                    }
                }
            }
        }
    };
    private CustomMessageListener hmy = new CustomMessageListener(2913276) { // from class: com.baidu.tieba.ala.liveroom.d.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            JSONObject optJSONObject;
            JSONArray optJSONArray;
            if (a.this.mOrientation == 1 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject) && (optJSONObject = ((JSONObject) customResponsedMessage.getData()).optJSONObject("ext_data")) != null && (optJSONArray = optJSONObject.optJSONArray("surprise_prize_member")) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                View inflate = LayoutInflater.from(a.this.activity).inflate(a.g.ala_fudai_dialog_layout, (ViewGroup) null);
                final Dialog dialog = new Dialog(a.this.caO().pageContext.getPageActivity(), a.i.FudaiDialogStyle);
                dialog.requestWindowFeature(1);
                dialog.setContentView(inflate);
                dialog.setCancelable(false);
                View findViewById = inflate.findViewById(a.f.ala_fudai_negative_btn);
                View findViewById2 = inflate.findViewById(a.f.ala_fudai_positive_btn);
                TextView textView = (TextView) inflate.findViewById(a.f.ala_fudai_tbean_num);
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.7.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.7.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialog.dismiss();
                        if (TbadkCoreApplication.isLogin()) {
                            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
                            httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
                            MessageManager.getInstance().sendMessage(httpMessage);
                            ak akVar = new ak();
                            akVar.aHs = -1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, akVar));
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
    private CustomMessageListener hmz = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                a.this.hnh.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hmA = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.a.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.hnv != null) {
                    a.this.hnv.gT(str);
                }
            }
        }
    };
    CustomMessageListener hmB = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.a.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.hnW != null && a.this.hnW.bfP != null && !a.this.hnW.bfU && !a.this.hnW.bfV && a.this.hnr != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.caO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                if (a.this.hne != null && a.this.hne.IH().KN()) {
                    layoutParams.bottomMargin = a.this.caO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds88);
                } else {
                    layoutParams.bottomMargin = a.this.caO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                }
                a.this.hnr.c(a.this.hmf, layoutParams);
                if (com.baidu.live.guardclub.e.HC() != null) {
                    com.baidu.live.guardclub.e.HC().HH();
                }
            }
        }
    };
    private CustomMessageListener hmC = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (a.this.hnt != null) {
                    a.this.hnt.dismiss();
                }
                if (a.this.hnv != null) {
                    a.this.hnv.dismiss();
                }
                if (a.this.hba != null) {
                    a.this.hba.dismiss();
                }
                com.baidu.live.im.b.d.Jp().setSwitchStatus(true);
                com.baidu.live.im.b.d.Jp().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.caf();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener hmD = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.a.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.hmo.c(a.this.caO());
                } else if (a.this.bZY() || !g.vq(2913168)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.13.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.caO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.caO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    a.this.hmo.c(a.this.hmf, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b hmE = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.a.17
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void v(View view, int i) {
            bq bqVar;
            String str;
            cn cnVar;
            String str2;
            bq bqVar2;
            ch chVar;
            String str3;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - a.this.lastClickTime >= 300) {
                a.this.lastClickTime = currentTimeMillis;
                if (i == 2 && a.this.GJ()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel"));
                    a.this.P(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.af.e.OY().bxA.DC().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.af.e.OY().bxA.DC().CC());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.af.e.OY().bxA.DC().CD());
                        if (a.this.caO().hxj.DW() != null && a.this.caO().hxj.DW().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.caO().hxj.DW().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.caO().hxj.DW().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.JQ());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.GJ()) {
                        if (com.baidu.live.d.xf().getBoolean("quick_gift_guide_show", true) && !a.this.bZY()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, ah.class, a.this.caO().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                ah ahVar = (ah) runTask.getData();
                                ahVar.setPageContext(a.this.caO().pageContext);
                                ahVar.setLiveShowData(a.this.caO().hxj.DW());
                                ahVar.setGiftItem(com.baidu.live.af.e.OY().bxA.DC());
                                ahVar.setOtherParams(a.this.JQ());
                                ahVar.initView();
                                ahVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.17.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        a.this.nE(false);
                                        a.this.hmn = null;
                                    }
                                });
                                a.this.hmn = ahVar;
                                ahVar.show();
                                a.this.nE(true);
                                return;
                            }
                            return;
                        }
                        n.a(a.this.caO().pageContext, a.this.caO().hxj.DW(), com.baidu.live.af.e.OY().bxA.DC(), a.this.JQ());
                    }
                } else if (i == 1) {
                    if (a.this.hne != null) {
                        a.this.caf();
                    }
                } else if (i == 3 && a.this.GJ()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    if (a.this.mOrientation == 2 && (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                        if (a.this.hmd != null) {
                            a.this.hmd.S(a.this.caO().hxj.DW());
                        }
                    } else {
                        a.this.hmR.d(a.this.caO().hxj.DW(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.caO() != null && a.this.caO().hxj != null && a.this.caO().hxj.DW() != null && a.this.caO().hxj.DW().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.caO().hxj.DW().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.caO().hxj.DW().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.caO().hxj.DW().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.JQ());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.caO() != null && a.this.caO().hxj != null && a.this.caO().hxj.DW() != null && a.this.caO().hxj.DW().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.caO().hxj.DW().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.caO().hxj.DW().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.caO().hxj.DW().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.JQ());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.bok != null) {
                        a.this.bok.ct(false);
                    }
                } else if (i == 12) {
                    if (a.this.hmZ != null) {
                        String valueOf = String.valueOf(a.this.caO().hxj.DW().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.caO().hxj.DW().mLiveInfo.room_id);
                        String str4 = null;
                        AlaLiveSdkInfo alaLiveSdkInfo = a.this.caO().hxj.DW().mLiveSdkInfo;
                        if (alaLiveSdkInfo != null && alaLiveSdkInfo.mCastIds != null) {
                            str4 = String.valueOf(a.this.caO().hxj.DW().mLiveSdkInfo.mCastIds.chatMCastId);
                        }
                        a.this.hmZ.aw(valueOf, valueOf2, str4);
                        com.baidu.live.q.a.c(a.this.caO().hxj.DW().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    x DW = a.this.caO().hxj.DW();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.caO().pageContext.getPageActivity(), DW.aFH.userName, Long.toString(DW.aFH.userId), Long.toString(DW.aFH.charmCount), String.valueOf(DW.mLiveInfo.group_id), String.valueOf(DW.mLiveInfo.live_id), false, String.valueOf(DW.aFH.userId), Long.toString(DW.aGd.userId), DW.aGd.userName, DW.aGd.portrait, a.this.hlV.getCount(), a.this.JQ())));
                    LogManager.getCommonLogger().doClickGusetNumLog(DW.mLiveInfo.feed_id, a.this.hlV.getCount() + "", a.this.JQ());
                } else if (i == 11) {
                    a.this.cak();
                    a.this.cal();
                } else if (i == 16) {
                    if (a.this.caO() != null && (bqVar2 = com.baidu.live.af.a.OJ().bxp) != null && (chVar = bqVar2.aMO) != null) {
                        String str5 = chVar.aOr.aOB;
                        if (!TextUtils.isEmpty(str5)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (a.this.caO().hxj != null && a.this.caO().hxj.DW() != null && a.this.caO().hxj.DW().mLiveInfo != null) {
                                j = a.this.caO().hxj.DW().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", a.this.caO().hxj.DW().mLiveInfo.room_id + "", a.this.caO().hxj.DW().mLiveInfo.feed_id, a.this.JQ());
                            }
                            if (str5.contains("?")) {
                                str3 = str5 + "&liveId=" + j;
                            } else {
                                str3 = str5 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.caO().pageContext.getPageActivity(), str3);
                        }
                    }
                } else if (i == 20) {
                    if (a.this.caO() != null) {
                        x xVar = null;
                        if (a.this.caO().hxj != null) {
                            xVar = a.this.caO().hxj.DW();
                        }
                        if (xVar != null && xVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.v.b.cjy().brD != null) {
                            String str6 = com.baidu.tieba.ala.liveroom.v.b.cjy().brD.aEU;
                            if (!TextUtils.isEmpty(str6)) {
                                if (str6.contains("?")) {
                                    str2 = str6 + "&live_id=" + xVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str2 = str6 + "?live_id=" + xVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(a.this.caO().pageContext.getPageActivity(), str2)));
                            }
                        }
                    }
                } else if (i == 17) {
                    if (a.this.GJ() && a.this.caO() != null && (bqVar = com.baidu.live.af.a.OJ().bxp) != null && bqVar.aMO != null && (str = bqVar.aMO.aOy) != null && (cnVar = new cn(str)) != null && !TextUtils.isEmpty(cnVar.webUrl)) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                        if (a.this.hnt != null && a.this.caO().hxj != null && a.this.caO().hxj.DW() != null) {
                            x DW2 = a.this.caO().hxj.DW();
                            a.this.hnt.b(cnVar.webUrl, DW2.mLiveInfo.live_id, DW2.aGd.userId, DW2.aFH.userId);
                            a.this.hmi.cZ(false);
                            a.this.hmi.Su();
                        }
                    }
                } else if (i == 18) {
                    if (a.this.hml) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.hml = !a.this.hml;
                } else if (i == 19 && a.this.hmi != null) {
                    a.this.hmi.Su();
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.hmT = new com.baidu.tieba.ala.liveroom.guide.c(caO().pageContext, this, false);
        this.hmq.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hmq);
        this.hmp.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hmp);
        this.hmr.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hmr);
        this.hms.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hms);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean isVertical() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZa() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.27
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.hmk) {
                    a.this.nz(false);
                }
            }
        }, 5000L);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void m(x xVar) {
        super.m(xVar);
        g.ceq();
        this.hml = false;
        if (this.hmW != null) {
            this.hmW.b(this.hmE);
        }
        if (this.hmi == null) {
            this.hmi = new com.baidu.live.tieba.e.b(caO().pageContext.getPageActivity());
            this.hmi.start();
        }
        this.hmi.cZ(true);
        caO().pageContext.getPageActivity().setRequestedOrientation(-1);
        caO().hxk.setIsForceHandledTouch(false);
        caO().hxk.setSwipeClearEnable(true);
        caO().hxk.setOnLiveViewScrollListener(this.hmt);
        caO().hxk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hmm.removeCallbacksAndMessages(null);
                a.this.hmj = false;
                a.this.nz(false);
                if (!a.this.hmk) {
                    a.this.bZa();
                }
            }
        });
        if (this.hnP != null) {
            this.hnP.setVisibility(0);
        }
        bZi();
        if (this.hnp != null) {
            this.hnp.a(xVar, this.buY);
            this.hnp.U(this.hnQ);
            this.hnp.a(this);
        }
        cav();
        bZu();
        bZU();
        bZT();
        bZv();
        bZf();
        bZz();
        bZw();
        bZb();
        nF(false);
        bZB();
        cau();
        caC();
        cao();
        cat();
        bZr();
        bZs();
        can();
        bZt();
        cap();
        bZd();
        bZC();
        nH(true);
        caw();
        bZk();
        bZq();
        caG();
        bZl();
        bZm();
        bZn();
        bZo();
        bZg();
        bZE();
        bZD();
        bZc();
        caF();
        caB();
        bZh();
        if (this.hnt != null && this.hnt.cjI() == null) {
            this.hnt.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.29
                @Override // com.baidu.tieba.ala.liveroom.turntable.d.a
                public void onDismiss() {
                    a.this.hmi.cZ(true);
                }
            });
        }
        c(this.goI);
        MessageManager.getInstance().registerListener(this.hmx);
        MessageManager.getInstance().registerListener(this.hmB);
        MessageManager.getInstance().registerListener(this.hmC);
        MessageManager.getInstance().registerListener(this.hmD);
        MessageManager.getInstance().registerListener(this.hmA);
        MessageManager.getInstance().registerListener(this.hmz);
        MessageManager.getInstance().registerListener(this.hmy);
        MessageManager.getInstance().registerListener(this.hmv);
        MessageManager.getInstance().registerListener(this.hmw);
        bZF();
        bZy();
        if (this.mOrientation == 2) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(caO().pageContext.getPageActivity());
            l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(caO().pageContext.getPageActivity()));
        }
        if (this.hnG != null) {
            this.hnG.K(xVar);
        }
        car();
    }

    private void bZb() {
        if (this.hnG == null) {
            View view = null;
            if (this.hmW != null && this.hmW.getView() != null) {
                view = this.hmW.getView();
            }
            this.hnG = new com.baidu.tieba.ala.liveroom.exclusive.b(caO().pageContext, LB(), caO().hxk, view, this.hlR.hpy, this);
        }
    }

    private void bZc() {
        if (this.hnF != null) {
            this.hnF.a(new com.baidu.live.aa.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.2
                @Override // com.baidu.live.aa.c
                public void cG(boolean z) {
                    if (a.this.hma != null) {
                        a.this.hma.setNeedCloseRecommendFloat(z);
                    }
                    if (a.this.caO().hxk.hMO) {
                        if (a.this.hmZ != null) {
                            a.this.hmZ.oA(z);
                            a.this.hmZ.oI(!z);
                        }
                        if (a.this.hmW != null) {
                            a.this.hmW.oA(z);
                            a.this.hmW.setPraiseEnable(!z);
                            a.this.hmW.oz(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nz(boolean z) {
        View DV;
        if (caO() != null && caO().pageContext != null && caO().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(caO().pageContext.getPageActivity()) == 2 || z) {
                if (this.hnh != null && (DV = this.hnh.DV()) != null) {
                    if (this.hmk) {
                        DV.setVisibility(0);
                    } else {
                        DV.setVisibility(8);
                    }
                }
                if (this.hmk) {
                    if (this.hnP != null) {
                        this.hnP.setVisibility(0);
                    }
                    if (this.hnQ != null) {
                        this.hnQ.setVisibility(0);
                    }
                    if (this.buY != null) {
                        this.buY.setVisibility(0);
                    }
                    if (this.buY != null) {
                        this.buY.setVisibility(0);
                    }
                    if (this.hng != null) {
                        this.hng.bw(false);
                    }
                } else {
                    if (this.hnP != null) {
                        this.hnP.setVisibility(8);
                    }
                    if (this.hnQ != null) {
                        this.hnQ.setVisibility(8);
                    }
                    if (this.buY != null) {
                        this.buY.setVisibility(8);
                    }
                    if (this.buY != null) {
                        this.buY.setVisibility(8);
                    }
                    if (this.hng != null) {
                        this.hng.bw(true);
                    }
                }
                this.hmk = this.hmk ? false : true;
                if (this.hlX != null) {
                    this.hlX.ny(this.hmk);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, boolean z2) {
        ImageView imageView;
        View Dt;
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view;
        }
        if (z) {
            if (imageView != null) {
                imageView.setImageResource(a.e.icon_live_barrage_off);
            }
            if (this.hmg != null) {
                this.hmg.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.e.icon_live_barrage_on);
            }
            if (this.hmg != null) {
                this.hmg.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.hng != null && (Dt = this.hng.Dt()) != null) {
            if (z) {
                Dt.setVisibility(8);
            } else {
                Dt.setVisibility(0);
            }
        }
    }

    private void bZd() {
        CustomResponsedMessage runTask;
        if (this.hmc == null && (runTask = MessageManager.getInstance().runTask(2913164, com.baidu.live.im.b.a.class, caO().pageContext)) != null) {
            this.hmc = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hmc != null) {
            this.hmc.setOtherParams(this.otherParams);
            this.hmc.a(new a.InterfaceC0177a() { // from class: com.baidu.tieba.ala.liveroom.d.a.3
                @Override // com.baidu.live.im.b.a.InterfaceC0177a
                public void Jo() {
                    a.this.caz();
                }
            });
        }
    }

    private void bZe() {
        if (this.hmY != null) {
            this.hmY.aJ(caO().hxi.getLiveContainerView());
        }
    }

    private void bZf() {
        if (this.hmd == null) {
            this.hmd = new com.baidu.tieba.ala.liveroom.share.b(caO().pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void bZg() {
        if (caO() != null) {
            if (this.hme == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.ae.a.class, caO().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hme = (com.baidu.live.ae.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hme.setIsHost(false);
            this.hme.a(this.buY, caO().hxj.DW().aGH);
        }
    }

    private void bZh() {
        if (caO() != null) {
            if (this.hnB == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913271, com.baidu.live.a.a.class, caO().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hnB = (com.baidu.live.a.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hnB.aY(true);
            this.hnB.setIsHost(false);
            this.hnB.a(bZK(), caO().hxj.DW());
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cs(int i) {
        super.cs(i);
        if (this.hmh != null && UtilHelper.getRealScreenOrientation(caO().pageContext.getPageActivity()) != 2) {
            this.hmh.setVisibility(0);
        }
        bZe();
        if (this.hma != null) {
            this.hma.cs(i);
        }
        if (this.hma == null || !this.hma.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
        if (this.hnG != null) {
            this.hnG.cdO();
        }
    }

    private void bZi() {
        if (this.buY == null) {
            PendantParentView.Model model = PendantParentView.Model.HORIZONTAL;
            if (this.mOrientation == 2) {
                model = PendantParentView.Model.HORIZONTAL_FULL;
            }
            this.buY = new PendantParentView(caO().pageContext.getPageActivity(), model);
            caO().hxk.addView(this.buY, ((caO().hxk.getView() == null || this.hmW == null || this.hmW.getView() == null) ? -1 : caO().hxk.getView().indexOfChild(this.hmW.getView())) + 1, new RelativeLayout.LayoutParams(-1, bZj()));
            this.buY.setDefaultItemMargin(caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            K(this.mOrientation, false);
        }
    }

    private int bZj() {
        int bottom;
        int bottom2;
        if (caO().bon.getLivePlayer().getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) caO().bon.getLivePlayer().getLayoutParams();
            bottom = layoutParams.topMargin + layoutParams.height;
        } else {
            bottom = caO().bon.getLivePlayer().getBottom();
        }
        if (caO().hxk.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) caO().hxk.getLayoutParams();
            bottom2 = layoutParams2.topMargin + layoutParams2.height;
        } else {
            bottom2 = caO().hxk.getBottom();
        }
        int i = 0;
        if (this.hnG != null) {
            i = this.hnG.getHeight();
        }
        return (((bottom2 - bottom) - i) - caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
    }

    private void bZk() {
        if (this.hlX == null) {
            this.hlX = new com.baidu.tieba.ala.liveroom.activeview.b(caO().pageContext);
        }
        if (caO() != null && caO().hxj != null) {
            this.hlX.GO(caO().hxj.ciK());
        }
        this.hlX.setOtherParams(JQ());
        this.hlX.c(caO().hxj.DW(), true);
        this.hlX.setHost(false);
        this.hlX.a(1, this.buY);
        this.hlX.a(2, this.buY);
        this.hlX.setVisible(this.hnT ? 8 : 0);
    }

    private void bZl() {
        if (this.buY != null) {
            if (this.hlW == null) {
                this.hlW = new com.baidu.tieba.ala.liveroom.l.a(caO().pageContext, this);
            }
            this.hlW.setOtherParams(JQ());
            this.hlW.a((ViewGroup) this.buY, bZp());
            this.hlW.L(caO().hxj.DW());
        }
    }

    private void bZm() {
        if (this.hnr == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, j.class, caO().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hnr = (j) runTask.getData();
            } else {
                return;
            }
        }
        this.hnr.setOtherParams(JQ());
        if (this.hmf != null && this.hmf.indexOfChild(this.hnr.getView()) >= 0) {
            this.hmf.removeView(this.hnr.getView());
        }
    }

    private void bZn() {
        if (this.hmO != null) {
            this.hmO.a(new a.InterfaceC0670a() { // from class: com.baidu.tieba.ala.liveroom.d.a.14
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0670a
                public void bR(int i, int i2) {
                    x DW = a.this.caO().hxj.DW();
                    if (DW != null && DW.mLiveInfo != null) {
                        if (a.this.hnu == null) {
                            a.this.hnu = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.caO().pageContext.getPageActivity());
                        }
                        a.this.hnu.d(a.this.hnQ, i, i2);
                        a.this.hnu.a(String.valueOf(DW.mLiveInfo.live_id), new a.InterfaceC0674a() { // from class: com.baidu.tieba.ala.liveroom.d.a.14.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0674a
                            public void a(float f, String str) {
                                if (a.this.hmO != null) {
                                    a.this.hmO.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0670a
                public void bS(int i, int i2) {
                    if (a.this.hnu != null) {
                        a.this.hnu.bX(i, i2);
                    }
                }
            });
        }
    }

    private void bZo() {
        if (this.hof == null) {
            this.hof = new com.baidu.tieba.ala.liveroom.j.e(caO().pageContext);
        }
        this.hof.setRoomId(caO().hxj.DW().mLiveInfo.room_id);
        this.hof.Hj("");
        this.hof.b(caO().hxj.DW(), this.buY);
        if (this.hmo == null) {
            this.hmo = new com.baidu.tieba.ala.liveroom.j.b(caO().pageContext, JQ(), this.hof, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.15
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bZN() {
                    a.this.nE(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bZO() {
                    a.this.nE(false);
                }
            });
        }
        this.hmo.setRoomId(caO().hxj.DW().mLiveInfo.room_id);
        if (this.hmf != null && this.hmf.indexOfChild(this.hmo.getView()) >= 0) {
            this.hmf.removeView(this.hmo.getView());
        }
        if (this.hmo != null) {
            this.hmo.b(caO());
        }
    }

    private LinearLayout.LayoutParams bZp() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = caO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZq() {
        if (this.hmO == null) {
            bZw();
        }
        this.hmO.a(com.baidu.live.af.e.OY().bxA, caO().hxj.DW());
    }

    private void bZr() {
        CustomResponsedMessage runTask;
        boolean z = true;
        if (this.hne == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, caO().pageContext)) != null && runTask.getData() != null) {
            this.hne = (k) runTask.getData();
            this.hne.setFromMaster(false);
            this.hne.IF().getView().setId(a.f.ala_liveroom_msg_list);
            this.hne.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.16
                @Override // com.baidu.live.im.k.a
                public boolean IJ() {
                    return a.this.GJ();
                }

                @Override // com.baidu.live.im.k.a
                public void IK() {
                    a.this.hnX = true;
                }

                @Override // com.baidu.live.im.k.a
                public void gD(String str) {
                    if (!a.this.hnT) {
                        a.this.nC(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.caO().pageContext.getPageActivity(), a.this.caO().hxi.getLiveContainerView());
                    }
                    a.this.GV(str);
                }

                @Override // com.baidu.live.im.k.a
                public void IL() {
                    if (a.this.hnT) {
                        a.this.nC(true);
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.16.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.caO().pageContext.getPageActivity(), a.this.caO().hxi.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (a.this.hne != null) {
                        a.this.hne.IG().setQuickInputPanelVisible(false);
                        a.this.hne.IG().KB();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void IM() {
                }

                @Override // com.baidu.live.im.k.a
                public void IN() {
                    if (a.this.hnT) {
                        a.this.bZM();
                        if (a.this.hnf != null) {
                            a.this.hnf.zg();
                        }
                        if (a.this.hmc != null) {
                            a.this.hmc.zg();
                        }
                    } else if (a.this.hne != null) {
                        a.this.hne.IG().setQuickInputPanelVisible(false);
                        a.this.hne.IG().KB();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean IO() {
                    return a.this.bZZ();
                }

                @Override // com.baidu.live.im.k.a
                public int IP() {
                    return a.this.caa();
                }

                @Override // com.baidu.live.im.k.a
                public boolean IQ() {
                    x DW = a.this.caO().hxj.DW();
                    if (DW == null || DW.aGd == null) {
                        return false;
                    }
                    return DW.aGd.isMysteriousMan;
                }
            });
            this.hmf = new FrameLayout(caO().pageContext.getPageActivity());
            this.hmf.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.hne != null && this.hmf != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(caO().pageContext.getPageActivity()) * 0.7f);
            int i = com.baidu.live.al.c.i(true, false);
            if (this.hnQ.indexOfChild(this.hmf) < 0) {
                if (this.hmf.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hmf.getParent()).removeView(this.hmf);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
                this.hnQ.addView(this.hmf, layoutParams);
            }
            if (this.hmf.indexOfChild(this.hne.IF().getView()) < 0) {
                if (this.hne.IF().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hne.IF().getView()).removeView(this.hne.IF().getView());
                }
                if (UtilHelper.getRealScreenOrientation(caO().pageContext.getPageActivity()) != 2) {
                    this.hmf.addView(this.hne.IF().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, i));
                }
            }
            if (caO().hxk.indexOfChild(this.hne.IG().getView()) < 0) {
                if (this.hne.IG().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hne.IG().getView().getParent()).removeView(this.hne.IG().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                cai();
                caO().hxk.addView(this.hne.IG().getView(), layoutParams2);
            }
            x DW = caO().hxj.DW();
            if (DW != null && DW.mLiveInfo != null) {
                this.hne.setLogData(DW.mLiveInfo.feed_id, JQ());
            }
            if (DW == null || DW.aGv == null || !DW.aGv.Av()) {
                z = false;
            }
            this.hne.a(String.valueOf(caO().hxj.DW().mLiveInfo.group_id), String.valueOf(caO().hxj.DW().mLiveInfo.last_msg_id), String.valueOf(caO().hxj.DW().aFH.userId), String.valueOf(caO().hxj.DW().mLiveInfo.live_id), caO().hxj.DW().aFH.appId, z, caO().hxj.DW().getGuardName());
            nC(false);
        }
    }

    private void bZs() {
        cag();
    }

    private void bZt() {
        if (this.hmg == null) {
            this.hmg = new FrameLayout(caO().pageContext.getPageActivity());
            this.hmg.setId(a.f.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void bZu() {
        if (this.hlS == null) {
            this.hlS = new com.baidu.tieba.ala.liveroom.o.a(caO().pageContext, false, this);
        }
        this.hlS.e(this.hnP, caO().hxj.DW());
        this.hlS.a(this.hmu);
        this.hlS.a(this.hmE);
    }

    private void bZv() {
        if (this.hlR == null) {
            this.hlR = new com.baidu.tieba.ala.liveroom.audiencelist.c(caO().pageContext, this, false);
        }
        this.hlR.a(String.valueOf(caO().hxj.DW().mLiveInfo.group_id), String.valueOf(caO().hxj.DW().mLiveInfo.live_id), String.valueOf(caO().hxj.DW().aFH.userId), caO().hxj.DW());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.f.ala_liveroom_hostheader;
            if (this.hmP != null && this.hmP.getView() != null && this.hmP.getView().getParent() != null) {
                i = a.f.ala_liveroom_guardthrone;
            }
            this.hlR.c(this.hnP, i, a.f.ala_liveroom_audience_count_layout);
            this.hlR.e(caO().hxj.bTh());
        }
    }

    private void bZw() {
        com.baidu.live.core.a.a KS;
        if (this.hmO == null) {
            this.hmO = new com.baidu.tieba.ala.liveroom.operation.a(caO().pageContext);
        }
        this.hmO.a(caO(), this.hnQ, caO().hxj.DW().mLiveInfo, true, this.hmE);
        this.hmO.setOtherParams(JQ());
        if (this.hnp != null && (KS = this.hnp.KS()) != null) {
            View rootLayout = KS.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.hmO.cy(rootLayout);
        }
        this.hmO.Q(caO().hxj.DW());
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void bZx() {
        bZy();
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void nA(boolean z) {
    }

    private void bZy() {
        if (this.hmO != null) {
            int i = caO().hxj.DW().aGd.isUegBlock;
            int i2 = caO().hxj.DW().aGd.isBlock;
            String str = caO().hxj.DW().aGd.userName;
            if (i > 0 || i2 > 0) {
                this.hmO.b(true, i, i2, str);
                this.hne.a(true, i, i2, str);
                this.hnk.b(true, i, i2, str);
                return;
            }
            this.hmO.b(false, i, i2, str);
            this.hne.a(false, i, i2, str);
            this.hnk.b(false, i, i2, str);
        }
    }

    private void bZz() {
        if (this.hlV == null) {
            this.hlV = new com.baidu.tieba.ala.liveroom.audiencelist.b(caO().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (caO().hxj.bTh() != null) {
            j = caO().hxj.bTh().getCount();
        }
        this.hlV.a(this.hmE);
        this.hlV.a(this.hnP, a.f.ala_liveroom_hostheader, j);
        this.hlV.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.hlV.nO(false);
        } else {
            this.hlV.nO(true);
        }
    }

    public void bZA() {
        this.hmR.d(caO().hxj.DW(), false);
    }

    public void bZB() {
        if (caO().hxj.DW() != null && caO().hxj.DW().aFH != null && caO().hxj.DW().mLiveInfo != null) {
            if (this.hlU == null) {
                this.hlU = new com.baidu.tieba.ala.liveroom.u.b(caO().pageContext);
            }
            long j = caO().hxj.DW().aFH.userId;
            int i = caO().hxj.DW().mLiveInfo.live_type;
            String str = caO().hxj.DW().aFH.portrait;
            String str2 = caO().hxj.DW().mLiveInfo.feed_id;
            long j2 = caO().hxj.DW().mLiveInfo.live_id;
            this.hlU.a(i, j, caO().hxj.DW().aFH.userName, false, str, JQ(), str2, j2);
            this.hlU.aF(this.hnP);
        }
    }

    private void bZC() {
        boolean z = false;
        if (this.hmZ == null) {
            this.hmZ = new com.baidu.tieba.ala.liveroom.w.a(caO().pageContext, this);
        }
        this.hmZ.c(caO().hxk, false);
        boolean caN = caN();
        AlaLiveInfoData alaLiveInfoData = caO().hxj.DW().mLiveInfo;
        boolean isZanAnimUnabled = (alaLiveInfoData == null || alaLiveInfoData.mAlaLiveSwitchData == null) ? false : alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled();
        if (caN && !isZanAnimUnabled) {
            z = true;
        }
        this.hmZ.oH(z);
    }

    private void bZD() {
        if (caO() != null && caO().bon != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(caO().pageContext.getPageActivity());
            Activity pageActivity = caO().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + p.br(pageActivity)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.hmh = new ImageView(caO().pageContext.getPageActivity());
            this.hmh.setVisibility(8);
            this.hmh.setBackgroundResource(a.e.sdk_round_btn_close_bg);
            this.hmh.setImageResource(a.e.icon_live_enlarge);
            this.hmh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hmi != null) {
                        a.this.hmi.St();
                        a.this.hmh.setVisibility(4);
                        a.this.hne.IH().cn(false);
                    }
                }
            });
            caO().hxk.addView(this.hmh, layoutParams);
            if (UtilHelper.getRealScreenOrientation(caO().pageContext.getPageActivity()) != 2) {
                if (caO().hxq) {
                    this.hmh.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.19
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.hmh != null && UtilHelper.getRealScreenOrientation(a.this.caO().pageContext.getPageActivity()) != 2) {
                                a.this.hmh.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
        }
    }

    private void bZE() {
        if (this.hnO == null) {
            this.hnO = new com.baidu.tieba.ala.liveroom.apppromotion.a(caO().pageContext);
        }
        this.hnO.b(bZK(), caO().hxj.DW());
    }

    private void bZF() {
        if (this.hnX || this.hnY) {
            if ((TbadkCoreApplication.isLogin() && this.hne.IG().hasText()) || this.hnY) {
                this.hnX = false;
                this.hnY = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.20
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.caf();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void t(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        super.t(bVar);
        if (this.hlX != null) {
            this.hlX.I(bVar);
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
        if (this.hme == null || !this.hme.V(jSONObject)) {
            if ((bVar.getMsgType() == 12 || bVar.getMsgType() == 13) && jSONObject != null) {
                String optString = jSONObject.optString("content_type");
                if ("task".equals(optString)) {
                    if (this.hlW != null) {
                        this.hlW.Q(jSONObject);
                    }
                } else if ("enter_live".equals(optString)) {
                    if (this.hlV != null && this.hlV.getCount() > 20) {
                        this.hlV.eZ(this.hlV.getCount() + 1);
                    } else if (this.hlR != null) {
                        com.baidu.live.data.a JB = bVar.JB();
                        q qVar = new q();
                        qVar.aFI = new AlaLocationData();
                        qVar.aFJ = new AlaRelationData();
                        qVar.aFH = new AlaLiveUserInfoData();
                        qVar.aFH.userId = JavaTypesHelper.toLong(JB.userId, 0L);
                        qVar.aFH.userName = JB.userName;
                        qVar.aFH.portrait = JB.portrait;
                        if (this.hlV != null && this.hlR.c(qVar)) {
                            this.hlV.eZ(this.hlV.getCount() + 1);
                        }
                    }
                } else if ("update_liveinfo".equals(optString)) {
                    if (caO().hxj.DW() != null && caO().hxj.DW().mLiveInfo != null) {
                        caO().hxj.a(caO().hxj.DW().mLiveInfo.live_id, caO().fromType, caO().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && caO().hxj.DW() != null && caO().hxj.DW().mLiveInfo != null && caO().hxj.DW().aGd != null && this.hma != null) {
                    long optLong = jSONObject.optLong("mvp_user_id");
                    long optLong2 = jSONObject.optLong("winner_live_id");
                    if (optLong == caO().hxj.DW().aGd.userId && optLong2 == caO().hxj.DW().mLiveInfo.live_id) {
                        this.hma.f(jSONObject.optInt("challenge_status"), jSONObject.optLong("challenge_id"));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void GQ(String str) {
        if (this.hlX != null) {
            this.hlX.GQ(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(x xVar) {
        super.k(xVar);
        if (this.hlS != null) {
            this.hlS.M(xVar);
        }
        if (this.hlT != null) {
            this.hlT.I(xVar);
        }
        if (this.hlW != null) {
            this.hlW.L(xVar);
        }
        if (this.hma != null) {
            this.hma.a(xVar);
        }
        if (this.hmc != null) {
            this.hmc.a(xVar);
        }
        if (this.hlX != null) {
            this.hlX.j(xVar);
            if (xVar != null && this.hnH != null && !this.hnH.hasInit && !TextUtils.isEmpty(this.hnH.aNi)) {
                this.hnH.hasInit = true;
                this.hlX.GR(this.hnH.aNi);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(r rVar) {
        if (rVar != null) {
            if (this.hlR != null && rVar.getList() != null) {
                this.hlR.e(rVar);
            }
            if (this.hlV != null) {
                this.hlV.eZ(rVar.getCount());
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void cy(boolean z) {
        super.cy(z);
        if (caO().hxk != null) {
            caO().hxk.ckl();
            caO().hxk.setLiveViewOnDispatchTouchEventListener(null);
            caO().hxk.setLiveViewOnTouchEventListener(null);
            caO().hxk.setOnLiveViewScrollListener(null);
        }
        if (caO().bon != null) {
            caO().bon.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
        }
        if (this.hma != null) {
            this.hma.zH();
        }
        bZG();
        if (this.hlU != null) {
            this.hlU.zH();
        }
        if (this.hmZ != null) {
            this.hmZ.release();
        }
        if (this.hlW != null) {
            this.hlW.zH();
        }
        if (this.hme != null) {
            this.hme.xk();
        }
        if (this.hmO != null) {
            this.hmO.ciQ();
        }
        if (this.hlT != null) {
            this.hlT.cdr();
            this.hlT.setVisible(8);
        }
        if (this.hlY != null) {
            this.hlY.zH();
        }
        if (this.hlX != null) {
            this.hlX.release();
        }
        if (this.buY != null) {
            this.buY.removeAllViews();
            this.buY = null;
        }
        if (this.hlZ != null) {
            this.hlZ.zH();
        }
        if (this.hmc != null) {
            this.hmc.a((a.InterfaceC0177a) null);
            this.hmc.zh();
        }
        if (this.hlS != null) {
            this.hlS.cfq();
        }
        if (this.hmh != null && (this.hmh.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hmh.getParent()).removeView(this.hmh);
        }
        if (this.hmd != null) {
            this.hmd.dismiss();
        }
        if (this.hmi != null) {
            this.hmi.cZ(false);
            this.hmi.Su();
        }
        if (this.hmo != null) {
            this.hmo.zH();
        }
        if (this.hof != null) {
            this.hof.ccl();
        }
        if (this.hnJ != null) {
            this.hnJ.zH();
        }
        if (this.hnO != null) {
            this.hnO.xk();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void n(x xVar) {
        View zf;
        super.n(xVar);
        if (this.hmc != null && (zf = this.hmc.zf()) != null && zf.getParent() != null) {
            ((ViewGroup) zf.getParent()).removeView(zf);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.hmc != null) {
            this.hmc.setOtherParams(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cw(boolean z) {
        super.cw(z);
        this.hmm.removeCallbacksAndMessages(null);
        bZG();
        this.hmk = false;
        this.hml = false;
        if (this.hlS != null) {
            this.hlS.onDestroy();
        }
        if (this.hlU != null) {
            this.hlU.onDestroy();
        }
        if (this.hlW != null) {
            this.hlW.onDestroy();
        }
        if (this.hlY != null) {
            this.hlY.onDestroy();
        }
        if (this.hlZ != null) {
            this.hlZ.onDestroy();
        }
        if (this.hma != null) {
            this.hma.onDestroy();
        }
        if (this.hmb != null) {
            this.hmb.onDestroy();
        }
        if (this.hmd != null) {
            this.hmd.onDestroy();
        }
        if (this.hlT != null) {
            this.hlT.onDestroy();
        }
        if (this.hmi != null) {
            this.hmi.stop();
        }
        if (this.hmZ != null) {
            this.hmZ.onDestroy();
        }
        if (this.hlR != null) {
            this.hlR.onDestroy();
        }
        if (this.hne != null) {
            this.hne.onDestroy();
        }
        if (this.hmO != null) {
            this.hmO.onDestory();
        }
        if (this.hmc != null) {
            this.hmc.a((a.InterfaceC0177a) null);
            this.hmc.release();
            this.hmc = null;
        }
        if (this.hof != null) {
            this.hof.cw(z ? false : true);
        }
        if (this.hmo != null) {
            this.hmo.onDestroy();
            this.hmo = null;
        }
        if (this.hnJ != null) {
            this.hnJ.onDestroy();
        }
        if (this.hme != null) {
            this.hme.onDestroy();
        }
        if (this.hnO != null) {
            this.hnO.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.hmq);
        MessageManager.getInstance().removeMessageRule(this.hmp);
        MessageManager.getInstance().removeMessageRule(this.hmr);
        MessageManager.getInstance().removeMessageRule(this.hms);
        MessageManager.getInstance().unRegisterListener(this.hmx);
        MessageManager.getInstance().unRegisterListener(this.hmB);
        MessageManager.getInstance().unRegisterListener(this.hmC);
        MessageManager.getInstance().unRegisterListener(this.hmD);
        MessageManager.getInstance().unRegisterListener(this.hmA);
        MessageManager.getInstance().unRegisterListener(this.hmz);
        MessageManager.getInstance().unRegisterListener(this.hmy);
        MessageManager.getInstance().unRegisterListener(this.hmv);
        MessageManager.getInstance().unRegisterListener(this.hmw);
    }

    private void bZG() {
        if (this.hne != null && this.hne.IF().getView() != null && this.hne.IF().getView().getParent() != null) {
            ((ViewGroup) this.hne.IF().getView().getParent()).removeView(this.hne.IF().getView());
        }
        if (this.hmf != null && this.hmf.getParent() != null) {
            ((ViewGroup) this.hmf.getParent()).removeView(this.hmf);
        }
        if (this.hmg != null && this.hmg.getParent() != null) {
            ((ViewGroup) this.hmg.getParent()).removeView(this.hmg);
        }
        if (this.hne != null && this.hne.IG().getView() != null) {
            this.hnQ.removeView(this.hne.IG().getView());
        }
        if (this.hne != null) {
            this.hne.IF().setMsgData(new LinkedList());
            this.hne.zh();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void a(at atVar) {
        if (this.hne != null) {
            caf();
            String nameShow = atVar.getNameShow();
            if (atVar.extInfoJson != null) {
                if (atVar.extInfoJson.optInt("is_mysterious_man") == 1) {
                    nameShow = atVar.extInfoJson.optString("mysterious_man_nickname");
                    if (TextUtils.isEmpty(nameShow)) {
                        nameShow = "神秘人";
                    }
                }
            }
            this.hne.IG().setEditText(" @" + nameShow + " ");
        }
        if (this.hmO != null) {
            this.hmO.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void g(com.baidu.live.data.a aVar) {
        if (this.hne != null) {
            caf();
            String nameShow = aVar.getNameShow();
            if (aVar.extInfoJson != null) {
                if (aVar.extInfoJson.optInt("is_mysterious_man") == 1) {
                    nameShow = aVar.extInfoJson.optString("mysterious_man_nickname");
                    if (TextUtils.isEmpty(nameShow)) {
                        nameShow = "神秘人";
                    }
                }
            }
            this.hne.IG().setEditText(" @" + nameShow + " ");
        }
        if (this.hmO != null) {
            this.hmO.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void GT(String str) {
        if (this.hne != null) {
            caf();
            StringBuilder sb = new StringBuilder();
            sb.append(" @");
            sb.append(str);
            sb.append(" ");
            if (com.baidu.live.af.a.OJ().bru.aJT != null && com.baidu.live.af.a.OJ().bru.aJT.originTexts != null && com.baidu.live.af.a.OJ().bru.aJT.originTexts.size() > 0) {
                this.hne.IG().KC();
                this.hne.IG().setEditText(sb.toString() + com.baidu.live.af.a.OJ().bru.aJT.originTexts.get(0));
            } else {
                this.hne.IG().setEditText(sb.toString());
            }
        }
        if (this.hmO != null) {
            this.hmO.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void b(at atVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected View bZH() {
        if (this.hne != null) {
            return this.hne.IG().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean bZI() {
        if (this.hne == null || !this.hne.IG().KA()) {
            return false;
        }
        nC(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected boolean bZJ() {
        return this.hlS == null || this.hlS.bZJ();
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected ViewGroup bZK() {
        return this.buY;
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
                    this.hnU = false;
                    P(intExtra, intExtra2, intExtra3);
                    return;
                }
                bZA();
                return;
            }
            avQ();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.hnT;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(caO().pageContext.getPageActivity()) || z2) {
            nB(z);
        }
    }

    private void nB(boolean z) {
        if (this.hne != null && this.hne.IF() != null) {
            this.hne.IF().onKeyboardVisibilityChanged(z);
        }
        if (z || this.hne == null || !this.hne.IG().KA()) {
            if (z) {
                if (this.hmO != null) {
                    this.hmO.setVisibility(8);
                }
                if (this.hng != null && this.hng.Dt() != null) {
                    this.hng.Dt().setVisibility(8);
                }
                bZM();
                if (this.hne != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hne.IG().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.hne.IG().getView().setLayoutParams(layoutParams);
                    this.hne.IG().getView().setVisibility(0);
                    this.hne.IG().setQuickInputPanelVisible(false);
                    this.hne.IH().cn(false);
                }
                if (this.hnP != null) {
                    this.hnP.setVisibility(8);
                }
                if (this.hlX != null) {
                    this.hlX.setVisible(8);
                }
                if (this.hnf != null) {
                    this.hnf.zg();
                }
                if (this.hnI != null) {
                    this.hnI.setCanVisible(false);
                }
                if (this.hny != null) {
                    this.hny.setCanVisible(false);
                }
                if (this.hnC != null) {
                    this.hnC.setCanVisible(false);
                }
                if (this.hnD != null) {
                    this.hnD.setVisible(8);
                }
                if (this.hnB != null) {
                    this.hnB.setCanVisible(false);
                }
                if (this.hnO != null) {
                    this.hnO.setCanVisible(false);
                }
                if (this.hnE != null) {
                    this.hnE.setCanVisible(false);
                }
            } else {
                bZL();
            }
            if (this.hne != null && this.hmf != null) {
                if (this.hnQ.indexOfChild(this.hmf) != -1 && this.hmf.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hmf.getLayoutParams();
                    layoutParams2.height = com.baidu.live.al.c.i(true, z);
                    this.hmf.setLayoutParams(layoutParams2);
                }
                if (this.hmf.indexOfChild(this.hne.IF().getView()) != -1 && this.hne.IF().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.hne.IF().getView().getLayoutParams();
                    layoutParams3.height = com.baidu.live.al.c.i(true, z);
                    this.hne.IF().getView().setLayoutParams(layoutParams3);
                }
                this.hne.IF().IE();
            }
        }
    }

    private void bZL() {
        if (this.hmO != null) {
            this.hmO.setVisibility(0);
        }
        if (this.hmf != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hmf.getLayoutParams();
            layoutParams.bottomMargin = caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            this.hmf.setLayoutParams(layoutParams);
        }
        if (this.hne != null) {
            cai();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hne.IG().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.hne.IG().getView().setLayoutParams(layoutParams2);
            if (this.aJV) {
                if (UtilHelper.getRealScreenOrientation(caO().pageContext.getPageActivity()) != 2 && !this.hne.IH().isClicked()) {
                    this.hne.IH().cn(true);
                }
            } else {
                this.hne.IH().cn(false);
            }
        }
        if (this.hmO != null) {
            this.hmO.setVisibility(0);
        }
        if (this.hng != null && this.hng.Dt() != null) {
            this.hng.Dt().setVisibility(0);
        }
        if (this.hnP != null && (!this.hmk || UtilHelper.getRealScreenOrientation(caO().pageContext.getPageActivity()) != 2)) {
            this.hnP.setVisibility(0);
        }
        if (this.hlX != null) {
            this.hlX.setVisible(0);
        }
        if (this.hnf != null) {
            this.hnf.zg();
        }
        if (this.hnI != null) {
            this.hnI.setCanVisible(true);
        }
        if (this.hny != null) {
            this.hny.setCanVisible(true);
        }
        if (this.hnC != null) {
            this.hnC.setCanVisible(true);
        }
        if (this.hnD != null) {
            this.hnD.setVisible(0);
        }
        if (this.hnB != null) {
            this.hnB.setCanVisible(true);
        }
        if (this.hnO != null) {
            this.hnO.setCanVisible(true);
        }
        if (this.hnE != null) {
            this.hnE.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZM() {
        boolean z;
        boolean z2;
        if (this.hmf != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hmf.getLayoutParams();
            if (this.hne == null || this.hne.IG() == null) {
                z = false;
                z2 = false;
            } else {
                boolean Ky = this.hne.IG().Ky();
                z = this.hne.IG().Kz();
                z2 = Ky;
            }
            int O = O(z2, z);
            if (layoutParams.bottomMargin != O) {
                layoutParams.bottomMargin = O;
                this.hmf.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nC(boolean z) {
        if (z) {
            this.hne.IG().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hmf.getLayoutParams();
            int quickInputPanelExpandHeight = this.hne.IG().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.hmf.setLayoutParams(layoutParams);
                if (this.hne.IF() != null) {
                    this.hne.IF().IE();
                    return;
                }
                return;
            }
            return;
        }
        bZL();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        FrameLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = caO().pageContext.getPageActivity();
        if (i3 == 1) {
            if (caO().pageContext.getPageActivity() != null && !UtilHelper.canUseStyleImmersiveSticky()) {
                com.baidu.live.utils.r.e(caO().pageContext.getPageActivity(), true);
            }
            if (this.hnP != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.hnP.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.hmd != null) {
                this.hmd.dismiss();
            }
            if (this.hmc != null) {
                this.hmc.a((a.InterfaceC0177a) null);
                this.hmc.zh();
            }
            if (this.bok != null) {
                this.bok.e(true, true);
            }
            if (this.hmh != null) {
                this.hmh.setVisibility(0);
                this.hmh.bringToFront();
            }
            if (this.hmU != null) {
                this.hmU.setVisibility(0);
            }
            if (this.hne != null && this.hne.IF().getView().getParent() != null && (this.hne.IF().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hne.IF().getView().getParent()).removeView(this.hne.IF().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(caO().pageContext.getPageActivity()) * 0.7f);
            int i4 = com.baidu.live.al.c.i(true, false);
            if (this.hmf != null && this.hne != null) {
                this.hmf.addView(this.hne.IF().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, i4));
            }
            if (this.hmg != null && (this.hmg.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hmg.getParent()).removeView(this.hmg);
            }
            if (this.hnf != null) {
                this.hnf.a(caO().hxj.DW(), false);
                this.hnf.a(new a.InterfaceC0177a() { // from class: com.baidu.tieba.ala.liveroom.d.a.21
                    @Override // com.baidu.live.im.b.a.InterfaceC0177a
                    public void Jo() {
                        a.this.caz();
                    }
                });
                View zf = this.hnf.zf();
                if (zf != null && this.hnQ != null && zf.getParent() == null) {
                    Resources resources = caO().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(caO().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                    layoutParams5.addRule(2, a.f.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                    this.hnQ.addView(zf, layoutParams5);
                }
            }
            if (this.hmW != null) {
                this.hmW.setPraiseEnable(true);
                caO().hxk.hMO = true;
            }
            if (this.hlR != null && this.hlR.hpz != null && (layoutParams3 = (FrameLayout.LayoutParams) this.hlR.hpz.getLayoutParams()) != null) {
                layoutParams3.width = -2;
                this.hlR.hpz.setLayoutParams(layoutParams3);
            }
            if (this.hmZ != null) {
                this.hmZ.ckL();
            }
            if (this.hmk) {
                nz(true);
            }
            if (this.hml) {
                if (this.hmO != null && this.hmO.getLandscapeBarrageImageView() != null) {
                    b(this.hmO.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.hmO != null) {
                this.hmO.vP(0);
            }
            if (this.hlV != null) {
                this.hlV.nN(true);
            }
            this.hmm.removeCallbacksAndMessages(null);
            if (this.hlW != null) {
                this.hlW.setCanVisible(true);
                this.hlW.L(caO().hxj.DW());
            }
            if (this.hme != null) {
                this.hme.cK(true);
            }
            if (this.hne != null) {
                if (this.aJV) {
                    if (!this.hne.IH().isClicked()) {
                        this.hne.IH().cn(true);
                    }
                } else {
                    this.hne.IH().cn(false);
                }
            }
        } else if (i3 == 2) {
            if (caO().pageContext.getPageActivity() != null && !UtilHelper.canUseStyleImmersiveSticky()) {
                com.baidu.live.utils.r.e(caO().pageContext.getPageActivity(), false);
            }
            if (this.hmZ != null) {
                this.hmZ.ckM();
            }
            if (this.hnP != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.hnP.getLayoutParams()) != null) {
                layoutParams2.topMargin = caO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
            }
            if (this.hnf != null) {
                this.hnf.a((a.InterfaceC0177a) null);
                this.hnf.zh();
            }
            caO().hxk.ckn();
            if (this.bok != null) {
                this.bok.e(false, true);
            }
            if (this.hmh != null) {
                this.hmh.setVisibility(4);
            }
            if (this.hne != null && this.hne.IF().getView().getParent() != null && (this.hne.IF().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hne.IF().getView().getParent()).removeView(this.hne.IF().getView());
                this.hne.IH().cn(false);
            }
            int max = Math.max(i, i2);
            if (this.hmg != null) {
                if (this.hmg.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hmg.getParent()).removeView(this.hmg);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100);
                caO().hxk.addView(this.hmg, this.buY != null ? caO().hxk.indexOfChild(this.buY) : -1, layoutParams6);
            }
            if (this.hmg != null && this.hmc != null) {
                this.hmc.a(caO().hxj.DW(), false);
                this.hmc.a(new a.InterfaceC0177a() { // from class: com.baidu.tieba.ala.liveroom.d.a.23
                    @Override // com.baidu.live.im.b.a.InterfaceC0177a
                    public void Jo() {
                        a.this.caz();
                    }
                });
                View zf2 = this.hmc.zf();
                if (zf2 != null && this.hmg.indexOfChild(zf2) < 0) {
                    this.hmg.addView(zf2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(caO().pageContext.getPageActivity()), -1));
                }
            }
            if (this.hmW != null) {
                this.hmW.aM(caO().hxk);
                this.hmW.setPraiseEnable(false);
                caO().hxk.hMO = false;
            }
            if (this.hlR != null && this.hlR.hpz != null && (layoutParams = (FrameLayout.LayoutParams) this.hlR.hpz.getLayoutParams()) != null) {
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                layoutParams.width = (int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f);
                this.hlR.hpz.setLayoutParams(layoutParams);
            }
            if (this.hmO != null) {
                this.hmO.vP(8);
            }
            if (this.hlV != null) {
                this.hlV.nN(false);
            }
            if (al.El() != null) {
                al.El().Ek();
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.ai.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.ai.c) runTask.getData()).Ek();
            }
            if (this.hmO != null && this.hmO.getLandscapeBarrageImageView() != null) {
                b(this.hmO.getLandscapeBarrageImageView(), this.hml, false);
            }
            bZa();
            if (this.hng != null) {
                this.hng.Dv();
            }
            if (this.hlW != null) {
                this.hlW.setCanVisible(false);
                this.hlW.ceu();
            }
            if (this.hme != null) {
                this.hme.setCanVisible(false);
            }
        }
        if (this.hnC != null) {
            this.hnC.cF(i3);
        }
        if (this.hnn != null) {
            this.hnn.cF(i3);
        }
        if (this.hnh != null) {
            this.hnh.cF(i3);
        }
        if (this.hne != null) {
            this.hne.IH().cF(i3);
        }
        if (this.hmO != null) {
            this.hmO.l(i, i2, i3);
        }
        K(i3, true);
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.hlR != null) {
                this.hlR.co(i3);
            }
            if (this.hlT != null) {
                this.hlT.co(i3);
            }
            if (this.hlX != null) {
                this.hlX.co(i3);
            }
            if (this.hnp != null) {
                this.hnp.co(i3);
            }
            if (this.hnk != null) {
                this.hnk.co(i3);
            }
            if (this.hnt != null) {
                this.hnt.co(i3);
            }
            if (this.hnv != null) {
                this.hnv.co(i3);
            }
            if (this.hba != null) {
                this.hba.co(i3);
            }
            if (this.hmn != null && this.hmn.isShowing()) {
                this.hmn.resize();
            }
            if (this.hnI != null) {
                this.hnI.co(i3);
            }
            if (this.hnJ != null) {
                this.hnJ.co(i3);
            }
            if (this.hnG != null) {
                this.hnG.cF(i3);
            }
            if (this.hnM != null) {
                this.hnM.co(i3);
            }
        }
        if (this.hng != null) {
            this.hng.Du();
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public boolean dz(int i) {
        boolean dz = super.dz(i);
        if (dz && 2 == i) {
            if (this.hlS.bZJ()) {
                return false;
            }
            if (dz && this.hmZ != null) {
                this.hmZ.oI(false);
            }
        }
        return dz;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void vd(int i) {
        super.vd(i);
        if (i == 7 || i == 11) {
            if (i != 7 || UtilHelper.getRealScreenOrientation(caO().pageContext.getPageActivity()) != 2) {
                if (this.hmO != null) {
                    this.hmO.setVisibility(8);
                }
                if (this.hne != null) {
                    this.hne.IF().getView().setVisibility(4);
                    this.hne.IH().cn(false);
                }
                if (this.hnu != null) {
                    this.hnu.oC(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public void dA(int i) {
        super.dA(i);
        if (i == 7 || i == 11) {
            if (this.hmO != null) {
                this.hmO.setVisibility(0);
            }
            if (this.hne != null) {
                this.hne.IF().getView().setVisibility(0);
                if (this.aJV && UtilHelper.getRealScreenOrientation(caO().pageContext.getPageActivity()) != 2 && !this.hne.IH().isClicked()) {
                    this.hne.IH().cn(true);
                }
            }
            if (this.hnu != null) {
                this.hnu.oC(true);
            }
            if (!this.hmk || UtilHelper.getRealScreenOrientation(caO().pageContext.getPageActivity()) != 2) {
                this.hnP.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.hlU != null) {
            this.hlU.cjn();
        }
        if (this.hlZ != null) {
            this.hlZ.zQ();
        }
        if (this.hlX != null) {
            this.hlX.onStop();
        }
        if (caO() != null) {
            BdUtilHelper.hideSoftKeyPad(caO().pageContext.getPageActivity(), caO().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.hlU != null) {
            this.hlU.cjm();
        }
        if (this.hlZ != null) {
            this.hlZ.zR();
        }
        if (this.hlX != null) {
            this.hlX.onStart();
        }
        if (this.hnG != null) {
            this.hnG.onStart();
        }
        if (this.hnO != null) {
            this.hnO.onStart();
        }
    }

    private void K(int i, boolean z) {
        if (this.buY != null) {
            int dimensionPixelSize = caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.buY.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                layoutParams.rightMargin = caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6);
                layoutParams.height = bZj();
                this.buY.setPosition(dimensionPixelSize, 0, dimensionPixelSize, 0);
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                int dimensionPixelSize2 = caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds72) + 0 + caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100) + caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
                layoutParams.height = -1;
                this.buY.setPosition(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
            }
            layoutParams.bottomMargin = caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds114);
            this.buY.setLayoutParams(layoutParams);
            this.buY.setModel(i == 1 ? PendantParentView.Model.HORIZONTAL : PendantParentView.Model.HORIZONTAL_FULL);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.e
    public void ve(int i) {
        K(this.mOrientation, false);
    }
}
