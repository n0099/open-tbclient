package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.i;
import com.baidu.live.data.AlaPersonChallengeData;
import com.baidu.live.data.az;
import com.baidu.live.data.bc;
import com.baidu.live.data.bg;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.challenge.b.b;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetChallengeInfoResponseMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class c implements i {
    private List<i.c> huF;
    private com.baidu.tieba.ala.liveroom.challenge.b.b huG;
    private i.m huH;
    private i.InterfaceC0174i huI;
    private i.l huJ;
    private i.h huK;
    private i.g huL;
    private i.k huM;
    private i.e huN;
    private i.a huO;
    private i.b huP;
    private i.n huQ;
    private i.d huR;
    private i.j huS;
    private long huT = 0;
    private boolean huU = false;
    private b.a huV = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void DX() {
            if (c.this.huH != null) {
                c.this.huH.DX();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void p(int i, String str) {
            if (c.this.huH != null) {
                c.this.huH.p(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.huI != null) {
                c.this.huI.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void m(int i, String str) {
            if (c.this.huI != null) {
                c.this.huI.m(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void cH(List<com.baidu.live.challenge.d> list) {
            if (c.this.huJ != null) {
                c.this.huJ.z(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aZ(int i, String str) {
            if (c.this.huJ != null) {
                c.this.huJ.o(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.huN != null) {
                c.this.huN.a(aVar.aIs, aVar != null ? aVar.aIt : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void ba(int i, String str) {
            if (c.this.huN != null) {
                c.this.huN.j(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.huN != null) {
                c.this.huN.b(z ? 100 : 101, aVar != null ? aVar.aIt : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bb(int i, String str) {
            if (c.this.huN != null) {
                c.this.huN.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void l(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.huP != null && i > 0) {
                c.this.huP.ea(i);
            }
            if (c.this.huL != null) {
                c.this.huL.y(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bc(int i, String str) {
            if (c.this.huL != null) {
                c.this.huL.k(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void k(boolean z, long j) {
            if (c.this.huS != null) {
                c.this.huS.k(z, j);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bd(int i, String str) {
            if (c.this.huS != null) {
                c.this.huS.k(false, 0L);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.huO != null) {
                c.this.huO.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void be(int i, String str) {
            if (c.this.huO != null) {
                c.this.huO.i(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.huM != null) {
                c.this.huM.a(aVar.DE(), aVar != null ? aVar.aIt : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bf(int i, String str) {
            if (c.this.huM != null) {
                c.this.huM.n(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.huM != null) {
                c.this.huM.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bg(int i, String str) {
            if (c.this.huM != null) {
                c.this.huM.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void p(boolean z, String str) {
            if (c.this.huQ != null) {
                c.this.huQ.d(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.huK != null) {
                c.this.huK.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void l(int i, String str) {
            if (c.this.huK != null) {
                c.this.huK.l(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(int i, bc bcVar, bg bgVar, bg bgVar2) {
            c.this.a(i, bcVar, bgVar, bgVar2);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void q(boolean z, String str) {
            if (c.this.huR != null) {
                c.this.huR.c(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public boolean cfx() {
            return c.this.huU;
        }
    };
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.huG = new com.baidu.tieba.ala.liveroom.challenge.b.b(tbPageContext, tbPageContext.getUniqueId());
        this.huG.a(this.huV);
        this.huF = new ArrayList();
    }

    @Override // com.baidu.live.challenge.i
    public void h(long j, long j2) {
        this.huG.h(j, j2);
    }

    @Override // com.baidu.live.challenge.i
    public void setIsHost(boolean z) {
        if (this.huG != null) {
            this.huG.setIsHost(z);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void DK() {
        this.huU = false;
    }

    @Override // com.baidu.live.challenge.i
    public void a(az azVar) {
        this.huU = false;
        if (azVar != null) {
            AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage = new AlaGetChallengeInfoResponseMessage();
            alaGetChallengeInfoResponseMessage.a(azVar.aQv);
            alaGetChallengeInfoResponseMessage.a(azVar.aQw);
            alaGetChallengeInfoResponseMessage.b(azVar.aQx);
            MessageManager.getInstance().dispatchResponsedMessage(alaGetChallengeInfoResponseMessage);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void c(x xVar) {
        if (xVar != null && xVar.mLiveInfo != null && !this.huU) {
            this.huG.fx(xVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void DL() {
        if (this.huG != null) {
            this.huG.cgg();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void DM() {
        if (this.huG != null) {
            this.huG.cgh();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !DS()) {
            this.huG.fx(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void dZ(int i) {
        if (this.huP != null) {
            this.huP.ea(i);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void DV() {
        if (this.huG != null) {
            this.huG.DV();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(long j, long j2, long j3, int i, String str) {
        if (this.huG != null) {
            this.huG.a(j, j2, j3, i, str);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void DN() {
        this.huG.DN();
    }

    @Override // com.baidu.live.challenge.i
    public void gh(String str) {
        this.huG.Il(str);
    }

    @Override // com.baidu.live.challenge.i
    public void y(int i, int i2) {
        this.huG.y(i, i2);
    }

    @Override // com.baidu.live.challenge.i
    public void g(int i, int i2, String str) {
        this.huG.g(i, i2, str);
    }

    @Override // com.baidu.live.challenge.i
    public void gi(String str) {
        this.huG.gi(str);
    }

    @Override // com.baidu.live.challenge.i
    public void aG(long j) {
        this.huG.aG(j);
    }

    @Override // com.baidu.live.challenge.i
    public void aH(long j) {
        this.huG.aH(j);
    }

    @Override // com.baidu.live.challenge.i
    public void aI(long j) {
        this.huG.aI(j);
    }

    @Override // com.baidu.live.challenge.i
    public void aJ(long j) {
        this.huG.aJ(j);
    }

    @Override // com.baidu.live.challenge.i
    public void DO() {
        this.huG.DO();
    }

    @Override // com.baidu.live.challenge.i
    public void DP() {
        this.huG.DP();
    }

    @Override // com.baidu.live.challenge.i
    public void DQ() {
        this.huG.DQ();
    }

    @Override // com.baidu.live.challenge.i
    public void DT() {
        this.huG.DT();
    }

    @Override // com.baidu.live.challenge.i
    public long DU() {
        return this.huG.DU();
    }

    @Override // com.baidu.live.challenge.i
    public ChallenfeInfoData.ChallengeStatus DR() {
        return this.huG.DR();
    }

    @Override // com.baidu.live.challenge.i
    public boolean DS() {
        return this.huG.DS();
    }

    @Override // com.baidu.live.challenge.i
    public void bs(boolean z) {
        this.huG.bs(z);
    }

    private void cfw() {
        if (this.huF != null) {
            this.huF.clear();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void DC() {
        this.huU = true;
        if (this.huG != null) {
            this.huG.cgc();
        }
        cfw();
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        if (this.huG != null) {
            this.huG.onDestroy();
        }
        cfw();
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.m mVar) {
        this.huH = mVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.InterfaceC0174i interfaceC0174i) {
        this.huI = interfaceC0174i;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.l lVar) {
        this.huJ = lVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.h hVar) {
        this.huK = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.g gVar) {
        this.huL = gVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.k kVar) {
        this.huM = kVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.e eVar) {
        this.huN = eVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.a aVar) {
        this.huO = aVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.b bVar) {
        this.huP = bVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.n nVar) {
        this.huQ = nVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.d dVar) {
        this.huR = dVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.f fVar) {
        this.huG.b(fVar);
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.j jVar) {
        this.huS = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.c cVar) {
        if (cVar != null && !this.huF.contains(cVar)) {
            this.huF.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void gg(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.huG.DO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, bc bcVar, bg bgVar, bg bgVar2) {
        if (!ListUtils.isEmpty(this.huF)) {
            if (i == 4) {
                if (this.huT == this.huG.DU()) {
                    BdLog.e("CHALLENGE_TAG challenge is Over but challenge id same?? ||Net Challenge id=" + this.huG.DU() + "||Last Challenge id=" + this.huT);
                    return;
                }
                this.huT = this.huG.DU();
            }
            for (i.c cVar : this.huF) {
                if (cVar != null) {
                    switch (i) {
                        case 2:
                            cVar.b(bcVar, bgVar, bgVar2);
                            continue;
                        case 3:
                            cVar.c(bcVar, bgVar, bgVar2);
                            continue;
                        case 4:
                            cVar.d(bcVar, bgVar, bgVar2);
                            continue;
                        case 5:
                            cVar.e(bcVar, bgVar, bgVar2);
                            continue;
                    }
                }
            }
        }
    }
}
