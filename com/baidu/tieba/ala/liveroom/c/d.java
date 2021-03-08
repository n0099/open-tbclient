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
/* loaded from: classes10.dex */
public class d extends b implements com.baidu.live.m.c {
    private PendantParentView bAa;
    private boolean gSo;
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
    private FrameLayout hsq;
    private com.baidu.tieba.ala.liveroom.i.b hsz;
    private LinearLayout hva;
    private e hvb;
    private boolean hvc;
    private boolean hvd;
    private com.baidu.tieba.ala.liveroom.apppromotion.a hvf;
    private com.baidu.live.follow.pendant.a hvg;
    private LinearLayout hvh;
    private int hvi;
    private long lastClickTime = 0;
    private int bottomMargin = 0;
    private boolean hve = false;
    private HttpRule hsA = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.hsk != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.hsk.AJ()) {
                httpMessage.addParam("ala_challenge_id", d.this.hsk.AM());
            }
            return httpMessage;
        }
    };
    private HttpRule hsB = new HttpRule(1021229) { // from class: com.baidu.tieba.ala.liveroom.c.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.hsk != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.hsk.AJ()) {
                httpMessage.addParam("challenge_id", d.this.hsk.AM());
            }
            return httpMessage;
        }
    };
    private HttpRule hsC = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.c.d.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.hsk != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.hsk.AJ()) {
                httpMessage.addParam("challenge_id", d.this.hsk.AM());
            }
            return httpMessage;
        }
    };
    private HttpRule hsD = new HttpRule(1021232) { // from class: com.baidu.tieba.ala.liveroom.c.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.hsk != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.hsk.AJ()) {
                httpMessage.addParam("challenge_id", d.this.hsk.AM());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c hsE = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.c.d.22
        @Override // com.baidu.live.liveroom.g.c
        public void Ng() {
            if (d.this.htj != null) {
                d.this.htj.oS(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cI(boolean z) {
            if (z) {
                if (d.this.htj != null) {
                    d.this.htj.oS(true);
                }
            } else if (d.this.htj != null) {
                d.this.htj.oS(false);
            }
            if (d.this.htC != null) {
                d.this.htC.bD(z);
            }
            if (d.this.hsi != null) {
                d.this.hsi.nJ(z ? false : true);
            }
            com.baidu.live.p.a.cJ(z);
        }
    };
    private HttpMessageListener hsI = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.d.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Oz() != null) {
                        com.baidu.live.ae.e.QC().bCD = getQuickGiftHttpResponseMessage.Oz();
                        d.this.caz();
                    }
                }
            }
        }
    };
    CustomMessageListener hsN = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.c.d.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.hsz.c(d.this.cbV());
                } else if (d.this.cbh() || !g.vD(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.26.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.cbV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.cbV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    d.this.hsz.c(d.this.hsq, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener hsJ = new CustomMessageListener(2913276) { // from class: com.baidu.tieba.ala.liveroom.c.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            JSONObject optJSONObject;
            JSONArray optJSONArray;
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject) && (optJSONObject = ((JSONObject) customResponsedMessage.getData()).optJSONObject("ext_data")) != null && (optJSONArray = optJSONObject.optJSONArray("surprise_prize_member")) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                View inflate = LayoutInflater.from(d.this.activity).inflate(a.g.ala_fudai_dialog_layout, (ViewGroup) null);
                final Dialog dialog = new Dialog(d.this.cbV().pageContext.getPageActivity(), a.i.FudaiDialogStyle);
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
    private CustomMessageListener hvj = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.c.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.cbh() || !g.vD(2913128)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.vB(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    d.this.HM(str);
                }
            }
        }
    };
    private CustomMessageListener hsK = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.c.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.htr.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener hsL = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.c.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.hue != null && d.this.hue.bky != null && !d.this.hue.bkD && !d.this.hue.bkE && d.this.htB != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.cbV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                if (d.this.hto != null && d.this.hto.Ki().Mo()) {
                    layoutParams.bottomMargin = d.this.cbV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds88);
                } else {
                    layoutParams.bottomMargin = d.this.cbV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                }
                d.this.htB.c(d.this.hsq, layoutParams);
                if (com.baidu.live.guardclub.e.IV() != null) {
                    com.baidu.live.guardclub.e.IV().Ja();
                }
            }
        }
    };
    private CustomMessageListener hsM = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.d.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.bif != null) {
                    d.this.bif.dismiss();
                }
                com.baidu.live.im.b.d.KQ().setSwitchStatus(true);
                com.baidu.live.im.b.d.KQ().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.cbm();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b hsO = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.d.18
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
                        alaStaticItem.addParams("gifts_value", com.baidu.live.ae.e.QC().bCD.EV().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.ae.e.QC().bCD.EV().DU());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.ae.e.QC().bCD.EV().DV());
                        if (d.this.cbV().hDq.Fp() != null && d.this.cbV().hDq.Fp().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.cbV().hDq.Fp().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.cbV().hDq.Fp().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.Lr());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.Ic()) {
                        if (com.baidu.live.d.xf().getBoolean("quick_gift_guide_show", true) && !d.this.cbh()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, ah.class, d.this.cbV().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                ah ahVar = (ah) runTask.getData();
                                ahVar.setPageContext(d.this.cbV().pageContext);
                                ahVar.setLiveShowData(d.this.cbV().hDq.Fp());
                                ahVar.setGiftItem(com.baidu.live.ae.e.QC().bCD.EV());
                                ahVar.setOtherParams(d.this.Lr());
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
                        n.a(d.this.cbV().pageContext, d.this.cbV().hDq.Fp(), com.baidu.live.ae.e.QC().bCD.EV(), d.this.Lr());
                    }
                } else if (i == 1) {
                    if (d.this.hto != null) {
                        d.this.cbm();
                    }
                } else if (i == 3 && d.this.Ic()) {
                    if (com.baidu.live.p.a.isDebug()) {
                        com.baidu.live.p.a.c(d.this.cbV().hDq.Fp().mLiveInfo.live_id, 0);
                        return;
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    d.this.htb.d(d.this.cbV().hDq.Fp(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.cbV() != null && d.this.cbV().hDq != null && d.this.cbV().hDq.Fp() != null && d.this.cbV().hDq.Fp().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.cbV().hDq.Fp().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.cbV().hDq.Fp().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.cbV().hDq.Fp().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.Lr());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.cbV() != null && d.this.cbV().hDq != null && d.this.cbV().hDq.Fp() != null && d.this.cbV().hDq.Fp().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.cbV().hDq.Fp().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.cbV().hDq.Fp().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.cbV().hDq.Fp().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.Lr());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.btl != null) {
                        d.this.btl.cC(false);
                    }
                } else if (i == 12) {
                    if (d.this.htj != null && d.this.cbV().hDq.Fp() != null && d.this.cbV().hDq.Fp().mLiveInfo != null) {
                        String valueOf = String.valueOf(d.this.cbV().hDq.Fp().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.cbV().hDq.Fp().mLiveInfo.room_id);
                        String str3 = null;
                        AlaLiveSdkInfo alaLiveSdkInfo = d.this.cbV().hDq.Fp().mLiveSdkInfo;
                        if (alaLiveSdkInfo != null && alaLiveSdkInfo.mCastIds != null) {
                            str3 = String.valueOf(d.this.cbV().hDq.Fp().mLiveSdkInfo.mCastIds.chatMCastId);
                        }
                        d.this.htj.ax(valueOf, valueOf2, str3);
                        com.baidu.live.p.a.c(d.this.cbV().hDq.Fp().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    ab Fp = d.this.cbV().hDq.Fp();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.cbV().pageContext.getPageActivity(), Fp.aJD.userName, Long.toString(Fp.aJD.userId), Long.toString(Fp.aJD.charmCount), String.valueOf(Fp.mLiveInfo.group_id), String.valueOf(Fp.mLiveInfo.live_id), false, String.valueOf(Fp.aJD.userId), Long.toString(Fp.aJZ.userId), Fp.aJZ.userName, Fp.aJZ.portrait, d.this.hsg.getCount(), d.this.Lr())));
                    LogManager.getCommonLogger().doClickGusetNumLog(Fp.mLiveInfo.feed_id, d.this.hsg.getCount() + "", d.this.Lr());
                } else if (i == 11) {
                    d.this.cbr();
                    d.this.cbs();
                } else if (i == 16) {
                    if (d.this.cbV() != null && (bvVar2 = com.baidu.live.ae.a.Qm().bCs) != null && (coVar = bvVar2.aRm) != null) {
                        String str4 = coVar.aSU.aTd;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (d.this.cbV().hDq != null && d.this.cbV().hDq.Fp() != null && d.this.cbV().hDq.Fp().mLiveInfo != null) {
                                j = d.this.cbV().hDq.Fp().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", d.this.cbV().hDq.Fp().mLiveInfo.room_id + "", d.this.cbV().hDq.Fp().mLiveInfo.feed_id, d.this.Lr());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.cbV().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (d.this.cbV() != null) {
                        ab abVar = null;
                        if (d.this.cbV().hDq != null) {
                            abVar = d.this.cbV().hDq.Fp();
                        }
                        if (abVar != null && abVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.u.b.ckK().bwG != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.u.b.ckK().bwG.aIQ;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + abVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + abVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(d.this.cbV().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17 && d.this.Ic() && d.this.cbV() != null && (bvVar = com.baidu.live.ae.a.Qm().bCs) != null && bvVar.aRm != null) {
                    String str6 = bvVar.aRm.aTa;
                    if (!TextUtils.isEmpty(str6)) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                        if (d.this.cbV().hDq != null && d.this.cbV().hDq.Fp() != null) {
                            if (d.this.htD == null) {
                                d.this.htD = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.cbV().pageContext.getPageActivity());
                            }
                            ab Fp2 = d.this.cbV().hDq.Fp();
                            String b = d.this.htD.b(str6, Fp2.mLiveInfo.live_id, Fp2.aJZ.userId, Fp2.aJD.userId);
                            com.baidu.live.an.c cVar = new com.baidu.live.an.c();
                            cVar.url = b;
                            d.this.bif.a(cVar);
                        }
                    }
                }
            }
        }
    };
    private boolean hvk = false;
    private boolean hvl = false;

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
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void m(ab abVar) {
        super.m(abVar);
        g.cfy();
        this.hve = true;
        this.hvl = false;
        this.hvk = false;
        cbV().hDr.setIsForceHandledTouch(false);
        cbV().hDr.setSwipeClearEnable(true);
        cbV().hDr.setOnLiveViewScrollListener(this.hsE);
        cbV().hDr.setOnClickListener(null);
        cbV().hDr.setClickable(false);
        if (this.htg != null) {
            this.htg.b(this.hsO);
        }
        if (this.htX != null) {
            this.htX.setVisibility(0);
        }
        car();
        if (this.htz != null) {
            this.htz.a(abVar, this.bAa);
            this.htz.U(this.htY);
            this.htz.a(this);
        }
        ccs();
        caD();
        cbd();
        cbc();
        caE();
        caI();
        caF();
        cch();
        nQ(false);
        caA();
        caB();
        cbu();
        caN();
        cbw();
        caK();
        caL();
        cck();
        ccl();
        cbC();
        nS(false);
        cbz();
        cbD();
        cap();
        cbN();
        cat();
        caz();
        cau();
        cav();
        caw();
        cax();
        cal();
        cbB();
        cbJ();
        cbv();
        cbA();
        nW(true);
        cbM();
        c(this.gto);
        caq();
        cci();
        cbI();
        cbg();
        ccj();
        MessageManager.getInstance().registerListener(this.hsI);
        MessageManager.getInstance().registerListener(this.hsK);
        MessageManager.getInstance().registerListener(this.hsL);
        MessageManager.getInstance().registerListener(this.hsM);
        MessageManager.getInstance().registerListener(this.hvj);
        MessageManager.getInstance().registerListener(this.hsN);
        MessageManager.getInstance().registerListener(this.hsJ);
        caO();
        caH();
        cby();
        I(abVar);
    }

    private void I(ab abVar) {
        if (cbV() != null && cbV().btp != null && abVar != null && abVar.mLiveInfo != null && abVar.aKQ != null && com.baidu.live.ae.a.Qm().bwx.aNX) {
            if ("1".equals(abVar.mLiveInfo.pubShowId)) {
                if (abVar.aKQ.aLo == 0) {
                    this.hvi = 0;
                } else if (abVar.aKQ.aLo == 1) {
                    this.hvi = 8;
                } else if (abVar.aKQ.aLo == 2) {
                    this.hvi = 7;
                } else {
                    this.hvi = 0;
                }
            } else {
                this.hvi = 0;
            }
            cbV().btp.setVideoMode(this.hvi);
            ccu();
        }
    }

    private void cch() {
    }

    private void cci() {
        AlaVideoBCChatData alaVideoBCChatData;
        CustomResponsedMessage runTask;
        AlaLiveUserInfoData alaLiveUserInfoData = cbV().hDq.Fp().aJZ;
        if (alaLiveUserInfoData != null && (alaVideoBCChatData = alaLiveUserInfoData.videoBCEnterData) != null && alaVideoBCChatData.isShowEnter()) {
            if (this.htV == null && (runTask = MessageManager.getInstance().runTask(2913255, com.baidu.live.am.c.class, cbV().pageContext)) != null && runTask.getData() != null) {
                this.htV = (com.baidu.live.am.c) runTask.getData();
            }
            if (this.htV != null) {
                this.htV.a(cbV().btp);
                this.htV.b(cbV().hDp.getMastView());
                this.htV.r(cbV().hDq.Fp());
                this.htV.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.23
                    @Override // com.baidu.live.am.c.a
                    public void VK() {
                        if (d.this.htg != null) {
                            d.this.cbV().hDr.hTf = false;
                            d.this.htg.setPraiseEnable(false);
                            if (d.this.cbV().hDs != null) {
                                d.this.cbV().hDs.setTalentShowing(true);
                            }
                        }
                    }

                    @Override // com.baidu.live.am.c.a
                    public void VL() {
                        if (d.this.htg != null) {
                            d.this.cbV().hDr.hTf = true;
                            d.this.htg.setPraiseEnable(true);
                            if (d.this.cbV().hDs != null) {
                                d.this.cbV().hDs.setTalentShowing(false);
                            }
                        }
                    }
                });
                View enterView = this.htV.getEnterView();
                if (enterView != null) {
                    if (enterView.getParent() != null) {
                        ((ViewGroup) enterView.getParent()).removeView(enterView);
                    }
                    this.hsY.cv(enterView);
                }
            }
        }
    }

    public void ccj() {
        this.hvg = new com.baidu.live.follow.pendant.a(getActivity());
    }

    private void cal() {
        if (this.htN != null) {
            this.htN.a(new com.baidu.live.y.c() { // from class: com.baidu.tieba.ala.liveroom.c.d.24
                @Override // com.baidu.live.y.c
                public void cP(boolean z) {
                    if (d.this.hsl != null) {
                        d.this.hsl.setNeedCloseRecommendFloat(z);
                    }
                    if (d.this.cbV().hDr.hTf) {
                        if (d.this.htj != null) {
                            d.this.htj.oK(z);
                            d.this.htj.oS(!z);
                        }
                        if (d.this.htg != null) {
                            d.this.htg.oK(z);
                            d.this.htg.setPraiseEnable(!z);
                            d.this.htg.oJ(z ? false : true);
                        }
                    }
                }
            });
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
        if (this.hvg != null) {
            if (this.hvg.d(abVar) && !this.hvg.isDisplay()) {
                cct();
                this.hvc = true;
                this.hvd = true;
                if (this.htJ != null) {
                    this.htJ.aW(true);
                    this.htJ.aX(true);
                }
                if (this.htg != null) {
                    this.htg.setPraiseEnable(false);
                    cbV().hDr.hTf = false;
                }
                ccm();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.topMargin = (int) getActivity().getResources().getDimension(a.d.sdk_ds16);
                ak akVar = abVar.aKQ;
                if (akVar != null) {
                    this.hvg.m(akVar.anchorPortrait, akVar.aIY, String.valueOf(akVar.aLm));
                    this.hvg.b(ccA(), layoutParams);
                }
            } else if (!this.hvg.d(abVar) && this.hvg.isDisplay()) {
                this.hvg.Du();
                this.hvc = false;
                this.hvd = false;
                if (this.htJ != null) {
                    this.htJ.aW(false);
                    this.htJ.aX(false);
                }
                if (this.htg != null) {
                    this.htg.setPraiseEnable(true);
                    cbV().hDr.hTf = true;
                }
                ccm();
                if (this.hvh != null) {
                    this.hvh.removeAllViews();
                    this.hvh = null;
                }
            }
        }
        nW(false);
        if (this.hsi != null) {
            this.hsi.j(abVar);
            this.hsi.nI(this.huh);
            this.hsi.updateView();
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

    private void can() {
        if (this.hti != null) {
            this.hti.aJ(cbV().hDp.getLiveContainerView());
        }
    }

    private void cck() {
        if (this.hsm == null) {
            this.hsm = new com.baidu.tieba.ala.liveroom.b.a(cbV().pageContext);
        }
        if (cbV().hDq != null && cbV().hDq.Fp() != null && cbV().hDq.Fp().mLiveInfo != null) {
            this.hsm.HG(String.valueOf(cbV().hDq.Fp().mLiveInfo.user_id));
        }
    }

    private void ccl() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (cbV() != null && cbV().hDq != null && cbV().hDq.Fp() != null && cbV().hDq.Fp().mLiveInfo != null) {
                j = cbV().hDq.Fp().mLiveInfo.room_id;
            }
            if (this.htw == null) {
                this.htw = new com.baidu.tieba.ala.liveroom.guide.a(cbV().pageContext, j);
            }
            this.htw.nO(this.hua);
            this.htw.a(new a.InterfaceC0672a() { // from class: com.baidu.tieba.ala.liveroom.c.d.7
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0672a
                public void ccB() {
                    if (d.this.btl != null) {
                        d.this.btl.cC(true);
                    }
                }
            });
            this.htw.aF(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cw(int i) {
        super.cw(i);
        can();
        if (this.hsl != null) {
            this.hsl.cw(i);
        }
    }

    private void car() {
        if (this.bAa == null) {
            this.bAa = new PendantParentView(cbV().pageContext.getPageActivity(), ccn());
            cbV().hDr.addView(this.bAa, new ViewGroup.LayoutParams(-1, -1));
            this.bAa.setDefaultItemMargin(cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.bAa.setPadding(cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            ccm();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void nL(boolean z) {
        if (z) {
            this.bottomMargin = cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds180);
        } else {
            this.bottomMargin = cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
        }
        ccm();
    }

    private void ccm() {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        if (this.bAa != null) {
            this.bAa.setModel(ccn());
            int dimensionPixelSize3 = cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds220);
            if (this.bottomMargin != 0) {
                dimensionPixelSize = this.bottomMargin;
            } else {
                dimensionPixelSize = cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            }
            if (this.gSo) {
                dimensionPixelSize2 = ccy();
            } else {
                dimensionPixelSize2 = cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds250);
            }
            this.bAa.setPosition(dimensionPixelSize3, 0, dimensionPixelSize2, dimensionPixelSize);
            return;
        }
        car();
    }

    private PendantParentView.Model ccn() {
        if (this.gSo) {
            return PendantParentView.Model.VERTICAL_PK;
        }
        if (this.hvc) {
            return PendantParentView.Model.VERTICAL_BB_CHATING;
        }
        return PendantParentView.Model.VERTICAL;
    }

    private void cco() {
        if (cbV().hDr != null && !this.hvl) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.8
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.hsq != null && d.this.hto != null && d.this.hto.Kg() != null && d.this.hto.Kg().getView() != null) {
                        if (d.this.gSo && !d.this.hub && d.this.cbV().hDr != null && d.this.cbV().hDr.getHeight() > 0 && !d.this.hvd) {
                            int bp = d.this.hsl != null ? d.this.hsl.bp(false) : 0;
                            ViewGroup.LayoutParams layoutParams = d.this.hsq.getLayoutParams();
                            int height = d.this.cbV().hDr.getHeight() - bp;
                            int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                i += UtilHelper.getStatusBarHeight();
                            }
                            if (layoutParams != null && d.this.hto != null) {
                                layoutParams.height = i + d.this.cbV().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                                d.this.hsq.setLayoutParams(layoutParams);
                                ViewGroup.LayoutParams layoutParams2 = d.this.hto.Kg().getView().getLayoutParams();
                                if (layoutParams2 != null) {
                                    layoutParams2.height = layoutParams.height - com.baidu.live.aj.c.ds(false);
                                    d.this.hto.Kg().getView().setLayoutParams(layoutParams2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        int j = com.baidu.live.aj.c.j(false, d.this.hub);
                        if (d.this.htY.indexOfChild(d.this.hsq) != -1 && d.this.hsq.getLayoutParams() != null) {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) d.this.hsq.getLayoutParams();
                            layoutParams3.height = com.baidu.live.aj.c.d(false, false, d.this.hub);
                            d.this.hsq.setLayoutParams(layoutParams3);
                        }
                        if (d.this.hsq.indexOfChild(d.this.hto.Kg().getView()) != -1 && d.this.hto.Kg().getView().getLayoutParams() != null) {
                            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) d.this.hto.Kg().getView().getLayoutParams();
                            layoutParams4.height = j;
                            d.this.hto.Kg().getView().setLayoutParams(layoutParams4);
                        }
                        d.this.hto.Kg().Kf();
                    }
                }
            });
        }
    }

    private void ccp() {
        if (cbV().hDr != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.9
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.htq != null) {
                        if (d.this.gSo && !d.this.hub && d.this.cbV().hDr != null && d.this.cbV().hDr.getHeight() > 0) {
                            int height = (d.this.cbV().hDr.getHeight() - (d.this.hsl != null ? d.this.hsl.bp(false) : 0)) + d.this.cbV().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            if (d.this.htq != null) {
                                d.this.htq.cI(height);
                            }
                        } else if (d.this.htq != null) {
                            d.this.htq.cI(com.baidu.live.aj.a.a(d.this.cbV().pageContext.getPageActivity(), false, false, d.this.hub));
                        }
                    }
                }
            });
        }
    }

    private void ccq() {
        if (cbV().hDr != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.10
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    if (d.this.htq != null) {
                        int i2 = com.baidu.live.aj.a.i(false, false);
                        if (!d.this.gSo || d.this.cbV().hDr == null || d.this.cbV().hDr.getHeight() <= 0) {
                            i = i2;
                        } else {
                            int height = d.this.cbV().hDr.getHeight() - (d.this.hsl != null ? d.this.hsl.bp(false) : 0);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            i = height + d.this.cbV().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                        }
                        if (d.this.htq != null) {
                            d.this.htq.cJ(i);
                        }
                    }
                }
            });
        }
    }

    private void ccr() {
        if (this.htp != null && this.htp.zS() != null) {
            ViewGroup.LayoutParams layoutParams = this.htp.zS().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = cbV().pageContext.getResources().getDimensionPixelOffset(this.gSo ? a.d.sdk_ds100 : a.d.sdk_ds20);
                this.htp.zS().setLayoutParams(layoutParams);
            }
        }
    }

    private void ccs() {
        if (this.hva == null) {
            this.hva = new LinearLayout(cbV().pageContext.getPageActivity());
            this.hva.setOrientation(1);
        }
        if (this.hva.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds160);
            layoutParams.leftMargin = cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            cbV().hDr.addView(this.hva, layoutParams);
        }
    }

    private void cct() {
        if (ccA() == null && com.baidu.live.ae.a.Qm().bwx != null) {
            if (!com.baidu.live.ae.a.Qm().bwx.aNX) {
                this.hvi = 0;
            }
            ccu();
        }
    }

    private void ccu() {
        List<cw.a> list;
        int i;
        if (cbV() != null && cbV().hDp != null && cbV().hDp.getMastView() != null && cbV().hDq != null && cbV().pageContext != null && cbV().pageContext.getResources() != null) {
            com.baidu.live.ae.a Qm = com.baidu.live.ae.a.Qm();
            if (Qm.bwx != null && Qm.bwx.aOV != null && (list = com.baidu.live.ae.a.Qm().bwx.aOV.dataList) != null && list.size() >= 2) {
                cw.a aVar = list.get(1) == null ? cw.a.aUp.get(1) : list.get(1);
                int i2 = com.baidu.live.ae.a.Qm().bwx.aOV.aUk;
                int i3 = com.baidu.live.ae.a.Qm().bwx.aOV.aUl;
                DisplayMetrics displayMetrics = cbV().pageContext.getResources().getDisplayMetrics();
                int i4 = displayMetrics.widthPixels;
                int i5 = displayMetrics.heightPixels;
                if (this.activity != null && com.baidu.live.utils.d.bc(this.activity)) {
                    i5 += com.baidu.live.utils.d.bh(this.activity);
                }
                int i6 = (((i2 * i5) / i3) - i4) / 2;
                int i7 = (aVar.width * i5) / i3;
                if (this.hvi == 0) {
                    i = ((aVar.x * i5) / i3) - i6;
                } else if (this.hvi == 8) {
                    i = (aVar.x * i5) / i3;
                } else {
                    i = this.hvi == 7 ? ((aVar.x * i5) / i3) - (i6 * 2) : 0;
                }
                int i8 = (aVar.height * i5) / i3;
                int i9 = (aVar.y * i5) / i3;
                if (this.hvh == null) {
                    this.hvh = new LinearLayout(cbV().pageContext.getPageActivity());
                    this.hvh.setOrientation(1);
                }
                if (this.hvh.getParent() == null) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((i >= 0 || this.hvi != 0) ? i7 : i7 + i, -2);
                    layoutParams.gravity = 8388659;
                    layoutParams.topMargin = i9 + i8;
                    if (!UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams.topMargin += UtilHelper.getImmersiveStickyBarHeight();
                    } else if (com.baidu.live.utils.d.Vo() && this.activity != null) {
                        layoutParams.topMargin += com.baidu.live.utils.d.bh(this.activity);
                    }
                    if (i < 0 && this.hvi == 0) {
                        i = 0;
                    }
                    layoutParams.leftMargin = i;
                    cbV().hDp.getMastView().addView(this.hvh, layoutParams);
                } else if (this.hvh != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hvh.getLayoutParams();
                    if (i < 0 && this.hvi == 0) {
                        i7 += i;
                    }
                    if (i < 0 && this.hvi == 0) {
                        i = 0;
                    }
                    layoutParams2.topMargin = i9 + i8;
                    if (!UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin += UtilHelper.getImmersiveStickyBarHeight();
                    } else if (com.baidu.live.utils.d.Vo() && this.activity != null) {
                        layoutParams2.topMargin += com.baidu.live.utils.d.bh(this.activity);
                    }
                    layoutParams2.width = i7;
                    layoutParams2.leftMargin = i;
                    this.hvh.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    private void cat() {
        if (this.hsi == null) {
            this.hsi = new com.baidu.tieba.ala.liveroom.activeview.b(cbV().pageContext);
        }
        if (cbV() != null && cbV().hDq != null) {
            this.hsi.HC(cbV().hDq.cjQ());
        }
        this.hsi.aW(this.gSo);
        this.hsi.setOtherParams(Lr());
        this.hsi.c(cbV().hDq.Fp(), false);
        this.hsi.setHost(false);
        this.hsi.nI(this.huh);
        this.hsi.a(1, this.bAa);
        this.hsi.a(2, this.bAa);
        this.hsi.setVisible(this.hub ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caz() {
        if (this.hsY == null) {
            caF();
        }
        this.hsY.setOtherParams(Lr());
        this.hsY.a(com.baidu.live.ae.e.QC().bCD, cbV().hDq.Fp());
    }

    private void cau() {
        if (this.hsh == null) {
            this.hsh = new com.baidu.tieba.ala.liveroom.k.a(cbV().pageContext, this);
        }
        this.hsh.setOtherParams(Lr());
        this.hsh.a((ViewGroup) this.bAa, cay());
        this.hsh.M(cbV().hDq.Fp());
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
            this.htJ.aW(this.gSo);
            this.htJ.setIsHorizontal(false);
            this.htJ.a(caT(), cbV().hDq.Fp());
            this.htJ.setIsHost(false);
            this.htJ.a(new a.InterfaceC0160a() { // from class: com.baidu.tieba.ala.liveroom.c.d.11
                @Override // com.baidu.live.a.a.InterfaceC0160a
                public void xl() {
                    d.this.ccv();
                }

                @Override // com.baidu.live.a.a.InterfaceC0160a
                public void xm() {
                    d.this.ccw();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccv() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccw() {
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
            this.hsY.a(new a.InterfaceC0677a() { // from class: com.baidu.tieba.ala.liveroom.c.d.13
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0677a
                public void bP(int i, int i2) {
                    ab Fp = d.this.cbV().hDq.Fp();
                    if (Fp != null && Fp.mLiveInfo != null) {
                        if (d.this.htD == null) {
                            d.this.htD = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.cbV().pageContext.getPageActivity());
                        }
                        d.this.htD.d(d.this.htY, i, i2);
                        d.this.htD.a(String.valueOf(Fp.mLiveInfo.live_id), new a.InterfaceC0681a() { // from class: com.baidu.tieba.ala.liveroom.c.d.13.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0681a
                            public void a(float f, String str) {
                                if (d.this.hsY != null) {
                                    d.this.hsY.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0677a
                public void bQ(int i, int i2) {
                    if (d.this.htD != null) {
                        d.this.htD.bV(i, i2);
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
            this.hsz = new com.baidu.tieba.ala.liveroom.i.b(cbV().pageContext, Lr(), this.hun, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.14
                @Override // com.baidu.tieba.ala.liveroom.i.b.a
                public void caW() {
                    d.this.nP(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.i.b.a
                public void caX() {
                    d.this.nP(false);
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

    private void caN() {
        if (this.hvf == null) {
            this.hvf = new com.baidu.tieba.ala.liveroom.apppromotion.a(cbV().pageContext);
        }
        this.hvf.b(caT(), cbV().hDq.Fp());
    }

    private LinearLayout.LayoutParams cay() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    private void caA() {
        CustomResponsedMessage runTask;
        if (this.hto == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, cbV().pageContext)) != null && runTask.getData() != null) {
            this.hto = (k) runTask.getData();
            this.hto.setFromMaster(false);
            this.hto.Kg().getView().setId(a.f.ala_liveroom_msg_list);
            this.hto.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.15
                @Override // com.baidu.live.im.k.a
                public boolean Kk() {
                    return d.this.Ic();
                }

                @Override // com.baidu.live.im.k.a
                public void Kl() {
                    d.this.huf = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hh(String str) {
                    if (!d.this.hub) {
                        d.this.nN(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.cbV().pageContext.getPageActivity(), d.this.cbV().hDp.getLiveContainerView());
                    }
                    d.this.HJ(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Km() {
                    if (d.this.hub) {
                        d.this.nN(true);
                        d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.15.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.cbV().pageContext.getPageActivity(), d.this.cbV().hDp.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.hto != null) {
                        d.this.hto.Kh().setQuickInputPanelVisible(false);
                        d.this.hto.Kh().Mc();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Kn() {
                }

                @Override // com.baidu.live.im.k.a
                public void Ko() {
                    if (d.this.hub) {
                        d.this.caV();
                        if (d.this.htp != null) {
                            d.this.htp.zT();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Kp() {
                    return d.this.cbi();
                }

                @Override // com.baidu.live.im.k.a
                public int Kq() {
                    return d.this.cbj();
                }

                @Override // com.baidu.live.im.k.a
                public boolean Kr() {
                    ab Fp = d.this.cbV().hDq.Fp();
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
            int j = com.baidu.live.aj.c.j(false, false);
            if (this.htY.indexOfChild(this.hsq) < 0) {
                if (this.hsq.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hsq.getParent()).removeView(this.hsq);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.live.aj.c.d(false, false, false));
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.live.aj.c.dr(false);
                this.htY.addView(this.hsq, layoutParams);
            }
            if (this.hsq.indexOfChild(this.hto.Kg().getView()) < 0) {
                if (this.hto.Kg().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hto.Kg().getView()).removeView(this.hto.Kg().getView());
                }
                this.hsq.addView(this.hto.Kg().getView(), new FrameLayout.LayoutParams(equipmentWidth, j));
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
            this.hto.a(String.valueOf(cbV().hDq.Fp().mLiveInfo.group_id), String.valueOf(cbV().hDq.Fp().mLiveInfo.last_msg_id), String.valueOf(cbV().hDq.Fp().aJD.userId), String.valueOf(cbV().hDq.Fp().mLiveInfo.live_id), cbV().hDq.Fp().aJD.appId, (Fp == null || Fp.aKr == null || !Fp.aKr.Bi()) ? false : true, cbV().hDq.Fp().getGuardName());
            nN(false);
        }
    }

    private void caD() {
        if (this.hsd == null) {
            this.hsd = new com.baidu.tieba.ala.liveroom.m.a(cbV().pageContext, false, this);
        }
        this.hsd.e(this.htX, cbV().hDq.Fp());
        this.hsd.a(this.hsO);
        this.hsd.setOtherParams(Lr());
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
            this.hsc.setOtherParams(Lr());
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

    private void caB() {
        cbn();
    }

    public void nV(boolean z) {
        if (this.hsY != null) {
            this.hsY.nV(z);
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

    protected void HM(String str) {
        if (this.hum == null) {
            this.hum = new com.baidu.tieba.ala.liveroom.s.b(cbV().pageContext);
        }
        this.hum.c(this.htY, str);
        nP(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.16
            @Override // java.lang.Runnable
            public void run() {
                d.this.hum.ckx();
                d.this.nP(false);
            }
        }, 5000L);
    }

    private void nW(boolean z) {
        CustomResponsedMessage runTask;
        if (cbV().hDq.Fp().mLiveInfo.live_type == 1 && this.hve) {
            if (this.hvb == null && (runTask = MessageManager.getInstance().runTask(2913074, e.class, cbV().pageContext)) != null && runTask.getData() != null) {
                this.hvb = (e) runTask.getData();
            }
            if (this.hvb != null) {
                if (this.hsk == null) {
                    this.hsk = this.hvb.a(cbV().pageContext);
                }
                if (z) {
                    this.hsk.AC();
                }
                if (cbV().hDq.Fp().mLiveInfo.challengeId > 0 && !this.hsk.AK()) {
                    this.hsk.h(cbV().hDq.Fp().mLiveInfo.live_id, cbV().hDq.Fp().aJD.userId);
                    nX(z);
                    if (z) {
                        this.hsk.a(cbV().hDq.ciX());
                    }
                    this.hsk.c(cbV().hDq.Fp());
                }
            }
        }
    }

    private void nX(boolean z) {
        if (this.hsl == null) {
            this.hsl = this.hvb.b(cbV().pageContext);
            this.hsl.a(new com.baidu.live.challenge.g() { // from class: com.baidu.tieba.ala.liveroom.c.d.17
                @Override // com.baidu.live.challenge.g
                public void Ay() {
                    d.this.cbV().hDr.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.g
                public void a(bg bgVar, bk bkVar, bk bkVar2) {
                    d.this.gSo = true;
                    d.this.Xh();
                    if (d.this.cbV().btp != null) {
                        d.this.cbV().btp.getLivePlayer().setBackgroundResource(a.c.sdk_transparent);
                    }
                    if (d.this.hte != null) {
                        d.this.hte.setTimeTextMode(true);
                    }
                    if (d.this.btl != null && bkVar != null && bkVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(bkVar.aQw);
                        arrayList.add(bkVar2.aQw);
                        com.baidu.live.liveroom.a.c cVar = d.this.btl;
                        if (d.this.huj) {
                            arrayList = null;
                        }
                        cVar.j(arrayList);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void Az() {
                }

                @Override // com.baidu.live.challenge.g
                public void AA() {
                }

                @Override // com.baidu.live.challenge.g
                public void bn(boolean z2) {
                    d.this.cbV().hDr.setSwipeClearEnable(true);
                    d.this.gSo = false;
                    d.this.ccx();
                    if (d.this.btl != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.cbV().hDq.cjM());
                        com.baidu.live.liveroom.a.c cVar = d.this.btl;
                        if (d.this.huj) {
                            arrayList = null;
                        }
                        cVar.j(arrayList);
                    }
                    if (d.this.cbV().btp != null) {
                        d.this.cbV().btp.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
                    }
                    if (d.this.hte != null) {
                        d.this.hte.setTimeTextMode(false);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void bo(boolean z2) {
                    if (z2 && d.this.htN != null) {
                        d.this.htN.onClose();
                    }
                }
            });
        }
        this.hsl.a(this.hsk);
        this.hsl.k(cbV().hDp.getLiveContainerView());
        this.hsl.c(z, false, false);
        this.hsk.a((i.c) this.hsl);
    }

    protected void Xh() {
        if (this.htf != null) {
            this.htf.vo(8);
        }
        if (this.htg != null) {
            this.htg.setPraiseEnable(false);
            cbV().hDr.hTf = false;
        }
        if (this.htI != null) {
            this.htI.setCanVisible(false);
        }
        if (this.hth != null) {
            this.hth.ckI();
        }
        if (this.hsh != null) {
            this.hsh.setCanVisible(false);
            this.hsh.cfC();
        }
        if (this.hsi != null) {
            this.hsi.aW(true);
        }
        if (this.hun != null) {
            this.hun.setVisible(8);
        }
        if (this.hsj != null) {
            this.hsj.setCanVisible(false);
            this.hsj.setVisible(8);
        }
        if (this.htJ != null) {
            this.htJ.aW(true);
            this.htJ.aX(true);
        }
        ccm();
        cco();
        ccp();
        ccq();
        ccr();
    }

    protected void ccx() {
        if (this.htf != null) {
            this.htf.vo(0);
        }
        if (this.htg != null) {
            this.htg.setPraiseEnable(true);
            cbV().hDr.hTf = true;
        }
        if (this.htI != null) {
            this.htI.setCanVisible(true);
        }
        if (this.hth != null) {
            this.hth.ckJ();
        }
        if (this.hsh != null) {
            this.hsh.setCanVisible(true);
            this.hsh.M(cbV().hDq.Fp());
        }
        if (this.htj != null) {
            this.htj.oS(true);
        }
        if (this.hsi != null) {
            this.hsi.aW(false);
        }
        if (this.hun != null) {
            this.hun.setVisible(0);
        }
        if (this.hsj != null) {
            this.hsj.setCanVisible(true);
            this.hsj.setVisible(0);
        }
        if (this.htJ != null) {
            this.htJ.aW(false);
            this.htJ.aX(false);
        }
        ccm();
        cco();
        ccp();
        ccq();
        ccr();
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

    private int ccy() {
        return (this.hsl != null ? this.hsl.bp(false) : 0) - BdUtilHelper.getStatusBarHeight(this.activity);
    }

    private void caL() {
        boolean z = true;
        if (this.htj == null) {
            this.htj = new com.baidu.tieba.ala.liveroom.v.a(cbV().pageContext, this);
        }
        this.htj.c(cbV().hDr, false);
        AlaLiveInfoData alaLiveInfoData = cbV().hDq.Fp().mLiveInfo;
        if (alaLiveInfoData != null) {
            boolean z2 = cbU() && alaLiveInfoData.screen_direction != 2;
            boolean isZanAnimUnabled = alaLiveInfoData.mAlaLiveSwitchData != null ? alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled() : false;
            if (!z2 || isZanAnimUnabled) {
                z = false;
            }
            this.htj.oR(z);
        }
    }

    private void caO() {
        if (this.huf || this.hug) {
            if ((TbadkCoreApplication.isLogin() && this.hto.Kh().hasText()) || this.hug) {
                this.huf = false;
                this.hug = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.19
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.cbm();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void caG() {
        caH();
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
                } else if ("challenge_mvp".equals(optString)) {
                    if (cbV().hDq.Fp() != null && cbV().hDq.Fp().mLiveInfo != null && cbV().hDq.Fp().aJZ != null && this.hsl != null) {
                        long optLong = jSONObject.optLong("mvp_user_id");
                        long optLong2 = jSONObject.optLong("winner_live_id");
                        if (optLong == cbV().hDq.Fp().aJZ.userId && optLong2 == cbV().hDq.Fp().mLiveInfo.live_id) {
                            this.hsl.g(jSONObject.optInt("challenge_status"), jSONObject.optLong("challenge_id"));
                        }
                    }
                } else if ("pub_show".equals(optString)) {
                    if (cbV() != null && com.baidu.live.ae.a.Qm().bwx.aNX) {
                        int optInt = jSONObject.optInt("type");
                        int optInt2 = jSONObject.optInt("status");
                        int optInt3 = jSONObject.optInt("align");
                        if (cbV().btp != null) {
                            if (optInt == 1) {
                                if (optInt2 == 2) {
                                    if (optInt3 == 0) {
                                        this.hvi = 0;
                                    } else if (optInt3 == 1) {
                                        this.hvi = 8;
                                    } else if (optInt3 == 2) {
                                        this.hvi = 7;
                                    } else {
                                        this.hvi = 0;
                                    }
                                } else {
                                    this.hvi = 0;
                                }
                            } else {
                                this.hvi = 0;
                            }
                            cbV().btp.setVideoMode(this.hvi);
                            ccu();
                        }
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        if (this.htI == null || this.htI.J(bVar)) {
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void HE(String str) {
        if (this.hsi != null) {
            this.hsi.HE(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.htV != null) {
            this.htV.onRequestPermissionsResult(i, strArr, iArr);
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
        if (this.hva != null) {
            this.hva.removeAllViews();
            this.hva = null;
        }
        if (this.hvh != null) {
            this.hvh.removeAllViews();
            this.hvh = null;
        }
        if (this.htj != null) {
            this.htj.onDestroy();
        }
        if (this.hsk != null) {
            this.hsk.Au();
        }
        if (this.hsd != null) {
            this.hsd.cgw();
        }
        if (this.hsz != null) {
            this.hsz.cancel();
        }
        if (this.hun != null) {
            this.hun.cdt();
        }
        if (this.hvf != null) {
            this.hvf.xk();
        }
        if (this.htI != null) {
            this.htI.xk();
        }
        if (this.hsp != null) {
            this.hsp.xk();
        }
        if (this.hsz != null) {
            this.hsz.Au();
        }
        if (this.htR != null) {
            this.htR.Au();
        }
        if (this.htV != null) {
            this.htV.Rx();
        }
        if (this.hvg != null && this.hvg.isDisplay()) {
            this.hvc = false;
            this.hvd = false;
            if (this.htJ != null) {
                this.htJ.aW(false);
                this.htJ.aX(false);
            }
            this.hvg.Du();
        }
        if (cbV().hDs != null) {
            cbV().hDs.setTalentShowing(false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cF(boolean z) {
        super.cF(z);
        caP();
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
        if (this.htw != null) {
            this.htw.onDestroy();
        }
        if (this.hse != null) {
            this.hse.onDestroy();
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
        if (this.hsi != null) {
            this.hsi.release();
        }
        if (this.hun != null) {
            this.hun.cF(!z);
        }
        if (this.hsp != null) {
            this.hsp.onDestroy();
        }
        if (this.hsz != null) {
            this.hsz.onDestroy();
            this.hsz = null;
        }
        if (this.htR != null) {
            this.htR.onDestroy();
        }
        if (this.htV != null) {
            this.htV.onDestroy();
        }
        if (cbV().hDs != null) {
            cbV().hDs.setTalentShowing(false);
        }
        if (this.hvf != null) {
            this.hvf.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.hsB);
        MessageManager.getInstance().removeMessageRule(this.hsA);
        MessageManager.getInstance().removeMessageRule(this.hsC);
        MessageManager.getInstance().removeMessageRule(this.hsD);
        MessageManager.getInstance().unRegisterListener(this.hsI);
        MessageManager.getInstance().unRegisterListener(this.hsK);
        MessageManager.getInstance().unRegisterListener(this.hsL);
        MessageManager.getInstance().unRegisterListener(this.hsM);
        MessageManager.getInstance().unRegisterListener(this.hvj);
        MessageManager.getInstance().unRegisterListener(this.hsN);
        MessageManager.getInstance().unRegisterListener(this.hsJ);
    }

    private void caP() {
        if (this.hto != null && this.hto.Kg().getView() != null && this.hto.Kg().getView().getParent() != null) {
            ((ViewGroup) this.hto.Kg().getView().getParent()).removeView(this.hto.Kg().getView());
        }
        if (this.hsq != null && this.hsq.getParent() != null) {
            ((ViewGroup) this.hsq.getParent()).removeView(this.hsq);
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    /* renamed from: ccz */
    public PendantParentView caT() {
        return this.bAa;
    }

    public ViewGroup ccA() {
        return this.hvh;
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
        } else if (i == 25051 && i2 == -1 && this.hun != null) {
            this.hun.cft();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.hto != null && this.hto.Kg() != null) {
            this.hto.Kg().onKeyboardVisibilityChanged(z);
        }
        if (z || this.hto == null || this.hto.Kh() == null || !this.hto.Kh().Mb()) {
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
                if (this.htI != null) {
                    this.htI.setCanVisible(false);
                }
                if (this.htJ != null) {
                    this.htJ.setCanVisible(false);
                }
                if (this.htK != null) {
                    this.htK.setCanVisible(false);
                }
                if (this.htL != null) {
                    this.htL.setVisible(8);
                }
                if (this.hvf != null) {
                    this.hvf.setCanVisible(false);
                }
                if (this.htM != null) {
                    this.htM.setCanVisible(false);
                }
                if (ccA() != null) {
                    ccA().setVisibility(8);
                }
            } else {
                caU();
            }
            if (this.htC != null) {
                this.htC.bC(z);
            }
            cco();
        }
    }

    private void caU() {
        if (this.hsY != null) {
            this.hsY.setVisibility(0);
        }
        if (this.hsq != null) {
            if (this.hvl) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hsq.getLayoutParams();
                layoutParams.bottomMargin = (O(false, false) - cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) + com.baidu.live.aj.c.Vm();
                this.hsq.setLayoutParams(layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hsq.getLayoutParams();
                layoutParams2.bottomMargin = cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds90);
                this.hsq.setLayoutParams(layoutParams2);
            }
        }
        if (this.hto != null) {
            cbp();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hto.Kh().getView().getLayoutParams();
            layoutParams3.bottomMargin = 0;
            this.hto.Kh().getView().setLayoutParams(layoutParams3);
            if (this.aOg) {
                if (this.hto.Ki().isClicked()) {
                    this.hto.Ki().cw(false);
                } else {
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
        if (this.htX != null) {
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
        if (this.htI != null) {
            this.htI.setCanVisible(!this.gSo);
        }
        if (this.htJ != null) {
            this.htJ.setCanVisible(true);
        }
        if (this.hvf != null) {
            this.hvf.setCanVisible(true);
        }
        if (this.htM != null) {
            this.htM.setCanVisible(true);
        }
        if (ccA() != null) {
            ccA().setVisibility(0);
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
        this.hvk = z;
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
        if (this.mOrientation != i3) {
            if (this.hsc != null) {
                this.hsc.cs(i3);
            }
            if (this.hse != null) {
                this.hse.cs(i3);
            }
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
            if (this.hsY != null) {
                this.hsY.setVisibility(8);
            }
            if (this.hto != null) {
                this.hto.Kg().getView().setVisibility(4);
                this.hto.Ki().getView().setVisibility(4);
            }
            if (this.hsi != null) {
                this.hsi.bN(2, 8);
                if (this.gSo) {
                    this.hsi.bN(1, 8);
                }
            }
            if (this.htD != null) {
                this.htD.oM(false);
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
                if (this.aOg && !this.hto.Ki().isClicked()) {
                    this.hto.Ki().cw(true);
                }
            }
            if (this.hsi != null) {
                this.hsi.setVisible(0);
            }
            if (this.htD != null) {
                this.htD.oM(true);
            }
            this.htX.setVisibility(0);
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
        if (this.hsj != null) {
            this.hsj.bm(true);
        }
        if (this.htV != null) {
            this.htV.onStopped();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.hsf != null) {
            this.hsf.cky();
        }
        if (this.hsk != null && this.hve) {
            this.hsk.AE();
        }
        if (this.hsi != null) {
            this.hsi.onStart();
        }
        if (this.hsj != null) {
            this.hsj.bm(false);
        }
        if (this.htV != null) {
            this.htV.onStarted();
        }
        if (this.hvf != null) {
            this.hvf.onStart();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        if (!onKeyDown && i == 4 && this.htV != null && this.htV.onKeyDown(i, keyEvent)) {
            return true;
        }
        return onKeyDown;
    }
}
