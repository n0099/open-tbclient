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
import com.baidu.live.data.y;
import com.baidu.live.data.z;
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
/* loaded from: classes2.dex */
public class a {
    private BdUniqueId anM;
    private InterfaceC0442a eOE;
    private int eOZ;
    private int ePa;
    private long ePi;
    private long ePj;
    private long ePk;
    private long ePl;
    private long ePm;
    private long ePn;
    private long ePo;
    private long ePq;
    private ChallenfeInfoData.ChallengeStatus ePr;
    private j.g ePs;
    private long edz;
    private TbPageContext mPageContext;
    private boolean ePp = false;
    private HttpMessageListener ePt = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.1
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
    private HttpMessageListener anf = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                a.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable ePu = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.3
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, a.this.anM);
            a.this.iW(false);
            a.this.mHandler.postDelayed(this, a.this.ePj);
        }
    };
    private Runnable ePv = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.4
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, a.this.anM);
            a.this.iX(false);
            a.this.mHandler.postDelayed(this, a.this.ePi);
        }
    };
    private Runnable ePw = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.5
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021112, a.this.anM);
            if (a.this.ePl > 0) {
                if (a.this.ePs != null) {
                    a.this.ePa = a.this.ePs.pq();
                }
                com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(a.this.ePl, a.this.eOZ, a.this.edz, a.this.ePq, a.this.ePa);
                aVar.setTag(a.this.anM);
                MessageManager.getInstance().sendMessage(aVar);
                a.this.mHandler.postDelayed(this, a.this.ePk);
            }
        }
    };
    private Handler mHandler = new Handler();

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0442a {
        void a(int i, boolean z, String str);

        void a(b bVar, List<d> list);

        void a(d dVar);

        void ak(int i, String str);

        void al(int i, String str);

        void am(int i, String str);

        void an(int i, String str);

        void b(int i, y yVar, z zVar, z zVar2);

        void b(com.baidu.live.challenge.a aVar);

        void b(boolean z, com.baidu.live.challenge.a aVar);

        void c(com.baidu.live.challenge.a aVar);

        void c(boolean z, com.baidu.live.challenge.a aVar);

        void d(boolean z, com.baidu.live.challenge.a aVar);

        void i(int i, String str);

        void j(int i, String str);

        void j(boolean z, String str);

        void k(int i, List<d> list);

        void pm();

        void pn();

        void po();

        void pp();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.anM = bdUniqueId;
        this.ePi = com.baidu.live.r.a.wA().arE.XR > 0 ? com.baidu.live.r.a.wA().arE.XR : 1000L;
        this.ePj = com.baidu.live.r.a.wA().arE.XS > 0 ? com.baidu.live.r.a.wA().arE.XS : 1000L;
        this.ePk = com.baidu.live.r.a.wA().arE.XT > 0 ? com.baidu.live.r.a.wA().arE.XT : 1000L;
        this.ePr = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        rG();
        registerListener();
    }

    public void d(long j, long j2) {
        this.edz = j;
        this.ePq = j2;
    }

    public void a(InterfaceC0442a interfaceC0442a) {
        this.eOE = interfaceC0442a;
    }

    public void b(j.g gVar) {
        this.ePs = gVar;
    }

    private void rG() {
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
        MessageManager.getInstance().registerListener(1021105, this.ePt);
        MessageManager.getInstance().registerListener(1021106, this.ePt);
        MessageManager.getInstance().registerListener(1021107, this.ePt);
        MessageManager.getInstance().registerListener(1021108, this.ePt);
        MessageManager.getInstance().registerListener(1021109, this.ePt);
        MessageManager.getInstance().registerListener(1021110, this.ePt);
        MessageManager.getInstance().registerListener(1021111, this.ePt);
        MessageManager.getInstance().registerListener(1021113, this.ePt);
        MessageManager.getInstance().registerListener(1021115, this.ePt);
        MessageManager.getInstance().registerListener(1021116, this.ePt);
        MessageManager.getInstance().registerListener(this.anf);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.ePt);
        MessageManager.getInstance().unRegisterListener(this.anf);
    }

    private void bhU() {
        MessageManager.getInstance().removeMessage(1021105, this.anM);
        MessageManager.getInstance().removeMessage(1021106, this.anM);
        MessageManager.getInstance().removeMessage(1021107, this.anM);
        MessageManager.getInstance().removeMessage(1021108, this.anM);
        MessageManager.getInstance().removeMessage(1021109, this.anM);
        MessageManager.getInstance().removeMessage(1021110, this.anM);
        MessageManager.getInstance().removeMessage(1021111, this.anM);
        MessageManager.getInstance().removeMessage(1021116, this.anM);
    }

    private void bhV() {
        MessageManager.getInstance().removeMessage(1021112, this.anM);
        MessageManager.getInstance().removeMessage(1021113, this.anM);
        MessageManager.getInstance().removeMessage(1021115, this.anM);
    }

    private void reset() {
        this.ePl = 0L;
        this.ePm = 0L;
        this.eOZ = 0;
        this.ePa = 0;
        this.ePn = 0L;
        this.ePo = 0L;
        bhY();
        bhX();
        bhZ();
        this.mHandler.removeCallbacksAndMessages(null);
        bhU();
        bhV();
    }

    public void bhW() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long pl() {
        return this.ePl;
    }

    public void n(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.anM);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void s(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.anM);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void t(long j) {
        this.ePl = 0L;
        this.ePm = j;
        this.ePr = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        iW(true);
        this.mHandler.postDelayed(this.ePu, 1000L);
    }

    public void u(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.anM);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void pe() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.anM);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void v(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.anM);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void pf() {
        this.ePl = 0L;
        this.ePr = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        iX(true);
        this.mHandler.postDelayed(this.ePv, 1000L);
    }

    public void pg() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.anM);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void pj() {
        HttpMessage httpMessage = new HttpMessage(1021113);
        httpMessage.addParam("challenge_id", this.ePl);
        httpMessage.addParam("cmd", "allin");
        httpMessage.setTag(this.anM);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void pk() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.ePl);
        httpMessage.setTag(this.anM);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.eOE != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.eOE.j(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.eOE.a(alaGetTargetListResponseMessage.bhR(), alaGetTargetListResponseMessage.bhS());
            }
        }
    }

    private void bhX() {
        MessageManager.getInstance().removeMessage(1021106, this.anM);
        this.mHandler.removeCallbacks(this.ePu);
        this.ePr = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iW(boolean z) {
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.ePm);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.anM);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.eOE == null || alaStartDirectChallengeResponseMessage == null || alaStartDirectChallengeResponseMessage.getError() != 0 || alaStartDirectChallengeResponseMessage.bhJ() == null) {
            return;
        }
        if (alaStartDirectChallengeResponseMessage.bhJ().isValid() || alaStartDirectChallengeResponseMessage.bhJ().isTimeout()) {
            com.baidu.live.challenge.a bhJ = alaStartDirectChallengeResponseMessage.bhJ();
            this.eOE.b(bhJ);
            bhX();
            if (bhJ.oU()) {
                cL(bhJ.challengeId);
                this.ePl = bhJ.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.eOE != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.eOE.ak(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                return;
            }
            boolean bhL = alaCancelDirectChallengeResponseMessage.bhL();
            com.baidu.live.challenge.a bhJ = alaCancelDirectChallengeResponseMessage.bhJ();
            this.eOE.b(bhL, alaCancelDirectChallengeResponseMessage.bhJ());
            bhX();
            if (!bhL && bhJ != null && bhJ.oU()) {
                cL(bhJ.challengeId);
                this.ePl = bhJ.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.eOE != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.eOE.al(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.eOE.k(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.bhP());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.eOE != null && alaAcceptDirectChallengeResponseMessage != null) {
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.eOE.am(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                return;
            }
            boolean bhK = alaAcceptDirectChallengeResponseMessage.bhK();
            com.baidu.live.challenge.a bhJ = alaAcceptDirectChallengeResponseMessage.bhJ();
            this.eOE.c(bhK, bhJ);
            if (bhK && bhJ != null) {
                cL(bhJ.challengeId);
                this.ePl = bhJ.challengeId;
            }
        }
    }

    private void bhY() {
        MessageManager.getInstance().removeMessage(1021110, this.anM);
        this.mHandler.removeCallbacks(this.ePv);
        this.ePr = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iX(boolean z) {
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.anM);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        if (this.eOE != null && alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.bhJ() != null && alaStartRandomChallengeResponseMessage.bhJ().isValid()) {
            com.baidu.live.challenge.a bhJ = alaStartRandomChallengeResponseMessage.bhJ();
            this.eOE.c(bhJ);
            if (bhJ.oU() && !pi()) {
                bhY();
                cL(bhJ.challengeId);
                this.ePl = bhJ.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        if (this.eOE != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.eOE.an(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                return;
            }
            boolean bhL = alaCancelRandomChallengeResponseMessage.bhL();
            com.baidu.live.challenge.a bhJ = alaCancelRandomChallengeResponseMessage.bhJ();
            this.eOE.d(bhL, alaCancelRandomChallengeResponseMessage.bhJ());
            bhY();
            if (!bhL && bhJ != null && bhJ.oU()) {
                cL(bhJ.challengeId);
                this.ePl = bhJ.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaRequestAllInResponseMessage alaRequestAllInResponseMessage) {
        if (this.eOE != null && alaRequestAllInResponseMessage != null) {
            this.eOE.a(alaRequestAllInResponseMessage.bhT(), !alaRequestAllInResponseMessage.hasError() && alaRequestAllInResponseMessage.getError() == 0, alaRequestAllInResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.eOE != null && alaSurrenderResponseMessage != null) {
            this.eOE.j(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.eOE != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.eOE.i(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.eOE.a(alaGetTargetInfoResponseMessage.bhQ());
            }
        }
    }

    public void as(boolean z) {
        this.eOZ = z ? 1 : 2;
    }

    public void cL(long j) {
        this.ePp = true;
        this.ePl = j;
        this.mHandler.post(this.ePw);
    }

    private void bhZ() {
        this.ePp = false;
        this.mHandler.removeCallbacks(this.ePw);
        MessageManager.getInstance().removeMessage(1021112, this.anM);
    }

    public void bia() {
        this.mHandler.removeCallbacks(this.ePw);
        MessageManager.getInstance().removeMessage(1021112, this.anM);
    }

    public void bib() {
        this.mHandler.post(this.ePw);
    }

    private void f(y yVar, z zVar, z zVar2) {
        if (yVar != null) {
            int i = yVar.Zo;
            this.eOE.b(i, yVar, zVar, zVar2);
            switch (i) {
                case 2:
                    this.ePr = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    bhU();
                    break;
                case 3:
                    this.ePr = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.ePr = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.ePl = 0L;
                    bhV();
                    break;
            }
            if (zVar != null && zVar.ZA != null) {
                this.ePn = zVar.ZA.userId;
            }
            if (zVar2 != null && zVar2.ZA != null) {
                this.ePo = zVar2.ZA.userId;
            }
            switch (yVar.Zq) {
                case 1:
                    if (this.ePn == yVar.Zr) {
                        this.eOE.pm();
                        break;
                    } else if (this.ePo == yVar.Zr) {
                        this.eOE.pn();
                        break;
                    }
                    break;
                case 2:
                    this.eOE.po();
                    break;
                case 3:
                    this.eOE.pp();
                    break;
            }
            if (4 == yVar.Zo || 5 == yVar.Zo) {
                bhZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.eOE != null && alaGetChallengeInfoResponseMessage != null && alaGetChallengeInfoResponseMessage.bhM() != null) {
            f(alaGetChallengeInfoResponseMessage.bhM(), alaGetChallengeInfoResponseMessage.bhN(), alaGetChallengeInfoResponseMessage.bhO());
        }
    }

    public ChallenfeInfoData.ChallengeStatus ph() {
        return this.ePr;
    }

    public boolean pi() {
        return this.ePp;
    }
}
