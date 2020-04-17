package com.baidu.tieba.ala.liveroom.challenge.b;

import android.os.Handler;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.b;
import com.baidu.live.challenge.d;
import com.baidu.live.challenge.j;
import com.baidu.live.data.ag;
import com.baidu.live.data.ah;
import com.baidu.live.tbadk.TbPageContext;
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
/* loaded from: classes3.dex */
public class a {
    private BdUniqueId aQF;
    private int aYE;
    private long eId;
    private long fzA;
    private long fzB;
    private long fzC;
    private long fzD;
    private long fzE;
    private long fzF;
    private long fzH;
    private ChallenfeInfoData.ChallengeStatus fzI;
    private j.e fzJ;
    private InterfaceC0491a fzb;
    private int fzu;
    private long fzz;
    private TbPageContext mPageContext;
    private boolean fzG = false;
    private HttpMessageListener aZo = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.1
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
    private HttpMessageListener aKn = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                a.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable fzK = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.3
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, a.this.aQF);
            a.this.km(false);
            a.this.mHandler.postDelayed(this, a.this.fzA);
        }
    };
    private Runnable fzL = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.4
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, a.this.aQF);
            a.this.kn(false);
            a.this.mHandler.postDelayed(this, a.this.fzz);
        }
    };
    private Runnable fzM = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.5
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021112, a.this.aQF);
            if (a.this.fzC > 0) {
                if (a.this.fzJ != null) {
                    a.this.fzu = a.this.fzJ.uA();
                }
                com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(a.this.fzC, a.this.aYE, a.this.eId, a.this.fzH, a.this.fzu);
                aVar.setTag(a.this.aQF);
                MessageManager.getInstance().sendMessage(aVar);
                a.this.mHandler.postDelayed(this, a.this.fzB);
            }
        }
    };
    private Handler mHandler = new Handler();

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0491a {
        void a(b bVar, List<d> list);

        void a(d dVar);

        void aD(int i, String str);

        void aE(int i, String str);

        void aF(int i, String str);

        void aG(int i, String str);

        void aH(int i, String str);

        void aI(int i, String str);

        void b(int i, ag agVar, ah ahVar, ah ahVar2);

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

        void uB();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.aQF = bdUniqueId;
        this.fzz = com.baidu.live.v.a.Eo().aQp.asB > 0 ? com.baidu.live.v.a.Eo().aQp.asB : 1000L;
        this.fzA = com.baidu.live.v.a.Eo().aQp.asC > 0 ? com.baidu.live.v.a.Eo().aQp.asC : 1000L;
        this.fzB = com.baidu.live.v.a.Eo().aQp.asD > 0 ? com.baidu.live.v.a.Eo().aQp.asD : 1000L;
        this.fzI = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        xC();
        registerListener();
    }

    public void d(long j, long j2) {
        this.eId = j;
        this.fzH = j2;
    }

    public void a(InterfaceC0491a interfaceC0491a) {
        this.fzb = interfaceC0491a;
    }

    public void b(j.e eVar) {
        this.fzJ = eVar;
    }

    private void xC() {
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
        MessageManager.getInstance().registerListener(1021183, this.aZo);
        MessageManager.getInstance().registerListener(1021105, this.aZo);
        MessageManager.getInstance().registerListener(1021182, this.aZo);
        MessageManager.getInstance().registerListener(1021106, this.aZo);
        MessageManager.getInstance().registerListener(1021107, this.aZo);
        MessageManager.getInstance().registerListener(1021108, this.aZo);
        MessageManager.getInstance().registerListener(1021109, this.aZo);
        MessageManager.getInstance().registerListener(1021110, this.aZo);
        MessageManager.getInstance().registerListener(1021111, this.aZo);
        MessageManager.getInstance().registerListener(1021115, this.aZo);
        MessageManager.getInstance().registerListener(1021116, this.aZo);
        MessageManager.getInstance().registerListener(this.aKn);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.aZo);
        MessageManager.getInstance().unRegisterListener(this.aKn);
    }

    private void btW() {
        MessageManager.getInstance().removeMessage(1021183, this.aQF);
        MessageManager.getInstance().removeMessage(1021105, this.aQF);
        MessageManager.getInstance().removeMessage(1021182, this.aQF);
        MessageManager.getInstance().removeMessage(1021106, this.aQF);
        MessageManager.getInstance().removeMessage(1021107, this.aQF);
        MessageManager.getInstance().removeMessage(1021108, this.aQF);
        MessageManager.getInstance().removeMessage(1021109, this.aQF);
        MessageManager.getInstance().removeMessage(1021110, this.aQF);
        MessageManager.getInstance().removeMessage(1021111, this.aQF);
        MessageManager.getInstance().removeMessage(1021116, this.aQF);
    }

    private void btX() {
        MessageManager.getInstance().removeMessage(1021112, this.aQF);
        MessageManager.getInstance().removeMessage(1021115, this.aQF);
    }

    private void reset() {
        this.fzC = 0L;
        this.fzD = 0L;
        this.aYE = 0;
        this.fzu = 0;
        this.fzE = 0L;
        this.fzF = 0L;
        bua();
        btZ();
        bub();
        this.mHandler.removeCallbacksAndMessages(null);
        btW();
        btX();
    }

    public void btY() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long uz() {
        return this.fzC;
    }

    public void us() {
        HttpMessage httpMessage = new HttpMessage(1021183);
        httpMessage.setTag(this.aQF);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void r(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.aQF);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void e(int i, int i2, String str) {
        HttpMessage httpMessage = new HttpMessage(1021182);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.addParam("query_words", str);
        httpMessage.setTag(this.aQF);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void R(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.aQF);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void S(long j) {
        this.fzC = 0L;
        this.fzD = j;
        this.fzI = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        km(true);
        this.mHandler.postDelayed(this.fzK, 1000L);
    }

    public void T(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.aQF);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void ut() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.aQF);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void U(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.aQF);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void uu() {
        this.fzC = 0L;
        this.fzI = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        kn(true);
        this.mHandler.postDelayed(this.fzL, 1000L);
    }

    public void uv() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.aQF);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void uy() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.fzC);
        httpMessage.setTag(this.aQF);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeSwitchResponsedMessage alaChallengeSwitchResponsedMessage) {
        if (alaChallengeSwitchResponsedMessage != null && this.fzb != null) {
            if (alaChallengeSwitchResponsedMessage.hasError() || alaChallengeSwitchResponsedMessage.getError() != 0) {
                this.fzb.l(alaChallengeSwitchResponsedMessage.getError(), alaChallengeSwitchResponsedMessage.getErrorString());
            } else {
                this.fzb.uB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.fzb != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.fzb.j(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.fzb.a(alaGetTargetListResponseMessage.btU(), alaGetTargetListResponseMessage.btV());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSearchTargetListResponseMessage alaSearchTargetListResponseMessage) {
        if (this.fzb != null && alaSearchTargetListResponseMessage != null) {
            if (alaSearchTargetListResponseMessage.hasError() || alaSearchTargetListResponseMessage.getError() != 0) {
                this.fzb.j(alaSearchTargetListResponseMessage.getError(), alaSearchTargetListResponseMessage.getErrorString());
            } else {
                this.fzb.a(alaSearchTargetListResponseMessage.btU(), alaSearchTargetListResponseMessage.btV());
            }
        }
    }

    private void btZ() {
        MessageManager.getInstance().removeMessage(1021106, this.aQF);
        this.mHandler.removeCallbacks(this.fzK);
        this.fzI = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void km(boolean z) {
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.fzD);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.aQF);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.fzb != null) {
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() != 0) {
                if (this.fzb != null) {
                    this.fzb.aD(alaStartDirectChallengeResponseMessage.getError(), alaStartDirectChallengeResponseMessage.getErrorString());
                }
            } else if (alaStartDirectChallengeResponseMessage == null || alaStartDirectChallengeResponseMessage.getError() != 0 || alaStartDirectChallengeResponseMessage.btM() == null) {
            } else {
                if (alaStartDirectChallengeResponseMessage.btM().isValid() || alaStartDirectChallengeResponseMessage.btM().isTimeout()) {
                    com.baidu.live.challenge.a btM = alaStartDirectChallengeResponseMessage.btM();
                    this.fzb.b(btM);
                    btZ();
                    if (btM.ui()) {
                        dA(btM.challengeId);
                        this.fzC = btM.challengeId;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.fzb != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.fzb.aE(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                return;
            }
            boolean btO = alaCancelDirectChallengeResponseMessage.btO();
            com.baidu.live.challenge.a btM = alaCancelDirectChallengeResponseMessage.btM();
            this.fzb.b(btO, alaCancelDirectChallengeResponseMessage.btM());
            btZ();
            if (!btO && btM != null && btM.ui()) {
                dA(btM.challengeId);
                this.fzC = btM.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.fzb != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.fzb.aF(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.fzb.l(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.btS());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.fzb != null && alaAcceptDirectChallengeResponseMessage != null) {
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.fzb.aG(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                return;
            }
            boolean btN = alaAcceptDirectChallengeResponseMessage.btN();
            com.baidu.live.challenge.a btM = alaAcceptDirectChallengeResponseMessage.btM();
            this.fzb.c(btN, btM);
            if (btN && btM != null) {
                dA(btM.challengeId);
                this.fzC = btM.challengeId;
            }
        }
    }

    private void bua() {
        MessageManager.getInstance().removeMessage(1021110, this.aQF);
        this.mHandler.removeCallbacks(this.fzL);
        this.fzI = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kn(boolean z) {
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.aQF);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        if (this.fzb != null) {
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() != 0) {
                if (this.fzb != null) {
                    this.fzb.aH(alaStartRandomChallengeResponseMessage.getError(), alaStartRandomChallengeResponseMessage.getErrorString());
                }
            } else if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.btM() != null && alaStartRandomChallengeResponseMessage.btM().isValid()) {
                com.baidu.live.challenge.a btM = alaStartRandomChallengeResponseMessage.btM();
                this.fzb.c(btM);
                if (btM.ui() && !ux()) {
                    bua();
                    dA(btM.challengeId);
                    this.fzC = btM.challengeId;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        if (this.fzb != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.fzb.aI(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                return;
            }
            boolean btO = alaCancelRandomChallengeResponseMessage.btO();
            com.baidu.live.challenge.a btM = alaCancelRandomChallengeResponseMessage.btM();
            this.fzb.d(btO, alaCancelRandomChallengeResponseMessage.btM());
            bua();
            if (!btO && btM != null && btM.ui()) {
                dA(btM.challengeId);
                this.fzC = btM.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.fzb != null && alaSurrenderResponseMessage != null) {
            this.fzb.l(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.fzb != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.fzb.i(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.fzb.a(alaGetTargetInfoResponseMessage.btT());
            }
        }
    }

    public void aT(boolean z) {
        this.aYE = z ? 1 : 2;
    }

    public void dA(long j) {
        this.fzG = true;
        this.fzC = j;
        this.mHandler.post(this.fzM);
    }

    private void bub() {
        this.fzG = false;
        this.mHandler.removeCallbacks(this.fzM);
        MessageManager.getInstance().removeMessage(1021112, this.aQF);
    }

    public void buc() {
        this.mHandler.removeCallbacks(this.fzM);
        MessageManager.getInstance().removeMessage(1021112, this.aQF);
    }

    public void bud() {
        this.mHandler.post(this.fzM);
    }

    private void f(ag agVar, ah ahVar, ah ahVar2) {
        if (agVar != null) {
            if (ahVar == null || ahVar.auq == null || ahVar.auq.getLiveID() == this.eId) {
                int i = agVar.aug;
                this.fzb.b(i, agVar, ahVar, ahVar2);
                switch (i) {
                    case 2:
                        this.fzI = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                        btW();
                        break;
                    case 3:
                        this.fzI = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                        break;
                    case 4:
                    case 5:
                        this.fzI = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                        this.fzC = 0L;
                        btX();
                        break;
                }
                if (ahVar != null && ahVar.aue != null) {
                    this.fzE = ahVar.aue.userId;
                }
                if (ahVar2 != null && ahVar2.aue != null) {
                    this.fzF = ahVar2.aue.userId;
                }
                if (4 == agVar.aug || 5 == agVar.aug) {
                    bub();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.fzb != null && alaGetChallengeInfoResponseMessage != null && alaGetChallengeInfoResponseMessage.btP() != null) {
            f(alaGetChallengeInfoResponseMessage.btP(), alaGetChallengeInfoResponseMessage.btQ(), alaGetChallengeInfoResponseMessage.btR());
        }
    }

    public ChallenfeInfoData.ChallengeStatus uw() {
        return this.fzI;
    }

    public boolean ux() {
        return this.fzG;
    }
}
