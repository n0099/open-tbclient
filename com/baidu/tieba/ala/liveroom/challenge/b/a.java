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
import com.baidu.live.data.ad;
import com.baidu.live.data.ae;
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
    private BdUniqueId arR;
    private InterfaceC0456a eTW;
    private long eUA;
    private long eUB;
    private long eUC;
    private long eUD;
    private long eUE;
    private long eUF;
    private long eUH;
    private ChallenfeInfoData.ChallengeStatus eUI;
    private j.e eUJ;
    private int eUq;
    private int eUr;
    private long eUz;
    private long ehL;
    private TbPageContext mPageContext;
    private boolean eUG = false;
    private HttpMessageListener eUK = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.1
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
    private HttpMessageListener ark = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                a.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable eUL = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.3
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, a.this.arR);
            a.this.jj(false);
            a.this.mHandler.postDelayed(this, a.this.eUA);
        }
    };
    private Runnable eUM = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.4
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, a.this.arR);
            a.this.jk(false);
            a.this.mHandler.postDelayed(this, a.this.eUz);
        }
    };
    private Runnable eUN = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.5
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021112, a.this.arR);
            if (a.this.eUC > 0) {
                if (a.this.eUJ != null) {
                    a.this.eUr = a.this.eUJ.qe();
                }
                com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(a.this.eUC, a.this.eUq, a.this.ehL, a.this.eUH, a.this.eUr);
                aVar.setTag(a.this.arR);
                MessageManager.getInstance().sendMessage(aVar);
                a.this.mHandler.postDelayed(this, a.this.eUB);
            }
        }
    };
    private Handler mHandler = new Handler();

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0456a {
        void a(b bVar, List<d> list);

        void a(d dVar);

        void ao(int i, String str);

        void ap(int i, String str);

        void aq(int i, String str);

        void ar(int i, String str);

        void as(int i, String str);

        void at(int i, String str);

        void b(int i, ad adVar, ae aeVar, ae aeVar2);

        void b(com.baidu.live.challenge.a aVar);

        void b(boolean z, com.baidu.live.challenge.a aVar);

        void c(com.baidu.live.challenge.a aVar);

        void c(boolean z, com.baidu.live.challenge.a aVar);

        void d(boolean z, com.baidu.live.challenge.a aVar);

        void j(int i, String str);

        void k(int i, String str);

        void k(int i, List<d> list);

        void k(boolean z, String str);

        void m(int i, String str);

        void qf();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.arR = bdUniqueId;
        this.eUz = com.baidu.live.v.a.zl().awB.aab > 0 ? com.baidu.live.v.a.zl().awB.aab : 1000L;
        this.eUA = com.baidu.live.v.a.zl().awB.aac > 0 ? com.baidu.live.v.a.zl().awB.aac : 1000L;
        this.eUB = com.baidu.live.v.a.zl().awB.aae > 0 ? com.baidu.live.v.a.zl().awB.aae : 1000L;
        this.eUI = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        te();
        registerListener();
    }

    public void d(long j, long j2) {
        this.ehL = j;
        this.eUH = j2;
    }

    public void a(InterfaceC0456a interfaceC0456a) {
        this.eTW = interfaceC0456a;
    }

    public void b(j.e eVar) {
        this.eUJ = eVar;
    }

    private void te() {
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
        MessageManager.getInstance().registerListener(1021183, this.eUK);
        MessageManager.getInstance().registerListener(1021105, this.eUK);
        MessageManager.getInstance().registerListener(1021182, this.eUK);
        MessageManager.getInstance().registerListener(1021106, this.eUK);
        MessageManager.getInstance().registerListener(1021107, this.eUK);
        MessageManager.getInstance().registerListener(1021108, this.eUK);
        MessageManager.getInstance().registerListener(1021109, this.eUK);
        MessageManager.getInstance().registerListener(1021110, this.eUK);
        MessageManager.getInstance().registerListener(1021111, this.eUK);
        MessageManager.getInstance().registerListener(1021115, this.eUK);
        MessageManager.getInstance().registerListener(1021116, this.eUK);
        MessageManager.getInstance().registerListener(this.ark);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.eUK);
        MessageManager.getInstance().unRegisterListener(this.ark);
    }

    private void bkx() {
        MessageManager.getInstance().removeMessage(1021183, this.arR);
        MessageManager.getInstance().removeMessage(1021105, this.arR);
        MessageManager.getInstance().removeMessage(1021182, this.arR);
        MessageManager.getInstance().removeMessage(1021106, this.arR);
        MessageManager.getInstance().removeMessage(1021107, this.arR);
        MessageManager.getInstance().removeMessage(1021108, this.arR);
        MessageManager.getInstance().removeMessage(1021109, this.arR);
        MessageManager.getInstance().removeMessage(1021110, this.arR);
        MessageManager.getInstance().removeMessage(1021111, this.arR);
        MessageManager.getInstance().removeMessage(1021116, this.arR);
    }

    private void bky() {
        MessageManager.getInstance().removeMessage(1021112, this.arR);
        MessageManager.getInstance().removeMessage(1021115, this.arR);
    }

    private void reset() {
        this.eUC = 0L;
        this.eUD = 0L;
        this.eUq = 0;
        this.eUr = 0;
        this.eUE = 0L;
        this.eUF = 0L;
        bkB();
        bkA();
        bkC();
        this.mHandler.removeCallbacksAndMessages(null);
        bkx();
        bky();
    }

    public void bkz() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long qd() {
        return this.eUC;
    }

    public void pW() {
        HttpMessage httpMessage = new HttpMessage(1021183);
        httpMessage.setTag(this.arR);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void s(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.arR);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void e(int i, int i2, String str) {
        HttpMessage httpMessage = new HttpMessage(1021182);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.addParam("query_words", str);
        httpMessage.setTag(this.arR);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void t(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.arR);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void u(long j) {
        this.eUC = 0L;
        this.eUD = j;
        this.eUI = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        jj(true);
        this.mHandler.postDelayed(this.eUL, 1000L);
    }

    public void v(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.arR);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void pX() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.arR);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void w(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.arR);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void pY() {
        this.eUC = 0L;
        this.eUI = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        jk(true);
        this.mHandler.postDelayed(this.eUM, 1000L);
    }

    public void pZ() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.arR);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void qc() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.eUC);
        httpMessage.setTag(this.arR);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeSwitchResponsedMessage alaChallengeSwitchResponsedMessage) {
        if (alaChallengeSwitchResponsedMessage != null && this.eTW != null) {
            if (alaChallengeSwitchResponsedMessage.hasError() || alaChallengeSwitchResponsedMessage.getError() != 0) {
                this.eTW.m(alaChallengeSwitchResponsedMessage.getError(), alaChallengeSwitchResponsedMessage.getErrorString());
            } else {
                this.eTW.qf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.eTW != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.eTW.k(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.eTW.a(alaGetTargetListResponseMessage.bkv(), alaGetTargetListResponseMessage.bkw());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSearchTargetListResponseMessage alaSearchTargetListResponseMessage) {
        if (this.eTW != null && alaSearchTargetListResponseMessage != null) {
            if (alaSearchTargetListResponseMessage.hasError() || alaSearchTargetListResponseMessage.getError() != 0) {
                this.eTW.k(alaSearchTargetListResponseMessage.getError(), alaSearchTargetListResponseMessage.getErrorString());
            } else {
                this.eTW.a(alaSearchTargetListResponseMessage.bkv(), alaSearchTargetListResponseMessage.bkw());
            }
        }
    }

    private void bkA() {
        MessageManager.getInstance().removeMessage(1021106, this.arR);
        this.mHandler.removeCallbacks(this.eUL);
        this.eUI = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jj(boolean z) {
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.eUD);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.arR);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.eTW != null) {
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() != 0) {
                if (this.eTW != null) {
                    this.eTW.ao(alaStartDirectChallengeResponseMessage.getError(), alaStartDirectChallengeResponseMessage.getErrorString());
                }
            } else if (alaStartDirectChallengeResponseMessage == null || alaStartDirectChallengeResponseMessage.getError() != 0 || alaStartDirectChallengeResponseMessage.bkn() == null) {
            } else {
                if (alaStartDirectChallengeResponseMessage.bkn().isValid() || alaStartDirectChallengeResponseMessage.bkn().isTimeout()) {
                    com.baidu.live.challenge.a bkn = alaStartDirectChallengeResponseMessage.bkn();
                    this.eTW.b(bkn);
                    bkA();
                    if (bkn.pM()) {
                        cS(bkn.challengeId);
                        this.eUC = bkn.challengeId;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.eTW != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.eTW.ap(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                return;
            }
            boolean bkp = alaCancelDirectChallengeResponseMessage.bkp();
            com.baidu.live.challenge.a bkn = alaCancelDirectChallengeResponseMessage.bkn();
            this.eTW.b(bkp, alaCancelDirectChallengeResponseMessage.bkn());
            bkA();
            if (!bkp && bkn != null && bkn.pM()) {
                cS(bkn.challengeId);
                this.eUC = bkn.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.eTW != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.eTW.aq(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.eTW.k(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.bkt());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.eTW != null && alaAcceptDirectChallengeResponseMessage != null) {
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.eTW.ar(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                return;
            }
            boolean bko = alaAcceptDirectChallengeResponseMessage.bko();
            com.baidu.live.challenge.a bkn = alaAcceptDirectChallengeResponseMessage.bkn();
            this.eTW.c(bko, bkn);
            if (bko && bkn != null) {
                cS(bkn.challengeId);
                this.eUC = bkn.challengeId;
            }
        }
    }

    private void bkB() {
        MessageManager.getInstance().removeMessage(1021110, this.arR);
        this.mHandler.removeCallbacks(this.eUM);
        this.eUI = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jk(boolean z) {
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.arR);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        if (this.eTW != null) {
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() != 0) {
                if (this.eTW != null) {
                    this.eTW.as(alaStartRandomChallengeResponseMessage.getError(), alaStartRandomChallengeResponseMessage.getErrorString());
                }
            } else if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.bkn() != null && alaStartRandomChallengeResponseMessage.bkn().isValid()) {
                com.baidu.live.challenge.a bkn = alaStartRandomChallengeResponseMessage.bkn();
                this.eTW.c(bkn);
                if (bkn.pM() && !qb()) {
                    bkB();
                    cS(bkn.challengeId);
                    this.eUC = bkn.challengeId;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        if (this.eTW != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.eTW.at(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                return;
            }
            boolean bkp = alaCancelRandomChallengeResponseMessage.bkp();
            com.baidu.live.challenge.a bkn = alaCancelRandomChallengeResponseMessage.bkn();
            this.eTW.d(bkp, alaCancelRandomChallengeResponseMessage.bkn());
            bkB();
            if (!bkp && bkn != null && bkn.pM()) {
                cS(bkn.challengeId);
                this.eUC = bkn.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.eTW != null && alaSurrenderResponseMessage != null) {
            this.eTW.k(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.eTW != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.eTW.j(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.eTW.a(alaGetTargetInfoResponseMessage.bku());
            }
        }
    }

    public void av(boolean z) {
        this.eUq = z ? 1 : 2;
    }

    public void cS(long j) {
        this.eUG = true;
        this.eUC = j;
        this.mHandler.post(this.eUN);
    }

    private void bkC() {
        this.eUG = false;
        this.mHandler.removeCallbacks(this.eUN);
        MessageManager.getInstance().removeMessage(1021112, this.arR);
    }

    public void bkD() {
        this.mHandler.removeCallbacks(this.eUN);
        MessageManager.getInstance().removeMessage(1021112, this.arR);
    }

    public void bkE() {
        this.mHandler.post(this.eUN);
    }

    private void f(ad adVar, ae aeVar, ae aeVar2) {
        if (adVar != null) {
            int i = adVar.abz;
            this.eTW.b(i, adVar, aeVar, aeVar2);
            switch (i) {
                case 2:
                    this.eUI = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    bkx();
                    break;
                case 3:
                    this.eUI = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.eUI = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.eUC = 0L;
                    bky();
                    break;
            }
            if (aeVar != null && aeVar.abx != null) {
                this.eUE = aeVar.abx.userId;
            }
            if (aeVar2 != null && aeVar2.abx != null) {
                this.eUF = aeVar2.abx.userId;
            }
            if (4 == adVar.abz || 5 == adVar.abz) {
                bkC();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.eTW != null && alaGetChallengeInfoResponseMessage != null && alaGetChallengeInfoResponseMessage.bkq() != null) {
            f(alaGetChallengeInfoResponseMessage.bkq(), alaGetChallengeInfoResponseMessage.bkr(), alaGetChallengeInfoResponseMessage.bks());
        }
    }

    public ChallenfeInfoData.ChallengeStatus qa() {
        return this.eUI;
    }

    public boolean qb() {
        return this.eUG;
    }
}
