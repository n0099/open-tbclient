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
    private boolean dVW;
    private RelativeLayout dWG;
    private LinearLayout dWH;
    private com.baidu.tieba.ala.liveroom.audiencelist.c dWI;
    private com.baidu.tieba.ala.liveroom.l.a dWJ;
    private com.baidu.tieba.ala.liveroom.e.b dWK;
    private com.baidu.tieba.ala.liveroom.q.b dWL;
    private com.baidu.tieba.ala.liveroom.p.b dWM;
    private com.baidu.tieba.ala.liveroom.operation.a dWN;
    private com.baidu.tieba.ala.liveroom.audiencelist.b dWO;
    private com.baidu.tieba.ala.liveroom.i.a dWP;
    private com.baidu.tieba.ala.liveroom.activeview.b dWQ;
    private com.baidu.live.c.a dWR;
    private j dWS;
    private i dWT;
    private com.baidu.tieba.ala.liveroom.attentionpop.b dWU;
    private FrameLayout dWX;
    private f dYB;
    private long lastClickTime = 0;
    private boolean dYC = false;
    private HttpRule dXf = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.dWS != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.dWS.nP()) {
                httpMessage.addParam("ala_challenge_id", d.this.dWS.nT());
            }
            return httpMessage;
        }
    };
    private HttpRule dXg = new HttpRule(1021151) { // from class: com.baidu.tieba.ala.liveroom.c.d.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.dWS != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.dWS.nP()) {
                httpMessage.addParam("challenge_id", d.this.dWS.nT());
            }
            return httpMessage;
        }
    };
    private AlaLiveView.c dXh = new AlaLiveView.c() { // from class: com.baidu.tieba.ala.liveroom.c.d.8
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void aOQ() {
            if (d.this.dXD != null) {
                d.this.dXD.in(false);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void hs(boolean z) {
            if (z) {
                if (d.this.dWN != null) {
                    d.this.dWN.nX(8);
                }
                if (d.this.dXD != null) {
                    d.this.dXD.in(true);
                    return;
                }
                return;
            }
            if (d.this.dWN != null) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                    d.this.dWN.nX(0);
                } else {
                    d.this.dWN.nX(8);
                }
            }
            if (d.this.dXD != null) {
                d.this.dXD.in(false);
            }
        }
    };
    private HttpMessageListener dXi = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.d.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.ur() != null) {
                        com.baidu.live.l.c.uG().akX = getQuickGiftHttpResponseMessage.ur();
                        d.this.aOu();
                    }
                }
            }
        }
    };
    private CustomMessageListener dXj = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.aOD();
        }
    };
    private CustomMessageListener dYD = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.c.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = (AlaBroadcastGiftToastData) customResponsedMessage.getData();
                if (d.this.dXK instanceof com.baidu.live.gift.broadcastgift.a) {
                    ((com.baidu.live.gift.broadcastgift.a) d.this.dXK).b(alaBroadcastGiftToastData);
                }
            }
        }
    };
    CustomMessageListener dXk = new CustomMessageListener(CmdConfigCustom.CMD_HOST_GET_WALLET_UA) { // from class: com.baidu.tieba.ala.liveroom.c.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.dYe != null && d.this.dYe.dLd != null && !d.this.dYe.dLJ && !d.this.dYe.dOk) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.aPw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = d.this.aPw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                d.this.dXS.c(d.this.dWX, layoutParams);
                com.baidu.tieba.ala.guardclub.a.aLg().aLh();
            }
        }
    };
    private CustomMessageListener dXl = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.d.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof Integer)) {
                if (d.this.dXT != null) {
                    d.this.dXT.dismiss();
                }
                k.sM().ax(true);
                k.sM().setSelect(((Integer) customResponsedMessage.getData()).intValue());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.aOZ();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b dXm = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.d.4
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
                    alaStaticItem.addParams("gifts_value", com.baidu.live.l.c.uG().akX.pF().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.l.c.uG().akX.pF().pc());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.l.c.uG().akX.pF().pd());
                    if (d.this.aPw().efC.uj() != null && d.this.aPw().efC.uj().mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", d.this.aPw().efC.uj().mLiveInfo.feed_id);
                        alaStaticItem.addParams("room_id", d.this.aPw().efC.uj().mLiveInfo.room_id);
                    }
                    alaStaticItem.addParams("other_params", d.this.tm());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    if (d.this.rA()) {
                        if (com.baidu.live.c.np().getBoolean("quick_gift_guide_show", true)) {
                            com.baidu.live.gift.container.e eVar = new com.baidu.live.gift.container.e(d.this.aPw().pageContext.getPageActivity(), d.this.aPw().pageContext, d.this.aPw().efC.uj(), com.baidu.live.l.c.uG().akX.pF(), d.this.tm());
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
                        com.baidu.live.gift.b.c.a(d.this.aPw().pageContext, d.this.aPw().efC.uj(), com.baidu.live.l.c.uG().akX.pF(), d.this.tm());
                    }
                } else if (i == 1) {
                    if (d.this.dXH != null) {
                        d.this.aOZ();
                    }
                } else if (i == 3 && d.this.rA()) {
                    d.this.dXw.c(d.this.aPw().efC.uj(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.aPw() != null && d.this.aPw().efC != null && d.this.aPw().efC.uj() != null && d.this.aPw().efC.uj().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.aPw().efC.uj().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.aPw().efC.uj().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.aPw().efC.uj().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.tm());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.aPw() != null && d.this.aPw().efC != null && d.this.aPw().efC.uj() != null && d.this.aPw().efC.uj().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.aPw().efC.uj().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.aPw().efC.uj().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.aPw().efC.uj().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.tm());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.dXu != null) {
                        d.this.dXu.aPK();
                    }
                } else if (i == 12) {
                    if (d.this.dXD != null) {
                        String valueOf = String.valueOf(d.this.aPw().efC.uj().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.aPw().efC.uj().mLiveInfo.room_id);
                        String str2 = null;
                        h hVar = d.this.aPw().efC.uj().mLiveSdkInfo;
                        if (hVar != null && hVar.mCastIds != null) {
                            str2 = String.valueOf(d.this.aPw().efC.uj().mLiveSdkInfo.mCastIds.PG);
                        }
                        d.this.dXD.R(valueOf, valueOf2, str2);
                        if (com.baidu.live.liveroom.a.tY().tZ()) {
                            d.this.aOD();
                        }
                    }
                } else if (i == 14) {
                    com.baidu.live.data.i uj = d.this.aPw().efC.uj();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.aPw().pageContext.getPageActivity(), uj.Ps.userName, Long.toString(uj.Ps.userId), Long.toString(uj.Ps.charmCount), String.valueOf(uj.mLiveInfo.group_id), String.valueOf(uj.mLiveInfo.live_id), false, String.valueOf(uj.Ps.userId), Long.toString(uj.PN.userId), uj.PN.userName, uj.PN.portrait, d.this.dWO.getCount(), d.this.tm())));
                    LogManager.getCommonLogger().doClickGusetNumLog(uj.mLiveInfo.feed_id, d.this.dWO.getCount() + "", d.this.tm());
                } else if (i == 11) {
                    d.this.aPc();
                    d.this.aPd();
                } else if (i == 15) {
                    if (d.this.dXQ != null && d.this.aPw() != null && d.this.aPw().efC != null && d.this.aPw().efC.uj() != null && d.this.aPw().efC.uj().mLiveInfo != null) {
                        long j = d.this.aPw().efC.uj().mLiveInfo.live_id;
                        String valueOf3 = String.valueOf(d.this.aPw().efC.uj().mLiveInfo.feed_id);
                        long j2 = d.this.aPw().efC.uj().mLiveInfo.room_id;
                        String str3 = d.this.aPw().efC.uj().mLiveInfo.cover;
                        String str4 = "";
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        if (d.this.aPw().efC.uj().mLiveInfo.session_info != null) {
                            str4 = d.this.aPw().efC.uj().mLiveInfo.session_info.flvUrl;
                        }
                        if (!TextUtils.isEmpty(d.this.tm())) {
                            try {
                                JSONObject jSONObject = new JSONObject(d.this.tm());
                                str5 = jSONObject.optString("tab");
                                str6 = jSONObject.optString("tag");
                                str7 = jSONObject.optString("source");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        d.this.dXQ.tB(m.a(valueOf3, j + "", j2, false, 1, str3, str4, str5, str6, str7));
                        m.arv = j;
                        if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                            ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                            LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf3, d.this.tm());
                        }
                    }
                } else if (i == 16) {
                    if (d.this.aPw() != null && (afVar2 = com.baidu.live.l.a.uA().akM) != null && (alVar2 = afVar2.Ue) != null) {
                        String str8 = alVar2.UM.US;
                        if (!TextUtils.isEmpty(str8)) {
                            long j3 = 0;
                            if (d.this.aPw().efC != null && d.this.aPw().efC.uj() != null && d.this.aPw().efC.uj().mLiveInfo != null) {
                                j3 = d.this.aPw().efC.uj().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j3 + "", d.this.aPw().efC.uj().mLiveInfo.room_id + "", d.this.aPw().efC.uj().mLiveInfo.feed_id, d.this.tm());
                            }
                            if (str8.contains("?")) {
                                str = str8 + "&liveId=" + j3;
                            } else {
                                str = str8 + "?liveId=" + j3;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.aPw().pageContext.getPageActivity(), str);
                        }
                    }
                } else if (i == 17 && d.this.rA() && d.this.aPw() != null && (afVar = com.baidu.live.l.a.uA().akM) != null && (alVar = afVar.Ue) != null && (aqVar = alVar.UN) != null && !TextUtils.isEmpty(aqVar.webUrl) && d.this.dXT != null && d.this.aPw().efC != null && d.this.aPw().efC.uj() != null) {
                    com.baidu.live.data.i uj2 = d.this.aPw().efC.uj();
                    d.this.dXT.a(aqVar.webUrl, uj2.mLiveInfo.live_id, uj2.PN.userId, uj2.Ps.userId);
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void init() {
        super.init();
        this.dXy = new com.baidu.tieba.ala.liveroom.guide.a(aPw().pageContext, this, false);
        this.dXf.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.dXf);
        this.dXg.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.dXg);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean aOh() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void uM() {
        super.uM();
        this.dYC = true;
        aPw().efD.setIsForceHandledTouch(false);
        aPw().efD.setSwipeClearEnable(true);
        aPw().efD.setOnLiveViewScrollListener(this.dXh);
        if (this.dXB != null) {
            this.dXB.b(this.dXm);
        }
        if (this.dXY != null) {
            this.dXY.setVisibility(0);
        }
        aOm();
        aOn();
        aOx();
        aOy();
        aOA();
        aOz();
        ho(false);
        aPf();
        aOp();
        aOv();
        aPh();
        aOC();
        aOE();
        hC(true);
        aPJ();
        aOo();
        aOu();
        aOq();
        aOr();
        aOs();
        hA(true);
        aPm();
        MessageManager.getInstance().registerListener(this.dXi);
        MessageManager.getInstance().registerListener(this.dXj);
        MessageManager.getInstance().registerListener(this.dYD);
        MessageManager.getInstance().registerListener(this.dXk);
        MessageManager.getInstance().registerListener(this.dXl);
        aOG();
    }

    private void aOj() {
        if (this.dXC != null) {
            this.dXC.ae(aPw().efE);
        }
    }

    private void aPJ() {
        if (this.dWU == null) {
            this.dWU = new com.baidu.tieba.ala.liveroom.attentionpop.b(aPw().pageContext);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void aS(int i) {
        super.aS(i);
        aOj();
        if (this.dWT != null) {
            this.dWT.aS(i);
        }
        if (this.dWT == null || !this.dWT.isActive()) {
        }
    }

    private void aOm() {
        if (this.dWG == null) {
            this.dWG = new RelativeLayout(aPw().pageContext.getPageActivity());
        }
        if (this.dWG.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            layoutParams.topMargin = aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds248);
            layoutParams.rightMargin = aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
            layoutParams.bottomMargin = aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds112);
            aPw().efD.addView(this.dWG, layoutParams);
        }
    }

    private void aOn() {
        if (this.dWH == null) {
            this.dWH = new LinearLayout(aPw().pageContext.getPageActivity());
            this.dWH.setOrientation(1);
        }
        if (this.dWH.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200);
            layoutParams.leftMargin = aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            aPw().efD.addView(this.dWH, layoutParams);
        }
    }

    private void aOp() {
        if (this.dXA != null && aPw() != null && aPw().efC != null) {
            this.dXA.b(this.dXY, aPw().efC.uj());
        }
    }

    private void aOo() {
        if (this.dWQ == null) {
            this.dWQ = new com.baidu.tieba.ala.liveroom.activeview.b(aPw().pageContext);
        }
        this.dWQ.hk(this.dVW);
        this.dWQ.setOtherParams(tm());
        this.dWQ.b(aPw().efC.uj(), false);
        this.dWQ.setHost(false);
        this.dWQ.a(1, this.dWH, nr(1));
        this.dWQ.a(2, this.dWG, nr(2));
        this.dWQ.setVisible(this.dYb ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOu() {
        if (this.dWN == null) {
            aOz();
        }
        this.dWN.setOtherParams(tm());
        this.dWN.a(com.baidu.live.l.c.uG().akX, aPw().efC.uj());
    }

    private ViewGroup.LayoutParams nr(int i) {
        switch (i) {
            case 1:
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (this.dWH == null || this.dWH.getChildCount() == 0) {
                    return layoutParams;
                }
                layoutParams.topMargin = aPw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                return layoutParams;
            case 2:
                ViewGroup.LayoutParams layoutParams2 = this.dWG.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(((int) (BdUtilHelper.getEquipmentWidth(aPw().pageContext.getPageActivity()) * 0.25f)) - ((layoutParams2 instanceof RelativeLayout.LayoutParams ? ((RelativeLayout.LayoutParams) layoutParams2).rightMargin : 0) * 2), -2);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                return layoutParams3;
            default:
                return new RelativeLayout.LayoutParams(-2, -2);
        }
    }

    private void aOq() {
        if (this.dWP == null) {
            this.dWP = new com.baidu.tieba.ala.liveroom.i.a(aPw().pageContext, this);
        }
        this.dWP.setOtherParams(tm());
        this.dWP.a(this.dWG, aOt());
        this.dWP.k(aPw().efC.uj());
    }

    private void aOr() {
        if (this.dXS == null) {
            this.dXS = new com.baidu.tieba.ala.liveroom.j.c(aPw().pageContext, tm());
        }
        if (this.dWX != null && this.dWX.indexOfChild(this.dXS.getView()) >= 0) {
            this.dWX.removeView(this.dXS.getView());
        }
    }

    private void aOs() {
        if (this.dWN != null) {
            this.dWN.a(new a.InterfaceC0369a() { // from class: com.baidu.tieba.ala.liveroom.c.d.14
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0369a
                public void aS(int i, int i2) {
                    com.baidu.live.data.i uj = d.this.aPw().efC.uj();
                    if (uj != null && uj.mLiveInfo != null) {
                        if (d.this.dXU == null) {
                            d.this.dXU = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.aPw().pageContext.getPageActivity());
                        }
                        d.this.dXU.d(d.this.dXZ, i, i2);
                        d.this.dXU.a(String.valueOf(uj.mLiveInfo.live_id), new a.InterfaceC0372a() { // from class: com.baidu.tieba.ala.liveroom.c.d.14.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0372a
                            public void a(float f, String str) {
                                if (d.this.dWN != null) {
                                    d.this.dWN.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0369a
                public void aT(int i, int i2) {
                    if (d.this.dXU != null) {
                        d.this.dXU.bd(i, i2);
                    }
                }
            });
        }
    }

    private ViewGroup.LayoutParams aOt() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.topMargin = (ScreenHelper.getRealScreenHeight(aPw().pageContext.getPageActivity()) - this.dWG.getTop()) - aPw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds814);
        return layoutParams;
    }

    private void aOv() {
        CustomResponsedMessage runTask;
        if (this.dXH == null && (runTask = MessageManager.getInstance().runTask(2913039, com.baidu.live.im.i.class, aPw().pageContext)) != null && runTask.getData() != null) {
            this.dXH = (com.baidu.live.im.i) runTask.getData();
            this.dXH.setFromMaster(false);
            this.dXH.sD().getView().setId(a.g.ala_liveroom_msg_list);
            this.dXH.a(new i.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.2
                @Override // com.baidu.live.im.i.a
                public boolean sF() {
                    return d.this.rA();
                }

                @Override // com.baidu.live.im.i.a
                public void sG() {
                    d.this.dYf = true;
                }

                @Override // com.baidu.live.im.i.a
                public void cH(String str) {
                    if (!d.this.dYb) {
                        d.this.hr(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.aPw().pageContext.getPageActivity(), d.this.aPw().efE);
                    }
                    d.this.ty(str);
                }

                @Override // com.baidu.live.im.i.a
                public void sH() {
                    if (d.this.dYb) {
                        d.this.hr(true);
                        d.this.aPw().efE.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.aPw().pageContext.getPageActivity(), d.this.aPw().efE);
                            }
                        }, 10L);
                    } else if (d.this.dXH != null) {
                        d.this.dXH.sE().setQuickInputPanelVisible(false);
                        d.this.dXH.sE().tG();
                    }
                }

                @Override // com.baidu.live.im.i.a
                public void sI() {
                    if (d.this.dYb) {
                        d.this.aON();
                        if (d.this.dXI != null) {
                            d.this.dXI.sK();
                        }
                    }
                }
            });
            this.dWX = new FrameLayout(aPw().pageContext.getPageActivity());
            this.dWX.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.dXH != null && this.dWX != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(aPw().pageContext.getPageActivity()) * 0.75f);
            int dimensionPixelSize = aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64) + ((int) (BdUtilHelper.getEquipmentHeight(aPw().pageContext.getPageActivity()) * 0.27f));
            if (this.dXZ.indexOfChild(this.dWX) < 0) {
                if (this.dWX.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.dWX.getParent()).removeView(this.dWX);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds27) + dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
                this.dXZ.addView(this.dWX, layoutParams);
            }
            if (this.dWX.indexOfChild(this.dXH.sD().getView()) < 0) {
                if (this.dXH.sD().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.dXH.sD().getView()).removeView(this.dXH.sD().getView());
                }
                this.dWX.addView(this.dXH.sD().getView(), new FrameLayout.LayoutParams(equipmentWidth, dimensionPixelSize));
            }
            if (aPw().efD.indexOfChild(this.dXH.sE().getView()) < 0) {
                if (this.dXH.sE().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.dXH.sE().getView().getParent()).removeView(this.dXH.sE().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                aPa();
                aPw().efD.addView(this.dXH.sE().getView(), layoutParams2);
            }
            com.baidu.live.data.i uj = aPw().efC.uj();
            if (uj != null && uj.mLiveInfo != null) {
                this.dXH.setLogData(uj.mLiveInfo.feed_id, tm());
            }
            this.dXH.e(String.valueOf(aPw().efC.uj().mLiveInfo.group_id), String.valueOf(aPw().efC.uj().mLiveInfo.last_msg_id), String.valueOf(aPw().efC.uj().Ps.userId), String.valueOf(aPw().efC.uj().mLiveInfo.live_id), aPw().efC.uj().Ps.appId);
            hr(false);
        }
    }

    private void aOx() {
        if (this.dWJ == null) {
            this.dWJ = new com.baidu.tieba.ala.liveroom.l.a(aPw().pageContext, false, this);
        }
        this.dWJ.d(this.dXY, aPw().efC.uj());
        this.dWJ.a(this.dXm);
        this.dWJ.setOtherParams(tm());
    }

    private void aOy() {
        if (this.dWI == null) {
            this.dWI = new com.baidu.tieba.ala.liveroom.audiencelist.c(aPw().pageContext, this, false);
        }
        this.dWI.a(String.valueOf(aPw().efC.uj().mLiveInfo.group_id), String.valueOf(aPw().efC.uj().mLiveInfo.live_id), String.valueOf(aPw().efC.uj().Ps.userId), aPw().efC.uj());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.dWI.c(this.dXY, a.g.ala_liveroom_hostheader, a.g.ala_liveroom_audience_count_layout);
            this.dWI.e(aPw().efC.aKy());
            this.dWI.setOtherParams(tm());
        }
    }

    private void aOz() {
        if (this.dWN == null) {
            this.dWN = new com.baidu.tieba.ala.liveroom.operation.a(aPw().pageContext);
        }
        this.dWN.a(aPw(), this.dXZ, aPw().efC.uj().mLiveInfo.live_type, true, this.dXm);
        this.dWN.setOtherParams(tm());
    }

    public void hz(boolean z) {
        if (this.dWN != null) {
            this.dWN.hz(z);
        }
    }

    private void aOA() {
        if (this.dWO == null) {
            this.dWO = new com.baidu.tieba.ala.liveroom.audiencelist.b(aPw().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (aPw().efC.aKy() != null) {
            j = aPw().efC.aKy().getCount();
        }
        this.dWO.a(this.dXm);
        this.dWO.a(this.dXY, a.g.ala_liveroom_audience, j);
        this.dWO.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.dWO.hG(false);
        } else {
            this.dWO.hG(true);
        }
    }

    private void hA(boolean z) {
        CustomResponsedMessage runTask;
        if (aPw().efC.uj().mLiveInfo.live_type == 1) {
            if (this.dYB == null && (runTask = MessageManager.getInstance().runTask(2913074, f.class, aPw().pageContext)) != null && runTask.getData() != null) {
                this.dYB = (f) runTask.getData();
            }
            if (this.dYB != null) {
                if (this.dWS == null) {
                    this.dWS = this.dYB.a(aPw().pageContext);
                }
                if (aPw().efC.uj().mLiveInfo.challengeId > 0 && !this.dWS.nQ()) {
                    this.dWS.d(aPw().efC.uj().mLiveInfo.live_id, aPw().efC.uj().Ps.userId);
                    hB(z);
                    this.dWS.c(aPw().efC.uj());
                }
            }
        }
    }

    private void hB(boolean z) {
        if (this.dWT == null) {
            this.dWT = this.dYB.b(aPw().pageContext);
            this.dWT.a(new com.baidu.live.challenge.h() { // from class: com.baidu.tieba.ala.liveroom.c.d.3
                @Override // com.baidu.live.challenge.h
                public void nG() {
                    d.this.aPw().efD.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.h
                public void a(v vVar, w wVar, w wVar2) {
                    d.this.dVW = true;
                    if (d.this.dXB != null) {
                        d.this.dXB.setPraiseEnable(false);
                        d.this.aPw().efD.ert = false;
                    }
                    if (d.this.dWP != null) {
                        d.this.dWP.setCanVisible(false);
                        d.this.dWP.aRW();
                    }
                    if (d.this.dWQ != null) {
                        d.this.dWQ.hk(true);
                        d.this.dWQ.setVisible(8);
                    }
                    if (d.this.dWR != null) {
                        d.this.dWR.setCanVisible(false);
                        d.this.dWR.setVisible(8);
                    }
                    if (d.this.aPw().efB != null) {
                        d.this.aPw().efB.setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                    }
                    if (d.this.dXz != null) {
                        d.this.dXz.setTimeTextMode(true);
                    }
                    if (d.this.dXu != null && wVar != null && wVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(wVar.Tc);
                        arrayList.add(wVar2.Tc);
                        e eVar = d.this.dXu;
                        if (d.this.dYh) {
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
                    d.this.aPw().efD.setSwipeClearEnable(true);
                    d.this.dVW = false;
                    if (d.this.dXB != null) {
                        d.this.dXB.setPraiseEnable(true);
                        d.this.aPw().efD.ert = true;
                    }
                    if (d.this.dWP != null) {
                        d.this.dWP.setCanVisible(true);
                        d.this.dWP.k(d.this.aPw().efC.uj());
                    }
                    if (d.this.dXD != null) {
                        d.this.dXD.in(true);
                    }
                    if (d.this.dWQ != null) {
                        d.this.dWQ.hk(false);
                        d.this.dWQ.setVisible(0);
                    }
                    if (d.this.dWR != null) {
                        d.this.dWR.setCanVisible(true);
                        d.this.dWR.setVisible(0);
                    }
                    if (d.this.dXu != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.aPw().efC.aVn());
                        e eVar = d.this.dXu;
                        if (d.this.dYh) {
                            arrayList = null;
                        }
                        eVar.O(arrayList);
                    }
                    if (d.this.aPw().efB != null) {
                        d.this.aPw().efB.setBackgroundResource(a.f.sdk_transparent_bg);
                    }
                    if (d.this.dXz != null) {
                        d.this.dXz.setTimeTextMode(false);
                    }
                }
            });
        }
        this.dWT.a(this.dWS);
        this.dWT.e(aPw().efE);
        this.dWT.b(z, false, false);
        this.dWS.a((j.e) this.dWT);
        this.dWS.a((j.c) this.dWT);
    }

    private void hC(boolean z) {
        CustomResponsedMessage runTask;
        if (aPw().efC.uj().mLiveInfo.live_type == 1 && com.baidu.live.l.a.uA().ajX.Rw) {
            if (this.dWR == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.c.a.class, aPw().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.c.a)) {
                this.dWR = (com.baidu.live.c.a) runTask.getData();
            }
            if (this.dWR != null) {
                this.dWR.a(aPw().efC.aVo(), false, false);
                if (aPw().efC.uj().mLiveInfo.pkId > 0 && this.dWR.getRootView() != null && this.dWR.getRootView().getParent() == null && this.dWG != null) {
                    if (this.dWG.getChildCount() <= 0) {
                        this.dWG.addView(this.dWR.getRootView(), new LinearLayout.LayoutParams(-2, -2));
                    } else {
                        View childAt = this.dWG.getChildAt(0);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.topMargin = aPw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                        childAt.setLayoutParams(layoutParams);
                        this.dWG.addView(this.dWR.getRootView(), 0, new LinearLayout.LayoutParams(-2, -2));
                    }
                }
                if (z) {
                    this.dWR.a(null, aPw().efC.uj());
                } else {
                    this.dWR.a(aPw().efC.uj());
                }
            }
        }
    }

    public void aOB() {
        this.dXw.c(aPw().efC.uj(), false);
    }

    public void aOC() {
        if (aPw().efC.uj() != null && aPw().efC.uj().Ps != null && aPw().efC.uj().mLiveInfo != null) {
            if (this.dWM == null) {
                this.dWM = new com.baidu.tieba.ala.liveroom.p.b(aPw().pageContext);
            }
            long j = aPw().efC.uj().Ps.userId;
            int i = aPw().efC.uj().mLiveInfo.live_type;
            String str = aPw().efC.uj().Ps.portrait;
            String str2 = aPw().efC.uj().mLiveInfo.feed_id;
            long j2 = aPw().efC.uj().mLiveInfo.live_id;
            this.dWM.a(i, j, aPw().efC.uj().Ps.userName, false, str, tm(), str2, j2);
            this.dWM.Z(this.dXY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOD() {
        if (aPw() == null || aPw().efC == null || aPw().efC.uj() == null || aPw().efC.uj().PN == null) {
            if (aPw().efC == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (aPw().efC.uj() == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (aPw().efC.uj().PN == null) {
                Log.i("RenameLog", "getLiveContext().liveModel.getLiveShowData().mLoginUserInfo == null");
                return;
            } else {
                return;
            }
        }
        String str = aPw().efC.uj().PN.userName;
        Log.i("RenameLog", "loginUserName:" + str);
        if (str != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), aPw().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt))) {
            com.baidu.live.c.np().putInt("guide_rename_show_count", com.baidu.live.c.np().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.tY().aE(true);
            if (this.dWL == null) {
                this.dWL = new com.baidu.tieba.ala.liveroom.q.b(aPw().pageContext);
            }
            this.dWL.setOtherParams(tm());
            this.dWL.f(this.dXZ, aPw().efC.uj());
            hv(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dWL.aVU();
                    d.this.hv(false);
                }
            }, 5000L);
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_SHOW);
            alaStaticItem.addParams("other_params", tm());
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    private void aOE() {
        boolean z = false;
        if (this.dXD == null) {
            this.dXD = new com.baidu.tieba.ala.liveroom.s.a(aPw().pageContext, this);
        }
        this.dXD.d(aPw().efD, false);
        if (aPv() && aPw().efC.uj().mLiveInfo.screen_direction != 2) {
            z = true;
        }
        this.dXD.im(z);
    }

    private void aOG() {
        if (this.dYf || this.dYg) {
            if ((TbadkCoreApplication.isLogin() && this.dXH.sE().hasText()) || this.dYg) {
                this.dYf = false;
                this.dYg = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.6
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.aOZ();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void f(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        super.f(aVar);
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
                if (this.dWP != null) {
                    this.dWP.x(jSONObject);
                }
            } else if ("enter_live".equals(optString)) {
                if (this.dWO.getCount() > 20) {
                    this.dWO.bV(this.dWO.getCount() + 1);
                } else if (this.dWI != null) {
                    com.baidu.live.data.a te = aVar.te();
                    com.baidu.live.data.d dVar = new com.baidu.live.data.d();
                    dVar.Pt = new AlaLocationData();
                    dVar.Pu = new AlaRelationData();
                    dVar.Ps = new AlaLiveUserInfoData();
                    dVar.Ps.userId = JavaTypesHelper.toLong(te.userId, 0L);
                    dVar.Ps.userName = te.userName;
                    dVar.Ps.portrait = te.portrait;
                    if (this.dWI.c(dVar)) {
                        this.dWO.bV(this.dWO.getCount() + 1);
                    }
                }
            } else if ("update_liveinfo".equals(optString) && aPw().efC.uj() != null && aPw().efC.uj().mLiveInfo != null) {
                aPw().efC.a(aPw().efC.uj().mLiveInfo.live_id, aPw().fromType, aPw().enterTime);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void tv(String str) {
        if (this.dWQ != null) {
            this.dWQ.tv(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void a(com.baidu.live.data.i iVar) {
        super.a(iVar);
        if (this.dWJ != null) {
            this.dWJ.l(iVar);
        }
        if (this.dWK != null) {
            this.dWK.h(iVar);
        }
        if (this.dWP != null) {
            this.dWP.k(iVar);
        }
        if (this.dWT != null) {
            this.dWT.b(iVar);
        }
        hC(false);
        hA(false);
        if (this.dWQ != null) {
            this.dWQ.g(iVar);
            if (iVar != null && this.dXX != null && !this.dXX.hasInit && !TextUtils.isEmpty(this.dXX.egp)) {
                this.dXX.hasInit = true;
                this.dWQ.tw(this.dXX.egp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void b(com.baidu.live.data.e eVar) {
        if (eVar != null) {
            if (this.dWI != null && eVar.getList() != null) {
                this.dWI.e(eVar);
            }
            if (this.dWO != null) {
                this.dWO.bV(eVar.getCount());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void hp(boolean z) {
        super.hp(z);
        this.dYC = false;
        if (aPw().efD != null) {
            aPw().efD.aWG();
            aPw().efD.setOnDispatchTouchEventListener(null);
            aPw().efD.setOnLiveViewScrollListener(null);
        }
        if (aPw().efB != null) {
            aPw().efB.setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.dWT != null) {
            this.dWT.nA();
        }
        aOI();
        if (this.dWM != null) {
            this.dWM.nA();
        }
        if (this.dXD != null) {
            this.dXD.release();
        }
        if (this.dWP != null) {
            this.dWP.nA();
        }
        if (this.dWN != null) {
            this.dWN.aVr();
        }
        if (this.dWK != null) {
            this.dWK.aRs();
            this.dWK.setVisible(8);
        }
        if (this.dWR != null) {
            this.dWR.nA();
        }
        if (this.dWQ != null) {
            this.dWQ.release();
        }
        if (this.dWG != null) {
            this.dWG.removeAllViews();
            this.dWG = null;
        }
        if (this.dWH != null) {
            this.dWH.removeAllViews();
            this.dWH = null;
        }
        if (this.dXD != null) {
            this.dXD.onDestroy();
        }
        if (this.dWS != null) {
            this.dWS.nA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onDestory() {
        super.onDestory();
        aOI();
        if (this.dWJ != null) {
            this.dWJ.onDestroy();
        }
        if (this.dWM != null) {
            this.dWM.onDestroy();
        }
        if (this.dWP != null) {
            this.dWP.onDestroy();
        }
        if (this.dWR != null) {
            this.dWR.onDestroy();
        }
        if (this.dWS != null) {
            this.dWS.onDestroy();
        }
        if (this.dWT != null) {
            this.dWT.onDestroy();
        }
        if (this.dWU != null) {
            this.dWU.onDestroy();
        }
        if (this.dWK != null) {
            this.dWK.onDestroy();
        }
        if (this.dWI != null) {
            this.dWI.onDestroy();
        }
        if (this.dXH != null) {
            this.dXH.onDestroy();
        }
        if (this.dWN != null) {
            this.dWN.onDestory();
        }
        MessageManager.getInstance().removeMessageRule(this.dXf);
        MessageManager.getInstance().removeMessageRule(this.dXg);
        if (this.dWQ != null) {
            this.dWQ.release();
        }
        MessageManager.getInstance().unRegisterListener(this.dXi);
        MessageManager.getInstance().unRegisterListener(this.dXj);
        MessageManager.getInstance().unRegisterListener(this.dYD);
        MessageManager.getInstance().unRegisterListener(this.dXk);
        MessageManager.getInstance().unRegisterListener(this.dXl);
    }

    private void aOI() {
        if (this.dXH != null && this.dXH.sD().getView() != null && this.dXH.sD().getView().getParent() != null) {
            ((ViewGroup) this.dXH.sD().getView().getParent()).removeView(this.dXH.sD().getView());
        }
        if (this.dWX != null && this.dWX.getParent() != null) {
            ((ViewGroup) this.dWX.getParent()).removeView(this.dWX);
        }
        if (this.dXH != null && this.dXH.sE().getView() != null) {
            this.dXZ.removeView(this.dXH.sE().getView());
        }
        if (this.dXH != null) {
            this.dXH.sD().setMsgData(new LinkedList());
            this.dXH.sj();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void a(s sVar) {
        if (this.dXH != null) {
            aOZ();
            this.dXH.sE().setEditText(" @" + sVar.getNameShow() + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.dWN != null) {
            this.dWN.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void e(com.baidu.live.data.a aVar) {
        if (this.dXH != null) {
            aOZ();
            this.dXH.sE().setEditText(" @" + aVar.userName + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.dWN != null) {
            this.dWN.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void b(s sVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected View aOJ() {
        if (this.dXH != null) {
            return this.dXH.sE().getView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean aOK() {
        if (this.dXH == null || !this.dXH.sE().tF()) {
            return false;
        }
        hr(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean aOL() {
        return this.dWJ == null || this.dWJ.aOL();
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
                    this.dYc = false;
                    F(intExtra, intExtra2, intExtra3);
                    return;
                }
                aOB();
                return;
            }
            aPu();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.dXH != null && this.dXH.sD() != null) {
            this.dXH.sD().onKeyboardVisibilityChanged(z);
        }
        if (z || this.dXH == null || !this.dXH.sE().tF()) {
            if (z) {
                if (this.dWN != null) {
                    this.dWN.setVisibility(8);
                }
                if (this.dXJ != null && this.dXJ.pB() != null) {
                    this.dXJ.pB().setVisibility(8);
                }
                aON();
                if (this.dXH != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dXH.sE().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.dXH.sE().getView().setLayoutParams(layoutParams);
                    this.dXH.sE().getView().setVisibility(0);
                    this.dXH.sE().setQuickInputPanelVisible(false);
                }
                if (this.dXY != null) {
                    this.dXY.setVisibility(8);
                }
                if (this.dWQ != null) {
                    this.dWQ.setVisible(8);
                }
                if (this.dXI != null) {
                    this.dXI.sK();
                }
            } else {
                aOM();
            }
            if (this.dXH != null && this.dWX != null) {
                int equipmentHeight = (int) (((z ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(aPw().pageContext.getPageActivity())) + aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
                if (this.dXZ.indexOfChild(this.dWX) != -1 && this.dWX.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dWX.getLayoutParams();
                    layoutParams2.height = aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds27) + equipmentHeight;
                    this.dWX.setLayoutParams(layoutParams2);
                }
                if (this.dWX.indexOfChild(this.dXH.sD().getView()) != -1 && this.dXH.sD().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.dXH.sD().getView().getLayoutParams();
                    layoutParams3.height = equipmentHeight;
                    this.dXH.sD().getView().setLayoutParams(layoutParams3);
                }
                this.dXH.sD().sC();
            }
        }
    }

    private void aOM() {
        if (this.dWN != null) {
            this.dWN.setVisibility(0);
        }
        if (this.dWX != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dWX.getLayoutParams();
            layoutParams.bottomMargin = aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
            this.dWX.setLayoutParams(layoutParams);
        }
        if (this.dXH != null) {
            aPa();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dXH.sE().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.dXH.sE().getView().setLayoutParams(layoutParams2);
        }
        if (this.dWN != null) {
            this.dWN.setVisibility(0);
        }
        if (this.dXJ != null && this.dXJ.pB() != null) {
            this.dXJ.pB().setVisibility(0);
        }
        if (this.dXY != null) {
            this.dXY.setVisibility(0);
        }
        if (this.dWQ != null) {
            this.dWQ.setVisible(0);
        }
        if (this.dXI != null) {
            this.dXI.sK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aON() {
        if (this.dWX != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dWX.getLayoutParams();
            boolean z = false;
            if (this.dXH != null && this.dXH.sE() != null) {
                z = this.dXH.sE().tE();
            }
            int hw = hw(z);
            if (layoutParams.bottomMargin != hw) {
                layoutParams.bottomMargin = hw;
                this.dWX.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hr(boolean z) {
        if (z) {
            this.dXH.sE().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dWX.getLayoutParams();
            int quickInputPanelExpandHeight = this.dXH.sE().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.dWX.setLayoutParams(layoutParams);
                if (this.dXH.sD() != null) {
                    this.dXH.sD().sC();
                    return;
                }
                return;
            }
            return;
        }
        aOM();
        onKeyboardVisibilityChanged(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void E(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.dWI != null) {
                this.dWI.bw(i3);
            }
            if (this.dWK != null) {
                this.dWK.bw(i3);
            }
        }
        super.E(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.tieba.ala.liveroom.b
    public boolean na(int i) {
        boolean na = super.na(i);
        if (na && 2 == i) {
            if (this.dWJ.aOL()) {
                return false;
            }
            if (na && this.dXD != null) {
                this.dXD.in(false);
            }
        }
        return na;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void ns(int i) {
        super.ns(i);
        if (i == 7 || i == 11) {
            if (this.dWN != null) {
                this.dWN.setVisibility(8);
            }
            if (this.dXH != null) {
                this.dXH.sD().getView().setVisibility(4);
            }
            if (this.dWQ != null) {
                this.dWQ.aR(2, 8);
            }
            if (this.dXU != null) {
                this.dXU.ii(false);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.tieba.ala.liveroom.b
    public void nb(int i) {
        super.nb(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.tieba.ala.liveroom.b
    public void nc(int i) {
        super.nc(i);
        if (i == 7 || i == 11) {
            if (this.dWN != null) {
                this.dWN.setVisibility(0);
            }
            if (this.dXH != null) {
                this.dXH.sD().getView().setVisibility(0);
            }
            if (this.dWQ != null) {
                this.dWQ.aR(2, 0);
            }
            if (this.dXU != null) {
                this.dXU.ii(true);
            }
            this.dXY.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void aOO() {
        super.aOO();
        if (this.dWM != null) {
            this.dWM.aVP();
        }
        if (this.dWS != null) {
            this.dWS.nK();
        }
        if (this.dWQ != null) {
            this.dWQ.onStop();
        }
        if (this.dWR != null) {
            this.dWR.ad(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void aOP() {
        super.aOP();
        if (this.dWM != null) {
            this.dWM.aVO();
        }
        if (this.dWS != null) {
            this.dWS.nL();
        }
        if (this.dWQ != null) {
            this.dWQ.onStart();
        }
        if (this.dWR != null) {
            this.dWR.ad(false);
        }
    }
}
