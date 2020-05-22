package com.baidu.tieba.ala.liveroom.challenge.a;

import android.os.Handler;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.b;
import com.baidu.live.challenge.d;
import com.baidu.live.challenge.j;
import com.baidu.live.data.ak;
import com.baidu.live.data.al;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaAcceptDirectChallengeResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaCancelDirectChallengeResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaCancelRandomChallengeResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaChallengeSwitchResponsedMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetChallengeInfoResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetDirectChallengeListResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetTargetInfoResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetTargetListResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaSearchTargetListResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaStartDirectChallengeResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaStartRandomChallengeResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaSurrenderResponseMessage;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private BdUniqueId aWV;
    private int bgf;
    private long eUH;
    private int fNB;
    private long fNG;
    private long fNH;
    private long fNI;
    private long fNJ;
    private long fNK;
    private long fNL;
    private long fNM;
    private long fNO;
    private ChallenfeInfoData.ChallengeStatus fNP;
    private j.e fNQ;
    private InterfaceC0559a fNi;
    private boolean isHost;
    private TbPageContext mPageContext;
    private boolean fNN = false;
    private boolean fNR = false;
    private HttpMessageListener bgQ = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaChallengeSwitchResponsedMessage) {
                a.this.a((AlaChallengeSwitchResponsedMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaGetTargetListResponseMessage) {
                a.this.a((AlaGetTargetListResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaStartDirectChallengeResponseMessage) {
                a.this.a((AlaStartDirectChallengeResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaCancelDirectChallengeResponseMessage) {
                a.this.a((AlaCancelDirectChallengeResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaGetDirectChallengeListResponseMessage) {
                a.this.a((AlaGetDirectChallengeListResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaAcceptDirectChallengeResponseMessage) {
                a.this.a((AlaAcceptDirectChallengeResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaStartRandomChallengeResponseMessage) {
                a.this.a((AlaStartRandomChallengeResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaCancelRandomChallengeResponseMessage) {
                a.this.a((AlaCancelRandomChallengeResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaSurrenderResponseMessage) {
                a.this.a((AlaSurrenderResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaGetTargetInfoResponseMessage) {
                a.this.a((AlaGetTargetInfoResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaSearchTargetListResponseMessage) {
                a.this.a((AlaSearchTargetListResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener aQg = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                a.this.fNR = false;
                a.this.b((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                a.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable fNS = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.a.a.3
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, a.this.aWV);
            a.this.kG(false);
            a.this.mHandler.postDelayed(this, a.this.fNH);
        }
    };
    private Runnable fNT = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.a.a.4
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, a.this.aWV);
            a.this.kH(false);
            a.this.mHandler.postDelayed(this, a.this.fNG);
        }
    };
    private Runnable fNU = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.a.a.5
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fNJ <= 0) {
                a.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().removeMessage(1021112, a.this.aWV);
                return;
            }
            a.this.mHandler.removeCallbacks(this);
            if (a.this.fNR) {
                a.this.mHandler.postDelayed(this, a.this.fNI);
                return;
            }
            MessageManager.getInstance().removeMessage(1021112, a.this.aWV);
            if (a.this.fNQ != null) {
                a.this.fNB = a.this.fNQ.vG();
            }
            a.this.fNR = true;
            com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(a.this.fNJ, a.this.bgf, a.this.eUH, a.this.fNO, a.this.fNB);
            aVar.setTag(a.this.aWV);
            MessageManager.getInstance().sendMessage(aVar);
            if (a.this.isHost) {
                UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_REQ, UbcStatConstant.ContentType.UBC_TYPE_PK_CHALLENGE_INFO, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("avts_conn", a.this.bgf);
                    jSONObject2.put("avts_fail", a.this.fNB);
                    jSONObject2.put("chat_id", a.this.fNJ);
                    jSONObject.put("pk", jSONObject2);
                } catch (JSONException e) {
                }
                ubcStatisticItem.setContentExt(jSONObject);
                UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
            }
            a.this.mHandler.postDelayed(this, a.this.fNI);
        }
    };
    private Handler mHandler = new Handler();

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0559a {
        void a(b bVar, List<d> list);

        void a(d dVar);

        void aI(int i, String str);

        void aJ(int i, String str);

        void aK(int i, String str);

        void aL(int i, String str);

        void aM(int i, String str);

        void aN(int i, String str);

        void b(int i, ak akVar, al alVar, al alVar2);

        void b(com.baidu.live.challenge.a aVar);

        void b(boolean z, com.baidu.live.challenge.a aVar);

        void c(com.baidu.live.challenge.a aVar);

        void c(boolean z, com.baidu.live.challenge.a aVar);

        void d(boolean z, com.baidu.live.challenge.a aVar);

        void i(int i, String str);

        void j(int i, String str);

        void l(int i, String str);

        void l(int i, List<d> list);

        void l(boolean z, String str);

        void vH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        UbcStatisticItem ubcStatisticItem;
        if (alaGetChallengeInfoResponseMessage != null && this.isHost) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("avts_conn", this.bgf);
                jSONObject2.put("avts_fail", this.fNB);
                if (alaGetChallengeInfoResponseMessage.bzM() != null) {
                    jSONObject2.put("chat_id", alaGetChallengeInfoResponseMessage.bzM().challengeId);
                    jSONObject2.put("chat_status", alaGetChallengeInfoResponseMessage.bzM().azq);
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

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.aWV = bdUniqueId;
        this.fNG = com.baidu.live.v.a.Ge().aWF.axH > 0 ? com.baidu.live.v.a.Ge().aWF.axH : 1000L;
        this.fNH = com.baidu.live.v.a.Ge().aWF.axI > 0 ? com.baidu.live.v.a.Ge().aWF.axI : 1000L;
        this.fNI = com.baidu.live.v.a.Ge().aWF.axJ > 0 ? com.baidu.live.v.a.Ge().aWF.axJ : 1000L;
        this.fNP = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        Fv();
        registerListener();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public void e(long j, long j2) {
        this.eUH = j;
        this.fNO = j2;
    }

    public void a(InterfaceC0559a interfaceC0559a) {
        this.fNi = interfaceC0559a;
    }

    public void b(j.e eVar) {
        this.fNQ = eVar;
    }

    private void Fv() {
        com.baidu.live.tieba.f.a.a.a(1021183, "ala/challenge/getChallengeSwitch", AlaChallengeSwitchResponsedMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021105, "ala/challenge/getChallengeTargetList", AlaGetTargetListResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021182, "ala/challenge/searchChallengeTargetList", AlaSearchTargetListResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021106, "ala/challenge/startDirectChallenge", AlaStartDirectChallengeResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021107, "ala/challenge/cancelDirectChallenge", AlaCancelDirectChallengeResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021108, "ala/challenge/getDirectChallengerList", AlaGetDirectChallengeListResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021109, "ala/challenge/acceptDirectChallenge", AlaAcceptDirectChallengeResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021110, "ala/challenge/startRandomChallenge", AlaStartRandomChallengeResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021111, "ala/challenge/cancelRandomChallenge", AlaCancelRandomChallengeResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021112, "ala/challenge/getChallengeInfo", AlaGetChallengeInfoResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021115, "ala/challenge/challengeAutoFail", AlaSurrenderResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021116, "ala/challenge/getChallengeTargetInfo", AlaGetTargetInfoResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(1021183, this.bgQ);
        MessageManager.getInstance().registerListener(1021105, this.bgQ);
        MessageManager.getInstance().registerListener(1021182, this.bgQ);
        MessageManager.getInstance().registerListener(1021106, this.bgQ);
        MessageManager.getInstance().registerListener(1021107, this.bgQ);
        MessageManager.getInstance().registerListener(1021108, this.bgQ);
        MessageManager.getInstance().registerListener(1021109, this.bgQ);
        MessageManager.getInstance().registerListener(1021110, this.bgQ);
        MessageManager.getInstance().registerListener(1021111, this.bgQ);
        MessageManager.getInstance().registerListener(1021115, this.bgQ);
        MessageManager.getInstance().registerListener(1021116, this.bgQ);
        MessageManager.getInstance().registerListener(this.aQg);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bgQ);
        MessageManager.getInstance().unRegisterListener(this.aQg);
    }

    private void bzT() {
        MessageManager.getInstance().removeMessage(1021183, this.aWV);
        MessageManager.getInstance().removeMessage(1021105, this.aWV);
        MessageManager.getInstance().removeMessage(1021182, this.aWV);
        MessageManager.getInstance().removeMessage(1021106, this.aWV);
        MessageManager.getInstance().removeMessage(1021107, this.aWV);
        MessageManager.getInstance().removeMessage(1021108, this.aWV);
        MessageManager.getInstance().removeMessage(1021109, this.aWV);
        MessageManager.getInstance().removeMessage(1021110, this.aWV);
        MessageManager.getInstance().removeMessage(1021111, this.aWV);
        MessageManager.getInstance().removeMessage(1021116, this.aWV);
    }

    private void bzU() {
        MessageManager.getInstance().removeMessage(1021112, this.aWV);
        MessageManager.getInstance().removeMessage(1021115, this.aWV);
    }

    private void reset() {
        this.fNJ = 0L;
        this.fNK = 0L;
        this.bgf = 0;
        this.fNB = 0;
        this.fNL = 0L;
        this.fNM = 0L;
        bzX();
        bzW();
        bzY();
        this.mHandler.removeCallbacksAndMessages(null);
        bzT();
        bzU();
    }

    public void bzV() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long vF() {
        return this.fNJ;
    }

    public void vy() {
        HttpMessage httpMessage = new HttpMessage(1021183);
        httpMessage.setTag(this.aWV);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void r(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.aWV);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void e(int i, int i2, String str) {
        HttpMessage httpMessage = new HttpMessage(1021182);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.addParam("query_words", str);
        httpMessage.setTag(this.aWV);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void V(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.aWV);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void W(long j) {
        this.fNJ = 0L;
        this.fNK = j;
        this.fNP = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        kG(true);
        this.mHandler.postDelayed(this.fNS, 1000L);
    }

    public void X(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.aWV);
        MessageManager.getInstance().sendMessage(httpMessage);
        dG(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void vz() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.aWV);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void Y(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.aWV);
        MessageManager.getInstance().sendMessage(httpMessage);
        dG(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void vA() {
        this.fNJ = 0L;
        this.fNP = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        kH(true);
        this.mHandler.postDelayed(this.fNT, 1000L);
    }

    public void vB() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.aWV);
        MessageManager.getInstance().sendMessage(httpMessage);
        dG(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, null);
    }

    public void vE() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.fNJ);
        httpMessage.setTag(this.aWV);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeSwitchResponsedMessage alaChallengeSwitchResponsedMessage) {
        if (alaChallengeSwitchResponsedMessage != null && this.fNi != null) {
            if (alaChallengeSwitchResponsedMessage.hasError() || alaChallengeSwitchResponsedMessage.getError() != 0) {
                this.fNi.l(alaChallengeSwitchResponsedMessage.getError(), alaChallengeSwitchResponsedMessage.getErrorString());
            } else {
                this.fNi.vH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.fNi != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.fNi.j(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.fNi.a(alaGetTargetListResponseMessage.bzR(), alaGetTargetListResponseMessage.bzS());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSearchTargetListResponseMessage alaSearchTargetListResponseMessage) {
        if (this.fNi != null && alaSearchTargetListResponseMessage != null) {
            if (alaSearchTargetListResponseMessage.hasError() || alaSearchTargetListResponseMessage.getError() != 0) {
                this.fNi.j(alaSearchTargetListResponseMessage.getError(), alaSearchTargetListResponseMessage.getErrorString());
            } else {
                this.fNi.a(alaSearchTargetListResponseMessage.bzR(), alaSearchTargetListResponseMessage.bzS());
            }
        }
    }

    private void bzW() {
        MessageManager.getInstance().removeMessage(1021106, this.aWV);
        this.mHandler.removeCallbacks(this.fNS);
        this.fNP = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kG(boolean z) {
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.fNK);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.aWV);
        MessageManager.getInstance().sendMessage(httpMessage);
        dG(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, ExtraParamsManager.getBase64(String.valueOf(this.fNK)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.fNi != null) {
            String base64 = ExtraParamsManager.getBase64(String.valueOf(this.fNK));
            String str = "";
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.bzJ() != null) {
                str = alaStartDirectChallengeResponseMessage.bzJ().auc + "";
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() != 0) {
                if (this.fNi != null) {
                    this.fNi.aI(alaStartDirectChallengeResponseMessage.getError(), alaStartDirectChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, alaStartDirectChallengeResponseMessage, base64, str);
                return;
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() == 0 && alaStartDirectChallengeResponseMessage.bzJ() != null && (alaStartDirectChallengeResponseMessage.bzJ().isValid() || alaStartDirectChallengeResponseMessage.bzJ().isTimeout())) {
                com.baidu.live.challenge.a bzJ = alaStartDirectChallengeResponseMessage.bzJ();
                this.fNi.b(bzJ);
                bzW();
                if (bzJ.vo()) {
                    dB(bzJ.challengeId);
                    this.fNJ = bzJ.challengeId;
                }
                if (alaStartDirectChallengeResponseMessage.bzJ().isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_TIMEOUT, alaStartDirectChallengeResponseMessage, base64, (String) null);
                }
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_SUCC, alaStartDirectChallengeResponseMessage, base64, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.fNi != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.fNi.aJ(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.fNK)), (String) null);
                return;
            }
            boolean bzL = alaCancelDirectChallengeResponseMessage.bzL();
            com.baidu.live.challenge.a bzJ = alaCancelDirectChallengeResponseMessage.bzJ();
            this.fNi.b(bzL, alaCancelDirectChallengeResponseMessage.bzJ());
            bzW();
            if (!bzL && bzJ != null && bzJ.vo()) {
                dB(bzJ.challengeId);
                this.fNJ = bzJ.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT_SUCC, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.fNK)), (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.fNi != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.fNi.aK(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.fNi.l(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.bzP());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.fNi != null && alaAcceptDirectChallengeResponseMessage != null) {
            String str = "";
            String str2 = "";
            if (alaAcceptDirectChallengeResponseMessage.bzJ() != null) {
                str2 = ExtraParamsManager.getBase64(String.valueOf(alaAcceptDirectChallengeResponseMessage.bzJ().aue));
            }
            if (alaAcceptDirectChallengeResponseMessage.bzJ() != null) {
                str = alaAcceptDirectChallengeResponseMessage.bzJ().auc + "";
            }
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.fNi.aL(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, alaAcceptDirectChallengeResponseMessage, str2, str);
                return;
            }
            boolean bzK = alaAcceptDirectChallengeResponseMessage.bzK();
            com.baidu.live.challenge.a bzJ = alaAcceptDirectChallengeResponseMessage.bzJ();
            this.fNi.c(bzK, bzJ);
            if (bzK && bzJ != null) {
                dB(bzJ.challengeId);
                this.fNJ = bzJ.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET_SUCC, alaAcceptDirectChallengeResponseMessage, str2, str);
        }
    }

    private void bzX() {
        MessageManager.getInstance().removeMessage(1021110, this.aWV);
        this.mHandler.removeCallbacks(this.fNT);
        this.fNP = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kH(boolean z) {
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.aWV);
        MessageManager.getInstance().sendMessage(httpMessage);
        dG(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        String str;
        String str2;
        if (this.fNi != null) {
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() != 0) {
                if (this.fNi != null) {
                    this.fNi.aM(alaStartRandomChallengeResponseMessage.getError(), alaStartRandomChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, (String) null, (String) null);
                return;
            }
            if (alaStartRandomChallengeResponseMessage == null || alaStartRandomChallengeResponseMessage.bzJ() == null) {
                str = null;
                str2 = null;
            } else {
                str2 = alaStartRandomChallengeResponseMessage.bzJ().auc + "";
                str = ExtraParamsManager.getBase64(alaStartRandomChallengeResponseMessage.bzJ().aue + "");
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.bzJ() != null && alaStartRandomChallengeResponseMessage.bzJ().isValid()) {
                com.baidu.live.challenge.a bzJ = alaStartRandomChallengeResponseMessage.bzJ();
                this.fNi.c(bzJ);
                if (bzJ.vo() && !vD()) {
                    bzX();
                    dB(bzJ.challengeId);
                    this.fNJ = bzJ.challengeId;
                }
                if (bzJ.isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOW_TIMEOUT, alaStartRandomChallengeResponseMessage, str, (String) null);
                }
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM_SUCC, alaStartRandomChallengeResponseMessage, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        String str;
        String str2 = null;
        if (this.fNi != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage == null || alaCancelRandomChallengeResponseMessage.bzJ() == null) {
                str = null;
            } else {
                str = alaCancelRandomChallengeResponseMessage.bzJ().challengeId + "";
                str2 = alaCancelRandomChallengeResponseMessage.bzJ().auc + "";
            }
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.fNi.aN(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, alaCancelRandomChallengeResponseMessage, str, str2);
                return;
            }
            boolean bzL = alaCancelRandomChallengeResponseMessage.bzL();
            com.baidu.live.challenge.a bzJ = alaCancelRandomChallengeResponseMessage.bzJ();
            this.fNi.d(bzL, alaCancelRandomChallengeResponseMessage.bzJ());
            bzX();
            if (!bzL && bzJ != null && bzJ.vo()) {
                dB(bzJ.challengeId);
                this.fNJ = bzJ.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCLE_RANDOM_SUCC, alaCancelRandomChallengeResponseMessage, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.fNi != null && alaSurrenderResponseMessage != null) {
            this.fNi.l(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.fNi != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.fNi.i(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.fNi.a(alaGetTargetInfoResponseMessage.bzQ());
            }
        }
    }

    public void aX(boolean z) {
        this.bgf = z ? 1 : 2;
    }

    public void dB(long j) {
        this.fNN = true;
        this.fNJ = j;
        this.mHandler.post(this.fNU);
    }

    private void bzY() {
        this.fNN = false;
        this.mHandler.removeCallbacks(this.fNU);
        this.fNR = false;
        MessageManager.getInstance().removeMessage(1021112, this.aWV);
    }

    public void bzZ() {
        this.mHandler.removeCallbacks(this.fNU);
        this.fNR = false;
        MessageManager.getInstance().removeMessage(1021112, this.aWV);
    }

    public void bAa() {
        this.mHandler.post(this.fNU);
    }

    private void a(ak akVar, al alVar, al alVar2, long j) {
        if (akVar == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info challenge meta is null?? logid=" + j);
        } else if (alVar != null && alVar.azA != null && alVar.azA.getLiveID() != this.eUH) {
            BdLog.e("CHALLENGE_TAG in challenge not current live?? ||Challenge id=" + akVar.challengeId + "||Challenge Status=" + akVar.azq + "||Net liveId=" + alVar.azA.getLiveID() + "||cur liveId=" + this.eUH + "||logid=" + j);
        } else {
            int i = akVar.azq;
            this.fNi.b(i, akVar, alVar, alVar2);
            switch (i) {
                case 2:
                    this.fNP = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    bzT();
                    break;
                case 3:
                    this.fNP = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.fNP = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.fNJ = 0L;
                    bzU();
                    break;
            }
            if (alVar != null && alVar.azo != null) {
                this.fNL = alVar.azo.userId;
            }
            if (alVar2 != null && alVar2.azo != null) {
                this.fNM = alVar2.azo.userId;
            }
            if (4 == akVar.azq || 5 == akVar.azq) {
                bzY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.fNi == null || alaGetChallengeInfoResponseMessage == null || alaGetChallengeInfoResponseMessage.bzM() == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info callback, response message, meta info  null?? ");
            if (alaGetChallengeInfoResponseMessage != null) {
                BdLog.e("CHALLENGE_TAG get Challenge Info error=" + alaGetChallengeInfoResponseMessage.getError());
                return;
            }
            return;
        }
        a(alaGetChallengeInfoResponseMessage.bzM(), alaGetChallengeInfoResponseMessage.bzN(), alaGetChallengeInfoResponseMessage.bzO(), alaGetChallengeInfoResponseMessage.getLogId());
    }

    public ChallenfeInfoData.ChallengeStatus vC() {
        return this.fNP;
    }

    private void dG(String str, String str2) {
        if (this.isHost) {
            UbcStatisticManager.getInstance().logSendRequest(v(str, str2, null, UbcStatisticLiveKey.KEY_ID_PK_REQ));
        }
    }

    private void a(String str, HttpResponsedMessage httpResponsedMessage, String str2, String str3) {
        if (this.isHost && httpResponsedMessage != null) {
            UbcStatisticManager.getInstance().logSendResponse(v(str, str2, str3, UbcStatisticLiveKey.KEY_ID_PK_RESP), httpResponsedMessage, true);
        }
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

    public boolean vD() {
        return this.fNN;
    }
}
