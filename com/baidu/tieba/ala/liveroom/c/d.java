package com.baidu.tieba.ala.liveroom.c;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
import com.baidu.live.challenge.f;
import com.baidu.live.challenge.i;
import com.baidu.live.challenge.j;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.af;
import com.baidu.live.data.al;
import com.baidu.live.data.aq;
import com.baidu.live.data.h;
import com.baidu.live.data.s;
import com.baidu.live.data.v;
import com.baidu.live.data.w;
import com.baidu.live.im.i;
import com.baidu.live.im.k;
import com.baidu.live.k.a;
import com.baidu.live.message.GetQuickGiftHttpResponseMessage;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.ILiveGoodsLogger;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.utils.m;
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends b {
    private RelativeLayout dVP;
    private LinearLayout dVQ;
    private com.baidu.tieba.ala.liveroom.audiencelist.c dVR;
    private com.baidu.tieba.ala.liveroom.l.a dVS;
    private com.baidu.tieba.ala.liveroom.e.b dVT;
    private com.baidu.tieba.ala.liveroom.q.b dVU;
    private com.baidu.tieba.ala.liveroom.p.b dVV;
    private com.baidu.tieba.ala.liveroom.operation.a dVW;
    private com.baidu.tieba.ala.liveroom.audiencelist.b dVX;
    private com.baidu.tieba.ala.liveroom.i.a dVY;
    private com.baidu.tieba.ala.liveroom.activeview.b dVZ;
    private boolean dVf;
    private com.baidu.live.c.a dWa;
    private j dWb;
    private i dWc;
    private com.baidu.tieba.ala.liveroom.attentionpop.b dWd;
    private FrameLayout dWg;
    private f dXK;
    private long lastClickTime = 0;
    private boolean dXL = false;
    private HttpRule dWo = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.dWb != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.dWb.nP()) {
                httpMessage.addParam("ala_challenge_id", d.this.dWb.nT());
            }
            return httpMessage;
        }
    };
    private HttpRule dWp = new HttpRule(1021151) { // from class: com.baidu.tieba.ala.liveroom.c.d.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.dWb != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.dWb.nP()) {
                httpMessage.addParam("challenge_id", d.this.dWb.nT());
            }
            return httpMessage;
        }
    };
    private AlaLiveView.c dWq = new AlaLiveView.c() { // from class: com.baidu.tieba.ala.liveroom.c.d.8
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void aOO() {
            if (d.this.dWM != null) {
                d.this.dWM.in(false);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void hs(boolean z) {
            if (z) {
                if (d.this.dVW != null) {
                    d.this.dVW.nW(8);
                }
                if (d.this.dWM != null) {
                    d.this.dWM.in(true);
                    return;
                }
                return;
            }
            if (d.this.dVW != null) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                    d.this.dVW.nW(0);
                } else {
                    d.this.dVW.nW(8);
                }
            }
            if (d.this.dWM != null) {
                d.this.dWM.in(false);
            }
        }
    };
    private HttpMessageListener dWr = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.d.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.us() != null) {
                        com.baidu.live.l.c.uH().akF = getQuickGiftHttpResponseMessage.us();
                        d.this.aOs();
                    }
                }
            }
        }
    };
    private CustomMessageListener dWs = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.aOB();
        }
    };
    private CustomMessageListener dXM = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.c.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = (AlaBroadcastGiftToastData) customResponsedMessage.getData();
                if (d.this.dWT instanceof com.baidu.live.gift.broadcastgift.a) {
                    ((com.baidu.live.gift.broadcastgift.a) d.this.dWT).b(alaBroadcastGiftToastData);
                }
            }
        }
    };
    CustomMessageListener dWt = new CustomMessageListener(CmdConfigCustom.CMD_HOST_GET_WALLET_UA) { // from class: com.baidu.tieba.ala.liveroom.c.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.dXn != null && d.this.dXn.dKm != null && !d.this.dXn.dKS && !d.this.dXn.dNt) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.aPu().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = d.this.aPu().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                d.this.dXb.c(d.this.dWg, layoutParams);
                com.baidu.tieba.ala.guardclub.a.aLe().aLf();
            }
        }
    };
    private CustomMessageListener dWu = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.d.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof Integer)) {
                if (d.this.dXc != null) {
                    d.this.dXc.dismiss();
                }
                k.sN().ax(true);
                k.sN().setSelect(((Integer) customResponsedMessage.getData()).intValue());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.aOX();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b dWv = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.d.4
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void n(View view, int i) {
            af afVar;
            al alVar;
            aq aqVar;
            af afVar2;
            al alVar2;
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - d.this.lastClickTime >= 300) {
                d.this.lastClickTime = currentTimeMillis;
                if (i == 2) {
                    d.this.F(-1, -1, -1);
                } else if (i == 13) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                    alaStaticItem.addParams("gifts_value", com.baidu.live.l.c.uH().akF.pF().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.l.c.uH().akF.pF().pc());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.l.c.uH().akF.pF().pd());
                    if (d.this.aPu().eeL.uk() != null && d.this.aPu().eeL.uk().mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", d.this.aPu().eeL.uk().mLiveInfo.feed_id);
                        alaStaticItem.addParams("room_id", d.this.aPu().eeL.uk().mLiveInfo.room_id);
                    }
                    alaStaticItem.addParams("other_params", d.this.tn());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    if (d.this.rB()) {
                        if (com.baidu.live.c.np().getBoolean("quick_gift_guide_show", true)) {
                            com.baidu.live.gift.container.e eVar = new com.baidu.live.gift.container.e(d.this.aPu().pageContext.getPageActivity(), d.this.aPu().pageContext, d.this.aPu().eeL.uk(), com.baidu.live.l.c.uH().akF.pF(), d.this.tn());
                            eVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.d.4.1
                                @Override // android.content.DialogInterface.OnDismissListener
                                public void onDismiss(DialogInterface dialogInterface) {
                                    d.this.hu(false);
                                }
                            });
                            eVar.show();
                            d.this.hu(true);
                            return;
                        }
                        com.baidu.live.gift.b.c.a(d.this.aPu().pageContext, d.this.aPu().eeL.uk(), com.baidu.live.l.c.uH().akF.pF(), d.this.tn());
                    }
                } else if (i == 1) {
                    if (d.this.dWQ != null) {
                        d.this.aOX();
                    }
                } else if (i == 3 && d.this.rB()) {
                    d.this.dWF.c(d.this.aPu().eeL.uk(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.aPu() != null && d.this.aPu().eeL != null && d.this.aPu().eeL.uk() != null && d.this.aPu().eeL.uk().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.aPu().eeL.uk().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.aPu().eeL.uk().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.aPu().eeL.uk().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.tn());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.aPu() != null && d.this.aPu().eeL != null && d.this.aPu().eeL.uk() != null && d.this.aPu().eeL.uk().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.aPu().eeL.uk().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.aPu().eeL.uk().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.aPu().eeL.uk().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.tn());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.dWD != null) {
                        d.this.dWD.aPI();
                    }
                } else if (i == 12) {
                    if (d.this.dWM != null) {
                        String valueOf = String.valueOf(d.this.aPu().eeL.uk().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.aPu().eeL.uk().mLiveInfo.room_id);
                        String str2 = null;
                        h hVar = d.this.aPu().eeL.uk().mLiveSdkInfo;
                        if (hVar != null && hVar.mCastIds != null) {
                            str2 = String.valueOf(d.this.aPu().eeL.uk().mLiveSdkInfo.mCastIds.Pd);
                        }
                        d.this.dWM.R(valueOf, valueOf2, str2);
                        if (com.baidu.live.liveroom.a.tZ().ua()) {
                            d.this.aOB();
                        }
                    }
                } else if (i == 14) {
                    com.baidu.live.data.i uk = d.this.aPu().eeL.uk();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.aPu().pageContext.getPageActivity(), uk.OR.userName, Long.toString(uk.OR.userId), Long.toString(uk.OR.charmCount), String.valueOf(uk.mLiveInfo.group_id), String.valueOf(uk.mLiveInfo.live_id), false, String.valueOf(uk.OR.userId), Long.toString(uk.Pj.userId), uk.Pj.userName, uk.Pj.portrait, d.this.dVX.getCount(), d.this.tn())));
                    LogManager.getCommonLogger().doClickGusetNumLog(uk.mLiveInfo.feed_id, d.this.dVX.getCount() + "", d.this.tn());
                } else if (i == 11) {
                    d.this.aPa();
                    d.this.aPb();
                } else if (i == 15) {
                    if (d.this.dWZ != null && d.this.aPu() != null && d.this.aPu().eeL != null && d.this.aPu().eeL.uk() != null && d.this.aPu().eeL.uk().mLiveInfo != null) {
                        long j = d.this.aPu().eeL.uk().mLiveInfo.live_id;
                        String valueOf3 = String.valueOf(d.this.aPu().eeL.uk().mLiveInfo.feed_id);
                        long j2 = d.this.aPu().eeL.uk().mLiveInfo.room_id;
                        String str3 = d.this.aPu().eeL.uk().mLiveInfo.cover;
                        String str4 = "";
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        if (d.this.aPu().eeL.uk().mLiveInfo.session_info != null) {
                            str4 = d.this.aPu().eeL.uk().mLiveInfo.session_info.flvUrl;
                        }
                        if (!TextUtils.isEmpty(d.this.tn())) {
                            try {
                                JSONObject jSONObject = new JSONObject(d.this.tn());
                                str5 = jSONObject.optString("tab");
                                str6 = jSONObject.optString("tag");
                                str7 = jSONObject.optString("source");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        d.this.dWZ.tB(m.a(valueOf3, j + "", j2, false, 1, str3, str4, str5, str6, str7));
                        m.ard = j;
                        if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                            ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                            LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf3, d.this.tn());
                        }
                    }
                } else if (i == 16) {
                    if (d.this.aPu() != null && (afVar2 = com.baidu.live.l.a.uB().aku) != null && (alVar2 = afVar2.TK) != null) {
                        String str8 = alVar2.Ur.Uw;
                        if (!TextUtils.isEmpty(str8)) {
                            long j3 = 0;
                            if (d.this.aPu().eeL != null && d.this.aPu().eeL.uk() != null && d.this.aPu().eeL.uk().mLiveInfo != null) {
                                j3 = d.this.aPu().eeL.uk().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j3 + "", d.this.aPu().eeL.uk().mLiveInfo.room_id + "", d.this.aPu().eeL.uk().mLiveInfo.feed_id, d.this.tn());
                            }
                            if (str8.contains("?")) {
                                str = str8 + "&liveId=" + j3;
                            } else {
                                str = str8 + "?liveId=" + j3;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.aPu().pageContext.getPageActivity(), str);
                        }
                    }
                } else if (i == 17 && d.this.rB() && d.this.aPu() != null && (afVar = com.baidu.live.l.a.uB().aku) != null && (alVar = afVar.TK) != null && (aqVar = alVar.Us) != null && !TextUtils.isEmpty(aqVar.webUrl) && d.this.dXc != null && d.this.aPu().eeL != null && d.this.aPu().eeL.uk() != null) {
                    com.baidu.live.data.i uk2 = d.this.aPu().eeL.uk();
                    d.this.dXc.a(aqVar.webUrl, uk2.mLiveInfo.live_id, uk2.Pj.userId, uk2.OR.userId);
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void init() {
        super.init();
        this.dWH = new com.baidu.tieba.ala.liveroom.guide.a(aPu().pageContext, this, false);
        this.dWo.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.dWo);
        this.dWp.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.dWp);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean aOf() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void uN() {
        super.uN();
        this.dXL = true;
        aPu().eeM.setIsForceHandledTouch(false);
        aPu().eeM.setSwipeClearEnable(true);
        aPu().eeM.setOnLiveViewScrollListener(this.dWq);
        if (this.dWK != null) {
            this.dWK.b(this.dWv);
        }
        if (this.dXh != null) {
            this.dXh.setVisibility(0);
        }
        aOk();
        aOl();
        aOv();
        aOw();
        aOy();
        aOx();
        ho(false);
        aPd();
        aOn();
        aOt();
        aPf();
        aOA();
        aOC();
        hC(true);
        aPH();
        aOm();
        aOs();
        aOo();
        aOp();
        aOq();
        hA(true);
        aPk();
        MessageManager.getInstance().registerListener(this.dWr);
        MessageManager.getInstance().registerListener(this.dWs);
        MessageManager.getInstance().registerListener(this.dXM);
        MessageManager.getInstance().registerListener(this.dWt);
        MessageManager.getInstance().registerListener(this.dWu);
        aOE();
    }

    private void aOh() {
        if (this.dWL != null) {
            this.dWL.ae(aPu().eeN);
        }
    }

    private void aPH() {
        if (this.dWd == null) {
            this.dWd = new com.baidu.tieba.ala.liveroom.attentionpop.b(aPu().pageContext);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void aS(int i) {
        super.aS(i);
        aOh();
        if (this.dWc != null) {
            this.dWc.aS(i);
        }
        if (this.dWc == null || !this.dWc.isActive()) {
        }
    }

    private void aOk() {
        if (this.dVP == null) {
            this.dVP = new RelativeLayout(aPu().pageContext.getPageActivity());
        }
        if (this.dVP.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            layoutParams.topMargin = aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds248);
            layoutParams.rightMargin = aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
            layoutParams.bottomMargin = aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds112);
            aPu().eeM.addView(this.dVP, layoutParams);
        }
    }

    private void aOl() {
        if (this.dVQ == null) {
            this.dVQ = new LinearLayout(aPu().pageContext.getPageActivity());
            this.dVQ.setOrientation(1);
        }
        if (this.dVQ.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200);
            layoutParams.leftMargin = aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            aPu().eeM.addView(this.dVQ, layoutParams);
        }
    }

    private void aOn() {
        if (this.dWJ != null && aPu() != null && aPu().eeL != null) {
            this.dWJ.b(this.dXh, aPu().eeL.uk());
        }
    }

    private void aOm() {
        if (this.dVZ == null) {
            this.dVZ = new com.baidu.tieba.ala.liveroom.activeview.b(aPu().pageContext);
        }
        this.dVZ.hk(this.dVf);
        this.dVZ.setOtherParams(tn());
        this.dVZ.b(aPu().eeL.uk(), false);
        this.dVZ.setHost(false);
        this.dVZ.a(1, this.dVQ, nq(1));
        this.dVZ.a(2, this.dVP, nq(2));
        this.dVZ.setVisible(this.dXk ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOs() {
        if (this.dVW == null) {
            aOx();
        }
        this.dVW.setOtherParams(tn());
        this.dVW.a(com.baidu.live.l.c.uH().akF, aPu().eeL.uk());
    }

    private ViewGroup.LayoutParams nq(int i) {
        switch (i) {
            case 1:
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (this.dVQ == null || this.dVQ.getChildCount() == 0) {
                    return layoutParams;
                }
                layoutParams.topMargin = aPu().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                return layoutParams;
            case 2:
                ViewGroup.LayoutParams layoutParams2 = this.dVP.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(((int) (BdUtilHelper.getEquipmentWidth(aPu().pageContext.getPageActivity()) * 0.25f)) - ((layoutParams2 instanceof RelativeLayout.LayoutParams ? ((RelativeLayout.LayoutParams) layoutParams2).rightMargin : 0) * 2), -2);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                return layoutParams3;
            default:
                return new RelativeLayout.LayoutParams(-2, -2);
        }
    }

    private void aOo() {
        if (this.dVY == null) {
            this.dVY = new com.baidu.tieba.ala.liveroom.i.a(aPu().pageContext, this);
        }
        this.dVY.setOtherParams(tn());
        this.dVY.a(this.dVP, aOr());
        this.dVY.k(aPu().eeL.uk());
    }

    private void aOp() {
        if (this.dXb == null) {
            this.dXb = new com.baidu.tieba.ala.liveroom.j.c(aPu().pageContext, tn());
        }
        if (this.dWg != null && this.dWg.indexOfChild(this.dXb.getView()) >= 0) {
            this.dWg.removeView(this.dXb.getView());
        }
    }

    private void aOq() {
        if (this.dVW != null) {
            this.dVW.a(new a.InterfaceC0364a() { // from class: com.baidu.tieba.ala.liveroom.c.d.14
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0364a
                public void aQ(int i, int i2) {
                    com.baidu.live.data.i uk = d.this.aPu().eeL.uk();
                    if (uk != null && uk.mLiveInfo != null) {
                        if (d.this.dXd == null) {
                            d.this.dXd = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.aPu().pageContext.getPageActivity());
                        }
                        d.this.dXd.d(d.this.dXi, i, i2);
                        d.this.dXd.a(String.valueOf(uk.mLiveInfo.live_id), new a.InterfaceC0367a() { // from class: com.baidu.tieba.ala.liveroom.c.d.14.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0367a
                            public void a(float f, String str) {
                                if (d.this.dVW != null) {
                                    d.this.dVW.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0364a
                public void aR(int i, int i2) {
                    if (d.this.dXd != null) {
                        d.this.dXd.bb(i, i2);
                    }
                }
            });
        }
    }

    private ViewGroup.LayoutParams aOr() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.topMargin = (ScreenHelper.getRealScreenHeight(aPu().pageContext.getPageActivity()) - this.dVP.getTop()) - aPu().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds814);
        return layoutParams;
    }

    private void aOt() {
        CustomResponsedMessage runTask;
        if (this.dWQ == null && (runTask = MessageManager.getInstance().runTask(2913039, com.baidu.live.im.i.class, aPu().pageContext)) != null && runTask.getData() != null) {
            this.dWQ = (com.baidu.live.im.i) runTask.getData();
            this.dWQ.setFromMaster(false);
            this.dWQ.sE().getView().setId(a.g.ala_liveroom_msg_list);
            this.dWQ.a(new i.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.2
                @Override // com.baidu.live.im.i.a
                public boolean sG() {
                    return d.this.rB();
                }

                @Override // com.baidu.live.im.i.a
                public void sH() {
                    d.this.dXo = true;
                }

                @Override // com.baidu.live.im.i.a
                public void cH(String str) {
                    if (!d.this.dXk) {
                        d.this.hr(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.aPu().pageContext.getPageActivity(), d.this.aPu().eeN);
                    }
                    d.this.ty(str);
                }

                @Override // com.baidu.live.im.i.a
                public void sI() {
                    if (d.this.dXk) {
                        d.this.hr(true);
                        d.this.aPu().eeN.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.aPu().pageContext.getPageActivity(), d.this.aPu().eeN);
                            }
                        }, 10L);
                    } else if (d.this.dWQ != null) {
                        d.this.dWQ.sF().setQuickInputPanelVisible(false);
                        d.this.dWQ.sF().tH();
                    }
                }

                @Override // com.baidu.live.im.i.a
                public void sJ() {
                    if (d.this.dXk) {
                        d.this.aOL();
                        if (d.this.dWR != null) {
                            d.this.dWR.sL();
                        }
                    }
                }
            });
            this.dWg = new FrameLayout(aPu().pageContext.getPageActivity());
            this.dWg.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.dWQ != null && this.dWg != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(aPu().pageContext.getPageActivity()) * 0.75f);
            int dimensionPixelSize = aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64) + ((int) (BdUtilHelper.getEquipmentHeight(aPu().pageContext.getPageActivity()) * 0.27f));
            if (this.dXi.indexOfChild(this.dWg) < 0) {
                if (this.dWg.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.dWg.getParent()).removeView(this.dWg);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds27) + dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
                this.dXi.addView(this.dWg, layoutParams);
            }
            if (this.dWg.indexOfChild(this.dWQ.sE().getView()) < 0) {
                if (this.dWQ.sE().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.dWQ.sE().getView()).removeView(this.dWQ.sE().getView());
                }
                this.dWg.addView(this.dWQ.sE().getView(), new FrameLayout.LayoutParams(equipmentWidth, dimensionPixelSize));
            }
            if (aPu().eeM.indexOfChild(this.dWQ.sF().getView()) < 0) {
                if (this.dWQ.sF().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.dWQ.sF().getView().getParent()).removeView(this.dWQ.sF().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                aOY();
                aPu().eeM.addView(this.dWQ.sF().getView(), layoutParams2);
            }
            com.baidu.live.data.i uk = aPu().eeL.uk();
            if (uk != null && uk.mLiveInfo != null) {
                this.dWQ.setLogData(uk.mLiveInfo.feed_id, tn());
            }
            this.dWQ.e(String.valueOf(aPu().eeL.uk().mLiveInfo.group_id), String.valueOf(aPu().eeL.uk().mLiveInfo.last_msg_id), String.valueOf(aPu().eeL.uk().OR.userId), String.valueOf(aPu().eeL.uk().mLiveInfo.live_id), aPu().eeL.uk().OR.appId);
            hr(false);
        }
    }

    private void aOv() {
        if (this.dVS == null) {
            this.dVS = new com.baidu.tieba.ala.liveroom.l.a(aPu().pageContext, false, this);
        }
        this.dVS.d(this.dXh, aPu().eeL.uk());
        this.dVS.a(this.dWv);
        this.dVS.setOtherParams(tn());
    }

    private void aOw() {
        if (this.dVR == null) {
            this.dVR = new com.baidu.tieba.ala.liveroom.audiencelist.c(aPu().pageContext, this, false);
        }
        this.dVR.a(String.valueOf(aPu().eeL.uk().mLiveInfo.group_id), String.valueOf(aPu().eeL.uk().mLiveInfo.live_id), String.valueOf(aPu().eeL.uk().OR.userId), aPu().eeL.uk());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.dVR.c(this.dXh, a.g.ala_liveroom_hostheader, a.g.ala_liveroom_audience_count_layout);
            this.dVR.e(aPu().eeL.aKw());
            this.dVR.setOtherParams(tn());
        }
    }

    private void aOx() {
        if (this.dVW == null) {
            this.dVW = new com.baidu.tieba.ala.liveroom.operation.a(aPu().pageContext);
        }
        this.dVW.a(aPu(), this.dXi, aPu().eeL.uk().mLiveInfo.live_type, true, this.dWv);
        this.dVW.setOtherParams(tn());
    }

    public void hz(boolean z) {
        if (this.dVW != null) {
            this.dVW.hz(z);
        }
    }

    private void aOy() {
        if (this.dVX == null) {
            this.dVX = new com.baidu.tieba.ala.liveroom.audiencelist.b(aPu().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (aPu().eeL.aKw() != null) {
            j = aPu().eeL.aKw().getCount();
        }
        this.dVX.a(this.dWv);
        this.dVX.a(this.dXh, a.g.ala_liveroom_audience, j);
        this.dVX.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.dVX.hG(false);
        } else {
            this.dVX.hG(true);
        }
    }

    private void hA(boolean z) {
        CustomResponsedMessage runTask;
        if (aPu().eeL.uk().mLiveInfo.live_type == 1) {
            if (this.dXK == null && (runTask = MessageManager.getInstance().runTask(2913074, f.class, aPu().pageContext)) != null && runTask.getData() != null) {
                this.dXK = (f) runTask.getData();
            }
            if (this.dXK != null) {
                if (this.dWb == null) {
                    this.dWb = this.dXK.a(aPu().pageContext);
                }
                if (aPu().eeL.uk().mLiveInfo.challengeId > 0 && !this.dWb.nQ()) {
                    this.dWb.d(aPu().eeL.uk().mLiveInfo.live_id, aPu().eeL.uk().OR.userId);
                    hB(z);
                    this.dWb.c(aPu().eeL.uk());
                }
            }
        }
    }

    private void hB(boolean z) {
        if (this.dWc == null) {
            this.dWc = this.dXK.b(aPu().pageContext);
            this.dWc.a(new com.baidu.live.challenge.h() { // from class: com.baidu.tieba.ala.liveroom.c.d.3
                @Override // com.baidu.live.challenge.h
                public void nG() {
                    d.this.aPu().eeM.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.h
                public void a(v vVar, w wVar, w wVar2) {
                    d.this.dVf = true;
                    if (d.this.dWK != null) {
                        d.this.dWK.setPraiseEnable(false);
                        d.this.aPu().eeM.eqB = false;
                    }
                    if (d.this.dVY != null) {
                        d.this.dVY.setCanVisible(false);
                        d.this.dVY.aRU();
                    }
                    if (d.this.dVZ != null) {
                        d.this.dVZ.hk(true);
                        d.this.dVZ.setVisible(8);
                    }
                    if (d.this.dWa != null) {
                        d.this.dWa.setCanVisible(false);
                        d.this.dWa.setVisible(8);
                    }
                    if (d.this.aPu().eeK != null) {
                        d.this.aPu().eeK.setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                    }
                    if (d.this.dWI != null) {
                        d.this.dWI.setTimeTextMode(true);
                    }
                    if (d.this.dWD != null && wVar != null && wVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(wVar.SG);
                        arrayList.add(wVar2.SG);
                        e eVar = d.this.dWD;
                        if (d.this.dXq) {
                            arrayList = null;
                        }
                        eVar.O(arrayList);
                    }
                }

                @Override // com.baidu.live.challenge.h
                public void nH() {
                }

                @Override // com.baidu.live.challenge.h
                public void nI() {
                }

                @Override // com.baidu.live.challenge.h
                public void af(boolean z2) {
                    d.this.aPu().eeM.setSwipeClearEnable(true);
                    d.this.dVf = false;
                    if (d.this.dWK != null) {
                        d.this.dWK.setPraiseEnable(true);
                        d.this.aPu().eeM.eqB = true;
                    }
                    if (d.this.dVY != null) {
                        d.this.dVY.setCanVisible(true);
                        d.this.dVY.k(d.this.aPu().eeL.uk());
                    }
                    if (d.this.dWM != null) {
                        d.this.dWM.in(true);
                    }
                    if (d.this.dVZ != null) {
                        d.this.dVZ.hk(false);
                        d.this.dVZ.setVisible(0);
                    }
                    if (d.this.dWa != null) {
                        d.this.dWa.setCanVisible(true);
                        d.this.dWa.setVisible(0);
                    }
                    if (d.this.dWD != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.aPu().eeL.aVl());
                        e eVar = d.this.dWD;
                        if (d.this.dXq) {
                            arrayList = null;
                        }
                        eVar.O(arrayList);
                    }
                    if (d.this.aPu().eeK != null) {
                        d.this.aPu().eeK.setBackgroundResource(a.f.sdk_transparent_bg);
                    }
                    if (d.this.dWI != null) {
                        d.this.dWI.setTimeTextMode(false);
                    }
                }
            });
        }
        this.dWc.a(this.dWb);
        this.dWc.e(aPu().eeN);
        this.dWc.b(z, false, false);
        this.dWb.a((j.e) this.dWc);
        this.dWb.a((j.c) this.dWc);
    }

    private void hC(boolean z) {
        CustomResponsedMessage runTask;
        if (aPu().eeL.uk().mLiveInfo.live_type == 1 && com.baidu.live.l.a.uB().ajF.QW) {
            if (this.dWa == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.c.a.class, aPu().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.c.a)) {
                this.dWa = (com.baidu.live.c.a) runTask.getData();
            }
            if (this.dWa != null) {
                this.dWa.a(aPu().eeL.aVm(), false, false);
                if (aPu().eeL.uk().mLiveInfo.pkId > 0 && this.dWa.getRootView() != null && this.dWa.getRootView().getParent() == null && this.dVP != null) {
                    if (this.dVP.getChildCount() <= 0) {
                        this.dVP.addView(this.dWa.getRootView(), new LinearLayout.LayoutParams(-2, -2));
                    } else {
                        View childAt = this.dVP.getChildAt(0);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.topMargin = aPu().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                        childAt.setLayoutParams(layoutParams);
                        this.dVP.addView(this.dWa.getRootView(), 0, new LinearLayout.LayoutParams(-2, -2));
                    }
                }
                if (z) {
                    this.dWa.a(null, aPu().eeL.uk());
                } else {
                    this.dWa.a(aPu().eeL.uk());
                }
            }
        }
    }

    public void aOz() {
        this.dWF.c(aPu().eeL.uk(), false);
    }

    public void aOA() {
        if (aPu().eeL.uk() != null && aPu().eeL.uk().OR != null && aPu().eeL.uk().mLiveInfo != null) {
            if (this.dVV == null) {
                this.dVV = new com.baidu.tieba.ala.liveroom.p.b(aPu().pageContext);
            }
            long j = aPu().eeL.uk().OR.userId;
            int i = aPu().eeL.uk().mLiveInfo.live_type;
            String str = aPu().eeL.uk().OR.portrait;
            String str2 = aPu().eeL.uk().mLiveInfo.feed_id;
            long j2 = aPu().eeL.uk().mLiveInfo.live_id;
            this.dVV.a(i, j, aPu().eeL.uk().OR.userName, false, str, tn(), str2, j2);
            this.dVV.Z(this.dXh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOB() {
        if (aPu() == null || aPu().eeL == null || aPu().eeL.uk() == null || aPu().eeL.uk().Pj == null) {
            if (aPu().eeL == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (aPu().eeL.uk() == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (aPu().eeL.uk().Pj == null) {
                Log.i("RenameLog", "getLiveContext().liveModel.getLiveShowData().mLoginUserInfo == null");
                return;
            } else {
                return;
            }
        }
        String str = aPu().eeL.uk().Pj.userName;
        Log.i("RenameLog", "loginUserName:" + str);
        if (str != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), aPu().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt))) {
            com.baidu.live.c.np().putInt("guide_rename_show_count", com.baidu.live.c.np().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.tZ().aE(true);
            if (this.dVU == null) {
                this.dVU = new com.baidu.tieba.ala.liveroom.q.b(aPu().pageContext);
            }
            this.dVU.setOtherParams(tn());
            this.dVU.f(this.dXi, aPu().eeL.uk());
            hv(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dVU.aVS();
                    d.this.hv(false);
                }
            }, 5000L);
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_SHOW);
            alaStaticItem.addParams("other_params", tn());
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    private void aOC() {
        boolean z = false;
        if (this.dWM == null) {
            this.dWM = new com.baidu.tieba.ala.liveroom.s.a(aPu().pageContext, this);
        }
        this.dWM.d(aPu().eeM, false);
        if (aPt() && aPu().eeL.uk().mLiveInfo.screen_direction != 2) {
            z = true;
        }
        this.dWM.im(z);
    }

    private void aOE() {
        if (this.dXo || this.dXp) {
            if ((TbadkCoreApplication.isLogin() && this.dWQ.sF().hasText()) || this.dXp) {
                this.dXo = false;
                this.dXp = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.6
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.aOX();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void g(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        super.g(aVar);
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
        } catch (JSONException e) {
            jSONObject = null;
        }
        if ((aVar.getMsgType() == 12 || aVar.getMsgType() == 13) && jSONObject != null) {
            String optString = jSONObject.optString("content_type");
            if ("task".equals(optString)) {
                if (this.dVY != null) {
                    this.dVY.y(jSONObject);
                }
            } else if ("enter_live".equals(optString)) {
                if (this.dVX.getCount() > 20) {
                    this.dVX.bU(this.dVX.getCount() + 1);
                } else if (this.dVR != null) {
                    com.baidu.live.data.a tf = aVar.tf();
                    com.baidu.live.data.d dVar = new com.baidu.live.data.d();
                    dVar.OT = new AlaLocationData();
                    dVar.OU = new AlaRelationData();
                    dVar.OR = new AlaLiveUserInfoData();
                    dVar.OR.userId = JavaTypesHelper.toLong(tf.userId, 0L);
                    dVar.OR.userName = tf.userName;
                    dVar.OR.portrait = tf.portrait;
                    if (this.dVR.c(dVar)) {
                        this.dVX.bU(this.dVX.getCount() + 1);
                    }
                }
            } else if ("update_liveinfo".equals(optString) && aPu().eeL.uk() != null && aPu().eeL.uk().mLiveInfo != null) {
                aPu().eeL.a(aPu().eeL.uk().mLiveInfo.live_id, aPu().fromType, aPu().enterTime);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void tv(String str) {
        if (this.dVZ != null) {
            this.dVZ.tv(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void a(com.baidu.live.data.i iVar) {
        super.a(iVar);
        if (this.dVS != null) {
            this.dVS.l(iVar);
        }
        if (this.dVT != null) {
            this.dVT.h(iVar);
        }
        if (this.dVY != null) {
            this.dVY.k(iVar);
        }
        if (this.dWc != null) {
            this.dWc.b(iVar);
        }
        hC(false);
        hA(false);
        if (this.dVZ != null) {
            this.dVZ.g(iVar);
            if (iVar != null && this.dXg != null && !this.dXg.hasInit && !TextUtils.isEmpty(this.dXg.efy)) {
                this.dXg.hasInit = true;
                Log.e("Da88", "openDetail--1---url = " + this.dXg.efy);
                this.dVZ.tw(this.dXg.efy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void b(com.baidu.live.data.e eVar) {
        if (eVar != null) {
            if (this.dVR != null && eVar.getList() != null) {
                this.dVR.e(eVar);
            }
            if (this.dVX != null) {
                this.dVX.bU(eVar.getCount());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void hp(boolean z) {
        super.hp(z);
        this.dXL = false;
        if (aPu().eeM != null) {
            aPu().eeM.aWE();
            aPu().eeM.setOnDispatchTouchEventListener(null);
            aPu().eeM.setOnLiveViewScrollListener(null);
        }
        if (aPu().eeK != null) {
            aPu().eeK.setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.dWc != null) {
            this.dWc.nA();
        }
        aOG();
        if (this.dVV != null) {
            this.dVV.nA();
        }
        if (this.dWM != null) {
            this.dWM.release();
        }
        if (this.dVY != null) {
            this.dVY.nA();
        }
        if (this.dVW != null) {
            this.dVW.aVp();
        }
        if (this.dVT != null) {
            this.dVT.aRq();
            this.dVT.setVisible(8);
        }
        if (this.dWa != null) {
            this.dWa.nA();
        }
        if (this.dVZ != null) {
            this.dVZ.release();
        }
        if (this.dVP != null) {
            this.dVP.removeAllViews();
            this.dVP = null;
        }
        if (this.dVQ != null) {
            this.dVQ.removeAllViews();
            this.dVQ = null;
        }
        if (this.dWM != null) {
            this.dWM.onDestroy();
        }
        if (this.dWb != null) {
            this.dWb.nA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onDestory() {
        super.onDestory();
        aOG();
        if (this.dVS != null) {
            this.dVS.onDestroy();
        }
        if (this.dVV != null) {
            this.dVV.onDestroy();
        }
        if (this.dVY != null) {
            this.dVY.onDestroy();
        }
        if (this.dWa != null) {
            this.dWa.onDestroy();
        }
        if (this.dWb != null) {
            this.dWb.onDestroy();
        }
        if (this.dWc != null) {
            this.dWc.onDestroy();
        }
        if (this.dWd != null) {
            this.dWd.onDestroy();
        }
        if (this.dVT != null) {
            this.dVT.onDestroy();
        }
        if (this.dVR != null) {
            this.dVR.onDestroy();
        }
        if (this.dWQ != null) {
            this.dWQ.onDestroy();
        }
        if (this.dVW != null) {
            this.dVW.onDestory();
        }
        MessageManager.getInstance().removeMessageRule(this.dWo);
        MessageManager.getInstance().removeMessageRule(this.dWp);
        if (this.dVZ != null) {
            this.dVZ.release();
        }
        MessageManager.getInstance().unRegisterListener(this.dWr);
        MessageManager.getInstance().unRegisterListener(this.dWs);
        MessageManager.getInstance().unRegisterListener(this.dXM);
        MessageManager.getInstance().unRegisterListener(this.dWt);
        MessageManager.getInstance().unRegisterListener(this.dWu);
    }

    private void aOG() {
        if (this.dWQ != null && this.dWQ.sE().getView() != null && this.dWQ.sE().getView().getParent() != null) {
            ((ViewGroup) this.dWQ.sE().getView().getParent()).removeView(this.dWQ.sE().getView());
        }
        if (this.dWg != null && this.dWg.getParent() != null) {
            ((ViewGroup) this.dWg.getParent()).removeView(this.dWg);
        }
        if (this.dWQ != null && this.dWQ.sF().getView() != null) {
            this.dXi.removeView(this.dWQ.sF().getView());
        }
        if (this.dWQ != null) {
            this.dWQ.sE().setMsgData(new LinkedList());
            this.dWQ.sk();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void a(s sVar) {
        if (this.dWQ != null) {
            aOX();
            this.dWQ.sF().setEditText(" @" + sVar.getNameShow() + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.dVW != null) {
            this.dVW.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void e(com.baidu.live.data.a aVar) {
        if (this.dWQ != null) {
            aOX();
            this.dWQ.sF().setEditText(" @" + aVar.userName + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.dVW != null) {
            this.dVW.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void b(s sVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected View aOH() {
        if (this.dWQ != null) {
            return this.dWQ.sF().getView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean aOI() {
        if (this.dWQ == null || !this.dWQ.sF().tG()) {
            return false;
        }
        hr(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean aOJ() {
        return this.dVS == null || this.dVS.aOJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 24009) {
            if (i2 == -1) {
                if (intent != null && "ala_live_room_show_gift_panel".equals(intent.getStringExtra("ala_live_room_show_panel_key"))) {
                    int intExtra = intent.getIntExtra("ala_live_room_gift_panel_tab_id", -1);
                    int intExtra2 = intent.getIntExtra("ala_live_room_gift_panel_category_id", -1);
                    int intExtra3 = intent.getIntExtra("ala_live_room_gift_panel_gift_id", -1);
                    this.dXl = false;
                    F(intExtra, intExtra2, intExtra3);
                    return;
                }
                aOz();
                return;
            }
            aPs();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.dWQ != null && this.dWQ.sE() != null) {
            this.dWQ.sE().onKeyboardVisibilityChanged(z);
        }
        if (z || this.dWQ == null || !this.dWQ.sF().tG()) {
            if (z) {
                if (this.dVW != null) {
                    this.dVW.setVisibility(8);
                }
                if (this.dWS != null && this.dWS.pB() != null) {
                    this.dWS.pB().setVisibility(8);
                }
                aOL();
                if (this.dWQ != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dWQ.sF().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.dWQ.sF().getView().setLayoutParams(layoutParams);
                    this.dWQ.sF().getView().setVisibility(0);
                    this.dWQ.sF().setQuickInputPanelVisible(false);
                }
                if (this.dXh != null) {
                    this.dXh.setVisibility(8);
                }
                if (this.dVZ != null) {
                    this.dVZ.setVisible(8);
                }
                if (this.dWR != null) {
                    this.dWR.sL();
                }
            } else {
                aOK();
            }
            if (this.dWQ != null && this.dWg != null) {
                int equipmentHeight = (int) (((z ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(aPu().pageContext.getPageActivity())) + aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
                if (this.dXi.indexOfChild(this.dWg) != -1 && this.dWg.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dWg.getLayoutParams();
                    layoutParams2.height = aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds27) + equipmentHeight;
                    this.dWg.setLayoutParams(layoutParams2);
                }
                if (this.dWg.indexOfChild(this.dWQ.sE().getView()) != -1 && this.dWQ.sE().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.dWQ.sE().getView().getLayoutParams();
                    layoutParams3.height = equipmentHeight;
                    this.dWQ.sE().getView().setLayoutParams(layoutParams3);
                }
                this.dWQ.sE().sD();
            }
        }
    }

    private void aOK() {
        if (this.dVW != null) {
            this.dVW.setVisibility(0);
        }
        if (this.dWg != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dWg.getLayoutParams();
            layoutParams.bottomMargin = aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
            this.dWg.setLayoutParams(layoutParams);
        }
        if (this.dWQ != null) {
            aOY();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dWQ.sF().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.dWQ.sF().getView().setLayoutParams(layoutParams2);
        }
        if (this.dVW != null) {
            this.dVW.setVisibility(0);
        }
        if (this.dWS != null && this.dWS.pB() != null) {
            this.dWS.pB().setVisibility(0);
        }
        if (this.dXh != null) {
            this.dXh.setVisibility(0);
        }
        if (this.dVZ != null) {
            this.dVZ.setVisible(0);
        }
        if (this.dWR != null) {
            this.dWR.sL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOL() {
        if (this.dWg != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dWg.getLayoutParams();
            boolean z = false;
            if (this.dWQ != null && this.dWQ.sF() != null) {
                z = this.dWQ.sF().tF();
            }
            int hw = hw(z);
            if (layoutParams.bottomMargin != hw) {
                layoutParams.bottomMargin = hw;
                this.dWg.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hr(boolean z) {
        if (z) {
            this.dWQ.sF().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dWg.getLayoutParams();
            int quickInputPanelExpandHeight = this.dWQ.sF().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.dWg.setLayoutParams(layoutParams);
                if (this.dWQ.sE() != null) {
                    this.dWQ.sE().sD();
                    return;
                }
                return;
            }
            return;
        }
        aOK();
        onKeyboardVisibilityChanged(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void E(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.dVR != null) {
                this.dVR.bw(i3);
            }
            if (this.dVT != null) {
                this.dVT.bw(i3);
            }
        }
        super.E(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.tieba.ala.liveroom.b
    public boolean mZ(int i) {
        boolean mZ = super.mZ(i);
        if (mZ && 2 == i) {
            if (this.dVS.aOJ()) {
                return false;
            }
            if (mZ && this.dWM != null) {
                this.dWM.in(false);
            }
        }
        return mZ;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void nr(int i) {
        super.nr(i);
        if (i == 7 || i == 11) {
            if (this.dVW != null) {
                this.dVW.setVisibility(8);
            }
            if (this.dWQ != null) {
                this.dWQ.sE().getView().setVisibility(4);
            }
            if (this.dVZ != null) {
                this.dVZ.aP(2, 8);
            }
            if (this.dXd != null) {
                this.dXd.ii(false);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.tieba.ala.liveroom.b
    public void na(int i) {
        super.na(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.tieba.ala.liveroom.b
    public void nb(int i) {
        super.nb(i);
        if (i == 7 || i == 11) {
            if (this.dVW != null) {
                this.dVW.setVisibility(0);
            }
            if (this.dWQ != null) {
                this.dWQ.sE().getView().setVisibility(0);
            }
            if (this.dVZ != null) {
                this.dVZ.aP(2, 0);
            }
            if (this.dXd != null) {
                this.dXd.ii(true);
            }
            this.dXh.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void aOM() {
        super.aOM();
        if (this.dVV != null) {
            this.dVV.aVN();
        }
        if (this.dWb != null) {
            this.dWb.nK();
        }
        if (this.dVZ != null) {
            this.dVZ.onStop();
        }
        if (this.dWa != null) {
            this.dWa.ad(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void aON() {
        super.aON();
        if (this.dVV != null) {
            this.dVV.aVM();
        }
        if (this.dWb != null) {
            this.dWb.nL();
        }
        if (this.dVZ != null) {
            this.dVZ.onStart();
        }
        if (this.dWa != null) {
            this.dWa.ad(false);
        }
    }
}
