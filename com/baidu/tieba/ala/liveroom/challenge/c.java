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
    private List<j.c> eTJ;
    private com.baidu.tieba.ala.liveroom.challenge.b.a eTK;
    private j.InterfaceC0081j eTL;
    private j.h eTM;
    private j.g eTN;
    private j.f eTO;
    private j.i eTP;
    private j.d eTQ;
    private j.a eTR;
    private j.b eTS;
    private j.k eTT;
    private long eTU = 0;
    private a.InterfaceC0456a eTV = new a.InterfaceC0456a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void qf() {
            if (c.this.eTL != null) {
                c.this.eTL.qf();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void m(int i, String str) {
            if (c.this.eTL != null) {
                c.this.eTL.m(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.eTM != null) {
                c.this.eTM.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void k(int i, String str) {
            if (c.this.eTM != null) {
                c.this.eTM.k(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.eTQ != null) {
                c.this.eTQ.a(aVar.WQ, aVar != null ? aVar.WR : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void ao(int i, String str) {
            if (c.this.eTQ != null) {
                c.this.eTQ.h(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.eTQ != null) {
                c.this.eTQ.b(z ? 100 : 101, aVar != null ? aVar.WR : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void ap(int i, String str) {
            if (c.this.eTQ != null) {
                c.this.eTQ.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void k(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.eTS != null && i > 0) {
                c.this.eTS.bm(i);
            }
            if (c.this.eTO != null) {
                c.this.eTO.m(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void aq(int i, String str) {
            if (c.this.eTO != null) {
                c.this.eTO.i(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.eTR != null) {
                c.this.eTR.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void ar(int i, String str) {
            if (c.this.eTR != null) {
                c.this.eTR.g(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.eTP != null) {
                c.this.eTP.a(aVar.pM(), aVar != null ? aVar.WR : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void as(int i, String str) {
            if (c.this.eTP != null) {
                c.this.eTP.l(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.eTP != null) {
                c.this.eTP.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void at(int i, String str) {
            if (c.this.eTP != null) {
                c.this.eTP.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void k(boolean z, String str) {
            if (c.this.eTT != null) {
                c.this.eTT.d(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.eTN != null) {
                c.this.eTN.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void j(int i, String str) {
            if (c.this.eTN != null) {
                c.this.eTN.j(i, str);
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
        this.eTK = new com.baidu.tieba.ala.liveroom.challenge.b.a(tbPageContext, tbPageContext.getUniqueId());
        this.eTK.a(this.eTV);
        this.eTJ = new ArrayList();
    }

    @Override // com.baidu.live.challenge.j
    public void d(long j, long j2) {
        this.eTK.d(j, j2);
    }

    @Override // com.baidu.live.challenge.j
    public void c(m mVar) {
        if (mVar != null && mVar.mLiveInfo != null) {
            this.eTK.cS(mVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void pU() {
        if (this.eTK != null) {
            this.eTK.bkB();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void pV() {
        if (this.eTK != null) {
            this.eTK.bkC();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !qb()) {
            this.eTK.cS(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void bl(int i) {
        if (this.eTS != null) {
            this.eTS.bm(i);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void pW() {
        this.eTK.pW();
    }

    @Override // com.baidu.live.challenge.j
    public void s(int i, int i2) {
        this.eTK.s(i, i2);
    }

    @Override // com.baidu.live.challenge.j
    public void e(int i, int i2, String str) {
        this.eTK.e(i, i2, str);
    }

    @Override // com.baidu.live.challenge.j
    public void t(long j) {
        this.eTK.t(j);
    }

    @Override // com.baidu.live.challenge.j
    public void u(long j) {
        this.eTK.u(j);
    }

    @Override // com.baidu.live.challenge.j
    public void v(long j) {
        this.eTK.v(j);
    }

    @Override // com.baidu.live.challenge.j
    public void w(long j) {
        this.eTK.w(j);
    }

    @Override // com.baidu.live.challenge.j
    public void pX() {
        this.eTK.pX();
    }

    @Override // com.baidu.live.challenge.j
    public void pY() {
        this.eTK.pY();
    }

    @Override // com.baidu.live.challenge.j
    public void pZ() {
        this.eTK.pZ();
    }

    @Override // com.baidu.live.challenge.j
    public void qc() {
        this.eTK.qc();
    }

    @Override // com.baidu.live.challenge.j
    public long qd() {
        return this.eTK.qd();
    }

    @Override // com.baidu.live.challenge.j
    public ChallenfeInfoData.ChallengeStatus qa() {
        return this.eTK.qa();
    }

    @Override // com.baidu.live.challenge.j
    public boolean qb() {
        return this.eTK.qb();
    }

    @Override // com.baidu.live.challenge.j
    public void av(boolean z) {
        this.eTK.av(z);
    }

    private void bka() {
        if (this.eTJ != null) {
            this.eTJ.clear();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void pK() {
        if (this.eTK != null) {
            this.eTK.bkx();
        }
        bka();
    }

    @Override // com.baidu.live.challenge.j
    public void onDestroy() {
        if (this.eTK != null) {
            this.eTK.onDestroy();
        }
        bka();
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.InterfaceC0081j interfaceC0081j) {
        this.eTL = interfaceC0081j;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.h hVar) {
        this.eTM = hVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.g gVar) {
        this.eTN = gVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.f fVar) {
        this.eTO = fVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.i iVar) {
        this.eTP = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.d dVar) {
        this.eTQ = dVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.a aVar) {
        this.eTR = aVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.b bVar) {
        this.eTS = bVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.k kVar) {
        this.eTT = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.e eVar) {
        this.eTK.b(eVar);
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.c cVar) {
        if (cVar != null && !this.eTJ.contains(cVar)) {
            this.eTJ.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void cU(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.eTK.pX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ad adVar, ae aeVar, ae aeVar2) {
        if (!ListUtils.isEmpty(this.eTJ)) {
            if (i == 4) {
                if (this.eTU != this.eTK.qd()) {
                    this.eTU = this.eTK.qd();
                } else {
                    return;
                }
            }
            for (j.c cVar : this.eTJ) {
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
