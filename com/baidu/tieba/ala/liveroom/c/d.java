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
    private LinearLayout fJV;
    private com.baidu.tieba.ala.liveroom.audiencelist.c fJW;
    private com.baidu.tieba.ala.liveroom.l.a fJX;
    private com.baidu.tieba.ala.liveroom.e.b fJY;
    private com.baidu.tieba.ala.liveroom.r.b fJZ;
    private boolean fJc;
    private com.baidu.tieba.ala.liveroom.audiencelist.b fKa;
    private com.baidu.tieba.ala.liveroom.j.a fKb;
    private com.baidu.tieba.ala.liveroom.activeview.b fKc;
    private com.baidu.live.d.a fKd;
    private j fKe;
    private i fKf;
    private com.baidu.tieba.ala.liveroom.attentionpop.b fKg;
    private FrameLayout fKj;
    private com.baidu.tieba.ala.liveroom.h.b fKr;
    private DispatchedPvlLayout fMo;
    private View fMp;
    private DispatchedRelativeLayout fMq;
    private f fMr;
    private long lastClickTime = 0;
    private boolean fMs = false;
    private HttpRule fKs = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.fKe != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.fKe.vC()) {
                httpMessage.addParam("ala_challenge_id", d.this.fKe.vF());
            }
            return httpMessage;
        }
    };
    private HttpRule fKt = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.c.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.fKe != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.fKe.vC()) {
                httpMessage.addParam("challenge_id", d.this.fKe.vF());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c fKu = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.c.d.18
        @Override // com.baidu.live.liveroom.g.c
        public void Fi() {
            if (d.this.fKV != null) {
                d.this.fKV.lu(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bT(boolean z) {
            if (z) {
                if (d.this.fKL != null) {
                    d.this.fKL.rv(8);
                }
                if (d.this.fKV != null) {
                    d.this.fKV.lu(true);
                }
            } else {
                if (d.this.fKL != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                        d.this.fKL.rv(0);
                    } else {
                        d.this.fKL.rv(8);
                    }
                }
                if (d.this.fKV != null) {
                    d.this.fKV.lu(false);
                }
            }
            if (d.this.fLm != null) {
                d.this.fLm.be(z);
            }
        }
    };
    private HttpMessageListener fKv = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.d.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Fs() != null) {
                        com.baidu.live.v.c.Gj().aYX = getQuickGiftHttpResponseMessage.Fs();
                        d.this.bxS();
                    }
                }
            }
        }
    };
    private CustomMessageListener fKw = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.d.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.byd();
        }
    };
    CustomMessageListener fKB = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.c.d.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    d.this.fKr.c(d.this.bzf());
                } else if (d.this.byx() || !g.qW(2913168)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.22.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, 3000L);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = d.this.bzf().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = d.this.bzf().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    d.this.fKr.b(d.this.fKj, layoutParams);
                }
            }
        }
    };
    private CustomMessageListener fMt = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.c.d.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (d.this.byx() || !g.qW(2913128)) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.23.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.qU(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, 3000L);
                } else {
                    d.this.Ck(str);
                }
            }
        }
    };
    private CustomMessageListener fKx = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.c.d.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                d.this.fLc.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fKy = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.c.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (d.this.fLq != null) {
                    d.this.fLq.Cm(str);
                }
            }
        }
    };
    CustomMessageListener fKz = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.c.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.fLF != null && d.this.fLF.aOG != null && !d.this.fLF.aOJ && !d.this.fLF.aOK && d.this.fLl != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.bzf().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = d.this.bzf().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                d.this.fLl.b(d.this.fKj, layoutParams);
                if (e.BG() != null) {
                    e.BG().BM();
                }
            }
        }
    };
    private CustomMessageListener fKA = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (d.this.fLo != null) {
                    d.this.fLo.dismiss();
                }
                if (d.this.fLq != null) {
                    d.this.fLq.dismiss();
                }
                m.CL().setSwitchStatus(true);
                m.CL().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.byE();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b fKC = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.d.14
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
                        if (d.this.bzf().fTb.Fk() != null && d.this.bzf().fTb.Fk().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", d.this.bzf().fTb.Fk().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", d.this.bzf().fTb.Fk().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", d.this.DN());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (d.this.AP()) {
                        if (com.baidu.live.c.uN().getBoolean("quick_gift_guide_show", true) && !d.this.byx()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, z.class, d.this.bzf().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                z zVar = (z) runTask.getData();
                                zVar.setPageContext(d.this.bzf().pageContext);
                                zVar.d(d.this.bzf().fTb.Fk());
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
                        n.a(d.this.bzf().pageContext, d.this.bzf().fTb.Fk(), com.baidu.live.v.c.Gj().aYX.yi(), d.this.DN());
                    }
                } else if (i == 1) {
                    if (d.this.fKZ != null) {
                        d.this.byE();
                    }
                } else if (i == 3 && d.this.AP()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    d.this.fKO.c(d.this.bzf().fTb.Fk(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.bzf() != null && d.this.bzf().fTb != null && d.this.bzf().fTb.Fk() != null && d.this.bzf().fTb.Fk().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.bzf().fTb.Fk().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.bzf().fTb.Fk().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.bzf().fTb.Fk().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.DN());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.bzf() != null && d.this.bzf().fTb != null && d.this.bzf().fTb.Fk() != null && d.this.bzf().fTb.Fk().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.bzf().fTb.Fk().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.bzf().fTb.Fk().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.bzf().fTb.Fk().mLiveInfo.feed_id + "");
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
                    if (d.this.fKV != null && d.this.bzf().fTb.Fk() != null && d.this.bzf().fTb.Fk().mLiveInfo != null) {
                        String valueOf = String.valueOf(d.this.bzf().fTb.Fk().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.bzf().fTb.Fk().mLiveInfo.room_id);
                        String str3 = null;
                        o oVar = d.this.bzf().fTb.Fk().mLiveSdkInfo;
                        if (oVar != null && oVar.mCastIds != null) {
                            str3 = String.valueOf(d.this.bzf().fTb.Fk().mLiveSdkInfo.mCastIds.avv);
                        }
                        d.this.fKV.ag(valueOf, valueOf2, str3);
                        if (com.baidu.live.liveroom.a.EI().EJ()) {
                            d.this.byd();
                        }
                    }
                } else if (i == 14) {
                    q Fk = d.this.bzf().fTb.Fk();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.bzf().pageContext.getPageActivity(), Fk.avj.userName, Long.toString(Fk.avj.userId), Long.toString(Fk.avj.charmCount), String.valueOf(Fk.mLiveInfo.group_id), String.valueOf(Fk.mLiveInfo.live_id), false, String.valueOf(Fk.avj.userId), Long.toString(Fk.avC.userId), Fk.avC.userName, Fk.avC.portrait, d.this.fKa.getCount(), d.this.DN())));
                    LogManager.getCommonLogger().doClickGusetNumLog(Fk.mLiveInfo.feed_id, d.this.fKa.getCount() + "", d.this.DN());
                } else if (i == 11) {
                    d.this.byH();
                    d.this.byI();
                } else if (i == 15) {
                    if (d.this.fLj != null && d.this.bzf() != null && d.this.bzf().fTb != null && d.this.bzf().fTb.Fk() != null && d.this.bzf().fTb.Fk().mLiveInfo != null) {
                        long j = d.this.bzf().fTb.Fk().mLiveInfo.live_id;
                        String valueOf3 = String.valueOf(d.this.bzf().fTb.Fk().mLiveInfo.feed_id);
                        long j2 = d.this.bzf().fTb.Fk().mLiveInfo.room_id;
                        String str4 = d.this.bzf().fTb.Fk().mLiveInfo.cover;
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        String str8 = "";
                        if (d.this.bzf().fTb.Fk().mLiveInfo.session_info != null) {
                            str5 = d.this.bzf().fTb.Fk().mLiveInfo.session_info.flvUrl;
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
                        d.this.fLj.Cm(com.baidu.live.utils.o.a(valueOf3, j + "", j2, false, 1, str4, str5, str6, str7, str8, String.valueOf(d.this.bzf().fTb.Fk().avC.userId), d.this.bzf().fTb.Fk().avC.userName, String.valueOf(d.this.bzf().fTb.Fk().mLiveInfo.group_id), String.valueOf(d.this.bzf().fTb.Fk().avj.userId)));
                        com.baidu.live.utils.o.bfr = j;
                        if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                            ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                            LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf3, d.this.DN());
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "shopcart_clk"));
                    }
                } else if (i == 16) {
                    if (d.this.bzf() != null && (axVar2 = com.baidu.live.v.a.Ge().aYP) != null && (bgVar2 = axVar2.aAI) != null) {
                        String str9 = bgVar2.aBF.aBM;
                        if (!TextUtils.isEmpty(str9)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j3 = 0;
                            if (d.this.bzf().fTb != null && d.this.bzf().fTb.Fk() != null && d.this.bzf().fTb.Fk().mLiveInfo != null) {
                                j3 = d.this.bzf().fTb.Fk().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j3 + "", d.this.bzf().fTb.Fk().mLiveInfo.room_id + "", d.this.bzf().fTb.Fk().mLiveInfo.feed_id, d.this.DN());
                            }
                            if (str9.contains("?")) {
                                str2 = str9 + "&liveId=" + j3;
                            } else {
                                str2 = str9 + "?liveId=" + j3;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.bzf().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (d.this.bzf() != null) {
                        q qVar = null;
                        if (d.this.bzf().fTb != null) {
                            qVar = d.this.bzf().fTb.Fk();
                        }
                        if (qVar != null && qVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.t.a.bGk().aWQ != null) {
                            String str10 = com.baidu.tieba.ala.liveroom.t.a.bGk().aWQ.auL;
                            if (!TextUtils.isEmpty(str10)) {
                                if (str10.contains("?")) {
                                    str = str10 + "&live_id=" + qVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str10 + "?live_id=" + qVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(d.this.bzf().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17 && d.this.AP() && d.this.bzf() != null && (axVar = com.baidu.live.v.a.Ge().aYP) != null && (bgVar = axVar.aAI) != null && (bmVar = bgVar.aBG) != null && !TextUtils.isEmpty(bmVar.webUrl)) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                    if (d.this.fLo != null && d.this.bzf().fTb != null && d.this.bzf().fTb.Fk() != null) {
                        q Fk2 = d.this.bzf().fTb.Fk();
                        d.this.fLo.a(bmVar.webUrl, Fk2.mLiveInfo.live_id, Fk2.avC.userId, Fk2.avj.userId);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.fKQ = new com.baidu.tieba.ala.liveroom.guide.c(bzf().pageContext, this, false);
        this.fKs.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.fKs);
        this.fKt.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.fKt);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean bxC() {
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void k(q qVar) {
        super.k(qVar);
        g.bBu();
        this.fMs = true;
        bzf().fTc.setIsForceHandledTouch(false);
        bzf().fTc.setSwipeClearEnable(true);
        bzf().fTc.setOnLiveViewScrollListener(this.fKu);
        if (this.fKT != null) {
            this.fKT.b(this.fKC);
        }
        if (this.fLy != null) {
            this.fLy.setVisibility(0);
        }
        bxH();
        bxK();
        bxV();
        byt();
        bxW();
        bya();
        bxX();
        kn(false);
        byL();
        byK();
        bxM();
        bxT();
        byN();
        byc();
        bye();
        kA(true);
        bzp();
        bzq();
        kt(false);
        byW();
        bxL();
        bxS();
        bxN();
        bxO();
        bxP();
        bxQ();
        byS();
        bxD();
        ky(true);
        byV();
        MessageManager.getInstance().registerListener(this.fKv);
        MessageManager.getInstance().registerListener(this.fKw);
        MessageManager.getInstance().registerListener(this.fKx);
        MessageManager.getInstance().registerListener(this.fKz);
        MessageManager.getInstance().registerListener(this.fKA);
        MessageManager.getInstance().registerListener(this.fMt);
        MessageManager.getInstance().registerListener(this.fKB);
        MessageManager.getInstance().registerListener(this.fKy);
        byg();
        bxZ();
        if (this.fJc) {
            kB(this.fJc);
            kC(this.fJc);
        }
    }

    private void bxD() {
        if (this.fLv != null) {
            this.fLv.a(new a.InterfaceC0569a() { // from class: com.baidu.tieba.ala.liveroom.c.d.19
                @Override // com.baidu.tieba.ala.liveroom.recommend.a.InterfaceC0569a
                public void kq(boolean z) {
                    if (d.this.fKf != null) {
                        d.this.fKf.setNeedCloseRecommendFloat(z);
                    }
                    if (d.this.bzf().fTc.ggU) {
                        if (d.this.fKV != null) {
                            d.this.fKV.lm(z);
                            d.this.fKV.lu(!z);
                        }
                        if (d.this.fKT != null) {
                            d.this.fKT.lm(z);
                            d.this.fKT.setPraiseEnable(!z);
                            d.this.fKT.ll(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void i(q qVar) {
        super.i(qVar);
        if (this.fJX != null) {
            this.fJX.t(qVar);
        }
        if (this.fJY != null) {
            this.fJY.p(qVar);
        }
        if (this.fKb != null) {
            this.fKb.s(qVar);
        }
        if (this.fKf != null) {
            this.fKf.a(qVar);
        }
        kA(false);
        ky(false);
        if (this.fKc != null) {
            this.fKc.h(qVar);
            this.fKc.kj(this.fLI);
            this.fKc.updateView();
            if (qVar != null && this.fLw != null && !this.fLw.hasInit && !TextUtils.isEmpty(this.fLw.aBc)) {
                this.fLw.hasInit = true;
                this.fKc.Cg(this.fLw.aBc);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(k kVar) {
        if (kVar != null) {
            if (this.fJW != null && kVar.getList() != null) {
                this.fJW.e(kVar);
            }
            if (this.fKa != null) {
                this.fKa.dm(kVar.getCount());
            }
        }
    }

    private void bxF() {
        if (this.fKU != null) {
            this.fKU.ar(bzf().fTa.getLiveContainerView());
        }
    }

    private void bzp() {
        if (this.fKg == null) {
            this.fKg = new com.baidu.tieba.ala.liveroom.attentionpop.b(bzf().pageContext);
        }
        if (bzf().fTb != null && bzf().fTb.Fk() != null && bzf().fTb.Fk().mLiveInfo != null) {
            this.fKg.Ch(String.valueOf(bzf().fTb.Fk().mLiveInfo.user_id));
        }
    }

    private void bzq() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (bzf() != null && bzf().fTb != null && bzf().fTb.Fk() != null && bzf().fTb.Fk().mLiveInfo != null) {
                j = bzf().fTb.Fk().mLiveInfo.room_id;
            }
            if (this.fLh == null) {
                this.fLh = new com.baidu.tieba.ala.liveroom.guide.a(bzf().pageContext, j);
            }
            this.fLh.kr(this.fLB);
            this.fLh.a(new a.InterfaceC0562a() { // from class: com.baidu.tieba.ala.liveroom.c.d.5
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0562a
                public void bzu() {
                    if (d.this.aWi != null) {
                        d.this.aWi.bO(true);
                    }
                }
            });
            this.fLh.ao(null);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bE(int i) {
        super.bE(i);
        bxF();
        if (this.fKf != null) {
            this.fKf.bE(i);
        }
    }

    private void bxH() {
        if (this.fMq == null) {
            this.fMq = new DispatchedRelativeLayout(bzf().pageContext.getPageActivity());
            this.fMq.setViewActionDispatched(false);
            this.fMq.setViewActionDispatchListener(new com.baidu.live.view.dispatch.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.6
                @Override // com.baidu.live.view.dispatch.a
                public boolean X(View view) {
                    return (d.this.fMo == null || d.this.fMo.Jx() || view == null || !(view.getTag(a.g.sdk_pvl_layout_priority_tag_key) instanceof Integer)) ? false : true;
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewAdded(View view) {
                    view.setTag(a.g.ala_live_room_vertival_widgets_bk_lp_key, view.getLayoutParams());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(view.getLayoutParams().width, view.getLayoutParams().height);
                    layoutParams.gravity = 5;
                    view.setLayoutParams(layoutParams);
                    if (d.this.fMo != null) {
                        d.this.fMo.addView(view);
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewRemoved(View view) {
                    if (d.this.fMo != null) {
                        d.this.fMo.removeView(view);
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public void Jz() {
                    if (d.this.fMo != null && !d.this.fMo.Jx()) {
                        d.this.fMo.removeAllViews();
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public int indexOfChild(View view) {
                    if (d.this.fMo != null) {
                        return d.this.fMo.indexOfChild(view);
                    }
                    return 0;
                }
            });
        }
        if (this.fMq.getParent() == null) {
            bzf().fTc.addView(this.fMq, kD(false));
        }
        if (this.fMo == null) {
            this.fMo = new DispatchedPvlLayout(bzf().pageContext.getPageActivity());
            this.fMo.setDefaultItemMargin(bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.fMo.setViewActionDispatched(false);
            this.fMo.setViewActionDispatchListener(new com.baidu.live.view.dispatch.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.7
                @Override // com.baidu.live.view.dispatch.a
                public boolean X(View view) {
                    return (d.this.fMq == null || d.this.fMq.Jx() || view == null || !(view.getTag(a.g.ala_live_room_vertival_widgets_bk_lp_key) instanceof ViewGroup.LayoutParams)) ? false : true;
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewAdded(View view) {
                    view.setLayoutParams(new LinearLayout.LayoutParams(view.getLayoutParams().width, view.getLayoutParams().height));
                    d.this.fMq.addView(view, (ViewGroup.LayoutParams) view.getTag(a.g.ala_live_room_vertival_widgets_bk_lp_key));
                }

                @Override // com.baidu.live.view.dispatch.a
                public void onViewRemoved(View view) {
                    d.this.fMq.removeView(view);
                }

                @Override // com.baidu.live.view.dispatch.a
                public void Jz() {
                    if (d.this.fMq != null && !d.this.fMq.Jx()) {
                        d.this.fMq.removeAllViews();
                    }
                }

                @Override // com.baidu.live.view.dispatch.a
                public int indexOfChild(View view) {
                    return d.this.fMq.indexOfChild(view);
                }
            });
        }
        if (this.fMo.getParent() == null) {
            bzf().fTc.addView(this.fMo, bzt());
        }
    }

    private void bxJ() {
        if (this.fMp == null) {
            this.fMp = new View(bzf().pageContext.getPageActivity());
            this.fMp.setTag(a.g.sdk_pvl_layout_priority_tag_key, 20);
        }
        if (this.fMp.getParent() == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(1, 0);
            layoutParams.weight = 1.0f;
            this.fMo.addView(this.fMp, layoutParams);
        }
    }

    private void bzr() {
        if (this.fMp != null) {
            this.fMo.removeView(this.fMp);
        }
    }

    private void bxK() {
        if (this.fJV == null) {
            this.fJV = new LinearLayout(bzf().pageContext.getPageActivity());
            this.fJV.setOrientation(1);
        }
        if (this.fJV.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds160);
            layoutParams.leftMargin = bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bzf().fTc.addView(this.fJV, layoutParams);
        }
    }

    private void bxM() {
        if (this.fKS != null && bzf() != null && bzf().fTb != null) {
            this.fKS.b(this.fLy, bzf().fTb.Fk());
        }
    }

    private void bxL() {
        if (this.fKc == null) {
            this.fKc = new com.baidu.tieba.ala.liveroom.activeview.b(bzf().pageContext);
        }
        this.fKc.ki(this.fJc);
        this.fKc.setOtherParams(DN());
        this.fKc.b(bzf().fTb.Fk(), false);
        this.fKc.setHost(false);
        this.fKc.kj(this.fLI);
        this.fKc.a(1, this.fJV, qN(1));
        this.fKc.a(2, this.fMo, qN(2));
        this.fKc.setVisible(this.fLC ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxS() {
        if (this.fKL == null) {
            bxX();
        }
        this.fKL.setOtherParams(DN());
        this.fKL.a(com.baidu.live.v.c.Gj().aYX, bzf().fTb.Fk());
    }

    private ViewGroup.LayoutParams qN(int i) {
        switch (i) {
            case 1:
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (this.fJV == null || this.fJV.getChildCount() == 0) {
                    return layoutParams;
                }
                layoutParams.topMargin = bzf().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                return layoutParams;
            case 2:
                ViewGroup.LayoutParams layoutParams2 = this.fMq.getLayoutParams();
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(((int) (BdUtilHelper.getEquipmentWidth(bzf().pageContext.getPageActivity()) * 0.25f)) - ((layoutParams2 instanceof LinearLayout.LayoutParams ? ((LinearLayout.LayoutParams) layoutParams2).rightMargin : 0) * 2), -2);
                layoutParams3.gravity = 5;
                return layoutParams3;
            default:
                return new RelativeLayout.LayoutParams(-2, -2);
        }
    }

    private void bxN() {
        if (this.fKb == null) {
            this.fKb = new com.baidu.tieba.ala.liveroom.j.a(bzf().pageContext, this);
        }
        this.fKb.setOtherParams(DN());
        this.fKb.d(this.fMq, bxR());
        this.fKb.s(bzf().fTb.Fk());
    }

    private void bxO() {
        if (this.fLl == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, com.baidu.live.guardclub.j.class, bzf().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.fLl = (com.baidu.live.guardclub.j) runTask.getData();
            } else {
                return;
            }
        }
        this.fLl.setOtherParams(DN());
        if (this.fKj != null && this.fKj.indexOfChild(this.fLl.getView()) >= 0) {
            this.fKj.removeView(this.fLl.getView());
        }
    }

    private void bxP() {
        if (this.fKL != null) {
            this.fKL.a(new a.InterfaceC0568a() { // from class: com.baidu.tieba.ala.liveroom.c.d.8
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0568a
                public void bv(int i, int i2) {
                    q Fk = d.this.bzf().fTb.Fk();
                    if (Fk != null && Fk.mLiveInfo != null) {
                        if (d.this.fLp == null) {
                            d.this.fLp = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.bzf().pageContext.getPageActivity());
                        }
                        d.this.fLp.d(d.this.fLz, i, i2);
                        d.this.fLp.a(String.valueOf(Fk.mLiveInfo.live_id), new a.InterfaceC0574a() { // from class: com.baidu.tieba.ala.liveroom.c.d.8.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0574a
                            public void a(float f, String str) {
                                if (d.this.fKL != null) {
                                    d.this.fKL.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0568a
                public void bw(int i, int i2) {
                    if (d.this.fLp != null) {
                        d.this.fLp.bB(i, i2);
                    }
                }
            });
        }
    }

    private void bxQ() {
        if (this.fLN == null) {
            this.fLN = new com.baidu.tieba.ala.liveroom.h.e(bzf().pageContext);
        }
        this.fLN.setRoomId(bzf().fTb.Fk().mLiveInfo.room_id);
        this.fLN.Cu("");
        this.fLN.a(bzf().fTb.Fk(), this.fMo);
        if (this.fKr == null) {
            this.fKr = new com.baidu.tieba.ala.liveroom.h.b(bzf().pageContext, DN(), this.fLN, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.9
                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void byp() {
                    d.this.ks(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void byq() {
                    d.this.ks(false);
                }
            });
        }
        this.fKr.setRoomId(bzf().fTb.Fk().mLiveInfo.room_id);
        if (this.fKj != null && this.fKj.indexOfChild(this.fKr.getView()) >= 0) {
            this.fKj.removeView(this.fKr.getView());
        }
        if (this.fKr != null) {
            this.fKr.b(bzf());
        }
    }

    private ViewGroup.LayoutParams bxR() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.topMargin = (ScreenHelper.getRealScreenHeight(bzf().pageContext.getPageActivity()) - this.fMq.getTop()) - bzf().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds814);
        return layoutParams;
    }

    private void bxT() {
        CustomResponsedMessage runTask;
        if (this.fKZ == null && (runTask = MessageManager.getInstance().runTask(2913039, com.baidu.live.im.k.class, bzf().pageContext)) != null && runTask.getData() != null) {
            this.fKZ = (com.baidu.live.im.k) runTask.getData();
            this.fKZ.setFromMaster(false);
            this.fKZ.CA().getView().setId(a.g.ala_liveroom_msg_list);
            this.fKZ.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.10
                @Override // com.baidu.live.im.k.a
                public boolean CC() {
                    return d.this.AP();
                }

                @Override // com.baidu.live.im.k.a
                public void CD() {
                    d.this.fLG = true;
                }

                @Override // com.baidu.live.im.k.a
                public void fq(String str) {
                    if (!d.this.fLC) {
                        d.this.kp(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.bzf().pageContext.getPageActivity(), d.this.bzf().fTa.getLiveContainerView());
                    }
                    d.this.Cj(str);
                }

                @Override // com.baidu.live.im.k.a
                public void CE() {
                    if (d.this.fLC) {
                        d.this.kp(true);
                        d.this.bzf().fTa.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.bzf().pageContext.getPageActivity(), d.this.bzf().fTa.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (d.this.fKZ != null) {
                        d.this.fKZ.CB().setQuickInputPanelVisible(false);
                        d.this.fKZ.CB().Ek();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void CF() {
                    if (d.this.fLC) {
                        d.this.byo();
                        if (d.this.fLa != null) {
                            d.this.fLa.CJ();
                        }
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean CG() {
                    return d.this.byy();
                }

                @Override // com.baidu.live.im.k.a
                public int CH() {
                    return d.this.byz();
                }
            });
            this.fKj = new FrameLayout(bzf().pageContext.getPageActivity());
            this.fKj.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.fKZ != null && this.fKj != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bzf().pageContext.getPageActivity()) * 0.75f);
            int cm = com.baidu.live.aa.a.cm(false);
            if (this.fLz.indexOfChild(this.fKj) < 0) {
                if (this.fKj.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fKj.getParent()).removeView(this.fKj);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.live.aa.a.h(false, false));
                layoutParams.addRule(12);
                layoutParams.bottomMargin = com.baidu.live.aa.a.cn(false);
                this.fLz.addView(this.fKj, layoutParams);
            }
            if (this.fKj.indexOfChild(this.fKZ.CA().getView()) < 0) {
                if (this.fKZ.CA().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fKZ.CA().getView()).removeView(this.fKZ.CA().getView());
                }
                this.fKj.addView(this.fKZ.CA().getView(), new FrameLayout.LayoutParams(equipmentWidth, cm));
            }
            if (bzf().fTc.indexOfChild(this.fKZ.CB().getView()) < 0) {
                if (this.fKZ.CB().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fKZ.CB().getView().getParent()).removeView(this.fKZ.CB().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                byF();
                bzf().fTc.addView(this.fKZ.CB().getView(), layoutParams2);
            }
            q Fk = bzf().fTb.Fk();
            if (Fk != null && Fk.mLiveInfo != null) {
                this.fKZ.setLogData(Fk.mLiveInfo.feed_id, DN());
            }
            this.fKZ.a(String.valueOf(bzf().fTb.Fk().mLiveInfo.group_id), String.valueOf(bzf().fTb.Fk().mLiveInfo.last_msg_id), String.valueOf(bzf().fTb.Fk().avj.userId), String.valueOf(bzf().fTb.Fk().mLiveInfo.live_id), bzf().fTb.Fk().avj.appId, (Fk == null || Fk.avP == null || !Fk.avP.vQ()) ? false : true);
            kp(false);
        }
    }

    private void bxV() {
        if (this.fJX == null) {
            this.fJX = new com.baidu.tieba.ala.liveroom.l.a(bzf().pageContext, false, this);
        }
        this.fJX.c(this.fLy, bzf().fTb.Fk());
        this.fJX.a(this.fKC);
        this.fJX.setOtherParams(DN());
    }

    private void bxW() {
        if (this.fJW == null) {
            this.fJW = new com.baidu.tieba.ala.liveroom.audiencelist.c(bzf().pageContext, this, false);
        }
        this.fJW.a(String.valueOf(bzf().fTb.Fk().mLiveInfo.group_id), String.valueOf(bzf().fTb.Fk().mLiveInfo.live_id), String.valueOf(bzf().fTb.Fk().avj.userId), bzf().fTb.Fk());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.fKN != null && this.fKN.getView() != null && this.fKN.getView().getParent() != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.fJW.c(this.fLy, i, a.g.ala_liveroom_audience_count_layout);
            this.fJW.e(bzf().fTb.bth());
            this.fJW.setOtherParams(DN());
        }
    }

    private void bxX() {
        if (this.fKL == null) {
            this.fKL = new com.baidu.tieba.ala.liveroom.operation.a(bzf().pageContext);
        }
        this.fKL.a(bzf(), this.fLz, bzf().fTb.Fk().mLiveInfo.live_type, true, this.fKC);
        this.fKL.setOtherParams(DN());
    }

    public void kx(boolean z) {
        if (this.fKL != null) {
            this.fKL.kx(z);
        }
    }

    private void bya() {
        if (this.fKa == null) {
            this.fKa = new com.baidu.tieba.ala.liveroom.audiencelist.b(bzf().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (bzf().fTb.bth() != null) {
            j = bzf().fTb.bth().getCount();
        }
        this.fKa.a(this.fKC);
        this.fKa.a(this.fLy, a.g.ala_liveroom_audience, j);
        this.fKa.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.fKa.kF(false);
        } else {
            this.fKa.kF(true);
        }
    }

    protected void Ck(String str) {
        if (this.fLM == null) {
            this.fLM = new com.baidu.tieba.ala.liveroom.q.b(bzf().pageContext);
        }
        this.fLM.b(this.fLz, str);
        ks(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.11
            @Override // java.lang.Runnable
            public void run() {
                d.this.fLM.bFT();
                d.this.ks(false);
            }
        }, 5000L);
    }

    private void ky(boolean z) {
        CustomResponsedMessage runTask;
        if (bzf().fTb.Fk().mLiveInfo.live_type == 1 && this.fMs) {
            if (this.fMr == null && (runTask = MessageManager.getInstance().runTask(2913074, f.class, bzf().pageContext)) != null && runTask.getData() != null) {
                this.fMr = (f) runTask.getData();
            }
            if (this.fMr != null) {
                if (this.fKe == null) {
                    this.fKe = this.fMr.a(bzf().pageContext);
                }
                if (bzf().fTb.Fk().mLiveInfo.challengeId > 0 && !this.fKe.vD()) {
                    this.fKe.e(bzf().fTb.Fk().mLiveInfo.live_id, bzf().fTb.Fk().avj.userId);
                    kz(z);
                    if (z) {
                        this.fKe.a(bzf().fTb.bEF());
                    }
                    this.fKe.c(bzf().fTb.Fk());
                }
            }
        }
    }

    private void kz(boolean z) {
        if (this.fKf == null) {
            this.fKf = this.fMr.b(bzf().pageContext);
            this.fKf.a(new h() { // from class: com.baidu.tieba.ala.liveroom.c.d.13
                @Override // com.baidu.live.challenge.h
                public void vs() {
                    d.this.bzf().fTc.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.h
                public void a(ak akVar, al alVar, al alVar2) {
                    d.this.fJc = true;
                    if (d.this.fKT != null) {
                        d.this.fKT.setPraiseEnable(false);
                        d.this.bzf().fTc.ggU = false;
                    }
                    if (d.this.fKb != null) {
                        d.this.fKb.setCanVisible(false);
                        d.this.fKb.bBA();
                    }
                    if (d.this.fKc != null) {
                        d.this.fKc.ki(true);
                    }
                    if (d.this.fLN != null) {
                        d.this.fLN.setVisible(8);
                    }
                    if (d.this.fKd != null) {
                        d.this.fKd.setCanVisible(false);
                        d.this.fKd.setVisible(8);
                    }
                    d.this.kB(true);
                    d.this.kC(true);
                    if (d.this.bzf().aWl != null) {
                        d.this.bzf().aWl.getLivePlayer().setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                    }
                    if (d.this.fKR != null) {
                        d.this.fKR.setTimeTextMode(true);
                    }
                    if (d.this.aWi != null && alVar != null && alVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(alVar.azA);
                        arrayList.add(alVar2.azA);
                        com.baidu.live.liveroom.a.b bVar = d.this.aWi;
                        if (d.this.fLJ) {
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
                    d.this.bzf().fTc.setSwipeClearEnable(true);
                    d.this.fJc = false;
                    if (d.this.fKT != null) {
                        d.this.fKT.setPraiseEnable(true);
                        d.this.bzf().fTc.ggU = true;
                    }
                    if (d.this.fKb != null) {
                        d.this.fKb.setCanVisible(true);
                        d.this.fKb.s(d.this.bzf().fTb.Fk());
                    }
                    if (d.this.fKV != null) {
                        d.this.fKV.lu(true);
                    }
                    if (d.this.fKc != null) {
                        d.this.fKc.ki(false);
                    }
                    if (d.this.fLN != null) {
                        d.this.fLN.setVisible(0);
                    }
                    if (d.this.fKd != null) {
                        d.this.fKd.setCanVisible(true);
                        d.this.fKd.setVisible(0);
                    }
                    d.this.kB(false);
                    d.this.kC(false);
                    if (d.this.aWi != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.bzf().fTb.bFv());
                        com.baidu.live.liveroom.a.b bVar = d.this.aWi;
                        if (d.this.fLJ) {
                            arrayList = null;
                        }
                        bVar.j(arrayList);
                    }
                    if (d.this.bzf().aWl != null) {
                        d.this.bzf().aWl.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
                    }
                    if (d.this.fKR != null) {
                        d.this.fKR.setTimeTextMode(false);
                    }
                }

                @Override // com.baidu.live.challenge.h
                public void aV(boolean z2) {
                    if (z2 && d.this.fLv != null) {
                        d.this.fLv.onClose();
                    }
                }
            });
        }
        this.fKf.a(this.fKe);
        this.fKf.j(bzf().fTa.getLiveContainerView());
        this.fKf.b(z, false, false);
        this.fKe.a((j.c) this.fKf);
    }

    private void kA(boolean z) {
        CustomResponsedMessage runTask;
        if (bzf().fTb.Fk().mLiveInfo.live_type == 1 && com.baidu.live.v.a.Ge().aWF.axA) {
            if (this.fKd == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bzf().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.fKd = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.fKd != null) {
                this.fKd.a(bzf().fTb.bFx(), false, false);
                if (bzf().fTb.Fk().mLiveInfo.pkId > 0 && this.fKd.getRootView() != null && this.fKd.getRootView().getParent() == null && this.fMq != null) {
                    if (this.fMq.getChildCount() <= 0) {
                        this.fMq.addView(this.fKd.getRootView(), new LinearLayout.LayoutParams(-2, -2));
                    } else {
                        View childAt = this.fMq.getChildAt(0);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.topMargin = bzf().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                        childAt.setLayoutParams(layoutParams);
                        this.fMq.addView(this.fKd.getRootView(), 0, new LinearLayout.LayoutParams(-2, -2));
                    }
                }
                if (z) {
                    this.fKd.a(null, bzf().fTb.Fk());
                } else {
                    this.fKd.b(bzf().fTb.Fk());
                }
            }
        }
    }

    public void byb() {
        this.fKO.c(bzf().fTb.Fk(), false);
    }

    public void byc() {
        if (bzf().fTb.Fk() != null && bzf().fTb.Fk().avj != null && bzf().fTb.Fk().mLiveInfo != null) {
            if (this.fJZ == null) {
                this.fJZ = new com.baidu.tieba.ala.liveroom.r.b(bzf().pageContext);
            }
            long j = bzf().fTb.Fk().avj.userId;
            int i = bzf().fTb.Fk().mLiveInfo.live_type;
            String str = bzf().fTb.Fk().avj.portrait;
            String str2 = bzf().fTb.Fk().mLiveInfo.feed_id;
            long j2 = bzf().fTb.Fk().mLiveInfo.live_id;
            this.fJZ.a(i, j, bzf().fTb.Fk().avj.userName, false, str, DN(), str2, j2);
            this.fJZ.ao(this.fLy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kB(boolean z) {
        if (this.fMo != null && this.fMq != null) {
            if (z) {
                this.fMo.setViewActionDispatched(false);
                this.fMq.setViewActionDispatched(true);
                ViewGroup.LayoutParams layoutParams = this.fMo.getLayoutParams();
                layoutParams.height = bzs();
                this.fMo.setLayoutParams(layoutParams);
                bxJ();
                return;
            }
            this.fMq.setViewActionDispatched(false);
            this.fMo.setViewActionDispatched(true);
            ViewGroup.LayoutParams layoutParams2 = this.fMo.getLayoutParams();
            layoutParams2.height = -2;
            this.fMo.setLayoutParams(layoutParams2);
            bzr();
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
        if (this.fKc != null) {
            ?? layoutParams = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams) layoutParams).gravity = 5;
            ?? r2 = this.fKc;
            ViewGroup viewGroup = z ? this.fMo : this.fJV;
            if (!z) {
                layoutParams = qN(1);
            }
            r2.a(1, viewGroup, layoutParams, 21);
            this.fKc.updateView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bzs() {
        return (((bzf().fTc.getBottom() - (this.fKf != null ? this.fKf.aW(false) : 0)) - (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0)) - bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byd() {
        if (bzf() == null || bzf().fTb == null || bzf().fTb.Fk() == null || bzf().fTb.Fk().avC == null) {
            if (bzf().fTb == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bzf().fTb.Fk() == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bzf().fTb.Fk().avC == null) {
                Log.i("RenameLog", "getLiveContext().liveModel.getLiveShowData().mLoginUserInfo == null");
                return;
            } else {
                return;
            }
        }
        String str = bzf().fTb.Fk().avC.userName;
        Log.i("RenameLog", "loginUserName:" + str);
        if (str != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bzf().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !byx()) {
            com.baidu.live.c.uN().putInt("guide_rename_show_count", com.baidu.live.c.uN().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.EI().bN(true);
            if (this.fLs == null) {
                this.fLs = new com.baidu.tieba.ala.liveroom.s.a(bzf().pageContext);
            }
            this.fLs.setOtherParams(DN());
            this.fLs.e(this.fLz, bzf().fTb.Fk());
            ks(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.15
                @Override // java.lang.Runnable
                public void run() {
                    d.this.fLs.bGb();
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

    private void bye() {
        boolean z = false;
        if (this.fKV == null) {
            this.fKV = new com.baidu.tieba.ala.liveroom.v.a(bzf().pageContext, this);
        }
        this.fKV.d(bzf().fTc, false);
        if (bze() && bzf().fTb.Fk().mLiveInfo.screen_direction != 2) {
            z = true;
        }
        this.fKV.lt(z);
    }

    private void byg() {
        if (this.fLG || this.fLH) {
            if ((TbadkCoreApplication.isLogin() && this.fKZ.CB().hasText()) || this.fLH) {
                this.fLG = false;
                this.fLH = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.16
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.byE();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void bxY() {
        bxZ();
    }

    private void bxZ() {
        if (this.fKL != null) {
            int i = bzf().fTb.Fk().avC.isUegBlock;
            int i2 = bzf().fTb.Fk().avC.isBlock;
            String str = bzf().fTb.Fk().avC.userName;
            if (i > 0 || i2 > 0) {
                this.fKL.b(true, i, i2, str);
                this.fKZ.a(true, i, i2, str);
                this.fLf.b(true, i, i2, str);
                return;
            }
            this.fKL.b(false, i, i2, str);
            this.fKZ.a(false, i, i2, str);
            this.fLf.b(false, i, i2, str);
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
                if (this.fKb != null) {
                    this.fKb.E(jSONObject);
                }
            } else if ("enter_live".equals(optString)) {
                if (this.fKa != null && this.fKa.getCount() > 20) {
                    this.fKa.dm(this.fKa.getCount() + 1);
                } else if (this.fJW != null) {
                    com.baidu.live.data.a DB = aVar.DB();
                    com.baidu.live.data.j jVar = new com.baidu.live.data.j();
                    jVar.avk = new AlaLocationData();
                    jVar.avl = new AlaRelationData();
                    jVar.avj = new AlaLiveUserInfoData();
                    jVar.avj.userId = JavaTypesHelper.toLong(DB.userId, 0L);
                    jVar.avj.userName = DB.userName;
                    jVar.avj.portrait = DB.portrait;
                    if (this.fKa != null && this.fJW.c(jVar)) {
                        this.fKa.dm(this.fKa.getCount() + 1);
                    }
                }
            } else if ("update_liveinfo".equals(optString) && bzf().fTb.Fk() != null && bzf().fTb.Fk().mLiveInfo != null) {
                bzf().fTb.a(bzf().fTb.Fk().mLiveInfo.live_id, bzf().fromType, bzf().enterTime);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void Cf(String str) {
        if (this.fKc != null) {
            this.fKc.Cf(str);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void bS(boolean z) {
        super.bS(z);
        if (bzf().fTc != null) {
            bzf().fTc.bGT();
            bzf().fTc.setLiveViewOnDispatchTouchEventListener(null);
            bzf().fTc.setLiveViewOnTouchEventListener(null);
            bzf().fTc.setOnLiveViewScrollListener(null);
        }
        if (bzf().aWl != null) {
            bzf().aWl.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.fKf != null) {
            this.fKf.vm();
        }
        byh();
        if (this.fJZ != null) {
            this.fJZ.vm();
        }
        if (this.fKV != null) {
            this.fKV.release();
        }
        if (this.fKb != null) {
            this.fKb.vm();
        }
        if (this.fKL != null) {
            this.fKL.bFC();
        }
        if (this.fJY != null) {
            this.fJY.bAQ();
            this.fJY.setVisible(8);
        }
        if (this.fKd != null) {
            this.fKd.vm();
        }
        if (this.fKc != null) {
            this.fKc.release();
        }
        if (this.fMq != null) {
            this.fMq.setViewActionDispatched(false);
            this.fMq.removeAllViews();
            this.fMq = null;
        }
        if (this.fMo != null) {
            this.fMo.setViewActionDispatched(false);
            this.fMo.removeAllViews();
            this.fMo = null;
        }
        if (this.fJV != null) {
            this.fJV.removeAllViews();
            this.fJV = null;
        }
        if (this.fKV != null) {
            this.fKV.onDestroy();
        }
        if (this.fKe != null) {
            this.fKe.vm();
        }
        if (this.fKr != null) {
            this.fKr.cancel();
        }
        if (this.fLN != null) {
            this.fLN.bzV();
        }
        if (this.fKr != null) {
            this.fKr.vm();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void bR(boolean z) {
        super.bR(z);
        byh();
        if (this.fJX != null) {
            this.fJX.onDestroy();
        }
        if (this.fJZ != null) {
            this.fJZ.onDestroy();
        }
        if (this.fKb != null) {
            this.fKb.onDestroy();
        }
        if (this.fKd != null) {
            this.fKd.onDestroy();
        }
        if (this.fKe != null) {
            this.fKe.onDestroy();
        }
        if (this.fKf != null) {
            this.fKf.onDestroy();
        }
        if (this.fKg != null) {
            this.fKg.onDestroy();
        }
        if (this.fLh != null) {
            this.fLh.onDestroy();
        }
        if (this.fJY != null) {
            this.fJY.onDestroy();
        }
        if (this.fJW != null) {
            this.fJW.onDestroy();
        }
        if (this.fKZ != null) {
            this.fKZ.onDestroy();
        }
        if (this.fKL != null) {
            this.fKL.onDestory();
        }
        if (this.fKc != null) {
            this.fKc.release();
        }
        if (this.fLN != null) {
            this.fLN.bR(!z);
        }
        if (this.fKr != null) {
            this.fKr.onDestroy();
            this.fKr = null;
        }
        MessageManager.getInstance().removeMessageRule(this.fKs);
        MessageManager.getInstance().removeMessageRule(this.fKt);
        MessageManager.getInstance().unRegisterListener(this.fKv);
        MessageManager.getInstance().unRegisterListener(this.fKw);
        MessageManager.getInstance().unRegisterListener(this.fKx);
        MessageManager.getInstance().unRegisterListener(this.fKz);
        MessageManager.getInstance().unRegisterListener(this.fKA);
        MessageManager.getInstance().unRegisterListener(this.fMt);
        MessageManager.getInstance().unRegisterListener(this.fKB);
        MessageManager.getInstance().unRegisterListener(this.fKy);
    }

    private void byh() {
        if (this.fKZ != null && this.fKZ.CA().getView() != null && this.fKZ.CA().getView().getParent() != null) {
            ((ViewGroup) this.fKZ.CA().getView().getParent()).removeView(this.fKZ.CA().getView());
        }
        if (this.fKj != null && this.fKj.getParent() != null) {
            ((ViewGroup) this.fKj.getParent()).removeView(this.fKj);
        }
        if (this.fKZ != null && this.fKZ.CB().getView() != null) {
            this.fLz.removeView(this.fKZ.CB().getView());
        }
        if (this.fKZ != null) {
            this.fKZ.CA().setMsgData(new LinkedList());
            this.fKZ.BZ();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void a(ad adVar) {
        if (this.fKZ != null) {
            byE();
            this.fKZ.CB().setEditText(" @" + adVar.getNameShow() + " ");
        }
        if (this.fKL != null) {
            this.fKL.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void g(com.baidu.live.data.a aVar) {
        if (this.fKZ != null) {
            byE();
            this.fKZ.CB().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.fKL != null) {
            this.fKL.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void b(ad adVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected View byi() {
        if (this.fKZ != null) {
            return this.fKZ.CB().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean byj() {
        if (this.fKZ == null || !this.fKZ.CB().Ej()) {
            return false;
        }
        kp(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean byk() {
        return this.fJX == null || this.fJX.byk();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup byl() {
        return this.fMq;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup bym() {
        return this.fJV;
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
                    this.fLD = false;
                    L(intExtra, intExtra2, intExtra3);
                    return;
                }
                byb();
                return;
            }
            bzd();
        } else if (i == 25051 && i2 == -1 && this.fLN != null) {
            this.fLN.bBp();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.fKZ != null && this.fKZ.CA() != null) {
            this.fKZ.CA().onKeyboardVisibilityChanged(z);
        }
        if (z || this.fKZ == null || this.fKZ.CB() == null || !this.fKZ.CB().Ej()) {
            if (z) {
                if (this.fKL != null) {
                    this.fKL.setVisibility(8);
                }
                if (this.fLb != null && this.fLb.xZ() != null) {
                    this.fLb.xZ().setVisibility(8);
                }
                byo();
                if (this.fKZ != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fKZ.CB().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.fKZ.CB().getView().setLayoutParams(layoutParams);
                    this.fKZ.CB().getView().setVisibility(0);
                    this.fKZ.CB().setQuickInputPanelVisible(false);
                }
                if (this.fLy != null) {
                    this.fLy.setVisibility(8);
                }
                if (this.fKc != null) {
                    this.fKc.setVisible(8);
                }
                if (this.fLa != null) {
                    this.fLa.CJ();
                }
                if (this.fLx != null) {
                    this.fLx.setCanVisible(false);
                }
            } else {
                byn();
            }
            if (this.fKZ != null && this.fKj != null) {
                int cm = com.baidu.live.aa.a.cm(z);
                if (this.fLz.indexOfChild(this.fKj) != -1 && this.fKj.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fKj.getLayoutParams();
                    layoutParams2.height = com.baidu.live.aa.a.h(false, z);
                    this.fKj.setLayoutParams(layoutParams2);
                }
                if (this.fKj.indexOfChild(this.fKZ.CA().getView()) != -1 && this.fKZ.CA().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.fKZ.CA().getView().getLayoutParams();
                    layoutParams3.height = cm;
                    this.fKZ.CA().getView().setLayoutParams(layoutParams3);
                }
                this.fKZ.CA().Cz();
            }
            if (this.fLm != null) {
                this.fLm.bd(z);
            }
        }
    }

    private void byn() {
        if (this.fKL != null) {
            this.fKL.setVisibility(0);
        }
        if (this.fKj != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fKj.getLayoutParams();
            layoutParams.bottomMargin = bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
            this.fKj.setLayoutParams(layoutParams);
        }
        if (this.fKZ != null) {
            byF();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fKZ.CB().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.fKZ.CB().getView().setLayoutParams(layoutParams2);
        }
        if (this.fKL != null) {
            this.fKL.setVisibility(0);
        }
        if (this.fLb != null && this.fLb.xZ() != null) {
            this.fLb.xZ().setVisibility(0);
        }
        if (this.fLy != null) {
            this.fLy.setVisibility(0);
        }
        if (this.fKc != null) {
            this.fKc.setVisible(0);
        }
        if (this.fLa != null) {
            this.fLa.CJ();
        }
        if (this.fLx != null) {
            this.fLx.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byo() {
        if (this.fKj != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fKj.getLayoutParams();
            boolean z = false;
            if (this.fKZ != null && this.fKZ.CB() != null) {
                z = this.fKZ.CB().Ei();
            }
            int ku = ku(z);
            if (layoutParams.bottomMargin != ku) {
                layoutParams.bottomMargin = ku;
                this.fKj.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kp(boolean z) {
        if (z) {
            this.fKZ.CB().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fKj.getLayoutParams();
            int quickInputPanelExpandHeight = this.fKZ.CB().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.fKj.setLayoutParams(layoutParams);
                if (this.fKZ.CA() != null) {
                    this.fKZ.CA().Cz();
                    return;
                }
                return;
            }
            return;
        }
        byn();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.fJW != null) {
                this.fJW.cs(i3);
            }
            if (this.fJY != null) {
                this.fJY.cs(i3);
            }
        }
        super.l(i, i2, i3);
        if (this.fJc && this.fMo != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.17
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (d.this.fMo != null && (layoutParams = d.this.fMo.getLayoutParams()) != null) {
                        int i4 = layoutParams.height;
                        int bzs = d.this.bzs();
                        if (bzs != i4) {
                            layoutParams.height = bzs;
                            d.this.fMo.setLayoutParams(layoutParams);
                        }
                    }
                }
            }, 100L);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public boolean cy(int i) {
        boolean cy = super.cy(i);
        if (cy && 2 == i) {
            if (this.fJX.byk()) {
                return false;
            }
            if (cy && this.fKV != null) {
                this.fKV.lu(false);
            }
        }
        return cy;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void qO(int i) {
        super.qO(i);
        if (i == 7 || i == 11) {
            if (this.fKL != null) {
                this.fKL.setVisibility(8);
            }
            if (this.fKZ != null) {
                this.fKZ.CA().getView().setVisibility(4);
            }
            if (this.fKc != null) {
                this.fKc.bt(2, 8);
                if (this.fJc) {
                    this.fKc.bt(1, 8);
                }
            }
            if (this.fLp != null) {
                this.fLp.lp(false);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public void cz(int i) {
        super.cz(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public void cA(int i) {
        super.cA(i);
        if (i == 7 || i == 11) {
            if (this.fKL != null) {
                this.fKL.setVisibility(0);
            }
            if (this.fKZ != null) {
                this.fKZ.CA().getView().setVisibility(0);
            }
            if (this.fKc != null) {
                this.fKc.setVisible(0);
            }
            if (this.fLp != null) {
                this.fLp.lp(true);
            }
            this.fLy.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.fJZ != null) {
            this.fJZ.bFV();
        }
        if (this.fKe != null) {
            this.fKe.vw();
        }
        if (this.fKc != null) {
            this.fKc.onStop();
        }
        if (this.fKd != null) {
            this.fKd.aS(true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.fJZ != null) {
            this.fJZ.bFU();
        }
        if (this.fKe != null && this.fMs) {
            this.fKe.vx();
        }
        if (this.fKc != null) {
            this.fKc.onStart();
        }
        if (this.fKd != null) {
            this.fKd.aS(false);
        }
    }

    private ViewGroup.LayoutParams kD(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.fMq == null) {
            return null;
        }
        int bzs = this.fJc ? bzs() : -2;
        ViewGroup.LayoutParams layoutParams2 = this.fMq.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, bzs);
        }
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds112);
        layoutParams.topMargin = bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200);
        return layoutParams;
    }

    private ViewGroup.LayoutParams bzt() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.fMo == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams2 = this.fMo.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
        return layoutParams;
    }
}
