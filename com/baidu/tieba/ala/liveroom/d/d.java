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
    private boolean gGG;
    private com.baidu.tieba.ala.liveroom.audiencelist.c heL;
    private com.baidu.tieba.ala.liveroom.o.a heM;
    private com.baidu.tieba.ala.liveroom.g.b heN;
    private com.baidu.tieba.ala.liveroom.u.b heO;
    private com.baidu.tieba.ala.liveroom.audiencelist.b heP;
    private com.baidu.tieba.ala.liveroom.l.a heQ;
    private com.baidu.tieba.ala.liveroom.activeview.b heR;
    private com.baidu.live.f.a heS;
    private i heT;
    private h heU;
    private com.baidu.tieba.ala.liveroom.c.a heV;
    private FrameLayout heZ;
    private com.baidu.tieba.ala.liveroom.j.b hfi;
    private LinearLayout hhG;
    private e hhH;
    private com.baidu.tieba.ala.liveroom.apppromotion.a hhJ;
    private long lastClickTime = 0;
    private boolean hhI = false;
    private HttpRule hfj = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.heT != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.heT.EC()) {
                httpMessage.addParam("ala_challenge_id", d.this.heT.EF());
            }
            return httpMessage;
        }
    };
    private HttpRule hfk = new HttpRule(1021229) { // from class: com.baidu.tieba.ala.liveroom.d.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.heT != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.heT.EC()) {
                httpMessage.addParam("challenge_id", d.this.heT.EF());
            }
            return httpMessage;
        }
    };
    private HttpRule hfl = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.d.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.heT != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.heT.EC()) {
                httpMessage.addParam("challenge_id", d.this.heT.EF());
            }
            return httpMessage;
        }
    };
    private HttpRule hfm = new HttpRule(1021232) { // from class: com.baidu.tieba.ala.liveroom.d.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.heT != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.heT.EC()) {
                httpMessage.addParam("challenge_id", d.this.heT.EF());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c hfn = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.d.22
        @Override // com.baidu.live.liveroom.g.c
        public void PL() {
            if (d.this.hfR != null) {
                d.this.hfR.on(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cA(boolean z) {
            if (z) {
                if (d.this.hfR != null) {
                    d.this.hfR.on(true);
                }
            } else if (d.this.hfR != null) {
                d.this.hfR.on(false);
            }
            if (d.this.hgk != null) {
                d.this.hgk.bE(z);
            }
            if (d.this.heR != null) {
                d.this.heR.nd(z ? false : true);
            }
            com.baidu.live.p.a.cB(z);
        }
    };
    private HttpMessageListener hfp = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.d.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.PU() != null) {
                        com.baidu.live.ae.e.RP().bxB = getQuickGiftHttpResponseMessage.PU();
                        d.this.caB();
                    }
                }
            }
        }
    };
    CustomMessageListener hfv = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.d.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.hfi.c(d.this.cbX());
                } else if (d.this.cbj() || !g.wL(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.26.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.cbX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.cbX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                    d.this.hfi.b(d.this.heZ, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener hfq = new CustomMessageListener(2913276) { // from class: com.baidu.tieba.ala.liveroom.d.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            JSONObject optJSONObject;
            JSONArray optJSONArray;
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject) && (optJSONObject = ((JSONObject) customResponsedMessage.getData()).optJSONObject("ext_data")) != null && (optJSONArray = optJSONObject.optJSONArray("surprise_prize_member")) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                View inflate = LayoutInflater.from(d.this.activity).inflate(a.g.ala_fudai_dialog_layout, (ViewGroup) null);
                final Dialog dialog = new Dialog(d.this.cbX().pageContext.getPageActivity(), a.i.FudaiDialogStyle);
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
    private CustomMessageListener hhK = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.d.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.cbj() || !g.wL(2913128)) {
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
    private CustomMessageListener hfr = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.hfZ.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hfs = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.this.hgn != null) {
                    d.this.hgn.ir(str);
                }
            }
        }
    };
    CustomMessageListener hft = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.d.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.hgN != null && d.this.hgN.bja != null && !d.this.hgN.bjf && !d.this.hgN.bjg && d.this.hgj != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.cbX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                if (d.this.hfW != null && d.this.hfW.Nf().OY()) {
                    layoutParams.bottomMargin = d.this.cbX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds70);
                } else {
                    layoutParams.bottomMargin = d.this.cbX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                }
                d.this.hgj.b(d.this.heZ, layoutParams);
                if (com.baidu.live.guardclub.e.LY() != null) {
                    com.baidu.live.guardclub.e.LY().Md();
                }
            }
        }
    };
    private CustomMessageListener hfu = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.d.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.hgl != null) {
                    d.this.hgl.dismiss();
                }
                if (d.this.hgn != null) {
                    d.this.hgn.dismiss();
                }
                if (d.this.gTT != null) {
                    d.this.gTT.dismiss();
                }
                com.baidu.live.im.b.d.NK().setSwitchStatus(true);
                com.baidu.live.im.b.d.NK().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.cbq();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b hfw = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.d.18
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
                        if (d.this.cbX().hpT.Iq() != null && d.this.cbX().hpT.Iq().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.cbX().hpT.Iq().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.cbX().hpT.Iq().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.Oj());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.Le()) {
                        if (com.baidu.live.d.BM().getBoolean("quick_gift_guide_show", true) && !d.this.cbj()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, ah.class, d.this.cbX().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                ah ahVar = (ah) runTask.getData();
                                ahVar.setPageContext(d.this.cbX().pageContext);
                                ahVar.setLiveShowData(d.this.cbX().hpT.Iq());
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
                        n.a(d.this.cbX().pageContext, d.this.cbX().hpT.Iq(), com.baidu.live.ae.e.RP().bxB.HW(), d.this.Oj());
                    }
                } else if (i == 1) {
                    if (d.this.hfW != null) {
                        d.this.cbq();
                    }
                } else if (i == 3 && d.this.Le()) {
                    if (com.baidu.live.p.a.isDebug()) {
                        com.baidu.live.p.a.b(d.this.cbX().hpT.Iq().mLiveInfo.live_id, 0);
                        return;
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    d.this.hfJ.c(d.this.cbX().hpT.Iq(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.cbX() != null && d.this.cbX().hpT != null && d.this.cbX().hpT.Iq() != null && d.this.cbX().hpT.Iq().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.cbX().hpT.Iq().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.cbX().hpT.Iq().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.cbX().hpT.Iq().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.Oj());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.cbX() != null && d.this.cbX().hpT != null && d.this.cbX().hpT.Iq() != null && d.this.cbX().hpT.Iq().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.cbX().hpT.Iq().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.cbX().hpT.Iq().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.cbX().hpT.Iq().mLiveInfo.feed_id + "");
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
                    if (d.this.hfR != null && d.this.cbX().hpT.Iq() != null && d.this.cbX().hpT.Iq().mLiveInfo != null) {
                        String valueOf = String.valueOf(d.this.cbX().hpT.Iq().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.cbX().hpT.Iq().mLiveInfo.room_id);
                        String str3 = null;
                        AlaLiveSdkInfo alaLiveSdkInfo = d.this.cbX().hpT.Iq().mLiveSdkInfo;
                        if (alaLiveSdkInfo != null && alaLiveSdkInfo.mCastIds != null) {
                            str3 = String.valueOf(d.this.cbX().hpT.Iq().mLiveSdkInfo.mCastIds.chatMCastId);
                        }
                        d.this.hfR.au(valueOf, valueOf2, str3);
                        com.baidu.live.p.a.b(d.this.cbX().hpT.Iq().mLiveInfo.live_id, 1);
                    }
                } else if (i == 14) {
                    w Iq = d.this.cbX().hpT.Iq();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.cbX().pageContext.getPageActivity(), Iq.aJV.userName, Long.toString(Iq.aJV.userId), Long.toString(Iq.aJV.charmCount), String.valueOf(Iq.mLiveInfo.group_id), String.valueOf(Iq.mLiveInfo.live_id), false, String.valueOf(Iq.aJV.userId), Long.toString(Iq.aKr.userId), Iq.aKr.userName, Iq.aKr.portrait, d.this.heP.getCount(), d.this.Oj())));
                    LogManager.getCommonLogger().doClickGusetNumLog(Iq.mLiveInfo.feed_id, d.this.heP.getCount() + "", d.this.Oj());
                } else if (i == 11) {
                    d.this.cbu();
                    d.this.cbv();
                } else if (i == 16) {
                    if (d.this.cbX() != null && (boVar2 = com.baidu.live.ae.a.RB().bxq) != null && (cfVar2 = boVar2.aQM) != null) {
                        String str4 = cfVar2.aSj.aSq;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (d.this.cbX().hpT != null && d.this.cbX().hpT.Iq() != null && d.this.cbX().hpT.Iq().mLiveInfo != null) {
                                j = d.this.cbX().hpT.Iq().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", d.this.cbX().hpT.Iq().mLiveInfo.room_id + "", d.this.cbX().hpT.Iq().mLiveInfo.feed_id, d.this.Oj());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.cbX().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (d.this.cbX() != null) {
                        w wVar = null;
                        if (d.this.cbX().hpT != null) {
                            wVar = d.this.cbX().hpT.Iq();
                        }
                        if (wVar != null && wVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.v.b.ckB().brJ != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.v.b.ckB().brJ.aJj;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + wVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(d.this.cbX().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17 && d.this.Le() && d.this.cbX() != null && (boVar = com.baidu.live.ae.a.RB().bxq) != null && (cfVar = boVar.aQM) != null && (clVar = cfVar.aSk) != null && !TextUtils.isEmpty(clVar.webUrl)) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                    if (d.this.hgl != null && d.this.cbX().hpT != null && d.this.cbX().hpT.Iq() != null) {
                        w Iq2 = d.this.cbX().hpT.Iq();
                        d.this.hgl.a(clVar.webUrl, Iq2.mLiveInfo.live_id, Iq2.aKr.userId, Iq2.aJV.userId);
                    }
                }
            }
        }
    };
    private boolean hhL = false;
    private boolean hhM = false;

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.hfL = new com.baidu.tieba.ala.liveroom.guide.c(cbX().pageContext, this, false);
        this.hfk.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hfk);
        this.hfj.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hfj);
        this.hfl.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hfl);
        this.hfm.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.hfm);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean cak() {
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(w wVar) {
        super.l(wVar);
        g.cfr();
        this.hhI = true;
        this.hhM = false;
        this.hhL = false;
        cbX().hpU.setIsForceHandledTouch(false);
        cbX().hpU.setSwipeClearEnable(true);
        cbX().hpU.setOnLiveViewScrollListener(this.hfn);
        cbX().hpU.setOnClickListener(null);
        cbX().hpU.setClickable(false);
        if (this.hfO != null) {
            this.hfO.b(this.hfw);
        }
        if (this.hgG != null) {
            this.hgG.setVisibility(0);
        }
        cat();
        if (this.hgh != null) {
            this.hgh.a(wVar, this.buZ);
            this.hgh.U(this.hgH);
            this.hgh.a(this);
        }
        ccr();
        caF();
        cbf();
        cbe();
        caG();
        caK();
        caH();
        cci();
        nj(false);
        caC();
        caD();
        cbx();
        caP();
        cbz();
        caM();
        caN();
        cck();
        ccl();
        cbF();
        nl(false);
        cbC();
        car();
        cbP();
        cav();
        caB();
        caw();
        cax();
        cay();
        caz();
        can();
        cbE();
        cbL();
        cby();
        cbD();
        np(true);
        cbO();
        c(this.giS);
        cas();
        ccj();
        cbK();
        cbi();
        MessageManager.getInstance().registerListener(this.hfp);
        MessageManager.getInstance().registerListener(this.hfr);
        MessageManager.getInstance().registerListener(this.hft);
        MessageManager.getInstance().registerListener(this.hfu);
        MessageManager.getInstance().registerListener(this.hhK);
        MessageManager.getInstance().registerListener(this.hfv);
        MessageManager.getInstance().registerListener(this.hfs);
        MessageManager.getInstance().registerListener(this.hfq);
        caQ();
        caJ();
        cbB();
    }

    private void cci() {
    }

    private void ccj() {
        AlaVideoBCChatData alaVideoBCChatData;
        CustomResponsedMessage runTask;
        AlaLiveUserInfoData alaLiveUserInfoData = cbX().hpT.Iq().aKr;
        if (alaLiveUserInfoData != null && (alaVideoBCChatData = alaLiveUserInfoData.videoBCEnterData) != null && alaVideoBCChatData.isShowEnter()) {
            if (this.hgE == null && (runTask = MessageManager.getInstance().runTask(2913255, com.baidu.live.an.c.class, cbX().pageContext)) != null && runTask.getData() != null) {
                this.hgE = (com.baidu.live.an.c) runTask.getData();
            }
            if (this.hgE != null) {
                this.hgE.a(cbX().brf);
                this.hgE.b(cbX().hpS.getMastView());
                this.hgE.q(cbX().hpT.Iq());
                this.hgE.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.23
                    @Override // com.baidu.live.an.c.a
                    public void WK() {
                        if (d.this.hfO != null) {
                            d.this.cbX().hpU.hFu = false;
                            d.this.hfO.setPraiseEnable(false);
                            if (d.this.cbX().hpV != null) {
                                d.this.cbX().hpV.setTalentShowing(true);
                            }
                        }
                    }

                    @Override // com.baidu.live.an.c.a
                    public void WL() {
                        if (d.this.hfO != null) {
                            d.this.cbX().hpU.hFu = true;
                            d.this.hfO.setPraiseEnable(true);
                            if (d.this.cbX().hpV != null) {
                                d.this.cbX().hpV.setTalentShowing(false);
                            }
                        }
                    }
                });
                View enterView = this.hgE.getEnterView();
                if (enterView != null) {
                    if (enterView.getParent() != null) {
                        ((ViewGroup) enterView.getParent()).removeView(enterView);
                    }
                    this.hfG.cq(enterView);
                }
            }
        }
    }

    private void can() {
        if (this.hgw != null) {
            this.hgw.a(new com.baidu.live.z.c() { // from class: com.baidu.tieba.ala.liveroom.d.d.24
                @Override // com.baidu.live.z.c
                public void cH(boolean z) {
                    if (d.this.heU != null) {
                        d.this.heU.setNeedCloseRecommendFloat(z);
                    }
                    if (d.this.cbX().hpU.hFu) {
                        if (d.this.hfR != null) {
                            d.this.hfR.of(z);
                            d.this.hfR.on(!z);
                        }
                        if (d.this.hfO != null) {
                            d.this.hfO.of(z);
                            d.this.hfO.setPraiseEnable(!z);
                            d.this.hfO.oe(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void j(w wVar) {
        super.j(wVar);
        if (this.heM != null) {
            this.heM.M(wVar);
        }
        if (this.heN != null) {
            this.heN.I(wVar);
        }
        if (this.heQ != null) {
            this.heQ.L(wVar);
        }
        if (this.heU != null) {
            this.heU.a(wVar);
        }
        np(false);
        if (this.heR != null) {
            this.heR.i(wVar);
            this.heR.nc(this.hgQ);
            this.heR.updateView();
            if (wVar != null && this.hgy != null && !this.hgy.hasInit && !TextUtils.isEmpty(this.hgy.aRg)) {
                this.hgy.hasInit = true;
                this.heR.Id(this.hgy.aRg);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(q qVar) {
        if (qVar != null) {
            if (this.heL != null && qVar.getList() != null) {
                this.heL.e(qVar);
            }
            if (this.heP != null) {
                this.heP.eZ(qVar.getCount());
            }
        }
    }

    private void cap() {
        if (this.hfQ != null) {
            this.hfQ.ax(cbX().hpS.getLiveContainerView());
        }
    }

    private void cck() {
        if (this.heV == null) {
            this.heV = new com.baidu.tieba.ala.liveroom.c.a(cbX().pageContext);
        }
        if (cbX().hpT != null && cbX().hpT.Iq() != null && cbX().hpT.Iq().mLiveInfo != null) {
            this.heV.Ie(String.valueOf(cbX().hpT.Iq().mLiveInfo.user_id));
        }
    }

    private void ccl() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (cbX() != null && cbX().hpT != null && cbX().hpT.Iq() != null && cbX().hpT.Iq().mLiveInfo != null) {
                j = cbX().hpT.Iq().mLiveInfo.room_id;
            }
            if (this.hge == null) {
                this.hge = new com.baidu.tieba.ala.liveroom.guide.a(cbX().pageContext, j);
            }
            this.hge.nh(this.hgJ);
            this.hge.a(new a.InterfaceC0689a() { // from class: com.baidu.tieba.ala.liveroom.d.d.8
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0689a
                public void ccu() {
                    if (d.this.brc != null) {
                        d.this.brc.cu(true);
                    }
                }
            });
            this.hge.at(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void eb(int i) {
        super.eb(i);
        cap();
        if (this.heU != null) {
            this.heU.eb(i);
        }
    }

    private void cat() {
        if (this.buZ == null) {
            this.buZ = new PendantParentView(cbX().pageContext.getPageActivity(), this.gGG ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            cbX().hpU.addView(this.buZ, new ViewGroup.LayoutParams(-1, -1));
            this.buZ.setDefaultItemMargin(cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.buZ.setPadding(cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            ccm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccm() {
        int dimensionPixelSize;
        if (this.buZ != null) {
            this.buZ.setModel(this.gGG ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            int dimensionPixelSize2 = cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds220);
            int dimensionPixelSize3 = cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            if (this.gGG) {
                dimensionPixelSize = ccs();
            } else {
                dimensionPixelSize = cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds200);
            }
            this.buZ.setPosition(dimensionPixelSize2, 0, dimensionPixelSize, dimensionPixelSize3);
            return;
        }
        cat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccn() {
        if (cbX().hpU != null && !this.hhM) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.9
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.heZ != null && d.this.hfW != null && d.this.hfW.Nd() != null && d.this.hfW.Nd().getView() != null) {
                        if (d.this.gGG && !d.this.hgK && d.this.cbX().hpU != null && d.this.cbX().hpU.getHeight() > 0) {
                            int bu = d.this.heU != null ? d.this.heU.bu(false) : 0;
                            ViewGroup.LayoutParams layoutParams = d.this.heZ.getLayoutParams();
                            int height = d.this.cbX().hpU.getHeight() - bu;
                            int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                i += UtilHelper.getStatusBarHeight();
                            }
                            if (layoutParams != null && d.this.hfW != null) {
                                layoutParams.height = i + d.this.cbX().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                                d.this.heZ.setLayoutParams(layoutParams);
                                ViewGroup.LayoutParams layoutParams2 = d.this.hfW.Nd().getView().getLayoutParams();
                                if (layoutParams2 != null) {
                                    layoutParams2.height = layoutParams.height - com.baidu.live.ak.c.dl(false);
                                    d.this.hfW.Nd().getView().setLayoutParams(layoutParams2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        int i2 = com.baidu.live.ak.c.i(false, d.this.hgK);
                        if (d.this.hgH.indexOfChild(d.this.heZ) != -1 && d.this.heZ.getLayoutParams() != null) {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) d.this.heZ.getLayoutParams();
                            layoutParams3.height = com.baidu.live.ak.c.c(false, false, d.this.hgK);
                            d.this.heZ.setLayoutParams(layoutParams3);
                        }
                        if (d.this.heZ.indexOfChild(d.this.hfW.Nd().getView()) != -1 && d.this.hfW.Nd().getView().getLayoutParams() != null) {
                            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) d.this.hfW.Nd().getView().getLayoutParams();
                            layoutParams4.height = i2;
                            d.this.hfW.Nd().getView().setLayoutParams(layoutParams4);
                        }
                        d.this.hfW.Nd().Nc();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cco() {
        if (cbX().hpU != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.10
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.hfY != null) {
                        if (d.this.gGG && !d.this.hgK && d.this.cbX().hpU != null && d.this.cbX().hpU.getHeight() > 0) {
                            int height = (d.this.cbX().hpU.getHeight() - (d.this.heU != null ? d.this.heU.bu(false) : 0)) + d.this.cbX().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            if (d.this.hfY != null) {
                                d.this.hfY.ek(height);
                            }
                        } else if (d.this.hfY != null) {
                            d.this.hfY.ek(com.baidu.live.ak.a.a(d.this.cbX().pageContext.getPageActivity(), false, false, d.this.hgK));
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccp() {
        if (cbX().hpU != null) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.11
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    if (d.this.hfY != null) {
                        int h = com.baidu.live.ak.a.h(false, false);
                        if (!d.this.gGG || d.this.cbX().hpU == null || d.this.cbX().hpU.getHeight() <= 0) {
                            i = h;
                        } else {
                            int height = d.this.cbX().hpU.getHeight() - (d.this.heU != null ? d.this.heU.bu(false) : 0);
                            if (UtilHelper.canUseStyleImmersiveSticky()) {
                                height += UtilHelper.getStatusBarHeight();
                            }
                            i = height + d.this.cbX().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
                        }
                        if (d.this.hfY != null) {
                            d.this.hfY.el(i);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccq() {
        if (this.hfX != null && this.hfX.DL() != null) {
            ViewGroup.LayoutParams layoutParams = this.hfX.DL().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = cbX().pageContext.getResources().getDimensionPixelOffset(this.gGG ? a.d.sdk_ds100 : a.d.sdk_ds20);
                this.hfX.DL().setLayoutParams(layoutParams);
            }
        }
    }

    private void ccr() {
        if (this.hhG == null) {
            this.hhG = new LinearLayout(cbX().pageContext.getPageActivity());
            this.hhG.setOrientation(1);
        }
        if (this.hhG.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds160);
            layoutParams.leftMargin = cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            cbX().hpU.addView(this.hhG, layoutParams);
        }
    }

    private void cav() {
        if (this.heR == null) {
            this.heR = new com.baidu.tieba.ala.liveroom.activeview.b(cbX().pageContext);
        }
        if (cbX() != null && cbX().hpT != null) {
            this.heR.Ia(cbX().hpT.cjP());
        }
        this.heR.bd(this.gGG);
        this.heR.setOtherParams(Oj());
        this.heR.b(cbX().hpT.Iq(), false);
        this.heR.setHost(false);
        this.heR.nc(this.hgQ);
        this.heR.a(1, this.buZ);
        this.heR.a(2, this.buZ);
        this.heR.setVisible(this.hgK ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caB() {
        if (this.hfG == null) {
            caH();
        }
        this.hfG.setOtherParams(Oj());
        this.hfG.a(com.baidu.live.ae.e.RP().bxB, cbX().hpT.Iq());
    }

    private void caw() {
        if (this.heQ == null) {
            this.heQ = new com.baidu.tieba.ala.liveroom.l.a(cbX().pageContext, this);
        }
        this.heQ.setOtherParams(Oj());
        this.heQ.a((ViewGroup) this.buZ, caA());
        this.heQ.L(cbX().hpT.Iq());
    }

    private void cas() {
        if (cbX() != null) {
            if (this.hgt == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913271, com.baidu.live.a.a.class, cbX().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hgt = (com.baidu.live.a.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hgt.bd(this.gGG);
            this.hgt.bf(false);
            this.hgt.a(caV(), cbX().hpT.Iq());
        }
    }

    private void cax() {
        if (this.hgj == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, j.class, cbX().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hgj = (j) runTask.getData();
            } else {
                return;
            }
        }
        this.hgj.setOtherParams(Oj());
        if (this.heZ != null && this.heZ.indexOfChild(this.hgj.getView()) >= 0) {
            this.heZ.removeView(this.hgj.getView());
        }
    }

    private void cay() {
        if (this.hfG != null) {
            this.hfG.a(new a.InterfaceC0695a() { // from class: com.baidu.tieba.ala.liveroom.d.d.13
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0695a
                public void bS(int i, int i2) {
                    w Iq = d.this.cbX().hpT.Iq();
                    if (Iq != null && Iq.mLiveInfo != null) {
                        if (d.this.hgm == null) {
                            d.this.hgm = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.cbX().pageContext.getPageActivity());
                        }
                        d.this.hgm.d(d.this.hgH, i, i2);
                        d.this.hgm.a(String.valueOf(Iq.mLiveInfo.live_id), new a.InterfaceC0699a() { // from class: com.baidu.tieba.ala.liveroom.d.d.13.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0699a
                            public void a(float f, String str) {
                                if (d.this.hfG != null) {
                                    d.this.hfG.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0695a
                public void bT(int i, int i2) {
                    if (d.this.hgm != null) {
                        d.this.hgm.bY(i, i2);
                    }
                }
            });
        }
    }

    private void caz() {
        if (this.hgW == null) {
            this.hgW = new com.baidu.tieba.ala.liveroom.j.e(cbX().pageContext);
        }
        this.hgW.setRoomId(cbX().hpT.Iq().mLiveInfo.room_id);
        this.hgW.It("");
        this.hgW.b(cbX().hpT.Iq(), this.buZ);
        if (this.hfi == null) {
            this.hfi = new com.baidu.tieba.ala.liveroom.j.b(cbX().pageContext, Oj(), this.hgW, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.14
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void caY() {
                    d.this.ni(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void caZ() {
                    d.this.ni(false);
                }
            });
        }
        this.hfi.setRoomId(cbX().hpT.Iq().mLiveInfo.room_id);
        if (this.heZ != null && this.heZ.indexOfChild(this.hfi.getView()) >= 0) {
            this.heZ.removeView(this.hfi.getView());
        }
        if (this.hfi != null) {
            this.hfi.b(cbX());
        }
    }

    private void caP() {
        if (this.hhJ == null) {
            this.hhJ = new com.baidu.tieba.ala.liveroom.apppromotion.a(cbX().pageContext);
        }
        this.hhJ.b(caV(), cbX().hpT.Iq());
    }

    private LinearLayout.LayoutParams caA() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    private void caC() {
        CustomResponsedMessage runTask;
        if (this.hfW == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, cbX().pageContext)) != null && runTask.getData() != null) {
            this.hfW = (k) runTask.getData();
            this.hfW.setFromMaster(false);
            this.hfW.Nd().getView().setId(a.f.ala_liveroom_msg_list);
            this.hfW.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.d.15
                @Override // com.baidu.live.im.k.a
                public boolean Nh() {
                    return d.this.Le();
                }

                @Override // com.baidu.live.im.k.a
                public void Ni() {
                    d.this.hgO = true;
                }

                @Override // com.baidu.live.im.k.a
                public void id(String str) {
                    if (!d.this.hgK) {
                        d.this.ng(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.cbX().pageContext.getPageActivity(), d.this.cbX().hpS.getLiveContainerView());
                    }
                    d.this.Ih(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Nj() {
                    if (d.this.hgK) {
                        d.this.ng(true);
                        d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.15.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.cbX().pageContext.getPageActivity(), d.this.cbX().hpS.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.hfW != null) {
                        d.this.hfW.Ne().setQuickInputPanelVisible(false);
                        d.this.hfW.Ne().OR();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Nk() {
                    if (d.this.hgK) {
                        d.this.caX();
                        if (d.this.hfX != null) {
                            d.this.hfX.DM();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Nl() {
                    return d.this.cbk();
                }

                @Override // com.baidu.live.im.k.a
                public int Nm() {
                    return d.this.cbl();
                }
            });
            this.heZ = new FrameLayout(cbX().pageContext.getPageActivity());
            this.heZ.setId(a.f.ala_liveroom_msg_list_root);
        }
        if (this.hfW != null && this.heZ != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(cbX().pageContext.getPageActivity()) * 0.7f);
            int i = com.baidu.live.ak.c.i(false, false);
            if (this.hgH.indexOfChild(this.heZ) < 0) {
                if (this.heZ.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.heZ.getParent()).removeView(this.heZ);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.live.ak.c.c(false, false, false));
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.live.ak.c.dk(false);
                this.hgH.addView(this.heZ, layoutParams);
            }
            if (this.heZ.indexOfChild(this.hfW.Nd().getView()) < 0) {
                if (this.hfW.Nd().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hfW.Nd().getView()).removeView(this.hfW.Nd().getView());
                }
                this.heZ.addView(this.hfW.Nd().getView(), new FrameLayout.LayoutParams(equipmentWidth, i));
            }
            if (cbX().hpU.indexOfChild(this.hfW.Ne().getView()) < 0) {
                if (this.hfW.Ne().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hfW.Ne().getView().getParent()).removeView(this.hfW.Ne().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                cbs();
                cbX().hpU.addView(this.hfW.Ne().getView(), layoutParams2);
            }
            w Iq = cbX().hpT.Iq();
            if (Iq != null && Iq.mLiveInfo != null) {
                this.hfW.setLogData(Iq.mLiveInfo.feed_id, Oj());
            }
            this.hfW.a(String.valueOf(cbX().hpT.Iq().mLiveInfo.group_id), String.valueOf(cbX().hpT.Iq().mLiveInfo.last_msg_id), String.valueOf(cbX().hpT.Iq().aJV.userId), String.valueOf(cbX().hpT.Iq().mLiveInfo.live_id), cbX().hpT.Iq().aJV.appId, (Iq == null || Iq.aKI == null || !Iq.aKI.Fb()) ? false : true, cbX().hpT.Iq().getGuardName());
            ng(false);
        }
    }

    private void caF() {
        if (this.heM == null) {
            this.heM = new com.baidu.tieba.ala.liveroom.o.a(cbX().pageContext, false, this);
        }
        this.heM.e(this.hgG, cbX().hpT.Iq());
        this.heM.a(this.hfw);
        this.heM.setOtherParams(Oj());
    }

    private void caG() {
        if (this.heL == null) {
            this.heL = new com.baidu.tieba.ala.liveroom.audiencelist.c(cbX().pageContext, this, false);
        }
        this.heL.a(String.valueOf(cbX().hpT.Iq().mLiveInfo.group_id), String.valueOf(cbX().hpT.Iq().mLiveInfo.live_id), String.valueOf(cbX().hpT.Iq().aJV.userId), cbX().hpT.Iq());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.f.ala_liveroom_hostheader;
            if (this.hfH != null && this.hfH.getView() != null && this.hfH.getView().getParent() != null) {
                i = a.f.ala_liveroom_guardthrone;
            }
            this.heL.c(this.hgG, i, a.f.ala_liveroom_audience_count_layout);
            this.heL.e(cbX().hpT.bUu());
            this.heL.setOtherParams(Oj());
        }
    }

    private void caH() {
        com.baidu.live.core.a.a Pc;
        if (this.hfG == null) {
            this.hfG = new com.baidu.tieba.ala.liveroom.operation.a(cbX().pageContext);
        }
        this.hfG.a(cbX(), this.hgH, cbX().hpT.Iq().mLiveInfo, true, this.hfw);
        this.hfG.setOtherParams(Oj());
        if (this.hgh != null && (Pc = this.hgh.Pc()) != null) {
            View rootLayout = Pc.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.hfG.cp(rootLayout);
        }
    }

    private void caD() {
        cbr();
    }

    public void no(boolean z) {
        if (this.hfG != null) {
            this.hfG.no(z);
        }
    }

    private void caK() {
        if (this.heP == null) {
            this.heP = new com.baidu.tieba.ala.liveroom.audiencelist.b(cbX().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (cbX().hpT.bUu() != null) {
            j = cbX().hpT.bUu().getCount();
        }
        this.heP.a(this.hfw);
        this.heP.a(this.hgG, a.f.ala_liveroom_hostheader, j);
        this.heP.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.heP.ns(false);
        } else {
            this.heP.ns(true);
        }
    }

    protected void Ii(String str) {
        if (this.hgV == null) {
            this.hgV = new com.baidu.tieba.ala.liveroom.t.b(cbX().pageContext);
        }
        this.hgV.c(this.hgH, str);
        ni(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.16
            @Override // java.lang.Runnable
            public void run() {
                d.this.hgV.cko();
                d.this.ni(false);
            }
        }, 5000L);
    }

    private void np(boolean z) {
        CustomResponsedMessage runTask;
        if (cbX().hpT.Iq().mLiveInfo.live_type == 1 && this.hhI) {
            if (this.hhH == null && (runTask = MessageManager.getInstance().runTask(2913074, e.class, cbX().pageContext)) != null && runTask.getData() != null) {
                this.hhH = (e) runTask.getData();
            }
            if (this.hhH != null) {
                if (this.heT == null) {
                    this.heT = this.hhH.a(cbX().pageContext);
                }
                if (z) {
                    this.heT.Ev();
                }
                if (cbX().hpT.Iq().mLiveInfo.challengeId > 0 && !this.heT.ED()) {
                    this.heT.e(cbX().hpT.Iq().mLiveInfo.live_id, cbX().hpT.Iq().aJV.userId);
                    nq(z);
                    if (z) {
                        this.heT.a(cbX().hpT.ciW());
                    }
                    this.heT.c(cbX().hpT.Iq());
                }
            }
        }
    }

    private void nq(boolean z) {
        if (this.heU == null) {
            this.heU = this.hhH.b(cbX().pageContext);
            this.heU.a(new com.baidu.live.challenge.g() { // from class: com.baidu.tieba.ala.liveroom.d.d.17
                @Override // com.baidu.live.challenge.g
                public void Er() {
                    d.this.cbX().hpU.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.g
                public void a(ba baVar, be beVar, be beVar2) {
                    d.this.gGG = true;
                    if (d.this.hfN != null) {
                        d.this.hfN.ww(8);
                    }
                    if (d.this.hfO != null) {
                        d.this.hfO.setPraiseEnable(false);
                        d.this.cbX().hpU.hFu = false;
                    }
                    if (d.this.hgs != null) {
                        d.this.hgs.setCanVisible(false);
                    }
                    if (d.this.hfP != null) {
                        d.this.hfP.ckz();
                    }
                    if (d.this.heQ != null) {
                        d.this.heQ.setCanVisible(false);
                        d.this.heQ.cfv();
                    }
                    if (d.this.heR != null) {
                        d.this.heR.bd(true);
                    }
                    if (d.this.hgW != null) {
                        d.this.hgW.setVisible(8);
                    }
                    if (d.this.heS != null) {
                        d.this.heS.setCanVisible(false);
                        d.this.heS.setVisible(8);
                    }
                    if (d.this.hgt != null) {
                        d.this.hgt.bd(true);
                        d.this.hgt.be(true);
                    }
                    d.this.ccm();
                    d.this.ccn();
                    d.this.cco();
                    d.this.ccp();
                    d.this.ccq();
                    if (d.this.cbX().brf != null) {
                        d.this.cbX().brf.getLivePlayer().setBackgroundResource(a.c.sdk_transparent);
                    }
                    if (d.this.hfM != null) {
                        d.this.hfM.setTimeTextMode(true);
                    }
                    if (d.this.brc != null && beVar != null && beVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(beVar.aPX);
                        arrayList.add(beVar2.aPX);
                        com.baidu.live.liveroom.a.c cVar = d.this.brc;
                        if (d.this.hgS) {
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
                    d.this.cbX().hpU.setSwipeClearEnable(true);
                    d.this.gGG = false;
                    if (d.this.hfN != null) {
                        d.this.hfN.ww(0);
                    }
                    if (d.this.hfO != null) {
                        d.this.hfO.setPraiseEnable(true);
                        d.this.cbX().hpU.hFu = true;
                    }
                    if (d.this.hgs != null) {
                        d.this.hgs.setCanVisible(true);
                    }
                    if (d.this.hfP != null) {
                        d.this.hfP.ckA();
                    }
                    if (d.this.heQ != null) {
                        d.this.heQ.setCanVisible(true);
                        d.this.heQ.L(d.this.cbX().hpT.Iq());
                    }
                    if (d.this.hfR != null) {
                        d.this.hfR.on(true);
                    }
                    if (d.this.heR != null) {
                        d.this.heR.bd(false);
                    }
                    if (d.this.hgW != null) {
                        d.this.hgW.setVisible(0);
                    }
                    if (d.this.heS != null) {
                        d.this.heS.setCanVisible(true);
                        d.this.heS.setVisible(0);
                    }
                    if (d.this.hgt != null) {
                        d.this.hgt.bd(false);
                        d.this.hgt.be(false);
                    }
                    d.this.ccm();
                    d.this.ccn();
                    d.this.cco();
                    d.this.ccp();
                    d.this.ccq();
                    if (d.this.brc != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.cbX().hpT.cjL());
                        com.baidu.live.liveroom.a.c cVar = d.this.brc;
                        if (d.this.hgS) {
                            arrayList = null;
                        }
                        cVar.o(arrayList);
                    }
                    if (d.this.cbX().brf != null) {
                        d.this.cbX().brf.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
                    }
                    if (d.this.hfM != null) {
                        d.this.hfM.setTimeTextMode(false);
                    }
                }

                @Override // com.baidu.live.challenge.g
                public void bt(boolean z2) {
                    if (z2 && d.this.hgw != null) {
                        d.this.hgw.onClose();
                    }
                }
            });
        }
        this.heU.a(this.heT);
        this.heU.i(cbX().hpS.getLiveContainerView());
        this.heU.b(z, false, false);
        this.heT.a((i.c) this.heU);
    }

    public void caL() {
        this.hfJ.c(cbX().hpT.Iq(), false);
    }

    public void caM() {
        if (cbX().hpT.Iq() != null && cbX().hpT.Iq().aJV != null && cbX().hpT.Iq().mLiveInfo != null) {
            if (this.heO == null) {
                this.heO = new com.baidu.tieba.ala.liveroom.u.b(cbX().pageContext);
            }
            long j = cbX().hpT.Iq().aJV.userId;
            int i = cbX().hpT.Iq().mLiveInfo.live_type;
            String str = cbX().hpT.Iq().aJV.portrait;
            String str2 = cbX().hpT.Iq().mLiveInfo.feed_id;
            long j2 = cbX().hpT.Iq().mLiveInfo.live_id;
            this.heO.a(i, j, cbX().hpT.Iq().aJV.userName, false, str, Oj(), str2, j2);
            this.heO.at(this.hgG);
        }
    }

    private int ccs() {
        return (this.heU != null ? this.heU.bu(false) : 0) + cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
    }

    private void caN() {
        boolean z = true;
        if (this.hfR == null) {
            this.hfR = new com.baidu.tieba.ala.liveroom.w.a(cbX().pageContext, this);
        }
        this.hfR.c(cbX().hpU, false);
        AlaLiveInfoData alaLiveInfoData = cbX().hpT.Iq().mLiveInfo;
        if (alaLiveInfoData != null) {
            boolean z2 = cbW() && alaLiveInfoData.screen_direction != 2;
            boolean isZanAnimUnabled = alaLiveInfoData.mAlaLiveSwitchData != null ? alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled() : false;
            if (!z2 || isZanAnimUnabled) {
                z = false;
            }
            this.hfR.om(z);
        }
    }

    private void caQ() {
        if (this.hgO || this.hgP) {
            if ((TbadkCoreApplication.isLogin() && this.hfW.Ne().hasText()) || this.hgP) {
                this.hgO = false;
                this.hgP = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.d.19
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.cbq();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void caI() {
        caJ();
    }

    private void caJ() {
        if (this.hfG != null) {
            int i = cbX().hpT.Iq().aKr.isUegBlock;
            int i2 = cbX().hpT.Iq().aKr.isBlock;
            String str = cbX().hpT.Iq().aKr.userName;
            if (i > 0 || i2 > 0) {
                this.hfG.b(true, i, i2, str);
                this.hfW.a(true, i, i2, str);
                this.hgc.b(true, i, i2, str);
                return;
            }
            this.hfG.b(false, i, i2, str);
            this.hfW.a(false, i, i2, str);
            this.hgc.b(false, i, i2, str);
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
        if (this.heR != null) {
            this.heR.G(bVar);
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
                    if (this.heQ != null) {
                        this.heQ.J(jSONObject2);
                    }
                } else if ("enter_live".equals(optString)) {
                    if (this.heP != null && this.heP.getCount() > 20) {
                        this.heP.eZ(this.heP.getCount() + 1);
                    } else if (this.heL != null) {
                        com.baidu.live.data.a NU = bVar.NU();
                        p pVar = new p();
                        pVar.aJW = new AlaLocationData();
                        pVar.aJX = new AlaRelationData();
                        pVar.aJV = new AlaLiveUserInfoData();
                        pVar.aJV.userId = JavaTypesHelper.toLong(NU.userId, 0L);
                        pVar.aJV.userName = NU.userName;
                        pVar.aJV.portrait = NU.portrait;
                        if (this.heP != null && this.heL.c(pVar)) {
                            this.heP.eZ(this.heP.getCount() + 1);
                        }
                    }
                } else if ("update_liveinfo".equals(optString)) {
                    if (cbX().hpT.Iq() != null && cbX().hpT.Iq().mLiveInfo != null) {
                        cbX().hpT.a(cbX().hpT.Iq().mLiveInfo.live_id, cbX().fromType, cbX().enterTime);
                    }
                } else if ("challenge_mvp".equals(optString) && cbX().hpT.Iq() != null && cbX().hpT.Iq().mLiveInfo != null && cbX().hpT.Iq().aKr != null && this.heU != null) {
                    long optLong = jSONObject2.optLong("mvp_user_id");
                    long optLong2 = jSONObject2.optLong("winner_live_id");
                    if (optLong == cbX().hpT.Iq().aKr.userId && optLong2 == cbX().hpT.Iq().mLiveInfo.live_id) {
                        this.heU.c(jSONObject2.optInt("challenge_status"), jSONObject2.optLong("challenge_id"));
                    }
                }
            } else {
                return;
            }
        }
        if (this.hgs == null || this.hgs.N(jSONObject2)) {
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void Ic(String str) {
        if (this.heR != null) {
            this.heR.Ic(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hgE != null) {
            this.hgE.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void cz(boolean z) {
        super.cz(z);
        if (cbX().hpU != null) {
            cbX().hpU.cll();
            cbX().hpU.setLiveViewOnDispatchTouchEventListener(null);
            cbX().hpU.setLiveViewOnTouchEventListener(null);
            cbX().hpU.setOnLiveViewScrollListener(null);
        }
        if (cbX().brf != null) {
            cbX().brf.getLivePlayer().setBackgroundResource(a.e.sdk_transparent_bg);
        }
        if (this.heU != null) {
            this.heU.En();
        }
        caR();
        if (this.heO != null) {
            this.heO.En();
        }
        if (this.hfR != null) {
            this.hfR.release();
        }
        if (this.heQ != null) {
            this.heQ.En();
        }
        if (this.hfG != null) {
            this.hfG.cjS();
        }
        if (this.heN != null) {
            this.heN.ces();
            this.heN.setVisible(8);
        }
        if (this.heS != null) {
            this.heS.En();
        }
        if (this.heR != null) {
            this.heR.release();
        }
        if (this.buZ != null) {
            this.buZ.removeAllViews();
            this.buZ = null;
        }
        if (this.hhG != null) {
            this.hhG.removeAllViews();
            this.hhG = null;
        }
        if (this.hfR != null) {
            this.hfR.onDestroy();
        }
        if (this.heT != null) {
            this.heT.En();
        }
        if (this.heM != null) {
            this.heM.cgt();
        }
        if (this.hfi != null) {
            this.hfi.cancel();
        }
        if (this.hgW != null) {
            this.hgW.cdm();
        }
        if (this.hhJ != null) {
            this.hhJ.Do();
        }
        if (this.hgs != null) {
            this.hgs.Do();
        }
        if (this.heY != null) {
            this.heY.Do();
        }
        if (this.hfi != null) {
            this.hfi.En();
        }
        if (this.hgA != null) {
            this.hgA.En();
        }
        if (this.hgE != null) {
            this.hgE.SB();
        }
        if (cbX().hpV != null) {
            cbX().hpV.setTalentShowing(false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cx(boolean z) {
        super.cx(z);
        caR();
        if (this.heM != null) {
            this.heM.onDestroy();
        }
        if (this.heO != null) {
            this.heO.onDestroy();
        }
        if (this.heQ != null) {
            this.heQ.onDestroy();
        }
        if (this.heS != null) {
            this.heS.onDestroy();
        }
        if (this.heT != null) {
            this.heT.onDestroy();
        }
        if (this.heU != null) {
            this.heU.onDestroy();
        }
        if (this.heV != null) {
            this.heV.onDestroy();
        }
        if (this.hge != null) {
            this.hge.onDestroy();
        }
        if (this.heN != null) {
            this.heN.onDestroy();
        }
        if (this.heL != null) {
            this.heL.onDestroy();
        }
        if (this.hfW != null) {
            this.hfW.onDestroy();
        }
        if (this.hfG != null) {
            this.hfG.onDestory();
        }
        if (this.heR != null) {
            this.heR.release();
        }
        if (this.hgW != null) {
            this.hgW.cx(!z);
        }
        if (this.heY != null) {
            this.heY.onDestroy();
        }
        if (this.hfi != null) {
            this.hfi.onDestroy();
            this.hfi = null;
        }
        if (this.hgA != null) {
            this.hgA.onDestroy();
        }
        if (this.hgE != null) {
            this.hgE.onDestroy();
        }
        if (cbX().hpV != null) {
            cbX().hpV.setTalentShowing(false);
        }
        if (this.hhJ != null) {
            this.hhJ.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.hfk);
        MessageManager.getInstance().removeMessageRule(this.hfj);
        MessageManager.getInstance().removeMessageRule(this.hfl);
        MessageManager.getInstance().removeMessageRule(this.hfm);
        MessageManager.getInstance().unRegisterListener(this.hfp);
        MessageManager.getInstance().unRegisterListener(this.hfr);
        MessageManager.getInstance().unRegisterListener(this.hft);
        MessageManager.getInstance().unRegisterListener(this.hfu);
        MessageManager.getInstance().unRegisterListener(this.hhK);
        MessageManager.getInstance().unRegisterListener(this.hfv);
        MessageManager.getInstance().unRegisterListener(this.hfs);
        MessageManager.getInstance().unRegisterListener(this.hfq);
    }

    private void caR() {
        if (this.hfW != null && this.hfW.Nd().getView() != null && this.hfW.Nd().getView().getParent() != null) {
            ((ViewGroup) this.hfW.Nd().getView().getParent()).removeView(this.hfW.Nd().getView());
        }
        if (this.heZ != null && this.heZ.getParent() != null) {
            ((ViewGroup) this.heZ.getParent()).removeView(this.heZ);
        }
        if (this.hfW != null && this.hfW.Ne().getView() != null) {
            this.hgH.removeView(this.hfW.Ne().getView());
        }
        if (this.hfW != null) {
            this.hfW.Nd().setMsgData(new LinkedList());
            this.hfW.DN();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void a(ar arVar) {
        if (this.hfW != null) {
            cbq();
            this.hfW.Ne().setEditText(" @" + arVar.getNameShow() + " ");
        }
        if (this.hfG != null) {
            this.hfG.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void g(com.baidu.live.data.a aVar) {
        if (this.hfW != null) {
            cbq();
            this.hfW.Ne().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.hfG != null) {
            this.hfG.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void If(String str) {
        if (this.hfW != null) {
            cbq();
            StringBuilder sb = new StringBuilder();
            sb.append(" @");
            sb.append(str);
            sb.append(" ");
            if (com.baidu.live.ae.a.RB().brA.aOc != null && com.baidu.live.ae.a.RB().brA.aOc.originTexts != null && com.baidu.live.ae.a.RB().brA.aOc.originTexts.size() > 0) {
                this.hfW.Ne().OS();
                this.hfW.Ne().setEditText(sb.toString() + com.baidu.live.ae.a.RB().brA.aOc.originTexts.get(0));
            } else {
                this.hfW.Ne().setEditText(sb.toString());
            }
        }
        if (this.hfG != null) {
            this.hfG.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void b(ar arVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected View caS() {
        if (this.hfW != null) {
            return this.hfW.Ne().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean caT() {
        if (this.hfW == null || !this.hfW.Ne().OQ()) {
            return false;
        }
        ng(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected boolean caU() {
        return this.heM == null || this.heM.caU();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.d.b
    /* renamed from: cct */
    public PendantParentView caV() {
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
                    this.hgL = false;
                    N(intExtra, intExtra2, intExtra3);
                    return;
                }
                caL();
                return;
            }
            ays();
        } else if (i == 25051 && i2 == -1 && this.hgW != null) {
            this.hgW.cfm();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.hfW != null && this.hfW.Nd() != null) {
            this.hfW.Nd().onKeyboardVisibilityChanged(z);
        }
        if (z || this.hfW == null || this.hfW.Ne() == null || !this.hfW.Ne().OQ()) {
            if (z) {
                if (this.hfG != null) {
                    this.hfG.setVisibility(8);
                }
                if (this.hfY != null && this.hfY.HN() != null) {
                    this.hfY.HN().setVisibility(8);
                }
                caX();
                if (this.hfW != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hfW.Ne().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.hfW.Ne().getView().setLayoutParams(layoutParams);
                    this.hfW.Ne().getView().setVisibility(0);
                    this.hfW.Ne().setQuickInputPanelVisible(false);
                    this.hfW.Nf().cp(false);
                }
                if (this.hgG != null) {
                    this.hgG.setVisibility(8);
                }
                if (this.heR != null) {
                    this.heR.setVisible(8);
                }
                if (this.hfX != null) {
                    this.hfX.DM();
                }
                if (this.hgz != null) {
                    this.hgz.setCanVisible(false);
                }
                if (this.hgq != null) {
                    this.hgq.setCanVisible(false);
                }
                if (this.hgs != null) {
                    this.hgs.setCanVisible(false);
                }
                if (this.hgt != null) {
                    this.hgt.setCanVisible(false);
                }
                if (this.hgu != null) {
                    this.hgu.setCanVisible(false);
                }
                if (this.hgv != null) {
                    this.hgv.setVisible(8);
                }
                if (this.hhJ != null) {
                    this.hhJ.setCanVisible(false);
                }
            } else {
                caW();
            }
            ccn();
            if (this.hgk != null) {
                this.hgk.bD(z);
            }
        }
    }

    private void caW() {
        if (this.hfG != null) {
            this.hfG.setVisibility(0);
        }
        if (this.heZ != null) {
            if (this.hhM) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.heZ.getLayoutParams();
                layoutParams.bottomMargin = (M(false, false) - cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) + com.baidu.live.ak.c.Ws();
                this.heZ.setLayoutParams(layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.heZ.getLayoutParams();
                layoutParams2.bottomMargin = cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds90);
                this.heZ.setLayoutParams(layoutParams2);
            }
        }
        if (this.hfW != null) {
            cbs();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hfW.Ne().getView().getLayoutParams();
            layoutParams3.bottomMargin = 0;
            this.hfW.Ne().getView().setLayoutParams(layoutParams3);
            if (this.hfW.Nf().isClicked()) {
                this.hfW.Nf().cp(false);
            } else {
                this.hfW.Nf().cp(true);
            }
        }
        if (this.hfG != null) {
            this.hfG.setVisibility(0);
        }
        if (this.hfY != null && this.hfY.HN() != null) {
            this.hfY.HN().setVisibility(0);
        }
        if (this.hgG != null) {
            this.hgG.setVisibility(0);
        }
        if (this.heR != null) {
            this.heR.setVisible(0);
        }
        if (this.hfX != null) {
            this.hfX.DM();
        }
        if (this.hgz != null) {
            this.hgz.setCanVisible(true);
        }
        if (this.hgq != null) {
            this.hgq.setCanVisible(true);
        }
        if (this.hgu != null) {
            this.hgu.setCanVisible(true);
        }
        if (this.hgv != null) {
            this.hgv.setVisible(0);
        }
        if (this.hgs != null) {
            this.hgs.setCanVisible(!this.gGG);
        }
        if (this.hgt != null) {
            this.hgt.setCanVisible(true);
        }
        if (this.hhJ != null) {
            this.hhJ.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caX() {
        boolean z;
        boolean z2 = false;
        if (this.heZ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.heZ.getLayoutParams();
            if (this.hfW == null || this.hfW.Ne() == null) {
                z = false;
            } else {
                z = this.hfW.Ne().OO();
                z2 = this.hfW.Ne().OP();
            }
            int M = M(z, z2);
            if (layoutParams.bottomMargin != M) {
                layoutParams.bottomMargin = M;
                this.heZ.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ng(boolean z) {
        this.hhL = z;
        if (z) {
            this.hfW.Ne().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.heZ.getLayoutParams();
            int quickInputPanelExpandHeight = this.hfW.Ne().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.heZ.setLayoutParams(layoutParams);
                if (this.hfW.Nd() != null) {
                    this.hfW.Nd().Nc();
                    return;
                }
                return;
            }
            return;
        }
        caW();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.heL != null) {
                this.heL.dX(i3);
            }
            if (this.heN != null) {
                this.heN.dX(i3);
            }
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public boolean fh(int i) {
        boolean fh = super.fh(i);
        if (fh && 2 == i) {
            if (this.heM.caU()) {
                return false;
            }
            if (fh && this.hfR != null) {
                this.hfR.on(false);
            }
        }
        return fh;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void wy(int i) {
        super.wy(i);
        if (i == 7 || i == 11) {
            if (this.hfG != null) {
                this.hfG.setVisibility(8);
            }
            if (this.hfW != null) {
                this.hfW.Nd().getView().setVisibility(4);
                this.hfW.Nf().getView().setVisibility(4);
            }
            if (this.heR != null) {
                this.heR.bQ(2, 8);
                if (this.gGG) {
                    this.heR.bQ(1, 8);
                }
            }
            if (this.hgm != null) {
                this.hgm.oh(false);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public void fi(int i) {
        super.fi(i);
        if (i == 7 || i == 11) {
            if (this.hfG != null) {
                this.hfG.setVisibility(0);
            }
            if (this.hfW != null) {
                this.hfW.Nd().getView().setVisibility(0);
                if (!this.hfW.Nf().isClicked()) {
                    this.hfW.Nf().cp(true);
                }
            }
            if (this.heR != null) {
                this.heR.setVisible(0);
            }
            if (this.hgm != null) {
                this.hgm.oh(true);
            }
            this.hgG.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.heO != null) {
            this.heO.ckq();
        }
        if (this.heT != null) {
            this.heT.Ew();
        }
        if (this.heR != null) {
            this.heR.onStop();
        }
        if (this.heS != null) {
            this.heS.br(true);
        }
        if (this.hgE != null) {
            this.hgE.onStopped();
        }
        if (this.hgD != null) {
            this.hgD.onStop();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.heO != null) {
            this.heO.ckp();
        }
        if (this.heT != null && this.hhI) {
            this.heT.Ex();
        }
        if (this.heR != null) {
            this.heR.onStart();
        }
        if (this.heS != null) {
            this.heS.br(false);
        }
        if (this.hgE != null) {
            this.hgE.onStarted();
        }
        if (this.hgD != null) {
            this.hgD.onStart();
        }
        if (this.hhJ != null) {
            this.hhJ.onStart();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        if (!onKeyDown && i == 4 && this.hgE != null && this.hgE.onKeyDown(i, keyEvent)) {
            return true;
        }
        return onKeyDown;
    }
}
