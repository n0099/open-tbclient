package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.i;
import com.baidu.live.data.AlaPersonChallengeData;
import com.baidu.live.data.ar;
import com.baidu.live.data.au;
import com.baidu.live.data.ay;
import com.baidu.live.data.u;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.challenge.b.b;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetChallengeInfoResponseMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements i {
    private List<i.c> gtd;
    private com.baidu.tieba.ala.liveroom.challenge.b.b gte;
    private i.m gtf;
    private i.InterfaceC0168i gtg;
    private i.l gth;
    private i.h gti;
    private i.g gtj;
    private i.k gtk;
    private i.e gtl;
    private i.a gtm;
    private i.b gtn;
    private i.n gto;
    private i.d gtp;
    private i.j gtq;
    private long gtr = 0;
    private boolean gts = false;
    private b.a gtt = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void Ck() {
            if (c.this.gtf != null) {
                c.this.gtf.Ck();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void n(int i, String str) {
            if (c.this.gtf != null) {
                c.this.gtf.n(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.gtg != null) {
                c.this.gtg.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void k(int i, String str) {
            if (c.this.gtg != null) {
                c.this.gtg.k(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void cb(List<com.baidu.live.challenge.d> list) {
            if (c.this.gth != null) {
                c.this.gth.w(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aK(int i, String str) {
            if (c.this.gth != null) {
                c.this.gth.m(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.gtl != null) {
                c.this.gtl.a(aVar.aCW, aVar != null ? aVar.aCX : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aL(int i, String str) {
            if (c.this.gtl != null) {
                c.this.gtl.h(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gtl != null) {
                c.this.gtl.b(z ? 100 : 101, aVar != null ? aVar.aCX : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aM(int i, String str) {
            if (c.this.gtl != null) {
                c.this.gtl.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void l(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.gtn != null && i > 0) {
                c.this.gtn.dJ(i);
            }
            if (c.this.gtj != null) {
                c.this.gtj.v(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aN(int i, String str) {
            if (c.this.gtj != null) {
                c.this.gtj.i(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(boolean z, long j) {
            if (c.this.gtq != null) {
                c.this.gtq.b(z, j);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gtm != null) {
                c.this.gtm.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aO(int i, String str) {
            if (c.this.gtm != null) {
                c.this.gtm.g(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.gtk != null) {
                c.this.gtk.a(aVar.BS(), aVar != null ? aVar.aCX : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aP(int i, String str) {
            if (c.this.gtk != null) {
                c.this.gtk.l(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gtk != null) {
                c.this.gtk.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aQ(int i, String str) {
            if (c.this.gtk != null) {
                c.this.gtk.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void n(boolean z, String str) {
            if (c.this.gto != null) {
                c.this.gto.d(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.gti != null) {
                c.this.gti.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void j(int i, String str) {
            if (c.this.gti != null) {
                c.this.gti.j(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(int i, au auVar, ay ayVar, ay ayVar2) {
            c.this.a(i, auVar, ayVar, ayVar2);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void o(boolean z, String str) {
            if (c.this.gtp != null) {
                c.this.gtp.c(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public boolean bQy() {
            return c.this.gts;
        }
    };
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gte = new com.baidu.tieba.ala.liveroom.challenge.b.b(tbPageContext, tbPageContext.getUniqueId());
        this.gte.a(this.gtt);
        this.gtd = new ArrayList();
    }

    @Override // com.baidu.live.challenge.i
    public void e(long j, long j2) {
        this.gte.e(j, j2);
    }

    @Override // com.baidu.live.challenge.i
    public void setIsHost(boolean z) {
        if (this.gte != null) {
            this.gte.setIsHost(z);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(ar arVar) {
        this.gts = false;
        if (arVar != null) {
            AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage = new AlaGetChallengeInfoResponseMessage();
            alaGetChallengeInfoResponseMessage.a(arVar.aJF);
            alaGetChallengeInfoResponseMessage.a(arVar.aJG);
            alaGetChallengeInfoResponseMessage.b(arVar.aJH);
            MessageManager.getInstance().dispatchResponsedMessage(alaGetChallengeInfoResponseMessage);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void c(u uVar) {
        if (uVar != null && uVar.mLiveInfo != null && !this.gts) {
            this.gte.ef(uVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void BY() {
        if (this.gte != null) {
            this.gte.bRg();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void BZ() {
        if (this.gte != null) {
            this.gte.bRh();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !Cf()) {
            this.gte.ef(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void dI(int i) {
        if (this.gtn != null) {
            this.gtn.dJ(i);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Ci() {
        if (this.gte != null) {
            this.gte.Ci();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(long j, long j2, long j3, int i, String str) {
        if (this.gte != null) {
            this.gte.a(j, j2, j3, i, str);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Ca() {
        this.gte.Ca();
    }

    @Override // com.baidu.live.challenge.i
    public void fO(String str) {
        this.gte.Gr(str);
    }

    @Override // com.baidu.live.challenge.i
    public void w(int i, int i2) {
        this.gte.w(i, i2);
    }

    @Override // com.baidu.live.challenge.i
    public void e(int i, int i2, String str) {
        this.gte.e(i, i2, str);
    }

    @Override // com.baidu.live.challenge.i
    public void fP(String str) {
        this.gte.fP(str);
    }

    @Override // com.baidu.live.challenge.i
    public void V(long j) {
        this.gte.V(j);
    }

    @Override // com.baidu.live.challenge.i
    public void W(long j) {
        this.gte.W(j);
    }

    @Override // com.baidu.live.challenge.i
    public void X(long j) {
        this.gte.X(j);
    }

    @Override // com.baidu.live.challenge.i
    public void Y(long j) {
        this.gte.Y(j);
    }

    @Override // com.baidu.live.challenge.i
    public void Cb() {
        this.gte.Cb();
    }

    @Override // com.baidu.live.challenge.i
    public void Cc() {
        this.gte.Cc();
    }

    @Override // com.baidu.live.challenge.i
    public void Cd() {
        this.gte.Cd();
    }

    @Override // com.baidu.live.challenge.i
    public void Cg() {
        this.gte.Cg();
    }

    @Override // com.baidu.live.challenge.i
    public long Ch() {
        return this.gte.Ch();
    }

    @Override // com.baidu.live.challenge.i
    public ChallenfeInfoData.ChallengeStatus Ce() {
        return this.gte.Ce();
    }

    @Override // com.baidu.live.challenge.i
    public boolean Cf() {
        return this.gte.Cf();
    }

    @Override // com.baidu.live.challenge.i
    public void bf(boolean z) {
        this.gte.bf(z);
    }

    private void bQx() {
        if (this.gtd != null) {
            this.gtd.clear();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void BQ() {
        this.gts = true;
        if (this.gte != null) {
            this.gte.bRc();
        }
        bQx();
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        if (this.gte != null) {
            this.gte.onDestroy();
        }
        bQx();
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.m mVar) {
        this.gtf = mVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.InterfaceC0168i interfaceC0168i) {
        this.gtg = interfaceC0168i;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.l lVar) {
        this.gth = lVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.h hVar) {
        this.gti = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.g gVar) {
        this.gtj = gVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.k kVar) {
        this.gtk = kVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.e eVar) {
        this.gtl = eVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.a aVar) {
        this.gtm = aVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.b bVar) {
        this.gtn = bVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.n nVar) {
        this.gto = nVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.d dVar) {
        this.gtp = dVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.f fVar) {
        this.gte.b(fVar);
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.j jVar) {
        this.gtq = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.c cVar) {
        if (cVar != null && !this.gtd.contains(cVar)) {
            this.gtd.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void fN(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.gte.Cb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, au auVar, ay ayVar, ay ayVar2) {
        if (!ListUtils.isEmpty(this.gtd)) {
            if (i == 4) {
                if (this.gtr == this.gte.Ch()) {
                    BdLog.e("CHALLENGE_TAG challenge is Over but challenge id same?? ||Net Challenge id=" + this.gte.Ch() + "||Last Challenge id=" + this.gtr);
                    return;
                }
                this.gtr = this.gte.Ch();
            }
            for (i.c cVar : this.gtd) {
                if (cVar != null) {
                    switch (i) {
                        case 2:
                            cVar.b(auVar, ayVar, ayVar2);
                            continue;
                        case 3:
                            cVar.c(auVar, ayVar, ayVar2);
                            continue;
                        case 4:
                            cVar.d(auVar, ayVar, ayVar2);
                            continue;
                        case 5:
                            cVar.e(auVar, ayVar, ayVar2);
                            continue;
                    }
                }
            }
        }
    }
}
