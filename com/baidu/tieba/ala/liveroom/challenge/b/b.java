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
    private int bHI;
    private BdUniqueId bou;
    private long fZh;
    private a gZI;
    private long haH;
    private long haI;
    private long haJ;
    private long haK;
    private long haL;
    private long haM;
    private long haN;
    private long haP;
    private ChallenfeInfoData.ChallengeStatus haQ;
    private i.f haR;
    private int hap;
    private boolean isHost;
    private TbPageContext mPageContext;
    private boolean haO = false;
    private boolean haS = false;
    private boolean haT = false;
    private boolean haU = false;
    private HttpMessageListener bJx = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.1
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
    private HttpMessageListener bir = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                b.this.haS = false;
                if (!b.this.gZI.bZs()) {
                    b.this.b((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                    b.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                }
            }
        }
    };
    private Runnable haX = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.haU) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.haI);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, b.this.bou);
            b.this.mX(false);
            b.this.mHandler.postDelayed(this, b.this.haI);
        }
    };
    private Runnable haY = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.4
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.haT) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.haH);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, b.this.bou);
            b.this.mY(false);
            b.this.mHandler.postDelayed(this, b.this.haH);
        }
    };
    private Runnable haZ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.5
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.haK <= 0) {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().removeMessage(1021112, b.this.bou);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            if (b.this.haS) {
                b.this.mHandler.postDelayed(this, b.this.haJ);
                return;
            }
            MessageManager.getInstance().removeMessage(1021112, b.this.bou);
            if (b.this.haR != null) {
                b.this.hap = b.this.haR.DG();
            }
            b.this.haS = true;
            com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(b.this.haK, b.this.bHI, b.this.fZh, b.this.haP, b.this.hap);
            aVar.setTag(b.this.bou);
            MessageManager.getInstance().sendMessage(aVar);
            if (b.this.isHost) {
                UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_REQ, UbcStatConstant.ContentType.UBC_TYPE_PK_CHALLENGE_INFO, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("avts_conn", b.this.bHI);
                    jSONObject2.put("avts_fail", b.this.hap);
                    jSONObject2.put("chat_id", b.this.haK);
                    jSONObject.put("pk", jSONObject2);
                } catch (JSONException e) {
                }
                ubcStatisticItem.setContentExt(jSONObject);
                UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
            }
            b.this.mHandler.postDelayed(this, b.this.haJ);
        }
    };
    private Handler mHandler = new Handler();
    private Map<Long, List<Long>> haV = new HashMap();
    private Map<Long, Integer> haW = new HashMap();

    /* loaded from: classes4.dex */
    public interface a {
        void DH();

        void a(com.baidu.live.challenge.b bVar, List<d> list);

        void a(d dVar);

        void aZ(int i, String str);

        void b(int i, az azVar, bd bdVar, bd bdVar2);

        void b(com.baidu.live.challenge.a aVar);

        void b(boolean z, com.baidu.live.challenge.a aVar);

        boolean bZs();

        void ba(int i, String str);

        void bb(int i, String str);

        void bc(int i, String str);

        void bd(int i, String str);

        void be(int i, String str);

        void bf(int i, String str);

        void bg(int i, String str);

        void c(com.baidu.live.challenge.a aVar);

        void c(boolean z, com.baidu.live.challenge.a aVar);

        void cw(List<d> list);

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
                jSONObject2.put("avts_conn", this.bHI);
                jSONObject2.put("avts_fail", this.hap);
                if (alaGetChallengeInfoResponseMessage.bZI() != null) {
                    jSONObject2.put("chat_id", alaGetChallengeInfoResponseMessage.bZI().challengeId);
                    jSONObject2.put("chat_status", alaGetChallengeInfoResponseMessage.bZI().aOx);
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
        this.bou = bdUniqueId;
        this.haH = com.baidu.live.aa.a.PQ().bod.aMk > 0 ? com.baidu.live.aa.a.PQ().bod.aMk : 1000L;
        this.haI = com.baidu.live.aa.a.PQ().bod.aMl > 0 ? com.baidu.live.aa.a.PQ().bod.aMl : 1000L;
        this.haJ = com.baidu.live.aa.a.PQ().bod.aMm > 0 ? com.baidu.live.aa.a.PQ().bod.aMm : 1000L;
        this.haQ = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        registerTask();
        registerListener();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public void e(long j, long j2) {
        this.fZh = j;
        this.haP = j2;
    }

    public void a(a aVar) {
        this.gZI = aVar;
    }

    public void b(i.f fVar) {
        this.haR = fVar;
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
        MessageManager.getInstance().registerListener(1021183, this.bJx);
        MessageManager.getInstance().registerListener(1021105, this.bJx);
        MessageManager.getInstance().registerListener(1021182, this.bJx);
        MessageManager.getInstance().registerListener(1021203, this.bJx);
        MessageManager.getInstance().registerListener(1021106, this.bJx);
        MessageManager.getInstance().registerListener(1021107, this.bJx);
        MessageManager.getInstance().registerListener(1021108, this.bJx);
        MessageManager.getInstance().registerListener(1021109, this.bJx);
        MessageManager.getInstance().registerListener(1021110, this.bJx);
        MessageManager.getInstance().registerListener(1021111, this.bJx);
        MessageManager.getInstance().registerListener(1021115, this.bJx);
        MessageManager.getInstance().registerListener(1021116, this.bJx);
        MessageManager.getInstance().registerListener(1021197, this.bJx);
        MessageManager.getInstance().registerListener(this.bir);
        MessageManager.getInstance().registerListener(1021209, this.bJx);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bJx);
        MessageManager.getInstance().unRegisterListener(this.bir);
    }

    private void bZV() {
        MessageManager.getInstance().removeMessage(1021183, this.bou);
        MessageManager.getInstance().removeMessage(1021105, this.bou);
        MessageManager.getInstance().removeMessage(1021182, this.bou);
        MessageManager.getInstance().removeMessage(1021203, this.bou);
        MessageManager.getInstance().removeMessage(1021106, this.bou);
        MessageManager.getInstance().removeMessage(1021107, this.bou);
        MessageManager.getInstance().removeMessage(1021108, this.bou);
        MessageManager.getInstance().removeMessage(1021109, this.bou);
        MessageManager.getInstance().removeMessage(1021110, this.bou);
        MessageManager.getInstance().removeMessage(1021111, this.bou);
        MessageManager.getInstance().removeMessage(1021116, this.bou);
        MessageManager.getInstance().removeMessage(1021209, this.bou);
    }

    private void bZW() {
        MessageManager.getInstance().removeMessage(1021112, this.bou);
        MessageManager.getInstance().removeMessage(1021115, this.bou);
    }

    private void reset() {
        this.haK = 0L;
        this.haL = 0L;
        this.bHI = 0;
        this.hap = 0;
        this.haM = 0L;
        this.haN = 0L;
        bZZ();
        bZY();
        caa();
        this.mHandler.removeCallbacksAndMessages(null);
        bZV();
        bZW();
    }

    public void bZX() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long DE() {
        return this.haK;
    }

    public void Dx() {
        HttpMessage httpMessage = new HttpMessage(1021183);
        httpMessage.setTag(this.bou);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void HT(String str) {
        HttpMessage httpMessage = new HttpMessage(1021209);
        httpMessage.addParam("user_id", str);
        httpMessage.setTag(this.bou);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void w(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.bou);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void g(int i, int i2, String str) {
        HttpMessage httpMessage = new HttpMessage(1021182);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.addParam("query_words", str);
        httpMessage.setTag(this.bou);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void gj(String str) {
        HttpMessage httpMessage = new HttpMessage(1021203);
        httpMessage.setTag(this.bou);
        httpMessage.addParam("anchor_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void aj(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.bou);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void ak(long j) {
        this.haK = 0L;
        this.haL = j;
        this.haQ = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        mX(true);
        this.mHandler.postDelayed(this.haX, 1000L);
    }

    public void al(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.bou);
        MessageManager.getInstance().sendMessage(httpMessage);
        es(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void Dy() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.bou);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void am(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.bou);
        MessageManager.getInstance().sendMessage(httpMessage);
        es(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void Dz() {
        this.haK = 0L;
        this.haQ = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        mY(true);
        this.mHandler.postDelayed(this.haY, 1000L);
    }

    public void DA() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.bou);
        MessageManager.getInstance().sendMessage(httpMessage);
        es(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, null);
    }

    public void DD() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.haK);
        httpMessage.setTag(this.bou);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void DF() {
        HttpMessage httpMessage = new HttpMessage(1021197);
        httpMessage.addParam("challenge_id", this.haK);
        httpMessage.setTag(this.bou);
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
        if (alaChallengeSwitchResponsedMessage != null && this.gZI != null) {
            if (alaChallengeSwitchResponsedMessage.hasError() || alaChallengeSwitchResponsedMessage.getError() != 0) {
                this.gZI.p(alaChallengeSwitchResponsedMessage.getError(), alaChallengeSwitchResponsedMessage.getErrorString());
            } else {
                this.gZI.DH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.gZI != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.gZI.m(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.gZI.a(alaGetTargetListResponseMessage.bZT(), alaGetTargetListResponseMessage.bZU());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSearchTargetListResponseMessage alaSearchTargetListResponseMessage) {
        if (this.gZI != null && alaSearchTargetListResponseMessage != null) {
            if (alaSearchTargetListResponseMessage.hasError() || alaSearchTargetListResponseMessage.getError() != 0) {
                this.gZI.m(alaSearchTargetListResponseMessage.getError(), alaSearchTargetListResponseMessage.getErrorString());
            } else {
                this.gZI.a(alaSearchTargetListResponseMessage.bZT(), alaSearchTargetListResponseMessage.bZU());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeLatestListResponseMessage alaChallengeLatestListResponseMessage) {
        if (this.gZI != null && alaChallengeLatestListResponseMessage != null) {
            if (alaChallengeLatestListResponseMessage.hasError() || alaChallengeLatestListResponseMessage.getError() != 0) {
                this.gZI.aZ(alaChallengeLatestListResponseMessage.getError(), alaChallengeLatestListResponseMessage.getErrorString());
            } else {
                this.gZI.cw(alaChallengeLatestListResponseMessage.bZH());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CloseChallengeResponseMessage closeChallengeResponseMessage) {
        if (this.gZI != null && closeChallengeResponseMessage != null) {
            this.gZI.q(!closeChallengeResponseMessage.hasError() && closeChallengeResponseMessage.getError() == 0, closeChallengeResponseMessage.getErrorString());
        }
    }

    private void bZY() {
        this.haU = false;
        MessageManager.getInstance().removeMessage(1021106, this.bou);
        this.mHandler.removeCallbacks(this.haX);
        this.haQ = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mX(boolean z) {
        this.haU = true;
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.haL);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.bou);
        MessageManager.getInstance().sendMessage(httpMessage);
        es(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, ExtraParamsManager.getBase64(String.valueOf(this.haL)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.gZI != null) {
            this.haU = false;
            String base64 = ExtraParamsManager.getBase64(String.valueOf(this.haL));
            String str = "";
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.bZE() != null) {
                str = alaStartDirectChallengeResponseMessage.bZE().aGZ + "";
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() != 0) {
                if (this.gZI != null) {
                    this.gZI.ba(alaStartDirectChallengeResponseMessage.getError(), alaStartDirectChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, alaStartDirectChallengeResponseMessage, base64, str);
                return;
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() == 0 && alaStartDirectChallengeResponseMessage.bZE() != null && (alaStartDirectChallengeResponseMessage.bZE().isValid() || alaStartDirectChallengeResponseMessage.bZE().isTimeout())) {
                com.baidu.live.challenge.a bZE = alaStartDirectChallengeResponseMessage.bZE();
                this.gZI.b(bZE);
                bZY();
                if (bZE.Do()) {
                    eT(bZE.challengeId);
                    this.haK = bZE.challengeId;
                }
                if (alaStartDirectChallengeResponseMessage.bZE().isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_TIMEOUT, alaStartDirectChallengeResponseMessage, base64, (String) null);
                }
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_SUCC, alaStartDirectChallengeResponseMessage, base64, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.gZI != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.gZI.bb(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.haL)), (String) null);
                return;
            }
            boolean bZG = alaCancelDirectChallengeResponseMessage.bZG();
            com.baidu.live.challenge.a bZE = alaCancelDirectChallengeResponseMessage.bZE();
            this.gZI.b(bZG, alaCancelDirectChallengeResponseMessage.bZE());
            bZY();
            if (!bZG && bZE != null && bZE.Do()) {
                eT(bZE.challengeId);
                this.haK = bZE.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT_SUCC, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.haL)), (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.gZI != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.gZI.bc(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.gZI.l(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.bZO());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetQualifyingResultResponseMessage alaGetQualifyingResultResponseMessage) {
        if (this.gZI != null && alaGetQualifyingResultResponseMessage != null) {
            if (alaGetQualifyingResultResponseMessage.hasError() || alaGetQualifyingResultResponseMessage.getError() != 0) {
                this.gZI.bd(alaGetQualifyingResultResponseMessage.getError(), alaGetQualifyingResultResponseMessage.getErrorString());
            } else if (alaGetQualifyingResultResponseMessage.bZQ()) {
                this.gZI.d(alaGetQualifyingResultResponseMessage.bZP(), alaGetQualifyingResultResponseMessage.bZR());
            } else {
                this.gZI.d(alaGetQualifyingResultResponseMessage.bZP(), -1L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.gZI != null && alaAcceptDirectChallengeResponseMessage != null) {
            String str = "";
            String str2 = "";
            if (alaAcceptDirectChallengeResponseMessage.bZE() != null) {
                str2 = ExtraParamsManager.getBase64(String.valueOf(alaAcceptDirectChallengeResponseMessage.bZE().aHb));
            }
            if (alaAcceptDirectChallengeResponseMessage.bZE() != null) {
                str = alaAcceptDirectChallengeResponseMessage.bZE().aGZ + "";
            }
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.gZI.be(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, alaAcceptDirectChallengeResponseMessage, str2, str);
                return;
            }
            boolean bZF = alaAcceptDirectChallengeResponseMessage.bZF();
            com.baidu.live.challenge.a bZE = alaAcceptDirectChallengeResponseMessage.bZE();
            this.gZI.c(bZF, bZE);
            if (bZF && bZE != null) {
                eT(bZE.challengeId);
                this.haK = bZE.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET_SUCC, alaAcceptDirectChallengeResponseMessage, str2, str);
        }
    }

    private void bZZ() {
        this.haT = false;
        MessageManager.getInstance().removeMessage(1021110, this.bou);
        this.mHandler.removeCallbacks(this.haY);
        this.haQ = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mY(boolean z) {
        this.haT = true;
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.bou);
        MessageManager.getInstance().sendMessage(httpMessage);
        es(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        String str;
        String str2;
        boolean z = false;
        if (this.gZI != null) {
            this.haT = false;
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() != 0) {
                if (this.gZI != null) {
                    this.gZI.bf(alaStartRandomChallengeResponseMessage.getError(), alaStartRandomChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, (String) null, (String) null);
                return;
            }
            if (alaStartRandomChallengeResponseMessage == null || alaStartRandomChallengeResponseMessage.bZE() == null) {
                str = null;
                str2 = null;
            } else {
                str2 = alaStartRandomChallengeResponseMessage.bZE().aGZ + "";
                str = ExtraParamsManager.getBase64(alaStartRandomChallengeResponseMessage.bZE().aHb + "");
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.bZE() != null && alaStartRandomChallengeResponseMessage.bZE().isValid()) {
                com.baidu.live.challenge.a bZE = alaStartRandomChallengeResponseMessage.bZE();
                this.gZI.c(bZE);
                if (bZE.Do() && !DC()) {
                    bZZ();
                    eT(bZE.challengeId);
                    this.haK = bZE.challengeId;
                } else {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, str, str2);
                }
                if (bZE.isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOW_TIMEOUT, alaStartRandomChallengeResponseMessage, str, (String) null);
                }
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.bZE() != null && alaStartRandomChallengeResponseMessage.bZE().isValid()) {
                z = true;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM_SUCC, alaStartRandomChallengeResponseMessage, str, str2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        String str;
        String str2 = null;
        if (this.gZI != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage == null || alaCancelRandomChallengeResponseMessage.bZE() == null) {
                str = null;
            } else {
                str = alaCancelRandomChallengeResponseMessage.bZE().challengeId + "";
                str2 = alaCancelRandomChallengeResponseMessage.bZE().aGZ + "";
            }
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.gZI.bg(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, alaCancelRandomChallengeResponseMessage, str, str2);
                return;
            }
            boolean bZG = alaCancelRandomChallengeResponseMessage.bZG();
            com.baidu.live.challenge.a bZE = alaCancelRandomChallengeResponseMessage.bZE();
            this.gZI.d(bZG, alaCancelRandomChallengeResponseMessage.bZE());
            bZZ();
            if (!bZG && bZE != null && bZE.Do()) {
                eT(bZE.challengeId);
                this.haK = bZE.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCLE_RANDOM_SUCC, alaCancelRandomChallengeResponseMessage, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.gZI != null && alaSurrenderResponseMessage != null) {
            this.gZI.p(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.gZI != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.gZI.l(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.gZI.a(alaGetTargetInfoResponseMessage.bZS());
            }
        }
    }

    public void bl(boolean z) {
        this.bHI = z ? 1 : 2;
    }

    public void eT(long j) {
        this.haO = true;
        this.haK = j;
        this.mHandler.post(this.haZ);
    }

    private void caa() {
        this.haO = false;
        this.mHandler.removeCallbacks(this.haZ);
        this.haS = false;
        MessageManager.getInstance().removeMessage(1021112, this.bou);
    }

    public void cab() {
        this.mHandler.removeCallbacks(this.haZ);
        this.haS = false;
        MessageManager.getInstance().removeMessage(1021112, this.bou);
    }

    public void cac() {
        this.mHandler.post(this.haZ);
    }

    private void a(az azVar, bd bdVar, bd bdVar2, long j) {
        if (azVar == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info challenge meta is null?? logid=" + j);
        } else if (bdVar != null && bdVar.aOJ != null && bdVar.aOJ.getLiveID() != this.fZh) {
            BdLog.e("CHALLENGE_TAG in challenge not current live?? ||Challenge id=" + azVar.challengeId + "||Challenge Status=" + azVar.aOx + "||Net liveId=" + bdVar.aOJ.getLiveID() + "||cur liveId=" + this.fZh + "||logid=" + j);
        } else {
            int i = azVar.aOx;
            this.gZI.b(i, azVar, bdVar, bdVar2);
            switch (i) {
                case 2:
                    this.haQ = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    bZV();
                    break;
                case 3:
                    this.haQ = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.haQ = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.haK = 0L;
                    bZW();
                    break;
            }
            if (bdVar != null && bdVar.aOv != null) {
                this.haM = bdVar.aOv.userId;
            }
            if (bdVar2 != null && bdVar2.aOv != null) {
                this.haN = bdVar2.aOv.userId;
            }
            if (4 == azVar.aOx || 5 == azVar.aOx) {
                caa();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.gZI == null || alaGetChallengeInfoResponseMessage == null || alaGetChallengeInfoResponseMessage.bZI() == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info callback, response message, meta info  null?? ");
            if (alaGetChallengeInfoResponseMessage != null) {
                BdLog.e("CHALLENGE_TAG get Challenge Info error=" + alaGetChallengeInfoResponseMessage.getError());
                return;
            }
            return;
        }
        az bZI = alaGetChallengeInfoResponseMessage.bZI();
        bd bZJ = alaGetChallengeInfoResponseMessage.bZJ();
        bd bZK = alaGetChallengeInfoResponseMessage.bZK();
        av bZL = alaGetChallengeInfoResponseMessage.bZL();
        bb bZM = alaGetChallengeInfoResponseMessage.bZM();
        bc bZN = alaGetChallengeInfoResponseMessage.bZN();
        if (bZL != null && bZL.aOr > 0 && this.haJ != bZL.aOr) {
            this.haJ = bZL.aOr;
        }
        a(bZI, bZJ, bZK, alaGetChallengeInfoResponseMessage.getLogId());
        int i = 0;
        if (com.baidu.live.aa.a.PQ().bod != null) {
            i = com.baidu.live.aa.a.PQ().bod.aMs;
        }
        if (i == 1 && bZI != null && bZJ != null && bZJ.aOJ != null && bZJ.aOJ.user_id == TbadkCoreApplication.getCurrentAccountId()) {
            if (this.haV == null) {
                this.haV = new HashMap();
            }
            long j = bZI.challengeId;
            if (bZN != null && bZN.aOI != null && !bZN.aOI.isEmpty() && (!this.haV.containsKey(Long.valueOf(j)) || this.haV.get(Long.valueOf(j)).isEmpty())) {
                this.haV.put(Long.valueOf(j), bZN.aOI);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913209, bZN.aOI));
            }
            if (bZM != null && bZI.aOx >= 3 && bZI.challengeResult == 2) {
                if ((bZM.type == 1 || bZM.type == 3) && !TextUtils.isEmpty(bZM.aOG)) {
                    if (this.haW == null) {
                        this.haW = new HashMap();
                    }
                    if (!this.haW.containsKey(Long.valueOf(j))) {
                        this.haW.put(Long.valueOf(j), 0);
                    }
                    if (bZI.aOx == 3) {
                        int intValue = this.haW.get(Long.valueOf(j)).intValue();
                        if (bZM.serverTime >= bZM.startTime && bZM.serverTime <= bZM.endTime) {
                            if (intValue < 1) {
                                this.haW.put(Long.valueOf(j), 1);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913210, bZM.aOG));
                            }
                        } else if (bZM.serverTime > bZM.endTime && intValue < 2) {
                            this.haW.put(Long.valueOf(j), 2);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                        }
                    } else if (bZI.aOx > 3) {
                        this.haW.put(Long.valueOf(j), 2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                    }
                }
            }
        }
    }

    public ChallenfeInfoData.ChallengeStatus DB() {
        return this.haQ;
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

    public boolean DC() {
        return this.haO;
    }
}
