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
    private List<i.c> huj;
    private com.baidu.tieba.ala.liveroom.challenge.b.b huk;
    private i.m hul;
    private i.InterfaceC0166i hum;
    private i.l hun;
    private i.h huo;
    private i.g hup;
    private i.k huq;
    private i.e hur;
    private i.a hus;
    private i.b hut;
    private i.n huu;
    private i.d huv;
    private i.j huw;
    private long hux = 0;
    private boolean huy = false;
    private b.a huz = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void AM() {
            if (c.this.hul != null) {
                c.this.hul.AM();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void t(int i, String str) {
            if (c.this.hul != null) {
                c.this.hul.t(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.hum != null) {
                c.this.hum.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void q(int i, String str) {
            if (c.this.hum != null) {
                c.this.hum.q(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void cC(List<com.baidu.live.challenge.d> list) {
            if (c.this.hun != null) {
                c.this.hun.z(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bf(int i, String str) {
            if (c.this.hun != null) {
                c.this.hun.s(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.hur != null) {
                c.this.hur.a(aVar.aFs, aVar != null ? aVar.aFt : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bg(int i, String str) {
            if (c.this.hur != null) {
                c.this.hur.n(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.hur != null) {
                c.this.hur.b(z ? 100 : 101, aVar != null ? aVar.aFt : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bh(int i, String str) {
            if (c.this.hur != null) {
                c.this.hur.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void m(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.hut != null && i > 0) {
                c.this.hut.cx(i);
            }
            if (c.this.hup != null) {
                c.this.hup.y(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bi(int i, String str) {
            if (c.this.hup != null) {
                c.this.hup.o(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void k(boolean z, long j) {
            if (c.this.huw != null) {
                c.this.huw.k(z, j);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bj(int i, String str) {
            if (c.this.huw != null) {
                c.this.huw.k(false, 0L);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.hus != null) {
                c.this.hus.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bk(int i, String str) {
            if (c.this.hus != null) {
                c.this.hus.m(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.huq != null) {
                c.this.huq.a(aVar.At(), aVar != null ? aVar.aFt : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bl(int i, String str) {
            if (c.this.huq != null) {
                c.this.huq.r(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.huq != null) {
                c.this.huq.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bm(int i, String str) {
            if (c.this.huq != null) {
                c.this.huq.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void w(boolean z, String str) {
            if (c.this.huu != null) {
                c.this.huu.h(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.huo != null) {
                c.this.huo.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void p(int i, String str) {
            if (c.this.huo != null) {
                c.this.huo.p(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(int i, bg bgVar, bk bkVar, bk bkVar2) {
            c.this.a(i, bgVar, bkVar, bkVar2);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void x(boolean z, String str) {
            if (c.this.huv != null) {
                c.this.huv.g(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public boolean ccB() {
            return c.this.huy;
        }
    };
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.huk = new com.baidu.tieba.ala.liveroom.challenge.b.b(tbPageContext, tbPageContext.getUniqueId());
        this.huk.a(this.huz);
        this.huj = new ArrayList();
    }

    @Override // com.baidu.live.challenge.i
    public void h(long j, long j2) {
        this.huk.h(j, j2);
    }

    @Override // com.baidu.live.challenge.i
    public void setIsHost(boolean z) {
        if (this.huk != null) {
            this.huk.setIsHost(z);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Az() {
        this.huy = false;
    }

    @Override // com.baidu.live.challenge.i
    public void a(bd bdVar) {
        this.huy = false;
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
        if (abVar != null && abVar.mLiveInfo != null && !this.huy) {
            this.huk.fC(abVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void AA() {
        if (this.huk != null) {
            this.huk.cdk();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void AB() {
        if (this.huk != null) {
            this.huk.cdl();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !AH()) {
            this.huk.fC(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void cw(int i) {
        if (this.hut != null) {
            this.hut.cx(i);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void AK() {
        if (this.huk != null) {
            this.huk.AK();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(long j, long j2, long j3, int i, String str) {
        if (this.huk != null) {
            this.huk.a(j, j2, j3, i, str);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void AC() {
        this.huk.AC();
    }

    @Override // com.baidu.live.challenge.i
    public void fp(String str) {
        this.huk.HD(str);
    }

    @Override // com.baidu.live.challenge.i
    public void y(int i, int i2) {
        this.huk.y(i, i2);
    }

    @Override // com.baidu.live.challenge.i
    public void g(int i, int i2, String str) {
        this.huk.g(i, i2, str);
    }

    @Override // com.baidu.live.challenge.i
    public void fq(String str) {
        this.huk.fq(str);
    }

    @Override // com.baidu.live.challenge.i
    public void aI(long j) {
        this.huk.aI(j);
    }

    @Override // com.baidu.live.challenge.i
    public void aJ(long j) {
        this.huk.aJ(j);
    }

    @Override // com.baidu.live.challenge.i
    public void aK(long j) {
        this.huk.aK(j);
    }

    @Override // com.baidu.live.challenge.i
    public void aL(long j) {
        this.huk.aL(j);
    }

    @Override // com.baidu.live.challenge.i
    public void AD() {
        this.huk.AD();
    }

    @Override // com.baidu.live.challenge.i
    public void AE() {
        this.huk.AE();
    }

    @Override // com.baidu.live.challenge.i
    public void AF() {
        this.huk.AF();
    }

    @Override // com.baidu.live.challenge.i
    public void AI() {
        this.huk.AI();
    }

    @Override // com.baidu.live.challenge.i
    public long AJ() {
        return this.huk.AJ();
    }

    @Override // com.baidu.live.challenge.i
    public ChallenfeInfoData.ChallengeStatus AG() {
        return this.huk.AG();
    }

    @Override // com.baidu.live.challenge.i
    public boolean AH() {
        return this.huk.AH();
    }

    @Override // com.baidu.live.challenge.i
    public void bq(boolean z) {
        this.huk.bq(z);
    }

    private void ccA() {
        if (this.huj != null) {
            this.huj.clear();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Ar() {
        this.huy = true;
        if (this.huk != null) {
            this.huk.cdg();
        }
        ccA();
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        if (this.huk != null) {
            this.huk.onDestroy();
        }
        ccA();
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.m mVar) {
        this.hul = mVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.InterfaceC0166i interfaceC0166i) {
        this.hum = interfaceC0166i;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.l lVar) {
        this.hun = lVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.h hVar) {
        this.huo = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.g gVar) {
        this.hup = gVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.k kVar) {
        this.huq = kVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.e eVar) {
        this.hur = eVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.a aVar) {
        this.hus = aVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.b bVar) {
        this.hut = bVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.n nVar) {
        this.huu = nVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.d dVar) {
        this.huv = dVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.f fVar) {
        this.huk.b(fVar);
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.j jVar) {
        this.huw = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.c cVar) {
        if (cVar != null && !this.huj.contains(cVar)) {
            this.huj.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void fo(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.huk.AD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, bg bgVar, bk bkVar, bk bkVar2) {
        if (!ListUtils.isEmpty(this.huj)) {
            if (i == 4) {
                if (this.hux == this.huk.AJ()) {
                    BdLog.e("CHALLENGE_TAG challenge is Over but challenge id same?? ||Net Challenge id=" + this.huk.AJ() + "||Last Challenge id=" + this.hux);
                    return;
                }
                this.hux = this.huk.AJ();
            }
            for (i.c cVar : this.huj) {
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
