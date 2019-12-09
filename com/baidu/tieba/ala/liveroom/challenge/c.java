package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.j;
import com.baidu.live.data.AlaPersonChallengeData;
import com.baidu.live.data.i;
import com.baidu.live.data.v;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.challenge.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c implements j {
    private j.f dYA;
    private j.a dYB;
    private j.d dYC;
    private j.b dYD;
    private j.c dYE;
    private j.l dYF;
    private long dYG = 0;
    private a.InterfaceC0354a dYH = new a.InterfaceC0354a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0354a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.dYw != null) {
                c.this.dYw.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0354a
        public void j(int i, String str) {
            if (c.this.dYw != null) {
                c.this.dYw.j(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0354a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.dYA != null) {
                c.this.dYA.a(aVar.NW, aVar != null ? aVar.NX : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0354a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.dYA != null) {
                c.this.dYA.b(z ? 100 : 101, aVar != null ? aVar.NX : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0354a
        public void V(int i, String str) {
            if (c.this.dYA != null) {
                c.this.dYA.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0354a
        public void h(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.dYC != null && i > 0) {
                c.this.dYC.aU(i);
            }
            if (c.this.dYy != null) {
                c.this.dYy.n(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0354a
        public void W(int i, String str) {
            if (c.this.dYy != null) {
                c.this.dYy.h(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0354a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.dYB != null) {
                c.this.dYB.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0354a
        public void X(int i, String str) {
            if (c.this.dYB != null) {
                c.this.dYB.g(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0354a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.dYz != null) {
                c.this.dYz.a(aVar.nC(), aVar != null ? aVar.NX : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0354a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.dYz != null) {
                c.this.dYz.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0354a
        public void Y(int i, String str) {
            if (c.this.dYz != null) {
                c.this.dYz.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0354a
        public void a(int i, boolean z, String str) {
            if (c.this.dYD != null) {
                c.this.dYD.a(i, z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0354a
        public void i(boolean z, String str) {
            if (c.this.dYF != null) {
                c.this.dYF.c(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0354a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.dYx != null) {
                c.this.dYx.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0354a
        public void i(int i, String str) {
            if (c.this.dYx != null) {
                c.this.dYx.i(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0354a
        public void nU() {
            if (c.this.dYE != null) {
                c.this.dYE.nU();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0354a
        public void nV() {
            if (c.this.dYE != null) {
                c.this.dYE.nV();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0354a
        public void nW() {
            if (c.this.dYE != null) {
                c.this.dYE.nW();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0354a
        public void nX() {
            if (c.this.dYE != null) {
                c.this.dYE.nX();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0354a
        public void b(int i, v vVar, w wVar, w wVar2) {
            c.this.a(i, vVar, wVar, wVar2);
        }
    };
    private List<j.e> dYu;
    private com.baidu.tieba.ala.liveroom.challenge.b.a dYv;
    private j.InterfaceC0058j dYw;
    private j.i dYx;
    private j.h dYy;
    private j.k dYz;
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.dYv = new com.baidu.tieba.ala.liveroom.challenge.b.a(tbPageContext, tbPageContext.getUniqueId());
        this.dYv.a(this.dYH);
        this.dYu = new ArrayList();
    }

    @Override // com.baidu.live.challenge.j
    public void d(long j, long j2) {
        this.dYv.d(j, j2);
    }

    @Override // com.baidu.live.challenge.j
    public void c(i iVar) {
        if (iVar != null && iVar.mLiveInfo != null) {
            this.dYv.cf(iVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void nK() {
        if (this.dYv != null) {
            this.dYv.aQx();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void nL() {
        if (this.dYv != null) {
            this.dYv.aQy();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !nQ()) {
            this.dYv.cf(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void aT(int i) {
        if (this.dYC != null) {
            this.dYC.aU(i);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void m(int i, int i2) {
        this.dYv.m(i, i2);
    }

    @Override // com.baidu.live.challenge.j
    public void q(long j) {
        this.dYv.q(j);
    }

    @Override // com.baidu.live.challenge.j
    public void r(long j) {
        this.dYv.r(j);
    }

    @Override // com.baidu.live.challenge.j
    public void s(long j) {
        this.dYv.s(j);
    }

    @Override // com.baidu.live.challenge.j
    public void t(long j) {
        this.dYv.t(j);
    }

    @Override // com.baidu.live.challenge.j
    public void nM() {
        this.dYv.nM();
    }

    @Override // com.baidu.live.challenge.j
    public void nN() {
        this.dYv.nN();
    }

    @Override // com.baidu.live.challenge.j
    public void nO() {
        this.dYv.nO();
    }

    @Override // com.baidu.live.challenge.j
    public void nR() {
        this.dYv.nR();
    }

    @Override // com.baidu.live.challenge.j
    public void nS() {
        this.dYv.nS();
    }

    @Override // com.baidu.live.challenge.j
    public long nT() {
        return this.dYv.nT();
    }

    @Override // com.baidu.live.challenge.j
    public ChallenfeInfoData.ChallengeStatus nP() {
        return this.dYv.nP();
    }

    @Override // com.baidu.live.challenge.j
    public boolean nQ() {
        return this.dYv.nQ();
    }

    @Override // com.baidu.live.challenge.j
    public void ag(boolean z) {
        this.dYv.ag(z);
    }

    private void aPU() {
        if (this.dYu != null) {
            this.dYu.clear();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void nA() {
        if (this.dYv != null) {
            this.dYv.aQt();
        }
        aPU();
    }

    @Override // com.baidu.live.challenge.j
    public void onDestroy() {
        if (this.dYv != null) {
            this.dYv.onDestroy();
        }
        aPU();
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.InterfaceC0058j interfaceC0058j) {
        this.dYw = interfaceC0058j;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.i iVar) {
        this.dYx = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.h hVar) {
        this.dYy = hVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.k kVar) {
        this.dYz = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.f fVar) {
        this.dYA = fVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.a aVar) {
        this.dYB = aVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.d dVar) {
        this.dYC = dVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.b bVar) {
        this.dYD = bVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.c cVar) {
        this.dYE = cVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.l lVar) {
        this.dYF = lVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.g gVar) {
        this.dYv.b(gVar);
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.e eVar) {
        if (eVar != null && !this.dYu.contains(eVar)) {
            this.dYu.add(eVar);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void bT(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.dYv.nM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, v vVar, w wVar, w wVar2) {
        if (!ListUtils.isEmpty(this.dYu)) {
            if (i == 4) {
                if (this.dYG != this.dYv.nT()) {
                    this.dYG = this.dYv.nT();
                } else {
                    return;
                }
            }
            for (j.e eVar : this.dYu) {
                if (eVar != null) {
                    switch (i) {
                        case 2:
                            eVar.b(vVar, wVar, wVar2);
                            continue;
                        case 3:
                            eVar.c(vVar, wVar, wVar2);
                            continue;
                        case 4:
                            eVar.d(vVar, wVar, wVar2);
                            continue;
                        case 5:
                            eVar.e(vVar, wVar, wVar2);
                            continue;
                    }
                }
            }
        }
    }
}
