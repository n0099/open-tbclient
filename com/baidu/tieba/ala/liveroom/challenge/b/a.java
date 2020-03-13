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
    private BdUniqueId arS;
    private int eUD;
    private int eUE;
    private long eUM;
    private long eUN;
    private long eUO;
    private long eUP;
    private long eUQ;
    private long eUR;
    private long eUS;
    private long eUU;
    private ChallenfeInfoData.ChallengeStatus eUV;
    private j.e eUW;
    private InterfaceC0456a eUj;
    private long ehY;
    private TbPageContext mPageContext;
    private boolean eUT = false;
    private HttpMessageListener eUX = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.1
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
    private HttpMessageListener arl = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                a.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable eUY = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.3
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, a.this.arS);
            a.this.jj(false);
            a.this.mHandler.postDelayed(this, a.this.eUN);
        }
    };
    private Runnable eUZ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.4
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, a.this.arS);
            a.this.jk(false);
            a.this.mHandler.postDelayed(this, a.this.eUM);
        }
    };
    private Runnable eVa = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.5
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021112, a.this.arS);
            if (a.this.eUP > 0) {
                if (a.this.eUW != null) {
                    a.this.eUE = a.this.eUW.qe();
                }
                com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(a.this.eUP, a.this.eUD, a.this.ehY, a.this.eUU, a.this.eUE);
                aVar.setTag(a.this.arS);
                MessageManager.getInstance().sendMessage(aVar);
                a.this.mHandler.postDelayed(this, a.this.eUO);
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
        this.arS = bdUniqueId;
        this.eUM = com.baidu.live.v.a.zl().awC.aab > 0 ? com.baidu.live.v.a.zl().awC.aab : 1000L;
        this.eUN = com.baidu.live.v.a.zl().awC.aac > 0 ? com.baidu.live.v.a.zl().awC.aac : 1000L;
        this.eUO = com.baidu.live.v.a.zl().awC.aae > 0 ? com.baidu.live.v.a.zl().awC.aae : 1000L;
        this.eUV = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        te();
        registerListener();
    }

    public void d(long j, long j2) {
        this.ehY = j;
        this.eUU = j2;
    }

    public void a(InterfaceC0456a interfaceC0456a) {
        this.eUj = interfaceC0456a;
    }

    public void b(j.e eVar) {
        this.eUW = eVar;
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
        MessageManager.getInstance().registerListener(1021183, this.eUX);
        MessageManager.getInstance().registerListener(1021105, this.eUX);
        MessageManager.getInstance().registerListener(1021182, this.eUX);
        MessageManager.getInstance().registerListener(1021106, this.eUX);
        MessageManager.getInstance().registerListener(1021107, this.eUX);
        MessageManager.getInstance().registerListener(1021108, this.eUX);
        MessageManager.getInstance().registerListener(1021109, this.eUX);
        MessageManager.getInstance().registerListener(1021110, this.eUX);
        MessageManager.getInstance().registerListener(1021111, this.eUX);
        MessageManager.getInstance().registerListener(1021115, this.eUX);
        MessageManager.getInstance().registerListener(1021116, this.eUX);
        MessageManager.getInstance().registerListener(this.arl);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.eUX);
        MessageManager.getInstance().unRegisterListener(this.arl);
    }

    private void bky() {
        MessageManager.getInstance().removeMessage(1021183, this.arS);
        MessageManager.getInstance().removeMessage(1021105, this.arS);
        MessageManager.getInstance().removeMessage(1021182, this.arS);
        MessageManager.getInstance().removeMessage(1021106, this.arS);
        MessageManager.getInstance().removeMessage(1021107, this.arS);
        MessageManager.getInstance().removeMessage(1021108, this.arS);
        MessageManager.getInstance().removeMessage(1021109, this.arS);
        MessageManager.getInstance().removeMessage(1021110, this.arS);
        MessageManager.getInstance().removeMessage(1021111, this.arS);
        MessageManager.getInstance().removeMessage(1021116, this.arS);
    }

    private void bkz() {
        MessageManager.getInstance().removeMessage(1021112, this.arS);
        MessageManager.getInstance().removeMessage(1021115, this.arS);
    }

    private void reset() {
        this.eUP = 0L;
        this.eUQ = 0L;
        this.eUD = 0;
        this.eUE = 0;
        this.eUR = 0L;
        this.eUS = 0L;
        bkC();
        bkB();
        bkD();
        this.mHandler.removeCallbacksAndMessages(null);
        bky();
        bkz();
    }

    public void bkA() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long qd() {
        return this.eUP;
    }

    public void pW() {
        HttpMessage httpMessage = new HttpMessage(1021183);
        httpMessage.setTag(this.arS);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void s(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.arS);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void e(int i, int i2, String str) {
        HttpMessage httpMessage = new HttpMessage(1021182);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.addParam("query_words", str);
        httpMessage.setTag(this.arS);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void t(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.arS);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void u(long j) {
        this.eUP = 0L;
        this.eUQ = j;
        this.eUV = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        jj(true);
        this.mHandler.postDelayed(this.eUY, 1000L);
    }

    public void v(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.arS);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void pX() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.arS);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void w(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.arS);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void pY() {
        this.eUP = 0L;
        this.eUV = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        jk(true);
        this.mHandler.postDelayed(this.eUZ, 1000L);
    }

    public void pZ() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.arS);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void qc() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.eUP);
        httpMessage.setTag(this.arS);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeSwitchResponsedMessage alaChallengeSwitchResponsedMessage) {
        if (alaChallengeSwitchResponsedMessage != null && this.eUj != null) {
            if (alaChallengeSwitchResponsedMessage.hasError() || alaChallengeSwitchResponsedMessage.getError() != 0) {
                this.eUj.m(alaChallengeSwitchResponsedMessage.getError(), alaChallengeSwitchResponsedMessage.getErrorString());
            } else {
                this.eUj.qf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.eUj != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.eUj.k(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.eUj.a(alaGetTargetListResponseMessage.bkw(), alaGetTargetListResponseMessage.bkx());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSearchTargetListResponseMessage alaSearchTargetListResponseMessage) {
        if (this.eUj != null && alaSearchTargetListResponseMessage != null) {
            if (alaSearchTargetListResponseMessage.hasError() || alaSearchTargetListResponseMessage.getError() != 0) {
                this.eUj.k(alaSearchTargetListResponseMessage.getError(), alaSearchTargetListResponseMessage.getErrorString());
            } else {
                this.eUj.a(alaSearchTargetListResponseMessage.bkw(), alaSearchTargetListResponseMessage.bkx());
            }
        }
    }

    private void bkB() {
        MessageManager.getInstance().removeMessage(1021106, this.arS);
        this.mHandler.removeCallbacks(this.eUY);
        this.eUV = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jj(boolean z) {
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.eUQ);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.arS);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.eUj != null) {
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() != 0) {
                if (this.eUj != null) {
                    this.eUj.ao(alaStartDirectChallengeResponseMessage.getError(), alaStartDirectChallengeResponseMessage.getErrorString());
                }
            } else if (alaStartDirectChallengeResponseMessage == null || alaStartDirectChallengeResponseMessage.getError() != 0 || alaStartDirectChallengeResponseMessage.bko() == null) {
            } else {
                if (alaStartDirectChallengeResponseMessage.bko().isValid() || alaStartDirectChallengeResponseMessage.bko().isTimeout()) {
                    com.baidu.live.challenge.a bko = alaStartDirectChallengeResponseMessage.bko();
                    this.eUj.b(bko);
                    bkB();
                    if (bko.pM()) {
                        cS(bko.challengeId);
                        this.eUP = bko.challengeId;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.eUj != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.eUj.ap(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                return;
            }
            boolean bkq = alaCancelDirectChallengeResponseMessage.bkq();
            com.baidu.live.challenge.a bko = alaCancelDirectChallengeResponseMessage.bko();
            this.eUj.b(bkq, alaCancelDirectChallengeResponseMessage.bko());
            bkB();
            if (!bkq && bko != null && bko.pM()) {
                cS(bko.challengeId);
                this.eUP = bko.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.eUj != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.eUj.aq(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.eUj.k(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.bku());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.eUj != null && alaAcceptDirectChallengeResponseMessage != null) {
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.eUj.ar(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                return;
            }
            boolean bkp = alaAcceptDirectChallengeResponseMessage.bkp();
            com.baidu.live.challenge.a bko = alaAcceptDirectChallengeResponseMessage.bko();
            this.eUj.c(bkp, bko);
            if (bkp && bko != null) {
                cS(bko.challengeId);
                this.eUP = bko.challengeId;
            }
        }
    }

    private void bkC() {
        MessageManager.getInstance().removeMessage(1021110, this.arS);
        this.mHandler.removeCallbacks(this.eUZ);
        this.eUV = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jk(boolean z) {
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.arS);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        if (this.eUj != null) {
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() != 0) {
                if (this.eUj != null) {
                    this.eUj.as(alaStartRandomChallengeResponseMessage.getError(), alaStartRandomChallengeResponseMessage.getErrorString());
                }
            } else if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.bko() != null && alaStartRandomChallengeResponseMessage.bko().isValid()) {
                com.baidu.live.challenge.a bko = alaStartRandomChallengeResponseMessage.bko();
                this.eUj.c(bko);
                if (bko.pM() && !qb()) {
                    bkC();
                    cS(bko.challengeId);
                    this.eUP = bko.challengeId;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        if (this.eUj != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.eUj.at(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                return;
            }
            boolean bkq = alaCancelRandomChallengeResponseMessage.bkq();
            com.baidu.live.challenge.a bko = alaCancelRandomChallengeResponseMessage.bko();
            this.eUj.d(bkq, alaCancelRandomChallengeResponseMessage.bko());
            bkC();
            if (!bkq && bko != null && bko.pM()) {
                cS(bko.challengeId);
                this.eUP = bko.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.eUj != null && alaSurrenderResponseMessage != null) {
            this.eUj.k(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.eUj != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.eUj.j(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.eUj.a(alaGetTargetInfoResponseMessage.bkv());
            }
        }
    }

    public void av(boolean z) {
        this.eUD = z ? 1 : 2;
    }

    public void cS(long j) {
        this.eUT = true;
        this.eUP = j;
        this.mHandler.post(this.eVa);
    }

    private void bkD() {
        this.eUT = false;
        this.mHandler.removeCallbacks(this.eVa);
        MessageManager.getInstance().removeMessage(1021112, this.arS);
    }

    public void bkE() {
        this.mHandler.removeCallbacks(this.eVa);
        MessageManager.getInstance().removeMessage(1021112, this.arS);
    }

    public void bkF() {
        this.mHandler.post(this.eVa);
    }

    private void f(ad adVar, ae aeVar, ae aeVar2) {
        if (adVar != null) {
            int i = adVar.abz;
            this.eUj.b(i, adVar, aeVar, aeVar2);
            switch (i) {
                case 2:
                    this.eUV = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    bky();
                    break;
                case 3:
                    this.eUV = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.eUV = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.eUP = 0L;
                    bkz();
                    break;
            }
            if (aeVar != null && aeVar.abx != null) {
                this.eUR = aeVar.abx.userId;
            }
            if (aeVar2 != null && aeVar2.abx != null) {
                this.eUS = aeVar2.abx.userId;
            }
            if (4 == adVar.abz || 5 == adVar.abz) {
                bkD();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.eUj != null && alaGetChallengeInfoResponseMessage != null && alaGetChallengeInfoResponseMessage.bkr() != null) {
            f(alaGetChallengeInfoResponseMessage.bkr(), alaGetChallengeInfoResponseMessage.bks(), alaGetChallengeInfoResponseMessage.bkt());
        }
    }

    public ChallenfeInfoData.ChallengeStatus qa() {
        return this.eUV;
    }

    public boolean qb() {
        return this.eUT;
    }
}
