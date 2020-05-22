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
    private List<j.c> fMW;
    private com.baidu.tieba.ala.liveroom.challenge.a.a fMX;
    private j.InterfaceC0157j fMY;
    private j.h fMZ;
    private j.g fNa;
    private j.f fNb;
    private j.i fNc;
    private j.d fNd;
    private j.a fNe;
    private j.b fNf;
    private j.k fNg;
    private long fNh = 0;
    private a.InterfaceC0559a fNi = new a.InterfaceC0559a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void vH() {
            if (c.this.fMY != null) {
                c.this.fMY.vH();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void l(int i, String str) {
            if (c.this.fMY != null) {
                c.this.fMY.l(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.fMZ != null) {
                c.this.fMZ.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void j(int i, String str) {
            if (c.this.fMZ != null) {
                c.this.fMZ.j(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.fNd != null) {
                c.this.fNd.a(aVar.auc, aVar != null ? aVar.aud : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void aI(int i, String str) {
            if (c.this.fNd != null) {
                c.this.fNd.g(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.fNd != null) {
                c.this.fNd.b(z ? 100 : 101, aVar != null ? aVar.aud : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void aJ(int i, String str) {
            if (c.this.fNd != null) {
                c.this.fNd.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void l(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.fNf != null && i > 0) {
                c.this.fNf.bG(i);
            }
            if (c.this.fNb != null) {
                c.this.fNb.p(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void aK(int i, String str) {
            if (c.this.fNb != null) {
                c.this.fNb.h(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.fNe != null) {
                c.this.fNe.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void aL(int i, String str) {
            if (c.this.fNe != null) {
                c.this.fNe.f(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.fNc != null) {
                c.this.fNc.a(aVar.vo(), aVar != null ? aVar.aud : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void aM(int i, String str) {
            if (c.this.fNc != null) {
                c.this.fNc.k(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.fNc != null) {
                c.this.fNc.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void aN(int i, String str) {
            if (c.this.fNc != null) {
                c.this.fNc.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void l(boolean z, String str) {
            if (c.this.fNg != null) {
                c.this.fNg.c(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.fNa != null) {
                c.this.fNa.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.a.a.InterfaceC0559a
        public void i(int i, String str) {
            if (c.this.fNa != null) {
                c.this.fNa.i(i, str);
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
        this.fMX = new com.baidu.tieba.ala.liveroom.challenge.a.a(tbPageContext, tbPageContext.getUniqueId());
        this.fMX.a(this.fNi);
        this.fMW = new ArrayList();
    }

    @Override // com.baidu.live.challenge.j
    public void e(long j, long j2) {
        this.fMX.e(j, j2);
    }

    @Override // com.baidu.live.challenge.j
    public void setIsHost(boolean z) {
        if (this.fMX != null) {
            this.fMX.setIsHost(z);
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
            this.fMX.dB(qVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void vw() {
        if (this.fMX != null) {
            this.fMX.bzZ();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void vx() {
        if (this.fMX != null) {
            this.fMX.bAa();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !vD()) {
            this.fMX.dB(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void bF(int i) {
        if (this.fNf != null) {
            this.fNf.bG(i);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void vy() {
        this.fMX.vy();
    }

    @Override // com.baidu.live.challenge.j
    public void r(int i, int i2) {
        this.fMX.r(i, i2);
    }

    @Override // com.baidu.live.challenge.j
    public void e(int i, int i2, String str) {
        this.fMX.e(i, i2, str);
    }

    @Override // com.baidu.live.challenge.j
    public void V(long j) {
        this.fMX.V(j);
    }

    @Override // com.baidu.live.challenge.j
    public void W(long j) {
        this.fMX.W(j);
    }

    @Override // com.baidu.live.challenge.j
    public void X(long j) {
        this.fMX.X(j);
    }

    @Override // com.baidu.live.challenge.j
    public void Y(long j) {
        this.fMX.Y(j);
    }

    @Override // com.baidu.live.challenge.j
    public void vz() {
        this.fMX.vz();
    }

    @Override // com.baidu.live.challenge.j
    public void vA() {
        this.fMX.vA();
    }

    @Override // com.baidu.live.challenge.j
    public void vB() {
        this.fMX.vB();
    }

    @Override // com.baidu.live.challenge.j
    public void vE() {
        this.fMX.vE();
    }

    @Override // com.baidu.live.challenge.j
    public long vF() {
        return this.fMX.vF();
    }

    @Override // com.baidu.live.challenge.j
    public ChallenfeInfoData.ChallengeStatus vC() {
        return this.fMX.vC();
    }

    @Override // com.baidu.live.challenge.j
    public boolean vD() {
        return this.fMX.vD();
    }

    @Override // com.baidu.live.challenge.j
    public void aX(boolean z) {
        this.fMX.aX(z);
    }

    private void bzz() {
        if (this.fMW != null) {
            this.fMW.clear();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void vm() {
        if (this.fMX != null) {
            this.fMX.bzV();
        }
        bzz();
    }

    @Override // com.baidu.live.challenge.j
    public void onDestroy() {
        if (this.fMX != null) {
            this.fMX.onDestroy();
        }
        bzz();
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.InterfaceC0157j interfaceC0157j) {
        this.fMY = interfaceC0157j;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.h hVar) {
        this.fMZ = hVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.g gVar) {
        this.fNa = gVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.f fVar) {
        this.fNb = fVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.i iVar) {
        this.fNc = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.d dVar) {
        this.fNd = dVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.a aVar) {
        this.fNe = aVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.b bVar) {
        this.fNf = bVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.k kVar) {
        this.fNg = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.e eVar) {
        this.fMX.b(eVar);
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.c cVar) {
        if (cVar != null && !this.fMW.contains(cVar)) {
            this.fMW.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void en(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.fMX.vz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ak akVar, al alVar, al alVar2) {
        if (!ListUtils.isEmpty(this.fMW)) {
            if (i == 4) {
                if (this.fNh == this.fMX.vF()) {
                    BdLog.e("CHALLENGE_TAG challenge is Over but challenge id same?? ||Net Challenge id=" + this.fMX.vF() + "||Last Challenge id=" + this.fNh);
                    return;
                }
                this.fNh = this.fMX.vF();
            }
            for (j.c cVar : this.fMW) {
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
