package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.i;
import com.baidu.live.data.AlaPersonChallengeData;
import com.baidu.live.data.aw;
import com.baidu.live.data.az;
import com.baidu.live.data.bd;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.challenge.b.b;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetChallengeInfoResponseMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements i {
    private List<i.c> gYZ;
    private com.baidu.tieba.ala.liveroom.challenge.b.b gZa;
    private i.m gZb;
    private i.InterfaceC0175i gZc;
    private i.l gZd;
    private i.h gZe;
    private i.g gZf;
    private i.k gZg;
    private i.e gZh;
    private i.a gZi;
    private i.b gZj;
    private i.n gZk;
    private i.d gZl;
    private i.j gZm;
    private long gZn = 0;
    private boolean gZo = false;
    private b.a gZp = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void CY() {
            if (c.this.gZb != null) {
                c.this.gZb.CY();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void p(int i, String str) {
            if (c.this.gZb != null) {
                c.this.gZb.p(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.gZc != null) {
                c.this.gZc.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void m(int i, String str) {
            if (c.this.gZc != null) {
                c.this.gZc.m(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void cw(List<com.baidu.live.challenge.d> list) {
            if (c.this.gZd != null) {
                c.this.gZd.y(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aX(int i, String str) {
            if (c.this.gZd != null) {
                c.this.gZd.o(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.gZh != null) {
                c.this.gZh.a(aVar.aFo, aVar != null ? aVar.aFp : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aY(int i, String str) {
            if (c.this.gZh != null) {
                c.this.gZh.j(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gZh != null) {
                c.this.gZh.b(z ? 100 : 101, aVar != null ? aVar.aFp : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aZ(int i, String str) {
            if (c.this.gZh != null) {
                c.this.gZh.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void l(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.gZj != null && i > 0) {
                c.this.gZj.dK(i);
            }
            if (c.this.gZf != null) {
                c.this.gZf.x(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void ba(int i, String str) {
            if (c.this.gZf != null) {
                c.this.gZf.k(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void d(boolean z, long j) {
            if (c.this.gZm != null) {
                c.this.gZm.d(z, j);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bb(int i, String str) {
            if (c.this.gZm != null) {
                c.this.gZm.d(false, 0L);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gZi != null) {
                c.this.gZi.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bc(int i, String str) {
            if (c.this.gZi != null) {
                c.this.gZi.i(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.gZg != null) {
                c.this.gZg.a(aVar.CF(), aVar != null ? aVar.aFp : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bd(int i, String str) {
            if (c.this.gZg != null) {
                c.this.gZg.n(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gZg != null) {
                c.this.gZg.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void be(int i, String str) {
            if (c.this.gZg != null) {
                c.this.gZg.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void q(boolean z, String str) {
            if (c.this.gZk != null) {
                c.this.gZk.d(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.gZe != null) {
                c.this.gZe.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void l(int i, String str) {
            if (c.this.gZe != null) {
                c.this.gZe.l(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(int i, az azVar, bd bdVar, bd bdVar2) {
            c.this.a(i, azVar, bdVar, bdVar2);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void r(boolean z, String str) {
            if (c.this.gZl != null) {
                c.this.gZl.c(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public boolean bYL() {
            return c.this.gZo;
        }
    };
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gZa = new com.baidu.tieba.ala.liveroom.challenge.b.b(tbPageContext, tbPageContext.getUniqueId());
        this.gZa.a(this.gZp);
        this.gYZ = new ArrayList();
    }

    @Override // com.baidu.live.challenge.i
    public void e(long j, long j2) {
        this.gZa.e(j, j2);
    }

    @Override // com.baidu.live.challenge.i
    public void setIsHost(boolean z) {
        if (this.gZa != null) {
            this.gZa.setIsHost(z);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void CL() {
        this.gZo = false;
    }

    @Override // com.baidu.live.challenge.i
    public void a(aw awVar) {
        this.gZo = false;
        if (awVar != null) {
            AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage = new AlaGetChallengeInfoResponseMessage();
            alaGetChallengeInfoResponseMessage.a(awVar.aMH);
            alaGetChallengeInfoResponseMessage.a(awVar.aMI);
            alaGetChallengeInfoResponseMessage.b(awVar.aMJ);
            MessageManager.getInstance().dispatchResponsedMessage(alaGetChallengeInfoResponseMessage);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void c(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && !this.gZo) {
            this.gZa.eT(wVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void CM() {
        if (this.gZa != null) {
            this.gZa.bZu();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void CN() {
        if (this.gZa != null) {
            this.gZa.bZv();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !CT()) {
            this.gZa.eT(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void dJ(int i) {
        if (this.gZj != null) {
            this.gZj.dK(i);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void CW() {
        if (this.gZa != null) {
            this.gZa.CW();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(long j, long j2, long j3, int i, String str) {
        if (this.gZa != null) {
            this.gZa.a(j, j2, j3, i, str);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void CO() {
        this.gZa.CO();
    }

    @Override // com.baidu.live.challenge.i
    public void gc(String str) {
        this.gZa.Hu(str);
    }

    @Override // com.baidu.live.challenge.i
    public void w(int i, int i2) {
        this.gZa.w(i, i2);
    }

    @Override // com.baidu.live.challenge.i
    public void f(int i, int i2, String str) {
        this.gZa.f(i, i2, str);
    }

    @Override // com.baidu.live.challenge.i
    public void gd(String str) {
        this.gZa.gd(str);
    }

    @Override // com.baidu.live.challenge.i
    public void aj(long j) {
        this.gZa.aj(j);
    }

    @Override // com.baidu.live.challenge.i
    public void ak(long j) {
        this.gZa.ak(j);
    }

    @Override // com.baidu.live.challenge.i
    public void al(long j) {
        this.gZa.al(j);
    }

    @Override // com.baidu.live.challenge.i
    public void am(long j) {
        this.gZa.am(j);
    }

    @Override // com.baidu.live.challenge.i
    public void CP() {
        this.gZa.CP();
    }

    @Override // com.baidu.live.challenge.i
    public void CQ() {
        this.gZa.CQ();
    }

    @Override // com.baidu.live.challenge.i
    public void CR() {
        this.gZa.CR();
    }

    @Override // com.baidu.live.challenge.i
    public void CU() {
        this.gZa.CU();
    }

    @Override // com.baidu.live.challenge.i
    public long CV() {
        return this.gZa.CV();
    }

    @Override // com.baidu.live.challenge.i
    public ChallenfeInfoData.ChallengeStatus CS() {
        return this.gZa.CS();
    }

    @Override // com.baidu.live.challenge.i
    public boolean CT() {
        return this.gZa.CT();
    }

    @Override // com.baidu.live.challenge.i
    public void bn(boolean z) {
        this.gZa.bn(z);
    }

    private void bYK() {
        if (this.gYZ != null) {
            this.gYZ.clear();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void CD() {
        this.gZo = true;
        if (this.gZa != null) {
            this.gZa.bZq();
        }
        bYK();
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        if (this.gZa != null) {
            this.gZa.onDestroy();
        }
        bYK();
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.m mVar) {
        this.gZb = mVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.InterfaceC0175i interfaceC0175i) {
        this.gZc = interfaceC0175i;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.l lVar) {
        this.gZd = lVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.h hVar) {
        this.gZe = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.g gVar) {
        this.gZf = gVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.k kVar) {
        this.gZg = kVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.e eVar) {
        this.gZh = eVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.a aVar) {
        this.gZi = aVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.b bVar) {
        this.gZj = bVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.n nVar) {
        this.gZk = nVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.d dVar) {
        this.gZl = dVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.f fVar) {
        this.gZa.b(fVar);
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.j jVar) {
        this.gZm = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.c cVar) {
        if (cVar != null && !this.gYZ.contains(cVar)) {
            this.gYZ.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void gb(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.gZa.CP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, az azVar, bd bdVar, bd bdVar2) {
        if (!ListUtils.isEmpty(this.gYZ)) {
            if (i == 4) {
                if (this.gZn == this.gZa.CV()) {
                    BdLog.e("CHALLENGE_TAG challenge is Over but challenge id same?? ||Net Challenge id=" + this.gZa.CV() + "||Last Challenge id=" + this.gZn);
                    return;
                }
                this.gZn = this.gZa.CV();
            }
            for (i.c cVar : this.gYZ) {
                if (cVar != null) {
                    switch (i) {
                        case 2:
                            cVar.b(azVar, bdVar, bdVar2);
                            continue;
                        case 3:
                            cVar.c(azVar, bdVar, bdVar2);
                            continue;
                        case 4:
                            cVar.d(azVar, bdVar, bdVar2);
                            continue;
                        case 5:
                            cVar.e(azVar, bdVar, bdVar2);
                            continue;
                    }
                }
            }
        }
    }
}
