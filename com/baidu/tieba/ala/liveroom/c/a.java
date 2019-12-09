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
    private LinearLayout dVO;
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
    private com.baidu.live.c.a dWa;
    private j dWb;
    private i dWc;
    private com.baidu.tieba.ala.liveroom.attentionpop.b dWd;
    private com.baidu.tieba.ala.liveroom.d.b dWe;
    private com.baidu.tieba.ala.liveroom.share.b dWf;
    private FrameLayout dWg;
    private FrameLayout dWh;
    private ImageView dWi;
    private com.baidu.live.tieba.e.b dWj;
    private com.baidu.live.gift.container.e dWn;
    private long lastClickTime = 0;
    private boolean dWk = false;
    private boolean dWl = false;
    private Handler dWm = new Handler();
    private HttpRule dWo = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.dWb != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.dWb.nP()) {
                httpMessage.addParam("ala_challenge_id", a.this.dWb.nT());
            }
            return httpMessage;
        }
    };
    private HttpRule dWp = new HttpRule(1021151) { // from class: com.baidu.tieba.ala.liveroom.c.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.dWb != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.dWb.nP()) {
                httpMessage.addParam("challenge_id", a.this.dWb.nT());
            }
            return httpMessage;
        }
    };
    private AlaLiveView.c dWq = new AlaLiveView.c() { // from class: com.baidu.tieba.ala.liveroom.c.a.14
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void aOO() {
            if (a.this.dWM != null) {
                a.this.dWM.in(false);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void hs(boolean z) {
            if (z) {
                if (a.this.dVW != null) {
                    a.this.dVW.nW(8);
                }
                if (a.this.dWM != null) {
                    a.this.dWM.in(true);
                    return;
                }
                return;
            }
            if (a.this.dVW != null) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                    a.this.dVW.nW(0);
                } else {
                    a.this.dVW.nW(8);
                }
            }
            if (a.this.dWM != null) {
                a.this.dWM.in(false);
            }
        }
    };
    private HttpMessageListener dWr = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.a.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.us() != null) {
                        com.baidu.live.l.c.uH().akF = getQuickGiftHttpResponseMessage.us();
                        a.this.aOs();
                    }
                }
            }
        }
    };
    private CustomMessageListener dWs = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.a.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.aOB();
        }
    };
    CustomMessageListener dWt = new CustomMessageListener(CmdConfigCustom.CMD_HOST_GET_WALLET_UA) { // from class: com.baidu.tieba.ala.liveroom.c.a.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.dXn != null && a.this.dXn.dKm != null && !a.this.dXn.dKS && !a.this.dXn.dNt) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.aPu().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = a.this.aPu().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                a.this.dXb.c(a.this.dWg, layoutParams);
                com.baidu.tieba.ala.guardclub.a.aLe().aLf();
            }
        }
    };
    private CustomMessageListener dWu = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof Integer)) {
                if (a.this.dXc != null) {
                    a.this.dXc.dismiss();
                }
                k.sN().ax(true);
                k.sN().setSelect(((Integer) customResponsedMessage.getData()).intValue());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.aOX();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b dWv = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.a.5
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
                if (i == 2 && a.this.rB()) {
                    a.this.F(-1, -1, -1);
                } else if (i == 13) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                    alaStaticItem.addParams("gifts_value", com.baidu.live.l.c.uH().akF.pF().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.l.c.uH().akF.pF().pc());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.l.c.uH().akF.pF().pd());
                    if (a.this.aPu().eeL.uk() != null && a.this.aPu().eeL.uk().mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", a.this.aPu().eeL.uk().mLiveInfo.feed_id);
                        alaStaticItem.addParams("room_id", a.this.aPu().eeL.uk().mLiveInfo.room_id);
                    }
                    alaStaticItem.addParams("other_params", a.this.tn());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    if (a.this.rB()) {
                        if (com.baidu.live.c.np().getBoolean("quick_gift_guide_show", true)) {
                            com.baidu.live.gift.container.e eVar = new com.baidu.live.gift.container.e(a.this.aPu().pageContext.getPageActivity(), a.this.aPu().pageContext, a.this.aPu().eeL.uk(), com.baidu.live.l.c.uH().akF.pF(), a.this.tn());
                            eVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.5.1
                                @Override // android.content.DialogInterface.OnDismissListener
                                public void onDismiss(DialogInterface dialogInterface) {
                                    a.this.hu(false);
                                    a.this.dWn = null;
                                }
                            });
                            a.this.dWn = eVar;
                            eVar.show();
                            a.this.hu(true);
                            return;
                        }
                        com.baidu.live.gift.b.c.a(a.this.aPu().pageContext, a.this.aPu().eeL.uk(), com.baidu.live.l.c.uH().akF.pF(), a.this.tn());
                    }
                } else if (i == 1) {
                    if (a.this.dWQ != null) {
                        a.this.aOX();
                    }
                } else if (i == 3 && a.this.rB()) {
                    if (a.this.mOrientation == 2 && TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.dWf != null) {
                            a.this.dWf.n(a.this.aPu().eeL.uk());
                        }
                    } else {
                        a.this.dWF.c(a.this.aPu().eeL.uk(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.aPu() != null && a.this.aPu().eeL != null && a.this.aPu().eeL.uk() != null && a.this.aPu().eeL.uk().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.aPu().eeL.uk().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.aPu().eeL.uk().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.aPu().eeL.uk().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.tn());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.aPu() != null && a.this.aPu().eeL != null && a.this.aPu().eeL.uk() != null && a.this.aPu().eeL.uk().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.aPu().eeL.uk().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.aPu().eeL.uk().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.aPu().eeL.uk().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.tn());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.dWD != null) {
                        a.this.dWD.aPI();
                    }
                } else if (i == 12) {
                    if (a.this.dWM != null) {
                        String valueOf = String.valueOf(a.this.aPu().eeL.uk().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.aPu().eeL.uk().mLiveInfo.room_id);
                        String str2 = null;
                        h hVar = a.this.aPu().eeL.uk().mLiveSdkInfo;
                        if (hVar != null && hVar.mCastIds != null) {
                            str2 = String.valueOf(a.this.aPu().eeL.uk().mLiveSdkInfo.mCastIds.Pd);
                        }
                        a.this.dWM.R(valueOf, valueOf2, str2);
                        if (com.baidu.live.liveroom.a.tZ().ua()) {
                            a.this.aOB();
                        }
                    }
                } else if (i == 14) {
                    com.baidu.live.data.i uk = a.this.aPu().eeL.uk();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.aPu().pageContext.getPageActivity(), uk.OR.userName, Long.toString(uk.OR.userId), Long.toString(uk.OR.charmCount), String.valueOf(uk.mLiveInfo.group_id), String.valueOf(uk.mLiveInfo.live_id), false, String.valueOf(uk.OR.userId), Long.toString(uk.Pj.userId), uk.Pj.userName, uk.Pj.portrait, a.this.dVX.getCount(), a.this.tn())));
                    LogManager.getCommonLogger().doClickGusetNumLog(uk.mLiveInfo.feed_id, a.this.dVX.getCount() + "", a.this.tn());
                } else if (i == 11) {
                    a.this.aPa();
                    a.this.aPb();
                } else if (i == 15) {
                    if (a.this.dWZ != null && a.this.aPu() != null && a.this.aPu().eeL != null && a.this.aPu().eeL.uk() != null && a.this.aPu().eeL.uk().mLiveInfo != null) {
                        long j = a.this.aPu().eeL.uk().mLiveInfo.live_id;
                        String valueOf3 = String.valueOf(a.this.aPu().eeL.uk().mLiveInfo.feed_id);
                        long j2 = a.this.aPu().eeL.uk().mLiveInfo.room_id;
                        String str3 = a.this.aPu().eeL.uk().mLiveInfo.cover;
                        String str4 = "";
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        if (a.this.aPu().eeL.uk().mLiveInfo.session_info != null) {
                            str4 = a.this.aPu().eeL.uk().mLiveInfo.session_info.flvUrl;
                        }
                        if (!TextUtils.isEmpty(a.this.tn())) {
                            try {
                                JSONObject jSONObject = new JSONObject(a.this.tn());
                                str5 = jSONObject.optString("tab");
                                str6 = jSONObject.optString("tag");
                                str7 = jSONObject.optString("source");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        a.this.dWZ.tB(m.a(valueOf3, j + "", j2, false, 1, str3, str4, str5, str6, str7));
                        m.ard = j;
                        if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                            ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                            LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf3, a.this.tn());
                        }
                    }
                } else if (i == 16) {
                    if (a.this.aPu() != null && (afVar2 = com.baidu.live.l.a.uB().aku) != null && (alVar2 = afVar2.TK) != null) {
                        String str8 = alVar2.Ur.Uw;
                        if (!TextUtils.isEmpty(str8)) {
                            long j3 = 0;
                            if (a.this.aPu().eeL != null && a.this.aPu().eeL.uk() != null && a.this.aPu().eeL.uk().mLiveInfo != null) {
                                j3 = a.this.aPu().eeL.uk().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j3 + "", a.this.aPu().eeL.uk().mLiveInfo.room_id + "", a.this.aPu().eeL.uk().mLiveInfo.feed_id, a.this.tn());
                            }
                            if (str8.contains("?")) {
                                str = str8 + "&liveId=" + j3;
                            } else {
                                str = str8 + "?liveId=" + j3;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.aPu().pageContext.getPageActivity(), str);
                        }
                    }
                } else if (i == 17) {
                    if (a.this.rB() && a.this.aPu() != null && (afVar = com.baidu.live.l.a.uB().aku) != null && (alVar = afVar.TK) != null && (aqVar = alVar.Us) != null && !TextUtils.isEmpty(aqVar.webUrl) && a.this.dXc != null && a.this.aPu().eeL != null && a.this.aPu().eeL.uk() != null) {
                        com.baidu.live.data.i uk2 = a.this.aPu().eeL.uk();
                        a.this.dXc.a(aqVar.webUrl, uk2.mLiveInfo.live_id, uk2.Pj.userId, uk2.OR.userId);
                        a.this.dWj.aK(false);
                        a.this.dWj.vv();
                    }
                } else if (i == 18) {
                    if (a.this.dWl) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.dWl = !a.this.dWl;
                } else if (i == 19 && a.this.dWj != null) {
                    a.this.dWj.vv();
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
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void uN() {
        super.uN();
        this.dWl = false;
        if (this.dWK != null) {
            this.dWK.b(this.dWv);
        }
        if (this.dWj == null) {
            this.dWj = new com.baidu.live.tieba.e.b(aPu().pageContext.getPageActivity());
            this.dWj.start();
        }
        this.dWj.aK(true);
        aPu().pageContext.getPageActivity().setRequestedOrientation(-1);
        aPu().eeM.setIsForceHandledTouch(false);
        aPu().eeM.setSwipeClearEnable(true);
        aPu().eeM.setOnLiveViewScrollListener(this.dWq);
        aPu().eeM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dWm.removeCallbacksAndMessages(null);
                a.this.hn(false);
                if (!a.this.dWk) {
                    a.this.dWm.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.dWk) {
                                a.this.hn(false);
                            }
                        }
                    }, 5000L);
                }
            }
        });
        if (this.dXh != null) {
            this.dXh.setVisibility(0);
        }
        aOj();
        aOk();
        aOl();
        aOv();
        aOw();
        aOi();
        aOy();
        aOx();
        ho(false);
        aPd();
        aOn();
        aOt();
        aOu();
        aPf();
        aOg();
        aOA();
        aOC();
        aOm();
        aOs();
        aOo();
        aOp();
        aOq();
        aOD();
        aPk();
        if (this.dXc != null && this.dXc.aWg() == null) {
            this.dXc.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.16
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.dWj.aK(true);
                }
            });
        }
        MessageManager.getInstance().registerListener(this.dWr);
        MessageManager.getInstance().registerListener(this.dWs);
        MessageManager.getInstance().registerListener(this.dWt);
        MessageManager.getInstance().registerListener(this.dWu);
        aOE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(boolean z) {
        View pN;
        if (aPu() != null && aPu().pageContext != null && aPu().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(aPu().pageContext.getPageActivity()) == 2 || z) {
                if (this.dWT != null && (pN = this.dWT.pN()) != null) {
                    if (this.dWk) {
                        pN.setVisibility(0);
                    } else {
                        pN.setVisibility(8);
                    }
                }
                if (this.dWk) {
                    if (this.dXh != null) {
                        this.dXh.setVisibility(0);
                    }
                    if (this.dXi != null) {
                        this.dXi.setVisibility(0);
                    }
                    if (this.dVQ != null) {
                        this.dVQ.setVisibility(0);
                    }
                    if (this.dVP != null) {
                        this.dVP.setVisibility(0);
                    }
                    if (this.dVO != null) {
                        this.dVO.setVisibility(0);
                    }
                    if (this.dWS != null) {
                        this.dWS.aj(false);
                    }
                } else {
                    if (this.dXh != null) {
                        this.dXh.setVisibility(8);
                    }
                    if (this.dXi != null) {
                        this.dXi.setVisibility(8);
                    }
                    if (this.dVQ != null) {
                        this.dVQ.setVisibility(8);
                    }
                    if (this.dVP != null) {
                        this.dVP.setVisibility(8);
                    }
                    if (this.dVO != null) {
                        this.dVO.setVisibility(8);
                    }
                    if (this.dWS != null) {
                        this.dWS.aj(true);
                    }
                }
                this.dWk = this.dWk ? false : true;
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
            if (this.dWh != null) {
                this.dWh.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_on);
            }
            if (this.dWh != null) {
                this.dWh.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.dWS != null && (pB = this.dWS.pB()) != null) {
            if (z) {
                pB.setVisibility(8);
            } else {
                pB.setVisibility(0);
            }
        }
    }

    private void aOg() {
        if (this.dWe == null) {
            this.dWe = new com.baidu.tieba.ala.liveroom.d.b(aPu().pageContext);
        }
        this.dWe.setOtherParams(this.otherParams);
        this.dWe.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.17
            @Override // com.baidu.live.im.j.a
            public void sM() {
                a.this.aPi();
            }
        });
    }

    private void aOh() {
        if (this.dWL != null) {
            this.dWL.ae(aPu().eeN);
        }
    }

    private void aOi() {
        if (this.dWf == null) {
            this.dWf = new com.baidu.tieba.ala.liveroom.share.b(aPu().pageContext);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void aS(int i) {
        super.aS(i);
        if (this.dWi != null && UtilHelper.getRealScreenOrientation(aPu().pageContext.getPageActivity()) != 2) {
            this.dWi.setVisibility(0);
        }
        aOh();
        if (this.dWc != null) {
            this.dWc.aS(i);
        }
        if (this.dWc == null || !this.dWc.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
    }

    private void aOj() {
        if (this.dVO == null) {
            this.dVO = new LinearLayout(aPu().pageContext.getPageActivity());
            this.dVO.setBackgroundColor(0);
            this.dVO.setOrientation(1);
        }
        if (this.dVO.getParent() == null) {
            int dimensionPixelSize = aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(((int) (BdUtilHelper.getEquipmentWidth(aPu().pageContext.getPageActivity()) * 0.25f)) - (dimensionPixelSize * 2), -1);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            layoutParams.topMargin = n.t(aPu().pageContext.getPageActivity());
            layoutParams.rightMargin = dimensionPixelSize;
            layoutParams.bottomMargin = aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds112);
            aPu().eeM.addView(this.dVO, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void ho(boolean z) {
        super.ho(z);
        this.dWS.aZ(aPu().eeL.uk().mLiveInfo.screen_direction);
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
            layoutParams.topMargin = aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds228);
            layoutParams.leftMargin = aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            aPu().eeM.addView(this.dVQ, layoutParams);
        }
    }

    private void aOm() {
        if (this.dVZ == null) {
            this.dVZ = new com.baidu.tieba.ala.liveroom.activeview.b(aPu().pageContext);
        }
        this.dVZ.setOtherParams(tn());
        this.dVZ.b(aPu().eeL.uk(), true);
        this.dVZ.setHost(false);
        this.dVZ.a(1, this.dVO, nq(1));
        this.dVZ.a(2, this.dVO, nq(2));
        this.dVZ.setVisible(this.dXk ? 8 : 0);
    }

    private void aOn() {
        if (this.dWJ != null && aPu() != null && aPu().eeL != null) {
            this.dWJ.b(this.dXh, aPu().eeL.uk());
        }
    }

    private ViewGroup.LayoutParams nq(int i) {
        switch (i) {
            case 1:
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = aPu().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds40);
                return layoutParams;
            case 2:
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams2.topMargin = aPu().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                return layoutParams2;
            default:
                return new RelativeLayout.LayoutParams(-1, -2);
        }
    }

    private void aOo() {
        if (this.dVO != null) {
            if (this.dVY == null) {
                this.dVY = new com.baidu.tieba.ala.liveroom.i.a(aPu().pageContext, this);
            }
            this.dVY.setOtherParams(tn());
            this.dVY.a(this.dVO, aOr());
            this.dVY.k(aPu().eeL.uk());
        }
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
            this.dVW.a(new a.InterfaceC0364a() { // from class: com.baidu.tieba.ala.liveroom.c.a.3
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0364a
                public void aQ(int i, int i2) {
                    com.baidu.live.data.i uk = a.this.aPu().eeL.uk();
                    if (uk != null && uk.mLiveInfo != null) {
                        if (a.this.dXd == null) {
                            a.this.dXd = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.aPu().pageContext.getPageActivity());
                        }
                        a.this.dXd.d(a.this.dXi, i, i2);
                        a.this.dXd.a(String.valueOf(uk.mLiveInfo.live_id), new a.InterfaceC0367a() { // from class: com.baidu.tieba.ala.liveroom.c.a.3.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0367a
                            public void a(float f, String str) {
                                if (a.this.dVW != null) {
                                    a.this.dVW.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0364a
                public void aR(int i, int i2) {
                    if (a.this.dXd != null) {
                        a.this.dXd.bb(i, i2);
                    }
                }
            });
        }
    }

    private ViewGroup.LayoutParams aOr() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = aPu().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOs() {
        if (this.dVW == null) {
            aOx();
        }
        this.dVW.a(com.baidu.live.l.c.uH().akF, aPu().eeL.uk());
    }

    private void aOt() {
        CustomResponsedMessage runTask;
        if (this.dWQ == null && (runTask = MessageManager.getInstance().runTask(2913039, com.baidu.live.im.i.class, aPu().pageContext)) != null && runTask.getData() != null) {
            this.dWQ = (com.baidu.live.im.i) runTask.getData();
            this.dWQ.setFromMaster(false);
            this.dWQ.sE().getView().setId(a.g.ala_liveroom_msg_list);
            this.dWQ.a(new i.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.4
                @Override // com.baidu.live.im.i.a
                public boolean sG() {
                    return a.this.rB();
                }

                @Override // com.baidu.live.im.i.a
                public void sH() {
                    a.this.dXo = true;
                }

                @Override // com.baidu.live.im.i.a
                public void cH(String str) {
                    if (!a.this.dXk) {
                        a.this.hr(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.aPu().pageContext.getPageActivity(), a.this.aPu().eeN);
                    }
                    a.this.ty(str);
                }

                @Override // com.baidu.live.im.i.a
                public void sI() {
                    if (a.this.dXk) {
                        a.this.hr(true);
                        a.this.aPu().eeN.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.aPu().pageContext.getPageActivity(), a.this.aPu().eeN);
                            }
                        }, 10L);
                    } else if (a.this.dWQ != null) {
                        a.this.dWQ.sF().setQuickInputPanelVisible(false);
                        a.this.dWQ.sF().tH();
                    }
                }

                @Override // com.baidu.live.im.i.a
                public void sJ() {
                    if (a.this.dXk) {
                        a.this.aOL();
                        if (a.this.dWR != null) {
                            a.this.dWR.sL();
                        }
                        if (a.this.dWe != null) {
                            a.this.dWe.sL();
                        }
                    } else if (a.this.dWQ != null) {
                        a.this.dWQ.sF().setQuickInputPanelVisible(false);
                        a.this.dWQ.sF().tH();
                    }
                }
            });
            this.dWg = new FrameLayout(aPu().pageContext.getPageActivity());
            this.dWg.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.dWQ != null && this.dWg != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(aPu().pageContext.getPageActivity()) * 0.75f);
            int dimensionPixelSize = aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds120) + ((int) (BdUtilHelper.getEquipmentHeight(aPu().pageContext.getPageActivity()) * 0.33f));
            if (this.dXi.indexOfChild(this.dWg) < 0) {
                if (this.dWg.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.dWg.getParent()).removeView(this.dWg);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                this.dXi.addView(this.dWg, layoutParams);
            }
            if (this.dWg.indexOfChild(this.dWQ.sE().getView()) < 0) {
                if (this.dWQ.sE().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.dWQ.sE().getView()).removeView(this.dWQ.sE().getView());
                }
                if (UtilHelper.getRealScreenOrientation(aPu().pageContext.getPageActivity()) != 2) {
                    this.dWg.addView(this.dWQ.sE().getView(), new FrameLayout.LayoutParams(equipmentWidth, dimensionPixelSize));
                }
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

    private void aOu() {
        if (this.dWh == null) {
            this.dWh = new FrameLayout(aPu().pageContext.getPageActivity());
            this.dWh.setId(a.g.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void aOv() {
        if (this.dVS == null) {
            this.dVS = new com.baidu.tieba.ala.liveroom.l.a(aPu().pageContext, false, this);
        }
        this.dVS.d(this.dXh, aPu().eeL.uk());
        this.dVS.a(this.dWv);
    }

    private void aOw() {
        if (this.dVR == null) {
            this.dVR = new com.baidu.tieba.ala.liveroom.audiencelist.c(aPu().pageContext, this, false);
        }
        this.dVR.a(String.valueOf(aPu().eeL.uk().mLiveInfo.group_id), String.valueOf(aPu().eeL.uk().mLiveInfo.live_id), String.valueOf(aPu().eeL.uk().OR.userId), aPu().eeL.uk());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.dVR.c(this.dXh, a.g.ala_liveroom_hostheader, a.g.ala_liveroom_audience_count_layout);
            this.dVR.e(aPu().eeL.aKw());
        }
    }

    private void aOx() {
        if (this.dVW == null) {
            this.dVW = new com.baidu.tieba.ala.liveroom.operation.a(aPu().pageContext);
        }
        this.dVW.a(aPu(), this.dXi, aPu().eeL.uk().mLiveInfo.live_type, true, this.dWv);
        this.dVW.setOtherParams(tn());
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
        String str;
        if (aPu() != null && aPu().eeL != null && aPu().eeL.uk() != null && aPu().eeL.uk().Pj != null && (str = aPu().eeL.uk().Pj.userName) != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), aPu().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt))) {
            com.baidu.live.c.np().putInt("guide_rename_show_count", com.baidu.live.c.np().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.tZ().aE(true);
            if (this.dVU == null) {
                this.dVU = new com.baidu.tieba.ala.liveroom.q.b(aPu().pageContext);
            }
            this.dVU.setOtherParams(tn());
            this.dVU.f(this.dXi, aPu().eeL.uk());
            hv(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.6
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dVU.aVS();
                    a.this.hv(false);
                }
            }, 5000L);
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_SHOW);
            alaStaticItem.addParams("other_params", tn());
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    private void aOC() {
        if (this.dWM == null) {
            this.dWM = new com.baidu.tieba.ala.liveroom.s.a(aPu().pageContext, this);
        }
        this.dWM.d(aPu().eeM, false);
        this.dWM.im(aPt());
    }

    private void aOD() {
        if (aPu() != null && aPu().eeK != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(aPu().pageContext.getPageActivity());
            Activity pageActivity = aPu().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + pageActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds176)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.dWi = new ImageView(aPu().pageContext.getPageActivity());
            this.dWi.setVisibility(8);
            this.dWi.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.dWi.setImageResource(a.f.icon_live_enlarge);
            this.dWi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.dWj != null) {
                        a.this.dWj.vu();
                        a.this.dWi.setVisibility(4);
                    }
                }
            });
            aPu().eeM.addView(this.dWi, layoutParams);
            if (UtilHelper.getRealScreenOrientation(aPu().pageContext.getPageActivity()) != 2) {
                if (aPu().eeS) {
                    this.dWi.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.dWi != null && UtilHelper.getRealScreenOrientation(a.this.aPu().pageContext.getPageActivity()) != 2) {
                                a.this.dWi.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
        }
    }

    private void aOE() {
        if (this.dXo || this.dXp) {
            if ((TbadkCoreApplication.isLogin() && this.dWQ.sF().hasText()) || this.dXp) {
                this.dXo = false;
                this.dXp = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.9
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.aOX();
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
            e.printStackTrace();
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
        if (this.dWe != null) {
            this.dWe.b(iVar);
        }
        if (this.dVZ != null) {
            this.dVZ.g(iVar);
            if (iVar != null && this.dXg != null && !this.dXg.hasInit && !TextUtils.isEmpty(this.dXg.efy)) {
                this.dXg.hasInit = true;
                Log.e("Da88", "openDetail--4---url = " + this.dXg.efy);
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
        if (this.dVO != null) {
            this.dVO.removeAllViews();
            this.dVO = null;
        }
        if (this.dVP != null) {
            this.dVP.removeAllViews();
            this.dVP = null;
        }
        if (this.dVQ != null) {
            this.dVQ.removeAllViews();
            this.dVQ = null;
        }
        if (this.dWb != null) {
            this.dWb.nA();
        }
        if (this.dWe != null) {
            this.dWe.a((j.a) null);
            this.dWe.sk();
        }
        if (this.dWi != null && (this.dWi.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.dWi.getParent()).removeView(this.dWi);
        }
        if (this.dWf != null) {
            this.dWf.dismiss();
        }
        if (this.dWj != null) {
            this.dWj.aK(false);
            this.dWj.vv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void aOF() {
        View sK;
        super.aOF();
        if (this.dWe != null && (sK = this.dWe.sK()) != null && sK.getParent() != null) {
            ((ViewGroup) sK.getParent()).removeView(sK);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.dWe != null) {
            this.dWe.setOtherParams(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onDestory() {
        super.onDestory();
        this.dWm.removeCallbacksAndMessages(null);
        aOG();
        this.dWk = false;
        this.dWl = false;
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
        if (this.dWf != null) {
            this.dWf.onDestroy();
        }
        if (this.dVT != null) {
            this.dVT.onDestroy();
        }
        if (this.dWj != null) {
            this.dWj.stop();
        }
        if (this.dWM != null) {
            this.dWM.onDestroy();
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
        if (this.dWe != null) {
            this.dWe.a((j.a) null);
            this.dWe.release();
            this.dWe = null;
        }
        MessageManager.getInstance().removeMessageRule(this.dWo);
        MessageManager.getInstance().removeMessageRule(this.dWp);
        MessageManager.getInstance().unRegisterListener(this.dWr);
        MessageManager.getInstance().unRegisterListener(this.dWs);
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
        if (this.dWh != null && this.dWh.getParent() != null) {
            ((ViewGroup) this.dWh.getParent()).removeView(this.dWh);
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
        boolean z2 = this.dXk;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(aPu().pageContext.getPageActivity()) || z2) {
            hq(z);
        }
    }

    private void hq(boolean z) {
        int dimensionPixelSize;
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
                int equipmentHeight = (int) ((z ? 0.2f : 0.33f) * BdUtilHelper.getEquipmentHeight(aPu().pageContext.getPageActivity()));
                if (z) {
                    dimensionPixelSize = equipmentHeight + aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64);
                } else {
                    dimensionPixelSize = equipmentHeight + aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
                }
                if (this.dXi.indexOfChild(this.dWg) != -1 && this.dWg.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dWg.getLayoutParams();
                    layoutParams2.height = dimensionPixelSize;
                    this.dWg.setLayoutParams(layoutParams2);
                }
                if (this.dWg.indexOfChild(this.dWQ.sE().getView()) != -1 && this.dWQ.sE().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.dWQ.sE().getView().getLayoutParams();
                    layoutParams3.height = dimensionPixelSize;
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
            layoutParams.bottomMargin = aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
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
        if (this.dXh != null && (!this.dWk || UtilHelper.getRealScreenOrientation(aPu().pageContext.getPageActivity()) != 2)) {
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
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        RelativeLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = aPu().pageContext.getPageActivity();
        if (i3 == 1) {
            if (this.dXh != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.dXh.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.dWf != null) {
                this.dWf.dismiss();
            }
            if (this.dWe != null) {
                this.dWe.a((j.a) null);
                this.dWe.sk();
            }
            if (this.dWD != null) {
                this.dWD.A(true, true);
            }
            if (this.dWi != null) {
                this.dWi.setVisibility(0);
                this.dWi.bringToFront();
            }
            if (this.dWI != null) {
                this.dWI.setVisibility(0);
            }
            if (this.dWQ != null && this.dWQ.sE().getView().getParent() != null && (this.dWQ.sE().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.dWQ.sE().getView().getParent()).removeView(this.dWQ.sE().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(aPu().pageContext.getPageActivity()) * 0.75f);
            int equipmentHeight = ((int) (BdUtilHelper.getEquipmentHeight(aPu().pageContext.getPageActivity()) * 0.33f)) + aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
            if (this.dWg != null && this.dWQ != null) {
                this.dWg.addView(this.dWQ.sE().getView(), new FrameLayout.LayoutParams(equipmentWidth, equipmentHeight));
            }
            if (this.dWh != null && (this.dWh.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.dWh.getParent()).removeView(this.dWh);
            }
            if (this.dWR != null) {
                this.dWR.a(aPu().eeL.uk(), false);
                this.dWR.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.10
                    @Override // com.baidu.live.im.j.a
                    public void sM() {
                        a.this.aPi();
                    }
                });
                View sK = this.dWR.sK();
                if (sK != null && this.dXi != null && sK.getParent() == null) {
                    Resources resources = aPu().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(aPu().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds80));
                    layoutParams5.addRule(2, a.g.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                    this.dXi.addView(sK, layoutParams5);
                }
            }
            if (this.dWK != null) {
                this.dWK.setPraiseEnable(true);
                aPu().eeM.eqB = true;
            }
            if (this.dVR != null && this.dVR.dYb != null && (layoutParams3 = (RelativeLayout.LayoutParams) this.dVR.dYb.getLayoutParams()) != null) {
                this.dVR.dYb.setPadding(0, 0, 0, 0);
                this.dVR.dYb.setLayoutParams(layoutParams3);
            }
            if (this.dWM != null) {
                this.dWM.aXa();
            }
            if (this.dWk) {
                hn(true);
            }
            if (this.dWl) {
                if (this.dVW != null && this.dVW.getLandscapeBarrageImageView() != null) {
                    b(this.dVW.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.dVX != null) {
                this.dVX.hF(true);
            }
            this.dWm.removeCallbacksAndMessages(null);
            if (this.dVY != null) {
                this.dVY.setCanVisible(true);
                this.dVY.k(aPu().eeL.uk());
            }
        } else if (i3 == 2) {
            if (this.dWM != null) {
                this.dWM.aXb();
            }
            if (this.dXh != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.dXh.getLayoutParams()) != null) {
                layoutParams2.topMargin = aPu().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
            }
            if (this.dWR != null) {
                this.dWR.a(null);
                this.dWR.sk();
            }
            aPu().eeM.aWG();
            if (this.dWD != null) {
                this.dWD.A(false, true);
            }
            if (this.dWi != null) {
                this.dWi.setVisibility(4);
            }
            if (this.dWQ != null && this.dWQ.sE().getView().getParent() != null && (this.dWQ.sE().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.dWQ.sE().getView().getParent()).removeView(this.dWQ.sE().getView());
            }
            int max = Math.max(i, i2);
            if (this.dWh != null) {
                if (this.dWh.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.dWh.getParent()).removeView(this.dWh);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
                aPu().eeM.addView(this.dWh, layoutParams6);
            }
            if (this.dWh != null && this.dWe != null) {
                this.dWe.a(aPu().eeL.uk(), false);
                this.dWe.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.12
                    @Override // com.baidu.live.im.j.a
                    public void sM() {
                        a.this.aPi();
                    }
                });
                View sK2 = this.dWe.sK();
                if (sK2 != null && this.dWh.indexOfChild(sK2) < 0) {
                    this.dWh.addView(sK2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(aPu().pageContext.getPageActivity()), -1));
                }
            }
            if (this.dWK != null) {
                this.dWK.ah(aPu().eeM);
                this.dWK.setPraiseEnable(false);
                aPu().eeM.eqB = false;
            }
            if (this.dVR != null && this.dVR.dYb != null && (layoutParams = (RelativeLayout.LayoutParams) this.dVR.dYb.getLayoutParams()) != null) {
                int width = this.dVR.dYb.getWidth();
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                this.dVR.dYb.setPadding(width - ((int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f)), 0, 0, 0);
                this.dVR.dYb.setLayoutParams(layoutParams);
            }
            if (this.dVX != null) {
                this.dVX.hF(false);
            }
            com.baidu.tieba.ala.liveroom.yuangift.a.aWX().aAk();
            com.baidu.tieba.ala.liveroom.task.b.aWa().aAk();
            if (this.dVW != null && this.dVW.getLandscapeBarrageImageView() != null) {
                b(this.dVW.getLandscapeBarrageImageView(), this.dWl, false);
            }
            this.dWm.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.13
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.dWk) {
                        a.this.hn(false);
                    }
                }
            }, 5000L);
            if (this.dVY != null) {
                this.dVY.setCanVisible(false);
                this.dVY.aRU();
            }
        }
        if (this.dWT != null) {
            if (i3 == 2) {
                View pN = this.dWT.pN();
                if (pN != null) {
                    if (pN.getParent() != null && (pN.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) pN.getParent()).removeView(pN);
                    }
                    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams7.addRule(5, a.g.ala_liveroom_hostheader);
                    layoutParams7.addRule(3, a.g.ala_liveroom_hostheader);
                    layoutParams7.topMargin = aPu().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                    if (this.dXh != null) {
                        this.dXh.addView(pN, layoutParams7);
                    }
                }
            } else {
                View pN2 = this.dWT.pN();
                if (pN2 != null) {
                    if (pN2.getParent() != null && (pN2.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) pN2.getParent()).removeView(pN2);
                    }
                    RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams8.topMargin = aPu().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
                    layoutParams8.addRule(3, a.g.ala_live_header_view);
                    aPu().eeM.addView(pN2, layoutParams8);
                }
            }
        }
        if (this.dVW != null) {
            this.dVW.E(i, i2, i3);
        }
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.dVR != null) {
                this.dVR.bw(i3);
            }
            if (this.dVT != null) {
                this.dVT.bw(i3);
            }
            ns(i3);
            if (this.dVZ != null) {
                this.dVZ.bw(i3);
            }
            if (this.dWW != null) {
                this.dWW.bw(i3);
            }
            if (this.dXc != null) {
                this.dXc.bw(i3);
            }
            if (this.dWn != null && this.dWn.isShowing()) {
                this.dWn.resize();
            }
        }
        if (this.dWS != null) {
            this.dWS.pC();
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
            if (i != 7 || UtilHelper.getRealScreenOrientation(aPu().pageContext.getPageActivity()) != 2) {
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
            if (!this.dWk || UtilHelper.getRealScreenOrientation(aPu().pageContext.getPageActivity()) != 2) {
                this.dXh.setVisibility(0);
            }
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
        if (aPu() != null) {
            BdUtilHelper.hideSoftKeyPad(aPu().pageContext.getPageActivity(), aPu().pageContext.getPageActivity().getWindow().getDecorView());
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
    }

    private void ns(int i) {
        if (this.dVO != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dVO.getLayoutParams();
            layoutParams.width = ScreenHelper.getRealScreenWidth(aPu().pageContext.getPageActivity());
            if (i == 1) {
                layoutParams.width = (int) (layoutParams.width * 0.25f);
                layoutParams.topMargin = n.t(aPu().pageContext.getPageActivity());
                layoutParams.rightMargin = aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
            } else if (i == 2) {
                layoutParams.topMargin = 0 + aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds72) + aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds22) + aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                layoutParams.rightMargin = aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
            }
            layoutParams.width -= layoutParams.rightMargin * 2;
            this.dVO.setLayoutParams(layoutParams);
        }
    }
}
