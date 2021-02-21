package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.i;
import com.baidu.live.data.AlaPersonChallengeData;
import com.baidu.live.data.ab;
import com.baidu.live.data.bd;
import com.baidu.live.data.bg;
import com.baidu.live.data.bk;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.challenge.b.b;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetChallengeInfoResponseMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class c implements i {
    private i.InterfaceC0166i huA;
    private i.l huB;
    private i.h huC;
    private i.g huD;
    private i.k huE;
    private i.e huF;
    private i.a huG;
    private i.b huH;
    private i.n huI;
    private i.d huJ;
    private i.j huK;
    private long huL = 0;
    private boolean huM = false;
    private b.a huN = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void AM() {
            if (c.this.huz != null) {
                c.this.huz.AM();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void t(int i, String str) {
            if (c.this.huz != null) {
                c.this.huz.t(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.huA != null) {
                c.this.huA.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void q(int i, String str) {
            if (c.this.huA != null) {
                c.this.huA.q(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void cC(List<com.baidu.live.challenge.d> list) {
            if (c.this.huB != null) {
                c.this.huB.z(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bf(int i, String str) {
            if (c.this.huB != null) {
                c.this.huB.s(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.huF != null) {
                c.this.huF.a(aVar.aFs, aVar != null ? aVar.aFt : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bg(int i, String str) {
            if (c.this.huF != null) {
                c.this.huF.n(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.huF != null) {
                c.this.huF.b(z ? 100 : 101, aVar != null ? aVar.aFt : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bh(int i, String str) {
            if (c.this.huF != null) {
                c.this.huF.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void m(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.huH != null && i > 0) {
                c.this.huH.cx(i);
            }
            if (c.this.huD != null) {
                c.this.huD.y(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bi(int i, String str) {
            if (c.this.huD != null) {
                c.this.huD.o(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void k(boolean z, long j) {
            if (c.this.huK != null) {
                c.this.huK.k(z, j);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bj(int i, String str) {
            if (c.this.huK != null) {
                c.this.huK.k(false, 0L);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.huG != null) {
                c.this.huG.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bk(int i, String str) {
            if (c.this.huG != null) {
                c.this.huG.m(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.huE != null) {
                c.this.huE.a(aVar.At(), aVar != null ? aVar.aFt : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bl(int i, String str) {
            if (c.this.huE != null) {
                c.this.huE.r(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.huE != null) {
                c.this.huE.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bm(int i, String str) {
            if (c.this.huE != null) {
                c.this.huE.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void w(boolean z, String str) {
            if (c.this.huI != null) {
                c.this.huI.h(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.huC != null) {
                c.this.huC.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void p(int i, String str) {
            if (c.this.huC != null) {
                c.this.huC.p(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(int i, bg bgVar, bk bkVar, bk bkVar2) {
            c.this.a(i, bgVar, bkVar, bkVar2);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void x(boolean z, String str) {
            if (c.this.huJ != null) {
                c.this.huJ.g(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public boolean ccI() {
            return c.this.huM;
        }
    };
    private List<i.c> hux;
    private com.baidu.tieba.ala.liveroom.challenge.b.b huy;
    private i.m huz;
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.huy = new com.baidu.tieba.ala.liveroom.challenge.b.b(tbPageContext, tbPageContext.getUniqueId());
        this.huy.a(this.huN);
        this.hux = new ArrayList();
    }

    @Override // com.baidu.live.challenge.i
    public void h(long j, long j2) {
        this.huy.h(j, j2);
    }

    @Override // com.baidu.live.challenge.i
    public void setIsHost(boolean z) {
        if (this.huy != null) {
            this.huy.setIsHost(z);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Az() {
        this.huM = false;
    }

    @Override // com.baidu.live.challenge.i
    public void a(bd bdVar) {
        this.huM = false;
        if (bdVar != null) {
            AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage = new AlaGetChallengeInfoResponseMessage();
            alaGetChallengeInfoResponseMessage.a(bdVar.aOF);
            alaGetChallengeInfoResponseMessage.a(bdVar.aOG);
            alaGetChallengeInfoResponseMessage.b(bdVar.aOH);
            MessageManager.getInstance().dispatchResponsedMessage(alaGetChallengeInfoResponseMessage);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void c(ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null && !this.huM) {
            this.huy.fC(abVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void AA() {
        if (this.huy != null) {
            this.huy.cdr();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void AB() {
        if (this.huy != null) {
            this.huy.cds();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !AH()) {
            this.huy.fC(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void cw(int i) {
        if (this.huH != null) {
            this.huH.cx(i);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void AK() {
        if (this.huy != null) {
            this.huy.AK();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(long j, long j2, long j3, int i, String str) {
        if (this.huy != null) {
            this.huy.a(j, j2, j3, i, str);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void AC() {
        this.huy.AC();
    }

    @Override // com.baidu.live.challenge.i
    public void fp(String str) {
        this.huy.HE(str);
    }

    @Override // com.baidu.live.challenge.i
    public void y(int i, int i2) {
        this.huy.y(i, i2);
    }

    @Override // com.baidu.live.challenge.i
    public void g(int i, int i2, String str) {
        this.huy.g(i, i2, str);
    }

    @Override // com.baidu.live.challenge.i
    public void fq(String str) {
        this.huy.fq(str);
    }

    @Override // com.baidu.live.challenge.i
    public void aI(long j) {
        this.huy.aI(j);
    }

    @Override // com.baidu.live.challenge.i
    public void aJ(long j) {
        this.huy.aJ(j);
    }

    @Override // com.baidu.live.challenge.i
    public void aK(long j) {
        this.huy.aK(j);
    }

    @Override // com.baidu.live.challenge.i
    public void aL(long j) {
        this.huy.aL(j);
    }

    @Override // com.baidu.live.challenge.i
    public void AD() {
        this.huy.AD();
    }

    @Override // com.baidu.live.challenge.i
    public void AE() {
        this.huy.AE();
    }

    @Override // com.baidu.live.challenge.i
    public void AF() {
        this.huy.AF();
    }

    @Override // com.baidu.live.challenge.i
    public void AI() {
        this.huy.AI();
    }

    @Override // com.baidu.live.challenge.i
    public long AJ() {
        return this.huy.AJ();
    }

    @Override // com.baidu.live.challenge.i
    public ChallenfeInfoData.ChallengeStatus AG() {
        return this.huy.AG();
    }

    @Override // com.baidu.live.challenge.i
    public boolean AH() {
        return this.huy.AH();
    }

    @Override // com.baidu.live.challenge.i
    public void bq(boolean z) {
        this.huy.bq(z);
    }

    private void ccH() {
        if (this.hux != null) {
            this.hux.clear();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Ar() {
        this.huM = true;
        if (this.huy != null) {
            this.huy.cdn();
        }
        ccH();
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        if (this.huy != null) {
            this.huy.onDestroy();
        }
        ccH();
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.m mVar) {
        this.huz = mVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.InterfaceC0166i interfaceC0166i) {
        this.huA = interfaceC0166i;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.l lVar) {
        this.huB = lVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.h hVar) {
        this.huC = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.g gVar) {
        this.huD = gVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.k kVar) {
        this.huE = kVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.e eVar) {
        this.huF = eVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.a aVar) {
        this.huG = aVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.b bVar) {
        this.huH = bVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.n nVar) {
        this.huI = nVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.d dVar) {
        this.huJ = dVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.f fVar) {
        this.huy.b(fVar);
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.j jVar) {
        this.huK = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.c cVar) {
        if (cVar != null && !this.hux.contains(cVar)) {
            this.hux.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void fo(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.huy.AD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, bg bgVar, bk bkVar, bk bkVar2) {
        if (!ListUtils.isEmpty(this.hux)) {
            if (i == 4) {
                if (this.huL == this.huy.AJ()) {
                    BdLog.e("CHALLENGE_TAG challenge is Over but challenge id same?? ||Net Challenge id=" + this.huy.AJ() + "||Last Challenge id=" + this.huL);
                    return;
                }
                this.huL = this.huy.AJ();
            }
            for (i.c cVar : this.hux) {
                if (cVar != null) {
                    switch (i) {
                        case 2:
                            cVar.b(bgVar, bkVar, bkVar2);
                            continue;
                        case 3:
                            cVar.c(bgVar, bkVar, bkVar2);
                            continue;
                        case 4:
                            cVar.d(bgVar, bkVar, bkVar2);
                            continue;
                        case 5:
                            cVar.e(bgVar, bkVar, bkVar2);
                            continue;
                    }
                }
            }
        }
    }
}
