package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.i;
import com.baidu.live.data.AlaPersonChallengeData;
import com.baidu.live.data.ar;
import com.baidu.live.data.au;
import com.baidu.live.data.ay;
import com.baidu.live.data.u;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.challenge.b.b;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetChallengeInfoResponseMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements i {
    private i.m gHA;
    private i.InterfaceC0174i gHB;
    private i.l gHC;
    private i.h gHD;
    private i.g gHE;
    private i.k gHF;
    private i.e gHG;
    private i.a gHH;
    private i.b gHI;
    private i.n gHJ;
    private i.d gHK;
    private i.j gHL;
    private long gHM = 0;
    private boolean gHN = false;
    private b.a gHO = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void Dh() {
            if (c.this.gHA != null) {
                c.this.gHA.Dh();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void p(int i, String str) {
            if (c.this.gHA != null) {
                c.this.gHA.p(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.gHB != null) {
                c.this.gHB.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void m(int i, String str) {
            if (c.this.gHB != null) {
                c.this.gHB.m(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void ce(List<com.baidu.live.challenge.d> list) {
            if (c.this.gHC != null) {
                c.this.gHC.y(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aU(int i, String str) {
            if (c.this.gHC != null) {
                c.this.gHC.o(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.gHG != null) {
                c.this.gHG.a(aVar.aGb, aVar != null ? aVar.aGc : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aV(int i, String str) {
            if (c.this.gHG != null) {
                c.this.gHG.j(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gHG != null) {
                c.this.gHG.b(z ? 100 : 101, aVar != null ? aVar.aGc : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aW(int i, String str) {
            if (c.this.gHG != null) {
                c.this.gHG.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void l(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.gHI != null && i > 0) {
                c.this.gHI.dO(i);
            }
            if (c.this.gHE != null) {
                c.this.gHE.x(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aX(int i, String str) {
            if (c.this.gHE != null) {
                c.this.gHE.k(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void d(boolean z, long j) {
            if (c.this.gHL != null) {
                c.this.gHL.d(z, j);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gHH != null) {
                c.this.gHH.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aY(int i, String str) {
            if (c.this.gHH != null) {
                c.this.gHH.i(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.gHF != null) {
                c.this.gHF.a(aVar.CP(), aVar != null ? aVar.aGc : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aZ(int i, String str) {
            if (c.this.gHF != null) {
                c.this.gHF.n(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gHF != null) {
                c.this.gHF.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void ba(int i, String str) {
            if (c.this.gHF != null) {
                c.this.gHF.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void n(boolean z, String str) {
            if (c.this.gHJ != null) {
                c.this.gHJ.d(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.gHD != null) {
                c.this.gHD.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void l(int i, String str) {
            if (c.this.gHD != null) {
                c.this.gHD.l(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(int i, au auVar, ay ayVar, ay ayVar2) {
            c.this.a(i, auVar, ayVar, ayVar2);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void o(boolean z, String str) {
            if (c.this.gHK != null) {
                c.this.gHK.c(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public boolean bTR() {
            return c.this.gHN;
        }
    };
    private List<i.c> gHy;
    private com.baidu.tieba.ala.liveroom.challenge.b.b gHz;
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gHz = new com.baidu.tieba.ala.liveroom.challenge.b.b(tbPageContext, tbPageContext.getUniqueId());
        this.gHz.a(this.gHO);
        this.gHy = new ArrayList();
    }

    @Override // com.baidu.live.challenge.i
    public void e(long j, long j2) {
        this.gHz.e(j, j2);
    }

    @Override // com.baidu.live.challenge.i
    public void setIsHost(boolean z) {
        if (this.gHz != null) {
            this.gHz.setIsHost(z);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(ar arVar) {
        this.gHN = false;
        if (arVar != null) {
            AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage = new AlaGetChallengeInfoResponseMessage();
            alaGetChallengeInfoResponseMessage.a(arVar.aMK);
            alaGetChallengeInfoResponseMessage.a(arVar.aML);
            alaGetChallengeInfoResponseMessage.b(arVar.aMM);
            MessageManager.getInstance().dispatchResponsedMessage(alaGetChallengeInfoResponseMessage);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void c(u uVar) {
        if (uVar != null && uVar.mLiveInfo != null && !this.gHN) {
            this.gHz.ev(uVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void CV() {
        if (this.gHz != null) {
            this.gHz.bUA();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void CW() {
        if (this.gHz != null) {
            this.gHz.bUB();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !Dc()) {
            this.gHz.ev(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void dN(int i) {
        if (this.gHI != null) {
            this.gHI.dO(i);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Df() {
        if (this.gHz != null) {
            this.gHz.Df();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(long j, long j2, long j3, int i, String str) {
        if (this.gHz != null) {
            this.gHz.a(j, j2, j3, i, str);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void CX() {
        this.gHz.CX();
    }

    @Override // com.baidu.live.challenge.i
    public void gc(String str) {
        this.gHz.Hd(str);
    }

    @Override // com.baidu.live.challenge.i
    public void w(int i, int i2) {
        this.gHz.w(i, i2);
    }

    @Override // com.baidu.live.challenge.i
    public void f(int i, int i2, String str) {
        this.gHz.f(i, i2, str);
    }

    @Override // com.baidu.live.challenge.i
    public void gd(String str) {
        this.gHz.gd(str);
    }

    @Override // com.baidu.live.challenge.i
    public void X(long j) {
        this.gHz.X(j);
    }

    @Override // com.baidu.live.challenge.i
    public void Y(long j) {
        this.gHz.Y(j);
    }

    @Override // com.baidu.live.challenge.i
    public void Z(long j) {
        this.gHz.Z(j);
    }

    @Override // com.baidu.live.challenge.i
    public void aa(long j) {
        this.gHz.aa(j);
    }

    @Override // com.baidu.live.challenge.i
    public void CY() {
        this.gHz.CY();
    }

    @Override // com.baidu.live.challenge.i
    public void CZ() {
        this.gHz.CZ();
    }

    @Override // com.baidu.live.challenge.i
    public void Da() {
        this.gHz.Da();
    }

    @Override // com.baidu.live.challenge.i
    public void Dd() {
        this.gHz.Dd();
    }

    @Override // com.baidu.live.challenge.i
    public long De() {
        return this.gHz.De();
    }

    @Override // com.baidu.live.challenge.i
    public ChallenfeInfoData.ChallengeStatus Db() {
        return this.gHz.Db();
    }

    @Override // com.baidu.live.challenge.i
    public boolean Dc() {
        return this.gHz.Dc();
    }

    @Override // com.baidu.live.challenge.i
    public void bj(boolean z) {
        this.gHz.bj(z);
    }

    private void bTQ() {
        if (this.gHy != null) {
            this.gHy.clear();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void CN() {
        this.gHN = true;
        if (this.gHz != null) {
            this.gHz.bUw();
        }
        bTQ();
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        if (this.gHz != null) {
            this.gHz.onDestroy();
        }
        bTQ();
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.m mVar) {
        this.gHA = mVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.InterfaceC0174i interfaceC0174i) {
        this.gHB = interfaceC0174i;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.l lVar) {
        this.gHC = lVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.h hVar) {
        this.gHD = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.g gVar) {
        this.gHE = gVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.k kVar) {
        this.gHF = kVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.e eVar) {
        this.gHG = eVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.a aVar) {
        this.gHH = aVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.b bVar) {
        this.gHI = bVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.n nVar) {
        this.gHJ = nVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.d dVar) {
        this.gHK = dVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.f fVar) {
        this.gHz.b(fVar);
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.j jVar) {
        this.gHL = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.c cVar) {
        if (cVar != null && !this.gHy.contains(cVar)) {
            this.gHy.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void gb(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.gHz.CY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, au auVar, ay ayVar, ay ayVar2) {
        if (!ListUtils.isEmpty(this.gHy)) {
            if (i == 4) {
                if (this.gHM == this.gHz.De()) {
                    BdLog.e("CHALLENGE_TAG challenge is Over but challenge id same?? ||Net Challenge id=" + this.gHz.De() + "||Last Challenge id=" + this.gHM);
                    return;
                }
                this.gHM = this.gHz.De();
            }
            for (i.c cVar : this.gHy) {
                if (cVar != null) {
                    switch (i) {
                        case 2:
                            cVar.b(auVar, ayVar, ayVar2);
                            continue;
                        case 3:
                            cVar.c(auVar, ayVar, ayVar2);
                            continue;
                        case 4:
                            cVar.d(auVar, ayVar, ayVar2);
                            continue;
                        case 5:
                            cVar.e(auVar, ayVar, ayVar2);
                            continue;
                    }
                }
            }
        }
    }
}
