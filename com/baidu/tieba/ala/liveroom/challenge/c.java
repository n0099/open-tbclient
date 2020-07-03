package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.i;
import com.baidu.live.data.AlaPersonChallengeData;
import com.baidu.live.data.aj;
import com.baidu.live.data.am;
import com.baidu.live.data.aq;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.challenge.b.b;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetChallengeInfoResponseMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements i {
    private i.h fYA;
    private i.g fYB;
    private i.j fYC;
    private i.e fYD;
    private i.a fYE;
    private i.b fYF;
    private i.m fYG;
    private i.d fYH;
    private long fYI = 0;
    private b.a fYJ = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void wb() {
            if (c.this.fYx != null) {
                c.this.fYx.wb();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void n(int i, String str) {
            if (c.this.fYx != null) {
                c.this.fYx.n(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.fYy != null) {
                c.this.fYy.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void k(int i, String str) {
            if (c.this.fYy != null) {
                c.this.fYy.k(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bR(List<com.baidu.live.challenge.d> list) {
            if (c.this.fYz != null) {
                c.this.fYz.t(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aK(int i, String str) {
            if (c.this.fYz != null) {
                c.this.fYz.m(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.fYD != null) {
                c.this.fYD.a(aVar.awe, aVar != null ? aVar.awf : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aL(int i, String str) {
            if (c.this.fYD != null) {
                c.this.fYD.h(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.fYD != null) {
                c.this.fYD.b(z ? 100 : 101, aVar != null ? aVar.awf : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aM(int i, String str) {
            if (c.this.fYD != null) {
                c.this.fYD.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void l(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.fYF != null && i > 0) {
                c.this.fYF.bN(i);
            }
            if (c.this.fYB != null) {
                c.this.fYB.s(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aN(int i, String str) {
            if (c.this.fYB != null) {
                c.this.fYB.i(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.fYE != null) {
                c.this.fYE.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aO(int i, String str) {
            if (c.this.fYE != null) {
                c.this.fYE.g(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.fYC != null) {
                c.this.fYC.a(aVar.vJ(), aVar != null ? aVar.awf : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aP(int i, String str) {
            if (c.this.fYC != null) {
                c.this.fYC.l(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.fYC != null) {
                c.this.fYC.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aQ(int i, String str) {
            if (c.this.fYC != null) {
                c.this.fYC.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void m(boolean z, String str) {
            if (c.this.fYG != null) {
                c.this.fYG.d(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.fYA != null) {
                c.this.fYA.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void j(int i, String str) {
            if (c.this.fYA != null) {
                c.this.fYA.j(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(int i, am amVar, aq aqVar, aq aqVar2) {
            c.this.a(i, amVar, aqVar, aqVar2);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void n(boolean z, String str) {
            if (c.this.fYH != null) {
                c.this.fYH.c(z, str);
            }
        }
    };
    private List<i.c> fYv;
    private com.baidu.tieba.ala.liveroom.challenge.b.b fYw;
    private i.l fYx;
    private i.InterfaceC0159i fYy;
    private i.k fYz;
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fYw = new com.baidu.tieba.ala.liveroom.challenge.b.b(tbPageContext, tbPageContext.getUniqueId());
        this.fYw.a(this.fYJ);
        this.fYv = new ArrayList();
    }

    @Override // com.baidu.live.challenge.i
    public void e(long j, long j2) {
        this.fYw.e(j, j2);
    }

    @Override // com.baidu.live.challenge.i
    public void setIsHost(boolean z) {
        if (this.fYw != null) {
            this.fYw.setIsHost(z);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(aj ajVar) {
        if (ajVar != null) {
            AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage = new AlaGetChallengeInfoResponseMessage();
            alaGetChallengeInfoResponseMessage.a(ajVar.aBD);
            alaGetChallengeInfoResponseMessage.a(ajVar.aBE);
            alaGetChallengeInfoResponseMessage.b(ajVar.aBF);
            MessageManager.getInstance().dispatchResponsedMessage(alaGetChallengeInfoResponseMessage);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void c(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null) {
            this.fYw.dE(qVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void vP() {
        if (this.fYw != null) {
            this.fYw.bCW();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void vQ() {
        if (this.fYw != null) {
            this.fYw.bCX();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !vW()) {
            this.fYw.dE(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void bM(int i) {
        if (this.fYF != null) {
            this.fYF.bN(i);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void vZ() {
        if (this.fYw != null) {
            this.fYw.vZ();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(long j, long j2, long j3, int i, String str) {
        if (this.fYw != null) {
            this.fYw.a(j, j2, j3, i, str);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void vR() {
        this.fYw.vR();
    }

    @Override // com.baidu.live.challenge.i
    public void t(int i, int i2) {
        this.fYw.t(i, i2);
    }

    @Override // com.baidu.live.challenge.i
    public void e(int i, int i2, String str) {
        this.fYw.e(i, i2, str);
    }

    @Override // com.baidu.live.challenge.i
    public void er(String str) {
        this.fYw.er(str);
    }

    @Override // com.baidu.live.challenge.i
    public void V(long j) {
        this.fYw.V(j);
    }

    @Override // com.baidu.live.challenge.i
    public void W(long j) {
        this.fYw.W(j);
    }

    @Override // com.baidu.live.challenge.i
    public void X(long j) {
        this.fYw.X(j);
    }

    @Override // com.baidu.live.challenge.i
    public void Y(long j) {
        this.fYw.Y(j);
    }

    @Override // com.baidu.live.challenge.i
    public void vS() {
        this.fYw.vS();
    }

    @Override // com.baidu.live.challenge.i
    public void vT() {
        this.fYw.vT();
    }

    @Override // com.baidu.live.challenge.i
    public void vU() {
        this.fYw.vU();
    }

    @Override // com.baidu.live.challenge.i
    public void vX() {
        this.fYw.vX();
    }

    @Override // com.baidu.live.challenge.i
    public long vY() {
        return this.fYw.vY();
    }

    @Override // com.baidu.live.challenge.i
    public ChallenfeInfoData.ChallengeStatus vV() {
        return this.fYw.vV();
    }

    @Override // com.baidu.live.challenge.i
    public boolean vW() {
        return this.fYw.vW();
    }

    @Override // com.baidu.live.challenge.i
    public void aX(boolean z) {
        this.fYw.aX(z);
    }

    private void bCt() {
        if (this.fYv != null) {
            this.fYv.clear();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void vH() {
        if (this.fYw != null) {
            this.fYw.bCS();
        }
        bCt();
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        if (this.fYw != null) {
            this.fYw.onDestroy();
        }
        bCt();
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.l lVar) {
        this.fYx = lVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.InterfaceC0159i interfaceC0159i) {
        this.fYy = interfaceC0159i;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.k kVar) {
        this.fYz = kVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.h hVar) {
        this.fYA = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.g gVar) {
        this.fYB = gVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.j jVar) {
        this.fYC = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.e eVar) {
        this.fYD = eVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.a aVar) {
        this.fYE = aVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.b bVar) {
        this.fYF = bVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.m mVar) {
        this.fYG = mVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.d dVar) {
        this.fYH = dVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.f fVar) {
        this.fYw.b(fVar);
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.c cVar) {
        if (cVar != null && !this.fYv.contains(cVar)) {
            this.fYv.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void eq(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.fYw.vS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, am amVar, aq aqVar, aq aqVar2) {
        if (!ListUtils.isEmpty(this.fYv)) {
            if (i == 4) {
                if (this.fYI == this.fYw.vY()) {
                    BdLog.e("CHALLENGE_TAG challenge is Over but challenge id same?? ||Net Challenge id=" + this.fYw.vY() + "||Last Challenge id=" + this.fYI);
                    return;
                }
                this.fYI = this.fYw.vY();
            }
            for (i.c cVar : this.fYv) {
                if (cVar != null) {
                    switch (i) {
                        case 2:
                            cVar.b(amVar, aqVar, aqVar2);
                            continue;
                        case 3:
                            cVar.c(amVar, aqVar, aqVar2);
                            continue;
                        case 4:
                            cVar.d(amVar, aqVar, aqVar2);
                            continue;
                        case 5:
                            cVar.e(amVar, aqVar, aqVar2);
                            continue;
                    }
                }
            }
        }
    }
}
