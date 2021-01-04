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
/* loaded from: classes11.dex */
public class a extends b implements com.baidu.live.n.c, e {
    private PendantParentView bzK;
    private com.baidu.tieba.ala.liveroom.g.b hqA;
    private com.baidu.tieba.ala.liveroom.u.b hqB;
    private com.baidu.tieba.ala.liveroom.audiencelist.b hqC;
    private com.baidu.tieba.ala.liveroom.l.a hqD;
    private com.baidu.tieba.ala.liveroom.activeview.b hqE;
    private com.baidu.live.f.a hqF;
    private i hqG;
    private h hqH;
    private com.baidu.tieba.ala.liveroom.c.a hqI;
    private com.baidu.live.im.b.a hqJ;
    private com.baidu.tieba.ala.liveroom.share.b hqK;
    private com.baidu.live.ae.a hqL;
    private FrameLayout hqM;
    private FrameLayout hqN;
    private ImageView hqO;
    private com.baidu.live.tieba.e.b hqP;
    private ah hqU;
    private com.baidu.tieba.ala.liveroom.j.b hqV;
    private com.baidu.tieba.ala.liveroom.audiencelist.c hqy;
    private com.baidu.tieba.ala.liveroom.o.a hqz;
    private long lastClickTime = 0;
    private boolean hqQ = false;
    private boolean hqR = false;
    private boolean hqS = false;
    private Handler hqT = new Handler();
    private HttpRule hqW = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.hqG != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.hqG.DR()) {
                httpMessage.addParam("ala_challenge_id", a.this.hqG.DU());
            }
            return httpMessage;
        }
    };
    private HttpRule hqX = new HttpRule(1021229) { // from class: com.baidu.tieba.ala.liveroom.d.a.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.hqG != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.hqG.DR()) {
                httpMessage.addParam("challenge_id", a.this.hqG.DU());
            }
            return httpMessage;
        }
    };
    private HttpRule hqY = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.a.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.hqG != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.hqG.DR()) {
                httpMessage.addParam("challenge_id", a.this.hqG.DU());
            }
            return httpMessage;
        }
    };
    private HttpRule hqZ = new HttpRule(1021232) { // from class: com.baidu.tieba.ala.liveroom.d.a.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.hqG != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.hqG.DR()) {
                httpMessage.addParam("challenge_id", a.this.hqG.DU());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c hra = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.25
        @Override // com.baidu.live.liveroom.g.c
        public void PA() {
            if (a.this.hrG != null) {
                a.this.hrG.oM(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cD(boolean z) {
            if (z) {
                if (a.this.hrG != null) {
                    a.this.hrG.oM(true);
                }
            } else if (a.this.hrG != null) {
                a.this.hrG.oM(false);
            }
            if (a.this.hrZ != null) {
                a.this.hrZ.bC(z);
            }
            if (a.this.hqE != null) {
                a.this.hqE.nC(z ? false : true);
            }
            com.baidu.live.q.a.cE(z);
        }
    };
    private com.baidu.tieba.ala.liveroom.o.c hrb = new com.baidu.tieba.ala.liveroom.o.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.26
        @Override // com.baidu.tieba.ala.liveroom.o.c
        public void onClick() {
            a.this.hqT.removeCallbacksAndMessages(null);
            a.this.hqQ = true;
        }

        @Override // com.baidu.tieba.ala.liveroom.o.c
        public void endAnimation() {
            if (a.this.hqQ) {
                a.this.ccR();
            }
        }
    };
    private CustomMessageListener hrc = new CustomMessageListener(2913287) { // from class: com.baidu.tieba.ala.liveroom.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hqP != null) {
                a.this.hqP.dd(false);
                a.this.hqP.Wn();
            }
        }
    };
    private CustomMessageListener hrd = new CustomMessageListener(2913290) { // from class: com.baidu.tieba.ala.liveroom.d.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hqP != null) {
                a.this.hqP.dd(true);
            }
        }
    };
    private HttpMessageListener hre = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.QT() != null) {
                        com.baidu.live.af.e.ST().bCm = getQuickGiftHttpResponseMessage.QT();
                        a.this.cdh();
                    }
                }
            }
        }
    };
    private CustomMessageListener hrf = new CustomMessageListener(2913276) { // from class: com.baidu.tieba.ala.liveroom.d.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            JSONObject optJSONObject;
            JSONArray optJSONArray;
            if (a.this.mOrientation == 1 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject) && (optJSONObject = ((JSONObject) customResponsedMessage.getData()).optJSONObject("ext_data")) != null && (optJSONArray = optJSONObject.optJSONArray("surprise_prize_member")) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                View inflate = LayoutInflater.from(a.this.activity).inflate(a.g.ala_fudai_dialog_layout, (ViewGroup) null);
                final Dialog dialog = new Dialog(a.this.ceF().pageContext.getPageActivity(), a.i.FudaiDialogStyle);
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
    private CustomMessageListener hrg = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                a.this.hrO.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hrh = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.a.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.hsc != null) {
                    a.this.hsc.ie(str);
                }
            }
        }
    };
    CustomMessageListener hri = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.a.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.hsD != null && a.this.hsD.bkF != null && !a.this.hsD.bkK && !a.this.hsD.bkL && a.this.hrY != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.ceF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                if (a.this.hrL != null && a.this.hrL.MC().OI()) {
                    layoutParams.bottomMargin = a.this.ceF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds88);
                } else {
                    layoutParams.bottomMargin = a.this.ceF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                }
                a.this.hrY.c(a.this.hqM, layoutParams);
                if (com.baidu.live.guardclub.e.Lx() != null) {
                    com.baidu.live.guardclub.e.Lx().LC();
                }
            }
        }
    };
    private CustomMessageListener hrj = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (a.this.hsa != null) {
                    a.this.hsa.dismiss();
                }
                if (a.this.hsc != null) {
                    a.this.hsc.dismiss();
                }
                if (a.this.hfG != null) {
                    a.this.hfG.dismiss();
                }
                com.baidu.live.im.b.d.Nk().setSwitchStatus(true);
                com.baidu.live.im.b.d.Nk().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cdW();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener hrk = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.a.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.hqV.c(a.this.ceF());
                } else if (a.this.cdP() || !g.wW(2913168)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.13.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.ceF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.ceF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    a.this.hqV.c(a.this.hqM, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b hrl = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.a.17
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
                if (i == 2 && a.this.KE()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel"));
                    a.this.P(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.af.e.ST().bCm.Hx().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.af.e.ST().bCm.Hx().Gx());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.af.e.ST().bCm.Hx().Gy());
                        if (a.this.ceF().hBP.HR() != null && a.this.ceF().hBP.HR().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.ceF().hBP.HR().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.ceF().hBP.HR().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.NL());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.KE()) {
                        if (com.baidu.live.d.Ba().getBoolean("quick_gift_guide_show", true) && !a.this.cdP()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, ah.class, a.this.ceF().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                ah ahVar = (ah) runTask.getData();
                                ahVar.setPageContext(a.this.ceF().pageContext);
                                ahVar.setLiveShowData(a.this.ceF().hBP.HR());
                                ahVar.setGiftItem(com.baidu.live.af.e.ST().bCm.Hx());
                                ahVar.setOtherParams(a.this.NL());
                                ahVar.initView();
                                ahVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.17.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        a.this.nI(false);
                                        a.this.hqU = null;
                                    }
                                });
                                a.this.hqU = ahVar;
                                ahVar.show();
                                a.this.nI(true);
                                return;
                            }
                            return;
                        }
                        n.a(a.this.ceF().pageContext, a.this.ceF().hBP.HR(), com.baidu.live.af.e.ST().bCm.Hx(), a.this.NL());
                    }
                } else if (i == 1) {
                    if (a.this.hrL != null) {
                        a.this.cdW();
                    }
                } else if (i == 3 && a.this.KE()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    if (a.this.mOrientation == 2 && (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                        if (a.this.hqK != null) {
                            a.this.hqK.S(a.this.ceF().hBP.HR());
                        }
                    } else {
                        a.this.hry.d(a.this.ceF().hBP.HR(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.ceF() != null && a.this.ceF().hBP != null && a.this.ceF().hBP.HR() != null && a.this.ceF().hBP.HR().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.ceF().hBP.HR().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.ceF().hBP.HR().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.ceF().hBP.HR().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.NL());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.ceF() != null && a.this.ceF().hBP != null && a.this.ceF().hBP.HR() != null && a.this.ceF().hBP.HR().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.ceF().hBP.HR().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.ceF().hBP.HR().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.ceF().hBP.HR().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.NL());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.bsW != null) {
                        a.this.bsW.cx(false);
                    }
                } else if (i == 12) {
                    if (a.this.hrG != null) {
                        String valueOf = String.valueOf(a.this.ceF().hBP.HR().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.ceF().hBP.HR().mLiveInfo.room_id);
                        String str4 = null;
                        AlaLiveSdkInfo alaLiveSdkInfo = a.this.ceF().hBP.HR().mLiveSdkInfo;
                        if (alaLiveSdkInfo != null && alaLiveSdkInfo.mCastIds != null) {
                            str4 = String.valueOf(a.this.ceF().hBP.HR().mLiveSdkInfo.mCastIds.chatMCastId);
                        }
                        a.this.hrG.ax(valueOf, valueOf2, str4);
                        com.baidu.live.q.a.c(a.this.ceF().hBP.HR().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    x HR = a.this.ceF().hBP.HR();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.ceF().pageContext.getPageActivity(), HR.aKu.userName, Long.toString(HR.aKu.userId), Long.toString(HR.aKu.charmCount), String.valueOf(HR.mLiveInfo.group_id), String.valueOf(HR.mLiveInfo.live_id), false, String.valueOf(HR.aKu.userId), Long.toString(HR.aKQ.userId), HR.aKQ.userName, HR.aKQ.portrait, a.this.hqC.getCount(), a.this.NL())));
                    LogManager.getCommonLogger().doClickGusetNumLog(HR.mLiveInfo.feed_id, a.this.hqC.getCount() + "", a.this.NL());
                } else if (i == 11) {
                    a.this.ceb();
                    a.this.cec();
                } else if (i == 16) {
                    if (a.this.ceF() != null && (bqVar2 = com.baidu.live.af.a.SE().bCb) != null && (chVar = bqVar2.aRB) != null) {
                        String str5 = chVar.aTe.aTo;
                        if (!TextUtils.isEmpty(str5)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (a.this.ceF().hBP != null && a.this.ceF().hBP.HR() != null && a.this.ceF().hBP.HR().mLiveInfo != null) {
                                j = a.this.ceF().hBP.HR().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", a.this.ceF().hBP.HR().mLiveInfo.room_id + "", a.this.ceF().hBP.HR().mLiveInfo.feed_id, a.this.NL());
                            }
                            if (str5.contains("?")) {
                                str3 = str5 + "&liveId=" + j;
                            } else {
                                str3 = str5 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.ceF().pageContext.getPageActivity(), str3);
                        }
                    }
                } else if (i == 20) {
                    if (a.this.ceF() != null) {
                        x xVar = null;
                        if (a.this.ceF().hBP != null) {
                            xVar = a.this.ceF().hBP.HR();
                        }
                        if (xVar != null && xVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.v.b.cnp().bwr != null) {
                            String str6 = com.baidu.tieba.ala.liveroom.v.b.cnp().bwr.aJH;
                            if (!TextUtils.isEmpty(str6)) {
                                if (str6.contains("?")) {
                                    str2 = str6 + "&live_id=" + xVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str2 = str6 + "?live_id=" + xVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(a.this.ceF().pageContext.getPageActivity(), str2)));
                            }
                        }
                    }
                } else if (i == 17) {
                    if (a.this.KE() && a.this.ceF() != null && (bqVar = com.baidu.live.af.a.SE().bCb) != null && bqVar.aRB != null && (str = bqVar.aRB.aTl) != null && (cnVar = new cn(str)) != null && !TextUtils.isEmpty(cnVar.webUrl)) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                        if (a.this.hsa != null && a.this.ceF().hBP != null && a.this.ceF().hBP.HR() != null) {
                            x HR2 = a.this.ceF().hBP.HR();
                            a.this.hsa.b(cnVar.webUrl, HR2.mLiveInfo.live_id, HR2.aKQ.userId, HR2.aKu.userId);
                            a.this.hqP.dd(false);
                            a.this.hqP.Wn();
                        }
                    }
                } else if (i == 18) {
                    if (a.this.hqS) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.hqS = !a.this.hqS;
                } else if (i == 19 && a.this.hqP != null) {
                    a.this.hqP.Wn();
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.hrA = new com.baidu.tieba.ala.liveroom.guide.c(ceF().pageContext, this, false);
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
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccR() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.27
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.hqR) {
                    a.this.nD(false);
                }
            }
        }, 5000L);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void m(x xVar) {
        super.m(xVar);
        g.cih();
        this.hqS = false;
        if (this.hrD != null) {
            this.hrD.b(this.hrl);
        }
        if (this.hqP == null) {
            this.hqP = new com.baidu.live.tieba.e.b(ceF().pageContext.getPageActivity());
            this.hqP.start();
        }
        this.hqP.dd(true);
        ceF().pageContext.getPageActivity().setRequestedOrientation(-1);
        ceF().hBQ.setIsForceHandledTouch(false);
        ceF().hBQ.setSwipeClearEnable(true);
        ceF().hBQ.setOnLiveViewScrollListener(this.hra);
        ceF().hBQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hqT.removeCallbacksAndMessages(null);
                a.this.hqQ = false;
                a.this.nD(false);
                if (!a.this.hqR) {
                    a.this.ccR();
                }
            }
        });
        if (this.hsw != null) {
            this.hsw.setVisibility(0);
        }
        ccZ();
        if (this.hrW != null) {
            this.hrW.a(xVar, this.bzK);
            this.hrW.U(this.hsx);
            this.hrW.a(this);
        }
        cem();
        cdl();
        cdL();
        cdK();
        cdm();
        ccW();
        cdq();
        cdn();
        ccS();
        nJ(false);
        cds();
        cel();
        cet();
        cef();
        cek();
        cdi();
        cdj();
        cee();
        cdk();
        ceg();
        ccU();
        cdt();
        nL(true);
        cen();
        cdb();
        cdh();
        cex();
        cdc();
        cdd();
        cde();
        cdf();
        ccX();
        cdv();
        cdu();
        ccT();
        cew();
        ces();
        ccY();
        if (this.hsa != null && this.hsa.cnz() == null) {
            this.hsa.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.29
                @Override // com.baidu.tieba.ala.liveroom.turntable.d.a
                public void onDismiss() {
                    a.this.hqP.dd(true);
                }
            });
        }
        c(this.gtp);
        MessageManager.getInstance().registerListener(this.hre);
        MessageManager.getInstance().registerListener(this.hri);
        MessageManager.getInstance().registerListener(this.hrj);
        MessageManager.getInstance().registerListener(this.hrk);
        MessageManager.getInstance().registerListener(this.hrh);
        MessageManager.getInstance().registerListener(this.hrg);
        MessageManager.getInstance().registerListener(this.hrf);
        MessageManager.getInstance().registerListener(this.hrc);
        MessageManager.getInstance().registerListener(this.hrd);
        cdw();
        cdp();
        if (this.mOrientation == 2) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(ceF().pageContext.getPageActivity());
            l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(ceF().pageContext.getPageActivity()));
        }
        if (this.hsn != null) {
            this.hsn.K(xVar);
        }
        cei();
    }

    private void ccS() {
        if (this.hsn == null) {
            View view = null;
            if (this.hrD != null && this.hrD.getView() != null) {
                view = this.hrD.getView();
            }
            this.hsn = new com.baidu.tieba.ala.liveroom.exclusive.b(ceF().pageContext, Pw(), ceF().hBQ, view, this.hqy.hue, this);
        }
    }

    private void ccT() {
        if (this.hsm != null) {
            this.hsm.a(new com.baidu.live.aa.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.2
                @Override // com.baidu.live.aa.c
                public void cK(boolean z) {
                    if (a.this.hqH != null) {
                        a.this.hqH.setNeedCloseRecommendFloat(z);
                    }
                    if (a.this.ceF().hBQ.hRu) {
                        if (a.this.hrG != null) {
                            a.this.hrG.oE(z);
                            a.this.hrG.oM(!z);
                        }
                        if (a.this.hrD != null) {
                            a.this.hrD.oE(z);
                            a.this.hrD.setPraiseEnable(!z);
                            a.this.hrD.oD(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nD(boolean z) {
        View HQ;
        if (ceF() != null && ceF().pageContext != null && ceF().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(ceF().pageContext.getPageActivity()) == 2 || z) {
                if (this.hrO != null && (HQ = this.hrO.HQ()) != null) {
                    if (this.hqR) {
                        HQ.setVisibility(0);
                    } else {
                        HQ.setVisibility(8);
                    }
                }
                if (this.hqR) {
                    if (this.hsw != null) {
                        this.hsw.setVisibility(0);
                    }
                    if (this.hsx != null) {
                        this.hsx.setVisibility(0);
                    }
                    if (this.bzK != null) {
                        this.bzK.setVisibility(0);
                    }
                    if (this.bzK != null) {
                        this.bzK.setVisibility(0);
                    }
                    if (this.hrN != null) {
                        this.hrN.bA(false);
                    }
                } else {
                    if (this.hsw != null) {
                        this.hsw.setVisibility(8);
                    }
                    if (this.hsx != null) {
                        this.hsx.setVisibility(8);
                    }
                    if (this.bzK != null) {
                        this.bzK.setVisibility(8);
                    }
                    if (this.bzK != null) {
                        this.bzK.setVisibility(8);
                    }
                    if (this.hrN != null) {
                        this.hrN.bA(true);
                    }
                }
                this.hqR = this.hqR ? false : true;
                if (this.hqE != null) {
                    this.hqE.nC(this.hqR);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, boolean z2) {
        ImageView imageView;
        View Ho;
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view;
        }
        if (z) {
            if (imageView != null) {
                imageView.setImageResource(a.e.icon_live_barrage_off);
            }
            if (this.hqN != null) {
                this.hqN.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.e.icon_live_barrage_on);
            }
            if (this.hqN != null) {
                this.hqN.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.hrN != null && (Ho = this.hrN.Ho()) != null) {
            if (z) {
                Ho.setVisibility(8);
            } else {
                Ho.setVisibility(0);
            }
        }
    }

    private void ccU() {
        CustomResponsedMessage runTask;
        if (this.hqJ == null && (runTask = MessageManager.getInstance().runTask(2913164, com.baidu.live.im.b.a.class, ceF().pageContext)) != null) {
            this.hqJ = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hqJ != null) {
            this.hqJ.setOtherParams(this.otherParams);
            this.hqJ.a(new a.InterfaceC0186a() { // from class: com.baidu.tieba.ala.liveroom.d.a.3
                @Override // com.baidu.live.im.b.a.InterfaceC0186a
                public void Nj() {
                    a.this.ceq();
                }
            });
        }
    }

    private void ccV() {
        if (this.hrF != null) {
            this.hrF.aJ(ceF().hBO.getLiveContainerView());
        }
    }

    private void ccW() {
        if (this.hqK == null) {
            this.hqK = new com.baidu.tieba.ala.liveroom.share.b(ceF().pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void ccX() {
        if (ceF() != null) {
            if (this.hqL == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.ae.a.class, ceF().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hqL = (com.baidu.live.ae.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hqL.setIsHost(false);
            this.hqL.a(this.bzK, ceF().hBP.HR().aLu);
        }
    }

    private void ccY() {
        if (ceF() != null) {
            if (this.hsi == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913271, com.baidu.live.a.a.class, ceF().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hsi = (com.baidu.live.a.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hsi.bc(true);
            this.hsi.setIsHost(false);
            this.hsi.a(cdB(), ceF().hBP.HR());
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void dY(int i) {
        super.dY(i);
        if (this.hqO != null && UtilHelper.getRealScreenOrientation(ceF().pageContext.getPageActivity()) != 2) {
            this.hqO.setVisibility(0);
        }
        ccV();
        if (this.hqH != null) {
            this.hqH.dY(i);
        }
        if (this.hqH == null || !this.hqH.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
        if (this.hsn != null) {
            this.hsn.chF();
        }
    }

    private void ccZ() {
        if (this.bzK == null) {
            PendantParentView.Model model = PendantParentView.Model.HORIZONTAL;
            if (this.mOrientation == 2) {
                model = PendantParentView.Model.HORIZONTAL_FULL;
            }
            this.bzK = new PendantParentView(ceF().pageContext.getPageActivity(), model);
            ceF().hBQ.addView(this.bzK, ((ceF().hBQ.getView() == null || this.hrD == null || this.hrD.getView() == null) ? -1 : ceF().hBQ.getView().indexOfChild(this.hrD.getView())) + 1, new RelativeLayout.LayoutParams(-1, cda()));
            this.bzK.setDefaultItemMargin(ceF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            K(this.mOrientation, false);
        }
    }

    private int cda() {
        int bottom;
        int bottom2;
        if (ceF().bsZ.getLivePlayer().getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ceF().bsZ.getLivePlayer().getLayoutParams();
            bottom = layoutParams.topMargin + layoutParams.height;
        } else {
            bottom = ceF().bsZ.getLivePlayer().getBottom();
        }
        if (ceF().hBQ.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) ceF().hBQ.getLayoutParams();
            bottom2 = layoutParams2.topMargin + layoutParams2.height;
        } else {
            bottom2 = ceF().hBQ.getBottom();
        }
        int i = 0;
        if (this.hsn != null) {
            i = this.hsn.getHeight();
        }
        return (((bottom2 - bottom) - i) - ceF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - ceF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
    }

    private void cdb() {
        if (this.hqE == null) {
            this.hqE = new com.baidu.tieba.ala.liveroom.activeview.b(ceF().pageContext);
        }
        if (ceF() != null && ceF().hBP != null) {
            this.hqE.Ia(ceF().hBP.cmB());
        }
        this.hqE.setOtherParams(NL());
        this.hqE.c(ceF().hBP.HR(), true);
        this.hqE.setHost(false);
        this.hqE.a(1, this.bzK);
        this.hqE.a(2, this.bzK);
        this.hqE.setVisible(this.hsA ? 8 : 0);
    }

    private void cdc() {
        if (this.bzK != null) {
            if (this.hqD == null) {
                this.hqD = new com.baidu.tieba.ala.liveroom.l.a(ceF().pageContext, this);
            }
            this.hqD.setOtherParams(NL());
            this.hqD.a((ViewGroup) this.bzK, cdg());
            this.hqD.L(ceF().hBP.HR());
        }
    }

    private void cdd() {
        if (this.hrY == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, j.class, ceF().pageContext.getPageActivity());
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

    private void cde() {
        if (this.hrv != null) {
            this.hrv.a(new a.InterfaceC0687a() { // from class: com.baidu.tieba.ala.liveroom.d.a.14
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0687a
                public void bR(int i, int i2) {
                    x HR = a.this.ceF().hBP.HR();
                    if (HR != null && HR.mLiveInfo != null) {
                        if (a.this.hsb == null) {
                            a.this.hsb = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.ceF().pageContext.getPageActivity());
                        }
                        a.this.hsb.d(a.this.hsx, i, i2);
                        a.this.hsb.a(String.valueOf(HR.mLiveInfo.live_id), new a.InterfaceC0691a() { // from class: com.baidu.tieba.ala.liveroom.d.a.14.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0691a
                            public void a(float f, String str) {
                                if (a.this.hrv != null) {
                                    a.this.hrv.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0687a
                public void bS(int i, int i2) {
                    if (a.this.hsb != null) {
                        a.this.hsb.bX(i, i2);
                    }
                }
            });
        }
    }

    private void cdf() {
        if (this.hsM == null) {
            this.hsM = new com.baidu.tieba.ala.liveroom.j.e(ceF().pageContext);
        }
        this.hsM.setRoomId(ceF().hBP.HR().mLiveInfo.room_id);
        this.hsM.Iv("");
        this.hsM.b(ceF().hBP.HR(), this.bzK);
        if (this.hqV == null) {
            this.hqV = new com.baidu.tieba.ala.liveroom.j.b(ceF().pageContext, NL(), this.hsM, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.15
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void cdE() {
                    a.this.nI(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void cdF() {
                    a.this.nI(false);
                }
            });
        }
        this.hqV.setRoomId(ceF().hBP.HR().mLiveInfo.room_id);
        if (this.hqM != null && this.hqM.indexOfChild(this.hqV.getView()) >= 0) {
            this.hqM.removeView(this.hqV.getView());
        }
        if (this.hqV != null) {
            this.hqV.b(ceF());
        }
    }

    private LinearLayout.LayoutParams cdg() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = ceF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdh() {
        if (this.hrv == null) {
            cdn();
        }
        this.hrv.a(com.baidu.live.af.e.ST().bCm, ceF().hBP.HR());
    }

    private void cdi() {
        CustomResponsedMessage runTask;
        boolean z = true;
        if (this.hrL == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, ceF().pageContext)) != null && runTask.getData() != null) {
            this.hrL = (k) runTask.getData();
            this.hrL.setFromMaster(false);
            this.hrL.MA().getView().setId(a.f.ala_liveroom_msg_list);
            this.hrL.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.16
                @Override // com.baidu.live.im.k.a
                public boolean ME() {
                    return a.this.KE();
                }

                @Override // com.baidu.live.im.k.a
                public void MF() {
                    a.this.hsE = true;
                }

                @Override // com.baidu.live.im.k.a
                public void hO(String str) {
                    if (!a.this.hsA) {
                        a.this.nG(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.ceF().pageContext.getPageActivity(), a.this.ceF().hBO.getLiveContainerView());
                    }
                    a.this.Ih(str);
                }

                @Override // com.baidu.live.im.k.a
                public void MG() {
                    if (a.this.hsA) {
                        a.this.nG(true);
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.16.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.ceF().pageContext.getPageActivity(), a.this.ceF().hBO.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (a.this.hrL != null) {
                        a.this.hrL.MB().setQuickInputPanelVisible(false);
                        a.this.hrL.MB().Ow();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void MH() {
                }

                @Override // com.baidu.live.im.k.a
                public void MI() {
                    if (a.this.hsA) {
                        a.this.cdD();
                        if (a.this.hrM != null) {
                            a.this.hrM.Db();
                        }
                        if (a.this.hqJ != null) {
                            a.this.hqJ.Db();
                        }
                    } else if (a.this.hrL != null) {
                        a.this.hrL.MB().setQuickInputPanelVisible(false);
                        a.this.hrL.MB().Ow();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean MJ() {
                    return a.this.cdQ();
                }

                @Override // com.baidu.live.im.k.a
                public int MK() {
                    return a.this.cdR();
                }

                @Override // com.baidu.live.im.k.a
                public boolean ML() {
                    x HR = a.this.ceF().hBP.HR();
                    if (HR == null || HR.aKQ == null) {
                        return false;
                    }
                    return HR.aKQ.isMysteriousMan;
                }
            });
            this.hqM = new FrameLayout(ceF().pageContext.getPageActivity());
            this.hqM.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.hrL != null && this.hqM != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(ceF().pageContext.getPageActivity()) * 0.7f);
            int i = com.baidu.live.al.c.i(true, false);
            if (this.hsx.indexOfChild(this.hqM) < 0) {
                if (this.hqM.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hqM.getParent()).removeView(this.hqM);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = ceF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
                this.hsx.addView(this.hqM, layoutParams);
            }
            if (this.hqM.indexOfChild(this.hrL.MA().getView()) < 0) {
                if (this.hrL.MA().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hrL.MA().getView()).removeView(this.hrL.MA().getView());
                }
                if (UtilHelper.getRealScreenOrientation(ceF().pageContext.getPageActivity()) != 2) {
                    this.hqM.addView(this.hrL.MA().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, i));
                }
            }
            if (ceF().hBQ.indexOfChild(this.hrL.MB().getView()) < 0) {
                if (this.hrL.MB().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hrL.MB().getView().getParent()).removeView(this.hrL.MB().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                cdZ();
                ceF().hBQ.addView(this.hrL.MB().getView(), layoutParams2);
            }
            x HR = ceF().hBP.HR();
            if (HR != null && HR.mLiveInfo != null) {
                this.hrL.setLogData(HR.mLiveInfo.feed_id, NL());
            }
            if (HR == null || HR.aLi == null || !HR.aLi.Eq()) {
                z = false;
            }
            this.hrL.a(String.valueOf(ceF().hBP.HR().mLiveInfo.group_id), String.valueOf(ceF().hBP.HR().mLiveInfo.last_msg_id), String.valueOf(ceF().hBP.HR().aKu.userId), String.valueOf(ceF().hBP.HR().mLiveInfo.live_id), ceF().hBP.HR().aKu.appId, z, ceF().hBP.HR().getGuardName());
            nG(false);
        }
    }

    private void cdj() {
        cdX();
    }

    private void cdk() {
        if (this.hqN == null) {
            this.hqN = new FrameLayout(ceF().pageContext.getPageActivity());
            this.hqN.setId(a.f.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void cdl() {
        if (this.hqz == null) {
            this.hqz = new com.baidu.tieba.ala.liveroom.o.a(ceF().pageContext, false, this);
        }
        this.hqz.e(this.hsw, ceF().hBP.HR());
        this.hqz.a(this.hrb);
        this.hqz.a(this.hrl);
    }

    private void cdm() {
        if (this.hqy == null) {
            this.hqy = new com.baidu.tieba.ala.liveroom.audiencelist.c(ceF().pageContext, this, false);
        }
        this.hqy.a(String.valueOf(ceF().hBP.HR().mLiveInfo.group_id), String.valueOf(ceF().hBP.HR().mLiveInfo.live_id), String.valueOf(ceF().hBP.HR().aKu.userId), ceF().hBP.HR());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.f.ala_liveroom_hostheader;
            if (this.hrw != null && this.hrw.getView() != null && this.hrw.getView().getParent() != null) {
                i = a.f.ala_liveroom_guardthrone;
            }
            this.hqy.c(this.hsw, i, a.f.ala_liveroom_audience_count_layout);
            this.hqy.e(ceF().hBP.bWY());
        }
    }

    private void cdn() {
        com.baidu.live.core.a.a ON;
        if (this.hrv == null) {
            this.hrv = new com.baidu.tieba.ala.liveroom.operation.a(ceF().pageContext);
        }
        this.hrv.a(ceF(), this.hsx, ceF().hBP.HR().mLiveInfo, true, this.hrl);
        this.hrv.setOtherParams(NL());
        if (this.hrW != null && (ON = this.hrW.ON()) != null) {
            View rootLayout = ON.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.hrv.cy(rootLayout);
        }
        this.hrv.Q(ceF().hBP.HR());
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void cdo() {
        cdp();
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void nE(boolean z) {
    }

    private void cdp() {
        if (this.hrv != null) {
            int i = ceF().hBP.HR().aKQ.isUegBlock;
            int i2 = ceF().hBP.HR().aKQ.isBlock;
            String str = ceF().hBP.HR().aKQ.userName;
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

    private void cdq() {
        if (this.hqC == null) {
            this.hqC = new com.baidu.tieba.ala.liveroom.audiencelist.b(ceF().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (ceF().hBP.bWY() != null) {
            j = ceF().hBP.bWY().getCount();
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

    public void cdr() {
        this.hry.d(ceF().hBP.HR(), false);
    }

    public void cds() {
        if (ceF().hBP.HR() != null && ceF().hBP.HR().aKu != null && ceF().hBP.HR().mLiveInfo != null) {
            if (this.hqB == null) {
                this.hqB = new com.baidu.tieba.ala.liveroom.u.b(ceF().pageContext);
            }
            long j = ceF().hBP.HR().aKu.userId;
            int i = ceF().hBP.HR().mLiveInfo.live_type;
            String str = ceF().hBP.HR().aKu.portrait;
            String str2 = ceF().hBP.HR().mLiveInfo.feed_id;
            long j2 = ceF().hBP.HR().mLiveInfo.live_id;
            this.hqB.a(i, j, ceF().hBP.HR().aKu.userName, false, str, NL(), str2, j2);
            this.hqB.aF(this.hsw);
        }
    }

    private void cdt() {
        boolean z = false;
        if (this.hrG == null) {
            this.hrG = new com.baidu.tieba.ala.liveroom.w.a(ceF().pageContext, this);
        }
        this.hrG.c(ceF().hBQ, false);
        boolean ceE = ceE();
        AlaLiveInfoData alaLiveInfoData = ceF().hBP.HR().mLiveInfo;
        boolean isZanAnimUnabled = (alaLiveInfoData == null || alaLiveInfoData.mAlaLiveSwitchData == null) ? false : alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled();
        if (ceE && !isZanAnimUnabled) {
            z = true;
        }
        this.hrG.oL(z);
    }

    private void cdu() {
        if (ceF() != null && ceF().bsZ != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(ceF().pageContext.getPageActivity());
            Activity pageActivity = ceF().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + p.bs(pageActivity)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.hqO = new ImageView(ceF().pageContext.getPageActivity());
            this.hqO.setVisibility(8);
            this.hqO.setBackgroundResource(a.e.sdk_round_btn_close_bg);
            this.hqO.setImageResource(a.e.icon_live_enlarge);
            this.hqO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hqP != null) {
                        a.this.hqP.Wm();
                        a.this.hqO.setVisibility(4);
                        a.this.hrL.MC().cr(false);
                    }
                }
            });
            ceF().hBQ.addView(this.hqO, layoutParams);
            if (UtilHelper.getRealScreenOrientation(ceF().pageContext.getPageActivity()) != 2) {
                if (ceF().hBW) {
                    this.hqO.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.19
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.hqO != null && UtilHelper.getRealScreenOrientation(a.this.ceF().pageContext.getPageActivity()) != 2) {
                                a.this.hqO.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
        }
    }

    private void cdv() {
        if (this.hsv == null) {
            this.hsv = new com.baidu.tieba.ala.liveroom.apppromotion.a(ceF().pageContext);
        }
        this.hsv.b(cdB(), ceF().hBP.HR());
    }

    private void cdw() {
        if (this.hsE || this.hsF) {
            if ((TbadkCoreApplication.isLogin() && this.hrL.MB().hasText()) || this.hsF) {
                this.hsE = false;
                this.hsF = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.20
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cdW();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void t(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
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
            e.printStackTrace();
            jSONObject = null;
        }
        if (this.hqL == null || !this.hqL.V(jSONObject)) {
            if ((bVar.getMsgType() == 12 || bVar.getMsgType() == 13) && jSONObject != null) {
                String optString = jSONObject.optString("content_type");
                if ("task".equals(optString)) {
                    if (this.hqD != null) {
                        this.hqD.Q(jSONObject);
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
                    if (ceF().hBP.HR() != null && ceF().hBP.HR().mLiveInfo != null) {
                        ceF().hBP.a(ceF().hBP.HR().mLiveInfo.live_id, ceF().fromType, ceF().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && ceF().hBP.HR() != null && ceF().hBP.HR().mLiveInfo != null && ceF().hBP.HR().aKQ != null && this.hqH != null) {
                    long optLong = jSONObject.optLong("mvp_user_id");
                    long optLong2 = jSONObject.optLong("winner_live_id");
                    if (optLong == ceF().hBP.HR().aKQ.userId && optLong2 == ceF().hBP.HR().mLiveInfo.live_id) {
                        this.hqH.f(jSONObject.optInt("challenge_status"), jSONObject.optLong("challenge_id"));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void Ic(String str) {
        if (this.hqE != null) {
            this.hqE.Ic(str);
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
        if (this.hqJ != null) {
            this.hqJ.a(xVar);
        }
        if (this.hqE != null) {
            this.hqE.j(xVar);
            if (xVar != null && this.hso != null && !this.hso.hasInit && !TextUtils.isEmpty(this.hso.aRV)) {
                this.hso.hasInit = true;
                this.hqE.Id(this.hso.aRV);
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

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void cC(boolean z) {
        super.cC(z);
        if (ceF().hBQ != null) {
            ceF().hBQ.coc();
            ceF().hBQ.setLiveViewOnDispatchTouchEventListener(null);
            ceF().hBQ.setLiveViewOnTouchEventListener(null);
            ceF().hBQ.setOnLiveViewScrollListener(null);
        }
        if (ceF().bsZ != null) {
            ceF().bsZ.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
        }
        if (this.hqH != null) {
            this.hqH.DC();
        }
        cdx();
        if (this.hqB != null) {
            this.hqB.DC();
        }
        if (this.hrG != null) {
            this.hrG.release();
        }
        if (this.hqD != null) {
            this.hqD.DC();
        }
        if (this.hqL != null) {
            this.hqL.Bf();
        }
        if (this.hrv != null) {
            this.hrv.cmH();
        }
        if (this.hqA != null) {
            this.hqA.chi();
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
        if (this.hqG != null) {
            this.hqG.DC();
        }
        if (this.hqJ != null) {
            this.hqJ.a((a.InterfaceC0186a) null);
            this.hqJ.Dc();
        }
        if (this.hqz != null) {
            this.hqz.cjh();
        }
        if (this.hqO != null && (this.hqO.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hqO.getParent()).removeView(this.hqO);
        }
        if (this.hqK != null) {
            this.hqK.dismiss();
        }
        if (this.hqP != null) {
            this.hqP.dd(false);
            this.hqP.Wn();
        }
        if (this.hqV != null) {
            this.hqV.DC();
        }
        if (this.hsM != null) {
            this.hsM.cgc();
        }
        if (this.hsq != null) {
            this.hsq.DC();
        }
        if (this.hsv != null) {
            this.hsv.Bf();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void n(x xVar) {
        View Da;
        super.n(xVar);
        if (this.hqJ != null && (Da = this.hqJ.Da()) != null && Da.getParent() != null) {
            ((ViewGroup) Da.getParent()).removeView(Da);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.hqJ != null) {
            this.hqJ.setOtherParams(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cA(boolean z) {
        super.cA(z);
        this.hqT.removeCallbacksAndMessages(null);
        cdx();
        this.hqR = false;
        this.hqS = false;
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
        if (this.hqK != null) {
            this.hqK.onDestroy();
        }
        if (this.hqA != null) {
            this.hqA.onDestroy();
        }
        if (this.hqP != null) {
            this.hqP.stop();
        }
        if (this.hrG != null) {
            this.hrG.onDestroy();
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
        if (this.hqJ != null) {
            this.hqJ.a((a.InterfaceC0186a) null);
            this.hqJ.release();
            this.hqJ = null;
        }
        if (this.hsM != null) {
            this.hsM.cA(z ? false : true);
        }
        if (this.hqV != null) {
            this.hqV.onDestroy();
            this.hqV = null;
        }
        if (this.hsq != null) {
            this.hsq.onDestroy();
        }
        if (this.hqL != null) {
            this.hqL.onDestroy();
        }
        if (this.hsv != null) {
            this.hsv.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.hqX);
        MessageManager.getInstance().removeMessageRule(this.hqW);
        MessageManager.getInstance().removeMessageRule(this.hqY);
        MessageManager.getInstance().removeMessageRule(this.hqZ);
        MessageManager.getInstance().unRegisterListener(this.hre);
        MessageManager.getInstance().unRegisterListener(this.hri);
        MessageManager.getInstance().unRegisterListener(this.hrj);
        MessageManager.getInstance().unRegisterListener(this.hrk);
        MessageManager.getInstance().unRegisterListener(this.hrh);
        MessageManager.getInstance().unRegisterListener(this.hrg);
        MessageManager.getInstance().unRegisterListener(this.hrf);
        MessageManager.getInstance().unRegisterListener(this.hrc);
        MessageManager.getInstance().unRegisterListener(this.hrd);
    }

    private void cdx() {
        if (this.hrL != null && this.hrL.MA().getView() != null && this.hrL.MA().getView().getParent() != null) {
            ((ViewGroup) this.hrL.MA().getView().getParent()).removeView(this.hrL.MA().getView());
        }
        if (this.hqM != null && this.hqM.getParent() != null) {
            ((ViewGroup) this.hqM.getParent()).removeView(this.hqM);
        }
        if (this.hqN != null && this.hqN.getParent() != null) {
            ((ViewGroup) this.hqN.getParent()).removeView(this.hqN);
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
            cdW();
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
            cdW();
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
    protected void If(String str) {
        if (this.hrL != null) {
            cdW();
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
    protected View cdy() {
        if (this.hrL != null) {
            return this.hrL.MB().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean cdz() {
        if (this.hrL == null || !this.hrL.MB().Ov()) {
            return false;
        }
        nG(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected boolean cdA() {
        return this.hqz == null || this.hqz.cdA();
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected ViewGroup cdB() {
        return this.bzK;
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
                cdr();
                return;
            }
            azJ();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.hsA;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(ceF().pageContext.getPageActivity()) || z2) {
            nF(z);
        }
    }

    private void nF(boolean z) {
        if (this.hrL != null && this.hrL.MA() != null) {
            this.hrL.MA().onKeyboardVisibilityChanged(z);
        }
        if (z || this.hrL == null || !this.hrL.MB().Ov()) {
            if (z) {
                if (this.hrv != null) {
                    this.hrv.setVisibility(8);
                }
                if (this.hrN != null && this.hrN.Ho() != null) {
                    this.hrN.Ho().setVisibility(8);
                }
                cdD();
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
                if (this.hsj != null) {
                    this.hsj.setCanVisible(false);
                }
                if (this.hsk != null) {
                    this.hsk.setVisible(8);
                }
                if (this.hsi != null) {
                    this.hsi.setCanVisible(false);
                }
                if (this.hsv != null) {
                    this.hsv.setCanVisible(false);
                }
                if (this.hsl != null) {
                    this.hsl.setCanVisible(false);
                }
            } else {
                cdC();
            }
            if (this.hrL != null && this.hqM != null) {
                if (this.hsx.indexOfChild(this.hqM) != -1 && this.hqM.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hqM.getLayoutParams();
                    layoutParams2.height = com.baidu.live.al.c.i(true, z);
                    this.hqM.setLayoutParams(layoutParams2);
                }
                if (this.hqM.indexOfChild(this.hrL.MA().getView()) != -1 && this.hrL.MA().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.hrL.MA().getView().getLayoutParams();
                    layoutParams3.height = com.baidu.live.al.c.i(true, z);
                    this.hrL.MA().getView().setLayoutParams(layoutParams3);
                }
                this.hrL.MA().Mz();
            }
        }
    }

    private void cdC() {
        if (this.hrv != null) {
            this.hrv.setVisibility(0);
        }
        if (this.hqM != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqM.getLayoutParams();
            layoutParams.bottomMargin = ceF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            this.hqM.setLayoutParams(layoutParams);
        }
        if (this.hrL != null) {
            cdZ();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hrL.MB().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.hrL.MB().getView().setLayoutParams(layoutParams2);
            if (this.aOI) {
                if (UtilHelper.getRealScreenOrientation(ceF().pageContext.getPageActivity()) != 2 && !this.hrL.MC().isClicked()) {
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
        if (this.hsw != null && (!this.hqR || UtilHelper.getRealScreenOrientation(ceF().pageContext.getPageActivity()) != 2)) {
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
        if (this.hsi != null) {
            this.hsi.setCanVisible(true);
        }
        if (this.hsv != null) {
            this.hsv.setCanVisible(true);
        }
        if (this.hsl != null) {
            this.hsl.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdD() {
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
        cdC();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        FrameLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = ceF().pageContext.getPageActivity();
        if (i3 == 1) {
            if (ceF().pageContext.getPageActivity() != null && !UtilHelper.canUseStyleImmersiveSticky()) {
                com.baidu.live.utils.r.e(ceF().pageContext.getPageActivity(), true);
            }
            if (this.hsw != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.hsw.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.hqK != null) {
                this.hqK.dismiss();
            }
            if (this.hqJ != null) {
                this.hqJ.a((a.InterfaceC0186a) null);
                this.hqJ.Dc();
            }
            if (this.bsW != null) {
                this.bsW.e(true, true);
            }
            if (this.hqO != null) {
                this.hqO.setVisibility(0);
                this.hqO.bringToFront();
            }
            if (this.hrB != null) {
                this.hrB.setVisibility(0);
            }
            if (this.hrL != null && this.hrL.MA().getView().getParent() != null && (this.hrL.MA().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hrL.MA().getView().getParent()).removeView(this.hrL.MA().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(ceF().pageContext.getPageActivity()) * 0.7f);
            int i4 = com.baidu.live.al.c.i(true, false);
            if (this.hqM != null && this.hrL != null) {
                this.hqM.addView(this.hrL.MA().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, i4));
            }
            if (this.hqN != null && (this.hqN.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hqN.getParent()).removeView(this.hqN);
            }
            if (this.hrM != null) {
                this.hrM.a(ceF().hBP.HR(), false);
                this.hrM.a(new a.InterfaceC0186a() { // from class: com.baidu.tieba.ala.liveroom.d.a.21
                    @Override // com.baidu.live.im.b.a.InterfaceC0186a
                    public void Nj() {
                        a.this.ceq();
                    }
                });
                View Da = this.hrM.Da();
                if (Da != null && this.hsx != null && Da.getParent() == null) {
                    Resources resources = ceF().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(ceF().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                    layoutParams5.addRule(2, a.f.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                    this.hsx.addView(Da, layoutParams5);
                }
            }
            if (this.hrD != null) {
                this.hrD.setPraiseEnable(true);
                ceF().hBQ.hRu = true;
            }
            if (this.hqy != null && this.hqy.huf != null && (layoutParams3 = (FrameLayout.LayoutParams) this.hqy.huf.getLayoutParams()) != null) {
                layoutParams3.width = -2;
                this.hqy.huf.setLayoutParams(layoutParams3);
            }
            if (this.hrG != null) {
                this.hrG.coC();
            }
            if (this.hqR) {
                nD(true);
            }
            if (this.hqS) {
                if (this.hrv != null && this.hrv.getLandscapeBarrageImageView() != null) {
                    b(this.hrv.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.hrv != null) {
                this.hrv.xv(0);
            }
            if (this.hqC != null) {
                this.hqC.nR(true);
            }
            this.hqT.removeCallbacksAndMessages(null);
            if (this.hqD != null) {
                this.hqD.setCanVisible(true);
                this.hqD.L(ceF().hBP.HR());
            }
            if (this.hqL != null) {
                this.hqL.cO(true);
            }
            if (this.hrL != null) {
                if (this.aOI) {
                    if (!this.hrL.MC().isClicked()) {
                        this.hrL.MC().cr(true);
                    }
                } else {
                    this.hrL.MC().cr(false);
                }
            }
        } else if (i3 == 2) {
            if (ceF().pageContext.getPageActivity() != null && !UtilHelper.canUseStyleImmersiveSticky()) {
                com.baidu.live.utils.r.e(ceF().pageContext.getPageActivity(), false);
            }
            if (this.hrG != null) {
                this.hrG.coD();
            }
            if (this.hsw != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.hsw.getLayoutParams()) != null) {
                layoutParams2.topMargin = ceF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
            }
            if (this.hrM != null) {
                this.hrM.a((a.InterfaceC0186a) null);
                this.hrM.Dc();
            }
            ceF().hBQ.coe();
            if (this.bsW != null) {
                this.bsW.e(false, true);
            }
            if (this.hqO != null) {
                this.hqO.setVisibility(4);
            }
            if (this.hrL != null && this.hrL.MA().getView().getParent() != null && (this.hrL.MA().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hrL.MA().getView().getParent()).removeView(this.hrL.MA().getView());
                this.hrL.MC().cr(false);
            }
            int max = Math.max(i, i2);
            if (this.hqN != null) {
                if (this.hqN.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hqN.getParent()).removeView(this.hqN);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, ceF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = ceF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100);
                ceF().hBQ.addView(this.hqN, this.bzK != null ? ceF().hBQ.indexOfChild(this.bzK) : -1, layoutParams6);
            }
            if (this.hqN != null && this.hqJ != null) {
                this.hqJ.a(ceF().hBP.HR(), false);
                this.hqJ.a(new a.InterfaceC0186a() { // from class: com.baidu.tieba.ala.liveroom.d.a.23
                    @Override // com.baidu.live.im.b.a.InterfaceC0186a
                    public void Nj() {
                        a.this.ceq();
                    }
                });
                View Da2 = this.hqJ.Da();
                if (Da2 != null && this.hqN.indexOfChild(Da2) < 0) {
                    this.hqN.addView(Da2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(ceF().pageContext.getPageActivity()), -1));
                }
            }
            if (this.hrD != null) {
                this.hrD.aM(ceF().hBQ);
                this.hrD.setPraiseEnable(false);
                ceF().hBQ.hRu = false;
            }
            if (this.hqy != null && this.hqy.huf != null && (layoutParams = (FrameLayout.LayoutParams) this.hqy.huf.getLayoutParams()) != null) {
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                layoutParams.width = (int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f);
                this.hqy.huf.setLayoutParams(layoutParams);
            }
            if (this.hrv != null) {
                this.hrv.xv(8);
            }
            if (this.hqC != null) {
                this.hqC.nR(false);
            }
            if (al.Ig() != null) {
                al.Ig().If();
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.ai.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.ai.c) runTask.getData()).If();
            }
            if (this.hrv != null && this.hrv.getLandscapeBarrageImageView() != null) {
                b(this.hrv.getLandscapeBarrageImageView(), this.hqS, false);
            }
            ccR();
            if (this.hrN != null) {
                this.hrN.Hq();
            }
            if (this.hqD != null) {
                this.hqD.setCanVisible(false);
                this.hqD.cil();
            }
            if (this.hqL != null) {
                this.hqL.setCanVisible(false);
            }
        }
        if (this.hsj != null) {
            this.hsj.el(i3);
        }
        if (this.hrU != null) {
            this.hrU.el(i3);
        }
        if (this.hrO != null) {
            this.hrO.el(i3);
        }
        if (this.hrL != null) {
            this.hrL.MC().el(i3);
        }
        if (this.hrv != null) {
            this.hrv.l(i, i2, i3);
        }
        K(i3, true);
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.hqy != null) {
                this.hqy.dU(i3);
            }
            if (this.hqA != null) {
                this.hqA.dU(i3);
            }
            if (this.hqE != null) {
                this.hqE.dU(i3);
            }
            if (this.hrW != null) {
                this.hrW.dU(i3);
            }
            if (this.hrR != null) {
                this.hrR.dU(i3);
            }
            if (this.hsa != null) {
                this.hsa.dU(i3);
            }
            if (this.hsc != null) {
                this.hsc.dU(i3);
            }
            if (this.hfG != null) {
                this.hfG.dU(i3);
            }
            if (this.hqU != null && this.hqU.isShowing()) {
                this.hqU.resize();
            }
            if (this.hsp != null) {
                this.hsp.dU(i3);
            }
            if (this.hsq != null) {
                this.hsq.dU(i3);
            }
            if (this.hsn != null) {
                this.hsn.el(i3);
            }
            if (this.hst != null) {
                this.hst.dU(i3);
            }
        }
        if (this.hrN != null) {
            this.hrN.Hp();
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public boolean ff(int i) {
        boolean ff = super.ff(i);
        if (ff && 2 == i) {
            if (this.hqz.cdA()) {
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
            if (i != 7 || UtilHelper.getRealScreenOrientation(ceF().pageContext.getPageActivity()) != 2) {
                if (this.hrv != null) {
                    this.hrv.setVisibility(8);
                }
                if (this.hrL != null) {
                    this.hrL.MA().getView().setVisibility(4);
                    this.hrL.MC().cr(false);
                }
                if (this.hsb != null) {
                    this.hsb.oG(false);
                }
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
                if (this.aOI && UtilHelper.getRealScreenOrientation(ceF().pageContext.getPageActivity()) != 2 && !this.hrL.MC().isClicked()) {
                    this.hrL.MC().cr(true);
                }
            }
            if (this.hsb != null) {
                this.hsb.oG(true);
            }
            if (!this.hqR || UtilHelper.getRealScreenOrientation(ceF().pageContext.getPageActivity()) != 2) {
                this.hsw.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.hqB != null) {
            this.hqB.cne();
        }
        if (this.hqG != null) {
            this.hqG.DL();
        }
        if (this.hqE != null) {
            this.hqE.onStop();
        }
        if (ceF() != null) {
            BdUtilHelper.hideSoftKeyPad(ceF().pageContext.getPageActivity(), ceF().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.hqB != null) {
            this.hqB.cnd();
        }
        if (this.hqG != null) {
            this.hqG.DM();
        }
        if (this.hqE != null) {
            this.hqE.onStart();
        }
        if (this.hsn != null) {
            this.hsn.onStart();
        }
        if (this.hsv != null) {
            this.hsv.onStart();
        }
    }

    private void K(int i, boolean z) {
        if (this.bzK != null) {
            int dimensionPixelSize = ceF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bzK.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                layoutParams.rightMargin = ceF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6);
                layoutParams.height = cda();
                this.bzK.setPosition(dimensionPixelSize, 0, dimensionPixelSize, 0);
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                int dimensionPixelSize2 = ceF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds72) + 0 + ceF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100) + ceF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = ceF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
                layoutParams.height = -1;
                this.bzK.setPosition(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
            }
            layoutParams.bottomMargin = ceF().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds114);
            this.bzK.setLayoutParams(layoutParams);
            this.bzK.setModel(i == 1 ? PendantParentView.Model.HORIZONTAL : PendantParentView.Model.HORIZONTAL_FULL);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.e
    public void wK(int i) {
        K(this.mOrientation, false);
    }
}
