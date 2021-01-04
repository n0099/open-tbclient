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
/* loaded from: classes11.dex */
public class b {
    private int bPS;
    private BdUniqueId bwz;
    private long grz;
    private a huV;
    private int hvC;
    private long hvU;
    private long hvV;
    private long hvW;
    private long hvX;
    private long hvY;
    private long hvZ;
    private long hwa;
    private long hwc;
    private ChallenfeInfoData.ChallengeStatus hwd;
    private i.f hwe;
    private boolean isHost;
    private TbPageContext mPageContext;
    private boolean hwb = false;
    private boolean hwf = false;
    private boolean hwg = false;
    private boolean hwh = false;
    private HttpMessageListener bRH = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.1
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
    private HttpMessageListener bmy = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                b.this.hwf = false;
                if (!b.this.huV.cfx()) {
                    b.this.b((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                    b.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                }
            }
        }
    };
    private Runnable hwk = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.hwh) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.hvV);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, b.this.bwz);
            b.this.nT(false);
            b.this.mHandler.postDelayed(this, b.this.hvV);
        }
    };
    private Runnable hwl = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.4
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.hwg) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.hvU);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, b.this.bwz);
            b.this.nU(false);
            b.this.mHandler.postDelayed(this, b.this.hvU);
        }
    };
    private Runnable hwm = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.5
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.hvX <= 0) {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().removeMessage(1021112, b.this.bwz);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            if (b.this.hwf) {
                b.this.mHandler.postDelayed(this, b.this.hvW);
                return;
            }
            MessageManager.getInstance().removeMessage(1021112, b.this.bwz);
            if (b.this.hwe != null) {
                b.this.hvC = b.this.hwe.DW();
            }
            b.this.hwf = true;
            com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(b.this.hvX, b.this.bPS, b.this.grz, b.this.hwc, b.this.hvC);
            aVar.setTag(b.this.bwz);
            MessageManager.getInstance().sendMessage(aVar);
            if (b.this.isHost) {
                UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_REQ, UbcStatConstant.ContentType.UBC_TYPE_PK_CHALLENGE_INFO, "author_liveroom", "");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("avts_conn", b.this.bPS);
                    jSONObject2.put("avts_fail", b.this.hvC);
                    jSONObject2.put("chat_id", b.this.hvX);
                    jSONObject.put("pk", jSONObject2);
                } catch (JSONException e) {
                }
                ubcStatisticItem.setContentExt(jSONObject);
                UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
            }
            b.this.mHandler.postDelayed(this, b.this.hvW);
        }
    };
    private Handler mHandler = new Handler();
    private Map<Long, List<Long>> hwi = new HashMap();
    private Map<Long, Integer> hwj = new HashMap();

    /* loaded from: classes11.dex */
    public interface a {
        void DX();

        void a(com.baidu.live.challenge.b bVar, List<d> list);

        void a(d dVar);

        void aZ(int i, String str);

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

        void c(com.baidu.live.challenge.a aVar);

        void c(boolean z, com.baidu.live.challenge.a aVar);

        void cH(List<d> list);

        boolean cfx();

        void d(boolean z, com.baidu.live.challenge.a aVar);

        void k(boolean z, long j);

        void l(int i, String str);

        void l(int i, List<d> list);

        void m(int i, String str);

        void p(int i, String str);

        void p(boolean z, String str);

        void q(boolean z, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        UbcStatisticItem ubcStatisticItem;
        if (alaGetChallengeInfoResponseMessage != null && this.isHost) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("avts_conn", this.bPS);
                jSONObject2.put("avts_fail", this.hvC);
                if (alaGetChallengeInfoResponseMessage.cfN() != null) {
                    jSONObject2.put("chat_id", alaGetChallengeInfoResponseMessage.cfN().challengeId);
                    jSONObject2.put(AlaRecorderLog.KEY_CHAT_STATUS, alaGetChallengeInfoResponseMessage.cfN().aQA);
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
        this.bwz = bdUniqueId;
        this.hvU = com.baidu.live.af.a.SE().bwi.aNY > 0 ? com.baidu.live.af.a.SE().bwi.aNY : 1000L;
        this.hvV = com.baidu.live.af.a.SE().bwi.aNZ > 0 ? com.baidu.live.af.a.SE().bwi.aNZ : 1000L;
        this.hvW = com.baidu.live.af.a.SE().bwi.aOa > 0 ? com.baidu.live.af.a.SE().bwi.aOa : 1000L;
        this.hwd = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        registerTask();
        registerListener();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public void h(long j, long j2) {
        this.grz = j;
        this.hwc = j2;
    }

    public void a(a aVar) {
        this.huV = aVar;
    }

    public void b(i.f fVar) {
        this.hwe = fVar;
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
        MessageManager.getInstance().registerListener(1021183, this.bRH);
        MessageManager.getInstance().registerListener(1021105, this.bRH);
        MessageManager.getInstance().registerListener(1021182, this.bRH);
        MessageManager.getInstance().registerListener(1021203, this.bRH);
        MessageManager.getInstance().registerListener(1021106, this.bRH);
        MessageManager.getInstance().registerListener(1021107, this.bRH);
        MessageManager.getInstance().registerListener(1021108, this.bRH);
        MessageManager.getInstance().registerListener(1021109, this.bRH);
        MessageManager.getInstance().registerListener(1021110, this.bRH);
        MessageManager.getInstance().registerListener(1021111, this.bRH);
        MessageManager.getInstance().registerListener(1021115, this.bRH);
        MessageManager.getInstance().registerListener(1021116, this.bRH);
        MessageManager.getInstance().registerListener(1021197, this.bRH);
        MessageManager.getInstance().registerListener(this.bmy);
        MessageManager.getInstance().registerListener(1021209, this.bRH);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bRH);
        MessageManager.getInstance().unRegisterListener(this.bmy);
    }

    private void cga() {
        MessageManager.getInstance().removeMessage(1021183, this.bwz);
        MessageManager.getInstance().removeMessage(1021105, this.bwz);
        MessageManager.getInstance().removeMessage(1021182, this.bwz);
        MessageManager.getInstance().removeMessage(1021203, this.bwz);
        MessageManager.getInstance().removeMessage(1021106, this.bwz);
        MessageManager.getInstance().removeMessage(1021107, this.bwz);
        MessageManager.getInstance().removeMessage(1021108, this.bwz);
        MessageManager.getInstance().removeMessage(1021109, this.bwz);
        MessageManager.getInstance().removeMessage(1021110, this.bwz);
        MessageManager.getInstance().removeMessage(1021111, this.bwz);
        MessageManager.getInstance().removeMessage(1021116, this.bwz);
        MessageManager.getInstance().removeMessage(1021209, this.bwz);
    }

    private void cgb() {
        MessageManager.getInstance().removeMessage(1021112, this.bwz);
        MessageManager.getInstance().removeMessage(1021115, this.bwz);
    }

    private void reset() {
        this.hvX = 0L;
        this.hvY = 0L;
        this.bPS = 0;
        this.hvC = 0;
        this.hvZ = 0L;
        this.hwa = 0L;
        cge();
        cgd();
        cgf();
        this.mHandler.removeCallbacksAndMessages(null);
        cga();
        cgb();
    }

    public void cgc() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long DU() {
        return this.hvX;
    }

    public void DN() {
        HttpMessage httpMessage = new HttpMessage(1021183);
        httpMessage.setTag(this.bwz);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void Il(String str) {
        HttpMessage httpMessage = new HttpMessage(1021209);
        httpMessage.addParam("user_id", str);
        httpMessage.setTag(this.bwz);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void y(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.bwz);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void g(int i, int i2, String str) {
        HttpMessage httpMessage = new HttpMessage(1021182);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.addParam("query_words", str);
        httpMessage.setTag(this.bwz);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void gi(String str) {
        HttpMessage httpMessage = new HttpMessage(1021203);
        httpMessage.setTag(this.bwz);
        httpMessage.addParam("anchor_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void aG(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.bwz);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void aH(long j) {
        this.hvX = 0L;
        this.hvY = j;
        this.hwd = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        nT(true);
        this.mHandler.postDelayed(this.hwk, 1000L);
    }

    public void aI(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.bwz);
        MessageManager.getInstance().sendMessage(httpMessage);
        ex(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void DO() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.bwz);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void aJ(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.bwz);
        MessageManager.getInstance().sendMessage(httpMessage);
        ex(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void DP() {
        this.hvX = 0L;
        this.hwd = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        nU(true);
        this.mHandler.postDelayed(this.hwl, 1000L);
    }

    public void DQ() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.bwz);
        MessageManager.getInstance().sendMessage(httpMessage);
        ex(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, null);
    }

    public void DT() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.hvX);
        httpMessage.setTag(this.bwz);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void DV() {
        HttpMessage httpMessage = new HttpMessage(1021197);
        httpMessage.addParam("challenge_id", this.hvX);
        httpMessage.setTag(this.bwz);
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
        if (alaChallengeSwitchResponsedMessage != null && this.huV != null) {
            if (alaChallengeSwitchResponsedMessage.hasError() || alaChallengeSwitchResponsedMessage.getError() != 0) {
                this.huV.p(alaChallengeSwitchResponsedMessage.getError(), alaChallengeSwitchResponsedMessage.getErrorString());
            } else {
                this.huV.DX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.huV != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.huV.m(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.huV.a(alaGetTargetListResponseMessage.cfY(), alaGetTargetListResponseMessage.cfZ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSearchTargetListResponseMessage alaSearchTargetListResponseMessage) {
        if (this.huV != null && alaSearchTargetListResponseMessage != null) {
            if (alaSearchTargetListResponseMessage.hasError() || alaSearchTargetListResponseMessage.getError() != 0) {
                this.huV.m(alaSearchTargetListResponseMessage.getError(), alaSearchTargetListResponseMessage.getErrorString());
            } else {
                this.huV.a(alaSearchTargetListResponseMessage.cfY(), alaSearchTargetListResponseMessage.cfZ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeLatestListResponseMessage alaChallengeLatestListResponseMessage) {
        if (this.huV != null && alaChallengeLatestListResponseMessage != null) {
            if (alaChallengeLatestListResponseMessage.hasError() || alaChallengeLatestListResponseMessage.getError() != 0) {
                this.huV.aZ(alaChallengeLatestListResponseMessage.getError(), alaChallengeLatestListResponseMessage.getErrorString());
            } else {
                this.huV.cH(alaChallengeLatestListResponseMessage.cfM());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CloseChallengeResponseMessage closeChallengeResponseMessage) {
        if (this.huV != null && closeChallengeResponseMessage != null) {
            boolean z = !closeChallengeResponseMessage.hasError() && closeChallengeResponseMessage.getError() == 0;
            this.huV.q(z, closeChallengeResponseMessage.getErrorString());
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_CLOSE_RESULT, "author_liveroom", z ? "challenge_close_succ" : "challenge_close_fail"), closeChallengeResponseMessage, true);
        }
    }

    private void cgd() {
        this.hwh = false;
        MessageManager.getInstance().removeMessage(1021106, this.bwz);
        this.mHandler.removeCallbacks(this.hwk);
        this.hwd = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nT(boolean z) {
        this.hwh = true;
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.hvY);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.bwz);
        MessageManager.getInstance().sendMessage(httpMessage);
        ex(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, ExtraParamsManager.getBase64(String.valueOf(this.hvY)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.huV != null) {
            this.hwh = false;
            String base64 = ExtraParamsManager.getBase64(String.valueOf(this.hvY));
            String str = "";
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.cfJ() != null) {
                str = alaStartDirectChallengeResponseMessage.cfJ().aIs + "";
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() != 0) {
                if (this.huV != null) {
                    this.huV.ba(alaStartDirectChallengeResponseMessage.getError(), alaStartDirectChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, alaStartDirectChallengeResponseMessage, base64, str);
                return;
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() == 0 && alaStartDirectChallengeResponseMessage.cfJ() != null && (alaStartDirectChallengeResponseMessage.cfJ().isValid() || alaStartDirectChallengeResponseMessage.cfJ().isTimeout())) {
                com.baidu.live.challenge.a cfJ = alaStartDirectChallengeResponseMessage.cfJ();
                this.huV.b(cfJ);
                cgd();
                if (cfJ.DE()) {
                    fx(cfJ.challengeId);
                    this.hvX = cfJ.challengeId;
                }
                if (alaStartDirectChallengeResponseMessage.cfJ().isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_TIMEOUT, alaStartDirectChallengeResponseMessage, base64, (String) null);
                }
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_SUCC, alaStartDirectChallengeResponseMessage, base64, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.huV != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.huV.bb(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.hvY)), (String) null);
                return;
            }
            boolean cfL = alaCancelDirectChallengeResponseMessage.cfL();
            com.baidu.live.challenge.a cfJ = alaCancelDirectChallengeResponseMessage.cfJ();
            this.huV.b(cfL, alaCancelDirectChallengeResponseMessage.cfJ());
            cgd();
            if (!cfL && cfJ != null && cfJ.DE()) {
                fx(cfJ.challengeId);
                this.hvX = cfJ.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT_SUCC, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.hvY)), (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.huV != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.huV.bc(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.huV.l(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.cfT());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetQualifyingResultResponseMessage alaGetQualifyingResultResponseMessage) {
        if (this.huV != null && alaGetQualifyingResultResponseMessage != null) {
            if (alaGetQualifyingResultResponseMessage.hasError() || alaGetQualifyingResultResponseMessage.getError() != 0) {
                this.huV.bd(alaGetQualifyingResultResponseMessage.getError(), alaGetQualifyingResultResponseMessage.getErrorString());
            } else if (alaGetQualifyingResultResponseMessage.cfV()) {
                this.huV.k(alaGetQualifyingResultResponseMessage.cfU(), alaGetQualifyingResultResponseMessage.cfW());
            } else {
                this.huV.k(alaGetQualifyingResultResponseMessage.cfU(), -1L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.huV != null && alaAcceptDirectChallengeResponseMessage != null) {
            String str = "";
            String str2 = "";
            if (alaAcceptDirectChallengeResponseMessage.cfJ() != null) {
                str2 = ExtraParamsManager.getBase64(String.valueOf(alaAcceptDirectChallengeResponseMessage.cfJ().aIu));
            }
            if (alaAcceptDirectChallengeResponseMessage.cfJ() != null) {
                str = alaAcceptDirectChallengeResponseMessage.cfJ().aIs + "";
            }
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.huV.be(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, alaAcceptDirectChallengeResponseMessage, str2, str);
                return;
            }
            boolean cfK = alaAcceptDirectChallengeResponseMessage.cfK();
            com.baidu.live.challenge.a cfJ = alaAcceptDirectChallengeResponseMessage.cfJ();
            this.huV.c(cfK, cfJ);
            if (cfK && cfJ != null) {
                fx(cfJ.challengeId);
                this.hvX = cfJ.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET_SUCC, alaAcceptDirectChallengeResponseMessage, str2, str);
        }
    }

    private void cge() {
        this.hwg = false;
        MessageManager.getInstance().removeMessage(1021110, this.bwz);
        this.mHandler.removeCallbacks(this.hwl);
        this.hwd = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nU(boolean z) {
        this.hwg = true;
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.bwz);
        MessageManager.getInstance().sendMessage(httpMessage);
        ex(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        String str;
        String str2;
        boolean z = false;
        if (this.huV != null) {
            this.hwg = false;
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() != 0) {
                if (this.huV != null) {
                    this.huV.bf(alaStartRandomChallengeResponseMessage.getError(), alaStartRandomChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, (String) null, (String) null);
                return;
            }
            if (alaStartRandomChallengeResponseMessage == null || alaStartRandomChallengeResponseMessage.cfJ() == null) {
                str = null;
                str2 = null;
            } else {
                str2 = alaStartRandomChallengeResponseMessage.cfJ().aIs + "";
                str = ExtraParamsManager.getBase64(alaStartRandomChallengeResponseMessage.cfJ().aIu + "");
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.cfJ() != null && alaStartRandomChallengeResponseMessage.cfJ().isValid()) {
                com.baidu.live.challenge.a cfJ = alaStartRandomChallengeResponseMessage.cfJ();
                this.huV.c(cfJ);
                if (cfJ.DE() && !DS()) {
                    cge();
                    fx(cfJ.challengeId);
                    this.hvX = cfJ.challengeId;
                } else {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, str, str2);
                }
                if (cfJ.isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOW_TIMEOUT, alaStartRandomChallengeResponseMessage, str, (String) null);
                }
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.cfJ() != null && alaStartRandomChallengeResponseMessage.cfJ().isValid()) {
                z = true;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM_SUCC, alaStartRandomChallengeResponseMessage, str, str2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        String str;
        String str2;
        if (this.huV != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage == null || alaCancelRandomChallengeResponseMessage.cfJ() == null) {
                str = null;
                str2 = null;
            } else {
                str = alaCancelRandomChallengeResponseMessage.cfJ().aIs + "";
                str2 = alaCancelRandomChallengeResponseMessage.cfJ().challengeId + "";
            }
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.huV.bg(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, alaCancelRandomChallengeResponseMessage, str2, str);
                return;
            }
            boolean cfL = alaCancelRandomChallengeResponseMessage.cfL();
            com.baidu.live.challenge.a cfJ = alaCancelRandomChallengeResponseMessage.cfJ();
            this.huV.d(cfL, alaCancelRandomChallengeResponseMessage.cfJ());
            cge();
            if (!cfL && cfJ != null && cfJ.DE()) {
                fx(cfJ.challengeId);
                this.hvX = cfJ.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCLE_RANDOM_SUCC, alaCancelRandomChallengeResponseMessage, str2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.huV != null && alaSurrenderResponseMessage != null) {
            this.huV.p(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.huV != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.huV.l(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.huV.a(alaGetTargetInfoResponseMessage.cfX());
            }
        }
    }

    public void bs(boolean z) {
        this.bPS = z ? 1 : 2;
    }

    public void fx(long j) {
        this.hwb = true;
        this.hvX = j;
        this.mHandler.post(this.hwm);
    }

    private void cgf() {
        this.hwb = false;
        this.mHandler.removeCallbacks(this.hwm);
        this.hwf = false;
        MessageManager.getInstance().removeMessage(1021112, this.bwz);
    }

    public void cgg() {
        this.mHandler.removeCallbacks(this.hwm);
        this.hwf = false;
        MessageManager.getInstance().removeMessage(1021112, this.bwz);
    }

    public void cgh() {
        this.mHandler.post(this.hwm);
    }

    private void a(bc bcVar, bg bgVar, bg bgVar2, long j) {
        if (bcVar == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info challenge meta is null?? logid=" + j);
        } else if (bgVar != null && bgVar.aQM != null && bgVar.aQM.getLiveID() != this.grz) {
            BdLog.e("CHALLENGE_TAG in challenge not current live?? ||Challenge id=" + bcVar.challengeId + "||Challenge Status=" + bcVar.aQA + "||Net liveId=" + bgVar.aQM.getLiveID() + "||cur liveId=" + this.grz + "||logid=" + j);
        } else {
            int i = bcVar.aQA;
            this.huV.b(i, bcVar, bgVar, bgVar2);
            switch (i) {
                case 2:
                    this.hwd = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    cga();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913284));
                    break;
                case 3:
                    this.hwd = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.hwd = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.hvX = 0L;
                    cgb();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913283));
                    break;
            }
            if (bgVar != null && bgVar.aQy != null) {
                this.hvZ = bgVar.aQy.userId;
            }
            if (bgVar2 != null && bgVar2.aQy != null) {
                this.hwa = bgVar2.aQy.userId;
            }
            if (4 == bcVar.aQA || 5 == bcVar.aQA) {
                cgf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.huV == null || alaGetChallengeInfoResponseMessage == null || alaGetChallengeInfoResponseMessage.cfN() == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info callback, response message, meta info  null?? ");
            if (alaGetChallengeInfoResponseMessage != null) {
                BdLog.e("CHALLENGE_TAG get Challenge Info error=" + alaGetChallengeInfoResponseMessage.getError());
                return;
            }
            return;
        }
        bc cfN = alaGetChallengeInfoResponseMessage.cfN();
        bg cfO = alaGetChallengeInfoResponseMessage.cfO();
        bg cfP = alaGetChallengeInfoResponseMessage.cfP();
        ay cfQ = alaGetChallengeInfoResponseMessage.cfQ();
        be cfR = alaGetChallengeInfoResponseMessage.cfR();
        bf cfS = alaGetChallengeInfoResponseMessage.cfS();
        if (cfQ != null && cfQ.aQu > 0 && this.hvW != cfQ.aQu) {
            this.hvW = cfQ.aQu;
        }
        a(cfN, cfO, cfP, alaGetChallengeInfoResponseMessage.getLogId());
        int i = 0;
        if (com.baidu.live.af.a.SE().bwi != null) {
            i = com.baidu.live.af.a.SE().bwi.aOg;
        }
        if (i == 1 && cfN != null && cfO != null && cfO.aQM != null && cfO.aQM.user_id == TbadkCoreApplication.getCurrentAccountId()) {
            if (this.hwi == null) {
                this.hwi = new HashMap();
            }
            long j = cfN.challengeId;
            if (cfS != null && cfS.aQL != null && !cfS.aQL.isEmpty() && (!this.hwi.containsKey(Long.valueOf(j)) || this.hwi.get(Long.valueOf(j)).isEmpty())) {
                this.hwi.put(Long.valueOf(j), cfS.aQL);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913209, cfS.aQL));
            }
            if (cfR != null && cfN.aQA >= 3 && cfN.challengeResult == 2) {
                if ((cfR.type == 1 || cfR.type == 3) && !TextUtils.isEmpty(cfR.aQJ)) {
                    if (this.hwj == null) {
                        this.hwj = new HashMap();
                    }
                    if (!this.hwj.containsKey(Long.valueOf(j))) {
                        this.hwj.put(Long.valueOf(j), 0);
                    }
                    if (cfN.aQA == 3) {
                        int intValue = this.hwj.get(Long.valueOf(j)).intValue();
                        if (cfR.serverTime >= cfR.startTime && cfR.serverTime <= cfR.endTime) {
                            if (intValue < 1) {
                                this.hwj.put(Long.valueOf(j), 1);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913210, cfR.aQJ));
                            }
                        } else if (cfR.serverTime > cfR.endTime && intValue < 2) {
                            this.hwj.put(Long.valueOf(j), 2);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                        }
                    } else if (cfN.aQA > 3) {
                        this.hwj.put(Long.valueOf(j), 2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                    }
                }
            }
        }
    }

    public ChallenfeInfoData.ChallengeStatus DR() {
        return this.hwd;
    }

    private void ex(String str, String str2) {
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

    public boolean DS() {
        return this.hwb;
    }
}
