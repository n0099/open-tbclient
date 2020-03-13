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
    private PriorityVerticalLinearLayout eRa;
    private LinearLayout eRb;
    private com.baidu.tieba.ala.liveroom.audiencelist.c eRc;
    private com.baidu.tieba.ala.liveroom.l.a eRd;
    private com.baidu.tieba.ala.liveroom.e.b eRe;
    private com.baidu.tieba.ala.liveroom.r.b eRf;
    private com.baidu.tieba.ala.liveroom.operation.a eRg;
    private com.baidu.tieba.ala.liveroom.audiencelist.b eRh;
    private com.baidu.tieba.ala.liveroom.j.a eRi;
    private com.baidu.tieba.ala.liveroom.activeview.b eRj;
    private com.baidu.live.d.a eRk;
    private j eRl;
    private i eRm;
    private com.baidu.tieba.ala.liveroom.attentionpop.b eRn;
    private com.baidu.live.im.j eRo;
    private com.baidu.tieba.ala.liveroom.share.b eRp;
    private FrameLayout eRq;
    private FrameLayout eRr;
    private ImageView eRs;
    private com.baidu.live.tieba.e.b eRt;
    private x eRx;
    private com.baidu.tieba.ala.liveroom.h.b eRy;
    private long lastClickTime = 0;
    private boolean eRu = false;
    private boolean eRv = false;
    private Handler eRw = new Handler();
    private HttpRule eRz = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.eRl != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.eRl.qa()) {
                httpMessage.addParam("ala_challenge_id", a.this.eRl.qd());
            }
            return httpMessage;
        }
    };
    private HttpRule eRA = new HttpRule(1021151) { // from class: com.baidu.tieba.ala.liveroom.c.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.eRl != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.eRl.qa()) {
                httpMessage.addParam("challenge_id", a.this.eRl.qd());
            }
            return httpMessage;
        }
    };
    private com.baidu.live.liveroom.g.c eRB = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.c.a.17
        @Override // com.baidu.live.liveroom.g.c
        public void yM() {
            if (a.this.eSa != null) {
                a.this.eSa.jR(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bg(boolean z) {
            if (z) {
                if (a.this.eRg != null) {
                    a.this.eRg.qz(8);
                }
                if (a.this.eSa != null) {
                    a.this.eSa.jR(true);
                }
            } else {
                if (a.this.eRg != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                        a.this.eRg.qz(0);
                    } else {
                        a.this.eRg.qz(8);
                    }
                }
                if (a.this.eSa != null) {
                    a.this.eSa.jR(false);
                }
            }
            if (a.this.eSr != null) {
                a.this.eSr.aB(z);
            }
        }
    };
    private HttpMessageListener eRC = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.a.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.yW() != null) {
                        com.baidu.live.v.c.zq().axN = getQuickGiftHttpResponseMessage.yW();
                        a.this.biC();
                    }
                }
            }
        }
    };
    private CustomMessageListener eRD = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.a.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.biL();
        }
    };
    private CustomMessageListener eRE = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.c.a.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.eSv != null) {
                    a.this.eSv.yS(str);
                }
            }
        }
    };
    CustomMessageListener eRF = new CustomMessageListener(CmdConfigCustom.CMD_HOST_GET_WALLET_UA) { // from class: com.baidu.tieba.ala.liveroom.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.eSJ != null && a.this.eSJ.apY != null && !a.this.eSJ.aqb && !a.this.eSJ.aqc && a.this.eSq != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.bjJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = a.this.bjJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                a.this.eSq.b(a.this.eRq, layoutParams);
                if (e.vG() != null) {
                    e.vG().vM();
                }
            }
        }
    };
    private CustomMessageListener eRG = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof String)) {
                if (a.this.eSt != null) {
                    a.this.eSt.dismiss();
                }
                k.wA().setSwitchStatus(true);
                k.wA().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bjl();
                    }
                }, 500L);
            }
        }
    };
    CustomMessageListener eRH = new CustomMessageListener(2913168) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913168) {
                if ("isAttentionOrGift".equals(customResponsedMessage.getData())) {
                    a.this.eRy.c(a.this.bjJ());
                } else if (a.this.bjf() || !g.qa(2913168)) {
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
                        }
                    }, 3000L);
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.leftMargin = a.this.bjJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    layoutParams.bottomMargin = a.this.bjJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                    a.this.eRy.b(a.this.eRq, layoutParams);
                }
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b eRI = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.a.8
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
                        alaStaticItem.addParams("gifts_value", com.baidu.live.v.c.zq().axN.su().getPrice());
                        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.v.c.zq().axN.su().rx());
                        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.v.c.zq().axN.su().ry());
                        if (a.this.bjJ().fav.yO() != null && a.this.bjJ().fav.yO().mLiveInfo != null) {
                            alaStaticItem.addParams("feed_id", a.this.bjJ().fav.yO().mLiveInfo.feed_id);
                            alaStaticItem.addParams("room_id", a.this.bjJ().fav.yO().mLiveInfo.room_id);
                        }
                        alaStaticItem.addParams("other_params", a.this.xx());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (a.this.uX()) {
                        if (com.baidu.live.c.pr().getBoolean("quick_gift_guide_show", true) && !a.this.bjf()) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913166, x.class, a.this.bjJ().pageContext.getPageActivity());
                            if (runTask != null && runTask.getData() != null) {
                                x xVar = (x) runTask.getData();
                                xVar.setPageContext(a.this.bjJ().pageContext);
                                xVar.d(a.this.bjJ().fav.yO());
                                xVar.a(com.baidu.live.v.c.zq().axN.su());
                                xVar.setOtherParams(a.this.xx());
                                xVar.initView();
                                xVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.8.1
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        a.this.iV(false);
                                        a.this.eRx = null;
                                    }
                                });
                                a.this.eRx = xVar;
                                xVar.show();
                                a.this.iV(true);
                                return;
                            }
                            return;
                        }
                        n.a(a.this.bjJ().pageContext, a.this.bjJ().fav.yO(), com.baidu.live.v.c.zq().axN.su(), a.this.xx());
                    }
                } else if (i == 1) {
                    if (a.this.eSe != null) {
                        a.this.bjl();
                    }
                } else if (i == 3 && a.this.uX()) {
                    if (a.this.mOrientation == 2 && TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.eRp != null) {
                            a.this.eRp.x(a.this.bjJ().fav.yO());
                        }
                    } else {
                        a.this.eRT.c(a.this.bjJ().fav.yO(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.bjJ() != null && a.this.bjJ().fav != null && a.this.bjJ().fav.yO() != null && a.this.bjJ().fav.yO().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.bjJ().fav.yO().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.bjJ().fav.yO().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.bjJ().fav.yO().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.xx());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.bjJ() != null && a.this.bjJ().fav != null && a.this.bjJ().fav.yO() != null && a.this.bjJ().fav.yO().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.bjJ().fav.yO().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.bjJ().fav.yO().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.bjJ().fav.yO().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.xx());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.awg != null) {
                        a.this.awg.bb(false);
                    }
                } else if (i == 12) {
                    if (a.this.eSa != null) {
                        String valueOf = String.valueOf(a.this.bjJ().fav.yO().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.bjJ().fav.yO().mLiveInfo.room_id);
                        String str2 = null;
                        com.baidu.live.data.k kVar = a.this.bjJ().fav.yO().mLiveSdkInfo;
                        if (kVar != null && kVar.mCastIds != null) {
                            str2 = String.valueOf(a.this.bjJ().fav.yO().mLiveSdkInfo.mCastIds.XX);
                        }
                        a.this.eSa.ad(valueOf, valueOf2, str2);
                        if (com.baidu.live.liveroom.a.ym().yn()) {
                            a.this.biL();
                        }
                    }
                } else if (i == 14) {
                    m yO = a.this.bjJ().fav.yO();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.bjJ().pageContext.getPageActivity(), yO.XQ.userName, Long.toString(yO.XQ.userId), Long.toString(yO.XQ.charmCount), String.valueOf(yO.mLiveInfo.group_id), String.valueOf(yO.mLiveInfo.live_id), false, String.valueOf(yO.XQ.userId), Long.toString(yO.Ye.userId), yO.Ye.userName, yO.Ye.portrait, a.this.eRh.getCount(), a.this.xx())));
                    LogManager.getCommonLogger().doClickGusetNumLog(yO.mLiveInfo.feed_id, a.this.eRh.getCount() + "", a.this.xx());
                } else if (i == 11) {
                    a.this.bjo();
                    a.this.bjp();
                } else if (i == 15) {
                    if (a.this.eSo != null && a.this.bjJ() != null && a.this.bjJ().fav != null && a.this.bjJ().fav.yO() != null && a.this.bjJ().fav.yO().mLiveInfo != null) {
                        long j = a.this.bjJ().fav.yO().mLiveInfo.live_id;
                        String valueOf3 = String.valueOf(a.this.bjJ().fav.yO().mLiveInfo.feed_id);
                        long j2 = a.this.bjJ().fav.yO().mLiveInfo.room_id;
                        String str3 = a.this.bjJ().fav.yO().mLiveInfo.cover;
                        String str4 = "";
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        if (a.this.bjJ().fav.yO().mLiveInfo.session_info != null) {
                            str4 = a.this.bjJ().fav.yO().mLiveInfo.session_info.flvUrl;
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
                        a.this.eSo.yS(o.a(valueOf3, j + "", j2, false, 1, str3, str4, str5, str6, str7));
                        o.aDR = j;
                        if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                            ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                            LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf3, a.this.xx());
                        }
                    }
                } else if (i == 16) {
                    if (a.this.bjJ() != null && (apVar2 = com.baidu.live.v.a.zl().axD) != null && (ayVar2 = apVar2.acS) != null) {
                        String str8 = ayVar2.adP.adW;
                        if (!TextUtils.isEmpty(str8)) {
                            long j3 = 0;
                            if (a.this.bjJ().fav != null && a.this.bjJ().fav.yO() != null && a.this.bjJ().fav.yO().mLiveInfo != null) {
                                j3 = a.this.bjJ().fav.yO().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j3 + "", a.this.bjJ().fav.yO().mLiveInfo.room_id + "", a.this.bjJ().fav.yO().mLiveInfo.feed_id, a.this.xx());
                            }
                            if (str8.contains("?")) {
                                str = str8 + "&liveId=" + j3;
                            } else {
                                str = str8 + "?liveId=" + j3;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.bjJ().pageContext.getPageActivity(), str);
                        }
                    }
                } else if (i == 17) {
                    if (a.this.uX() && a.this.bjJ() != null && (apVar = com.baidu.live.v.a.zl().axD) != null && (ayVar = apVar.acS) != null && (beVar = ayVar.adQ) != null && !TextUtils.isEmpty(beVar.webUrl) && a.this.eSt != null && a.this.bjJ().fav != null && a.this.bjJ().fav.yO() != null) {
                        m yO2 = a.this.bjJ().fav.yO();
                        a.this.eSt.a(beVar.webUrl, yO2.mLiveInfo.live_id, yO2.Ye.userId, yO2.XQ.userId);
                        a.this.eRt.bn(false);
                        a.this.eRt.Ac();
                    }
                } else if (i == 18) {
                    if (a.this.eRv) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.eRv = !a.this.eRv;
                } else if (i == 19 && a.this.eRt != null) {
                    a.this.eRt.Ac();
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.eRV = new com.baidu.tieba.ala.liveroom.guide.c(bjJ().pageContext, this, false);
        this.eRz.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.eRz);
        this.eRA.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.eRA);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean bin() {
        return false;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void k(m mVar) {
        super.k(mVar);
        g.bmc();
        this.eRv = false;
        if (this.eRY != null) {
            this.eRY.b(this.eRI);
        }
        if (this.eRt == null) {
            this.eRt = new com.baidu.live.tieba.e.b(bjJ().pageContext.getPageActivity());
            this.eRt.start();
        }
        this.eRt.bn(true);
        bjJ().pageContext.getPageActivity().setRequestedOrientation(-1);
        bjJ().faw.setIsForceHandledTouch(false);
        bjJ().faw.setSwipeClearEnable(true);
        bjJ().faw.setOnLiveViewScrollListener(this.eRB);
        bjJ().faw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eRw.removeCallbacksAndMessages(null);
                a.this.iQ(false);
                if (!a.this.eRu) {
                    a.this.eRw.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.eRu) {
                                a.this.iQ(false);
                            }
                        }
                    }, 5000L);
                }
            }
        });
        if (this.eSC != null) {
            this.eSC.setVisibility(0);
        }
        bir();
        biu();
        biF();
        bjb();
        biG();
        biq();
        biI();
        biH();
        iR(false);
        bjs();
        bjr();
        biw();
        biD();
        biE();
        bju();
        bio();
        biK();
        biM();
        iW(true);
        biv();
        biC();
        bjA();
        bix();
        biy();
        biz();
        biA();
        biN();
        bjz();
        if (this.eSt != null && this.eSt.bqD() == null) {
            this.eSt.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.19
                @Override // com.baidu.tieba.ala.liveroom.turntable.d.a
                public void onDismiss() {
                    a.this.eRt.bn(true);
                }
            });
        }
        MessageManager.getInstance().registerListener(this.eRC);
        MessageManager.getInstance().registerListener(this.eRD);
        MessageManager.getInstance().registerListener(this.eRF);
        MessageManager.getInstance().registerListener(this.eRG);
        MessageManager.getInstance().registerListener(this.eRH);
        MessageManager.getInstance().registerListener(this.eRE);
        biO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iQ(boolean z) {
        View sC;
        if (bjJ() != null && bjJ().pageContext != null && bjJ().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(bjJ().pageContext.getPageActivity()) == 2 || z) {
                if (this.eSh != null && (sC = this.eSh.sC()) != null) {
                    if (this.eRu) {
                        sC.setVisibility(0);
                    } else {
                        sC.setVisibility(8);
                    }
                }
                if (this.eRu) {
                    if (this.eSC != null) {
                        this.eSC.setVisibility(0);
                    }
                    if (this.eSD != null) {
                        this.eSD.setVisibility(0);
                    }
                    if (this.eRb != null) {
                        this.eRb.setVisibility(0);
                    }
                    if (this.eRa != null) {
                        this.eRa.setVisibility(0);
                    }
                    if (this.eSg != null) {
                        this.eSg.az(false);
                    }
                } else {
                    if (this.eSC != null) {
                        this.eSC.setVisibility(8);
                    }
                    if (this.eSD != null) {
                        this.eSD.setVisibility(8);
                    }
                    if (this.eRb != null) {
                        this.eRb.setVisibility(8);
                    }
                    if (this.eRa != null) {
                        this.eRa.setVisibility(8);
                    }
                    if (this.eSg != null) {
                        this.eSg.az(true);
                    }
                }
                this.eRu = this.eRu ? false : true;
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
            if (this.eRr != null) {
                this.eRr.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_on);
            }
            if (this.eRr != null) {
                this.eRr.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.eSg != null && (sl = this.eSg.sl()) != null) {
            if (z) {
                sl.setVisibility(8);
            } else {
                sl.setVisibility(0);
            }
        }
    }

    private void bio() {
        CustomResponsedMessage runTask;
        if (this.eRo == null && (runTask = MessageManager.getInstance().runTask(2913164, com.baidu.live.im.j.class, bjJ().pageContext)) != null) {
            this.eRo = (com.baidu.live.im.j) runTask.getData();
        }
        if (this.eRo != null) {
            this.eRo.setOtherParams(this.otherParams);
            this.eRo.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.20
                @Override // com.baidu.live.im.j.a
                public void wz() {
                    a.this.bjx();
                }
            });
        }
    }

    private void bip() {
        if (this.eRZ != null) {
            this.eRZ.ai(bjJ().fau.getLiveContainerView());
        }
    }

    private void biq() {
        if (this.eRp == null) {
            this.eRp = new com.baidu.tieba.ala.liveroom.share.b(bjJ().pageContext);
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bk(int i) {
        super.bk(i);
        if (this.eRs != null && UtilHelper.getRealScreenOrientation(bjJ().pageContext.getPageActivity()) != 2) {
            this.eRs.setVisibility(0);
        }
        bip();
        if (this.eRm != null) {
            this.eRm.bk(i);
        }
        if (this.eRm == null || !this.eRm.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void iR(boolean z) {
        super.iR(z);
        this.eSg.br(bjJ().fav.yO().mLiveInfo.screen_direction);
    }

    private void bir() {
        if (this.eRa == null) {
            this.eRa = new PriorityVerticalLinearLayout(bjJ().pageContext.getPageActivity());
            this.eRa.setDefaultItemMargin(bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            bit();
        }
        if (this.eRa.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, bis());
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            layoutParams.rightMargin = bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
            layoutParams.bottomMargin = bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
            bjJ().faw.addView(this.eRa, layoutParams);
        }
    }

    private int bis() {
        int bottom;
        int bottom2;
        if (bjJ().awj.getLivePlayer().getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bjJ().awj.getLivePlayer().getLayoutParams();
            bottom = layoutParams.topMargin + layoutParams.height;
        } else {
            bottom = bjJ().awj.getLivePlayer().getBottom();
        }
        if (bjJ().faw.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) bjJ().faw.getLayoutParams();
            bottom2 = layoutParams2.topMargin + layoutParams2.height;
        } else {
            bottom2 = bjJ().faw.getBottom();
        }
        return ((bottom2 - bottom) - bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
    }

    private void bit() {
        View view = new View(bjJ().pageContext.getPageActivity());
        view.setTag(a.g.sdk_pvl_layout_priority_tag_key, 20);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(1, 0);
        layoutParams.weight = 1.0f;
        this.eRa.addView(view, layoutParams);
    }

    private void biu() {
        if (this.eRb == null) {
            this.eRb = new LinearLayout(bjJ().pageContext.getPageActivity());
            this.eRb.setOrientation(1);
        }
        if (this.eRb.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds228);
            layoutParams.leftMargin = bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bjJ().faw.addView(this.eRb, layoutParams);
        }
    }

    private void biv() {
        if (this.eRj == null) {
            this.eRj = new com.baidu.tieba.ala.liveroom.activeview.b(bjJ().pageContext);
        }
        this.eRj.setOtherParams(xx());
        this.eRj.b(bjJ().fav.yO(), true);
        this.eRj.setHost(false);
        this.eRj.a(1, this.eRa, pQ(1));
        this.eRj.a(2, this.eRa, pQ(2));
        this.eRj.setVisible(this.eSG ? 8 : 0);
    }

    private void biw() {
        if (this.eRX != null && bjJ() != null && bjJ().fav != null) {
            this.eRX.b(this.eSC, bjJ().fav.yO());
        }
    }

    private ViewGroup.LayoutParams pQ(int i) {
        switch (i) {
            case 1:
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = bjJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds40);
                return layoutParams;
            case 2:
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 5;
                layoutParams2.topMargin = bjJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                return layoutParams2;
            default:
                return new RelativeLayout.LayoutParams(-1, -2);
        }
    }

    private void bix() {
        if (this.eRa != null) {
            if (this.eRi == null) {
                this.eRi = new com.baidu.tieba.ala.liveroom.j.a(bjJ().pageContext, this);
            }
            this.eRi.setOtherParams(xx());
            this.eRi.d(this.eRa, biB());
            this.eRi.t(bjJ().fav.yO());
        }
    }

    private void biy() {
        if (this.eSq == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, com.baidu.live.guardclub.j.class, bjJ().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.eSq = (com.baidu.live.guardclub.j) runTask.getData();
            } else {
                return;
            }
        }
        this.eSq.setOtherParams(xx());
        if (this.eRq != null && this.eRq.indexOfChild(this.eSq.getView()) >= 0) {
            this.eRq.removeView(this.eSq.getView());
        }
    }

    private void biz() {
        if (this.eRg != null) {
            this.eRg.a(new a.InterfaceC0465a() { // from class: com.baidu.tieba.ala.liveroom.c.a.5
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0465a
                public void bl(int i, int i2) {
                    m yO = a.this.bjJ().fav.yO();
                    if (yO != null && yO.mLiveInfo != null) {
                        if (a.this.eSu == null) {
                            a.this.eSu = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.bjJ().pageContext.getPageActivity());
                        }
                        a.this.eSu.d(a.this.eSD, i, i2);
                        a.this.eSu.a(String.valueOf(yO.mLiveInfo.live_id), new a.InterfaceC0467a() { // from class: com.baidu.tieba.ala.liveroom.c.a.5.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0467a
                            public void a(float f, String str) {
                                if (a.this.eRg != null) {
                                    a.this.eRg.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0465a
                public void bm(int i, int i2) {
                    if (a.this.eSu != null) {
                        a.this.eSu.br(i, i2);
                    }
                }
            });
        }
    }

    private void biA() {
        if (this.eSR == null) {
            this.eSR = new com.baidu.tieba.ala.liveroom.h.e(bjJ().pageContext);
        }
        this.eSR.setRoomId(bjJ().fav.yO().mLiveInfo.room_id);
        this.eSR.zb("");
        this.eSR.a(bjJ().fav.yO(), this.eRa);
        if (this.eRy == null) {
            this.eRy = new com.baidu.tieba.ala.liveroom.h.b(bjJ().pageContext, xx(), this.eSR, new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.6
                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void biX() {
                    a.this.iV(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.h.b.a
                public void biY() {
                    a.this.iV(false);
                }
            });
        }
        this.eRy.setRoomId(bjJ().fav.yO().mLiveInfo.room_id);
        if (this.eRq != null && this.eRq.indexOfChild(this.eRy.getView()) >= 0) {
            this.eRq.removeView(this.eRy.getView());
        }
        if (this.eRy != null) {
            this.eRy.b(bjJ());
        }
    }

    private ViewGroup.LayoutParams biB() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = bjJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biC() {
        if (this.eRg == null) {
            biH();
        }
        this.eRg.a(com.baidu.live.v.c.zq().axN, bjJ().fav.yO());
    }

    private void biD() {
        CustomResponsedMessage runTask;
        if (this.eSe == null && (runTask = MessageManager.getInstance().runTask(2913039, com.baidu.live.im.i.class, bjJ().pageContext)) != null && runTask.getData() != null) {
            this.eSe = (com.baidu.live.im.i) runTask.getData();
            this.eSe.setFromMaster(false);
            this.eSe.wq().getView().setId(a.g.ala_liveroom_msg_list);
            this.eSe.a(new i.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.7
                @Override // com.baidu.live.im.i.a
                public boolean ws() {
                    return a.this.uX();
                }

                @Override // com.baidu.live.im.i.a
                public void wt() {
                    a.this.eSK = true;
                }

                @Override // com.baidu.live.im.i.a
                public void dM(String str) {
                    if (!a.this.eSG) {
                        a.this.iT(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.bjJ().pageContext.getPageActivity(), a.this.bjJ().fau.getLiveContainerView());
                    }
                    a.this.yP(str);
                }

                @Override // com.baidu.live.im.i.a
                public void wu() {
                    if (a.this.eSG) {
                        a.this.iT(true);
                        a.this.bjJ().fau.getLiveContainerView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.bjJ().pageContext.getPageActivity(), a.this.bjJ().fau.getLiveContainerView());
                            }
                        }, 10L);
                    } else if (a.this.eSe != null) {
                        a.this.eSe.wr().setQuickInputPanelVisible(false);
                        a.this.eSe.wr().xR();
                    }
                }

                @Override // com.baidu.live.im.i.a
                public void wv() {
                    if (a.this.eSG) {
                        a.this.biW();
                        if (a.this.eSf != null) {
                            a.this.eSf.wy();
                        }
                        if (a.this.eRo != null) {
                            a.this.eRo.wy();
                        }
                    } else if (a.this.eSe != null) {
                        a.this.eSe.wr().setQuickInputPanelVisible(false);
                        a.this.eSe.wr().xR();
                    }
                }

                @Override // com.baidu.live.im.i.a
                public boolean ww() {
                    return a.this.bjg();
                }
            });
            this.eRq = new FrameLayout(bjJ().pageContext.getPageActivity());
            this.eRq.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.eSe != null && this.eRq != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bjJ().pageContext.getPageActivity()) * 0.75f);
            int dimensionPixelSize = bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds120) + ((int) (BdUtilHelper.getEquipmentHeight(bjJ().pageContext.getPageActivity()) * 0.33f));
            if (this.eSD.indexOfChild(this.eRq) < 0) {
                if (this.eRq.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eRq.getParent()).removeView(this.eRq);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                this.eSD.addView(this.eRq, layoutParams);
            }
            if (this.eRq.indexOfChild(this.eSe.wq().getView()) < 0) {
                if (this.eSe.wq().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eSe.wq().getView()).removeView(this.eSe.wq().getView());
                }
                if (UtilHelper.getRealScreenOrientation(bjJ().pageContext.getPageActivity()) != 2) {
                    this.eRq.addView(this.eSe.wq().getView(), new FrameLayout.LayoutParams(equipmentWidth, dimensionPixelSize));
                }
            }
            if (bjJ().faw.indexOfChild(this.eSe.wr().getView()) < 0) {
                if (this.eSe.wr().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eSe.wr().getView().getParent()).removeView(this.eSe.wr().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bjm();
                bjJ().faw.addView(this.eSe.wr().getView(), layoutParams2);
            }
            m yO = bjJ().fav.yO();
            if (yO != null && yO.mLiveInfo != null) {
                this.eSe.setLogData(yO.mLiveInfo.feed_id, xx());
            }
            this.eSe.e(String.valueOf(bjJ().fav.yO().mLiveInfo.group_id), String.valueOf(bjJ().fav.yO().mLiveInfo.last_msg_id), String.valueOf(bjJ().fav.yO().XQ.userId), String.valueOf(bjJ().fav.yO().mLiveInfo.live_id), bjJ().fav.yO().XQ.appId);
            iT(false);
        }
    }

    private void biE() {
        if (this.eRr == null) {
            this.eRr = new FrameLayout(bjJ().pageContext.getPageActivity());
            this.eRr.setId(a.g.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void biF() {
        if (this.eRd == null) {
            this.eRd = new com.baidu.tieba.ala.liveroom.l.a(bjJ().pageContext, false, this);
        }
        this.eRd.c(this.eSC, bjJ().fav.yO());
        this.eRd.a(this.eRI);
    }

    private void biG() {
        if (this.eRc == null) {
            this.eRc = new com.baidu.tieba.ala.liveroom.audiencelist.c(bjJ().pageContext, this, false);
        }
        this.eRc.a(String.valueOf(bjJ().fav.yO().mLiveInfo.group_id), String.valueOf(bjJ().fav.yO().mLiveInfo.live_id), String.valueOf(bjJ().fav.yO().XQ.userId), bjJ().fav.yO());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.eRS != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.eRc.c(this.eSC, i, a.g.ala_liveroom_audience_count_layout);
            this.eRc.f(bjJ().fav.bdZ());
        }
    }

    private void biH() {
        if (this.eRg == null) {
            this.eRg = new com.baidu.tieba.ala.liveroom.operation.a(bjJ().pageContext);
        }
        this.eRg.a(bjJ(), this.eSD, bjJ().fav.yO().mLiveInfo.live_type, true, this.eRI);
        this.eRg.setOtherParams(xx());
    }

    private void biI() {
        if (this.eRh == null) {
            this.eRh = new com.baidu.tieba.ala.liveroom.audiencelist.b(bjJ().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (bjJ().fav.bdZ() != null) {
            j = bjJ().fav.bdZ().getCount();
        }
        this.eRh.a(this.eRI);
        this.eRh.a(this.eSC, a.g.ala_liveroom_audience, j);
        this.eRh.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.eRh.ji(false);
        } else {
            this.eRh.ji(true);
        }
    }

    public void biJ() {
        this.eRT.c(bjJ().fav.yO(), false);
    }

    public void biK() {
        if (bjJ().fav.yO() != null && bjJ().fav.yO().XQ != null && bjJ().fav.yO().mLiveInfo != null) {
            if (this.eRf == null) {
                this.eRf = new com.baidu.tieba.ala.liveroom.r.b(bjJ().pageContext);
            }
            long j = bjJ().fav.yO().XQ.userId;
            int i = bjJ().fav.yO().mLiveInfo.live_type;
            String str = bjJ().fav.yO().XQ.portrait;
            String str2 = bjJ().fav.yO().mLiveInfo.feed_id;
            long j2 = bjJ().fav.yO().mLiveInfo.live_id;
            this.eRf.a(i, j, bjJ().fav.yO().XQ.userName, false, str, xx(), str2, j2);
            this.eRf.af(this.eSC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biL() {
        String str;
        if (bjJ() != null && bjJ().fav != null && bjJ().fav.yO() != null && bjJ().fav.yO().Ye != null && (str = bjJ().fav.yO().Ye.userName) != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bjJ().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt)) && !bjf()) {
            com.baidu.live.c.pr().putInt("guide_rename_show_count", com.baidu.live.c.pr().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.ym().ba(true);
            if (this.eSx == null) {
                this.eSx = new com.baidu.tieba.ala.liveroom.s.a(bjJ().pageContext);
            }
            this.eSx.setOtherParams(xx());
            this.eSx.e(this.eSD, bjJ().fav.yO());
            iV(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.9
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eSx.bqq();
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

    private void biM() {
        if (this.eSa == null) {
            this.eSa = new com.baidu.tieba.ala.liveroom.u.a(bjJ().pageContext, this);
        }
        this.eSa.d(bjJ().faw, false);
        this.eSa.jQ(bjI());
    }

    private void biN() {
        if (bjJ() != null && bjJ().awj != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(bjJ().pageContext.getPageActivity());
            Activity pageActivity = bjJ().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + pageActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds176)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.eRs = new ImageView(bjJ().pageContext.getPageActivity());
            this.eRs.setVisibility(8);
            this.eRs.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.eRs.setImageResource(a.f.icon_live_enlarge);
            this.eRs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.eRt != null) {
                        a.this.eRt.Ab();
                        a.this.eRs.setVisibility(4);
                    }
                }
            });
            bjJ().faw.addView(this.eRs, layoutParams);
            if (UtilHelper.getRealScreenOrientation(bjJ().pageContext.getPageActivity()) != 2) {
                if (bjJ().faB) {
                    this.eRs.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.12
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.eRs != null && UtilHelper.getRealScreenOrientation(a.this.bjJ().pageContext.getPageActivity()) != 2) {
                                a.this.eRs.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
        }
    }

    private void biO() {
        if (this.eSK || this.eSL) {
            if ((TbadkCoreApplication.isLogin() && this.eSe.wr().hasText()) || this.eSL) {
                this.eSK = false;
                this.eSL = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bjl();
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
                if (this.eRi != null) {
                    this.eRi.u(jSONObject);
                }
            } else if ("enter_live".equals(optString)) {
                if (this.eRh.getCount() > 20) {
                    this.eRh.cD(this.eRh.getCount() + 1);
                } else if (this.eRc != null) {
                    com.baidu.live.data.a xo = aVar.xo();
                    com.baidu.live.data.g gVar = new com.baidu.live.data.g();
                    gVar.XR = new AlaLocationData();
                    gVar.XS = new AlaRelationData();
                    gVar.XQ = new AlaLiveUserInfoData();
                    gVar.XQ.userId = JavaTypesHelper.toLong(xo.userId, 0L);
                    gVar.XQ.userName = xo.userName;
                    gVar.XQ.portrait = xo.portrait;
                    if (this.eRc.c(gVar)) {
                        this.eRh.cD(this.eRh.getCount() + 1);
                    }
                }
            } else if ("update_liveinfo".equals(optString) && bjJ().fav.yO() != null && bjJ().fav.yO().mLiveInfo != null) {
                bjJ().fav.a(bjJ().fav.yO().mLiveInfo.live_id, bjJ().fromType, bjJ().enterTime);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void yL(String str) {
        if (this.eRj != null) {
            this.eRj.yL(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void i(m mVar) {
        super.i(mVar);
        if (this.eRd != null) {
            this.eRd.u(mVar);
        }
        if (this.eRe != null) {
            this.eRe.q(mVar);
        }
        if (this.eRi != null) {
            this.eRi.t(mVar);
        }
        if (this.eRm != null) {
            this.eRm.a(mVar);
        }
        if (this.eRo != null) {
            this.eRo.a(mVar);
        }
        if (this.eRj != null) {
            this.eRj.h(mVar);
            if (mVar != null && this.eSA != null && !this.eSA.hasInit && !TextUtils.isEmpty(this.eSA.adm)) {
                this.eSA.hasInit = true;
                this.eRj.yM(this.eSA.adm);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void b(h hVar) {
        if (hVar != null) {
            if (this.eRc != null && hVar.getList() != null) {
                this.eRc.f(hVar);
            }
            if (this.eRh != null) {
                this.eRh.cD(hVar.getCount());
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void bf(boolean z) {
        super.bf(z);
        if (bjJ().faw != null) {
            bjJ().faw.brb();
            bjJ().faw.setLiveViewOnDispatchTouchEventListener(null);
            bjJ().faw.setOnLiveViewScrollListener(null);
        }
        if (bjJ().awj != null) {
            bjJ().awj.getLivePlayer().setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.eRm != null) {
            this.eRm.pK();
        }
        biP();
        if (this.eRf != null) {
            this.eRf.pK();
        }
        if (this.eSa != null) {
            this.eSa.release();
        }
        if (this.eRi != null) {
            this.eRi.pK();
        }
        if (this.eRg != null) {
            this.eRg.bpW();
        }
        if (this.eRe != null) {
            this.eRe.blv();
            this.eRe.setVisible(8);
        }
        if (this.eRk != null) {
            this.eRk.pK();
        }
        if (this.eRj != null) {
            this.eRj.release();
        }
        if (this.eRa != null) {
            this.eRa.removeAllViews();
            this.eRa = null;
        }
        if (this.eRb != null) {
            this.eRb.removeAllViews();
            this.eRb = null;
        }
        if (this.eRl != null) {
            this.eRl.pK();
        }
        if (this.eRo != null) {
            this.eRo.a((j.a) null);
            this.eRo.vW();
        }
        if (this.eRs != null && (this.eRs.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.eRs.getParent()).removeView(this.eRs);
        }
        if (this.eRp != null) {
            this.eRp.dismiss();
        }
        if (this.eRt != null) {
            this.eRt.bn(false);
            this.eRt.Ac();
        }
        if (this.eRy != null) {
            this.eRy.pK();
        }
        if (this.eSR != null) {
            this.eSR.bkA();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void l(m mVar) {
        View wx;
        super.l(mVar);
        if (this.eRo != null && (wx = this.eRo.wx()) != null && wx.getParent() != null) {
            ((ViewGroup) wx.getParent()).removeView(wx);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.eRo != null) {
            this.eRo.setOtherParams(str);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void be(boolean z) {
        super.be(z);
        this.eRw.removeCallbacksAndMessages(null);
        biP();
        this.eRu = false;
        this.eRv = false;
        if (this.eRd != null) {
            this.eRd.onDestroy();
        }
        if (this.eRf != null) {
            this.eRf.onDestroy();
        }
        if (this.eRi != null) {
            this.eRi.onDestroy();
        }
        if (this.eRk != null) {
            this.eRk.onDestroy();
        }
        if (this.eRl != null) {
            this.eRl.onDestroy();
        }
        if (this.eRm != null) {
            this.eRm.onDestroy();
        }
        if (this.eRn != null) {
            this.eRn.onDestroy();
        }
        if (this.eRp != null) {
            this.eRp.onDestroy();
        }
        if (this.eRe != null) {
            this.eRe.onDestroy();
        }
        if (this.eRt != null) {
            this.eRt.stop();
        }
        if (this.eSa != null) {
            this.eSa.onDestroy();
        }
        if (this.eRc != null) {
            this.eRc.onDestroy();
        }
        if (this.eSe != null) {
            this.eSe.onDestroy();
        }
        if (this.eRg != null) {
            this.eRg.onDestory();
        }
        if (this.eRo != null) {
            this.eRo.a((j.a) null);
            this.eRo.release();
            this.eRo = null;
        }
        if (this.eSR != null) {
            this.eSR.be(z ? false : true);
        }
        MessageManager.getInstance().removeMessageRule(this.eRz);
        MessageManager.getInstance().removeMessageRule(this.eRA);
        MessageManager.getInstance().unRegisterListener(this.eRC);
        MessageManager.getInstance().unRegisterListener(this.eRD);
        MessageManager.getInstance().unRegisterListener(this.eRF);
        MessageManager.getInstance().unRegisterListener(this.eRG);
        MessageManager.getInstance().unRegisterListener(this.eRH);
        MessageManager.getInstance().unRegisterListener(this.eRE);
    }

    private void biP() {
        if (this.eSe != null && this.eSe.wq().getView() != null && this.eSe.wq().getView().getParent() != null) {
            ((ViewGroup) this.eSe.wq().getView().getParent()).removeView(this.eSe.wq().getView());
        }
        if (this.eRq != null && this.eRq.getParent() != null) {
            ((ViewGroup) this.eRq.getParent()).removeView(this.eRq);
        }
        if (this.eRr != null && this.eRr.getParent() != null) {
            ((ViewGroup) this.eRr.getParent()).removeView(this.eRr);
        }
        if (this.eSe != null && this.eSe.wr().getView() != null) {
            this.eSD.removeView(this.eSe.wr().getView());
        }
        if (this.eSe != null) {
            this.eSe.wq().setMsgData(new LinkedList());
            this.eSe.vW();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void a(com.baidu.live.data.x xVar) {
        if (this.eSe != null) {
            bjl();
            this.eSe.wr().setEditText(" @" + xVar.getNameShow() + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.eRg != null) {
            this.eRg.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void f(com.baidu.live.data.a aVar) {
        if (this.eSe != null) {
            bjl();
            this.eSe.wr().setEditText(" @" + aVar.userName + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.eRg != null) {
            this.eRg.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void b(com.baidu.live.data.x xVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected View biQ() {
        if (this.eSe != null) {
            return this.eSe.wr().getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean biR() {
        if (this.eSe == null || !this.eSe.wr().xQ()) {
            return false;
        }
        iT(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean biS() {
        return this.eRd == null || this.eRd.biS();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup biT() {
        return this.eRa;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup biU() {
        return this.eRb;
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
                    this.eSH = false;
                    J(intExtra, intExtra2, intExtra3);
                    return;
                }
                biJ();
                return;
            }
            bjH();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.eSG;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(bjJ().pageContext.getPageActivity()) || z2) {
            iS(z);
        }
    }

    private void iS(boolean z) {
        int dimensionPixelSize;
        if (this.eSe != null && this.eSe.wq() != null) {
            this.eSe.wq().onKeyboardVisibilityChanged(z);
        }
        if (z || this.eSe == null || !this.eSe.wr().xQ()) {
            if (z) {
                if (this.eRg != null) {
                    this.eRg.setVisibility(8);
                }
                if (this.eSg != null && this.eSg.sl() != null) {
                    this.eSg.sl().setVisibility(8);
                }
                biW();
                if (this.eSe != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eSe.wr().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.eSe.wr().getView().setLayoutParams(layoutParams);
                    this.eSe.wr().getView().setVisibility(0);
                    this.eSe.wr().setQuickInputPanelVisible(false);
                }
                if (this.eSC != null) {
                    this.eSC.setVisibility(8);
                }
                if (this.eRj != null) {
                    this.eRj.setVisible(8);
                }
                if (this.eSf != null) {
                    this.eSf.wy();
                }
                if (this.eSB != null) {
                    this.eSB.setCanVisible(false);
                }
            } else {
                biV();
            }
            if (this.eSe != null && this.eRq != null) {
                int equipmentHeight = (int) ((z ? 0.2f : 0.33f) * BdUtilHelper.getEquipmentHeight(bjJ().pageContext.getPageActivity()));
                if (z) {
                    dimensionPixelSize = equipmentHeight + bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64);
                } else {
                    dimensionPixelSize = equipmentHeight + bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
                }
                if (this.eSD.indexOfChild(this.eRq) != -1 && this.eRq.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eRq.getLayoutParams();
                    layoutParams2.height = dimensionPixelSize;
                    this.eRq.setLayoutParams(layoutParams2);
                }
                if (this.eRq.indexOfChild(this.eSe.wq().getView()) != -1 && this.eSe.wq().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.eSe.wq().getView().getLayoutParams();
                    layoutParams3.height = dimensionPixelSize;
                    this.eSe.wq().getView().setLayoutParams(layoutParams3);
                }
                this.eSe.wq().wp();
            }
        }
    }

    private void biV() {
        if (this.eRg != null) {
            this.eRg.setVisibility(0);
        }
        if (this.eRq != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRq.getLayoutParams();
            layoutParams.bottomMargin = bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            this.eRq.setLayoutParams(layoutParams);
        }
        if (this.eSe != null) {
            bjm();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eSe.wr().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.eSe.wr().getView().setLayoutParams(layoutParams2);
        }
        if (this.eRg != null) {
            this.eRg.setVisibility(0);
        }
        if (this.eSg != null && this.eSg.sl() != null) {
            this.eSg.sl().setVisibility(0);
        }
        if (this.eSC != null && (!this.eRu || UtilHelper.getRealScreenOrientation(bjJ().pageContext.getPageActivity()) != 2)) {
            this.eSC.setVisibility(0);
        }
        if (this.eRj != null) {
            this.eRj.setVisible(0);
        }
        if (this.eSf != null) {
            this.eSf.wy();
        }
        if (this.eSB != null) {
            this.eSB.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biW() {
        if (this.eRq != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRq.getLayoutParams();
            boolean z = false;
            if (this.eSe != null && this.eSe.wr() != null) {
                z = this.eSe.wr().xP();
            }
            int iX = iX(z);
            if (layoutParams.bottomMargin != iX) {
                layoutParams.bottomMargin = iX;
                this.eRq.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iT(boolean z) {
        if (z) {
            this.eSe.wr().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRq.getLayoutParams();
            int quickInputPanelExpandHeight = this.eSe.wr().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.eRq.setLayoutParams(layoutParams);
                if (this.eSe.wq() != null) {
                    this.eSe.wq().wp();
                    return;
                }
                return;
            }
            return;
        }
        biV();
        onKeyboardVisibilityChanged(false);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void j(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        RelativeLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = bjJ().pageContext.getPageActivity();
        if (i3 == 1) {
            if (this.eSC != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.eSC.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.eRp != null) {
                this.eRp.dismiss();
            }
            if (this.eRo != null) {
                this.eRo.a((j.a) null);
                this.eRo.vW();
            }
            if (this.awg != null) {
                this.awg.f(true, true);
            }
            if (this.eRs != null) {
                this.eRs.setVisibility(0);
                this.eRs.bringToFront();
            }
            if (this.eRW != null) {
                this.eRW.setVisibility(0);
            }
            if (this.eSe != null && this.eSe.wq().getView().getParent() != null && (this.eSe.wq().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.eSe.wq().getView().getParent()).removeView(this.eSe.wq().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bjJ().pageContext.getPageActivity()) * 0.75f);
            int equipmentHeight = ((int) (BdUtilHelper.getEquipmentHeight(bjJ().pageContext.getPageActivity()) * 0.33f)) + bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
            if (this.eRq != null && this.eSe != null) {
                this.eRq.addView(this.eSe.wq().getView(), new FrameLayout.LayoutParams(equipmentWidth, equipmentHeight));
            }
            if (this.eRr != null && (this.eRr.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.eRr.getParent()).removeView(this.eRr);
            }
            if (this.eSf != null) {
                this.eSf.a(bjJ().fav.yO(), false);
                this.eSf.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.14
                    @Override // com.baidu.live.im.j.a
                    public void wz() {
                        a.this.bjx();
                    }
                });
                View wx = this.eSf.wx();
                if (wx != null && this.eSD != null && wx.getParent() == null) {
                    Resources resources = bjJ().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bjJ().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds80));
                    layoutParams5.addRule(2, a.g.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                    this.eSD.addView(wx, layoutParams5);
                }
            }
            if (this.eRY != null) {
                this.eRY.setPraiseEnable(true);
                bjJ().faw.fnp = true;
            }
            if (this.eRc != null && this.eRc.eTN != null && (layoutParams3 = (RelativeLayout.LayoutParams) this.eRc.eTN.getLayoutParams()) != null) {
                this.eRc.eTN.setPadding(0, 0, 0, 0);
                this.eRc.eTN.setLayoutParams(layoutParams3);
            }
            if (this.eSa != null) {
                this.eSa.brw();
            }
            if (this.eRu) {
                iQ(true);
            }
            if (this.eRv) {
                if (this.eRg != null && this.eRg.getLandscapeBarrageImageView() != null) {
                    b(this.eRg.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.eRh != null) {
                this.eRh.jh(true);
            }
            this.eRw.removeCallbacksAndMessages(null);
            if (this.eRi != null) {
                this.eRi.setCanVisible(true);
                this.eRi.t(bjJ().fav.yO());
            }
        } else if (i3 == 2) {
            if (this.eSa != null) {
                this.eSa.brx();
            }
            if (this.eSC != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.eSC.getLayoutParams()) != null) {
                layoutParams2.topMargin = bjJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
            }
            if (this.eSf != null) {
                this.eSf.a((j.a) null);
                this.eSf.vW();
            }
            bjJ().faw.brd();
            if (this.awg != null) {
                this.awg.f(false, true);
            }
            if (this.eRs != null) {
                this.eRs.setVisibility(4);
            }
            if (this.eSe != null && this.eSe.wq().getView().getParent() != null && (this.eSe.wq().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.eSe.wq().getView().getParent()).removeView(this.eSe.wq().getView());
            }
            int max = Math.max(i, i2);
            if (this.eRr != null) {
                if (this.eRr.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eRr.getParent()).removeView(this.eRr);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
                bjJ().faw.addView(this.eRr, layoutParams6);
            }
            if (this.eRr != null && this.eRo != null) {
                this.eRo.a(bjJ().fav.yO(), false);
                this.eRo.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.15
                    @Override // com.baidu.live.im.j.a
                    public void wz() {
                        a.this.bjx();
                    }
                });
                View wx2 = this.eRo.wx();
                if (wx2 != null && this.eRr.indexOfChild(wx2) < 0) {
                    this.eRr.addView(wx2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bjJ().pageContext.getPageActivity()), -1));
                }
            }
            if (this.eRY != null) {
                this.eRY.al(bjJ().faw);
                this.eRY.setPraiseEnable(false);
                bjJ().faw.fnp = false;
            }
            if (this.eRc != null && this.eRc.eTN != null && (layoutParams = (RelativeLayout.LayoutParams) this.eRc.eTN.getLayoutParams()) != null) {
                int width = this.eRc.eTN.getWidth();
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                this.eRc.eTN.setPadding(width - ((int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f)), 0, 0, 0);
                this.eRc.eTN.setLayoutParams(layoutParams);
            }
            if (this.eRh != null) {
                this.eRh.jh(false);
            }
            if (aa.sO() != null) {
                aa.sO().sN();
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.x.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.x.c) runTask.getData()).sN();
            }
            if (this.eRg != null && this.eRg.getLandscapeBarrageImageView() != null) {
                b(this.eRg.getLandscapeBarrageImageView(), this.eRv, false);
            }
            this.eRw.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.16
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.eRu) {
                        a.this.iQ(false);
                    }
                }
            }, 5000L);
            if (this.eSg != null) {
                this.eSg.sn();
            }
            if (this.eRi != null) {
                this.eRi.setCanVisible(false);
                this.eRi.bmh();
            }
        }
        if (this.eSh != null) {
            if (i3 == 2) {
                View sC = this.eSh.sC();
                if (sC != null) {
                    if (sC.getParent() != null && (sC.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) sC.getParent()).removeView(sC);
                    }
                    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams7.addRule(5, a.g.ala_liveroom_hostheader);
                    layoutParams7.addRule(3, a.g.ala_liveroom_hostheader);
                    layoutParams7.topMargin = bjJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                    if (this.eSC != null) {
                        this.eSC.addView(sC, layoutParams7);
                    }
                }
            } else {
                View sC2 = this.eSh.sC();
                if (sC2 != null) {
                    if (sC2.getParent() != null && (sC2.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) sC2.getParent()).removeView(sC2);
                    }
                    RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams8.topMargin = bjJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds4);
                    layoutParams8.addRule(3, a.g.ala_live_header_view);
                    bjJ().faw.addView(sC2, layoutParams8);
                }
            }
        }
        if (this.eRg != null) {
            this.eRg.j(i, i2, i3);
        }
        pS(i3);
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.eRc != null) {
                this.eRc.bW(i3);
            }
            if (this.eRe != null) {
                this.eRe.bW(i3);
            }
            if (this.eRj != null) {
                this.eRj.bW(i3);
            }
            if (this.eSk != null) {
                this.eSk.bW(i3);
            }
            if (this.eSt != null) {
                this.eSt.bW(i3);
            }
            if (this.eRx != null && this.eRx.isShowing()) {
                this.eRx.resize();
            }
            if (this.eSB != null) {
                this.eSB.bW(i3);
            }
        }
        if (this.eSg != null) {
            this.eSg.sm();
        }
        super.j(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.a.a
    public boolean cc(int i) {
        boolean cc = super.cc(i);
        if (cc && 2 == i) {
            if (this.eRd.biS()) {
                return false;
            }
            if (cc && this.eSa != null) {
                this.eSa.jR(false);
            }
        }
        return cc;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void pR(int i) {
        super.pR(i);
        if (i == 7 || i == 11) {
            if (i != 7 || UtilHelper.getRealScreenOrientation(bjJ().pageContext.getPageActivity()) != 2) {
                if (this.eRg != null) {
                    this.eRg.setVisibility(8);
                }
                if (this.eSe != null) {
                    this.eSe.wq().getView().setVisibility(4);
                }
                if (this.eSu != null) {
                    this.eSu.jM(false);
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
            if (this.eRg != null) {
                this.eRg.setVisibility(0);
            }
            if (this.eSe != null) {
                this.eSe.wq().getView().setVisibility(0);
            }
            if (this.eSu != null) {
                this.eSu.jM(true);
            }
            if (!this.eRu || UtilHelper.getRealScreenOrientation(bjJ().pageContext.getPageActivity()) != 2) {
                this.eSC.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        super.onStop();
        if (this.eRf != null) {
            this.eRf.bqo();
        }
        if (this.eRl != null) {
            this.eRl.pU();
        }
        if (this.eRj != null) {
            this.eRj.onStop();
        }
        if (bjJ() != null) {
            BdUtilHelper.hideSoftKeyPad(bjJ().pageContext.getPageActivity(), bjJ().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.live.liveroom.f.a
    public void onStart() {
        super.onStart();
        if (this.eRf != null) {
            this.eRf.bqn();
        }
        if (this.eRl != null) {
            this.eRl.pV();
        }
        if (this.eRj != null) {
            this.eRj.onStart();
        }
    }

    private void pS(int i) {
        if (this.eRa != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRa.getLayoutParams();
            if (i == 1) {
                layoutParams.removeRule(10);
                layoutParams.addRule(12);
                layoutParams.topMargin = 0;
                layoutParams.rightMargin = bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.bottomMargin = bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
                layoutParams.height = bis();
            } else if (i == 2) {
                layoutParams.removeRule(12);
                layoutParams.addRule(10);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds72) + 0 + bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds22) + bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                layoutParams.rightMargin = bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
                layoutParams.height = -2;
            }
            this.eRa.setLayoutParams(layoutParams);
        }
    }
}
