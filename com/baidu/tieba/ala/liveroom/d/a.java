package com.baidu.tieba.ala.liveroom.d;

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
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.h;
import com.baidu.live.challenge.i;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.ah;
import com.baidu.live.data.be;
import com.baidu.live.data.bo;
import com.baidu.live.data.bu;
import com.baidu.live.data.p;
import com.baidu.live.data.r;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.n;
import com.baidu.live.gift.z;
import com.baidu.live.guardclub.j;
import com.baidu.live.im.b.a;
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
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
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
import com.baidu.live.utils.q;
import com.baidu.tieba.ala.liveroom.exclusive.e;
import com.baidu.tieba.ala.liveroom.j.b;
import com.baidu.tieba.ala.liveroom.j.g;
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.turntable.d;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends b implements com.baidu.live.j.c, e {
    private PendantParentView bhK;
    private com.baidu.tieba.ala.liveroom.c.a gmA;
    private com.baidu.live.im.b.a gmB;
    private com.baidu.tieba.ala.liveroom.share.b gmC;
    private FrameLayout gmD;
    private FrameLayout gmE;
    private ImageView gmF;
    private com.baidu.live.tieba.e.b gmG;
    private z gmK;
    private com.baidu.tieba.ala.liveroom.j.b gmL;
    private com.baidu.tieba.ala.liveroom.audiencelist.c gmq;
    private com.baidu.tieba.ala.liveroom.o.a gmr;
    private com.baidu.tieba.ala.liveroom.g.b gms;
    private com.baidu.tieba.ala.liveroom.u.b gmt;
    private com.baidu.tieba.ala.liveroom.audiencelist.b gmu;
    private com.baidu.tieba.ala.liveroom.l.a gmv;
    private com.baidu.tieba.ala.liveroom.activeview.b gmw;
    private com.baidu.live.d.a gmx;
    private i gmy;
    private h gmz;
    private long lastClickTime = 0;
    private boolean gmH = false;
    private boolean gmI = false;
    private Handler gmJ = new Handler();
    private HttpRule gmM = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.gmy != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.gmy.BP()) {
                httpMessage.addParam("ala_challenge_id", a.this.gmy.BS());
            }
            return httpMessage;
        }
    };
    private HttpRule gmN = new HttpRule(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.ala.liveroom.d.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.gmy != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.gmy.BP()) {
                httpMessage.addParam("challenge_id", a.this.gmy.BS());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c gmO = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.19
        @Override // com.baidu.live.liveroom.g.c
        public void LA() {
            if (a.this.gnp != null) {
                a.this.gnp.mK(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void ce(boolean z) {
            if (z) {
                if (a.this.gnp != null) {
                    a.this.gnp.mK(true);
                }
            } else if (a.this.gnp != null) {
                a.this.gnp.mK(false);
            }
            if (a.this.gnH != null) {
                a.this.gnH.bl(z);
            }
            if (a.this.gmw != null) {
                a.this.gmw.lD(z ? false : true);
            }
        }
    };
    private HttpMessageListener gmP = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.d.a.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.LK() != null) {
                        com.baidu.live.w.c.Np().bkl = getQuickGiftHttpResponseMessage.LK();
                        a.this.bNu();
                    }
                }
            }
        }
    };
    private CustomMessageListener gmQ = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.d.a.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bNF();
        }
    };
    private CustomMessageListener gmR = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.d.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                a.this.gnx.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gmS = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.gnL != null) {
                    a.this.gnL.Go(str);
                }
            }
        }
    };
    CustomMessageListener gmT = new CustomMessageListener(2913113) { // from class: com.baidu.tieba.ala.liveroom.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.goc != null && a.this.goc.aXV != null && !a.this.goc.aXY && !a.this.goc.aXZ && a.this.gnG != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.bOG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = a.this.bOG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                a.this.gnG.b(a.this.gmD, layoutParams);
                if (com.baidu.live.guardclub.e.Il() != null) {
                    com.baidu.live.guardclub.e.Il().Ir();
                }
            }
        }
    };
    private CustomMessageListener gmU = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.d.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (a.this.gnJ != null) {
                    a.this.gnJ.dismiss();
                }
                com.baidu.live.im.b.d.JD().setSwitchStatus(true);
                com.baidu.live.im.b.d.JD().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bOh();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener gmV = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.d.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.gmL.c(a.this.bOG());
                } else if (a.this.bOb() || !g.ud(2913168)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.bOG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.bOG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    a.this.gmL.b(a.this.gmD, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gmW = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.d.a.10
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void m(View view, int i) {
            be beVar;
            bo boVar;
            bu buVar;
            String str;
            be beVar2;
            bo boVar2;
            String str2;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - a.this.lastClickTime >= 300) {
                a.this.lastClickTime = currentTimeMillis;
                if (i == 2 && a.this.Hu()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "gift_panel"));
                    a.this.K(-1, -1, -1);
                } else if (i == 13) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.w.c.Np().bkl.EN().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.w.c.Np().bkl.EN().DR());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.w.c.Np().bkl.EN().DS());
                        if (a.this.bOG().gxi.LC() != null && a.this.bOG().gxi.LC().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.bOG().gxi.LC().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.bOG().gxi.LC().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.JY());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.Hu()) {
                        if (com.baidu.live.c.AD().getBoolean("quick_gift_guide_show", true) && !a.this.bOb()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, z.class, a.this.bOG().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                z zVar = (z) runTask.getData();
                                zVar.setPageContext(a.this.bOG().pageContext);
                                zVar.d(a.this.bOG().gxi.LC());
                                zVar.setGiftItem(com.baidu.live.w.c.Np().bkl.EN());
                                zVar.setOtherParams(a.this.JY());
                                zVar.initView();
                                zVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.10.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        a.this.lK(false);
                                        a.this.gmK = null;
                                    }
                                });
                                a.this.gmK = zVar;
                                zVar.show();
                                a.this.lK(true);
                                return;
                            }
                            return;
                        }
                        n.a(a.this.bOG().pageContext, a.this.bOG().gxi.LC(), com.baidu.live.w.c.Np().bkl.EN(), a.this.JY());
                    }
                } else if (i == 1) {
                    if (a.this.gnu != null) {
                        a.this.bOh();
                    }
                } else if (i == 3 && a.this.Hu()) {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "share_clk"));
                    if (a.this.mOrientation == 2 && TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.gmC != null) {
                            a.this.gmC.A(a.this.bOG().gxi.LC());
                        }
                    } else {
                        a.this.gnh.c(a.this.bOG().gxi.LC(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.bOG() != null && a.this.bOG().gxi != null && a.this.bOG().gxi.LC() != null && a.this.bOG().gxi.LC().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.bOG().gxi.LC().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.bOG().gxi.LC().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.bOG().gxi.LC().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.JY());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.bOG() != null && a.this.bOG().gxi != null && a.this.bOG().gxi.LC() != null && a.this.bOG().gxi.LC().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.bOG().gxi.LC().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.bOG().gxi.LC().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.bOG().gxi.LC().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.JY());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.bek != null) {
                        a.this.bek.bY(false);
                    }
                } else if (i == 12) {
                    if (a.this.gnp != null) {
                        String valueOf = String.valueOf(a.this.bOG().gxi.LC().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.bOG().gxi.LC().mLiveInfo.room_id);
                        String str3 = null;
                        p pVar = a.this.bOG().gxi.LC().mLiveSdkInfo;
                        if (pVar != null && pVar.mCastIds != null) {
                            str3 = String.valueOf(a.this.bOG().gxi.LC().mLiveSdkInfo.mCastIds.aDY);
                        }
                        a.this.gnp.ai(valueOf, valueOf2, str3);
                        if (com.baidu.live.liveroom.a.KQ().KR()) {
                            a.this.bNF();
                        }
                    }
                } else if (i == 14) {
                    r LC = a.this.bOG().gxi.LC();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.bOG().pageContext.getPageActivity(), LC.aDG.userName, Long.toString(LC.aDG.userId), Long.toString(LC.aDG.charmCount), String.valueOf(LC.mLiveInfo.group_id), String.valueOf(LC.mLiveInfo.live_id), false, String.valueOf(LC.aDG.userId), Long.toString(LC.aEf.userId), LC.aEf.userName, LC.aEf.portrait, a.this.gmu.getCount(), a.this.JY())));
                    LogManager.getCommonLogger().doClickGusetNumLog(LC.mLiveInfo.feed_id, a.this.gmu.getCount() + "", a.this.JY());
                } else if (i == 11) {
                    a.this.bOk();
                    a.this.bOl();
                } else if (i == 16) {
                    if (a.this.bOG() != null && (beVar2 = com.baidu.live.w.a.Nk().bkd) != null && (boVar2 = beVar2.aJA) != null) {
                        String str4 = boVar2.aKw.aKD;
                        if (!TextUtils.isEmpty(str4)) {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quick_gift"));
                            long j = 0;
                            if (a.this.bOG().gxi != null && a.this.bOG().gxi.LC() != null && a.this.bOG().gxi.LC().mLiveInfo != null) {
                                j = a.this.bOG().gxi.LC().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j + "", a.this.bOG().gxi.LC().mLiveInfo.room_id + "", a.this.bOG().gxi.LC().mLiveInfo.feed_id, a.this.JY());
                            }
                            if (str4.contains("?")) {
                                str2 = str4 + "&liveId=" + j;
                            } else {
                                str2 = str4 + "?liveId=" + j;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.bOG().pageContext.getPageActivity(), str2);
                        }
                    }
                } else if (i == 20) {
                    if (a.this.bOG() != null) {
                        r rVar = null;
                        if (a.this.bOG().gxi != null) {
                            rVar = a.this.bOG().gxi.LC();
                        }
                        if (rVar != null && rVar.mLiveInfo != null && com.baidu.tieba.ala.liveroom.w.b.bWy().beU != null) {
                            String str5 = com.baidu.tieba.ala.liveroom.w.b.bWy().beU.aDi;
                            if (!TextUtils.isEmpty(str5)) {
                                if (str5.contains("?")) {
                                    str = str5 + "&live_id=" + rVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str5 + "?live_id=" + rVar.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(a.this.bOG().pageContext.getPageActivity(), str)));
                            }
                        }
                    }
                } else if (i == 17) {
                    if (a.this.Hu() && a.this.bOG() != null && (beVar = com.baidu.live.w.a.Nk().bkd) != null && (boVar = beVar.aJA) != null && (buVar = boVar.aKx) != null && !TextUtils.isEmpty(buVar.webUrl)) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "turntable"));
                        if (a.this.gnJ != null && a.this.bOG().gxi != null && a.this.bOG().gxi.LC() != null) {
                            r LC2 = a.this.bOG().gxi.LC();
                            a.this.gnJ.a(buVar.webUrl, LC2.mLiveInfo.live_id, LC2.aEf.userId, LC2.aDG.userId);
                            a.this.gmG.ct(false);
                            a.this.gmG.Oj();
                        }
                    }
                } else if (i == 18) {
                    if (a.this.gmI) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.gmI = !a.this.gmI;
                } else if (i == 19 && a.this.gmG != null) {
                    a.this.gmG.Oj();
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.gnj = new com.baidu.tieba.ala.liveroom.guide.c(bOG().pageContext, this, false);
        this.gmM.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.gmM);
        this.gmN.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.gmN);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean bNf() {
        return false;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void m(r rVar) {
        super.m(rVar);
        g.bRO();
        this.gmI = false;
        if (this.gnm != null) {
            this.gnm.b(this.gmW);
        }
        if (this.gmG == null) {
            this.gmG = new com.baidu.live.tieba.e.b(bOG().pageContext.getPageActivity());
            this.gmG.start();
        }
        this.gmG.ct(true);
        bOG().pageContext.getPageActivity().setRequestedOrientation(-1);
        bOG().gxj.setIsForceHandledTouch(false);
        bOG().gxj.setSwipeClearEnable(true);
        bOG().gxj.setOnLiveViewScrollListener(this.gmO);
        bOG().gxj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gmJ.removeCallbacksAndMessages(null);
                a.this.lG(false);
                if (!a.this.gmH) {
                    a.this.gmJ.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.gmH) {
                                a.this.lG(false);
                            }
                        }
                    }, 5000L);
                }
            }
        });
        if (this.gnV != null) {
            this.gnV.setVisibility(0);
        }
        bNl();
        if (this.gnE != null) {
            this.gnE.a(rVar, this.bhK);
            this.gnE.S(this.gnW);
            this.gnE.a(this);
        }
        bNx();
        bNX();
        bNy();
        bNk();
        bNC();
        bNz();
        bNg();
        lL(false);
        bOo();
        bOn();
        bNo();
        bNv();
        bNw();
        bOp();
        bNi();
        bNE();
        bNG();
        lM(true);
        bNn();
        bNu();
        bOy();
        bNp();
        bNq();
        bNr();
        bNs();
        bNH();
        bOu();
        bNh();
        bOx();
        if (this.gnJ != null && this.gnJ.bWG() == null) {
            this.gnJ.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.21
                @Override // com.baidu.tieba.ala.liveroom.turntable.d.a
                public void onDismiss() {
                    a.this.gmG.ct(true);
                }
            });
        }
        c(this.fxx);
        MessageManager.getInstance().registerListener(this.gmP);
        MessageManager.getInstance().registerListener(this.gmQ);
        MessageManager.getInstance().registerListener(this.gmT);
        MessageManager.getInstance().registerListener(this.gmU);
        MessageManager.getInstance().registerListener(this.gmV);
        MessageManager.getInstance().registerListener(this.gmS);
        MessageManager.getInstance().registerListener(this.gmR);
        bNI();
        bNB();
        if (this.mOrientation == 2) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(bOG().pageContext.getPageActivity());
            l(screenDimensions[0], screenDimensions[1], UtilHelper.getRealScreenOrientation(bOG().pageContext.getPageActivity()));
        }
        if (this.gnR != null) {
            this.gnR.u(rVar);
        }
    }

    private void bNg() {
        if (this.gnR == null) {
            View view = null;
            if (this.gnm != null && this.gnm.getView() != null) {
                view = this.gnm.getView();
            }
            this.gnR = new com.baidu.tieba.ala.liveroom.exclusive.b(bOG().pageContext, Lw(), bOG().gxj, view, this.gmq.gpn, this);
        }
    }

    private void bNh() {
        if (this.gnQ != null) {
            this.gnQ.a(new com.baidu.live.r.c() { // from class: com.baidu.tieba.ala.liveroom.d.a.22
                @Override // com.baidu.live.r.c
                public void ck(boolean z) {
                    if (a.this.gmz != null) {
                        a.this.gmz.setNeedCloseRecommendFloat(z);
                    }
                    if (a.this.bOG().gxj.gMa) {
                        if (a.this.gnp != null) {
                            a.this.gnp.mD(z);
                            a.this.gnp.mK(!z);
                        }
                        if (a.this.gnm != null) {
                            a.this.gnm.mD(z);
                            a.this.gnm.setPraiseEnable(!z);
                            a.this.gnm.mC(z ? false : true);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lG(boolean z) {
        View EV;
        if (bOG() != null && bOG().pageContext != null && bOG().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(bOG().pageContext.getPageActivity()) == 2 || z) {
                if (this.gnx != null && (EV = this.gnx.EV()) != null) {
                    if (this.gmH) {
                        EV.setVisibility(0);
                    } else {
                        EV.setVisibility(8);
                    }
                }
                if (this.gmH) {
                    if (this.gnV != null) {
                        this.gnV.setVisibility(0);
                    }
                    if (this.gnW != null) {
                        this.gnW.setVisibility(0);
                    }
                    if (this.bhK != null) {
                        this.bhK.setVisibility(0);
                    }
                    if (this.bhK != null) {
                        this.bhK.setVisibility(0);
                    }
                    if (this.gnw != null) {
                        this.gnw.bj(false);
                    }
                } else {
                    if (this.gnV != null) {
                        this.gnV.setVisibility(8);
                    }
                    if (this.gnW != null) {
                        this.gnW.setVisibility(8);
                    }
                    if (this.bhK != null) {
                        this.bhK.setVisibility(8);
                    }
                    if (this.bhK != null) {
                        this.bhK.setVisibility(8);
                    }
                    if (this.gnw != null) {
                        this.gnw.bj(true);
                    }
                }
                this.gmH = this.gmH ? false : true;
                if (this.gmw != null) {
                    this.gmw.lD(this.gmH);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, boolean z2) {
        ImageView imageView;
        View EE;
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view;
        }
        if (z) {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_off);
            }
            if (this.gmE != null) {
                this.gmE.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_on);
            }
            if (this.gmE != null) {
                this.gmE.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.gnw != null && (EE = this.gnw.EE()) != null) {
            if (z) {
                EE.setVisibility(8);
            } else {
                EE.setVisibility(0);
            }
        }
    }

    private void bNi() {
        CustomResponsedMessage runTask;
        if (this.gmB == null && (runTask = MessageManager.getInstance().runTask(2913164, com.baidu.live.im.b.a.class, bOG().pageContext)) != null) {
            this.gmB = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gmB != null) {
            this.gmB.setOtherParams(this.otherParams);
            this.gmB.a(new a.InterfaceC0175a() { // from class: com.baidu.tieba.ala.liveroom.d.a.23
                @Override // com.baidu.live.im.b.a.InterfaceC0175a
                public void JC() {
                    a.this.bOs();
                }
            });
        }
    }

    private void bNj() {
        if (this.gno != null) {
            this.gno.aw(bOG().gxh.getLiveContainerView());
        }
    }

    private void bNk() {
        if (this.gmC == null) {
            this.gmC = new com.baidu.tieba.ala.liveroom.share.b(bOG().pageContext);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void dD(int i) {
        super.dD(i);
        if (this.gmF != null && UtilHelper.getRealScreenOrientation(bOG().pageContext.getPageActivity()) != 2) {
            this.gmF.setVisibility(0);
        }
        bNj();
        if (this.gmz != null) {
            this.gmz.dD(i);
        }
        if (this.gmz == null || !this.gmz.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
        if (this.gnR != null) {
            this.gnR.bRm();
        }
    }

    private void bNl() {
        if (this.bhK == null) {
            PendantParentView.Model model = PendantParentView.Model.HORIZONTAL;
            if (this.mOrientation == 2) {
                model = PendantParentView.Model.HORIZONTAL_FULL;
            }
            this.bhK = new PendantParentView(bOG().pageContext.getPageActivity(), model);
            bOG().gxj.addView(this.bhK, ((bOG().gxj.getView() == null || this.gnm == null || this.gnm.getView() == null) ? -1 : bOG().gxj.getView().indexOfChild(this.gnm.getView())) + 1, new RelativeLayout.LayoutParams(-1, bNm()));
            this.bhK.setDefaultItemMargin(bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            I(this.mOrientation, false);
        }
    }

    private int bNm() {
        int bottom;
        int bottom2;
        if (bOG().ben.getLivePlayer().getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bOG().ben.getLivePlayer().getLayoutParams();
            bottom = layoutParams.topMargin + layoutParams.height;
        } else {
            bottom = bOG().ben.getLivePlayer().getBottom();
        }
        if (bOG().gxj.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) bOG().gxj.getLayoutParams();
            bottom2 = layoutParams2.topMargin + layoutParams2.height;
        } else {
            bottom2 = bOG().gxj.getBottom();
        }
        int i = 0;
        if (this.gnR != null) {
            i = this.gnR.getHeight();
        }
        return (((bottom2 - bottom) - i) - bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
    }

    private void bNn() {
        if (this.gmw == null) {
            this.gmw = new com.baidu.tieba.ala.liveroom.activeview.b(bOG().pageContext);
        }
        if (bOG() != null && bOG().gxi != null) {
            this.gmw.FM(bOG().gxi.bVR());
        }
        this.gmw.setOtherParams(JY());
        this.gmw.b(bOG().gxi.LC(), true);
        this.gmw.setHost(false);
        this.gmw.a(1, this.bhK);
        this.gmw.a(2, this.bhK);
        this.gmw.setVisible(this.gnZ ? 8 : 0);
    }

    private void bNo() {
        if (this.gnl != null && bOG() != null && bOG().gxi != null) {
            this.gnl.b(bOG().gxh.getLiveContainerView(), bOG().gxi.LC());
        }
    }

    private void bNp() {
        if (this.bhK != null) {
            if (this.gmv == null) {
                this.gmv = new com.baidu.tieba.ala.liveroom.l.a(bOG().pageContext, this);
            }
            this.gmv.setOtherParams(JY());
            this.gmv.a((ViewGroup) this.bhK, bNt());
            this.gmv.v(bOG().gxi.LC());
        }
    }

    private void bNq() {
        if (this.gnG == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, j.class, bOG().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gnG = (j) runTask.getData();
            } else {
                return;
            }
        }
        this.gnG.setOtherParams(JY());
        if (this.gmD != null && this.gmD.indexOfChild(this.gnG.getView()) >= 0) {
            this.gmD.removeView(this.gnG.getView());
        }
    }

    private void bNr() {
        if (this.gnf != null) {
            this.gnf.a(new a.InterfaceC0637a() { // from class: com.baidu.tieba.ala.liveroom.d.a.7
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0637a
                public void bK(int i, int i2) {
                    r LC = a.this.bOG().gxi.LC();
                    if (LC != null && LC.mLiveInfo != null) {
                        if (a.this.gnK == null) {
                            a.this.gnK = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.bOG().pageContext.getPageActivity());
                        }
                        a.this.gnK.d(a.this.gnW, i, i2);
                        a.this.gnK.a(String.valueOf(LC.mLiveInfo.live_id), new a.InterfaceC0641a() { // from class: com.baidu.tieba.ala.liveroom.d.a.7.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0641a
                            public void a(float f, String str) {
                                if (a.this.gnf != null) {
                                    a.this.gnf.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0637a
                public void bL(int i, int i2) {
                    if (a.this.gnK != null) {
                        a.this.gnK.bQ(i, i2);
                    }
                }
            });
        }
    }

    private void bNs() {
        if (this.gok == null) {
            this.gok = new com.baidu.tieba.ala.liveroom.j.e(bOG().pageContext);
        }
        this.gok.setRoomId(bOG().gxi.LC().mLiveInfo.room_id);
        this.gok.Ge("");
        this.gok.b(bOG().gxi.LC(), this.bhK);
        if (this.gmL == null) {
            this.gmL = new com.baidu.tieba.ala.liveroom.j.b(bOG().pageContext, JY(), this.gok, new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.8
                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bNR() {
                    a.this.lK(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.j.b.a
                public void bNS() {
                    a.this.lK(false);
                }
            });
        }
        this.gmL.setRoomId(bOG().gxi.LC().mLiveInfo.room_id);
        if (this.gmD != null && this.gmD.indexOfChild(this.gmL.getView()) >= 0) {
            this.gmD.removeView(this.gmL.getView());
        }
        if (this.gmL != null) {
            this.gmL.b(bOG());
        }
    }

    private LinearLayout.LayoutParams bNt() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = bOG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNu() {
        if (this.gnf == null) {
            bNz();
        }
        this.gnf.a(com.baidu.live.w.c.Np().bkl, bOG().gxi.LC());
    }

    private void bNv() {
        CustomResponsedMessage runTask;
        boolean z = true;
        if (this.gnu == null && (runTask = MessageManager.getInstance().runTask(2913039, k.class, bOG().pageContext)) != null && runTask.getData() != null) {
            this.gnu = (k) runTask.getData();
            this.gnu.setFromMaster(false);
            this.gnu.Jf().getView().setId(a.g.ala_liveroom_msg_list);
            this.gnu.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.9
                @Override // com.baidu.live.im.k.a
                public boolean Ji() {
                    return a.this.Hu();
                }

                @Override // com.baidu.live.im.k.a
                public void Jj() {
                    a.this.god = true;
                }

                @Override // com.baidu.live.im.k.a
                public void gR(String str) {
                    if (!a.this.gnZ) {
                        a.this.lI(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.bOG().pageContext.getPageActivity(), a.this.bOG().gxh.getLiveContainerView());
                    }
                    a.this.FS(str);
                }

                @Override // com.baidu.live.im.k.a
                public void Jk() {
                    if (a.this.gnZ) {
                        a.this.lI(true);
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.bOG().pageContext.getPageActivity(), a.this.bOG().gxh.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (a.this.gnu != null) {
                        a.this.gnu.Jg().setQuickInputPanelVisible(false);
                        a.this.gnu.Jg().Kz();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public void Jl() {
                    if (a.this.gnZ) {
                        a.this.bNQ();
                        if (a.this.gnv != null) {
                            a.this.gnv.Ba();
                        }
                        if (a.this.gmB != null) {
                            a.this.gmB.Ba();
                        }
                    } else if (a.this.gnu != null) {
                        a.this.gnu.Jg().setQuickInputPanelVisible(false);
                        a.this.gnu.Jg().Kz();
                    }
                }

                @Override // com.baidu.live.im.k.a
                public boolean Jm() {
                    return a.this.bOc();
                }

                @Override // com.baidu.live.im.k.a
                public int Jn() {
                    return a.this.bOd();
                }
            });
            this.gmD = new FrameLayout(bOG().pageContext.getPageActivity());
            this.gmD.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.gnu != null && this.gmD != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bOG().pageContext.getPageActivity()) * 0.7f);
            int i = com.baidu.live.ab.b.i(true, false);
            if (this.gnW.indexOfChild(this.gmD) < 0) {
                if (this.gmD.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gmD.getParent()).removeView(this.gmD);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                this.gnW.addView(this.gmD, layoutParams);
            }
            if (this.gmD.indexOfChild(this.gnu.Jf().getView()) < 0) {
                if (this.gnu.Jf().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gnu.Jf().getView()).removeView(this.gnu.Jf().getView());
                }
                if (UtilHelper.getRealScreenOrientation(bOG().pageContext.getPageActivity()) != 2) {
                    this.gmD.addView(this.gnu.Jf().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, i));
                }
            }
            if (bOG().gxj.indexOfChild(this.gnu.Jg().getView()) < 0) {
                if (this.gnu.Jg().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gnu.Jg().getView().getParent()).removeView(this.gnu.Jg().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bOi();
                bOG().gxj.addView(this.gnu.Jg().getView(), layoutParams2);
            }
            r LC = bOG().gxi.LC();
            if (LC != null && LC.mLiveInfo != null) {
                this.gnu.setLogData(LC.mLiveInfo.feed_id, JY());
            }
            if (LC == null || LC.aEs == null || !LC.aEs.Co()) {
                z = false;
            }
            this.gnu.a(String.valueOf(bOG().gxi.LC().mLiveInfo.group_id), String.valueOf(bOG().gxi.LC().mLiveInfo.last_msg_id), String.valueOf(bOG().gxi.LC().aDG.userId), String.valueOf(bOG().gxi.LC().mLiveInfo.live_id), bOG().gxi.LC().aDG.appId, z);
            lI(false);
        }
    }

    private void bNw() {
        if (this.gmE == null) {
            this.gmE = new FrameLayout(bOG().pageContext.getPageActivity());
            this.gmE.setId(a.g.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void bNx() {
        if (this.gmr == null) {
            this.gmr = new com.baidu.tieba.ala.liveroom.o.a(bOG().pageContext, false, this);
        }
        this.gmr.c(this.gnV, bOG().gxi.LC());
        this.gmr.a(this.gmW);
    }

    private void bNy() {
        if (this.gmq == null) {
            this.gmq = new com.baidu.tieba.ala.liveroom.audiencelist.c(bOG().pageContext, this, false);
        }
        this.gmq.a(String.valueOf(bOG().gxi.LC().mLiveInfo.group_id), String.valueOf(bOG().gxi.LC().mLiveInfo.live_id), String.valueOf(bOG().gxi.LC().aDG.userId), bOG().gxi.LC());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.gng != null && this.gng.getView() != null && this.gng.getView().getParent() != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.gmq.c(this.gnV, i, a.g.ala_liveroom_audience_count_layout);
            this.gmq.e(bOG().gxi.bIw());
        }
    }

    private void bNz() {
        com.baidu.live.core.a.a KO;
        if (this.gnf == null) {
            this.gnf = new com.baidu.tieba.ala.liveroom.operation.a(bOG().pageContext);
        }
        this.gnf.a(bOG(), this.gnW, bOG().gxi.LC().mLiveInfo, true, this.gmW);
        this.gnf.setOtherParams(JY());
        if (this.gnE != null && (KO = this.gnE.KO()) != null) {
            View rootLayout = KO.getRootLayout();
            if (rootLayout != null && rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.gnf.bO(rootLayout);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void bNA() {
        bNB();
    }

    private void bNB() {
        if (this.gnf != null) {
            int i = bOG().gxi.LC().aEf.isUegBlock;
            int i2 = bOG().gxi.LC().aEf.isBlock;
            String str = bOG().gxi.LC().aEf.userName;
            if (i > 0 || i2 > 0) {
                this.gnf.b(true, i, i2, str);
                this.gnu.a(true, i, i2, str);
                this.gnA.b(true, i, i2, str);
                return;
            }
            this.gnf.b(false, i, i2, str);
            this.gnu.a(false, i, i2, str);
            this.gnA.b(false, i, i2, str);
        }
    }

    private void bNC() {
        if (this.gmu == null) {
            this.gmu = new com.baidu.tieba.ala.liveroom.audiencelist.b(bOG().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (bOG().gxi.bIw() != null) {
            j = bOG().gxi.bIw().getCount();
        }
        this.gmu.a(this.gmW);
        this.gmu.a(this.gnV, a.g.ala_liveroom_hostheader, j);
        this.gmu.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.gmu.lT(false);
        } else {
            this.gmu.lT(true);
        }
    }

    public void bND() {
        this.gnh.c(bOG().gxi.LC(), false);
    }

    public void bNE() {
        if (bOG().gxi.LC() != null && bOG().gxi.LC().aDG != null && bOG().gxi.LC().mLiveInfo != null) {
            if (this.gmt == null) {
                this.gmt = new com.baidu.tieba.ala.liveroom.u.b(bOG().pageContext);
            }
            long j = bOG().gxi.LC().aDG.userId;
            int i = bOG().gxi.LC().mLiveInfo.live_type;
            String str = bOG().gxi.LC().aDG.portrait;
            String str2 = bOG().gxi.LC().mLiveInfo.feed_id;
            long j2 = bOG().gxi.LC().mLiveInfo.live_id;
            this.gmt.a(i, j, bOG().gxi.LC().aDG.userName, false, str, JY(), str2, j2);
            this.gmt.as(this.gnV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNF() {
        String str;
        if (bOG() != null && bOG().gxi != null && bOG().gxi.LC() != null && bOG().gxi.LC().aEf != null && (str = bOG().gxi.LC().aEf.userName) != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bOG().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !bOb()) {
            com.baidu.live.c.AD().putInt("guide_rename_show_count", com.baidu.live.c.AD().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.KQ().bX(true);
            if (this.gnN == null) {
                this.gnN = new com.baidu.tieba.ala.liveroom.v.a(bOG().pageContext);
            }
            this.gnN.setOtherParams(JY());
            this.gnN.e(this.gnW, bOG().gxi.LC());
            lK(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.12
                @Override // java.lang.Runnable
                public void run() {
                    a.this.gnN.bWn();
                    a.this.lK(false);
                }
            }, 5000L);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_SHOW);
                alaStaticItem.addParams("other_params", JY());
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    private void bNG() {
        boolean z = false;
        if (this.gnp == null) {
            this.gnp = new com.baidu.tieba.ala.liveroom.x.a(bOG().pageContext, this);
        }
        this.gnp.d(bOG().gxj, false);
        boolean bOF = bOF();
        AlaLiveInfoData alaLiveInfoData = bOG().gxi.LC().mLiveInfo;
        boolean isZanAnimUnabled = (alaLiveInfoData == null || alaLiveInfoData.mAlaLiveSwitchData == null) ? false : alaLiveInfoData.mAlaLiveSwitchData.isZanAnimUnabled();
        if (bOF && !isZanAnimUnabled) {
            z = true;
        }
        this.gnp.mJ(z);
    }

    private void bNH() {
        if (bOG() != null && bOG().ben != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(bOG().pageContext.getPageActivity());
            Activity pageActivity = bOG().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + pageActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds176)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.gmF = new ImageView(bOG().pageContext.getPageActivity());
            this.gmF.setVisibility(8);
            this.gmF.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.gmF.setImageResource(a.f.icon_live_enlarge);
            this.gmF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.gmG != null) {
                        a.this.gmG.Oi();
                        a.this.gmF.setVisibility(4);
                    }
                }
            });
            bOG().gxj.addView(this.gmF, layoutParams);
            if (UtilHelper.getRealScreenOrientation(bOG().pageContext.getPageActivity()) != 2) {
                if (bOG().gxo) {
                    this.gmF.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.14
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.gmF != null && UtilHelper.getRealScreenOrientation(a.this.bOG().pageContext.getPageActivity()) != 2) {
                                a.this.gmF.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
        }
    }

    private void bNI() {
        if (this.god || this.goe) {
            if ((TbadkCoreApplication.isLogin() && this.gnu.Jg().hasText()) || this.goe) {
                this.god = false;
                this.goe = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.15
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bOh();
                    }
                }, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void r(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        super.r(aVar);
        if (this.gmw != null) {
            this.gmw.y(aVar);
        }
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
                if (this.gmv != null) {
                    this.gmv.I(jSONObject);
                }
            } else if ("enter_live".equals(optString)) {
                if (this.gmu != null && this.gmu.getCount() > 20) {
                    this.gmu.dO(this.gmu.getCount() + 1);
                } else if (this.gmq != null) {
                    com.baidu.live.data.a JK = aVar.JK();
                    com.baidu.live.data.j jVar = new com.baidu.live.data.j();
                    jVar.aDH = new AlaLocationData();
                    jVar.aDI = new AlaRelationData();
                    jVar.aDG = new AlaLiveUserInfoData();
                    jVar.aDG.userId = JavaTypesHelper.toLong(JK.userId, 0L);
                    jVar.aDG.userName = JK.userName;
                    jVar.aDG.portrait = JK.portrait;
                    if (this.gmu != null && this.gmq.c(jVar)) {
                        this.gmu.dO(this.gmu.getCount() + 1);
                    }
                }
            } else if ("update_liveinfo".equals(optString)) {
                if (bOG().gxi.LC() != null && bOG().gxi.LC().mLiveInfo != null) {
                    bOG().gxi.a(bOG().gxi.LC().mLiveInfo.live_id, bOG().fromType, bOG().enterTime);
                }
            } else if ("challenge_mvp".equals(optString) && bOG().gxi.LC() != null && bOG().gxi.LC().mLiveInfo != null && bOG().gxi.LC().aEf != null && this.gmz != null) {
                long optLong = jSONObject.optLong("mvp_user_id");
                long optLong2 = jSONObject.optLong("winner_live_id");
                if (optLong == bOG().gxi.LC().aEf.userId && optLong2 == bOG().gxi.LC().mLiveInfo.live_id) {
                    this.gmz.c(jSONObject.optInt("challenge_status"), jSONObject.optLong("challenge_id"));
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void FO(String str) {
        if (this.gmw != null) {
            this.gmw.FO(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(r rVar) {
        super.k(rVar);
        if (this.gmr != null) {
            this.gmr.w(rVar);
        }
        if (this.gms != null) {
            this.gms.s(rVar);
        }
        if (this.gmv != null) {
            this.gmv.v(rVar);
        }
        if (this.gmz != null) {
            this.gmz.a(rVar);
        }
        if (this.gmB != null) {
            this.gmB.a(rVar);
        }
        if (this.gmw != null) {
            this.gmw.j(rVar);
            if (rVar != null && this.gnS != null && !this.gnS.hasInit && !TextUtils.isEmpty(this.gnS.aJU)) {
                this.gnS.hasInit = true;
                this.gmw.FP(this.gnS.aJU);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(com.baidu.live.data.k kVar) {
        if (kVar != null) {
            if (this.gmq != null && kVar.getList() != null) {
                this.gmq.e(kVar);
            }
            if (this.gmu != null) {
                this.gmu.dO(kVar.getCount());
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void cd(boolean z) {
        super.cd(z);
        if (bOG().gxj != null) {
            bOG().gxj.bXk();
            bOG().gxj.setLiveViewOnDispatchTouchEventListener(null);
            bOG().gxj.setLiveViewOnTouchEventListener(null);
            bOG().gxj.setOnLiveViewScrollListener(null);
        }
        if (bOG().ben != null) {
            bOG().ben.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.gmz != null) {
            this.gmz.BB();
        }
        bNJ();
        if (this.gmt != null) {
            this.gmt.BB();
        }
        if (this.gnp != null) {
            this.gnp.release();
        }
        if (this.gmv != null) {
            this.gmv.BB();
        }
        if (this.gnf != null) {
            this.gnf.bVU();
        }
        if (this.gms != null) {
            this.gms.bQN();
            this.gms.setVisible(8);
        }
        if (this.gmx != null) {
            this.gmx.BB();
        }
        if (this.gmw != null) {
            this.gmw.release();
        }
        if (this.bhK != null) {
            this.bhK.removeAllViews();
            this.bhK = null;
        }
        if (this.gmy != null) {
            this.gmy.BB();
        }
        if (this.gmB != null) {
            this.gmB.a((a.InterfaceC0175a) null);
            this.gmB.Bb();
        }
        if (this.gmF != null && (this.gmF.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gmF.getParent()).removeView(this.gmF);
        }
        if (this.gmC != null) {
            this.gmC.dismiss();
        }
        if (this.gmG != null) {
            this.gmG.ct(false);
            this.gmG.Oj();
        }
        if (this.gmL != null) {
            this.gmL.BB();
        }
        if (this.gok != null) {
            this.gok.bPK();
        }
        if (this.gnU != null) {
            this.gnU.BB();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void n(r rVar) {
        View AZ;
        super.n(rVar);
        if (this.gmB != null && (AZ = this.gmB.AZ()) != null && AZ.getParent() != null) {
            ((ViewGroup) AZ.getParent()).removeView(AZ);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.gmB != null) {
            this.gmB.setOtherParams(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cb(boolean z) {
        super.cb(z);
        this.gmJ.removeCallbacksAndMessages(null);
        bNJ();
        this.gmH = false;
        this.gmI = false;
        if (this.gmr != null) {
            this.gmr.onDestroy();
        }
        if (this.gmt != null) {
            this.gmt.onDestroy();
        }
        if (this.gmv != null) {
            this.gmv.onDestroy();
        }
        if (this.gmx != null) {
            this.gmx.onDestroy();
        }
        if (this.gmy != null) {
            this.gmy.onDestroy();
        }
        if (this.gmz != null) {
            this.gmz.onDestroy();
        }
        if (this.gmA != null) {
            this.gmA.onDestroy();
        }
        if (this.gmC != null) {
            this.gmC.onDestroy();
        }
        if (this.gms != null) {
            this.gms.onDestroy();
        }
        if (this.gmG != null) {
            this.gmG.stop();
        }
        if (this.gnp != null) {
            this.gnp.onDestroy();
        }
        if (this.gmq != null) {
            this.gmq.onDestroy();
        }
        if (this.gnu != null) {
            this.gnu.onDestroy();
        }
        if (this.gnf != null) {
            this.gnf.onDestory();
        }
        if (this.gmB != null) {
            this.gmB.a((a.InterfaceC0175a) null);
            this.gmB.release();
            this.gmB = null;
        }
        if (this.gok != null) {
            this.gok.cb(z ? false : true);
        }
        if (this.gmL != null) {
            this.gmL.onDestroy();
            this.gmL = null;
        }
        if (this.gnU != null) {
            this.gnU.onDestroy();
        }
        MessageManager.getInstance().removeMessageRule(this.gmM);
        MessageManager.getInstance().removeMessageRule(this.gmN);
        MessageManager.getInstance().unRegisterListener(this.gmP);
        MessageManager.getInstance().unRegisterListener(this.gmQ);
        MessageManager.getInstance().unRegisterListener(this.gmT);
        MessageManager.getInstance().unRegisterListener(this.gmU);
        MessageManager.getInstance().unRegisterListener(this.gmV);
        MessageManager.getInstance().unRegisterListener(this.gmS);
        MessageManager.getInstance().unRegisterListener(this.gmR);
    }

    private void bNJ() {
        if (this.gnu != null && this.gnu.Jf().getView() != null && this.gnu.Jf().getView().getParent() != null) {
            ((ViewGroup) this.gnu.Jf().getView().getParent()).removeView(this.gnu.Jf().getView());
        }
        if (this.gmD != null && this.gmD.getParent() != null) {
            ((ViewGroup) this.gmD.getParent()).removeView(this.gmD);
        }
        if (this.gmE != null && this.gmE.getParent() != null) {
            ((ViewGroup) this.gmE.getParent()).removeView(this.gmE);
        }
        if (this.gnu != null && this.gnu.Jg().getView() != null) {
            this.gnW.removeView(this.gnu.Jg().getView());
        }
        if (this.gnu != null) {
            this.gnu.Jf().setMsgData(new LinkedList());
            this.gnu.Bb();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void a(ah ahVar) {
        if (this.gnu != null) {
            bOh();
            this.gnu.Jg().setEditText(" @" + ahVar.getNameShow() + " ");
        }
        if (this.gnf != null) {
            this.gnf.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void g(com.baidu.live.data.a aVar) {
        if (this.gnu != null) {
            bOh();
            this.gnu.Jg().setEditText(" @" + aVar.getNameShow() + " ");
        }
        if (this.gnf != null) {
            this.gnf.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected void b(ah ahVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected View bNK() {
        if (this.gnu != null) {
            return this.gnu.Jg().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public boolean bNL() {
        if (this.gnu == null || !this.gnu.Jg().Ky()) {
            return false;
        }
        lI(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected boolean bNM() {
        return this.gmr == null || this.gmr.bNM();
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected ViewGroup bNN() {
        return this.bhK;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    protected ViewGroup bNO() {
        return null;
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
                    this.goa = false;
                    K(intExtra, intExtra2, intExtra3);
                    return;
                }
                bND();
                return;
            }
            aob();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.gnZ;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(bOG().pageContext.getPageActivity()) || z2) {
            lH(z);
        }
    }

    private void lH(boolean z) {
        if (this.gnu != null && this.gnu.Jf() != null) {
            this.gnu.Jf().onKeyboardVisibilityChanged(z);
        }
        if (z || this.gnu == null || !this.gnu.Jg().Ky()) {
            if (z) {
                if (this.gnf != null) {
                    this.gnf.setVisibility(8);
                }
                if (this.gnw != null && this.gnw.EE() != null) {
                    this.gnw.EE().setVisibility(8);
                }
                bNQ();
                if (this.gnu != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gnu.Jg().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.gnu.Jg().getView().setLayoutParams(layoutParams);
                    this.gnu.Jg().getView().setVisibility(0);
                    this.gnu.Jg().setQuickInputPanelVisible(false);
                }
                if (this.gnV != null) {
                    this.gnV.setVisibility(8);
                }
                if (this.gmw != null) {
                    this.gmw.setVisible(8);
                }
                if (this.gnv != null) {
                    this.gnv.Ba();
                }
                if (this.gnT != null) {
                    this.gnT.setCanVisible(false);
                }
                if (this.gnP != null) {
                    this.gnP.setCanVisible(false);
                }
            } else {
                bNP();
            }
            if (this.gnu != null && this.gmD != null) {
                if (this.gnW.indexOfChild(this.gmD) != -1 && this.gmD.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gmD.getLayoutParams();
                    layoutParams2.height = com.baidu.live.ab.b.i(true, z);
                    this.gmD.setLayoutParams(layoutParams2);
                }
                if (this.gmD.indexOfChild(this.gnu.Jf().getView()) != -1 && this.gnu.Jf().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.gnu.Jf().getView().getLayoutParams();
                    layoutParams3.height = com.baidu.live.ab.b.i(true, z);
                    this.gnu.Jf().getView().setLayoutParams(layoutParams3);
                }
                this.gnu.Jf().Je();
            }
        }
    }

    private void bNP() {
        if (this.gnf != null) {
            this.gnf.setVisibility(0);
        }
        if (this.gmD != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gmD.getLayoutParams();
            layoutParams.bottomMargin = bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            this.gmD.setLayoutParams(layoutParams);
        }
        if (this.gnu != null) {
            bOi();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gnu.Jg().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.gnu.Jg().getView().setLayoutParams(layoutParams2);
        }
        if (this.gnf != null) {
            this.gnf.setVisibility(0);
        }
        if (this.gnw != null && this.gnw.EE() != null) {
            this.gnw.EE().setVisibility(0);
        }
        if (this.gnV != null && (!this.gmH || UtilHelper.getRealScreenOrientation(bOG().pageContext.getPageActivity()) != 2)) {
            this.gnV.setVisibility(0);
        }
        if (this.gmw != null) {
            this.gmw.setVisible(0);
        }
        if (this.gnv != null) {
            this.gnv.Ba();
        }
        if (this.gnT != null) {
            this.gnT.setCanVisible(true);
        }
        if (this.gnP != null) {
            this.gnP.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNQ() {
        boolean z;
        boolean z2 = false;
        if (this.gmD != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gmD.getLayoutParams();
            if (this.gnu == null || this.gnu.Jg() == null) {
                z = false;
            } else {
                z = this.gnu.Jg().Kw();
                z2 = this.gnu.Jg().Kx();
            }
            int J = J(z, z2);
            if (layoutParams.bottomMargin != J) {
                layoutParams.bottomMargin = J;
                this.gmD.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lI(boolean z) {
        if (z) {
            this.gnu.Jg().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gmD.getLayoutParams();
            int quickInputPanelExpandHeight = this.gnu.Jg().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.gmD.setLayoutParams(layoutParams);
                if (this.gnu.Jf() != null) {
                    this.gnu.Jf().Je();
                    return;
                }
                return;
            }
            return;
        }
        bNP();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        FrameLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = bOG().pageContext.getPageActivity();
        if (i3 == 1) {
            if (bOG().pageContext.getPageActivity() != null && !UtilHelper.canUseStyleImmersiveSticky()) {
                q.e(bOG().pageContext.getPageActivity(), true);
            }
            if (this.gnV != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.gnV.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.gmC != null) {
                this.gmC.dismiss();
            }
            if (this.gmB != null) {
                this.gmB.a((a.InterfaceC0175a) null);
                this.gmB.Bb();
            }
            if (this.bek != null) {
                this.bek.e(true, true);
            }
            if (this.gmF != null) {
                this.gmF.setVisibility(0);
                this.gmF.bringToFront();
            }
            if (this.gnk != null) {
                this.gnk.setVisibility(0);
            }
            if (this.gnu != null && this.gnu.Jf().getView().getParent() != null && (this.gnu.Jf().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gnu.Jf().getView().getParent()).removeView(this.gnu.Jf().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bOG().pageContext.getPageActivity()) * 0.7f);
            int i4 = com.baidu.live.ab.b.i(true, false);
            if (this.gmD != null && this.gnu != null) {
                this.gmD.addView(this.gnu.Jf().getView(), 0, new FrameLayout.LayoutParams(equipmentWidth, i4));
            }
            if (this.gmE != null && (this.gmE.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gmE.getParent()).removeView(this.gmE);
            }
            if (this.gnv != null) {
                this.gnv.a(bOG().gxi.LC(), false);
                this.gnv.a(new a.InterfaceC0175a() { // from class: com.baidu.tieba.ala.liveroom.d.a.16
                    @Override // com.baidu.live.im.b.a.InterfaceC0175a
                    public void JC() {
                        a.this.bOs();
                    }
                });
                View AZ = this.gnv.AZ();
                if (AZ != null && this.gnW != null && AZ.getParent() == null) {
                    Resources resources = bOG().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bOG().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds98));
                    layoutParams5.addRule(2, a.g.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                    this.gnW.addView(AZ, layoutParams5);
                }
            }
            if (this.gnm != null) {
                this.gnm.setPraiseEnable(true);
                bOG().gxj.gMa = true;
            }
            if (this.gmq != null && this.gmq.gpo != null && (layoutParams3 = (FrameLayout.LayoutParams) this.gmq.gpo.getLayoutParams()) != null) {
                layoutParams3.width = -2;
                this.gmq.gpo.setLayoutParams(layoutParams3);
            }
            if (this.gnp != null) {
                this.gnp.bXJ();
            }
            if (this.gmH) {
                lG(true);
            }
            if (this.gmI) {
                if (this.gnf != null && this.gnf.getLandscapeBarrageImageView() != null) {
                    b(this.gnf.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.gnf != null) {
                this.gnf.uC(0);
            }
            if (this.gmu != null) {
                this.gmu.lS(true);
            }
            this.gmJ.removeCallbacksAndMessages(null);
            if (this.gmv != null) {
                this.gmv.setCanVisible(true);
                this.gmv.v(bOG().gxi.LC());
            }
        } else if (i3 == 2) {
            if (bOG().pageContext.getPageActivity() != null && !UtilHelper.canUseStyleImmersiveSticky()) {
                q.e(bOG().pageContext.getPageActivity(), false);
            }
            if (this.gnp != null) {
                this.gnp.bXK();
            }
            if (this.gnV != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.gnV.getLayoutParams()) != null) {
                layoutParams2.topMargin = bOG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
            }
            if (this.gnv != null) {
                this.gnv.a((a.InterfaceC0175a) null);
                this.gnv.Bb();
            }
            bOG().gxj.bXm();
            if (this.bek != null) {
                this.bek.e(false, true);
            }
            if (this.gmF != null) {
                this.gmF.setVisibility(4);
            }
            if (this.gnu != null && this.gnu.Jf().getView().getParent() != null && (this.gnu.Jf().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gnu.Jf().getView().getParent()).removeView(this.gnu.Jf().getView());
            }
            int max = Math.max(i, i2);
            if (this.gmE != null) {
                if (this.gmE.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.gmE.getParent()).removeView(this.gmE);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
                bOG().gxj.addView(this.gmE, this.bhK != null ? bOG().gxj.indexOfChild(this.bhK) : -1, layoutParams6);
            }
            if (this.gmE != null && this.gmB != null) {
                this.gmB.a(bOG().gxi.LC(), false);
                this.gmB.a(new a.InterfaceC0175a() { // from class: com.baidu.tieba.ala.liveroom.d.a.17
                    @Override // com.baidu.live.im.b.a.InterfaceC0175a
                    public void JC() {
                        a.this.bOs();
                    }
                });
                View AZ2 = this.gmB.AZ();
                if (AZ2 != null && this.gmE.indexOfChild(AZ2) < 0) {
                    this.gmE.addView(AZ2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bOG().pageContext.getPageActivity()), -1));
                }
            }
            if (this.gnm != null) {
                this.gnm.az(bOG().gxj);
                this.gnm.setPraiseEnable(false);
                bOG().gxj.gMa = false;
            }
            if (this.gmq != null && this.gmq.gpo != null && (layoutParams = (FrameLayout.LayoutParams) this.gmq.gpo.getLayoutParams()) != null) {
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                layoutParams.width = (int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f);
                this.gmq.gpo.setLayoutParams(layoutParams);
            }
            if (this.gnf != null) {
                this.gnf.uC(8);
            }
            if (this.gmu != null) {
                this.gmu.lS(false);
            }
            if (ac.Fe() != null) {
                ac.Fe().Fd();
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.y.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.y.c) runTask.getData()).Fd();
            }
            if (this.gnf != null && this.gnf.getLandscapeBarrageImageView() != null) {
                b(this.gnf.getLandscapeBarrageImageView(), this.gmI, false);
            }
            this.gmJ.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.18
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.gmH) {
                        a.this.lG(false);
                    }
                }
            }, 5000L);
            if (this.gnw != null) {
                this.gnw.EG();
            }
            if (this.gmv != null) {
                this.gmv.setCanVisible(false);
                this.gmv.bRS();
            }
        }
        if (this.gnx != null) {
            if (i3 == 2) {
                View EV = this.gnx.EV();
                if (EV != null) {
                    if (EV.getParent() != null && (EV.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) EV.getParent()).removeView(EV);
                    }
                    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams7.addRule(5, a.g.ala_liveroom_hostheader);
                    layoutParams7.addRule(3, a.g.ala_liveroom_hostheader);
                    layoutParams7.topMargin = bOG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                    if (this.gnV != null) {
                        this.gnV.addView(EV, layoutParams7);
                    }
                }
            } else {
                View EV2 = this.gnx.EV();
                if (EV2 != null) {
                    if (EV2.getParent() != null && (EV2.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) EV2.getParent()).removeView(EV2);
                    }
                    RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams8.topMargin = bOG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18) * (-1);
                    layoutParams8.addRule(3, a.g.ala_live_header_view);
                    bOG().gxj.addView(EV2, layoutParams8);
                }
            }
        }
        if (this.gnf != null) {
            this.gnf.l(i, i2, i3);
        }
        I(i3, true);
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.gmq != null) {
                this.gmq.dz(i3);
            }
            if (this.gms != null) {
                this.gms.dz(i3);
            }
            if (this.gmw != null) {
                this.gmw.dz(i3);
            }
            if (this.gnE != null) {
                this.gnE.dz(i3);
            }
            if (this.gnA != null) {
                this.gnA.dz(i3);
            }
            if (this.gnJ != null) {
                this.gnJ.dz(i3);
            }
            if (this.gmK != null && this.gmK.isShowing()) {
                this.gmK.resize();
            }
            if (this.gnT != null) {
                this.gnT.dz(i3);
            }
            if (this.gnU != null) {
                this.gnU.dz(i3);
            }
            if (this.gnR != null) {
                this.gnR.eD(i3);
            }
        }
        if (this.gnw != null) {
            this.gnw.EF();
        }
        super.l(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public boolean ey(int i) {
        boolean ey = super.ey(i);
        if (ey && 2 == i) {
            if (this.gmr.bNM()) {
                return false;
            }
            if (ey && this.gnp != null) {
                this.gnp.mK(false);
            }
        }
        return ey;
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b
    public void tQ(int i) {
        super.tQ(i);
        if (i == 7 || i == 11) {
            if (i != 7 || UtilHelper.getRealScreenOrientation(bOG().pageContext.getPageActivity()) != 2) {
                if (this.gnf != null) {
                    this.gnf.setVisibility(8);
                }
                if (this.gnu != null) {
                    this.gnu.Jf().getView().setVisibility(4);
                }
                if (this.gnK != null) {
                    this.gnK.mF(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.a.a
    public void ez(int i) {
        super.ez(i);
        if (i == 7 || i == 11) {
            if (this.gnf != null) {
                this.gnf.setVisibility(0);
            }
            if (this.gnu != null) {
                this.gnu.Jf().getView().setVisibility(0);
            }
            if (this.gnK != null) {
                this.gnK.mF(true);
            }
            if (!this.gmH || UtilHelper.getRealScreenOrientation(bOG().pageContext.getPageActivity()) != 2) {
                this.gnV.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.gmt != null) {
            this.gmt.bWl();
        }
        if (this.gmy != null) {
            this.gmy.BJ();
        }
        if (this.gmw != null) {
            this.gmw.onStop();
        }
        if (bOG() != null) {
            BdUtilHelper.hideSoftKeyPad(bOG().pageContext.getPageActivity(), bOG().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.d.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.gmt != null) {
            this.gmt.bWk();
        }
        if (this.gmy != null) {
            this.gmy.BK();
        }
        if (this.gmw != null) {
            this.gmw.onStart();
        }
        if (this.gnR != null) {
            this.gnR.onStart();
        }
    }

    private void I(int i, boolean z) {
        if (this.bhK != null) {
            int dimensionPixelSize = bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bhK.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                layoutParams.rightMargin = bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.height = bNm();
                this.bhK.setPosition(dimensionPixelSize, 0, dimensionPixelSize, 0);
                if (z) {
                    this.gnl.lF(true);
                }
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                int dimensionPixelSize2 = bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds72) + 0 + bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100) + bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
                layoutParams.height = -1;
                this.bhK.setPosition(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
                this.gnl.lF(false);
            }
            layoutParams.bottomMargin = bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            this.bhK.setLayoutParams(layoutParams);
            this.bhK.setModel(i == 1 ? PendantParentView.Model.HORIZONTAL : PendantParentView.Model.HORIZONTAL_FULL);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.e
    public void tR(int i) {
        I(this.mOrientation, false);
    }
}
