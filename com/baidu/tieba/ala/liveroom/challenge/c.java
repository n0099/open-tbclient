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
    private List<i.c> gpL;
    private com.baidu.tieba.ala.liveroom.challenge.b.b gpM;
    private i.l gpN;
    private i.InterfaceC0166i gpO;
    private i.k gpP;
    private i.h gpQ;
    private i.g gpR;
    private i.j gpS;
    private i.e gpT;
    private i.a gpU;
    private i.b gpV;
    private i.m gpW;
    private i.d gpX;
    private long gpY = 0;
    private b.a gpZ = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void BV() {
            if (c.this.gpN != null) {
                c.this.gpN.BV();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void n(int i, String str) {
            if (c.this.gpN != null) {
                c.this.gpN.n(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.gpO != null) {
                c.this.gpO.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void k(int i, String str) {
            if (c.this.gpO != null) {
                c.this.gpO.k(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bW(List<com.baidu.live.challenge.d> list) {
            if (c.this.gpP != null) {
                c.this.gpP.w(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aK(int i, String str) {
            if (c.this.gpP != null) {
                c.this.gpP.m(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.gpT != null) {
                c.this.gpT.a(aVar.aCl, aVar != null ? aVar.aCm : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aL(int i, String str) {
            if (c.this.gpT != null) {
                c.this.gpT.h(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gpT != null) {
                c.this.gpT.b(z ? 100 : 101, aVar != null ? aVar.aCm : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aM(int i, String str) {
            if (c.this.gpT != null) {
                c.this.gpT.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void l(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.gpV != null && i > 0) {
                c.this.gpV.dF(i);
            }
            if (c.this.gpR != null) {
                c.this.gpR.v(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aN(int i, String str) {
            if (c.this.gpR != null) {
                c.this.gpR.i(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gpU != null) {
                c.this.gpU.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aO(int i, String str) {
            if (c.this.gpU != null) {
                c.this.gpU.g(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.gpS != null) {
                c.this.gpS.a(aVar.BD(), aVar != null ? aVar.aCm : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aP(int i, String str) {
            if (c.this.gpS != null) {
                c.this.gpS.l(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gpS != null) {
                c.this.gpS.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aQ(int i, String str) {
            if (c.this.gpS != null) {
                c.this.gpS.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void n(boolean z, String str) {
            if (c.this.gpW != null) {
                c.this.gpW.d(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.gpQ != null) {
                c.this.gpQ.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void j(int i, String str) {
            if (c.this.gpQ != null) {
                c.this.gpQ.j(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(int i, ap apVar, at atVar, at atVar2) {
            c.this.a(i, apVar, atVar, atVar2);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void o(boolean z, String str) {
            if (c.this.gpX != null) {
                c.this.gpX.c(z, str);
            }
        }
    };
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gpM = new com.baidu.tieba.ala.liveroom.challenge.b.b(tbPageContext, tbPageContext.getUniqueId());
        this.gpM.a(this.gpZ);
        this.gpL = new ArrayList();
    }

    @Override // com.baidu.live.challenge.i
    public void e(long j, long j2) {
        this.gpM.e(j, j2);
    }

    @Override // com.baidu.live.challenge.i
    public void setIsHost(boolean z) {
        if (this.gpM != null) {
            this.gpM.setIsHost(z);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(am amVar) {
        if (amVar != null) {
            AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage = new AlaGetChallengeInfoResponseMessage();
            alaGetChallengeInfoResponseMessage.a(amVar.aIi);
            alaGetChallengeInfoResponseMessage.a(amVar.aIj);
            alaGetChallengeInfoResponseMessage.b(amVar.aIk);
            MessageManager.getInstance().dispatchResponsedMessage(alaGetChallengeInfoResponseMessage);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void c(r rVar) {
        if (rVar != null && rVar.mLiveInfo != null) {
            this.gpM.ed(rVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void BJ() {
        if (this.gpM != null) {
            this.gpM.bPN();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void BK() {
        if (this.gpM != null) {
            this.gpM.bPO();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !BQ()) {
            this.gpM.ed(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void dE(int i) {
        if (this.gpV != null) {
            this.gpV.dF(i);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void BT() {
        if (this.gpM != null) {
            this.gpM.BT();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(long j, long j2, long j3, int i, String str) {
        if (this.gpM != null) {
            this.gpM.a(j, j2, j3, i, str);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void BL() {
        this.gpM.BL();
    }

    @Override // com.baidu.live.challenge.i
    public void w(int i, int i2) {
        this.gpM.w(i, i2);
    }

    @Override // com.baidu.live.challenge.i
    public void e(int i, int i2, String str) {
        this.gpM.e(i, i2, str);
    }

    @Override // com.baidu.live.challenge.i
    public void fJ(String str) {
        this.gpM.fJ(str);
    }

    @Override // com.baidu.live.challenge.i
    public void W(long j) {
        this.gpM.W(j);
    }

    @Override // com.baidu.live.challenge.i
    public void X(long j) {
        this.gpM.X(j);
    }

    @Override // com.baidu.live.challenge.i
    public void Y(long j) {
        this.gpM.Y(j);
    }

    @Override // com.baidu.live.challenge.i
    public void Z(long j) {
        this.gpM.Z(j);
    }

    @Override // com.baidu.live.challenge.i
    public void BM() {
        this.gpM.BM();
    }

    @Override // com.baidu.live.challenge.i
    public void BN() {
        this.gpM.BN();
    }

    @Override // com.baidu.live.challenge.i
    public void BO() {
        this.gpM.BO();
    }

    @Override // com.baidu.live.challenge.i
    public void BR() {
        this.gpM.BR();
    }

    @Override // com.baidu.live.challenge.i
    public long BS() {
        return this.gpM.BS();
    }

    @Override // com.baidu.live.challenge.i
    public ChallenfeInfoData.ChallengeStatus BP() {
        return this.gpM.BP();
    }

    @Override // com.baidu.live.challenge.i
    public boolean BQ() {
        return this.gpM.BQ();
    }

    @Override // com.baidu.live.challenge.i
    public void bf(boolean z) {
        this.gpM.bf(z);
    }

    private void bPk() {
        if (this.gpL != null) {
            this.gpL.clear();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void BB() {
        if (this.gpM != null) {
            this.gpM.bPJ();
        }
        bPk();
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        if (this.gpM != null) {
            this.gpM.onDestroy();
        }
        bPk();
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.l lVar) {
        this.gpN = lVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.InterfaceC0166i interfaceC0166i) {
        this.gpO = interfaceC0166i;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.k kVar) {
        this.gpP = kVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.h hVar) {
        this.gpQ = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.g gVar) {
        this.gpR = gVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.j jVar) {
        this.gpS = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.e eVar) {
        this.gpT = eVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.a aVar) {
        this.gpU = aVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.b bVar) {
        this.gpV = bVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.m mVar) {
        this.gpW = mVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.d dVar) {
        this.gpX = dVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.f fVar) {
        this.gpM.b(fVar);
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.c cVar) {
        if (cVar != null && !this.gpL.contains(cVar)) {
            this.gpL.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void fI(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.gpM.BM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ap apVar, at atVar, at atVar2) {
        if (!ListUtils.isEmpty(this.gpL)) {
            if (i == 4) {
                if (this.gpY == this.gpM.BS()) {
                    BdLog.e("CHALLENGE_TAG challenge is Over but challenge id same?? ||Net Challenge id=" + this.gpM.BS() + "||Last Challenge id=" + this.gpY);
                    return;
                }
                this.gpY = this.gpM.BS();
            }
            for (i.c cVar : this.gpL) {
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
