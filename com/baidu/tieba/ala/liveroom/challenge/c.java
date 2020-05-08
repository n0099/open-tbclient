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
    private List<j.c> fyU;
    private com.baidu.tieba.ala.liveroom.challenge.b.a fyV;
    private j.InterfaceC0126j fyW;
    private j.h fyX;
    private j.g fyY;
    private j.f fyZ;
    private j.i fza;
    private j.d fzb;
    private j.a fzc;
    private j.b fzd;
    private j.k fze;
    private long fzf = 0;
    private a.InterfaceC0512a fzg = new a.InterfaceC0512a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0512a
        public void uA() {
            if (c.this.fyW != null) {
                c.this.fyW.uA();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0512a
        public void l(int i, String str) {
            if (c.this.fyW != null) {
                c.this.fyW.l(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0512a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.fyX != null) {
                c.this.fyX.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0512a
        public void j(int i, String str) {
            if (c.this.fyX != null) {
                c.this.fyX.j(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0512a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.fzb != null) {
                c.this.fzb.a(aVar.api, aVar != null ? aVar.apj : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0512a
        public void aD(int i, String str) {
            if (c.this.fzb != null) {
                c.this.fzb.g(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0512a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.fzb != null) {
                c.this.fzb.b(z ? 100 : 101, aVar != null ? aVar.apj : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0512a
        public void aE(int i, String str) {
            if (c.this.fzb != null) {
                c.this.fzb.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0512a
        public void l(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.fzd != null && i > 0) {
                c.this.fzd.bz(i);
            }
            if (c.this.fyZ != null) {
                c.this.fyZ.p(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0512a
        public void aF(int i, String str) {
            if (c.this.fyZ != null) {
                c.this.fyZ.h(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0512a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.fzc != null) {
                c.this.fzc.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0512a
        public void aG(int i, String str) {
            if (c.this.fzc != null) {
                c.this.fzc.f(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0512a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.fza != null) {
                c.this.fza.a(aVar.uh(), aVar != null ? aVar.apj : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0512a
        public void aH(int i, String str) {
            if (c.this.fza != null) {
                c.this.fza.k(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0512a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.fza != null) {
                c.this.fza.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0512a
        public void aI(int i, String str) {
            if (c.this.fza != null) {
                c.this.fza.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0512a
        public void l(boolean z, String str) {
            if (c.this.fze != null) {
                c.this.fze.c(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0512a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.fyY != null) {
                c.this.fyY.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0512a
        public void i(int i, String str) {
            if (c.this.fyY != null) {
                c.this.fyY.i(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0512a
        public void b(int i, ag agVar, ah ahVar, ah ahVar2) {
            c.this.a(i, agVar, ahVar, ahVar2);
        }
    };
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fyV = new com.baidu.tieba.ala.liveroom.challenge.b.a(tbPageContext, tbPageContext.getUniqueId());
        this.fyV.a(this.fzg);
        this.fyU = new ArrayList();
    }

    @Override // com.baidu.live.challenge.j
    public void d(long j, long j2) {
        this.fyV.d(j, j2);
    }

    @Override // com.baidu.live.challenge.j
    public void a(ad adVar) {
        if (adVar != null) {
            AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage = new AlaGetChallengeInfoResponseMessage();
            alaGetChallengeInfoResponseMessage.a(adVar.auh);
            alaGetChallengeInfoResponseMessage.a(adVar.aui);
            alaGetChallengeInfoResponseMessage.b(adVar.auj);
            MessageManager.getInstance().dispatchResponsedMessage(alaGetChallengeInfoResponseMessage);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void c(n nVar) {
        if (nVar != null && nVar.mLiveInfo != null) {
            this.fyV.dA(nVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void up() {
        if (this.fyV != null) {
            this.fyV.bua();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void uq() {
        if (this.fyV != null) {
            this.fyV.bub();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !uw()) {
            this.fyV.dA(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void by(int i) {
        if (this.fzd != null) {
            this.fzd.bz(i);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void ur() {
        this.fyV.ur();
    }

    @Override // com.baidu.live.challenge.j
    public void r(int i, int i2) {
        this.fyV.r(i, i2);
    }

    @Override // com.baidu.live.challenge.j
    public void e(int i, int i2, String str) {
        this.fyV.e(i, i2, str);
    }

    @Override // com.baidu.live.challenge.j
    public void R(long j) {
        this.fyV.R(j);
    }

    @Override // com.baidu.live.challenge.j
    public void S(long j) {
        this.fyV.S(j);
    }

    @Override // com.baidu.live.challenge.j
    public void T(long j) {
        this.fyV.T(j);
    }

    @Override // com.baidu.live.challenge.j
    public void U(long j) {
        this.fyV.U(j);
    }

    @Override // com.baidu.live.challenge.j
    public void us() {
        this.fyV.us();
    }

    @Override // com.baidu.live.challenge.j
    public void ut() {
        this.fyV.ut();
    }

    @Override // com.baidu.live.challenge.j
    public void uu() {
        this.fyV.uu();
    }

    @Override // com.baidu.live.challenge.j
    public void ux() {
        this.fyV.ux();
    }

    @Override // com.baidu.live.challenge.j
    public long uy() {
        return this.fyV.uy();
    }

    @Override // com.baidu.live.challenge.j
    public ChallenfeInfoData.ChallengeStatus uv() {
        return this.fyV.uv();
    }

    @Override // com.baidu.live.challenge.j
    public boolean uw() {
        return this.fyV.uw();
    }

    @Override // com.baidu.live.challenge.j
    public void aT(boolean z) {
        this.fyV.aT(z);
    }

    private void btA() {
        if (this.fyU != null) {
            this.fyU.clear();
        }
    }

    @Override // com.baidu.live.challenge.j
    public void uf() {
        if (this.fyV != null) {
            this.fyV.btW();
        }
        btA();
    }

    @Override // com.baidu.live.challenge.j
    public void onDestroy() {
        if (this.fyV != null) {
            this.fyV.onDestroy();
        }
        btA();
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.InterfaceC0126j interfaceC0126j) {
        this.fyW = interfaceC0126j;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.h hVar) {
        this.fyX = hVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.g gVar) {
        this.fyY = gVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.f fVar) {
        this.fyZ = fVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.i iVar) {
        this.fza = iVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.d dVar) {
        this.fzb = dVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.a aVar) {
        this.fzc = aVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.b bVar) {
        this.fzd = bVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.k kVar) {
        this.fze = kVar;
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.e eVar) {
        this.fyV.b(eVar);
    }

    @Override // com.baidu.live.challenge.j
    public void a(j.c cVar) {
        if (cVar != null && !this.fyU.contains(cVar)) {
            this.fyU.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.j
    public void dJ(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.fyV.us();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ag agVar, ah ahVar, ah ahVar2) {
        if (!ListUtils.isEmpty(this.fyU)) {
            if (i == 4) {
                if (this.fzf != this.fyV.uy()) {
                    this.fzf = this.fyV.uy();
                } else {
                    return;
                }
            }
            for (j.c cVar : this.fyU) {
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
