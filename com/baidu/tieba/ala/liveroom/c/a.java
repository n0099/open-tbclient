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
    private z fKB;
    private com.baidu.tieba.ala.liveroom.h.b fKC;
    private PriorityVerticalLinearLayout fKf;
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
    private l fKs;
    private com.baidu.tieba.ala.liveroom.share.b fKt;
    private FrameLayout fKu;
    private FrameLayout fKv;
    private ImageView fKw;
    private com.baidu.live.tieba.e.b fKx;
    private long lastClickTime = 0;
    private boolean fKy = false;
    private boolean fKz = false;
    private Handler fKA = new Handler();
    private HttpRule fKD = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.fKp != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.fKp.vC()) {
                httpMessage.addParam("ala_challenge_id", a.this.fKp.vF());
            }
            return httpMessage;
        }
    };
    private HttpRule fKE = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.c.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.fKp != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.fKp.vC()) {
                httpMessage.addParam("challenge_id", a.this.fKp.vF());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c fKF = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.c.a.19
        @Override // com.baidu.live.liveroom.g.c
        public void Fi() {
            if (a.this.fLg != null) {
                a.this.fLg.lu(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bT(boolean z) {
            if (z) {
                if (a.this.fKW != null) {
                    a.this.fKW.rx(8);
                }
                if (a.this.fLg != null) {
                    a.this.fLg.lu(true);
                }
            } else {
                if (a.this.fKW != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                        a.this.fKW.rx(0);
                    } else {
                        a.this.fKW.rx(8);
                    }
                }
                if (a.this.fLg != null) {
                    a.this.fLg.lu(false);
                }
            }
            if (a.this.fLx != null) {
                a.this.fLx.be(z);
            }
        }
    };
    private HttpMessageListener fKG = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.a.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.Fs() != null) {
                        com.baidu.live.v.c.Gj().aYX = getQuickGiftHttpResponseMessage.Fs();
                        a.this.bxU();
                    }
                }
            }
        }
    };
    private CustomMessageListener fKH = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.a.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.byf();
        }
    };
    private CustomMessageListener fKI = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                a.this.fLn.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fKJ = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.fLB != null) {
                    a.this.fLB.Cm(str);
                }
            }
        }
    };
    CustomMessageListener fKK = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.fLQ != null && a.this.fLQ.aOG != null && !a.this.fLQ.aOJ && !a.this.fLQ.aOK && a.this.fLw != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.bzh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = a.this.bzh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                a.this.fLw.b(a.this.fKu, layoutParams);
                if (e.BG() != null) {
                    e.BG().BM();
                }
            }
        }
    };
    private CustomMessageListener fKL = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (a.this.fLz != null) {
                    a.this.fLz.dismiss();
                }
                m.CL().setSwitchStatus(true);
                m.CL().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.byG();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener fKM = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.c.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.fKC.c(a.this.bzh());
                } else if (a.this.byz() || !g.qY(2913168)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, 3000L);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.bzh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.bzh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    a.this.fKC.b(a.this.fKu, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b fKN = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.a.10
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
                        if (a.this.bzh().fTm.Fk() != null && a.this.bzh().fTm.Fk().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.bzh().fTm.Fk().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.bzh().fTm.Fk().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.DN());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.AP()) {
                        if (com.baidu.live.c.uN().getBoolean("quick_gift_guide_show", true) && !a.this.byz()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, z.class, a.this.bzh().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                z zVar = (z) runTask.getData();
                                zVar.setPageContext(a.this.bzh().pageContext);
                                zVar.d(a.this.bzh().fTm.Fk());
                                zVar.setGiftItem(com.baidu.live.v.c.Gj().aYX.yi());
                                zVar.setOtherParams(a.this.DN());
                                zVar.initView();
                                zVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.10.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        a.this.ks(false);
                                        a.this.fKB = null;
                                    }
                                });
                                a.this.fKB = zVar;
                                zVar.show();
                                a.this.ks(true);
                                return;
                            }
                            return;
                        }
                        n.a(a.this.bzh().pageContext, a.this.bzh().fTm.Fk(), com.baidu.live.v.c.Gj().aYX.yi(), a.this.DN());
                    }
                } else if (i == 1) {
                    if (a.this.fLk != null) {
                        a.this.byG();
                    }
                } else if (i == 3 && a.this.AP()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    if (a.this.mOrientation == 2 && TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.fKt != null) {
                            a.this.fKt.w(a.this.bzh().fTm.Fk());
                        }
                    } else {
                        a.this.fKZ.c(a.this.bzh().fTm.Fk(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.bzh() != null && a.this.bzh().fTm != null && a.this.bzh().fTm.Fk() != null && a.this.bzh().fTm.Fk().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.bzh().fTm.Fk().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.bzh().fTm.Fk().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.bzh().fTm.Fk().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.DN());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.bzh() != null && a.this.bzh().fTm != null && a.this.bzh().fTm.Fk() != null && a.this.bzh().fTm.Fk().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.bzh().fTm.Fk().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.bzh().fTm.Fk().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.bzh().fTm.Fk().mLiveInfo.feed_id + "");
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
                    if (a.this.fLg != null) {
                        String valueOf = String.valueOf(a.this.bzh().fTm.Fk().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.bzh().fTm.Fk().mLiveInfo.room_id);
                        String str3 = null;
                        o oVar = a.this.bzh().fTm.Fk().mLiveSdkInfo;
                        if (oVar != null && oVar.mCastIds != null) {
                            str3 = String.valueOf(a.this.bzh().fTm.Fk().mLiveSdkInfo.mCastIds.avv);
                        }
                        a.this.fLg.ag(valueOf, valueOf2, str3);
                        if (com.baidu.live.liveroom.a.EI().EJ()) {
                            a.this.byf();
                        }
                    }
                } else if (i == 14) {
                    q Fk = a.this.bzh().fTm.Fk();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.bzh().pageContext.getPageActivity(), Fk.avj.userName, Long.toString(Fk.avj.userId), Long.toString(Fk.avj.charmCount), String.valueOf(Fk.mLiveInfo.group_id), String.valueOf(Fk.mLiveInfo.live_id), false, String.valueOf(Fk.avj.userId), Long.toString(Fk.avC.userId), Fk.avC.userName, Fk.avC.portrait, a.this.fKl.getCount(), a.this.DN())));
                    LogManager.getCommonLogger().doClickGusetNumLog(Fk.mLiveInfo.feed_id, a.this.fKl.getCount() + "", a.this.DN());
                } else if (i == 11) {
                    a.this.byJ();
                    a.this.byK();
                } else if (i == 15) {
                    if (a.this.fLu != null && a.this.bzh() != null && a.this.bzh().fTm != null && a.this.bzh().fTm.Fk() != null && a.this.bzh().fTm.Fk().mLiveInfo != null) {
                        long j = a.this.bzh().fTm.Fk().mLiveInfo.live_id;
                        String valueOf3 = String.valueOf(a.this.bzh().fTm.Fk().mLiveInfo.feed_id);
                        long j2 = a.this.bzh().fTm.Fk().mLiveInfo.room_id;
                        String str4 = a.this.bzh().fTm.Fk().mLiveInfo.cover;
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        String str8 = "";
                        if (a.this.bzh().fTm.Fk().mLiveInfo.session_info != null) {
                            str5 = a.this.bzh().fTm.Fk().mLiveInfo.session_info.flvUrl;
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
                        a.this.fLu.Cm(com.baidu.live.utils.o.a(valueOf3, j + "", j2, false, 1, str4, str5, str6, str7, str8, String.valueOf(a.this.bzh().fTm.Fk().mLiveInfo.user_id), a.this.bzh().fTm.Fk().mLiveInfo.user_name, String.valueOf(a.this.bzh().fTm.Fk().mLiveInfo.group_id), String.valueOf(a.this.bzh().fTm.Fk().avj.userId)));
                        com.baidu.live.utils.o.bfr = j;
                        if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                            ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                            LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf3, a.this.DN());
                        }
                    }
                } else if (i == 16) {
                    if (a.this.bzh() != null && (axVar2 = com.baidu.live.v.a.Ge().aYP) != null && (bgVar2 = axVar2.aAI) != null) {
                        String str9 = bgVar2.aBF.aBM;
                        if (!TextUtils.isEmpty(str9)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j3 = 0;
                            if (a.this.bzh().fTm != null && a.this.bzh().fTm.Fk() != null && a.this.bzh().fTm.Fk().mLiveInfo != null) {
                                j3 = a.this.bzh().fTm.Fk().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j3 + "", a.this.bzh().fTm.Fk().mLiveInfo.room_id + "", a.this.bzh().fTm.Fk().mLiveInfo.feed_id, a.this.DN());
                            }
                            if (str9.contains("?")) {
                                str2 = str9 + "&liveId=" + j3;
                            } else {
                                str2 = str9 + "?liveId=" + j3;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.bzh().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (a.this.bzh() != null) {
                        q qVar = null;
                        if (a.this.bzh().fTm != null) {
                            qVar = a.this.bzh().fTm.Fk();
                        }
                        if (qVar != null && qVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.t.a.bGm().aWQ != null) {
                            String str10 = com.baidu.tieba.ala.liveroom.t.a.bGm().aWQ.auL;
                            if (!TextUtils.isEmpty(str10)) {
                                if (str10.contains("?")) {
                                    str = str10 + "&live_id=" + qVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str10 + "?live_id=" + qVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(a.this.bzh().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17) {
                    if (a.this.AP() && a.this.bzh() != null && (axVar = com.baidu.live.v.a.Ge().aYP) != null && (bgVar = axVar.aAI) != null && (bmVar = bgVar.aBG) != null && !TextUtils.isEmpty(bmVar.webUrl)) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                        if (a.this.fLz != null && a.this.bzh().fTm != null && a.this.bzh().fTm.Fk() != null) {
                            q Fk2 = a.this.bzh().fTm.Fk();
                            a.this.fLz.a(bmVar.webUrl, Fk2.mLiveInfo.live_id, Fk2.avC.userId, Fk2.avj.userId);
                            a.this.fKx.cc(false);
                            a.this.fKx.GX();
                        }
                    }
                } else if (i == 18) {
                    if (a.this.fKz) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.fKz = !a.this.fKz;
                } else if (i == 19 && a.this.fKx != null) {
                    a.this.fKx.GX();
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
        return false;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void k(q qVar) {
        super.k(qVar);
        g.bBw();
        this.fKz = false;
        if (this.fLe != null) {
            this.fLe.b(this.fKN);
        }
        if (this.fKx == null) {
            this.fKx = new com.baidu.live.tieba.e.b(bzh().pageContext.getPageActivity());
            this.fKx.start();
        }
        this.fKx.cc(true);
        bzh().pageContext.getPageActivity().setRequestedOrientation(-1);
        bzh().fTn.setIsForceHandledTouch(false);
        bzh().fTn.setSwipeClearEnable(true);
        bzh().fTn.setOnLiveViewScrollListener(this.fKF);
        bzh().fTn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.fKA.removeCallbacksAndMessages(null);
                a.this.km(false);
                if (!a.this.fKy) {
                    a.this.fKA.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.fKy) {
                                a.this.km(false);
                            }
                        }
                    }, 5000L);
                }
            }
        });
        if (this.fLJ != null) {
            this.fLJ.setVisibility(0);
        }
        bxJ();
        bxM();
        bxX();
        byv();
        bxY();
        bxI();
        byc();
        bxZ();
        kn(false);
        byN();
        byM();
        bxO();
        bxV();
        bxW();
        byP();
        bxG();
        bye();
        byg();
        kt(true);
        bxN();
        bxU();
        byY();
        bxP();
        bxQ();
        bxR();
        bxS();
        byh();
        byU();
        bxF();
        byX();
        if (this.fLz != null && this.fLz.bGu() == null) {
            this.fLz.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.21
                @Override // com.baidu.tieba.ala.liveroom.turntable.d.a
                public void onDismiss() {
                    a.this.fKx.cc(true);
                }
            });
        }
        MessageManager.getInstance().registerListener(this.fKG);
        MessageManager.getInstance().registerListener(this.fKH);
        MessageManager.getInstance().registerListener(this.fKK);
        MessageManager.getInstance().registerListener(this.fKL);
        MessageManager.getInstance().registerListener(this.fKM);
        MessageManager.getInstance().registerListener(this.fKJ);
        MessageManager.getInstance().registerListener(this.fKI);
        byi();
        byb();
        if (this.mOrientation == 2) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(bzh().pageContext.getPageActivity());
            l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(bzh().pageContext.getPageActivity()));
        }
    }

    private void bxF() {
        if (this.fLG != null) {
            this.fLG.a(new a.InterfaceC0569a() { // from class: com.baidu.tieba.ala.liveroom.c.a.22
                @Override // com.baidu.tieba.ala.liveroom.recommend.a.InterfaceC0569a
                public void kq(boolean z) {
                    if (a.this.fKq != null) {
                        a.this.fKq.setNeedCloseRecommendFloat(z);
                    }
                    if (a.this.bzh().fTn.ghf) {
                        if (a.this.fLg != null) {
                            a.this.fLg.lm(z);
                            a.this.fLg.lu(!z);
                        }
                        if (a.this.fLe != null) {
                            a.this.fLe.lm(z);
                            a.this.fLe.setPraiseEnable(!z);
                            a.this.fLe.ll(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void km(boolean z) {
        View yq;
        if (bzh() != null && bzh().pageContext != null && bzh().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(bzh().pageContext.getPageActivity()) == 2 || z) {
                if (this.fLn != null && (yq = this.fLn.yq()) != null) {
                    if (this.fKy) {
                        yq.setVisibility(0);
                    } else {
                        yq.setVisibility(8);
                    }
                }
                if (this.fKy) {
                    if (this.fLJ != null) {
                        this.fLJ.setVisibility(0);
                    }
                    if (this.fLK != null) {
                        this.fLK.setVisibility(0);
                    }
                    if (this.fKg != null) {
                        this.fKg.setVisibility(0);
                    }
                    if (this.fKf != null) {
                        this.fKf.setVisibility(0);
                    }
                    if (this.fLm != null) {
                        this.fLm.bc(false);
                    }
                } else {
                    if (this.fLJ != null) {
                        this.fLJ.setVisibility(8);
                    }
                    if (this.fLK != null) {
                        this.fLK.setVisibility(8);
                    }
                    if (this.fKg != null) {
                        this.fKg.setVisibility(8);
                    }
                    if (this.fKf != null) {
                        this.fKf.setVisibility(8);
                    }
                    if (this.fLm != null) {
                        this.fLm.bc(true);
                    }
                }
                this.fKy = this.fKy ? false : true;
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
            if (this.fKv != null) {
                this.fKv.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_on);
            }
            if (this.fKv != null) {
                this.fKv.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.fLm != null && (xZ = this.fLm.xZ()) != null) {
            if (z) {
                xZ.setVisibility(8);
            } else {
                xZ.setVisibility(0);
            }
        }
    }

    private void bxG() {
        CustomResponsedMessage runTask;
        if (this.fKs == null && (runTask = MessageManager.getInstance().runTask(2913164, l.class, bzh().pageContext)) != null) {
            this.fKs = (l) runTask.getData();
        }
        if (this.fKs != null) {
            this.fKs.setOtherParams(this.otherParams);
            this.fKs.a(new l.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.23
                @Override // com.baidu.live.im.l.a
                public void CK() {
                    a.this.byS();
                }
            });
        }
    }

    private void bxH() {
        if (this.fLf != null) {
            this.fLf.ar(bzh().fTl.getLiveContainerView());
        }
    }

    private void bxI() {
        if (this.fKt == null) {
            this.fKt = new com.baidu.tieba.ala.liveroom.share.b(bzh().pageContext);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bG(int i) {
        super.bG(i);
        if (this.fKw != null && UtilHelper.getRealScreenOrientation(bzh().pageContext.getPageActivity()) != 2) {
            this.fKw.setVisibility(0);
        }
        bxH();
        if (this.fKq != null) {
            this.fKq.bG(i);
        }
        if (this.fKq == null || !this.fKq.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void kn(boolean z) {
        super.kn(z);
        this.fLm.bN(bzh().fTm.Fk().mLiveInfo.screen_direction);
    }

    private void bxJ() {
        int i = -1;
        if (this.fKf == null) {
            this.fKf = new PriorityVerticalLinearLayout(bzh().pageContext.getPageActivity());
            this.fKf.setDefaultItemMargin(bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            bxL();
        }
        if (this.fKf.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, bxK());
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            layoutParams.rightMargin = bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
            layoutParams.bottomMargin = bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            if (bzh().fTn.getView() != null && this.fLe != null && this.fLe.getView() != null) {
                i = bzh().fTn.getView().indexOfChild(this.fLe.getView());
            }
            bzh().fTn.addView(this.fKf, i + 1, layoutParams);
        }
    }

    private int bxK() {
        int bottom;
        int bottom2;
        if (bzh().aWl.getLivePlayer().getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bzh().aWl.getLivePlayer().getLayoutParams();
            bottom = layoutParams.topMargin + layoutParams.height;
        } else {
            bottom = bzh().aWl.getLivePlayer().getBottom();
        }
        if (bzh().fTn.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) bzh().fTn.getLayoutParams();
            bottom2 = layoutParams2.topMargin + layoutParams2.height;
        } else {
            bottom2 = bzh().fTn.getBottom();
        }
        return ((bottom2 - bottom) - bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
    }

    private void bxL() {
        View view = new View(bzh().pageContext.getPageActivity());
        view.setTag(a.g.sdk_pvl_layout_priority_tag_key, 20);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(1, 0);
        layoutParams.weight = 1.0f;
        this.fKf.addView(view, layoutParams);
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
            layoutParams.topMargin = bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds228);
            layoutParams.leftMargin = bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bzh().fTn.addView(this.fKg, layoutParams);
        }
    }

    private void bxN() {
        if (this.fKn == null) {
            this.fKn = new com.baidu.tieba.ala.liveroom.activeview.b(bzh().pageContext);
        }
        this.fKn.setOtherParams(DN());
        this.fKn.b(bzh().fTm.Fk(), true);
        this.fKn.setHost(false);
        this.fKn.a(1, this.fKf, qP(1));
        this.fKn.a(2, this.fKf, qP(2));
        this.fKn.setVisible(this.fLN ? 8 : 0);
    }

    private void bxO() {
        if (this.fLd != null && bzh() != null && bzh().fTm != null) {
            this.fLd.b(this.fLJ, bzh().fTm.Fk());
        }
    }

    private ViewGroup.LayoutParams qP(int i) {
        switch (i) {
            case 1:
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = bzh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds40);
                return layoutParams;
            case 2:
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 5;
                layoutParams2.topMargin = bzh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                return layoutParams2;
            default:
                return new RelativeLayout.LayoutParams(-1, -2);
        }
    }

    private void bxP() {
        if (this.fKf != null) {
            if (this.fKm == null) {
                this.fKm = new com.baidu.tieba.ala.liveroom.j.a(bzh().pageContext, this);
            }
            this.fKm.setOtherParams(DN());
            this.fKm.d(this.fKf, bxT());
            this.fKm.s(bzh().fTm.Fk());
        }
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
            this.fKW.a(new a.InterfaceC0568a() { // from class: com.baidu.tieba.ala.liveroom.c.a.7
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0568a
                public void bv(int i, int i2) {
                    q Fk = a.this.bzh().fTm.Fk();
                    if (Fk != null && Fk.mLiveInfo != null) {
                        if (a.this.fLA == null) {
                            a.this.fLA = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.bzh().pageContext.getPageActivity());
                        }
                        a.this.fLA.d(a.this.fLK, i, i2);
                        a.this.fLA.a(String.valueOf(Fk.mLiveInfo.live_id), new a.InterfaceC0574a() { // from class: com.baidu.tieba.ala.liveroom.c.a.7.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0574a
                            public void a(float f, String str) {
                                if (a.this.fKW != null) {
                                    a.this.fKW.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0568a
                public void bw(int i, int i2) {
                    if (a.this.fLA != null) {
                        a.this.fLA.bB(i, i2);
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
        this.fLY.a(bzh().fTm.Fk(), this.fKf);
        if (this.fKC == null) {
            this.fKC = new com.baidu.tieba.ala.liveroom.h.b(bzh().pageContext, DN(), this.fLY, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.8
                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void byr() {
                    a.this.ks(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void bys() {
                    a.this.ks(false);
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
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = bzh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxU() {
        if (this.fKW == null) {
            bxZ();
        }
        this.fKW.a(com.baidu.live.v.c.Gj().aYX, bzh().fTm.Fk());
    }

    private void bxV() {
        CustomResponsedMessage runTask;
        if (this.fLk == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, bzh().pageContext)) != null && runTask.getData() != null) {
            this.fLk = (k) runTask.getData();
            this.fLk.setFromMaster(false);
            this.fLk.CA().getView().setId(a.g.ala_liveroom_msg_list);
            this.fLk.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.9
                @Override // com.baidu.live.im.k.a
                public boolean CC() {
                    return a.this.AP();
                }

                @Override // com.baidu.live.im.k.a
                public void CD() {
                    a.this.fLR = true;
                }

                @Override // com.baidu.live.im.k.a
                public void fq(String str) {
                    if (!a.this.fLN) {
                        a.this.kp(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.bzh().pageContext.getPageActivity(), a.this.bzh().fTl.getLiveContainerView());
                    }
                    a.this.Cj(str);
                }

                @Override // com.baidu.live.im.k.a
                public void CE() {
                    if (a.this.fLN) {
                        a.this.kp(true);
                        a.this.bzh().fTl.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.bzh().pageContext.getPageActivity(), a.this.bzh().fTl.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (a.this.fLk != null) {
                        a.this.fLk.CB().setQuickInputPanelVisible(false);
                        a.this.fLk.CB().Ek();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void CF() {
                    if (a.this.fLN) {
                        a.this.byq();
                        if (a.this.fLl != null) {
                            a.this.fLl.CJ();
                        }
                        if (a.this.fKs != null) {
                            a.this.fKs.CJ();
                        }
                    } else if (a.this.fLk != null) {
                        a.this.fLk.CB().setQuickInputPanelVisible(false);
                        a.this.fLk.CB().Ek();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean CG() {
                    return a.this.byA();
                }

                @Override // com.baidu.live.im.k.a
                public int CH() {
                    return a.this.byB();
                }
            });
            this.fKu = new FrameLayout(bzh().pageContext.getPageActivity());
            this.fKu.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.fLk != null && this.fKu != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bzh().pageContext.getPageActivity()) * 0.75f);
            int dimensionPixelSize = bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds120) + ((int) (BdUtilHelper.getEquipmentHeight(bzh().pageContext.getPageActivity()) * 0.33f));
            if (this.fLK.indexOfChild(this.fKu) < 0) {
                if (this.fKu.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fKu.getParent()).removeView(this.fKu);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                this.fLK.addView(this.fKu, layoutParams);
            }
            if (this.fKu.indexOfChild(this.fLk.CA().getView()) < 0) {
                if (this.fLk.CA().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fLk.CA().getView()).removeView(this.fLk.CA().getView());
                }
                if (UtilHelper.getRealScreenOrientation(bzh().pageContext.getPageActivity()) != 2) {
                    this.fKu.addView(this.fLk.CA().getView(), new FrameLayout.LayoutParams(equipmentWidth, dimensionPixelSize));
                }
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

    private void bxW() {
        if (this.fKv == null) {
            this.fKv = new FrameLayout(bzh().pageContext.getPageActivity());
            this.fKv.setId(a.g.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void bxX() {
        if (this.fKi == null) {
            this.fKi = new com.baidu.tieba.ala.liveroom.l.a(bzh().pageContext, false, this);
        }
        this.fKi.c(this.fLJ, bzh().fTm.Fk());
        this.fKi.a(this.fKN);
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
        }
    }

    private void bxZ() {
        if (this.fKW == null) {
            this.fKW = new com.baidu.tieba.ala.liveroom.operation.a(bzh().pageContext);
        }
        this.fKW.a(bzh(), this.fLK, bzh().fTm.Fk().mLiveInfo.live_type, true, this.fKN);
        this.fKW.setOtherParams(DN());
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
    public void byf() {
        String str;
        if (bzh() != null && bzh().fTm != null && bzh().fTm.Fk() != null && bzh().fTm.Fk().avC != null && (str = bzh().fTm.Fk().avC.userName) != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bzh().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !byz()) {
            com.baidu.live.c.uN().putInt("guide_rename_show_count", com.baidu.live.c.uN().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.EI().bN(true);
            if (this.fLD == null) {
                this.fLD = new com.baidu.tieba.ala.liveroom.s.a(bzh().pageContext);
            }
            this.fLD.setOtherParams(DN());
            this.fLD.e(this.fLK, bzh().fTm.Fk());
            ks(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.12
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fLD.bGd();
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

    private void byg() {
        if (this.fLg == null) {
            this.fLg = new com.baidu.tieba.ala.liveroom.v.a(bzh().pageContext, this);
        }
        this.fLg.d(bzh().fTn, false);
        this.fLg.lt(bzg());
    }

    private void byh() {
        if (bzh() != null && bzh().aWl != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(bzh().pageContext.getPageActivity());
            Activity pageActivity = bzh().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + pageActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds176)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.fKw = new ImageView(bzh().pageContext.getPageActivity());
            this.fKw.setVisibility(8);
            this.fKw.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.fKw.setImageResource(a.f.icon_live_enlarge);
            this.fKw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.fKx != null) {
                        a.this.fKx.GW();
                        a.this.fKw.setVisibility(4);
                    }
                }
            });
            bzh().fTn.addView(this.fKw, layoutParams);
            if (UtilHelper.getRealScreenOrientation(bzh().pageContext.getPageActivity()) != 2) {
                if (bzh().fTs) {
                    this.fKw.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.14
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.fKw != null && UtilHelper.getRealScreenOrientation(a.this.bzh().pageContext.getPageActivity()) != 2) {
                                a.this.fKw.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
        }
    }

    private void byi() {
        if (this.fLR || this.fLS) {
            if ((TbadkCoreApplication.isLogin() && this.fLk.CB().hasText()) || this.fLS) {
                this.fLR = false;
                this.fLS = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.15
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.byG();
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
        if (this.fKs != null) {
            this.fKs.a(qVar);
        }
        if (this.fKn != null) {
            this.fKn.h(qVar);
            if (qVar != null && this.fLH != null && !this.fLH.hasInit && !TextUtils.isEmpty(this.fLH.aBc)) {
                this.fLH.hasInit = true;
                this.fKn.Cg(this.fLH.aBc);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(com.baidu.live.data.k kVar) {
        if (kVar != null) {
            if (this.fKh != null && kVar.getList() != null) {
                this.fKh.e(kVar);
            }
            if (this.fKl != null) {
                this.fKl.dm(kVar.getCount());
            }
        }
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
        if (this.fKf != null) {
            this.fKf.removeAllViews();
            this.fKf = null;
        }
        if (this.fKg != null) {
            this.fKg.removeAllViews();
            this.fKg = null;
        }
        if (this.fKp != null) {
            this.fKp.vm();
        }
        if (this.fKs != null) {
            this.fKs.a((l.a) null);
            this.fKs.BZ();
        }
        if (this.fKw != null && (this.fKw.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fKw.getParent()).removeView(this.fKw);
        }
        if (this.fKt != null) {
            this.fKt.dismiss();
        }
        if (this.fKx != null) {
            this.fKx.cc(false);
            this.fKx.GX();
        }
        if (this.fKC != null) {
            this.fKC.vm();
        }
        if (this.fLY != null) {
            this.fLY.bzX();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void l(q qVar) {
        View CI;
        super.l(qVar);
        if (this.fKs != null && (CI = this.fKs.CI()) != null && CI.getParent() != null) {
            ((ViewGroup) CI.getParent()).removeView(CI);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.fKs != null) {
            this.fKs.setOtherParams(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void bR(boolean z) {
        super.bR(z);
        this.fKA.removeCallbacksAndMessages(null);
        byj();
        this.fKy = false;
        this.fKz = false;
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
        if (this.fKt != null) {
            this.fKt.onDestroy();
        }
        if (this.fKj != null) {
            this.fKj.onDestroy();
        }
        if (this.fKx != null) {
            this.fKx.stop();
        }
        if (this.fLg != null) {
            this.fLg.onDestroy();
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
        if (this.fKs != null) {
            this.fKs.a((l.a) null);
            this.fKs.release();
            this.fKs = null;
        }
        if (this.fLY != null) {
            this.fLY.bR(z ? false : true);
        }
        if (this.fKC != null) {
            this.fKC.onDestroy();
            this.fKC = null;
        }
        MessageManager.getInstance().removeMessageRule(this.fKD);
        MessageManager.getInstance().removeMessageRule(this.fKE);
        MessageManager.getInstance().unRegisterListener(this.fKG);
        MessageManager.getInstance().unRegisterListener(this.fKH);
        MessageManager.getInstance().unRegisterListener(this.fKK);
        MessageManager.getInstance().unRegisterListener(this.fKL);
        MessageManager.getInstance().unRegisterListener(this.fKM);
        MessageManager.getInstance().unRegisterListener(this.fKJ);
        MessageManager.getInstance().unRegisterListener(this.fKI);
    }

    private void byj() {
        if (this.fLk != null && this.fLk.CA().getView() != null && this.fLk.CA().getView().getParent() != null) {
            ((ViewGroup) this.fLk.CA().getView().getParent()).removeView(this.fLk.CA().getView());
        }
        if (this.fKu != null && this.fKu.getParent() != null) {
            ((ViewGroup) this.fKu.getParent()).removeView(this.fKu);
        }
        if (this.fKv != null && this.fKv.getParent() != null) {
            ((ViewGroup) this.fKv.getParent()).removeView(this.fKv);
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
        return this.fKf;
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
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.fLN;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(bzh().pageContext.getPageActivity()) || z2) {
            ko(z);
        }
    }

    private void ko(boolean z) {
        int dimensionPixelSize;
        if (this.fLk != null && this.fLk.CA() != null) {
            this.fLk.CA().onKeyboardVisibilityChanged(z);
        }
        if (z || this.fLk == null || !this.fLk.CB().Ej()) {
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
                int equipmentHeight = (int) ((z ? 0.2f : 0.33f) * BdUtilHelper.getEquipmentHeight(bzh().pageContext.getPageActivity()));
                if (z) {
                    dimensionPixelSize = equipmentHeight + bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64);
                } else {
                    dimensionPixelSize = equipmentHeight + bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
                }
                if (this.fLK.indexOfChild(this.fKu) != -1 && this.fKu.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fKu.getLayoutParams();
                    layoutParams2.height = dimensionPixelSize;
                    this.fKu.setLayoutParams(layoutParams2);
                }
                if (this.fKu.indexOfChild(this.fLk.CA().getView()) != -1 && this.fLk.CA().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.fLk.CA().getView().getLayoutParams();
                    layoutParams3.height = dimensionPixelSize;
                    this.fLk.CA().getView().setLayoutParams(layoutParams3);
                }
                this.fLk.CA().Cz();
            }
        }
    }

    private void byp() {
        if (this.fKW != null) {
            this.fKW.setVisibility(0);
        }
        if (this.fKu != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fKu.getLayoutParams();
            layoutParams.bottomMargin = bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
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
        if (this.fLJ != null && (!this.fKy || UtilHelper.getRealScreenOrientation(bzh().pageContext.getPageActivity()) != 2)) {
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
        FrameLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        FrameLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = bzh().pageContext.getPageActivity();
        if (i3 == 1) {
            if (this.fLJ != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.fLJ.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.fKt != null) {
                this.fKt.dismiss();
            }
            if (this.fKs != null) {
                this.fKs.a((l.a) null);
                this.fKs.BZ();
            }
            if (this.aWi != null) {
                this.aWi.e(true, true);
            }
            if (this.fKw != null) {
                this.fKw.setVisibility(0);
                this.fKw.bringToFront();
            }
            if (this.fLc != null) {
                this.fLc.setVisibility(0);
            }
            if (this.fLk != null && this.fLk.CA().getView().getParent() != null && (this.fLk.CA().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.fLk.CA().getView().getParent()).removeView(this.fLk.CA().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bzh().pageContext.getPageActivity()) * 0.75f);
            int equipmentHeight = ((int) (BdUtilHelper.getEquipmentHeight(bzh().pageContext.getPageActivity()) * 0.33f)) + bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
            if (this.fKu != null && this.fLk != null) {
                this.fKu.addView(this.fLk.CA().getView(), new FrameLayout.LayoutParams(equipmentWidth, equipmentHeight));
            }
            if (this.fKv != null && (this.fKv.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.fKv.getParent()).removeView(this.fKv);
            }
            if (this.fLl != null) {
                this.fLl.a(bzh().fTm.Fk(), false);
                this.fLl.a(new l.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.16
                    @Override // com.baidu.live.im.l.a
                    public void CK() {
                        a.this.byS();
                    }
                });
                View CI = this.fLl.CI();
                if (CI != null && this.fLK != null && CI.getParent() == null) {
                    Resources resources = bzh().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bzh().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds98));
                    layoutParams5.addRule(2, a.g.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                    this.fLK.addView(CI, layoutParams5);
                }
            }
            if (this.fLe != null) {
                this.fLe.setPraiseEnable(true);
                bzh().fTn.ghf = true;
            }
            if (this.fKh != null && this.fKh.fMX != null && (layoutParams3 = (FrameLayout.LayoutParams) this.fKh.fMX.getLayoutParams()) != null) {
                layoutParams3.width = -2;
                this.fKh.fMX.setLayoutParams(layoutParams3);
            }
            if (this.fLg != null) {
                this.fLg.bHy();
            }
            if (this.fKy) {
                km(true);
            }
            if (this.fKz) {
                if (this.fKW != null && this.fKW.getLandscapeBarrageImageView() != null) {
                    b(this.fKW.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.fKl != null) {
                this.fKl.kE(true);
            }
            this.fKA.removeCallbacksAndMessages(null);
            if (this.fKm != null) {
                this.fKm.setCanVisible(true);
                this.fKm.s(bzh().fTm.Fk());
            }
        } else if (i3 == 2) {
            if (this.fLg != null) {
                this.fLg.bHz();
            }
            if (this.fLJ != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.fLJ.getLayoutParams()) != null) {
                layoutParams2.topMargin = bzh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
            }
            if (this.fLl != null) {
                this.fLl.a((l.a) null);
                this.fLl.BZ();
            }
            bzh().fTn.bGX();
            if (this.aWi != null) {
                this.aWi.e(false, true);
            }
            if (this.fKw != null) {
                this.fKw.setVisibility(4);
            }
            if (this.fLk != null && this.fLk.CA().getView().getParent() != null && (this.fLk.CA().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.fLk.CA().getView().getParent()).removeView(this.fLk.CA().getView());
            }
            int max = Math.max(i, i2);
            if (this.fKv != null) {
                if (this.fKv.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.fKv.getParent()).removeView(this.fKv);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
                bzh().fTn.addView(this.fKv, layoutParams6);
            }
            if (this.fKv != null && this.fKs != null) {
                this.fKs.a(bzh().fTm.Fk(), false);
                this.fKs.a(new l.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.17
                    @Override // com.baidu.live.im.l.a
                    public void CK() {
                        a.this.byS();
                    }
                });
                View CI2 = this.fKs.CI();
                if (CI2 != null && this.fKv.indexOfChild(CI2) < 0) {
                    this.fKv.addView(CI2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bzh().pageContext.getPageActivity()), -1));
                }
            }
            if (this.fLe != null) {
                this.fLe.au(bzh().fTn);
                this.fLe.setPraiseEnable(false);
                bzh().fTn.ghf = false;
            }
            if (this.fKh != null && this.fKh.fMX != null && (layoutParams = (FrameLayout.LayoutParams) this.fKh.fMX.getLayoutParams()) != null) {
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                layoutParams.width = (int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f);
                this.fKh.fMX.setLayoutParams(layoutParams);
            }
            if (this.fKl != null) {
                this.fKl.kE(false);
            }
            if (ac.yz() != null) {
                ac.yz().yy();
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.x.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.x.c) runTask.getData()).yy();
            }
            if (this.fKW != null && this.fKW.getLandscapeBarrageImageView() != null) {
                b(this.fKW.getLandscapeBarrageImageView(), this.fKz, false);
            }
            this.fKA.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.18
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.fKy) {
                        a.this.km(false);
                    }
                }
            }, 5000L);
            if (this.fLm != null) {
                this.fLm.yb();
            }
            if (this.fKm != null) {
                this.fKm.setCanVisible(false);
                this.fKm.bBC();
            }
        }
        if (this.fLn != null) {
            if (i3 == 2) {
                View yq = this.fLn.yq();
                if (yq != null) {
                    if (yq.getParent() != null && (yq.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) yq.getParent()).removeView(yq);
                    }
                    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams7.addRule(5, a.g.ala_liveroom_hostheader);
                    layoutParams7.addRule(3, a.g.ala_liveroom_hostheader);
                    layoutParams7.topMargin = bzh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                    if (this.fLJ != null) {
                        this.fLJ.addView(yq, layoutParams7);
                    }
                }
            } else {
                View yq2 = this.fLn.yq();
                if (yq2 != null) {
                    if (yq2.getParent() != null && (yq2.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) yq2.getParent()).removeView(yq2);
                    }
                    RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams8.topMargin = bzh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18) * (-1);
                    layoutParams8.addRule(3, a.g.ala_live_header_view);
                    bzh().fTn.addView(yq2, layoutParams8);
                }
            }
        }
        if (this.fKW != null) {
            this.fKW.l(i, i2, i3);
        }
        qR(i3);
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.fKh != null) {
                this.fKh.cu(i3);
            }
            if (this.fKj != null) {
                this.fKj.cu(i3);
            }
            if (this.fKn != null) {
                this.fKn.cu(i3);
            }
            if (this.fLq != null) {
                this.fLq.cu(i3);
            }
            if (this.fLz != null) {
                this.fLz.cu(i3);
            }
            if (this.fKB != null && this.fKB.isShowing()) {
                this.fKB.resize();
            }
            if (this.fLI != null) {
                this.fLI.cu(i3);
            }
        }
        if (this.fLm != null) {
            this.fLm.ya();
        }
        super.l(i, i2, i3);
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
            if (i != 7 || UtilHelper.getRealScreenOrientation(bzh().pageContext.getPageActivity()) != 2) {
                if (this.fKW != null) {
                    this.fKW.setVisibility(8);
                }
                if (this.fLk != null) {
                    this.fLk.CA().getView().setVisibility(4);
                }
                if (this.fLA != null) {
                    this.fLA.lp(false);
                }
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
            if (this.fLA != null) {
                this.fLA.lp(true);
            }
            if (!this.fKy || UtilHelper.getRealScreenOrientation(bzh().pageContext.getPageActivity()) != 2) {
                this.fLJ.setVisibility(0);
            }
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
        if (bzh() != null) {
            BdUtilHelper.hideSoftKeyPad(bzh().pageContext.getPageActivity(), bzh().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.fKk != null) {
            this.fKk.bFW();
        }
        if (this.fKp != null) {
            this.fKp.vx();
        }
        if (this.fKn != null) {
            this.fKn.onStart();
        }
    }

    private void qR(int i) {
        if (this.fKf != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fKf.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.bottomMargin = bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                layoutParams.height = bxK();
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds72) + 0 + bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds22) + bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                layoutParams.rightMargin = bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
                layoutParams.height = -2;
            }
            this.fKf.setLayoutParams(layoutParams);
        }
    }
}
