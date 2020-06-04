package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.j;
import com.baidu.live.data.AlaPersonChallengeData;
import com.baidu.live.data.ah;
import com.baidu.live.data.ak;
import com.baidu.live.data.al;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.challenge.a.a;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetChallengeInfoResponseMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements j {
    private List<j.c> fNh;
    private com.baidu.tieba.ala.liveroom.challenge.a.a fNi;
    private j.InterfaceC0157j fNj;
    private j.h fNk;
    private j.g fNl;
    private j.f fNm;
    private j.i fNn;
    private j.d fNo;
    private j.a fNp;
    private j.b fNq;
    private j.k fNr;
    private long fNs = 0;
    private a.InterfaceC0559a fNt = new a.InterfaceC0559a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void vH() {
            if (c.this.fNj != null) {
                c.this.fNj.vH();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void l(int i, String str) {
            if (c.this.fNj != null) {
                c.this.fNj.l(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.fNk != null) {
                c.this.fNk.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void j(int i, String str) {
            if (c.this.fNk != null) {
                c.this.fNk.j(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.fNo != null) {
                c.this.fNo.a(aVar.auc, aVar != null ? aVar.aud : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void aI(int i, String str) {
            if (c.this.fNo != null) {
                c.this.fNo.g(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.fNo != null) {
                c.this.fNo.b(z ? 100 : 101, aVar != null ? aVar.aud : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void aJ(int i, String str) {
            if (c.this.fNo != null) {
                c.this.fNo.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void l(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.fNq != null && i > 0) {
                c.this.fNq.bI(i);
            }
            if (c.this.fNm != null) {
                c.this.fNm.p(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void aK(int i, String str) {
            if (c.this.fNm != null) {
                c.this.fNm.h(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.fNp != null) {
                c.this.fNp.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void aL(int i, String str) {
            if (c.this.fNp != null) {
                c.this.fNp.f(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.fNn != null) {
                c.this.fNn.a(aVar.vo(), aVar != null ? aVar.aud : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void aM(int i, String str) {
            if (c.this.fNn != null) {
                c.this.fNn.k(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.fNn != null) {
                c.this.fNn.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void aN(int i, String str) {
            if (c.this.fNn != null) {
                c.this.fNn.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void l(boolean z, String str) {
            if (c.this.fNr != null) {
                c.this.fNr.c(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.fNl != null) {
                c.this.fNl.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void i(int i, String str) {
            if (c.this.fNl != null) {
                c.this.fNl.i(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void b(int i, ak akVar, al alVar, al alVar2) {
            c.this.a(i, akVar, alVar, alVar2);
        }
    };
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fNi = new com.baidu.tieba.ala.liveroom.challenge.a.a(tbPageContext, tbPageContext.getUniqueId());
        this.fNi.a(this.fNt);
        this.fNh = new ArrayList();
    }

    @Override // com.baidu.live.challenge.j
    public void e(long j, long j2) {
        this.fNi.e(j, j2);
    }

    @Override // com.baidu.live.challenge.j
    public void setIsHost(boolean z) {
        if (this.fNi != null) {
            this.fNi.setIsHost(z);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void a(ah ahVar) {
        if (ahVar != null) {
            AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage = new AlaGetChallengeInfoResponseMessage();
            alaGetChallengeInfoResponseMessage.a(ahVar.azl);
            alaGetChallengeInfoResponseMessage.a(ahVar.azm);
            alaGetChallengeInfoResponseMessage.b(ahVar.azn);
            MessageManager.getInstance().dispatchResponsedMessage(alaGetChallengeInfoResponseMessage);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void c(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null) {
            this.fNi.dB(qVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void vw() {
        if (this.fNi != null) {
            this.fNi.bAb();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void vx() {
        if (this.fNi != null) {
            this.fNi.bAc();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !vD()) {
            this.fNi.dB(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void bH(int i) {
        if (this.fNq != null) {
            this.fNq.bI(i);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void vy() {
        this.fNi.vy();
    }

    @Override // com.baidu.live.challenge.j
    public void r(int i, int i2) {
        this.fNi.r(i, i2);
    }

    @Override // com.baidu.live.challenge.j
    public void e(int i, int i2, String str) {
        this.fNi.e(i, i2, str);
    }

    @Override // com.baidu.live.challenge.j
    public void V(long j) {
        this.fNi.V(j);
    }

    @Override // com.baidu.live.challenge.j
    public void W(long j) {
        this.fNi.W(j);
    }

    @Override // com.baidu.live.challenge.j
    public void X(long j) {
        this.fNi.X(j);
    }

    @Override // com.baidu.live.challenge.j
    public void Y(long j) {
        this.fNi.Y(j);
    }

    @Override // com.baidu.live.challenge.j
    public void vz() {
        this.fNi.vz();
    }

    @Override // com.baidu.live.challenge.j
    public void vA() {
        this.fNi.vA();
    }

    @Override // com.baidu.live.challenge.j
    public void vB() {
        this.fNi.vB();
    }

    @Override // com.baidu.live.challenge.j
    public void vE() {
        this.fNi.vE();
    }

    @Override // com.baidu.live.challenge.j
    public long vF() {
        return this.fNi.vF();
    }

    @Override // com.baidu.live.challenge.j
    public ChallenfeInfoData.ChallengeStatus vC() {
        return this.fNi.vC();
    }

    @Override // com.baidu.live.challenge.j
    public boolean vD() {
        return this.fNi.vD();
    }

    @Override // com.baidu.live.challenge.j
    public void aX(boolean z) {
        this.fNi.aX(z);
    }

    private void bzB() {
        if (this.fNh != null) {
            this.fNh.clear();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void vm() {
        if (this.fNi != null) {
            this.fNi.bzX();
        }
        bzB();
    }

    @Override // com.baidu.live.challenge.j
    public void onDestroy() {
        if (this.fNi != null) {
            this.fNi.onDestroy();
        }
        bzB();
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.InterfaceC0157j interfaceC0157j) {
        this.fNj = interfaceC0157j;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.h hVar) {
        this.fNk = hVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.g gVar) {
        this.fNl = gVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.f fVar) {
        this.fNm = fVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.i iVar) {
        this.fNn = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.d dVar) {
        this.fNo = dVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.a aVar) {
        this.fNp = aVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.b bVar) {
        this.fNq = bVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.k kVar) {
        this.fNr = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.e eVar) {
        this.fNi.b(eVar);
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.c cVar) {
        if (cVar != null && !this.fNh.contains(cVar)) {
            this.fNh.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void en(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.fNi.vz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ak akVar, al alVar, al alVar2) {
        if (!ListUtils.isEmpty(this.fNh)) {
            if (i == 4) {
                if (this.fNs == this.fNi.vF()) {
                    BdLog.e("CHALLENGE_TAG challenge is Over but challenge id same?? ||Net Challenge id=" + this.fNi.vF() + "||Last Challenge id=" + this.fNs);
                    return;
                }
                this.fNs = this.fNi.vF();
            }
            for (j.c cVar : this.fNh) {
                if (cVar != null) {
                    switch (i) {
                        case 2:
                            cVar.b(akVar, alVar, alVar2);
                            continue;
                        case 3:
                            cVar.c(akVar, alVar, alVar2);
                            continue;
                        case 4:
                            cVar.d(akVar, alVar, alVar2);
                            continue;
                        case 5:
                            cVar.e(akVar, alVar, alVar2);
                            continue;
                    }
                }
            }
        }
    }
}
