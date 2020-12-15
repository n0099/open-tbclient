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
import com.baidu.live.data.aw;
import com.baidu.live.data.ba;
import com.baidu.live.data.bc;
import com.baidu.live.data.bd;
import com.baidu.live.data.be;
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
    private int bLf;
    private BdUniqueId brR;
    private long ghb;
    private int hjH;
    private long hjZ;
    private a hja;
    private long hka;
    private long hkb;
    private long hkc;
    private long hkd;
    private long hke;
    private long hkf;
    private long hkh;
    private ChallenfeInfoData.ChallengeStatus hki;
    private i.f hkj;
    private boolean isHost;
    private TbPageContext mPageContext;
    private boolean hkg = false;
    private boolean hkk = false;
    private boolean hkl = false;
    private boolean hkm = false;
    private HttpMessageListener bMU = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.1
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
    private HttpMessageListener bkS = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                b.this.hkk = false;
                if (!b.this.hja.ccH()) {
                    b.this.b((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                    b.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                }
            }
        }
    };
    private Runnable hkp = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.hkm) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.hka);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, b.this.brR);
            b.this.nt(false);
            b.this.mHandler.postDelayed(this, b.this.hka);
        }
    };
    private Runnable hkq = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.4
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.hkl) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.hjZ);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, b.this.brR);
            b.this.nu(false);
            b.this.mHandler.postDelayed(this, b.this.hjZ);
        }
    };
    private Runnable hkr = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.5
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.hkc <= 0) {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().removeMessage(1021112, b.this.brR);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            if (b.this.hkk) {
                b.this.mHandler.postDelayed(this, b.this.hkb);
                return;
            }
            MessageManager.getInstance().removeMessage(1021112, b.this.brR);
            if (b.this.hkj != null) {
                b.this.hjH = b.this.hkj.EH();
            }
            b.this.hkk = true;
            com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(b.this.hkc, b.this.bLf, b.this.ghb, b.this.hkh, b.this.hjH);
            aVar.setTag(b.this.brR);
            MessageManager.getInstance().sendMessage(aVar);
            if (b.this.isHost) {
                UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_REQ, UbcStatConstant.ContentType.UBC_TYPE_PK_CHALLENGE_INFO, "author_liveroom", "");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("avts_conn", b.this.bLf);
                    jSONObject2.put("avts_fail", b.this.hjH);
                    jSONObject2.put("chat_id", b.this.hkc);
                    jSONObject.put("pk", jSONObject2);
                } catch (JSONException e) {
                }
                ubcStatisticItem.setContentExt(jSONObject);
                UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
            }
            b.this.mHandler.postDelayed(this, b.this.hkb);
        }
    };
    private Handler mHandler = new Handler();
    private Map<Long, List<Long>> hkn = new HashMap();
    private Map<Long, Integer> hko = new HashMap();

    /* loaded from: classes4.dex */
    public interface a {
        void EI();

        void a(com.baidu.live.challenge.b bVar, List<d> list);

        void a(d dVar);

        void aX(int i, String str);

        void aY(int i, String str);

        void aZ(int i, String str);

        void b(int i, ba baVar, be beVar, be beVar2);

        void b(com.baidu.live.challenge.a aVar);

        void b(boolean z, com.baidu.live.challenge.a aVar);

        void ba(int i, String str);

        void bb(int i, String str);

        void bc(int i, String str);

        void bd(int i, String str);

        void be(int i, String str);

        void c(com.baidu.live.challenge.a aVar);

        void c(boolean z, com.baidu.live.challenge.a aVar);

        void cA(List<d> list);

        boolean ccH();

        void d(boolean z, long j);

        void d(boolean z, com.baidu.live.challenge.a aVar);

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
                jSONObject2.put("avts_conn", this.bLf);
                jSONObject2.put("avts_fail", this.hjH);
                if (alaGetChallengeInfoResponseMessage.ccX() != null) {
                    jSONObject2.put("chat_id", alaGetChallengeInfoResponseMessage.ccX().challengeId);
                    jSONObject2.put(AlaRecorderLog.KEY_CHAT_STATUS, alaGetChallengeInfoResponseMessage.ccX().aPL);
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
        this.brR = bdUniqueId;
        this.hjZ = com.baidu.live.ae.a.RB().brA.aNu > 0 ? com.baidu.live.ae.a.RB().brA.aNu : 1000L;
        this.hka = com.baidu.live.ae.a.RB().brA.aNv > 0 ? com.baidu.live.ae.a.RB().brA.aNv : 1000L;
        this.hkb = com.baidu.live.ae.a.RB().brA.aNw > 0 ? com.baidu.live.ae.a.RB().brA.aNw : 1000L;
        this.hki = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        registerTask();
        registerListener();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public void e(long j, long j2) {
        this.ghb = j;
        this.hkh = j2;
    }

    public void a(a aVar) {
        this.hja = aVar;
    }

    public void b(i.f fVar) {
        this.hkj = fVar;
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
        MessageManager.getInstance().registerListener(1021183, this.bMU);
        MessageManager.getInstance().registerListener(1021105, this.bMU);
        MessageManager.getInstance().registerListener(1021182, this.bMU);
        MessageManager.getInstance().registerListener(1021203, this.bMU);
        MessageManager.getInstance().registerListener(1021106, this.bMU);
        MessageManager.getInstance().registerListener(1021107, this.bMU);
        MessageManager.getInstance().registerListener(1021108, this.bMU);
        MessageManager.getInstance().registerListener(1021109, this.bMU);
        MessageManager.getInstance().registerListener(1021110, this.bMU);
        MessageManager.getInstance().registerListener(1021111, this.bMU);
        MessageManager.getInstance().registerListener(1021115, this.bMU);
        MessageManager.getInstance().registerListener(1021116, this.bMU);
        MessageManager.getInstance().registerListener(1021197, this.bMU);
        MessageManager.getInstance().registerListener(this.bkS);
        MessageManager.getInstance().registerListener(1021209, this.bMU);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bMU);
        MessageManager.getInstance().unRegisterListener(this.bkS);
    }

    private void cdk() {
        MessageManager.getInstance().removeMessage(1021183, this.brR);
        MessageManager.getInstance().removeMessage(1021105, this.brR);
        MessageManager.getInstance().removeMessage(1021182, this.brR);
        MessageManager.getInstance().removeMessage(1021203, this.brR);
        MessageManager.getInstance().removeMessage(1021106, this.brR);
        MessageManager.getInstance().removeMessage(1021107, this.brR);
        MessageManager.getInstance().removeMessage(1021108, this.brR);
        MessageManager.getInstance().removeMessage(1021109, this.brR);
        MessageManager.getInstance().removeMessage(1021110, this.brR);
        MessageManager.getInstance().removeMessage(1021111, this.brR);
        MessageManager.getInstance().removeMessage(1021116, this.brR);
        MessageManager.getInstance().removeMessage(1021209, this.brR);
    }

    private void cdl() {
        MessageManager.getInstance().removeMessage(1021112, this.brR);
        MessageManager.getInstance().removeMessage(1021115, this.brR);
    }

    private void reset() {
        this.hkc = 0L;
        this.hkd = 0L;
        this.bLf = 0;
        this.hjH = 0;
        this.hke = 0L;
        this.hkf = 0L;
        cdo();
        cdn();
        cdp();
        this.mHandler.removeCallbacksAndMessages(null);
        cdk();
        cdl();
    }

    public void cdm() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long EF() {
        return this.hkc;
    }

    public void Ey() {
        HttpMessage httpMessage = new HttpMessage(1021183);
        httpMessage.setTag(this.brR);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void Ij(String str) {
        HttpMessage httpMessage = new HttpMessage(1021209);
        httpMessage.addParam("user_id", str);
        httpMessage.setTag(this.brR);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void y(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.brR);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void g(int i, int i2, String str) {
        HttpMessage httpMessage = new HttpMessage(1021182);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.addParam("query_words", str);
        httpMessage.setTag(this.brR);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void gz(String str) {
        HttpMessage httpMessage = new HttpMessage(1021203);
        httpMessage.setTag(this.brR);
        httpMessage.addParam("anchor_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void aH(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.brR);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void aI(long j) {
        this.hkc = 0L;
        this.hkd = j;
        this.hki = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        nt(true);
        this.mHandler.postDelayed(this.hkp, 1000L);
    }

    public void aJ(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.brR);
        MessageManager.getInstance().sendMessage(httpMessage);
        ey(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void Ez() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.brR);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void aK(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.brR);
        MessageManager.getInstance().sendMessage(httpMessage);
        ey(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void EA() {
        this.hkc = 0L;
        this.hki = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        nu(true);
        this.mHandler.postDelayed(this.hkq, 1000L);
    }

    public void EB() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.brR);
        MessageManager.getInstance().sendMessage(httpMessage);
        ey(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, null);
    }

    public void EE() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.hkc);
        httpMessage.setTag(this.brR);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void EG() {
        HttpMessage httpMessage = new HttpMessage(1021197);
        httpMessage.addParam("challenge_id", this.hkc);
        httpMessage.setTag(this.brR);
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
        if (alaChallengeSwitchResponsedMessage != null && this.hja != null) {
            if (alaChallengeSwitchResponsedMessage.hasError() || alaChallengeSwitchResponsedMessage.getError() != 0) {
                this.hja.p(alaChallengeSwitchResponsedMessage.getError(), alaChallengeSwitchResponsedMessage.getErrorString());
            } else {
                this.hja.EI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.hja != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.hja.m(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.hja.a(alaGetTargetListResponseMessage.cdi(), alaGetTargetListResponseMessage.cdj());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSearchTargetListResponseMessage alaSearchTargetListResponseMessage) {
        if (this.hja != null && alaSearchTargetListResponseMessage != null) {
            if (alaSearchTargetListResponseMessage.hasError() || alaSearchTargetListResponseMessage.getError() != 0) {
                this.hja.m(alaSearchTargetListResponseMessage.getError(), alaSearchTargetListResponseMessage.getErrorString());
            } else {
                this.hja.a(alaSearchTargetListResponseMessage.cdi(), alaSearchTargetListResponseMessage.cdj());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeLatestListResponseMessage alaChallengeLatestListResponseMessage) {
        if (this.hja != null && alaChallengeLatestListResponseMessage != null) {
            if (alaChallengeLatestListResponseMessage.hasError() || alaChallengeLatestListResponseMessage.getError() != 0) {
                this.hja.aX(alaChallengeLatestListResponseMessage.getError(), alaChallengeLatestListResponseMessage.getErrorString());
            } else {
                this.hja.cA(alaChallengeLatestListResponseMessage.ccW());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CloseChallengeResponseMessage closeChallengeResponseMessage) {
        if (this.hja != null && closeChallengeResponseMessage != null) {
            this.hja.q(!closeChallengeResponseMessage.hasError() && closeChallengeResponseMessage.getError() == 0, closeChallengeResponseMessage.getErrorString());
        }
    }

    private void cdn() {
        this.hkm = false;
        MessageManager.getInstance().removeMessage(1021106, this.brR);
        this.mHandler.removeCallbacks(this.hkp);
        this.hki = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nt(boolean z) {
        this.hkm = true;
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.hkd);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.brR);
        MessageManager.getInstance().sendMessage(httpMessage);
        ey(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, ExtraParamsManager.getBase64(String.valueOf(this.hkd)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.hja != null) {
            this.hkm = false;
            String base64 = ExtraParamsManager.getBase64(String.valueOf(this.hkd));
            String str = "";
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.ccT() != null) {
                str = alaStartDirectChallengeResponseMessage.ccT().aHW + "";
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() != 0) {
                if (this.hja != null) {
                    this.hja.aY(alaStartDirectChallengeResponseMessage.getError(), alaStartDirectChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, alaStartDirectChallengeResponseMessage, base64, str);
                return;
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() == 0 && alaStartDirectChallengeResponseMessage.ccT() != null && (alaStartDirectChallengeResponseMessage.ccT().isValid() || alaStartDirectChallengeResponseMessage.ccT().isTimeout())) {
                com.baidu.live.challenge.a ccT = alaStartDirectChallengeResponseMessage.ccT();
                this.hja.b(ccT);
                cdn();
                if (ccT.Ep()) {
                    fx(ccT.challengeId);
                    this.hkc = ccT.challengeId;
                }
                if (alaStartDirectChallengeResponseMessage.ccT().isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_TIMEOUT, alaStartDirectChallengeResponseMessage, base64, (String) null);
                }
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_SUCC, alaStartDirectChallengeResponseMessage, base64, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.hja != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.hja.aZ(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.hkd)), (String) null);
                return;
            }
            boolean ccV = alaCancelDirectChallengeResponseMessage.ccV();
            com.baidu.live.challenge.a ccT = alaCancelDirectChallengeResponseMessage.ccT();
            this.hja.b(ccV, alaCancelDirectChallengeResponseMessage.ccT());
            cdn();
            if (!ccV && ccT != null && ccT.Ep()) {
                fx(ccT.challengeId);
                this.hkc = ccT.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT_SUCC, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.hkd)), (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.hja != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.hja.ba(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.hja.l(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.cdd());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetQualifyingResultResponseMessage alaGetQualifyingResultResponseMessage) {
        if (this.hja != null && alaGetQualifyingResultResponseMessage != null) {
            if (alaGetQualifyingResultResponseMessage.hasError() || alaGetQualifyingResultResponseMessage.getError() != 0) {
                this.hja.bb(alaGetQualifyingResultResponseMessage.getError(), alaGetQualifyingResultResponseMessage.getErrorString());
            } else if (alaGetQualifyingResultResponseMessage.cdf()) {
                this.hja.d(alaGetQualifyingResultResponseMessage.cde(), alaGetQualifyingResultResponseMessage.cdg());
            } else {
                this.hja.d(alaGetQualifyingResultResponseMessage.cde(), -1L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.hja != null && alaAcceptDirectChallengeResponseMessage != null) {
            String str = "";
            String str2 = "";
            if (alaAcceptDirectChallengeResponseMessage.ccT() != null) {
                str2 = ExtraParamsManager.getBase64(String.valueOf(alaAcceptDirectChallengeResponseMessage.ccT().aHY));
            }
            if (alaAcceptDirectChallengeResponseMessage.ccT() != null) {
                str = alaAcceptDirectChallengeResponseMessage.ccT().aHW + "";
            }
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.hja.bc(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, alaAcceptDirectChallengeResponseMessage, str2, str);
                return;
            }
            boolean ccU = alaAcceptDirectChallengeResponseMessage.ccU();
            com.baidu.live.challenge.a ccT = alaAcceptDirectChallengeResponseMessage.ccT();
            this.hja.c(ccU, ccT);
            if (ccU && ccT != null) {
                fx(ccT.challengeId);
                this.hkc = ccT.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET_SUCC, alaAcceptDirectChallengeResponseMessage, str2, str);
        }
    }

    private void cdo() {
        this.hkl = false;
        MessageManager.getInstance().removeMessage(1021110, this.brR);
        this.mHandler.removeCallbacks(this.hkq);
        this.hki = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nu(boolean z) {
        this.hkl = true;
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.brR);
        MessageManager.getInstance().sendMessage(httpMessage);
        ey(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        String str;
        String str2;
        boolean z = false;
        if (this.hja != null) {
            this.hkl = false;
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() != 0) {
                if (this.hja != null) {
                    this.hja.bd(alaStartRandomChallengeResponseMessage.getError(), alaStartRandomChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, (String) null, (String) null);
                return;
            }
            if (alaStartRandomChallengeResponseMessage == null || alaStartRandomChallengeResponseMessage.ccT() == null) {
                str = null;
                str2 = null;
            } else {
                str2 = alaStartRandomChallengeResponseMessage.ccT().aHW + "";
                str = ExtraParamsManager.getBase64(alaStartRandomChallengeResponseMessage.ccT().aHY + "");
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.ccT() != null && alaStartRandomChallengeResponseMessage.ccT().isValid()) {
                com.baidu.live.challenge.a ccT = alaStartRandomChallengeResponseMessage.ccT();
                this.hja.c(ccT);
                if (ccT.Ep() && !ED()) {
                    cdo();
                    fx(ccT.challengeId);
                    this.hkc = ccT.challengeId;
                } else {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, str, str2);
                }
                if (ccT.isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOW_TIMEOUT, alaStartRandomChallengeResponseMessage, str, (String) null);
                }
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.ccT() != null && alaStartRandomChallengeResponseMessage.ccT().isValid()) {
                z = true;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM_SUCC, alaStartRandomChallengeResponseMessage, str, str2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        String str;
        String str2 = null;
        if (this.hja != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage == null || alaCancelRandomChallengeResponseMessage.ccT() == null) {
                str = null;
            } else {
                str = alaCancelRandomChallengeResponseMessage.ccT().challengeId + "";
                str2 = alaCancelRandomChallengeResponseMessage.ccT().aHW + "";
            }
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.hja.be(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, alaCancelRandomChallengeResponseMessage, str, str2);
                return;
            }
            boolean ccV = alaCancelRandomChallengeResponseMessage.ccV();
            com.baidu.live.challenge.a ccT = alaCancelRandomChallengeResponseMessage.ccT();
            this.hja.d(ccV, alaCancelRandomChallengeResponseMessage.ccT());
            cdo();
            if (!ccV && ccT != null && ccT.Ep()) {
                fx(ccT.challengeId);
                this.hkc = ccT.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCLE_RANDOM_SUCC, alaCancelRandomChallengeResponseMessage, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.hja != null && alaSurrenderResponseMessage != null) {
            this.hja.p(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.hja != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.hja.l(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.hja.a(alaGetTargetInfoResponseMessage.cdh());
            }
        }
    }

    public void bv(boolean z) {
        this.bLf = z ? 1 : 2;
    }

    public void fx(long j) {
        this.hkg = true;
        this.hkc = j;
        this.mHandler.post(this.hkr);
    }

    private void cdp() {
        this.hkg = false;
        this.mHandler.removeCallbacks(this.hkr);
        this.hkk = false;
        MessageManager.getInstance().removeMessage(1021112, this.brR);
    }

    public void cdq() {
        this.mHandler.removeCallbacks(this.hkr);
        this.hkk = false;
        MessageManager.getInstance().removeMessage(1021112, this.brR);
    }

    public void cdr() {
        this.mHandler.post(this.hkr);
    }

    private void a(ba baVar, be beVar, be beVar2, long j) {
        if (baVar == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info challenge meta is null?? logid=" + j);
        } else if (beVar != null && beVar.aPX != null && beVar.aPX.getLiveID() != this.ghb) {
            BdLog.e("CHALLENGE_TAG in challenge not current live?? ||Challenge id=" + baVar.challengeId + "||Challenge Status=" + baVar.aPL + "||Net liveId=" + beVar.aPX.getLiveID() + "||cur liveId=" + this.ghb + "||logid=" + j);
        } else {
            int i = baVar.aPL;
            this.hja.b(i, baVar, beVar, beVar2);
            switch (i) {
                case 2:
                    this.hki = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    cdk();
                    break;
                case 3:
                    this.hki = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.hki = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.hkc = 0L;
                    cdl();
                    break;
            }
            if (beVar != null && beVar.aPJ != null) {
                this.hke = beVar.aPJ.userId;
            }
            if (beVar2 != null && beVar2.aPJ != null) {
                this.hkf = beVar2.aPJ.userId;
            }
            if (4 == baVar.aPL || 5 == baVar.aPL) {
                cdp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.hja == null || alaGetChallengeInfoResponseMessage == null || alaGetChallengeInfoResponseMessage.ccX() == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info callback, response message, meta info  null?? ");
            if (alaGetChallengeInfoResponseMessage != null) {
                BdLog.e("CHALLENGE_TAG get Challenge Info error=" + alaGetChallengeInfoResponseMessage.getError());
                return;
            }
            return;
        }
        ba ccX = alaGetChallengeInfoResponseMessage.ccX();
        be ccY = alaGetChallengeInfoResponseMessage.ccY();
        be ccZ = alaGetChallengeInfoResponseMessage.ccZ();
        aw cda = alaGetChallengeInfoResponseMessage.cda();
        bc cdb = alaGetChallengeInfoResponseMessage.cdb();
        bd cdc = alaGetChallengeInfoResponseMessage.cdc();
        if (cda != null && cda.aPF > 0 && this.hkb != cda.aPF) {
            this.hkb = cda.aPF;
        }
        a(ccX, ccY, ccZ, alaGetChallengeInfoResponseMessage.getLogId());
        int i = 0;
        if (com.baidu.live.ae.a.RB().brA != null) {
            i = com.baidu.live.ae.a.RB().brA.aNC;
        }
        if (i == 1 && ccX != null && ccY != null && ccY.aPX != null && ccY.aPX.user_id == TbadkCoreApplication.getCurrentAccountId()) {
            if (this.hkn == null) {
                this.hkn = new HashMap();
            }
            long j = ccX.challengeId;
            if (cdc != null && cdc.aPW != null && !cdc.aPW.isEmpty() && (!this.hkn.containsKey(Long.valueOf(j)) || this.hkn.get(Long.valueOf(j)).isEmpty())) {
                this.hkn.put(Long.valueOf(j), cdc.aPW);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913209, cdc.aPW));
            }
            if (cdb != null && ccX.aPL >= 3 && ccX.challengeResult == 2) {
                if ((cdb.type == 1 || cdb.type == 3) && !TextUtils.isEmpty(cdb.aPU)) {
                    if (this.hko == null) {
                        this.hko = new HashMap();
                    }
                    if (!this.hko.containsKey(Long.valueOf(j))) {
                        this.hko.put(Long.valueOf(j), 0);
                    }
                    if (ccX.aPL == 3) {
                        int intValue = this.hko.get(Long.valueOf(j)).intValue();
                        if (cdb.serverTime >= cdb.startTime && cdb.serverTime <= cdb.endTime) {
                            if (intValue < 1) {
                                this.hko.put(Long.valueOf(j), 1);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913210, cdb.aPU));
                            }
                        } else if (cdb.serverTime > cdb.endTime && intValue < 2) {
                            this.hko.put(Long.valueOf(j), 2);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                        }
                    } else if (ccX.aPL > 3) {
                        this.hko.put(Long.valueOf(j), 2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                    }
                }
            }
        }
    }

    public ChallenfeInfoData.ChallengeStatus EC() {
        return this.hki;
    }

    private void ey(String str, String str2) {
        if (this.isHost) {
            UbcStatisticManager.getInstance().logSendRequest(x(str, str2, null, UbcStatisticLiveKey.KEY_ID_PK_REQ));
        }
    }

    private void a(String str, HttpResponsedMessage httpResponsedMessage, String str2, String str3) {
        if (this.isHost && httpResponsedMessage != null) {
            UbcStatisticManager.getInstance().logSendResponse(x(str, str2, str3, UbcStatisticLiveKey.KEY_ID_PK_RESP), httpResponsedMessage, true);
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

    private UbcStatisticItem x(String str, String str2, String str3, String str4) {
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

    public boolean ED() {
        return this.hkg;
    }
}
