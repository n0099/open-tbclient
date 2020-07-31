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
import com.baidu.live.data.aj;
import com.baidu.live.data.an;
import com.baidu.live.data.ap;
import com.baidu.live.data.aq;
import com.baidu.live.data.ar;
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
/* loaded from: classes4.dex */
public class b {
    private BdUniqueId aZB;
    private int blG;
    private long fkg;
    private a gdQ;
    private long geL;
    private long geM;
    private long geN;
    private long geO;
    private long geP;
    private long geQ;
    private long geR;
    private long geT;
    private ChallenfeInfoData.ChallengeStatus geU;
    private i.f geV;
    private int gey;
    private boolean isHost;
    private TbPageContext mPageContext;
    private boolean geS = false;
    private boolean geW = false;
    private boolean geX = false;
    private boolean geY = false;
    private HttpMessageListener bmr = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.1
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
    private HttpMessageListener aUg = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                b.this.geW = false;
                b.this.b((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                b.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable gfb = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.geY) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.geM);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, b.this.aZB);
            b.this.lr(false);
            b.this.mHandler.postDelayed(this, b.this.geM);
        }
    };
    private Runnable gfc = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.4
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.geX) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.geL);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, b.this.aZB);
            b.this.ls(false);
            b.this.mHandler.postDelayed(this, b.this.geL);
        }
    };
    private Runnable gfd = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.5
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.geO <= 0) {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().removeMessage(1021112, b.this.aZB);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            if (b.this.geW) {
                b.this.mHandler.postDelayed(this, b.this.geN);
                return;
            }
            MessageManager.getInstance().removeMessage(1021112, b.this.aZB);
            if (b.this.geV != null) {
                b.this.gey = b.this.geV.ww();
            }
            b.this.geW = true;
            com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(b.this.geO, b.this.blG, b.this.fkg, b.this.geT, b.this.gey);
            aVar.setTag(b.this.aZB);
            MessageManager.getInstance().sendMessage(aVar);
            if (b.this.isHost) {
                UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_REQ, UbcStatConstant.ContentType.UBC_TYPE_PK_CHALLENGE_INFO, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("avts_conn", b.this.blG);
                    jSONObject2.put("avts_fail", b.this.gey);
                    jSONObject2.put("chat_id", b.this.geO);
                    jSONObject.put("pk", jSONObject2);
                } catch (JSONException e) {
                }
                ubcStatisticItem.setContentExt(jSONObject);
                UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
            }
            b.this.mHandler.postDelayed(this, b.this.geN);
        }
    };
    private Handler mHandler = new Handler();
    private Map<Long, List<Long>> geZ = new HashMap();
    private Map<Long, Integer> gfa = new HashMap();

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.live.challenge.b bVar, List<d> list);

        void a(d dVar);

        void aM(int i, String str);

        void aN(int i, String str);

        void aO(int i, String str);

        void aP(int i, String str);

        void aQ(int i, String str);

        void aR(int i, String str);

        void aS(int i, String str);

        void b(int i, an anVar, ar arVar, ar arVar2);

        void b(com.baidu.live.challenge.a aVar);

        void b(boolean z, com.baidu.live.challenge.a aVar);

        void bV(List<d> list);

        void c(com.baidu.live.challenge.a aVar);

        void c(boolean z, com.baidu.live.challenge.a aVar);

        void d(boolean z, com.baidu.live.challenge.a aVar);

        void k(int i, String str);

        void l(int i, String str);

        void l(int i, List<d> list);

        void m(boolean z, String str);

        void n(boolean z, String str);

        void o(int i, String str);

        void wx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        UbcStatisticItem ubcStatisticItem;
        if (alaGetChallengeInfoResponseMessage != null && this.isHost) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("avts_conn", this.blG);
                jSONObject2.put("avts_fail", this.gey);
                if (alaGetChallengeInfoResponseMessage.bFS() != null) {
                    jSONObject2.put("chat_id", alaGetChallengeInfoResponseMessage.bFS().challengeId);
                    jSONObject2.put("chat_status", alaGetChallengeInfoResponseMessage.bFS().aDd);
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
        this.aZB = bdUniqueId;
        this.geL = com.baidu.live.v.a.Hs().aZn.aBd > 0 ? com.baidu.live.v.a.Hs().aZn.aBd : 1000L;
        this.geM = com.baidu.live.v.a.Hs().aZn.aBe > 0 ? com.baidu.live.v.a.Hs().aZn.aBe : 1000L;
        this.geN = com.baidu.live.v.a.Hs().aZn.aBf > 0 ? com.baidu.live.v.a.Hs().aZn.aBf : 1000L;
        this.geU = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        registerTask();
        registerListener();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public void e(long j, long j2) {
        this.fkg = j;
        this.geT = j2;
    }

    public void a(a aVar) {
        this.gdQ = aVar;
    }

    public void b(i.f fVar) {
        this.geV = fVar;
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
        MessageManager.getInstance().registerListener(1021183, this.bmr);
        MessageManager.getInstance().registerListener(1021105, this.bmr);
        MessageManager.getInstance().registerListener(1021182, this.bmr);
        MessageManager.getInstance().registerListener(1021203, this.bmr);
        MessageManager.getInstance().registerListener(1021106, this.bmr);
        MessageManager.getInstance().registerListener(1021107, this.bmr);
        MessageManager.getInstance().registerListener(1021108, this.bmr);
        MessageManager.getInstance().registerListener(1021109, this.bmr);
        MessageManager.getInstance().registerListener(1021110, this.bmr);
        MessageManager.getInstance().registerListener(1021111, this.bmr);
        MessageManager.getInstance().registerListener(1021115, this.bmr);
        MessageManager.getInstance().registerListener(1021116, this.bmr);
        MessageManager.getInstance().registerListener(1021197, this.bmr);
        MessageManager.getInstance().registerListener(this.aUg);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bmr);
        MessageManager.getInstance().unRegisterListener(this.aUg);
    }

    private void bGc() {
        MessageManager.getInstance().removeMessage(1021183, this.aZB);
        MessageManager.getInstance().removeMessage(1021105, this.aZB);
        MessageManager.getInstance().removeMessage(1021182, this.aZB);
        MessageManager.getInstance().removeMessage(1021203, this.aZB);
        MessageManager.getInstance().removeMessage(1021106, this.aZB);
        MessageManager.getInstance().removeMessage(1021107, this.aZB);
        MessageManager.getInstance().removeMessage(1021108, this.aZB);
        MessageManager.getInstance().removeMessage(1021109, this.aZB);
        MessageManager.getInstance().removeMessage(1021110, this.aZB);
        MessageManager.getInstance().removeMessage(1021111, this.aZB);
        MessageManager.getInstance().removeMessage(1021116, this.aZB);
    }

    private void bGd() {
        MessageManager.getInstance().removeMessage(1021112, this.aZB);
        MessageManager.getInstance().removeMessage(1021115, this.aZB);
    }

    private void reset() {
        this.geO = 0L;
        this.geP = 0L;
        this.blG = 0;
        this.gey = 0;
        this.geQ = 0L;
        this.geR = 0L;
        bGg();
        bGf();
        bGh();
        this.mHandler.removeCallbacksAndMessages(null);
        bGc();
        bGd();
    }

    public void bGe() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long wu() {
        return this.geO;
    }

    public void wn() {
        HttpMessage httpMessage = new HttpMessage(1021183);
        httpMessage.setTag(this.aZB);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void t(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.aZB);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void e(int i, int i2, String str) {
        HttpMessage httpMessage = new HttpMessage(1021182);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.addParam("query_words", str);
        httpMessage.setTag(this.aZB);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void er(String str) {
        HttpMessage httpMessage = new HttpMessage(1021203);
        httpMessage.setTag(this.aZB);
        httpMessage.addParam("anchor_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void V(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.aZB);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void W(long j) {
        this.geO = 0L;
        this.geP = j;
        this.geU = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        lr(true);
        this.mHandler.postDelayed(this.gfb, 1000L);
    }

    public void X(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.aZB);
        MessageManager.getInstance().sendMessage(httpMessage);
        dK(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void wo() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.aZB);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void Y(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.aZB);
        MessageManager.getInstance().sendMessage(httpMessage);
        dK(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void wp() {
        this.geO = 0L;
        this.geU = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        ls(true);
        this.mHandler.postDelayed(this.gfc, 1000L);
    }

    public void wq() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.aZB);
        MessageManager.getInstance().sendMessage(httpMessage);
        dK(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, null);
    }

    public void wt() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.geO);
        httpMessage.setTag(this.aZB);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void wv() {
        HttpMessage httpMessage = new HttpMessage(1021197);
        httpMessage.addParam("challenge_id", this.geO);
        httpMessage.setTag(this.aZB);
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
        if (alaChallengeSwitchResponsedMessage != null && this.gdQ != null) {
            if (alaChallengeSwitchResponsedMessage.hasError() || alaChallengeSwitchResponsedMessage.getError() != 0) {
                this.gdQ.o(alaChallengeSwitchResponsedMessage.getError(), alaChallengeSwitchResponsedMessage.getErrorString());
            } else {
                this.gdQ.wx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.gdQ != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.gdQ.l(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.gdQ.a(alaGetTargetListResponseMessage.bGa(), alaGetTargetListResponseMessage.bGb());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSearchTargetListResponseMessage alaSearchTargetListResponseMessage) {
        if (this.gdQ != null && alaSearchTargetListResponseMessage != null) {
            if (alaSearchTargetListResponseMessage.hasError() || alaSearchTargetListResponseMessage.getError() != 0) {
                this.gdQ.l(alaSearchTargetListResponseMessage.getError(), alaSearchTargetListResponseMessage.getErrorString());
            } else {
                this.gdQ.a(alaSearchTargetListResponseMessage.bGa(), alaSearchTargetListResponseMessage.bGb());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeLatestListResponseMessage alaChallengeLatestListResponseMessage) {
        if (this.gdQ != null && alaChallengeLatestListResponseMessage != null) {
            if (alaChallengeLatestListResponseMessage.hasError() || alaChallengeLatestListResponseMessage.getError() != 0) {
                this.gdQ.aM(alaChallengeLatestListResponseMessage.getError(), alaChallengeLatestListResponseMessage.getErrorString());
            } else {
                this.gdQ.bV(alaChallengeLatestListResponseMessage.bFR());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CloseChallengeResponseMessage closeChallengeResponseMessage) {
        if (this.gdQ != null && closeChallengeResponseMessage != null) {
            this.gdQ.n(!closeChallengeResponseMessage.hasError() && closeChallengeResponseMessage.getError() == 0, closeChallengeResponseMessage.getErrorString());
        }
    }

    private void bGf() {
        this.geY = false;
        MessageManager.getInstance().removeMessage(1021106, this.aZB);
        this.mHandler.removeCallbacks(this.gfb);
        this.geU = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lr(boolean z) {
        this.geY = true;
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.geP);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.aZB);
        MessageManager.getInstance().sendMessage(httpMessage);
        dK(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, ExtraParamsManager.getBase64(String.valueOf(this.geP)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.gdQ != null) {
            this.geY = false;
            String base64 = ExtraParamsManager.getBase64(String.valueOf(this.geP));
            String str = "";
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.bFO() != null) {
                str = alaStartDirectChallengeResponseMessage.bFO().axj + "";
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() != 0) {
                if (this.gdQ != null) {
                    this.gdQ.aN(alaStartDirectChallengeResponseMessage.getError(), alaStartDirectChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, alaStartDirectChallengeResponseMessage, base64, str);
                return;
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() == 0 && alaStartDirectChallengeResponseMessage.bFO() != null && (alaStartDirectChallengeResponseMessage.bFO().isValid() || alaStartDirectChallengeResponseMessage.bFO().isTimeout())) {
                com.baidu.live.challenge.a bFO = alaStartDirectChallengeResponseMessage.bFO();
                this.gdQ.b(bFO);
                bGf();
                if (bFO.wf()) {
                    dS(bFO.challengeId);
                    this.geO = bFO.challengeId;
                }
                if (alaStartDirectChallengeResponseMessage.bFO().isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_TIMEOUT, alaStartDirectChallengeResponseMessage, base64, (String) null);
                }
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_SUCC, alaStartDirectChallengeResponseMessage, base64, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.gdQ != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.gdQ.aO(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.geP)), (String) null);
                return;
            }
            boolean bFQ = alaCancelDirectChallengeResponseMessage.bFQ();
            com.baidu.live.challenge.a bFO = alaCancelDirectChallengeResponseMessage.bFO();
            this.gdQ.b(bFQ, alaCancelDirectChallengeResponseMessage.bFO());
            bGf();
            if (!bFQ && bFO != null && bFO.wf()) {
                dS(bFO.challengeId);
                this.geO = bFO.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT_SUCC, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.geP)), (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.gdQ != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.gdQ.aP(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.gdQ.l(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.bFY());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.gdQ != null && alaAcceptDirectChallengeResponseMessage != null) {
            String str = "";
            String str2 = "";
            if (alaAcceptDirectChallengeResponseMessage.bFO() != null) {
                str2 = ExtraParamsManager.getBase64(String.valueOf(alaAcceptDirectChallengeResponseMessage.bFO().axl));
            }
            if (alaAcceptDirectChallengeResponseMessage.bFO() != null) {
                str = alaAcceptDirectChallengeResponseMessage.bFO().axj + "";
            }
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.gdQ.aQ(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, alaAcceptDirectChallengeResponseMessage, str2, str);
                return;
            }
            boolean bFP = alaAcceptDirectChallengeResponseMessage.bFP();
            com.baidu.live.challenge.a bFO = alaAcceptDirectChallengeResponseMessage.bFO();
            this.gdQ.c(bFP, bFO);
            if (bFP && bFO != null) {
                dS(bFO.challengeId);
                this.geO = bFO.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET_SUCC, alaAcceptDirectChallengeResponseMessage, str2, str);
        }
    }

    private void bGg() {
        this.geX = false;
        MessageManager.getInstance().removeMessage(1021110, this.aZB);
        this.mHandler.removeCallbacks(this.gfc);
        this.geU = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ls(boolean z) {
        this.geX = true;
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.aZB);
        MessageManager.getInstance().sendMessage(httpMessage);
        dK(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        String str;
        String str2;
        boolean z = false;
        if (this.gdQ != null) {
            this.geX = false;
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() != 0) {
                if (this.gdQ != null) {
                    this.gdQ.aR(alaStartRandomChallengeResponseMessage.getError(), alaStartRandomChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, (String) null, (String) null);
                return;
            }
            if (alaStartRandomChallengeResponseMessage == null || alaStartRandomChallengeResponseMessage.bFO() == null) {
                str = null;
                str2 = null;
            } else {
                str2 = alaStartRandomChallengeResponseMessage.bFO().axj + "";
                str = ExtraParamsManager.getBase64(alaStartRandomChallengeResponseMessage.bFO().axl + "");
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.bFO() != null && alaStartRandomChallengeResponseMessage.bFO().isValid()) {
                com.baidu.live.challenge.a bFO = alaStartRandomChallengeResponseMessage.bFO();
                this.gdQ.c(bFO);
                if (bFO.wf() && !ws()) {
                    bGg();
                    dS(bFO.challengeId);
                    this.geO = bFO.challengeId;
                } else {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, str, str2);
                }
                if (bFO.isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOW_TIMEOUT, alaStartRandomChallengeResponseMessage, str, (String) null);
                }
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.bFO() != null && alaStartRandomChallengeResponseMessage.bFO().isValid()) {
                z = true;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM_SUCC, alaStartRandomChallengeResponseMessage, str, str2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        String str;
        String str2 = null;
        if (this.gdQ != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage == null || alaCancelRandomChallengeResponseMessage.bFO() == null) {
                str = null;
            } else {
                str = alaCancelRandomChallengeResponseMessage.bFO().challengeId + "";
                str2 = alaCancelRandomChallengeResponseMessage.bFO().axj + "";
            }
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.gdQ.aS(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, alaCancelRandomChallengeResponseMessage, str, str2);
                return;
            }
            boolean bFQ = alaCancelRandomChallengeResponseMessage.bFQ();
            com.baidu.live.challenge.a bFO = alaCancelRandomChallengeResponseMessage.bFO();
            this.gdQ.d(bFQ, alaCancelRandomChallengeResponseMessage.bFO());
            bGg();
            if (!bFQ && bFO != null && bFO.wf()) {
                dS(bFO.challengeId);
                this.geO = bFO.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCLE_RANDOM_SUCC, alaCancelRandomChallengeResponseMessage, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.gdQ != null && alaSurrenderResponseMessage != null) {
            this.gdQ.m(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.gdQ != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.gdQ.k(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.gdQ.a(alaGetTargetInfoResponseMessage.bFZ());
            }
        }
    }

    public void ba(boolean z) {
        this.blG = z ? 1 : 2;
    }

    public void dS(long j) {
        this.geS = true;
        this.geO = j;
        this.mHandler.post(this.gfd);
    }

    private void bGh() {
        this.geS = false;
        this.mHandler.removeCallbacks(this.gfd);
        this.geW = false;
        MessageManager.getInstance().removeMessage(1021112, this.aZB);
    }

    public void bGi() {
        this.mHandler.removeCallbacks(this.gfd);
        this.geW = false;
        MessageManager.getInstance().removeMessage(1021112, this.aZB);
    }

    public void bGj() {
        this.mHandler.post(this.gfd);
    }

    private void a(an anVar, ar arVar, ar arVar2, long j) {
        if (anVar == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info challenge meta is null?? logid=" + j);
        } else if (arVar != null && arVar.aDu != null && arVar.aDu.getLiveID() != this.fkg) {
            BdLog.e("CHALLENGE_TAG in challenge not current live?? ||Challenge id=" + anVar.challengeId + "||Challenge Status=" + anVar.aDd + "||Net liveId=" + arVar.aDu.getLiveID() + "||cur liveId=" + this.fkg + "||logid=" + j);
        } else {
            int i = anVar.aDd;
            this.gdQ.b(i, anVar, arVar, arVar2);
            switch (i) {
                case 2:
                    this.geU = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    bGc();
                    break;
                case 3:
                    this.geU = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.geU = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.geO = 0L;
                    bGd();
                    break;
            }
            if (arVar != null && arVar.aDb != null) {
                this.geQ = arVar.aDb.userId;
            }
            if (arVar2 != null && arVar2.aDb != null) {
                this.geR = arVar2.aDb.userId;
            }
            if (4 == anVar.aDd || 5 == anVar.aDd) {
                bGh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.gdQ == null || alaGetChallengeInfoResponseMessage == null || alaGetChallengeInfoResponseMessage.bFS() == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info callback, response message, meta info  null?? ");
            if (alaGetChallengeInfoResponseMessage != null) {
                BdLog.e("CHALLENGE_TAG get Challenge Info error=" + alaGetChallengeInfoResponseMessage.getError());
                return;
            }
            return;
        }
        an bFS = alaGetChallengeInfoResponseMessage.bFS();
        ar bFT = alaGetChallengeInfoResponseMessage.bFT();
        ar bFU = alaGetChallengeInfoResponseMessage.bFU();
        aj bFV = alaGetChallengeInfoResponseMessage.bFV();
        ap bFW = alaGetChallengeInfoResponseMessage.bFW();
        aq bFX = alaGetChallengeInfoResponseMessage.bFX();
        if (bFV != null && bFV.aCX > 0 && this.geN != bFV.aCX) {
            this.geN = bFV.aCX;
        }
        a(bFS, bFT, bFU, alaGetChallengeInfoResponseMessage.getLogId());
        int i = 0;
        if (com.baidu.live.v.a.Hs().aZn != null) {
            i = com.baidu.live.v.a.Hs().aZn.aBl;
        }
        if (i == 1 && bFS != null && bFT != null && bFT.aDu != null && bFT.aDu.user_id == TbadkCoreApplication.getCurrentAccountId()) {
            if (this.geZ == null) {
                this.geZ = new HashMap();
            }
            long j = bFS.challengeId;
            if (bFX != null && bFX.aDt != null && !bFX.aDt.isEmpty() && (!this.geZ.containsKey(Long.valueOf(j)) || this.geZ.get(Long.valueOf(j)).isEmpty())) {
                this.geZ.put(Long.valueOf(j), bFX.aDt);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913209, bFX.aDt));
            }
            if (bFW != null && bFS.aDd >= 3 && bFS.challengeResult == 2) {
                if ((bFW.type == 1 || bFW.type == 3) && !TextUtils.isEmpty(bFW.aDr)) {
                    if (this.gfa == null) {
                        this.gfa = new HashMap();
                    }
                    if (!this.gfa.containsKey(Long.valueOf(j))) {
                        this.gfa.put(Long.valueOf(j), 0);
                    }
                    if (bFS.aDd == 3) {
                        int intValue = this.gfa.get(Long.valueOf(j)).intValue();
                        if (bFW.serverTime >= bFW.startTime && bFW.serverTime <= bFW.endTime) {
                            if (intValue < 1) {
                                this.gfa.put(Long.valueOf(j), 1);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913210, bFW.aDr));
                            }
                        } else if (bFW.serverTime > bFW.endTime && intValue < 2) {
                            this.gfa.put(Long.valueOf(j), 2);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                        }
                    } else if (bFS.aDd > 3) {
                        this.gfa.put(Long.valueOf(j), 2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                    }
                }
            }
        }
    }

    public ChallenfeInfoData.ChallengeStatus wr() {
        return this.geU;
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

    public boolean ws() {
        return this.geS;
    }
}
