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
    private BdUniqueId afK;
    private InterfaceC0359a dYH;
    private int dZc;
    private int dZd;
    private long dZl;
    private long dZm;
    private long dZn;
    private long dZo;
    private long dZp;
    private long dZq;
    private long dZr;
    private long dZt;
    private ChallenfeInfoData.ChallengeStatus dZu;
    private j.g dZv;
    private long dtM;
    private TbPageContext mPageContext;
    private boolean dZs = false;
    private HttpMessageListener dZw = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.1
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
    private HttpMessageListener afd = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                a.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable dZx = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.3
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, a.this.afK);
            a.this.hH(false);
            a.this.mHandler.postDelayed(this, a.this.dZm);
        }
    };
    private Runnable dZy = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.4
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, a.this.afK);
            a.this.hI(false);
            a.this.mHandler.postDelayed(this, a.this.dZl);
        }
    };
    private Runnable dZz = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.5
        @Override // java.lang.Runnable
        public void run() {
            a.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021112, a.this.afK);
            if (a.this.dZo > 0) {
                if (a.this.dZv != null) {
                    a.this.dZd = a.this.dZv.nY();
                }
                com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(a.this.dZo, a.this.dZc, a.this.dtM, a.this.dZt, a.this.dZd);
                aVar.setTag(a.this.afK);
                MessageManager.getInstance().sendMessage(aVar);
                a.this.mHandler.postDelayed(this, a.this.dZn);
            }
        }
    };
    private Handler mHandler = new Handler();

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0359a {
        void V(int i, String str);

        void W(int i, String str);

        void X(int i, String str);

        void Y(int i, String str);

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
        this.afK = bdUniqueId;
        this.dZl = com.baidu.live.l.a.uB().ajF.Rd > 0 ? com.baidu.live.l.a.uB().ajF.Rd : 1000L;
        this.dZm = com.baidu.live.l.a.uB().ajF.Re > 0 ? com.baidu.live.l.a.uB().ajF.Re : 1000L;
        this.dZn = com.baidu.live.l.a.uB().ajF.Rf > 0 ? com.baidu.live.l.a.uB().ajF.Rf : 1000L;
        this.dZu = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        registerTask();
        registerListener();
    }

    public void d(long j, long j2) {
        this.dtM = j;
        this.dZt = j2;
    }

    public void a(InterfaceC0359a interfaceC0359a) {
        this.dYH = interfaceC0359a;
    }

    public void b(j.g gVar) {
        this.dZv = gVar;
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
        MessageManager.getInstance().registerListener(1021105, this.dZw);
        MessageManager.getInstance().registerListener(1021106, this.dZw);
        MessageManager.getInstance().registerListener(1021107, this.dZw);
        MessageManager.getInstance().registerListener(1021108, this.dZw);
        MessageManager.getInstance().registerListener(1021109, this.dZw);
        MessageManager.getInstance().registerListener(1021110, this.dZw);
        MessageManager.getInstance().registerListener(1021111, this.dZw);
        MessageManager.getInstance().registerListener(1021113, this.dZw);
        MessageManager.getInstance().registerListener(1021115, this.dZw);
        MessageManager.getInstance().registerListener(1021116, this.dZw);
        MessageManager.getInstance().registerListener(this.afd);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.dZw);
        MessageManager.getInstance().unRegisterListener(this.afd);
    }

    private void aQr() {
        MessageManager.getInstance().removeMessage(1021105, this.afK);
        MessageManager.getInstance().removeMessage(1021106, this.afK);
        MessageManager.getInstance().removeMessage(1021107, this.afK);
        MessageManager.getInstance().removeMessage(1021108, this.afK);
        MessageManager.getInstance().removeMessage(1021109, this.afK);
        MessageManager.getInstance().removeMessage(1021110, this.afK);
        MessageManager.getInstance().removeMessage(1021111, this.afK);
        MessageManager.getInstance().removeMessage(1021116, this.afK);
    }

    private void aQs() {
        MessageManager.getInstance().removeMessage(1021112, this.afK);
        MessageManager.getInstance().removeMessage(1021113, this.afK);
        MessageManager.getInstance().removeMessage(1021115, this.afK);
    }

    private void reset() {
        this.dZo = 0L;
        this.dZp = 0L;
        this.dZc = 0;
        this.dZd = 0;
        this.dZq = 0L;
        this.dZr = 0L;
        aQv();
        aQu();
        aQw();
        this.mHandler.removeCallbacksAndMessages(null);
        aQr();
        aQs();
    }

    public void aQt() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long nT() {
        return this.dZo;
    }

    public void m(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.afK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void q(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.afK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void r(long j) {
        this.dZo = 0L;
        this.dZp = j;
        this.dZu = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        hH(true);
        this.mHandler.postDelayed(this.dZx, 1000L);
    }

    public void s(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.afK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void nM() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.afK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void t(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.afK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void nN() {
        this.dZo = 0L;
        this.dZu = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        hI(true);
        this.mHandler.postDelayed(this.dZy, 1000L);
    }

    public void nO() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.afK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void nR() {
        HttpMessage httpMessage = new HttpMessage(1021113);
        httpMessage.addParam("challenge_id", this.dZo);
        httpMessage.addParam("cmd", "allin");
        httpMessage.setTag(this.afK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void nS() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.dZo);
        httpMessage.setTag(this.afK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.dYH != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.dYH.j(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.dYH.a(alaGetTargetListResponseMessage.aQo(), alaGetTargetListResponseMessage.aQp());
            }
        }
    }

    private void aQu() {
        MessageManager.getInstance().removeMessage(1021106, this.afK);
        this.mHandler.removeCallbacks(this.dZx);
        this.dZu = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hH(boolean z) {
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.dZp);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.afK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.dYH == null || alaStartDirectChallengeResponseMessage == null || alaStartDirectChallengeResponseMessage.getError() != 0 || alaStartDirectChallengeResponseMessage.aQg() == null) {
            return;
        }
        if (alaStartDirectChallengeResponseMessage.aQg().isValid() || alaStartDirectChallengeResponseMessage.aQg().isTimeout()) {
            com.baidu.live.challenge.a aQg = alaStartDirectChallengeResponseMessage.aQg();
            this.dYH.b(aQg);
            aQu();
            if (aQg.nC()) {
                cf(aQg.challengeId);
                this.dZo = aQg.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.dYH != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.dYH.V(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                return;
            }
            boolean aQi = alaCancelDirectChallengeResponseMessage.aQi();
            com.baidu.live.challenge.a aQg = alaCancelDirectChallengeResponseMessage.aQg();
            this.dYH.b(aQi, alaCancelDirectChallengeResponseMessage.aQg());
            aQu();
            if (!aQi && aQg != null && aQg.nC()) {
                cf(aQg.challengeId);
                this.dZo = aQg.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.dYH != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.dYH.W(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.dYH.h(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.aQm());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.dYH != null && alaAcceptDirectChallengeResponseMessage != null) {
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.dYH.X(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                return;
            }
            boolean aQh = alaAcceptDirectChallengeResponseMessage.aQh();
            com.baidu.live.challenge.a aQg = alaAcceptDirectChallengeResponseMessage.aQg();
            this.dYH.c(aQh, aQg);
            if (aQh && aQg != null) {
                cf(aQg.challengeId);
                this.dZo = aQg.challengeId;
            }
        }
    }

    private void aQv() {
        MessageManager.getInstance().removeMessage(1021110, this.afK);
        this.mHandler.removeCallbacks(this.dZy);
        this.dZu = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hI(boolean z) {
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.afK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        if (this.dYH != null && alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.aQg() != null && alaStartRandomChallengeResponseMessage.aQg().isValid()) {
            com.baidu.live.challenge.a aQg = alaStartRandomChallengeResponseMessage.aQg();
            this.dYH.c(aQg);
            if (aQg.nC() && !nQ()) {
                aQv();
                cf(aQg.challengeId);
                this.dZo = aQg.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        if (this.dYH != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.dYH.Y(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                return;
            }
            boolean aQi = alaCancelRandomChallengeResponseMessage.aQi();
            com.baidu.live.challenge.a aQg = alaCancelRandomChallengeResponseMessage.aQg();
            this.dYH.d(aQi, alaCancelRandomChallengeResponseMessage.aQg());
            aQv();
            if (!aQi && aQg != null && aQg.nC()) {
                cf(aQg.challengeId);
                this.dZo = aQg.challengeId;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaRequestAllInResponseMessage alaRequestAllInResponseMessage) {
        if (this.dYH != null && alaRequestAllInResponseMessage != null) {
            this.dYH.a(alaRequestAllInResponseMessage.aQq(), !alaRequestAllInResponseMessage.hasError() && alaRequestAllInResponseMessage.getError() == 0, alaRequestAllInResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.dYH != null && alaSurrenderResponseMessage != null) {
            this.dYH.i(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.dYH != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.dYH.i(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.dYH.a(alaGetTargetInfoResponseMessage.aQn());
            }
        }
    }

    public void ag(boolean z) {
        this.dZc = z ? 1 : 2;
    }

    public void cf(long j) {
        this.dZs = true;
        this.dZo = j;
        this.mHandler.post(this.dZz);
    }

    private void aQw() {
        this.dZs = false;
        this.mHandler.removeCallbacks(this.dZz);
        MessageManager.getInstance().removeMessage(1021112, this.afK);
    }

    public void aQx() {
        this.mHandler.removeCallbacks(this.dZz);
        MessageManager.getInstance().removeMessage(1021112, this.afK);
    }

    public void aQy() {
        this.mHandler.post(this.dZz);
    }

    private void f(v vVar, w wVar, w wVar2) {
        if (vVar != null) {
            int i = vVar.Ss;
            this.dYH.b(i, vVar, wVar, wVar2);
            switch (i) {
                case 2:
                    this.dZu = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    aQr();
                    break;
                case 3:
                    this.dZu = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.dZu = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.dZo = 0L;
                    aQs();
                    break;
            }
            if (wVar != null && wVar.SF != null) {
                this.dZq = wVar.SF.userId;
            }
            if (wVar2 != null && wVar2.SF != null) {
                this.dZr = wVar2.SF.userId;
            }
            switch (vVar.Su) {
                case 1:
                    if (this.dZq == vVar.Sv) {
                        this.dYH.nU();
                        break;
                    } else if (this.dZr == vVar.Sv) {
                        this.dYH.nV();
                        break;
                    }
                    break;
                case 2:
                    this.dYH.nW();
                    break;
                case 3:
                    this.dYH.nX();
                    break;
            }
            if (4 == vVar.Ss || 5 == vVar.Ss) {
                aQw();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.dYH != null && alaGetChallengeInfoResponseMessage != null && alaGetChallengeInfoResponseMessage.aQj() != null) {
            f(alaGetChallengeInfoResponseMessage.aQj(), alaGetChallengeInfoResponseMessage.aQk(), alaGetChallengeInfoResponseMessage.aQl());
        }
    }

    public ChallenfeInfoData.ChallengeStatus nP() {
        return this.dZu;
    }

    public boolean nQ() {
        return this.dZs;
    }
}
