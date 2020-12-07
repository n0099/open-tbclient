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
    private List<i.c> hiI;
    private com.baidu.tieba.ala.liveroom.challenge.b.b hiJ;
    private i.m hiK;
    private i.InterfaceC0180i hiL;
    private i.l hiM;
    private i.h hiN;
    private i.g hiO;
    private i.k hiP;
    private i.e hiQ;
    private i.a hiR;
    private i.b hiS;
    private i.n hiT;
    private i.d hiU;
    private i.j hiV;
    private long hiW = 0;
    private boolean hiX = false;
    private b.a hiY = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void EI() {
            if (c.this.hiK != null) {
                c.this.hiK.EI();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void p(int i, String str) {
            if (c.this.hiK != null) {
                c.this.hiK.p(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.hiL != null) {
                c.this.hiL.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void m(int i, String str) {
            if (c.this.hiL != null) {
                c.this.hiL.m(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void cA(List<com.baidu.live.challenge.d> list) {
            if (c.this.hiM != null) {
                c.this.hiM.z(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aX(int i, String str) {
            if (c.this.hiM != null) {
                c.this.hiM.o(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.hiQ != null) {
                c.this.hiQ.a(aVar.aHW, aVar != null ? aVar.aHX : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aY(int i, String str) {
            if (c.this.hiQ != null) {
                c.this.hiQ.j(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.hiQ != null) {
                c.this.hiQ.b(z ? 100 : 101, aVar != null ? aVar.aHX : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aZ(int i, String str) {
            if (c.this.hiQ != null) {
                c.this.hiQ.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void l(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.hiS != null && i > 0) {
                c.this.hiS.ed(i);
            }
            if (c.this.hiO != null) {
                c.this.hiO.y(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void ba(int i, String str) {
            if (c.this.hiO != null) {
                c.this.hiO.k(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void d(boolean z, long j) {
            if (c.this.hiV != null) {
                c.this.hiV.d(z, j);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bb(int i, String str) {
            if (c.this.hiV != null) {
                c.this.hiV.d(false, 0L);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.hiR != null) {
                c.this.hiR.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bc(int i, String str) {
            if (c.this.hiR != null) {
                c.this.hiR.i(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.hiP != null) {
                c.this.hiP.a(aVar.Ep(), aVar != null ? aVar.aHX : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bd(int i, String str) {
            if (c.this.hiP != null) {
                c.this.hiP.n(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.hiP != null) {
                c.this.hiP.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void be(int i, String str) {
            if (c.this.hiP != null) {
                c.this.hiP.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void p(boolean z, String str) {
            if (c.this.hiT != null) {
                c.this.hiT.d(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.hiN != null) {
                c.this.hiN.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void l(int i, String str) {
            if (c.this.hiN != null) {
                c.this.hiN.l(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(int i, ba baVar, be beVar, be beVar2) {
            c.this.a(i, baVar, beVar, beVar2);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void q(boolean z, String str) {
            if (c.this.hiU != null) {
                c.this.hiU.c(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public boolean ccG() {
            return c.this.hiX;
        }
    };
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.hiJ = new com.baidu.tieba.ala.liveroom.challenge.b.b(tbPageContext, tbPageContext.getUniqueId());
        this.hiJ.a(this.hiY);
        this.hiI = new ArrayList();
    }

    @Override // com.baidu.live.challenge.i
    public void e(long j, long j2) {
        this.hiJ.e(j, j2);
    }

    @Override // com.baidu.live.challenge.i
    public void setIsHost(boolean z) {
        if (this.hiJ != null) {
            this.hiJ.setIsHost(z);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Ev() {
        this.hiX = false;
    }

    @Override // com.baidu.live.challenge.i
    public void a(ax axVar) {
        this.hiX = false;
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
        if (wVar != null && wVar.mLiveInfo != null && !this.hiX) {
            this.hiJ.fx(wVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Ew() {
        if (this.hiJ != null) {
            this.hiJ.cdp();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Ex() {
        if (this.hiJ != null) {
            this.hiJ.cdq();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !ED()) {
            this.hiJ.fx(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void ec(int i) {
        if (this.hiS != null) {
            this.hiS.ed(i);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void EG() {
        if (this.hiJ != null) {
            this.hiJ.EG();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(long j, long j2, long j3, int i, String str) {
        if (this.hiJ != null) {
            this.hiJ.a(j, j2, j3, i, str);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Ey() {
        this.hiJ.Ey();
    }

    @Override // com.baidu.live.challenge.i
    public void gy(String str) {
        this.hiJ.Ij(str);
    }

    @Override // com.baidu.live.challenge.i
    public void y(int i, int i2) {
        this.hiJ.y(i, i2);
    }

    @Override // com.baidu.live.challenge.i
    public void g(int i, int i2, String str) {
        this.hiJ.g(i, i2, str);
    }

    @Override // com.baidu.live.challenge.i
    public void gz(String str) {
        this.hiJ.gz(str);
    }

    @Override // com.baidu.live.challenge.i
    public void aH(long j) {
        this.hiJ.aH(j);
    }

    @Override // com.baidu.live.challenge.i
    public void aI(long j) {
        this.hiJ.aI(j);
    }

    @Override // com.baidu.live.challenge.i
    public void aJ(long j) {
        this.hiJ.aJ(j);
    }

    @Override // com.baidu.live.challenge.i
    public void aK(long j) {
        this.hiJ.aK(j);
    }

    @Override // com.baidu.live.challenge.i
    public void Ez() {
        this.hiJ.Ez();
    }

    @Override // com.baidu.live.challenge.i
    public void EA() {
        this.hiJ.EA();
    }

    @Override // com.baidu.live.challenge.i
    public void EB() {
        this.hiJ.EB();
    }

    @Override // com.baidu.live.challenge.i
    public void EE() {
        this.hiJ.EE();
    }

    @Override // com.baidu.live.challenge.i
    public long EF() {
        return this.hiJ.EF();
    }

    @Override // com.baidu.live.challenge.i
    public ChallenfeInfoData.ChallengeStatus EC() {
        return this.hiJ.EC();
    }

    @Override // com.baidu.live.challenge.i
    public boolean ED() {
        return this.hiJ.ED();
    }

    @Override // com.baidu.live.challenge.i
    public void bv(boolean z) {
        this.hiJ.bv(z);
    }

    private void ccF() {
        if (this.hiI != null) {
            this.hiI.clear();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void En() {
        this.hiX = true;
        if (this.hiJ != null) {
            this.hiJ.cdl();
        }
        ccF();
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        if (this.hiJ != null) {
            this.hiJ.onDestroy();
        }
        ccF();
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.m mVar) {
        this.hiK = mVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.InterfaceC0180i interfaceC0180i) {
        this.hiL = interfaceC0180i;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.l lVar) {
        this.hiM = lVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.h hVar) {
        this.hiN = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.g gVar) {
        this.hiO = gVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.k kVar) {
        this.hiP = kVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.e eVar) {
        this.hiQ = eVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.a aVar) {
        this.hiR = aVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.b bVar) {
        this.hiS = bVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.n nVar) {
        this.hiT = nVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.d dVar) {
        this.hiU = dVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.f fVar) {
        this.hiJ.b(fVar);
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.j jVar) {
        this.hiV = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.c cVar) {
        if (cVar != null && !this.hiI.contains(cVar)) {
            this.hiI.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void gx(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.hiJ.Ez();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ba baVar, be beVar, be beVar2) {
        if (!ListUtils.isEmpty(this.hiI)) {
            if (i == 4) {
                if (this.hiW == this.hiJ.EF()) {
                    BdLog.e("CHALLENGE_TAG challenge is Over but challenge id same?? ||Net Challenge id=" + this.hiJ.EF() + "||Last Challenge id=" + this.hiW);
                    return;
                }
                this.hiW = this.hiJ.EF();
            }
            for (i.c cVar : this.hiI) {
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
