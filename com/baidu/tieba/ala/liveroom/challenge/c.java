package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.i;
import com.baidu.live.data.AlaPersonChallengeData;
import com.baidu.live.data.ak;
import com.baidu.live.data.an;
import com.baidu.live.data.ar;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.challenge.b.b;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetChallengeInfoResponseMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements i {
    private List<i.c> gdC;
    private com.baidu.tieba.ala.liveroom.challenge.b.b gdD;
    private i.l gdE;
    private i.InterfaceC0158i gdF;
    private i.k gdG;
    private i.h gdH;
    private i.g gdI;
    private i.j gdJ;
    private i.e gdK;
    private i.a gdL;
    private i.b gdM;
    private i.m gdN;
    private i.d gdO;
    private long gdP = 0;
    private b.a gdQ = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void wx() {
            if (c.this.gdE != null) {
                c.this.gdE.wx();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void o(int i, String str) {
            if (c.this.gdE != null) {
                c.this.gdE.o(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.gdF != null) {
                c.this.gdF.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void l(int i, String str) {
            if (c.this.gdF != null) {
                c.this.gdF.l(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bV(List<com.baidu.live.challenge.d> list) {
            if (c.this.gdG != null) {
                c.this.gdG.v(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aM(int i, String str) {
            if (c.this.gdG != null) {
                c.this.gdG.n(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.gdK != null) {
                c.this.gdK.a(aVar.axj, aVar != null ? aVar.axk : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aN(int i, String str) {
            if (c.this.gdK != null) {
                c.this.gdK.i(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gdK != null) {
                c.this.gdK.b(z ? 100 : 101, aVar != null ? aVar.axk : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aO(int i, String str) {
            if (c.this.gdK != null) {
                c.this.gdK.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void l(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.gdM != null && i > 0) {
                c.this.gdM.bT(i);
            }
            if (c.this.gdI != null) {
                c.this.gdI.u(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aP(int i, String str) {
            if (c.this.gdI != null) {
                c.this.gdI.j(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gdL != null) {
                c.this.gdL.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aQ(int i, String str) {
            if (c.this.gdL != null) {
                c.this.gdL.h(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.gdJ != null) {
                c.this.gdJ.a(aVar.wf(), aVar != null ? aVar.axk : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aR(int i, String str) {
            if (c.this.gdJ != null) {
                c.this.gdJ.m(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gdJ != null) {
                c.this.gdJ.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aS(int i, String str) {
            if (c.this.gdJ != null) {
                c.this.gdJ.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void m(boolean z, String str) {
            if (c.this.gdN != null) {
                c.this.gdN.d(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.gdH != null) {
                c.this.gdH.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void k(int i, String str) {
            if (c.this.gdH != null) {
                c.this.gdH.k(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(int i, an anVar, ar arVar, ar arVar2) {
            c.this.a(i, anVar, arVar, arVar2);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void n(boolean z, String str) {
            if (c.this.gdO != null) {
                c.this.gdO.c(z, str);
            }
        }
    };
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gdD = new com.baidu.tieba.ala.liveroom.challenge.b.b(tbPageContext, tbPageContext.getUniqueId());
        this.gdD.a(this.gdQ);
        this.gdC = new ArrayList();
    }

    @Override // com.baidu.live.challenge.i
    public void e(long j, long j2) {
        this.gdD.e(j, j2);
    }

    @Override // com.baidu.live.challenge.i
    public void setIsHost(boolean z) {
        if (this.gdD != null) {
            this.gdD.setIsHost(z);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(ak akVar) {
        if (akVar != null) {
            AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage = new AlaGetChallengeInfoResponseMessage();
            alaGetChallengeInfoResponseMessage.a(akVar.aCY);
            alaGetChallengeInfoResponseMessage.a(akVar.aCZ);
            alaGetChallengeInfoResponseMessage.b(akVar.aDa);
            MessageManager.getInstance().dispatchResponsedMessage(alaGetChallengeInfoResponseMessage);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void c(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null) {
            this.gdD.dS(qVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void wl() {
        if (this.gdD != null) {
            this.gdD.bGi();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void wm() {
        if (this.gdD != null) {
            this.gdD.bGj();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !ws()) {
            this.gdD.dS(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void bS(int i) {
        if (this.gdM != null) {
            this.gdM.bT(i);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void wv() {
        if (this.gdD != null) {
            this.gdD.wv();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(long j, long j2, long j3, int i, String str) {
        if (this.gdD != null) {
            this.gdD.a(j, j2, j3, i, str);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void wn() {
        this.gdD.wn();
    }

    @Override // com.baidu.live.challenge.i
    public void t(int i, int i2) {
        this.gdD.t(i, i2);
    }

    @Override // com.baidu.live.challenge.i
    public void e(int i, int i2, String str) {
        this.gdD.e(i, i2, str);
    }

    @Override // com.baidu.live.challenge.i
    public void er(String str) {
        this.gdD.er(str);
    }

    @Override // com.baidu.live.challenge.i
    public void V(long j) {
        this.gdD.V(j);
    }

    @Override // com.baidu.live.challenge.i
    public void W(long j) {
        this.gdD.W(j);
    }

    @Override // com.baidu.live.challenge.i
    public void X(long j) {
        this.gdD.X(j);
    }

    @Override // com.baidu.live.challenge.i
    public void Y(long j) {
        this.gdD.Y(j);
    }

    @Override // com.baidu.live.challenge.i
    public void wo() {
        this.gdD.wo();
    }

    @Override // com.baidu.live.challenge.i
    public void wp() {
        this.gdD.wp();
    }

    @Override // com.baidu.live.challenge.i
    public void wq() {
        this.gdD.wq();
    }

    @Override // com.baidu.live.challenge.i
    public void wt() {
        this.gdD.wt();
    }

    @Override // com.baidu.live.challenge.i
    public long wu() {
        return this.gdD.wu();
    }

    @Override // com.baidu.live.challenge.i
    public ChallenfeInfoData.ChallengeStatus wr() {
        return this.gdD.wr();
    }

    @Override // com.baidu.live.challenge.i
    public boolean ws() {
        return this.gdD.ws();
    }

    @Override // com.baidu.live.challenge.i
    public void ba(boolean z) {
        this.gdD.ba(z);
    }

    private void bFF() {
        if (this.gdC != null) {
            this.gdC.clear();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void wd() {
        if (this.gdD != null) {
            this.gdD.bGe();
        }
        bFF();
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        if (this.gdD != null) {
            this.gdD.onDestroy();
        }
        bFF();
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.l lVar) {
        this.gdE = lVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.InterfaceC0158i interfaceC0158i) {
        this.gdF = interfaceC0158i;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.k kVar) {
        this.gdG = kVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.h hVar) {
        this.gdH = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.g gVar) {
        this.gdI = gVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.j jVar) {
        this.gdJ = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.e eVar) {
        this.gdK = eVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.a aVar) {
        this.gdL = aVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.b bVar) {
        this.gdM = bVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.m mVar) {
        this.gdN = mVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.d dVar) {
        this.gdO = dVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.f fVar) {
        this.gdD.b(fVar);
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.c cVar) {
        if (cVar != null && !this.gdC.contains(cVar)) {
            this.gdC.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void eq(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.gdD.wo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, an anVar, ar arVar, ar arVar2) {
        if (!ListUtils.isEmpty(this.gdC)) {
            if (i == 4) {
                if (this.gdP == this.gdD.wu()) {
                    BdLog.e("CHALLENGE_TAG challenge is Over but challenge id same?? ||Net Challenge id=" + this.gdD.wu() + "||Last Challenge id=" + this.gdP);
                    return;
                }
                this.gdP = this.gdD.wu();
            }
            for (i.c cVar : this.gdC) {
                if (cVar != null) {
                    switch (i) {
                        case 2:
                            cVar.b(anVar, arVar, arVar2);
                            continue;
                        case 3:
                            cVar.c(anVar, arVar, arVar2);
                            continue;
                        case 4:
                            cVar.d(anVar, arVar, arVar2);
                            continue;
                        case 5:
                            cVar.e(anVar, arVar, arVar2);
                            continue;
                    }
                }
            }
        }
    }
}
