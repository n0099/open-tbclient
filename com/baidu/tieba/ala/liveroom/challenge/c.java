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
    private List<j.c> eTK;
    private com.baidu.tieba.ala.liveroom.challenge.b.a eTL;
    private j.InterfaceC0081j eTM;
    private j.h eTN;
    private j.g eTO;
    private j.f eTP;
    private j.i eTQ;
    private j.d eTR;
    private j.a eTS;
    private j.b eTT;
    private j.k eTU;
    private long eTV = 0;
    private a.InterfaceC0456a eTW = new a.InterfaceC0456a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void qf() {
            if (c.this.eTM != null) {
                c.this.eTM.qf();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void m(int i, String str) {
            if (c.this.eTM != null) {
                c.this.eTM.m(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.eTN != null) {
                c.this.eTN.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void k(int i, String str) {
            if (c.this.eTN != null) {
                c.this.eTN.k(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.eTR != null) {
                c.this.eTR.a(aVar.WQ, aVar != null ? aVar.WR : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void ao(int i, String str) {
            if (c.this.eTR != null) {
                c.this.eTR.h(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.eTR != null) {
                c.this.eTR.b(z ? 100 : 101, aVar != null ? aVar.WR : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void ap(int i, String str) {
            if (c.this.eTR != null) {
                c.this.eTR.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void k(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.eTT != null && i > 0) {
                c.this.eTT.bm(i);
            }
            if (c.this.eTP != null) {
                c.this.eTP.m(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void aq(int i, String str) {
            if (c.this.eTP != null) {
                c.this.eTP.i(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.eTS != null) {
                c.this.eTS.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void ar(int i, String str) {
            if (c.this.eTS != null) {
                c.this.eTS.g(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.eTQ != null) {
                c.this.eTQ.a(aVar.pM(), aVar != null ? aVar.WR : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void as(int i, String str) {
            if (c.this.eTQ != null) {
                c.this.eTQ.l(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.eTQ != null) {
                c.this.eTQ.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void at(int i, String str) {
            if (c.this.eTQ != null) {
                c.this.eTQ.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void k(boolean z, String str) {
            if (c.this.eTU != null) {
                c.this.eTU.d(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.eTO != null) {
                c.this.eTO.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0456a
        public void j(int i, String str) {
            if (c.this.eTO != null) {
                c.this.eTO.j(i, str);
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
        this.eTL = new com.baidu.tieba.ala.liveroom.challenge.b.a(tbPageContext, tbPageContext.getUniqueId());
        this.eTL.a(this.eTW);
        this.eTK = new ArrayList();
    }

    @Override // com.baidu.live.challenge.j
    public void d(long j, long j2) {
        this.eTL.d(j, j2);
    }

    @Override // com.baidu.live.challenge.j
    public void c(m mVar) {
        if (mVar != null && mVar.mLiveInfo != null) {
            this.eTL.cS(mVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void pU() {
        if (this.eTL != null) {
            this.eTL.bkD();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void pV() {
        if (this.eTL != null) {
            this.eTL.bkE();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !qb()) {
            this.eTL.cS(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void bl(int i) {
        if (this.eTT != null) {
            this.eTT.bm(i);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void pW() {
        this.eTL.pW();
    }

    @Override // com.baidu.live.challenge.j
    public void s(int i, int i2) {
        this.eTL.s(i, i2);
    }

    @Override // com.baidu.live.challenge.j
    public void e(int i, int i2, String str) {
        this.eTL.e(i, i2, str);
    }

    @Override // com.baidu.live.challenge.j
    public void t(long j) {
        this.eTL.t(j);
    }

    @Override // com.baidu.live.challenge.j
    public void u(long j) {
        this.eTL.u(j);
    }

    @Override // com.baidu.live.challenge.j
    public void v(long j) {
        this.eTL.v(j);
    }

    @Override // com.baidu.live.challenge.j
    public void w(long j) {
        this.eTL.w(j);
    }

    @Override // com.baidu.live.challenge.j
    public void pX() {
        this.eTL.pX();
    }

    @Override // com.baidu.live.challenge.j
    public void pY() {
        this.eTL.pY();
    }

    @Override // com.baidu.live.challenge.j
    public void pZ() {
        this.eTL.pZ();
    }

    @Override // com.baidu.live.challenge.j
    public void qc() {
        this.eTL.qc();
    }

    @Override // com.baidu.live.challenge.j
    public long qd() {
        return this.eTL.qd();
    }

    @Override // com.baidu.live.challenge.j
    public ChallenfeInfoData.ChallengeStatus qa() {
        return this.eTL.qa();
    }

    @Override // com.baidu.live.challenge.j
    public boolean qb() {
        return this.eTL.qb();
    }

    @Override // com.baidu.live.challenge.j
    public void av(boolean z) {
        this.eTL.av(z);
    }

    private void bkc() {
        if (this.eTK != null) {
            this.eTK.clear();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void pK() {
        if (this.eTL != null) {
            this.eTL.bkz();
        }
        bkc();
    }

    @Override // com.baidu.live.challenge.j
    public void onDestroy() {
        if (this.eTL != null) {
            this.eTL.onDestroy();
        }
        bkc();
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.InterfaceC0081j interfaceC0081j) {
        this.eTM = interfaceC0081j;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.h hVar) {
        this.eTN = hVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.g gVar) {
        this.eTO = gVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.f fVar) {
        this.eTP = fVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.i iVar) {
        this.eTQ = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.d dVar) {
        this.eTR = dVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.a aVar) {
        this.eTS = aVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.b bVar) {
        this.eTT = bVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.k kVar) {
        this.eTU = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.e eVar) {
        this.eTL.b(eVar);
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.c cVar) {
        if (cVar != null && !this.eTK.contains(cVar)) {
            this.eTK.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void cU(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.eTL.pX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ad adVar, ae aeVar, ae aeVar2) {
        if (!ListUtils.isEmpty(this.eTK)) {
            if (i == 4) {
                if (this.eTV != this.eTL.qd()) {
                    this.eTV = this.eTL.qd();
                } else {
                    return;
                }
            }
            for (j.c cVar : this.eTK) {
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
