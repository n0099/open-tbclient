package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.j;
import com.baidu.live.data.AlaPersonChallengeData;
import com.baidu.live.data.ad;
import com.baidu.live.data.ag;
import com.baidu.live.data.ah;
import com.baidu.live.data.n;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.challenge.b.a;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetChallengeInfoResponseMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements j {
    private List<j.c> fyP;
    private com.baidu.tieba.ala.liveroom.challenge.b.a fyQ;
    private j.InterfaceC0105j fyR;
    private j.h fyS;
    private j.g fyT;
    private j.f fyU;
    private j.i fyV;
    private j.d fyW;
    private j.a fyX;
    private j.b fyY;
    private j.k fyZ;
    private long fza = 0;
    private a.InterfaceC0491a fzb = new a.InterfaceC0491a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0491a
        public void uB() {
            if (c.this.fyR != null) {
                c.this.fyR.uB();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0491a
        public void l(int i, String str) {
            if (c.this.fyR != null) {
                c.this.fyR.l(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0491a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.fyS != null) {
                c.this.fyS.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0491a
        public void j(int i, String str) {
            if (c.this.fyS != null) {
                c.this.fyS.j(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0491a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.fyW != null) {
                c.this.fyW.a(aVar.apc, aVar != null ? aVar.apd : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0491a
        public void aD(int i, String str) {
            if (c.this.fyW != null) {
                c.this.fyW.g(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0491a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.fyW != null) {
                c.this.fyW.b(z ? 100 : 101, aVar != null ? aVar.apd : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0491a
        public void aE(int i, String str) {
            if (c.this.fyW != null) {
                c.this.fyW.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0491a
        public void l(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.fyY != null && i > 0) {
                c.this.fyY.bz(i);
            }
            if (c.this.fyU != null) {
                c.this.fyU.p(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0491a
        public void aF(int i, String str) {
            if (c.this.fyU != null) {
                c.this.fyU.h(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0491a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.fyX != null) {
                c.this.fyX.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0491a
        public void aG(int i, String str) {
            if (c.this.fyX != null) {
                c.this.fyX.f(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0491a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.fyV != null) {
                c.this.fyV.a(aVar.ui(), aVar != null ? aVar.apd : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0491a
        public void aH(int i, String str) {
            if (c.this.fyV != null) {
                c.this.fyV.k(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0491a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.fyV != null) {
                c.this.fyV.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0491a
        public void aI(int i, String str) {
            if (c.this.fyV != null) {
                c.this.fyV.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0491a
        public void l(boolean z, String str) {
            if (c.this.fyZ != null) {
                c.this.fyZ.c(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0491a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.fyT != null) {
                c.this.fyT.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0491a
        public void i(int i, String str) {
            if (c.this.fyT != null) {
                c.this.fyT.i(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0491a
        public void b(int i, ag agVar, ah ahVar, ah ahVar2) {
            c.this.a(i, agVar, ahVar, ahVar2);
        }
    };
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fyQ = new com.baidu.tieba.ala.liveroom.challenge.b.a(tbPageContext, tbPageContext.getUniqueId());
        this.fyQ.a(this.fzb);
        this.fyP = new ArrayList();
    }

    @Override // com.baidu.live.challenge.j
    public void d(long j, long j2) {
        this.fyQ.d(j, j2);
    }

    @Override // com.baidu.live.challenge.j
    public void a(ad adVar) {
        if (adVar != null) {
            AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage = new AlaGetChallengeInfoResponseMessage();
            alaGetChallengeInfoResponseMessage.a(adVar.aub);
            alaGetChallengeInfoResponseMessage.a(adVar.auc);
            alaGetChallengeInfoResponseMessage.b(adVar.aud);
            MessageManager.getInstance().dispatchResponsedMessage(alaGetChallengeInfoResponseMessage);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void c(n nVar) {
        if (nVar != null && nVar.mLiveInfo != null) {
            this.fyQ.dA(nVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void uq() {
        if (this.fyQ != null) {
            this.fyQ.buc();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void ur() {
        if (this.fyQ != null) {
            this.fyQ.bud();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !ux()) {
            this.fyQ.dA(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void by(int i) {
        if (this.fyY != null) {
            this.fyY.bz(i);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void us() {
        this.fyQ.us();
    }

    @Override // com.baidu.live.challenge.j
    public void r(int i, int i2) {
        this.fyQ.r(i, i2);
    }

    @Override // com.baidu.live.challenge.j
    public void e(int i, int i2, String str) {
        this.fyQ.e(i, i2, str);
    }

    @Override // com.baidu.live.challenge.j
    public void R(long j) {
        this.fyQ.R(j);
    }

    @Override // com.baidu.live.challenge.j
    public void S(long j) {
        this.fyQ.S(j);
    }

    @Override // com.baidu.live.challenge.j
    public void T(long j) {
        this.fyQ.T(j);
    }

    @Override // com.baidu.live.challenge.j
    public void U(long j) {
        this.fyQ.U(j);
    }

    @Override // com.baidu.live.challenge.j
    public void ut() {
        this.fyQ.ut();
    }

    @Override // com.baidu.live.challenge.j
    public void uu() {
        this.fyQ.uu();
    }

    @Override // com.baidu.live.challenge.j
    public void uv() {
        this.fyQ.uv();
    }

    @Override // com.baidu.live.challenge.j
    public void uy() {
        this.fyQ.uy();
    }

    @Override // com.baidu.live.challenge.j
    public long uz() {
        return this.fyQ.uz();
    }

    @Override // com.baidu.live.challenge.j
    public ChallenfeInfoData.ChallengeStatus uw() {
        return this.fyQ.uw();
    }

    @Override // com.baidu.live.challenge.j
    public boolean ux() {
        return this.fyQ.ux();
    }

    @Override // com.baidu.live.challenge.j
    public void aT(boolean z) {
        this.fyQ.aT(z);
    }

    private void btC() {
        if (this.fyP != null) {
            this.fyP.clear();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void ug() {
        if (this.fyQ != null) {
            this.fyQ.btY();
        }
        btC();
    }

    @Override // com.baidu.live.challenge.j
    public void onDestroy() {
        if (this.fyQ != null) {
            this.fyQ.onDestroy();
        }
        btC();
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.InterfaceC0105j interfaceC0105j) {
        this.fyR = interfaceC0105j;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.h hVar) {
        this.fyS = hVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.g gVar) {
        this.fyT = gVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.f fVar) {
        this.fyU = fVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.i iVar) {
        this.fyV = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.d dVar) {
        this.fyW = dVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.a aVar) {
        this.fyX = aVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.b bVar) {
        this.fyY = bVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.k kVar) {
        this.fyZ = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.e eVar) {
        this.fyQ.b(eVar);
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.c cVar) {
        if (cVar != null && !this.fyP.contains(cVar)) {
            this.fyP.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void dJ(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.fyQ.ut();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ag agVar, ah ahVar, ah ahVar2) {
        if (!ListUtils.isEmpty(this.fyP)) {
            if (i == 4) {
                if (this.fza != this.fyQ.uz()) {
                    this.fza = this.fyQ.uz();
                } else {
                    return;
                }
            }
            for (j.c cVar : this.fyP) {
                if (cVar != null) {
                    switch (i) {
                        case 2:
                            cVar.b(agVar, ahVar, ahVar2);
                            continue;
                        case 3:
                            cVar.c(agVar, ahVar, ahVar2);
                            continue;
                        case 4:
                            cVar.d(agVar, ahVar, ahVar2);
                            continue;
                        case 5:
                            cVar.e(agVar, ahVar, ahVar2);
                            continue;
                    }
                }
            }
        }
    }
}
