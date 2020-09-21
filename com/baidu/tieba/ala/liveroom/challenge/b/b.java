package com.baidu.tieba.ala.liveroom.challenge.b;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.d;
import com.baidu.live.challenge.i;
import com.baidu.live.data.AlaLiveStickerInfo;
import com.baidu.live.data.aq;
import com.baidu.live.data.au;
import com.baidu.live.data.aw;
import com.baidu.live.data.ax;
import com.baidu.live.data.ay;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaAcceptDirectChallengeResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaCancelDirectChallengeResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaCancelRandomChallengeResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaChallengeLatestListResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaChallengeSwitchResponsedMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetChallengeInfoResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetDirectChallengeListResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetQualifyingResultResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetTargetInfoResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetTargetListResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaSearchTargetListResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaStartDirectChallengeResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaStartRandomChallengeResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaSurrenderResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.CloseChallengeResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.GetChallengeMvpToastInfoResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.SetChallengeMvpPunishChooseResponseMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private BdUniqueId bhK;
    private int buE;
    private long fyR;
    private a gtt;
    private long guB;
    private ChallenfeInfoData.ChallengeStatus guC;
    private i.f guD;
    private int gub;
    private long gut;
    private long guu;
    private long guv;
    private long guw;
    private long gux;
    private long guy;
    private long guz;
    private boolean isHost;
    private TbPageContext mPageContext;
    private boolean guA = false;
    private boolean guE = false;
    private boolean guF = false;
    private boolean guG = false;
    private HttpMessageListener bvo = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaChallengeSwitchResponsedMessage) {
                b.this.a((AlaChallengeSwitchResponsedMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaGetTargetListResponseMessage) {
                b.this.a((AlaGetTargetListResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaChallengeLatestListResponseMessage) {
                b.this.a((AlaChallengeLatestListResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaStartDirectChallengeResponseMessage) {
                b.this.a((AlaStartDirectChallengeResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaCancelDirectChallengeResponseMessage) {
                b.this.a((AlaCancelDirectChallengeResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaGetDirectChallengeListResponseMessage) {
                b.this.a((AlaGetDirectChallengeListResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaAcceptDirectChallengeResponseMessage) {
                b.this.a((AlaAcceptDirectChallengeResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaStartRandomChallengeResponseMessage) {
                b.this.a((AlaStartRandomChallengeResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaCancelRandomChallengeResponseMessage) {
                b.this.a((AlaCancelRandomChallengeResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaSurrenderResponseMessage) {
                b.this.a((AlaSurrenderResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaGetTargetInfoResponseMessage) {
                b.this.a((AlaGetTargetInfoResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaSearchTargetListResponseMessage) {
                b.this.a((AlaSearchTargetListResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof CloseChallengeResponseMessage) {
                b.this.a((CloseChallengeResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaGetQualifyingResultResponseMessage) {
                b.this.a((AlaGetQualifyingResultResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener bbU = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                b.this.guE = false;
                if (!b.this.gtt.bQy()) {
                    b.this.b((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                    b.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                }
            }
        }
    };
    private Runnable guJ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.guG) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.guu);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, b.this.bhK);
            b.this.lW(false);
            b.this.mHandler.postDelayed(this, b.this.guu);
        }
    };
    private Runnable guK = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.4
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.guF) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.gut);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, b.this.bhK);
            b.this.lX(false);
            b.this.mHandler.postDelayed(this, b.this.gut);
        }
    };
    private Runnable guL = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.5
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.guw <= 0) {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().removeMessage(1021112, b.this.bhK);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            if (b.this.guE) {
                b.this.mHandler.postDelayed(this, b.this.guv);
                return;
            }
            MessageManager.getInstance().removeMessage(1021112, b.this.bhK);
            if (b.this.guD != null) {
                b.this.gub = b.this.guD.Cj();
            }
            b.this.guE = true;
            com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(b.this.guw, b.this.buE, b.this.fyR, b.this.guB, b.this.gub);
            aVar.setTag(b.this.bhK);
            MessageManager.getInstance().sendMessage(aVar);
            if (b.this.isHost) {
                UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_REQ, UbcStatConstant.ContentType.UBC_TYPE_PK_CHALLENGE_INFO, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("avts_conn", b.this.buE);
                    jSONObject2.put("avts_fail", b.this.gub);
                    jSONObject2.put("chat_id", b.this.guw);
                    jSONObject.put("pk", jSONObject2);
                } catch (JSONException e) {
                }
                ubcStatisticItem.setContentExt(jSONObject);
                UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
            }
            b.this.mHandler.postDelayed(this, b.this.guv);
        }
    };
    private Handler mHandler = new Handler();
    private Map<Long, List<Long>> guH = new HashMap();
    private Map<Long, Integer> guI = new HashMap();

    /* loaded from: classes4.dex */
    public interface a {
        void Ck();

        void a(com.baidu.live.challenge.b bVar, List<d> list);

        void a(d dVar);

        void aK(int i, String str);

        void aL(int i, String str);

        void aM(int i, String str);

        void aN(int i, String str);

        void aO(int i, String str);

        void aP(int i, String str);

        void aQ(int i, String str);

        void b(int i, au auVar, ay ayVar, ay ayVar2);

        void b(com.baidu.live.challenge.a aVar);

        void b(boolean z, long j);

        void b(boolean z, com.baidu.live.challenge.a aVar);

        boolean bQy();

        void c(com.baidu.live.challenge.a aVar);

        void c(boolean z, com.baidu.live.challenge.a aVar);

        void cb(List<d> list);

        void d(boolean z, com.baidu.live.challenge.a aVar);

        void j(int i, String str);

        void k(int i, String str);

        void l(int i, List<d> list);

        void n(int i, String str);

        void n(boolean z, String str);

        void o(boolean z, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        UbcStatisticItem ubcStatisticItem;
        if (alaGetChallengeInfoResponseMessage != null && this.isHost) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("avts_conn", this.buE);
                jSONObject2.put("avts_fail", this.gub);
                if (alaGetChallengeInfoResponseMessage.bQN() != null) {
                    jSONObject2.put("chat_id", alaGetChallengeInfoResponseMessage.bQN().challengeId);
                    jSONObject2.put("chat_status", alaGetChallengeInfoResponseMessage.bQN().aJK);
                }
                jSONObject.put("pk", jSONObject2);
            } catch (JSONException e) {
            }
            if (alaGetChallengeInfoResponseMessage.hasError() || alaGetChallengeInfoResponseMessage.getError() != 0) {
                ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RESP, UbcStatConstant.ContentType.UBC_TYPE_PK_CHALLENGE_INFO, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "");
            } else {
                ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RESP, UbcStatConstant.ContentType.UBC_TYPE_PK_CHALLENGE_INFO_SUCC, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "");
            }
            ubcStatisticItem.setContentExt(jSONObject);
            UbcStatisticManager.getInstance().logSendResponse(ubcStatisticItem, alaGetChallengeInfoResponseMessage, true);
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.bhK = bdUniqueId;
        this.gut = com.baidu.live.x.a.NN().bhy.aHE > 0 ? com.baidu.live.x.a.NN().bhy.aHE : 1000L;
        this.guu = com.baidu.live.x.a.NN().bhy.aHF > 0 ? com.baidu.live.x.a.NN().bhy.aHF : 1000L;
        this.guv = com.baidu.live.x.a.NN().bhy.aHG > 0 ? com.baidu.live.x.a.NN().bhy.aHG : 1000L;
        this.guC = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        registerTask();
        registerListener();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public void e(long j, long j2) {
        this.fyR = j;
        this.guB = j2;
    }

    public void a(a aVar) {
        this.gtt = aVar;
    }

    public void b(i.f fVar) {
        this.guD = fVar;
    }

    private void registerTask() {
        com.baidu.live.tieba.f.a.a.a(1021183, "ala/challenge/getChallengeSwitch", AlaChallengeSwitchResponsedMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021105, "ala/challenge/getChallengeTargetList", AlaGetTargetListResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021182, "ala/challenge/searchChallengeTargetList", AlaSearchTargetListResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021203, "ala/challenge/lastlyList", AlaChallengeLatestListResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021106, "ala/challenge/startDirectChallenge", AlaStartDirectChallengeResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021107, "ala/challenge/cancelDirectChallenge", AlaCancelDirectChallengeResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021108, "ala/challenge/getDirectChallengerList", AlaGetDirectChallengeListResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021109, "ala/challenge/acceptDirectChallenge", AlaAcceptDirectChallengeResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021110, "ala/challenge/startRandomChallenge", AlaStartRandomChallengeResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021111, "ala/challenge/cancelRandomChallenge", AlaCancelRandomChallengeResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021112, "ala/challenge/getChallengeInfo", AlaGetChallengeInfoResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021115, "ala/challenge/challengeAutoFail", AlaSurrenderResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021116, "ala/challenge/getChallengeTargetInfo", AlaGetTargetInfoResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021197, "ala/challenge/closeChallenge", CloseChallengeResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021199, "ala/challenge/getChallengeMvpToastInfo", GetChallengeMvpToastInfoResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021200, "ala/challenge/setChallengeMvpPunishChoose", SetChallengeMvpPunishChooseResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021209, "ala/pksolo/getPkSeasonInfo", AlaGetQualifyingResultResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(1021183, this.bvo);
        MessageManager.getInstance().registerListener(1021105, this.bvo);
        MessageManager.getInstance().registerListener(1021182, this.bvo);
        MessageManager.getInstance().registerListener(1021203, this.bvo);
        MessageManager.getInstance().registerListener(1021106, this.bvo);
        MessageManager.getInstance().registerListener(1021107, this.bvo);
        MessageManager.getInstance().registerListener(1021108, this.bvo);
        MessageManager.getInstance().registerListener(1021109, this.bvo);
        MessageManager.getInstance().registerListener(1021110, this.bvo);
        MessageManager.getInstance().registerListener(1021111, this.bvo);
        MessageManager.getInstance().registerListener(1021115, this.bvo);
        MessageManager.getInstance().registerListener(1021116, this.bvo);
        MessageManager.getInstance().registerListener(1021197, this.bvo);
        MessageManager.getInstance().registerListener(this.bbU);
        MessageManager.getInstance().registerListener(1021209, this.bvo);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bvo);
        MessageManager.getInstance().unRegisterListener(this.bbU);
    }

    private void bRa() {
        MessageManager.getInstance().removeMessage(1021183, this.bhK);
        MessageManager.getInstance().removeMessage(1021105, this.bhK);
        MessageManager.getInstance().removeMessage(1021182, this.bhK);
        MessageManager.getInstance().removeMessage(1021203, this.bhK);
        MessageManager.getInstance().removeMessage(1021106, this.bhK);
        MessageManager.getInstance().removeMessage(1021107, this.bhK);
        MessageManager.getInstance().removeMessage(1021108, this.bhK);
        MessageManager.getInstance().removeMessage(1021109, this.bhK);
        MessageManager.getInstance().removeMessage(1021110, this.bhK);
        MessageManager.getInstance().removeMessage(1021111, this.bhK);
        MessageManager.getInstance().removeMessage(1021116, this.bhK);
        MessageManager.getInstance().removeMessage(1021209, this.bhK);
    }

    private void bRb() {
        MessageManager.getInstance().removeMessage(1021112, this.bhK);
        MessageManager.getInstance().removeMessage(1021115, this.bhK);
    }

    private void reset() {
        this.guw = 0L;
        this.gux = 0L;
        this.buE = 0;
        this.gub = 0;
        this.guy = 0L;
        this.guz = 0L;
        bRe();
        bRd();
        bRf();
        this.mHandler.removeCallbacksAndMessages(null);
        bRa();
        bRb();
    }

    public void bRc() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long Ch() {
        return this.guw;
    }

    public void Ca() {
        HttpMessage httpMessage = new HttpMessage(1021183);
        httpMessage.setTag(this.bhK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void Gr(String str) {
        HttpMessage httpMessage = new HttpMessage(1021209);
        httpMessage.addParam("user_id", str);
        httpMessage.setTag(this.bhK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void w(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.bhK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void e(int i, int i2, String str) {
        HttpMessage httpMessage = new HttpMessage(1021182);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.addParam("query_words", str);
        httpMessage.setTag(this.bhK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void fP(String str) {
        HttpMessage httpMessage = new HttpMessage(1021203);
        httpMessage.setTag(this.bhK);
        httpMessage.addParam("anchor_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void V(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.bhK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void W(long j) {
        this.guw = 0L;
        this.gux = j;
        this.guC = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        lW(true);
        this.mHandler.postDelayed(this.guJ, 1000L);
    }

    public void X(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.bhK);
        MessageManager.getInstance().sendMessage(httpMessage);
        ee(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void Cb() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.bhK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void Y(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.bhK);
        MessageManager.getInstance().sendMessage(httpMessage);
        ee(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void Cc() {
        this.guw = 0L;
        this.guC = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        lX(true);
        this.mHandler.postDelayed(this.guK, 1000L);
    }

    public void Cd() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.bhK);
        MessageManager.getInstance().sendMessage(httpMessage);
        ee(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, null);
    }

    public void Cg() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.guw);
        httpMessage.setTag(this.bhK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void Ci() {
        HttpMessage httpMessage = new HttpMessage(1021197);
        httpMessage.addParam("challenge_id", this.guw);
        httpMessage.setTag(this.bhK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void a(long j, long j2, long j3, int i, String str) {
        HttpMessage httpMessage = new HttpMessage(1021200);
        httpMessage.addParam("challenge_id", j);
        httpMessage.addParam("punish_type", i);
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        httpMessage.addParam(AlaLiveStickerInfo.STICKER_ID, str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeSwitchResponsedMessage alaChallengeSwitchResponsedMessage) {
        if (alaChallengeSwitchResponsedMessage != null && this.gtt != null) {
            if (alaChallengeSwitchResponsedMessage.hasError() || alaChallengeSwitchResponsedMessage.getError() != 0) {
                this.gtt.n(alaChallengeSwitchResponsedMessage.getError(), alaChallengeSwitchResponsedMessage.getErrorString());
            } else {
                this.gtt.Ck();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.gtt != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.gtt.k(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.gtt.a(alaGetTargetListResponseMessage.bQY(), alaGetTargetListResponseMessage.bQZ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSearchTargetListResponseMessage alaSearchTargetListResponseMessage) {
        if (this.gtt != null && alaSearchTargetListResponseMessage != null) {
            if (alaSearchTargetListResponseMessage.hasError() || alaSearchTargetListResponseMessage.getError() != 0) {
                this.gtt.k(alaSearchTargetListResponseMessage.getError(), alaSearchTargetListResponseMessage.getErrorString());
            } else {
                this.gtt.a(alaSearchTargetListResponseMessage.bQY(), alaSearchTargetListResponseMessage.bQZ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeLatestListResponseMessage alaChallengeLatestListResponseMessage) {
        if (this.gtt != null && alaChallengeLatestListResponseMessage != null) {
            if (alaChallengeLatestListResponseMessage.hasError() || alaChallengeLatestListResponseMessage.getError() != 0) {
                this.gtt.aK(alaChallengeLatestListResponseMessage.getError(), alaChallengeLatestListResponseMessage.getErrorString());
            } else {
                this.gtt.cb(alaChallengeLatestListResponseMessage.bQM());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CloseChallengeResponseMessage closeChallengeResponseMessage) {
        if (this.gtt != null && closeChallengeResponseMessage != null) {
            this.gtt.o(!closeChallengeResponseMessage.hasError() && closeChallengeResponseMessage.getError() == 0, closeChallengeResponseMessage.getErrorString());
        }
    }

    private void bRd() {
        this.guG = false;
        MessageManager.getInstance().removeMessage(1021106, this.bhK);
        this.mHandler.removeCallbacks(this.guJ);
        this.guC = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lW(boolean z) {
        this.guG = true;
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.gux);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.bhK);
        MessageManager.getInstance().sendMessage(httpMessage);
        ee(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, ExtraParamsManager.getBase64(String.valueOf(this.gux)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.gtt != null) {
            this.guG = false;
            String base64 = ExtraParamsManager.getBase64(String.valueOf(this.gux));
            String str = "";
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.bQJ() != null) {
                str = alaStartDirectChallengeResponseMessage.bQJ().aCW + "";
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() != 0) {
                if (this.gtt != null) {
                    this.gtt.aL(alaStartDirectChallengeResponseMessage.getError(), alaStartDirectChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, alaStartDirectChallengeResponseMessage, base64, str);
                return;
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() == 0 && alaStartDirectChallengeResponseMessage.bQJ() != null && (alaStartDirectChallengeResponseMessage.bQJ().isValid() || alaStartDirectChallengeResponseMessage.bQJ().isTimeout())) {
                com.baidu.live.challenge.a bQJ = alaStartDirectChallengeResponseMessage.bQJ();
                this.gtt.b(bQJ);
                bRd();
                if (bQJ.BS()) {
                    ef(bQJ.challengeId);
                    this.guw = bQJ.challengeId;
                }
                if (alaStartDirectChallengeResponseMessage.bQJ().isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_TIMEOUT, alaStartDirectChallengeResponseMessage, base64, (String) null);
                }
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_SUCC, alaStartDirectChallengeResponseMessage, base64, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.gtt != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.gtt.aM(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.gux)), (String) null);
                return;
            }
            boolean bQL = alaCancelDirectChallengeResponseMessage.bQL();
            com.baidu.live.challenge.a bQJ = alaCancelDirectChallengeResponseMessage.bQJ();
            this.gtt.b(bQL, alaCancelDirectChallengeResponseMessage.bQJ());
            bRd();
            if (!bQL && bQJ != null && bQJ.BS()) {
                ef(bQJ.challengeId);
                this.guw = bQJ.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT_SUCC, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.gux)), (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.gtt != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.gtt.aN(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.gtt.l(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.bQT());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetQualifyingResultResponseMessage alaGetQualifyingResultResponseMessage) {
        if (this.gtt != null && alaGetQualifyingResultResponseMessage != null) {
            if (alaGetQualifyingResultResponseMessage.bQV()) {
                this.gtt.b(alaGetQualifyingResultResponseMessage.bQU(), alaGetQualifyingResultResponseMessage.bQW());
            } else {
                this.gtt.b(alaGetQualifyingResultResponseMessage.bQU(), -1L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.gtt != null && alaAcceptDirectChallengeResponseMessage != null) {
            String str = "";
            String str2 = "";
            if (alaAcceptDirectChallengeResponseMessage.bQJ() != null) {
                str2 = ExtraParamsManager.getBase64(String.valueOf(alaAcceptDirectChallengeResponseMessage.bQJ().aCY));
            }
            if (alaAcceptDirectChallengeResponseMessage.bQJ() != null) {
                str = alaAcceptDirectChallengeResponseMessage.bQJ().aCW + "";
            }
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.gtt.aO(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, alaAcceptDirectChallengeResponseMessage, str2, str);
                return;
            }
            boolean bQK = alaAcceptDirectChallengeResponseMessage.bQK();
            com.baidu.live.challenge.a bQJ = alaAcceptDirectChallengeResponseMessage.bQJ();
            this.gtt.c(bQK, bQJ);
            if (bQK && bQJ != null) {
                ef(bQJ.challengeId);
                this.guw = bQJ.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET_SUCC, alaAcceptDirectChallengeResponseMessage, str2, str);
        }
    }

    private void bRe() {
        this.guF = false;
        MessageManager.getInstance().removeMessage(1021110, this.bhK);
        this.mHandler.removeCallbacks(this.guK);
        this.guC = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lX(boolean z) {
        this.guF = true;
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.bhK);
        MessageManager.getInstance().sendMessage(httpMessage);
        ee(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        String str;
        String str2;
        boolean z = false;
        if (this.gtt != null) {
            this.guF = false;
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() != 0) {
                if (this.gtt != null) {
                    this.gtt.aP(alaStartRandomChallengeResponseMessage.getError(), alaStartRandomChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, (String) null, (String) null);
                return;
            }
            if (alaStartRandomChallengeResponseMessage == null || alaStartRandomChallengeResponseMessage.bQJ() == null) {
                str = null;
                str2 = null;
            } else {
                str2 = alaStartRandomChallengeResponseMessage.bQJ().aCW + "";
                str = ExtraParamsManager.getBase64(alaStartRandomChallengeResponseMessage.bQJ().aCY + "");
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.bQJ() != null && alaStartRandomChallengeResponseMessage.bQJ().isValid()) {
                com.baidu.live.challenge.a bQJ = alaStartRandomChallengeResponseMessage.bQJ();
                this.gtt.c(bQJ);
                if (bQJ.BS() && !Cf()) {
                    bRe();
                    ef(bQJ.challengeId);
                    this.guw = bQJ.challengeId;
                } else {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, str, str2);
                }
                if (bQJ.isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOW_TIMEOUT, alaStartRandomChallengeResponseMessage, str, (String) null);
                }
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.bQJ() != null && alaStartRandomChallengeResponseMessage.bQJ().isValid()) {
                z = true;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM_SUCC, alaStartRandomChallengeResponseMessage, str, str2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        String str;
        String str2 = null;
        if (this.gtt != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage == null || alaCancelRandomChallengeResponseMessage.bQJ() == null) {
                str = null;
            } else {
                str = alaCancelRandomChallengeResponseMessage.bQJ().challengeId + "";
                str2 = alaCancelRandomChallengeResponseMessage.bQJ().aCW + "";
            }
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.gtt.aQ(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, alaCancelRandomChallengeResponseMessage, str, str2);
                return;
            }
            boolean bQL = alaCancelRandomChallengeResponseMessage.bQL();
            com.baidu.live.challenge.a bQJ = alaCancelRandomChallengeResponseMessage.bQJ();
            this.gtt.d(bQL, alaCancelRandomChallengeResponseMessage.bQJ());
            bRe();
            if (!bQL && bQJ != null && bQJ.BS()) {
                ef(bQJ.challengeId);
                this.guw = bQJ.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCLE_RANDOM_SUCC, alaCancelRandomChallengeResponseMessage, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.gtt != null && alaSurrenderResponseMessage != null) {
            this.gtt.n(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.gtt != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.gtt.j(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.gtt.a(alaGetTargetInfoResponseMessage.bQX());
            }
        }
    }

    public void bf(boolean z) {
        this.buE = z ? 1 : 2;
    }

    public void ef(long j) {
        this.guA = true;
        this.guw = j;
        this.mHandler.post(this.guL);
    }

    private void bRf() {
        this.guA = false;
        this.mHandler.removeCallbacks(this.guL);
        this.guE = false;
        MessageManager.getInstance().removeMessage(1021112, this.bhK);
    }

    public void bRg() {
        this.mHandler.removeCallbacks(this.guL);
        this.guE = false;
        MessageManager.getInstance().removeMessage(1021112, this.bhK);
    }

    public void bRh() {
        this.mHandler.post(this.guL);
    }

    private void a(au auVar, ay ayVar, ay ayVar2, long j) {
        if (auVar == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info challenge meta is null?? logid=" + j);
        } else if (ayVar != null && ayVar.aJW != null && ayVar.aJW.getLiveID() != this.fyR) {
            BdLog.e("CHALLENGE_TAG in challenge not current live?? ||Challenge id=" + auVar.challengeId + "||Challenge Status=" + auVar.aJK + "||Net liveId=" + ayVar.aJW.getLiveID() + "||cur liveId=" + this.fyR + "||logid=" + j);
        } else {
            int i = auVar.aJK;
            this.gtt.b(i, auVar, ayVar, ayVar2);
            switch (i) {
                case 2:
                    this.guC = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    bRa();
                    break;
                case 3:
                    this.guC = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.guC = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.guw = 0L;
                    bRb();
                    break;
            }
            if (ayVar != null && ayVar.aJI != null) {
                this.guy = ayVar.aJI.userId;
            }
            if (ayVar2 != null && ayVar2.aJI != null) {
                this.guz = ayVar2.aJI.userId;
            }
            if (4 == auVar.aJK || 5 == auVar.aJK) {
                bRf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.gtt == null || alaGetChallengeInfoResponseMessage == null || alaGetChallengeInfoResponseMessage.bQN() == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info callback, response message, meta info  null?? ");
            if (alaGetChallengeInfoResponseMessage != null) {
                BdLog.e("CHALLENGE_TAG get Challenge Info error=" + alaGetChallengeInfoResponseMessage.getError());
                return;
            }
            return;
        }
        au bQN = alaGetChallengeInfoResponseMessage.bQN();
        ay bQO = alaGetChallengeInfoResponseMessage.bQO();
        ay bQP = alaGetChallengeInfoResponseMessage.bQP();
        aq bQQ = alaGetChallengeInfoResponseMessage.bQQ();
        aw bQR = alaGetChallengeInfoResponseMessage.bQR();
        ax bQS = alaGetChallengeInfoResponseMessage.bQS();
        if (bQQ != null && bQQ.aJE > 0 && this.guv != bQQ.aJE) {
            this.guv = bQQ.aJE;
        }
        a(bQN, bQO, bQP, alaGetChallengeInfoResponseMessage.getLogId());
        int i = 0;
        if (com.baidu.live.x.a.NN().bhy != null) {
            i = com.baidu.live.x.a.NN().bhy.aHM;
        }
        if (i == 1 && bQN != null && bQO != null && bQO.aJW != null && bQO.aJW.user_id == TbadkCoreApplication.getCurrentAccountId()) {
            if (this.guH == null) {
                this.guH = new HashMap();
            }
            long j = bQN.challengeId;
            if (bQS != null && bQS.aJV != null && !bQS.aJV.isEmpty() && (!this.guH.containsKey(Long.valueOf(j)) || this.guH.get(Long.valueOf(j)).isEmpty())) {
                this.guH.put(Long.valueOf(j), bQS.aJV);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913209, bQS.aJV));
            }
            if (bQR != null && bQN.aJK >= 3 && bQN.challengeResult == 2) {
                if ((bQR.type == 1 || bQR.type == 3) && !TextUtils.isEmpty(bQR.aJT)) {
                    if (this.guI == null) {
                        this.guI = new HashMap();
                    }
                    if (!this.guI.containsKey(Long.valueOf(j))) {
                        this.guI.put(Long.valueOf(j), 0);
                    }
                    if (bQN.aJK == 3) {
                        int intValue = this.guI.get(Long.valueOf(j)).intValue();
                        if (bQR.serverTime >= bQR.startTime && bQR.serverTime <= bQR.endTime) {
                            if (intValue < 1) {
                                this.guI.put(Long.valueOf(j), 1);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913210, bQR.aJT));
                            }
                        } else if (bQR.serverTime > bQR.endTime && intValue < 2) {
                            this.guI.put(Long.valueOf(j), 2);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                        }
                    } else if (bQN.aJK > 3) {
                        this.guI.put(Long.valueOf(j), 2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                    }
                }
            }
        }
    }

    public ChallenfeInfoData.ChallengeStatus Ce() {
        return this.guC;
    }

    private void ee(String str, String str2) {
        if (this.isHost) {
            UbcStatisticManager.getInstance().logSendRequest(v(str, str2, null, UbcStatisticLiveKey.KEY_ID_PK_REQ));
        }
    }

    private void a(String str, HttpResponsedMessage httpResponsedMessage, String str2, String str3) {
        if (this.isHost && httpResponsedMessage != null) {
            UbcStatisticManager.getInstance().logSendResponse(v(str, str2, str3, UbcStatisticLiveKey.KEY_ID_PK_RESP), httpResponsedMessage, true);
        }
    }

    private void a(String str, HttpResponsedMessage httpResponsedMessage, String str2, String str3, boolean z) {
        if (this.isHost && httpResponsedMessage != null) {
            UbcStatisticManager.getInstance().logSendResponse(a(str, str2, str3, z, UbcStatisticLiveKey.KEY_ID_PK_RESP), httpResponsedMessage, true);
        }
    }

    private UbcStatisticItem a(String str, String str2, String str3, boolean z, String str4) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str4, str, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (str2 != null) {
            try {
                jSONObject2.put("rival_uk", str2);
            } catch (JSONException e) {
            }
        }
        if (str3 != null) {
            jSONObject2.put("status", str3);
        }
        jSONObject2.put("is_matched", z);
        jSONObject.put("pk", jSONObject2);
        ubcStatisticItem.setContentExt(jSONObject);
        return ubcStatisticItem;
    }

    private UbcStatisticItem v(String str, String str2, String str3, String str4) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str4, str, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (str2 != null) {
            try {
                jSONObject2.put("rival_uk", str2);
            } catch (JSONException e) {
            }
        }
        if (str3 != null) {
            jSONObject2.put("status", str3);
        }
        jSONObject.put("pk", jSONObject2);
        ubcStatisticItem.setContentExt(jSONObject);
        return ubcStatisticItem;
    }

    public boolean Cf() {
        return this.guA;
    }
}
