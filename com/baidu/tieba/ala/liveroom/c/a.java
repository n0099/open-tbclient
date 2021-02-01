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
    private ah hqB;
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
    private com.baidu.live.im.b.a hqq;
    private com.baidu.tieba.ala.liveroom.share.b hqr;
    private com.baidu.live.ad.a hqs;
    private FrameLayout hqt;
    private FrameLayout hqu;
    private ImageView hqv;
    private com.baidu.live.tieba.e.b hqw;
    private long lastClickTime = 0;
    private boolean hqx = false;
    private boolean hqy = false;
    private boolean hqz = false;
    private Handler hqA = new Handler();
    private HttpRule hqD = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.hqn != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.hqn.AG()) {
                httpMessage.addParam("ala_challenge_id", a.this.hqn.AJ());
            }
            return httpMessage;
        }
    };
    private HttpRule hqE = new HttpRule(1021229) { // from class: com.baidu.tieba.ala.liveroom.c.a.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.hqn != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.hqn.AG()) {
                httpMessage.addParam("challenge_id", a.this.hqn.AJ());
            }
            return httpMessage;
        }
    };
    private HttpRule hqF = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.c.a.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.hqn != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.hqn.AG()) {
                httpMessage.addParam("challenge_id", a.this.hqn.AJ());
            }
            return httpMessage;
        }
    };
    private HttpRule hqG = new HttpRule(1021232) { // from class: com.baidu.tieba.ala.liveroom.c.a.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.hqn != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.hqn.AG()) {
                httpMessage.addParam("challenge_id", a.this.hqn.AJ());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c hqH = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.c.a.23
        @Override // com.baidu.live.liveroom.g.c
        public void Nd() {
            if (a.this.hrm != null) {
                a.this.hrm.oS(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cI(boolean z) {
            if (z) {
                if (a.this.hrm != null) {
                    a.this.hrm.oS(true);
                }
            } else if (a.this.hrm != null) {
                a.this.hrm.oS(false);
            }
            if (a.this.hrF != null) {
                a.this.hrF.bD(z);
            }
            if (a.this.hql != null) {
                a.this.hql.nJ(z ? false : true);
            }
            com.baidu.live.p.a.cJ(z);
        }
    };
    private com.baidu.tieba.ala.liveroom.m.c hqI = new com.baidu.tieba.ala.liveroom.m.c() { // from class: com.baidu.tieba.ala.liveroom.c.a.24
        @Override // com.baidu.tieba.ala.liveroom.m.c
        public void onClick() {
            a.this.hqA.removeCallbacksAndMessages(null);
            a.this.hqx = true;
        }

        @Override // com.baidu.tieba.ala.liveroom.m.c
        public void endAnimation() {
            if (a.this.hqx) {
                a.this.bZW();
            }
        }
    };
    private CustomMessageListener hqJ = new CustomMessageListener(2913287) { // from class: com.baidu.tieba.ala.liveroom.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hqw != null) {
                a.this.hqw.dh(false);
                a.this.hqw.Ub();
            }
        }
    };
    private CustomMessageListener hqK = new CustomMessageListener(2913290) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hqw != null) {
                a.this.hqw.dh(true);
            }
        }
    };
    private HttpMessageListener hqL = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Ow() != null) {
                        com.baidu.live.ae.e.Qz().bBd = getQuickGiftHttpResponseMessage.Ow();
                        a.this.cam();
                    }
                }
            }
        }
    };
    private CustomMessageListener hqM = new CustomMessageListener(2913276) { // from class: com.baidu.tieba.ala.liveroom.c.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            JSONObject optJSONObject;
            JSONArray optJSONArray;
            if (a.this.mOrientation == 1 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject) && (optJSONObject = ((JSONObject) customResponsedMessage.getData()).optJSONObject("ext_data")) != null && (optJSONArray = optJSONObject.optJSONArray("surprise_prize_member")) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                View inflate = LayoutInflater.from(a.this.activity).inflate(a.g.ala_fudai_dialog_layout, (ViewGroup) null);
                final Dialog dialog = new Dialog(a.this.cbI().pageContext.getPageActivity(), a.i.FudaiDialogStyle);
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
    private CustomMessageListener hqN = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.c.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                a.this.hru.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener hqO = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.c.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.hsh != null && a.this.hsh.biY != null && !a.this.hsh.bjd && !a.this.hsh.bje && a.this.hrE != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.cbI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                if (a.this.hrr != null && a.this.hrr.Kf().Ml()) {
                    layoutParams.bottomMargin = a.this.cbI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds88);
                } else {
                    layoutParams.bottomMargin = a.this.cbI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                }
                a.this.hrE.c(a.this.hqt, layoutParams);
                if (com.baidu.live.guardclub.e.IS() != null) {
                    com.baidu.live.guardclub.e.IS().IX();
                }
            }
        }
    };
    private CustomMessageListener hqP = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.a.9
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
                        a.this.caZ();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener hqQ = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.c.a.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.hqC.c(a.this.cbI());
                } else if (a.this.caU() || !g.vB(2913168)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.cbI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.cbI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    a.this.hqC.c(a.this.hqt, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b hqR = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.a.15
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
                        if (a.this.cbI().hBt.Fm() != null && a.this.cbI().hBt.Fm().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.cbI().hBt.Fm().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.cbI().hBt.Fm().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.Lo());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.HZ()) {
                        if (com.baidu.live.d.xc().getBoolean("quick_gift_guide_show", true) && !a.this.caU()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, ah.class, a.this.cbI().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                ah ahVar = (ah) runTask.getData();
                                ahVar.setPageContext(a.this.cbI().pageContext);
                                ahVar.setLiveShowData(a.this.cbI().hBt.Fm());
                                ahVar.setGiftItem(com.baidu.live.ae.e.Qz().bBd.ES());
                                ahVar.setOtherParams(a.this.Lo());
                                ahVar.initView();
                                ahVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.15.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        a.this.nP(false);
                                        a.this.hqB = null;
                                    }
                                });
                                a.this.hqB = ahVar;
                                ahVar.show();
                                a.this.nP(true);
                                return;
                            }
                            return;
                        }
                        n.a(a.this.cbI().pageContext, a.this.cbI().hBt.Fm(), com.baidu.live.ae.e.Qz().bBd.ES(), a.this.Lo());
                    }
                } else if (i == 1) {
                    if (a.this.hrr != null) {
                        a.this.caZ();
                    }
                } else if (i == 3 && a.this.HZ()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    if (a.this.mOrientation == 2 && (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                        if (a.this.hqr != null) {
                            a.this.hqr.U(a.this.cbI().hBt.Fm());
                        }
                    } else {
                        a.this.hre.d(a.this.cbI().hBt.Fm(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.cbI() != null && a.this.cbI().hBt != null && a.this.cbI().hBt.Fm() != null && a.this.cbI().hBt.Fm().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.cbI().hBt.Fm().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.cbI().hBt.Fm().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.cbI().hBt.Fm().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.Lo());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.cbI() != null && a.this.cbI().hBt != null && a.this.cbI().hBt.Fm() != null && a.this.cbI().hBt.Fm().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.cbI().hBt.Fm().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.cbI().hBt.Fm().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.cbI().hBt.Fm().mLiveInfo.feed_id + "");
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
                    if (a.this.hrm != null) {
                        String valueOf = String.valueOf(a.this.cbI().hBt.Fm().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.cbI().hBt.Fm().mLiveInfo.room_id);
                        String str3 = null;
                        AlaLiveSdkInfo alaLiveSdkInfo = a.this.cbI().hBt.Fm().mLiveSdkInfo;
                        if (alaLiveSdkInfo != null && alaLiveSdkInfo.mCastIds != null) {
                            str3 = String.valueOf(a.this.cbI().hBt.Fm().mLiveSdkInfo.mCastIds.chatMCastId);
                        }
                        a.this.hrm.ax(valueOf, valueOf2, str3);
                        com.baidu.live.p.a.c(a.this.cbI().hBt.Fm().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    ab Fm = a.this.cbI().hBt.Fm();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.cbI().pageContext.getPageActivity(), Fm.aId.userName, Long.toString(Fm.aId.userId), Long.toString(Fm.aId.charmCount), String.valueOf(Fm.mLiveInfo.group_id), String.valueOf(Fm.mLiveInfo.live_id), false, String.valueOf(Fm.aId.userId), Long.toString(Fm.aIz.userId), Fm.aIz.userName, Fm.aIz.portrait, a.this.hqj.getCount(), a.this.Lo())));
                    LogManager.getCommonLogger().doClickGusetNumLog(Fm.mLiveInfo.feed_id, a.this.hqj.getCount() + "", a.this.Lo());
                } else if (i == 11) {
                    a.this.cbe();
                    a.this.cbf();
                } else if (i == 16) {
                    if (a.this.cbI() != null && (bvVar2 = com.baidu.live.ae.a.Qj().bAS) != null && (coVar = bvVar2.aPM) != null) {
                        String str4 = coVar.aRu.aRD;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (a.this.cbI().hBt != null && a.this.cbI().hBt.Fm() != null && a.this.cbI().hBt.Fm().mLiveInfo != null) {
                                j = a.this.cbI().hBt.Fm().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", a.this.cbI().hBt.Fm().mLiveInfo.room_id + "", a.this.cbI().hBt.Fm().mLiveInfo.feed_id, a.this.Lo());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.cbI().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (a.this.cbI() != null) {
                        ab abVar = null;
                        if (a.this.cbI().hBt != null) {
                            abVar = a.this.cbI().hBt.Fm();
                        }
                        if (abVar != null && abVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.u.b.ckx().bvg != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.u.b.ckx().bvg.aHq;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + abVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + abVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(a.this.cbI().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17) {
                    if (a.this.HZ() && a.this.cbI() != null && (bvVar = com.baidu.live.ae.a.Qj().bAS) != null && bvVar.aPM != null) {
                        String str6 = bvVar.aPM.aRA;
                        if (!TextUtils.isEmpty(str6)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                            if (a.this.cbI().hBt != null && a.this.cbI().hBt.Fm() != null) {
                                if (a.this.hrG == null) {
                                    a.this.hrG = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.cbI().pageContext.getPageActivity());
                                }
                                ab Fm2 = a.this.cbI().hBt.Fm();
                                String b2 = a.this.hrG.b(str6, Fm2.mLiveInfo.live_id, Fm2.aIz.userId, Fm2.aId.userId);
                                com.baidu.live.an.c cVar = new com.baidu.live.an.c();
                                cVar.url = b2;
                                a.this.bgE.a(cVar, new com.baidu.live.an.b() { // from class: com.baidu.tieba.ala.liveroom.c.a.15.2
                                    @Override // com.baidu.live.an.b
                                    public void onShow() {
                                        a.this.hqw.dh(false);
                                        a.this.hqw.Ub();
                                    }

                                    @Override // com.baidu.live.an.b
                                    public void onDismiss() {
                                        a.this.hqw.dh(true);
                                    }
                                });
                            }
                        }
                    }
                } else if (i == 18) {
                    if (a.this.hqz) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.hqz = !a.this.hqz;
                } else if (i == 19 && a.this.hqw != null) {
                    a.this.hqw.Ub();
                }
            }
        }
    };

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
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZW() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.25
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.hqy) {
                    a.this.nK(false);
                }
            }
        }, 5000L);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void m(ab abVar) {
        super.m(abVar);
        g.cfl();
        this.hqz = false;
        if (this.hrj != null) {
            this.hrj.b(this.hqR);
        }
        if (this.hqw == null) {
            this.hqw = new com.baidu.live.tieba.e.b(cbI().pageContext.getPageActivity());
            this.hqw.start();
        }
        this.hqw.dh(true);
        cbI().pageContext.getPageActivity().setRequestedOrientation(-1);
        cbI().hBu.setIsForceHandledTouch(false);
        cbI().hBu.setSwipeClearEnable(true);
        cbI().hBu.setOnLiveViewScrollListener(this.hqH);
        cbI().hBu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hqA.removeCallbacksAndMessages(null);
                a.this.hqx = false;
                a.this.nK(false);
                if (!a.this.hqy) {
                    a.this.bZW();
                }
            }
        });
        if (this.hsa != null) {
            this.hsa.setVisibility(0);
        }
        cae();
        if (this.hrC != null) {
            this.hrC.a(abVar, this.byA);
            this.hrC.U(this.hsb);
            this.hrC.a(this);
        }
        cbp();
        caq();
        caQ();
        caP();
        car();
        cab();
        cav();
        cas();
        bZX();
        nQ(false);
        cax();
        cbo();
        cbw();
        cbi();
        cbn();
        can();
        cao();
        cbh();
        cap();
        cbj();
        bZZ();
        cay();
        nS(true);
        cbq();
        cag();
        cam();
        cbA();
        cah();
        cai();
        caj();
        cak();
        cac();
        caA();
        caz();
        bZY();
        cbz();
        cbv();
        cad();
        c(this.grr);
        MessageManager.getInstance().registerListener(this.hqL);
        MessageManager.getInstance().registerListener(this.hqO);
        MessageManager.getInstance().registerListener(this.hqP);
        MessageManager.getInstance().registerListener(this.hqQ);
        MessageManager.getInstance().registerListener(this.hqN);
        MessageManager.getInstance().registerListener(this.hqM);
        MessageManager.getInstance().registerListener(this.hqJ);
        MessageManager.getInstance().registerListener(this.hqK);
        caB();
        cau();
        if (this.mOrientation == 2) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(cbI().pageContext.getPageActivity());
            l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(cbI().pageContext.getPageActivity()));
        }
        if (this.hrR != null) {
            this.hrR.L(abVar);
        }
        cbl();
    }

    private void bZX() {
        if (this.hrR == null) {
            View view = null;
            if (this.hrj != null && this.hrj.getView() != null) {
                view = this.hrj.getView();
            }
            this.hrR = new com.baidu.tieba.ala.liveroom.exclusive.b(cbI().pageContext, MZ(), cbI().hBu, view, this.hqf.htJ, this);
        }
    }

    private void bZY() {
        if (this.hrQ != null) {
            this.hrQ.a(new com.baidu.live.y.c() { // from class: com.baidu.tieba.ala.liveroom.c.a.27
                @Override // com.baidu.live.y.c
                public void cP(boolean z) {
                    if (a.this.hqo != null) {
                        a.this.hqo.setNeedCloseRecommendFloat(z);
                    }
                    if (a.this.cbI().hBu.hRi) {
                        if (a.this.hrm != null) {
                            a.this.hrm.oK(z);
                            a.this.hrm.oS(!z);
                        }
                        if (a.this.hrj != null) {
                            a.this.hrj.oK(z);
                            a.this.hrj.setPraiseEnable(!z);
                            a.this.hrj.oJ(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nK(boolean z) {
        View Fl;
        if (cbI() != null && cbI().pageContext != null && cbI().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(cbI().pageContext.getPageActivity()) == 2 || z) {
                if (this.hru != null && (Fl = this.hru.Fl()) != null) {
                    if (this.hqy) {
                        Fl.setVisibility(0);
                    } else {
                        Fl.setVisibility(8);
                    }
                }
                if (this.hqy) {
                    if (this.hsa != null) {
                        this.hsa.setVisibility(0);
                    }
                    if (this.hsb != null) {
                        this.hsb.setVisibility(0);
                    }
                    if (this.byA != null) {
                        this.byA.setVisibility(0);
                    }
                    if (this.byA != null) {
                        this.byA.setVisibility(0);
                    }
                    if (this.hrt != null) {
                        this.hrt.bB(false);
                    }
                } else {
                    if (this.hsa != null) {
                        this.hsa.setVisibility(8);
                    }
                    if (this.hsb != null) {
                        this.hsb.setVisibility(8);
                    }
                    if (this.byA != null) {
                        this.byA.setVisibility(8);
                    }
                    if (this.byA != null) {
                        this.byA.setVisibility(8);
                    }
                    if (this.hrt != null) {
                        this.hrt.bB(true);
                    }
                }
                this.hqy = this.hqy ? false : true;
                if (this.hql != null) {
                    this.hql.nJ(this.hqy);
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
            if (this.hqu != null) {
                this.hqu.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.e.icon_live_barrage_on);
            }
            if (this.hqu != null) {
                this.hqu.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.hrt != null && (EJ = this.hrt.EJ()) != null) {
            if (z) {
                EJ.setVisibility(8);
            } else {
                EJ.setVisibility(0);
            }
        }
    }

    private void bZZ() {
        CustomResponsedMessage runTask;
        if (this.hqq == null && (runTask = MessageManager.getInstance().runTask(2913164, com.baidu.live.im.b.a.class, cbI().pageContext)) != null) {
            this.hqq = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hqq != null) {
            this.hqq.setOtherParams(this.otherParams);
            this.hqq.a(new a.InterfaceC0179a() { // from class: com.baidu.tieba.ala.liveroom.c.a.2
                @Override // com.baidu.live.im.b.a.InterfaceC0179a
                public void KM() {
                    a.this.cbt();
                }
            });
        }
    }

    private void caa() {
        if (this.hrl != null) {
            this.hrl.aJ(cbI().hBs.getLiveContainerView());
        }
    }

    private void cab() {
        if (this.hqr == null) {
            this.hqr = new com.baidu.tieba.ala.liveroom.share.b(cbI().pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void cac() {
        if (cbI() != null) {
            if (this.hqs == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.ad.a.class, cbI().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hqs = (com.baidu.live.ad.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hqs.setIsHost(false);
            this.hqs.a(this.byA, cbI().hBt.Fm().aJc);
        }
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
            this.hrM.setIsHorizontal(true);
            this.hrM.setIsHost(false);
            this.hrM.a(caG(), cbI().hBt.Fm());
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cv(int i) {
        super.cv(i);
        if (this.hqv != null && UtilHelper.getRealScreenOrientation(cbI().pageContext.getPageActivity()) != 2) {
            this.hqv.setVisibility(0);
        }
        caa();
        if (this.hqo != null) {
            this.hqo.cv(i);
        }
        if (this.hqo == null || !this.hqo.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
        if (this.hrR != null) {
            this.hrR.ceJ();
        }
    }

    private void cae() {
        if (this.byA == null) {
            PendantParentView.Model model = PendantParentView.Model.HORIZONTAL;
            if (this.mOrientation == 2) {
                model = PendantParentView.Model.HORIZONTAL_FULL;
            }
            this.byA = new PendantParentView(cbI().pageContext.getPageActivity(), model);
            cbI().hBu.addView(this.byA, ((cbI().hBu.getView() == null || this.hrj == null || this.hrj.getView() == null) ? -1 : cbI().hBu.getView().indexOfChild(this.hrj.getView())) + 1, new RelativeLayout.LayoutParams(-1, caf()));
            this.byA.setDefaultItemMargin(cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            K(this.mOrientation, false);
        }
    }

    private int caf() {
        int bottom;
        int bottom2;
        if (cbI().brO.getLivePlayer().getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) cbI().brO.getLivePlayer().getLayoutParams();
            bottom = layoutParams.topMargin + layoutParams.height;
        } else {
            bottom = cbI().brO.getLivePlayer().getBottom();
        }
        if (cbI().hBu.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) cbI().hBu.getLayoutParams();
            bottom2 = layoutParams2.topMargin + layoutParams2.height;
        } else {
            bottom2 = cbI().hBu.getBottom();
        }
        int i = 0;
        if (this.hrR != null) {
            i = this.hrR.getHeight();
        }
        return (((bottom2 - bottom) - i) - cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
    }

    private void cag() {
        if (this.hql == null) {
            this.hql = new com.baidu.tieba.ala.liveroom.activeview.b(cbI().pageContext);
        }
        if (cbI() != null && cbI().hBt != null) {
            this.hql.Hs(cbI().hBt.cjD());
        }
        this.hql.setOtherParams(Lo());
        this.hql.c(cbI().hBt.Fm(), true);
        this.hql.setHost(false);
        this.hql.a(1, this.byA);
        this.hql.a(2, this.byA);
        this.hql.setVisible(this.hse ? 8 : 0);
    }

    private void cah() {
        if (this.byA != null) {
            if (this.hqk == null) {
                this.hqk = new com.baidu.tieba.ala.liveroom.k.a(cbI().pageContext, this);
            }
            this.hqk.setOtherParams(Lo());
            this.hqk.a((ViewGroup) this.byA, cal());
            this.hqk.M(cbI().hBt.Fm());
        }
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
            this.hrb.a(new a.InterfaceC0670a() { // from class: com.baidu.tieba.ala.liveroom.c.a.11
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0670a
                public void bO(int i, int i2) {
                    ab Fm = a.this.cbI().hBt.Fm();
                    if (Fm != null && Fm.mLiveInfo != null) {
                        if (a.this.hrG == null) {
                            a.this.hrG = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.cbI().pageContext.getPageActivity());
                        }
                        a.this.hrG.d(a.this.hsb, i, i2);
                        a.this.hrG.a(String.valueOf(Fm.mLiveInfo.live_id), new a.InterfaceC0674a() { // from class: com.baidu.tieba.ala.liveroom.c.a.11.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0674a
                            public void a(float f, String str) {
                                if (a.this.hrb != null) {
                                    a.this.hrb.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0670a
                public void bP(int i, int i2) {
                    if (a.this.hrG != null) {
                        a.this.hrG.bU(i, i2);
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
            this.hqC = new com.baidu.tieba.ala.liveroom.i.b(cbI().pageContext, Lo(), this.hsq, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.13
                @Override // com.baidu.tieba.ala.liveroom.i.b.a
                public void caJ() {
                    a.this.nP(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.i.b.a
                public void caK() {
                    a.this.nP(false);
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

    private LinearLayout.LayoutParams cal() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = cbI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cam() {
        if (this.hrb == null) {
            cas();
        }
        this.hrb.a(com.baidu.live.ae.e.Qz().bBd, cbI().hBt.Fm());
    }

    private void can() {
        CustomResponsedMessage runTask;
        boolean z = true;
        if (this.hrr == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, cbI().pageContext)) != null && runTask.getData() != null) {
            this.hrr = (k) runTask.getData();
            this.hrr.setFromMaster(false);
            this.hrr.Kd().getView().setId(a.f.ala_liveroom_msg_list);
            this.hrr.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.14
                @Override // com.baidu.live.im.k.a
                public boolean Kh() {
                    return a.this.HZ();
                }

                @Override // com.baidu.live.im.k.a
                public void Ki() {
                    a.this.hsi = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hb(String str) {
                    if (!a.this.hse) {
                        a.this.nN(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.cbI().pageContext.getPageActivity(), a.this.cbI().hBs.getLiveContainerView());
                    }
                    a.this.Hz(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Kj() {
                    if (a.this.hse) {
                        a.this.nN(true);
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.cbI().pageContext.getPageActivity(), a.this.cbI().hBs.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (a.this.hrr != null) {
                        a.this.hrr.Ke().setQuickInputPanelVisible(false);
                        a.this.hrr.Ke().LZ();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Kk() {
                }

                @Override // com.baidu.live.im.k.a
                public void Kl() {
                    if (a.this.hse) {
                        a.this.caI();
                        if (a.this.hrs != null) {
                            a.this.hrs.zQ();
                        }
                        if (a.this.hqq != null) {
                            a.this.hqq.zQ();
                        }
                    } else if (a.this.hrr != null) {
                        a.this.hrr.Ke().setQuickInputPanelVisible(false);
                        a.this.hrr.Ke().LZ();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Km() {
                    return a.this.caV();
                }

                @Override // com.baidu.live.im.k.a
                public int Kn() {
                    return a.this.caW();
                }

                @Override // com.baidu.live.im.k.a
                public boolean Ko() {
                    ab Fm = a.this.cbI().hBt.Fm();
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
            int j = com.baidu.live.aj.c.j(true, false);
            if (this.hsb.indexOfChild(this.hqt) < 0) {
                if (this.hqt.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hqt.getParent()).removeView(this.hqt);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, j);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
                this.hsb.addView(this.hqt, layoutParams);
            }
            if (this.hqt.indexOfChild(this.hrr.Kd().getView()) < 0) {
                if (this.hrr.Kd().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hrr.Kd().getView()).removeView(this.hrr.Kd().getView());
                }
                if (UtilHelper.getRealScreenOrientation(cbI().pageContext.getPageActivity()) != 2) {
                    this.hqt.addView(this.hrr.Kd().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, j));
                }
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
            if (Fm == null || Fm.aIR == null || !Fm.aIR.Bf()) {
                z = false;
            }
            this.hrr.a(String.valueOf(cbI().hBt.Fm().mLiveInfo.group_id), String.valueOf(cbI().hBt.Fm().mLiveInfo.last_msg_id), String.valueOf(cbI().hBt.Fm().aId.userId), String.valueOf(cbI().hBt.Fm().mLiveInfo.live_id), cbI().hBt.Fm().aId.appId, z, cbI().hBt.Fm().getGuardName());
            nN(false);
        }
    }

    private void cao() {
        cba();
    }

    private void cap() {
        if (this.hqu == null) {
            this.hqu = new FrameLayout(cbI().pageContext.getPageActivity());
            this.hqu.setId(a.f.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void caq() {
        if (this.hqg == null) {
            this.hqg = new com.baidu.tieba.ala.liveroom.m.a(cbI().pageContext, false, this);
        }
        this.hqg.e(this.hsa, cbI().hBt.Fm());
        this.hqg.a(this.hqI);
        this.hqg.a(this.hqR);
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

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void cat() {
        cau();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void nL(boolean z) {
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

    private void cay() {
        boolean z = false;
        if (this.hrm == null) {
            this.hrm = new com.baidu.tieba.ala.liveroom.v.a(cbI().pageContext, this);
        }
        this.hrm.c(cbI().hBu, false);
        boolean cbH = cbH();
        AlaLiveInfoData alaLiveInfoData = cbI().hBt.Fm().mLiveInfo;
        boolean isZanAnimUnabled = (alaLiveInfoData == null || alaLiveInfoData.mAlaLiveSwitchData == null) ? false : alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled();
        if (cbH && !isZanAnimUnabled) {
            z = true;
        }
        this.hrm.oR(z);
    }

    private void caz() {
        if (cbI() != null && cbI().brO != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(cbI().pageContext.getPageActivity());
            Activity pageActivity = cbI().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + p.br(pageActivity)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.hqv = new ImageView(cbI().pageContext.getPageActivity());
            this.hqv.setVisibility(8);
            this.hqv.setBackgroundResource(a.e.sdk_round_btn_close_bg);
            this.hqv.setImageResource(a.e.icon_live_enlarge);
            this.hqv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hqw != null) {
                        a.this.hqw.Ua();
                        a.this.hqv.setVisibility(4);
                        a.this.hrr.Kf().cw(false);
                    }
                }
            });
            cbI().hBu.addView(this.hqv, layoutParams);
            if (UtilHelper.getRealScreenOrientation(cbI().pageContext.getPageActivity()) != 2) {
                if (cbI().hBA) {
                    this.hqv.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.17
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.hqv != null && UtilHelper.getRealScreenOrientation(a.this.cbI().pageContext.getPageActivity()) != 2) {
                                a.this.hqv.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
        }
    }

    private void caA() {
        if (this.hrZ == null) {
            this.hrZ = new com.baidu.tieba.ala.liveroom.apppromotion.a(cbI().pageContext);
        }
        this.hrZ.b(caG(), cbI().hBt.Fm());
    }

    private void caB() {
        if (this.hsi || this.hsj) {
            if ((TbadkCoreApplication.isLogin() && this.hrr.Ke().hasText()) || this.hsj) {
                this.hsi = false;
                this.hsj = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.18
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.caZ();
                    }
                }, 500L);
            }
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
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (this.hqs == null || !this.hqs.Z(jSONObject)) {
            if ((bVar.getMsgType() == 12 || bVar.getMsgType() == 13) && jSONObject != null) {
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
                } else if ("challenge_mvp".equals(optString) && cbI().hBt.Fm() != null && cbI().hBt.Fm().mLiveInfo != null && cbI().hBt.Fm().aIz != null && this.hqo != null) {
                    long optLong = jSONObject.optLong("mvp_user_id");
                    long optLong2 = jSONObject.optLong("winner_live_id");
                    if (optLong == cbI().hBt.Fm().aIz.userId && optLong2 == cbI().hBt.Fm().mLiveInfo.live_id) {
                        this.hqo.g(jSONObject.optInt("challenge_status"), jSONObject.optLong("challenge_id"));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void Hu(String str) {
        if (this.hql != null) {
            this.hql.Hu(str);
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
        if (this.hqq != null) {
            this.hqq.a(abVar);
        }
        if (this.hql != null) {
            this.hql.j(abVar);
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
        if (this.hqs != null) {
            this.hqs.xh();
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
        if (this.hqn != null) {
            this.hqn.Ar();
        }
        if (this.hqq != null) {
            this.hqq.a((a.InterfaceC0179a) null);
            this.hqq.zR();
        }
        if (this.hqg != null) {
            this.hqg.cgj();
        }
        if (this.hqv != null && (this.hqv.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hqv.getParent()).removeView(this.hqv);
        }
        if (this.hqr != null) {
            this.hqr.dismiss();
        }
        if (this.hqw != null) {
            this.hqw.dh(false);
            this.hqw.Ub();
        }
        if (this.hqC != null) {
            this.hqC.Ar();
        }
        if (this.hsq != null) {
            this.hsq.cdg();
        }
        if (this.hrU != null) {
            this.hrU.Ar();
        }
        if (this.hrZ != null) {
            this.hrZ.xh();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void n(ab abVar) {
        View zP;
        super.n(abVar);
        if (this.hqq != null && (zP = this.hqq.zP()) != null && zP.getParent() != null) {
            ((ViewGroup) zP.getParent()).removeView(zP);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.hqq != null) {
            this.hqq.setOtherParams(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cF(boolean z) {
        super.cF(z);
        this.hqA.removeCallbacksAndMessages(null);
        caC();
        this.hqy = false;
        this.hqz = false;
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
        if (this.hqr != null) {
            this.hqr.onDestroy();
        }
        if (this.hqh != null) {
            this.hqh.onDestroy();
        }
        if (this.hqw != null) {
            this.hqw.stop();
        }
        if (this.hrm != null) {
            this.hrm.onDestroy();
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
        if (this.hqq != null) {
            this.hqq.a((a.InterfaceC0179a) null);
            this.hqq.release();
            this.hqq = null;
        }
        if (this.hsq != null) {
            this.hsq.cF(z ? false : true);
        }
        if (this.hqC != null) {
            this.hqC.onDestroy();
            this.hqC = null;
        }
        if (this.hrU != null) {
            this.hrU.onDestroy();
        }
        if (this.hqs != null) {
            this.hqs.onDestroy();
        }
        if (this.hrZ != null) {
            this.hrZ.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.hqE);
        MessageManager.getInstance().removeMessageRule(this.hqD);
        MessageManager.getInstance().removeMessageRule(this.hqF);
        MessageManager.getInstance().removeMessageRule(this.hqG);
        MessageManager.getInstance().unRegisterListener(this.hqL);
        MessageManager.getInstance().unRegisterListener(this.hqO);
        MessageManager.getInstance().unRegisterListener(this.hqP);
        MessageManager.getInstance().unRegisterListener(this.hqQ);
        MessageManager.getInstance().unRegisterListener(this.hqN);
        MessageManager.getInstance().unRegisterListener(this.hqM);
        MessageManager.getInstance().unRegisterListener(this.hqJ);
        MessageManager.getInstance().unRegisterListener(this.hqK);
    }

    private void caC() {
        if (this.hrr != null && this.hrr.Kd().getView() != null && this.hrr.Kd().getView().getParent() != null) {
            ((ViewGroup) this.hrr.Kd().getView().getParent()).removeView(this.hrr.Kd().getView());
        }
        if (this.hqt != null && this.hqt.getParent() != null) {
            ((ViewGroup) this.hqt.getParent()).removeView(this.hqt);
        }
        if (this.hqu != null && this.hqu.getParent() != null) {
            ((ViewGroup) this.hqu.getParent()).removeView(this.hqu);
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

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup caG() {
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
                    this.hsf = false;
                    P(intExtra, intExtra2, intExtra3);
                    return;
                }
                caw();
                return;
            }
            awo();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.hse;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(cbI().pageContext.getPageActivity()) || z2) {
            nM(z);
        }
    }

    private void nM(boolean z) {
        if (this.hrr != null && this.hrr.Kd() != null) {
            this.hrr.Kd().onKeyboardVisibilityChanged(z);
        }
        if (z || this.hrr == null || !this.hrr.Ke().LY()) {
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
                if (this.hrN != null) {
                    this.hrN.setCanVisible(false);
                }
                if (this.hrO != null) {
                    this.hrO.setVisible(8);
                }
                if (this.hrM != null) {
                    this.hrM.setCanVisible(false);
                }
                if (this.hrZ != null) {
                    this.hrZ.setCanVisible(false);
                }
                if (this.hrP != null) {
                    this.hrP.setCanVisible(false);
                }
            } else {
                caH();
            }
            if (this.hrr != null && this.hqt != null) {
                if (this.hsb.indexOfChild(this.hqt) != -1 && this.hqt.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hqt.getLayoutParams();
                    layoutParams2.height = com.baidu.live.aj.c.j(true, z);
                    this.hqt.setLayoutParams(layoutParams2);
                }
                if (this.hqt.indexOfChild(this.hrr.Kd().getView()) != -1 && this.hrr.Kd().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.hrr.Kd().getView().getLayoutParams();
                    layoutParams3.height = com.baidu.live.aj.c.j(true, z);
                    this.hrr.Kd().getView().setLayoutParams(layoutParams3);
                }
                this.hrr.Kd().Kc();
            }
        }
    }

    private void caH() {
        if (this.hrb != null) {
            this.hrb.setVisibility(0);
        }
        if (this.hqt != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqt.getLayoutParams();
            layoutParams.bottomMargin = cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            this.hqt.setLayoutParams(layoutParams);
        }
        if (this.hrr != null) {
            cbc();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hrr.Ke().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.hrr.Ke().getView().setLayoutParams(layoutParams2);
            if (this.aMG) {
                if (UtilHelper.getRealScreenOrientation(cbI().pageContext.getPageActivity()) != 2 && !this.hrr.Kf().isClicked()) {
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
        if (this.hsa != null && (!this.hqy || UtilHelper.getRealScreenOrientation(cbI().pageContext.getPageActivity()) != 2)) {
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
        if (this.hrM != null) {
            this.hrM.setCanVisible(true);
        }
        if (this.hrZ != null) {
            this.hrZ.setCanVisible(true);
        }
        if (this.hrP != null) {
            this.hrP.setCanVisible(true);
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
        FrameLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        FrameLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = cbI().pageContext.getPageActivity();
        if (i3 == 1) {
            if (cbI().pageContext.getPageActivity() != null) {
                r.e(cbI().pageContext.getPageActivity(), true);
            }
            if (this.hsa != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.hsa.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.hqr != null) {
                this.hqr.dismiss();
            }
            if (this.hqq != null) {
                this.hqq.a((a.InterfaceC0179a) null);
                this.hqq.zR();
            }
            if (this.brL != null) {
                this.brL.e(true, true);
            }
            if (this.hqv != null) {
                this.hqv.setVisibility(0);
                this.hqv.bringToFront();
            }
            if (this.hrh != null) {
                this.hrh.setVisibility(0);
            }
            if (this.hrr != null && this.hrr.Kd().getView().getParent() != null && (this.hrr.Kd().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hrr.Kd().getView().getParent()).removeView(this.hrr.Kd().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(cbI().pageContext.getPageActivity()) * 0.7f);
            int j = com.baidu.live.aj.c.j(true, false);
            if (this.hqt != null && this.hrr != null) {
                this.hqt.addView(this.hrr.Kd().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, j));
            }
            if (this.hqu != null && (this.hqu.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hqu.getParent()).removeView(this.hqu);
            }
            if (this.hrs != null) {
                this.hrs.a(cbI().hBt.Fm(), false);
                this.hrs.a(new a.InterfaceC0179a() { // from class: com.baidu.tieba.ala.liveroom.c.a.19
                    @Override // com.baidu.live.im.b.a.InterfaceC0179a
                    public void KM() {
                        a.this.cbt();
                    }
                });
                View zP = this.hrs.zP();
                if (zP != null && this.hsb != null && zP.getParent() == null) {
                    Resources resources = cbI().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(cbI().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                    layoutParams5.addRule(2, a.f.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                    this.hsb.addView(zP, layoutParams5);
                }
            }
            if (this.hrj != null) {
                this.hrj.setPraiseEnable(true);
                cbI().hBu.hRi = true;
            }
            if (this.hqf != null && this.hqf.htK != null && (layoutParams3 = (FrameLayout.LayoutParams) this.hqf.htK.getLayoutParams()) != null) {
                layoutParams3.width = -2;
                this.hqf.htK.setLayoutParams(layoutParams3);
            }
            if (this.hrm != null) {
                this.hrm.clJ();
            }
            if (this.hqy) {
                nK(true);
            }
            if (this.hqz) {
                if (this.hrb != null && this.hrb.getLandscapeBarrageImageView() != null) {
                    b(this.hrb.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.hrb != null) {
                this.hrb.wa(0);
            }
            if (this.hqj != null) {
                this.hqj.nY(true);
            }
            this.hqA.removeCallbacksAndMessages(null);
            if (this.hqk != null) {
                this.hqk.setCanVisible(true);
                this.hqk.M(cbI().hBt.Fm());
            }
            if (this.hqs != null) {
                this.hqs.cT(true);
            }
            if (this.hrr != null) {
                if (this.aMG) {
                    if (!this.hrr.Kf().isClicked()) {
                        this.hrr.Kf().cw(true);
                    }
                } else {
                    this.hrr.Kf().cw(false);
                }
            }
        } else if (i3 == 2) {
            if (cbI().pageContext.getPageActivity() != null) {
                r.e(cbI().pageContext.getPageActivity(), false);
            }
            if (this.hrm != null) {
                this.hrm.clK();
            }
            if (this.hsa != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.hsa.getLayoutParams()) != null) {
                layoutParams2.topMargin = cbI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
            }
            if (this.hrs != null) {
                this.hrs.a((a.InterfaceC0179a) null);
                this.hrs.zR();
            }
            cbI().hBu.cll();
            if (this.brL != null) {
                this.brL.e(false, true);
            }
            if (this.hqv != null) {
                this.hqv.setVisibility(4);
            }
            if (this.hrr != null && this.hrr.Kd().getView().getParent() != null && (this.hrr.Kd().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hrr.Kd().getView().getParent()).removeView(this.hrr.Kd().getView());
                this.hrr.Kf().cw(false);
            }
            int max = Math.max(i, i2);
            if (this.hqu != null) {
                if (this.hqu.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hqu.getParent()).removeView(this.hqu);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100);
                cbI().hBu.addView(this.hqu, this.byA != null ? cbI().hBu.indexOfChild(this.byA) : -1, layoutParams6);
            }
            if (this.hqu != null && this.hqq != null) {
                this.hqq.a(cbI().hBt.Fm(), false);
                this.hqq.a(new a.InterfaceC0179a() { // from class: com.baidu.tieba.ala.liveroom.c.a.20
                    @Override // com.baidu.live.im.b.a.InterfaceC0179a
                    public void KM() {
                        a.this.cbt();
                    }
                });
                View zP2 = this.hqq.zP();
                if (zP2 != null && this.hqu.indexOfChild(zP2) < 0) {
                    this.hqu.addView(zP2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(cbI().pageContext.getPageActivity()), -1));
                }
            }
            if (this.hrj != null) {
                this.hrj.aM(cbI().hBu);
                this.hrj.setPraiseEnable(false);
                cbI().hBu.hRi = false;
            }
            if (this.hqf != null && this.hqf.htK != null && (layoutParams = (FrameLayout.LayoutParams) this.hqf.htK.getLayoutParams()) != null) {
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                layoutParams.width = (int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f);
                this.hqf.htK.setLayoutParams(layoutParams);
            }
            if (this.hrb != null) {
                this.hrb.wa(8);
            }
            if (this.hqj != null) {
                this.hqj.nY(false);
            }
            if (al.FB() != null) {
                al.FB().FA();
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.ag.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.ag.c) runTask.getData()).FA();
            }
            if (this.hrb != null && this.hrb.getLandscapeBarrageImageView() != null) {
                b(this.hrb.getLandscapeBarrageImageView(), this.hqz, false);
            }
            bZW();
            if (this.hrt != null) {
                this.hrt.EL();
            }
            if (this.hqk != null) {
                this.hqk.setCanVisible(false);
                this.hqk.cfp();
            }
            if (this.hqs != null) {
                this.hqs.setCanVisible(false);
            }
        }
        if (this.hrN != null) {
            this.hrN.cK(i3);
        }
        if (this.hrA != null) {
            this.hrA.cK(i3);
        }
        if (this.hru != null) {
            this.hru.cK(i3);
        }
        if (this.hrr != null) {
            this.hrr.Kf().cK(i3);
        }
        if (this.hrb != null) {
            this.hrb.l(i, i2, i3);
        }
        K(i3, true);
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.hqf != null) {
                this.hqf.cr(i3);
            }
            if (this.hqh != null) {
                this.hqh.cr(i3);
            }
            if (this.hql != null) {
                this.hql.cr(i3);
            }
            if (this.hrC != null) {
                this.hrC.cr(i3);
            }
            if (this.hrx != null) {
                this.hrx.cr(i3);
            }
            if (this.bgE != null) {
                this.bgE.cr(i3);
            }
            if (this.hqB != null && this.hqB.isShowing()) {
                this.hqB.resize();
            }
            if (this.hrT != null) {
                this.hrT.cr(i3);
            }
            if (this.hrU != null) {
                this.hrU.cr(i3);
            }
            if (this.hrR != null) {
                this.hrR.cK(i3);
            }
            if (this.hrX != null) {
                this.hrX.cr(i3);
            }
        }
        if (this.hrt != null) {
            this.hrt.EK();
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
            if (i != 7 || UtilHelper.getRealScreenOrientation(cbI().pageContext.getPageActivity()) != 2) {
                if (this.hrb != null) {
                    this.hrb.setVisibility(8);
                }
                if (this.hrr != null) {
                    this.hrr.Kd().getView().setVisibility(4);
                    this.hrr.Kf().cw(false);
                }
                if (this.hrG != null) {
                    this.hrG.oM(false);
                }
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
                if (this.aMG && UtilHelper.getRealScreenOrientation(cbI().pageContext.getPageActivity()) != 2 && !this.hrr.Kf().isClicked()) {
                    this.hrr.Kf().cw(true);
                }
            }
            if (this.hrG != null) {
                this.hrG.oM(true);
            }
            if (!this.hqy || UtilHelper.getRealScreenOrientation(cbI().pageContext.getPageActivity()) != 2) {
                this.hsa.setVisibility(0);
            }
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
        if (cbI() != null) {
            BdUtilHelper.hideSoftKeyPad(cbI().pageContext.getPageActivity(), cbI().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.hqi != null) {
            this.hqi.ckl();
        }
        if (this.hqn != null) {
            this.hqn.AB();
        }
        if (this.hql != null) {
            this.hql.onStart();
        }
        if (this.hrR != null) {
            this.hrR.onStart();
        }
        if (this.hrZ != null) {
            this.hrZ.onStart();
        }
    }

    private void K(int i, boolean z) {
        if (this.byA != null) {
            int dimensionPixelSize = cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.byA.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                layoutParams.rightMargin = cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6);
                layoutParams.height = caf();
                this.byA.setPosition(dimensionPixelSize, 0, dimensionPixelSize, 0);
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                int dimensionPixelSize2 = cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds72) + 0 + cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100) + cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
                layoutParams.height = -1;
                this.byA.setPosition(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
            }
            layoutParams.bottomMargin = cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds114);
            this.byA.setLayoutParams(layoutParams);
            this.byA.setModel(i == 1 ? PendantParentView.Model.HORIZONTAL : PendantParentView.Model.HORIZONTAL_FULL);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.e
    public void vp(int i) {
        K(this.mOrientation, false);
    }
}
