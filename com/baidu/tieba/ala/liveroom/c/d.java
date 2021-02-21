package com.baidu.tieba.ala.liveroom.c;

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
import com.baidu.live.am.c;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.e;
import com.baidu.live.challenge.h;
import com.baidu.live.challenge.i;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveSdkInfo;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.ab;
import com.baidu.live.data.ak;
import com.baidu.live.data.ao;
import com.baidu.live.data.ax;
import com.baidu.live.data.bg;
import com.baidu.live.data.bk;
import com.baidu.live.data.bv;
import com.baidu.live.data.co;
import com.baidu.live.data.cw;
import com.baidu.live.data.u;
import com.baidu.live.data.v;
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
import com.baidu.tieba.ala.liveroom.i.b;
import com.baidu.tieba.ala.liveroom.i.g;
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends b implements com.baidu.live.m.c {
    private PendantParentView byA;
    private boolean gQF;
    private com.baidu.live.e.a hqA;
    private i hqB;
    private h hqC;
    private com.baidu.tieba.ala.liveroom.b.a hqD;
    private FrameLayout hqH;
    private com.baidu.tieba.ala.liveroom.i.b hqQ;
    private com.baidu.tieba.ala.liveroom.audiencelist.c hqt;
    private com.baidu.tieba.ala.liveroom.m.a hqu;
    private com.baidu.tieba.ala.liveroom.f.b hqv;
    private com.baidu.tieba.ala.liveroom.t.b hqw;
    private com.baidu.tieba.ala.liveroom.audiencelist.b hqx;
    private com.baidu.tieba.ala.liveroom.k.a hqy;
    private com.baidu.tieba.ala.liveroom.activeview.b hqz;
    private LinearLayout htr;
    private e hts;
    private boolean htt;
    private boolean htu;
    private com.baidu.tieba.ala.liveroom.apppromotion.a htw;
    private com.baidu.live.follow.pendant.a htx;
    private LinearLayout hty;
    private int htz;
    private long lastClickTime = 0;
    private int bottomMargin = 0;
    private boolean htv = false;
    private HttpRule hqR = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.hqB != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.hqB.AG()) {
                httpMessage.addParam("ala_challenge_id", d.this.hqB.AJ());
            }
            return httpMessage;
        }
    };
    private HttpRule hqS = new HttpRule(1021229) { // from class: com.baidu.tieba.ala.liveroom.c.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.hqB != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.hqB.AG()) {
                httpMessage.addParam("challenge_id", d.this.hqB.AJ());
            }
            return httpMessage;
        }
    };
    private HttpRule hqT = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.c.d.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.hqB != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.hqB.AG()) {
                httpMessage.addParam("challenge_id", d.this.hqB.AJ());
            }
            return httpMessage;
        }
    };
    private HttpRule hqU = new HttpRule(1021232) { // from class: com.baidu.tieba.ala.liveroom.c.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.hqB != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.hqB.AG()) {
                httpMessage.addParam("challenge_id", d.this.hqB.AJ());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c hqV = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.c.d.22
        @Override // com.baidu.live.liveroom.g.c
        public void Nd() {
            if (d.this.hrA != null) {
                d.this.hrA.oS(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cI(boolean z) {
            if (z) {
                if (d.this.hrA != null) {
                    d.this.hrA.oS(true);
                }
            } else if (d.this.hrA != null) {
                d.this.hrA.oS(false);
            }
            if (d.this.hrT != null) {
                d.this.hrT.bD(z);
            }
            if (d.this.hqz != null) {
                d.this.hqz.nJ(z ? false : true);
            }
            com.baidu.live.p.a.cJ(z);
        }
    };
    private HttpMessageListener hqZ = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.d.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Ow() != null) {
                        com.baidu.live.ae.e.Qz().bBd = getQuickGiftHttpResponseMessage.Ow();
                        d.this.cat();
                    }
                }
            }
        }
    };
    CustomMessageListener hre = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.c.d.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.hqQ.c(d.this.cbP());
                } else if (d.this.cbb() || !g.vB(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.26.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.cbP().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.cbP().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    d.this.hqQ.c(d.this.hqH, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener hra = new CustomMessageListener(2913276) { // from class: com.baidu.tieba.ala.liveroom.c.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            JSONObject optJSONObject;
            JSONArray optJSONArray;
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject) && (optJSONObject = ((JSONObject) customResponsedMessage.getData()).optJSONObject("ext_data")) != null && (optJSONArray = optJSONObject.optJSONArray("surprise_prize_member")) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                View inflate = LayoutInflater.from(d.this.activity).inflate(a.g.ala_fudai_dialog_layout, (ViewGroup) null);
                final Dialog dialog = new Dialog(d.this.cbP().pageContext.getPageActivity(), a.i.FudaiDialogStyle);
                dialog.requestWindowFeature(1);
                dialog.setContentView(inflate);
                dialog.setCancelable(false);
                View findViewById = inflate.findViewById(a.f.ala_fudai_negative_btn);
                View findViewById2 = inflate.findViewById(a.f.ala_fudai_positive_btn);
                TextView textView = (TextView) inflate.findViewById(a.f.ala_fudai_tbean_num);
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.d.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.d.2.2
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
    private CustomMessageListener htA = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.c.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.cbb() || !g.vB(2913128)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.vz(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    d.this.HD(str);
                }
            }
        }
    };
    private CustomMessageListener hrb = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.c.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.hrI.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener hrc = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.c.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.hsv != null && d.this.hsv.biY != null && !d.this.hsv.bjd && !d.this.hsv.bje && d.this.hrS != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.cbP().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                if (d.this.hrF != null && d.this.hrF.Kf().Ml()) {
                    layoutParams.bottomMargin = d.this.cbP().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds88);
                } else {
                    layoutParams.bottomMargin = d.this.cbP().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                }
                d.this.hrS.c(d.this.hqH, layoutParams);
                if (com.baidu.live.guardclub.e.IS() != null) {
                    com.baidu.live.guardclub.e.IS().IX();
                }
            }
        }
    };
    private CustomMessageListener hrd = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.d.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.bgE != null) {
                    d.this.bgE.dismiss();
                }
                com.baidu.live.im.b.d.KN().setSwitchStatus(true);
                com.baidu.live.im.b.d.KN().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.cbg();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b hrf = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.d.18
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void v(View view, int i) {
            bv bvVar;
            String str;
            bv bvVar2;
            co coVar;
            String str2;
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
                        alaStaticItem.addParams("gifts_value", com.baidu.live.ae.e.Qz().bBd.ES().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.ae.e.Qz().bBd.ES().DR());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.ae.e.Qz().bBd.ES().DS());
                        if (d.this.cbP().hBH.Fm() != null && d.this.cbP().hBH.Fm().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.cbP().hBH.Fm().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.cbP().hBH.Fm().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.Lo());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.HZ()) {
                        if (com.baidu.live.d.xc().getBoolean("quick_gift_guide_show", true) && !d.this.cbb()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, ah.class, d.this.cbP().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                ah ahVar = (ah) runTask.getData();
                                ahVar.setPageContext(d.this.cbP().pageContext);
                                ahVar.setLiveShowData(d.this.cbP().hBH.Fm());
                                ahVar.setGiftItem(com.baidu.live.ae.e.Qz().bBd.ES());
                                ahVar.setOtherParams(d.this.Lo());
                                ahVar.initView();
                                ahVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.d.18.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        d.this.nP(false);
                                    }
                                });
                                ahVar.show();
                                d.this.nP(true);
                                return;
                            }
                            return;
                        }
                        n.a(d.this.cbP().pageContext, d.this.cbP().hBH.Fm(), com.baidu.live.ae.e.Qz().bBd.ES(), d.this.Lo());
                    }
                } else if (i == 1) {
                    if (d.this.hrF != null) {
                        d.this.cbg();
                    }
                } else if (i == 3 && d.this.HZ()) {
                    if (com.baidu.live.p.a.isDebug()) {
                        com.baidu.live.p.a.c(d.this.cbP().hBH.Fm().mLiveInfo.live_id, 0);
                        return;
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    d.this.hrs.d(d.this.cbP().hBH.Fm(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.cbP() != null && d.this.cbP().hBH != null && d.this.cbP().hBH.Fm() != null && d.this.cbP().hBH.Fm().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.cbP().hBH.Fm().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.cbP().hBH.Fm().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.cbP().hBH.Fm().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.Lo());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.cbP() != null && d.this.cbP().hBH != null && d.this.cbP().hBH.Fm() != null && d.this.cbP().hBH.Fm().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.cbP().hBH.Fm().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.cbP().hBH.Fm().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.cbP().hBH.Fm().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.Lo());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.brL != null) {
                        d.this.brL.cC(false);
                    }
                } else if (i == 12) {
                    if (d.this.hrA != null && d.this.cbP().hBH.Fm() != null && d.this.cbP().hBH.Fm().mLiveInfo != null) {
                        String valueOf = String.valueOf(d.this.cbP().hBH.Fm().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.cbP().hBH.Fm().mLiveInfo.room_id);
                        String str3 = null;
                        AlaLiveSdkInfo alaLiveSdkInfo = d.this.cbP().hBH.Fm().mLiveSdkInfo;
                        if (alaLiveSdkInfo != null && alaLiveSdkInfo.mCastIds != null) {
                            str3 = String.valueOf(d.this.cbP().hBH.Fm().mLiveSdkInfo.mCastIds.chatMCastId);
                        }
                        d.this.hrA.ax(valueOf, valueOf2, str3);
                        com.baidu.live.p.a.c(d.this.cbP().hBH.Fm().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    ab Fm = d.this.cbP().hBH.Fm();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.cbP().pageContext.getPageActivity(), Fm.aId.userName, Long.toString(Fm.aId.userId), Long.toString(Fm.aId.charmCount), String.valueOf(Fm.mLiveInfo.group_id), String.valueOf(Fm.mLiveInfo.live_id), false, String.valueOf(Fm.aId.userId), Long.toString(Fm.aIz.userId), Fm.aIz.userName, Fm.aIz.portrait, d.this.hqx.getCount(), d.this.Lo())));
                    LogManager.getCommonLogger().doClickGusetNumLog(Fm.mLiveInfo.feed_id, d.this.hqx.getCount() + "", d.this.Lo());
                } else if (i == 11) {
                    d.this.cbl();
                    d.this.cbm();
                } else if (i == 16) {
                    if (d.this.cbP() != null && (bvVar2 = com.baidu.live.ae.a.Qj().bAS) != null && (coVar = bvVar2.aPM) != null) {
                        String str4 = coVar.aRu.aRD;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (d.this.cbP().hBH != null && d.this.cbP().hBH.Fm() != null && d.this.cbP().hBH.Fm().mLiveInfo != null) {
                                j = d.this.cbP().hBH.Fm().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", d.this.cbP().hBH.Fm().mLiveInfo.room_id + "", d.this.cbP().hBH.Fm().mLiveInfo.feed_id, d.this.Lo());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.cbP().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (d.this.cbP() != null) {
                        ab abVar = null;
                        if (d.this.cbP().hBH != null) {
                            abVar = d.this.cbP().hBH.Fm();
                        }
                        if (abVar != null && abVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.u.b.ckE().bvg != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.u.b.ckE().bvg.aHq;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + abVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + abVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(d.this.cbP().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17 && d.this.HZ() && d.this.cbP() != null && (bvVar = com.baidu.live.ae.a.Qj().bAS) != null && bvVar.aPM != null) {
                    String str6 = bvVar.aPM.aRA;
                    if (!TextUtils.isEmpty(str6)) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                        if (d.this.cbP().hBH != null && d.this.cbP().hBH.Fm() != null) {
                            if (d.this.hrU == null) {
                                d.this.hrU = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.cbP().pageContext.getPageActivity());
                            }
                            ab Fm2 = d.this.cbP().hBH.Fm();
                            String b2 = d.this.hrU.b(str6, Fm2.mLiveInfo.live_id, Fm2.aIz.userId, Fm2.aId.userId);
                            com.baidu.live.an.c cVar = new com.baidu.live.an.c();
                            cVar.url = b2;
                            d.this.bgE.a(cVar);
                        }
                    }
                }
            }
        }
    };
    private boolean htB = false;
    private boolean htC = false;

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
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void m(ab abVar) {
        super.m(abVar);
        g.cfs();
        this.htv = true;
        this.htC = false;
        this.htB = false;
        cbP().hBI.setIsForceHandledTouch(false);
        cbP().hBI.setSwipeClearEnable(true);
        cbP().hBI.setOnLiveViewScrollListener(this.hqV);
        cbP().hBI.setOnClickListener(null);
        cbP().hBI.setClickable(false);
        if (this.hrx != null) {
            this.hrx.b(this.hrf);
        }
        if (this.hso != null) {
            this.hso.setVisibility(0);
        }
        cal();
        if (this.hrQ != null) {
            this.hrQ.a(abVar, this.byA);
            this.hrQ.U(this.hsp);
            this.hrQ.a(this);
        }
        ccm();
        cax();
        caX();
        caW();
        cay();
        caC();
        caz();
        ccb();
        nQ(false);
        cau();
        cav();
        cbo();
        caH();
        cbq();
        caE();
        caF();
        cce();
        ccf();
        cbw();
        nS(false);
        cbt();
        cbx();
        caj();
        cbH();
        can();
        cat();
        cao();
        cap();
        caq();
        car();
        caf();
        cbv();
        cbD();
        cbp();
        cbu();
        nW(true);
        cbG();
        c(this.grF);
        cak();
        ccc();
        cbC();
        cba();
        ccd();
        MessageManager.getInstance().registerListener(this.hqZ);
        MessageManager.getInstance().registerListener(this.hrb);
        MessageManager.getInstance().registerListener(this.hrc);
        MessageManager.getInstance().registerListener(this.hrd);
        MessageManager.getInstance().registerListener(this.htA);
        MessageManager.getInstance().registerListener(this.hre);
        MessageManager.getInstance().registerListener(this.hra);
        caI();
        caB();
        cbs();
        I(abVar);
    }

    private void I(ab abVar) {
        if (cbP() != null && cbP().brO != null && abVar != null && abVar.mLiveInfo != null && abVar.aJq != null && com.baidu.live.ae.a.Qj().buX.aMx) {
            if ("1".equals(abVar.mLiveInfo.pubShowId)) {
                if (abVar.aJq.aJO == 0) {
                    this.htz = 0;
                } else if (abVar.aJq.aJO == 1) {
                    this.htz = 8;
                } else if (abVar.aJq.aJO == 2) {
                    this.htz = 7;
                } else {
                    this.htz = 0;
                }
            } else {
                this.htz = 0;
            }
            cbP().brO.setVideoMode(this.htz);
            cco();
        }
    }

    private void ccb() {
    }

    private void ccc() {
        AlaVideoBCChatData alaVideoBCChatData;
        CustomResponsedMessage runTask;
        AlaLiveUserInfoData alaLiveUserInfoData = cbP().hBH.Fm().aIz;
        if (alaLiveUserInfoData != null && (alaVideoBCChatData = alaLiveUserInfoData.videoBCEnterData) != null && alaVideoBCChatData.isShowEnter()) {
            if (this.hsm == null && (runTask = MessageManager.getInstance().runTask(2913255, com.baidu.live.am.c.class, cbP().pageContext)) != null && runTask.getData() != null) {
                this.hsm = (com.baidu.live.am.c) runTask.getData();
            }
            if (this.hsm != null) {
                this.hsm.a(cbP().brO);
                this.hsm.b(cbP().hBG.getMastView());
                this.hsm.r(cbP().hBH.Fm());
                this.hsm.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.23
                    @Override // com.baidu.live.am.c.a
                    public void VH() {
                        if (d.this.hrx != null) {
                            d.this.cbP().hBI.hRw = false;
                            d.this.hrx.setPraiseEnable(false);
                            if (d.this.cbP().hBJ != null) {
                                d.this.cbP().hBJ.setTalentShowing(true);
                            }
                        }
                    }

                    @Override // com.baidu.live.am.c.a
                    public void VI() {
                        if (d.this.hrx != null) {
                            d.this.cbP().hBI.hRw = true;
                            d.this.hrx.setPraiseEnable(true);
                            if (d.this.cbP().hBJ != null) {
                                d.this.cbP().hBJ.setTalentShowing(false);
                            }
                        }
                    }
                });
                View enterView = this.hsm.getEnterView();
                if (enterView != null) {
                    if (enterView.getParent() != null) {
                        ((ViewGroup) enterView.getParent()).removeView(enterView);
                    }
                    this.hrp.cv(enterView);
                }
            }
        }
    }

    public void ccd() {
        this.htx = new com.baidu.live.follow.pendant.a(getActivity());
    }

    private void caf() {
        if (this.hse != null) {
            this.hse.a(new com.baidu.live.y.c() { // from class: com.baidu.tieba.ala.liveroom.c.d.24
                @Override // com.baidu.live.y.c
                public void cP(boolean z) {
                    if (d.this.hqC != null) {
                        d.this.hqC.setNeedCloseRecommendFloat(z);
                    }
                    if (d.this.cbP().hBI.hRw) {
                        if (d.this.hrA != null) {
                            d.this.hrA.oK(z);
                            d.this.hrA.oS(!z);
                        }
                        if (d.this.hrx != null) {
                            d.this.hrx.oK(z);
                            d.this.hrx.setPraiseEnable(!z);
                            d.this.hrx.oJ(z ? false : true);
                        }
                    }
                }
            });
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
        if (this.htx != null) {
            if (this.htx.d(abVar) && !this.htx.isDisplay()) {
                ccn();
                this.htt = true;
                this.htu = true;
                if (this.hsa != null) {
                    this.hsa.aW(true);
                    this.hsa.aX(true);
                }
                if (this.hrx != null) {
                    this.hrx.setPraiseEnable(false);
                    cbP().hBI.hRw = false;
                }
                ccg();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.topMargin = (int) getActivity().getResources().getDimension(a.d.sdk_ds16);
                ak akVar = abVar.aJq;
                if (akVar != null) {
                    this.htx.m(akVar.anchorPortrait, akVar.aHy, String.valueOf(akVar.aJM));
                    this.htx.b(ccu(), layoutParams);
                }
            } else if (!this.htx.d(abVar) && this.htx.isDisplay()) {
                this.htx.Dr();
                this.htt = false;
                this.htu = false;
                if (this.hsa != null) {
                    this.hsa.aW(false);
                    this.hsa.aX(false);
                }
                if (this.hrx != null) {
                    this.hrx.setPraiseEnable(true);
                    cbP().hBI.hRw = true;
                }
                ccg();
                if (this.hty != null) {
                    this.hty.removeAllViews();
                    this.hty = null;
                }
            }
        }
        nW(false);
        if (this.hqz != null) {
            this.hqz.j(abVar);
            this.hqz.nI(this.hsy);
            this.hqz.updateView();
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

    private void cah() {
        if (this.hrz != null) {
            this.hrz.aJ(cbP().hBG.getLiveContainerView());
        }
    }

    private void cce() {
        if (this.hqD == null) {
            this.hqD = new com.baidu.tieba.ala.liveroom.b.a(cbP().pageContext);
        }
        if (cbP().hBH != null && cbP().hBH.Fm() != null && cbP().hBH.Fm().mLiveInfo != null) {
            this.hqD.Hx(String.valueOf(cbP().hBH.Fm().mLiveInfo.user_id));
        }
    }

    private void ccf() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (cbP() != null && cbP().hBH != null && cbP().hBH.Fm() != null && cbP().hBH.Fm().mLiveInfo != null) {
                j = cbP().hBH.Fm().mLiveInfo.room_id;
            }
            if (this.hrN == null) {
                this.hrN = new com.baidu.tieba.ala.liveroom.guide.a(cbP().pageContext, j);
            }
            this.hrN.nO(this.hsr);
            this.hrN.a(new a.InterfaceC0666a() { // from class: com.baidu.tieba.ala.liveroom.c.d.7
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0666a
                public void ccv() {
                    if (d.this.brL != null) {
                        d.this.brL.cC(true);
                    }
                }
            });
            this.hrN.aF(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cv(int i) {
        super.cv(i);
        cah();
        if (this.hqC != null) {
            this.hqC.cv(i);
        }
    }

    private void cal() {
        if (this.byA == null) {
            this.byA = new PendantParentView(cbP().pageContext.getPageActivity(), cch());
            cbP().hBI.addView(this.byA, new ViewGroup.LayoutParams(-1, -1));
            this.byA.setDefaultItemMargin(cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.byA.setPadding(cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            ccg();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void nL(boolean z) {
        if (z) {
            this.bottomMargin = cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds180);
        } else {
            this.bottomMargin = cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
        }
        ccg();
    }

    private void ccg() {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        if (this.byA != null) {
            this.byA.setModel(cch());
            int dimensionPixelSize3 = cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds220);
            if (this.bottomMargin != 0) {
                dimensionPixelSize = this.bottomMargin;
            } else {
                dimensionPixelSize = cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            }
            if (this.gQF) {
                dimensionPixelSize2 = ccs();
            } else {
                dimensionPixelSize2 = cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds250);
            }
            this.byA.setPosition(dimensionPixelSize3, 0, dimensionPixelSize2, dimensionPixelSize);
            return;
        }
        cal();
    }

    private PendantParentView.Model cch() {
        if (this.gQF) {
            return PendantParentView.Model.VERTICAL_PK;
        }
        if (this.htt) {
            return PendantParentView.Model.VERTICAL_BB_CHATING;
        }
        return PendantParentView.Model.VERTICAL;
    }

    private void cci() {
        if (cbP().hBI != null && !this.htC) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.8
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.hqH != null && d.this.hrF != null && d.this.hrF.Kd() != null && d.this.hrF.Kd().getView() != null) {
                        if (d.this.gQF && !d.this.hss && d.this.cbP().hBI != null && d.this.cbP().hBI.getHeight() > 0 && !d.this.htu) {
                            int bp = d.this.hqC != null ? d.this.hqC.bp(false) : 0;
                            ViewGroup.LayoutParams layoutParams = d.this.hqH.getLayoutParams();
                            int height = d.this.cbP().hBI.getHeight() - bp;
                            int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                i += UtilHelper.getStatusBarHeight();
                            }
                            if (layoutParams != null && d.this.hrF != null) {
                                layoutParams.height = i + d.this.cbP().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                                d.this.hqH.setLayoutParams(layoutParams);
                                ViewGroup.LayoutParams layoutParams2 = d.this.hrF.Kd().getView().getLayoutParams();
                                if (layoutParams2 != null) {
                                    layoutParams2.height = layoutParams.height - com.baidu.live.aj.c.ds(false);
                                    d.this.hrF.Kd().getView().setLayoutParams(layoutParams2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        int j = com.baidu.live.aj.c.j(false, d.this.hss);
                        if (d.this.hsp.indexOfChild(d.this.hqH) != -1 && d.this.hqH.getLayoutParams() != null) {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) d.this.hqH.getLayoutParams();
                            layoutParams3.height = com.baidu.live.aj.c.d(false, false, d.this.hss);
                            d.this.hqH.setLayoutParams(layoutParams3);
                        }
                        if (d.this.hqH.indexOfChild(d.this.hrF.Kd().getView()) != -1 && d.this.hrF.Kd().getView().getLayoutParams() != null) {
                            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) d.this.hrF.Kd().getView().getLayoutParams();
                            layoutParams4.height = j;
                            d.this.hrF.Kd().getView().setLayoutParams(layoutParams4);
                        }
                        d.this.hrF.Kd().Kc();
                    }
                }
            });
        }
    }

    private void ccj() {
        if (cbP().hBI != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.9
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.hrH != null) {
                        if (d.this.gQF && !d.this.hss && d.this.cbP().hBI != null && d.this.cbP().hBI.getHeight() > 0) {
                            int height = (d.this.cbP().hBI.getHeight() - (d.this.hqC != null ? d.this.hqC.bp(false) : 0)) + d.this.cbP().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            if (d.this.hrH != null) {
                                d.this.hrH.cH(height);
                            }
                        } else if (d.this.hrH != null) {
                            d.this.hrH.cH(com.baidu.live.aj.a.b(d.this.cbP().pageContext.getPageActivity(), false, false, d.this.hss));
                        }
                    }
                }
            });
        }
    }

    private void cck() {
        if (cbP().hBI != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.10
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    if (d.this.hrH != null) {
                        int i2 = com.baidu.live.aj.a.i(false, false);
                        if (!d.this.gQF || d.this.cbP().hBI == null || d.this.cbP().hBI.getHeight() <= 0) {
                            i = i2;
                        } else {
                            int height = d.this.cbP().hBI.getHeight() - (d.this.hqC != null ? d.this.hqC.bp(false) : 0);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            i = height + d.this.cbP().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                        }
                        if (d.this.hrH != null) {
                            d.this.hrH.cI(i);
                        }
                    }
                }
            });
        }
    }

    private void ccl() {
        if (this.hrG != null && this.hrG.zP() != null) {
            ViewGroup.LayoutParams layoutParams = this.hrG.zP().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = cbP().pageContext.getResources().getDimensionPixelOffset(this.gQF ? a.d.sdk_ds100 : a.d.sdk_ds20);
                this.hrG.zP().setLayoutParams(layoutParams);
            }
        }
    }

    private void ccm() {
        if (this.htr == null) {
            this.htr = new LinearLayout(cbP().pageContext.getPageActivity());
            this.htr.setOrientation(1);
        }
        if (this.htr.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds160);
            layoutParams.leftMargin = cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            cbP().hBI.addView(this.htr, layoutParams);
        }
    }

    private void ccn() {
        if (ccu() == null && com.baidu.live.ae.a.Qj().buX != null) {
            if (!com.baidu.live.ae.a.Qj().buX.aMx) {
                this.htz = 0;
            }
            cco();
        }
    }

    private void cco() {
        List<cw.a> list;
        int i;
        if (cbP() != null && cbP().hBG != null && cbP().hBG.getMastView() != null && cbP().hBH != null && cbP().pageContext != null && cbP().pageContext.getResources() != null) {
            com.baidu.live.ae.a Qj = com.baidu.live.ae.a.Qj();
            if (Qj.buX != null && Qj.buX.aNv != null && (list = com.baidu.live.ae.a.Qj().buX.aNv.dataList) != null && list.size() >= 2) {
                cw.a aVar = list.get(1) == null ? cw.a.aSP.get(1) : list.get(1);
                int i2 = com.baidu.live.ae.a.Qj().buX.aNv.aSK;
                int i3 = com.baidu.live.ae.a.Qj().buX.aNv.aSL;
                DisplayMetrics displayMetrics = cbP().pageContext.getResources().getDisplayMetrics();
                int i4 = displayMetrics.widthPixels;
                int i5 = displayMetrics.heightPixels;
                if (this.activity != null && com.baidu.live.utils.d.bd(this.activity)) {
                    i5 += com.baidu.live.utils.d.bi(this.activity);
                }
                int i6 = (((i2 * i5) / i3) - i4) / 2;
                int i7 = (aVar.width * i5) / i3;
                if (this.htz == 0) {
                    i = ((aVar.x * i5) / i3) - i6;
                } else if (this.htz == 8) {
                    i = (aVar.x * i5) / i3;
                } else {
                    i = this.htz == 7 ? ((aVar.x * i5) / i3) - (i6 * 2) : 0;
                }
                int i8 = (aVar.height * i5) / i3;
                int i9 = (aVar.y * i5) / i3;
                if (this.hty == null) {
                    this.hty = new LinearLayout(cbP().pageContext.getPageActivity());
                    this.hty.setOrientation(1);
                }
                if (this.hty.getParent() == null) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((i >= 0 || this.htz != 0) ? i7 : i7 + i, -2);
                    layoutParams.gravity = 8388659;
                    layoutParams.topMargin = i9 + i8;
                    if (!UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams.topMargin += UtilHelper.getImmersiveStickyBarHeight();
                    } else if (com.baidu.live.utils.d.Vl() && this.activity != null) {
                        layoutParams.topMargin += com.baidu.live.utils.d.bi(this.activity);
                    }
                    if (i < 0 && this.htz == 0) {
                        i = 0;
                    }
                    layoutParams.leftMargin = i;
                    cbP().hBG.getMastView().addView(this.hty, layoutParams);
                } else if (this.hty != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hty.getLayoutParams();
                    if (i < 0 && this.htz == 0) {
                        i7 += i;
                    }
                    if (i < 0 && this.htz == 0) {
                        i = 0;
                    }
                    layoutParams2.topMargin = i9 + i8;
                    if (!UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin += UtilHelper.getImmersiveStickyBarHeight();
                    } else if (com.baidu.live.utils.d.Vl() && this.activity != null) {
                        layoutParams2.topMargin += com.baidu.live.utils.d.bi(this.activity);
                    }
                    layoutParams2.width = i7;
                    layoutParams2.leftMargin = i;
                    this.hty.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    private void can() {
        if (this.hqz == null) {
            this.hqz = new com.baidu.tieba.ala.liveroom.activeview.b(cbP().pageContext);
        }
        if (cbP() != null && cbP().hBH != null) {
            this.hqz.Ht(cbP().hBH.cjK());
        }
        this.hqz.aW(this.gQF);
        this.hqz.setOtherParams(Lo());
        this.hqz.c(cbP().hBH.Fm(), false);
        this.hqz.setHost(false);
        this.hqz.nI(this.hsy);
        this.hqz.a(1, this.byA);
        this.hqz.a(2, this.byA);
        this.hqz.setVisible(this.hss ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cat() {
        if (this.hrp == null) {
            caz();
        }
        this.hrp.setOtherParams(Lo());
        this.hrp.a(com.baidu.live.ae.e.Qz().bBd, cbP().hBH.Fm());
    }

    private void cao() {
        if (this.hqy == null) {
            this.hqy = new com.baidu.tieba.ala.liveroom.k.a(cbP().pageContext, this);
        }
        this.hqy.setOtherParams(Lo());
        this.hqy.a((ViewGroup) this.byA, cas());
        this.hqy.M(cbP().hBH.Fm());
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
            this.hsa.aW(this.gQF);
            this.hsa.setIsHorizontal(false);
            this.hsa.a(caN(), cbP().hBH.Fm());
            this.hsa.setIsHost(false);
            this.hsa.a(new a.InterfaceC0154a() { // from class: com.baidu.tieba.ala.liveroom.c.d.11
                @Override // com.baidu.live.a.a.InterfaceC0154a
                public void xi() {
                    d.this.ccp();
                }

                @Override // com.baidu.live.a.a.InterfaceC0154a
                public void xj() {
                    d.this.ccq();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccp() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccq() {
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
            this.hrp.a(new a.InterfaceC0671a() { // from class: com.baidu.tieba.ala.liveroom.c.d.13
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0671a
                public void bP(int i, int i2) {
                    ab Fm = d.this.cbP().hBH.Fm();
                    if (Fm != null && Fm.mLiveInfo != null) {
                        if (d.this.hrU == null) {
                            d.this.hrU = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.cbP().pageContext.getPageActivity());
                        }
                        d.this.hrU.d(d.this.hsp, i, i2);
                        d.this.hrU.a(String.valueOf(Fm.mLiveInfo.live_id), new a.InterfaceC0675a() { // from class: com.baidu.tieba.ala.liveroom.c.d.13.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0675a
                            public void a(float f, String str) {
                                if (d.this.hrp != null) {
                                    d.this.hrp.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0671a
                public void bQ(int i, int i2) {
                    if (d.this.hrU != null) {
                        d.this.hrU.bV(i, i2);
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
            this.hqQ = new com.baidu.tieba.ala.liveroom.i.b(cbP().pageContext, Lo(), this.hsE, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.14
                @Override // com.baidu.tieba.ala.liveroom.i.b.a
                public void caQ() {
                    d.this.nP(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.i.b.a
                public void caR() {
                    d.this.nP(false);
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

    private void caH() {
        if (this.htw == null) {
            this.htw = new com.baidu.tieba.ala.liveroom.apppromotion.a(cbP().pageContext);
        }
        this.htw.b(caN(), cbP().hBH.Fm());
    }

    private LinearLayout.LayoutParams cas() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    private void cau() {
        CustomResponsedMessage runTask;
        if (this.hrF == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, cbP().pageContext)) != null && runTask.getData() != null) {
            this.hrF = (k) runTask.getData();
            this.hrF.setFromMaster(false);
            this.hrF.Kd().getView().setId(a.f.ala_liveroom_msg_list);
            this.hrF.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.15
                @Override // com.baidu.live.im.k.a
                public boolean Kh() {
                    return d.this.HZ();
                }

                @Override // com.baidu.live.im.k.a
                public void Ki() {
                    d.this.hsw = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hb(String str) {
                    if (!d.this.hss) {
                        d.this.nN(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.cbP().pageContext.getPageActivity(), d.this.cbP().hBG.getLiveContainerView());
                    }
                    d.this.HA(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Kj() {
                    if (d.this.hss) {
                        d.this.nN(true);
                        d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.15.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.cbP().pageContext.getPageActivity(), d.this.cbP().hBG.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.hrF != null) {
                        d.this.hrF.Ke().setQuickInputPanelVisible(false);
                        d.this.hrF.Ke().LZ();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Kk() {
                }

                @Override // com.baidu.live.im.k.a
                public void Kl() {
                    if (d.this.hss) {
                        d.this.caP();
                        if (d.this.hrG != null) {
                            d.this.hrG.zQ();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Km() {
                    return d.this.cbc();
                }

                @Override // com.baidu.live.im.k.a
                public int Kn() {
                    return d.this.cbd();
                }

                @Override // com.baidu.live.im.k.a
                public boolean Ko() {
                    ab Fm = d.this.cbP().hBH.Fm();
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
            int j = com.baidu.live.aj.c.j(false, false);
            if (this.hsp.indexOfChild(this.hqH) < 0) {
                if (this.hqH.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hqH.getParent()).removeView(this.hqH);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.live.aj.c.d(false, false, false));
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.live.aj.c.dr(false);
                this.hsp.addView(this.hqH, layoutParams);
            }
            if (this.hqH.indexOfChild(this.hrF.Kd().getView()) < 0) {
                if (this.hrF.Kd().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hrF.Kd().getView()).removeView(this.hrF.Kd().getView());
                }
                this.hqH.addView(this.hrF.Kd().getView(), new FrameLayout.LayoutParams(equipmentWidth, j));
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
            this.hrF.a(String.valueOf(cbP().hBH.Fm().mLiveInfo.group_id), String.valueOf(cbP().hBH.Fm().mLiveInfo.last_msg_id), String.valueOf(cbP().hBH.Fm().aId.userId), String.valueOf(cbP().hBH.Fm().mLiveInfo.live_id), cbP().hBH.Fm().aId.appId, (Fm == null || Fm.aIR == null || !Fm.aIR.Bf()) ? false : true, cbP().hBH.Fm().getGuardName());
            nN(false);
        }
    }

    private void cax() {
        if (this.hqu == null) {
            this.hqu = new com.baidu.tieba.ala.liveroom.m.a(cbP().pageContext, false, this);
        }
        this.hqu.e(this.hso, cbP().hBH.Fm());
        this.hqu.a(this.hrf);
        this.hqu.setOtherParams(Lo());
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
            this.hqt.setOtherParams(Lo());
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

    private void cav() {
        cbh();
    }

    public void nV(boolean z) {
        if (this.hrp != null) {
            this.hrp.nV(z);
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

    protected void HD(String str) {
        if (this.hsD == null) {
            this.hsD = new com.baidu.tieba.ala.liveroom.s.b(cbP().pageContext);
        }
        this.hsD.c(this.hsp, str);
        nP(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.16
            @Override // java.lang.Runnable
            public void run() {
                d.this.hsD.ckr();
                d.this.nP(false);
            }
        }, 5000L);
    }

    private void nW(boolean z) {
        CustomResponsedMessage runTask;
        if (cbP().hBH.Fm().mLiveInfo.live_type == 1 && this.htv) {
            if (this.hts == null && (runTask = MessageManager.getInstance().runTask(2913074, e.class, cbP().pageContext)) != null && runTask.getData() != null) {
                this.hts = (e) runTask.getData();
            }
            if (this.hts != null) {
                if (this.hqB == null) {
                    this.hqB = this.hts.a(cbP().pageContext);
                }
                if (z) {
                    this.hqB.Az();
                }
                if (cbP().hBH.Fm().mLiveInfo.challengeId > 0 && !this.hqB.AH()) {
                    this.hqB.h(cbP().hBH.Fm().mLiveInfo.live_id, cbP().hBH.Fm().aId.userId);
                    nX(z);
                    if (z) {
                        this.hqB.a(cbP().hBH.ciR());
                    }
                    this.hqB.c(cbP().hBH.Fm());
                }
            }
        }
    }

    private void nX(boolean z) {
        if (this.hqC == null) {
            this.hqC = this.hts.b(cbP().pageContext);
            this.hqC.a(new com.baidu.live.challenge.g() { // from class: com.baidu.tieba.ala.liveroom.c.d.17
                @Override // com.baidu.live.challenge.g
                public void Av() {
                    d.this.cbP().hBI.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.g
                public void a(bg bgVar, bk bkVar, bk bkVar2) {
                    d.this.gQF = true;
                    d.this.Xe();
                    if (d.this.cbP().brO != null) {
                        d.this.cbP().brO.getLivePlayer().setBackgroundResource(a.c.sdk_transparent);
                    }
                    if (d.this.hrv != null) {
                        d.this.hrv.setTimeTextMode(true);
                    }
                    if (d.this.brL != null && bkVar != null && bkVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(bkVar.aOW);
                        arrayList.add(bkVar2.aOW);
                        com.baidu.live.liveroom.a.c cVar = d.this.brL;
                        if (d.this.hsA) {
                            arrayList = null;
                        }
                        cVar.j(arrayList);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void Aw() {
                }

                @Override // com.baidu.live.challenge.g
                public void Ax() {
                }

                @Override // com.baidu.live.challenge.g
                public void bn(boolean z2) {
                    d.this.cbP().hBI.setSwipeClearEnable(true);
                    d.this.gQF = false;
                    d.this.ccr();
                    if (d.this.brL != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.cbP().hBH.cjG());
                        com.baidu.live.liveroom.a.c cVar = d.this.brL;
                        if (d.this.hsA) {
                            arrayList = null;
                        }
                        cVar.j(arrayList);
                    }
                    if (d.this.cbP().brO != null) {
                        d.this.cbP().brO.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
                    }
                    if (d.this.hrv != null) {
                        d.this.hrv.setTimeTextMode(false);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void bo(boolean z2) {
                    if (z2 && d.this.hse != null) {
                        d.this.hse.onClose();
                    }
                }
            });
        }
        this.hqC.a(this.hqB);
        this.hqC.k(cbP().hBG.getLiveContainerView());
        this.hqC.c(z, false, false);
        this.hqB.a((i.c) this.hqC);
    }

    protected void Xe() {
        if (this.hrw != null) {
            this.hrw.vm(8);
        }
        if (this.hrx != null) {
            this.hrx.setPraiseEnable(false);
            cbP().hBI.hRw = false;
        }
        if (this.hrZ != null) {
            this.hrZ.setCanVisible(false);
        }
        if (this.hry != null) {
            this.hry.ckC();
        }
        if (this.hqy != null) {
            this.hqy.setCanVisible(false);
            this.hqy.cfw();
        }
        if (this.hqz != null) {
            this.hqz.aW(true);
        }
        if (this.hsE != null) {
            this.hsE.setVisible(8);
        }
        if (this.hqA != null) {
            this.hqA.setCanVisible(false);
            this.hqA.setVisible(8);
        }
        if (this.hsa != null) {
            this.hsa.aW(true);
            this.hsa.aX(true);
        }
        ccg();
        cci();
        ccj();
        cck();
        ccl();
    }

    protected void ccr() {
        if (this.hrw != null) {
            this.hrw.vm(0);
        }
        if (this.hrx != null) {
            this.hrx.setPraiseEnable(true);
            cbP().hBI.hRw = true;
        }
        if (this.hrZ != null) {
            this.hrZ.setCanVisible(true);
        }
        if (this.hry != null) {
            this.hry.ckD();
        }
        if (this.hqy != null) {
            this.hqy.setCanVisible(true);
            this.hqy.M(cbP().hBH.Fm());
        }
        if (this.hrA != null) {
            this.hrA.oS(true);
        }
        if (this.hqz != null) {
            this.hqz.aW(false);
        }
        if (this.hsE != null) {
            this.hsE.setVisible(0);
        }
        if (this.hqA != null) {
            this.hqA.setCanVisible(true);
            this.hqA.setVisible(0);
        }
        if (this.hsa != null) {
            this.hsa.aW(false);
            this.hsa.aX(false);
        }
        ccg();
        cci();
        ccj();
        cck();
        ccl();
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

    private int ccs() {
        return (this.hqC != null ? this.hqC.bp(false) : 0) - BdUtilHelper.getStatusBarHeight(this.activity);
    }

    private void caF() {
        boolean z = true;
        if (this.hrA == null) {
            this.hrA = new com.baidu.tieba.ala.liveroom.v.a(cbP().pageContext, this);
        }
        this.hrA.c(cbP().hBI, false);
        AlaLiveInfoData alaLiveInfoData = cbP().hBH.Fm().mLiveInfo;
        if (alaLiveInfoData != null) {
            boolean z2 = cbO() && alaLiveInfoData.screen_direction != 2;
            boolean isZanAnimUnabled = alaLiveInfoData.mAlaLiveSwitchData != null ? alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled() : false;
            if (!z2 || isZanAnimUnabled) {
                z = false;
            }
            this.hrA.oR(z);
        }
    }

    private void caI() {
        if (this.hsw || this.hsx) {
            if ((TbadkCoreApplication.isLogin() && this.hrF.Ke().hasText()) || this.hsx) {
                this.hsw = false;
                this.hsx = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.19
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.cbg();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void caA() {
        caB();
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
            try {
                jSONObject.put("log_id", bVar.getMsgId());
            } catch (JSONException e) {
            }
        } catch (JSONException e2) {
            jSONObject = null;
        }
        if (bVar.getMsgType() == 12 || bVar.getMsgType() == 13) {
            if (jSONObject != null) {
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
                } else if ("challenge_mvp".equals(optString)) {
                    if (cbP().hBH.Fm() != null && cbP().hBH.Fm().mLiveInfo != null && cbP().hBH.Fm().aIz != null && this.hqC != null) {
                        long optLong = jSONObject.optLong("mvp_user_id");
                        long optLong2 = jSONObject.optLong("winner_live_id");
                        if (optLong == cbP().hBH.Fm().aIz.userId && optLong2 == cbP().hBH.Fm().mLiveInfo.live_id) {
                            this.hqC.g(jSONObject.optInt("challenge_status"), jSONObject.optLong("challenge_id"));
                        }
                    }
                } else if ("pub_show".equals(optString)) {
                    if (cbP() != null && com.baidu.live.ae.a.Qj().buX.aMx) {
                        int optInt = jSONObject.optInt("type");
                        int optInt2 = jSONObject.optInt("status");
                        int optInt3 = jSONObject.optInt("align");
                        if (cbP().brO != null) {
                            if (optInt == 1) {
                                if (optInt2 == 2) {
                                    if (optInt3 == 0) {
                                        this.htz = 0;
                                    } else if (optInt3 == 1) {
                                        this.htz = 8;
                                    } else if (optInt3 == 2) {
                                        this.htz = 7;
                                    } else {
                                        this.htz = 0;
                                    }
                                } else {
                                    this.htz = 0;
                                }
                            } else {
                                this.htz = 0;
                            }
                            cbP().brO.setVideoMode(this.htz);
                            cco();
                        }
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        if (this.hrZ == null || this.hrZ.J(bVar)) {
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void Hv(String str) {
        if (this.hqz != null) {
            this.hqz.Hv(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hsm != null) {
            this.hsm.onRequestPermissionsResult(i, strArr, iArr);
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
        if (this.htr != null) {
            this.htr.removeAllViews();
            this.htr = null;
        }
        if (this.hty != null) {
            this.hty.removeAllViews();
            this.hty = null;
        }
        if (this.hrA != null) {
            this.hrA.onDestroy();
        }
        if (this.hqB != null) {
            this.hqB.Ar();
        }
        if (this.hqu != null) {
            this.hqu.cgq();
        }
        if (this.hqQ != null) {
            this.hqQ.cancel();
        }
        if (this.hsE != null) {
            this.hsE.cdn();
        }
        if (this.htw != null) {
            this.htw.xh();
        }
        if (this.hrZ != null) {
            this.hrZ.xh();
        }
        if (this.hqG != null) {
            this.hqG.xh();
        }
        if (this.hqQ != null) {
            this.hqQ.Ar();
        }
        if (this.hsi != null) {
            this.hsi.Ar();
        }
        if (this.hsm != null) {
            this.hsm.Ru();
        }
        if (this.htx != null && this.htx.isDisplay()) {
            this.htt = false;
            this.htu = false;
            if (this.hsa != null) {
                this.hsa.aW(false);
                this.hsa.aX(false);
            }
            this.htx.Dr();
        }
        if (cbP().hBJ != null) {
            cbP().hBJ.setTalentShowing(false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cF(boolean z) {
        super.cF(z);
        caJ();
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
        if (this.hrN != null) {
            this.hrN.onDestroy();
        }
        if (this.hqv != null) {
            this.hqv.onDestroy();
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
        if (this.hqz != null) {
            this.hqz.release();
        }
        if (this.hsE != null) {
            this.hsE.cF(!z);
        }
        if (this.hqG != null) {
            this.hqG.onDestroy();
        }
        if (this.hqQ != null) {
            this.hqQ.onDestroy();
            this.hqQ = null;
        }
        if (this.hsi != null) {
            this.hsi.onDestroy();
        }
        if (this.hsm != null) {
            this.hsm.onDestroy();
        }
        if (cbP().hBJ != null) {
            cbP().hBJ.setTalentShowing(false);
        }
        if (this.htw != null) {
            this.htw.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.hqS);
        MessageManager.getInstance().removeMessageRule(this.hqR);
        MessageManager.getInstance().removeMessageRule(this.hqT);
        MessageManager.getInstance().removeMessageRule(this.hqU);
        MessageManager.getInstance().unRegisterListener(this.hqZ);
        MessageManager.getInstance().unRegisterListener(this.hrb);
        MessageManager.getInstance().unRegisterListener(this.hrc);
        MessageManager.getInstance().unRegisterListener(this.hrd);
        MessageManager.getInstance().unRegisterListener(this.htA);
        MessageManager.getInstance().unRegisterListener(this.hre);
        MessageManager.getInstance().unRegisterListener(this.hra);
    }

    private void caJ() {
        if (this.hrF != null && this.hrF.Kd().getView() != null && this.hrF.Kd().getView().getParent() != null) {
            ((ViewGroup) this.hrF.Kd().getView().getParent()).removeView(this.hrF.Kd().getView());
        }
        if (this.hqH != null && this.hqH.getParent() != null) {
            ((ViewGroup) this.hqH.getParent()).removeView(this.hqH);
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    /* renamed from: cct */
    public PendantParentView caN() {
        return this.byA;
    }

    public ViewGroup ccu() {
        return this.hty;
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
        } else if (i == 25051 && i2 == -1 && this.hsE != null) {
            this.hsE.cfn();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.hrF != null && this.hrF.Kd() != null) {
            this.hrF.Kd().onKeyboardVisibilityChanged(z);
        }
        if (z || this.hrF == null || this.hrF.Ke() == null || !this.hrF.Ke().LY()) {
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
                if (this.hrZ != null) {
                    this.hrZ.setCanVisible(false);
                }
                if (this.hsa != null) {
                    this.hsa.setCanVisible(false);
                }
                if (this.hsb != null) {
                    this.hsb.setCanVisible(false);
                }
                if (this.hsc != null) {
                    this.hsc.setVisible(8);
                }
                if (this.htw != null) {
                    this.htw.setCanVisible(false);
                }
                if (this.hsd != null) {
                    this.hsd.setCanVisible(false);
                }
                if (ccu() != null) {
                    ccu().setVisibility(8);
                }
            } else {
                caO();
            }
            if (this.hrT != null) {
                this.hrT.bC(z);
            }
            cci();
        }
    }

    private void caO() {
        if (this.hrp != null) {
            this.hrp.setVisibility(0);
        }
        if (this.hqH != null) {
            if (this.htC) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqH.getLayoutParams();
                layoutParams.bottomMargin = (O(false, false) - cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) + com.baidu.live.aj.c.Vj();
                this.hqH.setLayoutParams(layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hqH.getLayoutParams();
                layoutParams2.bottomMargin = cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds90);
                this.hqH.setLayoutParams(layoutParams2);
            }
        }
        if (this.hrF != null) {
            cbj();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hrF.Ke().getView().getLayoutParams();
            layoutParams3.bottomMargin = 0;
            this.hrF.Ke().getView().setLayoutParams(layoutParams3);
            if (this.aMG) {
                if (this.hrF.Kf().isClicked()) {
                    this.hrF.Kf().cw(false);
                } else {
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
        if (this.hso != null) {
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
        if (this.hrZ != null) {
            this.hrZ.setCanVisible(!this.gQF);
        }
        if (this.hsa != null) {
            this.hsa.setCanVisible(true);
        }
        if (this.htw != null) {
            this.htw.setCanVisible(true);
        }
        if (this.hsd != null) {
            this.hsd.setCanVisible(true);
        }
        if (ccu() != null) {
            ccu().setVisibility(0);
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
        this.htB = z;
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
        if (this.mOrientation != i3) {
            if (this.hqt != null) {
                this.hqt.cr(i3);
            }
            if (this.hqv != null) {
                this.hqv.cr(i3);
            }
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
            if (this.hrp != null) {
                this.hrp.setVisibility(8);
            }
            if (this.hrF != null) {
                this.hrF.Kd().getView().setVisibility(4);
                this.hrF.Kf().getView().setVisibility(4);
            }
            if (this.hqz != null) {
                this.hqz.bN(2, 8);
                if (this.gQF) {
                    this.hqz.bN(1, 8);
                }
            }
            if (this.hrU != null) {
                this.hrU.oM(false);
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
                if (this.aMG && !this.hrF.Kf().isClicked()) {
                    this.hrF.Kf().cw(true);
                }
            }
            if (this.hqz != null) {
                this.hqz.setVisible(0);
            }
            if (this.hrU != null) {
                this.hrU.oM(true);
            }
            this.hso.setVisibility(0);
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
        if (this.hqA != null) {
            this.hqA.bm(true);
        }
        if (this.hsm != null) {
            this.hsm.onStopped();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.hqw != null) {
            this.hqw.cks();
        }
        if (this.hqB != null && this.htv) {
            this.hqB.AB();
        }
        if (this.hqz != null) {
            this.hqz.onStart();
        }
        if (this.hqA != null) {
            this.hqA.bm(false);
        }
        if (this.hsm != null) {
            this.hsm.onStarted();
        }
        if (this.htw != null) {
            this.htw.onStart();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        if (!onKeyDown && i == 4 && this.hsm != null && this.hsm.onKeyDown(i, keyEvent)) {
            return true;
        }
        return onKeyDown;
    }
}
