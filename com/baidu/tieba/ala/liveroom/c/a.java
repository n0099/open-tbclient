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
import com.baidu.live.data.ap;
import com.baidu.live.data.ay;
import com.baidu.live.data.be;
import com.baidu.live.data.h;
import com.baidu.live.data.m;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.n;
import com.baidu.live.gift.x;
import com.baidu.live.guardclub.e;
import com.baidu.live.im.i;
import com.baidu.live.im.j;
import com.baidu.live.im.k;
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
import com.baidu.live.u.a;
import com.baidu.live.utils.o;
import com.baidu.live.view.PriorityVerticalLinearLayout;
import com.baidu.tieba.ala.liveroom.h.b;
import com.baidu.tieba.ala.liveroom.h.g;
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.turntable.d;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends b {
    private com.baidu.tieba.ala.liveroom.audiencelist.c eRA;
    private com.baidu.tieba.ala.liveroom.l.a eRB;
    private com.baidu.tieba.ala.liveroom.e.b eRC;
    private com.baidu.tieba.ala.liveroom.r.b eRD;
    private com.baidu.tieba.ala.liveroom.operation.a eRE;
    private com.baidu.tieba.ala.liveroom.audiencelist.b eRF;
    private com.baidu.tieba.ala.liveroom.j.a eRG;
    private com.baidu.tieba.ala.liveroom.activeview.b eRH;
    private com.baidu.live.d.a eRI;
    private j eRJ;
    private i eRK;
    private com.baidu.tieba.ala.liveroom.attentionpop.b eRL;
    private com.baidu.live.im.j eRM;
    private com.baidu.tieba.ala.liveroom.share.b eRN;
    private FrameLayout eRO;
    private FrameLayout eRP;
    private ImageView eRQ;
    private com.baidu.live.tieba.e.b eRR;
    private x eRV;
    private com.baidu.tieba.ala.liveroom.h.b eRW;
    private PriorityVerticalLinearLayout eRy;
    private LinearLayout eRz;
    private long lastClickTime = 0;
    private boolean eRS = false;
    private boolean eRT = false;
    private Handler eRU = new Handler();
    private HttpRule eRX = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.eRJ != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.eRJ.qf()) {
                httpMessage.addParam("ala_challenge_id", a.this.eRJ.qi());
            }
            return httpMessage;
        }
    };
    private HttpRule eRY = new HttpRule(1021151) { // from class: com.baidu.tieba.ala.liveroom.c.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.eRJ != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.eRJ.qf()) {
                httpMessage.addParam("challenge_id", a.this.eRJ.qi());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c eRZ = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.c.a.17
        @Override // com.baidu.live.liveroom.g.c
        public void yR() {
            if (a.this.eSy != null) {
                a.this.eSy.jT(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bg(boolean z) {
            if (z) {
                if (a.this.eRE != null) {
                    a.this.eRE.qB(8);
                }
                if (a.this.eSy != null) {
                    a.this.eSy.jT(true);
                }
            } else {
                if (a.this.eRE != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                        a.this.eRE.qB(0);
                    } else {
                        a.this.eRE.qB(8);
                    }
                }
                if (a.this.eSy != null) {
                    a.this.eSy.jT(false);
                }
            }
            if (a.this.eSP != null) {
                a.this.eSP.aB(z);
            }
        }
    };
    private HttpMessageListener eSa = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.a.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.zb() != null) {
                        com.baidu.live.v.c.zx().ayb = getQuickGiftHttpResponseMessage.zb();
                        a.this.biH();
                    }
                }
            }
        }
    };
    private CustomMessageListener eSb = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.a.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.biQ();
        }
    };
    private CustomMessageListener eSc = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.c.a.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.eST != null) {
                    a.this.eST.yS(str);
                }
            }
        }
    };
    CustomMessageListener eSd = new CustomMessageListener(CmdConfigCustom.CMD_HOST_GET_WALLET_UA) { // from class: com.baidu.tieba.ala.liveroom.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.eTh != null && a.this.eTh.aqi != null && !a.this.eTh.aql && !a.this.eTh.aqm && a.this.eSO != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.bjO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = a.this.bjO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                a.this.eSO.b(a.this.eRO, layoutParams);
                if (e.vL() != null) {
                    e.vL().vR();
                }
            }
        }
    };
    private CustomMessageListener eSe = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (a.this.eSR != null) {
                    a.this.eSR.dismiss();
                }
                k.wF().setSwitchStatus(true);
                k.wF().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bjq();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener eSf = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.eRW.c(a.this.bjO());
                } else if (a.this.bjk() || !g.qc(2913168)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, 3000L);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.bjO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.bjO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    a.this.eRW.b(a.this.eRO, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b eSg = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.a.8
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void m(View view, int i) {
            ap apVar;
            ay ayVar;
            be beVar;
            ap apVar2;
            ay ayVar2;
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - a.this.lastClickTime >= 300) {
                a.this.lastClickTime = currentTimeMillis;
                if (i == 2 && a.this.vc()) {
                    a.this.J(-1, -1, -1);
                } else if (i == 13) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.v.c.zx().ayb.sz().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.v.c.zx().ayb.sz().rC());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.v.c.zx().ayb.sz().rD());
                        if (a.this.bjO().faT.yT() != null && a.this.bjO().faT.yT().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.bjO().faT.yT().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.bjO().faT.yT().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.xC());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.vc()) {
                        if (com.baidu.live.c.pw().getBoolean("quick_gift_guide_show", true) && !a.this.bjk()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, x.class, a.this.bjO().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                x xVar = (x) runTask.getData();
                                xVar.setPageContext(a.this.bjO().pageContext);
                                xVar.d(a.this.bjO().faT.yT());
                                xVar.a(com.baidu.live.v.c.zx().ayb.sz());
                                xVar.setOtherParams(a.this.xC());
                                xVar.initView();
                                xVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.8.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        a.this.iX(false);
                                        a.this.eRV = null;
                                    }
                                });
                                a.this.eRV = xVar;
                                xVar.show();
                                a.this.iX(true);
                                return;
                            }
                            return;
                        }
                        n.a(a.this.bjO().pageContext, a.this.bjO().faT.yT(), com.baidu.live.v.c.zx().ayb.sz(), a.this.xC());
                    }
                } else if (i == 1) {
                    if (a.this.eSC != null) {
                        a.this.bjq();
                    }
                } else if (i == 3 && a.this.vc()) {
                    if (a.this.mOrientation == 2 && TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.eRN != null) {
                            a.this.eRN.x(a.this.bjO().faT.yT());
                        }
                    } else {
                        a.this.eSr.c(a.this.bjO().faT.yT(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.bjO() != null && a.this.bjO().faT != null && a.this.bjO().faT.yT() != null && a.this.bjO().faT.yT().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.bjO().faT.yT().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.bjO().faT.yT().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.bjO().faT.yT().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.xC());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.bjO() != null && a.this.bjO().faT != null && a.this.bjO().faT.yT() != null && a.this.bjO().faT.yT().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.bjO().faT.yT().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.bjO().faT.yT().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.bjO().faT.yT().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.xC());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.awq != null) {
                        a.this.awq.bb(false);
                    }
                } else if (i == 12) {
                    if (a.this.eSy != null) {
                        String valueOf = String.valueOf(a.this.bjO().faT.yT().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.bjO().faT.yT().mLiveInfo.room_id);
                        String str2 = null;
                        com.baidu.live.data.k kVar = a.this.bjO().faT.yT().mLiveSdkInfo;
                        if (kVar != null && kVar.mCastIds != null) {
                            str2 = String.valueOf(a.this.bjO().faT.yT().mLiveSdkInfo.mCastIds.Yh);
                        }
                        a.this.eSy.ad(valueOf, valueOf2, str2);
                        if (com.baidu.live.liveroom.a.yr().ys()) {
                            a.this.biQ();
                        }
                    }
                } else if (i == 14) {
                    m yT = a.this.bjO().faT.yT();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.bjO().pageContext.getPageActivity(), yT.Ya.userName, Long.toString(yT.Ya.userId), Long.toString(yT.Ya.charmCount), String.valueOf(yT.mLiveInfo.group_id), String.valueOf(yT.mLiveInfo.live_id), false, String.valueOf(yT.Ya.userId), Long.toString(yT.Yo.userId), yT.Yo.userName, yT.Yo.portrait, a.this.eRF.getCount(), a.this.xC())));
                    LogManager.getCommonLogger().doClickGusetNumLog(yT.mLiveInfo.feed_id, a.this.eRF.getCount() + "", a.this.xC());
                } else if (i == 11) {
                    a.this.bjt();
                    a.this.bju();
                } else if (i == 15) {
                    if (a.this.eSM != null && a.this.bjO() != null && a.this.bjO().faT != null && a.this.bjO().faT.yT() != null && a.this.bjO().faT.yT().mLiveInfo != null) {
                        long j = a.this.bjO().faT.yT().mLiveInfo.live_id;
                        String valueOf3 = String.valueOf(a.this.bjO().faT.yT().mLiveInfo.feed_id);
                        long j2 = a.this.bjO().faT.yT().mLiveInfo.room_id;
                        String str3 = a.this.bjO().faT.yT().mLiveInfo.cover;
                        String str4 = "";
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        if (a.this.bjO().faT.yT().mLiveInfo.session_info != null) {
                            str4 = a.this.bjO().faT.yT().mLiveInfo.session_info.flvUrl;
                        }
                        if (!TextUtils.isEmpty(a.this.xC())) {
                            try {
                                JSONObject jSONObject = new JSONObject(a.this.xC());
                                str5 = jSONObject.optString("tab");
                                str6 = jSONObject.optString("tag");
                                str7 = jSONObject.optString("source");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        a.this.eSM.yS(o.a(valueOf3, j + "", j2, false, 1, str3, str4, str5, str6, str7));
                        o.aEf = j;
                        if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                            ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                            LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf3, a.this.xC());
                        }
                    }
                } else if (i == 16) {
                    if (a.this.bjO() != null && (apVar2 = com.baidu.live.v.a.zs().axR) != null && (ayVar2 = apVar2.adc) != null) {
                        String str8 = ayVar2.adZ.aeg;
                        if (!TextUtils.isEmpty(str8)) {
                            long j3 = 0;
                            if (a.this.bjO().faT != null && a.this.bjO().faT.yT() != null && a.this.bjO().faT.yT().mLiveInfo != null) {
                                j3 = a.this.bjO().faT.yT().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j3 + "", a.this.bjO().faT.yT().mLiveInfo.room_id + "", a.this.bjO().faT.yT().mLiveInfo.feed_id, a.this.xC());
                            }
                            if (str8.contains("?")) {
                                str = str8 + "&liveId=" + j3;
                            } else {
                                str = str8 + "?liveId=" + j3;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.bjO().pageContext.getPageActivity(), str);
                        }
                    }
                } else if (i == 17) {
                    if (a.this.vc() && a.this.bjO() != null && (apVar = com.baidu.live.v.a.zs().axR) != null && (ayVar = apVar.adc) != null && (beVar = ayVar.aea) != null && !TextUtils.isEmpty(beVar.webUrl) && a.this.eSR != null && a.this.bjO().faT != null && a.this.bjO().faT.yT() != null) {
                        m yT2 = a.this.bjO().faT.yT();
                        a.this.eSR.a(beVar.webUrl, yT2.mLiveInfo.live_id, yT2.Yo.userId, yT2.Ya.userId);
                        a.this.eRR.bo(false);
                        a.this.eRR.Aj();
                    }
                } else if (i == 18) {
                    if (a.this.eRT) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.eRT = !a.this.eRT;
                } else if (i == 19 && a.this.eRR != null) {
                    a.this.eRR.Aj();
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.eSt = new com.baidu.tieba.ala.liveroom.guide.c(bjO().pageContext, this, false);
        this.eRX.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.eRX);
        this.eRY.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.eRY);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean bis() {
        return false;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void k(m mVar) {
        super.k(mVar);
        g.bmh();
        this.eRT = false;
        if (this.eSw != null) {
            this.eSw.b(this.eSg);
        }
        if (this.eRR == null) {
            this.eRR = new com.baidu.live.tieba.e.b(bjO().pageContext.getPageActivity());
            this.eRR.start();
        }
        this.eRR.bo(true);
        bjO().pageContext.getPageActivity().setRequestedOrientation(-1);
        bjO().faU.setIsForceHandledTouch(false);
        bjO().faU.setSwipeClearEnable(true);
        bjO().faU.setOnLiveViewScrollListener(this.eRZ);
        bjO().faU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eRU.removeCallbacksAndMessages(null);
                a.this.iS(false);
                if (!a.this.eRS) {
                    a.this.eRU.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.eRS) {
                                a.this.iS(false);
                            }
                        }
                    }, 5000L);
                }
            }
        });
        if (this.eTa != null) {
            this.eTa.setVisibility(0);
        }
        biw();
        biz();
        biK();
        bjg();
        biL();
        biv();
        biN();
        biM();
        iT(false);
        bjx();
        bjw();
        biB();
        biI();
        biJ();
        bjz();
        bit();
        biP();
        biR();
        iY(true);
        biA();
        biH();
        bjF();
        biC();
        biD();
        biE();
        biF();
        biS();
        bjE();
        if (this.eSR != null && this.eSR.bqI() == null) {
            this.eSR.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.19
                @Override // com.baidu.tieba.ala.liveroom.turntable.d.a
                public void onDismiss() {
                    a.this.eRR.bo(true);
                }
            });
        }
        MessageManager.getInstance().registerListener(this.eSa);
        MessageManager.getInstance().registerListener(this.eSb);
        MessageManager.getInstance().registerListener(this.eSd);
        MessageManager.getInstance().registerListener(this.eSe);
        MessageManager.getInstance().registerListener(this.eSf);
        MessageManager.getInstance().registerListener(this.eSc);
        biT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iS(boolean z) {
        View sH;
        if (bjO() != null && bjO().pageContext != null && bjO().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(bjO().pageContext.getPageActivity()) == 2 || z) {
                if (this.eSF != null && (sH = this.eSF.sH()) != null) {
                    if (this.eRS) {
                        sH.setVisibility(0);
                    } else {
                        sH.setVisibility(8);
                    }
                }
                if (this.eRS) {
                    if (this.eTa != null) {
                        this.eTa.setVisibility(0);
                    }
                    if (this.eTb != null) {
                        this.eTb.setVisibility(0);
                    }
                    if (this.eRz != null) {
                        this.eRz.setVisibility(0);
                    }
                    if (this.eRy != null) {
                        this.eRy.setVisibility(0);
                    }
                    if (this.eSE != null) {
                        this.eSE.az(false);
                    }
                } else {
                    if (this.eTa != null) {
                        this.eTa.setVisibility(8);
                    }
                    if (this.eTb != null) {
                        this.eTb.setVisibility(8);
                    }
                    if (this.eRz != null) {
                        this.eRz.setVisibility(8);
                    }
                    if (this.eRy != null) {
                        this.eRy.setVisibility(8);
                    }
                    if (this.eSE != null) {
                        this.eSE.az(true);
                    }
                }
                this.eRS = this.eRS ? false : true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, boolean z2) {
        ImageView imageView;
        View sq;
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view;
        }
        if (z) {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_off);
            }
            if (this.eRP != null) {
                this.eRP.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_on);
            }
            if (this.eRP != null) {
                this.eRP.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.eSE != null && (sq = this.eSE.sq()) != null) {
            if (z) {
                sq.setVisibility(8);
            } else {
                sq.setVisibility(0);
            }
        }
    }

    private void bit() {
        CustomResponsedMessage runTask;
        if (this.eRM == null && (runTask = MessageManager.getInstance().runTask(2913164, com.baidu.live.im.j.class, bjO().pageContext)) != null) {
            this.eRM = (com.baidu.live.im.j) runTask.getData();
        }
        if (this.eRM != null) {
            this.eRM.setOtherParams(this.otherParams);
            this.eRM.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.20
                @Override // com.baidu.live.im.j.a
                public void wE() {
                    a.this.bjC();
                }
            });
        }
    }

    private void biu() {
        if (this.eSx != null) {
            this.eSx.aj(bjO().faS.getLiveContainerView());
        }
    }

    private void biv() {
        if (this.eRN == null) {
            this.eRN = new com.baidu.tieba.ala.liveroom.share.b(bjO().pageContext);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bk(int i) {
        super.bk(i);
        if (this.eRQ != null && UtilHelper.getRealScreenOrientation(bjO().pageContext.getPageActivity()) != 2) {
            this.eRQ.setVisibility(0);
        }
        biu();
        if (this.eRK != null) {
            this.eRK.bk(i);
        }
        if (this.eRK == null || !this.eRK.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void iT(boolean z) {
        super.iT(z);
        this.eSE.br(bjO().faT.yT().mLiveInfo.screen_direction);
    }

    private void biw() {
        if (this.eRy == null) {
            this.eRy = new PriorityVerticalLinearLayout(bjO().pageContext.getPageActivity());
            this.eRy.setDefaultItemMargin(bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            biy();
        }
        if (this.eRy.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, bix());
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            layoutParams.rightMargin = bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
            layoutParams.bottomMargin = bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
            bjO().faU.addView(this.eRy, layoutParams);
        }
    }

    private int bix() {
        int bottom;
        int bottom2;
        if (bjO().awt.getLivePlayer().getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bjO().awt.getLivePlayer().getLayoutParams();
            bottom = layoutParams.topMargin + layoutParams.height;
        } else {
            bottom = bjO().awt.getLivePlayer().getBottom();
        }
        if (bjO().faU.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) bjO().faU.getLayoutParams();
            bottom2 = layoutParams2.topMargin + layoutParams2.height;
        } else {
            bottom2 = bjO().faU.getBottom();
        }
        return ((bottom2 - bottom) - bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
    }

    private void biy() {
        View view = new View(bjO().pageContext.getPageActivity());
        view.setTag(a.g.sdk_pvl_layout_priority_tag_key, 20);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(1, 0);
        layoutParams.weight = 1.0f;
        this.eRy.addView(view, layoutParams);
    }

    private void biz() {
        if (this.eRz == null) {
            this.eRz = new LinearLayout(bjO().pageContext.getPageActivity());
            this.eRz.setOrientation(1);
        }
        if (this.eRz.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds228);
            layoutParams.leftMargin = bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bjO().faU.addView(this.eRz, layoutParams);
        }
    }

    private void biA() {
        if (this.eRH == null) {
            this.eRH = new com.baidu.tieba.ala.liveroom.activeview.b(bjO().pageContext);
        }
        this.eRH.setOtherParams(xC());
        this.eRH.b(bjO().faT.yT(), true);
        this.eRH.setHost(false);
        this.eRH.a(1, this.eRy, pS(1));
        this.eRH.a(2, this.eRy, pS(2));
        this.eRH.setVisible(this.eTe ? 8 : 0);
    }

    private void biB() {
        if (this.eSv != null && bjO() != null && bjO().faT != null) {
            this.eSv.b(this.eTa, bjO().faT.yT());
        }
    }

    private ViewGroup.LayoutParams pS(int i) {
        switch (i) {
            case 1:
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = bjO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds40);
                return layoutParams;
            case 2:
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 5;
                layoutParams2.topMargin = bjO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                return layoutParams2;
            default:
                return new RelativeLayout.LayoutParams(-1, -2);
        }
    }

    private void biC() {
        if (this.eRy != null) {
            if (this.eRG == null) {
                this.eRG = new com.baidu.tieba.ala.liveroom.j.a(bjO().pageContext, this);
            }
            this.eRG.setOtherParams(xC());
            this.eRG.d(this.eRy, biG());
            this.eRG.t(bjO().faT.yT());
        }
    }

    private void biD() {
        if (this.eSO == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, com.baidu.live.guardclub.j.class, bjO().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.eSO = (com.baidu.live.guardclub.j) runTask.getData();
            } else {
                return;
            }
        }
        this.eSO.setOtherParams(xC());
        if (this.eRO != null && this.eRO.indexOfChild(this.eSO.getView()) >= 0) {
            this.eRO.removeView(this.eSO.getView());
        }
    }

    private void biE() {
        if (this.eRE != null) {
            this.eRE.a(new a.InterfaceC0465a() { // from class: com.baidu.tieba.ala.liveroom.c.a.5
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0465a
                public void bm(int i, int i2) {
                    m yT = a.this.bjO().faT.yT();
                    if (yT != null && yT.mLiveInfo != null) {
                        if (a.this.eSS == null) {
                            a.this.eSS = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.bjO().pageContext.getPageActivity());
                        }
                        a.this.eSS.d(a.this.eTb, i, i2);
                        a.this.eSS.a(String.valueOf(yT.mLiveInfo.live_id), new a.InterfaceC0467a() { // from class: com.baidu.tieba.ala.liveroom.c.a.5.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0467a
                            public void a(float f, String str) {
                                if (a.this.eRE != null) {
                                    a.this.eRE.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0465a
                public void bn(int i, int i2) {
                    if (a.this.eSS != null) {
                        a.this.eSS.bs(i, i2);
                    }
                }
            });
        }
    }

    private void biF() {
        if (this.eTp == null) {
            this.eTp = new com.baidu.tieba.ala.liveroom.h.e(bjO().pageContext);
        }
        this.eTp.setRoomId(bjO().faT.yT().mLiveInfo.room_id);
        this.eTp.zb("");
        this.eTp.a(bjO().faT.yT(), this.eRy);
        if (this.eRW == null) {
            this.eRW = new com.baidu.tieba.ala.liveroom.h.b(bjO().pageContext, xC(), this.eTp, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.6
                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void bjc() {
                    a.this.iX(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void bjd() {
                    a.this.iX(false);
                }
            });
        }
        this.eRW.setRoomId(bjO().faT.yT().mLiveInfo.room_id);
        if (this.eRO != null && this.eRO.indexOfChild(this.eRW.getView()) >= 0) {
            this.eRO.removeView(this.eRW.getView());
        }
        if (this.eRW != null) {
            this.eRW.b(bjO());
        }
    }

    private ViewGroup.LayoutParams biG() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = bjO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biH() {
        if (this.eRE == null) {
            biM();
        }
        this.eRE.a(com.baidu.live.v.c.zx().ayb, bjO().faT.yT());
    }

    private void biI() {
        CustomResponsedMessage runTask;
        if (this.eSC == null && (runTask = MessageManager.getInstance().runTask(2913039, com.baidu.live.im.i.class, bjO().pageContext)) != null && runTask.getData() != null) {
            this.eSC = (com.baidu.live.im.i) runTask.getData();
            this.eSC.setFromMaster(false);
            this.eSC.wv().getView().setId(a.g.ala_liveroom_msg_list);
            this.eSC.a(new i.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.7
                @Override // com.baidu.live.im.i.a
                public boolean wx() {
                    return a.this.vc();
                }

                @Override // com.baidu.live.im.i.a
                public void wy() {
                    a.this.eTi = true;
                }

                @Override // com.baidu.live.im.i.a
                public void dL(String str) {
                    if (!a.this.eTe) {
                        a.this.iV(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.bjO().pageContext.getPageActivity(), a.this.bjO().faS.getLiveContainerView());
                    }
                    a.this.yP(str);
                }

                @Override // com.baidu.live.im.i.a
                public void wz() {
                    if (a.this.eTe) {
                        a.this.iV(true);
                        a.this.bjO().faS.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.bjO().pageContext.getPageActivity(), a.this.bjO().faS.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (a.this.eSC != null) {
                        a.this.eSC.ww().setQuickInputPanelVisible(false);
                        a.this.eSC.ww().xW();
                    }
                }

                @Override // com.baidu.live.im.i.a
                public void wA() {
                    if (a.this.eTe) {
                        a.this.bjb();
                        if (a.this.eSD != null) {
                            a.this.eSD.wD();
                        }
                        if (a.this.eRM != null) {
                            a.this.eRM.wD();
                        }
                    } else if (a.this.eSC != null) {
                        a.this.eSC.ww().setQuickInputPanelVisible(false);
                        a.this.eSC.ww().xW();
                    }
                }

                @Override // com.baidu.live.im.i.a
                public boolean wB() {
                    return a.this.bjl();
                }
            });
            this.eRO = new FrameLayout(bjO().pageContext.getPageActivity());
            this.eRO.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.eSC != null && this.eRO != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bjO().pageContext.getPageActivity()) * 0.75f);
            int dimensionPixelSize = bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds120) + ((int) (BdUtilHelper.getEquipmentHeight(bjO().pageContext.getPageActivity()) * 0.33f));
            if (this.eTb.indexOfChild(this.eRO) < 0) {
                if (this.eRO.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eRO.getParent()).removeView(this.eRO);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                this.eTb.addView(this.eRO, layoutParams);
            }
            if (this.eRO.indexOfChild(this.eSC.wv().getView()) < 0) {
                if (this.eSC.wv().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eSC.wv().getView()).removeView(this.eSC.wv().getView());
                }
                if (UtilHelper.getRealScreenOrientation(bjO().pageContext.getPageActivity()) != 2) {
                    this.eRO.addView(this.eSC.wv().getView(), new FrameLayout.LayoutParams(equipmentWidth, dimensionPixelSize));
                }
            }
            if (bjO().faU.indexOfChild(this.eSC.ww().getView()) < 0) {
                if (this.eSC.ww().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eSC.ww().getView().getParent()).removeView(this.eSC.ww().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bjr();
                bjO().faU.addView(this.eSC.ww().getView(), layoutParams2);
            }
            m yT = bjO().faT.yT();
            if (yT != null && yT.mLiveInfo != null) {
                this.eSC.setLogData(yT.mLiveInfo.feed_id, xC());
            }
            this.eSC.e(String.valueOf(bjO().faT.yT().mLiveInfo.group_id), String.valueOf(bjO().faT.yT().mLiveInfo.last_msg_id), String.valueOf(bjO().faT.yT().Ya.userId), String.valueOf(bjO().faT.yT().mLiveInfo.live_id), bjO().faT.yT().Ya.appId);
            iV(false);
        }
    }

    private void biJ() {
        if (this.eRP == null) {
            this.eRP = new FrameLayout(bjO().pageContext.getPageActivity());
            this.eRP.setId(a.g.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void biK() {
        if (this.eRB == null) {
            this.eRB = new com.baidu.tieba.ala.liveroom.l.a(bjO().pageContext, false, this);
        }
        this.eRB.c(this.eTa, bjO().faT.yT());
        this.eRB.a(this.eSg);
    }

    private void biL() {
        if (this.eRA == null) {
            this.eRA = new com.baidu.tieba.ala.liveroom.audiencelist.c(bjO().pageContext, this, false);
        }
        this.eRA.a(String.valueOf(bjO().faT.yT().mLiveInfo.group_id), String.valueOf(bjO().faT.yT().mLiveInfo.live_id), String.valueOf(bjO().faT.yT().Ya.userId), bjO().faT.yT());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.eSq != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.eRA.c(this.eTa, i, a.g.ala_liveroom_audience_count_layout);
            this.eRA.f(bjO().faT.bee());
        }
    }

    private void biM() {
        if (this.eRE == null) {
            this.eRE = new com.baidu.tieba.ala.liveroom.operation.a(bjO().pageContext);
        }
        this.eRE.a(bjO(), this.eTb, bjO().faT.yT().mLiveInfo.live_type, true, this.eSg);
        this.eRE.setOtherParams(xC());
    }

    private void biN() {
        if (this.eRF == null) {
            this.eRF = new com.baidu.tieba.ala.liveroom.audiencelist.b(bjO().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (bjO().faT.bee() != null) {
            j = bjO().faT.bee().getCount();
        }
        this.eRF.a(this.eSg);
        this.eRF.a(this.eTa, a.g.ala_liveroom_audience, j);
        this.eRF.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.eRF.jk(false);
        } else {
            this.eRF.jk(true);
        }
    }

    public void biO() {
        this.eSr.c(bjO().faT.yT(), false);
    }

    public void biP() {
        if (bjO().faT.yT() != null && bjO().faT.yT().Ya != null && bjO().faT.yT().mLiveInfo != null) {
            if (this.eRD == null) {
                this.eRD = new com.baidu.tieba.ala.liveroom.r.b(bjO().pageContext);
            }
            long j = bjO().faT.yT().Ya.userId;
            int i = bjO().faT.yT().mLiveInfo.live_type;
            String str = bjO().faT.yT().Ya.portrait;
            String str2 = bjO().faT.yT().mLiveInfo.feed_id;
            long j2 = bjO().faT.yT().mLiveInfo.live_id;
            this.eRD.a(i, j, bjO().faT.yT().Ya.userName, false, str, xC(), str2, j2);
            this.eRD.ag(this.eTa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biQ() {
        String str;
        if (bjO() != null && bjO().faT != null && bjO().faT.yT() != null && bjO().faT.yT().Yo != null && (str = bjO().faT.yT().Yo.userName) != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bjO().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !bjk()) {
            com.baidu.live.c.pw().putInt("guide_rename_show_count", com.baidu.live.c.pw().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.yr().ba(true);
            if (this.eSV == null) {
                this.eSV = new com.baidu.tieba.ala.liveroom.s.a(bjO().pageContext);
            }
            this.eSV.setOtherParams(xC());
            this.eSV.e(this.eTb, bjO().faT.yT());
            iX(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eSV.bqv();
                    a.this.iX(false);
                }
            }, 5000L);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_SHOW);
                alaStaticItem.addParams("other_params", xC());
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    private void biR() {
        if (this.eSy == null) {
            this.eSy = new com.baidu.tieba.ala.liveroom.u.a(bjO().pageContext, this);
        }
        this.eSy.d(bjO().faU, false);
        this.eSy.jS(bjN());
    }

    private void biS() {
        if (bjO() != null && bjO().awt != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(bjO().pageContext.getPageActivity());
            Activity pageActivity = bjO().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + pageActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds176)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.eRQ = new ImageView(bjO().pageContext.getPageActivity());
            this.eRQ.setVisibility(8);
            this.eRQ.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.eRQ.setImageResource(a.f.icon_live_enlarge);
            this.eRQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.eRR != null) {
                        a.this.eRR.Ai();
                        a.this.eRQ.setVisibility(4);
                    }
                }
            });
            bjO().faU.addView(this.eRQ, layoutParams);
            if (UtilHelper.getRealScreenOrientation(bjO().pageContext.getPageActivity()) != 2) {
                if (bjO().faZ) {
                    this.eRQ.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.12
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.eRQ != null && UtilHelper.getRealScreenOrientation(a.this.bjO().pageContext.getPageActivity()) != 2) {
                                a.this.eRQ.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
        }
    }

    private void biT() {
        if (this.eTi || this.eTj) {
            if ((TbadkCoreApplication.isLogin() && this.eSC.ww().hasText()) || this.eTj) {
                this.eTi = false;
                this.eTj = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bjq();
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
                if (this.eRG != null) {
                    this.eRG.u(jSONObject);
                }
            } else if ("enter_live".equals(optString)) {
                if (this.eRF.getCount() > 20) {
                    this.eRF.cD(this.eRF.getCount() + 1);
                } else if (this.eRA != null) {
                    com.baidu.live.data.a xt = aVar.xt();
                    com.baidu.live.data.g gVar = new com.baidu.live.data.g();
                    gVar.Yb = new AlaLocationData();
                    gVar.Yc = new AlaRelationData();
                    gVar.Ya = new AlaLiveUserInfoData();
                    gVar.Ya.userId = JavaTypesHelper.toLong(xt.userId, 0L);
                    gVar.Ya.userName = xt.userName;
                    gVar.Ya.portrait = xt.portrait;
                    if (this.eRA.c(gVar)) {
                        this.eRF.cD(this.eRF.getCount() + 1);
                    }
                }
            } else if ("update_liveinfo".equals(optString) && bjO().faT.yT() != null && bjO().faT.yT().mLiveInfo != null) {
                bjO().faT.a(bjO().faT.yT().mLiveInfo.live_id, bjO().fromType, bjO().enterTime);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void yL(String str) {
        if (this.eRH != null) {
            this.eRH.yL(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void i(m mVar) {
        super.i(mVar);
        if (this.eRB != null) {
            this.eRB.u(mVar);
        }
        if (this.eRC != null) {
            this.eRC.q(mVar);
        }
        if (this.eRG != null) {
            this.eRG.t(mVar);
        }
        if (this.eRK != null) {
            this.eRK.a(mVar);
        }
        if (this.eRM != null) {
            this.eRM.a(mVar);
        }
        if (this.eRH != null) {
            this.eRH.h(mVar);
            if (mVar != null && this.eSY != null && !this.eSY.hasInit && !TextUtils.isEmpty(this.eSY.adw)) {
                this.eSY.hasInit = true;
                this.eRH.yM(this.eSY.adw);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(h hVar) {
        if (hVar != null) {
            if (this.eRA != null && hVar.getList() != null) {
                this.eRA.f(hVar);
            }
            if (this.eRF != null) {
                this.eRF.cD(hVar.getCount());
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void bf(boolean z) {
        super.bf(z);
        if (bjO().faU != null) {
            bjO().faU.brg();
            bjO().faU.setLiveViewOnDispatchTouchEventListener(null);
            bjO().faU.setOnLiveViewScrollListener(null);
        }
        if (bjO().awt != null) {
            bjO().awt.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.eRK != null) {
            this.eRK.pP();
        }
        biU();
        if (this.eRD != null) {
            this.eRD.pP();
        }
        if (this.eSy != null) {
            this.eSy.release();
        }
        if (this.eRG != null) {
            this.eRG.pP();
        }
        if (this.eRE != null) {
            this.eRE.bqb();
        }
        if (this.eRC != null) {
            this.eRC.blA();
            this.eRC.setVisible(8);
        }
        if (this.eRI != null) {
            this.eRI.pP();
        }
        if (this.eRH != null) {
            this.eRH.release();
        }
        if (this.eRy != null) {
            this.eRy.removeAllViews();
            this.eRy = null;
        }
        if (this.eRz != null) {
            this.eRz.removeAllViews();
            this.eRz = null;
        }
        if (this.eRJ != null) {
            this.eRJ.pP();
        }
        if (this.eRM != null) {
            this.eRM.a((j.a) null);
            this.eRM.wb();
        }
        if (this.eRQ != null && (this.eRQ.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.eRQ.getParent()).removeView(this.eRQ);
        }
        if (this.eRN != null) {
            this.eRN.dismiss();
        }
        if (this.eRR != null) {
            this.eRR.bo(false);
            this.eRR.Aj();
        }
        if (this.eRW != null) {
            this.eRW.pP();
        }
        if (this.eTp != null) {
            this.eTp.bkF();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void l(m mVar) {
        View wC;
        super.l(mVar);
        if (this.eRM != null && (wC = this.eRM.wC()) != null && wC.getParent() != null) {
            ((ViewGroup) wC.getParent()).removeView(wC);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.eRM != null) {
            this.eRM.setOtherParams(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void be(boolean z) {
        super.be(z);
        this.eRU.removeCallbacksAndMessages(null);
        biU();
        this.eRS = false;
        this.eRT = false;
        if (this.eRB != null) {
            this.eRB.onDestroy();
        }
        if (this.eRD != null) {
            this.eRD.onDestroy();
        }
        if (this.eRG != null) {
            this.eRG.onDestroy();
        }
        if (this.eRI != null) {
            this.eRI.onDestroy();
        }
        if (this.eRJ != null) {
            this.eRJ.onDestroy();
        }
        if (this.eRK != null) {
            this.eRK.onDestroy();
        }
        if (this.eRL != null) {
            this.eRL.onDestroy();
        }
        if (this.eRN != null) {
            this.eRN.onDestroy();
        }
        if (this.eRC != null) {
            this.eRC.onDestroy();
        }
        if (this.eRR != null) {
            this.eRR.stop();
        }
        if (this.eSy != null) {
            this.eSy.onDestroy();
        }
        if (this.eRA != null) {
            this.eRA.onDestroy();
        }
        if (this.eSC != null) {
            this.eSC.onDestroy();
        }
        if (this.eRE != null) {
            this.eRE.onDestory();
        }
        if (this.eRM != null) {
            this.eRM.a((j.a) null);
            this.eRM.release();
            this.eRM = null;
        }
        if (this.eTp != null) {
            this.eTp.be(z ? false : true);
        }
        MessageManager.getInstance().removeMessageRule(this.eRX);
        MessageManager.getInstance().removeMessageRule(this.eRY);
        MessageManager.getInstance().unRegisterListener(this.eSa);
        MessageManager.getInstance().unRegisterListener(this.eSb);
        MessageManager.getInstance().unRegisterListener(this.eSd);
        MessageManager.getInstance().unRegisterListener(this.eSe);
        MessageManager.getInstance().unRegisterListener(this.eSf);
        MessageManager.getInstance().unRegisterListener(this.eSc);
    }

    private void biU() {
        if (this.eSC != null && this.eSC.wv().getView() != null && this.eSC.wv().getView().getParent() != null) {
            ((ViewGroup) this.eSC.wv().getView().getParent()).removeView(this.eSC.wv().getView());
        }
        if (this.eRO != null && this.eRO.getParent() != null) {
            ((ViewGroup) this.eRO.getParent()).removeView(this.eRO);
        }
        if (this.eRP != null && this.eRP.getParent() != null) {
            ((ViewGroup) this.eRP.getParent()).removeView(this.eRP);
        }
        if (this.eSC != null && this.eSC.ww().getView() != null) {
            this.eTb.removeView(this.eSC.ww().getView());
        }
        if (this.eSC != null) {
            this.eSC.wv().setMsgData(new LinkedList());
            this.eSC.wb();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void a(com.baidu.live.data.x xVar) {
        if (this.eSC != null) {
            bjq();
            this.eSC.ww().setEditText(" @" + xVar.getNameShow() + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.eRE != null) {
            this.eRE.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void f(com.baidu.live.data.a aVar) {
        if (this.eSC != null) {
            bjq();
            this.eSC.ww().setEditText(" @" + aVar.userName + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.eRE != null) {
            this.eRE.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void b(com.baidu.live.data.x xVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected View biV() {
        if (this.eSC != null) {
            return this.eSC.ww().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean biW() {
        if (this.eSC == null || !this.eSC.ww().xV()) {
            return false;
        }
        iV(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean biX() {
        return this.eRB == null || this.eRB.biX();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup biY() {
        return this.eRy;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup biZ() {
        return this.eRz;
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
                    this.eTf = false;
                    J(intExtra, intExtra2, intExtra3);
                    return;
                }
                biO();
                return;
            }
            bjM();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.eTe;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(bjO().pageContext.getPageActivity()) || z2) {
            iU(z);
        }
    }

    private void iU(boolean z) {
        int dimensionPixelSize;
        if (this.eSC != null && this.eSC.wv() != null) {
            this.eSC.wv().onKeyboardVisibilityChanged(z);
        }
        if (z || this.eSC == null || !this.eSC.ww().xV()) {
            if (z) {
                if (this.eRE != null) {
                    this.eRE.setVisibility(8);
                }
                if (this.eSE != null && this.eSE.sq() != null) {
                    this.eSE.sq().setVisibility(8);
                }
                bjb();
                if (this.eSC != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eSC.ww().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.eSC.ww().getView().setLayoutParams(layoutParams);
                    this.eSC.ww().getView().setVisibility(0);
                    this.eSC.ww().setQuickInputPanelVisible(false);
                }
                if (this.eTa != null) {
                    this.eTa.setVisibility(8);
                }
                if (this.eRH != null) {
                    this.eRH.setVisible(8);
                }
                if (this.eSD != null) {
                    this.eSD.wD();
                }
                if (this.eSZ != null) {
                    this.eSZ.setCanVisible(false);
                }
            } else {
                bja();
            }
            if (this.eSC != null && this.eRO != null) {
                int equipmentHeight = (int) ((z ? 0.2f : 0.33f) * BdUtilHelper.getEquipmentHeight(bjO().pageContext.getPageActivity()));
                if (z) {
                    dimensionPixelSize = equipmentHeight + bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64);
                } else {
                    dimensionPixelSize = equipmentHeight + bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
                }
                if (this.eTb.indexOfChild(this.eRO) != -1 && this.eRO.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eRO.getLayoutParams();
                    layoutParams2.height = dimensionPixelSize;
                    this.eRO.setLayoutParams(layoutParams2);
                }
                if (this.eRO.indexOfChild(this.eSC.wv().getView()) != -1 && this.eSC.wv().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.eSC.wv().getView().getLayoutParams();
                    layoutParams3.height = dimensionPixelSize;
                    this.eSC.wv().getView().setLayoutParams(layoutParams3);
                }
                this.eSC.wv().wu();
            }
        }
    }

    private void bja() {
        if (this.eRE != null) {
            this.eRE.setVisibility(0);
        }
        if (this.eRO != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRO.getLayoutParams();
            layoutParams.bottomMargin = bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            this.eRO.setLayoutParams(layoutParams);
        }
        if (this.eSC != null) {
            bjr();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eSC.ww().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.eSC.ww().getView().setLayoutParams(layoutParams2);
        }
        if (this.eRE != null) {
            this.eRE.setVisibility(0);
        }
        if (this.eSE != null && this.eSE.sq() != null) {
            this.eSE.sq().setVisibility(0);
        }
        if (this.eTa != null && (!this.eRS || UtilHelper.getRealScreenOrientation(bjO().pageContext.getPageActivity()) != 2)) {
            this.eTa.setVisibility(0);
        }
        if (this.eRH != null) {
            this.eRH.setVisible(0);
        }
        if (this.eSD != null) {
            this.eSD.wD();
        }
        if (this.eSZ != null) {
            this.eSZ.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjb() {
        if (this.eRO != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRO.getLayoutParams();
            boolean z = false;
            if (this.eSC != null && this.eSC.ww() != null) {
                z = this.eSC.ww().xU();
            }
            int iZ = iZ(z);
            if (layoutParams.bottomMargin != iZ) {
                layoutParams.bottomMargin = iZ;
                this.eRO.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iV(boolean z) {
        if (z) {
            this.eSC.ww().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRO.getLayoutParams();
            int quickInputPanelExpandHeight = this.eSC.ww().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.eRO.setLayoutParams(layoutParams);
                if (this.eSC.wv() != null) {
                    this.eSC.wv().wu();
                    return;
                }
                return;
            }
            return;
        }
        bja();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void j(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        RelativeLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = bjO().pageContext.getPageActivity();
        if (i3 == 1) {
            if (this.eTa != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.eTa.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.eRN != null) {
                this.eRN.dismiss();
            }
            if (this.eRM != null) {
                this.eRM.a((j.a) null);
                this.eRM.wb();
            }
            if (this.awq != null) {
                this.awq.f(true, true);
            }
            if (this.eRQ != null) {
                this.eRQ.setVisibility(0);
                this.eRQ.bringToFront();
            }
            if (this.eSu != null) {
                this.eSu.setVisibility(0);
            }
            if (this.eSC != null && this.eSC.wv().getView().getParent() != null && (this.eSC.wv().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.eSC.wv().getView().getParent()).removeView(this.eSC.wv().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bjO().pageContext.getPageActivity()) * 0.75f);
            int equipmentHeight = ((int) (BdUtilHelper.getEquipmentHeight(bjO().pageContext.getPageActivity()) * 0.33f)) + bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
            if (this.eRO != null && this.eSC != null) {
                this.eRO.addView(this.eSC.wv().getView(), new FrameLayout.LayoutParams(equipmentWidth, equipmentHeight));
            }
            if (this.eRP != null && (this.eRP.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.eRP.getParent()).removeView(this.eRP);
            }
            if (this.eSD != null) {
                this.eSD.a(bjO().faT.yT(), false);
                this.eSD.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.14
                    @Override // com.baidu.live.im.j.a
                    public void wE() {
                        a.this.bjC();
                    }
                });
                View wC = this.eSD.wC();
                if (wC != null && this.eTb != null && wC.getParent() == null) {
                    Resources resources = bjO().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bjO().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds80));
                    layoutParams5.addRule(2, a.g.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                    this.eTb.addView(wC, layoutParams5);
                }
            }
            if (this.eSw != null) {
                this.eSw.setPraiseEnable(true);
                bjO().faU.fnO = true;
            }
            if (this.eRA != null && this.eRA.eUl != null && (layoutParams3 = (RelativeLayout.LayoutParams) this.eRA.eUl.getLayoutParams()) != null) {
                this.eRA.eUl.setPadding(0, 0, 0, 0);
                this.eRA.eUl.setLayoutParams(layoutParams3);
            }
            if (this.eSy != null) {
                this.eSy.brB();
            }
            if (this.eRS) {
                iS(true);
            }
            if (this.eRT) {
                if (this.eRE != null && this.eRE.getLandscapeBarrageImageView() != null) {
                    b(this.eRE.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.eRF != null) {
                this.eRF.jj(true);
            }
            this.eRU.removeCallbacksAndMessages(null);
            if (this.eRG != null) {
                this.eRG.setCanVisible(true);
                this.eRG.t(bjO().faT.yT());
            }
        } else if (i3 == 2) {
            if (this.eSy != null) {
                this.eSy.brC();
            }
            if (this.eTa != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.eTa.getLayoutParams()) != null) {
                layoutParams2.topMargin = bjO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
            }
            if (this.eSD != null) {
                this.eSD.a((j.a) null);
                this.eSD.wb();
            }
            bjO().faU.bri();
            if (this.awq != null) {
                this.awq.f(false, true);
            }
            if (this.eRQ != null) {
                this.eRQ.setVisibility(4);
            }
            if (this.eSC != null && this.eSC.wv().getView().getParent() != null && (this.eSC.wv().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.eSC.wv().getView().getParent()).removeView(this.eSC.wv().getView());
            }
            int max = Math.max(i, i2);
            if (this.eRP != null) {
                if (this.eRP.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eRP.getParent()).removeView(this.eRP);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
                bjO().faU.addView(this.eRP, layoutParams6);
            }
            if (this.eRP != null && this.eRM != null) {
                this.eRM.a(bjO().faT.yT(), false);
                this.eRM.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.15
                    @Override // com.baidu.live.im.j.a
                    public void wE() {
                        a.this.bjC();
                    }
                });
                View wC2 = this.eRM.wC();
                if (wC2 != null && this.eRP.indexOfChild(wC2) < 0) {
                    this.eRP.addView(wC2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bjO().pageContext.getPageActivity()), -1));
                }
            }
            if (this.eSw != null) {
                this.eSw.am(bjO().faU);
                this.eSw.setPraiseEnable(false);
                bjO().faU.fnO = false;
            }
            if (this.eRA != null && this.eRA.eUl != null && (layoutParams = (RelativeLayout.LayoutParams) this.eRA.eUl.getLayoutParams()) != null) {
                int width = this.eRA.eUl.getWidth();
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                this.eRA.eUl.setPadding(width - ((int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f)), 0, 0, 0);
                this.eRA.eUl.setLayoutParams(layoutParams);
            }
            if (this.eRF != null) {
                this.eRF.jj(false);
            }
            if (aa.sT() != null) {
                aa.sT().sS();
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.x.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.x.c) runTask.getData()).sS();
            }
            if (this.eRE != null && this.eRE.getLandscapeBarrageImageView() != null) {
                b(this.eRE.getLandscapeBarrageImageView(), this.eRT, false);
            }
            this.eRU.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.16
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.eRS) {
                        a.this.iS(false);
                    }
                }
            }, 5000L);
            if (this.eSE != null) {
                this.eSE.ss();
            }
            if (this.eRG != null) {
                this.eRG.setCanVisible(false);
                this.eRG.bmm();
            }
        }
        if (this.eSF != null) {
            if (i3 == 2) {
                View sH = this.eSF.sH();
                if (sH != null) {
                    if (sH.getParent() != null && (sH.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) sH.getParent()).removeView(sH);
                    }
                    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams7.addRule(5, a.g.ala_liveroom_hostheader);
                    layoutParams7.addRule(3, a.g.ala_liveroom_hostheader);
                    layoutParams7.topMargin = bjO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                    if (this.eTa != null) {
                        this.eTa.addView(sH, layoutParams7);
                    }
                }
            } else {
                View sH2 = this.eSF.sH();
                if (sH2 != null) {
                    if (sH2.getParent() != null && (sH2.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) sH2.getParent()).removeView(sH2);
                    }
                    RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams8.topMargin = bjO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds4);
                    layoutParams8.addRule(3, a.g.ala_live_header_view);
                    bjO().faU.addView(sH2, layoutParams8);
                }
            }
        }
        if (this.eRE != null) {
            this.eRE.j(i, i2, i3);
        }
        pU(i3);
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.eRA != null) {
                this.eRA.bW(i3);
            }
            if (this.eRC != null) {
                this.eRC.bW(i3);
            }
            if (this.eRH != null) {
                this.eRH.bW(i3);
            }
            if (this.eSI != null) {
                this.eSI.bW(i3);
            }
            if (this.eSR != null) {
                this.eSR.bW(i3);
            }
            if (this.eRV != null && this.eRV.isShowing()) {
                this.eRV.resize();
            }
            if (this.eSZ != null) {
                this.eSZ.bW(i3);
            }
        }
        if (this.eSE != null) {
            this.eSE.sr();
        }
        super.j(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public boolean cc(int i) {
        boolean cc = super.cc(i);
        if (cc && 2 == i) {
            if (this.eRB.biX()) {
                return false;
            }
            if (cc && this.eSy != null) {
                this.eSy.jT(false);
            }
        }
        return cc;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void pT(int i) {
        super.pT(i);
        if (i == 7 || i == 11) {
            if (i != 7 || UtilHelper.getRealScreenOrientation(bjO().pageContext.getPageActivity()) != 2) {
                if (this.eRE != null) {
                    this.eRE.setVisibility(8);
                }
                if (this.eSC != null) {
                    this.eSC.wv().getView().setVisibility(4);
                }
                if (this.eSS != null) {
                    this.eSS.jO(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public void cd(int i) {
        super.cd(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public void ce(int i) {
        super.ce(i);
        if (i == 7 || i == 11) {
            if (this.eRE != null) {
                this.eRE.setVisibility(0);
            }
            if (this.eSC != null) {
                this.eSC.wv().getView().setVisibility(0);
            }
            if (this.eSS != null) {
                this.eSS.jO(true);
            }
            if (!this.eRS || UtilHelper.getRealScreenOrientation(bjO().pageContext.getPageActivity()) != 2) {
                this.eTa.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.eRD != null) {
            this.eRD.bqt();
        }
        if (this.eRJ != null) {
            this.eRJ.pZ();
        }
        if (this.eRH != null) {
            this.eRH.onStop();
        }
        if (bjO() != null) {
            BdUtilHelper.hideSoftKeyPad(bjO().pageContext.getPageActivity(), bjO().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.eRD != null) {
            this.eRD.bqs();
        }
        if (this.eRJ != null) {
            this.eRJ.qa();
        }
        if (this.eRH != null) {
            this.eRH.onStart();
        }
    }

    private void pU(int i) {
        if (this.eRy != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRy.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.bottomMargin = bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
                layoutParams.height = bix();
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds72) + 0 + bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds22) + bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                layoutParams.rightMargin = bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
                layoutParams.height = -2;
            }
            this.eRy.setLayoutParams(layoutParams);
        }
    }
}
