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
/* loaded from: classes10.dex */
public class b {
    private BdUniqueId aEw;
    private int bQq;
    private long gry;
    private a hww;
    private long hxA;
    private long hxB;
    private long hxD;
    private ChallenfeInfoData.ChallengeStatus hxE;
    private i.f hxF;
    private int hxd;
    private long hxv;
    private long hxw;
    private long hxx;
    private long hxy;
    private long hxz;
    private boolean isHost;
    private TbPageContext mPageContext;
    private boolean hxC = false;
    private boolean hxG = false;
    private boolean hxH = false;
    private boolean hxI = false;
    private HttpMessageListener bSl = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.1
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
    private HttpMessageListener bmE = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                b.this.hxG = false;
                if (!b.this.hww.ccO()) {
                    b.this.b((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                    b.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                }
            }
        }
    };
    private Runnable hxL = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.hxI) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.hxw);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, b.this.aEw);
            b.this.oa(false);
            b.this.mHandler.postDelayed(this, b.this.hxw);
        }
    };
    private Runnable hxM = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.4
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.hxH) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.hxv);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, b.this.aEw);
            b.this.ob(false);
            b.this.mHandler.postDelayed(this, b.this.hxv);
        }
    };
    private Runnable hxN = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.5
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.hxy <= 0) {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().removeMessage(1021112, b.this.aEw);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            if (b.this.hxG) {
                b.this.mHandler.postDelayed(this, b.this.hxx);
                return;
            }
            MessageManager.getInstance().removeMessage(1021112, b.this.aEw);
            if (b.this.hxF != null) {
                b.this.hxd = b.this.hxF.AO();
            }
            b.this.hxG = true;
            com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(b.this.hxy, b.this.bQq, b.this.gry, b.this.hxD, b.this.hxd);
            aVar.setTag(b.this.aEw);
            MessageManager.getInstance().sendMessage(aVar);
            if (b.this.isHost) {
                UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_REQ, UbcStatConstant.ContentType.UBC_TYPE_PK_CHALLENGE_INFO, "author_liveroom", "");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("avts_conn", b.this.bQq);
                    jSONObject2.put("avts_fail", b.this.hxd);
                    jSONObject2.put("chat_id", b.this.hxy);
                    jSONObject.put("pk", jSONObject2);
                } catch (JSONException e) {
                }
                ubcStatisticItem.setContentExt(jSONObject);
                UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
            }
            b.this.mHandler.postDelayed(this, b.this.hxx);
        }
    };
    private Handler mHandler = new Handler();
    private Map<Long, List<Long>> hxJ = new HashMap();
    private Map<Long, Integer> hxK = new HashMap();

    /* loaded from: classes10.dex */
    public interface a {
        void AP();

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

        boolean ccO();

        void d(boolean z, com.baidu.live.challenge.a aVar);

        void l(boolean z, long j);

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
                jSONObject2.put("avts_conn", this.bQq);
                jSONObject2.put("avts_fail", this.hxd);
                if (alaGetChallengeInfoResponseMessage.cde() != null) {
                    jSONObject2.put("chat_id", alaGetChallengeInfoResponseMessage.cde().challengeId);
                    jSONObject2.put(AlaRecorderLog.KEY_CHAT_STATUS, alaGetChallengeInfoResponseMessage.cde().aQk);
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
        this.aEw = bdUniqueId;
        this.hxv = com.baidu.live.ae.a.Qm().bwx.aNv > 0 ? com.baidu.live.ae.a.Qm().bwx.aNv : 1000L;
        this.hxw = com.baidu.live.ae.a.Qm().bwx.aNw > 0 ? com.baidu.live.ae.a.Qm().bwx.aNw : 1000L;
        this.hxx = com.baidu.live.ae.a.Qm().bwx.aNx > 0 ? com.baidu.live.ae.a.Qm().bwx.aNx : 1000L;
        this.hxE = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        registerTask();
        registerListener();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public void h(long j, long j2) {
        this.gry = j;
        this.hxD = j2;
    }

    public void a(a aVar) {
        this.hww = aVar;
    }

    public void b(i.f fVar) {
        this.hxF = fVar;
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
        MessageManager.getInstance().registerListener(1021183, this.bSl);
        MessageManager.getInstance().registerListener(1021105, this.bSl);
        MessageManager.getInstance().registerListener(1021182, this.bSl);
        MessageManager.getInstance().registerListener(1021203, this.bSl);
        MessageManager.getInstance().registerListener(1021106, this.bSl);
        MessageManager.getInstance().registerListener(1021107, this.bSl);
        MessageManager.getInstance().registerListener(1021108, this.bSl);
        MessageManager.getInstance().registerListener(1021109, this.bSl);
        MessageManager.getInstance().registerListener(1021110, this.bSl);
        MessageManager.getInstance().registerListener(1021111, this.bSl);
        MessageManager.getInstance().registerListener(1021115, this.bSl);
        MessageManager.getInstance().registerListener(1021116, this.bSl);
        MessageManager.getInstance().registerListener(1021197, this.bSl);
        MessageManager.getInstance().registerListener(this.bmE);
        MessageManager.getInstance().registerListener(1021209, this.bSl);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bSl);
        MessageManager.getInstance().unRegisterListener(this.bmE);
    }

    private void cdr() {
        MessageManager.getInstance().removeMessage(1021183, this.aEw);
        MessageManager.getInstance().removeMessage(1021105, this.aEw);
        MessageManager.getInstance().removeMessage(1021182, this.aEw);
        MessageManager.getInstance().removeMessage(1021203, this.aEw);
        MessageManager.getInstance().removeMessage(1021106, this.aEw);
        MessageManager.getInstance().removeMessage(1021107, this.aEw);
        MessageManager.getInstance().removeMessage(1021108, this.aEw);
        MessageManager.getInstance().removeMessage(1021109, this.aEw);
        MessageManager.getInstance().removeMessage(1021110, this.aEw);
        MessageManager.getInstance().removeMessage(1021111, this.aEw);
        MessageManager.getInstance().removeMessage(1021116, this.aEw);
        MessageManager.getInstance().removeMessage(1021209, this.aEw);
    }

    private void cds() {
        MessageManager.getInstance().removeMessage(1021112, this.aEw);
        MessageManager.getInstance().removeMessage(1021115, this.aEw);
    }

    private void reset() {
        this.hxy = 0L;
        this.hxz = 0L;
        this.bQq = 0;
        this.hxd = 0;
        this.hxA = 0L;
        this.hxB = 0L;
        cdv();
        cdu();
        cdw();
        this.mHandler.removeCallbacksAndMessages(null);
        cdr();
        cds();
    }

    public void cdt() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long AM() {
        return this.hxy;
    }

    public void AF() {
        HttpMessage httpMessage = new HttpMessage(1021183);
        httpMessage.setTag(this.aEw);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void HN(String str) {
        HttpMessage httpMessage = new HttpMessage(1021209);
        httpMessage.addParam("user_id", str);
        httpMessage.setTag(this.aEw);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void y(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.aEw);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void g(int i, int i2, String str) {
        HttpMessage httpMessage = new HttpMessage(1021182);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.addParam("query_words", str);
        httpMessage.setTag(this.aEw);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void fw(String str) {
        HttpMessage httpMessage = new HttpMessage(1021203);
        httpMessage.setTag(this.aEw);
        httpMessage.addParam("anchor_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void aI(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.aEw);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void aJ(long j) {
        this.hxy = 0L;
        this.hxz = j;
        this.hxE = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        oa(true);
        this.mHandler.postDelayed(this.hxL, 1000L);
    }

    public void aK(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.aEw);
        MessageManager.getInstance().sendMessage(httpMessage);
        ev(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void AG() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.aEw);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void aL(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.aEw);
        MessageManager.getInstance().sendMessage(httpMessage);
        ev(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void AH() {
        this.hxy = 0L;
        this.hxE = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        ob(true);
        this.mHandler.postDelayed(this.hxM, 1000L);
    }

    public void AI() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.aEw);
        MessageManager.getInstance().sendMessage(httpMessage);
        ev(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, null);
    }

    public void AL() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.hxy);
        httpMessage.setTag(this.aEw);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void AN() {
        HttpMessage httpMessage = new HttpMessage(1021197);
        httpMessage.addParam("challenge_id", this.hxy);
        httpMessage.setTag(this.aEw);
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
        if (alaChallengeSwitchResponsedMessage != null && this.hww != null) {
            if (alaChallengeSwitchResponsedMessage.hasError() || alaChallengeSwitchResponsedMessage.getError() != 0) {
                this.hww.t(alaChallengeSwitchResponsedMessage.getError(), alaChallengeSwitchResponsedMessage.getErrorString());
            } else {
                this.hww.AP();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.hww != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.hww.q(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.hww.a(alaGetTargetListResponseMessage.cdp(), alaGetTargetListResponseMessage.cdq());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSearchTargetListResponseMessage alaSearchTargetListResponseMessage) {
        if (this.hww != null && alaSearchTargetListResponseMessage != null) {
            if (alaSearchTargetListResponseMessage.hasError() || alaSearchTargetListResponseMessage.getError() != 0) {
                this.hww.q(alaSearchTargetListResponseMessage.getError(), alaSearchTargetListResponseMessage.getErrorString());
            } else {
                this.hww.a(alaSearchTargetListResponseMessage.cdp(), alaSearchTargetListResponseMessage.cdq());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeLatestListResponseMessage alaChallengeLatestListResponseMessage) {
        if (this.hww != null && alaChallengeLatestListResponseMessage != null) {
            if (alaChallengeLatestListResponseMessage.hasError() || alaChallengeLatestListResponseMessage.getError() != 0) {
                this.hww.bf(alaChallengeLatestListResponseMessage.getError(), alaChallengeLatestListResponseMessage.getErrorString());
            } else {
                this.hww.cC(alaChallengeLatestListResponseMessage.cdd());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CloseChallengeResponseMessage closeChallengeResponseMessage) {
        if (this.hww != null && closeChallengeResponseMessage != null) {
            boolean z = !closeChallengeResponseMessage.hasError() && closeChallengeResponseMessage.getError() == 0;
            this.hww.x(z, closeChallengeResponseMessage.getErrorString());
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_CLOSE_RESULT, "author_liveroom", z ? "challenge_close_succ" : "challenge_close_fail"), closeChallengeResponseMessage, true);
        }
    }

    private void cdu() {
        this.hxI = false;
        MessageManager.getInstance().removeMessage(1021106, this.aEw);
        this.mHandler.removeCallbacks(this.hxL);
        this.hxE = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oa(boolean z) {
        this.hxI = true;
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.hxz);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.aEw);
        MessageManager.getInstance().sendMessage(httpMessage);
        ev(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, ExtraParamsManager.getBase64(String.valueOf(this.hxz)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.hww != null) {
            this.hxI = false;
            String base64 = ExtraParamsManager.getBase64(String.valueOf(this.hxz));
            String str = "";
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.cda() != null) {
                str = alaStartDirectChallengeResponseMessage.cda().aGS + "";
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() != 0) {
                if (this.hww != null) {
                    this.hww.bg(alaStartDirectChallengeResponseMessage.getError(), alaStartDirectChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, alaStartDirectChallengeResponseMessage, base64, str);
                return;
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() == 0 && alaStartDirectChallengeResponseMessage.cda() != null && (alaStartDirectChallengeResponseMessage.cda().isValid() || alaStartDirectChallengeResponseMessage.cda().isTimeout())) {
                com.baidu.live.challenge.a cda = alaStartDirectChallengeResponseMessage.cda();
                this.hww.b(cda);
                cdu();
                if (cda.Aw()) {
                    fC(cda.challengeId);
                    this.hxy = cda.challengeId;
                }
                if (alaStartDirectChallengeResponseMessage.cda().isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_TIMEOUT, alaStartDirectChallengeResponseMessage, base64, (String) null);
                }
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_SUCC, alaStartDirectChallengeResponseMessage, base64, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.hww != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.hww.bh(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.hxz)), (String) null);
                return;
            }
            boolean cdc = alaCancelDirectChallengeResponseMessage.cdc();
            com.baidu.live.challenge.a cda = alaCancelDirectChallengeResponseMessage.cda();
            this.hww.b(cdc, alaCancelDirectChallengeResponseMessage.cda());
            cdu();
            if (!cdc && cda != null && cda.Aw()) {
                fC(cda.challengeId);
                this.hxy = cda.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT_SUCC, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.hxz)), (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.hww != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.hww.bi(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.hww.m(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.cdk());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetQualifyingResultResponseMessage alaGetQualifyingResultResponseMessage) {
        if (this.hww != null && alaGetQualifyingResultResponseMessage != null) {
            if (alaGetQualifyingResultResponseMessage.hasError() || alaGetQualifyingResultResponseMessage.getError() != 0) {
                this.hww.bj(alaGetQualifyingResultResponseMessage.getError(), alaGetQualifyingResultResponseMessage.getErrorString());
            } else if (alaGetQualifyingResultResponseMessage.cdm()) {
                this.hww.l(alaGetQualifyingResultResponseMessage.cdl(), alaGetQualifyingResultResponseMessage.cdn());
            } else {
                this.hww.l(alaGetQualifyingResultResponseMessage.cdl(), -1L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.hww != null && alaAcceptDirectChallengeResponseMessage != null) {
            String str = "";
            String str2 = "";
            if (alaAcceptDirectChallengeResponseMessage.cda() != null) {
                str2 = ExtraParamsManager.getBase64(String.valueOf(alaAcceptDirectChallengeResponseMessage.cda().aGU));
            }
            if (alaAcceptDirectChallengeResponseMessage.cda() != null) {
                str = alaAcceptDirectChallengeResponseMessage.cda().aGS + "";
            }
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.hww.bk(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, alaAcceptDirectChallengeResponseMessage, str2, str);
                return;
            }
            boolean cdb = alaAcceptDirectChallengeResponseMessage.cdb();
            com.baidu.live.challenge.a cda = alaAcceptDirectChallengeResponseMessage.cda();
            this.hww.c(cdb, cda);
            if (cdb && cda != null) {
                fC(cda.challengeId);
                this.hxy = cda.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET_SUCC, alaAcceptDirectChallengeResponseMessage, str2, str);
        }
    }

    private void cdv() {
        this.hxH = false;
        MessageManager.getInstance().removeMessage(1021110, this.aEw);
        this.mHandler.removeCallbacks(this.hxM);
        this.hxE = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ob(boolean z) {
        this.hxH = true;
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.aEw);
        MessageManager.getInstance().sendMessage(httpMessage);
        ev(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        String str;
        String str2;
        boolean z = false;
        if (this.hww != null) {
            this.hxH = false;
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() != 0) {
                if (this.hww != null) {
                    this.hww.bl(alaStartRandomChallengeResponseMessage.getError(), alaStartRandomChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, (String) null, (String) null);
                return;
            }
            if (alaStartRandomChallengeResponseMessage == null || alaStartRandomChallengeResponseMessage.cda() == null) {
                str = null;
                str2 = null;
            } else {
                str2 = alaStartRandomChallengeResponseMessage.cda().aGS + "";
                str = ExtraParamsManager.getBase64(alaStartRandomChallengeResponseMessage.cda().aGU + "");
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.cda() != null && alaStartRandomChallengeResponseMessage.cda().isValid()) {
                com.baidu.live.challenge.a cda = alaStartRandomChallengeResponseMessage.cda();
                this.hww.c(cda);
                if (cda.Aw() && !AK()) {
                    cdv();
                    fC(cda.challengeId);
                    this.hxy = cda.challengeId;
                } else {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, str, str2);
                }
                if (cda.isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOW_TIMEOUT, alaStartRandomChallengeResponseMessage, str, (String) null);
                }
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.cda() != null && alaStartRandomChallengeResponseMessage.cda().isValid()) {
                z = true;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM_SUCC, alaStartRandomChallengeResponseMessage, str, str2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        String str;
        String str2;
        if (this.hww != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage == null || alaCancelRandomChallengeResponseMessage.cda() == null) {
                str = null;
                str2 = null;
            } else {
                str = alaCancelRandomChallengeResponseMessage.cda().aGS + "";
                str2 = alaCancelRandomChallengeResponseMessage.cda().challengeId + "";
            }
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.hww.bm(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, alaCancelRandomChallengeResponseMessage, str2, str);
                return;
            }
            boolean cdc = alaCancelRandomChallengeResponseMessage.cdc();
            com.baidu.live.challenge.a cda = alaCancelRandomChallengeResponseMessage.cda();
            this.hww.d(cdc, alaCancelRandomChallengeResponseMessage.cda());
            cdv();
            if (!cdc && cda != null && cda.Aw()) {
                fC(cda.challengeId);
                this.hxy = cda.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCLE_RANDOM_SUCC, alaCancelRandomChallengeResponseMessage, str2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.hww != null && alaSurrenderResponseMessage != null) {
            this.hww.w(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.hww != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.hww.p(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.hww.a(alaGetTargetInfoResponseMessage.cdo());
            }
        }
    }

    public void bq(boolean z) {
        this.bQq = z ? 1 : 2;
    }

    public void fC(long j) {
        this.hxC = true;
        this.hxy = j;
        this.mHandler.post(this.hxN);
    }

    private void cdw() {
        this.hxC = false;
        this.mHandler.removeCallbacks(this.hxN);
        this.hxG = false;
        MessageManager.getInstance().removeMessage(1021112, this.aEw);
    }

    public void cdx() {
        this.mHandler.removeCallbacks(this.hxN);
        this.hxG = false;
        MessageManager.getInstance().removeMessage(1021112, this.aEw);
    }

    public void cdy() {
        this.mHandler.post(this.hxN);
    }

    private void a(bg bgVar, bk bkVar, bk bkVar2, long j) {
        if (bgVar == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info challenge meta is null?? logid=" + j);
        } else if (bkVar != null && bkVar.aQw != null && bkVar.aQw.getLiveID() != this.gry) {
            BdLog.e("CHALLENGE_TAG in challenge not current live?? ||Challenge id=" + bgVar.challengeId + "||Challenge Status=" + bgVar.aQk + "||Net liveId=" + bkVar.aQw.getLiveID() + "||cur liveId=" + this.gry + "||logid=" + j);
        } else {
            int i = bgVar.aQk;
            this.hww.b(i, bgVar, bkVar, bkVar2);
            switch (i) {
                case 2:
                    this.hxE = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    cdr();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913284));
                    break;
                case 3:
                    this.hxE = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.hxE = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.hxy = 0L;
                    cds();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913283));
                    break;
            }
            if (bkVar != null && bkVar.aQi != null) {
                this.hxA = bkVar.aQi.userId;
            }
            if (bkVar2 != null && bkVar2.aQi != null) {
                this.hxB = bkVar2.aQi.userId;
            }
            if (4 == bgVar.aQk || 5 == bgVar.aQk) {
                cdw();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.hww == null || alaGetChallengeInfoResponseMessage == null || alaGetChallengeInfoResponseMessage.cde() == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info callback, response message, meta info  null?? ");
            if (alaGetChallengeInfoResponseMessage != null) {
                BdLog.e("CHALLENGE_TAG get Challenge Info error=" + alaGetChallengeInfoResponseMessage.getError());
                return;
            }
            return;
        }
        bg cde = alaGetChallengeInfoResponseMessage.cde();
        bk cdf = alaGetChallengeInfoResponseMessage.cdf();
        bk cdg = alaGetChallengeInfoResponseMessage.cdg();
        bc cdh = alaGetChallengeInfoResponseMessage.cdh();
        bi cdi = alaGetChallengeInfoResponseMessage.cdi();
        bj cdj = alaGetChallengeInfoResponseMessage.cdj();
        if (cdh != null && cdh.aQe > 0 && this.hxx != cdh.aQe) {
            this.hxx = cdh.aQe;
        }
        a(cde, cdf, cdg, alaGetChallengeInfoResponseMessage.getLogId());
        int i = 0;
        if (com.baidu.live.ae.a.Qm().bwx != null) {
            i = com.baidu.live.ae.a.Qm().bwx.aND;
        }
        if (i == 1 && cde != null && cdf != null && cdf.aQw != null && cdf.aQw.user_id == TbadkCoreApplication.getCurrentAccountId()) {
            if (this.hxJ == null) {
                this.hxJ = new HashMap();
            }
            long j = cde.challengeId;
            if (cdj != null && cdj.aQv != null && !cdj.aQv.isEmpty() && (!this.hxJ.containsKey(Long.valueOf(j)) || this.hxJ.get(Long.valueOf(j)).isEmpty())) {
                this.hxJ.put(Long.valueOf(j), cdj.aQv);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913209, cdj.aQv));
            }
            if (cdi != null && cde.aQk >= 3 && cde.challengeResult == 2) {
                if ((cdi.type == 1 || cdi.type == 3) && !TextUtils.isEmpty(cdi.aQt)) {
                    if (this.hxK == null) {
                        this.hxK = new HashMap();
                    }
                    if (!this.hxK.containsKey(Long.valueOf(j))) {
                        this.hxK.put(Long.valueOf(j), 0);
                    }
                    if (cde.aQk == 3) {
                        int intValue = this.hxK.get(Long.valueOf(j)).intValue();
                        if (cdi.serverTime >= cdi.startTime && cdi.serverTime <= cdi.endTime) {
                            if (intValue < 1) {
                                this.hxK.put(Long.valueOf(j), 1);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913210, cdi.aQt));
                            }
                        } else if (cdi.serverTime > cdi.endTime && intValue < 2) {
                            this.hxK.put(Long.valueOf(j), 2);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                        }
                    } else if (cde.aQk > 3) {
                        this.hxK.put(Long.valueOf(j), 2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                    }
                }
            }
        }
    }

    public ChallenfeInfoData.ChallengeStatus AJ() {
        return this.hxE;
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

    public boolean AK() {
        return this.hxC;
    }
}
