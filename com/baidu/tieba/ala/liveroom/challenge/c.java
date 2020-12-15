package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.i;
import com.baidu.live.data.AlaPersonChallengeData;
import com.baidu.live.data.ax;
import com.baidu.live.data.ba;
import com.baidu.live.data.be;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.challenge.b.b;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetChallengeInfoResponseMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements i {
    private List<i.c> hiK;
    private com.baidu.tieba.ala.liveroom.challenge.b.b hiL;
    private i.m hiM;
    private i.InterfaceC0180i hiN;
    private i.l hiO;
    private i.h hiP;
    private i.g hiQ;
    private i.k hiR;
    private i.e hiS;
    private i.a hiT;
    private i.b hiU;
    private i.n hiV;
    private i.d hiW;
    private i.j hiX;
    private long hiY = 0;
    private boolean hiZ = false;
    private b.a hja = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void EI() {
            if (c.this.hiM != null) {
                c.this.hiM.EI();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void p(int i, String str) {
            if (c.this.hiM != null) {
                c.this.hiM.p(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.hiN != null) {
                c.this.hiN.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void m(int i, String str) {
            if (c.this.hiN != null) {
                c.this.hiN.m(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void cA(List<com.baidu.live.challenge.d> list) {
            if (c.this.hiO != null) {
                c.this.hiO.z(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aX(int i, String str) {
            if (c.this.hiO != null) {
                c.this.hiO.o(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.hiS != null) {
                c.this.hiS.a(aVar.aHW, aVar != null ? aVar.aHX : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aY(int i, String str) {
            if (c.this.hiS != null) {
                c.this.hiS.j(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.hiS != null) {
                c.this.hiS.b(z ? 100 : 101, aVar != null ? aVar.aHX : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aZ(int i, String str) {
            if (c.this.hiS != null) {
                c.this.hiS.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void l(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.hiU != null && i > 0) {
                c.this.hiU.ed(i);
            }
            if (c.this.hiQ != null) {
                c.this.hiQ.y(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void ba(int i, String str) {
            if (c.this.hiQ != null) {
                c.this.hiQ.k(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void d(boolean z, long j) {
            if (c.this.hiX != null) {
                c.this.hiX.d(z, j);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bb(int i, String str) {
            if (c.this.hiX != null) {
                c.this.hiX.d(false, 0L);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.hiT != null) {
                c.this.hiT.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bc(int i, String str) {
            if (c.this.hiT != null) {
                c.this.hiT.i(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.hiR != null) {
                c.this.hiR.a(aVar.Ep(), aVar != null ? aVar.aHX : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bd(int i, String str) {
            if (c.this.hiR != null) {
                c.this.hiR.n(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.hiR != null) {
                c.this.hiR.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void be(int i, String str) {
            if (c.this.hiR != null) {
                c.this.hiR.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void p(boolean z, String str) {
            if (c.this.hiV != null) {
                c.this.hiV.d(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.hiP != null) {
                c.this.hiP.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void l(int i, String str) {
            if (c.this.hiP != null) {
                c.this.hiP.l(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(int i, ba baVar, be beVar, be beVar2) {
            c.this.a(i, baVar, beVar, beVar2);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void q(boolean z, String str) {
            if (c.this.hiW != null) {
                c.this.hiW.c(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public boolean ccH() {
            return c.this.hiZ;
        }
    };
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.hiL = new com.baidu.tieba.ala.liveroom.challenge.b.b(tbPageContext, tbPageContext.getUniqueId());
        this.hiL.a(this.hja);
        this.hiK = new ArrayList();
    }

    @Override // com.baidu.live.challenge.i
    public void e(long j, long j2) {
        this.hiL.e(j, j2);
    }

    @Override // com.baidu.live.challenge.i
    public void setIsHost(boolean z) {
        if (this.hiL != null) {
            this.hiL.setIsHost(z);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Ev() {
        this.hiZ = false;
    }

    @Override // com.baidu.live.challenge.i
    public void a(ax axVar) {
        this.hiZ = false;
        if (axVar != null) {
            AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage = new AlaGetChallengeInfoResponseMessage();
            alaGetChallengeInfoResponseMessage.a(axVar.aPG);
            alaGetChallengeInfoResponseMessage.a(axVar.aPH);
            alaGetChallengeInfoResponseMessage.b(axVar.aPI);
            MessageManager.getInstance().dispatchResponsedMessage(alaGetChallengeInfoResponseMessage);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void c(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && !this.hiZ) {
            this.hiL.fx(wVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Ew() {
        if (this.hiL != null) {
            this.hiL.cdq();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Ex() {
        if (this.hiL != null) {
            this.hiL.cdr();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !ED()) {
            this.hiL.fx(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void ec(int i) {
        if (this.hiU != null) {
            this.hiU.ed(i);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void EG() {
        if (this.hiL != null) {
            this.hiL.EG();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(long j, long j2, long j3, int i, String str) {
        if (this.hiL != null) {
            this.hiL.a(j, j2, j3, i, str);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Ey() {
        this.hiL.Ey();
    }

    @Override // com.baidu.live.challenge.i
    public void gy(String str) {
        this.hiL.Ij(str);
    }

    @Override // com.baidu.live.challenge.i
    public void y(int i, int i2) {
        this.hiL.y(i, i2);
    }

    @Override // com.baidu.live.challenge.i
    public void g(int i, int i2, String str) {
        this.hiL.g(i, i2, str);
    }

    @Override // com.baidu.live.challenge.i
    public void gz(String str) {
        this.hiL.gz(str);
    }

    @Override // com.baidu.live.challenge.i
    public void aH(long j) {
        this.hiL.aH(j);
    }

    @Override // com.baidu.live.challenge.i
    public void aI(long j) {
        this.hiL.aI(j);
    }

    @Override // com.baidu.live.challenge.i
    public void aJ(long j) {
        this.hiL.aJ(j);
    }

    @Override // com.baidu.live.challenge.i
    public void aK(long j) {
        this.hiL.aK(j);
    }

    @Override // com.baidu.live.challenge.i
    public void Ez() {
        this.hiL.Ez();
    }

    @Override // com.baidu.live.challenge.i
    public void EA() {
        this.hiL.EA();
    }

    @Override // com.baidu.live.challenge.i
    public void EB() {
        this.hiL.EB();
    }

    @Override // com.baidu.live.challenge.i
    public void EE() {
        this.hiL.EE();
    }

    @Override // com.baidu.live.challenge.i
    public long EF() {
        return this.hiL.EF();
    }

    @Override // com.baidu.live.challenge.i
    public ChallenfeInfoData.ChallengeStatus EC() {
        return this.hiL.EC();
    }

    @Override // com.baidu.live.challenge.i
    public boolean ED() {
        return this.hiL.ED();
    }

    @Override // com.baidu.live.challenge.i
    public void bv(boolean z) {
        this.hiL.bv(z);
    }

    private void ccG() {
        if (this.hiK != null) {
            this.hiK.clear();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void En() {
        this.hiZ = true;
        if (this.hiL != null) {
            this.hiL.cdm();
        }
        ccG();
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        if (this.hiL != null) {
            this.hiL.onDestroy();
        }
        ccG();
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.m mVar) {
        this.hiM = mVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.InterfaceC0180i interfaceC0180i) {
        this.hiN = interfaceC0180i;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.l lVar) {
        this.hiO = lVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.h hVar) {
        this.hiP = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.g gVar) {
        this.hiQ = gVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.k kVar) {
        this.hiR = kVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.e eVar) {
        this.hiS = eVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.a aVar) {
        this.hiT = aVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.b bVar) {
        this.hiU = bVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.n nVar) {
        this.hiV = nVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.d dVar) {
        this.hiW = dVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.f fVar) {
        this.hiL.b(fVar);
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.j jVar) {
        this.hiX = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.c cVar) {
        if (cVar != null && !this.hiK.contains(cVar)) {
            this.hiK.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void gx(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.hiL.Ez();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ba baVar, be beVar, be beVar2) {
        if (!ListUtils.isEmpty(this.hiK)) {
            if (i == 4) {
                if (this.hiY == this.hiL.EF()) {
                    BdLog.e("CHALLENGE_TAG challenge is Over but challenge id same?? ||Net Challenge id=" + this.hiL.EF() + "||Last Challenge id=" + this.hiY);
                    return;
                }
                this.hiY = this.hiL.EF();
            }
            for (i.c cVar : this.hiK) {
                if (cVar != null) {
                    switch (i) {
                        case 2:
                            cVar.b(baVar, beVar, beVar2);
                            continue;
                        case 3:
                            cVar.c(baVar, beVar, beVar2);
                            continue;
                        case 4:
                            cVar.d(baVar, beVar, beVar2);
                            continue;
                        case 5:
                            cVar.e(baVar, beVar, beVar2);
                            continue;
                    }
                }
            }
        }
    }
}
