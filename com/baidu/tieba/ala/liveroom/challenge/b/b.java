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
import com.baidu.live.data.ai;
import com.baidu.live.data.am;
import com.baidu.live.data.ao;
import com.baidu.live.data.ap;
import com.baidu.live.data.aq;
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
/* loaded from: classes3.dex */
public class b {
    private BdUniqueId aZD;
    private int blm;
    private a fYJ;
    private long fZD;
    private long fZE;
    private long fZF;
    private long fZG;
    private long fZH;
    private long fZI;
    private long fZJ;
    private long fZL;
    private ChallenfeInfoData.ChallengeStatus fZM;
    private i.f fZN;
    private int fZq;
    private long ffd;
    private boolean isHost;
    private TbPageContext mPageContext;
    private boolean fZK = false;
    private boolean fZO = false;
    private boolean fZP = false;
    private boolean fZQ = false;
    private HttpMessageListener blW = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.1
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
            }
        }
    };
    private HttpMessageListener aSM = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                b.this.fZO = false;
                b.this.b((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                b.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable fZT = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.fZQ) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.fZE);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, b.this.aZD);
            b.this.kO(false);
            b.this.mHandler.postDelayed(this, b.this.fZE);
        }
    };
    private Runnable fZU = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.4
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.fZP) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.fZD);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, b.this.aZD);
            b.this.kP(false);
            b.this.mHandler.postDelayed(this, b.this.fZD);
        }
    };
    private Runnable fZV = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.5
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.fZG <= 0) {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().removeMessage(1021112, b.this.aZD);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            if (b.this.fZO) {
                b.this.mHandler.postDelayed(this, b.this.fZF);
                return;
            }
            MessageManager.getInstance().removeMessage(1021112, b.this.aZD);
            if (b.this.fZN != null) {
                b.this.fZq = b.this.fZN.wa();
            }
            b.this.fZO = true;
            com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(b.this.fZG, b.this.blm, b.this.ffd, b.this.fZL, b.this.fZq);
            aVar.setTag(b.this.aZD);
            MessageManager.getInstance().sendMessage(aVar);
            if (b.this.isHost) {
                UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_REQ, UbcStatConstant.ContentType.UBC_TYPE_PK_CHALLENGE_INFO, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("avts_conn", b.this.blm);
                    jSONObject2.put("avts_fail", b.this.fZq);
                    jSONObject2.put("chat_id", b.this.fZG);
                    jSONObject.put("pk", jSONObject2);
                } catch (JSONException e) {
                }
                ubcStatisticItem.setContentExt(jSONObject);
                UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
            }
            b.this.mHandler.postDelayed(this, b.this.fZF);
        }
    };
    private Handler mHandler = new Handler();
    private Map<Long, List<Long>> fZR = new HashMap();
    private Map<Long, Integer> fZS = new HashMap();

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.live.challenge.b bVar, List<d> list);

        void a(d dVar);

        void aK(int i, String str);

        void aL(int i, String str);

        void aM(int i, String str);

        void aN(int i, String str);

        void aO(int i, String str);

        void aP(int i, String str);

        void aQ(int i, String str);

        void b(int i, am amVar, aq aqVar, aq aqVar2);

        void b(com.baidu.live.challenge.a aVar);

        void b(boolean z, com.baidu.live.challenge.a aVar);

        void bR(List<d> list);

        void c(com.baidu.live.challenge.a aVar);

        void c(boolean z, com.baidu.live.challenge.a aVar);

        void d(boolean z, com.baidu.live.challenge.a aVar);

        void j(int i, String str);

        void k(int i, String str);

        void l(int i, List<d> list);

        void m(boolean z, String str);

        void n(int i, String str);

        void n(boolean z, String str);

        void wb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        UbcStatisticItem ubcStatisticItem;
        if (alaGetChallengeInfoResponseMessage != null && this.isHost) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("avts_conn", this.blm);
                jSONObject2.put("avts_fail", this.fZq);
                if (alaGetChallengeInfoResponseMessage.bCG() != null) {
                    jSONObject2.put("chat_id", alaGetChallengeInfoResponseMessage.bCG().challengeId);
                    jSONObject2.put("chat_status", alaGetChallengeInfoResponseMessage.bCG().aBI);
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
        this.aZD = bdUniqueId;
        this.fZD = com.baidu.live.v.a.Hm().aZp.azQ > 0 ? com.baidu.live.v.a.Hm().aZp.azQ : 1000L;
        this.fZE = com.baidu.live.v.a.Hm().aZp.azR > 0 ? com.baidu.live.v.a.Hm().aZp.azR : 1000L;
        this.fZF = com.baidu.live.v.a.Hm().aZp.azS > 0 ? com.baidu.live.v.a.Hm().aZp.azS : 1000L;
        this.fZM = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        xp();
        registerListener();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public void e(long j, long j2) {
        this.ffd = j;
        this.fZL = j2;
    }

    public void a(a aVar) {
        this.fYJ = aVar;
    }

    public void b(i.f fVar) {
        this.fZN = fVar;
    }

    private void xp() {
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
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(1021183, this.blW);
        MessageManager.getInstance().registerListener(1021105, this.blW);
        MessageManager.getInstance().registerListener(1021182, this.blW);
        MessageManager.getInstance().registerListener(1021203, this.blW);
        MessageManager.getInstance().registerListener(1021106, this.blW);
        MessageManager.getInstance().registerListener(1021107, this.blW);
        MessageManager.getInstance().registerListener(1021108, this.blW);
        MessageManager.getInstance().registerListener(1021109, this.blW);
        MessageManager.getInstance().registerListener(1021110, this.blW);
        MessageManager.getInstance().registerListener(1021111, this.blW);
        MessageManager.getInstance().registerListener(1021115, this.blW);
        MessageManager.getInstance().registerListener(1021116, this.blW);
        MessageManager.getInstance().registerListener(1021197, this.blW);
        MessageManager.getInstance().registerListener(this.aSM);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.blW);
        MessageManager.getInstance().unRegisterListener(this.aSM);
    }

    private void bCQ() {
        MessageManager.getInstance().removeMessage(1021183, this.aZD);
        MessageManager.getInstance().removeMessage(1021105, this.aZD);
        MessageManager.getInstance().removeMessage(1021182, this.aZD);
        MessageManager.getInstance().removeMessage(1021203, this.aZD);
        MessageManager.getInstance().removeMessage(1021106, this.aZD);
        MessageManager.getInstance().removeMessage(1021107, this.aZD);
        MessageManager.getInstance().removeMessage(1021108, this.aZD);
        MessageManager.getInstance().removeMessage(1021109, this.aZD);
        MessageManager.getInstance().removeMessage(1021110, this.aZD);
        MessageManager.getInstance().removeMessage(1021111, this.aZD);
        MessageManager.getInstance().removeMessage(1021116, this.aZD);
    }

    private void bCR() {
        MessageManager.getInstance().removeMessage(1021112, this.aZD);
        MessageManager.getInstance().removeMessage(1021115, this.aZD);
    }

    private void reset() {
        this.fZG = 0L;
        this.fZH = 0L;
        this.blm = 0;
        this.fZq = 0;
        this.fZI = 0L;
        this.fZJ = 0L;
        bCU();
        bCT();
        bCV();
        this.mHandler.removeCallbacksAndMessages(null);
        bCQ();
        bCR();
    }

    public void bCS() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long vY() {
        return this.fZG;
    }

    public void vR() {
        HttpMessage httpMessage = new HttpMessage(1021183);
        httpMessage.setTag(this.aZD);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void t(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.aZD);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void e(int i, int i2, String str) {
        HttpMessage httpMessage = new HttpMessage(1021182);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.addParam("query_words", str);
        httpMessage.setTag(this.aZD);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void er(String str) {
        HttpMessage httpMessage = new HttpMessage(1021203);
        httpMessage.setTag(this.aZD);
        httpMessage.addParam("anchor_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void V(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.aZD);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void W(long j) {
        this.fZG = 0L;
        this.fZH = j;
        this.fZM = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        kO(true);
        this.mHandler.postDelayed(this.fZT, 1000L);
    }

    public void X(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.aZD);
        MessageManager.getInstance().sendMessage(httpMessage);
        dK(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void vS() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.aZD);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void Y(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.aZD);
        MessageManager.getInstance().sendMessage(httpMessage);
        dK(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void vT() {
        this.fZG = 0L;
        this.fZM = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        kP(true);
        this.mHandler.postDelayed(this.fZU, 1000L);
    }

    public void vU() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.aZD);
        MessageManager.getInstance().sendMessage(httpMessage);
        dK(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, null);
    }

    public void vX() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.fZG);
        httpMessage.setTag(this.aZD);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void vZ() {
        HttpMessage httpMessage = new HttpMessage(1021197);
        httpMessage.addParam("challenge_id", this.fZG);
        httpMessage.setTag(this.aZD);
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
        if (alaChallengeSwitchResponsedMessage != null && this.fYJ != null) {
            if (alaChallengeSwitchResponsedMessage.hasError() || alaChallengeSwitchResponsedMessage.getError() != 0) {
                this.fYJ.n(alaChallengeSwitchResponsedMessage.getError(), alaChallengeSwitchResponsedMessage.getErrorString());
            } else {
                this.fYJ.wb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.fYJ != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.fYJ.k(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.fYJ.a(alaGetTargetListResponseMessage.bCO(), alaGetTargetListResponseMessage.bCP());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSearchTargetListResponseMessage alaSearchTargetListResponseMessage) {
        if (this.fYJ != null && alaSearchTargetListResponseMessage != null) {
            if (alaSearchTargetListResponseMessage.hasError() || alaSearchTargetListResponseMessage.getError() != 0) {
                this.fYJ.k(alaSearchTargetListResponseMessage.getError(), alaSearchTargetListResponseMessage.getErrorString());
            } else {
                this.fYJ.a(alaSearchTargetListResponseMessage.bCO(), alaSearchTargetListResponseMessage.bCP());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeLatestListResponseMessage alaChallengeLatestListResponseMessage) {
        if (this.fYJ != null && alaChallengeLatestListResponseMessage != null) {
            if (alaChallengeLatestListResponseMessage.hasError() || alaChallengeLatestListResponseMessage.getError() != 0) {
                this.fYJ.aK(alaChallengeLatestListResponseMessage.getError(), alaChallengeLatestListResponseMessage.getErrorString());
            } else {
                this.fYJ.bR(alaChallengeLatestListResponseMessage.bCF());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CloseChallengeResponseMessage closeChallengeResponseMessage) {
        if (this.fYJ != null && closeChallengeResponseMessage != null) {
            this.fYJ.n(!closeChallengeResponseMessage.hasError() && closeChallengeResponseMessage.getError() == 0, closeChallengeResponseMessage.getErrorString());
        }
    }

    private void bCT() {
        this.fZQ = false;
        MessageManager.getInstance().removeMessage(1021106, this.aZD);
        this.mHandler.removeCallbacks(this.fZT);
        this.fZM = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kO(boolean z) {
        this.fZQ = true;
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.fZH);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.aZD);
        MessageManager.getInstance().sendMessage(httpMessage);
        dK(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, ExtraParamsManager.getBase64(String.valueOf(this.fZH)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.fYJ != null) {
            this.fZQ = false;
            String base64 = ExtraParamsManager.getBase64(String.valueOf(this.fZH));
            String str = "";
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.bCC() != null) {
                str = alaStartDirectChallengeResponseMessage.bCC().awe + "";
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() != 0) {
                if (this.fYJ != null) {
                    this.fYJ.aL(alaStartDirectChallengeResponseMessage.getError(), alaStartDirectChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, alaStartDirectChallengeResponseMessage, base64, str);
                return;
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() == 0 && alaStartDirectChallengeResponseMessage.bCC() != null && (alaStartDirectChallengeResponseMessage.bCC().isValid() || alaStartDirectChallengeResponseMessage.bCC().isTimeout())) {
                com.baidu.live.challenge.a bCC = alaStartDirectChallengeResponseMessage.bCC();
                this.fYJ.b(bCC);
                bCT();
                if (bCC.vJ()) {
                    dE(bCC.challengeId);
                    this.fZG = bCC.challengeId;
                }
                if (alaStartDirectChallengeResponseMessage.bCC().isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_TIMEOUT, alaStartDirectChallengeResponseMessage, base64, (String) null);
                }
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_SUCC, alaStartDirectChallengeResponseMessage, base64, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.fYJ != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.fYJ.aM(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.fZH)), (String) null);
                return;
            }
            boolean bCE = alaCancelDirectChallengeResponseMessage.bCE();
            com.baidu.live.challenge.a bCC = alaCancelDirectChallengeResponseMessage.bCC();
            this.fYJ.b(bCE, alaCancelDirectChallengeResponseMessage.bCC());
            bCT();
            if (!bCE && bCC != null && bCC.vJ()) {
                dE(bCC.challengeId);
                this.fZG = bCC.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT_SUCC, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.fZH)), (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.fYJ != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.fYJ.aN(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.fYJ.l(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.bCM());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.fYJ != null && alaAcceptDirectChallengeResponseMessage != null) {
            String str = "";
            String str2 = "";
            if (alaAcceptDirectChallengeResponseMessage.bCC() != null) {
                str2 = ExtraParamsManager.getBase64(String.valueOf(alaAcceptDirectChallengeResponseMessage.bCC().awg));
            }
            if (alaAcceptDirectChallengeResponseMessage.bCC() != null) {
                str = alaAcceptDirectChallengeResponseMessage.bCC().awe + "";
            }
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.fYJ.aO(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, alaAcceptDirectChallengeResponseMessage, str2, str);
                return;
            }
            boolean bCD = alaAcceptDirectChallengeResponseMessage.bCD();
            com.baidu.live.challenge.a bCC = alaAcceptDirectChallengeResponseMessage.bCC();
            this.fYJ.c(bCD, bCC);
            if (bCD && bCC != null) {
                dE(bCC.challengeId);
                this.fZG = bCC.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET_SUCC, alaAcceptDirectChallengeResponseMessage, str2, str);
        }
    }

    private void bCU() {
        this.fZP = false;
        MessageManager.getInstance().removeMessage(1021110, this.aZD);
        this.mHandler.removeCallbacks(this.fZU);
        this.fZM = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kP(boolean z) {
        this.fZP = true;
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.aZD);
        MessageManager.getInstance().sendMessage(httpMessage);
        dK(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        String str;
        String str2;
        boolean z = false;
        if (this.fYJ != null) {
            this.fZP = false;
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() != 0) {
                if (this.fYJ != null) {
                    this.fYJ.aP(alaStartRandomChallengeResponseMessage.getError(), alaStartRandomChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, (String) null, (String) null);
                return;
            }
            if (alaStartRandomChallengeResponseMessage == null || alaStartRandomChallengeResponseMessage.bCC() == null) {
                str = null;
                str2 = null;
            } else {
                str2 = alaStartRandomChallengeResponseMessage.bCC().awe + "";
                str = ExtraParamsManager.getBase64(alaStartRandomChallengeResponseMessage.bCC().awg + "");
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.bCC() != null && alaStartRandomChallengeResponseMessage.bCC().isValid()) {
                com.baidu.live.challenge.a bCC = alaStartRandomChallengeResponseMessage.bCC();
                this.fYJ.c(bCC);
                if (bCC.vJ() && !vW()) {
                    bCU();
                    dE(bCC.challengeId);
                    this.fZG = bCC.challengeId;
                } else {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, str, str2);
                }
                if (bCC.isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOW_TIMEOUT, alaStartRandomChallengeResponseMessage, str, (String) null);
                }
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.bCC() != null && alaStartRandomChallengeResponseMessage.bCC().isValid()) {
                z = true;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM_SUCC, alaStartRandomChallengeResponseMessage, str, str2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        String str;
        String str2 = null;
        if (this.fYJ != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage == null || alaCancelRandomChallengeResponseMessage.bCC() == null) {
                str = null;
            } else {
                str = alaCancelRandomChallengeResponseMessage.bCC().challengeId + "";
                str2 = alaCancelRandomChallengeResponseMessage.bCC().awe + "";
            }
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.fYJ.aQ(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, alaCancelRandomChallengeResponseMessage, str, str2);
                return;
            }
            boolean bCE = alaCancelRandomChallengeResponseMessage.bCE();
            com.baidu.live.challenge.a bCC = alaCancelRandomChallengeResponseMessage.bCC();
            this.fYJ.d(bCE, alaCancelRandomChallengeResponseMessage.bCC());
            bCU();
            if (!bCE && bCC != null && bCC.vJ()) {
                dE(bCC.challengeId);
                this.fZG = bCC.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCLE_RANDOM_SUCC, alaCancelRandomChallengeResponseMessage, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.fYJ != null && alaSurrenderResponseMessage != null) {
            this.fYJ.m(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.fYJ != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.fYJ.j(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.fYJ.a(alaGetTargetInfoResponseMessage.bCN());
            }
        }
    }

    public void aX(boolean z) {
        this.blm = z ? 1 : 2;
    }

    public void dE(long j) {
        this.fZK = true;
        this.fZG = j;
        this.mHandler.post(this.fZV);
    }

    private void bCV() {
        this.fZK = false;
        this.mHandler.removeCallbacks(this.fZV);
        this.fZO = false;
        MessageManager.getInstance().removeMessage(1021112, this.aZD);
    }

    public void bCW() {
        this.mHandler.removeCallbacks(this.fZV);
        this.fZO = false;
        MessageManager.getInstance().removeMessage(1021112, this.aZD);
    }

    public void bCX() {
        this.mHandler.post(this.fZV);
    }

    private void a(am amVar, aq aqVar, aq aqVar2, long j) {
        if (amVar == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info challenge meta is null?? logid=" + j);
        } else if (aqVar != null && aqVar.aBZ != null && aqVar.aBZ.getLiveID() != this.ffd) {
            BdLog.e("CHALLENGE_TAG in challenge not current live?? ||Challenge id=" + amVar.challengeId + "||Challenge Status=" + amVar.aBI + "||Net liveId=" + aqVar.aBZ.getLiveID() + "||cur liveId=" + this.ffd + "||logid=" + j);
        } else {
            int i = amVar.aBI;
            this.fYJ.b(i, amVar, aqVar, aqVar2);
            switch (i) {
                case 2:
                    this.fZM = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    bCQ();
                    break;
                case 3:
                    this.fZM = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.fZM = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.fZG = 0L;
                    bCR();
                    break;
            }
            if (aqVar != null && aqVar.aBG != null) {
                this.fZI = aqVar.aBG.userId;
            }
            if (aqVar2 != null && aqVar2.aBG != null) {
                this.fZJ = aqVar2.aBG.userId;
            }
            if (4 == amVar.aBI || 5 == amVar.aBI) {
                bCV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.fYJ == null || alaGetChallengeInfoResponseMessage == null || alaGetChallengeInfoResponseMessage.bCG() == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info callback, response message, meta info  null?? ");
            if (alaGetChallengeInfoResponseMessage != null) {
                BdLog.e("CHALLENGE_TAG get Challenge Info error=" + alaGetChallengeInfoResponseMessage.getError());
                return;
            }
            return;
        }
        am bCG = alaGetChallengeInfoResponseMessage.bCG();
        aq bCH = alaGetChallengeInfoResponseMessage.bCH();
        aq bCI = alaGetChallengeInfoResponseMessage.bCI();
        ai bCJ = alaGetChallengeInfoResponseMessage.bCJ();
        ao bCK = alaGetChallengeInfoResponseMessage.bCK();
        ap bCL = alaGetChallengeInfoResponseMessage.bCL();
        if (bCJ != null && bCJ.aBC > 0 && this.fZF != bCJ.aBC) {
            this.fZF = bCJ.aBC;
        }
        a(bCG, bCH, bCI, alaGetChallengeInfoResponseMessage.getLogId());
        int i = 0;
        if (com.baidu.live.v.a.Hm().aZp != null) {
            i = com.baidu.live.v.a.Hm().aZp.azY;
        }
        if (i == 1 && bCG != null && bCH != null && bCH.aBZ != null && bCH.aBZ.user_id == TbadkCoreApplication.getCurrentAccountId()) {
            if (this.fZR == null) {
                this.fZR = new HashMap();
            }
            long j = bCG.challengeId;
            if (bCL != null && bCL.aBY != null && !bCL.aBY.isEmpty() && (!this.fZR.containsKey(Long.valueOf(j)) || this.fZR.get(Long.valueOf(j)).isEmpty())) {
                this.fZR.put(Long.valueOf(j), bCL.aBY);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913209, bCL.aBY));
            }
            if (bCK != null && bCG.aBI >= 3 && bCG.challengeResult == 2) {
                if ((bCK.type == 1 || bCK.type == 3) && !TextUtils.isEmpty(bCK.aBW)) {
                    if (this.fZS == null) {
                        this.fZS = new HashMap();
                    }
                    if (!this.fZS.containsKey(Long.valueOf(j))) {
                        this.fZS.put(Long.valueOf(j), 0);
                    }
                    if (bCG.aBI == 3) {
                        int intValue = this.fZS.get(Long.valueOf(j)).intValue();
                        if (bCK.serverTime >= bCK.startTime && bCK.serverTime <= bCK.endTime) {
                            if (intValue < 1) {
                                this.fZS.put(Long.valueOf(j), 1);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913210, bCK.aBW));
                            }
                        } else if (bCK.serverTime > bCK.endTime && intValue < 2) {
                            this.fZS.put(Long.valueOf(j), 2);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                        }
                    } else if (bCG.aBI > 3) {
                        this.fZS.put(Long.valueOf(j), 2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                    }
                }
            }
        }
    }

    public ChallenfeInfoData.ChallengeStatus vV() {
        return this.fZM;
    }

    private void dK(String str, String str2) {
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

    public boolean vW() {
        return this.fZK;
    }
}
