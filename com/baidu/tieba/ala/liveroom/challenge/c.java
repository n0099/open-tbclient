package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.j;
import com.baidu.live.data.AlaPersonChallengeData;
import com.baidu.live.data.k;
import com.baidu.live.data.y;
import com.baidu.live.data.z;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.challenge.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements j {
    private j.b eOA;
    private j.c eOB;
    private j.l eOC;
    private long eOD = 0;
    private a.InterfaceC0442a eOE = new a.InterfaceC0442a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0442a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.eOt != null) {
                c.this.eOt.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0442a
        public void j(int i, String str) {
            if (c.this.eOt != null) {
                c.this.eOt.j(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0442a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.eOx != null) {
                c.this.eOx.a(aVar.UT, aVar != null ? aVar.UU : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0442a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.eOx != null) {
                c.this.eOx.b(z ? 100 : 101, aVar != null ? aVar.UU : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0442a
        public void ak(int i, String str) {
            if (c.this.eOx != null) {
                c.this.eOx.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0442a
        public void k(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.eOz != null && i > 0) {
                c.this.eOz.bf(i);
            }
            if (c.this.eOv != null) {
                c.this.eOv.m(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0442a
        public void al(int i, String str) {
            if (c.this.eOv != null) {
                c.this.eOv.h(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0442a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.eOy != null) {
                c.this.eOy.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0442a
        public void am(int i, String str) {
            if (c.this.eOy != null) {
                c.this.eOy.g(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0442a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.eOw != null) {
                c.this.eOw.a(aVar.oU(), aVar != null ? aVar.UU : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0442a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.eOw != null) {
                c.this.eOw.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0442a
        public void an(int i, String str) {
            if (c.this.eOw != null) {
                c.this.eOw.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0442a
        public void a(int i, boolean z, String str) {
            if (c.this.eOA != null) {
                c.this.eOA.a(i, z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0442a
        public void j(boolean z, String str) {
            if (c.this.eOC != null) {
                c.this.eOC.d(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0442a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.eOu != null) {
                c.this.eOu.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0442a
        public void i(int i, String str) {
            if (c.this.eOu != null) {
                c.this.eOu.i(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0442a
        public void pm() {
            if (c.this.eOB != null) {
                c.this.eOB.pm();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0442a
        public void pn() {
            if (c.this.eOB != null) {
                c.this.eOB.pn();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0442a
        public void po() {
            if (c.this.eOB != null) {
                c.this.eOB.po();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0442a
        public void pp() {
            if (c.this.eOB != null) {
                c.this.eOB.pp();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0442a
        public void b(int i, y yVar, z zVar, z zVar2) {
            c.this.a(i, yVar, zVar, zVar2);
        }
    };
    private List<j.e> eOr;
    private com.baidu.tieba.ala.liveroom.challenge.b.a eOs;
    private j.InterfaceC0074j eOt;
    private j.i eOu;
    private j.h eOv;
    private j.k eOw;
    private j.f eOx;
    private j.a eOy;
    private j.d eOz;
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.eOs = new com.baidu.tieba.ala.liveroom.challenge.b.a(tbPageContext, tbPageContext.getUniqueId());
        this.eOs.a(this.eOE);
        this.eOr = new ArrayList();
    }

    @Override // com.baidu.live.challenge.j
    public void d(long j, long j2) {
        this.eOs.d(j, j2);
    }

    @Override // com.baidu.live.challenge.j
    public void c(k kVar) {
        if (kVar != null && kVar.mLiveInfo != null) {
            this.eOs.cL(kVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void pc() {
        if (this.eOs != null) {
            this.eOs.bia();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void pd() {
        if (this.eOs != null) {
            this.eOs.bib();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !pi()) {
            this.eOs.cL(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void be(int i) {
        if (this.eOz != null) {
            this.eOz.bf(i);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void n(int i, int i2) {
        this.eOs.n(i, i2);
    }

    @Override // com.baidu.live.challenge.j
    public void s(long j) {
        this.eOs.s(j);
    }

    @Override // com.baidu.live.challenge.j
    public void t(long j) {
        this.eOs.t(j);
    }

    @Override // com.baidu.live.challenge.j
    public void u(long j) {
        this.eOs.u(j);
    }

    @Override // com.baidu.live.challenge.j
    public void v(long j) {
        this.eOs.v(j);
    }

    @Override // com.baidu.live.challenge.j
    public void pe() {
        this.eOs.pe();
    }

    @Override // com.baidu.live.challenge.j
    public void pf() {
        this.eOs.pf();
    }

    @Override // com.baidu.live.challenge.j
    public void pg() {
        this.eOs.pg();
    }

    @Override // com.baidu.live.challenge.j
    public void pj() {
        this.eOs.pj();
    }

    @Override // com.baidu.live.challenge.j
    public void pk() {
        this.eOs.pk();
    }

    @Override // com.baidu.live.challenge.j
    public long pl() {
        return this.eOs.pl();
    }

    @Override // com.baidu.live.challenge.j
    public ChallenfeInfoData.ChallengeStatus ph() {
        return this.eOs.ph();
    }

    @Override // com.baidu.live.challenge.j
    public boolean pi() {
        return this.eOs.pi();
    }

    @Override // com.baidu.live.challenge.j
    public void as(boolean z) {
        this.eOs.as(z);
    }

    private void bhx() {
        if (this.eOr != null) {
            this.eOr.clear();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void oS() {
        if (this.eOs != null) {
            this.eOs.bhW();
        }
        bhx();
    }

    @Override // com.baidu.live.challenge.j
    public void onDestroy() {
        if (this.eOs != null) {
            this.eOs.onDestroy();
        }
        bhx();
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.InterfaceC0074j interfaceC0074j) {
        this.eOt = interfaceC0074j;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.i iVar) {
        this.eOu = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.h hVar) {
        this.eOv = hVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.k kVar) {
        this.eOw = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.f fVar) {
        this.eOx = fVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.a aVar) {
        this.eOy = aVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.d dVar) {
        this.eOz = dVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.b bVar) {
        this.eOA = bVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.c cVar) {
        this.eOB = cVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.l lVar) {
        this.eOC = lVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.g gVar) {
        this.eOs.b(gVar);
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.e eVar) {
        if (eVar != null && !this.eOr.contains(eVar)) {
            this.eOr.add(eVar);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void cK(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.eOs.pe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, y yVar, z zVar, z zVar2) {
        if (!ListUtils.isEmpty(this.eOr)) {
            if (i == 4) {
                if (this.eOD != this.eOs.pl()) {
                    this.eOD = this.eOs.pl();
                } else {
                    return;
                }
            }
            for (j.e eVar : this.eOr) {
                if (eVar != null) {
                    switch (i) {
                        case 2:
                            eVar.b(yVar, zVar, zVar2);
                            continue;
                        case 3:
                            eVar.c(yVar, zVar, zVar2);
                            continue;
                        case 4:
                            eVar.d(yVar, zVar, zVar2);
                            continue;
                        case 5:
                            eVar.e(yVar, zVar, zVar2);
                            continue;
                    }
                }
            }
        }
    }
}
