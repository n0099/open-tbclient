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
import com.baidu.live.challenge.i;
import com.baidu.live.challenge.j;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.ad;
import com.baidu.live.data.ax;
import com.baidu.live.data.bg;
import com.baidu.live.data.bm;
import com.baidu.live.data.o;
import com.baidu.live.data.q;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.n;
import com.baidu.live.gift.z;
import com.baidu.live.guardclub.e;
import com.baidu.live.im.k;
import com.baidu.live.im.l;
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
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
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
import com.baidu.live.view.PriorityVerticalLinearLayout;
import com.baidu.tieba.ala.liveroom.h.b;
import com.baidu.tieba.ala.liveroom.h.g;
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.recommend.a;
import com.baidu.tieba.ala.liveroom.turntable.d;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends b {
    private PriorityVerticalLinearLayout fJU;
    private LinearLayout fJV;
    private com.baidu.tieba.ala.liveroom.audiencelist.c fJW;
    private com.baidu.tieba.ala.liveroom.l.a fJX;
    private com.baidu.tieba.ala.liveroom.e.b fJY;
    private com.baidu.tieba.ala.liveroom.r.b fJZ;
    private com.baidu.tieba.ala.liveroom.audiencelist.b fKa;
    private com.baidu.tieba.ala.liveroom.j.a fKb;
    private com.baidu.tieba.ala.liveroom.activeview.b fKc;
    private com.baidu.live.d.a fKd;
    private j fKe;
    private i fKf;
    private com.baidu.tieba.ala.liveroom.attentionpop.b fKg;
    private l fKh;
    private com.baidu.tieba.ala.liveroom.share.b fKi;
    private FrameLayout fKj;
    private FrameLayout fKk;
    private ImageView fKl;
    private com.baidu.live.tieba.e.b fKm;
    private z fKq;
    private com.baidu.tieba.ala.liveroom.h.b fKr;
    private long lastClickTime = 0;
    private boolean fKn = false;
    private boolean fKo = false;
    private Handler fKp = new Handler();
    private HttpRule fKs = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.fKe != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.fKe.vC()) {
                httpMessage.addParam("ala_challenge_id", a.this.fKe.vF());
            }
            return httpMessage;
        }
    };
    private HttpRule fKt = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.c.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.fKe != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.fKe.vC()) {
                httpMessage.addParam("challenge_id", a.this.fKe.vF());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c fKu = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.c.a.19
        @Override // com.baidu.live.liveroom.g.c
        public void Fi() {
            if (a.this.fKV != null) {
                a.this.fKV.lu(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bT(boolean z) {
            if (z) {
                if (a.this.fKL != null) {
                    a.this.fKL.rv(8);
                }
                if (a.this.fKV != null) {
                    a.this.fKV.lu(true);
                }
            } else {
                if (a.this.fKL != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                        a.this.fKL.rv(0);
                    } else {
                        a.this.fKL.rv(8);
                    }
                }
                if (a.this.fKV != null) {
                    a.this.fKV.lu(false);
                }
            }
            if (a.this.fLm != null) {
                a.this.fLm.be(z);
            }
        }
    };
    private HttpMessageListener fKv = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.a.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Fs() != null) {
                        com.baidu.live.v.c.Gj().aYX = getQuickGiftHttpResponseMessage.Fs();
                        a.this.bxS();
                    }
                }
            }
        }
    };
    private CustomMessageListener fKw = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.a.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.byd();
        }
    };
    private CustomMessageListener fKx = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                a.this.fLc.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fKy = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.fLq != null) {
                    a.this.fLq.Cm(str);
                }
            }
        }
    };
    CustomMessageListener fKz = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.fLF != null && a.this.fLF.aOG != null && !a.this.fLF.aOJ && !a.this.fLF.aOK && a.this.fLl != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.bzf().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = a.this.bzf().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                a.this.fLl.b(a.this.fKj, layoutParams);
                if (e.BG() != null) {
                    e.BG().BM();
                }
            }
        }
    };
    private CustomMessageListener fKA = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (a.this.fLo != null) {
                    a.this.fLo.dismiss();
                }
                m.CL().setSwitchStatus(true);
                m.CL().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.byE();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener fKB = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.c.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.fKr.c(a.this.bzf());
                } else if (a.this.byx() || !g.qW(2913168)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, 3000L);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.bzf().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.bzf().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    a.this.fKr.b(a.this.fKj, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b fKC = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.a.10
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
            if (currentTimeMillis - a.this.lastClickTime >= 300) {
                a.this.lastClickTime = currentTimeMillis;
                if (i == 2 && a.this.AP()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel"));
                    a.this.L(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.v.c.Gj().aYX.yi().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.v.c.Gj().aYX.yi().xl());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.v.c.Gj().aYX.yi().xm());
                        if (a.this.bzf().fTb.Fk() != null && a.this.bzf().fTb.Fk().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.bzf().fTb.Fk().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.bzf().fTb.Fk().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.DN());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.AP()) {
                        if (com.baidu.live.c.uN().getBoolean("quick_gift_guide_show", true) && !a.this.byx()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, z.class, a.this.bzf().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                z zVar = (z) runTask.getData();
                                zVar.setPageContext(a.this.bzf().pageContext);
                                zVar.d(a.this.bzf().fTb.Fk());
                                zVar.setGiftItem(com.baidu.live.v.c.Gj().aYX.yi());
                                zVar.setOtherParams(a.this.DN());
                                zVar.initView();
                                zVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.10.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        a.this.ks(false);
                                        a.this.fKq = null;
                                    }
                                });
                                a.this.fKq = zVar;
                                zVar.show();
                                a.this.ks(true);
                                return;
                            }
                            return;
                        }
                        n.a(a.this.bzf().pageContext, a.this.bzf().fTb.Fk(), com.baidu.live.v.c.Gj().aYX.yi(), a.this.DN());
                    }
                } else if (i == 1) {
                    if (a.this.fKZ != null) {
                        a.this.byE();
                    }
                } else if (i == 3 && a.this.AP()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    if (a.this.mOrientation == 2 && TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.fKi != null) {
                            a.this.fKi.w(a.this.bzf().fTb.Fk());
                        }
                    } else {
                        a.this.fKO.c(a.this.bzf().fTb.Fk(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.bzf() != null && a.this.bzf().fTb != null && a.this.bzf().fTb.Fk() != null && a.this.bzf().fTb.Fk().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.bzf().fTb.Fk().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.bzf().fTb.Fk().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.bzf().fTb.Fk().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.DN());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.bzf() != null && a.this.bzf().fTb != null && a.this.bzf().fTb.Fk() != null && a.this.bzf().fTb.Fk().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.bzf().fTb.Fk().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.bzf().fTb.Fk().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.bzf().fTb.Fk().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.DN());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.aWi != null) {
                        a.this.aWi.bO(false);
                    }
                } else if (i == 12) {
                    if (a.this.fKV != null) {
                        String valueOf = String.valueOf(a.this.bzf().fTb.Fk().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.bzf().fTb.Fk().mLiveInfo.room_id);
                        String str3 = null;
                        o oVar = a.this.bzf().fTb.Fk().mLiveSdkInfo;
                        if (oVar != null && oVar.mCastIds != null) {
                            str3 = String.valueOf(a.this.bzf().fTb.Fk().mLiveSdkInfo.mCastIds.avv);
                        }
                        a.this.fKV.ag(valueOf, valueOf2, str3);
                        if (com.baidu.live.liveroom.a.EI().EJ()) {
                            a.this.byd();
                        }
                    }
                } else if (i == 14) {
                    q Fk = a.this.bzf().fTb.Fk();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.bzf().pageContext.getPageActivity(), Fk.avj.userName, Long.toString(Fk.avj.userId), Long.toString(Fk.avj.charmCount), String.valueOf(Fk.mLiveInfo.group_id), String.valueOf(Fk.mLiveInfo.live_id), false, String.valueOf(Fk.avj.userId), Long.toString(Fk.avC.userId), Fk.avC.userName, Fk.avC.portrait, a.this.fKa.getCount(), a.this.DN())));
                    LogManager.getCommonLogger().doClickGusetNumLog(Fk.mLiveInfo.feed_id, a.this.fKa.getCount() + "", a.this.DN());
                } else if (i == 11) {
                    a.this.byH();
                    a.this.byI();
                } else if (i == 15) {
                    if (a.this.fLj != null && a.this.bzf() != null && a.this.bzf().fTb != null && a.this.bzf().fTb.Fk() != null && a.this.bzf().fTb.Fk().mLiveInfo != null) {
                        long j = a.this.bzf().fTb.Fk().mLiveInfo.live_id;
                        String valueOf3 = String.valueOf(a.this.bzf().fTb.Fk().mLiveInfo.feed_id);
                        long j2 = a.this.bzf().fTb.Fk().mLiveInfo.room_id;
                        String str4 = a.this.bzf().fTb.Fk().mLiveInfo.cover;
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        String str8 = "";
                        if (a.this.bzf().fTb.Fk().mLiveInfo.session_info != null) {
                            str5 = a.this.bzf().fTb.Fk().mLiveInfo.session_info.flvUrl;
                        }
                        if (!TextUtils.isEmpty(a.this.DN())) {
                            try {
                                JSONObject jSONObject = new JSONObject(a.this.DN());
                                str6 = jSONObject.optString("tab");
                                str7 = jSONObject.optString("tag");
                                str8 = jSONObject.optString("source");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        a.this.fLj.Cm(com.baidu.live.utils.o.a(valueOf3, j + "", j2, false, 1, str4, str5, str6, str7, str8, String.valueOf(a.this.bzf().fTb.Fk().mLiveInfo.user_id), a.this.bzf().fTb.Fk().mLiveInfo.user_name, String.valueOf(a.this.bzf().fTb.Fk().mLiveInfo.group_id), String.valueOf(a.this.bzf().fTb.Fk().avj.userId)));
                        com.baidu.live.utils.o.bfr = j;
                        if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                            ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                            LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf3, a.this.DN());
                        }
                    }
                } else if (i == 16) {
                    if (a.this.bzf() != null && (axVar2 = com.baidu.live.v.a.Ge().aYP) != null && (bgVar2 = axVar2.aAI) != null) {
                        String str9 = bgVar2.aBF.aBM;
                        if (!TextUtils.isEmpty(str9)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j3 = 0;
                            if (a.this.bzf().fTb != null && a.this.bzf().fTb.Fk() != null && a.this.bzf().fTb.Fk().mLiveInfo != null) {
                                j3 = a.this.bzf().fTb.Fk().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j3 + "", a.this.bzf().fTb.Fk().mLiveInfo.room_id + "", a.this.bzf().fTb.Fk().mLiveInfo.feed_id, a.this.DN());
                            }
                            if (str9.contains("?")) {
                                str2 = str9 + "&liveId=" + j3;
                            } else {
                                str2 = str9 + "?liveId=" + j3;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.bzf().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (a.this.bzf() != null) {
                        q qVar = null;
                        if (a.this.bzf().fTb != null) {
                            qVar = a.this.bzf().fTb.Fk();
                        }
                        if (qVar != null && qVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.t.a.bGk().aWQ != null) {
                            String str10 = com.baidu.tieba.ala.liveroom.t.a.bGk().aWQ.auL;
                            if (!TextUtils.isEmpty(str10)) {
                                if (str10.contains("?")) {
                                    str = str10 + "&live_id=" + qVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str10 + "?live_id=" + qVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(a.this.bzf().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17) {
                    if (a.this.AP() && a.this.bzf() != null && (axVar = com.baidu.live.v.a.Ge().aYP) != null && (bgVar = axVar.aAI) != null && (bmVar = bgVar.aBG) != null && !TextUtils.isEmpty(bmVar.webUrl)) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                        if (a.this.fLo != null && a.this.bzf().fTb != null && a.this.bzf().fTb.Fk() != null) {
                            q Fk2 = a.this.bzf().fTb.Fk();
                            a.this.fLo.a(bmVar.webUrl, Fk2.mLiveInfo.live_id, Fk2.avC.userId, Fk2.avj.userId);
                            a.this.fKm.cc(false);
                            a.this.fKm.GX();
                        }
                    }
                } else if (i == 18) {
                    if (a.this.fKo) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.fKo = !a.this.fKo;
                } else if (i == 19 && a.this.fKm != null) {
                    a.this.fKm.GX();
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
        return false;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void k(q qVar) {
        super.k(qVar);
        g.bBu();
        this.fKo = false;
        if (this.fKT != null) {
            this.fKT.b(this.fKC);
        }
        if (this.fKm == null) {
            this.fKm = new com.baidu.live.tieba.e.b(bzf().pageContext.getPageActivity());
            this.fKm.start();
        }
        this.fKm.cc(true);
        bzf().pageContext.getPageActivity().setRequestedOrientation(-1);
        bzf().fTc.setIsForceHandledTouch(false);
        bzf().fTc.setSwipeClearEnable(true);
        bzf().fTc.setOnLiveViewScrollListener(this.fKu);
        bzf().fTc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.fKp.removeCallbacksAndMessages(null);
                a.this.km(false);
                if (!a.this.fKn) {
                    a.this.fKp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.fKn) {
                                a.this.km(false);
                            }
                        }
                    }, 5000L);
                }
            }
        });
        if (this.fLy != null) {
            this.fLy.setVisibility(0);
        }
        bxH();
        bxK();
        bxV();
        byt();
        bxW();
        bxG();
        bya();
        bxX();
        kn(false);
        byL();
        byK();
        bxM();
        bxT();
        bxU();
        byN();
        bxE();
        byc();
        bye();
        kt(true);
        bxL();
        bxS();
        byW();
        bxN();
        bxO();
        bxP();
        bxQ();
        byf();
        byS();
        bxD();
        byV();
        if (this.fLo != null && this.fLo.bGs() == null) {
            this.fLo.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.21
                @Override // com.baidu.tieba.ala.liveroom.turntable.d.a
                public void onDismiss() {
                    a.this.fKm.cc(true);
                }
            });
        }
        MessageManager.getInstance().registerListener(this.fKv);
        MessageManager.getInstance().registerListener(this.fKw);
        MessageManager.getInstance().registerListener(this.fKz);
        MessageManager.getInstance().registerListener(this.fKA);
        MessageManager.getInstance().registerListener(this.fKB);
        MessageManager.getInstance().registerListener(this.fKy);
        MessageManager.getInstance().registerListener(this.fKx);
        byg();
        bxZ();
        if (this.mOrientation == 2) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(bzf().pageContext.getPageActivity());
            l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(bzf().pageContext.getPageActivity()));
        }
    }

    private void bxD() {
        if (this.fLv != null) {
            this.fLv.a(new a.InterfaceC0569a() { // from class: com.baidu.tieba.ala.liveroom.c.a.22
                @Override // com.baidu.tieba.ala.liveroom.recommend.a.InterfaceC0569a
                public void kq(boolean z) {
                    if (a.this.fKf != null) {
                        a.this.fKf.setNeedCloseRecommendFloat(z);
                    }
                    if (a.this.bzf().fTc.ggU) {
                        if (a.this.fKV != null) {
                            a.this.fKV.lm(z);
                            a.this.fKV.lu(!z);
                        }
                        if (a.this.fKT != null) {
                            a.this.fKT.lm(z);
                            a.this.fKT.setPraiseEnable(!z);
                            a.this.fKT.ll(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void km(boolean z) {
        View yq;
        if (bzf() != null && bzf().pageContext != null && bzf().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(bzf().pageContext.getPageActivity()) == 2 || z) {
                if (this.fLc != null && (yq = this.fLc.yq()) != null) {
                    if (this.fKn) {
                        yq.setVisibility(0);
                    } else {
                        yq.setVisibility(8);
                    }
                }
                if (this.fKn) {
                    if (this.fLy != null) {
                        this.fLy.setVisibility(0);
                    }
                    if (this.fLz != null) {
                        this.fLz.setVisibility(0);
                    }
                    if (this.fJV != null) {
                        this.fJV.setVisibility(0);
                    }
                    if (this.fJU != null) {
                        this.fJU.setVisibility(0);
                    }
                    if (this.fLb != null) {
                        this.fLb.bc(false);
                    }
                } else {
                    if (this.fLy != null) {
                        this.fLy.setVisibility(8);
                    }
                    if (this.fLz != null) {
                        this.fLz.setVisibility(8);
                    }
                    if (this.fJV != null) {
                        this.fJV.setVisibility(8);
                    }
                    if (this.fJU != null) {
                        this.fJU.setVisibility(8);
                    }
                    if (this.fLb != null) {
                        this.fLb.bc(true);
                    }
                }
                this.fKn = this.fKn ? false : true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, boolean z2) {
        ImageView imageView;
        View xZ;
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view;
        }
        if (z) {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_off);
            }
            if (this.fKk != null) {
                this.fKk.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_on);
            }
            if (this.fKk != null) {
                this.fKk.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.fLb != null && (xZ = this.fLb.xZ()) != null) {
            if (z) {
                xZ.setVisibility(8);
            } else {
                xZ.setVisibility(0);
            }
        }
    }

    private void bxE() {
        CustomResponsedMessage runTask;
        if (this.fKh == null && (runTask = MessageManager.getInstance().runTask(2913164, l.class, bzf().pageContext)) != null) {
            this.fKh = (l) runTask.getData();
        }
        if (this.fKh != null) {
            this.fKh.setOtherParams(this.otherParams);
            this.fKh.a(new l.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.23
                @Override // com.baidu.live.im.l.a
                public void CK() {
                    a.this.byQ();
                }
            });
        }
    }

    private void bxF() {
        if (this.fKU != null) {
            this.fKU.ar(bzf().fTa.getLiveContainerView());
        }
    }

    private void bxG() {
        if (this.fKi == null) {
            this.fKi = new com.baidu.tieba.ala.liveroom.share.b(bzf().pageContext);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bE(int i) {
        super.bE(i);
        if (this.fKl != null && UtilHelper.getRealScreenOrientation(bzf().pageContext.getPageActivity()) != 2) {
            this.fKl.setVisibility(0);
        }
        bxF();
        if (this.fKf != null) {
            this.fKf.bE(i);
        }
        if (this.fKf == null || !this.fKf.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void kn(boolean z) {
        super.kn(z);
        this.fLb.bL(bzf().fTb.Fk().mLiveInfo.screen_direction);
    }

    private void bxH() {
        int i = -1;
        if (this.fJU == null) {
            this.fJU = new PriorityVerticalLinearLayout(bzf().pageContext.getPageActivity());
            this.fJU.setDefaultItemMargin(bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            bxJ();
        }
        if (this.fJU.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, bxI());
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            layoutParams.rightMargin = bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
            layoutParams.bottomMargin = bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            if (bzf().fTc.getView() != null && this.fKT != null && this.fKT.getView() != null) {
                i = bzf().fTc.getView().indexOfChild(this.fKT.getView());
            }
            bzf().fTc.addView(this.fJU, i + 1, layoutParams);
        }
    }

    private int bxI() {
        int bottom;
        int bottom2;
        if (bzf().aWl.getLivePlayer().getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bzf().aWl.getLivePlayer().getLayoutParams();
            bottom = layoutParams.topMargin + layoutParams.height;
        } else {
            bottom = bzf().aWl.getLivePlayer().getBottom();
        }
        if (bzf().fTc.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) bzf().fTc.getLayoutParams();
            bottom2 = layoutParams2.topMargin + layoutParams2.height;
        } else {
            bottom2 = bzf().fTc.getBottom();
        }
        return ((bottom2 - bottom) - bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
    }

    private void bxJ() {
        View view = new View(bzf().pageContext.getPageActivity());
        view.setTag(a.g.sdk_pvl_layout_priority_tag_key, 20);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(1, 0);
        layoutParams.weight = 1.0f;
        this.fJU.addView(view, layoutParams);
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
            layoutParams.topMargin = bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds228);
            layoutParams.leftMargin = bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bzf().fTc.addView(this.fJV, layoutParams);
        }
    }

    private void bxL() {
        if (this.fKc == null) {
            this.fKc = new com.baidu.tieba.ala.liveroom.activeview.b(bzf().pageContext);
        }
        this.fKc.setOtherParams(DN());
        this.fKc.b(bzf().fTb.Fk(), true);
        this.fKc.setHost(false);
        this.fKc.a(1, this.fJU, qN(1));
        this.fKc.a(2, this.fJU, qN(2));
        this.fKc.setVisible(this.fLC ? 8 : 0);
    }

    private void bxM() {
        if (this.fKS != null && bzf() != null && bzf().fTb != null) {
            this.fKS.b(this.fLy, bzf().fTb.Fk());
        }
    }

    private ViewGroup.LayoutParams qN(int i) {
        switch (i) {
            case 1:
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = bzf().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds40);
                return layoutParams;
            case 2:
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 5;
                layoutParams2.topMargin = bzf().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                return layoutParams2;
            default:
                return new RelativeLayout.LayoutParams(-1, -2);
        }
    }

    private void bxN() {
        if (this.fJU != null) {
            if (this.fKb == null) {
                this.fKb = new com.baidu.tieba.ala.liveroom.j.a(bzf().pageContext, this);
            }
            this.fKb.setOtherParams(DN());
            this.fKb.d(this.fJU, bxR());
            this.fKb.s(bzf().fTb.Fk());
        }
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
            this.fKL.a(new a.InterfaceC0568a() { // from class: com.baidu.tieba.ala.liveroom.c.a.7
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0568a
                public void bv(int i, int i2) {
                    q Fk = a.this.bzf().fTb.Fk();
                    if (Fk != null && Fk.mLiveInfo != null) {
                        if (a.this.fLp == null) {
                            a.this.fLp = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.bzf().pageContext.getPageActivity());
                        }
                        a.this.fLp.d(a.this.fLz, i, i2);
                        a.this.fLp.a(String.valueOf(Fk.mLiveInfo.live_id), new a.InterfaceC0574a() { // from class: com.baidu.tieba.ala.liveroom.c.a.7.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0574a
                            public void a(float f, String str) {
                                if (a.this.fKL != null) {
                                    a.this.fKL.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0568a
                public void bw(int i, int i2) {
                    if (a.this.fLp != null) {
                        a.this.fLp.bB(i, i2);
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
        this.fLN.a(bzf().fTb.Fk(), this.fJU);
        if (this.fKr == null) {
            this.fKr = new com.baidu.tieba.ala.liveroom.h.b(bzf().pageContext, DN(), this.fLN, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.8
                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void byp() {
                    a.this.ks(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void byq() {
                    a.this.ks(false);
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
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = bzf().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxS() {
        if (this.fKL == null) {
            bxX();
        }
        this.fKL.a(com.baidu.live.v.c.Gj().aYX, bzf().fTb.Fk());
    }

    private void bxT() {
        CustomResponsedMessage runTask;
        if (this.fKZ == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, bzf().pageContext)) != null && runTask.getData() != null) {
            this.fKZ = (k) runTask.getData();
            this.fKZ.setFromMaster(false);
            this.fKZ.CA().getView().setId(a.g.ala_liveroom_msg_list);
            this.fKZ.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.9
                @Override // com.baidu.live.im.k.a
                public boolean CC() {
                    return a.this.AP();
                }

                @Override // com.baidu.live.im.k.a
                public void CD() {
                    a.this.fLG = true;
                }

                @Override // com.baidu.live.im.k.a
                public void fq(String str) {
                    if (!a.this.fLC) {
                        a.this.kp(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.bzf().pageContext.getPageActivity(), a.this.bzf().fTa.getLiveContainerView());
                    }
                    a.this.Cj(str);
                }

                @Override // com.baidu.live.im.k.a
                public void CE() {
                    if (a.this.fLC) {
                        a.this.kp(true);
                        a.this.bzf().fTa.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.bzf().pageContext.getPageActivity(), a.this.bzf().fTa.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (a.this.fKZ != null) {
                        a.this.fKZ.CB().setQuickInputPanelVisible(false);
                        a.this.fKZ.CB().Ek();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void CF() {
                    if (a.this.fLC) {
                        a.this.byo();
                        if (a.this.fLa != null) {
                            a.this.fLa.CJ();
                        }
                        if (a.this.fKh != null) {
                            a.this.fKh.CJ();
                        }
                    } else if (a.this.fKZ != null) {
                        a.this.fKZ.CB().setQuickInputPanelVisible(false);
                        a.this.fKZ.CB().Ek();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean CG() {
                    return a.this.byy();
                }

                @Override // com.baidu.live.im.k.a
                public int CH() {
                    return a.this.byz();
                }
            });
            this.fKj = new FrameLayout(bzf().pageContext.getPageActivity());
            this.fKj.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.fKZ != null && this.fKj != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bzf().pageContext.getPageActivity()) * 0.75f);
            int dimensionPixelSize = bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds120) + ((int) (BdUtilHelper.getEquipmentHeight(bzf().pageContext.getPageActivity()) * 0.33f));
            if (this.fLz.indexOfChild(this.fKj) < 0) {
                if (this.fKj.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fKj.getParent()).removeView(this.fKj);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                this.fLz.addView(this.fKj, layoutParams);
            }
            if (this.fKj.indexOfChild(this.fKZ.CA().getView()) < 0) {
                if (this.fKZ.CA().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fKZ.CA().getView()).removeView(this.fKZ.CA().getView());
                }
                if (UtilHelper.getRealScreenOrientation(bzf().pageContext.getPageActivity()) != 2) {
                    this.fKj.addView(this.fKZ.CA().getView(), new FrameLayout.LayoutParams(equipmentWidth, dimensionPixelSize));
                }
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

    private void bxU() {
        if (this.fKk == null) {
            this.fKk = new FrameLayout(bzf().pageContext.getPageActivity());
            this.fKk.setId(a.g.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void bxV() {
        if (this.fJX == null) {
            this.fJX = new com.baidu.tieba.ala.liveroom.l.a(bzf().pageContext, false, this);
        }
        this.fJX.c(this.fLy, bzf().fTb.Fk());
        this.fJX.a(this.fKC);
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
        }
    }

    private void bxX() {
        if (this.fKL == null) {
            this.fKL = new com.baidu.tieba.ala.liveroom.operation.a(bzf().pageContext);
        }
        this.fKL.a(bzf(), this.fLz, bzf().fTb.Fk().mLiveInfo.live_type, true, this.fKC);
        this.fKL.setOtherParams(DN());
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
    public void byd() {
        String str;
        if (bzf() != null && bzf().fTb != null && bzf().fTb.Fk() != null && bzf().fTb.Fk().avC != null && (str = bzf().fTb.Fk().avC.userName) != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bzf().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !byx()) {
            com.baidu.live.c.uN().putInt("guide_rename_show_count", com.baidu.live.c.uN().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.EI().bN(true);
            if (this.fLs == null) {
                this.fLs = new com.baidu.tieba.ala.liveroom.s.a(bzf().pageContext);
            }
            this.fLs.setOtherParams(DN());
            this.fLs.e(this.fLz, bzf().fTb.Fk());
            ks(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.12
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fLs.bGb();
                    a.this.ks(false);
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
        if (this.fKV == null) {
            this.fKV = new com.baidu.tieba.ala.liveroom.v.a(bzf().pageContext, this);
        }
        this.fKV.d(bzf().fTc, false);
        this.fKV.lt(bze());
    }

    private void byf() {
        if (bzf() != null && bzf().aWl != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(bzf().pageContext.getPageActivity());
            Activity pageActivity = bzf().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + pageActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds176)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.fKl = new ImageView(bzf().pageContext.getPageActivity());
            this.fKl.setVisibility(8);
            this.fKl.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.fKl.setImageResource(a.f.icon_live_enlarge);
            this.fKl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.fKm != null) {
                        a.this.fKm.GW();
                        a.this.fKl.setVisibility(4);
                    }
                }
            });
            bzf().fTc.addView(this.fKl, layoutParams);
            if (UtilHelper.getRealScreenOrientation(bzf().pageContext.getPageActivity()) != 2) {
                if (bzf().fTh) {
                    this.fKl.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.14
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.fKl != null && UtilHelper.getRealScreenOrientation(a.this.bzf().pageContext.getPageActivity()) != 2) {
                                a.this.fKl.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
        }
    }

    private void byg() {
        if (this.fLG || this.fLH) {
            if ((TbadkCoreApplication.isLogin() && this.fKZ.CB().hasText()) || this.fLH) {
                this.fLG = false;
                this.fLH = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.15
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.byE();
                    }
                }, 500L);
            }
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
            e.printStackTrace();
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
        if (this.fKh != null) {
            this.fKh.a(qVar);
        }
        if (this.fKc != null) {
            this.fKc.h(qVar);
            if (qVar != null && this.fLw != null && !this.fLw.hasInit && !TextUtils.isEmpty(this.fLw.aBc)) {
                this.fLw.hasInit = true;
                this.fKc.Cg(this.fLw.aBc);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(com.baidu.live.data.k kVar) {
        if (kVar != null) {
            if (this.fJW != null && kVar.getList() != null) {
                this.fJW.e(kVar);
            }
            if (this.fKa != null) {
                this.fKa.dm(kVar.getCount());
            }
        }
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
        if (this.fJU != null) {
            this.fJU.removeAllViews();
            this.fJU = null;
        }
        if (this.fJV != null) {
            this.fJV.removeAllViews();
            this.fJV = null;
        }
        if (this.fKe != null) {
            this.fKe.vm();
        }
        if (this.fKh != null) {
            this.fKh.a((l.a) null);
            this.fKh.BZ();
        }
        if (this.fKl != null && (this.fKl.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fKl.getParent()).removeView(this.fKl);
        }
        if (this.fKi != null) {
            this.fKi.dismiss();
        }
        if (this.fKm != null) {
            this.fKm.cc(false);
            this.fKm.GX();
        }
        if (this.fKr != null) {
            this.fKr.vm();
        }
        if (this.fLN != null) {
            this.fLN.bzV();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void l(q qVar) {
        View CI;
        super.l(qVar);
        if (this.fKh != null && (CI = this.fKh.CI()) != null && CI.getParent() != null) {
            ((ViewGroup) CI.getParent()).removeView(CI);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.fKh != null) {
            this.fKh.setOtherParams(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void bR(boolean z) {
        super.bR(z);
        this.fKp.removeCallbacksAndMessages(null);
        byh();
        this.fKn = false;
        this.fKo = false;
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
        if (this.fKi != null) {
            this.fKi.onDestroy();
        }
        if (this.fJY != null) {
            this.fJY.onDestroy();
        }
        if (this.fKm != null) {
            this.fKm.stop();
        }
        if (this.fKV != null) {
            this.fKV.onDestroy();
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
        if (this.fKh != null) {
            this.fKh.a((l.a) null);
            this.fKh.release();
            this.fKh = null;
        }
        if (this.fLN != null) {
            this.fLN.bR(z ? false : true);
        }
        if (this.fKr != null) {
            this.fKr.onDestroy();
            this.fKr = null;
        }
        MessageManager.getInstance().removeMessageRule(this.fKs);
        MessageManager.getInstance().removeMessageRule(this.fKt);
        MessageManager.getInstance().unRegisterListener(this.fKv);
        MessageManager.getInstance().unRegisterListener(this.fKw);
        MessageManager.getInstance().unRegisterListener(this.fKz);
        MessageManager.getInstance().unRegisterListener(this.fKA);
        MessageManager.getInstance().unRegisterListener(this.fKB);
        MessageManager.getInstance().unRegisterListener(this.fKy);
        MessageManager.getInstance().unRegisterListener(this.fKx);
    }

    private void byh() {
        if (this.fKZ != null && this.fKZ.CA().getView() != null && this.fKZ.CA().getView().getParent() != null) {
            ((ViewGroup) this.fKZ.CA().getView().getParent()).removeView(this.fKZ.CA().getView());
        }
        if (this.fKj != null && this.fKj.getParent() != null) {
            ((ViewGroup) this.fKj.getParent()).removeView(this.fKj);
        }
        if (this.fKk != null && this.fKk.getParent() != null) {
            ((ViewGroup) this.fKk.getParent()).removeView(this.fKk);
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
        return this.fJU;
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
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.fLC;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(bzf().pageContext.getPageActivity()) || z2) {
            ko(z);
        }
    }

    private void ko(boolean z) {
        int dimensionPixelSize;
        if (this.fKZ != null && this.fKZ.CA() != null) {
            this.fKZ.CA().onKeyboardVisibilityChanged(z);
        }
        if (z || this.fKZ == null || !this.fKZ.CB().Ej()) {
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
                int equipmentHeight = (int) ((z ? 0.2f : 0.33f) * BdUtilHelper.getEquipmentHeight(bzf().pageContext.getPageActivity()));
                if (z) {
                    dimensionPixelSize = equipmentHeight + bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64);
                } else {
                    dimensionPixelSize = equipmentHeight + bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
                }
                if (this.fLz.indexOfChild(this.fKj) != -1 && this.fKj.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fKj.getLayoutParams();
                    layoutParams2.height = dimensionPixelSize;
                    this.fKj.setLayoutParams(layoutParams2);
                }
                if (this.fKj.indexOfChild(this.fKZ.CA().getView()) != -1 && this.fKZ.CA().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.fKZ.CA().getView().getLayoutParams();
                    layoutParams3.height = dimensionPixelSize;
                    this.fKZ.CA().getView().setLayoutParams(layoutParams3);
                }
                this.fKZ.CA().Cz();
            }
        }
    }

    private void byn() {
        if (this.fKL != null) {
            this.fKL.setVisibility(0);
        }
        if (this.fKj != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fKj.getLayoutParams();
            layoutParams.bottomMargin = bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
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
        if (this.fLy != null && (!this.fKn || UtilHelper.getRealScreenOrientation(bzf().pageContext.getPageActivity()) != 2)) {
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
        FrameLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        FrameLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = bzf().pageContext.getPageActivity();
        if (i3 == 1) {
            if (this.fLy != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.fLy.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.fKi != null) {
                this.fKi.dismiss();
            }
            if (this.fKh != null) {
                this.fKh.a((l.a) null);
                this.fKh.BZ();
            }
            if (this.aWi != null) {
                this.aWi.e(true, true);
            }
            if (this.fKl != null) {
                this.fKl.setVisibility(0);
                this.fKl.bringToFront();
            }
            if (this.fKR != null) {
                this.fKR.setVisibility(0);
            }
            if (this.fKZ != null && this.fKZ.CA().getView().getParent() != null && (this.fKZ.CA().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.fKZ.CA().getView().getParent()).removeView(this.fKZ.CA().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bzf().pageContext.getPageActivity()) * 0.75f);
            int equipmentHeight = ((int) (BdUtilHelper.getEquipmentHeight(bzf().pageContext.getPageActivity()) * 0.33f)) + bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
            if (this.fKj != null && this.fKZ != null) {
                this.fKj.addView(this.fKZ.CA().getView(), new FrameLayout.LayoutParams(equipmentWidth, equipmentHeight));
            }
            if (this.fKk != null && (this.fKk.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.fKk.getParent()).removeView(this.fKk);
            }
            if (this.fLa != null) {
                this.fLa.a(bzf().fTb.Fk(), false);
                this.fLa.a(new l.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.16
                    @Override // com.baidu.live.im.l.a
                    public void CK() {
                        a.this.byQ();
                    }
                });
                View CI = this.fLa.CI();
                if (CI != null && this.fLz != null && CI.getParent() == null) {
                    Resources resources = bzf().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bzf().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds98));
                    layoutParams5.addRule(2, a.g.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                    this.fLz.addView(CI, layoutParams5);
                }
            }
            if (this.fKT != null) {
                this.fKT.setPraiseEnable(true);
                bzf().fTc.ggU = true;
            }
            if (this.fJW != null && this.fJW.fMM != null && (layoutParams3 = (FrameLayout.LayoutParams) this.fJW.fMM.getLayoutParams()) != null) {
                layoutParams3.width = -2;
                this.fJW.fMM.setLayoutParams(layoutParams3);
            }
            if (this.fKV != null) {
                this.fKV.bHw();
            }
            if (this.fKn) {
                km(true);
            }
            if (this.fKo) {
                if (this.fKL != null && this.fKL.getLandscapeBarrageImageView() != null) {
                    b(this.fKL.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.fKa != null) {
                this.fKa.kE(true);
            }
            this.fKp.removeCallbacksAndMessages(null);
            if (this.fKb != null) {
                this.fKb.setCanVisible(true);
                this.fKb.s(bzf().fTb.Fk());
            }
        } else if (i3 == 2) {
            if (this.fKV != null) {
                this.fKV.bHx();
            }
            if (this.fLy != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.fLy.getLayoutParams()) != null) {
                layoutParams2.topMargin = bzf().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
            }
            if (this.fLa != null) {
                this.fLa.a((l.a) null);
                this.fLa.BZ();
            }
            bzf().fTc.bGV();
            if (this.aWi != null) {
                this.aWi.e(false, true);
            }
            if (this.fKl != null) {
                this.fKl.setVisibility(4);
            }
            if (this.fKZ != null && this.fKZ.CA().getView().getParent() != null && (this.fKZ.CA().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.fKZ.CA().getView().getParent()).removeView(this.fKZ.CA().getView());
            }
            int max = Math.max(i, i2);
            if (this.fKk != null) {
                if (this.fKk.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fKk.getParent()).removeView(this.fKk);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
                bzf().fTc.addView(this.fKk, layoutParams6);
            }
            if (this.fKk != null && this.fKh != null) {
                this.fKh.a(bzf().fTb.Fk(), false);
                this.fKh.a(new l.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.17
                    @Override // com.baidu.live.im.l.a
                    public void CK() {
                        a.this.byQ();
                    }
                });
                View CI2 = this.fKh.CI();
                if (CI2 != null && this.fKk.indexOfChild(CI2) < 0) {
                    this.fKk.addView(CI2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bzf().pageContext.getPageActivity()), -1));
                }
            }
            if (this.fKT != null) {
                this.fKT.au(bzf().fTc);
                this.fKT.setPraiseEnable(false);
                bzf().fTc.ggU = false;
            }
            if (this.fJW != null && this.fJW.fMM != null && (layoutParams = (FrameLayout.LayoutParams) this.fJW.fMM.getLayoutParams()) != null) {
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                layoutParams.width = (int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f);
                this.fJW.fMM.setLayoutParams(layoutParams);
            }
            if (this.fKa != null) {
                this.fKa.kE(false);
            }
            if (ac.yz() != null) {
                ac.yz().yy();
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.x.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.x.c) runTask.getData()).yy();
            }
            if (this.fKL != null && this.fKL.getLandscapeBarrageImageView() != null) {
                b(this.fKL.getLandscapeBarrageImageView(), this.fKo, false);
            }
            this.fKp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.18
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.fKn) {
                        a.this.km(false);
                    }
                }
            }, 5000L);
            if (this.fLb != null) {
                this.fLb.yb();
            }
            if (this.fKb != null) {
                this.fKb.setCanVisible(false);
                this.fKb.bBA();
            }
        }
        if (this.fLc != null) {
            if (i3 == 2) {
                View yq = this.fLc.yq();
                if (yq != null) {
                    if (yq.getParent() != null && (yq.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) yq.getParent()).removeView(yq);
                    }
                    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams7.addRule(5, a.g.ala_liveroom_hostheader);
                    layoutParams7.addRule(3, a.g.ala_liveroom_hostheader);
                    layoutParams7.topMargin = bzf().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                    if (this.fLy != null) {
                        this.fLy.addView(yq, layoutParams7);
                    }
                }
            } else {
                View yq2 = this.fLc.yq();
                if (yq2 != null) {
                    if (yq2.getParent() != null && (yq2.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) yq2.getParent()).removeView(yq2);
                    }
                    RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams8.topMargin = bzf().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18) * (-1);
                    layoutParams8.addRule(3, a.g.ala_live_header_view);
                    bzf().fTc.addView(yq2, layoutParams8);
                }
            }
        }
        if (this.fKL != null) {
            this.fKL.l(i, i2, i3);
        }
        qP(i3);
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.fJW != null) {
                this.fJW.cs(i3);
            }
            if (this.fJY != null) {
                this.fJY.cs(i3);
            }
            if (this.fKc != null) {
                this.fKc.cs(i3);
            }
            if (this.fLf != null) {
                this.fLf.cs(i3);
            }
            if (this.fLo != null) {
                this.fLo.cs(i3);
            }
            if (this.fKq != null && this.fKq.isShowing()) {
                this.fKq.resize();
            }
            if (this.fLx != null) {
                this.fLx.cs(i3);
            }
        }
        if (this.fLb != null) {
            this.fLb.ya();
        }
        super.l(i, i2, i3);
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
            if (i != 7 || UtilHelper.getRealScreenOrientation(bzf().pageContext.getPageActivity()) != 2) {
                if (this.fKL != null) {
                    this.fKL.setVisibility(8);
                }
                if (this.fKZ != null) {
                    this.fKZ.CA().getView().setVisibility(4);
                }
                if (this.fLp != null) {
                    this.fLp.lp(false);
                }
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
            if (this.fLp != null) {
                this.fLp.lp(true);
            }
            if (!this.fKn || UtilHelper.getRealScreenOrientation(bzf().pageContext.getPageActivity()) != 2) {
                this.fLy.setVisibility(0);
            }
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
        if (bzf() != null) {
            BdUtilHelper.hideSoftKeyPad(bzf().pageContext.getPageActivity(), bzf().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.fJZ != null) {
            this.fJZ.bFU();
        }
        if (this.fKe != null) {
            this.fKe.vx();
        }
        if (this.fKc != null) {
            this.fKc.onStart();
        }
    }

    private void qP(int i) {
        if (this.fJU != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fJU.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.bottomMargin = bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                layoutParams.height = bxI();
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds72) + 0 + bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds22) + bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                layoutParams.rightMargin = bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
                layoutParams.height = -2;
            }
            this.fJU.setLayoutParams(layoutParams);
        }
    }
}
