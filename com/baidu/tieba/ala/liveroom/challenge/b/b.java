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
import com.baidu.live.data.al;
import com.baidu.live.data.ap;
import com.baidu.live.data.ar;
import com.baidu.live.data.as;
import com.baidu.live.data.at;
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
/* loaded from: classes7.dex */
public class b {
    private BdUniqueId beV;
    private int brm;
    private long fvC;
    private a gpZ;
    private int gqG;
    private long gqT;
    private long gqU;
    private long gqV;
    private long gqW;
    private long gqX;
    private long gqY;
    private long gqZ;
    private long grb;
    private ChallenfeInfoData.ChallengeStatus grc;
    private i.f grd;
    private boolean isHost;
    private TbPageContext mPageContext;
    private boolean gra = false;
    private boolean gre = false;
    private boolean grf = false;
    private boolean grg = false;
    private HttpMessageListener brW = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.1
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
    private HttpMessageListener aZu = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                b.this.gre = false;
                b.this.b((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                b.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable grj = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.grg) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.gqU);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, b.this.beV);
            b.this.lS(false);
            b.this.mHandler.postDelayed(this, b.this.gqU);
        }
    };
    private Runnable grk = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.4
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.grf) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.gqT);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, b.this.beV);
            b.this.lT(false);
            b.this.mHandler.postDelayed(this, b.this.gqT);
        }
    };
    private Runnable grl = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.5
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.gqW <= 0) {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().removeMessage(1021112, b.this.beV);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            if (b.this.gre) {
                b.this.mHandler.postDelayed(this, b.this.gqV);
                return;
            }
            MessageManager.getInstance().removeMessage(1021112, b.this.beV);
            if (b.this.grd != null) {
                b.this.gqG = b.this.grd.BU();
            }
            b.this.gre = true;
            com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(b.this.gqW, b.this.brm, b.this.fvC, b.this.grb, b.this.gqG);
            aVar.setTag(b.this.beV);
            MessageManager.getInstance().sendMessage(aVar);
            if (b.this.isHost) {
                UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_REQ, UbcStatConstant.ContentType.UBC_TYPE_PK_CHALLENGE_INFO, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("avts_conn", b.this.brm);
                    jSONObject2.put("avts_fail", b.this.gqG);
                    jSONObject2.put("chat_id", b.this.gqW);
                    jSONObject.put("pk", jSONObject2);
                } catch (JSONException e) {
                }
                ubcStatisticItem.setContentExt(jSONObject);
                UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
            }
            b.this.mHandler.postDelayed(this, b.this.gqV);
        }
    };
    private Handler mHandler = new Handler();
    private Map<Long, List<Long>> grh = new HashMap();
    private Map<Long, Integer> gri = new HashMap();

    /* loaded from: classes7.dex */
    public interface a {
        void BV();

        void a(com.baidu.live.challenge.b bVar, List<d> list);

        void a(d dVar);

        void aK(int i, String str);

        void aL(int i, String str);

        void aM(int i, String str);

        void aN(int i, String str);

        void aO(int i, String str);

        void aP(int i, String str);

        void aQ(int i, String str);

        void b(int i, ap apVar, at atVar, at atVar2);

        void b(com.baidu.live.challenge.a aVar);

        void b(boolean z, com.baidu.live.challenge.a aVar);

        void bW(List<d> list);

        void c(com.baidu.live.challenge.a aVar);

        void c(boolean z, com.baidu.live.challenge.a aVar);

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
                jSONObject2.put("avts_conn", this.brm);
                jSONObject2.put("avts_fail", this.gqG);
                if (alaGetChallengeInfoResponseMessage.bPx() != null) {
                    jSONObject2.put("chat_id", alaGetChallengeInfoResponseMessage.bPx().challengeId);
                    jSONObject2.put("chat_status", alaGetChallengeInfoResponseMessage.bPx().aIn);
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
        this.beV = bdUniqueId;
        this.gqT = com.baidu.live.w.a.Nk().beH.aGn > 0 ? com.baidu.live.w.a.Nk().beH.aGn : 1000L;
        this.gqU = com.baidu.live.w.a.Nk().beH.aGo > 0 ? com.baidu.live.w.a.Nk().beH.aGo : 1000L;
        this.gqV = com.baidu.live.w.a.Nk().beH.aGp > 0 ? com.baidu.live.w.a.Nk().beH.aGp : 1000L;
        this.grc = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        registerTask();
        registerListener();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public void e(long j, long j2) {
        this.fvC = j;
        this.grb = j2;
    }

    public void a(a aVar) {
        this.gpZ = aVar;
    }

    public void b(i.f fVar) {
        this.grd = fVar;
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
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(1021183, this.brW);
        MessageManager.getInstance().registerListener(1021105, this.brW);
        MessageManager.getInstance().registerListener(1021182, this.brW);
        MessageManager.getInstance().registerListener(1021203, this.brW);
        MessageManager.getInstance().registerListener(1021106, this.brW);
        MessageManager.getInstance().registerListener(1021107, this.brW);
        MessageManager.getInstance().registerListener(1021108, this.brW);
        MessageManager.getInstance().registerListener(1021109, this.brW);
        MessageManager.getInstance().registerListener(1021110, this.brW);
        MessageManager.getInstance().registerListener(1021111, this.brW);
        MessageManager.getInstance().registerListener(1021115, this.brW);
        MessageManager.getInstance().registerListener(1021116, this.brW);
        MessageManager.getInstance().registerListener(1021197, this.brW);
        MessageManager.getInstance().registerListener(this.aZu);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.brW);
        MessageManager.getInstance().unRegisterListener(this.aZu);
    }

    private void bPH() {
        MessageManager.getInstance().removeMessage(1021183, this.beV);
        MessageManager.getInstance().removeMessage(1021105, this.beV);
        MessageManager.getInstance().removeMessage(1021182, this.beV);
        MessageManager.getInstance().removeMessage(1021203, this.beV);
        MessageManager.getInstance().removeMessage(1021106, this.beV);
        MessageManager.getInstance().removeMessage(1021107, this.beV);
        MessageManager.getInstance().removeMessage(1021108, this.beV);
        MessageManager.getInstance().removeMessage(1021109, this.beV);
        MessageManager.getInstance().removeMessage(1021110, this.beV);
        MessageManager.getInstance().removeMessage(1021111, this.beV);
        MessageManager.getInstance().removeMessage(1021116, this.beV);
    }

    private void bPI() {
        MessageManager.getInstance().removeMessage(1021112, this.beV);
        MessageManager.getInstance().removeMessage(1021115, this.beV);
    }

    private void reset() {
        this.gqW = 0L;
        this.gqX = 0L;
        this.brm = 0;
        this.gqG = 0;
        this.gqY = 0L;
        this.gqZ = 0L;
        bPL();
        bPK();
        bPM();
        this.mHandler.removeCallbacksAndMessages(null);
        bPH();
        bPI();
    }

    public void bPJ() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long BS() {
        return this.gqW;
    }

    public void BL() {
        HttpMessage httpMessage = new HttpMessage(1021183);
        httpMessage.setTag(this.beV);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void w(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.beV);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void e(int i, int i2, String str) {
        HttpMessage httpMessage = new HttpMessage(1021182);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.addParam("query_words", str);
        httpMessage.setTag(this.beV);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void fJ(String str) {
        HttpMessage httpMessage = new HttpMessage(1021203);
        httpMessage.setTag(this.beV);
        httpMessage.addParam("anchor_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void W(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.beV);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void X(long j) {
        this.gqW = 0L;
        this.gqX = j;
        this.grc = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        lS(true);
        this.mHandler.postDelayed(this.grj, 1000L);
    }

    public void Y(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.beV);
        MessageManager.getInstance().sendMessage(httpMessage);
        eb(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void BM() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.beV);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void Z(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.beV);
        MessageManager.getInstance().sendMessage(httpMessage);
        eb(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void BN() {
        this.gqW = 0L;
        this.grc = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        lT(true);
        this.mHandler.postDelayed(this.grk, 1000L);
    }

    public void BO() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.beV);
        MessageManager.getInstance().sendMessage(httpMessage);
        eb(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, null);
    }

    public void BR() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.gqW);
        httpMessage.setTag(this.beV);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void BT() {
        HttpMessage httpMessage = new HttpMessage(1021197);
        httpMessage.addParam("challenge_id", this.gqW);
        httpMessage.setTag(this.beV);
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
        if (alaChallengeSwitchResponsedMessage != null && this.gpZ != null) {
            if (alaChallengeSwitchResponsedMessage.hasError() || alaChallengeSwitchResponsedMessage.getError() != 0) {
                this.gpZ.n(alaChallengeSwitchResponsedMessage.getError(), alaChallengeSwitchResponsedMessage.getErrorString());
            } else {
                this.gpZ.BV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.gpZ != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.gpZ.k(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.gpZ.a(alaGetTargetListResponseMessage.bPF(), alaGetTargetListResponseMessage.bPG());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSearchTargetListResponseMessage alaSearchTargetListResponseMessage) {
        if (this.gpZ != null && alaSearchTargetListResponseMessage != null) {
            if (alaSearchTargetListResponseMessage.hasError() || alaSearchTargetListResponseMessage.getError() != 0) {
                this.gpZ.k(alaSearchTargetListResponseMessage.getError(), alaSearchTargetListResponseMessage.getErrorString());
            } else {
                this.gpZ.a(alaSearchTargetListResponseMessage.bPF(), alaSearchTargetListResponseMessage.bPG());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeLatestListResponseMessage alaChallengeLatestListResponseMessage) {
        if (this.gpZ != null && alaChallengeLatestListResponseMessage != null) {
            if (alaChallengeLatestListResponseMessage.hasError() || alaChallengeLatestListResponseMessage.getError() != 0) {
                this.gpZ.aK(alaChallengeLatestListResponseMessage.getError(), alaChallengeLatestListResponseMessage.getErrorString());
            } else {
                this.gpZ.bW(alaChallengeLatestListResponseMessage.bPw());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CloseChallengeResponseMessage closeChallengeResponseMessage) {
        if (this.gpZ != null && closeChallengeResponseMessage != null) {
            this.gpZ.o(!closeChallengeResponseMessage.hasError() && closeChallengeResponseMessage.getError() == 0, closeChallengeResponseMessage.getErrorString());
        }
    }

    private void bPK() {
        this.grg = false;
        MessageManager.getInstance().removeMessage(1021106, this.beV);
        this.mHandler.removeCallbacks(this.grj);
        this.grc = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lS(boolean z) {
        this.grg = true;
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.gqX);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.beV);
        MessageManager.getInstance().sendMessage(httpMessage);
        eb(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, ExtraParamsManager.getBase64(String.valueOf(this.gqX)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.gpZ != null) {
            this.grg = false;
            String base64 = ExtraParamsManager.getBase64(String.valueOf(this.gqX));
            String str = "";
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.bPt() != null) {
                str = alaStartDirectChallengeResponseMessage.bPt().aCl + "";
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() != 0) {
                if (this.gpZ != null) {
                    this.gpZ.aL(alaStartDirectChallengeResponseMessage.getError(), alaStartDirectChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, alaStartDirectChallengeResponseMessage, base64, str);
                return;
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() == 0 && alaStartDirectChallengeResponseMessage.bPt() != null && (alaStartDirectChallengeResponseMessage.bPt().isValid() || alaStartDirectChallengeResponseMessage.bPt().isTimeout())) {
                com.baidu.live.challenge.a bPt = alaStartDirectChallengeResponseMessage.bPt();
                this.gpZ.b(bPt);
                bPK();
                if (bPt.BD()) {
                    ed(bPt.challengeId);
                    this.gqW = bPt.challengeId;
                }
                if (alaStartDirectChallengeResponseMessage.bPt().isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_TIMEOUT, alaStartDirectChallengeResponseMessage, base64, (String) null);
                }
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_SUCC, alaStartDirectChallengeResponseMessage, base64, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.gpZ != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.gpZ.aM(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.gqX)), (String) null);
                return;
            }
            boolean bPv = alaCancelDirectChallengeResponseMessage.bPv();
            com.baidu.live.challenge.a bPt = alaCancelDirectChallengeResponseMessage.bPt();
            this.gpZ.b(bPv, alaCancelDirectChallengeResponseMessage.bPt());
            bPK();
            if (!bPv && bPt != null && bPt.BD()) {
                ed(bPt.challengeId);
                this.gqW = bPt.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT_SUCC, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.gqX)), (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.gpZ != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.gpZ.aN(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.gpZ.l(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.bPD());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.gpZ != null && alaAcceptDirectChallengeResponseMessage != null) {
            String str = "";
            String str2 = "";
            if (alaAcceptDirectChallengeResponseMessage.bPt() != null) {
                str2 = ExtraParamsManager.getBase64(String.valueOf(alaAcceptDirectChallengeResponseMessage.bPt().aCn));
            }
            if (alaAcceptDirectChallengeResponseMessage.bPt() != null) {
                str = alaAcceptDirectChallengeResponseMessage.bPt().aCl + "";
            }
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.gpZ.aO(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, alaAcceptDirectChallengeResponseMessage, str2, str);
                return;
            }
            boolean bPu = alaAcceptDirectChallengeResponseMessage.bPu();
            com.baidu.live.challenge.a bPt = alaAcceptDirectChallengeResponseMessage.bPt();
            this.gpZ.c(bPu, bPt);
            if (bPu && bPt != null) {
                ed(bPt.challengeId);
                this.gqW = bPt.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET_SUCC, alaAcceptDirectChallengeResponseMessage, str2, str);
        }
    }

    private void bPL() {
        this.grf = false;
        MessageManager.getInstance().removeMessage(1021110, this.beV);
        this.mHandler.removeCallbacks(this.grk);
        this.grc = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lT(boolean z) {
        this.grf = true;
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.beV);
        MessageManager.getInstance().sendMessage(httpMessage);
        eb(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        String str;
        String str2;
        boolean z = false;
        if (this.gpZ != null) {
            this.grf = false;
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() != 0) {
                if (this.gpZ != null) {
                    this.gpZ.aP(alaStartRandomChallengeResponseMessage.getError(), alaStartRandomChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, (String) null, (String) null);
                return;
            }
            if (alaStartRandomChallengeResponseMessage == null || alaStartRandomChallengeResponseMessage.bPt() == null) {
                str = null;
                str2 = null;
            } else {
                str2 = alaStartRandomChallengeResponseMessage.bPt().aCl + "";
                str = ExtraParamsManager.getBase64(alaStartRandomChallengeResponseMessage.bPt().aCn + "");
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.bPt() != null && alaStartRandomChallengeResponseMessage.bPt().isValid()) {
                com.baidu.live.challenge.a bPt = alaStartRandomChallengeResponseMessage.bPt();
                this.gpZ.c(bPt);
                if (bPt.BD() && !BQ()) {
                    bPL();
                    ed(bPt.challengeId);
                    this.gqW = bPt.challengeId;
                } else {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, str, str2);
                }
                if (bPt.isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOW_TIMEOUT, alaStartRandomChallengeResponseMessage, str, (String) null);
                }
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.bPt() != null && alaStartRandomChallengeResponseMessage.bPt().isValid()) {
                z = true;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM_SUCC, alaStartRandomChallengeResponseMessage, str, str2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        String str;
        String str2 = null;
        if (this.gpZ != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage == null || alaCancelRandomChallengeResponseMessage.bPt() == null) {
                str = null;
            } else {
                str = alaCancelRandomChallengeResponseMessage.bPt().challengeId + "";
                str2 = alaCancelRandomChallengeResponseMessage.bPt().aCl + "";
            }
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.gpZ.aQ(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, alaCancelRandomChallengeResponseMessage, str, str2);
                return;
            }
            boolean bPv = alaCancelRandomChallengeResponseMessage.bPv();
            com.baidu.live.challenge.a bPt = alaCancelRandomChallengeResponseMessage.bPt();
            this.gpZ.d(bPv, alaCancelRandomChallengeResponseMessage.bPt());
            bPL();
            if (!bPv && bPt != null && bPt.BD()) {
                ed(bPt.challengeId);
                this.gqW = bPt.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCLE_RANDOM_SUCC, alaCancelRandomChallengeResponseMessage, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.gpZ != null && alaSurrenderResponseMessage != null) {
            this.gpZ.n(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.gpZ != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.gpZ.j(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.gpZ.a(alaGetTargetInfoResponseMessage.bPE());
            }
        }
    }

    public void bf(boolean z) {
        this.brm = z ? 1 : 2;
    }

    public void ed(long j) {
        this.gra = true;
        this.gqW = j;
        this.mHandler.post(this.grl);
    }

    private void bPM() {
        this.gra = false;
        this.mHandler.removeCallbacks(this.grl);
        this.gre = false;
        MessageManager.getInstance().removeMessage(1021112, this.beV);
    }

    public void bPN() {
        this.mHandler.removeCallbacks(this.grl);
        this.gre = false;
        MessageManager.getInstance().removeMessage(1021112, this.beV);
    }

    public void bPO() {
        this.mHandler.post(this.grl);
    }

    private void a(ap apVar, at atVar, at atVar2, long j) {
        if (apVar == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info challenge meta is null?? logid=" + j);
        } else if (atVar != null && atVar.aIE != null && atVar.aIE.getLiveID() != this.fvC) {
            BdLog.e("CHALLENGE_TAG in challenge not current live?? ||Challenge id=" + apVar.challengeId + "||Challenge Status=" + apVar.aIn + "||Net liveId=" + atVar.aIE.getLiveID() + "||cur liveId=" + this.fvC + "||logid=" + j);
        } else {
            int i = apVar.aIn;
            this.gpZ.b(i, apVar, atVar, atVar2);
            switch (i) {
                case 2:
                    this.grc = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    bPH();
                    break;
                case 3:
                    this.grc = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.grc = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.gqW = 0L;
                    bPI();
                    break;
            }
            if (atVar != null && atVar.aIl != null) {
                this.gqY = atVar.aIl.userId;
            }
            if (atVar2 != null && atVar2.aIl != null) {
                this.gqZ = atVar2.aIl.userId;
            }
            if (4 == apVar.aIn || 5 == apVar.aIn) {
                bPM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.gpZ == null || alaGetChallengeInfoResponseMessage == null || alaGetChallengeInfoResponseMessage.bPx() == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info callback, response message, meta info  null?? ");
            if (alaGetChallengeInfoResponseMessage != null) {
                BdLog.e("CHALLENGE_TAG get Challenge Info error=" + alaGetChallengeInfoResponseMessage.getError());
                return;
            }
            return;
        }
        ap bPx = alaGetChallengeInfoResponseMessage.bPx();
        at bPy = alaGetChallengeInfoResponseMessage.bPy();
        at bPz = alaGetChallengeInfoResponseMessage.bPz();
        al bPA = alaGetChallengeInfoResponseMessage.bPA();
        ar bPB = alaGetChallengeInfoResponseMessage.bPB();
        as bPC = alaGetChallengeInfoResponseMessage.bPC();
        if (bPA != null && bPA.aIh > 0 && this.gqV != bPA.aIh) {
            this.gqV = bPA.aIh;
        }
        a(bPx, bPy, bPz, alaGetChallengeInfoResponseMessage.getLogId());
        int i = 0;
        if (com.baidu.live.w.a.Nk().beH != null) {
            i = com.baidu.live.w.a.Nk().beH.aGv;
        }
        if (i == 1 && bPx != null && bPy != null && bPy.aIE != null && bPy.aIE.user_id == TbadkCoreApplication.getCurrentAccountId()) {
            if (this.grh == null) {
                this.grh = new HashMap();
            }
            long j = bPx.challengeId;
            if (bPC != null && bPC.aID != null && !bPC.aID.isEmpty() && (!this.grh.containsKey(Long.valueOf(j)) || this.grh.get(Long.valueOf(j)).isEmpty())) {
                this.grh.put(Long.valueOf(j), bPC.aID);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913209, bPC.aID));
            }
            if (bPB != null && bPx.aIn >= 3 && bPx.challengeResult == 2) {
                if ((bPB.type == 1 || bPB.type == 3) && !TextUtils.isEmpty(bPB.aIB)) {
                    if (this.gri == null) {
                        this.gri = new HashMap();
                    }
                    if (!this.gri.containsKey(Long.valueOf(j))) {
                        this.gri.put(Long.valueOf(j), 0);
                    }
                    if (bPx.aIn == 3) {
                        int intValue = this.gri.get(Long.valueOf(j)).intValue();
                        if (bPB.serverTime >= bPB.startTime && bPB.serverTime <= bPB.endTime) {
                            if (intValue < 1) {
                                this.gri.put(Long.valueOf(j), 1);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913210, bPB.aIB));
                            }
                        } else if (bPB.serverTime > bPB.endTime && intValue < 2) {
                            this.gri.put(Long.valueOf(j), 2);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                        }
                    } else if (bPx.aIn > 3) {
                        this.gri.put(Long.valueOf(j), 2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                    }
                }
            }
        }
    }

    public ChallenfeInfoData.ChallengeStatus BP() {
        return this.grc;
    }

    private void eb(String str, String str2) {
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

    public boolean BQ() {
        return this.gra;
    }
}
