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
    private List<j.e> dZl;
    private com.baidu.tieba.ala.liveroom.challenge.b.a dZm;
    private j.InterfaceC0058j dZn;
    private j.i dZo;
    private j.h dZp;
    private j.k dZq;
    private j.f dZr;
    private j.a dZs;
    private j.d dZt;
    private j.b dZu;
    private j.c dZv;
    private j.l dZw;
    private long dZx = 0;
    private a.InterfaceC0359a dZy = new a.InterfaceC0359a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0359a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.dZn != null) {
                c.this.dZn.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0359a
        public void j(int i, String str) {
            if (c.this.dZn != null) {
                c.this.dZn.j(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0359a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.dZr != null) {
                c.this.dZr.a(aVar.Ow, aVar != null ? aVar.Ox : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0359a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.dZr != null) {
                c.this.dZr.b(z ? 100 : 101, aVar != null ? aVar.Ox : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0359a
        public void W(int i, String str) {
            if (c.this.dZr != null) {
                c.this.dZr.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0359a
        public void h(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.dZt != null && i > 0) {
                c.this.dZt.aU(i);
            }
            if (c.this.dZp != null) {
                c.this.dZp.n(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0359a
        public void X(int i, String str) {
            if (c.this.dZp != null) {
                c.this.dZp.h(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0359a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.dZs != null) {
                c.this.dZs.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0359a
        public void Y(int i, String str) {
            if (c.this.dZs != null) {
                c.this.dZs.g(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0359a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.dZq != null) {
                c.this.dZq.a(aVar.nC(), aVar != null ? aVar.Ox : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0359a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.dZq != null) {
                c.this.dZq.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0359a
        public void Z(int i, String str) {
            if (c.this.dZq != null) {
                c.this.dZq.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0359a
        public void a(int i, boolean z, String str) {
            if (c.this.dZu != null) {
                c.this.dZu.a(i, z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0359a
        public void i(boolean z, String str) {
            if (c.this.dZw != null) {
                c.this.dZw.c(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0359a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.dZo != null) {
                c.this.dZo.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0359a
        public void i(int i, String str) {
            if (c.this.dZo != null) {
                c.this.dZo.i(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0359a
        public void nU() {
            if (c.this.dZv != null) {
                c.this.dZv.nU();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0359a
        public void nV() {
            if (c.this.dZv != null) {
                c.this.dZv.nV();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0359a
        public void nW() {
            if (c.this.dZv != null) {
                c.this.dZv.nW();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0359a
        public void nX() {
            if (c.this.dZv != null) {
                c.this.dZv.nX();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0359a
        public void b(int i, v vVar, w wVar, w wVar2) {
            c.this.a(i, vVar, wVar, wVar2);
        }
    };
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.dZm = new com.baidu.tieba.ala.liveroom.challenge.b.a(tbPageContext, tbPageContext.getUniqueId());
        this.dZm.a(this.dZy);
        this.dZl = new ArrayList();
    }

    @Override // com.baidu.live.challenge.j
    public void d(long j, long j2) {
        this.dZm.d(j, j2);
    }

    @Override // com.baidu.live.challenge.j
    public void c(i iVar) {
        if (iVar != null && iVar.mLiveInfo != null) {
            this.dZm.cg(iVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void nK() {
        if (this.dZm != null) {
            this.dZm.aQz();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void nL() {
        if (this.dZm != null) {
            this.dZm.aQA();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !nQ()) {
            this.dZm.cg(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void aT(int i) {
        if (this.dZt != null) {
            this.dZt.aU(i);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void o(int i, int i2) {
        this.dZm.o(i, i2);
    }

    @Override // com.baidu.live.challenge.j
    public void r(long j) {
        this.dZm.r(j);
    }

    @Override // com.baidu.live.challenge.j
    public void s(long j) {
        this.dZm.s(j);
    }

    @Override // com.baidu.live.challenge.j
    public void t(long j) {
        this.dZm.t(j);
    }

    @Override // com.baidu.live.challenge.j
    public void u(long j) {
        this.dZm.u(j);
    }

    @Override // com.baidu.live.challenge.j
    public void nM() {
        this.dZm.nM();
    }

    @Override // com.baidu.live.challenge.j
    public void nN() {
        this.dZm.nN();
    }

    @Override // com.baidu.live.challenge.j
    public void nO() {
        this.dZm.nO();
    }

    @Override // com.baidu.live.challenge.j
    public void nR() {
        this.dZm.nR();
    }

    @Override // com.baidu.live.challenge.j
    public void nS() {
        this.dZm.nS();
    }

    @Override // com.baidu.live.challenge.j
    public long nT() {
        return this.dZm.nT();
    }

    @Override // com.baidu.live.challenge.j
    public ChallenfeInfoData.ChallengeStatus nP() {
        return this.dZm.nP();
    }

    @Override // com.baidu.live.challenge.j
    public boolean nQ() {
        return this.dZm.nQ();
    }

    @Override // com.baidu.live.challenge.j
    public void ag(boolean z) {
        this.dZm.ag(z);
    }

    private void aPW() {
        if (this.dZl != null) {
            this.dZl.clear();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void nA() {
        if (this.dZm != null) {
            this.dZm.aQv();
        }
        aPW();
    }

    @Override // com.baidu.live.challenge.j
    public void onDestroy() {
        if (this.dZm != null) {
            this.dZm.onDestroy();
        }
        aPW();
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.InterfaceC0058j interfaceC0058j) {
        this.dZn = interfaceC0058j;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.i iVar) {
        this.dZo = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.h hVar) {
        this.dZp = hVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.k kVar) {
        this.dZq = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.f fVar) {
        this.dZr = fVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.a aVar) {
        this.dZs = aVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.d dVar) {
        this.dZt = dVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.b bVar) {
        this.dZu = bVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.c cVar) {
        this.dZv = cVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.l lVar) {
        this.dZw = lVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.g gVar) {
        this.dZm.b(gVar);
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.e eVar) {
        if (eVar != null && !this.dZl.contains(eVar)) {
            this.dZl.add(eVar);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void bT(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.dZm.nM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, v vVar, w wVar, w wVar2) {
        if (!ListUtils.isEmpty(this.dZl)) {
            if (i == 4) {
                if (this.dZx != this.dZm.nT()) {
                    this.dZx = this.dZm.nT();
                } else {
                    return;
                }
            }
            for (j.e eVar : this.dZl) {
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
