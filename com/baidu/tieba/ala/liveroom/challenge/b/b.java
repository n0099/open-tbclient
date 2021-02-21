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
    private long gpP;
    private a huN;
    private long hvM;
    private long hvN;
    private long hvO;
    private long hvP;
    private long hvQ;
    private long hvR;
    private long hvS;
    private long hvU;
    private ChallenfeInfoData.ChallengeStatus hvV;
    private i.f hvW;
    private int hvu;
    private boolean isHost;
    private TbPageContext mPageContext;
    private boolean hvT = false;
    private boolean hvX = false;
    private boolean hvY = false;
    private boolean hvZ = false;
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
                b.this.hvX = false;
                if (!b.this.huN.ccI()) {
                    b.this.b((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                    b.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                }
            }
        }
    };
    private Runnable hwc = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.hvZ) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.hvN);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, b.this.aCW);
            b.this.oa(false);
            b.this.mHandler.postDelayed(this, b.this.hvN);
        }
    };
    private Runnable hwd = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.4
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.hvY) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.hvM);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, b.this.aCW);
            b.this.ob(false);
            b.this.mHandler.postDelayed(this, b.this.hvM);
        }
    };
    private Runnable hwe = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.5
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.hvP <= 0) {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().removeMessage(1021112, b.this.aCW);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            if (b.this.hvX) {
                b.this.mHandler.postDelayed(this, b.this.hvO);
                return;
            }
            MessageManager.getInstance().removeMessage(1021112, b.this.aCW);
            if (b.this.hvW != null) {
                b.this.hvu = b.this.hvW.AL();
            }
            b.this.hvX = true;
            com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(b.this.hvP, b.this.bOQ, b.this.gpP, b.this.hvU, b.this.hvu);
            aVar.setTag(b.this.aCW);
            MessageManager.getInstance().sendMessage(aVar);
            if (b.this.isHost) {
                UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_REQ, UbcStatConstant.ContentType.UBC_TYPE_PK_CHALLENGE_INFO, "author_liveroom", "");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("avts_conn", b.this.bOQ);
                    jSONObject2.put("avts_fail", b.this.hvu);
                    jSONObject2.put("chat_id", b.this.hvP);
                    jSONObject.put("pk", jSONObject2);
                } catch (JSONException e) {
                }
                ubcStatisticItem.setContentExt(jSONObject);
                UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
            }
            b.this.mHandler.postDelayed(this, b.this.hvO);
        }
    };
    private Handler mHandler = new Handler();
    private Map<Long, List<Long>> hwa = new HashMap();
    private Map<Long, Integer> hwb = new HashMap();

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

        boolean ccI();

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
                jSONObject2.put("avts_fail", this.hvu);
                if (alaGetChallengeInfoResponseMessage.ccY() != null) {
                    jSONObject2.put("chat_id", alaGetChallengeInfoResponseMessage.ccY().challengeId);
                    jSONObject2.put(AlaRecorderLog.KEY_CHAT_STATUS, alaGetChallengeInfoResponseMessage.ccY().aOK);
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
        this.hvM = com.baidu.live.ae.a.Qj().buX.aLV > 0 ? com.baidu.live.ae.a.Qj().buX.aLV : 1000L;
        this.hvN = com.baidu.live.ae.a.Qj().buX.aLW > 0 ? com.baidu.live.ae.a.Qj().buX.aLW : 1000L;
        this.hvO = com.baidu.live.ae.a.Qj().buX.aLX > 0 ? com.baidu.live.ae.a.Qj().buX.aLX : 1000L;
        this.hvV = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        registerTask();
        registerListener();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public void h(long j, long j2) {
        this.gpP = j;
        this.hvU = j2;
    }

    public void a(a aVar) {
        this.huN = aVar;
    }

    public void b(i.f fVar) {
        this.hvW = fVar;
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

    private void cdl() {
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

    private void cdm() {
        MessageManager.getInstance().removeMessage(1021112, this.aCW);
        MessageManager.getInstance().removeMessage(1021115, this.aCW);
    }

    private void reset() {
        this.hvP = 0L;
        this.hvQ = 0L;
        this.bOQ = 0;
        this.hvu = 0;
        this.hvR = 0L;
        this.hvS = 0L;
        cdp();
        cdo();
        cdq();
        this.mHandler.removeCallbacksAndMessages(null);
        cdl();
        cdm();
    }

    public void cdn() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long AJ() {
        return this.hvP;
    }

    public void AC() {
        HttpMessage httpMessage = new HttpMessage(1021183);
        httpMessage.setTag(this.aCW);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void HE(String str) {
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
        this.hvP = 0L;
        this.hvQ = j;
        this.hvV = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        oa(true);
        this.mHandler.postDelayed(this.hwc, 1000L);
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
        this.hvP = 0L;
        this.hvV = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        ob(true);
        this.mHandler.postDelayed(this.hwd, 1000L);
    }

    public void AF() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.aCW);
        MessageManager.getInstance().sendMessage(httpMessage);
        ev(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, null);
    }

    public void AI() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.hvP);
        httpMessage.setTag(this.aCW);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void AK() {
        HttpMessage httpMessage = new HttpMessage(1021197);
        httpMessage.addParam("challenge_id", this.hvP);
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
        if (alaChallengeSwitchResponsedMessage != null && this.huN != null) {
            if (alaChallengeSwitchResponsedMessage.hasError() || alaChallengeSwitchResponsedMessage.getError() != 0) {
                this.huN.t(alaChallengeSwitchResponsedMessage.getError(), alaChallengeSwitchResponsedMessage.getErrorString());
            } else {
                this.huN.AM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.huN != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.huN.q(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.huN.a(alaGetTargetListResponseMessage.cdj(), alaGetTargetListResponseMessage.cdk());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSearchTargetListResponseMessage alaSearchTargetListResponseMessage) {
        if (this.huN != null && alaSearchTargetListResponseMessage != null) {
            if (alaSearchTargetListResponseMessage.hasError() || alaSearchTargetListResponseMessage.getError() != 0) {
                this.huN.q(alaSearchTargetListResponseMessage.getError(), alaSearchTargetListResponseMessage.getErrorString());
            } else {
                this.huN.a(alaSearchTargetListResponseMessage.cdj(), alaSearchTargetListResponseMessage.cdk());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeLatestListResponseMessage alaChallengeLatestListResponseMessage) {
        if (this.huN != null && alaChallengeLatestListResponseMessage != null) {
            if (alaChallengeLatestListResponseMessage.hasError() || alaChallengeLatestListResponseMessage.getError() != 0) {
                this.huN.bf(alaChallengeLatestListResponseMessage.getError(), alaChallengeLatestListResponseMessage.getErrorString());
            } else {
                this.huN.cC(alaChallengeLatestListResponseMessage.ccX());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CloseChallengeResponseMessage closeChallengeResponseMessage) {
        if (this.huN != null && closeChallengeResponseMessage != null) {
            boolean z = !closeChallengeResponseMessage.hasError() && closeChallengeResponseMessage.getError() == 0;
            this.huN.x(z, closeChallengeResponseMessage.getErrorString());
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_CLOSE_RESULT, "author_liveroom", z ? "challenge_close_succ" : "challenge_close_fail"), closeChallengeResponseMessage, true);
        }
    }

    private void cdo() {
        this.hvZ = false;
        MessageManager.getInstance().removeMessage(1021106, this.aCW);
        this.mHandler.removeCallbacks(this.hwc);
        this.hvV = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oa(boolean z) {
        this.hvZ = true;
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.hvQ);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.aCW);
        MessageManager.getInstance().sendMessage(httpMessage);
        ev(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, ExtraParamsManager.getBase64(String.valueOf(this.hvQ)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.huN != null) {
            this.hvZ = false;
            String base64 = ExtraParamsManager.getBase64(String.valueOf(this.hvQ));
            String str = "";
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.ccU() != null) {
                str = alaStartDirectChallengeResponseMessage.ccU().aFs + "";
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() != 0) {
                if (this.huN != null) {
                    this.huN.bg(alaStartDirectChallengeResponseMessage.getError(), alaStartDirectChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, alaStartDirectChallengeResponseMessage, base64, str);
                return;
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() == 0 && alaStartDirectChallengeResponseMessage.ccU() != null && (alaStartDirectChallengeResponseMessage.ccU().isValid() || alaStartDirectChallengeResponseMessage.ccU().isTimeout())) {
                com.baidu.live.challenge.a ccU = alaStartDirectChallengeResponseMessage.ccU();
                this.huN.b(ccU);
                cdo();
                if (ccU.At()) {
                    fC(ccU.challengeId);
                    this.hvP = ccU.challengeId;
                }
                if (alaStartDirectChallengeResponseMessage.ccU().isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_TIMEOUT, alaStartDirectChallengeResponseMessage, base64, (String) null);
                }
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_SUCC, alaStartDirectChallengeResponseMessage, base64, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.huN != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.huN.bh(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.hvQ)), (String) null);
                return;
            }
            boolean ccW = alaCancelDirectChallengeResponseMessage.ccW();
            com.baidu.live.challenge.a ccU = alaCancelDirectChallengeResponseMessage.ccU();
            this.huN.b(ccW, alaCancelDirectChallengeResponseMessage.ccU());
            cdo();
            if (!ccW && ccU != null && ccU.At()) {
                fC(ccU.challengeId);
                this.hvP = ccU.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT_SUCC, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.hvQ)), (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.huN != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.huN.bi(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.huN.m(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.cde());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetQualifyingResultResponseMessage alaGetQualifyingResultResponseMessage) {
        if (this.huN != null && alaGetQualifyingResultResponseMessage != null) {
            if (alaGetQualifyingResultResponseMessage.hasError() || alaGetQualifyingResultResponseMessage.getError() != 0) {
                this.huN.bj(alaGetQualifyingResultResponseMessage.getError(), alaGetQualifyingResultResponseMessage.getErrorString());
            } else if (alaGetQualifyingResultResponseMessage.cdg()) {
                this.huN.k(alaGetQualifyingResultResponseMessage.cdf(), alaGetQualifyingResultResponseMessage.cdh());
            } else {
                this.huN.k(alaGetQualifyingResultResponseMessage.cdf(), -1L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.huN != null && alaAcceptDirectChallengeResponseMessage != null) {
            String str = "";
            String str2 = "";
            if (alaAcceptDirectChallengeResponseMessage.ccU() != null) {
                str2 = ExtraParamsManager.getBase64(String.valueOf(alaAcceptDirectChallengeResponseMessage.ccU().aFu));
            }
            if (alaAcceptDirectChallengeResponseMessage.ccU() != null) {
                str = alaAcceptDirectChallengeResponseMessage.ccU().aFs + "";
            }
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.huN.bk(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, alaAcceptDirectChallengeResponseMessage, str2, str);
                return;
            }
            boolean ccV = alaAcceptDirectChallengeResponseMessage.ccV();
            com.baidu.live.challenge.a ccU = alaAcceptDirectChallengeResponseMessage.ccU();
            this.huN.c(ccV, ccU);
            if (ccV && ccU != null) {
                fC(ccU.challengeId);
                this.hvP = ccU.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET_SUCC, alaAcceptDirectChallengeResponseMessage, str2, str);
        }
    }

    private void cdp() {
        this.hvY = false;
        MessageManager.getInstance().removeMessage(1021110, this.aCW);
        this.mHandler.removeCallbacks(this.hwd);
        this.hvV = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ob(boolean z) {
        this.hvY = true;
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
        if (this.huN != null) {
            this.hvY = false;
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() != 0) {
                if (this.huN != null) {
                    this.huN.bl(alaStartRandomChallengeResponseMessage.getError(), alaStartRandomChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, (String) null, (String) null);
                return;
            }
            if (alaStartRandomChallengeResponseMessage == null || alaStartRandomChallengeResponseMessage.ccU() == null) {
                str = null;
                str2 = null;
            } else {
                str2 = alaStartRandomChallengeResponseMessage.ccU().aFs + "";
                str = ExtraParamsManager.getBase64(alaStartRandomChallengeResponseMessage.ccU().aFu + "");
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.ccU() != null && alaStartRandomChallengeResponseMessage.ccU().isValid()) {
                com.baidu.live.challenge.a ccU = alaStartRandomChallengeResponseMessage.ccU();
                this.huN.c(ccU);
                if (ccU.At() && !AH()) {
                    cdp();
                    fC(ccU.challengeId);
                    this.hvP = ccU.challengeId;
                } else {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, str, str2);
                }
                if (ccU.isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOW_TIMEOUT, alaStartRandomChallengeResponseMessage, str, (String) null);
                }
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.ccU() != null && alaStartRandomChallengeResponseMessage.ccU().isValid()) {
                z = true;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM_SUCC, alaStartRandomChallengeResponseMessage, str, str2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        String str;
        String str2;
        if (this.huN != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage == null || alaCancelRandomChallengeResponseMessage.ccU() == null) {
                str = null;
                str2 = null;
            } else {
                str = alaCancelRandomChallengeResponseMessage.ccU().aFs + "";
                str2 = alaCancelRandomChallengeResponseMessage.ccU().challengeId + "";
            }
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.huN.bm(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, alaCancelRandomChallengeResponseMessage, str2, str);
                return;
            }
            boolean ccW = alaCancelRandomChallengeResponseMessage.ccW();
            com.baidu.live.challenge.a ccU = alaCancelRandomChallengeResponseMessage.ccU();
            this.huN.d(ccW, alaCancelRandomChallengeResponseMessage.ccU());
            cdp();
            if (!ccW && ccU != null && ccU.At()) {
                fC(ccU.challengeId);
                this.hvP = ccU.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCLE_RANDOM_SUCC, alaCancelRandomChallengeResponseMessage, str2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.huN != null && alaSurrenderResponseMessage != null) {
            this.huN.w(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.huN != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.huN.p(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.huN.a(alaGetTargetInfoResponseMessage.cdi());
            }
        }
    }

    public void bq(boolean z) {
        this.bOQ = z ? 1 : 2;
    }

    public void fC(long j) {
        this.hvT = true;
        this.hvP = j;
        this.mHandler.post(this.hwe);
    }

    private void cdq() {
        this.hvT = false;
        this.mHandler.removeCallbacks(this.hwe);
        this.hvX = false;
        MessageManager.getInstance().removeMessage(1021112, this.aCW);
    }

    public void cdr() {
        this.mHandler.removeCallbacks(this.hwe);
        this.hvX = false;
        MessageManager.getInstance().removeMessage(1021112, this.aCW);
    }

    public void cds() {
        this.mHandler.post(this.hwe);
    }

    private void a(bg bgVar, bk bkVar, bk bkVar2, long j) {
        if (bgVar == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info challenge meta is null?? logid=" + j);
        } else if (bkVar != null && bkVar.aOW != null && bkVar.aOW.getLiveID() != this.gpP) {
            BdLog.e("CHALLENGE_TAG in challenge not current live?? ||Challenge id=" + bgVar.challengeId + "||Challenge Status=" + bgVar.aOK + "||Net liveId=" + bkVar.aOW.getLiveID() + "||cur liveId=" + this.gpP + "||logid=" + j);
        } else {
            int i = bgVar.aOK;
            this.huN.b(i, bgVar, bkVar, bkVar2);
            switch (i) {
                case 2:
                    this.hvV = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    cdl();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913284));
                    break;
                case 3:
                    this.hvV = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.hvV = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.hvP = 0L;
                    cdm();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913283));
                    break;
            }
            if (bkVar != null && bkVar.aOI != null) {
                this.hvR = bkVar.aOI.userId;
            }
            if (bkVar2 != null && bkVar2.aOI != null) {
                this.hvS = bkVar2.aOI.userId;
            }
            if (4 == bgVar.aOK || 5 == bgVar.aOK) {
                cdq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.huN == null || alaGetChallengeInfoResponseMessage == null || alaGetChallengeInfoResponseMessage.ccY() == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info callback, response message, meta info  null?? ");
            if (alaGetChallengeInfoResponseMessage != null) {
                BdLog.e("CHALLENGE_TAG get Challenge Info error=" + alaGetChallengeInfoResponseMessage.getError());
                return;
            }
            return;
        }
        bg ccY = alaGetChallengeInfoResponseMessage.ccY();
        bk ccZ = alaGetChallengeInfoResponseMessage.ccZ();
        bk cda = alaGetChallengeInfoResponseMessage.cda();
        bc cdb = alaGetChallengeInfoResponseMessage.cdb();
        bi cdc = alaGetChallengeInfoResponseMessage.cdc();
        bj cdd = alaGetChallengeInfoResponseMessage.cdd();
        if (cdb != null && cdb.aOE > 0 && this.hvO != cdb.aOE) {
            this.hvO = cdb.aOE;
        }
        a(ccY, ccZ, cda, alaGetChallengeInfoResponseMessage.getLogId());
        int i = 0;
        if (com.baidu.live.ae.a.Qj().buX != null) {
            i = com.baidu.live.ae.a.Qj().buX.aMd;
        }
        if (i == 1 && ccY != null && ccZ != null && ccZ.aOW != null && ccZ.aOW.user_id == TbadkCoreApplication.getCurrentAccountId()) {
            if (this.hwa == null) {
                this.hwa = new HashMap();
            }
            long j = ccY.challengeId;
            if (cdd != null && cdd.aOV != null && !cdd.aOV.isEmpty() && (!this.hwa.containsKey(Long.valueOf(j)) || this.hwa.get(Long.valueOf(j)).isEmpty())) {
                this.hwa.put(Long.valueOf(j), cdd.aOV);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913209, cdd.aOV));
            }
            if (cdc != null && ccY.aOK >= 3 && ccY.challengeResult == 2) {
                if ((cdc.type == 1 || cdc.type == 3) && !TextUtils.isEmpty(cdc.aOT)) {
                    if (this.hwb == null) {
                        this.hwb = new HashMap();
                    }
                    if (!this.hwb.containsKey(Long.valueOf(j))) {
                        this.hwb.put(Long.valueOf(j), 0);
                    }
                    if (ccY.aOK == 3) {
                        int intValue = this.hwb.get(Long.valueOf(j)).intValue();
                        if (cdc.serverTime >= cdc.startTime && cdc.serverTime <= cdc.endTime) {
                            if (intValue < 1) {
                                this.hwb.put(Long.valueOf(j), 1);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913210, cdc.aOT));
                            }
                        } else if (cdc.serverTime > cdc.endTime && intValue < 2) {
                            this.hwb.put(Long.valueOf(j), 2);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                        }
                    } else if (ccY.aOK > 3) {
                        this.hwb.put(Long.valueOf(j), 2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                    }
                }
            }
        }
    }

    public ChallenfeInfoData.ChallengeStatus AG() {
        return this.hvV;
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
        return this.hvT;
    }
}
