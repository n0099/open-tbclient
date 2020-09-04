package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.i;
import com.baidu.live.data.AlaPersonChallengeData;
import com.baidu.live.data.am;
import com.baidu.live.data.ap;
import com.baidu.live.data.at;
import com.baidu.live.data.r;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.challenge.b.b;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetChallengeInfoResponseMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c implements i {
    private List<i.c> gpP;
    private com.baidu.tieba.ala.liveroom.challenge.b.b gpQ;
    private i.l gpR;
    private i.InterfaceC0166i gpS;
    private i.k gpT;
    private i.h gpU;
    private i.g gpV;
    private i.j gpW;
    private i.e gpX;
    private i.a gpY;
    private i.b gpZ;
    private i.m gqa;
    private i.d gqb;
    private long gqc = 0;
    private b.a gqd = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void BV() {
            if (c.this.gpR != null) {
                c.this.gpR.BV();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void n(int i, String str) {
            if (c.this.gpR != null) {
                c.this.gpR.n(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.gpS != null) {
                c.this.gpS.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void k(int i, String str) {
            if (c.this.gpS != null) {
                c.this.gpS.k(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bW(List<com.baidu.live.challenge.d> list) {
            if (c.this.gpT != null) {
                c.this.gpT.w(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aJ(int i, String str) {
            if (c.this.gpT != null) {
                c.this.gpT.m(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.gpX != null) {
                c.this.gpX.a(aVar.aCn, aVar != null ? aVar.aCo : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aK(int i, String str) {
            if (c.this.gpX != null) {
                c.this.gpX.h(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gpX != null) {
                c.this.gpX.b(z ? 100 : 101, aVar != null ? aVar.aCo : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aL(int i, String str) {
            if (c.this.gpX != null) {
                c.this.gpX.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void l(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.gpZ != null && i > 0) {
                c.this.gpZ.dF(i);
            }
            if (c.this.gpV != null) {
                c.this.gpV.v(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aM(int i, String str) {
            if (c.this.gpV != null) {
                c.this.gpV.i(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gpY != null) {
                c.this.gpY.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aN(int i, String str) {
            if (c.this.gpY != null) {
                c.this.gpY.g(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.gpW != null) {
                c.this.gpW.a(aVar.BD(), aVar != null ? aVar.aCo : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aO(int i, String str) {
            if (c.this.gpW != null) {
                c.this.gpW.l(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gpW != null) {
                c.this.gpW.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aP(int i, String str) {
            if (c.this.gpW != null) {
                c.this.gpW.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void n(boolean z, String str) {
            if (c.this.gqa != null) {
                c.this.gqa.d(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.gpU != null) {
                c.this.gpU.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void j(int i, String str) {
            if (c.this.gpU != null) {
                c.this.gpU.j(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(int i, ap apVar, at atVar, at atVar2) {
            c.this.a(i, apVar, atVar, atVar2);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void o(boolean z, String str) {
            if (c.this.gqb != null) {
                c.this.gqb.c(z, str);
            }
        }
    };
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gpQ = new com.baidu.tieba.ala.liveroom.challenge.b.b(tbPageContext, tbPageContext.getUniqueId());
        this.gpQ.a(this.gqd);
        this.gpP = new ArrayList();
    }

    @Override // com.baidu.live.challenge.i
    public void e(long j, long j2) {
        this.gpQ.e(j, j2);
    }

    @Override // com.baidu.live.challenge.i
    public void setIsHost(boolean z) {
        if (this.gpQ != null) {
            this.gpQ.setIsHost(z);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(am amVar) {
        if (amVar != null) {
            AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage = new AlaGetChallengeInfoResponseMessage();
            alaGetChallengeInfoResponseMessage.a(amVar.aIk);
            alaGetChallengeInfoResponseMessage.a(amVar.aIl);
            alaGetChallengeInfoResponseMessage.b(amVar.aIm);
            MessageManager.getInstance().dispatchResponsedMessage(alaGetChallengeInfoResponseMessage);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void c(r rVar) {
        if (rVar != null && rVar.mLiveInfo != null) {
            this.gpQ.ed(rVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void BJ() {
        if (this.gpQ != null) {
            this.gpQ.bPO();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void BK() {
        if (this.gpQ != null) {
            this.gpQ.bPP();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !BQ()) {
            this.gpQ.ed(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void dE(int i) {
        if (this.gpZ != null) {
            this.gpZ.dF(i);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void BT() {
        if (this.gpQ != null) {
            this.gpQ.BT();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(long j, long j2, long j3, int i, String str) {
        if (this.gpQ != null) {
            this.gpQ.a(j, j2, j3, i, str);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void BL() {
        this.gpQ.BL();
    }

    @Override // com.baidu.live.challenge.i
    public void w(int i, int i2) {
        this.gpQ.w(i, i2);
    }

    @Override // com.baidu.live.challenge.i
    public void e(int i, int i2, String str) {
        this.gpQ.e(i, i2, str);
    }

    @Override // com.baidu.live.challenge.i
    public void fK(String str) {
        this.gpQ.fK(str);
    }

    @Override // com.baidu.live.challenge.i
    public void W(long j) {
        this.gpQ.W(j);
    }

    @Override // com.baidu.live.challenge.i
    public void X(long j) {
        this.gpQ.X(j);
    }

    @Override // com.baidu.live.challenge.i
    public void Y(long j) {
        this.gpQ.Y(j);
    }

    @Override // com.baidu.live.challenge.i
    public void Z(long j) {
        this.gpQ.Z(j);
    }

    @Override // com.baidu.live.challenge.i
    public void BM() {
        this.gpQ.BM();
    }

    @Override // com.baidu.live.challenge.i
    public void BN() {
        this.gpQ.BN();
    }

    @Override // com.baidu.live.challenge.i
    public void BO() {
        this.gpQ.BO();
    }

    @Override // com.baidu.live.challenge.i
    public void BR() {
        this.gpQ.BR();
    }

    @Override // com.baidu.live.challenge.i
    public long BS() {
        return this.gpQ.BS();
    }

    @Override // com.baidu.live.challenge.i
    public ChallenfeInfoData.ChallengeStatus BP() {
        return this.gpQ.BP();
    }

    @Override // com.baidu.live.challenge.i
    public boolean BQ() {
        return this.gpQ.BQ();
    }

    @Override // com.baidu.live.challenge.i
    public void bf(boolean z) {
        this.gpQ.bf(z);
    }

    private void bPl() {
        if (this.gpP != null) {
            this.gpP.clear();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void BB() {
        if (this.gpQ != null) {
            this.gpQ.bPK();
        }
        bPl();
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        if (this.gpQ != null) {
            this.gpQ.onDestroy();
        }
        bPl();
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.l lVar) {
        this.gpR = lVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.InterfaceC0166i interfaceC0166i) {
        this.gpS = interfaceC0166i;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.k kVar) {
        this.gpT = kVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.h hVar) {
        this.gpU = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.g gVar) {
        this.gpV = gVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.j jVar) {
        this.gpW = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.e eVar) {
        this.gpX = eVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.a aVar) {
        this.gpY = aVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.b bVar) {
        this.gpZ = bVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.m mVar) {
        this.gqa = mVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.d dVar) {
        this.gqb = dVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.f fVar) {
        this.gpQ.b(fVar);
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.c cVar) {
        if (cVar != null && !this.gpP.contains(cVar)) {
            this.gpP.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void fJ(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.gpQ.BM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ap apVar, at atVar, at atVar2) {
        if (!ListUtils.isEmpty(this.gpP)) {
            if (i == 4) {
                if (this.gqc == this.gpQ.BS()) {
                    BdLog.e("CHALLENGE_TAG challenge is Over but challenge id same?? ||Net Challenge id=" + this.gpQ.BS() + "||Last Challenge id=" + this.gqc);
                    return;
                }
                this.gqc = this.gpQ.BS();
            }
            for (i.c cVar : this.gpP) {
                if (cVar != null) {
                    switch (i) {
                        case 2:
                            cVar.b(apVar, atVar, atVar2);
                            continue;
                        case 3:
                            cVar.c(apVar, atVar, atVar2);
                            continue;
                        case 4:
                            cVar.d(apVar, atVar, atVar2);
                            continue;
                        case 5:
                            cVar.e(apVar, atVar, atVar2);
                            continue;
                    }
                }
            }
        }
    }
}
