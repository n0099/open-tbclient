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
    private BdUniqueId asc;
    private InterfaceC0456a eUH;
    private int eVb;
    private int eVc;
    private long eVk;
    private long eVl;
    private long eVm;
    private long eVn;
    private long eVo;
    private long eVp;
    private long eVq;
    private long eVs;
    private ChallenfeInfoData.ChallengeStatus eVt;
    private j.e eVu;
    private long eio;
    private TbPageContext mPageContext;
    private boolean eVr = false;
    private HttpMessageListener eVv = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.1
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
    private HttpMessageListener arv = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                a.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable eVw = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.3
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, a.this.asc);
            a.this.jl(false);
            a.this.mHandler.postDelayed(this, a.this.eVl);
        }
    };
    private Runnable eVx = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.4
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, a.this.asc);
            a.this.jm(false);
            a.this.mHandler.postDelayed(this, a.this.eVk);
        }
    };
    private Runnable eVy = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.5
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021112, a.this.asc);
            if (a.this.eVn > 0) {
                if (a.this.eVu != null) {
                    a.this.eVc = a.this.eVu.qj();
                }
                com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(a.this.eVn, a.this.eVb, a.this.eio, a.this.eVs, a.this.eVc);
                aVar.setTag(a.this.asc);
                MessageManager.getInstance().sendMessage(aVar);
                a.this.mHandler.postDelayed(this, a.this.eVm);
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

        void qk();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.asc = bdUniqueId;
        this.eVk = com.baidu.live.v.a.zs().awM.aam > 0 ? com.baidu.live.v.a.zs().awM.aam : 1000L;
        this.eVl = com.baidu.live.v.a.zs().awM.aan > 0 ? com.baidu.live.v.a.zs().awM.aan : 1000L;
        this.eVm = com.baidu.live.v.a.zs().awM.aao > 0 ? com.baidu.live.v.a.zs().awM.aao : 1000L;
        this.eVt = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        tj();
        registerListener();
    }

    public void d(long j, long j2) {
        this.eio = j;
        this.eVs = j2;
    }

    public void a(InterfaceC0456a interfaceC0456a) {
        this.eUH = interfaceC0456a;
    }

    public void b(j.e eVar) {
        this.eVu = eVar;
    }

    private void tj() {
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
        MessageManager.getInstance().registerListener(1021183, this.eVv);
        MessageManager.getInstance().registerListener(1021105, this.eVv);
        MessageManager.getInstance().registerListener(1021182, this.eVv);
        MessageManager.getInstance().registerListener(1021106, this.eVv);
        MessageManager.getInstance().registerListener(1021107, this.eVv);
        MessageManager.getInstance().registerListener(1021108, this.eVv);
        MessageManager.getInstance().registerListener(1021109, this.eVv);
        MessageManager.getInstance().registerListener(1021110, this.eVv);
        MessageManager.getInstance().registerListener(1021111, this.eVv);
        MessageManager.getInstance().registerListener(1021115, this.eVv);
        MessageManager.getInstance().registerListener(1021116, this.eVv);
        MessageManager.getInstance().registerListener(this.arv);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.eVv);
        MessageManager.getInstance().unRegisterListener(this.arv);
    }

    private void bkD() {
        MessageManager.getInstance().removeMessage(1021183, this.asc);
        MessageManager.getInstance().removeMessage(1021105, this.asc);
        MessageManager.getInstance().removeMessage(1021182, this.asc);
        MessageManager.getInstance().removeMessage(1021106, this.asc);
        MessageManager.getInstance().removeMessage(1021107, this.asc);
        MessageManager.getInstance().removeMessage(1021108, this.asc);
        MessageManager.getInstance().removeMessage(1021109, this.asc);
        MessageManager.getInstance().removeMessage(1021110, this.asc);
        MessageManager.getInstance().removeMessage(1021111, this.asc);
        MessageManager.getInstance().removeMessage(1021116, this.asc);
    }

    private void bkE() {
        MessageManager.getInstance().removeMessage(1021112, this.asc);
        MessageManager.getInstance().removeMessage(1021115, this.asc);
    }

    private void reset() {
        this.eVn = 0L;
        this.eVo = 0L;
        this.eVb = 0;
        this.eVc = 0;
        this.eVp = 0L;
        this.eVq = 0L;
        bkH();
        bkG();
        bkI();
        this.mHandler.removeCallbacksAndMessages(null);
        bkD();
        bkE();
    }

    public void bkF() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long qi() {
        return this.eVn;
    }

    public void qb() {
        HttpMessage httpMessage = new HttpMessage(1021183);
        httpMessage.setTag(this.asc);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void s(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.asc);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void e(int i, int i2, String str) {
        HttpMessage httpMessage = new HttpMessage(1021182);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.addParam("query_words", str);
        httpMessage.setTag(this.asc);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void t(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.asc);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void u(long j) {
        this.eVn = 0L;
        this.eVo = j;
        this.eVt = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        jl(true);
        this.mHandler.postDelayed(this.eVw, 1000L);
    }

    public void v(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.asc);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void qc() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.asc);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void w(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.asc);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void qd() {
        this.eVn = 0L;
        this.eVt = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        jm(true);
        this.mHandler.postDelayed(this.eVx, 1000L);
    }

    public void qe() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.asc);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void qh() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.eVn);
        httpMessage.setTag(this.asc);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeSwitchResponsedMessage alaChallengeSwitchResponsedMessage) {
        if (alaChallengeSwitchResponsedMessage != null && this.eUH != null) {
            if (alaChallengeSwitchResponsedMessage.hasError() || alaChallengeSwitchResponsedMessage.getError() != 0) {
                this.eUH.m(alaChallengeSwitchResponsedMessage.getError(), alaChallengeSwitchResponsedMessage.getErrorString());
            } else {
                this.eUH.qk();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.eUH != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.eUH.k(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.eUH.a(alaGetTargetListResponseMessage.bkB(), alaGetTargetListResponseMessage.bkC());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSearchTargetListResponseMessage alaSearchTargetListResponseMessage) {
        if (this.eUH != null && alaSearchTargetListResponseMessage != null) {
            if (alaSearchTargetListResponseMessage.hasError() || alaSearchTargetListResponseMessage.getError() != 0) {
                this.eUH.k(alaSearchTargetListResponseMessage.getError(), alaSearchTargetListResponseMessage.getErrorString());
            } else {
                this.eUH.a(alaSearchTargetListResponseMessage.bkB(), alaSearchTargetListResponseMessage.bkC());
            }
        }
    }

    private void bkG() {
        MessageManager.getInstance().removeMessage(1021106, this.asc);
        this.mHandler.removeCallbacks(this.eVw);
        this.eVt = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jl(boolean z) {
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.eVo);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.asc);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.eUH != null) {
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() != 0) {
                if (this.eUH != null) {
                    this.eUH.ao(alaStartDirectChallengeResponseMessage.getError(), alaStartDirectChallengeResponseMessage.getErrorString());
                }
            } else if (alaStartDirectChallengeResponseMessage == null || alaStartDirectChallengeResponseMessage.getError() != 0 || alaStartDirectChallengeResponseMessage.bkt() == null) {
            } else {
                if (alaStartDirectChallengeResponseMessage.bkt().isValid() || alaStartDirectChallengeResponseMessage.bkt().isTimeout()) {
                    com.baidu.live.challenge.a bkt = alaStartDirectChallengeResponseMessage.bkt();
                    this.eUH.b(bkt);
                    bkG();
                    if (bkt.pR()) {
                        cS(bkt.challengeId);
                        this.eVn = bkt.challengeId;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.eUH != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.eUH.ap(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                return;
            }
            boolean bkv = alaCancelDirectChallengeResponseMessage.bkv();
            com.baidu.live.challenge.a bkt = alaCancelDirectChallengeResponseMessage.bkt();
            this.eUH.b(bkv, alaCancelDirectChallengeResponseMessage.bkt());
            bkG();
            if (!bkv && bkt != null && bkt.pR()) {
                cS(bkt.challengeId);
                this.eVn = bkt.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.eUH != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.eUH.aq(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.eUH.k(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.bkz());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.eUH != null && alaAcceptDirectChallengeResponseMessage != null) {
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.eUH.ar(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                return;
            }
            boolean bku = alaAcceptDirectChallengeResponseMessage.bku();
            com.baidu.live.challenge.a bkt = alaAcceptDirectChallengeResponseMessage.bkt();
            this.eUH.c(bku, bkt);
            if (bku && bkt != null) {
                cS(bkt.challengeId);
                this.eVn = bkt.challengeId;
            }
        }
    }

    private void bkH() {
        MessageManager.getInstance().removeMessage(1021110, this.asc);
        this.mHandler.removeCallbacks(this.eVx);
        this.eVt = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jm(boolean z) {
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.asc);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        if (this.eUH != null) {
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() != 0) {
                if (this.eUH != null) {
                    this.eUH.as(alaStartRandomChallengeResponseMessage.getError(), alaStartRandomChallengeResponseMessage.getErrorString());
                }
            } else if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.bkt() != null && alaStartRandomChallengeResponseMessage.bkt().isValid()) {
                com.baidu.live.challenge.a bkt = alaStartRandomChallengeResponseMessage.bkt();
                this.eUH.c(bkt);
                if (bkt.pR() && !qg()) {
                    bkH();
                    cS(bkt.challengeId);
                    this.eVn = bkt.challengeId;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        if (this.eUH != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.eUH.at(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                return;
            }
            boolean bkv = alaCancelRandomChallengeResponseMessage.bkv();
            com.baidu.live.challenge.a bkt = alaCancelRandomChallengeResponseMessage.bkt();
            this.eUH.d(bkv, alaCancelRandomChallengeResponseMessage.bkt());
            bkH();
            if (!bkv && bkt != null && bkt.pR()) {
                cS(bkt.challengeId);
                this.eVn = bkt.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.eUH != null && alaSurrenderResponseMessage != null) {
            this.eUH.k(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.eUH != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.eUH.j(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.eUH.a(alaGetTargetInfoResponseMessage.bkA());
            }
        }
    }

    public void av(boolean z) {
        this.eVb = z ? 1 : 2;
    }

    public void cS(long j) {
        this.eVr = true;
        this.eVn = j;
        this.mHandler.post(this.eVy);
    }

    private void bkI() {
        this.eVr = false;
        this.mHandler.removeCallbacks(this.eVy);
        MessageManager.getInstance().removeMessage(1021112, this.asc);
    }

    public void bkJ() {
        this.mHandler.removeCallbacks(this.eVy);
        MessageManager.getInstance().removeMessage(1021112, this.asc);
    }

    public void bkK() {
        this.mHandler.post(this.eVy);
    }

    private void f(ad adVar, ae aeVar, ae aeVar2) {
        if (adVar != null) {
            int i = adVar.abJ;
            this.eUH.b(i, adVar, aeVar, aeVar2);
            switch (i) {
                case 2:
                    this.eVt = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    bkD();
                    break;
                case 3:
                    this.eVt = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.eVt = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.eVn = 0L;
                    bkE();
                    break;
            }
            if (aeVar != null && aeVar.abH != null) {
                this.eVp = aeVar.abH.userId;
            }
            if (aeVar2 != null && aeVar2.abH != null) {
                this.eVq = aeVar2.abH.userId;
            }
            if (4 == adVar.abJ || 5 == adVar.abJ) {
                bkI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.eUH != null && alaGetChallengeInfoResponseMessage != null && alaGetChallengeInfoResponseMessage.bkw() != null) {
            f(alaGetChallengeInfoResponseMessage.bkw(), alaGetChallengeInfoResponseMessage.bkx(), alaGetChallengeInfoResponseMessage.bky());
        }
    }

    public ChallenfeInfoData.ChallengeStatus qf() {
        return this.eVt;
    }

    public boolean qg() {
        return this.eVr;
    }
}
