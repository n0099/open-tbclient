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
import com.baidu.live.data.ay;
import com.baidu.live.data.bc;
import com.baidu.live.data.be;
import com.baidu.live.data.bf;
import com.baidu.live.data.bg;
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
/* loaded from: classes10.dex */
public class b {
    private int bLg;
    private BdUniqueId brL;
    private long gmS;
    private int hqW;
    private a hqp;
    private long hro;
    private long hrp;
    private long hrq;
    private long hrr;
    private long hrs;
    private long hrt;
    private long hru;
    private long hrw;
    private ChallenfeInfoData.ChallengeStatus hrx;
    private i.f hry;
    private boolean isHost;
    private TbPageContext mPageContext;
    private boolean hrv = false;
    private boolean hrz = false;
    private boolean hrA = false;
    private boolean hrB = false;
    private HttpMessageListener bMV = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.1
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
    private HttpMessageListener bhJ = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                b.this.hrz = false;
                if (!b.this.hqp.cbG()) {
                    b.this.b((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                    b.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                }
            }
        }
    };
    private Runnable hrE = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.hrB) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.hrp);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, b.this.brL);
            b.this.nP(false);
            b.this.mHandler.postDelayed(this, b.this.hrp);
        }
    };
    private Runnable hrF = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.4
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.hrA) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.hro);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, b.this.brL);
            b.this.nQ(false);
            b.this.mHandler.postDelayed(this, b.this.hro);
        }
    };
    private Runnable hrG = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.5
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.hrr <= 0) {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().removeMessage(1021112, b.this.brL);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            if (b.this.hrz) {
                b.this.mHandler.postDelayed(this, b.this.hrq);
                return;
            }
            MessageManager.getInstance().removeMessage(1021112, b.this.brL);
            if (b.this.hry != null) {
                b.this.hqW = b.this.hry.Ab();
            }
            b.this.hrz = true;
            com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(b.this.hrr, b.this.bLg, b.this.gmS, b.this.hrw, b.this.hqW);
            aVar.setTag(b.this.brL);
            MessageManager.getInstance().sendMessage(aVar);
            if (b.this.isHost) {
                UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_REQ, UbcStatConstant.ContentType.UBC_TYPE_PK_CHALLENGE_INFO, "author_liveroom", "");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("avts_conn", b.this.bLg);
                    jSONObject2.put("avts_fail", b.this.hqW);
                    jSONObject2.put("chat_id", b.this.hrr);
                    jSONObject.put("pk", jSONObject2);
                } catch (JSONException e) {
                }
                ubcStatisticItem.setContentExt(jSONObject);
                UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
            }
            b.this.mHandler.postDelayed(this, b.this.hrq);
        }
    };
    private Handler mHandler = new Handler();
    private Map<Long, List<Long>> hrC = new HashMap();
    private Map<Long, Integer> hrD = new HashMap();

    /* loaded from: classes10.dex */
    public interface a {
        void Ac();

        void a(com.baidu.live.challenge.b bVar, List<d> list);

        void a(d dVar);

        void b(int i, bc bcVar, bg bgVar, bg bgVar2);

        void b(com.baidu.live.challenge.a aVar);

        void b(boolean z, com.baidu.live.challenge.a aVar);

        void ba(int i, String str);

        void bb(int i, String str);

        void bc(int i, String str);

        void bd(int i, String str);

        void be(int i, String str);

        void bf(int i, String str);

        void bg(int i, String str);

        void bh(int i, String str);

        void c(com.baidu.live.challenge.a aVar);

        void c(boolean z, com.baidu.live.challenge.a aVar);

        void cH(List<d> list);

        boolean cbG();

        void d(boolean z, com.baidu.live.challenge.a aVar);

        void k(boolean z, long j);

        void l(int i, List<d> list);

        void m(int i, String str);

        void n(int i, String str);

        void p(boolean z, String str);

        void q(int i, String str);

        void q(boolean z, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        UbcStatisticItem ubcStatisticItem;
        if (alaGetChallengeInfoResponseMessage != null && this.isHost) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("avts_conn", this.bLg);
                jSONObject2.put("avts_fail", this.hqW);
                if (alaGetChallengeInfoResponseMessage.cbW() != null) {
                    jSONObject2.put("chat_id", alaGetChallengeInfoResponseMessage.cbW().challengeId);
                    jSONObject2.put(AlaRecorderLog.KEY_CHAT_STATUS, alaGetChallengeInfoResponseMessage.cbW().aLN);
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
        this.brL = bdUniqueId;
        this.hro = com.baidu.live.af.a.OJ().bru.aJl > 0 ? com.baidu.live.af.a.OJ().bru.aJl : 1000L;
        this.hrp = com.baidu.live.af.a.OJ().bru.aJm > 0 ? com.baidu.live.af.a.OJ().bru.aJm : 1000L;
        this.hrq = com.baidu.live.af.a.OJ().bru.aJn > 0 ? com.baidu.live.af.a.OJ().bru.aJn : 1000L;
        this.hrx = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        registerTask();
        registerListener();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public void h(long j, long j2) {
        this.gmS = j;
        this.hrw = j2;
    }

    public void a(a aVar) {
        this.hqp = aVar;
    }

    public void b(i.f fVar) {
        this.hry = fVar;
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
        MessageManager.getInstance().registerListener(1021183, this.bMV);
        MessageManager.getInstance().registerListener(1021105, this.bMV);
        MessageManager.getInstance().registerListener(1021182, this.bMV);
        MessageManager.getInstance().registerListener(1021203, this.bMV);
        MessageManager.getInstance().registerListener(1021106, this.bMV);
        MessageManager.getInstance().registerListener(1021107, this.bMV);
        MessageManager.getInstance().registerListener(1021108, this.bMV);
        MessageManager.getInstance().registerListener(1021109, this.bMV);
        MessageManager.getInstance().registerListener(1021110, this.bMV);
        MessageManager.getInstance().registerListener(1021111, this.bMV);
        MessageManager.getInstance().registerListener(1021115, this.bMV);
        MessageManager.getInstance().registerListener(1021116, this.bMV);
        MessageManager.getInstance().registerListener(1021197, this.bMV);
        MessageManager.getInstance().registerListener(this.bhJ);
        MessageManager.getInstance().registerListener(1021209, this.bMV);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bMV);
        MessageManager.getInstance().unRegisterListener(this.bhJ);
    }

    private void ccj() {
        MessageManager.getInstance().removeMessage(1021183, this.brL);
        MessageManager.getInstance().removeMessage(1021105, this.brL);
        MessageManager.getInstance().removeMessage(1021182, this.brL);
        MessageManager.getInstance().removeMessage(1021203, this.brL);
        MessageManager.getInstance().removeMessage(1021106, this.brL);
        MessageManager.getInstance().removeMessage(1021107, this.brL);
        MessageManager.getInstance().removeMessage(1021108, this.brL);
        MessageManager.getInstance().removeMessage(1021109, this.brL);
        MessageManager.getInstance().removeMessage(1021110, this.brL);
        MessageManager.getInstance().removeMessage(1021111, this.brL);
        MessageManager.getInstance().removeMessage(1021116, this.brL);
        MessageManager.getInstance().removeMessage(1021209, this.brL);
    }

    private void cck() {
        MessageManager.getInstance().removeMessage(1021112, this.brL);
        MessageManager.getInstance().removeMessage(1021115, this.brL);
    }

    private void reset() {
        this.hrr = 0L;
        this.hrs = 0L;
        this.bLg = 0;
        this.hqW = 0;
        this.hrt = 0L;
        this.hru = 0L;
        ccn();
        ccm();
        cco();
        this.mHandler.removeCallbacksAndMessages(null);
        ccj();
        cck();
    }

    public void ccl() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long zZ() {
        return this.hrr;
    }

    public void zS() {
        HttpMessage httpMessage = new HttpMessage(1021183);
        httpMessage.setTag(this.brL);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void GZ(String str) {
        HttpMessage httpMessage = new HttpMessage(1021209);
        httpMessage.addParam("user_id", str);
        httpMessage.setTag(this.brL);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void y(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.brL);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void g(int i, int i2, String str) {
        HttpMessage httpMessage = new HttpMessage(1021182);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.addParam("query_words", str);
        httpMessage.setTag(this.brL);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void eX(String str) {
        HttpMessage httpMessage = new HttpMessage(1021203);
        httpMessage.setTag(this.brL);
        httpMessage.addParam("anchor_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void aG(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.brL);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void aH(long j) {
        this.hrr = 0L;
        this.hrs = j;
        this.hrx = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        nP(true);
        this.mHandler.postDelayed(this.hrE, 1000L);
    }

    public void aI(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.brL);
        MessageManager.getInstance().sendMessage(httpMessage);
        ew(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void zT() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.brL);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void aJ(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.brL);
        MessageManager.getInstance().sendMessage(httpMessage);
        ew(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void zU() {
        this.hrr = 0L;
        this.hrx = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        nQ(true);
        this.mHandler.postDelayed(this.hrF, 1000L);
    }

    public void zV() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.brL);
        MessageManager.getInstance().sendMessage(httpMessage);
        ew(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, null);
    }

    public void zY() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.hrr);
        httpMessage.setTag(this.brL);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void Aa() {
        HttpMessage httpMessage = new HttpMessage(1021197);
        httpMessage.addParam("challenge_id", this.hrr);
        httpMessage.setTag(this.brL);
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
        if (alaChallengeSwitchResponsedMessage != null && this.hqp != null) {
            if (alaChallengeSwitchResponsedMessage.hasError() || alaChallengeSwitchResponsedMessage.getError() != 0) {
                this.hqp.q(alaChallengeSwitchResponsedMessage.getError(), alaChallengeSwitchResponsedMessage.getErrorString());
            } else {
                this.hqp.Ac();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.hqp != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.hqp.n(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.hqp.a(alaGetTargetListResponseMessage.cch(), alaGetTargetListResponseMessage.cci());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSearchTargetListResponseMessage alaSearchTargetListResponseMessage) {
        if (this.hqp != null && alaSearchTargetListResponseMessage != null) {
            if (alaSearchTargetListResponseMessage.hasError() || alaSearchTargetListResponseMessage.getError() != 0) {
                this.hqp.n(alaSearchTargetListResponseMessage.getError(), alaSearchTargetListResponseMessage.getErrorString());
            } else {
                this.hqp.a(alaSearchTargetListResponseMessage.cch(), alaSearchTargetListResponseMessage.cci());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeLatestListResponseMessage alaChallengeLatestListResponseMessage) {
        if (this.hqp != null && alaChallengeLatestListResponseMessage != null) {
            if (alaChallengeLatestListResponseMessage.hasError() || alaChallengeLatestListResponseMessage.getError() != 0) {
                this.hqp.ba(alaChallengeLatestListResponseMessage.getError(), alaChallengeLatestListResponseMessage.getErrorString());
            } else {
                this.hqp.cH(alaChallengeLatestListResponseMessage.cbV());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CloseChallengeResponseMessage closeChallengeResponseMessage) {
        if (this.hqp != null && closeChallengeResponseMessage != null) {
            boolean z = !closeChallengeResponseMessage.hasError() && closeChallengeResponseMessage.getError() == 0;
            this.hqp.q(z, closeChallengeResponseMessage.getErrorString());
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_CLOSE_RESULT, "author_liveroom", z ? "challenge_close_succ" : "challenge_close_fail"), closeChallengeResponseMessage, true);
        }
    }

    private void ccm() {
        this.hrB = false;
        MessageManager.getInstance().removeMessage(1021106, this.brL);
        this.mHandler.removeCallbacks(this.hrE);
        this.hrx = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nP(boolean z) {
        this.hrB = true;
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.hrs);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.brL);
        MessageManager.getInstance().sendMessage(httpMessage);
        ew(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, ExtraParamsManager.getBase64(String.valueOf(this.hrs)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.hqp != null) {
            this.hrB = false;
            String base64 = ExtraParamsManager.getBase64(String.valueOf(this.hrs));
            String str = "";
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.cbS() != null) {
                str = alaStartDirectChallengeResponseMessage.cbS().aDF + "";
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() != 0) {
                if (this.hqp != null) {
                    this.hqp.bb(alaStartDirectChallengeResponseMessage.getError(), alaStartDirectChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, alaStartDirectChallengeResponseMessage, base64, str);
                return;
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() == 0 && alaStartDirectChallengeResponseMessage.cbS() != null && (alaStartDirectChallengeResponseMessage.cbS().isValid() || alaStartDirectChallengeResponseMessage.cbS().isTimeout())) {
                com.baidu.live.challenge.a cbS = alaStartDirectChallengeResponseMessage.cbS();
                this.hqp.b(cbS);
                ccm();
                if (cbS.zJ()) {
                    fx(cbS.challengeId);
                    this.hrr = cbS.challengeId;
                }
                if (alaStartDirectChallengeResponseMessage.cbS().isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_TIMEOUT, alaStartDirectChallengeResponseMessage, base64, (String) null);
                }
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_SUCC, alaStartDirectChallengeResponseMessage, base64, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.hqp != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.hqp.bc(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.hrs)), (String) null);
                return;
            }
            boolean cbU = alaCancelDirectChallengeResponseMessage.cbU();
            com.baidu.live.challenge.a cbS = alaCancelDirectChallengeResponseMessage.cbS();
            this.hqp.b(cbU, alaCancelDirectChallengeResponseMessage.cbS());
            ccm();
            if (!cbU && cbS != null && cbS.zJ()) {
                fx(cbS.challengeId);
                this.hrr = cbS.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT_SUCC, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.hrs)), (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.hqp != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.hqp.bd(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.hqp.l(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.ccc());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetQualifyingResultResponseMessage alaGetQualifyingResultResponseMessage) {
        if (this.hqp != null && alaGetQualifyingResultResponseMessage != null) {
            if (alaGetQualifyingResultResponseMessage.hasError() || alaGetQualifyingResultResponseMessage.getError() != 0) {
                this.hqp.be(alaGetQualifyingResultResponseMessage.getError(), alaGetQualifyingResultResponseMessage.getErrorString());
            } else if (alaGetQualifyingResultResponseMessage.cce()) {
                this.hqp.k(alaGetQualifyingResultResponseMessage.ccd(), alaGetQualifyingResultResponseMessage.ccf());
            } else {
                this.hqp.k(alaGetQualifyingResultResponseMessage.ccd(), -1L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.hqp != null && alaAcceptDirectChallengeResponseMessage != null) {
            String str = "";
            String str2 = "";
            if (alaAcceptDirectChallengeResponseMessage.cbS() != null) {
                str2 = ExtraParamsManager.getBase64(String.valueOf(alaAcceptDirectChallengeResponseMessage.cbS().aDH));
            }
            if (alaAcceptDirectChallengeResponseMessage.cbS() != null) {
                str = alaAcceptDirectChallengeResponseMessage.cbS().aDF + "";
            }
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.hqp.bf(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, alaAcceptDirectChallengeResponseMessage, str2, str);
                return;
            }
            boolean cbT = alaAcceptDirectChallengeResponseMessage.cbT();
            com.baidu.live.challenge.a cbS = alaAcceptDirectChallengeResponseMessage.cbS();
            this.hqp.c(cbT, cbS);
            if (cbT && cbS != null) {
                fx(cbS.challengeId);
                this.hrr = cbS.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET_SUCC, alaAcceptDirectChallengeResponseMessage, str2, str);
        }
    }

    private void ccn() {
        this.hrA = false;
        MessageManager.getInstance().removeMessage(1021110, this.brL);
        this.mHandler.removeCallbacks(this.hrF);
        this.hrx = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nQ(boolean z) {
        this.hrA = true;
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.brL);
        MessageManager.getInstance().sendMessage(httpMessage);
        ew(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        String str;
        String str2;
        boolean z = false;
        if (this.hqp != null) {
            this.hrA = false;
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() != 0) {
                if (this.hqp != null) {
                    this.hqp.bg(alaStartRandomChallengeResponseMessage.getError(), alaStartRandomChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, (String) null, (String) null);
                return;
            }
            if (alaStartRandomChallengeResponseMessage == null || alaStartRandomChallengeResponseMessage.cbS() == null) {
                str = null;
                str2 = null;
            } else {
                str2 = alaStartRandomChallengeResponseMessage.cbS().aDF + "";
                str = ExtraParamsManager.getBase64(alaStartRandomChallengeResponseMessage.cbS().aDH + "");
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.cbS() != null && alaStartRandomChallengeResponseMessage.cbS().isValid()) {
                com.baidu.live.challenge.a cbS = alaStartRandomChallengeResponseMessage.cbS();
                this.hqp.c(cbS);
                if (cbS.zJ() && !zX()) {
                    ccn();
                    fx(cbS.challengeId);
                    this.hrr = cbS.challengeId;
                } else {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, str, str2);
                }
                if (cbS.isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOW_TIMEOUT, alaStartRandomChallengeResponseMessage, str, (String) null);
                }
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.cbS() != null && alaStartRandomChallengeResponseMessage.cbS().isValid()) {
                z = true;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM_SUCC, alaStartRandomChallengeResponseMessage, str, str2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        String str;
        String str2;
        if (this.hqp != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage == null || alaCancelRandomChallengeResponseMessage.cbS() == null) {
                str = null;
                str2 = null;
            } else {
                str = alaCancelRandomChallengeResponseMessage.cbS().aDF + "";
                str2 = alaCancelRandomChallengeResponseMessage.cbS().challengeId + "";
            }
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.hqp.bh(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, alaCancelRandomChallengeResponseMessage, str2, str);
                return;
            }
            boolean cbU = alaCancelRandomChallengeResponseMessage.cbU();
            com.baidu.live.challenge.a cbS = alaCancelRandomChallengeResponseMessage.cbS();
            this.hqp.d(cbU, alaCancelRandomChallengeResponseMessage.cbS());
            ccn();
            if (!cbU && cbS != null && cbS.zJ()) {
                fx(cbS.challengeId);
                this.hrr = cbS.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCLE_RANDOM_SUCC, alaCancelRandomChallengeResponseMessage, str2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.hqp != null && alaSurrenderResponseMessage != null) {
            this.hqp.p(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.hqp != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.hqp.m(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.hqp.a(alaGetTargetInfoResponseMessage.ccg());
            }
        }
    }

    public void bo(boolean z) {
        this.bLg = z ? 1 : 2;
    }

    public void fx(long j) {
        this.hrv = true;
        this.hrr = j;
        this.mHandler.post(this.hrG);
    }

    private void cco() {
        this.hrv = false;
        this.mHandler.removeCallbacks(this.hrG);
        this.hrz = false;
        MessageManager.getInstance().removeMessage(1021112, this.brL);
    }

    public void ccp() {
        this.mHandler.removeCallbacks(this.hrG);
        this.hrz = false;
        MessageManager.getInstance().removeMessage(1021112, this.brL);
    }

    public void ccq() {
        this.mHandler.post(this.hrG);
    }

    private void a(bc bcVar, bg bgVar, bg bgVar2, long j) {
        if (bcVar == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info challenge meta is null?? logid=" + j);
        } else if (bgVar != null && bgVar.aLZ != null && bgVar.aLZ.getLiveID() != this.gmS) {
            BdLog.e("CHALLENGE_TAG in challenge not current live?? ||Challenge id=" + bcVar.challengeId + "||Challenge Status=" + bcVar.aLN + "||Net liveId=" + bgVar.aLZ.getLiveID() + "||cur liveId=" + this.gmS + "||logid=" + j);
        } else {
            int i = bcVar.aLN;
            this.hqp.b(i, bcVar, bgVar, bgVar2);
            switch (i) {
                case 2:
                    this.hrx = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    ccj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913284));
                    break;
                case 3:
                    this.hrx = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.hrx = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.hrr = 0L;
                    cck();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913283));
                    break;
            }
            if (bgVar != null && bgVar.aLL != null) {
                this.hrt = bgVar.aLL.userId;
            }
            if (bgVar2 != null && bgVar2.aLL != null) {
                this.hru = bgVar2.aLL.userId;
            }
            if (4 == bcVar.aLN || 5 == bcVar.aLN) {
                cco();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.hqp == null || alaGetChallengeInfoResponseMessage == null || alaGetChallengeInfoResponseMessage.cbW() == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info callback, response message, meta info  null?? ");
            if (alaGetChallengeInfoResponseMessage != null) {
                BdLog.e("CHALLENGE_TAG get Challenge Info error=" + alaGetChallengeInfoResponseMessage.getError());
                return;
            }
            return;
        }
        bc cbW = alaGetChallengeInfoResponseMessage.cbW();
        bg cbX = alaGetChallengeInfoResponseMessage.cbX();
        bg cbY = alaGetChallengeInfoResponseMessage.cbY();
        ay cbZ = alaGetChallengeInfoResponseMessage.cbZ();
        be cca = alaGetChallengeInfoResponseMessage.cca();
        bf ccb = alaGetChallengeInfoResponseMessage.ccb();
        if (cbZ != null && cbZ.aLH > 0 && this.hrq != cbZ.aLH) {
            this.hrq = cbZ.aLH;
        }
        a(cbW, cbX, cbY, alaGetChallengeInfoResponseMessage.getLogId());
        int i = 0;
        if (com.baidu.live.af.a.OJ().bru != null) {
            i = com.baidu.live.af.a.OJ().bru.aJt;
        }
        if (i == 1 && cbW != null && cbX != null && cbX.aLZ != null && cbX.aLZ.user_id == TbadkCoreApplication.getCurrentAccountId()) {
            if (this.hrC == null) {
                this.hrC = new HashMap();
            }
            long j = cbW.challengeId;
            if (ccb != null && ccb.aLY != null && !ccb.aLY.isEmpty() && (!this.hrC.containsKey(Long.valueOf(j)) || this.hrC.get(Long.valueOf(j)).isEmpty())) {
                this.hrC.put(Long.valueOf(j), ccb.aLY);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913209, ccb.aLY));
            }
            if (cca != null && cbW.aLN >= 3 && cbW.challengeResult == 2) {
                if ((cca.type == 1 || cca.type == 3) && !TextUtils.isEmpty(cca.aLW)) {
                    if (this.hrD == null) {
                        this.hrD = new HashMap();
                    }
                    if (!this.hrD.containsKey(Long.valueOf(j))) {
                        this.hrD.put(Long.valueOf(j), 0);
                    }
                    if (cbW.aLN == 3) {
                        int intValue = this.hrD.get(Long.valueOf(j)).intValue();
                        if (cca.serverTime >= cca.startTime && cca.serverTime <= cca.endTime) {
                            if (intValue < 1) {
                                this.hrD.put(Long.valueOf(j), 1);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913210, cca.aLW));
                            }
                        } else if (cca.serverTime > cca.endTime && intValue < 2) {
                            this.hrD.put(Long.valueOf(j), 2);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                        }
                    } else if (cbW.aLN > 3) {
                        this.hrD.put(Long.valueOf(j), 2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                    }
                }
            }
        }
    }

    public ChallenfeInfoData.ChallengeStatus zW() {
        return this.hrx;
    }

    private void ew(String str, String str2) {
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

    public boolean zX() {
        return this.hrv;
    }
}
