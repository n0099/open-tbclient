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
    private PriorityVerticalLinearLayout eQN;
    private LinearLayout eQO;
    private com.baidu.tieba.ala.liveroom.audiencelist.c eQP;
    private com.baidu.tieba.ala.liveroom.l.a eQQ;
    private com.baidu.tieba.ala.liveroom.e.b eQR;
    private com.baidu.tieba.ala.liveroom.r.b eQS;
    private com.baidu.tieba.ala.liveroom.operation.a eQT;
    private com.baidu.tieba.ala.liveroom.audiencelist.b eQU;
    private com.baidu.tieba.ala.liveroom.j.a eQV;
    private com.baidu.tieba.ala.liveroom.activeview.b eQW;
    private com.baidu.live.d.a eQX;
    private j eQY;
    private i eQZ;
    private com.baidu.tieba.ala.liveroom.attentionpop.b eRa;
    private com.baidu.live.im.j eRb;
    private com.baidu.tieba.ala.liveroom.share.b eRc;
    private FrameLayout eRd;
    private FrameLayout eRe;
    private ImageView eRf;
    private com.baidu.live.tieba.e.b eRg;
    private x eRk;
    private com.baidu.tieba.ala.liveroom.h.b eRl;
    private long lastClickTime = 0;
    private boolean eRh = false;
    private boolean eRi = false;
    private Handler eRj = new Handler();
    private HttpRule eRm = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.eQY != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.eQY.qa()) {
                httpMessage.addParam("ala_challenge_id", a.this.eQY.qd());
            }
            return httpMessage;
        }
    };
    private HttpRule eRn = new HttpRule(1021151) { // from class: com.baidu.tieba.ala.liveroom.c.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.eQY != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.eQY.qa()) {
                httpMessage.addParam("challenge_id", a.this.eQY.qd());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c eRo = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.c.a.17
        @Override // com.baidu.live.liveroom.g.c
        public void yM() {
            if (a.this.eRN != null) {
                a.this.eRN.jR(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bg(boolean z) {
            if (z) {
                if (a.this.eQT != null) {
                    a.this.eQT.qz(8);
                }
                if (a.this.eRN != null) {
                    a.this.eRN.jR(true);
                }
            } else {
                if (a.this.eQT != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                        a.this.eQT.qz(0);
                    } else {
                        a.this.eQT.qz(8);
                    }
                }
                if (a.this.eRN != null) {
                    a.this.eRN.jR(false);
                }
            }
            if (a.this.eSe != null) {
                a.this.eSe.aB(z);
            }
        }
    };
    private HttpMessageListener eRp = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.a.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.yW() != null) {
                        com.baidu.live.v.c.zq().axM = getQuickGiftHttpResponseMessage.yW();
                        a.this.biB();
                    }
                }
            }
        }
    };
    private CustomMessageListener eRq = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.a.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.biK();
        }
    };
    private CustomMessageListener eRr = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.c.a.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.eSi != null) {
                    a.this.eSi.yR(str);
                }
            }
        }
    };
    CustomMessageListener eRs = new CustomMessageListener(CmdConfigCustom.CMD_HOST_GET_WALLET_UA) { // from class: com.baidu.tieba.ala.liveroom.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.eSw != null && a.this.eSw.apX != null && !a.this.eSw.aqa && !a.this.eSw.aqb && a.this.eSd != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.bjI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = a.this.bjI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                a.this.eSd.b(a.this.eRd, layoutParams);
                if (e.vG() != null) {
                    e.vG().vM();
                }
            }
        }
    };
    private CustomMessageListener eRt = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (a.this.eSg != null) {
                    a.this.eSg.dismiss();
                }
                k.wA().setSwitchStatus(true);
                k.wA().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bjk();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener eRu = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.eRl.c(a.this.bjI());
                } else if (a.this.bje() || !g.qa(2913168)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, 3000L);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.bjI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.bjI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    a.this.eRl.b(a.this.eRd, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b eRv = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.a.8
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
                if (i == 2 && a.this.uX()) {
                    a.this.J(-1, -1, -1);
                } else if (i == 13) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                        alaStaticItem.addParams("gifts_value", com.baidu.live.v.c.zq().axM.su().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.v.c.zq().axM.su().rx());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.v.c.zq().axM.su().ry());
                        if (a.this.bjI().fai.yO() != null && a.this.bjI().fai.yO().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.bjI().fai.yO().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.bjI().fai.yO().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.xx());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.uX()) {
                        if (com.baidu.live.c.pr().getBoolean("quick_gift_guide_show", true) && !a.this.bje()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, x.class, a.this.bjI().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                x xVar = (x) runTask.getData();
                                xVar.setPageContext(a.this.bjI().pageContext);
                                xVar.d(a.this.bjI().fai.yO());
                                xVar.a(com.baidu.live.v.c.zq().axM.su());
                                xVar.setOtherParams(a.this.xx());
                                xVar.initView();
                                xVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.8.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        a.this.iV(false);
                                        a.this.eRk = null;
                                    }
                                });
                                a.this.eRk = xVar;
                                xVar.show();
                                a.this.iV(true);
                                return;
                            }
                            return;
                        }
                        n.a(a.this.bjI().pageContext, a.this.bjI().fai.yO(), com.baidu.live.v.c.zq().axM.su(), a.this.xx());
                    }
                } else if (i == 1) {
                    if (a.this.eRR != null) {
                        a.this.bjk();
                    }
                } else if (i == 3 && a.this.uX()) {
                    if (a.this.mOrientation == 2 && TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.eRc != null) {
                            a.this.eRc.x(a.this.bjI().fai.yO());
                        }
                    } else {
                        a.this.eRG.c(a.this.bjI().fai.yO(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.bjI() != null && a.this.bjI().fai != null && a.this.bjI().fai.yO() != null && a.this.bjI().fai.yO().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.bjI().fai.yO().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.bjI().fai.yO().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.bjI().fai.yO().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.xx());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.bjI() != null && a.this.bjI().fai != null && a.this.bjI().fai.yO() != null && a.this.bjI().fai.yO().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.bjI().fai.yO().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.bjI().fai.yO().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.bjI().fai.yO().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.xx());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.awf != null) {
                        a.this.awf.bb(false);
                    }
                } else if (i == 12) {
                    if (a.this.eRN != null) {
                        String valueOf = String.valueOf(a.this.bjI().fai.yO().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.bjI().fai.yO().mLiveInfo.room_id);
                        String str2 = null;
                        com.baidu.live.data.k kVar = a.this.bjI().fai.yO().mLiveSdkInfo;
                        if (kVar != null && kVar.mCastIds != null) {
                            str2 = String.valueOf(a.this.bjI().fai.yO().mLiveSdkInfo.mCastIds.XX);
                        }
                        a.this.eRN.ad(valueOf, valueOf2, str2);
                        if (com.baidu.live.liveroom.a.ym().yn()) {
                            a.this.biK();
                        }
                    }
                } else if (i == 14) {
                    m yO = a.this.bjI().fai.yO();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.bjI().pageContext.getPageActivity(), yO.XQ.userName, Long.toString(yO.XQ.userId), Long.toString(yO.XQ.charmCount), String.valueOf(yO.mLiveInfo.group_id), String.valueOf(yO.mLiveInfo.live_id), false, String.valueOf(yO.XQ.userId), Long.toString(yO.Ye.userId), yO.Ye.userName, yO.Ye.portrait, a.this.eQU.getCount(), a.this.xx())));
                    LogManager.getCommonLogger().doClickGusetNumLog(yO.mLiveInfo.feed_id, a.this.eQU.getCount() + "", a.this.xx());
                } else if (i == 11) {
                    a.this.bjn();
                    a.this.bjo();
                } else if (i == 15) {
                    if (a.this.eSb != null && a.this.bjI() != null && a.this.bjI().fai != null && a.this.bjI().fai.yO() != null && a.this.bjI().fai.yO().mLiveInfo != null) {
                        long j = a.this.bjI().fai.yO().mLiveInfo.live_id;
                        String valueOf3 = String.valueOf(a.this.bjI().fai.yO().mLiveInfo.feed_id);
                        long j2 = a.this.bjI().fai.yO().mLiveInfo.room_id;
                        String str3 = a.this.bjI().fai.yO().mLiveInfo.cover;
                        String str4 = "";
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        if (a.this.bjI().fai.yO().mLiveInfo.session_info != null) {
                            str4 = a.this.bjI().fai.yO().mLiveInfo.session_info.flvUrl;
                        }
                        if (!TextUtils.isEmpty(a.this.xx())) {
                            try {
                                JSONObject jSONObject = new JSONObject(a.this.xx());
                                str5 = jSONObject.optString("tab");
                                str6 = jSONObject.optString("tag");
                                str7 = jSONObject.optString("source");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        a.this.eSb.yR(o.a(valueOf3, j + "", j2, false, 1, str3, str4, str5, str6, str7));
                        o.aDQ = j;
                        if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                            ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                            LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf3, a.this.xx());
                        }
                    }
                } else if (i == 16) {
                    if (a.this.bjI() != null && (apVar2 = com.baidu.live.v.a.zl().axC) != null && (ayVar2 = apVar2.acS) != null) {
                        String str8 = ayVar2.adP.adW;
                        if (!TextUtils.isEmpty(str8)) {
                            long j3 = 0;
                            if (a.this.bjI().fai != null && a.this.bjI().fai.yO() != null && a.this.bjI().fai.yO().mLiveInfo != null) {
                                j3 = a.this.bjI().fai.yO().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j3 + "", a.this.bjI().fai.yO().mLiveInfo.room_id + "", a.this.bjI().fai.yO().mLiveInfo.feed_id, a.this.xx());
                            }
                            if (str8.contains("?")) {
                                str = str8 + "&liveId=" + j3;
                            } else {
                                str = str8 + "?liveId=" + j3;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.bjI().pageContext.getPageActivity(), str);
                        }
                    }
                } else if (i == 17) {
                    if (a.this.uX() && a.this.bjI() != null && (apVar = com.baidu.live.v.a.zl().axC) != null && (ayVar = apVar.acS) != null && (beVar = ayVar.adQ) != null && !TextUtils.isEmpty(beVar.webUrl) && a.this.eSg != null && a.this.bjI().fai != null && a.this.bjI().fai.yO() != null) {
                        m yO2 = a.this.bjI().fai.yO();
                        a.this.eSg.a(beVar.webUrl, yO2.mLiveInfo.live_id, yO2.Ye.userId, yO2.XQ.userId);
                        a.this.eRg.bn(false);
                        a.this.eRg.Ac();
                    }
                } else if (i == 18) {
                    if (a.this.eRi) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.eRi = !a.this.eRi;
                } else if (i == 19 && a.this.eRg != null) {
                    a.this.eRg.Ac();
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.eRI = new com.baidu.tieba.ala.liveroom.guide.c(bjI().pageContext, this, false);
        this.eRm.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.eRm);
        this.eRn.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.eRn);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean bim() {
        return false;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void k(m mVar) {
        super.k(mVar);
        g.bmb();
        this.eRi = false;
        if (this.eRL != null) {
            this.eRL.b(this.eRv);
        }
        if (this.eRg == null) {
            this.eRg = new com.baidu.live.tieba.e.b(bjI().pageContext.getPageActivity());
            this.eRg.start();
        }
        this.eRg.bn(true);
        bjI().pageContext.getPageActivity().setRequestedOrientation(-1);
        bjI().faj.setIsForceHandledTouch(false);
        bjI().faj.setSwipeClearEnable(true);
        bjI().faj.setOnLiveViewScrollListener(this.eRo);
        bjI().faj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eRj.removeCallbacksAndMessages(null);
                a.this.iQ(false);
                if (!a.this.eRh) {
                    a.this.eRj.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.eRh) {
                                a.this.iQ(false);
                            }
                        }
                    }, 5000L);
                }
            }
        });
        if (this.eSp != null) {
            this.eSp.setVisibility(0);
        }
        biq();
        bit();
        biE();
        bja();
        biF();
        bip();
        biH();
        biG();
        iR(false);
        bjr();
        bjq();
        biv();
        biC();
        biD();
        bjt();
        bin();
        biJ();
        biL();
        iW(true);
        biu();
        biB();
        bjz();
        biw();
        bix();
        biy();
        biz();
        biM();
        bjy();
        if (this.eSg != null && this.eSg.bqC() == null) {
            this.eSg.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.19
                @Override // com.baidu.tieba.ala.liveroom.turntable.d.a
                public void onDismiss() {
                    a.this.eRg.bn(true);
                }
            });
        }
        MessageManager.getInstance().registerListener(this.eRp);
        MessageManager.getInstance().registerListener(this.eRq);
        MessageManager.getInstance().registerListener(this.eRs);
        MessageManager.getInstance().registerListener(this.eRt);
        MessageManager.getInstance().registerListener(this.eRu);
        MessageManager.getInstance().registerListener(this.eRr);
        biN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iQ(boolean z) {
        View sC;
        if (bjI() != null && bjI().pageContext != null && bjI().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(bjI().pageContext.getPageActivity()) == 2 || z) {
                if (this.eRU != null && (sC = this.eRU.sC()) != null) {
                    if (this.eRh) {
                        sC.setVisibility(0);
                    } else {
                        sC.setVisibility(8);
                    }
                }
                if (this.eRh) {
                    if (this.eSp != null) {
                        this.eSp.setVisibility(0);
                    }
                    if (this.eSq != null) {
                        this.eSq.setVisibility(0);
                    }
                    if (this.eQO != null) {
                        this.eQO.setVisibility(0);
                    }
                    if (this.eQN != null) {
                        this.eQN.setVisibility(0);
                    }
                    if (this.eRT != null) {
                        this.eRT.az(false);
                    }
                } else {
                    if (this.eSp != null) {
                        this.eSp.setVisibility(8);
                    }
                    if (this.eSq != null) {
                        this.eSq.setVisibility(8);
                    }
                    if (this.eQO != null) {
                        this.eQO.setVisibility(8);
                    }
                    if (this.eQN != null) {
                        this.eQN.setVisibility(8);
                    }
                    if (this.eRT != null) {
                        this.eRT.az(true);
                    }
                }
                this.eRh = this.eRh ? false : true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, boolean z2) {
        ImageView imageView;
        View sl;
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view;
        }
        if (z) {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_off);
            }
            if (this.eRe != null) {
                this.eRe.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_on);
            }
            if (this.eRe != null) {
                this.eRe.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.eRT != null && (sl = this.eRT.sl()) != null) {
            if (z) {
                sl.setVisibility(8);
            } else {
                sl.setVisibility(0);
            }
        }
    }

    private void bin() {
        CustomResponsedMessage runTask;
        if (this.eRb == null && (runTask = MessageManager.getInstance().runTask(2913164, com.baidu.live.im.j.class, bjI().pageContext)) != null) {
            this.eRb = (com.baidu.live.im.j) runTask.getData();
        }
        if (this.eRb != null) {
            this.eRb.setOtherParams(this.otherParams);
            this.eRb.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.20
                @Override // com.baidu.live.im.j.a
                public void wz() {
                    a.this.bjw();
                }
            });
        }
    }

    private void bio() {
        if (this.eRM != null) {
            this.eRM.ai(bjI().fah.getLiveContainerView());
        }
    }

    private void bip() {
        if (this.eRc == null) {
            this.eRc = new com.baidu.tieba.ala.liveroom.share.b(bjI().pageContext);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bk(int i) {
        super.bk(i);
        if (this.eRf != null && UtilHelper.getRealScreenOrientation(bjI().pageContext.getPageActivity()) != 2) {
            this.eRf.setVisibility(0);
        }
        bio();
        if (this.eQZ != null) {
            this.eQZ.bk(i);
        }
        if (this.eQZ == null || !this.eQZ.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void iR(boolean z) {
        super.iR(z);
        this.eRT.br(bjI().fai.yO().mLiveInfo.screen_direction);
    }

    private void biq() {
        if (this.eQN == null) {
            this.eQN = new PriorityVerticalLinearLayout(bjI().pageContext.getPageActivity());
            this.eQN.setDefaultItemMargin(bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            bis();
        }
        if (this.eQN.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, bir());
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            layoutParams.rightMargin = bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
            layoutParams.bottomMargin = bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
            bjI().faj.addView(this.eQN, layoutParams);
        }
    }

    private int bir() {
        int bottom;
        if (bjI().awi.getLivePlayer().getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bjI().awi.getLivePlayer().getLayoutParams();
            bottom = layoutParams.topMargin + layoutParams.height;
        } else {
            bottom = bjI().awi.getLivePlayer().getBottom();
        }
        return ((bjI().faj.getBottom() - bottom) - bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
    }

    private void bis() {
        View view = new View(bjI().pageContext.getPageActivity());
        view.setTag(a.g.sdk_pvl_layout_priority_tag_key, 20);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(1, 0);
        layoutParams.weight = 1.0f;
        this.eQN.addView(view, layoutParams);
    }

    private void bit() {
        if (this.eQO == null) {
            this.eQO = new LinearLayout(bjI().pageContext.getPageActivity());
            this.eQO.setOrientation(1);
        }
        if (this.eQO.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds228);
            layoutParams.leftMargin = bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bjI().faj.addView(this.eQO, layoutParams);
        }
    }

    private void biu() {
        if (this.eQW == null) {
            this.eQW = new com.baidu.tieba.ala.liveroom.activeview.b(bjI().pageContext);
        }
        this.eQW.setOtherParams(xx());
        this.eQW.b(bjI().fai.yO(), true);
        this.eQW.setHost(false);
        this.eQW.a(1, this.eQN, pQ(1));
        this.eQW.a(2, this.eQN, pQ(2));
        this.eQW.setVisible(this.eSt ? 8 : 0);
    }

    private void biv() {
        if (this.eRK != null && bjI() != null && bjI().fai != null) {
            this.eRK.b(this.eSp, bjI().fai.yO());
        }
    }

    private ViewGroup.LayoutParams pQ(int i) {
        switch (i) {
            case 1:
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = bjI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds40);
                return layoutParams;
            case 2:
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 5;
                layoutParams2.topMargin = bjI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                return layoutParams2;
            default:
                return new RelativeLayout.LayoutParams(-1, -2);
        }
    }

    private void biw() {
        if (this.eQN != null) {
            if (this.eQV == null) {
                this.eQV = new com.baidu.tieba.ala.liveroom.j.a(bjI().pageContext, this);
            }
            this.eQV.setOtherParams(xx());
            this.eQV.d(this.eQN, biA());
            this.eQV.t(bjI().fai.yO());
        }
    }

    private void bix() {
        if (this.eSd == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, com.baidu.live.guardclub.j.class, bjI().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.eSd = (com.baidu.live.guardclub.j) runTask.getData();
            } else {
                return;
            }
        }
        this.eSd.setOtherParams(xx());
        if (this.eRd != null && this.eRd.indexOfChild(this.eSd.getView()) >= 0) {
            this.eRd.removeView(this.eSd.getView());
        }
    }

    private void biy() {
        if (this.eQT != null) {
            this.eQT.a(new a.InterfaceC0465a() { // from class: com.baidu.tieba.ala.liveroom.c.a.5
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0465a
                public void bl(int i, int i2) {
                    m yO = a.this.bjI().fai.yO();
                    if (yO != null && yO.mLiveInfo != null) {
                        if (a.this.eSh == null) {
                            a.this.eSh = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.bjI().pageContext.getPageActivity());
                        }
                        a.this.eSh.d(a.this.eSq, i, i2);
                        a.this.eSh.a(String.valueOf(yO.mLiveInfo.live_id), new a.InterfaceC0467a() { // from class: com.baidu.tieba.ala.liveroom.c.a.5.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0467a
                            public void a(float f, String str) {
                                if (a.this.eQT != null) {
                                    a.this.eQT.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0465a
                public void bm(int i, int i2) {
                    if (a.this.eSh != null) {
                        a.this.eSh.br(i, i2);
                    }
                }
            });
        }
    }

    private void biz() {
        if (this.eSE == null) {
            this.eSE = new com.baidu.tieba.ala.liveroom.h.e(bjI().pageContext);
        }
        this.eSE.setRoomId(bjI().fai.yO().mLiveInfo.room_id);
        this.eSE.za("");
        this.eSE.a(bjI().fai.yO(), this.eQN);
        if (this.eRl == null) {
            this.eRl = new com.baidu.tieba.ala.liveroom.h.b(bjI().pageContext, xx(), this.eSE, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.6
                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void biW() {
                    a.this.iV(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void biX() {
                    a.this.iV(false);
                }
            });
        }
        this.eRl.setRoomId(bjI().fai.yO().mLiveInfo.room_id);
        if (this.eRd != null && this.eRd.indexOfChild(this.eRl.getView()) >= 0) {
            this.eRd.removeView(this.eRl.getView());
        }
        if (this.eRl != null) {
            this.eRl.b(bjI());
        }
    }

    private ViewGroup.LayoutParams biA() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = bjI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biB() {
        if (this.eQT == null) {
            biG();
        }
        this.eQT.a(com.baidu.live.v.c.zq().axM, bjI().fai.yO());
    }

    private void biC() {
        CustomResponsedMessage runTask;
        if (this.eRR == null && (runTask = MessageManager.getInstance().runTask(2913039, com.baidu.live.im.i.class, bjI().pageContext)) != null && runTask.getData() != null) {
            this.eRR = (com.baidu.live.im.i) runTask.getData();
            this.eRR.setFromMaster(false);
            this.eRR.wq().getView().setId(a.g.ala_liveroom_msg_list);
            this.eRR.a(new i.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.7
                @Override // com.baidu.live.im.i.a
                public boolean ws() {
                    return a.this.uX();
                }

                @Override // com.baidu.live.im.i.a
                public void wt() {
                    a.this.eSx = true;
                }

                @Override // com.baidu.live.im.i.a
                public void dM(String str) {
                    if (!a.this.eSt) {
                        a.this.iT(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.bjI().pageContext.getPageActivity(), a.this.bjI().fah.getLiveContainerView());
                    }
                    a.this.yO(str);
                }

                @Override // com.baidu.live.im.i.a
                public void wu() {
                    if (a.this.eSt) {
                        a.this.iT(true);
                        a.this.bjI().fah.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.bjI().pageContext.getPageActivity(), a.this.bjI().fah.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (a.this.eRR != null) {
                        a.this.eRR.wr().setQuickInputPanelVisible(false);
                        a.this.eRR.wr().xR();
                    }
                }

                @Override // com.baidu.live.im.i.a
                public void wv() {
                    if (a.this.eSt) {
                        a.this.biV();
                        if (a.this.eRS != null) {
                            a.this.eRS.wy();
                        }
                        if (a.this.eRb != null) {
                            a.this.eRb.wy();
                        }
                    } else if (a.this.eRR != null) {
                        a.this.eRR.wr().setQuickInputPanelVisible(false);
                        a.this.eRR.wr().xR();
                    }
                }

                @Override // com.baidu.live.im.i.a
                public boolean ww() {
                    return a.this.bjf();
                }
            });
            this.eRd = new FrameLayout(bjI().pageContext.getPageActivity());
            this.eRd.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.eRR != null && this.eRd != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bjI().pageContext.getPageActivity()) * 0.75f);
            int dimensionPixelSize = bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds120) + ((int) (BdUtilHelper.getEquipmentHeight(bjI().pageContext.getPageActivity()) * 0.33f));
            if (this.eSq.indexOfChild(this.eRd) < 0) {
                if (this.eRd.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eRd.getParent()).removeView(this.eRd);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                this.eSq.addView(this.eRd, layoutParams);
            }
            if (this.eRd.indexOfChild(this.eRR.wq().getView()) < 0) {
                if (this.eRR.wq().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eRR.wq().getView()).removeView(this.eRR.wq().getView());
                }
                if (UtilHelper.getRealScreenOrientation(bjI().pageContext.getPageActivity()) != 2) {
                    this.eRd.addView(this.eRR.wq().getView(), new FrameLayout.LayoutParams(equipmentWidth, dimensionPixelSize));
                }
            }
            if (bjI().faj.indexOfChild(this.eRR.wr().getView()) < 0) {
                if (this.eRR.wr().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eRR.wr().getView().getParent()).removeView(this.eRR.wr().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bjl();
                bjI().faj.addView(this.eRR.wr().getView(), layoutParams2);
            }
            m yO = bjI().fai.yO();
            if (yO != null && yO.mLiveInfo != null) {
                this.eRR.setLogData(yO.mLiveInfo.feed_id, xx());
            }
            this.eRR.e(String.valueOf(bjI().fai.yO().mLiveInfo.group_id), String.valueOf(bjI().fai.yO().mLiveInfo.last_msg_id), String.valueOf(bjI().fai.yO().XQ.userId), String.valueOf(bjI().fai.yO().mLiveInfo.live_id), bjI().fai.yO().XQ.appId);
            iT(false);
        }
    }

    private void biD() {
        if (this.eRe == null) {
            this.eRe = new FrameLayout(bjI().pageContext.getPageActivity());
            this.eRe.setId(a.g.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void biE() {
        if (this.eQQ == null) {
            this.eQQ = new com.baidu.tieba.ala.liveroom.l.a(bjI().pageContext, false, this);
        }
        this.eQQ.c(this.eSp, bjI().fai.yO());
        this.eQQ.a(this.eRv);
    }

    private void biF() {
        if (this.eQP == null) {
            this.eQP = new com.baidu.tieba.ala.liveroom.audiencelist.c(bjI().pageContext, this, false);
        }
        this.eQP.a(String.valueOf(bjI().fai.yO().mLiveInfo.group_id), String.valueOf(bjI().fai.yO().mLiveInfo.live_id), String.valueOf(bjI().fai.yO().XQ.userId), bjI().fai.yO());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.eRF != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.eQP.c(this.eSp, i, a.g.ala_liveroom_audience_count_layout);
            this.eQP.f(bjI().fai.bdY());
        }
    }

    private void biG() {
        if (this.eQT == null) {
            this.eQT = new com.baidu.tieba.ala.liveroom.operation.a(bjI().pageContext);
        }
        this.eQT.a(bjI(), this.eSq, bjI().fai.yO().mLiveInfo.live_type, true, this.eRv);
        this.eQT.setOtherParams(xx());
    }

    private void biH() {
        if (this.eQU == null) {
            this.eQU = new com.baidu.tieba.ala.liveroom.audiencelist.b(bjI().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (bjI().fai.bdY() != null) {
            j = bjI().fai.bdY().getCount();
        }
        this.eQU.a(this.eRv);
        this.eQU.a(this.eSp, a.g.ala_liveroom_audience, j);
        this.eQU.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.eQU.ji(false);
        } else {
            this.eQU.ji(true);
        }
    }

    public void biI() {
        this.eRG.c(bjI().fai.yO(), false);
    }

    public void biJ() {
        if (bjI().fai.yO() != null && bjI().fai.yO().XQ != null && bjI().fai.yO().mLiveInfo != null) {
            if (this.eQS == null) {
                this.eQS = new com.baidu.tieba.ala.liveroom.r.b(bjI().pageContext);
            }
            long j = bjI().fai.yO().XQ.userId;
            int i = bjI().fai.yO().mLiveInfo.live_type;
            String str = bjI().fai.yO().XQ.portrait;
            String str2 = bjI().fai.yO().mLiveInfo.feed_id;
            long j2 = bjI().fai.yO().mLiveInfo.live_id;
            this.eQS.a(i, j, bjI().fai.yO().XQ.userName, false, str, xx(), str2, j2);
            this.eQS.af(this.eSp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biK() {
        String str;
        if (bjI() != null && bjI().fai != null && bjI().fai.yO() != null && bjI().fai.yO().Ye != null && (str = bjI().fai.yO().Ye.userName) != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bjI().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !bje()) {
            com.baidu.live.c.pr().putInt("guide_rename_show_count", com.baidu.live.c.pr().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.ym().ba(true);
            if (this.eSk == null) {
                this.eSk = new com.baidu.tieba.ala.liveroom.s.a(bjI().pageContext);
            }
            this.eSk.setOtherParams(xx());
            this.eSk.e(this.eSq, bjI().fai.yO());
            iV(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eSk.bqp();
                    a.this.iV(false);
                }
            }, 5000L);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_SHOW);
                alaStaticItem.addParams("other_params", xx());
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    private void biL() {
        if (this.eRN == null) {
            this.eRN = new com.baidu.tieba.ala.liveroom.u.a(bjI().pageContext, this);
        }
        this.eRN.d(bjI().faj, false);
        this.eRN.jQ(bjH());
    }

    private void biM() {
        if (bjI() != null && bjI().awi != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(bjI().pageContext.getPageActivity());
            Activity pageActivity = bjI().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + pageActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds176)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.eRf = new ImageView(bjI().pageContext.getPageActivity());
            this.eRf.setVisibility(8);
            this.eRf.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.eRf.setImageResource(a.f.icon_live_enlarge);
            this.eRf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.eRg != null) {
                        a.this.eRg.Ab();
                        a.this.eRf.setVisibility(4);
                    }
                }
            });
            bjI().faj.addView(this.eRf, layoutParams);
            if (UtilHelper.getRealScreenOrientation(bjI().pageContext.getPageActivity()) != 2) {
                if (bjI().fao) {
                    this.eRf.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.12
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.eRf != null && UtilHelper.getRealScreenOrientation(a.this.bjI().pageContext.getPageActivity()) != 2) {
                                a.this.eRf.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
        }
    }

    private void biN() {
        if (this.eSx || this.eSy) {
            if ((TbadkCoreApplication.isLogin() && this.eRR.wr().hasText()) || this.eSy) {
                this.eSx = false;
                this.eSy = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bjk();
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
                if (this.eQV != null) {
                    this.eQV.u(jSONObject);
                }
            } else if ("enter_live".equals(optString)) {
                if (this.eQU.getCount() > 20) {
                    this.eQU.cD(this.eQU.getCount() + 1);
                } else if (this.eQP != null) {
                    com.baidu.live.data.a xo = aVar.xo();
                    com.baidu.live.data.g gVar = new com.baidu.live.data.g();
                    gVar.XR = new AlaLocationData();
                    gVar.XS = new AlaRelationData();
                    gVar.XQ = new AlaLiveUserInfoData();
                    gVar.XQ.userId = JavaTypesHelper.toLong(xo.userId, 0L);
                    gVar.XQ.userName = xo.userName;
                    gVar.XQ.portrait = xo.portrait;
                    if (this.eQP.c(gVar)) {
                        this.eQU.cD(this.eQU.getCount() + 1);
                    }
                }
            } else if ("update_liveinfo".equals(optString) && bjI().fai.yO() != null && bjI().fai.yO().mLiveInfo != null) {
                bjI().fai.a(bjI().fai.yO().mLiveInfo.live_id, bjI().fromType, bjI().enterTime);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void yK(String str) {
        if (this.eQW != null) {
            this.eQW.yK(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void i(m mVar) {
        super.i(mVar);
        if (this.eQQ != null) {
            this.eQQ.u(mVar);
        }
        if (this.eQR != null) {
            this.eQR.q(mVar);
        }
        if (this.eQV != null) {
            this.eQV.t(mVar);
        }
        if (this.eQZ != null) {
            this.eQZ.a(mVar);
        }
        if (this.eRb != null) {
            this.eRb.a(mVar);
        }
        if (this.eQW != null) {
            this.eQW.h(mVar);
            if (mVar != null && this.eSn != null && !this.eSn.hasInit && !TextUtils.isEmpty(this.eSn.adm)) {
                this.eSn.hasInit = true;
                this.eQW.yL(this.eSn.adm);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(h hVar) {
        if (hVar != null) {
            if (this.eQP != null && hVar.getList() != null) {
                this.eQP.f(hVar);
            }
            if (this.eQU != null) {
                this.eQU.cD(hVar.getCount());
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void bf(boolean z) {
        super.bf(z);
        if (bjI().faj != null) {
            bjI().faj.bra();
            bjI().faj.setLiveViewOnDispatchTouchEventListener(null);
            bjI().faj.setOnLiveViewScrollListener(null);
        }
        if (bjI().awi != null) {
            bjI().awi.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.eQZ != null) {
            this.eQZ.pK();
        }
        biO();
        if (this.eQS != null) {
            this.eQS.pK();
        }
        if (this.eRN != null) {
            this.eRN.release();
        }
        if (this.eQV != null) {
            this.eQV.pK();
        }
        if (this.eQT != null) {
            this.eQT.bpV();
        }
        if (this.eQR != null) {
            this.eQR.blu();
            this.eQR.setVisible(8);
        }
        if (this.eQX != null) {
            this.eQX.pK();
        }
        if (this.eQW != null) {
            this.eQW.release();
        }
        if (this.eQN != null) {
            this.eQN.removeAllViews();
            this.eQN = null;
        }
        if (this.eQO != null) {
            this.eQO.removeAllViews();
            this.eQO = null;
        }
        if (this.eQY != null) {
            this.eQY.pK();
        }
        if (this.eRb != null) {
            this.eRb.a((j.a) null);
            this.eRb.vW();
        }
        if (this.eRf != null && (this.eRf.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.eRf.getParent()).removeView(this.eRf);
        }
        if (this.eRc != null) {
            this.eRc.dismiss();
        }
        if (this.eRg != null) {
            this.eRg.bn(false);
            this.eRg.Ac();
        }
        if (this.eRl != null) {
            this.eRl.pK();
        }
        if (this.eSE != null) {
            this.eSE.bkz();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void l(m mVar) {
        View wx;
        super.l(mVar);
        if (this.eRb != null && (wx = this.eRb.wx()) != null && wx.getParent() != null) {
            ((ViewGroup) wx.getParent()).removeView(wx);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.eRb != null) {
            this.eRb.setOtherParams(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void be(boolean z) {
        super.be(z);
        this.eRj.removeCallbacksAndMessages(null);
        biO();
        this.eRh = false;
        this.eRi = false;
        if (this.eQQ != null) {
            this.eQQ.onDestroy();
        }
        if (this.eQS != null) {
            this.eQS.onDestroy();
        }
        if (this.eQV != null) {
            this.eQV.onDestroy();
        }
        if (this.eQX != null) {
            this.eQX.onDestroy();
        }
        if (this.eQY != null) {
            this.eQY.onDestroy();
        }
        if (this.eQZ != null) {
            this.eQZ.onDestroy();
        }
        if (this.eRa != null) {
            this.eRa.onDestroy();
        }
        if (this.eRc != null) {
            this.eRc.onDestroy();
        }
        if (this.eQR != null) {
            this.eQR.onDestroy();
        }
        if (this.eRg != null) {
            this.eRg.stop();
        }
        if (this.eRN != null) {
            this.eRN.onDestroy();
        }
        if (this.eQP != null) {
            this.eQP.onDestroy();
        }
        if (this.eRR != null) {
            this.eRR.onDestroy();
        }
        if (this.eQT != null) {
            this.eQT.onDestory();
        }
        if (this.eRb != null) {
            this.eRb.a((j.a) null);
            this.eRb.release();
            this.eRb = null;
        }
        if (this.eSE != null) {
            this.eSE.be(z ? false : true);
        }
        MessageManager.getInstance().removeMessageRule(this.eRm);
        MessageManager.getInstance().removeMessageRule(this.eRn);
        MessageManager.getInstance().unRegisterListener(this.eRp);
        MessageManager.getInstance().unRegisterListener(this.eRq);
        MessageManager.getInstance().unRegisterListener(this.eRs);
        MessageManager.getInstance().unRegisterListener(this.eRt);
        MessageManager.getInstance().unRegisterListener(this.eRu);
        MessageManager.getInstance().unRegisterListener(this.eRr);
    }

    private void biO() {
        if (this.eRR != null && this.eRR.wq().getView() != null && this.eRR.wq().getView().getParent() != null) {
            ((ViewGroup) this.eRR.wq().getView().getParent()).removeView(this.eRR.wq().getView());
        }
        if (this.eRd != null && this.eRd.getParent() != null) {
            ((ViewGroup) this.eRd.getParent()).removeView(this.eRd);
        }
        if (this.eRe != null && this.eRe.getParent() != null) {
            ((ViewGroup) this.eRe.getParent()).removeView(this.eRe);
        }
        if (this.eRR != null && this.eRR.wr().getView() != null) {
            this.eSq.removeView(this.eRR.wr().getView());
        }
        if (this.eRR != null) {
            this.eRR.wq().setMsgData(new LinkedList());
            this.eRR.vW();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void a(com.baidu.live.data.x xVar) {
        if (this.eRR != null) {
            bjk();
            this.eRR.wr().setEditText(" @" + xVar.getNameShow() + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.eQT != null) {
            this.eQT.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void f(com.baidu.live.data.a aVar) {
        if (this.eRR != null) {
            bjk();
            this.eRR.wr().setEditText(" @" + aVar.userName + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.eQT != null) {
            this.eQT.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void b(com.baidu.live.data.x xVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected View biP() {
        if (this.eRR != null) {
            return this.eRR.wr().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean biQ() {
        if (this.eRR == null || !this.eRR.wr().xQ()) {
            return false;
        }
        iT(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean biR() {
        return this.eQQ == null || this.eQQ.biR();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup biS() {
        return this.eQN;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup biT() {
        return this.eQO;
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
                    this.eSu = false;
                    J(intExtra, intExtra2, intExtra3);
                    return;
                }
                biI();
                return;
            }
            bjG();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.eSt;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(bjI().pageContext.getPageActivity()) || z2) {
            iS(z);
        }
    }

    private void iS(boolean z) {
        int dimensionPixelSize;
        if (this.eRR != null && this.eRR.wq() != null) {
            this.eRR.wq().onKeyboardVisibilityChanged(z);
        }
        if (z || this.eRR == null || !this.eRR.wr().xQ()) {
            if (z) {
                if (this.eQT != null) {
                    this.eQT.setVisibility(8);
                }
                if (this.eRT != null && this.eRT.sl() != null) {
                    this.eRT.sl().setVisibility(8);
                }
                biV();
                if (this.eRR != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRR.wr().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.eRR.wr().getView().setLayoutParams(layoutParams);
                    this.eRR.wr().getView().setVisibility(0);
                    this.eRR.wr().setQuickInputPanelVisible(false);
                }
                if (this.eSp != null) {
                    this.eSp.setVisibility(8);
                }
                if (this.eQW != null) {
                    this.eQW.setVisible(8);
                }
                if (this.eRS != null) {
                    this.eRS.wy();
                }
                if (this.eSo != null) {
                    this.eSo.setCanVisible(false);
                }
            } else {
                biU();
            }
            if (this.eRR != null && this.eRd != null) {
                int equipmentHeight = (int) ((z ? 0.2f : 0.33f) * BdUtilHelper.getEquipmentHeight(bjI().pageContext.getPageActivity()));
                if (z) {
                    dimensionPixelSize = equipmentHeight + bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64);
                } else {
                    dimensionPixelSize = equipmentHeight + bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
                }
                if (this.eSq.indexOfChild(this.eRd) != -1 && this.eRd.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eRd.getLayoutParams();
                    layoutParams2.height = dimensionPixelSize;
                    this.eRd.setLayoutParams(layoutParams2);
                }
                if (this.eRd.indexOfChild(this.eRR.wq().getView()) != -1 && this.eRR.wq().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.eRR.wq().getView().getLayoutParams();
                    layoutParams3.height = dimensionPixelSize;
                    this.eRR.wq().getView().setLayoutParams(layoutParams3);
                }
                this.eRR.wq().wp();
            }
        }
    }

    private void biU() {
        if (this.eQT != null) {
            this.eQT.setVisibility(0);
        }
        if (this.eRd != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRd.getLayoutParams();
            layoutParams.bottomMargin = bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            this.eRd.setLayoutParams(layoutParams);
        }
        if (this.eRR != null) {
            bjl();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eRR.wr().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.eRR.wr().getView().setLayoutParams(layoutParams2);
        }
        if (this.eQT != null) {
            this.eQT.setVisibility(0);
        }
        if (this.eRT != null && this.eRT.sl() != null) {
            this.eRT.sl().setVisibility(0);
        }
        if (this.eSp != null && (!this.eRh || UtilHelper.getRealScreenOrientation(bjI().pageContext.getPageActivity()) != 2)) {
            this.eSp.setVisibility(0);
        }
        if (this.eQW != null) {
            this.eQW.setVisible(0);
        }
        if (this.eRS != null) {
            this.eRS.wy();
        }
        if (this.eSo != null) {
            this.eSo.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biV() {
        if (this.eRd != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRd.getLayoutParams();
            boolean z = false;
            if (this.eRR != null && this.eRR.wr() != null) {
                z = this.eRR.wr().xP();
            }
            int iX = iX(z);
            if (layoutParams.bottomMargin != iX) {
                layoutParams.bottomMargin = iX;
                this.eRd.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iT(boolean z) {
        if (z) {
            this.eRR.wr().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRd.getLayoutParams();
            int quickInputPanelExpandHeight = this.eRR.wr().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.eRd.setLayoutParams(layoutParams);
                if (this.eRR.wq() != null) {
                    this.eRR.wq().wp();
                    return;
                }
                return;
            }
            return;
        }
        biU();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void j(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        RelativeLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = bjI().pageContext.getPageActivity();
        if (i3 == 1) {
            if (this.eSp != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.eSp.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.eRc != null) {
                this.eRc.dismiss();
            }
            if (this.eRb != null) {
                this.eRb.a((j.a) null);
                this.eRb.vW();
            }
            if (this.awf != null) {
                this.awf.e(true, true);
            }
            if (this.eRf != null) {
                this.eRf.setVisibility(0);
                this.eRf.bringToFront();
            }
            if (this.eRJ != null) {
                this.eRJ.setVisibility(0);
            }
            if (this.eRR != null && this.eRR.wq().getView().getParent() != null && (this.eRR.wq().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.eRR.wq().getView().getParent()).removeView(this.eRR.wq().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bjI().pageContext.getPageActivity()) * 0.75f);
            int equipmentHeight = ((int) (BdUtilHelper.getEquipmentHeight(bjI().pageContext.getPageActivity()) * 0.33f)) + bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
            if (this.eRd != null && this.eRR != null) {
                this.eRd.addView(this.eRR.wq().getView(), new FrameLayout.LayoutParams(equipmentWidth, equipmentHeight));
            }
            if (this.eRe != null && (this.eRe.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.eRe.getParent()).removeView(this.eRe);
            }
            if (this.eRS != null) {
                this.eRS.a(bjI().fai.yO(), false);
                this.eRS.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.14
                    @Override // com.baidu.live.im.j.a
                    public void wz() {
                        a.this.bjw();
                    }
                });
                View wx = this.eRS.wx();
                if (wx != null && this.eSq != null && wx.getParent() == null) {
                    Resources resources = bjI().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bjI().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds80));
                    layoutParams5.addRule(2, a.g.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                    this.eSq.addView(wx, layoutParams5);
                }
            }
            if (this.eRL != null) {
                this.eRL.setPraiseEnable(true);
                bjI().faj.fnc = true;
            }
            if (this.eQP != null && this.eQP.eTA != null && (layoutParams3 = (RelativeLayout.LayoutParams) this.eQP.eTA.getLayoutParams()) != null) {
                this.eQP.eTA.setPadding(0, 0, 0, 0);
                this.eQP.eTA.setLayoutParams(layoutParams3);
            }
            if (this.eRN != null) {
                this.eRN.brv();
            }
            if (this.eRh) {
                iQ(true);
            }
            if (this.eRi) {
                if (this.eQT != null && this.eQT.getLandscapeBarrageImageView() != null) {
                    b(this.eQT.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.eQU != null) {
                this.eQU.jh(true);
            }
            this.eRj.removeCallbacksAndMessages(null);
            if (this.eQV != null) {
                this.eQV.setCanVisible(true);
                this.eQV.t(bjI().fai.yO());
            }
        } else if (i3 == 2) {
            if (this.eRN != null) {
                this.eRN.brw();
            }
            if (this.eSp != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.eSp.getLayoutParams()) != null) {
                layoutParams2.topMargin = bjI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
            }
            if (this.eRS != null) {
                this.eRS.a((j.a) null);
                this.eRS.vW();
            }
            bjI().faj.brc();
            if (this.awf != null) {
                this.awf.e(false, true);
            }
            if (this.eRf != null) {
                this.eRf.setVisibility(4);
            }
            if (this.eRR != null && this.eRR.wq().getView().getParent() != null && (this.eRR.wq().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.eRR.wq().getView().getParent()).removeView(this.eRR.wq().getView());
            }
            int max = Math.max(i, i2);
            if (this.eRe != null) {
                if (this.eRe.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eRe.getParent()).removeView(this.eRe);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
                bjI().faj.addView(this.eRe, layoutParams6);
            }
            if (this.eRe != null && this.eRb != null) {
                this.eRb.a(bjI().fai.yO(), false);
                this.eRb.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.15
                    @Override // com.baidu.live.im.j.a
                    public void wz() {
                        a.this.bjw();
                    }
                });
                View wx2 = this.eRb.wx();
                if (wx2 != null && this.eRe.indexOfChild(wx2) < 0) {
                    this.eRe.addView(wx2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bjI().pageContext.getPageActivity()), -1));
                }
            }
            if (this.eRL != null) {
                this.eRL.al(bjI().faj);
                this.eRL.setPraiseEnable(false);
                bjI().faj.fnc = false;
            }
            if (this.eQP != null && this.eQP.eTA != null && (layoutParams = (RelativeLayout.LayoutParams) this.eQP.eTA.getLayoutParams()) != null) {
                int width = this.eQP.eTA.getWidth();
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                this.eQP.eTA.setPadding(width - ((int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f)), 0, 0, 0);
                this.eQP.eTA.setLayoutParams(layoutParams);
            }
            if (this.eQU != null) {
                this.eQU.jh(false);
            }
            if (aa.sO() != null) {
                aa.sO().sN();
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.x.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.x.c) runTask.getData()).sN();
            }
            if (this.eQT != null && this.eQT.getLandscapeBarrageImageView() != null) {
                b(this.eQT.getLandscapeBarrageImageView(), this.eRi, false);
            }
            this.eRj.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.16
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.eRh) {
                        a.this.iQ(false);
                    }
                }
            }, 5000L);
            if (this.eRT != null) {
                this.eRT.sn();
            }
            if (this.eQV != null) {
                this.eQV.setCanVisible(false);
                this.eQV.bmg();
            }
        }
        if (this.eRU != null) {
            if (i3 == 2) {
                View sC = this.eRU.sC();
                if (sC != null) {
                    if (sC.getParent() != null && (sC.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) sC.getParent()).removeView(sC);
                    }
                    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams7.addRule(5, a.g.ala_liveroom_hostheader);
                    layoutParams7.addRule(3, a.g.ala_liveroom_hostheader);
                    layoutParams7.topMargin = bjI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                    if (this.eSp != null) {
                        this.eSp.addView(sC, layoutParams7);
                    }
                }
            } else {
                View sC2 = this.eRU.sC();
                if (sC2 != null) {
                    if (sC2.getParent() != null && (sC2.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) sC2.getParent()).removeView(sC2);
                    }
                    RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams8.topMargin = bjI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds4);
                    layoutParams8.addRule(3, a.g.ala_live_header_view);
                    bjI().faj.addView(sC2, layoutParams8);
                }
            }
        }
        if (this.eQT != null) {
            this.eQT.j(i, i2, i3);
        }
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.eQP != null) {
                this.eQP.bW(i3);
            }
            if (this.eQR != null) {
                this.eQR.bW(i3);
            }
            pS(i3);
            if (this.eQW != null) {
                this.eQW.bW(i3);
            }
            if (this.eRX != null) {
                this.eRX.bW(i3);
            }
            if (this.eSg != null) {
                this.eSg.bW(i3);
            }
            if (this.eRk != null && this.eRk.isShowing()) {
                this.eRk.resize();
            }
            if (this.eSo != null) {
                this.eSo.bW(i3);
            }
        }
        if (this.eRT != null) {
            this.eRT.sm();
        }
        super.j(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public boolean cc(int i) {
        boolean cc = super.cc(i);
        if (cc && 2 == i) {
            if (this.eQQ.biR()) {
                return false;
            }
            if (cc && this.eRN != null) {
                this.eRN.jR(false);
            }
        }
        return cc;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void pR(int i) {
        super.pR(i);
        if (i == 7 || i == 11) {
            if (i != 7 || UtilHelper.getRealScreenOrientation(bjI().pageContext.getPageActivity()) != 2) {
                if (this.eQT != null) {
                    this.eQT.setVisibility(8);
                }
                if (this.eRR != null) {
                    this.eRR.wq().getView().setVisibility(4);
                }
                if (this.eSh != null) {
                    this.eSh.jM(false);
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
            if (this.eQT != null) {
                this.eQT.setVisibility(0);
            }
            if (this.eRR != null) {
                this.eRR.wq().getView().setVisibility(0);
            }
            if (this.eSh != null) {
                this.eSh.jM(true);
            }
            if (!this.eRh || UtilHelper.getRealScreenOrientation(bjI().pageContext.getPageActivity()) != 2) {
                this.eSp.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.eQS != null) {
            this.eQS.bqn();
        }
        if (this.eQY != null) {
            this.eQY.pU();
        }
        if (this.eQW != null) {
            this.eQW.onStop();
        }
        if (bjI() != null) {
            BdUtilHelper.hideSoftKeyPad(bjI().pageContext.getPageActivity(), bjI().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.eQS != null) {
            this.eQS.bqm();
        }
        if (this.eQY != null) {
            this.eQY.pV();
        }
        if (this.eQW != null) {
            this.eQW.onStart();
        }
    }

    private void pS(int i) {
        if (this.eQN != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eQN.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.bottomMargin = bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
                layoutParams.height = bir();
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds72) + 0 + bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds22) + bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                layoutParams.rightMargin = bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
                layoutParams.height = -2;
            }
            this.eQN.setLayoutParams(layoutParams);
        }
    }
}
