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
import com.baidu.live.data.av;
import com.baidu.live.data.az;
import com.baidu.live.data.bb;
import com.baidu.live.data.bc;
import com.baidu.live.data.bd;
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
    private int bFX;
    private BdUniqueId bmJ;
    private long fYO;
    private int gZW;
    private a gZp;
    private long hao;
    private long hap;
    private long haq;
    private long har;
    private long has;
    private long hat;
    private long hau;
    private long haw;
    private ChallenfeInfoData.ChallengeStatus hax;
    private i.f hay;
    private boolean isHost;
    private TbPageContext mPageContext;
    private boolean hav = false;
    private boolean haz = false;
    private boolean haA = false;
    private boolean haB = false;
    private HttpMessageListener bHM = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.1
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
    private HttpMessageListener bgD = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                b.this.haz = false;
                if (!b.this.gZp.bYL()) {
                    b.this.b((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                    b.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                }
            }
        }
    };
    private Runnable haE = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.haB) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.hap);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, b.this.bmJ);
            b.this.mY(false);
            b.this.mHandler.postDelayed(this, b.this.hap);
        }
    };
    private Runnable haF = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.4
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.haA) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.hao);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, b.this.bmJ);
            b.this.mZ(false);
            b.this.mHandler.postDelayed(this, b.this.hao);
        }
    };
    private Runnable haG = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.5
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.har <= 0) {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().removeMessage(1021112, b.this.bmJ);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            if (b.this.haz) {
                b.this.mHandler.postDelayed(this, b.this.haq);
                return;
            }
            MessageManager.getInstance().removeMessage(1021112, b.this.bmJ);
            if (b.this.hay != null) {
                b.this.gZW = b.this.hay.CX();
            }
            b.this.haz = true;
            com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(b.this.har, b.this.bFX, b.this.fYO, b.this.haw, b.this.gZW);
            aVar.setTag(b.this.bmJ);
            MessageManager.getInstance().sendMessage(aVar);
            if (b.this.isHost) {
                UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_REQ, UbcStatConstant.ContentType.UBC_TYPE_PK_CHALLENGE_INFO, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("avts_conn", b.this.bFX);
                    jSONObject2.put("avts_fail", b.this.gZW);
                    jSONObject2.put("chat_id", b.this.har);
                    jSONObject.put("pk", jSONObject2);
                } catch (JSONException e) {
                }
                ubcStatisticItem.setContentExt(jSONObject);
                UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
            }
            b.this.mHandler.postDelayed(this, b.this.haq);
        }
    };
    private Handler mHandler = new Handler();
    private Map<Long, List<Long>> haC = new HashMap();
    private Map<Long, Integer> haD = new HashMap();

    /* loaded from: classes4.dex */
    public interface a {
        void CY();

        void a(com.baidu.live.challenge.b bVar, List<d> list);

        void a(d dVar);

        void aX(int i, String str);

        void aY(int i, String str);

        void aZ(int i, String str);

        void b(int i, az azVar, bd bdVar, bd bdVar2);

        void b(com.baidu.live.challenge.a aVar);

        void b(boolean z, com.baidu.live.challenge.a aVar);

        boolean bYL();

        void ba(int i, String str);

        void bb(int i, String str);

        void bc(int i, String str);

        void bd(int i, String str);

        void be(int i, String str);

        void c(com.baidu.live.challenge.a aVar);

        void c(boolean z, com.baidu.live.challenge.a aVar);

        void cw(List<d> list);

        void d(boolean z, long j);

        void d(boolean z, com.baidu.live.challenge.a aVar);

        void l(int i, String str);

        void l(int i, List<d> list);

        void m(int i, String str);

        void p(int i, String str);

        void q(boolean z, String str);

        void r(boolean z, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        UbcStatisticItem ubcStatisticItem;
        if (alaGetChallengeInfoResponseMessage != null && this.isHost) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("avts_conn", this.bFX);
                jSONObject2.put("avts_fail", this.gZW);
                if (alaGetChallengeInfoResponseMessage.bZb() != null) {
                    jSONObject2.put("chat_id", alaGetChallengeInfoResponseMessage.bZb().challengeId);
                    jSONObject2.put("chat_status", alaGetChallengeInfoResponseMessage.bZb().aMM);
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
        this.bmJ = bdUniqueId;
        this.hao = com.baidu.live.aa.a.Ph().bms.aKz > 0 ? com.baidu.live.aa.a.Ph().bms.aKz : 1000L;
        this.hap = com.baidu.live.aa.a.Ph().bms.aKA > 0 ? com.baidu.live.aa.a.Ph().bms.aKA : 1000L;
        this.haq = com.baidu.live.aa.a.Ph().bms.aKB > 0 ? com.baidu.live.aa.a.Ph().bms.aKB : 1000L;
        this.hax = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        registerTask();
        registerListener();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public void e(long j, long j2) {
        this.fYO = j;
        this.haw = j2;
    }

    public void a(a aVar) {
        this.gZp = aVar;
    }

    public void b(i.f fVar) {
        this.hay = fVar;
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
        MessageManager.getInstance().registerListener(1021183, this.bHM);
        MessageManager.getInstance().registerListener(1021105, this.bHM);
        MessageManager.getInstance().registerListener(1021182, this.bHM);
        MessageManager.getInstance().registerListener(1021203, this.bHM);
        MessageManager.getInstance().registerListener(1021106, this.bHM);
        MessageManager.getInstance().registerListener(1021107, this.bHM);
        MessageManager.getInstance().registerListener(1021108, this.bHM);
        MessageManager.getInstance().registerListener(1021109, this.bHM);
        MessageManager.getInstance().registerListener(1021110, this.bHM);
        MessageManager.getInstance().registerListener(1021111, this.bHM);
        MessageManager.getInstance().registerListener(1021115, this.bHM);
        MessageManager.getInstance().registerListener(1021116, this.bHM);
        MessageManager.getInstance().registerListener(1021197, this.bHM);
        MessageManager.getInstance().registerListener(this.bgD);
        MessageManager.getInstance().registerListener(1021209, this.bHM);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bHM);
        MessageManager.getInstance().unRegisterListener(this.bgD);
    }

    private void bZo() {
        MessageManager.getInstance().removeMessage(1021183, this.bmJ);
        MessageManager.getInstance().removeMessage(1021105, this.bmJ);
        MessageManager.getInstance().removeMessage(1021182, this.bmJ);
        MessageManager.getInstance().removeMessage(1021203, this.bmJ);
        MessageManager.getInstance().removeMessage(1021106, this.bmJ);
        MessageManager.getInstance().removeMessage(1021107, this.bmJ);
        MessageManager.getInstance().removeMessage(1021108, this.bmJ);
        MessageManager.getInstance().removeMessage(1021109, this.bmJ);
        MessageManager.getInstance().removeMessage(1021110, this.bmJ);
        MessageManager.getInstance().removeMessage(1021111, this.bmJ);
        MessageManager.getInstance().removeMessage(1021116, this.bmJ);
        MessageManager.getInstance().removeMessage(1021209, this.bmJ);
    }

    private void bZp() {
        MessageManager.getInstance().removeMessage(1021112, this.bmJ);
        MessageManager.getInstance().removeMessage(1021115, this.bmJ);
    }

    private void reset() {
        this.har = 0L;
        this.has = 0L;
        this.bFX = 0;
        this.gZW = 0;
        this.hat = 0L;
        this.hau = 0L;
        bZs();
        bZr();
        bZt();
        this.mHandler.removeCallbacksAndMessages(null);
        bZo();
        bZp();
    }

    public void bZq() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long CV() {
        return this.har;
    }

    public void CO() {
        HttpMessage httpMessage = new HttpMessage(1021183);
        httpMessage.setTag(this.bmJ);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void Hu(String str) {
        HttpMessage httpMessage = new HttpMessage(1021209);
        httpMessage.addParam("user_id", str);
        httpMessage.setTag(this.bmJ);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void w(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.bmJ);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void f(int i, int i2, String str) {
        HttpMessage httpMessage = new HttpMessage(1021182);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.addParam("query_words", str);
        httpMessage.setTag(this.bmJ);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void gd(String str) {
        HttpMessage httpMessage = new HttpMessage(1021203);
        httpMessage.setTag(this.bmJ);
        httpMessage.addParam("anchor_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void aj(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.bmJ);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void ak(long j) {
        this.har = 0L;
        this.has = j;
        this.hax = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        mY(true);
        this.mHandler.postDelayed(this.haE, 1000L);
    }

    public void al(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.bmJ);
        MessageManager.getInstance().sendMessage(httpMessage);
        es(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void CP() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.bmJ);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void am(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.bmJ);
        MessageManager.getInstance().sendMessage(httpMessage);
        es(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void CQ() {
        this.har = 0L;
        this.hax = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        mZ(true);
        this.mHandler.postDelayed(this.haF, 1000L);
    }

    public void CR() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.bmJ);
        MessageManager.getInstance().sendMessage(httpMessage);
        es(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, null);
    }

    public void CU() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.har);
        httpMessage.setTag(this.bmJ);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void CW() {
        HttpMessage httpMessage = new HttpMessage(1021197);
        httpMessage.addParam("challenge_id", this.har);
        httpMessage.setTag(this.bmJ);
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
        if (alaChallengeSwitchResponsedMessage != null && this.gZp != null) {
            if (alaChallengeSwitchResponsedMessage.hasError() || alaChallengeSwitchResponsedMessage.getError() != 0) {
                this.gZp.p(alaChallengeSwitchResponsedMessage.getError(), alaChallengeSwitchResponsedMessage.getErrorString());
            } else {
                this.gZp.CY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.gZp != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.gZp.m(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.gZp.a(alaGetTargetListResponseMessage.bZm(), alaGetTargetListResponseMessage.bZn());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSearchTargetListResponseMessage alaSearchTargetListResponseMessage) {
        if (this.gZp != null && alaSearchTargetListResponseMessage != null) {
            if (alaSearchTargetListResponseMessage.hasError() || alaSearchTargetListResponseMessage.getError() != 0) {
                this.gZp.m(alaSearchTargetListResponseMessage.getError(), alaSearchTargetListResponseMessage.getErrorString());
            } else {
                this.gZp.a(alaSearchTargetListResponseMessage.bZm(), alaSearchTargetListResponseMessage.bZn());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeLatestListResponseMessage alaChallengeLatestListResponseMessage) {
        if (this.gZp != null && alaChallengeLatestListResponseMessage != null) {
            if (alaChallengeLatestListResponseMessage.hasError() || alaChallengeLatestListResponseMessage.getError() != 0) {
                this.gZp.aX(alaChallengeLatestListResponseMessage.getError(), alaChallengeLatestListResponseMessage.getErrorString());
            } else {
                this.gZp.cw(alaChallengeLatestListResponseMessage.bZa());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CloseChallengeResponseMessage closeChallengeResponseMessage) {
        if (this.gZp != null && closeChallengeResponseMessage != null) {
            this.gZp.r(!closeChallengeResponseMessage.hasError() && closeChallengeResponseMessage.getError() == 0, closeChallengeResponseMessage.getErrorString());
        }
    }

    private void bZr() {
        this.haB = false;
        MessageManager.getInstance().removeMessage(1021106, this.bmJ);
        this.mHandler.removeCallbacks(this.haE);
        this.hax = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mY(boolean z) {
        this.haB = true;
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.has);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.bmJ);
        MessageManager.getInstance().sendMessage(httpMessage);
        es(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, ExtraParamsManager.getBase64(String.valueOf(this.has)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.gZp != null) {
            this.haB = false;
            String base64 = ExtraParamsManager.getBase64(String.valueOf(this.has));
            String str = "";
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.bYX() != null) {
                str = alaStartDirectChallengeResponseMessage.bYX().aFo + "";
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() != 0) {
                if (this.gZp != null) {
                    this.gZp.aY(alaStartDirectChallengeResponseMessage.getError(), alaStartDirectChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, alaStartDirectChallengeResponseMessage, base64, str);
                return;
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() == 0 && alaStartDirectChallengeResponseMessage.bYX() != null && (alaStartDirectChallengeResponseMessage.bYX().isValid() || alaStartDirectChallengeResponseMessage.bYX().isTimeout())) {
                com.baidu.live.challenge.a bYX = alaStartDirectChallengeResponseMessage.bYX();
                this.gZp.b(bYX);
                bZr();
                if (bYX.CF()) {
                    eT(bYX.challengeId);
                    this.har = bYX.challengeId;
                }
                if (alaStartDirectChallengeResponseMessage.bYX().isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_TIMEOUT, alaStartDirectChallengeResponseMessage, base64, (String) null);
                }
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_SUCC, alaStartDirectChallengeResponseMessage, base64, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.gZp != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.gZp.aZ(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.has)), (String) null);
                return;
            }
            boolean bYZ = alaCancelDirectChallengeResponseMessage.bYZ();
            com.baidu.live.challenge.a bYX = alaCancelDirectChallengeResponseMessage.bYX();
            this.gZp.b(bYZ, alaCancelDirectChallengeResponseMessage.bYX());
            bZr();
            if (!bYZ && bYX != null && bYX.CF()) {
                eT(bYX.challengeId);
                this.har = bYX.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT_SUCC, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.has)), (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.gZp != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.gZp.ba(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.gZp.l(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.bZh());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetQualifyingResultResponseMessage alaGetQualifyingResultResponseMessage) {
        if (this.gZp != null && alaGetQualifyingResultResponseMessage != null) {
            if (alaGetQualifyingResultResponseMessage.hasError() || alaGetQualifyingResultResponseMessage.getError() != 0) {
                this.gZp.bb(alaGetQualifyingResultResponseMessage.getError(), alaGetQualifyingResultResponseMessage.getErrorString());
            } else if (alaGetQualifyingResultResponseMessage.bZj()) {
                this.gZp.d(alaGetQualifyingResultResponseMessage.bZi(), alaGetQualifyingResultResponseMessage.bZk());
            } else {
                this.gZp.d(alaGetQualifyingResultResponseMessage.bZi(), -1L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.gZp != null && alaAcceptDirectChallengeResponseMessage != null) {
            String str = "";
            String str2 = "";
            if (alaAcceptDirectChallengeResponseMessage.bYX() != null) {
                str2 = ExtraParamsManager.getBase64(String.valueOf(alaAcceptDirectChallengeResponseMessage.bYX().aFq));
            }
            if (alaAcceptDirectChallengeResponseMessage.bYX() != null) {
                str = alaAcceptDirectChallengeResponseMessage.bYX().aFo + "";
            }
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.gZp.bc(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, alaAcceptDirectChallengeResponseMessage, str2, str);
                return;
            }
            boolean bYY = alaAcceptDirectChallengeResponseMessage.bYY();
            com.baidu.live.challenge.a bYX = alaAcceptDirectChallengeResponseMessage.bYX();
            this.gZp.c(bYY, bYX);
            if (bYY && bYX != null) {
                eT(bYX.challengeId);
                this.har = bYX.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET_SUCC, alaAcceptDirectChallengeResponseMessage, str2, str);
        }
    }

    private void bZs() {
        this.haA = false;
        MessageManager.getInstance().removeMessage(1021110, this.bmJ);
        this.mHandler.removeCallbacks(this.haF);
        this.hax = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mZ(boolean z) {
        this.haA = true;
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.bmJ);
        MessageManager.getInstance().sendMessage(httpMessage);
        es(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        String str;
        String str2;
        boolean z = false;
        if (this.gZp != null) {
            this.haA = false;
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() != 0) {
                if (this.gZp != null) {
                    this.gZp.bd(alaStartRandomChallengeResponseMessage.getError(), alaStartRandomChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, (String) null, (String) null);
                return;
            }
            if (alaStartRandomChallengeResponseMessage == null || alaStartRandomChallengeResponseMessage.bYX() == null) {
                str = null;
                str2 = null;
            } else {
                str2 = alaStartRandomChallengeResponseMessage.bYX().aFo + "";
                str = ExtraParamsManager.getBase64(alaStartRandomChallengeResponseMessage.bYX().aFq + "");
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.bYX() != null && alaStartRandomChallengeResponseMessage.bYX().isValid()) {
                com.baidu.live.challenge.a bYX = alaStartRandomChallengeResponseMessage.bYX();
                this.gZp.c(bYX);
                if (bYX.CF() && !CT()) {
                    bZs();
                    eT(bYX.challengeId);
                    this.har = bYX.challengeId;
                } else {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, str, str2);
                }
                if (bYX.isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOW_TIMEOUT, alaStartRandomChallengeResponseMessage, str, (String) null);
                }
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.bYX() != null && alaStartRandomChallengeResponseMessage.bYX().isValid()) {
                z = true;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM_SUCC, alaStartRandomChallengeResponseMessage, str, str2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        String str;
        String str2 = null;
        if (this.gZp != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage == null || alaCancelRandomChallengeResponseMessage.bYX() == null) {
                str = null;
            } else {
                str = alaCancelRandomChallengeResponseMessage.bYX().challengeId + "";
                str2 = alaCancelRandomChallengeResponseMessage.bYX().aFo + "";
            }
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.gZp.be(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, alaCancelRandomChallengeResponseMessage, str, str2);
                return;
            }
            boolean bYZ = alaCancelRandomChallengeResponseMessage.bYZ();
            com.baidu.live.challenge.a bYX = alaCancelRandomChallengeResponseMessage.bYX();
            this.gZp.d(bYZ, alaCancelRandomChallengeResponseMessage.bYX());
            bZs();
            if (!bYZ && bYX != null && bYX.CF()) {
                eT(bYX.challengeId);
                this.har = bYX.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCLE_RANDOM_SUCC, alaCancelRandomChallengeResponseMessage, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.gZp != null && alaSurrenderResponseMessage != null) {
            this.gZp.q(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.gZp != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.gZp.l(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.gZp.a(alaGetTargetInfoResponseMessage.bZl());
            }
        }
    }

    public void bn(boolean z) {
        this.bFX = z ? 1 : 2;
    }

    public void eT(long j) {
        this.hav = true;
        this.har = j;
        this.mHandler.post(this.haG);
    }

    private void bZt() {
        this.hav = false;
        this.mHandler.removeCallbacks(this.haG);
        this.haz = false;
        MessageManager.getInstance().removeMessage(1021112, this.bmJ);
    }

    public void bZu() {
        this.mHandler.removeCallbacks(this.haG);
        this.haz = false;
        MessageManager.getInstance().removeMessage(1021112, this.bmJ);
    }

    public void bZv() {
        this.mHandler.post(this.haG);
    }

    private void a(az azVar, bd bdVar, bd bdVar2, long j) {
        if (azVar == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info challenge meta is null?? logid=" + j);
        } else if (bdVar != null && bdVar.aMY != null && bdVar.aMY.getLiveID() != this.fYO) {
            BdLog.e("CHALLENGE_TAG in challenge not current live?? ||Challenge id=" + azVar.challengeId + "||Challenge Status=" + azVar.aMM + "||Net liveId=" + bdVar.aMY.getLiveID() + "||cur liveId=" + this.fYO + "||logid=" + j);
        } else {
            int i = azVar.aMM;
            this.gZp.b(i, azVar, bdVar, bdVar2);
            switch (i) {
                case 2:
                    this.hax = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    bZo();
                    break;
                case 3:
                    this.hax = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.hax = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.har = 0L;
                    bZp();
                    break;
            }
            if (bdVar != null && bdVar.aMK != null) {
                this.hat = bdVar.aMK.userId;
            }
            if (bdVar2 != null && bdVar2.aMK != null) {
                this.hau = bdVar2.aMK.userId;
            }
            if (4 == azVar.aMM || 5 == azVar.aMM) {
                bZt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.gZp == null || alaGetChallengeInfoResponseMessage == null || alaGetChallengeInfoResponseMessage.bZb() == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info callback, response message, meta info  null?? ");
            if (alaGetChallengeInfoResponseMessage != null) {
                BdLog.e("CHALLENGE_TAG get Challenge Info error=" + alaGetChallengeInfoResponseMessage.getError());
                return;
            }
            return;
        }
        az bZb = alaGetChallengeInfoResponseMessage.bZb();
        bd bZc = alaGetChallengeInfoResponseMessage.bZc();
        bd bZd = alaGetChallengeInfoResponseMessage.bZd();
        av bZe = alaGetChallengeInfoResponseMessage.bZe();
        bb bZf = alaGetChallengeInfoResponseMessage.bZf();
        bc bZg = alaGetChallengeInfoResponseMessage.bZg();
        if (bZe != null && bZe.aMG > 0 && this.haq != bZe.aMG) {
            this.haq = bZe.aMG;
        }
        a(bZb, bZc, bZd, alaGetChallengeInfoResponseMessage.getLogId());
        int i = 0;
        if (com.baidu.live.aa.a.Ph().bms != null) {
            i = com.baidu.live.aa.a.Ph().bms.aKH;
        }
        if (i == 1 && bZb != null && bZc != null && bZc.aMY != null && bZc.aMY.user_id == TbadkCoreApplication.getCurrentAccountId()) {
            if (this.haC == null) {
                this.haC = new HashMap();
            }
            long j = bZb.challengeId;
            if (bZg != null && bZg.aMX != null && !bZg.aMX.isEmpty() && (!this.haC.containsKey(Long.valueOf(j)) || this.haC.get(Long.valueOf(j)).isEmpty())) {
                this.haC.put(Long.valueOf(j), bZg.aMX);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913209, bZg.aMX));
            }
            if (bZf != null && bZb.aMM >= 3 && bZb.challengeResult == 2) {
                if ((bZf.type == 1 || bZf.type == 3) && !TextUtils.isEmpty(bZf.aMV)) {
                    if (this.haD == null) {
                        this.haD = new HashMap();
                    }
                    if (!this.haD.containsKey(Long.valueOf(j))) {
                        this.haD.put(Long.valueOf(j), 0);
                    }
                    if (bZb.aMM == 3) {
                        int intValue = this.haD.get(Long.valueOf(j)).intValue();
                        if (bZf.serverTime >= bZf.startTime && bZf.serverTime <= bZf.endTime) {
                            if (intValue < 1) {
                                this.haD.put(Long.valueOf(j), 1);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913210, bZf.aMV));
                            }
                        } else if (bZf.serverTime > bZf.endTime && intValue < 2) {
                            this.haD.put(Long.valueOf(j), 2);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                        }
                    } else if (bZb.aMM > 3) {
                        this.haD.put(Long.valueOf(j), 2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                    }
                }
            }
        }
    }

    public ChallenfeInfoData.ChallengeStatus CS() {
        return this.hax;
    }

    private void es(String str, String str2) {
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

    private UbcStatisticItem x(String str, String str2, String str3, String str4) {
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

    public boolean CT() {
        return this.hav;
    }
}
