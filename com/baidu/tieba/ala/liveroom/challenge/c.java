package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.j;
import com.baidu.live.data.AlaPersonChallengeData;
import com.baidu.live.data.ac;
import com.baidu.live.data.ad;
import com.baidu.live.data.l;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.challenge.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements j {
    private List<j.c> ePT;
    private com.baidu.tieba.ala.liveroom.challenge.b.a ePU;
    private j.InterfaceC0074j ePV;
    private j.h ePW;
    private j.g ePX;
    private j.f ePY;
    private j.i ePZ;
    private j.d eQa;
    private j.a eQb;
    private j.b eQc;
    private j.k eQd;
    private long eQe = 0;
    private a.InterfaceC0445a eQf = new a.InterfaceC0445a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0445a
        public void pu() {
            if (c.this.ePV != null) {
                c.this.ePV.pu();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0445a
        public void m(int i, String str) {
            if (c.this.ePV != null) {
                c.this.ePV.m(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0445a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.ePW != null) {
                c.this.ePW.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0445a
        public void k(int i, String str) {
            if (c.this.ePW != null) {
                c.this.ePW.k(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0445a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.eQa != null) {
                c.this.eQa.a(aVar.Vk, aVar != null ? aVar.Vl : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0445a
        public void am(int i, String str) {
            if (c.this.eQa != null) {
                c.this.eQa.h(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0445a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.eQa != null) {
                c.this.eQa.b(z ? 100 : 101, aVar != null ? aVar.Vl : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0445a
        public void an(int i, String str) {
            if (c.this.eQa != null) {
                c.this.eQa.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0445a
        public void k(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.eQc != null && i > 0) {
                c.this.eQc.bf(i);
            }
            if (c.this.ePY != null) {
                c.this.ePY.m(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0445a
        public void ao(int i, String str) {
            if (c.this.ePY != null) {
                c.this.ePY.i(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0445a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.eQb != null) {
                c.this.eQb.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0445a
        public void ap(int i, String str) {
            if (c.this.eQb != null) {
                c.this.eQb.g(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0445a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.ePZ != null) {
                c.this.ePZ.a(aVar.pb(), aVar != null ? aVar.Vl : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0445a
        public void aq(int i, String str) {
            if (c.this.ePZ != null) {
                c.this.ePZ.l(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0445a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.ePZ != null) {
                c.this.ePZ.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0445a
        public void ar(int i, String str) {
            if (c.this.ePZ != null) {
                c.this.ePZ.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0445a
        public void j(boolean z, String str) {
            if (c.this.eQd != null) {
                c.this.eQd.d(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0445a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.ePX != null) {
                c.this.ePX.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0445a
        public void j(int i, String str) {
            if (c.this.ePX != null) {
                c.this.ePX.j(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0445a
        public void b(int i, ac acVar, ad adVar, ad adVar2) {
            c.this.a(i, acVar, adVar, adVar2);
        }
    };
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.ePU = new com.baidu.tieba.ala.liveroom.challenge.b.a(tbPageContext, tbPageContext.getUniqueId());
        this.ePU.a(this.eQf);
        this.ePT = new ArrayList();
    }

    @Override // com.baidu.live.challenge.j
    public void d(long j, long j2) {
        this.ePU.d(j, j2);
    }

    @Override // com.baidu.live.challenge.j
    public void c(l lVar) {
        if (lVar != null && lVar.mLiveInfo != null) {
            this.ePU.cQ(lVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void pj() {
        if (this.ePU != null) {
            this.ePU.biL();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void pk() {
        if (this.ePU != null) {
            this.ePU.biM();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !pq()) {
            this.ePU.cQ(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void be(int i) {
        if (this.eQc != null) {
            this.eQc.bf(i);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void pl() {
        this.ePU.pl();
    }

    @Override // com.baidu.live.challenge.j
    public void r(int i, int i2) {
        this.ePU.r(i, i2);
    }

    @Override // com.baidu.live.challenge.j
    public void e(int i, int i2, String str) {
        this.ePU.e(i, i2, str);
    }

    @Override // com.baidu.live.challenge.j
    public void s(long j) {
        this.ePU.s(j);
    }

    @Override // com.baidu.live.challenge.j
    public void t(long j) {
        this.ePU.t(j);
    }

    @Override // com.baidu.live.challenge.j
    public void u(long j) {
        this.ePU.u(j);
    }

    @Override // com.baidu.live.challenge.j
    public void v(long j) {
        this.ePU.v(j);
    }

    @Override // com.baidu.live.challenge.j
    public void pm() {
        this.ePU.pm();
    }

    @Override // com.baidu.live.challenge.j
    public void pn() {
        this.ePU.pn();
    }

    @Override // com.baidu.live.challenge.j
    public void po() {
        this.ePU.po();
    }

    @Override // com.baidu.live.challenge.j
    public void pr() {
        this.ePU.pr();
    }

    @Override // com.baidu.live.challenge.j
    public long ps() {
        return this.ePU.ps();
    }

    @Override // com.baidu.live.challenge.j
    public ChallenfeInfoData.ChallengeStatus pp() {
        return this.ePU.pp();
    }

    @Override // com.baidu.live.challenge.j
    public boolean pq() {
        return this.ePU.pq();
    }

    @Override // com.baidu.live.challenge.j
    public void as(boolean z) {
        this.ePU.as(z);
    }

    private void bik() {
        if (this.ePT != null) {
            this.ePT.clear();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void oZ() {
        if (this.ePU != null) {
            this.ePU.biH();
        }
        bik();
    }

    @Override // com.baidu.live.challenge.j
    public void onDestroy() {
        if (this.ePU != null) {
            this.ePU.onDestroy();
        }
        bik();
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.InterfaceC0074j interfaceC0074j) {
        this.ePV = interfaceC0074j;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.h hVar) {
        this.ePW = hVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.g gVar) {
        this.ePX = gVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.f fVar) {
        this.ePY = fVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.i iVar) {
        this.ePZ = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.d dVar) {
        this.eQa = dVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.a aVar) {
        this.eQb = aVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.b bVar) {
        this.eQc = bVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.k kVar) {
        this.eQd = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.e eVar) {
        this.ePU.b(eVar);
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.c cVar) {
        if (cVar != null && !this.ePT.contains(cVar)) {
            this.ePT.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void cL(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.ePU.pm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ac acVar, ad adVar, ad adVar2) {
        if (!ListUtils.isEmpty(this.ePT)) {
            if (i == 4) {
                if (this.eQe != this.ePU.ps()) {
                    this.eQe = this.ePU.ps();
                } else {
                    return;
                }
            }
            for (j.c cVar : this.ePT) {
                if (cVar != null) {
                    switch (i) {
                        case 2:
                            cVar.b(acVar, adVar, adVar2);
                            continue;
                        case 3:
                            cVar.c(acVar, adVar, adVar2);
                            continue;
                        case 4:
                            cVar.d(acVar, adVar, adVar2);
                            continue;
                        case 5:
                            cVar.e(acVar, adVar, adVar2);
                            continue;
                    }
                }
            }
        }
    }
}
