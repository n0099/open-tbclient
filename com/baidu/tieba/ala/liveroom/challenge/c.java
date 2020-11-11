package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.i;
import com.baidu.live.data.AlaPersonChallengeData;
import com.baidu.live.data.aw;
import com.baidu.live.data.az;
import com.baidu.live.data.bd;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.challenge.b.b;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetChallengeInfoResponseMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements i {
    private i.e gZA;
    private i.a gZB;
    private i.b gZC;
    private i.n gZD;
    private i.d gZE;
    private i.j gZF;
    private long gZG = 0;
    private boolean gZH = false;
    private b.a gZI = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void DH() {
            if (c.this.gZu != null) {
                c.this.gZu.DH();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void p(int i, String str) {
            if (c.this.gZu != null) {
                c.this.gZu.p(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.gZv != null) {
                c.this.gZv.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void m(int i, String str) {
            if (c.this.gZv != null) {
                c.this.gZv.m(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void cw(List<com.baidu.live.challenge.d> list) {
            if (c.this.gZw != null) {
                c.this.gZw.y(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aZ(int i, String str) {
            if (c.this.gZw != null) {
                c.this.gZw.o(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.gZA != null) {
                c.this.gZA.a(aVar.aGZ, aVar != null ? aVar.aHa : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void ba(int i, String str) {
            if (c.this.gZA != null) {
                c.this.gZA.j(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gZA != null) {
                c.this.gZA.b(z ? 100 : 101, aVar != null ? aVar.aHa : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bb(int i, String str) {
            if (c.this.gZA != null) {
                c.this.gZA.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void l(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.gZC != null && i > 0) {
                c.this.gZC.dO(i);
            }
            if (c.this.gZy != null) {
                c.this.gZy.x(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bc(int i, String str) {
            if (c.this.gZy != null) {
                c.this.gZy.k(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void d(boolean z, long j) {
            if (c.this.gZF != null) {
                c.this.gZF.d(z, j);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bd(int i, String str) {
            if (c.this.gZF != null) {
                c.this.gZF.d(false, 0L);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gZB != null) {
                c.this.gZB.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void be(int i, String str) {
            if (c.this.gZB != null) {
                c.this.gZB.i(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.gZz != null) {
                c.this.gZz.a(aVar.Do(), aVar != null ? aVar.aHa : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bf(int i, String str) {
            if (c.this.gZz != null) {
                c.this.gZz.n(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gZz != null) {
                c.this.gZz.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bg(int i, String str) {
            if (c.this.gZz != null) {
                c.this.gZz.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void p(boolean z, String str) {
            if (c.this.gZD != null) {
                c.this.gZD.d(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.gZx != null) {
                c.this.gZx.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void l(int i, String str) {
            if (c.this.gZx != null) {
                c.this.gZx.l(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(int i, az azVar, bd bdVar, bd bdVar2) {
            c.this.a(i, azVar, bdVar, bdVar2);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void q(boolean z, String str) {
            if (c.this.gZE != null) {
                c.this.gZE.c(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public boolean bZs() {
            return c.this.gZH;
        }
    };
    private List<i.c> gZs;
    private com.baidu.tieba.ala.liveroom.challenge.b.b gZt;
    private i.m gZu;
    private i.InterfaceC0177i gZv;
    private i.l gZw;
    private i.h gZx;
    private i.g gZy;
    private i.k gZz;
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gZt = new com.baidu.tieba.ala.liveroom.challenge.b.b(tbPageContext, tbPageContext.getUniqueId());
        this.gZt.a(this.gZI);
        this.gZs = new ArrayList();
    }

    @Override // com.baidu.live.challenge.i
    public void e(long j, long j2) {
        this.gZt.e(j, j2);
    }

    @Override // com.baidu.live.challenge.i
    public void setIsHost(boolean z) {
        if (this.gZt != null) {
            this.gZt.setIsHost(z);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Du() {
        this.gZH = false;
    }

    @Override // com.baidu.live.challenge.i
    public void a(aw awVar) {
        this.gZH = false;
        if (awVar != null) {
            AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage = new AlaGetChallengeInfoResponseMessage();
            alaGetChallengeInfoResponseMessage.a(awVar.aOs);
            alaGetChallengeInfoResponseMessage.a(awVar.aOt);
            alaGetChallengeInfoResponseMessage.b(awVar.aOu);
            MessageManager.getInstance().dispatchResponsedMessage(alaGetChallengeInfoResponseMessage);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void c(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && !this.gZH) {
            this.gZt.eT(wVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Dv() {
        if (this.gZt != null) {
            this.gZt.cab();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Dw() {
        if (this.gZt != null) {
            this.gZt.cac();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !DC()) {
            this.gZt.eT(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void dN(int i) {
        if (this.gZC != null) {
            this.gZC.dO(i);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void DF() {
        if (this.gZt != null) {
            this.gZt.DF();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(long j, long j2, long j3, int i, String str) {
        if (this.gZt != null) {
            this.gZt.a(j, j2, j3, i, str);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Dx() {
        this.gZt.Dx();
    }

    @Override // com.baidu.live.challenge.i
    public void gi(String str) {
        this.gZt.HT(str);
    }

    @Override // com.baidu.live.challenge.i
    public void w(int i, int i2) {
        this.gZt.w(i, i2);
    }

    @Override // com.baidu.live.challenge.i
    public void g(int i, int i2, String str) {
        this.gZt.g(i, i2, str);
    }

    @Override // com.baidu.live.challenge.i
    public void gj(String str) {
        this.gZt.gj(str);
    }

    @Override // com.baidu.live.challenge.i
    public void aj(long j) {
        this.gZt.aj(j);
    }

    @Override // com.baidu.live.challenge.i
    public void ak(long j) {
        this.gZt.ak(j);
    }

    @Override // com.baidu.live.challenge.i
    public void al(long j) {
        this.gZt.al(j);
    }

    @Override // com.baidu.live.challenge.i
    public void am(long j) {
        this.gZt.am(j);
    }

    @Override // com.baidu.live.challenge.i
    public void Dy() {
        this.gZt.Dy();
    }

    @Override // com.baidu.live.challenge.i
    public void Dz() {
        this.gZt.Dz();
    }

    @Override // com.baidu.live.challenge.i
    public void DA() {
        this.gZt.DA();
    }

    @Override // com.baidu.live.challenge.i
    public void DD() {
        this.gZt.DD();
    }

    @Override // com.baidu.live.challenge.i
    public long DE() {
        return this.gZt.DE();
    }

    @Override // com.baidu.live.challenge.i
    public ChallenfeInfoData.ChallengeStatus DB() {
        return this.gZt.DB();
    }

    @Override // com.baidu.live.challenge.i
    public boolean DC() {
        return this.gZt.DC();
    }

    @Override // com.baidu.live.challenge.i
    public void bl(boolean z) {
        this.gZt.bl(z);
    }

    private void bZr() {
        if (this.gZs != null) {
            this.gZs.clear();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Dm() {
        this.gZH = true;
        if (this.gZt != null) {
            this.gZt.bZX();
        }
        bZr();
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        if (this.gZt != null) {
            this.gZt.onDestroy();
        }
        bZr();
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.m mVar) {
        this.gZu = mVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.InterfaceC0177i interfaceC0177i) {
        this.gZv = interfaceC0177i;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.l lVar) {
        this.gZw = lVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.h hVar) {
        this.gZx = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.g gVar) {
        this.gZy = gVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.k kVar) {
        this.gZz = kVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.e eVar) {
        this.gZA = eVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.a aVar) {
        this.gZB = aVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.b bVar) {
        this.gZC = bVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.n nVar) {
        this.gZD = nVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.d dVar) {
        this.gZE = dVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.f fVar) {
        this.gZt.b(fVar);
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.j jVar) {
        this.gZF = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.c cVar) {
        if (cVar != null && !this.gZs.contains(cVar)) {
            this.gZs.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void gh(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.gZt.Dy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, az azVar, bd bdVar, bd bdVar2) {
        if (!ListUtils.isEmpty(this.gZs)) {
            if (i == 4) {
                if (this.gZG == this.gZt.DE()) {
                    BdLog.e("CHALLENGE_TAG challenge is Over but challenge id same?? ||Net Challenge id=" + this.gZt.DE() + "||Last Challenge id=" + this.gZG);
                    return;
                }
                this.gZG = this.gZt.DE();
            }
            for (i.c cVar : this.gZs) {
                if (cVar != null) {
                    switch (i) {
                        case 2:
                            cVar.b(azVar, bdVar, bdVar2);
                            continue;
                        case 3:
                            cVar.c(azVar, bdVar, bdVar2);
                            continue;
                        case 4:
                            cVar.d(azVar, bdVar, bdVar2);
                            continue;
                        case 5:
                            cVar.e(azVar, bdVar, bdVar2);
                            continue;
                    }
                }
            }
        }
    }
}
