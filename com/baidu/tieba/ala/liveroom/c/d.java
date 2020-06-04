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
import com.baidu.ala.AlaCmdConfigHttp;
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
import com.baidu.live.challenge.h;
import com.baidu.live.challenge.i;
import com.baidu.live.challenge.j;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.ad;
import com.baidu.live.data.ak;
import com.baidu.live.data.al;
import com.baidu.live.data.ax;
import com.baidu.live.data.bg;
import com.baidu.live.data.bm;
import com.baidu.live.data.k;
import com.baidu.live.data.o;
import com.baidu.live.data.q;
import com.baidu.live.gift.n;
import com.baidu.live.gift.z;
import com.baidu.live.guardclub.e;
import com.baidu.live.im.k;
import com.baidu.live.im.m;
import com.baidu.live.message.GetQuickGiftHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
import com.baidu.live.tbadk.core.atomdata.CommonWebViewActivityConfig;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.ILiveGoodsLogger;
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
import com.baidu.live.u.a;
import com.baidu.live.view.dispatch.DispatchedPvlLayout;
import com.baidu.live.view.dispatch.DispatchedRelativeLayout;
import com.baidu.tieba.ala.liveroom.guide.a;
import com.baidu.tieba.ala.liveroom.h.b;
import com.baidu.tieba.ala.liveroom.h.g;
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.recommend.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends b {
    private boolean fJn;
    private com.baidu.tieba.ala.liveroom.h.b fKC;
    private LinearLayout fKg;
    private com.baidu.tieba.ala.liveroom.audiencelist.c fKh;
    private com.baidu.tieba.ala.liveroom.l.a fKi;
    private com.baidu.tieba.ala.liveroom.e.b fKj;
    private com.baidu.tieba.ala.liveroom.r.b fKk;
    private com.baidu.tieba.ala.liveroom.audiencelist.b fKl;
    private com.baidu.tieba.ala.liveroom.j.a fKm;
    private com.baidu.tieba.ala.liveroom.activeview.b fKn;
    private com.baidu.live.d.a fKo;
    private j fKp;
    private i fKq;
    private com.baidu.tieba.ala.liveroom.attentionpop.b fKr;
    private FrameLayout fKu;
    private View fMA;
    private DispatchedRelativeLayout fMB;
    private f fMC;
    private DispatchedPvlLayout fMz;
    private long lastClickTime = 0;
    private boolean fMD = false;
    private HttpRule fKD = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.fKp != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.fKp.vC()) {
                httpMessage.addParam("ala_challenge_id", d.this.fKp.vF());
            }
            return httpMessage;
        }
    };
    private HttpRule fKE = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.c.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.fKp != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.fKp.vC()) {
                httpMessage.addParam("challenge_id", d.this.fKp.vF());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c fKF = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.c.d.18
        @Override // com.baidu.live.liveroom.g.c
        public void Fi() {
            if (d.this.fLg != null) {
                d.this.fLg.lu(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bT(boolean z) {
            if (z) {
                if (d.this.fKW != null) {
                    d.this.fKW.rx(8);
                }
                if (d.this.fLg != null) {
                    d.this.fLg.lu(true);
                }
            } else {
                if (d.this.fKW != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                        d.this.fKW.rx(0);
                    } else {
                        d.this.fKW.rx(8);
                    }
                }
                if (d.this.fLg != null) {
                    d.this.fLg.lu(false);
                }
            }
            if (d.this.fLx != null) {
                d.this.fLx.be(z);
            }
        }
    };
    private HttpMessageListener fKG = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.d.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Fs() != null) {
                        com.baidu.live.v.c.Gj().aYX = getQuickGiftHttpResponseMessage.Fs();
                        d.this.bxU();
                    }
                }
            }
        }
    };
    private CustomMessageListener fKH = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.byf();
        }
    };
    CustomMessageListener fKM = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.c.d.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.fKC.c(d.this.bzh());
                } else if (d.this.byz() || !g.qY(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.22.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, 3000L);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.bzh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.bzh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    d.this.fKC.b(d.this.fKu, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener fME = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.c.d.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.byz() || !g.qY(2913128)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.23.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.qW(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, 3000L);
                } else {
                    d.this.Ck(str);
                }
            }
        }
    };
    private CustomMessageListener fKI = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.c.d.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.fLn.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fKJ = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.c.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.this.fLB != null) {
                    d.this.fLB.Cm(str);
                }
            }
        }
    };
    CustomMessageListener fKK = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.c.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.fLQ != null && d.this.fLQ.aOG != null && !d.this.fLQ.aOJ && !d.this.fLQ.aOK && d.this.fLw != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.bzh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = d.this.bzh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                d.this.fLw.b(d.this.fKu, layoutParams);
                if (e.BG() != null) {
                    e.BG().BM();
                }
            }
        }
    };
    private CustomMessageListener fKL = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.fLz != null) {
                    d.this.fLz.dismiss();
                }
                if (d.this.fLB != null) {
                    d.this.fLB.dismiss();
                }
                m.CL().setSwitchStatus(true);
                m.CL().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.byG();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b fKN = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.d.14
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void l(View view, int i) {
            ax axVar;
            bg bgVar;
            bm bmVar;
            String str;
            ax axVar2;
            bg bgVar2;
            String str2;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - d.this.lastClickTime >= 300) {
                d.this.lastClickTime = currentTimeMillis;
                if (i == 2) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel"));
                    d.this.L(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.v.c.Gj().aYX.yi().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.v.c.Gj().aYX.yi().xl());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.v.c.Gj().aYX.yi().xm());
                        if (d.this.bzh().fTm.Fk() != null && d.this.bzh().fTm.Fk().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.bzh().fTm.Fk().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.bzh().fTm.Fk().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.DN());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.AP()) {
                        if (com.baidu.live.c.uN().getBoolean("quick_gift_guide_show", true) && !d.this.byz()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, z.class, d.this.bzh().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                z zVar = (z) runTask.getData();
                                zVar.setPageContext(d.this.bzh().pageContext);
                                zVar.d(d.this.bzh().fTm.Fk());
                                zVar.setGiftItem(com.baidu.live.v.c.Gj().aYX.yi());
                                zVar.setOtherParams(d.this.DN());
                                zVar.initView();
                                zVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.d.14.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        d.this.ks(false);
                                    }
                                });
                                zVar.show();
                                d.this.ks(true);
                                return;
                            }
                            return;
                        }
                        n.a(d.this.bzh().pageContext, d.this.bzh().fTm.Fk(), com.baidu.live.v.c.Gj().aYX.yi(), d.this.DN());
                    }
                } else if (i == 1) {
                    if (d.this.fLk != null) {
                        d.this.byG();
                    }
                } else if (i == 3 && d.this.AP()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    d.this.fKZ.c(d.this.bzh().fTm.Fk(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.bzh() != null && d.this.bzh().fTm != null && d.this.bzh().fTm.Fk() != null && d.this.bzh().fTm.Fk().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.bzh().fTm.Fk().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.bzh().fTm.Fk().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.bzh().fTm.Fk().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.DN());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.bzh() != null && d.this.bzh().fTm != null && d.this.bzh().fTm.Fk() != null && d.this.bzh().fTm.Fk().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.bzh().fTm.Fk().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.bzh().fTm.Fk().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.bzh().fTm.Fk().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.DN());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.aWi != null) {
                        d.this.aWi.bO(false);
                    }
                } else if (i == 12) {
                    if (d.this.fLg != null && d.this.bzh().fTm.Fk() != null && d.this.bzh().fTm.Fk().mLiveInfo != null) {
                        String valueOf = String.valueOf(d.this.bzh().fTm.Fk().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.bzh().fTm.Fk().mLiveInfo.room_id);
                        String str3 = null;
                        o oVar = d.this.bzh().fTm.Fk().mLiveSdkInfo;
                        if (oVar != null && oVar.mCastIds != null) {
                            str3 = String.valueOf(d.this.bzh().fTm.Fk().mLiveSdkInfo.mCastIds.avv);
                        }
                        d.this.fLg.ag(valueOf, valueOf2, str3);
                        if (com.baidu.live.liveroom.a.EI().EJ()) {
                            d.this.byf();
                        }
                    }
                } else if (i == 14) {
                    q Fk = d.this.bzh().fTm.Fk();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.bzh().pageContext.getPageActivity(), Fk.avj.userName, Long.toString(Fk.avj.userId), Long.toString(Fk.avj.charmCount), String.valueOf(Fk.mLiveInfo.group_id), String.valueOf(Fk.mLiveInfo.live_id), false, String.valueOf(Fk.avj.userId), Long.toString(Fk.avC.userId), Fk.avC.userName, Fk.avC.portrait, d.this.fKl.getCount(), d.this.DN())));
                    LogManager.getCommonLogger().doClickGusetNumLog(Fk.mLiveInfo.feed_id, d.this.fKl.getCount() + "", d.this.DN());
                } else if (i == 11) {
                    d.this.byJ();
                    d.this.byK();
                } else if (i == 15) {
                    if (d.this.fLu != null && d.this.bzh() != null && d.this.bzh().fTm != null && d.this.bzh().fTm.Fk() != null && d.this.bzh().fTm.Fk().mLiveInfo != null) {
                        long j = d.this.bzh().fTm.Fk().mLiveInfo.live_id;
                        String valueOf3 = String.valueOf(d.this.bzh().fTm.Fk().mLiveInfo.feed_id);
                        long j2 = d.this.bzh().fTm.Fk().mLiveInfo.room_id;
                        String str4 = d.this.bzh().fTm.Fk().mLiveInfo.cover;
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        String str8 = "";
                        if (d.this.bzh().fTm.Fk().mLiveInfo.session_info != null) {
                            str5 = d.this.bzh().fTm.Fk().mLiveInfo.session_info.flvUrl;
                        }
                        if (!TextUtils.isEmpty(d.this.DN())) {
                            try {
                                JSONObject jSONObject = new JSONObject(d.this.DN());
                                str6 = jSONObject.optString("tab");
                                str7 = jSONObject.optString("tag");
                                str8 = jSONObject.optString("source");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        d.this.fLu.Cm(com.baidu.live.utils.o.a(valueOf3, j + "", j2, false, 1, str4, str5, str6, str7, str8, String.valueOf(d.this.bzh().fTm.Fk().avC.userId), d.this.bzh().fTm.Fk().avC.userName, String.valueOf(d.this.bzh().fTm.Fk().mLiveInfo.group_id), String.valueOf(d.this.bzh().fTm.Fk().avj.userId)));
                        com.baidu.live.utils.o.bfr = j;
                        if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                            ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                            LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf3, d.this.DN());
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "shopcart_clk"));
                    }
                } else if (i == 16) {
                    if (d.this.bzh() != null && (axVar2 = com.baidu.live.v.a.Ge().aYP) != null && (bgVar2 = axVar2.aAI) != null) {
                        String str9 = bgVar2.aBF.aBM;
                        if (!TextUtils.isEmpty(str9)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j3 = 0;
                            if (d.this.bzh().fTm != null && d.this.bzh().fTm.Fk() != null && d.this.bzh().fTm.Fk().mLiveInfo != null) {
                                j3 = d.this.bzh().fTm.Fk().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j3 + "", d.this.bzh().fTm.Fk().mLiveInfo.room_id + "", d.this.bzh().fTm.Fk().mLiveInfo.feed_id, d.this.DN());
                            }
                            if (str9.contains("?")) {
                                str2 = str9 + "&liveId=" + j3;
                            } else {
                                str2 = str9 + "?liveId=" + j3;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.bzh().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (d.this.bzh() != null) {
                        q qVar = null;
                        if (d.this.bzh().fTm != null) {
                            qVar = d.this.bzh().fTm.Fk();
                        }
                        if (qVar != null && qVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.t.a.bGm().aWQ != null) {
                            String str10 = com.baidu.tieba.ala.liveroom.t.a.bGm().aWQ.auL;
                            if (!TextUtils.isEmpty(str10)) {
                                if (str10.contains("?")) {
                                    str = str10 + "&live_id=" + qVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str10 + "?live_id=" + qVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(d.this.bzh().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17 && d.this.AP() && d.this.bzh() != null && (axVar = com.baidu.live.v.a.Ge().aYP) != null && (bgVar = axVar.aAI) != null && (bmVar = bgVar.aBG) != null && !TextUtils.isEmpty(bmVar.webUrl)) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                    if (d.this.fLz != null && d.this.bzh().fTm != null && d.this.bzh().fTm.Fk() != null) {
                        q Fk2 = d.this.bzh().fTm.Fk();
                        d.this.fLz.a(bmVar.webUrl, Fk2.mLiveInfo.live_id, Fk2.avC.userId, Fk2.avj.userId);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.fLb = new com.baidu.tieba.ala.liveroom.guide.c(bzh().pageContext, this, false);
        this.fKD.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.fKD);
        this.fKE.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.fKE);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean bxE() {
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void k(q qVar) {
        super.k(qVar);
        g.bBw();
        this.fMD = true;
        bzh().fTn.setIsForceHandledTouch(false);
        bzh().fTn.setSwipeClearEnable(true);
        bzh().fTn.setOnLiveViewScrollListener(this.fKF);
        if (this.fLe != null) {
            this.fLe.b(this.fKN);
        }
        if (this.fLJ != null) {
            this.fLJ.setVisibility(0);
        }
        bxJ();
        bxM();
        bxX();
        byv();
        bxY();
        byc();
        bxZ();
        kn(false);
        byN();
        byM();
        bxO();
        bxV();
        byP();
        bye();
        byg();
        kA(true);
        bzr();
        bzs();
        kt(false);
        byY();
        bxN();
        bxU();
        bxP();
        bxQ();
        bxR();
        bxS();
        byU();
        bxF();
        ky(true);
        byX();
        MessageManager.getInstance().registerListener(this.fKG);
        MessageManager.getInstance().registerListener(this.fKH);
        MessageManager.getInstance().registerListener(this.fKI);
        MessageManager.getInstance().registerListener(this.fKK);
        MessageManager.getInstance().registerListener(this.fKL);
        MessageManager.getInstance().registerListener(this.fME);
        MessageManager.getInstance().registerListener(this.fKM);
        MessageManager.getInstance().registerListener(this.fKJ);
        byi();
        byb();
        if (this.fJn) {
            kB(this.fJn);
            kC(this.fJn);
        }
    }

    private void bxF() {
        if (this.fLG != null) {
            this.fLG.a(new a.InterfaceC0569a() { // from class: com.baidu.tieba.ala.liveroom.c.d.19
                @Override // com.baidu.tieba.ala.liveroom.recommend.a.InterfaceC0569a
                public void kq(boolean z) {
                    if (d.this.fKq != null) {
                        d.this.fKq.setNeedCloseRecommendFloat(z);
                    }
                    if (d.this.bzh().fTn.ghf) {
                        if (d.this.fLg != null) {
                            d.this.fLg.lm(z);
                            d.this.fLg.lu(!z);
                        }
                        if (d.this.fLe != null) {
                            d.this.fLe.lm(z);
                            d.this.fLe.setPraiseEnable(!z);
                            d.this.fLe.ll(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void i(q qVar) {
        super.i(qVar);
        if (this.fKi != null) {
            this.fKi.t(qVar);
        }
        if (this.fKj != null) {
            this.fKj.p(qVar);
        }
        if (this.fKm != null) {
            this.fKm.s(qVar);
        }
        if (this.fKq != null) {
            this.fKq.a(qVar);
        }
        kA(false);
        ky(false);
        if (this.fKn != null) {
            this.fKn.h(qVar);
            this.fKn.kj(this.fLT);
            this.fKn.updateView();
            if (qVar != null && this.fLH != null && !this.fLH.hasInit && !TextUtils.isEmpty(this.fLH.aBc)) {
                this.fLH.hasInit = true;
                this.fKn.Cg(this.fLH.aBc);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(k kVar) {
        if (kVar != null) {
            if (this.fKh != null && kVar.getList() != null) {
                this.fKh.e(kVar);
            }
            if (this.fKl != null) {
                this.fKl.dm(kVar.getCount());
            }
        }
    }

    private void bxH() {
        if (this.fLf != null) {
            this.fLf.ar(bzh().fTl.getLiveContainerView());
        }
    }

    private void bzr() {
        if (this.fKr == null) {
            this.fKr = new com.baidu.tieba.ala.liveroom.attentionpop.b(bzh().pageContext);
        }
        if (bzh().fTm != null && bzh().fTm.Fk() != null && bzh().fTm.Fk().mLiveInfo != null) {
            this.fKr.Ch(String.valueOf(bzh().fTm.Fk().mLiveInfo.user_id));
        }
    }

    private void bzs() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (bzh() != null && bzh().fTm != null && bzh().fTm.Fk() != null && bzh().fTm.Fk().mLiveInfo != null) {
                j = bzh().fTm.Fk().mLiveInfo.room_id;
            }
            if (this.fLs == null) {
                this.fLs = new com.baidu.tieba.ala.liveroom.guide.a(bzh().pageContext, j);
            }
            this.fLs.kr(this.fLM);
            this.fLs.a(new a.InterfaceC0562a() { // from class: com.baidu.tieba.ala.liveroom.c.d.5
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0562a
                public void bzw() {
                    if (d.this.aWi != null) {
                        d.this.aWi.bO(true);
                    }
                }
            });
            this.fLs.ao(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bG(int i) {
        super.bG(i);
        bxH();
        if (this.fKq != null) {
            this.fKq.bG(i);
        }
    }

    private void bxJ() {
        if (this.fMB == null) {
            this.fMB = new DispatchedRelativeLayout(bzh().pageContext.getPageActivity());
            this.fMB.setViewActionDispatched(false);
            this.fMB.setViewActionDispatchListener(new com.baidu.live.view.dispatch.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.6
                @Override // com.baidu.live.view.dispatch.a
                public boolean X(View view) {
                    return (d.this.fMz == null || d.this.fMz.Jx() || view == null || !(view.getTag(a.g.sdk_pvl_layout_priority_tag_key) instanceof Integer)) ? false : true;
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewAdded(View view) {
                    view.setTag(a.g.ala_live_room_vertival_widgets_bk_lp_key, view.getLayoutParams());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(view.getLayoutParams().width, view.getLayoutParams().height);
                    layoutParams.gravity = 5;
                    view.setLayoutParams(layoutParams);
                    if (d.this.fMz != null) {
                        d.this.fMz.addView(view);
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewRemoved(View view) {
                    if (d.this.fMz != null) {
                        d.this.fMz.removeView(view);
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public void Jz() {
                    if (d.this.fMz != null && !d.this.fMz.Jx()) {
                        d.this.fMz.removeAllViews();
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public int indexOfChild(View view) {
                    if (d.this.fMz != null) {
                        return d.this.fMz.indexOfChild(view);
                    }
                    return 0;
                }
            });
        }
        if (this.fMB.getParent() == null) {
            bzh().fTn.addView(this.fMB, kD(false));
        }
        if (this.fMz == null) {
            this.fMz = new DispatchedPvlLayout(bzh().pageContext.getPageActivity());
            this.fMz.setDefaultItemMargin(bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.fMz.setViewActionDispatched(false);
            this.fMz.setViewActionDispatchListener(new com.baidu.live.view.dispatch.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.7
                @Override // com.baidu.live.view.dispatch.a
                public boolean X(View view) {
                    return (d.this.fMB == null || d.this.fMB.Jx() || view == null || !(view.getTag(a.g.ala_live_room_vertival_widgets_bk_lp_key) instanceof ViewGroup.LayoutParams)) ? false : true;
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewAdded(View view) {
                    view.setLayoutParams(new LinearLayout.LayoutParams(view.getLayoutParams().width, view.getLayoutParams().height));
                    d.this.fMB.addView(view, (ViewGroup.LayoutParams) view.getTag(a.g.ala_live_room_vertival_widgets_bk_lp_key));
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewRemoved(View view) {
                    d.this.fMB.removeView(view);
                }

                @Override // com.baidu.live.view.dispatch.a
                public void Jz() {
                    if (d.this.fMB != null && !d.this.fMB.Jx()) {
                        d.this.fMB.removeAllViews();
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public int indexOfChild(View view) {
                    return d.this.fMB.indexOfChild(view);
                }
            });
        }
        if (this.fMz.getParent() == null) {
            bzh().fTn.addView(this.fMz, bzv());
        }
    }

    private void bxL() {
        if (this.fMA == null) {
            this.fMA = new View(bzh().pageContext.getPageActivity());
            this.fMA.setTag(a.g.sdk_pvl_layout_priority_tag_key, 20);
        }
        if (this.fMA.getParent() == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(1, 0);
            layoutParams.weight = 1.0f;
            this.fMz.addView(this.fMA, layoutParams);
        }
    }

    private void bzt() {
        if (this.fMA != null) {
            this.fMz.removeView(this.fMA);
        }
    }

    private void bxM() {
        if (this.fKg == null) {
            this.fKg = new LinearLayout(bzh().pageContext.getPageActivity());
            this.fKg.setOrientation(1);
        }
        if (this.fKg.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds160);
            layoutParams.leftMargin = bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bzh().fTn.addView(this.fKg, layoutParams);
        }
    }

    private void bxO() {
        if (this.fLd != null && bzh() != null && bzh().fTm != null) {
            this.fLd.b(this.fLJ, bzh().fTm.Fk());
        }
    }

    private void bxN() {
        if (this.fKn == null) {
            this.fKn = new com.baidu.tieba.ala.liveroom.activeview.b(bzh().pageContext);
        }
        this.fKn.ki(this.fJn);
        this.fKn.setOtherParams(DN());
        this.fKn.b(bzh().fTm.Fk(), false);
        this.fKn.setHost(false);
        this.fKn.kj(this.fLT);
        this.fKn.a(1, this.fKg, qP(1));
        this.fKn.a(2, this.fMz, qP(2));
        this.fKn.setVisible(this.fLN ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxU() {
        if (this.fKW == null) {
            bxZ();
        }
        this.fKW.setOtherParams(DN());
        this.fKW.a(com.baidu.live.v.c.Gj().aYX, bzh().fTm.Fk());
    }

    private ViewGroup.LayoutParams qP(int i) {
        switch (i) {
            case 1:
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (this.fKg == null || this.fKg.getChildCount() == 0) {
                    return layoutParams;
                }
                layoutParams.topMargin = bzh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                return layoutParams;
            case 2:
                ViewGroup.LayoutParams layoutParams2 = this.fMB.getLayoutParams();
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(((int) (BdUtilHelper.getEquipmentWidth(bzh().pageContext.getPageActivity()) * 0.25f)) - ((layoutParams2 instanceof LinearLayout.LayoutParams ? ((LinearLayout.LayoutParams) layoutParams2).rightMargin : 0) * 2), -2);
                layoutParams3.gravity = 5;
                return layoutParams3;
            default:
                return new RelativeLayout.LayoutParams(-2, -2);
        }
    }

    private void bxP() {
        if (this.fKm == null) {
            this.fKm = new com.baidu.tieba.ala.liveroom.j.a(bzh().pageContext, this);
        }
        this.fKm.setOtherParams(DN());
        this.fKm.d(this.fMB, bxT());
        this.fKm.s(bzh().fTm.Fk());
    }

    private void bxQ() {
        if (this.fLw == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, com.baidu.live.guardclub.j.class, bzh().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.fLw = (com.baidu.live.guardclub.j) runTask.getData();
            } else {
                return;
            }
        }
        this.fLw.setOtherParams(DN());
        if (this.fKu != null && this.fKu.indexOfChild(this.fLw.getView()) >= 0) {
            this.fKu.removeView(this.fLw.getView());
        }
    }

    private void bxR() {
        if (this.fKW != null) {
            this.fKW.a(new a.InterfaceC0568a() { // from class: com.baidu.tieba.ala.liveroom.c.d.8
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0568a
                public void bv(int i, int i2) {
                    q Fk = d.this.bzh().fTm.Fk();
                    if (Fk != null && Fk.mLiveInfo != null) {
                        if (d.this.fLA == null) {
                            d.this.fLA = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.bzh().pageContext.getPageActivity());
                        }
                        d.this.fLA.d(d.this.fLK, i, i2);
                        d.this.fLA.a(String.valueOf(Fk.mLiveInfo.live_id), new a.InterfaceC0574a() { // from class: com.baidu.tieba.ala.liveroom.c.d.8.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0574a
                            public void a(float f, String str) {
                                if (d.this.fKW != null) {
                                    d.this.fKW.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0568a
                public void bw(int i, int i2) {
                    if (d.this.fLA != null) {
                        d.this.fLA.bB(i, i2);
                    }
                }
            });
        }
    }

    private void bxS() {
        if (this.fLY == null) {
            this.fLY = new com.baidu.tieba.ala.liveroom.h.e(bzh().pageContext);
        }
        this.fLY.setRoomId(bzh().fTm.Fk().mLiveInfo.room_id);
        this.fLY.Cu("");
        this.fLY.a(bzh().fTm.Fk(), this.fMz);
        if (this.fKC == null) {
            this.fKC = new com.baidu.tieba.ala.liveroom.h.b(bzh().pageContext, DN(), this.fLY, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.9
                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void byr() {
                    d.this.ks(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void bys() {
                    d.this.ks(false);
                }
            });
        }
        this.fKC.setRoomId(bzh().fTm.Fk().mLiveInfo.room_id);
        if (this.fKu != null && this.fKu.indexOfChild(this.fKC.getView()) >= 0) {
            this.fKu.removeView(this.fKC.getView());
        }
        if (this.fKC != null) {
            this.fKC.b(bzh());
        }
    }

    private ViewGroup.LayoutParams bxT() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.topMargin = (ScreenHelper.getRealScreenHeight(bzh().pageContext.getPageActivity()) - this.fMB.getTop()) - bzh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds814);
        return layoutParams;
    }

    private void bxV() {
        CustomResponsedMessage runTask;
        if (this.fLk == null && (runTask = MessageManager.getInstance().runTask(2913039, com.baidu.live.im.k.class, bzh().pageContext)) != null && runTask.getData() != null) {
            this.fLk = (com.baidu.live.im.k) runTask.getData();
            this.fLk.setFromMaster(false);
            this.fLk.CA().getView().setId(a.g.ala_liveroom_msg_list);
            this.fLk.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.10
                @Override // com.baidu.live.im.k.a
                public boolean CC() {
                    return d.this.AP();
                }

                @Override // com.baidu.live.im.k.a
                public void CD() {
                    d.this.fLR = true;
                }

                @Override // com.baidu.live.im.k.a
                public void fq(String str) {
                    if (!d.this.fLN) {
                        d.this.kp(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.bzh().pageContext.getPageActivity(), d.this.bzh().fTl.getLiveContainerView());
                    }
                    d.this.Cj(str);
                }

                @Override // com.baidu.live.im.k.a
                public void CE() {
                    if (d.this.fLN) {
                        d.this.kp(true);
                        d.this.bzh().fTl.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.bzh().pageContext.getPageActivity(), d.this.bzh().fTl.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.fLk != null) {
                        d.this.fLk.CB().setQuickInputPanelVisible(false);
                        d.this.fLk.CB().Ek();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void CF() {
                    if (d.this.fLN) {
                        d.this.byq();
                        if (d.this.fLl != null) {
                            d.this.fLl.CJ();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean CG() {
                    return d.this.byA();
                }

                @Override // com.baidu.live.im.k.a
                public int CH() {
                    return d.this.byB();
                }
            });
            this.fKu = new FrameLayout(bzh().pageContext.getPageActivity());
            this.fKu.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.fLk != null && this.fKu != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bzh().pageContext.getPageActivity()) * 0.75f);
            int cm = com.baidu.live.aa.a.cm(false);
            if (this.fLK.indexOfChild(this.fKu) < 0) {
                if (this.fKu.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fKu.getParent()).removeView(this.fKu);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.live.aa.a.h(false, false));
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.live.aa.a.cn(false);
                this.fLK.addView(this.fKu, layoutParams);
            }
            if (this.fKu.indexOfChild(this.fLk.CA().getView()) < 0) {
                if (this.fLk.CA().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fLk.CA().getView()).removeView(this.fLk.CA().getView());
                }
                this.fKu.addView(this.fLk.CA().getView(), new FrameLayout.LayoutParams(equipmentWidth, cm));
            }
            if (bzh().fTn.indexOfChild(this.fLk.CB().getView()) < 0) {
                if (this.fLk.CB().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fLk.CB().getView().getParent()).removeView(this.fLk.CB().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                byH();
                bzh().fTn.addView(this.fLk.CB().getView(), layoutParams2);
            }
            q Fk = bzh().fTm.Fk();
            if (Fk != null && Fk.mLiveInfo != null) {
                this.fLk.setLogData(Fk.mLiveInfo.feed_id, DN());
            }
            this.fLk.a(String.valueOf(bzh().fTm.Fk().mLiveInfo.group_id), String.valueOf(bzh().fTm.Fk().mLiveInfo.last_msg_id), String.valueOf(bzh().fTm.Fk().avj.userId), String.valueOf(bzh().fTm.Fk().mLiveInfo.live_id), bzh().fTm.Fk().avj.appId, (Fk == null || Fk.avP == null || !Fk.avP.vQ()) ? false : true);
            kp(false);
        }
    }

    private void bxX() {
        if (this.fKi == null) {
            this.fKi = new com.baidu.tieba.ala.liveroom.l.a(bzh().pageContext, false, this);
        }
        this.fKi.c(this.fLJ, bzh().fTm.Fk());
        this.fKi.a(this.fKN);
        this.fKi.setOtherParams(DN());
    }

    private void bxY() {
        if (this.fKh == null) {
            this.fKh = new com.baidu.tieba.ala.liveroom.audiencelist.c(bzh().pageContext, this, false);
        }
        this.fKh.a(String.valueOf(bzh().fTm.Fk().mLiveInfo.group_id), String.valueOf(bzh().fTm.Fk().mLiveInfo.live_id), String.valueOf(bzh().fTm.Fk().avj.userId), bzh().fTm.Fk());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.fKY != null && this.fKY.getView() != null && this.fKY.getView().getParent() != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.fKh.c(this.fLJ, i, a.g.ala_liveroom_audience_count_layout);
            this.fKh.e(bzh().fTm.btj());
            this.fKh.setOtherParams(DN());
        }
    }

    private void bxZ() {
        if (this.fKW == null) {
            this.fKW = new com.baidu.tieba.ala.liveroom.operation.a(bzh().pageContext);
        }
        this.fKW.a(bzh(), this.fLK, bzh().fTm.Fk().mLiveInfo.live_type, true, this.fKN);
        this.fKW.setOtherParams(DN());
    }

    public void kx(boolean z) {
        if (this.fKW != null) {
            this.fKW.kx(z);
        }
    }

    private void byc() {
        if (this.fKl == null) {
            this.fKl = new com.baidu.tieba.ala.liveroom.audiencelist.b(bzh().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (bzh().fTm.btj() != null) {
            j = bzh().fTm.btj().getCount();
        }
        this.fKl.a(this.fKN);
        this.fKl.a(this.fLJ, a.g.ala_liveroom_audience, j);
        this.fKl.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.fKl.kF(false);
        } else {
            this.fKl.kF(true);
        }
    }

    protected void Ck(String str) {
        if (this.fLX == null) {
            this.fLX = new com.baidu.tieba.ala.liveroom.q.b(bzh().pageContext);
        }
        this.fLX.b(this.fLK, str);
        ks(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.11
            @Override // java.lang.Runnable
            public void run() {
                d.this.fLX.bFV();
                d.this.ks(false);
            }
        }, 5000L);
    }

    private void ky(boolean z) {
        CustomResponsedMessage runTask;
        if (bzh().fTm.Fk().mLiveInfo.live_type == 1 && this.fMD) {
            if (this.fMC == null && (runTask = MessageManager.getInstance().runTask(2913074, f.class, bzh().pageContext)) != null && runTask.getData() != null) {
                this.fMC = (f) runTask.getData();
            }
            if (this.fMC != null) {
                if (this.fKp == null) {
                    this.fKp = this.fMC.a(bzh().pageContext);
                }
                if (bzh().fTm.Fk().mLiveInfo.challengeId > 0 && !this.fKp.vD()) {
                    this.fKp.e(bzh().fTm.Fk().mLiveInfo.live_id, bzh().fTm.Fk().avj.userId);
                    kz(z);
                    if (z) {
                        this.fKp.a(bzh().fTm.bEH());
                    }
                    this.fKp.c(bzh().fTm.Fk());
                }
            }
        }
    }

    private void kz(boolean z) {
        if (this.fKq == null) {
            this.fKq = this.fMC.b(bzh().pageContext);
            this.fKq.a(new h() { // from class: com.baidu.tieba.ala.liveroom.c.d.13
                @Override // com.baidu.live.challenge.h
                public void vs() {
                    d.this.bzh().fTn.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.h
                public void a(ak akVar, al alVar, al alVar2) {
                    d.this.fJn = true;
                    if (d.this.fLe != null) {
                        d.this.fLe.setPraiseEnable(false);
                        d.this.bzh().fTn.ghf = false;
                    }
                    if (d.this.fKm != null) {
                        d.this.fKm.setCanVisible(false);
                        d.this.fKm.bBC();
                    }
                    if (d.this.fKn != null) {
                        d.this.fKn.ki(true);
                    }
                    if (d.this.fLY != null) {
                        d.this.fLY.setVisible(8);
                    }
                    if (d.this.fKo != null) {
                        d.this.fKo.setCanVisible(false);
                        d.this.fKo.setVisible(8);
                    }
                    d.this.kB(true);
                    d.this.kC(true);
                    if (d.this.bzh().aWl != null) {
                        d.this.bzh().aWl.getLivePlayer().setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                    }
                    if (d.this.fLc != null) {
                        d.this.fLc.setTimeTextMode(true);
                    }
                    if (d.this.aWi != null && alVar != null && alVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(alVar.azA);
                        arrayList.add(alVar2.azA);
                        com.baidu.live.liveroom.a.b bVar = d.this.aWi;
                        if (d.this.fLU) {
                            arrayList = null;
                        }
                        bVar.j(arrayList);
                    }
                }

                @Override // com.baidu.live.challenge.h
                public void vt() {
                }

                @Override // com.baidu.live.challenge.h
                public void vu() {
                }

                @Override // com.baidu.live.challenge.h
                public void aU(boolean z2) {
                    d.this.bzh().fTn.setSwipeClearEnable(true);
                    d.this.fJn = false;
                    if (d.this.fLe != null) {
                        d.this.fLe.setPraiseEnable(true);
                        d.this.bzh().fTn.ghf = true;
                    }
                    if (d.this.fKm != null) {
                        d.this.fKm.setCanVisible(true);
                        d.this.fKm.s(d.this.bzh().fTm.Fk());
                    }
                    if (d.this.fLg != null) {
                        d.this.fLg.lu(true);
                    }
                    if (d.this.fKn != null) {
                        d.this.fKn.ki(false);
                    }
                    if (d.this.fLY != null) {
                        d.this.fLY.setVisible(0);
                    }
                    if (d.this.fKo != null) {
                        d.this.fKo.setCanVisible(true);
                        d.this.fKo.setVisible(0);
                    }
                    d.this.kB(false);
                    d.this.kC(false);
                    if (d.this.aWi != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.bzh().fTm.bFx());
                        com.baidu.live.liveroom.a.b bVar = d.this.aWi;
                        if (d.this.fLU) {
                            arrayList = null;
                        }
                        bVar.j(arrayList);
                    }
                    if (d.this.bzh().aWl != null) {
                        d.this.bzh().aWl.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
                    }
                    if (d.this.fLc != null) {
                        d.this.fLc.setTimeTextMode(false);
                    }
                }

                @Override // com.baidu.live.challenge.h
                public void aV(boolean z2) {
                    if (z2 && d.this.fLG != null) {
                        d.this.fLG.onClose();
                    }
                }
            });
        }
        this.fKq.a(this.fKp);
        this.fKq.j(bzh().fTl.getLiveContainerView());
        this.fKq.b(z, false, false);
        this.fKp.a((j.c) this.fKq);
    }

    private void kA(boolean z) {
        CustomResponsedMessage runTask;
        if (bzh().fTm.Fk().mLiveInfo.live_type == 1 && com.baidu.live.v.a.Ge().aWF.axA) {
            if (this.fKo == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bzh().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.fKo = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.fKo != null) {
                this.fKo.a(bzh().fTm.bFz(), false, false);
                if (bzh().fTm.Fk().mLiveInfo.pkId > 0 && this.fKo.getRootView() != null && this.fKo.getRootView().getParent() == null && this.fMB != null) {
                    if (this.fMB.getChildCount() <= 0) {
                        this.fMB.addView(this.fKo.getRootView(), new LinearLayout.LayoutParams(-2, -2));
                    } else {
                        View childAt = this.fMB.getChildAt(0);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.topMargin = bzh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                        childAt.setLayoutParams(layoutParams);
                        this.fMB.addView(this.fKo.getRootView(), 0, new LinearLayout.LayoutParams(-2, -2));
                    }
                }
                if (z) {
                    this.fKo.a(null, bzh().fTm.Fk());
                } else {
                    this.fKo.b(bzh().fTm.Fk());
                }
            }
        }
    }

    public void byd() {
        this.fKZ.c(bzh().fTm.Fk(), false);
    }

    public void bye() {
        if (bzh().fTm.Fk() != null && bzh().fTm.Fk().avj != null && bzh().fTm.Fk().mLiveInfo != null) {
            if (this.fKk == null) {
                this.fKk = new com.baidu.tieba.ala.liveroom.r.b(bzh().pageContext);
            }
            long j = bzh().fTm.Fk().avj.userId;
            int i = bzh().fTm.Fk().mLiveInfo.live_type;
            String str = bzh().fTm.Fk().avj.portrait;
            String str2 = bzh().fTm.Fk().mLiveInfo.feed_id;
            long j2 = bzh().fTm.Fk().mLiveInfo.live_id;
            this.fKk.a(i, j, bzh().fTm.Fk().avj.userName, false, str, DN(), str2, j2);
            this.fKk.ao(this.fLJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kB(boolean z) {
        if (this.fMz != null && this.fMB != null) {
            if (z) {
                this.fMz.setViewActionDispatched(false);
                this.fMB.setViewActionDispatched(true);
                ViewGroup.LayoutParams layoutParams = this.fMz.getLayoutParams();
                layoutParams.height = bzu();
                this.fMz.setLayoutParams(layoutParams);
                bxL();
                return;
            }
            this.fMB.setViewActionDispatched(false);
            this.fMz.setViewActionDispatched(true);
            ViewGroup.LayoutParams layoutParams2 = this.fMz.getLayoutParams();
            layoutParams2.height = -2;
            this.fMz.setLayoutParams(layoutParams2);
            bzt();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:7:0x0014 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.LinearLayout$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.tieba.ala.liveroom.activeview.b] */
    public void kC(boolean z) {
        if (this.fKn != null) {
            ?? layoutParams = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams) layoutParams).gravity = 5;
            ?? r2 = this.fKn;
            ViewGroup viewGroup = z ? this.fMz : this.fKg;
            if (!z) {
                layoutParams = qP(1);
            }
            r2.a(1, viewGroup, layoutParams, 21);
            this.fKn.updateView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bzu() {
        return (((bzh().fTn.getBottom() - (this.fKq != null ? this.fKq.aW(false) : 0)) - (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0)) - bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byf() {
        if (bzh() == null || bzh().fTm == null || bzh().fTm.Fk() == null || bzh().fTm.Fk().avC == null) {
            if (bzh().fTm == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bzh().fTm.Fk() == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bzh().fTm.Fk().avC == null) {
                Log.i("RenameLog", "getLiveContext().liveModel.getLiveShowData().mLoginUserInfo == null");
                return;
            } else {
                return;
            }
        }
        String str = bzh().fTm.Fk().avC.userName;
        Log.i("RenameLog", "loginUserName:" + str);
        if (str != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bzh().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !byz()) {
            com.baidu.live.c.uN().putInt("guide_rename_show_count", com.baidu.live.c.uN().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.EI().bN(true);
            if (this.fLD == null) {
                this.fLD = new com.baidu.tieba.ala.liveroom.s.a(bzh().pageContext);
            }
            this.fLD.setOtherParams(DN());
            this.fLD.e(this.fLK, bzh().fTm.Fk());
            ks(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.15
                @Override // java.lang.Runnable
                public void run() {
                    d.this.fLD.bGd();
                    d.this.ks(false);
                }
            }, 5000L);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_SHOW);
                alaStaticItem.addParams("other_params", DN());
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    private void byg() {
        boolean z = false;
        if (this.fLg == null) {
            this.fLg = new com.baidu.tieba.ala.liveroom.v.a(bzh().pageContext, this);
        }
        this.fLg.d(bzh().fTn, false);
        if (bzg() && bzh().fTm.Fk().mLiveInfo.screen_direction != 2) {
            z = true;
        }
        this.fLg.lt(z);
    }

    private void byi() {
        if (this.fLR || this.fLS) {
            if ((TbadkCoreApplication.isLogin() && this.fLk.CB().hasText()) || this.fLS) {
                this.fLR = false;
                this.fLS = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.16
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.byG();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void bya() {
        byb();
    }

    private void byb() {
        if (this.fKW != null) {
            int i = bzh().fTm.Fk().avC.isUegBlock;
            int i2 = bzh().fTm.Fk().avC.isBlock;
            String str = bzh().fTm.Fk().avC.userName;
            if (i > 0 || i2 > 0) {
                this.fKW.b(true, i, i2, str);
                this.fLk.a(true, i, i2, str);
                this.fLq.b(true, i, i2, str);
                return;
            }
            this.fKW.b(false, i, i2, str);
            this.fLk.a(false, i, i2, str);
            this.fLq.b(false, i, i2, str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void k(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        super.k(aVar);
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
                if (this.fKm != null) {
                    this.fKm.E(jSONObject);
                }
            } else if ("enter_live".equals(optString)) {
                if (this.fKl != null && this.fKl.getCount() > 20) {
                    this.fKl.dm(this.fKl.getCount() + 1);
                } else if (this.fKh != null) {
                    com.baidu.live.data.a DB = aVar.DB();
                    com.baidu.live.data.j jVar = new com.baidu.live.data.j();
                    jVar.avk = new AlaLocationData();
                    jVar.avl = new AlaRelationData();
                    jVar.avj = new AlaLiveUserInfoData();
                    jVar.avj.userId = JavaTypesHelper.toLong(DB.userId, 0L);
                    jVar.avj.userName = DB.userName;
                    jVar.avj.portrait = DB.portrait;
                    if (this.fKl != null && this.fKh.c(jVar)) {
                        this.fKl.dm(this.fKl.getCount() + 1);
                    }
                }
            } else if ("update_liveinfo".equals(optString) && bzh().fTm.Fk() != null && bzh().fTm.Fk().mLiveInfo != null) {
                bzh().fTm.a(bzh().fTm.Fk().mLiveInfo.live_id, bzh().fromType, bzh().enterTime);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void Cf(String str) {
        if (this.fKn != null) {
            this.fKn.Cf(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void bS(boolean z) {
        super.bS(z);
        if (bzh().fTn != null) {
            bzh().fTn.bGV();
            bzh().fTn.setLiveViewOnDispatchTouchEventListener(null);
            bzh().fTn.setLiveViewOnTouchEventListener(null);
            bzh().fTn.setOnLiveViewScrollListener(null);
        }
        if (bzh().aWl != null) {
            bzh().aWl.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.fKq != null) {
            this.fKq.vm();
        }
        byj();
        if (this.fKk != null) {
            this.fKk.vm();
        }
        if (this.fLg != null) {
            this.fLg.release();
        }
        if (this.fKm != null) {
            this.fKm.vm();
        }
        if (this.fKW != null) {
            this.fKW.bFE();
        }
        if (this.fKj != null) {
            this.fKj.bAS();
            this.fKj.setVisible(8);
        }
        if (this.fKo != null) {
            this.fKo.vm();
        }
        if (this.fKn != null) {
            this.fKn.release();
        }
        if (this.fMB != null) {
            this.fMB.setViewActionDispatched(false);
            this.fMB.removeAllViews();
            this.fMB = null;
        }
        if (this.fMz != null) {
            this.fMz.setViewActionDispatched(false);
            this.fMz.removeAllViews();
            this.fMz = null;
        }
        if (this.fKg != null) {
            this.fKg.removeAllViews();
            this.fKg = null;
        }
        if (this.fLg != null) {
            this.fLg.onDestroy();
        }
        if (this.fKp != null) {
            this.fKp.vm();
        }
        if (this.fKC != null) {
            this.fKC.cancel();
        }
        if (this.fLY != null) {
            this.fLY.bzX();
        }
        if (this.fKC != null) {
            this.fKC.vm();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void bR(boolean z) {
        super.bR(z);
        byj();
        if (this.fKi != null) {
            this.fKi.onDestroy();
        }
        if (this.fKk != null) {
            this.fKk.onDestroy();
        }
        if (this.fKm != null) {
            this.fKm.onDestroy();
        }
        if (this.fKo != null) {
            this.fKo.onDestroy();
        }
        if (this.fKp != null) {
            this.fKp.onDestroy();
        }
        if (this.fKq != null) {
            this.fKq.onDestroy();
        }
        if (this.fKr != null) {
            this.fKr.onDestroy();
        }
        if (this.fLs != null) {
            this.fLs.onDestroy();
        }
        if (this.fKj != null) {
            this.fKj.onDestroy();
        }
        if (this.fKh != null) {
            this.fKh.onDestroy();
        }
        if (this.fLk != null) {
            this.fLk.onDestroy();
        }
        if (this.fKW != null) {
            this.fKW.onDestory();
        }
        if (this.fKn != null) {
            this.fKn.release();
        }
        if (this.fLY != null) {
            this.fLY.bR(!z);
        }
        if (this.fKC != null) {
            this.fKC.onDestroy();
            this.fKC = null;
        }
        MessageManager.getInstance().removeMessageRule(this.fKD);
        MessageManager.getInstance().removeMessageRule(this.fKE);
        MessageManager.getInstance().unRegisterListener(this.fKG);
        MessageManager.getInstance().unRegisterListener(this.fKH);
        MessageManager.getInstance().unRegisterListener(this.fKI);
        MessageManager.getInstance().unRegisterListener(this.fKK);
        MessageManager.getInstance().unRegisterListener(this.fKL);
        MessageManager.getInstance().unRegisterListener(this.fME);
        MessageManager.getInstance().unRegisterListener(this.fKM);
        MessageManager.getInstance().unRegisterListener(this.fKJ);
    }

    private void byj() {
        if (this.fLk != null && this.fLk.CA().getView() != null && this.fLk.CA().getView().getParent() != null) {
            ((ViewGroup) this.fLk.CA().getView().getParent()).removeView(this.fLk.CA().getView());
        }
        if (this.fKu != null && this.fKu.getParent() != null) {
            ((ViewGroup) this.fKu.getParent()).removeView(this.fKu);
        }
        if (this.fLk != null && this.fLk.CB().getView() != null) {
            this.fLK.removeView(this.fLk.CB().getView());
        }
        if (this.fLk != null) {
            this.fLk.CA().setMsgData(new LinkedList());
            this.fLk.BZ();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void a(ad adVar) {
        if (this.fLk != null) {
            byG();
            this.fLk.CB().setEditText(" @" + adVar.getNameShow() + " ");
        }
        if (this.fKW != null) {
            this.fKW.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void g(com.baidu.live.data.a aVar) {
        if (this.fLk != null) {
            byG();
            this.fLk.CB().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.fKW != null) {
            this.fKW.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void b(ad adVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected View byk() {
        if (this.fLk != null) {
            return this.fLk.CB().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean byl() {
        if (this.fLk == null || !this.fLk.CB().Ej()) {
            return false;
        }
        kp(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean bym() {
        return this.fKi == null || this.fKi.bym();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup byn() {
        return this.fMB;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup byo() {
        return this.fKg;
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
                    this.fLO = false;
                    L(intExtra, intExtra2, intExtra3);
                    return;
                }
                byd();
                return;
            }
            bzf();
        } else if (i == 25051 && i2 == -1 && this.fLY != null) {
            this.fLY.bBr();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.fLk != null && this.fLk.CA() != null) {
            this.fLk.CA().onKeyboardVisibilityChanged(z);
        }
        if (z || this.fLk == null || this.fLk.CB() == null || !this.fLk.CB().Ej()) {
            if (z) {
                if (this.fKW != null) {
                    this.fKW.setVisibility(8);
                }
                if (this.fLm != null && this.fLm.xZ() != null) {
                    this.fLm.xZ().setVisibility(8);
                }
                byq();
                if (this.fLk != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fLk.CB().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.fLk.CB().getView().setLayoutParams(layoutParams);
                    this.fLk.CB().getView().setVisibility(0);
                    this.fLk.CB().setQuickInputPanelVisible(false);
                }
                if (this.fLJ != null) {
                    this.fLJ.setVisibility(8);
                }
                if (this.fKn != null) {
                    this.fKn.setVisible(8);
                }
                if (this.fLl != null) {
                    this.fLl.CJ();
                }
                if (this.fLI != null) {
                    this.fLI.setCanVisible(false);
                }
            } else {
                byp();
            }
            if (this.fLk != null && this.fKu != null) {
                int cm = com.baidu.live.aa.a.cm(z);
                if (this.fLK.indexOfChild(this.fKu) != -1 && this.fKu.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fKu.getLayoutParams();
                    layoutParams2.height = com.baidu.live.aa.a.h(false, z);
                    this.fKu.setLayoutParams(layoutParams2);
                }
                if (this.fKu.indexOfChild(this.fLk.CA().getView()) != -1 && this.fLk.CA().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.fLk.CA().getView().getLayoutParams();
                    layoutParams3.height = cm;
                    this.fLk.CA().getView().setLayoutParams(layoutParams3);
                }
                this.fLk.CA().Cz();
            }
            if (this.fLx != null) {
                this.fLx.bd(z);
            }
        }
    }

    private void byp() {
        if (this.fKW != null) {
            this.fKW.setVisibility(0);
        }
        if (this.fKu != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fKu.getLayoutParams();
            layoutParams.bottomMargin = bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
            this.fKu.setLayoutParams(layoutParams);
        }
        if (this.fLk != null) {
            byH();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fLk.CB().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.fLk.CB().getView().setLayoutParams(layoutParams2);
        }
        if (this.fKW != null) {
            this.fKW.setVisibility(0);
        }
        if (this.fLm != null && this.fLm.xZ() != null) {
            this.fLm.xZ().setVisibility(0);
        }
        if (this.fLJ != null) {
            this.fLJ.setVisibility(0);
        }
        if (this.fKn != null) {
            this.fKn.setVisible(0);
        }
        if (this.fLl != null) {
            this.fLl.CJ();
        }
        if (this.fLI != null) {
            this.fLI.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byq() {
        if (this.fKu != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fKu.getLayoutParams();
            boolean z = false;
            if (this.fLk != null && this.fLk.CB() != null) {
                z = this.fLk.CB().Ei();
            }
            int ku = ku(z);
            if (layoutParams.bottomMargin != ku) {
                layoutParams.bottomMargin = ku;
                this.fKu.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kp(boolean z) {
        if (z) {
            this.fLk.CB().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fKu.getLayoutParams();
            int quickInputPanelExpandHeight = this.fLk.CB().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.fKu.setLayoutParams(layoutParams);
                if (this.fLk.CA() != null) {
                    this.fLk.CA().Cz();
                    return;
                }
                return;
            }
            return;
        }
        byp();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.fKh != null) {
                this.fKh.cu(i3);
            }
            if (this.fKj != null) {
                this.fKj.cu(i3);
            }
        }
        super.l(i, i2, i3);
        if (this.fJn && this.fMz != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.17
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (d.this.fMz != null && (layoutParams = d.this.fMz.getLayoutParams()) != null) {
                        int i4 = layoutParams.height;
                        int bzu = d.this.bzu();
                        if (bzu != i4) {
                            layoutParams.height = bzu;
                            d.this.fMz.setLayoutParams(layoutParams);
                        }
                    }
                }
            }, 100L);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public boolean cA(int i) {
        boolean cA = super.cA(i);
        if (cA && 2 == i) {
            if (this.fKi.bym()) {
                return false;
            }
            if (cA && this.fLg != null) {
                this.fLg.lu(false);
            }
        }
        return cA;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void qQ(int i) {
        super.qQ(i);
        if (i == 7 || i == 11) {
            if (this.fKW != null) {
                this.fKW.setVisibility(8);
            }
            if (this.fLk != null) {
                this.fLk.CA().getView().setVisibility(4);
            }
            if (this.fKn != null) {
                this.fKn.bt(2, 8);
                if (this.fJn) {
                    this.fKn.bt(1, 8);
                }
            }
            if (this.fLA != null) {
                this.fLA.lp(false);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public void cB(int i) {
        super.cB(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public void cC(int i) {
        super.cC(i);
        if (i == 7 || i == 11) {
            if (this.fKW != null) {
                this.fKW.setVisibility(0);
            }
            if (this.fLk != null) {
                this.fLk.CA().getView().setVisibility(0);
            }
            if (this.fKn != null) {
                this.fKn.setVisible(0);
            }
            if (this.fLA != null) {
                this.fLA.lp(true);
            }
            this.fLJ.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.fKk != null) {
            this.fKk.bFX();
        }
        if (this.fKp != null) {
            this.fKp.vw();
        }
        if (this.fKn != null) {
            this.fKn.onStop();
        }
        if (this.fKo != null) {
            this.fKo.aS(true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.fKk != null) {
            this.fKk.bFW();
        }
        if (this.fKp != null && this.fMD) {
            this.fKp.vx();
        }
        if (this.fKn != null) {
            this.fKn.onStart();
        }
        if (this.fKo != null) {
            this.fKo.aS(false);
        }
    }

    private ViewGroup.LayoutParams kD(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.fMB == null) {
            return null;
        }
        int bzu = this.fJn ? bzu() : -2;
        ViewGroup.LayoutParams layoutParams2 = this.fMB.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, bzu);
        }
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds112);
        layoutParams.topMargin = bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200);
        return layoutParams;
    }

    private ViewGroup.LayoutParams bzv() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.fMz == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams2 = this.fMz.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
        return layoutParams;
    }
}
