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
import com.baidu.live.data.at;
import com.baidu.live.data.ax;
import com.baidu.live.data.az;
import com.baidu.live.data.ba;
import com.baidu.live.data.bb;
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
    private int bBC;
    private BdUniqueId bnb;
    private long fTr;
    private a gTD;
    private long gUD;
    private long gUE;
    private long gUF;
    private long gUG;
    private long gUH;
    private long gUI;
    private long gUJ;
    private long gUL;
    private ChallenfeInfoData.ChallengeStatus gUM;
    private i.f gUN;
    private int gUl;
    private boolean isHost;
    private TbPageContext mPageContext;
    private boolean gUK = false;
    private boolean gUO = false;
    private boolean gUP = false;
    private boolean gUQ = false;
    private HttpMessageListener bDQ = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.1
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
    private HttpMessageListener bgV = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                b.this.gUO = false;
                if (!b.this.gTD.bWQ()) {
                    b.this.b((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                    b.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                }
            }
        }
    };
    private Runnable gUT = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.gUQ) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.gUE);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, b.this.bnb);
            b.this.mO(false);
            b.this.mHandler.postDelayed(this, b.this.gUE);
        }
    };
    private Runnable gUU = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.4
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.gUP) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.gUD);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, b.this.bnb);
            b.this.mP(false);
            b.this.mHandler.postDelayed(this, b.this.gUD);
        }
    };
    private Runnable gUV = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.5
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.gUG <= 0) {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().removeMessage(1021112, b.this.bnb);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            if (b.this.gUO) {
                b.this.mHandler.postDelayed(this, b.this.gUF);
                return;
            }
            MessageManager.getInstance().removeMessage(1021112, b.this.bnb);
            if (b.this.gUN != null) {
                b.this.gUl = b.this.gUN.Dn();
            }
            b.this.gUO = true;
            com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(b.this.gUG, b.this.bBC, b.this.fTr, b.this.gUL, b.this.gUl);
            aVar.setTag(b.this.bnb);
            MessageManager.getInstance().sendMessage(aVar);
            if (b.this.isHost) {
                UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_REQ, UbcStatConstant.ContentType.UBC_TYPE_PK_CHALLENGE_INFO, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("avts_conn", b.this.bBC);
                    jSONObject2.put("avts_fail", b.this.gUl);
                    jSONObject2.put("chat_id", b.this.gUG);
                    jSONObject.put("pk", jSONObject2);
                } catch (JSONException e) {
                }
                ubcStatisticItem.setContentExt(jSONObject);
                UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
            }
            b.this.mHandler.postDelayed(this, b.this.gUF);
        }
    };
    private Handler mHandler = new Handler();
    private Map<Long, List<Long>> gUR = new HashMap();
    private Map<Long, Integer> gUS = new HashMap();

    /* loaded from: classes4.dex */
    public interface a {
        void Do();

        void a(com.baidu.live.challenge.b bVar, List<d> list);

        void a(d dVar);

        void aV(int i, String str);

        void aW(int i, String str);

        void aX(int i, String str);

        void aY(int i, String str);

        void aZ(int i, String str);

        void b(int i, ax axVar, bb bbVar, bb bbVar2);

        void b(com.baidu.live.challenge.a aVar);

        void b(boolean z, com.baidu.live.challenge.a aVar);

        boolean bWQ();

        void ba(int i, String str);

        void bb(int i, String str);

        void bc(int i, String str);

        void c(com.baidu.live.challenge.a aVar);

        void c(boolean z, com.baidu.live.challenge.a aVar);

        void co(List<d> list);

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
                jSONObject2.put("avts_conn", this.bBC);
                jSONObject2.put("avts_fail", this.gUl);
                if (alaGetChallengeInfoResponseMessage.bXg() != null) {
                    jSONObject2.put("chat_id", alaGetChallengeInfoResponseMessage.bXg().challengeId);
                    jSONObject2.put("chat_status", alaGetChallengeInfoResponseMessage.bXg().aNu);
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
        this.bnb = bdUniqueId;
        this.gUD = com.baidu.live.z.a.Pq().bmJ.aLk > 0 ? com.baidu.live.z.a.Pq().bmJ.aLk : 1000L;
        this.gUE = com.baidu.live.z.a.Pq().bmJ.aLl > 0 ? com.baidu.live.z.a.Pq().bmJ.aLl : 1000L;
        this.gUF = com.baidu.live.z.a.Pq().bmJ.aLm > 0 ? com.baidu.live.z.a.Pq().bmJ.aLm : 1000L;
        this.gUM = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        registerTask();
        registerListener();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public void e(long j, long j2) {
        this.fTr = j;
        this.gUL = j2;
    }

    public void a(a aVar) {
        this.gTD = aVar;
    }

    public void b(i.f fVar) {
        this.gUN = fVar;
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
        MessageManager.getInstance().registerListener(1021183, this.bDQ);
        MessageManager.getInstance().registerListener(1021105, this.bDQ);
        MessageManager.getInstance().registerListener(1021182, this.bDQ);
        MessageManager.getInstance().registerListener(1021203, this.bDQ);
        MessageManager.getInstance().registerListener(1021106, this.bDQ);
        MessageManager.getInstance().registerListener(1021107, this.bDQ);
        MessageManager.getInstance().registerListener(1021108, this.bDQ);
        MessageManager.getInstance().registerListener(1021109, this.bDQ);
        MessageManager.getInstance().registerListener(1021110, this.bDQ);
        MessageManager.getInstance().registerListener(1021111, this.bDQ);
        MessageManager.getInstance().registerListener(1021115, this.bDQ);
        MessageManager.getInstance().registerListener(1021116, this.bDQ);
        MessageManager.getInstance().registerListener(1021197, this.bDQ);
        MessageManager.getInstance().registerListener(this.bgV);
        MessageManager.getInstance().registerListener(1021209, this.bDQ);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bDQ);
        MessageManager.getInstance().unRegisterListener(this.bgV);
    }

    private void bXt() {
        MessageManager.getInstance().removeMessage(1021183, this.bnb);
        MessageManager.getInstance().removeMessage(1021105, this.bnb);
        MessageManager.getInstance().removeMessage(1021182, this.bnb);
        MessageManager.getInstance().removeMessage(1021203, this.bnb);
        MessageManager.getInstance().removeMessage(1021106, this.bnb);
        MessageManager.getInstance().removeMessage(1021107, this.bnb);
        MessageManager.getInstance().removeMessage(1021108, this.bnb);
        MessageManager.getInstance().removeMessage(1021109, this.bnb);
        MessageManager.getInstance().removeMessage(1021110, this.bnb);
        MessageManager.getInstance().removeMessage(1021111, this.bnb);
        MessageManager.getInstance().removeMessage(1021116, this.bnb);
        MessageManager.getInstance().removeMessage(1021209, this.bnb);
    }

    private void bXu() {
        MessageManager.getInstance().removeMessage(1021112, this.bnb);
        MessageManager.getInstance().removeMessage(1021115, this.bnb);
    }

    private void reset() {
        this.gUG = 0L;
        this.gUH = 0L;
        this.bBC = 0;
        this.gUl = 0;
        this.gUI = 0L;
        this.gUJ = 0L;
        bXx();
        bXw();
        bXy();
        this.mHandler.removeCallbacksAndMessages(null);
        bXt();
        bXu();
    }

    public void bXv() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long Dl() {
        return this.gUG;
    }

    public void De() {
        HttpMessage httpMessage = new HttpMessage(1021183);
        httpMessage.setTag(this.bnb);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void HB(String str) {
        HttpMessage httpMessage = new HttpMessage(1021209);
        httpMessage.addParam("user_id", str);
        httpMessage.setTag(this.bnb);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void w(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.bnb);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void g(int i, int i2, String str) {
        HttpMessage httpMessage = new HttpMessage(1021182);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.addParam("query_words", str);
        httpMessage.setTag(this.bnb);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void ge(String str) {
        HttpMessage httpMessage = new HttpMessage(1021203);
        httpMessage.setTag(this.bnb);
        httpMessage.addParam("anchor_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void X(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.bnb);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void Y(long j) {
        this.gUG = 0L;
        this.gUH = j;
        this.gUM = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        mO(true);
        this.mHandler.postDelayed(this.gUT, 1000L);
    }

    public void Z(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.bnb);
        MessageManager.getInstance().sendMessage(httpMessage);
        es(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void Df() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.bnb);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void aa(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.bnb);
        MessageManager.getInstance().sendMessage(httpMessage);
        es(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void Dg() {
        this.gUG = 0L;
        this.gUM = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        mP(true);
        this.mHandler.postDelayed(this.gUU, 1000L);
    }

    public void Dh() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.bnb);
        MessageManager.getInstance().sendMessage(httpMessage);
        es(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, null);
    }

    public void Dk() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.gUG);
        httpMessage.setTag(this.bnb);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void Dm() {
        HttpMessage httpMessage = new HttpMessage(1021197);
        httpMessage.addParam("challenge_id", this.gUG);
        httpMessage.setTag(this.bnb);
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
        if (alaChallengeSwitchResponsedMessage != null && this.gTD != null) {
            if (alaChallengeSwitchResponsedMessage.hasError() || alaChallengeSwitchResponsedMessage.getError() != 0) {
                this.gTD.p(alaChallengeSwitchResponsedMessage.getError(), alaChallengeSwitchResponsedMessage.getErrorString());
            } else {
                this.gTD.Do();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.gTD != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.gTD.m(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.gTD.a(alaGetTargetListResponseMessage.bXr(), alaGetTargetListResponseMessage.bXs());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSearchTargetListResponseMessage alaSearchTargetListResponseMessage) {
        if (this.gTD != null && alaSearchTargetListResponseMessage != null) {
            if (alaSearchTargetListResponseMessage.hasError() || alaSearchTargetListResponseMessage.getError() != 0) {
                this.gTD.m(alaSearchTargetListResponseMessage.getError(), alaSearchTargetListResponseMessage.getErrorString());
            } else {
                this.gTD.a(alaSearchTargetListResponseMessage.bXr(), alaSearchTargetListResponseMessage.bXs());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeLatestListResponseMessage alaChallengeLatestListResponseMessage) {
        if (this.gTD != null && alaChallengeLatestListResponseMessage != null) {
            if (alaChallengeLatestListResponseMessage.hasError() || alaChallengeLatestListResponseMessage.getError() != 0) {
                this.gTD.aV(alaChallengeLatestListResponseMessage.getError(), alaChallengeLatestListResponseMessage.getErrorString());
            } else {
                this.gTD.co(alaChallengeLatestListResponseMessage.bXf());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CloseChallengeResponseMessage closeChallengeResponseMessage) {
        if (this.gTD != null && closeChallengeResponseMessage != null) {
            this.gTD.q(!closeChallengeResponseMessage.hasError() && closeChallengeResponseMessage.getError() == 0, closeChallengeResponseMessage.getErrorString());
        }
    }

    private void bXw() {
        this.gUQ = false;
        MessageManager.getInstance().removeMessage(1021106, this.bnb);
        this.mHandler.removeCallbacks(this.gUT);
        this.gUM = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mO(boolean z) {
        this.gUQ = true;
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.gUH);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.bnb);
        MessageManager.getInstance().sendMessage(httpMessage);
        es(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, ExtraParamsManager.getBase64(String.valueOf(this.gUH)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.gTD != null) {
            this.gUQ = false;
            String base64 = ExtraParamsManager.getBase64(String.valueOf(this.gUH));
            String str = "";
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.bXc() != null) {
                str = alaStartDirectChallengeResponseMessage.bXc().aGj + "";
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() != 0) {
                if (this.gTD != null) {
                    this.gTD.aW(alaStartDirectChallengeResponseMessage.getError(), alaStartDirectChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, alaStartDirectChallengeResponseMessage, base64, str);
                return;
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() == 0 && alaStartDirectChallengeResponseMessage.bXc() != null && (alaStartDirectChallengeResponseMessage.bXc().isValid() || alaStartDirectChallengeResponseMessage.bXc().isTimeout())) {
                com.baidu.live.challenge.a bXc = alaStartDirectChallengeResponseMessage.bXc();
                this.gTD.b(bXc);
                bXw();
                if (bXc.CV()) {
                    ex(bXc.challengeId);
                    this.gUG = bXc.challengeId;
                }
                if (alaStartDirectChallengeResponseMessage.bXc().isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_TIMEOUT, alaStartDirectChallengeResponseMessage, base64, (String) null);
                }
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_SUCC, alaStartDirectChallengeResponseMessage, base64, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.gTD != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.gTD.aX(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.gUH)), (String) null);
                return;
            }
            boolean bXe = alaCancelDirectChallengeResponseMessage.bXe();
            com.baidu.live.challenge.a bXc = alaCancelDirectChallengeResponseMessage.bXc();
            this.gTD.b(bXe, alaCancelDirectChallengeResponseMessage.bXc());
            bXw();
            if (!bXe && bXc != null && bXc.CV()) {
                ex(bXc.challengeId);
                this.gUG = bXc.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT_SUCC, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.gUH)), (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.gTD != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.gTD.aY(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.gTD.l(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.bXm());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetQualifyingResultResponseMessage alaGetQualifyingResultResponseMessage) {
        if (this.gTD != null && alaGetQualifyingResultResponseMessage != null) {
            if (alaGetQualifyingResultResponseMessage.hasError() || alaGetQualifyingResultResponseMessage.getError() != 0) {
                this.gTD.aZ(alaGetQualifyingResultResponseMessage.getError(), alaGetQualifyingResultResponseMessage.getErrorString());
            } else if (alaGetQualifyingResultResponseMessage.bXo()) {
                this.gTD.d(alaGetQualifyingResultResponseMessage.bXn(), alaGetQualifyingResultResponseMessage.bXp());
            } else {
                this.gTD.d(alaGetQualifyingResultResponseMessage.bXn(), -1L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.gTD != null && alaAcceptDirectChallengeResponseMessage != null) {
            String str = "";
            String str2 = "";
            if (alaAcceptDirectChallengeResponseMessage.bXc() != null) {
                str2 = ExtraParamsManager.getBase64(String.valueOf(alaAcceptDirectChallengeResponseMessage.bXc().aGl));
            }
            if (alaAcceptDirectChallengeResponseMessage.bXc() != null) {
                str = alaAcceptDirectChallengeResponseMessage.bXc().aGj + "";
            }
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.gTD.ba(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, alaAcceptDirectChallengeResponseMessage, str2, str);
                return;
            }
            boolean bXd = alaAcceptDirectChallengeResponseMessage.bXd();
            com.baidu.live.challenge.a bXc = alaAcceptDirectChallengeResponseMessage.bXc();
            this.gTD.c(bXd, bXc);
            if (bXd && bXc != null) {
                ex(bXc.challengeId);
                this.gUG = bXc.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET_SUCC, alaAcceptDirectChallengeResponseMessage, str2, str);
        }
    }

    private void bXx() {
        this.gUP = false;
        MessageManager.getInstance().removeMessage(1021110, this.bnb);
        this.mHandler.removeCallbacks(this.gUU);
        this.gUM = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mP(boolean z) {
        this.gUP = true;
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.bnb);
        MessageManager.getInstance().sendMessage(httpMessage);
        es(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        String str;
        String str2;
        boolean z = false;
        if (this.gTD != null) {
            this.gUP = false;
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() != 0) {
                if (this.gTD != null) {
                    this.gTD.bb(alaStartRandomChallengeResponseMessage.getError(), alaStartRandomChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, (String) null, (String) null);
                return;
            }
            if (alaStartRandomChallengeResponseMessage == null || alaStartRandomChallengeResponseMessage.bXc() == null) {
                str = null;
                str2 = null;
            } else {
                str2 = alaStartRandomChallengeResponseMessage.bXc().aGj + "";
                str = ExtraParamsManager.getBase64(alaStartRandomChallengeResponseMessage.bXc().aGl + "");
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.bXc() != null && alaStartRandomChallengeResponseMessage.bXc().isValid()) {
                com.baidu.live.challenge.a bXc = alaStartRandomChallengeResponseMessage.bXc();
                this.gTD.c(bXc);
                if (bXc.CV() && !Dj()) {
                    bXx();
                    ex(bXc.challengeId);
                    this.gUG = bXc.challengeId;
                } else {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, str, str2);
                }
                if (bXc.isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOW_TIMEOUT, alaStartRandomChallengeResponseMessage, str, (String) null);
                }
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.bXc() != null && alaStartRandomChallengeResponseMessage.bXc().isValid()) {
                z = true;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM_SUCC, alaStartRandomChallengeResponseMessage, str, str2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        String str;
        String str2 = null;
        if (this.gTD != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage == null || alaCancelRandomChallengeResponseMessage.bXc() == null) {
                str = null;
            } else {
                str = alaCancelRandomChallengeResponseMessage.bXc().challengeId + "";
                str2 = alaCancelRandomChallengeResponseMessage.bXc().aGj + "";
            }
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.gTD.bc(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, alaCancelRandomChallengeResponseMessage, str, str2);
                return;
            }
            boolean bXe = alaCancelRandomChallengeResponseMessage.bXe();
            com.baidu.live.challenge.a bXc = alaCancelRandomChallengeResponseMessage.bXc();
            this.gTD.d(bXe, alaCancelRandomChallengeResponseMessage.bXc());
            bXx();
            if (!bXe && bXc != null && bXc.CV()) {
                ex(bXc.challengeId);
                this.gUG = bXc.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCLE_RANDOM_SUCC, alaCancelRandomChallengeResponseMessage, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.gTD != null && alaSurrenderResponseMessage != null) {
            this.gTD.p(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.gTD != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.gTD.l(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.gTD.a(alaGetTargetInfoResponseMessage.bXq());
            }
        }
    }

    public void bk(boolean z) {
        this.bBC = z ? 1 : 2;
    }

    public void ex(long j) {
        this.gUK = true;
        this.gUG = j;
        this.mHandler.post(this.gUV);
    }

    private void bXy() {
        this.gUK = false;
        this.mHandler.removeCallbacks(this.gUV);
        this.gUO = false;
        MessageManager.getInstance().removeMessage(1021112, this.bnb);
    }

    public void bXz() {
        this.mHandler.removeCallbacks(this.gUV);
        this.gUO = false;
        MessageManager.getInstance().removeMessage(1021112, this.bnb);
    }

    public void bXA() {
        this.mHandler.post(this.gUV);
    }

    private void a(ax axVar, bb bbVar, bb bbVar2, long j) {
        if (axVar == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info challenge meta is null?? logid=" + j);
        } else if (bbVar != null && bbVar.aNG != null && bbVar.aNG.getLiveID() != this.fTr) {
            BdLog.e("CHALLENGE_TAG in challenge not current live?? ||Challenge id=" + axVar.challengeId + "||Challenge Status=" + axVar.aNu + "||Net liveId=" + bbVar.aNG.getLiveID() + "||cur liveId=" + this.fTr + "||logid=" + j);
        } else {
            int i = axVar.aNu;
            this.gTD.b(i, axVar, bbVar, bbVar2);
            switch (i) {
                case 2:
                    this.gUM = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    bXt();
                    break;
                case 3:
                    this.gUM = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.gUM = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.gUG = 0L;
                    bXu();
                    break;
            }
            if (bbVar != null && bbVar.aNs != null) {
                this.gUI = bbVar.aNs.userId;
            }
            if (bbVar2 != null && bbVar2.aNs != null) {
                this.gUJ = bbVar2.aNs.userId;
            }
            if (4 == axVar.aNu || 5 == axVar.aNu) {
                bXy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.gTD == null || alaGetChallengeInfoResponseMessage == null || alaGetChallengeInfoResponseMessage.bXg() == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info callback, response message, meta info  null?? ");
            if (alaGetChallengeInfoResponseMessage != null) {
                BdLog.e("CHALLENGE_TAG get Challenge Info error=" + alaGetChallengeInfoResponseMessage.getError());
                return;
            }
            return;
        }
        ax bXg = alaGetChallengeInfoResponseMessage.bXg();
        bb bXh = alaGetChallengeInfoResponseMessage.bXh();
        bb bXi = alaGetChallengeInfoResponseMessage.bXi();
        at bXj = alaGetChallengeInfoResponseMessage.bXj();
        az bXk = alaGetChallengeInfoResponseMessage.bXk();
        ba bXl = alaGetChallengeInfoResponseMessage.bXl();
        if (bXj != null && bXj.aNo > 0 && this.gUF != bXj.aNo) {
            this.gUF = bXj.aNo;
        }
        a(bXg, bXh, bXi, alaGetChallengeInfoResponseMessage.getLogId());
        int i = 0;
        if (com.baidu.live.z.a.Pq().bmJ != null) {
            i = com.baidu.live.z.a.Pq().bmJ.aLs;
        }
        if (i == 1 && bXg != null && bXh != null && bXh.aNG != null && bXh.aNG.user_id == TbadkCoreApplication.getCurrentAccountId()) {
            if (this.gUR == null) {
                this.gUR = new HashMap();
            }
            long j = bXg.challengeId;
            if (bXl != null && bXl.aNF != null && !bXl.aNF.isEmpty() && (!this.gUR.containsKey(Long.valueOf(j)) || this.gUR.get(Long.valueOf(j)).isEmpty())) {
                this.gUR.put(Long.valueOf(j), bXl.aNF);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913209, bXl.aNF));
            }
            if (bXk != null && bXg.aNu >= 3 && bXg.challengeResult == 2) {
                if ((bXk.type == 1 || bXk.type == 3) && !TextUtils.isEmpty(bXk.aND)) {
                    if (this.gUS == null) {
                        this.gUS = new HashMap();
                    }
                    if (!this.gUS.containsKey(Long.valueOf(j))) {
                        this.gUS.put(Long.valueOf(j), 0);
                    }
                    if (bXg.aNu == 3) {
                        int intValue = this.gUS.get(Long.valueOf(j)).intValue();
                        if (bXk.serverTime >= bXk.startTime && bXk.serverTime <= bXk.endTime) {
                            if (intValue < 1) {
                                this.gUS.put(Long.valueOf(j), 1);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913210, bXk.aND));
                            }
                        } else if (bXk.serverTime > bXk.endTime && intValue < 2) {
                            this.gUS.put(Long.valueOf(j), 2);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                        }
                    } else if (bXg.aNu > 3) {
                        this.gUS.put(Long.valueOf(j), 2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                    }
                }
            }
        }
    }

    public ChallenfeInfoData.ChallengeStatus Di() {
        return this.gUM;
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

    public boolean Dj() {
        return this.gUK;
    }
}
