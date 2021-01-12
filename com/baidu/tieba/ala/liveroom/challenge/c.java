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
/* loaded from: classes10.dex */
public class c implements i {
    private List<i.c> hpZ;
    private com.baidu.tieba.ala.liveroom.challenge.b.b hqa;
    private i.m hqb;
    private i.InterfaceC0165i hqc;
    private i.l hqd;
    private i.h hqe;
    private i.g hqf;
    private i.k hqg;
    private i.e hqh;
    private i.a hqi;
    private i.b hqj;
    private i.n hqk;
    private i.d hql;
    private i.j hqm;
    private long hqn = 0;
    private boolean hqo = false;
    private b.a hqp = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void Ac() {
            if (c.this.hqb != null) {
                c.this.hqb.Ac();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void q(int i, String str) {
            if (c.this.hqb != null) {
                c.this.hqb.q(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.hqc != null) {
                c.this.hqc.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void n(int i, String str) {
            if (c.this.hqc != null) {
                c.this.hqc.n(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void cH(List<com.baidu.live.challenge.d> list) {
            if (c.this.hqd != null) {
                c.this.hqd.z(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void ba(int i, String str) {
            if (c.this.hqd != null) {
                c.this.hqd.p(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.hqh != null) {
                c.this.hqh.a(aVar.aDF, aVar != null ? aVar.aDG : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bb(int i, String str) {
            if (c.this.hqh != null) {
                c.this.hqh.k(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.hqh != null) {
                c.this.hqh.b(z ? 100 : 101, aVar != null ? aVar.aDG : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bc(int i, String str) {
            if (c.this.hqh != null) {
                c.this.hqh.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void l(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.hqj != null && i > 0) {
                c.this.hqj.cu(i);
            }
            if (c.this.hqf != null) {
                c.this.hqf.y(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bd(int i, String str) {
            if (c.this.hqf != null) {
                c.this.hqf.l(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void k(boolean z, long j) {
            if (c.this.hqm != null) {
                c.this.hqm.k(z, j);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void be(int i, String str) {
            if (c.this.hqm != null) {
                c.this.hqm.k(false, 0L);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.hqi != null) {
                c.this.hqi.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bf(int i, String str) {
            if (c.this.hqi != null) {
                c.this.hqi.j(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.hqg != null) {
                c.this.hqg.a(aVar.zJ(), aVar != null ? aVar.aDG : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bg(int i, String str) {
            if (c.this.hqg != null) {
                c.this.hqg.o(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.hqg != null) {
                c.this.hqg.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bh(int i, String str) {
            if (c.this.hqg != null) {
                c.this.hqg.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void p(boolean z, String str) {
            if (c.this.hqk != null) {
                c.this.hqk.d(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.hqe != null) {
                c.this.hqe.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void m(int i, String str) {
            if (c.this.hqe != null) {
                c.this.hqe.m(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(int i, bc bcVar, bg bgVar, bg bgVar2) {
            c.this.a(i, bcVar, bgVar, bgVar2);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void q(boolean z, String str) {
            if (c.this.hql != null) {
                c.this.hql.c(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public boolean cbG() {
            return c.this.hqo;
        }
    };
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.hqa = new com.baidu.tieba.ala.liveroom.challenge.b.b(tbPageContext, tbPageContext.getUniqueId());
        this.hqa.a(this.hqp);
        this.hpZ = new ArrayList();
    }

    @Override // com.baidu.live.challenge.i
    public void h(long j, long j2) {
        this.hqa.h(j, j2);
    }

    @Override // com.baidu.live.challenge.i
    public void setIsHost(boolean z) {
        if (this.hqa != null) {
            this.hqa.setIsHost(z);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void zP() {
        this.hqo = false;
    }

    @Override // com.baidu.live.challenge.i
    public void a(az azVar) {
        this.hqo = false;
        if (azVar != null) {
            AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage = new AlaGetChallengeInfoResponseMessage();
            alaGetChallengeInfoResponseMessage.a(azVar.aLI);
            alaGetChallengeInfoResponseMessage.a(azVar.aLJ);
            alaGetChallengeInfoResponseMessage.b(azVar.aLK);
            MessageManager.getInstance().dispatchResponsedMessage(alaGetChallengeInfoResponseMessage);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void c(x xVar) {
        if (xVar != null && xVar.mLiveInfo != null && !this.hqo) {
            this.hqa.fx(xVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void zQ() {
        if (this.hqa != null) {
            this.hqa.ccp();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void zR() {
        if (this.hqa != null) {
            this.hqa.ccq();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !zX()) {
            this.hqa.fx(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void ct(int i) {
        if (this.hqj != null) {
            this.hqj.cu(i);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Aa() {
        if (this.hqa != null) {
            this.hqa.Aa();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(long j, long j2, long j3, int i, String str) {
        if (this.hqa != null) {
            this.hqa.a(j, j2, j3, i, str);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void zS() {
        this.hqa.zS();
    }

    @Override // com.baidu.live.challenge.i
    public void eW(String str) {
        this.hqa.GZ(str);
    }

    @Override // com.baidu.live.challenge.i
    public void y(int i, int i2) {
        this.hqa.y(i, i2);
    }

    @Override // com.baidu.live.challenge.i
    public void g(int i, int i2, String str) {
        this.hqa.g(i, i2, str);
    }

    @Override // com.baidu.live.challenge.i
    public void eX(String str) {
        this.hqa.eX(str);
    }

    @Override // com.baidu.live.challenge.i
    public void aG(long j) {
        this.hqa.aG(j);
    }

    @Override // com.baidu.live.challenge.i
    public void aH(long j) {
        this.hqa.aH(j);
    }

    @Override // com.baidu.live.challenge.i
    public void aI(long j) {
        this.hqa.aI(j);
    }

    @Override // com.baidu.live.challenge.i
    public void aJ(long j) {
        this.hqa.aJ(j);
    }

    @Override // com.baidu.live.challenge.i
    public void zT() {
        this.hqa.zT();
    }

    @Override // com.baidu.live.challenge.i
    public void zU() {
        this.hqa.zU();
    }

    @Override // com.baidu.live.challenge.i
    public void zV() {
        this.hqa.zV();
    }

    @Override // com.baidu.live.challenge.i
    public void zY() {
        this.hqa.zY();
    }

    @Override // com.baidu.live.challenge.i
    public long zZ() {
        return this.hqa.zZ();
    }

    @Override // com.baidu.live.challenge.i
    public ChallenfeInfoData.ChallengeStatus zW() {
        return this.hqa.zW();
    }

    @Override // com.baidu.live.challenge.i
    public boolean zX() {
        return this.hqa.zX();
    }

    @Override // com.baidu.live.challenge.i
    public void bo(boolean z) {
        this.hqa.bo(z);
    }

    private void cbF() {
        if (this.hpZ != null) {
            this.hpZ.clear();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void zH() {
        this.hqo = true;
        if (this.hqa != null) {
            this.hqa.ccl();
        }
        cbF();
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        if (this.hqa != null) {
            this.hqa.onDestroy();
        }
        cbF();
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.m mVar) {
        this.hqb = mVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.InterfaceC0165i interfaceC0165i) {
        this.hqc = interfaceC0165i;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.l lVar) {
        this.hqd = lVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.h hVar) {
        this.hqe = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.g gVar) {
        this.hqf = gVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.k kVar) {
        this.hqg = kVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.e eVar) {
        this.hqh = eVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.a aVar) {
        this.hqi = aVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.b bVar) {
        this.hqj = bVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.n nVar) {
        this.hqk = nVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.d dVar) {
        this.hql = dVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.f fVar) {
        this.hqa.b(fVar);
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.j jVar) {
        this.hqm = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.c cVar) {
        if (cVar != null && !this.hpZ.contains(cVar)) {
            this.hpZ.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void eV(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.hqa.zT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, bc bcVar, bg bgVar, bg bgVar2) {
        if (!ListUtils.isEmpty(this.hpZ)) {
            if (i == 4) {
                if (this.hqn == this.hqa.zZ()) {
                    BdLog.e("CHALLENGE_TAG challenge is Over but challenge id same?? ||Net Challenge id=" + this.hqa.zZ() + "||Last Challenge id=" + this.hqn);
                    return;
                }
                this.hqn = this.hqa.zZ();
            }
            for (i.c cVar : this.hpZ) {
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
