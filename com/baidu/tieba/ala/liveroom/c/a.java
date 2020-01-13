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
import com.baidu.live.data.ao;
import com.baidu.live.data.aw;
import com.baidu.live.data.bc;
import com.baidu.live.data.f;
import com.baidu.live.data.l;
import com.baidu.live.data.w;
import com.baidu.live.im.i;
import com.baidu.live.im.j;
import com.baidu.live.im.k;
import com.baidu.live.message.GetQuickGiftHttpResponseMessage;
import com.baidu.live.r.a;
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
import com.baidu.live.utils.o;
import com.baidu.live.view.PriorityVerticalLinearLayout;
import com.baidu.tieba.ala.liveroom.i.b;
import com.baidu.tieba.ala.liveroom.i.g;
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.turntable.d;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends b {
    private PriorityVerticalLinearLayout eMJ;
    private LinearLayout eMK;
    private com.baidu.tieba.ala.liveroom.audiencelist.c eML;
    private com.baidu.tieba.ala.liveroom.n.a eMM;
    private com.baidu.tieba.ala.liveroom.f.b eMN;
    private com.baidu.tieba.ala.liveroom.u.b eMO;
    private com.baidu.tieba.ala.liveroom.operation.a eMP;
    private com.baidu.tieba.ala.liveroom.audiencelist.b eMQ;
    private com.baidu.tieba.ala.liveroom.k.a eMR;
    private com.baidu.tieba.ala.liveroom.activeview.b eMS;
    private com.baidu.live.d.a eMT;
    private j eMU;
    private i eMV;
    private com.baidu.tieba.ala.liveroom.attentionpop.b eMW;
    private com.baidu.tieba.ala.liveroom.e.b eMX;
    private com.baidu.tieba.ala.liveroom.share.b eMY;
    private FrameLayout eMZ;
    private FrameLayout eNa;
    private ImageView eNb;
    private com.baidu.live.tieba.e.b eNc;
    private com.baidu.live.gift.container.e eNg;
    private com.baidu.tieba.ala.liveroom.i.b eNh;
    private long lastClickTime = 0;
    private boolean eNd = false;
    private boolean eNe = false;
    private Handler eNf = new Handler();
    private HttpRule eNi = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.eMU != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.eMU.pp()) {
                httpMessage.addParam("ala_challenge_id", a.this.eMU.ps());
            }
            return httpMessage;
        }
    };
    private HttpRule eNj = new HttpRule(1021151) { // from class: com.baidu.tieba.ala.liveroom.c.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.eMU != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.eMU.pp()) {
                httpMessage.addParam("challenge_id", a.this.eMU.ps());
            }
            return httpMessage;
        }
    };
    private AlaLiveView.c eNk = new AlaLiveView.c() { // from class: com.baidu.tieba.ala.liveroom.c.a.17
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void bgQ() {
            if (a.this.eNK != null) {
                a.this.eNK.jP(false);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void iN(boolean z) {
            if (z) {
                if (a.this.eMP != null) {
                    a.this.eMP.qs(8);
                }
                if (a.this.eNK != null) {
                    a.this.eNK.jP(true);
                }
            } else {
                if (a.this.eMP != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                        a.this.eMP.qs(0);
                    } else {
                        a.this.eMP.qs(8);
                    }
                }
                if (a.this.eNK != null) {
                    a.this.eNK.jP(false);
                }
            }
            if (a.this.eNS != null) {
                a.this.eNS.ay(z);
            }
        }
    };
    private HttpMessageListener eNl = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.a.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.wE() != null) {
                        com.baidu.live.s.c.wW().atv = getQuickGiftHttpResponseMessage.wE();
                        a.this.bgq();
                    }
                }
            }
        }
    };
    private CustomMessageListener eNm = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.a.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bgz();
        }
    };
    private CustomMessageListener eNn = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.liveroom.c.a.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.eOf != null) {
                    a.this.eOf.yw(str);
                }
            }
        }
    };
    CustomMessageListener eNo = new CustomMessageListener(CmdConfigCustom.CMD_HOST_GET_WALLET_UA) { // from class: com.baidu.tieba.ala.liveroom.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.eOt != null && a.this.eOt.ezN != null && !a.this.eOt.eAt && !a.this.eOt.eCM) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.bhE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = a.this.bhE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                a.this.eOc.c(a.this.eMZ, layoutParams);
                com.baidu.tieba.ala.guardclub.a.bcK().bcL();
            }
        }
    };
    private CustomMessageListener eNp = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (a.this.eOd != null) {
                    a.this.eOd.dismiss();
                }
                k.uW().setSwitchStatus(true);
                k.uW().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bhd();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener eNq = new CustomMessageListener(2913151) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913151) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.eNh.c(a.this.bhE());
                } else if (a.this.bgX() || !g.pS(2913151)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, null));
                        }
                    }, 3000L);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.bhE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.bhE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    a.this.eNh.c(a.this.eMZ, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b eNr = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.a.8
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void m(View view, int i) {
            ao aoVar;
            aw awVar;
            bc bcVar;
            ao aoVar2;
            aw awVar2;
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - a.this.lastClickTime >= 300) {
                a.this.lastClickTime = currentTimeMillis;
                if (i == 2 && a.this.tH()) {
                    a.this.I(-1, -1, -1);
                } else if (i == 13) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.s.c.wW().atv.rt().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.s.c.wW().atv.rt().qE());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.s.c.wW().atv.rt().qF());
                        if (a.this.bhE().eWr.ww() != null && a.this.bhE().eWr.ww().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.bhE().eWr.ww().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.bhE().eWr.ww().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.vz());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.tH()) {
                        if (com.baidu.live.c.oJ().getBoolean("quick_gift_guide_show", true) && !a.this.bgX()) {
                            com.baidu.live.gift.container.e eVar = new com.baidu.live.gift.container.e(a.this.bhE().pageContext.getPageActivity(), a.this.bhE().pageContext, a.this.bhE().eWr.ww(), com.baidu.live.s.c.wW().atv.rt(), a.this.vz());
                            eVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.8.1
                                @Override // android.content.DialogInterface.OnDismissListener
                                public void onDismiss(DialogInterface dialogInterface) {
                                    a.this.iP(false);
                                    a.this.eNg = null;
                                }
                            });
                            a.this.eNg = eVar;
                            eVar.show();
                            a.this.iP(true);
                            return;
                        }
                        com.baidu.live.gift.b.c.a(a.this.bhE().pageContext, a.this.bhE().eWr.ww(), com.baidu.live.s.c.wW().atv.rt(), a.this.vz());
                    }
                } else if (i == 1) {
                    if (a.this.eNO != null) {
                        a.this.bhd();
                    }
                } else if (i == 3 && a.this.tH()) {
                    if (a.this.mOrientation == 2 && TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.eMY != null) {
                            a.this.eMY.s(a.this.bhE().eWr.ww());
                        }
                    } else {
                        a.this.eND.c(a.this.bhE().eWr.ww(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.bhE() != null && a.this.bhE().eWr != null && a.this.bhE().eWr.ww() != null && a.this.bhE().eWr.ww().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.bhE().eWr.ww().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.bhE().eWr.ww().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.bhE().eWr.ww().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.vz());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.bhE() != null && a.this.bhE().eWr != null && a.this.bhE().eWr.ww() != null && a.this.bhE().eWr.ww().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.bhE().eWr.ww().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.bhE().eWr.ww().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.bhE().eWr.ww().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.vz());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.eNA != null) {
                        a.this.eNA.ja(false);
                    }
                } else if (i == 12) {
                    if (a.this.eNK != null) {
                        String valueOf = String.valueOf(a.this.bhE().eWr.ww().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.bhE().eWr.ww().mLiveInfo.room_id);
                        String str2 = null;
                        com.baidu.live.data.j jVar = a.this.bhE().eWr.ww().mLiveSdkInfo;
                        if (jVar != null && jVar.mCastIds != null) {
                            str2 = String.valueOf(a.this.bhE().eWr.ww().mLiveSdkInfo.mCastIds.Wm);
                        }
                        a.this.eNK.ad(valueOf, valueOf2, str2);
                        if (com.baidu.live.liveroom.a.wl().wm()) {
                            a.this.bgz();
                        }
                    }
                } else if (i == 14) {
                    l ww = a.this.bhE().eWr.ww();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.bhE().pageContext.getPageActivity(), ww.Wf.userName, Long.toString(ww.Wf.userId), Long.toString(ww.Wf.charmCount), String.valueOf(ww.mLiveInfo.group_id), String.valueOf(ww.mLiveInfo.live_id), false, String.valueOf(ww.Wf.userId), Long.toString(ww.Wt.userId), ww.Wt.userName, ww.Wt.portrait, a.this.eMQ.getCount(), a.this.vz())));
                    LogManager.getCommonLogger().doClickGusetNumLog(ww.mLiveInfo.feed_id, a.this.eMQ.getCount() + "", a.this.vz());
                } else if (i == 11) {
                    a.this.bhg();
                    a.this.bhh();
                } else if (i == 15) {
                    if (a.this.eOa != null && a.this.bhE() != null && a.this.bhE().eWr != null && a.this.bhE().eWr.ww() != null && a.this.bhE().eWr.ww().mLiveInfo != null) {
                        long j = a.this.bhE().eWr.ww().mLiveInfo.live_id;
                        String valueOf3 = String.valueOf(a.this.bhE().eWr.ww().mLiveInfo.feed_id);
                        long j2 = a.this.bhE().eWr.ww().mLiveInfo.room_id;
                        String str3 = a.this.bhE().eWr.ww().mLiveInfo.cover;
                        String str4 = "";
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        if (a.this.bhE().eWr.ww().mLiveInfo.session_info != null) {
                            str4 = a.this.bhE().eWr.ww().mLiveInfo.session_info.flvUrl;
                        }
                        if (!TextUtils.isEmpty(a.this.vz())) {
                            try {
                                JSONObject jSONObject = new JSONObject(a.this.vz());
                                str5 = jSONObject.optString("tab");
                                str6 = jSONObject.optString("tag");
                                str7 = jSONObject.optString("source");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        a.this.eOa.yw(o.a(valueOf3, j + "", j2, false, 1, str3, str4, str5, str6, str7));
                        o.azz = j;
                        if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                            ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                            LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf3, a.this.vz());
                        }
                    }
                } else if (i == 16) {
                    if (a.this.bhE() != null && (aoVar2 = com.baidu.live.s.a.wR().atk) != null && (awVar2 = aoVar2.aaU) != null) {
                        String str8 = awVar2.abK.abR;
                        if (!TextUtils.isEmpty(str8)) {
                            long j3 = 0;
                            if (a.this.bhE().eWr != null && a.this.bhE().eWr.ww() != null && a.this.bhE().eWr.ww().mLiveInfo != null) {
                                j3 = a.this.bhE().eWr.ww().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j3 + "", a.this.bhE().eWr.ww().mLiveInfo.room_id + "", a.this.bhE().eWr.ww().mLiveInfo.feed_id, a.this.vz());
                            }
                            if (str8.contains("?")) {
                                str = str8 + "&liveId=" + j3;
                            } else {
                                str = str8 + "?liveId=" + j3;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.bhE().pageContext.getPageActivity(), str);
                        }
                    }
                } else if (i == 17) {
                    if (a.this.tH() && a.this.bhE() != null && (aoVar = com.baidu.live.s.a.wR().atk) != null && (awVar = aoVar.aaU) != null && (bcVar = awVar.abL) != null && !TextUtils.isEmpty(bcVar.webUrl) && a.this.eOd != null && a.this.bhE().eWr != null && a.this.bhE().eWr.ww() != null) {
                        l ww2 = a.this.bhE().eWr.ww();
                        a.this.eOd.a(bcVar.webUrl, ww2.mLiveInfo.live_id, ww2.Wt.userId, ww2.Wf.userId);
                        a.this.eNc.bf(false);
                        a.this.eNc.xJ();
                    }
                } else if (i == 18) {
                    if (a.this.eNe) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.eNe = !a.this.eNe;
                } else if (i == 19 && a.this.eNc != null) {
                    a.this.eNc.xJ();
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void init() {
        super.init();
        this.eNF = new com.baidu.tieba.ala.liveroom.guide.c(bhE().pageContext, this, false);
        this.eNi.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.eNi);
        this.eNj.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.eNj);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean bgb() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void xc() {
        super.xc();
        g.bkl();
        this.eNe = false;
        if (this.eNI != null) {
            this.eNI.b(this.eNr);
        }
        if (this.eNc == null) {
            this.eNc = new com.baidu.live.tieba.e.b(bhE().pageContext.getPageActivity());
            this.eNc.start();
        }
        this.eNc.bf(true);
        bhE().pageContext.getPageActivity().setRequestedOrientation(-1);
        bhE().eWs.setIsForceHandledTouch(false);
        bhE().eWs.setSwipeClearEnable(true);
        bhE().eWs.setOnLiveViewScrollListener(this.eNk);
        bhE().eWs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eNf.removeCallbacksAndMessages(null);
                a.this.iH(false);
                if (!a.this.eNd) {
                    a.this.eNf.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.eNd) {
                                a.this.iH(false);
                            }
                        }
                    }, 5000L);
                }
            }
        });
        if (this.eOm != null) {
            this.eOm.setVisibility(0);
        }
        bgf();
        bgi();
        bgt();
        bgT();
        bgu();
        bge();
        bgw();
        bgv();
        iI(false);
        bhk();
        bhj();
        bgk();
        bgr();
        bgs();
        bhm();
        bgc();
        bgy();
        bgA();
        iQ(true);
        bgj();
        bgq();
        bhs();
        bgl();
        bgm();
        bgn();
        bgo();
        bgB();
        bhr();
        if (this.eOd != null && this.eOd.boU() == null) {
            this.eOd.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.19
                @Override // com.baidu.tieba.ala.liveroom.turntable.d.a
                public void onDismiss() {
                    a.this.eNc.bf(true);
                }
            });
        }
        MessageManager.getInstance().registerListener(this.eNl);
        MessageManager.getInstance().registerListener(this.eNm);
        MessageManager.getInstance().registerListener(this.eNo);
        MessageManager.getInstance().registerListener(this.eNp);
        MessageManager.getInstance().registerListener(this.eNq);
        MessageManager.getInstance().registerListener(this.eNn);
        bgC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iH(boolean z) {
        View rB;
        if (bhE() != null && bhE().pageContext != null && bhE().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(bhE().pageContext.getPageActivity()) == 2 || z) {
                if (this.eNR != null && (rB = this.eNR.rB()) != null) {
                    if (this.eNd) {
                        rB.setVisibility(0);
                    } else {
                        rB.setVisibility(8);
                    }
                }
                if (this.eNd) {
                    if (this.eOm != null) {
                        this.eOm.setVisibility(0);
                    }
                    if (this.eOn != null) {
                        this.eOn.setVisibility(0);
                    }
                    if (this.eMK != null) {
                        this.eMK.setVisibility(0);
                    }
                    if (this.eMJ != null) {
                        this.eMJ.setVisibility(0);
                    }
                    if (this.eNQ != null) {
                        this.eNQ.aw(false);
                    }
                } else {
                    if (this.eOm != null) {
                        this.eOm.setVisibility(8);
                    }
                    if (this.eOn != null) {
                        this.eOn.setVisibility(8);
                    }
                    if (this.eMK != null) {
                        this.eMK.setVisibility(8);
                    }
                    if (this.eMJ != null) {
                        this.eMJ.setVisibility(8);
                    }
                    if (this.eNQ != null) {
                        this.eNQ.aw(true);
                    }
                }
                this.eNd = this.eNd ? false : true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, boolean z2) {
        ImageView imageView;
        View rk;
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view;
        }
        if (z) {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_off);
            }
            if (this.eNa != null) {
                this.eNa.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_on);
            }
            if (this.eNa != null) {
                this.eNa.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.eNQ != null && (rk = this.eNQ.rk()) != null) {
            if (z) {
                rk.setVisibility(8);
            } else {
                rk.setVisibility(0);
            }
        }
    }

    private void bgc() {
        if (this.eMX == null) {
            this.eMX = new com.baidu.tieba.ala.liveroom.e.b(bhE().pageContext);
        }
        this.eMX.setOtherParams(this.otherParams);
        this.eMX.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.20
            @Override // com.baidu.live.im.j.a
            public void uV() {
                a.this.bhp();
            }
        });
    }

    private void bgd() {
        if (this.eNJ != null) {
            this.eNJ.ah(bhE().eWt);
        }
    }

    private void bge() {
        if (this.eMY == null) {
            this.eMY = new com.baidu.tieba.ala.liveroom.share.b(bhE().pageContext);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void bd(int i) {
        super.bd(i);
        if (this.eNb != null && UtilHelper.getRealScreenOrientation(bhE().pageContext.getPageActivity()) != 2) {
            this.eNb.setVisibility(0);
        }
        bgd();
        if (this.eMV != null) {
            this.eMV.bd(i);
        }
        if (this.eMV == null || !this.eMV.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void iI(boolean z) {
        super.iI(z);
        this.eNQ.bk(bhE().eWr.ww().mLiveInfo.screen_direction);
    }

    private void bgf() {
        if (this.eMJ == null) {
            this.eMJ = new PriorityVerticalLinearLayout(bhE().pageContext.getPageActivity());
            this.eMJ.setDefaultItemMargin(bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            bgh();
        }
        if (this.eMJ.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, bgg());
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            layoutParams.rightMargin = bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
            layoutParams.bottomMargin = bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
            bhE().eWs.addView(this.eMJ, layoutParams);
        }
    }

    private int bgg() {
        return ((bhE().eWs.getBottom() - bhE().eWq.getBottom()) - bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
    }

    private void bgh() {
        View view = new View(bhE().pageContext.getPageActivity());
        view.setTag(a.g.sdk_pvl_layout_priority_tag_key, 20);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(1, 0);
        layoutParams.weight = 1.0f;
        this.eMJ.addView(view, layoutParams);
    }

    private void bgi() {
        if (this.eMK == null) {
            this.eMK = new LinearLayout(bhE().pageContext.getPageActivity());
            this.eMK.setOrientation(1);
        }
        if (this.eMK.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds228);
            layoutParams.leftMargin = bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bhE().eWs.addView(this.eMK, layoutParams);
        }
    }

    private void bgj() {
        if (this.eMS == null) {
            this.eMS = new com.baidu.tieba.ala.liveroom.activeview.b(bhE().pageContext);
        }
        this.eMS.setOtherParams(vz());
        this.eMS.b(bhE().eWr.ww(), true);
        this.eMS.setHost(false);
        this.eMS.a(1, this.eMJ, pI(1));
        this.eMS.a(2, this.eMJ, pI(2));
        this.eMS.setVisible(this.eOq ? 8 : 0);
    }

    private void bgk() {
        if (this.eNH != null && bhE() != null && bhE().eWr != null) {
            this.eNH.b(this.eOm, bhE().eWr.ww());
        }
    }

    private ViewGroup.LayoutParams pI(int i) {
        switch (i) {
            case 1:
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = bhE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds40);
                return layoutParams;
            case 2:
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 5;
                layoutParams2.topMargin = bhE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                return layoutParams2;
            default:
                return new RelativeLayout.LayoutParams(-1, -2);
        }
    }

    private void bgl() {
        if (this.eMJ != null) {
            if (this.eMR == null) {
                this.eMR = new com.baidu.tieba.ala.liveroom.k.a(bhE().pageContext, this);
            }
            this.eMR.setOtherParams(vz());
            this.eMR.d(this.eMJ, bgp());
            this.eMR.o(bhE().eWr.ww());
        }
    }

    private void bgm() {
        if (this.eOc == null) {
            this.eOc = new com.baidu.tieba.ala.liveroom.l.c(bhE().pageContext, vz());
        }
        if (this.eMZ != null && this.eMZ.indexOfChild(this.eOc.getView()) >= 0) {
            this.eMZ.removeView(this.eOc.getView());
        }
    }

    private void bgn() {
        if (this.eMP != null) {
            this.eMP.a(new a.InterfaceC0454a() { // from class: com.baidu.tieba.ala.liveroom.c.a.5
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0454a
                public void bk(int i, int i2) {
                    l ww = a.this.bhE().eWr.ww();
                    if (ww != null && ww.mLiveInfo != null) {
                        if (a.this.eOe == null) {
                            a.this.eOe = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.bhE().pageContext.getPageActivity());
                        }
                        a.this.eOe.d(a.this.eOn, i, i2);
                        a.this.eOe.a(String.valueOf(ww.mLiveInfo.live_id), new a.InterfaceC0459a() { // from class: com.baidu.tieba.ala.liveroom.c.a.5.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0459a
                            public void a(float f, String str) {
                                if (a.this.eMP != null) {
                                    a.this.eMP.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0454a
                public void bl(int i, int i2) {
                    if (a.this.eOe != null) {
                        a.this.eOe.bq(i, i2);
                    }
                }
            });
        }
    }

    private void bgo() {
        if (this.eOA == null) {
            this.eOA = new com.baidu.tieba.ala.liveroom.i.e(bhE().pageContext);
        }
        this.eOA.setRoomId(bhE().eWr.ww().mLiveInfo.room_id);
        this.eOA.yG("");
        this.eOA.a(bhE().eWr.ww(), this.eMJ);
        if (this.eNh == null) {
            this.eNh = new com.baidu.tieba.ala.liveroom.i.b(bhE().pageContext, vz(), this.eOA, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.6
                @Override // com.baidu.tieba.ala.liveroom.i.b.a
                public void bgO() {
                    a.this.iP(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.i.b.a
                public void bgP() {
                    a.this.iP(false);
                }
            });
        }
        this.eNh.setRoomId(bhE().eWr.ww().mLiveInfo.room_id);
        if (this.eMZ != null && this.eMZ.indexOfChild(this.eNh.getView()) >= 0) {
            this.eMZ.removeView(this.eNh.getView());
        }
        if (this.eNh != null) {
            this.eNh.b(bhE());
        }
    }

    private ViewGroup.LayoutParams bgp() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = bhE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgq() {
        if (this.eMP == null) {
            bgv();
        }
        this.eMP.a(com.baidu.live.s.c.wW().atv, bhE().eWr.ww());
    }

    private void bgr() {
        CustomResponsedMessage runTask;
        if (this.eNO == null && (runTask = MessageManager.getInstance().runTask(2913039, com.baidu.live.im.i.class, bhE().pageContext)) != null && runTask.getData() != null) {
            this.eNO = (com.baidu.live.im.i) runTask.getData();
            this.eNO.setFromMaster(false);
            this.eNO.uM().getView().setId(a.g.ala_liveroom_msg_list);
            this.eNO.a(new i.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.7
                @Override // com.baidu.live.im.i.a
                public boolean uO() {
                    return a.this.tH();
                }

                @Override // com.baidu.live.im.i.a
                public void uP() {
                    a.this.eOu = true;
                }

                @Override // com.baidu.live.im.i.a
                public void dB(String str) {
                    if (!a.this.eOq) {
                        a.this.iM(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.bhE().pageContext.getPageActivity(), a.this.bhE().eWt);
                    }
                    a.this.yt(str);
                }

                @Override // com.baidu.live.im.i.a
                public void uQ() {
                    if (a.this.eOq) {
                        a.this.iM(true);
                        a.this.bhE().eWt.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.bhE().pageContext.getPageActivity(), a.this.bhE().eWt);
                            }
                        }, 10L);
                    } else if (a.this.eNO != null) {
                        a.this.eNO.uN().setQuickInputPanelVisible(false);
                        a.this.eNO.uN().vS();
                    }
                }

                @Override // com.baidu.live.im.i.a
                public void uR() {
                    if (a.this.eOq) {
                        a.this.bgL();
                        if (a.this.eNP != null) {
                            a.this.eNP.uU();
                        }
                        if (a.this.eMX != null) {
                            a.this.eMX.uU();
                        }
                    } else if (a.this.eNO != null) {
                        a.this.eNO.uN().setQuickInputPanelVisible(false);
                        a.this.eNO.uN().vS();
                    }
                }

                @Override // com.baidu.live.im.i.a
                public boolean uS() {
                    return a.this.bgY();
                }
            });
            this.eMZ = new FrameLayout(bhE().pageContext.getPageActivity());
            this.eMZ.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.eNO != null && this.eMZ != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bhE().pageContext.getPageActivity()) * 0.75f);
            int dimensionPixelSize = bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds120) + ((int) (BdUtilHelper.getEquipmentHeight(bhE().pageContext.getPageActivity()) * 0.33f));
            if (this.eOn.indexOfChild(this.eMZ) < 0) {
                if (this.eMZ.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eMZ.getParent()).removeView(this.eMZ);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                this.eOn.addView(this.eMZ, layoutParams);
            }
            if (this.eMZ.indexOfChild(this.eNO.uM().getView()) < 0) {
                if (this.eNO.uM().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eNO.uM().getView()).removeView(this.eNO.uM().getView());
                }
                if (UtilHelper.getRealScreenOrientation(bhE().pageContext.getPageActivity()) != 2) {
                    this.eMZ.addView(this.eNO.uM().getView(), new FrameLayout.LayoutParams(equipmentWidth, dimensionPixelSize));
                }
            }
            if (bhE().eWs.indexOfChild(this.eNO.uN().getView()) < 0) {
                if (this.eNO.uN().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eNO.uN().getView().getParent()).removeView(this.eNO.uN().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bhe();
                bhE().eWs.addView(this.eNO.uN().getView(), layoutParams2);
            }
            l ww = bhE().eWr.ww();
            if (ww != null && ww.mLiveInfo != null) {
                this.eNO.setLogData(ww.mLiveInfo.feed_id, vz());
            }
            this.eNO.e(String.valueOf(bhE().eWr.ww().mLiveInfo.group_id), String.valueOf(bhE().eWr.ww().mLiveInfo.last_msg_id), String.valueOf(bhE().eWr.ww().Wf.userId), String.valueOf(bhE().eWr.ww().mLiveInfo.live_id), bhE().eWr.ww().Wf.appId);
            iM(false);
        }
    }

    private void bgs() {
        if (this.eNa == null) {
            this.eNa = new FrameLayout(bhE().pageContext.getPageActivity());
            this.eNa.setId(a.g.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void bgt() {
        if (this.eMM == null) {
            this.eMM = new com.baidu.tieba.ala.liveroom.n.a(bhE().pageContext, false, this);
        }
        this.eMM.d(this.eOm, bhE().eWr.ww());
        this.eMM.a(this.eNr);
    }

    private void bgu() {
        if (this.eML == null) {
            this.eML = new com.baidu.tieba.ala.liveroom.audiencelist.c(bhE().pageContext, this, false);
        }
        this.eML.a(String.valueOf(bhE().eWr.ww().mLiveInfo.group_id), String.valueOf(bhE().eWr.ww().mLiveInfo.live_id), String.valueOf(bhE().eWr.ww().Wf.userId), bhE().eWr.ww());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.eNC != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.eML.c(this.eOm, i, a.g.ala_liveroom_audience_count_layout);
            this.eML.f(bhE().eWr.bbH());
        }
    }

    private void bgv() {
        if (this.eMP == null) {
            this.eMP = new com.baidu.tieba.ala.liveroom.operation.a(bhE().pageContext);
        }
        this.eMP.a(bhE(), this.eOn, bhE().eWr.ww().mLiveInfo.live_type, true, this.eNr);
        this.eMP.setOtherParams(vz());
    }

    private void bgw() {
        if (this.eMQ == null) {
            this.eMQ = new com.baidu.tieba.ala.liveroom.audiencelist.b(bhE().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (bhE().eWr.bbH() != null) {
            j = bhE().eWr.bbH().getCount();
        }
        this.eMQ.a(this.eNr);
        this.eMQ.a(this.eOm, a.g.ala_liveroom_audience, j);
        this.eMQ.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.eMQ.je(false);
        } else {
            this.eMQ.je(true);
        }
    }

    public void bgx() {
        this.eND.c(bhE().eWr.ww(), false);
    }

    public void bgy() {
        if (bhE().eWr.ww() != null && bhE().eWr.ww().Wf != null && bhE().eWr.ww().mLiveInfo != null) {
            if (this.eMO == null) {
                this.eMO = new com.baidu.tieba.ala.liveroom.u.b(bhE().pageContext);
            }
            long j = bhE().eWr.ww().Wf.userId;
            int i = bhE().eWr.ww().mLiveInfo.live_type;
            String str = bhE().eWr.ww().Wf.portrait;
            String str2 = bhE().eWr.ww().mLiveInfo.feed_id;
            long j2 = bhE().eWr.ww().mLiveInfo.live_id;
            this.eMO.a(i, j, bhE().eWr.ww().Wf.userName, false, str, vz(), str2, j2);
            this.eMO.ad(this.eOm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgz() {
        String str;
        if (bhE() != null && bhE().eWr != null && bhE().eWr.ww() != null && bhE().eWr.ww().Wt != null && (str = bhE().eWr.ww().Wt.userName) != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bhE().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !bgX()) {
            com.baidu.live.c.oJ().putInt("guide_rename_show_count", com.baidu.live.c.oJ().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.wl().aX(true);
            if (this.eOh == null) {
                this.eOh = new com.baidu.tieba.ala.liveroom.v.a(bhE().pageContext);
            }
            this.eOh.setOtherParams(vz());
            this.eOh.f(this.eOn, bhE().eWr.ww());
            iP(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eOh.boH();
                    a.this.iP(false);
                }
            }, 5000L);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_SHOW);
                alaStaticItem.addParams("other_params", vz());
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    private void bgA() {
        if (this.eNK == null) {
            this.eNK = new com.baidu.tieba.ala.liveroom.x.a(bhE().pageContext, this);
        }
        this.eNK.d(bhE().eWs, false);
        this.eNK.jO(bhD());
    }

    private void bgB() {
        if (bhE() != null && bhE().eWq != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(bhE().pageContext.getPageActivity());
            Activity pageActivity = bhE().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + pageActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds176)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.eNb = new ImageView(bhE().pageContext.getPageActivity());
            this.eNb.setVisibility(8);
            this.eNb.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.eNb.setImageResource(a.f.icon_live_enlarge);
            this.eNb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.eNc != null) {
                        a.this.eNc.xI();
                        a.this.eNb.setVisibility(4);
                    }
                }
            });
            bhE().eWs.addView(this.eNb, layoutParams);
            if (UtilHelper.getRealScreenOrientation(bhE().pageContext.getPageActivity()) != 2) {
                if (bhE().eWy) {
                    this.eNb.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.12
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.eNb != null && UtilHelper.getRealScreenOrientation(a.this.bhE().pageContext.getPageActivity()) != 2) {
                                a.this.eNb.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
        }
    }

    private void bgC() {
        if (this.eOu || this.eOv) {
            if ((TbadkCoreApplication.isLogin() && this.eNO.uN().hasText()) || this.eOv) {
                this.eOu = false;
                this.eOv = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bhd();
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
                if (this.eMR != null) {
                    this.eMR.u(jSONObject);
                }
            } else if ("enter_live".equals(optString)) {
                if (this.eMQ.getCount() > 20) {
                    this.eMQ.cA(this.eMQ.getCount() + 1);
                } else if (this.eML != null) {
                    com.baidu.live.data.a vq = aVar.vq();
                    f fVar = new f();
                    fVar.Wg = new AlaLocationData();
                    fVar.Wh = new AlaRelationData();
                    fVar.Wf = new AlaLiveUserInfoData();
                    fVar.Wf.userId = JavaTypesHelper.toLong(vq.userId, 0L);
                    fVar.Wf.userName = vq.userName;
                    fVar.Wf.portrait = vq.portrait;
                    if (this.eML.c(fVar)) {
                        this.eMQ.cA(this.eMQ.getCount() + 1);
                    }
                }
            } else if ("update_liveinfo".equals(optString) && bhE().eWr.ww() != null && bhE().eWr.ww().mLiveInfo != null) {
                bhE().eWr.a(bhE().eWr.ww().mLiveInfo.live_id, bhE().fromType, bhE().enterTime);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void yp(String str) {
        if (this.eMS != null) {
            this.eMS.yp(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void b(l lVar) {
        super.b(lVar);
        if (this.eMM != null) {
            this.eMM.p(lVar);
        }
        if (this.eMN != null) {
            this.eMN.l(lVar);
        }
        if (this.eMR != null) {
            this.eMR.o(lVar);
        }
        if (this.eMV != null) {
            this.eMV.a(lVar);
        }
        if (this.eMX != null) {
            this.eMX.a(lVar);
        }
        if (this.eMS != null) {
            this.eMS.g(lVar);
            if (lVar != null && this.eOk != null && !this.eOk.hasInit && !TextUtils.isEmpty(this.eOk.eXn)) {
                this.eOk.hasInit = true;
                this.eMS.yq(this.eOk.eXn);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void c(com.baidu.live.data.g gVar) {
        if (gVar != null) {
            if (this.eML != null && gVar.getList() != null) {
                this.eML.f(gVar);
            }
            if (this.eMQ != null) {
                this.eMQ.cA(gVar.getCount());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void iJ(boolean z) {
        super.iJ(z);
        if (bhE().eWs != null) {
            bhE().eWs.bps();
            bhE().eWs.setOnDispatchTouchEventListener(null);
            bhE().eWs.setOnLiveViewScrollListener(null);
        }
        if (bhE().eWq != null) {
            bhE().eWq.setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.eMV != null) {
            this.eMV.oZ();
        }
        bgE();
        if (this.eMO != null) {
            this.eMO.oZ();
        }
        if (this.eNK != null) {
            this.eNK.release();
        }
        if (this.eMR != null) {
            this.eMR.oZ();
        }
        if (this.eMP != null) {
            this.eMP.bog();
        }
        if (this.eMN != null) {
            this.eMN.bjD();
            this.eMN.setVisible(8);
        }
        if (this.eMT != null) {
            this.eMT.oZ();
        }
        if (this.eMS != null) {
            this.eMS.release();
        }
        if (this.eMJ != null) {
            this.eMJ.removeAllViews();
            this.eMJ = null;
        }
        if (this.eMK != null) {
            this.eMK.removeAllViews();
            this.eMK = null;
        }
        if (this.eMU != null) {
            this.eMU.oZ();
        }
        if (this.eMX != null) {
            this.eMX.a((j.a) null);
            this.eMX.us();
        }
        if (this.eNb != null && (this.eNb.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.eNb.getParent()).removeView(this.eNb);
        }
        if (this.eMY != null) {
            this.eMY.dismiss();
        }
        if (this.eNc != null) {
            this.eNc.bf(false);
            this.eNc.xJ();
        }
        if (this.eNh != null) {
            this.eNh.oZ();
        }
        if (this.eOA != null) {
            this.eOA.biH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void bgD() {
        View uT;
        super.bgD();
        if (this.eMX != null && (uT = this.eMX.uT()) != null && uT.getParent() != null) {
            ((ViewGroup) uT.getParent()).removeView(uT);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.eMX != null) {
            this.eMX.setOtherParams(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void iK(boolean z) {
        super.iK(z);
        this.eNf.removeCallbacksAndMessages(null);
        bgE();
        this.eNd = false;
        this.eNe = false;
        if (this.eMM != null) {
            this.eMM.onDestroy();
        }
        if (this.eMO != null) {
            this.eMO.onDestroy();
        }
        if (this.eMR != null) {
            this.eMR.onDestroy();
        }
        if (this.eMT != null) {
            this.eMT.onDestroy();
        }
        if (this.eMU != null) {
            this.eMU.onDestroy();
        }
        if (this.eMV != null) {
            this.eMV.onDestroy();
        }
        if (this.eMW != null) {
            this.eMW.onDestroy();
        }
        if (this.eMY != null) {
            this.eMY.onDestroy();
        }
        if (this.eMN != null) {
            this.eMN.onDestroy();
        }
        if (this.eNc != null) {
            this.eNc.stop();
        }
        if (this.eNK != null) {
            this.eNK.onDestroy();
        }
        if (this.eML != null) {
            this.eML.onDestroy();
        }
        if (this.eNO != null) {
            this.eNO.onDestroy();
        }
        if (this.eMP != null) {
            this.eMP.onDestory();
        }
        if (this.eMX != null) {
            this.eMX.a((j.a) null);
            this.eMX.release();
            this.eMX = null;
        }
        if (this.eOA != null) {
            this.eOA.jn(z ? false : true);
        }
        MessageManager.getInstance().removeMessageRule(this.eNi);
        MessageManager.getInstance().removeMessageRule(this.eNj);
        MessageManager.getInstance().unRegisterListener(this.eNl);
        MessageManager.getInstance().unRegisterListener(this.eNm);
        MessageManager.getInstance().unRegisterListener(this.eNo);
        MessageManager.getInstance().unRegisterListener(this.eNp);
        MessageManager.getInstance().unRegisterListener(this.eNq);
        MessageManager.getInstance().unRegisterListener(this.eNn);
    }

    private void bgE() {
        if (this.eNO != null && this.eNO.uM().getView() != null && this.eNO.uM().getView().getParent() != null) {
            ((ViewGroup) this.eNO.uM().getView().getParent()).removeView(this.eNO.uM().getView());
        }
        if (this.eMZ != null && this.eMZ.getParent() != null) {
            ((ViewGroup) this.eMZ.getParent()).removeView(this.eMZ);
        }
        if (this.eNa != null && this.eNa.getParent() != null) {
            ((ViewGroup) this.eNa.getParent()).removeView(this.eNa);
        }
        if (this.eNO != null && this.eNO.uN().getView() != null) {
            this.eOn.removeView(this.eNO.uN().getView());
        }
        if (this.eNO != null) {
            this.eNO.uM().setMsgData(new LinkedList());
            this.eNO.us();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void a(w wVar) {
        if (this.eNO != null) {
            bhd();
            this.eNO.uN().setEditText(" @" + wVar.getNameShow() + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.eMP != null) {
            this.eMP.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void e(com.baidu.live.data.a aVar) {
        if (this.eNO != null) {
            bhd();
            this.eNO.uN().setEditText(" @" + aVar.userName + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.eMP != null) {
            this.eMP.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void b(w wVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected View bgF() {
        if (this.eNO != null) {
            return this.eNO.uN().getView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean bgG() {
        if (this.eNO == null || !this.eNO.uN().vR()) {
            return false;
        }
        iM(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean bgH() {
        return this.eMM == null || this.eMM.bgH();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup bgI() {
        return this.eMJ;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup bgJ() {
        return this.eMK;
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
                    this.eOr = false;
                    I(intExtra, intExtra2, intExtra3);
                    return;
                }
                bgx();
                return;
            }
            bhC();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.eOq;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(bhE().pageContext.getPageActivity()) || z2) {
            iL(z);
        }
    }

    private void iL(boolean z) {
        int dimensionPixelSize;
        if (this.eNO != null && this.eNO.uM() != null) {
            this.eNO.uM().onKeyboardVisibilityChanged(z);
        }
        if (z || this.eNO == null || !this.eNO.uN().vR()) {
            if (z) {
                if (this.eMP != null) {
                    this.eMP.setVisibility(8);
                }
                if (this.eNQ != null && this.eNQ.rk() != null) {
                    this.eNQ.rk().setVisibility(8);
                }
                bgL();
                if (this.eNO != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eNO.uN().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.eNO.uN().getView().setLayoutParams(layoutParams);
                    this.eNO.uN().getView().setVisibility(0);
                    this.eNO.uN().setQuickInputPanelVisible(false);
                }
                if (this.eOm != null) {
                    this.eOm.setVisibility(8);
                }
                if (this.eMS != null) {
                    this.eMS.setVisible(8);
                }
                if (this.eNP != null) {
                    this.eNP.uU();
                }
                if (this.eOl != null) {
                    this.eOl.setCanVisible(false);
                }
            } else {
                bgK();
            }
            if (this.eNO != null && this.eMZ != null) {
                int equipmentHeight = (int) ((z ? 0.2f : 0.33f) * BdUtilHelper.getEquipmentHeight(bhE().pageContext.getPageActivity()));
                if (z) {
                    dimensionPixelSize = equipmentHeight + bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64);
                } else {
                    dimensionPixelSize = equipmentHeight + bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
                }
                if (this.eOn.indexOfChild(this.eMZ) != -1 && this.eMZ.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eMZ.getLayoutParams();
                    layoutParams2.height = dimensionPixelSize;
                    this.eMZ.setLayoutParams(layoutParams2);
                }
                if (this.eMZ.indexOfChild(this.eNO.uM().getView()) != -1 && this.eNO.uM().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.eNO.uM().getView().getLayoutParams();
                    layoutParams3.height = dimensionPixelSize;
                    this.eNO.uM().getView().setLayoutParams(layoutParams3);
                }
                this.eNO.uM().uL();
            }
        }
    }

    private void bgK() {
        if (this.eMP != null) {
            this.eMP.setVisibility(0);
        }
        if (this.eMZ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eMZ.getLayoutParams();
            layoutParams.bottomMargin = bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            this.eMZ.setLayoutParams(layoutParams);
        }
        if (this.eNO != null) {
            bhe();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eNO.uN().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.eNO.uN().getView().setLayoutParams(layoutParams2);
        }
        if (this.eMP != null) {
            this.eMP.setVisibility(0);
        }
        if (this.eNQ != null && this.eNQ.rk() != null) {
            this.eNQ.rk().setVisibility(0);
        }
        if (this.eOm != null && (!this.eNd || UtilHelper.getRealScreenOrientation(bhE().pageContext.getPageActivity()) != 2)) {
            this.eOm.setVisibility(0);
        }
        if (this.eMS != null) {
            this.eMS.setVisible(0);
        }
        if (this.eNP != null) {
            this.eNP.uU();
        }
        if (this.eOl != null) {
            this.eOl.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgL() {
        if (this.eMZ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eMZ.getLayoutParams();
            boolean z = false;
            if (this.eNO != null && this.eNO.uN() != null) {
                z = this.eNO.uN().vQ();
            }
            int iR = iR(z);
            if (layoutParams.bottomMargin != iR) {
                layoutParams.bottomMargin = iR;
                this.eMZ.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iM(boolean z) {
        if (z) {
            this.eNO.uN().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eMZ.getLayoutParams();
            int quickInputPanelExpandHeight = this.eNO.uN().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.eMZ.setLayoutParams(layoutParams);
                if (this.eNO.uM() != null) {
                    this.eNO.uM().uL();
                    return;
                }
                return;
            }
            return;
        }
        bgK();
        onKeyboardVisibilityChanged(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void E(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        RelativeLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = bhE().pageContext.getPageActivity();
        if (i3 == 1) {
            if (this.eOm != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.eOm.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.eMY != null) {
                this.eMY.dismiss();
            }
            if (this.eMX != null) {
                this.eMX.a((j.a) null);
                this.eMX.us();
            }
            if (this.eNA != null) {
                this.eNA.z(true, true);
            }
            if (this.eNb != null) {
                this.eNb.setVisibility(0);
                this.eNb.bringToFront();
            }
            if (this.eNG != null) {
                this.eNG.setVisibility(0);
            }
            if (this.eNO != null && this.eNO.uM().getView().getParent() != null && (this.eNO.uM().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.eNO.uM().getView().getParent()).removeView(this.eNO.uM().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bhE().pageContext.getPageActivity()) * 0.75f);
            int equipmentHeight = ((int) (BdUtilHelper.getEquipmentHeight(bhE().pageContext.getPageActivity()) * 0.33f)) + bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
            if (this.eMZ != null && this.eNO != null) {
                this.eMZ.addView(this.eNO.uM().getView(), new FrameLayout.LayoutParams(equipmentWidth, equipmentHeight));
            }
            if (this.eNa != null && (this.eNa.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.eNa.getParent()).removeView(this.eNa);
            }
            if (this.eNP != null) {
                this.eNP.a(bhE().eWr.ww(), false);
                this.eNP.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.14
                    @Override // com.baidu.live.im.j.a
                    public void uV() {
                        a.this.bhp();
                    }
                });
                View uT = this.eNP.uT();
                if (uT != null && this.eOn != null && uT.getParent() == null) {
                    Resources resources = bhE().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bhE().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds80));
                    layoutParams5.addRule(2, a.g.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                    this.eOn.addView(uT, layoutParams5);
                }
            }
            if (this.eNI != null) {
                this.eNI.setPraiseEnable(true);
                bhE().eWs.fkh = true;
            }
            if (this.eML != null && this.eML.ePx != null && (layoutParams3 = (RelativeLayout.LayoutParams) this.eML.ePx.getLayoutParams()) != null) {
                this.eML.ePx.setPadding(0, 0, 0, 0);
                this.eML.ePx.setLayoutParams(layoutParams3);
            }
            if (this.eNK != null) {
                this.eNK.bpP();
            }
            if (this.eNd) {
                iH(true);
            }
            if (this.eNe) {
                if (this.eMP != null && this.eMP.getLandscapeBarrageImageView() != null) {
                    b(this.eMP.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.eMQ != null) {
                this.eMQ.jd(true);
            }
            this.eNf.removeCallbacksAndMessages(null);
            if (this.eMR != null) {
                this.eMR.setCanVisible(true);
                this.eMR.o(bhE().eWr.ww());
            }
        } else if (i3 == 2) {
            if (this.eNK != null) {
                this.eNK.bpQ();
            }
            if (this.eOm != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.eOm.getLayoutParams()) != null) {
                layoutParams2.topMargin = bhE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
            }
            if (this.eNP != null) {
                this.eNP.a((j.a) null);
                this.eNP.us();
            }
            bhE().eWs.bpu();
            if (this.eNA != null) {
                this.eNA.z(false, true);
            }
            if (this.eNb != null) {
                this.eNb.setVisibility(4);
            }
            if (this.eNO != null && this.eNO.uM().getView().getParent() != null && (this.eNO.uM().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.eNO.uM().getView().getParent()).removeView(this.eNO.uM().getView());
            }
            int max = Math.max(i, i2);
            if (this.eNa != null) {
                if (this.eNa.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eNa.getParent()).removeView(this.eNa);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
                bhE().eWs.addView(this.eNa, layoutParams6);
            }
            if (this.eNa != null && this.eMX != null) {
                this.eMX.a(bhE().eWr.ww(), false);
                this.eMX.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.15
                    @Override // com.baidu.live.im.j.a
                    public void uV() {
                        a.this.bhp();
                    }
                });
                View uT2 = this.eMX.uT();
                if (uT2 != null && this.eNa.indexOfChild(uT2) < 0) {
                    this.eNa.addView(uT2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bhE().pageContext.getPageActivity()), -1));
                }
            }
            if (this.eNI != null) {
                this.eNI.ak(bhE().eWs);
                this.eNI.setPraiseEnable(false);
                bhE().eWs.fkh = false;
            }
            if (this.eML != null && this.eML.ePx != null && (layoutParams = (RelativeLayout.LayoutParams) this.eML.ePx.getLayoutParams()) != null) {
                int width = this.eML.ePx.getWidth();
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                this.eML.ePx.setPadding(width - ((int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f)), 0, 0, 0);
                this.eML.ePx.setLayoutParams(layoutParams);
            }
            if (this.eMQ != null) {
                this.eMQ.jd(false);
            }
            com.baidu.tieba.ala.liveroom.yuangift.a.bpM().xe();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.u.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.u.c) runTask.getData()).xe();
            }
            if (this.eMP != null && this.eMP.getLandscapeBarrageImageView() != null) {
                b(this.eMP.getLandscapeBarrageImageView(), this.eNe, false);
            }
            this.eNf.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.16
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.eNd) {
                        a.this.iH(false);
                    }
                }
            }, 5000L);
            if (this.eNQ != null) {
                this.eNQ.rm();
            }
            if (this.eMR != null) {
                this.eMR.setCanVisible(false);
                this.eMR.bkq();
            }
        }
        if (this.eNR != null) {
            if (i3 == 2) {
                View rB = this.eNR.rB();
                if (rB != null) {
                    if (rB.getParent() != null && (rB.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) rB.getParent()).removeView(rB);
                    }
                    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams7.addRule(5, a.g.ala_liveroom_hostheader);
                    layoutParams7.addRule(3, a.g.ala_liveroom_hostheader);
                    layoutParams7.topMargin = bhE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                    if (this.eOm != null) {
                        this.eOm.addView(rB, layoutParams7);
                    }
                }
            } else {
                View rB2 = this.eNR.rB();
                if (rB2 != null) {
                    if (rB2.getParent() != null && (rB2.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) rB2.getParent()).removeView(rB2);
                    }
                    RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams8.topMargin = bhE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds4);
                    layoutParams8.addRule(3, a.g.ala_live_header_view);
                    bhE().eWs.addView(rB2, layoutParams8);
                }
            }
        }
        if (this.eMP != null) {
            this.eMP.E(i, i2, i3);
        }
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.eML != null) {
                this.eML.bN(i3);
            }
            if (this.eMN != null) {
                this.eMN.bN(i3);
            }
            pK(i3);
            if (this.eMS != null) {
                this.eMS.bN(i3);
            }
            if (this.eNW != null) {
                this.eNW.bN(i3);
            }
            if (this.eOd != null) {
                this.eOd.bN(i3);
            }
            if (this.eNg != null && this.eNg.isShowing()) {
                this.eNg.resize();
            }
            if (this.eOl != null) {
                this.eOl.bN(i3);
            }
        }
        if (this.eNQ != null) {
            this.eNQ.rl();
        }
        super.E(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.tieba.ala.liveroom.b
    public boolean pr(int i) {
        boolean pr = super.pr(i);
        if (pr && 2 == i) {
            if (this.eMM.bgH()) {
                return false;
            }
            if (pr && this.eNK != null) {
                this.eNK.jP(false);
            }
        }
        return pr;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void pJ(int i) {
        super.pJ(i);
        if (i == 7 || i == 11) {
            if (i != 7 || UtilHelper.getRealScreenOrientation(bhE().pageContext.getPageActivity()) != 2) {
                if (this.eMP != null) {
                    this.eMP.setVisibility(8);
                }
                if (this.eNO != null) {
                    this.eNO.uM().getView().setVisibility(4);
                }
                if (this.eOe != null) {
                    this.eOe.jK(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.tieba.ala.liveroom.b
    public void ps(int i) {
        super.ps(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.tieba.ala.liveroom.b
    public void pt(int i) {
        super.pt(i);
        if (i == 7 || i == 11) {
            if (this.eMP != null) {
                this.eMP.setVisibility(0);
            }
            if (this.eNO != null) {
                this.eNO.uM().getView().setVisibility(0);
            }
            if (this.eOe != null) {
                this.eOe.jK(true);
            }
            if (!this.eNd || UtilHelper.getRealScreenOrientation(bhE().pageContext.getPageActivity()) != 2) {
                this.eOm.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void bgM() {
        super.bgM();
        if (this.eMO != null) {
            this.eMO.boF();
        }
        if (this.eMU != null) {
            this.eMU.pj();
        }
        if (this.eMS != null) {
            this.eMS.onStop();
        }
        if (bhE() != null) {
            BdUtilHelper.hideSoftKeyPad(bhE().pageContext.getPageActivity(), bhE().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void bgN() {
        super.bgN();
        if (this.eMO != null) {
            this.eMO.boE();
        }
        if (this.eMU != null) {
            this.eMU.pk();
        }
        if (this.eMS != null) {
            this.eMS.onStart();
        }
    }

    private void pK(int i) {
        if (this.eMJ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eMJ.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.bottomMargin = bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
                layoutParams.height = bgg();
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds72) + 0 + bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds22) + bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                layoutParams.rightMargin = bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
                layoutParams.height = -2;
            }
            this.eMJ.setLayoutParams(layoutParams);
        }
    }
}
