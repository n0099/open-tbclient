package com.baidu.tieba.ala.liveroom.d;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.a.a;
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
import com.baidu.live.ao.c;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.e;
import com.baidu.live.challenge.h;
import com.baidu.live.challenge.i;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveSdkInfo;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.ag;
import com.baidu.live.data.ak;
import com.baidu.live.data.at;
import com.baidu.live.data.bc;
import com.baidu.live.data.bg;
import com.baidu.live.data.bq;
import com.baidu.live.data.ch;
import com.baidu.live.data.cn;
import com.baidu.live.data.cq;
import com.baidu.live.data.q;
import com.baidu.live.data.r;
import com.baidu.live.data.x;
import com.baidu.live.gift.ah;
import com.baidu.live.gift.n;
import com.baidu.live.guardclub.j;
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
import com.baidu.live.tbadk.coreextra.data.AlaVideoBCChatData;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.ala.liveroom.guide.a;
import com.baidu.tieba.ala.liveroom.j.b;
import com.baidu.tieba.ala.liveroom.j.g;
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d extends b implements com.baidu.live.n.c {
    private PendantParentView buY;
    private boolean gNL;
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
    private FrameLayout hmf;
    private com.baidu.tieba.ala.liveroom.j.b hmo;
    private LinearLayout hoT;
    private e hoU;
    private boolean hoV;
    private boolean hoW;
    private com.baidu.tieba.ala.liveroom.apppromotion.a hoY;
    private com.baidu.live.follow.pendant.a hoZ;
    private LinearLayout hpa;
    private long lastClickTime = 0;
    private int agE = 0;
    private boolean hoX = false;
    private HttpRule hmp = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.hlZ != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.hlZ.zW()) {
                httpMessage.addParam("ala_challenge_id", d.this.hlZ.zZ());
            }
            return httpMessage;
        }
    };
    private HttpRule hmq = new HttpRule(1021229) { // from class: com.baidu.tieba.ala.liveroom.d.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.hlZ != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.hlZ.zW()) {
                httpMessage.addParam("challenge_id", d.this.hlZ.zZ());
            }
            return httpMessage;
        }
    };
    private HttpRule hmr = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.hlZ != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.hlZ.zW()) {
                httpMessage.addParam("challenge_id", d.this.hlZ.zZ());
            }
            return httpMessage;
        }
    };
    private HttpRule hms = new HttpRule(1021232) { // from class: com.baidu.tieba.ala.liveroom.d.d.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.hlZ != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.hlZ.zW()) {
                httpMessage.addParam("challenge_id", d.this.hlZ.zZ());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c hmt = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.d.23
        @Override // com.baidu.live.liveroom.g.c
        public void LF() {
            if (d.this.hmZ != null) {
                d.this.hmZ.oI(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cz(boolean z) {
            if (z) {
                if (d.this.hmZ != null) {
                    d.this.hmZ.oI(true);
                }
            } else if (d.this.hmZ != null) {
                d.this.hmZ.oI(false);
            }
            if (d.this.hns != null) {
                d.this.hns.by(z);
            }
            if (d.this.hlX != null) {
                d.this.hlX.ny(z ? false : true);
            }
            com.baidu.live.q.a.cA(z);
        }
    };
    private HttpMessageListener hmx = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.d.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.MY() != null) {
                        com.baidu.live.af.e.OY().bxA = getQuickGiftHttpResponseMessage.MY();
                        d.this.bZq();
                    }
                }
            }
        }
    };
    CustomMessageListener hmD = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.d.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.hmo.c(d.this.caO());
                } else if (d.this.bZY() || !g.vq(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.27.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.caO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.caO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    d.this.hmo.c(d.this.hmf, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener hmy = new CustomMessageListener(2913276) { // from class: com.baidu.tieba.ala.liveroom.d.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            JSONObject optJSONObject;
            JSONArray optJSONArray;
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject) && (optJSONObject = ((JSONObject) customResponsedMessage.getData()).optJSONObject("ext_data")) != null && (optJSONArray = optJSONObject.optJSONArray("surprise_prize_member")) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                View inflate = LayoutInflater.from(d.this.activity).inflate(a.g.ala_fudai_dialog_layout, (ViewGroup) null);
                final Dialog dialog = new Dialog(d.this.caO().pageContext.getPageActivity(), a.i.FudaiDialogStyle);
                dialog.requestWindowFeature(1);
                dialog.setContentView(inflate);
                dialog.setCancelable(false);
                View findViewById = inflate.findViewById(a.f.ala_fudai_negative_btn);
                View findViewById2 = inflate.findViewById(a.f.ala_fudai_positive_btn);
                TextView textView = (TextView) inflate.findViewById(a.f.ala_fudai_tbean_num);
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.d.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.d.2.2
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
    private CustomMessageListener hpb = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.d.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.bZY() || !g.vq(2913128)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.vo(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    d.this.GY(str);
                }
            }
        }
    };
    private CustomMessageListener hmz = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.hnh.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hmA = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.this.hnv != null) {
                    d.this.hnv.gT(str);
                }
            }
        }
    };
    CustomMessageListener hmB = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.d.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.hnW != null && d.this.hnW.bfP != null && !d.this.hnW.bfU && !d.this.hnW.bfV && d.this.hnr != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.caO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                if (d.this.hne != null && d.this.hne.IH().KN()) {
                    layoutParams.bottomMargin = d.this.caO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds88);
                } else {
                    layoutParams.bottomMargin = d.this.caO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                }
                d.this.hnr.c(d.this.hmf, layoutParams);
                if (com.baidu.live.guardclub.e.HC() != null) {
                    com.baidu.live.guardclub.e.HC().HH();
                }
            }
        }
    };
    private CustomMessageListener hmC = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.d.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.hnt != null) {
                    d.this.hnt.dismiss();
                }
                if (d.this.hnv != null) {
                    d.this.hnv.dismiss();
                }
                if (d.this.hba != null) {
                    d.this.hba.dismiss();
                }
                com.baidu.live.im.b.d.Jp().setSwitchStatus(true);
                com.baidu.live.im.b.d.Jp().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.caf();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b hmE = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.d.19
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void v(View view, int i) {
            bq bqVar;
            String str;
            String str2;
            bq bqVar2;
            ch chVar;
            String str3;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - d.this.lastClickTime >= 300) {
                d.this.lastClickTime = currentTimeMillis;
                if (i == 2) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel"));
                    d.this.P(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.af.e.OY().bxA.DC().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.af.e.OY().bxA.DC().CC());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.af.e.OY().bxA.DC().CD());
                        if (d.this.caO().hxj.DW() != null && d.this.caO().hxj.DW().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.caO().hxj.DW().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.caO().hxj.DW().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.JQ());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.GJ()) {
                        if (com.baidu.live.d.xf().getBoolean("quick_gift_guide_show", true) && !d.this.bZY()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, ah.class, d.this.caO().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                ah ahVar = (ah) runTask.getData();
                                ahVar.setPageContext(d.this.caO().pageContext);
                                ahVar.setLiveShowData(d.this.caO().hxj.DW());
                                ahVar.setGiftItem(com.baidu.live.af.e.OY().bxA.DC());
                                ahVar.setOtherParams(d.this.JQ());
                                ahVar.initView();
                                ahVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.d.d.19.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        d.this.nE(false);
                                    }
                                });
                                ahVar.show();
                                d.this.nE(true);
                                return;
                            }
                            return;
                        }
                        n.a(d.this.caO().pageContext, d.this.caO().hxj.DW(), com.baidu.live.af.e.OY().bxA.DC(), d.this.JQ());
                    }
                } else if (i == 1) {
                    if (d.this.hne != null) {
                        d.this.caf();
                    }
                } else if (i == 3 && d.this.GJ()) {
                    if (com.baidu.live.q.a.isDebug()) {
                        com.baidu.live.q.a.c(d.this.caO().hxj.DW().mLiveInfo.live_id, 0);
                        return;
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    d.this.hmR.d(d.this.caO().hxj.DW(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.caO() != null && d.this.caO().hxj != null && d.this.caO().hxj.DW() != null && d.this.caO().hxj.DW().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.caO().hxj.DW().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.caO().hxj.DW().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.caO().hxj.DW().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.JQ());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.caO() != null && d.this.caO().hxj != null && d.this.caO().hxj.DW() != null && d.this.caO().hxj.DW().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.caO().hxj.DW().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.caO().hxj.DW().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.caO().hxj.DW().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.JQ());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.bok != null) {
                        d.this.bok.ct(false);
                    }
                } else if (i == 12) {
                    if (d.this.hmZ != null && d.this.caO().hxj.DW() != null && d.this.caO().hxj.DW().mLiveInfo != null) {
                        String valueOf = String.valueOf(d.this.caO().hxj.DW().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.caO().hxj.DW().mLiveInfo.room_id);
                        String str4 = null;
                        AlaLiveSdkInfo alaLiveSdkInfo = d.this.caO().hxj.DW().mLiveSdkInfo;
                        if (alaLiveSdkInfo != null && alaLiveSdkInfo.mCastIds != null) {
                            str4 = String.valueOf(d.this.caO().hxj.DW().mLiveSdkInfo.mCastIds.chatMCastId);
                        }
                        d.this.hmZ.aw(valueOf, valueOf2, str4);
                        com.baidu.live.q.a.c(d.this.caO().hxj.DW().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    x DW = d.this.caO().hxj.DW();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.caO().pageContext.getPageActivity(), DW.aFH.userName, Long.toString(DW.aFH.userId), Long.toString(DW.aFH.charmCount), String.valueOf(DW.mLiveInfo.group_id), String.valueOf(DW.mLiveInfo.live_id), false, String.valueOf(DW.aFH.userId), Long.toString(DW.aGd.userId), DW.aGd.userName, DW.aGd.portrait, d.this.hlV.getCount(), d.this.JQ())));
                    LogManager.getCommonLogger().doClickGusetNumLog(DW.mLiveInfo.feed_id, d.this.hlV.getCount() + "", d.this.JQ());
                } else if (i == 11) {
                    d.this.cak();
                    d.this.cal();
                } else if (i == 16) {
                    if (d.this.caO() != null && (bqVar2 = com.baidu.live.af.a.OJ().bxp) != null && (chVar = bqVar2.aMO) != null) {
                        String str5 = chVar.aOr.aOB;
                        if (!TextUtils.isEmpty(str5)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (d.this.caO().hxj != null && d.this.caO().hxj.DW() != null && d.this.caO().hxj.DW().mLiveInfo != null) {
                                j = d.this.caO().hxj.DW().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", d.this.caO().hxj.DW().mLiveInfo.room_id + "", d.this.caO().hxj.DW().mLiveInfo.feed_id, d.this.JQ());
                            }
                            if (str5.contains("?")) {
                                str3 = str5 + "&liveId=" + j;
                            } else {
                                str3 = str5 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.caO().pageContext.getPageActivity(), str3);
                        }
                    }
                } else if (i == 20) {
                    if (d.this.caO() != null) {
                        x xVar = null;
                        if (d.this.caO().hxj != null) {
                            xVar = d.this.caO().hxj.DW();
                        }
                        if (xVar != null && xVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.v.b.cjy().brD != null) {
                            String str6 = com.baidu.tieba.ala.liveroom.v.b.cjy().brD.aEU;
                            if (!TextUtils.isEmpty(str6)) {
                                if (str6.contains("?")) {
                                    str2 = str6 + "&live_id=" + xVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str2 = str6 + "?live_id=" + xVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(d.this.caO().pageContext.getPageActivity(), str2)));
                            }
                        }
                    }
                } else if (i == 17 && d.this.GJ() && d.this.caO() != null && (bqVar = com.baidu.live.af.a.OJ().bxp) != null && bqVar.aMO != null && (str = bqVar.aMO.aOy) != null) {
                    cn cnVar = new cn(str);
                    if (!TextUtils.isEmpty(cnVar.webUrl)) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                        if (d.this.hnt != null && d.this.caO().hxj != null && d.this.caO().hxj.DW() != null) {
                            x DW2 = d.this.caO().hxj.DW();
                            d.this.hnt.b(cnVar.webUrl, DW2.mLiveInfo.live_id, DW2.aGd.userId, DW2.aFH.userId);
                        }
                    }
                }
            }
        }
    };
    private boolean hpc = false;
    private boolean hpd = false;

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
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void m(x xVar) {
        super.m(xVar);
        g.ceq();
        this.hoX = true;
        this.hpd = false;
        this.hpc = false;
        caO().hxk.setIsForceHandledTouch(false);
        caO().hxk.setSwipeClearEnable(true);
        caO().hxk.setOnLiveViewScrollListener(this.hmt);
        caO().hxk.setOnClickListener(null);
        caO().hxk.setClickable(false);
        if (this.hmW != null) {
            this.hmW.b(this.hmE);
        }
        if (this.hnP != null) {
            this.hnP.setVisibility(0);
        }
        bZi();
        if (this.hnp != null) {
            this.hnp.a(xVar, this.buY);
            this.hnp.U(this.hnQ);
            this.hnp.a(this);
        }
        cbl();
        bZu();
        bZU();
        bZT();
        bZv();
        bZz();
        bZw();
        cba();
        nF(false);
        bZr();
        bZs();
        can();
        bZE();
        cap();
        bZB();
        bZC();
        cbd();
        cbe();
        cav();
        nH(false);
        cas();
        caw();
        bZg();
        caG();
        bZk();
        bZq();
        bZl();
        bZm();
        bZn();
        bZo();
        bZc();
        cau();
        caC();
        cao();
        cat();
        nL(true);
        caF();
        c(this.goI);
        bZh();
        cbb();
        caB();
        bZX();
        cbc();
        MessageManager.getInstance().registerListener(this.hmx);
        MessageManager.getInstance().registerListener(this.hmz);
        MessageManager.getInstance().registerListener(this.hmB);
        MessageManager.getInstance().registerListener(this.hmC);
        MessageManager.getInstance().registerListener(this.hpb);
        MessageManager.getInstance().registerListener(this.hmD);
        MessageManager.getInstance().registerListener(this.hmA);
        MessageManager.getInstance().registerListener(this.hmy);
        bZF();
        bZy();
        car();
    }

    private void cba() {
    }

    private void cbb() {
        AlaVideoBCChatData alaVideoBCChatData;
        CustomResponsedMessage runTask;
        AlaLiveUserInfoData alaLiveUserInfoData = caO().hxj.DW().aGd;
        if (alaLiveUserInfoData != null && (alaVideoBCChatData = alaLiveUserInfoData.videoBCEnterData) != null && alaVideoBCChatData.isShowEnter()) {
            if (this.hnN == null && (runTask = MessageManager.getInstance().runTask(2913255, com.baidu.live.ao.c.class, caO().pageContext)) != null && runTask.getData() != null) {
                this.hnN = (com.baidu.live.ao.c) runTask.getData();
            }
            if (this.hnN != null) {
                this.hnN.a(caO().bon);
                this.hnN.b(caO().hxi.getMastView());
                this.hnN.r(caO().hxj.DW());
                this.hnN.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.24
                    @Override // com.baidu.live.ao.c.a
                    public void TY() {
                        if (d.this.hmW != null) {
                            d.this.caO().hxk.hMO = false;
                            d.this.hmW.setPraiseEnable(false);
                            if (d.this.caO().hxl != null) {
                                d.this.caO().hxl.setTalentShowing(true);
                            }
                        }
                    }

                    @Override // com.baidu.live.ao.c.a
                    public void TZ() {
                        if (d.this.hmW != null) {
                            d.this.caO().hxk.hMO = true;
                            d.this.hmW.setPraiseEnable(true);
                            if (d.this.caO().hxl != null) {
                                d.this.caO().hxl.setTalentShowing(false);
                            }
                        }
                    }
                });
                View enterView = this.hnN.getEnterView();
                if (enterView != null) {
                    if (enterView.getParent() != null) {
                        ((ViewGroup) enterView.getParent()).removeView(enterView);
                    }
                    this.hmO.cz(enterView);
                }
            }
        }
    }

    public void cbc() {
        this.hoZ = new com.baidu.live.follow.pendant.a(getActivity());
    }

    private void bZc() {
        if (this.hnF != null) {
            this.hnF.a(new com.baidu.live.aa.c() { // from class: com.baidu.tieba.ala.liveroom.d.d.25
                @Override // com.baidu.live.aa.c
                public void cG(boolean z) {
                    if (d.this.hma != null) {
                        d.this.hma.setNeedCloseRecommendFloat(z);
                    }
                    if (d.this.caO().hxk.hMO) {
                        if (d.this.hmZ != null) {
                            d.this.hmZ.oA(z);
                            d.this.hmZ.oI(!z);
                        }
                        if (d.this.hmW != null) {
                            d.this.hmW.oA(z);
                            d.this.hmW.setPraiseEnable(!z);
                            d.this.hmW.oz(z ? false : true);
                        }
                    }
                }
            });
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
        if (this.hoZ != null) {
            if (this.hoZ.d(xVar) && !this.hoZ.isDisplay()) {
                cbm();
                this.hoV = true;
                this.hoW = true;
                if (this.hnB != null) {
                    this.hnB.aW(true);
                    this.hnB.aX(true);
                }
                if (this.hmW != null) {
                    this.hmW.setPraiseEnable(false);
                    caO().hxk.hMO = false;
                }
                cbf();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.topMargin = (int) getActivity().getResources().getDimension(a.d.sdk_ds16);
                ag agVar = xVar.aGS;
                if (agVar != null) {
                    this.hoZ.m(agVar.anchorPortrait, agVar.aFc, String.valueOf(agVar.aHi));
                    this.hoZ.b(cbs(), layoutParams);
                }
            } else if (!this.hoZ.d(xVar) && this.hoZ.isDisplay()) {
                this.hoZ.Cc();
                this.hoV = false;
                this.hoW = false;
                if (this.hnB != null) {
                    this.hnB.aW(false);
                    this.hnB.aX(false);
                }
                if (this.hmW != null) {
                    this.hmW.setPraiseEnable(true);
                    caO().hxk.hMO = true;
                }
                cbf();
                if (this.hpa != null) {
                    this.hpa.removeAllViews();
                    this.hpa = null;
                }
            }
        }
        nL(false);
        if (this.hlX != null) {
            this.hlX.j(xVar);
            this.hlX.nx(this.hnZ);
            this.hlX.updateView();
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

    private void bZe() {
        if (this.hmY != null) {
            this.hmY.aJ(caO().hxi.getLiveContainerView());
        }
    }

    private void cbd() {
        if (this.hmb == null) {
            this.hmb = new com.baidu.tieba.ala.liveroom.c.a(caO().pageContext);
        }
        if (caO().hxj != null && caO().hxj.DW() != null && caO().hxj.DW().mLiveInfo != null) {
            this.hmb.GS(String.valueOf(caO().hxj.DW().mLiveInfo.user_id));
        }
    }

    private void cbe() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (caO() != null && caO().hxj != null && caO().hxj.DW() != null && caO().hxj.DW().mLiveInfo != null) {
                j = caO().hxj.DW().mLiveInfo.room_id;
            }
            if (this.hnm == null) {
                this.hnm = new com.baidu.tieba.ala.liveroom.guide.a(caO().pageContext, j);
            }
            this.hnm.nD(this.hnS);
            this.hnm.a(new a.InterfaceC0664a() { // from class: com.baidu.tieba.ala.liveroom.d.d.8
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0664a
                public void cbt() {
                    if (d.this.bok != null) {
                        d.this.bok.ct(true);
                    }
                }
            });
            this.hnm.aF(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cs(int i) {
        super.cs(i);
        bZe();
        if (this.hma != null) {
            this.hma.cs(i);
        }
    }

    private void bZi() {
        if (this.buY == null) {
            this.buY = new PendantParentView(caO().pageContext.getPageActivity(), cbg());
            caO().hxk.addView(this.buY, new ViewGroup.LayoutParams(-1, -1));
            this.buY.setDefaultItemMargin(caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.buY.setPadding(caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            cbf();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void nA(boolean z) {
        if (z) {
            this.agE = caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds180);
        } else {
            this.agE = caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
        }
        cbf();
    }

    private void cbf() {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        if (this.buY != null) {
            this.buY.setModel(cbg());
            int dimensionPixelSize3 = caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds220);
            if (this.agE != 0) {
                dimensionPixelSize = this.agE;
            } else {
                dimensionPixelSize = caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            }
            if (this.gNL) {
                dimensionPixelSize2 = cbq();
            } else {
                dimensionPixelSize2 = caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds250);
            }
            this.buY.setPosition(dimensionPixelSize3, 0, dimensionPixelSize2, dimensionPixelSize);
            return;
        }
        bZi();
    }

    private PendantParentView.Model cbg() {
        if (this.gNL) {
            return PendantParentView.Model.VERTICAL_PK;
        }
        if (this.hoV) {
            return PendantParentView.Model.VERTICAL_BB_CHATING;
        }
        return PendantParentView.Model.VERTICAL;
    }

    private void cbh() {
        if (caO().hxk != null && !this.hpd) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.9
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.hmf != null && d.this.hne != null && d.this.hne.IF() != null && d.this.hne.IF().getView() != null) {
                        if (d.this.gNL && !d.this.hnT && d.this.caO().hxk != null && d.this.caO().hxk.getHeight() > 0 && !d.this.hoW) {
                            int bn = d.this.hma != null ? d.this.hma.bn(false) : 0;
                            ViewGroup.LayoutParams layoutParams = d.this.hmf.getLayoutParams();
                            int height = d.this.caO().hxk.getHeight() - bn;
                            int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                i += UtilHelper.getStatusBarHeight();
                            }
                            if (layoutParams != null && d.this.hne != null) {
                                layoutParams.height = i + d.this.caO().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                                d.this.hmf.setLayoutParams(layoutParams);
                                ViewGroup.LayoutParams layoutParams2 = d.this.hne.IF().getView().getLayoutParams();
                                if (layoutParams2 != null) {
                                    layoutParams2.height = layoutParams.height - com.baidu.live.al.c.dk(false);
                                    d.this.hne.IF().getView().setLayoutParams(layoutParams2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        int i2 = com.baidu.live.al.c.i(false, d.this.hnT);
                        if (d.this.hnQ.indexOfChild(d.this.hmf) != -1 && d.this.hmf.getLayoutParams() != null) {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) d.this.hmf.getLayoutParams();
                            layoutParams3.height = com.baidu.live.al.c.d(false, false, d.this.hnT);
                            d.this.hmf.setLayoutParams(layoutParams3);
                        }
                        if (d.this.hmf.indexOfChild(d.this.hne.IF().getView()) != -1 && d.this.hne.IF().getView().getLayoutParams() != null) {
                            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) d.this.hne.IF().getView().getLayoutParams();
                            layoutParams4.height = i2;
                            d.this.hne.IF().getView().setLayoutParams(layoutParams4);
                        }
                        d.this.hne.IF().IE();
                    }
                }
            });
        }
    }

    private void cbi() {
        if (caO().hxk != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.10
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.hng != null) {
                        if (d.this.gNL && !d.this.hnT && d.this.caO().hxk != null && d.this.caO().hxk.getHeight() > 0) {
                            int height = (d.this.caO().hxk.getHeight() - (d.this.hma != null ? d.this.hma.bn(false) : 0)) + d.this.caO().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            if (d.this.hng != null) {
                                d.this.hng.cC(height);
                            }
                        } else if (d.this.hng != null) {
                            d.this.hng.cC(com.baidu.live.al.a.b(d.this.caO().pageContext.getPageActivity(), false, false, d.this.hnT));
                        }
                    }
                }
            });
        }
    }

    private void cbj() {
        if (caO().hxk != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.11
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    if (d.this.hng != null) {
                        int h = com.baidu.live.al.a.h(false, false);
                        if (!d.this.gNL || d.this.caO().hxk == null || d.this.caO().hxk.getHeight() <= 0) {
                            i = h;
                        } else {
                            int height = d.this.caO().hxk.getHeight() - (d.this.hma != null ? d.this.hma.bn(false) : 0);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            i = height + d.this.caO().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                        }
                        if (d.this.hng != null) {
                            d.this.hng.cD(i);
                        }
                    }
                }
            });
        }
    }

    private void cbk() {
        if (this.hnf != null && this.hnf.zf() != null) {
            ViewGroup.LayoutParams layoutParams = this.hnf.zf().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = caO().pageContext.getResources().getDimensionPixelOffset(this.gNL ? a.d.sdk_ds100 : a.d.sdk_ds20);
                this.hnf.zf().setLayoutParams(layoutParams);
            }
        }
    }

    private void cbl() {
        if (this.hoT == null) {
            this.hoT = new LinearLayout(caO().pageContext.getPageActivity());
            this.hoT.setOrientation(1);
        }
        if (this.hoT.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds160);
            layoutParams.leftMargin = caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            caO().hxk.addView(this.hoT, layoutParams);
        }
    }

    private void cbm() {
        List<cq.a> list;
        if (cbs() == null && caO() != null && caO().hxi != null && caO().hxi.getMastView() != null && caO().hxj != null && caO().pageContext != null && caO().pageContext.getResources() != null) {
            com.baidu.live.af.a OJ = com.baidu.live.af.a.OJ();
            if (OJ.bru != null && OJ.bru.aKG != null && (list = com.baidu.live.af.a.OJ().bru.aKG.dataList) != null && list.size() >= 2) {
                cq.a aVar = list.get(1) == null ? cq.a.aPM.get(1) : list.get(1);
                int i = com.baidu.live.af.a.OJ().bru.aKG.aPI;
                int i2 = com.baidu.live.af.a.OJ().bru.aKG.aPJ;
                DisplayMetrics displayMetrics = caO().pageContext.getResources().getDisplayMetrics();
                int i3 = displayMetrics.widthPixels;
                int i4 = displayMetrics.heightPixels;
                if (this.activity != null && com.baidu.live.utils.d.bd(this.activity)) {
                    i4 += com.baidu.live.utils.d.bi(this.activity);
                }
                int i5 = (((i * i4) / i2) - i3) / 2;
                int i6 = (aVar.width * i4) / i2;
                int i7 = ((aVar.x * i4) / i2) - i5;
                int i8 = (aVar.height * i4) / i2;
                int i9 = (aVar.y * i4) / i2;
                if (this.hpa == null) {
                    this.hpa = new LinearLayout(caO().pageContext.getPageActivity());
                    this.hpa.setOrientation(1);
                }
                if (this.hpa.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i7 < 0 ? i6 + i7 : i6, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(9);
                    layoutParams.topMargin = i9 + i8;
                    if (!UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams.topMargin += UtilHelper.getImmersiveStickyBarHeight();
                    } else if (com.baidu.live.utils.d.TE() && this.activity != null) {
                        layoutParams.topMargin += com.baidu.live.utils.d.bi(this.activity);
                    }
                    layoutParams.leftMargin = i7 < 0 ? 0 : i7;
                    caO().hxi.getMastView().addView(this.hpa, layoutParams);
                }
            }
        }
    }

    private void bZk() {
        if (this.hlX == null) {
            this.hlX = new com.baidu.tieba.ala.liveroom.activeview.b(caO().pageContext);
        }
        if (caO() != null && caO().hxj != null) {
            this.hlX.GO(caO().hxj.ciK());
        }
        this.hlX.aW(this.gNL);
        this.hlX.setOtherParams(JQ());
        this.hlX.c(caO().hxj.DW(), false);
        this.hlX.setHost(false);
        this.hlX.nx(this.hnZ);
        this.hlX.a(1, this.buY);
        this.hlX.a(2, this.buY);
        this.hlX.setVisible(this.hnT ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZq() {
        if (this.hmO == null) {
            bZw();
        }
        this.hmO.setOtherParams(JQ());
        this.hmO.a(com.baidu.live.af.e.OY().bxA, caO().hxj.DW());
    }

    private void bZl() {
        if (this.hlW == null) {
            this.hlW = new com.baidu.tieba.ala.liveroom.l.a(caO().pageContext, this);
        }
        this.hlW.setOtherParams(JQ());
        this.hlW.a((ViewGroup) this.buY, bZp());
        this.hlW.L(caO().hxj.DW());
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
            this.hnB.aW(this.gNL);
            this.hnB.aY(false);
            this.hnB.a(bZK(), caO().hxj.DW());
            this.hnB.setIsHost(false);
            this.hnB.a(new a.InterfaceC0154a() { // from class: com.baidu.tieba.ala.liveroom.d.d.13
                @Override // com.baidu.live.a.a.InterfaceC0154a
                public void xl() {
                    d.this.cbn();
                }

                @Override // com.baidu.live.a.a.InterfaceC0154a
                public void xm() {
                    d.this.cbo();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbn() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbo() {
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
            this.hmO.a(new a.InterfaceC0670a() { // from class: com.baidu.tieba.ala.liveroom.d.d.14
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0670a
                public void bR(int i, int i2) {
                    x DW = d.this.caO().hxj.DW();
                    if (DW != null && DW.mLiveInfo != null) {
                        if (d.this.hnu == null) {
                            d.this.hnu = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.caO().pageContext.getPageActivity());
                        }
                        d.this.hnu.d(d.this.hnQ, i, i2);
                        d.this.hnu.a(String.valueOf(DW.mLiveInfo.live_id), new a.InterfaceC0674a() { // from class: com.baidu.tieba.ala.liveroom.d.d.14.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0674a
                            public void a(float f, String str) {
                                if (d.this.hmO != null) {
                                    d.this.hmO.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0670a
                public void bS(int i, int i2) {
                    if (d.this.hnu != null) {
                        d.this.hnu.bX(i, i2);
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
            this.hmo = new com.baidu.tieba.ala.liveroom.j.b(caO().pageContext, JQ(), this.hof, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.15
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bZN() {
                    d.this.nE(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bZO() {
                    d.this.nE(false);
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

    private void bZE() {
        if (this.hoY == null) {
            this.hoY = new com.baidu.tieba.ala.liveroom.apppromotion.a(caO().pageContext);
        }
        this.hoY.b(bZK(), caO().hxj.DW());
    }

    private LinearLayout.LayoutParams bZp() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    private void bZr() {
        CustomResponsedMessage runTask;
        if (this.hne == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, caO().pageContext)) != null && runTask.getData() != null) {
            this.hne = (k) runTask.getData();
            this.hne.setFromMaster(false);
            this.hne.IF().getView().setId(a.f.ala_liveroom_msg_list);
            this.hne.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.16
                @Override // com.baidu.live.im.k.a
                public boolean IJ() {
                    return d.this.GJ();
                }

                @Override // com.baidu.live.im.k.a
                public void IK() {
                    d.this.hnX = true;
                }

                @Override // com.baidu.live.im.k.a
                public void gD(String str) {
                    if (!d.this.hnT) {
                        d.this.nC(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.caO().pageContext.getPageActivity(), d.this.caO().hxi.getLiveContainerView());
                    }
                    d.this.GV(str);
                }

                @Override // com.baidu.live.im.k.a
                public void IL() {
                    if (d.this.hnT) {
                        d.this.nC(true);
                        d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.16.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.caO().pageContext.getPageActivity(), d.this.caO().hxi.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.hne != null) {
                        d.this.hne.IG().setQuickInputPanelVisible(false);
                        d.this.hne.IG().KB();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void IM() {
                }

                @Override // com.baidu.live.im.k.a
                public void IN() {
                    if (d.this.hnT) {
                        d.this.bZM();
                        if (d.this.hnf != null) {
                            d.this.hnf.zg();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean IO() {
                    return d.this.bZZ();
                }

                @Override // com.baidu.live.im.k.a
                public int IP() {
                    return d.this.caa();
                }

                @Override // com.baidu.live.im.k.a
                public boolean IQ() {
                    x DW = d.this.caO().hxj.DW();
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
            int i = com.baidu.live.al.c.i(false, false);
            if (this.hnQ.indexOfChild(this.hmf) < 0) {
                if (this.hmf.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hmf.getParent()).removeView(this.hmf);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.live.al.c.d(false, false, false));
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.live.al.c.dj(false);
                this.hnQ.addView(this.hmf, layoutParams);
            }
            if (this.hmf.indexOfChild(this.hne.IF().getView()) < 0) {
                if (this.hne.IF().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hne.IF().getView()).removeView(this.hne.IF().getView());
                }
                this.hmf.addView(this.hne.IF().getView(), new FrameLayout.LayoutParams(equipmentWidth, i));
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
            this.hne.a(String.valueOf(caO().hxj.DW().mLiveInfo.group_id), String.valueOf(caO().hxj.DW().mLiveInfo.last_msg_id), String.valueOf(caO().hxj.DW().aFH.userId), String.valueOf(caO().hxj.DW().mLiveInfo.live_id), caO().hxj.DW().aFH.appId, (DW == null || DW.aGv == null || !DW.aGv.Av()) ? false : true, caO().hxj.DW().getGuardName());
            nC(false);
        }
    }

    private void bZu() {
        if (this.hlS == null) {
            this.hlS = new com.baidu.tieba.ala.liveroom.o.a(caO().pageContext, false, this);
        }
        this.hlS.e(this.hnP, caO().hxj.DW());
        this.hlS.a(this.hmE);
        this.hlS.setOtherParams(JQ());
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
            this.hlR.setOtherParams(JQ());
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

    private void bZs() {
        cag();
    }

    public void nK(boolean z) {
        if (this.hmO != null) {
            this.hmO.nK(z);
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

    protected void GY(String str) {
        if (this.hoe == null) {
            this.hoe = new com.baidu.tieba.ala.liveroom.t.b(caO().pageContext);
        }
        this.hoe.c(this.hnQ, str);
        nE(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.17
            @Override // java.lang.Runnable
            public void run() {
                d.this.hoe.cjl();
                d.this.nE(false);
            }
        }, 5000L);
    }

    private void nL(boolean z) {
        CustomResponsedMessage runTask;
        if (caO().hxj.DW().mLiveInfo.live_type == 1 && this.hoX) {
            if (this.hoU == null && (runTask = MessageManager.getInstance().runTask(2913074, e.class, caO().pageContext)) != null && runTask.getData() != null) {
                this.hoU = (e) runTask.getData();
            }
            if (this.hoU != null) {
                if (this.hlZ == null) {
                    this.hlZ = this.hoU.a(caO().pageContext);
                }
                if (z) {
                    this.hlZ.zP();
                }
                if (caO().hxj.DW().mLiveInfo.challengeId > 0 && !this.hlZ.zX()) {
                    this.hlZ.h(caO().hxj.DW().mLiveInfo.live_id, caO().hxj.DW().aFH.userId);
                    nM(z);
                    if (z) {
                        this.hlZ.a(caO().hxj.chR());
                    }
                    this.hlZ.c(caO().hxj.DW());
                }
            }
        }
    }

    private void nM(boolean z) {
        if (this.hma == null) {
            this.hma = this.hoU.b(caO().pageContext);
            this.hma.a(new com.baidu.live.challenge.g() { // from class: com.baidu.tieba.ala.liveroom.d.d.18
                @Override // com.baidu.live.challenge.g
                public void zL() {
                    d.this.caO().hxk.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.g
                public void a(bc bcVar, bg bgVar, bg bgVar2) {
                    d.this.gNL = true;
                    d.this.Vv();
                    if (d.this.caO().bon != null) {
                        d.this.caO().bon.getLivePlayer().setBackgroundResource(a.c.sdk_transparent);
                    }
                    if (d.this.hmU != null) {
                        d.this.hmU.setTimeTextMode(true);
                    }
                    if (d.this.bok != null && bgVar != null && bgVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(bgVar.aLZ);
                        arrayList.add(bgVar2.aLZ);
                        com.baidu.live.liveroom.a.c cVar = d.this.bok;
                        if (d.this.hob) {
                            arrayList = null;
                        }
                        cVar.j(arrayList);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void zM() {
                }

                @Override // com.baidu.live.challenge.g
                public void zN() {
                }

                @Override // com.baidu.live.challenge.g
                public void bl(boolean z2) {
                    d.this.caO().hxk.setSwipeClearEnable(true);
                    d.this.gNL = false;
                    d.this.cbp();
                    if (d.this.bok != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.caO().hxj.ciG());
                        com.baidu.live.liveroom.a.c cVar = d.this.bok;
                        if (d.this.hob) {
                            arrayList = null;
                        }
                        cVar.j(arrayList);
                    }
                    if (d.this.caO().bon != null) {
                        d.this.caO().bon.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
                    }
                    if (d.this.hmU != null) {
                        d.this.hmU.setTimeTextMode(false);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void bm(boolean z2) {
                    if (z2 && d.this.hnF != null) {
                        d.this.hnF.onClose();
                    }
                }
            });
        }
        this.hma.a(this.hlZ);
        this.hma.k(caO().hxi.getLiveContainerView());
        this.hma.c(z, false, false);
        this.hlZ.a((i.c) this.hma);
    }

    protected void Vv() {
        if (this.hmV != null) {
            this.hmV.vb(8);
        }
        if (this.hmW != null) {
            this.hmW.setPraiseEnable(false);
            caO().hxk.hMO = false;
        }
        if (this.hnA != null) {
            this.hnA.setCanVisible(false);
        }
        if (this.hmX != null) {
            this.hmX.cjw();
        }
        if (this.hlW != null) {
            this.hlW.setCanVisible(false);
            this.hlW.ceu();
        }
        if (this.hlX != null) {
            this.hlX.aW(true);
        }
        if (this.hof != null) {
            this.hof.setVisible(8);
        }
        if (this.hlY != null) {
            this.hlY.setCanVisible(false);
            this.hlY.setVisible(8);
        }
        if (this.hnB != null) {
            this.hnB.aW(true);
            this.hnB.aX(true);
        }
        cbf();
        cbh();
        cbi();
        cbj();
        cbk();
    }

    protected void cbp() {
        if (this.hmV != null) {
            this.hmV.vb(0);
        }
        if (this.hmW != null) {
            this.hmW.setPraiseEnable(true);
            caO().hxk.hMO = true;
        }
        if (this.hnA != null) {
            this.hnA.setCanVisible(true);
        }
        if (this.hmX != null) {
            this.hmX.cjx();
        }
        if (this.hlW != null) {
            this.hlW.setCanVisible(true);
            this.hlW.L(caO().hxj.DW());
        }
        if (this.hmZ != null) {
            this.hmZ.oI(true);
        }
        if (this.hlX != null) {
            this.hlX.aW(false);
        }
        if (this.hof != null) {
            this.hof.setVisible(0);
        }
        if (this.hlY != null) {
            this.hlY.setCanVisible(true);
            this.hlY.setVisible(0);
        }
        if (this.hnB != null) {
            this.hnB.aW(false);
            this.hnB.aX(false);
        }
        cbf();
        cbh();
        cbi();
        cbj();
        cbk();
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

    private int cbq() {
        return (this.hma != null ? this.hma.bn(false) : 0) - BdUtilHelper.getStatusBarHeight(this.activity);
    }

    private void bZC() {
        boolean z = true;
        if (this.hmZ == null) {
            this.hmZ = new com.baidu.tieba.ala.liveroom.w.a(caO().pageContext, this);
        }
        this.hmZ.c(caO().hxk, false);
        AlaLiveInfoData alaLiveInfoData = caO().hxj.DW().mLiveInfo;
        if (alaLiveInfoData != null) {
            boolean z2 = caN() && alaLiveInfoData.screen_direction != 2;
            boolean isZanAnimUnabled = alaLiveInfoData.mAlaLiveSwitchData != null ? alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled() : false;
            if (!z2 || isZanAnimUnabled) {
                z = false;
            }
            this.hmZ.oH(z);
        }
    }

    private void bZF() {
        if (this.hnX || this.hnY) {
            if ((TbadkCoreApplication.isLogin() && this.hne.IG().hasText()) || this.hnY) {
                this.hnX = false;
                this.hnY = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.20
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.caf();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void bZx() {
        bZy();
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

    /* JADX WARN: Removed duplicated region for block: B:16:0x003a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
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
            jSONObject = null;
        }
        try {
            jSONObject.put("log_id", bVar.getMsgId());
            jSONObject2 = jSONObject;
        } catch (JSONException e2) {
            jSONObject2 = jSONObject;
            if (bVar.getMsgType() != 12) {
            }
            if (jSONObject2 == null) {
            }
        }
        if (bVar.getMsgType() != 12 || bVar.getMsgType() == 13) {
            if (jSONObject2 == null) {
                String optString = jSONObject2.optString("content_type");
                if ("task".equals(optString)) {
                    if (this.hlW != null) {
                        this.hlW.Q(jSONObject2);
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
                    long optLong = jSONObject2.optLong("mvp_user_id");
                    long optLong2 = jSONObject2.optLong("winner_live_id");
                    if (optLong == caO().hxj.DW().aGd.userId && optLong2 == caO().hxj.DW().mLiveInfo.live_id) {
                        this.hma.f(jSONObject2.optInt("challenge_status"), jSONObject2.optLong("challenge_id"));
                    }
                }
            } else {
                return;
            }
        }
        if (this.hnA == null || this.hnA.V(jSONObject2)) {
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void GQ(String str) {
        if (this.hlX != null) {
            this.hlX.GQ(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hnN != null) {
            this.hnN.onRequestPermissionsResult(i, strArr, iArr);
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
        if (this.hoT != null) {
            this.hoT.removeAllViews();
            this.hoT = null;
        }
        if (this.hpa != null) {
            this.hpa.removeAllViews();
            this.hpa = null;
        }
        if (this.hmZ != null) {
            this.hmZ.onDestroy();
        }
        if (this.hlZ != null) {
            this.hlZ.zH();
        }
        if (this.hlS != null) {
            this.hlS.cfq();
        }
        if (this.hmo != null) {
            this.hmo.cancel();
        }
        if (this.hof != null) {
            this.hof.ccl();
        }
        if (this.hoY != null) {
            this.hoY.xk();
        }
        if (this.hnA != null) {
            this.hnA.xk();
        }
        if (this.hme != null) {
            this.hme.xk();
        }
        if (this.hmo != null) {
            this.hmo.zH();
        }
        if (this.hnJ != null) {
            this.hnJ.zH();
        }
        if (this.hnN != null) {
            this.hnN.PK();
        }
        if (this.hoZ != null && this.hoZ.isDisplay()) {
            this.hoV = false;
            this.hoW = false;
            if (this.hnB != null) {
                this.hnB.aW(false);
                this.hnB.aX(false);
            }
            this.hoZ.Cc();
        }
        if (caO().hxl != null) {
            caO().hxl.setTalentShowing(false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cw(boolean z) {
        super.cw(z);
        bZG();
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
        if (this.hnm != null) {
            this.hnm.onDestroy();
        }
        if (this.hlT != null) {
            this.hlT.onDestroy();
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
        if (this.hlX != null) {
            this.hlX.release();
        }
        if (this.hof != null) {
            this.hof.cw(!z);
        }
        if (this.hme != null) {
            this.hme.onDestroy();
        }
        if (this.hmo != null) {
            this.hmo.onDestroy();
            this.hmo = null;
        }
        if (this.hnJ != null) {
            this.hnJ.onDestroy();
        }
        if (this.hnN != null) {
            this.hnN.onDestroy();
        }
        if (caO().hxl != null) {
            caO().hxl.setTalentShowing(false);
        }
        if (this.hoY != null) {
            this.hoY.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.hmq);
        MessageManager.getInstance().removeMessageRule(this.hmp);
        MessageManager.getInstance().removeMessageRule(this.hmr);
        MessageManager.getInstance().removeMessageRule(this.hms);
        MessageManager.getInstance().unRegisterListener(this.hmx);
        MessageManager.getInstance().unRegisterListener(this.hmz);
        MessageManager.getInstance().unRegisterListener(this.hmB);
        MessageManager.getInstance().unRegisterListener(this.hmC);
        MessageManager.getInstance().unRegisterListener(this.hpb);
        MessageManager.getInstance().unRegisterListener(this.hmD);
        MessageManager.getInstance().unRegisterListener(this.hmA);
        MessageManager.getInstance().unRegisterListener(this.hmy);
    }

    private void bZG() {
        if (this.hne != null && this.hne.IF().getView() != null && this.hne.IF().getView().getParent() != null) {
            ((ViewGroup) this.hne.IF().getView().getParent()).removeView(this.hne.IF().getView());
        }
        if (this.hmf != null && this.hmf.getParent() != null) {
            ((ViewGroup) this.hmf.getParent()).removeView(this.hmf);
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    /* renamed from: cbr */
    public PendantParentView bZK() {
        return this.buY;
    }

    public ViewGroup cbs() {
        return this.hpa;
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
        } else if (i == 25051 && i2 == -1 && this.hof != null) {
            this.hof.cel();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.hne != null && this.hne.IF() != null) {
            this.hne.IF().onKeyboardVisibilityChanged(z);
        }
        if (z || this.hne == null || this.hne.IG() == null || !this.hne.IG().KA()) {
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
                if (this.hnA != null) {
                    this.hnA.setCanVisible(false);
                }
                if (this.hnB != null) {
                    this.hnB.setCanVisible(false);
                }
                if (this.hnC != null) {
                    this.hnC.setCanVisible(false);
                }
                if (this.hnD != null) {
                    this.hnD.setVisible(8);
                }
                if (this.hoY != null) {
                    this.hoY.setCanVisible(false);
                }
                if (this.hnE != null) {
                    this.hnE.setCanVisible(false);
                }
                if (cbs() != null) {
                    cbs().setVisibility(8);
                }
            } else {
                bZL();
            }
            if (this.hns != null) {
                this.hns.bx(z);
            }
            cbh();
        }
    }

    private void bZL() {
        if (this.hmO != null) {
            this.hmO.setVisibility(0);
        }
        if (this.hmf != null) {
            if (this.hpd) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hmf.getLayoutParams();
                layoutParams.bottomMargin = (O(false, false) - caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) + com.baidu.live.al.c.TC();
                this.hmf.setLayoutParams(layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hmf.getLayoutParams();
                layoutParams2.bottomMargin = caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds90);
                this.hmf.setLayoutParams(layoutParams2);
            }
        }
        if (this.hne != null) {
            cai();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hne.IG().getView().getLayoutParams();
            layoutParams3.bottomMargin = 0;
            this.hne.IG().getView().setLayoutParams(layoutParams3);
            if (this.aJV) {
                if (this.hne.IH().isClicked()) {
                    this.hne.IH().cn(false);
                } else {
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
        if (this.hnP != null) {
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
        if (this.hnA != null) {
            this.hnA.setCanVisible(!this.gNL);
        }
        if (this.hnB != null) {
            this.hnB.setCanVisible(true);
        }
        if (this.hoY != null) {
            this.hoY.setCanVisible(true);
        }
        if (this.hnE != null) {
            this.hnE.setCanVisible(true);
        }
        if (cbs() != null) {
            cbs().setVisibility(0);
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
        this.hpc = z;
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
        if (this.mOrientation != i3) {
            if (this.hlR != null) {
                this.hlR.co(i3);
            }
            if (this.hlT != null) {
                this.hlT.co(i3);
            }
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
            if (this.hmO != null) {
                this.hmO.setVisibility(8);
            }
            if (this.hne != null) {
                this.hne.IF().getView().setVisibility(4);
                this.hne.IH().getView().setVisibility(4);
            }
            if (this.hlX != null) {
                this.hlX.bP(2, 8);
                if (this.gNL) {
                    this.hlX.bP(1, 8);
                }
            }
            if (this.hnu != null) {
                this.hnu.oC(false);
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
                if (this.aJV && !this.hne.IH().isClicked()) {
                    this.hne.IH().cn(true);
                }
            }
            if (this.hlX != null) {
                this.hlX.setVisible(0);
            }
            if (this.hnu != null) {
                this.hnu.oC(true);
            }
            this.hnP.setVisibility(0);
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
        if (this.hlY != null) {
            this.hlY.bk(true);
        }
        if (this.hnN != null) {
            this.hnN.onStopped();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.hlU != null) {
            this.hlU.cjm();
        }
        if (this.hlZ != null && this.hoX) {
            this.hlZ.zR();
        }
        if (this.hlX != null) {
            this.hlX.onStart();
        }
        if (this.hlY != null) {
            this.hlY.bk(false);
        }
        if (this.hnN != null) {
            this.hnN.onStarted();
        }
        if (this.hoY != null) {
            this.hoY.onStart();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        if (!onKeyDown && i == 4 && this.hnN != null && this.hnN.onKeyDown(i, keyEvent)) {
            return true;
        }
        return onKeyDown;
    }
}
