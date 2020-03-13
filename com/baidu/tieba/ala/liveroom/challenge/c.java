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
    private List<j.c> eTX;
    private com.baidu.tieba.ala.liveroom.challenge.b.a eTY;
    private j.InterfaceC0081j eTZ;
    private j.h eUa;
    private j.g eUb;
    private j.f eUc;
    private j.i eUd;
    private j.d eUe;
    private j.a eUf;
    private j.b eUg;
    private j.k eUh;
    private long eUi = 0;
    private a.InterfaceC0456a eUj = new a.InterfaceC0456a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void qf() {
            if (c.this.eTZ != null) {
                c.this.eTZ.qf();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void m(int i, String str) {
            if (c.this.eTZ != null) {
                c.this.eTZ.m(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.eUa != null) {
                c.this.eUa.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void k(int i, String str) {
            if (c.this.eUa != null) {
                c.this.eUa.k(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.eUe != null) {
                c.this.eUe.a(aVar.WQ, aVar != null ? aVar.WR : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void ao(int i, String str) {
            if (c.this.eUe != null) {
                c.this.eUe.h(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.eUe != null) {
                c.this.eUe.b(z ? 100 : 101, aVar != null ? aVar.WR : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void ap(int i, String str) {
            if (c.this.eUe != null) {
                c.this.eUe.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void k(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.eUg != null && i > 0) {
                c.this.eUg.bm(i);
            }
            if (c.this.eUc != null) {
                c.this.eUc.m(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void aq(int i, String str) {
            if (c.this.eUc != null) {
                c.this.eUc.i(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.eUf != null) {
                c.this.eUf.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void ar(int i, String str) {
            if (c.this.eUf != null) {
                c.this.eUf.g(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.eUd != null) {
                c.this.eUd.a(aVar.pM(), aVar != null ? aVar.WR : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void as(int i, String str) {
            if (c.this.eUd != null) {
                c.this.eUd.l(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.eUd != null) {
                c.this.eUd.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void at(int i, String str) {
            if (c.this.eUd != null) {
                c.this.eUd.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void k(boolean z, String str) {
            if (c.this.eUh != null) {
                c.this.eUh.d(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.eUb != null) {
                c.this.eUb.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void j(int i, String str) {
            if (c.this.eUb != null) {
                c.this.eUb.j(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void b(int i, ad adVar, ae aeVar, ae aeVar2) {
            c.this.a(i, adVar, aeVar, aeVar2);
        }
    };
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.eTY = new com.baidu.tieba.ala.liveroom.challenge.b.a(tbPageContext, tbPageContext.getUniqueId());
        this.eTY.a(this.eUj);
        this.eTX = new ArrayList();
    }

    @Override // com.baidu.live.challenge.j
    public void d(long j, long j2) {
        this.eTY.d(j, j2);
    }

    @Override // com.baidu.live.challenge.j
    public void c(m mVar) {
        if (mVar != null && mVar.mLiveInfo != null) {
            this.eTY.cS(mVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void pU() {
        if (this.eTY != null) {
            this.eTY.bkE();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void pV() {
        if (this.eTY != null) {
            this.eTY.bkF();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !qb()) {
            this.eTY.cS(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void bl(int i) {
        if (this.eUg != null) {
            this.eUg.bm(i);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void pW() {
        this.eTY.pW();
    }

    @Override // com.baidu.live.challenge.j
    public void s(int i, int i2) {
        this.eTY.s(i, i2);
    }

    @Override // com.baidu.live.challenge.j
    public void e(int i, int i2, String str) {
        this.eTY.e(i, i2, str);
    }

    @Override // com.baidu.live.challenge.j
    public void t(long j) {
        this.eTY.t(j);
    }

    @Override // com.baidu.live.challenge.j
    public void u(long j) {
        this.eTY.u(j);
    }

    @Override // com.baidu.live.challenge.j
    public void v(long j) {
        this.eTY.v(j);
    }

    @Override // com.baidu.live.challenge.j
    public void w(long j) {
        this.eTY.w(j);
    }

    @Override // com.baidu.live.challenge.j
    public void pX() {
        this.eTY.pX();
    }

    @Override // com.baidu.live.challenge.j
    public void pY() {
        this.eTY.pY();
    }

    @Override // com.baidu.live.challenge.j
    public void pZ() {
        this.eTY.pZ();
    }

    @Override // com.baidu.live.challenge.j
    public void qc() {
        this.eTY.qc();
    }

    @Override // com.baidu.live.challenge.j
    public long qd() {
        return this.eTY.qd();
    }

    @Override // com.baidu.live.challenge.j
    public ChallenfeInfoData.ChallengeStatus qa() {
        return this.eTY.qa();
    }

    @Override // com.baidu.live.challenge.j
    public boolean qb() {
        return this.eTY.qb();
    }

    @Override // com.baidu.live.challenge.j
    public void av(boolean z) {
        this.eTY.av(z);
    }

    private void bkd() {
        if (this.eTX != null) {
            this.eTX.clear();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void pK() {
        if (this.eTY != null) {
            this.eTY.bkA();
        }
        bkd();
    }

    @Override // com.baidu.live.challenge.j
    public void onDestroy() {
        if (this.eTY != null) {
            this.eTY.onDestroy();
        }
        bkd();
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.InterfaceC0081j interfaceC0081j) {
        this.eTZ = interfaceC0081j;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.h hVar) {
        this.eUa = hVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.g gVar) {
        this.eUb = gVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.f fVar) {
        this.eUc = fVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.i iVar) {
        this.eUd = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.d dVar) {
        this.eUe = dVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.a aVar) {
        this.eUf = aVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.b bVar) {
        this.eUg = bVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.k kVar) {
        this.eUh = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.e eVar) {
        this.eTY.b(eVar);
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.c cVar) {
        if (cVar != null && !this.eTX.contains(cVar)) {
            this.eTX.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void cU(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.eTY.pX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ad adVar, ae aeVar, ae aeVar2) {
        if (!ListUtils.isEmpty(this.eTX)) {
            if (i == 4) {
                if (this.eUi != this.eTY.qd()) {
                    this.eUi = this.eTY.qd();
                } else {
                    return;
                }
            }
            for (j.c cVar : this.eTX) {
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
