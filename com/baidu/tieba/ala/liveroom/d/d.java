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
/* loaded from: classes11.dex */
public class d extends b implements com.baidu.live.n.c {
    private PendantParentView bzK;
    private boolean gSr;
    private com.baidu.tieba.ala.liveroom.g.b hqA;
    private com.baidu.tieba.ala.liveroom.u.b hqB;
    private com.baidu.tieba.ala.liveroom.audiencelist.b hqC;
    private com.baidu.tieba.ala.liveroom.l.a hqD;
    private com.baidu.tieba.ala.liveroom.activeview.b hqE;
    private com.baidu.live.f.a hqF;
    private i hqG;
    private h hqH;
    private com.baidu.tieba.ala.liveroom.c.a hqI;
    private FrameLayout hqM;
    private com.baidu.tieba.ala.liveroom.j.b hqV;
    private com.baidu.tieba.ala.liveroom.audiencelist.c hqy;
    private com.baidu.tieba.ala.liveroom.o.a hqz;
    private e htA;
    private boolean htB;
    private boolean htC;
    private com.baidu.tieba.ala.liveroom.apppromotion.a htE;
    private com.baidu.live.follow.pendant.a htF;
    private LinearLayout htG;
    private LinearLayout htz;
    private long lastClickTime = 0;
    private int ahv = 0;
    private boolean htD = false;
    private HttpRule hqW = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.hqG != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.hqG.DR()) {
                httpMessage.addParam("ala_challenge_id", d.this.hqG.DU());
            }
            return httpMessage;
        }
    };
    private HttpRule hqX = new HttpRule(1021229) { // from class: com.baidu.tieba.ala.liveroom.d.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.hqG != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.hqG.DR()) {
                httpMessage.addParam("challenge_id", d.this.hqG.DU());
            }
            return httpMessage;
        }
    };
    private HttpRule hqY = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.hqG != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.hqG.DR()) {
                httpMessage.addParam("challenge_id", d.this.hqG.DU());
            }
            return httpMessage;
        }
    };
    private HttpRule hqZ = new HttpRule(1021232) { // from class: com.baidu.tieba.ala.liveroom.d.d.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.hqG != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.hqG.DR()) {
                httpMessage.addParam("challenge_id", d.this.hqG.DU());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c hra = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.d.23
        @Override // com.baidu.live.liveroom.g.c
        public void PA() {
            if (d.this.hrG != null) {
                d.this.hrG.oM(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cD(boolean z) {
            if (z) {
                if (d.this.hrG != null) {
                    d.this.hrG.oM(true);
                }
            } else if (d.this.hrG != null) {
                d.this.hrG.oM(false);
            }
            if (d.this.hrZ != null) {
                d.this.hrZ.bC(z);
            }
            if (d.this.hqE != null) {
                d.this.hqE.nC(z ? false : true);
            }
            com.baidu.live.q.a.cE(z);
        }
    };
    private HttpMessageListener hre = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.d.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.QT() != null) {
                        com.baidu.live.af.e.ST().bCm = getQuickGiftHttpResponseMessage.QT();
                        d.this.cdi();
                    }
                }
            }
        }
    };
    CustomMessageListener hrk = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.d.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.hqV.c(d.this.ceG());
                } else if (d.this.cdQ() || !g.wW(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.27.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.ceG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.ceG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    d.this.hqV.c(d.this.hqM, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener hrf = new CustomMessageListener(2913276) { // from class: com.baidu.tieba.ala.liveroom.d.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            JSONObject optJSONObject;
            JSONArray optJSONArray;
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject) && (optJSONObject = ((JSONObject) customResponsedMessage.getData()).optJSONObject("ext_data")) != null && (optJSONArray = optJSONObject.optJSONArray("surprise_prize_member")) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                View inflate = LayoutInflater.from(d.this.activity).inflate(a.g.ala_fudai_dialog_layout, (ViewGroup) null);
                final Dialog dialog = new Dialog(d.this.ceG().pageContext.getPageActivity(), a.i.FudaiDialogStyle);
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
                            akVar.aMf = -1;
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
    private CustomMessageListener htH = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.d.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.cdQ() || !g.wW(2913128)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.wU(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    d.this.Ij(str);
                }
            }
        }
    };
    private CustomMessageListener hrg = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.hrO.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hrh = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.this.hsc != null) {
                    d.this.hsc.ie(str);
                }
            }
        }
    };
    CustomMessageListener hri = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.d.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.hsD != null && d.this.hsD.bkF != null && !d.this.hsD.bkK && !d.this.hsD.bkL && d.this.hrY != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.ceG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                if (d.this.hrL != null && d.this.hrL.MC().OI()) {
                    layoutParams.bottomMargin = d.this.ceG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds88);
                } else {
                    layoutParams.bottomMargin = d.this.ceG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                }
                d.this.hrY.c(d.this.hqM, layoutParams);
                if (com.baidu.live.guardclub.e.Lx() != null) {
                    com.baidu.live.guardclub.e.Lx().LC();
                }
            }
        }
    };
    private CustomMessageListener hrj = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.d.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.hsa != null) {
                    d.this.hsa.dismiss();
                }
                if (d.this.hsc != null) {
                    d.this.hsc.dismiss();
                }
                if (d.this.hfG != null) {
                    d.this.hfG.dismiss();
                }
                com.baidu.live.im.b.d.Nk().setSwitchStatus(true);
                com.baidu.live.im.b.d.Nk().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.cdX();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b hrl = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.d.19
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
                        alaStaticItem.addParams("gifts_value", com.baidu.live.af.e.ST().bCm.Hx().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.af.e.ST().bCm.Hx().Gx());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.af.e.ST().bCm.Hx().Gy());
                        if (d.this.ceG().hBP.HR() != null && d.this.ceG().hBP.HR().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.ceG().hBP.HR().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.ceG().hBP.HR().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.NL());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.KE()) {
                        if (com.baidu.live.d.Ba().getBoolean("quick_gift_guide_show", true) && !d.this.cdQ()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, ah.class, d.this.ceG().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                ah ahVar = (ah) runTask.getData();
                                ahVar.setPageContext(d.this.ceG().pageContext);
                                ahVar.setLiveShowData(d.this.ceG().hBP.HR());
                                ahVar.setGiftItem(com.baidu.live.af.e.ST().bCm.Hx());
                                ahVar.setOtherParams(d.this.NL());
                                ahVar.initView();
                                ahVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.d.d.19.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        d.this.nI(false);
                                    }
                                });
                                ahVar.show();
                                d.this.nI(true);
                                return;
                            }
                            return;
                        }
                        n.a(d.this.ceG().pageContext, d.this.ceG().hBP.HR(), com.baidu.live.af.e.ST().bCm.Hx(), d.this.NL());
                    }
                } else if (i == 1) {
                    if (d.this.hrL != null) {
                        d.this.cdX();
                    }
                } else if (i == 3 && d.this.KE()) {
                    if (com.baidu.live.q.a.isDebug()) {
                        com.baidu.live.q.a.c(d.this.ceG().hBP.HR().mLiveInfo.live_id, 0);
                        return;
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    d.this.hry.d(d.this.ceG().hBP.HR(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.ceG() != null && d.this.ceG().hBP != null && d.this.ceG().hBP.HR() != null && d.this.ceG().hBP.HR().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.ceG().hBP.HR().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.ceG().hBP.HR().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.ceG().hBP.HR().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.NL());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.ceG() != null && d.this.ceG().hBP != null && d.this.ceG().hBP.HR() != null && d.this.ceG().hBP.HR().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.ceG().hBP.HR().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.ceG().hBP.HR().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.ceG().hBP.HR().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.NL());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.bsW != null) {
                        d.this.bsW.cx(false);
                    }
                } else if (i == 12) {
                    if (d.this.hrG != null && d.this.ceG().hBP.HR() != null && d.this.ceG().hBP.HR().mLiveInfo != null) {
                        String valueOf = String.valueOf(d.this.ceG().hBP.HR().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.ceG().hBP.HR().mLiveInfo.room_id);
                        String str4 = null;
                        AlaLiveSdkInfo alaLiveSdkInfo = d.this.ceG().hBP.HR().mLiveSdkInfo;
                        if (alaLiveSdkInfo != null && alaLiveSdkInfo.mCastIds != null) {
                            str4 = String.valueOf(d.this.ceG().hBP.HR().mLiveSdkInfo.mCastIds.chatMCastId);
                        }
                        d.this.hrG.ax(valueOf, valueOf2, str4);
                        com.baidu.live.q.a.c(d.this.ceG().hBP.HR().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    x HR = d.this.ceG().hBP.HR();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.ceG().pageContext.getPageActivity(), HR.aKu.userName, Long.toString(HR.aKu.userId), Long.toString(HR.aKu.charmCount), String.valueOf(HR.mLiveInfo.group_id), String.valueOf(HR.mLiveInfo.live_id), false, String.valueOf(HR.aKu.userId), Long.toString(HR.aKQ.userId), HR.aKQ.userName, HR.aKQ.portrait, d.this.hqC.getCount(), d.this.NL())));
                    LogManager.getCommonLogger().doClickGusetNumLog(HR.mLiveInfo.feed_id, d.this.hqC.getCount() + "", d.this.NL());
                } else if (i == 11) {
                    d.this.cec();
                    d.this.ced();
                } else if (i == 16) {
                    if (d.this.ceG() != null && (bqVar2 = com.baidu.live.af.a.SE().bCb) != null && (chVar = bqVar2.aRB) != null) {
                        String str5 = chVar.aTe.aTo;
                        if (!TextUtils.isEmpty(str5)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (d.this.ceG().hBP != null && d.this.ceG().hBP.HR() != null && d.this.ceG().hBP.HR().mLiveInfo != null) {
                                j = d.this.ceG().hBP.HR().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", d.this.ceG().hBP.HR().mLiveInfo.room_id + "", d.this.ceG().hBP.HR().mLiveInfo.feed_id, d.this.NL());
                            }
                            if (str5.contains("?")) {
                                str3 = str5 + "&liveId=" + j;
                            } else {
                                str3 = str5 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.ceG().pageContext.getPageActivity(), str3);
                        }
                    }
                } else if (i == 20) {
                    if (d.this.ceG() != null) {
                        x xVar = null;
                        if (d.this.ceG().hBP != null) {
                            xVar = d.this.ceG().hBP.HR();
                        }
                        if (xVar != null && xVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.v.b.cnq().bwr != null) {
                            String str6 = com.baidu.tieba.ala.liveroom.v.b.cnq().bwr.aJH;
                            if (!TextUtils.isEmpty(str6)) {
                                if (str6.contains("?")) {
                                    str2 = str6 + "&live_id=" + xVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str2 = str6 + "?live_id=" + xVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(d.this.ceG().pageContext.getPageActivity(), str2)));
                            }
                        }
                    }
                } else if (i == 17 && d.this.KE() && d.this.ceG() != null && (bqVar = com.baidu.live.af.a.SE().bCb) != null && bqVar.aRB != null && (str = bqVar.aRB.aTl) != null) {
                    cn cnVar = new cn(str);
                    if (!TextUtils.isEmpty(cnVar.webUrl)) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                        if (d.this.hsa != null && d.this.ceG().hBP != null && d.this.ceG().hBP.HR() != null) {
                            x HR2 = d.this.ceG().hBP.HR();
                            d.this.hsa.b(cnVar.webUrl, HR2.mLiveInfo.live_id, HR2.aKQ.userId, HR2.aKu.userId);
                        }
                    }
                }
            }
        }
    };
    private boolean htI = false;
    private boolean htJ = false;

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.hrA = new com.baidu.tieba.ala.liveroom.guide.c(ceG().pageContext, this, false);
        this.hqX.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hqX);
        this.hqW.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hqW);
        this.hqY.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hqY);
        this.hqZ.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hqZ);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean isVertical() {
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void m(x xVar) {
        super.m(xVar);
        g.cii();
        this.htD = true;
        this.htJ = false;
        this.htI = false;
        ceG().hBQ.setIsForceHandledTouch(false);
        ceG().hBQ.setSwipeClearEnable(true);
        ceG().hBQ.setOnLiveViewScrollListener(this.hra);
        ceG().hBQ.setOnClickListener(null);
        ceG().hBQ.setClickable(false);
        if (this.hrD != null) {
            this.hrD.b(this.hrl);
        }
        if (this.hsw != null) {
            this.hsw.setVisibility(0);
        }
        cda();
        if (this.hrW != null) {
            this.hrW.a(xVar, this.bzK);
            this.hrW.U(this.hsx);
            this.hrW.a(this);
        }
        cfd();
        cdm();
        cdM();
        cdL();
        cdn();
        cdr();
        cdo();
        ceS();
        nJ(false);
        cdj();
        cdk();
        cef();
        cdw();
        ceh();
        cdt();
        cdu();
        ceV();
        ceW();
        cen();
        nL(false);
        cek();
        ceo();
        ccY();
        cey();
        cdc();
        cdi();
        cdd();
        cde();
        cdf();
        cdg();
        ccU();
        cem();
        ceu();
        ceg();
        cel();
        nP(true);
        cex();
        c(this.gtp);
        ccZ();
        ceT();
        cet();
        cdP();
        ceU();
        MessageManager.getInstance().registerListener(this.hre);
        MessageManager.getInstance().registerListener(this.hrg);
        MessageManager.getInstance().registerListener(this.hri);
        MessageManager.getInstance().registerListener(this.hrj);
        MessageManager.getInstance().registerListener(this.htH);
        MessageManager.getInstance().registerListener(this.hrk);
        MessageManager.getInstance().registerListener(this.hrh);
        MessageManager.getInstance().registerListener(this.hrf);
        cdx();
        cdq();
        cej();
    }

    private void ceS() {
    }

    private void ceT() {
        AlaVideoBCChatData alaVideoBCChatData;
        CustomResponsedMessage runTask;
        AlaLiveUserInfoData alaLiveUserInfoData = ceG().hBP.HR().aKQ;
        if (alaLiveUserInfoData != null && (alaVideoBCChatData = alaLiveUserInfoData.videoBCEnterData) != null && alaVideoBCChatData.isShowEnter()) {
            if (this.hsu == null && (runTask = MessageManager.getInstance().runTask(2913255, com.baidu.live.ao.c.class, ceG().pageContext)) != null && runTask.getData() != null) {
                this.hsu = (com.baidu.live.ao.c) runTask.getData();
            }
            if (this.hsu != null) {
                this.hsu.a(ceG().bsZ);
                this.hsu.b(ceG().hBO.getMastView());
                this.hsu.r(ceG().hBP.HR());
                this.hsu.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.24
                    @Override // com.baidu.live.ao.c.a
                    public void XR() {
                        if (d.this.hrD != null) {
                            d.this.ceG().hBQ.hRu = false;
                            d.this.hrD.setPraiseEnable(false);
                            if (d.this.ceG().hBR != null) {
                                d.this.ceG().hBR.setTalentShowing(true);
                            }
                        }
                    }

                    @Override // com.baidu.live.ao.c.a
                    public void XS() {
                        if (d.this.hrD != null) {
                            d.this.ceG().hBQ.hRu = true;
                            d.this.hrD.setPraiseEnable(true);
                            if (d.this.ceG().hBR != null) {
                                d.this.ceG().hBR.setTalentShowing(false);
                            }
                        }
                    }
                });
                View enterView = this.hsu.getEnterView();
                if (enterView != null) {
                    if (enterView.getParent() != null) {
                        ((ViewGroup) enterView.getParent()).removeView(enterView);
                    }
                    this.hrv.cz(enterView);
                }
            }
        }
    }

    public void ceU() {
        this.htF = new com.baidu.live.follow.pendant.a(getActivity());
    }

    private void ccU() {
        if (this.hsm != null) {
            this.hsm.a(new com.baidu.live.aa.c() { // from class: com.baidu.tieba.ala.liveroom.d.d.25
                @Override // com.baidu.live.aa.c
                public void cK(boolean z) {
                    if (d.this.hqH != null) {
                        d.this.hqH.setNeedCloseRecommendFloat(z);
                    }
                    if (d.this.ceG().hBQ.hRu) {
                        if (d.this.hrG != null) {
                            d.this.hrG.oE(z);
                            d.this.hrG.oM(!z);
                        }
                        if (d.this.hrD != null) {
                            d.this.hrD.oE(z);
                            d.this.hrD.setPraiseEnable(!z);
                            d.this.hrD.oD(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(x xVar) {
        super.k(xVar);
        if (this.hqz != null) {
            this.hqz.M(xVar);
        }
        if (this.hqA != null) {
            this.hqA.I(xVar);
        }
        if (this.hqD != null) {
            this.hqD.L(xVar);
        }
        if (this.hqH != null) {
            this.hqH.a(xVar);
        }
        if (this.htF != null) {
            if (this.htF.d(xVar) && !this.htF.isDisplay()) {
                cfe();
                this.htB = true;
                this.htC = true;
                if (this.hsi != null) {
                    this.hsi.ba(true);
                    this.hsi.bb(true);
                }
                if (this.hrD != null) {
                    this.hrD.setPraiseEnable(false);
                    ceG().hBQ.hRu = false;
                }
                ceX();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.topMargin = (int) getActivity().getResources().getDimension(a.d.sdk_ds16);
                ag agVar = xVar.aLF;
                if (agVar != null) {
                    this.htF.n(agVar.anchorPortrait, agVar.aJP, String.valueOf(agVar.aLV));
                    this.htF.b(cfk(), layoutParams);
                }
            } else if (!this.htF.d(xVar) && this.htF.isDisplay()) {
                this.htF.FX();
                this.htB = false;
                this.htC = false;
                if (this.hsi != null) {
                    this.hsi.ba(false);
                    this.hsi.bb(false);
                }
                if (this.hrD != null) {
                    this.hrD.setPraiseEnable(true);
                    ceG().hBQ.hRu = true;
                }
                ceX();
                if (this.htG != null) {
                    this.htG.removeAllViews();
                    this.htG = null;
                }
            }
        }
        nP(false);
        if (this.hqE != null) {
            this.hqE.j(xVar);
            this.hqE.nB(this.hsG);
            this.hqE.updateView();
            if (xVar != null && this.hso != null && !this.hso.hasInit && !TextUtils.isEmpty(this.hso.aRV)) {
                this.hso.hasInit = true;
                this.hqE.Ic(this.hso.aRV);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(r rVar) {
        if (rVar != null) {
            if (this.hqy != null && rVar.getList() != null) {
                this.hqy.e(rVar);
            }
            if (this.hqC != null) {
                this.hqC.eZ(rVar.getCount());
            }
        }
    }

    private void ccW() {
        if (this.hrF != null) {
            this.hrF.aJ(ceG().hBO.getLiveContainerView());
        }
    }

    private void ceV() {
        if (this.hqI == null) {
            this.hqI = new com.baidu.tieba.ala.liveroom.c.a(ceG().pageContext);
        }
        if (ceG().hBP != null && ceG().hBP.HR() != null && ceG().hBP.HR().mLiveInfo != null) {
            this.hqI.Id(String.valueOf(ceG().hBP.HR().mLiveInfo.user_id));
        }
    }

    private void ceW() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (ceG() != null && ceG().hBP != null && ceG().hBP.HR() != null && ceG().hBP.HR().mLiveInfo != null) {
                j = ceG().hBP.HR().mLiveInfo.room_id;
            }
            if (this.hrT == null) {
                this.hrT = new com.baidu.tieba.ala.liveroom.guide.a(ceG().pageContext, j);
            }
            this.hrT.nH(this.hsz);
            this.hrT.a(new a.InterfaceC0681a() { // from class: com.baidu.tieba.ala.liveroom.d.d.8
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0681a
                public void cfl() {
                    if (d.this.bsW != null) {
                        d.this.bsW.cx(true);
                    }
                }
            });
            this.hrT.aF(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void dY(int i) {
        super.dY(i);
        ccW();
        if (this.hqH != null) {
            this.hqH.dY(i);
        }
    }

    private void cda() {
        if (this.bzK == null) {
            this.bzK = new PendantParentView(ceG().pageContext.getPageActivity(), ceY());
            ceG().hBQ.addView(this.bzK, new ViewGroup.LayoutParams(-1, -1));
            this.bzK.setDefaultItemMargin(ceG().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.bzK.setPadding(ceG().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, ceG().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            ceX();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void nE(boolean z) {
        if (z) {
            this.ahv = ceG().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds180);
        } else {
            this.ahv = ceG().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
        }
        ceX();
    }

    private void ceX() {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        if (this.bzK != null) {
            this.bzK.setModel(ceY());
            int dimensionPixelSize3 = ceG().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds220);
            if (this.ahv != 0) {
                dimensionPixelSize = this.ahv;
            } else {
                dimensionPixelSize = ceG().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            }
            if (this.gSr) {
                dimensionPixelSize2 = cfi();
            } else {
                dimensionPixelSize2 = ceG().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds250);
            }
            this.bzK.setPosition(dimensionPixelSize3, 0, dimensionPixelSize2, dimensionPixelSize);
            return;
        }
        cda();
    }

    private PendantParentView.Model ceY() {
        if (this.gSr) {
            return PendantParentView.Model.VERTICAL_PK;
        }
        if (this.htB) {
            return PendantParentView.Model.VERTICAL_BB_CHATING;
        }
        return PendantParentView.Model.VERTICAL;
    }

    private void ceZ() {
        if (ceG().hBQ != null && !this.htJ) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.9
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.hqM != null && d.this.hrL != null && d.this.hrL.MA() != null && d.this.hrL.MA().getView() != null) {
                        if (d.this.gSr && !d.this.hsA && d.this.ceG().hBQ != null && d.this.ceG().hBQ.getHeight() > 0 && !d.this.htC) {
                            int br = d.this.hqH != null ? d.this.hqH.br(false) : 0;
                            ViewGroup.LayoutParams layoutParams = d.this.hqM.getLayoutParams();
                            int height = d.this.ceG().hBQ.getHeight() - br;
                            int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                i += UtilHelper.getStatusBarHeight();
                            }
                            if (layoutParams != null && d.this.hrL != null) {
                                layoutParams.height = i + d.this.ceG().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                                d.this.hqM.setLayoutParams(layoutParams);
                                ViewGroup.LayoutParams layoutParams2 = d.this.hrL.MA().getView().getLayoutParams();
                                if (layoutParams2 != null) {
                                    layoutParams2.height = layoutParams.height - com.baidu.live.al.c.m19do(false);
                                    d.this.hrL.MA().getView().setLayoutParams(layoutParams2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        int i2 = com.baidu.live.al.c.i(false, d.this.hsA);
                        if (d.this.hsx.indexOfChild(d.this.hqM) != -1 && d.this.hqM.getLayoutParams() != null) {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) d.this.hqM.getLayoutParams();
                            layoutParams3.height = com.baidu.live.al.c.d(false, false, d.this.hsA);
                            d.this.hqM.setLayoutParams(layoutParams3);
                        }
                        if (d.this.hqM.indexOfChild(d.this.hrL.MA().getView()) != -1 && d.this.hrL.MA().getView().getLayoutParams() != null) {
                            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) d.this.hrL.MA().getView().getLayoutParams();
                            layoutParams4.height = i2;
                            d.this.hrL.MA().getView().setLayoutParams(layoutParams4);
                        }
                        d.this.hrL.MA().Mz();
                    }
                }
            });
        }
    }

    private void cfa() {
        if (ceG().hBQ != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.10
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.hrN != null) {
                        if (d.this.gSr && !d.this.hsA && d.this.ceG().hBQ != null && d.this.ceG().hBQ.getHeight() > 0) {
                            int height = (d.this.ceG().hBQ.getHeight() - (d.this.hqH != null ? d.this.hqH.br(false) : 0)) + d.this.ceG().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            if (d.this.hrN != null) {
                                d.this.hrN.ei(height);
                            }
                        } else if (d.this.hrN != null) {
                            d.this.hrN.ei(com.baidu.live.al.a.b(d.this.ceG().pageContext.getPageActivity(), false, false, d.this.hsA));
                        }
                    }
                }
            });
        }
    }

    private void cfb() {
        if (ceG().hBQ != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.11
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    if (d.this.hrN != null) {
                        int h = com.baidu.live.al.a.h(false, false);
                        if (!d.this.gSr || d.this.ceG().hBQ == null || d.this.ceG().hBQ.getHeight() <= 0) {
                            i = h;
                        } else {
                            int height = d.this.ceG().hBQ.getHeight() - (d.this.hqH != null ? d.this.hqH.br(false) : 0);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            i = height + d.this.ceG().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                        }
                        if (d.this.hrN != null) {
                            d.this.hrN.ej(i);
                        }
                    }
                }
            });
        }
    }

    private void cfc() {
        if (this.hrM != null && this.hrM.Da() != null) {
            ViewGroup.LayoutParams layoutParams = this.hrM.Da().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = ceG().pageContext.getResources().getDimensionPixelOffset(this.gSr ? a.d.sdk_ds100 : a.d.sdk_ds20);
                this.hrM.Da().setLayoutParams(layoutParams);
            }
        }
    }

    private void cfd() {
        if (this.htz == null) {
            this.htz = new LinearLayout(ceG().pageContext.getPageActivity());
            this.htz.setOrientation(1);
        }
        if (this.htz.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = ceG().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds160);
            layoutParams.leftMargin = ceG().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            ceG().hBQ.addView(this.htz, layoutParams);
        }
    }

    private void cfe() {
        List<cq.a> list;
        if (cfk() == null && ceG() != null && ceG().hBO != null && ceG().hBO.getMastView() != null && ceG().hBP != null && ceG().pageContext != null && ceG().pageContext.getResources() != null) {
            com.baidu.live.af.a SE = com.baidu.live.af.a.SE();
            if (SE.bwi != null && SE.bwi.aPt != null && (list = com.baidu.live.af.a.SE().bwi.aPt.dataList) != null && list.size() >= 2) {
                cq.a aVar = list.get(1) == null ? cq.a.aUz.get(1) : list.get(1);
                int i = com.baidu.live.af.a.SE().bwi.aPt.aUv;
                int i2 = com.baidu.live.af.a.SE().bwi.aPt.aUw;
                DisplayMetrics displayMetrics = ceG().pageContext.getResources().getDisplayMetrics();
                int i3 = displayMetrics.widthPixels;
                int i4 = displayMetrics.heightPixels;
                if (this.activity != null && com.baidu.live.utils.d.be(this.activity)) {
                    i4 += com.baidu.live.utils.d.bj(this.activity);
                }
                int i5 = (((i * i4) / i2) - i3) / 2;
                int i6 = (aVar.width * i4) / i2;
                int i7 = ((aVar.x * i4) / i2) - i5;
                int i8 = (aVar.height * i4) / i2;
                int i9 = (aVar.y * i4) / i2;
                if (this.htG == null) {
                    this.htG = new LinearLayout(ceG().pageContext.getPageActivity());
                    this.htG.setOrientation(1);
                }
                if (this.htG.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i7 < 0 ? i6 + i7 : i6, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(9);
                    layoutParams.topMargin = i9 + i8;
                    if (!UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams.topMargin += UtilHelper.getImmersiveStickyBarHeight();
                    } else if (com.baidu.live.utils.d.Xx() && this.activity != null) {
                        layoutParams.topMargin += com.baidu.live.utils.d.bj(this.activity);
                    }
                    layoutParams.leftMargin = i7 < 0 ? 0 : i7;
                    ceG().hBO.getMastView().addView(this.htG, layoutParams);
                }
            }
        }
    }

    private void cdc() {
        if (this.hqE == null) {
            this.hqE = new com.baidu.tieba.ala.liveroom.activeview.b(ceG().pageContext);
        }
        if (ceG() != null && ceG().hBP != null) {
            this.hqE.HZ(ceG().hBP.cmC());
        }
        this.hqE.ba(this.gSr);
        this.hqE.setOtherParams(NL());
        this.hqE.c(ceG().hBP.HR(), false);
        this.hqE.setHost(false);
        this.hqE.nB(this.hsG);
        this.hqE.a(1, this.bzK);
        this.hqE.a(2, this.bzK);
        this.hqE.setVisible(this.hsA ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdi() {
        if (this.hrv == null) {
            cdo();
        }
        this.hrv.setOtherParams(NL());
        this.hrv.a(com.baidu.live.af.e.ST().bCm, ceG().hBP.HR());
    }

    private void cdd() {
        if (this.hqD == null) {
            this.hqD = new com.baidu.tieba.ala.liveroom.l.a(ceG().pageContext, this);
        }
        this.hqD.setOtherParams(NL());
        this.hqD.a((ViewGroup) this.bzK, cdh());
        this.hqD.L(ceG().hBP.HR());
    }

    private void ccZ() {
        if (ceG() != null) {
            if (this.hsi == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913271, com.baidu.live.a.a.class, ceG().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hsi = (com.baidu.live.a.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hsi.ba(this.gSr);
            this.hsi.bc(false);
            this.hsi.a(cdC(), ceG().hBP.HR());
            this.hsi.setIsHost(false);
            this.hsi.a(new a.InterfaceC0163a() { // from class: com.baidu.tieba.ala.liveroom.d.d.13
                @Override // com.baidu.live.a.a.InterfaceC0163a
                public void Bg() {
                    d.this.cff();
                }

                @Override // com.baidu.live.a.a.InterfaceC0163a
                public void Bh() {
                    d.this.cfg();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cff() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfg() {
    }

    private void cde() {
        if (this.hrY == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, j.class, ceG().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hrY = (j) runTask.getData();
            } else {
                return;
            }
        }
        this.hrY.setOtherParams(NL());
        if (this.hqM != null && this.hqM.indexOfChild(this.hrY.getView()) >= 0) {
            this.hqM.removeView(this.hrY.getView());
        }
    }

    private void cdf() {
        if (this.hrv != null) {
            this.hrv.a(new a.InterfaceC0687a() { // from class: com.baidu.tieba.ala.liveroom.d.d.14
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0687a
                public void bR(int i, int i2) {
                    x HR = d.this.ceG().hBP.HR();
                    if (HR != null && HR.mLiveInfo != null) {
                        if (d.this.hsb == null) {
                            d.this.hsb = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.ceG().pageContext.getPageActivity());
                        }
                        d.this.hsb.d(d.this.hsx, i, i2);
                        d.this.hsb.a(String.valueOf(HR.mLiveInfo.live_id), new a.InterfaceC0691a() { // from class: com.baidu.tieba.ala.liveroom.d.d.14.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0691a
                            public void a(float f, String str) {
                                if (d.this.hrv != null) {
                                    d.this.hrv.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0687a
                public void bS(int i, int i2) {
                    if (d.this.hsb != null) {
                        d.this.hsb.bX(i, i2);
                    }
                }
            });
        }
    }

    private void cdg() {
        if (this.hsM == null) {
            this.hsM = new com.baidu.tieba.ala.liveroom.j.e(ceG().pageContext);
        }
        this.hsM.setRoomId(ceG().hBP.HR().mLiveInfo.room_id);
        this.hsM.Iu("");
        this.hsM.b(ceG().hBP.HR(), this.bzK);
        if (this.hqV == null) {
            this.hqV = new com.baidu.tieba.ala.liveroom.j.b(ceG().pageContext, NL(), this.hsM, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.15
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void cdF() {
                    d.this.nI(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void cdG() {
                    d.this.nI(false);
                }
            });
        }
        this.hqV.setRoomId(ceG().hBP.HR().mLiveInfo.room_id);
        if (this.hqM != null && this.hqM.indexOfChild(this.hqV.getView()) >= 0) {
            this.hqM.removeView(this.hqV.getView());
        }
        if (this.hqV != null) {
            this.hqV.b(ceG());
        }
    }

    private void cdw() {
        if (this.htE == null) {
            this.htE = new com.baidu.tieba.ala.liveroom.apppromotion.a(ceG().pageContext);
        }
        this.htE.b(cdC(), ceG().hBP.HR());
    }

    private LinearLayout.LayoutParams cdh() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    private void cdj() {
        CustomResponsedMessage runTask;
        if (this.hrL == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, ceG().pageContext)) != null && runTask.getData() != null) {
            this.hrL = (k) runTask.getData();
            this.hrL.setFromMaster(false);
            this.hrL.MA().getView().setId(a.f.ala_liveroom_msg_list);
            this.hrL.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.16
                @Override // com.baidu.live.im.k.a
                public boolean ME() {
                    return d.this.KE();
                }

                @Override // com.baidu.live.im.k.a
                public void MF() {
                    d.this.hsE = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hO(String str) {
                    if (!d.this.hsA) {
                        d.this.nG(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.ceG().pageContext.getPageActivity(), d.this.ceG().hBO.getLiveContainerView());
                    }
                    d.this.Ig(str);
                }

                @Override // com.baidu.live.im.k.a
                public void MG() {
                    if (d.this.hsA) {
                        d.this.nG(true);
                        d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.16.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.ceG().pageContext.getPageActivity(), d.this.ceG().hBO.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.hrL != null) {
                        d.this.hrL.MB().setQuickInputPanelVisible(false);
                        d.this.hrL.MB().Ow();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void MH() {
                }

                @Override // com.baidu.live.im.k.a
                public void MI() {
                    if (d.this.hsA) {
                        d.this.cdE();
                        if (d.this.hrM != null) {
                            d.this.hrM.Db();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean MJ() {
                    return d.this.cdR();
                }

                @Override // com.baidu.live.im.k.a
                public int MK() {
                    return d.this.cdS();
                }

                @Override // com.baidu.live.im.k.a
                public boolean ML() {
                    x HR = d.this.ceG().hBP.HR();
                    if (HR == null || HR.aKQ == null) {
                        return false;
                    }
                    return HR.aKQ.isMysteriousMan;
                }
            });
            this.hqM = new FrameLayout(ceG().pageContext.getPageActivity());
            this.hqM.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.hrL != null && this.hqM != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(ceG().pageContext.getPageActivity()) * 0.7f);
            int i = com.baidu.live.al.c.i(false, false);
            if (this.hsx.indexOfChild(this.hqM) < 0) {
                if (this.hqM.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hqM.getParent()).removeView(this.hqM);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.live.al.c.d(false, false, false));
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.live.al.c.dn(false);
                this.hsx.addView(this.hqM, layoutParams);
            }
            if (this.hqM.indexOfChild(this.hrL.MA().getView()) < 0) {
                if (this.hrL.MA().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hrL.MA().getView()).removeView(this.hrL.MA().getView());
                }
                this.hqM.addView(this.hrL.MA().getView(), new FrameLayout.LayoutParams(equipmentWidth, i));
            }
            if (ceG().hBQ.indexOfChild(this.hrL.MB().getView()) < 0) {
                if (this.hrL.MB().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hrL.MB().getView().getParent()).removeView(this.hrL.MB().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                cea();
                ceG().hBQ.addView(this.hrL.MB().getView(), layoutParams2);
            }
            x HR = ceG().hBP.HR();
            if (HR != null && HR.mLiveInfo != null) {
                this.hrL.setLogData(HR.mLiveInfo.feed_id, NL());
            }
            this.hrL.a(String.valueOf(ceG().hBP.HR().mLiveInfo.group_id), String.valueOf(ceG().hBP.HR().mLiveInfo.last_msg_id), String.valueOf(ceG().hBP.HR().aKu.userId), String.valueOf(ceG().hBP.HR().mLiveInfo.live_id), ceG().hBP.HR().aKu.appId, (HR == null || HR.aLi == null || !HR.aLi.Eq()) ? false : true, ceG().hBP.HR().getGuardName());
            nG(false);
        }
    }

    private void cdm() {
        if (this.hqz == null) {
            this.hqz = new com.baidu.tieba.ala.liveroom.o.a(ceG().pageContext, false, this);
        }
        this.hqz.e(this.hsw, ceG().hBP.HR());
        this.hqz.a(this.hrl);
        this.hqz.setOtherParams(NL());
    }

    private void cdn() {
        if (this.hqy == null) {
            this.hqy = new com.baidu.tieba.ala.liveroom.audiencelist.c(ceG().pageContext, this, false);
        }
        this.hqy.a(String.valueOf(ceG().hBP.HR().mLiveInfo.group_id), String.valueOf(ceG().hBP.HR().mLiveInfo.live_id), String.valueOf(ceG().hBP.HR().aKu.userId), ceG().hBP.HR());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.f.ala_liveroom_hostheader;
            if (this.hrw != null && this.hrw.getView() != null && this.hrw.getView().getParent() != null) {
                i = a.f.ala_liveroom_guardthrone;
            }
            this.hqy.c(this.hsw, i, a.f.ala_liveroom_audience_count_layout);
            this.hqy.e(ceG().hBP.bWZ());
            this.hqy.setOtherParams(NL());
        }
    }

    private void cdo() {
        com.baidu.live.core.a.a ON;
        if (this.hrv == null) {
            this.hrv = new com.baidu.tieba.ala.liveroom.operation.a(ceG().pageContext);
        }
        this.hrv.a(ceG(), this.hsx, ceG().hBP.HR().mLiveInfo, true, this.hrl);
        this.hrv.setOtherParams(NL());
        if (this.hrW != null && (ON = this.hrW.ON()) != null) {
            View rootLayout = ON.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.hrv.cy(rootLayout);
        }
        this.hrv.Q(ceG().hBP.HR());
    }

    private void cdk() {
        cdY();
    }

    public void nO(boolean z) {
        if (this.hrv != null) {
            this.hrv.nO(z);
        }
    }

    private void cdr() {
        if (this.hqC == null) {
            this.hqC = new com.baidu.tieba.ala.liveroom.audiencelist.b(ceG().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (ceG().hBP.bWZ() != null) {
            j = ceG().hBP.bWZ().getCount();
        }
        this.hqC.a(this.hrl);
        this.hqC.a(this.hsw, a.f.ala_liveroom_hostheader, j);
        this.hqC.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.hqC.nS(false);
        } else {
            this.hqC.nS(true);
        }
    }

    protected void Ij(String str) {
        if (this.hsL == null) {
            this.hsL = new com.baidu.tieba.ala.liveroom.t.b(ceG().pageContext);
        }
        this.hsL.c(this.hsx, str);
        nI(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.17
            @Override // java.lang.Runnable
            public void run() {
                d.this.hsL.cnd();
                d.this.nI(false);
            }
        }, 5000L);
    }

    private void nP(boolean z) {
        CustomResponsedMessage runTask;
        if (ceG().hBP.HR().mLiveInfo.live_type == 1 && this.htD) {
            if (this.htA == null && (runTask = MessageManager.getInstance().runTask(2913074, e.class, ceG().pageContext)) != null && runTask.getData() != null) {
                this.htA = (e) runTask.getData();
            }
            if (this.htA != null) {
                if (this.hqG == null) {
                    this.hqG = this.htA.a(ceG().pageContext);
                }
                if (z) {
                    this.hqG.DK();
                }
                if (ceG().hBP.HR().mLiveInfo.challengeId > 0 && !this.hqG.DS()) {
                    this.hqG.h(ceG().hBP.HR().mLiveInfo.live_id, ceG().hBP.HR().aKu.userId);
                    nQ(z);
                    if (z) {
                        this.hqG.a(ceG().hBP.clJ());
                    }
                    this.hqG.c(ceG().hBP.HR());
                }
            }
        }
    }

    private void nQ(boolean z) {
        if (this.hqH == null) {
            this.hqH = this.htA.b(ceG().pageContext);
            this.hqH.a(new com.baidu.live.challenge.g() { // from class: com.baidu.tieba.ala.liveroom.d.d.18
                @Override // com.baidu.live.challenge.g
                public void DG() {
                    d.this.ceG().hBQ.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.g
                public void a(bc bcVar, bg bgVar, bg bgVar2) {
                    d.this.gSr = true;
                    d.this.Zo();
                    if (d.this.ceG().bsZ != null) {
                        d.this.ceG().bsZ.getLivePlayer().setBackgroundResource(a.c.sdk_transparent);
                    }
                    if (d.this.hrB != null) {
                        d.this.hrB.setTimeTextMode(true);
                    }
                    if (d.this.bsW != null && bgVar != null && bgVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(bgVar.aQM);
                        arrayList.add(bgVar2.aQM);
                        com.baidu.live.liveroom.a.c cVar = d.this.bsW;
                        if (d.this.hsI) {
                            arrayList = null;
                        }
                        cVar.o(arrayList);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void DH() {
                }

                @Override // com.baidu.live.challenge.g
                public void DI() {
                }

                @Override // com.baidu.live.challenge.g
                public void bp(boolean z2) {
                    d.this.ceG().hBQ.setSwipeClearEnable(true);
                    d.this.gSr = false;
                    d.this.cfh();
                    if (d.this.bsW != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.ceG().hBP.cmy());
                        com.baidu.live.liveroom.a.c cVar = d.this.bsW;
                        if (d.this.hsI) {
                            arrayList = null;
                        }
                        cVar.o(arrayList);
                    }
                    if (d.this.ceG().bsZ != null) {
                        d.this.ceG().bsZ.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
                    }
                    if (d.this.hrB != null) {
                        d.this.hrB.setTimeTextMode(false);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void bq(boolean z2) {
                    if (z2 && d.this.hsm != null) {
                        d.this.hsm.onClose();
                    }
                }
            });
        }
        this.hqH.a(this.hqG);
        this.hqH.k(ceG().hBO.getLiveContainerView());
        this.hqH.c(z, false, false);
        this.hqG.a((i.c) this.hqH);
    }

    protected void Zo() {
        if (this.hrC != null) {
            this.hrC.wH(8);
        }
        if (this.hrD != null) {
            this.hrD.setPraiseEnable(false);
            ceG().hBQ.hRu = false;
        }
        if (this.hsh != null) {
            this.hsh.setCanVisible(false);
        }
        if (this.hrE != null) {
            this.hrE.cno();
        }
        if (this.hqD != null) {
            this.hqD.setCanVisible(false);
            this.hqD.cim();
        }
        if (this.hqE != null) {
            this.hqE.ba(true);
        }
        if (this.hsM != null) {
            this.hsM.setVisible(8);
        }
        if (this.hqF != null) {
            this.hqF.setCanVisible(false);
            this.hqF.setVisible(8);
        }
        if (this.hsi != null) {
            this.hsi.ba(true);
            this.hsi.bb(true);
        }
        ceX();
        ceZ();
        cfa();
        cfb();
        cfc();
    }

    protected void cfh() {
        if (this.hrC != null) {
            this.hrC.wH(0);
        }
        if (this.hrD != null) {
            this.hrD.setPraiseEnable(true);
            ceG().hBQ.hRu = true;
        }
        if (this.hsh != null) {
            this.hsh.setCanVisible(true);
        }
        if (this.hrE != null) {
            this.hrE.cnp();
        }
        if (this.hqD != null) {
            this.hqD.setCanVisible(true);
            this.hqD.L(ceG().hBP.HR());
        }
        if (this.hrG != null) {
            this.hrG.oM(true);
        }
        if (this.hqE != null) {
            this.hqE.ba(false);
        }
        if (this.hsM != null) {
            this.hsM.setVisible(0);
        }
        if (this.hqF != null) {
            this.hqF.setCanVisible(true);
            this.hqF.setVisible(0);
        }
        if (this.hsi != null) {
            this.hsi.ba(false);
            this.hsi.bb(false);
        }
        ceX();
        ceZ();
        cfa();
        cfb();
        cfc();
    }

    public void cds() {
        this.hry.d(ceG().hBP.HR(), false);
    }

    public void cdt() {
        if (ceG().hBP.HR() != null && ceG().hBP.HR().aKu != null && ceG().hBP.HR().mLiveInfo != null) {
            if (this.hqB == null) {
                this.hqB = new com.baidu.tieba.ala.liveroom.u.b(ceG().pageContext);
            }
            long j = ceG().hBP.HR().aKu.userId;
            int i = ceG().hBP.HR().mLiveInfo.live_type;
            String str = ceG().hBP.HR().aKu.portrait;
            String str2 = ceG().hBP.HR().mLiveInfo.feed_id;
            long j2 = ceG().hBP.HR().mLiveInfo.live_id;
            this.hqB.a(i, j, ceG().hBP.HR().aKu.userName, false, str, NL(), str2, j2);
            this.hqB.aF(this.hsw);
        }
    }

    private int cfi() {
        return (this.hqH != null ? this.hqH.br(false) : 0) - BdUtilHelper.getStatusBarHeight(this.activity);
    }

    private void cdu() {
        boolean z = true;
        if (this.hrG == null) {
            this.hrG = new com.baidu.tieba.ala.liveroom.w.a(ceG().pageContext, this);
        }
        this.hrG.c(ceG().hBQ, false);
        AlaLiveInfoData alaLiveInfoData = ceG().hBP.HR().mLiveInfo;
        if (alaLiveInfoData != null) {
            boolean z2 = ceF() && alaLiveInfoData.screen_direction != 2;
            boolean isZanAnimUnabled = alaLiveInfoData.mAlaLiveSwitchData != null ? alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled() : false;
            if (!z2 || isZanAnimUnabled) {
                z = false;
            }
            this.hrG.oL(z);
        }
    }

    private void cdx() {
        if (this.hsE || this.hsF) {
            if ((TbadkCoreApplication.isLogin() && this.hrL.MB().hasText()) || this.hsF) {
                this.hsE = false;
                this.hsF = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.20
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.cdX();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void cdp() {
        cdq();
    }

    private void cdq() {
        if (this.hrv != null) {
            int i = ceG().hBP.HR().aKQ.isUegBlock;
            int i2 = ceG().hBP.HR().aKQ.isBlock;
            String str = ceG().hBP.HR().aKQ.userName;
            if (i > 0 || i2 > 0) {
                this.hrv.b(true, i, i2, str);
                this.hrL.a(true, i, i2, str);
                this.hrR.b(true, i, i2, str);
                return;
            }
            this.hrv.b(false, i, i2, str);
            this.hrL.a(false, i, i2, str);
            this.hrR.b(false, i, i2, str);
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
        if (this.hqE != null) {
            this.hqE.I(bVar);
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
                    if (this.hqD != null) {
                        this.hqD.Q(jSONObject2);
                    }
                } else if ("enter_live".equals(optString)) {
                    if (this.hqC != null && this.hqC.getCount() > 20) {
                        this.hqC.eZ(this.hqC.getCount() + 1);
                    } else if (this.hqy != null) {
                        com.baidu.live.data.a Nw = bVar.Nw();
                        q qVar = new q();
                        qVar.aKv = new AlaLocationData();
                        qVar.aKw = new AlaRelationData();
                        qVar.aKu = new AlaLiveUserInfoData();
                        qVar.aKu.userId = JavaTypesHelper.toLong(Nw.userId, 0L);
                        qVar.aKu.userName = Nw.userName;
                        qVar.aKu.portrait = Nw.portrait;
                        if (this.hqC != null && this.hqy.c(qVar)) {
                            this.hqC.eZ(this.hqC.getCount() + 1);
                        }
                    }
                } else if ("update_liveinfo".equals(optString)) {
                    if (ceG().hBP.HR() != null && ceG().hBP.HR().mLiveInfo != null) {
                        ceG().hBP.a(ceG().hBP.HR().mLiveInfo.live_id, ceG().fromType, ceG().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && ceG().hBP.HR() != null && ceG().hBP.HR().mLiveInfo != null && ceG().hBP.HR().aKQ != null && this.hqH != null) {
                    long optLong = jSONObject2.optLong("mvp_user_id");
                    long optLong2 = jSONObject2.optLong("winner_live_id");
                    if (optLong == ceG().hBP.HR().aKQ.userId && optLong2 == ceG().hBP.HR().mLiveInfo.live_id) {
                        this.hqH.f(jSONObject2.optInt("challenge_status"), jSONObject2.optLong("challenge_id"));
                    }
                }
            } else {
                return;
            }
        }
        if (this.hsh == null || this.hsh.V(jSONObject2)) {
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void Ib(String str) {
        if (this.hqE != null) {
            this.hqE.Ib(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hsu != null) {
            this.hsu.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void cC(boolean z) {
        super.cC(z);
        if (ceG().hBQ != null) {
            ceG().hBQ.cod();
            ceG().hBQ.setLiveViewOnDispatchTouchEventListener(null);
            ceG().hBQ.setLiveViewOnTouchEventListener(null);
            ceG().hBQ.setOnLiveViewScrollListener(null);
        }
        if (ceG().bsZ != null) {
            ceG().bsZ.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
        }
        if (this.hqH != null) {
            this.hqH.DC();
        }
        cdy();
        if (this.hqB != null) {
            this.hqB.DC();
        }
        if (this.hrG != null) {
            this.hrG.release();
        }
        if (this.hqD != null) {
            this.hqD.DC();
        }
        if (this.hrv != null) {
            this.hrv.cmI();
        }
        if (this.hqA != null) {
            this.hqA.chj();
            this.hqA.setVisible(8);
        }
        if (this.hqF != null) {
            this.hqF.DC();
        }
        if (this.hqE != null) {
            this.hqE.release();
        }
        if (this.bzK != null) {
            this.bzK.removeAllViews();
            this.bzK = null;
        }
        if (this.htz != null) {
            this.htz.removeAllViews();
            this.htz = null;
        }
        if (this.htG != null) {
            this.htG.removeAllViews();
            this.htG = null;
        }
        if (this.hrG != null) {
            this.hrG.onDestroy();
        }
        if (this.hqG != null) {
            this.hqG.DC();
        }
        if (this.hqz != null) {
            this.hqz.cji();
        }
        if (this.hqV != null) {
            this.hqV.cancel();
        }
        if (this.hsM != null) {
            this.hsM.cgd();
        }
        if (this.htE != null) {
            this.htE.Bf();
        }
        if (this.hsh != null) {
            this.hsh.Bf();
        }
        if (this.hqL != null) {
            this.hqL.Bf();
        }
        if (this.hqV != null) {
            this.hqV.DC();
        }
        if (this.hsq != null) {
            this.hsq.DC();
        }
        if (this.hsu != null) {
            this.hsu.TF();
        }
        if (this.htF != null && this.htF.isDisplay()) {
            this.htB = false;
            this.htC = false;
            if (this.hsi != null) {
                this.hsi.ba(false);
                this.hsi.bb(false);
            }
            this.htF.FX();
        }
        if (ceG().hBR != null) {
            ceG().hBR.setTalentShowing(false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cA(boolean z) {
        super.cA(z);
        cdy();
        if (this.hqz != null) {
            this.hqz.onDestroy();
        }
        if (this.hqB != null) {
            this.hqB.onDestroy();
        }
        if (this.hqD != null) {
            this.hqD.onDestroy();
        }
        if (this.hqF != null) {
            this.hqF.onDestroy();
        }
        if (this.hqG != null) {
            this.hqG.onDestroy();
        }
        if (this.hqH != null) {
            this.hqH.onDestroy();
        }
        if (this.hqI != null) {
            this.hqI.onDestroy();
        }
        if (this.hrT != null) {
            this.hrT.onDestroy();
        }
        if (this.hqA != null) {
            this.hqA.onDestroy();
        }
        if (this.hqy != null) {
            this.hqy.onDestroy();
        }
        if (this.hrL != null) {
            this.hrL.onDestroy();
        }
        if (this.hrv != null) {
            this.hrv.onDestory();
        }
        if (this.hqE != null) {
            this.hqE.release();
        }
        if (this.hsM != null) {
            this.hsM.cA(!z);
        }
        if (this.hqL != null) {
            this.hqL.onDestroy();
        }
        if (this.hqV != null) {
            this.hqV.onDestroy();
            this.hqV = null;
        }
        if (this.hsq != null) {
            this.hsq.onDestroy();
        }
        if (this.hsu != null) {
            this.hsu.onDestroy();
        }
        if (ceG().hBR != null) {
            ceG().hBR.setTalentShowing(false);
        }
        if (this.htE != null) {
            this.htE.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.hqX);
        MessageManager.getInstance().removeMessageRule(this.hqW);
        MessageManager.getInstance().removeMessageRule(this.hqY);
        MessageManager.getInstance().removeMessageRule(this.hqZ);
        MessageManager.getInstance().unRegisterListener(this.hre);
        MessageManager.getInstance().unRegisterListener(this.hrg);
        MessageManager.getInstance().unRegisterListener(this.hri);
        MessageManager.getInstance().unRegisterListener(this.hrj);
        MessageManager.getInstance().unRegisterListener(this.htH);
        MessageManager.getInstance().unRegisterListener(this.hrk);
        MessageManager.getInstance().unRegisterListener(this.hrh);
        MessageManager.getInstance().unRegisterListener(this.hrf);
    }

    private void cdy() {
        if (this.hrL != null && this.hrL.MA().getView() != null && this.hrL.MA().getView().getParent() != null) {
            ((ViewGroup) this.hrL.MA().getView().getParent()).removeView(this.hrL.MA().getView());
        }
        if (this.hqM != null && this.hqM.getParent() != null) {
            ((ViewGroup) this.hqM.getParent()).removeView(this.hqM);
        }
        if (this.hrL != null && this.hrL.MB().getView() != null) {
            this.hsx.removeView(this.hrL.MB().getView());
        }
        if (this.hrL != null) {
            this.hrL.MA().setMsgData(new LinkedList());
            this.hrL.Dc();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void a(at atVar) {
        if (this.hrL != null) {
            cdX();
            String nameShow = atVar.getNameShow();
            if (atVar.extInfoJson != null) {
                if (atVar.extInfoJson.optInt("is_mysterious_man") == 1) {
                    nameShow = atVar.extInfoJson.optString("mysterious_man_nickname");
                    if (TextUtils.isEmpty(nameShow)) {
                        nameShow = "神秘人";
                    }
                }
            }
            this.hrL.MB().setEditText(" @" + nameShow + " ");
        }
        if (this.hrv != null) {
            this.hrv.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void g(com.baidu.live.data.a aVar) {
        if (this.hrL != null) {
            cdX();
            String nameShow = aVar.getNameShow();
            if (aVar.extInfoJson != null) {
                if (aVar.extInfoJson.optInt("is_mysterious_man") == 1) {
                    nameShow = aVar.extInfoJson.optString("mysterious_man_nickname");
                    if (TextUtils.isEmpty(nameShow)) {
                        nameShow = "神秘人";
                    }
                }
            }
            this.hrL.MB().setEditText(" @" + nameShow + " ");
        }
        if (this.hrv != null) {
            this.hrv.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void Ie(String str) {
        if (this.hrL != null) {
            cdX();
            StringBuilder sb = new StringBuilder();
            sb.append(" @");
            sb.append(str);
            sb.append(" ");
            if (com.baidu.live.af.a.SE().bwi.aOG != null && com.baidu.live.af.a.SE().bwi.aOG.originTexts != null && com.baidu.live.af.a.SE().bwi.aOG.originTexts.size() > 0) {
                this.hrL.MB().Ox();
                this.hrL.MB().setEditText(sb.toString() + com.baidu.live.af.a.SE().bwi.aOG.originTexts.get(0));
            } else {
                this.hrL.MB().setEditText(sb.toString());
            }
        }
        if (this.hrv != null) {
            this.hrv.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void b(at atVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected View cdz() {
        if (this.hrL != null) {
            return this.hrL.MB().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean cdA() {
        if (this.hrL == null || !this.hrL.MB().Ov()) {
            return false;
        }
        nG(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected boolean cdB() {
        return this.hqz == null || this.hqz.cdB();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    /* renamed from: cfj */
    public PendantParentView cdC() {
        return this.bzK;
    }

    public ViewGroup cfk() {
        return this.htG;
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
                    this.hsB = false;
                    P(intExtra, intExtra2, intExtra3);
                    return;
                }
                cds();
                return;
            }
            azK();
        } else if (i == 25051 && i2 == -1 && this.hsM != null) {
            this.hsM.cid();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.hrL != null && this.hrL.MA() != null) {
            this.hrL.MA().onKeyboardVisibilityChanged(z);
        }
        if (z || this.hrL == null || this.hrL.MB() == null || !this.hrL.MB().Ov()) {
            if (z) {
                if (this.hrv != null) {
                    this.hrv.setVisibility(8);
                }
                if (this.hrN != null && this.hrN.Ho() != null) {
                    this.hrN.Ho().setVisibility(8);
                }
                cdE();
                if (this.hrL != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hrL.MB().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.hrL.MB().getView().setLayoutParams(layoutParams);
                    this.hrL.MB().getView().setVisibility(0);
                    this.hrL.MB().setQuickInputPanelVisible(false);
                    this.hrL.MC().cr(false);
                }
                if (this.hsw != null) {
                    this.hsw.setVisibility(8);
                }
                if (this.hqE != null) {
                    this.hqE.setVisible(8);
                }
                if (this.hrM != null) {
                    this.hrM.Db();
                }
                if (this.hsp != null) {
                    this.hsp.setCanVisible(false);
                }
                if (this.hsf != null) {
                    this.hsf.setCanVisible(false);
                }
                if (this.hsh != null) {
                    this.hsh.setCanVisible(false);
                }
                if (this.hsi != null) {
                    this.hsi.setCanVisible(false);
                }
                if (this.hsj != null) {
                    this.hsj.setCanVisible(false);
                }
                if (this.hsk != null) {
                    this.hsk.setVisible(8);
                }
                if (this.htE != null) {
                    this.htE.setCanVisible(false);
                }
                if (this.hsl != null) {
                    this.hsl.setCanVisible(false);
                }
                if (cfk() != null) {
                    cfk().setVisibility(8);
                }
            } else {
                cdD();
            }
            if (this.hrZ != null) {
                this.hrZ.bB(z);
            }
            ceZ();
        }
    }

    private void cdD() {
        if (this.hrv != null) {
            this.hrv.setVisibility(0);
        }
        if (this.hqM != null) {
            if (this.htJ) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqM.getLayoutParams();
                layoutParams.bottomMargin = (O(false, false) - ceG().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) + com.baidu.live.al.c.Xv();
                this.hqM.setLayoutParams(layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hqM.getLayoutParams();
                layoutParams2.bottomMargin = ceG().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds90);
                this.hqM.setLayoutParams(layoutParams2);
            }
        }
        if (this.hrL != null) {
            cea();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hrL.MB().getView().getLayoutParams();
            layoutParams3.bottomMargin = 0;
            this.hrL.MB().getView().setLayoutParams(layoutParams3);
            if (this.aOI) {
                if (this.hrL.MC().isClicked()) {
                    this.hrL.MC().cr(false);
                } else {
                    this.hrL.MC().cr(true);
                }
            } else {
                this.hrL.MC().cr(false);
            }
        }
        if (this.hrv != null) {
            this.hrv.setVisibility(0);
        }
        if (this.hrN != null && this.hrN.Ho() != null) {
            this.hrN.Ho().setVisibility(0);
        }
        if (this.hsw != null) {
            this.hsw.setVisibility(0);
        }
        if (this.hqE != null) {
            this.hqE.setVisible(0);
        }
        if (this.hrM != null) {
            this.hrM.Db();
        }
        if (this.hsp != null) {
            this.hsp.setCanVisible(true);
        }
        if (this.hsf != null) {
            this.hsf.setCanVisible(true);
        }
        if (this.hsj != null) {
            this.hsj.setCanVisible(true);
        }
        if (this.hsk != null) {
            this.hsk.setVisible(0);
        }
        if (this.hsh != null) {
            this.hsh.setCanVisible(!this.gSr);
        }
        if (this.hsi != null) {
            this.hsi.setCanVisible(true);
        }
        if (this.htE != null) {
            this.htE.setCanVisible(true);
        }
        if (this.hsl != null) {
            this.hsl.setCanVisible(true);
        }
        if (cfk() != null) {
            cfk().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdE() {
        boolean z;
        boolean z2;
        if (this.hqM != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqM.getLayoutParams();
            if (this.hrL == null || this.hrL.MB() == null) {
                z = false;
                z2 = false;
            } else {
                boolean Ot = this.hrL.MB().Ot();
                z = this.hrL.MB().Ou();
                z2 = Ot;
            }
            int O = O(z2, z);
            if (layoutParams.bottomMargin != O) {
                layoutParams.bottomMargin = O;
                this.hqM.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nG(boolean z) {
        this.htI = z;
        if (z) {
            this.hrL.MB().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqM.getLayoutParams();
            int quickInputPanelExpandHeight = this.hrL.MB().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.hqM.setLayoutParams(layoutParams);
                if (this.hrL.MA() != null) {
                    this.hrL.MA().Mz();
                    return;
                }
                return;
            }
            return;
        }
        cdD();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.hqy != null) {
                this.hqy.dU(i3);
            }
            if (this.hqA != null) {
                this.hqA.dU(i3);
            }
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public boolean ff(int i) {
        boolean ff = super.ff(i);
        if (ff && 2 == i) {
            if (this.hqz.cdB()) {
                return false;
            }
            if (ff && this.hrG != null) {
                this.hrG.oM(false);
            }
        }
        return ff;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void wJ(int i) {
        super.wJ(i);
        if (i == 7 || i == 11) {
            if (this.hrv != null) {
                this.hrv.setVisibility(8);
            }
            if (this.hrL != null) {
                this.hrL.MA().getView().setVisibility(4);
                this.hrL.MC().getView().setVisibility(4);
            }
            if (this.hqE != null) {
                this.hqE.bP(2, 8);
                if (this.gSr) {
                    this.hqE.bP(1, 8);
                }
            }
            if (this.hsb != null) {
                this.hsb.oG(false);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public void fg(int i) {
        super.fg(i);
        if (i == 7 || i == 11) {
            if (this.hrv != null) {
                this.hrv.setVisibility(0);
            }
            if (this.hrL != null) {
                this.hrL.MA().getView().setVisibility(0);
                if (this.aOI && !this.hrL.MC().isClicked()) {
                    this.hrL.MC().cr(true);
                }
            }
            if (this.hqE != null) {
                this.hqE.setVisible(0);
            }
            if (this.hsb != null) {
                this.hsb.oG(true);
            }
            this.hsw.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.hqB != null) {
            this.hqB.cnf();
        }
        if (this.hqG != null) {
            this.hqG.DL();
        }
        if (this.hqE != null) {
            this.hqE.onStop();
        }
        if (this.hqF != null) {
            this.hqF.bo(true);
        }
        if (this.hsu != null) {
            this.hsu.onStopped();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.hqB != null) {
            this.hqB.cne();
        }
        if (this.hqG != null && this.htD) {
            this.hqG.DM();
        }
        if (this.hqE != null) {
            this.hqE.onStart();
        }
        if (this.hqF != null) {
            this.hqF.bo(false);
        }
        if (this.hsu != null) {
            this.hsu.onStarted();
        }
        if (this.htE != null) {
            this.htE.onStart();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        if (!onKeyDown && i == 4 && this.hsu != null && this.hsu.onKeyDown(i, keyEvent)) {
            return true;
        }
        return onKeyDown;
    }
}
