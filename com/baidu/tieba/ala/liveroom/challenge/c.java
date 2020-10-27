package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.i;
import com.baidu.live.data.AlaPersonChallengeData;
import com.baidu.live.data.au;
import com.baidu.live.data.ax;
import com.baidu.live.data.bb;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.challenge.b.b;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetChallengeInfoResponseMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements i {
    private i.j gTA;
    private long gTB = 0;
    private boolean gTC = false;
    private b.a gTD = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void Do() {
            if (c.this.gTp != null) {
                c.this.gTp.Do();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void p(int i, String str) {
            if (c.this.gTp != null) {
                c.this.gTp.p(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
            if (c.this.gTq != null) {
                c.this.gTq.a(bVar, list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void m(int i, String str) {
            if (c.this.gTq != null) {
                c.this.gTq.m(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void co(List<com.baidu.live.challenge.d> list) {
            if (c.this.gTr != null) {
                c.this.gTr.y(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aV(int i, String str) {
            if (c.this.gTr != null) {
                c.this.gTr.o(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(com.baidu.live.challenge.a aVar) {
            if (c.this.gTv != null) {
                c.this.gTv.a(aVar.aGj, aVar != null ? aVar.aGk : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aW(int i, String str) {
            if (c.this.gTv != null) {
                c.this.gTv.j(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gTv != null) {
                c.this.gTv.b(z ? 100 : 101, aVar != null ? aVar.aGk : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aX(int i, String str) {
            if (c.this.gTv != null) {
                c.this.gTv.b(102, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void l(int i, List<com.baidu.live.challenge.d> list) {
            if (c.this.gTx != null && i > 0) {
                c.this.gTx.dO(i);
            }
            if (c.this.gTt != null) {
                c.this.gTt.x(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aY(int i, String str) {
            if (c.this.gTt != null) {
                c.this.gTt.k(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void d(boolean z, long j) {
            if (c.this.gTA != null) {
                c.this.gTA.d(z, j);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void aZ(int i, String str) {
            if (c.this.gTA != null) {
                c.this.gTA.d(false, 0L);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gTw != null) {
                c.this.gTw.a(z, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void ba(int i, String str) {
            if (c.this.gTw != null) {
                c.this.gTw.i(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void c(com.baidu.live.challenge.a aVar) {
            if (c.this.gTu != null) {
                c.this.gTu.a(aVar.CV(), aVar != null ? aVar.aGk : null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bb(int i, String str) {
            if (c.this.gTu != null) {
                c.this.gTu.n(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void d(boolean z, com.baidu.live.challenge.a aVar) {
            if (c.this.gTu != null) {
                c.this.gTu.c(z ? 0 : 1, null, aVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void bc(int i, String str) {
            if (c.this.gTu != null) {
                c.this.gTu.c(2, str, null);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void p(boolean z, String str) {
            if (c.this.gTy != null) {
                c.this.gTy.d(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void a(com.baidu.live.challenge.d dVar) {
            if (c.this.gTs != null) {
                c.this.gTs.a(dVar);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void l(int i, String str) {
            if (c.this.gTs != null) {
                c.this.gTs.l(i, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void b(int i, ax axVar, bb bbVar, bb bbVar2) {
            c.this.a(i, axVar, bbVar, bbVar2);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public void q(boolean z, String str) {
            if (c.this.gTz != null) {
                c.this.gTz.c(z, str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.b.a
        public boolean bWQ() {
            return c.this.gTC;
        }
    };
    private List<i.c> gTn;
    private com.baidu.tieba.ala.liveroom.challenge.b.b gTo;
    private i.m gTp;
    private i.InterfaceC0175i gTq;
    private i.l gTr;
    private i.h gTs;
    private i.g gTt;
    private i.k gTu;
    private i.e gTv;
    private i.a gTw;
    private i.b gTx;
    private i.n gTy;
    private i.d gTz;
    private TbPageContext mTbPageContext;

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gTo = new com.baidu.tieba.ala.liveroom.challenge.b.b(tbPageContext, tbPageContext.getUniqueId());
        this.gTo.a(this.gTD);
        this.gTn = new ArrayList();
    }

    @Override // com.baidu.live.challenge.i
    public void e(long j, long j2) {
        this.gTo.e(j, j2);
    }

    @Override // com.baidu.live.challenge.i
    public void setIsHost(boolean z) {
        if (this.gTo != null) {
            this.gTo.setIsHost(z);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Db() {
        this.gTC = false;
    }

    @Override // com.baidu.live.challenge.i
    public void a(au auVar) {
        this.gTC = false;
        if (auVar != null) {
            AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage = new AlaGetChallengeInfoResponseMessage();
            alaGetChallengeInfoResponseMessage.a(auVar.aNp);
            alaGetChallengeInfoResponseMessage.a(auVar.aNq);
            alaGetChallengeInfoResponseMessage.b(auVar.aNr);
            MessageManager.getInstance().dispatchResponsedMessage(alaGetChallengeInfoResponseMessage);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void c(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && !this.gTC) {
            this.gTo.ex(wVar.mLiveInfo.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Dc() {
        if (this.gTo != null) {
            this.gTo.bXz();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Dd() {
        if (this.gTo != null) {
            this.gTo.bXA();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(AlaPersonChallengeData alaPersonChallengeData) {
        if (alaPersonChallengeData.challengeId > 0 && !Dj()) {
            this.gTo.ex(alaPersonChallengeData.challengeId);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void dN(int i) {
        if (this.gTx != null) {
            this.gTx.dO(i);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void Dm() {
        if (this.gTo != null) {
            this.gTo.Dm();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(long j, long j2, long j3, int i, String str) {
        if (this.gTo != null) {
            this.gTo.a(j, j2, j3, i, str);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void De() {
        this.gTo.De();
    }

    @Override // com.baidu.live.challenge.i
    public void gd(String str) {
        this.gTo.HB(str);
    }

    @Override // com.baidu.live.challenge.i
    public void w(int i, int i2) {
        this.gTo.w(i, i2);
    }

    @Override // com.baidu.live.challenge.i
    public void g(int i, int i2, String str) {
        this.gTo.g(i, i2, str);
    }

    @Override // com.baidu.live.challenge.i
    public void ge(String str) {
        this.gTo.ge(str);
    }

    @Override // com.baidu.live.challenge.i
    public void X(long j) {
        this.gTo.X(j);
    }

    @Override // com.baidu.live.challenge.i
    public void Y(long j) {
        this.gTo.Y(j);
    }

    @Override // com.baidu.live.challenge.i
    public void Z(long j) {
        this.gTo.Z(j);
    }

    @Override // com.baidu.live.challenge.i
    public void aa(long j) {
        this.gTo.aa(j);
    }

    @Override // com.baidu.live.challenge.i
    public void Df() {
        this.gTo.Df();
    }

    @Override // com.baidu.live.challenge.i
    public void Dg() {
        this.gTo.Dg();
    }

    @Override // com.baidu.live.challenge.i
    public void Dh() {
        this.gTo.Dh();
    }

    @Override // com.baidu.live.challenge.i
    public void Dk() {
        this.gTo.Dk();
    }

    @Override // com.baidu.live.challenge.i
    public long Dl() {
        return this.gTo.Dl();
    }

    @Override // com.baidu.live.challenge.i
    public ChallenfeInfoData.ChallengeStatus Di() {
        return this.gTo.Di();
    }

    @Override // com.baidu.live.challenge.i
    public boolean Dj() {
        return this.gTo.Dj();
    }

    @Override // com.baidu.live.challenge.i
    public void bk(boolean z) {
        this.gTo.bk(z);
    }

    private void bWP() {
        if (this.gTn != null) {
            this.gTn.clear();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void CT() {
        this.gTC = true;
        if (this.gTo != null) {
            this.gTo.bXv();
        }
        bWP();
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        if (this.gTo != null) {
            this.gTo.onDestroy();
        }
        bWP();
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.m mVar) {
        this.gTp = mVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.InterfaceC0175i interfaceC0175i) {
        this.gTq = interfaceC0175i;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.l lVar) {
        this.gTr = lVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.h hVar) {
        this.gTs = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.g gVar) {
        this.gTt = gVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.k kVar) {
        this.gTu = kVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.e eVar) {
        this.gTv = eVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.a aVar) {
        this.gTw = aVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.b bVar) {
        this.gTx = bVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.n nVar) {
        this.gTy = nVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.d dVar) {
        this.gTz = dVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.f fVar) {
        this.gTo.b(fVar);
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.j jVar) {
        this.gTA = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(i.c cVar) {
        if (cVar != null && !this.gTn.contains(cVar)) {
            this.gTn.add(cVar);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void gc(String str) {
        if ("challenge_direct_new".equals(str)) {
            this.gTo.Df();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ax axVar, bb bbVar, bb bbVar2) {
        if (!ListUtils.isEmpty(this.gTn)) {
            if (i == 4) {
                if (this.gTB == this.gTo.Dl()) {
                    BdLog.e("CHALLENGE_TAG challenge is Over but challenge id same?? ||Net Challenge id=" + this.gTo.Dl() + "||Last Challenge id=" + this.gTB);
                    return;
                }
                this.gTB = this.gTo.Dl();
            }
            for (i.c cVar : this.gTn) {
                if (cVar != null) {
                    switch (i) {
                        case 2:
                            cVar.b(axVar, bbVar, bbVar2);
                            continue;
                        case 3:
                            cVar.c(axVar, bbVar, bbVar2);
                            continue;
                        case 4:
                            cVar.d(axVar, bbVar, bbVar2);
                            continue;
                        case 5:
                            cVar.e(axVar, bbVar, bbVar2);
                            continue;
                    }
                }
            }
        }
    }
}
