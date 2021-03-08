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
/* loaded from: classes10.dex */
public class c implements i {
    private List<i.c> hwg;
    private com.baidu.tieba.ala.liveroom.challenge.b.b hwh;
    private i.m hwi;
    private i.InterfaceC0172i hwj;
    private i.l hwk;
    private i.h hwl;
    private i.g hwm;
    private i.k hwn;
    private i.e hwo;
    private i.a hwp;
    private i.b hwq;
    private i.n hwr;
    private i.d hws;
    private i.j hwt;
    private long hwu = 0;
    private boolean hwv = false;
    private b.a hww = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void AP() {
            if (c.this.hwi != null) {
                c.this.hwi.AP();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void t(int i, String str) {
            if (c.this.hwi != null) {
                c.this.hwi.t(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.hwj != null) {
                c.this.hwj.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void q(int i, String str) {
            if (c.this.hwj != null) {
                c.this.hwj.q(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void cC(List<com.baidu.live.challenge.d> list) {
            if (c.this.hwk != null) {
                c.this.hwk.z(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bf(int i, String str) {
            if (c.this.hwk != null) {
                c.this.hwk.s(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.hwo != null) {
                c.this.hwo.a(aVar.aGS, aVar != null ? aVar.aGT : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bg(int i, String str) {
            if (c.this.hwo != null) {
                c.this.hwo.n(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.hwo != null) {
                c.this.hwo.b(z ? 100 : 101, aVar != null ? aVar.aGT : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bh(int i, String str) {
            if (c.this.hwo != null) {
                c.this.hwo.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void m(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.hwq != null && i > 0) {
                c.this.hwq.cy(i);
            }
            if (c.this.hwm != null) {
                c.this.hwm.y(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bi(int i, String str) {
            if (c.this.hwm != null) {
                c.this.hwm.o(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void l(boolean z, long j) {
            if (c.this.hwt != null) {
                c.this.hwt.l(z, j);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bj(int i, String str) {
            if (c.this.hwt != null) {
                c.this.hwt.l(false, 0L);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.hwp != null) {
                c.this.hwp.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bk(int i, String str) {
            if (c.this.hwp != null) {
                c.this.hwp.m(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.hwn != null) {
                c.this.hwn.a(aVar.Aw(), aVar != null ? aVar.aGT : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bl(int i, String str) {
            if (c.this.hwn != null) {
                c.this.hwn.r(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.hwn != null) {
                c.this.hwn.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bm(int i, String str) {
            if (c.this.hwn != null) {
                c.this.hwn.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void w(boolean z, String str) {
            if (c.this.hwr != null) {
                c.this.hwr.h(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.hwl != null) {
                c.this.hwl.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void p(int i, String str) {
            if (c.this.hwl != null) {
                c.this.hwl.p(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(int i, bg bgVar, bk bkVar, bk bkVar2) {
            c.this.a(i, bgVar, bkVar, bkVar2);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void x(boolean z, String str) {
            if (c.this.hws != null) {
                c.this.hws.g(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public boolean ccO() {
            return c.this.hwv;
        }
    };
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.hwh = new com.baidu.tieba.ala.liveroom.challenge.b.b(tbPageContext, tbPageContext.getUniqueId());
        this.hwh.a(this.hww);
        this.hwg = new ArrayList();
    }

    @Override // com.baidu.live.challenge.i
    public void h(long j, long j2) {
        this.hwh.h(j, j2);
    }

    @Override // com.baidu.live.challenge.i
    public void setIsHost(boolean z) {
        if (this.hwh != null) {
            this.hwh.setIsHost(z);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void AC() {
        this.hwv = false;
    }

    @Override // com.baidu.live.challenge.i
    public void a(bd bdVar) {
        this.hwv = false;
        if (bdVar != null) {
            AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage = new AlaGetChallengeInfoResponseMessage();
            alaGetChallengeInfoResponseMessage.a(bdVar.aQf);
            alaGetChallengeInfoResponseMessage.a(bdVar.aQg);
            alaGetChallengeInfoResponseMessage.b(bdVar.aQh);
            MessageManager.getInstance().dispatchResponsedMessage(alaGetChallengeInfoResponseMessage);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void c(ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null && !this.hwv) {
            this.hwh.fC(abVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void AD() {
        if (this.hwh != null) {
            this.hwh.cdx();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void AE() {
        if (this.hwh != null) {
            this.hwh.cdy();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !AK()) {
            this.hwh.fC(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void cx(int i) {
        if (this.hwq != null) {
            this.hwq.cy(i);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void AN() {
        if (this.hwh != null) {
            this.hwh.AN();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(long j, long j2, long j3, int i, String str) {
        if (this.hwh != null) {
            this.hwh.a(j, j2, j3, i, str);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void AF() {
        this.hwh.AF();
    }

    @Override // com.baidu.live.challenge.i
    public void fv(String str) {
        this.hwh.HN(str);
    }

    @Override // com.baidu.live.challenge.i
    public void y(int i, int i2) {
        this.hwh.y(i, i2);
    }

    @Override // com.baidu.live.challenge.i
    public void g(int i, int i2, String str) {
        this.hwh.g(i, i2, str);
    }

    @Override // com.baidu.live.challenge.i
    public void fw(String str) {
        this.hwh.fw(str);
    }

    @Override // com.baidu.live.challenge.i
    public void aI(long j) {
        this.hwh.aI(j);
    }

    @Override // com.baidu.live.challenge.i
    public void aJ(long j) {
        this.hwh.aJ(j);
    }

    @Override // com.baidu.live.challenge.i
    public void aK(long j) {
        this.hwh.aK(j);
    }

    @Override // com.baidu.live.challenge.i
    public void aL(long j) {
        this.hwh.aL(j);
    }

    @Override // com.baidu.live.challenge.i
    public void AG() {
        this.hwh.AG();
    }

    @Override // com.baidu.live.challenge.i
    public void AH() {
        this.hwh.AH();
    }

    @Override // com.baidu.live.challenge.i
    public void AI() {
        this.hwh.AI();
    }

    @Override // com.baidu.live.challenge.i
    public void AL() {
        this.hwh.AL();
    }

    @Override // com.baidu.live.challenge.i
    public long AM() {
        return this.hwh.AM();
    }

    @Override // com.baidu.live.challenge.i
    public ChallenfeInfoData.ChallengeStatus AJ() {
        return this.hwh.AJ();
    }

    @Override // com.baidu.live.challenge.i
    public boolean AK() {
        return this.hwh.AK();
    }

    @Override // com.baidu.live.challenge.i
    public void bq(boolean z) {
        this.hwh.bq(z);
    }

    private void ccN() {
        if (this.hwg != null) {
            this.hwg.clear();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Au() {
        this.hwv = true;
        if (this.hwh != null) {
            this.hwh.cdt();
        }
        ccN();
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        if (this.hwh != null) {
            this.hwh.onDestroy();
        }
        ccN();
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.m mVar) {
        this.hwi = mVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.InterfaceC0172i interfaceC0172i) {
        this.hwj = interfaceC0172i;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.l lVar) {
        this.hwk = lVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.h hVar) {
        this.hwl = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.g gVar) {
        this.hwm = gVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.k kVar) {
        this.hwn = kVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.e eVar) {
        this.hwo = eVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.a aVar) {
        this.hwp = aVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.b bVar) {
        this.hwq = bVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.n nVar) {
        this.hwr = nVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.d dVar) {
        this.hws = dVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.f fVar) {
        this.hwh.b(fVar);
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.j jVar) {
        this.hwt = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.c cVar) {
        if (cVar != null && !this.hwg.contains(cVar)) {
            this.hwg.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void fu(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.hwh.AG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, bg bgVar, bk bkVar, bk bkVar2) {
        if (!ListUtils.isEmpty(this.hwg)) {
            if (i == 4) {
                if (this.hwu == this.hwh.AM()) {
                    BdLog.e("CHALLENGE_TAG challenge is Over but challenge id same?? ||Net Challenge id=" + this.hwh.AM() + "||Last Challenge id=" + this.hwu);
                    return;
                }
                this.hwu = this.hwh.AM();
            }
            for (i.c cVar : this.hwg) {
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
