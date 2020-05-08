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
    private BdUniqueId aQK;
    private int aYJ;
    private long eIi;
    private long fzE;
    private long fzF;
    private long fzG;
    private long fzH;
    private long fzI;
    private long fzJ;
    private long fzK;
    private long fzM;
    private ChallenfeInfoData.ChallengeStatus fzN;
    private j.e fzO;
    private InterfaceC0512a fzg;
    private int fzz;
    private TbPageContext mPageContext;
    private boolean fzL = false;
    private HttpMessageListener aZt = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.1
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
    private HttpMessageListener aKt = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                a.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable fzP = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.3
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, a.this.aQK);
            a.this.km(false);
            a.this.mHandler.postDelayed(this, a.this.fzF);
        }
    };
    private Runnable fzQ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.4
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, a.this.aQK);
            a.this.kn(false);
            a.this.mHandler.postDelayed(this, a.this.fzE);
        }
    };
    private Runnable fzR = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.5
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021112, a.this.aQK);
            if (a.this.fzH > 0) {
                if (a.this.fzO != null) {
                    a.this.fzz = a.this.fzO.uz();
                }
                com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(a.this.fzH, a.this.aYJ, a.this.eIi, a.this.fzM, a.this.fzz);
                aVar.setTag(a.this.aQK);
                MessageManager.getInstance().sendMessage(aVar);
                a.this.mHandler.postDelayed(this, a.this.fzG);
            }
        }
    };
    private Handler mHandler = new Handler();

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0512a {
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

        void uA();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.aQK = bdUniqueId;
        this.fzE = com.baidu.live.v.a.En().aQu.asH > 0 ? com.baidu.live.v.a.En().aQu.asH : 1000L;
        this.fzF = com.baidu.live.v.a.En().aQu.asI > 0 ? com.baidu.live.v.a.En().aQu.asI : 1000L;
        this.fzG = com.baidu.live.v.a.En().aQu.asJ > 0 ? com.baidu.live.v.a.En().aQu.asJ : 1000L;
        this.fzN = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        xB();
        registerListener();
    }

    public void d(long j, long j2) {
        this.eIi = j;
        this.fzM = j2;
    }

    public void a(InterfaceC0512a interfaceC0512a) {
        this.fzg = interfaceC0512a;
    }

    public void b(j.e eVar) {
        this.fzO = eVar;
    }

    private void xB() {
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
        MessageManager.getInstance().registerListener(1021183, this.aZt);
        MessageManager.getInstance().registerListener(1021105, this.aZt);
        MessageManager.getInstance().registerListener(1021182, this.aZt);
        MessageManager.getInstance().registerListener(1021106, this.aZt);
        MessageManager.getInstance().registerListener(1021107, this.aZt);
        MessageManager.getInstance().registerListener(1021108, this.aZt);
        MessageManager.getInstance().registerListener(1021109, this.aZt);
        MessageManager.getInstance().registerListener(1021110, this.aZt);
        MessageManager.getInstance().registerListener(1021111, this.aZt);
        MessageManager.getInstance().registerListener(1021115, this.aZt);
        MessageManager.getInstance().registerListener(1021116, this.aZt);
        MessageManager.getInstance().registerListener(this.aKt);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.aZt);
        MessageManager.getInstance().unRegisterListener(this.aKt);
    }

    private void btU() {
        MessageManager.getInstance().removeMessage(1021183, this.aQK);
        MessageManager.getInstance().removeMessage(1021105, this.aQK);
        MessageManager.getInstance().removeMessage(1021182, this.aQK);
        MessageManager.getInstance().removeMessage(1021106, this.aQK);
        MessageManager.getInstance().removeMessage(1021107, this.aQK);
        MessageManager.getInstance().removeMessage(1021108, this.aQK);
        MessageManager.getInstance().removeMessage(1021109, this.aQK);
        MessageManager.getInstance().removeMessage(1021110, this.aQK);
        MessageManager.getInstance().removeMessage(1021111, this.aQK);
        MessageManager.getInstance().removeMessage(1021116, this.aQK);
    }

    private void btV() {
        MessageManager.getInstance().removeMessage(1021112, this.aQK);
        MessageManager.getInstance().removeMessage(1021115, this.aQK);
    }

    private void reset() {
        this.fzH = 0L;
        this.fzI = 0L;
        this.aYJ = 0;
        this.fzz = 0;
        this.fzJ = 0L;
        this.fzK = 0L;
        btY();
        btX();
        btZ();
        this.mHandler.removeCallbacksAndMessages(null);
        btU();
        btV();
    }

    public void btW() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long uy() {
        return this.fzH;
    }

    public void ur() {
        HttpMessage httpMessage = new HttpMessage(1021183);
        httpMessage.setTag(this.aQK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void r(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.aQK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void e(int i, int i2, String str) {
        HttpMessage httpMessage = new HttpMessage(1021182);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.addParam("query_words", str);
        httpMessage.setTag(this.aQK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void R(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.aQK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void S(long j) {
        this.fzH = 0L;
        this.fzI = j;
        this.fzN = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        km(true);
        this.mHandler.postDelayed(this.fzP, 1000L);
    }

    public void T(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.aQK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void us() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.aQK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void U(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.aQK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void ut() {
        this.fzH = 0L;
        this.fzN = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        kn(true);
        this.mHandler.postDelayed(this.fzQ, 1000L);
    }

    public void uu() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.aQK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void ux() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.fzH);
        httpMessage.setTag(this.aQK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeSwitchResponsedMessage alaChallengeSwitchResponsedMessage) {
        if (alaChallengeSwitchResponsedMessage != null && this.fzg != null) {
            if (alaChallengeSwitchResponsedMessage.hasError() || alaChallengeSwitchResponsedMessage.getError() != 0) {
                this.fzg.l(alaChallengeSwitchResponsedMessage.getError(), alaChallengeSwitchResponsedMessage.getErrorString());
            } else {
                this.fzg.uA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.fzg != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.fzg.j(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.fzg.a(alaGetTargetListResponseMessage.btS(), alaGetTargetListResponseMessage.btT());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSearchTargetListResponseMessage alaSearchTargetListResponseMessage) {
        if (this.fzg != null && alaSearchTargetListResponseMessage != null) {
            if (alaSearchTargetListResponseMessage.hasError() || alaSearchTargetListResponseMessage.getError() != 0) {
                this.fzg.j(alaSearchTargetListResponseMessage.getError(), alaSearchTargetListResponseMessage.getErrorString());
            } else {
                this.fzg.a(alaSearchTargetListResponseMessage.btS(), alaSearchTargetListResponseMessage.btT());
            }
        }
    }

    private void btX() {
        MessageManager.getInstance().removeMessage(1021106, this.aQK);
        this.mHandler.removeCallbacks(this.fzP);
        this.fzN = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void km(boolean z) {
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.fzI);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.aQK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.fzg != null) {
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() != 0) {
                if (this.fzg != null) {
                    this.fzg.aD(alaStartDirectChallengeResponseMessage.getError(), alaStartDirectChallengeResponseMessage.getErrorString());
                }
            } else if (alaStartDirectChallengeResponseMessage == null || alaStartDirectChallengeResponseMessage.getError() != 0 || alaStartDirectChallengeResponseMessage.btK() == null) {
            } else {
                if (alaStartDirectChallengeResponseMessage.btK().isValid() || alaStartDirectChallengeResponseMessage.btK().isTimeout()) {
                    com.baidu.live.challenge.a btK = alaStartDirectChallengeResponseMessage.btK();
                    this.fzg.b(btK);
                    btX();
                    if (btK.uh()) {
                        dA(btK.challengeId);
                        this.fzH = btK.challengeId;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.fzg != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.fzg.aE(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                return;
            }
            boolean btM = alaCancelDirectChallengeResponseMessage.btM();
            com.baidu.live.challenge.a btK = alaCancelDirectChallengeResponseMessage.btK();
            this.fzg.b(btM, alaCancelDirectChallengeResponseMessage.btK());
            btX();
            if (!btM && btK != null && btK.uh()) {
                dA(btK.challengeId);
                this.fzH = btK.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.fzg != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.fzg.aF(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.fzg.l(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.btQ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.fzg != null && alaAcceptDirectChallengeResponseMessage != null) {
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.fzg.aG(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                return;
            }
            boolean btL = alaAcceptDirectChallengeResponseMessage.btL();
            com.baidu.live.challenge.a btK = alaAcceptDirectChallengeResponseMessage.btK();
            this.fzg.c(btL, btK);
            if (btL && btK != null) {
                dA(btK.challengeId);
                this.fzH = btK.challengeId;
            }
        }
    }

    private void btY() {
        MessageManager.getInstance().removeMessage(1021110, this.aQK);
        this.mHandler.removeCallbacks(this.fzQ);
        this.fzN = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kn(boolean z) {
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.aQK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        if (this.fzg != null) {
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() != 0) {
                if (this.fzg != null) {
                    this.fzg.aH(alaStartRandomChallengeResponseMessage.getError(), alaStartRandomChallengeResponseMessage.getErrorString());
                }
            } else if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.btK() != null && alaStartRandomChallengeResponseMessage.btK().isValid()) {
                com.baidu.live.challenge.a btK = alaStartRandomChallengeResponseMessage.btK();
                this.fzg.c(btK);
                if (btK.uh() && !uw()) {
                    btY();
                    dA(btK.challengeId);
                    this.fzH = btK.challengeId;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        if (this.fzg != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.fzg.aI(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                return;
            }
            boolean btM = alaCancelRandomChallengeResponseMessage.btM();
            com.baidu.live.challenge.a btK = alaCancelRandomChallengeResponseMessage.btK();
            this.fzg.d(btM, alaCancelRandomChallengeResponseMessage.btK());
            btY();
            if (!btM && btK != null && btK.uh()) {
                dA(btK.challengeId);
                this.fzH = btK.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.fzg != null && alaSurrenderResponseMessage != null) {
            this.fzg.l(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.fzg != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.fzg.i(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.fzg.a(alaGetTargetInfoResponseMessage.btR());
            }
        }
    }

    public void aT(boolean z) {
        this.aYJ = z ? 1 : 2;
    }

    public void dA(long j) {
        this.fzL = true;
        this.fzH = j;
        this.mHandler.post(this.fzR);
    }

    private void btZ() {
        this.fzL = false;
        this.mHandler.removeCallbacks(this.fzR);
        MessageManager.getInstance().removeMessage(1021112, this.aQK);
    }

    public void bua() {
        this.mHandler.removeCallbacks(this.fzR);
        MessageManager.getInstance().removeMessage(1021112, this.aQK);
    }

    public void bub() {
        this.mHandler.post(this.fzR);
    }

    private void f(ag agVar, ah ahVar, ah ahVar2) {
        if (agVar != null) {
            if (ahVar == null || ahVar.auw == null || ahVar.auw.getLiveID() == this.eIi) {
                int i = agVar.aum;
                this.fzg.b(i, agVar, ahVar, ahVar2);
                switch (i) {
                    case 2:
                        this.fzN = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                        btU();
                        break;
                    case 3:
                        this.fzN = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                        break;
                    case 4:
                    case 5:
                        this.fzN = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                        this.fzH = 0L;
                        btV();
                        break;
                }
                if (ahVar != null && ahVar.auk != null) {
                    this.fzJ = ahVar.auk.userId;
                }
                if (ahVar2 != null && ahVar2.auk != null) {
                    this.fzK = ahVar2.auk.userId;
                }
                if (4 == agVar.aum || 5 == agVar.aum) {
                    btZ();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.fzg != null && alaGetChallengeInfoResponseMessage != null && alaGetChallengeInfoResponseMessage.btN() != null) {
            f(alaGetChallengeInfoResponseMessage.btN(), alaGetChallengeInfoResponseMessage.btO(), alaGetChallengeInfoResponseMessage.btP());
        }
    }

    public ChallenfeInfoData.ChallengeStatus uv() {
        return this.fzN;
    }

    public boolean uw() {
        return this.fzL;
    }
}
