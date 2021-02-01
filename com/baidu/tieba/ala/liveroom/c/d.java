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
    private boolean gQr;
    private com.baidu.tieba.ala.liveroom.i.b hqC;
    private com.baidu.tieba.ala.liveroom.audiencelist.c hqf;
    private com.baidu.tieba.ala.liveroom.m.a hqg;
    private com.baidu.tieba.ala.liveroom.f.b hqh;
    private com.baidu.tieba.ala.liveroom.t.b hqi;
    private com.baidu.tieba.ala.liveroom.audiencelist.b hqj;
    private com.baidu.tieba.ala.liveroom.k.a hqk;
    private com.baidu.tieba.ala.liveroom.activeview.b hql;
    private com.baidu.live.e.a hqm;
    private i hqn;
    private h hqo;
    private com.baidu.tieba.ala.liveroom.b.a hqp;
    private FrameLayout hqt;
    private LinearLayout htd;
    private e hte;
    private boolean htf;
    private boolean htg;
    private com.baidu.tieba.ala.liveroom.apppromotion.a hti;
    private com.baidu.live.follow.pendant.a htj;
    private LinearLayout htk;
    private int htl;
    private long lastClickTime = 0;
    private int bottomMargin = 0;
    private boolean hth = false;
    private HttpRule hqD = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.hqn != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.hqn.AG()) {
                httpMessage.addParam("ala_challenge_id", d.this.hqn.AJ());
            }
            return httpMessage;
        }
    };
    private HttpRule hqE = new HttpRule(1021229) { // from class: com.baidu.tieba.ala.liveroom.c.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.hqn != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.hqn.AG()) {
                httpMessage.addParam("challenge_id", d.this.hqn.AJ());
            }
            return httpMessage;
        }
    };
    private HttpRule hqF = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.c.d.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.hqn != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.hqn.AG()) {
                httpMessage.addParam("challenge_id", d.this.hqn.AJ());
            }
            return httpMessage;
        }
    };
    private HttpRule hqG = new HttpRule(1021232) { // from class: com.baidu.tieba.ala.liveroom.c.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.hqn != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.hqn.AG()) {
                httpMessage.addParam("challenge_id", d.this.hqn.AJ());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c hqH = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.c.d.22
        @Override // com.baidu.live.liveroom.g.c
        public void Nd() {
            if (d.this.hrm != null) {
                d.this.hrm.oS(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cI(boolean z) {
            if (z) {
                if (d.this.hrm != null) {
                    d.this.hrm.oS(true);
                }
            } else if (d.this.hrm != null) {
                d.this.hrm.oS(false);
            }
            if (d.this.hrF != null) {
                d.this.hrF.bD(z);
            }
            if (d.this.hql != null) {
                d.this.hql.nJ(z ? false : true);
            }
            com.baidu.live.p.a.cJ(z);
        }
    };
    private HttpMessageListener hqL = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.d.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Ow() != null) {
                        com.baidu.live.ae.e.Qz().bBd = getQuickGiftHttpResponseMessage.Ow();
                        d.this.cam();
                    }
                }
            }
        }
    };
    CustomMessageListener hqQ = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.c.d.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.hqC.c(d.this.cbI());
                } else if (d.this.caU() || !g.vB(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.26.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.cbI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.cbI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    d.this.hqC.c(d.this.hqt, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener hqM = new CustomMessageListener(2913276) { // from class: com.baidu.tieba.ala.liveroom.c.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            JSONObject optJSONObject;
            JSONArray optJSONArray;
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject) && (optJSONObject = ((JSONObject) customResponsedMessage.getData()).optJSONObject("ext_data")) != null && (optJSONArray = optJSONObject.optJSONArray("surprise_prize_member")) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                View inflate = LayoutInflater.from(d.this.activity).inflate(a.g.ala_fudai_dialog_layout, (ViewGroup) null);
                final Dialog dialog = new Dialog(d.this.cbI().pageContext.getPageActivity(), a.i.FudaiDialogStyle);
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
    private CustomMessageListener htm = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.c.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.caU() || !g.vB(2913128)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.vz(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    d.this.HC(str);
                }
            }
        }
    };
    private CustomMessageListener hqN = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.c.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.hru.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener hqO = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.c.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.hsh != null && d.this.hsh.biY != null && !d.this.hsh.bjd && !d.this.hsh.bje && d.this.hrE != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.cbI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                if (d.this.hrr != null && d.this.hrr.Kf().Ml()) {
                    layoutParams.bottomMargin = d.this.cbI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds88);
                } else {
                    layoutParams.bottomMargin = d.this.cbI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                }
                d.this.hrE.c(d.this.hqt, layoutParams);
                if (com.baidu.live.guardclub.e.IS() != null) {
                    com.baidu.live.guardclub.e.IS().IX();
                }
            }
        }
    };
    private CustomMessageListener hqP = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.d.6
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
                        d.this.caZ();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b hqR = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.d.18
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
                        if (d.this.cbI().hBt.Fm() != null && d.this.cbI().hBt.Fm().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.cbI().hBt.Fm().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.cbI().hBt.Fm().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.Lo());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.HZ()) {
                        if (com.baidu.live.d.xc().getBoolean("quick_gift_guide_show", true) && !d.this.caU()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, ah.class, d.this.cbI().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                ah ahVar = (ah) runTask.getData();
                                ahVar.setPageContext(d.this.cbI().pageContext);
                                ahVar.setLiveShowData(d.this.cbI().hBt.Fm());
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
                        n.a(d.this.cbI().pageContext, d.this.cbI().hBt.Fm(), com.baidu.live.ae.e.Qz().bBd.ES(), d.this.Lo());
                    }
                } else if (i == 1) {
                    if (d.this.hrr != null) {
                        d.this.caZ();
                    }
                } else if (i == 3 && d.this.HZ()) {
                    if (com.baidu.live.p.a.isDebug()) {
                        com.baidu.live.p.a.c(d.this.cbI().hBt.Fm().mLiveInfo.live_id, 0);
                        return;
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    d.this.hre.d(d.this.cbI().hBt.Fm(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.cbI() != null && d.this.cbI().hBt != null && d.this.cbI().hBt.Fm() != null && d.this.cbI().hBt.Fm().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.cbI().hBt.Fm().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.cbI().hBt.Fm().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.cbI().hBt.Fm().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.Lo());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.cbI() != null && d.this.cbI().hBt != null && d.this.cbI().hBt.Fm() != null && d.this.cbI().hBt.Fm().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.cbI().hBt.Fm().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.cbI().hBt.Fm().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.cbI().hBt.Fm().mLiveInfo.feed_id + "");
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
                    if (d.this.hrm != null && d.this.cbI().hBt.Fm() != null && d.this.cbI().hBt.Fm().mLiveInfo != null) {
                        String valueOf = String.valueOf(d.this.cbI().hBt.Fm().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.cbI().hBt.Fm().mLiveInfo.room_id);
                        String str3 = null;
                        AlaLiveSdkInfo alaLiveSdkInfo = d.this.cbI().hBt.Fm().mLiveSdkInfo;
                        if (alaLiveSdkInfo != null && alaLiveSdkInfo.mCastIds != null) {
                            str3 = String.valueOf(d.this.cbI().hBt.Fm().mLiveSdkInfo.mCastIds.chatMCastId);
                        }
                        d.this.hrm.ax(valueOf, valueOf2, str3);
                        com.baidu.live.p.a.c(d.this.cbI().hBt.Fm().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    ab Fm = d.this.cbI().hBt.Fm();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.cbI().pageContext.getPageActivity(), Fm.aId.userName, Long.toString(Fm.aId.userId), Long.toString(Fm.aId.charmCount), String.valueOf(Fm.mLiveInfo.group_id), String.valueOf(Fm.mLiveInfo.live_id), false, String.valueOf(Fm.aId.userId), Long.toString(Fm.aIz.userId), Fm.aIz.userName, Fm.aIz.portrait, d.this.hqj.getCount(), d.this.Lo())));
                    LogManager.getCommonLogger().doClickGusetNumLog(Fm.mLiveInfo.feed_id, d.this.hqj.getCount() + "", d.this.Lo());
                } else if (i == 11) {
                    d.this.cbe();
                    d.this.cbf();
                } else if (i == 16) {
                    if (d.this.cbI() != null && (bvVar2 = com.baidu.live.ae.a.Qj().bAS) != null && (coVar = bvVar2.aPM) != null) {
                        String str4 = coVar.aRu.aRD;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (d.this.cbI().hBt != null && d.this.cbI().hBt.Fm() != null && d.this.cbI().hBt.Fm().mLiveInfo != null) {
                                j = d.this.cbI().hBt.Fm().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", d.this.cbI().hBt.Fm().mLiveInfo.room_id + "", d.this.cbI().hBt.Fm().mLiveInfo.feed_id, d.this.Lo());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.cbI().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (d.this.cbI() != null) {
                        ab abVar = null;
                        if (d.this.cbI().hBt != null) {
                            abVar = d.this.cbI().hBt.Fm();
                        }
                        if (abVar != null && abVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.u.b.ckx().bvg != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.u.b.ckx().bvg.aHq;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + abVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + abVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(d.this.cbI().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17 && d.this.HZ() && d.this.cbI() != null && (bvVar = com.baidu.live.ae.a.Qj().bAS) != null && bvVar.aPM != null) {
                    String str6 = bvVar.aPM.aRA;
                    if (!TextUtils.isEmpty(str6)) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                        if (d.this.cbI().hBt != null && d.this.cbI().hBt.Fm() != null) {
                            if (d.this.hrG == null) {
                                d.this.hrG = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.cbI().pageContext.getPageActivity());
                            }
                            ab Fm2 = d.this.cbI().hBt.Fm();
                            String b2 = d.this.hrG.b(str6, Fm2.mLiveInfo.live_id, Fm2.aIz.userId, Fm2.aId.userId);
                            com.baidu.live.an.c cVar = new com.baidu.live.an.c();
                            cVar.url = b2;
                            d.this.bgE.a(cVar);
                        }
                    }
                }
            }
        }
    };
    private boolean htn = false;
    private boolean hto = false;

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.hrg = new com.baidu.tieba.ala.liveroom.guide.c(cbI().pageContext, this, false);
        this.hqE.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hqE);
        this.hqD.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hqD);
        this.hqF.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hqF);
        this.hqG.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hqG);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean isVertical() {
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void m(ab abVar) {
        super.m(abVar);
        g.cfl();
        this.hth = true;
        this.hto = false;
        this.htn = false;
        cbI().hBu.setIsForceHandledTouch(false);
        cbI().hBu.setSwipeClearEnable(true);
        cbI().hBu.setOnLiveViewScrollListener(this.hqH);
        cbI().hBu.setOnClickListener(null);
        cbI().hBu.setClickable(false);
        if (this.hrj != null) {
            this.hrj.b(this.hqR);
        }
        if (this.hsa != null) {
            this.hsa.setVisibility(0);
        }
        cae();
        if (this.hrC != null) {
            this.hrC.a(abVar, this.byA);
            this.hrC.U(this.hsb);
            this.hrC.a(this);
        }
        ccf();
        caq();
        caQ();
        caP();
        car();
        cav();
        cas();
        cbU();
        nQ(false);
        can();
        cao();
        cbh();
        caA();
        cbj();
        cax();
        cay();
        cbX();
        cbY();
        cbp();
        nS(false);
        cbm();
        cbq();
        cac();
        cbA();
        cag();
        cam();
        cah();
        cai();
        caj();
        cak();
        bZY();
        cbo();
        cbw();
        cbi();
        cbn();
        nW(true);
        cbz();
        c(this.grr);
        cad();
        cbV();
        cbv();
        caT();
        cbW();
        MessageManager.getInstance().registerListener(this.hqL);
        MessageManager.getInstance().registerListener(this.hqN);
        MessageManager.getInstance().registerListener(this.hqO);
        MessageManager.getInstance().registerListener(this.hqP);
        MessageManager.getInstance().registerListener(this.htm);
        MessageManager.getInstance().registerListener(this.hqQ);
        MessageManager.getInstance().registerListener(this.hqM);
        caB();
        cau();
        cbl();
        I(abVar);
    }

    private void I(ab abVar) {
        if (cbI() != null && cbI().brO != null && abVar != null && abVar.mLiveInfo != null && abVar.aJq != null && com.baidu.live.ae.a.Qj().buX.aMx) {
            if ("1".equals(abVar.mLiveInfo.pubShowId)) {
                if (abVar.aJq.aJO == 0) {
                    this.htl = 0;
                } else if (abVar.aJq.aJO == 1) {
                    this.htl = 8;
                } else if (abVar.aJq.aJO == 2) {
                    this.htl = 7;
                } else {
                    this.htl = 0;
                }
            } else {
                this.htl = 0;
            }
            cbI().brO.setVideoMode(this.htl);
            cch();
        }
    }

    private void cbU() {
    }

    private void cbV() {
        AlaVideoBCChatData alaVideoBCChatData;
        CustomResponsedMessage runTask;
        AlaLiveUserInfoData alaLiveUserInfoData = cbI().hBt.Fm().aIz;
        if (alaLiveUserInfoData != null && (alaVideoBCChatData = alaLiveUserInfoData.videoBCEnterData) != null && alaVideoBCChatData.isShowEnter()) {
            if (this.hrY == null && (runTask = MessageManager.getInstance().runTask(2913255, com.baidu.live.am.c.class, cbI().pageContext)) != null && runTask.getData() != null) {
                this.hrY = (com.baidu.live.am.c) runTask.getData();
            }
            if (this.hrY != null) {
                this.hrY.a(cbI().brO);
                this.hrY.b(cbI().hBs.getMastView());
                this.hrY.r(cbI().hBt.Fm());
                this.hrY.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.23
                    @Override // com.baidu.live.am.c.a
                    public void VH() {
                        if (d.this.hrj != null) {
                            d.this.cbI().hBu.hRi = false;
                            d.this.hrj.setPraiseEnable(false);
                            if (d.this.cbI().hBv != null) {
                                d.this.cbI().hBv.setTalentShowing(true);
                            }
                        }
                    }

                    @Override // com.baidu.live.am.c.a
                    public void VI() {
                        if (d.this.hrj != null) {
                            d.this.cbI().hBu.hRi = true;
                            d.this.hrj.setPraiseEnable(true);
                            if (d.this.cbI().hBv != null) {
                                d.this.cbI().hBv.setTalentShowing(false);
                            }
                        }
                    }
                });
                View enterView = this.hrY.getEnterView();
                if (enterView != null) {
                    if (enterView.getParent() != null) {
                        ((ViewGroup) enterView.getParent()).removeView(enterView);
                    }
                    this.hrb.cv(enterView);
                }
            }
        }
    }

    public void cbW() {
        this.htj = new com.baidu.live.follow.pendant.a(getActivity());
    }

    private void bZY() {
        if (this.hrQ != null) {
            this.hrQ.a(new com.baidu.live.y.c() { // from class: com.baidu.tieba.ala.liveroom.c.d.24
                @Override // com.baidu.live.y.c
                public void cP(boolean z) {
                    if (d.this.hqo != null) {
                        d.this.hqo.setNeedCloseRecommendFloat(z);
                    }
                    if (d.this.cbI().hBu.hRi) {
                        if (d.this.hrm != null) {
                            d.this.hrm.oK(z);
                            d.this.hrm.oS(!z);
                        }
                        if (d.this.hrj != null) {
                            d.this.hrj.oK(z);
                            d.this.hrj.setPraiseEnable(!z);
                            d.this.hrj.oJ(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(ab abVar) {
        super.k(abVar);
        if (this.hqg != null) {
            this.hqg.N(abVar);
        }
        if (this.hqh != null) {
            this.hqh.J(abVar);
        }
        if (this.hqk != null) {
            this.hqk.M(abVar);
        }
        if (this.hqo != null) {
            this.hqo.a(abVar);
        }
        if (this.htj != null) {
            if (this.htj.d(abVar) && !this.htj.isDisplay()) {
                ccg();
                this.htf = true;
                this.htg = true;
                if (this.hrM != null) {
                    this.hrM.aW(true);
                    this.hrM.aX(true);
                }
                if (this.hrj != null) {
                    this.hrj.setPraiseEnable(false);
                    cbI().hBu.hRi = false;
                }
                cbZ();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.topMargin = (int) getActivity().getResources().getDimension(a.d.sdk_ds16);
                ak akVar = abVar.aJq;
                if (akVar != null) {
                    this.htj.m(akVar.anchorPortrait, akVar.aHy, String.valueOf(akVar.aJM));
                    this.htj.b(ccn(), layoutParams);
                }
            } else if (!this.htj.d(abVar) && this.htj.isDisplay()) {
                this.htj.Dr();
                this.htf = false;
                this.htg = false;
                if (this.hrM != null) {
                    this.hrM.aW(false);
                    this.hrM.aX(false);
                }
                if (this.hrj != null) {
                    this.hrj.setPraiseEnable(true);
                    cbI().hBu.hRi = true;
                }
                cbZ();
                if (this.htk != null) {
                    this.htk.removeAllViews();
                    this.htk = null;
                }
            }
        }
        nW(false);
        if (this.hql != null) {
            this.hql.j(abVar);
            this.hql.nI(this.hsk);
            this.hql.updateView();
            if (abVar != null && this.hrS != null && !this.hrS.hasInit && !TextUtils.isEmpty(this.hrS.aQj)) {
                this.hrS.hasInit = true;
                this.hql.Hv(this.hrS.aQj);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(v vVar) {
        if (vVar != null) {
            if (this.hqf != null && vVar.getList() != null) {
                this.hqf.e(vVar);
            }
            if (this.hqj != null) {
                this.hqj.ff(vVar.getCount());
            }
        }
    }

    private void caa() {
        if (this.hrl != null) {
            this.hrl.aJ(cbI().hBs.getLiveContainerView());
        }
    }

    private void cbX() {
        if (this.hqp == null) {
            this.hqp = new com.baidu.tieba.ala.liveroom.b.a(cbI().pageContext);
        }
        if (cbI().hBt != null && cbI().hBt.Fm() != null && cbI().hBt.Fm().mLiveInfo != null) {
            this.hqp.Hw(String.valueOf(cbI().hBt.Fm().mLiveInfo.user_id));
        }
    }

    private void cbY() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (cbI() != null && cbI().hBt != null && cbI().hBt.Fm() != null && cbI().hBt.Fm().mLiveInfo != null) {
                j = cbI().hBt.Fm().mLiveInfo.room_id;
            }
            if (this.hrz == null) {
                this.hrz = new com.baidu.tieba.ala.liveroom.guide.a(cbI().pageContext, j);
            }
            this.hrz.nO(this.hsd);
            this.hrz.a(new a.InterfaceC0665a() { // from class: com.baidu.tieba.ala.liveroom.c.d.7
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0665a
                public void cco() {
                    if (d.this.brL != null) {
                        d.this.brL.cC(true);
                    }
                }
            });
            this.hrz.aF(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cv(int i) {
        super.cv(i);
        caa();
        if (this.hqo != null) {
            this.hqo.cv(i);
        }
    }

    private void cae() {
        if (this.byA == null) {
            this.byA = new PendantParentView(cbI().pageContext.getPageActivity(), cca());
            cbI().hBu.addView(this.byA, new ViewGroup.LayoutParams(-1, -1));
            this.byA.setDefaultItemMargin(cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.byA.setPadding(cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            cbZ();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void nL(boolean z) {
        if (z) {
            this.bottomMargin = cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds180);
        } else {
            this.bottomMargin = cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
        }
        cbZ();
    }

    private void cbZ() {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        if (this.byA != null) {
            this.byA.setModel(cca());
            int dimensionPixelSize3 = cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds220);
            if (this.bottomMargin != 0) {
                dimensionPixelSize = this.bottomMargin;
            } else {
                dimensionPixelSize = cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            }
            if (this.gQr) {
                dimensionPixelSize2 = ccl();
            } else {
                dimensionPixelSize2 = cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds250);
            }
            this.byA.setPosition(dimensionPixelSize3, 0, dimensionPixelSize2, dimensionPixelSize);
            return;
        }
        cae();
    }

    private PendantParentView.Model cca() {
        if (this.gQr) {
            return PendantParentView.Model.VERTICAL_PK;
        }
        if (this.htf) {
            return PendantParentView.Model.VERTICAL_BB_CHATING;
        }
        return PendantParentView.Model.VERTICAL;
    }

    private void ccb() {
        if (cbI().hBu != null && !this.hto) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.8
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.hqt != null && d.this.hrr != null && d.this.hrr.Kd() != null && d.this.hrr.Kd().getView() != null) {
                        if (d.this.gQr && !d.this.hse && d.this.cbI().hBu != null && d.this.cbI().hBu.getHeight() > 0 && !d.this.htg) {
                            int bp = d.this.hqo != null ? d.this.hqo.bp(false) : 0;
                            ViewGroup.LayoutParams layoutParams = d.this.hqt.getLayoutParams();
                            int height = d.this.cbI().hBu.getHeight() - bp;
                            int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                i += UtilHelper.getStatusBarHeight();
                            }
                            if (layoutParams != null && d.this.hrr != null) {
                                layoutParams.height = i + d.this.cbI().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                                d.this.hqt.setLayoutParams(layoutParams);
                                ViewGroup.LayoutParams layoutParams2 = d.this.hrr.Kd().getView().getLayoutParams();
                                if (layoutParams2 != null) {
                                    layoutParams2.height = layoutParams.height - com.baidu.live.aj.c.ds(false);
                                    d.this.hrr.Kd().getView().setLayoutParams(layoutParams2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        int j = com.baidu.live.aj.c.j(false, d.this.hse);
                        if (d.this.hsb.indexOfChild(d.this.hqt) != -1 && d.this.hqt.getLayoutParams() != null) {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) d.this.hqt.getLayoutParams();
                            layoutParams3.height = com.baidu.live.aj.c.d(false, false, d.this.hse);
                            d.this.hqt.setLayoutParams(layoutParams3);
                        }
                        if (d.this.hqt.indexOfChild(d.this.hrr.Kd().getView()) != -1 && d.this.hrr.Kd().getView().getLayoutParams() != null) {
                            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) d.this.hrr.Kd().getView().getLayoutParams();
                            layoutParams4.height = j;
                            d.this.hrr.Kd().getView().setLayoutParams(layoutParams4);
                        }
                        d.this.hrr.Kd().Kc();
                    }
                }
            });
        }
    }

    private void ccc() {
        if (cbI().hBu != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.9
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.hrt != null) {
                        if (d.this.gQr && !d.this.hse && d.this.cbI().hBu != null && d.this.cbI().hBu.getHeight() > 0) {
                            int height = (d.this.cbI().hBu.getHeight() - (d.this.hqo != null ? d.this.hqo.bp(false) : 0)) + d.this.cbI().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            if (d.this.hrt != null) {
                                d.this.hrt.cH(height);
                            }
                        } else if (d.this.hrt != null) {
                            d.this.hrt.cH(com.baidu.live.aj.a.b(d.this.cbI().pageContext.getPageActivity(), false, false, d.this.hse));
                        }
                    }
                }
            });
        }
    }

    private void ccd() {
        if (cbI().hBu != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.10
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    if (d.this.hrt != null) {
                        int i2 = com.baidu.live.aj.a.i(false, false);
                        if (!d.this.gQr || d.this.cbI().hBu == null || d.this.cbI().hBu.getHeight() <= 0) {
                            i = i2;
                        } else {
                            int height = d.this.cbI().hBu.getHeight() - (d.this.hqo != null ? d.this.hqo.bp(false) : 0);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            i = height + d.this.cbI().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                        }
                        if (d.this.hrt != null) {
                            d.this.hrt.cI(i);
                        }
                    }
                }
            });
        }
    }

    private void cce() {
        if (this.hrs != null && this.hrs.zP() != null) {
            ViewGroup.LayoutParams layoutParams = this.hrs.zP().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = cbI().pageContext.getResources().getDimensionPixelOffset(this.gQr ? a.d.sdk_ds100 : a.d.sdk_ds20);
                this.hrs.zP().setLayoutParams(layoutParams);
            }
        }
    }

    private void ccf() {
        if (this.htd == null) {
            this.htd = new LinearLayout(cbI().pageContext.getPageActivity());
            this.htd.setOrientation(1);
        }
        if (this.htd.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds160);
            layoutParams.leftMargin = cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            cbI().hBu.addView(this.htd, layoutParams);
        }
    }

    private void ccg() {
        if (ccn() == null && com.baidu.live.ae.a.Qj().buX != null) {
            if (!com.baidu.live.ae.a.Qj().buX.aMx) {
                this.htl = 0;
            }
            cch();
        }
    }

    private void cch() {
        List<cw.a> list;
        int i;
        if (cbI() != null && cbI().hBs != null && cbI().hBs.getMastView() != null && cbI().hBt != null && cbI().pageContext != null && cbI().pageContext.getResources() != null) {
            com.baidu.live.ae.a Qj = com.baidu.live.ae.a.Qj();
            if (Qj.buX != null && Qj.buX.aNv != null && (list = com.baidu.live.ae.a.Qj().buX.aNv.dataList) != null && list.size() >= 2) {
                cw.a aVar = list.get(1) == null ? cw.a.aSP.get(1) : list.get(1);
                int i2 = com.baidu.live.ae.a.Qj().buX.aNv.aSK;
                int i3 = com.baidu.live.ae.a.Qj().buX.aNv.aSL;
                DisplayMetrics displayMetrics = cbI().pageContext.getResources().getDisplayMetrics();
                int i4 = displayMetrics.widthPixels;
                int i5 = displayMetrics.heightPixels;
                if (this.activity != null && com.baidu.live.utils.d.bd(this.activity)) {
                    i5 += com.baidu.live.utils.d.bi(this.activity);
                }
                int i6 = (((i2 * i5) / i3) - i4) / 2;
                int i7 = (aVar.width * i5) / i3;
                if (this.htl == 0) {
                    i = ((aVar.x * i5) / i3) - i6;
                } else if (this.htl == 8) {
                    i = (aVar.x * i5) / i3;
                } else {
                    i = this.htl == 7 ? ((aVar.x * i5) / i3) - (i6 * 2) : 0;
                }
                int i8 = (aVar.height * i5) / i3;
                int i9 = (aVar.y * i5) / i3;
                if (this.htk == null) {
                    this.htk = new LinearLayout(cbI().pageContext.getPageActivity());
                    this.htk.setOrientation(1);
                }
                if (this.htk.getParent() == null) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((i >= 0 || this.htl != 0) ? i7 : i7 + i, -2);
                    layoutParams.gravity = 8388659;
                    layoutParams.topMargin = i9 + i8;
                    if (!UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams.topMargin += UtilHelper.getImmersiveStickyBarHeight();
                    } else if (com.baidu.live.utils.d.Vl() && this.activity != null) {
                        layoutParams.topMargin += com.baidu.live.utils.d.bi(this.activity);
                    }
                    if (i < 0 && this.htl == 0) {
                        i = 0;
                    }
                    layoutParams.leftMargin = i;
                    cbI().hBs.getMastView().addView(this.htk, layoutParams);
                } else if (this.htk != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.htk.getLayoutParams();
                    if (i < 0 && this.htl == 0) {
                        i7 += i;
                    }
                    if (i < 0 && this.htl == 0) {
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
                    this.htk.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    private void cag() {
        if (this.hql == null) {
            this.hql = new com.baidu.tieba.ala.liveroom.activeview.b(cbI().pageContext);
        }
        if (cbI() != null && cbI().hBt != null) {
            this.hql.Hs(cbI().hBt.cjD());
        }
        this.hql.aW(this.gQr);
        this.hql.setOtherParams(Lo());
        this.hql.c(cbI().hBt.Fm(), false);
        this.hql.setHost(false);
        this.hql.nI(this.hsk);
        this.hql.a(1, this.byA);
        this.hql.a(2, this.byA);
        this.hql.setVisible(this.hse ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cam() {
        if (this.hrb == null) {
            cas();
        }
        this.hrb.setOtherParams(Lo());
        this.hrb.a(com.baidu.live.ae.e.Qz().bBd, cbI().hBt.Fm());
    }

    private void cah() {
        if (this.hqk == null) {
            this.hqk = new com.baidu.tieba.ala.liveroom.k.a(cbI().pageContext, this);
        }
        this.hqk.setOtherParams(Lo());
        this.hqk.a((ViewGroup) this.byA, cal());
        this.hqk.M(cbI().hBt.Fm());
    }

    private void cad() {
        if (cbI() != null) {
            if (this.hrM == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913271, com.baidu.live.a.a.class, cbI().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hrM = (com.baidu.live.a.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hrM.aW(this.gQr);
            this.hrM.setIsHorizontal(false);
            this.hrM.a(caG(), cbI().hBt.Fm());
            this.hrM.setIsHost(false);
            this.hrM.a(new a.InterfaceC0154a() { // from class: com.baidu.tieba.ala.liveroom.c.d.11
                @Override // com.baidu.live.a.a.InterfaceC0154a
                public void xi() {
                    d.this.cci();
                }

                @Override // com.baidu.live.a.a.InterfaceC0154a
                public void xj() {
                    d.this.ccj();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cci() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccj() {
    }

    private void cai() {
        if (this.hrE == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, j.class, cbI().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hrE = (j) runTask.getData();
            } else {
                return;
            }
        }
        this.hrE.setOtherParams(Lo());
        if (this.hqt != null && this.hqt.indexOfChild(this.hrE.getView()) >= 0) {
            this.hqt.removeView(this.hrE.getView());
        }
    }

    private void caj() {
        if (this.hrb != null) {
            this.hrb.a(new a.InterfaceC0670a() { // from class: com.baidu.tieba.ala.liveroom.c.d.13
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0670a
                public void bO(int i, int i2) {
                    ab Fm = d.this.cbI().hBt.Fm();
                    if (Fm != null && Fm.mLiveInfo != null) {
                        if (d.this.hrG == null) {
                            d.this.hrG = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.cbI().pageContext.getPageActivity());
                        }
                        d.this.hrG.d(d.this.hsb, i, i2);
                        d.this.hrG.a(String.valueOf(Fm.mLiveInfo.live_id), new a.InterfaceC0674a() { // from class: com.baidu.tieba.ala.liveroom.c.d.13.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0674a
                            public void a(float f, String str) {
                                if (d.this.hrb != null) {
                                    d.this.hrb.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0670a
                public void bP(int i, int i2) {
                    if (d.this.hrG != null) {
                        d.this.hrG.bU(i, i2);
                    }
                }
            });
        }
    }

    private void cak() {
        if (this.hsq == null) {
            this.hsq = new com.baidu.tieba.ala.liveroom.i.e(cbI().pageContext);
        }
        this.hsq.setRoomId(cbI().hBt.Fm().mLiveInfo.room_id);
        this.hsq.HN("");
        this.hsq.b(cbI().hBt.Fm(), this.byA);
        if (this.hqC == null) {
            this.hqC = new com.baidu.tieba.ala.liveroom.i.b(cbI().pageContext, Lo(), this.hsq, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.14
                @Override // com.baidu.tieba.ala.liveroom.i.b.a
                public void caJ() {
                    d.this.nP(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.i.b.a
                public void caK() {
                    d.this.nP(false);
                }
            });
        }
        this.hqC.setRoomId(cbI().hBt.Fm().mLiveInfo.room_id);
        if (this.hqt != null && this.hqt.indexOfChild(this.hqC.getView()) >= 0) {
            this.hqt.removeView(this.hqC.getView());
        }
        if (this.hqC != null) {
            this.hqC.b(cbI());
        }
    }

    private void caA() {
        if (this.hti == null) {
            this.hti = new com.baidu.tieba.ala.liveroom.apppromotion.a(cbI().pageContext);
        }
        this.hti.b(caG(), cbI().hBt.Fm());
    }

    private LinearLayout.LayoutParams cal() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    private void can() {
        CustomResponsedMessage runTask;
        if (this.hrr == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, cbI().pageContext)) != null && runTask.getData() != null) {
            this.hrr = (k) runTask.getData();
            this.hrr.setFromMaster(false);
            this.hrr.Kd().getView().setId(a.f.ala_liveroom_msg_list);
            this.hrr.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.15
                @Override // com.baidu.live.im.k.a
                public boolean Kh() {
                    return d.this.HZ();
                }

                @Override // com.baidu.live.im.k.a
                public void Ki() {
                    d.this.hsi = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hb(String str) {
                    if (!d.this.hse) {
                        d.this.nN(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.cbI().pageContext.getPageActivity(), d.this.cbI().hBs.getLiveContainerView());
                    }
                    d.this.Hz(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Kj() {
                    if (d.this.hse) {
                        d.this.nN(true);
                        d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.15.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.cbI().pageContext.getPageActivity(), d.this.cbI().hBs.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.hrr != null) {
                        d.this.hrr.Ke().setQuickInputPanelVisible(false);
                        d.this.hrr.Ke().LZ();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Kk() {
                }

                @Override // com.baidu.live.im.k.a
                public void Kl() {
                    if (d.this.hse) {
                        d.this.caI();
                        if (d.this.hrs != null) {
                            d.this.hrs.zQ();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Km() {
                    return d.this.caV();
                }

                @Override // com.baidu.live.im.k.a
                public int Kn() {
                    return d.this.caW();
                }

                @Override // com.baidu.live.im.k.a
                public boolean Ko() {
                    ab Fm = d.this.cbI().hBt.Fm();
                    if (Fm == null || Fm.aIz == null) {
                        return false;
                    }
                    return Fm.aIz.isMysteriousMan;
                }
            });
            this.hqt = new FrameLayout(cbI().pageContext.getPageActivity());
            this.hqt.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.hrr != null && this.hqt != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(cbI().pageContext.getPageActivity()) * 0.7f);
            int j = com.baidu.live.aj.c.j(false, false);
            if (this.hsb.indexOfChild(this.hqt) < 0) {
                if (this.hqt.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hqt.getParent()).removeView(this.hqt);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.live.aj.c.d(false, false, false));
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.live.aj.c.dr(false);
                this.hsb.addView(this.hqt, layoutParams);
            }
            if (this.hqt.indexOfChild(this.hrr.Kd().getView()) < 0) {
                if (this.hrr.Kd().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hrr.Kd().getView()).removeView(this.hrr.Kd().getView());
                }
                this.hqt.addView(this.hrr.Kd().getView(), new FrameLayout.LayoutParams(equipmentWidth, j));
            }
            if (cbI().hBu.indexOfChild(this.hrr.Ke().getView()) < 0) {
                if (this.hrr.Ke().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hrr.Ke().getView().getParent()).removeView(this.hrr.Ke().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                cbc();
                cbI().hBu.addView(this.hrr.Ke().getView(), layoutParams2);
            }
            ab Fm = cbI().hBt.Fm();
            if (Fm != null && Fm.mLiveInfo != null) {
                this.hrr.setLogData(Fm.mLiveInfo.feed_id, Lo());
            }
            this.hrr.a(String.valueOf(cbI().hBt.Fm().mLiveInfo.group_id), String.valueOf(cbI().hBt.Fm().mLiveInfo.last_msg_id), String.valueOf(cbI().hBt.Fm().aId.userId), String.valueOf(cbI().hBt.Fm().mLiveInfo.live_id), cbI().hBt.Fm().aId.appId, (Fm == null || Fm.aIR == null || !Fm.aIR.Bf()) ? false : true, cbI().hBt.Fm().getGuardName());
            nN(false);
        }
    }

    private void caq() {
        if (this.hqg == null) {
            this.hqg = new com.baidu.tieba.ala.liveroom.m.a(cbI().pageContext, false, this);
        }
        this.hqg.e(this.hsa, cbI().hBt.Fm());
        this.hqg.a(this.hqR);
        this.hqg.setOtherParams(Lo());
    }

    private void car() {
        if (this.hqf == null) {
            this.hqf = new com.baidu.tieba.ala.liveroom.audiencelist.c(cbI().pageContext, this, false);
        }
        this.hqf.a(String.valueOf(cbI().hBt.Fm().mLiveInfo.group_id), String.valueOf(cbI().hBt.Fm().mLiveInfo.live_id), String.valueOf(cbI().hBt.Fm().aId.userId), cbI().hBt.Fm());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.f.ala_liveroom_hostheader;
            if (this.hrc != null && this.hrc.getView() != null && this.hrc.getView().getParent() != null) {
                i = a.f.ala_liveroom_guardthrone;
            }
            this.hqf.c(this.hsa, i, a.f.ala_liveroom_audience_count_layout);
            this.hqf.e(cbI().hBt.bTK());
            this.hqf.setOtherParams(Lo());
        }
    }

    private void cas() {
        com.baidu.live.core.a.a Mq;
        if (this.hrb == null) {
            this.hrb = new com.baidu.tieba.ala.liveroom.operation.a(cbI().pageContext);
        }
        this.hrb.a(cbI(), this.hsb, cbI().hBt.Fm().mLiveInfo, true, this.hqR);
        this.hrb.setOtherParams(Lo());
        if (this.hrC != null && (Mq = this.hrC.Mq()) != null) {
            View rootLayout = Mq.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.hrb.cu(rootLayout);
        }
        this.hrb.S(cbI().hBt.Fm());
    }

    private void cao() {
        cba();
    }

    public void nV(boolean z) {
        if (this.hrb != null) {
            this.hrb.nV(z);
        }
    }

    private void cav() {
        if (this.hqj == null) {
            this.hqj = new com.baidu.tieba.ala.liveroom.audiencelist.b(cbI().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (cbI().hBt.bTK() != null) {
            j = cbI().hBt.bTK().getCount();
        }
        this.hqj.a(this.hqR);
        this.hqj.a(this.hsa, a.f.ala_liveroom_hostheader, j);
        this.hqj.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.hqj.nZ(false);
        } else {
            this.hqj.nZ(true);
        }
    }

    protected void HC(String str) {
        if (this.hsp == null) {
            this.hsp = new com.baidu.tieba.ala.liveroom.s.b(cbI().pageContext);
        }
        this.hsp.c(this.hsb, str);
        nP(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.16
            @Override // java.lang.Runnable
            public void run() {
                d.this.hsp.ckk();
                d.this.nP(false);
            }
        }, 5000L);
    }

    private void nW(boolean z) {
        CustomResponsedMessage runTask;
        if (cbI().hBt.Fm().mLiveInfo.live_type == 1 && this.hth) {
            if (this.hte == null && (runTask = MessageManager.getInstance().runTask(2913074, e.class, cbI().pageContext)) != null && runTask.getData() != null) {
                this.hte = (e) runTask.getData();
            }
            if (this.hte != null) {
                if (this.hqn == null) {
                    this.hqn = this.hte.a(cbI().pageContext);
                }
                if (z) {
                    this.hqn.Az();
                }
                if (cbI().hBt.Fm().mLiveInfo.challengeId > 0 && !this.hqn.AH()) {
                    this.hqn.h(cbI().hBt.Fm().mLiveInfo.live_id, cbI().hBt.Fm().aId.userId);
                    nX(z);
                    if (z) {
                        this.hqn.a(cbI().hBt.ciK());
                    }
                    this.hqn.c(cbI().hBt.Fm());
                }
            }
        }
    }

    private void nX(boolean z) {
        if (this.hqo == null) {
            this.hqo = this.hte.b(cbI().pageContext);
            this.hqo.a(new com.baidu.live.challenge.g() { // from class: com.baidu.tieba.ala.liveroom.c.d.17
                @Override // com.baidu.live.challenge.g
                public void Av() {
                    d.this.cbI().hBu.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.g
                public void a(bg bgVar, bk bkVar, bk bkVar2) {
                    d.this.gQr = true;
                    d.this.Xe();
                    if (d.this.cbI().brO != null) {
                        d.this.cbI().brO.getLivePlayer().setBackgroundResource(a.c.sdk_transparent);
                    }
                    if (d.this.hrh != null) {
                        d.this.hrh.setTimeTextMode(true);
                    }
                    if (d.this.brL != null && bkVar != null && bkVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(bkVar.aOW);
                        arrayList.add(bkVar2.aOW);
                        com.baidu.live.liveroom.a.c cVar = d.this.brL;
                        if (d.this.hsm) {
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
                    d.this.cbI().hBu.setSwipeClearEnable(true);
                    d.this.gQr = false;
                    d.this.cck();
                    if (d.this.brL != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.cbI().hBt.cjz());
                        com.baidu.live.liveroom.a.c cVar = d.this.brL;
                        if (d.this.hsm) {
                            arrayList = null;
                        }
                        cVar.j(arrayList);
                    }
                    if (d.this.cbI().brO != null) {
                        d.this.cbI().brO.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
                    }
                    if (d.this.hrh != null) {
                        d.this.hrh.setTimeTextMode(false);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void bo(boolean z2) {
                    if (z2 && d.this.hrQ != null) {
                        d.this.hrQ.onClose();
                    }
                }
            });
        }
        this.hqo.a(this.hqn);
        this.hqo.k(cbI().hBs.getLiveContainerView());
        this.hqo.c(z, false, false);
        this.hqn.a((i.c) this.hqo);
    }

    protected void Xe() {
        if (this.hri != null) {
            this.hri.vm(8);
        }
        if (this.hrj != null) {
            this.hrj.setPraiseEnable(false);
            cbI().hBu.hRi = false;
        }
        if (this.hrL != null) {
            this.hrL.setCanVisible(false);
        }
        if (this.hrk != null) {
            this.hrk.ckv();
        }
        if (this.hqk != null) {
            this.hqk.setCanVisible(false);
            this.hqk.cfp();
        }
        if (this.hql != null) {
            this.hql.aW(true);
        }
        if (this.hsq != null) {
            this.hsq.setVisible(8);
        }
        if (this.hqm != null) {
            this.hqm.setCanVisible(false);
            this.hqm.setVisible(8);
        }
        if (this.hrM != null) {
            this.hrM.aW(true);
            this.hrM.aX(true);
        }
        cbZ();
        ccb();
        ccc();
        ccd();
        cce();
    }

    protected void cck() {
        if (this.hri != null) {
            this.hri.vm(0);
        }
        if (this.hrj != null) {
            this.hrj.setPraiseEnable(true);
            cbI().hBu.hRi = true;
        }
        if (this.hrL != null) {
            this.hrL.setCanVisible(true);
        }
        if (this.hrk != null) {
            this.hrk.ckw();
        }
        if (this.hqk != null) {
            this.hqk.setCanVisible(true);
            this.hqk.M(cbI().hBt.Fm());
        }
        if (this.hrm != null) {
            this.hrm.oS(true);
        }
        if (this.hql != null) {
            this.hql.aW(false);
        }
        if (this.hsq != null) {
            this.hsq.setVisible(0);
        }
        if (this.hqm != null) {
            this.hqm.setCanVisible(true);
            this.hqm.setVisible(0);
        }
        if (this.hrM != null) {
            this.hrM.aW(false);
            this.hrM.aX(false);
        }
        cbZ();
        ccb();
        ccc();
        ccd();
        cce();
    }

    public void caw() {
        this.hre.d(cbI().hBt.Fm(), false);
    }

    public void cax() {
        if (cbI().hBt.Fm() != null && cbI().hBt.Fm().aId != null && cbI().hBt.Fm().mLiveInfo != null) {
            if (this.hqi == null) {
                this.hqi = new com.baidu.tieba.ala.liveroom.t.b(cbI().pageContext);
            }
            long j = cbI().hBt.Fm().aId.userId;
            int i = cbI().hBt.Fm().mLiveInfo.live_type;
            String str = cbI().hBt.Fm().aId.portrait;
            String str2 = cbI().hBt.Fm().mLiveInfo.feed_id;
            long j2 = cbI().hBt.Fm().mLiveInfo.live_id;
            this.hqi.a(i, j, cbI().hBt.Fm().aId.userName, false, str, Lo(), str2, j2);
            this.hqi.aF(this.hsa);
        }
    }

    private int ccl() {
        return (this.hqo != null ? this.hqo.bp(false) : 0) - BdUtilHelper.getStatusBarHeight(this.activity);
    }

    private void cay() {
        boolean z = true;
        if (this.hrm == null) {
            this.hrm = new com.baidu.tieba.ala.liveroom.v.a(cbI().pageContext, this);
        }
        this.hrm.c(cbI().hBu, false);
        AlaLiveInfoData alaLiveInfoData = cbI().hBt.Fm().mLiveInfo;
        if (alaLiveInfoData != null) {
            boolean z2 = cbH() && alaLiveInfoData.screen_direction != 2;
            boolean isZanAnimUnabled = alaLiveInfoData.mAlaLiveSwitchData != null ? alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled() : false;
            if (!z2 || isZanAnimUnabled) {
                z = false;
            }
            this.hrm.oR(z);
        }
    }

    private void caB() {
        if (this.hsi || this.hsj) {
            if ((TbadkCoreApplication.isLogin() && this.hrr.Ke().hasText()) || this.hsj) {
                this.hsi = false;
                this.hsj = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.19
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.caZ();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void cat() {
        cau();
    }

    private void cau() {
        if (this.hrb != null) {
            int i = cbI().hBt.Fm().aIz.isUegBlock;
            int i2 = cbI().hBt.Fm().aIz.isBlock;
            String str = cbI().hBt.Fm().aIz.userName;
            if (i > 0 || i2 > 0) {
                this.hrb.b(true, i, i2, str);
                this.hrr.a(true, i, i2, str);
                this.hrx.b(true, i, i2, str);
                return;
            }
            this.hrb.b(false, i, i2, str);
            this.hrr.a(false, i, i2, str);
            this.hrx.b(false, i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void t(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        super.t(bVar);
        if (this.hql != null) {
            this.hql.N(bVar);
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
                    if (this.hqk != null) {
                        this.hqk.Q(jSONObject);
                    }
                } else if ("enter_live".equals(optString)) {
                    if (this.hqj != null && this.hqj.getCount() > 20) {
                        this.hqj.ff(this.hqj.getCount() + 1);
                    } else if (this.hqf != null) {
                        com.baidu.live.data.a KZ = bVar.KZ();
                        u uVar = new u();
                        uVar.aIe = new AlaLocationData();
                        uVar.aIf = new AlaRelationData();
                        uVar.aId = new AlaLiveUserInfoData();
                        uVar.aId.userId = JavaTypesHelper.toLong(KZ.userId, 0L);
                        uVar.aId.userName = KZ.userName;
                        uVar.aId.portrait = KZ.portrait;
                        if (this.hqj != null && this.hqf.c(uVar)) {
                            this.hqj.ff(this.hqj.getCount() + 1);
                        }
                    }
                } else if ("update_liveinfo".equals(optString)) {
                    if (cbI().hBt.Fm() != null && cbI().hBt.Fm().mLiveInfo != null) {
                        cbI().hBt.a(cbI().hBt.Fm().mLiveInfo.live_id, cbI().fromType, cbI().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString)) {
                    if (cbI().hBt.Fm() != null && cbI().hBt.Fm().mLiveInfo != null && cbI().hBt.Fm().aIz != null && this.hqo != null) {
                        long optLong = jSONObject.optLong("mvp_user_id");
                        long optLong2 = jSONObject.optLong("winner_live_id");
                        if (optLong == cbI().hBt.Fm().aIz.userId && optLong2 == cbI().hBt.Fm().mLiveInfo.live_id) {
                            this.hqo.g(jSONObject.optInt("challenge_status"), jSONObject.optLong("challenge_id"));
                        }
                    }
                } else if ("pub_show".equals(optString)) {
                    if (cbI() != null && com.baidu.live.ae.a.Qj().buX.aMx) {
                        int optInt = jSONObject.optInt("type");
                        int optInt2 = jSONObject.optInt("status");
                        int optInt3 = jSONObject.optInt("align");
                        if (cbI().brO != null) {
                            if (optInt == 1) {
                                if (optInt2 == 2) {
                                    if (optInt3 == 0) {
                                        this.htl = 0;
                                    } else if (optInt3 == 1) {
                                        this.htl = 8;
                                    } else if (optInt3 == 2) {
                                        this.htl = 7;
                                    } else {
                                        this.htl = 0;
                                    }
                                } else {
                                    this.htl = 0;
                                }
                            } else {
                                this.htl = 0;
                            }
                            cbI().brO.setVideoMode(this.htl);
                            cch();
                        }
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        if (this.hrL == null || this.hrL.J(bVar)) {
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void Hu(String str) {
        if (this.hql != null) {
            this.hql.Hu(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hrY != null) {
            this.hrY.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void cH(boolean z) {
        super.cH(z);
        if (cbI().hBu != null) {
            cbI().hBu.clj();
            cbI().hBu.setLiveViewOnDispatchTouchEventListener(null);
            cbI().hBu.setLiveViewOnTouchEventListener(null);
            cbI().hBu.setOnLiveViewScrollListener(null);
        }
        if (cbI().brO != null) {
            cbI().brO.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
        }
        if (this.hqo != null) {
            this.hqo.Ar();
        }
        caC();
        if (this.hqi != null) {
            this.hqi.Ar();
        }
        if (this.hrm != null) {
            this.hrm.release();
        }
        if (this.hqk != null) {
            this.hqk.Ar();
        }
        if (this.hrb != null) {
            this.hrb.cjP();
        }
        if (this.hqh != null) {
            this.hqh.cem();
            this.hqh.setVisible(8);
        }
        if (this.hqm != null) {
            this.hqm.Ar();
        }
        if (this.hql != null) {
            this.hql.release();
        }
        if (this.byA != null) {
            this.byA.removeAllViews();
            this.byA = null;
        }
        if (this.htd != null) {
            this.htd.removeAllViews();
            this.htd = null;
        }
        if (this.htk != null) {
            this.htk.removeAllViews();
            this.htk = null;
        }
        if (this.hrm != null) {
            this.hrm.onDestroy();
        }
        if (this.hqn != null) {
            this.hqn.Ar();
        }
        if (this.hqg != null) {
            this.hqg.cgj();
        }
        if (this.hqC != null) {
            this.hqC.cancel();
        }
        if (this.hsq != null) {
            this.hsq.cdg();
        }
        if (this.hti != null) {
            this.hti.xh();
        }
        if (this.hrL != null) {
            this.hrL.xh();
        }
        if (this.hqs != null) {
            this.hqs.xh();
        }
        if (this.hqC != null) {
            this.hqC.Ar();
        }
        if (this.hrU != null) {
            this.hrU.Ar();
        }
        if (this.hrY != null) {
            this.hrY.Ru();
        }
        if (this.htj != null && this.htj.isDisplay()) {
            this.htf = false;
            this.htg = false;
            if (this.hrM != null) {
                this.hrM.aW(false);
                this.hrM.aX(false);
            }
            this.htj.Dr();
        }
        if (cbI().hBv != null) {
            cbI().hBv.setTalentShowing(false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cF(boolean z) {
        super.cF(z);
        caC();
        if (this.hqg != null) {
            this.hqg.onDestroy();
        }
        if (this.hqi != null) {
            this.hqi.onDestroy();
        }
        if (this.hqk != null) {
            this.hqk.onDestroy();
        }
        if (this.hqm != null) {
            this.hqm.onDestroy();
        }
        if (this.hqn != null) {
            this.hqn.onDestroy();
        }
        if (this.hqo != null) {
            this.hqo.onDestroy();
        }
        if (this.hqp != null) {
            this.hqp.onDestroy();
        }
        if (this.hrz != null) {
            this.hrz.onDestroy();
        }
        if (this.hqh != null) {
            this.hqh.onDestroy();
        }
        if (this.hqf != null) {
            this.hqf.onDestroy();
        }
        if (this.hrr != null) {
            this.hrr.onDestroy();
        }
        if (this.hrb != null) {
            this.hrb.onDestory();
        }
        if (this.hql != null) {
            this.hql.release();
        }
        if (this.hsq != null) {
            this.hsq.cF(!z);
        }
        if (this.hqs != null) {
            this.hqs.onDestroy();
        }
        if (this.hqC != null) {
            this.hqC.onDestroy();
            this.hqC = null;
        }
        if (this.hrU != null) {
            this.hrU.onDestroy();
        }
        if (this.hrY != null) {
            this.hrY.onDestroy();
        }
        if (cbI().hBv != null) {
            cbI().hBv.setTalentShowing(false);
        }
        if (this.hti != null) {
            this.hti.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.hqE);
        MessageManager.getInstance().removeMessageRule(this.hqD);
        MessageManager.getInstance().removeMessageRule(this.hqF);
        MessageManager.getInstance().removeMessageRule(this.hqG);
        MessageManager.getInstance().unRegisterListener(this.hqL);
        MessageManager.getInstance().unRegisterListener(this.hqN);
        MessageManager.getInstance().unRegisterListener(this.hqO);
        MessageManager.getInstance().unRegisterListener(this.hqP);
        MessageManager.getInstance().unRegisterListener(this.htm);
        MessageManager.getInstance().unRegisterListener(this.hqQ);
        MessageManager.getInstance().unRegisterListener(this.hqM);
    }

    private void caC() {
        if (this.hrr != null && this.hrr.Kd().getView() != null && this.hrr.Kd().getView().getParent() != null) {
            ((ViewGroup) this.hrr.Kd().getView().getParent()).removeView(this.hrr.Kd().getView());
        }
        if (this.hqt != null && this.hqt.getParent() != null) {
            ((ViewGroup) this.hqt.getParent()).removeView(this.hqt);
        }
        if (this.hrr != null && this.hrr.Ke().getView() != null) {
            this.hsb.removeView(this.hrr.Ke().getView());
        }
        if (this.hrr != null) {
            this.hrr.Kd().setMsgData(new LinkedList());
            this.hrr.zR();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void a(ax axVar) {
        if (this.hrr != null) {
            caZ();
            String nameShow = axVar.getNameShow();
            if (axVar.extInfoJson != null) {
                if (axVar.extInfoJson.optInt("is_mysterious_man") == 1) {
                    nameShow = axVar.extInfoJson.optString("mysterious_man_nickname");
                    if (TextUtils.isEmpty(nameShow)) {
                        nameShow = "神秘人";
                    }
                }
            }
            this.hrr.Ke().setEditText(" @" + nameShow + " ");
        }
        if (this.hrb != null) {
            this.hrb.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void g(com.baidu.live.data.a aVar) {
        if (this.hrr != null) {
            caZ();
            String nameShow = aVar.getNameShow();
            if (aVar.extInfoJson != null) {
                if (aVar.extInfoJson.optInt("is_mysterious_man") == 1) {
                    nameShow = aVar.extInfoJson.optString("mysterious_man_nickname");
                    if (TextUtils.isEmpty(nameShow)) {
                        nameShow = "神秘人";
                    }
                }
            }
            this.hrr.Ke().setEditText(" @" + nameShow + " ");
        }
        if (this.hrb != null) {
            this.hrb.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void Hx(String str) {
        if (this.hrr != null) {
            caZ();
            StringBuilder sb = new StringBuilder();
            sb.append(" @");
            sb.append(str);
            sb.append(" ");
            if (com.baidu.live.ae.a.Qj().buX.aME != null && com.baidu.live.ae.a.Qj().buX.aME.originTexts != null && com.baidu.live.ae.a.Qj().buX.aME.originTexts.size() > 0) {
                this.hrr.Ke().Ma();
                this.hrr.Ke().setEditText(sb.toString() + com.baidu.live.ae.a.Qj().buX.aME.originTexts.get(0));
            } else {
                this.hrr.Ke().setEditText(sb.toString());
            }
        }
        if (this.hrb != null) {
            this.hrb.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void b(ax axVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected View caD() {
        if (this.hrr != null) {
            return this.hrr.Ke().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean caE() {
        if (this.hrr == null || !this.hrr.Ke().LY()) {
            return false;
        }
        nN(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean caF() {
        return this.hqg == null || this.hqg.caF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    /* renamed from: ccm */
    public PendantParentView caG() {
        return this.byA;
    }

    public ViewGroup ccn() {
        return this.htk;
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
                    this.hsf = false;
                    P(intExtra, intExtra2, intExtra3);
                    return;
                }
                caw();
                return;
            }
            awo();
        } else if (i == 25051 && i2 == -1 && this.hsq != null) {
            this.hsq.cfg();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.hrr != null && this.hrr.Kd() != null) {
            this.hrr.Kd().onKeyboardVisibilityChanged(z);
        }
        if (z || this.hrr == null || this.hrr.Ke() == null || !this.hrr.Ke().LY()) {
            if (z) {
                if (this.hrb != null) {
                    this.hrb.setVisibility(8);
                }
                if (this.hrt != null && this.hrt.EJ() != null) {
                    this.hrt.EJ().setVisibility(8);
                }
                caI();
                if (this.hrr != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hrr.Ke().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.hrr.Ke().getView().setLayoutParams(layoutParams);
                    this.hrr.Ke().getView().setVisibility(0);
                    this.hrr.Ke().setQuickInputPanelVisible(false);
                    this.hrr.Kf().cw(false);
                }
                if (this.hsa != null) {
                    this.hsa.setVisibility(8);
                }
                if (this.hql != null) {
                    this.hql.setVisible(8);
                }
                if (this.hrs != null) {
                    this.hrs.zQ();
                }
                if (this.hrT != null) {
                    this.hrT.setCanVisible(false);
                }
                if (this.hrJ != null) {
                    this.hrJ.setCanVisible(false);
                }
                if (this.hrL != null) {
                    this.hrL.setCanVisible(false);
                }
                if (this.hrM != null) {
                    this.hrM.setCanVisible(false);
                }
                if (this.hrN != null) {
                    this.hrN.setCanVisible(false);
                }
                if (this.hrO != null) {
                    this.hrO.setVisible(8);
                }
                if (this.hti != null) {
                    this.hti.setCanVisible(false);
                }
                if (this.hrP != null) {
                    this.hrP.setCanVisible(false);
                }
                if (ccn() != null) {
                    ccn().setVisibility(8);
                }
            } else {
                caH();
            }
            if (this.hrF != null) {
                this.hrF.bC(z);
            }
            ccb();
        }
    }

    private void caH() {
        if (this.hrb != null) {
            this.hrb.setVisibility(0);
        }
        if (this.hqt != null) {
            if (this.hto) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqt.getLayoutParams();
                layoutParams.bottomMargin = (O(false, false) - cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) + com.baidu.live.aj.c.Vj();
                this.hqt.setLayoutParams(layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hqt.getLayoutParams();
                layoutParams2.bottomMargin = cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds90);
                this.hqt.setLayoutParams(layoutParams2);
            }
        }
        if (this.hrr != null) {
            cbc();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hrr.Ke().getView().getLayoutParams();
            layoutParams3.bottomMargin = 0;
            this.hrr.Ke().getView().setLayoutParams(layoutParams3);
            if (this.aMG) {
                if (this.hrr.Kf().isClicked()) {
                    this.hrr.Kf().cw(false);
                } else {
                    this.hrr.Kf().cw(true);
                }
            } else {
                this.hrr.Kf().cw(false);
            }
        }
        if (this.hrb != null) {
            this.hrb.setVisibility(0);
        }
        if (this.hrt != null && this.hrt.EJ() != null) {
            this.hrt.EJ().setVisibility(0);
        }
        if (this.hsa != null) {
            this.hsa.setVisibility(0);
        }
        if (this.hql != null) {
            this.hql.setVisible(0);
        }
        if (this.hrs != null) {
            this.hrs.zQ();
        }
        if (this.hrT != null) {
            this.hrT.setCanVisible(true);
        }
        if (this.hrJ != null) {
            this.hrJ.setCanVisible(true);
        }
        if (this.hrN != null) {
            this.hrN.setCanVisible(true);
        }
        if (this.hrO != null) {
            this.hrO.setVisible(0);
        }
        if (this.hrL != null) {
            this.hrL.setCanVisible(!this.gQr);
        }
        if (this.hrM != null) {
            this.hrM.setCanVisible(true);
        }
        if (this.hti != null) {
            this.hti.setCanVisible(true);
        }
        if (this.hrP != null) {
            this.hrP.setCanVisible(true);
        }
        if (ccn() != null) {
            ccn().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caI() {
        boolean z;
        boolean z2;
        if (this.hqt != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqt.getLayoutParams();
            if (this.hrr == null || this.hrr.Ke() == null) {
                z = false;
                z2 = false;
            } else {
                boolean LW = this.hrr.Ke().LW();
                z = this.hrr.Ke().LX();
                z2 = LW;
            }
            int O = O(z2, z);
            if (layoutParams.bottomMargin != O) {
                layoutParams.bottomMargin = O;
                this.hqt.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nN(boolean z) {
        this.htn = z;
        if (z) {
            this.hrr.Ke().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqt.getLayoutParams();
            int quickInputPanelExpandHeight = this.hrr.Ke().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.hqt.setLayoutParams(layoutParams);
                if (this.hrr.Kd() != null) {
                    this.hrr.Kd().Kc();
                    return;
                }
                return;
            }
            return;
        }
        caH();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.hqf != null) {
                this.hqf.cr(i3);
            }
            if (this.hqh != null) {
                this.hqh.cr(i3);
            }
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public boolean dF(int i) {
        boolean dF = super.dF(i);
        if (dF && 2 == i) {
            if (this.hqg.caF()) {
                return false;
            }
            if (dF && this.hrm != null) {
                this.hrm.oS(false);
            }
        }
        return dF;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void vo(int i) {
        super.vo(i);
        if (i == 7 || i == 11) {
            if (this.hrb != null) {
                this.hrb.setVisibility(8);
            }
            if (this.hrr != null) {
                this.hrr.Kd().getView().setVisibility(4);
                this.hrr.Kf().getView().setVisibility(4);
            }
            if (this.hql != null) {
                this.hql.bM(2, 8);
                if (this.gQr) {
                    this.hql.bM(1, 8);
                }
            }
            if (this.hrG != null) {
                this.hrG.oM(false);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public void dG(int i) {
        super.dG(i);
        if (i == 7 || i == 11) {
            if (this.hrb != null) {
                this.hrb.setVisibility(0);
            }
            if (this.hrr != null) {
                this.hrr.Kd().getView().setVisibility(0);
                if (this.aMG && !this.hrr.Kf().isClicked()) {
                    this.hrr.Kf().cw(true);
                }
            }
            if (this.hql != null) {
                this.hql.setVisible(0);
            }
            if (this.hrG != null) {
                this.hrG.oM(true);
            }
            this.hsa.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.hqi != null) {
            this.hqi.ckm();
        }
        if (this.hqn != null) {
            this.hqn.AA();
        }
        if (this.hql != null) {
            this.hql.onStop();
        }
        if (this.hqm != null) {
            this.hqm.bm(true);
        }
        if (this.hrY != null) {
            this.hrY.onStopped();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.hqi != null) {
            this.hqi.ckl();
        }
        if (this.hqn != null && this.hth) {
            this.hqn.AB();
        }
        if (this.hql != null) {
            this.hql.onStart();
        }
        if (this.hqm != null) {
            this.hqm.bm(false);
        }
        if (this.hrY != null) {
            this.hrY.onStarted();
        }
        if (this.hti != null) {
            this.hti.onStart();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        if (!onKeyDown && i == 4 && this.hrY != null && this.hrY.onKeyDown(i, keyEvent)) {
            return true;
        }
        return onKeyDown;
    }
}
