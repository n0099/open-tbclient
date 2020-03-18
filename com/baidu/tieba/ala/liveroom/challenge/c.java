package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.j;
import com.baidu.live.data.AlaPersonChallengeData;
import com.baidu.live.data.ad;
import com.baidu.live.data.ae;
import com.baidu.live.data.m;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.challenge.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements j {
    private j.f eUA;
    private j.i eUB;
    private j.d eUC;
    private j.a eUD;
    private j.b eUE;
    private j.k eUF;
    private long eUG = 0;
    private a.InterfaceC0456a eUH = new a.InterfaceC0456a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void qk() {
            if (c.this.eUx != null) {
                c.this.eUx.qk();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void m(int i, String str) {
            if (c.this.eUx != null) {
                c.this.eUx.m(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.eUy != null) {
                c.this.eUy.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void k(int i, String str) {
            if (c.this.eUy != null) {
                c.this.eUy.k(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.eUC != null) {
                c.this.eUC.a(aVar.Xa, aVar != null ? aVar.Xb : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void ao(int i, String str) {
            if (c.this.eUC != null) {
                c.this.eUC.h(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.eUC != null) {
                c.this.eUC.b(z ? 100 : 101, aVar != null ? aVar.Xb : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void ap(int i, String str) {
            if (c.this.eUC != null) {
                c.this.eUC.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void k(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.eUE != null && i > 0) {
                c.this.eUE.bm(i);
            }
            if (c.this.eUA != null) {
                c.this.eUA.m(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void aq(int i, String str) {
            if (c.this.eUA != null) {
                c.this.eUA.i(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.eUD != null) {
                c.this.eUD.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void ar(int i, String str) {
            if (c.this.eUD != null) {
                c.this.eUD.g(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.eUB != null) {
                c.this.eUB.a(aVar.pR(), aVar != null ? aVar.Xb : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void as(int i, String str) {
            if (c.this.eUB != null) {
                c.this.eUB.l(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.eUB != null) {
                c.this.eUB.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void at(int i, String str) {
            if (c.this.eUB != null) {
                c.this.eUB.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void k(boolean z, String str) {
            if (c.this.eUF != null) {
                c.this.eUF.d(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.eUz != null) {
                c.this.eUz.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void j(int i, String str) {
            if (c.this.eUz != null) {
                c.this.eUz.j(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void b(int i, ad adVar, ae aeVar, ae aeVar2) {
            c.this.a(i, adVar, aeVar, aeVar2);
        }
    };
    private List<j.c> eUv;
    private com.baidu.tieba.ala.liveroom.challenge.b.a eUw;
    private j.InterfaceC0081j eUx;
    private j.h eUy;
    private j.g eUz;
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.eUw = new com.baidu.tieba.ala.liveroom.challenge.b.a(tbPageContext, tbPageContext.getUniqueId());
        this.eUw.a(this.eUH);
        this.eUv = new ArrayList();
    }

    @Override // com.baidu.live.challenge.j
    public void d(long j, long j2) {
        this.eUw.d(j, j2);
    }

    @Override // com.baidu.live.challenge.j
    public void c(m mVar) {
        if (mVar != null && mVar.mLiveInfo != null) {
            this.eUw.cS(mVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void pZ() {
        if (this.eUw != null) {
            this.eUw.bkJ();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void qa() {
        if (this.eUw != null) {
            this.eUw.bkK();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !qg()) {
            this.eUw.cS(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void bl(int i) {
        if (this.eUE != null) {
            this.eUE.bm(i);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void qb() {
        this.eUw.qb();
    }

    @Override // com.baidu.live.challenge.j
    public void s(int i, int i2) {
        this.eUw.s(i, i2);
    }

    @Override // com.baidu.live.challenge.j
    public void e(int i, int i2, String str) {
        this.eUw.e(i, i2, str);
    }

    @Override // com.baidu.live.challenge.j
    public void t(long j) {
        this.eUw.t(j);
    }

    @Override // com.baidu.live.challenge.j
    public void u(long j) {
        this.eUw.u(j);
    }

    @Override // com.baidu.live.challenge.j
    public void v(long j) {
        this.eUw.v(j);
    }

    @Override // com.baidu.live.challenge.j
    public void w(long j) {
        this.eUw.w(j);
    }

    @Override // com.baidu.live.challenge.j
    public void qc() {
        this.eUw.qc();
    }

    @Override // com.baidu.live.challenge.j
    public void qd() {
        this.eUw.qd();
    }

    @Override // com.baidu.live.challenge.j
    public void qe() {
        this.eUw.qe();
    }

    @Override // com.baidu.live.challenge.j
    public void qh() {
        this.eUw.qh();
    }

    @Override // com.baidu.live.challenge.j
    public long qi() {
        return this.eUw.qi();
    }

    @Override // com.baidu.live.challenge.j
    public ChallenfeInfoData.ChallengeStatus qf() {
        return this.eUw.qf();
    }

    @Override // com.baidu.live.challenge.j
    public boolean qg() {
        return this.eUw.qg();
    }

    @Override // com.baidu.live.challenge.j
    public void av(boolean z) {
        this.eUw.av(z);
    }

    private void bki() {
        if (this.eUv != null) {
            this.eUv.clear();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void pP() {
        if (this.eUw != null) {
            this.eUw.bkF();
        }
        bki();
    }

    @Override // com.baidu.live.challenge.j
    public void onDestroy() {
        if (this.eUw != null) {
            this.eUw.onDestroy();
        }
        bki();
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.InterfaceC0081j interfaceC0081j) {
        this.eUx = interfaceC0081j;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.h hVar) {
        this.eUy = hVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.g gVar) {
        this.eUz = gVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.f fVar) {
        this.eUA = fVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.i iVar) {
        this.eUB = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.d dVar) {
        this.eUC = dVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.a aVar) {
        this.eUD = aVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.b bVar) {
        this.eUE = bVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.k kVar) {
        this.eUF = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.e eVar) {
        this.eUw.b(eVar);
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.c cVar) {
        if (cVar != null && !this.eUv.contains(cVar)) {
            this.eUv.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void cT(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.eUw.qc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ad adVar, ae aeVar, ae aeVar2) {
        if (!ListUtils.isEmpty(this.eUv)) {
            if (i == 4) {
                if (this.eUG != this.eUw.qi()) {
                    this.eUG = this.eUw.qi();
                } else {
                    return;
                }
            }
            for (j.c cVar : this.eUv) {
                if (cVar != null) {
                    switch (i) {
                        case 2:
                            cVar.b(adVar, aeVar, aeVar2);
                            continue;
                        case 3:
                            cVar.c(adVar, aeVar, aeVar2);
                            continue;
                        case 4:
                            cVar.d(adVar, aeVar, aeVar2);
                            continue;
                        case 5:
                            cVar.e(adVar, aeVar, aeVar2);
                            continue;
                    }
                }
            }
        }
    }
}
