package com.baidu.tieba.ala.liveroom.d;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
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
import com.baidu.live.an.c;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.e;
import com.baidu.live.challenge.h;
import com.baidu.live.challenge.i;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveSdkInfo;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.ai;
import com.baidu.live.data.ar;
import com.baidu.live.data.ba;
import com.baidu.live.data.be;
import com.baidu.live.data.bo;
import com.baidu.live.data.cf;
import com.baidu.live.data.cl;
import com.baidu.live.data.p;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends b implements com.baidu.live.m.c {
    private PendantParentView buZ;
    private boolean gGE;
    private com.baidu.tieba.ala.liveroom.audiencelist.c heJ;
    private com.baidu.tieba.ala.liveroom.o.a heK;
    private com.baidu.tieba.ala.liveroom.g.b heL;
    private com.baidu.tieba.ala.liveroom.u.b heM;
    private com.baidu.tieba.ala.liveroom.audiencelist.b heN;
    private com.baidu.tieba.ala.liveroom.l.a heO;
    private com.baidu.tieba.ala.liveroom.activeview.b heP;
    private com.baidu.live.f.a heQ;
    private i heR;
    private h heS;
    private com.baidu.tieba.ala.liveroom.c.a heT;
    private FrameLayout heX;
    private com.baidu.tieba.ala.liveroom.j.b hfg;
    private LinearLayout hhE;
    private e hhF;
    private com.baidu.tieba.ala.liveroom.apppromotion.a hhH;
    private long lastClickTime = 0;
    private boolean hhG = false;
    private HttpRule hfh = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.heR != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.heR.EC()) {
                httpMessage.addParam("ala_challenge_id", d.this.heR.EF());
            }
            return httpMessage;
        }
    };
    private HttpRule hfi = new HttpRule(1021229) { // from class: com.baidu.tieba.ala.liveroom.d.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.heR != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.heR.EC()) {
                httpMessage.addParam("challenge_id", d.this.heR.EF());
            }
            return httpMessage;
        }
    };
    private HttpRule hfj = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.d.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.heR != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.heR.EC()) {
                httpMessage.addParam("challenge_id", d.this.heR.EF());
            }
            return httpMessage;
        }
    };
    private HttpRule hfk = new HttpRule(1021232) { // from class: com.baidu.tieba.ala.liveroom.d.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.heR != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.heR.EC()) {
                httpMessage.addParam("challenge_id", d.this.heR.EF());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c hfl = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.d.22
        @Override // com.baidu.live.liveroom.g.c
        public void PL() {
            if (d.this.hfP != null) {
                d.this.hfP.on(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cA(boolean z) {
            if (z) {
                if (d.this.hfP != null) {
                    d.this.hfP.on(true);
                }
            } else if (d.this.hfP != null) {
                d.this.hfP.on(false);
            }
            if (d.this.hgi != null) {
                d.this.hgi.bE(z);
            }
            if (d.this.heP != null) {
                d.this.heP.nd(z ? false : true);
            }
            com.baidu.live.p.a.cB(z);
        }
    };
    private HttpMessageListener hfn = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.d.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.PU() != null) {
                        com.baidu.live.ae.e.RP().bxB = getQuickGiftHttpResponseMessage.PU();
                        d.this.caA();
                    }
                }
            }
        }
    };
    CustomMessageListener hft = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.d.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.hfg.c(d.this.cbW());
                } else if (d.this.cbi() || !g.wL(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.26.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.cbW().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.cbW().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    d.this.hfg.b(d.this.heX, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener hfo = new CustomMessageListener(2913276) { // from class: com.baidu.tieba.ala.liveroom.d.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            JSONObject optJSONObject;
            JSONArray optJSONArray;
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject) && (optJSONObject = ((JSONObject) customResponsedMessage.getData()).optJSONObject("ext_data")) != null && (optJSONArray = optJSONObject.optJSONArray("surprise_prize_member")) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                View inflate = LayoutInflater.from(d.this.activity).inflate(a.g.ala_fudai_dialog_layout, (ViewGroup) null);
                final Dialog dialog = new Dialog(d.this.cbW().pageContext.getPageActivity(), a.i.FudaiDialogStyle);
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
                            ai aiVar = new ai();
                            aiVar.aLB = -1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aiVar));
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
    private CustomMessageListener hhI = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.d.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.cbi() || !g.wL(2913128)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.wJ(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    d.this.Ii(str);
                }
            }
        }
    };
    private CustomMessageListener hfp = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.hfX.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hfq = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.this.hgl != null) {
                    d.this.hgl.ir(str);
                }
            }
        }
    };
    CustomMessageListener hfr = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.d.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.hgL != null && d.this.hgL.bja != null && !d.this.hgL.bjf && !d.this.hgL.bjg && d.this.hgh != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.cbW().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                if (d.this.hfU != null && d.this.hfU.Nf().OY()) {
                    layoutParams.bottomMargin = d.this.cbW().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds70);
                } else {
                    layoutParams.bottomMargin = d.this.cbW().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                }
                d.this.hgh.b(d.this.heX, layoutParams);
                if (com.baidu.live.guardclub.e.LY() != null) {
                    com.baidu.live.guardclub.e.LY().Md();
                }
            }
        }
    };
    private CustomMessageListener hfs = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.d.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.hgj != null) {
                    d.this.hgj.dismiss();
                }
                if (d.this.hgl != null) {
                    d.this.hgl.dismiss();
                }
                if (d.this.gTR != null) {
                    d.this.gTR.dismiss();
                }
                com.baidu.live.im.b.d.NK().setSwitchStatus(true);
                com.baidu.live.im.b.d.NK().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.cbp();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b hfu = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.d.18
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void s(View view, int i) {
            bo boVar;
            cf cfVar;
            cl clVar;
            String str;
            bo boVar2;
            cf cfVar2;
            String str2;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - d.this.lastClickTime >= 300) {
                d.this.lastClickTime = currentTimeMillis;
                if (i == 2) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel"));
                    d.this.N(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.ae.e.RP().bxB.HW().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.ae.e.RP().bxB.HW().GX());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.ae.e.RP().bxB.HW().GY());
                        if (d.this.cbW().hpR.Iq() != null && d.this.cbW().hpR.Iq().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.cbW().hpR.Iq().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.cbW().hpR.Iq().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.Oj());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.Le()) {
                        if (com.baidu.live.d.BM().getBoolean("quick_gift_guide_show", true) && !d.this.cbi()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, ah.class, d.this.cbW().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                ah ahVar = (ah) runTask.getData();
                                ahVar.setPageContext(d.this.cbW().pageContext);
                                ahVar.setLiveShowData(d.this.cbW().hpR.Iq());
                                ahVar.setGiftItem(com.baidu.live.ae.e.RP().bxB.HW());
                                ahVar.setOtherParams(d.this.Oj());
                                ahVar.initView();
                                ahVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.d.d.18.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        d.this.ni(false);
                                    }
                                });
                                ahVar.show();
                                d.this.ni(true);
                                return;
                            }
                            return;
                        }
                        n.a(d.this.cbW().pageContext, d.this.cbW().hpR.Iq(), com.baidu.live.ae.e.RP().bxB.HW(), d.this.Oj());
                    }
                } else if (i == 1) {
                    if (d.this.hfU != null) {
                        d.this.cbp();
                    }
                } else if (i == 3 && d.this.Le()) {
                    if (com.baidu.live.p.a.isDebug()) {
                        com.baidu.live.p.a.b(d.this.cbW().hpR.Iq().mLiveInfo.live_id, 0);
                        return;
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    d.this.hfH.c(d.this.cbW().hpR.Iq(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.cbW() != null && d.this.cbW().hpR != null && d.this.cbW().hpR.Iq() != null && d.this.cbW().hpR.Iq().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.cbW().hpR.Iq().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.cbW().hpR.Iq().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.cbW().hpR.Iq().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.Oj());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.cbW() != null && d.this.cbW().hpR != null && d.this.cbW().hpR.Iq() != null && d.this.cbW().hpR.Iq().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.cbW().hpR.Iq().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.cbW().hpR.Iq().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.cbW().hpR.Iq().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.Oj());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.brc != null) {
                        d.this.brc.cu(false);
                    }
                } else if (i == 12) {
                    if (d.this.hfP != null && d.this.cbW().hpR.Iq() != null && d.this.cbW().hpR.Iq().mLiveInfo != null) {
                        String valueOf = String.valueOf(d.this.cbW().hpR.Iq().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.cbW().hpR.Iq().mLiveInfo.room_id);
                        String str3 = null;
                        AlaLiveSdkInfo alaLiveSdkInfo = d.this.cbW().hpR.Iq().mLiveSdkInfo;
                        if (alaLiveSdkInfo != null && alaLiveSdkInfo.mCastIds != null) {
                            str3 = String.valueOf(d.this.cbW().hpR.Iq().mLiveSdkInfo.mCastIds.chatMCastId);
                        }
                        d.this.hfP.au(valueOf, valueOf2, str3);
                        com.baidu.live.p.a.b(d.this.cbW().hpR.Iq().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    w Iq = d.this.cbW().hpR.Iq();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.cbW().pageContext.getPageActivity(), Iq.aJV.userName, Long.toString(Iq.aJV.userId), Long.toString(Iq.aJV.charmCount), String.valueOf(Iq.mLiveInfo.group_id), String.valueOf(Iq.mLiveInfo.live_id), false, String.valueOf(Iq.aJV.userId), Long.toString(Iq.aKr.userId), Iq.aKr.userName, Iq.aKr.portrait, d.this.heN.getCount(), d.this.Oj())));
                    LogManager.getCommonLogger().doClickGusetNumLog(Iq.mLiveInfo.feed_id, d.this.heN.getCount() + "", d.this.Oj());
                } else if (i == 11) {
                    d.this.cbt();
                    d.this.cbu();
                } else if (i == 16) {
                    if (d.this.cbW() != null && (boVar2 = com.baidu.live.ae.a.RB().bxq) != null && (cfVar2 = boVar2.aQM) != null) {
                        String str4 = cfVar2.aSj.aSq;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (d.this.cbW().hpR != null && d.this.cbW().hpR.Iq() != null && d.this.cbW().hpR.Iq().mLiveInfo != null) {
                                j = d.this.cbW().hpR.Iq().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", d.this.cbW().hpR.Iq().mLiveInfo.room_id + "", d.this.cbW().hpR.Iq().mLiveInfo.feed_id, d.this.Oj());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.cbW().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (d.this.cbW() != null) {
                        w wVar = null;
                        if (d.this.cbW().hpR != null) {
                            wVar = d.this.cbW().hpR.Iq();
                        }
                        if (wVar != null && wVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.v.b.ckA().brJ != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.v.b.ckA().brJ.aJj;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(d.this.cbW().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17 && d.this.Le() && d.this.cbW() != null && (boVar = com.baidu.live.ae.a.RB().bxq) != null && (cfVar = boVar.aQM) != null && (clVar = cfVar.aSk) != null && !TextUtils.isEmpty(clVar.webUrl)) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                    if (d.this.hgj != null && d.this.cbW().hpR != null && d.this.cbW().hpR.Iq() != null) {
                        w Iq2 = d.this.cbW().hpR.Iq();
                        d.this.hgj.a(clVar.webUrl, Iq2.mLiveInfo.live_id, Iq2.aKr.userId, Iq2.aJV.userId);
                    }
                }
            }
        }
    };
    private boolean hhJ = false;
    private boolean hhK = false;

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.hfJ = new com.baidu.tieba.ala.liveroom.guide.c(cbW().pageContext, this, false);
        this.hfi.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hfi);
        this.hfh.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hfh);
        this.hfj.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hfj);
        this.hfk.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hfk);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean caj() {
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(w wVar) {
        super.l(wVar);
        g.cfq();
        this.hhG = true;
        this.hhK = false;
        this.hhJ = false;
        cbW().hpS.setIsForceHandledTouch(false);
        cbW().hpS.setSwipeClearEnable(true);
        cbW().hpS.setOnLiveViewScrollListener(this.hfl);
        cbW().hpS.setOnClickListener(null);
        cbW().hpS.setClickable(false);
        if (this.hfM != null) {
            this.hfM.b(this.hfu);
        }
        if (this.hgE != null) {
            this.hgE.setVisibility(0);
        }
        cas();
        if (this.hgf != null) {
            this.hgf.a(wVar, this.buZ);
            this.hgf.U(this.hgF);
            this.hgf.a(this);
        }
        ccq();
        caE();
        cbe();
        cbd();
        caF();
        caJ();
        caG();
        cch();
        nj(false);
        caB();
        caC();
        cbw();
        caO();
        cby();
        caL();
        caM();
        ccj();
        cck();
        cbE();
        nl(false);
        cbB();
        caq();
        cbO();
        cau();
        caA();
        cav();
        caw();
        cax();
        cay();
        cam();
        cbD();
        cbK();
        cbx();
        cbC();
        np(true);
        cbN();
        c(this.giQ);
        car();
        cci();
        cbJ();
        cbh();
        MessageManager.getInstance().registerListener(this.hfn);
        MessageManager.getInstance().registerListener(this.hfp);
        MessageManager.getInstance().registerListener(this.hfr);
        MessageManager.getInstance().registerListener(this.hfs);
        MessageManager.getInstance().registerListener(this.hhI);
        MessageManager.getInstance().registerListener(this.hft);
        MessageManager.getInstance().registerListener(this.hfq);
        MessageManager.getInstance().registerListener(this.hfo);
        caP();
        caI();
        cbA();
    }

    private void cch() {
    }

    private void cci() {
        AlaVideoBCChatData alaVideoBCChatData;
        CustomResponsedMessage runTask;
        AlaLiveUserInfoData alaLiveUserInfoData = cbW().hpR.Iq().aKr;
        if (alaLiveUserInfoData != null && (alaVideoBCChatData = alaLiveUserInfoData.videoBCEnterData) != null && alaVideoBCChatData.isShowEnter()) {
            if (this.hgC == null && (runTask = MessageManager.getInstance().runTask(2913255, com.baidu.live.an.c.class, cbW().pageContext)) != null && runTask.getData() != null) {
                this.hgC = (com.baidu.live.an.c) runTask.getData();
            }
            if (this.hgC != null) {
                this.hgC.a(cbW().brf);
                this.hgC.b(cbW().hpQ.getMastView());
                this.hgC.q(cbW().hpR.Iq());
                this.hgC.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.23
                    @Override // com.baidu.live.an.c.a
                    public void WK() {
                        if (d.this.hfM != null) {
                            d.this.cbW().hpS.hFs = false;
                            d.this.hfM.setPraiseEnable(false);
                            if (d.this.cbW().hpT != null) {
                                d.this.cbW().hpT.setTalentShowing(true);
                            }
                        }
                    }

                    @Override // com.baidu.live.an.c.a
                    public void WL() {
                        if (d.this.hfM != null) {
                            d.this.cbW().hpS.hFs = true;
                            d.this.hfM.setPraiseEnable(true);
                            if (d.this.cbW().hpT != null) {
                                d.this.cbW().hpT.setTalentShowing(false);
                            }
                        }
                    }
                });
                View enterView = this.hgC.getEnterView();
                if (enterView != null) {
                    if (enterView.getParent() != null) {
                        ((ViewGroup) enterView.getParent()).removeView(enterView);
                    }
                    this.hfE.cq(enterView);
                }
            }
        }
    }

    private void cam() {
        if (this.hgu != null) {
            this.hgu.a(new com.baidu.live.z.c() { // from class: com.baidu.tieba.ala.liveroom.d.d.24
                @Override // com.baidu.live.z.c
                public void cH(boolean z) {
                    if (d.this.heS != null) {
                        d.this.heS.setNeedCloseRecommendFloat(z);
                    }
                    if (d.this.cbW().hpS.hFs) {
                        if (d.this.hfP != null) {
                            d.this.hfP.of(z);
                            d.this.hfP.on(!z);
                        }
                        if (d.this.hfM != null) {
                            d.this.hfM.of(z);
                            d.this.hfM.setPraiseEnable(!z);
                            d.this.hfM.oe(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void j(w wVar) {
        super.j(wVar);
        if (this.heK != null) {
            this.heK.M(wVar);
        }
        if (this.heL != null) {
            this.heL.I(wVar);
        }
        if (this.heO != null) {
            this.heO.L(wVar);
        }
        if (this.heS != null) {
            this.heS.a(wVar);
        }
        np(false);
        if (this.heP != null) {
            this.heP.i(wVar);
            this.heP.nc(this.hgO);
            this.heP.updateView();
            if (wVar != null && this.hgw != null && !this.hgw.hasInit && !TextUtils.isEmpty(this.hgw.aRg)) {
                this.hgw.hasInit = true;
                this.heP.Id(this.hgw.aRg);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(q qVar) {
        if (qVar != null) {
            if (this.heJ != null && qVar.getList() != null) {
                this.heJ.e(qVar);
            }
            if (this.heN != null) {
                this.heN.eZ(qVar.getCount());
            }
        }
    }

    private void cao() {
        if (this.hfO != null) {
            this.hfO.ax(cbW().hpQ.getLiveContainerView());
        }
    }

    private void ccj() {
        if (this.heT == null) {
            this.heT = new com.baidu.tieba.ala.liveroom.c.a(cbW().pageContext);
        }
        if (cbW().hpR != null && cbW().hpR.Iq() != null && cbW().hpR.Iq().mLiveInfo != null) {
            this.heT.Ie(String.valueOf(cbW().hpR.Iq().mLiveInfo.user_id));
        }
    }

    private void cck() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (cbW() != null && cbW().hpR != null && cbW().hpR.Iq() != null && cbW().hpR.Iq().mLiveInfo != null) {
                j = cbW().hpR.Iq().mLiveInfo.room_id;
            }
            if (this.hgc == null) {
                this.hgc = new com.baidu.tieba.ala.liveroom.guide.a(cbW().pageContext, j);
            }
            this.hgc.nh(this.hgH);
            this.hgc.a(new a.InterfaceC0689a() { // from class: com.baidu.tieba.ala.liveroom.d.d.8
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0689a
                public void cct() {
                    if (d.this.brc != null) {
                        d.this.brc.cu(true);
                    }
                }
            });
            this.hgc.at(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void eb(int i) {
        super.eb(i);
        cao();
        if (this.heS != null) {
            this.heS.eb(i);
        }
    }

    private void cas() {
        if (this.buZ == null) {
            this.buZ = new PendantParentView(cbW().pageContext.getPageActivity(), this.gGE ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            cbW().hpS.addView(this.buZ, new ViewGroup.LayoutParams(-1, -1));
            this.buZ.setDefaultItemMargin(cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.buZ.setPadding(cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            ccl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccl() {
        int dimensionPixelSize;
        if (this.buZ != null) {
            this.buZ.setModel(this.gGE ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            int dimensionPixelSize2 = cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds220);
            int dimensionPixelSize3 = cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            if (this.gGE) {
                dimensionPixelSize = ccr();
            } else {
                dimensionPixelSize = cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds200);
            }
            this.buZ.setPosition(dimensionPixelSize2, 0, dimensionPixelSize, dimensionPixelSize3);
            return;
        }
        cas();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccm() {
        if (cbW().hpS != null && !this.hhK) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.9
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.heX != null && d.this.hfU != null && d.this.hfU.Nd() != null && d.this.hfU.Nd().getView() != null) {
                        if (d.this.gGE && !d.this.hgI && d.this.cbW().hpS != null && d.this.cbW().hpS.getHeight() > 0) {
                            int bu = d.this.heS != null ? d.this.heS.bu(false) : 0;
                            ViewGroup.LayoutParams layoutParams = d.this.heX.getLayoutParams();
                            int height = d.this.cbW().hpS.getHeight() - bu;
                            int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                i += UtilHelper.getStatusBarHeight();
                            }
                            if (layoutParams != null && d.this.hfU != null) {
                                layoutParams.height = i + d.this.cbW().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                                d.this.heX.setLayoutParams(layoutParams);
                                ViewGroup.LayoutParams layoutParams2 = d.this.hfU.Nd().getView().getLayoutParams();
                                if (layoutParams2 != null) {
                                    layoutParams2.height = layoutParams.height - com.baidu.live.ak.c.dl(false);
                                    d.this.hfU.Nd().getView().setLayoutParams(layoutParams2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        int i2 = com.baidu.live.ak.c.i(false, d.this.hgI);
                        if (d.this.hgF.indexOfChild(d.this.heX) != -1 && d.this.heX.getLayoutParams() != null) {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) d.this.heX.getLayoutParams();
                            layoutParams3.height = com.baidu.live.ak.c.c(false, false, d.this.hgI);
                            d.this.heX.setLayoutParams(layoutParams3);
                        }
                        if (d.this.heX.indexOfChild(d.this.hfU.Nd().getView()) != -1 && d.this.hfU.Nd().getView().getLayoutParams() != null) {
                            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) d.this.hfU.Nd().getView().getLayoutParams();
                            layoutParams4.height = i2;
                            d.this.hfU.Nd().getView().setLayoutParams(layoutParams4);
                        }
                        d.this.hfU.Nd().Nc();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccn() {
        if (cbW().hpS != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.10
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.hfW != null) {
                        if (d.this.gGE && !d.this.hgI && d.this.cbW().hpS != null && d.this.cbW().hpS.getHeight() > 0) {
                            int height = (d.this.cbW().hpS.getHeight() - (d.this.heS != null ? d.this.heS.bu(false) : 0)) + d.this.cbW().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            if (d.this.hfW != null) {
                                d.this.hfW.ek(height);
                            }
                        } else if (d.this.hfW != null) {
                            d.this.hfW.ek(com.baidu.live.ak.a.a(d.this.cbW().pageContext.getPageActivity(), false, false, d.this.hgI));
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cco() {
        if (cbW().hpS != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.11
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    if (d.this.hfW != null) {
                        int h = com.baidu.live.ak.a.h(false, false);
                        if (!d.this.gGE || d.this.cbW().hpS == null || d.this.cbW().hpS.getHeight() <= 0) {
                            i = h;
                        } else {
                            int height = d.this.cbW().hpS.getHeight() - (d.this.heS != null ? d.this.heS.bu(false) : 0);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            i = height + d.this.cbW().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                        }
                        if (d.this.hfW != null) {
                            d.this.hfW.el(i);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccp() {
        if (this.hfV != null && this.hfV.DL() != null) {
            ViewGroup.LayoutParams layoutParams = this.hfV.DL().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = cbW().pageContext.getResources().getDimensionPixelOffset(this.gGE ? a.d.sdk_ds100 : a.d.sdk_ds20);
                this.hfV.DL().setLayoutParams(layoutParams);
            }
        }
    }

    private void ccq() {
        if (this.hhE == null) {
            this.hhE = new LinearLayout(cbW().pageContext.getPageActivity());
            this.hhE.setOrientation(1);
        }
        if (this.hhE.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds160);
            layoutParams.leftMargin = cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            cbW().hpS.addView(this.hhE, layoutParams);
        }
    }

    private void cau() {
        if (this.heP == null) {
            this.heP = new com.baidu.tieba.ala.liveroom.activeview.b(cbW().pageContext);
        }
        if (cbW() != null && cbW().hpR != null) {
            this.heP.Ia(cbW().hpR.cjO());
        }
        this.heP.bd(this.gGE);
        this.heP.setOtherParams(Oj());
        this.heP.b(cbW().hpR.Iq(), false);
        this.heP.setHost(false);
        this.heP.nc(this.hgO);
        this.heP.a(1, this.buZ);
        this.heP.a(2, this.buZ);
        this.heP.setVisible(this.hgI ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caA() {
        if (this.hfE == null) {
            caG();
        }
        this.hfE.setOtherParams(Oj());
        this.hfE.a(com.baidu.live.ae.e.RP().bxB, cbW().hpR.Iq());
    }

    private void cav() {
        if (this.heO == null) {
            this.heO = new com.baidu.tieba.ala.liveroom.l.a(cbW().pageContext, this);
        }
        this.heO.setOtherParams(Oj());
        this.heO.a((ViewGroup) this.buZ, caz());
        this.heO.L(cbW().hpR.Iq());
    }

    private void car() {
        if (cbW() != null) {
            if (this.hgr == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913271, com.baidu.live.a.a.class, cbW().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hgr = (com.baidu.live.a.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hgr.bd(this.gGE);
            this.hgr.bf(false);
            this.hgr.a(caU(), cbW().hpR.Iq());
        }
    }

    private void caw() {
        if (this.hgh == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, j.class, cbW().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hgh = (j) runTask.getData();
            } else {
                return;
            }
        }
        this.hgh.setOtherParams(Oj());
        if (this.heX != null && this.heX.indexOfChild(this.hgh.getView()) >= 0) {
            this.heX.removeView(this.hgh.getView());
        }
    }

    private void cax() {
        if (this.hfE != null) {
            this.hfE.a(new a.InterfaceC0695a() { // from class: com.baidu.tieba.ala.liveroom.d.d.13
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0695a
                public void bS(int i, int i2) {
                    w Iq = d.this.cbW().hpR.Iq();
                    if (Iq != null && Iq.mLiveInfo != null) {
                        if (d.this.hgk == null) {
                            d.this.hgk = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.cbW().pageContext.getPageActivity());
                        }
                        d.this.hgk.d(d.this.hgF, i, i2);
                        d.this.hgk.a(String.valueOf(Iq.mLiveInfo.live_id), new a.InterfaceC0699a() { // from class: com.baidu.tieba.ala.liveroom.d.d.13.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0699a
                            public void a(float f, String str) {
                                if (d.this.hfE != null) {
                                    d.this.hfE.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0695a
                public void bT(int i, int i2) {
                    if (d.this.hgk != null) {
                        d.this.hgk.bY(i, i2);
                    }
                }
            });
        }
    }

    private void cay() {
        if (this.hgU == null) {
            this.hgU = new com.baidu.tieba.ala.liveroom.j.e(cbW().pageContext);
        }
        this.hgU.setRoomId(cbW().hpR.Iq().mLiveInfo.room_id);
        this.hgU.It("");
        this.hgU.b(cbW().hpR.Iq(), this.buZ);
        if (this.hfg == null) {
            this.hfg = new com.baidu.tieba.ala.liveroom.j.b(cbW().pageContext, Oj(), this.hgU, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.14
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void caX() {
                    d.this.ni(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void caY() {
                    d.this.ni(false);
                }
            });
        }
        this.hfg.setRoomId(cbW().hpR.Iq().mLiveInfo.room_id);
        if (this.heX != null && this.heX.indexOfChild(this.hfg.getView()) >= 0) {
            this.heX.removeView(this.hfg.getView());
        }
        if (this.hfg != null) {
            this.hfg.b(cbW());
        }
    }

    private void caO() {
        if (this.hhH == null) {
            this.hhH = new com.baidu.tieba.ala.liveroom.apppromotion.a(cbW().pageContext);
        }
        this.hhH.b(caU(), cbW().hpR.Iq());
    }

    private LinearLayout.LayoutParams caz() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    private void caB() {
        CustomResponsedMessage runTask;
        if (this.hfU == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, cbW().pageContext)) != null && runTask.getData() != null) {
            this.hfU = (k) runTask.getData();
            this.hfU.setFromMaster(false);
            this.hfU.Nd().getView().setId(a.f.ala_liveroom_msg_list);
            this.hfU.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.15
                @Override // com.baidu.live.im.k.a
                public boolean Nh() {
                    return d.this.Le();
                }

                @Override // com.baidu.live.im.k.a
                public void Ni() {
                    d.this.hgM = true;
                }

                @Override // com.baidu.live.im.k.a
                public void id(String str) {
                    if (!d.this.hgI) {
                        d.this.ng(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.cbW().pageContext.getPageActivity(), d.this.cbW().hpQ.getLiveContainerView());
                    }
                    d.this.Ih(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Nj() {
                    if (d.this.hgI) {
                        d.this.ng(true);
                        d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.15.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.cbW().pageContext.getPageActivity(), d.this.cbW().hpQ.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.hfU != null) {
                        d.this.hfU.Ne().setQuickInputPanelVisible(false);
                        d.this.hfU.Ne().OR();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Nk() {
                    if (d.this.hgI) {
                        d.this.caW();
                        if (d.this.hfV != null) {
                            d.this.hfV.DM();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Nl() {
                    return d.this.cbj();
                }

                @Override // com.baidu.live.im.k.a
                public int Nm() {
                    return d.this.cbk();
                }
            });
            this.heX = new FrameLayout(cbW().pageContext.getPageActivity());
            this.heX.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.hfU != null && this.heX != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(cbW().pageContext.getPageActivity()) * 0.7f);
            int i = com.baidu.live.ak.c.i(false, false);
            if (this.hgF.indexOfChild(this.heX) < 0) {
                if (this.heX.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.heX.getParent()).removeView(this.heX);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.live.ak.c.c(false, false, false));
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.live.ak.c.dk(false);
                this.hgF.addView(this.heX, layoutParams);
            }
            if (this.heX.indexOfChild(this.hfU.Nd().getView()) < 0) {
                if (this.hfU.Nd().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hfU.Nd().getView()).removeView(this.hfU.Nd().getView());
                }
                this.heX.addView(this.hfU.Nd().getView(), new FrameLayout.LayoutParams(equipmentWidth, i));
            }
            if (cbW().hpS.indexOfChild(this.hfU.Ne().getView()) < 0) {
                if (this.hfU.Ne().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hfU.Ne().getView().getParent()).removeView(this.hfU.Ne().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                cbr();
                cbW().hpS.addView(this.hfU.Ne().getView(), layoutParams2);
            }
            w Iq = cbW().hpR.Iq();
            if (Iq != null && Iq.mLiveInfo != null) {
                this.hfU.setLogData(Iq.mLiveInfo.feed_id, Oj());
            }
            this.hfU.a(String.valueOf(cbW().hpR.Iq().mLiveInfo.group_id), String.valueOf(cbW().hpR.Iq().mLiveInfo.last_msg_id), String.valueOf(cbW().hpR.Iq().aJV.userId), String.valueOf(cbW().hpR.Iq().mLiveInfo.live_id), cbW().hpR.Iq().aJV.appId, (Iq == null || Iq.aKI == null || !Iq.aKI.Fb()) ? false : true, cbW().hpR.Iq().getGuardName());
            ng(false);
        }
    }

    private void caE() {
        if (this.heK == null) {
            this.heK = new com.baidu.tieba.ala.liveroom.o.a(cbW().pageContext, false, this);
        }
        this.heK.e(this.hgE, cbW().hpR.Iq());
        this.heK.a(this.hfu);
        this.heK.setOtherParams(Oj());
    }

    private void caF() {
        if (this.heJ == null) {
            this.heJ = new com.baidu.tieba.ala.liveroom.audiencelist.c(cbW().pageContext, this, false);
        }
        this.heJ.a(String.valueOf(cbW().hpR.Iq().mLiveInfo.group_id), String.valueOf(cbW().hpR.Iq().mLiveInfo.live_id), String.valueOf(cbW().hpR.Iq().aJV.userId), cbW().hpR.Iq());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.f.ala_liveroom_hostheader;
            if (this.hfF != null && this.hfF.getView() != null && this.hfF.getView().getParent() != null) {
                i = a.f.ala_liveroom_guardthrone;
            }
            this.heJ.c(this.hgE, i, a.f.ala_liveroom_audience_count_layout);
            this.heJ.e(cbW().hpR.bUt());
            this.heJ.setOtherParams(Oj());
        }
    }

    private void caG() {
        com.baidu.live.core.a.a Pc;
        if (this.hfE == null) {
            this.hfE = new com.baidu.tieba.ala.liveroom.operation.a(cbW().pageContext);
        }
        this.hfE.a(cbW(), this.hgF, cbW().hpR.Iq().mLiveInfo, true, this.hfu);
        this.hfE.setOtherParams(Oj());
        if (this.hgf != null && (Pc = this.hgf.Pc()) != null) {
            View rootLayout = Pc.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.hfE.cp(rootLayout);
        }
    }

    private void caC() {
        cbq();
    }

    public void no(boolean z) {
        if (this.hfE != null) {
            this.hfE.no(z);
        }
    }

    private void caJ() {
        if (this.heN == null) {
            this.heN = new com.baidu.tieba.ala.liveroom.audiencelist.b(cbW().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (cbW().hpR.bUt() != null) {
            j = cbW().hpR.bUt().getCount();
        }
        this.heN.a(this.hfu);
        this.heN.a(this.hgE, a.f.ala_liveroom_hostheader, j);
        this.heN.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.heN.ns(false);
        } else {
            this.heN.ns(true);
        }
    }

    protected void Ii(String str) {
        if (this.hgT == null) {
            this.hgT = new com.baidu.tieba.ala.liveroom.t.b(cbW().pageContext);
        }
        this.hgT.c(this.hgF, str);
        ni(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.16
            @Override // java.lang.Runnable
            public void run() {
                d.this.hgT.ckn();
                d.this.ni(false);
            }
        }, 5000L);
    }

    private void np(boolean z) {
        CustomResponsedMessage runTask;
        if (cbW().hpR.Iq().mLiveInfo.live_type == 1 && this.hhG) {
            if (this.hhF == null && (runTask = MessageManager.getInstance().runTask(2913074, e.class, cbW().pageContext)) != null && runTask.getData() != null) {
                this.hhF = (e) runTask.getData();
            }
            if (this.hhF != null) {
                if (this.heR == null) {
                    this.heR = this.hhF.a(cbW().pageContext);
                }
                if (z) {
                    this.heR.Ev();
                }
                if (cbW().hpR.Iq().mLiveInfo.challengeId > 0 && !this.heR.ED()) {
                    this.heR.e(cbW().hpR.Iq().mLiveInfo.live_id, cbW().hpR.Iq().aJV.userId);
                    nq(z);
                    if (z) {
                        this.heR.a(cbW().hpR.ciV());
                    }
                    this.heR.c(cbW().hpR.Iq());
                }
            }
        }
    }

    private void nq(boolean z) {
        if (this.heS == null) {
            this.heS = this.hhF.b(cbW().pageContext);
            this.heS.a(new com.baidu.live.challenge.g() { // from class: com.baidu.tieba.ala.liveroom.d.d.17
                @Override // com.baidu.live.challenge.g
                public void Er() {
                    d.this.cbW().hpS.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.g
                public void a(ba baVar, be beVar, be beVar2) {
                    d.this.gGE = true;
                    if (d.this.hfL != null) {
                        d.this.hfL.ww(8);
                    }
                    if (d.this.hfM != null) {
                        d.this.hfM.setPraiseEnable(false);
                        d.this.cbW().hpS.hFs = false;
                    }
                    if (d.this.hgq != null) {
                        d.this.hgq.setCanVisible(false);
                    }
                    if (d.this.hfN != null) {
                        d.this.hfN.cky();
                    }
                    if (d.this.heO != null) {
                        d.this.heO.setCanVisible(false);
                        d.this.heO.cfu();
                    }
                    if (d.this.heP != null) {
                        d.this.heP.bd(true);
                    }
                    if (d.this.hgU != null) {
                        d.this.hgU.setVisible(8);
                    }
                    if (d.this.heQ != null) {
                        d.this.heQ.setCanVisible(false);
                        d.this.heQ.setVisible(8);
                    }
                    if (d.this.hgr != null) {
                        d.this.hgr.bd(true);
                        d.this.hgr.be(true);
                    }
                    d.this.ccl();
                    d.this.ccm();
                    d.this.ccn();
                    d.this.cco();
                    d.this.ccp();
                    if (d.this.cbW().brf != null) {
                        d.this.cbW().brf.getLivePlayer().setBackgroundResource(a.c.sdk_transparent);
                    }
                    if (d.this.hfK != null) {
                        d.this.hfK.setTimeTextMode(true);
                    }
                    if (d.this.brc != null && beVar != null && beVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(beVar.aPX);
                        arrayList.add(beVar2.aPX);
                        com.baidu.live.liveroom.a.c cVar = d.this.brc;
                        if (d.this.hgQ) {
                            arrayList = null;
                        }
                        cVar.o(arrayList);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void Es() {
                }

                @Override // com.baidu.live.challenge.g
                public void Et() {
                }

                @Override // com.baidu.live.challenge.g
                public void bs(boolean z2) {
                    d.this.cbW().hpS.setSwipeClearEnable(true);
                    d.this.gGE = false;
                    if (d.this.hfL != null) {
                        d.this.hfL.ww(0);
                    }
                    if (d.this.hfM != null) {
                        d.this.hfM.setPraiseEnable(true);
                        d.this.cbW().hpS.hFs = true;
                    }
                    if (d.this.hgq != null) {
                        d.this.hgq.setCanVisible(true);
                    }
                    if (d.this.hfN != null) {
                        d.this.hfN.ckz();
                    }
                    if (d.this.heO != null) {
                        d.this.heO.setCanVisible(true);
                        d.this.heO.L(d.this.cbW().hpR.Iq());
                    }
                    if (d.this.hfP != null) {
                        d.this.hfP.on(true);
                    }
                    if (d.this.heP != null) {
                        d.this.heP.bd(false);
                    }
                    if (d.this.hgU != null) {
                        d.this.hgU.setVisible(0);
                    }
                    if (d.this.heQ != null) {
                        d.this.heQ.setCanVisible(true);
                        d.this.heQ.setVisible(0);
                    }
                    if (d.this.hgr != null) {
                        d.this.hgr.bd(false);
                        d.this.hgr.be(false);
                    }
                    d.this.ccl();
                    d.this.ccm();
                    d.this.ccn();
                    d.this.cco();
                    d.this.ccp();
                    if (d.this.brc != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.cbW().hpR.cjK());
                        com.baidu.live.liveroom.a.c cVar = d.this.brc;
                        if (d.this.hgQ) {
                            arrayList = null;
                        }
                        cVar.o(arrayList);
                    }
                    if (d.this.cbW().brf != null) {
                        d.this.cbW().brf.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
                    }
                    if (d.this.hfK != null) {
                        d.this.hfK.setTimeTextMode(false);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void bt(boolean z2) {
                    if (z2 && d.this.hgu != null) {
                        d.this.hgu.onClose();
                    }
                }
            });
        }
        this.heS.a(this.heR);
        this.heS.i(cbW().hpQ.getLiveContainerView());
        this.heS.b(z, false, false);
        this.heR.a((i.c) this.heS);
    }

    public void caK() {
        this.hfH.c(cbW().hpR.Iq(), false);
    }

    public void caL() {
        if (cbW().hpR.Iq() != null && cbW().hpR.Iq().aJV != null && cbW().hpR.Iq().mLiveInfo != null) {
            if (this.heM == null) {
                this.heM = new com.baidu.tieba.ala.liveroom.u.b(cbW().pageContext);
            }
            long j = cbW().hpR.Iq().aJV.userId;
            int i = cbW().hpR.Iq().mLiveInfo.live_type;
            String str = cbW().hpR.Iq().aJV.portrait;
            String str2 = cbW().hpR.Iq().mLiveInfo.feed_id;
            long j2 = cbW().hpR.Iq().mLiveInfo.live_id;
            this.heM.a(i, j, cbW().hpR.Iq().aJV.userName, false, str, Oj(), str2, j2);
            this.heM.at(this.hgE);
        }
    }

    private int ccr() {
        return (this.heS != null ? this.heS.bu(false) : 0) + cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
    }

    private void caM() {
        boolean z = true;
        if (this.hfP == null) {
            this.hfP = new com.baidu.tieba.ala.liveroom.w.a(cbW().pageContext, this);
        }
        this.hfP.c(cbW().hpS, false);
        AlaLiveInfoData alaLiveInfoData = cbW().hpR.Iq().mLiveInfo;
        if (alaLiveInfoData != null) {
            boolean z2 = cbV() && alaLiveInfoData.screen_direction != 2;
            boolean isZanAnimUnabled = alaLiveInfoData.mAlaLiveSwitchData != null ? alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled() : false;
            if (!z2 || isZanAnimUnabled) {
                z = false;
            }
            this.hfP.om(z);
        }
    }

    private void caP() {
        if (this.hgM || this.hgN) {
            if ((TbadkCoreApplication.isLogin() && this.hfU.Ne().hasText()) || this.hgN) {
                this.hgM = false;
                this.hgN = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.19
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.cbp();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void caH() {
        caI();
    }

    private void caI() {
        if (this.hfE != null) {
            int i = cbW().hpR.Iq().aKr.isUegBlock;
            int i2 = cbW().hpR.Iq().aKr.isBlock;
            String str = cbW().hpR.Iq().aKr.userName;
            if (i > 0 || i2 > 0) {
                this.hfE.b(true, i, i2, str);
                this.hfU.a(true, i, i2, str);
                this.hga.b(true, i, i2, str);
                return;
            }
            this.hfE.b(false, i, i2, str);
            this.hfU.a(false, i, i2, str);
            this.hga.b(false, i, i2, str);
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
        if (this.heP != null) {
            this.heP.G(bVar);
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
                    if (this.heO != null) {
                        this.heO.J(jSONObject2);
                    }
                } else if ("enter_live".equals(optString)) {
                    if (this.heN != null && this.heN.getCount() > 20) {
                        this.heN.eZ(this.heN.getCount() + 1);
                    } else if (this.heJ != null) {
                        com.baidu.live.data.a NU = bVar.NU();
                        p pVar = new p();
                        pVar.aJW = new AlaLocationData();
                        pVar.aJX = new AlaRelationData();
                        pVar.aJV = new AlaLiveUserInfoData();
                        pVar.aJV.userId = JavaTypesHelper.toLong(NU.userId, 0L);
                        pVar.aJV.userName = NU.userName;
                        pVar.aJV.portrait = NU.portrait;
                        if (this.heN != null && this.heJ.c(pVar)) {
                            this.heN.eZ(this.heN.getCount() + 1);
                        }
                    }
                } else if ("update_liveinfo".equals(optString)) {
                    if (cbW().hpR.Iq() != null && cbW().hpR.Iq().mLiveInfo != null) {
                        cbW().hpR.a(cbW().hpR.Iq().mLiveInfo.live_id, cbW().fromType, cbW().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && cbW().hpR.Iq() != null && cbW().hpR.Iq().mLiveInfo != null && cbW().hpR.Iq().aKr != null && this.heS != null) {
                    long optLong = jSONObject2.optLong("mvp_user_id");
                    long optLong2 = jSONObject2.optLong("winner_live_id");
                    if (optLong == cbW().hpR.Iq().aKr.userId && optLong2 == cbW().hpR.Iq().mLiveInfo.live_id) {
                        this.heS.c(jSONObject2.optInt("challenge_status"), jSONObject2.optLong("challenge_id"));
                    }
                }
            } else {
                return;
            }
        }
        if (this.hgq == null || this.hgq.N(jSONObject2)) {
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void Ic(String str) {
        if (this.heP != null) {
            this.heP.Ic(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hgC != null) {
            this.hgC.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void cz(boolean z) {
        super.cz(z);
        if (cbW().hpS != null) {
            cbW().hpS.clk();
            cbW().hpS.setLiveViewOnDispatchTouchEventListener(null);
            cbW().hpS.setLiveViewOnTouchEventListener(null);
            cbW().hpS.setOnLiveViewScrollListener(null);
        }
        if (cbW().brf != null) {
            cbW().brf.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
        }
        if (this.heS != null) {
            this.heS.En();
        }
        caQ();
        if (this.heM != null) {
            this.heM.En();
        }
        if (this.hfP != null) {
            this.hfP.release();
        }
        if (this.heO != null) {
            this.heO.En();
        }
        if (this.hfE != null) {
            this.hfE.cjR();
        }
        if (this.heL != null) {
            this.heL.cer();
            this.heL.setVisible(8);
        }
        if (this.heQ != null) {
            this.heQ.En();
        }
        if (this.heP != null) {
            this.heP.release();
        }
        if (this.buZ != null) {
            this.buZ.removeAllViews();
            this.buZ = null;
        }
        if (this.hhE != null) {
            this.hhE.removeAllViews();
            this.hhE = null;
        }
        if (this.hfP != null) {
            this.hfP.onDestroy();
        }
        if (this.heR != null) {
            this.heR.En();
        }
        if (this.heK != null) {
            this.heK.cgs();
        }
        if (this.hfg != null) {
            this.hfg.cancel();
        }
        if (this.hgU != null) {
            this.hgU.cdl();
        }
        if (this.hhH != null) {
            this.hhH.Do();
        }
        if (this.hgq != null) {
            this.hgq.Do();
        }
        if (this.heW != null) {
            this.heW.Do();
        }
        if (this.hfg != null) {
            this.hfg.En();
        }
        if (this.hgy != null) {
            this.hgy.En();
        }
        if (this.hgC != null) {
            this.hgC.SB();
        }
        if (cbW().hpT != null) {
            cbW().hpT.setTalentShowing(false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cx(boolean z) {
        super.cx(z);
        caQ();
        if (this.heK != null) {
            this.heK.onDestroy();
        }
        if (this.heM != null) {
            this.heM.onDestroy();
        }
        if (this.heO != null) {
            this.heO.onDestroy();
        }
        if (this.heQ != null) {
            this.heQ.onDestroy();
        }
        if (this.heR != null) {
            this.heR.onDestroy();
        }
        if (this.heS != null) {
            this.heS.onDestroy();
        }
        if (this.heT != null) {
            this.heT.onDestroy();
        }
        if (this.hgc != null) {
            this.hgc.onDestroy();
        }
        if (this.heL != null) {
            this.heL.onDestroy();
        }
        if (this.heJ != null) {
            this.heJ.onDestroy();
        }
        if (this.hfU != null) {
            this.hfU.onDestroy();
        }
        if (this.hfE != null) {
            this.hfE.onDestory();
        }
        if (this.heP != null) {
            this.heP.release();
        }
        if (this.hgU != null) {
            this.hgU.cx(!z);
        }
        if (this.heW != null) {
            this.heW.onDestroy();
        }
        if (this.hfg != null) {
            this.hfg.onDestroy();
            this.hfg = null;
        }
        if (this.hgy != null) {
            this.hgy.onDestroy();
        }
        if (this.hgC != null) {
            this.hgC.onDestroy();
        }
        if (cbW().hpT != null) {
            cbW().hpT.setTalentShowing(false);
        }
        if (this.hhH != null) {
            this.hhH.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.hfi);
        MessageManager.getInstance().removeMessageRule(this.hfh);
        MessageManager.getInstance().removeMessageRule(this.hfj);
        MessageManager.getInstance().removeMessageRule(this.hfk);
        MessageManager.getInstance().unRegisterListener(this.hfn);
        MessageManager.getInstance().unRegisterListener(this.hfp);
        MessageManager.getInstance().unRegisterListener(this.hfr);
        MessageManager.getInstance().unRegisterListener(this.hfs);
        MessageManager.getInstance().unRegisterListener(this.hhI);
        MessageManager.getInstance().unRegisterListener(this.hft);
        MessageManager.getInstance().unRegisterListener(this.hfq);
        MessageManager.getInstance().unRegisterListener(this.hfo);
    }

    private void caQ() {
        if (this.hfU != null && this.hfU.Nd().getView() != null && this.hfU.Nd().getView().getParent() != null) {
            ((ViewGroup) this.hfU.Nd().getView().getParent()).removeView(this.hfU.Nd().getView());
        }
        if (this.heX != null && this.heX.getParent() != null) {
            ((ViewGroup) this.heX.getParent()).removeView(this.heX);
        }
        if (this.hfU != null && this.hfU.Ne().getView() != null) {
            this.hgF.removeView(this.hfU.Ne().getView());
        }
        if (this.hfU != null) {
            this.hfU.Nd().setMsgData(new LinkedList());
            this.hfU.DN();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void a(ar arVar) {
        if (this.hfU != null) {
            cbp();
            this.hfU.Ne().setEditText(" @" + arVar.getNameShow() + " ");
        }
        if (this.hfE != null) {
            this.hfE.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void g(com.baidu.live.data.a aVar) {
        if (this.hfU != null) {
            cbp();
            this.hfU.Ne().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.hfE != null) {
            this.hfE.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void If(String str) {
        if (this.hfU != null) {
            cbp();
            StringBuilder sb = new StringBuilder();
            sb.append(" @");
            sb.append(str);
            sb.append(" ");
            if (com.baidu.live.ae.a.RB().brA.aOc != null && com.baidu.live.ae.a.RB().brA.aOc.originTexts != null && com.baidu.live.ae.a.RB().brA.aOc.originTexts.size() > 0) {
                this.hfU.Ne().OS();
                this.hfU.Ne().setEditText(sb.toString() + com.baidu.live.ae.a.RB().brA.aOc.originTexts.get(0));
            } else {
                this.hfU.Ne().setEditText(sb.toString());
            }
        }
        if (this.hfE != null) {
            this.hfE.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void b(ar arVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected View caR() {
        if (this.hfU != null) {
            return this.hfU.Ne().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean caS() {
        if (this.hfU == null || !this.hfU.Ne().OQ()) {
            return false;
        }
        ng(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected boolean caT() {
        return this.heK == null || this.heK.caT();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    /* renamed from: ccs */
    public PendantParentView caU() {
        return this.buZ;
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
                    this.hgJ = false;
                    N(intExtra, intExtra2, intExtra3);
                    return;
                }
                caK();
                return;
            }
            ays();
        } else if (i == 25051 && i2 == -1 && this.hgU != null) {
            this.hgU.cfl();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.hfU != null && this.hfU.Nd() != null) {
            this.hfU.Nd().onKeyboardVisibilityChanged(z);
        }
        if (z || this.hfU == null || this.hfU.Ne() == null || !this.hfU.Ne().OQ()) {
            if (z) {
                if (this.hfE != null) {
                    this.hfE.setVisibility(8);
                }
                if (this.hfW != null && this.hfW.HN() != null) {
                    this.hfW.HN().setVisibility(8);
                }
                caW();
                if (this.hfU != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hfU.Ne().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.hfU.Ne().getView().setLayoutParams(layoutParams);
                    this.hfU.Ne().getView().setVisibility(0);
                    this.hfU.Ne().setQuickInputPanelVisible(false);
                    this.hfU.Nf().cp(false);
                }
                if (this.hgE != null) {
                    this.hgE.setVisibility(8);
                }
                if (this.heP != null) {
                    this.heP.setVisible(8);
                }
                if (this.hfV != null) {
                    this.hfV.DM();
                }
                if (this.hgx != null) {
                    this.hgx.setCanVisible(false);
                }
                if (this.hgo != null) {
                    this.hgo.setCanVisible(false);
                }
                if (this.hgq != null) {
                    this.hgq.setCanVisible(false);
                }
                if (this.hgr != null) {
                    this.hgr.setCanVisible(false);
                }
                if (this.hgs != null) {
                    this.hgs.setCanVisible(false);
                }
                if (this.hgt != null) {
                    this.hgt.setVisible(8);
                }
                if (this.hhH != null) {
                    this.hhH.setCanVisible(false);
                }
            } else {
                caV();
            }
            ccm();
            if (this.hgi != null) {
                this.hgi.bD(z);
            }
        }
    }

    private void caV() {
        if (this.hfE != null) {
            this.hfE.setVisibility(0);
        }
        if (this.heX != null) {
            if (this.hhK) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.heX.getLayoutParams();
                layoutParams.bottomMargin = (M(false, false) - cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) + com.baidu.live.ak.c.Ws();
                this.heX.setLayoutParams(layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.heX.getLayoutParams();
                layoutParams2.bottomMargin = cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds90);
                this.heX.setLayoutParams(layoutParams2);
            }
        }
        if (this.hfU != null) {
            cbr();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hfU.Ne().getView().getLayoutParams();
            layoutParams3.bottomMargin = 0;
            this.hfU.Ne().getView().setLayoutParams(layoutParams3);
            if (this.hfU.Nf().isClicked()) {
                this.hfU.Nf().cp(false);
            } else {
                this.hfU.Nf().cp(true);
            }
        }
        if (this.hfE != null) {
            this.hfE.setVisibility(0);
        }
        if (this.hfW != null && this.hfW.HN() != null) {
            this.hfW.HN().setVisibility(0);
        }
        if (this.hgE != null) {
            this.hgE.setVisibility(0);
        }
        if (this.heP != null) {
            this.heP.setVisible(0);
        }
        if (this.hfV != null) {
            this.hfV.DM();
        }
        if (this.hgx != null) {
            this.hgx.setCanVisible(true);
        }
        if (this.hgo != null) {
            this.hgo.setCanVisible(true);
        }
        if (this.hgs != null) {
            this.hgs.setCanVisible(true);
        }
        if (this.hgt != null) {
            this.hgt.setVisible(0);
        }
        if (this.hgq != null) {
            this.hgq.setCanVisible(!this.gGE);
        }
        if (this.hgr != null) {
            this.hgr.setCanVisible(true);
        }
        if (this.hhH != null) {
            this.hhH.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caW() {
        boolean z;
        boolean z2 = false;
        if (this.heX != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.heX.getLayoutParams();
            if (this.hfU == null || this.hfU.Ne() == null) {
                z = false;
            } else {
                z = this.hfU.Ne().OO();
                z2 = this.hfU.Ne().OP();
            }
            int M = M(z, z2);
            if (layoutParams.bottomMargin != M) {
                layoutParams.bottomMargin = M;
                this.heX.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ng(boolean z) {
        this.hhJ = z;
        if (z) {
            this.hfU.Ne().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.heX.getLayoutParams();
            int quickInputPanelExpandHeight = this.hfU.Ne().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.heX.setLayoutParams(layoutParams);
                if (this.hfU.Nd() != null) {
                    this.hfU.Nd().Nc();
                    return;
                }
                return;
            }
            return;
        }
        caV();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.heJ != null) {
                this.heJ.dX(i3);
            }
            if (this.heL != null) {
                this.heL.dX(i3);
            }
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public boolean fh(int i) {
        boolean fh = super.fh(i);
        if (fh && 2 == i) {
            if (this.heK.caT()) {
                return false;
            }
            if (fh && this.hfP != null) {
                this.hfP.on(false);
            }
        }
        return fh;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void wy(int i) {
        super.wy(i);
        if (i == 7 || i == 11) {
            if (this.hfE != null) {
                this.hfE.setVisibility(8);
            }
            if (this.hfU != null) {
                this.hfU.Nd().getView().setVisibility(4);
                this.hfU.Nf().getView().setVisibility(4);
            }
            if (this.heP != null) {
                this.heP.bQ(2, 8);
                if (this.gGE) {
                    this.heP.bQ(1, 8);
                }
            }
            if (this.hgk != null) {
                this.hgk.oh(false);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public void fi(int i) {
        super.fi(i);
        if (i == 7 || i == 11) {
            if (this.hfE != null) {
                this.hfE.setVisibility(0);
            }
            if (this.hfU != null) {
                this.hfU.Nd().getView().setVisibility(0);
                if (!this.hfU.Nf().isClicked()) {
                    this.hfU.Nf().cp(true);
                }
            }
            if (this.heP != null) {
                this.heP.setVisible(0);
            }
            if (this.hgk != null) {
                this.hgk.oh(true);
            }
            this.hgE.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.heM != null) {
            this.heM.ckp();
        }
        if (this.heR != null) {
            this.heR.Ew();
        }
        if (this.heP != null) {
            this.heP.onStop();
        }
        if (this.heQ != null) {
            this.heQ.br(true);
        }
        if (this.hgC != null) {
            this.hgC.onStopped();
        }
        if (this.hgB != null) {
            this.hgB.onStop();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.heM != null) {
            this.heM.cko();
        }
        if (this.heR != null && this.hhG) {
            this.heR.Ex();
        }
        if (this.heP != null) {
            this.heP.onStart();
        }
        if (this.heQ != null) {
            this.heQ.br(false);
        }
        if (this.hgC != null) {
            this.hgC.onStarted();
        }
        if (this.hgB != null) {
            this.hgB.onStart();
        }
        if (this.hhH != null) {
            this.hhH.onStart();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        if (!onKeyDown && i == 4 && this.hgC != null && this.hgC.onKeyDown(i, keyEvent)) {
            return true;
        }
        return onKeyDown;
    }
}
