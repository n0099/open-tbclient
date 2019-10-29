package com.baidu.tieba.ala.liveroom.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
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
import com.baidu.live.challenge.i;
import com.baidu.live.challenge.j;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.af;
import com.baidu.live.data.al;
import com.baidu.live.data.aq;
import com.baidu.live.data.h;
import com.baidu.live.data.s;
import com.baidu.live.im.i;
import com.baidu.live.im.j;
import com.baidu.live.im.k;
import com.baidu.live.k.a;
import com.baidu.live.message.GetQuickGiftHttpResponseMessage;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.log.ILiveGoodsLogger;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.utils.m;
import com.baidu.live.utils.n;
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends b {
    private LinearLayout dWF;
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
    private com.baidu.tieba.ala.liveroom.d.b dWV;
    private com.baidu.tieba.ala.liveroom.share.b dWW;
    private FrameLayout dWX;
    private FrameLayout dWY;
    private ImageView dWZ;
    private com.baidu.live.tieba.e.b dXa;
    private com.baidu.live.gift.container.e dXe;
    private long lastClickTime = 0;
    private boolean dXb = false;
    private boolean dXc = false;
    private Handler dXd = new Handler();
    private HttpRule dXf = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.dWS != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.dWS.nP()) {
                httpMessage.addParam("ala_challenge_id", a.this.dWS.nT());
            }
            return httpMessage;
        }
    };
    private HttpRule dXg = new HttpRule(1021151) { // from class: com.baidu.tieba.ala.liveroom.c.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.dWS != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.dWS.nP()) {
                httpMessage.addParam("challenge_id", a.this.dWS.nT());
            }
            return httpMessage;
        }
    };
    private AlaLiveView.c dXh = new AlaLiveView.c() { // from class: com.baidu.tieba.ala.liveroom.c.a.14
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void aOQ() {
            if (a.this.dXD != null) {
                a.this.dXD.in(false);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void hs(boolean z) {
            if (z) {
                if (a.this.dWN != null) {
                    a.this.dWN.nX(8);
                }
                if (a.this.dXD != null) {
                    a.this.dXD.in(true);
                    return;
                }
                return;
            }
            if (a.this.dWN != null) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                    a.this.dWN.nX(0);
                } else {
                    a.this.dWN.nX(8);
                }
            }
            if (a.this.dXD != null) {
                a.this.dXD.in(false);
            }
        }
    };
    private HttpMessageListener dXi = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.a.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.ur() != null) {
                        com.baidu.live.l.c.uG().akX = getQuickGiftHttpResponseMessage.ur();
                        a.this.aOu();
                    }
                }
            }
        }
    };
    private CustomMessageListener dXj = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.a.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.aOD();
        }
    };
    CustomMessageListener dXk = new CustomMessageListener(CmdConfigCustom.CMD_HOST_GET_WALLET_UA) { // from class: com.baidu.tieba.ala.liveroom.c.a.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.dYe != null && a.this.dYe.dLd != null && !a.this.dYe.dLJ && !a.this.dYe.dOk) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.aPw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = a.this.aPw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                a.this.dXS.c(a.this.dWX, layoutParams);
                com.baidu.tieba.ala.guardclub.a.aLg().aLh();
            }
        }
    };
    private CustomMessageListener dXl = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof Integer)) {
                if (a.this.dXT != null) {
                    a.this.dXT.dismiss();
                }
                k.sM().ax(true);
                k.sM().setSelect(((Integer) customResponsedMessage.getData()).intValue());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.aOZ();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b dXm = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.a.5
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void n(View view, int i) {
            af afVar;
            al alVar;
            aq aqVar;
            af afVar2;
            al alVar2;
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - a.this.lastClickTime >= 300) {
                a.this.lastClickTime = currentTimeMillis;
                if (i == 2 && a.this.rA()) {
                    a.this.F(-1, -1, -1);
                } else if (i == 13) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                    alaStaticItem.addParams("gifts_value", com.baidu.live.l.c.uG().akX.pF().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.l.c.uG().akX.pF().pc());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.l.c.uG().akX.pF().pd());
                    if (a.this.aPw().efC.uj() != null && a.this.aPw().efC.uj().mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", a.this.aPw().efC.uj().mLiveInfo.feed_id);
                        alaStaticItem.addParams("room_id", a.this.aPw().efC.uj().mLiveInfo.room_id);
                    }
                    alaStaticItem.addParams("other_params", a.this.tm());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    if (a.this.rA()) {
                        if (com.baidu.live.c.np().getBoolean("quick_gift_guide_show", true)) {
                            com.baidu.live.gift.container.e eVar = new com.baidu.live.gift.container.e(a.this.aPw().pageContext.getPageActivity(), a.this.aPw().pageContext, a.this.aPw().efC.uj(), com.baidu.live.l.c.uG().akX.pF(), a.this.tm());
                            eVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.5.1
                                @Override // android.content.DialogInterface.OnDismissListener
                                public void onDismiss(DialogInterface dialogInterface) {
                                    a.this.hu(false);
                                    a.this.dXe = null;
                                }
                            });
                            a.this.dXe = eVar;
                            eVar.show();
                            a.this.hu(true);
                            return;
                        }
                        com.baidu.live.gift.b.c.a(a.this.aPw().pageContext, a.this.aPw().efC.uj(), com.baidu.live.l.c.uG().akX.pF(), a.this.tm());
                    }
                } else if (i == 1) {
                    if (a.this.dXH != null) {
                        a.this.aOZ();
                    }
                } else if (i == 3 && a.this.rA()) {
                    if (a.this.mOrientation == 2 && TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.dWW != null) {
                            a.this.dWW.n(a.this.aPw().efC.uj());
                        }
                    } else {
                        a.this.dXw.c(a.this.aPw().efC.uj(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.aPw() != null && a.this.aPw().efC != null && a.this.aPw().efC.uj() != null && a.this.aPw().efC.uj().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.aPw().efC.uj().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.aPw().efC.uj().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.aPw().efC.uj().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.tm());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.aPw() != null && a.this.aPw().efC != null && a.this.aPw().efC.uj() != null && a.this.aPw().efC.uj().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.aPw().efC.uj().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.aPw().efC.uj().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.aPw().efC.uj().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.tm());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.dXu != null) {
                        a.this.dXu.aPK();
                    }
                } else if (i == 12) {
                    if (a.this.dXD != null) {
                        String valueOf = String.valueOf(a.this.aPw().efC.uj().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.aPw().efC.uj().mLiveInfo.room_id);
                        String str2 = null;
                        h hVar = a.this.aPw().efC.uj().mLiveSdkInfo;
                        if (hVar != null && hVar.mCastIds != null) {
                            str2 = String.valueOf(a.this.aPw().efC.uj().mLiveSdkInfo.mCastIds.PG);
                        }
                        a.this.dXD.R(valueOf, valueOf2, str2);
                        if (com.baidu.live.liveroom.a.tY().tZ()) {
                            a.this.aOD();
                        }
                    }
                } else if (i == 14) {
                    com.baidu.live.data.i uj = a.this.aPw().efC.uj();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.aPw().pageContext.getPageActivity(), uj.Ps.userName, Long.toString(uj.Ps.userId), Long.toString(uj.Ps.charmCount), String.valueOf(uj.mLiveInfo.group_id), String.valueOf(uj.mLiveInfo.live_id), false, String.valueOf(uj.Ps.userId), Long.toString(uj.PN.userId), uj.PN.userName, uj.PN.portrait, a.this.dWO.getCount(), a.this.tm())));
                    LogManager.getCommonLogger().doClickGusetNumLog(uj.mLiveInfo.feed_id, a.this.dWO.getCount() + "", a.this.tm());
                } else if (i == 11) {
                    a.this.aPc();
                    a.this.aPd();
                } else if (i == 15) {
                    if (a.this.dXQ != null && a.this.aPw() != null && a.this.aPw().efC != null && a.this.aPw().efC.uj() != null && a.this.aPw().efC.uj().mLiveInfo != null) {
                        long j = a.this.aPw().efC.uj().mLiveInfo.live_id;
                        String valueOf3 = String.valueOf(a.this.aPw().efC.uj().mLiveInfo.feed_id);
                        long j2 = a.this.aPw().efC.uj().mLiveInfo.room_id;
                        String str3 = a.this.aPw().efC.uj().mLiveInfo.cover;
                        String str4 = "";
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        if (a.this.aPw().efC.uj().mLiveInfo.session_info != null) {
                            str4 = a.this.aPw().efC.uj().mLiveInfo.session_info.flvUrl;
                        }
                        if (!TextUtils.isEmpty(a.this.tm())) {
                            try {
                                JSONObject jSONObject = new JSONObject(a.this.tm());
                                str5 = jSONObject.optString("tab");
                                str6 = jSONObject.optString("tag");
                                str7 = jSONObject.optString("source");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        a.this.dXQ.tB(m.a(valueOf3, j + "", j2, false, 1, str3, str4, str5, str6, str7));
                        m.arv = j;
                        if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                            ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                            LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf3, a.this.tm());
                        }
                    }
                } else if (i == 16) {
                    if (a.this.aPw() != null && (afVar2 = com.baidu.live.l.a.uA().akM) != null && (alVar2 = afVar2.Ue) != null) {
                        String str8 = alVar2.UM.US;
                        if (!TextUtils.isEmpty(str8)) {
                            long j3 = 0;
                            if (a.this.aPw().efC != null && a.this.aPw().efC.uj() != null && a.this.aPw().efC.uj().mLiveInfo != null) {
                                j3 = a.this.aPw().efC.uj().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j3 + "", a.this.aPw().efC.uj().mLiveInfo.room_id + "", a.this.aPw().efC.uj().mLiveInfo.feed_id, a.this.tm());
                            }
                            if (str8.contains("?")) {
                                str = str8 + "&liveId=" + j3;
                            } else {
                                str = str8 + "?liveId=" + j3;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.aPw().pageContext.getPageActivity(), str);
                        }
                    }
                } else if (i == 17) {
                    if (a.this.rA() && a.this.aPw() != null && (afVar = com.baidu.live.l.a.uA().akM) != null && (alVar = afVar.Ue) != null && (aqVar = alVar.UN) != null && !TextUtils.isEmpty(aqVar.webUrl) && a.this.dXT != null && a.this.aPw().efC != null && a.this.aPw().efC.uj() != null) {
                        com.baidu.live.data.i uj2 = a.this.aPw().efC.uj();
                        a.this.dXT.a(aqVar.webUrl, uj2.mLiveInfo.live_id, uj2.PN.userId, uj2.Ps.userId);
                        a.this.dXa.aK(false);
                        a.this.dXa.vu();
                    }
                } else if (i == 18) {
                    if (a.this.dXc) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.dXc = !a.this.dXc;
                } else if (i == 19 && a.this.dXa != null) {
                    a.this.dXa.vu();
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
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void uM() {
        super.uM();
        this.dXc = false;
        if (this.dXB != null) {
            this.dXB.b(this.dXm);
        }
        if (this.dXa == null) {
            this.dXa = new com.baidu.live.tieba.e.b(aPw().pageContext.getPageActivity());
            this.dXa.start();
        }
        this.dXa.aK(true);
        aPw().pageContext.getPageActivity().setRequestedOrientation(-1);
        aPw().efD.setIsForceHandledTouch(false);
        aPw().efD.setSwipeClearEnable(true);
        aPw().efD.setOnLiveViewScrollListener(this.dXh);
        aPw().efD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dXd.removeCallbacksAndMessages(null);
                a.this.hn(false);
                if (!a.this.dXb) {
                    a.this.dXd.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.dXb) {
                                a.this.hn(false);
                            }
                        }
                    }, 5000L);
                }
            }
        });
        if (this.dXY != null) {
            this.dXY.setVisibility(0);
        }
        aOl();
        aOm();
        aOn();
        aOx();
        aOy();
        aOk();
        aOA();
        aOz();
        ho(false);
        aPf();
        aOp();
        aOv();
        aOw();
        aPh();
        aOi();
        aOC();
        aOE();
        aOo();
        aOu();
        aOq();
        aOr();
        aOs();
        aOF();
        aPm();
        if (this.dXT != null && this.dXT.aWi() == null) {
            this.dXT.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.16
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.dXa.aK(true);
                }
            });
        }
        MessageManager.getInstance().registerListener(this.dXi);
        MessageManager.getInstance().registerListener(this.dXj);
        MessageManager.getInstance().registerListener(this.dXk);
        MessageManager.getInstance().registerListener(this.dXl);
        aOG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(boolean z) {
        View pN;
        if (aPw() != null && aPw().pageContext != null && aPw().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(aPw().pageContext.getPageActivity()) == 2 || z) {
                if (this.dXK != null && (pN = this.dXK.pN()) != null) {
                    if (this.dXb) {
                        pN.setVisibility(0);
                    } else {
                        pN.setVisibility(8);
                    }
                }
                if (this.dXb) {
                    if (this.dXY != null) {
                        this.dXY.setVisibility(0);
                    }
                    if (this.dXZ != null) {
                        this.dXZ.setVisibility(0);
                    }
                    if (this.dWH != null) {
                        this.dWH.setVisibility(0);
                    }
                    if (this.dWG != null) {
                        this.dWG.setVisibility(0);
                    }
                    if (this.dWF != null) {
                        this.dWF.setVisibility(0);
                    }
                    if (this.dXJ != null) {
                        this.dXJ.aj(false);
                    }
                } else {
                    if (this.dXY != null) {
                        this.dXY.setVisibility(8);
                    }
                    if (this.dXZ != null) {
                        this.dXZ.setVisibility(8);
                    }
                    if (this.dWH != null) {
                        this.dWH.setVisibility(8);
                    }
                    if (this.dWG != null) {
                        this.dWG.setVisibility(8);
                    }
                    if (this.dWF != null) {
                        this.dWF.setVisibility(8);
                    }
                    if (this.dXJ != null) {
                        this.dXJ.aj(true);
                    }
                }
                this.dXb = this.dXb ? false : true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, boolean z2) {
        ImageView imageView;
        View pB;
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view;
        }
        if (z) {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_off);
            }
            if (this.dWY != null) {
                this.dWY.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_on);
            }
            if (this.dWY != null) {
                this.dWY.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.dXJ != null && (pB = this.dXJ.pB()) != null) {
            if (z) {
                pB.setVisibility(8);
            } else {
                pB.setVisibility(0);
            }
        }
    }

    private void aOi() {
        if (this.dWV == null) {
            this.dWV = new com.baidu.tieba.ala.liveroom.d.b(aPw().pageContext);
        }
        this.dWV.setOtherParams(this.otherParams);
        this.dWV.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.17
            @Override // com.baidu.live.im.j.a
            public void sL() {
                a.this.aPk();
            }
        });
    }

    private void aOj() {
        if (this.dXC != null) {
            this.dXC.ae(aPw().efE);
        }
    }

    private void aOk() {
        if (this.dWW == null) {
            this.dWW = new com.baidu.tieba.ala.liveroom.share.b(aPw().pageContext);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void aS(int i) {
        super.aS(i);
        if (this.dWZ != null && UtilHelper.getRealScreenOrientation(aPw().pageContext.getPageActivity()) != 2) {
            this.dWZ.setVisibility(0);
        }
        aOj();
        if (this.dWT != null) {
            this.dWT.aS(i);
        }
        if (this.dWT == null || !this.dWT.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
    }

    private void aOl() {
        if (this.dWF == null) {
            this.dWF = new LinearLayout(aPw().pageContext.getPageActivity());
            this.dWF.setBackgroundColor(0);
            this.dWF.setOrientation(1);
        }
        if (this.dWF.getParent() == null) {
            int dimensionPixelSize = aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(((int) (BdUtilHelper.getEquipmentWidth(aPw().pageContext.getPageActivity()) * 0.25f)) - (dimensionPixelSize * 2), -1);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            layoutParams.topMargin = n.t(aPw().pageContext.getPageActivity());
            layoutParams.rightMargin = dimensionPixelSize;
            layoutParams.bottomMargin = aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds112);
            aPw().efD.addView(this.dWF, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void ho(boolean z) {
        super.ho(z);
        this.dXJ.aZ(aPw().efC.uj().mLiveInfo.screen_direction);
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
            layoutParams.topMargin = aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds228);
            layoutParams.leftMargin = aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            aPw().efD.addView(this.dWH, layoutParams);
        }
    }

    private void aOo() {
        if (this.dWQ == null) {
            this.dWQ = new com.baidu.tieba.ala.liveroom.activeview.b(aPw().pageContext);
        }
        this.dWQ.setOtherParams(tm());
        this.dWQ.b(aPw().efC.uj(), true);
        this.dWQ.setHost(false);
        this.dWQ.a(1, this.dWF, nr(1));
        this.dWQ.a(2, this.dWF, nr(2));
        this.dWQ.setVisible(this.dYb ? 8 : 0);
    }

    private void aOp() {
        if (this.dXA != null && aPw() != null && aPw().efC != null) {
            this.dXA.b(this.dXY, aPw().efC.uj());
        }
    }

    private ViewGroup.LayoutParams nr(int i) {
        switch (i) {
            case 1:
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = aPw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds40);
                return layoutParams;
            case 2:
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams2.topMargin = aPw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                return layoutParams2;
            default:
                return new RelativeLayout.LayoutParams(-1, -2);
        }
    }

    private void aOq() {
        if (this.dWF != null) {
            if (this.dWP == null) {
                this.dWP = new com.baidu.tieba.ala.liveroom.i.a(aPw().pageContext, this);
            }
            this.dWP.setOtherParams(tm());
            this.dWP.a(this.dWF, aOt());
            this.dWP.k(aPw().efC.uj());
        }
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
            this.dWN.a(new a.InterfaceC0369a() { // from class: com.baidu.tieba.ala.liveroom.c.a.3
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0369a
                public void aS(int i, int i2) {
                    com.baidu.live.data.i uj = a.this.aPw().efC.uj();
                    if (uj != null && uj.mLiveInfo != null) {
                        if (a.this.dXU == null) {
                            a.this.dXU = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.aPw().pageContext.getPageActivity());
                        }
                        a.this.dXU.d(a.this.dXZ, i, i2);
                        a.this.dXU.a(String.valueOf(uj.mLiveInfo.live_id), new a.InterfaceC0372a() { // from class: com.baidu.tieba.ala.liveroom.c.a.3.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0372a
                            public void a(float f, String str) {
                                if (a.this.dWN != null) {
                                    a.this.dWN.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0369a
                public void aT(int i, int i2) {
                    if (a.this.dXU != null) {
                        a.this.dXU.bd(i, i2);
                    }
                }
            });
        }
    }

    private ViewGroup.LayoutParams aOt() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = aPw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOu() {
        if (this.dWN == null) {
            aOz();
        }
        this.dWN.a(com.baidu.live.l.c.uG().akX, aPw().efC.uj());
    }

    private void aOv() {
        CustomResponsedMessage runTask;
        if (this.dXH == null && (runTask = MessageManager.getInstance().runTask(2913039, com.baidu.live.im.i.class, aPw().pageContext)) != null && runTask.getData() != null) {
            this.dXH = (com.baidu.live.im.i) runTask.getData();
            this.dXH.setFromMaster(false);
            this.dXH.sD().getView().setId(a.g.ala_liveroom_msg_list);
            this.dXH.a(new i.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.4
                @Override // com.baidu.live.im.i.a
                public boolean sF() {
                    return a.this.rA();
                }

                @Override // com.baidu.live.im.i.a
                public void sG() {
                    a.this.dYf = true;
                }

                @Override // com.baidu.live.im.i.a
                public void cH(String str) {
                    if (!a.this.dYb) {
                        a.this.hr(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.aPw().pageContext.getPageActivity(), a.this.aPw().efE);
                    }
                    a.this.ty(str);
                }

                @Override // com.baidu.live.im.i.a
                public void sH() {
                    if (a.this.dYb) {
                        a.this.hr(true);
                        a.this.aPw().efE.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.aPw().pageContext.getPageActivity(), a.this.aPw().efE);
                            }
                        }, 10L);
                    } else if (a.this.dXH != null) {
                        a.this.dXH.sE().setQuickInputPanelVisible(false);
                        a.this.dXH.sE().tG();
                    }
                }

                @Override // com.baidu.live.im.i.a
                public void sI() {
                    if (a.this.dYb) {
                        a.this.aON();
                        if (a.this.dXI != null) {
                            a.this.dXI.sK();
                        }
                        if (a.this.dWV != null) {
                            a.this.dWV.sK();
                        }
                    } else if (a.this.dXH != null) {
                        a.this.dXH.sE().setQuickInputPanelVisible(false);
                        a.this.dXH.sE().tG();
                    }
                }
            });
            this.dWX = new FrameLayout(aPw().pageContext.getPageActivity());
            this.dWX.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.dXH != null && this.dWX != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(aPw().pageContext.getPageActivity()) * 0.75f);
            int dimensionPixelSize = aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds120) + ((int) (BdUtilHelper.getEquipmentHeight(aPw().pageContext.getPageActivity()) * 0.33f));
            if (this.dXZ.indexOfChild(this.dWX) < 0) {
                if (this.dWX.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.dWX.getParent()).removeView(this.dWX);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                this.dXZ.addView(this.dWX, layoutParams);
            }
            if (this.dWX.indexOfChild(this.dXH.sD().getView()) < 0) {
                if (this.dXH.sD().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.dXH.sD().getView()).removeView(this.dXH.sD().getView());
                }
                if (UtilHelper.getRealScreenOrientation(aPw().pageContext.getPageActivity()) != 2) {
                    this.dWX.addView(this.dXH.sD().getView(), new FrameLayout.LayoutParams(equipmentWidth, dimensionPixelSize));
                }
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

    private void aOw() {
        if (this.dWY == null) {
            this.dWY = new FrameLayout(aPw().pageContext.getPageActivity());
            this.dWY.setId(a.g.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void aOx() {
        if (this.dWJ == null) {
            this.dWJ = new com.baidu.tieba.ala.liveroom.l.a(aPw().pageContext, false, this);
        }
        this.dWJ.d(this.dXY, aPw().efC.uj());
        this.dWJ.a(this.dXm);
    }

    private void aOy() {
        if (this.dWI == null) {
            this.dWI = new com.baidu.tieba.ala.liveroom.audiencelist.c(aPw().pageContext, this, false);
        }
        this.dWI.a(String.valueOf(aPw().efC.uj().mLiveInfo.group_id), String.valueOf(aPw().efC.uj().mLiveInfo.live_id), String.valueOf(aPw().efC.uj().Ps.userId), aPw().efC.uj());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.dWI.c(this.dXY, a.g.ala_liveroom_hostheader, a.g.ala_liveroom_audience_count_layout);
            this.dWI.e(aPw().efC.aKy());
        }
    }

    private void aOz() {
        if (this.dWN == null) {
            this.dWN = new com.baidu.tieba.ala.liveroom.operation.a(aPw().pageContext);
        }
        this.dWN.a(aPw(), this.dXZ, aPw().efC.uj().mLiveInfo.live_type, true, this.dXm);
        this.dWN.setOtherParams(tm());
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
        String str;
        if (aPw() != null && aPw().efC != null && aPw().efC.uj() != null && aPw().efC.uj().PN != null && (str = aPw().efC.uj().PN.userName) != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), aPw().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt))) {
            com.baidu.live.c.np().putInt("guide_rename_show_count", com.baidu.live.c.np().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.tY().aE(true);
            if (this.dWL == null) {
                this.dWL = new com.baidu.tieba.ala.liveroom.q.b(aPw().pageContext);
            }
            this.dWL.setOtherParams(tm());
            this.dWL.f(this.dXZ, aPw().efC.uj());
            hv(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.6
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dWL.aVU();
                    a.this.hv(false);
                }
            }, 5000L);
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_SHOW);
            alaStaticItem.addParams("other_params", tm());
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    private void aOE() {
        if (this.dXD == null) {
            this.dXD = new com.baidu.tieba.ala.liveroom.s.a(aPw().pageContext, this);
        }
        this.dXD.d(aPw().efD, false);
        this.dXD.im(aPv());
    }

    private void aOF() {
        if (aPw() != null && aPw().efB != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(aPw().pageContext.getPageActivity());
            Activity pageActivity = aPw().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + pageActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds176)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.dWZ = new ImageView(aPw().pageContext.getPageActivity());
            this.dWZ.setVisibility(8);
            this.dWZ.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.dWZ.setImageResource(a.f.icon_live_enlarge);
            this.dWZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.dXa != null) {
                        a.this.dXa.vt();
                        a.this.dWZ.setVisibility(4);
                    }
                }
            });
            aPw().efD.addView(this.dWZ, layoutParams);
            if (UtilHelper.getRealScreenOrientation(aPw().pageContext.getPageActivity()) != 2) {
                if (aPw().efJ) {
                    this.dWZ.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.dWZ != null && UtilHelper.getRealScreenOrientation(a.this.aPw().pageContext.getPageActivity()) != 2) {
                                a.this.dWZ.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
        }
    }

    private void aOG() {
        if (this.dYf || this.dYg) {
            if ((TbadkCoreApplication.isLogin() && this.dXH.sE().hasText()) || this.dYg) {
                this.dYf = false;
                this.dYg = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.9
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.aOZ();
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
            e.printStackTrace();
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
        if (this.dWV != null) {
            this.dWV.b(iVar);
        }
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
        if (this.dWF != null) {
            this.dWF.removeAllViews();
            this.dWF = null;
        }
        if (this.dWG != null) {
            this.dWG.removeAllViews();
            this.dWG = null;
        }
        if (this.dWH != null) {
            this.dWH.removeAllViews();
            this.dWH = null;
        }
        if (this.dWS != null) {
            this.dWS.nA();
        }
        if (this.dWV != null) {
            this.dWV.a((j.a) null);
            this.dWV.sj();
        }
        if (this.dWZ != null && (this.dWZ.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.dWZ.getParent()).removeView(this.dWZ);
        }
        if (this.dWW != null) {
            this.dWW.dismiss();
        }
        if (this.dXa != null) {
            this.dXa.aK(false);
            this.dXa.vu();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void aOH() {
        View sJ;
        super.aOH();
        if (this.dWV != null && (sJ = this.dWV.sJ()) != null && sJ.getParent() != null) {
            ((ViewGroup) sJ.getParent()).removeView(sJ);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.dWV != null) {
            this.dWV.setOtherParams(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onDestory() {
        super.onDestory();
        this.dXd.removeCallbacksAndMessages(null);
        aOI();
        this.dXb = false;
        this.dXc = false;
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
        if (this.dWW != null) {
            this.dWW.onDestroy();
        }
        if (this.dWK != null) {
            this.dWK.onDestroy();
        }
        if (this.dXa != null) {
            this.dXa.stop();
        }
        if (this.dXD != null) {
            this.dXD.onDestroy();
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
        if (this.dWV != null) {
            this.dWV.a((j.a) null);
            this.dWV.release();
            this.dWV = null;
        }
        MessageManager.getInstance().removeMessageRule(this.dXf);
        MessageManager.getInstance().removeMessageRule(this.dXg);
        MessageManager.getInstance().unRegisterListener(this.dXi);
        MessageManager.getInstance().unRegisterListener(this.dXj);
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
        if (this.dWY != null && this.dWY.getParent() != null) {
            ((ViewGroup) this.dWY.getParent()).removeView(this.dWY);
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
        boolean z2 = this.dYb;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(aPw().pageContext.getPageActivity()) || z2) {
            hq(z);
        }
    }

    private void hq(boolean z) {
        int dimensionPixelSize;
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
                int equipmentHeight = (int) ((z ? 0.2f : 0.33f) * BdUtilHelper.getEquipmentHeight(aPw().pageContext.getPageActivity()));
                if (z) {
                    dimensionPixelSize = equipmentHeight + aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64);
                } else {
                    dimensionPixelSize = equipmentHeight + aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
                }
                if (this.dXZ.indexOfChild(this.dWX) != -1 && this.dWX.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dWX.getLayoutParams();
                    layoutParams2.height = dimensionPixelSize;
                    this.dWX.setLayoutParams(layoutParams2);
                }
                if (this.dWX.indexOfChild(this.dXH.sD().getView()) != -1 && this.dXH.sD().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.dXH.sD().getView().getLayoutParams();
                    layoutParams3.height = dimensionPixelSize;
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
            layoutParams.bottomMargin = aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
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
        if (this.dXY != null && (!this.dXb || UtilHelper.getRealScreenOrientation(aPw().pageContext.getPageActivity()) != 2)) {
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
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        RelativeLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = aPw().pageContext.getPageActivity();
        if (i3 == 1) {
            if (this.dXY != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.dXY.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.dWW != null) {
                this.dWW.dismiss();
            }
            if (this.dWV != null) {
                this.dWV.a((j.a) null);
                this.dWV.sj();
            }
            if (this.dXu != null) {
                this.dXu.A(true, true);
            }
            if (this.dWZ != null) {
                this.dWZ.setVisibility(0);
                this.dWZ.bringToFront();
            }
            if (this.dXz != null) {
                this.dXz.setVisibility(0);
            }
            if (this.dXH != null && this.dXH.sD().getView().getParent() != null && (this.dXH.sD().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.dXH.sD().getView().getParent()).removeView(this.dXH.sD().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(aPw().pageContext.getPageActivity()) * 0.75f);
            int equipmentHeight = ((int) (BdUtilHelper.getEquipmentHeight(aPw().pageContext.getPageActivity()) * 0.33f)) + aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
            if (this.dWX != null && this.dXH != null) {
                this.dWX.addView(this.dXH.sD().getView(), new FrameLayout.LayoutParams(equipmentWidth, equipmentHeight));
            }
            if (this.dWY != null && (this.dWY.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.dWY.getParent()).removeView(this.dWY);
            }
            if (this.dXI != null) {
                this.dXI.a(aPw().efC.uj(), false);
                this.dXI.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.10
                    @Override // com.baidu.live.im.j.a
                    public void sL() {
                        a.this.aPk();
                    }
                });
                View sJ = this.dXI.sJ();
                if (sJ != null && this.dXZ != null && sJ.getParent() == null) {
                    Resources resources = aPw().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(aPw().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds80));
                    layoutParams5.addRule(2, a.g.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                    this.dXZ.addView(sJ, layoutParams5);
                }
            }
            if (this.dXB != null) {
                this.dXB.setPraiseEnable(true);
                aPw().efD.ert = true;
            }
            if (this.dWI != null && this.dWI.dYS != null && (layoutParams3 = (RelativeLayout.LayoutParams) this.dWI.dYS.getLayoutParams()) != null) {
                this.dWI.dYS.setPadding(0, 0, 0, 0);
                this.dWI.dYS.setLayoutParams(layoutParams3);
            }
            if (this.dXD != null) {
                this.dXD.aXc();
            }
            if (this.dXb) {
                hn(true);
            }
            if (this.dXc) {
                if (this.dWN != null && this.dWN.getLandscapeBarrageImageView() != null) {
                    b(this.dWN.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.dWO != null) {
                this.dWO.hF(true);
            }
            this.dXd.removeCallbacksAndMessages(null);
            if (this.dWP != null) {
                this.dWP.setCanVisible(true);
                this.dWP.k(aPw().efC.uj());
            }
        } else if (i3 == 2) {
            if (this.dXD != null) {
                this.dXD.aXd();
            }
            if (this.dXY != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.dXY.getLayoutParams()) != null) {
                layoutParams2.topMargin = aPw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
            }
            if (this.dXI != null) {
                this.dXI.a(null);
                this.dXI.sj();
            }
            aPw().efD.aWI();
            if (this.dXu != null) {
                this.dXu.A(false, true);
            }
            if (this.dWZ != null) {
                this.dWZ.setVisibility(4);
            }
            if (this.dXH != null && this.dXH.sD().getView().getParent() != null && (this.dXH.sD().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.dXH.sD().getView().getParent()).removeView(this.dXH.sD().getView());
            }
            int max = Math.max(i, i2);
            if (this.dWY != null) {
                if (this.dWY.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.dWY.getParent()).removeView(this.dWY);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
                aPw().efD.addView(this.dWY, layoutParams6);
            }
            if (this.dWY != null && this.dWV != null) {
                this.dWV.a(aPw().efC.uj(), false);
                this.dWV.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.12
                    @Override // com.baidu.live.im.j.a
                    public void sL() {
                        a.this.aPk();
                    }
                });
                View sJ2 = this.dWV.sJ();
                if (sJ2 != null && this.dWY.indexOfChild(sJ2) < 0) {
                    this.dWY.addView(sJ2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(aPw().pageContext.getPageActivity()), -1));
                }
            }
            if (this.dXB != null) {
                this.dXB.ah(aPw().efD);
                this.dXB.setPraiseEnable(false);
                aPw().efD.ert = false;
            }
            if (this.dWI != null && this.dWI.dYS != null && (layoutParams = (RelativeLayout.LayoutParams) this.dWI.dYS.getLayoutParams()) != null) {
                int width = this.dWI.dYS.getWidth();
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                this.dWI.dYS.setPadding(width - ((int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f)), 0, 0, 0);
                this.dWI.dYS.setLayoutParams(layoutParams);
            }
            if (this.dWO != null) {
                this.dWO.hF(false);
            }
            com.baidu.tieba.ala.liveroom.yuangift.a.aWZ().aAm();
            com.baidu.tieba.ala.liveroom.task.b.aWc().aAm();
            if (this.dWN != null && this.dWN.getLandscapeBarrageImageView() != null) {
                b(this.dWN.getLandscapeBarrageImageView(), this.dXc, false);
            }
            this.dXd.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.13
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.dXb) {
                        a.this.hn(false);
                    }
                }
            }, 5000L);
            if (this.dWP != null) {
                this.dWP.setCanVisible(false);
                this.dWP.aRW();
            }
        }
        if (this.dXK != null) {
            if (i3 == 2) {
                View pN = this.dXK.pN();
                if (pN != null) {
                    if (pN.getParent() != null && (pN.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) pN.getParent()).removeView(pN);
                    }
                    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams7.addRule(5, a.g.ala_liveroom_hostheader);
                    layoutParams7.addRule(3, a.g.ala_liveroom_hostheader);
                    layoutParams7.topMargin = aPw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                    if (this.dXY != null) {
                        this.dXY.addView(pN, layoutParams7);
                    }
                }
            } else {
                View pN2 = this.dXK.pN();
                if (pN2 != null) {
                    if (pN2.getParent() != null && (pN2.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) pN2.getParent()).removeView(pN2);
                    }
                    RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams8.topMargin = aPw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
                    layoutParams8.addRule(3, a.g.ala_live_header_view);
                    aPw().efD.addView(pN2, layoutParams8);
                }
            }
        }
        if (this.dWN != null) {
            this.dWN.E(i, i2, i3);
        }
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.dWI != null) {
                this.dWI.bw(i3);
            }
            if (this.dWK != null) {
                this.dWK.bw(i3);
            }
            nt(i3);
            if (this.dWQ != null) {
                this.dWQ.bw(i3);
            }
            if (this.dXN != null) {
                this.dXN.bw(i3);
            }
            if (this.dXT != null) {
                this.dXT.bw(i3);
            }
            if (this.dXe != null && this.dXe.isShowing()) {
                this.dXe.resize();
            }
        }
        if (this.dXJ != null) {
            this.dXJ.pC();
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
            if (i != 7 || UtilHelper.getRealScreenOrientation(aPw().pageContext.getPageActivity()) != 2) {
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
            if (!this.dXb || UtilHelper.getRealScreenOrientation(aPw().pageContext.getPageActivity()) != 2) {
                this.dXY.setVisibility(0);
            }
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
        if (aPw() != null) {
            BdUtilHelper.hideSoftKeyPad(aPw().pageContext.getPageActivity(), aPw().pageContext.getPageActivity().getWindow().getDecorView());
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
    }

    private void nt(int i) {
        if (this.dWF != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dWF.getLayoutParams();
            layoutParams.width = ScreenHelper.getRealScreenWidth(aPw().pageContext.getPageActivity());
            if (i == 1) {
                layoutParams.width = (int) (layoutParams.width * 0.25f);
                layoutParams.topMargin = n.t(aPw().pageContext.getPageActivity());
                layoutParams.rightMargin = aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
            } else if (i == 2) {
                layoutParams.topMargin = 0 + aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds72) + aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds22) + aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                layoutParams.rightMargin = aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
            }
            layoutParams.width -= layoutParams.rightMargin * 2;
            this.dWF.setLayoutParams(layoutParams);
        }
    }
}
