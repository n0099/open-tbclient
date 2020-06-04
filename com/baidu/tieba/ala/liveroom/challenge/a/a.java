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
    private long eUS;
    private int fNM;
    private long fNR;
    private long fNS;
    private long fNT;
    private long fNU;
    private long fNV;
    private long fNW;
    private long fNX;
    private long fNZ;
    private InterfaceC0559a fNt;
    private ChallenfeInfoData.ChallengeStatus fOa;
    private j.e fOb;
    private boolean isHost;
    private TbPageContext mPageContext;
    private boolean fNY = false;
    private boolean fOc = false;
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
                a.this.fOc = false;
                a.this.b((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                a.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable fOd = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.a.a.3
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, a.this.aWV);
            a.this.kG(false);
            a.this.mHandler.postDelayed(this, a.this.fNS);
        }
    };
    private Runnable fOe = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.a.a.4
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, a.this.aWV);
            a.this.kH(false);
            a.this.mHandler.postDelayed(this, a.this.fNR);
        }
    };
    private Runnable fOf = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.a.a.5
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fNU <= 0) {
                a.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().removeMessage(1021112, a.this.aWV);
                return;
            }
            a.this.mHandler.removeCallbacks(this);
            if (a.this.fOc) {
                a.this.mHandler.postDelayed(this, a.this.fNT);
                return;
            }
            MessageManager.getInstance().removeMessage(1021112, a.this.aWV);
            if (a.this.fOb != null) {
                a.this.fNM = a.this.fOb.vG();
            }
            a.this.fOc = true;
            com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(a.this.fNU, a.this.bgf, a.this.eUS, a.this.fNZ, a.this.fNM);
            aVar.setTag(a.this.aWV);
            MessageManager.getInstance().sendMessage(aVar);
            if (a.this.isHost) {
                UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_REQ, UbcStatConstant.ContentType.UBC_TYPE_PK_CHALLENGE_INFO, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("avts_conn", a.this.bgf);
                    jSONObject2.put("avts_fail", a.this.fNM);
                    jSONObject2.put("chat_id", a.this.fNU);
                    jSONObject.put("pk", jSONObject2);
                } catch (JSONException e) {
                }
                ubcStatisticItem.setContentExt(jSONObject);
                UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
            }
            a.this.mHandler.postDelayed(this, a.this.fNT);
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
                jSONObject2.put("avts_fail", this.fNM);
                if (alaGetChallengeInfoResponseMessage.bzO() != null) {
                    jSONObject2.put("chat_id", alaGetChallengeInfoResponseMessage.bzO().challengeId);
                    jSONObject2.put("chat_status", alaGetChallengeInfoResponseMessage.bzO().azq);
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
        this.fNR = com.baidu.live.v.a.Ge().aWF.axH > 0 ? com.baidu.live.v.a.Ge().aWF.axH : 1000L;
        this.fNS = com.baidu.live.v.a.Ge().aWF.axI > 0 ? com.baidu.live.v.a.Ge().aWF.axI : 1000L;
        this.fNT = com.baidu.live.v.a.Ge().aWF.axJ > 0 ? com.baidu.live.v.a.Ge().aWF.axJ : 1000L;
        this.fOa = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        Fv();
        registerListener();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public void e(long j, long j2) {
        this.eUS = j;
        this.fNZ = j2;
    }

    public void a(InterfaceC0559a interfaceC0559a) {
        this.fNt = interfaceC0559a;
    }

    public void b(j.e eVar) {
        this.fOb = eVar;
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

    private void bzV() {
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

    private void bzW() {
        MessageManager.getInstance().removeMessage(1021112, this.aWV);
        MessageManager.getInstance().removeMessage(1021115, this.aWV);
    }

    private void reset() {
        this.fNU = 0L;
        this.fNV = 0L;
        this.bgf = 0;
        this.fNM = 0;
        this.fNW = 0L;
        this.fNX = 0L;
        bzZ();
        bzY();
        bAa();
        this.mHandler.removeCallbacksAndMessages(null);
        bzV();
        bzW();
    }

    public void bzX() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long vF() {
        return this.fNU;
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
        this.fNU = 0L;
        this.fNV = j;
        this.fOa = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        kG(true);
        this.mHandler.postDelayed(this.fOd, 1000L);
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
        this.fNU = 0L;
        this.fOa = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        kH(true);
        this.mHandler.postDelayed(this.fOe, 1000L);
    }

    public void vB() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.aWV);
        MessageManager.getInstance().sendMessage(httpMessage);
        dG(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, null);
    }

    public void vE() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.fNU);
        httpMessage.setTag(this.aWV);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeSwitchResponsedMessage alaChallengeSwitchResponsedMessage) {
        if (alaChallengeSwitchResponsedMessage != null && this.fNt != null) {
            if (alaChallengeSwitchResponsedMessage.hasError() || alaChallengeSwitchResponsedMessage.getError() != 0) {
                this.fNt.l(alaChallengeSwitchResponsedMessage.getError(), alaChallengeSwitchResponsedMessage.getErrorString());
            } else {
                this.fNt.vH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.fNt != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.fNt.j(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.fNt.a(alaGetTargetListResponseMessage.bzT(), alaGetTargetListResponseMessage.bzU());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSearchTargetListResponseMessage alaSearchTargetListResponseMessage) {
        if (this.fNt != null && alaSearchTargetListResponseMessage != null) {
            if (alaSearchTargetListResponseMessage.hasError() || alaSearchTargetListResponseMessage.getError() != 0) {
                this.fNt.j(alaSearchTargetListResponseMessage.getError(), alaSearchTargetListResponseMessage.getErrorString());
            } else {
                this.fNt.a(alaSearchTargetListResponseMessage.bzT(), alaSearchTargetListResponseMessage.bzU());
            }
        }
    }

    private void bzY() {
        MessageManager.getInstance().removeMessage(1021106, this.aWV);
        this.mHandler.removeCallbacks(this.fOd);
        this.fOa = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kG(boolean z) {
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.fNV);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.aWV);
        MessageManager.getInstance().sendMessage(httpMessage);
        dG(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, ExtraParamsManager.getBase64(String.valueOf(this.fNV)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.fNt != null) {
            String base64 = ExtraParamsManager.getBase64(String.valueOf(this.fNV));
            String str = "";
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.bzL() != null) {
                str = alaStartDirectChallengeResponseMessage.bzL().auc + "";
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() != 0) {
                if (this.fNt != null) {
                    this.fNt.aI(alaStartDirectChallengeResponseMessage.getError(), alaStartDirectChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, alaStartDirectChallengeResponseMessage, base64, str);
                return;
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() == 0 && alaStartDirectChallengeResponseMessage.bzL() != null && (alaStartDirectChallengeResponseMessage.bzL().isValid() || alaStartDirectChallengeResponseMessage.bzL().isTimeout())) {
                com.baidu.live.challenge.a bzL = alaStartDirectChallengeResponseMessage.bzL();
                this.fNt.b(bzL);
                bzY();
                if (bzL.vo()) {
                    dB(bzL.challengeId);
                    this.fNU = bzL.challengeId;
                }
                if (alaStartDirectChallengeResponseMessage.bzL().isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_TIMEOUT, alaStartDirectChallengeResponseMessage, base64, (String) null);
                }
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_SUCC, alaStartDirectChallengeResponseMessage, base64, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.fNt != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.fNt.aJ(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.fNV)), (String) null);
                return;
            }
            boolean bzN = alaCancelDirectChallengeResponseMessage.bzN();
            com.baidu.live.challenge.a bzL = alaCancelDirectChallengeResponseMessage.bzL();
            this.fNt.b(bzN, alaCancelDirectChallengeResponseMessage.bzL());
            bzY();
            if (!bzN && bzL != null && bzL.vo()) {
                dB(bzL.challengeId);
                this.fNU = bzL.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT_SUCC, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.fNV)), (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.fNt != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.fNt.aK(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.fNt.l(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.bzR());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.fNt != null && alaAcceptDirectChallengeResponseMessage != null) {
            String str = "";
            String str2 = "";
            if (alaAcceptDirectChallengeResponseMessage.bzL() != null) {
                str2 = ExtraParamsManager.getBase64(String.valueOf(alaAcceptDirectChallengeResponseMessage.bzL().aue));
            }
            if (alaAcceptDirectChallengeResponseMessage.bzL() != null) {
                str = alaAcceptDirectChallengeResponseMessage.bzL().auc + "";
            }
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.fNt.aL(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, alaAcceptDirectChallengeResponseMessage, str2, str);
                return;
            }
            boolean bzM = alaAcceptDirectChallengeResponseMessage.bzM();
            com.baidu.live.challenge.a bzL = alaAcceptDirectChallengeResponseMessage.bzL();
            this.fNt.c(bzM, bzL);
            if (bzM && bzL != null) {
                dB(bzL.challengeId);
                this.fNU = bzL.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET_SUCC, alaAcceptDirectChallengeResponseMessage, str2, str);
        }
    }

    private void bzZ() {
        MessageManager.getInstance().removeMessage(1021110, this.aWV);
        this.mHandler.removeCallbacks(this.fOe);
        this.fOa = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
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
        if (this.fNt != null) {
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() != 0) {
                if (this.fNt != null) {
                    this.fNt.aM(alaStartRandomChallengeResponseMessage.getError(), alaStartRandomChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, (String) null, (String) null);
                return;
            }
            if (alaStartRandomChallengeResponseMessage == null || alaStartRandomChallengeResponseMessage.bzL() == null) {
                str = null;
                str2 = null;
            } else {
                str2 = alaStartRandomChallengeResponseMessage.bzL().auc + "";
                str = ExtraParamsManager.getBase64(alaStartRandomChallengeResponseMessage.bzL().aue + "");
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.bzL() != null && alaStartRandomChallengeResponseMessage.bzL().isValid()) {
                com.baidu.live.challenge.a bzL = alaStartRandomChallengeResponseMessage.bzL();
                this.fNt.c(bzL);
                if (bzL.vo() && !vD()) {
                    bzZ();
                    dB(bzL.challengeId);
                    this.fNU = bzL.challengeId;
                }
                if (bzL.isTimeout()) {
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
        if (this.fNt != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage == null || alaCancelRandomChallengeResponseMessage.bzL() == null) {
                str = null;
            } else {
                str = alaCancelRandomChallengeResponseMessage.bzL().challengeId + "";
                str2 = alaCancelRandomChallengeResponseMessage.bzL().auc + "";
            }
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.fNt.aN(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, alaCancelRandomChallengeResponseMessage, str, str2);
                return;
            }
            boolean bzN = alaCancelRandomChallengeResponseMessage.bzN();
            com.baidu.live.challenge.a bzL = alaCancelRandomChallengeResponseMessage.bzL();
            this.fNt.d(bzN, alaCancelRandomChallengeResponseMessage.bzL());
            bzZ();
            if (!bzN && bzL != null && bzL.vo()) {
                dB(bzL.challengeId);
                this.fNU = bzL.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCLE_RANDOM_SUCC, alaCancelRandomChallengeResponseMessage, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.fNt != null && alaSurrenderResponseMessage != null) {
            this.fNt.l(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.fNt != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.fNt.i(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.fNt.a(alaGetTargetInfoResponseMessage.bzS());
            }
        }
    }

    public void aX(boolean z) {
        this.bgf = z ? 1 : 2;
    }

    public void dB(long j) {
        this.fNY = true;
        this.fNU = j;
        this.mHandler.post(this.fOf);
    }

    private void bAa() {
        this.fNY = false;
        this.mHandler.removeCallbacks(this.fOf);
        this.fOc = false;
        MessageManager.getInstance().removeMessage(1021112, this.aWV);
    }

    public void bAb() {
        this.mHandler.removeCallbacks(this.fOf);
        this.fOc = false;
        MessageManager.getInstance().removeMessage(1021112, this.aWV);
    }

    public void bAc() {
        this.mHandler.post(this.fOf);
    }

    private void a(ak akVar, al alVar, al alVar2, long j) {
        if (akVar == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info challenge meta is null?? logid=" + j);
        } else if (alVar != null && alVar.azA != null && alVar.azA.getLiveID() != this.eUS) {
            BdLog.e("CHALLENGE_TAG in challenge not current live?? ||Challenge id=" + akVar.challengeId + "||Challenge Status=" + akVar.azq + "||Net liveId=" + alVar.azA.getLiveID() + "||cur liveId=" + this.eUS + "||logid=" + j);
        } else {
            int i = akVar.azq;
            this.fNt.b(i, akVar, alVar, alVar2);
            switch (i) {
                case 2:
                    this.fOa = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    bzV();
                    break;
                case 3:
                    this.fOa = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.fOa = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.fNU = 0L;
                    bzW();
                    break;
            }
            if (alVar != null && alVar.azo != null) {
                this.fNW = alVar.azo.userId;
            }
            if (alVar2 != null && alVar2.azo != null) {
                this.fNX = alVar2.azo.userId;
            }
            if (4 == akVar.azq || 5 == akVar.azq) {
                bAa();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.fNt == null || alaGetChallengeInfoResponseMessage == null || alaGetChallengeInfoResponseMessage.bzO() == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info callback, response message, meta info  null?? ");
            if (alaGetChallengeInfoResponseMessage != null) {
                BdLog.e("CHALLENGE_TAG get Challenge Info error=" + alaGetChallengeInfoResponseMessage.getError());
                return;
            }
            return;
        }
        a(alaGetChallengeInfoResponseMessage.bzO(), alaGetChallengeInfoResponseMessage.bzP(), alaGetChallengeInfoResponseMessage.bzQ(), alaGetChallengeInfoResponseMessage.getLogId());
    }

    public ChallenfeInfoData.ChallengeStatus vC() {
        return this.fOa;
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
        return this.fNY;
    }
}
