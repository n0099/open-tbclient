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
import com.baidu.live.data.aq;
import com.baidu.live.data.au;
import com.baidu.live.data.aw;
import com.baidu.live.data.ax;
import com.baidu.live.data.ay;
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
    private BdUniqueId blA;
    private int byG;
    private long fLa;
    private a gHO;
    private long gIO;
    private long gIP;
    private long gIQ;
    private long gIR;
    private long gIS;
    private long gIT;
    private long gIU;
    private long gIW;
    private ChallenfeInfoData.ChallengeStatus gIX;
    private i.f gIY;
    private int gIw;
    private boolean isHost;
    private TbPageContext mPageContext;
    private boolean gIV = false;
    private boolean gIZ = false;
    private boolean gJa = false;
    private boolean gJb = false;
    private HttpMessageListener bAU = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.1
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
    private HttpMessageListener bfG = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                b.this.gIZ = false;
                if (!b.this.gHO.bTR()) {
                    b.this.b((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                    b.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                }
            }
        }
    };
    private Runnable gJe = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.gJb) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.gIP);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, b.this.blA);
            b.this.my(false);
            b.this.mHandler.postDelayed(this, b.this.gIP);
        }
    };
    private Runnable gJf = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.4
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.gJa) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.gIO);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, b.this.blA);
            b.this.mz(false);
            b.this.mHandler.postDelayed(this, b.this.gIO);
        }
    };
    private Runnable gJg = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.5
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.gIR <= 0) {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().removeMessage(1021112, b.this.blA);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            if (b.this.gIZ) {
                b.this.mHandler.postDelayed(this, b.this.gIQ);
                return;
            }
            MessageManager.getInstance().removeMessage(1021112, b.this.blA);
            if (b.this.gIY != null) {
                b.this.gIw = b.this.gIY.Dg();
            }
            b.this.gIZ = true;
            com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(b.this.gIR, b.this.byG, b.this.fLa, b.this.gIW, b.this.gIw);
            aVar.setTag(b.this.blA);
            MessageManager.getInstance().sendMessage(aVar);
            if (b.this.isHost) {
                UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_REQ, UbcStatConstant.ContentType.UBC_TYPE_PK_CHALLENGE_INFO, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("avts_conn", b.this.byG);
                    jSONObject2.put("avts_fail", b.this.gIw);
                    jSONObject2.put("chat_id", b.this.gIR);
                    jSONObject.put("pk", jSONObject2);
                } catch (JSONException e) {
                }
                ubcStatisticItem.setContentExt(jSONObject);
                UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
            }
            b.this.mHandler.postDelayed(this, b.this.gIQ);
        }
    };
    private Handler mHandler = new Handler();
    private Map<Long, List<Long>> gJc = new HashMap();
    private Map<Long, Integer> gJd = new HashMap();

    /* loaded from: classes4.dex */
    public interface a {
        void Dh();

        void a(com.baidu.live.challenge.b bVar, List<d> list);

        void a(d dVar);

        void aU(int i, String str);

        void aV(int i, String str);

        void aW(int i, String str);

        void aX(int i, String str);

        void aY(int i, String str);

        void aZ(int i, String str);

        void b(int i, au auVar, ay ayVar, ay ayVar2);

        void b(com.baidu.live.challenge.a aVar);

        void b(boolean z, com.baidu.live.challenge.a aVar);

        boolean bTR();

        void ba(int i, String str);

        void c(com.baidu.live.challenge.a aVar);

        void c(boolean z, com.baidu.live.challenge.a aVar);

        void ce(List<d> list);

        void d(boolean z, long j);

        void d(boolean z, com.baidu.live.challenge.a aVar);

        void l(int i, String str);

        void l(int i, List<d> list);

        void m(int i, String str);

        void n(boolean z, String str);

        void o(boolean z, String str);

        void p(int i, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        UbcStatisticItem ubcStatisticItem;
        if (alaGetChallengeInfoResponseMessage != null && this.isHost) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("avts_conn", this.byG);
                jSONObject2.put("avts_fail", this.gIw);
                if (alaGetChallengeInfoResponseMessage.bUh() != null) {
                    jSONObject2.put("chat_id", alaGetChallengeInfoResponseMessage.bUh().challengeId);
                    jSONObject2.put("chat_status", alaGetChallengeInfoResponseMessage.bUh().aMP);
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
        this.blA = bdUniqueId;
        this.gIO = com.baidu.live.x.a.OS().blo.aKI > 0 ? com.baidu.live.x.a.OS().blo.aKI : 1000L;
        this.gIP = com.baidu.live.x.a.OS().blo.aKJ > 0 ? com.baidu.live.x.a.OS().blo.aKJ : 1000L;
        this.gIQ = com.baidu.live.x.a.OS().blo.aKK > 0 ? com.baidu.live.x.a.OS().blo.aKK : 1000L;
        this.gIX = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        registerTask();
        registerListener();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public void e(long j, long j2) {
        this.fLa = j;
        this.gIW = j2;
    }

    public void a(a aVar) {
        this.gHO = aVar;
    }

    public void b(i.f fVar) {
        this.gIY = fVar;
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
        MessageManager.getInstance().registerListener(1021183, this.bAU);
        MessageManager.getInstance().registerListener(1021105, this.bAU);
        MessageManager.getInstance().registerListener(1021182, this.bAU);
        MessageManager.getInstance().registerListener(1021203, this.bAU);
        MessageManager.getInstance().registerListener(1021106, this.bAU);
        MessageManager.getInstance().registerListener(1021107, this.bAU);
        MessageManager.getInstance().registerListener(1021108, this.bAU);
        MessageManager.getInstance().registerListener(1021109, this.bAU);
        MessageManager.getInstance().registerListener(1021110, this.bAU);
        MessageManager.getInstance().registerListener(1021111, this.bAU);
        MessageManager.getInstance().registerListener(1021115, this.bAU);
        MessageManager.getInstance().registerListener(1021116, this.bAU);
        MessageManager.getInstance().registerListener(1021197, this.bAU);
        MessageManager.getInstance().registerListener(this.bfG);
        MessageManager.getInstance().registerListener(1021209, this.bAU);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bAU);
        MessageManager.getInstance().unRegisterListener(this.bfG);
    }

    private void bUu() {
        MessageManager.getInstance().removeMessage(1021183, this.blA);
        MessageManager.getInstance().removeMessage(1021105, this.blA);
        MessageManager.getInstance().removeMessage(1021182, this.blA);
        MessageManager.getInstance().removeMessage(1021203, this.blA);
        MessageManager.getInstance().removeMessage(1021106, this.blA);
        MessageManager.getInstance().removeMessage(1021107, this.blA);
        MessageManager.getInstance().removeMessage(1021108, this.blA);
        MessageManager.getInstance().removeMessage(1021109, this.blA);
        MessageManager.getInstance().removeMessage(1021110, this.blA);
        MessageManager.getInstance().removeMessage(1021111, this.blA);
        MessageManager.getInstance().removeMessage(1021116, this.blA);
        MessageManager.getInstance().removeMessage(1021209, this.blA);
    }

    private void bUv() {
        MessageManager.getInstance().removeMessage(1021112, this.blA);
        MessageManager.getInstance().removeMessage(1021115, this.blA);
    }

    private void reset() {
        this.gIR = 0L;
        this.gIS = 0L;
        this.byG = 0;
        this.gIw = 0;
        this.gIT = 0L;
        this.gIU = 0L;
        bUy();
        bUx();
        bUz();
        this.mHandler.removeCallbacksAndMessages(null);
        bUu();
        bUv();
    }

    public void bUw() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long De() {
        return this.gIR;
    }

    public void CX() {
        HttpMessage httpMessage = new HttpMessage(1021183);
        httpMessage.setTag(this.blA);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void Hd(String str) {
        HttpMessage httpMessage = new HttpMessage(1021209);
        httpMessage.addParam("user_id", str);
        httpMessage.setTag(this.blA);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void w(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.blA);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void f(int i, int i2, String str) {
        HttpMessage httpMessage = new HttpMessage(1021182);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.addParam("query_words", str);
        httpMessage.setTag(this.blA);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void gd(String str) {
        HttpMessage httpMessage = new HttpMessage(1021203);
        httpMessage.setTag(this.blA);
        httpMessage.addParam("anchor_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void X(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.blA);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void Y(long j) {
        this.gIR = 0L;
        this.gIS = j;
        this.gIX = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        my(true);
        this.mHandler.postDelayed(this.gJe, 1000L);
    }

    public void Z(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.blA);
        MessageManager.getInstance().sendMessage(httpMessage);
        el(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void CY() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.blA);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void aa(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.blA);
        MessageManager.getInstance().sendMessage(httpMessage);
        el(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void CZ() {
        this.gIR = 0L;
        this.gIX = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        mz(true);
        this.mHandler.postDelayed(this.gJf, 1000L);
    }

    public void Da() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.blA);
        MessageManager.getInstance().sendMessage(httpMessage);
        el(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, null);
    }

    public void Dd() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.gIR);
        httpMessage.setTag(this.blA);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void Df() {
        HttpMessage httpMessage = new HttpMessage(1021197);
        httpMessage.addParam("challenge_id", this.gIR);
        httpMessage.setTag(this.blA);
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
        if (alaChallengeSwitchResponsedMessage != null && this.gHO != null) {
            if (alaChallengeSwitchResponsedMessage.hasError() || alaChallengeSwitchResponsedMessage.getError() != 0) {
                this.gHO.p(alaChallengeSwitchResponsedMessage.getError(), alaChallengeSwitchResponsedMessage.getErrorString());
            } else {
                this.gHO.Dh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.gHO != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.gHO.m(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.gHO.a(alaGetTargetListResponseMessage.bUs(), alaGetTargetListResponseMessage.bUt());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSearchTargetListResponseMessage alaSearchTargetListResponseMessage) {
        if (this.gHO != null && alaSearchTargetListResponseMessage != null) {
            if (alaSearchTargetListResponseMessage.hasError() || alaSearchTargetListResponseMessage.getError() != 0) {
                this.gHO.m(alaSearchTargetListResponseMessage.getError(), alaSearchTargetListResponseMessage.getErrorString());
            } else {
                this.gHO.a(alaSearchTargetListResponseMessage.bUs(), alaSearchTargetListResponseMessage.bUt());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeLatestListResponseMessage alaChallengeLatestListResponseMessage) {
        if (this.gHO != null && alaChallengeLatestListResponseMessage != null) {
            if (alaChallengeLatestListResponseMessage.hasError() || alaChallengeLatestListResponseMessage.getError() != 0) {
                this.gHO.aU(alaChallengeLatestListResponseMessage.getError(), alaChallengeLatestListResponseMessage.getErrorString());
            } else {
                this.gHO.ce(alaChallengeLatestListResponseMessage.bUg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CloseChallengeResponseMessage closeChallengeResponseMessage) {
        if (this.gHO != null && closeChallengeResponseMessage != null) {
            this.gHO.o(!closeChallengeResponseMessage.hasError() && closeChallengeResponseMessage.getError() == 0, closeChallengeResponseMessage.getErrorString());
        }
    }

    private void bUx() {
        this.gJb = false;
        MessageManager.getInstance().removeMessage(1021106, this.blA);
        this.mHandler.removeCallbacks(this.gJe);
        this.gIX = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void my(boolean z) {
        this.gJb = true;
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.gIS);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.blA);
        MessageManager.getInstance().sendMessage(httpMessage);
        el(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, ExtraParamsManager.getBase64(String.valueOf(this.gIS)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.gHO != null) {
            this.gJb = false;
            String base64 = ExtraParamsManager.getBase64(String.valueOf(this.gIS));
            String str = "";
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.bUd() != null) {
                str = alaStartDirectChallengeResponseMessage.bUd().aGb + "";
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() != 0) {
                if (this.gHO != null) {
                    this.gHO.aV(alaStartDirectChallengeResponseMessage.getError(), alaStartDirectChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, alaStartDirectChallengeResponseMessage, base64, str);
                return;
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() == 0 && alaStartDirectChallengeResponseMessage.bUd() != null && (alaStartDirectChallengeResponseMessage.bUd().isValid() || alaStartDirectChallengeResponseMessage.bUd().isTimeout())) {
                com.baidu.live.challenge.a bUd = alaStartDirectChallengeResponseMessage.bUd();
                this.gHO.b(bUd);
                bUx();
                if (bUd.CP()) {
                    ev(bUd.challengeId);
                    this.gIR = bUd.challengeId;
                }
                if (alaStartDirectChallengeResponseMessage.bUd().isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_TIMEOUT, alaStartDirectChallengeResponseMessage, base64, (String) null);
                }
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_SUCC, alaStartDirectChallengeResponseMessage, base64, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.gHO != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.gHO.aW(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.gIS)), (String) null);
                return;
            }
            boolean bUf = alaCancelDirectChallengeResponseMessage.bUf();
            com.baidu.live.challenge.a bUd = alaCancelDirectChallengeResponseMessage.bUd();
            this.gHO.b(bUf, alaCancelDirectChallengeResponseMessage.bUd());
            bUx();
            if (!bUf && bUd != null && bUd.CP()) {
                ev(bUd.challengeId);
                this.gIR = bUd.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT_SUCC, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.gIS)), (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.gHO != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.gHO.aX(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.gHO.l(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.bUn());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetQualifyingResultResponseMessage alaGetQualifyingResultResponseMessage) {
        if (this.gHO != null && alaGetQualifyingResultResponseMessage != null) {
            if (alaGetQualifyingResultResponseMessage.bUp()) {
                this.gHO.d(alaGetQualifyingResultResponseMessage.bUo(), alaGetQualifyingResultResponseMessage.bUq());
            } else {
                this.gHO.d(alaGetQualifyingResultResponseMessage.bUo(), -1L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.gHO != null && alaAcceptDirectChallengeResponseMessage != null) {
            String str = "";
            String str2 = "";
            if (alaAcceptDirectChallengeResponseMessage.bUd() != null) {
                str2 = ExtraParamsManager.getBase64(String.valueOf(alaAcceptDirectChallengeResponseMessage.bUd().aGd));
            }
            if (alaAcceptDirectChallengeResponseMessage.bUd() != null) {
                str = alaAcceptDirectChallengeResponseMessage.bUd().aGb + "";
            }
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.gHO.aY(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, alaAcceptDirectChallengeResponseMessage, str2, str);
                return;
            }
            boolean bUe = alaAcceptDirectChallengeResponseMessage.bUe();
            com.baidu.live.challenge.a bUd = alaAcceptDirectChallengeResponseMessage.bUd();
            this.gHO.c(bUe, bUd);
            if (bUe && bUd != null) {
                ev(bUd.challengeId);
                this.gIR = bUd.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET_SUCC, alaAcceptDirectChallengeResponseMessage, str2, str);
        }
    }

    private void bUy() {
        this.gJa = false;
        MessageManager.getInstance().removeMessage(1021110, this.blA);
        this.mHandler.removeCallbacks(this.gJf);
        this.gIX = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mz(boolean z) {
        this.gJa = true;
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.blA);
        MessageManager.getInstance().sendMessage(httpMessage);
        el(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        String str;
        String str2;
        boolean z = false;
        if (this.gHO != null) {
            this.gJa = false;
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() != 0) {
                if (this.gHO != null) {
                    this.gHO.aZ(alaStartRandomChallengeResponseMessage.getError(), alaStartRandomChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, (String) null, (String) null);
                return;
            }
            if (alaStartRandomChallengeResponseMessage == null || alaStartRandomChallengeResponseMessage.bUd() == null) {
                str = null;
                str2 = null;
            } else {
                str2 = alaStartRandomChallengeResponseMessage.bUd().aGb + "";
                str = ExtraParamsManager.getBase64(alaStartRandomChallengeResponseMessage.bUd().aGd + "");
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.bUd() != null && alaStartRandomChallengeResponseMessage.bUd().isValid()) {
                com.baidu.live.challenge.a bUd = alaStartRandomChallengeResponseMessage.bUd();
                this.gHO.c(bUd);
                if (bUd.CP() && !Dc()) {
                    bUy();
                    ev(bUd.challengeId);
                    this.gIR = bUd.challengeId;
                } else {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, str, str2);
                }
                if (bUd.isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOW_TIMEOUT, alaStartRandomChallengeResponseMessage, str, (String) null);
                }
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.bUd() != null && alaStartRandomChallengeResponseMessage.bUd().isValid()) {
                z = true;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM_SUCC, alaStartRandomChallengeResponseMessage, str, str2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        String str;
        String str2 = null;
        if (this.gHO != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage == null || alaCancelRandomChallengeResponseMessage.bUd() == null) {
                str = null;
            } else {
                str = alaCancelRandomChallengeResponseMessage.bUd().challengeId + "";
                str2 = alaCancelRandomChallengeResponseMessage.bUd().aGb + "";
            }
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.gHO.ba(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, alaCancelRandomChallengeResponseMessage, str, str2);
                return;
            }
            boolean bUf = alaCancelRandomChallengeResponseMessage.bUf();
            com.baidu.live.challenge.a bUd = alaCancelRandomChallengeResponseMessage.bUd();
            this.gHO.d(bUf, alaCancelRandomChallengeResponseMessage.bUd());
            bUy();
            if (!bUf && bUd != null && bUd.CP()) {
                ev(bUd.challengeId);
                this.gIR = bUd.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCLE_RANDOM_SUCC, alaCancelRandomChallengeResponseMessage, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.gHO != null && alaSurrenderResponseMessage != null) {
            this.gHO.n(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.gHO != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.gHO.l(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.gHO.a(alaGetTargetInfoResponseMessage.bUr());
            }
        }
    }

    public void bj(boolean z) {
        this.byG = z ? 1 : 2;
    }

    public void ev(long j) {
        this.gIV = true;
        this.gIR = j;
        this.mHandler.post(this.gJg);
    }

    private void bUz() {
        this.gIV = false;
        this.mHandler.removeCallbacks(this.gJg);
        this.gIZ = false;
        MessageManager.getInstance().removeMessage(1021112, this.blA);
    }

    public void bUA() {
        this.mHandler.removeCallbacks(this.gJg);
        this.gIZ = false;
        MessageManager.getInstance().removeMessage(1021112, this.blA);
    }

    public void bUB() {
        this.mHandler.post(this.gJg);
    }

    private void a(au auVar, ay ayVar, ay ayVar2, long j) {
        if (auVar == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info challenge meta is null?? logid=" + j);
        } else if (ayVar != null && ayVar.aNb != null && ayVar.aNb.getLiveID() != this.fLa) {
            BdLog.e("CHALLENGE_TAG in challenge not current live?? ||Challenge id=" + auVar.challengeId + "||Challenge Status=" + auVar.aMP + "||Net liveId=" + ayVar.aNb.getLiveID() + "||cur liveId=" + this.fLa + "||logid=" + j);
        } else {
            int i = auVar.aMP;
            this.gHO.b(i, auVar, ayVar, ayVar2);
            switch (i) {
                case 2:
                    this.gIX = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    bUu();
                    break;
                case 3:
                    this.gIX = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.gIX = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.gIR = 0L;
                    bUv();
                    break;
            }
            if (ayVar != null && ayVar.aMN != null) {
                this.gIT = ayVar.aMN.userId;
            }
            if (ayVar2 != null && ayVar2.aMN != null) {
                this.gIU = ayVar2.aMN.userId;
            }
            if (4 == auVar.aMP || 5 == auVar.aMP) {
                bUz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.gHO == null || alaGetChallengeInfoResponseMessage == null || alaGetChallengeInfoResponseMessage.bUh() == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info callback, response message, meta info  null?? ");
            if (alaGetChallengeInfoResponseMessage != null) {
                BdLog.e("CHALLENGE_TAG get Challenge Info error=" + alaGetChallengeInfoResponseMessage.getError());
                return;
            }
            return;
        }
        au bUh = alaGetChallengeInfoResponseMessage.bUh();
        ay bUi = alaGetChallengeInfoResponseMessage.bUi();
        ay bUj = alaGetChallengeInfoResponseMessage.bUj();
        aq bUk = alaGetChallengeInfoResponseMessage.bUk();
        aw bUl = alaGetChallengeInfoResponseMessage.bUl();
        ax bUm = alaGetChallengeInfoResponseMessage.bUm();
        if (bUk != null && bUk.aMJ > 0 && this.gIQ != bUk.aMJ) {
            this.gIQ = bUk.aMJ;
        }
        a(bUh, bUi, bUj, alaGetChallengeInfoResponseMessage.getLogId());
        int i = 0;
        if (com.baidu.live.x.a.OS().blo != null) {
            i = com.baidu.live.x.a.OS().blo.aKQ;
        }
        if (i == 1 && bUh != null && bUi != null && bUi.aNb != null && bUi.aNb.user_id == TbadkCoreApplication.getCurrentAccountId()) {
            if (this.gJc == null) {
                this.gJc = new HashMap();
            }
            long j = bUh.challengeId;
            if (bUm != null && bUm.aNa != null && !bUm.aNa.isEmpty() && (!this.gJc.containsKey(Long.valueOf(j)) || this.gJc.get(Long.valueOf(j)).isEmpty())) {
                this.gJc.put(Long.valueOf(j), bUm.aNa);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913209, bUm.aNa));
            }
            if (bUl != null && bUh.aMP >= 3 && bUh.challengeResult == 2) {
                if ((bUl.type == 1 || bUl.type == 3) && !TextUtils.isEmpty(bUl.aMY)) {
                    if (this.gJd == null) {
                        this.gJd = new HashMap();
                    }
                    if (!this.gJd.containsKey(Long.valueOf(j))) {
                        this.gJd.put(Long.valueOf(j), 0);
                    }
                    if (bUh.aMP == 3) {
                        int intValue = this.gJd.get(Long.valueOf(j)).intValue();
                        if (bUl.serverTime >= bUl.startTime && bUl.serverTime <= bUl.endTime) {
                            if (intValue < 1) {
                                this.gJd.put(Long.valueOf(j), 1);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913210, bUl.aMY));
                            }
                        } else if (bUl.serverTime > bUl.endTime && intValue < 2) {
                            this.gJd.put(Long.valueOf(j), 2);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                        }
                    } else if (bUh.aMP > 3) {
                        this.gJd.put(Long.valueOf(j), 2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                    }
                }
            }
        }
    }

    public ChallenfeInfoData.ChallengeStatus Db() {
        return this.gIX;
    }

    private void el(String str, String str2) {
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

    private UbcStatisticItem w(String str, String str2, String str3, String str4) {
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

    public boolean Dc() {
        return this.gIV;
    }
}
