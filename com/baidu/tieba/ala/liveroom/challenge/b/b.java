package com.baidu.tieba.ala.liveroom.challenge.b;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.ala.recorder.video.AlaRecorderLog;
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
import com.baidu.live.data.bc;
import com.baidu.live.data.bg;
import com.baidu.live.data.bi;
import com.baidu.live.data.bj;
import com.baidu.live.data.bk;
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
/* loaded from: classes11.dex */
public class b {
    private BdUniqueId aCW;
    private int bOQ;
    private long gpB;
    private a huz;
    private long hvA;
    private long hvB;
    private long hvC;
    private long hvD;
    private long hvE;
    private long hvG;
    private ChallenfeInfoData.ChallengeStatus hvH;
    private i.f hvI;
    private int hvg;
    private long hvy;
    private long hvz;
    private boolean isHost;
    private TbPageContext mPageContext;
    private boolean hvF = false;
    private boolean hvJ = false;
    private boolean hvK = false;
    private boolean hvL = false;
    private HttpMessageListener bQL = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.1
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
    private HttpMessageListener bld = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                b.this.hvJ = false;
                if (!b.this.huz.ccB()) {
                    b.this.b((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                    b.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                }
            }
        }
    };
    private Runnable hvO = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.hvL) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.hvz);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, b.this.aCW);
            b.this.oa(false);
            b.this.mHandler.postDelayed(this, b.this.hvz);
        }
    };
    private Runnable hvP = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.4
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.hvK) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.hvy);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, b.this.aCW);
            b.this.ob(false);
            b.this.mHandler.postDelayed(this, b.this.hvy);
        }
    };
    private Runnable hvQ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.5
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.hvB <= 0) {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().removeMessage(1021112, b.this.aCW);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            if (b.this.hvJ) {
                b.this.mHandler.postDelayed(this, b.this.hvA);
                return;
            }
            MessageManager.getInstance().removeMessage(1021112, b.this.aCW);
            if (b.this.hvI != null) {
                b.this.hvg = b.this.hvI.AL();
            }
            b.this.hvJ = true;
            com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(b.this.hvB, b.this.bOQ, b.this.gpB, b.this.hvG, b.this.hvg);
            aVar.setTag(b.this.aCW);
            MessageManager.getInstance().sendMessage(aVar);
            if (b.this.isHost) {
                UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_REQ, UbcStatConstant.ContentType.UBC_TYPE_PK_CHALLENGE_INFO, "author_liveroom", "");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("avts_conn", b.this.bOQ);
                    jSONObject2.put("avts_fail", b.this.hvg);
                    jSONObject2.put("chat_id", b.this.hvB);
                    jSONObject.put("pk", jSONObject2);
                } catch (JSONException e) {
                }
                ubcStatisticItem.setContentExt(jSONObject);
                UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
            }
            b.this.mHandler.postDelayed(this, b.this.hvA);
        }
    };
    private Handler mHandler = new Handler();
    private Map<Long, List<Long>> hvM = new HashMap();
    private Map<Long, Integer> hvN = new HashMap();

    /* loaded from: classes11.dex */
    public interface a {
        void AM();

        void a(com.baidu.live.challenge.b bVar, List<d> list);

        void a(d dVar);

        void b(int i, bg bgVar, bk bkVar, bk bkVar2);

        void b(com.baidu.live.challenge.a aVar);

        void b(boolean z, com.baidu.live.challenge.a aVar);

        void bf(int i, String str);

        void bg(int i, String str);

        void bh(int i, String str);

        void bi(int i, String str);

        void bj(int i, String str);

        void bk(int i, String str);

        void bl(int i, String str);

        void bm(int i, String str);

        void c(com.baidu.live.challenge.a aVar);

        void c(boolean z, com.baidu.live.challenge.a aVar);

        void cC(List<d> list);

        boolean ccB();

        void d(boolean z, com.baidu.live.challenge.a aVar);

        void k(boolean z, long j);

        void m(int i, List<d> list);

        void p(int i, String str);

        void q(int i, String str);

        void t(int i, String str);

        void w(boolean z, String str);

        void x(boolean z, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        UbcStatisticItem ubcStatisticItem;
        if (alaGetChallengeInfoResponseMessage != null && this.isHost) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("avts_conn", this.bOQ);
                jSONObject2.put("avts_fail", this.hvg);
                if (alaGetChallengeInfoResponseMessage.ccR() != null) {
                    jSONObject2.put("chat_id", alaGetChallengeInfoResponseMessage.ccR().challengeId);
                    jSONObject2.put(AlaRecorderLog.KEY_CHAT_STATUS, alaGetChallengeInfoResponseMessage.ccR().aOK);
                }
                jSONObject.put("pk", jSONObject2);
            } catch (JSONException e) {
            }
            if (alaGetChallengeInfoResponseMessage.hasError() || alaGetChallengeInfoResponseMessage.getError() != 0) {
                ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RESP, UbcStatConstant.ContentType.UBC_TYPE_PK_CHALLENGE_INFO, "author_liveroom", "");
            } else {
                ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RESP, UbcStatConstant.ContentType.UBC_TYPE_PK_CHALLENGE_INFO_SUCC, "author_liveroom", "");
            }
            ubcStatisticItem.setContentExt(jSONObject);
            UbcStatisticManager.getInstance().logSendResponse(ubcStatisticItem, alaGetChallengeInfoResponseMessage, true);
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.aCW = bdUniqueId;
        this.hvy = com.baidu.live.ae.a.Qj().buX.aLV > 0 ? com.baidu.live.ae.a.Qj().buX.aLV : 1000L;
        this.hvz = com.baidu.live.ae.a.Qj().buX.aLW > 0 ? com.baidu.live.ae.a.Qj().buX.aLW : 1000L;
        this.hvA = com.baidu.live.ae.a.Qj().buX.aLX > 0 ? com.baidu.live.ae.a.Qj().buX.aLX : 1000L;
        this.hvH = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        registerTask();
        registerListener();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public void h(long j, long j2) {
        this.gpB = j;
        this.hvG = j2;
    }

    public void a(a aVar) {
        this.huz = aVar;
    }

    public void b(i.f fVar) {
        this.hvI = fVar;
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
        MessageManager.getInstance().registerListener(1021183, this.bQL);
        MessageManager.getInstance().registerListener(1021105, this.bQL);
        MessageManager.getInstance().registerListener(1021182, this.bQL);
        MessageManager.getInstance().registerListener(1021203, this.bQL);
        MessageManager.getInstance().registerListener(1021106, this.bQL);
        MessageManager.getInstance().registerListener(1021107, this.bQL);
        MessageManager.getInstance().registerListener(1021108, this.bQL);
        MessageManager.getInstance().registerListener(1021109, this.bQL);
        MessageManager.getInstance().registerListener(1021110, this.bQL);
        MessageManager.getInstance().registerListener(1021111, this.bQL);
        MessageManager.getInstance().registerListener(1021115, this.bQL);
        MessageManager.getInstance().registerListener(1021116, this.bQL);
        MessageManager.getInstance().registerListener(1021197, this.bQL);
        MessageManager.getInstance().registerListener(this.bld);
        MessageManager.getInstance().registerListener(1021209, this.bQL);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bQL);
        MessageManager.getInstance().unRegisterListener(this.bld);
    }

    private void cde() {
        MessageManager.getInstance().removeMessage(1021183, this.aCW);
        MessageManager.getInstance().removeMessage(1021105, this.aCW);
        MessageManager.getInstance().removeMessage(1021182, this.aCW);
        MessageManager.getInstance().removeMessage(1021203, this.aCW);
        MessageManager.getInstance().removeMessage(1021106, this.aCW);
        MessageManager.getInstance().removeMessage(1021107, this.aCW);
        MessageManager.getInstance().removeMessage(1021108, this.aCW);
        MessageManager.getInstance().removeMessage(1021109, this.aCW);
        MessageManager.getInstance().removeMessage(1021110, this.aCW);
        MessageManager.getInstance().removeMessage(1021111, this.aCW);
        MessageManager.getInstance().removeMessage(1021116, this.aCW);
        MessageManager.getInstance().removeMessage(1021209, this.aCW);
    }

    private void cdf() {
        MessageManager.getInstance().removeMessage(1021112, this.aCW);
        MessageManager.getInstance().removeMessage(1021115, this.aCW);
    }

    private void reset() {
        this.hvB = 0L;
        this.hvC = 0L;
        this.bOQ = 0;
        this.hvg = 0;
        this.hvD = 0L;
        this.hvE = 0L;
        cdi();
        cdh();
        cdj();
        this.mHandler.removeCallbacksAndMessages(null);
        cde();
        cdf();
    }

    public void cdg() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long AJ() {
        return this.hvB;
    }

    public void AC() {
        HttpMessage httpMessage = new HttpMessage(1021183);
        httpMessage.setTag(this.aCW);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void HD(String str) {
        HttpMessage httpMessage = new HttpMessage(1021209);
        httpMessage.addParam("user_id", str);
        httpMessage.setTag(this.aCW);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void y(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.aCW);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void g(int i, int i2, String str) {
        HttpMessage httpMessage = new HttpMessage(1021182);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.addParam("query_words", str);
        httpMessage.setTag(this.aCW);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void fq(String str) {
        HttpMessage httpMessage = new HttpMessage(1021203);
        httpMessage.setTag(this.aCW);
        httpMessage.addParam("anchor_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void aI(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.aCW);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void aJ(long j) {
        this.hvB = 0L;
        this.hvC = j;
        this.hvH = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        oa(true);
        this.mHandler.postDelayed(this.hvO, 1000L);
    }

    public void aK(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.aCW);
        MessageManager.getInstance().sendMessage(httpMessage);
        ev(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void AD() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.aCW);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void aL(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.aCW);
        MessageManager.getInstance().sendMessage(httpMessage);
        ev(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void AE() {
        this.hvB = 0L;
        this.hvH = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        ob(true);
        this.mHandler.postDelayed(this.hvP, 1000L);
    }

    public void AF() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.aCW);
        MessageManager.getInstance().sendMessage(httpMessage);
        ev(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, null);
    }

    public void AI() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.hvB);
        httpMessage.setTag(this.aCW);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void AK() {
        HttpMessage httpMessage = new HttpMessage(1021197);
        httpMessage.addParam("challenge_id", this.hvB);
        httpMessage.setTag(this.aCW);
        MessageManager.getInstance().sendMessage(httpMessage);
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_CLOSE, "author_liveroom", ""));
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
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_MVPPUNISHCHOOSE, "author_liveroom", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeSwitchResponsedMessage alaChallengeSwitchResponsedMessage) {
        if (alaChallengeSwitchResponsedMessage != null && this.huz != null) {
            if (alaChallengeSwitchResponsedMessage.hasError() || alaChallengeSwitchResponsedMessage.getError() != 0) {
                this.huz.t(alaChallengeSwitchResponsedMessage.getError(), alaChallengeSwitchResponsedMessage.getErrorString());
            } else {
                this.huz.AM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.huz != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.huz.q(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.huz.a(alaGetTargetListResponseMessage.cdc(), alaGetTargetListResponseMessage.cdd());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSearchTargetListResponseMessage alaSearchTargetListResponseMessage) {
        if (this.huz != null && alaSearchTargetListResponseMessage != null) {
            if (alaSearchTargetListResponseMessage.hasError() || alaSearchTargetListResponseMessage.getError() != 0) {
                this.huz.q(alaSearchTargetListResponseMessage.getError(), alaSearchTargetListResponseMessage.getErrorString());
            } else {
                this.huz.a(alaSearchTargetListResponseMessage.cdc(), alaSearchTargetListResponseMessage.cdd());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeLatestListResponseMessage alaChallengeLatestListResponseMessage) {
        if (this.huz != null && alaChallengeLatestListResponseMessage != null) {
            if (alaChallengeLatestListResponseMessage.hasError() || alaChallengeLatestListResponseMessage.getError() != 0) {
                this.huz.bf(alaChallengeLatestListResponseMessage.getError(), alaChallengeLatestListResponseMessage.getErrorString());
            } else {
                this.huz.cC(alaChallengeLatestListResponseMessage.ccQ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CloseChallengeResponseMessage closeChallengeResponseMessage) {
        if (this.huz != null && closeChallengeResponseMessage != null) {
            boolean z = !closeChallengeResponseMessage.hasError() && closeChallengeResponseMessage.getError() == 0;
            this.huz.x(z, closeChallengeResponseMessage.getErrorString());
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_CLOSE_RESULT, "author_liveroom", z ? "challenge_close_succ" : "challenge_close_fail"), closeChallengeResponseMessage, true);
        }
    }

    private void cdh() {
        this.hvL = false;
        MessageManager.getInstance().removeMessage(1021106, this.aCW);
        this.mHandler.removeCallbacks(this.hvO);
        this.hvH = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oa(boolean z) {
        this.hvL = true;
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.hvC);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.aCW);
        MessageManager.getInstance().sendMessage(httpMessage);
        ev(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, ExtraParamsManager.getBase64(String.valueOf(this.hvC)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.huz != null) {
            this.hvL = false;
            String base64 = ExtraParamsManager.getBase64(String.valueOf(this.hvC));
            String str = "";
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.ccN() != null) {
                str = alaStartDirectChallengeResponseMessage.ccN().aFs + "";
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() != 0) {
                if (this.huz != null) {
                    this.huz.bg(alaStartDirectChallengeResponseMessage.getError(), alaStartDirectChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, alaStartDirectChallengeResponseMessage, base64, str);
                return;
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() == 0 && alaStartDirectChallengeResponseMessage.ccN() != null && (alaStartDirectChallengeResponseMessage.ccN().isValid() || alaStartDirectChallengeResponseMessage.ccN().isTimeout())) {
                com.baidu.live.challenge.a ccN = alaStartDirectChallengeResponseMessage.ccN();
                this.huz.b(ccN);
                cdh();
                if (ccN.At()) {
                    fC(ccN.challengeId);
                    this.hvB = ccN.challengeId;
                }
                if (alaStartDirectChallengeResponseMessage.ccN().isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_TIMEOUT, alaStartDirectChallengeResponseMessage, base64, (String) null);
                }
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_SUCC, alaStartDirectChallengeResponseMessage, base64, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.huz != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.huz.bh(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.hvC)), (String) null);
                return;
            }
            boolean ccP = alaCancelDirectChallengeResponseMessage.ccP();
            com.baidu.live.challenge.a ccN = alaCancelDirectChallengeResponseMessage.ccN();
            this.huz.b(ccP, alaCancelDirectChallengeResponseMessage.ccN());
            cdh();
            if (!ccP && ccN != null && ccN.At()) {
                fC(ccN.challengeId);
                this.hvB = ccN.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT_SUCC, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.hvC)), (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.huz != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.huz.bi(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.huz.m(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.ccX());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetQualifyingResultResponseMessage alaGetQualifyingResultResponseMessage) {
        if (this.huz != null && alaGetQualifyingResultResponseMessage != null) {
            if (alaGetQualifyingResultResponseMessage.hasError() || alaGetQualifyingResultResponseMessage.getError() != 0) {
                this.huz.bj(alaGetQualifyingResultResponseMessage.getError(), alaGetQualifyingResultResponseMessage.getErrorString());
            } else if (alaGetQualifyingResultResponseMessage.ccZ()) {
                this.huz.k(alaGetQualifyingResultResponseMessage.ccY(), alaGetQualifyingResultResponseMessage.cda());
            } else {
                this.huz.k(alaGetQualifyingResultResponseMessage.ccY(), -1L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.huz != null && alaAcceptDirectChallengeResponseMessage != null) {
            String str = "";
            String str2 = "";
            if (alaAcceptDirectChallengeResponseMessage.ccN() != null) {
                str2 = ExtraParamsManager.getBase64(String.valueOf(alaAcceptDirectChallengeResponseMessage.ccN().aFu));
            }
            if (alaAcceptDirectChallengeResponseMessage.ccN() != null) {
                str = alaAcceptDirectChallengeResponseMessage.ccN().aFs + "";
            }
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.huz.bk(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, alaAcceptDirectChallengeResponseMessage, str2, str);
                return;
            }
            boolean ccO = alaAcceptDirectChallengeResponseMessage.ccO();
            com.baidu.live.challenge.a ccN = alaAcceptDirectChallengeResponseMessage.ccN();
            this.huz.c(ccO, ccN);
            if (ccO && ccN != null) {
                fC(ccN.challengeId);
                this.hvB = ccN.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET_SUCC, alaAcceptDirectChallengeResponseMessage, str2, str);
        }
    }

    private void cdi() {
        this.hvK = false;
        MessageManager.getInstance().removeMessage(1021110, this.aCW);
        this.mHandler.removeCallbacks(this.hvP);
        this.hvH = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ob(boolean z) {
        this.hvK = true;
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.aCW);
        MessageManager.getInstance().sendMessage(httpMessage);
        ev(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        String str;
        String str2;
        boolean z = false;
        if (this.huz != null) {
            this.hvK = false;
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() != 0) {
                if (this.huz != null) {
                    this.huz.bl(alaStartRandomChallengeResponseMessage.getError(), alaStartRandomChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, (String) null, (String) null);
                return;
            }
            if (alaStartRandomChallengeResponseMessage == null || alaStartRandomChallengeResponseMessage.ccN() == null) {
                str = null;
                str2 = null;
            } else {
                str2 = alaStartRandomChallengeResponseMessage.ccN().aFs + "";
                str = ExtraParamsManager.getBase64(alaStartRandomChallengeResponseMessage.ccN().aFu + "");
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.ccN() != null && alaStartRandomChallengeResponseMessage.ccN().isValid()) {
                com.baidu.live.challenge.a ccN = alaStartRandomChallengeResponseMessage.ccN();
                this.huz.c(ccN);
                if (ccN.At() && !AH()) {
                    cdi();
                    fC(ccN.challengeId);
                    this.hvB = ccN.challengeId;
                } else {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, str, str2);
                }
                if (ccN.isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOW_TIMEOUT, alaStartRandomChallengeResponseMessage, str, (String) null);
                }
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.ccN() != null && alaStartRandomChallengeResponseMessage.ccN().isValid()) {
                z = true;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM_SUCC, alaStartRandomChallengeResponseMessage, str, str2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        String str;
        String str2;
        if (this.huz != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage == null || alaCancelRandomChallengeResponseMessage.ccN() == null) {
                str = null;
                str2 = null;
            } else {
                str = alaCancelRandomChallengeResponseMessage.ccN().aFs + "";
                str2 = alaCancelRandomChallengeResponseMessage.ccN().challengeId + "";
            }
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.huz.bm(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, alaCancelRandomChallengeResponseMessage, str2, str);
                return;
            }
            boolean ccP = alaCancelRandomChallengeResponseMessage.ccP();
            com.baidu.live.challenge.a ccN = alaCancelRandomChallengeResponseMessage.ccN();
            this.huz.d(ccP, alaCancelRandomChallengeResponseMessage.ccN());
            cdi();
            if (!ccP && ccN != null && ccN.At()) {
                fC(ccN.challengeId);
                this.hvB = ccN.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCLE_RANDOM_SUCC, alaCancelRandomChallengeResponseMessage, str2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.huz != null && alaSurrenderResponseMessage != null) {
            this.huz.w(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.huz != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.huz.p(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.huz.a(alaGetTargetInfoResponseMessage.cdb());
            }
        }
    }

    public void bq(boolean z) {
        this.bOQ = z ? 1 : 2;
    }

    public void fC(long j) {
        this.hvF = true;
        this.hvB = j;
        this.mHandler.post(this.hvQ);
    }

    private void cdj() {
        this.hvF = false;
        this.mHandler.removeCallbacks(this.hvQ);
        this.hvJ = false;
        MessageManager.getInstance().removeMessage(1021112, this.aCW);
    }

    public void cdk() {
        this.mHandler.removeCallbacks(this.hvQ);
        this.hvJ = false;
        MessageManager.getInstance().removeMessage(1021112, this.aCW);
    }

    public void cdl() {
        this.mHandler.post(this.hvQ);
    }

    private void a(bg bgVar, bk bkVar, bk bkVar2, long j) {
        if (bgVar == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info challenge meta is null?? logid=" + j);
        } else if (bkVar != null && bkVar.aOW != null && bkVar.aOW.getLiveID() != this.gpB) {
            BdLog.e("CHALLENGE_TAG in challenge not current live?? ||Challenge id=" + bgVar.challengeId + "||Challenge Status=" + bgVar.aOK + "||Net liveId=" + bkVar.aOW.getLiveID() + "||cur liveId=" + this.gpB + "||logid=" + j);
        } else {
            int i = bgVar.aOK;
            this.huz.b(i, bgVar, bkVar, bkVar2);
            switch (i) {
                case 2:
                    this.hvH = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    cde();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913284));
                    break;
                case 3:
                    this.hvH = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.hvH = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.hvB = 0L;
                    cdf();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913283));
                    break;
            }
            if (bkVar != null && bkVar.aOI != null) {
                this.hvD = bkVar.aOI.userId;
            }
            if (bkVar2 != null && bkVar2.aOI != null) {
                this.hvE = bkVar2.aOI.userId;
            }
            if (4 == bgVar.aOK || 5 == bgVar.aOK) {
                cdj();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.huz == null || alaGetChallengeInfoResponseMessage == null || alaGetChallengeInfoResponseMessage.ccR() == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info callback, response message, meta info  null?? ");
            if (alaGetChallengeInfoResponseMessage != null) {
                BdLog.e("CHALLENGE_TAG get Challenge Info error=" + alaGetChallengeInfoResponseMessage.getError());
                return;
            }
            return;
        }
        bg ccR = alaGetChallengeInfoResponseMessage.ccR();
        bk ccS = alaGetChallengeInfoResponseMessage.ccS();
        bk ccT = alaGetChallengeInfoResponseMessage.ccT();
        bc ccU = alaGetChallengeInfoResponseMessage.ccU();
        bi ccV = alaGetChallengeInfoResponseMessage.ccV();
        bj ccW = alaGetChallengeInfoResponseMessage.ccW();
        if (ccU != null && ccU.aOE > 0 && this.hvA != ccU.aOE) {
            this.hvA = ccU.aOE;
        }
        a(ccR, ccS, ccT, alaGetChallengeInfoResponseMessage.getLogId());
        int i = 0;
        if (com.baidu.live.ae.a.Qj().buX != null) {
            i = com.baidu.live.ae.a.Qj().buX.aMd;
        }
        if (i == 1 && ccR != null && ccS != null && ccS.aOW != null && ccS.aOW.user_id == TbadkCoreApplication.getCurrentAccountId()) {
            if (this.hvM == null) {
                this.hvM = new HashMap();
            }
            long j = ccR.challengeId;
            if (ccW != null && ccW.aOV != null && !ccW.aOV.isEmpty() && (!this.hvM.containsKey(Long.valueOf(j)) || this.hvM.get(Long.valueOf(j)).isEmpty())) {
                this.hvM.put(Long.valueOf(j), ccW.aOV);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913209, ccW.aOV));
            }
            if (ccV != null && ccR.aOK >= 3 && ccR.challengeResult == 2) {
                if ((ccV.type == 1 || ccV.type == 3) && !TextUtils.isEmpty(ccV.aOT)) {
                    if (this.hvN == null) {
                        this.hvN = new HashMap();
                    }
                    if (!this.hvN.containsKey(Long.valueOf(j))) {
                        this.hvN.put(Long.valueOf(j), 0);
                    }
                    if (ccR.aOK == 3) {
                        int intValue = this.hvN.get(Long.valueOf(j)).intValue();
                        if (ccV.serverTime >= ccV.startTime && ccV.serverTime <= ccV.endTime) {
                            if (intValue < 1) {
                                this.hvN.put(Long.valueOf(j), 1);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913210, ccV.aOT));
                            }
                        } else if (ccV.serverTime > ccV.endTime && intValue < 2) {
                            this.hvN.put(Long.valueOf(j), 2);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                        }
                    } else if (ccR.aOK > 3) {
                        this.hvN.put(Long.valueOf(j), 2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                    }
                }
            }
        }
    }

    public ChallenfeInfoData.ChallengeStatus AG() {
        return this.hvH;
    }

    private void ev(String str, String str2) {
        if (this.isHost) {
            UbcStatisticManager.getInstance().logSendRequest(w(str, str2, null, UbcStatisticLiveKey.KEY_ID_PK_REQ));
        }
    }

    private void a(String str, HttpResponsedMessage httpResponsedMessage, String str2, String str3) {
        if (this.isHost && httpResponsedMessage != null) {
            UbcStatisticManager.getInstance().logSendResponse(w(str, str2, str3, UbcStatisticLiveKey.KEY_ID_PK_RESP), httpResponsedMessage, true);
        }
    }

    private void a(String str, HttpResponsedMessage httpResponsedMessage, String str2, String str3, boolean z) {
        if (this.isHost && httpResponsedMessage != null) {
            UbcStatisticManager.getInstance().logSendResponse(a(str, str2, str3, z, UbcStatisticLiveKey.KEY_ID_PK_RESP), httpResponsedMessage, true);
        }
    }

    private UbcStatisticItem a(String str, String str2, String str3, boolean z, String str4) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str4, str, "author_liveroom", "");
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

    private UbcStatisticItem w(String str, String str2, String str3, String str4) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str4, str, "author_liveroom", "");
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

    public boolean AH() {
        return this.hvF;
    }
}
