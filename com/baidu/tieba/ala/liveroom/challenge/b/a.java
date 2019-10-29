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
import com.baidu.live.data.v;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaAcceptDirectChallengeResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaCancelDirectChallengeResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaCancelRandomChallengeResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetChallengeInfoResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetDirectChallengeListResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetTargetInfoResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetTargetListResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaRequestAllInResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaStartDirectChallengeResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaStartRandomChallengeResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaSurrenderResponseMessage;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private BdUniqueId agc;
    private int dZT;
    private int dZU;
    private InterfaceC0359a dZy;
    private long duD;
    private long eac;
    private long ead;
    private long eae;
    private long eaf;
    private long eag;
    private long eah;
    private long eai;
    private long eak;
    private ChallenfeInfoData.ChallengeStatus eal;
    private j.g eam;
    private TbPageContext mPageContext;
    private boolean eaj = false;
    private HttpMessageListener ean = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetTargetListResponseMessage) {
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
            } else if (httpResponsedMessage instanceof AlaRequestAllInResponseMessage) {
                a.this.a((AlaRequestAllInResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaSurrenderResponseMessage) {
                a.this.a((AlaSurrenderResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaGetTargetInfoResponseMessage) {
                a.this.a((AlaGetTargetInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener afv = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                a.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable eao = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.3
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, a.this.agc);
            a.this.hH(false);
            a.this.mHandler.postDelayed(this, a.this.ead);
        }
    };
    private Runnable eap = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.4
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, a.this.agc);
            a.this.hI(false);
            a.this.mHandler.postDelayed(this, a.this.eac);
        }
    };
    private Runnable eaq = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.5
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021112, a.this.agc);
            if (a.this.eaf > 0) {
                if (a.this.eam != null) {
                    a.this.dZU = a.this.eam.nY();
                }
                com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(a.this.eaf, a.this.dZT, a.this.duD, a.this.eak, a.this.dZU);
                aVar.setTag(a.this.agc);
                MessageManager.getInstance().sendMessage(aVar);
                a.this.mHandler.postDelayed(this, a.this.eae);
            }
        }
    };
    private Handler mHandler = new Handler();

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0359a {
        void W(int i, String str);

        void X(int i, String str);

        void Y(int i, String str);

        void Z(int i, String str);

        void a(int i, boolean z, String str);

        void a(b bVar, List<d> list);

        void a(d dVar);

        void b(int i, v vVar, w wVar, w wVar2);

        void b(com.baidu.live.challenge.a aVar);

        void b(boolean z, com.baidu.live.challenge.a aVar);

        void c(com.baidu.live.challenge.a aVar);

        void c(boolean z, com.baidu.live.challenge.a aVar);

        void d(boolean z, com.baidu.live.challenge.a aVar);

        void h(int i, List<d> list);

        void i(int i, String str);

        void i(boolean z, String str);

        void j(int i, String str);

        void nU();

        void nV();

        void nW();

        void nX();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.agc = bdUniqueId;
        this.eac = com.baidu.live.l.a.uA().ajX.RD > 0 ? com.baidu.live.l.a.uA().ajX.RD : 1000L;
        this.ead = com.baidu.live.l.a.uA().ajX.RE > 0 ? com.baidu.live.l.a.uA().ajX.RE : 1000L;
        this.eae = com.baidu.live.l.a.uA().ajX.RF > 0 ? com.baidu.live.l.a.uA().ajX.RF : 1000L;
        this.eal = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        registerTask();
        registerListener();
    }

    public void d(long j, long j2) {
        this.duD = j;
        this.eak = j2;
    }

    public void a(InterfaceC0359a interfaceC0359a) {
        this.dZy = interfaceC0359a;
    }

    public void b(j.g gVar) {
        this.eam = gVar;
    }

    private void registerTask() {
        com.baidu.live.tieba.f.a.a.a(1021105, "ala/challenge/getChallengeTargetList", AlaGetTargetListResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021106, "ala/challenge/startDirectChallenge", AlaStartDirectChallengeResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021107, "ala/challenge/cancelDirectChallenge", AlaCancelDirectChallengeResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021108, "ala/challenge/getDirectChallengerList", AlaGetDirectChallengeListResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021109, "ala/challenge/acceptDirectChallenge", AlaAcceptDirectChallengeResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021110, "ala/challenge/startRandomChallenge", AlaStartRandomChallengeResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021111, "ala/challenge/cancelRandomChallenge", AlaCancelRandomChallengeResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021112, "ala/challenge/getChallengeInfo", AlaGetChallengeInfoResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021113, "ala/challenge/challengeCmd", AlaRequestAllInResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021115, "ala/challenge/challengeAutoFail", AlaSurrenderResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021116, "ala/challenge/getChallengeTargetInfo", AlaGetTargetInfoResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(1021105, this.ean);
        MessageManager.getInstance().registerListener(1021106, this.ean);
        MessageManager.getInstance().registerListener(1021107, this.ean);
        MessageManager.getInstance().registerListener(1021108, this.ean);
        MessageManager.getInstance().registerListener(1021109, this.ean);
        MessageManager.getInstance().registerListener(1021110, this.ean);
        MessageManager.getInstance().registerListener(1021111, this.ean);
        MessageManager.getInstance().registerListener(1021113, this.ean);
        MessageManager.getInstance().registerListener(1021115, this.ean);
        MessageManager.getInstance().registerListener(1021116, this.ean);
        MessageManager.getInstance().registerListener(this.afv);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.ean);
        MessageManager.getInstance().unRegisterListener(this.afv);
    }

    private void aQt() {
        MessageManager.getInstance().removeMessage(1021105, this.agc);
        MessageManager.getInstance().removeMessage(1021106, this.agc);
        MessageManager.getInstance().removeMessage(1021107, this.agc);
        MessageManager.getInstance().removeMessage(1021108, this.agc);
        MessageManager.getInstance().removeMessage(1021109, this.agc);
        MessageManager.getInstance().removeMessage(1021110, this.agc);
        MessageManager.getInstance().removeMessage(1021111, this.agc);
        MessageManager.getInstance().removeMessage(1021116, this.agc);
    }

    private void aQu() {
        MessageManager.getInstance().removeMessage(1021112, this.agc);
        MessageManager.getInstance().removeMessage(1021113, this.agc);
        MessageManager.getInstance().removeMessage(1021115, this.agc);
    }

    private void reset() {
        this.eaf = 0L;
        this.eag = 0L;
        this.dZT = 0;
        this.dZU = 0;
        this.eah = 0L;
        this.eai = 0L;
        aQx();
        aQw();
        aQy();
        this.mHandler.removeCallbacksAndMessages(null);
        aQt();
        aQu();
    }

    public void aQv() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long nT() {
        return this.eaf;
    }

    public void o(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.agc);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void r(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.agc);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void s(long j) {
        this.eaf = 0L;
        this.eag = j;
        this.eal = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        hH(true);
        this.mHandler.postDelayed(this.eao, 1000L);
    }

    public void t(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.agc);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void nM() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.agc);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void u(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.agc);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void nN() {
        this.eaf = 0L;
        this.eal = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        hI(true);
        this.mHandler.postDelayed(this.eap, 1000L);
    }

    public void nO() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.agc);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void nR() {
        HttpMessage httpMessage = new HttpMessage(1021113);
        httpMessage.addParam("challenge_id", this.eaf);
        httpMessage.addParam("cmd", "allin");
        httpMessage.setTag(this.agc);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void nS() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.eaf);
        httpMessage.setTag(this.agc);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.dZy != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.dZy.j(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.dZy.a(alaGetTargetListResponseMessage.aQq(), alaGetTargetListResponseMessage.aQr());
            }
        }
    }

    private void aQw() {
        MessageManager.getInstance().removeMessage(1021106, this.agc);
        this.mHandler.removeCallbacks(this.eao);
        this.eal = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hH(boolean z) {
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.eag);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.agc);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.dZy == null || alaStartDirectChallengeResponseMessage == null || alaStartDirectChallengeResponseMessage.getError() != 0 || alaStartDirectChallengeResponseMessage.aQi() == null) {
            return;
        }
        if (alaStartDirectChallengeResponseMessage.aQi().isValid() || alaStartDirectChallengeResponseMessage.aQi().isTimeout()) {
            com.baidu.live.challenge.a aQi = alaStartDirectChallengeResponseMessage.aQi();
            this.dZy.b(aQi);
            aQw();
            if (aQi.nC()) {
                cg(aQi.challengeId);
                this.eaf = aQi.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.dZy != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.dZy.W(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                return;
            }
            boolean aQk = alaCancelDirectChallengeResponseMessage.aQk();
            com.baidu.live.challenge.a aQi = alaCancelDirectChallengeResponseMessage.aQi();
            this.dZy.b(aQk, alaCancelDirectChallengeResponseMessage.aQi());
            aQw();
            if (!aQk && aQi != null && aQi.nC()) {
                cg(aQi.challengeId);
                this.eaf = aQi.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.dZy != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.dZy.X(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.dZy.h(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.aQo());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.dZy != null && alaAcceptDirectChallengeResponseMessage != null) {
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.dZy.Y(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                return;
            }
            boolean aQj = alaAcceptDirectChallengeResponseMessage.aQj();
            com.baidu.live.challenge.a aQi = alaAcceptDirectChallengeResponseMessage.aQi();
            this.dZy.c(aQj, aQi);
            if (aQj && aQi != null) {
                cg(aQi.challengeId);
                this.eaf = aQi.challengeId;
            }
        }
    }

    private void aQx() {
        MessageManager.getInstance().removeMessage(1021110, this.agc);
        this.mHandler.removeCallbacks(this.eap);
        this.eal = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hI(boolean z) {
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.agc);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        if (this.dZy != null && alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.aQi() != null && alaStartRandomChallengeResponseMessage.aQi().isValid()) {
            com.baidu.live.challenge.a aQi = alaStartRandomChallengeResponseMessage.aQi();
            this.dZy.c(aQi);
            if (aQi.nC() && !nQ()) {
                aQx();
                cg(aQi.challengeId);
                this.eaf = aQi.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        if (this.dZy != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.dZy.Z(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                return;
            }
            boolean aQk = alaCancelRandomChallengeResponseMessage.aQk();
            com.baidu.live.challenge.a aQi = alaCancelRandomChallengeResponseMessage.aQi();
            this.dZy.d(aQk, alaCancelRandomChallengeResponseMessage.aQi());
            aQx();
            if (!aQk && aQi != null && aQi.nC()) {
                cg(aQi.challengeId);
                this.eaf = aQi.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaRequestAllInResponseMessage alaRequestAllInResponseMessage) {
        if (this.dZy != null && alaRequestAllInResponseMessage != null) {
            this.dZy.a(alaRequestAllInResponseMessage.aQs(), !alaRequestAllInResponseMessage.hasError() && alaRequestAllInResponseMessage.getError() == 0, alaRequestAllInResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.dZy != null && alaSurrenderResponseMessage != null) {
            this.dZy.i(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.dZy != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.dZy.i(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.dZy.a(alaGetTargetInfoResponseMessage.aQp());
            }
        }
    }

    public void ag(boolean z) {
        this.dZT = z ? 1 : 2;
    }

    public void cg(long j) {
        this.eaj = true;
        this.eaf = j;
        this.mHandler.post(this.eaq);
    }

    private void aQy() {
        this.eaj = false;
        this.mHandler.removeCallbacks(this.eaq);
        MessageManager.getInstance().removeMessage(1021112, this.agc);
    }

    public void aQz() {
        this.mHandler.removeCallbacks(this.eaq);
        MessageManager.getInstance().removeMessage(1021112, this.agc);
    }

    public void aQA() {
        this.mHandler.post(this.eaq);
    }

    private void f(v vVar, w wVar, w wVar2) {
        if (vVar != null) {
            int i = vVar.SO;
            this.dZy.b(i, vVar, wVar, wVar2);
            switch (i) {
                case 2:
                    this.eal = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    aQt();
                    break;
                case 3:
                    this.eal = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.eal = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.eaf = 0L;
                    aQu();
                    break;
            }
            if (wVar != null && wVar.Tb != null) {
                this.eah = wVar.Tb.userId;
            }
            if (wVar2 != null && wVar2.Tb != null) {
                this.eai = wVar2.Tb.userId;
            }
            switch (vVar.SR) {
                case 1:
                    if (this.eah == vVar.SS) {
                        this.dZy.nU();
                        break;
                    } else if (this.eai == vVar.SS) {
                        this.dZy.nV();
                        break;
                    }
                    break;
                case 2:
                    this.dZy.nW();
                    break;
                case 3:
                    this.dZy.nX();
                    break;
            }
            if (4 == vVar.SO || 5 == vVar.SO) {
                aQy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.dZy != null && alaGetChallengeInfoResponseMessage != null && alaGetChallengeInfoResponseMessage.aQl() != null) {
            f(alaGetChallengeInfoResponseMessage.aQl(), alaGetChallengeInfoResponseMessage.aQm(), alaGetChallengeInfoResponseMessage.aQn());
        }
    }

    public ChallenfeInfoData.ChallengeStatus nP() {
        return this.eal;
    }

    public boolean nQ() {
        return this.eaj;
    }
}
