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
import com.baidu.live.challenge.f;
import com.baidu.live.challenge.h;
import com.baidu.live.challenge.i;
import com.baidu.live.challenge.j;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.ak;
import com.baidu.live.data.as;
import com.baidu.live.data.ay;
import com.baidu.live.data.g;
import com.baidu.live.data.u;
import com.baidu.live.data.y;
import com.baidu.live.data.z;
import com.baidu.live.im.i;
import com.baidu.live.im.k;
import com.baidu.live.message.GetQuickGiftHttpResponseMessage;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.ILiveGoodsLogger;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.utils.n;
import com.baidu.tieba.ala.liveroom.guide.a;
import com.baidu.tieba.ala.liveroom.operation.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends b {
    private boolean eKG;
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
    private FrameLayout eLN;
    private RelativeLayout eLx;
    private LinearLayout eLy;
    private com.baidu.tieba.ala.liveroom.audiencelist.c eLz;
    private f eNF;
    private long lastClickTime = 0;
    private boolean eNG = false;
    private HttpRule eLV = new HttpRule(1021015) { // from class: com.baidu.tieba.ala.liveroom.c.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.eLI != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.eLI.ph()) {
                httpMessage.addParam("ala_challenge_id", d.this.eLI.pl());
            }
            return httpMessage;
        }
    };
    private HttpRule eLW = new HttpRule(1021151) { // from class: com.baidu.tieba.ala.liveroom.c.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage != null && d.this.eLI != null && ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING == d.this.eLI.ph()) {
                httpMessage.addParam("challenge_id", d.this.eLI.pl());
            }
            return httpMessage;
        }
    };
    private AlaLiveView.c eLX = new AlaLiveView.c() { // from class: com.baidu.tieba.ala.liveroom.c.d.11
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void bgm() {
            if (d.this.eMu != null) {
                d.this.eMu.jE(false);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void iD(boolean z) {
            if (z) {
                if (d.this.eLD != null) {
                    d.this.eLD.qn(8);
                }
                if (d.this.eMu != null) {
                    d.this.eMu.jE(true);
                    return;
                }
                return;
            }
            if (d.this.eLD != null) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                    d.this.eLD.qn(0);
                } else {
                    d.this.eLD.qn(8);
                }
            }
            if (d.this.eMu != null) {
                d.this.eMu.jE(false);
            }
        }
    };
    private HttpMessageListener eLY = new HttpMessageListener(1021124) { // from class: com.baidu.tieba.ala.liveroom.c.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021124 && (httpResponsedMessage instanceof GetQuickGiftHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetQuickGiftHttpResponseMessage getQuickGiftHttpResponseMessage = (GetQuickGiftHttpResponseMessage) httpResponsedMessage;
                    if (getQuickGiftHttpResponseMessage.wn() != null) {
                        com.baidu.live.r.c.wF().asJ = getQuickGiftHttpResponseMessage.wn();
                        d.this.bfO();
                    }
                }
            }
        }
    };
    private CustomMessageListener eLZ = new CustomMessageListener(2913093) { // from class: com.baidu.tieba.ala.liveroom.c.d.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.bfX();
        }
    };
    private CustomMessageListener eNH = new CustomMessageListener(2913128) { // from class: com.baidu.tieba.ala.liveroom.c.d.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                final String str = (String) customResponsedMessage.getData();
                if (b.eNg || b.eNf || b.eNh) {
                    d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.14.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, str));
                        }
                    }, 3000L);
                } else {
                    d.this.yp(str);
                }
            }
        }
    };
    private CustomMessageListener eNI = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.c.d.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = (AlaBroadcastGiftToastData) customResponsedMessage.getData();
                if (d.this.eMB instanceof com.baidu.live.gift.broadcastgift.a) {
                    ((com.baidu.live.gift.broadcastgift.a) d.this.eMB).b(alaBroadcastGiftToastData);
                }
            }
        }
    };
    CustomMessageListener eMa = new CustomMessageListener(CmdConfigCustom.CMD_HOST_GET_WALLET_UA) { // from class: com.baidu.tieba.ala.liveroom.c.d.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913113 && d.this.eNa != null && d.this.eNa.eyC != null && !d.this.eNa.ezi && !d.this.eNa.eBB) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 80;
                layoutParams.leftMargin = d.this.bgX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                layoutParams.bottomMargin = d.this.bgX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                d.this.eMK.e(d.this.eLN, layoutParams);
                com.baidu.tieba.ala.guardclub.a.bcp().bcq();
            }
        }
    };
    private CustomMessageListener eMb = new CustomMessageListener(2913121) { // from class: com.baidu.tieba.ala.liveroom.c.d.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913121 && (customResponsedMessage.getData() instanceof Integer)) {
                if (d.this.eML != null) {
                    d.this.eML.dismiss();
                }
                k.uF().setSwitchStatus(true);
                k.uF().setSelectId((String) customResponsedMessage.getData());
                if (d.this.mHandler == null) {
                    d.this.mHandler = new Handler();
                }
                d.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.17.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bgx();
                    }
                }, 500L);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b eMc = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.c.d.7
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void m(View view, int i) {
            ak akVar;
            as asVar;
            ay ayVar;
            ak akVar2;
            as asVar2;
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - d.this.lastClickTime >= 300) {
                d.this.lastClickTime = currentTimeMillis;
                if (i == 2) {
                    d.this.I(-1, -1, -1);
                } else if (i == 13) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_CLICK);
                    alaStaticItem.addParams("gifts_value", com.baidu.live.r.c.wF().asJ.rh().getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, com.baidu.live.r.c.wF().asJ.rh().qx());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, com.baidu.live.r.c.wF().asJ.rh().qy());
                    if (d.this.bgX().eUF.wf() != null && d.this.bgX().eUF.wf().mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", d.this.bgX().eUF.wf().mLiveInfo.feed_id);
                        alaStaticItem.addParams("room_id", d.this.bgX().eUF.wf().mLiveInfo.room_id);
                    }
                    alaStaticItem.addParams("other_params", d.this.vi());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    if (d.this.tq()) {
                        if (com.baidu.live.c.oI().getBoolean("quick_gift_guide_show", true)) {
                            com.baidu.live.gift.container.e eVar = new com.baidu.live.gift.container.e(d.this.bgX().pageContext.getPageActivity(), d.this.bgX().pageContext, d.this.bgX().eUF.wf(), com.baidu.live.r.c.wF().asJ.rh(), d.this.vi());
                            eVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.d.7.1
                                @Override // android.content.DialogInterface.OnDismissListener
                                public void onDismiss(DialogInterface dialogInterface) {
                                    d.this.iG(false);
                                }
                            });
                            eVar.show();
                            d.this.iG(true);
                            return;
                        }
                        com.baidu.live.gift.b.c.a(d.this.bgX().pageContext, d.this.bgX().eUF.wf(), com.baidu.live.r.c.wF().asJ.rh(), d.this.vi());
                    }
                } else if (i == 1) {
                    if (d.this.eMy != null) {
                        d.this.bgx();
                    }
                } else if (i == 3 && d.this.tq()) {
                    d.this.eMn.c(d.this.bgX().eUF.wf(), false);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                        if (d.this.bgX() != null && d.this.bgX().eUF != null && d.this.bgX().eUF.wf() != null && d.this.bgX().eUF.wf().mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", d.this.bgX().eUF.wf().mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", d.this.bgX().eUF.wf().mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", d.this.bgX().eUF.wf().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", d.this.vi());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                        if (d.this.bgX() != null && d.this.bgX().eUF != null && d.this.bgX().eUF.wf() != null && d.this.bgX().eUF.wf().mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", d.this.bgX().eUF.wf().mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", d.this.bgX().eUF.wf().mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", d.this.bgX().eUF.wf().mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("other_params", d.this.vi());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                } else if (i == 8) {
                    TiebaInitialize.log("c12552");
                    if (d.this.eMk != null) {
                        d.this.eMk.iR(false);
                    }
                } else if (i == 12) {
                    if (d.this.eMu != null) {
                        String valueOf = String.valueOf(d.this.bgX().eUF.wf().mLiveInfo.live_id);
                        String valueOf2 = String.valueOf(d.this.bgX().eUF.wf().mLiveInfo.room_id);
                        String str2 = null;
                        com.baidu.live.data.j jVar = d.this.bgX().eUF.wf().mLiveSdkInfo;
                        if (jVar != null && jVar.mCastIds != null) {
                            str2 = String.valueOf(d.this.bgX().eUF.wf().mLiveSdkInfo.mCastIds.VW);
                        }
                        d.this.eMu.ac(valueOf, valueOf2, str2);
                        if (com.baidu.live.liveroom.a.vU().vV()) {
                            d.this.bfX();
                        }
                    }
                } else if (i == 14) {
                    com.baidu.live.data.k wf = d.this.bgX().eUF.wf();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(d.this.bgX().pageContext.getPageActivity(), wf.VP.userName, Long.toString(wf.VP.userId), Long.toString(wf.VP.charmCount), String.valueOf(wf.mLiveInfo.group_id), String.valueOf(wf.mLiveInfo.live_id), false, String.valueOf(wf.VP.userId), Long.toString(wf.Wc.userId), wf.Wc.userName, wf.Wc.portrait, d.this.eLE.getCount(), d.this.vi())));
                    LogManager.getCommonLogger().doClickGusetNumLog(wf.mLiveInfo.feed_id, d.this.eLE.getCount() + "", d.this.vi());
                } else if (i == 11) {
                    d.this.bgA();
                    d.this.bgB();
                } else if (i == 15) {
                    if (d.this.eMI != null && d.this.bgX() != null && d.this.bgX().eUF != null && d.this.bgX().eUF.wf() != null && d.this.bgX().eUF.wf().mLiveInfo != null) {
                        long j = d.this.bgX().eUF.wf().mLiveInfo.live_id;
                        String valueOf3 = String.valueOf(d.this.bgX().eUF.wf().mLiveInfo.feed_id);
                        long j2 = d.this.bgX().eUF.wf().mLiveInfo.room_id;
                        String str3 = d.this.bgX().eUF.wf().mLiveInfo.cover;
                        String str4 = "";
                        String str5 = "";
                        String str6 = "";
                        String str7 = "";
                        if (d.this.bgX().eUF.wf().mLiveInfo.session_info != null) {
                            str4 = d.this.bgX().eUF.wf().mLiveInfo.session_info.flvUrl;
                        }
                        if (!TextUtils.isEmpty(d.this.vi())) {
                            try {
                                JSONObject jSONObject = new JSONObject(d.this.vi());
                                str5 = jSONObject.optString("tab");
                                str6 = jSONObject.optString("tag");
                                str7 = jSONObject.optString("source");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        d.this.eMI.ys(n.a(valueOf3, j + "", j2, false, 1, str3, str4, str5, str6, str7));
                        n.ayO = j;
                        if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                            ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                            LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf3, d.this.vi());
                        }
                    }
                } else if (i == 16) {
                    if (d.this.bgX() != null && (akVar2 = com.baidu.live.r.a.wA().asy) != null && (asVar2 = akVar2.aaH) != null) {
                        String str8 = asVar2.abz.abG;
                        if (!TextUtils.isEmpty(str8)) {
                            long j3 = 0;
                            if (d.this.bgX().eUF != null && d.this.bgX().eUF.wf() != null && d.this.bgX().eUF.wf().mLiveInfo != null) {
                                j3 = d.this.bgX().eUF.wf().mLiveInfo.live_id;
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargeQuickLog(j3 + "", d.this.bgX().eUF.wf().mLiveInfo.room_id + "", d.this.bgX().eUF.wf().mLiveInfo.feed_id, d.this.vi());
                            }
                            if (str8.contains("?")) {
                                str = str8 + "&liveId=" + j3;
                            } else {
                                str = str8 + "?liveId=" + j3;
                            }
                            BrowserHelper.startInternalWebActivity(d.this.bgX().pageContext.getPageActivity(), str);
                        }
                    }
                } else if (i == 17 && d.this.tq() && d.this.bgX() != null && (akVar = com.baidu.live.r.a.wA().asy) != null && (asVar = akVar.aaH) != null && (ayVar = asVar.abA) != null && !TextUtils.isEmpty(ayVar.webUrl) && d.this.eML != null && d.this.bgX().eUF != null && d.this.bgX().eUF.wf() != null) {
                    com.baidu.live.data.k wf2 = d.this.bgX().eUF.wf();
                    d.this.eML.a(ayVar.webUrl, wf2.mLiveInfo.live_id, wf2.Wc.userId, wf2.VP.userId);
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
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void wL() {
        super.wL();
        this.eNG = true;
        bgX().eUG.setIsForceHandledTouch(false);
        bgX().eUG.setSwipeClearEnable(true);
        bgX().eUG.setOnLiveViewScrollListener(this.eLX);
        if (this.eMs != null) {
            this.eMs.b(this.eMc);
        }
        if (this.eMT != null) {
            this.eMT.setVisibility(0);
        }
        bfG();
        bfH();
        bfR();
        bgp();
        bfS();
        bfU();
        bfT();
        iy(false);
        bgD();
        bfJ();
        bfP();
        bgF();
        bfW();
        bfY();
        iQ(true);
        bhj();
        bhk();
        iJ(false);
        bfI();
        bfO();
        bgL();
        bfK();
        bfL();
        bfM();
        iO(true);
        bgK();
        MessageManager.getInstance().registerListener(this.eLY);
        MessageManager.getInstance().registerListener(this.eLZ);
        MessageManager.getInstance().registerListener(this.eNI);
        MessageManager.getInstance().registerListener(this.eMa);
        MessageManager.getInstance().registerListener(this.eMb);
        MessageManager.getInstance().registerListener(this.eNH);
        bga();
    }

    private void bfD() {
        if (this.eMt != null) {
            this.eMt.ad(bgX().eUH);
        }
    }

    private void bhj() {
        if (this.eLK == null) {
            this.eLK = new com.baidu.tieba.ala.liveroom.attentionpop.b(bgX().pageContext);
        }
        if (bgX().eUF != null && bgX().eUF.wf() != null && bgX().eUF.wf().mLiveInfo != null) {
            this.eLK.ym(String.valueOf(bgX().eUF.wf().mLiveInfo.user_id));
        }
    }

    private void bhk() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            long j = 0;
            if (bgX() != null && bgX().eUF != null && bgX().eUF.wf() != null && bgX().eUF.wf().mLiveInfo != null) {
                j = bgX().eUF.wf().mLiveInfo.room_id;
            }
            if (this.eMG == null) {
                this.eMG = new com.baidu.tieba.ala.liveroom.guide.a(bgX().pageContext, j);
            }
            this.eMG.iE(this.eMW);
            this.eMG.a(new a.InterfaceC0445a() { // from class: com.baidu.tieba.ala.liveroom.c.d.2
                @Override // com.baidu.tieba.ala.liveroom.guide.a.InterfaceC0445a
                public void bhl() {
                    if (d.this.eMk != null) {
                        d.this.eMk.iR(true);
                    }
                }
            });
            this.eMG.Z(null);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void bd(int i) {
        super.bd(i);
        bfD();
        if (this.eLJ != null) {
            this.eLJ.bd(i);
        }
        if (this.eLJ == null || !this.eLJ.isActive()) {
        }
    }

    private void bfG() {
        if (this.eLx == null) {
            this.eLx = new RelativeLayout(bgX().pageContext.getPageActivity());
        }
        if (this.eLx.getParent() == null) {
            bgX().eUG.addView(this.eLx, iC(false));
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
            layoutParams.topMargin = bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds160);
            layoutParams.leftMargin = bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            bgX().eUG.addView(this.eLy, layoutParams);
        }
    }

    private void bfJ() {
        if (this.eMr != null && bgX() != null && bgX().eUF != null) {
            this.eMr.b(this.eMT, bgX().eUF.wf());
        }
    }

    private void bfI() {
        if (this.eLG == null) {
            this.eLG = new com.baidu.tieba.ala.liveroom.activeview.b(bgX().pageContext);
        }
        this.eLG.iu(this.eKG);
        this.eLG.setOtherParams(vi());
        this.eLG.b(bgX().eUF.wf(), false);
        this.eLG.setHost(false);
        this.eLG.a(1, this.eLy, pH(1));
        this.eLG.a(2, this.eLx, pH(2));
        this.eLG.setVisible(this.eMX ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfO() {
        if (this.eLD == null) {
            bfT();
        }
        this.eLD.setOtherParams(vi());
        this.eLD.a(com.baidu.live.r.c.wF().asJ, bgX().eUF.wf());
    }

    private ViewGroup.LayoutParams pH(int i) {
        switch (i) {
            case 1:
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (this.eLy == null || this.eLy.getChildCount() == 0) {
                    return layoutParams;
                }
                layoutParams.topMargin = bgX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                return layoutParams;
            case 2:
                ViewGroup.LayoutParams layoutParams2 = this.eLx.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(((int) (BdUtilHelper.getEquipmentWidth(bgX().pageContext.getPageActivity()) * 0.25f)) - ((layoutParams2 instanceof RelativeLayout.LayoutParams ? ((RelativeLayout.LayoutParams) layoutParams2).rightMargin : 0) * 2), -2);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                return layoutParams3;
            default:
                return new RelativeLayout.LayoutParams(-2, -2);
        }
    }

    private void bfK() {
        if (this.eLF == null) {
            this.eLF = new com.baidu.tieba.ala.liveroom.i.a(bgX().pageContext, this);
        }
        this.eLF.setOtherParams(vi());
        this.eLF.c(this.eLx, bfN());
        this.eLF.m(bgX().eUF.wf());
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
            this.eLD.a(new a.InterfaceC0451a() { // from class: com.baidu.tieba.ala.liveroom.c.d.3
                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0451a
                public void bg(int i, int i2) {
                    com.baidu.live.data.k wf = d.this.bgX().eUF.wf();
                    if (wf != null && wf.mLiveInfo != null) {
                        if (d.this.eMM == null) {
                            d.this.eMM = new com.baidu.tieba.ala.liveroom.turntable.lucky.b(d.this.bgX().pageContext.getPageActivity());
                        }
                        d.this.eMM.d(d.this.eMU, i, i2);
                        d.this.eMM.a(String.valueOf(wf.mLiveInfo.live_id), new a.InterfaceC0455a() { // from class: com.baidu.tieba.ala.liveroom.c.d.3.1
                            @Override // com.baidu.tieba.ala.liveroom.turntable.lucky.a.InterfaceC0455a
                            public void a(float f, String str) {
                                if (d.this.eLD != null) {
                                    d.this.eLD.b(f, str);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.operation.a.InterfaceC0451a
                public void bh(int i, int i2) {
                    if (d.this.eMM != null) {
                        d.this.eMM.br(i, i2);
                    }
                }
            });
        }
    }

    private ViewGroup.LayoutParams bfN() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.topMargin = (ScreenHelper.getRealScreenHeight(bgX().pageContext.getPageActivity()) - this.eLx.getTop()) - bgX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds814);
        return layoutParams;
    }

    private void bfP() {
        CustomResponsedMessage runTask;
        if (this.eMy == null && (runTask = MessageManager.getInstance().runTask(2913039, com.baidu.live.im.i.class, bgX().pageContext)) != null && runTask.getData() != null) {
            this.eMy = (com.baidu.live.im.i) runTask.getData();
            this.eMy.setFromMaster(false);
            this.eMy.uv().getView().setId(a.g.ala_liveroom_msg_list);
            this.eMy.a(new i.a() { // from class: com.baidu.tieba.ala.liveroom.c.d.4
                @Override // com.baidu.live.im.i.a
                public boolean ux() {
                    return d.this.tq();
                }

                @Override // com.baidu.live.im.i.a
                public void uy() {
                    d.this.eNb = true;
                }

                @Override // com.baidu.live.im.i.a
                public void dz(String str) {
                    if (!d.this.eMX) {
                        d.this.iB(false);
                    } else {
                        BdUtilHelper.hideSoftKeyPad(d.this.bgX().pageContext.getPageActivity(), d.this.bgX().eUH);
                    }
                    d.this.yo(str);
                }

                @Override // com.baidu.live.im.i.a
                public void uz() {
                    if (d.this.eMX) {
                        d.this.iB(true);
                        d.this.bgX().eUH.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BdUtilHelper.hideSoftKeyPad(d.this.bgX().pageContext.getPageActivity(), d.this.bgX().eUH);
                            }
                        }, 10L);
                    } else if (d.this.eMy != null) {
                        d.this.eMy.uw().setQuickInputPanelVisible(false);
                        d.this.eMy.uw().vB();
                    }
                }

                @Override // com.baidu.live.im.i.a
                public void uA() {
                    if (d.this.eMX) {
                        d.this.bgj();
                        if (d.this.eMz != null) {
                            d.this.eMz.uD();
                        }
                    }
                }

                @Override // com.baidu.live.im.i.a
                public boolean uB() {
                    return d.this.bgt();
                }
            });
            this.eLN = new FrameLayout(bgX().pageContext.getPageActivity());
            this.eLN.setId(a.g.ala_liveroom_msg_list_root);
        }
        if (this.eMy != null && this.eLN != null) {
            int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(bgX().pageContext.getPageActivity()) * 0.75f);
            int dimensionPixelSize = bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64) + ((int) (BdUtilHelper.getEquipmentHeight(bgX().pageContext.getPageActivity()) * 0.27f));
            if (this.eMU.indexOfChild(this.eLN) < 0) {
                if (this.eLN.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eLN.getParent()).removeView(this.eLN);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds27) + dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
                this.eMU.addView(this.eLN, layoutParams);
            }
            if (this.eLN.indexOfChild(this.eMy.uv().getView()) < 0) {
                if (this.eMy.uv().getView().getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.eMy.uv().getView()).removeView(this.eMy.uv().getView());
                }
                this.eLN.addView(this.eMy.uv().getView(), new FrameLayout.LayoutParams(equipmentWidth, dimensionPixelSize));
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

    private void bfR() {
        if (this.eLA == null) {
            this.eLA = new com.baidu.tieba.ala.liveroom.l.a(bgX().pageContext, false, this);
        }
        this.eLA.d(this.eMT, bgX().eUF.wf());
        this.eLA.a(this.eMc);
        this.eLA.setOtherParams(vi());
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
            this.eLz.setOtherParams(vi());
        }
    }

    private void bfT() {
        if (this.eLD == null) {
            this.eLD = new com.baidu.tieba.ala.liveroom.operation.a(bgX().pageContext);
        }
        this.eLD.a(bgX(), this.eMU, bgX().eUF.wf().mLiveInfo.live_type, true, this.eMc);
        this.eLD.setOtherParams(vi());
    }

    public void iN(boolean z) {
        if (this.eLD != null) {
            this.eLD.iN(z);
        }
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

    protected void yp(String str) {
        if (this.eNi == null) {
            this.eNi = new com.baidu.tieba.ala.liveroom.p.b(bgX().pageContext);
        }
        this.eNi.b(this.eMU, str);
        iI(true);
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.eNi.bnw();
                d.this.iI(false);
            }
        }, 5000L);
    }

    private void iO(boolean z) {
        CustomResponsedMessage runTask;
        if (bgX().eUF.wf().mLiveInfo.live_type == 1) {
            if (this.eNF == null && (runTask = MessageManager.getInstance().runTask(2913074, f.class, bgX().pageContext)) != null && runTask.getData() != null) {
                this.eNF = (f) runTask.getData();
            }
            if (this.eNF != null) {
                if (this.eLI == null) {
                    this.eLI = this.eNF.a(bgX().pageContext);
                }
                if (bgX().eUF.wf().mLiveInfo.challengeId > 0 && !this.eLI.pi()) {
                    this.eLI.d(bgX().eUF.wf().mLiveInfo.live_id, bgX().eUF.wf().VP.userId);
                    iP(z);
                    this.eLI.c(bgX().eUF.wf());
                }
            }
        }
    }

    private void iP(boolean z) {
        if (this.eLJ == null) {
            this.eLJ = this.eNF.b(bgX().pageContext);
            this.eLJ.a(new h() { // from class: com.baidu.tieba.ala.liveroom.c.d.6
                @Override // com.baidu.live.challenge.h
                public void oY() {
                    d.this.bgX().eUG.scrollOrigin();
                }

                @Override // com.baidu.live.challenge.h
                public void a(y yVar, z zVar, z zVar2) {
                    d.this.eKG = true;
                    if (d.this.eMs != null) {
                        d.this.eMs.setPraiseEnable(false);
                        d.this.bgX().eUG.fgV = false;
                    }
                    if (d.this.eLF != null) {
                        d.this.eLF.setCanVisible(false);
                        d.this.eLF.bju();
                    }
                    if (d.this.eLG != null) {
                        d.this.eLG.iu(true);
                        d.this.eLG.setVisible(8);
                    }
                    if (d.this.eLH != null) {
                        d.this.eLH.setCanVisible(false);
                        d.this.eLH.setVisible(8);
                    }
                    if (d.this.eLx != null) {
                        d.this.eLx.setLayoutParams(d.this.iC(true));
                    }
                    if (d.this.bgX().eUE != null) {
                        d.this.bgX().eUE.setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                    }
                    if (d.this.eMq != null) {
                        d.this.eMq.setTimeTextMode(true);
                    }
                    if (d.this.eMk != null && zVar != null && zVar2 != null) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(zVar.ZB);
                        arrayList.add(zVar2.ZB);
                        e eVar = d.this.eMk;
                        if (d.this.eNd) {
                            arrayList = null;
                        }
                        eVar.U(arrayList);
                    }
                }

                @Override // com.baidu.live.challenge.h
                public void oZ() {
                }

                @Override // com.baidu.live.challenge.h
                public void pa() {
                }

                @Override // com.baidu.live.challenge.h
                public void aq(boolean z2) {
                    d.this.bgX().eUG.setSwipeClearEnable(true);
                    d.this.eKG = false;
                    if (d.this.eMs != null) {
                        d.this.eMs.setPraiseEnable(true);
                        d.this.bgX().eUG.fgV = true;
                    }
                    if (d.this.eLF != null) {
                        d.this.eLF.setCanVisible(true);
                        d.this.eLF.m(d.this.bgX().eUF.wf());
                    }
                    if (d.this.eMu != null) {
                        d.this.eMu.jE(true);
                    }
                    if (d.this.eLG != null) {
                        d.this.eLG.iu(false);
                        d.this.eLG.setVisible(0);
                    }
                    if (d.this.eLH != null) {
                        d.this.eLH.setCanVisible(true);
                        d.this.eLH.setVisible(0);
                    }
                    if (d.this.eLx != null) {
                        d.this.eLx.setLayoutParams(d.this.iC(false));
                    }
                    if (d.this.eMk != null && !z2) {
                        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
                        arrayList.add(d.this.bgX().eUF.bnd());
                        e eVar = d.this.eMk;
                        if (d.this.eNd) {
                            arrayList = null;
                        }
                        eVar.U(arrayList);
                    }
                    if (d.this.bgX().eUE != null) {
                        d.this.bgX().eUE.setBackgroundResource(a.f.sdk_transparent_bg);
                    }
                    if (d.this.eMq != null) {
                        d.this.eMq.setTimeTextMode(false);
                    }
                }
            });
        }
        this.eLJ.a(this.eLI);
        this.eLJ.e(bgX().eUH);
        this.eLJ.b(z, false, false);
        this.eLI.a((j.e) this.eLJ);
        this.eLI.a((j.c) this.eLJ);
    }

    private void iQ(boolean z) {
        CustomResponsedMessage runTask;
        if (bgX().eUF.wf().mLiveInfo.live_type == 1 && com.baidu.live.r.a.wA().arE.XK) {
            if (this.eLH == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bgX().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.eLH = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.eLH != null) {
                this.eLH.a(bgX().eUF.bne(), false, false);
                if (bgX().eUF.wf().mLiveInfo.pkId > 0 && this.eLH.getRootView() != null && this.eLH.getRootView().getParent() == null && this.eLx != null) {
                    if (this.eLx.getChildCount() <= 0) {
                        this.eLx.addView(this.eLH.getRootView(), new LinearLayout.LayoutParams(-2, -2));
                    } else {
                        View childAt = this.eLx.getChildAt(0);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.topMargin = bgX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds48);
                        childAt.setLayoutParams(layoutParams);
                        this.eLx.addView(this.eLH.getRootView(), 0, new LinearLayout.LayoutParams(-2, -2));
                    }
                }
                if (z) {
                    this.eLH.a(null, bgX().eUF.wf());
                } else {
                    this.eLH.b(bgX().eUF.wf());
                }
            }
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
        if (bgX() == null || bgX().eUF == null || bgX().eUF.wf() == null || bgX().eUF.wf().Wc == null) {
            if (bgX().eUF == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bgX().eUF.wf() == null) {
                Log.i("RenameLog", "getLiveContext().liveModel == null");
                return;
            } else if (bgX().eUF.wf().Wc == null) {
                Log.i("RenameLog", "getLiveContext().liveModel.getLiveShowData().mLoginUserInfo == null");
                return;
            } else {
                return;
            }
        }
        String str = bgX().eUF.wf().Wc.userName;
        Log.i("RenameLog", "loginUserName:" + str);
        if (str != null && str.length() >= 4 && TextUtils.equals(str.substring(0, 4), bgX().pageContext.getPageActivity().getResources().getString(a.i.rename_filter_txt))) {
            com.baidu.live.c.oI().putInt("guide_rename_show_count", com.baidu.live.c.oI().getInt("guide_rename_show_count", 0) + 1);
            com.baidu.live.liveroom.a.vU().aV(true);
            if (this.eMO == null) {
                this.eMO = new com.baidu.tieba.ala.liveroom.s.a(bgX().pageContext);
            }
            this.eMO.setOtherParams(vi());
            this.eMO.f(this.eMU, bgX().eUF.wf());
            iI(true);
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.8
                @Override // java.lang.Runnable
                public void run() {
                    d.this.eMO.bnH();
                    d.this.iI(false);
                }
            }, 5000L);
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_SHOW);
            alaStaticItem.addParams("other_params", vi());
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    private void bfY() {
        boolean z = false;
        if (this.eMu == null) {
            this.eMu = new com.baidu.tieba.ala.liveroom.u.a(bgX().pageContext, this);
        }
        this.eMu.d(bgX().eUG, false);
        if (bgW() && bgX().eUF.wf().mLiveInfo.screen_direction != 2) {
            z = true;
        }
        this.eMu.jD(z);
    }

    private void bga() {
        if (this.eNb || this.eNc) {
            if ((TbadkCoreApplication.isLogin() && this.eMy.uw().hasText()) || this.eNc) {
                this.eNb = false;
                this.eNc = false;
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.d.9
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.bgx();
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
                    com.baidu.live.data.f fVar = new com.baidu.live.data.f();
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
        iQ(false);
        iO(false);
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
        this.eNG = false;
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
        if (this.eLx != null) {
            this.eLx.removeAllViews();
            this.eLx = null;
        }
        if (this.eLy != null) {
            this.eLy.removeAllViews();
            this.eLy = null;
        }
        if (this.eMu != null) {
            this.eMu.onDestroy();
        }
        if (this.eLI != null) {
            this.eLI.oS();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.c.b
    public void onDestory() {
        super.onDestory();
        bgc();
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
        if (this.eMG != null) {
            this.eMG.onDestroy();
        }
        if (this.eLB != null) {
            this.eLB.onDestroy();
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
        MessageManager.getInstance().removeMessageRule(this.eLV);
        MessageManager.getInstance().removeMessageRule(this.eLW);
        if (this.eLG != null) {
            this.eLG.release();
        }
        MessageManager.getInstance().unRegisterListener(this.eLY);
        MessageManager.getInstance().unRegisterListener(this.eLZ);
        MessageManager.getInstance().unRegisterListener(this.eNI);
        MessageManager.getInstance().unRegisterListener(this.eMa);
        MessageManager.getInstance().unRegisterListener(this.eMb);
        MessageManager.getInstance().unRegisterListener(this.eNH);
    }

    private void bgc() {
        if (this.eMy != null && this.eMy.uv().getView() != null && this.eMy.uv().getView().getParent() != null) {
            ((ViewGroup) this.eMy.uv().getView().getParent()).removeView(this.eMy.uv().getView());
        }
        if (this.eLN != null && this.eLN.getParent() != null) {
            ((ViewGroup) this.eLN.getParent()).removeView(this.eLN);
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
        return this.eLx;
    }

    @Override // com.baidu.tieba.ala.liveroom.c.b
    protected ViewGroup bgh() {
        return this.eLy;
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
        super.onKeyboardVisibilityChanged(z);
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
                int equipmentHeight = (int) (((z ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(bgX().pageContext.getPageActivity())) + bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
                if (this.eMU.indexOfChild(this.eLN) != -1 && this.eLN.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eLN.getLayoutParams();
                    layoutParams2.height = bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds27) + equipmentHeight;
                    this.eLN.setLayoutParams(layoutParams2);
                }
                if (this.eLN.indexOfChild(this.eMy.uv().getView()) != -1 && this.eMy.uv().getView().getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.eMy.uv().getView().getLayoutParams();
                    layoutParams3.height = equipmentHeight;
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
            layoutParams.bottomMargin = bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds90);
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
        if (this.eMT != null) {
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
        if (this.mOrientation != i3) {
            if (this.eLz != null) {
                this.eLz.bN(i3);
            }
            if (this.eLB != null) {
                this.eLB.bN(i3);
            }
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
            if (this.eLD != null) {
                this.eLD.setVisibility(8);
            }
            if (this.eMy != null) {
                this.eMy.uv().getView().setVisibility(4);
            }
            if (this.eLG != null) {
                this.eLG.bf(2, 8);
            }
            if (this.eMM != null) {
                this.eMM.jz(false);
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
            if (this.eLG != null) {
                this.eLG.bf(2, 0);
            }
            if (this.eMM != null) {
                this.eMM.jz(true);
            }
            this.eMT.setVisibility(0);
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
        if (this.eLH != null) {
            this.eLH.ao(true);
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
        if (this.eLH != null) {
            this.eLH.ao(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup.LayoutParams iC(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.eLx == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams2 = this.eLx.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds112);
        if (z && this.eLJ != null) {
            layoutParams.topMargin = this.eLJ.ar(false) + bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            return layoutParams;
        }
        layoutParams.topMargin = bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds200);
        return layoutParams;
    }
}
