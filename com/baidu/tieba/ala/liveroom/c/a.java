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
import com.baidu.live.data.ak;
import com.baidu.live.data.as;
import com.baidu.live.data.ay;
import com.baidu.live.data.f;
import com.baidu.live.data.g;
import com.baidu.live.data.u;
import com.baidu.live.im.i;
import com.baidu.live.im.j;
import com.baidu.live.im.k;
import com.baidu.live.message.GetQuickGiftHttpResponseMessage;
import com.baidu.live.q.a;
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
import com.baidu.live.utils.n;
import com.baidu.live.utils.o;
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends b {
    private com.baidu.tieba.ala.liveroom.l.a eLA;
    private com.baidu.tieba.ala.liveroom.e.b eLB;
    private com.baidu.tieba.ala.liveroom.r.b eLC;
    private com.baidu.tieba.ala.liveroom.operation.a eLD;
    private com.baidu.tieba.ala.liveroom.audiencelist.b eLE;
    private com.baidu.tieba.ala.liveroom.i.a eLF;
    private com.baidu.tieba.ala.liveroom.activeview.b eLG;
    private com.baidu.live.d.a eLH;
    private j eLI;
    private i eLJ;
    private com.baidu.tieba.ala.liveroom.attentionpop.b eLK;
    private com.baidu.tieba.ala.liveroom.d.b eLL;
    private com.baidu.tieba.ala.liveroom.share.b eLM;
    private FrameLayout eLN;
    private FrameLayout eLO;
    private ImageView eLP;
    private com.baidu.live.tieba.e.b eLQ;
    private com.baidu.live.gift.container.e eLU;
    private LinearLayout eLw;
    private RelativeLayout eLx;
    private LinearLayout eLy;
    private com.baidu.tieba.ala.liveroom.audiencelist.c eLz;
    private long lastClickTime = 0;
    private boolean eLR = false;
    private boolean eLS = false;
    private Handler eLT = new Handler();
    private HttpRule eLV = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.eLI != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.eLI.ph()) {
                httpMessage.addParam("ala_challenge_id", a.this.eLI.pl());
            }
            return httpMessage;
        }
    };
    private HttpRule eLW = new HttpRule(1021151) { // from class: com.baidu.tieba.ala.liveroom.c.a.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && a.this.eLI != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == a.this.eLI.ph()) {
                httpMessage.addParam("challenge_id", a.this.eLI.pl());
            }
            return httpMessage;
        }
    };
    private AlaLiveView.c eLX = new AlaLiveView.c() { // from class: com.baidu.tieba.ala.liveroom.c.a.14
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void bgm() {
            if (a.this.eMu != null) {
                a.this.eMu.jE(false);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void iD(boolean z) {
            if (z) {
                if (a.this.eLD != null) {
                    a.this.eLD.qn(8);
                }
                if (a.this.eMu != null) {
                    a.this.eMu.jE(true);
                    return;
                }
                return;
            }
            if (a.this.eLD != null) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                    a.this.eLD.qn(0);
                } else {
                    a.this.eLD.qn(8);
                }
            }
            if (a.this.eMu != null) {
                a.this.eMu.jE(false);
            }
        }
    };
    private HttpMessageListener eLY = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.a.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.wn() != null) {
                        com.baidu.live.r.c.wF().asJ = getQuickGiftHttpResponseMessage.wn();
                        a.this.bfO();
                    }
                }
            }
        }
    };
    private CustomMessageListener eLZ = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.a.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bfX();
        }
    };
    CustomMessageListener eMa = new CustomMessageListener(CmdConfigCustom.CMD_HOST_GET_WALLET_UA) { // from class: com.baidu.tieba.ala.liveroom.c.a.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && a.this.eNa != null && a.this.eNa.eyC != null && !a.this.eNa.ezi && !a.this.eNa.eBB) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = a.this.bgX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = a.this.bgX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                a.this.eMK.e(a.this.eLN, layoutParams);
                com.baidu.tieba.ala.guardclub.a.bcp().bcq();
            }
        }
    };
    private CustomMessageListener eMb = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof Integer)) {
                if (a.this.eML != null) {
                    a.this.eML.dismiss();
                }
                k.uF().setSwitchStatus(true);
                k.uF().setSelectId((String) customResponsedMessage.getData());
                if (a.this.mHandler == null) {
                    a.this.mHandler = new Handler();
                }
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bgx();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b eMc = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.a.5
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void m(View view, int i) {
            ak akVar;
            as asVar;
            ay ayVar;
            ak akVar2;
            as asVar2;
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - a.this.lastClickTime >= 300) {
                a.this.lastClickTime = currentTimeMillis;
                if (i == 2 && a.this.tq()) {
                    a.this.I(-1, -1, -1);
                } else if (i == 13) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                    alaStaticItem.addParams("gifts_value", com.baidu.live.r.c.wF().asJ.rh().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.r.c.wF().asJ.rh().qx());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.r.c.wF().asJ.rh().qy());
                    if (a.this.bgX().eUF.wf() != null && a.this.bgX().eUF.wf().mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", a.this.bgX().eUF.wf().mLiveInfo.feed_id);
                        alaStaticItem.addParams("room_id", a.this.bgX().eUF.wf().mLiveInfo.room_id);
                    }
                    alaStaticItem.addParams("other_params", a.this.vi());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    if (a.this.tq()) {
                        if (com.baidu.live.c.oI().getBoolean("quick_gift_guide_show", true)) {
                            com.baidu.live.gift.container.e eVar = new com.baidu.live.gift.container.e(a.this.bgX().pageContext.getPageActivity(), a.this.bgX().pageContext, a.this.bgX().eUF.wf(), com.baidu.live.r.c.wF().asJ.rh(), a.this.vi());
                            eVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.5.1
                                @Override // android.content.DialogInterface.OnDismissListener
                                public void onDismiss(DialogInterface dialogInterface) {
                                    a.this.iG(false);
                                    a.this.eLU = null;
                                }
                            });
                            a.this.eLU = eVar;
                            eVar.show();
                            a.this.iG(true);
                            return;
                        }
                        com.baidu.live.gift.b.c.a(a.this.bgX().pageContext, a.this.bgX().eUF.wf(), com.baidu.live.r.c.wF().asJ.rh(), a.this.vi());
                    }
                } else if (i == 1) {
                    if (a.this.eMy != null) {
                        a.this.bgx();
                    }
                } else if (i == 3 && a.this.tq()) {
                    if (a.this.mOrientation == 2 && TbadkCoreApplication.getInst().isQuanmin()) {
                        if (a.this.eLM != null) {
                            a.this.eLM.q(a.this.bgX().eUF.wf());
                        }
                    } else {
                        a.this.eMn.c(a.this.bgX().eUF.wf(), false);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (a.this.bgX() != null && a.this.bgX().eUF != null && a.this.bgX().eUF.wf() != null && a.this.bgX().eUF.wf().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.bgX().eUF.wf().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.bgX().eUF.wf().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.bgX().eUF.wf().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.vi());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (a.this.bgX() != null && a.this.bgX().eUF != null && a.this.bgX().eUF.wf() != null && a.this.bgX().eUF.wf().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.bgX().eUF.wf().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.bgX().eUF.wf().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.bgX().eUF.wf().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", a.this.vi());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (a.this.eMk != null) {
                        a.this.eMk.iR(false);
                    }
                } else if (i == 12) {
                    if (a.this.eMu != null) {
                        String valueOf = String.valueOf(a.this.bgX().eUF.wf().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(a.this.bgX().eUF.wf().mLiveInfo.room_id);
                        String str2 = null;
                        com.baidu.live.data.j jVar = a.this.bgX().eUF.wf().mLiveSdkInfo;
                        if (jVar != null && jVar.mCastIds != null) {
                            str2 = String.valueOf(a.this.bgX().eUF.wf().mLiveSdkInfo.mCastIds.VW);
                        }
                        a.this.eMu.ac(valueOf, valueOf2, str2);
                        if (com.baidu.live.liveroom.a.vU().vV()) {
                            a.this.bfX();
                        }
                    }
                } else if (i == 14) {
                    com.baidu.live.data.k wf = a.this.bgX().eUF.wf();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(a.this.bgX().pageContext.getPageActivity(), wf.VP.userName, Long.toString(wf.VP.userId), Long.toString(wf.VP.charmCount), String.valueOf(wf.mLiveInfo.group_id), String.valueOf(wf.mLiveInfo.live_id), false, String.valueOf(wf.VP.userId), Long.toString(wf.Wc.userId), wf.Wc.userName, wf.Wc.portrait, a.this.eLE.getCount(), a.this.vi())));
                    LogManager.getCommonLogger().doClickGusetNumLog(wf.mLiveInfo.feed_id, a.this.eLE.getCount() + "", a.this.vi());
                } else if (i == 11) {
                    a.this.bgA();
                    a.this.bgB();
                } else if (i == 15) {
                    if (a.this.eMI != null && a.this.bgX() != null && a.this.bgX().eUF != null && a.this.bgX().eUF.wf() != null && a.this.bgX().eUF.wf().mLiveInfo != null) {
                        long j = a.this.bgX().eUF.wf().mLiveInfo.live_id;
                        String valueOf3 = String.valueOf(a.this.bgX().eUF.wf().mLiveInfo.feed_id);
                        long j2 = a.this.bgX().eUF.wf().mLiveInfo.room_id;
                        String str3 = a.this.bgX().eUF.wf().mLiveInfo.cover;
                        String str4 = "";
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        if (a.this.bgX().eUF.wf().mLiveInfo.session_info != null) {
                            str4 = a.this.bgX().eUF.wf().mLiveInfo.session_info.flvUrl;
                        }
                        if (!TextUtils.isEmpty(a.this.vi())) {
                            try {
                                JSONObject jSONObject = new JSONObject(a.this.vi());
                                str5 = jSONObject.optString("tab");
                                str6 = jSONObject.optString("tag");
                                str7 = jSONObject.optString("source");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        a.this.eMI.ys(n.a(valueOf3, j + "", j2, false, 1, str3, str4, str5, str6, str7));
                        n.ayO = j;
                        if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                            ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                            LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf3, a.this.vi());
                        }
                    }
                } else if (i == 16) {
                    if (a.this.bgX() != null && (akVar2 = com.baidu.live.r.a.wA().asy) != null && (asVar2 = akVar2.aaH) != null) {
                        String str8 = asVar2.abz.abG;
                        if (!TextUtils.isEmpty(str8)) {
                            long j3 = 0;
                            if (a.this.bgX().eUF != null && a.this.bgX().eUF.wf() != null && a.this.bgX().eUF.wf().mLiveInfo != null) {
                                j3 = a.this.bgX().eUF.wf().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j3 + "", a.this.bgX().eUF.wf().mLiveInfo.room_id + "", a.this.bgX().eUF.wf().mLiveInfo.feed_id, a.this.vi());
                            }
                            if (str8.contains("?")) {
                                str = str8 + "&liveId=" + j3;
                            } else {
                                str = str8 + "?liveId=" + j3;
                            }
                            BrowserHelper.startInternalWebActivity(a.this.bgX().pageContext.getPageActivity(), str);
                        }
                    }
                } else if (i == 17) {
                    if (a.this.tq() && a.this.bgX() != null && (akVar = com.baidu.live.r.a.wA().asy) != null && (asVar = akVar.aaH) != null && (ayVar = asVar.abA) != null && !TextUtils.isEmpty(ayVar.webUrl) && a.this.eML != null && a.this.bgX().eUF != null && a.this.bgX().eUF.wf() != null) {
                        com.baidu.live.data.k wf2 = a.this.bgX().eUF.wf();
                        a.this.eML.a(ayVar.webUrl, wf2.mLiveInfo.live_id, wf2.Wc.userId, wf2.VP.userId);
                        a.this.eLQ.bb(false);
                        a.this.eLQ.xt();
                    }
                } else if (i == 18) {
                    if (a.this.eLS) {
                        a.this.b(view, false, true);
                    } else {
                        a.this.b(view, true, true);
                    }
                    a.this.eLS = !a.this.eLS;
                } else if (i == 19 && a.this.eLQ != null) {
                    a.this.eLQ.xt();
                }
            }
        }
    };

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void init() {
        super.init();
        this.eMp = new com.baidu.tieba.ala.liveroom.guide.c(bgX().pageContext, this, false);
        this.eLV.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.eLV);
        this.eLW.setPriority(-1);
        MessageManager.getInstance().addMessageRule(this.eLW);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean bfB() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void wL() {
        super.wL();
        this.eLS = false;
        if (this.eMs != null) {
            this.eMs.b(this.eMc);
        }
        if (this.eLQ == null) {
            this.eLQ = new com.baidu.live.tieba.e.b(bgX().pageContext.getPageActivity());
            this.eLQ.start();
        }
        this.eLQ.bb(true);
        bgX().pageContext.getPageActivity().setRequestedOrientation(-1);
        bgX().eUG.setIsForceHandledTouch(false);
        bgX().eUG.setSwipeClearEnable(true);
        bgX().eUG.setOnLiveViewScrollListener(this.eLX);
        bgX().eUG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eLT.removeCallbacksAndMessages(null);
                a.this.ix(false);
                if (!a.this.eLR) {
                    a.this.eLT.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.eLR) {
                                a.this.ix(false);
                            }
                        }
                    }, 5000L);
                }
            }
        });
        if (this.eMT != null) {
            this.eMT.setVisibility(0);
        }
        bfF();
        bfG();
        bfH();
        bfR();
        bgp();
        bfS();
        bfE();
        bfU();
        bfT();
        iy(false);
        bgD();
        bfJ();
        bfP();
        bfQ();
        bgF();
        bfC();
        bfW();
        bfY();
        iJ(true);
        bfI();
        bfO();
        bgL();
        bfK();
        bfL();
        bfM();
        bfZ();
        bgK();
        if (this.eML != null && this.eML.bnU() == null) {
            this.eML.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.16
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.eLQ.bb(true);
                }
            });
        }
        MessageManager.getInstance().registerListener(this.eLY);
        MessageManager.getInstance().registerListener(this.eLZ);
        MessageManager.getInstance().registerListener(this.eMa);
        MessageManager.getInstance().registerListener(this.eMb);
        bga();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ix(boolean z) {
        View rp;
        if (bgX() != null && bgX().pageContext != null && bgX().pageContext.getPageActivity() != null) {
            if (UtilHelper.getRealScreenOrientation(bgX().pageContext.getPageActivity()) == 2 || z) {
                if (this.eMB != null && (rp = this.eMB.rp()) != null) {
                    if (this.eLR) {
                        rp.setVisibility(0);
                    } else {
                        rp.setVisibility(8);
                    }
                }
                if (this.eLR) {
                    if (this.eMT != null) {
                        this.eMT.setVisibility(0);
                    }
                    if (this.eMU != null) {
                        this.eMU.setVisibility(0);
                    }
                    if (this.eLy != null) {
                        this.eLy.setVisibility(0);
                    }
                    if (this.eLx != null) {
                        this.eLx.setVisibility(0);
                    }
                    if (this.eLw != null) {
                        this.eLw.setVisibility(0);
                    }
                    if (this.eMA != null) {
                        this.eMA.aw(false);
                    }
                } else {
                    if (this.eMT != null) {
                        this.eMT.setVisibility(8);
                    }
                    if (this.eMU != null) {
                        this.eMU.setVisibility(8);
                    }
                    if (this.eLy != null) {
                        this.eLy.setVisibility(8);
                    }
                    if (this.eLx != null) {
                        this.eLx.setVisibility(8);
                    }
                    if (this.eLw != null) {
                        this.eLw.setVisibility(8);
                    }
                    if (this.eMA != null) {
                        this.eMA.aw(true);
                    }
                }
                this.eLR = this.eLR ? false : true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, boolean z2) {
        ImageView imageView;
        View qY;
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view;
        }
        if (z) {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_off);
            }
            if (this.eLO != null) {
                this.eLO.setVisibility(8);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已屏蔽", 0);
            }
        } else {
            if (imageView != null) {
                imageView.setImageResource(a.f.icon_live_barrage_on);
            }
            if (this.eLO != null) {
                this.eLO.setVisibility(0);
            }
            if (z2) {
                BdUtilHelper.getCustomToast().showToast("弹幕和礼物消息已开启", 0);
            }
        }
        if (this.eMA != null && (qY = this.eMA.qY()) != null) {
            if (z) {
                qY.setVisibility(8);
            } else {
                qY.setVisibility(0);
            }
        }
    }

    private void bfC() {
        if (this.eLL == null) {
            this.eLL = new com.baidu.tieba.ala.liveroom.d.b(bgX().pageContext);
        }
        this.eLL.setOtherParams(this.otherParams);
        this.eLL.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.17
            @Override // com.baidu.live.im.j.a
            public void uE() {
                a.this.bgI();
            }
        });
    }

    private void bfD() {
        if (this.eMt != null) {
            this.eMt.ad(bgX().eUH);
        }
    }

    private void bfE() {
        if (this.eLM == null) {
            this.eLM = new com.baidu.tieba.ala.liveroom.share.b(bgX().pageContext);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void bd(int i) {
        super.bd(i);
        if (this.eLP != null && UtilHelper.getRealScreenOrientation(bgX().pageContext.getPageActivity()) != 2) {
            this.eLP.setVisibility(0);
        }
        bfD();
        if (this.eLJ != null) {
            this.eLJ.bd(i);
        }
        if (this.eLJ == null || !this.eLJ.isActive()) {
            Log.i("NewHorizontalScheduler", "onFirstFrame");
        }
    }

    private void bfF() {
        if (this.eLw == null) {
            this.eLw = new LinearLayout(bgX().pageContext.getPageActivity());
            this.eLw.setBackgroundColor(0);
            this.eLw.setOrientation(1);
        }
        if (this.eLw.getParent() == null) {
            bgX().eUG.addView(this.eLw, iC(false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void iy(boolean z) {
        super.iy(z);
        this.eMA.bk(bgX().eUF.wf().mLiveInfo.screen_direction);
    }

    private void bfG() {
        if (this.eLx == null) {
            this.eLx = new RelativeLayout(bgX().pageContext.getPageActivity());
        }
        if (this.eLx.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            layoutParams.topMargin = bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds248);
            layoutParams.rightMargin = bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
            layoutParams.bottomMargin = bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds112);
            bgX().eUG.addView(this.eLx, layoutParams);
        }
    }

    private void bfH() {
        if (this.eLy == null) {
            this.eLy = new LinearLayout(bgX().pageContext.getPageActivity());
            this.eLy.setOrientation(1);
        }
        if (this.eLy.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.topMargin = bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds228);
            layoutParams.leftMargin = bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bgX().eUG.addView(this.eLy, layoutParams);
        }
    }

    private void bfI() {
        if (this.eLG == null) {
            this.eLG = new com.baidu.tieba.ala.liveroom.activeview.b(bgX().pageContext);
        }
        this.eLG.setOtherParams(vi());
        this.eLG.b(bgX().eUF.wf(), true);
        this.eLG.setHost(false);
        this.eLG.a(1, this.eLw, pH(1));
        this.eLG.a(2, this.eLw, pH(2));
        this.eLG.setVisible(this.eMX ? 8 : 0);
    }

    private void bfJ() {
        if (this.eMr != null && bgX() != null && bgX().eUF != null) {
            this.eMr.b(this.eMT, bgX().eUF.wf());
        }
    }

    private ViewGroup.LayoutParams pH(int i) {
        switch (i) {
            case 1:
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = bgX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds40);
                return layoutParams;
            case 2:
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams2.topMargin = bgX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                return layoutParams2;
            default:
                return new RelativeLayout.LayoutParams(-1, -2);
        }
    }

    private void bfK() {
        if (this.eLw != null) {
            if (this.eLF == null) {
                this.eLF = new com.baidu.tieba.ala.liveroom.i.a(bgX().pageContext, this);
            }
            this.eLF.setOtherParams(vi());
            this.eLF.c(this.eLw, bfN());
            this.eLF.m(bgX().eUF.wf());
        }
    }

    private void bfL() {
        if (this.eMK == null) {
            this.eMK = new com.baidu.tieba.ala.liveroom.j.c(bgX().pageContext, vi());
        }
        if (this.eLN != null && this.eLN.indexOfChild(this.eMK.getView()) >= 0) {
            this.eLN.removeView(this.eMK.getView());
        }
    }

    private void bfM() {
        if (this.eLD != null) {
            this.eLD.a(new a.InterfaceC0451a() { // from class: com.baidu.tieba.ala.liveroom.c.a.3
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0451a
                public void bg(int i, int i2) {
                    com.baidu.live.data.k wf = a.this.bgX().eUF.wf();
                    if (wf != null && wf.mLiveInfo != null) {
                        if (a.this.eMM == null) {
                            a.this.eMM = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(a.this.bgX().pageContext.getPageActivity());
                        }
                        a.this.eMM.d(a.this.eMU, i, i2);
                        a.this.eMM.a(String.valueOf(wf.mLiveInfo.live_id), new a.InterfaceC0455a() { // from class: com.baidu.tieba.ala.liveroom.c.a.3.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0455a
                            public void a(float f, String str) {
                                if (a.this.eLD != null) {
                                    a.this.eLD.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0451a
                public void bh(int i, int i2) {
                    if (a.this.eMM != null) {
                        a.this.eMM.br(i, i2);
                    }
                }
            });
        }
    }

    private ViewGroup.LayoutParams bfN() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.topMargin = bgX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfO() {
        if (this.eLD == null) {
            bfT();
        }
        this.eLD.a(com.baidu.live.r.c.wF().asJ, bgX().eUF.wf());
    }

    private void bfP() {
        CustomResponsedMessage runTask;
        if (this.eMy == null && (runTask = MessageManager.getInstance().runTask(2913039, com.baidu.live.im.i.class, bgX().pageContext)) != null && runTask.getData() != null) {
            this.eMy = (com.baidu.live.im.i) runTask.getData();
            this.eMy.setFromMaster(false);
            this.eMy.uv().getView().setId(a.g.ala_liveroom_msg_list);
            this.eMy.a(new i.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.4
                @Override // com.baidu.live.im.i.a
                public boolean ux() {
                    return a.this.tq();
                }

                @Override // com.baidu.live.im.i.a
                public void uy() {
                    a.this.eNb = true;
                }

                @Override // com.baidu.live.im.i.a
                public void dz(String str) {
                    if (!a.this.eMX) {
                        a.this.iB(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(a.this.bgX().pageContext.getPageActivity(), a.this.bgX().eUH);
                    }
                    a.this.yo(str);
                }

                @Override // com.baidu.live.im.i.a
                public void uz() {
                    if (a.this.eMX) {
                        a.this.iB(true);
                        a.this.bgX().eUH.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(a.this.bgX().pageContext.getPageActivity(), a.this.bgX().eUH);
                            }
                        }, 10L);
                    } else if (a.this.eMy != null) {
                        a.this.eMy.uw().setQuickInputPanelVisible(false);
                        a.this.eMy.uw().vB();
                    }
                }

                @Override // com.baidu.live.im.i.a
                public void uA() {
                    if (a.this.eMX) {
                        a.this.bgj();
                        if (a.this.eMz != null) {
                            a.this.eMz.uD();
                        }
                        if (a.this.eLL != null) {
                            a.this.eLL.uD();
                        }
                    } else if (a.this.eMy != null) {
                        a.this.eMy.uw().setQuickInputPanelVisible(false);
                        a.this.eMy.uw().vB();
                    }
                }

                @Override // com.baidu.live.im.i.a
                public boolean uB() {
                    return a.this.bgt();
                }
            });
            this.eLN = new FrameLayout(bgX().pageContext.getPageActivity());
            this.eLN.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.eMy != null && this.eLN != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bgX().pageContext.getPageActivity()) * 0.75f);
            int dimensionPixelSize = bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds120) + ((int) (BdUtilHelper.getEquipmentHeight(bgX().pageContext.getPageActivity()) * 0.33f));
            if (this.eMU.indexOfChild(this.eLN) < 0) {
                if (this.eLN.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eLN.getParent()).removeView(this.eLN);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                this.eMU.addView(this.eLN, layoutParams);
            }
            if (this.eLN.indexOfChild(this.eMy.uv().getView()) < 0) {
                if (this.eMy.uv().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eMy.uv().getView()).removeView(this.eMy.uv().getView());
                }
                if (UtilHelper.getRealScreenOrientation(bgX().pageContext.getPageActivity()) != 2) {
                    this.eLN.addView(this.eMy.uv().getView(), new FrameLayout.LayoutParams(equipmentWidth, dimensionPixelSize));
                }
            }
            if (bgX().eUG.indexOfChild(this.eMy.uw().getView()) < 0) {
                if (this.eMy.uw().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eMy.uw().getView().getParent()).removeView(this.eMy.uw().getView());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                bgy();
                bgX().eUG.addView(this.eMy.uw().getView(), layoutParams2);
            }
            com.baidu.live.data.k wf = bgX().eUF.wf();
            if (wf != null && wf.mLiveInfo != null) {
                this.eMy.setLogData(wf.mLiveInfo.feed_id, vi());
            }
            this.eMy.e(String.valueOf(bgX().eUF.wf().mLiveInfo.group_id), String.valueOf(bgX().eUF.wf().mLiveInfo.last_msg_id), String.valueOf(bgX().eUF.wf().VP.userId), String.valueOf(bgX().eUF.wf().mLiveInfo.live_id), bgX().eUF.wf().VP.appId);
            iB(false);
        }
    }

    private void bfQ() {
        if (this.eLO == null) {
            this.eLO = new FrameLayout(bgX().pageContext.getPageActivity());
            this.eLO.setId(a.g.ala_liveroom_msg_list_root_landscape);
        }
    }

    private void bfR() {
        if (this.eLA == null) {
            this.eLA = new com.baidu.tieba.ala.liveroom.l.a(bgX().pageContext, false, this);
        }
        this.eLA.d(this.eMT, bgX().eUF.wf());
        this.eLA.a(this.eMc);
    }

    private void bfS() {
        if (this.eLz == null) {
            this.eLz = new com.baidu.tieba.ala.liveroom.audiencelist.c(bgX().pageContext, this, false);
        }
        this.eLz.a(String.valueOf(bgX().eUF.wf().mLiveInfo.group_id), String.valueOf(bgX().eUF.wf().mLiveInfo.live_id), String.valueOf(bgX().eUF.wf().VP.userId), bgX().eUF.wf());
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isDayListUnabled()) {
            int i = a.g.ala_liveroom_hostheader;
            if (this.eMm != null) {
                i = a.g.ala_liveroom_guardthrone;
            }
            this.eLz.c(this.eMT, i, a.g.ala_liveroom_audience_count_layout);
            this.eLz.f(bgX().eUF.bbm());
        }
    }

    private void bfT() {
        if (this.eLD == null) {
            this.eLD = new com.baidu.tieba.ala.liveroom.operation.a(bgX().pageContext);
        }
        this.eLD.a(bgX(), this.eMU, bgX().eUF.wf().mLiveInfo.live_type, true, this.eMc);
        this.eLD.setOtherParams(vi());
    }

    private void bfU() {
        if (this.eLE == null) {
            this.eLE = new com.baidu.tieba.ala.liveroom.audiencelist.b(bgX().pageContext.getPageActivity(), false);
        }
        long j = 1;
        if (bgX().eUF.bbm() != null) {
            j = bgX().eUF.bbm().getCount();
        }
        this.eLE.a(this.eMc);
        this.eLE.a(this.eMT, a.g.ala_liveroom_audience, j);
        this.eLE.setVisible(0);
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isAudienceUnabled()) {
            this.eLE.iV(false);
        } else {
            this.eLE.iV(true);
        }
    }

    public void bfV() {
        this.eMn.c(bgX().eUF.wf(), false);
    }

    public void bfW() {
        if (bgX().eUF.wf() != null && bgX().eUF.wf().VP != null && bgX().eUF.wf().mLiveInfo != null) {
            if (this.eLC == null) {
                this.eLC = new com.baidu.tieba.ala.liveroom.r.b(bgX().pageContext);
            }
            long j = bgX().eUF.wf().VP.userId;
            int i = bgX().eUF.wf().mLiveInfo.live_type;
            String str = bgX().eUF.wf().VP.portrait;
            String str2 = bgX().eUF.wf().mLiveInfo.feed_id;
            long j2 = bgX().eUF.wf().mLiveInfo.live_id;
            this.eLC.a(i, j, bgX().eUF.wf().VP.userName, false, str, vi(), str2, j2);
            this.eLC.Z(this.eMT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfX() {
        String str;
        if (bgX() != null && bgX().eUF != null && bgX().eUF.wf() != null && bgX().eUF.wf().Wc != null && (str = bgX().eUF.wf().Wc.userName) != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bgX().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt))) {
            com.baidu.live.c.oI().putInt("guide_rename_show_count", com.baidu.live.c.oI().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.vU().aV(true);
            if (this.eMO == null) {
                this.eMO = new com.baidu.tieba.ala.liveroom.s.a(bgX().pageContext);
            }
            this.eMO.setOtherParams(vi());
            this.eMO.f(this.eMU, bgX().eUF.wf());
            iH(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.6
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eMO.bnH();
                    a.this.iH(false);
                }
            }, 5000L);
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_SHOW);
            alaStaticItem.addParams("other_params", vi());
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    private void bfY() {
        if (this.eMu == null) {
            this.eMu = new com.baidu.tieba.ala.liveroom.u.a(bgX().pageContext, this);
        }
        this.eMu.d(bgX().eUG, false);
        this.eMu.jD(bgW());
    }

    private void bfZ() {
        if (bgX() != null && bgX().eUE != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(bgX().pageContext.getPageActivity());
            Activity pageActivity = bgX().pageContext.getPageActivity();
            int dip2px = BdUtilHelper.dip2px(pageActivity, 32.0f);
            int dip2px2 = BdUtilHelper.dip2px(pageActivity, 4.0f);
            int dip2px3 = BdUtilHelper.dip2px(pageActivity, 12.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.topMargin = ((((Math.min(screenFullSize[0], screenFullSize[1]) * 9) / 16) + pageActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds176)) - dip2px) - dip2px2;
            layoutParams.addRule(11);
            layoutParams.rightMargin = dip2px3;
            this.eLP = new ImageView(bgX().pageContext.getPageActivity());
            this.eLP.setVisibility(8);
            this.eLP.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.eLP.setImageResource(a.f.icon_live_enlarge);
            this.eLP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.eLQ != null) {
                        a.this.eLQ.xs();
                        a.this.eLP.setVisibility(4);
                    }
                }
            });
            bgX().eUG.addView(this.eLP, layoutParams);
            if (UtilHelper.getRealScreenOrientation(bgX().pageContext.getPageActivity()) != 2) {
                if (bgX().eUM) {
                    this.eLP.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.eLP != null && UtilHelper.getRealScreenOrientation(a.this.bgX().pageContext.getPageActivity()) != 2) {
                                a.this.eLP.setVisibility(0);
                            }
                        }
                    }, 1000L);
                }
            }
        }
    }

    private void bga() {
        if (this.eNb || this.eNc) {
            if ((TbadkCoreApplication.isLogin() && this.eMy.uw().hasText()) || this.eNc) {
                this.eNb = false;
                this.eNc = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.9
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bgx();
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
                if (this.eLF != null) {
                    this.eLF.u(jSONObject);
                }
            } else if ("enter_live".equals(optString)) {
                if (this.eLE.getCount() > 20) {
                    this.eLE.cv(this.eLE.getCount() + 1);
                } else if (this.eLz != null) {
                    com.baidu.live.data.a uZ = aVar.uZ();
                    f fVar = new f();
                    fVar.VQ = new AlaLocationData();
                    fVar.VR = new AlaRelationData();
                    fVar.VP = new AlaLiveUserInfoData();
                    fVar.VP.userId = JavaTypesHelper.toLong(uZ.userId, 0L);
                    fVar.VP.userName = uZ.userName;
                    fVar.VP.portrait = uZ.portrait;
                    if (this.eLz.c(fVar)) {
                        this.eLE.cv(this.eLE.getCount() + 1);
                    }
                }
            } else if ("update_liveinfo".equals(optString) && bgX().eUF.wf() != null && bgX().eUF.wf().mLiveInfo != null) {
                bgX().eUF.a(bgX().eUF.wf().mLiveInfo.live_id, bgX().fromType, bgX().enterTime);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void yk(String str) {
        if (this.eLG != null) {
            this.eLG.yk(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void b(com.baidu.live.data.k kVar) {
        super.b(kVar);
        if (this.eLA != null) {
            this.eLA.n(kVar);
        }
        if (this.eLB != null) {
            this.eLB.j(kVar);
        }
        if (this.eLF != null) {
            this.eLF.m(kVar);
        }
        if (this.eLJ != null) {
            this.eLJ.a(kVar);
        }
        if (this.eLL != null) {
            this.eLL.a(kVar);
        }
        if (this.eLG != null) {
            this.eLG.g(kVar);
            if (kVar != null && this.eMR != null && !this.eMR.hasInit && !TextUtils.isEmpty(this.eMR.eVs)) {
                this.eMR.hasInit = true;
                this.eLG.yl(this.eMR.eVs);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void c(g gVar) {
        if (gVar != null) {
            if (this.eLz != null && gVar.getList() != null) {
                this.eLz.f(gVar);
            }
            if (this.eLE != null) {
                this.eLE.cv(gVar.getCount());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void iz(boolean z) {
        super.iz(z);
        if (bgX().eUG != null) {
            bgX().eUG.bos();
            bgX().eUG.setOnDispatchTouchEventListener(null);
            bgX().eUG.setOnLiveViewScrollListener(null);
        }
        if (bgX().eUE != null) {
            bgX().eUE.setBackgroundResource(a.f.sdk_transparent_bg);
        }
        if (this.eLJ != null) {
            this.eLJ.oS();
        }
        bgc();
        if (this.eLC != null) {
            this.eLC.oS();
        }
        if (this.eMu != null) {
            this.eMu.release();
        }
        if (this.eLF != null) {
            this.eLF.oS();
        }
        if (this.eLD != null) {
            this.eLD.bnh();
        }
        if (this.eLB != null) {
            this.eLB.biR();
            this.eLB.setVisible(8);
        }
        if (this.eLH != null) {
            this.eLH.oS();
        }
        if (this.eLG != null) {
            this.eLG.release();
        }
        if (this.eLw != null) {
            this.eLw.removeAllViews();
            this.eLw = null;
        }
        if (this.eLx != null) {
            this.eLx.removeAllViews();
            this.eLx = null;
        }
        if (this.eLy != null) {
            this.eLy.removeAllViews();
            this.eLy = null;
        }
        if (this.eLI != null) {
            this.eLI.oS();
        }
        if (this.eLL != null) {
            this.eLL.a((j.a) null);
            this.eLL.ub();
        }
        if (this.eLP != null && (this.eLP.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.eLP.getParent()).removeView(this.eLP);
        }
        if (this.eLM != null) {
            this.eLM.dismiss();
        }
        if (this.eLQ != null) {
            this.eLQ.bb(false);
            this.eLQ.xt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void bgb() {
        View uC;
        super.bgb();
        if (this.eLL != null && (uC = this.eLL.uC()) != null && uC.getParent() != null) {
            ((ViewGroup) uC.getParent()).removeView(uC);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void setOtherParams(String str) {
        super.setOtherParams(str);
        if (this.eLL != null) {
            this.eLL.setOtherParams(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onDestory() {
        super.onDestory();
        this.eLT.removeCallbacksAndMessages(null);
        bgc();
        this.eLR = false;
        this.eLS = false;
        if (this.eLA != null) {
            this.eLA.onDestroy();
        }
        if (this.eLC != null) {
            this.eLC.onDestroy();
        }
        if (this.eLF != null) {
            this.eLF.onDestroy();
        }
        if (this.eLH != null) {
            this.eLH.onDestroy();
        }
        if (this.eLI != null) {
            this.eLI.onDestroy();
        }
        if (this.eLJ != null) {
            this.eLJ.onDestroy();
        }
        if (this.eLK != null) {
            this.eLK.onDestroy();
        }
        if (this.eLM != null) {
            this.eLM.onDestroy();
        }
        if (this.eLB != null) {
            this.eLB.onDestroy();
        }
        if (this.eLQ != null) {
            this.eLQ.stop();
        }
        if (this.eMu != null) {
            this.eMu.onDestroy();
        }
        if (this.eLz != null) {
            this.eLz.onDestroy();
        }
        if (this.eMy != null) {
            this.eMy.onDestroy();
        }
        if (this.eLD != null) {
            this.eLD.onDestory();
        }
        if (this.eLL != null) {
            this.eLL.a((j.a) null);
            this.eLL.release();
            this.eLL = null;
        }
        MessageManager.getInstance().removeMessageRule(this.eLV);
        MessageManager.getInstance().removeMessageRule(this.eLW);
        MessageManager.getInstance().unRegisterListener(this.eLY);
        MessageManager.getInstance().unRegisterListener(this.eLZ);
        MessageManager.getInstance().unRegisterListener(this.eMa);
        MessageManager.getInstance().unRegisterListener(this.eMb);
    }

    private void bgc() {
        if (this.eMy != null && this.eMy.uv().getView() != null && this.eMy.uv().getView().getParent() != null) {
            ((ViewGroup) this.eMy.uv().getView().getParent()).removeView(this.eMy.uv().getView());
        }
        if (this.eLN != null && this.eLN.getParent() != null) {
            ((ViewGroup) this.eLN.getParent()).removeView(this.eLN);
        }
        if (this.eLO != null && this.eLO.getParent() != null) {
            ((ViewGroup) this.eLO.getParent()).removeView(this.eLO);
        }
        if (this.eMy != null && this.eMy.uw().getView() != null) {
            this.eMU.removeView(this.eMy.uw().getView());
        }
        if (this.eMy != null) {
            this.eMy.uv().setMsgData(new LinkedList());
            this.eMy.ub();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void a(u uVar) {
        if (this.eMy != null) {
            bgx();
            this.eMy.uw().setEditText(" @" + uVar.getNameShow() + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.eLD != null) {
            this.eLD.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void e(com.baidu.live.data.a aVar) {
        if (this.eMy != null) {
            bgx();
            this.eMy.uw().setEditText(" @" + aVar.userName + HanziToPinyin.Token.SEPARATOR);
        }
        if (this.eLD != null) {
            this.eLD.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected void b(u uVar) {
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected View bgd() {
        if (this.eMy != null) {
            return this.eMy.uw().getView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public boolean bge() {
        if (this.eMy == null || !this.eMy.uw().vA()) {
            return false;
        }
        iB(false);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected boolean bgf() {
        return this.eLA == null || this.eLA.bgf();
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup bgg() {
        return this.eLw;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup bgh() {
        return this.eLw;
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
                    this.eMY = false;
                    I(intExtra, intExtra2, intExtra3);
                    return;
                }
                bfV();
                return;
            }
            bgV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onKeyboardVisibilityChanged(boolean z) {
        boolean z2 = this.eMX;
        super.onKeyboardVisibilityChanged(z);
        if (this.mOrientation == UtilHelper.getRealScreenOrientation(bgX().pageContext.getPageActivity()) || z2) {
            iA(z);
        }
    }

    private void iA(boolean z) {
        int dimensionPixelSize;
        if (this.eMy != null && this.eMy.uv() != null) {
            this.eMy.uv().onKeyboardVisibilityChanged(z);
        }
        if (z || this.eMy == null || !this.eMy.uw().vA()) {
            if (z) {
                if (this.eLD != null) {
                    this.eLD.setVisibility(8);
                }
                if (this.eMA != null && this.eMA.qY() != null) {
                    this.eMA.qY().setVisibility(8);
                }
                bgj();
                if (this.eMy != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eMy.uw().getView().getLayoutParams();
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.eMy.uw().getView().setLayoutParams(layoutParams);
                    this.eMy.uw().getView().setVisibility(0);
                    this.eMy.uw().setQuickInputPanelVisible(false);
                }
                if (this.eMT != null) {
                    this.eMT.setVisibility(8);
                }
                if (this.eLG != null) {
                    this.eLG.setVisible(8);
                }
                if (this.eMz != null) {
                    this.eMz.uD();
                }
                if (this.eMS != null) {
                    this.eMS.setCanVisible(false);
                }
            } else {
                bgi();
            }
            if (this.eMy != null && this.eLN != null) {
                int equipmentHeight = (int) ((z ? 0.2f : 0.33f) * BdUtilHelper.getEquipmentHeight(bgX().pageContext.getPageActivity()));
                if (z) {
                    dimensionPixelSize = equipmentHeight + bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64);
                } else {
                    dimensionPixelSize = equipmentHeight + bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
                }
                if (this.eMU.indexOfChild(this.eLN) != -1 && this.eLN.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eLN.getLayoutParams();
                    layoutParams2.height = dimensionPixelSize;
                    this.eLN.setLayoutParams(layoutParams2);
                }
                if (this.eLN.indexOfChild(this.eMy.uv().getView()) != -1 && this.eMy.uv().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.eMy.uv().getView().getLayoutParams();
                    layoutParams3.height = dimensionPixelSize;
                    this.eMy.uv().getView().setLayoutParams(layoutParams3);
                }
                this.eMy.uv().uu();
            }
        }
    }

    private void bgi() {
        if (this.eLD != null) {
            this.eLD.setVisibility(0);
        }
        if (this.eLN != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eLN.getLayoutParams();
            layoutParams.bottomMargin = bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            this.eLN.setLayoutParams(layoutParams);
        }
        if (this.eMy != null) {
            bgy();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eMy.uw().getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            this.eMy.uw().getView().setLayoutParams(layoutParams2);
        }
        if (this.eLD != null) {
            this.eLD.setVisibility(0);
        }
        if (this.eMA != null && this.eMA.qY() != null) {
            this.eMA.qY().setVisibility(0);
        }
        if (this.eMT != null && (!this.eLR || UtilHelper.getRealScreenOrientation(bgX().pageContext.getPageActivity()) != 2)) {
            this.eMT.setVisibility(0);
        }
        if (this.eLG != null) {
            this.eLG.setVisible(0);
        }
        if (this.eMz != null) {
            this.eMz.uD();
        }
        if (this.eMS != null) {
            this.eMS.setCanVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgj() {
        if (this.eLN != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eLN.getLayoutParams();
            boolean z = false;
            if (this.eMy != null && this.eMy.uw() != null) {
                z = this.eMy.uw().vz();
            }
            int iK = iK(z);
            if (layoutParams.bottomMargin != iK) {
                layoutParams.bottomMargin = iK;
                this.eLN.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iB(boolean z) {
        if (z) {
            this.eMy.uw().setQuickInputPanelVisible(true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eLN.getLayoutParams();
            int quickInputPanelExpandHeight = this.eMy.uw().getQuickInputPanelExpandHeight();
            if (quickInputPanelExpandHeight > 0) {
                layoutParams.bottomMargin = quickInputPanelExpandHeight + layoutParams.bottomMargin;
                this.eLN.setLayoutParams(layoutParams);
                if (this.eMy.uv() != null) {
                    this.eMy.uv().uu();
                    return;
                }
                return;
            }
            return;
        }
        bgi();
        onKeyboardVisibilityChanged(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void E(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        RelativeLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Activity pageActivity = bgX().pageContext.getPageActivity();
        if (i3 == 1) {
            if (this.eMT != null && (layoutParams4 = (RelativeLayout.LayoutParams) this.eMT.getLayoutParams()) != null) {
                layoutParams4.topMargin = 0;
            }
            if (this.eLM != null) {
                this.eLM.dismiss();
            }
            if (this.eLL != null) {
                this.eLL.a((j.a) null);
                this.eLL.ub();
            }
            if (this.eMk != null) {
                this.eMk.A(true, true);
            }
            if (this.eLP != null) {
                this.eLP.setVisibility(0);
                this.eLP.bringToFront();
            }
            if (this.eMq != null) {
                this.eMq.setVisibility(0);
            }
            if (this.eMy != null && this.eMy.uv().getView().getParent() != null && (this.eMy.uv().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.eMy.uv().getView().getParent()).removeView(this.eMy.uv().getView());
            }
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bgX().pageContext.getPageActivity()) * 0.75f);
            int equipmentHeight = ((int) (BdUtilHelper.getEquipmentHeight(bgX().pageContext.getPageActivity()) * 0.33f)) + bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds120);
            if (this.eLN != null && this.eMy != null) {
                this.eLN.addView(this.eMy.uv().getView(), new FrameLayout.LayoutParams(equipmentWidth, equipmentHeight));
            }
            if (this.eLO != null && (this.eLO.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.eLO.getParent()).removeView(this.eLO);
            }
            if (this.eMz != null) {
                this.eMz.a(bgX().eUF.wf(), false);
                this.eMz.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.10
                    @Override // com.baidu.live.im.j.a
                    public void uE() {
                        a.this.bgI();
                    }
                });
                View uC = this.eMz.uC();
                if (uC != null && this.eMU != null && uC.getParent() == null) {
                    Resources resources = bgX().pageContext.getResources();
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bgX().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds80));
                    layoutParams5.addRule(2, a.g.ala_liveroom_msg_list_root);
                    layoutParams5.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                    this.eMU.addView(uC, layoutParams5);
                }
            }
            if (this.eMs != null) {
                this.eMs.setPraiseEnable(true);
                bgX().eUG.fgV = true;
            }
            if (this.eLz != null && this.eLz.eNZ != null && (layoutParams3 = (RelativeLayout.LayoutParams) this.eLz.eNZ.getLayoutParams()) != null) {
                this.eLz.eNZ.setPadding(0, 0, 0, 0);
                this.eLz.eNZ.setLayoutParams(layoutParams3);
            }
            if (this.eMu != null) {
                this.eMu.boO();
            }
            if (this.eLR) {
                ix(true);
            }
            if (this.eLS) {
                if (this.eLD != null && this.eLD.getLandscapeBarrageImageView() != null) {
                    b(this.eLD.getLandscapeBarrageImageView(), false, false);
                } else {
                    b(null, false, false);
                }
            }
            if (this.eLE != null) {
                this.eLE.iU(true);
            }
            this.eLT.removeCallbacksAndMessages(null);
            if (this.eLF != null) {
                this.eLF.setCanVisible(true);
                this.eLF.m(bgX().eUF.wf());
            }
        } else if (i3 == 2) {
            if (this.eMu != null) {
                this.eMu.boP();
            }
            if (this.eMT != null && (layoutParams2 = (RelativeLayout.LayoutParams) this.eMT.getLayoutParams()) != null) {
                layoutParams2.topMargin = bgX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
            }
            if (this.eMz != null) {
                this.eMz.a((j.a) null);
                this.eMz.ub();
            }
            bgX().eUG.bou();
            if (this.eMk != null) {
                this.eMk.A(false, true);
            }
            if (this.eLP != null) {
                this.eLP.setVisibility(4);
            }
            if (this.eMy != null && this.eMy.uv().getView().getParent() != null && (this.eMy.uv().getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.eMy.uv().getView().getParent()).removeView(this.eMy.uv().getView());
            }
            int max = Math.max(i, i2);
            if (this.eLO != null) {
                if (this.eLO.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eLO.getParent()).removeView(this.eLO);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(max, bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200));
                layoutParams6.addRule(12);
                layoutParams6.addRule(14);
                layoutParams6.bottomMargin = bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
                bgX().eUG.addView(this.eLO, layoutParams6);
            }
            if (this.eLO != null && this.eLL != null) {
                this.eLL.a(bgX().eUF.wf(), false);
                this.eLL.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.a.12
                    @Override // com.baidu.live.im.j.a
                    public void uE() {
                        a.this.bgI();
                    }
                });
                View uC2 = this.eLL.uC();
                if (uC2 != null && this.eLO.indexOfChild(uC2) < 0) {
                    this.eLO.addView(uC2, new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bgX().pageContext.getPageActivity()), -1));
                }
            }
            if (this.eMs != null) {
                this.eMs.ag(bgX().eUG);
                this.eMs.setPraiseEnable(false);
                bgX().eUG.fgV = false;
            }
            if (this.eLz != null && this.eLz.eNZ != null && (layoutParams = (RelativeLayout.LayoutParams) this.eLz.eNZ.getLayoutParams()) != null) {
                int width = this.eLz.eNZ.getWidth();
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(pageActivity);
                this.eLz.eNZ.setPadding(width - ((int) (Math.max(screenDimensions[0], screenDimensions[1]) * 0.25f)), 0, 0, 0);
                this.eLz.eNZ.setLayoutParams(layoutParams);
            }
            if (this.eLE != null) {
                this.eLE.iU(false);
            }
            com.baidu.tieba.ala.liveroom.yuangift.a.boL().wN();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.s.c.class);
            if (runTask != null && runTask.getData() != null) {
                ((com.baidu.live.s.c) runTask.getData()).wN();
            }
            if (this.eLD != null && this.eLD.getLandscapeBarrageImageView() != null) {
                b(this.eLD.getLandscapeBarrageImageView(), this.eLS, false);
            }
            this.eLT.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.a.13
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.eLR) {
                        a.this.ix(false);
                    }
                }
            }, 5000L);
            if (this.eMA != null) {
                this.eMA.ra();
            }
            if (this.eLF != null) {
                this.eLF.setCanVisible(false);
                this.eLF.bju();
            }
        }
        if (this.eMB != null) {
            if (i3 == 2) {
                View rp = this.eMB.rp();
                if (rp != null) {
                    if (rp.getParent() != null && (rp.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) rp.getParent()).removeView(rp);
                    }
                    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams7.addRule(5, a.g.ala_liveroom_hostheader);
                    layoutParams7.addRule(3, a.g.ala_liveroom_hostheader);
                    layoutParams7.topMargin = bgX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                    if (this.eMT != null) {
                        this.eMT.addView(rp, layoutParams7);
                    }
                }
            } else {
                View rp2 = this.eMB.rp();
                if (rp2 != null) {
                    if (rp2.getParent() != null && (rp2.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) rp2.getParent()).removeView(rp2);
                    }
                    RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams8.topMargin = bgX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds4);
                    layoutParams8.addRule(3, a.g.ala_live_header_view);
                    bgX().eUG.addView(rp2, layoutParams8);
                }
            }
        }
        if (this.eLD != null) {
            this.eLD.E(i, i2, i3);
        }
        if (this.mOrientation == i3) {
            Log.i("NewHorizontalScheduler", "orientation=" + i3);
        } else {
            if (this.eLz != null) {
                this.eLz.bN(i3);
            }
            if (this.eLB != null) {
                this.eLB.bN(i3);
            }
            pJ(i3);
            if (this.eLG != null) {
                this.eLG.bN(i3);
            }
            if (this.eME != null) {
                this.eME.bN(i3);
            }
            if (this.eML != null) {
                this.eML.bN(i3);
            }
            if (this.eLU != null && this.eLU.isShowing()) {
                this.eLU.resize();
            }
            if (this.eMS != null) {
                this.eMS.bN(i3);
            }
        }
        if (this.eMA != null) {
            this.eMA.qZ();
        }
        super.E(i, i2, i3);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.tieba.ala.liveroom.b
    public boolean pq(int i) {
        boolean pq = super.pq(i);
        if (pq && 2 == i) {
            if (this.eLA.bgf()) {
                return false;
            }
            if (pq && this.eMu != null) {
                this.eMu.jE(false);
            }
        }
        return pq;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void pI(int i) {
        super.pI(i);
        if (i == 7 || i == 11) {
            if (i != 7 || UtilHelper.getRealScreenOrientation(bgX().pageContext.getPageActivity()) != 2) {
                if (this.eLD != null) {
                    this.eLD.setVisibility(8);
                }
                if (this.eMy != null) {
                    this.eMy.uv().getView().setVisibility(4);
                }
                if (this.eMM != null) {
                    this.eMM.jz(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.tieba.ala.liveroom.b
    public void pr(int i) {
        super.pr(i);
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b, com.baidu.tieba.ala.liveroom.b
    public void ps(int i) {
        super.ps(i);
        if (i == 7 || i == 11) {
            if (this.eLD != null) {
                this.eLD.setVisibility(0);
            }
            if (this.eMy != null) {
                this.eMy.uv().getView().setVisibility(0);
            }
            if (this.eMM != null) {
                this.eMM.jz(true);
            }
            if (!this.eLR || UtilHelper.getRealScreenOrientation(bgX().pageContext.getPageActivity()) != 2) {
                this.eMT.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void bgk() {
        super.bgk();
        if (this.eLC != null) {
            this.eLC.bnF();
        }
        if (this.eLI != null) {
            this.eLI.pc();
        }
        if (this.eLG != null) {
            this.eLG.onStop();
        }
        if (bgX() != null) {
            BdUtilHelper.hideSoftKeyPad(bgX().pageContext.getPageActivity(), bgX().pageContext.getPageActivity().getWindow().getDecorView());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void bgl() {
        super.bgl();
        if (this.eLC != null) {
            this.eLC.bnE();
        }
        if (this.eLI != null) {
            this.eLI.pd();
        }
        if (this.eLG != null) {
            this.eLG.onStart();
        }
    }

    private void pJ(int i) {
        if (this.eLw != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eLw.getLayoutParams();
            layoutParams.width = ScreenHelper.getRealScreenWidth(bgX().pageContext.getPageActivity());
            if (i == 1) {
                layoutParams.width = (int) (layoutParams.width * 0.5f);
                layoutParams.topMargin = o.w(bgX().pageContext.getPageActivity());
                layoutParams.rightMargin = bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
            } else if (i == 2) {
                layoutParams.topMargin = 0 + bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds72) + bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds22) + bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                layoutParams.rightMargin = bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
            }
            layoutParams.width -= layoutParams.rightMargin * 2;
            this.eLw.setLayoutParams(layoutParams);
        }
    }

    private ViewGroup.LayoutParams iC(boolean z) {
        if (this.eLw == null) {
            return null;
        }
        int dimensionPixelSize = bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(((int) (BdUtilHelper.getEquipmentWidth(bgX().pageContext.getPageActivity()) * 0.5f)) - (dimensionPixelSize * 2), -1);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.rightMargin = dimensionPixelSize;
        layoutParams.bottomMargin = bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds112);
        if (z && this.eLJ != null) {
            layoutParams.topMargin = this.eLJ.ar(false);
            return layoutParams;
        }
        layoutParams.topMargin = o.w(bgX().pageContext.getPageActivity());
        return layoutParams;
    }
}
