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
import com.baidu.live.data.ac;
import com.baidu.live.data.ad;
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
/* loaded from: classes2.dex */
public class a {
    private BdUniqueId aoz;
    private long eQH;
    private long eQI;
    private long eQJ;
    private long eQK;
    private long eQL;
    private long eQM;
    private long eQN;
    private long eQP;
    private ChallenfeInfoData.ChallengeStatus eQQ;
    private j.e eQR;
    private InterfaceC0445a eQf;
    private int eQy;
    private int eQz;
    private long edH;
    private TbPageContext mPageContext;
    private boolean eQO = false;
    private HttpMessageListener eQS = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.1
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
    private HttpMessageListener anS = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                a.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable eQT = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.3
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, a.this.aoz);
            a.this.jf(false);
            a.this.mHandler.postDelayed(this, a.this.eQI);
        }
    };
    private Runnable eQU = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.4
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, a.this.aoz);
            a.this.jg(false);
            a.this.mHandler.postDelayed(this, a.this.eQH);
        }
    };
    private Runnable eQV = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.5
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021112, a.this.aoz);
            if (a.this.eQK > 0) {
                if (a.this.eQR != null) {
                    a.this.eQz = a.this.eQR.pt();
                }
                com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(a.this.eQK, a.this.eQy, a.this.edH, a.this.eQP, a.this.eQz);
                aVar.setTag(a.this.aoz);
                MessageManager.getInstance().sendMessage(aVar);
                a.this.mHandler.postDelayed(this, a.this.eQJ);
            }
        }
    };
    private Handler mHandler = new Handler();

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0445a {
        void a(b bVar, List<d> list);

        void a(d dVar);

        void am(int i, String str);

        void an(int i, String str);

        void ao(int i, String str);

        void ap(int i, String str);

        void aq(int i, String str);

        void ar(int i, String str);

        void b(int i, ac acVar, ad adVar, ad adVar2);

        void b(com.baidu.live.challenge.a aVar);

        void b(boolean z, com.baidu.live.challenge.a aVar);

        void c(com.baidu.live.challenge.a aVar);

        void c(boolean z, com.baidu.live.challenge.a aVar);

        void d(boolean z, com.baidu.live.challenge.a aVar);

        void j(int i, String str);

        void j(boolean z, String str);

        void k(int i, String str);

        void k(int i, List<d> list);

        void m(int i, String str);

        void pu();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.aoz = bdUniqueId;
        this.eQH = com.baidu.live.s.a.wR().asq.Yk > 0 ? com.baidu.live.s.a.wR().asq.Yk : 1000L;
        this.eQI = com.baidu.live.s.a.wR().asq.Yl > 0 ? com.baidu.live.s.a.wR().asq.Yl : 1000L;
        this.eQJ = com.baidu.live.s.a.wR().asq.Ym > 0 ? com.baidu.live.s.a.wR().asq.Ym : 1000L;
        this.eQQ = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        rT();
        registerListener();
    }

    public void d(long j, long j2) {
        this.edH = j;
        this.eQP = j2;
    }

    public void a(InterfaceC0445a interfaceC0445a) {
        this.eQf = interfaceC0445a;
    }

    public void b(j.e eVar) {
        this.eQR = eVar;
    }

    private void rT() {
        com.baidu.live.tieba.f.a.a.a(1021175, "ala/challenge/getChallengeSwitch", AlaChallengeSwitchResponsedMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021105, "ala/challenge/getChallengeTargetList", AlaGetTargetListResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021174, "ala/challenge/searchChallengeTargetList", AlaSearchTargetListResponseMessage.class, true, true, true, true);
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
        MessageManager.getInstance().registerListener(1021175, this.eQS);
        MessageManager.getInstance().registerListener(1021105, this.eQS);
        MessageManager.getInstance().registerListener(1021174, this.eQS);
        MessageManager.getInstance().registerListener(1021106, this.eQS);
        MessageManager.getInstance().registerListener(1021107, this.eQS);
        MessageManager.getInstance().registerListener(1021108, this.eQS);
        MessageManager.getInstance().registerListener(1021109, this.eQS);
        MessageManager.getInstance().registerListener(1021110, this.eQS);
        MessageManager.getInstance().registerListener(1021111, this.eQS);
        MessageManager.getInstance().registerListener(1021115, this.eQS);
        MessageManager.getInstance().registerListener(1021116, this.eQS);
        MessageManager.getInstance().registerListener(this.anS);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.eQS);
        MessageManager.getInstance().unRegisterListener(this.anS);
    }

    private void biF() {
        MessageManager.getInstance().removeMessage(1021175, this.aoz);
        MessageManager.getInstance().removeMessage(1021105, this.aoz);
        MessageManager.getInstance().removeMessage(1021174, this.aoz);
        MessageManager.getInstance().removeMessage(1021106, this.aoz);
        MessageManager.getInstance().removeMessage(1021107, this.aoz);
        MessageManager.getInstance().removeMessage(1021108, this.aoz);
        MessageManager.getInstance().removeMessage(1021109, this.aoz);
        MessageManager.getInstance().removeMessage(1021110, this.aoz);
        MessageManager.getInstance().removeMessage(1021111, this.aoz);
        MessageManager.getInstance().removeMessage(1021116, this.aoz);
    }

    private void biG() {
        MessageManager.getInstance().removeMessage(1021112, this.aoz);
        MessageManager.getInstance().removeMessage(1021115, this.aoz);
    }

    private void reset() {
        this.eQK = 0L;
        this.eQL = 0L;
        this.eQy = 0;
        this.eQz = 0;
        this.eQM = 0L;
        this.eQN = 0L;
        biJ();
        biI();
        biK();
        this.mHandler.removeCallbacksAndMessages(null);
        biF();
        biG();
    }

    public void biH() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long ps() {
        return this.eQK;
    }

    public void pl() {
        HttpMessage httpMessage = new HttpMessage(1021175);
        httpMessage.setTag(this.aoz);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void r(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.aoz);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void e(int i, int i2, String str) {
        HttpMessage httpMessage = new HttpMessage(1021174);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.addParam("query_words", str);
        httpMessage.setTag(this.aoz);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void s(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.aoz);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void t(long j) {
        this.eQK = 0L;
        this.eQL = j;
        this.eQQ = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        jf(true);
        this.mHandler.postDelayed(this.eQT, 1000L);
    }

    public void u(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.aoz);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void pm() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.aoz);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void v(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.aoz);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void pn() {
        this.eQK = 0L;
        this.eQQ = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        jg(true);
        this.mHandler.postDelayed(this.eQU, 1000L);
    }

    public void po() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.aoz);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void pr() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.eQK);
        httpMessage.setTag(this.aoz);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeSwitchResponsedMessage alaChallengeSwitchResponsedMessage) {
        if (alaChallengeSwitchResponsedMessage != null && this.eQf != null) {
            if (alaChallengeSwitchResponsedMessage.hasError() || alaChallengeSwitchResponsedMessage.getError() != 0) {
                this.eQf.m(alaChallengeSwitchResponsedMessage.getError(), alaChallengeSwitchResponsedMessage.getErrorString());
            } else {
                this.eQf.pu();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.eQf != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.eQf.k(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.eQf.a(alaGetTargetListResponseMessage.biD(), alaGetTargetListResponseMessage.biE());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSearchTargetListResponseMessage alaSearchTargetListResponseMessage) {
        if (this.eQf != null && alaSearchTargetListResponseMessage != null) {
            if (alaSearchTargetListResponseMessage.hasError() || alaSearchTargetListResponseMessage.getError() != 0) {
                this.eQf.k(alaSearchTargetListResponseMessage.getError(), alaSearchTargetListResponseMessage.getErrorString());
            } else {
                this.eQf.a(alaSearchTargetListResponseMessage.biD(), alaSearchTargetListResponseMessage.biE());
            }
        }
    }

    private void biI() {
        MessageManager.getInstance().removeMessage(1021106, this.aoz);
        this.mHandler.removeCallbacks(this.eQT);
        this.eQQ = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jf(boolean z) {
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.eQL);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.aoz);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.eQf != null) {
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() != 0) {
                if (this.eQf != null) {
                    this.eQf.am(alaStartDirectChallengeResponseMessage.getError(), alaStartDirectChallengeResponseMessage.getErrorString());
                }
            } else if (alaStartDirectChallengeResponseMessage == null || alaStartDirectChallengeResponseMessage.getError() != 0 || alaStartDirectChallengeResponseMessage.biv() == null) {
            } else {
                if (alaStartDirectChallengeResponseMessage.biv().isValid() || alaStartDirectChallengeResponseMessage.biv().isTimeout()) {
                    com.baidu.live.challenge.a biv = alaStartDirectChallengeResponseMessage.biv();
                    this.eQf.b(biv);
                    biI();
                    if (biv.pb()) {
                        cQ(biv.challengeId);
                        this.eQK = biv.challengeId;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.eQf != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.eQf.an(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                return;
            }
            boolean bix = alaCancelDirectChallengeResponseMessage.bix();
            com.baidu.live.challenge.a biv = alaCancelDirectChallengeResponseMessage.biv();
            this.eQf.b(bix, alaCancelDirectChallengeResponseMessage.biv());
            biI();
            if (!bix && biv != null && biv.pb()) {
                cQ(biv.challengeId);
                this.eQK = biv.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.eQf != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.eQf.ao(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.eQf.k(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.biB());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.eQf != null && alaAcceptDirectChallengeResponseMessage != null) {
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.eQf.ap(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                return;
            }
            boolean biw = alaAcceptDirectChallengeResponseMessage.biw();
            com.baidu.live.challenge.a biv = alaAcceptDirectChallengeResponseMessage.biv();
            this.eQf.c(biw, biv);
            if (biw && biv != null) {
                cQ(biv.challengeId);
                this.eQK = biv.challengeId;
            }
        }
    }

    private void biJ() {
        MessageManager.getInstance().removeMessage(1021110, this.aoz);
        this.mHandler.removeCallbacks(this.eQU);
        this.eQQ = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jg(boolean z) {
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.aoz);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        if (this.eQf != null) {
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() != 0) {
                if (this.eQf != null) {
                    this.eQf.aq(alaStartRandomChallengeResponseMessage.getError(), alaStartRandomChallengeResponseMessage.getErrorString());
                }
            } else if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.biv() != null && alaStartRandomChallengeResponseMessage.biv().isValid()) {
                com.baidu.live.challenge.a biv = alaStartRandomChallengeResponseMessage.biv();
                this.eQf.c(biv);
                if (biv.pb() && !pq()) {
                    biJ();
                    cQ(biv.challengeId);
                    this.eQK = biv.challengeId;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        if (this.eQf != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.eQf.ar(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                return;
            }
            boolean bix = alaCancelRandomChallengeResponseMessage.bix();
            com.baidu.live.challenge.a biv = alaCancelRandomChallengeResponseMessage.biv();
            this.eQf.d(bix, alaCancelRandomChallengeResponseMessage.biv());
            biJ();
            if (!bix && biv != null && biv.pb()) {
                cQ(biv.challengeId);
                this.eQK = biv.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.eQf != null && alaSurrenderResponseMessage != null) {
            this.eQf.j(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.eQf != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.eQf.j(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.eQf.a(alaGetTargetInfoResponseMessage.biC());
            }
        }
    }

    public void as(boolean z) {
        this.eQy = z ? 1 : 2;
    }

    public void cQ(long j) {
        this.eQO = true;
        this.eQK = j;
        this.mHandler.post(this.eQV);
    }

    private void biK() {
        this.eQO = false;
        this.mHandler.removeCallbacks(this.eQV);
        MessageManager.getInstance().removeMessage(1021112, this.aoz);
    }

    public void biL() {
        this.mHandler.removeCallbacks(this.eQV);
        MessageManager.getInstance().removeMessage(1021112, this.aoz);
    }

    public void biM() {
        this.mHandler.post(this.eQV);
    }

    private void f(ac acVar, ad adVar, ad adVar2) {
        if (acVar != null) {
            int i = acVar.ZE;
            this.eQf.b(i, acVar, adVar, adVar2);
            switch (i) {
                case 2:
                    this.eQQ = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    biF();
                    break;
                case 3:
                    this.eQQ = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.eQQ = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.eQK = 0L;
                    biG();
                    break;
            }
            if (adVar != null && adVar.ZC != null) {
                this.eQM = adVar.ZC.userId;
            }
            if (adVar2 != null && adVar2.ZC != null) {
                this.eQN = adVar2.ZC.userId;
            }
            if (4 == acVar.ZE || 5 == acVar.ZE) {
                biK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.eQf != null && alaGetChallengeInfoResponseMessage != null && alaGetChallengeInfoResponseMessage.biy() != null) {
            f(alaGetChallengeInfoResponseMessage.biy(), alaGetChallengeInfoResponseMessage.biz(), alaGetChallengeInfoResponseMessage.biA());
        }
    }

    public ChallenfeInfoData.ChallengeStatus pp() {
        return this.eQQ;
    }

    public boolean pq() {
        return this.eQO;
    }
}
